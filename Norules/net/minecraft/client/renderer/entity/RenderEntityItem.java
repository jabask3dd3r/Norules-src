package net.minecraft.client.renderer.entity;

import net.minecraft.entity.item.*;
import java.util.*;
import net.minecraft.item.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.block.model.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.texture.*;

public class RenderEntityItem extends Render<EntityItem>
{
    private final /* synthetic */ Random random;
    private final /* synthetic */ RenderItem itemRenderer;
    
    private int getModelCount(final ItemStack llllllllllllllIlIIlIIIlllllIIlII) {
        int llllllllllllllIlIIlIIIlllllIIIll = 1;
        if (llllllllllllllIlIIlIIIlllllIIlII.func_190916_E() > 48) {
            llllllllllllllIlIIlIIIlllllIIIll = 5;
        }
        else if (llllllllllllllIlIIlIIIlllllIIlII.func_190916_E() > 32) {
            llllllllllllllIlIIlIIIlllllIIIll = 4;
        }
        else if (llllllllllllllIlIIlIIIlllllIIlII.func_190916_E() > 16) {
            llllllllllllllIlIIlIIIlllllIIIll = 3;
        }
        else if (llllllllllllllIlIIlIIIlllllIIlII.func_190916_E() > 1) {
            llllllllllllllIlIIlIIIlllllIIIll = 2;
        }
        return llllllllllllllIlIIlIIIlllllIIIll;
    }
    
