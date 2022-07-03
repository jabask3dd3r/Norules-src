package net.minecraft.client.renderer.tileentity;

import net.minecraft.client.model.*;
import net.minecraft.item.*;
import net.minecraft.tileentity.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.*;

public class TileEntityBedRenderer extends TileEntitySpecialRenderer<TileEntityBed>
{
    private /* synthetic */ int field_193850_e;
    private static final /* synthetic */ ResourceLocation[] field_193848_a;
    private /* synthetic */ ModelBed field_193849_d;
    
    static {
        final EnumDyeColor[] lllllllllllllIlIIIIIllIlIlIIlIll = EnumDyeColor.values();
        field_193848_a = new ResourceLocation[lllllllllllllIlIIIIIllIlIlIIlIll.length];
        final int lllllllllllllIlIIIIIllIlIlIIIlIl;
        final Exception lllllllllllllIlIIIIIllIlIlIIIllI = (Exception)((EnumDyeColor[])(Object)(lllllllllllllIlIIIIIllIlIlIIIlIl = (int)(Object)lllllllllllllIlIIIIIllIlIlIIlIll)).length;
        for (boolean lllllllllllllIlIIIIIllIlIlIIIlll = false; lllllllllllllIlIIIIIllIlIlIIIlll < lllllllllllllIlIIIIIllIlIlIIIllI; ++lllllllllllllIlIIIIIllIlIlIIIlll) {
            final EnumDyeColor lllllllllllllIlIIIIIllIlIlIIlIlI = lllllllllllllIlIIIIIllIlIlIIIlIl[lllllllllllllIlIIIIIllIlIlIIIlll];
            TileEntityBedRenderer.field_193848_a[lllllllllllllIlIIIIIllIlIlIIlIlI.getMetadata()] = new ResourceLocation(String.valueOf(new StringBuilder("textures/entity/bed/").append(lllllllllllllIlIIIIIllIlIlIIlIlI.func_192396_c()).append(".png")));
        }
    }
    
    public TileEntityBedRenderer() {
        this.field_193849_d = new ModelBed();
        this.field_193850_e = this.field_193849_d.func_193770_a();
    }
    
    @Override
    public void func_192841_a(final TileEntityBed lllllllllllllIlIIIIIllIlIIllIlII, final double lllllllllllllIlIIIIIllIlIIlIIllI, final double lllllllllllllIlIIIIIllIlIIllIIlI, final double lllllllllllllIlIIIIIllIlIIllIIIl, final float lllllllllllllIlIIIIIllIlIIllIIII, final int lllllllllllllIlIIIIIllIlIIlIllll, final float lllllllllllllIlIIIIIllIlIIlIlllI) {
        if (this.field_193850_e != this.field_193849_d.func_193770_a()) {
            this.field_193849_d = new ModelBed();
            this.field_193850_e = this.field_193849_d.func_193770_a();
        }
        final boolean lllllllllllllIlIIIIIllIlIIlIllIl = lllllllllllllIlIIIIIllIlIIllIlII.getWorld() != null;
        final boolean lllllllllllllIlIIIIIllIlIIlIllII = !lllllllllllllIlIIIIIllIlIIlIllIl || lllllllllllllIlIIIIIllIlIIllIlII.func_193050_e();
        final EnumDyeColor lllllllllllllIlIIIIIllIlIIlIlIll = (lllllllllllllIlIIIIIllIlIIllIlII != null) ? lllllllllllllIlIIIIIllIlIIllIlII.func_193048_a() : EnumDyeColor.RED;
        final int lllllllllllllIlIIIIIllIlIIlIlIlI = lllllllllllllIlIIIIIllIlIIlIllIl ? (lllllllllllllIlIIIIIllIlIIllIlII.getBlockMetadata() & 0x3) : 0;
        if (lllllllllllllIlIIIIIllIlIIlIllll >= 0) {
            this.bindTexture(TileEntityBedRenderer.DESTROY_STAGES[lllllllllllllIlIIIIIllIlIIlIllll]);
            GlStateManager.matrixMode(5890);
            GlStateManager.pushMatrix();
            GlStateManager.scale(4.0f, 4.0f, 1.0f);
            GlStateManager.translate(0.0625f, 0.0625f, 0.0625f);
            GlStateManager.matrixMode(5888);
        }
        else {
            final ResourceLocation lllllllllllllIlIIIIIllIlIIlIlIIl = TileEntityBedRenderer.field_193848_a[lllllllllllllIlIIIIIllIlIIlIlIll.getMetadata()];
            if (lllllllllllllIlIIIIIllIlIIlIlIIl != null) {
                this.bindTexture(lllllllllllllIlIIIIIllIlIIlIlIIl);
            }
        }
        if (lllllllllllllIlIIIIIllIlIIlIllIl) {
            this.func_193847_a(lllllllllllllIlIIIIIllIlIIlIllII, lllllllllllllIlIIIIIllIlIIlIIllI, lllllllllllllIlIIIIIllIlIIllIIlI, lllllllllllllIlIIIIIllIlIIllIIIl, lllllllllllllIlIIIIIllIlIIlIlIlI, lllllllllllllIlIIIIIllIlIIlIlllI);
        }
        else {
            GlStateManager.pushMatrix();
            this.func_193847_a(true, lllllllllllllIlIIIIIllIlIIlIIllI, lllllllllllllIlIIIIIllIlIIllIIlI, lllllllllllllIlIIIIIllIlIIllIIIl, lllllllllllllIlIIIIIllIlIIlIlIlI, lllllllllllllIlIIIIIllIlIIlIlllI);
            this.func_193847_a(false, lllllllllllllIlIIIIIllIlIIlIIllI, lllllllllllllIlIIIIIllIlIIllIIlI, lllllllllllllIlIIIIIllIlIIllIIIl - 1.0, lllllllllllllIlIIIIIllIlIIlIlIlI, lllllllllllllIlIIIIIllIlIIlIlllI);
            GlStateManager.popMatrix();
        }
        if (lllllllllllllIlIIIIIllIlIIlIllll >= 0) {
            GlStateManager.matrixMode(5890);
            GlStateManager.popMatrix();
            GlStateManager.matrixMode(5888);
        }
    }
    
