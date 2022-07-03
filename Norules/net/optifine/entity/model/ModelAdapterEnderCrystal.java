package net.optifine.entity.model;

import net.minecraft.entity.item.*;
import net.minecraft.client.model.*;
import net.minecraft.client.*;
import optifine.*;
import net.minecraft.client.renderer.entity.*;

public class ModelAdapterEnderCrystal extends ModelAdapter
{
    protected ModelAdapterEnderCrystal(final String lllllllllllllIlllIllIlIllllIIllI) {
        super(EntityEnderCrystal.class, lllllllllllllIlllIllIlIllllIIllI, 0.5f);
    }
    
    @Override
    public ModelRenderer getModelRenderer(final ModelBase lllllllllllllIlllIllIlIllIIlIllI, final String lllllllllllllIlllIllIlIllIIlIIll) {
        if (!(lllllllllllllIlllIllIlIllIIlIllI instanceof ModelEnderCrystal)) {
            return null;
        }
        final ModelEnderCrystal lllllllllllllIlllIllIlIllIIllIII = (ModelEnderCrystal)lllllllllllllIlllIllIlIllIIlIllI;
        if (lllllllllllllIlllIllIlIllIIlIIll.equals("cube")) {
            return (ModelRenderer)Reflector.getFieldValue(lllllllllllllIlllIllIlIllIIllIII, Reflector.ModelEnderCrystal_ModelRenderers, 0);
        }
        if (lllllllllllllIlllIllIlIllIIlIIll.equals("glass")) {
            return (ModelRenderer)Reflector.getFieldValue(lllllllllllllIlllIllIlIllIIllIII, Reflector.ModelEnderCrystal_ModelRenderers, 1);
        }
        return lllllllllllllIlllIllIlIllIIlIIll.equals("base") ? ((ModelRenderer)Reflector.getFieldValue(lllllllllllllIlllIllIlIllIIllIII, Reflector.ModelEnderCrystal_ModelRenderers, 2)) : null;
    }
    
    @Override
    public ModelBase makeModel() {
        return new ModelEnderCrystal(0.0f, true);
    }
    
    public ModelAdapterEnderCrystal() {
        this("end_crystal");
    }
    
    @Override
    public IEntityRenderer makeEntityRender(final ModelBase lllllllllllllIlllIllIlIllIIIIlII, final float lllllllllllllIlllIllIlIllIIIIIll) {
        final RenderManager lllllllllllllIlllIllIlIllIIIIIlI = Minecraft.getMinecraft().getRenderManager();
        final Render lllllllllllllIlllIllIlIllIIIIIIl = lllllllllllllIlllIllIlIllIIIIIlI.getEntityRenderMap().get(EntityEnderCrystal.class);
        if (!(lllllllllllllIlllIllIlIllIIIIIIl instanceof RenderEnderCrystal)) {
            Config.warn(String.valueOf(new StringBuilder("Not an instance of RenderEnderCrystal: ").append(lllllllllllllIlllIllIlIllIIIIIIl)));
            return null;
        }
        final RenderEnderCrystal lllllllllllllIlllIllIlIllIIIIIII = (RenderEnderCrystal)lllllllllllllIlllIllIlIllIIIIIIl;
        if (!Reflector.RenderEnderCrystal_modelEnderCrystal.exists()) {
            Config.warn("Field not found: RenderEnderCrystal.modelEnderCrystal");
            return null;
        }
        Reflector.setFieldValue(lllllllllllllIlllIllIlIllIIIIIII, Reflector.RenderEnderCrystal_modelEnderCrystal, lllllllllllllIlllIllIlIllIIIIlII);
        lllllllllllllIlllIllIlIllIIIIIII.shadowSize = lllllllllllllIlllIllIlIllIIIIIll;
        return lllllllllllllIlllIllIlIllIIIIIII;
    }
}
