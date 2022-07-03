package net.minecraft.enchantment;

import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.init.*;
import net.minecraft.util.math.*;
import net.minecraft.inventory.*;

public class EnchantmentProtection extends Enchantment
{
    public final /* synthetic */ Type protectionType;
    
    @Override
    public int calcModifierDamage(final int lllllllllllllIlIIIllIllllIlllIIl, final DamageSource lllllllllllllIlIIIllIllllIllIIlI) {
        if (lllllllllllllIlIIIllIllllIllIIlI.canHarmInCreative()) {
            return 0;
        }
        if (this.protectionType == Type.ALL) {
            return lllllllllllllIlIIIllIllllIlllIIl;
        }
        if (this.protectionType == Type.FIRE && lllllllllllllIlIIIllIllllIllIIlI.isFireDamage()) {
            return lllllllllllllIlIIIllIllllIlllIIl * 2;
        }
        if (this.protectionType == Type.FALL && lllllllllllllIlIIIllIllllIllIIlI == DamageSource.fall) {
            return lllllllllllllIlIIIllIllllIlllIIl * 3;
        }
        if (this.protectionType == Type.EXPLOSION && lllllllllllllIlIIIllIllllIllIIlI.isExplosion()) {
            return lllllllllllllIlIIIllIllllIlllIIl * 2;
        }
        return (this.protectionType == Type.PROJECTILE && lllllllllllllIlIIIllIllllIllIIlI.isProjectile()) ? (lllllllllllllIlIIIllIllllIlllIIl * 2) : 0;
    }
    
    public static double getBlastDamageReduction(final EntityLivingBase lllllllllllllIlIIIllIlllIllllllI, double lllllllllllllIlIIIllIlllIlllllII) {
        final int lllllllllllllIlIIIllIllllIIIIIII = EnchantmentHelper.getMaxEnchantmentLevel(Enchantments.BLAST_PROTECTION, lllllllllllllIlIIIllIlllIllllllI);
        if (lllllllllllllIlIIIllIllllIIIIIII > 0) {
            lllllllllllllIlIIIllIlllIlllllII -= MathHelper.floor(lllllllllllllIlIIIllIlllIlllllII * (lllllllllllllIlIIIllIllllIIIIIII * 0.15f));
        }
        return lllllllllllllIlIIIllIlllIlllllII;
    }
    
    public boolean canApplyTogether(final Enchantment lllllllllllllIlIIIllIllllIIlllII) {
        if (lllllllllllllIlIIIllIllllIIlllII instanceof EnchantmentProtection) {
            final EnchantmentProtection lllllllllllllIlIIIllIllllIlIIIII = (EnchantmentProtection)lllllllllllllIlIIIllIllllIIlllII;
            return this.protectionType != lllllllllllllIlIIIllIllllIlIIIII.protectionType && (this.protectionType == Type.FALL || lllllllllllllIlIIIllIllllIlIIIII.protectionType == Type.FALL);
        }
        return super.canApplyTogether(lllllllllllllIlIIIllIllllIIlllII);
    }
    
    @Override
    public int getMaxLevel() {
        return 4;
    }
    
    @Override
    public int getMaxEnchantability(final int lllllllllllllIlIIIllIlllllIIlIlI) {
        return this.getMinEnchantability(lllllllllllllIlIIIllIlllllIIlIlI) + this.protectionType.getEnchantIncreasePerLevel();
    }
    
    @Override
    public String getName() {
        return String.valueOf(new StringBuilder("enchantment.protect.").append(this.protectionType.getTypeName()));
    }
    
    public static int getFireTimeForEntity(final EntityLivingBase lllllllllllllIlIIIllIllllIIIllll, int lllllllllllllIlIIIllIllllIIIlIll) {
        final int lllllllllllllIlIIIllIllllIIIllIl = EnchantmentHelper.getMaxEnchantmentLevel(Enchantments.FIRE_PROTECTION, lllllllllllllIlIIIllIllllIIIllll);
        if (lllllllllllllIlIIIllIllllIIIllIl > 0) {
            lllllllllllllIlIIIllIllllIIIlIll -= MathHelper.floor(lllllllllllllIlIIIllIllllIIIlIll * (float)lllllllllllllIlIIIllIllllIIIllIl * 0.15f);
        }
        return lllllllllllllIlIIIllIllllIIIlIll;
    }
    
    public EnchantmentProtection(final Rarity lllllllllllllIlIIIllIllllllIIIIl, final Type lllllllllllllIlIIIllIllllllIIlIl, final EntityEquipmentSlot... lllllllllllllIlIIIllIllllllIIIll) {
        super(lllllllllllllIlIIIllIllllllIIIIl, EnumEnchantmentType.ARMOR, lllllllllllllIlIIIllIllllllIIIll);
        this.protectionType = lllllllllllllIlIIIllIllllllIIlIl;
        if (lllllllllllllIlIIIllIllllllIIlIl == Type.FALL) {
            this.type = EnumEnchantmentType.ARMOR_FEET;
        }
    }
    
    @Override
    public int getMinEnchantability(final int lllllllllllllIlIIIllIlllllIlIIlI) {
        return this.protectionType.getMinimalEnchantability() + (lllllllllllllIlIIIllIlllllIlIIlI - 1) * this.protectionType.getEnchantIncreasePerLevel();
    }
    
    public enum Type
    {
        private final /* synthetic */ int levelCostSpan;
        private final /* synthetic */ String typeName;
        
        PROJECTILE("PROJECTILE", 4, "projectile", 3, 6, 15), 
        FALL("FALL", 2, "fall", 5, 6, 10), 
        ALL("ALL", 0, "all", 1, 11, 20), 
        EXPLOSION("EXPLOSION", 3, "explosion", 5, 8, 12);
        
        private final /* synthetic */ int minEnchantability;
        private final /* synthetic */ int levelCost;
        
        FIRE("FIRE", 1, "fire", 10, 8, 12);
        
        public String getTypeName() {
            return this.typeName;
        }
        
        public int getMinimalEnchantability() {
            return this.minEnchantability;
        }
        
        private Type(final String lllllllllllllIIlIllIIllIIIlIIlII, final int lllllllllllllIIlIllIIllIIIlIIIll, final String lllllllllllllIIlIllIIllIIIlIIIlI, final int lllllllllllllIIlIllIIllIIIlIlIII, final int lllllllllllllIIlIllIIllIIIlIIlll, final int lllllllllllllIIlIllIIllIIIlIIllI) {
            this.typeName = lllllllllllllIIlIllIIllIIIlIIIlI;
            this.minEnchantability = lllllllllllllIIlIllIIllIIIlIlIII;
            this.levelCost = lllllllllllllIIlIllIIllIIIlIIlll;
            this.levelCostSpan = lllllllllllllIIlIllIIllIIIlIIllI;
        }
        
        public int getEnchantIncreasePerLevel() {
            return this.levelCost;
        }
    }
}
