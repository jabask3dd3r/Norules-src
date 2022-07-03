package net.minecraft.client.renderer;

import net.minecraft.client.renderer.color.*;
import net.minecraft.world.*;
import net.minecraft.block.state.*;
import net.minecraft.client.*;
import shadersmod.client.*;
import net.minecraft.crash.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.block.*;
import net.minecraft.util.*;
import javax.annotation.*;
import java.util.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.client.renderer.block.model.*;
import net.minecraft.util.math.*;
import optifine.*;

public class BlockModelRenderer
{
    private static /* synthetic */ float aoLightValueOpaque;
    private static final /* synthetic */ BlockRenderLayer[] OVERLAY_LAYERS;
    private final /* synthetic */ BlockColors blockColors;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing;
    
    public boolean renderModel(final IBlockAccess llllllllllllllIIIIIIlIlllIIlIlII, IBakedModel llllllllllllllIIIIIIlIlllIIlIIll, final IBlockState llllllllllllllIIIIIIlIlllIlIIIII, final BlockPos llllllllllllllIIIIIIlIlllIIlIIIl, final BufferBuilder llllllllllllllIIIIIIlIlllIIllllI, final boolean llllllllllllllIIIIIIlIlllIIIllll, long llllllllllllllIIIIIIlIlllIIIlllI) {
        final boolean llllllllllllllIIIIIIlIlllIIllIll = Minecraft.isAmbientOcclusionEnabled() && ReflectorForge.getLightValue(llllllllllllllIIIIIIlIlllIlIIIII, llllllllllllllIIIIIIlIlllIIlIlII, llllllllllllllIIIIIIlIlllIIlIIIl) == 0 && llllllllllllllIIIIIIlIlllIIlIIll.isAmbientOcclusion();
        try {
            if (Config.isShaders()) {
                SVertexBuilder.pushEntity(llllllllllllllIIIIIIlIlllIlIIIII, llllllllllllllIIIIIIlIlllIIlIIIl, llllllllllllllIIIIIIlIlllIIlIlII, llllllllllllllIIIIIIlIlllIIllllI);
            }
            if (!Config.isAlternateBlocks()) {
                llllllllllllllIIIIIIlIlllIIIlllI = 0L;
            }
            final RenderEnv llllllllllllllIIIIIIlIlllIIllIlI = llllllllllllllIIIIIIlIlllIIllllI.getRenderEnv(llllllllllllllIIIIIIlIlllIIlIlII, llllllllllllllIIIIIIlIlllIlIIIII, llllllllllllllIIIIIIlIlllIIlIIIl);
            llllllllllllllIIIIIIlIlllIIlIIll = BlockModelCustomizer.getRenderModel(llllllllllllllIIIIIIlIlllIIlIIll, llllllllllllllIIIIIIlIlllIlIIIII, llllllllllllllIIIIIIlIlllIIllIlI);
            final boolean llllllllllllllIIIIIIlIlllIIllIIl = llllllllllllllIIIIIIlIlllIIllIll ? this.renderModelSmooth(llllllllllllllIIIIIIlIlllIIlIlII, llllllllllllllIIIIIIlIlllIIlIIll, llllllllllllllIIIIIIlIlllIlIIIII, llllllllllllllIIIIIIlIlllIIlIIIl, llllllllllllllIIIIIIlIlllIIllllI, llllllllllllllIIIIIIlIlllIIIllll, llllllllllllllIIIIIIlIlllIIIlllI) : this.renderModelFlat(llllllllllllllIIIIIIlIlllIIlIlII, llllllllllllllIIIIIIlIlllIIlIIll, llllllllllllllIIIIIIlIlllIlIIIII, llllllllllllllIIIIIIlIlllIIlIIIl, llllllllllllllIIIIIIlIlllIIllllI, llllllllllllllIIIIIIlIlllIIIllll, llllllllllllllIIIIIIlIlllIIIlllI);
            if (llllllllllllllIIIIIIlIlllIIllIIl) {
                this.renderOverlayModels(llllllllllllllIIIIIIlIlllIIlIlII, llllllllllllllIIIIIIlIlllIIlIIll, llllllllllllllIIIIIIlIlllIlIIIII, llllllllllllllIIIIIIlIlllIIlIIIl, llllllllllllllIIIIIIlIlllIIllllI, llllllllllllllIIIIIIlIlllIIIllll, llllllllllllllIIIIIIlIlllIIIlllI, llllllllllllllIIIIIIlIlllIIllIlI, llllllllllllllIIIIIIlIlllIIllIll);
            }
            if (Config.isShaders()) {
                SVertexBuilder.popEntity(llllllllllllllIIIIIIlIlllIIllllI);
            }
            return llllllllllllllIIIIIIlIlllIIllIIl;
        }
        catch (Throwable llllllllllllllIIIIIIlIlllIIllIII) {
            final CrashReport llllllllllllllIIIIIIlIlllIIlIlll = CrashReport.makeCrashReport(llllllllllllllIIIIIIlIlllIIllIII, "Tesselating block model");
            final CrashReportCategory llllllllllllllIIIIIIlIlllIIlIllI = llllllllllllllIIIIIIlIlllIIlIlll.makeCategory("Block model being tesselated");
            CrashReportCategory.addBlockInfo(llllllllllllllIIIIIIlIlllIIlIllI, llllllllllllllIIIIIIlIlllIIlIIIl, llllllllllllllIIIIIIlIlllIlIIIII);
            llllllllllllllIIIIIIlIlllIIlIllI.addCrashSection("Using AO", llllllllllllllIIIIIIlIlllIIllIll);
            throw new ReportedException(llllllllllllllIIIIIIlIlllIIlIlll);
        }
    }
    
    public BlockModelRenderer(final BlockColors llllllllllllllIIIIIIlIlllllllIlI) {
        this.blockColors = llllllllllllllIIIIIIlIlllllllIlI;
        if (Reflector.ForgeModContainer_forgeLightPipelineEnabled.exists()) {
            Reflector.setFieldValue(Reflector.ForgeModContainer_forgeLightPipelineEnabled, false);
        }
    }
    
    public void renderModelBrightness(final IBakedModel llllllllllllllIIIIIIIlIllIllllll, final IBlockState llllllllllllllIIIIIIIlIllIlllllI, final float llllllllllllllIIIIIIIlIllIllIIll, final boolean llllllllllllllIIIIIIIlIllIllIIlI) {
        final Block llllllllllllllIIIIIIIlIllIlllIll = llllllllllllllIIIIIIIlIllIlllllI.getBlock();
        GlStateManager.rotate(90.0f, 0.0f, 1.0f, 0.0f);
        int llllllllllllllIIIIIIIlIllIlllIlI = this.blockColors.colorMultiplier(llllllllllllllIIIIIIIlIllIlllllI, null, null, 0);
        if (EntityRenderer.anaglyphEnable) {
            llllllllllllllIIIIIIIlIllIlllIlI = TextureUtil.anaglyphColor(llllllllllllllIIIIIIIlIllIlllIlI);
        }
        final float llllllllllllllIIIIIIIlIllIlllIIl = (llllllllllllllIIIIIIIlIllIlllIlI >> 16 & 0xFF) / 255.0f;
        final float llllllllllllllIIIIIIIlIllIlllIII = (llllllllllllllIIIIIIIlIllIlllIlI >> 8 & 0xFF) / 255.0f;
        final float llllllllllllllIIIIIIIlIllIllIlll = (llllllllllllllIIIIIIIlIllIlllIlI & 0xFF) / 255.0f;
        if (!llllllllllllllIIIIIIIlIllIllIIlI) {
            GlStateManager.color(llllllllllllllIIIIIIIlIllIllIIll, llllllllllllllIIIIIIIlIllIllIIll, llllllllllllllIIIIIIIlIllIllIIll, 1.0f);
        }
        this.renderModelBrightnessColor(llllllllllllllIIIIIIIlIllIlllllI, llllllllllllllIIIIIIIlIllIllllll, llllllllllllllIIIIIIIlIllIllIIll, llllllllllllllIIIIIIIlIllIlllIIl, llllllllllllllIIIIIIIlIllIlllIII, llllllllllllllIIIIIIIlIllIllIlll);
    }
    
    public boolean renderModel(final IBlockAccess llllllllllllllIIIIIIlIlllllIIllI, final IBakedModel llllllllllllllIIIIIIlIlllllIIlIl, final IBlockState llllllllllllllIIIIIIlIllllIllIIl, final BlockPos llllllllllllllIIIIIIlIllllIlIlll, final BufferBuilder llllllllllllllIIIIIIlIlllllIIIlI, final boolean llllllllllllllIIIIIIlIllllIlIIll) {
        return this.renderModel(llllllllllllllIIIIIIlIlllllIIllI, llllllllllllllIIIIIIlIlllllIIlIl, llllllllllllllIIIIIIlIllllIllIIl, llllllllllllllIIIIIIlIllllIlIlll, llllllllllllllIIIIIIlIlllllIIIlI, llllllllllllllIIIIIIlIllllIlIIll, MathHelper.getPositionRandom(llllllllllllllIIIIIIlIllllIlIlll));
    }
    
