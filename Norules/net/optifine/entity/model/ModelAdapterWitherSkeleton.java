package net.optifine.entity.model;

import net.minecraft.client.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.entity.monster.*;
import net.minecraft.client.model.*;

public class ModelAdapterWitherSkeleton extends ModelAdapterBiped
{
    @Override
    public IEntityRenderer makeEntityRender(final ModelBase lIlIIIIIIlIlII, final float lIlIIIIIIlIlll) {
        final RenderManager lIlIIIIIIlIllI = Minecraft.getMinecraft().getRenderManager();
        final RenderWitherSkeleton lIlIIIIIIlIlIl = new RenderWitherSkeleton(lIlIIIIIIlIllI);
        lIlIIIIIIlIlIl.mainModel = lIlIIIIIIlIlII;
        lIlIIIIIIlIlIl.shadowSize = lIlIIIIIIlIlll;
        return lIlIIIIIIlIlIl;
    }
    
    public ModelAdapterWitherSkeleton() {
        super(EntityWitherSkeleton.class, "wither_skeleton", 0.7f);
    }
    
    @Override
    public ModelBase makeModel() {
        return new ModelSkeleton();
    }
}
