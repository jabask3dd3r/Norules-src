package net.minecraft.client.particle;

import net.minecraft.world.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;

public class ParticleSmokeNormal extends Particle
{
    /* synthetic */ float smokeParticleScale;
    
    private ParticleSmokeNormal(final World lllllllllllllIllllllIIIlIllIllll, final double lllllllllllllIllllllIIIlIllIlllI, final double lllllllllllllIllllllIIIlIllIllIl, final double lllllllllllllIllllllIIIlIllIIlII, final double lllllllllllllIllllllIIIlIllIlIll, final double lllllllllllllIllllllIIIlIllIlIlI, final double lllllllllllllIllllllIIIlIllIIIIl) {
        this(lllllllllllllIllllllIIIlIllIllll, lllllllllllllIllllllIIIlIllIlllI, lllllllllllllIllllllIIIlIllIllIl, lllllllllllllIllllllIIIlIllIIlII, lllllllllllllIllllllIIIlIllIlIll, lllllllllllllIllllllIIIlIllIlIlI, lllllllllllllIllllllIIIlIllIIIIl, 1.0f);
    }
    
    @Override
    public void renderParticle(final BufferBuilder lllllllllllllIllllllIIIlIIlIllIl, final Entity lllllllllllllIllllllIIIlIIlIllII, final float lllllllllllllIllllllIIIlIIllIlIl, final float lllllllllllllIllllllIIIlIIlIlIlI, final float lllllllllllllIllllllIIIlIIllIIll, final float lllllllllllllIllllllIIIlIIlIlIII, final float lllllllllllllIllllllIIIlIIlIIlll, final float lllllllllllllIllllllIIIlIIllIIII) {
        float lllllllllllllIllllllIIIlIIlIllll = (this.particleAge + lllllllllllllIllllllIIIlIIllIlIl) / this.particleMaxAge * 32.0f;
        lllllllllllllIllllllIIIlIIlIllll = MathHelper.clamp(lllllllllllllIllllllIIIlIIlIllll, 0.0f, 1.0f);
        this.particleScale = this.smokeParticleScale * lllllllllllllIllllllIIIlIIlIllll;
        super.renderParticle(lllllllllllllIllllllIIIlIIlIllIl, lllllllllllllIllllllIIIlIIlIllII, lllllllllllllIllllllIIIlIIllIlIl, lllllllllllllIllllllIIIlIIlIlIlI, lllllllllllllIllllllIIIlIIllIIll, lllllllllllllIllllllIIIlIIlIlIII, lllllllllllllIllllllIIIlIIlIIlll, lllllllllllllIllllllIIIlIIllIIII);
    }
    
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
    
    protected ParticleSmokeNormal(final World lllllllllllllIllllllIIIlIlIIlIll, final double lllllllllllllIllllllIIIlIlIIlIlI, final double lllllllllllllIllllllIIIlIlIIlIIl, final double lllllllllllllIllllllIIIlIlIlIIlI, final double lllllllllllllIllllllIIIlIlIIIlll, final double lllllllllllllIllllllIIIlIlIlIIII, final double lllllllllllllIllllllIIIlIlIIllll, final float lllllllllllllIllllllIIIlIlIIlllI) {
        super(lllllllllllllIllllllIIIlIlIIlIll, lllllllllllllIllllllIIIlIlIIlIlI, lllllllllllllIllllllIIIlIlIIlIIl, lllllllllllllIllllllIIIlIlIlIIlI, 0.0, 0.0, 0.0);
        this.motionX *= 0.10000000149011612;
        this.motionY *= 0.10000000149011612;
        this.motionZ *= 0.10000000149011612;
        this.motionX += lllllllllllllIllllllIIIlIlIIIlll;
        this.motionY += lllllllllllllIllllllIIIlIlIlIIII;
        this.motionZ += lllllllllllllIllllllIIIlIlIIllll;
        final float lllllllllllllIllllllIIIlIlIIllIl = (float)(Math.random() * 0.30000001192092896);
        this.particleRed = lllllllllllllIllllllIIIlIlIIllIl;
        this.particleGreen = lllllllllllllIllllllIIIlIlIIllIl;
        this.particleBlue = lllllllllllllIllllllIIIlIlIIllIl;
        this.particleScale *= 0.75f;
        this.particleScale *= lllllllllllllIllllllIIIlIlIIlllI;
        this.smokeParticleScale = this.particleScale;
        this.particleMaxAge = (int)(8.0 / (Math.random() * 0.8 + 0.2));
        this.particleMaxAge *= (int)lllllllllllllIllllllIIIlIlIIlllI;
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int lllllllllllllIlIIIIllIlIllllIlll, final World lllllllllllllIlIIIIllIlIlllIlllI, final double lllllllllllllIlIIIIllIlIlllIllIl, final double lllllllllllllIlIIIIllIlIllllIlII, final double lllllllllllllIlIIIIllIlIllllIIll, final double lllllllllllllIlIIIIllIlIllllIIlI, final double lllllllllllllIlIIIIllIlIlllIlIIl, final double lllllllllllllIlIIIIllIlIllllIIII, final int... lllllllllllllIlIIIIllIlIlllIllll) {
            return new ParticleSmokeNormal(lllllllllllllIlIIIIllIlIlllIlllI, lllllllllllllIlIIIIllIlIlllIllIl, lllllllllllllIlIIIIllIlIllllIlII, lllllllllllllIlIIIIllIlIllllIIll, lllllllllllllIlIIIIllIlIllllIIlI, lllllllllllllIlIIIIllIlIlllIlIIl, lllllllllllllIlIIIIllIlIllllIIII, null);
        }
    }
}
