package net.minecraft.client.particle;

import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

public class ParticleHeart extends Particle
{
    /* synthetic */ float particleScaleOverTime;
    
    @Override
    public void renderParticle(final BufferBuilder llllllllllllIllllllllIIIIIIIIlII, final Entity llllllllllllIllllllllIIIIIIIIIll, final float llllllllllllIllllllllIIIIIIIllII, final float llllllllllllIllllllllIIIIIIIlIll, final float llllllllllllIllllllllIIIIIIIlIlI, final float llllllllllllIllllllllIIIIIIIlIIl, final float llllllllllllIlllllllIllllllllllI, final float llllllllllllIllllllllIIIIIIIIlll) {
        float llllllllllllIllllllllIIIIIIIIllI = (this.particleAge + llllllllllllIllllllllIIIIIIIllII) / this.particleMaxAge * 32.0f;
        llllllllllllIllllllllIIIIIIIIllI = MathHelper.clamp(llllllllllllIllllllllIIIIIIIIllI, 0.0f, 1.0f);
        this.particleScale = this.particleScaleOverTime * llllllllllllIllllllllIIIIIIIIllI;
        super.renderParticle(llllllllllllIllllllllIIIIIIIIlII, llllllllllllIllllllllIIIIIIIIIll, llllllllllllIllllllllIIIIIIIllII, llllllllllllIllllllllIIIIIIIlIll, llllllllllllIllllllllIIIIIIIlIlI, llllllllllllIllllllllIIIIIIIlIIl, llllllllllllIlllllllIllllllllllI, llllllllllllIllllllllIIIIIIIIlll);
    }
    
    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.particleAge++ >= this.particleMaxAge) {
            this.setExpired();
        }
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        if (this.posY == this.prevPosY) {
            this.motionX *= 1.1;
            this.motionZ *= 1.1;
        }
        this.motionX *= 0.8600000143051147;
        this.motionY *= 0.8600000143051147;
        this.motionZ *= 0.8600000143051147;
        if (this.isCollided) {
            this.motionX *= 0.699999988079071;
            this.motionZ *= 0.699999988079071;
        }
    }
    
    protected ParticleHeart(final World llllllllllllIllllllllIIIIIlIIlll, final double llllllllllllIllllllllIIIIIlIIllI, final double llllllllllllIllllllllIIIIIIlllII, final double llllllllllllIllllllllIIIIIIllIll, final double llllllllllllIllllllllIIIIIlIIIll, final double llllllllllllIllllllllIIIIIlIIIlI, final double llllllllllllIllllllllIIIIIlIIIIl, final float llllllllllllIllllllllIIIIIlIIIII) {
        super(llllllllllllIllllllllIIIIIlIIlll, llllllllllllIllllllllIIIIIlIIllI, llllllllllllIllllllllIIIIIIlllII, llllllllllllIllllllllIIIIIIllIll, 0.0, 0.0, 0.0);
        this.motionX *= 0.009999999776482582;
        this.motionY *= 0.009999999776482582;
        this.motionZ *= 0.009999999776482582;
        this.motionY += 0.1;
        this.particleScale *= 0.75f;
        this.particleScale *= llllllllllllIllllllllIIIIIlIIIII;
        this.particleScaleOverTime = this.particleScale;
        this.particleMaxAge = 16;
        this.setParticleTextureIndex(80);
    }
    
    protected ParticleHeart(final World llllllllllllIllllllllIIIIIllIlIl, final double llllllllllllIllllllllIIIIIllIlII, final double llllllllllllIllllllllIIIIIlllIll, final double llllllllllllIllllllllIIIIIlllIlI, final double llllllllllllIllllllllIIIIIllIIIl, final double llllllllllllIllllllllIIIIIlllIII, final double llllllllllllIllllllllIIIIIlIllll) {
        this(llllllllllllIllllllllIIIIIllIlIl, llllllllllllIllllllllIIIIIllIlII, llllllllllllIllllllllIIIIIlllIll, llllllllllllIllllllllIIIIIlllIlI, llllllllllllIllllllllIIIIIllIIIl, llllllllllllIllllllllIIIIIlllIII, llllllllllllIllllllllIIIIIlIllll, 2.0f);
    }
    
    public static class AngryVillagerFactory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int llllllllllllllIlIIIllIlIlllllIlI, final World llllllllllllllIlIIIllIlIlllllIIl, final double llllllllllllllIlIIIllIlIlllllIII, final double llllllllllllllIlIIIllIlIlllIllIl, final double llllllllllllllIlIIIllIlIllllIllI, final double llllllllllllllIlIIIllIlIllllIlIl, final double llllllllllllllIlIIIllIlIllllIlII, final double llllllllllllllIlIIIllIlIlllIlIIl, final int... llllllllllllllIlIIIllIlIllllIIlI) {
            final Particle llllllllllllllIlIIIllIlIllllIIIl = new ParticleHeart(llllllllllllllIlIIIllIlIlllllIIl, llllllllllllllIlIIIllIlIlllllIII, llllllllllllllIlIIIllIlIlllIllIl + 0.5, llllllllllllllIlIIIllIlIllllIllI, llllllllllllllIlIIIllIlIllllIlIl, llllllllllllllIlIIIllIlIllllIlII, llllllllllllllIlIIIllIlIlllIlIIl);
            llllllllllllllIlIIIllIlIllllIIIl.setParticleTextureIndex(81);
            llllllllllllllIlIIIllIlIllllIIIl.setRBGColorF(1.0f, 1.0f, 1.0f);
            return llllllllllllllIlIIIllIlIllllIIIl;
        }
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int llllllllllllllIIlIIlIIIIIllIlllI, final World llllllllllllllIIlIIlIIIIIllIllIl, final double llllllllllllllIIlIIlIIIIIllIllII, final double llllllllllllllIIlIIlIIIIIllIlIll, final double llllllllllllllIIlIIlIIIIIllIlIlI, final double llllllllllllllIIlIIlIIIIIllIlIIl, final double llllllllllllllIIlIIlIIIIIllIIIII, final double llllllllllllllIIlIIlIIIIIlIllllI, final int... llllllllllllllIIlIIlIIIIIllIIllI) {
            return new ParticleHeart(llllllllllllllIIlIIlIIIIIllIllIl, llllllllllllllIIlIIlIIIIIllIllII, llllllllllllllIIlIIlIIIIIllIlIll, llllllllllllllIIlIIlIIIIIllIlIlI, llllllllllllllIIlIIlIIIIIllIlIIl, llllllllllllllIIlIIlIIIIIllIIIII, llllllllllllllIIlIIlIIIIIlIllllI);
        }
    }
}
