package net.optifine.entity.model;

import net.minecraft.util.*;

public class CustomEntityRenderer
{
    private /* synthetic */ float shadowSize;
    private /* synthetic */ ResourceLocation textureLocation;
    private /* synthetic */ CustomModelRenderer[] customModelRenderers;
    private /* synthetic */ String name;
    private /* synthetic */ String basePath;
    
    public float getShadowSize() {
        return this.shadowSize;
    }
    
    public CustomModelRenderer[] getCustomModelRenderers() {
        return this.customModelRenderers;
    }
    
    public ResourceLocation getTextureLocation() {
        return this.textureLocation;
    }
    
    public CustomEntityRenderer(final String llllllllllllllIIIIlIIllIIllllIll, final String llllllllllllllIIIIlIIllIIllllIlI, final ResourceLocation llllllllllllllIIIIlIIllIIllllIIl, final CustomModelRenderer[] llllllllllllllIIIIlIIllIIlllIIlI, final float llllllllllllllIIIIlIIllIIlllIIIl) {
        this.name = null;
        this.basePath = null;
        this.textureLocation = null;
        this.customModelRenderers = null;
        this.shadowSize = 0.0f;
        this.name = llllllllllllllIIIIlIIllIIllllIll;
        this.basePath = llllllllllllllIIIIlIIllIIllllIlI;
        this.textureLocation = llllllllllllllIIIIlIIllIIllllIIl;
        this.customModelRenderers = llllllllllllllIIIIlIIllIIlllIIlI;
        this.shadowSize = llllllllllllllIIIIlIIllIIlllIIIl;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getBasePath() {
        return this.basePath;
    }
}
