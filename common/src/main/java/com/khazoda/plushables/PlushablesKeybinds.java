package com.khazoda.plushables;

import com.khazoda.core.keybind.KhazClientKeybinds;
import com.khazoda.core.keybind.KhazKeybind;
import com.mojang.blaze3d.platform.InputConstants;

public final class PlushablesKeybinds {
  public static final KhazKeybind SHOW_LORE = KhazKeybind.builder(Constants.ID("show_lore"))
      .defaultKey(InputConstants.KEY_LCONTROL)
      .build();

  private PlushablesKeybinds() {
  }

  public static void register() {
    KhazClientKeybinds.register(SHOW_LORE);
  }
}
