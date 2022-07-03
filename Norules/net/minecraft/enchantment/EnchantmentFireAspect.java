package net.minecraft.enchantment;

import net.minecraft.inventory.*;

public class EnchantmentFireAspect extends Enchantment
{
    protected EnchantmentFireAspect(final Rarity llllllllllllIllllllllIIIIllIIIII, final EntityEquipmentSlot... llllllllllllIllllllllIIIIllIIIlI) {
        super(llllllllllllIllllllllIIIIllIIIII, EnumEnchantmentType.WEAPON, llllllllllllIllllllllIIIIllIIIlI);
        this.setName("fire");
    }
    
    @Override
    public int getMaxLevel() {
        return 2;
    }
    
    @Override
    public int getMaxEnchantability(final int llllllllllllIllllllllIIIIlIlIlIl) {
        return super.getMinEnchantability(llllllllllllIllllllllIIIIlIlIlIl) + 50;
    }
    
    @Override
    public int getMinEnchantability(final int llllllllllllIllllllllIIIIlIllIll) {
        return 10 + 20 * (llllllllllllIllllllllIIIIlIllIll - 1);
    }
}
