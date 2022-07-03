package net.optifine.entity.model;

import net.minecraft.client.*;
import net.minecraft.client.renderer.entity.*;
import java.util.*;
import net.minecraft.entity.passive.*;
import net.minecraft.client.model.*;
import optifine.*;

public class ModelAdapterOcelot extends ModelAdapter
{
    private static /* synthetic */ Map<String, Integer> mapPartFields;
    
    @Override
    public IEntityRenderer makeEntityRender(final ModelBase llllllllllllllllIllIIIllIlIIIlll, final float llllllllllllllllIllIIIllIlIIlIlI) {
        final RenderManager llllllllllllllllIllIIIllIlIIlIIl = Minecraft.getMinecraft().getRenderManager();
        final RenderOcelot llllllllllllllllIllIIIllIlIIlIII = new RenderOcelot(llllllllllllllllIllIIIllIlIIlIIl);
        llllllllllllllllIllIIIllIlIIlIII.mainModel = llllllllllllllllIllIIIllIlIIIlll;
        llllllllllllllllIllIIIllIlIIlIII.shadowSize = llllllllllllllllIllIIIllIlIIlIlI;
        return llllllllllllllllIllIIIllIlIIlIII;
    }
    
    private static Map<String, Integer> getMapPartFields() {
        if (ModelAdapterOcelot.mapPartFields != null) {
            return ModelAdapterOcelot.mapPartFields;
        }
        (ModelAdapterOcelot.mapPartFields = new HashMap<String, Integer>()).put("back_left_leg", 0);
        ModelAdapterOcelot.mapPartFields.put("back_right_leg", 1);
        ModelAdapterOcelot.mapPartFields.put("front_left_leg", 2);
        ModelAdapterOcelot.mapPartFields.put("front_right_leg", 3);
        ModelAdapterOcelot.mapPartFields.put("tail", 4);
        ModelAdapterOcelot.mapPartFields.put("tail2", 5);
        ModelAdapterOcelot.mapPartFields.put("head", 6);
        ModelAdapterOcelot.mapPartFields.put("body", 7);
        return ModelAdapterOcelot.mapPartFields;
    }
    
    public ModelAdapterOcelot() {
        super(EntityOcelot.class, "ocelot", 0.4f);
    }
    
    static {
        ModelAdapterOcelot.mapPartFields = null;
    }
    
    @Override
    public ModelRenderer getModelRenderer(final ModelBase llllllllllllllllIllIIIllIllIlIll, final String llllllllllllllllIllIIIllIlIlllIl) {
        if (!(llllllllllllllllIllIIIllIllIlIll instanceof ModelOcelot)) {
            return null;
        }
        final ModelOcelot llllllllllllllllIllIIIllIllIIlIl = (ModelOcelot)llllllllllllllllIllIIIllIllIlIll;
        final Map<String, Integer> llllllllllllllllIllIIIllIllIIIll = getMapPartFields();
        if (llllllllllllllllIllIIIllIllIIIll.containsKey(llllllllllllllllIllIIIllIlIlllIl)) {
            final int llllllllllllllllIllIIIllIllIIIIl = llllllllllllllllIllIIIllIllIIIll.get(llllllllllllllllIllIIIllIlIlllIl);
            return (ModelRenderer)Reflector.getFieldValue(llllllllllllllllIllIIIllIllIIlIl, Reflector.ModelOcelot_ModelRenderers, llllllllllllllllIllIIIllIllIIIIl);
        }
        return null;
    }
    
    @Override
    public ModelBase makeModel() {
        return new ModelOcelot();
    }
}
