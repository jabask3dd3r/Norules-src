package net.minecraft.client.particle;

import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;

public class ParticleFlame extends Particle
{
    private final /* synthetic */ float flameScale;
    
    @Override
    public void moveEntity(final double lllllllllllllIIlllIIlIlllllIlIII, final double lllllllllllllIIlllIIlIlllllIlIll, final double lllllllllllllIIlllIIlIlllllIIllI) {
        this.setEntityBoundingBox(this.getEntityBoundingBox().offset(lllllllllllllIIlllIIlIlllllIlIII, lllllllllllllIIlllIIlIlllllIlIll, lllllllllllllIIlllIIlIlllllIIllI));
        this.resetPositionToBB();
    }
    
    protected ParticleFlame(final World lllllllllllllIIlllIIlIlllllllIII, final double lllllllllllllIIlllIIlIllllllllll, final double lllllllllllllIIlllIIlIlllllllllI, final double lllllllllllllIIlllIIlIllllllIlIl, final double lllllllllllllIIlllIIlIllllllllII, final double lllllllllllllIIlllIIlIllllllIIll, final double lllllllllllllIIlllIIlIlllllllIlI) {
        super(lllllllllllllIIlllIIlIlllllllIII, lllllllllllllIIlllIIlIllllllllll, lllllllllllllIIlllIIlIlllllllllI, lllllllllllllIIlllIIlIllllllIlIl, lllllllllllllIIlllIIlIllllllllII, lllllllllllllIIlllIIlIllllllIIll, lllllllllllllIIlllIIlIlllllllIlI);
        this.motionX = this.motionX * 0.009999999776482582 + lllllllllllllIIlllIIlIllllllllII;
        this.motionY = this.motionY * 0.009999999776482582 + lllllllllllllIIlllIIlIllllllIIll;
        this.motionZ = this.motionZ * 0.009999999776482582 + lllllllllllllIIlllIIlIlllllllIlI;
        this.posX += (this.rand.nextFloat() - this.rand.nextFloat()) * 0.05f;
        this.posY += (this.rand.nextFloat() - this.rand.nextFloat()) * 0.05f;
        this.posZ += (this.rand.nextFloat() - this.rand.nextFloat()) * 0.05f;
        this.flameScale = this.particleScale;
        this.particleRed = 1.0f;
        this.particleGreen = 1.0f;
        this.particleBlue = 1.0f;
        this.particleMaxAge = (int)(8.0 / (Math.random() * 0.8 + 0.2)) + 4;
        this.setParticleTextureIndex(48);
    }
    
    @Override
    public int getBrightnessForRender(final float lllllllllllllIIlllIIlIllllIIIIII) {
        float lllllllllllllIIlllIIlIlllIllllll = (this.particleAge + lllllllllllllIIlllIIlIllllIIIIII) / this.particleMaxAge;
        lllllllllllllIIlllIIlIlllIllllll = MathHelper.clamp(lllllllllllllIIlllIIlIlllIllllll, 0.0f, 1.0f);
        final int lllllllllllllIIlllIIlIlllIlllllI = super.getBrightnessForRender(lllllllllllllIIlllIIlIllllIIIIII);
        int lllllllllllllIIlllIIlIlllIllllIl = lllllllllllllIIlllIIlIlllIlllllI & 0xFF;
        final int lllllllllllllIIlllIIlIlllIllllII = lllllllllllllIIlllIIlIlllIlllllI >> 16 & 0xFF;
        lllllllllllllIIlllIIlIlllIllllIl += (int)(lllllllllllllIIlllIIlIlllIllllll * 15.0f * 16.0f);
        if (lllllllllllllIIlllIIlIlllIllllIl > 240) {
            lllllllllllllIIlllIIlIlllIllllIl = 240;
        }
        return lllllllllllllIIlllIIlIlllIllllIl | lllllllllllllIIlllIIlIlllIllllII << 16;
    }
    
    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.particleAge++ >= this.particleMaxAge) {
            this.setExpired();
        }
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.9599999785423279;
        this.motionY *= 0.9599999785423279;
        this.motionZ *= 0.9599999785423279;
        if (this.isCollided) {
            this.motionX *= 0.699999988079071;
            this.motionZ *= 0.699999988079071;
        }
    }
    
    @Override
    public void renderParticle(final BufferBuilder lllllllllllllIIlllIIlIllllIllIlI, final Entity lllllllllllllIIlllIIlIllllIllIIl, final float lllllllllllllIIlllIIlIllllIllIII, final float lllllllllllllIIlllIIlIllllIlIlll, final float lllllllllllllIIlllIIlIllllIIllII, final float lllllllllllllIIlllIIlIllllIlIlIl, final float lllllllllllllIIlllIIlIllllIlIlII, final float lllllllllllllIIlllIIlIllllIIlIIl) {
        final float lllllllllllllIIlllIIlIllllIlIIlI = (this.particleAge + lllllllllllllIIlllIIlIllllIllIII) / this.particleMaxAge;
        this.particleScale = this.flameScale * (1.0f - lllllllllllllIIlllIIlIllllIlIIlI * lllllllllllllIIlllIIlIllllIlIIlI * 0.5f);
        super.renderParticle(lllllllllllllIIlllIIlIllllIllIlI, lllllllllllllIIlllIIlIllllIllIIl, lllllllllllllIIlllIIlIllllIllIII, lllllllllllllIIlllIIlIllllIlIlll, lllllllllllllIIlllIIlIllllIIllII, lllllllllllllIIlllIIlIllllIlIlIl, lllllllllllllIIlllIIlIllllIlIlII, lllllllllllllIIlllIIlIllllIIlIIl);
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int lllllllllllllIlIIIlIIllIlIIIIlII, final World lllllllllllllIlIIIlIIllIIllllIll, final double lllllllllllllIlIIIlIIllIIllllIlI, final double lllllllllllllIlIIIlIIllIIllllIIl, final double lllllllllllllIlIIIlIIllIIllllIII, final double lllllllllllllIlIIIlIIllIIlllllll, final double lllllllllllllIlIIIlIIllIIlllIllI, final double lllllllllllllIlIIIlIIllIIlllIlIl, final int... lllllllllllllIlIIIlIIllIIlllllII) {
            return new ParticleFlame(lllllllllllllIlIIIlIIllIIllllIll, lllllllllllllIlIIIlIIllIIllllIlI, lllllllllllllIlIIIlIIllIIllllIIl, lllllllllllllIlIIIlIIllIIllllIII, lllllllllllllIlIIIlIIllIIlllllll, lllllllllllllIlIIIlIIllIIlllIllI, lllllllllllllIlIIIlIIllIIlllIlIl);
        }
    }
}
