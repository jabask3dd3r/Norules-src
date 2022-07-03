package net.optifine.entity.model;

import net.minecraft.client.*;
import optifine.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class ModelAdapterLeadKnot extends ModelAdapter
{
    @Override
    public IEntityRenderer makeEntityRender(final ModelBase llllllllllllllIlIIIllllIlIIIIIIl, final float llllllllllllllIlIIIllllIlIIIIIII) {
        final RenderManager llllllllllllllIlIIIllllIlIIIIIll = Minecraft.getMinecraft().getRenderManager();
        final RenderLeashKnot llllllllllllllIlIIIllllIlIIIIIlI = new RenderLeashKnot(llllllllllllllIlIIIllllIlIIIIIll);
        if (!Reflector.RenderLeashKnot_leashKnotModel.exists()) {
            Config.warn("Field not found: RenderLeashKnot.leashKnotModel");
            return null;
        }
        Reflector.setFieldValue(llllllllllllllIlIIIllllIlIIIIIlI, Reflector.RenderLeashKnot_leashKnotModel, llllllllllllllIlIIIllllIlIIIIIIl);
        llllllllllllllIlIIIllllIlIIIIIlI.shadowSize = llllllllllllllIlIIIllllIlIIIIIII;
        return llllllllllllllIlIIIllllIlIIIIIlI;
    }
    
    @Override
    public ModelBase makeModel() {
        return new ModelLeashKnot();
    }
    
    @Override
    public ModelRenderer getModelRenderer(final ModelBase llllllllllllllIlIIIllllIlIIIllIl, final String llllllllllllllIlIIIllllIlIIIllll) {
        if (!(llllllllllllllIlIIIllllIlIIIllIl instanceof ModelLeashKnot)) {
            return null;
        }
        final ModelLeashKnot llllllllllllllIlIIIllllIlIIIlllI = (ModelLeashKnot)llllllllllllllIlIIIllllIlIIIllIl;
        return llllllllllllllIlIIIllllIlIIIllll.equals("knot") ? llllllllllllllIlIIIllllIlIIIlllI.knotRenderer : null;
    }
    
    public ModelAdapterLeadKnot() {
        super(EntityLeashKnot.class, "lead_knot", 0.0f);
    }
}
