package net.minecraft.client.renderer.entity;

import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.monster.*;

public class RenderCaveSpider extends RenderSpider<EntityCaveSpider>
{
    private static final /* synthetic */ ResourceLocation CAVE_SPIDER_TEXTURES;
    
    @Override
    protected void preRenderCallback(final EntityCaveSpider llIIlllllIIIlIl, final float llIIlllllIIIlII) {
        GlStateManager.scale(0.7f, 0.7f, 0.7f);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityCaveSpider llIIlllllIIIIlI) {
        return RenderCaveSpider.CAVE_SPIDER_TEXTURES;
    }
    
    static {
        CAVE_SPIDER_TEXTURES = new ResourceLocation("textures/entity/spider/cave_spider.png");
    }
    
    public RenderCaveSpider(final RenderManager llIIlllllIIIlll) {
        super(llIIlllllIIIlll);
        this.shadowSize *= 0.7f;
    }
}
