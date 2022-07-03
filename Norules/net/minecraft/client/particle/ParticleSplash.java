package net.minecraft.client.particle;

import net.minecraft.world.*;

public class ParticleSplash extends ParticleRain
{
    protected ParticleSplash(final World lllllllllllllIIllIIIlIllllllIlIl, final double lllllllllllllIIllIIIlIllllllIlII, final double lllllllllllllIIllIIIlIllllllIIll, final double lllllllllllllIIllIIIlIllllllIIlI, final double lllllllllllllIIllIIIlIllllllIIIl, final double lllllllllllllIIllIIIlIllllllIIII, final double lllllllllllllIIllIIIlIlllllIIlll) {
        super(lllllllllllllIIllIIIlIllllllIlIl, lllllllllllllIIllIIIlIllllllIlII, lllllllllllllIIllIIIlIllllllIIll, lllllllllllllIIllIIIlIllllllIIlI);
        this.particleGravity = 0.04f;
        this.nextTextureIndexX();
        if (lllllllllllllIIllIIIlIllllllIIII == 0.0 && (lllllllllllllIIllIIIlIllllllIIIl != 0.0 || lllllllllllllIIllIIIlIlllllIIlll != 0.0)) {
            this.motionX = lllllllllllllIIllIIIlIllllllIIIl;
            this.motionY = lllllllllllllIIllIIIlIllllllIIII + 0.1;
            this.motionZ = lllllllllllllIIllIIIlIlllllIIlll;
        }
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int lllllllllllllIlIlIIlIIIIlIIlIlII, final World lllllllllllllIlIlIIlIIIIlIIIlIll, final double lllllllllllllIlIlIIlIIIIlIIIlIlI, final double lllllllllllllIlIlIIlIIIIlIIIlIIl, final double lllllllllllllIlIlIIlIIIIlIIlIIII, final double lllllllllllllIlIlIIlIIIIlIIIIlll, final double lllllllllllllIlIlIIlIIIIlIIIlllI, final double lllllllllllllIlIlIIlIIIIlIIIIlIl, final int... lllllllllllllIlIlIIlIIIIlIIIllII) {
            return new ParticleSplash(lllllllllllllIlIlIIlIIIIlIIIlIll, lllllllllllllIlIlIIlIIIIlIIIlIlI, lllllllllllllIlIlIIlIIIIlIIIlIIl, lllllllllllllIlIlIIlIIIIlIIlIIII, lllllllllllllIlIlIIlIIIIlIIIIlll, lllllllllllllIlIlIIlIIIIlIIIlllI, lllllllllllllIlIlIIlIIIIlIIIIlIl);
        }
    }
}
