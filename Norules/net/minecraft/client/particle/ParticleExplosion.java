package net.minecraft.client.particle;

import net.minecraft.world.*;

public class ParticleExplosion extends Particle
{
    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.particleAge++ >= this.particleMaxAge) {
            this.setExpired();
        }
        this.setParticleTextureIndex(7 - this.particleAge * 8 / this.particleMaxAge);
        this.motionY += 0.004;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.8999999761581421;
        this.motionY *= 0.8999999761581421;
        this.motionZ *= 0.8999999761581421;
        if (this.isCollided) {
            this.motionX *= 0.699999988079071;
            this.motionZ *= 0.699999988079071;
        }
    }
    
    protected ParticleExplosion(final World lllllllllllllIlIIllIIIIlIllIIIlI, final double lllllllllllllIlIIllIIIIlIllIIIIl, final double lllllllllllllIlIIllIIIIlIllIIIII, final double lllllllllllllIlIIllIIIIlIllIlIII, final double lllllllllllllIlIIllIIIIlIllIIlll, final double lllllllllllllIlIIllIIIIlIlIlllIl, final double lllllllllllllIlIIllIIIIlIllIIlIl) {
        super(lllllllllllllIlIIllIIIIlIllIIIlI, lllllllllllllIlIIllIIIIlIllIIIIl, lllllllllllllIlIIllIIIIlIllIIIII, lllllllllllllIlIIllIIIIlIllIlIII, lllllllllllllIlIIllIIIIlIllIIlll, lllllllllllllIlIIllIIIIlIlIlllIl, lllllllllllllIlIIllIIIIlIllIIlIl);
        this.motionX = lllllllllllllIlIIllIIIIlIllIIlll + (Math.random() * 2.0 - 1.0) * 0.05000000074505806;
        this.motionY = lllllllllllllIlIIllIIIIlIlIlllIl + (Math.random() * 2.0 - 1.0) * 0.05000000074505806;
        this.motionZ = lllllllllllllIlIIllIIIIlIllIIlIl + (Math.random() * 2.0 - 1.0) * 0.05000000074505806;
        final float lllllllllllllIlIIllIIIIlIllIIlII = this.rand.nextFloat() * 0.3f + 0.7f;
        this.particleRed = lllllllllllllIlIIllIIIIlIllIIlII;
        this.particleGreen = lllllllllllllIlIIllIIIIlIllIIlII;
        this.particleBlue = lllllllllllllIlIIllIIIIlIllIIlII;
        this.particleScale = this.rand.nextFloat() * this.rand.nextFloat() * 6.0f + 1.0f;
        this.particleMaxAge = (int)(16.0 / (this.rand.nextFloat() * 0.8 + 0.2)) + 2;
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int llllllllllllllIIlIIlIIlIIlllIIlI, final World llllllllllllllIIlIIlIIlIIlllIIIl, final double llllllllllllllIIlIIlIIlIIllIlIII, final double llllllllllllllIIlIIlIIlIIllIIlll, final double llllllllllllllIIlIIlIIlIIllIIllI, final double llllllllllllllIIlIIlIIlIIllIllIl, final double llllllllllllllIIlIIlIIlIIllIllII, final double llllllllllllllIIlIIlIIlIIllIlIll, final int... llllllllllllllIIlIIlIIlIIllIlIlI) {
            return new ParticleExplosion(llllllllllllllIIlIIlIIlIIlllIIIl, llllllllllllllIIlIIlIIlIIllIlIII, llllllllllllllIIlIIlIIlIIllIIlll, llllllllllllllIIlIIlIIlIIllIIllI, llllllllllllllIIlIIlIIlIIllIllIl, llllllllllllllIIlIIlIIlIIllIllII, llllllllllllllIIlIIlIIlIIllIlIll);
        }
    }
}
