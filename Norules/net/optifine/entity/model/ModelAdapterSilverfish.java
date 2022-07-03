package net.optifine.entity.model;

import net.minecraft.client.model.*;
import optifine.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.entity.monster.*;

public class ModelAdapterSilverfish extends ModelAdapter
{
    @Override
    public ModelRenderer getModelRenderer(final ModelBase lllllllllllllIIIIlIlllIIIllIlIIl, final String lllllllllllllIIIIlIlllIIIlllIIll) {
        if (!(lllllllllllllIIIIlIlllIIIllIlIIl instanceof ModelSilverfish)) {
            return null;
        }
        final ModelSilverfish lllllllllllllIIIIlIlllIIIlllIIlI = (ModelSilverfish)lllllllllllllIIIIlIlllIIIllIlIIl;
        final String lllllllllllllIIIIlIlllIIIlllIIIl = "body";
        if (lllllllllllllIIIIlIlllIIIlllIIll.startsWith(lllllllllllllIIIIlIlllIIIlllIIIl)) {
            final ModelRenderer[] lllllllllllllIIIIlIlllIIIlllIIII = (ModelRenderer[])Reflector.getFieldValue(lllllllllllllIIIIlIlllIIIlllIIlI, Reflector.ModelSilverfish_bodyParts);
            if (lllllllllllllIIIIlIlllIIIlllIIII == null) {
                return null;
            }
            final String lllllllllllllIIIIlIlllIIIllIllll = lllllllllllllIIIIlIlllIIIlllIIll.substring(lllllllllllllIIIIlIlllIIIlllIIIl.length());
            int lllllllllllllIIIIlIlllIIIllIlllI = Config.parseInt(lllllllllllllIIIIlIlllIIIllIllll, -1);
            return (--lllllllllllllIIIIlIlllIIIllIlllI >= 0 && lllllllllllllIIIIlIlllIIIllIlllI < lllllllllllllIIIIlIlllIIIlllIIII.length) ? lllllllllllllIIIIlIlllIIIlllIIII[lllllllllllllIIIIlIlllIIIllIlllI] : null;
        }
        else {
            final String lllllllllllllIIIIlIlllIIIllIllIl = "wing";
            if (!lllllllllllllIIIIlIlllIIIlllIIll.startsWith(lllllllllllllIIIIlIlllIIIllIllIl)) {
                return null;
            }
            final ModelRenderer[] lllllllllllllIIIIlIlllIIIllIllII = (ModelRenderer[])Reflector.getFieldValue(lllllllllllllIIIIlIlllIIIlllIIlI, Reflector.ModelSilverfish_wingParts);
            if (lllllllllllllIIIIlIlllIIIllIllII == null) {
                return null;
            }
            final String lllllllllllllIIIIlIlllIIIllIlIll = lllllllllllllIIIIlIlllIIIlllIIll.substring(lllllllllllllIIIIlIlllIIIllIllIl.length());
            int lllllllllllllIIIIlIlllIIIllIlIlI = Config.parseInt(lllllllllllllIIIIlIlllIIIllIlIll, -1);
            return (--lllllllllllllIIIIlIlllIIIllIlIlI >= 0 && lllllllllllllIIIIlIlllIIIllIlIlI < lllllllllllllIIIIlIlllIIIllIllII.length) ? lllllllllllllIIIIlIlllIIIllIllII[lllllllllllllIIIIlIlllIIIllIlIlI] : null;
        }
    }
    
    @Override
    public ModelBase makeModel() {
        return new ModelSilverfish();
    }
    
    @Override
    public IEntityRenderer makeEntityRender(final ModelBase lllllllllllllIIIIlIlllIIIlIllIII, final float lllllllllllllIIIIlIlllIIIlIlIlll) {
        final RenderManager lllllllllllllIIIIlIlllIIIlIllIlI = Minecraft.getMinecraft().getRenderManager();
        final RenderSilverfish lllllllllllllIIIIlIlllIIIlIllIIl = new RenderSilverfish(lllllllllllllIIIIlIlllIIIlIllIlI);
        lllllllllllllIIIIlIlllIIIlIllIIl.mainModel = lllllllllllllIIIIlIlllIIIlIllIII;
        lllllllllllllIIIIlIlllIIIlIllIIl.shadowSize = lllllllllllllIIIIlIlllIIIlIlIlll;
        return lllllllllllllIIIIlIlllIIIlIllIIl;
    }
    
    public ModelAdapterSilverfish() {
        super(EntitySilverfish.class, "silverfish", 0.3f);
    }
}
