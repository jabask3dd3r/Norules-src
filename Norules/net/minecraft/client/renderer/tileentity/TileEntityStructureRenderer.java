package net.minecraft.client.renderer.tileentity;

import net.minecraft.client.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.util.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.math.*;
import net.minecraft.init.*;
import net.minecraft.client.renderer.*;
import net.minecraft.world.*;
import net.minecraft.block.state.*;

public class TileEntityStructureRenderer extends TileEntitySpecialRenderer<TileEntityStructure>
{
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Rotation;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Mirror;
    
    @Override
    public void func_192841_a(final TileEntityStructure lllllllllllllIIIIIlIllllllIIIllI, final double lllllllllllllIIIIIlIlllllllIllll, final double lllllllllllllIIIIIlIllllllIIIlII, final double lllllllllllllIIIIIlIllllllIIIIll, final float lllllllllllllIIIIIlIlllllllIllII, final int lllllllllllllIIIIIlIllllllIIIIIl, final float lllllllllllllIIIIIlIlllllllIlIlI) {
        if (Minecraft.getMinecraft().player.canUseCommandBlock() || Minecraft.getMinecraft().player.isSpectator()) {
            super.func_192841_a(lllllllllllllIIIIIlIllllllIIIllI, lllllllllllllIIIIIlIlllllllIllll, lllllllllllllIIIIIlIllllllIIIlII, lllllllllllllIIIIIlIllllllIIIIll, lllllllllllllIIIIIlIlllllllIllII, lllllllllllllIIIIIlIllllllIIIIIl, lllllllllllllIIIIIlIlllllllIlIlI);
            final BlockPos lllllllllllllIIIIIlIlllllllIlIIl = lllllllllllllIIIIIlIllllllIIIllI.getPosition();
            final BlockPos lllllllllllllIIIIIlIlllllllIlIII = lllllllllllllIIIIIlIllllllIIIllI.getStructureSize();
            if (lllllllllllllIIIIIlIlllllllIlIII.getX() >= 1 && lllllllllllllIIIIIlIlllllllIlIII.getY() >= 1 && lllllllllllllIIIIIlIlllllllIlIII.getZ() >= 1 && (lllllllllllllIIIIIlIllllllIIIllI.getMode() == TileEntityStructure.Mode.SAVE || lllllllllllllIIIIIlIllllllIIIllI.getMode() == TileEntityStructure.Mode.LOAD)) {
                final double lllllllllllllIIIIIlIlllllllIIlll = 0.01;
                final double lllllllllllllIIIIIlIlllllllIIllI = lllllllllllllIIIIIlIlllllllIlIIl.getX();
                final double lllllllllllllIIIIIlIlllllllIIlIl = lllllllllllllIIIIIlIlllllllIlIIl.getZ();
                final double lllllllllllllIIIIIlIlllllllIIlII = lllllllllllllIIIIIlIllllllIIIlII + lllllllllllllIIIIIlIlllllllIlIIl.getY() - 0.01;
                final double lllllllllllllIIIIIlIlllllllIIIll = lllllllllllllIIIIIlIlllllllIIlII + lllllllllllllIIIIIlIlllllllIlIII.getY() + 0.02;
                final double lllllllllllllIIIIIlIlllllllIIIII;
                final double lllllllllllllIIIIIlIllllllIlllIl;
                switch ($SWITCH_TABLE$net$minecraft$util$Mirror()[lllllllllllllIIIIIlIllllllIIIllI.getMirror().ordinal()]) {
                    case 2: {
                        final double lllllllllllllIIIIIlIlllllllIIIlI = lllllllllllllIIIIIlIlllllllIlIII.getX() + 0.02;
                        final double lllllllllllllIIIIIlIllllllIlllll = -(lllllllllllllIIIIIlIlllllllIlIII.getZ() + 0.02);
                        break;
                    }
                    case 3: {
                        final double lllllllllllllIIIIIlIlllllllIIIIl = -(lllllllllllllIIIIIlIlllllllIlIII.getX() + 0.02);
                        final double lllllllllllllIIIIIlIllllllIllllI = lllllllllllllIIIIIlIlllllllIlIII.getZ() + 0.02;
                        break;
                    }
                    default: {
                        lllllllllllllIIIIIlIlllllllIIIII = lllllllllllllIIIIIlIlllllllIlIII.getX() + 0.02;
                        lllllllllllllIIIIIlIllllllIlllIl = lllllllllllllIIIIIlIlllllllIlIII.getZ() + 0.02;
                        break;
                    }
                }
                final double lllllllllllllIIIIIlIllllllIllIIl;
                final double lllllllllllllIIIIIlIllllllIlIlIl;
                final double lllllllllllllIIIIIlIllllllIlIIIl;
                final double lllllllllllllIIIIIlIllllllIIllIl;
                switch ($SWITCH_TABLE$net$minecraft$util$Rotation()[lllllllllllllIIIIIlIllllllIIIllI.getRotation().ordinal()]) {
                    case 2: {
                        final double lllllllllllllIIIIIlIllllllIlllII = lllllllllllllIIIIIlIlllllllIllll + ((lllllllllllllIIIIIlIllllllIlllIl < 0.0) ? (lllllllllllllIIIIIlIlllllllIIllI - 0.01) : (lllllllllllllIIIIIlIlllllllIIllI + 1.0 + 0.01));
                        final double lllllllllllllIIIIIlIllllllIllIII = lllllllllllllIIIIIlIllllllIIIIll + ((lllllllllllllIIIIIlIlllllllIIIII < 0.0) ? (lllllllllllllIIIIIlIlllllllIIlIl + 1.0 + 0.01) : (lllllllllllllIIIIIlIlllllllIIlIl - 0.01));
                        final double lllllllllllllIIIIIlIllllllIlIlII = lllllllllllllIIIIIlIllllllIlllII - lllllllllllllIIIIIlIllllllIlllIl;
                        final double lllllllllllllIIIIIlIllllllIlIIII = lllllllllllllIIIIIlIllllllIllIII + lllllllllllllIIIIIlIlllllllIIIII;
                        break;
                    }
                    case 3: {
                        final double lllllllllllllIIIIIlIllllllIllIll = lllllllllllllIIIIIlIlllllllIllll + ((lllllllllllllIIIIIlIlllllllIIIII < 0.0) ? (lllllllllllllIIIIIlIlllllllIIllI - 0.01) : (lllllllllllllIIIIIlIlllllllIIllI + 1.0 + 0.01));
                        final double lllllllllllllIIIIIlIllllllIlIlll = lllllllllllllIIIIIlIllllllIIIIll + ((lllllllllllllIIIIIlIllllllIlllIl < 0.0) ? (lllllllllllllIIIIIlIlllllllIIlIl - 0.01) : (lllllllllllllIIIIIlIlllllllIIlIl + 1.0 + 0.01));
                        final double lllllllllllllIIIIIlIllllllIlIIll = lllllllllllllIIIIIlIllllllIllIll - lllllllllllllIIIIIlIlllllllIIIII;
                        final double lllllllllllllIIIIIlIllllllIIllll = lllllllllllllIIIIIlIllllllIlIlll - lllllllllllllIIIIIlIllllllIlllIl;
                        break;
                    }
                    case 4: {
                        final double lllllllllllllIIIIIlIllllllIllIlI = lllllllllllllIIIIIlIlllllllIllll + ((lllllllllllllIIIIIlIllllllIlllIl < 0.0) ? (lllllllllllllIIIIIlIlllllllIIllI + 1.0 + 0.01) : (lllllllllllllIIIIIlIlllllllIIllI - 0.01));
                        final double lllllllllllllIIIIIlIllllllIlIllI = lllllllllllllIIIIIlIllllllIIIIll + ((lllllllllllllIIIIIlIlllllllIIIII < 0.0) ? (lllllllllllllIIIIIlIlllllllIIlIl - 0.01) : (lllllllllllllIIIIIlIlllllllIIlIl + 1.0 + 0.01));
                        final double lllllllllllllIIIIIlIllllllIlIIlI = lllllllllllllIIIIIlIllllllIllIlI + lllllllllllllIIIIIlIllllllIlllIl;
                        final double lllllllllllllIIIIIlIllllllIIlllI = lllllllllllllIIIIIlIllllllIlIllI - lllllllllllllIIIIIlIlllllllIIIII;
                        break;
                    }
                    default: {
                        lllllllllllllIIIIIlIllllllIllIIl = lllllllllllllIIIIIlIlllllllIllll + ((lllllllllllllIIIIIlIlllllllIIIII < 0.0) ? (lllllllllllllIIIIIlIlllllllIIllI + 1.0 + 0.01) : (lllllllllllllIIIIIlIlllllllIIllI - 0.01));
                        lllllllllllllIIIIIlIllllllIlIlIl = lllllllllllllIIIIIlIllllllIIIIll + ((lllllllllllllIIIIIlIllllllIlllIl < 0.0) ? (lllllllllllllIIIIIlIlllllllIIlIl + 1.0 + 0.01) : (lllllllllllllIIIIIlIlllllllIIlIl - 0.01));
                        lllllllllllllIIIIIlIllllllIlIIIl = lllllllllllllIIIIIlIllllllIllIIl + lllllllllllllIIIIIlIlllllllIIIII;
                        lllllllllllllIIIIIlIllllllIIllIl = lllllllllllllIIIIIlIllllllIlIlIl + lllllllllllllIIIIIlIllllllIlllIl;
                        break;
                    }
                }
                final int lllllllllllllIIIIIlIllllllIIllII = 255;
                final int lllllllllllllIIIIIlIllllllIIlIll = 223;
                final int lllllllllllllIIIIIlIllllllIIlIlI = 127;
                final Tessellator lllllllllllllIIIIIlIllllllIIlIIl = Tessellator.getInstance();
                final BufferBuilder lllllllllllllIIIIIlIllllllIIlIII = lllllllllllllIIIIIlIllllllIIlIIl.getBuffer();
                GlStateManager.disableFog();
                GlStateManager.disableLighting();
                GlStateManager.disableTexture2D();
                GlStateManager.enableBlend();
                GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
                this.setLightmapDisabled(true);
                if (lllllllllllllIIIIIlIllllllIIIllI.getMode() == TileEntityStructure.Mode.SAVE || lllllllllllllIIIIIlIllllllIIIllI.showsBoundingBox()) {
                    this.renderBox(lllllllllllllIIIIIlIllllllIIlIIl, lllllllllllllIIIIIlIllllllIIlIII, lllllllllllllIIIIIlIllllllIllIIl, lllllllllllllIIIIIlIlllllllIIlII, lllllllllllllIIIIIlIllllllIlIlIl, lllllllllllllIIIIIlIllllllIlIIIl, lllllllllllllIIIIIlIlllllllIIIll, lllllllllllllIIIIIlIllllllIIllIl, 255, 223, 127);
                }
                if (lllllllllllllIIIIIlIllllllIIIllI.getMode() == TileEntityStructure.Mode.SAVE && lllllllllllllIIIIIlIllllllIIIllI.showsAir()) {
                    this.renderInvisibleBlocks(lllllllllllllIIIIIlIllllllIIIllI, lllllllllllllIIIIIlIlllllllIllll, lllllllllllllIIIIIlIllllllIIIlII, lllllllllllllIIIIIlIllllllIIIIll, lllllllllllllIIIIIlIlllllllIlIIl, lllllllllllllIIIIIlIllllllIIlIIl, lllllllllllllIIIIIlIllllllIIlIII, true);
                    this.renderInvisibleBlocks(lllllllllllllIIIIIlIllllllIIIllI, lllllllllllllIIIIIlIlllllllIllll, lllllllllllllIIIIIlIllllllIIIlII, lllllllllllllIIIIIlIllllllIIIIll, lllllllllllllIIIIIlIlllllllIlIIl, lllllllllllllIIIIIlIllllllIIlIIl, lllllllllllllIIIIIlIllllllIIlIII, false);
                }
                this.setLightmapDisabled(false);
                GlStateManager.glLineWidth(1.0f);
                GlStateManager.enableLighting();
                GlStateManager.enableTexture2D();
                GlStateManager.enableDepth();
                GlStateManager.depthMask(true);
                GlStateManager.enableFog();
            }
        }
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Mirror() {
        final int[] $switch_TABLE$net$minecraft$util$Mirror = TileEntityStructureRenderer.$SWITCH_TABLE$net$minecraft$util$Mirror;
        if ($switch_TABLE$net$minecraft$util$Mirror != null) {
            return $switch_TABLE$net$minecraft$util$Mirror;
        }
        final Exception lllllllllllllIIIIIlIllllIIlIllll = (Object)new int[Mirror.values().length];
        try {
            lllllllllllllIIIIIlIllllIIlIllll[Mirror.FRONT_BACK.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIIIIIlIllllIIlIllll[Mirror.LEFT_RIGHT.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIIIIIlIllllIIlIllll[Mirror.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        return TileEntityStructureRenderer.$SWITCH_TABLE$net$minecraft$util$Mirror = (int[])(Object)lllllllllllllIIIIIlIllllIIlIllll;
    }
    
    private void renderBox(final Tessellator lllllllllllllIIIIIlIllllIlIlllII, final BufferBuilder lllllllllllllIIIIIlIllllIlIIlllI, final double lllllllllllllIIIIIlIllllIlIllIlI, final double lllllllllllllIIIIIlIllllIlIllIIl, final double lllllllllllllIIIIIlIllllIlIIlIll, final double lllllllllllllIIIIIlIllllIlIlIlll, final double lllllllllllllIIIIIlIllllIlIlIllI, final double lllllllllllllIIIIIlIllllIlIlIlIl, final int lllllllllllllIIIIIlIllllIlIlIlII, final int lllllllllllllIIIIIlIllllIlIlIIll, final int lllllllllllllIIIIIlIllllIlIlIIII) {
        GlStateManager.glLineWidth(2.0f);
        lllllllllllllIIIIIlIllllIlIIlllI.begin(3, DefaultVertexFormats.POSITION_COLOR);
        lllllllllllllIIIIIlIllllIlIIlllI.pos(lllllllllllllIIIIIlIllllIlIllIlI, lllllllllllllIIIIIlIllllIlIllIIl, lllllllllllllIIIIIlIllllIlIIlIll).color((float)lllllllllllllIIIIIlIllllIlIlIIll, (float)lllllllllllllIIIIIlIllllIlIlIIll, (float)lllllllllllllIIIIIlIllllIlIlIIll, 0.0f).endVertex();
        lllllllllllllIIIIIlIllllIlIIlllI.pos(lllllllllllllIIIIIlIllllIlIllIlI, lllllllllllllIIIIIlIllllIlIllIIl, lllllllllllllIIIIIlIllllIlIIlIll).color(lllllllllllllIIIIIlIllllIlIlIIll, lllllllllllllIIIIIlIllllIlIlIIll, lllllllllllllIIIIIlIllllIlIlIIll, lllllllllllllIIIIIlIllllIlIlIlII).endVertex();
        lllllllllllllIIIIIlIllllIlIIlllI.pos(lllllllllllllIIIIIlIllllIlIlIlll, lllllllllllllIIIIIlIllllIlIllIIl, lllllllllllllIIIIIlIllllIlIIlIll).color(lllllllllllllIIIIIlIllllIlIlIIll, lllllllllllllIIIIIlIllllIlIlIIII, lllllllllllllIIIIIlIllllIlIlIIII, lllllllllllllIIIIIlIllllIlIlIlII).endVertex();
        lllllllllllllIIIIIlIllllIlIIlllI.pos(lllllllllllllIIIIIlIllllIlIlIlll, lllllllllllllIIIIIlIllllIlIllIIl, lllllllllllllIIIIIlIllllIlIlIlIl).color(lllllllllllllIIIIIlIllllIlIlIIll, lllllllllllllIIIIIlIllllIlIlIIll, lllllllllllllIIIIIlIllllIlIlIIll, lllllllllllllIIIIIlIllllIlIlIlII).endVertex();
        lllllllllllllIIIIIlIllllIlIIlllI.pos(lllllllllllllIIIIIlIllllIlIllIlI, lllllllllllllIIIIIlIllllIlIllIIl, lllllllllllllIIIIIlIllllIlIlIlIl).color(lllllllllllllIIIIIlIllllIlIlIIll, lllllllllllllIIIIIlIllllIlIlIIll, lllllllllllllIIIIIlIllllIlIlIIll, lllllllllllllIIIIIlIllllIlIlIlII).endVertex();
        lllllllllllllIIIIIlIllllIlIIlllI.pos(lllllllllllllIIIIIlIllllIlIllIlI, lllllllllllllIIIIIlIllllIlIllIIl, lllllllllllllIIIIIlIllllIlIIlIll).color(lllllllllllllIIIIIlIllllIlIlIIII, lllllllllllllIIIIIlIllllIlIlIIII, lllllllllllllIIIIIlIllllIlIlIIll, lllllllllllllIIIIIlIllllIlIlIlII).endVertex();
        lllllllllllllIIIIIlIllllIlIIlllI.pos(lllllllllllllIIIIIlIllllIlIllIlI, lllllllllllllIIIIIlIllllIlIlIllI, lllllllllllllIIIIIlIllllIlIIlIll).color(lllllllllllllIIIIIlIllllIlIlIIII, lllllllllllllIIIIIlIllllIlIlIIll, lllllllllllllIIIIIlIllllIlIlIIII, lllllllllllllIIIIIlIllllIlIlIlII).endVertex();
        lllllllllllllIIIIIlIllllIlIIlllI.pos(lllllllllllllIIIIIlIllllIlIlIlll, lllllllllllllIIIIIlIllllIlIlIllI, lllllllllllllIIIIIlIllllIlIIlIll).color(lllllllllllllIIIIIlIllllIlIlIIll, lllllllllllllIIIIIlIllllIlIlIIll, lllllllllllllIIIIIlIllllIlIlIIll, lllllllllllllIIIIIlIllllIlIlIlII).endVertex();
        lllllllllllllIIIIIlIllllIlIIlllI.pos(lllllllllllllIIIIIlIllllIlIlIlll, lllllllllllllIIIIIlIllllIlIlIllI, lllllllllllllIIIIIlIllllIlIlIlIl).color(lllllllllllllIIIIIlIllllIlIlIIll, lllllllllllllIIIIIlIllllIlIlIIll, lllllllllllllIIIIIlIllllIlIlIIll, lllllllllllllIIIIIlIllllIlIlIlII).endVertex();
        lllllllllllllIIIIIlIllllIlIIlllI.pos(lllllllllllllIIIIIlIllllIlIllIlI, lllllllllllllIIIIIlIllllIlIlIllI, lllllllllllllIIIIIlIllllIlIlIlIl).color(lllllllllllllIIIIIlIllllIlIlIIll, lllllllllllllIIIIIlIllllIlIlIIll, lllllllllllllIIIIIlIllllIlIlIIll, lllllllllllllIIIIIlIllllIlIlIlII).endVertex();
        lllllllllllllIIIIIlIllllIlIIlllI.pos(lllllllllllllIIIIIlIllllIlIllIlI, lllllllllllllIIIIIlIllllIlIlIllI, lllllllllllllIIIIIlIllllIlIIlIll).color(lllllllllllllIIIIIlIllllIlIlIIll, lllllllllllllIIIIIlIllllIlIlIIll, lllllllllllllIIIIIlIllllIlIlIIll, lllllllllllllIIIIIlIllllIlIlIlII).endVertex();
        lllllllllllllIIIIIlIllllIlIIlllI.pos(lllllllllllllIIIIIlIllllIlIllIlI, lllllllllllllIIIIIlIllllIlIlIllI, lllllllllllllIIIIIlIllllIlIlIlIl).color(lllllllllllllIIIIIlIllllIlIlIIll, lllllllllllllIIIIIlIllllIlIlIIll, lllllllllllllIIIIIlIllllIlIlIIll, lllllllllllllIIIIIlIllllIlIlIlII).endVertex();
        lllllllllllllIIIIIlIllllIlIIlllI.pos(lllllllllllllIIIIIlIllllIlIllIlI, lllllllllllllIIIIIlIllllIlIllIIl, lllllllllllllIIIIIlIllllIlIlIlIl).color(lllllllllllllIIIIIlIllllIlIlIIll, lllllllllllllIIIIIlIllllIlIlIIll, lllllllllllllIIIIIlIllllIlIlIIll, lllllllllllllIIIIIlIllllIlIlIlII).endVertex();
        lllllllllllllIIIIIlIllllIlIIlllI.pos(lllllllllllllIIIIIlIllllIlIlIlll, lllllllllllllIIIIIlIllllIlIllIIl, lllllllllllllIIIIIlIllllIlIlIlIl).color(lllllllllllllIIIIIlIllllIlIlIIll, lllllllllllllIIIIIlIllllIlIlIIll, lllllllllllllIIIIIlIllllIlIlIIll, lllllllllllllIIIIIlIllllIlIlIlII).endVertex();
        lllllllllllllIIIIIlIllllIlIIlllI.pos(lllllllllllllIIIIIlIllllIlIlIlll, lllllllllllllIIIIIlIllllIlIlIllI, lllllllllllllIIIIIlIllllIlIlIlIl).color(lllllllllllllIIIIIlIllllIlIlIIll, lllllllllllllIIIIIlIllllIlIlIIll, lllllllllllllIIIIIlIllllIlIlIIll, lllllllllllllIIIIIlIllllIlIlIlII).endVertex();
        lllllllllllllIIIIIlIllllIlIIlllI.pos(lllllllllllllIIIIIlIllllIlIlIlll, lllllllllllllIIIIIlIllllIlIlIllI, lllllllllllllIIIIIlIllllIlIIlIll).color(lllllllllllllIIIIIlIllllIlIlIIll, lllllllllllllIIIIIlIllllIlIlIIll, lllllllllllllIIIIIlIllllIlIlIIll, lllllllllllllIIIIIlIllllIlIlIlII).endVertex();
        lllllllllllllIIIIIlIllllIlIIlllI.pos(lllllllllllllIIIIIlIllllIlIlIlll, lllllllllllllIIIIIlIllllIlIllIIl, lllllllllllllIIIIIlIllllIlIIlIll).color(lllllllllllllIIIIIlIllllIlIlIIll, lllllllllllllIIIIIlIllllIlIlIIll, lllllllllllllIIIIIlIllllIlIlIIll, lllllllllllllIIIIIlIllllIlIlIlII).endVertex();
        lllllllllllllIIIIIlIllllIlIIlllI.pos(lllllllllllllIIIIIlIllllIlIlIlll, lllllllllllllIIIIIlIllllIlIllIIl, lllllllllllllIIIIIlIllllIlIIlIll).color((float)lllllllllllllIIIIIlIllllIlIlIIll, (float)lllllllllllllIIIIIlIllllIlIlIIll, (float)lllllllllllllIIIIIlIllllIlIlIIll, 0.0f).endVertex();
        lllllllllllllIIIIIlIllllIlIlllII.draw();
        GlStateManager.glLineWidth(1.0f);
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Rotation() {
        final int[] $switch_TABLE$net$minecraft$util$Rotation = TileEntityStructureRenderer.$SWITCH_TABLE$net$minecraft$util$Rotation;
        if ($switch_TABLE$net$minecraft$util$Rotation != null) {
            return $switch_TABLE$net$minecraft$util$Rotation;
        }
        final char lllllllllllllIIIIIlIllllIIlIllIl = (Object)new int[Rotation.values().length];
        try {
            lllllllllllllIIIIIlIllllIIlIllIl[Rotation.CLOCKWISE_180.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIIIIIlIllllIIlIllIl[Rotation.CLOCKWISE_90.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIIIIIlIllllIIlIllIl[Rotation.COUNTERCLOCKWISE_90.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllIIIIIlIllllIIlIllIl[Rotation.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return TileEntityStructureRenderer.$SWITCH_TABLE$net$minecraft$util$Rotation = (int[])(Object)lllllllllllllIIIIIlIllllIIlIllIl;
    }
    
    @Override
    public boolean isGlobalRenderer(final TileEntityStructure lllllllllllllIIIIIlIllllIlIIIlIl) {
        return true;
    }
    
    private void renderInvisibleBlocks(final TileEntityStructure lllllllllllllIIIIIlIllllIlllllll, final double lllllllllllllIIIIIlIllllIllllllI, final double lllllllllllllIIIIIlIlllllIIlIIll, final double lllllllllllllIIIIIlIlllllIIlIIlI, final BlockPos lllllllllllllIIIIIlIlllllIIlIIIl, final Tessellator lllllllllllllIIIIIlIllllIllllIlI, final BufferBuilder lllllllllllllIIIIIlIlllllIIIllll, final boolean lllllllllllllIIIIIlIlllllIIIlllI) {
        GlStateManager.glLineWidth(lllllllllllllIIIIIlIlllllIIIlllI ? 3.0f : 1.0f);
        lllllllllllllIIIIIlIlllllIIIllll.begin(3, DefaultVertexFormats.POSITION_COLOR);
        final World lllllllllllllIIIIIlIlllllIIIllIl = lllllllllllllIIIIIlIllllIlllllll.getWorld();
        final BlockPos lllllllllllllIIIIIlIlllllIIIllII = lllllllllllllIIIIIlIllllIlllllll.getPos();
        final BlockPos lllllllllllllIIIIIlIlllllIIIlIll = lllllllllllllIIIIIlIlllllIIIllII.add(lllllllllllllIIIIIlIlllllIIlIIIl);
        for (final BlockPos lllllllllllllIIIIIlIlllllIIIlIlI : BlockPos.getAllInBox(lllllllllllllIIIIIlIlllllIIIlIll, lllllllllllllIIIIIlIlllllIIIlIll.add(lllllllllllllIIIIIlIllllIlllllll.getStructureSize()).add(-1, -1, -1))) {
            final IBlockState lllllllllllllIIIIIlIlllllIIIlIIl = lllllllllllllIIIIIlIlllllIIIllIl.getBlockState(lllllllllllllIIIIIlIlllllIIIlIlI);
            final boolean lllllllllllllIIIIIlIlllllIIIlIII = lllllllllllllIIIIIlIlllllIIIlIIl == Blocks.AIR.getDefaultState();
            final boolean lllllllllllllIIIIIlIlllllIIIIlll = lllllllllllllIIIIIlIlllllIIIlIIl == Blocks.STRUCTURE_VOID.getDefaultState();
            if (lllllllllllllIIIIIlIlllllIIIlIII || lllllllllllllIIIIIlIlllllIIIIlll) {
                final float lllllllllllllIIIIIlIlllllIIIIllI = lllllllllllllIIIIIlIlllllIIIlIII ? 0.05f : 0.0f;
                final double lllllllllllllIIIIIlIlllllIIIIlIl = lllllllllllllIIIIIlIlllllIIIlIlI.getX() - lllllllllllllIIIIIlIlllllIIIllII.getX() + 0.45f + lllllllllllllIIIIIlIllllIllllllI - lllllllllllllIIIIIlIlllllIIIIllI;
                final double lllllllllllllIIIIIlIlllllIIIIlII = lllllllllllllIIIIIlIlllllIIIlIlI.getY() - lllllllllllllIIIIIlIlllllIIIllII.getY() + 0.45f + lllllllllllllIIIIIlIlllllIIlIIll - lllllllllllllIIIIIlIlllllIIIIllI;
                final double lllllllllllllIIIIIlIlllllIIIIIll = lllllllllllllIIIIIlIlllllIIIlIlI.getZ() - lllllllllllllIIIIIlIlllllIIIllII.getZ() + 0.45f + lllllllllllllIIIIIlIlllllIIlIIlI - lllllllllllllIIIIIlIlllllIIIIllI;
                final double lllllllllllllIIIIIlIlllllIIIIIlI = lllllllllllllIIIIIlIlllllIIIlIlI.getX() - lllllllllllllIIIIIlIlllllIIIllII.getX() + 0.55f + lllllllllllllIIIIIlIllllIllllllI + lllllllllllllIIIIIlIlllllIIIIllI;
                final double lllllllllllllIIIIIlIlllllIIIIIIl = lllllllllllllIIIIIlIlllllIIIlIlI.getY() - lllllllllllllIIIIIlIlllllIIIllII.getY() + 0.55f + lllllllllllllIIIIIlIlllllIIlIIll + lllllllllllllIIIIIlIlllllIIIIllI;
                final double lllllllllllllIIIIIlIlllllIIIIIII = lllllllllllllIIIIIlIlllllIIIlIlI.getZ() - lllllllllllllIIIIIlIlllllIIIllII.getZ() + 0.55f + lllllllllllllIIIIIlIlllllIIlIIlI + lllllllllllllIIIIIlIlllllIIIIllI;
                if (lllllllllllllIIIIIlIlllllIIIlllI) {
                    RenderGlobal.drawBoundingBox(lllllllllllllIIIIIlIlllllIIIllll, lllllllllllllIIIIIlIlllllIIIIlIl, lllllllllllllIIIIIlIlllllIIIIlII, lllllllllllllIIIIIlIlllllIIIIIll, lllllllllllllIIIIIlIlllllIIIIIlI, lllllllllllllIIIIIlIlllllIIIIIIl, lllllllllllllIIIIIlIlllllIIIIIII, 0.0f, 0.0f, 0.0f, 1.0f);
                }
                else if (lllllllllllllIIIIIlIlllllIIIlIII) {
                    RenderGlobal.drawBoundingBox(lllllllllllllIIIIIlIlllllIIIllll, lllllllllllllIIIIIlIlllllIIIIlIl, lllllllllllllIIIIIlIlllllIIIIlII, lllllllllllllIIIIIlIlllllIIIIIll, lllllllllllllIIIIIlIlllllIIIIIlI, lllllllllllllIIIIIlIlllllIIIIIIl, lllllllllllllIIIIIlIlllllIIIIIII, 0.5f, 0.5f, 1.0f, 1.0f);
                }
                else {
                    RenderGlobal.drawBoundingBox(lllllllllllllIIIIIlIlllllIIIllll, lllllllllllllIIIIIlIlllllIIIIlIl, lllllllllllllIIIIIlIlllllIIIIlII, lllllllllllllIIIIIlIlllllIIIIIll, lllllllllllllIIIIIlIlllllIIIIIlI, lllllllllllllIIIIIlIlllllIIIIIIl, lllllllllllllIIIIIlIlllllIIIIIII, 1.0f, 0.25f, 0.25f, 1.0f);
                }
            }
        }
        lllllllllllllIIIIIlIllllIllllIlI.draw();
    }
}
