package net.minecraft.entity.boss.dragon.phase;

import net.minecraft.entity.boss.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.entity.projectile.*;

public abstract class PhaseSittingBase extends PhaseBase
{
    @Override
    public boolean getIsStationary() {
        return true;
    }
    
    public PhaseSittingBase(final EntityDragon lllllllllllllIlllIlIIllIlllllIll) {
        super(lllllllllllllIlllIlIIllIlllllIll);
    }
    
    @Override
    public float getAdjustedDamage(final MultiPartEntityPart lllllllllllllIlllIlIIllIllIlllll, final DamageSource lllllllllllllIlllIlIIllIllIlllIl, final float lllllllllllllIlllIlIIllIllIllIll) {
        if (lllllllllllllIlllIlIIllIllIlllIl.getSourceOfDamage() instanceof EntityArrow) {
            lllllllllllllIlllIlIIllIllIlllIl.getSourceOfDamage().setFire(1);
            return 0.0f;
        }
        return super.getAdjustedDamage(lllllllllllllIlllIlIIllIllIlllll, lllllllllllllIlllIlIIllIllIlllIl, lllllllllllllIlllIlIIllIllIllIll);
    }
}
