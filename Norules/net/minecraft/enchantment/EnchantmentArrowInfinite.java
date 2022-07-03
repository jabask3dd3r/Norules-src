package net.minecraft.enchantment;

import net.minecraft.inventory.*;

public class EnchantmentArrowInfinite extends Enchantment
{
    public boolean canApplyTogether(final Enchantment lllIIIIIIIl) {
        return !(lllIIIIIIIl instanceof EnchantmentMending) && super.canApplyTogether(lllIIIIIIIl);
    }
    
    @Override
    public int getMaxEnchantability(final int lllIIIIlIII) {
        return 50;
    }
    
    @Override
    public int getMinEnchantability(final int lllIIIIlIlI) {
        return 20;
    }
    
    public EnchantmentArrowInfinite(final Rarity lllIIIIllIl, final EntityEquipmentSlot... lllIIIIllll) {
        super(lllIIIIllIl, EnumEnchantmentType.BOW, lllIIIIllll);
        this.setName("arrowInfinite");
    }
    
    @Override
    public int getMaxLevel() {
        return 1;
    }
}
