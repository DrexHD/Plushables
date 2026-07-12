package com.khazoda.plushables.platform;

import com.khazoda.core.keybind.KhazKeybindFabric;
import com.khazoda.plushables.PlushablesKeybinds;
import com.khazoda.plushables.client.model.PlushableOrientationModel;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin;
import net.fabricmc.fabric.api.client.model.loading.v1.ModelModifier;
import net.minecraft.client.renderer.block.dispatch.BlockStateModel;
import net.minecraft.world.level.block.Block;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class PlushablesFabricClient implements ClientModInitializer {
  private static void registerPlushableModelOrientation() {
    ModelLoadingPlugin.register(context -> {
      Map<Block, Map<Integer, BlockStateModel>> cache = new ConcurrentHashMap<>();
      context.modifyBlockModelAfterBake().register(ModelModifier.WRAP_PHASE, (model, bakeContext) ->
          PlushableOrientationModel.wrapPlushableModel(bakeContext.state(), model, cache));
    });
  }

  @Override
  public void onInitializeClient() {
    registerPlushableModelOrientation();
    PlushablesKeybinds.register();
    KhazKeybindFabric.init();
  }
}