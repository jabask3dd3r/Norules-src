package net.minecraft.entity.item;

import net.minecraft.entity.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.nbt.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.item.*;

public class EntityEnderEye extends Entity
{
    private /* synthetic */ double targetX;
    private /* synthetic */ double targetZ;
    private /* synthetic */ double targetY;
    private /* synthetic */ int despawnTimer;
    private /* synthetic */ boolean shatterOrDrop;
    
    @Override
    protected void entityInit() {
    }
    
    @Override
    public void setVelocity(final double lllIlllIlII, final double lllIlllIIll, final double lllIlllIIlI) {
        this.motionX = lllIlllIlII;
        this.motionY = lllIlllIIll;
        this.motionZ = lllIlllIIlI;
        if (this.prevRotationPitch == 0.0f && this.prevRotationYaw == 0.0f) {
            final float lllIlllIllI = MathHelper.sqrt(lllIlllIlII * lllIlllIlII + lllIlllIIlI * lllIlllIIlI);
            this.rotationYaw = (float)(MathHelper.atan2(lllIlllIlII, lllIlllIIlI) * 57.29577951308232);
            this.rotationPitch = (float)(MathHelper.atan2(lllIlllIIll, lllIlllIllI) * 57.29577951308232);
            this.prevRotationYaw = this.rotationYaw;
            this.prevRotationPitch = this.rotationPitch;
        }
    }
    
    public EntityEnderEye(final World llllIllIIll) {
        super(llllIllIIll);
        this.setSize(0.25f, 0.25f);
    }
    
    public void moveTowards(final BlockPos llllIIIlllI) {
        final double llllIIIllIl = llllIIIlllI.getX();
        final int llllIIIllII = llllIIIlllI.getY();
        final double llllIIIlIll = llllIIIlllI.getZ();
        final double llllIIIlIlI = llllIIIllIl - this.posX;
        final double llllIIIlIIl = llllIIIlIll - this.posZ;
        final float llllIIIlIII = MathHelper.sqrt(llllIIIlIlI * llllIIIlIlI + llllIIIlIIl * llllIIIlIIl);
        if (llllIIIlIII > 12.0f) {
            this.targetX = this.posX + llllIIIlIlI / llllIIIlIII * 12.0;
            this.targetZ = this.posZ + llllIIIlIIl / llllIIIlIII * 12.0;
            this.targetY = this.posY + 8.0;
        }
        else {
            this.targetX = llllIIIllIl;
            this.targetY = llllIIIllII;
            this.targetZ = llllIIIlIll;
        }
        this.despawnTimer = 0;
        this.shatterOrDrop = (this.rand.nextInt(5) > 0);
    }
    
    public void readEntityFromNBT(final NBTTagCompound lllIlIlIlII) {
    }
    
    @Override
    public int getBrightnessForRender() {
        return 15728880;
    }
    
    @Override
    public boolean canBeAttackedWithItem() {
        return false;
    }
    
    @Override
    public boolean isInRangeToRenderDist(final double llllIlIlIII) {
        double llllIlIlIlI = this.getEntityBoundingBox().getAverageEdgeLength() * 4.0;
        if (Double.isNaN(llllIlIlIlI)) {
            llllIlIlIlI = 4.0;
        }
        llllIlIlIlI *= 64.0;
        return llllIlIlIII < llllIlIlIlI * llllIlIlIlI;
    }
    
    public void writeEntityToNBT(final NBTTagCompound lllIlIlIllI) {
    }
    
    public EntityEnderEye(final World llllIIllIll, final double llllIIlllll, final double llllIIllIIl, final double llllIIlllIl) {
        super(llllIIllIll);
        this.despawnTimer = 0;
        this.setSize(0.25f, 0.25f);
        this.setPosition(llllIIlllll, llllIIllIIl, llllIIlllIl);
    }
    
    @Override
    public void onUpdate() {
        this.lastTickPosX = this.posX;
        this.lastTickPosY = this.posY;
        this.lastTickPosZ = this.posZ;
        super.onUpdate();
        this.posX += this.motionX;
        this.posY += this.motionY;
        this.posZ += this.motionZ;
        final float lllIllIIlll = MathHelper.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
        this.rotationYaw = (float)(MathHelper.atan2(this.motionX, this.motionZ) * 57.29577951308232);
        this.rotationPitch = (float)(MathHelper.atan2(this.motionY, lllIllIIlll) * 57.29577951308232);
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
        if (!this.world.isRemote) {
            final double lllIllIIllI = this.targetX - this.posX;
            final double lllIllIIlIl = this.targetZ - this.posZ;
            final float lllIllIIlII = (float)Math.sqrt(lllIllIIllI * lllIllIIllI + lllIllIIlIl * lllIllIIlIl);
            final float lllIllIIIll = (float)MathHelper.atan2(lllIllIIlIl, lllIllIIllI);
            double lllIllIIIlI = lllIllIIlll + (lllIllIIlII - lllIllIIlll) * 0.0025;
            if (lllIllIIlII < 1.0f) {
                lllIllIIIlI *= 0.8;
                this.motionY *= 0.8;
            }
            this.motionX = Math.cos(lllIllIIIll) * lllIllIIIlI;
            this.motionZ = Math.sin(lllIllIIIll) * lllIllIIIlI;
            if (this.posY < this.targetY) {
                this.motionY += (1.0 - this.motionY) * 0.014999999664723873;
            }
            else {
                this.motionY += (-1.0 - this.motionY) * 0.014999999664723873;
            }
        }
        final float lllIllIIIIl = 0.25f;
        if (this.isInWater()) {
            for (int lllIllIIIII = 0; lllIllIIIII < 4; ++lllIllIIIII) {
                this.world.spawnParticle(EnumParticleTypes.WATER_BUBBLE, this.posX - this.motionX * 0.25, this.posY - this.motionY * 0.25, this.posZ - this.motionZ * 0.25, this.motionX, this.motionY, this.motionZ, new int[0]);
            }
        }
        else {
            this.world.spawnParticle(EnumParticleTypes.PORTAL, this.posX - this.motionX * 0.25 + this.rand.nextDouble() * 0.6 - 0.3, this.posY - this.motionY * 0.25 - 0.5, this.posZ - this.motionZ * 0.25 + this.rand.nextDouble() * 0.6 - 0.3, this.motionX, this.motionY, this.motionZ, new int[0]);
        }
        if (!this.world.isRemote) {
            this.setPosition(this.posX, this.posY, this.posZ);
            ++this.despawnTimer;
            if (this.despawnTimer > 80 && !this.world.isRemote) {
                this.playSound(SoundEvents.field_193777_bb, 1.0f, 1.0f);
                this.setDead();
                if (this.shatterOrDrop) {
                    this.world.spawnEntityInWorld(new EntityItem(this.world, this.posX, this.posY, this.posZ, new ItemStack(Items.ENDER_EYE)));
                }
                else {
                    this.world.playEvent(2003, new BlockPos(this), 0);
                }
            }
        }
    }
    
    @Override
    public float getBrightness() {
        return 1.0f;
    }
}
