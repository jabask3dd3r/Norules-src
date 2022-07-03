package net.minecraft.client.renderer.entity;

import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.item.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.block.model.*;

public class RenderSnowball<T extends Entity> extends Render<T>
{
    private final /* synthetic */ RenderItem itemRenderer;
    protected final /* synthetic */ Item item;
    
    @Override
    protected ResourceLocation getEntityTexture(final Entity lllllllllllllIIllllIIlIlIlllIIII) {
        return TextureMap.LOCATION_BLOCKS_TEXTURE;
    }
    
    public ItemStack getStackToRender(final T lllllllllllllIIllllIIlIlIlllIIll) {
        return new ItemStack(this.item);
    }
    
    public RenderSnowball(final RenderManager lllllllllllllIIllllIIlIllIIIllIl, final Item lllllllllllllIIllllIIlIllIIlIIII, final RenderItem lllllllllllllIIllllIIlIllIIIllll) {
        super(lllllllllllllIIllllIIlIllIIIllIl);
        this.item = lllllllllllllIIllllIIlIllIIlIIII;
        this.itemRenderer = lllllllllllllIIllllIIlIllIIIllll;
    }
    
    @Override
    public void doRender(final T lllllllllllllIIllllIIlIlIllllIll, final double lllllllllllllIIllllIIlIlIllllIlI, final double lllllllllllllIIllllIIlIllIIIIIII, final double lllllllllllllIIllllIIlIlIllllIII, final float lllllllllllllIIllllIIlIlIllllllI, final float lllllllllllllIIllllIIlIlIlllllIl) {
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)lllllllllllllIIllllIIlIlIllllIlI, (float)lllllllllllllIIllllIIlIllIIIIIII, (float)lllllllllllllIIllllIIlIlIllllIII);
        GlStateManager.enableRescaleNormal();
        GlStateManager.rotate(-this.renderManager.playerViewY, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(((this.renderManager.options.thirdPersonView == 2) ? -1 : 1) * this.renderManager.playerViewX, 1.0f, 0.0f, 0.0f);
        GlStateManager.rotate(180.0f, 0.0f, 1.0f, 0.0f);
        this.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
        if (this.renderOutlines) {
            GlStateManager.enableColorMaterial();
            GlStateManager.enableOutlineMode(this.getTeamColor(lllllllllllllIIllllIIlIlIllllIll));
        }
        this.itemRenderer.renderItem(this.getStackToRender(lllllllllllllIIllllIIlIlIllllIll), ItemCameraTransforms.TransformType.GROUND);
        if (this.renderOutlines) {
            GlStateManager.disableOutlineMode();
            GlStateManager.disableColorMaterial();
        }
        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
        super.doRender(lllllllllllllIIllllIIlIlIllllIll, lllllllllllllIIllllIIlIlIllllIlI, lllllllllllllIIllllIIlIllIIIIIII, lllllllllllllIIllllIIlIlIllllIII, lllllllllllllIIllllIIlIlIllllllI, lllllllllllllIIllllIIlIlIlllllIl);
    }
}
