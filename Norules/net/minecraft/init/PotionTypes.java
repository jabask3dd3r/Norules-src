package net.minecraft.init;

import net.minecraft.potion.*;
import java.util.*;
import net.minecraft.util.*;
import com.google.common.collect.*;

public class PotionTypes
{
    private static final /* synthetic */ Set<PotionType> CACHE;
    
    private static PotionType getRegisteredPotionType(final String lllllllllllllllIllIIllllIllIIIIl) {
        final PotionType lllllllllllllllIllIIllllIllIIIlI = PotionType.REGISTRY.getObject(new ResourceLocation(lllllllllllllllIllIIllllIllIIIIl));
        if (!PotionTypes.CACHE.add(lllllllllllllllIllIIllllIllIIIlI)) {
            throw new IllegalStateException(String.valueOf(new StringBuilder("Invalid Potion requested: ").append(lllllllllllllllIllIIllllIllIIIIl)));
        }
        return lllllllllllllllIllIIllllIllIIIlI;
    }
    
    static {
        if (!Bootstrap.isRegistered()) {
            throw new RuntimeException("Accessed Potions before Bootstrap!");
        }
        CACHE = Sets.newHashSet();
        EMPTY = getRegisteredPotionType("empty");
        WATER = getRegisteredPotionType("water");
        MUNDANE = getRegisteredPotionType("mundane");
        THICK = getRegisteredPotionType("thick");
        AWKWARD = getRegisteredPotionType("awkward");
        NIGHT_VISION = getRegisteredPotionType("night_vision");
        LONG_NIGHT_VISION = getRegisteredPotionType("long_night_vision");
        INVISIBILITY = getRegisteredPotionType("invisibility");
        LONG_INVISIBILITY = getRegisteredPotionType("long_invisibility");
        LEAPING = getRegisteredPotionType("leaping");
        LONG_LEAPING = getRegisteredPotionType("long_leaping");
        STRONG_LEAPING = getRegisteredPotionType("strong_leaping");
        FIRE_RESISTANCE = getRegisteredPotionType("fire_resistance");
        LONG_FIRE_RESISTANCE = getRegisteredPotionType("long_fire_resistance");
        SWIFTNESS = getRegisteredPotionType("swiftness");
        LONG_SWIFTNESS = getRegisteredPotionType("long_swiftness");
        STRONG_SWIFTNESS = getRegisteredPotionType("strong_swiftness");
        SLOWNESS = getRegisteredPotionType("slowness");
        LONG_SLOWNESS = getRegisteredPotionType("long_slowness");
        WATER_BREATHING = getRegisteredPotionType("water_breathing");
        LONG_WATER_BREATHING = getRegisteredPotionType("long_water_breathing");
        HEALING = getRegisteredPotionType("healing");
        STRONG_HEALING = getRegisteredPotionType("strong_healing");
        HARMING = getRegisteredPotionType("harming");
        STRONG_HARMING = getRegisteredPotionType("strong_harming");
        POISON = getRegisteredPotionType("poison");
        LONG_POISON = getRegisteredPotionType("long_poison");
        STRONG_POISON = getRegisteredPotionType("strong_poison");
        REGENERATION = getRegisteredPotionType("regeneration");
        LONG_REGENERATION = getRegisteredPotionType("long_regeneration");
        STRONG_REGENERATION = getRegisteredPotionType("strong_regeneration");
        STRENGTH = getRegisteredPotionType("strength");
        LONG_STRENGTH = getRegisteredPotionType("long_strength");
        STRONG_STRENGTH = getRegisteredPotionType("strong_strength");
        WEAKNESS = getRegisteredPotionType("weakness");
        LONG_WEAKNESS = getRegisteredPotionType("long_weakness");
        PotionTypes.CACHE.clear();
    }
}
