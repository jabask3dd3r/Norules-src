package net.minecraft.client.renderer.tileentity;

import java.nio.*;
import java.util.*;
import optifine.*;
import shadersmod.client.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.util.*;
import net.minecraft.tileentity.*;
import net.minecraft.client.renderer.*;

public class TileEntityEndPortalRenderer extends TileEntitySpecialRenderer<TileEntityEndPortal>
{
    private final /* synthetic */ FloatBuffer buffer;
    private static final /* synthetic */ FloatBuffer MODELVIEW;
    private static final /* synthetic */ FloatBuffer PROJECTION;
    private static final /* synthetic */ ResourceLocation END_SKY_TEXTURE;
    private static final /* synthetic */ Random RANDOM;
    private static final /* synthetic */ ResourceLocation END_PORTAL_TEXTURE;
    
    private FloatBuffer getBuffer(final float lllllllllllllIllIlIlIIIIIlIIIlII, final float lllllllllllllIllIlIlIIIIIlIIIIll, final float lllllllllllllIllIlIlIIIIIlIIIIlI, final float lllllllllllllIllIlIlIIIIIIllllII) {
        this.buffer.clear();
        this.buffer.put(lllllllllllllIllIlIlIIIIIlIIIlII).put(lllllllllllllIllIlIlIIIIIlIIIIll).put(lllllllllllllIllIlIlIIIIIlIIIIlI).put(lllllllllllllIllIlIlIIIIIIllllII);
        this.buffer.flip();
        return this.buffer;
    }
    
