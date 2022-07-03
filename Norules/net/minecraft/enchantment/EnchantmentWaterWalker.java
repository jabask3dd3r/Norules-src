package net.minecraft.enchantment;

import net.minecraft.init.*;
import net.minecraft.inventory.*;

public class EnchantmentWaterWalker extends Enchantment
{
    public boolean canApplyTogether(final Enchantment llIIllllllIIIlI) {
        return super.canApplyTogether(llIIllllllIIIlI) && llIIllllllIIIlI != Enchantments.FROST_WALKER;
    }
    
    @Override
    public int getMinEnchantability(final int llIIllllllIllIl) {
        return llIIllllllIllIl * 10;
    }
    
    @Override
    public int getMaxLevel() {
        return 3;
    }
    
    public EnchantmentWaterWalker(final Rarity llIIlllllllIIlI, final EntityEquipmentSlot... llIIlllllllIlII) {
        super(llIIlllllllIIlI, EnumEnchantmentType.ARMOR_FEET, llIIlllllllIlII);
        this.setName("waterWalker");
    }
    
    @Override
    public int getMaxEnchantability(final int llIIllllllIIlll) {
        return this.getMinEnchantability(llIIllllllIIlll) + 15;
    }
}
