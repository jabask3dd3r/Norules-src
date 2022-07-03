package net.minecraft.client.particle;

import net.minecraft.world.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;

public class ParticleCrit extends Particle
{
    /* synthetic */ float oSize;
    
    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.particleAge++ >= this.particleMaxAge) {
            this.setExpired();
        }
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.particleGreen *= (float)0.96;
        this.particleBlue *= (float)0.9;
        this.motionX *= 0.699999988079071;
        this.motionY *= 0.699999988079071;
        this.motionZ *= 0.699999988079071;
        this.motionY -= 0.019999999552965164;
        if (this.isCollided) {
            this.motionX *= 0.699999988079071;
            this.motionZ *= 0.699999988079071;
        }
    }
    
    protected ParticleCrit(final World lllllllllllllIlllIIIIlIlIlllllll, final double lllllllllllllIlllIIIIlIlIlllIllI, final double lllllllllllllIlllIIIIlIlIlllllIl, final double lllllllllllllIlllIIIIlIlIlllllII, final double lllllllllllllIlllIIIIlIlIlllIIll, final double lllllllllllllIlllIIIIlIlIllllIlI, final double lllllllllllllIlllIIIIlIlIllllIIl) {
        this(lllllllllllllIlllIIIIlIlIlllllll, lllllllllllllIlllIIIIlIlIlllIllI, lllllllllllllIlllIIIIlIlIlllllIl, lllllllllllllIlllIIIIlIlIlllllII, lllllllllllllIlllIIIIlIlIlllIIll, lllllllllllllIlllIIIIlIlIllllIlI, lllllllllllllIlllIIIIlIlIllllIIl, 1.0f);
    }
    
    @Override
    public void renderParticle(final BufferBuilder lllllllllllllIlllIIIIlIlIIllllIl, final Entity lllllllllllllIlllIIIIlIlIIllllII, final float lllllllllllllIlllIIIIlIlIlIIIlIl, final float lllllllllllllIlllIIIIlIlIIlllIlI, final float lllllllllllllIlllIIIIlIlIIlllIIl, final float lllllllllllllIlllIIIIlIlIIlllIII, final float lllllllllllllIlllIIIIlIlIIllIlll, final float lllllllllllllIlllIIIIlIlIlIIIIII) {
        float lllllllllllllIlllIIIIlIlIIllllll = (this.particleAge + lllllllllllllIlllIIIIlIlIlIIIlIl) / this.particleMaxAge * 32.0f;
        lllllllllllllIlllIIIIlIlIIllllll = MathHelper.clamp(lllllllllllllIlllIIIIlIlIIllllll, 0.0f, 1.0f);
        this.particleScale = this.oSize * lllllllllllllIlllIIIIlIlIIllllll;
        super.renderParticle(lllllllllllllIlllIIIIlIlIIllllIl, lllllllllllllIlllIIIIlIlIIllllII, lllllllllllllIlllIIIIlIlIlIIIlIl, lllllllllllllIlllIIIIlIlIIlllIlI, lllllllllllllIlllIIIIlIlIIlllIIl, lllllllllllllIlllIIIIlIlIIlllIII, lllllllllllllIlllIIIIlIlIIllIlll, lllllllllllllIlllIIIIlIlIlIIIIII);
    }
    
    protected ParticleCrit(final World lllllllllllllIlllIIIIlIlIlIllIll, final double lllllllllllllIlllIIIIlIlIlIllIlI, final double lllllllllllllIlllIIIIlIlIlIllIIl, final double lllllllllllllIlllIIIIlIlIllIIIlI, final double lllllllllllllIlllIIIIlIlIllIIIIl, final double lllllllllllllIlllIIIIlIlIlIlIllI, final double lllllllllllllIlllIIIIlIlIlIlllll, final float lllllllllllllIlllIIIIlIlIlIllllI) {
        super(lllllllllllllIlllIIIIlIlIlIllIll, lllllllllllllIlllIIIIlIlIlIllIlI, lllllllllllllIlllIIIIlIlIlIllIIl, lllllllllllllIlllIIIIlIlIllIIIlI, 0.0, 0.0, 0.0);
        this.motionX *= 0.10000000149011612;
        this.motionY *= 0.10000000149011612;
        this.motionZ *= 0.10000000149011612;
        this.motionX += lllllllllllllIlllIIIIlIlIllIIIIl * 0.4;
        this.motionY += lllllllllllllIlllIIIIlIlIlIlIllI * 0.4;
        this.motionZ += lllllllllllllIlllIIIIlIlIlIlllll * 0.4;
        final float lllllllllllllIlllIIIIlIlIlIlllIl = (float)(Math.random() * 0.30000001192092896 + 0.6000000238418579);
        this.particleRed = lllllllllllllIlllIIIIlIlIlIlllIl;
        this.particleGreen = lllllllllllllIlllIIIIlIlIlIlllIl;
        this.particleBlue = lllllllllllllIlllIIIIlIlIlIlllIl;
        this.particleScale *= 0.75f;
        this.particleScale *= lllllllllllllIlllIIIIlIlIlIllllI;
        this.oSize = this.particleScale;
        this.particleMaxAge = (int)(6.0 / (Math.random() * 0.8 + 0.6));
        this.particleMaxAge *= (int)lllllllllllllIlllIIIIlIlIlIllllI;
        this.setParticleTextureIndex(65);
        this.onUpdate();
    }
    
    public static class MagicFactory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int lllllllllllllIIlIlllllIlIIlIllll, final World lllllllllllllIIlIlllllIlIIlIlllI, final double lllllllllllllIIlIlllllIlIIlIllIl, final double lllllllllllllIIlIlllllIlIIlIIIlI, final double lllllllllllllIIlIlllllIlIIlIlIll, final double lllllllllllllIIlIlllllIlIIlIlIlI, final double lllllllllllllIIlIlllllIlIIlIlIIl, final double lllllllllllllIIlIlllllIlIIlIlIII, final int... lllllllllllllIIlIlllllIlIIlIIlll) {
            final Particle lllllllllllllIIlIlllllIlIIlIIllI = new ParticleCrit(lllllllllllllIIlIlllllIlIIlIlllI, lllllllllllllIIlIlllllIlIIlIllIl, lllllllllllllIIlIlllllIlIIlIIIlI, lllllllllllllIIlIlllllIlIIlIlIll, lllllllllllllIIlIlllllIlIIlIlIlI, lllllllllllllIIlIlllllIlIIlIlIIl, lllllllllllllIIlIlllllIlIIlIlIII);
            lllllllllllllIIlIlllllIlIIlIIllI.setRBGColorF(lllllllllllllIIlIlllllIlIIlIIllI.getRedColorF() * 0.3f, lllllllllllllIIlIlllllIlIIlIIllI.getGreenColorF() * 0.8f, lllllllllllllIIlIlllllIlIIlIIllI.getBlueColorF());
            lllllllllllllIIlIlllllIlIIlIIllI.nextTextureIndexX();
            return lllllllllllllIIlIlllllIlIIlIIllI;
        }
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int llllllllllllllllIlIIlllllIIlIIlI, final World llllllllllllllllIlIIlllllIIlIIIl, final double llllllllllllllllIlIIlllllIIlIIII, final double llllllllllllllllIlIIlllllIIIllll, final double llllllllllllllllIlIIlllllIIIIllI, final double llllllllllllllllIlIIlllllIIIllIl, final double llllllllllllllllIlIIlllllIIIIlII, final double llllllllllllllllIlIIlllllIIIlIll, final int... llllllllllllllllIlIIlllllIIIlIlI) {
            return new ParticleCrit(llllllllllllllllIlIIlllllIIlIIIl, llllllllllllllllIlIIlllllIIlIIII, llllllllllllllllIlIIlllllIIIllll, llllllllllllllllIlIIlllllIIIIllI, llllllllllllllllIlIIlllllIIIllIl, llllllllllllllllIlIIlllllIIIIlII, llllllllllllllllIlIIlllllIIIlIll);
        }
    }
    
    public static class DamageIndicatorFactory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int lllllllllllllIIlIlIIlllllIIllIlI, final World lllllllllllllIIlIlIIlllllIIllIIl, final double lllllllllllllIIlIlIIlllllIIIlllI, final double lllllllllllllIIlIlIIlllllIIIllIl, final double lllllllllllllIIlIlIIlllllIIlIllI, final double lllllllllllllIIlIlIIlllllIIlIlIl, final double lllllllllllllIIlIlIIlllllIIIlIlI, final double lllllllllllllIIlIlIIlllllIIIlIIl, final int... lllllllllllllIIlIlIIlllllIIlIIlI) {
            final Particle lllllllllllllIIlIlIIlllllIIlIIIl = new ParticleCrit(lllllllllllllIIlIlIIlllllIIllIIl, lllllllllllllIIlIlIIlllllIIIlllI, lllllllllllllIIlIlIIlllllIIIllIl, lllllllllllllIIlIlIIlllllIIlIllI, lllllllllllllIIlIlIIlllllIIlIlIl, lllllllllllllIIlIlIIlllllIIIlIlI + 1.0, lllllllllllllIIlIlIIlllllIIIlIIl, 1.0f);
            lllllllllllllIIlIlIIlllllIIlIIIl.setMaxAge(20);
            lllllllllllllIIlIlIIlllllIIlIIIl.setParticleTextureIndex(67);
            return lllllllllllllIIlIlIIlllllIIlIIIl;
        }
    }
}
