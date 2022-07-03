package net.optifine.entity.model;

import net.minecraft.entity.monster.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.model.*;

public class ModelAdapterShulker extends ModelAdapter
{
    public ModelAdapterShulker() {
        super(EntityShulker.class, "shulker", 0.0f);
    }
    
    @Override
    public ModelBase makeModel() {
        return new ModelShulker();
    }
    
    @Override
    public IEntityRenderer makeEntityRender(final ModelBase llIIllIllIlIlI, final float llIIllIllIlIIl) {
        final RenderManager llIIllIllIllII = Minecraft.getMinecraft().getRenderManager();
        final RenderShulker llIIllIllIlIll = new RenderShulker(llIIllIllIllII);
        llIIllIllIlIll.mainModel = llIIllIllIlIlI;
        llIIllIllIlIll.shadowSize = llIIllIllIlIIl;
        return llIIllIllIlIll;
    }
    
    @Override
    public ModelRenderer getModelRenderer(final ModelBase llIIllIlllIllI, final String llIIllIllllIII) {
        if (!(llIIllIlllIllI instanceof ModelShulker)) {
            return null;
        }
        final ModelShulker llIIllIlllIlll = (ModelShulker)llIIllIlllIllI;
        if (llIIllIllllIII.equals("head")) {
            return llIIllIlllIlll.head;
        }
        if (llIIllIllllIII.equals("base")) {
            return llIIllIlllIlll.base;
        }
        return llIIllIllllIII.equals("lid") ? llIIllIlllIlll.lid : null;
    }
}
