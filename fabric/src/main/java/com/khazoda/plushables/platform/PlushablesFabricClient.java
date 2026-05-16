package com.khazoda.plushables.platform;

import com.khazoda.core.config.KhazConfigSyncFabric;
import com.khazoda.core.keybind.KhazKeybindFabric;
import com.khazoda.plushables.Constants;
import com.khazoda.plushables.PlushablesCommon;
import com.khazoda.plushables.PlushablesKeybinds;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;

public final class PlushablesFabricClient implements ClientModInitializer {
  private static void registerServerConfigReceiver() {
    ClientPlayNetworking.registerGlobalReceiver(Constants.CONFIG_SYNC.type(), (payload, context) -> PlushablesCommon.CONFIG.applyServerSyncedValues(payload.serverValues()));
  }

  private static void registerDisconnectReloadListener() {
    ClientPlayConnectionEvents.DISCONNECT.register((listener, client) -> PlushablesCommon.CONFIG.clearServerSyncedValuesAndReload());
  }

  @Override
  public void onInitializeClient() {
    KhazConfigSyncFabric.registerClientboundPayloadType(Constants.CONFIG_SYNC);
    registerServerConfigReceiver();
    registerDisconnectReloadListener();
    PlushablesKeybinds.register();
    KhazKeybindFabric.init();
  }
}
