package com.example.examplemod.registry.helper;

import com.example.examplemod.registry.MainRegistry;

/**
 * Fabric entrypoint helper for the {@link KhazReg} registry system.
 */
public final class KhazRegFabric {
  private KhazRegFabric() {
  }

  /**
   * Call KhazRegFabric.init() in your Fabric mod constructor's onInitialize() method immediately after YourModCommon.init().
   */
  public static void init() {
    MainRegistry.init();
    MainRegistry.reg.registerAllStatic();
  }
}
