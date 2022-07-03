package net.minecraft.client.particle;

import net.minecraft.crash.*;
import net.minecraft.block.state.*;
import net.minecraft.entity.*;
import optifine.*;
import javax.annotation.*;
import net.minecraft.block.material.*;
import net.minecraft.world.*;
import net.minecraft.block.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import com.google.common.collect.*;
import java.util.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.client.renderer.vertex.*;

public class ParticleManager
{
    private final /* synthetic */ Random rand;
    private final /* synthetic */ Map<Integer, IParticleFactory> particleTypes;
    private final /* synthetic */ TextureManager renderer;
    private static final /* synthetic */ ResourceLocation PARTICLE_TEXTURES;
    private final /* synthetic */ Queue<ParticleEmitter> particleEmitters;
    private final /* synthetic */ Queue<Particle> queueEntityFX;
    private final /* synthetic */ ArrayDeque<Particle>[][] fxLayers;
    protected /* synthetic */ World worldObj;
    
    private void tickParticle(final Particle lllllllllllllllIllIIlIIIIlIIlIII) {
        try {
            lllllllllllllllIllIIlIIIIlIIlIII.onUpdate();
        }
        catch (Throwable lllllllllllllllIllIIlIIIIlIIllIl) {
            final CrashReport lllllllllllllllIllIIlIIIIlIIllII = CrashReport.makeCrashReport(lllllllllllllllIllIIlIIIIlIIllIl, "Ticking Particle");
            final CrashReportCategory lllllllllllllllIllIIlIIIIlIIlIll = lllllllllllllllIllIIlIIIIlIIllII.makeCategory("Particle being ticked");
            final int lllllllllllllllIllIIlIIIIlIIlIlI = lllllllllllllllIllIIlIIIIlIIlIII.getFXLayer();
            lllllllllllllllIllIIlIIIIlIIlIll.setDetail("Particle", new ICrashReportDetail<String>() {
                @Override
                public String call() throws Exception {
                    return lllllllllllllllIllIIlIIIIlIIlIII.toString();
                }
            });
            lllllllllllllllIllIIlIIIIlIIlIll.setDetail("Particle Type", new ICrashReportDetail<String>() {
                @Override
                public String call() throws Exception {
                    if (lllllllllllllllIllIIlIIIIlIIlIlI == 0) {
                        return "MISC_TEXTURE";
                    }
                    if (lllllllllllllllIllIIlIIIIlIIlIlI == 1) {
                        return "TERRAIN_TEXTURE";
                    }
                    return (lllllllllllllllIllIIlIIIIlIIlIlI == 3) ? "ENTITY_PARTICLE_TEXTURE" : String.valueOf(new StringBuilder("Unknown - ").append(lllllllllllllllIllIIlIIIIlIIlIlI));
                }
            });
            throw new ReportedException(lllllllllllllllIllIIlIIIIlIIllII);
        }
    }
    
    private void updateEffectLayer(final int lllllllllllllllIllIIlIIIIllIIIll) {
        this.worldObj.theProfiler.startSection(String.valueOf(lllllllllllllllIllIIlIIIIllIIIll));
        for (int lllllllllllllllIllIIlIIIIllIIlIl = 0; lllllllllllllllIllIIlIIIIllIIlIl < 2; ++lllllllllllllllIllIIlIIIIllIIlIl) {
            this.worldObj.theProfiler.startSection(String.valueOf(lllllllllllllllIllIIlIIIIllIIlIl));
            this.tickParticleList(this.fxLayers[lllllllllllllllIllIIlIIIIllIIIll][lllllllllllllllIllIIlIIIIllIIlIl]);
            this.worldObj.theProfiler.endSection();
        }
        this.worldObj.theProfiler.endSection();
    }
    
    public void addBlockHitEffects(final BlockPos lllllllllllllllIllIIIlllIlllIIIl, final RayTraceResult lllllllllllllllIllIIIlllIllIlIll) {
        final IBlockState lllllllllllllllIllIIIlllIllIllll = this.worldObj.getBlockState(lllllllllllllllIllIIIlllIlllIIIl);
        if (lllllllllllllllIllIIIlllIllIllll != null) {
            final boolean lllllllllllllllIllIIIlllIllIlllI = Reflector.callBoolean(lllllllllllllllIllIIIlllIllIllll.getBlock(), Reflector.ForgeBlock_addHitEffects, lllllllllllllllIllIIIlllIllIllll, this.worldObj, lllllllllllllllIllIIIlllIllIlIll, this);
            if (lllllllllllllllIllIIIlllIllIllll != null && !lllllllllllllllIllIIIlllIllIlllI) {
                this.addBlockHitEffects(lllllllllllllllIllIIIlllIlllIIIl, lllllllllllllllIllIIIlllIllIlIll.sideHit);
            }
        }
    }
    
