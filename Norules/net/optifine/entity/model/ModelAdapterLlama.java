package net.optifine.entity.model;

import net.minecraft.entity.passive.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.model.*;

public class ModelAdapterLlama extends ModelAdapterQuadruped
{
    public ModelAdapterLlama() {
        super(EntityLlama.class, "llama", 0.7f);
    }
    
    @Override
    public IEntityRenderer makeEntityRender(final ModelBase llllllllllllllIIlllIIIIIllllllIl, final float llllllllllllllIIlllIIIIlIIIIIIII) {
        final RenderManager llllllllllllllIIlllIIIIIllllllll = Minecraft.getMinecraft().getRenderManager();
        final RenderLlama llllllllllllllIIlllIIIIIlllllllI = new RenderLlama(llllllllllllllIIlllIIIIIllllllll);
        llllllllllllllIIlllIIIIIlllllllI.mainModel = llllllllllllllIIlllIIIIIllllllIl;
        llllllllllllllIIlllIIIIIlllllllI.shadowSize = llllllllllllllIIlllIIIIlIIIIIIII;
        return llllllllllllllIIlllIIIIIlllllllI;
    }
    
    @Override
    public ModelBase makeModel() {
        return new ModelLlama(0.0f);
    }
}
