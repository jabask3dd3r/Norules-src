package net.minecraft.potion;

import java.util.*;
import net.minecraft.item.crafting.*;
import com.google.common.base.*;
import com.google.common.collect.*;
import net.minecraft.init.*;
import net.minecraft.item.*;

public class PotionHelper
{
    private static final /* synthetic */ List<Ingredient> POTION_ITEMS;
    private static final /* synthetic */ List<MixPredicate<PotionType>> POTION_TYPE_CONVERSIONS;
    private static final /* synthetic */ List<MixPredicate<Item>> POTION_ITEM_CONVERSIONS;
    private static final /* synthetic */ Predicate<ItemStack> IS_POTION_ITEM;
    
    protected static boolean isTypeConversionReagent(final ItemStack llllllllllllllIIIIIlIllIIIIIllIl) {
        for (int llllllllllllllIIIIIlIllIIIIIllII = 0, llllllllllllllIIIIIlIllIIIIIlIll = PotionHelper.POTION_TYPE_CONVERSIONS.size(); llllllllllllllIIIIIlIllIIIIIllII < llllllllllllllIIIIIlIllIIIIIlIll; ++llllllllllllllIIIIIlIllIIIIIllII) {
            if (PotionHelper.POTION_TYPE_CONVERSIONS.get(llllllllllllllIIIIIlIllIIIIIllII).reagent.apply(llllllllllllllIIIIIlIllIIIIIllIl)) {
                return true;
            }
        }
        return false;
    }
    
    private static void func_193354_a(final ItemPotion llllllllllllllIIIIIlIlIllIlIllIl) {
        PotionHelper.POTION_ITEMS.add(Ingredient.func_193368_a(llllllllllllllIIIIIlIlIllIlIllIl));
    }
    
    private static void func_193357_a(final PotionType llllllllllllllIIIIIlIlIllIlIIIIl, final Item llllllllllllllIIIIIlIlIllIIllIIl, final PotionType llllllllllllllIIIIIlIlIllIIlIlll) {
        func_193356_a(llllllllllllllIIIIIlIlIllIlIIIIl, Ingredient.func_193368_a(llllllllllllllIIIIIlIlIllIIllIIl), llllllllllllllIIIIIlIlIllIIlIlll);
    }
    
    public static boolean hasConversions(final ItemStack llllllllllllllIIIIIlIllIIIIIIIll, final ItemStack llllllllllllllIIIIIlIllIIIIIIIlI) {
        return PotionHelper.IS_POTION_ITEM.apply((Object)llllllllllllllIIIIIlIllIIIIIIIll) && (hasItemConversions(llllllllllllllIIIIIlIllIIIIIIIll, llllllllllllllIIIIIlIllIIIIIIIlI) || hasTypeConversions(llllllllllllllIIIIIlIllIIIIIIIll, llllllllllllllIIIIIlIllIIIIIIIlI));
    }
    
    static {
        POTION_TYPE_CONVERSIONS = Lists.newArrayList();
        POTION_ITEM_CONVERSIONS = Lists.newArrayList();
        POTION_ITEMS = Lists.newArrayList();
        IS_POTION_ITEM = (Predicate)new Predicate<ItemStack>() {
            public boolean apply(final ItemStack lllllllllllllIIIlIlIlIIIIIIlIIII) {
                for (final Ingredient lllllllllllllIIIlIlIlIIIIIIlIIIl : PotionHelper.POTION_ITEMS) {
                    if (lllllllllllllIIIlIlIlIIIIIIlIIIl.apply(lllllllllllllIIIlIlIlIIIIIIlIIII)) {
                        return true;
                    }
                }
                return false;
            }
        };
    }
    
    public static boolean isReagent(final ItemStack llllllllllllllIIIIIlIllIIIIllIll) {
        return isItemConversionReagent(llllllllllllllIIIIIlIllIIIIllIll) || isTypeConversionReagent(llllllllllllllIIIIIlIllIIIIllIll);
    }
    
    private static void func_193355_a(final ItemPotion llllllllllllllIIIIIlIlIllIllIlII, final Item llllllllllllllIIIIIlIlIllIllIIII, final ItemPotion llllllllllllllIIIIIlIlIllIllIIlI) {
        PotionHelper.POTION_ITEM_CONVERSIONS.add(new MixPredicate<Item>(llllllllllllllIIIIIlIlIllIllIlII, Ingredient.func_193368_a(llllllllllllllIIIIIlIlIllIllIIII), llllllllllllllIIIIIlIlIllIllIIlI));
    }
    
