package net.minecraft.enchantment;

import net.minecraft.item.*;
import net.minecraft.init.*;
import net.minecraft.inventory.*;

public class EnchantmentDigging extends Enchantment
{
    @Override
    public boolean canApply(final ItemStack lllllllllllllIllIIlllllIIIllIIII) {
        return lllllllllllllIllIIlllllIIIllIIII.getItem() == Items.SHEARS || super.canApply(lllllllllllllIllIIlllllIIIllIIII);
    }
    
    @Override
    public int getMinEnchantability(final int lllllllllllllIllIIlllllIIIlllllI) {
        return 1 + 10 * (lllllllllllllIllIIlllllIIIlllllI - 1);
    }
    
    @Override
    public int getMaxEnchantability(final int lllllllllllllIllIIlllllIIIlllIIl) {
        return super.getMinEnchantability(lllllllllllllIllIIlllllIIIlllIIl) + 50;
    }
    
    protected EnchantmentDigging(final Rarity lllllllllllllIllIIlllllIIlIIIIlI, final EntityEquipmentSlot... lllllllllllllIllIIlllllIIlIIIlII) {
        super(lllllllllllllIllIIlllllIIlIIIIlI, EnumEnchantmentType.DIGGER, lllllllllllllIllIIlllllIIlIIIlII);
        this.setName("digging");
    }
    
    @Override
    public int getMaxLevel() {
        return 5;
    }
}
