package net.minecraft.enchantment;

import net.minecraft.inventory.*;

public class EnchantmentArrowDamage extends Enchantment
{
    public EnchantmentArrowDamage(final Rarity lllllllllllllllIIllIlIlIIIIIIIlI, final EntityEquipmentSlot... lllllllllllllllIIllIlIIllllllllI) {
        super(lllllllllllllllIIllIlIlIIIIIIIlI, EnumEnchantmentType.BOW, lllllllllllllllIIllIlIIllllllllI);
        this.setName("arrowDamage");
    }
    
    @Override
    public int getMaxEnchantability(final int lllllllllllllllIIllIlIIlllllIllI) {
        return this.getMinEnchantability(lllllllllllllllIIllIlIIlllllIllI) + 15;
    }
    
    @Override
    public int getMinEnchantability(final int lllllllllllllllIIllIlIIllllllIlI) {
        return 1 + (lllllllllllllllIIllIlIIllllllIlI - 1) * 10;
    }
    
    @Override
    public int getMaxLevel() {
        return 5;
    }
}
