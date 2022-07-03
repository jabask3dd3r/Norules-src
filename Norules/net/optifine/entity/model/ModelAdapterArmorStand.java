package net.optifine.entity.model;

import net.minecraft.entity.item.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.model.*;

public class ModelAdapterArmorStand extends ModelAdapter
{
    public ModelAdapterArmorStand() {
        super(EntityArmorStand.class, "armor_stand", 0.7f);
    }
    
    @Override
    public ModelBase makeModel() {
        return new ModelArmorStand();
    }
    
    @Override
    public IEntityRenderer makeEntityRender(final ModelBase lllllllllllllIllIIlllIIllIllIIlI, final float lllllllllllllIllIIlllIIllIlIllIl) {
        final RenderManager lllllllllllllIllIIlllIIllIllIIII = Minecraft.getMinecraft().getRenderManager();
        final RenderArmorStand lllllllllllllIllIIlllIIllIlIllll = new RenderArmorStand(lllllllllllllIllIIlllIIllIllIIII);
        lllllllllllllIllIIlllIIllIlIllll.mainModel = lllllllllllllIllIIlllIIllIllIIlI;
        lllllllllllllIllIIlllIIllIlIllll.shadowSize = lllllllllllllIllIIlllIIllIlIllIl;
        return lllllllllllllIllIIlllIIllIlIllll;
    }
    
    @Override
    public ModelRenderer getModelRenderer(final ModelBase lllllllllllllIllIIlllIIllIllllIl, final String lllllllllllllIllIIlllIIllIlllIIl) {
        if (!(lllllllllllllIllIIlllIIllIllllIl instanceof ModelArmorStand)) {
            return null;
        }
        final ModelArmorStand lllllllllllllIllIIlllIIllIlllIll = (ModelArmorStand)lllllllllllllIllIIlllIIllIllllIl;
        if (lllllllllllllIllIIlllIIllIlllIIl.equals("right")) {
            return lllllllllllllIllIIlllIIllIlllIll.standRightSide;
        }
        if (lllllllllllllIllIIlllIIllIlllIIl.equals("left")) {
            return lllllllllllllIllIIlllIIllIlllIll.standLeftSide;
        }
        if (lllllllllllllIllIIlllIIllIlllIIl.equals("waist")) {
            return lllllllllllllIllIIlllIIllIlllIll.standWaist;
        }
        return lllllllllllllIllIIlllIIllIlllIIl.equals("base") ? lllllllllllllIllIIlllIIllIlllIll.standBase : null;
    }
}