    @Override
    public void doRender(final EntityItem llllllllllllllIlIIlIIIllllIIlIll, final double llllllllllllllIlIIlIIIlllIllIIIl, final double llllllllllllllIlIIlIIIlllIllIIII, final double llllllllllllllIlIIlIIIllllIIlIII, final float llllllllllllllIlIIlIIIllllIIIlll, final float llllllllllllllIlIIlIIIllllIIIllI) {
        final ItemStack llllllllllllllIlIIlIIIllllIIIlIl = llllllllllllllIlIIlIIIllllIIlIll.getEntityItem();
        final int llllllllllllllIlIIlIIIllllIIIlII = llllllllllllllIlIIlIIIllllIIIlIl.func_190926_b() ? 187 : (Item.getIdFromItem(llllllllllllllIlIIlIIIllllIIIlIl.getItem()) + llllllllllllllIlIIlIIIllllIIIlIl.getMetadata());
        this.random.setSeed(llllllllllllllIlIIlIIIllllIIIlII);
        boolean llllllllllllllIlIIlIIIllllIIIIll = false;
        if (this.bindEntityTexture(llllllllllllllIlIIlIIIllllIIlIll)) {
            this.renderManager.renderEngine.getTexture(this.getEntityTexture(llllllllllllllIlIIlIIIllllIIlIll)).setBlurMipmap(false, false);
            llllllllllllllIlIIlIIIllllIIIIll = true;
        }
        GlStateManager.enableRescaleNormal();
        GlStateManager.alphaFunc(516, 0.1f);
        GlStateManager.enableBlend();
        RenderHelper.enableStandardItemLighting();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.pushMatrix();
        final IBakedModel llllllllllllllIlIIlIIIllllIIIIlI = this.itemRenderer.getItemModelWithOverrides(llllllllllllllIlIIlIIIllllIIIlIl, llllllllllllllIlIIlIIIllllIIlIll.world, null);
        final int llllllllllllllIlIIlIIIllllIIIIIl = this.transformModelCount(llllllllllllllIlIIlIIIllllIIlIll, llllllllllllllIlIIlIIIlllIllIIIl, llllllllllllllIlIIlIIIlllIllIIII, llllllllllllllIlIIlIIIllllIIlIII, llllllllllllllIlIIlIIIllllIIIllI, llllllllllllllIlIIlIIIllllIIIIlI);
        final float llllllllllllllIlIIlIIIllllIIIIII = llllllllllllllIlIIlIIIllllIIIIlI.getItemCameraTransforms().ground.scale.x;
        final float llllllllllllllIlIIlIIIlllIllllll = llllllllllllllIlIIlIIIllllIIIIlI.getItemCameraTransforms().ground.scale.y;
        final float llllllllllllllIlIIlIIIlllIlllllI = llllllllllllllIlIIlIIIllllIIIIlI.getItemCameraTransforms().ground.scale.z;
        final boolean llllllllllllllIlIIlIIIlllIllllIl = llllllllllllllIlIIlIIIllllIIIIlI.isGui3d();
        if (!llllllllllllllIlIIlIIIlllIllllIl) {
            final float llllllllllllllIlIIlIIIlllIllllII = -0.0f * (llllllllllllllIlIIlIIIllllIIIIIl - 1) * 0.5f * llllllllllllllIlIIlIIIllllIIIIII;
            final float llllllllllllllIlIIlIIIlllIlllIll = -0.0f * (llllllllllllllIlIIlIIIllllIIIIIl - 1) * 0.5f * llllllllllllllIlIIlIIIlllIllllll;
            final float llllllllllllllIlIIlIIIlllIlllIlI = -0.09375f * (llllllllllllllIlIIlIIIllllIIIIIl - 1) * 0.5f * llllllllllllllIlIIlIIIlllIlllllI;
            GlStateManager.translate(llllllllllllllIlIIlIIIlllIllllII, llllllllllllllIlIIlIIIlllIlllIll, llllllllllllllIlIIlIIIlllIlllIlI);
        }
        if (this.renderOutlines) {
            GlStateManager.enableColorMaterial();
            GlStateManager.enableOutlineMode(this.getTeamColor(llllllllllllllIlIIlIIIllllIIlIll));
        }
        for (int llllllllllllllIlIIlIIIlllIlllIIl = 0; llllllllllllllIlIIlIIIlllIlllIIl < llllllllllllllIlIIlIIIllllIIIIIl; ++llllllllllllllIlIIlIIIlllIlllIIl) {
            if (llllllllllllllIlIIlIIIlllIllllIl) {
                GlStateManager.pushMatrix();
                if (llllllllllllllIlIIlIIIlllIlllIIl > 0) {
                    final float llllllllllllllIlIIlIIIlllIlllIII = (this.random.nextFloat() * 2.0f - 1.0f) * 0.15f;
                    final float llllllllllllllIlIIlIIIlllIllIlll = (this.random.nextFloat() * 2.0f - 1.0f) * 0.15f;
                    final float llllllllllllllIlIIlIIIlllIllIllI = (this.random.nextFloat() * 2.0f - 1.0f) * 0.15f;
                    GlStateManager.translate(llllllllllllllIlIIlIIIlllIlllIII, llllllllllllllIlIIlIIIlllIllIlll, llllllllllllllIlIIlIIIlllIllIllI);
                }
                llllllllllllllIlIIlIIIllllIIIIlI.getItemCameraTransforms().applyTransform(ItemCameraTransforms.TransformType.GROUND);
                this.itemRenderer.renderItem(llllllllllllllIlIIlIIIllllIIIlIl, llllllllllllllIlIIlIIIllllIIIIlI);
                GlStateManager.popMatrix();
            }
            else {
                GlStateManager.pushMatrix();
                if (llllllllllllllIlIIlIIIlllIlllIIl > 0) {
                    final float llllllllllllllIlIIlIIIlllIllIlIl = (this.random.nextFloat() * 2.0f - 1.0f) * 0.15f * 0.5f;
                    final float llllllllllllllIlIIlIIIlllIllIlII = (this.random.nextFloat() * 2.0f - 1.0f) * 0.15f * 0.5f;
                    GlStateManager.translate(llllllllllllllIlIIlIIIlllIllIlIl, llllllllllllllIlIIlIIIlllIllIlII, 0.0f);
                }
                llllllllllllllIlIIlIIIllllIIIIlI.getItemCameraTransforms().applyTransform(ItemCameraTransforms.TransformType.GROUND);
                this.itemRenderer.renderItem(llllllllllllllIlIIlIIIllllIIIlIl, llllllllllllllIlIIlIIIllllIIIIlI);
                GlStateManager.popMatrix();
                GlStateManager.translate(0.0f * llllllllllllllIlIIlIIIllllIIIIII, 0.0f * llllllllllllllIlIIlIIIlllIllllll, 0.09375f * llllllllllllllIlIIlIIIlllIlllllI);
            }
        }
        if (this.renderOutlines) {
            GlStateManager.disableOutlineMode();
            GlStateManager.disableColorMaterial();
        }
        GlStateManager.popMatrix();
        GlStateManager.disableRescaleNormal();
        GlStateManager.disableBlend();
        this.bindEntityTexture(llllllllllllllIlIIlIIIllllIIlIll);
        if (llllllllllllllIlIIlIIIllllIIIIll) {
            this.renderManager.renderEngine.getTexture(this.getEntityTexture(llllllllllllllIlIIlIIIllllIIlIll)).restoreLastBlurMipmap();
        }
        super.doRender(llllllllllllllIlIIlIIIllllIIlIll, llllllllllllllIlIIlIIIlllIllIIIl, llllllllllllllIlIIlIIIlllIllIIII, llllllllllllllIlIIlIIIllllIIlIII, llllllllllllllIlIIlIIIllllIIIlll, llllllllllllllIlIIlIIIllllIIIllI);
    }
    
