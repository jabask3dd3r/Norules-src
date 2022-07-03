package net.optifine.entity.model;

import net.minecraft.client.model.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.entity.monster.*;

public class ModelAdapterCreeper extends ModelAdapter
{
    @Override
    public ModelRenderer getModelRenderer(final ModelBase lllllllllllllIIlllllIIIlllIlIIlI, final String lllllllllllllIIlllllIIIlllIlIlII) {
        if (!(lllllllllllllIIlllllIIIlllIlIIlI instanceof ModelCreeper)) {
            return null;
        }
        final ModelCreeper lllllllllllllIIlllllIIIlllIlIIll = (ModelCreeper)lllllllllllllIIlllllIIIlllIlIIlI;
        if (lllllllllllllIIlllllIIIlllIlIlII.equals("head")) {
            return lllllllllllllIIlllllIIIlllIlIIll.head;
        }
        if (lllllllllllllIIlllllIIIlllIlIlII.equals("armor")) {
            return lllllllllllllIIlllllIIIlllIlIIll.creeperArmor;
        }
        if (lllllllllllllIIlllllIIIlllIlIlII.equals("body")) {
            return lllllllllllllIIlllllIIIlllIlIIll.body;
        }
        if (lllllllllllllIIlllllIIIlllIlIlII.equals("leg1")) {
            return lllllllllllllIIlllllIIIlllIlIIll.leg1;
        }
        if (lllllllllllllIIlllllIIIlllIlIlII.equals("leg2")) {
            return lllllllllllllIIlllllIIIlllIlIIll.leg2;
        }
        if (lllllllllllllIIlllllIIIlllIlIlII.equals("leg3")) {
            return lllllllllllllIIlllllIIIlllIlIIll.leg3;
        }
        return lllllllllllllIIlllllIIIlllIlIlII.equals("leg4") ? lllllllllllllIIlllllIIIlllIlIIll.leg4 : null;
    }
    
    @Override
    public IEntityRenderer makeEntityRender(final ModelBase lllllllllllllIIlllllIIIlllIIIllI, final float lllllllllllllIIlllllIIIlllIIIlIl) {
        final RenderManager lllllllllllllIIlllllIIIlllIIlIII = Minecraft.getMinecraft().getRenderManager();
        final RenderCreeper lllllllllllllIIlllllIIIlllIIIlll = new RenderCreeper(lllllllllllllIIlllllIIIlllIIlIII);
        lllllllllllllIIlllllIIIlllIIIlll.mainModel = lllllllllllllIIlllllIIIlllIIIllI;
        lllllllllllllIIlllllIIIlllIIIlll.shadowSize = lllllllllllllIIlllllIIIlllIIIlIl;
        return lllllllllllllIIlllllIIIlllIIIlll;
    }
    
    @Override
    public ModelBase makeModel() {
        return new ModelCreeper();
    }
    
    public ModelAdapterCreeper() {
        super(EntityCreeper.class, "creeper", 0.5f);
    }
}
