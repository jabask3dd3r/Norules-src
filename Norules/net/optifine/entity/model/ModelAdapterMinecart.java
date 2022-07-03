package net.optifine.entity.model;

import net.minecraft.client.model.*;
import net.minecraft.client.*;
import optifine.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.entity.item.*;

public class ModelAdapterMinecart extends ModelAdapter
{
    protected ModelAdapterMinecart(final Class lllllllllllllIlIIIIIlIllllllIIIl, final String lllllllllllllIlIIIIIlIlllllIllII, final float lllllllllllllIlIIIIIlIlllllIllll) {
        super(lllllllllllllIlIIIIIlIllllllIIIl, lllllllllllllIlIIIIIlIlllllIllII, lllllllllllllIlIIIIIlIlllllIllll);
    }
    
    @Override
    public ModelRenderer getModelRenderer(final ModelBase lllllllllllllIlIIIIIlIlllllIIIlI, final String lllllllllllllIlIIIIIlIlllllIIlII) {
        if (!(lllllllllllllIlIIIIIlIlllllIIIlI instanceof ModelMinecart)) {
            return null;
        }
        final ModelMinecart lllllllllllllIlIIIIIlIlllllIIIll = (ModelMinecart)lllllllllllllIlIIIIIlIlllllIIIlI;
        if (lllllllllllllIlIIIIIlIlllllIIlII.equals("bottom")) {
            return lllllllllllllIlIIIIIlIlllllIIIll.sideModels[0];
        }
        if (lllllllllllllIlIIIIIlIlllllIIlII.equals("back")) {
            return lllllllllllllIlIIIIIlIlllllIIIll.sideModels[1];
        }
        if (lllllllllllllIlIIIIIlIlllllIIlII.equals("front")) {
            return lllllllllllllIlIIIIIlIlllllIIIll.sideModels[2];
        }
        if (lllllllllllllIlIIIIIlIlllllIIlII.equals("right")) {
            return lllllllllllllIlIIIIIlIlllllIIIll.sideModels[3];
        }
        if (lllllllllllllIlIIIIIlIlllllIIlII.equals("left")) {
            return lllllllllllllIlIIIIIlIlllllIIIll.sideModels[4];
        }
        return lllllllllllllIlIIIIIlIlllllIIlII.equals("dirt") ? lllllllllllllIlIIIIIlIlllllIIIll.sideModels[5] : null;
    }
    
    @Override
    public IEntityRenderer makeEntityRender(final ModelBase lllllllllllllIlIIIIIlIllllIlIllI, final float lllllllllllllIlIIIIIlIllllIllIIl) {
        final RenderManager lllllllllllllIlIIIIIlIllllIllIII = Minecraft.getMinecraft().getRenderManager();
        final RenderMinecart lllllllllllllIlIIIIIlIllllIlIlll = new RenderMinecart(lllllllllllllIlIIIIIlIllllIllIII);
        if (!Reflector.RenderMinecart_modelMinecart.exists()) {
            Config.warn("Field not found: RenderMinecart.modelMinecart");
            return null;
        }
        Reflector.setFieldValue(lllllllllllllIlIIIIIlIllllIlIlll, Reflector.RenderMinecart_modelMinecart, lllllllllllllIlIIIIIlIllllIlIllI);
        lllllllllllllIlIIIIIlIllllIlIlll.shadowSize = lllllllllllllIlIIIIIlIllllIllIIl;
        return lllllllllllllIlIIIIIlIllllIlIlll;
    }
    
    public ModelAdapterMinecart() {
        super(EntityMinecart.class, "minecart", 0.5f);
    }
    
    @Override
    public ModelBase makeModel() {
        return new ModelMinecart();
    }
}
