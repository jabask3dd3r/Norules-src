package net.minecraft.client.renderer.entity.layers;

import net.minecraft.entity.monster.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.client.renderer.block.model.*;
import net.minecraft.entity.*;

public class LayerSnowmanHead implements LayerRenderer<EntitySnowman>
{
    private final /* synthetic */ RenderSnowMan snowManRenderer;
    
    public LayerSnowmanHead(final RenderSnowMan llllllllllllllIIIIIllIlIlIIllIlI) {
        this.snowManRenderer = llllllllllllllIIIIIllIlIlIIllIlI;
    }
    
    @Override
    public void doRenderLayer(final EntitySnowman llllllllllllllIIIIIllIlIlIIIlIll, final float llllllllllllllIIIIIllIlIlIIIlIIl, final float llllllllllllllIIIIIllIlIlIIIIlll, final float llllllllllllllIIIIIllIlIlIIIIlIl, final float llllllllllllllIIIIIllIlIlIIIIIll, final float llllllllllllllIIIIIllIlIlIIIIIlI, final float llllllllllllllIIIIIllIlIlIIIIIIl, final float llllllllllllllIIIIIllIlIIlllllll) {
        if (!llllllllllllllIIIIIllIlIlIIIlIll.isInvisible() && llllllllllllllIIIIIllIlIlIIIlIll.isPumpkinEquipped()) {
            GlStateManager.pushMatrix();
            this.snowManRenderer.getMainModel().head.postRender(0.0625f);
            final float llllllllllllllIIIIIllIlIIlllllIl = 0.625f;
            GlStateManager.translate(0.0f, -0.34375f, 0.0f);
            GlStateManager.rotate(180.0f, 0.0f, 1.0f, 0.0f);
            GlStateManager.scale(0.625f, -0.625f, -0.625f);
            Minecraft.getMinecraft().getItemRenderer().renderItem(llllllllllllllIIIIIllIlIlIIIlIll, new ItemStack(Blocks.PUMPKIN, 1), ItemCameraTransforms.TransformType.HEAD);
            GlStateManager.popMatrix();
        }
    }
    
    @Override
    public boolean shouldCombineTextures() {
        return true;
    }
}
