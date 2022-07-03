package net.minecraft.entity.projectile;

import net.minecraft.entity.passive.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.nbt.*;
import java.util.*;
import net.minecraft.util.math.*;
import javax.annotation.*;
import net.minecraft.block.material.*;

public class EntityLlamaSpit extends Entity implements IProjectile
{
    public /* synthetic */ EntityLlama field_190539_a;
    private /* synthetic */ NBTTagCompound field_190540_b;
    
    public void func_190536_a(final RayTraceResult lllllllllllllIllllIllIIlIlIlIlII) {
        if (lllllllllllllIllllIllIIlIlIlIlII.entityHit != null && this.field_190539_a != null) {
            lllllllllllllIllllIllIIlIlIlIlII.entityHit.attackEntityFrom(DamageSource.causeIndirectDamage(this, this.field_190539_a).setProjectile(), 1.0f);
        }
        if (!this.world.isRemote) {
            this.setDead();
        }
    }
    
    @Override
    public void setVelocity(final double lllllllllllllIllllIllIIllIIlIlIl, final double lllllllllllllIllllIllIIllIIllIIl, final double lllllllllllllIllllIllIIllIIlIIll) {
        this.motionX = lllllllllllllIllllIllIIllIIlIlIl;
        this.motionY = lllllllllllllIllllIllIIllIIllIIl;
        this.motionZ = lllllllllllllIllllIllIIllIIlIIll;
        if (this.prevRotationPitch == 0.0f && this.prevRotationYaw == 0.0f) {
            final float lllllllllllllIllllIllIIllIIlIlll = MathHelper.sqrt(lllllllllllllIllllIllIIllIIlIlIl * lllllllllllllIllllIllIIllIIlIlIl + lllllllllllllIllllIllIIllIIlIIll * lllllllllllllIllllIllIIllIIlIIll);
            this.rotationPitch = (float)(MathHelper.atan2(lllllllllllllIllllIllIIllIIllIIl, lllllllllllllIllllIllIIllIIlIlll) * 57.29577951308232);
            this.rotationYaw = (float)(MathHelper.atan2(lllllllllllllIllllIllIIllIIlIlIl, lllllllllllllIllllIllIIllIIlIIll) * 57.29577951308232);
            this.prevRotationPitch = this.rotationPitch;
            this.prevRotationYaw = this.rotationYaw;
            this.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
        }
    }
    
    @Override
    protected void readEntityFromNBT(final NBTTagCompound lllllllllllllIllllIllIIlIlIIllIl) {
        if (lllllllllllllIllllIllIIlIlIIllIl.hasKey("Owner", 10)) {
            this.field_190540_b = lllllllllllllIllllIllIIlIlIIllIl.getCompoundTag("Owner");
        }
    }
    
    public EntityLlamaSpit(final World lllllllllllllIllllIllIIlllIIIIIl, final double lllllllllllllIllllIllIIlllIIlIlI, final double lllllllllllllIllllIllIIlllIIlIIl, final double lllllllllllllIllllIllIIlllIIlIII, final double lllllllllllllIllllIllIIlllIIIlll, final double lllllllllllllIllllIllIIlllIIIllI, final double lllllllllllllIllllIllIIlllIIIlIl) {
        super(lllllllllllllIllllIllIIlllIIIIIl);
        this.setPosition(lllllllllllllIllllIllIIlllIIlIlI, lllllllllllllIllllIllIIlllIIlIIl, lllllllllllllIllllIllIIlllIIlIII);
        for (int lllllllllllllIllllIllIIlllIIIlII = 0; lllllllllllllIllllIllIIlllIIIlII < 7; ++lllllllllllllIllllIllIIlllIIIlII) {
            final double lllllllllllllIllllIllIIlllIIIIll = 0.4 + 0.1 * lllllllllllllIllllIllIIlllIIIlII;
            lllllllllllllIllllIllIIlllIIIIIl.spawnParticle(EnumParticleTypes.SPIT, lllllllllllllIllllIllIIlllIIlIlI, lllllllllllllIllllIllIIlllIIlIIl, lllllllllllllIllllIllIIlllIIlIII, lllllllllllllIllllIllIIlllIIIlll * lllllllllllllIllllIllIIlllIIIIll, lllllllllllllIllllIllIIlllIIIllI, lllllllllllllIllllIllIIlllIIIlIl * lllllllllllllIllllIllIIlllIIIIll, new int[0]);
        }
        this.motionX = lllllllllllllIllllIllIIlllIIIlll;
        this.motionY = lllllllllllllIllllIllIIlllIIIllI;
        this.motionZ = lllllllllllllIllllIllIIlllIIIlIl;
    }
    
