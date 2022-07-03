package net.optifine.entity.model;

import net.minecraft.entity.monster.*;
import net.minecraft.client.model.*;
import optifine.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.entity.*;

public class ModelAdapterVex extends ModelAdapterBiped
{
    @Override
    public ModelBase makeModel() {
        return new ModelVex();
    }
    
    public ModelAdapterVex() {
        super(EntityVex.class, "vex", 0.3f);
    }
    
    @Override
    public ModelRenderer getModelRenderer(final ModelBase llllllllllllllIIllIIllllIIIIIIll, final String llllllllllllllIIllIIllllIIIIIIlI) {
        if (!(llllllllllllllIIllIIllllIIIIIIll instanceof ModelVex)) {
            return null;
        }
        final ModelRenderer llllllllllllllIIllIIllllIIIIIllI = super.getModelRenderer(llllllllllllllIIllIIllllIIIIIIll, llllllllllllllIIllIIllllIIIIIIlI);
        if (llllllllllllllIIllIIllllIIIIIllI != null) {
            return llllllllllllllIIllIIllllIIIIIllI;
        }
        final ModelVex llllllllllllllIIllIIllllIIIIIlIl = (ModelVex)llllllllllllllIIllIIllllIIIIIIll;
        if (llllllllllllllIIllIIllllIIIIIIlI.equals("left_wing")) {
            return (ModelRenderer)Reflector.getFieldValue(llllllllllllllIIllIIllllIIIIIlIl, Reflector.ModelVex_leftWing);
        }
        return llllllllllllllIIllIIllllIIIIIIlI.equals("right_wing") ? ((ModelRenderer)Reflector.getFieldValue(llllllllllllllIIllIIllllIIIIIlIl, Reflector.ModelVex_rightWing)) : null;
    }
    
    @Override
    public IEntityRenderer makeEntityRender(final ModelBase llllllllllllllIIllIIlllIlllllIIl, final float llllllllllllllIIllIIlllIllllIlII) {
        final RenderManager llllllllllllllIIllIIlllIllllIlll = Minecraft.getMinecraft().getRenderManager();
        final RenderVex llllllllllllllIIllIIlllIllllIllI = new RenderVex(llllllllllllllIIllIIlllIllllIlll);
        llllllllllllllIIllIIlllIllllIllI.mainModel = llllllllllllllIIllIIlllIlllllIIl;
        llllllllllllllIIllIIlllIllllIllI.shadowSize = llllllllllllllIIllIIlllIllllIlII;
        return llllllllllllllIIllIIlllIllllIllI;
    }
}
