package net.minecraft.client.particle;

import net.minecraft.world.*;

public class ParticleSuspendedTown extends Particle
{
    @Override
    public void moveEntity(final double llllllllllllllllllIIIlIIIIlIlIlI, final double llllllllllllllllllIIIlIIIIlIIIlI, final double llllllllllllllllllIIIlIIIIlIIllI) {
        this.setEntityBoundingBox(this.getEntityBoundingBox().offset(llllllllllllllllllIIIlIIIIlIlIlI, llllllllllllllllllIIIlIIIIlIIIlI, llllllllllllllllllIIIlIIIIlIIllI));
        this.resetPositionToBB();
    }
    
    protected ParticleSuspendedTown(final World llllllllllllllllllIIIlIIIlIlIlIl, final double llllllllllllllllllIIIlIIIlIlIlII, final double llllllllllllllllllIIIlIIIlIlIIll, final double llllllllllllllllllIIIlIIIlIlIIlI, final double llllllllllllllllllIIIlIIIlIIIIII, final double llllllllllllllllllIIIlIIIIlllllI, final double llllllllllllllllllIIIlIIIlIIlllI) {
        super(llllllllllllllllllIIIlIIIlIlIlIl, llllllllllllllllllIIIlIIIlIlIlII, llllllllllllllllllIIIlIIIlIlIIll, llllllllllllllllllIIIlIIIlIlIIlI, llllllllllllllllllIIIlIIIlIIIIII, llllllllllllllllllIIIlIIIIlllllI, llllllllllllllllllIIIlIIIlIIlllI);
        final float llllllllllllllllllIIIlIIIlIIllII = this.rand.nextFloat() * 0.1f + 0.2f;
        this.particleRed = llllllllllllllllllIIIlIIIlIIllII;
        this.particleGreen = llllllllllllllllllIIIlIIIlIIllII;
        this.particleBlue = llllllllllllllllllIIIlIIIlIIllII;
        this.setParticleTextureIndex(0);
        this.setSize(0.02f, 0.02f);
        this.particleScale *= this.rand.nextFloat() * 0.6f + 0.5f;
        this.motionX *= 0.019999999552965164;
        this.motionY *= 0.019999999552965164;
        this.motionZ *= 0.019999999552965164;
        this.particleMaxAge = (int)(20.0 / (Math.random() * 0.8 + 0.2));
    }
    
    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.99;
        this.motionY *= 0.99;
        this.motionZ *= 0.99;
        if (this.particleMaxAge-- <= 0) {
            this.setExpired();
        }
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int lllllllllllllIlllIlIIllIIIlIlllI, final World lllllllllllllIlllIlIIllIIIlIIlIl, final double lllllllllllllIlllIlIIllIIIlIIlII, final double lllllllllllllIlllIlIIllIIIlIlIll, final double lllllllllllllIlllIlIIllIIIlIIIlI, final double lllllllllllllIlllIlIIllIIIlIlIIl, final double lllllllllllllIlllIlIIllIIIlIlIII, final double lllllllllllllIlllIlIIllIIIIlllll, final int... lllllllllllllIlllIlIIllIIIlIIllI) {
            return new ParticleSuspendedTown(lllllllllllllIlllIlIIllIIIlIIlIl, lllllllllllllIlllIlIIllIIIlIIlII, lllllllllllllIlllIlIIllIIIlIlIll, lllllllllllllIlllIlIIllIIIlIIIlI, lllllllllllllIlllIlIIllIIIlIlIIl, lllllllllllllIlllIlIIllIIIlIlIII, lllllllllllllIlllIlIIllIIIIlllll);
        }
    }
    
    public static class HappyVillagerFactory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int llllllllllllllIlllIIIIIlIlIIllII, final World llllllllllllllIlllIIIIIlIlIIIIIl, final double llllllllllllllIlllIIIIIlIlIIlIlI, final double llllllllllllllIlllIIIIIlIIllllll, final double llllllllllllllIlllIIIIIlIIlllllI, final double llllllllllllllIlllIIIIIlIIllllIl, final double llllllllllllllIlllIIIIIlIlIIIllI, final double llllllllllllllIlllIIIIIlIIlllIll, final int... llllllllllllllIlllIIIIIlIlIIIlII) {
            final Particle llllllllllllllIlllIIIIIlIlIIIIll = new ParticleSuspendedTown(llllllllllllllIlllIIIIIlIlIIIIIl, llllllllllllllIlllIIIIIlIlIIlIlI, llllllllllllllIlllIIIIIlIIllllll, llllllllllllllIlllIIIIIlIIlllllI, llllllllllllllIlllIIIIIlIIllllIl, llllllllllllllIlllIIIIIlIlIIIllI, llllllllllllllIlllIIIIIlIIlllIll);
            llllllllllllllIlllIIIIIlIlIIIIll.setParticleTextureIndex(82);
            llllllllllllllIlllIIIIIlIlIIIIll.setRBGColorF(1.0f, 1.0f, 1.0f);
            return llllllllllllllIlllIIIIIlIlIIIIll;
        }
    }
}
