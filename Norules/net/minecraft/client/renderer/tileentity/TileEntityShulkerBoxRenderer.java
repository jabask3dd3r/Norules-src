package net.minecraft.client.renderer.tileentity;

import net.minecraft.client.model.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.*;
import net.minecraft.block.*;
import net.minecraft.block.properties.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.block.state.*;

public class TileEntityShulkerBoxRenderer extends TileEntitySpecialRenderer<TileEntityShulkerBox>
{
    private final /* synthetic */ ModelShulker field_191285_a;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing;
    
    @Override
    public void func_192841_a(final TileEntityShulkerBox lllllllllllllIlIIIlIIIIlIIlIllIl, final double lllllllllllllIlIIIlIIIIlIIlIIIIl, final double lllllllllllllIlIIIlIIIIlIIlIlIll, final double lllllllllllllIlIIIlIIIIlIIIlllll, final float lllllllllllllIlIIIlIIIIlIIlIlIIl, final int lllllllllllllIlIIIlIIIIlIIlIlIII, final float lllllllllllllIlIIIlIIIIlIIlIIlll) {
        EnumFacing lllllllllllllIlIIIlIIIIlIIlIIllI = EnumFacing.UP;
        if (lllllllllllllIlIIIlIIIIlIIlIllIl.hasWorldObj()) {
            final IBlockState lllllllllllllIlIIIlIIIIlIIlIIlIl = this.getWorld().getBlockState(lllllllllllllIlIIIlIIIIlIIlIllIl.getPos());
            if (lllllllllllllIlIIIlIIIIlIIlIIlIl.getBlock() instanceof BlockShulkerBox) {
                lllllllllllllIlIIIlIIIIlIIlIIllI = lllllllllllllIlIIIlIIIIlIIlIIlIl.getValue(BlockShulkerBox.field_190957_a);
            }
        }
        GlStateManager.enableDepth();
        GlStateManager.depthFunc(515);
        GlStateManager.depthMask(true);
        GlStateManager.disableCull();
        if (lllllllllllllIlIIIlIIIIlIIlIlIII >= 0) {
            this.bindTexture(TileEntityShulkerBoxRenderer.DESTROY_STAGES[lllllllllllllIlIIIlIIIIlIIlIlIII]);
            GlStateManager.matrixMode(5890);
            GlStateManager.pushMatrix();
            GlStateManager.scale(4.0f, 4.0f, 1.0f);
            GlStateManager.translate(0.0625f, 0.0625f, 0.0625f);
            GlStateManager.matrixMode(5888);
        }
        else {
            this.bindTexture(RenderShulker.SHULKER_ENDERGOLEM_TEXTURE[lllllllllllllIlIIIlIIIIlIIlIllIl.func_190592_s().getMetadata()]);
        }
        GlStateManager.pushMatrix();
        GlStateManager.enableRescaleNormal();
        if (lllllllllllllIlIIIlIIIIlIIlIlIII < 0) {
            GlStateManager.color(1.0f, 1.0f, 1.0f, lllllllllllllIlIIIlIIIIlIIlIIlll);
        }
        GlStateManager.translate((float)lllllllllllllIlIIIlIIIIlIIlIIIIl + 0.5f, (float)lllllllllllllIlIIIlIIIIlIIlIlIll + 1.5f, (float)lllllllllllllIlIIIlIIIIlIIIlllll + 0.5f);
        GlStateManager.scale(1.0f, -1.0f, -1.0f);
        GlStateManager.translate(0.0f, 1.0f, 0.0f);
        final float lllllllllllllIlIIIlIIIIlIIlIIlII = 0.9995f;
        GlStateManager.scale(0.9995f, 0.9995f, 0.9995f);
        GlStateManager.translate(0.0f, -1.0f, 0.0f);
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllllIlIIIlIIIIlIIlIIllI.ordinal()]) {
            case 1: {
                GlStateManager.translate(0.0f, 2.0f, 0.0f);
                GlStateManager.rotate(180.0f, 1.0f, 0.0f, 0.0f);
                break;
            }
            case 3: {
                GlStateManager.translate(0.0f, 1.0f, 1.0f);
                GlStateManager.rotate(90.0f, 1.0f, 0.0f, 0.0f);
                GlStateManager.rotate(180.0f, 0.0f, 0.0f, 1.0f);
                break;
            }
            case 4: {
                GlStateManager.translate(0.0f, 1.0f, -1.0f);
                GlStateManager.rotate(90.0f, 1.0f, 0.0f, 0.0f);
                break;
            }
            case 5: {
                GlStateManager.translate(-1.0f, 1.0f, 0.0f);
                GlStateManager.rotate(90.0f, 1.0f, 0.0f, 0.0f);
                GlStateManager.rotate(-90.0f, 0.0f, 0.0f, 1.0f);
                break;
            }
            case 6: {
                GlStateManager.translate(1.0f, 1.0f, 0.0f);
                GlStateManager.rotate(90.0f, 1.0f, 0.0f, 0.0f);
                GlStateManager.rotate(90.0f, 0.0f, 0.0f, 1.0f);
                break;
            }
        }
        this.field_191285_a.base.render(0.0625f);
        GlStateManager.translate(0.0f, -lllllllllllllIlIIIlIIIIlIIlIllIl.func_190585_a(lllllllllllllIlIIIlIIIIlIIlIlIIl) * 0.5f, 0.0f);
        GlStateManager.rotate(270.0f * lllllllllllllIlIIIlIIIIlIIlIllIl.func_190585_a(lllllllllllllIlIIIlIIIIlIIlIlIIl), 0.0f, 1.0f, 0.0f);
        this.field_191285_a.lid.render(0.0625f);
        GlStateManager.enableCull();
        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        if (lllllllllllllIlIIIlIIIIlIIlIlIII >= 0) {
            GlStateManager.matrixMode(5890);
            GlStateManager.popMatrix();
            GlStateManager.matrixMode(5888);
        }
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing = TileEntityShulkerBoxRenderer.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
        if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing;
        }
        final float lllllllllllllIlIIIlIIIIlIIIIlIII = (Object)new int[EnumFacing.values().length];
        try {
            lllllllllllllIlIIIlIIIIlIIIIlIII[EnumFacing.DOWN.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIlIIIlIIIIlIIIIlIII[EnumFacing.EAST.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIlIIIlIIIIlIIIIlIII[EnumFacing.NORTH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllIlIIIlIIIIlIIIIlIII[EnumFacing.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllllIlIIIlIIIIlIIIIlIII[EnumFacing.UP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllllIlIIIlIIIIlIIIIlIII[EnumFacing.WEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return TileEntityShulkerBoxRenderer.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)lllllllllllllIlIIIlIIIIlIIIIlIII;
    }
    
    public TileEntityShulkerBoxRenderer(final ModelShulker lllllllllllllIlIIIlIIIIlIIlllIIl) {
        this.field_191285_a = lllllllllllllIlIIIlIIIIlIIlllIIl;
    }
}
