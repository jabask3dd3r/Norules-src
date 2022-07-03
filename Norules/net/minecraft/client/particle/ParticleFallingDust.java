package net.minecraft.client.particle;

import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;
import net.minecraft.init.*;
import net.minecraft.util.*;
import net.minecraft.client.*;
import net.minecraft.util.math.*;
import net.minecraft.block.*;
import net.minecraft.block.state.*;
import javax.annotation.*;

public class ParticleFallingDust extends Particle
{
    final /* synthetic */ float rotSpeed;
    /* synthetic */ float oSize;
    
    @Override
    public void renderParticle(final BufferBuilder lllllllllllllIIlllIIlIlllIIIIIlI, final Entity lllllllllllllIIlllIIlIlllIIIIIIl, final float lllllllllllllIIlllIIlIllIlllIllI, final float lllllllllllllIIlllIIlIllIlllIlIl, final float lllllllllllllIIlllIIlIllIlllIlII, final float lllllllllllllIIlllIIlIllIlllIIll, final float lllllllllllllIIlllIIlIllIlllllII, final float lllllllllllllIIlllIIlIllIlllIIIl) {
        float lllllllllllllIIlllIIlIllIllllIlI = (this.particleAge + lllllllllllllIIlllIIlIllIlllIllI) / this.particleMaxAge * 32.0f;
        lllllllllllllIIlllIIlIllIllllIlI = MathHelper.clamp(lllllllllllllIIlllIIlIllIllllIlI, 0.0f, 1.0f);
        this.particleScale = this.oSize * lllllllllllllIIlllIIlIllIllllIlI;
        super.renderParticle(lllllllllllllIIlllIIlIlllIIIIIlI, lllllllllllllIIlllIIlIlllIIIIIIl, lllllllllllllIIlllIIlIllIlllIllI, lllllllllllllIIlllIIlIllIlllIlIl, lllllllllllllIIlllIIlIllIlllIlII, lllllllllllllIIlllIIlIllIlllIIll, lllllllllllllIIlllIIlIllIlllllII, lllllllllllllIIlllIIlIllIlllIIIl);
    }
    
    protected ParticleFallingDust(final World lllllllllllllIIlllIIlIlllIIllllI, final double lllllllllllllIIlllIIlIlllIIlllIl, final double lllllllllllllIIlllIIlIlllIIlIIll, final double lllllllllllllIIlllIIlIlllIIllIll, final float lllllllllllllIIlllIIlIlllIIllIlI, final float lllllllllllllIIlllIIlIlllIIlIIII, final float lllllllllllllIIlllIIlIlllIIIllll) {
        super(lllllllllllllIIlllIIlIlllIIllllI, lllllllllllllIIlllIIlIlllIIlllIl, lllllllllllllIIlllIIlIlllIIlIIll, lllllllllllllIIlllIIlIlllIIllIll, 0.0, 0.0, 0.0);
        this.motionX = 0.0;
        this.motionY = 0.0;
        this.motionZ = 0.0;
        this.particleRed = lllllllllllllIIlllIIlIlllIIllIlI;
        this.particleGreen = lllllllllllllIIlllIIlIlllIIlIIII;
        this.particleBlue = lllllllllllllIIlllIIlIlllIIIllll;
        final float lllllllllllllIIlllIIlIlllIIlIlll = 0.9f;
        this.particleScale *= 0.75f;
        this.particleScale *= 0.9f;
        this.oSize = this.particleScale;
        this.particleMaxAge = (int)(32.0 / (Math.random() * 0.8 + 0.2));
        this.particleMaxAge *= (int)0.9f;
        this.rotSpeed = ((float)Math.random() - 0.5f) * 0.1f;
        this.particleAngle = (float)Math.random() * 6.2831855f;
    }
    
    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.particleAge++ >= this.particleMaxAge) {
            this.setExpired();
        }
        this.prevParticleAngle = this.particleAngle;
        this.particleAngle += 3.1415927f * this.rotSpeed * 2.0f;
        if (this.isCollided) {
            final float n = 0.0f;
            this.particleAngle = n;
            this.prevParticleAngle = n;
        }
        this.setParticleTextureIndex(7 - this.particleAge * 8 / this.particleMaxAge);
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionY -= 0.003000000026077032;
        this.motionY = Math.max(this.motionY, -0.14000000059604645);
    }
    
    public static class Factory implements IParticleFactory
    {
        @Nullable
        @Override
        public Particle createParticle(final int llllllllllllllllllIlIIlllIIIlIII, final World llllllllllllllllllIlIIllIllllIII, final double llllllllllllllllllIlIIllIlllIllI, final double llllllllllllllllllIlIIlllIIIIlIl, final double llllllllllllllllllIlIIlllIIIIlII, final double llllllllllllllllllIlIIlllIIIIIll, final double llllllllllllllllllIlIIlllIIIIIlI, final double llllllllllllllllllIlIIlllIIIIIIl, final int... llllllllllllllllllIlIIllIlllIIIl) {
            final IBlockState llllllllllllllllllIlIIllIlllllll = Block.getStateById(llllllllllllllllllIlIIllIlllIIIl[0]);
            if (llllllllllllllllllIlIIllIlllllll.getBlock() != Blocks.AIR && llllllllllllllllllIlIIllIlllllll.getRenderType() == EnumBlockRenderType.INVISIBLE) {
                return null;
            }
            int llllllllllllllllllIlIIllIllllllI = Minecraft.getMinecraft().getBlockColors().getColor(llllllllllllllllllIlIIllIlllllll, llllllllllllllllllIlIIllIllllIII, new BlockPos(llllllllllllllllllIlIIllIlllIllI, llllllllllllllllllIlIIlllIIIIlIl, llllllllllllllllllIlIIlllIIIIlII));
            if (llllllllllllllllllIlIIllIlllllll.getBlock() instanceof BlockFalling) {
                llllllllllllllllllIlIIllIllllllI = ((BlockFalling)llllllllllllllllllIlIIllIlllllll.getBlock()).getDustColor(llllllllllllllllllIlIIllIlllllll);
            }
            final float llllllllllllllllllIlIIllIlllllIl = (llllllllllllllllllIlIIllIllllllI >> 16 & 0xFF) / 255.0f;
            final float llllllllllllllllllIlIIllIlllllII = (llllllllllllllllllIlIIllIllllllI >> 8 & 0xFF) / 255.0f;
            final float llllllllllllllllllIlIIllIllllIll = (llllllllllllllllllIlIIllIllllllI & 0xFF) / 255.0f;
            return new ParticleFallingDust(llllllllllllllllllIlIIllIllllIII, llllllllllllllllllIlIIllIlllIllI, llllllllllllllllllIlIIlllIIIIlIl, llllllllllllllllllIlIIlllIIIIlII, llllllllllllllllllIlIIllIlllllIl, llllllllllllllllllIlIIllIlllllII, llllllllllllllllllIlIIllIllllIll);
        }
    }
}
