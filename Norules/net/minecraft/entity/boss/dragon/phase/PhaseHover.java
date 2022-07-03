package net.minecraft.entity.boss.dragon.phase;

import net.minecraft.util.math.*;
import net.minecraft.entity.boss.*;
import javax.annotation.*;

public class PhaseHover extends PhaseBase
{
    private /* synthetic */ Vec3d targetLocation;
    
    public PhaseHover(final EntityDragon lIIlIIIlllIlIll) {
        super(lIIlIIIlllIlIll);
    }
    
    @Override
    public void doLocalUpdate() {
        if (this.targetLocation == null) {
            this.targetLocation = new Vec3d(this.dragon.posX, this.dragon.posY, this.dragon.posZ);
        }
    }
    
    @Override
    public float getMaxRiseOrFall() {
        return 1.0f;
    }
    
    @Override
    public boolean getIsStationary() {
        return true;
    }
    
    @Override
    public PhaseList<PhaseHover> getPhaseList() {
        return PhaseList.HOVER;
    }
    
    @Nullable
    @Override
    public Vec3d getTargetLocation() {
        return this.targetLocation;
    }
    
    @Override
    public void initPhase() {
        this.targetLocation = null;
    }
}
