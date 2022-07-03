package net.minecraft.util;

import java.util.*;
import javax.annotation.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.text.*;
import net.minecraft.item.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import com.google.common.collect.*;

public class CombatTracker
{
    private final /* synthetic */ List<CombatEntry> combatEntries;
    private final /* synthetic */ EntityLivingBase fighter;
    private /* synthetic */ int combatEndTime;
    private /* synthetic */ boolean takingDamage;
    private /* synthetic */ int lastDamageTime;
    private /* synthetic */ boolean inCombat;
    private /* synthetic */ String fallSuffix;
    private /* synthetic */ int combatStartTime;
    
    public void reset() {
        final int lllllllllllllIIllIlllllIIIIIllll = this.inCombat ? 300 : 100;
        if (this.takingDamage && (!this.fighter.isEntityAlive() || this.fighter.ticksExisted - this.lastDamageTime > lllllllllllllIIllIlllllIIIIIllll)) {
            final boolean lllllllllllllIIllIlllllIIIIIlllI = this.inCombat;
            this.takingDamage = false;
            this.inCombat = false;
            this.combatEndTime = this.fighter.ticksExisted;
            if (lllllllllllllIIllIlllllIIIIIlllI) {
                this.fighter.sendEndCombat();
            }
            this.combatEntries.clear();
        }
    }
    
    private String getFallSuffix(final CombatEntry lllllllllllllIIllIlllllIIIIllIll) {
        return (lllllllllllllIIllIlllllIIIIllIll.getFallSuffix() == null) ? "generic" : lllllllllllllIIllIlllllIIIIllIll.getFallSuffix();
    }
    
    @Nullable
    private CombatEntry getBestCombatEntry() {
        CombatEntry lllllllllllllIIllIlllllIIIlIllII = null;
        CombatEntry lllllllllllllIIllIlllllIIIlIlIll = null;
        float lllllllllllllIIllIlllllIIIlIlIlI = 0.0f;
        float lllllllllllllIIllIlllllIIIlIlIIl = 0.0f;
        for (int lllllllllllllIIllIlllllIIIlIlIII = 0; lllllllllllllIIllIlllllIIIlIlIII < this.combatEntries.size(); ++lllllllllllllIIllIlllllIIIlIlIII) {
            final CombatEntry lllllllllllllIIllIlllllIIIlIIlll = this.combatEntries.get(lllllllllllllIIllIlllllIIIlIlIII);
            final CombatEntry lllllllllllllIIllIlllllIIIlIIllI = (lllllllllllllIIllIlllllIIIlIlIII > 0) ? this.combatEntries.get(lllllllllllllIIllIlllllIIIlIlIII - 1) : null;
            if ((lllllllllllllIIllIlllllIIIlIIlll.getDamageSrc() == DamageSource.fall || lllllllllllllIIllIlllllIIIlIIlll.getDamageSrc() == DamageSource.outOfWorld) && lllllllllllllIIllIlllllIIIlIIlll.getDamageAmount() > 0.0f && (lllllllllllllIIllIlllllIIIlIllII == null || lllllllllllllIIllIlllllIIIlIIlll.getDamageAmount() > lllllllllllllIIllIlllllIIIlIlIIl)) {
                if (lllllllllllllIIllIlllllIIIlIlIII > 0) {
                    lllllllllllllIIllIlllllIIIlIllII = lllllllllllllIIllIlllllIIIlIIllI;
                }
                else {
                    lllllllllllllIIllIlllllIIIlIllII = lllllllllllllIIllIlllllIIIlIIlll;
                }
                lllllllllllllIIllIlllllIIIlIlIIl = lllllllllllllIIllIlllllIIIlIIlll.getDamageAmount();
            }
            if (lllllllllllllIIllIlllllIIIlIIlll.getFallSuffix() != null && (lllllllllllllIIllIlllllIIIlIlIll == null || lllllllllllllIIllIlllllIIIlIIlll.getDamage() > lllllllllllllIIllIlllllIIIlIlIlI)) {
                lllllllllllllIIllIlllllIIIlIlIll = lllllllllllllIIllIlllllIIIlIIlll;
                lllllllllllllIIllIlllllIIIlIlIlI = lllllllllllllIIllIlllllIIIlIIlll.getDamage();
            }
        }
        if (lllllllllllllIIllIlllllIIIlIlIIl > 5.0f && lllllllllllllIIllIlllllIIIlIllII != null) {
            return lllllllllllllIIllIlllllIIIlIllII;
        }
        if (lllllllllllllIIllIlllllIIIlIlIlI > 5.0f && lllllllllllllIIllIlllllIIIlIlIll != null) {
            return lllllllllllllIIllIlllllIIIlIlIll;
        }
        return null;
    }
    
