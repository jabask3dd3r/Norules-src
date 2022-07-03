package net.minecraft.enchantment;

import net.minecraft.util.*;

public class EnchantmentData extends WeightedRandom.Item
{
    public final /* synthetic */ int enchantmentLevel;
    public final /* synthetic */ Enchantment enchantmentobj;
    
    public EnchantmentData(final Enchantment lllllllllllllllIIlIIIIllllIllIIl, final int lllllllllllllllIIlIIIIllllIllIII) {
        super(lllllllllllllllIIlIIIIllllIllIIl.getRarity().getWeight());
        this.enchantmentobj = lllllllllllllllIIlIIIIllllIllIIl;
        this.enchantmentLevel = lllllllllllllllIIlIIIIllllIllIII;
    }
}