    private void tickParticleList(final Queue<Particle> lllllllllllllllIllIIlIIIIlIllIII) {
        if (!lllllllllllllllIllIIlIIIIlIllIII.isEmpty()) {
            final Iterator<Particle> lllllllllllllllIllIIlIIIIlIllIll = lllllllllllllllIllIIlIIIIlIllIII.iterator();
            while (lllllllllllllllIllIIlIIIIlIllIll.hasNext()) {
                final Particle lllllllllllllllIllIIlIIIIlIllIlI = lllllllllllllllIllIIlIIIIlIllIll.next();
                this.tickParticle(lllllllllllllllIllIIlIIIIlIllIlI);
                if (!lllllllllllllllIllIIlIIIIlIllIlI.isAlive()) {
                    lllllllllllllllIllIIlIIIIlIllIll.remove();
                }
            }
        }
    }
    
    public void func_191271_a(final Entity lllllllllllllllIllIIlIIIlIlIIlll, final EnumParticleTypes lllllllllllllllIllIIlIIIlIlIIIlI, final int lllllllllllllllIllIIlIIIlIlIIIIl) {
        this.particleEmitters.add(new ParticleEmitter(this.worldObj, lllllllllllllllIllIIlIIIlIlIIlll, lllllllllllllllIllIIlIIIlIlIIIlI, lllllllllllllllIllIIlIIIlIlIIIIl));
    }
    
    private void registerVanillaParticles() {
        this.registerParticle(EnumParticleTypes.EXPLOSION_NORMAL.getParticleID(), new ParticleExplosion.Factory());
        this.registerParticle(EnumParticleTypes.SPIT.getParticleID(), new ParticleSpit.Factory());
        this.registerParticle(EnumParticleTypes.WATER_BUBBLE.getParticleID(), new ParticleBubble.Factory());
        this.registerParticle(EnumParticleTypes.WATER_SPLASH.getParticleID(), new ParticleSplash.Factory());
        this.registerParticle(EnumParticleTypes.WATER_WAKE.getParticleID(), new ParticleWaterWake.Factory());
        this.registerParticle(EnumParticleTypes.WATER_DROP.getParticleID(), new ParticleRain.Factory());
        this.registerParticle(EnumParticleTypes.SUSPENDED.getParticleID(), new ParticleSuspend.Factory());
        this.registerParticle(EnumParticleTypes.SUSPENDED_DEPTH.getParticleID(), new ParticleSuspendedTown.Factory());
        this.registerParticle(EnumParticleTypes.CRIT.getParticleID(), new ParticleCrit.Factory());
        this.registerParticle(EnumParticleTypes.CRIT_MAGIC.getParticleID(), new ParticleCrit.MagicFactory());
        this.registerParticle(EnumParticleTypes.SMOKE_NORMAL.getParticleID(), new ParticleSmokeNormal.Factory());
        this.registerParticle(EnumParticleTypes.SMOKE_LARGE.getParticleID(), new ParticleSmokeLarge.Factory());
        this.registerParticle(EnumParticleTypes.SPELL.getParticleID(), new ParticleSpell.Factory());
        this.registerParticle(EnumParticleTypes.SPELL_INSTANT.getParticleID(), new ParticleSpell.InstantFactory());
        this.registerParticle(EnumParticleTypes.SPELL_MOB.getParticleID(), new ParticleSpell.MobFactory());
        this.registerParticle(EnumParticleTypes.SPELL_MOB_AMBIENT.getParticleID(), new ParticleSpell.AmbientMobFactory());
        this.registerParticle(EnumParticleTypes.SPELL_WITCH.getParticleID(), new ParticleSpell.WitchFactory());
        this.registerParticle(EnumParticleTypes.DRIP_WATER.getParticleID(), new ParticleDrip.WaterFactory());
        this.registerParticle(EnumParticleTypes.DRIP_LAVA.getParticleID(), new ParticleDrip.LavaFactory());
        this.registerParticle(EnumParticleTypes.VILLAGER_ANGRY.getParticleID(), new ParticleHeart.AngryVillagerFactory());
        this.registerParticle(EnumParticleTypes.VILLAGER_HAPPY.getParticleID(), new ParticleSuspendedTown.HappyVillagerFactory());
        this.registerParticle(EnumParticleTypes.TOWN_AURA.getParticleID(), new ParticleSuspendedTown.Factory());
        this.registerParticle(EnumParticleTypes.NOTE.getParticleID(), new ParticleNote.Factory());
        this.registerParticle(EnumParticleTypes.PORTAL.getParticleID(), new ParticlePortal.Factory());
        this.registerParticle(EnumParticleTypes.ENCHANTMENT_TABLE.getParticleID(), new ParticleEnchantmentTable.EnchantmentTable());
        this.registerParticle(EnumParticleTypes.FLAME.getParticleID(), new ParticleFlame.Factory());
        this.registerParticle(EnumParticleTypes.LAVA.getParticleID(), new ParticleLava.Factory());
        this.registerParticle(EnumParticleTypes.FOOTSTEP.getParticleID(), new ParticleFootStep.Factory());
        this.registerParticle(EnumParticleTypes.CLOUD.getParticleID(), new ParticleCloud.Factory());
        this.registerParticle(EnumParticleTypes.REDSTONE.getParticleID(), new ParticleRedstone.Factory());
        this.registerParticle(EnumParticleTypes.FALLING_DUST.getParticleID(), new ParticleFallingDust.Factory());
        this.registerParticle(EnumParticleTypes.SNOWBALL.getParticleID(), new ParticleBreaking.SnowballFactory());
        this.registerParticle(EnumParticleTypes.SNOW_SHOVEL.getParticleID(), new ParticleSnowShovel.Factory());
        this.registerParticle(EnumParticleTypes.SLIME.getParticleID(), new ParticleBreaking.SlimeFactory());
        this.registerParticle(EnumParticleTypes.HEART.getParticleID(), new ParticleHeart.Factory());
        this.registerParticle(EnumParticleTypes.BARRIER.getParticleID(), new Barrier.Factory());
        this.registerParticle(EnumParticleTypes.ITEM_CRACK.getParticleID(), new ParticleBreaking.Factory());
        this.registerParticle(EnumParticleTypes.BLOCK_CRACK.getParticleID(), new ParticleDigging.Factory());
        this.registerParticle(EnumParticleTypes.BLOCK_DUST.getParticleID(), new ParticleBlockDust.Factory());
        this.registerParticle(EnumParticleTypes.EXPLOSION_HUGE.getParticleID(), new ParticleExplosionHuge.Factory());
        this.registerParticle(EnumParticleTypes.EXPLOSION_LARGE.getParticleID(), new ParticleExplosionLarge.Factory());
        this.registerParticle(EnumParticleTypes.FIREWORKS_SPARK.getParticleID(), new ParticleFirework.Factory());
        this.registerParticle(EnumParticleTypes.MOB_APPEARANCE.getParticleID(), new ParticleMobAppearance.Factory());
        this.registerParticle(EnumParticleTypes.DRAGON_BREATH.getParticleID(), new ParticleDragonBreath.Factory());
        this.registerParticle(EnumParticleTypes.END_ROD.getParticleID(), new ParticleEndRod.Factory());
        this.registerParticle(EnumParticleTypes.DAMAGE_INDICATOR.getParticleID(), new ParticleCrit.DamageIndicatorFactory());
        this.registerParticle(EnumParticleTypes.SWEEP_ATTACK.getParticleID(), new ParticleSweepAttack.Factory());
        this.registerParticle(EnumParticleTypes.TOTEM.getParticleID(), new ParticleTotem.Factory());
    }
    
