package com.example.examplemod;

import com.example.examplemod.registry.MainRegistry;

public class ExampleModCommon {
  private static boolean initialized;

  public static void init() {
    if (initialized) return;

    initialized = true;
    MainRegistry.init();
  }
}