package net.optifine.entity.model;

import net.minecraft.client.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.entity.monster.*;
import net.minecraft.client.model.*;

public class ModelAdapterEnderman extends ModelAdapterBiped
{
    @Override
    public IEntityRenderer makeEntityRender(final ModelBase lllllllllllllllIIlIllllllllIIIII, final float lllllllllllllllIIlIlllllllIllIll) {
        final RenderManager lllllllllllllllIIlIlllllllIllllI = Minecraft.getMinecraft().getRenderManager();
        final RenderEnderman lllllllllllllllIIlIlllllllIlllIl = new RenderEnderman(lllllllllllllllIIlIlllllllIllllI);
        lllllllllllllllIIlIlllllllIlllIl.mainModel = lllllllllllllllIIlIllllllllIIIII;
        lllllllllllllllIIlIlllllllIlllIl.shadowSize = lllllllllllllllIIlIlllllllIllIll;
        return lllllllllllllllIIlIlllllllIlllIl;
    }
    
    public ModelAdapterEnderman() {
        super(EntityEnderman.class, "enderman", 0.5f);
    }
    
    @Override
    public ModelBase makeModel() {
        return new ModelEnderman(0.0f);
    }
}
