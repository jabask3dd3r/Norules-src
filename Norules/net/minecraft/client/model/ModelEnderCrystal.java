package net.minecraft.client.model;

import net.minecraft.entity.*;
import net.minecraft.client.renderer.*;

public class ModelEnderCrystal extends ModelBase
{
    private final /* synthetic */ ModelRenderer glass;
    private final /* synthetic */ ModelRenderer cube;
    private /* synthetic */ ModelRenderer base;
    
    public ModelEnderCrystal(final float llllllllllllllIlllIIIIlIlIllllIl, final boolean llllllllllllllIlllIIIIlIlIllllII) {
        this.glass = new ModelRenderer(this, "glass");
        this.glass.setTextureOffset(0, 0).addBox(-4.0f, -4.0f, -4.0f, 8, 8, 8);
        this.cube = new ModelRenderer(this, "cube");
        this.cube.setTextureOffset(32, 0).addBox(-4.0f, -4.0f, -4.0f, 8, 8, 8);
        if (llllllllllllllIlllIIIIlIlIllllII) {
            this.base = new ModelRenderer(this, "base");
            this.base.setTextureOffset(0, 16).addBox(-6.0f, 0.0f, -6.0f, 12, 4, 12);
        }
    }
    
    @Override
    public void render(final Entity llllllllllllllIlllIIIIlIlIllIIll, final float llllllllllllllIlllIIIIlIlIllIIlI, final float llllllllllllllIlllIIIIlIlIlIlIlI, final float llllllllllllllIlllIIIIlIlIllIIII, final float llllllllllllllIlllIIIIlIlIlIllll, final float llllllllllllllIlllIIIIlIlIlIlllI, final float llllllllllllllIlllIIIIlIlIlIlIII) {
        GlStateManager.pushMatrix();
        GlStateManager.scale(2.0f, 2.0f, 2.0f);
        GlStateManager.translate(0.0f, -0.5f, 0.0f);
        if (this.base != null) {
            this.base.render(llllllllllllllIlllIIIIlIlIlIlIII);
        }
        GlStateManager.rotate(llllllllllllllIlllIIIIlIlIlIlIlI, 0.0f, 1.0f, 0.0f);
        GlStateManager.translate(0.0f, 0.8f + llllllllllllllIlllIIIIlIlIllIIII, 0.0f);
        GlStateManager.rotate(60.0f, 0.7071f, 0.0f, 0.7071f);
        this.glass.render(llllllllllllllIlllIIIIlIlIlIlIII);
        final float llllllllllllllIlllIIIIlIlIlIllII = 0.875f;
        GlStateManager.scale(0.875f, 0.875f, 0.875f);
        GlStateManager.rotate(60.0f, 0.7071f, 0.0f, 0.7071f);
        GlStateManager.rotate(llllllllllllllIlllIIIIlIlIlIlIlI, 0.0f, 1.0f, 0.0f);
        this.glass.render(llllllllllllllIlllIIIIlIlIlIlIII);
        GlStateManager.scale(0.875f, 0.875f, 0.875f);
        GlStateManager.rotate(60.0f, 0.7071f, 0.0f, 0.7071f);
        GlStateManager.rotate(llllllllllllllIlllIIIIlIlIlIlIlI, 0.0f, 1.0f, 0.0f);
        this.cube.render(llllllllllllllIlllIIIIlIlIlIlIII);
        GlStateManager.popMatrix();
    }
}
