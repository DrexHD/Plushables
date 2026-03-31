package com.example.examplemod.registry;

import com.example.examplemod.Constants;
import com.example.examplemod.registry.helper.Reginald;

public final class MainRegistry {
  public static final Reginald R = new Reginald(Constants.MOD_ID);

  private MainRegistry() {
  }

  public static void init() {
  }
}