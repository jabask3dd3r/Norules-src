package net.minecraft.client.renderer.entity;

import net.minecraft.entity.monster.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;
import net.minecraft.client.model.*;
import net.minecraft.client.renderer.entity.layers.*;

public class RenderCreeper extends RenderLiving<EntityCreeper>
{
    private static final /* synthetic */ ResourceLocation CREEPER_TEXTURES;
    
    @Override
    protected int getColorMultiplier(final EntityCreeper llllllllllllllIlIIIIIIIIlIIIIllI, final float llllllllllllllIlIIIIIIIIlIIIlIlI, final float llllllllllllllIlIIIIIIIIlIIIIlIl) {
        final float llllllllllllllIlIIIIIIIIlIIIlIII = llllllllllllllIlIIIIIIIIlIIIIllI.getCreeperFlashIntensity(llllllllllllllIlIIIIIIIIlIIIIlIl);
        if ((int)(llllllllllllllIlIIIIIIIIlIIIlIII * 10.0f) % 2 == 0) {
            return 0;
        }
        int llllllllllllllIlIIIIIIIIlIIIIlll = (int)(llllllllllllllIlIIIIIIIIlIIIlIII * 0.2f * 255.0f);
        llllllllllllllIlIIIIIIIIlIIIIlll = MathHelper.clamp(llllllllllllllIlIIIIIIIIlIIIIlll, 0, 255);
        return llllllllllllllIlIIIIIIIIlIIIIlll << 24 | 0x30FFFFFF;
    }
    
    @Override
    protected void preRenderCallback(final EntityCreeper llllllllllllllIlIIIIIIIIlIIlIllI, final float llllllllllllllIlIIIIIIIIlIIlIlIl) {
        float llllllllllllllIlIIIIIIIIlIIllIlI = llllllllllllllIlIIIIIIIIlIIlIllI.getCreeperFlashIntensity(llllllllllllllIlIIIIIIIIlIIlIlIl);
        final float llllllllllllllIlIIIIIIIIlIIllIIl = 1.0f + MathHelper.sin(llllllllllllllIlIIIIIIIIlIIllIlI * 100.0f) * llllllllllllllIlIIIIIIIIlIIllIlI * 0.01f;
        llllllllllllllIlIIIIIIIIlIIllIlI = MathHelper.clamp(llllllllllllllIlIIIIIIIIlIIllIlI, 0.0f, 1.0f);
        llllllllllllllIlIIIIIIIIlIIllIlI *= llllllllllllllIlIIIIIIIIlIIllIlI;
        llllllllllllllIlIIIIIIIIlIIllIlI *= llllllllllllllIlIIIIIIIIlIIllIlI;
        final float llllllllllllllIlIIIIIIIIlIIllIII = (1.0f + llllllllllllllIlIIIIIIIIlIIllIlI * 0.4f) * llllllllllllllIlIIIIIIIIlIIllIIl;
        final float llllllllllllllIlIIIIIIIIlIIlIlll = (1.0f + llllllllllllllIlIIIIIIIIlIIllIlI * 0.1f) / llllllllllllllIlIIIIIIIIlIIllIIl;
        GlStateManager.scale(llllllllllllllIlIIIIIIIIlIIllIII, llllllllllllllIlIIIIIIIIlIIlIlll, llllllllllllllIlIIIIIIIIlIIllIII);
    }
    
    static {
        CREEPER_TEXTURES = new ResourceLocation("textures/entity/creeper/creeper.png");
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityCreeper llllllllllllllIlIIIIIIIIlIIIIIIl) {
        return RenderCreeper.CREEPER_TEXTURES;
    }
    
    public RenderCreeper(final RenderManager llllllllllllllIlIIIIIIIIlIlIIllI) {
        super(llllllllllllllIlIIIIIIIIlIlIIllI, new ModelCreeper(), 0.5f);
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new LayerCreeperCharge(this));
    }
}