    protected static boolean isItemConversionReagent(final ItemStack llllllllllllllIIIIIlIllIIIIlIIll) {
        for (int llllllllllllllIIIIIlIllIIIIlIlIl = 0, llllllllllllllIIIIIlIllIIIIlIlII = PotionHelper.POTION_ITEM_CONVERSIONS.size(); llllllllllllllIIIIIlIllIIIIlIlIl < llllllllllllllIIIIIlIllIIIIlIlII; ++llllllllllllllIIIIIlIllIIIIlIlIl) {
            if (PotionHelper.POTION_ITEM_CONVERSIONS.get(llllllllllllllIIIIIlIllIIIIlIlIl).reagent.apply(llllllllllllllIIIIIlIllIIIIlIIll)) {
                return true;
            }
        }
        return false;
    }
    
    private static void func_193356_a(final PotionType llllllllllllllIIIIIlIlIlIlllllll, final Ingredient llllllllllllllIIIIIlIlIlIlllllIl, final PotionType llllllllllllllIIIIIlIlIlIlllllII) {
        PotionHelper.POTION_TYPE_CONVERSIONS.add(new MixPredicate<PotionType>(llllllllllllllIIIIIlIlIlIlllllll, llllllllllllllIIIIIlIlIlIlllllIl, llllllllllllllIIIIIlIlIlIlllllII));
    }
    
    protected static boolean hasTypeConversions(final ItemStack llllllllllllllIIIIIlIlIllllIIIll, final ItemStack llllllllllllllIIIIIlIlIllllIIIlI) {
        final PotionType llllllllllllllIIIIIlIlIllllIIlll = PotionUtils.getPotionFromItem(llllllllllllllIIIIIlIlIllllIIIll);
        for (int llllllllllllllIIIIIlIlIllllIIllI = 0, llllllllllllllIIIIIlIlIllllIIlIl = PotionHelper.POTION_TYPE_CONVERSIONS.size(); llllllllllllllIIIIIlIlIllllIIllI < llllllllllllllIIIIIlIlIllllIIlIl; ++llllllllllllllIIIIIlIlIllllIIllI) {
            final MixPredicate<PotionType> llllllllllllllIIIIIlIlIllllIIlII = PotionHelper.POTION_TYPE_CONVERSIONS.get(llllllllllllllIIIIIlIlIllllIIllI);
            if (llllllllllllllIIIIIlIlIllllIIlII.input == llllllllllllllIIIIIlIlIllllIIlll && llllllllllllllIIIIIlIlIllllIIlII.reagent.apply(llllllllllllllIIIIIlIlIllllIIIlI)) {
                return true;
            }
        }
        return false;
    }
    
    public static ItemStack doReaction(final ItemStack llllllllllllllIIIIIlIlIlllIIllIl, final ItemStack llllllllllllllIIIIIlIlIlllIlIlIl) {
        if (!llllllllllllllIIIIIlIlIlllIlIlIl.func_190926_b()) {
            final PotionType llllllllllllllIIIIIlIlIlllIlIlII = PotionUtils.getPotionFromItem(llllllllllllllIIIIIlIlIlllIlIlIl);
            final Item llllllllllllllIIIIIlIlIlllIlIIll = llllllllllllllIIIIIlIlIlllIlIlIl.getItem();
            for (int llllllllllllllIIIIIlIlIlllIlIIlI = 0, llllllllllllllIIIIIlIlIlllIlIIIl = PotionHelper.POTION_ITEM_CONVERSIONS.size(); llllllllllllllIIIIIlIlIlllIlIIlI < llllllllllllllIIIIIlIlIlllIlIIIl; ++llllllllllllllIIIIIlIlIlllIlIIlI) {
                final MixPredicate<Item> llllllllllllllIIIIIlIlIlllIlIIII = PotionHelper.POTION_ITEM_CONVERSIONS.get(llllllllllllllIIIIIlIlIlllIlIIlI);
                if (llllllllllllllIIIIIlIlIlllIlIIII.input == llllllllllllllIIIIIlIlIlllIlIIll && llllllllllllllIIIIIlIlIlllIlIIII.reagent.apply(llllllllllllllIIIIIlIlIlllIIllIl)) {
                    return PotionUtils.addPotionToItemStack(new ItemStack(llllllllllllllIIIIIlIlIlllIlIIII.output), llllllllllllllIIIIIlIlIlllIlIlII);
                }
            }
            for (int llllllllllllllIIIIIlIlIlllIlIIlI = 0, llllllllllllllIIIIIlIlIlllIIllll = PotionHelper.POTION_TYPE_CONVERSIONS.size(); llllllllllllllIIIIIlIlIlllIlIIlI < llllllllllllllIIIIIlIlIlllIIllll; ++llllllllllllllIIIIIlIlIlllIlIIlI) {
                final MixPredicate<PotionType> llllllllllllllIIIIIlIlIlllIIlllI = PotionHelper.POTION_TYPE_CONVERSIONS.get(llllllllllllllIIIIIlIlIlllIlIIlI);
                if (llllllllllllllIIIIIlIlIlllIIlllI.input == llllllllllllllIIIIIlIlIlllIlIlII && llllllllllllllIIIIIlIlIlllIIlllI.reagent.apply(llllllllllllllIIIIIlIlIlllIIllIl)) {
                    return PotionUtils.addPotionToItemStack(new ItemStack(llllllllllllllIIIIIlIlIlllIlIIll), llllllllllllllIIIIIlIlIlllIIlllI.output);
                }
            }
        }
        return llllllllllllllIIIIIlIlIlllIlIlIl;
    }
    