    public void emitParticleAtEntity(final Entity lllllllllllllllIllIIlIIIlIllIIIl, final EnumParticleTypes lllllllllllllllIllIIlIIIlIllIIII) {
        this.particleEmitters.add(new ParticleEmitter(this.worldObj, lllllllllllllllIllIIlIIIlIllIIIl, lllllllllllllllIllIIlIIIlIllIIII));
    }
    
    static {
        PARTICLE_TEXTURES = new ResourceLocation("textures/particle/particles.png");
    }
    
    public void addEffect(final Particle lllllllllllllllIllIIlIIIIllllIlI) {
        if (lllllllllllllllIllIIlIIIIllllIlI != null && (!(lllllllllllllllIllIIlIIIIllllIlI instanceof ParticleFirework.Spark) || Config.isFireworkParticles())) {
            this.queueEntityFX.add(lllllllllllllllIllIIlIIIIllllIlI);
        }
    }
    
    private boolean reuseBarrierParticle(final Particle lllllllllllllllIllIIIlllIllllIll, final ArrayDeque<Particle> lllllllllllllllIllIIIlllIllllIlI) {
        for (final Particle lllllllllllllllIllIIIlllIlllllII : lllllllllllllllIllIIIlllIllllIlI) {
            if (lllllllllllllllIllIIIlllIlllllII instanceof Barrier && lllllllllllllllIllIIIlllIllllIll.prevPosX == lllllllllllllllIllIIIlllIlllllII.prevPosX && lllllllllllllllIllIIIlllIllllIll.prevPosY == lllllllllllllllIllIIIlllIlllllII.prevPosY && lllllllllllllllIllIIIlllIllllIll.prevPosZ == lllllllllllllllIllIIIlllIlllllII.prevPosZ) {
                lllllllllllllllIllIIIlllIlllllII.particleAge = 0;
                return true;
            }
        }
        return false;
    }
    
