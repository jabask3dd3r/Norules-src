package net.minecraft.client.renderer.entity;

import net.minecraft.client.renderer.texture.*;
import java.util.*;
import net.minecraft.client.renderer.entity.layers.*;
import net.minecraft.client.model.*;
import java.nio.*;
import shadersmod.client.*;
import net.minecraft.client.*;
import net.minecraft.entity.*;
import optifine.*;
import net.minecraft.util.math.*;
import net.optifine.entity.model.*;
import net.minecraft.client.renderer.*;
import com.google.common.collect.*;
import net.minecraft.scoreboard.*;
import me.nrules.event.events.*;
import net.minecraft.client.entity.*;
import org.apache.logging.log4j.*;
import net.minecraft.util.text.*;
import net.minecraft.entity.player.*;

public abstract class RenderLivingBase<T extends EntityLivingBase> extends Render<T>
{
    public /* synthetic */ float renderHeadPitch;
    public static /* synthetic */ float NAME_TAG_RANGE_SNEAK;
    public /* synthetic */ float renderLimbSwing;
    private static final /* synthetic */ DynamicTexture TEXTURE_BRIGHTNESS;
    public /* synthetic */ float renderLimbSwingAmount;
    public static final /* synthetic */ boolean animateModelLiving;
    protected /* synthetic */ boolean renderMarker;
    public static /* synthetic */ float NAME_TAG_RANGE;
    public /* synthetic */ float renderHeadYaw;
    protected /* synthetic */ List<LayerRenderer<T>> layerRenderers;
    private static final /* synthetic */ Logger LOGGER;
    public /* synthetic */ float renderScaleFactor;
    public /* synthetic */ ModelBase mainModel;
    protected /* synthetic */ FloatBuffer brightnessBuffer;
    public /* synthetic */ float renderAgeInTicks;
    
    protected void preRenderCallback(final T llllllllllllllIIIllIIlIIlllIllll, final float llllllllllllllIIIllIIlIIlllIlllI) {
    }
    
