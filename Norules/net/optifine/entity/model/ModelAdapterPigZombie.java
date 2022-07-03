package net.optifine.entity.model;

import net.minecraft.client.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.entity.monster.*;
import net.minecraft.client.model.*;

public class ModelAdapterPigZombie extends ModelAdapterBiped
{
    @Override
    public IEntityRenderer makeEntityRender(final ModelBase lllllllllllllllIlllIllIIIlIlIllI, final float lllllllllllllllIlllIllIIIlIlIlIl) {
        final RenderManager lllllllllllllllIlllIllIIIlIllIII = Minecraft.getMinecraft().getRenderManager();
        final RenderPigZombie lllllllllllllllIlllIllIIIlIlIlll = new RenderPigZombie(lllllllllllllllIlllIllIIIlIllIII);
        lllllllllllllllIlllIllIIIlIlIlll.mainModel = lllllllllllllllIlllIllIIIlIlIllI;
        lllllllllllllllIlllIllIIIlIlIlll.shadowSize = lllllllllllllllIlllIllIIIlIlIlIl;
        return lllllllllllllllIlllIllIIIlIlIlll;
    }
    
    public ModelAdapterPigZombie() {
        super(EntityPigZombie.class, "zombie_pigman", 0.5f);
    }
    
    @Override
    public ModelBase makeModel() {
        return new ModelZombie();
    }
}
