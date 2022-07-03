package net.minecraft.client.renderer.entity;

import net.minecraft.entity.monster.*;
import net.minecraft.util.*;
import net.minecraft.client.model.*;
import net.minecraft.client.renderer.entity.layers.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;

public class RenderIronGolem extends RenderLiving<EntityIronGolem>
{
    private static final /* synthetic */ ResourceLocation IRON_GOLEM_TEXTURES;
    
    public RenderIronGolem(final RenderManager lllllllllllllIIlllIIIlIlIlIlIlll) {
        super(lllllllllllllIIlllIIIlIlIlIlIlll, new ModelIronGolem(), 0.5f);
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerIronGolemFlower(this));
    }
    
    static {
        IRON_GOLEM_TEXTURES = new ResourceLocation("textures/entity/iron_golem.png");
    }
    
    @Override
    protected void rotateCorpse(final EntityIronGolem lllllllllllllIIlllIIIlIlIIlllIII, final float lllllllllllllIIlllIIIlIlIIllIlll, final float lllllllllllllIIlllIIIlIlIIllIllI, final float lllllllllllllIIlllIIIlIlIIllIlIl) {
        super.rotateCorpse(lllllllllllllIIlllIIIlIlIIlllIII, lllllllllllllIIlllIIIlIlIIllIlll, lllllllllllllIIlllIIIlIlIIllIllI, lllllllllllllIIlllIIIlIlIIllIlIl);
        if (lllllllllllllIIlllIIIlIlIIlllIII.limbSwingAmount >= 0.01) {
            final float lllllllllllllIIlllIIIlIlIIllllII = 13.0f;
            final float lllllllllllllIIlllIIIlIlIIlllIll = lllllllllllllIIlllIIIlIlIIlllIII.limbSwing - lllllllllllllIIlllIIIlIlIIlllIII.limbSwingAmount * (1.0f - lllllllllllllIIlllIIIlIlIIllIlIl) + 6.0f;
            final float lllllllllllllIIlllIIIlIlIIlllIlI = (Math.abs(lllllllllllllIIlllIIIlIlIIlllIll % 13.0f - 6.5f) - 3.25f) / 3.25f;
            GlStateManager.rotate(6.5f * lllllllllllllIIlllIIIlIlIIlllIlI, 0.0f, 0.0f, 1.0f);
        }
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityIronGolem lllllllllllllIIlllIIIlIlIlIlIIll) {
        return RenderIronGolem.IRON_GOLEM_TEXTURES;
    }
}
