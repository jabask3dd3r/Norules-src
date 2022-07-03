package net.minecraft.client.renderer.debug;

import net.minecraft.client.*;
import net.minecraft.util.math.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.init.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.client.renderer.*;

public class DebugRendererHeightMap implements DebugRenderer.IDebugRenderer
{
    private final /* synthetic */ Minecraft minecraft;
    
    @Override
    public void render(final float lllllllllllllIllIlIlllllIIIIIlII, final long lllllllllllllIllIlIlllllIIIlIIIl) {
        final EntityPlayer lllllllllllllIllIlIlllllIIIlIIII = this.minecraft.player;
        final World lllllllllllllIllIlIlllllIIIIllll = this.minecraft.world;
        final double lllllllllllllIllIlIlllllIIIIlllI = lllllllllllllIllIlIlllllIIIlIIII.lastTickPosX + (lllllllllllllIllIlIlllllIIIlIIII.posX - lllllllllllllIllIlIlllllIIIlIIII.lastTickPosX) * lllllllllllllIllIlIlllllIIIIIlII;
        final double lllllllllllllIllIlIlllllIIIIllIl = lllllllllllllIllIlIlllllIIIlIIII.lastTickPosY + (lllllllllllllIllIlIlllllIIIlIIII.posY - lllllllllllllIllIlIlllllIIIlIIII.lastTickPosY) * lllllllllllllIllIlIlllllIIIIIlII;
        final double lllllllllllllIllIlIlllllIIIIllII = lllllllllllllIllIlIlllllIIIlIIII.lastTickPosZ + (lllllllllllllIllIlIlllllIIIlIIII.posZ - lllllllllllllIllIlIlllllIIIlIIII.lastTickPosZ) * lllllllllllllIllIlIlllllIIIIIlII;
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.disableTexture2D();
        final BlockPos lllllllllllllIllIlIlllllIIIIlIll = new BlockPos(lllllllllllllIllIlIlllllIIIlIIII.posX, 0.0, lllllllllllllIllIlIlllllIIIlIIII.posZ);
        final Iterable<BlockPos> lllllllllllllIllIlIlllllIIIIlIlI = BlockPos.getAllInBox(lllllllllllllIllIlIlllllIIIIlIll.add(-40, 0, -40), lllllllllllllIllIlIlllllIIIIlIll.add(40, 0, 40));
        final Tessellator lllllllllllllIllIlIlllllIIIIlIIl = Tessellator.getInstance();
        final BufferBuilder lllllllllllllIllIlIlllllIIIIlIII = lllllllllllllIllIlIlllllIIIIlIIl.getBuffer();
        lllllllllllllIllIlIlllllIIIIlIII.begin(5, DefaultVertexFormats.POSITION_COLOR);
        for (final BlockPos lllllllllllllIllIlIlllllIIIIIlll : lllllllllllllIllIlIlllllIIIIlIlI) {
            final int lllllllllllllIllIlIlllllIIIIIllI = lllllllllllllIllIlIlllllIIIIllll.getHeight(lllllllllllllIllIlIlllllIIIIIlll.getX(), lllllllllllllIllIlIlllllIIIIIlll.getZ());
            if (lllllllllllllIllIlIlllllIIIIllll.getBlockState(lllllllllllllIllIlIlllllIIIIIlll.add(0, lllllllllllllIllIlIlllllIIIIIllI, 0).down()) == Blocks.AIR.getDefaultState()) {
                RenderGlobal.addChainedFilledBoxVertices(lllllllllllllIllIlIlllllIIIIlIII, lllllllllllllIllIlIlllllIIIIIlll.getX() + 0.25f - lllllllllllllIllIlIlllllIIIIlllI, lllllllllllllIllIlIlllllIIIIIllI - lllllllllllllIllIlIlllllIIIIllIl, lllllllllllllIllIlIlllllIIIIIlll.getZ() + 0.25f - lllllllllllllIllIlIlllllIIIIllII, lllllllllllllIllIlIlllllIIIIIlll.getX() + 0.75f - lllllllllllllIllIlIlllllIIIIlllI, lllllllllllllIllIlIlllllIIIIIllI + 0.09375 - lllllllllllllIllIlIlllllIIIIllIl, lllllllllllllIllIlIlllllIIIIIlll.getZ() + 0.75f - lllllllllllllIllIlIlllllIIIIllII, 0.0f, 0.0f, 1.0f, 0.5f);
            }
            else {
                RenderGlobal.addChainedFilledBoxVertices(lllllllllllllIllIlIlllllIIIIlIII, lllllllllllllIllIlIlllllIIIIIlll.getX() + 0.25f - lllllllllllllIllIlIlllllIIIIlllI, lllllllllllllIllIlIlllllIIIIIllI - lllllllllllllIllIlIlllllIIIIllIl, lllllllllllllIllIlIlllllIIIIIlll.getZ() + 0.25f - lllllllllllllIllIlIlllllIIIIllII, lllllllllllllIllIlIlllllIIIIIlll.getX() + 0.75f - lllllllllllllIllIlIlllllIIIIlllI, lllllllllllllIllIlIlllllIIIIIllI + 0.09375 - lllllllllllllIllIlIlllllIIIIllIl, lllllllllllllIllIlIlllllIIIIIlll.getZ() + 0.75f - lllllllllllllIllIlIlllllIIIIllII, 0.0f, 1.0f, 0.0f, 0.5f);
            }
        }
        lllllllllllllIllIlIlllllIIIIlIIl.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.popMatrix();
    }
    
    public DebugRendererHeightMap(final Minecraft lllllllllllllIllIlIlllllIIlIIIlI) {
        this.minecraft = lllllllllllllIllIlIlllllIIlIIIlI;
    }
}
