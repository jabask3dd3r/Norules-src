package net.optifine.entity.model;

import net.minecraft.entity.item.*;
import net.minecraft.client.model.*;
import net.minecraft.client.*;
import optifine.*;
import net.minecraft.client.renderer.entity.*;

public class ModelAdapterMinecartTnt extends ModelAdapterMinecart
{
    public ModelAdapterMinecartTnt() {
        super(EntityMinecartTNT.class, "tnt_minecart", 0.5f);
    }
    
    @Override
    public IEntityRenderer makeEntityRender(final ModelBase lllllllllllllIlllIlIlIlIIlIIllIl, final float lllllllllllllIlllIlIlIlIIlIIlIII) {
        final RenderManager lllllllllllllIlllIlIlIlIIlIIlIll = Minecraft.getMinecraft().getRenderManager();
        final RenderTntMinecart lllllllllllllIlllIlIlIlIIlIIlIlI = new RenderTntMinecart(lllllllllllllIlllIlIlIlIIlIIlIll);
        if (!Reflector.RenderMinecart_modelMinecart.exists()) {
            Config.warn("Field not found: RenderMinecart.modelMinecart");
            return null;
        }
        Reflector.setFieldValue(lllllllllllllIlllIlIlIlIIlIIlIlI, Reflector.RenderMinecart_modelMinecart, lllllllllllllIlllIlIlIlIIlIIllIl);
        lllllllllllllIlllIlIlIlIIlIIlIlI.shadowSize = lllllllllllllIlllIlIlIlIIlIIlIII;
        return lllllllllllllIlllIlIlIlIIlIIlIlI;
    }
}
