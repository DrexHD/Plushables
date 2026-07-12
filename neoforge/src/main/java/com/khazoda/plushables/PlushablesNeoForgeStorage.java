package com.khazoda.plushables;

import com.google.common.collect.MapMaker;
import com.khazoda.plushables.block.BasePlushableBlockEntity;
import com.khazoda.plushables.registry.MainRegistry;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.transfer.ResourceHandler;
import net.neoforged.neoforge.transfer.item.ItemResource;
import net.neoforged.neoforge.transfer.item.ItemStackResourceHandler;
import net.neoforged.neoforge.transfer.transaction.TransactionContext;

import java.util.Map;

public final class PlushablesNeoForgeStorage {
  private static final Map<BasePlushableBlockEntity, ResourceHandler<ItemResource>> HANDLERS = new MapMaker().weakKeys().weakValues().makeMap();

  private PlushablesNeoForgeStorage() {
  }

  public static void registerCapabilities(RegisterCapabilitiesEvent event) {
    event.registerBlockEntity(Capabilities.Item.BLOCK, MainRegistry.PLUSHABLE_BLOCK_ENTITY.get(), (blockEntity, direction) -> handlerFor(blockEntity));
  }

  private static ResourceHandler<ItemResource> handlerFor(BasePlushableBlockEntity blockEntity) {
    return HANDLERS.computeIfAbsent(blockEntity, PlushableItemResourceHandler::new);
  }

  private static final class PlushableItemResourceHandler extends ItemStackResourceHandler {
    private final BasePlushableBlockEntity blockEntity;

    private PlushableItemResourceHandler(BasePlushableBlockEntity blockEntity) {
      this.blockEntity = blockEntity;
    }

    @Override
    protected ItemStack getStack() {
      return this.blockEntity.getTheItem();
    }

    @Override
    protected void setStack(ItemStack stack) {
      this.blockEntity.setTheItemTransactionally(stack.isEmpty() ? ItemStack.EMPTY : stack);
    }

    @Override
    protected boolean isValid(ItemResource resource) {
      return this.blockEntity.canTransferAccept(resource.toStack());
    }

    @Override
    protected int getCapacity(ItemResource resource) {
      return this.blockEntity.getMaxStackSize();
    }

    @Override
    public int extract(int index, ItemResource resource, int amount, TransactionContext transaction) {
      if (!this.blockEntity.canTransferExtract(resource.toStack())) return 0;
      return super.extract(index, resource, amount, transaction);
    }

    @Override
    protected void onRootCommit(ItemStack originalState) {
      this.blockEntity.commitTheItemTransfer();
    }
  }
}
