package net.minecraft.enchantment;

import net.minecraft.inventory.*;
import net.minecraft.init.*;

public class EnchantmentUntouching extends Enchantment
{
    @Override
    public int getMinEnchantability(final int lllllllllllllIIlIIIIIlIIIllIlIIl) {
        return 15;
    }
    
    @Override
    public int getMaxLevel() {
        return 1;
    }
    
    protected EnchantmentUntouching(final Rarity lllllllllllllIIlIIIIIlIIIllIllll, final EntityEquipmentSlot... lllllllllllllIIlIIIIIlIIIllIlIll) {
        super(lllllllllllllIIlIIIIIlIIIllIllll, EnumEnchantmentType.DIGGER, lllllllllllllIIlIIIIIlIIIllIlIll);
        this.setName("untouching");
    }
    
    @Override
    public int getMaxEnchantability(final int lllllllllllllIIlIIIIIlIIIllIIIll) {
        return super.getMinEnchantability(lllllllllllllIIlIIIIIlIIIllIIIll) + 50;
    }
    
    public boolean canApplyTogether(final Enchantment lllllllllllllIIlIIIIIlIIIlIlllII) {
        return super.canApplyTogether(lllllllllllllIIlIIIIIlIIIlIlllII) && lllllllllllllIIlIIIIIlIIIlIlllII != Enchantments.FORTUNE;
    }
}
