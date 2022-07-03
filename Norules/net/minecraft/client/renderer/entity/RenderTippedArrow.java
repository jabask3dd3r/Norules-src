package net.minecraft.client.renderer.entity;

import net.minecraft.entity.projectile.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;

public class RenderTippedArrow extends RenderArrow<EntityTippedArrow>
{
    public static final /* synthetic */ ResourceLocation RES_TIPPED_ARROW;
    public static final /* synthetic */ ResourceLocation RES_ARROW;
    
    static {
        RES_ARROW = new ResourceLocation("textures/entity/projectiles/arrow.png");
        RES_TIPPED_ARROW = new ResourceLocation("textures/entity/projectiles/tipped_arrow.png");
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityTippedArrow lllllllllllllllIlIlIlllllIIIIIII) {
        return (lllllllllllllllIlIlIlllllIIIIIII.getColor() > 0) ? RenderTippedArrow.RES_TIPPED_ARROW : RenderTippedArrow.RES_ARROW;
    }
    
    public RenderTippedArrow(final RenderManager lllllllllllllllIlIlIlllllIIIIlIl) {
        super(lllllllllllllllIlIlIlllllIIIIlIl);
    }
}
