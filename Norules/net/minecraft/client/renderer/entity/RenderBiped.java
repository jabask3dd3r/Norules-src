package net.minecraft.client.renderer.entity;

import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.model.*;
import net.minecraft.client.renderer.entity.layers.*;

public class RenderBiped<T extends EntityLiving> extends RenderLiving<T>
{
    private static final /* synthetic */ ResourceLocation DEFAULT_RES_LOC;
    
    @Override
    public void transformHeldFull3DItemLayer() {
        GlStateManager.translate(0.0f, 0.1875f, 0.0f);
    }
    
    public RenderBiped(final RenderManager lllllllllllllIllIIlllIIIIIlllIII, final ModelBiped lllllllllllllIllIIlllIIIIIllIlll, final float lllllllllllllIllIIlllIIIIIlllIlI) {
        super(lllllllllllllIllIIlllIIIIIlllIII, lllllllllllllIllIIlllIIIIIllIlll, lllllllllllllIllIIlllIIIIIlllIlI);
        this.addLayer(new LayerCustomHead(lllllllllllllIllIIlllIIIIIllIlll.bipedHead));
        this.addLayer(new LayerElytra(this));
        this.addLayer(new LayerHeldItem(this));
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final T lllllllllllllIllIIlllIIIIIllIlII) {
        return RenderBiped.DEFAULT_RES_LOC;
    }
    
    static {
        DEFAULT_RES_LOC = new ResourceLocation("textures/entity/steve.png");
    }
}
