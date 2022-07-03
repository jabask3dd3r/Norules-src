package net.optifine.entity.model;

import net.minecraft.client.model.*;
import net.minecraft.tileentity.*;
import optifine.*;
import net.minecraft.client.renderer.tileentity.*;

public class ModelAdapterChest extends ModelAdapter
{
    @Override
    public ModelRenderer getModelRenderer(final ModelBase llllllllllllllllIlllIIIllIlIlllI, final String llllllllllllllllIlllIIIllIlIllIl) {
        if (!(llllllllllllllllIlllIIIllIlIlllI instanceof ModelChest)) {
            return null;
        }
        final ModelChest llllllllllllllllIlllIIIllIlIllII = (ModelChest)llllllllllllllllIlllIIIllIlIlllI;
        if (llllllllllllllllIlllIIIllIlIllIl.equals("lid")) {
            return llllllllllllllllIlllIIIllIlIllII.chestLid;
        }
        if (llllllllllllllllIlllIIIllIlIllIl.equals("base")) {
            return llllllllllllllllIlllIIIllIlIllII.chestBelow;
        }
        return llllllllllllllllIlllIIIllIlIllIl.equals("knob") ? llllllllllllllllIlllIIIllIlIllII.chestKnob : null;
    }
    
    @Override
    public IEntityRenderer makeEntityRender(final ModelBase llllllllllllllllIlllIIIllIlIIIII, final float llllllllllllllllIlllIIIllIlIIIll) {
        final TileEntityRendererDispatcher llllllllllllllllIlllIIIllIlIIIlI = TileEntityRendererDispatcher.instance;
        TileEntitySpecialRenderer llllllllllllllllIlllIIIllIlIIIIl = llllllllllllllllIlllIIIllIlIIIlI.getSpecialRendererByClass(TileEntityChest.class);
        if (!(llllllllllllllllIlllIIIllIlIIIIl instanceof TileEntityChestRenderer)) {
            return null;
        }
        if (llllllllllllllllIlllIIIllIlIIIIl.getEntityClass() == null) {
            llllllllllllllllIlllIIIllIlIIIIl = new TileEntityChestRenderer();
            llllllllllllllllIlllIIIllIlIIIIl.setRendererDispatcher(llllllllllllllllIlllIIIllIlIIIlI);
        }
        if (!Reflector.TileEntityChestRenderer_simpleChest.exists()) {
            Config.warn("Field not found: TileEntityChestRenderer.simpleChest");
            return null;
        }
        Reflector.setFieldValue(llllllllllllllllIlllIIIllIlIIIIl, Reflector.TileEntityChestRenderer_simpleChest, llllllllllllllllIlllIIIllIlIIIII);
        return llllllllllllllllIlllIIIllIlIIIIl;
    }
    
    @Override
    public ModelBase makeModel() {
        return new ModelChest();
    }
    
    public ModelAdapterChest() {
        super(TileEntityChest.class, "chest", 0.0f);
    }
}
