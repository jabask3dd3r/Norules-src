package net.optifine.entity.model;

import net.minecraft.client.model.*;

public abstract class ModelAdapterQuadruped extends ModelAdapter
{
    public ModelAdapterQuadruped(final Class lllllllllllllIlIIIlIIlllllIIIIII, final String lllllllllllllIlIIIlIIllllIllllll, final float lllllllllllllIlIIIlIIllllIlllllI) {
        super(lllllllllllllIlIIIlIIlllllIIIIII, lllllllllllllIlIIIlIIllllIllllll, lllllllllllllIlIIIlIIllllIlllllI);
    }
    
    @Override
    public ModelRenderer getModelRenderer(final ModelBase lllllllllllllIlIIIlIIllllIllIlIl, final String lllllllllllllIlIIIlIIllllIllIIIl) {
        if (!(lllllllllllllIlIIIlIIllllIllIlIl instanceof ModelQuadruped)) {
            return null;
        }
        final ModelQuadruped lllllllllllllIlIIIlIIllllIllIIll = (ModelQuadruped)lllllllllllllIlIIIlIIllllIllIlIl;
        if (lllllllllllllIlIIIlIIllllIllIIIl.equals("head")) {
            return lllllllllllllIlIIIlIIllllIllIIll.head;
        }
        if (lllllllllllllIlIIIlIIllllIllIIIl.equals("body")) {
            return lllllllllllllIlIIIlIIllllIllIIll.body;
        }
        if (lllllllllllllIlIIIlIIllllIllIIIl.equals("leg1")) {
            return lllllllllllllIlIIIlIIllllIllIIll.leg1;
        }
        if (lllllllllllllIlIIIlIIllllIllIIIl.equals("leg2")) {
            return lllllllllllllIlIIIlIIllllIllIIll.leg2;
        }
        if (lllllllllllllIlIIIlIIllllIllIIIl.equals("leg3")) {
            return lllllllllllllIlIIIlIIllllIllIIll.leg3;
        }
        return lllllllllllllIlIIIlIIllllIllIIIl.equals("leg4") ? lllllllllllllIlIIIlIIllllIllIIll.leg4 : null;
    }
}
