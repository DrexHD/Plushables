package com.khazoda.plushables;

import com.khazoda.plushables.registry.MainRegistry;
import com.khazoda.core.KhazRegFabric;
import com.khazoda.plushables.loot.LootTableModificationFabric;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;

public class PlushablesFabric implements ModInitializer {

  @Override
  public void onInitialize() {
    PlushablesCommon.init();
    KhazRegFabric.init(MainRegistry::init);
    CreativeModeTabEvents.modifyOutputEvent(MainRegistry.PLUSHABLES_TAB.key()).register(output -> MainRegistry.addMainTabItems(output::accept));
    LootTableModificationFabric.init();
  }
}
