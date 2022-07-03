package net.minecraft.enchantment;

import net.minecraft.inventory.*;

public class EnchantmentVanishingCurse extends Enchantment
{
    @Override
    public boolean isTreasureEnchantment() {
        return true;
    }
    
    public EnchantmentVanishingCurse(final Rarity lllllllllllllIIlllIIlllIllllIlII, final EntityEquipmentSlot... lllllllllllllIIlllIIlllIllllIIll) {
        super(lllllllllllllIIlllIIlllIllllIlII, EnumEnchantmentType.ALL, lllllllllllllIIlllIIlllIllllIIll);
        this.setName("vanishing_curse");
    }
    
    @Override
    public int getMinEnchantability(final int lllllllllllllIIlllIIlllIlllIlllI) {
        return 25;
    }
    
    @Override
    public int getMaxEnchantability(final int lllllllllllllIIlllIIlllIlllIllII) {
        return 50;
    }
    
    @Override
    public boolean func_190936_d() {
        return true;
    }
    
    @Override
    public int getMaxLevel() {
        return 1;
    }
}
