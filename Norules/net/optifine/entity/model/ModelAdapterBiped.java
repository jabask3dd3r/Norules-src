package net.optifine.entity.model;

import net.minecraft.client.model.*;

public abstract class ModelAdapterBiped extends ModelAdapter
{
    public ModelAdapterBiped(final Class lllllllllllllIIlIlIIlIIlIIIllIll, final String lllllllllllllIIlIlIIlIIlIIIllIlI, final float lllllllllllllIIlIlIIlIIlIIIllIIl) {
        super(lllllllllllllIIlIlIIlIIlIIIllIll, lllllllllllllIIlIlIIlIIlIIIllIlI, lllllllllllllIIlIlIIlIIlIIIllIIl);
    }
    
    @Override
    public ModelRenderer getModelRenderer(final ModelBase lllllllllllllIIlIlIIlIIlIIIIllIl, final String lllllllllllllIIlIlIIlIIlIIIIllll) {
        if (!(lllllllllllllIIlIlIIlIIlIIIIllIl instanceof ModelBiped)) {
            return null;
        }
        final ModelBiped lllllllllllllIIlIlIIlIIlIIIIlllI = (ModelBiped)lllllllllllllIIlIlIIlIIlIIIIllIl;
        if (lllllllllllllIIlIlIIlIIlIIIIllll.equals("head")) {
            return lllllllllllllIIlIlIIlIIlIIIIlllI.bipedHead;
        }
        if (lllllllllllllIIlIlIIlIIlIIIIllll.equals("headwear")) {
            return lllllllllllllIIlIlIIlIIlIIIIlllI.bipedHeadwear;
        }
        if (lllllllllllllIIlIlIIlIIlIIIIllll.equals("body")) {
            return lllllllllllllIIlIlIIlIIlIIIIlllI.bipedBody;
        }
        if (lllllllllllllIIlIlIIlIIlIIIIllll.equals("left_arm")) {
            return lllllllllllllIIlIlIIlIIlIIIIlllI.bipedLeftArm;
        }
        if (lllllllllllllIIlIlIIlIIlIIIIllll.equals("right_arm")) {
            return lllllllllllllIIlIlIIlIIlIIIIlllI.bipedRightArm;
        }
        if (lllllllllllllIIlIlIIlIIlIIIIllll.equals("left_leg")) {
            return lllllllllllllIIlIlIIlIIlIIIIlllI.bipedLeftLeg;
        }
        return lllllllllllllIIlIlIIlIIlIIIIllll.equals("right_leg") ? lllllllllllllIIlIlIIlIIlIIIIlllI.bipedRightLeg : null;
    }
}
