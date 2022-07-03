package net.optifine.entity.model;

import net.minecraft.entity.item.*;
import net.minecraft.client.model.*;
import net.minecraft.client.*;
import optifine.*;
import net.minecraft.client.renderer.entity.*;

public class ModelAdapterMinecartMobSpawner extends ModelAdapterMinecart
{
    public ModelAdapterMinecartMobSpawner() {
        super(EntityMinecartMobSpawner.class, "spawner_minecart", 0.5f);
    }
    
    @Override
    public IEntityRenderer makeEntityRender(final ModelBase llllllllllllllIIlllIIllIIIIIIIII, final float llllllllllllllIIlllIIlIllllllIll) {
        final RenderManager llllllllllllllIIlllIIlIllllllllI = Minecraft.getMinecraft().getRenderManager();
        final RenderMinecartMobSpawner llllllllllllllIIlllIIlIlllllllIl = new RenderMinecartMobSpawner(llllllllllllllIIlllIIlIllllllllI);
        if (!Reflector.RenderMinecart_modelMinecart.exists()) {
            Config.warn("Field not found: RenderMinecart.modelMinecart");
            return null;
        }
        Reflector.setFieldValue(llllllllllllllIIlllIIlIlllllllIl, Reflector.RenderMinecart_modelMinecart, llllllllllllllIIlllIIllIIIIIIIII);
        llllllllllllllIIlllIIlIlllllllIl.shadowSize = llllllllllllllIIlllIIlIllllllIll;
        return llllllllllllllIIlllIIlIlllllllIl;
    }
}
