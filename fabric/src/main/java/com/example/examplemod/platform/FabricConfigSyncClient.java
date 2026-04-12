package com.example.examplemod.platform;

import com.example.examplemod.ExampleModCommon;
import com.example.examplemod.config.ServerConfigSyncPayload;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;

public class FabricConfigSyncClient implements ClientModInitializer {
  @Override
  public void onInitializeClient() {
    FabricConfigSync.registerClientboundPayloadType();
    registerServerConfigReceiver();
    registerDisconnectReloadListener();
  }

  private static void registerServerConfigReceiver() {
    ClientPlayNetworking.registerGlobalReceiver(ServerConfigSyncPayload.TYPE, (payload, context) -> ExampleModCommon.CONFIG.applyServerSyncedValues(payload.serverValues()));
  }

  private static void registerDisconnectReloadListener() {
    ClientPlayConnectionEvents.DISCONNECT.register((listener, client) -> ExampleModCommon.CONFIG.clearServerSyncedValuesAndReload());
  }
}
