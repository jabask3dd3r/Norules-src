package net.optifine.entity.model;

import net.minecraft.client.*;
import net.minecraft.client.renderer.entity.*;
import java.util.*;
import net.minecraft.client.model.*;
import optifine.*;
import net.minecraft.entity.passive.*;

public class ModelAdapterHorse extends ModelAdapter
{
    private static /* synthetic */ Map<String, Integer> mapPartFields;
    
    protected ModelAdapterHorse(final Class lllllllllllllllIlIllIIIllIIIIlIl, final String lllllllllllllllIlIllIIIllIIIIIll, final float lllllllllllllllIlIllIIIllIIIIlll) {
        super(lllllllllllllllIlIllIIIllIIIIlIl, lllllllllllllllIlIllIIIllIIIIIll, lllllllllllllllIlIllIIIllIIIIlll);
    }
    
    static {
        ModelAdapterHorse.mapPartFields = null;
    }
    
    @Override
    public ModelBase makeModel() {
        return new ModelHorse();
    }
    
    @Override
    public IEntityRenderer makeEntityRender(final ModelBase lllllllllllllllIlIllIIIlIlIIIlll, final float lllllllllllllllIlIllIIIlIlIIIllI) {
        final RenderManager lllllllllllllllIlIllIIIlIlIIIlII = Minecraft.getMinecraft().getRenderManager();
        final RenderHorse lllllllllllllllIlIllIIIlIlIIIIlI = new RenderHorse(lllllllllllllllIlIllIIIlIlIIIlII);
        lllllllllllllllIlIllIIIlIlIIIIlI.mainModel = lllllllllllllllIlIllIIIlIlIIIlll;
        lllllllllllllllIlIllIIIlIlIIIIlI.shadowSize = lllllllllllllllIlIllIIIlIlIIIllI;
        return lllllllllllllllIlIllIIIlIlIIIIlI;
    }
    
    private static Map<String, Integer> getMapPartFields() {
        if (ModelAdapterHorse.mapPartFields != null) {
            return ModelAdapterHorse.mapPartFields;
        }
        (ModelAdapterHorse.mapPartFields = new HashMap<String, Integer>()).put("head", 0);
        ModelAdapterHorse.mapPartFields.put("upper_mouth", 1);
        ModelAdapterHorse.mapPartFields.put("lower_mouth", 2);
        ModelAdapterHorse.mapPartFields.put("horse_left_ear", 3);
        ModelAdapterHorse.mapPartFields.put("horse_right_ear", 4);
        ModelAdapterHorse.mapPartFields.put("mule_left_ear", 5);
        ModelAdapterHorse.mapPartFields.put("mule_right_ear", 6);
        ModelAdapterHorse.mapPartFields.put("neck", 7);
        ModelAdapterHorse.mapPartFields.put("horse_face_ropes", 8);
        ModelAdapterHorse.mapPartFields.put("mane", 9);
        ModelAdapterHorse.mapPartFields.put("body", 10);
        ModelAdapterHorse.mapPartFields.put("tail_base", 11);
        ModelAdapterHorse.mapPartFields.put("tail_middle", 12);
        ModelAdapterHorse.mapPartFields.put("tail_tip", 13);
        ModelAdapterHorse.mapPartFields.put("back_left_leg", 14);
        ModelAdapterHorse.mapPartFields.put("back_left_shin", 15);
        ModelAdapterHorse.mapPartFields.put("back_left_hoof", 16);
        ModelAdapterHorse.mapPartFields.put("back_right_leg", 17);
        ModelAdapterHorse.mapPartFields.put("back_right_shin", 18);
        ModelAdapterHorse.mapPartFields.put("back_right_hoof", 19);
        ModelAdapterHorse.mapPartFields.put("front_left_leg", 20);
        ModelAdapterHorse.mapPartFields.put("front_left_shin", 21);
        ModelAdapterHorse.mapPartFields.put("front_left_hoof", 22);
        ModelAdapterHorse.mapPartFields.put("front_right_leg", 23);
        ModelAdapterHorse.mapPartFields.put("front_right_shin", 24);
        ModelAdapterHorse.mapPartFields.put("front_right_hoof", 25);
        ModelAdapterHorse.mapPartFields.put("mule_left_chest", 26);
        ModelAdapterHorse.mapPartFields.put("mule_right_chest", 27);
        ModelAdapterHorse.mapPartFields.put("horse_saddle_bottom", 28);
        ModelAdapterHorse.mapPartFields.put("horse_saddle_front", 29);
        ModelAdapterHorse.mapPartFields.put("horse_saddle_back", 30);
        ModelAdapterHorse.mapPartFields.put("horse_left_saddle_rope", 31);
        ModelAdapterHorse.mapPartFields.put("horse_left_saddle_metal", 32);
        ModelAdapterHorse.mapPartFields.put("horse_right_saddle_rope", 33);
        ModelAdapterHorse.mapPartFields.put("horse_right_saddle_metal", 34);
        ModelAdapterHorse.mapPartFields.put("horse_left_face_metal", 35);
        ModelAdapterHorse.mapPartFields.put("horse_right_face_metal", 36);
        ModelAdapterHorse.mapPartFields.put("horse_left_rein", 37);
        ModelAdapterHorse.mapPartFields.put("horse_right_rein", 38);
        return ModelAdapterHorse.mapPartFields;
    }
    
    @Override
    public ModelRenderer getModelRenderer(final ModelBase lllllllllllllllIlIllIIIlIllIllIl, final String lllllllllllllllIlIllIIIlIllIllII) {
        if (!(lllllllllllllllIlIllIIIlIllIllIl instanceof ModelHorse)) {
            return null;
        }
        final ModelHorse lllllllllllllllIlIllIIIlIlllIIll = (ModelHorse)lllllllllllllllIlIllIIIlIllIllIl;
        final Map<String, Integer> lllllllllllllllIlIllIIIlIlllIIIl = getMapPartFields();
        if (lllllllllllllllIlIllIIIlIlllIIIl.containsKey(lllllllllllllllIlIllIIIlIllIllII)) {
            final int lllllllllllllllIlIllIIIlIllIllll = lllllllllllllllIlIllIIIlIlllIIIl.get(lllllllllllllllIlIllIIIlIllIllII);
            return (ModelRenderer)Reflector.getFieldValue(lllllllllllllllIlIllIIIlIlllIIll, Reflector.ModelHorse_ModelRenderers, lllllllllllllllIlIllIIIlIllIllll);
        }
        return null;
    }
    
    public ModelAdapterHorse() {
        super(EntityHorse.class, "horse", 0.75f);
    }
}
