package net.minecraft.client.particle;

import net.minecraft.world.*;

public class ParticleSimpleAnimated extends Particle
{
    private final /* synthetic */ int numAgingFrames;
    private /* synthetic */ boolean fadingColor;
    private final /* synthetic */ float yAccel;
    private /* synthetic */ float fadeTargetBlue;
    private /* synthetic */ float fadeTargetGreen;
    private /* synthetic */ float fadeTargetRed;
    private /* synthetic */ float field_191239_M;
    private final /* synthetic */ int textureIdx;
    
    public ParticleSimpleAnimated(final World lllllllllllllIIllIIIIIlIIIllIllI, final double lllllllllllllIIllIIIIIlIIIllIlIl, final double lllllllllllllIIllIIIIIlIIIlIllII, final double lllllllllllllIIllIIIIIlIIIlIlIll, final int lllllllllllllIIllIIIIIlIIIlIlIlI, final int lllllllllllllIIllIIIIIlIIIlIlIIl, final float lllllllllllllIIllIIIIIlIIIllIIII) {
        super(lllllllllllllIIllIIIIIlIIIllIllI, lllllllllllllIIllIIIIIlIIIllIlIl, lllllllllllllIIllIIIIIlIIIlIllII, lllllllllllllIIllIIIIIlIIIlIlIll);
        this.field_191239_M = 0.91f;
        this.textureIdx = lllllllllllllIIllIIIIIlIIIlIlIlI;
        this.numAgingFrames = lllllllllllllIIllIIIIIlIIIlIlIIl;
        this.yAccel = lllllllllllllIIllIIIIIlIIIllIIII;
    }
    
    public void setColorFade(final int lllllllllllllIIllIIIIIlIIIIlIIlI) {
        this.fadeTargetRed = ((lllllllllllllIIllIIIIIlIIIIlIIlI & 0xFF0000) >> 16) / 255.0f;
        this.fadeTargetGreen = ((lllllllllllllIIllIIIIIlIIIIlIIlI & 0xFF00) >> 8) / 255.0f;
        this.fadeTargetBlue = ((lllllllllllllIIllIIIIIlIIIIlIIlI & 0xFF) >> 0) / 255.0f;
        this.fadingColor = true;
    }
    
    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.particleAge++ >= this.particleMaxAge) {
            this.setExpired();
        }
        if (this.particleAge > this.particleMaxAge / 2) {
            this.setAlphaF(1.0f - (this.particleAge - (float)(this.particleMaxAge / 2)) / this.particleMaxAge);
            if (this.fadingColor) {
                this.particleRed += (this.fadeTargetRed - this.particleRed) * 0.2f;
                this.particleGreen += (this.fadeTargetGreen - this.particleGreen) * 0.2f;
                this.particleBlue += (this.fadeTargetBlue - this.particleBlue) * 0.2f;
            }
        }
        this.setParticleTextureIndex(this.textureIdx + (this.numAgingFrames - 1 - this.particleAge * this.numAgingFrames / this.particleMaxAge));
        this.motionY += this.yAccel;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= this.field_191239_M;
        this.motionY *= this.field_191239_M;
        this.motionZ *= this.field_191239_M;
        if (this.isCollided) {
            this.motionX *= 0.699999988079071;
            this.motionZ *= 0.699999988079071;
        }
    }
    
    @Override
    public int getBrightnessForRender(final float lllllllllllllIIllIIIIIlIIIIIlIlI) {
        return 15728880;
    }
    
    protected void func_191238_f(final float lllllllllllllIIllIIIIIlIIIIIIlII) {
        this.field_191239_M = lllllllllllllIIllIIIIIlIIIIIIlII;
    }
    
    @Override
    public boolean isTransparent() {
        return true;
    }
    
    public void setColor(final int lllllllllllllIIllIIIIIlIIIlIIIII) {
        final float lllllllllllllIIllIIIIIlIIIIlllll = ((lllllllllllllIIllIIIIIlIIIlIIIII & 0xFF0000) >> 16) / 255.0f;
        final float lllllllllllllIIllIIIIIlIIIIllllI = ((lllllllllllllIIllIIIIIlIIIlIIIII & 0xFF00) >> 8) / 255.0f;
        final float lllllllllllllIIllIIIIIlIIIIlllIl = ((lllllllllllllIIllIIIIIlIIIlIIIII & 0xFF) >> 0) / 255.0f;
        final float lllllllllllllIIllIIIIIlIIIIlllII = 1.0f;
        this.setRBGColorF(lllllllllllllIIllIIIIIlIIIIlllll * 1.0f, lllllllllllllIIllIIIIIlIIIIllllI * 1.0f, lllllllllllllIIllIIIIIlIIIIlllIl * 1.0f);
    }
}
