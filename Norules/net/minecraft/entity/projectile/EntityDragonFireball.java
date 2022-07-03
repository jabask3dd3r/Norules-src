package net.minecraft.entity.projectile;

import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.potion.*;
import net.minecraft.util.math.*;
import java.util.*;
import net.minecraft.world.*;
import net.minecraft.util.datafix.*;

public class EntityDragonFireball extends EntityFireball
{
    @Override
    protected boolean isFireballFiery() {
        return false;
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource lllllllllllllIIIlllIllIllIIllllI, final float lllllllllllllIIIlllIllIllIIlllIl) {
        return false;
    }
    
    @Override
    protected void onImpact(final RayTraceResult lllllllllllllIIIlllIllIllIlIIllI) {
        if ((lllllllllllllIIIlllIllIllIlIIllI.entityHit == null || !lllllllllllllIIIlllIllIllIlIIllI.entityHit.isEntityEqual(this.shootingEntity)) && !this.world.isRemote) {
            final List<EntityLivingBase> lllllllllllllIIIlllIllIllIlIlIll = this.world.getEntitiesWithinAABB((Class<? extends EntityLivingBase>)EntityLivingBase.class, this.getEntityBoundingBox().expand(4.0, 2.0, 4.0));
            final EntityAreaEffectCloud lllllllllllllIIIlllIllIllIlIlIlI = new EntityAreaEffectCloud(this.world, this.posX, this.posY, this.posZ);
            lllllllllllllIIIlllIllIllIlIlIlI.setOwner(this.shootingEntity);
            lllllllllllllIIIlllIllIllIlIlIlI.setParticle(EnumParticleTypes.DRAGON_BREATH);
            lllllllllllllIIIlllIllIllIlIlIlI.setRadius(3.0f);
            lllllllllllllIIIlllIllIllIlIlIlI.setDuration(600);
            lllllllllllllIIIlllIllIllIlIlIlI.setRadiusPerTick((7.0f - lllllllllllllIIIlllIllIllIlIlIlI.getRadius()) / lllllllllllllIIIlllIllIllIlIlIlI.getDuration());
            lllllllllllllIIIlllIllIllIlIlIlI.addEffect(new PotionEffect(MobEffects.INSTANT_DAMAGE, 1, 1));
            if (!lllllllllllllIIIlllIllIllIlIlIll.isEmpty()) {
                for (final EntityLivingBase lllllllllllllIIIlllIllIllIlIlIIl : lllllllllllllIIIlllIllIllIlIlIll) {
                    final double lllllllllllllIIIlllIllIllIlIlIII = this.getDistanceSqToEntity(lllllllllllllIIIlllIllIllIlIlIIl);
                    if (lllllllllllllIIIlllIllIllIlIlIII < 16.0) {
                        lllllllllllllIIIlllIllIllIlIlIlI.setPosition(lllllllllllllIIIlllIllIllIlIlIIl.posX, lllllllllllllIIIlllIllIllIlIlIIl.posY, lllllllllllllIIIlllIllIllIlIlIIl.posZ);
                        break;
                    }
                }
            }
            this.world.playEvent(2006, new BlockPos(this.posX, this.posY, this.posZ), 0);
            this.world.spawnEntityInWorld(lllllllllllllIIIlllIllIllIlIlIlI);
            this.setDead();
        }
    }
    
    public EntityDragonFireball(final World lllllllllllllIIIlllIllIllllIIlII) {
        super(lllllllllllllIIIlllIllIllllIIlII);
        this.setSize(1.0f, 1.0f);
    }
    
    public EntityDragonFireball(final World lllllllllllllIIIlllIllIlllIIIIlI, final EntityLivingBase lllllllllllllIIIlllIllIllIlllIll, final double lllllllllllllIIIlllIllIlllIIIIII, final double lllllllllllllIIIlllIllIllIllllll, final double lllllllllllllIIIlllIllIllIlllIII) {
        super(lllllllllllllIIIlllIllIlllIIIIlI, lllllllllllllIIIlllIllIllIlllIll, lllllllllllllIIIlllIllIlllIIIIII, lllllllllllllIIIlllIllIllIllllll, lllllllllllllIIIlllIllIllIlllIII);
        this.setSize(1.0f, 1.0f);
    }
    
    public static void registerFixesDragonFireball(final DataFixer lllllllllllllIIIlllIllIllIllIlIl) {
        EntityFireball.registerFixesFireball(lllllllllllllIIIlllIllIllIllIlIl, "DragonFireball");
    }
    
    public EntityDragonFireball(final World lllllllllllllIIIlllIllIlllIllIII, final double lllllllllllllIIIlllIllIlllIIllll, final double lllllllllllllIIIlllIllIlllIIlllI, final double lllllllllllllIIIlllIllIlllIIllIl, final double lllllllllllllIIIlllIllIlllIlIlII, final double lllllllllllllIIIlllIllIlllIlIIll, final double lllllllllllllIIIlllIllIlllIlIIlI) {
        super(lllllllllllllIIIlllIllIlllIllIII, lllllllllllllIIIlllIllIlllIIllll, lllllllllllllIIIlllIllIlllIIlllI, lllllllllllllIIIlllIllIlllIIllIl, lllllllllllllIIIlllIllIlllIlIlII, lllllllllllllIIIlllIllIlllIlIIll, lllllllllllllIIIlllIllIlllIlIIlI);
        this.setSize(1.0f, 1.0f);
    }
    
    @Override
    public boolean canBeCollidedWith() {
        return false;
    }
    
    @Override
    protected EnumParticleTypes getParticleType() {
        return EnumParticleTypes.DRAGON_BREATH;
    }
}
