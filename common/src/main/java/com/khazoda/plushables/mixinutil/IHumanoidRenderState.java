package com.khazoda.plushables.mixinutil;

import net.minecraft.world.item.ItemStack;

public interface IHumanoidRenderState {
  void plushables$setMainHandItem(ItemStack item);
  void plushables$setOffHandItem(ItemStack item);
  ItemStack plushables$getMainHandItem();
  ItemStack plushables$getOffHandItem();
}
