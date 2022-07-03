package net.minecraft.client.renderer.entity;

import net.minecraft.entity.item.*;
import net.minecraft.client.*;
import net.minecraft.util.math.*;
import net.minecraft.init.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.entity.*;

public class RenderTNTPrimed extends Render<EntityTNTPrimed>
{
    @Override
    public void doRender(final EntityTNTPrimed lllllllllllllllllIlIIIlllllIIlII, final double lllllllllllllllllIlIIIlllllIIIll, final double lllllllllllllllllIlIIIlllllIIIlI, final double lllllllllllllllllIlIIIlllllIllII, final float lllllllllllllllllIlIIIlllllIIIII, final float lllllllllllllllllIlIIIllllIlllll) {
        final BlockRendererDispatcher lllllllllllllllllIlIIIlllllIlIIl = Minecraft.getMinecraft().getBlockRendererDispatcher();
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)lllllllllllllllllIlIIIlllllIIIll, (float)lllllllllllllllllIlIIIlllllIIIlI + 0.5f, (float)lllllllllllllllllIlIIIlllllIllII);
        if (lllllllllllllllllIlIIIlllllIIlII.getFuse() - lllllllllllllllllIlIIIllllIlllll + 1.0f < 10.0f) {
            float lllllllllllllllllIlIIIlllllIlIII = 1.0f - (lllllllllllllllllIlIIIlllllIIlII.getFuse() - lllllllllllllllllIlIIIllllIlllll + 1.0f) / 10.0f;
            lllllllllllllllllIlIIIlllllIlIII = MathHelper.clamp(lllllllllllllllllIlIIIlllllIlIII, 0.0f, 1.0f);
            lllllllllllllllllIlIIIlllllIlIII *= lllllllllllllllllIlIIIlllllIlIII;
            lllllllllllllllllIlIIIlllllIlIII *= lllllllllllllllllIlIIIlllllIlIII;
            final float lllllllllllllllllIlIIIlllllIIlll = 1.0f + lllllllllllllllllIlIIIlllllIlIII * 0.3f;
            GlStateManager.scale(lllllllllllllllllIlIIIlllllIIlll, lllllllllllllllllIlIIIlllllIIlll, lllllllllllllllllIlIIIlllllIIlll);
        }
        final float lllllllllllllllllIlIIIlllllIIllI = (1.0f - (lllllllllllllllllIlIIIlllllIIlII.getFuse() - lllllllllllllllllIlIIIllllIlllll + 1.0f) / 100.0f) * 0.8f;
        this.bindEntityTexture(lllllllllllllllllIlIIIlllllIIlII);
        GlStateManager.rotate(-90.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.translate(-0.5f, -0.5f, 0.5f);
        lllllllllllllllllIlIIIlllllIlIIl.renderBlockBrightness(Blocks.TNT.getDefaultState(), lllllllllllllllllIlIIIlllllIIlII.getBrightness());
        GlStateManager.translate(0.0f, 0.0f, 1.0f);
        if (this.renderOutlines) {
            GlStateManager.enableColorMaterial();
            GlStateManager.enableOutlineMode(this.getTeamColor(lllllllllllllllllIlIIIlllllIIlII));
            lllllllllllllllllIlIIIlllllIlIIl.renderBlockBrightness(Blocks.TNT.getDefaultState(), 1.0f);
            GlStateManager.disableOutlineMode();
            GlStateManager.disableColorMaterial();
        }
        else if (lllllllllllllllllIlIIIlllllIIlII.getFuse() / 5 % 2 == 0) {
            GlStateManager.disableTexture2D();
            GlStateManager.disableLighting();
            GlStateManager.enableBlend();
            GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.DST_ALPHA);
            GlStateManager.color(1.0f, 1.0f, 1.0f, lllllllllllllllllIlIIIlllllIIllI);
            GlStateManager.doPolygonOffset(-3.0f, -3.0f);
            GlStateManager.enablePolygonOffset();
            lllllllllllllllllIlIIIlllllIlIIl.renderBlockBrightness(Blocks.TNT.getDefaultState(), 1.0f);
            GlStateManager.doPolygonOffset(0.0f, 0.0f);
            GlStateManager.disablePolygonOffset();
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.disableBlend();
            GlStateManager.enableLighting();
            GlStateManager.enableTexture2D();
        }
        GlStateManager.popMatrix();
        super.doRender(lllllllllllllllllIlIIIlllllIIlII, lllllllllllllllllIlIIIlllllIIIll, lllllllllllllllllIlIIIlllllIIIlI, lllllllllllllllllIlIIIlllllIllII, lllllllllllllllllIlIIIlllllIIIII, lllllllllllllllllIlIIIllllIlllll);
    }
    
    public RenderTNTPrimed(final RenderManager lllllllllllllllllIlIIIlllllllIll) {
        super(lllllllllllllllllIlIIIlllllllIll);
        this.shadowSize = 0.5f;
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityTNTPrimed lllllllllllllllllIlIIIllllIllIlI) {
        return TextureMap.LOCATION_BLOCKS_TEXTURE;
    }
}
