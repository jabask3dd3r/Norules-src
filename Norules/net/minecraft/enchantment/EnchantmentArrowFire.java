package net.minecraft.enchantment;

import net.minecraft.inventory.*;

public class EnchantmentArrowFire extends Enchantment
{
    public EnchantmentArrowFire(final Rarity llllllllllllllIIllIlIllIIIIllllI, final EntityEquipmentSlot... llllllllllllllIIllIlIllIIIIllIlI) {
        super(llllllllllllllIIllIlIllIIIIllllI, EnumEnchantmentType.BOW, llllllllllllllIIllIlIllIIIIllIlI);
        this.setName("arrowFire");
    }
    
    @Override
    public int getMinEnchantability(final int llllllllllllllIIllIlIllIIIIllIII) {
        return 20;
    }
    
    @Override
    public int getMaxLevel() {
        return 1;
    }
    
    @Override
    public int getMaxEnchantability(final int llllllllllllllIIllIlIllIIIIlIIll) {
        return 50;
    }
}
