package net.optifine.entity.model;

import net.minecraft.client.model.*;
import optifine.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.entity.monster.*;

public class ModelAdapterSlime extends ModelAdapter
{
    @Override
    public ModelBase makeModel() {
        return new ModelSlime(16);
    }
    
    @Override
    public ModelRenderer getModelRenderer(final ModelBase lllllllllllllllIllllllIIlIllllll, final String lllllllllllllllIllllllIIlIlllllI) {
        if (!(lllllllllllllllIllllllIIlIllllll instanceof ModelSlime)) {
            return null;
        }
        final ModelSlime lllllllllllllllIllllllIIlIllllII = (ModelSlime)lllllllllllllllIllllllIIlIllllll;
        if (lllllllllllllllIllllllIIlIlllllI.equals("body")) {
            return (ModelRenderer)Reflector.getFieldValue(lllllllllllllllIllllllIIlIllllII, Reflector.ModelSlime_ModelRenderers, 0);
        }
        if (lllllllllllllllIllllllIIlIlllllI.equals("left_eye")) {
            return (ModelRenderer)Reflector.getFieldValue(lllllllllllllllIllllllIIlIllllII, Reflector.ModelSlime_ModelRenderers, 1);
        }
        if (lllllllllllllllIllllllIIlIlllllI.equals("right_eye")) {
            return (ModelRenderer)Reflector.getFieldValue(lllllllllllllllIllllllIIlIllllII, Reflector.ModelSlime_ModelRenderers, 2);
        }
        return lllllllllllllllIllllllIIlIlllllI.equals("mouth") ? ((ModelRenderer)Reflector.getFieldValue(lllllllllllllllIllllllIIlIllllII, Reflector.ModelSlime_ModelRenderers, 3)) : null;
    }
    
    @Override
    public IEntityRenderer makeEntityRender(final ModelBase lllllllllllllllIllllllIIlIIllllI, final float lllllllllllllllIllllllIIlIlIIlII) {
        final RenderManager lllllllllllllllIllllllIIlIlIIIlI = Minecraft.getMinecraft().getRenderManager();
        final RenderSlime lllllllllllllllIllllllIIlIlIIIII = new RenderSlime(lllllllllllllllIllllllIIlIlIIIlI);
        lllllllllllllllIllllllIIlIlIIIII.mainModel = lllllllllllllllIllllllIIlIIllllI;
        lllllllllllllllIllllllIIlIlIIIII.shadowSize = lllllllllllllllIllllllIIlIlIIlII;
        return lllllllllllllllIllllllIIlIlIIIII;
    }
    
    public ModelAdapterSlime() {
        super(EntitySlime.class, "slime", 0.25f);
    }
}
