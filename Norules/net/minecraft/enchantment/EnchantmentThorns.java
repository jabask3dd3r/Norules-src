package net.minecraft.enchantment;

import java.util.*;
import net.minecraft.item.*;
import net.minecraft.entity.*;
import net.minecraft.init.*;
import net.minecraft.util.*;
import net.minecraft.inventory.*;

public class EnchantmentThorns extends Enchantment
{
    @Override
    public int getMaxLevel() {
        return 3;
    }
    
    public static int getDamage(final int lllllllllllllllIIlIlllIIIIlIIIII, final Random lllllllllllllllIIlIlllIIIIIlllll) {
        return (lllllllllllllllIIlIlllIIIIlIIIII > 10) ? (lllllllllllllllIIlIlllIIIIlIIIII - 10) : (1 + lllllllllllllllIIlIlllIIIIIlllll.nextInt(4));
    }
    
    @Override
    public int getMaxEnchantability(final int lllllllllllllllIIlIlllIIIlIIIIlI) {
        return super.getMinEnchantability(lllllllllllllllIIlIlllIIIlIIIIlI) + 50;
    }
    
    @Override
    public boolean canApply(final ItemStack lllllllllllllllIIlIlllIIIIllllIl) {
        return lllllllllllllllIIlIlllIIIIllllIl.getItem() instanceof ItemArmor || super.canApply(lllllllllllllllIIlIlllIIIIllllIl);
    }
    
    @Override
    public void onUserHurt(final EntityLivingBase lllllllllllllllIIlIlllIIIIlIllll, final Entity lllllllllllllllIIlIlllIIIIllIIll, final int lllllllllllllllIIlIlllIIIIlIllIl) {
        final Random lllllllllllllllIIlIlllIIIIllIIIl = lllllllllllllllIIlIlllIIIIlIllll.getRNG();
        final ItemStack lllllllllllllllIIlIlllIIIIllIIII = EnchantmentHelper.getEnchantedItem(Enchantments.THORNS, lllllllllllllllIIlIlllIIIIlIllll);
        if (shouldHit(lllllllllllllllIIlIlllIIIIlIllIl, lllllllllllllllIIlIlllIIIIllIIIl)) {
            if (lllllllllllllllIIlIlllIIIIllIIll != null) {
                lllllllllllllllIIlIlllIIIIllIIll.attackEntityFrom(DamageSource.causeThornsDamage(lllllllllllllllIIlIlllIIIIlIllll), (float)getDamage(lllllllllllllllIIlIlllIIIIlIllIl, lllllllllllllllIIlIlllIIIIllIIIl));
            }
            if (!lllllllllllllllIIlIlllIIIIllIIII.func_190926_b()) {
                lllllllllllllllIIlIlllIIIIllIIII.damageItem(3, lllllllllllllllIIlIlllIIIIlIllll);
            }
        }
        else if (!lllllllllllllllIIlIlllIIIIllIIII.func_190926_b()) {
            lllllllllllllllIIlIlllIIIIllIIII.damageItem(1, lllllllllllllllIIlIlllIIIIlIllll);
        }
    }
    
    public EnchantmentThorns(final Rarity lllllllllllllllIIlIlllIIIlIIllIl, final EntityEquipmentSlot... lllllllllllllllIIlIlllIIIlIIllll) {
        super(lllllllllllllllIIlIlllIIIlIIllIl, EnumEnchantmentType.ARMOR_CHEST, lllllllllllllllIIlIlllIIIlIIllll);
        this.setName("thorns");
    }
    
    @Override
    public int getMinEnchantability(final int lllllllllllllllIIlIlllIIIlIIlIIl) {
        return 10 + 20 * (lllllllllllllllIIlIlllIIIlIIlIIl - 1);
    }
    
    public static boolean shouldHit(final int lllllllllllllllIIlIlllIIIIlIIllI, final Random lllllllllllllllIIlIlllIIIIlIIlll) {
        return lllllllllllllllIIlIlllIIIIlIIllI > 0 && lllllllllllllllIIlIlllIIIIlIIlll.nextFloat() < 0.15f * lllllllllllllllIIlIlllIIIIlIIllI;
    }
}
