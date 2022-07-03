package net.minecraft.enchantment;

import net.minecraft.inventory.*;

public class EnchantmentArrowKnockback extends Enchantment
{
    @Override
    public int getMinEnchantability(final int lllllllllllllIIlIIIIlIIlIllIlIIl) {
        return 12 + (lllllllllllllIIlIIIIlIIlIllIlIIl - 1) * 20;
    }
    
    public EnchantmentArrowKnockback(final Rarity lllllllllllllIIlIIIIlIIlIlllIIII, final EntityEquipmentSlot... lllllllllllllIIlIIIIlIIlIllIllll) {
        super(lllllllllllllIIlIIIIlIIlIlllIIII, EnumEnchantmentType.BOW, lllllllllllllIIlIIIIlIIlIllIllll);
        this.setName("arrowKnockback");
    }
    
    @Override
    public int getMaxLevel() {
        return 2;
    }
    
    @Override
    public int getMaxEnchantability(final int lllllllllllllIIlIIIIlIIlIllIIIlI) {
        return this.getMinEnchantability(lllllllllllllIIlIIIIlIIlIllIIIlI) + 25;
    }
}
