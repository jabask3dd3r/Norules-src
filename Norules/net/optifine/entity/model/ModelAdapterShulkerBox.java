package net.optifine.entity.model;

import net.minecraft.client.model.*;
import net.minecraft.tileentity.*;
import optifine.*;
import net.minecraft.client.renderer.tileentity.*;

public class ModelAdapterShulkerBox extends ModelAdapter
{
    @Override
    public ModelBase makeModel() {
        return new ModelShulker();
    }
    
    @Override
    public ModelRenderer getModelRenderer(final ModelBase llllllllllllllllIIlIlIIlIlllIIII, final String llllllllllllllllIIlIlIIlIlllIIll) {
        if (!(llllllllllllllllIIlIlIIlIlllIIII instanceof ModelShulker)) {
            return null;
        }
        final ModelShulker llllllllllllllllIIlIlIIlIlllIIIl = (ModelShulker)llllllllllllllllIIlIlIIlIlllIIII;
        if (llllllllllllllllIIlIlIIlIlllIIll.equals("head")) {
            return llllllllllllllllIIlIlIIlIlllIIIl.head;
        }
        if (llllllllllllllllIIlIlIIlIlllIIll.equals("base")) {
            return llllllllllllllllIIlIlIIlIlllIIIl.base;
        }
        return llllllllllllllllIIlIlIIlIlllIIll.equals("lid") ? llllllllllllllllIIlIlIIlIlllIIIl.lid : null;
    }
    
    public ModelAdapterShulkerBox() {
        super(TileEntityShulkerBox.class, "shulker_box", 0.0f);
    }
    
    @Override
    public IEntityRenderer makeEntityRender(final ModelBase llllllllllllllllIIlIlIIlIllIIIIl, final float llllllllllllllllIIlIlIIlIllIIlII) {
        final TileEntityRendererDispatcher llllllllllllllllIIlIlIIlIllIIIll = TileEntityRendererDispatcher.instance;
        TileEntitySpecialRenderer llllllllllllllllIIlIlIIlIllIIIlI = llllllllllllllllIIlIlIIlIllIIIll.getSpecialRendererByClass(TileEntityShulkerBox.class);
        if (!(llllllllllllllllIIlIlIIlIllIIIlI instanceof TileEntityShulkerBoxRenderer)) {
            return null;
        }
        if (llllllllllllllllIIlIlIIlIllIIIlI.getEntityClass() == null) {
            llllllllllllllllIIlIlIIlIllIIIlI = new TileEntityShulkerBoxRenderer((ModelShulker)llllllllllllllllIIlIlIIlIllIIIIl);
            llllllllllllllllIIlIlIIlIllIIIlI.setRendererDispatcher(llllllllllllllllIIlIlIIlIllIIIll);
        }
        if (!Reflector.TileEntityShulkerBoxRenderer_model.exists()) {
            Config.warn("Field not found: TileEntityShulkerBoxRenderer.model");
            return null;
        }
        Reflector.setFieldValue(llllllllllllllllIIlIlIIlIllIIIlI, Reflector.TileEntityShulkerBoxRenderer_model, llllllllllllllllIIlIlIIlIllIIIIl);
        return llllllllllllllllIIlIlIIlIllIIIlI;
    }
}
