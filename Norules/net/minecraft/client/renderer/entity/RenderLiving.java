package net.minecraft.client.renderer.entity;

import net.minecraft.client.model.*;
import net.minecraft.client.renderer.culling.*;
import optifine.*;
import shadersmod.client.*;
import net.minecraft.entity.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.client.renderer.*;

public abstract class RenderLiving<T extends EntityLiving> extends RenderLivingBase<T>
{
    @Override
    protected boolean canRenderName(final T lllllllllllllIIIlIlIlIlIlIIlIIlI) {
        return super.canRenderName(lllllllllllllIIIlIlIlIlIlIIlIIlI) && (lllllllllllllIIIlIlIlIlIlIIlIIlI.getAlwaysRenderNameTagForRender() || (lllllllllllllIIIlIlIlIlIlIIlIIlI.hasCustomName() && lllllllllllllIIIlIlIlIlIlIIlIIlI == this.renderManager.pointedEntity));
    }
    
    public RenderLiving(final RenderManager lllllllllllllIIIlIlIlIlIlIIllIlI, final ModelBase lllllllllllllIIIlIlIlIlIlIIlllIl, final float lllllllllllllIIIlIlIlIlIlIIlllII) {
        super(lllllllllllllIIIlIlIlIlIlIIllIlI, lllllllllllllIIIlIlIlIlIlIIlllIl, lllllllllllllIIIlIlIlIlIlIIlllII);
    }
    
    @Override
    public boolean shouldRender(final T lllllllllllllIIIlIlIlIlIlIIIlIIl, final ICamera lllllllllllllIIIlIlIlIlIlIIIlIII, final double lllllllllllllIIIlIlIlIlIlIIIIIII, final double lllllllllllllIIIlIlIlIlIIlllllll, final double lllllllllllllIIIlIlIlIlIlIIIIlIl) {
        if (super.shouldRender(lllllllllllllIIIlIlIlIlIlIIIlIIl, lllllllllllllIIIlIlIlIlIlIIIlIII, lllllllllllllIIIlIlIlIlIlIIIIIII, lllllllllllllIIIlIlIlIlIIlllllll, lllllllllllllIIIlIlIlIlIlIIIIlIl)) {
            return true;
        }
        if (lllllllllllllIIIlIlIlIlIlIIIlIIl.getLeashed() && lllllllllllllIIIlIlIlIlIlIIIlIIl.getLeashedToEntity() != null) {
            final Entity lllllllllllllIIIlIlIlIlIlIIIIlII = lllllllllllllIIIlIlIlIlIlIIIlIIl.getLeashedToEntity();
            return lllllllllllllIIIlIlIlIlIlIIIlIII.isBoundingBoxInFrustum(lllllllllllllIIIlIlIlIlIlIIIIlII.getRenderBoundingBox());
        }
        return false;
    }
    
    private double interpolateValue(final double lllllllllllllIIIlIlIlIlIIlIlIllI, final double lllllllllllllIIIlIlIlIlIIlIlIIlI, final double lllllllllllllIIIlIlIlIlIIlIlIIIl) {
        return lllllllllllllIIIlIlIlIlIIlIlIllI + (lllllllllllllIIIlIlIlIlIIlIlIIlI - lllllllllllllIIIlIlIlIlIIlIlIllI) * lllllllllllllIIIlIlIlIlIIlIlIIIl;
    }
    
