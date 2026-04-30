package com.khazoda.plushables;

import com.khazoda.plushables.registry.MainRegistry;
import com.khazoda.baseline.KhazRegNeoForge;
import com.khazoda.baseline.NeoForgeConfigSync;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(Constants.MOD_ID)
public class PlushablesNeoForge {

  public PlushablesNeoForge(IEventBus eventBus) {
    PlushablesCommon.init();
    NeoForgeConfigSync.registerPayloadHandlers(eventBus, Constants.CONFIG_SYNC);
    KhazRegNeoForge.init(eventBus, MainRegistry::init);
  }
}
