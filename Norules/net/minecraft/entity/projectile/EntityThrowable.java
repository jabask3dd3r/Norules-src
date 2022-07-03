package net.minecraft.entity.projectile;

import net.minecraft.block.*;
import net.minecraft.entity.*;
import net.minecraft.util.datafix.*;
import net.minecraft.nbt.*;
import net.minecraft.entity.player.*;
import net.minecraft.init.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import java.util.*;
import javax.annotation.*;

public abstract class EntityThrowable extends Entity implements IProjectile
{
    private /* synthetic */ int zTile;
    protected /* synthetic */ boolean inGround;
    public /* synthetic */ Entity ignoreEntity;
    private /* synthetic */ int xTile;
    private /* synthetic */ Block inTile;
    protected /* synthetic */ EntityLivingBase thrower;
    private /* synthetic */ int ticksInGround;
    public /* synthetic */ int throwableShake;
    private /* synthetic */ int yTile;
    private /* synthetic */ String throwerName;
    private /* synthetic */ int ignoreTime;
    private /* synthetic */ int ticksInAir;
    
    public static void registerFixesThrowable(final DataFixer llllllllllllIllllllIIlIlIllllIIl, final String llllllllllllIllllllIIlIlIllllIII) {
    }
    
    @Override
    public void setVelocity(final double llllllllllllIllllllIIlIllIlIllll, final double llllllllllllIllllllIIlIllIlIlIIl, final double llllllllllllIllllllIIlIllIlIlIII) {
        this.motionX = llllllllllllIllllllIIlIllIlIllll;
        this.motionY = llllllllllllIllllllIIlIllIlIlIIl;
        this.motionZ = llllllllllllIllllllIIlIllIlIlIII;
        if (this.prevRotationPitch == 0.0f && this.prevRotationYaw == 0.0f) {
            final float llllllllllllIllllllIIlIllIlIllII = MathHelper.sqrt(llllllllllllIllllllIIlIllIlIllll * llllllllllllIllllllIIlIllIlIllll + llllllllllllIllllllIIlIllIlIlIII * llllllllllllIllllllIIlIllIlIlIII);
            this.rotationYaw = (float)(MathHelper.atan2(llllllllllllIllllllIIlIllIlIllll, llllllllllllIllllllIIlIllIlIlIII) * 57.29577951308232);
            this.rotationPitch = (float)(MathHelper.atan2(llllllllllllIllllllIIlIllIlIlIIl, llllllllllllIllllllIIlIllIlIllII) * 57.29577951308232);
            this.prevRotationYaw = this.rotationYaw;
            this.prevRotationPitch = this.rotationPitch;
        }
    }
    
    protected abstract void onImpact(final RayTraceResult p0);
    
    public EntityThrowable(final World llllllllllllIllllllIIllIIIIIlllI) {
        super(llllllllllllIllllllIIllIIIIIlllI);
        this.xTile = -1;
        this.yTile = -1;
        this.zTile = -1;
        this.setSize(0.25f, 0.25f);
    }
    
    public void writeEntityToNBT(final NBTTagCompound llllllllllllIllllllIIlIlIlllIIll) {
        llllllllllllIllllllIIlIlIlllIIll.setInteger("xTile", this.xTile);
        llllllllllllIllllllIIlIlIlllIIll.setInteger("yTile", this.yTile);
        llllllllllllIllllllIIlIlIlllIIll.setInteger("zTile", this.zTile);
        final ResourceLocation llllllllllllIllllllIIlIlIlllIIlI = Block.REGISTRY.getNameForObject(this.inTile);
        llllllllllllIllllllIIlIlIlllIIll.setString("inTile", (llllllllllllIllllllIIlIlIlllIIlI == null) ? "" : llllllllllllIllllllIIlIlIlllIIlI.toString());
        llllllllllllIllllllIIlIlIlllIIll.setByte("shake", (byte)this.throwableShake);
        llllllllllllIllllllIIlIlIlllIIll.setByte("inGround", (byte)(this.inGround ? 1 : 0));
        if ((this.throwerName == null || this.throwerName.isEmpty()) && this.thrower instanceof EntityPlayer) {
            this.throwerName = this.thrower.getName();
        }
        llllllllllllIllllllIIlIlIlllIIll.setString("ownerName", (this.throwerName == null) ? "" : this.throwerName);
    }
    