    public void clearEffects(@Nullable final World lllllllllllllllIllIIIlllllIlllIl) {
        this.worldObj = lllllllllllllllIllIIIlllllIlllIl;
        for (int lllllllllllllllIllIIIlllllIlllII = 0; lllllllllllllllIllIIIlllllIlllII < 4; ++lllllllllllllllIllIIIlllllIlllII) {
            for (int lllllllllllllllIllIIIlllllIllIll = 0; lllllllllllllllIllIIIlllllIllIll < 2; ++lllllllllllllllIllIIIlllllIllIll) {
                this.fxLayers[lllllllllllllllIllIIIlllllIlllII][lllllllllllllllIllIIIlllllIllIll].clear();
            }
        }
        this.particleEmitters.clear();
    }
    
    public void renderLitParticles(final Entity lllllllllllllllIllIIIllllllllllI, final float lllllllllllllllIllIIIllllllIllll) {
        final float lllllllllllllllIllIIIlllllllllII = 0.017453292f;
        final float lllllllllllllllIllIIIllllllllIll = MathHelper.cos(lllllllllllllllIllIIIllllllllllI.rotationYaw * 0.017453292f);
        final float lllllllllllllllIllIIIllllllllIlI = MathHelper.sin(lllllllllllllllIllIIIllllllllllI.rotationYaw * 0.017453292f);
        final float lllllllllllllllIllIIIllllllllIIl = -lllllllllllllllIllIIIllllllllIlI * MathHelper.sin(lllllllllllllllIllIIIllllllllllI.rotationPitch * 0.017453292f);
        final float lllllllllllllllIllIIIllllllllIII = lllllllllllllllIllIIIllllllllIll * MathHelper.sin(lllllllllllllllIllIIIllllllllllI.rotationPitch * 0.017453292f);
        final float lllllllllllllllIllIIIlllllllIlll = MathHelper.cos(lllllllllllllllIllIIIllllllllllI.rotationPitch * 0.017453292f);
        for (int lllllllllllllllIllIIIlllllllIllI = 0; lllllllllllllllIllIIIlllllllIllI < 2; ++lllllllllllllllIllIIIlllllllIllI) {
            final Queue<Particle> lllllllllllllllIllIIIlllllllIlIl = this.fxLayers[3][lllllllllllllllIllIIIlllllllIllI];
            if (!lllllllllllllllIllIIIlllllllIlIl.isEmpty()) {
                final Tessellator lllllllllllllllIllIIIlllllllIlII = Tessellator.getInstance();
                final BufferBuilder lllllllllllllllIllIIIlllllllIIll = lllllllllllllllIllIIIlllllllIlII.getBuffer();
                for (final Particle lllllllllllllllIllIIIlllllllIIlI : lllllllllllllllIllIIIlllllllIlIl) {
                    lllllllllllllllIllIIIlllllllIIlI.renderParticle(lllllllllllllllIllIIIlllllllIIll, lllllllllllllllIllIIIllllllllllI, lllllllllllllllIllIIIllllllIllll, lllllllllllllllIllIIIllllllllIll, lllllllllllllllIllIIIlllllllIlll, lllllllllllllllIllIIIllllllllIlI, lllllllllllllllIllIIIllllllllIIl, lllllllllllllllIllIIIllllllllIII);
                }
            }
        }
    }
    
    public void addBlockDestroyEffects(final BlockPos lllllllllllllllIllIIIlllllIIlIlI, IBlockState lllllllllllllllIllIIIllllIllllII) {
        boolean lllllllllllllllIllIIIlllllIIIlll = false;
        if (Reflector.ForgeBlock_addDestroyEffects.exists() && Reflector.ForgeBlock_isAir.exists()) {
            final Block lllllllllllllllIllIIIlllllIIIllI = lllllllllllllllIllIIIllllIllllII.getBlock();
            final boolean lllllllllllllllIllIIIlllllIIlIII = !Reflector.callBoolean(lllllllllllllllIllIIIlllllIIIllI, Reflector.ForgeBlock_isAir, lllllllllllllllIllIIIllllIllllII, this.worldObj, lllllllllllllllIllIIIlllllIIlIlI) && !Reflector.callBoolean(lllllllllllllllIllIIIlllllIIIllI, Reflector.ForgeBlock_addDestroyEffects, this.worldObj, lllllllllllllllIllIIIlllllIIlIlI, this);
        }
        else {
            lllllllllllllllIllIIIlllllIIIlll = (lllllllllllllllIllIIIllllIllllII.getMaterial() != Material.AIR);
        }
        if (lllllllllllllllIllIIIlllllIIIlll) {
            lllllllllllllllIllIIIllllIllllII = lllllllllllllllIllIIIllllIllllII.getActualState(this.worldObj, lllllllllllllllIllIIIlllllIIlIlI);
            final int lllllllllllllllIllIIIlllllIIIlIl = 4;
            for (int lllllllllllllllIllIIIlllllIIIlII = 0; lllllllllllllllIllIIIlllllIIIlII < 4; ++lllllllllllllllIllIIIlllllIIIlII) {
                for (int lllllllllllllllIllIIIlllllIIIIll = 0; lllllllllllllllIllIIIlllllIIIIll < 4; ++lllllllllllllllIllIIIlllllIIIIll) {
                    for (int lllllllllllllllIllIIIlllllIIIIlI = 0; lllllllllllllllIllIIIlllllIIIIlI < 4; ++lllllllllllllllIllIIIlllllIIIIlI) {
                        final double lllllllllllllllIllIIIlllllIIIIIl = (lllllllllllllllIllIIIlllllIIIlII + 0.5) / 4.0;
                        final double lllllllllllllllIllIIIlllllIIIIII = (lllllllllllllllIllIIIlllllIIIIll + 0.5) / 4.0;
                        final double lllllllllllllllIllIIIllllIllllll = (lllllllllllllllIllIIIlllllIIIIlI + 0.5) / 4.0;
                        this.addEffect(new ParticleDigging(this.worldObj, lllllllllllllllIllIIIlllllIIlIlI.getX() + lllllllllllllllIllIIIlllllIIIIIl, lllllllllllllllIllIIIlllllIIlIlI.getY() + lllllllllllllllIllIIIlllllIIIIII, lllllllllllllllIllIIIlllllIIlIlI.getZ() + lllllllllllllllIllIIIllllIllllll, lllllllllllllllIllIIIlllllIIIIIl - 0.5, lllllllllllllllIllIIIlllllIIIIII - 0.5, lllllllllllllllIllIIIllllIllllll - 0.5, lllllllllllllllIllIIIllllIllllII).setBlockPos(lllllllllllllllIllIIIlllllIIlIlI));
                    }
                }
            }
        }
    }
    