    @Override
    public void setThrowableHeading(double lllllllllllllIllllIllIIlIllIlIII, double lllllllllllllIllllIllIIlIllIIlll, double lllllllllllllIllllIllIIlIllIIllI, final float lllllllllllllIllllIllIIlIlIlllIl, final float lllllllllllllIllllIllIIlIlIlllII) {
        final float lllllllllllllIllllIllIIlIllIIIll = MathHelper.sqrt(lllllllllllllIllllIllIIlIllIlIII * lllllllllllllIllllIllIIlIllIlIII + lllllllllllllIllllIllIIlIllIIlll * lllllllllllllIllllIllIIlIllIIlll + lllllllllllllIllllIllIIlIllIIllI * lllllllllllllIllllIllIIlIllIIllI);
        lllllllllllllIllllIllIIlIllIlIII /= lllllllllllllIllllIllIIlIllIIIll;
        lllllllllllllIllllIllIIlIllIIlll /= lllllllllllllIllllIllIIlIllIIIll;
        lllllllllllllIllllIllIIlIllIIllI /= lllllllllllllIllllIllIIlIllIIIll;
        lllllllllllllIllllIllIIlIllIlIII += this.rand.nextGaussian() * 0.007499999832361937 * lllllllllllllIllllIllIIlIlIlllII;
        lllllllllllllIllllIllIIlIllIIlll += this.rand.nextGaussian() * 0.007499999832361937 * lllllllllllllIllllIllIIlIlIlllII;
        lllllllllllllIllllIllIIlIllIIllI += this.rand.nextGaussian() * 0.007499999832361937 * lllllllllllllIllllIllIIlIlIlllII;
        lllllllllllllIllllIllIIlIllIlIII *= lllllllllllllIllllIllIIlIlIlllIl;
        lllllllllllllIllllIllIIlIllIIlll *= lllllllllllllIllllIllIIlIlIlllIl;
        lllllllllllllIllllIllIIlIllIIllI *= lllllllllllllIllllIllIIlIlIlllIl;
        this.motionX = lllllllllllllIllllIllIIlIllIlIII;
        this.motionY = lllllllllllllIllllIllIIlIllIIlll;
        this.motionZ = lllllllllllllIllllIllIIlIllIIllI;
        final float lllllllllllllIllllIllIIlIllIIIlI = MathHelper.sqrt(lllllllllllllIllllIllIIlIllIlIII * lllllllllllllIllllIllIIlIllIlIII + lllllllllllllIllllIllIIlIllIIllI * lllllllllllllIllllIllIIlIllIIllI);
        this.rotationYaw = (float)(MathHelper.atan2(lllllllllllllIllllIllIIlIllIlIII, lllllllllllllIllllIllIIlIllIIllI) * 57.29577951308232);
        this.rotationPitch = (float)(MathHelper.atan2(lllllllllllllIllllIllIIlIllIIlll, lllllllllllllIllllIllIIlIllIIIlI) * 57.29577951308232);
        this.prevRotationYaw = this.rotationYaw;
        this.prevRotationPitch = this.rotationPitch;
    }
    
