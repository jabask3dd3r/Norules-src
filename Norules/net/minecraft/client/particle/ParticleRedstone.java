package net.minecraft.client.particle;

import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

public class ParticleRedstone extends Particle
{
    /* synthetic */ float reddustParticleScale;
    
    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.particleAge++ >= this.particleMaxAge) {
            this.setExpired();
        }
        this.setParticleTextureIndex(7 - this.particleAge * 8 / this.particleMaxAge);
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        if (this.posY == this.prevPosY) {
            this.motionX *= 1.1;
            this.motionZ *= 1.1;
        }
        this.motionX *= 0.9599999785423279;
        this.motionY *= 0.9599999785423279;
        this.motionZ *= 0.9599999785423279;
        if (this.isCollided) {
            this.motionX *= 0.699999988079071;
            this.motionZ *= 0.699999988079071;
        }
    }
    
    @Override
    public void renderParticle(final BufferBuilder lllllllllllllllIIlIlIllllIlIIIIl, final Entity lllllllllllllllIIlIlIllllIlIIIII, final float lllllllllllllllIIlIlIllllIIlllll, final float lllllllllllllllIIlIlIllllIIllllI, final float lllllllllllllllIIlIlIllllIIlIIll, final float lllllllllllllllIIlIlIllllIIlIIlI, final float lllllllllllllllIIlIlIllllIIlIIIl, final float lllllllllllllllIIlIlIllllIIllIlI) {
        float lllllllllllllllIIlIlIllllIIllIIl = (this.particleAge + lllllllllllllllIIlIlIllllIIlllll) / this.particleMaxAge * 32.0f;
        lllllllllllllllIIlIlIllllIIllIIl = MathHelper.clamp(lllllllllllllllIIlIlIllllIIllIIl, 0.0f, 1.0f);
        this.particleScale = this.reddustParticleScale * lllllllllllllllIIlIlIllllIIllIIl;
        super.renderParticle(lllllllllllllllIIlIlIllllIlIIIIl, lllllllllllllllIIlIlIllllIlIIIII, lllllllllllllllIIlIlIllllIIlllll, lllllllllllllllIIlIlIllllIIllllI, lllllllllllllllIIlIlIllllIIlIIll, lllllllllllllllIIlIlIllllIIlIIlI, lllllllllllllllIIlIlIllllIIlIIIl, lllllllllllllllIIlIlIllllIIllIlI);
    }
    
    protected ParticleRedstone(final World lllllllllllllllIIlIlIllllIllllll, final double lllllllllllllllIIlIlIllllIllIlII, final double lllllllllllllllIIlIlIllllIllIIll, final double lllllllllllllllIIlIlIllllIllIIlI, final float lllllllllllllllIIlIlIllllIllIIIl, float lllllllllllllllIIlIlIllllIllIIII, final float lllllllllllllllIIlIlIllllIlIllll, final float lllllllllllllllIIlIlIllllIlllIII) {
        super(lllllllllllllllIIlIlIllllIllllll, lllllllllllllllIIlIlIllllIllIlII, lllllllllllllllIIlIlIllllIllIIll, lllllllllllllllIIlIlIllllIllIIlI, 0.0, 0.0, 0.0);
        this.motionX *= 0.10000000149011612;
        this.motionY *= 0.10000000149011612;
        this.motionZ *= 0.10000000149011612;
        if (lllllllllllllllIIlIlIllllIllIIII == 0.0f) {
            lllllllllllllllIIlIlIllllIllIIII = 1.0f;
        }
        final float lllllllllllllllIIlIlIllllIllIlll = (float)Math.random() * 0.4f + 0.6f;
        this.particleRed = ((float)(Math.random() * 0.20000000298023224) + 0.8f) * lllllllllllllllIIlIlIllllIllIIII * lllllllllllllllIIlIlIllllIllIlll;
        this.particleGreen = ((float)(Math.random() * 0.20000000298023224) + 0.8f) * lllllllllllllllIIlIlIllllIlIllll * lllllllllllllllIIlIlIllllIllIlll;
        this.particleBlue = ((float)(Math.random() * 0.20000000298023224) + 0.8f) * lllllllllllllllIIlIlIllllIlllIII * lllllllllllllllIIlIlIllllIllIlll;
        this.particleScale *= 0.75f;
        this.particleScale *= lllllllllllllllIIlIlIllllIllIIIl;
        this.reddustParticleScale = this.particleScale;
        this.particleMaxAge = (int)(8.0 / (Math.random() * 0.8 + 0.2));
        this.particleMaxAge *= (int)lllllllllllllllIIlIlIllllIllIIIl;
    }
    
    protected ParticleRedstone(final World lllllllllllllllIIlIlIlllllIlIIIl, final double lllllllllllllllIIlIlIlllllIlIIII, final double lllllllllllllllIIlIlIlllllIlIlll, final double lllllllllllllllIIlIlIlllllIlIllI, final float lllllllllllllllIIlIlIlllllIIllIl, final float lllllllllllllllIIlIlIlllllIIllII, final float lllllllllllllllIIlIlIlllllIIlIll) {
        this(lllllllllllllllIIlIlIlllllIlIIIl, lllllllllllllllIIlIlIlllllIlIIII, lllllllllllllllIIlIlIlllllIlIlll, lllllllllllllllIIlIlIlllllIlIllI, 1.0f, lllllllllllllllIIlIlIlllllIIllIl, lllllllllllllllIIlIlIlllllIIllII, lllllllllllllllIIlIlIlllllIIlIll);
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int lllllllllllllllIIIlIlIllllllllII, final World lllllllllllllllIIIlIlIllllllIIll, final double lllllllllllllllIIIlIlIllllllIIlI, final double lllllllllllllllIIIlIlIllllllIIIl, final double lllllllllllllllIIIlIlIllllllIIII, final double lllllllllllllllIIIlIlIlllllIllll, final double lllllllllllllllIIIlIlIllllllIllI, final double lllllllllllllllIIIlIlIlllllIllIl, final int... lllllllllllllllIIIlIlIllllllIlII) {
            return new ParticleRedstone(lllllllllllllllIIIlIlIllllllIIll, lllllllllllllllIIIlIlIllllllIIlI, lllllllllllllllIIIlIlIllllllIIIl, lllllllllllllllIIIlIlIllllllIIII, (float)lllllllllllllllIIIlIlIlllllIllll, (float)lllllllllllllllIIIlIlIllllllIllI, (float)lllllllllllllllIIIlIlIlllllIllIl);
        }
    }
}
