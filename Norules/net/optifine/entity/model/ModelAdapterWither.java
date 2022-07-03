package net.optifine.entity.model;

import net.minecraft.client.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.model.*;
import optifine.*;
import net.minecraft.entity.boss.*;

public class ModelAdapterWither extends ModelAdapter
{
    @Override
    public IEntityRenderer makeEntityRender(final ModelBase llllllllllllllllIIlIlIllIlIIlIll, final float llllllllllllllllIIlIlIllIlIIlIlI) {
        final RenderManager llllllllllllllllIIlIlIllIlIIlIIl = Minecraft.getMinecraft().getRenderManager();
        final RenderWither llllllllllllllllIIlIlIllIlIIlIII = new RenderWither(llllllllllllllllIIlIlIllIlIIlIIl);
        llllllllllllllllIIlIlIllIlIIlIII.mainModel = llllllllllllllllIIlIlIllIlIIlIll;
        llllllllllllllllIIlIlIllIlIIlIII.shadowSize = llllllllllllllllIIlIlIllIlIIlIlI;
        return llllllllllllllllIIlIlIllIlIIlIII;
    }
    
    @Override
    public ModelRenderer getModelRenderer(final ModelBase llllllllllllllllIIlIlIllIlIllIII, final String llllllllllllllllIIlIlIllIllIIIlI) {
        if (!(llllllllllllllllIIlIlIllIlIllIII instanceof ModelWither)) {
            return null;
        }
        final ModelWither llllllllllllllllIIlIlIllIllIIIIl = (ModelWither)llllllllllllllllIIlIlIllIlIllIII;
        final String llllllllllllllllIIlIlIllIllIIIII = "body";
        if (llllllllllllllllIIlIlIllIllIIIlI.startsWith(llllllllllllllllIIlIlIllIllIIIII)) {
            final ModelRenderer[] llllllllllllllllIIlIlIllIlIlllll = (ModelRenderer[])Reflector.getFieldValue(llllllllllllllllIIlIlIllIllIIIIl, Reflector.ModelWither_bodyParts);
            if (llllllllllllllllIIlIlIllIlIlllll == null) {
                return null;
            }
            final String llllllllllllllllIIlIlIllIlIllllI = llllllllllllllllIIlIlIllIllIIIlI.substring(llllllllllllllllIIlIlIllIllIIIII.length());
            int llllllllllllllllIIlIlIllIlIlllIl = Config.parseInt(llllllllllllllllIIlIlIllIlIllllI, -1);
            return (--llllllllllllllllIIlIlIllIlIlllIl >= 0 && llllllllllllllllIIlIlIllIlIlllIl < llllllllllllllllIIlIlIllIlIlllll.length) ? llllllllllllllllIIlIlIllIlIlllll[llllllllllllllllIIlIlIllIlIlllIl] : null;
        }
        else {
            final String llllllllllllllllIIlIlIllIlIlllII = "head";
            if (!llllllllllllllllIIlIlIllIllIIIlI.startsWith(llllllllllllllllIIlIlIllIlIlllII)) {
                return null;
            }
            final ModelRenderer[] llllllllllllllllIIlIlIllIlIllIll = (ModelRenderer[])Reflector.getFieldValue(llllllllllllllllIIlIlIllIllIIIIl, Reflector.ModelWither_heads);
            if (llllllllllllllllIIlIlIllIlIllIll == null) {
                return null;
            }
            final String llllllllllllllllIIlIlIllIlIllIlI = llllllllllllllllIIlIlIllIllIIIlI.substring(llllllllllllllllIIlIlIllIlIlllII.length());
            int llllllllllllllllIIlIlIllIlIllIIl = Config.parseInt(llllllllllllllllIIlIlIllIlIllIlI, -1);
            return (--llllllllllllllllIIlIlIllIlIllIIl >= 0 && llllllllllllllllIIlIlIllIlIllIIl < llllllllllllllllIIlIlIllIlIllIll.length) ? llllllllllllllllIIlIlIllIlIllIll[llllllllllllllllIIlIlIllIlIllIIl] : null;
        }
    }
    
    public ModelAdapterWither() {
        super(EntityWither.class, "wither", 0.5f);
    }
    
    @Override
    public ModelBase makeModel() {
        return new ModelWither(0.0f);
    }
}
