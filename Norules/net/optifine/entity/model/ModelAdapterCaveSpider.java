package net.optifine.entity.model;

import net.minecraft.entity.monster.*;
import net.minecraft.client.model.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.entity.*;

public class ModelAdapterCaveSpider extends ModelAdapterSpider
{
    public ModelAdapterCaveSpider() {
        super(EntityCaveSpider.class, "cave_spider", 0.7f);
    }
    
    @Override
    public IEntityRenderer makeEntityRender(final ModelBase lllllllllllllIllIIlIIIIlIIIllIIl, final float lllllllllllllIllIIlIIIIlIIIllIII) {
        final RenderManager lllllllllllllIllIIlIIIIlIIIllIll = Minecraft.getMinecraft().getRenderManager();
        final RenderCaveSpider lllllllllllllIllIIlIIIIlIIIllIlI = new RenderCaveSpider(lllllllllllllIllIIlIIIIlIIIllIll);
        lllllllllllllIllIIlIIIIlIIIllIlI.mainModel = lllllllllllllIllIIlIIIIlIIIllIIl;
        lllllllllllllIllIIlIIIIlIIIllIlI.shadowSize = lllllllllllllIllIIlIIIIlIIIllIII;
        return lllllllllllllIllIIlIIIIlIIIllIlI;
    }
}
