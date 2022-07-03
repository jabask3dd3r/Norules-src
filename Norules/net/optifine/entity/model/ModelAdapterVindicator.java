package net.optifine.entity.model;

import net.minecraft.client.model.*;
import net.minecraft.entity.monster.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.entity.*;

public class ModelAdapterVindicator extends ModelAdapterIllager
{
    @Override
    public ModelBase makeModel() {
        return new ModelIllager(0.0f, 0.0f, 64, 64);
    }
    
    public ModelAdapterVindicator() {
        super(EntityVindicator.class, "vindication_illager", 0.5f);
    }
    
    @Override
    public IEntityRenderer makeEntityRender(final ModelBase lllllllllllllllIlIllIlIllllIIlII, final float lllllllllllllllIlIllIlIllllIIIll) {
        final RenderManager lllllllllllllllIlIllIlIllllIIllI = Minecraft.getMinecraft().getRenderManager();
        final RenderVindicator lllllllllllllllIlIllIlIllllIIlIl = new RenderVindicator(lllllllllllllllIlIllIlIllllIIllI);
        lllllllllllllllIlIllIlIllllIIlIl.mainModel = lllllllllllllllIlIllIlIllllIIlII;
        lllllllllllllllIlIllIlIllllIIlIl.shadowSize = lllllllllllllllIlIllIlIllllIIIll;
        return lllllllllllllllIlIllIlIllllIIlIl;
    }
}
