package com.khazoda.plushables.platform.services;

import com.khazoda.core.config.KhazConfig;
import com.khazoda.plushables.block.BasePlushableBlockEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.nio.file.Path;

public interface IPlatformHelper {

  /**
   * Gets the name of the current platform
   *
   * @return The name of the current platform.
   */
  String getPlatformName();

  /**
   * Checks if a mod with the given id is loaded.
   *
   * @param modId The mod to check if it is loaded.
   * @return True if the mod is loaded, false otherwise.
   */
  boolean isModLoaded(String modId);

  /**
   * Check if the game is currently in a development environment.
   *
   * @return True if in a development environment, false otherwise.
   */
  boolean isDevelopmentEnvironment();

  /**
   * Gets the config directory for the current platform.
   *
   * @return The config directory path.
   */
  Path getConfigDirectory();

  void registerServerConfigSync(KhazConfig config);

  BlockEntityType<BasePlushableBlockEntity> createPlushableBlockEntityType(Block... validBlocks);

  /**
   * Gets the name of the environment type as a string.
   *
   * @return The name of the environment type.
   */
  default String getEnvironmentName() {
    return isDevelopmentEnvironment() ? "development" : "production";
  }

  /**
   * @return true if the code is running on the client, false otherwise
   */
  boolean isClientSide();
}
