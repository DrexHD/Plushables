package com.example.examplemod;

import com.example.examplemod.registry.helper.KhazRegNeoForge;
import com.example.examplemod.platform.NeoForgeConfigSync;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(Constants.MOD_ID)
public class ExampleModNeoForge {

  public ExampleModNeoForge(IEventBus eventBus) {
    ExampleModCommon.init();
    NeoForgeConfigSync.registerPayloadHandlers(eventBus);
    KhazRegNeoForge.init(eventBus);
  }
}
