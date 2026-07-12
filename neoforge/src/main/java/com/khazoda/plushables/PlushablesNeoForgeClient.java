package com.khazoda.plushables;

import com.khazoda.core.keybind.KhazKeybindNeoForge;
import com.khazoda.plushables.client.model.PlushableOrientationModel;
import com.khazoda.plushables.registry.MainRegistry;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.ModelEvent;

import java.util.function.Supplier;

@Mod(value = Constants.MOD_ID, dist = Dist.CLIENT)
public final class PlushablesNeoForgeClient {
  public PlushablesNeoForgeClient(IEventBus eventBus) {
    eventBus.addListener(PlushablesNeoForgeClient::modifyBakingResult);
    PlushablesKeybinds.register();
    KhazKeybindNeoForge.init(eventBus);
  }

  private static void modifyBakingResult(ModelEvent.ModifyBakingResult event) {
    PlushableOrientationModel.wrapPlushableModels(
        event.getBakingResult().blockStateModels(),
        MainRegistry.ALL_PLUSHABLES.stream().map(Supplier::get).toList()
    );
  }
}