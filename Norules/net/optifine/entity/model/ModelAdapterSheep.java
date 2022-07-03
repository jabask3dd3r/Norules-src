package net.optifine.entity.model;

import net.minecraft.client.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.entity.passive.*;
import net.minecraft.client.model.*;

public class ModelAdapterSheep extends ModelAdapterQuadruped
{
    @Override
    public IEntityRenderer makeEntityRender(final ModelBase llllllllllllIllllllIIIIIlllIllII, final float llllllllllllIllllllIIIIIlllIIlll) {
        final RenderManager llllllllllllIllllllIIIIIlllIlIlI = Minecraft.getMinecraft().getRenderManager();
        final RenderSheep llllllllllllIllllllIIIIIlllIlIIl = new RenderSheep(llllllllllllIllllllIIIIIlllIlIlI);
        llllllllllllIllllllIIIIIlllIlIIl.mainModel = llllllllllllIllllllIIIIIlllIllII;
        llllllllllllIllllllIIIIIlllIlIIl.shadowSize = llllllllllllIllllllIIIIIlllIIlll;
        return llllllllllllIllllllIIIIIlllIlIIl;
    }
    
    public ModelAdapterSheep() {
        super(EntitySheep.class, "sheep", 0.7f);
    }
    
    @Override
    public ModelBase makeModel() {
        return new ModelSheep2();
    }
}
