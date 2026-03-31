package com.example.examplemod;

import com.example.examplemod.registry.helper.KhazRegFabric;
import net.fabricmc.api.ModInitializer;

public class ExampleModFabric implements ModInitializer {

  @Override
  public void onInitialize() {
    ExampleModCommon.init();
    KhazRegFabric.init();
  }
}
