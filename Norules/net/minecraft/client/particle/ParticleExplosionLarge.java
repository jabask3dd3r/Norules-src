package net.minecraft.client.particle;

import net.minecraft.client.renderer.texture.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.entity.*;
import net.minecraft.client.renderer.*;
import net.minecraft.world.*;
import net.minecraft.client.*;

public class ParticleExplosionLarge extends Particle
{
    private /* synthetic */ int life;
    private final /* synthetic */ TextureManager theRenderEngine;
    private static final /* synthetic */ VertexFormat VERTEX_FORMAT;
    private static final /* synthetic */ ResourceLocation EXPLOSION_TEXTURE;
    private final /* synthetic */ float size;
    private final /* synthetic */ int lifeTime;
    
    @Override
    public int getBrightnessForRender(final float llllllllllllIlllllIlIIlIlIllIlll) {
        return 61680;
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
    
    static {
        EXPLOSION_TEXTURE = new ResourceLocation("textures/entity/explosion.png");
        VERTEX_FORMAT = new VertexFormat().addElement(DefaultVertexFormats.POSITION_3F).addElement(DefaultVertexFormats.TEX_2F).addElement(DefaultVertexFormats.COLOR_4UB).addElement(DefaultVertexFormats.TEX_2S).addElement(DefaultVertexFormats.NORMAL_3B).addElement(DefaultVertexFormats.PADDING_1B);
    }
    
    @Override
    public void renderParticle(final BufferBuilder llllllllllllIlllllIlIIlIllIllIlI, final Entity llllllllllllIlllllIlIIlIllIllIIl, final float llllllllllllIlllllIlIIlIllIllIII, final float llllllllllllIlllllIlIIlIllIIIllI, final float llllllllllllIlllllIlIIlIllIlIllI, final float llllllllllllIlllllIlIIlIllIlIlIl, final float llllllllllllIlllllIlIIlIllIlIlII, final float llllllllllllIlllllIlIIlIllIlIIll) {
        final int llllllllllllIlllllIlIIlIllIlIIlI = (int)((this.life + llllllllllllIlllllIlIIlIllIllIII) * 15.0f / this.lifeTime);
        if (llllllllllllIlllllIlIIlIllIlIIlI <= 15) {
            this.theRenderEngine.bindTexture(ParticleExplosionLarge.EXPLOSION_TEXTURE);
            final float llllllllllllIlllllIlIIlIllIlIIIl = llllllllllllIlllllIlIIlIllIlIIlI % 4 / 4.0f;
            final float llllllllllllIlllllIlIIlIllIlIIII = llllllllllllIlllllIlIIlIllIlIIIl + 0.24975f;
            final float llllllllllllIlllllIlIIlIllIIllll = llllllllllllIlllllIlIIlIllIlIIlI / 4 / 4.0f;
            final float llllllllllllIlllllIlIIlIllIIlllI = llllllllllllIlllllIlIIlIllIIllll + 0.24975f;
            final float llllllllllllIlllllIlIIlIllIIllIl = 2.0f * this.size;
            final float llllllllllllIlllllIlIIlIllIIllII = (float)(this.prevPosX + (this.posX - this.prevPosX) * llllllllllllIlllllIlIIlIllIllIII - ParticleExplosionLarge.interpPosX);
            final float llllllllllllIlllllIlIIlIllIIlIll = (float)(this.prevPosY + (this.posY - this.prevPosY) * llllllllllllIlllllIlIIlIllIllIII - ParticleExplosionLarge.interpPosY);
            final float llllllllllllIlllllIlIIlIllIIlIlI = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * llllllllllllIlllllIlIIlIllIllIII - ParticleExplosionLarge.interpPosZ);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.disableLighting();
            RenderHelper.disableStandardItemLighting();
            llllllllllllIlllllIlIIlIllIllIlI.begin(7, ParticleExplosionLarge.VERTEX_FORMAT);
            llllllllllllIlllllIlIIlIllIllIlI.pos(llllllllllllIlllllIlIIlIllIIllII - llllllllllllIlllllIlIIlIllIIIllI * llllllllllllIlllllIlIIlIllIIllIl - llllllllllllIlllllIlIIlIllIlIlII * llllllllllllIlllllIlIIlIllIIllIl, llllllllllllIlllllIlIIlIllIIlIll - llllllllllllIlllllIlIIlIllIlIllI * llllllllllllIlllllIlIIlIllIIllIl, llllllllllllIlllllIlIIlIllIIlIlI - llllllllllllIlllllIlIIlIllIlIlIl * llllllllllllIlllllIlIIlIllIIllIl - llllllllllllIlllllIlIIlIllIlIIll * llllllllllllIlllllIlIIlIllIIllIl).tex(llllllllllllIlllllIlIIlIllIlIIII, llllllllllllIlllllIlIIlIllIIlllI).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).lightmap(0, 240).normal(0.0f, 1.0f, 0.0f).endVertex();
            llllllllllllIlllllIlIIlIllIllIlI.pos(llllllllllllIlllllIlIIlIllIIllII - llllllllllllIlllllIlIIlIllIIIllI * llllllllllllIlllllIlIIlIllIIllIl + llllllllllllIlllllIlIIlIllIlIlII * llllllllllllIlllllIlIIlIllIIllIl, llllllllllllIlllllIlIIlIllIIlIll + llllllllllllIlllllIlIIlIllIlIllI * llllllllllllIlllllIlIIlIllIIllIl, llllllllllllIlllllIlIIlIllIIlIlI - llllllllllllIlllllIlIIlIllIlIlIl * llllllllllllIlllllIlIIlIllIIllIl + llllllllllllIlllllIlIIlIllIlIIll * llllllllllllIlllllIlIIlIllIIllIl).tex(llllllllllllIlllllIlIIlIllIlIIII, llllllllllllIlllllIlIIlIllIIllll).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).lightmap(0, 240).normal(0.0f, 1.0f, 0.0f).endVertex();
            llllllllllllIlllllIlIIlIllIllIlI.pos(llllllllllllIlllllIlIIlIllIIllII + llllllllllllIlllllIlIIlIllIIIllI * llllllllllllIlllllIlIIlIllIIllIl + llllllllllllIlllllIlIIlIllIlIlII * llllllllllllIlllllIlIIlIllIIllIl, llllllllllllIlllllIlIIlIllIIlIll + llllllllllllIlllllIlIIlIllIlIllI * llllllllllllIlllllIlIIlIllIIllIl, llllllllllllIlllllIlIIlIllIIlIlI + llllllllllllIlllllIlIIlIllIlIlIl * llllllllllllIlllllIlIIlIllIIllIl + llllllllllllIlllllIlIIlIllIlIIll * llllllllllllIlllllIlIIlIllIIllIl).tex(llllllllllllIlllllIlIIlIllIlIIIl, llllllllllllIlllllIlIIlIllIIllll).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).lightmap(0, 240).normal(0.0f, 1.0f, 0.0f).endVertex();
            llllllllllllIlllllIlIIlIllIllIlI.pos(llllllllllllIlllllIlIIlIllIIllII + llllllllllllIlllllIlIIlIllIIIllI * llllllllllllIlllllIlIIlIllIIllIl - llllllllllllIlllllIlIIlIllIlIlII * llllllllllllIlllllIlIIlIllIIllIl, llllllllllllIlllllIlIIlIllIIlIll - llllllllllllIlllllIlIIlIllIlIllI * llllllllllllIlllllIlIIlIllIIllIl, llllllllllllIlllllIlIIlIllIIlIlI + llllllllllllIlllllIlIIlIllIlIlIl * llllllllllllIlllllIlIIlIllIIllIl - llllllllllllIlllllIlIIlIllIlIIll * llllllllllllIlllllIlIIlIllIIllIl).tex(llllllllllllIlllllIlIIlIllIlIIIl, llllllllllllIlllllIlIIlIllIIlllI).color(this.particleRed, this.particleGreen, this.particleBlue, 1.0f).lightmap(0, 240).normal(0.0f, 1.0f, 0.0f).endVertex();
            Tessellator.getInstance().draw();
            GlStateManager.enableLighting();
        }
    }
    
    @Override
    public int getFXLayer() {
        return 3;
    }
    
    protected ParticleExplosionLarge(final TextureManager llllllllllllIlllllIlIIlIllllllIl, final World llllllllllllIlllllIlIIlIllllIIlI, final double llllllllllllIlllllIlIIlIllllIIIl, final double llllllllllllIlllllIlIIlIlllllIlI, final double llllllllllllIlllllIlIIlIlllIllll, final double llllllllllllIlllllIlIIlIlllllIII, final double llllllllllllIlllllIlIIlIllllIlll, final double llllllllllllIlllllIlIIlIllllIllI) {
        super(llllllllllllIlllllIlIIlIllllIIlI, llllllllllllIlllllIlIIlIllllIIIl, llllllllllllIlllllIlIIlIlllllIlI, llllllllllllIlllllIlIIlIlllIllll, 0.0, 0.0, 0.0);
        this.theRenderEngine = llllllllllllIlllllIlIIlIllllllIl;
        this.lifeTime = 6 + this.rand.nextInt(4);
        final float llllllllllllIlllllIlIIlIllllIlIl = this.rand.nextFloat() * 0.6f + 0.4f;
        this.particleRed = llllllllllllIlllllIlIIlIllllIlIl;
        this.particleGreen = llllllllllllIlllllIlIIlIllllIlIl;
        this.particleBlue = llllllllllllIlllllIlIIlIllllIlIl;
        this.size = 1.0f - (float)llllllllllllIlllllIlIIlIlllllIII * 0.5f;
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int lllllllllllllllIllIlIlIlIIIlIIII, final World lllllllllllllllIllIlIlIlIIIIllll, final double lllllllllllllllIllIlIlIlIIIIIllI, final double lllllllllllllllIllIlIlIlIIIIIlIl, final double lllllllllllllllIllIlIlIlIIIIllII, final double lllllllllllllllIllIlIlIlIIIIlIll, final double lllllllllllllllIllIlIlIlIIIIlIlI, final double lllllllllllllllIllIlIlIlIIIIlIIl, final int... lllllllllllllllIllIlIlIlIIIIlIII) {
            return new ParticleExplosionLarge(Minecraft.getMinecraft().getTextureManager(), lllllllllllllllIllIlIlIlIIIIllll, lllllllllllllllIllIlIlIlIIIIIllI, lllllllllllllllIllIlIlIlIIIIIlIl, lllllllllllllllIllIlIlIlIIIIllII, lllllllllllllllIllIlIlIlIIIIlIll, lllllllllllllllIllIlIlIlIIIIlIlI, lllllllllllllllIllIlIlIlIIIIlIIl);
        }
    }
}
