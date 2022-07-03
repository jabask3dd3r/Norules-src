package net.minecraft.client.renderer.tileentity;

import net.minecraft.util.*;
import net.minecraft.tileentity.*;
import java.util.*;
import optifine.*;
import shadersmod.client.*;
import net.minecraft.util.math.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.client.renderer.*;

public class TileEntityBeaconRenderer extends TileEntitySpecialRenderer<TileEntityBeacon>
{
    public static final /* synthetic */ ResourceLocation TEXTURE_BEACON_BEAM;
    
    @Override
    public boolean isGlobalRenderer(final TileEntityBeacon llllllllllllllllIIllIIIIllIlIIlI) {
        return true;
    }
    
    public void renderBeacon(final double llllllllllllllllIIllIIIlIlIllIlI, final double llllllllllllllllIIllIIIlIlIllIIl, final double llllllllllllllllIIllIIIlIllIIlII, final double llllllllllllllllIIllIIIlIllIIIll, final double llllllllllllllllIIllIIIlIlIlIllI, final List<TileEntityBeacon.BeamSegment> llllllllllllllllIIllIIIlIlIlIlIl, final double llllllllllllllllIIllIIIlIlIlIlII) {
        if (llllllllllllllllIIllIIIlIlIlIllI > 0.0 && llllllllllllllllIIllIIIlIlIlIlIl.size() > 0) {
            if (Config.isShaders()) {
                Shaders.beginBeacon();
            }
            GlStateManager.alphaFunc(516, 0.1f);
            this.bindTexture(TileEntityBeaconRenderer.TEXTURE_BEACON_BEAM);
            if (llllllllllllllllIIllIIIlIlIlIllI > 0.0) {
                GlStateManager.disableFog();
                int llllllllllllllllIIllIIIlIlIlllll = 0;
                for (int llllllllllllllllIIllIIIlIlIllllI = 0; llllllllllllllllIIllIIIlIlIllllI < llllllllllllllllIIllIIIlIlIlIlIl.size(); ++llllllllllllllllIIllIIIlIlIllllI) {
                    final TileEntityBeacon.BeamSegment llllllllllllllllIIllIIIlIlIlllIl = llllllllllllllllIIllIIIlIlIlIlIl.get(llllllllllllllllIIllIIIlIlIllllI);
                    renderBeamSegment(llllllllllllllllIIllIIIlIlIllIlI, llllllllllllllllIIllIIIlIlIllIIl, llllllllllllllllIIllIIIlIllIIlII, llllllllllllllllIIllIIIlIllIIIll, llllllllllllllllIIllIIIlIlIlIllI, llllllllllllllllIIllIIIlIlIlIlII, llllllllllllllllIIllIIIlIlIlllll, llllllllllllllllIIllIIIlIlIlllIl.getHeight(), llllllllllllllllIIllIIIlIlIlllIl.getColors());
                    llllllllllllllllIIllIIIlIlIlllll += llllllllllllllllIIllIIIlIlIlllIl.getHeight();
                }
                GlStateManager.enableFog();
            }
            if (Config.isShaders()) {
                Shaders.endBeacon();
            }
        }
    }
    
    static {
        TEXTURE_BEACON_BEAM = new ResourceLocation("textures/entity/beacon_beam.png");
    }
    
    @Override
    public void func_192841_a(final TileEntityBeacon llllllllllllllllIIllIIIlIlllIlll, final double llllllllllllllllIIllIIIlIllllllI, final double llllllllllllllllIIllIIIlIlllIlIl, final double llllllllllllllllIIllIIIlIlllIlII, final float llllllllllllllllIIllIIIlIllllIll, final int llllllllllllllllIIllIIIlIllllIlI, final float llllllllllllllllIIllIIIlIllllIIl) {
        this.renderBeacon(llllllllllllllllIIllIIIlIllllllI, llllllllllllllllIIllIIIlIlllIlIl, llllllllllllllllIIllIIIlIlllIlII, llllllllllllllllIIllIIIlIllllIll, llllllllllllllllIIllIIIlIlllIlll.shouldBeamRender(), llllllllllllllllIIllIIIlIlllIlll.getBeamSegments(), (double)llllllllllllllllIIllIIIlIlllIlll.getWorld().getTotalWorldTime());
    }
    
