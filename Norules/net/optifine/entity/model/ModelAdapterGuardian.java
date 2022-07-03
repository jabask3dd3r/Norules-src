package net.optifine.entity.model;

import net.minecraft.client.model.*;
import optifine.*;
import net.minecraft.entity.monster.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.entity.*;

public class ModelAdapterGuardian extends ModelAdapter
{
    @Override
    public ModelRenderer getModelRenderer(final ModelBase llllllllllllllIIIIlIllIIIlIlIlll, final String llllllllllllllIIIIlIllIIIlIlIllI) {
        if (!(llllllllllllllIIIIlIllIIIlIlIlll instanceof ModelGuardian)) {
            return null;
        }
        final ModelGuardian llllllllllllllIIIIlIllIIIllIIIII = (ModelGuardian)llllllllllllllIIIIlIllIIIlIlIlll;
        if (llllllllllllllIIIIlIllIIIlIlIllI.equals("body")) {
            return (ModelRenderer)Reflector.getFieldValue(llllllllllllllIIIIlIllIIIllIIIII, Reflector.ModelGuardian_body);
        }
        if (llllllllllllllIIIIlIllIIIlIlIllI.equals("eye")) {
            return (ModelRenderer)Reflector.getFieldValue(llllllllllllllIIIIlIllIIIllIIIII, Reflector.ModelGuardian_eye);
        }
        final String llllllllllllllIIIIlIllIIIlIlllll = "spine";
        if (llllllllllllllIIIIlIllIIIlIlIllI.startsWith(llllllllllllllIIIIlIllIIIlIlllll)) {
            final ModelRenderer[] llllllllllllllIIIIlIllIIIlIllllI = (ModelRenderer[])Reflector.getFieldValue(llllllllllllllIIIIlIllIIIllIIIII, Reflector.ModelGuardian_spines);
            if (llllllllllllllIIIIlIllIIIlIllllI == null) {
                return null;
            }
            final String llllllllllllllIIIIlIllIIIlIlllIl = llllllllllllllIIIIlIllIIIlIlIllI.substring(llllllllllllllIIIIlIllIIIlIlllll.length());
            int llllllllllllllIIIIlIllIIIlIlllII = Config.parseInt(llllllllllllllIIIIlIllIIIlIlllIl, -1);
            return (--llllllllllllllIIIIlIllIIIlIlllII >= 0 && llllllllllllllIIIIlIllIIIlIlllII < llllllllllllllIIIIlIllIIIlIllllI.length) ? llllllllllllllIIIIlIllIIIlIllllI[llllllllllllllIIIIlIllIIIlIlllII] : null;
        }
        else {
            final String llllllllllllllIIIIlIllIIIlIllIll = "tail";
            if (!llllllllllllllIIIIlIllIIIlIlIllI.startsWith(llllllllllllllIIIIlIllIIIlIllIll)) {
                return null;
            }
            final ModelRenderer[] llllllllllllllIIIIlIllIIIlIllIlI = (ModelRenderer[])Reflector.getFieldValue(llllllllllllllIIIIlIllIIIllIIIII, Reflector.ModelGuardian_tail);
            if (llllllllllllllIIIIlIllIIIlIllIlI == null) {
                return null;
            }
            final String llllllllllllllIIIIlIllIIIlIllIIl = llllllllllllllIIIIlIllIIIlIlIllI.substring(llllllllllllllIIIIlIllIIIlIllIll.length());
            int llllllllllllllIIIIlIllIIIlIllIII = Config.parseInt(llllllllllllllIIIIlIllIIIlIllIIl, -1);
            return (--llllllllllllllIIIIlIllIIIlIllIII >= 0 && llllllllllllllIIIIlIllIIIlIllIII < llllllllllllllIIIIlIllIIIlIllIlI.length) ? llllllllllllllIIIIlIllIIIlIllIlI[llllllllllllllIIIIlIllIIIlIllIII] : null;
        }
    }
    
    @Override
    public ModelBase makeModel() {
        return new ModelGuardian();
    }
    
    public ModelAdapterGuardian() {
        super(EntityGuardian.class, "guardian", 0.5f);
    }
    
    @Override
    public IEntityRenderer makeEntityRender(final ModelBase llllllllllllllIIIIlIllIIIlIIlIlI, final float llllllllllllllIIIIlIllIIIlIIIlIl) {
        final RenderManager llllllllllllllIIIIlIllIIIlIIlIII = Minecraft.getMinecraft().getRenderManager();
        final RenderGuardian llllllllllllllIIIIlIllIIIlIIIlll = new RenderGuardian(llllllllllllllIIIIlIllIIIlIIlIII);
        llllllllllllllIIIIlIllIIIlIIIlll.mainModel = llllllllllllllIIIIlIllIIIlIIlIlI;
        llllllllllllllIIIIlIllIIIlIIIlll.shadowSize = llllllllllllllIIIIlIllIIIlIIIlIl;
        return llllllllllllllIIIIlIllIIIlIIIlll;
    }
}
