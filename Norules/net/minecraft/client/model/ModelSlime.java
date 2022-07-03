package net.minecraft.client.model;

import net.minecraft.entity.*;
import net.minecraft.client.renderer.*;

public class ModelSlime extends ModelBase
{
    /* synthetic */ ModelRenderer slimeBodies;
    /* synthetic */ ModelRenderer slimeLeftEye;
    /* synthetic */ ModelRenderer slimeMouth;
    /* synthetic */ ModelRenderer slimeRightEye;
    
    public ModelSlime(final int lIlIIllI) {
        if (lIlIIllI > 0) {
            this.slimeBodies = new ModelRenderer(this, 0, lIlIIllI);
            this.slimeBodies.addBox(-3.0f, 17.0f, -3.0f, 6, 6, 6);
            this.slimeRightEye = new ModelRenderer(this, 32, 0);
            this.slimeRightEye.addBox(-3.25f, 18.0f, -3.5f, 2, 2, 2);
            this.slimeLeftEye = new ModelRenderer(this, 32, 4);
            this.slimeLeftEye.addBox(1.25f, 18.0f, -3.5f, 2, 2, 2);
            this.slimeMouth = new ModelRenderer(this, 32, 8);
            this.slimeMouth.addBox(0.0f, 21.0f, -3.5f, 1, 1, 1);
        }
        else {
            this.slimeBodies = new ModelRenderer(this, 0, lIlIIllI);
            this.slimeBodies.addBox(-4.0f, 16.0f, -4.0f, 8, 8, 8);
        }
    }
    
    @Override
    public void render(final Entity lIIlIlII, final float lIIllIll, final float lIIllIlI, final float lIIlIIIl, final float lIIlIIII, final float lIIlIlll, final float lIIlIllI) {
        this.setRotationAngles(lIIllIll, lIIllIlI, lIIlIIIl, lIIlIIII, lIIlIlll, lIIlIllI, lIIlIlII);
        GlStateManager.translate(0.0f, 0.001f, 0.0f);
        this.slimeBodies.render(lIIlIllI);
        if (this.slimeRightEye != null) {
            this.slimeRightEye.render(lIIlIllI);
            this.slimeLeftEye.render(lIIlIllI);
            this.slimeMouth.render(lIIlIllI);
        }
    }
}
