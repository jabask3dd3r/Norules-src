package net.minecraft.client.particle;

import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;
import net.minecraft.item.*;
import net.minecraft.client.*;
import net.minecraft.init.*;

public class Barrier extends Particle
{
    @Override
    public void renderParticle(final BufferBuilder lllllllllllllIIlIllIIIIllllIllII, final Entity lllllllllllllIIlIllIIIIllllIlIll, final float lllllllllllllIIlIllIIIIllllIlIlI, final float lllllllllllllIIlIllIIIIllllIlIIl, final float lllllllllllllIIlIllIIIIllllIlIII, final float lllllllllllllIIlIllIIIIlllIlIlII, final float lllllllllllllIIlIllIIIIlllIlIIll, final float lllllllllllllIIlIllIIIIlllIlIIlI) {
        final float lllllllllllllIIlIllIIIIllllIIlII = this.particleTexture.getMinU();
        final float lllllllllllllIIlIllIIIIllllIIIll = this.particleTexture.getMaxU();
        final float lllllllllllllIIlIllIIIIllllIIIlI = this.particleTexture.getMinV();
        final float lllllllllllllIIlIllIIIIllllIIIIl = this.particleTexture.getMaxV();
        final float lllllllllllllIIlIllIIIIllllIIIII = 0.5f;
        final float lllllllllllllIIlIllIIIIlllIlllll = (float)(this.prevPosX + (this.posX - this.prevPosX) * lllllllllllllIIlIllIIIIllllIlIlI - Barrier.interpPosX);
        final float lllllllllllllIIlIllIIIIlllIllllI = (float)(this.prevPosY + (this.posY - this.prevPosY) * lllllllllllllIIlIllIIIIllllIlIlI - Barrier.interpPosY);
        final float lllllllllllllIIlIllIIIIlllIlllIl = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * lllllllllllllIIlIllIIIIllllIlIlI - Barrier.interpPosZ);
        final int lllllllllllllIIlIllIIIIlllIlllII = this.getBrightnessForRender(lllllllllllllIIlIllIIIIllllIlIlI);
        final int lllllllllllllIIlIllIIIIlllIllIll = lllllllllllllIIlIllIIIIlllIlllII >> 16 & 0xFFFF;
        final int lllllllllllllIIlIllIIIIlllIllIlI = lllllllllllllIIlIllIIIIlllIlllII & 0xFFFF;
        lllllllllllllIIlIllIIIIllllIllII.pos(lllllllllllllIIlIllIIIIlllIlllll - lllllllllllllIIlIllIIIIllllIlIIl * 0.5f - lllllllllllllIIlIllIIIIlllIlIIll * 0.5f, lllllllllllllIIlIllIIIIlllIllllI - lllllllllllllIIlIllIIIIllllIlIII * 0.5f, lllllllllllllIIlIllIIIIlllIlllIl - lllllllllllllIIlIllIIIIlllIlIlII * 0.5f - lllllllllllllIIlIllIIIIlllIlIIlI * 0.5f).tex(lllllllllllllIIlIllIIIIllllIIIll, lllllllllllllIIlIllIIIIllllIIIIl).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).lightmap(lllllllllllllIIlIllIIIIlllIllIll, lllllllllllllIIlIllIIIIlllIllIlI).endVertex();
        lllllllllllllIIlIllIIIIllllIllII.pos(lllllllllllllIIlIllIIIIlllIlllll - lllllllllllllIIlIllIIIIllllIlIIl * 0.5f + lllllllllllllIIlIllIIIIlllIlIIll * 0.5f, lllllllllllllIIlIllIIIIlllIllllI + lllllllllllllIIlIllIIIIllllIlIII * 0.5f, lllllllllllllIIlIllIIIIlllIlllIl - lllllllllllllIIlIllIIIIlllIlIlII * 0.5f + lllllllllllllIIlIllIIIIlllIlIIlI * 0.5f).tex(lllllllllllllIIlIllIIIIllllIIIll, lllllllllllllIIlIllIIIIllllIIIlI).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).lightmap(lllllllllllllIIlIllIIIIlllIllIll, lllllllllllllIIlIllIIIIlllIllIlI).endVertex();
        lllllllllllllIIlIllIIIIllllIllII.pos(lllllllllllllIIlIllIIIIlllIlllll + lllllllllllllIIlIllIIIIllllIlIIl * 0.5f + lllllllllllllIIlIllIIIIlllIlIIll * 0.5f, lllllllllllllIIlIllIIIIlllIllllI + lllllllllllllIIlIllIIIIllllIlIII * 0.5f, lllllllllllllIIlIllIIIIlllIlllIl + lllllllllllllIIlIllIIIIlllIlIlII * 0.5f + lllllllllllllIIlIllIIIIlllIlIIlI * 0.5f).tex(lllllllllllllIIlIllIIIIllllIIlII, lllllllllllllIIlIllIIIIllllIIIlI).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).lightmap(lllllllllllllIIlIllIIIIlllIllIll, lllllllllllllIIlIllIIIIlllIllIlI).endVertex();
        lllllllllllllIIlIllIIIIllllIllII.pos(lllllllllllllIIlIllIIIIlllIlllll + lllllllllllllIIlIllIIIIllllIlIIl * 0.5f - lllllllllllllIIlIllIIIIlllIlIIll * 0.5f, lllllllllllllIIlIllIIIIlllIllllI - lllllllllllllIIlIllIIIIllllIlIII * 0.5f, lllllllllllllIIlIllIIIIlllIlllIl + lllllllllllllIIlIllIIIIlllIlIlII * 0.5f - lllllllllllllIIlIllIIIIlllIlIIlI * 0.5f).tex(lllllllllllllIIlIllIIIIllllIIlII, lllllllllllllIIlIllIIIIllllIIIIl).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).lightmap(lllllllllllllIIlIllIIIIlllIllIll, lllllllllllllIIlIllIIIIlllIllIlI).endVertex();
    }
    
    @Override
    public int getFXLayer() {
        return 1;
    }
    
    protected Barrier(final World lllllllllllllIIlIllIIIlIIIIIllII, final double lllllllllllllIIlIllIIIlIIIIIIlIl, final double lllllllllllllIIlIllIIIlIIIIIlIlI, final double lllllllllllllIIlIllIIIlIIIIIlIIl, final Item lllllllllllllIIlIllIIIlIIIIIIIlI) {
        super(lllllllllllllIIlIllIIIlIIIIIllII, lllllllllllllIIlIllIIIlIIIIIIlIl, lllllllllllllIIlIllIIIlIIIIIlIlI, lllllllllllllIIlIllIIIlIIIIIlIIl, 0.0, 0.0, 0.0);
        this.setParticleTexture(Minecraft.getMinecraft().getRenderItem().getItemModelMesher().getParticleIcon(lllllllllllllIIlIllIIIlIIIIIIIlI));
        this.particleRed = 1.0f;
        this.particleGreen = 1.0f;
        this.particleBlue = 1.0f;
        this.motionX = 0.0;
        this.motionY = 0.0;
        this.motionZ = 0.0;
        this.particleGravity = 0.0f;
        this.particleMaxAge = 80;
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int lllllllllllllIlIIIlIllIIlllIIIlI, final World lllllllllllllIlIIIlIllIIlllIIIIl, final double lllllllllllllIlIIIlIllIIlllIIIII, final double lllllllllllllIlIIIlIllIIllIlllll, final double lllllllllllllIlIIIlIllIIllIlIllI, final double lllllllllllllIlIIIlIllIIllIlllIl, final double lllllllllllllIlIIIlIllIIllIlllII, final double lllllllllllllIlIIIlIllIIllIllIll, final int... lllllllllllllIlIIIlIllIIllIllIlI) {
            return new Barrier(lllllllllllllIlIIIlIllIIlllIIIIl, lllllllllllllIlIIIlIllIIlllIIIII, lllllllllllllIlIIIlIllIIllIlllll, lllllllllllllIlIIIlIllIIllIlIllI, Item.getItemFromBlock(Blocks.BARRIER));
        }
    }
}
