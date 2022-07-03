package net.optifine.entity.model;

import net.minecraft.client.model.*;
import net.minecraft.entity.passive.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.entity.*;

public class ModelAdapterPig extends ModelAdapterQuadruped
{
    @Override
    public ModelBase makeModel() {
        return new ModelPig();
    }
    
    public ModelAdapterPig() {
        super(EntityPig.class, "pig", 0.7f);
    }
    
    @Override
    public IEntityRenderer makeEntityRender(final ModelBase lllIlIIllIlIIll, final float lllIlIIllIlIIlI) {
        final RenderManager lllIlIIllIlIIIl = Minecraft.getMinecraft().getRenderManager();
        final RenderPig lllIlIIllIlIIII = new RenderPig(lllIlIIllIlIIIl);
        lllIlIIllIlIIII.mainModel = lllIlIIllIlIIll;
        lllIlIIllIlIIII.shadowSize = lllIlIIllIlIIlI;
        return lllIlIIllIlIIII;
    }
}
