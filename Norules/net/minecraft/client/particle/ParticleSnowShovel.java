package net.minecraft.client.particle;

import net.minecraft.world.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;

public class ParticleSnowShovel extends Particle
{
    /* synthetic */ float snowDigParticleScale;
    
    protected ParticleSnowShovel(final World llllllllllllllllIIIllIIIlIIIIllI, final double llllllllllllllllIIIllIIIIllllIll, final double llllllllllllllllIIIllIIIlIIIIlII, final double llllllllllllllllIIIllIIIIllllIIl, final double llllllllllllllllIIIllIIIIllllIII, final double llllllllllllllllIIIllIIIlIIIIIIl, final double llllllllllllllllIIIllIIIlIIIIIII, final float llllllllllllllllIIIllIIIIlllllll) {
        super(llllllllllllllllIIIllIIIlIIIIllI, llllllllllllllllIIIllIIIIllllIll, llllllllllllllllIIIllIIIlIIIIlII, llllllllllllllllIIIllIIIIllllIIl, llllllllllllllllIIIllIIIIllllIII, llllllllllllllllIIIllIIIlIIIIIIl, llllllllllllllllIIIllIIIlIIIIIII);
        this.motionX *= 0.10000000149011612;
        this.motionY *= 0.10000000149011612;
        this.motionZ *= 0.10000000149011612;
        this.motionX += llllllllllllllllIIIllIIIIllllIII;
        this.motionY += llllllllllllllllIIIllIIIlIIIIIIl;
        this.motionZ += llllllllllllllllIIIllIIIlIIIIIII;
        final float llllllllllllllllIIIllIIIIllllllI = 1.0f - (float)(Math.random() * 0.30000001192092896);
        this.particleRed = llllllllllllllllIIIllIIIIllllllI;
        this.particleGreen = llllllllllllllllIIIllIIIIllllllI;
        this.particleBlue = llllllllllllllllIIIllIIIIllllllI;
        this.particleScale *= 0.75f;
        this.particleScale *= llllllllllllllllIIIllIIIIlllllll;
        this.snowDigParticleScale = this.particleScale;
        this.particleMaxAge = (int)(8.0 / (Math.random() * 0.8 + 0.2));
        this.particleMaxAge *= (int)llllllllllllllllIIIllIIIIlllllll;
    }
    
    @Override
    public void renderParticle(final BufferBuilder llllllllllllllllIIIllIIIIllIlIII, final Entity llllllllllllllllIIIllIIIIllIIlll, final float llllllllllllllllIIIllIIIIllIIllI, final float llllllllllllllllIIIllIIIIllIIlIl, final float llllllllllllllllIIIllIIIIllIIlII, final float llllllllllllllllIIIllIIIIllIIIll, final float llllllllllllllllIIIllIIIIllIIIlI, final float llllllllllllllllIIIllIIIIllIIIIl) {
        float llllllllllllllllIIIllIIIIllIIIII = (this.particleAge + llllllllllllllllIIIllIIIIllIIllI) / this.particleMaxAge * 32.0f;
        llllllllllllllllIIIllIIIIllIIIII = MathHelper.clamp(llllllllllllllllIIIllIIIIllIIIII, 0.0f, 1.0f);
        this.particleScale = this.snowDigParticleScale * llllllllllllllllIIIllIIIIllIIIII;
        super.renderParticle(llllllllllllllllIIIllIIIIllIlIII, llllllllllllllllIIIllIIIIllIIlll, llllllllllllllllIIIllIIIIllIIllI, llllllllllllllllIIIllIIIIllIIlIl, llllllllllllllllIIIllIIIIllIIlII, llllllllllllllllIIIllIIIIllIIIll, llllllllllllllllIIIllIIIIllIIIlI, llllllllllllllllIIIllIIIIllIIIIl);
    }
    
    protected ParticleSnowShovel(final World llllllllllllllllIIIllIIIlIIllIII, final double llllllllllllllllIIIllIIIlIIlIlll, final double llllllllllllllllIIIllIIIlIIlIllI, final double llllllllllllllllIIIllIIIlIIlIlIl, final double llllllllllllllllIIIllIIIlIIlllII, final double llllllllllllllllIIIllIIIlIIlIIll, final double llllllllllllllllIIIllIIIlIIlIIlI) {
        this(llllllllllllllllIIIllIIIlIIllIII, llllllllllllllllIIIllIIIlIIlIlll, llllllllllllllllIIIllIIIlIIlIllI, llllllllllllllllIIIllIIIlIIlIlIl, llllllllllllllllIIIllIIIlIIlllII, llllllllllllllllIIIllIIIlIIlIIll, llllllllllllllllIIIllIIIlIIlIIlI, 1.0f);
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
        this.motionY -= 0.03;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.9900000095367432;
        this.motionY *= 0.9900000095367432;
        this.motionZ *= 0.9900000095367432;
        if (this.isCollided) {
            this.motionX *= 0.699999988079071;
            this.motionZ *= 0.699999988079071;
        }
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int lllllllllllllIlIIlllIIIllIlIIIII, final World lllllllllllllIlIIlllIIIllIIlllll, final double lllllllllllllIlIIlllIIIllIIllllI, final double lllllllllllllIlIIlllIIIllIIlIlIl, final double lllllllllllllIlIIlllIIIllIIlllII, final double lllllllllllllIlIIlllIIIllIIllIll, final double lllllllllllllIlIIlllIIIllIIllIlI, final double lllllllllllllIlIIlllIIIllIIlIIIl, final int... lllllllllllllIlIIlllIIIllIIllIII) {
            return new ParticleSnowShovel(lllllllllllllIlIIlllIIIllIIlllll, lllllllllllllIlIIlllIIIllIIllllI, lllllllllllllIlIIlllIIIllIIlIlIl, lllllllllllllIlIIlllIIIllIIlllII, lllllllllllllIlIIlllIIIllIIllIll, lllllllllllllIlIIlllIIIllIIllIlI, lllllllllllllIlIIlllIIIllIIlIIIl);
        }
    }
}
