package com.example.examplemod;

import com.example.examplemod.config.KhazConfig;
import com.example.examplemod.platform.Services;

public final class ExampleModCommon {
  public static final KhazConfig CONFIG = KhazConfig.of(Constants.MOD_ID);

  private ExampleModCommon() {
  }

  public static void init() {
    CONFIG.load();
    Services.PLATFORM.registerServerConfigSync(CONFIG);
  }
}
