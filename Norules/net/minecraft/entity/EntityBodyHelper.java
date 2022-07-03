package net.minecraft.entity;

import net.minecraft.util.math.*;

public class EntityBodyHelper
{
    private /* synthetic */ float prevRenderYawHead;
    private final /* synthetic */ EntityLivingBase theLiving;
    private /* synthetic */ int rotationTickCounter;
    
    public EntityBodyHelper(final EntityLivingBase lllllllllllllIIllIIllIlllIIlIIII) {
        this.theLiving = lllllllllllllIIllIIllIlllIIlIIII;
    }
    
    public void updateRenderAngles() {
        final double lllllllllllllIIllIIllIlllIIIIlll = this.theLiving.posX - this.theLiving.prevPosX;
        final double lllllllllllllIIllIIllIlllIIIIllI = this.theLiving.posZ - this.theLiving.prevPosZ;
        if (lllllllllllllIIllIIllIlllIIIIlll * lllllllllllllIIllIIllIlllIIIIlll + lllllllllllllIIllIIllIlllIIIIllI * lllllllllllllIIllIIllIlllIIIIllI > 2.500000277905201E-7) {
            this.theLiving.renderYawOffset = this.theLiving.rotationYaw;
            this.theLiving.rotationYawHead = this.computeAngleWithBound(this.theLiving.renderYawOffset, this.theLiving.rotationYawHead, 75.0f);
            this.prevRenderYawHead = this.theLiving.rotationYawHead;
            this.rotationTickCounter = 0;
        }
        else if (this.theLiving.getPassengers().isEmpty() || !(this.theLiving.getPassengers().get(0) instanceof EntityLiving)) {
            float lllllllllllllIIllIIllIlllIIIIlIl = 75.0f;
            if (Math.abs(this.theLiving.rotationYawHead - this.prevRenderYawHead) > 15.0f) {
                this.rotationTickCounter = 0;
                this.prevRenderYawHead = this.theLiving.rotationYawHead;
            }
            else {
                ++this.rotationTickCounter;
                final int lllllllllllllIIllIIllIlllIIIIlII = 10;
                if (this.rotationTickCounter > 10) {
                    lllllllllllllIIllIIllIlllIIIIlIl = Math.max(1.0f - (this.rotationTickCounter - 10) / 10.0f, 0.0f) * 75.0f;
                }
            }
            this.theLiving.renderYawOffset = this.computeAngleWithBound(this.theLiving.rotationYawHead, this.theLiving.renderYawOffset, lllllllllllllIIllIIllIlllIIIIlIl);
        }
    }
    
    private float computeAngleWithBound(final float lllllllllllllIIllIIllIllIllllIIl, final float lllllllllllllIIllIIllIllIlllIlII, final float lllllllllllllIIllIIllIllIlllIIll) {
        float lllllllllllllIIllIIllIllIlllIllI = MathHelper.wrapDegrees(lllllllllllllIIllIIllIllIllllIIl - lllllllllllllIIllIIllIllIlllIlII);
        if (lllllllllllllIIllIIllIllIlllIllI < -lllllllllllllIIllIIllIllIlllIIll) {
            lllllllllllllIIllIIllIllIlllIllI = -lllllllllllllIIllIIllIllIlllIIll;
        }
        if (lllllllllllllIIllIIllIllIlllIllI >= lllllllllllllIIllIIllIllIlllIIll) {
            lllllllllllllIIllIIllIllIlllIllI = lllllllllllllIIllIIllIllIlllIIll;
        }
        return lllllllllllllIIllIIllIllIllllIIl - lllllllllllllIIllIIllIllIlllIllI;
    }
}
