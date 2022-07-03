package net.optifine.entity.model;

import net.minecraft.entity.passive.*;
import net.minecraft.client.model.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.entity.*;

public class ModelAdapterMule extends ModelAdapterHorse
{
    public ModelAdapterMule() {
        super(EntityMule.class, "mule", 0.75f);
    }
    
    @Override
    public IEntityRenderer makeEntityRender(final ModelBase lllllllllllllIIllIIlIlIllIlIIIlI, final float lllllllllllllIIllIIlIlIllIlIIIIl) {
        final RenderManager lllllllllllllIIllIIlIlIllIlIIlII = Minecraft.getMinecraft().getRenderManager();
        final RenderAbstractHorse lllllllllllllIIllIIlIlIllIlIIIll = new RenderAbstractHorse(lllllllllllllIIllIIlIlIllIlIIlII);
        lllllllllllllIIllIIlIlIllIlIIIll.mainModel = lllllllllllllIIllIIlIlIllIlIIIlI;
        lllllllllllllIIllIIlIlIllIlIIIll.shadowSize = lllllllllllllIIllIIlIlIllIlIIIIl;
        return lllllllllllllIIllIIlIlIllIlIIIll;
    }
}