    public void setLightmap(final T lllllllllllllIIIlIlIlIlIIllIIIlI) {
        final int lllllllllllllIIIlIlIlIlIIllIIIIl = lllllllllllllIIIlIlIlIlIIllIIIlI.getBrightnessForRender();
        final int lllllllllllllIIIlIlIlIlIIllIIIII = lllllllllllllIIIlIlIlIlIIllIIIIl % 65536;
        final int lllllllllllllIIIlIlIlIlIIlIlllll = lllllllllllllIIIlIlIlIlIIllIIIIl / 65536;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)lllllllllllllIIIlIlIlIlIIllIIIII, (float)lllllllllllllIIIlIlIlIlIIlIlllll);
    }
    
    protected void renderLeash(final T lllllllllllllIIIlIlIlIlIIIIlIllI, double lllllllllllllIIIlIlIlIIlllIlllII, double lllllllllllllIIIlIlIlIIlllIllIll, double lllllllllllllIIIlIlIlIIlllIllIlI, final float lllllllllllllIIIlIlIlIlIIIIlIIII, final float lllllllllllllIIIlIlIlIIlllIllIIl) {
        if (!Config.isShaders() || !Shaders.isShadowPass) {
            final Entity lllllllllllllIIIlIlIlIlIIIIIlIll = lllllllllllllIIIlIlIlIlIIIIlIllI.getLeashedToEntity();
            if (lllllllllllllIIIlIlIlIlIIIIIlIll != null) {
                lllllllllllllIIIlIlIlIIlllIllIll -= ((1.6 - lllllllllllllIIIlIlIlIlIIIIlIllI.height) * 0.5 != 0.0);
                final Tessellator lllllllllllllIIIlIlIlIlIIIIIlIIl = Tessellator.getInstance();
                final BufferBuilder lllllllllllllIIIlIlIlIlIIIIIIlll = lllllllllllllIIIlIlIlIlIIIIIlIIl.getBuffer();
                final double lllllllllllllIIIlIlIlIlIIIIIIlIl = this.interpolateValue(lllllllllllllIIIlIlIlIlIIIIIlIll.prevRotationYaw, lllllllllllllIIIlIlIlIlIIIIIlIll.rotationYaw, lllllllllllllIIIlIlIlIIlllIllIIl * 0.5f) * 0.01745329238474369;
                final double lllllllllllllIIIlIlIlIlIIIIIIIll = this.interpolateValue(lllllllllllllIIIlIlIlIlIIIIIlIll.prevRotationPitch, lllllllllllllIIIlIlIlIlIIIIIlIll.rotationPitch, lllllllllllllIIIlIlIlIIlllIllIIl * 0.5f) * 0.01745329238474369;
                double lllllllllllllIIIlIlIlIlIIIIIIIIl = Math.cos(lllllllllllllIIIlIlIlIlIIIIIIlIl);
                double lllllllllllllIIIlIlIlIlIIIIIIIII = Math.sin(lllllllllllllIIIlIlIlIlIIIIIIlIl);
                double lllllllllllllIIIlIlIlIIlllllllll = Math.sin(lllllllllllllIIIlIlIlIlIIIIIIIll);
                if (lllllllllllllIIIlIlIlIlIIIIIlIll instanceof EntityHanging) {
                    lllllllllllllIIIlIlIlIlIIIIIIIIl = 0.0;
                    lllllllllllllIIIlIlIlIlIIIIIIIII = 0.0;
                    lllllllllllllIIIlIlIlIIlllllllll = -1.0;
                }
                final double lllllllllllllIIIlIlIlIIlllllllIl = Math.cos(lllllllllllllIIIlIlIlIlIIIIIIIll);
                final double lllllllllllllIIIlIlIlIIllllllIll = this.interpolateValue(lllllllllllllIIIlIlIlIlIIIIIlIll.prevPosX, lllllllllllllIIIlIlIlIlIIIIIlIll.posX, lllllllllllllIIIlIlIlIIlllIllIIl) - lllllllllllllIIIlIlIlIlIIIIIIIIl * 0.7 - lllllllllllllIIIlIlIlIlIIIIIIIII * 0.5 * lllllllllllllIIIlIlIlIIlllllllIl;
                final double lllllllllllllIIIlIlIlIIllllllIIl = this.interpolateValue(lllllllllllllIIIlIlIlIlIIIIIlIll.prevPosY + lllllllllllllIIIlIlIlIlIIIIIlIll.getEyeHeight() * 0.7, lllllllllllllIIIlIlIlIlIIIIIlIll.posY + lllllllllllllIIIlIlIlIlIIIIIlIll.getEyeHeight() * 0.7, lllllllllllllIIIlIlIlIIlllIllIIl) - lllllllllllllIIIlIlIlIIlllllllll * 0.5 - 0.25;
                final double lllllllllllllIIIlIlIlIIllllllIII = this.interpolateValue(lllllllllllllIIIlIlIlIlIIIIIlIll.prevPosZ, lllllllllllllIIIlIlIlIlIIIIIlIll.posZ, lllllllllllllIIIlIlIlIIlllIllIIl) - lllllllllllllIIIlIlIlIlIIIIIIIII * 0.7 + lllllllllllllIIIlIlIlIlIIIIIIIIl * 0.5 * lllllllllllllIIIlIlIlIIlllllllIl;
                final double lllllllllllllIIIlIlIlIIlllllIlll = this.interpolateValue(lllllllllllllIIIlIlIlIlIIIIlIllI.prevRenderYawOffset, lllllllllllllIIIlIlIlIlIIIIlIllI.renderYawOffset, lllllllllllllIIIlIlIlIIlllIllIIl) * 0.01745329238474369 + 1.5707963267948966;
                lllllllllllllIIIlIlIlIlIIIIIIIIl = Math.cos(lllllllllllllIIIlIlIlIIlllllIlll) * lllllllllllllIIIlIlIlIlIIIIlIllI.width * 0.4;
                lllllllllllllIIIlIlIlIlIIIIIIIII = Math.sin(lllllllllllllIIIlIlIlIIlllllIlll) * lllllllllllllIIIlIlIlIlIIIIlIllI.width * 0.4;
                final double lllllllllllllIIIlIlIlIIlllllIllI = this.interpolateValue(lllllllllllllIIIlIlIlIlIIIIlIllI.prevPosX, lllllllllllllIIIlIlIlIlIIIIlIllI.posX, lllllllllllllIIIlIlIlIIlllIllIIl) + lllllllllllllIIIlIlIlIlIIIIIIIIl;
                final double lllllllllllllIIIlIlIlIIlllllIlII = this.interpolateValue(lllllllllllllIIIlIlIlIlIIIIlIllI.prevPosY, lllllllllllllIIIlIlIlIlIIIIlIllI.posY, lllllllllllllIIIlIlIlIIlllIllIIl);
                final double lllllllllllllIIIlIlIlIIlllllIIlI = this.interpolateValue(lllllllllllllIIIlIlIlIlIIIIlIllI.prevPosZ, lllllllllllllIIIlIlIlIlIIIIlIllI.posZ, lllllllllllllIIIlIlIlIIlllIllIIl) + lllllllllllllIIIlIlIlIlIIIIIIIII;
                lllllllllllllIIIlIlIlIIlllIlllII += (Exception)lllllllllllllIIIlIlIlIlIIIIIIIIl;
                lllllllllllllIIIlIlIlIIlllIllIlI += lllllllllllllIIIlIlIlIlIIIIIIIII;
                final double lllllllllllllIIIlIlIlIIlllllIIIl = (float)(lllllllllllllIIIlIlIlIIllllllIll - lllllllllllllIIIlIlIlIIlllllIllI);
                final double lllllllllllllIIIlIlIlIIllllIllll = (float)(lllllllllllllIIIlIlIlIIllllllIIl - lllllllllllllIIIlIlIlIIlllllIlII);
                final double lllllllllllllIIIlIlIlIIllllIlllI = (float)(lllllllllllllIIIlIlIlIIllllllIII - lllllllllllllIIIlIlIlIIlllllIIlI);
                GlStateManager.disableTexture2D();
                GlStateManager.disableLighting();
                GlStateManager.disableCull();
                if (Config.isShaders()) {
                    Shaders.beginLeash();
                }
                final int lllllllllllllIIIlIlIlIIllllIllIl = 24;
                final double lllllllllllllIIIlIlIlIIllllIlIll = 0.025;
                lllllllllllllIIIlIlIlIlIIIIIIlll.begin(5, DefaultVertexFormats.POSITION_COLOR);
                for (int lllllllllllllIIIlIlIlIIllllIlIIl = 0; lllllllllllllIIIlIlIlIIllllIlIIl <= 24; ++lllllllllllllIIIlIlIlIIllllIlIIl) {
                    float lllllllllllllIIIlIlIlIIllllIIlll = 0.5f;
                    float lllllllllllllIIIlIlIlIIllllIIllI = 0.4f;
                    float lllllllllllllIIIlIlIlIIllllIIlIl = 0.3f;
                    if (lllllllllllllIIIlIlIlIIllllIlIIl % 2 == 0) {
                        lllllllllllllIIIlIlIlIIllllIIlll *= 0.7f;
                        lllllllllllllIIIlIlIlIIllllIIllI *= 0.7f;
                        lllllllllllllIIIlIlIlIIllllIIlIl *= 0.7f;
                    }
                    final float lllllllllllllIIIlIlIlIIllllIIlII = lllllllllllllIIIlIlIlIIllllIlIIl / 24.0f;
                    lllllllllllllIIIlIlIlIlIIIIIIlll.pos((double)(lllllllllllllIIIlIlIlIIlllIlllII + lllllllllllllIIIlIlIlIIlllllIIIl * lllllllllllllIIIlIlIlIIllllIIlII + 0.0), (lllllllllllllIIIlIlIlIIlllIllIll ? 1 : 0) + lllllllllllllIIIlIlIlIIllllIllll * (lllllllllllllIIIlIlIlIIllllIIlII * lllllllllllllIIIlIlIlIIllllIIlII + lllllllllllllIIIlIlIlIIllllIIlII) * 0.5 + ((24.0f - lllllllllllllIIIlIlIlIIllllIlIIl) / 18.0f + 0.125f), lllllllllllllIIIlIlIlIIlllIllIlI + lllllllllllllIIIlIlIlIIllllIlllI * lllllllllllllIIIlIlIlIIllllIIlII).color(lllllllllllllIIIlIlIlIIllllIIlll, lllllllllllllIIIlIlIlIIllllIIllI, lllllllllllllIIIlIlIlIIllllIIlIl, 1.0f).endVertex();
                    lllllllllllllIIIlIlIlIlIIIIIIlll.pos((double)(lllllllllllllIIIlIlIlIIlllIlllII + lllllllllllllIIIlIlIlIIlllllIIIl * lllllllllllllIIIlIlIlIIllllIIlII + 0.025), (lllllllllllllIIIlIlIlIIlllIllIll ? 1 : 0) + lllllllllllllIIIlIlIlIIllllIllll * (lllllllllllllIIIlIlIlIIllllIIlII * lllllllllllllIIIlIlIlIIllllIIlII + lllllllllllllIIIlIlIlIIllllIIlII) * 0.5 + ((24.0f - lllllllllllllIIIlIlIlIIllllIlIIl) / 18.0f + 0.125f) + 0.025, lllllllllllllIIIlIlIlIIlllIllIlI + lllllllllllllIIIlIlIlIIllllIlllI * lllllllllllllIIIlIlIlIIllllIIlII).color(lllllllllllllIIIlIlIlIIllllIIlll, lllllllllllllIIIlIlIlIIllllIIllI, lllllllllllllIIIlIlIlIIllllIIlIl, 1.0f).endVertex();
                }
                lllllllllllllIIIlIlIlIlIIIIIlIIl.draw();
                lllllllllllllIIIlIlIlIlIIIIIIlll.begin(5, DefaultVertexFormats.POSITION_COLOR);
                for (int lllllllllllllIIIlIlIlIIllllIIIll = 0; lllllllllllllIIIlIlIlIIllllIIIll <= 24; ++lllllllllllllIIIlIlIlIIllllIIIll) {
                    float lllllllllllllIIIlIlIlIIllllIIIlI = 0.5f;
                    float lllllllllllllIIIlIlIlIIllllIIIIl = 0.4f;
                    float lllllllllllllIIIlIlIlIIllllIIIII = 0.3f;
                    if (lllllllllllllIIIlIlIlIIllllIIIll % 2 == 0) {
                        lllllllllllllIIIlIlIlIIllllIIIlI *= 0.7f;
                        lllllllllllllIIIlIlIlIIllllIIIIl *= 0.7f;
                        lllllllllllllIIIlIlIlIIllllIIIII *= 0.7f;
                    }
                    final float lllllllllllllIIIlIlIlIIlllIlllll = lllllllllllllIIIlIlIlIIllllIIIll / 24.0f;
                    lllllllllllllIIIlIlIlIlIIIIIIlll.pos((double)(lllllllllllllIIIlIlIlIIlllIlllII + lllllllllllllIIIlIlIlIIlllllIIIl * lllllllllllllIIIlIlIlIIlllIlllll + 0.0), (lllllllllllllIIIlIlIlIIlllIllIll ? 1 : 0) + lllllllllllllIIIlIlIlIIllllIllll * (lllllllllllllIIIlIlIlIIlllIlllll * lllllllllllllIIIlIlIlIIlllIlllll + lllllllllllllIIIlIlIlIIlllIlllll) * 0.5 + ((24.0f - lllllllllllllIIIlIlIlIIllllIIIll) / 18.0f + 0.125f) + 0.025, lllllllllllllIIIlIlIlIIlllIllIlI + lllllllllllllIIIlIlIlIIllllIlllI * lllllllllllllIIIlIlIlIIlllIlllll).color(lllllllllllllIIIlIlIlIIllllIIIlI, lllllllllllllIIIlIlIlIIllllIIIIl, lllllllllllllIIIlIlIlIIllllIIIII, 1.0f).endVertex();
                    lllllllllllllIIIlIlIlIlIIIIIIlll.pos((double)(lllllllllllllIIIlIlIlIIlllIlllII + lllllllllllllIIIlIlIlIIlllllIIIl * lllllllllllllIIIlIlIlIIlllIlllll + 0.025), (lllllllllllllIIIlIlIlIIlllIllIll ? 1 : 0) + lllllllllllllIIIlIlIlIIllllIllll * (lllllllllllllIIIlIlIlIIlllIlllll * lllllllllllllIIIlIlIlIIlllIlllll + lllllllllllllIIIlIlIlIIlllIlllll) * 0.5 + ((24.0f - lllllllllllllIIIlIlIlIIllllIIIll) / 18.0f + 0.125f), lllllllllllllIIIlIlIlIIlllIllIlI + lllllllllllllIIIlIlIlIIllllIlllI * lllllllllllllIIIlIlIlIIlllIlllll + 0.025).color(lllllllllllllIIIlIlIlIIllllIIIlI, lllllllllllllIIIlIlIlIIllllIIIIl, lllllllllllllIIIlIlIlIIllllIIIII, 1.0f).endVertex();
                }
                lllllllllllllIIIlIlIlIlIIIIIlIIl.draw();
                if (Config.isShaders()) {
                    Shaders.endLeash();
                }
                GlStateManager.enableLighting();
                GlStateManager.enableTexture2D();
                GlStateManager.enableCull();
            }
        }
    }
    
    @Override
    public void doRender(final T lllllllllllllIIIlIlIlIlIIllIllIl, final double lllllllllllllIIIlIlIlIlIIlllIIll, final double lllllllllllllIIIlIlIlIlIIlllIIlI, final double lllllllllllllIIIlIlIlIlIIlllIIIl, final float lllllllllllllIIIlIlIlIlIIlllIIII, final float lllllllllllllIIIlIlIlIlIIllIlIII) {
        super.doRender(lllllllllllllIIIlIlIlIlIIllIllIl, lllllllllllllIIIlIlIlIlIIlllIIll, lllllllllllllIIIlIlIlIlIIlllIIlI, lllllllllllllIIIlIlIlIlIIlllIIIl, lllllllllllllIIIlIlIlIlIIlllIIII, lllllllllllllIIIlIlIlIlIIllIlIII);
        if (!this.renderOutlines) {
            this.renderLeash(lllllllllllllIIIlIlIlIlIIllIllIl, lllllllllllllIIIlIlIlIlIIlllIIll, lllllllllllllIIIlIlIlIlIIlllIIlI, lllllllllllllIIIlIlIlIlIIlllIIIl, lllllllllllllIIIlIlIlIlIIlllIIII, lllllllllllllIIIlIlIlIlIIllIlIII);
        }
    }
}
