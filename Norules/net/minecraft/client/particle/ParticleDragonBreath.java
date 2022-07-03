package net.minecraft.client.particle;

import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

public class ParticleDragonBreath extends Particle
{
    private final /* synthetic */ float oSize;
    private /* synthetic */ boolean hasHitGround;
    
    @Override
    public void renderParticle(final BufferBuilder llllllllllllIlllllIIlIIIIlllllll, final Entity llllllllllllIlllllIIlIIIlIIIIlll, final float llllllllllllIlllllIIlIIIlIIIIllI, final float llllllllllllIlllllIIlIIIIlllllII, final float llllllllllllIlllllIIlIIIIllllIll, final float llllllllllllIlllllIIlIIIlIIIIIll, final float llllllllllllIlllllIIlIIIIllllIIl, final float llllllllllllIlllllIIlIIIlIIIIIIl) {
        this.particleScale = this.oSize * MathHelper.clamp((this.particleAge + llllllllllllIlllllIIlIIIlIIIIllI) / this.particleMaxAge * 32.0f, 0.0f, 1.0f);
        super.renderParticle(llllllllllllIlllllIIlIIIIlllllll, llllllllllllIlllllIIlIIIlIIIIlll, llllllllllllIlllllIIlIIIlIIIIllI, llllllllllllIlllllIIlIIIIlllllII, llllllllllllIlllllIIlIIIIllllIll, llllllllllllIlllllIIlIIIlIIIIIll, llllllllllllIlllllIIlIIIIllllIIl, llllllllllllIlllllIIlIIIlIIIIIIl);
    }
    
    protected ParticleDragonBreath(final World llllllllllllIlllllIIlIIIlIlIIlII, final double llllllllllllIlllllIIlIIIlIIllIll, final double llllllllllllIlllllIIlIIIlIIllIlI, final double llllllllllllIlllllIIlIIIlIIllIIl, final double llllllllllllIlllllIIlIIIlIlIIIII, final double llllllllllllIlllllIIlIIIlIIlIlll, final double llllllllllllIlllllIIlIIIlIIlIllI) {
        super(llllllllllllIlllllIIlIIIlIlIIlII, llllllllllllIlllllIIlIIIlIIllIll, llllllllllllIlllllIIlIIIlIIllIlI, llllllllllllIlllllIIlIIIlIIllIIl, llllllllllllIlllllIIlIIIlIlIIIII, llllllllllllIlllllIIlIIIlIIlIlll, llllllllllllIlllllIIlIIIlIIlIllI);
        this.motionX = llllllllllllIlllllIIlIIIlIlIIIII;
        this.motionY = llllllllllllIlllllIIlIIIlIIlIlll;
        this.motionZ = llllllllllllIlllllIIlIIIlIIlIllI;
        this.particleRed = MathHelper.nextFloat(this.rand, 0.7176471f, 0.8745098f);
        this.particleGreen = MathHelper.nextFloat(this.rand, 0.0f, 0.0f);
        this.particleBlue = MathHelper.nextFloat(this.rand, 0.8235294f, 0.9764706f);
        this.particleScale *= 0.75f;
        this.oSize = this.particleScale;
        this.particleMaxAge = (int)(20.0 / (this.rand.nextFloat() * 0.8 + 0.2));
        this.hasHitGround = false;
    }
    
    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.particleAge++ >= this.particleMaxAge) {
            this.setExpired();
        }
        else {
            this.setParticleTextureIndex(3 * this.particleAge / this.particleMaxAge + 5);
            if (this.isCollided) {
                this.motionY = 0.0;
                this.hasHitGround = true;
            }
            if (this.hasHitGround) {
                this.motionY += 0.002;
            }
            this.moveEntity(this.motionX, this.motionY, this.motionZ);
            if (this.posY == this.prevPosY) {
                this.motionX *= 1.1;
                this.motionZ *= 1.1;
            }
            this.motionX *= 0.9599999785423279;
            this.motionZ *= 0.9599999785423279;
            if (this.hasHitGround) {
                this.motionY *= 0.9599999785423279;
            }
        }
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int lllllllllllllIlIIlIIIIIIlIIlIIII, final World lllllllllllllIlIIlIIIIIIlIIIllll, final double lllllllllllllIlIIlIIIIIIlIIIlllI, final double lllllllllllllIlIIlIIIIIIlIIIIlIl, final double lllllllllllllIlIIlIIIIIIlIIIIlII, final double lllllllllllllIlIIlIIIIIIlIIIIIll, final double lllllllllllllIlIIlIIIIIIlIIIlIlI, final double lllllllllllllIlIIlIIIIIIlIIIIIIl, final int... lllllllllllllIlIIlIIIIIIlIIIlIII) {
            return new ParticleDragonBreath(lllllllllllllIlIIlIIIIIIlIIIllll, lllllllllllllIlIIlIIIIIIlIIIlllI, lllllllllllllIlIIlIIIIIIlIIIIlIl, lllllllllllllIlIIlIIIIIIlIIIIlII, lllllllllllllIlIIlIIIIIIlIIIIIll, lllllllllllllIlIIlIIIIIIlIIIlIlI, lllllllllllllIlIIlIIIIIIlIIIIIIl);
        }
    }
}
