package net.minecraft.client.renderer.entity.layers;

import net.minecraft.entity.monster.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.*;
import net.minecraft.block.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.client.renderer.block.model.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;

public class LayerHeldItemWitch implements LayerRenderer<EntityWitch>
{
    private final /* synthetic */ RenderWitch witchRenderer;
    
    @Override
    public void doRenderLayer(final EntityWitch lllIIlIIllIl, final float lllIIlIIllII, final float lllIIlIIlIll, final float lllIIlIIlIlI, final float lllIIlIIlIIl, final float lllIIlIIlIII, final float lllIIlIIIlll, final float lllIIlIIIllI) {
        final ItemStack lllIIlIIIlIl = lllIIlIIllIl.getHeldItemMainhand();
        if (!lllIIlIIIlIl.func_190926_b()) {
            GlStateManager.color(1.0f, 1.0f, 1.0f);
            GlStateManager.pushMatrix();
            if (this.witchRenderer.getMainModel().isChild) {
                GlStateManager.translate(0.0f, 0.625f, 0.0f);
                GlStateManager.rotate(-20.0f, -1.0f, 0.0f, 0.0f);
                final float lllIIlIIIlII = 0.5f;
                GlStateManager.scale(0.5f, 0.5f, 0.5f);
            }
            this.witchRenderer.getMainModel().villagerNose.postRender(0.0625f);
            GlStateManager.translate(-0.0625f, 0.53125f, 0.21875f);
            final Item lllIIlIIIIll = lllIIlIIIlIl.getItem();
            final Minecraft lllIIlIIIIlI = Minecraft.getMinecraft();
            if (Block.getBlockFromItem(lllIIlIIIIll).getDefaultState().getRenderType() == EnumBlockRenderType.ENTITYBLOCK_ANIMATED) {
                GlStateManager.translate(0.0f, 0.0625f, -0.25f);
                GlStateManager.rotate(30.0f, 1.0f, 0.0f, 0.0f);
                GlStateManager.rotate(-5.0f, 0.0f, 1.0f, 0.0f);
                final float lllIIlIIIIIl = 0.375f;
                GlStateManager.scale(0.375f, -0.375f, 0.375f);
            }
            else if (lllIIlIIIIll == Items.BOW) {
                GlStateManager.translate(0.0f, 0.125f, -0.125f);
                GlStateManager.rotate(-45.0f, 0.0f, 1.0f, 0.0f);
                final float lllIIlIIIIII = 0.625f;
                GlStateManager.scale(0.625f, -0.625f, 0.625f);
                GlStateManager.rotate(-100.0f, 1.0f, 0.0f, 0.0f);
                GlStateManager.rotate(-20.0f, 0.0f, 1.0f, 0.0f);
            }
            else if (lllIIlIIIIll.isFull3D()) {
                if (lllIIlIIIIll.shouldRotateAroundWhenRendering()) {
                    GlStateManager.rotate(180.0f, 0.0f, 0.0f, 1.0f);
                    GlStateManager.translate(0.0f, -0.0625f, 0.0f);
                }
                this.witchRenderer.transformHeldFull3DItemLayer();
                GlStateManager.translate(0.0625f, -0.125f, 0.0f);
                final float lllIIIllllll = 0.625f;
                GlStateManager.scale(0.625f, -0.625f, 0.625f);
                GlStateManager.rotate(0.0f, 1.0f, 0.0f, 0.0f);
                GlStateManager.rotate(0.0f, 0.0f, 1.0f, 0.0f);
            }
            else {
                GlStateManager.translate(0.1875f, 0.1875f, 0.0f);
                final float lllIIIlllllI = 0.875f;
                GlStateManager.scale(0.875f, 0.875f, 0.875f);
                GlStateManager.rotate(-20.0f, 0.0f, 0.0f, 1.0f);
                GlStateManager.rotate(-60.0f, 1.0f, 0.0f, 0.0f);
                GlStateManager.rotate(-30.0f, 0.0f, 0.0f, 1.0f);
            }
            GlStateManager.rotate(-15.0f, 1.0f, 0.0f, 0.0f);
            GlStateManager.rotate(40.0f, 0.0f, 0.0f, 1.0f);
            lllIIlIIIIlI.getItemRenderer().renderItem(lllIIlIIllIl, lllIIlIIIlIl, ItemCameraTransforms.TransformType.THIRD_PERSON_RIGHT_HAND);
            GlStateManager.popMatrix();
        }
    }
    
    public LayerHeldItemWitch(final RenderWitch lllIIlIlIlIl) {
        this.witchRenderer = lllIIlIlIlIl;
    }
    
    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
}
