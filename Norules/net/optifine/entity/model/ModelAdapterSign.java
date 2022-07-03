package net.optifine.entity.model;

import net.minecraft.tileentity.*;
import optifine.*;
import net.minecraft.client.renderer.tileentity.*;
import net.minecraft.client.model.*;

public class ModelAdapterSign extends ModelAdapter
{
    @Override
    public IEntityRenderer makeEntityRender(final ModelBase lllllllllllllllIlIllIIIIlIIlIlII, final float lllllllllllllllIlIllIIIIlIIlIlll) {
        final TileEntityRendererDispatcher lllllllllllllllIlIllIIIIlIIlIllI = TileEntityRendererDispatcher.instance;
        TileEntitySpecialRenderer lllllllllllllllIlIllIIIIlIIlIlIl = lllllllllllllllIlIllIIIIlIIlIllI.getSpecialRendererByClass(TileEntitySign.class);
        if (!(lllllllllllllllIlIllIIIIlIIlIlIl instanceof TileEntitySignRenderer)) {
            return null;
        }
        if (lllllllllllllllIlIllIIIIlIIlIlIl.getEntityClass() == null) {
            lllllllllllllllIlIllIIIIlIIlIlIl = new TileEntitySignRenderer();
            lllllllllllllllIlIllIIIIlIIlIlIl.setRendererDispatcher(lllllllllllllllIlIllIIIIlIIlIllI);
        }
        if (!Reflector.TileEntitySignRenderer_model.exists()) {
            Config.warn("Field not found: TileEntitySignRenderer.model");
            return null;
        }
        Reflector.setFieldValue(lllllllllllllllIlIllIIIIlIIlIlIl, Reflector.TileEntitySignRenderer_model, lllllllllllllllIlIllIIIIlIIlIlII);
        return lllllllllllllllIlIllIIIIlIIlIlIl;
    }
    
    @Override
    public ModelRenderer getModelRenderer(final ModelBase lllllllllllllllIlIllIIIIlIIlllll, final String lllllllllllllllIlIllIIIIlIIllllI) {
        if (!(lllllllllllllllIlIllIIIIlIIlllll instanceof ModelSign)) {
            return null;
        }
        final ModelSign lllllllllllllllIlIllIIIIlIlIIIII = (ModelSign)lllllllllllllllIlIllIIIIlIIlllll;
        if (lllllllllllllllIlIllIIIIlIIllllI.equals("board")) {
            return lllllllllllllllIlIllIIIIlIlIIIII.signBoard;
        }
        return lllllllllllllllIlIllIIIIlIIllllI.equals("stick") ? lllllllllllllllIlIllIIIIlIlIIIII.signStick : null;
    }
    
    public ModelAdapterSign() {
        super(TileEntitySign.class, "sign", 0.0f);
    }
    
    @Override
    public ModelBase makeModel() {
        return new ModelSign();
    }
}
