package com.khazoda.plushables.block;

import com.khazoda.plushables.PlushablesConfig;
import com.khazoda.plushables.registry.MainRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponentGetter;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.ticks.ContainerSingleItem;

import java.util.List;

public class BasePlushableBlockEntity extends BlockEntity implements ContainerSingleItem {
  private ItemStack item = ItemStack.EMPTY;

  public BasePlushableBlockEntity(BlockPos pos, BlockState blockState) {
    super(MainRegistry.PLUSHABLE_BLOCK_ENTITY.get(), pos, blockState);
  }

  @Override
  public ItemStack getTheItem() {
    return this.item;
  }

  @Override
  public void setTheItem(ItemStack itemStack) {
    this.item = itemStack;
    this.setChanged();

    if (this.level != null) {
      this.level.updateNeighbourForOutputSignal(this.worldPosition, this.getBlockState().getBlock());
    }

    if (this.level instanceof ServerLevel serverLevel) {
      BasePlushable.tryExplodeStoredTnt(serverLevel, this.worldPosition);
    }
  }

  @Override
  public ItemStack splitTheItem(int amount) {
    if (this.item.isEmpty()) return ItemStack.EMPTY;

    ItemStack removedItem = this.item.split(amount);
    this.setTheItem(this.item.isEmpty() ? ItemStack.EMPTY : this.item);
    return removedItem;
  }

  @Override
  public boolean stillValid(Player player) {
    return Container.stillValidBlockEntity(this, player);
  }

  @Override
  public int getMaxStackSize() {
    return 1;
  }

  @Override
  public boolean canPlaceItem(int slot, ItemStack itemStack) {
    return PlushablesConfig.storageSystemEnabled()
        && slot == 0
        && this.item.isEmpty()
        && BasePlushable.canStoreInPlushable(itemStack);
  }

  @Override
  public boolean canTakeItem(Container into, int slot, ItemStack itemStack) {
    return PlushablesConfig.storageSystemEnabled();
  }

  @Override
  public void preRemoveSideEffects(BlockPos pos, BlockState state) {
    // The stored item is preserved through the dropped plushable's CONTAINER component.
    // This gets overridden so that default item drop behaviour doesn't happen. hi :)
  }

  @Override
  protected void saveAdditional(ValueOutput output) {
    super.saveAdditional(output);

    if (!this.item.isEmpty()) {
      output.store("item", ItemStack.OPTIONAL_CODEC, this.item);
    }
  }

  @Override
  protected void loadAdditional(ValueInput input) {
    super.loadAdditional(input);
    this.item = input.read("item", ItemStack.OPTIONAL_CODEC).orElse(ItemStack.EMPTY);
  }

  @Override
  protected void collectImplicitComponents(DataComponentMap.Builder componentMapBuilder) {
    super.collectImplicitComponents(componentMapBuilder);
    if (!this.item.isEmpty()) {
      componentMapBuilder.set(DataComponents.CONTAINER, ItemContainerContents.fromItems(List.of(this.item.copy())));
    }
  }

  @Override
  protected void applyImplicitComponents(DataComponentGetter componentInput) {
    super.applyImplicitComponents(componentInput);
    ItemStack storedItem = componentInput.getOrDefault(DataComponents.CONTAINER, ItemContainerContents.EMPTY).copyOne();
    if (this.item.isEmpty() && !storedItem.isEmpty()) {
      this.setTheItem(storedItem);
    }
  }

  @Override
  public void removeComponentsFromTag(ValueOutput output) {
    output.discard("item");
  }
}