    public static void renderBeamSegment(final double llllllllllllllllIIllIIIlIIllllll, final double llllllllllllllllIIllIIIlIlIIIlll, final double llllllllllllllllIIllIIIlIIllllIl, final double llllllllllllllllIIllIIIlIlIIIlIl, final double llllllllllllllllIIllIIIlIlIIIlII, final double llllllllllllllllIIllIIIlIlIIIIll, final int llllllllllllllllIIllIIIlIlIIIIlI, final int llllllllllllllllIIllIIIlIlIIIIIl, final float[] llllllllllllllllIIllIIIlIIllIlll) {
        renderBeamSegment(llllllllllllllllIIllIIIlIIllllll, llllllllllllllllIIllIIIlIlIIIlll, llllllllllllllllIIllIIIlIIllllIl, llllllllllllllllIIllIIIlIlIIIlIl, llllllllllllllllIIllIIIlIlIIIlII, llllllllllllllllIIllIIIlIlIIIIll, llllllllllllllllIIllIIIlIlIIIIlI, llllllllllllllllIIllIIIlIlIIIIIl, llllllllllllllllIIllIIIlIIllIlll, 0.2, 0.25);
    }
    
    public static void renderBeamSegment(final double llllllllllllllllIIllIIIIllllIlII, final double llllllllllllllllIIllIIIIllllIIll, final double llllllllllllllllIIllIIIlIIIlIIll, final double llllllllllllllllIIllIIIlIIIlIIlI, final double llllllllllllllllIIllIIIIllllIIII, final double llllllllllllllllIIllIIIIlllIllll, final int llllllllllllllllIIllIIIIlllIlllI, final int llllllllllllllllIIllIIIlIIIIlllI, final float[] llllllllllllllllIIllIIIIlllIllII, final double llllllllllllllllIIllIIIIlllIlIll, final double llllllllllllllllIIllIIIIlllIlIlI) {
        final int llllllllllllllllIIllIIIlIIIIlIlI = llllllllllllllllIIllIIIIlllIlllI + llllllllllllllllIIllIIIlIIIIlllI;
        GlStateManager.glTexParameteri(3553, 10242, 10497);
        GlStateManager.glTexParameteri(3553, 10243, 10497);
        GlStateManager.disableLighting();
        GlStateManager.disableCull();
        GlStateManager.disableBlend();
        GlStateManager.depthMask(true);
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        final Tessellator llllllllllllllllIIllIIIlIIIIlIIl = Tessellator.getInstance();
        final BufferBuilder llllllllllllllllIIllIIIlIIIIlIII = llllllllllllllllIIllIIIlIIIIlIIl.getBuffer();
        final double llllllllllllllllIIllIIIlIIIIIlll = llllllllllllllllIIllIIIIlllIllll + llllllllllllllllIIllIIIlIIIlIIlI;
        final double llllllllllllllllIIllIIIlIIIIIllI = (llllllllllllllllIIllIIIlIIIIlllI < 0) ? llllllllllllllllIIllIIIlIIIIIlll : (-llllllllllllllllIIllIIIlIIIIIlll);
        final double llllllllllllllllIIllIIIlIIIIIlIl = MathHelper.frac(llllllllllllllllIIllIIIlIIIIIllI * 0.2 - MathHelper.floor(llllllllllllllllIIllIIIlIIIIIllI * 0.1));
        final float llllllllllllllllIIllIIIlIIIIIlII = llllllllllllllllIIllIIIIlllIllII[0];
        final float llllllllllllllllIIllIIIlIIIIIIll = llllllllllllllllIIllIIIIlllIllII[1];
        final float llllllllllllllllIIllIIIlIIIIIIlI = llllllllllllllllIIllIIIIlllIllII[2];
        double llllllllllllllllIIllIIIlIIIIIIIl = llllllllllllllllIIllIIIlIIIIIlll * 0.025 * -1.5;
        double llllllllllllllllIIllIIIlIIIIIIII = 0.5 + Math.cos(llllllllllllllllIIllIIIlIIIIIIIl + 2.356194490192345) * llllllllllllllllIIllIIIIlllIlIll;
        double llllllllllllllllIIllIIIIllllllll = 0.5 + Math.sin(llllllllllllllllIIllIIIlIIIIIIIl + 2.356194490192345) * llllllllllllllllIIllIIIIlllIlIll;
        double llllllllllllllllIIllIIIIlllllllI = 0.5 + Math.cos(llllllllllllllllIIllIIIlIIIIIIIl + 0.7853981633974483) * llllllllllllllllIIllIIIIlllIlIll;
        double llllllllllllllllIIllIIIIllllllIl = 0.5 + Math.sin(llllllllllllllllIIllIIIlIIIIIIIl + 0.7853981633974483) * llllllllllllllllIIllIIIIlllIlIll;
        double llllllllllllllllIIllIIIIllllllII = 0.5 + Math.cos(llllllllllllllllIIllIIIlIIIIIIIl + 3.9269908169872414) * llllllllllllllllIIllIIIIlllIlIll;
        double llllllllllllllllIIllIIIIlllllIll = 0.5 + Math.sin(llllllllllllllllIIllIIIlIIIIIIIl + 3.9269908169872414) * llllllllllllllllIIllIIIIlllIlIll;
        double llllllllllllllllIIllIIIIlllllIlI = 0.5 + Math.cos(llllllllllllllllIIllIIIlIIIIIIIl + 5.497787143782138) * llllllllllllllllIIllIIIIlllIlIll;
        double llllllllllllllllIIllIIIIlllllIIl = 0.5 + Math.sin(llllllllllllllllIIllIIIlIIIIIIIl + 5.497787143782138) * llllllllllllllllIIllIIIIlllIlIll;
        double llllllllllllllllIIllIIIIlllllIII = 0.0;
        double llllllllllllllllIIllIIIIllllIlll = 1.0;
        double llllllllllllllllIIllIIIIllllIllI = -1.0 + llllllllllllllllIIllIIIlIIIIIlIl;
        final double llllllllllllllllIIllIIIIllllIlIl = llllllllllllllllIIllIIIlIIIIlllI * llllllllllllllllIIllIIIIllllIIII * (0.5 / llllllllllllllllIIllIIIIlllIlIll) + llllllllllllllllIIllIIIIllllIllI;
        llllllllllllllllIIllIIIlIIIIlIII.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
        llllllllllllllllIIllIIIlIIIIlIII.pos(llllllllllllllllIIllIIIIllllIlII + llllllllllllllllIIllIIIlIIIIIIII, llllllllllllllllIIllIIIIllllIIll + llllllllllllllllIIllIIIlIIIIlIlI, llllllllllllllllIIllIIIlIIIlIIll + llllllllllllllllIIllIIIIllllllll).tex(1.0, llllllllllllllllIIllIIIIllllIlIl).color(llllllllllllllllIIllIIIlIIIIIlII, llllllllllllllllIIllIIIlIIIIIIll, llllllllllllllllIIllIIIlIIIIIIlI, 1.0f).endVertex();
        llllllllllllllllIIllIIIlIIIIlIII.pos(llllllllllllllllIIllIIIIllllIlII + llllllllllllllllIIllIIIlIIIIIIII, llllllllllllllllIIllIIIIllllIIll + llllllllllllllllIIllIIIIlllIlllI, llllllllllllllllIIllIIIlIIIlIIll + llllllllllllllllIIllIIIIllllllll).tex(1.0, llllllllllllllllIIllIIIIllllIllI).color(llllllllllllllllIIllIIIlIIIIIlII, llllllllllllllllIIllIIIlIIIIIIll, llllllllllllllllIIllIIIlIIIIIIlI, 1.0f).endVertex();
        llllllllllllllllIIllIIIlIIIIlIII.pos(llllllllllllllllIIllIIIIllllIlII + llllllllllllllllIIllIIIIlllllllI, llllllllllllllllIIllIIIIllllIIll + llllllllllllllllIIllIIIIlllIlllI, llllllllllllllllIIllIIIlIIIlIIll + llllllllllllllllIIllIIIIllllllIl).tex(0.0, llllllllllllllllIIllIIIIllllIllI).color(llllllllllllllllIIllIIIlIIIIIlII, llllllllllllllllIIllIIIlIIIIIIll, llllllllllllllllIIllIIIlIIIIIIlI, 1.0f).endVertex();
        llllllllllllllllIIllIIIlIIIIlIII.pos(llllllllllllllllIIllIIIIllllIlII + llllllllllllllllIIllIIIIlllllllI, llllllllllllllllIIllIIIIllllIIll + llllllllllllllllIIllIIIlIIIIlIlI, llllllllllllllllIIllIIIlIIIlIIll + llllllllllllllllIIllIIIIllllllIl).tex(0.0, llllllllllllllllIIllIIIIllllIlIl).color(llllllllllllllllIIllIIIlIIIIIlII, llllllllllllllllIIllIIIlIIIIIIll, llllllllllllllllIIllIIIlIIIIIIlI, 1.0f).endVertex();
        llllllllllllllllIIllIIIlIIIIlIII.pos(llllllllllllllllIIllIIIIllllIlII + llllllllllllllllIIllIIIIlllllIlI, llllllllllllllllIIllIIIIllllIIll + llllllllllllllllIIllIIIlIIIIlIlI, llllllllllllllllIIllIIIlIIIlIIll + llllllllllllllllIIllIIIIlllllIIl).tex(1.0, llllllllllllllllIIllIIIIllllIlIl).color(llllllllllllllllIIllIIIlIIIIIlII, llllllllllllllllIIllIIIlIIIIIIll, llllllllllllllllIIllIIIlIIIIIIlI, 1.0f).endVertex();
        llllllllllllllllIIllIIIlIIIIlIII.pos(llllllllllllllllIIllIIIIllllIlII + llllllllllllllllIIllIIIIlllllIlI, llllllllllllllllIIllIIIIllllIIll + llllllllllllllllIIllIIIIlllIlllI, llllllllllllllllIIllIIIlIIIlIIll + llllllllllllllllIIllIIIIlllllIIl).tex(1.0, llllllllllllllllIIllIIIIllllIllI).color(llllllllllllllllIIllIIIlIIIIIlII, llllllllllllllllIIllIIIlIIIIIIll, llllllllllllllllIIllIIIlIIIIIIlI, 1.0f).endVertex();
        llllllllllllllllIIllIIIlIIIIlIII.pos(llllllllllllllllIIllIIIIllllIlII + llllllllllllllllIIllIIIIllllllII, llllllllllllllllIIllIIIIllllIIll + llllllllllllllllIIllIIIIlllIlllI, llllllllllllllllIIllIIIlIIIlIIll + llllllllllllllllIIllIIIIlllllIll).tex(0.0, llllllllllllllllIIllIIIIllllIllI).color(llllllllllllllllIIllIIIlIIIIIlII, llllllllllllllllIIllIIIlIIIIIIll, llllllllllllllllIIllIIIlIIIIIIlI, 1.0f).endVertex();
        llllllllllllllllIIllIIIlIIIIlIII.pos(llllllllllllllllIIllIIIIllllIlII + llllllllllllllllIIllIIIIllllllII, llllllllllllllllIIllIIIIllllIIll + llllllllllllllllIIllIIIlIIIIlIlI, llllllllllllllllIIllIIIlIIIlIIll + llllllllllllllllIIllIIIIlllllIll).tex(0.0, llllllllllllllllIIllIIIIllllIlIl).color(llllllllllllllllIIllIIIlIIIIIlII, llllllllllllllllIIllIIIlIIIIIIll, llllllllllllllllIIllIIIlIIIIIIlI, 1.0f).endVertex();
        llllllllllllllllIIllIIIlIIIIlIII.pos(llllllllllllllllIIllIIIIllllIlII + llllllllllllllllIIllIIIIlllllllI, llllllllllllllllIIllIIIIllllIIll + llllllllllllllllIIllIIIlIIIIlIlI, llllllllllllllllIIllIIIlIIIlIIll + llllllllllllllllIIllIIIIllllllIl).tex(1.0, llllllllllllllllIIllIIIIllllIlIl).color(llllllllllllllllIIllIIIlIIIIIlII, llllllllllllllllIIllIIIlIIIIIIll, llllllllllllllllIIllIIIlIIIIIIlI, 1.0f).endVertex();
        llllllllllllllllIIllIIIlIIIIlIII.pos(llllllllllllllllIIllIIIIllllIlII + llllllllllllllllIIllIIIIlllllllI, llllllllllllllllIIllIIIIllllIIll + llllllllllllllllIIllIIIIlllIlllI, llllllllllllllllIIllIIIlIIIlIIll + llllllllllllllllIIllIIIIllllllIl).tex(1.0, llllllllllllllllIIllIIIIllllIllI).color(llllllllllllllllIIllIIIlIIIIIlII, llllllllllllllllIIllIIIlIIIIIIll, llllllllllllllllIIllIIIlIIIIIIlI, 1.0f).endVertex();
        llllllllllllllllIIllIIIlIIIIlIII.pos(llllllllllllllllIIllIIIIllllIlII + llllllllllllllllIIllIIIIlllllIlI, llllllllllllllllIIllIIIIllllIIll + llllllllllllllllIIllIIIIlllIlllI, llllllllllllllllIIllIIIlIIIlIIll + llllllllllllllllIIllIIIIlllllIIl).tex(0.0, llllllllllllllllIIllIIIIllllIllI).color(llllllllllllllllIIllIIIlIIIIIlII, llllllllllllllllIIllIIIlIIIIIIll, llllllllllllllllIIllIIIlIIIIIIlI, 1.0f).endVertex();
        llllllllllllllllIIllIIIlIIIIlIII.pos(llllllllllllllllIIllIIIIllllIlII + llllllllllllllllIIllIIIIlllllIlI, llllllllllllllllIIllIIIIllllIIll + llllllllllllllllIIllIIIlIIIIlIlI, llllllllllllllllIIllIIIlIIIlIIll + llllllllllllllllIIllIIIIlllllIIl).tex(0.0, llllllllllllllllIIllIIIIllllIlIl).color(llllllllllllllllIIllIIIlIIIIIlII, llllllllllllllllIIllIIIlIIIIIIll, llllllllllllllllIIllIIIlIIIIIIlI, 1.0f).endVertex();
        llllllllllllllllIIllIIIlIIIIlIII.pos(llllllllllllllllIIllIIIIllllIlII + llllllllllllllllIIllIIIIllllllII, llllllllllllllllIIllIIIIllllIIll + llllllllllllllllIIllIIIlIIIIlIlI, llllllllllllllllIIllIIIlIIIlIIll + llllllllllllllllIIllIIIIlllllIll).tex(1.0, llllllllllllllllIIllIIIIllllIlIl).color(llllllllllllllllIIllIIIlIIIIIlII, llllllllllllllllIIllIIIlIIIIIIll, llllllllllllllllIIllIIIlIIIIIIlI, 1.0f).endVertex();
        llllllllllllllllIIllIIIlIIIIlIII.pos(llllllllllllllllIIllIIIIllllIlII + llllllllllllllllIIllIIIIllllllII, llllllllllllllllIIllIIIIllllIIll + llllllllllllllllIIllIIIIlllIlllI, llllllllllllllllIIllIIIlIIIlIIll + llllllllllllllllIIllIIIIlllllIll).tex(1.0, llllllllllllllllIIllIIIIllllIllI).color(llllllllllllllllIIllIIIlIIIIIlII, llllllllllllllllIIllIIIlIIIIIIll, llllllllllllllllIIllIIIlIIIIIIlI, 1.0f).endVertex();
        llllllllllllllllIIllIIIlIIIIlIII.pos(llllllllllllllllIIllIIIIllllIlII + llllllllllllllllIIllIIIlIIIIIIII, llllllllllllllllIIllIIIIllllIIll + llllllllllllllllIIllIIIIlllIlllI, llllllllllllllllIIllIIIlIIIlIIll + llllllllllllllllIIllIIIIllllllll).tex(0.0, llllllllllllllllIIllIIIIllllIllI).color(llllllllllllllllIIllIIIlIIIIIlII, llllllllllllllllIIllIIIlIIIIIIll, llllllllllllllllIIllIIIlIIIIIIlI, 1.0f).endVertex();
        llllllllllllllllIIllIIIlIIIIlIII.pos(llllllllllllllllIIllIIIIllllIlII + llllllllllllllllIIllIIIlIIIIIIII, llllllllllllllllIIllIIIIllllIIll + llllllllllllllllIIllIIIlIIIIlIlI, llllllllllllllllIIllIIIlIIIlIIll + llllllllllllllllIIllIIIIllllllll).tex(0.0, llllllllllllllllIIllIIIIllllIlIl).color(llllllllllllllllIIllIIIlIIIIIlII, llllllllllllllllIIllIIIlIIIIIIll, llllllllllllllllIIllIIIlIIIIIIlI, 1.0f).endVertex();
        llllllllllllllllIIllIIIlIIIIlIIl.draw();
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.depthMask(false);
        llllllllllllllllIIllIIIlIIIIIIIl = 0.5 - llllllllllllllllIIllIIIIlllIlIlI;
        llllllllllllllllIIllIIIlIIIIIIII = 0.5 - llllllllllllllllIIllIIIIlllIlIlI;
        llllllllllllllllIIllIIIIllllllll = 0.5 + llllllllllllllllIIllIIIIlllIlIlI;
        llllllllllllllllIIllIIIIlllllllI = 0.5 - llllllllllllllllIIllIIIIlllIlIlI;
        llllllllllllllllIIllIIIIllllllIl = 0.5 - llllllllllllllllIIllIIIIlllIlIlI;
        llllllllllllllllIIllIIIIllllllII = 0.5 + llllllllllllllllIIllIIIIlllIlIlI;
        llllllllllllllllIIllIIIIlllllIll = 0.5 + llllllllllllllllIIllIIIIlllIlIlI;
        llllllllllllllllIIllIIIIlllllIlI = 0.5 + llllllllllllllllIIllIIIIlllIlIlI;
        llllllllllllllllIIllIIIIlllllIIl = 0.0;
        llllllllllllllllIIllIIIIlllllIII = 1.0;
        llllllllllllllllIIllIIIIllllIlll = -1.0 + llllllllllllllllIIllIIIlIIIIIlIl;
        llllllllllllllllIIllIIIIllllIllI = llllllllllllllllIIllIIIlIIIIlllI * llllllllllllllllIIllIIIIllllIIII + llllllllllllllllIIllIIIIllllIlll;
        llllllllllllllllIIllIIIlIIIIlIII.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
        llllllllllllllllIIllIIIlIIIIlIII.pos(llllllllllllllllIIllIIIIllllIlII + llllllllllllllllIIllIIIlIIIIIIIl, llllllllllllllllIIllIIIIllllIIll + llllllllllllllllIIllIIIlIIIIlIlI, llllllllllllllllIIllIIIlIIIlIIll + llllllllllllllllIIllIIIlIIIIIIII).tex(1.0, llllllllllllllllIIllIIIIllllIllI).color(llllllllllllllllIIllIIIlIIIIIlII, llllllllllllllllIIllIIIlIIIIIIll, llllllllllllllllIIllIIIlIIIIIIlI, 0.125f).endVertex();
        llllllllllllllllIIllIIIlIIIIlIII.pos(llllllllllllllllIIllIIIIllllIlII + llllllllllllllllIIllIIIlIIIIIIIl, llllllllllllllllIIllIIIIllllIIll + llllllllllllllllIIllIIIIlllIlllI, llllllllllllllllIIllIIIlIIIlIIll + llllllllllllllllIIllIIIlIIIIIIII).tex(1.0, llllllllllllllllIIllIIIIllllIlll).color(llllllllllllllllIIllIIIlIIIIIlII, llllllllllllllllIIllIIIlIIIIIIll, llllllllllllllllIIllIIIlIIIIIIlI, 0.125f).endVertex();
        llllllllllllllllIIllIIIlIIIIlIII.pos(llllllllllllllllIIllIIIIllllIlII + llllllllllllllllIIllIIIIllllllll, llllllllllllllllIIllIIIIllllIIll + llllllllllllllllIIllIIIIlllIlllI, llllllllllllllllIIllIIIlIIIlIIll + llllllllllllllllIIllIIIIlllllllI).tex(0.0, llllllllllllllllIIllIIIIllllIlll).color(llllllllllllllllIIllIIIlIIIIIlII, llllllllllllllllIIllIIIlIIIIIIll, llllllllllllllllIIllIIIlIIIIIIlI, 0.125f).endVertex();
        llllllllllllllllIIllIIIlIIIIlIII.pos(llllllllllllllllIIllIIIIllllIlII + llllllllllllllllIIllIIIIllllllll, llllllllllllllllIIllIIIIllllIIll + llllllllllllllllIIllIIIlIIIIlIlI, llllllllllllllllIIllIIIlIIIlIIll + llllllllllllllllIIllIIIIlllllllI).tex(0.0, llllllllllllllllIIllIIIIllllIllI).color(llllllllllllllllIIllIIIlIIIIIlII, llllllllllllllllIIllIIIlIIIIIIll, llllllllllllllllIIllIIIlIIIIIIlI, 0.125f).endVertex();
        llllllllllllllllIIllIIIlIIIIlIII.pos(llllllllllllllllIIllIIIIllllIlII + llllllllllllllllIIllIIIIlllllIll, llllllllllllllllIIllIIIIllllIIll + llllllllllllllllIIllIIIlIIIIlIlI, llllllllllllllllIIllIIIlIIIlIIll + llllllllllllllllIIllIIIIlllllIlI).tex(1.0, llllllllllllllllIIllIIIIllllIllI).color(llllllllllllllllIIllIIIlIIIIIlII, llllllllllllllllIIllIIIlIIIIIIll, llllllllllllllllIIllIIIlIIIIIIlI, 0.125f).endVertex();
        llllllllllllllllIIllIIIlIIIIlIII.pos(llllllllllllllllIIllIIIIllllIlII + llllllllllllllllIIllIIIIlllllIll, llllllllllllllllIIllIIIIllllIIll + llllllllllllllllIIllIIIIlllIlllI, llllllllllllllllIIllIIIlIIIlIIll + llllllllllllllllIIllIIIIlllllIlI).tex(1.0, llllllllllllllllIIllIIIIllllIlll).color(llllllllllllllllIIllIIIlIIIIIlII, llllllllllllllllIIllIIIlIIIIIIll, llllllllllllllllIIllIIIlIIIIIIlI, 0.125f).endVertex();
        llllllllllllllllIIllIIIlIIIIlIII.pos(llllllllllllllllIIllIIIIllllIlII + llllllllllllllllIIllIIIIllllllIl, llllllllllllllllIIllIIIIllllIIll + llllllllllllllllIIllIIIIlllIlllI, llllllllllllllllIIllIIIlIIIlIIll + llllllllllllllllIIllIIIIllllllII).tex(0.0, llllllllllllllllIIllIIIIllllIlll).color(llllllllllllllllIIllIIIlIIIIIlII, llllllllllllllllIIllIIIlIIIIIIll, llllllllllllllllIIllIIIlIIIIIIlI, 0.125f).endVertex();
        llllllllllllllllIIllIIIlIIIIlIII.pos(llllllllllllllllIIllIIIIllllIlII + llllllllllllllllIIllIIIIllllllIl, llllllllllllllllIIllIIIIllllIIll + llllllllllllllllIIllIIIlIIIIlIlI, llllllllllllllllIIllIIIlIIIlIIll + llllllllllllllllIIllIIIIllllllII).tex(0.0, llllllllllllllllIIllIIIIllllIllI).color(llllllllllllllllIIllIIIlIIIIIlII, llllllllllllllllIIllIIIlIIIIIIll, llllllllllllllllIIllIIIlIIIIIIlI, 0.125f).endVertex();
        llllllllllllllllIIllIIIlIIIIlIII.pos(llllllllllllllllIIllIIIIllllIlII + llllllllllllllllIIllIIIIllllllll, llllllllllllllllIIllIIIIllllIIll + llllllllllllllllIIllIIIlIIIIlIlI, llllllllllllllllIIllIIIlIIIlIIll + llllllllllllllllIIllIIIIlllllllI).tex(1.0, llllllllllllllllIIllIIIIllllIllI).color(llllllllllllllllIIllIIIlIIIIIlII, llllllllllllllllIIllIIIlIIIIIIll, llllllllllllllllIIllIIIlIIIIIIlI, 0.125f).endVertex();
        llllllllllllllllIIllIIIlIIIIlIII.pos(llllllllllllllllIIllIIIIllllIlII + llllllllllllllllIIllIIIIllllllll, llllllllllllllllIIllIIIIllllIIll + llllllllllllllllIIllIIIIlllIlllI, llllllllllllllllIIllIIIlIIIlIIll + llllllllllllllllIIllIIIIlllllllI).tex(1.0, llllllllllllllllIIllIIIIllllIlll).color(llllllllllllllllIIllIIIlIIIIIlII, llllllllllllllllIIllIIIlIIIIIIll, llllllllllllllllIIllIIIlIIIIIIlI, 0.125f).endVertex();
        llllllllllllllllIIllIIIlIIIIlIII.pos(llllllllllllllllIIllIIIIllllIlII + llllllllllllllllIIllIIIIlllllIll, llllllllllllllllIIllIIIIllllIIll + llllllllllllllllIIllIIIIlllIlllI, llllllllllllllllIIllIIIlIIIlIIll + llllllllllllllllIIllIIIIlllllIlI).tex(0.0, llllllllllllllllIIllIIIIllllIlll).color(llllllllllllllllIIllIIIlIIIIIlII, llllllllllllllllIIllIIIlIIIIIIll, llllllllllllllllIIllIIIlIIIIIIlI, 0.125f).endVertex();
        llllllllllllllllIIllIIIlIIIIlIII.pos(llllllllllllllllIIllIIIIllllIlII + llllllllllllllllIIllIIIIlllllIll, llllllllllllllllIIllIIIIllllIIll + llllllllllllllllIIllIIIlIIIIlIlI, llllllllllllllllIIllIIIlIIIlIIll + llllllllllllllllIIllIIIIlllllIlI).tex(0.0, llllllllllllllllIIllIIIIllllIllI).color(llllllllllllllllIIllIIIlIIIIIlII, llllllllllllllllIIllIIIlIIIIIIll, llllllllllllllllIIllIIIlIIIIIIlI, 0.125f).endVertex();
        llllllllllllllllIIllIIIlIIIIlIII.pos(llllllllllllllllIIllIIIIllllIlII + llllllllllllllllIIllIIIIllllllIl, llllllllllllllllIIllIIIIllllIIll + llllllllllllllllIIllIIIlIIIIlIlI, llllllllllllllllIIllIIIlIIIlIIll + llllllllllllllllIIllIIIIllllllII).tex(1.0, llllllllllllllllIIllIIIIllllIllI).color(llllllllllllllllIIllIIIlIIIIIlII, llllllllllllllllIIllIIIlIIIIIIll, llllllllllllllllIIllIIIlIIIIIIlI, 0.125f).endVertex();
        llllllllllllllllIIllIIIlIIIIlIII.pos(llllllllllllllllIIllIIIIllllIlII + llllllllllllllllIIllIIIIllllllIl, llllllllllllllllIIllIIIIllllIIll + llllllllllllllllIIllIIIIlllIlllI, llllllllllllllllIIllIIIlIIIlIIll + llllllllllllllllIIllIIIIllllllII).tex(1.0, llllllllllllllllIIllIIIIllllIlll).color(llllllllllllllllIIllIIIlIIIIIlII, llllllllllllllllIIllIIIlIIIIIIll, llllllllllllllllIIllIIIlIIIIIIlI, 0.125f).endVertex();
        llllllllllllllllIIllIIIlIIIIlIII.pos(llllllllllllllllIIllIIIIllllIlII + llllllllllllllllIIllIIIlIIIIIIIl, llllllllllllllllIIllIIIIllllIIll + llllllllllllllllIIllIIIIlllIlllI, llllllllllllllllIIllIIIlIIIlIIll + llllllllllllllllIIllIIIlIIIIIIII).tex(0.0, llllllllllllllllIIllIIIIllllIlll).color(llllllllllllllllIIllIIIlIIIIIlII, llllllllllllllllIIllIIIlIIIIIIll, llllllllllllllllIIllIIIlIIIIIIlI, 0.125f).endVertex();
        llllllllllllllllIIllIIIlIIIIlIII.pos(llllllllllllllllIIllIIIIllllIlII + llllllllllllllllIIllIIIlIIIIIIIl, llllllllllllllllIIllIIIIllllIIll + llllllllllllllllIIllIIIlIIIIlIlI, llllllllllllllllIIllIIIlIIIlIIll + llllllllllllllllIIllIIIlIIIIIIII).tex(0.0, llllllllllllllllIIllIIIIllllIllI).color(llllllllllllllllIIllIIIlIIIIIlII, llllllllllllllllIIllIIIlIIIIIIll, llllllllllllllllIIllIIIlIIIIIIlI, 0.125f).endVertex();
        llllllllllllllllIIllIIIlIIIIlIIl.draw();
        GlStateManager.enableLighting();
        GlStateManager.enableTexture2D();
        GlStateManager.depthMask(true);
    }
}
