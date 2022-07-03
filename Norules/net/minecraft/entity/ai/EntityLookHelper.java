package net.minecraft.entity.ai;

import net.minecraft.util.math.*;
import net.minecraft.entity.*;

public class EntityLookHelper
{
    private /* synthetic */ double posY;
    private /* synthetic */ double posX;
    private /* synthetic */ boolean isLooking;
    private /* synthetic */ float deltaLookPitch;
    private final /* synthetic */ EntityLiving entity;
    private /* synthetic */ float deltaLookYaw;
    private /* synthetic */ double posZ;
    
    public double getLookPosZ() {
        return this.posZ;
    }
    
    public void onUpdateLook() {
        this.entity.rotationPitch = 0.0f;
        if (this.isLooking) {
            this.isLooking = false;
            final double lllllllllllllIlllIlllIIllIllllll = this.posX - this.entity.posX;
            final double lllllllllllllIlllIlllIIllIlllllI = this.posY - (this.entity.posY + this.entity.getEyeHeight());
            final double lllllllllllllIlllIlllIIllIllllIl = this.posZ - this.entity.posZ;
            final double lllllllllllllIlllIlllIIllIllllII = MathHelper.sqrt(lllllllllllllIlllIlllIIllIllllll * lllllllllllllIlllIlllIIllIllllll + lllllllllllllIlllIlllIIllIllllIl * lllllllllllllIlllIlllIIllIllllIl);
            final float lllllllllllllIlllIlllIIllIlllIll = (float)(MathHelper.atan2(lllllllllllllIlllIlllIIllIllllIl, lllllllllllllIlllIlllIIllIllllll) * 57.29577951308232) - 90.0f;
            final float lllllllllllllIlllIlllIIllIlllIlI = (float)(-(MathHelper.atan2(lllllllllllllIlllIlllIIllIlllllI, lllllllllllllIlllIlllIIllIllllII) * 57.29577951308232));
            this.entity.rotationPitch = this.updateRotation(this.entity.rotationPitch, lllllllllllllIlllIlllIIllIlllIlI, this.deltaLookPitch);
            this.entity.rotationYawHead = this.updateRotation(this.entity.rotationYawHead, lllllllllllllIlllIlllIIllIlllIll, this.deltaLookYaw);
        }
        else {
            this.entity.rotationYawHead = this.updateRotation(this.entity.rotationYawHead, this.entity.renderYawOffset, 10.0f);
        }
        final float lllllllllllllIlllIlllIIllIlllIIl = MathHelper.wrapDegrees(this.entity.rotationYawHead - this.entity.renderYawOffset);
        if (!this.entity.getNavigator().noPath()) {
            if (lllllllllllllIlllIlllIIllIlllIIl < -75.0f) {
                this.entity.rotationYawHead = this.entity.renderYawOffset - 75.0f;
            }
            if (lllllllllllllIlllIlllIIllIlllIIl > 75.0f) {
                this.entity.rotationYawHead = this.entity.renderYawOffset + 75.0f;
            }
        }
    }
    
    public void setLookPosition(final double lllllllllllllIlllIlllIIlllIIllII, final double lllllllllllllIlllIlllIIlllIlIIIl, final double lllllllllllllIlllIlllIIlllIIlIlI, final float lllllllllllllIlllIlllIIlllIIllll, final float lllllllllllllIlllIlllIIlllIIlIII) {
        this.posX = lllllllllllllIlllIlllIIlllIIllII;
        this.posY = lllllllllllllIlllIlllIIlllIlIIIl;
        this.posZ = lllllllllllllIlllIlllIIlllIIlIlI;
        this.deltaLookYaw = lllllllllllllIlllIlllIIlllIIllll;
        this.deltaLookPitch = lllllllllllllIlllIlllIIlllIIlIII;
        this.isLooking = true;
    }
    
    public boolean getIsLooking() {
        return this.isLooking;
    }
    
    private float updateRotation(final float lllllllllllllIlllIlllIIllIlIllII, final float lllllllllllllIlllIlllIIllIlIlIll, final float lllllllllllllIlllIlllIIllIlIIllI) {
        float lllllllllllllIlllIlllIIllIlIlIIl = MathHelper.wrapDegrees(lllllllllllllIlllIlllIIllIlIlIll - lllllllllllllIlllIlllIIllIlIllII);
        if (lllllllllllllIlllIlllIIllIlIlIIl > lllllllllllllIlllIlllIIllIlIIllI) {
            lllllllllllllIlllIlllIIllIlIlIIl = lllllllllllllIlllIlllIIllIlIIllI;
        }
        if (lllllllllllllIlllIlllIIllIlIlIIl < -lllllllllllllIlllIlllIIllIlIIllI) {
            lllllllllllllIlllIlllIIllIlIlIIl = -lllllllllllllIlllIlllIIllIlIIllI;
        }
        return lllllllllllllIlllIlllIIllIlIllII + lllllllllllllIlllIlllIIllIlIlIIl;
    }
    
    public void setLookPositionWithEntity(final Entity lllllllllllllIlllIlllIIllllIIIII, final float lllllllllllllIlllIlllIIlllIllIll, final float lllllllllllllIlllIlllIIlllIllllI) {
        this.posX = lllllllllllllIlllIlllIIllllIIIII.posX;
        if (lllllllllllllIlllIlllIIllllIIIII instanceof EntityLivingBase) {
            this.posY = lllllllllllllIlllIlllIIllllIIIII.posY + lllllllllllllIlllIlllIIllllIIIII.getEyeHeight();
        }
        else {
            this.posY = (lllllllllllllIlllIlllIIllllIIIII.getEntityBoundingBox().minY + lllllllllllllIlllIlllIIllllIIIII.getEntityBoundingBox().maxY) / 2.0;
        }
        this.posZ = lllllllllllllIlllIlllIIllllIIIII.posZ;
        this.deltaLookYaw = lllllllllllllIlllIlllIIlllIllIll;
        this.deltaLookPitch = lllllllllllllIlllIlllIIlllIllllI;
        this.isLooking = true;
    }
    
    public double getLookPosX() {
        return this.posX;
    }
    
    public double getLookPosY() {
        return this.posY;
    }
    
    public EntityLookHelper(final EntityLiving lllllllllllllIlllIlllIIllllIlIII) {
        this.entity = lllllllllllllIlllIlllIIllllIlIII;
    }
}
