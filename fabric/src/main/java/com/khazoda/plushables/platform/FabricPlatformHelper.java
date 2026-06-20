package com.khazoda.plushables.platform;

import com.khazoda.core.config.KhazConfig;
import com.khazoda.core.config.KhazConfigSyncFabric;
import com.khazoda.plushables.Constants;
import com.khazoda.plushables.block.BasePlushableBlockEntity;
import com.khazoda.plushables.platform.services.IPlatformHelper;
import net.fabricmc.api.EnvType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.nio.file.Path;
import java.util.Set;

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
  public BlockEntityType<BasePlushableBlockEntity> createPlushableBlockEntityType(Block... validBlocks) {
    return new BlockEntityType<>(BasePlushableBlockEntity::new, Set.of(validBlocks));
  }

  @Override
  public boolean isClientSide() {
    return FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT;
  }
}
