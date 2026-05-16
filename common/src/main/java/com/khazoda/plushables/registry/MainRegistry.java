package com.khazoda.plushables.registry;


import com.khazoda.core.reg.KhazReg;
import com.khazoda.core.reg.KhazReg.BlockEntry;
import com.khazoda.core.reg.KhazReg.Entry;
import com.khazoda.plushables.Constants;
import com.khazoda.plushables.block.BasePlushable;
import com.khazoda.plushables.block.plushable.*;
import com.khazoda.plushables.item.PlushableBlockItem;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public final class MainRegistry {
  public static final KhazReg reg = new KhazReg(Constants.MOD_ID);
  private static boolean initialized;
  private static final List<Supplier<? extends ItemLike>> TAB = new ArrayList<>();

  private static final List<BlockEntry<BasePlushable, PlushableBlockItem>> ALL_PLUSHABLES_MUTABLE = new ArrayList<>();
  public static final List<BlockEntry<BasePlushable, PlushableBlockItem>> ALL_PLUSHABLES = Collections.unmodifiableList(ALL_PLUSHABLES_MUTABLE);

  /**
   * ==========[ Items ]==========
   */
  public static final Entry<Item> HEART_OF_GOLD_ITEM = reg.item("heart_of_gold").addToTab(TAB);

  /**
   * ==========[ Blocks + BlockItems ]==========
   */

  public static final BlockEntry<BasePlushable, PlushableBlockItem> PLUSHABLE_PENGUIN_BLOCK = register("plushable_penguin", PlushablePenguinBlock::new);
  public static final BlockEntry<BasePlushable, PlushableBlockItem> PLUSHABLE_FROGLIN_BLOCK = register("plushable_froglin", PlushableFroglinBlock::new);
  public static final BlockEntry<BasePlushable, PlushableBlockItem> PLUSHABLE_FOX_BLOCK = register("plushable_fox", PlushableFoxBlock::new);
  public static final BlockEntry<BasePlushable, PlushableBlockItem> PLUSHABLE_CLUCKY_BLOCK = register("plushable_clucky", PlushableCluckyBlock::new);
  public static final BlockEntry<BasePlushable, PlushableBlockItem> PLUSHABLE_PIG_BLOCK = register("plushable_pig", PlushablePigBlock::new);
  public static final BlockEntry<BasePlushable, PlushableBlockItem> PLUSHABLE_TRUFFLES_BLOCK = register("plushable_truffles", PlushableTrufflesBlock::new);
  public static final BlockEntry<BasePlushable, PlushableBlockItem> PLUSHABLE_DJUNGELSKOG_BLOCK = register("plushable_djungelskog", PlushableDjungelskogBlock::new);
  public static final BlockEntry<BasePlushable, PlushableBlockItem> PLUSHABLE_RATTIAM_BLOCK = register("plushable_rattiam", PlushableRattiamBlock::new);
  public static final BlockEntry<BasePlushable, PlushableBlockItem> PLUSHABLE_TRICERATOPS_BLOCK = register("plushable_triceratops", PlushableTriceratopsBlock::new);
  public static final BlockEntry<BasePlushable, PlushableBlockItem> PLUSHABLE_UNICORN_BLOCK = register("plushable_unicorn", PlushableUnicornBlock::new);
  public static final BlockEntry<BasePlushable, PlushableBlockItem> PLUSHABLE_WHELPLING_BLOCK = register("plushable_whelpling", PlushableWhelplingBlock::new);
  public static final BlockEntry<BasePlushable, PlushableBlockItem> PLUSHABLE_RAPTOR_BLOCK = register("plushable_raptor", PlushableRaptorBlock::new);
  public static final BlockEntry<BasePlushable, PlushableBlockItem> PLUSHABLE_RUPERT_BLOCK = register("plushable_rupert", PlushableRupertBlock::new);
  public static final BlockEntry<BasePlushable, PlushableBlockItem> PLUSHABLE_DRAGON_BLOCK = register("plushable_dragon", PlushableDragonBlock::new);
  public static final BlockEntry<BasePlushable, PlushableBlockItem> PLUSHABLE_WIZARD_BLOCK = register("plushable_wizard", PlushableWizardBlock::new);
  public static final BlockEntry<BasePlushable, PlushableBlockItem> PLUSHABLE_BEAUX_BLOCK = register("plushable_beaux", PlushableBeauxBlock::new);
  public static final BlockEntry<BasePlushable, PlushableBlockItem> PLUSHABLE_GOBLIN_BLOCK = register("plushable_goblin", PlushableGoblinBlock::new);
  public static final BlockEntry<BasePlushable, PlushableBlockItem> PLUSHABLE_BIG_TATER_BLOCK = register("plushable_big_tater", PlushableBigTaterBlock::new);
  public static final BlockEntry<BasePlushable, PlushableBlockItem> PLUSHABLE_BIG_IRRITATER_BLOCK = register("plushable_big_irritater", PlushableBigIrritaterBlock::new);
  public static final BlockEntry<BasePlushable, PlushableBlockItem> PLUSHABLE_OTTER_BLOCK = register("plushable_otter", PlushableOtterBlock::new);
  public static final BlockEntry<BasePlushable, PlushableBlockItem> PLUSHABLE_SHRUMP_BLOCK = register("plushable_shrump", PlushableShrumpBlock::new);
  public static final BlockEntry<BasePlushable, PlushableBlockItem> PLUSHABLE_OCTOPLUSHABLE_BLOCK = register("plushable_octoplushable", PlushableOctoplushableBlock::new);
  public static final BlockEntry<BasePlushable, PlushableBlockItem> PLUSHABLE_SNAIL_BLOCK = register("plushable_snail", PlushableSnailBlock::new);
  public static final BlockEntry<BasePlushable, PlushableBlockItem> PLUSHABLE_WHALE_BLOCK = register("plushable_whale", PlushableWhaleBlock::new);
  public static final BlockEntry<BasePlushable, PlushableBlockItem> PLUSHABLE_ORANGUTAN_BLOCK = register("plushable_orangutan", PlushableOrangutanBlock::new);
  public static final BlockEntry<BasePlushable, PlushableBlockItem> PLUSHABLE_GOLDFISH_BLOCK = register("plushable_goldfish", PlushableGoldfishBlock::new);
  public static final BlockEntry<BasePlushable, PlushableBlockItem> PLUSHABLE_TRATER_BLOCK = register("plushable_trater", PlushableTraterBlock::new);
  public static final BlockEntry<BasePlushable, PlushableBlockItem> PLUSHABLE_CONDUCTOR_BLOCK = register("plushable_conductor", PlushableConductorBlock::new);
  public static final BlockEntry<BasePlushable, PlushableBlockItem> PLUSHABLE_ANIMATRONIC_BLOCK = register("plushable_animatronic", PlushableAnimatronicBlock::new);
  public static final BlockEntry<BasePlushable, PlushableBlockItem> PLUSHABLE_MOOBLOOM_BLOCK = register("plushable_moobloom", PlushableMoobloomBlock::new);
  public static final BlockEntry<BasePlushable, PlushableBlockItem> PLUSHABLE_FROGE_BLOCK = register("plushable_froge", PlushableFrogeBlock::new);
  public static final BlockEntry<BasePlushable, PlushableBlockItem> PLUSHABLE_OWL_BLOCK = register("plushable_owl", PlushableOwlBlock::new);
  public static final BlockEntry<BasePlushable, PlushableBlockItem> PLUSHABLE_HAMSTER_BLOCK = register("plushable_hamster", PlushableHamsterBlock::new);
  public static final BlockEntry<BasePlushable, PlushableBlockItem> PLUSHABLE_DORMOUSE_BLOCK = register("plushable_dormouse", PlushableDormouseBlock::new);
  public static final BlockEntry<BasePlushable, PlushableBlockItem> PLUSHABLE_SEA_BUNNY_BLOCK = register("plushable_sea_bunny", PlushableSeaBunnyBlock::new);
  public static final BlockEntry<BasePlushable, PlushableBlockItem> PLUSHABLE_STATUETTE_BLOCK = register("plushable_statuette", PlushableStatuetteBlock::new);
  public static final BlockEntry<BasePlushable, PlushableBlockItem> PLUSHABLE_MAMMOTH_BLOCK = register("plushable_mammoth", PlushableMammothBlock::new);
  public static final BlockEntry<BasePlushable, PlushableBlockItem> PLUSHABLE_TIGER_BLOCK = register("plushable_tiger", PlushableTigerBlock::new);
  public static final BlockEntry<BasePlushable, PlushableBlockItem> PLUSHABLE_WALRUS_BLOCK = register("plushable_walrus", PlushableWalrusBlock::new);
  public static final BlockEntry<BasePlushable, PlushableBlockItem> PLUSHABLE_BLAHAJ_BLOCK = register("plushable_blahaj", PlushableBlahajBlock::new);
  public static final BlockEntry<BasePlushable, PlushableBlockItem> PLUSHABLE_WISP_BLOCK = register("plushable_wisp", PlushableWispBlock::new);
  public static final BlockEntry<BasePlushable, PlushableBlockItem> PLUSHABLE_COOPER_BLOCK = register("plushable_cooper", PlushableCooperBlock::new);
  public static final BlockEntry<BasePlushable, PlushableBlockItem> PLUSHABLE_ZIGGY_BLOCK = register("plushable_ziggy", PlushableZiggyBlock::new);
  public static final BlockEntry<BasePlushable, PlushableBlockItem> PLUSHABLE_POTSY_BLOCK = register("plushable_potsy", PlushablePotsyBlock::new);
  public static final BlockEntry<BasePlushable, PlushableBlockItem> PLUSHABLE_SNOWIE_BLOCK = register("plushable_snowie", PlushableSnowieBlock::new);
  public static final BlockEntry<BasePlushable, PlushableBlockItem> PLUSHABLE_RIBBIT_BLOCK = register("plushable_ribbit", PlushableRibbitBlock::new);
  public static final BlockEntry<BasePlushable, PlushableBlockItem> PLUSHABLE_CREAKY_BLOCK = register("plushable_creaky", PlushableCreakyBlock::new);
  public static final BlockEntry<BasePlushable, PlushableBlockItem> PLUSHABLE_KWEEBEC_BLOCK = register("plushable_kweebec", PlushableKweebecBlock::new);
  public static final BlockEntry<BasePlushable, PlushableBlockItem> PLUSHABLE_STONELING_BLOCK = register("plushable_stoneling", PlushableStonelingBlock::new);

  /**
   * ==========[ Sounds ]=========
   */
  public static final Entry<SoundEvent> PLUSHABLE_GENERIC = reg.sound("plushable_generic");
  public static final Entry<SoundEvent> PLUSHABLE_CLUCKY = reg.sound("plushable_clucky");
  public static final Entry<SoundEvent> PLUSHABLE_DRAGON = reg.sound("plushable_dragon");
  public static final Entry<SoundEvent> PLUSHABLE_GOLDFISH = reg.sound("plushable_goldfish");
  public static final Entry<SoundEvent> PLUSHABLE_OWL = reg.sound("plushable_owl");
  public static final Entry<SoundEvent> PLUSHABLE_RUPERT = reg.sound("plushable_rupert");
  public static final Entry<SoundEvent> PLUSHABLE_WIZARD = reg.sound("plushable_wizard");
  public static final Entry<SoundEvent> PLUSHABLE_KWEEBEC = reg.sound("plushable_kweebec");
  public static final Entry<SoundEvent> PLUSHABLE_STONELING = reg.sound("plushable_stoneling");

  /**
   * ==========[ Tabs ]==========
   */
  public static final Entry<CreativeModeTab> PLUSHABLES_TAB = reg.tab("main", () -> new ItemStack(PLUSHABLE_PENGUIN_BLOCK.get()));

  private MainRegistry() {
  }

  public static KhazReg init() {
    if (initialized) return reg;
    initialized = true;
    reg.freeze();
    return reg;
  }

  public static void addMainTabItems(Consumer<ItemLike> output) {
    for (Supplier<? extends ItemLike> item : TAB) {
      output.accept(item.get());
    }
  }

  private static BlockEntry<BasePlushable, PlushableBlockItem> register(String name, Function<BlockBehaviour.Properties, BasePlushable> factory) {
    BlockEntry<BasePlushable, PlushableBlockItem> entry = reg.blockWithItem(name, (key, ignored) ->
        factory.apply(BasePlushable.defaultSettings.setId(key)), PlushableBlockItem::new).addToTab(TAB);
    ALL_PLUSHABLES_MUTABLE.add(entry);
    return entry;
  }
}
