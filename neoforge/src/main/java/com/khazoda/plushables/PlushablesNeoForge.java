package com.khazoda.plushables;

import com.khazoda.core.config.KhazConfigSyncNeoForge;
import com.khazoda.core.reg.KhazRegNeoForge;
import com.khazoda.plushables.registry.MainRegistry;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

@Mod(Constants.MOD_ID)
public class PlushablesNeoForge {

  public PlushablesNeoForge(IEventBus eventBus) {
    PlushablesCommon.init();
    KhazConfigSyncNeoForge.registerPayloadHandlers(eventBus, Constants.CONFIG_SYNC);
    KhazRegNeoForge.init(eventBus, MainRegistry::init);
    eventBus.addListener(this::onBuildCreativeModeTabContents);
  }

  private void onBuildCreativeModeTabContents(BuildCreativeModeTabContentsEvent event) {
    if (MainRegistry.PLUSHABLES_TAB.key().equals(event.getTabKey())) {
      MainRegistry.addMainTabItems(event::accept);
    }
  }
}
