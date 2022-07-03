package net.minecraft.client.particle;

import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;

public class ParticleLava extends Particle
{
    private final /* synthetic */ float lavaParticleScale;
    
    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.particleAge++ >= this.particleMaxAge) {
            this.setExpired();
        }
        final float llllllllllllllllIlllllIllIIIIIIl = this.particleAge / (float)this.particleMaxAge;
        if (this.rand.nextFloat() > llllllllllllllllIlllllIllIIIIIIl) {
            this.worldObj.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, this.posX, this.posY, this.posZ, this.motionX, this.motionY, this.motionZ, new int[0]);
        }
        this.motionY -= 0.03;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.9990000128746033;
        this.motionY *= 0.9990000128746033;
        this.motionZ *= 0.9990000128746033;
        if (this.isCollided) {
            this.motionX *= 0.699999988079071;
            this.motionZ *= 0.699999988079071;
        }
    }
    
    protected ParticleLava(final World llllllllllllllllIlllllIllIlllIlI, final double llllllllllllllllIlllllIllIllIlII, final double llllllllllllllllIlllllIllIllIIll, final double llllllllllllllllIlllllIllIllIIlI) {
        super(llllllllllllllllIlllllIllIlllIlI, llllllllllllllllIlllllIllIllIlII, llllllllllllllllIlllllIllIllIIll, llllllllllllllllIlllllIllIllIIlI, 0.0, 0.0, 0.0);
        this.motionX *= 0.800000011920929;
        this.motionY *= 0.800000011920929;
        this.motionZ *= 0.800000011920929;
        this.motionY = this.rand.nextFloat() * 0.4f + 0.05f;
        this.particleRed = 1.0f;
        this.particleGreen = 1.0f;
        this.particleBlue = 1.0f;
        this.particleScale *= this.rand.nextFloat() * 2.0f + 0.2f;
        this.lavaParticleScale = this.particleScale;
        this.particleMaxAge = (int)(16.0 / (Math.random() * 0.8 + 0.2));
        this.setParticleTextureIndex(49);
    }
    
    @Override
    public void renderParticle(final BufferBuilder llllllllllllllllIlllllIllIIlIlll, final Entity llllllllllllllllIlllllIllIIlIllI, final float llllllllllllllllIlllllIllIIIlIll, final float llllllllllllllllIlllllIllIIlIlII, final float llllllllllllllllIlllllIllIIIlIIl, final float llllllllllllllllIlllllIllIIlIIlI, final float llllllllllllllllIlllllIllIIIIlll, final float llllllllllllllllIlllllIllIIIIllI) {
        final float llllllllllllllllIlllllIllIIIllll = (this.particleAge + llllllllllllllllIlllllIllIIIlIll) / this.particleMaxAge;
        this.particleScale = this.lavaParticleScale * (1.0f - llllllllllllllllIlllllIllIIIllll * llllllllllllllllIlllllIllIIIllll);
        super.renderParticle(llllllllllllllllIlllllIllIIlIlll, llllllllllllllllIlllllIllIIlIllI, llllllllllllllllIlllllIllIIIlIll, llllllllllllllllIlllllIllIIlIlII, llllllllllllllllIlllllIllIIIlIIl, llllllllllllllllIlllllIllIIlIIlI, llllllllllllllllIlllllIllIIIIlll, llllllllllllllllIlllllIllIIIIllI);
    }
    
    @Override
    public int getBrightnessForRender(final float llllllllllllllllIlllllIllIlIIllI) {
        final int llllllllllllllllIlllllIllIlIlIlI = super.getBrightnessForRender(llllllllllllllllIlllllIllIlIIllI);
        final int llllllllllllllllIlllllIllIlIlIIl = 240;
        final int llllllllllllllllIlllllIllIlIlIII = llllllllllllllllIlllllIllIlIlIlI >> 16 & 0xFF;
        return 0xF0 | llllllllllllllllIlllllIllIlIlIII << 16;
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int llllllllllllllIIIllllIlIIIlIllIl, final World llllllllllllllIIIllllIlIIIlIlIll, final double llllllllllllllIIIllllIlIIIlIlIlI, final double llllllllllllllIIIllllIlIIIlIlIIl, final double llllllllllllllIIIllllIlIIIIlllIl, final double llllllllllllllIIIllllIlIIIlIIlll, final double llllllllllllllIIIllllIlIIIlIIllI, final double llllllllllllllIIIllllIlIIIlIIlIl, final int... llllllllllllllIIIllllIlIIIlIIlII) {
            return new ParticleLava(llllllllllllllIIIllllIlIIIlIlIll, llllllllllllllIIIllllIlIIIlIlIlI, llllllllllllllIIIllllIlIIIlIlIIl, llllllllllllllIIIllllIlIIIIlllIl);
        }
    }
}