    @Override
    public void onUpdate() {
        this.lastTickPosX = this.posX;
        this.lastTickPosY = this.posY;
        this.lastTickPosZ = this.posZ;
        super.onUpdate();
        if (this.throwableShake > 0) {
            --this.throwableShake;
        }
        if (this.inGround) {
            if (this.world.getBlockState(new BlockPos(this.xTile, this.yTile, this.zTile)).getBlock() == this.inTile) {
                ++this.ticksInGround;
                if (this.ticksInGround == 1200) {
                    this.setDead();
                }
                return;
            }
            this.inGround = false;
            this.motionX *= this.rand.nextFloat() * 0.2f;
            this.motionY *= this.rand.nextFloat() * 0.2f;
            this.motionZ *= this.rand.nextFloat() * 0.2f;
            this.ticksInGround = 0;
            this.ticksInAir = 0;
        }
        else {
            ++this.ticksInAir;
        }
        Vec3d llllllllllllIllllllIIlIllIIllIII = new Vec3d(this.posX, this.posY, this.posZ);
        Vec3d llllllllllllIllllllIIlIllIIlIlll = new Vec3d(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
        RayTraceResult llllllllllllIllllllIIlIllIIlIllI = this.world.rayTraceBlocks(llllllllllllIllllllIIlIllIIllIII, llllllllllllIllllllIIlIllIIlIlll);
        llllllllllllIllllllIIlIllIIllIII = new Vec3d(this.posX, this.posY, this.posZ);
        llllllllllllIllllllIIlIllIIlIlll = new Vec3d(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
        if (llllllllllllIllllllIIlIllIIlIllI != null) {
            llllllllllllIllllllIIlIllIIlIlll = new Vec3d(llllllllllllIllllllIIlIllIIlIllI.hitVec.xCoord, llllllllllllIllllllIIlIllIIlIllI.hitVec.yCoord, llllllllllllIllllllIIlIllIIlIllI.hitVec.zCoord);
        }
        Entity llllllllllllIllllllIIlIllIIlIlIl = null;
        final List<Entity> llllllllllllIllllllIIlIllIIlIlII = this.world.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox().addCoord(this.motionX, this.motionY, this.motionZ).expandXyz(1.0));
        double llllllllllllIllllllIIlIllIIlIIll = 0.0;
        boolean llllllllllllIllllllIIlIllIIlIIlI = false;
        for (int llllllllllllIllllllIIlIllIIlIIIl = 0; llllllllllllIllllllIIlIllIIlIIIl < llllllllllllIllllllIIlIllIIlIlII.size(); ++llllllllllllIllllllIIlIllIIlIIIl) {
            final Entity llllllllllllIllllllIIlIllIIlIIII = llllllllllllIllllllIIlIllIIlIlII.get(llllllllllllIllllllIIlIllIIlIIIl);
            if (llllllllllllIllllllIIlIllIIlIIII.canBeCollidedWith()) {
                if (llllllllllllIllllllIIlIllIIlIIII == this.ignoreEntity) {
                    llllllllllllIllllllIIlIllIIlIIlI = true;
                }
                else if (this.thrower != null && this.ticksExisted < 2 && this.ignoreEntity == null) {
                    this.ignoreEntity = llllllllllllIllllllIIlIllIIlIIII;
                    llllllllllllIllllllIIlIllIIlIIlI = true;
                }
                else {
                    llllllllllllIllllllIIlIllIIlIIlI = false;
                    final AxisAlignedBB llllllllllllIllllllIIlIllIIIllll = llllllllllllIllllllIIlIllIIlIIII.getEntityBoundingBox().expandXyz(0.30000001192092896);
                    final RayTraceResult llllllllllllIllllllIIlIllIIIlllI = llllllllllllIllllllIIlIllIIIllll.calculateIntercept(llllllllllllIllllllIIlIllIIllIII, llllllllllllIllllllIIlIllIIlIlll);
                    if (llllllllllllIllllllIIlIllIIIlllI != null) {
                        final double llllllllllllIllllllIIlIllIIIllIl = llllllllllllIllllllIIlIllIIllIII.squareDistanceTo(llllllllllllIllllllIIlIllIIIlllI.hitVec);
                        if (llllllllllllIllllllIIlIllIIIllIl < llllllllllllIllllllIIlIllIIlIIll || llllllllllllIllllllIIlIllIIlIIll == 0.0) {
                            llllllllllllIllllllIIlIllIIlIlIl = llllllllllllIllllllIIlIllIIlIIII;
                            llllllllllllIllllllIIlIllIIlIIll = llllllllllllIllllllIIlIllIIIllIl;
                        }
                    }
                }
            }
        }
        if (this.ignoreEntity != null) {
            if (llllllllllllIllllllIIlIllIIlIIlI) {
                this.ignoreTime = 2;
            }
            else if (this.ignoreTime-- <= 0) {
                this.ignoreEntity = null;
            }
        }
        if (llllllllllllIllllllIIlIllIIlIlIl != null) {
            llllllllllllIllllllIIlIllIIlIllI = new RayTraceResult(llllllllllllIllllllIIlIllIIlIlIl);
        }
        if (llllllllllllIllllllIIlIllIIlIllI != null) {
            if (llllllllllllIllllllIIlIllIIlIllI.typeOfHit == RayTraceResult.Type.BLOCK && this.world.getBlockState(llllllllllllIllllllIIlIllIIlIllI.getBlockPos()).getBlock() == Blocks.PORTAL) {
                this.setPortal(llllllllllllIllllllIIlIllIIlIllI.getBlockPos());
            }
            else {
                this.onImpact(llllllllllllIllllllIIlIllIIlIllI);
            }
        }
        this.posX += this.motionX;
        this.posY += this.motionY;
        this.posZ += this.motionZ;
        final float llllllllllllIllllllIIlIllIIIllII = MathHelper.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
        this.rotationYaw = (float)(MathHelper.atan2(this.motionX, this.motionZ) * 57.29577951308232);
        this.rotationPitch = (float)(MathHelper.atan2(this.motionY, llllllllllllIllllllIIlIllIIIllII) * 57.29577951308232);
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
        float llllllllllllIllllllIIlIllIIIlIll = 0.99f;
        final float llllllllllllIllllllIIlIllIIIlIlI = this.getGravityVelocity();
        if (this.isInWater()) {
            for (int llllllllllllIllllllIIlIllIIIlIIl = 0; llllllllllllIllllllIIlIllIIIlIIl < 4; ++llllllllllllIllllllIIlIllIIIlIIl) {
                final float llllllllllllIllllllIIlIllIIIlIII = 0.25f;
                this.world.spawnParticle(EnumParticleTypes.WATER_BUBBLE, this.posX - this.motionX * 0.25, this.posY - this.motionY * 0.25, this.posZ - this.motionZ * 0.25, this.motionX, this.motionY, this.motionZ, new int[0]);
            }
            llllllllllllIllllllIIlIllIIIlIll = 0.8f;
        }
        this.motionX *= llllllllllllIllllllIIlIllIIIlIll;
        this.motionY *= llllllllllllIllllllIIlIllIIIlIll;
        this.motionZ *= llllllllllllIllllllIIlIllIIIlIll;
        if (!this.hasNoGravity()) {
            this.motionY -= llllllllllllIllllllIIlIllIIIlIlI;
        }
        this.setPosition(this.posX, this.posY, this.posZ);
    }
    
    public void setHeadingFromThrower(final Entity llllllllllllIllllllIIlIlllIlIllI, final float llllllllllllIllllllIIlIlllIlllll, final float llllllllllllIllllllIIlIlllIllllI, final float llllllllllllIllllllIIlIlllIlIIll, final float llllllllllllIllllllIIlIlllIlllII, final float llllllllllllIllllllIIlIlllIllIll) {
        final float llllllllllllIllllllIIlIlllIllIlI = -MathHelper.sin(llllllllllllIllllllIIlIlllIllllI * 0.017453292f) * MathHelper.cos(llllllllllllIllllllIIlIlllIlllll * 0.017453292f);
        final float llllllllllllIllllllIIlIlllIllIIl = -MathHelper.sin((llllllllllllIllllllIIlIlllIlllll + llllllllllllIllllllIIlIlllIlIIll) * 0.017453292f);
        final float llllllllllllIllllllIIlIlllIllIII = MathHelper.cos(llllllllllllIllllllIIlIlllIllllI * 0.017453292f) * MathHelper.cos(llllllllllllIllllllIIlIlllIlllll * 0.017453292f);
        this.setThrowableHeading(llllllllllllIllllllIIlIlllIllIlI, llllllllllllIllllllIIlIlllIllIIl, llllllllllllIllllllIIlIlllIllIII, llllllllllllIllllllIIlIlllIlllII, llllllllllllIllllllIIlIlllIllIll);
        this.motionX += llllllllllllIllllllIIlIlllIlIllI.motionX;
        this.motionZ += llllllllllllIllllllIIlIlllIlIllI.motionZ;
        if (!llllllllllllIllllllIIlIlllIlIllI.onGround) {
            this.motionY += llllllllllllIllllllIIlIlllIlIllI.motionY;
        }
    }
    
    @Override
    public void setThrowableHeading(double llllllllllllIllllllIIlIllIllllII, double llllllllllllIllllllIIlIlllIIIIll, double llllllllllllIllllllIIlIlllIIIIlI, final float llllllllllllIllllllIIlIlllIIIIIl, final float llllllllllllIllllllIIlIllIlllIII) {
        final float llllllllllllIllllllIIlIllIllllll = MathHelper.sqrt(llllllllllllIllllllIIlIllIllllII * llllllllllllIllllllIIlIllIllllII + llllllllllllIllllllIIlIlllIIIIll * llllllllllllIllllllIIlIlllIIIIll + llllllllllllIllllllIIlIlllIIIIlI * llllllllllllIllllllIIlIlllIIIIlI);
        llllllllllllIllllllIIlIllIllllII /= llllllllllllIllllllIIlIllIllllll;
        llllllllllllIllllllIIlIlllIIIIll /= llllllllllllIllllllIIlIllIllllll;
        llllllllllllIllllllIIlIlllIIIIlI /= llllllllllllIllllllIIlIllIllllll;
        llllllllllllIllllllIIlIllIllllII += this.rand.nextGaussian() * 0.007499999832361937 * llllllllllllIllllllIIlIllIlllIII;
        llllllllllllIllllllIIlIlllIIIIll += this.rand.nextGaussian() * 0.007499999832361937 * llllllllllllIllllllIIlIllIlllIII;
        llllllllllllIllllllIIlIlllIIIIlI += this.rand.nextGaussian() * 0.007499999832361937 * llllllllllllIllllllIIlIllIlllIII;
        llllllllllllIllllllIIlIllIllllII *= llllllllllllIllllllIIlIlllIIIIIl;
        llllllllllllIllllllIIlIlllIIIIll *= llllllllllllIllllllIIlIlllIIIIIl;
        llllllllllllIllllllIIlIlllIIIIlI *= llllllllllllIllllllIIlIlllIIIIIl;
        this.motionX = llllllllllllIllllllIIlIllIllllII;
        this.motionY = llllllllllllIllllllIIlIlllIIIIll;
        this.motionZ = llllllllllllIllllllIIlIlllIIIIlI;
        final float llllllllllllIllllllIIlIllIlllllI = MathHelper.sqrt(llllllllllllIllllllIIlIllIllllII * llllllllllllIllllllIIlIllIllllII + llllllllllllIllllllIIlIlllIIIIlI * llllllllllllIllllllIIlIlllIIIIlI);
        this.rotationYaw = (float)(MathHelper.atan2(llllllllllllIllllllIIlIllIllllII, llllllllllllIllllllIIlIlllIIIIlI) * 57.29577951308232);
        this.rotationPitch = (float)(MathHelper.atan2(llllllllllllIllllllIIlIlllIIIIll, llllllllllllIllllllIIlIllIlllllI) * 57.29577951308232);
        this.prevRotationYaw = this.rotationYaw;
        this.prevRotationPitch = this.rotationPitch;
        this.ticksInGround = 0;
    }
    
    protected float getGravityVelocity() {
        return 0.03f;
    }
    
    public void readEntityFromNBT(final NBTTagCompound llllllllllllIllllllIIlIlIllIlIIl) {
        this.xTile = llllllllllllIllllllIIlIlIllIlIIl.getInteger("xTile");
        this.yTile = llllllllllllIllllllIIlIlIllIlIIl.getInteger("yTile");
        this.zTile = llllllllllllIllllllIIlIlIllIlIIl.getInteger("zTile");
        if (llllllllllllIllllllIIlIlIllIlIIl.hasKey("inTile", 8)) {
            this.inTile = Block.getBlockFromName(llllllllllllIllllllIIlIlIllIlIIl.getString("inTile"));
        }
        else {
            this.inTile = Block.getBlockById(llllllllllllIllllllIIlIlIllIlIIl.getByte("inTile") & 0xFF);
        }
        this.throwableShake = (llllllllllllIllllllIIlIlIllIlIIl.getByte("shake") & 0xFF);
        this.inGround = (llllllllllllIllllllIIlIlIllIlIIl.getByte("inGround") == 1);
        this.thrower = null;
        this.throwerName = llllllllllllIllllllIIlIlIllIlIIl.getString("ownerName");
        if (this.throwerName != null && this.throwerName.isEmpty()) {
            this.throwerName = null;
        }
        this.thrower = this.getThrower();
    }
    
    @Override
    public boolean isInRangeToRenderDist(final double llllllllllllIllllllIIlIlllllIIII) {
        double llllllllllllIllllllIIlIllllIllll = this.getEntityBoundingBox().getAverageEdgeLength() * 4.0;
        if (Double.isNaN(llllllllllllIllllllIIlIllllIllll)) {
            llllllllllllIllllllIIlIllllIllll = 4.0;
        }
        llllllllllllIllllllIIlIllllIllll *= 64.0;
        return llllllllllllIllllllIIlIlllllIIII < llllllllllllIllllllIIlIllllIllll * llllllllllllIllllllIIlIllllIllll;
    }
    
    @Nullable
    public EntityLivingBase getThrower() {
        if (this.thrower == null && this.throwerName != null && !this.throwerName.isEmpty()) {
            this.thrower = this.world.getPlayerEntityByName(this.throwerName);
            if (this.thrower == null && this.world instanceof WorldServer) {
                try {
                    final Entity llllllllllllIllllllIIlIlIllIIlIl = ((WorldServer)this.world).getEntityFromUuid(UUID.fromString(this.throwerName));
                    if (llllllllllllIllllllIIlIlIllIIlIl instanceof EntityLivingBase) {
                        this.thrower = (EntityLivingBase)llllllllllllIllllllIIlIlIllIIlIl;
                    }
                }
                catch (Throwable llllllllllllIllllllIIlIlIllIIlII) {
                    this.thrower = null;
                }
            }
        }
        return this.thrower;
    }
    
    public EntityThrowable(final World llllllllllllIllllllIIllIIIIIIIlI, final double llllllllllllIllllllIIllIIIIIIllI, final double llllllllllllIllllllIIllIIIIIIIII, final double llllllllllllIllllllIIllIIIIIIlII) {
        this(llllllllllllIllllllIIllIIIIIIIlI);
        this.setPosition(llllllllllllIllllllIIllIIIIIIllI, llllllllllllIllllllIIllIIIIIIIII, llllllllllllIllllllIIllIIIIIIlII);
    }
    
    public EntityThrowable(final World llllllllllllIllllllIIlIllllllIlI, final EntityLivingBase llllllllllllIllllllIIlIlllllIllI) {
        this(llllllllllllIllllllIIlIllllllIlI, llllllllllllIllllllIIlIlllllIllI.posX, llllllllllllIllllllIIlIlllllIllI.posY + llllllllllllIllllllIIlIlllllIllI.getEyeHeight() - 0.10000000149011612, llllllllllllIllllllIIlIlllllIllI.posZ);
        this.thrower = llllllllllllIllllllIIlIlllllIllI;
    }
    
    @Override
    protected void entityInit() {
    }
}
