package net.minecraft.world;

import net.minecraft.entity.player.*;
import net.minecraft.block.material.*;
import net.minecraft.init.*;
import net.minecraft.block.state.*;
import net.minecraft.block.*;
import net.minecraft.util.math.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.enchantment.*;
import java.util.*;
import com.google.common.collect.*;
import net.minecraft.entity.item.*;
import javax.annotation.*;

public class Explosion
{
    private final /* synthetic */ float explosionSize;
    private final /* synthetic */ double explosionY;
    private final /* synthetic */ Entity exploder;
    private final /* synthetic */ Random explosionRNG;
    private final /* synthetic */ boolean isFlaming;
    private final /* synthetic */ World worldObj;
    private final /* synthetic */ Map<EntityPlayer, Vec3d> playerKnockbackMap;
    private final /* synthetic */ List<BlockPos> affectedBlockPositions;
    private final /* synthetic */ boolean isSmoking;
    private final /* synthetic */ double explosionX;
    private final /* synthetic */ double explosionZ;
    
    public List<BlockPos> getAffectedBlockPositions() {
        return this.affectedBlockPositions;
    }
    
    public Map<EntityPlayer, Vec3d> getPlayerKnockbackMap() {
        return this.playerKnockbackMap;
    }
    
    public void clearAffectedBlockPositions() {
        this.affectedBlockPositions.clear();
    }
    
    public Explosion(final World lllllllllllllIIIIIIIIIIlIIlllIIl, final Entity lllllllllllllIIIIIIIIIIlIlIIIIlI, final double lllllllllllllIIIIIIIIIIlIlIIIIIl, final double lllllllllllllIIIIIIIIIIlIIllIllI, final double lllllllllllllIIIIIIIIIIlIIllllll, final float lllllllllllllIIIIIIIIIIlIIlllllI, final boolean lllllllllllllIIIIIIIIIIlIIllIIll, final boolean lllllllllllllIIIIIIIIIIlIIllllII, final List<BlockPos> lllllllllllllIIIIIIIIIIlIIlllIll) {
        this(lllllllllllllIIIIIIIIIIlIIlllIIl, lllllllllllllIIIIIIIIIIlIlIIIIlI, lllllllllllllIIIIIIIIIIlIlIIIIIl, lllllllllllllIIIIIIIIIIlIIllIllI, lllllllllllllIIIIIIIIIIlIIllllll, lllllllllllllIIIIIIIIIIlIIlllllI, lllllllllllllIIIIIIIIIIlIIllIIll, lllllllllllllIIIIIIIIIIlIIllllII);
        this.affectedBlockPositions.addAll(lllllllllllllIIIIIIIIIIlIIlllIll);
    }
    
