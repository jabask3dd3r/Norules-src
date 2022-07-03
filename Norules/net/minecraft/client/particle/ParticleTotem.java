package net.minecraft.client.particle;

import net.minecraft.world.*;

public class ParticleTotem extends ParticleSimpleAnimated
{
    public ParticleTotem(final World lllllllllllllIIllIIlIlllIIllIIll, final double lllllllllllllIIllIIlIlllIIlllIlI, final double lllllllllllllIIllIIlIlllIIllIIIl, final double lllllllllllllIIllIIlIlllIIlllIII, final double lllllllllllllIIllIIlIlllIIllIlll, final double lllllllllllllIIllIIlIlllIIllIllI, final double lllllllllllllIIllIIlIlllIIllIlIl) {
        super(lllllllllllllIIllIIlIlllIIllIIll, lllllllllllllIIllIIlIlllIIlllIlI, lllllllllllllIIllIIlIlllIIllIIIl, lllllllllllllIIllIIlIlllIIlllIII, 176, 8, -0.05f);
        this.motionX = lllllllllllllIIllIIlIlllIIllIlll;
        this.motionY = lllllllllllllIIllIIlIlllIIllIllI;
        this.motionZ = lllllllllllllIIllIIlIlllIIllIlIl;
        this.particleScale *= 0.75f;
        this.particleMaxAge = 60 + this.rand.nextInt(12);
        if (this.rand.nextInt(4) == 0) {
            this.setRBGColorF(0.6f + this.rand.nextFloat() * 0.2f, 0.6f + this.rand.nextFloat() * 0.3f, this.rand.nextFloat() * 0.2f);
        }
        else {
            this.setRBGColorF(0.1f + this.rand.nextFloat() * 0.2f, 0.4f + this.rand.nextFloat() * 0.3f, this.rand.nextFloat() * 0.2f);
        }
        this.func_191238_f(0.6f);
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int llllllllllllllllllIIlIIIIllIIlII, final World llllllllllllllllllIIlIIIIlIllIll, final double llllllllllllllllllIIlIIIIlIllIlI, final double llllllllllllllllllIIlIIIIlIllIIl, final double llllllllllllllllllIIlIIIIllIIIII, final double llllllllllllllllllIIlIIIIlIlllll, final double llllllllllllllllllIIlIIIIlIlIllI, final double llllllllllllllllllIIlIIIIlIlIlIl, final int... llllllllllllllllllIIlIIIIlIlllII) {
            return new ParticleTotem(llllllllllllllllllIIlIIIIlIllIll, llllllllllllllllllIIlIIIIlIllIlI, llllllllllllllllllIIlIIIIlIllIIl, llllllllllllllllllIIlIIIIllIIIII, llllllllllllllllllIIlIIIIlIlllll, llllllllllllllllllIIlIIIIlIlIllI, llllllllllllllllllIIlIIIIlIlIlIl);
        }
    }
}
