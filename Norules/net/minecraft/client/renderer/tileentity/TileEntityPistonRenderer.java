package net.minecraft.client.renderer.tileentity;

import net.minecraft.util.math.*;
import net.minecraft.block.state.*;
import net.minecraft.world.*;
import net.minecraft.block.material.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.init.*;
import net.minecraft.block.properties.*;
import net.minecraft.util.*;
import net.minecraft.block.*;
import net.minecraft.tileentity.*;

public class TileEntityPistonRenderer extends TileEntitySpecialRenderer<TileEntityPiston>
{
    private final /* synthetic */ BlockRendererDispatcher blockRenderer;
    
    private boolean renderStateModel(final BlockPos llllllllllllllIlIIllIIlllIlIIllI, final IBlockState llllllllllllllIlIIllIIlllIIlllll, final BufferBuilder llllllllllllllIlIIllIIlllIIllllI, final World llllllllllllllIlIIllIIlllIlIIIll, final boolean llllllllllllllIlIIllIIlllIIlllII) {
        return this.blockRenderer.getBlockModelRenderer().renderModel(llllllllllllllIlIIllIIlllIlIIIll, this.blockRenderer.getModelForState(llllllllllllllIlIIllIIlllIIlllll), llllllllllllllIlIIllIIlllIIlllll, llllllllllllllIlIIllIIlllIlIIllI, llllllllllllllIlIIllIIlllIIllllI, llllllllllllllIlIIllIIlllIIlllII);
    }
    
