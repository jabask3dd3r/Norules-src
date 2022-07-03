package net.minecraft.client.renderer.entity;

import net.minecraft.entity.monster.*;
import net.minecraft.util.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class RenderEndermite extends RenderLiving<EntityEndermite>
{
    private static final /* synthetic */ ResourceLocation ENDERMITE_TEXTURES;
    
    public RenderEndermite(final RenderManager llllllllllllllIllllIlllIlIIIlIIl) {
        super(llllllllllllllIllllIlllIlIIIlIIl, new ModelEnderMite(), 0.3f);
    }
    
    static {
        ENDERMITE_TEXTURES = new ResourceLocation("textures/entity/endermite.png");
    }
    
    @Override
    protected float getDeathMaxRotation(final EntityEndermite llllllllllllllIllllIlllIlIIIIlIl) {
        return 180.0f;
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityEndermite llllllllllllllIllllIlllIlIIIIIll) {
        return RenderEndermite.ENDERMITE_TEXTURES;
    }
}
