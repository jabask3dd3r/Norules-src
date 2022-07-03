package net.optifine.entity.model;

import net.minecraft.client.model.*;
import optifine.*;
import net.minecraft.entity.monster.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.entity.*;

public class ModelAdapterWitch extends ModelAdapter
{
    @Override
    public ModelRenderer getModelRenderer(final ModelBase lllllllllllllllllIIlIIIIIIIlIIlI, final String lllllllllllllllllIIlIIIIIIIlIIIl) {
        if (!(lllllllllllllllllIIlIIIIIIIlIIlI instanceof ModelWitch)) {
            return null;
        }
        final ModelWitch lllllllllllllllllIIlIIIIIIIlIIII = (ModelWitch)lllllllllllllllllIIlIIIIIIIlIIlI;
        if (lllllllllllllllllIIlIIIIIIIlIIIl.equals("mole")) {
            return (ModelRenderer)Reflector.getFieldValue(lllllllllllllllllIIlIIIIIIIlIIII, Reflector.ModelWitch_mole);
        }
        if (lllllllllllllllllIIlIIIIIIIlIIIl.equals("hat")) {
            return (ModelRenderer)Reflector.getFieldValue(lllllllllllllllllIIlIIIIIIIlIIII, Reflector.ModelWitch_hat);
        }
        if (lllllllllllllllllIIlIIIIIIIlIIIl.equals("head")) {
            return lllllllllllllllllIIlIIIIIIIlIIII.villagerHead;
        }
        if (lllllllllllllllllIIlIIIIIIIlIIIl.equals("body")) {
            return lllllllllllllllllIIlIIIIIIIlIIII.villagerBody;
        }
        if (lllllllllllllllllIIlIIIIIIIlIIIl.equals("arms")) {
            return lllllllllllllllllIIlIIIIIIIlIIII.villagerArms;
        }
        if (lllllllllllllllllIIlIIIIIIIlIIIl.equals("left_leg")) {
            return lllllllllllllllllIIlIIIIIIIlIIII.leftVillagerLeg;
        }
        if (lllllllllllllllllIIlIIIIIIIlIIIl.equals("right_leg")) {
            return lllllllllllllllllIIlIIIIIIIlIIII.rightVillagerLeg;
        }
        return lllllllllllllllllIIlIIIIIIIlIIIl.equals("nose") ? lllllllllllllllllIIlIIIIIIIlIIII.villagerNose : null;
    }
    
    public ModelAdapterWitch() {
        super(EntityWitch.class, "witch", 0.5f);
    }
    
    @Override
    public IEntityRenderer makeEntityRender(final ModelBase lllllllllllllllllIIlIIIIIIIIIlll, final float lllllllllllllllllIIlIIIIIIIIIllI) {
        final RenderManager lllllllllllllllllIIlIIIIIIIIIlIl = Minecraft.getMinecraft().getRenderManager();
        final RenderWitch lllllllllllllllllIIlIIIIIIIIIlII = new RenderWitch(lllllllllllllllllIIlIIIIIIIIIlIl);
        lllllllllllllllllIIlIIIIIIIIIlII.mainModel = lllllllllllllllllIIlIIIIIIIIIlll;
        lllllllllllllllllIIlIIIIIIIIIlII.shadowSize = lllllllllllllllllIIlIIIIIIIIIllI;
        return lllllllllllllllllIIlIIIIIIIIIlII;
    }
    
    @Override
    public ModelBase makeModel() {
        return new ModelWitch(0.0f);
    }
}
