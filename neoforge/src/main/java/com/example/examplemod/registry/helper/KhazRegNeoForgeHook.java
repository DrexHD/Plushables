package com.example.examplemod.registry.helper;

import com.example.examplemod.registry.MainRegistry;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.registries.RegisterEvent;

/**
 * NeoForge entrypoint helper for the {@link KhazReg} registry system.
 */
public final class KhazRegNeoForgeHook {
  private KhazRegNeoForgeHook() {
  }

  /**
   * Call KhazRegNeoForgeHook.init(eventBus) in your NeoForge mod constructor immediately after YourModCommon.init().
   */
  public static void init(IEventBus eventBus) {
    MainRegistry.init();
    eventBus.addListener(KhazRegNeoForgeHook::registerRegistries);
    eventBus.addListener(KhazRegNeoForgeHook::verifyRegistriesRegistered);
  }

  private static void registerRegistries(RegisterEvent event) {
    MainRegistry.reg.registerNeoForge(event.getRegistry());
  }

  private static void verifyRegistriesRegistered(FMLCommonSetupEvent event) {
    MainRegistry.reg.verifyAllStaticRegistrations();
  }
}
