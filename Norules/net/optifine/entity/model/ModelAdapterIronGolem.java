package net.optifine.entity.model;

import net.minecraft.client.model.*;
import net.minecraft.entity.monster.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.entity.*;

public class ModelAdapterIronGolem extends ModelAdapter
{
    @Override
    public ModelRenderer getModelRenderer(final ModelBase llllllllllllllllIIlllllllllIIlII, final String llllllllllllllllIIlllllllllIIIll) {
        if (!(llllllllllllllllIIlllllllllIIlII instanceof ModelIronGolem)) {
            return null;
        }
        final ModelIronGolem llllllllllllllllIIlllllllllIIlIl = (ModelIronGolem)llllllllllllllllIIlllllllllIIlII;
        if (llllllllllllllllIIlllllllllIIIll.equals("head")) {
            return llllllllllllllllIIlllllllllIIlIl.ironGolemHead;
        }
        if (llllllllllllllllIIlllllllllIIIll.equals("body")) {
            return llllllllllllllllIIlllllllllIIlIl.ironGolemBody;
        }
        if (llllllllllllllllIIlllllllllIIIll.equals("left_arm")) {
            return llllllllllllllllIIlllllllllIIlIl.ironGolemLeftArm;
        }
        if (llllllllllllllllIIlllllllllIIIll.equals("right_arm")) {
            return llllllllllllllllIIlllllllllIIlIl.ironGolemRightArm;
        }
        if (llllllllllllllllIIlllllllllIIIll.equals("left_leg")) {
            return llllllllllllllllIIlllllllllIIlIl.ironGolemLeftLeg;
        }
        return llllllllllllllllIIlllllllllIIIll.equals("right_leg") ? llllllllllllllllIIlllllllllIIlIl.ironGolemRightLeg : null;
    }
    
    @Override
    public ModelBase makeModel() {
        return new ModelIronGolem();
    }
    
    public ModelAdapterIronGolem() {
        super(EntityIronGolem.class, "iron_golem", 0.5f);
    }
    
    @Override
    public IEntityRenderer makeEntityRender(final ModelBase llllllllllllllllIIllllllllIllIII, final float llllllllllllllllIIllllllllIllIll) {
        final RenderManager llllllllllllllllIIllllllllIllIlI = Minecraft.getMinecraft().getRenderManager();
        final RenderIronGolem llllllllllllllllIIllllllllIllIIl = new RenderIronGolem(llllllllllllllllIIllllllllIllIlI);
        llllllllllllllllIIllllllllIllIIl.mainModel = llllllllllllllllIIllllllllIllIII;
        llllllllllllllllIIllllllllIllIIl.shadowSize = llllllllllllllllIIllllllllIllIll;
        return llllllllllllllllIIllllllllIllIIl;
    }
}