    private void fillQuadBounds(final IBlockState llllllllllllllIIIIIIlIlIllIIlIII, final int[] llllllllllllllIIIIIIlIlIllIIIlll, final EnumFacing llllllllllllllIIIIIIlIlIllIllIIl, @Nullable final float[] llllllllllllllIIIIIIlIlIllIllIII, final BitSet llllllllllllllIIIIIIlIlIllIIIlII) {
        float llllllllllllllIIIIIIlIlIllIlIllI = 32.0f;
        float llllllllllllllIIIIIIlIlIllIlIlIl = 32.0f;
        float llllllllllllllIIIIIIlIlIllIlIlII = 32.0f;
        float llllllllllllllIIIIIIlIlIllIlIIll = -32.0f;
        float llllllllllllllIIIIIIlIlIllIlIIlI = -32.0f;
        float llllllllllllllIIIIIIlIlIllIlIIIl = -32.0f;
        final int llllllllllllllIIIIIIlIlIllIlIIII = llllllllllllllIIIIIIlIlIllIIIlll.length / 4;
        for (int llllllllllllllIIIIIIlIlIllIIllll = 0; llllllllllllllIIIIIIlIlIllIIllll < 4; ++llllllllllllllIIIIIIlIlIllIIllll) {
            final float llllllllllllllIIIIIIlIlIllIIlllI = Float.intBitsToFloat(llllllllllllllIIIIIIlIlIllIIIlll[llllllllllllllIIIIIIlIlIllIIllll * llllllllllllllIIIIIIlIlIllIlIIII]);
            final float llllllllllllllIIIIIIlIlIllIIllIl = Float.intBitsToFloat(llllllllllllllIIIIIIlIlIllIIIlll[llllllllllllllIIIIIIlIlIllIIllll * llllllllllllllIIIIIIlIlIllIlIIII + 1]);
            final float llllllllllllllIIIIIIlIlIllIIllII = Float.intBitsToFloat(llllllllllllllIIIIIIlIlIllIIIlll[llllllllllllllIIIIIIlIlIllIIllll * llllllllllllllIIIIIIlIlIllIlIIII + 2]);
            llllllllllllllIIIIIIlIlIllIlIllI = Math.min(llllllllllllllIIIIIIlIlIllIlIllI, llllllllllllllIIIIIIlIlIllIIlllI);
            llllllllllllllIIIIIIlIlIllIlIlIl = Math.min(llllllllllllllIIIIIIlIlIllIlIlIl, llllllllllllllIIIIIIlIlIllIIllIl);
            llllllllllllllIIIIIIlIlIllIlIlII = Math.min(llllllllllllllIIIIIIlIlIllIlIlII, llllllllllllllIIIIIIlIlIllIIllII);
            llllllllllllllIIIIIIlIlIllIlIIll = Math.max(llllllllllllllIIIIIIlIlIllIlIIll, llllllllllllllIIIIIIlIlIllIIlllI);
            llllllllllllllIIIIIIlIlIllIlIIlI = Math.max(llllllllllllllIIIIIIlIlIllIlIIlI, llllllllllllllIIIIIIlIlIllIIllIl);
            llllllllllllllIIIIIIlIlIllIlIIIl = Math.max(llllllllllllllIIIIIIlIlIllIlIIIl, llllllllllllllIIIIIIlIlIllIIllII);
        }
        if (llllllllllllllIIIIIIlIlIllIllIII != null) {
            llllllllllllllIIIIIIlIlIllIllIII[EnumFacing.WEST.getIndex()] = llllllllllllllIIIIIIlIlIllIlIllI;
            llllllllllllllIIIIIIlIlIllIllIII[EnumFacing.EAST.getIndex()] = llllllllllllllIIIIIIlIlIllIlIIll;
            llllllllllllllIIIIIIlIlIllIllIII[EnumFacing.DOWN.getIndex()] = llllllllllllllIIIIIIlIlIllIlIlIl;
            llllllllllllllIIIIIIlIlIllIllIII[EnumFacing.UP.getIndex()] = llllllllllllllIIIIIIlIlIllIlIIlI;
            llllllllllllllIIIIIIlIlIllIllIII[EnumFacing.NORTH.getIndex()] = llllllllllllllIIIIIIlIlIllIlIlII;
            llllllllllllllIIIIIIlIlIllIllIII[EnumFacing.SOUTH.getIndex()] = llllllllllllllIIIIIIlIlIllIlIIIl;
            final int llllllllllllllIIIIIIlIlIllIIlIll = EnumFacing.VALUES.length;
            llllllllllllllIIIIIIlIlIllIllIII[EnumFacing.WEST.getIndex() + llllllllllllllIIIIIIlIlIllIIlIll] = 1.0f - llllllllllllllIIIIIIlIlIllIlIllI;
            llllllllllllllIIIIIIlIlIllIllIII[EnumFacing.EAST.getIndex() + llllllllllllllIIIIIIlIlIllIIlIll] = 1.0f - llllllllllllllIIIIIIlIlIllIlIIll;
            llllllllllllllIIIIIIlIlIllIllIII[EnumFacing.DOWN.getIndex() + llllllllllllllIIIIIIlIlIllIIlIll] = 1.0f - llllllllllllllIIIIIIlIlIllIlIlIl;
            llllllllllllllIIIIIIlIlIllIllIII[EnumFacing.UP.getIndex() + llllllllllllllIIIIIIlIlIllIIlIll] = 1.0f - llllllllllllllIIIIIIlIlIllIlIIlI;
            llllllllllllllIIIIIIlIlIllIllIII[EnumFacing.NORTH.getIndex() + llllllllllllllIIIIIIlIlIllIIlIll] = 1.0f - llllllllllllllIIIIIIlIlIllIlIlII;
            llllllllllllllIIIIIIlIlIllIllIII[EnumFacing.SOUTH.getIndex() + llllllllllllllIIIIIIlIlIllIIlIll] = 1.0f - llllllllllllllIIIIIIlIlIllIlIIIl;
        }
        final float llllllllllllllIIIIIIlIlIllIIlIlI = 1.0E-4f;
        final float llllllllllllllIIIIIIlIlIllIIlIIl = 0.9999f;
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[llllllllllllllIIIIIIlIlIllIllIIl.ordinal()]) {
            case 1: {
                llllllllllllllIIIIIIlIlIllIIIlII.set(1, llllllllllllllIIIIIIlIlIllIlIllI >= 1.0E-4f || llllllllllllllIIIIIIlIlIllIlIlII >= 1.0E-4f || llllllllllllllIIIIIIlIlIllIlIIll <= 0.9999f || llllllllllllllIIIIIIlIlIllIlIIIl <= 0.9999f);
                llllllllllllllIIIIIIlIlIllIIIlII.set(0, (llllllllllllllIIIIIIlIlIllIlIlIl < 1.0E-4f || llllllllllllllIIIIIIlIlIllIIlIII.isFullCube()) && llllllllllllllIIIIIIlIlIllIlIlIl == llllllllllllllIIIIIIlIlIllIlIIlI);
                break;
            }
            case 2: {
                llllllllllllllIIIIIIlIlIllIIIlII.set(1, llllllllllllllIIIIIIlIlIllIlIllI >= 1.0E-4f || llllllllllllllIIIIIIlIlIllIlIlII >= 1.0E-4f || llllllllllllllIIIIIIlIlIllIlIIll <= 0.9999f || llllllllllllllIIIIIIlIlIllIlIIIl <= 0.9999f);
                llllllllllllllIIIIIIlIlIllIIIlII.set(0, (llllllllllllllIIIIIIlIlIllIlIIlI > 0.9999f || llllllllllllllIIIIIIlIlIllIIlIII.isFullCube()) && llllllllllllllIIIIIIlIlIllIlIlIl == llllllllllllllIIIIIIlIlIllIlIIlI);
                break;
            }
            case 3: {
                llllllllllllllIIIIIIlIlIllIIIlII.set(1, llllllllllllllIIIIIIlIlIllIlIllI >= 1.0E-4f || llllllllllllllIIIIIIlIlIllIlIlIl >= 1.0E-4f || llllllllllllllIIIIIIlIlIllIlIIll <= 0.9999f || llllllllllllllIIIIIIlIlIllIlIIlI <= 0.9999f);
                llllllllllllllIIIIIIlIlIllIIIlII.set(0, (llllllllllllllIIIIIIlIlIllIlIlII < 1.0E-4f || llllllllllllllIIIIIIlIlIllIIlIII.isFullCube()) && llllllllllllllIIIIIIlIlIllIlIlII == llllllllllllllIIIIIIlIlIllIlIIIl);
                break;
            }
            case 4: {
                llllllllllllllIIIIIIlIlIllIIIlII.set(1, llllllllllllllIIIIIIlIlIllIlIllI >= 1.0E-4f || llllllllllllllIIIIIIlIlIllIlIlIl >= 1.0E-4f || llllllllllllllIIIIIIlIlIllIlIIll <= 0.9999f || llllllllllllllIIIIIIlIlIllIlIIlI <= 0.9999f);
                llllllllllllllIIIIIIlIlIllIIIlII.set(0, (llllllllllllllIIIIIIlIlIllIlIIIl > 0.9999f || llllllllllllllIIIIIIlIlIllIIlIII.isFullCube()) && llllllllllllllIIIIIIlIlIllIlIlII == llllllllllllllIIIIIIlIlIllIlIIIl);
                break;
            }
            case 5: {
                llllllllllllllIIIIIIlIlIllIIIlII.set(1, llllllllllllllIIIIIIlIlIllIlIlIl >= 1.0E-4f || llllllllllllllIIIIIIlIlIllIlIlII >= 1.0E-4f || llllllllllllllIIIIIIlIlIllIlIIlI <= 0.9999f || llllllllllllllIIIIIIlIlIllIlIIIl <= 0.9999f);
                llllllllllllllIIIIIIlIlIllIIIlII.set(0, (llllllllllllllIIIIIIlIlIllIlIllI < 1.0E-4f || llllllllllllllIIIIIIlIlIllIIlIII.isFullCube()) && llllllllllllllIIIIIIlIlIllIlIllI == llllllllllllllIIIIIIlIlIllIlIIll);
                break;
            }
            case 6: {
                llllllllllllllIIIIIIlIlIllIIIlII.set(1, llllllllllllllIIIIIIlIlIllIlIlIl >= 1.0E-4f || llllllllllllllIIIIIIlIlIllIlIlII >= 1.0E-4f || llllllllllllllIIIIIIlIlIllIlIIlI <= 0.9999f || llllllllllllllIIIIIIlIlIllIlIIIl <= 0.9999f);
                llllllllllllllIIIIIIlIlIllIIIlII.set(0, (llllllllllllllIIIIIIlIlIllIlIIll > 0.9999f || llllllllllllllIIIIIIlIlIllIIlIII.isFullCube()) && llllllllllllllIIIIIIlIlIllIlIllI == llllllllllllllIIIIIIlIlIllIlIIll);
                break;
            }
        }
    }
    
    public void renderModelBrightnessColor(final IBlockState llllllllllllllIIIIIIIlIlllIlllII, final IBakedModel llllllllllllllIIIIIIIlIlllIlIIll, final float llllllllllllllIIIIIIIlIlllIllIlI, final float llllllllllllllIIIIIIIlIlllIlIIIl, final float llllllllllllllIIIIIIIlIlllIlIIII, final float llllllllllllllIIIIIIIlIlllIIllll) {
        final byte llllllllllllllIIIIIIIlIlllIIlIll;
        final int llllllllllllllIIIIIIIlIlllIIllII = ((EnumFacing[])(Object)(llllllllllllllIIIIIIIlIlllIIlIll = (byte)(Object)EnumFacing.VALUES)).length;
        for (byte llllllllllllllIIIIIIIlIlllIIllIl = 0; llllllllllllllIIIIIIIlIlllIIllIl < llllllllllllllIIIIIIIlIlllIIllII; ++llllllllllllllIIIIIIIlIlllIIllIl) {
            final EnumFacing llllllllllllllIIIIIIIlIlllIlIllI = llllllllllllllIIIIIIIlIlllIIlIll[llllllllllllllIIIIIIIlIlllIIllIl];
            this.renderModelBrightnessColorQuads(llllllllllllllIIIIIIIlIlllIllIlI, llllllllllllllIIIIIIIlIlllIlIIIl, llllllllllllllIIIIIIIlIlllIlIIII, llllllllllllllIIIIIIIlIlllIIllll, llllllllllllllIIIIIIIlIlllIlIIll.getQuads(llllllllllllllIIIIIIIlIlllIlllII, llllllllllllllIIIIIIIlIlllIlIllI, 0L));
        }
        this.renderModelBrightnessColorQuads(llllllllllllllIIIIIIIlIlllIllIlI, llllllllllllllIIIIIIIlIlllIlIIIl, llllllllllllllIIIIIIIlIlllIlIIII, llllllllllllllIIIIIIIlIlllIIllll, llllllllllllllIIIIIIIlIlllIlIIll.getQuads(llllllllllllllIIIIIIIlIlllIlllII, null, 0L));
    }
    
    public boolean renderModelSmooth(final IBlockAccess llllllllllllllIIIIIIlIllIllIllII, final IBakedModel llllllllllllllIIIIIIlIllIllllIII, final IBlockState llllllllllllllIIIIIIlIllIllIlIlI, final BlockPos llllllllllllllIIIIIIlIllIlllIllI, final BufferBuilder llllllllllllllIIIIIIlIllIlllIlIl, final boolean llllllllllllllIIIIIIlIllIlllIlII, final long llllllllllllllIIIIIIlIllIllIIllI) {
        boolean llllllllllllllIIIIIIlIllIlllIIlI = false;
        final RenderEnv llllllllllllllIIIIIIlIllIlllIIIl = llllllllllllllIIIIIIlIllIlllIlIl.getRenderEnv(llllllllllllllIIIIIIlIllIllIllII, llllllllllllllIIIIIIlIllIllIlIlI, llllllllllllllIIIIIIlIllIlllIllI);
        final int llllllllllllllIIIIIIlIllIllIIIII;
        final String llllllllllllllIIIIIIlIllIllIIIIl = (String)((EnumFacing[])(Object)(llllllllllllllIIIIIIlIllIllIIIII = (int)(Object)EnumFacing.VALUES)).length;
        for (char llllllllllllllIIIIIIlIllIllIIIlI = '\0'; llllllllllllllIIIIIIlIllIllIIIlI < llllllllllllllIIIIIIlIllIllIIIIl; ++llllllllllllllIIIIIIlIllIllIIIlI) {
            final EnumFacing llllllllllllllIIIIIIlIllIlllIIII = llllllllllllllIIIIIIlIllIllIIIII[llllllllllllllIIIIIIlIllIllIIIlI];
            List<BakedQuad> llllllllllllllIIIIIIlIllIllIllll = llllllllllllllIIIIIIlIllIllllIII.getQuads(llllllllllllllIIIIIIlIllIllIlIlI, llllllllllllllIIIIIIlIllIlllIIII, llllllllllllllIIIIIIlIllIllIIllI);
            if (!llllllllllllllIIIIIIlIllIllIllll.isEmpty() && (!llllllllllllllIIIIIIlIllIlllIlII || llllllllllllllIIIIIIlIllIllIlIlI.shouldSideBeRendered(llllllllllllllIIIIIIlIllIllIllII, llllllllllllllIIIIIIlIllIlllIllI, llllllllllllllIIIIIIlIllIlllIIII))) {
                llllllllllllllIIIIIIlIllIllIllll = BlockModelCustomizer.getRenderQuads(llllllllllllllIIIIIIlIllIllIllll, llllllllllllllIIIIIIlIllIllIllII, llllllllllllllIIIIIIlIllIllIlIlI, llllllllllllllIIIIIIlIllIlllIllI, llllllllllllllIIIIIIlIllIlllIIII, llllllllllllllIIIIIIlIllIllIIllI, llllllllllllllIIIIIIlIllIlllIIIl);
                this.renderQuadsSmooth(llllllllllllllIIIIIIlIllIllIllII, llllllllllllllIIIIIIlIllIllIlIlI, llllllllllllllIIIIIIlIllIlllIllI, llllllllllllllIIIIIIlIllIlllIlIl, llllllllllllllIIIIIIlIllIllIllll, llllllllllllllIIIIIIlIllIlllIIIl);
                llllllllllllllIIIIIIlIllIlllIIlI = true;
            }
        }
        List<BakedQuad> llllllllllllllIIIIIIlIllIllIlllI = llllllllllllllIIIIIIlIllIllllIII.getQuads(llllllllllllllIIIIIIlIllIllIlIlI, null, llllllllllllllIIIIIIlIllIllIIllI);
        if (!llllllllllllllIIIIIIlIllIllIlllI.isEmpty()) {
            llllllllllllllIIIIIIlIllIllIlllI = BlockModelCustomizer.getRenderQuads(llllllllllllllIIIIIIlIllIllIlllI, llllllllllllllIIIIIIlIllIllIllII, llllllllllllllIIIIIIlIllIllIlIlI, llllllllllllllIIIIIIlIllIlllIllI, null, llllllllllllllIIIIIIlIllIllIIllI, llllllllllllllIIIIIIlIllIlllIIIl);
            this.renderQuadsSmooth(llllllllllllllIIIIIIlIllIllIllII, llllllllllllllIIIIIIlIllIllIlIlI, llllllllllllllIIIIIIlIllIlllIllI, llllllllllllllIIIIIIlIllIlllIlIl, llllllllllllllIIIIIIlIllIllIlllI, llllllllllllllIIIIIIlIllIlllIIIl);
            llllllllllllllIIIIIIlIllIlllIIlI = true;
        }
        return llllllllllllllIIIIIIlIllIlllIIlI;
    }
    
    static {
        BlockModelRenderer.aoLightValueOpaque = 0.2f;
        OVERLAY_LAYERS = new BlockRenderLayer[] { BlockRenderLayer.CUTOUT, BlockRenderLayer.CUTOUT_MIPPED, BlockRenderLayer.TRANSLUCENT };
    }
    
    private void renderModelBrightnessColorQuads(final float llllllllllllllIIIIIIIlIllIIlIlIl, final float llllllllllllllIIIIIIIlIllIIlllll, final float llllllllllllllIIIIIIIlIllIIllllI, final float llllllllllllllIIIIIIIlIllIIlIIlI, final List<BakedQuad> llllllllllllllIIIIIIIlIllIIlllII) {
        final Tessellator llllllllllllllIIIIIIIlIllIIllIll = Tessellator.getInstance();
        final BufferBuilder llllllllllllllIIIIIIIlIllIIllIlI = llllllllllllllIIIIIIIlIllIIllIll.getBuffer();
        for (int llllllllllllllIIIIIIIlIllIIllIIl = 0, llllllllllllllIIIIIIIlIllIIllIII = llllllllllllllIIIIIIIlIllIIlllII.size(); llllllllllllllIIIIIIIlIllIIllIIl < llllllllllllllIIIIIIIlIllIIllIII; ++llllllllllllllIIIIIIIlIllIIllIIl) {
            final BakedQuad llllllllllllllIIIIIIIlIllIIlIlll = llllllllllllllIIIIIIIlIllIIlllII.get(llllllllllllllIIIIIIIlIllIIllIIl);
            llllllllllllllIIIIIIIlIllIIllIlI.begin(7, DefaultVertexFormats.ITEM);
            llllllllllllllIIIIIIIlIllIIllIlI.addVertexData(llllllllllllllIIIIIIIlIllIIlIlll.getVertexData());
            if (llllllllllllllIIIIIIIlIllIIlIlll.hasTintIndex()) {
                llllllllllllllIIIIIIIlIllIIllIlI.putColorRGB_F4(llllllllllllllIIIIIIIlIllIIlllll * llllllllllllllIIIIIIIlIllIIlIlIl, llllllllllllllIIIIIIIlIllIIllllI * llllllllllllllIIIIIIIlIllIIlIlIl, llllllllllllllIIIIIIIlIllIIlIIlI * llllllllllllllIIIIIIIlIllIIlIlIl);
            }
            else {
                llllllllllllllIIIIIIIlIllIIllIlI.putColorRGB_F4(llllllllllllllIIIIIIIlIllIIlIlIl, llllllllllllllIIIIIIIlIllIIlIlIl, llllllllllllllIIIIIIIlIllIIlIlIl);
            }
            final Vec3i llllllllllllllIIIIIIIlIllIIlIllI = llllllllllllllIIIIIIIlIllIIlIlll.getFace().getDirectionVec();
            llllllllllllllIIIIIIIlIllIIllIlI.putNormal((float)llllllllllllllIIIIIIIlIllIIlIllI.getX(), (float)llllllllllllllIIIIIIIlIllIIlIllI.getY(), (float)llllllllllllllIIIIIIIlIllIIlIllI.getZ());
            llllllllllllllIIIIIIIlIllIIllIll.draw();
        }
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing = BlockModelRenderer.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
        if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing;
        }
        final String llllllllllllllIIIIIIIlIlIlIIlIlI = (Object)new int[EnumFacing.values().length];
        try {
            llllllllllllllIIIIIIIlIlIlIIlIlI[EnumFacing.DOWN.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllIIIIIIIlIlIlIIlIlI[EnumFacing.EAST.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllllIIIIIIIlIlIlIIlIlI[EnumFacing.NORTH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllllIIIIIIIlIlIlIIlIlI[EnumFacing.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            llllllllllllllIIIIIIIlIlIlIIlIlI[EnumFacing.UP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            llllllllllllllIIIIIIIlIlIlIIlIlI[EnumFacing.WEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return BlockModelRenderer.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)llllllllllllllIIIIIIIlIlIlIIlIlI;
    }
    
    private void renderQuadsFlat(final IBlockAccess llllllllllllllIIIIIIIllIIIIlIIII, final IBlockState llllllllllllllIIIIIIIllIIIIIllll, final BlockPos llllllllllllllIIIIIIIllIIIIIlllI, int llllllllllllllIIIIIIIllIIIIIllIl, final boolean llllllllllllllIIIIIIIllIIIIIllII, final BufferBuilder llllllllllllllIIIIIIIllIIIlIIlII, final List<BakedQuad> llllllllllllllIIIIIIIllIIIIIlIlI, final RenderEnv llllllllllllllIIIIIIIllIIIlIIIlI) {
        final BitSet llllllllllllllIIIIIIIllIIIlIIIIl = llllllllllllllIIIIIIIllIIIlIIIlI.getBoundsFlags();
        final Vec3d llllllllllllllIIIIIIIllIIIlIIIII = llllllllllllllIIIIIIIllIIIIIllll.func_191059_e(llllllllllllllIIIIIIIllIIIIlIIII, llllllllllllllIIIIIIIllIIIIIlllI);
        final double llllllllllllllIIIIIIIllIIIIlllll = llllllllllllllIIIIIIIllIIIIIlllI.getX() + llllllllllllllIIIIIIIllIIIlIIIII.xCoord;
        final double llllllllllllllIIIIIIIllIIIIllllI = llllllllllllllIIIIIIIllIIIIIlllI.getY() + llllllllllllllIIIIIIIllIIIlIIIII.yCoord;
        final double llllllllllllllIIIIIIIllIIIIlllIl = llllllllllllllIIIIIIIllIIIIIlllI.getZ() + llllllllllllllIIIIIIIllIIIlIIIII.zCoord;
        for (int llllllllllllllIIIIIIIllIIIIlllII = 0, llllllllllllllIIIIIIIllIIIIllIll = llllllllllllllIIIIIIIllIIIIIlIlI.size(); llllllllllllllIIIIIIIllIIIIlllII < llllllllllllllIIIIIIIllIIIIllIll; ++llllllllllllllIIIIIIIllIIIIlllII) {
            final BakedQuad llllllllllllllIIIIIIIllIIIIllIlI = llllllllllllllIIIIIIIllIIIIIlIlI.get(llllllllllllllIIIIIIIllIIIIlllII);
            if (llllllllllllllIIIIIIIllIIIIIllII) {
                this.fillQuadBounds(llllllllllllllIIIIIIIllIIIIIllll, llllllllllllllIIIIIIIllIIIIllIlI.getVertexData(), llllllllllllllIIIIIIIllIIIIllIlI.getFace(), null, llllllllllllllIIIIIIIllIIIlIIIIl);
                final BlockPos llllllllllllllIIIIIIIllIIIIllIIl = llllllllllllllIIIIIIIllIIIlIIIIl.get(0) ? llllllllllllllIIIIIIIllIIIIIlllI.offset(llllllllllllllIIIIIIIllIIIIllIlI.getFace()) : llllllllllllllIIIIIIIllIIIIIlllI;
                llllllllllllllIIIIIIIllIIIIIllIl = llllllllllllllIIIIIIIllIIIIIllll.getPackedLightmapCoords(llllllllllllllIIIIIIIllIIIIlIIII, llllllllllllllIIIIIIIllIIIIllIIl);
            }
            if (llllllllllllllIIIIIIIllIIIlIIlII.isMultiTexture()) {
                llllllllllllllIIIIIIIllIIIlIIlII.addVertexData(llllllllllllllIIIIIIIllIIIIllIlI.getVertexDataSingle());
                llllllllllllllIIIIIIIllIIIlIIlII.putSprite(llllllllllllllIIIIIIIllIIIIllIlI.getSprite());
            }
            else {
                llllllllllllllIIIIIIIllIIIlIIlII.addVertexData(llllllllllllllIIIIIIIllIIIIllIlI.getVertexData());
            }
            llllllllllllllIIIIIIIllIIIlIIlII.putBrightness4(llllllllllllllIIIIIIIllIIIIIllIl, llllllllllllllIIIIIIIllIIIIIllIl, llllllllllllllIIIIIIIllIIIIIllIl, llllllllllllllIIIIIIIllIIIIIllIl);
            final int llllllllllllllIIIIIIIllIIIIllIII = CustomColors.getColorMultiplier(llllllllllllllIIIIIIIllIIIIllIlI, llllllllllllllIIIIIIIllIIIIIllll, llllllllllllllIIIIIIIllIIIIlIIII, llllllllllllllIIIIIIIllIIIIIlllI, llllllllllllllIIIIIIIllIIIlIIIlI);
            if (!llllllllllllllIIIIIIIllIIIIllIlI.hasTintIndex() && llllllllllllllIIIIIIIllIIIIllIII == -1) {
                if (llllllllllllllIIIIIIIllIIIIllIlI.shouldApplyDiffuseLighting()) {
                    final float llllllllllllllIIIIIIIllIIIIlIlll = FaceBakery.getFaceBrightness(llllllllllllllIIIIIIIllIIIIllIlI.getFace());
                    llllllllllllllIIIIIIIllIIIlIIlII.putColorMultiplier(llllllllllllllIIIIIIIllIIIIlIlll, llllllllllllllIIIIIIIllIIIIlIlll, llllllllllllllIIIIIIIllIIIIlIlll, 4);
                    llllllllllllllIIIIIIIllIIIlIIlII.putColorMultiplier(llllllllllllllIIIIIIIllIIIIlIlll, llllllllllllllIIIIIIIllIIIIlIlll, llllllllllllllIIIIIIIllIIIIlIlll, 3);
                    llllllllllllllIIIIIIIllIIIlIIlII.putColorMultiplier(llllllllllllllIIIIIIIllIIIIlIlll, llllllllllllllIIIIIIIllIIIIlIlll, llllllllllllllIIIIIIIllIIIIlIlll, 2);
                    llllllllllllllIIIIIIIllIIIlIIlII.putColorMultiplier(llllllllllllllIIIIIIIllIIIIlIlll, llllllllllllllIIIIIIIllIIIIlIlll, llllllllllllllIIIIIIIllIIIIlIlll, 1);
                }
            }
            else {
                int llllllllllllllIIIIIIIllIIIIlIllI;
                if ((llllllllllllllIIIIIIIllIIIIlIllI = llllllllllllllIIIIIIIllIIIIllIII) == -1) {
                    llllllllllllllIIIIIIIllIIIIlIllI = this.blockColors.colorMultiplier(llllllllllllllIIIIIIIllIIIIIllll, llllllllllllllIIIIIIIllIIIIlIIII, llllllllllllllIIIIIIIllIIIIIlllI, llllllllllllllIIIIIIIllIIIIllIlI.getTintIndex());
                }
                if (EntityRenderer.anaglyphEnable) {
                    llllllllllllllIIIIIIIllIIIIlIllI = TextureUtil.anaglyphColor(llllllllllllllIIIIIIIllIIIIlIllI);
                }
                float llllllllllllllIIIIIIIllIIIIlIlIl = (llllllllllllllIIIIIIIllIIIIlIllI >> 16 & 0xFF) / 255.0f;
                float llllllllllllllIIIIIIIllIIIIlIlII = (llllllllllllllIIIIIIIllIIIIlIllI >> 8 & 0xFF) / 255.0f;
                float llllllllllllllIIIIIIIllIIIIlIIll = (llllllllllllllIIIIIIIllIIIIlIllI & 0xFF) / 255.0f;
                if (llllllllllllllIIIIIIIllIIIIllIlI.shouldApplyDiffuseLighting()) {
                    final float llllllllllllllIIIIIIIllIIIIlIIlI = FaceBakery.getFaceBrightness(llllllllllllllIIIIIIIllIIIIllIlI.getFace());
                    llllllllllllllIIIIIIIllIIIIlIlIl *= llllllllllllllIIIIIIIllIIIIlIIlI;
                    llllllllllllllIIIIIIIllIIIIlIlII *= llllllllllllllIIIIIIIllIIIIlIIlI;
                    llllllllllllllIIIIIIIllIIIIlIIll *= llllllllllllllIIIIIIIllIIIIlIIlI;
                }
                llllllllllllllIIIIIIIllIIIlIIlII.putColorMultiplier(llllllllllllllIIIIIIIllIIIIlIlIl, llllllllllllllIIIIIIIllIIIIlIlII, llllllllllllllIIIIIIIllIIIIlIIll, 4);
                llllllllllllllIIIIIIIllIIIlIIlII.putColorMultiplier(llllllllllllllIIIIIIIllIIIIlIlIl, llllllllllllllIIIIIIIllIIIIlIlII, llllllllllllllIIIIIIIllIIIIlIIll, 3);
                llllllllllllllIIIIIIIllIIIlIIlII.putColorMultiplier(llllllllllllllIIIIIIIllIIIIlIlIl, llllllllllllllIIIIIIIllIIIIlIlII, llllllllllllllIIIIIIIllIIIIlIIll, 2);
                llllllllllllllIIIIIIIllIIIlIIlII.putColorMultiplier(llllllllllllllIIIIIIIllIIIIlIlIl, llllllllllllllIIIIIIIllIIIIlIlII, llllllllllllllIIIIIIIllIIIIlIIll, 1);
            }
            llllllllllllllIIIIIIIllIIIlIIlII.putPosition(llllllllllllllIIIIIIIllIIIIlllll, llllllllllllllIIIIIIIllIIIIllllI, llllllllllllllIIIIIIIllIIIIlllIl);
        }
    }
    
    public static float fixAoLightValue(final float llllllllllllllIIIIIIIlIllIIIlIIl) {
        return (llllllllllllllIIIIIIIlIllIIIlIIl == 0.2f) ? BlockModelRenderer.aoLightValueOpaque : llllllllllllllIIIIIIIlIllIIIlIIl;
    }
    
    private void renderQuadsSmooth(final IBlockAccess llllllllllllllIIIIIIlIllIIIIIIIl, final IBlockState llllllllllllllIIIIIIlIllIIIIIIII, final BlockPos llllllllllllllIIIIIIlIllIIIlIlll, final BufferBuilder llllllllllllllIIIIIIlIllIIIlIllI, final List<BakedQuad> llllllllllllllIIIIIIlIlIllllllIl, final RenderEnv llllllllllllllIIIIIIlIlIllllllII) {
        final float[] llllllllllllllIIIIIIlIllIIIlIIll = llllllllllllllIIIIIIlIlIllllllII.getQuadBounds();
        final BitSet llllllllllllllIIIIIIlIllIIIlIIlI = llllllllllllllIIIIIIlIlIllllllII.getBoundsFlags();
        final AmbientOcclusionFace llllllllllllllIIIIIIlIllIIIlIIIl = llllllllllllllIIIIIIlIlIllllllII.getAoFace();
        final Vec3d llllllllllllllIIIIIIlIllIIIlIIII = llllllllllllllIIIIIIlIllIIIIIIII.func_191059_e(llllllllllllllIIIIIIlIllIIIIIIIl, llllllllllllllIIIIIIlIllIIIlIlll);
        final double llllllllllllllIIIIIIlIllIIIIllll = llllllllllllllIIIIIIlIllIIIlIlll.getX() + llllllllllllllIIIIIIlIllIIIlIIII.xCoord;
        final double llllllllllllllIIIIIIlIllIIIIlllI = llllllllllllllIIIIIIlIllIIIlIlll.getY() + llllllllllllllIIIIIIlIllIIIlIIII.yCoord;
        final double llllllllllllllIIIIIIlIllIIIIllIl = llllllllllllllIIIIIIlIllIIIlIlll.getZ() + llllllllllllllIIIIIIlIllIIIlIIII.zCoord;
        for (int llllllllllllllIIIIIIlIllIIIIllII = 0, llllllllllllllIIIIIIlIllIIIIlIll = llllllllllllllIIIIIIlIlIllllllIl.size(); llllllllllllllIIIIIIlIllIIIIllII < llllllllllllllIIIIIIlIllIIIIlIll; ++llllllllllllllIIIIIIlIllIIIIllII) {
            final BakedQuad llllllllllllllIIIIIIlIllIIIIlIlI = llllllllllllllIIIIIIlIlIllllllIl.get(llllllllllllllIIIIIIlIllIIIIllII);
            this.fillQuadBounds(llllllllllllllIIIIIIlIllIIIIIIII, llllllllllllllIIIIIIlIllIIIIlIlI.getVertexData(), llllllllllllllIIIIIIlIllIIIIlIlI.getFace(), llllllllllllllIIIIIIlIllIIIlIIll, llllllllllllllIIIIIIlIllIIIlIIlI);
            llllllllllllllIIIIIIlIllIIIlIIIl.updateVertexBrightness(llllllllllllllIIIIIIlIllIIIIIIIl, llllllllllllllIIIIIIlIllIIIIIIII, llllllllllllllIIIIIIlIllIIIlIlll, llllllllllllllIIIIIIlIllIIIIlIlI.getFace(), llllllllllllllIIIIIIlIllIIIlIIll, llllllllllllllIIIIIIlIllIIIlIIlI);
            if (llllllllllllllIIIIIIlIllIIIlIllI.isMultiTexture()) {
                llllllllllllllIIIIIIlIllIIIlIllI.addVertexData(llllllllllllllIIIIIIlIllIIIIlIlI.getVertexDataSingle());
                llllllllllllllIIIIIIlIllIIIlIllI.putSprite(llllllllllllllIIIIIIlIllIIIIlIlI.getSprite());
            }
            else {
                llllllllllllllIIIIIIlIllIIIlIllI.addVertexData(llllllllllllllIIIIIIlIllIIIIlIlI.getVertexData());
            }
            llllllllllllllIIIIIIlIllIIIlIllI.putBrightness4(llllllllllllllIIIIIIlIllIIIlIIIl.vertexBrightness[0], llllllllllllllIIIIIIlIllIIIlIIIl.vertexBrightness[1], llllllllllllllIIIIIIlIllIIIlIIIl.vertexBrightness[2], llllllllllllllIIIIIIlIllIIIlIIIl.vertexBrightness[3]);
            if (llllllllllllllIIIIIIlIllIIIIlIlI.shouldApplyDiffuseLighting()) {
                final float llllllllllllllIIIIIIlIllIIIIlIIl = FaceBakery.getFaceBrightness(llllllllllllllIIIIIIlIllIIIIlIlI.getFace());
                final float[] access$1;
                float[] llllllllllllllIIIIIIlIllIIIIlIII = access$1 = llllllllllllllIIIIIIlIllIIIlIIIl.vertexColorMultiplier;
                final int n = 0;
                access$1[n] *= llllllllllllllIIIIIIlIllIIIIlIIl;
                final float[] access$2;
                llllllllllllllIIIIIIlIllIIIIlIII = (access$2 = llllllllllllllIIIIIIlIllIIIlIIIl.vertexColorMultiplier);
                final int n2 = 1;
                access$2[n2] *= llllllllllllllIIIIIIlIllIIIIlIIl;
                final float[] access$3;
                llllllllllllllIIIIIIlIllIIIIlIII = (access$3 = llllllllllllllIIIIIIlIllIIIlIIIl.vertexColorMultiplier);
                final int n3 = 2;
                access$3[n3] *= llllllllllllllIIIIIIlIllIIIIlIIl;
                final float[] access$4;
                llllllllllllllIIIIIIlIllIIIIlIII = (access$4 = llllllllllllllIIIIIIlIllIIIlIIIl.vertexColorMultiplier);
                final int n4 = 3;
                access$4[n4] *= llllllllllllllIIIIIIlIllIIIIlIIl;
            }
            final int llllllllllllllIIIIIIlIllIIIIIlll = CustomColors.getColorMultiplier(llllllllllllllIIIIIIlIllIIIIlIlI, llllllllllllllIIIIIIlIllIIIIIIII, llllllllllllllIIIIIIlIllIIIIIIIl, llllllllllllllIIIIIIlIllIIIlIlll, llllllllllllllIIIIIIlIlIllllllII);
            if (!llllllllllllllIIIIIIlIllIIIIlIlI.hasTintIndex() && llllllllllllllIIIIIIlIllIIIIIlll == -1) {
                llllllllllllllIIIIIIlIllIIIlIllI.putColorMultiplier(llllllllllllllIIIIIIlIllIIIlIIIl.vertexColorMultiplier[0], llllllllllllllIIIIIIlIllIIIlIIIl.vertexColorMultiplier[0], llllllllllllllIIIIIIlIllIIIlIIIl.vertexColorMultiplier[0], 4);
                llllllllllllllIIIIIIlIllIIIlIllI.putColorMultiplier(llllllllllllllIIIIIIlIllIIIlIIIl.vertexColorMultiplier[1], llllllllllllllIIIIIIlIllIIIlIIIl.vertexColorMultiplier[1], llllllllllllllIIIIIIlIllIIIlIIIl.vertexColorMultiplier[1], 3);
                llllllllllllllIIIIIIlIllIIIlIllI.putColorMultiplier(llllllllllllllIIIIIIlIllIIIlIIIl.vertexColorMultiplier[2], llllllllllllllIIIIIIlIllIIIlIIIl.vertexColorMultiplier[2], llllllllllllllIIIIIIlIllIIIlIIIl.vertexColorMultiplier[2], 2);
                llllllllllllllIIIIIIlIllIIIlIllI.putColorMultiplier(llllllllllllllIIIIIIlIllIIIlIIIl.vertexColorMultiplier[3], llllllllllllllIIIIIIlIllIIIlIIIl.vertexColorMultiplier[3], llllllllllllllIIIIIIlIllIIIlIIIl.vertexColorMultiplier[3], 1);
            }
            else {
                int llllllllllllllIIIIIIlIllIIIIIllI;
                if ((llllllllllllllIIIIIIlIllIIIIIllI = llllllllllllllIIIIIIlIllIIIIIlll) == -1) {
                    llllllllllllllIIIIIIlIllIIIIIllI = this.blockColors.colorMultiplier(llllllllllllllIIIIIIlIllIIIIIIII, llllllllllllllIIIIIIlIllIIIIIIIl, llllllllllllllIIIIIIlIllIIIlIlll, llllllllllllllIIIIIIlIllIIIIlIlI.getTintIndex());
                }
                if (EntityRenderer.anaglyphEnable) {
                    llllllllllllllIIIIIIlIllIIIIIllI = TextureUtil.anaglyphColor(llllllllllllllIIIIIIlIllIIIIIllI);
                }
                final float llllllllllllllIIIIIIlIllIIIIIlIl = (llllllllllllllIIIIIIlIllIIIIIllI >> 16 & 0xFF) / 255.0f;
                final float llllllllllllllIIIIIIlIllIIIIIlII = (llllllllllllllIIIIIIlIllIIIIIllI >> 8 & 0xFF) / 255.0f;
                final float llllllllllllllIIIIIIlIllIIIIIIll = (llllllllllllllIIIIIIlIllIIIIIllI & 0xFF) / 255.0f;
                llllllllllllllIIIIIIlIllIIIlIllI.putColorMultiplier(llllllllllllllIIIIIIlIllIIIlIIIl.vertexColorMultiplier[0] * llllllllllllllIIIIIIlIllIIIIIlIl, llllllllllllllIIIIIIlIllIIIlIIIl.vertexColorMultiplier[0] * llllllllllllllIIIIIIlIllIIIIIlII, llllllllllllllIIIIIIlIllIIIlIIIl.vertexColorMultiplier[0] * llllllllllllllIIIIIIlIllIIIIIIll, 4);
                llllllllllllllIIIIIIlIllIIIlIllI.putColorMultiplier(llllllllllllllIIIIIIlIllIIIlIIIl.vertexColorMultiplier[1] * llllllllllllllIIIIIIlIllIIIIIlIl, llllllllllllllIIIIIIlIllIIIlIIIl.vertexColorMultiplier[1] * llllllllllllllIIIIIIlIllIIIIIlII, llllllllllllllIIIIIIlIllIIIlIIIl.vertexColorMultiplier[1] * llllllllllllllIIIIIIlIllIIIIIIll, 3);
                llllllllllllllIIIIIIlIllIIIlIllI.putColorMultiplier(llllllllllllllIIIIIIlIllIIIlIIIl.vertexColorMultiplier[2] * llllllllllllllIIIIIIlIllIIIIIlIl, llllllllllllllIIIIIIlIllIIIlIIIl.vertexColorMultiplier[2] * llllllllllllllIIIIIIlIllIIIIIlII, llllllllllllllIIIIIIlIllIIIlIIIl.vertexColorMultiplier[2] * llllllllllllllIIIIIIlIllIIIIIIll, 2);
                llllllllllllllIIIIIIlIllIIIlIllI.putColorMultiplier(llllllllllllllIIIIIIlIllIIIlIIIl.vertexColorMultiplier[3] * llllllllllllllIIIIIIlIllIIIIIlIl, llllllllllllllIIIIIIlIllIIIlIIIl.vertexColorMultiplier[3] * llllllllllllllIIIIIIlIllIIIIIlII, llllllllllllllIIIIIIlIllIIIlIIIl.vertexColorMultiplier[3] * llllllllllllllIIIIIIlIllIIIIIIll, 1);
            }
            llllllllllllllIIIIIIlIllIIIlIllI.putPosition(llllllllllllllIIIIIIlIllIIIIllll, llllllllllllllIIIIIIlIllIIIIlllI, llllllllllllllIIIIIIlIllIIIIllIl);
        }
    }
    
    public static void updateAoLightValue() {
        BlockModelRenderer.aoLightValueOpaque = 1.0f - Config.getAmbientOcclusionLevel() * 0.8f;
    }
    
    public boolean renderModelFlat(final IBlockAccess llllllllllllllIIIIIIlIllIlIIllIl, final IBakedModel llllllllllllllIIIIIIlIllIIlllllI, final IBlockState llllllllllllllIIIIIIlIllIlIIlIll, final BlockPos llllllllllllllIIIIIIlIllIIllllII, final BufferBuilder llllllllllllllIIIIIIlIllIIlllIll, final boolean llllllllllllllIIIIIIlIllIIlllIlI, final long llllllllllllllIIIIIIlIllIIlllIIl) {
        boolean llllllllllllllIIIIIIlIllIlIIIllI = false;
        final RenderEnv llllllllllllllIIIIIIlIllIlIIIlIl = llllllllllllllIIIIIIlIllIIlllIll.getRenderEnv(llllllllllllllIIIIIIlIllIlIIllIl, llllllllllllllIIIIIIlIllIlIIlIll, llllllllllllllIIIIIIlIllIIllllII);
        final short llllllllllllllIIIIIIlIllIIllIIll;
        final long llllllllllllllIIIIIIlIllIIllIlII = ((EnumFacing[])(Object)(llllllllllllllIIIIIIlIllIIllIIll = (short)(Object)EnumFacing.VALUES)).length;
        for (boolean llllllllllllllIIIIIIlIllIIllIlIl = false; (llllllllllllllIIIIIIlIllIIllIlIl ? 1 : 0) < llllllllllllllIIIIIIlIllIIllIlII; ++llllllllllllllIIIIIIlIllIIllIlIl) {
            final EnumFacing llllllllllllllIIIIIIlIllIlIIIlII = llllllllllllllIIIIIIlIllIIllIIll[llllllllllllllIIIIIIlIllIIllIlIl];
            List<BakedQuad> llllllllllllllIIIIIIlIllIlIIIIll = llllllllllllllIIIIIIlIllIIlllllI.getQuads(llllllllllllllIIIIIIlIllIlIIlIll, llllllllllllllIIIIIIlIllIlIIIlII, llllllllllllllIIIIIIlIllIIlllIIl);
            if (!llllllllllllllIIIIIIlIllIlIIIIll.isEmpty() && (!llllllllllllllIIIIIIlIllIIlllIlI || llllllllllllllIIIIIIlIllIlIIlIll.shouldSideBeRendered(llllllllllllllIIIIIIlIllIlIIllIl, llllllllllllllIIIIIIlIllIIllllII, llllllllllllllIIIIIIlIllIlIIIlII))) {
                final int llllllllllllllIIIIIIlIllIlIIIIlI = llllllllllllllIIIIIIlIllIlIIlIll.getPackedLightmapCoords(llllllllllllllIIIIIIlIllIlIIllIl, llllllllllllllIIIIIIlIllIIllllII.offset(llllllllllllllIIIIIIlIllIlIIIlII));
                llllllllllllllIIIIIIlIllIlIIIIll = BlockModelCustomizer.getRenderQuads(llllllllllllllIIIIIIlIllIlIIIIll, llllllllllllllIIIIIIlIllIlIIllIl, llllllllllllllIIIIIIlIllIlIIlIll, llllllllllllllIIIIIIlIllIIllllII, llllllllllllllIIIIIIlIllIlIIIlII, llllllllllllllIIIIIIlIllIIlllIIl, llllllllllllllIIIIIIlIllIlIIIlIl);
                this.renderQuadsFlat(llllllllllllllIIIIIIlIllIlIIllIl, llllllllllllllIIIIIIlIllIlIIlIll, llllllllllllllIIIIIIlIllIIllllII, llllllllllllllIIIIIIlIllIlIIIIlI, false, llllllllllllllIIIIIIlIllIIlllIll, llllllllllllllIIIIIIlIllIlIIIIll, llllllllllllllIIIIIIlIllIlIIIlIl);
                llllllllllllllIIIIIIlIllIlIIIllI = true;
            }
        }
        List<BakedQuad> llllllllllllllIIIIIIlIllIlIIIIIl = llllllllllllllIIIIIIlIllIIlllllI.getQuads(llllllllllllllIIIIIIlIllIlIIlIll, null, llllllllllllllIIIIIIlIllIIlllIIl);
        if (!llllllllllllllIIIIIIlIllIlIIIIIl.isEmpty()) {
            llllllllllllllIIIIIIlIllIlIIIIIl = BlockModelCustomizer.getRenderQuads(llllllllllllllIIIIIIlIllIlIIIIIl, llllllllllllllIIIIIIlIllIlIIllIl, llllllllllllllIIIIIIlIllIlIIlIll, llllllllllllllIIIIIIlIllIIllllII, null, llllllllllllllIIIIIIlIllIIlllIIl, llllllllllllllIIIIIIlIllIlIIIlIl);
            this.renderQuadsFlat(llllllllllllllIIIIIIlIllIlIIllIl, llllllllllllllIIIIIIlIllIlIIlIll, llllllllllllllIIIIIIlIllIIllllII, -1, true, llllllllllllllIIIIIIlIllIIlllIll, llllllllllllllIIIIIIlIllIlIIIIIl, llllllllllllllIIIIIIlIllIlIIIlIl);
            llllllllllllllIIIIIIlIllIlIIIllI = true;
        }
        return llllllllllllllIIIIIIlIllIlIIIllI;
    }
    
    private void renderOverlayModels(final IBlockAccess llllllllllllllIIIIIIIlIlIlIlllIl, final IBakedModel llllllllllllllIIIIIIIlIlIlllIIlI, final IBlockState llllllllllllllIIIIIIIlIlIlIlllII, final BlockPos llllllllllllllIIIIIIIlIlIlIllIll, final BufferBuilder llllllllllllllIIIIIIIlIlIllIllll, final boolean llllllllllllllIIIIIIIlIlIlIllIIl, final long llllllllllllllIIIIIIIlIlIlIllIII, final RenderEnv llllllllllllllIIIIIIIlIlIlIlIlll, final boolean llllllllllllllIIIIIIIlIlIllIlIll) {
        if (llllllllllllllIIIIIIIlIlIlIlIlll.isOverlaysRendered()) {
            for (int llllllllllllllIIIIIIIlIlIllIlIlI = 0; llllllllllllllIIIIIIIlIlIllIlIlI < BlockModelRenderer.OVERLAY_LAYERS.length; ++llllllllllllllIIIIIIIlIlIllIlIlI) {
                final BlockRenderLayer llllllllllllllIIIIIIIlIlIllIlIIl = BlockModelRenderer.OVERLAY_LAYERS[llllllllllllllIIIIIIIlIlIllIlIlI];
                final ListQuadsOverlay llllllllllllllIIIIIIIlIlIllIlIII = llllllllllllllIIIIIIIlIlIlIlIlll.getListQuadsOverlay(llllllllllllllIIIIIIIlIlIllIlIIl);
                if (llllllllllllllIIIIIIIlIlIllIlIII.size() > 0) {
                    final RegionRenderCacheBuilder llllllllllllllIIIIIIIlIlIllIIlll = llllllllllllllIIIIIIIlIlIlIlIlll.getRegionRenderCacheBuilder();
                    if (llllllllllllllIIIIIIIlIlIllIIlll != null) {
                        final BufferBuilder llllllllllllllIIIIIIIlIlIllIIllI = llllllllllllllIIIIIIIlIlIllIIlll.getWorldRendererByLayer(llllllllllllllIIIIIIIlIlIllIlIIl);
                        if (!llllllllllllllIIIIIIIlIlIllIIllI.isDrawing()) {
                            llllllllllllllIIIIIIIlIlIllIIllI.begin(7, DefaultVertexFormats.BLOCK);
                            llllllllllllllIIIIIIIlIlIllIIllI.setTranslation(llllllllllllllIIIIIIIlIlIllIllll.getXOffset(), llllllllllllllIIIIIIIlIlIllIllll.getYOffset(), llllllllllllllIIIIIIIlIlIllIllll.getZOffset());
                        }
                        for (int llllllllllllllIIIIIIIlIlIllIIlIl = 0; llllllllllllllIIIIIIIlIlIllIIlIl < llllllllllllllIIIIIIIlIlIllIlIII.size(); ++llllllllllllllIIIIIIIlIlIllIIlIl) {
                            final BakedQuad llllllllllllllIIIIIIIlIlIllIIlII = llllllllllllllIIIIIIIlIlIllIlIII.getQuad(llllllllllllllIIIIIIIlIlIllIIlIl);
                            final List<BakedQuad> llllllllllllllIIIIIIIlIlIllIIIll = llllllllllllllIIIIIIIlIlIllIlIII.getListQuadsSingle(llllllllllllllIIIIIIIlIlIllIIlII);
                            final IBlockState llllllllllllllIIIIIIIlIlIllIIIlI = llllllllllllllIIIIIIIlIlIllIlIII.getBlockState(llllllllllllllIIIIIIIlIlIllIIlIl);
                            llllllllllllllIIIIIIIlIlIlIlIlll.reset(llllllllllllllIIIIIIIlIlIlIlllIl, llllllllllllllIIIIIIIlIlIllIIIlI, llllllllllllllIIIIIIIlIlIlIllIll);
                            if (llllllllllllllIIIIIIIlIlIllIlIll) {
                                this.renderQuadsSmooth(llllllllllllllIIIIIIIlIlIlIlllIl, llllllllllllllIIIIIIIlIlIllIIIlI, llllllllllllllIIIIIIIlIlIlIllIll, llllllllllllllIIIIIIIlIlIllIIllI, llllllllllllllIIIIIIIlIlIllIIIll, llllllllllllllIIIIIIIlIlIlIlIlll);
                            }
                            else {
                                final int llllllllllllllIIIIIIIlIlIllIIIIl = llllllllllllllIIIIIIIlIlIllIIIlI.getPackedLightmapCoords(llllllllllllllIIIIIIIlIlIlIlllIl, llllllllllllllIIIIIIIlIlIlIllIll.offset(llllllllllllllIIIIIIIlIlIllIIlII.getFace()));
                                this.renderQuadsFlat(llllllllllllllIIIIIIIlIlIlIlllIl, llllllllllllllIIIIIIIlIlIllIIIlI, llllllllllllllIIIIIIIlIlIlIllIll, llllllllllllllIIIIIIIlIlIllIIIIl, false, llllllllllllllIIIIIIIlIlIllIIllI, llllllllllllllIIIIIIIlIlIllIIIll, llllllllllllllIIIIIIIlIlIlIlIlll);
                            }
                        }
                    }
                    llllllllllllllIIIIIIIlIlIllIlIII.clear();
                }
            }
        }
        if (Config.isBetterSnow() && !llllllllllllllIIIIIIIlIlIlIlIlll.isBreakingAnimation() && BetterSnow.shouldRender(llllllllllllllIIIIIIIlIlIlIlllIl, llllllllllllllIIIIIIIlIlIlIlllII, llllllllllllllIIIIIIIlIlIlIllIll)) {
            final IBakedModel llllllllllllllIIIIIIIlIlIllIIIII = BetterSnow.getModelSnowLayer();
            final IBlockState llllllllllllllIIIIIIIlIlIlIlllll = BetterSnow.getStateSnowLayer();
            this.renderModel(llllllllllllllIIIIIIIlIlIlIlllIl, llllllllllllllIIIIIIIlIlIllIIIII, llllllllllllllIIIIIIIlIlIlIlllll, llllllllllllllIIIIIIIlIlIlIllIll, llllllllllllllIIIIIIIlIlIllIllll, llllllllllllllIIIIIIIlIlIlIllIIl, llllllllllllllIIIIIIIlIlIlIllIII);
        }
    }
    
    public void renderModelBrightnessColor(final IBakedModel llllllllllllllIIIIIIIlIlllllIIll, final float llllllllllllllIIIIIIIlIllllIllII, final float llllllllllllllIIIIIIIlIlllllIIIl, final float llllllllllllllIIIIIIIlIllllIlIlI, final float llllllllllllllIIIIIIIlIllllIlIIl) {
        this.renderModelBrightnessColor(null, llllllllllllllIIIIIIIlIlllllIIll, llllllllllllllIIIIIIIlIllllIllII, llllllllllllllIIIIIIIlIlllllIIIl, llllllllllllllIIIIIIIlIllllIlIlI, llllllllllllllIIIIIIIlIllllIlIIl);
    }
    
    public static class AmbientOcclusionFace
    {
        private final /* synthetic */ int[] vertexBrightness;
        private final /* synthetic */ float[] vertexColorMultiplier;
        
        private int getAoBrightness(int llllllllllllllIIllIlIllllIlIllII, int llllllllllllllIIllIlIllllIlIlIll, int llllllllllllllIIllIlIllllIlIlIlI, final int llllllllllllllIIllIlIllllIlIlIIl) {
            if (llllllllllllllIIllIlIllllIlIllII == 0) {
                llllllllllllllIIllIlIllllIlIllII = llllllllllllllIIllIlIllllIlIlIIl;
            }
            if (llllllllllllllIIllIlIllllIlIlIll == 0) {
                llllllllllllllIIllIlIllllIlIlIll = llllllllllllllIIllIlIllllIlIlIIl;
            }
            if (llllllllllllllIIllIlIllllIlIlIlI == 0) {
                llllllllllllllIIllIlIllllIlIlIlI = llllllllllllllIIllIlIllllIlIlIIl;
            }
            return (int)(llllllllllllllIIllIlIllllIlIllII + llllllllllllllIIllIlIllllIlIlIll + llllllllllllllIIllIlIllllIlIlIlI + llllllllllllllIIllIlIllllIlIlIIl >> 2 & 0xFF00FF);
        }
        
        public AmbientOcclusionFace() {
            this.vertexColorMultiplier = new float[4];
            this.vertexBrightness = new int[4];
        }
        
        public void updateVertexBrightness(final IBlockAccess llllllllllllllIIllIllIIIIIlllllI, final IBlockState llllllllllllllIIllIllIIIIIllllIl, final BlockPos llllllllllllllIIllIlIllllllIllll, final EnumFacing llllllllllllllIIllIlIllllllIlllI, final float[] llllllllllllllIIllIllIIIIIlllIlI, final BitSet llllllllllllllIIllIlIllllllIllII) {
            final BlockPos llllllllllllllIIllIllIIIIIlllIII = llllllllllllllIIllIlIllllllIllII.get(0) ? llllllllllllllIIllIlIllllllIllll.offset(llllllllllllllIIllIlIllllllIlllI) : llllllllllllllIIllIlIllllllIllll;
            final BlockPos.PooledMutableBlockPos llllllllllllllIIllIllIIIIIllIlll = BlockPos.PooledMutableBlockPos.retain();
            final EnumNeighborInfo llllllllllllllIIllIllIIIIIllIllI = EnumNeighborInfo.getNeighbourInfo(llllllllllllllIIllIlIllllllIlllI);
            final BlockPos.PooledMutableBlockPos llllllllllllllIIllIllIIIIIllIlIl = BlockPos.PooledMutableBlockPos.retain(llllllllllllllIIllIllIIIIIlllIII).move(llllllllllllllIIllIllIIIIIllIllI.corners[0]);
            final BlockPos.PooledMutableBlockPos llllllllllllllIIllIllIIIIIllIlII = BlockPos.PooledMutableBlockPos.retain(llllllllllllllIIllIllIIIIIlllIII).move(llllllllllllllIIllIllIIIIIllIllI.corners[1]);
            final BlockPos.PooledMutableBlockPos llllllllllllllIIllIllIIIIIllIIll = BlockPos.PooledMutableBlockPos.retain(llllllllllllllIIllIllIIIIIlllIII).move(llllllllllllllIIllIllIIIIIllIllI.corners[2]);
            final BlockPos.PooledMutableBlockPos llllllllllllllIIllIllIIIIIllIIlI = BlockPos.PooledMutableBlockPos.retain(llllllllllllllIIllIllIIIIIlllIII).move(llllllllllllllIIllIllIIIIIllIllI.corners[3]);
            final int llllllllllllllIIllIllIIIIIllIIIl = llllllllllllllIIllIllIIIIIllllIl.getPackedLightmapCoords(llllllllllllllIIllIllIIIIIlllllI, llllllllllllllIIllIllIIIIIllIlIl);
            final int llllllllllllllIIllIllIIIIIllIIII = llllllllllllllIIllIllIIIIIllllIl.getPackedLightmapCoords(llllllllllllllIIllIllIIIIIlllllI, llllllllllllllIIllIllIIIIIllIlII);
            final int llllllllllllllIIllIllIIIIIlIllll = llllllllllllllIIllIllIIIIIllllIl.getPackedLightmapCoords(llllllllllllllIIllIllIIIIIlllllI, llllllllllllllIIllIllIIIIIllIIll);
            final int llllllllllllllIIllIllIIIIIlIlllI = llllllllllllllIIllIllIIIIIllllIl.getPackedLightmapCoords(llllllllllllllIIllIllIIIIIlllllI, llllllllllllllIIllIllIIIIIllIIlI);
            float llllllllllllllIIllIllIIIIIlIllIl = llllllllllllllIIllIllIIIIIlllllI.getBlockState(llllllllllllllIIllIllIIIIIllIlIl).getAmbientOcclusionLightValue();
            float llllllllllllllIIllIllIIIIIlIllII = llllllllllllllIIllIllIIIIIlllllI.getBlockState(llllllllllllllIIllIllIIIIIllIlII).getAmbientOcclusionLightValue();
            float llllllllllllllIIllIllIIIIIlIlIll = llllllllllllllIIllIllIIIIIlllllI.getBlockState(llllllllllllllIIllIllIIIIIllIIll).getAmbientOcclusionLightValue();
            float llllllllllllllIIllIllIIIIIlIlIlI = llllllllllllllIIllIllIIIIIlllllI.getBlockState(llllllllllllllIIllIllIIIIIllIIlI).getAmbientOcclusionLightValue();
            llllllllllllllIIllIllIIIIIlIllIl = BlockModelRenderer.fixAoLightValue(llllllllllllllIIllIllIIIIIlIllIl);
            llllllllllllllIIllIllIIIIIlIllII = BlockModelRenderer.fixAoLightValue(llllllllllllllIIllIllIIIIIlIllII);
            llllllllllllllIIllIllIIIIIlIlIll = BlockModelRenderer.fixAoLightValue(llllllllllllllIIllIllIIIIIlIlIll);
            llllllllllllllIIllIllIIIIIlIlIlI = BlockModelRenderer.fixAoLightValue(llllllllllllllIIllIllIIIIIlIlIlI);
            final boolean llllllllllllllIIllIllIIIIIlIlIIl = llllllllllllllIIllIllIIIIIlllllI.getBlockState(llllllllllllllIIllIllIIIIIllIlll.setPos(llllllllllllllIIllIllIIIIIllIlIl).move(llllllllllllllIIllIlIllllllIlllI)).isTranslucent();
            final boolean llllllllllllllIIllIllIIIIIlIlIII = llllllllllllllIIllIllIIIIIlllllI.getBlockState(llllllllllllllIIllIllIIIIIllIlll.setPos(llllllllllllllIIllIllIIIIIllIlII).move(llllllllllllllIIllIlIllllllIlllI)).isTranslucent();
            final boolean llllllllllllllIIllIllIIIIIlIIlll = llllllllllllllIIllIllIIIIIlllllI.getBlockState(llllllllllllllIIllIllIIIIIllIlll.setPos(llllllllllllllIIllIllIIIIIllIIll).move(llllllllllllllIIllIlIllllllIlllI)).isTranslucent();
            final boolean llllllllllllllIIllIllIIIIIlIIllI = llllllllllllllIIllIllIIIIIlllllI.getBlockState(llllllllllllllIIllIllIIIIIllIlll.setPos(llllllllllllllIIllIllIIIIIllIIlI).move(llllllllllllllIIllIlIllllllIlllI)).isTranslucent();
            float llllllllllllllIIllIllIIIIIlIIIlI = 0.0f;
            int llllllllllllllIIllIllIIIIIlIIlII = 0;
            if (!llllllllllllllIIllIllIIIIIlIIlll && !llllllllllllllIIllIllIIIIIlIlIIl) {
                final float llllllllllllllIIllIllIIIIIlIIIll = llllllllllllllIIllIllIIIIIlIllIl;
                final int llllllllllllllIIllIllIIIIIlIIlIl = llllllllllllllIIllIllIIIIIllIIIl;
            }
            else {
                final BlockPos llllllllllllllIIllIllIIIIIlIIIIl = llllllllllllllIIllIllIIIIIllIlll.setPos(llllllllllllllIIllIllIIIIIllIlIl).move(llllllllllllllIIllIllIIIIIllIllI.corners[2]);
                llllllllllllllIIllIllIIIIIlIIIlI = llllllllllllllIIllIllIIIIIlllllI.getBlockState(llllllllllllllIIllIllIIIIIlIIIIl).getAmbientOcclusionLightValue();
                llllllllllllllIIllIllIIIIIlIIIlI = BlockModelRenderer.fixAoLightValue(llllllllllllllIIllIllIIIIIlIIIlI);
                llllllllllllllIIllIllIIIIIlIIlII = llllllllllllllIIllIllIIIIIllllIl.getPackedLightmapCoords(llllllllllllllIIllIllIIIIIlllllI, llllllllllllllIIllIllIIIIIlIIIIl);
            }
            float llllllllllllllIIllIllIIIIIIlllIl = 0.0f;
            int llllllllllllllIIllIllIIIIIIlllll = 0;
            if (!llllllllllllllIIllIllIIIIIlIIllI && !llllllllllllllIIllIllIIIIIlIlIIl) {
                final float llllllllllllllIIllIllIIIIIIllllI = llllllllllllllIIllIllIIIIIlIllIl;
                final int llllllllllllllIIllIllIIIIIlIIIII = llllllllllllllIIllIllIIIIIllIIIl;
            }
            else {
                final BlockPos llllllllllllllIIllIllIIIIIIlllII = llllllllllllllIIllIllIIIIIllIlll.setPos(llllllllllllllIIllIllIIIIIllIlIl).move(llllllllllllllIIllIllIIIIIllIllI.corners[3]);
                llllllllllllllIIllIllIIIIIIlllIl = llllllllllllllIIllIllIIIIIlllllI.getBlockState(llllllllllllllIIllIllIIIIIIlllII).getAmbientOcclusionLightValue();
                llllllllllllllIIllIllIIIIIIlllIl = BlockModelRenderer.fixAoLightValue(llllllllllllllIIllIllIIIIIIlllIl);
                llllllllllllllIIllIllIIIIIIlllll = llllllllllllllIIllIllIIIIIllllIl.getPackedLightmapCoords(llllllllllllllIIllIllIIIIIlllllI, llllllllllllllIIllIllIIIIIIlllII);
            }
            float llllllllllllllIIllIllIIIIIIllIII = 0.0f;
            int llllllllllllllIIllIllIIIIIIllIlI = 0;
            if (!llllllllllllllIIllIllIIIIIlIIlll && !llllllllllllllIIllIllIIIIIlIlIII) {
                final float llllllllllllllIIllIllIIIIIIllIIl = llllllllllllllIIllIllIIIIIlIllII;
                final int llllllllllllllIIllIllIIIIIIllIll = llllllllllllllIIllIllIIIIIllIIII;
            }
            else {
                final BlockPos llllllllllllllIIllIllIIIIIIlIlll = llllllllllllllIIllIllIIIIIllIlll.setPos(llllllllllllllIIllIllIIIIIllIlII).move(llllllllllllllIIllIllIIIIIllIllI.corners[2]);
                llllllllllllllIIllIllIIIIIIllIII = llllllllllllllIIllIllIIIIIlllllI.getBlockState(llllllllllllllIIllIllIIIIIIlIlll).getAmbientOcclusionLightValue();
                llllllllllllllIIllIllIIIIIIllIII = BlockModelRenderer.fixAoLightValue(llllllllllllllIIllIllIIIIIIllIII);
                llllllllllllllIIllIllIIIIIIllIlI = llllllllllllllIIllIllIIIIIllllIl.getPackedLightmapCoords(llllllllllllllIIllIllIIIIIlllllI, llllllllllllllIIllIllIIIIIIlIlll);
            }
            float llllllllllllllIIllIllIIIIIIlIIll = 0.0f;
            int llllllllllllllIIllIllIIIIIIlIlIl = 0;
            if (!llllllllllllllIIllIllIIIIIlIIllI && !llllllllllllllIIllIllIIIIIlIlIII) {
                final float llllllllllllllIIllIllIIIIIIlIlII = llllllllllllllIIllIllIIIIIlIllII;
                final int llllllllllllllIIllIllIIIIIIlIllI = llllllllllllllIIllIllIIIIIllIIII;
            }
            else {
                final BlockPos llllllllllllllIIllIllIIIIIIlIIlI = llllllllllllllIIllIllIIIIIllIlll.setPos(llllllllllllllIIllIllIIIIIllIlII).move(llllllllllllllIIllIllIIIIIllIllI.corners[3]);
                llllllllllllllIIllIllIIIIIIlIIll = llllllllllllllIIllIllIIIIIlllllI.getBlockState(llllllllllllllIIllIllIIIIIIlIIlI).getAmbientOcclusionLightValue();
                llllllllllllllIIllIllIIIIIIlIIll = BlockModelRenderer.fixAoLightValue(llllllllllllllIIllIllIIIIIIlIIll);
                llllllllllllllIIllIllIIIIIIlIlIl = llllllllllllllIIllIllIIIIIllllIl.getPackedLightmapCoords(llllllllllllllIIllIllIIIIIlllllI, llllllllllllllIIllIllIIIIIIlIIlI);
            }
            int llllllllllllllIIllIllIIIIIIlIIIl = llllllllllllllIIllIllIIIIIllllIl.getPackedLightmapCoords(llllllllllllllIIllIllIIIIIlllllI, llllllllllllllIIllIlIllllllIllll);
            if (llllllllllllllIIllIlIllllllIllII.get(0) || !llllllllllllllIIllIllIIIIIlllllI.getBlockState(llllllllllllllIIllIlIllllllIllll.offset(llllllllllllllIIllIlIllllllIlllI)).isOpaqueCube()) {
                llllllllllllllIIllIllIIIIIIlIIIl = llllllllllllllIIllIllIIIIIllllIl.getPackedLightmapCoords(llllllllllllllIIllIllIIIIIlllllI, llllllllllllllIIllIlIllllllIllll.offset(llllllllllllllIIllIlIllllllIlllI));
            }
            float llllllllllllllIIllIllIIIIIIlIIII = llllllllllllllIIllIlIllllllIllII.get(0) ? llllllllllllllIIllIllIIIIIlllllI.getBlockState(llllllllllllllIIllIllIIIIIlllIII).getAmbientOcclusionLightValue() : llllllllllllllIIllIllIIIIIlllllI.getBlockState(llllllllllllllIIllIlIllllllIllll).getAmbientOcclusionLightValue();
            llllllllllllllIIllIllIIIIIIlIIII = BlockModelRenderer.fixAoLightValue(llllllllllllllIIllIllIIIIIIlIIII);
            final VertexTranslations llllllllllllllIIllIllIIIIIIIllll = VertexTranslations.getVertexTranslations(llllllllllllllIIllIlIllllllIlllI);
            llllllllllllllIIllIllIIIIIllIlll.release();
            llllllllllllllIIllIllIIIIIllIlIl.release();
            llllllllllllllIIllIllIIIIIllIlII.release();
            llllllllllllllIIllIllIIIIIllIIll.release();
            llllllllllllllIIllIllIIIIIllIIlI.release();
            if (llllllllllllllIIllIlIllllllIllII.get(1) && llllllllllllllIIllIllIIIIIllIllI.doNonCubicWeight) {
                final float llllllllllllllIIllIllIIIIIIIlllI = (llllllllllllllIIllIllIIIIIlIlIlI + llllllllllllllIIllIllIIIIIlIllIl + llllllllllllllIIllIllIIIIIIlllIl + llllllllllllllIIllIllIIIIIIlIIII) * 0.25f;
                final float llllllllllllllIIllIllIIIIIIIllIl = (llllllllllllllIIllIllIIIIIlIlIll + llllllllllllllIIllIllIIIIIlIllIl + llllllllllllllIIllIllIIIIIlIIIlI + llllllllllllllIIllIllIIIIIIlIIII) * 0.25f;
                final float llllllllllllllIIllIllIIIIIIIllII = (llllllllllllllIIllIllIIIIIlIlIll + llllllllllllllIIllIllIIIIIlIllII + llllllllllllllIIllIllIIIIIIllIII + llllllllllllllIIllIllIIIIIIlIIII) * 0.25f;
                final float llllllllllllllIIllIllIIIIIIIlIll = (llllllllllllllIIllIllIIIIIlIlIlI + llllllllllllllIIllIllIIIIIlIllII + llllllllllllllIIllIllIIIIIIlIIll + llllllllllllllIIllIllIIIIIIlIIII) * 0.25f;
                final float llllllllllllllIIllIllIIIIIIIlIlI = llllllllllllllIIllIllIIIIIlllIlI[llllllllllllllIIllIllIIIIIllIllI.vert0Weights[0].shape] * llllllllllllllIIllIllIIIIIlllIlI[llllllllllllllIIllIllIIIIIllIllI.vert0Weights[1].shape];
                final float llllllllllllllIIllIllIIIIIIIlIIl = llllllllllllllIIllIllIIIIIlllIlI[llllllllllllllIIllIllIIIIIllIllI.vert0Weights[2].shape] * llllllllllllllIIllIllIIIIIlllIlI[llllllllllllllIIllIllIIIIIllIllI.vert0Weights[3].shape];
                final float llllllllllllllIIllIllIIIIIIIlIII = llllllllllllllIIllIllIIIIIlllIlI[llllllllllllllIIllIllIIIIIllIllI.vert0Weights[4].shape] * llllllllllllllIIllIllIIIIIlllIlI[llllllllllllllIIllIllIIIIIllIllI.vert0Weights[5].shape];
                final float llllllllllllllIIllIllIIIIIIIIlll = llllllllllllllIIllIllIIIIIlllIlI[llllllllllllllIIllIllIIIIIllIllI.vert0Weights[6].shape] * llllllllllllllIIllIllIIIIIlllIlI[llllllllllllllIIllIllIIIIIllIllI.vert0Weights[7].shape];
                final float llllllllllllllIIllIllIIIIIIIIllI = llllllllllllllIIllIllIIIIIlllIlI[llllllllllllllIIllIllIIIIIllIllI.vert1Weights[0].shape] * llllllllllllllIIllIllIIIIIlllIlI[llllllllllllllIIllIllIIIIIllIllI.vert1Weights[1].shape];
                final float llllllllllllllIIllIllIIIIIIIIlIl = llllllllllllllIIllIllIIIIIlllIlI[llllllllllllllIIllIllIIIIIllIllI.vert1Weights[2].shape] * llllllllllllllIIllIllIIIIIlllIlI[llllllllllllllIIllIllIIIIIllIllI.vert1Weights[3].shape];
                final float llllllllllllllIIllIllIIIIIIIIlII = llllllllllllllIIllIllIIIIIlllIlI[llllllllllllllIIllIllIIIIIllIllI.vert1Weights[4].shape] * llllllllllllllIIllIllIIIIIlllIlI[llllllllllllllIIllIllIIIIIllIllI.vert1Weights[5].shape];
                final float llllllllllllllIIllIllIIIIIIIIIll = llllllllllllllIIllIllIIIIIlllIlI[llllllllllllllIIllIllIIIIIllIllI.vert1Weights[6].shape] * llllllllllllllIIllIllIIIIIlllIlI[llllllllllllllIIllIllIIIIIllIllI.vert1Weights[7].shape];
                final float llllllllllllllIIllIllIIIIIIIIIlI = llllllllllllllIIllIllIIIIIlllIlI[llllllllllllllIIllIllIIIIIllIllI.vert2Weights[0].shape] * llllllllllllllIIllIllIIIIIlllIlI[llllllllllllllIIllIllIIIIIllIllI.vert2Weights[1].shape];
                final float llllllllllllllIIllIllIIIIIIIIIIl = llllllllllllllIIllIllIIIIIlllIlI[llllllllllllllIIllIllIIIIIllIllI.vert2Weights[2].shape] * llllllllllllllIIllIllIIIIIlllIlI[llllllllllllllIIllIllIIIIIllIllI.vert2Weights[3].shape];
                final float llllllllllllllIIllIllIIIIIIIIIII = llllllllllllllIIllIllIIIIIlllIlI[llllllllllllllIIllIllIIIIIllIllI.vert2Weights[4].shape] * llllllllllllllIIllIllIIIIIlllIlI[llllllllllllllIIllIllIIIIIllIllI.vert2Weights[5].shape];
                final float llllllllllllllIIllIlIlllllllllll = llllllllllllllIIllIllIIIIIlllIlI[llllllllllllllIIllIllIIIIIllIllI.vert2Weights[6].shape] * llllllllllllllIIllIllIIIIIlllIlI[llllllllllllllIIllIllIIIIIllIllI.vert2Weights[7].shape];
                final float llllllllllllllIIllIlIllllllllllI = llllllllllllllIIllIllIIIIIlllIlI[llllllllllllllIIllIllIIIIIllIllI.vert3Weights[0].shape] * llllllllllllllIIllIllIIIIIlllIlI[llllllllllllllIIllIllIIIIIllIllI.vert3Weights[1].shape];
                final float llllllllllllllIIllIlIlllllllllIl = llllllllllllllIIllIllIIIIIlllIlI[llllllllllllllIIllIllIIIIIllIllI.vert3Weights[2].shape] * llllllllllllllIIllIllIIIIIlllIlI[llllllllllllllIIllIllIIIIIllIllI.vert3Weights[3].shape];
                final float llllllllllllllIIllIlIlllllllllII = llllllllllllllIIllIllIIIIIlllIlI[llllllllllllllIIllIllIIIIIllIllI.vert3Weights[4].shape] * llllllllllllllIIllIllIIIIIlllIlI[llllllllllllllIIllIllIIIIIllIllI.vert3Weights[5].shape];
                final float llllllllllllllIIllIlIllllllllIll = llllllllllllllIIllIllIIIIIlllIlI[llllllllllllllIIllIllIIIIIllIllI.vert3Weights[6].shape] * llllllllllllllIIllIllIIIIIlllIlI[llllllllllllllIIllIllIIIIIllIllI.vert3Weights[7].shape];
                this.vertexColorMultiplier[llllllllllllllIIllIllIIIIIIIllll.vert0] = llllllllllllllIIllIllIIIIIIIlllI * llllllllllllllIIllIllIIIIIIIlIlI + llllllllllllllIIllIllIIIIIIIllIl * llllllllllllllIIllIllIIIIIIIlIIl + llllllllllllllIIllIllIIIIIIIllII * llllllllllllllIIllIllIIIIIIIlIII + llllllllllllllIIllIllIIIIIIIlIll * llllllllllllllIIllIllIIIIIIIIlll;
                this.vertexColorMultiplier[llllllllllllllIIllIllIIIIIIIllll.vert1] = llllllllllllllIIllIllIIIIIIIlllI * llllllllllllllIIllIllIIIIIIIIllI + llllllllllllllIIllIllIIIIIIIllIl * llllllllllllllIIllIllIIIIIIIIlIl + llllllllllllllIIllIllIIIIIIIllII * llllllllllllllIIllIllIIIIIIIIlII + llllllllllllllIIllIllIIIIIIIlIll * llllllllllllllIIllIllIIIIIIIIIll;
                this.vertexColorMultiplier[llllllllllllllIIllIllIIIIIIIllll.vert2] = llllllllllllllIIllIllIIIIIIIlllI * llllllllllllllIIllIllIIIIIIIIIlI + llllllllllllllIIllIllIIIIIIIllIl * llllllllllllllIIllIllIIIIIIIIIIl + llllllllllllllIIllIllIIIIIIIllII * llllllllllllllIIllIllIIIIIIIIIII + llllllllllllllIIllIllIIIIIIIlIll * llllllllllllllIIllIlIlllllllllll;
                this.vertexColorMultiplier[llllllllllllllIIllIllIIIIIIIllll.vert3] = llllllllllllllIIllIllIIIIIIIlllI * llllllllllllllIIllIlIllllllllllI + llllllllllllllIIllIllIIIIIIIllIl * llllllllllllllIIllIlIlllllllllIl + llllllllllllllIIllIllIIIIIIIllII * llllllllllllllIIllIlIlllllllllII + llllllllllllllIIllIllIIIIIIIlIll * llllllllllllllIIllIlIllllllllIll;
                final int llllllllllllllIIllIlIllllllllIlI = this.getAoBrightness(llllllllllllllIIllIllIIIIIlIlllI, llllllllllllllIIllIllIIIIIllIIIl, llllllllllllllIIllIllIIIIIIlllll, llllllllllllllIIllIllIIIIIIlIIIl);
                final int llllllllllllllIIllIlIllllllllIIl = this.getAoBrightness(llllllllllllllIIllIllIIIIIlIllll, llllllllllllllIIllIllIIIIIllIIIl, llllllllllllllIIllIllIIIIIlIIlII, llllllllllllllIIllIllIIIIIIlIIIl);
                final int llllllllllllllIIllIlIllllllllIII = this.getAoBrightness(llllllllllllllIIllIllIIIIIlIllll, llllllllllllllIIllIllIIIIIllIIII, llllllllllllllIIllIllIIIIIIllIlI, llllllllllllllIIllIllIIIIIIlIIIl);
                final int llllllllllllllIIllIlIlllllllIlll = this.getAoBrightness(llllllllllllllIIllIllIIIIIlIlllI, llllllllllllllIIllIllIIIIIllIIII, llllllllllllllIIllIllIIIIIIlIlIl, llllllllllllllIIllIllIIIIIIlIIIl);
                this.vertexBrightness[llllllllllllllIIllIllIIIIIIIllll.vert0] = this.getVertexBrightness(llllllllllllllIIllIlIllllllllIlI, llllllllllllllIIllIlIllllllllIIl, llllllllllllllIIllIlIllllllllIII, llllllllllllllIIllIlIlllllllIlll, llllllllllllllIIllIllIIIIIIIlIlI, llllllllllllllIIllIllIIIIIIIlIIl, llllllllllllllIIllIllIIIIIIIlIII, llllllllllllllIIllIllIIIIIIIIlll);
                this.vertexBrightness[llllllllllllllIIllIllIIIIIIIllll.vert1] = this.getVertexBrightness(llllllllllllllIIllIlIllllllllIlI, llllllllllllllIIllIlIllllllllIIl, llllllllllllllIIllIlIllllllllIII, llllllllllllllIIllIlIlllllllIlll, llllllllllllllIIllIllIIIIIIIIllI, llllllllllllllIIllIllIIIIIIIIlIl, llllllllllllllIIllIllIIIIIIIIlII, llllllllllllllIIllIllIIIIIIIIIll);
                this.vertexBrightness[llllllllllllllIIllIllIIIIIIIllll.vert2] = this.getVertexBrightness(llllllllllllllIIllIlIllllllllIlI, llllllllllllllIIllIlIllllllllIIl, llllllllllllllIIllIlIllllllllIII, llllllllllllllIIllIlIlllllllIlll, llllllllllllllIIllIllIIIIIIIIIlI, llllllllllllllIIllIllIIIIIIIIIIl, llllllllllllllIIllIllIIIIIIIIIII, llllllllllllllIIllIlIlllllllllll);
                this.vertexBrightness[llllllllllllllIIllIllIIIIIIIllll.vert3] = this.getVertexBrightness(llllllllllllllIIllIlIllllllllIlI, llllllllllllllIIllIlIllllllllIIl, llllllllllllllIIllIlIllllllllIII, llllllllllllllIIllIlIlllllllIlll, llllllllllllllIIllIlIllllllllllI, llllllllllllllIIllIlIlllllllllIl, llllllllllllllIIllIlIlllllllllII, llllllllllllllIIllIlIllllllllIll);
            }
            else {
                final float llllllllllllllIIllIlIlllllllIllI = (llllllllllllllIIllIllIIIIIlIlIlI + llllllllllllllIIllIllIIIIIlIllIl + llllllllllllllIIllIllIIIIIIlllIl + llllllllllllllIIllIllIIIIIIlIIII) * 0.25f;
                final float llllllllllllllIIllIlIlllllllIlIl = (llllllllllllllIIllIllIIIIIlIlIll + llllllllllllllIIllIllIIIIIlIllIl + llllllllllllllIIllIllIIIIIlIIIlI + llllllllllllllIIllIllIIIIIIlIIII) * 0.25f;
                final float llllllllllllllIIllIlIlllllllIlII = (llllllllllllllIIllIllIIIIIlIlIll + llllllllllllllIIllIllIIIIIlIllII + llllllllllllllIIllIllIIIIIIllIII + llllllllllllllIIllIllIIIIIIlIIII) * 0.25f;
                final float llllllllllllllIIllIlIlllllllIIll = (llllllllllllllIIllIllIIIIIlIlIlI + llllllllllllllIIllIllIIIIIlIllII + llllllllllllllIIllIllIIIIIIlIIll + llllllllllllllIIllIllIIIIIIlIIII) * 0.25f;
                this.vertexBrightness[llllllllllllllIIllIllIIIIIIIllll.vert0] = this.getAoBrightness(llllllllllllllIIllIllIIIIIlIlllI, llllllllllllllIIllIllIIIIIllIIIl, llllllllllllllIIllIllIIIIIIlllll, llllllllllllllIIllIllIIIIIIlIIIl);
                this.vertexBrightness[llllllllllllllIIllIllIIIIIIIllll.vert1] = this.getAoBrightness(llllllllllllllIIllIllIIIIIlIllll, llllllllllllllIIllIllIIIIIllIIIl, llllllllllllllIIllIllIIIIIlIIlII, llllllllllllllIIllIllIIIIIIlIIIl);
                this.vertexBrightness[llllllllllllllIIllIllIIIIIIIllll.vert2] = this.getAoBrightness(llllllllllllllIIllIllIIIIIlIllll, llllllllllllllIIllIllIIIIIllIIII, llllllllllllllIIllIllIIIIIIllIlI, llllllllllllllIIllIllIIIIIIlIIIl);
                this.vertexBrightness[llllllllllllllIIllIllIIIIIIIllll.vert3] = this.getAoBrightness(llllllllllllllIIllIllIIIIIlIlllI, llllllllllllllIIllIllIIIIIllIIII, llllllllllllllIIllIllIIIIIIlIlIl, llllllllllllllIIllIllIIIIIIlIIIl);
                this.vertexColorMultiplier[llllllllllllllIIllIllIIIIIIIllll.vert0] = llllllllllllllIIllIlIlllllllIllI;
                this.vertexColorMultiplier[llllllllllllllIIllIllIIIIIIIllll.vert1] = llllllllllllllIIllIlIlllllllIlIl;
                this.vertexColorMultiplier[llllllllllllllIIllIllIIIIIIIllll.vert2] = llllllllllllllIIllIlIlllllllIlII;
                this.vertexColorMultiplier[llllllllllllllIIllIllIIIIIIIllll.vert3] = llllllllllllllIIllIlIlllllllIIll;
            }
        }
        
        private int getVertexBrightness(final int llllllllllllllIIllIlIllllIIlllIl, final int llllllllllllllIIllIlIllllIIlIIlI, final int llllllllllllllIIllIlIllllIIllIll, final int llllllllllllllIIllIlIllllIIlIIII, final float llllllllllllllIIllIlIllllIIllIIl, final float llllllllllllllIIllIlIllllIIllIII, final float llllllllllllllIIllIlIllllIIlIlll, final float llllllllllllllIIllIlIllllIIIllII) {
            final int llllllllllllllIIllIlIllllIIlIlIl = (int)((llllllllllllllIIllIlIllllIIlllIl >> 16 & 0xFF) * llllllllllllllIIllIlIllllIIllIIl + (llllllllllllllIIllIlIllllIIlIIlI >> 16 & 0xFF) * llllllllllllllIIllIlIllllIIllIII + (llllllllllllllIIllIlIllllIIllIll >> 16 & 0xFF) * llllllllllllllIIllIlIllllIIlIlll + (llllllllllllllIIllIlIllllIIlIIII >> 16 & 0xFF) * llllllllllllllIIllIlIllllIIIllII) & 0xFF;
            final int llllllllllllllIIllIlIllllIIlIlII = (int)((llllllllllllllIIllIlIllllIIlllIl & 0xFF) * llllllllllllllIIllIlIllllIIllIIl + (llllllllllllllIIllIlIllllIIlIIlI & 0xFF) * llllllllllllllIIllIlIllllIIllIII + (llllllllllllllIIllIlIllllIIllIll & 0xFF) * llllllllllllllIIllIlIllllIIlIlll + (llllllllllllllIIllIlIllllIIlIIII & 0xFF) * llllllllllllllIIllIlIllllIIIllII) & 0xFF;
            return llllllllllllllIIllIlIllllIIlIlIl << 16 | llllllllllllllIIllIlIllllIIlIlII;
        }
        
        public AmbientOcclusionFace(final BlockModelRenderer llllllllllllllIIllIllIIIIllllllI) {
            this.vertexColorMultiplier = new float[4];
            this.vertexBrightness = new int[4];
        }
    }
    
    public enum Orientation
    {
        FLIP_WEST("FLIP_WEST", 10, EnumFacing.WEST, true), 
        SOUTH("SOUTH", 3, EnumFacing.SOUTH, false), 
        FLIP_SOUTH("FLIP_SOUTH", 9, EnumFacing.SOUTH, true), 
        DOWN("DOWN", 0, EnumFacing.DOWN, false), 
        FLIP_EAST("FLIP_EAST", 11, EnumFacing.EAST, true), 
        NORTH("NORTH", 2, EnumFacing.NORTH, false), 
        FLIP_UP("FLIP_UP", 7, EnumFacing.UP, true), 
        FLIP_NORTH("FLIP_NORTH", 8, EnumFacing.NORTH, true);
        
        private final /* synthetic */ int shape;
        
        FLIP_DOWN("FLIP_DOWN", 6, EnumFacing.DOWN, true), 
        EAST("EAST", 5, EnumFacing.EAST, false), 
        WEST("WEST", 4, EnumFacing.WEST, false), 
        UP("UP", 1, EnumFacing.UP, false);
        
        private Orientation(final String lIlllllIIlIIIII, final int lIlllllIIIlllll, final EnumFacing lIlllllIIlIIIll, final boolean lIlllllIIIlllIl) {
            this.shape = lIlllllIIlIIIll.getIndex() + (lIlllllIIIlllIl ? EnumFacing.values().length : 0);
        }
    }
    
    enum VertexTranslations
    {
        EAST("EAST", 5, 1, 2, 3, 0);
        
        private static final /* synthetic */ VertexTranslations[] VALUES;
        
        DOWN("DOWN", 0, 0, 1, 2, 3);
        
        private final /* synthetic */ int vert2;
        
        UP("UP", 1, 2, 3, 0, 1);
        
        private final /* synthetic */ int vert0;
        private final /* synthetic */ int vert1;
        
        WEST("WEST", 4, 3, 0, 1, 2);
        
        private final /* synthetic */ int vert3;
        
        SOUTH("SOUTH", 3, 0, 1, 2, 3), 
        NORTH("NORTH", 2, 3, 0, 1, 2);
        
        public static VertexTranslations getVertexTranslations(final EnumFacing llllllllllllllIIIIlIIlIlIIIlIIll) {
            return VertexTranslations.VALUES[llllllllllllllIIIIlIIlIlIIIlIIll.getIndex()];
        }
        
        private VertexTranslations(final String llllllllllllllIIIIlIIlIlIIIllIll, final int llllllllllllllIIIIlIIlIlIIIllIlI, final int llllllllllllllIIIIlIIlIlIIlIIIII, final int llllllllllllllIIIIlIIlIlIIIllIII, final int llllllllllllllIIIIlIIlIlIIIlIlll, final int llllllllllllllIIIIlIIlIlIIIlIllI) {
            this.vert0 = llllllllllllllIIIIlIIlIlIIlIIIII;
            this.vert1 = llllllllllllllIIIIlIIlIlIIIllIII;
            this.vert2 = llllllllllllllIIIIlIIlIlIIIlIlll;
            this.vert3 = llllllllllllllIIIIlIIlIlIIIlIllI;
        }
        
        static {
            (VALUES = new VertexTranslations[6])[EnumFacing.DOWN.getIndex()] = VertexTranslations.DOWN;
            VertexTranslations.VALUES[EnumFacing.UP.getIndex()] = VertexTranslations.UP;
            VertexTranslations.VALUES[EnumFacing.NORTH.getIndex()] = VertexTranslations.NORTH;
            VertexTranslations.VALUES[EnumFacing.SOUTH.getIndex()] = VertexTranslations.SOUTH;
            VertexTranslations.VALUES[EnumFacing.WEST.getIndex()] = VertexTranslations.WEST;
            VertexTranslations.VALUES[EnumFacing.EAST.getIndex()] = VertexTranslations.EAST;
        }
    }
    
    public enum EnumNeighborInfo
    {
        NORTH("NORTH", 2, new EnumFacing[] { EnumFacing.UP, EnumFacing.DOWN, EnumFacing.EAST, EnumFacing.WEST }, 0.8f, true, new Orientation[] { Orientation.UP, Orientation.FLIP_WEST, Orientation.UP, Orientation.WEST, Orientation.FLIP_UP, Orientation.WEST, Orientation.FLIP_UP, Orientation.FLIP_WEST }, new Orientation[] { Orientation.UP, Orientation.FLIP_EAST, Orientation.UP, Orientation.EAST, Orientation.FLIP_UP, Orientation.EAST, Orientation.FLIP_UP, Orientation.FLIP_EAST }, new Orientation[] { Orientation.DOWN, Orientation.FLIP_EAST, Orientation.DOWN, Orientation.EAST, Orientation.FLIP_DOWN, Orientation.EAST, Orientation.FLIP_DOWN, Orientation.FLIP_EAST }, new Orientation[] { Orientation.DOWN, Orientation.FLIP_WEST, Orientation.DOWN, Orientation.WEST, Orientation.FLIP_DOWN, Orientation.WEST, Orientation.FLIP_DOWN, Orientation.FLIP_WEST }), 
        DOWN("DOWN", 0, new EnumFacing[] { EnumFacing.WEST, EnumFacing.EAST, EnumFacing.NORTH, EnumFacing.SOUTH }, 0.5f, true, new Orientation[] { Orientation.FLIP_WEST, Orientation.SOUTH, Orientation.FLIP_WEST, Orientation.FLIP_SOUTH, Orientation.WEST, Orientation.FLIP_SOUTH, Orientation.WEST, Orientation.SOUTH }, new Orientation[] { Orientation.FLIP_WEST, Orientation.NORTH, Orientation.FLIP_WEST, Orientation.FLIP_NORTH, Orientation.WEST, Orientation.FLIP_NORTH, Orientation.WEST, Orientation.NORTH }, new Orientation[] { Orientation.FLIP_EAST, Orientation.NORTH, Orientation.FLIP_EAST, Orientation.FLIP_NORTH, Orientation.EAST, Orientation.FLIP_NORTH, Orientation.EAST, Orientation.NORTH }, new Orientation[] { Orientation.FLIP_EAST, Orientation.SOUTH, Orientation.FLIP_EAST, Orientation.FLIP_SOUTH, Orientation.EAST, Orientation.FLIP_SOUTH, Orientation.EAST, Orientation.SOUTH });
        
        private static final /* synthetic */ EnumNeighborInfo[] VALUES;
        private final /* synthetic */ Orientation[] vert0Weights;
        private final /* synthetic */ boolean doNonCubicWeight;
        private final /* synthetic */ float shadeWeight;
        
        UP("UP", 1, new EnumFacing[] { EnumFacing.EAST, EnumFacing.WEST, EnumFacing.NORTH, EnumFacing.SOUTH }, 1.0f, true, new Orientation[] { Orientation.EAST, Orientation.SOUTH, Orientation.EAST, Orientation.FLIP_SOUTH, Orientation.FLIP_EAST, Orientation.FLIP_SOUTH, Orientation.FLIP_EAST, Orientation.SOUTH }, new Orientation[] { Orientation.EAST, Orientation.NORTH, Orientation.EAST, Orientation.FLIP_NORTH, Orientation.FLIP_EAST, Orientation.FLIP_NORTH, Orientation.FLIP_EAST, Orientation.NORTH }, new Orientation[] { Orientation.WEST, Orientation.NORTH, Orientation.WEST, Orientation.FLIP_NORTH, Orientation.FLIP_WEST, Orientation.FLIP_NORTH, Orientation.FLIP_WEST, Orientation.NORTH }, new Orientation[] { Orientation.WEST, Orientation.SOUTH, Orientation.WEST, Orientation.FLIP_SOUTH, Orientation.FLIP_WEST, Orientation.FLIP_SOUTH, Orientation.FLIP_WEST, Orientation.SOUTH }), 
        EAST("EAST", 5, new EnumFacing[] { EnumFacing.DOWN, EnumFacing.UP, EnumFacing.NORTH, EnumFacing.SOUTH }, 0.6f, true, new Orientation[] { Orientation.FLIP_DOWN, Orientation.SOUTH, Orientation.FLIP_DOWN, Orientation.FLIP_SOUTH, Orientation.DOWN, Orientation.FLIP_SOUTH, Orientation.DOWN, Orientation.SOUTH }, new Orientation[] { Orientation.FLIP_DOWN, Orientation.NORTH, Orientation.FLIP_DOWN, Orientation.FLIP_NORTH, Orientation.DOWN, Orientation.FLIP_NORTH, Orientation.DOWN, Orientation.NORTH }, new Orientation[] { Orientation.FLIP_UP, Orientation.NORTH, Orientation.FLIP_UP, Orientation.FLIP_NORTH, Orientation.UP, Orientation.FLIP_NORTH, Orientation.UP, Orientation.NORTH }, new Orientation[] { Orientation.FLIP_UP, Orientation.SOUTH, Orientation.FLIP_UP, Orientation.FLIP_SOUTH, Orientation.UP, Orientation.FLIP_SOUTH, Orientation.UP, Orientation.SOUTH });
        
        private final /* synthetic */ EnumFacing[] corners;
        private final /* synthetic */ Orientation[] vert1Weights;
        private final /* synthetic */ Orientation[] vert2Weights;
        
        SOUTH("SOUTH", 3, new EnumFacing[] { EnumFacing.WEST, EnumFacing.EAST, EnumFacing.DOWN, EnumFacing.UP }, 0.8f, true, new Orientation[] { Orientation.UP, Orientation.FLIP_WEST, Orientation.FLIP_UP, Orientation.FLIP_WEST, Orientation.FLIP_UP, Orientation.WEST, Orientation.UP, Orientation.WEST }, new Orientation[] { Orientation.DOWN, Orientation.FLIP_WEST, Orientation.FLIP_DOWN, Orientation.FLIP_WEST, Orientation.FLIP_DOWN, Orientation.WEST, Orientation.DOWN, Orientation.WEST }, new Orientation[] { Orientation.DOWN, Orientation.FLIP_EAST, Orientation.FLIP_DOWN, Orientation.FLIP_EAST, Orientation.FLIP_DOWN, Orientation.EAST, Orientation.DOWN, Orientation.EAST }, new Orientation[] { Orientation.UP, Orientation.FLIP_EAST, Orientation.FLIP_UP, Orientation.FLIP_EAST, Orientation.FLIP_UP, Orientation.EAST, Orientation.UP, Orientation.EAST });
        
        private final /* synthetic */ Orientation[] vert3Weights;
        
        WEST("WEST", 4, new EnumFacing[] { EnumFacing.UP, EnumFacing.DOWN, EnumFacing.NORTH, EnumFacing.SOUTH }, 0.6f, true, new Orientation[] { Orientation.UP, Orientation.SOUTH, Orientation.UP, Orientation.FLIP_SOUTH, Orientation.FLIP_UP, Orientation.FLIP_SOUTH, Orientation.FLIP_UP, Orientation.SOUTH }, new Orientation[] { Orientation.UP, Orientation.NORTH, Orientation.UP, Orientation.FLIP_NORTH, Orientation.FLIP_UP, Orientation.FLIP_NORTH, Orientation.FLIP_UP, Orientation.NORTH }, new Orientation[] { Orientation.DOWN, Orientation.NORTH, Orientation.DOWN, Orientation.FLIP_NORTH, Orientation.FLIP_DOWN, Orientation.FLIP_NORTH, Orientation.FLIP_DOWN, Orientation.NORTH }, new Orientation[] { Orientation.DOWN, Orientation.SOUTH, Orientation.DOWN, Orientation.FLIP_SOUTH, Orientation.FLIP_DOWN, Orientation.FLIP_SOUTH, Orientation.FLIP_DOWN, Orientation.SOUTH });
        
        public static EnumNeighborInfo getNeighbourInfo(final EnumFacing lllllllllllllllIIllIlllIIllIIllI) {
            return EnumNeighborInfo.VALUES[lllllllllllllllIIllIlllIIllIIllI.getIndex()];
        }
        
        private EnumNeighborInfo(final String lllllllllllllllIIllIlllIIlllIIII, final int lllllllllllllllIIllIlllIIllIllll, final EnumFacing[] lllllllllllllllIIllIlllIIllIlllI, final float lllllllllllllllIIllIlllIIlllIlll, final boolean lllllllllllllllIIllIlllIIlllIllI, final Orientation[] lllllllllllllllIIllIlllIIllIlIll, final Orientation[] lllllllllllllllIIllIlllIIllIlIlI, final Orientation[] lllllllllllllllIIllIlllIIlllIIll, final Orientation[] lllllllllllllllIIllIlllIIllIlIII) {
            this.corners = lllllllllllllllIIllIlllIIllIlllI;
            this.shadeWeight = lllllllllllllllIIllIlllIIlllIlll;
            this.doNonCubicWeight = lllllllllllllllIIllIlllIIlllIllI;
            this.vert0Weights = lllllllllllllllIIllIlllIIllIlIll;
            this.vert1Weights = lllllllllllllllIIllIlllIIllIlIlI;
            this.vert2Weights = lllllllllllllllIIllIlllIIlllIIll;
            this.vert3Weights = lllllllllllllllIIllIlllIIllIlIII;
        }
        
        static {
            (VALUES = new EnumNeighborInfo[6])[EnumFacing.DOWN.getIndex()] = EnumNeighborInfo.DOWN;
            EnumNeighborInfo.VALUES[EnumFacing.UP.getIndex()] = EnumNeighborInfo.UP;
            EnumNeighborInfo.VALUES[EnumFacing.NORTH.getIndex()] = EnumNeighborInfo.NORTH;
            EnumNeighborInfo.VALUES[EnumFacing.SOUTH.getIndex()] = EnumNeighborInfo.SOUTH;
            EnumNeighborInfo.VALUES[EnumFacing.WEST.getIndex()] = EnumNeighborInfo.WEST;
            EnumNeighborInfo.VALUES[EnumFacing.EAST.getIndex()] = EnumNeighborInfo.EAST;
        }
    }
}
