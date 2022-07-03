package net.minecraft.entity.projectile;

import net.minecraft.entity.*;
import net.minecraft.world.*;
import net.minecraft.util.datafix.*;
import net.minecraft.nbt.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;

public abstract class EntityFireball extends Entity
{
    private /* synthetic */ int ticksAlive;
    public /* synthetic */ EntityLivingBase shootingEntity;
    public /* synthetic */ double accelerationZ;
    public /* synthetic */ double accelerationY;
    public /* synthetic */ double accelerationX;
    private /* synthetic */ int ticksInAir;
    
    @Override
    public int getBrightnessForRender() {
        return 15728880;
    }
    
    @Override
    protected void entityInit() {
    }
    
    public EntityFireball(final World llllllllllllllIlIIIllIIIIlIlIllI, final double llllllllllllllIlIIIllIIIIlIlIlIl, final double llllllllllllllIlIIIllIIIIlIlllIl, final double llllllllllllllIlIIIllIIIIlIlllII, final double llllllllllllllIlIIIllIIIIlIlIIlI, final double llllllllllllllIlIIIllIIIIlIllIlI, final double llllllllllllllIlIIIllIIIIlIllIIl) {
        super(llllllllllllllIlIIIllIIIIlIlIllI);
        this.setSize(1.0f, 1.0f);
        this.setLocationAndAngles(llllllllllllllIlIIIllIIIIlIlIlIl, llllllllllllllIlIIIllIIIIlIlllIl, llllllllllllllIlIIIllIIIIlIlllII, this.rotationYaw, this.rotationPitch);
        this.setPosition(llllllllllllllIlIIIllIIIIlIlIlIl, llllllllllllllIlIIIllIIIIlIlllIl, llllllllllllllIlIIIllIIIIlIlllII);
        final double llllllllllllllIlIIIllIIIIlIllIII = MathHelper.sqrt(llllllllllllllIlIIIllIIIIlIlIIlI * llllllllllllllIlIIIllIIIIlIlIIlI + llllllllllllllIlIIIllIIIIlIllIlI * llllllllllllllIlIIIllIIIIlIllIlI + llllllllllllllIlIIIllIIIIlIllIIl * llllllllllllllIlIIIllIIIIlIllIIl);
        this.accelerationX = llllllllllllllIlIIIllIIIIlIlIIlI / llllllllllllllIlIIIllIIIIlIllIII * 0.1;
        this.accelerationY = llllllllllllllIlIIIllIIIIlIllIlI / llllllllllllllIlIIIllIIIIlIllIII * 0.1;
        this.accelerationZ = llllllllllllllIlIIIllIIIIlIllIIl / llllllllllllllIlIIIllIIIIlIllIII * 0.1;
    }
    
    public static void registerFixesFireball(final DataFixer llllllllllllllIlIIIllIIIIIlIIlll, final String llllllllllllllIlIIIllIIIIIlIIllI) {
    }
    
    @Override
    public boolean canBeCollidedWith() {
        return true;
    }
    
    public void readEntityFromNBT(final NBTTagCompound llllllllllllllIlIIIllIIIIIIlIlll) {
        if (llllllllllllllIlIIIllIIIIIIlIlll.hasKey("power", 9)) {
            final NBTTagList llllllllllllllIlIIIllIIIIIIllIlI = llllllllllllllIlIIIllIIIIIIlIlll.getTagList("power", 6);
            if (llllllllllllllIlIIIllIIIIIIllIlI.tagCount() == 3) {
                this.accelerationX = llllllllllllllIlIIIllIIIIIIllIlI.getDoubleAt(0);
                this.accelerationY = llllllllllllllIlIIIllIIIIIIllIlI.getDoubleAt(1);
                this.accelerationZ = llllllllllllllIlIIIllIIIIIIllIlI.getDoubleAt(2);
            }
        }
        this.ticksAlive = llllllllllllllIlIIIllIIIIIIlIlll.getInteger("life");
        if (llllllllllllllIlIIIllIIIIIIlIlll.hasKey("direction", 9) && llllllllllllllIlIIIllIIIIIIlIlll.getTagList("direction", 6).tagCount() == 3) {
            final NBTTagList llllllllllllllIlIIIllIIIIIIllIIl = llllllllllllllIlIIIllIIIIIIlIlll.getTagList("direction", 6);
            this.motionX = llllllllllllllIlIIIllIIIIIIllIIl.getDoubleAt(0);
            this.motionY = llllllllllllllIlIIIllIIIIIIllIIl.getDoubleAt(1);
            this.motionZ = llllllllllllllIlIIIllIIIIIIllIIl.getDoubleAt(2);
        }
        else {
            this.setDead();
        }
    }
    
