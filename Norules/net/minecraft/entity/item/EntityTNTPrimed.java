package net.minecraft.entity.item;

import javax.annotation.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.nbt.*;
import net.minecraft.world.*;
import net.minecraft.network.datasync.*;

public class EntityTNTPrimed extends Entity
{
    @Nullable
    private /* synthetic */ EntityLivingBase tntPlacedBy;
    private static final /* synthetic */ DataParameter<Integer> FUSE;
    private /* synthetic */ int fuse;
    
    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (!this.hasNoGravity()) {
            this.motionY -= 0.03999999910593033;
        }
        this.moveEntity(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.9800000190734863;
        this.motionY *= 0.9800000190734863;
        this.motionZ *= 0.9800000190734863;
        if (this.onGround) {
            this.motionX *= 0.699999988079071;
            this.motionZ *= 0.699999988079071;
            this.motionY *= -0.5;
        }
        --this.fuse;
        if (this.fuse <= 0) {
            this.setDead();
            if (!this.world.isRemote) {
                this.explode();
            }
        }
        else {
            this.handleWaterMovement();
            this.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, this.posX, this.posY + 0.5, this.posZ, 0.0, 0.0, 0.0, new int[0]);
        }
    }
    
    @Override
    protected void readEntityFromNBT(final NBTTagCompound llllllllllllllIIlIIIlIIIlIlIIIIl) {
        this.setFuse(llllllllllllllIIlIIIlIIIlIlIIIIl.getShort("Fuse"));
    }
    
    @Override
    public boolean canBeCollidedWith() {
        return !this.isDead;
    }
    
    @Override
    public void notifyDataManagerChange(final DataParameter<?> llllllllllllllIIlIIIlIIIlIIlIIIl) {
        if (EntityTNTPrimed.FUSE.equals(llllllllllllllIIlIIIlIIIlIIlIIIl)) {
            this.fuse = this.getFuseDataManager();
        }
    }
    
    public EntityTNTPrimed(final World llllllllllllllIIlIIIlIIIllIIIIlI, final double llllllllllllllIIlIIIlIIIllIIIIIl, final double llllllllllllllIIlIIIlIIIllIIIlll, final double llllllllllllllIIlIIIlIIIllIIIllI, final EntityLivingBase llllllllllllllIIlIIIlIIIllIIIlIl) {
        this(llllllllllllllIIlIIIlIIIllIIIIlI);
        this.setPosition(llllllllllllllIIlIIIlIIIllIIIIIl, llllllllllllllIIlIIIlIIIllIIIlll, llllllllllllllIIlIIIlIIIllIIIllI);
        final float llllllllllllllIIlIIIlIIIllIIIlII = (float)(Math.random() * 6.283185307179586);
        this.motionX = -(float)Math.sin(llllllllllllllIIlIIIlIIIllIIIlII) * 0.02f;
        this.motionY = 0.20000000298023224;
        this.motionZ = -(float)Math.cos(llllllllllllllIIlIIIlIIIllIIIlII) * 0.02f;
        this.setFuse(80);
        this.prevPosX = llllllllllllllIIlIIIlIIIllIIIIIl;
        this.prevPosY = llllllllllllllIIlIIIlIIIllIIIlll;
        this.prevPosZ = llllllllllllllIIlIIIlIIIllIIIllI;
        this.tntPlacedBy = llllllllllllllIIlIIIlIIIllIIIlIl;
    }
    
    static {
        FUSE = EntityDataManager.createKey(EntityTNTPrimed.class, DataSerializers.VARINT);
    }
    
    @Override
    public float getEyeHeight() {
        return 0.0f;
    }
    
    public void setFuse(final int llllllllllllllIIlIIIlIIIlIIlIlll) {
        this.dataManager.set(EntityTNTPrimed.FUSE, llllllllllllllIIlIIIlIIIlIIlIlll);
        this.fuse = llllllllllllllIIlIIIlIIIlIIlIlll;
    }
    
    public EntityTNTPrimed(final World llllllllllllllIIlIIIlIIIllIlIIlI) {
        super(llllllllllllllIIlIIIlIIIllIlIIlI);
        this.fuse = 80;
        this.preventEntitySpawning = true;
        this.isImmuneToFire = true;
        this.setSize(0.98f, 0.98f);
    }
    
    @Nullable
    public EntityLivingBase getTntPlacedBy() {
        return this.tntPlacedBy;
    }
    
    @Override
    protected void entityInit() {
        this.dataManager.register(EntityTNTPrimed.FUSE, 80);
    }
    
    private void explode() {
        final float llllllllllllllIIlIIIlIIIlIlIllll = 4.0f;
        this.world.createExplosion(this, this.posX, this.posY + this.height / 16.0f, this.posZ, 4.0f, true);
    }
    
    @Override
    protected boolean canTriggerWalking() {
        return false;
    }
    
    @Override
    protected void writeEntityToNBT(final NBTTagCompound llllllllllllllIIlIIIlIIIlIlIIlll) {
        llllllllllllllIIlIIIlIIIlIlIIlll.setShort("Fuse", (short)this.getFuse());
    }
    
    public int getFuseDataManager() {
        return this.dataManager.get(EntityTNTPrimed.FUSE);
    }
    
    public int getFuse() {
        return this.fuse;
    }
}