    public EntityLlamaSpit(final World lllllllllllllIllllIllIIlllIllIll, final EntityLlama lllllllllllllIllllIllIIlllIlIlll) {
        super(lllllllllllllIllllIllIIlllIllIll);
        this.field_190539_a = lllllllllllllIllllIllIIlllIlIlll;
        this.setPosition(lllllllllllllIllllIllIIlllIlIlll.posX - (lllllllllllllIllllIllIIlllIlIlll.width + 1.0f) * 0.5 * MathHelper.sin(lllllllllllllIllllIllIIlllIlIlll.renderYawOffset * 0.017453292f), lllllllllllllIllllIllIIlllIlIlll.posY + lllllllllllllIllllIllIIlllIlIlll.getEyeHeight() - 0.10000000149011612, lllllllllllllIllllIllIIlllIlIlll.posZ + (lllllllllllllIllllIllIIlllIlIlll.width + 1.0f) * 0.5 * MathHelper.cos(lllllllllllllIllllIllIIlllIlIlll.renderYawOffset * 0.017453292f));
        this.setSize(0.25f, 0.25f);
    }
    
    @Override
    protected void writeEntityToNBT(final NBTTagCompound lllllllllllllIllllIllIIlIlIIIlll) {
        if (this.field_190539_a != null) {
            final NBTTagCompound lllllllllllllIllllIllIIlIlIIIllI = new NBTTagCompound();
            final UUID lllllllllllllIllllIllIIlIlIIIlIl = this.field_190539_a.getUniqueID();
            lllllllllllllIllllIllIIlIlIIIllI.setUniqueId("OwnerUUID", lllllllllllllIllllIllIIlIlIIIlIl);
            lllllllllllllIllllIllIIlIlIIIlll.setTag("Owner", lllllllllllllIllllIllIIlIlIIIllI);
        }
    }
    