    protected static boolean hasItemConversions(final ItemStack llllllllllllllIIIIIlIlIlllllIlIl, final ItemStack llllllllllllllIIIIIlIlIllllllIlI) {
        final Item llllllllllllllIIIIIlIlIllllllIIl = llllllllllllllIIIIIlIlIlllllIlIl.getItem();
        for (int llllllllllllllIIIIIlIlIllllllIII = 0, llllllllllllllIIIIIlIlIlllllIlll = PotionHelper.POTION_ITEM_CONVERSIONS.size(); llllllllllllllIIIIIlIlIllllllIII < llllllllllllllIIIIIlIlIlllllIlll; ++llllllllllllllIIIIIlIlIllllllIII) {
            final MixPredicate<Item> llllllllllllllIIIIIlIlIlllllIllI = PotionHelper.POTION_ITEM_CONVERSIONS.get(llllllllllllllIIIIIlIlIllllllIII);
            if (llllllllllllllIIIIIlIlIlllllIllI.input == llllllllllllllIIIIIlIlIllllllIIl && llllllllllllllIIIIIlIlIlllllIllI.reagent.apply(llllllllllllllIIIIIlIlIllllllIlI)) {
                return true;
            }
        }
        return false;
    }
    
    public static void init() {
        func_193354_a(Items.POTIONITEM);
        func_193354_a(Items.SPLASH_POTION);
        func_193354_a(Items.LINGERING_POTION);
        func_193355_a(Items.POTIONITEM, Items.GUNPOWDER, Items.SPLASH_POTION);
        func_193355_a(Items.SPLASH_POTION, Items.DRAGON_BREATH, Items.LINGERING_POTION);
        func_193357_a(PotionTypes.WATER, Items.SPECKLED_MELON, PotionTypes.MUNDANE);
        func_193357_a(PotionTypes.WATER, Items.GHAST_TEAR, PotionTypes.MUNDANE);
        func_193357_a(PotionTypes.WATER, Items.RABBIT_FOOT, PotionTypes.MUNDANE);
        func_193357_a(PotionTypes.WATER, Items.BLAZE_POWDER, PotionTypes.MUNDANE);
        func_193357_a(PotionTypes.WATER, Items.SPIDER_EYE, PotionTypes.MUNDANE);
        func_193357_a(PotionTypes.WATER, Items.SUGAR, PotionTypes.MUNDANE);
        func_193357_a(PotionTypes.WATER, Items.MAGMA_CREAM, PotionTypes.MUNDANE);
        func_193357_a(PotionTypes.WATER, Items.GLOWSTONE_DUST, PotionTypes.THICK);
        func_193357_a(PotionTypes.WATER, Items.REDSTONE, PotionTypes.MUNDANE);
        func_193357_a(PotionTypes.WATER, Items.NETHER_WART, PotionTypes.AWKWARD);
        func_193357_a(PotionTypes.AWKWARD, Items.GOLDEN_CARROT, PotionTypes.NIGHT_VISION);
        func_193357_a(PotionTypes.NIGHT_VISION, Items.REDSTONE, PotionTypes.LONG_NIGHT_VISION);
        func_193357_a(PotionTypes.NIGHT_VISION, Items.FERMENTED_SPIDER_EYE, PotionTypes.INVISIBILITY);
        func_193357_a(PotionTypes.LONG_NIGHT_VISION, Items.FERMENTED_SPIDER_EYE, PotionTypes.LONG_INVISIBILITY);
        func_193357_a(PotionTypes.INVISIBILITY, Items.REDSTONE, PotionTypes.LONG_INVISIBILITY);
        func_193357_a(PotionTypes.AWKWARD, Items.MAGMA_CREAM, PotionTypes.FIRE_RESISTANCE);
        func_193357_a(PotionTypes.FIRE_RESISTANCE, Items.REDSTONE, PotionTypes.LONG_FIRE_RESISTANCE);
        func_193357_a(PotionTypes.AWKWARD, Items.RABBIT_FOOT, PotionTypes.LEAPING);
        func_193357_a(PotionTypes.LEAPING, Items.REDSTONE, PotionTypes.LONG_LEAPING);
        func_193357_a(PotionTypes.LEAPING, Items.GLOWSTONE_DUST, PotionTypes.STRONG_LEAPING);
        func_193357_a(PotionTypes.LEAPING, Items.FERMENTED_SPIDER_EYE, PotionTypes.SLOWNESS);
        func_193357_a(PotionTypes.LONG_LEAPING, Items.FERMENTED_SPIDER_EYE, PotionTypes.LONG_SLOWNESS);
        func_193357_a(PotionTypes.SLOWNESS, Items.REDSTONE, PotionTypes.LONG_SLOWNESS);
        func_193357_a(PotionTypes.SWIFTNESS, Items.FERMENTED_SPIDER_EYE, PotionTypes.SLOWNESS);
        func_193357_a(PotionTypes.LONG_SWIFTNESS, Items.FERMENTED_SPIDER_EYE, PotionTypes.LONG_SLOWNESS);
        func_193357_a(PotionTypes.AWKWARD, Items.SUGAR, PotionTypes.SWIFTNESS);
        func_193357_a(PotionTypes.SWIFTNESS, Items.REDSTONE, PotionTypes.LONG_SWIFTNESS);
        func_193357_a(PotionTypes.SWIFTNESS, Items.GLOWSTONE_DUST, PotionTypes.STRONG_SWIFTNESS);
        func_193356_a(PotionTypes.AWKWARD, Ingredient.func_193369_a(new ItemStack(Items.FISH, 1, ItemFishFood.FishType.PUFFERFISH.getMetadata())), PotionTypes.WATER_BREATHING);
        func_193357_a(PotionTypes.WATER_BREATHING, Items.REDSTONE, PotionTypes.LONG_WATER_BREATHING);
        func_193357_a(PotionTypes.AWKWARD, Items.SPECKLED_MELON, PotionTypes.HEALING);
        func_193357_a(PotionTypes.HEALING, Items.GLOWSTONE_DUST, PotionTypes.STRONG_HEALING);
        func_193357_a(PotionTypes.HEALING, Items.FERMENTED_SPIDER_EYE, PotionTypes.HARMING);
        func_193357_a(PotionTypes.STRONG_HEALING, Items.FERMENTED_SPIDER_EYE, PotionTypes.STRONG_HARMING);
        func_193357_a(PotionTypes.HARMING, Items.GLOWSTONE_DUST, PotionTypes.STRONG_HARMING);
        func_193357_a(PotionTypes.POISON, Items.FERMENTED_SPIDER_EYE, PotionTypes.HARMING);
        func_193357_a(PotionTypes.LONG_POISON, Items.FERMENTED_SPIDER_EYE, PotionTypes.HARMING);
        func_193357_a(PotionTypes.STRONG_POISON, Items.FERMENTED_SPIDER_EYE, PotionTypes.STRONG_HARMING);
        func_193357_a(PotionTypes.AWKWARD, Items.SPIDER_EYE, PotionTypes.POISON);
        func_193357_a(PotionTypes.POISON, Items.REDSTONE, PotionTypes.LONG_POISON);
        func_193357_a(PotionTypes.POISON, Items.GLOWSTONE_DUST, PotionTypes.STRONG_POISON);
        func_193357_a(PotionTypes.AWKWARD, Items.GHAST_TEAR, PotionTypes.REGENERATION);
        func_193357_a(PotionTypes.REGENERATION, Items.REDSTONE, PotionTypes.LONG_REGENERATION);
        func_193357_a(PotionTypes.REGENERATION, Items.GLOWSTONE_DUST, PotionTypes.STRONG_REGENERATION);
        func_193357_a(PotionTypes.AWKWARD, Items.BLAZE_POWDER, PotionTypes.STRENGTH);
        func_193357_a(PotionTypes.STRENGTH, Items.REDSTONE, PotionTypes.LONG_STRENGTH);
        func_193357_a(PotionTypes.STRENGTH, Items.GLOWSTONE_DUST, PotionTypes.STRONG_STRENGTH);
        func_193357_a(PotionTypes.WATER, Items.FERMENTED_SPIDER_EYE, PotionTypes.WEAKNESS);
        func_193357_a(PotionTypes.WEAKNESS, Items.REDSTONE, PotionTypes.LONG_WEAKNESS);
    }
    
    static class MixPredicate<T>
    {
        final /* synthetic */ T output;
        final /* synthetic */ T input;
        final /* synthetic */ Ingredient reagent;
        
        public MixPredicate(final T lllllllllllllllIllIIlIllIlllllIl, final Ingredient lllllllllllllllIllIIlIllIlllllII, final T lllllllllllllllIllIIlIllIlllllll) {
            this.input = lllllllllllllllIllIIlIllIlllllIl;
            this.reagent = lllllllllllllllIllIIlIllIlllllII;
            this.output = lllllllllllllllIllIIlIllIlllllll;
        }
    }
}
