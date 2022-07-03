package net.minecraft.entity.boss.dragon.phase;

import net.minecraft.world.gen.feature.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.boss.*;
import net.minecraft.util.*;
import javax.annotation.*;

public class PhaseDying extends PhaseBase
{
    private /* synthetic */ Vec3d targetLocation;
    private /* synthetic */ int time;
    
    @Override
    public PhaseList<PhaseDying> getPhaseList() {
        return PhaseList.DYING;
    }
    
    @Override
    public float getMaxRiseOrFall() {
        return 3.0f;
    }
    
    @Override
    public void doLocalUpdate() {
        ++this.time;
        if (this.targetLocation == null) {
            final BlockPos llllllllllllIllllIlllllllIIIIIII = this.dragon.world.getHeight(WorldGenEndPodium.END_PODIUM_LOCATION);
            this.targetLocation = new Vec3d(llllllllllllIllllIlllllllIIIIIII.getX(), llllllllllllIllllIlllllllIIIIIII.getY(), llllllllllllIllllIlllllllIIIIIII.getZ());
        }
        final double llllllllllllIllllIllllllIlllllll = this.targetLocation.squareDistanceTo(this.dragon.posX, this.dragon.posY, this.dragon.posZ);
        if (llllllllllllIllllIllllllIlllllll >= 100.0 && llllllllllllIllllIllllllIlllllll <= 22500.0 && !this.dragon.isCollidedHorizontally && !this.dragon.isCollidedVertically) {
            this.dragon.setHealth(1.0f);
        }
        else {
            this.dragon.setHealth(0.0f);
        }
    }
    
    public PhaseDying(final EntityDragon llllllllllllIllllIlllllllIIlIIlI) {
        super(llllllllllllIllllIlllllllIIlIIlI);
    }
    
    @Override
    public void doClientRenderEffects() {
        if (this.time++ % 10 == 0) {
            final float llllllllllllIllllIlllllllIIIlIlI = (this.dragon.getRNG().nextFloat() - 0.5f) * 8.0f;
            final float llllllllllllIllllIlllllllIIIlIIl = (this.dragon.getRNG().nextFloat() - 0.5f) * 4.0f;
            final float llllllllllllIllllIlllllllIIIlIII = (this.dragon.getRNG().nextFloat() - 0.5f) * 8.0f;
            this.dragon.world.spawnParticle(EnumParticleTypes.EXPLOSION_HUGE, this.dragon.posX + llllllllllllIllllIlllllllIIIlIlI, this.dragon.posY + 2.0 + llllllllllllIllllIlllllllIIIlIIl, this.dragon.posZ + llllllllllllIllllIlllllllIIIlIII, 0.0, 0.0, 0.0, new int[0]);
        }
    }
    
    @Override
    public void initPhase() {
        this.targetLocation = null;
        this.time = 0;
    }
    
    @Nullable
    @Override
    public Vec3d getTargetLocation() {
        return this.targetLocation;
    }
}
