package net.optifine.entity.model;

import net.minecraft.client.model.*;
import optifine.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.entity.passive.*;

public class ModelAdapterSquid extends ModelAdapter
{
    @Override
    public ModelRenderer getModelRenderer(final ModelBase lllllllllllllllIIIIIIlIIIlllllll, final String lllllllllllllllIIIIIIlIIIlllllIl) {
        if (!(lllllllllllllllIIIIIIlIIIlllllll instanceof ModelSquid)) {
            return null;
        }
        final ModelSquid lllllllllllllllIIIIIIlIIIllllIll = (ModelSquid)lllllllllllllllIIIIIIlIIIlllllll;
        if (lllllllllllllllIIIIIIlIIIlllllIl.equals("body")) {
            return (ModelRenderer)Reflector.getFieldValue(lllllllllllllllIIIIIIlIIIllllIll, Reflector.ModelSquid_body);
        }
        final String lllllllllllllllIIIIIIlIIIllllIIl = "tentacle";
        if (!lllllllllllllllIIIIIIlIIIlllllIl.startsWith(lllllllllllllllIIIIIIlIIIllllIIl)) {
            return null;
        }
        final ModelRenderer[] lllllllllllllllIIIIIIlIIIlllIlll = (ModelRenderer[])Reflector.getFieldValue(lllllllllllllllIIIIIIlIIIllllIll, Reflector.ModelSquid_tentacles);
        if (lllllllllllllllIIIIIIlIIIlllIlll == null) {
            return null;
        }
        final String lllllllllllllllIIIIIIlIIIlllIlIl = lllllllllllllllIIIIIIlIIIlllllIl.substring(lllllllllllllllIIIIIIlIIIllllIIl.length());
        int lllllllllllllllIIIIIIlIIIlllIlII = Config.parseInt(lllllllllllllllIIIIIIlIIIlllIlIl, -1);
        return (--lllllllllllllllIIIIIIlIIIlllIlII >= 0 && lllllllllllllllIIIIIIlIIIlllIlII < lllllllllllllllIIIIIIlIIIlllIlll.length) ? lllllllllllllllIIIIIIlIIIlllIlll[lllllllllllllllIIIIIIlIIIlllIlII] : null;
    }
    
    @Override
    public IEntityRenderer makeEntityRender(final ModelBase lllllllllllllllIIIIIIlIIIlIllIII, final float lllllllllllllllIIIIIIlIIIlIllIll) {
        final RenderManager lllllllllllllllIIIIIIlIIIlIllIlI = Minecraft.getMinecraft().getRenderManager();
        final RenderSquid lllllllllllllllIIIIIIlIIIlIllIIl = new RenderSquid(lllllllllllllllIIIIIIlIIIlIllIlI);
        lllllllllllllllIIIIIIlIIIlIllIIl.mainModel = lllllllllllllllIIIIIIlIIIlIllIII;
        lllllllllllllllIIIIIIlIIIlIllIIl.shadowSize = lllllllllllllllIIIIIIlIIIlIllIll;
        return lllllllllllllllIIIIIIlIIIlIllIIl;
    }
    
    @Override
    public ModelBase makeModel() {
        return new ModelSquid();
    }
    
    public ModelAdapterSquid() {
        super(EntitySquid.class, "squid", 0.7f);
    }
}
