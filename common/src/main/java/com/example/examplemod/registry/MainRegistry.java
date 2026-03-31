package com.example.examplemod.registry;

import com.example.examplemod.Constants;
import com.example.examplemod.registry.helper.KhazReg;

public final class MainRegistry {
  public static final KhazReg reg = new KhazReg(Constants.MOD_ID);
  private static boolean initialized;

  private MainRegistry() {
  }

  public static void init() {
    if (initialized) return;
    initialized = true;
  }
}