    @Nullable
    public EntityLivingBase getBestAttacker() {
        EntityLivingBase lllllllllllllIIllIlllllIIlIIIIIl = null;
        EntityPlayer lllllllllllllIIllIlllllIIlIIIIII = null;
        float lllllllllllllIIllIlllllIIIllllll = 0.0f;
        float lllllllllllllIIllIlllllIIIlllllI = 0.0f;
        for (final CombatEntry lllllllllllllIIllIlllllIIIllllIl : this.combatEntries) {
            if (lllllllllllllIIllIlllllIIIllllIl.getDamageSrc().getEntity() instanceof EntityPlayer && (lllllllllllllIIllIlllllIIlIIIIII == null || lllllllllllllIIllIlllllIIIllllIl.getDamage() > lllllllllllllIIllIlllllIIIlllllI)) {
                lllllllllllllIIllIlllllIIIlllllI = lllllllllllllIIllIlllllIIIllllIl.getDamage();
                lllllllllllllIIllIlllllIIlIIIIII = (EntityPlayer)lllllllllllllIIllIlllllIIIllllIl.getDamageSrc().getEntity();
            }
            if (lllllllllllllIIllIlllllIIIllllIl.getDamageSrc().getEntity() instanceof EntityLivingBase && (lllllllllllllIIllIlllllIIlIIIIIl == null || lllllllllllllIIllIlllllIIIllllIl.getDamage() > lllllllllllllIIllIlllllIIIllllll)) {
                lllllllllllllIIllIlllllIIIllllll = lllllllllllllIIllIlllllIIIllllIl.getDamage();
                lllllllllllllIIllIlllllIIlIIIIIl = (EntityLivingBase)lllllllllllllIIllIlllllIIIllllIl.getDamageSrc().getEntity();
            }
        }
        if (lllllllllllllIIllIlllllIIlIIIIII != null && lllllllllllllIIllIlllllIIIlllllI >= lllllllllllllIIllIlllllIIIllllll / 3.0f) {
            return lllllllllllllIIllIlllllIIlIIIIII;
        }
        return lllllllllllllIIllIlllllIIlIIIIIl;
    }
    
    public ITextComponent getDeathMessage() {
        if (this.combatEntries.isEmpty()) {
            return new TextComponentTranslation("death.attack.generic", new Object[] { this.fighter.getDisplayName() });
        }
        final CombatEntry lllllllllllllIIllIlllllIIllIIIIl = this.getBestCombatEntry();
        final CombatEntry lllllllllllllIIllIlllllIIllIIIII = this.combatEntries.get(this.combatEntries.size() - 1);
        final ITextComponent lllllllllllllIIllIlllllIIlIlllll = lllllllllllllIIllIlllllIIllIIIII.getDamageSrcDisplayName();
        final Entity lllllllllllllIIllIlllllIIlIllllI = lllllllllllllIIllIlllllIIllIIIII.getDamageSrc().getEntity();
        ITextComponent lllllllllllllIIllIlllllIIlIlIlll = null;
        if (lllllllllllllIIllIlllllIIllIIIIl != null && lllllllllllllIIllIlllllIIllIIIII.getDamageSrc() == DamageSource.fall) {
            final ITextComponent lllllllllllllIIllIlllllIIlIlIllI = lllllllllllllIIllIlllllIIllIIIIl.getDamageSrcDisplayName();
            if (lllllllllllllIIllIlllllIIllIIIIl.getDamageSrc() != DamageSource.fall && lllllllllllllIIllIlllllIIllIIIIl.getDamageSrc() != DamageSource.outOfWorld) {
                if (lllllllllllllIIllIlllllIIlIlIllI != null && (lllllllllllllIIllIlllllIIlIlllll == null || !lllllllllllllIIllIlllllIIlIlIllI.equals(lllllllllllllIIllIlllllIIlIlllll))) {
                    final Entity lllllllllllllIIllIlllllIIlIlIlIl = lllllllllllllIIllIlllllIIllIIIIl.getDamageSrc().getEntity();
                    final ItemStack lllllllllllllIIllIlllllIIlIlIlII = (lllllllllllllIIllIlllllIIlIlIlIl instanceof EntityLivingBase) ? ((EntityLivingBase)lllllllllllllIIllIlllllIIlIlIlIl).getHeldItemMainhand() : ItemStack.field_190927_a;
                    if (!lllllllllllllIIllIlllllIIlIlIlII.func_190926_b() && lllllllllllllIIllIlllllIIlIlIlII.hasDisplayName()) {
                        final ITextComponent lllllllllllllIIllIlllllIIlIlllIl = new TextComponentTranslation("death.fell.assist.item", new Object[] { this.fighter.getDisplayName(), lllllllllllllIIllIlllllIIlIlIllI, lllllllllllllIIllIlllllIIlIlIlII.getTextComponent() });
                    }
                    else {
                        final ITextComponent lllllllllllllIIllIlllllIIlIlllII = new TextComponentTranslation("death.fell.assist", new Object[] { this.fighter.getDisplayName(), lllllllllllllIIllIlllllIIlIlIllI });
                    }
                }
                else if (lllllllllllllIIllIlllllIIlIlllll != null) {
                    final ItemStack lllllllllllllIIllIlllllIIlIlIIll = (lllllllllllllIIllIlllllIIlIllllI instanceof EntityLivingBase) ? ((EntityLivingBase)lllllllllllllIIllIlllllIIlIllllI).getHeldItemMainhand() : ItemStack.field_190927_a;
                    if (!lllllllllllllIIllIlllllIIlIlIIll.func_190926_b() && lllllllllllllIIllIlllllIIlIlIIll.hasDisplayName()) {
                        final ITextComponent lllllllllllllIIllIlllllIIlIllIll = new TextComponentTranslation("death.fell.finish.item", new Object[] { this.fighter.getDisplayName(), lllllllllllllIIllIlllllIIlIlllll, lllllllllllllIIllIlllllIIlIlIIll.getTextComponent() });
                    }
                    else {
                        final ITextComponent lllllllllllllIIllIlllllIIlIllIlI = new TextComponentTranslation("death.fell.finish", new Object[] { this.fighter.getDisplayName(), lllllllllllllIIllIlllllIIlIlllll });
                    }
                }
                else {
                    final ITextComponent lllllllllllllIIllIlllllIIlIllIIl = new TextComponentTranslation("death.fell.killer", new Object[] { this.fighter.getDisplayName() });
                }
            }
            else {
                final ITextComponent lllllllllllllIIllIlllllIIlIllIII = new TextComponentTranslation(String.valueOf(new StringBuilder("death.fell.accident.").append(this.getFallSuffix(lllllllllllllIIllIlllllIIllIIIIl))), new Object[] { this.fighter.getDisplayName() });
            }
        }
        else {
            lllllllllllllIIllIlllllIIlIlIlll = lllllllllllllIIllIlllllIIllIIIII.getDamageSrc().getDeathMessage(this.fighter);
        }
        return lllllllllllllIIllIlllllIIlIlIlll;
    }
    
