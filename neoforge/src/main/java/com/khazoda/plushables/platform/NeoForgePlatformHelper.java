package com.khazoda.plushables.platform;

import com.khazoda.core.config.KhazConfig;
import com.khazoda.core.config.KhazConfigSyncNeoForge;
import com.khazoda.plushables.Constants;
import com.khazoda.plushables.block.BasePlushableBlockEntity;
import com.khazoda.plushables.platform.services.IPlatformHelper;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.fml.loading.FMLLoader;
import net.neoforged.fml.loading.FMLPaths;

import java.nio.file.Path;

public class NeoForgePlatformHelper implements IPlatformHelper {

  @Override
  public String getPlatformName() {
    return "NeoForge";
  }

  @Override
  public boolean isModLoaded(String modId) {
    return ModList.get().isLoaded(modId);
  }

  @Override
  public boolean isDevelopmentEnvironment() {
    return !FMLLoader.getCurrent().isProduction();
  }

  @Override
  public Path getConfigDirectory() {
    return FMLPaths.CONFIGDIR.get();
  }

  @Override
  public void registerServerConfigSync(KhazConfig config) {
    KhazConfigSyncNeoForge.registerServerConfigSync(config, Constants.CONFIG_SYNC);
  }

  @Override
  public BlockEntityType<BasePlushableBlockEntity> createPlushableBlockEntityType(Block... validBlocks) {
    return new BlockEntityType<>(BasePlushableBlockEntity::new, validBlocks);
  }

  @Override
  public boolean isClientSide() {
    return FMLEnvironment.getDist().isClient();
  }
}
