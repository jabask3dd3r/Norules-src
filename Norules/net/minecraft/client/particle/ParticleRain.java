package net.minecraft.client.particle;

import net.minecraft.block.*;
import net.minecraft.block.properties.*;
import net.minecraft.util.math.*;
import net.minecraft.block.state.*;
import net.minecraft.block.material.*;
import net.minecraft.world.*;

public class ParticleRain extends Particle
{
    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.motionY -= this.particleGravity;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.9800000190734863;
        this.motionY *= 0.9800000190734863;
        this.motionZ *= 0.9800000190734863;
        if (this.particleMaxAge-- <= 0) {
            this.setExpired();
        }
        if (this.isCollided) {
            if (Math.random() < 0.5) {
                this.setExpired();
            }
            this.motionX *= 0.699999988079071;
            this.motionZ *= 0.699999988079071;
        }
        final BlockPos lllllllllllllllllllllIIlIIIlIlIl = new BlockPos(this.posX, this.posY, this.posZ);
        final IBlockState lllllllllllllllllllllIIlIIIlIlII = this.worldObj.getBlockState(lllllllllllllllllllllIIlIIIlIlIl);
        final Material lllllllllllllllllllllIIlIIIlIIll = lllllllllllllllllllllIIlIIIlIlII.getMaterial();
        if (lllllllllllllllllllllIIlIIIlIIll.isLiquid() || lllllllllllllllllllllIIlIIIlIIll.isSolid()) {
            double lllllllllllllllllllllIIlIIIlIIIl = 0.0;
            if (lllllllllllllllllllllIIlIIIlIlII.getBlock() instanceof BlockLiquid) {
                final double lllllllllllllllllllllIIlIIIlIIlI = 1.0f - BlockLiquid.getLiquidHeightPercent(lllllllllllllllllllllIIlIIIlIlII.getValue((IProperty<Integer>)BlockLiquid.LEVEL));
            }
            else {
                lllllllllllllllllllllIIlIIIlIIIl = lllllllllllllllllllllIIlIIIlIlII.getBoundingBox(this.worldObj, lllllllllllllllllllllIIlIIIlIlIl).maxY;
            }
            final double lllllllllllllllllllllIIlIIIlIIII = MathHelper.floor(this.posY) + lllllllllllllllllllllIIlIIIlIIIl;
            if (this.posY < lllllllllllllllllllllIIlIIIlIIII) {
                this.setExpired();
            }
        }
    }
    
    protected ParticleRain(final World lllllllllllllllllllllIIlIIlIIIII, final double lllllllllllllllllllllIIlIIlIIlII, final double lllllllllllllllllllllIIlIIlIIIll, final double lllllllllllllllllllllIIlIIIlllIl) {
        super(lllllllllllllllllllllIIlIIlIIIII, lllllllllllllllllllllIIlIIlIIlII, lllllllllllllllllllllIIlIIlIIIll, lllllllllllllllllllllIIlIIIlllIl, 0.0, 0.0, 0.0);
        this.motionX *= 0.30000001192092896;
        this.motionY = Math.random() * 0.20000000298023224 + 0.10000000149011612;
        this.motionZ *= 0.30000001192092896;
        this.particleRed = 1.0f;
        this.particleGreen = 1.0f;
        this.particleBlue = 1.0f;
        this.setParticleTextureIndex(19 + this.rand.nextInt(4));
        this.setSize(0.01f, 0.01f);
        this.particleGravity = 0.06f;
        this.particleMaxAge = (int)(8.0 / (Math.random() * 0.8 + 0.2));
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int llllllllllllIlllllllllIIIIlllIIl, final World llllllllllllIlllllllllIIIIllIIII, final double llllllllllllIlllllllllIIIIllIlll, final double llllllllllllIlllllllllIIIIlIlllI, final double llllllllllllIlllllllllIIIIlIllIl, final double llllllllllllIlllllllllIIIIllIlII, final double llllllllllllIlllllllllIIIIllIIll, final double llllllllllllIlllllllllIIIIllIIlI, final int... llllllllllllIlllllllllIIIIllIIIl) {
            return new ParticleRain(llllllllllllIlllllllllIIIIllIIII, llllllllllllIlllllllllIIIIllIlll, llllllllllllIlllllllllIIIIlIlllI, llllllllllllIlllllllllIIIIlIllIl);
        }
    }
}
