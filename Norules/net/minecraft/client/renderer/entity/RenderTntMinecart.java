package net.minecraft.client.renderer.entity;

import net.minecraft.block.state.*;
import net.minecraft.util.math.*;
import net.minecraft.client.*;
import net.minecraft.init.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.item.*;

public class RenderTntMinecart extends RenderMinecart<EntityMinecartTNT>
{
    @Override
    protected void renderCartContents(final EntityMinecartTNT lllllllllllllIllIlIlIlIIlllIlIII, final float lllllllllllllIllIlIlIlIIlllIIlll, final IBlockState lllllllllllllIllIlIlIlIIllIllllI) {
        final int lllllllllllllIllIlIlIlIIlllIIlIl = lllllllllllllIllIlIlIlIIlllIlIII.getFuseTicks();
        if (lllllllllllllIllIlIlIlIIlllIIlIl > -1 && lllllllllllllIllIlIlIlIIlllIIlIl - lllllllllllllIllIlIlIlIIlllIIlll + 1.0f < 10.0f) {
            float lllllllllllllIllIlIlIlIIlllIIlII = 1.0f - (lllllllllllllIllIlIlIlIIlllIIlIl - lllllllllllllIllIlIlIlIIlllIIlll + 1.0f) / 10.0f;
            lllllllllllllIllIlIlIlIIlllIIlII = MathHelper.clamp(lllllllllllllIllIlIlIlIIlllIIlII, 0.0f, 1.0f);
            lllllllllllllIllIlIlIlIIlllIIlII *= lllllllllllllIllIlIlIlIIlllIIlII;
            lllllllllllllIllIlIlIlIIlllIIlII *= lllllllllllllIllIlIlIlIIlllIIlII;
            final float lllllllllllllIllIlIlIlIIlllIIIll = 1.0f + lllllllllllllIllIlIlIlIIlllIIlII * 0.3f;
            GlStateManager.scale(lllllllllllllIllIlIlIlIIlllIIIll, lllllllllllllIllIlIlIlIIlllIIIll, lllllllllllllIllIlIlIlIIlllIIIll);
        }
        super.renderCartContents(lllllllllllllIllIlIlIlIIlllIlIII, lllllllllllllIllIlIlIlIIlllIIlll, lllllllllllllIllIlIlIlIIllIllllI);
        if (lllllllllllllIllIlIlIlIIlllIIlIl > -1 && lllllllllllllIllIlIlIlIIlllIIlIl / 5 % 2 == 0) {
            final BlockRendererDispatcher lllllllllllllIllIlIlIlIIlllIIIlI = Minecraft.getMinecraft().getBlockRendererDispatcher();
            GlStateManager.disableTexture2D();
            GlStateManager.disableLighting();
            GlStateManager.enableBlend();
            GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.DST_ALPHA);
            GlStateManager.color(1.0f, 1.0f, 1.0f, (1.0f - (lllllllllllllIllIlIlIlIIlllIIlIl - lllllllllllllIllIlIlIlIIlllIIlll + 1.0f) / 100.0f) * 0.8f);
            GlStateManager.pushMatrix();
            lllllllllllllIllIlIlIlIIlllIIIlI.renderBlockBrightness(Blocks.TNT.getDefaultState(), 1.0f);
            GlStateManager.popMatrix();
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.disableBlend();
            GlStateManager.enableLighting();
            GlStateManager.enableTexture2D();
        }
    }
    
    public RenderTntMinecart(final RenderManager lllllllllllllIllIlIlIlIIllllIIll) {
        super(lllllllllllllIllIlIlIlIIllllIIll);
    }
}
