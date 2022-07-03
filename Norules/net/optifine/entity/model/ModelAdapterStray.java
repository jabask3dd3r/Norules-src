package net.optifine.entity.model;

import net.minecraft.client.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.monster.*;

public class ModelAdapterStray extends ModelAdapterBiped
{
    @Override
    public IEntityRenderer makeEntityRender(final ModelBase lllllllllllllIIlIlIIlIIllIllllII, final float lllllllllllllIIlIlIIlIIllIllIlll) {
        final RenderManager lllllllllllllIIlIlIIlIIllIlllIlI = Minecraft.getMinecraft().getRenderManager();
        final RenderStray lllllllllllllIIlIlIIlIIllIlllIIl = new RenderStray(lllllllllllllIIlIlIIlIIllIlllIlI);
        lllllllllllllIIlIlIIlIIllIlllIIl.mainModel = lllllllllllllIIlIlIIlIIllIllllII;
        lllllllllllllIIlIlIIlIIllIlllIIl.shadowSize = lllllllllllllIIlIlIIlIIllIllIlll;
        return lllllllllllllIIlIlIIlIIllIlllIIl;
    }
    
    @Override
    public ModelBase makeModel() {
        return new ModelSkeleton();
    }
    
    public ModelAdapterStray() {
        super(EntityStray.class, "stray", 0.7f);
    }
}