    public void addBlockHitEffects(final BlockPos lllllllllllllllIllIIIllllIlIIllI, final EnumFacing lllllllllllllllIllIIIllllIlIIlIl) {
        final IBlockState lllllllllllllllIllIIIllllIlIIlII = this.worldObj.getBlockState(lllllllllllllllIllIIIllllIlIIllI);
        if (lllllllllllllllIllIIIllllIlIIlII.getRenderType() != EnumBlockRenderType.INVISIBLE) {
            final int lllllllllllllllIllIIIllllIlIIIll = lllllllllllllllIllIIIllllIlIIllI.getX();
            final int lllllllllllllllIllIIIllllIlIIIlI = lllllllllllllllIllIIIllllIlIIllI.getY();
            final int lllllllllllllllIllIIIllllIlIIIIl = lllllllllllllllIllIIIllllIlIIllI.getZ();
            final float lllllllllllllllIllIIIllllIlIIIII = 0.1f;
            final AxisAlignedBB lllllllllllllllIllIIIllllIIlllll = lllllllllllllllIllIIIllllIlIIlII.getBoundingBox(this.worldObj, lllllllllllllllIllIIIllllIlIIllI);
            double lllllllllllllllIllIIIllllIIllllI = lllllllllllllllIllIIIllllIlIIIll + this.rand.nextDouble() * (lllllllllllllllIllIIIllllIIlllll.maxX - lllllllllllllllIllIIIllllIIlllll.minX - 0.20000000298023224) + 0.10000000149011612 + lllllllllllllllIllIIIllllIIlllll.minX;
            double lllllllllllllllIllIIIllllIIlllIl = lllllllllllllllIllIIIllllIlIIIlI + this.rand.nextDouble() * (lllllllllllllllIllIIIllllIIlllll.maxY - lllllllllllllllIllIIIllllIIlllll.minY - 0.20000000298023224) + 0.10000000149011612 + lllllllllllllllIllIIIllllIIlllll.minY;
            double lllllllllllllllIllIIIllllIIlllII = lllllllllllllllIllIIIllllIlIIIIl + this.rand.nextDouble() * (lllllllllllllllIllIIIllllIIlllll.maxZ - lllllllllllllllIllIIIllllIIlllll.minZ - 0.20000000298023224) + 0.10000000149011612 + lllllllllllllllIllIIIllllIIlllll.minZ;
            if (lllllllllllllllIllIIIllllIlIIlIl == EnumFacing.DOWN) {
                lllllllllllllllIllIIIllllIIlllIl = lllllllllllllllIllIIIllllIlIIIlI + lllllllllllllllIllIIIllllIIlllll.minY - 0.10000000149011612;
            }
            if (lllllllllllllllIllIIIllllIlIIlIl == EnumFacing.UP) {
                lllllllllllllllIllIIIllllIIlllIl = lllllllllllllllIllIIIllllIlIIIlI + lllllllllllllllIllIIIllllIIlllll.maxY + 0.10000000149011612;
            }
            if (lllllllllllllllIllIIIllllIlIIlIl == EnumFacing.NORTH) {
                lllllllllllllllIllIIIllllIIlllII = lllllllllllllllIllIIIllllIlIIIIl + lllllllllllllllIllIIIllllIIlllll.minZ - 0.10000000149011612;
            }
            if (lllllllllllllllIllIIIllllIlIIlIl == EnumFacing.SOUTH) {
                lllllllllllllllIllIIIllllIIlllII = lllllllllllllllIllIIIllllIlIIIIl + lllllllllllllllIllIIIllllIIlllll.maxZ + 0.10000000149011612;
            }
            if (lllllllllllllllIllIIIllllIlIIlIl == EnumFacing.WEST) {
                lllllllllllllllIllIIIllllIIllllI = lllllllllllllllIllIIIllllIlIIIll + lllllllllllllllIllIIIllllIIlllll.minX - 0.10000000149011612;
            }
            if (lllllllllllllllIllIIIllllIlIIlIl == EnumFacing.EAST) {
                lllllllllllllllIllIIIllllIIllllI = lllllllllllllllIllIIIllllIlIIIll + lllllllllllllllIllIIIllllIIlllll.maxX + 0.10000000149011612;
            }
            this.addEffect(new ParticleDigging(this.worldObj, lllllllllllllllIllIIIllllIIllllI, lllllllllllllllIllIIIllllIIlllIl, lllllllllllllllIllIIIllllIIlllII, 0.0, 0.0, 0.0, lllllllllllllllIllIIIllllIlIIlII).setBlockPos(lllllllllllllllIllIIIllllIlIIllI).multiplyVelocity(0.2f).multipleParticleScaleBy(0.6f));
        }
    }
    
