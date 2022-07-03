package net.optifine.entity.model;

import net.minecraft.entity.monster.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.model.*;

public class ModelAdapterZombie extends ModelAdapterBiped
{
    public ModelAdapterZombie() {
        super(EntityZombie.class, "zombie", 0.5f);
    }
    
    @Override
    public IEntityRenderer makeEntityRender(final ModelBase lllllllllllllllIIIlllIlIIIllIlll, final float lllllllllllllllIIIlllIlIIIllIllI) {
        final RenderManager lllllllllllllllIIIlllIlIIIlllIIl = Minecraft.getMinecraft().getRenderManager();
        final RenderZombie lllllllllllllllIIIlllIlIIIlllIII = new RenderZombie(lllllllllllllllIIIlllIlIIIlllIIl);
        lllllllllllllllIIIlllIlIIIlllIII.mainModel = lllllllllllllllIIIlllIlIIIllIlll;
        lllllllllllllllIIIlllIlIIIlllIII.shadowSize = lllllllllllllllIIIlllIlIIIllIllI;
        return lllllllllllllllIIIlllIlIIIlllIII;
    }
    
    @Override
    public ModelBase makeModel() {
        return new ModelZombie();
    }
}
