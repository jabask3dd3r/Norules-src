package net.optifine.entity.model;

import net.minecraft.tileentity.*;
import optifine.*;
import net.minecraft.client.renderer.tileentity.*;
import net.minecraft.client.model.*;

public class ModelAdapterEnderChest extends ModelAdapter
{
    @Override
    public ModelBase makeModel() {
        return new ModelChest();
    }
    
    @Override
    public IEntityRenderer makeEntityRender(final ModelBase llllllllllllllIIllllIIlIIIIllIII, final float llllllllllllllIIllllIIlIIIIlIlll) {
        final TileEntityRendererDispatcher llllllllllllllIIllllIIlIIIIlIllI = TileEntityRendererDispatcher.instance;
        TileEntitySpecialRenderer llllllllllllllIIllllIIlIIIIlIlIl = llllllllllllllIIllllIIlIIIIlIllI.getSpecialRendererByClass(TileEntityEnderChest.class);
        if (!(llllllllllllllIIllllIIlIIIIlIlIl instanceof TileEntityEnderChestRenderer)) {
            return null;
        }
        if (llllllllllllllIIllllIIlIIIIlIlIl.getEntityClass() == null) {
            llllllllllllllIIllllIIlIIIIlIlIl = new TileEntityEnderChestRenderer();
            llllllllllllllIIllllIIlIIIIlIlIl.setRendererDispatcher(llllllllllllllIIllllIIlIIIIlIllI);
        }
        if (!Reflector.TileEntityEnderChestRenderer_modelChest.exists()) {
            Config.warn("Field not found: TileEntityEnderChestRenderer.modelChest");
            return null;
        }
        Reflector.setFieldValue(llllllllllllllIIllllIIlIIIIlIlIl, Reflector.TileEntityEnderChestRenderer_modelChest, llllllllllllllIIllllIIlIIIIllIII);
        return llllllllllllllIIllllIIlIIIIlIlIl;
    }
    
    @Override
    public ModelRenderer getModelRenderer(final ModelBase llllllllllllllIIllllIIlIIIIlllll, final String llllllllllllllIIllllIIlIIIlIIIIl) {
        if (!(llllllllllllllIIllllIIlIIIIlllll instanceof ModelChest)) {
            return null;
        }
        final ModelChest llllllllllllllIIllllIIlIIIlIIIII = (ModelChest)llllllllllllllIIllllIIlIIIIlllll;
        if (llllllllllllllIIllllIIlIIIlIIIIl.equals("lid")) {
            return llllllllllllllIIllllIIlIIIlIIIII.chestLid;
        }
        if (llllllllllllllIIllllIIlIIIlIIIIl.equals("base")) {
            return llllllllllllllIIllllIIlIIIlIIIII.chestBelow;
        }
        return llllllllllllllIIllllIIlIIIlIIIIl.equals("knob") ? llllllllllllllIIllllIIlIIIlIIIII.chestKnob : null;
    }
    
    public ModelAdapterEnderChest() {
        super(TileEntityEnderChest.class, "ender_chest", 0.0f);
    }
}