    public ParticleManager(final World lllllllllllllllIllIIlIIIllIIIlIl, final TextureManager lllllllllllllllIllIIlIIIllIIIlII) {
        this.fxLayers = (ArrayDeque<Particle>[][])new ArrayDeque[4][];
        this.particleEmitters = (Queue<ParticleEmitter>)Queues.newArrayDeque();
        this.rand = new Random();
        this.particleTypes = (Map<Integer, IParticleFactory>)Maps.newHashMap();
        this.queueEntityFX = (Queue<Particle>)Queues.newArrayDeque();
        this.worldObj = lllllllllllllllIllIIlIIIllIIIlIl;
        this.renderer = lllllllllllllllIllIIlIIIllIIIlII;
        for (int lllllllllllllllIllIIlIIIllIIlIII = 0; lllllllllllllllIllIIlIIIllIIlIII < 4; ++lllllllllllllllIllIIlIIIllIIlIII) {
            this.fxLayers[lllllllllllllllIllIIlIIIllIIlIII] = (ArrayDeque<Particle>[])new ArrayDeque[2];
            for (int lllllllllllllllIllIIlIIIllIIIlll = 0; lllllllllllllllIllIIlIIIllIIIlll < 2; ++lllllllllllllllIllIIlIIIllIIIlll) {
                this.fxLayers[lllllllllllllllIllIIlIIIllIIlIII][lllllllllllllllIllIIlIIIllIIIlll] = (ArrayDeque<Particle>)Queues.newArrayDeque();
            }
        }
        this.registerVanillaParticles();
    }
    
    public void updateEffects() {
        for (int lllllllllllllllIllIIlIIIIlllIlII = 0; lllllllllllllllIllIIlIIIIlllIlII < 4; ++lllllllllllllllIllIIlIIIIlllIlII) {
            this.updateEffectLayer(lllllllllllllllIllIIlIIIIlllIlII);
        }
        if (!this.particleEmitters.isEmpty()) {
            final List<ParticleEmitter> lllllllllllllllIllIIlIIIIlllIIll = (List<ParticleEmitter>)Lists.newArrayList();
            for (final ParticleEmitter lllllllllllllllIllIIlIIIIlllIIlI : this.particleEmitters) {
                lllllllllllllllIllIIlIIIIlllIIlI.onUpdate();
                if (!lllllllllllllllIllIIlIIIIlllIIlI.isAlive()) {
                    lllllllllllllllIllIIlIIIIlllIIll.add(lllllllllllllllIllIIlIIIIlllIIlI);
                }
            }
            this.particleEmitters.removeAll(lllllllllllllllIllIIlIIIIlllIIll);
        }
        if (!this.queueEntityFX.isEmpty()) {
            for (Particle lllllllllllllllIllIIlIIIIlllIIIl = this.queueEntityFX.poll(); lllllllllllllllIllIIlIIIIlllIIIl != null; lllllllllllllllIllIIlIIIIlllIIIl = this.queueEntityFX.poll()) {
                final int lllllllllllllllIllIIlIIIIlllIIII = lllllllllllllllIllIIlIIIIlllIIIl.getFXLayer();
                final int lllllllllllllllIllIIlIIIIllIllll = lllllllllllllllIllIIlIIIIlllIIIl.isTransparent() ? 0 : 1;
                if (this.fxLayers[lllllllllllllllIllIIlIIIIlllIIII][lllllllllllllllIllIIlIIIIllIllll].size() >= 16384) {
                    this.fxLayers[lllllllllllllllIllIIlIIIIlllIIII][lllllllllllllllIllIIlIIIIllIllll].removeFirst();
                }
                if (!(lllllllllllllllIllIIlIIIIlllIIIl instanceof Barrier) || !this.reuseBarrierParticle(lllllllllllllllIllIIlIIIIlllIIIl, this.fxLayers[lllllllllllllllIllIIlIIIIlllIIII][lllllllllllllllIllIIlIIIIllIllll])) {
                    this.fxLayers[lllllllllllllllIllIIlIIIIlllIIII][lllllllllllllllIllIIlIIIIllIllll].add(lllllllllllllllIllIIlIIIIlllIIIl);
                }
            }
        }
    }
    
