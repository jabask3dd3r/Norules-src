package net.optifine.entity.model;

import net.minecraft.entity.passive.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.model.*;

public class ModelAdapterMooshroom extends ModelAdapterQuadruped
{
    public ModelAdapterMooshroom() {
        super(EntityMooshroom.class, "mooshroom", 0.7f);
    }
    
    @Override
    public IEntityRenderer makeEntityRender(final ModelBase llllllllllllllllIllIllllIIIIlIII, final float llllllllllllllllIllIllllIIIIIIll) {
        final RenderManager llllllllllllllllIllIllllIIIIIllI = Minecraft.getMinecraft().getRenderManager();
        final RenderMooshroom llllllllllllllllIllIllllIIIIIlIl = new RenderMooshroom(llllllllllllllllIllIllllIIIIIllI);
        llllllllllllllllIllIllllIIIIIlIl.mainModel = llllllllllllllllIllIllllIIIIlIII;
        llllllllllllllllIllIllllIIIIIlIl.shadowSize = llllllllllllllllIllIllllIIIIIIll;
        return llllllllllllllllIllIllllIIIIIlIl;
    }
    
    @Override
    public ModelBase makeModel() {
        return new ModelCow();
    }
}
