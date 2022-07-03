package net.optifine.entity.model;

import net.minecraft.client.model.*;
import net.minecraft.entity.monster.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.entity.*;

public class ModelAdapterPolarBear extends ModelAdapterQuadruped
{
    @Override
    public ModelBase makeModel() {
        return new ModelPolarBear();
    }
    
    public ModelAdapterPolarBear() {
        super(EntityPolarBear.class, "polar_bear", 0.7f);
    }
    
    @Override
    public IEntityRenderer makeEntityRender(final ModelBase lllllllllllllIIIIIlIlIlIllIIIIll, final float lllllllllllllIIIIIlIlIlIllIIIIlI) {
        final RenderManager lllllllllllllIIIIIlIlIlIllIIIIIl = Minecraft.getMinecraft().getRenderManager();
        final RenderPolarBear lllllllllllllIIIIIlIlIlIllIIIIII = new RenderPolarBear(lllllllllllllIIIIIlIlIlIllIIIIIl);
        lllllllllllllIIIIIlIlIlIllIIIIII.mainModel = lllllllllllllIIIIIlIlIlIllIIIIll;
        lllllllllllllIIIIIlIlIlIllIIIIII.shadowSize = lllllllllllllIIIIIlIlIlIllIIIIlI;
        return lllllllllllllIIIIIlIlIlIllIIIIII;
    }
}
