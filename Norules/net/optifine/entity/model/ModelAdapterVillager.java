package net.optifine.entity.model;

import net.minecraft.client.model.*;
import net.minecraft.entity.passive.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.entity.*;

public class ModelAdapterVillager extends ModelAdapter
{
    @Override
    public ModelBase makeModel() {
        return new ModelVillager(0.0f);
    }
    
    @Override
    public ModelRenderer getModelRenderer(final ModelBase lllllllllllllllIllIllIIlIIIIIIII, final String lllllllllllllllIllIllIIlIIIIIIlI) {
        if (!(lllllllllllllllIllIllIIlIIIIIIII instanceof ModelVillager)) {
            return null;
        }
        final ModelVillager lllllllllllllllIllIllIIlIIIIIIIl = (ModelVillager)lllllllllllllllIllIllIIlIIIIIIII;
        if (lllllllllllllllIllIllIIlIIIIIIlI.equals("head")) {
            return lllllllllllllllIllIllIIlIIIIIIIl.villagerHead;
        }
        if (lllllllllllllllIllIllIIlIIIIIIlI.equals("body")) {
            return lllllllllllllllIllIllIIlIIIIIIIl.villagerBody;
        }
        if (lllllllllllllllIllIllIIlIIIIIIlI.equals("arms")) {
            return lllllllllllllllIllIllIIlIIIIIIIl.villagerArms;
        }
        if (lllllllllllllllIllIllIIlIIIIIIlI.equals("left_leg")) {
            return lllllllllllllllIllIllIIlIIIIIIIl.leftVillagerLeg;
        }
        if (lllllllllllllllIllIllIIlIIIIIIlI.equals("right_leg")) {
            return lllllllllllllllIllIllIIlIIIIIIIl.rightVillagerLeg;
        }
        return lllllllllllllllIllIllIIlIIIIIIlI.equals("nose") ? lllllllllllllllIllIllIIlIIIIIIIl.villagerNose : null;
    }
    
    public ModelAdapterVillager() {
        super(EntityVillager.class, "villager", 0.5f);
    }
    
    @Override
    public IEntityRenderer makeEntityRender(final ModelBase lllllllllllllllIllIllIIIlllllIII, final float lllllllllllllllIllIllIIIllllIlll) {
        final RenderManager lllllllllllllllIllIllIIIllllIllI = Minecraft.getMinecraft().getRenderManager();
        final RenderVillager lllllllllllllllIllIllIIIllllIlIl = new RenderVillager(lllllllllllllllIllIllIIIllllIllI);
        lllllllllllllllIllIllIIIllllIlIl.mainModel = lllllllllllllllIllIllIIIlllllIII;
        lllllllllllllllIllIllIIIllllIlIl.shadowSize = lllllllllllllllIllIllIIIllllIlll;
        return lllllllllllllllIllIllIIIllllIlIl;
    }
}
