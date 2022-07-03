package net.minecraft.client.renderer.entity;

import net.minecraft.entity.projectile.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.client.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.player.*;
import net.minecraft.client.renderer.*;
import net.minecraft.item.*;
import net.minecraft.entity.*;

public class RenderFish extends Render<EntityFishHook>
{
    private static final /* synthetic */ ResourceLocation FISH_PARTICLES;
    
    @Override
    public void doRender(final EntityFishHook llllllllllllllllIlIlIIlllllIIllI, final double llllllllllllllllIlIlIIlllllIIlIl, final double llllllllllllllllIlIlIIlllIllIlIl, final double llllllllllllllllIlIlIIlllIllIlII, final float llllllllllllllllIlIlIIlllllIIIlI, final float llllllllllllllllIlIlIIlllIllIIlI) {
        final EntityPlayer llllllllllllllllIlIlIIlllllIIIII = llllllllllllllllIlIlIIlllllIIllI.func_190619_l();
        if (llllllllllllllllIlIlIIlllllIIIII != null && !this.renderOutlines) {
            GlStateManager.pushMatrix();
            GlStateManager.translate((float)llllllllllllllllIlIlIIlllllIIlIl, (float)llllllllllllllllIlIlIIlllIllIlIl, (float)llllllllllllllllIlIlIIlllIllIlII);
            GlStateManager.enableRescaleNormal();
            GlStateManager.scale(0.5f, 0.5f, 0.5f);
            this.bindEntityTexture(llllllllllllllllIlIlIIlllllIIllI);
            final Tessellator llllllllllllllllIlIlIIllllIlllll = Tessellator.getInstance();
            final BufferBuilder llllllllllllllllIlIlIIllllIllllI = llllllllllllllllIlIlIIllllIlllll.getBuffer();
            final int llllllllllllllllIlIlIIllllIlllIl = 1;
            final int llllllllllllllllIlIlIIllllIlllII = 2;
            final float llllllllllllllllIlIlIIllllIllIll = 0.0625f;
            final float llllllllllllllllIlIlIIllllIllIlI = 0.125f;
            final float llllllllllllllllIlIlIIllllIllIIl = 0.125f;
            final float llllllllllllllllIlIlIIllllIllIII = 0.1875f;
            final float llllllllllllllllIlIlIIllllIlIlll = 1.0f;
            final float llllllllllllllllIlIlIIllllIlIllI = 0.5f;
            final float llllllllllllllllIlIlIIllllIlIlIl = 0.5f;
            GlStateManager.rotate(180.0f - this.renderManager.playerViewY, 0.0f, 1.0f, 0.0f);
            GlStateManager.rotate(((this.renderManager.options.thirdPersonView == 2) ? -1 : 1) * -this.renderManager.playerViewX, 1.0f, 0.0f, 0.0f);
            if (this.renderOutlines) {
                GlStateManager.enableColorMaterial();
                GlStateManager.enableOutlineMode(this.getTeamColor(llllllllllllllllIlIlIIlllllIIllI));
            }
            llllllllllllllllIlIlIIllllIllllI.begin(7, DefaultVertexFormats.POSITION_TEX_NORMAL);
            llllllllllllllllIlIlIIllllIllllI.pos(-0.5, -0.5, 0.0).tex(0.0625, 0.1875).normal(0.0f, 1.0f, 0.0f).endVertex();
            llllllllllllllllIlIlIIllllIllllI.pos(0.5, -0.5, 0.0).tex(0.125, 0.1875).normal(0.0f, 1.0f, 0.0f).endVertex();
            llllllllllllllllIlIlIIllllIllllI.pos(0.5, 0.5, 0.0).tex(0.125, 0.125).normal(0.0f, 1.0f, 0.0f).endVertex();
            llllllllllllllllIlIlIIllllIllllI.pos(-0.5, 0.5, 0.0).tex(0.0625, 0.125).normal(0.0f, 1.0f, 0.0f).endVertex();
            llllllllllllllllIlIlIIllllIlllll.draw();
            if (this.renderOutlines) {
                GlStateManager.disableOutlineMode();
                GlStateManager.disableColorMaterial();
            }
            GlStateManager.disableRescaleNormal();
            GlStateManager.popMatrix();
            int llllllllllllllllIlIlIIllllIlIlII = (llllllllllllllllIlIlIIlllllIIIII.getPrimaryHand() == EnumHandSide.RIGHT) ? 1 : -1;
            final ItemStack llllllllllllllllIlIlIIllllIlIIll = llllllllllllllllIlIlIIlllllIIIII.getHeldItemMainhand();
            if (llllllllllllllllIlIlIIllllIlIIll.getItem() != Items.FISHING_ROD) {
                llllllllllllllllIlIlIIllllIlIlII = -llllllllllllllllIlIlIIllllIlIlII;
            }
            final float llllllllllllllllIlIlIIllllIlIIlI = llllllllllllllllIlIlIIlllllIIIII.getSwingProgress(llllllllllllllllIlIlIIlllIllIIlI);
            final float llllllllllllllllIlIlIIllllIlIIIl = MathHelper.sin(MathHelper.sqrt(llllllllllllllllIlIlIIllllIlIIlI) * 3.1415927f);
            final float llllllllllllllllIlIlIIllllIlIIII = (llllllllllllllllIlIlIIlllllIIIII.prevRenderYawOffset + (llllllllllllllllIlIlIIlllllIIIII.renderYawOffset - llllllllllllllllIlIlIIlllllIIIII.prevRenderYawOffset) * llllllllllllllllIlIlIIlllIllIIlI) * 0.017453292f;
            final double llllllllllllllllIlIlIIllllIIllll = MathHelper.sin(llllllllllllllllIlIlIIllllIlIIII);
            final double llllllllllllllllIlIlIIllllIIlllI = MathHelper.cos(llllllllllllllllIlIlIIllllIlIIII);
            final double llllllllllllllllIlIlIIllllIIllIl = llllllllllllllllIlIlIIllllIlIlII * 0.35;
            final double llllllllllllllllIlIlIIllllIIllII = 0.8;
            double llllllllllllllllIlIlIIllllIIlIlI;
            double llllllllllllllllIlIlIIllllIIlIII;
            double llllllllllllllllIlIlIIllllIIIllI;
            double llllllllllllllllIlIlIIllllIIIlII;
            if ((this.renderManager.options == null || this.renderManager.options.thirdPersonView <= 0) && llllllllllllllllIlIlIIlllllIIIII == Minecraft.getMinecraft().player) {
                float llllllllllllllllIlIlIIllllIIIIll = this.renderManager.options.fovSetting;
                llllllllllllllllIlIlIIllllIIIIll /= 100.0f;
                Vec3d llllllllllllllllIlIlIIllllIIIIlI = new Vec3d(llllllllllllllllIlIlIIllllIlIlII * -0.36 * llllllllllllllllIlIlIIllllIIIIll, -0.045 * llllllllllllllllIlIlIIllllIIIIll, 0.4);
                llllllllllllllllIlIlIIllllIIIIlI = llllllllllllllllIlIlIIllllIIIIlI.rotatePitch(-(llllllllllllllllIlIlIIlllllIIIII.prevRotationPitch + (llllllllllllllllIlIlIIlllllIIIII.rotationPitch - llllllllllllllllIlIlIIlllllIIIII.prevRotationPitch) * llllllllllllllllIlIlIIlllIllIIlI) * 0.017453292f);
                llllllllllllllllIlIlIIllllIIIIlI = llllllllllllllllIlIlIIllllIIIIlI.rotateYaw(-(llllllllllllllllIlIlIIlllllIIIII.prevRotationYaw + (llllllllllllllllIlIlIIlllllIIIII.rotationYaw - llllllllllllllllIlIlIIlllllIIIII.prevRotationYaw) * llllllllllllllllIlIlIIlllIllIIlI) * 0.017453292f);
                llllllllllllllllIlIlIIllllIIIIlI = llllllllllllllllIlIlIIllllIIIIlI.rotateYaw(llllllllllllllllIlIlIIllllIlIIIl * 0.5f);
                llllllllllllllllIlIlIIllllIIIIlI = llllllllllllllllIlIlIIllllIIIIlI.rotatePitch(-llllllllllllllllIlIlIIllllIlIIIl * 0.7f);
                final double llllllllllllllllIlIlIIllllIIlIll = llllllllllllllllIlIlIIlllllIIIII.prevPosX + (llllllllllllllllIlIlIIlllllIIIII.posX - llllllllllllllllIlIlIIlllllIIIII.prevPosX) * llllllllllllllllIlIlIIlllIllIIlI + llllllllllllllllIlIlIIllllIIIIlI.xCoord;
                final double llllllllllllllllIlIlIIllllIIlIIl = llllllllllllllllIlIlIIlllllIIIII.prevPosY + (llllllllllllllllIlIlIIlllllIIIII.posY - llllllllllllllllIlIlIIlllllIIIII.prevPosY) * llllllllllllllllIlIlIIlllIllIIlI + llllllllllllllllIlIlIIllllIIIIlI.yCoord;
                final double llllllllllllllllIlIlIIllllIIIlll = llllllllllllllllIlIlIIlllllIIIII.prevPosZ + (llllllllllllllllIlIlIIlllllIIIII.posZ - llllllllllllllllIlIlIIlllllIIIII.prevPosZ) * llllllllllllllllIlIlIIlllIllIIlI + llllllllllllllllIlIlIIllllIIIIlI.zCoord;
                final double llllllllllllllllIlIlIIllllIIIlIl = llllllllllllllllIlIlIIlllllIIIII.getEyeHeight();
            }
            else {
                llllllllllllllllIlIlIIllllIIlIlI = llllllllllllllllIlIlIIlllllIIIII.prevPosX + (llllllllllllllllIlIlIIlllllIIIII.posX - llllllllllllllllIlIlIIlllllIIIII.prevPosX) * llllllllllllllllIlIlIIlllIllIIlI - llllllllllllllllIlIlIIllllIIlllI * llllllllllllllllIlIlIIllllIIllIl - llllllllllllllllIlIlIIllllIIllll * 0.8;
                llllllllllllllllIlIlIIllllIIlIII = llllllllllllllllIlIlIIlllllIIIII.prevPosY + llllllllllllllllIlIlIIlllllIIIII.getEyeHeight() + (llllllllllllllllIlIlIIlllllIIIII.posY - llllllllllllllllIlIlIIlllllIIIII.prevPosY) * llllllllllllllllIlIlIIlllIllIIlI - 0.45;
                llllllllllllllllIlIlIIllllIIIllI = llllllllllllllllIlIlIIlllllIIIII.prevPosZ + (llllllllllllllllIlIlIIlllllIIIII.posZ - llllllllllllllllIlIlIIlllllIIIII.prevPosZ) * llllllllllllllllIlIlIIlllIllIIlI - llllllllllllllllIlIlIIllllIIllll * llllllllllllllllIlIlIIllllIIllIl + llllllllllllllllIlIlIIllllIIlllI * 0.8;
                llllllllllllllllIlIlIIllllIIIlII = (llllllllllllllllIlIlIIlllllIIIII.isSneaking() ? -0.1875 : 0.0);
            }
            final double llllllllllllllllIlIlIIllllIIIIIl = llllllllllllllllIlIlIIlllllIIllI.prevPosX + (llllllllllllllllIlIlIIlllllIIllI.posX - llllllllllllllllIlIlIIlllllIIllI.prevPosX) * llllllllllllllllIlIlIIlllIllIIlI;
            final double llllllllllllllllIlIlIIllllIIIIII = llllllllllllllllIlIlIIlllllIIllI.prevPosY + (llllllllllllllllIlIlIIlllllIIllI.posY - llllllllllllllllIlIlIIlllllIIllI.prevPosY) * llllllllllllllllIlIlIIlllIllIIlI + 0.25;
            final double llllllllllllllllIlIlIIlllIllllll = llllllllllllllllIlIlIIlllllIIllI.prevPosZ + (llllllllllllllllIlIlIIlllllIIllI.posZ - llllllllllllllllIlIlIIlllllIIllI.prevPosZ) * llllllllllllllllIlIlIIlllIllIIlI;
            final double llllllllllllllllIlIlIIlllIlllllI = (float)(llllllllllllllllIlIlIIllllIIlIlI - llllllllllllllllIlIlIIllllIIIIIl);
            final double llllllllllllllllIlIlIIlllIllllIl = (float)(llllllllllllllllIlIlIIllllIIlIII - llllllllllllllllIlIlIIllllIIIIII) + llllllllllllllllIlIlIIllllIIIlII;
            final double llllllllllllllllIlIlIIlllIllllII = (float)(llllllllllllllllIlIlIIllllIIIllI - llllllllllllllllIlIlIIlllIllllll);
            GlStateManager.disableTexture2D();
            GlStateManager.disableLighting();
            llllllllllllllllIlIlIIllllIllllI.begin(3, DefaultVertexFormats.POSITION_COLOR);
            final int llllllllllllllllIlIlIIlllIlllIll = 16;
            for (int llllllllllllllllIlIlIIlllIlllIlI = 0; llllllllllllllllIlIlIIlllIlllIlI <= 16; ++llllllllllllllllIlIlIIlllIlllIlI) {
                final float llllllllllllllllIlIlIIlllIlllIIl = llllllllllllllllIlIlIIlllIlllIlI / 16.0f;
                llllllllllllllllIlIlIIllllIllllI.pos(llllllllllllllllIlIlIIlllllIIlIl + llllllllllllllllIlIlIIlllIlllllI * llllllllllllllllIlIlIIlllIlllIIl, llllllllllllllllIlIlIIlllIllIlIl + llllllllllllllllIlIlIIlllIllllIl * (llllllllllllllllIlIlIIlllIlllIIl * llllllllllllllllIlIlIIlllIlllIIl + llllllllllllllllIlIlIIlllIlllIIl) * 0.5 + 0.25, llllllllllllllllIlIlIIlllIllIlII + llllllllllllllllIlIlIIlllIllllII * llllllllllllllllIlIlIIlllIlllIIl).color(0, 0, 0, 255).endVertex();
            }
            llllllllllllllllIlIlIIllllIlllll.draw();
            GlStateManager.enableLighting();
            GlStateManager.enableTexture2D();
            super.doRender(llllllllllllllllIlIlIIlllllIIllI, llllllllllllllllIlIlIIlllllIIlIl, llllllllllllllllIlIlIIlllIllIlIl, llllllllllllllllIlIlIIlllIllIlII, llllllllllllllllIlIlIIlllllIIIlI, llllllllllllllllIlIlIIlllIllIIlI);
        }
    }
    
    static {
        FISH_PARTICLES = new ResourceLocation("textures/particle/particles.png");
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityFishHook llllllllllllllllIlIlIIlllIIIllIl) {
        return RenderFish.FISH_PARTICLES;
    }
    
    public RenderFish(final RenderManager llllllllllllllllIlIlIlIIIIIlIIlI) {
        super(llllllllllllllllIlIlIlIIIIIlIIlI);
    }
}
