package net.optifine.entity.model;

import net.minecraft.client.*;
import optifine.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.model.*;
import net.minecraft.entity.item.*;

public class ModelAdapterBoat extends ModelAdapter
{
    @Override
    public IEntityRenderer makeEntityRender(final ModelBase lllllllllllllIlIIlllIIIlIIlIllll, final float lllllllllllllIlIIlllIIIlIIllIIlI) {
        final RenderManager lllllllllllllIlIIlllIIIlIIllIIIl = Minecraft.getMinecraft().getRenderManager();
        final RenderBoat lllllllllllllIlIIlllIIIlIIllIIII = new RenderBoat(lllllllllllllIlIIlllIIIlIIllIIIl);
        if (!Reflector.RenderBoat_modelBoat.exists()) {
            Config.warn("Field not found: RenderBoat.modelBoat");
            return null;
        }
        Reflector.setFieldValue(lllllllllllllIlIIlllIIIlIIllIIII, Reflector.RenderBoat_modelBoat, lllllllllllllIlIIlllIIIlIIlIllll);
        lllllllllllllIlIIlllIIIlIIllIIII.shadowSize = lllllllllllllIlIIlllIIIlIIllIIlI;
        return lllllllllllllIlIIlllIIIlIIllIIII;
    }
    
    @Override
    public ModelBase makeModel() {
        return new ModelBoat();
    }
    
    @Override
    public ModelRenderer getModelRenderer(final ModelBase lllllllllllllIlIIlllIIIlIIlllllI, final String lllllllllllllIlIIlllIIIlIIllllIl) {
        if (!(lllllllllllllIlIIlllIIIlIIlllllI instanceof ModelBoat)) {
            return null;
        }
        final ModelBoat lllllllllllllIlIIlllIIIlIIllllII = (ModelBoat)lllllllllllllIlIIlllIIIlIIlllllI;
        if (lllllllllllllIlIIlllIIIlIIllllIl.equals("bottom")) {
            return lllllllllllllIlIIlllIIIlIIllllII.boatSides[0];
        }
        if (lllllllllllllIlIIlllIIIlIIllllIl.equals("back")) {
            return lllllllllllllIlIIlllIIIlIIllllII.boatSides[1];
        }
        if (lllllllllllllIlIIlllIIIlIIllllIl.equals("front")) {
            return lllllllllllllIlIIlllIIIlIIllllII.boatSides[2];
        }
        if (lllllllllllllIlIIlllIIIlIIllllIl.equals("right")) {
            return lllllllllllllIlIIlllIIIlIIllllII.boatSides[3];
        }
        if (lllllllllllllIlIIlllIIIlIIllllIl.equals("left")) {
            return lllllllllllllIlIIlllIIIlIIllllII.boatSides[4];
        }
        if (lllllllllllllIlIIlllIIIlIIllllIl.equals("paddle_left")) {
            return lllllllllllllIlIIlllIIIlIIllllII.paddles[0];
        }
        if (lllllllllllllIlIIlllIIIlIIllllIl.equals("paddle_right")) {
            return lllllllllllllIlIIlllIIIlIIllllII.paddles[1];
        }
        return lllllllllllllIlIIlllIIIlIIllllIl.equals("bottom_no_water") ? lllllllllllllIlIIlllIIIlIIllllII.noWater : null;
    }
    
    public ModelAdapterBoat() {
        super(EntityBoat.class, "boat", 0.5f);
    }
}
