package com.khazoda.plushables.datagen.provider;

import com.khazoda.plushables.registry.MainRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class PlushablesRecipeProvider extends FabricRecipeProvider {

  public PlushablesRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
    super(output, registriesFuture);
  }

  @Override
  protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
    return new RecipeProvider(provider, recipeOutput) {
      @Override
      public void buildRecipes() {
        /* ==========[ Heart of Gold ]========== */
        shaped(RecipeCategory.MISC, MainRegistry.HEART_OF_GOLD_ITEM.get())
            .pattern("X#X")
            .pattern("#^#")
            .pattern(" # ")
            .define('#', Items.GOLD_NUGGET)
            .define('^', Items.HONEY_BOTTLE)
            .define('X', ItemTags.FLOWERS)
            .unlockedBy("has_gold_nugget", has(Items.GOLD_NUGGET))
            .unlockedBy("has_flowers", has(ItemTags.FLOWERS))
            .unlockedBy("has_honey_bottle", has(Items.HONEY_BOTTLE))
            .save(output);

        /* ==========[ Plushables ]========== */
        createPlushableRecipe(output, MainRegistry.PLUSHABLE_ANIMATRONIC_BLOCK.item().get(), Items.REDSTONE, Items.BLUE_WOOL);
        createPlushableRecipe(output, MainRegistry.PLUSHABLE_WISP_BLOCK.item().get(), Items.ECHO_SHARD, Items.LIGHT_BLUE_WOOL);
        createPlushableRecipe(output, MainRegistry.PLUSHABLE_WIZARD_BLOCK.item().get(), Items.GOLD_INGOT, Items.PURPLE_WOOL);
        createPlushableRecipe(output, MainRegistry.PLUSHABLE_ZIGGY_BLOCK.item().get(), ItemTags.FISHES, Items.WHITE_WOOL);
        createPlushableRecipe(output, MainRegistry.PLUSHABLE_WHALE_BLOCK.item().get(), Items.KELP, Items.BLUE_WOOL);
        createPlushableRecipe(output, MainRegistry.PLUSHABLE_WHELPLING_BLOCK.item().get(), Items.BLAZE_POWDER, Items.RED_WOOL);
        createPlushableRecipe(output, MainRegistry.PLUSHABLE_TRUFFLES_BLOCK.item().get(), Items.LILY_OF_THE_VALLEY, Items.PINK_WOOL);
        createPlushableRecipe(output, MainRegistry.PLUSHABLE_UNICORN_BLOCK.item().get(), Items.CHERRY_LEAVES, Items.WHITE_WOOL);
        createPlushableRecipe(output, MainRegistry.PLUSHABLE_WALRUS_BLOCK.item().get(), Items.SEA_PICKLE, Items.BROWN_WOOL);
        createPlushableRecipe(output, MainRegistry.PLUSHABLE_TIGER_BLOCK.item().get(), Items.PORKCHOP, Items.ORANGE_WOOL);
        createPlushableRecipe(output, MainRegistry.PLUSHABLE_TRATER_BLOCK.item().get(), Items.POISONOUS_POTATO, Items.CYAN_WOOL);
        createPlushableRecipe(output, MainRegistry.PLUSHABLE_TRICERATOPS_BLOCK.item().get(), Items.FERN, Items.GREEN_WOOL);
        createPlushableRecipe(output, MainRegistry.PLUSHABLE_SHRUMP_BLOCK.item().get(), Items.RED_MUSHROOM, Items.WHITE_WOOL);
        createPlushableRecipe(output, MainRegistry.PLUSHABLE_SNAIL_BLOCK.item().get(), Items.SLIME_BALL, Items.CYAN_WOOL);
        createPlushableRecipe(output, MainRegistry.PLUSHABLE_STATUETTE_BLOCK.item().get(), Items.TERRACOTTA, Items.BROWN_WOOL);
        createPlushableRecipe(output, MainRegistry.PLUSHABLE_RUPERT_BLOCK.item().get(), ItemTags.FISHES, Items.BLACK_WOOL);
        createPlushableRecipe(output, MainRegistry.PLUSHABLE_SEA_BUNNY_BLOCK.item().get(), Items.SEAGRASS, Items.WHITE_WOOL);
        createPlushableRecipe(output, MainRegistry.PLUSHABLE_POTSY_BLOCK.item().get(), Items.CAULDRON, Items.BLACK_WOOL);
        createPlushableRecipe(output, MainRegistry.PLUSHABLE_RAPTOR_BLOCK.item().get(), Items.FLINT, Items.BLUE_WOOL);
        createPlushableRecipe(output, MainRegistry.PLUSHABLE_RATTIAM_BLOCK.item().get(), Items.WHEAT, Items.LIGHT_GRAY_WOOL);
        createPlushableRecipe(output, MainRegistry.PLUSHABLE_OWL_BLOCK.item().get(), Items.GLOW_BERRIES, Items.BROWN_WOOL);
        createPlushableRecipe(output, MainRegistry.PLUSHABLE_PENGUIN_BLOCK.item().get(), Items.SNOWBALL, Items.GRAY_WOOL);
        createPlushableRecipe(output, MainRegistry.PLUSHABLE_PIG_BLOCK.item().get(), Items.MUD, Items.PINK_WOOL);
        createPlushableRecipe(output, MainRegistry.PLUSHABLE_ORANGUTAN_BLOCK.item().get(), Items.VINE, Items.ORANGE_WOOL);
        createPlushableRecipe(output, MainRegistry.PLUSHABLE_OTTER_BLOCK.item().get(), ItemTags.FISHES, Items.BROWN_WOOL);
        createPlushableRecipe(output, MainRegistry.PLUSHABLE_MOOBLOOM_BLOCK.item().get(), Items.SUNFLOWER, Items.YELLOW_WOOL);
        createPlushableRecipe(output, MainRegistry.PLUSHABLE_OCTOPLUSHABLE_BLOCK.item().get(), Items.INK_SAC, Items.LIGHT_BLUE_WOOL);
        createPlushableRecipe(output, MainRegistry.PLUSHABLE_MAMMOTH_BLOCK.item().get(), Items.POINTED_DRIPSTONE, Items.BROWN_WOOL);
        createPlushableRecipe(output, MainRegistry.PLUSHABLE_GOBLIN_BLOCK.item().get(), Items.RED_MUSHROOM, Items.LIME_WOOL);
        createPlushableRecipe(output, MainRegistry.PLUSHABLE_GOLDFISH_BLOCK.item().get(), Items.GOLD_INGOT, Items.ORANGE_WOOL);
        createPlushableRecipe(output, MainRegistry.PLUSHABLE_HAMSTER_BLOCK.item().get(), Items.CARROT, Items.ORANGE_WOOL);
        createPlushableRecipe(output, MainRegistry.PLUSHABLE_FOX_BLOCK.item().get(), Items.PUMPKIN, Items.ORANGE_WOOL);
        createPlushableRecipe(output, MainRegistry.PLUSHABLE_FROGE_BLOCK.item().get(), Items.LILY_PAD, Items.YELLOW_WOOL);
        createPlushableRecipe(output, MainRegistry.PLUSHABLE_FROGLIN_BLOCK.item().get(), Items.LILY_PAD, Items.GREEN_WOOL);
        createPlushableRecipe(output, MainRegistry.PLUSHABLE_DJUNGELSKOG_BLOCK.item().get(), Items.HONEYCOMB, Items.BROWN_WOOL);
        createPlushableRecipe(output, MainRegistry.PLUSHABLE_DORMOUSE_BLOCK.item().get(), Items.OAK_LEAVES, Items.BROWN_WOOL);
        createPlushableRecipe(output, MainRegistry.PLUSHABLE_DRAGON_BLOCK.item().get(), Items.BLAZE_ROD, Items.WHITE_WOOL);
        createPlushableRecipe(output, MainRegistry.PLUSHABLE_CONDUCTOR_BLOCK.item().get(), Items.RAIL, Items.GRAY_WOOL);
        createPlushableRecipe(output, MainRegistry.PLUSHABLE_COOPER_BLOCK.item().get(), Items.BONE, Items.BLACK_WOOL);
        createPlushableRecipe(output, MainRegistry.PLUSHABLE_CLUCKY_BLOCK.item().get(), Items.EGG, Items.WHITE_WOOL);
        createPlushableRecipe(output, MainRegistry.PLUSHABLE_BIG_IRRITATER_BLOCK.item().get(), Items.POTATO, Items.RED_WOOL);
        createPlushableRecipe(output, MainRegistry.PLUSHABLE_BIG_TATER_BLOCK.item().get(), Items.POTATO, Items.PINK_WOOL);
        createPlushableRecipe(output, MainRegistry.PLUSHABLE_BLAHAJ_BLOCK.item().get(), Items.PINK_PETALS, Items.LIGHT_BLUE_WOOL);
        createPlushableRecipe(output, MainRegistry.PLUSHABLE_BEAUX_BLOCK.item().get(), Items.BONE, Items.GRAY_WOOL);
        createPlushableRecipe(output, MainRegistry.PLUSHABLE_SNOWIE_BLOCK.item().get(), Items.SNOWBALL, Items.WHITE_WOOL);
        createPlushableRecipe(output, MainRegistry.PLUSHABLE_RIBBIT_BLOCK.item().get(), Items.FISHING_ROD, Items.LIME_WOOL);
        createPlushableRecipe(output, MainRegistry.PLUSHABLE_CREAKY_BLOCK.item().get(), Items.CHERRY_SAPLING, Items.BLACK_WOOL);
        createPlushableRecipe(output, MainRegistry.PLUSHABLE_KWEEBEC_BLOCK.item().get(), Items.LEAF_LITTER, Items.BROWN_WOOL);
        createPlushableRecipe(output, MainRegistry.PLUSHABLE_STONELING_BLOCK.item().get(), Items.STONE, Items.GRAY_WOOL);

      }

      private void createPlushableRecipe(RecipeOutput output, Item result, TagKey<Item> decorativeTag, Item wool) {
        shapeless(RecipeCategory.MISC, result)
            .requires(decorativeTag)
            .requires(wool)
            .requires(MainRegistry.HEART_OF_GOLD_ITEM.get())
            .unlockedBy("has_heart_of_gold", has(MainRegistry.HEART_OF_GOLD_ITEM.get()))
            .save(output);
      }

      private void createPlushableRecipe(RecipeOutput output, Item result, Item decorative, Item wool) {
        shapeless(RecipeCategory.MISC, result)
            .requires(decorative)
            .requires(wool)
            .requires(MainRegistry.HEART_OF_GOLD_ITEM.get())
            .unlockedBy("has_heart_of_gold", has(MainRegistry.HEART_OF_GOLD_ITEM.get()))
            .save(output);
      }
    };
  }

  @Override
  public String getName() {
    return "";
  }
}

