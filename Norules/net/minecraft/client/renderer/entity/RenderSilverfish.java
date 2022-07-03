package net.minecraft.client.renderer.entity;

import net.minecraft.entity.monster.*;
import net.minecraft.util.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class RenderSilverfish extends RenderLiving<EntitySilverfish>
{
    private static final /* synthetic */ ResourceLocation SILVERFISH_TEXTURES;
    
    @Override
    protected ResourceLocation getEntityTexture(final EntitySilverfish lllllllllllllIIIlIlIIIIIIIlIIIIl) {
        return RenderSilverfish.SILVERFISH_TEXTURES;
    }
    
    public RenderSilverfish(final RenderManager lllllllllllllIIIlIlIIIIIIIlIIlll) {
        super(lllllllllllllIIIlIlIIIIIIIlIIlll, new ModelSilverfish(), 0.3f);
    }
    
    static {
        SILVERFISH_TEXTURES = new ResourceLocation("textures/entity/silverfish.png");
    }
    
    @Override
    protected float getDeathMaxRotation(final EntitySilverfish lllllllllllllIIIlIlIIIIIIIlIIIll) {
        return 180.0f;
    }
}
