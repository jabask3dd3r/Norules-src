package net.minecraft.enchantment;

import net.minecraft.inventory.*;

public class EnchantmentWaterWorker extends Enchantment
{
    @Override
    public int getMaxLevel() {
        return 1;
    }
    
    public EnchantmentWaterWorker(final Rarity lllllllllllllIIlllIlIllIIlllIIIl, final EntityEquipmentSlot... lllllllllllllIIlllIlIllIIllIllIl) {
        super(lllllllllllllIIlllIlIllIIlllIIIl, EnumEnchantmentType.ARMOR_HEAD, lllllllllllllIIlllIlIllIIllIllIl);
        this.setName("waterWorker");
    }
    
    @Override
    public int getMinEnchantability(final int lllllllllllllIIlllIlIllIIllIlIll) {
        return 1;
    }
    
    @Override
    public int getMaxEnchantability(final int lllllllllllllIIlllIlIllIIllIIlIl) {
        return this.getMinEnchantability(lllllllllllllIIlllIlIllIIllIIlIl) + 40;
    }
}
