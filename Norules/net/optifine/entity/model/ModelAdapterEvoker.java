package net.optifine.entity.model;

import net.minecraft.entity.monster.*;
import net.minecraft.client.model.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.entity.*;

public class ModelAdapterEvoker extends ModelAdapterIllager
{
    public ModelAdapterEvoker() {
        super(EntityEvoker.class, "evocation_illager", 0.5f);
    }
    
    @Override
    public ModelBase makeModel() {
        return new ModelIllager(0.0f, 0.0f, 64, 64);
    }
    
    @Override
    public IEntityRenderer makeEntityRender(final ModelBase lllllllllllllIIlIIIIlllIIllllIlI, final float lllllllllllllIIlIIIIlllIIlllllIl) {
        final RenderManager lllllllllllllIIlIIIIlllIIlllllII = Minecraft.getMinecraft().getRenderManager();
        final RenderEvoker lllllllllllllIIlIIIIlllIIllllIll = new RenderEvoker(lllllllllllllIIlIIIIlllIIlllllII);
        lllllllllllllIIlIIIIlllIIllllIll.mainModel = lllllllllllllIIlIIIIlllIIllllIlI;
        lllllllllllllIIlIIIIlllIIllllIll.shadowSize = lllllllllllllIIlIIIIlllIIlllllIl;
        return lllllllllllllIIlIIIIlllIIllllIll;
    }
}