    @Nullable
    private Entity func_190538_a(final Vec3d lllllllllllllIllllIllIIlIllllIll, final Vec3d lllllllllllllIllllIllIIllIIIIlII) {
        Entity lllllllllllllIllllIllIIllIIIIIll = null;
        final List<Entity> lllllllllllllIllllIllIIllIIIIIlI = this.world.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox().addCoord(this.motionX, this.motionY, this.motionZ).expandXyz(1.0));
        double lllllllllllllIllllIllIIllIIIIIIl = 0.0;
        for (final Entity lllllllllllllIllllIllIIllIIIIIII : lllllllllllllIllllIllIIllIIIIIlI) {
            if (lllllllllllllIllllIllIIllIIIIIII != this.field_190539_a) {
                final AxisAlignedBB lllllllllllllIllllIllIIlIlllllll = lllllllllllllIllllIllIIllIIIIIII.getEntityBoundingBox().expandXyz(0.30000001192092896);
                final RayTraceResult lllllllllllllIllllIllIIlIllllllI = lllllllllllllIllllIllIIlIlllllll.calculateIntercept(lllllllllllllIllllIllIIlIllllIll, lllllllllllllIllllIllIIllIIIIlII);
                if (lllllllllllllIllllIllIIlIllllllI == null) {
                    continue;
                }
                final double lllllllllllllIllllIllIIlIlllllIl = lllllllllllllIllllIllIIlIllllIll.squareDistanceTo(lllllllllllllIllllIllIIlIllllllI.hitVec);
                if (lllllllllllllIllllIllIIlIlllllIl >= lllllllllllllIllllIllIIllIIIIIIl && lllllllllllllIllllIllIIllIIIIIIl != 0.0) {
                    continue;
                }
                lllllllllllllIllllIllIIllIIIIIll = lllllllllllllIllllIllIIllIIIIIII;
                lllllllllllllIllllIllIIllIIIIIIl = lllllllllllllIllllIllIIlIlllllIl;
            }
        }
        return lllllllllllllIllllIllIIllIIIIIll;
    }
    
    public EntityLlamaSpit(final World lllllllllllllIllllIllIIllllIIIlI) {
        super(lllllllllllllIllllIllIIllllIIIlI);
    }
    
    @Override
    protected void entityInit() {
    }
    
    @Override
    public void onUpdate() {
        super.onUpdate();
        if (this.field_190540_b != null) {
            this.func_190537_j();
        }
        Vec3d lllllllllllllIllllIllIIllIlIllll = new Vec3d(this.posX, this.posY, this.posZ);
        Vec3d lllllllllllllIllllIllIIllIlIlllI = new Vec3d(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
        RayTraceResult lllllllllllllIllllIllIIllIlIllIl = this.world.rayTraceBlocks(lllllllllllllIllllIllIIllIlIllll, lllllllllllllIllllIllIIllIlIlllI);
        lllllllllllllIllllIllIIllIlIllll = new Vec3d(this.posX, this.posY, this.posZ);
        lllllllllllllIllllIllIIllIlIlllI = new Vec3d(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
        if (lllllllllllllIllllIllIIllIlIllIl != null) {
            lllllllllllllIllllIllIIllIlIlllI = new Vec3d(lllllllllllllIllllIllIIllIlIllIl.hitVec.xCoord, lllllllllllllIllllIllIIllIlIllIl.hitVec.yCoord, lllllllllllllIllllIllIIllIlIllIl.hitVec.zCoord);
        }
        final Entity lllllllllllllIllllIllIIllIlIllII = this.func_190538_a(lllllllllllllIllllIllIIllIlIllll, lllllllllllllIllllIllIIllIlIlllI);
        if (lllllllllllllIllllIllIIllIlIllII != null) {
            lllllllllllllIllllIllIIllIlIllIl = new RayTraceResult(lllllllllllllIllllIllIIllIlIllII);
        }
        if (lllllllllllllIllllIllIIllIlIllIl != null) {
            this.func_190536_a(lllllllllllllIllllIllIIllIlIllIl);
        }
        this.posX += this.motionX;
        this.posY += this.motionY;
        this.posZ += this.motionZ;
        final float lllllllllllllIllllIllIIllIlIlIll = MathHelper.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
        this.rotationYaw = (float)(MathHelper.atan2(this.motionX, this.motionZ) * 57.29577951308232);
        this.rotationPitch = (float)(MathHelper.atan2(this.motionY, lllllllllllllIllllIllIIllIlIlIll) * 57.29577951308232);
        while (this.rotationPitch - this.prevRotationPitch < -180.0f) {
            this.prevRotationPitch -= 360.0f;
        }
        while (this.rotationPitch - this.prevRotationPitch >= 180.0f) {
            this.prevRotationPitch += 360.0f;
        }
        while (this.rotationYaw - this.prevRotationYaw < -180.0f) {
            this.prevRotationYaw -= 360.0f;
        }
        while (this.rotationYaw - this.prevRotationYaw >= 180.0f) {
            this.prevRotationYaw += 360.0f;
        }
        this.rotationPitch = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2f;
        this.rotationYaw = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2f;
        final float lllllllllllllIllllIllIIllIlIlIlI = 0.99f;
        final float lllllllllllllIllllIllIIllIlIlIIl = 0.06f;
        if (!this.world.isMaterialInBB(this.getEntityBoundingBox(), Material.AIR)) {
            this.setDead();
        }
        else if (this.isInWater()) {
            this.setDead();
        }
        else {
            this.motionX *= 0.9900000095367432;
            this.motionY *= 0.9900000095367432;
            this.motionZ *= 0.9900000095367432;
            if (!this.hasNoGravity()) {
                this.motionY -= 0.05999999865889549;
            }
            this.setPosition(this.posX, this.posY, this.posZ);
        }
    }
    
    private void func_190537_j() {
        if (this.field_190540_b != null && this.field_190540_b.hasUniqueId("OwnerUUID")) {
            final UUID lllllllllllllIllllIllIIlIIlllIll = this.field_190540_b.getUniqueId("OwnerUUID");
            for (final EntityLlama lllllllllllllIllllIllIIlIIlllIlI : this.world.getEntitiesWithinAABB((Class<? extends Entity>)EntityLlama.class, this.getEntityBoundingBox().expandXyz(15.0))) {
                if (lllllllllllllIllllIllIIlIIlllIlI.getUniqueID().equals(lllllllllllllIllllIllIIlIIlllIll)) {
                    this.field_190539_a = lllllllllllllIllllIllIIlIIlllIlI;
                    break;
                }
            }
        }
        this.field_190540_b = null;
    }
}
