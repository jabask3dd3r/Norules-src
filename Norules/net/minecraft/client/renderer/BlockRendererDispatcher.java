package net.minecraft.client.renderer;

import net.minecraft.block.state.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.crash.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.color.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.client.renderer.block.model.*;
import net.minecraft.client.resources.*;

public class BlockRendererDispatcher implements IResourceManagerReloadListener
{
    private final /* synthetic */ BlockModelShapes blockModelShapes;
    private final /* synthetic */ BlockModelRenderer blockModelRenderer;
    private final /* synthetic */ BlockFluidRenderer fluidRenderer;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumBlockRenderType;
    private final /* synthetic */ ChestRenderer chestRenderer;
    
    public boolean renderBlock(IBlockState llIIIIlIlIIIllI, final BlockPos llIIIIlIlIIIlIl, final IBlockAccess llIIIIlIlIIIlII, final BufferBuilder llIIIIlIlIIIIll) {
        try {
            final EnumBlockRenderType llIIIIlIlIIlIll = llIIIIlIlIIIllI.getRenderType();
            if (llIIIIlIlIIlIll == EnumBlockRenderType.INVISIBLE) {
                return false;
            }
            if (llIIIIlIlIIIlII.getWorldType() != WorldType.DEBUG_WORLD) {
                try {
                    llIIIIlIlIIIllI = llIIIIlIlIIIllI.getActualState(llIIIIlIlIIIlII, llIIIIlIlIIIlIl);
                }
                catch (Exception ex) {}
            }
            switch ($SWITCH_TABLE$net$minecraft$util$EnumBlockRenderType()[llIIIIlIlIIlIll.ordinal()]) {
                case 4: {
                    return this.blockModelRenderer.renderModel(llIIIIlIlIIIlII, this.getModelForState(llIIIIlIlIIIllI), llIIIIlIlIIIllI, llIIIIlIlIIIlIl, llIIIIlIlIIIIll, true);
                }
                case 3: {
                    return false;
                }
                case 2: {
                    return this.fluidRenderer.renderFluid(llIIIIlIlIIIlII, llIIIIlIlIIIllI, llIIIIlIlIIIlIl, llIIIIlIlIIIIll);
                }
                default: {
                    return false;
                }
            }
        }
        catch (Throwable llIIIIlIlIIlIlI) {
            final CrashReport llIIIIlIlIIlIIl = CrashReport.makeCrashReport(llIIIIlIlIIlIlI, "Tesselating block in world");
            final CrashReportCategory llIIIIlIlIIlIII = llIIIIlIlIIlIIl.makeCategory("Block being tesselated");
            CrashReportCategory.addBlockInfo(llIIIIlIlIIlIII, llIIIIlIlIIIlIl, llIIIIlIlIIIllI.getBlock(), llIIIIlIlIIIllI.getBlock().getMetaFromState(llIIIIlIlIIIllI));
            throw new ReportedException(llIIIIlIlIIlIIl);
        }
    }
    
    public BlockRendererDispatcher(final BlockModelShapes llIIIIlIlllIlIl, final BlockColors llIIIIlIlllIlII) {
        this.chestRenderer = new ChestRenderer();
        this.blockModelShapes = llIIIIlIlllIlIl;
        this.blockModelRenderer = new BlockModelRenderer(llIIIIlIlllIlII);
        this.fluidRenderer = new BlockFluidRenderer(llIIIIlIlllIlII);
    }
    
    public void renderBlockBrightness(final IBlockState llIIIIlIIlIlIll, final float llIIIIlIIlIllll) {
        final EnumBlockRenderType llIIIIlIIlIlllI = llIIIIlIIlIlIll.getRenderType();
        if (llIIIIlIIlIlllI != EnumBlockRenderType.INVISIBLE) {
            switch ($SWITCH_TABLE$net$minecraft$util$EnumBlockRenderType()[llIIIIlIIlIlllI.ordinal()]) {
                case 4: {
                    final IBakedModel llIIIIlIIlIllIl = this.getModelForState(llIIIIlIIlIlIll);
                    this.blockModelRenderer.renderModelBrightness(llIIIIlIIlIllIl, llIIIIlIIlIlIll, llIIIIlIIlIllll, true);
                    break;
                }
                case 3: {
                    this.chestRenderer.renderChestBrightness(llIIIIlIIlIlIll.getBlock(), llIIIIlIIlIllll);
                    break;
                }
            }
        }
    }
    
    public IBakedModel getModelForState(final IBlockState llIIIIlIIlllIIl) {
        return this.blockModelShapes.getModelForState(llIIIIlIIlllIIl);
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumBlockRenderType() {
        final int[] $switch_TABLE$net$minecraft$util$EnumBlockRenderType = BlockRendererDispatcher.$SWITCH_TABLE$net$minecraft$util$EnumBlockRenderType;
        if ($switch_TABLE$net$minecraft$util$EnumBlockRenderType != null) {
            return $switch_TABLE$net$minecraft$util$EnumBlockRenderType;
        }
        final boolean llIIIIlIIlIIIlI = (Object)new int[EnumBlockRenderType.values().length];
        try {
            llIIIIlIIlIIIlI[EnumBlockRenderType.ENTITYBLOCK_ANIMATED.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llIIIIlIIlIIIlI[EnumBlockRenderType.INVISIBLE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llIIIIlIIlIIIlI[EnumBlockRenderType.LIQUID.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llIIIIlIIlIIIlI[EnumBlockRenderType.MODEL.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return BlockRendererDispatcher.$SWITCH_TABLE$net$minecraft$util$EnumBlockRenderType = (int[])(Object)llIIIIlIIlIIIlI;
    }
    
    public BlockModelRenderer getBlockModelRenderer() {
        return this.blockModelRenderer;
    }
    
    public void renderBlockDamage(IBlockState llIIIIlIlIllllI, final BlockPos llIIIIlIllIIlII, final TextureAtlasSprite llIIIIlIlIlllII, final IBlockAccess llIIIIlIlIllIll) {
        if (llIIIIlIlIllllI.getRenderType() == EnumBlockRenderType.MODEL) {
            llIIIIlIlIllllI = llIIIIlIlIllllI.getActualState(llIIIIlIlIllIll, llIIIIlIllIIlII);
            final IBakedModel llIIIIlIllIIIIl = this.blockModelShapes.getModelForState(llIIIIlIlIllllI);
            final IBakedModel llIIIIlIllIIIII = new SimpleBakedModel.Builder(llIIIIlIlIllllI, llIIIIlIllIIIIl, llIIIIlIlIlllII, llIIIIlIllIIlII).makeBakedModel();
            this.blockModelRenderer.renderModel(llIIIIlIlIllIll, llIIIIlIllIIIII, llIIIIlIlIllllI, llIIIIlIllIIlII, Tessellator.getInstance().getBuffer(), true);
        }
    }
    
    @Override
    public void onResourceManagerReload(final IResourceManager llIIIIlIIlIIlIl) {
        this.fluidRenderer.initAtlasSprites();
    }
    
    public BlockModelShapes getBlockModelShapes() {
        return this.blockModelShapes;
    }
}