    @Override
    public float getBrightness() {
        return 1.0f;
    }
    
    public void writeEntityToNBT(final NBTTagCompound llllllllllllllIlIIIllIIIIIlIIIlI) {
        llllllllllllllIlIIIllIIIIIlIIIlI.setTag("direction", this.newDoubleNBTList(this.motionX, this.motionY, this.motionZ));
        llllllllllllllIlIIIllIIIIIlIIIlI.setTag("power", this.newDoubleNBTList(this.accelerationX, this.accelerationY, this.accelerationZ));
        llllllllllllllIlIIIllIIIIIlIIIlI.setInteger("life", this.ticksAlive);
    }
    
    @Override
    public boolean isInRangeToRenderDist(final double llllllllllllllIlIIIllIIIIllIlllI) {
        double llllllllllllllIlIIIllIIIIllIllIl = this.getEntityBoundingBox().getAverageEdgeLength() * 4.0;
        if (Double.isNaN(llllllllllllllIlIIIllIIIIllIllIl)) {
            llllllllllllllIlIIIllIIIIllIllIl = 4.0;
        }
        llllllllllllllIlIIIllIIIIllIllIl *= 64.0;
        return llllllllllllllIlIIIllIIIIllIlllI < llllllllllllllIlIIIllIIIIllIllIl * llllllllllllllIlIIIllIIIIllIllIl;
    }
    
    protected float getMotionFactor() {
        return 0.95f;
    }
    
    @Override
    public float getCollisionBorderSize() {
        return 1.0f;
    }
    
    protected EnumParticleTypes getParticleType() {
        return EnumParticleTypes.SMOKE_NORMAL;
    }
    
    @Override
    public void onUpdate() {
        if (this.world.isRemote || ((this.shootingEntity == null || !this.shootingEntity.isDead) && this.world.isBlockLoaded(new BlockPos(this)))) {
            super.onUpdate();
            if (this.isFireballFiery()) {
                this.setFire(1);
            }
            ++this.ticksInAir;
            final RayTraceResult llllllllllllllIlIIIllIIIIIllIIll = ProjectileHelper.forwardsRaycast(this, true, this.ticksInAir >= 25, this.shootingEntity);
            if (llllllllllllllIlIIIllIIIIIllIIll != null) {
                this.onImpact(llllllllllllllIlIIIllIIIIIllIIll);
            }
            this.posX += this.motionX;
            this.posY += this.motionY;
            this.posZ += this.motionZ;
            ProjectileHelper.rotateTowardsMovement(this, 0.2f);
            float llllllllllllllIlIIIllIIIIIllIIlI = this.getMotionFactor();
            if (this.isInWater()) {
                for (int llllllllllllllIlIIIllIIIIIllIIIl = 0; llllllllllllllIlIIIllIIIIIllIIIl < 4; ++llllllllllllllIlIIIllIIIIIllIIIl) {
                    final float llllllllllllllIlIIIllIIIIIllIIII = 0.25f;
                    this.world.spawnParticle(EnumParticleTypes.WATER_BUBBLE, this.posX - this.motionX * 0.25, this.posY - this.motionY * 0.25, this.posZ - this.motionZ * 0.25, this.motionX, this.motionY, this.motionZ, new int[0]);
                }
                llllllllllllllIlIIIllIIIIIllIIlI = 0.8f;
            }
            this.motionX += this.accelerationX;
            this.motionY += this.accelerationY;
            this.motionZ += this.accelerationZ;
            this.motionX *= llllllllllllllIlIIIllIIIIIllIIlI;
            this.motionY *= llllllllllllllIlIIIllIIIIIllIIlI;
            this.motionZ *= llllllllllllllIlIIIllIIIIIllIIlI;
            this.world.spawnParticle(this.getParticleType(), this.posX, this.posY + 0.5, this.posZ, 0.0, 0.0, 0.0, new int[0]);
            this.setPosition(this.posX, this.posY, this.posZ);
        }
        else {
            this.setDead();
        }
    }
    