    @Nullable
    public Particle spawnEffectParticle(final int lllllllllllllllIllIIlIIIlIIlIlII, final double lllllllllllllllIllIIlIIIlIIlIIll, final double lllllllllllllllIllIIlIIIlIIlIIlI, final double lllllllllllllllIllIIlIIIlIIlIIIl, final double lllllllllllllllIllIIlIIIlIIlIIII, final double lllllllllllllllIllIIlIIIlIIIIIll, final double lllllllllllllllIllIIlIIIlIIIIIlI, final int... lllllllllllllllIllIIlIIIlIIIllIl) {
        final IParticleFactory lllllllllllllllIllIIlIIIlIIIllII = this.particleTypes.get(lllllllllllllllIllIIlIIIlIIlIlII);
        if (lllllllllllllllIllIIlIIIlIIIllII != null) {
            final Particle lllllllllllllllIllIIlIIIlIIIlIll = lllllllllllllllIllIIlIIIlIIIllII.createParticle(lllllllllllllllIllIIlIIIlIIlIlII, this.worldObj, lllllllllllllllIllIIlIIIlIIlIIll, lllllllllllllllIllIIlIIIlIIlIIlI, lllllllllllllllIllIIlIIIlIIlIIIl, lllllllllllllllIllIIlIIIlIIlIIII, lllllllllllllllIllIIlIIIlIIIIIll, lllllllllllllllIllIIlIIIlIIIIIlI, lllllllllllllllIllIIlIIIlIIIllIl);
            if (lllllllllllllllIllIIlIIIlIIIlIll != null) {
                this.addEffect(lllllllllllllllIllIIlIIIlIIIlIll);
                return lllllllllllllllIllIIlIIIlIIIlIll;
            }
        }
        return null;
    }
    
    public String getStatistics() {
        int lllllllllllllllIllIIIllllIIIlIlI = 0;
        for (int lllllllllllllllIllIIIllllIIIlIIl = 0; lllllllllllllllIllIIIllllIIIlIIl < 4; ++lllllllllllllllIllIIIllllIIIlIIl) {
            for (int lllllllllllllllIllIIIllllIIIlIII = 0; lllllllllllllllIllIIIllllIIIlIII < 2; ++lllllllllllllllIllIIIllllIIIlIII) {
                lllllllllllllllIllIIIllllIIIlIlI += this.fxLayers[lllllllllllllllIllIIIllllIIIlIIl][lllllllllllllllIllIIIllllIIIlIII].size();
            }
        }
        return String.valueOf(new StringBuilder().append(lllllllllllllllIllIIIllllIIIlIlI));
    }
    
