package net.minecraft.client.renderer.entity;

import net.minecraft.entity.item.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.client.*;
import net.minecraft.util.math.*;
import net.minecraft.block.state.*;
import net.minecraft.world.*;
import net.minecraft.client.renderer.*;

public class RenderFallingBlock extends Render<EntityFallingBlock>
{
    @Override
    protected ResourceLocation getEntityTexture(final EntityFallingBlock llllllllllllllllIlllIIllIlllIllI) {
        return TextureMap.LOCATION_BLOCKS_TEXTURE;
    }
    
    @Override
    public void doRender(final EntityFallingBlock llllllllllllllllIlllIIlllIIIIIll, final double llllllllllllllllIlllIIlllIIIIIlI, final double llllllllllllllllIlllIIlllIIIlllI, final double llllllllllllllllIlllIIlllIIIllIl, final float llllllllllllllllIlllIIllIlllllll, final float llllllllllllllllIlllIIllIllllllI) {
        if (llllllllllllllllIlllIIlllIIIIIll.getBlock() != null) {
            final IBlockState llllllllllllllllIlllIIlllIIIlIlI = llllllllllllllllIlllIIlllIIIIIll.getBlock();
            if (llllllllllllllllIlllIIlllIIIlIlI.getRenderType() == EnumBlockRenderType.MODEL) {
                final World llllllllllllllllIlllIIlllIIIlIIl = llllllllllllllllIlllIIlllIIIIIll.getWorldObj();
                if (llllllllllllllllIlllIIlllIIIlIlI != llllllllllllllllIlllIIlllIIIlIIl.getBlockState(new BlockPos(llllllllllllllllIlllIIlllIIIIIll)) && llllllllllllllllIlllIIlllIIIlIlI.getRenderType() != EnumBlockRenderType.INVISIBLE) {
                    this.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
                    GlStateManager.pushMatrix();
                    GlStateManager.disableLighting();
                    final Tessellator llllllllllllllllIlllIIlllIIIlIII = Tessellator.getInstance();
                    final BufferBuilder llllllllllllllllIlllIIlllIIIIlll = llllllllllllllllIlllIIlllIIIlIII.getBuffer();
                    if (this.renderOutlines) {
                        GlStateManager.enableColorMaterial();
                        GlStateManager.enableOutlineMode(this.getTeamColor(llllllllllllllllIlllIIlllIIIIIll));
                    }
                    llllllllllllllllIlllIIlllIIIIlll.begin(7, DefaultVertexFormats.BLOCK);
                    final BlockPos llllllllllllllllIlllIIlllIIIIllI = new BlockPos(llllllllllllllllIlllIIlllIIIIIll.posX, llllllllllllllllIlllIIlllIIIIIll.getEntityBoundingBox().maxY, llllllllllllllllIlllIIlllIIIIIll.posZ);
                    GlStateManager.translate((float)(llllllllllllllllIlllIIlllIIIIIlI - llllllllllllllllIlllIIlllIIIIllI.getX() - 0.5), (float)(llllllllllllllllIlllIIlllIIIlllI - llllllllllllllllIlllIIlllIIIIllI.getY()), (float)(llllllllllllllllIlllIIlllIIIllIl - llllllllllllllllIlllIIlllIIIIllI.getZ() - 0.5));
                    final BlockRendererDispatcher llllllllllllllllIlllIIlllIIIIlIl = Minecraft.getMinecraft().getBlockRendererDispatcher();
                    llllllllllllllllIlllIIlllIIIIlIl.getBlockModelRenderer().renderModel(llllllllllllllllIlllIIlllIIIlIIl, llllllllllllllllIlllIIlllIIIIlIl.getModelForState(llllllllllllllllIlllIIlllIIIlIlI), llllllllllllllllIlllIIlllIIIlIlI, llllllllllllllllIlllIIlllIIIIllI, llllllllllllllllIlllIIlllIIIIlll, false, MathHelper.getPositionRandom(llllllllllllllllIlllIIlllIIIIIll.getOrigin()));
                    llllllllllllllllIlllIIlllIIIlIII.draw();
                    if (this.renderOutlines) {
                        GlStateManager.disableOutlineMode();
                        GlStateManager.disableColorMaterial();
                    }
                    GlStateManager.enableLighting();
                    GlStateManager.popMatrix();
                    super.doRender(llllllllllllllllIlllIIlllIIIIIll, llllllllllllllllIlllIIlllIIIIIlI, llllllllllllllllIlllIIlllIIIlllI, llllllllllllllllIlllIIlllIIIllIl, llllllllllllllllIlllIIllIlllllll, llllllllllllllllIlllIIllIllllllI);
                }
            }
        }
    }
    
    public RenderFallingBlock(final RenderManager llllllllllllllllIlllIIlllIlIIIIl) {
        super(llllllllllllllllIlllIIlllIlIIIIl);
        this.shadowSize = 0.5f;
    }
}
