package net.minecraft.client.renderer.debug;

import net.minecraft.client.*;
import net.minecraft.entity.player.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import net.minecraft.util.math.*;
import net.minecraft.client.renderer.*;
import net.minecraft.block.properties.*;
import net.minecraft.world.*;
import net.minecraft.block.state.*;

public class DebugRendererWater implements DebugRenderer.IDebugRenderer
{
    private /* synthetic */ double zo;
    private final /* synthetic */ Minecraft minecraft;
    private /* synthetic */ double yo;
    private /* synthetic */ double xo;
    private /* synthetic */ EntityPlayer player;
    
    public DebugRendererWater(final Minecraft lllllllllllllIllllIllllllIIlIlII) {
        this.minecraft = lllllllllllllIllllIllllllIIlIlII;
    }
    
    @Override
    public void render(final float lllllllllllllIllllIllllllIIIIllI, final long lllllllllllllIllllIllllllIIIIlIl) {
        this.player = this.minecraft.player;
        this.xo = this.player.lastTickPosX + (this.player.posX - this.player.lastTickPosX) * lllllllllllllIllllIllllllIIIIllI;
        this.yo = this.player.lastTickPosY + (this.player.posY - this.player.lastTickPosY) * lllllllllllllIllllIllllllIIIIllI;
        this.zo = this.player.lastTickPosZ + (this.player.posZ - this.player.lastTickPosZ) * lllllllllllllIllllIllllllIIIIllI;
        final BlockPos lllllllllllllIllllIllllllIIIIlII = this.minecraft.player.getPosition();
        final World lllllllllllllIllllIllllllIIIIIll = this.minecraft.player.world;
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.color(0.0f, 1.0f, 0.0f, 0.75f);
        GlStateManager.disableTexture2D();
        GlStateManager.glLineWidth(6.0f);
        for (final BlockPos lllllllllllllIllllIllllllIIIIIlI : BlockPos.getAllInBox(lllllllllllllIllllIllllllIIIIlII.add(-10, -10, -10), lllllllllllllIllllIllllllIIIIlII.add(10, 10, 10))) {
            final IBlockState lllllllllllllIllllIllllllIIIIIIl = lllllllllllllIllllIllllllIIIIIll.getBlockState(lllllllllllllIllllIllllllIIIIIlI);
            if (lllllllllllllIllllIllllllIIIIIIl.getBlock() == Blocks.WATER || lllllllllllllIllllIllllllIIIIIIl.getBlock() == Blocks.FLOWING_WATER) {
                final double lllllllllllllIllllIllllllIIIIIII = BlockLiquid.func_190972_g(lllllllllllllIllllIllllllIIIIIIl, lllllllllllllIllllIllllllIIIIIll, lllllllllllllIllllIllllllIIIIIlI);
                RenderGlobal.renderFilledBox(new AxisAlignedBB(lllllllllllllIllllIllllllIIIIIlI.getX() + 0.01f, lllllllllllllIllllIllllllIIIIIlI.getY() + 0.01f, lllllllllllllIllllIllllllIIIIIlI.getZ() + 0.01f, lllllllllllllIllllIllllllIIIIIlI.getX() + 0.99f, lllllllllllllIllllIllllllIIIIIII, lllllllllllllIllllIllllllIIIIIlI.getZ() + 0.99f).offset(-this.xo, -this.yo, -this.zo), 1.0f, 1.0f, 1.0f, 0.2f);
            }
        }
        for (final BlockPos lllllllllllllIllllIlllllIlllllll : BlockPos.getAllInBox(lllllllllllllIllllIllllllIIIIlII.add(-10, -10, -10), lllllllllllllIllllIllllllIIIIlII.add(10, 10, 10))) {
            final IBlockState lllllllllllllIllllIlllllIllllllI = lllllllllllllIllllIllllllIIIIIll.getBlockState(lllllllllllllIllllIlllllIlllllll);
            if (lllllllllllllIllllIlllllIllllllI.getBlock() == Blocks.WATER || lllllllllllllIllllIlllllIllllllI.getBlock() == Blocks.FLOWING_WATER) {
                final Integer lllllllllllllIllllIlllllIlllllIl = lllllllllllllIllllIlllllIllllllI.getValue((IProperty<Integer>)BlockLiquid.LEVEL);
                final double lllllllllllllIllllIlllllIlllllII = (lllllllllllllIllllIlllllIlllllIl > 7) ? 0.9 : (1.0 - 0.11 * lllllllllllllIllllIlllllIlllllIl);
                final String lllllllllllllIllllIlllllIllllIll = (lllllllllllllIllllIlllllIllllllI.getBlock() == Blocks.FLOWING_WATER) ? "f" : "s";
                DebugRenderer.renderDebugText(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIllllIlllllIllllIll)).append(" ").append(lllllllllllllIllllIlllllIlllllIl)), lllllllllllllIllllIlllllIlllllll.getX() + 0.5, lllllllllllllIllllIlllllIlllllll.getY() + lllllllllllllIllllIlllllIlllllII, lllllllllllllIllllIlllllIlllllll.getZ() + 0.5, lllllllllllllIllllIllllllIIIIllI, -16777216);
            }
        }
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }
}
