package com.khazoda.plushables.datagen.provider;

import com.khazoda.plushables.registry.MainRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class PlushablesBlockLootTableProvider extends FabricBlockLootSubProvider {
  public PlushablesBlockLootTableProvider(FabricPackOutput packOutput,
                                          CompletableFuture<HolderLookup.Provider> registryLookup) {
    super(packOutput, registryLookup);
  }

  @Override
  public void generate() {
    for (var plushable : MainRegistry.ALL_PLUSHABLES) {
      dropSelf(plushable.get());
    }
  }
}
