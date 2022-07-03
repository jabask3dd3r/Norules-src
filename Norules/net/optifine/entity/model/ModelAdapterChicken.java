package net.optifine.entity.model;

import net.minecraft.client.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.entity.passive.*;
import net.minecraft.client.model.*;

public class ModelAdapterChicken extends ModelAdapter
{
    @Override
    public IEntityRenderer makeEntityRender(final ModelBase lllllllllllllIIlllllIIlIlIlllIll, final float lllllllllllllIIlllllIIlIlIlllIlI) {
        final RenderManager lllllllllllllIIlllllIIlIlIlllIIl = Minecraft.getMinecraft().getRenderManager();
        final RenderChicken lllllllllllllIIlllllIIlIlIlllIII = new RenderChicken(lllllllllllllIIlllllIIlIlIlllIIl);
        lllllllllllllIIlllllIIlIlIlllIII.mainModel = lllllllllllllIIlllllIIlIlIlllIll;
        lllllllllllllIIlllllIIlIlIlllIII.shadowSize = lllllllllllllIIlllllIIlIlIlllIlI;
        return lllllllllllllIIlllllIIlIlIlllIII;
    }
    
    public ModelAdapterChicken() {
        super(EntityChicken.class, "chicken", 0.3f);
    }
    
    @Override
    public ModelBase makeModel() {
        return new ModelChicken();
    }
    
    @Override
    public ModelRenderer getModelRenderer(final ModelBase lllllllllllllIIlllllIIlIllIIIllI, final String lllllllllllllIIlllllIIlIllIIIIlI) {
        if (!(lllllllllllllIIlllllIIlIllIIIllI instanceof ModelChicken)) {
            return null;
        }
        final ModelChicken lllllllllllllIIlllllIIlIllIIIlII = (ModelChicken)lllllllllllllIIlllllIIlIllIIIllI;
        if (lllllllllllllIIlllllIIlIllIIIIlI.equals("head")) {
            return lllllllllllllIIlllllIIlIllIIIlII.head;
        }
        if (lllllllllllllIIlllllIIlIllIIIIlI.equals("body")) {
            return lllllllllllllIIlllllIIlIllIIIlII.body;
        }
        if (lllllllllllllIIlllllIIlIllIIIIlI.equals("right_leg")) {
            return lllllllllllllIIlllllIIlIllIIIlII.rightLeg;
        }
        if (lllllllllllllIIlllllIIlIllIIIIlI.equals("left_leg")) {
            return lllllllllllllIIlllllIIlIllIIIlII.leftLeg;
        }
        if (lllllllllllllIIlllllIIlIllIIIIlI.equals("right_wing")) {
            return lllllllllllllIIlllllIIlIllIIIlII.rightWing;
        }
        if (lllllllllllllIIlllllIIlIllIIIIlI.equals("left_wing")) {
            return lllllllllllllIIlllllIIlIllIIIlII.leftWing;
        }
        if (lllllllllllllIIlllllIIlIllIIIIlI.equals("bill")) {
            return lllllllllllllIIlllllIIlIllIIIlII.bill;
        }
        return lllllllllllllIIlllllIIlIllIIIIlI.equals("chin") ? lllllllllllllIIlllllIIlIllIIIlII.chin : null;
    }
}
