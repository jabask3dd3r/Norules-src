package net.optifine.entity.model;

import net.minecraft.client.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.model.*;
import optifine.*;
import net.minecraft.entity.boss.*;

public class ModelAdapterDragon extends ModelAdapter
{
    @Override
    public ModelBase makeModel() {
        return new ModelDragon(0.0f);
    }
    
    @Override
    public IEntityRenderer makeEntityRender(final ModelBase llllllllllllllIIlIIIIIIIIllIIllI, final float llllllllllllllIIlIIIIIIIIllIIlIl) {
        final RenderManager llllllllllllllIIlIIIIIIIIllIIlII = Minecraft.getMinecraft().getRenderManager();
        final RenderDragon llllllllllllllIIlIIIIIIIIllIIIll = new RenderDragon(llllllllllllllIIlIIIIIIIIllIIlII);
        llllllllllllllIIlIIIIIIIIllIIIll.mainModel = llllllllllllllIIlIIIIIIIIllIIllI;
        llllllllllllllIIlIIIIIIIIllIIIll.shadowSize = llllllllllllllIIlIIIIIIIIllIIlIl;
        return llllllllllllllIIlIIIIIIIIllIIIll;
    }
    
    @Override
    public ModelRenderer getModelRenderer(final ModelBase llllllllllllllIIlIIIIIIIIlllIIIl, final String llllllllllllllIIlIIIIIIIIllIllIl) {
        if (!(llllllllllllllIIlIIIIIIIIlllIIIl instanceof ModelDragon)) {
            return null;
        }
        final ModelDragon llllllllllllllIIlIIIIIIIIllIllll = (ModelDragon)llllllllllllllIIlIIIIIIIIlllIIIl;
        if (llllllllllllllIIlIIIIIIIIllIllIl.equals("head")) {
            return (ModelRenderer)Reflector.getFieldValue(llllllllllllllIIlIIIIIIIIllIllll, Reflector.ModelDragon_ModelRenderers, 0);
        }
        if (llllllllllllllIIlIIIIIIIIllIllIl.equals("spine")) {
            return (ModelRenderer)Reflector.getFieldValue(llllllllllllllIIlIIIIIIIIllIllll, Reflector.ModelDragon_ModelRenderers, 1);
        }
        if (llllllllllllllIIlIIIIIIIIllIllIl.equals("jaw")) {
            return (ModelRenderer)Reflector.getFieldValue(llllllllllllllIIlIIIIIIIIllIllll, Reflector.ModelDragon_ModelRenderers, 2);
        }
        if (llllllllllllllIIlIIIIIIIIllIllIl.equals("body")) {
            return (ModelRenderer)Reflector.getFieldValue(llllllllllllllIIlIIIIIIIIllIllll, Reflector.ModelDragon_ModelRenderers, 3);
        }
        if (llllllllllllllIIlIIIIIIIIllIllIl.equals("rear_leg")) {
            return (ModelRenderer)Reflector.getFieldValue(llllllllllllllIIlIIIIIIIIllIllll, Reflector.ModelDragon_ModelRenderers, 4);
        }
        if (llllllllllllllIIlIIIIIIIIllIllIl.equals("front_leg")) {
            return (ModelRenderer)Reflector.getFieldValue(llllllllllllllIIlIIIIIIIIllIllll, Reflector.ModelDragon_ModelRenderers, 5);
        }
        if (llllllllllllllIIlIIIIIIIIllIllIl.equals("rear_leg_tip")) {
            return (ModelRenderer)Reflector.getFieldValue(llllllllllllllIIlIIIIIIIIllIllll, Reflector.ModelDragon_ModelRenderers, 6);
        }
        if (llllllllllllllIIlIIIIIIIIllIllIl.equals("front_leg_tip")) {
            return (ModelRenderer)Reflector.getFieldValue(llllllllllllllIIlIIIIIIIIllIllll, Reflector.ModelDragon_ModelRenderers, 7);
        }
        if (llllllllllllllIIlIIIIIIIIllIllIl.equals("rear_foot")) {
            return (ModelRenderer)Reflector.getFieldValue(llllllllllllllIIlIIIIIIIIllIllll, Reflector.ModelDragon_ModelRenderers, 8);
        }
        if (llllllllllllllIIlIIIIIIIIllIllIl.equals("front_foot")) {
            return (ModelRenderer)Reflector.getFieldValue(llllllllllllllIIlIIIIIIIIllIllll, Reflector.ModelDragon_ModelRenderers, 9);
        }
        if (llllllllllllllIIlIIIIIIIIllIllIl.equals("wing")) {
            return (ModelRenderer)Reflector.getFieldValue(llllllllllllllIIlIIIIIIIIllIllll, Reflector.ModelDragon_ModelRenderers, 10);
        }
        return llllllllllllllIIlIIIIIIIIllIllIl.equals("wing_tip") ? ((ModelRenderer)Reflector.getFieldValue(llllllllllllllIIlIIIIIIIIllIllll, Reflector.ModelDragon_ModelRenderers, 11)) : null;
    }
    
    public ModelAdapterDragon() {
        super(EntityDragon.class, "dragon", 0.5f);
    }
}
