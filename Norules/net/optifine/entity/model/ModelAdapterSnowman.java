package net.optifine.entity.model;

import net.minecraft.entity.monster.*;
import net.minecraft.client.model.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.entity.*;

public class ModelAdapterSnowman extends ModelAdapter
{
    @Override
    public ModelBase makeModel() {
        return new ModelSnowMan();
    }
    
    public ModelAdapterSnowman() {
        super(EntitySnowman.class, "snow_golem", 0.5f);
    }
    
    @Override
    public ModelRenderer getModelRenderer(final ModelBase lllllllllllllIIIlIIIIIIllIlllllI, final String lllllllllllllIIIlIIIIIIllIllllIl) {
        if (!(lllllllllllllIIIlIIIIIIllIlllllI instanceof ModelSnowMan)) {
            return null;
        }
        final ModelSnowMan lllllllllllllIIIlIIIIIIllIllllll = (ModelSnowMan)lllllllllllllIIIlIIIIIIllIlllllI;
        if (lllllllllllllIIIlIIIIIIllIllllIl.equals("body")) {
            return lllllllllllllIIIlIIIIIIllIllllll.body;
        }
        if (lllllllllllllIIIlIIIIIIllIllllIl.equals("body_bottom")) {
            return lllllllllllllIIIlIIIIIIllIllllll.bottomBody;
        }
        if (lllllllllllllIIIlIIIIIIllIllllIl.equals("head")) {
            return lllllllllllllIIIlIIIIIIllIllllll.head;
        }
        if (lllllllllllllIIIlIIIIIIllIllllIl.equals("left_hand")) {
            return lllllllllllllIIIlIIIIIIllIllllll.leftHand;
        }
        return lllllllllllllIIIlIIIIIIllIllllIl.equals("right_hand") ? lllllllllllllIIIlIIIIIIllIllllll.rightHand : null;
    }
    
    @Override
    public IEntityRenderer makeEntityRender(final ModelBase lllllllllllllIIIlIIIIIIllIllIllI, final float lllllllllllllIIIlIIIIIIllIllIlIl) {
        final RenderManager lllllllllllllIIIlIIIIIIllIllIlII = Minecraft.getMinecraft().getRenderManager();
        final RenderSnowMan lllllllllllllIIIlIIIIIIllIllIIll = new RenderSnowMan(lllllllllllllIIIlIIIIIIllIllIlII);
        lllllllllllllIIIlIIIIIIllIllIIll.mainModel = lllllllllllllIIIlIIIIIIllIllIllI;
        lllllllllllllIIIlIIIIIIllIllIIll.shadowSize = lllllllllllllIIIlIIIIIIllIllIlIl;
        return lllllllllllllIIIlIIIIIIllIllIIll;
    }
}
