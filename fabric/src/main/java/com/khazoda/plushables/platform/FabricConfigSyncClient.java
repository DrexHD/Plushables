package com.khazoda.plushables.platform;

import com.khazoda.plushables.PlushablesCommon;
import com.khazoda.plushables.Constants;
import com.khazoda.baseline.FabricConfigSync;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;

public class FabricConfigSyncClient implements ClientModInitializer {
  @Override
  public void onInitializeClient() {
    FabricConfigSync.registerClientboundPayloadType(Constants.CONFIG_SYNC);
    registerServerConfigReceiver();
    registerDisconnectReloadListener();
  }

  private static void registerServerConfigReceiver() {
    ClientPlayNetworking.registerGlobalReceiver(Constants.CONFIG_SYNC.type(), (payload, context) -> PlushablesCommon.CONFIG.applyServerSyncedValues(payload.serverValues()));
  }

  private static void registerDisconnectReloadListener() {
    ClientPlayConnectionEvents.DISCONNECT.register((listener, client) -> PlushablesCommon.CONFIG.clearServerSyncedValuesAndReload());
  }
}
