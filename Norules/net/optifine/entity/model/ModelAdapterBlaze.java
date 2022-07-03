package net.optifine.entity.model;

import net.minecraft.client.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.model.*;
import optifine.*;
import net.minecraft.entity.monster.*;

public class ModelAdapterBlaze extends ModelAdapter
{
    @Override
    public IEntityRenderer makeEntityRender(final ModelBase llllllllllllllIlIIlIlIIIIlIlllll, final float llllllllllllllIlIIlIlIIIIlIllllI) {
        final RenderManager llllllllllllllIlIIlIlIIIIlIlllIl = Minecraft.getMinecraft().getRenderManager();
        final RenderBlaze llllllllllllllIlIIlIlIIIIlIlllII = new RenderBlaze(llllllllllllllIlIIlIlIIIIlIlllIl);
        llllllllllllllIlIIlIlIIIIlIlllII.mainModel = llllllllllllllIlIIlIlIIIIlIlllll;
        llllllllllllllIlIIlIlIIIIlIlllII.shadowSize = llllllllllllllIlIIlIlIIIIlIllllI;
        return llllllllllllllIlIIlIlIIIIlIlllII;
    }
    
    @Override
    public ModelRenderer getModelRenderer(final ModelBase llllllllllllllIlIIlIlIIIIlllIIlI, final String llllllllllllllIlIIlIlIIIIllIlIlI) {
        if (!(llllllllllllllIlIIlIlIIIIlllIIlI instanceof ModelBlaze)) {
            return null;
        }
        final ModelBlaze llllllllllllllIlIIlIlIIIIlllIIII = (ModelBlaze)llllllllllllllIlIIlIlIIIIlllIIlI;
        if (llllllllllllllIlIIlIlIIIIllIlIlI.equals("head")) {
            return (ModelRenderer)Reflector.getFieldValue(llllllllllllllIlIIlIlIIIIlllIIII, Reflector.ModelBlaze_blazeHead);
        }
        final String llllllllllllllIlIIlIlIIIIllIllll = "stick";
        if (!llllllllllllllIlIIlIlIIIIllIlIlI.startsWith(llllllllllllllIlIIlIlIIIIllIllll)) {
            return null;
        }
        final ModelRenderer[] llllllllllllllIlIIlIlIIIIllIlllI = (ModelRenderer[])Reflector.getFieldValue(llllllllllllllIlIIlIlIIIIlllIIII, Reflector.ModelBlaze_blazeSticks);
        if (llllllllllllllIlIIlIlIIIIllIlllI == null) {
            return null;
        }
        final String llllllllllllllIlIIlIlIIIIllIllIl = llllllllllllllIlIIlIlIIIIllIlIlI.substring(llllllllllllllIlIIlIlIIIIllIllll.length());
        int llllllllllllllIlIIlIlIIIIllIllII = Config.parseInt(llllllllllllllIlIIlIlIIIIllIllIl, -1);
        return (--llllllllllllllIlIIlIlIIIIllIllII >= 0 && llllllllllllllIlIIlIlIIIIllIllII < llllllllllllllIlIIlIlIIIIllIlllI.length) ? llllllllllllllIlIIlIlIIIIllIlllI[llllllllllllllIlIIlIlIIIIllIllII] : null;
    }
    
    public ModelAdapterBlaze() {
        super(EntityBlaze.class, "blaze", 0.5f);
    }
    
    @Override
    public ModelBase makeModel() {
        return new ModelBlaze();
    }
}