    protected boolean isFireballFiery() {
        return true;
    }
    
    public EntityFireball(final World llllllllllllllIlIIIllIIIIIllllll, final EntityLivingBase llllllllllllllIlIIIllIIIIIlllllI, double llllllllllllllIlIIIllIIIIIllllIl, double llllllllllllllIlIIIllIIIIIllllII, double llllllllllllllIlIIIllIIIIIlllIll) {
        super(llllllllllllllIlIIIllIIIIIllllll);
        this.shootingEntity = llllllllllllllIlIIIllIIIIIlllllI;
        this.setSize(1.0f, 1.0f);
        this.setLocationAndAngles(llllllllllllllIlIIIllIIIIIlllllI.posX, llllllllllllllIlIIIllIIIIIlllllI.posY, llllllllllllllIlIIIllIIIIIlllllI.posZ, llllllllllllllIlIIIllIIIIIlllllI.rotationYaw, llllllllllllllIlIIIllIIIIIlllllI.rotationPitch);
        this.setPosition(this.posX, this.posY, this.posZ);
        this.motionX = 0.0;
        this.motionY = 0.0;
        this.motionZ = 0.0;
        llllllllllllllIlIIIllIIIIIllllIl += this.rand.nextGaussian() * 0.4;
        llllllllllllllIlIIIllIIIIIllllII += this.rand.nextGaussian() * 0.4;
        llllllllllllllIlIIIllIIIIIlllIll += this.rand.nextGaussian() * 0.4;
        final double llllllllllllllIlIIIllIIIIlIIIIIl = MathHelper.sqrt(llllllllllllllIlIIIllIIIIIllllIl * llllllllllllllIlIIIllIIIIIllllIl + llllllllllllllIlIIIllIIIIIllllII * llllllllllllllIlIIIllIIIIIllllII + llllllllllllllIlIIIllIIIIIlllIll * llllllllllllllIlIIIllIIIIIlllIll);
        this.accelerationX = llllllllllllllIlIIIllIIIIIllllIl / llllllllllllllIlIIIllIIIIlIIIIIl * 0.1;
        this.accelerationY = llllllllllllllIlIIIllIIIIIllllII / llllllllllllllIlIIIllIIIIlIIIIIl * 0.1;
        this.accelerationZ = llllllllllllllIlIIIllIIIIIlllIll / llllllllllllllIlIIIllIIIIlIIIIIl * 0.1;
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource llllllllllllllIlIIIllIIIIIIIlIll, final float llllllllllllllIlIIIllIIIIIIIlllI) {
        if (this.isEntityInvulnerable(llllllllllllllIlIIIllIIIIIIIlIll)) {
            return false;
        }
        this.setBeenAttacked();
        if (llllllllllllllIlIIIllIIIIIIIlIll.getEntity() != null) {
            final Vec3d llllllllllllllIlIIIllIIIIIIIllIl = llllllllllllllIlIIIllIIIIIIIlIll.getEntity().getLookVec();
            if (llllllllllllllIlIIIllIIIIIIIllIl != null) {
                this.motionX = llllllllllllllIlIIIllIIIIIIIllIl.xCoord;
                this.motionY = llllllllllllllIlIIIllIIIIIIIllIl.yCoord;
                this.motionZ = llllllllllllllIlIIIllIIIIIIIllIl.zCoord;
                this.accelerationX = this.motionX * 0.1;
                this.accelerationY = this.motionY * 0.1;
                this.accelerationZ = this.motionZ * 0.1;
            }
            if (llllllllllllllIlIIIllIIIIIIIlIll.getEntity() instanceof EntityLivingBase) {
                this.shootingEntity = (EntityLivingBase)llllllllllllllIlIIIllIIIIIIIlIll.getEntity();
            }
            return true;
        }
        return false;
    }
    
    protected abstract void onImpact(final RayTraceResult p0);
    
    public EntityFireball(final World llllllllllllllIlIIIllIIIIlllIlII) {
        super(llllllllllllllIlIIIllIIIIlllIlII);
        this.setSize(1.0f, 1.0f);
    }
}
