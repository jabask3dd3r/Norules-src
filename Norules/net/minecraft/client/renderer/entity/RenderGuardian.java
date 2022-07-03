package net.minecraft.client.renderer.entity;

import net.minecraft.entity.monster.*;
import net.minecraft.util.*;
import net.minecraft.client.model.*;
import net.minecraft.client.renderer.culling.*;
import net.minecraft.util.math.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;

public class RenderGuardian extends RenderLiving<EntityGuardian>
{
    private static final /* synthetic */ ResourceLocation GUARDIAN_BEAM_TEXTURE;
    private static final /* synthetic */ ResourceLocation GUARDIAN_TEXTURE;
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityGuardian llllllllllllllIIIIllIlIIIIllIIlI) {
        return RenderGuardian.GUARDIAN_TEXTURE;
    }
    
    public RenderGuardian(final RenderManager llllllllllllllIIIIllIlIIlllllIII) {
        super(llllllllllllllIIIIllIlIIlllllIII, new ModelGuardian(), 0.5f);
    }
    
    private Vec3d getPosition(final EntityLivingBase llllllllllllllIIIIllIlIIllIIllll, final double llllllllllllllIIIIllIlIIllIIlllI, final float llllllllllllllIIIIllIlIIllIIllIl) {
        final double llllllllllllllIIIIllIlIIllIlIIlI = llllllllllllllIIIIllIlIIllIIllll.lastTickPosX + (llllllllllllllIIIIllIlIIllIIllll.posX - llllllllllllllIIIIllIlIIllIIllll.lastTickPosX) * llllllllllllllIIIIllIlIIllIIllIl;
        final double llllllllllllllIIIIllIlIIllIlIIIl = llllllllllllllIIIIllIlIIllIIlllI + llllllllllllllIIIIllIlIIllIIllll.lastTickPosY + (llllllllllllllIIIIllIlIIllIIllll.posY - llllllllllllllIIIIllIlIIllIIllll.lastTickPosY) * llllllllllllllIIIIllIlIIllIIllIl;
        final double llllllllllllllIIIIllIlIIllIlIIII = llllllllllllllIIIIllIlIIllIIllll.lastTickPosZ + (llllllllllllllIIIIllIlIIllIIllll.posZ - llllllllllllllIIIIllIlIIllIIllll.lastTickPosZ) * llllllllllllllIIIIllIlIIllIIllIl;
        return new Vec3d(llllllllllllllIIIIllIlIIllIlIIlI, llllllllllllllIIIIllIlIIllIlIIIl, llllllllllllllIIIIllIlIIllIlIIII);
    }
    
    @Override
    public boolean shouldRender(final EntityGuardian llllllllllllllIIIIllIlIIlllIllIl, final ICamera llllllllllllllIIIIllIlIIlllIIIll, final double llllllllllllllIIIIllIlIIlllIIIlI, final double llllllllllllllIIIIllIlIIlllIIIIl, final double llllllllllllllIIIIllIlIIlllIlIIl) {
        if (super.shouldRender(llllllllllllllIIIIllIlIIlllIllIl, llllllllllllllIIIIllIlIIlllIIIll, llllllllllllllIIIIllIlIIlllIIIlI, llllllllllllllIIIIllIlIIlllIIIIl, llllllllllllllIIIIllIlIIlllIlIIl)) {
            return true;
        }
        if (llllllllllllllIIIIllIlIIlllIllIl.hasTargetedEntity()) {
            final EntityLivingBase llllllllllllllIIIIllIlIIlllIlIII = llllllllllllllIIIIllIlIIlllIllIl.getTargetedEntity();
            if (llllllllllllllIIIIllIlIIlllIlIII != null) {
                final Vec3d llllllllllllllIIIIllIlIIlllIIlll = this.getPosition(llllllllllllllIIIIllIlIIlllIlIII, llllllllllllllIIIIllIlIIlllIlIII.height * 0.5, 1.0f);
                final Vec3d llllllllllllllIIIIllIlIIlllIIllI = this.getPosition(llllllllllllllIIIIllIlIIlllIllIl, llllllllllllllIIIIllIlIIlllIllIl.getEyeHeight(), 1.0f);
                if (llllllllllllllIIIIllIlIIlllIIIll.isBoundingBoxInFrustum(new AxisAlignedBB(llllllllllllllIIIIllIlIIlllIIllI.xCoord, llllllllllllllIIIIllIlIIlllIIllI.yCoord, llllllllllllllIIIIllIlIIlllIIllI.zCoord, llllllllllllllIIIIllIlIIlllIIlll.xCoord, llllllllllllllIIIIllIlIIlllIIlll.yCoord, llllllllllllllIIIIllIlIIlllIIlll.zCoord))) {
                    return true;
                }
            }
        }
        return false;
    }
    
    @Override
    public void doRender(final EntityGuardian llllllllllllllIIIIllIlIIIllIIlII, final double llllllllllllllIIIIllIlIIlIIlIlIl, final double llllllllllllllIIIIllIlIIlIIlIlII, final double llllllllllllllIIIIllIlIIlIIlIIll, final float llllllllllllllIIIIllIlIIlIIlIIlI, final float llllllllllllllIIIIllIlIIlIIlIIIl) {
        super.doRender(llllllllllllllIIIIllIlIIIllIIlII, llllllllllllllIIIIllIlIIlIIlIlIl, llllllllllllllIIIIllIlIIlIIlIlII, llllllllllllllIIIIllIlIIlIIlIIll, llllllllllllllIIIIllIlIIlIIlIIlI, llllllllllllllIIIIllIlIIlIIlIIIl);
        final EntityLivingBase llllllllllllllIIIIllIlIIlIIlIIII = llllllllllllllIIIIllIlIIIllIIlII.getTargetedEntity();
        if (llllllllllllllIIIIllIlIIlIIlIIII != null) {
            final float llllllllllllllIIIIllIlIIlIIIllll = llllllllllllllIIIIllIlIIIllIIlII.getAttackAnimationScale(llllllllllllllIIIIllIlIIlIIlIIIl);
            final Tessellator llllllllllllllIIIIllIlIIlIIIlllI = Tessellator.getInstance();
            final BufferBuilder llllllllllllllIIIIllIlIIlIIIllIl = llllllllllllllIIIIllIlIIlIIIlllI.getBuffer();
            this.bindTexture(RenderGuardian.GUARDIAN_BEAM_TEXTURE);
            GlStateManager.glTexParameteri(3553, 10242, 10497);
            GlStateManager.glTexParameteri(3553, 10243, 10497);
            GlStateManager.disableLighting();
            GlStateManager.disableCull();
            GlStateManager.disableBlend();
            GlStateManager.depthMask(true);
            final float llllllllllllllIIIIllIlIIlIIIllII = 240.0f;
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0f, 240.0f);
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            final float llllllllllllllIIIIllIlIIlIIIlIll = llllllllllllllIIIIllIlIIIllIIlII.world.getTotalWorldTime() + llllllllllllllIIIIllIlIIlIIlIIIl;
            final float llllllllllllllIIIIllIlIIlIIIlIlI = llllllllllllllIIIIllIlIIlIIIlIll * 0.5f % 1.0f;
            final float llllllllllllllIIIIllIlIIlIIIlIIl = llllllllllllllIIIIllIlIIIllIIlII.getEyeHeight();
            GlStateManager.pushMatrix();
            GlStateManager.translate((float)llllllllllllllIIIIllIlIIlIIlIlIl, (float)llllllllllllllIIIIllIlIIlIIlIlII + llllllllllllllIIIIllIlIIlIIIlIIl, (float)llllllllllllllIIIIllIlIIlIIlIIll);
            final Vec3d llllllllllllllIIIIllIlIIlIIIlIII = this.getPosition(llllllllllllllIIIIllIlIIlIIlIIII, llllllllllllllIIIIllIlIIlIIlIIII.height * 0.5, llllllllllllllIIIIllIlIIlIIlIIIl);
            final Vec3d llllllllllllllIIIIllIlIIlIIIIlll = this.getPosition(llllllllllllllIIIIllIlIIIllIIlII, llllllllllllllIIIIllIlIIlIIIlIIl, llllllllllllllIIIIllIlIIlIIlIIIl);
            Vec3d llllllllllllllIIIIllIlIIlIIIIllI = llllllllllllllIIIIllIlIIlIIIlIII.subtract(llllllllllllllIIIIllIlIIlIIIIlll);
            final double llllllllllllllIIIIllIlIIlIIIIlIl = llllllllllllllIIIIllIlIIlIIIIllI.lengthVector() + 1.0;
            llllllllllllllIIIIllIlIIlIIIIllI = llllllllllllllIIIIllIlIIlIIIIllI.normalize();
            final float llllllllllllllIIIIllIlIIlIIIIlII = (float)Math.acos(llllllllllllllIIIIllIlIIlIIIIllI.yCoord);
            final float llllllllllllllIIIIllIlIIlIIIIIll = (float)Math.atan2(llllllllllllllIIIIllIlIIlIIIIllI.zCoord, llllllllllllllIIIIllIlIIlIIIIllI.xCoord);
            GlStateManager.rotate((1.5707964f + -llllllllllllllIIIIllIlIIlIIIIIll) * 57.295776f, 0.0f, 1.0f, 0.0f);
            GlStateManager.rotate(llllllllllllllIIIIllIlIIlIIIIlII * 57.295776f, 1.0f, 0.0f, 0.0f);
            final int llllllllllllllIIIIllIlIIlIIIIIlI = 1;
            final double llllllllllllllIIIIllIlIIlIIIIIIl = llllllllllllllIIIIllIlIIlIIIlIll * 0.05 * -1.5;
            llllllllllllllIIIIllIlIIlIIIllIl.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
            final float llllllllllllllIIIIllIlIIlIIIIIII = llllllllllllllIIIIllIlIIlIIIllll * llllllllllllllIIIIllIlIIlIIIllll;
            final int llllllllllllllIIIIllIlIIIlllllll = 64 + (int)(llllllllllllllIIIIllIlIIlIIIIIII * 191.0f);
            final int llllllllllllllIIIIllIlIIIllllllI = 32 + (int)(llllllllllllllIIIIllIlIIlIIIIIII * 191.0f);
            final int llllllllllllllIIIIllIlIIIlllllIl = 128 - (int)(llllllllllllllIIIIllIlIIlIIIIIII * 64.0f);
            final double llllllllllllllIIIIllIlIIIlllllII = 0.2;
            final double llllllllllllllIIIIllIlIIIllllIll = 0.282;
            final double llllllllllllllIIIIllIlIIIllllIlI = 0.0 + Math.cos(llllllllllllllIIIIllIlIIlIIIIIIl + 2.356194490192345) * 0.282;
            final double llllllllllllllIIIIllIlIIIllllIIl = 0.0 + Math.sin(llllllllllllllIIIIllIlIIlIIIIIIl + 2.356194490192345) * 0.282;
            final double llllllllllllllIIIIllIlIIIllllIII = 0.0 + Math.cos(llllllllllllllIIIIllIlIIlIIIIIIl + 0.7853981633974483) * 0.282;
            final double llllllllllllllIIIIllIlIIIlllIlll = 0.0 + Math.sin(llllllllllllllIIIIllIlIIlIIIIIIl + 0.7853981633974483) * 0.282;
            final double llllllllllllllIIIIllIlIIIlllIllI = 0.0 + Math.cos(llllllllllllllIIIIllIlIIlIIIIIIl + 3.9269908169872414) * 0.282;
            final double llllllllllllllIIIIllIlIIIlllIlIl = 0.0 + Math.sin(llllllllllllllIIIIllIlIIlIIIIIIl + 3.9269908169872414) * 0.282;
            final double llllllllllllllIIIIllIlIIIlllIlII = 0.0 + Math.cos(llllllllllllllIIIIllIlIIlIIIIIIl + 5.497787143782138) * 0.282;
            final double llllllllllllllIIIIllIlIIIlllIIll = 0.0 + Math.sin(llllllllllllllIIIIllIlIIlIIIIIIl + 5.497787143782138) * 0.282;
            final double llllllllllllllIIIIllIlIIIlllIIlI = 0.0 + Math.cos(llllllllllllllIIIIllIlIIlIIIIIIl + 3.141592653589793) * 0.2;
            final double llllllllllllllIIIIllIlIIIlllIIIl = 0.0 + Math.sin(llllllllllllllIIIIllIlIIlIIIIIIl + 3.141592653589793) * 0.2;
            final double llllllllllllllIIIIllIlIIIlllIIII = 0.0 + Math.cos(llllllllllllllIIIIllIlIIlIIIIIIl + 0.0) * 0.2;
            final double llllllllllllllIIIIllIlIIIllIllll = 0.0 + Math.sin(llllllllllllllIIIIllIlIIlIIIIIIl + 0.0) * 0.2;
            final double llllllllllllllIIIIllIlIIIllIlllI = 0.0 + Math.cos(llllllllllllllIIIIllIlIIlIIIIIIl + 1.5707963267948966) * 0.2;
            final double llllllllllllllIIIIllIlIIIllIllIl = 0.0 + Math.sin(llllllllllllllIIIIllIlIIlIIIIIIl + 1.5707963267948966) * 0.2;
            final double llllllllllllllIIIIllIlIIIllIllII = 0.0 + Math.cos(llllllllllllllIIIIllIlIIlIIIIIIl + 4.71238898038469) * 0.2;
            final double llllllllllllllIIIIllIlIIIllIlIll = 0.0 + Math.sin(llllllllllllllIIIIllIlIIlIIIIIIl + 4.71238898038469) * 0.2;
            final double llllllllllllllIIIIllIlIIIllIlIlI = 0.0;
            final double llllllllllllllIIIIllIlIIIllIlIIl = 0.4999;
            final double llllllllllllllIIIIllIlIIIllIlIII = -1.0f + llllllllllllllIIIIllIlIIlIIIlIlI;
            final double llllllllllllllIIIIllIlIIIllIIlll = llllllllllllllIIIIllIlIIlIIIIlIl * 2.5 + llllllllllllllIIIIllIlIIIllIlIII;
            llllllllllllllIIIIllIlIIlIIIllIl.pos(llllllllllllllIIIIllIlIIIlllIIlI, llllllllllllllIIIIllIlIIlIIIIlIl, llllllllllllllIIIIllIlIIIlllIIIl).tex(0.4999, llllllllllllllIIIIllIlIIIllIIlll).color(llllllllllllllIIIIllIlIIIlllllll, llllllllllllllIIIIllIlIIIllllllI, llllllllllllllIIIIllIlIIIlllllIl, 255).endVertex();
            llllllllllllllIIIIllIlIIlIIIllIl.pos(llllllllllllllIIIIllIlIIIlllIIlI, 0.0, llllllllllllllIIIIllIlIIIlllIIIl).tex(0.4999, llllllllllllllIIIIllIlIIIllIlIII).color(llllllllllllllIIIIllIlIIIlllllll, llllllllllllllIIIIllIlIIIllllllI, llllllllllllllIIIIllIlIIIlllllIl, 255).endVertex();
            llllllllllllllIIIIllIlIIlIIIllIl.pos(llllllllllllllIIIIllIlIIIlllIIII, 0.0, llllllllllllllIIIIllIlIIIllIllll).tex(0.0, llllllllllllllIIIIllIlIIIllIlIII).color(llllllllllllllIIIIllIlIIIlllllll, llllllllllllllIIIIllIlIIIllllllI, llllllllllllllIIIIllIlIIIlllllIl, 255).endVertex();
            llllllllllllllIIIIllIlIIlIIIllIl.pos(llllllllllllllIIIIllIlIIIlllIIII, llllllllllllllIIIIllIlIIlIIIIlIl, llllllllllllllIIIIllIlIIIllIllll).tex(0.0, llllllllllllllIIIIllIlIIIllIIlll).color(llllllllllllllIIIIllIlIIIlllllll, llllllllllllllIIIIllIlIIIllllllI, llllllllllllllIIIIllIlIIIlllllIl, 255).endVertex();
            llllllllllllllIIIIllIlIIlIIIllIl.pos(llllllllllllllIIIIllIlIIIllIlllI, llllllllllllllIIIIllIlIIlIIIIlIl, llllllllllllllIIIIllIlIIIllIllIl).tex(0.4999, llllllllllllllIIIIllIlIIIllIIlll).color(llllllllllllllIIIIllIlIIIlllllll, llllllllllllllIIIIllIlIIIllllllI, llllllllllllllIIIIllIlIIIlllllIl, 255).endVertex();
            llllllllllllllIIIIllIlIIlIIIllIl.pos(llllllllllllllIIIIllIlIIIllIlllI, 0.0, llllllllllllllIIIIllIlIIIllIllIl).tex(0.4999, llllllllllllllIIIIllIlIIIllIlIII).color(llllllllllllllIIIIllIlIIIlllllll, llllllllllllllIIIIllIlIIIllllllI, llllllllllllllIIIIllIlIIIlllllIl, 255).endVertex();
            llllllllllllllIIIIllIlIIlIIIllIl.pos(llllllllllllllIIIIllIlIIIllIllII, 0.0, llllllllllllllIIIIllIlIIIllIlIll).tex(0.0, llllllllllllllIIIIllIlIIIllIlIII).color(llllllllllllllIIIIllIlIIIlllllll, llllllllllllllIIIIllIlIIIllllllI, llllllllllllllIIIIllIlIIIlllllIl, 255).endVertex();
            llllllllllllllIIIIllIlIIlIIIllIl.pos(llllllllllllllIIIIllIlIIIllIllII, llllllllllllllIIIIllIlIIlIIIIlIl, llllllllllllllIIIIllIlIIIllIlIll).tex(0.0, llllllllllllllIIIIllIlIIIllIIlll).color(llllllllllllllIIIIllIlIIIlllllll, llllllllllllllIIIIllIlIIIllllllI, llllllllllllllIIIIllIlIIIlllllIl, 255).endVertex();
            double llllllllllllllIIIIllIlIIIllIIllI = 0.0;
            if (llllllllllllllIIIIllIlIIIllIIlII.ticksExisted % 2 == 0) {
                llllllllllllllIIIIllIlIIIllIIllI = 0.5;
            }
            llllllllllllllIIIIllIlIIlIIIllIl.pos(llllllllllllllIIIIllIlIIIllllIlI, llllllllllllllIIIIllIlIIlIIIIlIl, llllllllllllllIIIIllIlIIIllllIIl).tex(0.5, llllllllllllllIIIIllIlIIIllIIllI + 0.5).color(llllllllllllllIIIIllIlIIIlllllll, llllllllllllllIIIIllIlIIIllllllI, llllllllllllllIIIIllIlIIIlllllIl, 255).endVertex();
            llllllllllllllIIIIllIlIIlIIIllIl.pos(llllllllllllllIIIIllIlIIIllllIII, llllllllllllllIIIIllIlIIlIIIIlIl, llllllllllllllIIIIllIlIIIlllIlll).tex(1.0, llllllllllllllIIIIllIlIIIllIIllI + 0.5).color(llllllllllllllIIIIllIlIIIlllllll, llllllllllllllIIIIllIlIIIllllllI, llllllllllllllIIIIllIlIIIlllllIl, 255).endVertex();
            llllllllllllllIIIIllIlIIlIIIllIl.pos(llllllllllllllIIIIllIlIIIlllIlII, llllllllllllllIIIIllIlIIlIIIIlIl, llllllllllllllIIIIllIlIIIlllIIll).tex(1.0, llllllllllllllIIIIllIlIIIllIIllI).color(llllllllllllllIIIIllIlIIIlllllll, llllllllllllllIIIIllIlIIIllllllI, llllllllllllllIIIIllIlIIIlllllIl, 255).endVertex();
            llllllllllllllIIIIllIlIIlIIIllIl.pos(llllllllllllllIIIIllIlIIIlllIllI, llllllllllllllIIIIllIlIIlIIIIlIl, llllllllllllllIIIIllIlIIIlllIlIl).tex(0.5, llllllllllllllIIIIllIlIIIllIIllI).color(llllllllllllllIIIIllIlIIIlllllll, llllllllllllllIIIIllIlIIIllllllI, llllllllllllllIIIIllIlIIIlllllIl, 255).endVertex();
            llllllllllllllIIIIllIlIIlIIIlllI.draw();
            GlStateManager.popMatrix();
        }
    }
    
    static {
        GUARDIAN_TEXTURE = new ResourceLocation("textures/entity/guardian.png");
        GUARDIAN_BEAM_TEXTURE = new ResourceLocation("textures/entity/guardian_beam.png");
    }
}
