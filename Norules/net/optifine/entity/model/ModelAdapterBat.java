package net.optifine.entity.model;

import net.minecraft.client.model.*;
import optifine.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.entity.passive.*;

public class ModelAdapterBat extends ModelAdapter
{
    @Override
    public ModelBase makeModel() {
        return new ModelBat();
    }
    
    @Override
    public ModelRenderer getModelRenderer(final ModelBase lllllllllllllllIlIlIlIIIIlIlllII, final String lllllllllllllllIlIlIlIIIIlIllIII) {
        if (!(lllllllllllllllIlIlIlIIIIlIlllII instanceof ModelBat)) {
            return null;
        }
        final ModelBat lllllllllllllllIlIlIlIIIIlIllIlI = (ModelBat)lllllllllllllllIlIlIlIIIIlIlllII;
        if (lllllllllllllllIlIlIlIIIIlIllIII.equals("head")) {
            return (ModelRenderer)Reflector.getFieldValue(lllllllllllllllIlIlIlIIIIlIllIlI, Reflector.ModelBat_ModelRenderers, 0);
        }
        if (lllllllllllllllIlIlIlIIIIlIllIII.equals("body")) {
            return (ModelRenderer)Reflector.getFieldValue(lllllllllllllllIlIlIlIIIIlIllIlI, Reflector.ModelBat_ModelRenderers, 1);
        }
        if (lllllllllllllllIlIlIlIIIIlIllIII.equals("right_wing")) {
            return (ModelRenderer)Reflector.getFieldValue(lllllllllllllllIlIlIlIIIIlIllIlI, Reflector.ModelBat_ModelRenderers, 2);
        }
        if (lllllllllllllllIlIlIlIIIIlIllIII.equals("left_wing")) {
            return (ModelRenderer)Reflector.getFieldValue(lllllllllllllllIlIlIlIIIIlIllIlI, Reflector.ModelBat_ModelRenderers, 3);
        }
        if (lllllllllllllllIlIlIlIIIIlIllIII.equals("outer_right_wing")) {
            return (ModelRenderer)Reflector.getFieldValue(lllllllllllllllIlIlIlIIIIlIllIlI, Reflector.ModelBat_ModelRenderers, 4);
        }
        return lllllllllllllllIlIlIlIIIIlIllIII.equals("outer_left_wing") ? ((ModelRenderer)Reflector.getFieldValue(lllllllllllllllIlIlIlIIIIlIllIlI, Reflector.ModelBat_ModelRenderers, 5)) : null;
    }
    
    @Override
    public IEntityRenderer makeEntityRender(final ModelBase lllllllllllllllIlIlIlIIIIlIlIIIl, final float lllllllllllllllIlIlIlIIIIlIlIIII) {
        final RenderManager lllllllllllllllIlIlIlIIIIlIIllll = Minecraft.getMinecraft().getRenderManager();
        final RenderBat lllllllllllllllIlIlIlIIIIlIIlllI = new RenderBat(lllllllllllllllIlIlIlIIIIlIIllll);
        lllllllllllllllIlIlIlIIIIlIIlllI.mainModel = lllllllllllllllIlIlIlIIIIlIlIIIl;
        lllllllllllllllIlIlIlIIIIlIIlllI.shadowSize = lllllllllllllllIlIlIlIIIIlIlIIII;
        return lllllllllllllllIlIlIlIIIIlIIlllI;
    }
    
    public ModelAdapterBat() {
        super(EntityBat.class, "bat", 0.25f);
    }
}
