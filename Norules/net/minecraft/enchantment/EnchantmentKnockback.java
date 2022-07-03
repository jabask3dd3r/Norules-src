package net.minecraft.enchantment;

import net.minecraft.inventory.*;

public class EnchantmentKnockback extends Enchantment
{
    @Override
    public int getMaxLevel() {
        return 2;
    }
    
    @Override
    public int getMinEnchantability(final int llllllllllllllIlIIIIllIlIlIIIlII) {
        return 5 + 20 * (llllllllllllllIlIIIIllIlIlIIIlII - 1);
    }
    
    @Override
    public int getMaxEnchantability(final int llllllllllllllIlIIIIllIlIIlllllI) {
        return super.getMinEnchantability(llllllllllllllIlIIIIllIlIIlllllI) + 50;
    }
    
    protected EnchantmentKnockback(final Rarity llllllllllllllIlIIIIllIlIlIIlIIl, final EntityEquipmentSlot... llllllllllllllIlIIIIllIlIlIIlIII) {
        super(llllllllllllllIlIIIIllIlIlIIlIIl, EnumEnchantmentType.WEAPON, llllllllllllllIlIIIIllIlIlIIlIII);
        this.setName("knockback");
    }
}