    private void func_193847_a(final boolean lllllllllllllIlIIIIIllIlIIIlIIIl, final double lllllllllllllIlIIIIIllIlIIIlIIII, final double lllllllllllllIlIIIIIllIlIIIIIlIl, final double lllllllllllllIlIIIIIllIlIIIIIlII, final int lllllllllllllIlIIIIIllIlIIIIIIll, final float lllllllllllllIlIIIIIllIlIIIIIIlI) {
        this.field_193849_d.func_193769_a(lllllllllllllIlIIIIIllIlIIIlIIIl);
        GlStateManager.pushMatrix();
        float lllllllllllllIlIIIIIllIlIIIIlIll = 0.0f;
        float lllllllllllllIlIIIIIllIlIIIIlIlI = 0.0f;
        float lllllllllllllIlIIIIIllIlIIIIlIIl = 0.0f;
        if (lllllllllllllIlIIIIIllIlIIIIIIll == EnumFacing.NORTH.getHorizontalIndex()) {
            lllllllllllllIlIIIIIllIlIIIIlIll = 0.0f;
        }
        else if (lllllllllllllIlIIIIIllIlIIIIIIll == EnumFacing.SOUTH.getHorizontalIndex()) {
            lllllllllllllIlIIIIIllIlIIIIlIll = 180.0f;
            lllllllllllllIlIIIIIllIlIIIIlIlI = 1.0f;
            lllllllllllllIlIIIIIllIlIIIIlIIl = 1.0f;
        }
        else if (lllllllllllllIlIIIIIllIlIIIIIIll == EnumFacing.WEST.getHorizontalIndex()) {
            lllllllllllllIlIIIIIllIlIIIIlIll = -90.0f;
            lllllllllllllIlIIIIIllIlIIIIlIIl = 1.0f;
        }
        else if (lllllllllllllIlIIIIIllIlIIIIIIll == EnumFacing.EAST.getHorizontalIndex()) {
            lllllllllllllIlIIIIIllIlIIIIlIll = 90.0f;
            lllllllllllllIlIIIIIllIlIIIIlIlI = 1.0f;
        }
        GlStateManager.translate((float)lllllllllllllIlIIIIIllIlIIIlIIII + lllllllllllllIlIIIIIllIlIIIIlIlI, (float)lllllllllllllIlIIIIIllIlIIIIIlIl + 0.5625f, (float)lllllllllllllIlIIIIIllIlIIIIIlII + lllllllllllllIlIIIIIllIlIIIIlIIl);
        GlStateManager.rotate(90.0f, 1.0f, 0.0f, 0.0f);
        GlStateManager.rotate(lllllllllllllIlIIIIIllIlIIIIlIll, 0.0f, 0.0f, 1.0f);
        GlStateManager.enableRescaleNormal();
        GlStateManager.pushMatrix();
        this.field_193849_d.func_193771_b();
        GlStateManager.popMatrix();
        GlStateManager.color(1.0f, 1.0f, 1.0f, lllllllllllllIlIIIIIllIlIIIIIIlI);
        GlStateManager.popMatrix();
    }
}
