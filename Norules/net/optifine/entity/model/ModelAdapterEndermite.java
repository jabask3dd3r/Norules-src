package net.optifine.entity.model;

import net.minecraft.client.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.model.*;
import optifine.*;
import net.minecraft.entity.monster.*;

public class ModelAdapterEndermite extends ModelAdapter
{
    @Override
    public IEntityRenderer makeEntityRender(final ModelBase llllllllllllllIIllIlIlllIlIIlIll, final float llllllllllllllIIllIlIlllIlIIlIlI) {
        final RenderManager llllllllllllllIIllIlIlllIlIIlIIl = Minecraft.getMinecraft().getRenderManager();
        final RenderEndermite llllllllllllllIIllIlIlllIlIIlIII = new RenderEndermite(llllllllllllllIIllIlIlllIlIIlIIl);
        llllllllllllllIIllIlIlllIlIIlIII.mainModel = llllllllllllllIIllIlIlllIlIIlIll;
        llllllllllllllIIllIlIlllIlIIlIII.shadowSize = llllllllllllllIIllIlIlllIlIIlIlI;
        return llllllllllllllIIllIlIlllIlIIlIII;
    }
    
    @Override
    public ModelRenderer getModelRenderer(final ModelBase llllllllllllllIIllIlIlllIlIlIlll, final String llllllllllllllIIllIlIlllIlIlllIl) {
        if (!(llllllllllllllIIllIlIlllIlIlIlll instanceof ModelEnderMite)) {
            return null;
        }
        final ModelEnderMite llllllllllllllIIllIlIlllIlIlllII = (ModelEnderMite)llllllllllllllIIllIlIlllIlIlIlll;
        final String llllllllllllllIIllIlIlllIlIllIll = "body";
        if (!llllllllllllllIIllIlIlllIlIlllIl.startsWith(llllllllllllllIIllIlIlllIlIllIll)) {
            return null;
        }
        final ModelRenderer[] llllllllllllllIIllIlIlllIlIllIlI = (ModelRenderer[])Reflector.getFieldValue(llllllllllllllIIllIlIlllIlIlllII, Reflector.ModelEnderMite_bodyParts);
        if (llllllllllllllIIllIlIlllIlIllIlI == null) {
            return null;
        }
        final String llllllllllllllIIllIlIlllIlIllIIl = llllllllllllllIIllIlIlllIlIlllIl.substring(llllllllllllllIIllIlIlllIlIllIll.length());
        int llllllllllllllIIllIlIlllIlIllIII = Config.parseInt(llllllllllllllIIllIlIlllIlIllIIl, -1);
        return (--llllllllllllllIIllIlIlllIlIllIII >= 0 && llllllllllllllIIllIlIlllIlIllIII < llllllllllllllIIllIlIlllIlIllIlI.length) ? llllllllllllllIIllIlIlllIlIllIlI[llllllllllllllIIllIlIlllIlIllIII] : null;
    }
    
    @Override
    public ModelBase makeModel() {
        return new ModelEnderMite();
    }
    
    public ModelAdapterEndermite() {
        super(EntityEndermite.class, "endermite", 0.3f);
    }
}
