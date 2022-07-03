package net.minecraft.enchantment;

import net.minecraft.inventory.*;

public class EnchantmentBindingCurse extends Enchantment
{
    @Override
    public int getMaxLevel() {
        return 1;
    }
    
    @Override
    public boolean isTreasureEnchantment() {
        return true;
    }
    
    @Override
    public int getMaxEnchantability(final int lllllllllllllIIllIIIlIlllIlllIII) {
        return 50;
    }
    
    @Override
    public boolean func_190936_d() {
        return true;
    }
    
    public EnchantmentBindingCurse(final Rarity lllllllllllllIIllIIIlIlllIllllIl, final EntityEquipmentSlot... lllllllllllllIIllIIIlIlllIllllll) {
        super(lllllllllllllIIllIIIlIlllIllllIl, EnumEnchantmentType.WEARABLE, lllllllllllllIIllIIIlIlllIllllll);
        this.setName("binding_curse");
    }
    
    @Override
    public int getMinEnchantability(final int lllllllllllllIIllIIIlIlllIlllIlI) {
        return 25;
    }
}
