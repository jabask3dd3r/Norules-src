package net.minecraft.init;

import net.minecraft.enchantment.*;
import net.minecraft.util.*;
import javax.annotation.*;

public class Enchantments
{
    @Nullable
    private static Enchantment getRegisteredEnchantment(final String lllllllllllllIlIlllIIlIIlIlIlIll) {
        final Enchantment lllllllllllllIlIlllIIlIIlIlIlIlI = Enchantment.REGISTRY.getObject(new ResourceLocation(lllllllllllllIlIlllIIlIIlIlIlIll));
        if (lllllllllllllIlIlllIIlIIlIlIlIlI == null) {
            throw new IllegalStateException(String.valueOf(new StringBuilder("Invalid Enchantment requested: ").append(lllllllllllllIlIlllIIlIIlIlIlIll)));
        }
        return lllllllllllllIlIlllIIlIIlIlIlIlI;
    }
    
    static {
        PROTECTION = getRegisteredEnchantment("protection");
        FIRE_PROTECTION = getRegisteredEnchantment("fire_protection");
        FEATHER_FALLING = getRegisteredEnchantment("feather_falling");
        BLAST_PROTECTION = getRegisteredEnchantment("blast_protection");
        PROJECTILE_PROTECTION = getRegisteredEnchantment("projectile_protection");
        RESPIRATION = getRegisteredEnchantment("respiration");
        AQUA_AFFINITY = getRegisteredEnchantment("aqua_affinity");
        THORNS = getRegisteredEnchantment("thorns");
        DEPTH_STRIDER = getRegisteredEnchantment("depth_strider");
        FROST_WALKER = getRegisteredEnchantment("frost_walker");
        field_190941_k = getRegisteredEnchantment("binding_curse");
        SHARPNESS = getRegisteredEnchantment("sharpness");
        SMITE = getRegisteredEnchantment("smite");
        BANE_OF_ARTHROPODS = getRegisteredEnchantment("bane_of_arthropods");
        KNOCKBACK = getRegisteredEnchantment("knockback");
        FIRE_ASPECT = getRegisteredEnchantment("fire_aspect");
        LOOTING = getRegisteredEnchantment("looting");
        field_191530_r = getRegisteredEnchantment("sweeping");
        EFFICIENCY = getRegisteredEnchantment("efficiency");
        SILK_TOUCH = getRegisteredEnchantment("silk_touch");
        UNBREAKING = getRegisteredEnchantment("unbreaking");
        FORTUNE = getRegisteredEnchantment("fortune");
        POWER = getRegisteredEnchantment("power");
        PUNCH = getRegisteredEnchantment("punch");
        FLAME = getRegisteredEnchantment("flame");
        INFINITY = getRegisteredEnchantment("infinity");
        LUCK_OF_THE_SEA = getRegisteredEnchantment("luck_of_the_sea");
        LURE = getRegisteredEnchantment("lure");
        MENDING = getRegisteredEnchantment("mending");
        field_190940_C = getRegisteredEnchantment("vanishing_curse");
        if (!Bootstrap.isRegistered()) {
            throw new RuntimeException("Accessed Enchantments before Bootstrap!");
        }
    }
}
