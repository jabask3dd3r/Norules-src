package net.minecraft.client.model;

import net.minecraft.entity.*;

public class ModelLlamaSpit extends ModelBase
{
    private final /* synthetic */ ModelRenderer field_191225_a;
    
    @Override
    public void render(final Entity lllllllllllllllIlIllIIlllIlllllI, final float lllllllllllllllIlIllIIlllIllllIl, final float lllllllllllllllIlIllIIlllIllllII, final float lllllllllllllllIlIllIIlllIlllIll, final float lllllllllllllllIlIllIIlllIlllIlI, final float lllllllllllllllIlIllIIllllIIIIIl, final float lllllllllllllllIlIllIIlllIlllIII) {
        this.setRotationAngles(lllllllllllllllIlIllIIlllIllllIl, lllllllllllllllIlIllIIlllIllllII, lllllllllllllllIlIllIIlllIlllIll, lllllllllllllllIlIllIIlllIlllIlI, lllllllllllllllIlIllIIllllIIIIIl, lllllllllllllllIlIllIIlllIlllIII, lllllllllllllllIlIllIIlllIlllllI);
        this.field_191225_a.render(lllllllllllllllIlIllIIlllIlllIII);
    }
    
    public ModelLlamaSpit(final float lllllllllllllllIlIllIIllllIlIIIl) {
        this.field_191225_a = new ModelRenderer(this);
        final int lllllllllllllllIlIllIIllllIlIIll = 2;
        this.field_191225_a.setTextureOffset(0, 0).addBox(-4.0f, 0.0f, 0.0f, 2, 2, 2, lllllllllllllllIlIllIIllllIlIIIl);
        this.field_191225_a.setTextureOffset(0, 0).addBox(0.0f, -4.0f, 0.0f, 2, 2, 2, lllllllllllllllIlIllIIllllIlIIIl);
        this.field_191225_a.setTextureOffset(0, 0).addBox(0.0f, 0.0f, -4.0f, 2, 2, 2, lllllllllllllllIlIllIIllllIlIIIl);
        this.field_191225_a.setTextureOffset(0, 0).addBox(0.0f, 0.0f, 0.0f, 2, 2, 2, lllllllllllllllIlIllIIllllIlIIIl);
        this.field_191225_a.setTextureOffset(0, 0).addBox(2.0f, 0.0f, 0.0f, 2, 2, 2, lllllllllllllllIlIllIIllllIlIIIl);
        this.field_191225_a.setTextureOffset(0, 0).addBox(0.0f, 2.0f, 0.0f, 2, 2, 2, lllllllllllllllIlIllIIllllIlIIIl);
        this.field_191225_a.setTextureOffset(0, 0).addBox(0.0f, 0.0f, 2.0f, 2, 2, 2, lllllllllllllllIlIllIIllllIlIIIl);
        this.field_191225_a.setRotationPoint(0.0f, 0.0f, 0.0f);
    }
    
    public ModelLlamaSpit() {
        this(0.0f);
    }
}
