package net.optifine.entity.model;

import net.minecraft.entity.passive.*;
import net.minecraft.client.model.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.entity.*;

public class ModelAdapterDonkey extends ModelAdapterHorse
{
    public ModelAdapterDonkey() {
        super(EntityDonkey.class, "donkey", 0.75f);
    }
    
    @Override
    public IEntityRenderer makeEntityRender(final ModelBase lllllllllllllIIIIllIlIIllIllIIlI, final float lllllllllllllIIIIllIlIIllIllIlIl) {
        final RenderManager lllllllllllllIIIIllIlIIllIllIlII = Minecraft.getMinecraft().getRenderManager();
        final RenderAbstractHorse lllllllllllllIIIIllIlIIllIllIIll = new RenderAbstractHorse(lllllllllllllIIIIllIlIIllIllIlII);
        lllllllllllllIIIIllIlIIllIllIIll.mainModel = lllllllllllllIIIIllIlIIllIllIIlI;
        lllllllllllllIIIIllIlIIllIllIIll.shadowSize = lllllllllllllIIIIllIlIIllIllIlIl;
        return lllllllllllllIIIIllIlIIllIllIIll;
    }
}
