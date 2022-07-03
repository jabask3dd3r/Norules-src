package net.minecraft.client.renderer.entity;

import net.minecraft.entity.monster.*;
import net.minecraft.util.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class RenderBlaze extends RenderLiving<EntityBlaze>
{
    private static final /* synthetic */ ResourceLocation BLAZE_TEXTURES;
    
    public RenderBlaze(final RenderManager llllllllllllllllIIIIIlIllllIlIII) {
        super(llllllllllllllllIIIIIlIllllIlIII, new ModelBlaze(), 0.5f);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityBlaze llllllllllllllllIIIIIlIllllIIlII) {
        return RenderBlaze.BLAZE_TEXTURES;
    }
    
    static {
        BLAZE_TEXTURES = new ResourceLocation("textures/entity/blaze.png");
    }
}
