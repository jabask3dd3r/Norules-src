package net.minecraft.client.particle;

import net.minecraft.world.*;

public class ParticleEnchantmentTable extends Particle
{
    private final /* synthetic */ double coordZ;
    private final /* synthetic */ double coordY;
    private final /* synthetic */ double coordX;
    private final /* synthetic */ float oSize;
    
    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        float lllllllllllllIIIIlIIlIlllIIlllII = this.particleAge / (float)this.particleMaxAge;
        lllllllllllllIIIIlIIlIlllIIlllII = 1.0f - lllllllllllllIIIIlIIlIlllIIlllII;
        float lllllllllllllIIIIlIIlIlllIIllIll = 1.0f - lllllllllllllIIIIlIIlIlllIIlllII;
        lllllllllllllIIIIlIIlIlllIIllIll *= lllllllllllllIIIIlIIlIlllIIllIll;
        lllllllllllllIIIIlIIlIlllIIllIll *= lllllllllllllIIIIlIIlIlllIIllIll;
        this.posX = this.coordX + this.motionX * lllllllllllllIIIIlIIlIlllIIlllII;
        this.posY = this.coordY + this.motionY * lllllllllllllIIIIlIIlIlllIIlllII - lllllllllllllIIIIlIIlIlllIIllIll * 1.2f;
        this.posZ = this.coordZ + this.motionZ * lllllllllllllIIIIlIIlIlllIIlllII;
        if (this.particleAge++ >= this.particleMaxAge) {
            this.setExpired();
        }
    }
    
    @Override
    public void moveEntity(final double lllllllllllllIIIIlIIlIlllIlllIIl, final double lllllllllllllIIIIlIIlIlllIllIlII, final double lllllllllllllIIIIlIIlIlllIllIIll) {
        this.setEntityBoundingBox(this.getEntityBoundingBox().offset(lllllllllllllIIIIlIIlIlllIlllIIl, lllllllllllllIIIIlIIlIlllIllIlII, lllllllllllllIIIIlIIlIlllIllIIll));
        this.resetPositionToBB();
    }
    
    @Override
    public int getBrightnessForRender(final float lllllllllllllIIIIlIIlIlllIlIlIll) {
        final int lllllllllllllIIIIlIIlIlllIlIlIlI = super.getBrightnessForRender(lllllllllllllIIIIlIIlIlllIlIlIll);
        float lllllllllllllIIIIlIIlIlllIlIlIIl = this.particleAge / (float)this.particleMaxAge;
        lllllllllllllIIIIlIIlIlllIlIlIIl *= lllllllllllllIIIIlIIlIlllIlIlIIl;
        lllllllllllllIIIIlIIlIlllIlIlIIl *= lllllllllllllIIIIlIIlIlllIlIlIIl;
        final int lllllllllllllIIIIlIIlIlllIlIlIII = lllllllllllllIIIIlIIlIlllIlIlIlI & 0xFF;
        int lllllllllllllIIIIlIIlIlllIlIIlll = lllllllllllllIIIIlIIlIlllIlIlIlI >> 16 & 0xFF;
        lllllllllllllIIIIlIIlIlllIlIIlll += (int)(lllllllllllllIIIIlIIlIlllIlIlIIl * 15.0f * 16.0f);
        if (lllllllllllllIIIIlIIlIlllIlIIlll > 240) {
            lllllllllllllIIIIlIIlIlllIlIIlll = 240;
        }
        return lllllllllllllIIIIlIIlIlllIlIlIII | lllllllllllllIIIIlIIlIlllIlIIlll << 16;
    }
    
    protected ParticleEnchantmentTable(final World lllllllllllllIIIIlIIlIllllIIllll, final double lllllllllllllIIIIlIIlIllllIIlllI, final double lllllllllllllIIIIlIIlIllllIIIlII, final double lllllllllllllIIIIlIIlIllllIIllII, final double lllllllllllllIIIIlIIlIllllIIIIlI, final double lllllllllllllIIIIlIIlIllllIIIIIl, final double lllllllllllllIIIIlIIlIllllIIlIIl) {
        super(lllllllllllllIIIIlIIlIllllIIllll, lllllllllllllIIIIlIIlIllllIIlllI, lllllllllllllIIIIlIIlIllllIIIlII, lllllllllllllIIIIlIIlIllllIIllII, lllllllllllllIIIIlIIlIllllIIIIlI, lllllllllllllIIIIlIIlIllllIIIIIl, lllllllllllllIIIIlIIlIllllIIlIIl);
        this.motionX = lllllllllllllIIIIlIIlIllllIIIIlI;
        this.motionY = lllllllllllllIIIIlIIlIllllIIIIIl;
        this.motionZ = lllllllllllllIIIIlIIlIllllIIlIIl;
        this.coordX = lllllllllllllIIIIlIIlIllllIIlllI;
        this.coordY = lllllllllllllIIIIlIIlIllllIIIlII;
        this.coordZ = lllllllllllllIIIIlIIlIllllIIllII;
        this.prevPosX = lllllllllllllIIIIlIIlIllllIIlllI + lllllllllllllIIIIlIIlIllllIIIIlI;
        this.prevPosY = lllllllllllllIIIIlIIlIllllIIIlII + lllllllllllllIIIIlIIlIllllIIIIIl;
        this.prevPosZ = lllllllllllllIIIIlIIlIllllIIllII + lllllllllllllIIIIlIIlIllllIIlIIl;
        this.posX = this.prevPosX;
        this.posY = this.prevPosY;
        this.posZ = this.prevPosZ;
        final float lllllllllllllIIIIlIIlIllllIIlIII = this.rand.nextFloat() * 0.6f + 0.4f;
        this.particleScale = this.rand.nextFloat() * 0.5f + 0.2f;
        this.oSize = this.particleScale;
        this.particleRed = 0.9f * lllllllllllllIIIIlIIlIllllIIlIII;
        this.particleGreen = 0.9f * lllllllllllllIIIIlIIlIllllIIlIII;
        this.particleBlue = lllllllllllllIIIIlIIlIllllIIlIII;
        this.particleMaxAge = (int)(Math.random() * 10.0) + 30;
        this.setParticleTextureIndex((int)(Math.random() * 26.0 + 1.0 + 224.0));
    }
    
    public static class EnchantmentTable implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int lllllllllllllIIIIIlIIllIIlIIlIII, final World lllllllllllllIIIIIlIIllIIlIIIlll, final double lllllllllllllIIIIIlIIllIIIlllllI, final double lllllllllllllIIIIIlIIllIIlIIIlIl, final double lllllllllllllIIIIIlIIllIIlIIIlII, final double lllllllllllllIIIIIlIIllIIlIIIIll, final double lllllllllllllIIIIIlIIllIIIlllIlI, final double lllllllllllllIIIIIlIIllIIlIIIIIl, final int... lllllllllllllIIIIIlIIllIIlIIIIII) {
            return new ParticleEnchantmentTable(lllllllllllllIIIIIlIIllIIlIIIlll, lllllllllllllIIIIIlIIllIIIlllllI, lllllllllllllIIIIIlIIllIIlIIIlIl, lllllllllllllIIIIIlIIllIIlIIIlII, lllllllllllllIIIIIlIIllIIlIIIIll, lllllllllllllIIIIIlIIllIIIlllIlI, lllllllllllllIIIIIlIIllIIlIIIIIl);
        }
    }
}
