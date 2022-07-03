package net.optifine.entity.model;

import net.minecraft.client.model.*;
import optifine.*;
import java.util.*;
import net.minecraft.entity.passive.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.entity.*;

public class ModelAdapterRabbit extends ModelAdapter
{
    private static /* synthetic */ Map<String, Integer> mapPartFields;
    
    static {
        ModelAdapterRabbit.mapPartFields = null;
    }
    
    @Override
    public ModelRenderer getModelRenderer(final ModelBase lIlllIlllIllll, final String lIlllIllllIIll) {
        if (!(lIlllIlllIllll instanceof ModelRabbit)) {
            return null;
        }
        final ModelRabbit lIlllIllllIIlI = (ModelRabbit)lIlllIlllIllll;
        final Map<String, Integer> lIlllIllllIIIl = getMapPartFields();
        if (lIlllIllllIIIl.containsKey(lIlllIllllIIll)) {
            final int lIlllIllllIIII = lIlllIllllIIIl.get(lIlllIllllIIll);
            return (ModelRenderer)Reflector.getFieldValue(lIlllIllllIIlI, Reflector.ModelRabbit_renderers, lIlllIllllIIII);
        }
        return null;
    }
    
    @Override
    public ModelBase makeModel() {
        return new ModelRabbit();
    }
    
    private static Map<String, Integer> getMapPartFields() {
        if (ModelAdapterRabbit.mapPartFields != null) {
            return ModelAdapterRabbit.mapPartFields;
        }
        (ModelAdapterRabbit.mapPartFields = new HashMap<String, Integer>()).put("left_foot", 0);
        ModelAdapterRabbit.mapPartFields.put("right_foot", 1);
        ModelAdapterRabbit.mapPartFields.put("left_thigh", 2);
        ModelAdapterRabbit.mapPartFields.put("right_thigh", 3);
        ModelAdapterRabbit.mapPartFields.put("body", 4);
        ModelAdapterRabbit.mapPartFields.put("left_arm", 5);
        ModelAdapterRabbit.mapPartFields.put("right_arm", 6);
        ModelAdapterRabbit.mapPartFields.put("head", 7);
        ModelAdapterRabbit.mapPartFields.put("right_ear", 8);
        ModelAdapterRabbit.mapPartFields.put("left_ear", 9);
        ModelAdapterRabbit.mapPartFields.put("tail", 10);
        ModelAdapterRabbit.mapPartFields.put("nose", 11);
        return ModelAdapterRabbit.mapPartFields;
    }
    
    public ModelAdapterRabbit() {
        super(EntityRabbit.class, "rabbit", 0.3f);
    }
    
    @Override
    public IEntityRenderer makeEntityRender(final ModelBase lIlllIlllIIIIl, final float lIlllIlllIIlII) {
        final RenderManager lIlllIlllIIIll = Minecraft.getMinecraft().getRenderManager();
        final RenderRabbit lIlllIlllIIIlI = new RenderRabbit(lIlllIlllIIIll);
        lIlllIlllIIIlI.mainModel = lIlllIlllIIIIl;
        lIlllIlllIIIlI.shadowSize = lIlllIlllIIlII;
        return lIlllIlllIIIlI;
    }
}
