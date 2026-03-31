package com.example.examplemod;

import com.example.examplemod.registry.MainRegistry;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.registries.RegisterEvent;

@Mod(Constants.MOD_ID)
public class ExampleModNeoForge {

  public ExampleModNeoForge(IEventBus eventBus) {
    ExampleModCommon.init();
    eventBus.addListener(this::registerRegistries);
    eventBus.addListener(this::verifyRegistriesRegistered);
  }

  private void registerRegistries(RegisterEvent event) {
    MainRegistry.R.registerNeoForge(event.getRegistry());
  }

  private void verifyRegistriesRegistered(FMLCommonSetupEvent event) {
    MainRegistry.R.verifyAllStaticRegistrations();
  }
}