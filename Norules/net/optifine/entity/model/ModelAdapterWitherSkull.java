package net.optifine.entity.model;

import net.minecraft.entity.projectile.*;
import net.minecraft.client.model.*;
import net.minecraft.client.*;
import optifine.*;
import net.minecraft.client.renderer.entity.*;

public class ModelAdapterWitherSkull extends ModelAdapter
{
    public ModelAdapterWitherSkull() {
        super(EntityWitherSkull.class, "wither_skull", 0.0f);
    }
    
    @Override
    public ModelBase makeModel() {
        return new ModelSkeletonHead();
    }
    
    @Override
    public ModelRenderer getModelRenderer(final ModelBase llllllllllllllIIlIlIIllllllIIllI, final String llllllllllllllIIlIlIIllllllIlIII) {
        if (!(llllllllllllllIIlIlIIllllllIIllI instanceof ModelSkeletonHead)) {
            return null;
        }
        final ModelSkeletonHead llllllllllllllIIlIlIIllllllIIlll = (ModelSkeletonHead)llllllllllllllIIlIlIIllllllIIllI;
        return llllllllllllllIIlIlIIllllllIlIII.equals("head") ? llllllllllllllIIlIlIIllllllIIlll.skeletonHead : null;
    }
    
    @Override
    public IEntityRenderer makeEntityRender(final ModelBase llllllllllllllIIlIlIIlllllIllIlI, final float llllllllllllllIIlIlIIlllllIllIIl) {
        final RenderManager llllllllllllllIIlIlIIlllllIlllII = Minecraft.getMinecraft().getRenderManager();
        final RenderWitherSkull llllllllllllllIIlIlIIlllllIllIll = new RenderWitherSkull(llllllllllllllIIlIlIIlllllIlllII);
        if (!Reflector.RenderWitherSkull_model.exists()) {
            Config.warn("Field not found: RenderWitherSkull_model");
            return null;
        }
        Reflector.setFieldValue(llllllllllllllIIlIlIIlllllIllIll, Reflector.RenderWitherSkull_model, llllllllllllllIIlIlIIlllllIllIlI);
        llllllllllllllIIlIlIIlllllIllIll.shadowSize = llllllllllllllIIlIlIIlllllIllIIl;
        return llllllllllllllIIlIlIIlllllIllIll;
    }
}
