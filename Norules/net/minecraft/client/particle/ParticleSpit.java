package net.minecraft.client.particle;

import net.minecraft.world.*;

public class ParticleSpit extends ParticleExplosion
{
    @Override
    public void onUpdate() {
        super.onUpdate();
        this.motionY -= 0.004 + 0.04 * this.particleGravity;
    }
    
    protected ParticleSpit(final World lllllllllllllllIllIllIlIIlIIIIIl, final double lllllllllllllllIllIllIlIIlIIlIII, final double lllllllllllllllIllIllIlIIlIIIlll, final double lllllllllllllllIllIllIlIIIlllllI, final double lllllllllllllllIllIllIlIIlIIIlIl, final double lllllllllllllllIllIllIlIIlIIIlII, final double lllllllllllllllIllIllIlIIlIIIIll) {
        super(lllllllllllllllIllIllIlIIlIIIIIl, lllllllllllllllIllIllIlIIlIIlIII, lllllllllllllllIllIllIlIIlIIIlll, lllllllllllllllIllIllIlIIIlllllI, lllllllllllllllIllIllIlIIlIIIlIl, lllllllllllllllIllIllIlIIlIIIlII, lllllllllllllllIllIllIlIIlIIIIll);
        this.particleGravity = 0.5f;
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int lllllllllllllIIIIlIIlIIIlIIlIlll, final World lllllllllllllIIIIlIIlIIIlIIlIllI, final double lllllllllllllIIIIlIIlIIIlIIlIlIl, final double lllllllllllllIIIIlIIlIIIlIIlIlII, final double lllllllllllllIIIIlIIlIIIlIIIlIll, final double lllllllllllllIIIIlIIlIIIlIIlIIlI, final double lllllllllllllIIIIlIIlIIIlIIlIIIl, final double lllllllllllllIIIIlIIlIIIlIIIlIII, final int... lllllllllllllIIIIlIIlIIIlIIIllll) {
            return new ParticleSpit(lllllllllllllIIIIlIIlIIIlIIlIllI, lllllllllllllIIIIlIIlIIIlIIlIlIl, lllllllllllllIIIIlIIlIIIlIIlIlII, lllllllllllllIIIIlIIlIIIlIIIlIll, lllllllllllllIIIIlIIlIIIlIIlIIlI, lllllllllllllIIIIlIIlIIIlIIlIIIl, lllllllllllllIIIIlIIlIIIlIIIlIII);
        }
    }
}
