package net.minecraft.client.renderer.entity;

import net.minecraft.entity.monster.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.client.model.*;
import net.minecraft.client.renderer.entity.layers.*;

public class RenderSpider<T extends EntitySpider> extends RenderLiving<T>
{
    private static final /* synthetic */ ResourceLocation SPIDER_TEXTURES;
    
    static {
        SPIDER_TEXTURES = new ResourceLocation("textures/entity/spider/spider.png");
    }
    
    @Override
    protected float getDeathMaxRotation(final T lllllllllllllIlIIlIIlIllllIIllll) {
        return 180.0f;
    }
    
    public RenderSpider(final RenderManager lllllllllllllIlIIlIIlIllllIlIIIl) {
        super(lllllllllllllIlIIlIIlIllllIlIIIl, new ModelSpider(), 1.0f);
        this.addLayer(new LayerSpiderEyes(this));
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final T lllllllllllllIlIIlIIlIllllIIllIl) {
        return RenderSpider.SPIDER_TEXTURES;
    }
}
