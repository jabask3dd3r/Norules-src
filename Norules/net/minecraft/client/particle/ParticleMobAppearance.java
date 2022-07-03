package net.minecraft.client.particle;

import net.minecraft.entity.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.math.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.world.*;
import net.minecraft.entity.monster.*;

public class ParticleMobAppearance extends Particle
{
    private /* synthetic */ EntityLivingBase entity;
    
    @Override
    public void renderParticle(final BufferBuilder llllllllllllllllIllIlIIIIllIIIll, final Entity llllllllllllllllIllIlIIIIllIIIlI, final float llllllllllllllllIllIlIIIIllIIIIl, final float llllllllllllllllIllIlIIIIllIIIII, final float llllllllllllllllIllIlIIIIlIlllll, final float llllllllllllllllIllIlIIIIlIllllI, final float llllllllllllllllIllIlIIIIlIlllIl, final float llllllllllllllllIllIlIIIIlIlllII) {
        if (this.entity != null) {
            final RenderManager llllllllllllllllIllIlIIIIlIllIll = Minecraft.getMinecraft().getRenderManager();
            llllllllllllllllIllIlIIIIlIllIll.setRenderPosition(Particle.interpPosX, Particle.interpPosY, Particle.interpPosZ);
            final float llllllllllllllllIllIlIIIIlIllIlI = 0.42553192f;
            final float llllllllllllllllIllIlIIIIlIllIIl = (this.particleAge + llllllllllllllllIllIlIIIIllIIIIl) / this.particleMaxAge;
            GlStateManager.depthMask(true);
            GlStateManager.enableBlend();
            GlStateManager.enableDepth();
            GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
            final float llllllllllllllllIllIlIIIIlIllIII = 240.0f;
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0f, 240.0f);
            GlStateManager.pushMatrix();
            final float llllllllllllllllIllIlIIIIlIlIlll = 0.05f + 0.5f * MathHelper.sin(llllllllllllllllIllIlIIIIlIllIIl * 3.1415927f);
            GlStateManager.color(1.0f, 1.0f, 1.0f, llllllllllllllllIllIlIIIIlIlIlll);
            GlStateManager.translate(0.0f, 1.8f, 0.0f);
            GlStateManager.rotate(180.0f - llllllllllllllllIllIlIIIIllIIIlI.rotationYaw, 0.0f, 1.0f, 0.0f);
            GlStateManager.rotate(60.0f - 150.0f * llllllllllllllllIllIlIIIIlIllIIl - llllllllllllllllIllIlIIIIllIIIlI.rotationPitch, 1.0f, 0.0f, 0.0f);
            GlStateManager.translate(0.0f, -0.4f, -1.5f);
            GlStateManager.scale(0.42553192f, 0.42553192f, 0.42553192f);
            this.entity.rotationYaw = 0.0f;
            this.entity.rotationYawHead = 0.0f;
            this.entity.prevRotationYaw = 0.0f;
            this.entity.prevRotationYawHead = 0.0f;
            llllllllllllllllIllIlIIIIlIllIll.doRenderEntity(this.entity, 0.0, 0.0, 0.0, 0.0f, llllllllllllllllIllIlIIIIllIIIIl, false);
            GlStateManager.popMatrix();
            GlStateManager.enableDepth();
        }
    }
    
    @Override
    public int getFXLayer() {
        return 3;
    }
    
    protected ParticleMobAppearance(final World llllllllllllllllIllIlIIIIlllllII, final double llllllllllllllllIllIlIIIIllllIll, final double llllllllllllllllIllIlIIIIllllIlI, final double llllllllllllllllIllIlIIIIlllIlII) {
        super(llllllllllllllllIllIlIIIIlllllII, llllllllllllllllIllIlIIIIllllIll, llllllllllllllllIllIlIIIIllllIlI, llllllllllllllllIllIlIIIIlllIlII, 0.0, 0.0, 0.0);
        this.particleRed = 1.0f;
        this.particleGreen = 1.0f;
        this.particleBlue = 1.0f;
        this.motionX = 0.0;
        this.motionY = 0.0;
        this.motionZ = 0.0;
        this.particleGravity = 0.0f;
        this.particleMaxAge = 30;
    }
    
    @Override
    public void onUpdate() {
        super.onUpdate();
        if (this.entity == null) {
            final EntityElderGuardian llllllllllllllllIllIlIIIIllIllll = new EntityElderGuardian(this.worldObj);
            llllllllllllllllIllIlIIIIllIllll.func_190767_di();
            this.entity = llllllllllllllllIllIlIIIIllIllll;
        }
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public Particle createParticle(final int lllllllllllllIllllIlIllIlllIIIlI, final World lllllllllllllIllllIlIllIllIllIIl, final double lllllllllllllIllllIlIllIllIllIII, final double lllllllllllllIllllIlIllIllIlIlll, final double lllllllllllllIllllIlIllIllIllllI, final double lllllllllllllIllllIlIllIllIlllIl, final double lllllllllllllIllllIlIllIllIlllII, final double lllllllllllllIllllIlIllIllIllIll, final int... lllllllllllllIllllIlIllIllIllIlI) {
            return new ParticleMobAppearance(lllllllllllllIllllIlIllIllIllIIl, lllllllllllllIllllIlIllIllIllIII, lllllllllllllIllllIlIllIllIlIlll, lllllllllllllIllllIlIllIllIllllI);
        }
    }
}
