package net.optifine.entity.model;

import net.minecraft.client.model.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.entity.monster.*;

public class ModelAdapterSpider extends ModelAdapter
{
    protected ModelAdapterSpider(final Class lllllllllllllIlIlIIIIIIIlIIIIIII, final String lllllllllllllIlIlIIIIIIIIlllllll, final float lllllllllllllIlIlIIIIIIIlIIIIIlI) {
        super(lllllllllllllIlIlIIIIIIIlIIIIIII, lllllllllllllIlIlIIIIIIIIlllllll, lllllllllllllIlIlIIIIIIIlIIIIIlI);
    }
    
    @Override
    public ModelRenderer getModelRenderer(final ModelBase lllllllllllllIlIlIIIIIIIIllllIII, final String lllllllllllllIlIlIIIIIIIIlllIlll) {
        if (!(lllllllllllllIlIlIIIIIIIIllllIII instanceof ModelSpider)) {
            return null;
        }
        final ModelSpider lllllllllllllIlIlIIIIIIIIlllIllI = (ModelSpider)lllllllllllllIlIlIIIIIIIIllllIII;
        if (lllllllllllllIlIlIIIIIIIIlllIlll.equals("head")) {
            return lllllllllllllIlIlIIIIIIIIlllIllI.spiderHead;
        }
        if (lllllllllllllIlIlIIIIIIIIlllIlll.equals("neck")) {
            return lllllllllllllIlIlIIIIIIIIlllIllI.spiderNeck;
        }
        if (lllllllllllllIlIlIIIIIIIIlllIlll.equals("body")) {
            return lllllllllllllIlIlIIIIIIIIlllIllI.spiderBody;
        }
        if (lllllllllllllIlIlIIIIIIIIlllIlll.equals("leg1")) {
            return lllllllllllllIlIlIIIIIIIIlllIllI.spiderLeg1;
        }
        if (lllllllllllllIlIlIIIIIIIIlllIlll.equals("leg2")) {
            return lllllllllllllIlIlIIIIIIIIlllIllI.spiderLeg2;
        }
        if (lllllllllllllIlIlIIIIIIIIlllIlll.equals("leg3")) {
            return lllllllllllllIlIlIIIIIIIIlllIllI.spiderLeg3;
        }
        if (lllllllllllllIlIlIIIIIIIIlllIlll.equals("leg4")) {
            return lllllllllllllIlIlIIIIIIIIlllIllI.spiderLeg4;
        }
        if (lllllllllllllIlIlIIIIIIIIlllIlll.equals("leg5")) {
            return lllllllllllllIlIlIIIIIIIIlllIllI.spiderLeg5;
        }
        if (lllllllllllllIlIlIIIIIIIIlllIlll.equals("leg6")) {
            return lllllllllllllIlIlIIIIIIIIlllIllI.spiderLeg6;
        }
        if (lllllllllllllIlIlIIIIIIIIlllIlll.equals("leg7")) {
            return lllllllllllllIlIlIIIIIIIIlllIllI.spiderLeg7;
        }
        return lllllllllllllIlIlIIIIIIIIlllIlll.equals("leg8") ? lllllllllllllIlIlIIIIIIIIlllIllI.spiderLeg8 : null;
    }
    
    @Override
    public IEntityRenderer makeEntityRender(final ModelBase lllllllllllllIlIlIIIIIIIIllIllIl, final float lllllllllllllIlIlIIIIIIIIllIlIII) {
        final RenderManager lllllllllllllIlIlIIIIIIIIllIlIll = Minecraft.getMinecraft().getRenderManager();
        final RenderSpider lllllllllllllIlIlIIIIIIIIllIlIlI = new RenderSpider(lllllllllllllIlIlIIIIIIIIllIlIll);
        lllllllllllllIlIlIIIIIIIIllIlIlI.mainModel = lllllllllllllIlIlIIIIIIIIllIllIl;
        lllllllllllllIlIlIIIIIIIIllIlIlI.shadowSize = lllllllllllllIlIlIIIIIIIIllIlIII;
        return lllllllllllllIlIlIIIIIIIIllIlIlI;
    }
    
    @Override
    public ModelBase makeModel() {
        return new ModelSpider();
    }
    
    public ModelAdapterSpider() {
        super(EntitySpider.class, "spider", 1.0f);
    }
}
