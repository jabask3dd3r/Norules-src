package net.minecraft.client.particle;

import net.minecraft.world.*;

public class ParticleEndRod extends ParticleSimpleAnimated
{
    @Override
    public void moveEntity(final double llllllllllllllIlIlIIIIIlIllIlIll, final double llllllllllllllIlIlIIIIIlIllIlIlI, final double llllllllllllllIlIlIIIIIlIllIlIII) {
        this.setEntityBoundingBox(this.getEntityBoundingBox().offset(llllllllllllllIlIlIIIIIlIllIlIll, llllllllllllllIlIlIIIIIlIllIlIlI, llllllllllllllIlIlIIIIIlIllIlIII));
        this.resetPositionToBB();
    }
    
    public ParticleEndRod(final World llllllllllllllIlIlIIIIIlIlllllIl, final double llllllllllllllIlIlIIIIIllIIIlIIl, final double llllllllllllllIlIlIIIIIlIllllIIl, final double llllllllllllllIlIlIIIIIllIIIIllI, final double llllllllllllllIlIlIIIIIllIIIIlIl, final double llllllllllllllIlIlIIIIIlIlllIIll, final double llllllllllllllIlIlIIIIIlIlllIIIl) {
        super(llllllllllllllIlIlIIIIIlIlllllIl, llllllllllllllIlIlIIIIIllIIIlIIl, llllllllllllllIlIlIIIIIlIllllIIl, llllllllllllllIlIlIIIIIllIIIIllI, 176, 8, -5.0E-4f);
        this.motionX = llllllllllllllIlIlIIIIIllIIIIlIl;
        this.motionY = llllllllllllllIlIlIIIIIlIlllIIll;
        this.motionZ = llllllllllllllIlIlIIIIIlIlllIIIl;
        this.particleScale *= 0.75f;
        this.particleMaxAge = 60 + this.rand.nextInt(12);
        this.setColorFade(15916745);
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int lllllllllllllllIIlIlIIllIlIIIIlI, final World lllllllllllllllIIlIlIIllIIlllIIl, final double lllllllllllllllIIlIlIIllIlIIIIII, final double lllllllllllllllIIlIlIIllIIllIlll, final double lllllllllllllllIIlIlIIllIIllIllI, final double lllllllllllllllIIlIlIIllIIllllIl, final double lllllllllllllllIIlIlIIllIIllllII, final double lllllllllllllllIIlIlIIllIIlllIll, final int... lllllllllllllllIIlIlIIllIIlllIlI) {
            return new ParticleEndRod(lllllllllllllllIIlIlIIllIIlllIIl, lllllllllllllllIIlIlIIllIlIIIIII, lllllllllllllllIIlIlIIllIIllIlll, lllllllllllllllIIlIlIIllIIllIllI, lllllllllllllllIIlIlIIllIIllllIl, lllllllllllllllIIlIlIIllIIllllII, lllllllllllllllIIlIlIIllIIlllIll);
        }
    }
}