    public void calculateFallSuffix() {
        this.resetFallSuffix();
        if (this.fighter.isOnLadder()) {
            final Block lllllllllllllIIllIlllllIIlllllIl = this.fighter.world.getBlockState(new BlockPos(this.fighter.posX, this.fighter.getEntityBoundingBox().minY, this.fighter.posZ)).getBlock();
            if (lllllllllllllIIllIlllllIIlllllIl == Blocks.LADDER) {
                this.fallSuffix = "ladder";
            }
            else if (lllllllllllllIIllIlllllIIlllllIl == Blocks.VINE) {
                this.fallSuffix = "vines";
            }
        }
        else if (this.fighter.isInWater()) {
            this.fallSuffix = "water";
        }
    }
    
    private void resetFallSuffix() {
        this.fallSuffix = null;
    }
    
    public EntityLivingBase getFighter() {
        return this.fighter;
    }
    
    public int getCombatDuration() {
        return this.inCombat ? (this.fighter.ticksExisted - this.combatStartTime) : (this.combatEndTime - this.combatStartTime);
    }
    
    public void trackDamage(final DamageSource lllllllllllllIIllIlllllIIlllIlII, final float lllllllllllllIIllIlllllIIlllIIll, final float lllllllllllllIIllIlllllIIlllIIlI) {
        this.reset();
        this.calculateFallSuffix();
        final CombatEntry lllllllllllllIIllIlllllIIlllIIIl = new CombatEntry(lllllllllllllIIllIlllllIIlllIlII, this.fighter.ticksExisted, lllllllllllllIIllIlllllIIlllIIll, lllllllllllllIIllIlllllIIlllIIlI, this.fallSuffix, this.fighter.fallDistance);
        this.combatEntries.add(lllllllllllllIIllIlllllIIlllIIIl);
        this.lastDamageTime = this.fighter.ticksExisted;
        this.takingDamage = true;
        if (lllllllllllllIIllIlllllIIlllIIIl.isLivingDamageSrc() && !this.inCombat && this.fighter.isEntityAlive()) {
            this.inCombat = true;
            this.combatStartTime = this.fighter.ticksExisted;
            this.combatEndTime = this.combatStartTime;
            this.fighter.sendEnterCombat();
        }
    }
    
    public CombatTracker(final EntityLivingBase lllllllllllllIIllIlllllIlIIIIIIl) {
        this.combatEntries = (List<CombatEntry>)Lists.newArrayList();
        this.fighter = lllllllllllllIIllIlllllIlIIIIIIl;
    }
}
