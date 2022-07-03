package net.minecraft.client.particle;

import net.minecraft.util.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.*;

public class ParticleFootStep extends Particle
{
    private /* synthetic */ int footstepAge;
    private final /* synthetic */ int footstepMaxAge;
    private static final /* synthetic */ ResourceLocation FOOTPRINT_TEXTURE;
    private final /* synthetic */ TextureManager currentFootSteps;
    
    static {
        FOOTPRINT_TEXTURE = new ResourceLocation("textures/particle/footprint.png");
    }
    
    @Override
    public void onUpdate() {
        ++this.footstepAge;
        if (this.footstepAge == this.footstepMaxAge) {
            this.setExpired();
        }
    }
    
    protected ParticleFootStep(final TextureManager lllllllllllllIIIlIlIIllIIIllIIll, final World lllllllllllllIIIlIlIIllIIIllIIlI, final double lllllllllllllIIIlIlIIllIIIllIIIl, final double lllllllllllllIIIlIlIIllIIIllIIII, final double lllllllllllllIIIlIlIIllIIIllIlIl) {
        super(lllllllllllllIIIlIlIIllIIIllIIlI, lllllllllllllIIIlIlIIllIIIllIIIl, lllllllllllllIIIlIlIIllIIIllIIII, lllllllllllllIIIlIlIIllIIIllIlIl, 0.0, 0.0, 0.0);
        this.currentFootSteps = lllllllllllllIIIlIlIIllIIIllIIll;
        this.motionX = 0.0;
        this.motionY = 0.0;
        this.motionZ = 0.0;
        this.footstepMaxAge = 200;
    }
    
    @Override
    public int getFXLayer() {
        return 3;
    }
    
    @Override
    public void renderParticle(final BufferBuilder lllllllllllllIIIlIlIIllIIIlIIIll, final Entity lllllllllllllIIIlIlIIllIIIlIIIlI, final float lllllllllllllIIIlIlIIllIIIlIIIIl, final float lllllllllllllIIIlIlIIllIIIlIIIII, final float lllllllllllllIIIlIlIIllIIIIlllll, final float lllllllllllllIIIlIlIIllIIIIllllI, final float lllllllllllllIIIlIlIIllIIIIlllIl, final float lllllllllllllIIIlIlIIllIIIIlllII) {
        float lllllllllllllIIIlIlIIllIIIIllIll = (this.footstepAge + lllllllllllllIIIlIlIIllIIIlIIIIl) / this.footstepMaxAge;
        lllllllllllllIIIlIlIIllIIIIllIll *= lllllllllllllIIIlIlIIllIIIIllIll;
        float lllllllllllllIIIlIlIIllIIIIllIlI = 2.0f - lllllllllllllIIIlIlIIllIIIIllIll * 2.0f;
        if (lllllllllllllIIIlIlIIllIIIIllIlI > 1.0f) {
            lllllllllllllIIIlIlIIllIIIIllIlI = 1.0f;
        }
        lllllllllllllIIIlIlIIllIIIIllIlI *= 0.2f;
        GlStateManager.disableLighting();
        final float lllllllllllllIIIlIlIIllIIIIllIIl = 0.125f;
        final float lllllllllllllIIIlIlIIllIIIIllIII = (float)(this.posX - ParticleFootStep.interpPosX);
        final float lllllllllllllIIIlIlIIllIIIIlIlll = (float)(this.posY - ParticleFootStep.interpPosY);
        final float lllllllllllllIIIlIlIIllIIIIlIllI = (float)(this.posZ - ParticleFootStep.interpPosZ);
        final float lllllllllllllIIIlIlIIllIIIIlIlIl = this.worldObj.getLightBrightness(new BlockPos(this.posX, this.posY, this.posZ));
        this.currentFootSteps.bindTexture(ParticleFootStep.FOOTPRINT_TEXTURE);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        lllllllllllllIIIlIlIIllIIIlIIIll.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
        lllllllllllllIIIlIlIIllIIIlIIIll.pos(lllllllllllllIIIlIlIIllIIIIllIII - 0.125f, lllllllllllllIIIlIlIIllIIIIlIlll, lllllllllllllIIIlIlIIllIIIIlIllI + 0.125f).tex(0.0, 1.0).color(lllllllllllllIIIlIlIIllIIIIlIlIl, lllllllllllllIIIlIlIIllIIIIlIlIl, lllllllllllllIIIlIlIIllIIIIlIlIl, lllllllllllllIIIlIlIIllIIIIllIlI).endVertex();
        lllllllllllllIIIlIlIIllIIIlIIIll.pos(lllllllllllllIIIlIlIIllIIIIllIII + 0.125f, lllllllllllllIIIlIlIIllIIIIlIlll, lllllllllllllIIIlIlIIllIIIIlIllI + 0.125f).tex(1.0, 1.0).color(lllllllllllllIIIlIlIIllIIIIlIlIl, lllllllllllllIIIlIlIIllIIIIlIlIl, lllllllllllllIIIlIlIIllIIIIlIlIl, lllllllllllllIIIlIlIIllIIIIllIlI).endVertex();
        lllllllllllllIIIlIlIIllIIIlIIIll.pos(lllllllllllllIIIlIlIIllIIIIllIII + 0.125f, lllllllllllllIIIlIlIIllIIIIlIlll, lllllllllllllIIIlIlIIllIIIIlIllI - 0.125f).tex(1.0, 0.0).color(lllllllllllllIIIlIlIIllIIIIlIlIl, lllllllllllllIIIlIlIIllIIIIlIlIl, lllllllllllllIIIlIlIIllIIIIlIlIl, lllllllllllllIIIlIlIIllIIIIllIlI).endVertex();
        lllllllllllllIIIlIlIIllIIIlIIIll.pos(lllllllllllllIIIlIlIIllIIIIllIII - 0.125f, lllllllllllllIIIlIlIIllIIIIlIlll, lllllllllllllIIIlIlIIllIIIIlIllI - 0.125f).tex(0.0, 0.0).color(lllllllllllllIIIlIlIIllIIIIlIlIl, lllllllllllllIIIlIlIIllIIIIlIlIl, lllllllllllllIIIlIlIIllIIIIlIlIl, lllllllllllllIIIlIlIIllIIIIllIlI).endVertex();
        Tessellator.getInstance().draw();
        GlStateManager.disableBlend();
        GlStateManager.enableLighting();
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int lllllllllllllIIllllIIlIlIllIIIIl, final World lllllllllllllIIllllIIlIlIllIIIII, final double lllllllllllllIIllllIIlIlIlIlllll, final double lllllllllllllIIllllIIlIlIlIllllI, final double lllllllllllllIIllllIIlIlIlIlIlIl, final double lllllllllllllIIllllIIlIlIlIlllII, final double lllllllllllllIIllllIIlIlIlIllIll, final double lllllllllllllIIllllIIlIlIlIllIlI, final int... lllllllllllllIIllllIIlIlIlIllIIl) {
            return new ParticleFootStep(Minecraft.getMinecraft().getTextureManager(), lllllllllllllIIllllIIlIlIllIIIII, lllllllllllllIIllllIIlIlIlIlllll, lllllllllllllIIllllIIlIlIlIllllI, lllllllllllllIIllllIIlIlIlIlIlIl);
        }
    }
}