    private int transformModelCount(final EntityItem llllllllllllllIlIIlIIlIIIIIIIlII, final double llllllllllllllIlIIlIIlIIIIIIIIll, final double llllllllllllllIlIIlIIlIIIIIIIIlI, final double llllllllllllllIlIIlIIIllllllIIlI, final float llllllllllllllIlIIlIIIllllllIIIl, final IBakedModel llllllllllllllIlIIlIIIllllllIIII) {
        final ItemStack llllllllllllllIlIIlIIIlllllllllI = llllllllllllllIlIIlIIlIIIIIIIlII.getEntityItem();
        final Item llllllllllllllIlIIlIIIllllllllIl = llllllllllllllIlIIlIIIlllllllllI.getItem();
        if (llllllllllllllIlIIlIIIllllllllIl == null) {
            return 0;
        }
        final boolean llllllllllllllIlIIlIIIllllllllII = llllllllllllllIlIIlIIIllllllIIII.isGui3d();
        final int llllllllllllllIlIIlIIIlllllllIll = this.getModelCount(llllllllllllllIlIIlIIIlllllllllI);
        final float llllllllllllllIlIIlIIIlllllllIlI = 0.25f;
        final float llllllllllllllIlIIlIIIlllllllIIl = MathHelper.sin((llllllllllllllIlIIlIIlIIIIIIIlII.getAge() + llllllllllllllIlIIlIIIllllllIIIl) / 10.0f + llllllllllllllIlIIlIIlIIIIIIIlII.hoverStart) * 0.1f + 0.1f;
        final float llllllllllllllIlIIlIIIlllllllIII = llllllllllllllIlIIlIIIllllllIIII.getItemCameraTransforms().getTransform(ItemCameraTransforms.TransformType.GROUND).scale.y;
        GlStateManager.translate((float)llllllllllllllIlIIlIIlIIIIIIIIll, (float)llllllllllllllIlIIlIIlIIIIIIIIlI + llllllllllllllIlIIlIIIlllllllIIl + 0.25f * llllllllllllllIlIIlIIIlllllllIII, (float)llllllllllllllIlIIlIIIllllllIIlI);
        if (llllllllllllllIlIIlIIIllllllllII || this.renderManager.options != null) {
            final float llllllllllllllIlIIlIIIllllllIlll = ((llllllllllllllIlIIlIIlIIIIIIIlII.getAge() + llllllllllllllIlIIlIIIllllllIIIl) / 20.0f + llllllllllllllIlIIlIIlIIIIIIIlII.hoverStart) * 57.295776f;
            GlStateManager.rotate(llllllllllllllIlIIlIIIllllllIlll, 0.0f, 1.0f, 0.0f);
        }
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        return llllllllllllllIlIIlIIIlllllllIll;
    }
    
    public RenderEntityItem(final RenderManager llllllllllllllIlIIlIIlIIIIIllIIl, final RenderItem llllllllllllllIlIIlIIlIIIIIlIlIl) {
        super(llllllllllllllIlIIlIIlIIIIIllIIl);
        this.random = new Random();
        this.itemRenderer = llllllllllllllIlIIlIIlIIIIIlIlIl;
        this.shadowSize = 0.15f;
        this.shadowOpaque = 0.75f;
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityItem llllllllllllllIlIIlIIIlllIIllllI) {
        return TextureMap.LOCATION_BLOCKS_TEXTURE;
    }
}
