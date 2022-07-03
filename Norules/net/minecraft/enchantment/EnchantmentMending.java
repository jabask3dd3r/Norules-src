package net.minecraft.enchantment;

import net.minecraft.inventory.*;

public class EnchantmentMending extends Enchantment
{
    @Override
    public int getMaxEnchantability(final int llllllllllllllIlIIIIIIIIllIIlIII) {
        return this.getMinEnchantability(llllllllllllllIlIIIIIIIIllIIlIII) + 50;
    }
    
    @Override
    public int getMinEnchantability(final int llllllllllllllIlIIIIIIIIllIIlllI) {
        return llllllllllllllIlIIIIIIIIllIIlllI * 25;
    }
    
    @Override
    public boolean isTreasureEnchantment() {
        return true;
    }
    
    public EnchantmentMending(final Rarity llllllllllllllIlIIIIIIIIllIlIllI, final EntityEquipmentSlot... llllllllllllllIlIIIIIIIIllIlIlIl) {
        super(llllllllllllllIlIIIIIIIIllIlIllI, EnumEnchantmentType.BREAKABLE, llllllllllllllIlIIIIIIIIllIlIlIl);
        this.setName("mending");
    }
    
    @Override
    public int getMaxLevel() {
        return 1;
    }
}
