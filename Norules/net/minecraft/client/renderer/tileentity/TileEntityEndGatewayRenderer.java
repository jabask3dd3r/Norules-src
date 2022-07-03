package net.minecraft.client.renderer.tileentity;

import net.minecraft.util.*;
import net.minecraft.client.renderer.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.math.*;
import net.minecraft.item.*;

public class TileEntityEndGatewayRenderer extends TileEntityEndPortalRenderer
{
    private static final /* synthetic */ ResourceLocation END_GATEWAY_BEAM_TEXTURE;
    
    static {
        END_GATEWAY_BEAM_TEXTURE = new ResourceLocation("textures/entity/end_gateway_beam.png");
    }
    
    @Override
    public void func_192841_a(final TileEntityEndPortal lllllllllllllIIIlIlIlIlllIllIIIl, final double lllllllllllllIIIlIlIlIlllIllIIII, final double lllllllllllllIIIlIlIlIlllIllllII, final double lllllllllllllIIIlIlIlIlllIlllIll, final float lllllllllllllIIIlIlIlIlllIlllIlI, final int lllllllllllllIIIlIlIlIlllIlllIIl, final float lllllllllllllIIIlIlIlIlllIlIlIll) {
        GlStateManager.disableFog();
        final TileEntityEndGateway lllllllllllllIIIlIlIlIlllIllIlll = (TileEntityEndGateway)lllllllllllllIIIlIlIlIlllIllIIIl;
        if (lllllllllllllIIIlIlIlIlllIllIlll.isSpawning() || lllllllllllllIIIlIlIlIlllIllIlll.isCoolingDown()) {
            GlStateManager.alphaFunc(516, 0.1f);
            this.bindTexture(TileEntityEndGatewayRenderer.END_GATEWAY_BEAM_TEXTURE);
            float lllllllllllllIIIlIlIlIlllIllIllI = lllllllllllllIIIlIlIlIlllIllIlll.isSpawning() ? lllllllllllllIIIlIlIlIlllIllIlll.getSpawnPercent(lllllllllllllIIIlIlIlIlllIlllIlI) : lllllllllllllIIIlIlIlIlllIllIlll.getCooldownPercent(lllllllllllllIIIlIlIlIlllIlllIlI);
            final double lllllllllllllIIIlIlIlIlllIllIlIl = lllllllllllllIIIlIlIlIlllIllIlll.isSpawning() ? (256.0 - lllllllllllllIIIlIlIlIlllIllllII) : 50.0;
            lllllllllllllIIIlIlIlIlllIllIllI = MathHelper.sin(lllllllllllllIIIlIlIlIlllIllIllI * 3.1415927f);
            final int lllllllllllllIIIlIlIlIlllIllIlII = MathHelper.floor(lllllllllllllIIIlIlIlIlllIllIllI * lllllllllllllIIIlIlIlIlllIllIlIl);
            final float[] lllllllllllllIIIlIlIlIlllIllIIll = lllllllllllllIIIlIlIlIlllIllIlll.isSpawning() ? EnumDyeColor.MAGENTA.func_193349_f() : EnumDyeColor.PURPLE.func_193349_f();
            TileEntityBeaconRenderer.renderBeamSegment(lllllllllllllIIIlIlIlIlllIllIIII, lllllllllllllIIIlIlIlIlllIllllII, lllllllllllllIIIlIlIlIlllIlllIll, lllllllllllllIIIlIlIlIlllIlllIlI, lllllllllllllIIIlIlIlIlllIllIllI, (double)lllllllllllllIIIlIlIlIlllIllIlll.getWorld().getTotalWorldTime(), 0, lllllllllllllIIIlIlIlIlllIllIlII, lllllllllllllIIIlIlIlIlllIllIIll, 0.15, 0.175);
            TileEntityBeaconRenderer.renderBeamSegment(lllllllllllllIIIlIlIlIlllIllIIII, lllllllllllllIIIlIlIlIlllIllllII, lllllllllllllIIIlIlIlIlllIlllIll, lllllllllllllIIIlIlIlIlllIlllIlI, lllllllllllllIIIlIlIlIlllIllIllI, (double)lllllllllllllIIIlIlIlIlllIllIlll.getWorld().getTotalWorldTime(), 0, -lllllllllllllIIIlIlIlIlllIllIlII, lllllllllllllIIIlIlIlIlllIllIIll, 0.15, 0.175);
        }
        super.func_192841_a(lllllllllllllIIIlIlIlIlllIllIIIl, lllllllllllllIIIlIlIlIlllIllIIII, lllllllllllllIIIlIlIlIlllIllllII, lllllllllllllIIIlIlIlIlllIlllIll, lllllllllllllIIIlIlIlIlllIlllIlI, lllllllllllllIIIlIlIlIlllIlllIIl, lllllllllllllIIIlIlIlIlllIlIlIll);
        GlStateManager.enableFog();
    }
    
    @Override
    protected int func_191286_a(final double lllllllllllllIIIlIlIlIlllIlIIIII) {
        return super.func_191286_a(lllllllllllllIIIlIlIlIlllIlIIIII) + 1;
    }
    
    @Override
    protected float func_191287_c() {
        return 1.0f;
    }
}
