package com.khazoda.plushables;

import com.khazoda.plushables.platform.Services;

public final class PlushablesCommon {
  private PlushablesCommon() {
  }

  public static void init() {
    PlushablesConfig.init();
    if (Services.PLATFORM.isModLoaded(Constants.MOD_ID)) Constants.LOG.info("- Plushables Loaded -");
  }
}
