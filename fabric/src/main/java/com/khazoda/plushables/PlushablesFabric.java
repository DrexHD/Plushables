package com.khazoda.plushables;

import com.khazoda.plushables.registry.MainRegistry;
import com.khazoda.baseline.KhazRegFabric;
import net.fabricmc.api.ModInitializer;

public class PlushablesFabric implements ModInitializer {

  @Override
  public void onInitialize() {
    PlushablesCommon.init();
    KhazRegFabric.init(MainRegistry::init);
  }
}
