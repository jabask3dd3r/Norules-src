package net.minecraft.client.particle;

import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;

public class ParticleNote extends Particle
{
    /* synthetic */ float noteParticleScale;
    
    protected ParticleNote(final World lllllllllllllllllIIlllIIIIIlIlll, final double lllllllllllllllllIIlllIIIIIlIllI, final double lllllllllllllllllIIlllIIIIIlIlIl, final double lllllllllllllllllIIlllIIIIIIllII, final double lllllllllllllllllIIlllIIIIIlIIll, final double lllllllllllllllllIIlllIIIIIIlIlI, final double lllllllllllllllllIIlllIIIIIlIIIl) {
        this(lllllllllllllllllIIlllIIIIIlIlll, lllllllllllllllllIIlllIIIIIlIllI, lllllllllllllllllIIlllIIIIIlIlIl, lllllllllllllllllIIlllIIIIIIllII, lllllllllllllllllIIlllIIIIIlIIll, lllllllllllllllllIIlllIIIIIIlIlI, lllllllllllllllllIIlllIIIIIlIIIl, 2.0f);
    }
    
    protected ParticleNote(final World lllllllllllllllllIIllIllllllIlll, final double lllllllllllllllllIIllIllllllIllI, final double lllllllllllllllllIIllIlllllllllI, final double lllllllllllllllllIIllIllllllIlII, final double lllllllllllllllllIIllIllllllllII, final double lllllllllllllllllIIllIlllllllIll, final double lllllllllllllllllIIllIlllllllIlI, final float lllllllllllllllllIIllIllllllIIlI) {
        super(lllllllllllllllllIIllIllllllIlll, lllllllllllllllllIIllIllllllIllI, lllllllllllllllllIIllIlllllllllI, lllllllllllllllllIIllIllllllIlII, 0.0, 0.0, 0.0);
        this.motionX *= 0.009999999776482582;
        this.motionY *= 0.009999999776482582;
        this.motionZ *= 0.009999999776482582;
        this.motionY += 0.2;
        this.particleRed = MathHelper.sin(((float)lllllllllllllllllIIllIllllllllII + 0.0f) * 6.2831855f) * 0.65f + 0.35f;
        this.particleGreen = MathHelper.sin(((float)lllllllllllllllllIIllIllllllllII + 0.33333334f) * 6.2831855f) * 0.65f + 0.35f;
        this.particleBlue = MathHelper.sin(((float)lllllllllllllllllIIllIllllllllII + 0.6666667f) * 6.2831855f) * 0.65f + 0.35f;
        this.particleScale *= 0.75f;
        this.particleScale *= lllllllllllllllllIIllIllllllIIlI;
        this.noteParticleScale = this.particleScale;
        this.particleMaxAge = 6;
        this.setParticleTextureIndex(64);
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
        this.motionX *= 0.6600000262260437;
        this.motionY *= 0.6600000262260437;
        this.motionZ *= 0.6600000262260437;
        if (this.isCollided) {
            this.motionX *= 0.699999988079071;
            this.motionZ *= 0.699999988079071;
        }
    }
    
    @Override
    public void renderParticle(final BufferBuilder lllllllllllllllllIIllIllllIlllII, final Entity lllllllllllllllllIIllIlllllIIlIl, final float lllllllllllllllllIIllIllllIllIlI, final float lllllllllllllllllIIllIlllllIIIll, final float lllllllllllllllllIIllIllllIllIII, final float lllllllllllllllllIIllIlllllIIIIl, final float lllllllllllllllllIIllIlllllIIIII, final float lllllllllllllllllIIllIllllIlIlIl) {
        float lllllllllllllllllIIllIllllIllllI = (this.particleAge + lllllllllllllllllIIllIllllIllIlI) / this.particleMaxAge * 32.0f;
        lllllllllllllllllIIllIllllIllllI = MathHelper.clamp(lllllllllllllllllIIllIllllIllllI, 0.0f, 1.0f);
        this.particleScale = this.noteParticleScale * lllllllllllllllllIIllIllllIllllI;
        super.renderParticle(lllllllllllllllllIIllIllllIlllII, lllllllllllllllllIIllIlllllIIlIl, lllllllllllllllllIIllIllllIllIlI, lllllllllllllllllIIllIlllllIIIll, lllllllllllllllllIIllIllllIllIII, lllllllllllllllllIIllIlllllIIIIl, lllllllllllllllllIIllIlllllIIIII, lllllllllllllllllIIllIllllIlIlIl);
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int lllllllllllllIIIllIlIlIlIlIlIllI, final World lllllllllllllIIIllIlIlIlIlIIllIl, final double lllllllllllllIIIllIlIlIlIlIlIlII, final double lllllllllllllIIIllIlIlIlIlIlIIll, final double lllllllllllllIIIllIlIlIlIlIlIIlI, final double lllllllllllllIIIllIlIlIlIlIlIIIl, final double lllllllllllllIIIllIlIlIlIlIlIIII, final double lllllllllllllIIIllIlIlIlIlIIIlll, final int... lllllllllllllIIIllIlIlIlIlIIlllI) {
            return new ParticleNote(lllllllllllllIIIllIlIlIlIlIIllIl, lllllllllllllIIIllIlIlIlIlIlIlII, lllllllllllllIIIllIlIlIlIlIlIIll, lllllllllllllIIIllIlIlIlIlIlIIlI, lllllllllllllIIIllIlIlIlIlIlIIIl, lllllllllllllIIIllIlIlIlIlIlIIII, lllllllllllllIIIllIlIlIlIlIIIlll);
        }
    }
}
