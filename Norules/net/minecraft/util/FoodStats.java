package net.minecraft.util;

import net.minecraft.item.*;
import net.minecraft.nbt.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;

public class FoodStats
{
    private /* synthetic */ int foodTimer;
    private /* synthetic */ int foodLevel;
    private /* synthetic */ float foodExhaustionLevel;
    private /* synthetic */ int prevFoodLevel;
    private /* synthetic */ float foodSaturationLevel;
    
    public float getSaturationLevel() {
        return this.foodSaturationLevel;
    }
    
    public void setFoodSaturationLevel(final float lllllllllllllllIIIIllllIlIlIlIII) {
        this.foodSaturationLevel = lllllllllllllllIIIIllllIlIlIlIII;
    }
    
    public FoodStats() {
        this.foodLevel = 20;
        this.foodSaturationLevel = 5.0f;
        this.prevFoodLevel = 20;
    }
    
    public void addStats(final ItemFood lllllllllllllllIIIIllllIlllIIIII, final ItemStack lllllllllllllllIIIIllllIllIlllII) {
        this.addStats(lllllllllllllllIIIIllllIlllIIIII.getHealAmount(lllllllllllllllIIIIllllIllIlllII), lllllllllllllllIIIIllllIlllIIIII.getSaturationModifier(lllllllllllllllIIIIllllIllIlllII));
    }
    
    public void readNBT(final NBTTagCompound lllllllllllllllIIIIllllIllIIlIIl) {
        if (lllllllllllllllIIIIllllIllIIlIIl.hasKey("foodLevel", 99)) {
            this.foodLevel = lllllllllllllllIIIIllllIllIIlIIl.getInteger("foodLevel");
            this.foodTimer = lllllllllllllllIIIIllllIllIIlIIl.getInteger("foodTickTimer");
            this.foodSaturationLevel = lllllllllllllllIIIIllllIllIIlIIl.getFloat("foodSaturationLevel");
            this.foodExhaustionLevel = lllllllllllllllIIIIllllIllIIlIIl.getFloat("foodExhaustionLevel");
        }
    }
    
    public int getFoodLevel() {
        return this.foodLevel;
    }
    
    public void addExhaustion(final float lllllllllllllllIIIIllllIlIllIlll) {
        this.foodExhaustionLevel = Math.min(this.foodExhaustionLevel + lllllllllllllllIIIIllllIlIllIlll, 40.0f);
    }
    
    public void addStats(final int lllllllllllllllIIIIllllIlllIlIIl, final float lllllllllllllllIIIIllllIlllIIlIl) {
        this.foodLevel = Math.min(lllllllllllllllIIIIllllIlllIlIIl + this.foodLevel, 20);
        this.foodSaturationLevel = Math.min(this.foodSaturationLevel + lllllllllllllllIIIIllllIlllIlIIl * lllllllllllllllIIIIllllIlllIIlIl * 2.0f, (float)this.foodLevel);
    }
    
    public void setFoodLevel(final int lllllllllllllllIIIIllllIlIlIllII) {
        this.foodLevel = lllllllllllllllIIIIllllIlIlIllII;
    }
    
    public boolean needFood() {
        return this.foodLevel < 20;
    }
    
    public void onUpdate(final EntityPlayer lllllllllllllllIIIIllllIllIlIIII) {
        final EnumDifficulty lllllllllllllllIIIIllllIllIlIlII = lllllllllllllllIIIIllllIllIlIIII.world.getDifficulty();
        this.prevFoodLevel = this.foodLevel;
        if (this.foodExhaustionLevel > 4.0f) {
            this.foodExhaustionLevel -= 4.0f;
            if (this.foodSaturationLevel > 0.0f) {
                this.foodSaturationLevel = Math.max(this.foodSaturationLevel - 1.0f, 0.0f);
            }
            else if (lllllllllllllllIIIIllllIllIlIlII != EnumDifficulty.PEACEFUL) {
                this.foodLevel = Math.max(this.foodLevel - 1, 0);
            }
        }
        final boolean lllllllllllllllIIIIllllIllIlIIll = lllllllllllllllIIIIllllIllIlIIII.world.getGameRules().getBoolean("naturalRegeneration");
        if (lllllllllllllllIIIIllllIllIlIIll && this.foodSaturationLevel > 0.0f && lllllllllllllllIIIIllllIllIlIIII.shouldHeal() && this.foodLevel >= 20) {
            ++this.foodTimer;
            if (this.foodTimer >= 10) {
                final float lllllllllllllllIIIIllllIllIlIIlI = Math.min(this.foodSaturationLevel, 6.0f);
                lllllllllllllllIIIIllllIllIlIIII.heal(lllllllllllllllIIIIllllIllIlIIlI / 6.0f);
                this.addExhaustion(lllllllllllllllIIIIllllIllIlIIlI);
                this.foodTimer = 0;
            }
        }
        else if (lllllllllllllllIIIIllllIllIlIIll && this.foodLevel >= 18 && lllllllllllllllIIIIllllIllIlIIII.shouldHeal()) {
            ++this.foodTimer;
            if (this.foodTimer >= 80) {
                lllllllllllllllIIIIllllIllIlIIII.heal(1.0f);
                this.addExhaustion(6.0f);
                this.foodTimer = 0;
            }
        }
        else if (this.foodLevel <= 0) {
            ++this.foodTimer;
            if (this.foodTimer >= 80) {
                if (lllllllllllllllIIIIllllIllIlIIII.getHealth() > 10.0f || lllllllllllllllIIIIllllIllIlIlII == EnumDifficulty.HARD || (lllllllllllllllIIIIllllIllIlIIII.getHealth() > 1.0f && lllllllllllllllIIIIllllIllIlIlII == EnumDifficulty.NORMAL)) {
                    lllllllllllllllIIIIllllIllIlIIII.attackEntityFrom(DamageSource.starve, 1.0f);
                }
                this.foodTimer = 0;
            }
        }
        else {
            this.foodTimer = 0;
        }
    }
    
    public void writeNBT(final NBTTagCompound lllllllllllllllIIIIllllIllIIIIll) {
        lllllllllllllllIIIIllllIllIIIIll.setInteger("foodLevel", this.foodLevel);
        lllllllllllllllIIIIllllIllIIIIll.setInteger("foodTickTimer", this.foodTimer);
        lllllllllllllllIIIIllllIllIIIIll.setFloat("foodSaturationLevel", this.foodSaturationLevel);
        lllllllllllllllIIIIllllIllIIIIll.setFloat("foodExhaustionLevel", this.foodExhaustionLevel);
    }
}
