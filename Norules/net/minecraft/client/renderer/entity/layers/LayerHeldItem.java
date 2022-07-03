package net.minecraft.client.renderer.entity.layers;

import net.minecraft.entity.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import net.minecraft.client.model.*;
import net.minecraft.item.*;
import net.minecraft.client.renderer.block.model.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.*;

public class LayerHeldItem implements LayerRenderer<EntityLivingBase>
{
    protected final /* synthetic */ RenderLivingBase<?> livingEntityRenderer;
    
    protected void func_191361_a(final EnumHandSide lllllllllllllIllIlIllllIlIlIllIl) {
        ((ModelBiped)this.livingEntityRenderer.getMainModel()).postRenderArm(0.0625f, lllllllllllllIllIlIllllIlIlIllIl);
    }
    
    public LayerHeldItem(final RenderLivingBase<?> lllllllllllllIllIlIllllIlllIIIII) {
        this.livingEntityRenderer = lllllllllllllIllIlIllllIlllIIIII;
    }
    
    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
    
    private void renderHeldItem(final EntityLivingBase lllllllllllllIllIlIllllIlIllllIl, final ItemStack lllllllllllllIllIlIllllIlIllIllI, final ItemCameraTransforms.TransformType lllllllllllllIllIlIllllIlIllIlIl, final EnumHandSide lllllllllllllIllIlIllllIlIllIlII) {
        if (!lllllllllllllIllIlIllllIlIllIllI.func_190926_b()) {
            GlStateManager.pushMatrix();
            this.func_191361_a(lllllllllllllIllIlIllllIlIllIlII);
            if (lllllllllllllIllIlIllllIlIllllIl.isSneaking()) {
                GlStateManager.translate(0.0f, 0.2f, 0.0f);
            }
            GlStateManager.rotate(-90.0f, 1.0f, 0.0f, 0.0f);
            GlStateManager.rotate(180.0f, 0.0f, 1.0f, 0.0f);
            final boolean lllllllllllllIllIlIllllIlIlllIIl = lllllllllllllIllIlIllllIlIllIlII == EnumHandSide.LEFT;
            GlStateManager.translate((lllllllllllllIllIlIllllIlIlllIIl ? -1 : 1) / 16.0f, 0.125f, -0.625f);
            Minecraft.getMinecraft().getItemRenderer().renderItemSide(lllllllllllllIllIlIllllIlIllllIl, lllllllllllllIllIlIllllIlIllIllI, lllllllllllllIllIlIllllIlIllIlIl, lllllllllllllIllIlIllllIlIlllIIl);
            GlStateManager.popMatrix();
        }
    }
    
    @Override
    public void doRenderLayer(final EntityLivingBase lllllllllllllIllIlIllllIllIlIllI, final float lllllllllllllIllIlIllllIllIlIlIl, final float lllllllllllllIllIlIllllIllIlIlII, final float lllllllllllllIllIlIllllIllIlIIll, final float lllllllllllllIllIlIllllIllIlIIlI, final float lllllllllllllIllIlIllllIllIlIIIl, final float lllllllllllllIllIlIllllIllIlIIII, final float lllllllllllllIllIlIllllIllIIllll) {
        final boolean lllllllllllllIllIlIllllIllIIlllI = lllllllllllllIllIlIllllIllIlIllI.getPrimaryHand() == EnumHandSide.RIGHT;
        final ItemStack lllllllllllllIllIlIllllIllIIllIl = lllllllllllllIllIlIllllIllIIlllI ? lllllllllllllIllIlIllllIllIlIllI.getHeldItemOffhand() : lllllllllllllIllIlIllllIllIlIllI.getHeldItemMainhand();
        final ItemStack lllllllllllllIllIlIllllIllIIllII = lllllllllllllIllIlIllllIllIIlllI ? lllllllllllllIllIlIllllIllIlIllI.getHeldItemMainhand() : lllllllllllllIllIlIllllIllIlIllI.getHeldItemOffhand();
        if (!lllllllllllllIllIlIllllIllIIllIl.func_190926_b() || !lllllllllllllIllIlIllllIllIIllII.func_190926_b()) {
            GlStateManager.pushMatrix();
            if (this.livingEntityRenderer.getMainModel().isChild) {
                final float lllllllllllllIllIlIllllIllIIlIll = 0.5f;
                GlStateManager.translate(0.0f, 0.75f, 0.0f);
                GlStateManager.scale(0.5f, 0.5f, 0.5f);
            }
            this.renderHeldItem(lllllllllllllIllIlIllllIllIlIllI, lllllllllllllIllIlIllllIllIIllII, ItemCameraTransforms.TransformType.THIRD_PERSON_RIGHT_HAND, EnumHandSide.RIGHT);
            this.renderHeldItem(lllllllllllllIllIlIllllIllIlIllI, lllllllllllllIllIlIllllIllIIllIl, ItemCameraTransforms.TransformType.THIRD_PERSON_LEFT_HAND, EnumHandSide.LEFT);
            GlStateManager.popMatrix();
        }
    }
}
