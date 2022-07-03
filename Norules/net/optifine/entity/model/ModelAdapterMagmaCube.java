package net.optifine.entity.model;

import net.minecraft.client.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.model.*;
import optifine.*;
import net.minecraft.entity.monster.*;

public class ModelAdapterMagmaCube extends ModelAdapter
{
    @Override
    public IEntityRenderer makeEntityRender(final ModelBase llllllllllllllIIIIlIlllIllIllIII, final float llllllllllllllIIIIlIlllIllIlIlll) {
        final RenderManager llllllllllllllIIIIlIlllIllIllIlI = Minecraft.getMinecraft().getRenderManager();
        final RenderMagmaCube llllllllllllllIIIIlIlllIllIllIIl = new RenderMagmaCube(llllllllllllllIIIIlIlllIllIllIlI);
        llllllllllllllIIIIlIlllIllIllIIl.mainModel = llllllllllllllIIIIlIlllIllIllIII;
        llllllllllllllIIIIlIlllIllIllIIl.shadowSize = llllllllllllllIIIIlIlllIllIlIlll;
        return llllllllllllllIIIIlIlllIllIllIIl;
    }
    
    @Override
    public ModelRenderer getModelRenderer(final ModelBase llllllllllllllIIIIlIlllIlllIllll, final String llllllllllllllIIIIlIlllIlllIlllI) {
        if (!(llllllllllllllIIIIlIlllIlllIllll instanceof ModelMagmaCube)) {
            return null;
        }
        final ModelMagmaCube llllllllllllllIIIIlIlllIlllIllIl = (ModelMagmaCube)llllllllllllllIIIIlIlllIlllIllll;
        if (llllllllllllllIIIIlIlllIlllIlllI.equals("core")) {
            return (ModelRenderer)Reflector.getFieldValue(llllllllllllllIIIIlIlllIlllIllIl, Reflector.ModelMagmaCube_core);
        }
        final String llllllllllllllIIIIlIlllIlllIllII = "segment";
        if (!llllllllllllllIIIIlIlllIlllIlllI.startsWith(llllllllllllllIIIIlIlllIlllIllII)) {
            return null;
        }
        final ModelRenderer[] llllllllllllllIIIIlIlllIlllIlIll = (ModelRenderer[])Reflector.getFieldValue(llllllllllllllIIIIlIlllIlllIllIl, Reflector.ModelMagmaCube_segments);
        if (llllllllllllllIIIIlIlllIlllIlIll == null) {
            return null;
        }
        final String llllllllllllllIIIIlIlllIlllIlIlI = llllllllllllllIIIIlIlllIlllIlllI.substring(llllllllllllllIIIIlIlllIlllIllII.length());
        int llllllllllllllIIIIlIlllIlllIlIIl = Config.parseInt(llllllllllllllIIIIlIlllIlllIlIlI, -1);
        return (--llllllllllllllIIIIlIlllIlllIlIIl >= 0 && llllllllllllllIIIIlIlllIlllIlIIl < llllllllllllllIIIIlIlllIlllIlIll.length) ? llllllllllllllIIIIlIlllIlllIlIll[llllllllllllllIIIIlIlllIlllIlIIl] : null;
    }
    
    public ModelAdapterMagmaCube() {
        super(EntityMagmaCube.class, "magma_cube", 0.5f);
    }
    
    @Override
    public ModelBase makeModel() {
        return new ModelMagmaCube();
    }
}
