package net.optifine.entity.model;

import net.minecraft.client.model.*;
import net.minecraft.tileentity.*;
import optifine.*;
import net.minecraft.client.renderer.tileentity.*;

public class ModelAdapterChestLarge extends ModelAdapter
{
    @Override
    public ModelRenderer getModelRenderer(final ModelBase lllllllllllllIllIIllllIlllIIlIlI, final String lllllllllllllIllIIllllIlllIIIllI) {
        if (!(lllllllllllllIllIIllllIlllIIlIlI instanceof ModelChest)) {
            return null;
        }
        final ModelChest lllllllllllllIllIIllllIlllIIlIII = (ModelChest)lllllllllllllIllIIllllIlllIIlIlI;
        if (lllllllllllllIllIIllllIlllIIIllI.equals("lid")) {
            return lllllllllllllIllIIllllIlllIIlIII.chestLid;
        }
        if (lllllllllllllIllIIllllIlllIIIllI.equals("base")) {
            return lllllllllllllIllIIllllIlllIIlIII.chestBelow;
        }
        return lllllllllllllIllIIllllIlllIIIllI.equals("knob") ? lllllllllllllIllIIllllIlllIIlIII.chestKnob : null;
    }
    
    @Override
    public ModelBase makeModel() {
        return new ModelLargeChest();
    }
    
    public ModelAdapterChestLarge() {
        super(TileEntityChest.class, "chest_large", 0.0f);
    }
    
    @Override
    public IEntityRenderer makeEntityRender(final ModelBase lllllllllllllIllIIllllIlllIIIIII, final float lllllllllllllIllIIllllIllIllllll) {
        final TileEntityRendererDispatcher lllllllllllllIllIIllllIllIlllllI = TileEntityRendererDispatcher.instance;
        TileEntitySpecialRenderer lllllllllllllIllIIllllIllIllllIl = lllllllllllllIllIIllllIllIlllllI.getSpecialRendererByClass(TileEntityChest.class);
        if (!(lllllllllllllIllIIllllIllIllllIl instanceof TileEntityChestRenderer)) {
            return null;
        }
        if (lllllllllllllIllIIllllIllIllllIl.getEntityClass() == null) {
            lllllllllllllIllIIllllIllIllllIl = new TileEntityChestRenderer();
            lllllllllllllIllIIllllIllIllllIl.setRendererDispatcher(lllllllllllllIllIIllllIllIlllllI);
        }
        if (!Reflector.TileEntityChestRenderer_largeChest.exists()) {
            Config.warn("Field not found: TileEntityChestRenderer.largeChest");
            return null;
        }
        Reflector.setFieldValue(lllllllllllllIllIIllllIllIllllIl, Reflector.TileEntityChestRenderer_largeChest, lllllllllllllIllIIllllIlllIIIIII);
        return lllllllllllllIllIIllllIllIllllIl;
    }
}
