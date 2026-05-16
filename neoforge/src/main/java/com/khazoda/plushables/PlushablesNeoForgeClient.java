package com.khazoda.plushables;

import com.khazoda.core.keybind.KhazKeybindNeoForge;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(value = Constants.MOD_ID, dist = Dist.CLIENT)
public final class PlushablesNeoForgeClient {
  public PlushablesNeoForgeClient(IEventBus eventBus) {
    PlushablesKeybinds.register();
    KhazKeybindNeoForge.init(eventBus);
  }
}