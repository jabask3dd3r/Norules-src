package net.minecraft.client.particle;

import net.minecraft.util.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.*;

public class ParticleSweepAttack extends Particle
{
    private static final /* synthetic */ ResourceLocation SWEEP_TEXTURE;
    private /* synthetic */ int life;
    private static final /* synthetic */ VertexFormat VERTEX_FORMAT;
    private final /* synthetic */ TextureManager textureManager;
    private final /* synthetic */ int lifeTime;
    private final /* synthetic */ float size;
    
    @Override
    public int getBrightnessForRender(final float lllllIllIllllll) {
        return 61680;
    }
    
    static {
        SWEEP_TEXTURE = new ResourceLocation("textures/entity/sweep.png");
        VERTEX_FORMAT = new VertexFormat().addElement(DefaultVertexFormats.POSITION_3F).addElement(DefaultVertexFormats.TEX_2F).addElement(DefaultVertexFormats.COLOR_4UB).addElement(DefaultVertexFormats.TEX_2S).addElement(DefaultVertexFormats.NORMAL_3B).addElement(DefaultVertexFormats.PADDING_1B);
    }
    
    protected ParticleSweepAttack(final TextureManager lllllIllllllIll, final World lllllIllllllIlI, final double llllllIIIIIIIll, final double llllllIIIIIIIlI, final double llllllIIIIIIIIl, final double llllllIIIIIIIII, final double lllllIlllllllll, final double lllllIllllllllI) {
        super(lllllIllllllIlI, llllllIIIIIIIll, llllllIIIIIIIlI, llllllIIIIIIIIl, 0.0, 0.0, 0.0);
        this.textureManager = lllllIllllllIll;
        this.lifeTime = 4;
        final float lllllIlllllllIl = this.rand.nextFloat() * 0.6f + 0.4f;
        this.particleRed = lllllIlllllllIl;
        this.particleGreen = lllllIlllllllIl;
        this.particleBlue = lllllIlllllllIl;
        this.size = 1.0f - (float)llllllIIIIIIIII * 0.5f;
    }
    
    @Override
    public void renderParticle(final BufferBuilder lllllIllllIIIlI, final Entity lllllIllllIIIIl, final float lllllIllllIIIII, final float lllllIlllIlllll, final float lllllIlllIIllIl, final float lllllIlllIIllII, final float lllllIlllIIlIll, final float lllllIlllIllIll) {
        final int lllllIlllIllIlI = (int)((this.life + lllllIllllIIIII) * 3.0f / this.lifeTime);
        if (lllllIlllIllIlI <= 7) {
            this.textureManager.bindTexture(ParticleSweepAttack.SWEEP_TEXTURE);
            final float lllllIlllIllIIl = lllllIlllIllIlI % 4 / 4.0f;
            final float lllllIlllIllIII = lllllIlllIllIIl + 0.24975f;
            final float lllllIlllIlIlll = lllllIlllIllIlI / 2 / 2.0f;
            final float lllllIlllIlIllI = lllllIlllIlIlll + 0.4995f;
            final float lllllIlllIlIlIl = 1.0f * this.size;
            final float lllllIlllIlIlII = (float)(this.prevPosX + (this.posX - this.prevPosX) * lllllIllllIIIII - ParticleSweepAttack.interpPosX);
            final float lllllIlllIlIIll = (float)(this.prevPosY + (this.posY - this.prevPosY) * lllllIllllIIIII - ParticleSweepAttack.interpPosY);
            final float lllllIlllIlIIlI = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * lllllIllllIIIII - ParticleSweepAttack.interpPosZ);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.disableLighting();
            RenderHelper.disableStandardItemLighting();
            lllllIllllIIIlI.begin(7, ParticleSweepAttack.VERTEX_FORMAT);
            lllllIllllIIIlI.pos(lllllIlllIlIlII - lllllIlllIlllll * lllllIlllIlIlIl - lllllIlllIIlIll * lllllIlllIlIlIl, lllllIlllIlIIll - lllllIlllIIllIl * lllllIlllIlIlIl * 0.5f, lllllIlllIlIIlI - lllllIlllIIllII * lllllIlllIlIlIl - lllllIlllIllIll * lllllIlllIlIlIl).tex(lllllIlllIllIII, lllllIlllIlIllI).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).lightmap(0, 240).normal(0.0f, 1.0f, 0.0f).endVertex();
            lllllIllllIIIlI.pos(lllllIlllIlIlII - lllllIlllIlllll * lllllIlllIlIlIl + lllllIlllIIlIll * lllllIlllIlIlIl, lllllIlllIlIIll + lllllIlllIIllIl * lllllIlllIlIlIl * 0.5f, lllllIlllIlIIlI - lllllIlllIIllII * lllllIlllIlIlIl + lllllIlllIllIll * lllllIlllIlIlIl).tex(lllllIlllIllIII, lllllIlllIlIlll).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).lightmap(0, 240).normal(0.0f, 1.0f, 0.0f).endVertex();
            lllllIllllIIIlI.pos(lllllIlllIlIlII + lllllIlllIlllll * lllllIlllIlIlIl + lllllIlllIIlIll * lllllIlllIlIlIl, lllllIlllIlIIll + lllllIlllIIllIl * lllllIlllIlIlIl * 0.5f, lllllIlllIlIIlI + lllllIlllIIllII * lllllIlllIlIlIl + lllllIlllIllIll * lllllIlllIlIlIl).tex(lllllIlllIllIIl, lllllIlllIlIlll).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).lightmap(0, 240).normal(0.0f, 1.0f, 0.0f).endVertex();
            lllllIllllIIIlI.pos(lllllIlllIlIlII + lllllIlllIlllll * lllllIlllIlIlIl - lllllIlllIIlIll * lllllIlllIlIlIl, lllllIlllIlIIll - lllllIlllIIllIl * lllllIlllIlIlIl * 0.5f, lllllIlllIlIIlI + lllllIlllIIllII * lllllIlllIlIlIl - lllllIlllIllIll * lllllIlllIlIlIl).tex(lllllIlllIllIIl, lllllIlllIlIllI).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).lightmap(0, 240).normal(0.0f, 1.0f, 0.0f).endVertex();
            Tessellator.getInstance().draw();
            GlStateManager.enableLighting();
        }
    }
    
    @Override
    public int getFXLayer() {
        return 3;
    }
    
    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        ++this.life;
        if (this.life == this.lifeTime) {
            this.setExpired();
        }
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int llllllllllllllIlIIIlIlIIllIlIIll, final World llllllllllllllIlIIIlIlIIllIlIIlI, final double llllllllllllllIlIIIlIlIIllIIlIIl, final double llllllllllllllIlIIIlIlIIllIIlIII, final double llllllllllllllIlIIIlIlIIllIIllll, final double llllllllllllllIlIIIlIlIIllIIIllI, final double llllllllllllllIlIIIlIlIIllIIllIl, final double llllllllllllllIlIIIlIlIIllIIIlII, final int... llllllllllllllIlIIIlIlIIllIIlIll) {
            return new ParticleSweepAttack(Minecraft.getMinecraft().getTextureManager(), llllllllllllllIlIIIlIlIIllIlIIlI, llllllllllllllIlIIIlIlIIllIIlIIl, llllllllllllllIlIIIlIlIIllIIlIII, llllllllllllllIlIIIlIlIIllIIllll, llllllllllllllIlIIIlIlIIllIIIllI, llllllllllllllIlIIIlIlIIllIIllIl, llllllllllllllIlIIIlIlIIllIIIlII);
        }
    }
}
