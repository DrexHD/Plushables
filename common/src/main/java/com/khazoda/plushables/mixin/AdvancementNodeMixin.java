package com.khazoda.plushables.mixin;

import com.khazoda.plushables.Constants;
import it.unimi.dsi.fastutil.objects.ReferenceLinkedOpenHashSet;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementNode;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Set;

@Mixin(AdvancementNode.class)
public class AdvancementNodeMixin {
  @Mutable
  @Final
  @Shadow
  private Set<AdvancementNode> children;

  @Inject(method = "<init>", at = @At("RETURN"))
  private void plushables$preserveChildInsertionOrder(AdvancementHolder holder, AdvancementNode parent, CallbackInfo ci) {
    if (!Constants.MOD_ID.equals(holder.id().getNamespace()) || children instanceof ReferenceLinkedOpenHashSet<?>) return;
    // Keep plushables advancement siblings in declaration order so numbering goes bottom to top (instead of random).
    children = new ReferenceLinkedOpenHashSet<>(children);
  }
}
