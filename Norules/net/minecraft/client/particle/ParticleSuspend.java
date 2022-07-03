package net.minecraft.client.particle;

import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.block.material.*;

public class ParticleSuspend extends Particle
{
    protected ParticleSuspend(final World lllllllllllllIIlllIIlIIIlIIIllII, final double lllllllllllllIIlllIIlIIIlIIIIIll, final double lllllllllllllIIlllIIlIIIlIIIIIlI, final double lllllllllllllIIlllIIlIIIlIIIlIIl, final double lllllllllllllIIlllIIlIIIlIIIlIII, final double lllllllllllllIIlllIIlIIIIlllllll, final double lllllllllllllIIlllIIlIIIIllllllI) {
        super(lllllllllllllIIlllIIlIIIlIIIllII, lllllllllllllIIlllIIlIIIlIIIIIll, lllllllllllllIIlllIIlIIIlIIIIIlI - 0.125, lllllllllllllIIlllIIlIIIlIIIlIIl, lllllllllllllIIlllIIlIIIlIIIlIII, lllllllllllllIIlllIIlIIIIlllllll, lllllllllllllIIlllIIlIIIIllllllI);
        this.particleRed = 0.4f;
        this.particleGreen = 0.4f;
        this.particleBlue = 0.7f;
        this.setParticleTextureIndex(0);
        this.setSize(0.01f, 0.01f);
        this.particleScale *= this.rand.nextFloat() * 0.6f + 0.2f;
        this.motionX = lllllllllllllIIlllIIlIIIlIIIlIII * 0.0;
        this.motionY = lllllllllllllIIlllIIlIIIIlllllll * 0.0;
        this.motionZ = lllllllllllllIIlllIIlIIIIllllllI * 0.0;
        this.particleMaxAge = (int)(16.0 / (Math.random() * 0.8 + 0.2));
    }
    
    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        if (this.worldObj.getBlockState(new BlockPos(this.posX, this.posY, this.posZ)).getMaterial() != Material.WATER) {
            this.setExpired();
        }
        if (this.particleMaxAge-- <= 0) {
            this.setExpired();
        }
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int lllllllllllllIIlIlIIlIIIlIIlIIIl, final World lllllllllllllIIlIlIIlIIIlIIIlIII, final double lllllllllllllIIlIlIIlIIIlIIIIlll, final double lllllllllllllIIlIlIIlIIIlIIIIllI, final double lllllllllllllIIlIlIIlIIIlIIIllIl, final double lllllllllllllIIlIlIIlIIIlIIIllII, final double lllllllllllllIIlIlIIlIIIlIIIlIll, final double lllllllllllllIIlIlIIlIIIlIIIlIlI, final int... lllllllllllllIIlIlIIlIIIlIIIlIIl) {
            return new ParticleSuspend(lllllllllllllIIlIlIIlIIIlIIIlIII, lllllllllllllIIlIlIIlIIIlIIIIlll, lllllllllllllIIlIlIIlIIIlIIIIllI, lllllllllllllIIlIlIIlIIIlIIIllIl, lllllllllllllIIlIlIIlIIIlIIIllII, lllllllllllllIIlIlIIlIIIlIIIlIll, lllllllllllllIIlIlIIlIIIlIIIlIlI);
        }
    }
}
