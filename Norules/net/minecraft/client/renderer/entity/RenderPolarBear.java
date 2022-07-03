package net.minecraft.client.renderer.entity;

import net.minecraft.entity.monster.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class RenderPolarBear extends RenderLiving<EntityPolarBear>
{
    private static final /* synthetic */ ResourceLocation POLAR_BEAR_TEXTURE;
    
    @Override
    protected void preRenderCallback(final EntityPolarBear llllllllllllllllIlllllllIIllIIlI, final float llllllllllllllllIlllllllIIllIIII) {
        GlStateManager.scale(1.2f, 1.2f, 1.2f);
        super.preRenderCallback(llllllllllllllllIlllllllIIllIIlI, llllllllllllllllIlllllllIIllIIII);
    }
    
    static {
        POLAR_BEAR_TEXTURE = new ResourceLocation("textures/entity/bear/polarbear.png");
    }
    
    public RenderPolarBear(final RenderManager llllllllllllllllIlllllllIllIlIll) {
        super(llllllllllllllllIlllllllIllIlIll, new ModelPolarBear(), 0.7f);
    }
    
    @Override
    public void doRender(final EntityPolarBear llllllllllllllllIlllllllIlIllIIl, final double llllllllllllllllIlllllllIlIIllII, final double llllllllllllllllIlllllllIlIIlIlI, final double llllllllllllllllIlllllllIlIlIllI, final float llllllllllllllllIlllllllIlIlIlII, final float llllllllllllllllIlllllllIlIlIIlI) {
        super.doRender(llllllllllllllllIlllllllIlIllIIl, llllllllllllllllIlllllllIlIIllII, llllllllllllllllIlllllllIlIIlIlI, llllllllllllllllIlllllllIlIlIllI, llllllllllllllllIlllllllIlIlIlII, llllllllllllllllIlllllllIlIlIIlI);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityPolarBear llllllllllllllllIlllllllIllIIllI) {
        return RenderPolarBear.POLAR_BEAR_TEXTURE;
    }
}