    public void renderParticles(final Entity lllllllllllllllIllIIlIIIIIllIIII, final float lllllllllllllllIllIIlIIIIIlIllll) {
        final float lllllllllllllllIllIIlIIIIIlIlllI = ActiveRenderInfo.getRotationX();
        final float lllllllllllllllIllIIlIIIIIlIllIl = ActiveRenderInfo.getRotationZ();
        final float lllllllllllllllIllIIlIIIIIlIllII = ActiveRenderInfo.getRotationYZ();
        final float lllllllllllllllIllIIlIIIIIlIlIll = ActiveRenderInfo.getRotationXY();
        final float lllllllllllllllIllIIlIIIIIlIlIlI = ActiveRenderInfo.getRotationXZ();
        Particle.interpPosX = lllllllllllllllIllIIlIIIIIllIIII.lastTickPosX + (lllllllllllllllIllIIlIIIIIllIIII.posX - lllllllllllllllIllIIlIIIIIllIIII.lastTickPosX) * lllllllllllllllIllIIlIIIIIlIllll;
        Particle.interpPosY = lllllllllllllllIllIIlIIIIIllIIII.lastTickPosY + (lllllllllllllllIllIIlIIIIIllIIII.posY - lllllllllllllllIllIIlIIIIIllIIII.lastTickPosY) * lllllllllllllllIllIIlIIIIIlIllll;
        Particle.interpPosZ = lllllllllllllllIllIIlIIIIIllIIII.lastTickPosZ + (lllllllllllllllIllIIlIIIIIllIIII.posZ - lllllllllllllllIllIIlIIIIIllIIII.lastTickPosZ) * lllllllllllllllIllIIlIIIIIlIllll;
        Particle.cameraViewDir = lllllllllllllllIllIIlIIIIIllIIII.getLook(lllllllllllllllIllIIlIIIIIlIllll);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        GlStateManager.alphaFunc(516, 0.003921569f);
        for (int lllllllllllllllIllIIlIIIIIlIlIIl = 0; lllllllllllllllIllIIlIIIIIlIlIIl < 3; ++lllllllllllllllIllIIlIIIIIlIlIIl) {
            final int lllllllllllllllIllIIlIIIIIlIlIII = lllllllllllllllIllIIlIIIIIlIlIIl;
            for (int lllllllllllllllIllIIlIIIIIlIIlll = 0; lllllllllllllllIllIIlIIIIIlIIlll < 2; ++lllllllllllllllIllIIlIIIIIlIIlll) {
                if (!this.fxLayers[lllllllllllllllIllIIlIIIIIlIlIII][lllllllllllllllIllIIlIIIIIlIIlll].isEmpty()) {
                    switch (lllllllllllllllIllIIlIIIIIlIIlll) {
                        case 0: {
                            GlStateManager.depthMask(false);
                            break;
                        }
                        case 1: {
                            GlStateManager.depthMask(true);
                            break;
                        }
                    }
                    switch (lllllllllllllllIllIIlIIIIIlIlIII) {
                        default: {
                            this.renderer.bindTexture(ParticleManager.PARTICLE_TEXTURES);
                            break;
                        }
                        case 1: {
                            this.renderer.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
                            break;
                        }
                    }
                    GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
                    final Tessellator lllllllllllllllIllIIlIIIIIlIIllI = Tessellator.getInstance();
                    final BufferBuilder lllllllllllllllIllIIlIIIIIlIIlIl = lllllllllllllllIllIIlIIIIIlIIllI.getBuffer();
                    lllllllllllllllIllIIlIIIIIlIIlIl.begin(7, DefaultVertexFormats.PARTICLE_POSITION_TEX_COLOR_LMAP);
                    for (final Particle lllllllllllllllIllIIlIIIIIlIIlII : this.fxLayers[lllllllllllllllIllIIlIIIIIlIlIII][lllllllllllllllIllIIlIIIIIlIIlll]) {
                        try {
                            lllllllllllllllIllIIlIIIIIlIIlII.renderParticle(lllllllllllllllIllIIlIIIIIlIIlIl, lllllllllllllllIllIIlIIIIIllIIII, lllllllllllllllIllIIlIIIIIlIllll, lllllllllllllllIllIIlIIIIIlIlllI, lllllllllllllllIllIIlIIIIIlIlIlI, lllllllllllllllIllIIlIIIIIlIllIl, lllllllllllllllIllIIlIIIIIlIllII, lllllllllllllllIllIIlIIIIIlIlIll);
                        }
                        catch (Throwable lllllllllllllllIllIIlIIIIIlIIIll) {
                            final CrashReport lllllllllllllllIllIIlIIIIIlIIIlI = CrashReport.makeCrashReport(lllllllllllllllIllIIlIIIIIlIIIll, "Rendering Particle");
                            final CrashReportCategory lllllllllllllllIllIIlIIIIIlIIIIl = lllllllllllllllIllIIlIIIIIlIIIlI.makeCategory("Particle being rendered");
                            lllllllllllllllIllIIlIIIIIlIIIIl.setDetail("Particle", new ICrashReportDetail<String>() {
                                @Override
                                public String call() throws Exception {
                                    return lllllllllllllllIllIIlIIIIIlIIlII.toString();
                                }
                            });
                            lllllllllllllllIllIIlIIIIIlIIIIl.setDetail("Particle Type", new ICrashReportDetail<String>() {
                                @Override
                                public String call() throws Exception {
                                    if (lllllllllllllllIllIIlIIIIIlIlIII == 0) {
                                        return "MISC_TEXTURE";
                                    }
                                    if (lllllllllllllllIllIIlIIIIIlIlIII == 1) {
                                        return "TERRAIN_TEXTURE";
                                    }
                                    return (lllllllllllllllIllIIlIIIIIlIlIII == 3) ? "ENTITY_PARTICLE_TEXTURE" : String.valueOf(new StringBuilder("Unknown - ").append(lllllllllllllllIllIIlIIIIIlIlIII));
                                }
                            });
                            throw new ReportedException(lllllllllllllllIllIIlIIIIIlIIIlI);
                        }
                    }
                    lllllllllllllllIllIIlIIIIIlIIllI.draw();
                }
            }
        }
        GlStateManager.depthMask(true);
        GlStateManager.disableBlend();
        GlStateManager.alphaFunc(516, 0.1f);
    }
    
    public void registerParticle(final int lllllllllllllllIllIIlIIIlIllIlll, final IParticleFactory lllllllllllllllIllIIlIIIlIllIllI) {
        this.particleTypes.put(lllllllllllllllIllIIlIIIlIllIlll, lllllllllllllllIllIIlIIIlIllIllI);
    }
}
