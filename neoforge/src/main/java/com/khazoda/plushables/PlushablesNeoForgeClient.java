package com.khazoda.plushables;

import com.khazoda.core.keybind.KhazKeybindNeoForge;
import com.khazoda.plushables.client.model.PlushableOrientationModel;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.client.event.ModelEvent;
import net.neoforged.fml.common.Mod;

@Mod(value = Constants.MOD_ID, dist = Dist.CLIENT)
public final class PlushablesNeoForgeClient {
  public PlushablesNeoForgeClient(IEventBus eventBus) {
    eventBus.addListener(PlushablesNeoForgeClient::modifyBakingResult);
    PlushablesKeybinds.register();
    KhazKeybindNeoForge.init(eventBus);
  }

  private static void modifyBakingResult(ModelEvent.ModifyBakingResult event) {
    var models = event.getBakingResult().blockStateModels();
    var wrappedModels = PlushableOrientationModel.wrapPlushableModels(models);
    if (wrappedModels != models) {
      models.clear();
      models.putAll(wrappedModels);
    }
  }
}