    public void doExplosionB(final boolean lllllllllllllIIIIIIIIIIIlIlIlIII) {
        this.worldObj.playSound(null, this.explosionX, this.explosionY, this.explosionZ, SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.BLOCKS, 4.0f, (1.0f + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 0.2f) * 0.7f);
        if (this.explosionSize >= 2.0f && this.isSmoking) {
            this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_HUGE, this.explosionX, this.explosionY, this.explosionZ, 1.0, 0.0, 0.0, new int[0]);
        }
        else {
            this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, this.explosionX, this.explosionY, this.explosionZ, 1.0, 0.0, 0.0, new int[0]);
        }
        if (this.isSmoking) {
            for (final BlockPos lllllllllllllIIIIIIIIIIIlIlIIlll : this.affectedBlockPositions) {
                final IBlockState lllllllllllllIIIIIIIIIIIlIlIIllI = this.worldObj.getBlockState(lllllllllllllIIIIIIIIIIIlIlIIlll);
                final Block lllllllllllllIIIIIIIIIIIlIlIIlIl = lllllllllllllIIIIIIIIIIIlIlIIllI.getBlock();
                if (lllllllllllllIIIIIIIIIIIlIlIlIII) {
                    final double lllllllllllllIIIIIIIIIIIlIlIIlII = lllllllllllllIIIIIIIIIIIlIlIIlll.getX() + this.worldObj.rand.nextFloat();
                    final double lllllllllllllIIIIIIIIIIIlIlIIIll = lllllllllllllIIIIIIIIIIIlIlIIlll.getY() + this.worldObj.rand.nextFloat();
                    final double lllllllllllllIIIIIIIIIIIlIlIIIlI = lllllllllllllIIIIIIIIIIIlIlIIlll.getZ() + this.worldObj.rand.nextFloat();
                    double lllllllllllllIIIIIIIIIIIlIlIIIIl = lllllllllllllIIIIIIIIIIIlIlIIlII - this.explosionX;
                    double lllllllllllllIIIIIIIIIIIlIlIIIII = lllllllllllllIIIIIIIIIIIlIlIIIll - this.explosionY;
                    double lllllllllllllIIIIIIIIIIIlIIlllll = lllllllllllllIIIIIIIIIIIlIlIIIlI - this.explosionZ;
                    final double lllllllllllllIIIIIIIIIIIlIIllllI = MathHelper.sqrt(lllllllllllllIIIIIIIIIIIlIlIIIIl * lllllllllllllIIIIIIIIIIIlIlIIIIl + lllllllllllllIIIIIIIIIIIlIlIIIII * lllllllllllllIIIIIIIIIIIlIlIIIII + lllllllllllllIIIIIIIIIIIlIIlllll * lllllllllllllIIIIIIIIIIIlIIlllll);
                    lllllllllllllIIIIIIIIIIIlIlIIIIl /= lllllllllllllIIIIIIIIIIIlIIllllI;
                    lllllllllllllIIIIIIIIIIIlIlIIIII /= lllllllllllllIIIIIIIIIIIlIIllllI;
                    lllllllllllllIIIIIIIIIIIlIIlllll /= lllllllllllllIIIIIIIIIIIlIIllllI;
                    double lllllllllllllIIIIIIIIIIIlIIlllIl = 0.5 / (lllllllllllllIIIIIIIIIIIlIIllllI / this.explosionSize + 0.1);
                    lllllllllllllIIIIIIIIIIIlIIlllIl *= this.worldObj.rand.nextFloat() * this.worldObj.rand.nextFloat() + 0.3f;
                    lllllllllllllIIIIIIIIIIIlIlIIIIl *= lllllllllllllIIIIIIIIIIIlIIlllIl;
                    lllllllllllllIIIIIIIIIIIlIlIIIII *= lllllllllllllIIIIIIIIIIIlIIlllIl;
                    lllllllllllllIIIIIIIIIIIlIIlllll *= lllllllllllllIIIIIIIIIIIlIIlllIl;
                    this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, (lllllllllllllIIIIIIIIIIIlIlIIlII + this.explosionX) / 2.0, (lllllllllllllIIIIIIIIIIIlIlIIIll + this.explosionY) / 2.0, (lllllllllllllIIIIIIIIIIIlIlIIIlI + this.explosionZ) / 2.0, lllllllllllllIIIIIIIIIIIlIlIIIIl, lllllllllllllIIIIIIIIIIIlIlIIIII, lllllllllllllIIIIIIIIIIIlIIlllll, new int[0]);
                    this.worldObj.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, lllllllllllllIIIIIIIIIIIlIlIIlII, lllllllllllllIIIIIIIIIIIlIlIIIll, lllllllllllllIIIIIIIIIIIlIlIIIlI, lllllllllllllIIIIIIIIIIIlIlIIIIl, lllllllllllllIIIIIIIIIIIlIlIIIII, lllllllllllllIIIIIIIIIIIlIIlllll, new int[0]);
                }
                if (lllllllllllllIIIIIIIIIIIlIlIIllI.getMaterial() != Material.AIR) {
                    if (lllllllllllllIIIIIIIIIIIlIlIIlIl.canDropFromExplosion(this)) {
                        lllllllllllllIIIIIIIIIIIlIlIIlIl.dropBlockAsItemWithChance(this.worldObj, lllllllllllllIIIIIIIIIIIlIlIIlll, this.worldObj.getBlockState(lllllllllllllIIIIIIIIIIIlIlIIlll), 1.0f / this.explosionSize, 0);
                    }
                    this.worldObj.setBlockState(lllllllllllllIIIIIIIIIIIlIlIIlll, Blocks.AIR.getDefaultState(), 3);
                    lllllllllllllIIIIIIIIIIIlIlIIlIl.onBlockDestroyedByExplosion(this.worldObj, lllllllllllllIIIIIIIIIIIlIlIIlll, this);
                }
            }
        }
        if (this.isFlaming) {
            for (final BlockPos lllllllllllllIIIIIIIIIIIlIIlllII : this.affectedBlockPositions) {
                if (this.worldObj.getBlockState(lllllllllllllIIIIIIIIIIIlIIlllII).getMaterial() == Material.AIR && this.worldObj.getBlockState(lllllllllllllIIIIIIIIIIIlIIlllII.down()).isFullBlock() && this.explosionRNG.nextInt(3) == 0) {
                    this.worldObj.setBlockState(lllllllllllllIIIIIIIIIIIlIIlllII, Blocks.FIRE.getDefaultState());
                }
            }
        }
    }
    
    public void doExplosionA() {
        final Set<BlockPos> lllllllllllllIIIIIIIIIIIlllllIII = (Set<BlockPos>)Sets.newHashSet();
        final int lllllllllllllIIIIIIIIIIIllllIlll = 16;
        for (int lllllllllllllIIIIIIIIIIIllllIllI = 0; lllllllllllllIIIIIIIIIIIllllIllI < 16; ++lllllllllllllIIIIIIIIIIIllllIllI) {
            for (int lllllllllllllIIIIIIIIIIIllllIlIl = 0; lllllllllllllIIIIIIIIIIIllllIlIl < 16; ++lllllllllllllIIIIIIIIIIIllllIlIl) {
                for (int lllllllllllllIIIIIIIIIIIllllIlII = 0; lllllllllllllIIIIIIIIIIIllllIlII < 16; ++lllllllllllllIIIIIIIIIIIllllIlII) {
                    if (lllllllllllllIIIIIIIIIIIllllIllI == 0 || lllllllllllllIIIIIIIIIIIllllIllI == 15 || lllllllllllllIIIIIIIIIIIllllIlIl == 0 || lllllllllllllIIIIIIIIIIIllllIlIl == 15 || lllllllllllllIIIIIIIIIIIllllIlII == 0 || lllllllllllllIIIIIIIIIIIllllIlII == 15) {
                        double lllllllllllllIIIIIIIIIIIllllIIll = lllllllllllllIIIIIIIIIIIllllIllI / 15.0f * 2.0f - 1.0f;
                        double lllllllllllllIIIIIIIIIIIllllIIlI = lllllllllllllIIIIIIIIIIIllllIlIl / 15.0f * 2.0f - 1.0f;
                        double lllllllllllllIIIIIIIIIIIllllIIIl = lllllllllllllIIIIIIIIIIIllllIlII / 15.0f * 2.0f - 1.0f;
                        final double lllllllllllllIIIIIIIIIIIllllIIII = Math.sqrt(lllllllllllllIIIIIIIIIIIllllIIll * lllllllllllllIIIIIIIIIIIllllIIll + lllllllllllllIIIIIIIIIIIllllIIlI * lllllllllllllIIIIIIIIIIIllllIIlI + lllllllllllllIIIIIIIIIIIllllIIIl * lllllllllllllIIIIIIIIIIIllllIIIl);
                        lllllllllllllIIIIIIIIIIIllllIIll /= lllllllllllllIIIIIIIIIIIllllIIII;
                        lllllllllllllIIIIIIIIIIIllllIIlI /= lllllllllllllIIIIIIIIIIIllllIIII;
                        lllllllllllllIIIIIIIIIIIllllIIIl /= lllllllllllllIIIIIIIIIIIllllIIII;
                        float lllllllllllllIIIIIIIIIIIlllIllll = this.explosionSize * (0.7f + this.worldObj.rand.nextFloat() * 0.6f);
                        double lllllllllllllIIIIIIIIIIIlllIlllI = this.explosionX;
                        double lllllllllllllIIIIIIIIIIIlllIllIl = this.explosionY;
                        double lllllllllllllIIIIIIIIIIIlllIllII = this.explosionZ;
                        final float lllllllllllllIIIIIIIIIIIlllIlIll = 0.3f;
                        while (lllllllllllllIIIIIIIIIIIlllIllll > 0.0f) {
                            final BlockPos lllllllllllllIIIIIIIIIIIlllIlIlI = new BlockPos(lllllllllllllIIIIIIIIIIIlllIlllI, lllllllllllllIIIIIIIIIIIlllIllIl, lllllllllllllIIIIIIIIIIIlllIllII);
                            final IBlockState lllllllllllllIIIIIIIIIIIlllIlIIl = this.worldObj.getBlockState(lllllllllllllIIIIIIIIIIIlllIlIlI);
                            if (lllllllllllllIIIIIIIIIIIlllIlIIl.getMaterial() != Material.AIR) {
                                final float lllllllllllllIIIIIIIIIIIlllIlIII = (this.exploder != null) ? this.exploder.getExplosionResistance(this, this.worldObj, lllllllllllllIIIIIIIIIIIlllIlIlI, lllllllllllllIIIIIIIIIIIlllIlIIl) : lllllllllllllIIIIIIIIIIIlllIlIIl.getBlock().getExplosionResistance(null);
                                lllllllllllllIIIIIIIIIIIlllIllll -= (lllllllllllllIIIIIIIIIIIlllIlIII + 0.3f) * 0.3f;
                            }
                            if (lllllllllllllIIIIIIIIIIIlllIllll > 0.0f && (this.exploder == null || this.exploder.verifyExplosion(this, this.worldObj, lllllllllllllIIIIIIIIIIIlllIlIlI, lllllllllllllIIIIIIIIIIIlllIlIIl, lllllllllllllIIIIIIIIIIIlllIllll))) {
                                lllllllllllllIIIIIIIIIIIlllllIII.add(lllllllllllllIIIIIIIIIIIlllIlIlI);
                            }
                            lllllllllllllIIIIIIIIIIIlllIlllI += lllllllllllllIIIIIIIIIIIllllIIll * 0.30000001192092896;
                            lllllllllllllIIIIIIIIIIIlllIllIl += lllllllllllllIIIIIIIIIIIllllIIlI * 0.30000001192092896;
                            lllllllllllllIIIIIIIIIIIlllIllII += lllllllllllllIIIIIIIIIIIllllIIIl * 0.30000001192092896;
                            lllllllllllllIIIIIIIIIIIlllIllll -= 0.22500001f;
                        }
                    }
                }
            }
        }
        this.affectedBlockPositions.addAll(lllllllllllllIIIIIIIIIIIlllllIII);
        final float lllllllllllllIIIIIIIIIIIlllIIlll = this.explosionSize * 2.0f;
        final int lllllllllllllIIIIIIIIIIIlllIIllI = MathHelper.floor(this.explosionX - lllllllllllllIIIIIIIIIIIlllIIlll - 1.0);
        final int lllllllllllllIIIIIIIIIIIlllIIlIl = MathHelper.floor(this.explosionX + lllllllllllllIIIIIIIIIIIlllIIlll + 1.0);
        final int lllllllllllllIIIIIIIIIIIlllIIlII = MathHelper.floor(this.explosionY - lllllllllllllIIIIIIIIIIIlllIIlll - 1.0);
        final int lllllllllllllIIIIIIIIIIIlllIIIll = MathHelper.floor(this.explosionY + lllllllllllllIIIIIIIIIIIlllIIlll + 1.0);
        final int lllllllllllllIIIIIIIIIIIlllIIIlI = MathHelper.floor(this.explosionZ - lllllllllllllIIIIIIIIIIIlllIIlll - 1.0);
        final int lllllllllllllIIIIIIIIIIIlllIIIIl = MathHelper.floor(this.explosionZ + lllllllllllllIIIIIIIIIIIlllIIlll + 1.0);
        final List<Entity> lllllllllllllIIIIIIIIIIIlllIIIII = this.worldObj.getEntitiesWithinAABBExcludingEntity(this.exploder, new AxisAlignedBB(lllllllllllllIIIIIIIIIIIlllIIllI, lllllllllllllIIIIIIIIIIIlllIIlII, lllllllllllllIIIIIIIIIIIlllIIIlI, lllllllllllllIIIIIIIIIIIlllIIlIl, lllllllllllllIIIIIIIIIIIlllIIIll, lllllllllllllIIIIIIIIIIIlllIIIIl));
        final Vec3d lllllllllllllIIIIIIIIIIIllIlllll = new Vec3d(this.explosionX, this.explosionY, this.explosionZ);
        for (int lllllllllllllIIIIIIIIIIIllIllllI = 0; lllllllllllllIIIIIIIIIIIllIllllI < lllllllllllllIIIIIIIIIIIlllIIIII.size(); ++lllllllllllllIIIIIIIIIIIllIllllI) {
            final Entity lllllllllllllIIIIIIIIIIIllIlllIl = lllllllllllllIIIIIIIIIIIlllIIIII.get(lllllllllllllIIIIIIIIIIIllIllllI);
            if (!lllllllllllllIIIIIIIIIIIllIlllIl.isImmuneToExplosions()) {
                final double lllllllllllllIIIIIIIIIIIllIlllII = lllllllllllllIIIIIIIIIIIllIlllIl.getDistance(this.explosionX, this.explosionY, this.explosionZ) / lllllllllllllIIIIIIIIIIIlllIIlll;
                if (lllllllllllllIIIIIIIIIIIllIlllII <= 1.0) {
                    double lllllllllllllIIIIIIIIIIIllIllIll = lllllllllllllIIIIIIIIIIIllIlllIl.posX - this.explosionX;
                    double lllllllllllllIIIIIIIIIIIllIllIlI = lllllllllllllIIIIIIIIIIIllIlllIl.posY + lllllllllllllIIIIIIIIIIIllIlllIl.getEyeHeight() - this.explosionY;
                    double lllllllllllllIIIIIIIIIIIllIllIIl = lllllllllllllIIIIIIIIIIIllIlllIl.posZ - this.explosionZ;
                    final double lllllllllllllIIIIIIIIIIIllIllIII = MathHelper.sqrt(lllllllllllllIIIIIIIIIIIllIllIll * lllllllllllllIIIIIIIIIIIllIllIll + lllllllllllllIIIIIIIIIIIllIllIlI * lllllllllllllIIIIIIIIIIIllIllIlI + lllllllllllllIIIIIIIIIIIllIllIIl * lllllllllllllIIIIIIIIIIIllIllIIl);
                    if (lllllllllllllIIIIIIIIIIIllIllIII != 0.0) {
                        lllllllllllllIIIIIIIIIIIllIllIll /= lllllllllllllIIIIIIIIIIIllIllIII;
                        lllllllllllllIIIIIIIIIIIllIllIlI /= lllllllllllllIIIIIIIIIIIllIllIII;
                        lllllllllllllIIIIIIIIIIIllIllIIl /= lllllllllllllIIIIIIIIIIIllIllIII;
                        final double lllllllllllllIIIIIIIIIIIllIlIlll = this.worldObj.getBlockDensity(lllllllllllllIIIIIIIIIIIllIlllll, lllllllllllllIIIIIIIIIIIllIlllIl.getEntityBoundingBox());
                        final double lllllllllllllIIIIIIIIIIIllIlIllI = (1.0 - lllllllllllllIIIIIIIIIIIllIlllII) * lllllllllllllIIIIIIIIIIIllIlIlll;
                        lllllllllllllIIIIIIIIIIIllIlllIl.attackEntityFrom(DamageSource.causeExplosionDamage(this), (float)(int)((lllllllllllllIIIIIIIIIIIllIlIllI * lllllllllllllIIIIIIIIIIIllIlIllI + lllllllllllllIIIIIIIIIIIllIlIllI) / 2.0 * 7.0 * lllllllllllllIIIIIIIIIIIlllIIlll + 1.0));
                        double lllllllllllllIIIIIIIIIIIllIlIlIl = lllllllllllllIIIIIIIIIIIllIlIllI;
                        if (lllllllllllllIIIIIIIIIIIllIlllIl instanceof EntityLivingBase) {
                            lllllllllllllIIIIIIIIIIIllIlIlIl = EnchantmentProtection.getBlastDamageReduction((EntityLivingBase)lllllllllllllIIIIIIIIIIIllIlllIl, lllllllllllllIIIIIIIIIIIllIlIllI);
                        }
                        final Entity entity = lllllllllllllIIIIIIIIIIIllIlllIl;
                        entity.motionX += lllllllllllllIIIIIIIIIIIllIllIll * lllllllllllllIIIIIIIIIIIllIlIlIl;
                        final Entity entity2 = lllllllllllllIIIIIIIIIIIllIlllIl;
                        entity2.motionY += lllllllllllllIIIIIIIIIIIllIllIlI * lllllllllllllIIIIIIIIIIIllIlIlIl;
                        final Entity entity3 = lllllllllllllIIIIIIIIIIIllIlllIl;
                        entity3.motionZ += lllllllllllllIIIIIIIIIIIllIllIIl * lllllllllllllIIIIIIIIIIIllIlIlIl;
                        if (lllllllllllllIIIIIIIIIIIllIlllIl instanceof EntityPlayer) {
                            final EntityPlayer lllllllllllllIIIIIIIIIIIllIlIlII = (EntityPlayer)lllllllllllllIIIIIIIIIIIllIlllIl;
                            if (!lllllllllllllIIIIIIIIIIIllIlIlII.isSpectator() && (!lllllllllllllIIIIIIIIIIIllIlIlII.isCreative() || !lllllllllllllIIIIIIIIIIIllIlIlII.capabilities.isFlying)) {
                                this.playerKnockbackMap.put(lllllllllllllIIIIIIIIIIIllIlIlII, new Vec3d(lllllllllllllIIIIIIIIIIIllIllIll * lllllllllllllIIIIIIIIIIIllIlIllI, lllllllllllllIIIIIIIIIIIllIllIlI * lllllllllllllIIIIIIIIIIIllIlIllI, lllllllllllllIIIIIIIIIIIllIllIIl * lllllllllllllIIIIIIIIIIIllIlIllI));
                            }
                        }
                    }
                }
            }
        }
    }
    
    public Explosion(final World lllllllllllllIIIIIIIIIIlIIIlllIl, final Entity lllllllllllllIIIIIIIIIIlIIlIIlIl, final double lllllllllllllIIIIIIIIIIlIIlIIlII, final double lllllllllllllIIIIIIIIIIlIIlIIIll, final double lllllllllllllIIIIIIIIIIlIIIllIIl, final float lllllllllllllIIIIIIIIIIlIIlIIIIl, final boolean lllllllllllllIIIIIIIIIIlIIlIIIII, final boolean lllllllllllllIIIIIIIIIIlIIIlIllI) {
        this.explosionRNG = new Random();
        this.affectedBlockPositions = (List<BlockPos>)Lists.newArrayList();
        this.playerKnockbackMap = (Map<EntityPlayer, Vec3d>)Maps.newHashMap();
        this.worldObj = lllllllllllllIIIIIIIIIIlIIIlllIl;
        this.exploder = lllllllllllllIIIIIIIIIIlIIlIIlIl;
        this.explosionSize = lllllllllllllIIIIIIIIIIlIIlIIIIl;
        this.explosionX = lllllllllllllIIIIIIIIIIlIIlIIlII;
        this.explosionY = lllllllllllllIIIIIIIIIIlIIlIIIll;
        this.explosionZ = lllllllllllllIIIIIIIIIIlIIIllIIl;
        this.isFlaming = lllllllllllllIIIIIIIIIIlIIlIIIII;
        this.isSmoking = lllllllllllllIIIIIIIIIIlIIIlIllI;
    }
    
    @Nullable
    public EntityLivingBase getExplosivePlacedBy() {
        if (this.exploder == null) {
            return null;
        }
        if (this.exploder instanceof EntityTNTPrimed) {
            return ((EntityTNTPrimed)this.exploder).getTntPlacedBy();
        }
        return (this.exploder instanceof EntityLivingBase) ? ((EntityLivingBase)this.exploder) : null;
    }
    
    public Explosion(final World lllllllllllllIIIIIIIIIIlIlIlllIl, final Entity lllllllllllllIIIIIIIIIIlIlIlIlII, final double lllllllllllllIIIIIIIIIIlIlIllIll, final double lllllllllllllIIIIIIIIIIlIlIllIlI, final double lllllllllllllIIIIIIIIIIlIlIlIIIl, final float lllllllllllllIIIIIIIIIIlIlIllIII, final List<BlockPos> lllllllllllllIIIIIIIIIIlIlIlIlll) {
        this(lllllllllllllIIIIIIIIIIlIlIlllIl, lllllllllllllIIIIIIIIIIlIlIlIlII, lllllllllllllIIIIIIIIIIlIlIllIll, lllllllllllllIIIIIIIIIIlIlIllIlI, lllllllllllllIIIIIIIIIIlIlIlIIIl, lllllllllllllIIIIIIIIIIlIlIllIII, false, true, lllllllllllllIIIIIIIIIIlIlIlIlll);
    }
}
