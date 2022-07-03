package net.minecraft.client.particle;

import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;

public class ParticleCloud extends Particle
{
    /* synthetic */ float oSize;
    
    protected ParticleCloud(final World lllllllllllllIIllIIlIllIIlIllIIl, final double lllllllllllllIIllIIlIllIIllIIIlI, final double lllllllllllllIIllIIlIllIIlIlIlll, final double lllllllllllllIIllIIlIllIIlIlIllI, final double lllllllllllllIIllIIlIllIIlIlIlIl, final double lllllllllllllIIllIIlIllIIlIlIlII, final double lllllllllllllIIllIIlIllIIlIlIIll) {
        super(lllllllllllllIIllIIlIllIIlIllIIl, lllllllllllllIIllIIlIllIIllIIIlI, lllllllllllllIIllIIlIllIIlIlIlll, lllllllllllllIIllIIlIllIIlIlIllI, 0.0, 0.0, 0.0);
        final float lllllllllllllIIllIIlIllIIlIlllII = 2.5f;
        this.motionX *= 0.10000000149011612;
        this.motionY *= 0.10000000149011612;
        this.motionZ *= 0.10000000149011612;
        this.motionX += lllllllllllllIIllIIlIllIIlIlIlIl;
        this.motionY += lllllllllllllIIllIIlIllIIlIlIlII;
        this.motionZ += lllllllllllllIIllIIlIllIIlIlIIll;
        final float lllllllllllllIIllIIlIllIIlIllIll = 1.0f - (float)(Math.random() * 0.30000001192092896);
        this.particleRed = lllllllllllllIIllIIlIllIIlIllIll;
        this.particleGreen = lllllllllllllIIllIIlIllIIlIllIll;
        this.particleBlue = lllllllllllllIIllIIlIllIIlIllIll;
        this.particleScale *= 0.75f;
        this.particleScale *= 2.5f;
        this.oSize = this.particleScale;
        this.particleMaxAge = (int)(8.0 / (Math.random() * 0.8 + 0.3));
        this.particleMaxAge *= (int)2.5f;
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
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.9599999785423279;
        this.motionY *= 0.9599999785423279;
        this.motionZ *= 0.9599999785423279;
        final EntityPlayer lllllllllllllIIllIIlIllIIIlIlllI = this.worldObj.getClosestPlayer(this.posX, this.posY, this.posZ, 2.0, false);
        if (lllllllllllllIIllIIlIllIIIlIlllI != null) {
            final AxisAlignedBB lllllllllllllIIllIIlIllIIIlIllIl = lllllllllllllIIllIIlIllIIIlIlllI.getEntityBoundingBox();
            if (this.posY > lllllllllllllIIllIIlIllIIIlIllIl.minY) {
                this.posY += (lllllllllllllIIllIIlIllIIIlIllIl.minY - this.posY) * 0.2;
                this.motionY += (lllllllllllllIIllIIlIllIIIlIlllI.motionY - this.motionY) * 0.2;
                this.setPosition(this.posX, this.posY, this.posZ);
            }
        }
        if (this.isCollided) {
            this.motionX *= 0.699999988079071;
            this.motionZ *= 0.699999988079071;
        }
    }
    
    @Override
    public void renderParticle(final BufferBuilder lllllllllllllIIllIIlIllIIlIIIlIl, final Entity lllllllllllllIIllIIlIllIIlIIIlII, final float lllllllllllllIIllIIlIllIIIlllIIl, final float lllllllllllllIIllIIlIllIIlIIIIlI, final float lllllllllllllIIllIIlIllIIIllIlll, final float lllllllllllllIIllIIlIllIIlIIIIII, final float lllllllllllllIIllIIlIllIIIllIlIl, final float lllllllllllllIIllIIlIllIIIllIlII) {
        float lllllllllllllIIllIIlIllIIIllllIl = (this.particleAge + lllllllllllllIIllIIlIllIIIlllIIl) / this.particleMaxAge * 32.0f;
        lllllllllllllIIllIIlIllIIIllllIl = MathHelper.clamp(lllllllllllllIIllIIlIllIIIllllIl, 0.0f, 1.0f);
        this.particleScale = this.oSize * lllllllllllllIIllIIlIllIIIllllIl;
        super.renderParticle(lllllllllllllIIllIIlIllIIlIIIlIl, lllllllllllllIIllIIlIllIIlIIIlII, lllllllllllllIIllIIlIllIIIlllIIl, lllllllllllllIIllIIlIllIIlIIIIlI, lllllllllllllIIllIIlIllIIIllIlll, lllllllllllllIIllIIlIllIIlIIIIII, lllllllllllllIIllIIlIllIIIllIlIl, lllllllllllllIIllIIlIllIIIllIlII);
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int llllllllllllllllIllIlIlIlIlIllIl, final World llllllllllllllllIllIlIlIlIlIllII, final double llllllllllllllllIllIlIlIlIlIIIll, final double llllllllllllllllIllIlIlIlIlIlIlI, final double llllllllllllllllIllIlIlIlIlIlIIl, final double llllllllllllllllIllIlIlIlIlIIIII, final double llllllllllllllllIllIlIlIlIlIIlll, final double llllllllllllllllIllIlIlIlIlIIllI, final int... llllllllllllllllIllIlIlIlIlIIlIl) {
            return new ParticleCloud(llllllllllllllllIllIlIlIlIlIllII, llllllllllllllllIllIlIlIlIlIIIll, llllllllllllllllIllIlIlIlIlIlIlI, llllllllllllllllIllIlIlIlIlIlIIl, llllllllllllllllIllIlIlIlIlIIIII, llllllllllllllllIllIlIlIlIlIIlll, llllllllllllllllIllIlIlIlIlIIllI);
        }
    }
}
