package net.minecraft.enchantment;

import net.minecraft.inventory.*;

public class EnchantmentFishingSpeed extends Enchantment
{
    @Override
    public int getMinEnchantability(final int llllllllllllllIIIIlllllllllIIlll) {
        return 15 + (llllllllllllllIIIIlllllllllIIlll - 1) * 9;
    }
    
    @Override
    public int getMaxLevel() {
        return 3;
    }
    
    @Override
    public int getMaxEnchantability(final int llllllllllllllIIIIlllllllllIIIII) {
        return super.getMinEnchantability(llllllllllllllIIIIlllllllllIIIII) + 50;
    }
    
    protected EnchantmentFishingSpeed(final Rarity llllllllllllllIIIIlllllllllIllII, final EnumEnchantmentType llllllllllllllIIIIlllllllllIlIll, final EntityEquipmentSlot... llllllllllllllIIIIlllllllllIlIlI) {
        super(llllllllllllllIIIIlllllllllIllII, llllllllllllllIIIIlllllllllIlIll, llllllllllllllIIIIlllllllllIlIlI);
        this.setName("fishingSpeed");
    }
}
