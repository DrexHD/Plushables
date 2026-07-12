package com.khazoda.plushables;

import com.khazoda.core.reg.KhazRegFabric;
import com.khazoda.plushables.loot.LootTableModificationFabric;
import com.khazoda.plushables.registry.MainRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;

public class PlushablesFabric implements ModInitializer {

  @Override
  public void onInitialize() {
    PlushablesCommon.init();
    KhazRegFabric.init(MainRegistry::init);
    PlushablesFabricStorage.init();
    CreativeModeTabEvents.modifyOutputEvent(MainRegistry.PLUSHABLES_TAB.key()).register(output -> MainRegistry.addMainTabItems(output::accept));
    LootTableModificationFabric.init();
  }
}