    @Override
    public void func_192841_a(final TileEntityEndPortal lllllllllllllIllIlIlIIIIIllIllII, final double lllllllllllllIllIlIlIIIIIlllllll, final double lllllllllllllIllIlIlIIIIIllIlIlI, final double lllllllllllllIllIlIlIIIIIlllllIl, final float lllllllllllllIllIlIlIIIIIllIlIII, final int lllllllllllllIllIlIlIIIIIllIIlll, final float lllllllllllllIllIlIlIIIIIllllIlI) {
        if (!Config.isShaders() || !ShadersRender.renderEndPortal(lllllllllllllIllIlIlIIIIIllIllII, lllllllllllllIllIlIlIIIIIlllllll, lllllllllllllIllIlIlIIIIIllIlIlI, lllllllllllllIllIlIlIIIIIlllllIl, lllllllllllllIllIlIlIIIIIllIlIII, lllllllllllllIllIlIlIIIIIllIIlll, this.func_191287_c())) {
            GlStateManager.disableLighting();
            TileEntityEndPortalRenderer.RANDOM.setSeed(31100L);
            GlStateManager.getFloat(2982, TileEntityEndPortalRenderer.MODELVIEW);
            GlStateManager.getFloat(2983, TileEntityEndPortalRenderer.PROJECTION);
            final double lllllllllllllIllIlIlIIIIIllllIIl = lllllllllllllIllIlIlIIIIIlllllll * lllllllllllllIllIlIlIIIIIlllllll + lllllllllllllIllIlIlIIIIIllIlIlI * lllllllllllllIllIlIlIIIIIllIlIlI + lllllllllllllIllIlIlIIIIIlllllIl * lllllllllllllIllIlIlIIIIIlllllIl;
            final int lllllllllllllIllIlIlIIIIIllllIII = this.func_191286_a(lllllllllllllIllIlIlIIIIIllllIIl);
            final float lllllllllllllIllIlIlIIIIIlllIlll = this.func_191287_c();
            boolean lllllllllllllIllIlIlIIIIIlllIllI = false;
            for (int lllllllllllllIllIlIlIIIIIlllIlIl = 0; lllllllllllllIllIlIlIIIIIlllIlIl < lllllllllllllIllIlIlIIIIIllllIII; ++lllllllllllllIllIlIlIIIIIlllIlIl) {
                GlStateManager.pushMatrix();
                float lllllllllllllIllIlIlIIIIIlllIlII = 2.0f / (18 - lllllllllllllIllIlIlIIIIIlllIlIl);
                if (lllllllllllllIllIlIlIIIIIlllIlIl == 0) {
                    this.bindTexture(TileEntityEndPortalRenderer.END_SKY_TEXTURE);
                    lllllllllllllIllIlIlIIIIIlllIlII = 0.15f;
                    GlStateManager.enableBlend();
                    GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
                }
                if (lllllllllllllIllIlIlIIIIIlllIlIl >= 1) {
                    this.bindTexture(TileEntityEndPortalRenderer.END_PORTAL_TEXTURE);
                    lllllllllllllIllIlIlIIIIIlllIllI = true;
                    Minecraft.getMinecraft().entityRenderer.func_191514_d(true);
                }
                if (lllllllllllllIllIlIlIIIIIlllIlIl == 1) {
                    GlStateManager.enableBlend();
                    GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE);
                }
                GlStateManager.texGen(GlStateManager.TexGen.S, 9216);
                GlStateManager.texGen(GlStateManager.TexGen.T, 9216);
                GlStateManager.texGen(GlStateManager.TexGen.R, 9216);
                GlStateManager.texGen(GlStateManager.TexGen.S, 9474, this.getBuffer(1.0f, 0.0f, 0.0f, 0.0f));
                GlStateManager.texGen(GlStateManager.TexGen.T, 9474, this.getBuffer(0.0f, 1.0f, 0.0f, 0.0f));
                GlStateManager.texGen(GlStateManager.TexGen.R, 9474, this.getBuffer(0.0f, 0.0f, 1.0f, 0.0f));
                GlStateManager.enableTexGenCoord(GlStateManager.TexGen.S);
                GlStateManager.enableTexGenCoord(GlStateManager.TexGen.T);
                GlStateManager.enableTexGenCoord(GlStateManager.TexGen.R);
                GlStateManager.popMatrix();
                GlStateManager.matrixMode(5890);
                GlStateManager.pushMatrix();
                GlStateManager.loadIdentity();
                GlStateManager.translate(0.5f, 0.5f, 0.0f);
                GlStateManager.scale(0.5f, 0.5f, 1.0f);
                final float lllllllllllllIllIlIlIIIIIlllIIll = (float)(lllllllllllllIllIlIlIIIIIlllIlIl + 1);
                GlStateManager.translate(17.0f / lllllllllllllIllIlIlIIIIIlllIIll, (2.0f + lllllllllllllIllIlIlIIIIIlllIIll / 1.5f) * (Minecraft.getSystemTime() % 800000.0f / 800000.0f), 0.0f);
                GlStateManager.rotate((lllllllllllllIllIlIlIIIIIlllIIll * lllllllllllllIllIlIlIIIIIlllIIll * 4321.0f + lllllllllllllIllIlIlIIIIIlllIIll * 9.0f) * 2.0f, 0.0f, 0.0f, 1.0f);
                GlStateManager.scale(4.5f - lllllllllllllIllIlIlIIIIIlllIIll / 4.0f, 4.5f - lllllllllllllIllIlIlIIIIIlllIIll / 4.0f, 1.0f);
                GlStateManager.multMatrix(TileEntityEndPortalRenderer.PROJECTION);
                GlStateManager.multMatrix(TileEntityEndPortalRenderer.MODELVIEW);
                final Tessellator lllllllllllllIllIlIlIIIIIlllIIlI = Tessellator.getInstance();
                final BufferBuilder lllllllllllllIllIlIlIIIIIlllIIIl = lllllllllllllIllIlIlIIIIIlllIIlI.getBuffer();
                lllllllllllllIllIlIlIIIIIlllIIIl.begin(7, DefaultVertexFormats.POSITION_COLOR);
                final float lllllllllllllIllIlIlIIIIIlllIIII = (TileEntityEndPortalRenderer.RANDOM.nextFloat() * 0.5f + 0.1f) * lllllllllllllIllIlIlIIIIIlllIlII;
                final float lllllllllllllIllIlIlIIIIIllIllll = (TileEntityEndPortalRenderer.RANDOM.nextFloat() * 0.5f + 0.4f) * lllllllllllllIllIlIlIIIIIlllIlII;
                final float lllllllllllllIllIlIlIIIIIllIlllI = (TileEntityEndPortalRenderer.RANDOM.nextFloat() * 0.5f + 0.5f) * lllllllllllllIllIlIlIIIIIlllIlII;
                if (lllllllllllllIllIlIlIIIIIllIllII.shouldRenderFace(EnumFacing.SOUTH)) {
                    lllllllllllllIllIlIlIIIIIlllIIIl.pos(lllllllllllllIllIlIlIIIIIlllllll, lllllllllllllIllIlIlIIIIIllIlIlI, lllllllllllllIllIlIlIIIIIlllllIl + 1.0).color(lllllllllllllIllIlIlIIIIIlllIIII, lllllllllllllIllIlIlIIIIIllIllll, lllllllllllllIllIlIlIIIIIllIlllI, 1.0f).endVertex();
                    lllllllllllllIllIlIlIIIIIlllIIIl.pos(lllllllllllllIllIlIlIIIIIlllllll + 1.0, lllllllllllllIllIlIlIIIIIllIlIlI, lllllllllllllIllIlIlIIIIIlllllIl + 1.0).color(lllllllllllllIllIlIlIIIIIlllIIII, lllllllllllllIllIlIlIIIIIllIllll, lllllllllllllIllIlIlIIIIIllIlllI, 1.0f).endVertex();
                    lllllllllllllIllIlIlIIIIIlllIIIl.pos(lllllllllllllIllIlIlIIIIIlllllll + 1.0, lllllllllllllIllIlIlIIIIIllIlIlI + 1.0, lllllllllllllIllIlIlIIIIIlllllIl + 1.0).color(lllllllllllllIllIlIlIIIIIlllIIII, lllllllllllllIllIlIlIIIIIllIllll, lllllllllllllIllIlIlIIIIIllIlllI, 1.0f).endVertex();
                    lllllllllllllIllIlIlIIIIIlllIIIl.pos(lllllllllllllIllIlIlIIIIIlllllll, lllllllllllllIllIlIlIIIIIllIlIlI + 1.0, lllllllllllllIllIlIlIIIIIlllllIl + 1.0).color(lllllllllllllIllIlIlIIIIIlllIIII, lllllllllllllIllIlIlIIIIIllIllll, lllllllllllllIllIlIlIIIIIllIlllI, 1.0f).endVertex();
                }
                if (lllllllllllllIllIlIlIIIIIllIllII.shouldRenderFace(EnumFacing.NORTH)) {
                    lllllllllllllIllIlIlIIIIIlllIIIl.pos(lllllllllllllIllIlIlIIIIIlllllll, lllllllllllllIllIlIlIIIIIllIlIlI + 1.0, lllllllllllllIllIlIlIIIIIlllllIl).color(lllllllllllllIllIlIlIIIIIlllIIII, lllllllllllllIllIlIlIIIIIllIllll, lllllllllllllIllIlIlIIIIIllIlllI, 1.0f).endVertex();
                    lllllllllllllIllIlIlIIIIIlllIIIl.pos(lllllllllllllIllIlIlIIIIIlllllll + 1.0, lllllllllllllIllIlIlIIIIIllIlIlI + 1.0, lllllllllllllIllIlIlIIIIIlllllIl).color(lllllllllllllIllIlIlIIIIIlllIIII, lllllllllllllIllIlIlIIIIIllIllll, lllllllllllllIllIlIlIIIIIllIlllI, 1.0f).endVertex();
                    lllllllllllllIllIlIlIIIIIlllIIIl.pos(lllllllllllllIllIlIlIIIIIlllllll + 1.0, lllllllllllllIllIlIlIIIIIllIlIlI, lllllllllllllIllIlIlIIIIIlllllIl).color(lllllllllllllIllIlIlIIIIIlllIIII, lllllllllllllIllIlIlIIIIIllIllll, lllllllllllllIllIlIlIIIIIllIlllI, 1.0f).endVertex();
                    lllllllllllllIllIlIlIIIIIlllIIIl.pos(lllllllllllllIllIlIlIIIIIlllllll, lllllllllllllIllIlIlIIIIIllIlIlI, lllllllllllllIllIlIlIIIIIlllllIl).color(lllllllllllllIllIlIlIIIIIlllIIII, lllllllllllllIllIlIlIIIIIllIllll, lllllllllllllIllIlIlIIIIIllIlllI, 1.0f).endVertex();
                }
                if (lllllllllllllIllIlIlIIIIIllIllII.shouldRenderFace(EnumFacing.EAST)) {
                    lllllllllllllIllIlIlIIIIIlllIIIl.pos(lllllllllllllIllIlIlIIIIIlllllll + 1.0, lllllllllllllIllIlIlIIIIIllIlIlI + 1.0, lllllllllllllIllIlIlIIIIIlllllIl).color(lllllllllllllIllIlIlIIIIIlllIIII, lllllllllllllIllIlIlIIIIIllIllll, lllllllllllllIllIlIlIIIIIllIlllI, 1.0f).endVertex();
                    lllllllllllllIllIlIlIIIIIlllIIIl.pos(lllllllllllllIllIlIlIIIIIlllllll + 1.0, lllllllllllllIllIlIlIIIIIllIlIlI + 1.0, lllllllllllllIllIlIlIIIIIlllllIl + 1.0).color(lllllllllllllIllIlIlIIIIIlllIIII, lllllllllllllIllIlIlIIIIIllIllll, lllllllllllllIllIlIlIIIIIllIlllI, 1.0f).endVertex();
                    lllllllllllllIllIlIlIIIIIlllIIIl.pos(lllllllllllllIllIlIlIIIIIlllllll + 1.0, lllllllllllllIllIlIlIIIIIllIlIlI, lllllllllllllIllIlIlIIIIIlllllIl + 1.0).color(lllllllllllllIllIlIlIIIIIlllIIII, lllllllllllllIllIlIlIIIIIllIllll, lllllllllllllIllIlIlIIIIIllIlllI, 1.0f).endVertex();
                    lllllllllllllIllIlIlIIIIIlllIIIl.pos(lllllllllllllIllIlIlIIIIIlllllll + 1.0, lllllllllllllIllIlIlIIIIIllIlIlI, lllllllllllllIllIlIlIIIIIlllllIl).color(lllllllllllllIllIlIlIIIIIlllIIII, lllllllllllllIllIlIlIIIIIllIllll, lllllllllllllIllIlIlIIIIIllIlllI, 1.0f).endVertex();
                }
                if (lllllllllllllIllIlIlIIIIIllIllII.shouldRenderFace(EnumFacing.WEST)) {
                    lllllllllllllIllIlIlIIIIIlllIIIl.pos(lllllllllllllIllIlIlIIIIIlllllll, lllllllllllllIllIlIlIIIIIllIlIlI, lllllllllllllIllIlIlIIIIIlllllIl).color(lllllllllllllIllIlIlIIIIIlllIIII, lllllllllllllIllIlIlIIIIIllIllll, lllllllllllllIllIlIlIIIIIllIlllI, 1.0f).endVertex();
                    lllllllllllllIllIlIlIIIIIlllIIIl.pos(lllllllllllllIllIlIlIIIIIlllllll, lllllllllllllIllIlIlIIIIIllIlIlI, lllllllllllllIllIlIlIIIIIlllllIl + 1.0).color(lllllllllllllIllIlIlIIIIIlllIIII, lllllllllllllIllIlIlIIIIIllIllll, lllllllllllllIllIlIlIIIIIllIlllI, 1.0f).endVertex();
                    lllllllllllllIllIlIlIIIIIlllIIIl.pos(lllllllllllllIllIlIlIIIIIlllllll, lllllllllllllIllIlIlIIIIIllIlIlI + 1.0, lllllllllllllIllIlIlIIIIIlllllIl + 1.0).color(lllllllllllllIllIlIlIIIIIlllIIII, lllllllllllllIllIlIlIIIIIllIllll, lllllllllllllIllIlIlIIIIIllIlllI, 1.0f).endVertex();
                    lllllllllllllIllIlIlIIIIIlllIIIl.pos(lllllllllllllIllIlIlIIIIIlllllll, lllllllllllllIllIlIlIIIIIllIlIlI + 1.0, lllllllllllllIllIlIlIIIIIlllllIl).color(lllllllllllllIllIlIlIIIIIlllIIII, lllllllllllllIllIlIlIIIIIllIllll, lllllllllllllIllIlIlIIIIIllIlllI, 1.0f).endVertex();
                }
                if (lllllllllllllIllIlIlIIIIIllIllII.shouldRenderFace(EnumFacing.DOWN)) {
                    lllllllllllllIllIlIlIIIIIlllIIIl.pos(lllllllllllllIllIlIlIIIIIlllllll, lllllllllllllIllIlIlIIIIIllIlIlI, lllllllllllllIllIlIlIIIIIlllllIl).color(lllllllllllllIllIlIlIIIIIlllIIII, lllllllllllllIllIlIlIIIIIllIllll, lllllllllllllIllIlIlIIIIIllIlllI, 1.0f).endVertex();
                    lllllllllllllIllIlIlIIIIIlllIIIl.pos(lllllllllllllIllIlIlIIIIIlllllll + 1.0, lllllllllllllIllIlIlIIIIIllIlIlI, lllllllllllllIllIlIlIIIIIlllllIl).color(lllllllllllllIllIlIlIIIIIlllIIII, lllllllllllllIllIlIlIIIIIllIllll, lllllllllllllIllIlIlIIIIIllIlllI, 1.0f).endVertex();
                    lllllllllllllIllIlIlIIIIIlllIIIl.pos(lllllllllllllIllIlIlIIIIIlllllll + 1.0, lllllllllllllIllIlIlIIIIIllIlIlI, lllllllllllllIllIlIlIIIIIlllllIl + 1.0).color(lllllllllllllIllIlIlIIIIIlllIIII, lllllllllllllIllIlIlIIIIIllIllll, lllllllllllllIllIlIlIIIIIllIlllI, 1.0f).endVertex();
                    lllllllllllllIllIlIlIIIIIlllIIIl.pos(lllllllllllllIllIlIlIIIIIlllllll, lllllllllllllIllIlIlIIIIIllIlIlI, lllllllllllllIllIlIlIIIIIlllllIl + 1.0).color(lllllllllllllIllIlIlIIIIIlllIIII, lllllllllllllIllIlIlIIIIIllIllll, lllllllllllllIllIlIlIIIIIllIlllI, 1.0f).endVertex();
                }
                if (lllllllllllllIllIlIlIIIIIllIllII.shouldRenderFace(EnumFacing.UP)) {
                    lllllllllllllIllIlIlIIIIIlllIIIl.pos(lllllllllllllIllIlIlIIIIIlllllll, lllllllllllllIllIlIlIIIIIllIlIlI + lllllllllllllIllIlIlIIIIIlllIlll, lllllllllllllIllIlIlIIIIIlllllIl + 1.0).color(lllllllllllllIllIlIlIIIIIlllIIII, lllllllllllllIllIlIlIIIIIllIllll, lllllllllllllIllIlIlIIIIIllIlllI, 1.0f).endVertex();
                    lllllllllllllIllIlIlIIIIIlllIIIl.pos(lllllllllllllIllIlIlIIIIIlllllll + 1.0, lllllllllllllIllIlIlIIIIIllIlIlI + lllllllllllllIllIlIlIIIIIlllIlll, lllllllllllllIllIlIlIIIIIlllllIl + 1.0).color(lllllllllllllIllIlIlIIIIIlllIIII, lllllllllllllIllIlIlIIIIIllIllll, lllllllllllllIllIlIlIIIIIllIlllI, 1.0f).endVertex();
                    lllllllllllllIllIlIlIIIIIlllIIIl.pos(lllllllllllllIllIlIlIIIIIlllllll + 1.0, lllllllllllllIllIlIlIIIIIllIlIlI + lllllllllllllIllIlIlIIIIIlllIlll, lllllllllllllIllIlIlIIIIIlllllIl).color(lllllllllllllIllIlIlIIIIIlllIIII, lllllllllllllIllIlIlIIIIIllIllll, lllllllllllllIllIlIlIIIIIllIlllI, 1.0f).endVertex();
                    lllllllllllllIllIlIlIIIIIlllIIIl.pos(lllllllllllllIllIlIlIIIIIlllllll, lllllllllllllIllIlIlIIIIIllIlIlI + lllllllllllllIllIlIlIIIIIlllIlll, lllllllllllllIllIlIlIIIIIlllllIl).color(lllllllllllllIllIlIlIIIIIlllIIII, lllllllllllllIllIlIlIIIIIllIllll, lllllllllllllIllIlIlIIIIIllIlllI, 1.0f).endVertex();
                }
                lllllllllllllIllIlIlIIIIIlllIIlI.draw();
                GlStateManager.popMatrix();
                GlStateManager.matrixMode(5888);
                this.bindTexture(TileEntityEndPortalRenderer.END_SKY_TEXTURE);
            }
            GlStateManager.disableBlend();
            GlStateManager.disableTexGenCoord(GlStateManager.TexGen.S);
            GlStateManager.disableTexGenCoord(GlStateManager.TexGen.T);
            GlStateManager.disableTexGenCoord(GlStateManager.TexGen.R);
            GlStateManager.enableLighting();
            if (lllllllllllllIllIlIlIIIIIlllIllI) {
                Minecraft.getMinecraft().entityRenderer.func_191514_d(false);
            }
        }
    }
    
    protected float func_191287_c() {
        return 0.75f;
    }
    
    protected int func_191286_a(final double lllllllllllllIllIlIlIIIIIlIIllIl) {
        int lllllllllllllIllIlIlIIIIIlIIlllI = 0;
        if (lllllllllllllIllIlIlIIIIIlIIllIl > 36864.0) {
            final int lllllllllllllIllIlIlIIIIIlIlIllI = 1;
        }
        else if (lllllllllllllIllIlIlIIIIIlIIllIl > 25600.0) {
            final int lllllllllllllIllIlIlIIIIIlIlIlIl = 3;
        }
        else if (lllllllllllllIllIlIlIIIIIlIIllIl > 16384.0) {
            final int lllllllllllllIllIlIlIIIIIlIlIlII = 5;
        }
        else if (lllllllllllllIllIlIlIIIIIlIIllIl > 9216.0) {
            final int lllllllllllllIllIlIlIIIIIlIlIIll = 7;
        }
        else if (lllllllllllllIllIlIlIIIIIlIIllIl > 4096.0) {
            final int lllllllllllllIllIlIlIIIIIlIlIIlI = 9;
        }
        else if (lllllllllllllIllIlIlIIIIIlIIllIl > 1024.0) {
            final int lllllllllllllIllIlIlIIIIIlIlIIIl = 11;
        }
        else if (lllllllllllllIllIlIlIIIIIlIIllIl > 576.0) {
            final int lllllllllllllIllIlIlIIIIIlIlIIII = 13;
        }
        else if (lllllllllllllIllIlIlIIIIIlIIllIl > 256.0) {
            final int lllllllllllllIllIlIlIIIIIlIIllll = 14;
        }
        else {
            lllllllllllllIllIlIlIIIIIlIIlllI = 15;
        }
        return lllllllllllllIllIlIlIIIIIlIIlllI;
    }
    
    static {
        END_SKY_TEXTURE = new ResourceLocation("textures/environment/end_sky.png");
        END_PORTAL_TEXTURE = new ResourceLocation("textures/entity/end_portal.png");
        RANDOM = new Random(31100L);
        MODELVIEW = GLAllocation.createDirectFloatBuffer(16);
        PROJECTION = GLAllocation.createDirectFloatBuffer(16);
    }
    
    public TileEntityEndPortalRenderer() {
        this.buffer = GLAllocation.createDirectFloatBuffer(16);
    }
}
