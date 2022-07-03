package net.minecraft.client.renderer.debug;

import net.minecraft.client.*;
import net.minecraft.init.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.block.state.*;
import net.minecraft.util.math.*;
import net.minecraft.client.renderer.*;

public class DebugRendererSolidFace implements DebugRenderer.IDebugRenderer
{
    private final /* synthetic */ Minecraft field_193851_a;
    
    @Override
    public void render(final float llllllllllllllIIIIIlIIIIIlIIlllI, final long llllllllllllllIIIIIlIIIIIlllIIII) {
        final EntityPlayer llllllllllllllIIIIIlIIIIIllIllll = this.field_193851_a.player;
        final double llllllllllllllIIIIIlIIIIIllIlllI = llllllllllllllIIIIIlIIIIIllIllll.lastTickPosX + (llllllllllllllIIIIIlIIIIIllIllll.posX - llllllllllllllIIIIIlIIIIIllIllll.lastTickPosX) * llllllllllllllIIIIIlIIIIIlIIlllI;
        final double llllllllllllllIIIIIlIIIIIllIllIl = llllllllllllllIIIIIlIIIIIllIllll.lastTickPosY + (llllllllllllllIIIIIlIIIIIllIllll.posY - llllllllllllllIIIIIlIIIIIllIllll.lastTickPosY) * llllllllllllllIIIIIlIIIIIlIIlllI;
        final double llllllllllllllIIIIIlIIIIIllIllII = llllllllllllllIIIIIlIIIIIllIllll.lastTickPosZ + (llllllllllllllIIIIIlIIIIIllIllll.posZ - llllllllllllllIIIIIlIIIIIllIllll.lastTickPosZ) * llllllllllllllIIIIIlIIIIIlIIlllI;
        final World llllllllllllllIIIIIlIIIIIllIlIll = this.field_193851_a.player.world;
        final Iterable<BlockPos> llllllllllllllIIIIIlIIIIIllIlIlI = BlockPos.func_191532_a(MathHelper.floor(llllllllllllllIIIIIlIIIIIllIllll.posX - 6.0), MathHelper.floor(llllllllllllllIIIIIlIIIIIllIllll.posY - 6.0), MathHelper.floor(llllllllllllllIIIIIlIIIIIllIllll.posZ - 6.0), MathHelper.floor(llllllllllllllIIIIIlIIIIIllIllll.posX + 6.0), MathHelper.floor(llllllllllllllIIIIIlIIIIIllIllll.posY + 6.0), MathHelper.floor(llllllllllllllIIIIIlIIIIIllIllll.posZ + 6.0));
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.glLineWidth(2.0f);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask(false);
        for (final BlockPos llllllllllllllIIIIIlIIIIIllIlIIl : llllllllllllllIIIIIlIIIIIllIlIlI) {
            final IBlockState llllllllllllllIIIIIlIIIIIllIlIII = llllllllllllllIIIIIlIIIIIllIlIll.getBlockState(llllllllllllllIIIIIlIIIIIllIlIIl);
            if (llllllllllllllIIIIIlIIIIIllIlIII.getBlock() != Blocks.AIR) {
                final AxisAlignedBB llllllllllllllIIIIIlIIIIIllIIlll = llllllllllllllIIIIIlIIIIIllIlIII.getSelectedBoundingBox(llllllllllllllIIIIIlIIIIIllIlIll, llllllllllllllIIIIIlIIIIIllIlIIl).expandXyz(0.002).offset(-llllllllllllllIIIIIlIIIIIllIlllI, -llllllllllllllIIIIIlIIIIIllIllIl, -llllllllllllllIIIIIlIIIIIllIllII);
                final double llllllllllllllIIIIIlIIIIIllIIllI = llllllllllllllIIIIIlIIIIIllIIlll.minX;
                final double llllllllllllllIIIIIlIIIIIllIIlIl = llllllllllllllIIIIIlIIIIIllIIlll.minY;
                final double llllllllllllllIIIIIlIIIIIllIIlII = llllllllllllllIIIIIlIIIIIllIIlll.minZ;
                final double llllllllllllllIIIIIlIIIIIllIIIll = llllllllllllllIIIIIlIIIIIllIIlll.maxX;
                final double llllllllllllllIIIIIlIIIIIllIIIlI = llllllllllllllIIIIIlIIIIIllIIlll.maxY;
                final double llllllllllllllIIIIIlIIIIIllIIIIl = llllllllllllllIIIIIlIIIIIllIIlll.maxZ;
                final float llllllllllllllIIIIIlIIIIIllIIIII = 1.0f;
                final float llllllllllllllIIIIIlIIIIIlIlllll = 0.0f;
                final float llllllllllllllIIIIIlIIIIIlIllllI = 0.0f;
                final float llllllllllllllIIIIIlIIIIIlIlllIl = 0.5f;
                if (llllllllllllllIIIIIlIIIIIllIlIII.func_193401_d(llllllllllllllIIIIIlIIIIIllIlIll, llllllllllllllIIIIIlIIIIIllIlIIl, EnumFacing.WEST) == BlockFaceShape.SOLID) {
                    final Tessellator llllllllllllllIIIIIlIIIIIlIlllII = Tessellator.getInstance();
                    final BufferBuilder llllllllllllllIIIIIlIIIIIlIllIll = llllllllllllllIIIIIlIIIIIlIlllII.getBuffer();
                    llllllllllllllIIIIIlIIIIIlIllIll.begin(5, DefaultVertexFormats.POSITION_COLOR);
                    llllllllllllllIIIIIlIIIIIlIllIll.pos(llllllllllllllIIIIIlIIIIIllIIllI, llllllllllllllIIIIIlIIIIIllIIlIl, llllllllllllllIIIIIlIIIIIllIIlII).color(1.0f, 0.0f, 0.0f, 0.5f).endVertex();
                    llllllllllllllIIIIIlIIIIIlIllIll.pos(llllllllllllllIIIIIlIIIIIllIIllI, llllllllllllllIIIIIlIIIIIllIIlIl, llllllllllllllIIIIIlIIIIIllIIIIl).color(1.0f, 0.0f, 0.0f, 0.5f).endVertex();
                    llllllllllllllIIIIIlIIIIIlIllIll.pos(llllllllllllllIIIIIlIIIIIllIIllI, llllllllllllllIIIIIlIIIIIllIIIlI, llllllllllllllIIIIIlIIIIIllIIlII).color(1.0f, 0.0f, 0.0f, 0.5f).endVertex();
                    llllllllllllllIIIIIlIIIIIlIllIll.pos(llllllllllllllIIIIIlIIIIIllIIllI, llllllllllllllIIIIIlIIIIIllIIIlI, llllllllllllllIIIIIlIIIIIllIIIIl).color(1.0f, 0.0f, 0.0f, 0.5f).endVertex();
                    llllllllllllllIIIIIlIIIIIlIlllII.draw();
                }
                if (llllllllllllllIIIIIlIIIIIllIlIII.func_193401_d(llllllllllllllIIIIIlIIIIIllIlIll, llllllllllllllIIIIIlIIIIIllIlIIl, EnumFacing.SOUTH) == BlockFaceShape.SOLID) {
                    final Tessellator llllllllllllllIIIIIlIIIIIlIllIlI = Tessellator.getInstance();
                    final BufferBuilder llllllllllllllIIIIIlIIIIIlIllIIl = llllllllllllllIIIIIlIIIIIlIllIlI.getBuffer();
                    llllllllllllllIIIIIlIIIIIlIllIIl.begin(5, DefaultVertexFormats.POSITION_COLOR);
                    llllllllllllllIIIIIlIIIIIlIllIIl.pos(llllllllllllllIIIIIlIIIIIllIIllI, llllllllllllllIIIIIlIIIIIllIIIlI, llllllllllllllIIIIIlIIIIIllIIIIl).color(1.0f, 0.0f, 0.0f, 0.5f).endVertex();
                    llllllllllllllIIIIIlIIIIIlIllIIl.pos(llllllllllllllIIIIIlIIIIIllIIllI, llllllllllllllIIIIIlIIIIIllIIlIl, llllllllllllllIIIIIlIIIIIllIIIIl).color(1.0f, 0.0f, 0.0f, 0.5f).endVertex();
                    llllllllllllllIIIIIlIIIIIlIllIIl.pos(llllllllllllllIIIIIlIIIIIllIIIll, llllllllllllllIIIIIlIIIIIllIIIlI, llllllllllllllIIIIIlIIIIIllIIIIl).color(1.0f, 0.0f, 0.0f, 0.5f).endVertex();
                    llllllllllllllIIIIIlIIIIIlIllIIl.pos(llllllllllllllIIIIIlIIIIIllIIIll, llllllllllllllIIIIIlIIIIIllIIlIl, llllllllllllllIIIIIlIIIIIllIIIIl).color(1.0f, 0.0f, 0.0f, 0.5f).endVertex();
                    llllllllllllllIIIIIlIIIIIlIllIlI.draw();
                }
                if (llllllllllllllIIIIIlIIIIIllIlIII.func_193401_d(llllllllllllllIIIIIlIIIIIllIlIll, llllllllllllllIIIIIlIIIIIllIlIIl, EnumFacing.EAST) == BlockFaceShape.SOLID) {
                    final Tessellator llllllllllllllIIIIIlIIIIIlIllIII = Tessellator.getInstance();
                    final BufferBuilder llllllllllllllIIIIIlIIIIIlIlIlll = llllllllllllllIIIIIlIIIIIlIllIII.getBuffer();
                    llllllllllllllIIIIIlIIIIIlIlIlll.begin(5, DefaultVertexFormats.POSITION_COLOR);
                    llllllllllllllIIIIIlIIIIIlIlIlll.pos(llllllllllllllIIIIIlIIIIIllIIIll, llllllllllllllIIIIIlIIIIIllIIlIl, llllllllllllllIIIIIlIIIIIllIIIIl).color(1.0f, 0.0f, 0.0f, 0.5f).endVertex();
                    llllllllllllllIIIIIlIIIIIlIlIlll.pos(llllllllllllllIIIIIlIIIIIllIIIll, llllllllllllllIIIIIlIIIIIllIIlIl, llllllllllllllIIIIIlIIIIIllIIlII).color(1.0f, 0.0f, 0.0f, 0.5f).endVertex();
                    llllllllllllllIIIIIlIIIIIlIlIlll.pos(llllllllllllllIIIIIlIIIIIllIIIll, llllllllllllllIIIIIlIIIIIllIIIlI, llllllllllllllIIIIIlIIIIIllIIIIl).color(1.0f, 0.0f, 0.0f, 0.5f).endVertex();
                    llllllllllllllIIIIIlIIIIIlIlIlll.pos(llllllllllllllIIIIIlIIIIIllIIIll, llllllllllllllIIIIIlIIIIIllIIIlI, llllllllllllllIIIIIlIIIIIllIIlII).color(1.0f, 0.0f, 0.0f, 0.5f).endVertex();
                    llllllllllllllIIIIIlIIIIIlIllIII.draw();
                }
                if (llllllllllllllIIIIIlIIIIIllIlIII.func_193401_d(llllllllllllllIIIIIlIIIIIllIlIll, llllllllllllllIIIIIlIIIIIllIlIIl, EnumFacing.NORTH) == BlockFaceShape.SOLID) {
                    final Tessellator llllllllllllllIIIIIlIIIIIlIlIllI = Tessellator.getInstance();
                    final BufferBuilder llllllllllllllIIIIIlIIIIIlIlIlIl = llllllllllllllIIIIIlIIIIIlIlIllI.getBuffer();
                    llllllllllllllIIIIIlIIIIIlIlIlIl.begin(5, DefaultVertexFormats.POSITION_COLOR);
                    llllllllllllllIIIIIlIIIIIlIlIlIl.pos(llllllllllllllIIIIIlIIIIIllIIIll, llllllllllllllIIIIIlIIIIIllIIIlI, llllllllllllllIIIIIlIIIIIllIIlII).color(1.0f, 0.0f, 0.0f, 0.5f).endVertex();
                    llllllllllllllIIIIIlIIIIIlIlIlIl.pos(llllllllllllllIIIIIlIIIIIllIIIll, llllllllllllllIIIIIlIIIIIllIIlIl, llllllllllllllIIIIIlIIIIIllIIlII).color(1.0f, 0.0f, 0.0f, 0.5f).endVertex();
                    llllllllllllllIIIIIlIIIIIlIlIlIl.pos(llllllllllllllIIIIIlIIIIIllIIllI, llllllllllllllIIIIIlIIIIIllIIIlI, llllllllllllllIIIIIlIIIIIllIIlII).color(1.0f, 0.0f, 0.0f, 0.5f).endVertex();
                    llllllllllllllIIIIIlIIIIIlIlIlIl.pos(llllllllllllllIIIIIlIIIIIllIIllI, llllllllllllllIIIIIlIIIIIllIIlIl, llllllllllllllIIIIIlIIIIIllIIlII).color(1.0f, 0.0f, 0.0f, 0.5f).endVertex();
                    llllllllllllllIIIIIlIIIIIlIlIllI.draw();
                }
                if (llllllllllllllIIIIIlIIIIIllIlIII.func_193401_d(llllllllllllllIIIIIlIIIIIllIlIll, llllllllllllllIIIIIlIIIIIllIlIIl, EnumFacing.DOWN) == BlockFaceShape.SOLID) {
                    final Tessellator llllllllllllllIIIIIlIIIIIlIlIlII = Tessellator.getInstance();
                    final BufferBuilder llllllllllllllIIIIIlIIIIIlIlIIll = llllllllllllllIIIIIlIIIIIlIlIlII.getBuffer();
                    llllllllllllllIIIIIlIIIIIlIlIIll.begin(5, DefaultVertexFormats.POSITION_COLOR);
                    llllllllllllllIIIIIlIIIIIlIlIIll.pos(llllllllllllllIIIIIlIIIIIllIIllI, llllllllllllllIIIIIlIIIIIllIIlIl, llllllllllllllIIIIIlIIIIIllIIlII).color(1.0f, 0.0f, 0.0f, 0.5f).endVertex();
                    llllllllllllllIIIIIlIIIIIlIlIIll.pos(llllllllllllllIIIIIlIIIIIllIIIll, llllllllllllllIIIIIlIIIIIllIIlIl, llllllllllllllIIIIIlIIIIIllIIlII).color(1.0f, 0.0f, 0.0f, 0.5f).endVertex();
                    llllllllllllllIIIIIlIIIIIlIlIIll.pos(llllllllllllllIIIIIlIIIIIllIIllI, llllllllllllllIIIIIlIIIIIllIIlIl, llllllllllllllIIIIIlIIIIIllIIIIl).color(1.0f, 0.0f, 0.0f, 0.5f).endVertex();
                    llllllllllllllIIIIIlIIIIIlIlIIll.pos(llllllllllllllIIIIIlIIIIIllIIIll, llllllllllllllIIIIIlIIIIIllIIlIl, llllllllllllllIIIIIlIIIIIllIIIIl).color(1.0f, 0.0f, 0.0f, 0.5f).endVertex();
                    llllllllllllllIIIIIlIIIIIlIlIlII.draw();
                }
                if (llllllllllllllIIIIIlIIIIIllIlIII.func_193401_d(llllllllllllllIIIIIlIIIIIllIlIll, llllllllllllllIIIIIlIIIIIllIlIIl, EnumFacing.UP) != BlockFaceShape.SOLID) {
                    continue;
                }
                final Tessellator llllllllllllllIIIIIlIIIIIlIlIIlI = Tessellator.getInstance();
                final BufferBuilder llllllllllllllIIIIIlIIIIIlIlIIIl = llllllllllllllIIIIIlIIIIIlIlIIlI.getBuffer();
                llllllllllllllIIIIIlIIIIIlIlIIIl.begin(5, DefaultVertexFormats.POSITION_COLOR);
                llllllllllllllIIIIIlIIIIIlIlIIIl.pos(llllllllllllllIIIIIlIIIIIllIIllI, llllllllllllllIIIIIlIIIIIllIIIlI, llllllllllllllIIIIIlIIIIIllIIlII).color(1.0f, 0.0f, 0.0f, 0.5f).endVertex();
                llllllllllllllIIIIIlIIIIIlIlIIIl.pos(llllllllllllllIIIIIlIIIIIllIIllI, llllllllllllllIIIIIlIIIIIllIIIlI, llllllllllllllIIIIIlIIIIIllIIIIl).color(1.0f, 0.0f, 0.0f, 0.5f).endVertex();
                llllllllllllllIIIIIlIIIIIlIlIIIl.pos(llllllllllllllIIIIIlIIIIIllIIIll, llllllllllllllIIIIIlIIIIIllIIIlI, llllllllllllllIIIIIlIIIIIllIIlII).color(1.0f, 0.0f, 0.0f, 0.5f).endVertex();
                llllllllllllllIIIIIlIIIIIlIlIIIl.pos(llllllllllllllIIIIIlIIIIIllIIIll, llllllllllllllIIIIIlIIIIIllIIIlI, llllllllllllllIIIIIlIIIIIllIIIIl).color(1.0f, 0.0f, 0.0f, 0.5f).endVertex();
                llllllllllllllIIIIIlIIIIIlIlIIlI.draw();
            }
        }
        GlStateManager.depthMask(true);
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }
    
    public DebugRendererSolidFace(final Minecraft llllllllllllllIIIIIlIIIIlIIIllIl) {
        this.field_193851_a = llllllllllllllIIIIIlIIIIlIIIllIl;
    }
}
