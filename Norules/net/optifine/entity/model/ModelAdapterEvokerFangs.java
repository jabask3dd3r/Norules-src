package net.optifine.entity.model;

import net.minecraft.client.model.*;
import net.minecraft.client.*;
import optifine.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.entity.projectile.*;

public class ModelAdapterEvokerFangs extends ModelAdapter
{
    @Override
    public ModelRenderer getModelRenderer(final ModelBase lllllllllllllIIlIIlIllIlIlllIlll, final String lllllllllllllIIlIIlIllIlIlllIllI) {
        if (!(lllllllllllllIIlIIlIllIlIlllIlll instanceof ModelEvokerFangs)) {
            return null;
        }
        final ModelEvokerFangs lllllllllllllIIlIIlIllIlIllllIII = (ModelEvokerFangs)lllllllllllllIIlIIlIllIlIlllIlll;
        if (lllllllllllllIIlIIlIllIlIlllIllI.equals("base")) {
            return (ModelRenderer)Reflector.getFieldValue(lllllllllllllIIlIIlIllIlIllllIII, Reflector.ModelEvokerFangs_ModelRenderers, 0);
        }
        if (lllllllllllllIIlIIlIllIlIlllIllI.equals("upper_jaw")) {
            return (ModelRenderer)Reflector.getFieldValue(lllllllllllllIIlIIlIllIlIllllIII, Reflector.ModelEvokerFangs_ModelRenderers, 1);
        }
        return lllllllllllllIIlIIlIllIlIlllIllI.equals("lower_jaw") ? ((ModelRenderer)Reflector.getFieldValue(lllllllllllllIIlIIlIllIlIllllIII, Reflector.ModelEvokerFangs_ModelRenderers, 2)) : null;
    }
    
    @Override
    public ModelBase makeModel() {
        return new ModelEvokerFangs();
    }
    
    @Override
    public IEntityRenderer makeEntityRender(final ModelBase lllllllllllllIIlIIlIllIlIllIlIll, final float lllllllllllllIIlIIlIllIlIllIlIlI) {
        final RenderManager lllllllllllllIIlIIlIllIlIllIllIl = Minecraft.getMinecraft().getRenderManager();
        final RenderEvokerFangs lllllllllllllIIlIIlIllIlIllIllII = new RenderEvokerFangs(lllllllllllllIIlIIlIllIlIllIllIl);
        if (!Reflector.RenderEvokerFangs_model.exists()) {
            Config.warn("Field not found: RenderEvokerFangs.model");
            return null;
        }
        Reflector.setFieldValue(lllllllllllllIIlIIlIllIlIllIllII, Reflector.RenderEvokerFangs_model, lllllllllllllIIlIIlIllIlIllIlIll);
        lllllllllllllIIlIIlIllIlIllIllII.shadowSize = lllllllllllllIIlIIlIllIlIllIlIlI;
        return lllllllllllllIIlIIlIllIlIllIllII;
    }
    
    public ModelAdapterEvokerFangs() {
        super(EntityEvokerFangs.class, "evocation_fangs", 0.0f);
    }
}
