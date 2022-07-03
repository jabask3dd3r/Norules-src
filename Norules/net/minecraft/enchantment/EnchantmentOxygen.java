package net.minecraft.enchantment;

import net.minecraft.inventory.*;

public class EnchantmentOxygen extends Enchantment
{
    @Override
    public int getMinEnchantability(final int lllllllllllllllIIlIlIIIlIlllIlIl) {
        return 10 * lllllllllllllllIIlIlIIIlIlllIlIl;
    }
    
    public EnchantmentOxygen(final Rarity lllllllllllllllIIlIlIIIlIllllIlI, final EntityEquipmentSlot... lllllllllllllllIIlIlIIIlIlllllII) {
        super(lllllllllllllllIIlIlIIIlIllllIlI, EnumEnchantmentType.ARMOR_HEAD, lllllllllllllllIIlIlIIIlIlllllII);
        this.setName("oxygen");
    }
    
    @Override
    public int getMaxLevel() {
        return 3;
    }
    
    @Override
    public int getMaxEnchantability(final int lllllllllllllllIIlIlIIIlIllIllll) {
        return this.getMinEnchantability(lllllllllllllllIIlIlIIIlIllIllll) + 30;
    }
}
