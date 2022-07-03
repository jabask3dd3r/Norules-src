package net.minecraft.client.particle;

import net.minecraft.world.*;

public class ParticleSmokeLarge extends ParticleSmokeNormal
{
    protected ParticleSmokeLarge(final World lllllllllllllIIIlIIlIIIIlIIlllIl, final double lllllllllllllIIIlIIlIIIIlIlIIlII, final double lllllllllllllIIIlIIlIIIIlIIllIll, final double lllllllllllllIIIlIIlIIIIlIlIIIlI, final double lllllllllllllIIIlIIlIIIIlIlIIIIl, final double lllllllllllllIIIlIIlIIIIlIIllIII, final double lllllllllllllIIIlIIlIIIIlIIlllll) {
        super(lllllllllllllIIIlIIlIIIIlIIlllIl, lllllllllllllIIIlIIlIIIIlIlIIlII, lllllllllllllIIIlIIlIIIIlIIllIll, lllllllllllllIIIlIIlIIIIlIlIIIlI, lllllllllllllIIIlIIlIIIIlIlIIIIl, lllllllllllllIIIlIIlIIIIlIIllIII, lllllllllllllIIIlIIlIIIIlIIlllll, 2.5f);
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int llllllllllllllIlIlIlllllllIIIlIl, final World llllllllllllllIlIlIlllllllIIIlII, final double llllllllllllllIlIlIllllllIlllIIl, final double llllllllllllllIlIlIlllllllIIIIlI, final double llllllllllllllIlIlIllllllIllIllI, final double llllllllllllllIlIlIllllllIllIlIl, final double llllllllllllllIlIlIllllllIllIlII, final double llllllllllllllIlIlIllllllIllIIll, final int... llllllllllllllIlIlIllllllIllllIl) {
            return new ParticleSmokeLarge(llllllllllllllIlIlIlllllllIIIlII, llllllllllllllIlIlIllllllIlllIIl, llllllllllllllIlIlIlllllllIIIIlI, llllllllllllllIlIlIllllllIllIllI, llllllllllllllIlIlIllllllIllIlIl, llllllllllllllIlIlIllllllIllIlII, llllllllllllllIlIlIllllllIllIIll);
        }
    }
}
