package net.minecraft.enchantment;

import java.util.*;
import net.minecraft.item.*;
import net.minecraft.inventory.*;

public class EnchantmentDurability extends Enchantment
{
    @Override
    public int getMaxEnchantability(final int lllllllllllllllIllIIlIIlllIIlIII) {
        return super.getMinEnchantability(lllllllllllllllIllIIlIIlllIIlIII) + 50;
    }
    
    @Override
    public int getMinEnchantability(final int lllllllllllllllIllIIlIIlllIIllIl) {
        return 5 + (lllllllllllllllIllIIlIIlllIIllIl - 1) * 8;
    }
    
    public static boolean negateDamage(final ItemStack lllllllllllllllIllIIlIIllIlllIll, final int lllllllllllllllIllIIlIIllIlllIlI, final Random lllllllllllllllIllIIlIIllIlllIIl) {
        return (!(lllllllllllllllIllIIlIIllIlllIll.getItem() instanceof ItemArmor) || lllllllllllllllIllIIlIIllIlllIIl.nextFloat() >= 0.6f) && lllllllllllllllIllIIlIIllIlllIIl.nextInt(lllllllllllllllIllIIlIIllIlllIlI + 1) > 0;
    }
    
    protected EnchantmentDurability(final Rarity lllllllllllllllIllIIlIIlllIlIlII, final EntityEquipmentSlot... lllllllllllllllIllIIlIIlllIlIIll) {
        super(lllllllllllllllIllIIlIIlllIlIlII, EnumEnchantmentType.BREAKABLE, lllllllllllllllIllIIlIIlllIlIIll);
        this.setName("durability");
    }
    
    @Override
    public boolean canApply(final ItemStack lllllllllllllllIllIIlIIlllIIIIIl) {
        return lllllllllllllllIllIIlIIlllIIIIIl.isItemStackDamageable() || super.canApply(lllllllllllllllIllIIlIIlllIIIIIl);
    }
    
    @Override
    public int getMaxLevel() {
        return 3;
    }
}
