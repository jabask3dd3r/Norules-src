package net.optifine.entity.model;

import net.minecraft.entity.monster.*;
import net.minecraft.client.model.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.entity.*;

public class ModelAdapterZombieVillager extends ModelAdapterBiped
{
    public ModelAdapterZombieVillager() {
        super(EntityZombieVillager.class, "zombie_villager", 0.5f);
    }
    
    @Override
    public ModelBase makeModel() {
        return new ModelZombieVillager();
    }
    
    @Override
    public IEntityRenderer makeEntityRender(final ModelBase llllllllllllllIlIllllIlIlIIIIIll, final float llllllllllllllIlIllllIlIlIIIIllI) {
        final RenderManager llllllllllllllIlIllllIlIlIIIIlIl = Minecraft.getMinecraft().getRenderManager();
        final RenderZombieVillager llllllllllllllIlIllllIlIlIIIIlII = new RenderZombieVillager(llllllllllllllIlIllllIlIlIIIIlIl);
        llllllllllllllIlIllllIlIlIIIIlII.mainModel = llllllllllllllIlIllllIlIlIIIIIll;
        llllllllllllllIlIllllIlIlIIIIlII.shadowSize = llllllllllllllIlIllllIlIlIIIIllI;
        return llllllllllllllIlIllllIlIlIIIIlII;
    }
}
