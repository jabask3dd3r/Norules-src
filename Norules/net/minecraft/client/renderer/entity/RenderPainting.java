package net.minecraft.client.renderer.entity;

import net.minecraft.entity.item.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;

public class RenderPainting extends Render<EntityPainting>
{
    private static final /* synthetic */ ResourceLocation KRISTOFFER_PAINTING_TEXTURE;
    
    @Override
    public void doRender(final EntityPainting llllllllllllllIIllIIIIlllIlIIIlI, final double llllllllllllllIIllIIIIlllIIllIII, final double llllllllllllllIIllIIIIlllIIlIlll, final double llllllllllllllIIllIIIIlllIIlIllI, final float llllllllllllllIIllIIIIlllIIlIlIl, final float llllllllllllllIIllIIIIlllIIlIlII) {
        GlStateManager.pushMatrix();
        GlStateManager.translate(llllllllllllllIIllIIIIlllIIllIII, llllllllllllllIIllIIIIlllIIlIlll, llllllllllllllIIllIIIIlllIIlIllI);
        GlStateManager.rotate(180.0f - llllllllllllllIIllIIIIlllIIlIlIl, 0.0f, 1.0f, 0.0f);
        GlStateManager.enableRescaleNormal();
        this.bindEntityTexture(llllllllllllllIIllIIIIlllIlIIIlI);
        final EntityPainting.EnumArt llllllllllllllIIllIIIIlllIIlllII = llllllllllllllIIllIIIIlllIlIIIlI.art;
        final float llllllllllllllIIllIIIIlllIIllIll = 0.0625f;
        GlStateManager.scale(0.0625f, 0.0625f, 0.0625f);
        if (this.renderOutlines) {
            GlStateManager.enableColorMaterial();
            GlStateManager.enableOutlineMode(this.getTeamColor(llllllllllllllIIllIIIIlllIlIIIlI));
        }
        this.renderPainting(llllllllllllllIIllIIIIlllIlIIIlI, llllllllllllllIIllIIIIlllIIlllII.sizeX, llllllllllllllIIllIIIIlllIIlllII.sizeY, llllllllllllllIIllIIIIlllIIlllII.offsetX, llllllllllllllIIllIIIIlllIIlllII.offsetY);
        if (this.renderOutlines) {
            GlStateManager.disableOutlineMode();
            GlStateManager.disableColorMaterial();
        }
        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
        super.doRender(llllllllllllllIIllIIIIlllIlIIIlI, llllllllllllllIIllIIIIlllIIllIII, llllllllllllllIIllIIIIlllIIlIlll, llllllllllllllIIllIIIIlllIIlIllI, llllllllllllllIIllIIIIlllIIlIlIl, llllllllllllllIIllIIIIlllIIlIlII);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityPainting llllllllllllllIIllIIIIlllIIlIIII) {
        return RenderPainting.KRISTOFFER_PAINTING_TEXTURE;
    }
    
