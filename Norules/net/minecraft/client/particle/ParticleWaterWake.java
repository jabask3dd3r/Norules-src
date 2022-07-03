package net.minecraft.client.particle;

import net.minecraft.world.*;

public class ParticleWaterWake extends Particle
{
    protected ParticleWaterWake(final World lllllllllllllIIIlllIIllIIlIIIIIl, final double lllllllllllllIIIlllIIllIIlIIIIII, final double lllllllllllllIIIlllIIllIIIllllll, final double lllllllllllllIIIlllIIllIIIlllllI, final double lllllllllllllIIIlllIIllIIIllIlIl, final double lllllllllllllIIIlllIIllIIIllllII, final double lllllllllllllIIIlllIIllIIIllIIll) {
        super(lllllllllllllIIIlllIIllIIlIIIIIl, lllllllllllllIIIlllIIllIIlIIIIII, lllllllllllllIIIlllIIllIIIllllll, lllllllllllllIIIlllIIllIIIlllllI, 0.0, 0.0, 0.0);
        this.motionX *= 0.30000001192092896;
        this.motionY = Math.random() * 0.20000000298023224 + 0.10000000149011612;
        this.motionZ *= 0.30000001192092896;
        this.particleRed = 1.0f;
        this.particleGreen = 1.0f;
        this.particleBlue = 1.0f;
        this.setParticleTextureIndex(19);
        this.setSize(0.01f, 0.01f);
        this.particleMaxAge = (int)(8.0 / (Math.random() * 0.8 + 0.2));
        this.particleGravity = 0.0f;
        this.motionX = lllllllllllllIIIlllIIllIIIllIlIl;
        this.motionY = lllllllllllllIIIlllIIllIIIllllII;
        this.motionZ = lllllllllllllIIIlllIIllIIIllIIll;
    }
    
    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.motionY -= this.particleGravity;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.9800000190734863;
        this.motionY *= 0.9800000190734863;
        this.motionZ *= 0.9800000190734863;
        final int lllllllllllllIIIlllIIllIIIlIlllI = 60 - this.particleMaxAge;
        final float lllllllllllllIIIlllIIllIIIlIllIl = lllllllllllllIIIlllIIllIIIlIlllI * 0.001f;
        this.setSize(lllllllllllllIIIlllIIllIIIlIllIl, lllllllllllllIIIlllIIllIIIlIllIl);
        this.setParticleTextureIndex(19 + lllllllllllllIIIlllIIllIIIlIlllI % 4);
        if (this.particleMaxAge-- <= 0) {
            this.setExpired();
        }
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int llllllllllllllIlIIIIIIIllIIIlllI, final World llllllllllllllIlIIIIIIIllIIIIlIl, final double llllllllllllllIlIIIIIIIllIIIllII, final double llllllllllllllIlIIIIIIIllIIIlIll, final double llllllllllllllIlIIIIIIIllIIIIIlI, final double llllllllllllllIlIIIIIIIllIIIIIIl, final double llllllllllllllIlIIIIIIIllIIIIIII, final double llllllllllllllIlIIIIIIIlIlllllll, final int... llllllllllllllIlIIIIIIIllIIIIllI) {
            return new ParticleWaterWake(llllllllllllllIlIIIIIIIllIIIIlIl, llllllllllllllIlIIIIIIIllIIIllII, llllllllllllllIlIIIIIIIllIIIlIll, llllllllllllllIlIIIIIIIllIIIIIlI, llllllllllllllIlIIIIIIIllIIIIIIl, llllllllllllllIlIIIIIIIllIIIIIII, llllllllllllllIlIIIIIIIlIlllllll);
        }
    }
}
