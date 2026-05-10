package com.khazoda.plushables.platform;

import com.khazoda.plushables.Constants;
import com.khazoda.plushables.platform.services.IPlatformHelper;
import com.khazoda.core.KhazConfigSyncFabric;
import com.khazoda.core.KhazConfig;
import net.fabricmc.api.EnvType;
import net.fabricmc.loader.api.FabricLoader;

import java.nio.file.Path;

public class FabricPlatformHelper implements IPlatformHelper {
  @Override
  public String getPlatformName() {
    return "Fabric";
  }

  @Override
  public boolean isModLoaded(String modId) {
    return FabricLoader.getInstance().isModLoaded(modId);
  }

  @Override
  public boolean isDevelopmentEnvironment() {
    return FabricLoader.getInstance().isDevelopmentEnvironment();
  }

  @Override
  public Path getConfigDirectory() {
    return FabricLoader.getInstance().getConfigDir();
  }

  @Override
  public void registerServerConfigSync(KhazConfig config) {
    KhazConfigSyncFabric.registerServerConfigSync(config, Constants.CONFIG_SYNC);
  }
  @Override
  public boolean isClientSide() {
    return FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT;
  }
}
