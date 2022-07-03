package net.optifine.entity.model;

import net.minecraft.client.model.*;
import optifine.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.entity.passive.*;

public class ModelAdapterWolf extends ModelAdapter
{
    @Override
    public ModelRenderer getModelRenderer(final ModelBase llllllllllllllIIIIIllIIlIIIllIlI, final String llllllllllllllIIIIIllIIlIIIllIIl) {
        if (!(llllllllllllllIIIIIllIIlIIIllIlI instanceof ModelWolf)) {
            return null;
        }
        final ModelWolf llllllllllllllIIIIIllIIlIIIllIII = (ModelWolf)llllllllllllllIIIIIllIIlIIIllIlI;
        if (llllllllllllllIIIIIllIIlIIIllIIl.equals("head")) {
            return llllllllllllllIIIIIllIIlIIIllIII.wolfHeadMain;
        }
        if (llllllllllllllIIIIIllIIlIIIllIIl.equals("body")) {
            return llllllllllllllIIIIIllIIlIIIllIII.wolfBody;
        }
        if (llllllllllllllIIIIIllIIlIIIllIIl.equals("leg1")) {
            return llllllllllllllIIIIIllIIlIIIllIII.wolfLeg1;
        }
        if (llllllllllllllIIIIIllIIlIIIllIIl.equals("leg2")) {
            return llllllllllllllIIIIIllIIlIIIllIII.wolfLeg2;
        }
        if (llllllllllllllIIIIIllIIlIIIllIIl.equals("leg3")) {
            return llllllllllllllIIIIIllIIlIIIllIII.wolfLeg3;
        }
        if (llllllllllllllIIIIIllIIlIIIllIIl.equals("leg4")) {
            return llllllllllllllIIIIIllIIlIIIllIII.wolfLeg4;
        }
        if (llllllllllllllIIIIIllIIlIIIllIIl.equals("tail")) {
            return (ModelRenderer)Reflector.getFieldValue(llllllllllllllIIIIIllIIlIIIllIII, Reflector.ModelWolf_tail);
        }
        return llllllllllllllIIIIIllIIlIIIllIIl.equals("mane") ? ((ModelRenderer)Reflector.getFieldValue(llllllllllllllIIIIIllIIlIIIllIII, Reflector.ModelWolf_mane)) : null;
    }
    
    @Override
    public IEntityRenderer makeEntityRender(final ModelBase llllllllllllllIIIIIllIIlIIIIlIll, final float llllllllllllllIIIIIllIIlIIIIlIlI) {
        final RenderManager llllllllllllllIIIIIllIIlIIIIllIl = Minecraft.getMinecraft().getRenderManager();
        final RenderWolf llllllllllllllIIIIIllIIlIIIIllII = new RenderWolf(llllllllllllllIIIIIllIIlIIIIllIl);
        llllllllllllllIIIIIllIIlIIIIllII.mainModel = llllllllllllllIIIIIllIIlIIIIlIll;
        llllllllllllllIIIIIllIIlIIIIllII.shadowSize = llllllllllllllIIIIIllIIlIIIIlIlI;
        return llllllllllllllIIIIIllIIlIIIIllII;
    }
    
    public ModelAdapterWolf() {
        super(EntityWolf.class, "wolf", 0.5f);
    }
    
    @Override
    public ModelBase makeModel() {
        return new ModelWolf();
    }
}
