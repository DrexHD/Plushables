package com.khazoda.plushables.platform;

import com.khazoda.core.config.KhazConfigSyncFabric;
import com.khazoda.core.keybind.KhazKeybindFabric;
import com.khazoda.plushables.Constants;
import com.khazoda.plushables.PlushablesCommon;
import com.khazoda.plushables.PlushablesKeybinds;
import com.khazoda.plushables.client.model.PlushableOrientationModel;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin;
import net.fabricmc.fabric.api.client.model.loading.v1.ModelModifier;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.renderer.block.dispatch.BlockStateModel;
import net.minecraft.world.level.block.Block;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class PlushablesFabricClient implements ClientModInitializer {
  private static void registerServerConfigReceiver() {
    ClientPlayNetworking.registerGlobalReceiver(Constants.CONFIG_SYNC.type(), (payload, context) -> PlushablesCommon.CONFIG.applyServerSyncedValues(payload.serverValues()));
  }

  private static void registerDisconnectReloadListener() {
    ClientPlayConnectionEvents.DISCONNECT.register((listener, client) -> PlushablesCommon.CONFIG.clearServerSyncedValuesAndReload());
  }

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
    KhazConfigSyncFabric.registerClientboundPayloadType(Constants.CONFIG_SYNC);
    registerServerConfigReceiver();
    registerDisconnectReloadListener();
    PlushablesKeybinds.register();
    KhazKeybindFabric.init();
  }
}
