package net.minecraft.client.particle;

import net.minecraft.block.state.*;
import net.minecraft.util.math.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;
import net.minecraft.client.*;
import javax.annotation.*;
import net.minecraft.world.*;

public class ParticleDigging extends Particle
{
    private final /* synthetic */ IBlockState sourceState;
    private /* synthetic */ BlockPos sourcePos;
    
    public ParticleDigging init() {
        this.sourcePos = new BlockPos(this.posX, this.posY, this.posZ);
        final Block lllllllllllllIIIlIIlllIIIIIIlIII = this.sourceState.getBlock();
        if (lllllllllllllIIIlIIlllIIIIIIlIII == Blocks.GRASS) {
            return this;
        }
        this.multiplyColor(this.sourcePos);
        return this;
    }
    
    @Override
    public void renderParticle(final BufferBuilder lllllllllllllIIIlIIllIlllllIIlll, final Entity lllllllllllllIIIlIIllIlllllIIllI, final float lllllllllllllIIIlIIllIllllIlIIlI, final float lllllllllllllIIIlIIllIllllIlIIIl, final float lllllllllllllIIIlIIllIllllIlIIII, final float lllllllllllllIIIlIIllIllllIIllll, final float lllllllllllllIIIlIIllIllllIIlllI, final float lllllllllllllIIIlIIllIlllllIIIII) {
        float lllllllllllllIIIlIIllIllllIlllll = (this.particleTextureIndexX + this.particleTextureJitterX / 4.0f) / 16.0f;
        float lllllllllllllIIIlIIllIllllIllllI = lllllllllllllIIIlIIllIllllIlllll + 0.015609375f;
        float lllllllllllllIIIlIIllIllllIlllIl = (this.particleTextureIndexY + this.particleTextureJitterY / 4.0f) / 16.0f;
        float lllllllllllllIIIlIIllIllllIlllII = lllllllllllllIIIlIIllIllllIlllIl + 0.015609375f;
        final float lllllllllllllIIIlIIllIllllIllIll = 0.1f * this.particleScale;
        if (this.particleTexture != null) {
            lllllllllllllIIIlIIllIllllIlllll = this.particleTexture.getInterpolatedU(this.particleTextureJitterX / 4.0f * 16.0f);
            lllllllllllllIIIlIIllIllllIllllI = this.particleTexture.getInterpolatedU((this.particleTextureJitterX + 1.0f) / 4.0f * 16.0f);
            lllllllllllllIIIlIIllIllllIlllIl = this.particleTexture.getInterpolatedV(this.particleTextureJitterY / 4.0f * 16.0f);
            lllllllllllllIIIlIIllIllllIlllII = this.particleTexture.getInterpolatedV((this.particleTextureJitterY + 1.0f) / 4.0f * 16.0f);
        }
        final float lllllllllllllIIIlIIllIllllIllIlI = (float)(this.prevPosX + (this.posX - this.prevPosX) * lllllllllllllIIIlIIllIllllIlIIlI - ParticleDigging.interpPosX);
        final float lllllllllllllIIIlIIllIllllIllIIl = (float)(this.prevPosY + (this.posY - this.prevPosY) * lllllllllllllIIIlIIllIllllIlIIlI - ParticleDigging.interpPosY);
        final float lllllllllllllIIIlIIllIllllIllIII = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * lllllllllllllIIIlIIllIllllIlIIlI - ParticleDigging.interpPosZ);
        final int lllllllllllllIIIlIIllIllllIlIlll = this.getBrightnessForRender(lllllllllllllIIIlIIllIllllIlIIlI);
        final int lllllllllllllIIIlIIllIllllIlIllI = lllllllllllllIIIlIIllIllllIlIlll >> 16 & 0xFFFF;
        final int lllllllllllllIIIlIIllIllllIlIlIl = lllllllllllllIIIlIIllIllllIlIlll & 0xFFFF;
        lllllllllllllIIIlIIllIlllllIIlll.pos(lllllllllllllIIIlIIllIllllIllIlI - lllllllllllllIIIlIIllIllllIlIIIl * lllllllllllllIIIlIIllIllllIllIll - lllllllllllllIIIlIIllIllllIIlllI * lllllllllllllIIIlIIllIllllIllIll, lllllllllllllIIIlIIllIllllIllIIl - lllllllllllllIIIlIIllIllllIlIIII * lllllllllllllIIIlIIllIllllIllIll, lllllllllllllIIIlIIllIllllIllIII - lllllllllllllIIIlIIllIllllIIllll * lllllllllllllIIIlIIllIllllIllIll - lllllllllllllIIIlIIllIlllllIIIII * lllllllllllllIIIlIIllIllllIllIll).tex(lllllllllllllIIIlIIllIllllIlllll, lllllllllllllIIIlIIllIllllIlllII).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).lightmap(lllllllllllllIIIlIIllIllllIlIllI, lllllllllllllIIIlIIllIllllIlIlIl).endVertex();
        lllllllllllllIIIlIIllIlllllIIlll.pos(lllllllllllllIIIlIIllIllllIllIlI - lllllllllllllIIIlIIllIllllIlIIIl * lllllllllllllIIIlIIllIllllIllIll + lllllllllllllIIIlIIllIllllIIlllI * lllllllllllllIIIlIIllIllllIllIll, lllllllllllllIIIlIIllIllllIllIIl + lllllllllllllIIIlIIllIllllIlIIII * lllllllllllllIIIlIIllIllllIllIll, lllllllllllllIIIlIIllIllllIllIII - lllllllllllllIIIlIIllIllllIIllll * lllllllllllllIIIlIIllIllllIllIll + lllllllllllllIIIlIIllIlllllIIIII * lllllllllllllIIIlIIllIllllIllIll).tex(lllllllllllllIIIlIIllIllllIlllll, lllllllllllllIIIlIIllIllllIlllIl).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).lightmap(lllllllllllllIIIlIIllIllllIlIllI, lllllllllllllIIIlIIllIllllIlIlIl).endVertex();
        lllllllllllllIIIlIIllIlllllIIlll.pos(lllllllllllllIIIlIIllIllllIllIlI + lllllllllllllIIIlIIllIllllIlIIIl * lllllllllllllIIIlIIllIllllIllIll + lllllllllllllIIIlIIllIllllIIlllI * lllllllllllllIIIlIIllIllllIllIll, lllllllllllllIIIlIIllIllllIllIIl + lllllllllllllIIIlIIllIllllIlIIII * lllllllllllllIIIlIIllIllllIllIll, lllllllllllllIIIlIIllIllllIllIII + lllllllllllllIIIlIIllIllllIIllll * lllllllllllllIIIlIIllIllllIllIll + lllllllllllllIIIlIIllIlllllIIIII * lllllllllllllIIIlIIllIllllIllIll).tex(lllllllllllllIIIlIIllIllllIllllI, lllllllllllllIIIlIIllIllllIlllIl).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).lightmap(lllllllllllllIIIlIIllIllllIlIllI, lllllllllllllIIIlIIllIllllIlIlIl).endVertex();
        lllllllllllllIIIlIIllIlllllIIlll.pos(lllllllllllllIIIlIIllIllllIllIlI + lllllllllllllIIIlIIllIllllIlIIIl * lllllllllllllIIIlIIllIllllIllIll - lllllllllllllIIIlIIllIllllIIlllI * lllllllllllllIIIlIIllIllllIllIll, lllllllllllllIIIlIIllIllllIllIIl - lllllllllllllIIIlIIllIllllIlIIII * lllllllllllllIIIlIIllIllllIllIll, lllllllllllllIIIlIIllIllllIllIII + lllllllllllllIIIlIIllIllllIIllll * lllllllllllllIIIlIIllIllllIllIll - lllllllllllllIIIlIIllIlllllIIIII * lllllllllllllIIIlIIllIllllIllIll).tex(lllllllllllllIIIlIIllIllllIllllI, lllllllllllllIIIlIIllIllllIlllII).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).lightmap(lllllllllllllIIIlIIllIllllIlIllI, lllllllllllllIIIlIIllIllllIlIlIl).endVertex();
    }
    
    @Override
    public int getBrightnessForRender(final float lllllllllllllIIIlIIllIlllIllllII) {
        final int lllllllllllllIIIlIIllIlllIlllIll = super.getBrightnessForRender(lllllllllllllIIIlIIllIlllIllllII);
        int lllllllllllllIIIlIIllIlllIlllIlI = 0;
        if (this.worldObj.isBlockLoaded(this.sourcePos)) {
            lllllllllllllIIIlIIllIlllIlllIlI = this.worldObj.getCombinedLight(this.sourcePos, 0);
        }
        return (lllllllllllllIIIlIIllIlllIlllIll == 0) ? lllllllllllllIIIlIIllIlllIlllIlI : lllllllllllllIIIlIIllIlllIlllIll;
    }
    
    protected ParticleDigging(final World lllllllllllllIIIlIIlllIIIIIllIIl, final double lllllllllllllIIIlIIlllIIIIlIIIIl, final double lllllllllllllIIIlIIlllIIIIlIIIII, final double lllllllllllllIIIlIIlllIIIIIlllll, final double lllllllllllllIIIlIIlllIIIIIllllI, final double lllllllllllllIIIlIIlllIIIIIlIlII, final double lllllllllllllIIIlIIlllIIIIIlIIll, final IBlockState lllllllllllllIIIlIIlllIIIIIllIll) {
        super(lllllllllllllIIIlIIlllIIIIIllIIl, lllllllllllllIIIlIIlllIIIIlIIIIl, lllllllllllllIIIlIIlllIIIIlIIIII, lllllllllllllIIIlIIlllIIIIIlllll, lllllllllllllIIIlIIlllIIIIIllllI, lllllllllllllIIIlIIlllIIIIIlIlII, lllllllllllllIIIlIIlllIIIIIlIIll);
        this.sourceState = lllllllllllllIIIlIIlllIIIIIllIll;
        this.setParticleTexture(Minecraft.getMinecraft().getBlockRendererDispatcher().getBlockModelShapes().getTexture(lllllllllllllIIIlIIlllIIIIIllIll));
        this.particleGravity = lllllllllllllIIIlIIlllIIIIIllIll.getBlock().blockParticleGravity;
        this.particleRed = 0.6f;
        this.particleGreen = 0.6f;
        this.particleBlue = 0.6f;
        this.particleScale /= 2.0f;
    }
    
    public ParticleDigging setBlockPos(final BlockPos lllllllllllllIIIlIIlllIIIIIIllII) {
        this.sourcePos = lllllllllllllIIIlIIlllIIIIIIllII;
        if (this.sourceState.getBlock() == Blocks.GRASS) {
            return this;
        }
        this.multiplyColor(lllllllllllllIIIlIIlllIIIIIIllII);
        return this;
    }
    
    @Override
    public int getFXLayer() {
        return 1;
    }
    
    protected void multiplyColor(@Nullable final BlockPos lllllllllllllIIIlIIllIlllllllllI) {
        final int lllllllllllllIIIlIIlllIIIIIIIIII = Minecraft.getMinecraft().getBlockColors().colorMultiplier(this.sourceState, this.worldObj, lllllllllllllIIIlIIllIlllllllllI, 0);
        this.particleRed *= (lllllllllllllIIIlIIlllIIIIIIIIII >> 16 & 0xFF) / 255.0f;
        this.particleGreen *= (lllllllllllllIIIlIIlllIIIIIIIIII >> 8 & 0xFF) / 255.0f;
        this.particleBlue *= (lllllllllllllIIIlIIlllIIIIIIIIII & 0xFF) / 255.0f;
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int llllllllllllllIIlllIIIlllllIIIll, final World llllllllllllllIIlllIIIllllIllIlI, final double llllllllllllllIIlllIIIlllllIIIIl, final double llllllllllllllIIlllIIIlllllIIIII, final double llllllllllllllIIlllIIIllllIlllll, final double llllllllllllllIIlllIIIllllIlIllI, final double llllllllllllllIIlllIIIllllIlllIl, final double llllllllllllllIIlllIIIllllIlllII, final int... llllllllllllllIIlllIIIllllIlIIll) {
            return new ParticleDigging(llllllllllllllIIlllIIIllllIllIlI, llllllllllllllIIlllIIIlllllIIIIl, llllllllllllllIIlllIIIlllllIIIII, llllllllllllllIIlllIIIllllIlllll, llllllllllllllIIlllIIIllllIlIllI, llllllllllllllIIlllIIIllllIlllIl, llllllllllllllIIlllIIIllllIlllII, Block.getStateById(llllllllllllllIIlllIIIllllIlIIll[0])).init();
        }
    }
}
