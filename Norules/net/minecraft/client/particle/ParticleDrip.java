package net.minecraft.client.particle;

import net.minecraft.block.material.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.block.*;
import net.minecraft.block.properties.*;
import net.minecraft.util.math.*;
import net.minecraft.block.state.*;

public class ParticleDrip extends Particle
{
    private final /* synthetic */ Material materialType;
    private /* synthetic */ int bobTimer;
    
    @Override
    public int getBrightnessForRender(final float llllllllllllllllIlIlIllIlIIlIIIl) {
        return (this.materialType == Material.WATER) ? super.getBrightnessForRender(llllllllllllllllIlIlIllIlIIlIIIl) : 257;
    }
    
    protected ParticleDrip(final World llllllllllllllllIlIlIllIlIIlllll, final double llllllllllllllllIlIlIllIlIIllllI, final double llllllllllllllllIlIlIllIlIIlIlll, final double llllllllllllllllIlIlIllIlIIlllII, final Material llllllllllllllllIlIlIllIlIIllIll) {
        super(llllllllllllllllIlIlIllIlIIlllll, llllllllllllllllIlIlIllIlIIllllI, llllllllllllllllIlIlIllIlIIlIlll, llllllllllllllllIlIlIllIlIIlllII, 0.0, 0.0, 0.0);
        this.motionX = 0.0;
        this.motionY = 0.0;
        this.motionZ = 0.0;
        if (llllllllllllllllIlIlIllIlIIllIll == Material.WATER) {
            this.particleRed = 0.0f;
            this.particleGreen = 0.0f;
            this.particleBlue = 1.0f;
        }
        else {
            this.particleRed = 1.0f;
            this.particleGreen = 0.0f;
            this.particleBlue = 0.0f;
        }
        this.setParticleTextureIndex(113);
        this.setSize(0.01f, 0.01f);
        this.particleGravity = 0.06f;
        this.materialType = llllllllllllllllIlIlIllIlIIllIll;
        this.bobTimer = 40;
        this.particleMaxAge = (int)(64.0 / (Math.random() * 0.8 + 0.2));
        this.motionX = 0.0;
        this.motionY = 0.0;
        this.motionZ = 0.0;
    }
    
    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.materialType == Material.WATER) {
            this.particleRed = 0.2f;
            this.particleGreen = 0.3f;
            this.particleBlue = 1.0f;
        }
        else {
            this.particleRed = 1.0f;
            this.particleGreen = 16.0f / (40 - this.bobTimer + 16);
            this.particleBlue = 4.0f / (40 - this.bobTimer + 8);
        }
        this.motionY -= this.particleGravity;
        if (this.bobTimer-- > 0) {
            this.motionX *= 0.02;
            this.motionY *= 0.02;
            this.motionZ *= 0.02;
            this.setParticleTextureIndex(113);
        }
        else {
            this.setParticleTextureIndex(112);
        }
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.9800000190734863;
        this.motionY *= 0.9800000190734863;
        this.motionZ *= 0.9800000190734863;
        if (this.particleMaxAge-- <= 0) {
            this.setExpired();
        }
        if (this.isCollided) {
            if (this.materialType == Material.WATER) {
                this.setExpired();
                this.worldObj.spawnParticle(EnumParticleTypes.WATER_SPLASH, this.posX, this.posY, this.posZ, 0.0, 0.0, 0.0, new int[0]);
            }
            else {
                this.setParticleTextureIndex(114);
            }
            this.motionX *= 0.699999988079071;
            this.motionZ *= 0.699999988079071;
        }
        final BlockPos llllllllllllllllIlIlIllIlIIIIlll = new BlockPos(this.posX, this.posY, this.posZ);
        final IBlockState llllllllllllllllIlIlIllIlIIIIllI = this.worldObj.getBlockState(llllllllllllllllIlIlIllIlIIIIlll);
        final Material llllllllllllllllIlIlIllIlIIIIlIl = llllllllllllllllIlIlIllIlIIIIllI.getMaterial();
        if (llllllllllllllllIlIlIllIlIIIIlIl.isLiquid() || llllllllllllllllIlIlIllIlIIIIlIl.isSolid()) {
            double llllllllllllllllIlIlIllIlIIIIlII = 0.0;
            if (llllllllllllllllIlIlIllIlIIIIllI.getBlock() instanceof BlockLiquid) {
                llllllllllllllllIlIlIllIlIIIIlII = BlockLiquid.getLiquidHeightPercent(llllllllllllllllIlIlIllIlIIIIllI.getValue((IProperty<Integer>)BlockLiquid.LEVEL));
            }
            final double llllllllllllllllIlIlIllIlIIIIIll = MathHelper.floor(this.posY) + 1 - llllllllllllllllIlIlIllIlIIIIlII;
            if (this.posY < llllllllllllllllIlIlIllIlIIIIIll) {
                this.setExpired();
            }
        }
    }
    
    public static class WaterFactory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int llllllllllllllIllIIIlIlIllllIlII, final World llllllllllllllIllIIIlIlIlllIlIll, final double llllllllllllllIllIIIlIlIllllIIlI, final double llllllllllllllIllIIIlIlIllllIIIl, final double llllllllllllllIllIIIlIlIllllIIII, final double llllllllllllllIllIIIlIlIlllIllll, final double llllllllllllllIllIIIlIlIlllIlllI, final double llllllllllllllIllIIIlIlIlllIllIl, final int... llllllllllllllIllIIIlIlIlllIllII) {
            return new ParticleDrip(llllllllllllllIllIIIlIlIlllIlIll, llllllllllllllIllIIIlIlIllllIIlI, llllllllllllllIllIIIlIlIllllIIIl, llllllllllllllIllIIIlIlIllllIIII, Material.WATER);
        }
    }
    
    public static class LavaFactory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int lllllllllllllIlIIlIIlIlllIIIIIII, final World lllllllllllllIlIIlIIlIllIlllIlll, final double lllllllllllllIlIIlIIlIllIlllIllI, final double lllllllllllllIlIIlIIlIllIlllIlIl, final double lllllllllllllIlIIlIIlIllIlllllII, final double lllllllllllllIlIIlIIlIllIllllIll, final double lllllllllllllIlIIlIIlIllIllllIlI, final double lllllllllllllIlIIlIIlIllIllllIIl, final int... lllllllllllllIlIIlIIlIllIllllIII) {
            return new ParticleDrip(lllllllllllllIlIIlIIlIllIlllIlll, lllllllllllllIlIIlIIlIllIlllIllI, lllllllllllllIlIIlIIlIllIlllIlIl, lllllllllllllIlIIlIIlIllIlllllII, Material.LAVA);
        }
    }
}
