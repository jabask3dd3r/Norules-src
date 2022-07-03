package net.minecraft.entity.boss.dragon.phase;

import net.minecraft.world.gen.feature.*;
import net.minecraft.util.*;
import net.minecraft.entity.boss.*;
import javax.annotation.*;
import net.minecraft.util.math.*;

public class PhaseLanding extends PhaseBase
{
    private /* synthetic */ Vec3d targetLocation;
    
    @Override
    public void doLocalUpdate() {
        if (this.targetLocation == null) {
            this.targetLocation = new Vec3d(this.dragon.world.getTopSolidOrLiquidBlock(WorldGenEndPodium.END_PODIUM_LOCATION));
        }
        if (this.targetLocation.squareDistanceTo(this.dragon.posX, this.dragon.posY, this.dragon.posZ) < 1.0) {
            this.dragon.getPhaseManager().getPhase(PhaseList.SITTING_FLAMING).resetFlameCount();
            this.dragon.getPhaseManager().setPhase(PhaseList.SITTING_SCANNING);
        }
    }
    
    @Override
    public void initPhase() {
        this.targetLocation = null;
    }
    
    @Override
    public PhaseList<PhaseLanding> getPhaseList() {
        return PhaseList.LANDING;
    }
    
    @Override
    public void doClientRenderEffects() {
        final Vec3d lllllllllllllllIllllIIIllllIIIll = this.dragon.getHeadLookVec(1.0f).normalize();
        lllllllllllllllIllllIIIllllIIIll.rotateYaw(-0.7853982f);
        final double lllllllllllllllIllllIIIllllIIIlI = this.dragon.dragonPartHead.posX;
        final double lllllllllllllllIllllIIIllllIIIIl = this.dragon.dragonPartHead.posY + this.dragon.dragonPartHead.height / 2.0f;
        final double lllllllllllllllIllllIIIllllIIIII = this.dragon.dragonPartHead.posZ;
        for (int lllllllllllllllIllllIIIlllIlllll = 0; lllllllllllllllIllllIIIlllIlllll < 8; ++lllllllllllllllIllllIIIlllIlllll) {
            final double lllllllllllllllIllllIIIlllIllllI = lllllllllllllllIllllIIIllllIIIlI + this.dragon.getRNG().nextGaussian() / 2.0;
            final double lllllllllllllllIllllIIIlllIlllIl = lllllllllllllllIllllIIIllllIIIIl + this.dragon.getRNG().nextGaussian() / 2.0;
            final double lllllllllllllllIllllIIIlllIlllII = lllllllllllllllIllllIIIllllIIIII + this.dragon.getRNG().nextGaussian() / 2.0;
            this.dragon.world.spawnParticle(EnumParticleTypes.DRAGON_BREATH, lllllllllllllllIllllIIIlllIllllI, lllllllllllllllIllllIIIlllIlllIl, lllllllllllllllIllllIIIlllIlllII, -lllllllllllllllIllllIIIllllIIIll.xCoord * 0.07999999821186066 + this.dragon.motionX, -lllllllllllllllIllllIIIllllIIIll.yCoord * 0.30000001192092896 + this.dragon.motionY, -lllllllllllllllIllllIIIllllIIIll.zCoord * 0.07999999821186066 + this.dragon.motionZ, new int[0]);
            lllllllllllllllIllllIIIllllIIIll.rotateYaw(0.19634955f);
        }
    }
    
    public PhaseLanding(final EntityDragon lllllllllllllllIllllIIIlllllIIII) {
        super(lllllllllllllllIllllIIIlllllIIII);
    }
    
    @Nullable
    @Override
    public Vec3d getTargetLocation() {
        return this.targetLocation;
    }
    
    @Override
    public float getYawFactor() {
        final float lllllllllllllllIllllIIIlllIIlIlI = MathHelper.sqrt(this.dragon.motionX * this.dragon.motionX + this.dragon.motionZ * this.dragon.motionZ) + 1.0f;
        final float lllllllllllllllIllllIIIlllIIlIIl = Math.min(lllllllllllllllIllllIIIlllIIlIlI, 40.0f);
        return lllllllllllllllIllllIIIlllIIlIIl / lllllllllllllllIllllIIIlllIIlIlI;
    }
    
    @Override
    public float getMaxRiseOrFall() {
        return 1.5f;
    }
}
