package net.minecraft.client.renderer.entity;

import net.minecraft.client.entity.*;
import net.minecraft.scoreboard.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.item.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.math.*;
import net.minecraft.client.model.*;
import net.minecraft.client.renderer.entity.layers.*;
import net.minecraft.entity.*;
import me.nrules.*;
import me.nrules.module.render.*;
import org.lwjgl.opengl.*;

public class RenderPlayer extends RenderLivingBase<AbstractClientPlayer>
{
    private final /* synthetic */ boolean smallArms;
    
    @Override
    public ModelPlayer getMainModel() {
        return (ModelPlayer)super.getMainModel();
    }
    
    public RenderPlayer(final RenderManager lllllllllllllIlIlIIllIIIllIlIIlI) {
        this(lllllllllllllIlIlIIllIIIllIlIIlI, false);
    }
    
    public ResourceLocation getEntityTexture(final AbstractClientPlayer lllllllllllllIlIlIIllIIIlIIlIIIl) {
        return lllllllllllllIlIlIIllIIIlIIlIIIl.getLocationSkin();
    }
    
    @Override
    protected void renderEntityName(final AbstractClientPlayer lllllllllllllIlIlIIllIIIIllllllI, final double lllllllllllllIlIlIIllIIIIlllIIll, double lllllllllllllIlIlIIllIIIIlllIIlI, final double lllllllllllllIlIlIIllIIIIlllIIIl, final String lllllllllllllIlIlIIllIIIIlllIIII, final double lllllllllllllIlIlIIllIIIIllIllll) {
        if (lllllllllllllIlIlIIllIIIIllIllll < 100.0) {
            final Scoreboard lllllllllllllIlIlIIllIIIIllllIII = lllllllllllllIlIlIIllIIIIllllllI.getWorldScoreboard();
            final ScoreObjective lllllllllllllIlIlIIllIIIIlllIlll = lllllllllllllIlIlIIllIIIIllllIII.getObjectiveInDisplaySlot(2);
            if (lllllllllllllIlIlIIllIIIIlllIlll != null) {
                final Score lllllllllllllIlIlIIllIIIIlllIllI = lllllllllllllIlIlIIllIIIIllllIII.getOrCreateScore(lllllllllllllIlIlIIllIIIIllllllI.getName(), lllllllllllllIlIlIIllIIIIlllIlll);
                this.renderLivingLabel(lllllllllllllIlIlIIllIIIIllllllI, String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlIlIIllIIIIlllIllI.getScorePoints())).append(" ").append(lllllllllllllIlIlIIllIIIIlllIlll.getDisplayName())), lllllllllllllIlIlIIllIIIIlllIIll, lllllllllllllIlIlIIllIIIIlllIIlI, lllllllllllllIlIlIIllIIIIlllIIIl, 64);
                lllllllllllllIlIlIIllIIIIlllIIlI += this.getFontRendererFromRenderManager().FONT_HEIGHT * 1.15f * 0.025f;
            }
        }
        super.renderEntityName(lllllllllllllIlIlIIllIIIIllllllI, lllllllllllllIlIlIIllIIIIlllIIll, lllllllllllllIlIlIIllIIIIlllIIlI, lllllllllllllIlIlIIllIIIIlllIIIl, lllllllllllllIlIlIIllIIIIlllIIII, lllllllllllllIlIlIIllIIIIllIllll);
    }
    
    private void setModelVisibilities(final AbstractClientPlayer lllllllllllllIlIlIIllIIIlIIllIll) {
        final ModelPlayer lllllllllllllIlIlIIllIIIlIlIIIll = this.getMainModel();
        if (lllllllllllllIlIlIIllIIIlIIllIll.isSpectator()) {
            lllllllllllllIlIlIIllIIIlIlIIIll.setInvisible(false);
            lllllllllllllIlIlIIllIIIlIlIIIll.bipedHead.showModel = true;
            lllllllllllllIlIlIIllIIIlIlIIIll.bipedHeadwear.showModel = true;
        }
        else {
            final ItemStack lllllllllllllIlIlIIllIIIlIlIIIlI = lllllllllllllIlIlIIllIIIlIIllIll.getHeldItemMainhand();
            final ItemStack lllllllllllllIlIlIIllIIIlIlIIIIl = lllllllllllllIlIlIIllIIIlIIllIll.getHeldItemOffhand();
            lllllllllllllIlIlIIllIIIlIlIIIll.setInvisible(true);
            lllllllllllllIlIlIIllIIIlIlIIIll.bipedHeadwear.showModel = lllllllllllllIlIlIIllIIIlIIllIll.isWearing(EnumPlayerModelParts.HAT);
            lllllllllllllIlIlIIllIIIlIlIIIll.bipedBodyWear.showModel = lllllllllllllIlIlIIllIIIlIIllIll.isWearing(EnumPlayerModelParts.JACKET);
            lllllllllllllIlIlIIllIIIlIlIIIll.bipedLeftLegwear.showModel = lllllllllllllIlIlIIllIIIlIIllIll.isWearing(EnumPlayerModelParts.LEFT_PANTS_LEG);
            lllllllllllllIlIlIIllIIIlIlIIIll.bipedRightLegwear.showModel = lllllllllllllIlIlIIllIIIlIIllIll.isWearing(EnumPlayerModelParts.RIGHT_PANTS_LEG);
            lllllllllllllIlIlIIllIIIlIlIIIll.bipedLeftArmwear.showModel = lllllllllllllIlIlIIllIIIlIIllIll.isWearing(EnumPlayerModelParts.LEFT_SLEEVE);
            lllllllllllllIlIlIIllIIIlIlIIIll.bipedRightArmwear.showModel = lllllllllllllIlIlIIllIIIlIIllIll.isWearing(EnumPlayerModelParts.RIGHT_SLEEVE);
            lllllllllllllIlIlIIllIIIlIlIIIll.isSneak = lllllllllllllIlIlIIllIIIlIIllIll.isSneaking();
            ModelBiped.ArmPose lllllllllllllIlIlIIllIIIlIlIIIII = ModelBiped.ArmPose.EMPTY;
            ModelBiped.ArmPose lllllllllllllIlIlIIllIIIlIIlllll = ModelBiped.ArmPose.EMPTY;
            if (!lllllllllllllIlIlIIllIIIlIlIIIlI.func_190926_b()) {
                lllllllllllllIlIlIIllIIIlIlIIIII = ModelBiped.ArmPose.ITEM;
                if (lllllllllllllIlIlIIllIIIlIIllIll.getItemInUseCount() > 0) {
                    final EnumAction lllllllllllllIlIlIIllIIIlIIllllI = lllllllllllllIlIlIIllIIIlIlIIIlI.getItemUseAction();
                    if (lllllllllllllIlIlIIllIIIlIIllllI == EnumAction.BLOCK) {
                        lllllllllllllIlIlIIllIIIlIlIIIII = ModelBiped.ArmPose.BLOCK;
                    }
                    else if (lllllllllllllIlIlIIllIIIlIIllllI == EnumAction.BOW) {
                        lllllllllllllIlIlIIllIIIlIlIIIII = ModelBiped.ArmPose.BOW_AND_ARROW;
                    }
                }
            }
            if (!lllllllllllllIlIlIIllIIIlIlIIIIl.func_190926_b()) {
                lllllllllllllIlIlIIllIIIlIIlllll = ModelBiped.ArmPose.ITEM;
                if (lllllllllllllIlIlIIllIIIlIIllIll.getItemInUseCount() > 0) {
                    final EnumAction lllllllllllllIlIlIIllIIIlIIlllIl = lllllllllllllIlIlIIllIIIlIlIIIIl.getItemUseAction();
                    if (lllllllllllllIlIlIIllIIIlIIlllIl == EnumAction.BLOCK) {
                        lllllllllllllIlIlIIllIIIlIIlllll = ModelBiped.ArmPose.BLOCK;
                    }
                }
            }
            if (lllllllllllllIlIlIIllIIIlIIllIll.getPrimaryHand() == EnumHandSide.RIGHT) {
                lllllllllllllIlIlIIllIIIlIlIIIll.rightArmPose = lllllllllllllIlIlIIllIIIlIlIIIII;
                lllllllllllllIlIlIIllIIIlIlIIIll.leftArmPose = lllllllllllllIlIlIIllIIIlIIlllll;
            }
            else {
                lllllllllllllIlIlIIllIIIlIlIIIll.rightArmPose = lllllllllllllIlIlIIllIIIlIIlllll;
                lllllllllllllIlIlIIllIIIlIlIIIll.leftArmPose = lllllllllllllIlIlIIllIIIlIlIIIII;
            }
        }
    }
    
    @Override
    protected void rotateCorpse(final AbstractClientPlayer lllllllllllllIlIlIIllIIIIIllIIIl, final float lllllllllllllIlIlIIllIIIIIllIIII, final float lllllllllllllIlIlIIllIIIIIlIIIll, final float lllllllllllllIlIlIIllIIIIIlIlllI) {
        if (lllllllllllllIlIlIIllIIIIIllIIIl.isEntityAlive() && lllllllllllllIlIlIIllIIIIIllIIIl.isPlayerSleeping()) {
            GlStateManager.rotate(lllllllllllllIlIlIIllIIIIIllIIIl.getBedOrientationInDegrees(), 0.0f, 1.0f, 0.0f);
            GlStateManager.rotate(this.getDeathMaxRotation(lllllllllllllIlIlIIllIIIIIllIIIl), 0.0f, 0.0f, 1.0f);
            GlStateManager.rotate(270.0f, 0.0f, 1.0f, 0.0f);
        }
        else if (lllllllllllllIlIlIIllIIIIIllIIIl.isElytraFlying()) {
            super.rotateCorpse(lllllllllllllIlIlIIllIIIIIllIIIl, lllllllllllllIlIlIIllIIIIIllIIII, lllllllllllllIlIlIIllIIIIIlIIIll, lllllllllllllIlIlIIllIIIIIlIlllI);
            final float lllllllllllllIlIlIIllIIIIIlIllIl = lllllllllllllIlIlIIllIIIIIllIIIl.getTicksElytraFlying() + lllllllllllllIlIlIIllIIIIIlIlllI;
            final float lllllllllllllIlIlIIllIIIIIlIllII = MathHelper.clamp(lllllllllllllIlIlIIllIIIIIlIllIl * lllllllllllllIlIlIIllIIIIIlIllIl / 100.0f, 0.0f, 1.0f);
            GlStateManager.rotate(lllllllllllllIlIlIIllIIIIIlIllII * (-90.0f - lllllllllllllIlIlIIllIIIIIllIIIl.rotationPitch), 1.0f, 0.0f, 0.0f);
            final Vec3d lllllllllllllIlIlIIllIIIIIlIlIll = lllllllllllllIlIlIIllIIIIIllIIIl.getLook(lllllllllllllIlIlIIllIIIIIlIlllI);
            final double lllllllllllllIlIlIIllIIIIIlIlIlI = lllllllllllllIlIlIIllIIIIIllIIIl.motionX * lllllllllllllIlIlIIllIIIIIllIIIl.motionX + lllllllllllllIlIlIIllIIIIIllIIIl.motionZ * lllllllllllllIlIlIIllIIIIIllIIIl.motionZ;
            final double lllllllllllllIlIlIIllIIIIIlIlIIl = lllllllllllllIlIlIIllIIIIIlIlIll.xCoord * lllllllllllllIlIlIIllIIIIIlIlIll.xCoord + lllllllllllllIlIlIIllIIIIIlIlIll.zCoord * lllllllllllllIlIlIIllIIIIIlIlIll.zCoord;
            if (lllllllllllllIlIlIIllIIIIIlIlIlI > 0.0 && lllllllllllllIlIlIIllIIIIIlIlIIl > 0.0) {
                final double lllllllllllllIlIlIIllIIIIIlIlIII = (lllllllllllllIlIlIIllIIIIIllIIIl.motionX * lllllllllllllIlIlIIllIIIIIlIlIll.xCoord + lllllllllllllIlIlIIllIIIIIllIIIl.motionZ * lllllllllllllIlIlIIllIIIIIlIlIll.zCoord) / (Math.sqrt(lllllllllllllIlIlIIllIIIIIlIlIlI) * Math.sqrt(lllllllllllllIlIlIIllIIIIIlIlIIl));
                final double lllllllllllllIlIlIIllIIIIIlIIlll = lllllllllllllIlIlIIllIIIIIllIIIl.motionX * lllllllllllllIlIlIIllIIIIIlIlIll.zCoord - lllllllllllllIlIlIIllIIIIIllIIIl.motionZ * lllllllllllllIlIlIIllIIIIIlIlIll.xCoord;
                GlStateManager.rotate((float)(Math.signum(lllllllllllllIlIlIIllIIIIIlIIlll) * Math.acos(lllllllllllllIlIlIIllIIIIIlIlIII)) * 180.0f / 3.1415927f, 0.0f, 1.0f, 0.0f);
            }
        }
        else {
            super.rotateCorpse(lllllllllllllIlIlIIllIIIIIllIIIl, lllllllllllllIlIlIIllIIIIIllIIII, lllllllllllllIlIlIIllIIIIIlIIIll, lllllllllllllIlIlIIllIIIIIlIlllI);
        }
    }
    
    public RenderPlayer(final RenderManager lllllllllllllIlIlIIllIIIllIIlIlI, final boolean lllllllllllllIlIlIIllIIIllIIllII) {
        super(lllllllllllllIlIlIIllIIIllIIlIlI, new ModelPlayer(0.0f, lllllllllllllIlIlIIllIIIllIIllII), 0.5f);
        this.smallArms = lllllllllllllIlIlIIllIIIllIIllII;
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerBipedArmor(this));
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerHeldItem(this));
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerArrow(this));
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerDeadmau5Head(this));
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerCape(this));
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerCustomHead(this.getMainModel().bipedHead));
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerElytra(this));
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerEntityOnShoulder(lllllllllllllIlIlIIllIIIllIIlIlI));
    }
    
    @Override
    protected void renderLivingAt(final AbstractClientPlayer lllllllllllllIlIlIIllIIIIlIIIIlI, final double lllllllllllllIlIlIIllIIIIlIIIIIl, final double lllllllllllllIlIlIIllIIIIlIIIlIl, final double lllllllllllllIlIlIIllIIIIIllllll) {
        if (lllllllllllllIlIlIIllIIIIlIIIIlI.isEntityAlive() && lllllllllllllIlIlIIllIIIIlIIIIlI.isPlayerSleeping()) {
            super.renderLivingAt(lllllllllllllIlIlIIllIIIIlIIIIlI, lllllllllllllIlIlIIllIIIIlIIIIIl + lllllllllllllIlIlIIllIIIIlIIIIlI.renderOffsetX, lllllllllllllIlIlIIllIIIIlIIIlIl + lllllllllllllIlIlIIllIIIIlIIIIlI.renderOffsetY, lllllllllllllIlIlIIllIIIIIllllll + lllllllllllllIlIlIIllIIIIlIIIIlI.renderOffsetZ);
        }
        else {
            super.renderLivingAt(lllllllllllllIlIlIIllIIIIlIIIIlI, lllllllllllllIlIlIIllIIIIlIIIIIl, lllllllllllllIlIlIIllIIIIlIIIlIl, lllllllllllllIlIlIIllIIIIIllllll);
        }
    }
    
    @Override
    public void doRender(final AbstractClientPlayer lllllllllllllIlIlIIllIIIlIllllII, final double lllllllllllllIlIlIIllIIIlIlllIll, final double lllllllllllllIlIlIIllIIIlIllIIlI, final double lllllllllllllIlIlIIllIIIlIlllIIl, final float lllllllllllllIlIlIIllIIIlIllIIII, final float lllllllllllllIlIlIIllIIIlIlIllll) {
        if (!lllllllllllllIlIlIIllIIIlIllllII.isUser() || this.renderManager.renderViewEntity == lllllllllllllIlIlIIllIIIlIllllII) {
            double lllllllllllllIlIlIIllIIIlIllIllI = lllllllllllllIlIlIIllIIIlIllIIlI;
            if (lllllllllllllIlIlIIllIIIlIllllII.isSneaking()) {
                lllllllllllllIlIlIIllIIIlIllIllI = lllllllllllllIlIlIIllIIIlIllIIlI - 0.125;
            }
            if (Main.moduleManager.getModule(Chams.class).isToggled()) {
                GL11.glEnable(32823);
                GL11.glPolygonOffset(1.0f, -2000000.0f);
            }
            else {
                this.setModelVisibilities(lllllllllllllIlIlIIllIIIlIllllII);
            }
            this.setModelVisibilities(lllllllllllllIlIlIIllIIIlIllllII);
            GlStateManager.enableBlendProfile(GlStateManager.Profile.PLAYER_SKIN);
            super.doRender(lllllllllllllIlIlIIllIIIlIllllII, lllllllllllllIlIlIIllIIIlIlllIll, lllllllllllllIlIlIIllIIIlIllIllI, lllllllllllllIlIlIIllIIIlIlllIIl, lllllllllllllIlIlIIllIIIlIllIIII, lllllllllllllIlIlIIllIIIlIlIllll);
            GlStateManager.disableBlendProfile(GlStateManager.Profile.PLAYER_SKIN);
        }
    }
    
    @Override
    public void transformHeldFull3DItemLayer() {
        GlStateManager.translate(0.0f, 0.1875f, 0.0f);
    }
    
    public void renderRightArm(final AbstractClientPlayer lllllllllllllIlIlIIllIIIIllIIlIl) {
        final float lllllllllllllIlIlIIllIIIIllIIlII = 1.0f;
        GlStateManager.color(1.0f, 1.0f, 1.0f);
        final float lllllllllllllIlIlIIllIIIIllIIIll = 0.0625f;
        final ModelPlayer lllllllllllllIlIlIIllIIIIllIIIlI = this.getMainModel();
        this.setModelVisibilities(lllllllllllllIlIlIIllIIIIllIIlIl);
        GlStateManager.enableBlend();
        lllllllllllllIlIlIIllIIIIllIIIlI.swingProgress = 0.0f;
        lllllllllllllIlIlIIllIIIIllIIIlI.isSneak = false;
        lllllllllllllIlIlIIllIIIIllIIIlI.setRotationAngles(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f, lllllllllllllIlIlIIllIIIIllIIlIl);
        lllllllllllllIlIlIIllIIIIllIIIlI.bipedRightArm.rotateAngleX = 0.0f;
        lllllllllllllIlIlIIllIIIIllIIIlI.bipedRightArm.render(0.0625f);
        lllllllllllllIlIlIIllIIIIllIIIlI.bipedRightArmwear.rotateAngleX = 0.0f;
        lllllllllllllIlIlIIllIIIIllIIIlI.bipedRightArmwear.render(0.0625f);
        GlStateManager.disableBlend();
    }
    
    @Override
    protected void preRenderCallback(final AbstractClientPlayer lllllllllllllIlIlIIllIIIlIIIllIl, final float lllllllllllllIlIlIIllIIIlIIIllII) {
        final float lllllllllllllIlIlIIllIIIlIIIlIll = 0.9375f;
        GlStateManager.scale(0.9375f, 0.9375f, 0.9375f);
    }
    
    public void renderLeftArm(final AbstractClientPlayer lllllllllllllIlIlIIllIIIIlIlIIIl) {
        final float lllllllllllllIlIlIIllIIIIlIlIlIl = 1.0f;
        GlStateManager.color(1.0f, 1.0f, 1.0f);
        final float lllllllllllllIlIlIIllIIIIlIlIlII = 0.0625f;
        final ModelPlayer lllllllllllllIlIlIIllIIIIlIlIIll = this.getMainModel();
        this.setModelVisibilities(lllllllllllllIlIlIIllIIIIlIlIIIl);
        GlStateManager.enableBlend();
        lllllllllllllIlIlIIllIIIIlIlIIll.isSneak = false;
        lllllllllllllIlIlIIllIIIIlIlIIll.swingProgress = 0.0f;
        lllllllllllllIlIlIIllIIIIlIlIIll.setRotationAngles(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f, lllllllllllllIlIlIIllIIIIlIlIIIl);
        lllllllllllllIlIlIIllIIIIlIlIIll.bipedLeftArm.rotateAngleX = 0.0f;
        lllllllllllllIlIlIIllIIIIlIlIIll.bipedLeftArm.render(0.0625f);
        lllllllllllllIlIlIIllIIIIlIlIIll.bipedLeftArmwear.rotateAngleX = 0.0f;
        lllllllllllllIlIlIIllIIIIlIlIIll.bipedLeftArmwear.render(0.0625f);
        GlStateManager.disableBlend();
    }
}
