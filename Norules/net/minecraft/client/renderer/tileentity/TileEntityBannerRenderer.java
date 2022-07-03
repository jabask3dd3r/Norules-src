package net.minecraft.client.renderer.tileentity;

import net.minecraft.client.model.*;
import net.minecraft.init.*;
import net.minecraft.util.math.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.*;
import javax.annotation.*;
import net.minecraft.tileentity.*;

public class TileEntityBannerRenderer extends TileEntitySpecialRenderer<TileEntityBanner>
{
    private final /* synthetic */ ModelBanner bannerModel;
    
    @Override
    public void func_192841_a(final TileEntityBanner lllllllllllllIlllIlIlIIlllllIIlI, final double lllllllllllllIlllIlIlIIlllIlllll, final double lllllllllllllIlllIlIlIIlllIllllI, final double lllllllllllllIlllIlIlIIllllIllll, final float lllllllllllllIlllIlIlIIllllIlllI, final int lllllllllllllIlllIlIlIIllllIllIl, final float lllllllllllllIlllIlIlIIllllIllII) {
        final boolean lllllllllllllIlllIlIlIIllllIlIll = lllllllllllllIlllIlIlIIlllllIIlI.getWorld() != null;
        final boolean lllllllllllllIlllIlIlIIllllIlIlI = !lllllllllllllIlllIlIlIIllllIlIll || lllllllllllllIlllIlIlIIlllllIIlI.getBlockType() == Blocks.STANDING_BANNER;
        final int lllllllllllllIlllIlIlIIllllIlIIl = lllllllllllllIlllIlIlIIllllIlIll ? lllllllllllllIlllIlIlIIlllllIIlI.getBlockMetadata() : 0;
        final long lllllllllllllIlllIlIlIIllllIlIII = lllllllllllllIlllIlIlIIllllIlIll ? lllllllllllllIlllIlIlIIlllllIIlI.getWorld().getTotalWorldTime() : 0L;
        GlStateManager.pushMatrix();
        final float lllllllllllllIlllIlIlIIllllIIlll = 0.6666667f;
        if (lllllllllllllIlllIlIlIIllllIlIlI) {
            GlStateManager.translate((float)lllllllllllllIlllIlIlIIlllIlllll + 0.5f, (float)lllllllllllllIlllIlIlIIlllIllllI + 0.5f, (float)lllllllllllllIlllIlIlIIllllIllll + 0.5f);
            final float lllllllllllllIlllIlIlIIllllIIllI = lllllllllllllIlllIlIlIIllllIlIIl * 360 / 16.0f;
            GlStateManager.rotate(-lllllllllllllIlllIlIlIIllllIIllI, 0.0f, 1.0f, 0.0f);
            this.bannerModel.bannerStand.showModel = true;
        }
        else {
            float lllllllllllllIlllIlIlIIllllIIlIl = 0.0f;
            if (lllllllllllllIlllIlIlIIllllIlIIl == 2) {
                lllllllllllllIlllIlIlIIllllIIlIl = 180.0f;
            }
            if (lllllllllllllIlllIlIlIIllllIlIIl == 4) {
                lllllllllllllIlllIlIlIIllllIIlIl = 90.0f;
            }
            if (lllllllllllllIlllIlIlIIllllIlIIl == 5) {
                lllllllllllllIlllIlIlIIllllIIlIl = -90.0f;
            }
            GlStateManager.translate((float)lllllllllllllIlllIlIlIIlllIlllll + 0.5f, (float)lllllllllllllIlllIlIlIIlllIllllI - 0.16666667f, (float)lllllllllllllIlllIlIlIIllllIllll + 0.5f);
            GlStateManager.rotate(-lllllllllllllIlllIlIlIIllllIIlIl, 0.0f, 1.0f, 0.0f);
            GlStateManager.translate(0.0f, -0.3125f, -0.4375f);
            this.bannerModel.bannerStand.showModel = false;
        }
        final BlockPos lllllllllllllIlllIlIlIIllllIIlII = lllllllllllllIlllIlIlIIlllllIIlI.getPos();
        final float lllllllllllllIlllIlIlIIllllIIIll = lllllllllllllIlllIlIlIIllllIIlII.getX() * 7 + lllllllllllllIlllIlIlIIllllIIlII.getY() * 9 + lllllllllllllIlllIlIlIIllllIIlII.getZ() * 13 + (float)lllllllllllllIlllIlIlIIllllIlIII + lllllllllllllIlllIlIlIIllllIlllI;
        this.bannerModel.bannerSlate.rotateAngleX = (-0.0125f + 0.01f * MathHelper.cos(lllllllllllllIlllIlIlIIllllIIIll * 3.1415927f * 0.02f)) * 3.1415927f;
        GlStateManager.enableRescaleNormal();
        final ResourceLocation lllllllllllllIlllIlIlIIllllIIIlI = this.getBannerResourceLocation(lllllllllllllIlllIlIlIIlllllIIlI);
        if (lllllllllllllIlllIlIlIIllllIIIlI != null) {
            this.bindTexture(lllllllllllllIlllIlIlIIllllIIIlI);
            GlStateManager.pushMatrix();
            GlStateManager.scale(0.6666667f, -0.6666667f, -0.6666667f);
            this.bannerModel.renderBanner();
            GlStateManager.popMatrix();
        }
        GlStateManager.color(1.0f, 1.0f, 1.0f, lllllllllllllIlllIlIlIIllllIllII);
        GlStateManager.popMatrix();
    }
    
    @Nullable
    private ResourceLocation getBannerResourceLocation(final TileEntityBanner lllllllllllllIlllIlIlIIlllIIllll) {
        return BannerTextures.BANNER_DESIGNS.getResourceLocation(lllllllllllllIlllIlIlIIlllIIllll.getPatternResourceLocation(), lllllllllllllIlllIlIlIIlllIIllll.getPatternList(), lllllllllllllIlllIlIlIIlllIIllll.getColorList());
    }
    
    public TileEntityBannerRenderer() {
        this.bannerModel = new ModelBanner();
    }
}
