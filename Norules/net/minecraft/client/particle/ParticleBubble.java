package net.minecraft.client.particle;

import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.block.material.*;

public class ParticleBubble extends Particle
{
    protected ParticleBubble(final World llllllllllllllIIIIIIIllIlIIIllll, final double llllllllllllllIIIIIIIllIlIIIlllI, final double llllllllllllllIIIIIIIllIlIIIllIl, final double llllllllllllllIIIIIIIllIlIIIIlII, final double llllllllllllllIIIIIIIllIlIIIlIll, final double llllllllllllllIIIIIIIllIlIIIIIlI, final double llllllllllllllIIIIIIIllIlIIIIIIl) {
        super(llllllllllllllIIIIIIIllIlIIIllll, llllllllllllllIIIIIIIllIlIIIlllI, llllllllllllllIIIIIIIllIlIIIllIl, llllllllllllllIIIIIIIllIlIIIIlII, llllllllllllllIIIIIIIllIlIIIlIll, llllllllllllllIIIIIIIllIlIIIIIlI, llllllllllllllIIIIIIIllIlIIIIIIl);
        this.particleRed = 1.0f;
        this.particleGreen = 1.0f;
        this.particleBlue = 1.0f;
        this.setParticleTextureIndex(32);
        this.setSize(0.02f, 0.02f);
        this.particleScale *= this.rand.nextFloat() * 0.6f + 0.2f;
        this.motionX = llllllllllllllIIIIIIIllIlIIIlIll * 0.20000000298023224 + (Math.random() * 2.0 - 1.0) * 0.019999999552965164;
        this.motionY = llllllllllllllIIIIIIIllIlIIIIIlI * 0.20000000298023224 + (Math.random() * 2.0 - 1.0) * 0.019999999552965164;
        this.motionZ = llllllllllllllIIIIIIIllIlIIIIIIl * 0.20000000298023224 + (Math.random() * 2.0 - 1.0) * 0.019999999552965164;
        this.particleMaxAge = (int)(8.0 / (Math.random() * 0.8 + 0.2));
    }
    
    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.motionY += 0.002;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.8500000238418579;
        this.motionY *= 0.8500000238418579;
        this.motionZ *= 0.8500000238418579;
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
        public Particle createParticle(final int llllllllllllllIllIlllIIIllllIlII, final World llllllllllllllIllIlllIIIllllIIll, final double llllllllllllllIllIlllIIIlllIlIlI, final double llllllllllllllIllIlllIIIllllIIIl, final double llllllllllllllIllIlllIIIlllIlIII, final double llllllllllllllIllIlllIIIlllIIlll, final double llllllllllllllIllIlllIIIlllIIllI, final double llllllllllllllIllIlllIIIlllIllIl, final int... llllllllllllllIllIlllIIIlllIllII) {
            return new ParticleBubble(llllllllllllllIllIlllIIIllllIIll, llllllllllllllIllIlllIIIlllIlIlI, llllllllllllllIllIlllIIIllllIIIl, llllllllllllllIllIlllIIIlllIlIII, llllllllllllllIllIlllIIIlllIIlll, llllllllllllllIllIlllIIIlllIIllI, llllllllllllllIllIlllIIIlllIllIl);
        }
    }
}