    protected void unsetBrightness() {
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
        GlStateManager.enableTexture2D();
        GlStateManager.glTexEnvi(8960, 8704, OpenGlHelper.GL_COMBINE);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_COMBINE_RGB, 8448);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_SOURCE0_RGB, OpenGlHelper.defaultTexUnit);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_SOURCE1_RGB, OpenGlHelper.GL_PRIMARY_COLOR);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_OPERAND0_RGB, 768);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_OPERAND1_RGB, 768);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_COMBINE_ALPHA, 8448);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_SOURCE0_ALPHA, OpenGlHelper.defaultTexUnit);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_SOURCE1_ALPHA, OpenGlHelper.GL_PRIMARY_COLOR);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_OPERAND0_ALPHA, 770);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_OPERAND1_ALPHA, 770);
        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GlStateManager.glTexEnvi(8960, 8704, OpenGlHelper.GL_COMBINE);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_COMBINE_RGB, 8448);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_OPERAND0_RGB, 768);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_OPERAND1_RGB, 768);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_SOURCE0_RGB, 5890);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_SOURCE1_RGB, OpenGlHelper.GL_PREVIOUS);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_COMBINE_ALPHA, 8448);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_OPERAND0_ALPHA, 770);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_SOURCE0_ALPHA, 5890);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.setActiveTexture(OpenGlHelper.GL_TEXTURE2);
        GlStateManager.disableTexture2D();
        GlStateManager.bindTexture(0);
        GlStateManager.glTexEnvi(8960, 8704, OpenGlHelper.GL_COMBINE);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_COMBINE_RGB, 8448);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_OPERAND0_RGB, 768);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_OPERAND1_RGB, 768);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_SOURCE0_RGB, 5890);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_SOURCE1_RGB, OpenGlHelper.GL_PREVIOUS);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_COMBINE_ALPHA, 8448);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_OPERAND0_ALPHA, 770);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_SOURCE0_ALPHA, 5890);
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
        if (Config.isShaders()) {
            Shaders.setEntityColor(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }
    
    protected void renderModel(final T llllllllllllllIIIllIIlIllIIIlIlI, final float llllllllllllllIIIllIIlIllIIIlIIl, final float llllllllllllllIIIllIIlIlIllllllI, final float llllllllllllllIIIllIIlIlIlllllIl, final float llllllllllllllIIIllIIlIlIlllllII, final float llllllllllllllIIIllIIlIlIllllIll, final float llllllllllllllIIIllIIlIlIllllIlI) {
        final boolean llllllllllllllIIIllIIlIllIIIIIll = this.func_193115_c(llllllllllllllIIIllIIlIllIIIlIlI);
        final boolean llllllllllllllIIIllIIlIllIIIIIlI = !llllllllllllllIIIllIIlIllIIIIIll && !llllllllllllllIIIllIIlIllIIIlIlI.isInvisibleToPlayer(Minecraft.getMinecraft().player);
        if (llllllllllllllIIIllIIlIllIIIIIll || llllllllllllllIIIllIIlIllIIIIIlI) {
            if (!this.bindEntityTexture(llllllllllllllIIIllIIlIllIIIlIlI)) {
                return;
            }
            if (llllllllllllllIIIllIIlIllIIIIIlI) {
                GlStateManager.enableBlendProfile(GlStateManager.Profile.TRANSPARENT_MODEL);
            }
            this.mainModel.render(llllllllllllllIIIllIIlIllIIIlIlI, llllllllllllllIIIllIIlIllIIIlIIl, llllllllllllllIIIllIIlIlIllllllI, llllllllllllllIIIllIIlIlIlllllIl, llllllllllllllIIIllIIlIlIlllllII, llllllllllllllIIIllIIlIlIllllIll, llllllllllllllIIIllIIlIlIllllIlI);
            if (llllllllllllllIIIllIIlIllIIIIIlI) {
                GlStateManager.disableBlendProfile(GlStateManager.Profile.TRANSPARENT_MODEL);
            }
        }
    }
    
    protected float handleRotationFloat(final T llllllllllllllIIIllIIlIlIIIlllIl, final float llllllllllllllIIIllIIlIlIIIllIlI) {
        return llllllllllllllIIIllIIlIlIIIlllIl.ticksExisted + llllllllllllllIIIllIIlIlIIIllIlI;
    }
    
    @Override
    public void doRender(final T llllllllllllllIIIllIIlIlllIIIlll, final double llllllllllllllIIIllIIlIlllIIIllI, final double llllllllllllllIIIllIIlIlllIIIlIl, final double llllllllllllllIIIllIIlIllIllIIII, final float llllllllllllllIIIllIIlIllIlIllll, final float llllllllllllllIIIllIIlIllIlIlllI) {
        if (!Reflector.RenderLivingEvent_Pre_Constructor.exists() || !Reflector.postForgeBusEvent(Reflector.RenderLivingEvent_Pre_Constructor, llllllllllllllIIIllIIlIlllIIIlll, this, llllllllllllllIIIllIIlIllIlIlllI, llllllllllllllIIIllIIlIlllIIIllI, llllllllllllllIIIllIIlIlllIIIlIl, llllllllllllllIIIllIIlIllIllIIII)) {
            if (RenderLivingBase.animateModelLiving) {
                llllllllllllllIIIllIIlIlllIIIlll.limbSwingAmount = 1.0f;
            }
            GlStateManager.pushMatrix();
            GlStateManager.disableCull();
            this.mainModel.swingProgress = this.getSwingProgress(llllllllllllllIIIllIIlIlllIIIlll, llllllllllllllIIIllIIlIllIlIlllI);
            this.mainModel.isRiding = llllllllllllllIIIllIIlIlllIIIlll.isRiding();
            if (Reflector.ForgeEntity_shouldRiderSit.exists()) {
                this.mainModel.isRiding = (llllllllllllllIIIllIIlIlllIIIlll.isRiding() && llllllllllllllIIIllIIlIlllIIIlll.getRidingEntity() != null && Reflector.callBoolean(llllllllllllllIIIllIIlIlllIIIlll.getRidingEntity(), Reflector.ForgeEntity_shouldRiderSit, new Object[0]));
            }
            this.mainModel.isChild = llllllllllllllIIIllIIlIlllIIIlll.isChild();
            try {
                float llllllllllllllIIIllIIlIlllIIIIIl = this.interpolateRotation(llllllllllllllIIIllIIlIlllIIIlll.prevRenderYawOffset, llllllllllllllIIIllIIlIlllIIIlll.renderYawOffset, llllllllllllllIIIllIIlIllIlIlllI);
                final float llllllllllllllIIIllIIlIlllIIIIII = this.interpolateRotation(llllllllllllllIIIllIIlIlllIIIlll.prevRotationYawHead, llllllllllllllIIIllIIlIlllIIIlll.rotationYawHead, llllllllllllllIIIllIIlIllIlIlllI);
                float llllllllllllllIIIllIIlIllIllllll = llllllllllllllIIIllIIlIlllIIIIII - llllllllllllllIIIllIIlIlllIIIIIl;
                if (this.mainModel.isRiding && llllllllllllllIIIllIIlIlllIIIlll.getRidingEntity() instanceof EntityLivingBase) {
                    final EntityLivingBase llllllllllllllIIIllIIlIllIlllllI = (EntityLivingBase)llllllllllllllIIIllIIlIlllIIIlll.getRidingEntity();
                    llllllllllllllIIIllIIlIlllIIIIIl = this.interpolateRotation(llllllllllllllIIIllIIlIllIlllllI.prevRenderYawOffset, llllllllllllllIIIllIIlIllIlllllI.renderYawOffset, llllllllllllllIIIllIIlIllIlIlllI);
                    llllllllllllllIIIllIIlIllIllllll = llllllllllllllIIIllIIlIlllIIIIII - llllllllllllllIIIllIIlIlllIIIIIl;
                    float llllllllllllllIIIllIIlIllIllllIl = MathHelper.wrapDegrees(llllllllllllllIIIllIIlIllIllllll);
                    if (llllllllllllllIIIllIIlIllIllllIl < -85.0f) {
                        llllllllllllllIIIllIIlIllIllllIl = -85.0f;
                    }
                    if (llllllllllllllIIIllIIlIllIllllIl >= 85.0f) {
                        llllllllllllllIIIllIIlIllIllllIl = 85.0f;
                    }
                    llllllllllllllIIIllIIlIlllIIIIIl = llllllllllllllIIIllIIlIlllIIIIII - llllllllllllllIIIllIIlIllIllllIl;
                    if (llllllllllllllIIIllIIlIllIllllIl * llllllllllllllIIIllIIlIllIllllIl > 2500.0f) {
                        llllllllllllllIIIllIIlIlllIIIIIl += llllllllllllllIIIllIIlIllIllllIl * 0.2f;
                    }
                    llllllllllllllIIIllIIlIllIllllll = llllllllllllllIIIllIIlIlllIIIIII - llllllllllllllIIIllIIlIlllIIIIIl;
                }
                final float llllllllllllllIIIllIIlIllIllllII = (llllllllllllllIIIllIIlIlllIIIlll instanceof EntityPlayer && llllllllllllllIIIllIIlIlllIIIlll == Minecraft.getMinecraft().player) ? (llllllllllllllIIIllIIlIlllIIIlll.prevRotationPitchHead + (llllllllllllllIIIllIIlIlllIIIlll.rotationPitchHead - llllllllllllllIIIllIIlIlllIIIlll.prevRotationPitchHead) * llllllllllllllIIIllIIlIllIlIlllI) : (llllllllllllllIIIllIIlIlllIIIlll.prevRotationPitch + (llllllllllllllIIIllIIlIlllIIIlll.rotationPitch - llllllllllllllIIIllIIlIlllIIIlll.prevRotationPitch) * llllllllllllllIIIllIIlIllIlIlllI);
                this.renderLivingAt(llllllllllllllIIIllIIlIlllIIIlll, llllllllllllllIIIllIIlIlllIIIllI, llllllllllllllIIIllIIlIlllIIIlIl, llllllllllllllIIIllIIlIllIllIIII);
                final float llllllllllllllIIIllIIlIllIlllIll = this.handleRotationFloat(llllllllllllllIIIllIIlIlllIIIlll, llllllllllllllIIIllIIlIllIlIlllI);
                this.rotateCorpse(llllllllllllllIIIllIIlIlllIIIlll, llllllllllllllIIIllIIlIllIlllIll, llllllllllllllIIIllIIlIlllIIIIIl, llllllllllllllIIIllIIlIllIlIlllI);
                final float llllllllllllllIIIllIIlIllIlllIlI = this.prepareScale(llllllllllllllIIIllIIlIlllIIIlll, llllllllllllllIIIllIIlIllIlIlllI);
                float llllllllllllllIIIllIIlIllIlllIIl = 0.0f;
                float llllllllllllllIIIllIIlIllIlllIII = 0.0f;
                if (!llllllllllllllIIIllIIlIlllIIIlll.isRiding()) {
                    llllllllllllllIIIllIIlIllIlllIIl = llllllllllllllIIIllIIlIlllIIIlll.prevLimbSwingAmount + (llllllllllllllIIIllIIlIlllIIIlll.limbSwingAmount - llllllllllllllIIIllIIlIlllIIIlll.prevLimbSwingAmount) * llllllllllllllIIIllIIlIllIlIlllI;
                    llllllllllllllIIIllIIlIllIlllIII = llllllllllllllIIIllIIlIlllIIIlll.limbSwing - llllllllllllllIIIllIIlIlllIIIlll.limbSwingAmount * (1.0f - llllllllllllllIIIllIIlIllIlIlllI);
                    if (llllllllllllllIIIllIIlIlllIIIlll.isChild()) {
                        llllllllllllllIIIllIIlIllIlllIII *= 3.0f;
                    }
                    if (llllllllllllllIIIllIIlIllIlllIIl > 1.0f) {
                        llllllllllllllIIIllIIlIllIlllIIl = 1.0f;
                    }
                }
                GlStateManager.enableAlpha();
                this.mainModel.setLivingAnimations(llllllllllllllIIIllIIlIlllIIIlll, llllllllllllllIIIllIIlIllIlllIII, llllllllllllllIIIllIIlIllIlllIIl, llllllllllllllIIIllIIlIllIlIlllI);
                this.mainModel.setRotationAngles(llllllllllllllIIIllIIlIllIlllIII, llllllllllllllIIIllIIlIllIlllIIl, llllllllllllllIIIllIIlIllIlllIll, llllllllllllllIIIllIIlIllIllllll, llllllllllllllIIIllIIlIllIllllII, llllllllllllllIIIllIIlIllIlllIlI, llllllllllllllIIIllIIlIlllIIIlll);
                if (CustomEntityModels.isActive()) {
                    this.renderLimbSwing = llllllllllllllIIIllIIlIllIlllIII;
                    this.renderLimbSwingAmount = llllllllllllllIIIllIIlIllIlllIIl;
                    this.renderAgeInTicks = llllllllllllllIIIllIIlIllIlllIll;
                    this.renderHeadYaw = llllllllllllllIIIllIIlIllIllllll;
                    this.renderHeadPitch = llllllllllllllIIIllIIlIllIllllII;
                    this.renderScaleFactor = llllllllllllllIIIllIIlIllIlllIlI;
                }
                if (this.renderOutlines) {
                    final boolean llllllllllllllIIIllIIlIllIllIlll = this.setScoreTeamColor(llllllllllllllIIIllIIlIlllIIIlll);
                    GlStateManager.enableColorMaterial();
                    GlStateManager.enableOutlineMode(this.getTeamColor(llllllllllllllIIIllIIlIlllIIIlll));
                    if (!this.renderMarker) {
                        this.renderModel(llllllllllllllIIIllIIlIlllIIIlll, llllllllllllllIIIllIIlIllIlllIII, llllllllllllllIIIllIIlIllIlllIIl, llllllllllllllIIIllIIlIllIlllIll, llllllllllllllIIIllIIlIllIllllll, llllllllllllllIIIllIIlIllIllllII, llllllllllllllIIIllIIlIllIlllIlI);
                    }
                    if (!(llllllllllllllIIIllIIlIlllIIIlll instanceof EntityPlayer) || !((EntityPlayer)llllllllllllllIIIllIIlIlllIIIlll).isSpectator()) {
                        this.renderLayers(llllllllllllllIIIllIIlIlllIIIlll, llllllllllllllIIIllIIlIllIlllIII, llllllllllllllIIIllIIlIllIlllIIl, llllllllllllllIIIllIIlIllIlIlllI, llllllllllllllIIIllIIlIllIlllIll, llllllllllllllIIIllIIlIllIllllll, llllllllllllllIIIllIIlIllIllllII, llllllllllllllIIIllIIlIllIlllIlI);
                    }
                    GlStateManager.disableOutlineMode();
                    GlStateManager.disableColorMaterial();
                    if (llllllllllllllIIIllIIlIllIllIlll) {
                        this.unsetScoreTeamColor();
                    }
                }
                else {
                    final boolean llllllllllllllIIIllIIlIllIllIllI = this.setDoRenderBrightness(llllllllllllllIIIllIIlIlllIIIlll, llllllllllllllIIIllIIlIllIlIlllI);
                    this.renderModel(llllllllllllllIIIllIIlIlllIIIlll, llllllllllllllIIIllIIlIllIlllIII, llllllllllllllIIIllIIlIllIlllIIl, llllllllllllllIIIllIIlIllIlllIll, llllllllllllllIIIllIIlIllIllllll, llllllllllllllIIIllIIlIllIllllII, llllllllllllllIIIllIIlIllIlllIlI);
                    if (llllllllllllllIIIllIIlIllIllIllI) {
                        this.unsetBrightness();
                    }
                    GlStateManager.depthMask(true);
                    if (!(llllllllllllllIIIllIIlIlllIIIlll instanceof EntityPlayer) || !((EntityPlayer)llllllllllllllIIIllIIlIlllIIIlll).isSpectator()) {
                        this.renderLayers(llllllllllllllIIIllIIlIlllIIIlll, llllllllllllllIIIllIIlIllIlllIII, llllllllllllllIIIllIIlIllIlllIIl, llllllllllllllIIIllIIlIllIlIlllI, llllllllllllllIIIllIIlIllIlllIll, llllllllllllllIIIllIIlIllIllllll, llllllllllllllIIIllIIlIllIllllII, llllllllllllllIIIllIIlIllIlllIlI);
                    }
                }
                GlStateManager.disableRescaleNormal();
            }
            catch (Exception llllllllllllllIIIllIIlIllIllIlIl) {
                RenderLivingBase.LOGGER.error("Couldn't render entity", (Throwable)llllllllllllllIIIllIIlIllIllIlIl);
            }
            GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
            GlStateManager.enableTexture2D();
            GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
            GlStateManager.enableCull();
            GlStateManager.popMatrix();
            super.doRender(llllllllllllllIIIllIIlIlllIIIlll, llllllllllllllIIIllIIlIlllIIIllI, llllllllllllllIIIllIIlIlllIIIlIl, llllllllllllllIIIllIIlIllIllIIII, llllllllllllllIIIllIIlIllIlIllll, llllllllllllllIIIllIIlIllIlIlllI);
            if (Reflector.RenderLivingEvent_Post_Constructor.exists()) {
                Reflector.postForgeBusEvent(Reflector.RenderLivingEvent_Post_Constructor, llllllllllllllIIIllIIlIlllIIIlll, this, llllllllllllllIIIllIIlIllIlIlllI, llllllllllllllIIIllIIlIlllIIIllI, llllllllllllllIIIllIIlIlllIIIlIl, llllllllllllllIIIllIIlIllIllIIII);
            }
        }
    }
    
    public <V extends EntityLivingBase, U extends LayerRenderer<V>> boolean addLayer(final U llllllllllllllIIIllIIlIllllIllII) {
        return this.layerRenderers.add((LayerRenderer<T>)llllllllllllllIIIllIIlIllllIllII);
    }
    
    protected float getDeathMaxRotation(final T llllllllllllllIIIllIIlIIllllIlIl) {
        return 90.0f;
    }
    
    protected float getSwingProgress(final T llllllllllllllIIIllIIlIlIIlIIlII, final float llllllllllllllIIIllIIlIlIIlIIIll) {
        return llllllllllllllIIIllIIlIlIIlIIlII.getSwingProgress(llllllllllllllIIIllIIlIlIIlIIIll);
    }
    
    protected boolean setBrightness(final T llllllllllllllIIIllIIlIlIlIIllll, final float llllllllllllllIIIllIIlIlIlIIlllI, final boolean llllllllllllllIIIllIIlIlIlIIllIl) {
        final float llllllllllllllIIIllIIlIlIlIllIII = llllllllllllllIIIllIIlIlIlIIllll.getBrightness();
        final int llllllllllllllIIIllIIlIlIlIlIlll = this.getColorMultiplier(llllllllllllllIIIllIIlIlIlIIllll, llllllllllllllIIIllIIlIlIlIllIII, llllllllllllllIIIllIIlIlIlIIlllI);
        final boolean llllllllllllllIIIllIIlIlIlIlIllI = (llllllllllllllIIIllIIlIlIlIlIlll >> 24 & 0xFF) > 0;
        final boolean llllllllllllllIIIllIIlIlIlIlIlIl = llllllllllllllIIIllIIlIlIlIIllll.hurtTime > 0 || llllllllllllllIIIllIIlIlIlIIllll.deathTime > 0;
        if (!llllllllllllllIIIllIIlIlIlIlIllI && !llllllllllllllIIIllIIlIlIlIlIlIl) {
            return false;
        }
        if (!llllllllllllllIIIllIIlIlIlIlIllI && !llllllllllllllIIIllIIlIlIlIIllIl) {
            return false;
        }
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
        GlStateManager.enableTexture2D();
        GlStateManager.glTexEnvi(8960, 8704, OpenGlHelper.GL_COMBINE);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_COMBINE_RGB, 8448);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_SOURCE0_RGB, OpenGlHelper.defaultTexUnit);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_SOURCE1_RGB, OpenGlHelper.GL_PRIMARY_COLOR);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_OPERAND0_RGB, 768);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_OPERAND1_RGB, 768);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_COMBINE_ALPHA, 7681);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_SOURCE0_ALPHA, OpenGlHelper.defaultTexUnit);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_OPERAND0_ALPHA, 770);
        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GlStateManager.enableTexture2D();
        GlStateManager.glTexEnvi(8960, 8704, OpenGlHelper.GL_COMBINE);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_COMBINE_RGB, OpenGlHelper.GL_INTERPOLATE);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_SOURCE0_RGB, OpenGlHelper.GL_CONSTANT);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_SOURCE1_RGB, OpenGlHelper.GL_PREVIOUS);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_SOURCE2_RGB, OpenGlHelper.GL_CONSTANT);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_OPERAND0_RGB, 768);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_OPERAND1_RGB, 768);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_OPERAND2_RGB, 770);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_COMBINE_ALPHA, 7681);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_SOURCE0_ALPHA, OpenGlHelper.GL_PREVIOUS);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_OPERAND0_ALPHA, 770);
        this.brightnessBuffer.position(0);
        if (llllllllllllllIIIllIIlIlIlIlIlIl) {
            this.brightnessBuffer.put(1.0f);
            this.brightnessBuffer.put(0.0f);
            this.brightnessBuffer.put(0.0f);
            this.brightnessBuffer.put(0.3f);
            if (Config.isShaders()) {
                Shaders.setEntityColor(1.0f, 0.0f, 0.0f, 0.3f);
            }
        }
        else {
            final float llllllllllllllIIIllIIlIlIlIlIlII = (llllllllllllllIIIllIIlIlIlIlIlll >> 24 & 0xFF) / 255.0f;
            final float llllllllllllllIIIllIIlIlIlIlIIll = (llllllllllllllIIIllIIlIlIlIlIlll >> 16 & 0xFF) / 255.0f;
            final float llllllllllllllIIIllIIlIlIlIlIIlI = (llllllllllllllIIIllIIlIlIlIlIlll >> 8 & 0xFF) / 255.0f;
            final float llllllllllllllIIIllIIlIlIlIlIIIl = (llllllllllllllIIIllIIlIlIlIlIlll & 0xFF) / 255.0f;
            this.brightnessBuffer.put(llllllllllllllIIIllIIlIlIlIlIIll);
            this.brightnessBuffer.put(llllllllllllllIIIllIIlIlIlIlIIlI);
            this.brightnessBuffer.put(llllllllllllllIIIllIIlIlIlIlIIIl);
            this.brightnessBuffer.put(1.0f - llllllllllllllIIIllIIlIlIlIlIlII);
            if (Config.isShaders()) {
                Shaders.setEntityColor(llllllllllllllIIIllIIlIlIlIlIIll, llllllllllllllIIIllIIlIlIlIlIIlI, llllllllllllllIIIllIIlIlIlIlIIIl, 1.0f - llllllllllllllIIIllIIlIlIlIlIlII);
            }
        }
        this.brightnessBuffer.flip();
        GlStateManager.glTexEnv(8960, 8705, this.brightnessBuffer);
        GlStateManager.setActiveTexture(OpenGlHelper.GL_TEXTURE2);
        GlStateManager.enableTexture2D();
        GlStateManager.bindTexture(RenderLivingBase.TEXTURE_BRIGHTNESS.getGlTextureId());
        GlStateManager.glTexEnvi(8960, 8704, OpenGlHelper.GL_COMBINE);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_COMBINE_RGB, 8448);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_SOURCE0_RGB, OpenGlHelper.GL_PREVIOUS);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_SOURCE1_RGB, OpenGlHelper.lightmapTexUnit);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_OPERAND0_RGB, 768);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_OPERAND1_RGB, 768);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_COMBINE_ALPHA, 7681);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_SOURCE0_ALPHA, OpenGlHelper.GL_PREVIOUS);
        GlStateManager.glTexEnvi(8960, OpenGlHelper.GL_OPERAND0_ALPHA, 770);
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
        return true;
    }
    
    protected void renderLayers(final T llllllllllllllIIIllIIlIlIIIIIIIl, final float llllllllllllllIIIllIIlIlIIIIlIll, final float llllllllllllllIIIllIIlIIllllllll, final float llllllllllllllIIIllIIlIIlllllllI, final float llllllllllllllIIIllIIlIIllllllIl, final float llllllllllllllIIIllIIlIIllllllII, final float llllllllllllllIIIllIIlIlIIIIIllI, final float llllllllllllllIIIllIIlIlIIIIIlIl) {
        for (final LayerRenderer<T> llllllllllllllIIIllIIlIlIIIIIlII : this.layerRenderers) {
            final boolean llllllllllllllIIIllIIlIlIIIIIIll = this.setBrightness(llllllllllllllIIIllIIlIlIIIIIIIl, llllllllllllllIIIllIIlIIlllllllI, llllllllllllllIIIllIIlIlIIIIIlII.shouldCombineTextures());
            llllllllllllllIIIllIIlIlIIIIIlII.doRenderLayer(llllllllllllllIIIllIIlIlIIIIIIIl, llllllllllllllIIIllIIlIlIIIIlIll, llllllllllllllIIIllIIlIIllllllll, llllllllllllllIIIllIIlIIlllllllI, llllllllllllllIIIllIIlIIllllllIl, llllllllllllllIIIllIIlIIllllllII, llllllllllllllIIIllIIlIlIIIIIllI, llllllllllllllIIIllIIlIlIIIIIlIl);
            if (llllllllllllllIIIllIIlIlIIIIIIll) {
                this.unsetBrightness();
            }
        }
    }
    
    protected boolean func_193115_c(final T llllllllllllllIIIllIIlIlIlllIlII) {
        return !llllllllllllllIIIllIIlIlIlllIlII.isInvisible() || this.renderOutlines;
    }
    
    public void transformHeldFull3DItemLayer() {
    }
    
    public RenderLivingBase(final RenderManager llllllllllllllIIIllIIlIlllllllIl, final ModelBase llllllllllllllIIIllIIlIlllllIlII, final float llllllllllllllIIIllIIlIllllllIlI) {
        super(llllllllllllllIIIllIIlIlllllllIl);
        this.brightnessBuffer = GLAllocation.createDirectFloatBuffer(4);
        this.layerRenderers = (List<LayerRenderer<T>>)Lists.newArrayList();
        this.mainModel = llllllllllllllIIIllIIlIlllllIlII;
        this.shadowSize = llllllllllllllIIIllIIlIllllllIlI;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$scoreboard$Team$EnumVisible() {
        final int[] $switch_TABLE$net$minecraft$scoreboard$Team$EnumVisible = RenderLivingBase.$SWITCH_TABLE$net$minecraft$scoreboard$Team$EnumVisible;
        if ($switch_TABLE$net$minecraft$scoreboard$Team$EnumVisible != null) {
            return $switch_TABLE$net$minecraft$scoreboard$Team$EnumVisible;
        }
        final long llllllllllllllIIIllIIlIIlIIlllIl = (Object)new int[Team.EnumVisible.values().length];
        try {
            llllllllllllllIIIllIIlIIlIIlllIl[Team.EnumVisible.ALWAYS.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllIIIllIIlIIlIIlllIl[Team.EnumVisible.HIDE_FOR_OTHER_TEAMS.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllllIIIllIIlIIlIIlllIl[Team.EnumVisible.HIDE_FOR_OWN_TEAM.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllllIIIllIIlIIlIIlllIl[Team.EnumVisible.NEVER.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return RenderLivingBase.$SWITCH_TABLE$net$minecraft$scoreboard$Team$EnumVisible = (int[])(Object)llllllllllllllIIIllIIlIIlIIlllIl;
    }
    
    public List<LayerRenderer<T>> getLayerRenderers() {
        return this.layerRenderers;
    }
    
    public void renderName(final T llllllllllllllIIIllIIlIIlllIIIll, final double llllllllllllllIIIllIIlIIllIllIIl, final double llllllllllllllIIIllIIlIIlllIIIIl, final double llllllllllllllIIIllIIlIIllIlIlll) {
        if (!Reflector.RenderLivingEvent_Specials_Pre_Constructor.exists() || !Reflector.postForgeBusEvent(Reflector.RenderLivingEvent_Specials_Pre_Constructor, llllllllllllllIIIllIIlIIlllIIIll, this, llllllllllllllIIIllIIlIIllIllIIl, llllllllllllllIIIllIIlIIlllIIIIl, llllllllllllllIIIllIIlIIllIlIlll)) {
            if (this.canRenderName(llllllllllllllIIIllIIlIIlllIIIll)) {
                final double llllllllllllllIIIllIIlIIllIlllll = llllllllllllllIIIllIIlIIlllIIIll.getDistanceSqToEntity(this.renderManager.renderViewEntity);
                final float llllllllllllllIIIllIIlIIllIllllI = llllllllllllllIIIllIIlIIlllIIIll.isSneaking() ? RenderLivingBase.NAME_TAG_RANGE_SNEAK : RenderLivingBase.NAME_TAG_RANGE;
                if (llllllllllllllIIIllIIlIIllIlllll < llllllllllllllIIIllIIlIIllIllllI * llllllllllllllIIIllIIlIIllIllllI) {
                    final EventNameTags llllllllllllllIIIllIIlIIllIlllIl = new EventNameTags(llllllllllllllIIIllIIlIIlllIIIll, llllllllllllllIIIllIIlIIlllIIIll.getDisplayName().getFormattedText());
                    llllllllllllllIIIllIIlIIllIlllIl.call();
                    if (llllllllllllllIIIllIIlIIllIlllIl.isCancelled()) {
                        return;
                    }
                    final String llllllllllllllIIIllIIlIIllIlllII = llllllllllllllIIIllIIlIIlllIIIll.getDisplayName().getFormattedText();
                    GlStateManager.alphaFunc(516, 0.1f);
                    this.renderEntityName(llllllllllllllIIIllIIlIIlllIIIll, llllllllllllllIIIllIIlIIllIllIIl, llllllllllllllIIIllIIlIIlllIIIIl, llllllllllllllIIIllIIlIIllIlIlll, llllllllllllllIIIllIIlIIllIlllII, llllllllllllllIIIllIIlIIllIlllll);
                }
            }
            if (Reflector.RenderLivingEvent_Specials_Post_Constructor.exists()) {
                Reflector.postForgeBusEvent(Reflector.RenderLivingEvent_Specials_Post_Constructor, llllllllllllllIIIllIIlIIlllIIIll, this, llllllllllllllIIIllIIlIIllIllIIl, llllllllllllllIIIllIIlIIlllIIIIl, llllllllllllllIIIllIIlIIllIlIlll);
            }
        }
    }
    
    protected void renderLivingAt(final T llllllllllllllIIIllIIlIlIIllllll, final double llllllllllllllIIIllIIlIlIIlllIll, final double llllllllllllllIIIllIIlIlIIllllIl, final double llllllllllllllIIIllIIlIlIIllllII) {
        GlStateManager.translate((float)llllllllllllllIIIllIIlIlIIlllIll, (float)llllllllllllllIIIllIIlIlIIllllIl, (float)llllllllllllllIIIllIIlIlIIllllII);
    }
    
    protected int getColorMultiplier(final T llllllllllllllIIIllIIlIIllllIIll, final float llllllllllllllIIIllIIlIIllllIIlI, final float llllllllllllllIIIllIIlIIllllIIIl) {
        return 0;
    }
    
    protected void unsetScoreTeamColor() {
        GlStateManager.enableLighting();
        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GlStateManager.enableTexture2D();
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
    }
    
    @Override
    protected boolean canRenderName(final T llllllllllllllIIIllIIlIIllIIIIll) {
        final EntityPlayerSP llllllllllllllIIIllIIlIIllIIlIIl = Minecraft.getMinecraft().player;
        final boolean llllllllllllllIIIllIIlIIllIIlIII = !llllllllllllllIIIllIIlIIllIIIIll.isInvisibleToPlayer(llllllllllllllIIIllIIlIIllIIlIIl);
        if (llllllllllllllIIIllIIlIIllIIIIll != llllllllllllllIIIllIIlIIllIIlIIl) {
            final Team llllllllllllllIIIllIIlIIllIIIlll = llllllllllllllIIIllIIlIIllIIIIll.getTeam();
            final Team llllllllllllllIIIllIIlIIllIIIllI = llllllllllllllIIIllIIlIIllIIlIIl.getTeam();
            if (llllllllllllllIIIllIIlIIllIIIlll != null) {
                final Team.EnumVisible llllllllllllllIIIllIIlIIllIIIlIl = llllllllllllllIIIllIIlIIllIIIlll.getNameTagVisibility();
                switch ($SWITCH_TABLE$net$minecraft$scoreboard$Team$EnumVisible()[llllllllllllllIIIllIIlIIllIIIlIl.ordinal()]) {
                    case 1: {
                        return llllllllllllllIIIllIIlIIllIIlIII;
                    }
                    case 2: {
                        return false;
                    }
                    case 3: {
                        return (llllllllllllllIIIllIIlIIllIIIllI == null) ? llllllllllllllIIIllIIlIIllIIlIII : (llllllllllllllIIIllIIlIIllIIIlll.isSameTeam(llllllllllllllIIIllIIlIIllIIIllI) && (llllllllllllllIIIllIIlIIllIIIlll.getSeeFriendlyInvisiblesEnabled() || llllllllllllllIIIllIIlIIllIIlIII));
                    }
                    case 4: {
                        return (llllllllllllllIIIllIIlIIllIIIllI == null) ? llllllllllllllIIIllIIlIIllIIlIII : (!llllllllllllllIIIllIIlIIllIIIlll.isSameTeam(llllllllllllllIIIllIIlIIllIIIllI) && llllllllllllllIIIllIIlIIllIIlIII);
                    }
                    default: {
                        return true;
                    }
                }
            }
        }
        return Minecraft.isGuiEnabled() && llllllllllllllIIIllIIlIIllIIIIll != this.renderManager.renderViewEntity && llllllllllllllIIIllIIlIIllIIlIII && !llllllllllllllIIIllIIlIIllIIIIll.isBeingRidden();
    }
    
    public ModelBase getMainModel() {
        return this.mainModel;
    }
    
    protected boolean setDoRenderBrightness(final T llllllllllllllIIIllIIlIlIllIlIlI, final float llllllllllllllIIIllIIlIlIllIlIIl) {
        return this.setBrightness(llllllllllllllIIIllIIlIlIllIlIlI, llllllllllllllIIIllIIlIlIllIlIIl, true);
    }
    
    protected float interpolateRotation(final float llllllllllllllIIIllIIlIllllIIIIl, final float llllllllllllllIIIllIIlIllllIIIII, final float llllllllllllllIIIllIIlIlllIlllll) {
        float llllllllllllllIIIllIIlIlllIllllI;
        for (llllllllllllllIIIllIIlIlllIllllI = llllllllllllllIIIllIIlIllllIIIII - llllllllllllllIIIllIIlIllllIIIIl; llllllllllllllIIIllIIlIlllIllllI < -180.0f; llllllllllllllIIIllIIlIlllIllllI += 360.0f) {}
        while (llllllllllllllIIIllIIlIlllIllllI >= 180.0f) {
            llllllllllllllIIIllIIlIlllIllllI -= 360.0f;
        }
        return llllllllllllllIIIllIIlIllllIIIIl + llllllllllllllIIIllIIlIlllIlllll * llllllllllllllIIIllIIlIlllIllllI;
    }
    
    public float prepareScale(final T llllllllllllllIIIllIIlIllIIllIll, final float llllllllllllllIIIllIIlIllIIllIlI) {
        GlStateManager.enableRescaleNormal();
        GlStateManager.scale(-1.0f, -1.0f, 1.0f);
        this.preRenderCallback(llllllllllllllIIIllIIlIllIIllIll, llllllllllllllIIIllIIlIllIIllIlI);
        final float llllllllllllllIIIllIIlIllIIlllIl = 0.0625f;
        GlStateManager.translate(0.0f, -1.501f, 0.0f);
        return 0.0625f;
    }
    
    protected boolean setScoreTeamColor(final T llllllllllllllIIIllIIlIllIIlIlll) {
        GlStateManager.disableLighting();
        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GlStateManager.disableTexture2D();
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
        return true;
    }
    
    static {
        LOGGER = LogManager.getLogger();
        TEXTURE_BRIGHTNESS = new DynamicTexture(16, 16);
        RenderLivingBase.NAME_TAG_RANGE = 64.0f;
        RenderLivingBase.NAME_TAG_RANGE_SNEAK = 32.0f;
        animateModelLiving = Boolean.getBoolean("animate.model.living");
        final int[] llllllllllllllIIIllIIllIIIIlIIIl = RenderLivingBase.TEXTURE_BRIGHTNESS.getTextureData();
        for (int llllllllllllllIIIllIIllIIIIlIIII = 0; llllllllllllllIIIllIIllIIIIlIIII < 256; ++llllllllllllllIIIllIIllIIIIlIIII) {
            llllllllllllllIIIllIIllIIIIlIIIl[llllllllllllllIIIllIIllIIIIlIIII] = -1;
        }
        RenderLivingBase.TEXTURE_BRIGHTNESS.updateDynamicTexture();
    }
    
    protected void rotateCorpse(final T llllllllllllllIIIllIIlIlIIlIlIll, final float llllllllllllllIIIllIIlIlIIllIIIl, final float llllllllllllllIIIllIIlIlIIllIIII, final float llllllllllllllIIIllIIlIlIIlIlIIl) {
        GlStateManager.rotate(180.0f - llllllllllllllIIIllIIlIlIIllIIII, 0.0f, 1.0f, 0.0f);
        if (llllllllllllllIIIllIIlIlIIlIlIll.deathTime > 0) {
            float llllllllllllllIIIllIIlIlIIlIlllI = (llllllllllllllIIIllIIlIlIIlIlIll.deathTime + llllllllllllllIIIllIIlIlIIlIlIIl - 1.0f) / 20.0f * 1.6f;
            llllllllllllllIIIllIIlIlIIlIlllI = MathHelper.sqrt(llllllllllllllIIIllIIlIlIIlIlllI);
            if (llllllllllllllIIIllIIlIlIIlIlllI > 1.0f) {
                llllllllllllllIIIllIIlIlIIlIlllI = 1.0f;
            }
            GlStateManager.rotate(llllllllllllllIIIllIIlIlIIlIlllI * this.getDeathMaxRotation(llllllllllllllIIIllIIlIlIIlIlIll), 0.0f, 0.0f, 1.0f);
        }
        else {
            final String llllllllllllllIIIllIIlIlIIlIllIl = TextFormatting.getTextWithoutFormattingCodes(llllllllllllllIIIllIIlIlIIlIlIll.getName());
            if (llllllllllllllIIIllIIlIlIIlIllIl != null && ("Dinnerbone".equals(llllllllllllllIIIllIIlIlIIlIllIl) || "Grumm".equals(llllllllllllllIIIllIIlIlIIlIllIl)) && (!(llllllllllllllIIIllIIlIlIIlIlIll instanceof EntityPlayer) || ((EntityPlayer)llllllllllllllIIIllIIlIlIIlIlIll).isWearing(EnumPlayerModelParts.CAPE))) {
                GlStateManager.translate(0.0f, llllllllllllllIIIllIIlIlIIlIlIll.height + 0.1f, 0.0f);
                GlStateManager.rotate(180.0f, 0.0f, 0.0f, 1.0f);
            }
        }
    }
}
