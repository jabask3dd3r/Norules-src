package net.minecraft.client.particle;

import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;

public class ParticlePortal extends Particle
{
    private final /* synthetic */ double portalPosX;
    private final /* synthetic */ float portalParticleScale;
    private final /* synthetic */ double portalPosZ;
    private final /* synthetic */ double portalPosY;
    
    @Override
    public void renderParticle(final BufferBuilder lllllllllllllIllIlIIlllIlIIIllII, final Entity lllllllllllllIllIlIIlllIlIIlIlIl, final float lllllllllllllIllIlIIlllIlIIIlIlI, final float lllllllllllllIllIlIIlllIlIIlIIll, final float lllllllllllllIllIlIIlllIlIIlIIlI, final float lllllllllllllIllIlIIlllIlIIlIIIl, final float lllllllllllllIllIlIIlllIlIIlIIII, final float lllllllllllllIllIlIIlllIlIIIllll) {
        float lllllllllllllIllIlIIlllIlIIIlllI = (this.particleAge + lllllllllllllIllIlIIlllIlIIIlIlI) / this.particleMaxAge;
        lllllllllllllIllIlIIlllIlIIIlllI = 1.0f - lllllllllllllIllIlIIlllIlIIIlllI;
        lllllllllllllIllIlIIlllIlIIIlllI *= lllllllllllllIllIlIIlllIlIIIlllI;
        lllllllllllllIllIlIIlllIlIIIlllI = 1.0f - lllllllllllllIllIlIIlllIlIIIlllI;
        this.particleScale = this.portalParticleScale * lllllllllllllIllIlIIlllIlIIIlllI;
        super.renderParticle(lllllllllllllIllIlIIlllIlIIIllII, lllllllllllllIllIlIIlllIlIIlIlIl, lllllllllllllIllIlIIlllIlIIIlIlI, lllllllllllllIllIlIIlllIlIIlIIll, lllllllllllllIllIlIIlllIlIIlIIlI, lllllllllllllIllIlIIlllIlIIlIIIl, lllllllllllllIllIlIIlllIlIIlIIII, lllllllllllllIllIlIIlllIlIIIllll);
    }
    
    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        final float lllllllllllllIllIlIIlllIIllIllII = this.particleAge / (float)this.particleMaxAge;
        final float lllllllllllllIllIlIIlllIIllIlIll = -lllllllllllllIllIlIIlllIIllIllII + lllllllllllllIllIlIIlllIIllIllII * lllllllllllllIllIlIIlllIIllIllII * 2.0f;
        final float lllllllllllllIllIlIIlllIIllIlIlI = 1.0f - lllllllllllllIllIlIIlllIIllIlIll;
        this.posX = this.portalPosX + this.motionX * lllllllllllllIllIlIIlllIIllIlIlI;
        this.posY = this.portalPosY + this.motionY * lllllllllllllIllIlIIlllIIllIlIlI + (1.0f - lllllllllllllIllIlIIlllIIllIllII);
        this.posZ = this.portalPosZ + this.motionZ * lllllllllllllIllIlIIlllIIllIlIlI;
        if (this.particleAge++ >= this.particleMaxAge) {
            this.setExpired();
        }
    }
    
    protected ParticlePortal(final World lllllllllllllIllIlIIlllIlIlllllI, final double lllllllllllllIllIlIIlllIlIllllIl, final double lllllllllllllIllIlIIlllIlIllllII, final double lllllllllllllIllIlIIlllIlIllIIlI, final double lllllllllllllIllIlIIlllIlIlllIlI, final double lllllllllllllIllIlIIlllIlIlllIIl, final double lllllllllllllIllIlIIlllIlIlllIII) {
        super(lllllllllllllIllIlIIlllIlIlllllI, lllllllllllllIllIlIIlllIlIllllIl, lllllllllllllIllIlIIlllIlIllllII, lllllllllllllIllIlIIlllIlIllIIlI, lllllllllllllIllIlIIlllIlIlllIlI, lllllllllllllIllIlIIlllIlIlllIIl, lllllllllllllIllIlIIlllIlIlllIII);
        this.motionX = lllllllllllllIllIlIIlllIlIlllIlI;
        this.motionY = lllllllllllllIllIlIIlllIlIlllIIl;
        this.motionZ = lllllllllllllIllIlIIlllIlIlllIII;
        this.posX = lllllllllllllIllIlIIlllIlIllllIl;
        this.posY = lllllllllllllIllIlIIlllIlIllllII;
        this.posZ = lllllllllllllIllIlIIlllIlIllIIlI;
        this.portalPosX = this.posX;
        this.portalPosY = this.posY;
        this.portalPosZ = this.posZ;
        final float lllllllllllllIllIlIIlllIlIllIlll = this.rand.nextFloat() * 0.6f + 0.4f;
        this.particleScale = this.rand.nextFloat() * 0.2f + 0.5f;
        this.portalParticleScale = this.particleScale;
        this.particleRed = lllllllllllllIllIlIIlllIlIllIlll * 0.9f;
        this.particleGreen = lllllllllllllIllIlIIlllIlIllIlll * 0.3f;
        this.particleBlue = lllllllllllllIllIlIIlllIlIllIlll;
        this.particleMaxAge = (int)(Math.random() * 10.0) + 40;
        this.setParticleTextureIndex((int)(Math.random() * 8.0));
    }
    
    @Override
    public int getBrightnessForRender(final float lllllllllllllIllIlIIlllIIlllIllI) {
        final int lllllllllllllIllIlIIlllIIllllIll = super.getBrightnessForRender(lllllllllllllIllIlIIlllIIlllIllI);
        float lllllllllllllIllIlIIlllIIllllIlI = this.particleAge / (float)this.particleMaxAge;
        lllllllllllllIllIlIIlllIIllllIlI *= lllllllllllllIllIlIIlllIIllllIlI;
        lllllllllllllIllIlIIlllIIllllIlI *= lllllllllllllIllIlIIlllIIllllIlI;
        final int lllllllllllllIllIlIIlllIIllllIIl = lllllllllllllIllIlIIlllIIllllIll & 0xFF;
        int lllllllllllllIllIlIIlllIIllllIII = lllllllllllllIllIlIIlllIIllllIll >> 16 & 0xFF;
        lllllllllllllIllIlIIlllIIllllIII += (int)(lllllllllllllIllIlIIlllIIllllIlI * 15.0f * 16.0f);
        if (lllllllllllllIllIlIIlllIIllllIII > 240) {
            lllllllllllllIllIlIIlllIIllllIII = 240;
        }
        return lllllllllllllIllIlIIlllIIllllIIl | lllllllllllllIllIlIIlllIIllllIII << 16;
    }
    
    @Override
    public void moveEntity(final double lllllllllllllIllIlIIlllIlIlIlIII, final double lllllllllllllIllIlIIlllIlIlIIlll, final double lllllllllllllIllIlIIlllIlIlIIllI) {
        this.setEntityBoundingBox(this.getEntityBoundingBox().offset(lllllllllllllIllIlIIlllIlIlIlIII, lllllllllllllIllIlIIlllIlIlIIlll, lllllllllllllIllIlIIlllIlIlIIllI));
        this.resetPositionToBB();
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int lllllllllllllIIIIIlIIllIIIIlIllI, final World lllllllllllllIIIIIlIIllIIIIlIlIl, final double lllllllllllllIIIIIlIIllIIIIlIlII, final double lllllllllllllIIIIIlIIllIIIIIlIll, final double lllllllllllllIIIIIlIIllIIIIIlIlI, final double lllllllllllllIIIIIlIIllIIIIIlIIl, final double lllllllllllllIIIIIlIIllIIIIlIIII, final double lllllllllllllIIIIIlIIllIIIIIIlll, final int... lllllllllllllIIIIIlIIllIIIIIlllI) {
            return new ParticlePortal(lllllllllllllIIIIIlIIllIIIIlIlIl, lllllllllllllIIIIIlIIllIIIIlIlII, lllllllllllllIIIIIlIIllIIIIIlIll, lllllllllllllIIIIIlIIllIIIIIlIlI, lllllllllllllIIIIIlIIllIIIIIlIIl, lllllllllllllIIIIIlIIllIIIIlIIII, lllllllllllllIIIIIlIIllIIIIIIlll);
        }
    }
}
