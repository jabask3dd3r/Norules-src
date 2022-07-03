package net.minecraft.client.renderer.entity;

import net.minecraft.entity.monster.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.*;
import net.minecraft.client.renderer.entity.layers.*;

public class RenderWitch extends RenderLiving<EntityWitch>
{
    private static final /* synthetic */ ResourceLocation WITCH_TEXTURES;
    
    @Override
    protected void preRenderCallback(final EntityWitch lllllllllllllIIllllIIIIIIlllIlIl, final float lllllllllllllIIllllIIIIIIlllIlII) {
        final float lllllllllllllIIllllIIIIIIlllIIll = 0.9375f;
        GlStateManager.scale(0.9375f, 0.9375f, 0.9375f);
    }
    
    @Override
    public void transformHeldFull3DItemLayer() {
        GlStateManager.translate(0.0f, 0.1875f, 0.0f);
    }
    
    @Override
    public void doRender(final EntityWitch lllllllllllllIIllllIIIIIlIIIIIII, final double lllllllllllllIIllllIIIIIIlllllll, final double lllllllllllllIIllllIIIIIlIIIIlIl, final double lllllllllllllIIllllIIIIIIlllllIl, final float lllllllllllllIIllllIIIIIlIIIIIll, final float lllllllllllllIIllllIIIIIlIIIIIlI) {
        ((ModelWitch)this.mainModel).holdingItem = !lllllllllllllIIllllIIIIIlIIIIIII.getHeldItemMainhand().func_190926_b();
        super.doRender(lllllllllllllIIllllIIIIIlIIIIIII, lllllllllllllIIllllIIIIIIlllllll, lllllllllllllIIllllIIIIIlIIIIlIl, lllllllllllllIIllllIIIIIIlllllIl, lllllllllllllIIllllIIIIIlIIIIIll, lllllllllllllIIllllIIIIIlIIIIIlI);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityWitch lllllllllllllIIllllIIIIIIllllIIl) {
        return RenderWitch.WITCH_TEXTURES;
    }
    
    static {
        WITCH_TEXTURES = new ResourceLocation("textures/entity/witch.png");
    }
    
    @Override
    public ModelWitch getMainModel() {
        return (ModelWitch)super.getMainModel();
    }
    
    public RenderWitch(final RenderManager lllllllllllllIIllllIIIIIlIIlIIll) {
        super(lllllllllllllIIllllIIIIIlIIlIIll, new ModelWitch(0.0f), 0.5f);
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerHeldItemWitch(this));
    }
}
