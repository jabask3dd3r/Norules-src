package net.minecraft.client.particle;

import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;

public class ParticleExplosionHuge extends Particle
{
    private /* synthetic */ int timeSinceStart;
    
    @Override
    public void onUpdate() {
        for (int lllllllllllllIlIIlIIIllIIIlIllIl = 0; lllllllllllllIlIIlIIIllIIIlIllIl < 6; ++lllllllllllllIlIIlIIIllIIIlIllIl) {
            final double lllllllllllllIlIIlIIIllIIIlIllII = this.posX + (this.rand.nextDouble() - this.rand.nextDouble()) * 4.0;
            final double lllllllllllllIlIIlIIIllIIIlIlIll = this.posY + (this.rand.nextDouble() - this.rand.nextDouble()) * 4.0;
            final double lllllllllllllIlIIlIIIllIIIlIlIlI = this.posZ + (this.rand.nextDouble() - this.rand.nextDouble()) * 4.0;
            this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, lllllllllllllIlIIlIIIllIIIlIllII, lllllllllllllIlIIlIIIllIIIlIlIll, lllllllllllllIlIIlIIIllIIIlIlIlI, this.timeSinceStart / 8.0f, 0.0, 0.0, new int[0]);
        }
        ++this.timeSinceStart;
        if (this.timeSinceStart == 8) {
            this.setExpired();
        }
    }
    
    @Override
    public int getFXLayer() {
        return 1;
    }
    
    protected ParticleExplosionHuge(final World lllllllllllllIlIIlIIIllIIlIlIlIl, final double lllllllllllllIlIIlIIIllIIlIlIlII, final double lllllllllllllIlIIlIIIllIIlIIIllI, final double lllllllllllllIlIIlIIIllIIlIIIlIl, final double lllllllllllllIlIIlIIIllIIlIlIIII, final double lllllllllllllIlIIlIIIllIIlIIlllI, final double lllllllllllllIlIIlIIIllIIlIIllII) {
        super(lllllllllllllIlIIlIIIllIIlIlIlIl, lllllllllllllIlIIlIIIllIIlIlIlII, lllllllllllllIlIIlIIIllIIlIIIllI, lllllllllllllIlIIlIIIllIIlIIIlIl, 0.0, 0.0, 0.0);
    }
    
    @Override
    public void renderParticle(final BufferBuilder lllllllllllllIlIIlIIIllIIlIIIIIl, final Entity lllllllllllllIlIIlIIIllIIIllllll, final float lllllllllllllIlIIlIIIllIIIllllIl, final float lllllllllllllIlIIlIIIllIIIllllII, final float lllllllllllllIlIIlIIIllIIIlllIll, final float lllllllllllllIlIIlIIIllIIIlllIIl, final float lllllllllllllIlIIlIIIllIIIllIlll, final float lllllllllllllIlIIlIIIllIIIllIllI) {
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int lIIlllIllllIIII, final World lIIlllIlllIIlll, final double lIIlllIlllIIllI, final double lIIlllIlllIIlIl, final double lIIlllIlllIIlII, final double lIIlllIlllIlIll, final double lIIlllIlllIIIlI, final double lIIlllIlllIIIIl, final int... lIIlllIlllIlIII) {
            return new ParticleExplosionHuge(lIIlllIlllIIlll, lIIlllIlllIIllI, lIIlllIlllIIlIl, lIIlllIlllIIlII, lIIlllIlllIlIll, lIIlllIlllIIIlI, lIIlllIlllIIIIl);
        }
    }
}
