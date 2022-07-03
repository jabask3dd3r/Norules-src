package net.minecraft.entity.boss.dragon.phase;

import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.init.*;
import net.minecraft.potion.*;
import net.minecraft.entity.*;
import net.minecraft.entity.boss.*;

public class PhaseSittingFlaming extends PhaseSittingBase
{
    private /* synthetic */ int flameTicks;
    private /* synthetic */ int flameCount;
    private /* synthetic */ EntityAreaEffectCloud areaEffectCloud;
    
    @Override
    public void doClientRenderEffects() {
        ++this.flameTicks;
        if (this.flameTicks % 2 == 0 && this.flameTicks < 10) {
            final Vec3d lllllllllllllIIIIIlllIIIlIIlllll = this.dragon.getHeadLookVec(1.0f).normalize();
            lllllllllllllIIIIIlllIIIlIIlllll.rotateYaw(-0.7853982f);
            final double lllllllllllllIIIIIlllIIIlIIllllI = this.dragon.dragonPartHead.posX;
            final double lllllllllllllIIIIIlllIIIlIIlllIl = this.dragon.dragonPartHead.posY + this.dragon.dragonPartHead.height / 2.0f;
            final double lllllllllllllIIIIIlllIIIlIIlllII = this.dragon.dragonPartHead.posZ;
            for (int lllllllllllllIIIIIlllIIIlIIllIll = 0; lllllllllllllIIIIIlllIIIlIIllIll < 8; ++lllllllllllllIIIIIlllIIIlIIllIll) {
                final double lllllllllllllIIIIIlllIIIlIIllIlI = lllllllllllllIIIIIlllIIIlIIllllI + this.dragon.getRNG().nextGaussian() / 2.0;
                final double lllllllllllllIIIIIlllIIIlIIllIIl = lllllllllllllIIIIIlllIIIlIIlllIl + this.dragon.getRNG().nextGaussian() / 2.0;
                final double lllllllllllllIIIIIlllIIIlIIllIII = lllllllllllllIIIIIlllIIIlIIlllII + this.dragon.getRNG().nextGaussian() / 2.0;
                for (int lllllllllllllIIIIIlllIIIlIIlIlll = 0; lllllllllllllIIIIIlllIIIlIIlIlll < 6; ++lllllllllllllIIIIIlllIIIlIIlIlll) {
                    this.dragon.world.spawnParticle(EnumParticleTypes.DRAGON_BREATH, lllllllllllllIIIIIlllIIIlIIllIlI, lllllllllllllIIIIIlllIIIlIIllIIl, lllllllllllllIIIIIlllIIIlIIllIII, -lllllllllllllIIIIIlllIIIlIIlllll.xCoord * 0.07999999821186066 * lllllllllllllIIIIIlllIIIlIIlIlll, -lllllllllllllIIIIIlllIIIlIIlllll.yCoord * 0.6000000238418579, -lllllllllllllIIIIIlllIIIlIIlllll.zCoord * 0.07999999821186066 * lllllllllllllIIIIIlllIIIlIIlIlll, new int[0]);
                }
                lllllllllllllIIIIIlllIIIlIIlllll.rotateYaw(0.19634955f);
            }
        }
    }
    
    @Override
    public void doLocalUpdate() {
        ++this.flameTicks;
        if (this.flameTicks >= 200) {
            if (this.flameCount >= 4) {
                this.dragon.getPhaseManager().setPhase(PhaseList.TAKEOFF);
            }
            else {
                this.dragon.getPhaseManager().setPhase(PhaseList.SITTING_SCANNING);
            }
        }
        else if (this.flameTicks == 10) {
            final Vec3d lllllllllllllIIIIIlllIIIlIIIIlII = new Vec3d(this.dragon.dragonPartHead.posX - this.dragon.posX, 0.0, this.dragon.dragonPartHead.posZ - this.dragon.posZ).normalize();
            final float lllllllllllllIIIIIlllIIIlIIIIIll = 5.0f;
            final double lllllllllllllIIIIIlllIIIlIIIIIlI = this.dragon.dragonPartHead.posX + lllllllllllllIIIIIlllIIIlIIIIlII.xCoord * 5.0 / 2.0;
            final double lllllllllllllIIIIIlllIIIlIIIIIIl = this.dragon.dragonPartHead.posZ + lllllllllllllIIIIIlllIIIlIIIIlII.zCoord * 5.0 / 2.0;
            double lllllllllllllIIIIIlllIIIlIIIIIII = this.dragon.dragonPartHead.posY + this.dragon.dragonPartHead.height / 2.0f;
            final BlockPos.MutableBlockPos lllllllllllllIIIIIlllIIIIlllllll = new BlockPos.MutableBlockPos(MathHelper.floor(lllllllllllllIIIIIlllIIIlIIIIIlI), MathHelper.floor(lllllllllllllIIIIIlllIIIlIIIIIII), MathHelper.floor(lllllllllllllIIIIIlllIIIlIIIIIIl));
            while (this.dragon.world.isAirBlock(lllllllllllllIIIIIlllIIIIlllllll)) {
                --lllllllllllllIIIIIlllIIIlIIIIIII;
                lllllllllllllIIIIIlllIIIIlllllll.setPos(MathHelper.floor(lllllllllllllIIIIIlllIIIlIIIIIlI), MathHelper.floor(lllllllllllllIIIIIlllIIIlIIIIIII), MathHelper.floor(lllllllllllllIIIIIlllIIIlIIIIIIl));
            }
            lllllllllllllIIIIIlllIIIlIIIIIII = MathHelper.floor(lllllllllllllIIIIIlllIIIlIIIIIII) + 1;
            this.areaEffectCloud = new EntityAreaEffectCloud(this.dragon.world, lllllllllllllIIIIIlllIIIlIIIIIlI, lllllllllllllIIIIIlllIIIlIIIIIII, lllllllllllllIIIIIlllIIIlIIIIIIl);
            this.areaEffectCloud.setOwner(this.dragon);
            this.areaEffectCloud.setRadius(5.0f);
            this.areaEffectCloud.setDuration(200);
            this.areaEffectCloud.setParticle(EnumParticleTypes.DRAGON_BREATH);
            this.areaEffectCloud.addEffect(new PotionEffect(MobEffects.INSTANT_DAMAGE));
            this.dragon.world.spawnEntityInWorld(this.areaEffectCloud);
        }
    }
    
    public PhaseSittingFlaming(final EntityDragon lllllllllllllIIIIIlllIIIlIlIllIl) {
        super(lllllllllllllIIIIIlllIIIlIlIllIl);
    }
    
    public void resetFlameCount() {
        this.flameCount = 0;
    }
    
    @Override
    public PhaseList<PhaseSittingFlaming> getPhaseList() {
        return PhaseList.SITTING_FLAMING;
    }
    
    @Override
    public void initPhase() {
        this.flameTicks = 0;
        ++this.flameCount;
    }
    
    @Override
    public void removeAreaEffect() {
        if (this.areaEffectCloud != null) {
            this.areaEffectCloud.setDead();
            this.areaEffectCloud = null;
        }
    }
}
