package net.optifine.entity.model;

import net.minecraft.client.model.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.entity.monster.*;

public class ModelAdapterSkeleton extends ModelAdapterBiped
{
    @Override
    public ModelBase makeModel() {
        return new ModelSkeleton();
    }
    
    @Override
    public IEntityRenderer makeEntityRender(final ModelBase llllllllllllllllIlIlIllIllIIllll, final float llllllllllllllllIlIlIllIllIlIIlI) {
        final RenderManager llllllllllllllllIlIlIllIllIlIIIl = Minecraft.getMinecraft().getRenderManager();
        final RenderSkeleton llllllllllllllllIlIlIllIllIlIIII = new RenderSkeleton(llllllllllllllllIlIlIllIllIlIIIl);
        llllllllllllllllIlIlIllIllIlIIII.mainModel = llllllllllllllllIlIlIllIllIIllll;
        llllllllllllllllIlIlIllIllIlIIII.shadowSize = llllllllllllllllIlIlIllIllIlIIlI;
        return llllllllllllllllIlIlIllIllIlIIII;
    }
    
    public ModelAdapterSkeleton() {
        super(EntitySkeleton.class, "skeleton", 0.7f);
    }
}
