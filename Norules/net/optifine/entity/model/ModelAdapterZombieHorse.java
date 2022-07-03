package net.optifine.entity.model;

import net.minecraft.entity.passive.*;
import net.minecraft.client.model.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.entity.*;

public class ModelAdapterZombieHorse extends ModelAdapterHorse
{
    public ModelAdapterZombieHorse() {
        super(EntitySkeletonHorse.class, "skeleton_horse", 0.75f);
    }
    
    @Override
    public IEntityRenderer makeEntityRender(final ModelBase lllllllllllllllIllllIIIllIlIlllI, final float lllllllllllllllIllllIIIllIlIlIIl) {
        final RenderManager lllllllllllllllIllllIIIllIlIllII = Minecraft.getMinecraft().getRenderManager();
        final RenderAbstractHorse lllllllllllllllIllllIIIllIlIlIll = new RenderAbstractHorse(lllllllllllllllIllllIIIllIlIllII);
        lllllllllllllllIllllIIIllIlIlIll.mainModel = lllllllllllllllIllllIIIllIlIlllI;
        lllllllllllllllIllllIIIllIlIlIll.shadowSize = lllllllllllllllIllllIIIllIlIlIIl;
        return lllllllllllllllIllllIIIllIlIlIll;
    }
}
