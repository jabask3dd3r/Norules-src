package net.minecraft.entity.boss.dragon.phase;

import javax.annotation.*;
import net.minecraft.entity.item.*;
import net.minecraft.util.math.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;

public interface IPhase
{
    PhaseList<? extends IPhase> getPhaseList();
    
    @Nullable
    Vec3d getTargetLocation();
    
    void onCrystalDestroyed(final EntityEnderCrystal p0, final BlockPos p1, final DamageSource p2, final EntityPlayer p3);
    
    float getAdjustedDamage(final MultiPartEntityPart p0, final DamageSource p1, final float p2);
    
    float getYawFactor();
    
    void doClientRenderEffects();
    
    void doLocalUpdate();
    
    void initPhase();
    
    void removeAreaEffect();
    
    float getMaxRiseOrFall();
    
    boolean getIsStationary();
}
