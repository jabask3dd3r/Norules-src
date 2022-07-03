package net.optifine.entity.model;

import net.minecraft.client.model.*;
import net.optifine.entity.model.anim.*;

public class CustomModelRenderer
{
    private /* synthetic */ String modelPart;
    private /* synthetic */ ModelRenderer modelRenderer;
    private /* synthetic */ boolean attach;
    private /* synthetic */ ModelUpdater modelUpdater;
    
    public ModelUpdater getModelUpdater() {
        return this.modelUpdater;
    }
    
    public String getModelPart() {
        return this.modelPart;
    }
    
    public boolean isAttach() {
        return this.attach;
    }
    
    public CustomModelRenderer(final String lllllllllllllIlIlIIllllIllllIIll, final boolean lllllllllllllIlIlIIllllIllllIIlI, final ModelRenderer lllllllllllllIlIlIIllllIllllIllI, final ModelUpdater lllllllllllllIlIlIIllllIllllIlIl) {
        this.modelPart = lllllllllllllIlIlIIllllIllllIIll;
        this.attach = lllllllllllllIlIlIIllllIllllIIlI;
        this.modelRenderer = lllllllllllllIlIlIIllllIllllIllI;
        this.modelUpdater = lllllllllllllIlIlIIllllIllllIlIl;
    }
    
    public ModelRenderer getModelRenderer() {
        return this.modelRenderer;
    }
}
