package net.optifine.entity.model;

import net.minecraft.entity.passive.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.model.*;

public class ModelAdapterCow extends ModelAdapterQuadruped
{
    public ModelAdapterCow() {
        super(EntityCow.class, "cow", 0.7f);
    }
    
    @Override
    public IEntityRenderer makeEntityRender(final ModelBase lllllllllllllIIIlIlIlIlIllIIIlll, final float lllllllllllllIIIlIlIlIlIllIIIllI) {
        final RenderManager lllllllllllllIIIlIlIlIlIllIIIlIl = Minecraft.getMinecraft().getRenderManager();
        final RenderCow lllllllllllllIIIlIlIlIlIllIIIlII = new RenderCow(lllllllllllllIIIlIlIlIlIllIIIlIl);
        lllllllllllllIIIlIlIlIlIllIIIlII.mainModel = lllllllllllllIIIlIlIlIlIllIIIlll;
        lllllllllllllIIIlIlIlIlIllIIIlII.shadowSize = lllllllllllllIIIlIlIlIlIllIIIllI;
        return lllllllllllllIIIlIlIlIlIllIIIlII;
    }
    
    @Override
    public ModelBase makeModel() {
        return new ModelCow();
    }
}
