package net.minecraft.enchantment;

import net.minecraft.init.*;
import net.minecraft.inventory.*;

public class EnchantmentLootBonus extends Enchantment
{
    public boolean canApplyTogether(final Enchantment llllllllllllllIllIIlIlIIlllllIIl) {
        return super.canApplyTogether(llllllllllllllIllIIlIlIIlllllIIl) && llllllllllllllIllIIlIlIIlllllIIl != Enchantments.SILK_TOUCH;
    }
    
    @Override
    public int getMinEnchantability(final int llllllllllllllIllIIlIlIlIIIIIlIl) {
        return 15 + (llllllllllllllIllIIlIlIlIIIIIlIl - 1) * 9;
    }
    
    @Override
    public int getMaxLevel() {
        return 3;
    }
    
    protected EnchantmentLootBonus(final Rarity llllllllllllllIllIIlIlIlIIIIlllI, final EnumEnchantmentType llllllllllllllIllIIlIlIlIIIIlIIl, final EntityEquipmentSlot... llllllllllllllIllIIlIlIlIIIIlIII) {
        super(llllllllllllllIllIIlIlIlIIIIlllI, llllllllllllllIllIIlIlIlIIIIlIIl, llllllllllllllIllIIlIlIlIIIIlIII);
        if (llllllllllllllIllIIlIlIlIIIIlIIl == EnumEnchantmentType.DIGGER) {
            this.setName("lootBonusDigger");
        }
        else if (llllllllllllllIllIIlIlIlIIIIlIIl == EnumEnchantmentType.FISHING_ROD) {
            this.setName("lootBonusFishing");
        }
        else {
            this.setName("lootBonus");
        }
    }
    
    @Override
    public int getMaxEnchantability(final int llllllllllllllIllIIlIlIIlllllllI) {
        return super.getMinEnchantability(llllllllllllllIllIIlIlIIlllllllI) + 50;
    }
}
