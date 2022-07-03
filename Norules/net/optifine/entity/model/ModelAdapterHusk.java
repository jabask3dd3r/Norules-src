package net.optifine.entity.model;

import net.minecraft.client.model.*;
import net.minecraft.entity.monster.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.entity.*;

public class ModelAdapterHusk extends ModelAdapterBiped
{
    @Override
    public ModelBase makeModel() {
        return new ModelZombie();
    }
    
    public ModelAdapterHusk() {
        super(EntityHusk.class, "husk", 0.5f);
    }
    
    @Override
    public IEntityRenderer makeEntityRender(final ModelBase lllllllllllllIIIlIlIIllllllIlIIl, final float lllllllllllllIIIlIlIIllllllIlIII) {
        final RenderManager lllllllllllllIIIlIlIIllllllIIlll = Minecraft.getMinecraft().getRenderManager();
        final RenderHusk lllllllllllllIIIlIlIIllllllIIllI = new RenderHusk(lllllllllllllIIIlIlIIllllllIIlll);
        lllllllllllllIIIlIlIIllllllIIllI.mainModel = lllllllllllllIIIlIlIIllllllIlIIl;
        lllllllllllllIIIlIlIIllllllIIllI.shadowSize = lllllllllllllIIIlIlIIllllllIlIII;
        return lllllllllllllIIIlIlIIllllllIIllI;
    }
}
