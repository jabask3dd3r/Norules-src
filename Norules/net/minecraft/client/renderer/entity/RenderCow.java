package net.minecraft.client.renderer.entity;

import net.minecraft.entity.passive.*;
import net.minecraft.util.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class RenderCow extends RenderLiving<EntityCow>
{
    private static final /* synthetic */ ResourceLocation COW_TEXTURES;
    
    public RenderCow(final RenderManager lllllllllllllIIIlllIIlllIIIIlIlI) {
        super(lllllllllllllIIIlllIIlllIIIIlIlI, new ModelCow(), 0.7f);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityCow lllllllllllllIIIlllIIlllIIIIIllI) {
        return RenderCow.COW_TEXTURES;
    }
    
    static {
        COW_TEXTURES = new ResourceLocation("textures/entity/cow/cow.png");
    }
}
