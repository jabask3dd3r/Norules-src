package net.minecraft.entity.boss.dragon.phase;

import net.minecraft.entity.boss.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import javax.annotation.*;
import net.minecraft.entity.item.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.player.*;

public abstract class PhaseBase implements IPhase
{
    protected final /* synthetic */ EntityDragon dragon;
    
    @Override
    public boolean getIsStationary() {
        return false;
    }
    
    @Override
    public void doClientRenderEffects() {
    }
    
    @Override
    public float getAdjustedDamage(final MultiPartEntityPart llllllllllllllllllIllllllIIllIlI, final DamageSource llllllllllllllllllIllllllIIllIIl, final float llllllllllllllllllIllllllIIllIII) {
        return llllllllllllllllllIllllllIIllIII;
    }
    
    @Override
    public float getMaxRiseOrFall() {
        return 0.6f;
    }
    
    @Override
    public float getYawFactor() {
        final float llllllllllllllllllIllllllIIlIIlI = MathHelper.sqrt(this.dragon.motionX * this.dragon.motionX + this.dragon.motionZ * this.dragon.motionZ) + 1.0f;
        final float llllllllllllllllllIllllllIIlIIIl = Math.min(llllllllllllllllllIllllllIIlIIlI, 40.0f);
        return 0.7f / llllllllllllllllllIllllllIIlIIIl / llllllllllllllllllIllllllIIlIIlI;
    }
    
    @Override
    public void doLocalUpdate() {
    }
    
    @Override
    public void removeAreaEffect() {
    }
    
    public PhaseBase(final EntityDragon llllllllllllllllllIllllllIlIlIIl) {
        this.dragon = llllllllllllllllllIllllllIlIlIIl;
    }
    
    @Nullable
    @Override
    public Vec3d getTargetLocation() {
        return null;
    }
    
    @Override
    public void initPhase() {
    }
    
    @Override
    public void onCrystalDestroyed(final EntityEnderCrystal llllllllllllllllllIllllllIlIIlII, final BlockPos llllllllllllllllllIllllllIlIIIll, final DamageSource llllllllllllllllllIllllllIlIIIlI, @Nullable final EntityPlayer llllllllllllllllllIllllllIlIIIIl) {
    }
}
