package net.optifine.entity.model;

import net.minecraft.client.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.entity.monster.*;
import net.minecraft.client.model.*;
import optifine.*;

public class ModelAdapterGhast extends ModelAdapter
{
    @Override
    public IEntityRenderer makeEntityRender(final ModelBase lllllllllllllIIIlIIlllIIIlllllll, final float lllllllllllllIIIlIIlllIIlIIIIIlI) {
        final RenderManager lllllllllllllIIIlIIlllIIlIIIIIIl = Minecraft.getMinecraft().getRenderManager();
        final RenderGhast lllllllllllllIIIlIIlllIIlIIIIIII = new RenderGhast(lllllllllllllIIIlIIlllIIlIIIIIIl);
        lllllllllllllIIIlIIlllIIlIIIIIII.mainModel = lllllllllllllIIIlIIlllIIIlllllll;
        lllllllllllllIIIlIIlllIIlIIIIIII.shadowSize = lllllllllllllIIIlIIlllIIlIIIIIlI;
        return lllllllllllllIIIlIIlllIIlIIIIIII;
    }
    
    public ModelAdapterGhast() {
        super(EntityGhast.class, "ghast", 0.5f);
    }
    
    @Override
    public ModelRenderer getModelRenderer(final ModelBase lllllllllllllIIIlIIlllIIlIIIllll, final String lllllllllllllIIIlIIlllIIlIIlIlIl) {
        if (!(lllllllllllllIIIlIIlllIIlIIIllll instanceof ModelGhast)) {
            return null;
        }
        final ModelGhast lllllllllllllIIIlIIlllIIlIIlIlII = (ModelGhast)lllllllllllllIIIlIIlllIIlIIIllll;
        if (lllllllllllllIIIlIIlllIIlIIlIlIl.equals("body")) {
            return (ModelRenderer)Reflector.getFieldValue(lllllllllllllIIIlIIlllIIlIIlIlII, Reflector.ModelGhast_body);
        }
        final String lllllllllllllIIIlIIlllIIlIIlIIll = "tentacle";
        if (!lllllllllllllIIIlIIlllIIlIIlIlIl.startsWith(lllllllllllllIIIlIIlllIIlIIlIIll)) {
            return null;
        }
        final ModelRenderer[] lllllllllllllIIIlIIlllIIlIIlIIlI = (ModelRenderer[])Reflector.getFieldValue(lllllllllllllIIIlIIlllIIlIIlIlII, Reflector.ModelGhast_tentacles);
        if (lllllllllllllIIIlIIlllIIlIIlIIlI == null) {
            return null;
        }
        final String lllllllllllllIIIlIIlllIIlIIlIIIl = lllllllllllllIIIlIIlllIIlIIlIlIl.substring(lllllllllllllIIIlIIlllIIlIIlIIll.length());
        int lllllllllllllIIIlIIlllIIlIIlIIII = Config.parseInt(lllllllllllllIIIlIIlllIIlIIlIIIl, -1);
        return (--lllllllllllllIIIlIIlllIIlIIlIIII >= 0 && lllllllllllllIIIlIIlllIIlIIlIIII < lllllllllllllIIIlIIlllIIlIIlIIlI.length) ? lllllllllllllIIIlIIlllIIlIIlIIlI[lllllllllllllIIIlIIlllIIlIIlIIII] : null;
    }
    
    @Override
    public ModelBase makeModel() {
        return new ModelGhast();
    }
}
