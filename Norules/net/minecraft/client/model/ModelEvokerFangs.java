package net.minecraft.client.model;

import net.minecraft.entity.*;
import net.minecraft.util.math.*;

public class ModelEvokerFangs extends ModelBase
{
    private final /* synthetic */ ModelRenderer field_191215_c;
    private final /* synthetic */ ModelRenderer field_191213_a;
    private final /* synthetic */ ModelRenderer field_191214_b;
    
    @Override
    public void render(final Entity lllllllllllllllllIIlIIIIIIlIlIlI, final float lllllllllllllllllIIlIIIIIIlIIIII, final float lllllllllllllllllIIlIIIIIIlIlIII, final float lllllllllllllllllIIlIIIIIIlIIlll, final float lllllllllllllllllIIlIIIIIIlIIllI, final float lllllllllllllllllIIlIIIIIIlIIlIl, final float lllllllllllllllllIIlIIIIIIlIIlII) {
        float lllllllllllllllllIIlIIIIIIlIIIll = lllllllllllllllllIIlIIIIIIlIIIII * 2.0f;
        if (lllllllllllllllllIIlIIIIIIlIIIll > 1.0f) {
            lllllllllllllllllIIlIIIIIIlIIIll = 1.0f;
        }
        lllllllllllllllllIIlIIIIIIlIIIll = 1.0f - lllllllllllllllllIIlIIIIIIlIIIll * lllllllllllllllllIIlIIIIIIlIIIll * lllllllllllllllllIIlIIIIIIlIIIll;
        this.field_191214_b.rotateAngleZ = 3.1415927f - lllllllllllllllllIIlIIIIIIlIIIll * 0.35f * 3.1415927f;
        this.field_191215_c.rotateAngleZ = 3.1415927f + lllllllllllllllllIIlIIIIIIlIIIll * 0.35f * 3.1415927f;
        this.field_191215_c.rotateAngleY = 3.1415927f;
        final float lllllllllllllllllIIlIIIIIIlIIIlI = (lllllllllllllllllIIlIIIIIIlIIIII + MathHelper.sin(lllllllllllllllllIIlIIIIIIlIIIII * 2.7f)) * 0.6f * 12.0f;
        this.field_191214_b.rotationPointY = 24.0f - lllllllllllllllllIIlIIIIIIlIIIlI;
        this.field_191215_c.rotationPointY = this.field_191214_b.rotationPointY;
        this.field_191213_a.rotationPointY = this.field_191214_b.rotationPointY;
        this.field_191213_a.render(lllllllllllllllllIIlIIIIIIlIIlII);
        this.field_191214_b.render(lllllllllllllllllIIlIIIIIIlIIlII);
        this.field_191215_c.render(lllllllllllllllllIIlIIIIIIlIIlII);
    }
    
    public ModelEvokerFangs() {
        this.field_191213_a = new ModelRenderer(this, 0, 0);
        this.field_191213_a.setRotationPoint(-5.0f, 22.0f, -5.0f);
        this.field_191213_a.addBox(0.0f, 0.0f, 0.0f, 10, 12, 10);
        this.field_191214_b = new ModelRenderer(this, 40, 0);
        this.field_191214_b.setRotationPoint(1.5f, 22.0f, -4.0f);
        this.field_191214_b.addBox(0.0f, 0.0f, 0.0f, 4, 14, 8);
        this.field_191215_c = new ModelRenderer(this, 40, 0);
        this.field_191215_c.setRotationPoint(-1.5f, 22.0f, 4.0f);
        this.field_191215_c.addBox(0.0f, 0.0f, 0.0f, 4, 14, 8);
    }
}
