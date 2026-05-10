package com.khazoda.plushables;

import com.khazoda.plushables.platform.Services;
import com.khazoda.core.KhazConfig;

public final class PlushablesCommon {
  public static final KhazConfig CONFIG = KhazConfig.of(Constants.MOD_NAME, Constants.MOD_ID, Services.PLATFORM.getConfigDirectory());

  private PlushablesCommon() {
  }

  public static void init() {
    CONFIG.load();
    Services.PLATFORM.registerServerConfigSync(CONFIG);
    if (Services.PLATFORM.isModLoaded(Constants.MOD_ID)) Constants.LOG.info("- Plushables Loaded -");
  }
}