    @Override
    public void func_192841_a(final TileEntityPiston llllllllllllllIlIIllIIllllIIlIlI, final double llllllllllllllIlIIllIIlllIlllIIl, final double llllllllllllllIlIIllIIlllIlllIII, final double llllllllllllllIlIIllIIlllIllIlll, final float llllllllllllllIlIIllIIlllIllIllI, final int llllllllllllllIlIIllIIllllIIIlIl, final float llllllllllllllIlIIllIIllllIIIlII) {
        final BlockPos llllllllllllllIlIIllIIllllIIIIll = llllllllllllllIlIIllIIllllIIlIlI.getPos();
        IBlockState llllllllllllllIlIIllIIllllIIIIlI = llllllllllllllIlIIllIIllllIIlIlI.getPistonState();
        final Block llllllllllllllIlIIllIIllllIIIIIl = llllllllllllllIlIIllIIllllIIIIlI.getBlock();
        if (llllllllllllllIlIIllIIllllIIIIlI.getMaterial() != Material.AIR && llllllllllllllIlIIllIIllllIIlIlI.getProgress(llllllllllllllIlIIllIIlllIllIllI) < 1.0f) {
            final Tessellator llllllllllllllIlIIllIIllllIIIIII = Tessellator.getInstance();
            final BufferBuilder llllllllllllllIlIIllIIlllIllllll = llllllllllllllIlIIllIIllllIIIIII.getBuffer();
            this.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
            RenderHelper.disableStandardItemLighting();
            GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
            GlStateManager.enableBlend();
            GlStateManager.disableCull();
            if (Minecraft.isAmbientOcclusionEnabled()) {
                GlStateManager.shadeModel(7425);
            }
            else {
                GlStateManager.shadeModel(7424);
            }
            llllllllllllllIlIIllIIlllIllllll.begin(7, DefaultVertexFormats.BLOCK);
            llllllllllllllIlIIllIIlllIllllll.setTranslation(llllllllllllllIlIIllIIlllIlllIIl - llllllllllllllIlIIllIIllllIIIIll.getX() + llllllllllllllIlIIllIIllllIIlIlI.getOffsetX(llllllllllllllIlIIllIIlllIllIllI), llllllllllllllIlIIllIIlllIlllIII - llllllllllllllIlIIllIIllllIIIIll.getY() + llllllllllllllIlIIllIIllllIIlIlI.getOffsetY(llllllllllllllIlIIllIIlllIllIllI), llllllllllllllIlIIllIIlllIllIlll - llllllllllllllIlIIllIIllllIIIIll.getZ() + llllllllllllllIlIIllIIllllIIlIlI.getOffsetZ(llllllllllllllIlIIllIIlllIllIllI));
            final World llllllllllllllIlIIllIIlllIlllllI = this.getWorld();
            if (llllllllllllllIlIIllIIllllIIIIIl == Blocks.PISTON_HEAD && llllllllllllllIlIIllIIllllIIlIlI.getProgress(llllllllllllllIlIIllIIlllIllIllI) <= 0.25f) {
                llllllllllllllIlIIllIIllllIIIIlI = llllllllllllllIlIIllIIllllIIIIlI.withProperty((IProperty<Comparable>)BlockPistonExtension.SHORT, true);
                this.renderStateModel(llllllllllllllIlIIllIIllllIIIIll, llllllllllllllIlIIllIIllllIIIIlI, llllllllllllllIlIIllIIlllIllllll, llllllllllllllIlIIllIIlllIlllllI, true);
            }
            else if (llllllllllllllIlIIllIIllllIIlIlI.shouldPistonHeadBeRendered() && !llllllllllllllIlIIllIIllllIIlIlI.isExtending()) {
                final BlockPistonExtension.EnumPistonType llllllllllllllIlIIllIIlllIllllIl = (llllllllllllllIlIIllIIllllIIIIIl == Blocks.STICKY_PISTON) ? BlockPistonExtension.EnumPistonType.STICKY : BlockPistonExtension.EnumPistonType.DEFAULT;
                IBlockState llllllllllllllIlIIllIIlllIllllII = Blocks.PISTON_HEAD.getDefaultState().withProperty(BlockPistonExtension.TYPE, llllllllllllllIlIIllIIlllIllllIl).withProperty((IProperty<Comparable>)BlockPistonExtension.FACING, (EnumFacing)llllllllllllllIlIIllIIllllIIIIlI.getValue((IProperty<V>)BlockPistonBase.FACING));
                llllllllllllllIlIIllIIlllIllllII = llllllllllllllIlIIllIIlllIllllII.withProperty((IProperty<Comparable>)BlockPistonExtension.SHORT, llllllllllllllIlIIllIIllllIIlIlI.getProgress(llllllllllllllIlIIllIIlllIllIllI) >= 0.5f);
                this.renderStateModel(llllllllllllllIlIIllIIllllIIIIll, llllllllllllllIlIIllIIlllIllllII, llllllllllllllIlIIllIIlllIllllll, llllllllllllllIlIIllIIlllIlllllI, true);
                llllllllllllllIlIIllIIlllIllllll.setTranslation(llllllllllllllIlIIllIIlllIlllIIl - llllllllllllllIlIIllIIllllIIIIll.getX(), llllllllllllllIlIIllIIlllIlllIII - llllllllllllllIlIIllIIllllIIIIll.getY(), llllllllllllllIlIIllIIlllIllIlll - llllllllllllllIlIIllIIllllIIIIll.getZ());
                llllllllllllllIlIIllIIllllIIIIlI = llllllllllllllIlIIllIIllllIIIIlI.withProperty((IProperty<Comparable>)BlockPistonBase.EXTENDED, true);
                this.renderStateModel(llllllllllllllIlIIllIIllllIIIIll, llllllllllllllIlIIllIIllllIIIIlI, llllllllllllllIlIIllIIlllIllllll, llllllllllllllIlIIllIIlllIlllllI, true);
            }
            else {
                this.renderStateModel(llllllllllllllIlIIllIIllllIIIIll, llllllllllllllIlIIllIIllllIIIIlI, llllllllllllllIlIIllIIlllIllllll, llllllllllllllIlIIllIIlllIlllllI, false);
            }
            llllllllllllllIlIIllIIlllIllllll.setTranslation(0.0, 0.0, 0.0);
            llllllllllllllIlIIllIIllllIIIIII.draw();
            RenderHelper.enableStandardItemLighting();
        }
    }
    
    public TileEntityPistonRenderer() {
        this.blockRenderer = Minecraft.getMinecraft().getBlockRendererDispatcher();
    }
}
