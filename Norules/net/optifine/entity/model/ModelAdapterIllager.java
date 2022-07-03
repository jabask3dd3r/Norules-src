package net.optifine.entity.model;

import net.minecraft.client.model.*;

public abstract class ModelAdapterIllager extends ModelAdapter
{
    public ModelAdapterIllager(final Class lllllllllllllIIIIlIIIlIIIlIIIlll, final String lllllllllllllIIIIlIIIlIIIlIIlIlI, final float lllllllllllllIIIIlIIIlIIIlIIIlIl) {
        super(lllllllllllllIIIIlIIIlIIIlIIIlll, lllllllllllllIIIIlIIIlIIIlIIlIlI, lllllllllllllIIIIlIIIlIIIlIIIlIl);
    }
    
    @Override
    public ModelRenderer getModelRenderer(final ModelBase lllllllllllllIIIIlIIIlIIIIllllIl, final String lllllllllllllIIIIlIIIlIIIIllllII) {
        if (!(lllllllllllllIIIIlIIIlIIIIllllIl instanceof ModelIllager)) {
            return null;
        }
        final ModelIllager lllllllllllllIIIIlIIIlIIIIlllllI = (ModelIllager)lllllllllllllIIIIlIIIlIIIIllllIl;
        if (lllllllllllllIIIIlIIIlIIIIllllII.equals("head")) {
            return lllllllllllllIIIIlIIIlIIIIlllllI.field_191217_a;
        }
        if (lllllllllllllIIIIlIIIlIIIIllllII.equals("body")) {
            return lllllllllllllIIIIlIIIlIIIIlllllI.field_191218_b;
        }
        if (lllllllllllllIIIIlIIIlIIIIllllII.equals("arms")) {
            return lllllllllllllIIIIlIIIlIIIIlllllI.field_191219_c;
        }
        if (lllllllllllllIIIIlIIIlIIIIllllII.equals("left_leg")) {
            return lllllllllllllIIIIlIIIlIIIIlllllI.field_191221_e;
        }
        if (lllllllllllllIIIIlIIIlIIIIllllII.equals("right_leg")) {
            return lllllllllllllIIIIlIIIlIIIIlllllI.field_191220_d;
        }
        if (lllllllllllllIIIIlIIIlIIIIllllII.equals("nose")) {
            return lllllllllllllIIIIlIIIlIIIIlllllI.field_191222_f;
        }
        if (lllllllllllllIIIIlIIIlIIIIllllII.equals("left_arm")) {
            return lllllllllllllIIIIlIIIlIIIIlllllI.field_191224_h;
        }
        return lllllllllllllIIIIlIIIlIIIIllllII.equals("right_arm") ? lllllllllllllIIIIlIIIlIIIIlllllI.field_191223_g : null;
    }
}
