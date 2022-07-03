package net.optifine.entity.model;

import net.minecraft.entity.passive.*;
import net.minecraft.client.model.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.entity.*;

public class ModelAdapterSkeletonHorse extends ModelAdapterHorse
{
    public ModelAdapterSkeletonHorse() {
        super(EntityZombieHorse.class, "zombie_horse", 0.75f);
    }
    
    @Override
    public IEntityRenderer makeEntityRender(final ModelBase lllllllllllllIllIlIIIIllllIlllIl, final float lllllllllllllIllIlIIIIllllIlllII) {
        final RenderManager lllllllllllllIllIlIIIIllllIlllll = Minecraft.getMinecraft().getRenderManager();
        final RenderAbstractHorse lllllllllllllIllIlIIIIllllIllllI = new RenderAbstractHorse(lllllllllllllIllIlIIIIllllIlllll);
        lllllllllllllIllIlIIIIllllIllllI.mainModel = lllllllllllllIllIlIIIIllllIlllIl;
        lllllllllllllIllIlIIIIllllIllllI.shadowSize = lllllllllllllIllIlIIIIllllIlllII;
        return lllllllllllllIllIlIIIIllllIllllI;
    }
}
