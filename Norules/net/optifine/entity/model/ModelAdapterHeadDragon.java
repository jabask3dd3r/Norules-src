package net.optifine.entity.model;

import net.minecraft.client.model.*;
import net.minecraft.tileentity.*;
import optifine.*;
import net.minecraft.client.renderer.tileentity.*;

public class ModelAdapterHeadDragon extends ModelAdapter
{
    @Override
    public ModelBase makeModel() {
        return new ModelDragonHead(0.0f);
    }
    
    @Override
    public ModelRenderer getModelRenderer(final ModelBase llllllllllllllIlIlIIllllIIlllllI, final String llllllllllllllIlIlIIllllIIlllIlI) {
        if (!(llllllllllllllIlIlIIllllIIlllllI instanceof ModelDragonHead)) {
            return null;
        }
        final ModelDragonHead llllllllllllllIlIlIIllllIIllllII = (ModelDragonHead)llllllllllllllIlIlIIllllIIlllllI;
        if (llllllllllllllIlIlIIllllIIlllIlI.equals("head")) {
            return (ModelRenderer)Reflector.getFieldValue(llllllllllllllIlIlIIllllIIllllII, Reflector.ModelDragonHead_head);
        }
        return llllllllllllllIlIlIIllllIIlllIlI.equals("jaw") ? ((ModelRenderer)Reflector.getFieldValue(llllllllllllllIlIlIIllllIIllllII, Reflector.ModelDragonHead_jaw)) : null;
    }
    
    @Override
    public IEntityRenderer makeEntityRender(final ModelBase llllllllllllllIlIlIIllllIIllIlII, final float llllllllllllllIlIlIIllllIIllIIll) {
        final TileEntityRendererDispatcher llllllllllllllIlIlIIllllIIllIIlI = TileEntityRendererDispatcher.instance;
        TileEntitySpecialRenderer llllllllllllllIlIlIIllllIIllIIIl = llllllllllllllIlIlIIllllIIllIIlI.getSpecialRendererByClass(TileEntitySkull.class);
        if (!(llllllllllllllIlIlIIllllIIllIIIl instanceof TileEntitySkullRenderer)) {
            return null;
        }
        if (llllllllllllllIlIlIIllllIIllIIIl.getEntityClass() == null) {
            llllllllllllllIlIlIIllllIIllIIIl = new TileEntitySkullRenderer();
            llllllllllllllIlIlIIllllIIllIIIl.setRendererDispatcher(llllllllllllllIlIlIIllllIIllIIlI);
        }
        if (!Reflector.TileEntitySkullRenderer_dragonHead.exists()) {
            Config.warn("Field not found: TileEntitySkullRenderer.dragonHead");
            return null;
        }
        Reflector.setFieldValue(llllllllllllllIlIlIIllllIIllIIIl, Reflector.TileEntitySkullRenderer_dragonHead, llllllllllllllIlIlIIllllIIllIlII);
        return llllllllllllllIlIlIIllllIIllIIIl;
    }
    
    public ModelAdapterHeadDragon() {
        super(TileEntitySkull.class, "head_dragon", 0.0f);
    }
}
