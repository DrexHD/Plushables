package com.khazoda.plushables;

import com.khazoda.core.config.KhazConfig;
import com.khazoda.plushables.platform.Services;

public final class PlushablesConfig {
  public static final KhazConfig.Entry<Boolean> ENABLE_STORAGE_SYSTEM = KhazConfig.bool("enable_storage_system", true, "Allows players to insert and extract items from plushables. Setting this to false won't delete items inside existing plushables.");
  public static final KhazConfig.Entry<Boolean> ENABLE_STORED_TNT_EXPLOSIONS = KhazConfig.bool("enable_stored_tnt_explosions", true, "Allows powered plushables containing TNT to explode.");

  public static final KhazConfig CONFIG = KhazConfig.of(Constants.MOD_NAME, Constants.MOD_ID, Services.PLATFORM.getConfigDirectory(), ENABLE_STORAGE_SYSTEM, ENABLE_STORED_TNT_EXPLOSIONS);

  private PlushablesConfig() {
  }

  public static void init() {
    CONFIG.load();
    Services.PLATFORM.registerServerConfigSync(CONFIG);
  }

  public static boolean storageSystemEnabled() {
    return CONFIG.get(ENABLE_STORAGE_SYSTEM);
  }

  public static boolean storedTntExplosionsEnabled() {
    return storageSystemEnabled() && CONFIG.get(ENABLE_STORED_TNT_EXPLOSIONS);
  }
}
