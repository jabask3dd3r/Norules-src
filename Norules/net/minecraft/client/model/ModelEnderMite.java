package net.minecraft.client.model;

import net.minecraft.entity.*;
import net.minecraft.util.math.*;

public class ModelEnderMite extends ModelBase
{
    private static final /* synthetic */ int[][] BODY_TEXS;
    private final /* synthetic */ ModelRenderer[] bodyParts;
    private static final /* synthetic */ int BODY_COUNT;
    private static final /* synthetic */ int[][] BODY_SIZES;
    
    public ModelEnderMite() {
        this.bodyParts = new ModelRenderer[ModelEnderMite.BODY_COUNT];
        float llllllllllllIllllllIllIIlllIllIl = -3.5f;
        for (int llllllllllllIllllllIllIIlllIllII = 0; llllllllllllIllllllIllIIlllIllII < this.bodyParts.length; ++llllllllllllIllllllIllIIlllIllII) {
            (this.bodyParts[llllllllllllIllllllIllIIlllIllII] = new ModelRenderer(this, ModelEnderMite.BODY_TEXS[llllllllllllIllllllIllIIlllIllII][0], ModelEnderMite.BODY_TEXS[llllllllllllIllllllIllIIlllIllII][1])).addBox(ModelEnderMite.BODY_SIZES[llllllllllllIllllllIllIIlllIllII][0] * -0.5f, 0.0f, ModelEnderMite.BODY_SIZES[llllllllllllIllllllIllIIlllIllII][2] * -0.5f, ModelEnderMite.BODY_SIZES[llllllllllllIllllllIllIIlllIllII][0], ModelEnderMite.BODY_SIZES[llllllllllllIllllllIllIIlllIllII][1], ModelEnderMite.BODY_SIZES[llllllllllllIllllllIllIIlllIllII][2]);
            this.bodyParts[llllllllllllIllllllIllIIlllIllII].setRotationPoint(0.0f, (float)(24 - ModelEnderMite.BODY_SIZES[llllllllllllIllllllIllIIlllIllII][1]), llllllllllllIllllllIllIIlllIllIl);
            if (llllllllllllIllllllIllIIlllIllII < this.bodyParts.length - 1) {
                llllllllllllIllllllIllIIlllIllIl += (ModelEnderMite.BODY_SIZES[llllllllllllIllllllIllIIlllIllII][2] + ModelEnderMite.BODY_SIZES[llllllllllllIllllllIllIIlllIllII + 1][2]) * 0.5f;
            }
        }
    }
    
    static {
        BODY_SIZES = new int[][] { { 4, 3, 2 }, { 6, 4, 5 }, { 3, 3, 1 }, { 1, 2, 1 } };
        BODY_TEXS = new int[][] { new int[2], { 0, 5 }, { 0, 14 }, { 0, 18 } };
        BODY_COUNT = ModelEnderMite.BODY_SIZES.length;
    }
    
    @Override
    public void setRotationAngles(final float llllllllllllIllllllIllIIllIIIIll, final float llllllllllllIllllllIllIIllIIIIlI, final float llllllllllllIllllllIllIIlIlllIlI, final float llllllllllllIllllllIllIIllIIIIII, final float llllllllllllIllllllIllIIlIllllll, final float llllllllllllIllllllIllIIlIlllllI, final Entity llllllllllllIllllllIllIIlIllllIl) {
        for (int llllllllllllIllllllIllIIlIllllII = 0; llllllllllllIllllllIllIIlIllllII < this.bodyParts.length; ++llllllllllllIllllllIllIIlIllllII) {
            this.bodyParts[llllllllllllIllllllIllIIlIllllII].rotateAngleY = MathHelper.cos(llllllllllllIllllllIllIIlIlllIlI * 0.9f + llllllllllllIllllllIllIIlIllllII * 0.15f * 3.1415927f) * 3.1415927f * 0.01f * (1 + Math.abs(llllllllllllIllllllIllIIlIllllII - 2));
            this.bodyParts[llllllllllllIllllllIllIIlIllllII].rotationPointX = MathHelper.sin(llllllllllllIllllllIllIIlIlllIlI * 0.9f + llllllllllllIllllllIllIIlIllllII * 0.15f * 3.1415927f) * 3.1415927f * 0.1f * Math.abs(llllllllllllIllllllIllIIlIllllII - 2);
        }
    }
    
    @Override
    public void render(final Entity llllllllllllIllllllIllIIllIllIll, final float llllllllllllIllllllIllIIllIlIIIl, final float llllllllllllIllllllIllIIllIllIIl, final float llllllllllllIllllllIllIIllIIllll, final float llllllllllllIllllllIllIIllIIlllI, final float llllllllllllIllllllIllIIllIlIllI, final float llllllllllllIllllllIllIIllIIllII) {
        this.setRotationAngles(llllllllllllIllllllIllIIllIlIIIl, llllllllllllIllllllIllIIllIllIIl, llllllllllllIllllllIllIIllIIllll, llllllllllllIllllllIllIIllIIlllI, llllllllllllIllllllIllIIllIlIllI, llllllllllllIllllllIllIIllIIllII, llllllllllllIllllllIllIIllIllIll);
        final int llllllllllllIllllllIllIIllIIlIII;
        final boolean llllllllllllIllllllIllIIllIIlIIl = ((ModelRenderer[])(Object)(llllllllllllIllllllIllIIllIIlIII = (int)(Object)this.bodyParts)).length != 0;
        for (short llllllllllllIllllllIllIIllIIlIlI = 0; llllllllllllIllllllIllIIllIIlIlI < (llllllllllllIllllllIllIIllIIlIIl ? 1 : 0); ++llllllllllllIllllllIllIIllIIlIlI) {
            final ModelRenderer llllllllllllIllllllIllIIllIlIlII = llllllllllllIllllllIllIIllIIlIII[llllllllllllIllllllIllIIllIIlIlI];
            llllllllllllIllllllIllIIllIlIlII.render(llllllllllllIllllllIllIIllIIllII);
        }
    }
}
