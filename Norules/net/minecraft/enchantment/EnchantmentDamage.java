package net.minecraft.enchantment;

import net.minecraft.entity.*;
import net.minecraft.init.*;
import net.minecraft.potion.*;
import net.minecraft.item.*;
import net.minecraft.inventory.*;

public class EnchantmentDamage extends Enchantment
{
    public final /* synthetic */ int damageType;
    private static final /* synthetic */ int[] BASE_ENCHANTABILITY;
    private static final /* synthetic */ String[] PROTECTION_NAME;
    private static final /* synthetic */ int[] THRESHOLD_ENCHANTABILITY;
    private static final /* synthetic */ int[] LEVEL_ENCHANTABILITY;
    
    @Override
    public float calcDamageByCreature(final int lllllllllllllIIlIlllllllIIllIlIl, final EnumCreatureAttribute lllllllllllllIIlIlllllllIIllIlII) {
        if (this.damageType == 0) {
            return 1.0f + Math.max(0, lllllllllllllIIlIlllllllIIllIlIl - 1) * 0.5f;
        }
        if (this.damageType == 1 && lllllllllllllIIlIlllllllIIllIlII == EnumCreatureAttribute.UNDEAD) {
            return lllllllllllllIIlIlllllllIIllIlIl * 2.5f;
        }
        return (this.damageType == 2 && lllllllllllllIIlIlllllllIIllIlII == EnumCreatureAttribute.ARTHROPOD) ? (lllllllllllllIIlIlllllllIIllIlIl * 2.5f) : 0.0f;
    }
    
    @Override
    public String getName() {
        return String.valueOf(new StringBuilder("enchantment.damage.").append(EnchantmentDamage.PROTECTION_NAME[this.damageType]));
    }
    
    @Override
    public int getMaxLevel() {
        return 5;
    }
    
    public boolean canApplyTogether(final Enchantment lllllllllllllIIlIlllllllIIlIlIlI) {
        return !(lllllllllllllIIlIlllllllIIlIlIlI instanceof EnchantmentDamage);
    }
    
    @Override
    public void onEntityDamaged(final EntityLivingBase lllllllllllllIIlIlllllllIIIlllII, final Entity lllllllllllllIIlIlllllllIIIlIlIl, final int lllllllllllllIIlIlllllllIIIllIlI) {
        if (lllllllllllllIIlIlllllllIIIlIlIl instanceof EntityLivingBase) {
            final EntityLivingBase lllllllllllllIIlIlllllllIIIllIIl = (EntityLivingBase)lllllllllllllIIlIlllllllIIIlIlIl;
            if (this.damageType == 2 && lllllllllllllIIlIlllllllIIIllIIl.getCreatureAttribute() == EnumCreatureAttribute.ARTHROPOD) {
                final int lllllllllllllIIlIlllllllIIIllIII = 20 + lllllllllllllIIlIlllllllIIIlllII.getRNG().nextInt(10 * lllllllllllllIIlIlllllllIIIllIlI);
                lllllllllllllIIlIlllllllIIIllIIl.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, lllllllllllllIIlIlllllllIIIllIII, 3));
            }
        }
    }
    
    @Override
    public boolean canApply(final ItemStack lllllllllllllIIlIlllllllIIlIIlII) {
        return lllllllllllllIIlIlllllllIIlIIlII.getItem() instanceof ItemAxe || super.canApply(lllllllllllllIIlIlllllllIIlIIlII);
    }
    
    @Override
    public int getMaxEnchantability(final int lllllllllllllIIlIlllllllIIllllIl) {
        return this.getMinEnchantability(lllllllllllllIIlIlllllllIIllllIl) + EnchantmentDamage.THRESHOLD_ENCHANTABILITY[this.damageType];
    }
    
    @Override
    public int getMinEnchantability(final int lllllllllllllIIlIlllllllIlIIIIIl) {
        return EnchantmentDamage.BASE_ENCHANTABILITY[this.damageType] + (lllllllllllllIIlIlllllllIlIIIIIl - 1) * EnchantmentDamage.LEVEL_ENCHANTABILITY[this.damageType];
    }
    
    static {
        PROTECTION_NAME = new String[] { "all", "undead", "arthropods" };
        BASE_ENCHANTABILITY = new int[] { 1, 5, 5 };
        LEVEL_ENCHANTABILITY = new int[] { 11, 8, 8 };
        THRESHOLD_ENCHANTABILITY = new int[] { 20, 20, 20 };
    }
    
    public EnchantmentDamage(final Rarity lllllllllllllIIlIlllllllIlIIlIIl, final int lllllllllllllIIlIlllllllIlIIlIII, final EntityEquipmentSlot... lllllllllllllIIlIlllllllIlIIIlll) {
        super(lllllllllllllIIlIlllllllIlIIlIIl, EnumEnchantmentType.WEAPON, lllllllllllllIIlIlllllllIlIIIlll);
        this.damageType = lllllllllllllIIlIlllllllIlIIlIII;
    }
}
