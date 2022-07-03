package net.minecraft.client.particle;

import java.util.*;
import net.minecraft.world.*;

public class ParticleSpell extends Particle
{
    private static final /* synthetic */ Random RANDOM;
    private /* synthetic */ int baseSpellTextureIndex;
    
    @Override
    public boolean isTransparent() {
        return true;
    }
    
    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.particleAge++ >= this.particleMaxAge) {
            this.setExpired();
        }
        this.setParticleTextureIndex(this.baseSpellTextureIndex + (7 - this.particleAge * 8 / this.particleMaxAge));
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
    
    static {
        RANDOM = new Random();
    }
    
    public void setBaseSpellTextureIndex(final int llllllllllllIlllllIIIlIlIIIIllII) {
        this.baseSpellTextureIndex = llllllllllllIlllllIIIlIlIIIIllII;
    }
    
    protected ParticleSpell(final World llllllllllllIlllllIIIlIlIIlIIlII, final double llllllllllllIlllllIIIlIlIIIllIll, final double llllllllllllIlllllIIIlIlIIIllIlI, final double llllllllllllIlllllIIIlIlIIlIIIIl, final double llllllllllllIlllllIIIlIlIIIllIII, final double llllllllllllIlllllIIIlIlIIIlllll, final double llllllllllllIlllllIIIlIlIIIlIllI) {
        super(llllllllllllIlllllIIIlIlIIlIIlII, llllllllllllIlllllIIIlIlIIIllIll, llllllllllllIlllllIIIlIlIIIllIlI, llllllllllllIlllllIIIlIlIIlIIIIl, 0.5 - ParticleSpell.RANDOM.nextDouble(), llllllllllllIlllllIIIlIlIIIlllll, 0.5 - ParticleSpell.RANDOM.nextDouble());
        this.baseSpellTextureIndex = 128;
        this.motionY *= 0.20000000298023224;
        if (llllllllllllIlllllIIIlIlIIIllIII == 0.0 && llllllllllllIlllllIIIlIlIIIlIllI == 0.0) {
            this.motionX *= 0.10000000149011612;
            this.motionZ *= 0.10000000149011612;
        }
        this.particleScale *= 0.75f;
        this.particleMaxAge = (int)(8.0 / (Math.random() * 0.8 + 0.2));
    }
    
    public static class AmbientMobFactory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int llllllllllllllllIIllllIIIlllIllI, final World llllllllllllllllIIllllIIIllIlIll, final double llllllllllllllllIIllllIIIllIlIlI, final double llllllllllllllllIIllllIIIllIlIIl, final double llllllllllllllllIIllllIIIlllIIlI, final double llllllllllllllllIIllllIIIllIIlll, final double llllllllllllllllIIllllIIIllIIllI, final double llllllllllllllllIIllllIIIllIllll, final int... llllllllllllllllIIllllIIIllIlllI) {
            final Particle llllllllllllllllIIllllIIIllIllIl = new ParticleSpell(llllllllllllllllIIllllIIIllIlIll, llllllllllllllllIIllllIIIllIlIlI, llllllllllllllllIIllllIIIllIlIIl, llllllllllllllllIIllllIIIlllIIlI, llllllllllllllllIIllllIIIllIIlll, llllllllllllllllIIllllIIIllIIllI, llllllllllllllllIIllllIIIllIllll);
            llllllllllllllllIIllllIIIllIllIl.setAlphaF(0.15f);
            llllllllllllllllIIllllIIIllIllIl.setRBGColorF((float)llllllllllllllllIIllllIIIllIIlll, (float)llllllllllllllllIIllllIIIllIIllI, (float)llllllllllllllllIIllllIIIllIllll);
            return llllllllllllllllIIllllIIIllIllIl;
        }
    }
    
    public static class MobFactory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int lllllllllllllllIIIIlIllllIllllIl, final World lllllllllllllllIIIIlIllllIllIIlI, final double lllllllllllllllIIIIlIllllIllIIIl, final double lllllllllllllllIIIIlIllllIlllIlI, final double lllllllllllllllIIIIlIllllIlllIIl, final double lllllllllllllllIIIIlIllllIlllIII, final double lllllllllllllllIIIIlIllllIlIllIl, final double lllllllllllllllIIIIlIllllIllIllI, final int... lllllllllllllllIIIIlIllllIllIlIl) {
            final Particle lllllllllllllllIIIIlIllllIllIlII = new ParticleSpell(lllllllllllllllIIIIlIllllIllIIlI, lllllllllllllllIIIIlIllllIllIIIl, lllllllllllllllIIIIlIllllIlllIlI, lllllllllllllllIIIIlIllllIlllIIl, lllllllllllllllIIIIlIllllIlllIII, lllllllllllllllIIIIlIllllIlIllIl, lllllllllllllllIIIIlIllllIllIllI);
            lllllllllllllllIIIIlIllllIllIlII.setRBGColorF((float)lllllllllllllllIIIIlIllllIlllIII, (float)lllllllllllllllIIIIlIllllIlIllIl, (float)lllllllllllllllIIIIlIllllIllIllI);
            return lllllllllllllllIIIIlIllllIllIlII;
        }
    }
    
    public static class WitchFactory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int llllllllllllllllllIlIIlllIlIlIlI, final World llllllllllllllllllIlIIlllIlIlIIl, final double llllllllllllllllllIlIIlllIlIlIII, final double llllllllllllllllllIlIIlllIlIIlll, final double llllllllllllllllllIlIIlllIIllIlI, final double llllllllllllllllllIlIIlllIlIIlIl, final double llllllllllllllllllIlIIlllIIllIII, final double llllllllllllllllllIlIIlllIlIIIll, final int... llllllllllllllllllIlIIlllIlIIIlI) {
            final Particle llllllllllllllllllIlIIlllIlIIIIl = new ParticleSpell(llllllllllllllllllIlIIlllIlIlIIl, llllllllllllllllllIlIIlllIlIlIII, llllllllllllllllllIlIIlllIlIIlll, llllllllllllllllllIlIIlllIIllIlI, llllllllllllllllllIlIIlllIlIIlIl, llllllllllllllllllIlIIlllIIllIII, llllllllllllllllllIlIIlllIlIIIll);
            ((ParticleSpell)llllllllllllllllllIlIIlllIlIIIIl).setBaseSpellTextureIndex(144);
            final float llllllllllllllllllIlIIlllIlIIIII = llllllllllllllllllIlIIlllIlIlIIl.rand.nextFloat() * 0.5f + 0.35f;
            llllllllllllllllllIlIIlllIlIIIIl.setRBGColorF(1.0f * llllllllllllllllllIlIIlllIlIIIII, 0.0f * llllllllllllllllllIlIIlllIlIIIII, 1.0f * llllllllllllllllllIlIIlllIlIIIII);
            return llllllllllllllllllIlIIlllIlIIIIl;
        }
    }
    
    public static class InstantFactory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int lllllllllllllIllIlIlIlllllIIIIIl, final World lllllllllllllIllIlIlIlllllIIIIII, final double lllllllllllllIllIlIlIllllIllIlIl, final double lllllllllllllIllIlIlIllllIllIlII, final double lllllllllllllIllIlIlIllllIllllIl, final double lllllllllllllIllIlIlIllllIllIIlI, final double lllllllllllllIllIlIlIllllIllIIIl, final double lllllllllllllIllIlIlIllllIllIIII, final int... lllllllllllllIllIlIlIllllIlllIIl) {
            final Particle lllllllllllllIllIlIlIllllIlllIII = new ParticleSpell(lllllllllllllIllIlIlIlllllIIIIII, lllllllllllllIllIlIlIllllIllIlIl, lllllllllllllIllIlIlIllllIllIlII, lllllllllllllIllIlIlIllllIllllIl, lllllllllllllIllIlIlIllllIllIIlI, lllllllllllllIllIlIlIllllIllIIIl, lllllllllllllIllIlIlIllllIllIIII);
            ((ParticleSpell)lllllllllllllIllIlIlIllllIlllIII).setBaseSpellTextureIndex(144);
            return lllllllllllllIllIlIlIllllIlllIII;
        }
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int llllllllllllllIllIIllIIIlIIIlllI, final World llllllllllllllIllIIllIIIlIIIllIl, final double llllllllllllllIllIIllIIIlIIIIlII, final double llllllllllllllIllIIllIIIlIIIlIll, final double llllllllllllllIllIIllIIIlIIIIIlI, final double llllllllllllllIllIIllIIIlIIIIIIl, final double llllllllllllllIllIIllIIIlIIIIIII, final double llllllllllllllIllIIllIIIIlllllll, final int... llllllllllllllIllIIllIIIlIIIIllI) {
            return new ParticleSpell(llllllllllllllIllIIllIIIlIIIllIl, llllllllllllllIllIIllIIIlIIIIlII, llllllllllllllIllIIllIIIlIIIlIll, llllllllllllllIllIIllIIIlIIIIIlI, llllllllllllllIllIIllIIIlIIIIIIl, llllllllllllllIllIIllIIIlIIIIIII, llllllllllllllIllIIllIIIIlllllll);
        }
    }
}
