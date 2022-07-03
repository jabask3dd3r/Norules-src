package net.minecraft.enchantment;

import net.minecraft.inventory.*;

public class EnchantmentSweepingEdge extends Enchantment
{
    public static float func_191526_e(final int llllllllllllllllllIIllIllllIIlll) {
        return 1.0f - 1.0f / (llllllllllllllllllIIllIllllIIlll + 1);
    }
    
    @Override
    public int getMaxEnchantability(final int llllllllllllllllllIIllIllllIllII) {
        return this.getMinEnchantability(llllllllllllllllllIIllIllllIllII) + 15;
    }
    
    @Override
    public int getMaxLevel() {
        return 3;
    }
    
    @Override
    public int getMinEnchantability(final int llllllllllllllllllIIllIlllllIIIl) {
        return 5 + (llllllllllllllllllIIllIlllllIIIl - 1) * 9;
    }
    
    public EnchantmentSweepingEdge(final Rarity llllllllllllllllllIIllIllllllIII, final EntityEquipmentSlot... llllllllllllllllllIIllIlllllIlll) {
        super(llllllllllllllllllIIllIllllllIII, EnumEnchantmentType.WEAPON, llllllllllllllllllIIllIlllllIlll);
    }
    
    @Override
    public String getName() {
        return "enchantment.sweeping";
    }
}