    private void setLightmap(final EntityPainting llllllllllllllIIllIIIIllIIIlIlIl, final float llllllllllllllIIllIIIIllIIIlllll, final float llllllllllllllIIllIIIIllIIIllllI) {
        int llllllllllllllIIllIIIIllIIIlllIl = MathHelper.floor(llllllllllllllIIllIIIIllIIIlIlIl.posX);
        final int llllllllllllllIIllIIIIllIIIlllII = MathHelper.floor(llllllllllllllIIllIIIIllIIIlIlIl.posY + llllllllllllllIIllIIIIllIIIllllI / 16.0f);
        int llllllllllllllIIllIIIIllIIIllIll = MathHelper.floor(llllllllllllllIIllIIIIllIIIlIlIl.posZ);
        final EnumFacing llllllllllllllIIllIIIIllIIIllIlI = llllllllllllllIIllIIIIllIIIlIlIl.facingDirection;
        if (llllllllllllllIIllIIIIllIIIllIlI == EnumFacing.NORTH) {
            llllllllllllllIIllIIIIllIIIlllIl = MathHelper.floor(llllllllllllllIIllIIIIllIIIlIlIl.posX + llllllllllllllIIllIIIIllIIIlllll / 16.0f);
        }
        if (llllllllllllllIIllIIIIllIIIllIlI == EnumFacing.WEST) {
            llllllllllllllIIllIIIIllIIIllIll = MathHelper.floor(llllllllllllllIIllIIIIllIIIlIlIl.posZ - llllllllllllllIIllIIIIllIIIlllll / 16.0f);
        }
        if (llllllllllllllIIllIIIIllIIIllIlI == EnumFacing.SOUTH) {
            llllllllllllllIIllIIIIllIIIlllIl = MathHelper.floor(llllllllllllllIIllIIIIllIIIlIlIl.posX - llllllllllllllIIllIIIIllIIIlllll / 16.0f);
        }
        if (llllllllllllllIIllIIIIllIIIllIlI == EnumFacing.EAST) {
            llllllllllllllIIllIIIIllIIIllIll = MathHelper.floor(llllllllllllllIIllIIIIllIIIlIlIl.posZ + llllllllllllllIIllIIIIllIIIlllll / 16.0f);
        }
        final int llllllllllllllIIllIIIIllIIIllIIl = this.renderManager.worldObj.getCombinedLight(new BlockPos(llllllllllllllIIllIIIIllIIIlllIl, llllllllllllllIIllIIIIllIIIlllII, llllllllllllllIIllIIIIllIIIllIll), 0);
        final int llllllllllllllIIllIIIIllIIIllIII = llllllllllllllIIllIIIIllIIIllIIl % 65536;
        final int llllllllllllllIIllIIIIllIIIlIlll = llllllllllllllIIllIIIIllIIIllIIl / 65536;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)llllllllllllllIIllIIIIllIIIllIII, (float)llllllllllllllIIllIIIIllIIIlIlll);
        GlStateManager.color(1.0f, 1.0f, 1.0f);
    }
    
    private void renderPainting(final EntityPainting llllllllllllllIIllIIIIllIlIIllII, final int llllllllllllllIIllIIIIllIlIIlIll, final int llllllllllllllIIllIIIIllIlIIlIlI, final int llllllllllllllIIllIIIIllIlIIlIIl, final int llllllllllllllIIllIIIIllIlIIlIII) {
        final float llllllllllllllIIllIIIIllIllIlIII = -llllllllllllllIIllIIIIllIlIIlIll / 2.0f;
        final float llllllllllllllIIllIIIIllIllIIlll = -llllllllllllllIIllIIIIllIlIIlIlI / 2.0f;
        final float llllllllllllllIIllIIIIllIllIIllI = 0.5f;
        final float llllllllllllllIIllIIIIllIllIIlIl = 0.75f;
        final float llllllllllllllIIllIIIIllIllIIlII = 0.8125f;
        final float llllllllllllllIIllIIIIllIllIIIll = 0.0f;
        final float llllllllllllllIIllIIIIllIllIIIlI = 0.0625f;
        final float llllllllllllllIIllIIIIllIllIIIIl = 0.75f;
        final float llllllllllllllIIllIIIIllIllIIIII = 0.8125f;
        final float llllllllllllllIIllIIIIllIlIlllll = 0.001953125f;
        final float llllllllllllllIIllIIIIllIlIllllI = 0.001953125f;
        final float llllllllllllllIIllIIIIllIlIlllIl = 0.7519531f;
        final float llllllllllllllIIllIIIIllIlIlllII = 0.7519531f;
        final float llllllllllllllIIllIIIIllIlIllIll = 0.0f;
        final float llllllllllllllIIllIIIIllIlIllIlI = 0.0625f;
        for (int llllllllllllllIIllIIIIllIlIllIIl = 0; llllllllllllllIIllIIIIllIlIllIIl < llllllllllllllIIllIIIIllIlIIlIll / 16; ++llllllllllllllIIllIIIIllIlIllIIl) {
            for (int llllllllllllllIIllIIIIllIlIllIII = 0; llllllllllllllIIllIIIIllIlIllIII < llllllllllllllIIllIIIIllIlIIlIlI / 16; ++llllllllllllllIIllIIIIllIlIllIII) {
                final float llllllllllllllIIllIIIIllIlIlIlll = llllllllllllllIIllIIIIllIllIlIII + (llllllllllllllIIllIIIIllIlIllIIl + 1) * 16;
                final float llllllllllllllIIllIIIIllIlIlIllI = llllllllllllllIIllIIIIllIllIlIII + llllllllllllllIIllIIIIllIlIllIIl * 16;
                final float llllllllllllllIIllIIIIllIlIlIlIl = llllllllllllllIIllIIIIllIllIIlll + (llllllllllllllIIllIIIIllIlIllIII + 1) * 16;
                final float llllllllllllllIIllIIIIllIlIlIlII = llllllllllllllIIllIIIIllIllIIlll + llllllllllllllIIllIIIIllIlIllIII * 16;
                this.setLightmap(llllllllllllllIIllIIIIllIlIIllII, (llllllllllllllIIllIIIIllIlIlIlll + llllllllllllllIIllIIIIllIlIlIllI) / 2.0f, (llllllllllllllIIllIIIIllIlIlIlIl + llllllllllllllIIllIIIIllIlIlIlII) / 2.0f);
                final float llllllllllllllIIllIIIIllIlIlIIll = (llllllllllllllIIllIIIIllIlIIlIIl + llllllllllllllIIllIIIIllIlIIlIll - llllllllllllllIIllIIIIllIlIllIIl * 16) / 256.0f;
                final float llllllllllllllIIllIIIIllIlIlIIlI = (llllllllllllllIIllIIIIllIlIIlIIl + llllllllllllllIIllIIIIllIlIIlIll - (llllllllllllllIIllIIIIllIlIllIIl + 1) * 16) / 256.0f;
                final float llllllllllllllIIllIIIIllIlIlIIIl = (llllllllllllllIIllIIIIllIlIIlIII + llllllllllllllIIllIIIIllIlIIlIlI - llllllllllllllIIllIIIIllIlIllIII * 16) / 256.0f;
                final float llllllllllllllIIllIIIIllIlIlIIII = (llllllllllllllIIllIIIIllIlIIlIII + llllllllllllllIIllIIIIllIlIIlIlI - (llllllllllllllIIllIIIIllIlIllIII + 1) * 16) / 256.0f;
                final Tessellator llllllllllllllIIllIIIIllIlIIllll = Tessellator.getInstance();
                final BufferBuilder llllllllllllllIIllIIIIllIlIIlllI = llllllllllllllIIllIIIIllIlIIllll.getBuffer();
                llllllllllllllIIllIIIIllIlIIlllI.begin(7, DefaultVertexFormats.POSITION_TEX_NORMAL);
                llllllllllllllIIllIIIIllIlIIlllI.pos(llllllllllllllIIllIIIIllIlIlIlll, llllllllllllllIIllIIIIllIlIlIlII, -0.5).tex(llllllllllllllIIllIIIIllIlIlIIlI, llllllllllllllIIllIIIIllIlIlIIIl).normal(0.0f, 0.0f, -1.0f).endVertex();
                llllllllllllllIIllIIIIllIlIIlllI.pos(llllllllllllllIIllIIIIllIlIlIllI, llllllllllllllIIllIIIIllIlIlIlII, -0.5).tex(llllllllllllllIIllIIIIllIlIlIIll, llllllllllllllIIllIIIIllIlIlIIIl).normal(0.0f, 0.0f, -1.0f).endVertex();
                llllllllllllllIIllIIIIllIlIIlllI.pos(llllllllllllllIIllIIIIllIlIlIllI, llllllllllllllIIllIIIIllIlIlIlIl, -0.5).tex(llllllllllllllIIllIIIIllIlIlIIll, llllllllllllllIIllIIIIllIlIlIIII).normal(0.0f, 0.0f, -1.0f).endVertex();
                llllllllllllllIIllIIIIllIlIIlllI.pos(llllllllllllllIIllIIIIllIlIlIlll, llllllllllllllIIllIIIIllIlIlIlIl, -0.5).tex(llllllllllllllIIllIIIIllIlIlIIlI, llllllllllllllIIllIIIIllIlIlIIII).normal(0.0f, 0.0f, -1.0f).endVertex();
                llllllllllllllIIllIIIIllIlIIlllI.pos(llllllllllllllIIllIIIIllIlIlIlll, llllllllllllllIIllIIIIllIlIlIlIl, 0.5).tex(0.75, 0.0).normal(0.0f, 0.0f, 1.0f).endVertex();
                llllllllllllllIIllIIIIllIlIIlllI.pos(llllllllllllllIIllIIIIllIlIlIllI, llllllllllllllIIllIIIIllIlIlIlIl, 0.5).tex(0.8125, 0.0).normal(0.0f, 0.0f, 1.0f).endVertex();
                llllllllllllllIIllIIIIllIlIIlllI.pos(llllllllllllllIIllIIIIllIlIlIllI, llllllllllllllIIllIIIIllIlIlIlII, 0.5).tex(0.8125, 0.0625).normal(0.0f, 0.0f, 1.0f).endVertex();
                llllllllllllllIIllIIIIllIlIIlllI.pos(llllllllllllllIIllIIIIllIlIlIlll, llllllllllllllIIllIIIIllIlIlIlII, 0.5).tex(0.75, 0.0625).normal(0.0f, 0.0f, 1.0f).endVertex();
                llllllllllllllIIllIIIIllIlIIlllI.pos(llllllllllllllIIllIIIIllIlIlIlll, llllllllllllllIIllIIIIllIlIlIlIl, -0.5).tex(0.75, 0.001953125).normal(0.0f, 1.0f, 0.0f).endVertex();
                llllllllllllllIIllIIIIllIlIIlllI.pos(llllllllllllllIIllIIIIllIlIlIllI, llllllllllllllIIllIIIIllIlIlIlIl, -0.5).tex(0.8125, 0.001953125).normal(0.0f, 1.0f, 0.0f).endVertex();
                llllllllllllllIIllIIIIllIlIIlllI.pos(llllllllllllllIIllIIIIllIlIlIllI, llllllllllllllIIllIIIIllIlIlIlIl, 0.5).tex(0.8125, 0.001953125).normal(0.0f, 1.0f, 0.0f).endVertex();
                llllllllllllllIIllIIIIllIlIIlllI.pos(llllllllllllllIIllIIIIllIlIlIlll, llllllllllllllIIllIIIIllIlIlIlIl, 0.5).tex(0.75, 0.001953125).normal(0.0f, 1.0f, 0.0f).endVertex();
                llllllllllllllIIllIIIIllIlIIlllI.pos(llllllllllllllIIllIIIIllIlIlIlll, llllllllllllllIIllIIIIllIlIlIlII, 0.5).tex(0.75, 0.001953125).normal(0.0f, -1.0f, 0.0f).endVertex();
                llllllllllllllIIllIIIIllIlIIlllI.pos(llllllllllllllIIllIIIIllIlIlIllI, llllllllllllllIIllIIIIllIlIlIlII, 0.5).tex(0.8125, 0.001953125).normal(0.0f, -1.0f, 0.0f).endVertex();
                llllllllllllllIIllIIIIllIlIIlllI.pos(llllllllllllllIIllIIIIllIlIlIllI, llllllllllllllIIllIIIIllIlIlIlII, -0.5).tex(0.8125, 0.001953125).normal(0.0f, -1.0f, 0.0f).endVertex();
                llllllllllllllIIllIIIIllIlIIlllI.pos(llllllllllllllIIllIIIIllIlIlIlll, llllllllllllllIIllIIIIllIlIlIlII, -0.5).tex(0.75, 0.001953125).normal(0.0f, -1.0f, 0.0f).endVertex();
                llllllllllllllIIllIIIIllIlIIlllI.pos(llllllllllllllIIllIIIIllIlIlIlll, llllllllllllllIIllIIIIllIlIlIlIl, 0.5).tex(0.751953125, 0.0).normal(-1.0f, 0.0f, 0.0f).endVertex();
                llllllllllllllIIllIIIIllIlIIlllI.pos(llllllllllllllIIllIIIIllIlIlIlll, llllllllllllllIIllIIIIllIlIlIlII, 0.5).tex(0.751953125, 0.0625).normal(-1.0f, 0.0f, 0.0f).endVertex();
                llllllllllllllIIllIIIIllIlIIlllI.pos(llllllllllllllIIllIIIIllIlIlIlll, llllllllllllllIIllIIIIllIlIlIlII, -0.5).tex(0.751953125, 0.0625).normal(-1.0f, 0.0f, 0.0f).endVertex();
                llllllllllllllIIllIIIIllIlIIlllI.pos(llllllllllllllIIllIIIIllIlIlIlll, llllllllllllllIIllIIIIllIlIlIlIl, -0.5).tex(0.751953125, 0.0).normal(-1.0f, 0.0f, 0.0f).endVertex();
                llllllllllllllIIllIIIIllIlIIlllI.pos(llllllllllllllIIllIIIIllIlIlIllI, llllllllllllllIIllIIIIllIlIlIlIl, -0.5).tex(0.751953125, 0.0).normal(1.0f, 0.0f, 0.0f).endVertex();
                llllllllllllllIIllIIIIllIlIIlllI.pos(llllllllllllllIIllIIIIllIlIlIllI, llllllllllllllIIllIIIIllIlIlIlII, -0.5).tex(0.751953125, 0.0625).normal(1.0f, 0.0f, 0.0f).endVertex();
                llllllllllllllIIllIIIIllIlIIlllI.pos(llllllllllllllIIllIIIIllIlIlIllI, llllllllllllllIIllIIIIllIlIlIlII, 0.5).tex(0.751953125, 0.0625).normal(1.0f, 0.0f, 0.0f).endVertex();
                llllllllllllllIIllIIIIllIlIIlllI.pos(llllllllllllllIIllIIIIllIlIlIllI, llllllllllllllIIllIIIIllIlIlIlIl, 0.5).tex(0.751953125, 0.0).normal(1.0f, 0.0f, 0.0f).endVertex();
                llllllllllllllIIllIIIIllIlIIllll.draw();
            }
        }
    }
    
    public RenderPainting(final RenderManager llllllllllllllIIllIIIIlllIlIllll) {
        super(llllllllllllllIIllIIIIlllIlIllll);
    }
    
    static {
        KRISTOFFER_PAINTING_TEXTURE = new ResourceLocation("textures/painting/paintings_kristoffer_zetterstrand.png");
    }
}
