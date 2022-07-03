package net.minecraft.entity.projectile;

import net.minecraft.block.state.*;
import net.minecraft.entity.boss.*;
import net.minecraft.block.*;
import net.minecraft.util.datafix.*;
import net.minecraft.util.math.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.init.*;
import net.minecraft.potion.*;
import net.minecraft.entity.*;
import net.minecraft.network.datasync.*;

public class EntityWitherSkull extends EntityFireball
{
    private static final /* synthetic */ DataParameter<Boolean> INVULNERABLE;
    
    public EntityWitherSkull(final World lllllllllllllIlIIllllIlIIIIllIll, final EntityLivingBase lllllllllllllIlIIllllIlIIIIllIlI, final double lllllllllllllIlIIllllIlIIIIllIIl, final double lllllllllllllIlIIllllIlIIIIllllI, final double lllllllllllllIlIIllllIlIIIIlllIl) {
        super(lllllllllllllIlIIllllIlIIIIllIll, lllllllllllllIlIIllllIlIIIIllIlI, lllllllllllllIlIIllllIlIIIIllIIl, lllllllllllllIlIIllllIlIIIIllllI, lllllllllllllIlIIllllIlIIIIlllIl);
        this.setSize(0.3125f, 0.3125f);
    }
    
    @Override
    public float getExplosionResistance(final Explosion lllllllllllllIlIIllllIIllllIlIII, final World lllllllllllllIlIIllllIIllllIIlll, final BlockPos lllllllllllllIlIIllllIIllllIllIl, final IBlockState lllllllllllllIlIIllllIIllllIIlIl) {
        float lllllllllllllIlIIllllIIllllIlIll = super.getExplosionResistance(lllllllllllllIlIIllllIIllllIlIII, lllllllllllllIlIIllllIIllllIIlll, lllllllllllllIlIIllllIIllllIllIl, lllllllllllllIlIIllllIIllllIIlIl);
        final Block lllllllllllllIlIIllllIIllllIlIlI = lllllllllllllIlIIllllIIllllIIlIl.getBlock();
        if (this.isInvulnerable() && EntityWither.canDestroyBlock(lllllllllllllIlIIllllIIllllIlIlI)) {
            lllllllllllllIlIIllllIIllllIlIll = Math.min(0.8f, lllllllllllllIlIIllllIIllllIlIll);
        }
        return lllllllllllllIlIIllllIIllllIlIll;
    }
    
    public void setInvulnerable(final boolean lllllllllllllIlIIllllIIllIlllIII) {
        this.dataManager.set(EntityWitherSkull.INVULNERABLE, lllllllllllllIlIIllllIIllIlllIII);
    }
    
    public static void registerFixesWitherSkull(final DataFixer lllllllllllllIlIIllllIlIIIIlIlII) {
        EntityFireball.registerFixesFireball(lllllllllllllIlIIllllIlIIIIlIlII, "WitherSkull");
    }
    
    @Override
    protected void onImpact(final RayTraceResult lllllllllllllIlIIllllIIlllIlIllI) {
        if (!this.world.isRemote) {
            if (lllllllllllllIlIIllllIIlllIlIllI.entityHit != null) {
                if (this.shootingEntity != null) {
                    if (lllllllllllllIlIIllllIIlllIlIllI.entityHit.attackEntityFrom(DamageSource.causeMobDamage(this.shootingEntity), 8.0f)) {
                        if (lllllllllllllIlIIllllIIlllIlIllI.entityHit.isEntityAlive()) {
                            this.applyEnchantments(this.shootingEntity, lllllllllllllIlIIllllIIlllIlIllI.entityHit);
                        }
                        else {
                            this.shootingEntity.heal(5.0f);
                        }
                    }
                }
                else {
                    lllllllllllllIlIIllllIIlllIlIllI.entityHit.attackEntityFrom(DamageSource.magic, 5.0f);
                }
                if (lllllllllllllIlIIllllIIlllIlIllI.entityHit instanceof EntityLivingBase) {
                    int lllllllllllllIlIIllllIIlllIlIlII = 0;
                    if (this.world.getDifficulty() == EnumDifficulty.NORMAL) {
                        lllllllllllllIlIIllllIIlllIlIlII = 10;
                    }
                    else if (this.world.getDifficulty() == EnumDifficulty.HARD) {
                        lllllllllllllIlIIllllIIlllIlIlII = 40;
                    }
                    if (lllllllllllllIlIIllllIIlllIlIlII > 0) {
                        ((EntityLivingBase)lllllllllllllIlIIllllIIlllIlIllI.entityHit).addPotionEffect(new PotionEffect(MobEffects.WITHER, 20 * lllllllllllllIlIIllllIIlllIlIlII, 1));
                    }
                }
            }
            this.world.newExplosion(this, this.posX, this.posY, this.posZ, 1.0f, false, this.world.getGameRules().getBoolean("mobGriefing"));
            this.setDead();
        }
    }
    
    public EntityWitherSkull(final World lllllllllllllIlIIllllIlIIIlIlIIl) {
        super(lllllllllllllIlIIllllIlIIIlIlIIl);
        this.setSize(0.3125f, 0.3125f);
    }
    
    public EntityWitherSkull(final World lllllllllllllIlIIllllIlIIIIIIlll, final double lllllllllllllIlIIllllIlIIIIIIllI, final double lllllllllllllIlIIllllIIlllllllIl, final double lllllllllllllIlIIllllIlIIIIIIlII, final double lllllllllllllIlIIllllIlIIIIIIIll, final double lllllllllllllIlIIllllIlIIIIIIIlI, final double lllllllllllllIlIIllllIIllllllIIl) {
        super(lllllllllllllIlIIllllIlIIIIIIlll, lllllllllllllIlIIllllIlIIIIIIllI, lllllllllllllIlIIllllIIlllllllIl, lllllllllllllIlIIllllIlIIIIIIlII, lllllllllllllIlIIllllIlIIIIIIIll, lllllllllllllIlIIllllIlIIIIIIIlI, lllllllllllllIlIIllllIIllllllIIl);
        this.setSize(0.3125f, 0.3125f);
    }
    
    static {
        INVULNERABLE = EntityDataManager.createKey(EntityWitherSkull.class, DataSerializers.BOOLEAN);
    }
    
    @Override
    protected void entityInit() {
        this.dataManager.register(EntityWitherSkull.INVULNERABLE, false);
    }
    
    @Override
    protected boolean isFireballFiery() {
        return false;
    }
    
    public boolean isInvulnerable() {
        return this.dataManager.get(EntityWitherSkull.INVULNERABLE);
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource lllllllllllllIlIIllllIIlllIIIllI, final float lllllllllllllIlIIllllIIlllIIIlII) {
        return false;
    }
    
    @Override
    public boolean canBeCollidedWith() {
        return false;
    }
    
    @Override
    protected float getMotionFactor() {
        return this.isInvulnerable() ? 0.73f : super.getMotionFactor();
    }
    
    @Override
    public boolean isBurning() {
        return false;
    }
}
