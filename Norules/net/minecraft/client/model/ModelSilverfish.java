package net.minecraft.client.model;

import net.minecraft.entity.*;
import net.minecraft.util.math.*;

public class ModelSilverfish extends ModelBase
{
    private final /* synthetic */ ModelRenderer[] silverfishBodyParts;
    private final /* synthetic */ ModelRenderer[] silverfishWings;
    private final /* synthetic */ float[] zPlacement;
    private static final /* synthetic */ int[][] SILVERFISH_TEXTURE_POSITIONS;
    private static final /* synthetic */ int[][] SILVERFISH_BOX_LENGTH;
    
    static {
        SILVERFISH_BOX_LENGTH = new int[][] { { 3, 2, 2 }, { 4, 3, 2 }, { 6, 4, 3 }, { 3, 3, 3 }, { 2, 2, 3 }, { 2, 1, 2 }, { 1, 1, 2 } };
        SILVERFISH_TEXTURE_POSITIONS = new int[][] { new int[2], { 0, 4 }, { 0, 9 }, { 0, 16 }, { 0, 22 }, { 11, 0 }, { 13, 4 } };
    }
    
    public ModelSilverfish() {
        this.silverfishBodyParts = new ModelRenderer[7];
        this.zPlacement = new float[7];
        float llllllllllllllIIlIIllIlIIIlIIIIl = -3.5f;
        for (int llllllllllllllIIlIIllIlIIIlIIIII = 0; llllllllllllllIIlIIllIlIIIlIIIII < this.silverfishBodyParts.length; ++llllllllllllllIIlIIllIlIIIlIIIII) {
            (this.silverfishBodyParts[llllllllllllllIIlIIllIlIIIlIIIII] = new ModelRenderer(this, ModelSilverfish.SILVERFISH_TEXTURE_POSITIONS[llllllllllllllIIlIIllIlIIIlIIIII][0], ModelSilverfish.SILVERFISH_TEXTURE_POSITIONS[llllllllllllllIIlIIllIlIIIlIIIII][1])).addBox(ModelSilverfish.SILVERFISH_BOX_LENGTH[llllllllllllllIIlIIllIlIIIlIIIII][0] * -0.5f, 0.0f, ModelSilverfish.SILVERFISH_BOX_LENGTH[llllllllllllllIIlIIllIlIIIlIIIII][2] * -0.5f, ModelSilverfish.SILVERFISH_BOX_LENGTH[llllllllllllllIIlIIllIlIIIlIIIII][0], ModelSilverfish.SILVERFISH_BOX_LENGTH[llllllllllllllIIlIIllIlIIIlIIIII][1], ModelSilverfish.SILVERFISH_BOX_LENGTH[llllllllllllllIIlIIllIlIIIlIIIII][2]);
            this.silverfishBodyParts[llllllllllllllIIlIIllIlIIIlIIIII].setRotationPoint(0.0f, (float)(24 - ModelSilverfish.SILVERFISH_BOX_LENGTH[llllllllllllllIIlIIllIlIIIlIIIII][1]), llllllllllllllIIlIIllIlIIIlIIIIl);
            this.zPlacement[llllllllllllllIIlIIllIlIIIlIIIII] = llllllllllllllIIlIIllIlIIIlIIIIl;
            if (llllllllllllllIIlIIllIlIIIlIIIII < this.silverfishBodyParts.length - 1) {
                llllllllllllllIIlIIllIlIIIlIIIIl += (ModelSilverfish.SILVERFISH_BOX_LENGTH[llllllllllllllIIlIIllIlIIIlIIIII][2] + ModelSilverfish.SILVERFISH_BOX_LENGTH[llllllllllllllIIlIIllIlIIIlIIIII + 1][2]) * 0.5f;
            }
        }
        this.silverfishWings = new ModelRenderer[3];
        (this.silverfishWings[0] = new ModelRenderer(this, 20, 0)).addBox(-5.0f, 0.0f, ModelSilverfish.SILVERFISH_BOX_LENGTH[2][2] * -0.5f, 10, 8, ModelSilverfish.SILVERFISH_BOX_LENGTH[2][2]);
        this.silverfishWings[0].setRotationPoint(0.0f, 16.0f, this.zPlacement[2]);
        (this.silverfishWings[1] = new ModelRenderer(this, 20, 11)).addBox(-3.0f, 0.0f, ModelSilverfish.SILVERFISH_BOX_LENGTH[4][2] * -0.5f, 6, 4, ModelSilverfish.SILVERFISH_BOX_LENGTH[4][2]);
        this.silverfishWings[1].setRotationPoint(0.0f, 20.0f, this.zPlacement[4]);
        (this.silverfishWings[2] = new ModelRenderer(this, 20, 18)).addBox(-3.0f, 0.0f, ModelSilverfish.SILVERFISH_BOX_LENGTH[4][2] * -0.5f, 6, 5, ModelSilverfish.SILVERFISH_BOX_LENGTH[1][2]);
        this.silverfishWings[2].setRotationPoint(0.0f, 19.0f, this.zPlacement[1]);
    }
    
    @Override
    public void setRotationAngles(final float llllllllllllllIIlIIllIIlllllIllI, final float llllllllllllllIIlIIllIIlllllIlIl, final float llllllllllllllIIlIIllIIlllllIlII, final float llllllllllllllIIlIIllIIlllllIIll, final float llllllllllllllIIlIIllIIlllllIIlI, final float llllllllllllllIIlIIllIIlllllIIIl, final Entity llllllllllllllIIlIIllIIlllllIIII) {
        for (int llllllllllllllIIlIIllIIllllIllll = 0; llllllllllllllIIlIIllIIllllIllll < this.silverfishBodyParts.length; ++llllllllllllllIIlIIllIIllllIllll) {
            this.silverfishBodyParts[llllllllllllllIIlIIllIIllllIllll].rotateAngleY = MathHelper.cos(llllllllllllllIIlIIllIIlllllIlII * 0.9f + llllllllllllllIIlIIllIIllllIllll * 0.15f * 3.1415927f) * 3.1415927f * 0.05f * (1 + Math.abs(llllllllllllllIIlIIllIIllllIllll - 2));
            this.silverfishBodyParts[llllllllllllllIIlIIllIIllllIllll].rotationPointX = MathHelper.sin(llllllllllllllIIlIIllIIlllllIlII * 0.9f + llllllllllllllIIlIIllIIllllIllll * 0.15f * 3.1415927f) * 3.1415927f * 0.2f * Math.abs(llllllllllllllIIlIIllIIllllIllll - 2);
        }
        this.silverfishWings[0].rotateAngleY = this.silverfishBodyParts[2].rotateAngleY;
        this.silverfishWings[1].rotateAngleY = this.silverfishBodyParts[4].rotateAngleY;
        this.silverfishWings[1].rotationPointX = this.silverfishBodyParts[4].rotationPointX;
        this.silverfishWings[2].rotateAngleY = this.silverfishBodyParts[1].rotateAngleY;
        this.silverfishWings[2].rotationPointX = this.silverfishBodyParts[1].rotationPointX;
    }
    
    @Override
    public void render(final Entity llllllllllllllIIlIIllIlIIIIIllll, final float llllllllllllllIIlIIllIlIIIIIIlII, final float llllllllllllllIIlIIllIlIIIIIIIll, final float llllllllllllllIIlIIllIlIIIIIllII, final float llllllllllllllIIlIIllIlIIIIIIIIl, final float llllllllllllllIIlIIllIlIIIIIlIlI, final float llllllllllllllIIlIIllIlIIIIIlIIl) {
        this.setRotationAngles(llllllllllllllIIlIIllIlIIIIIIlII, llllllllllllllIIlIIllIlIIIIIIIll, llllllllllllllIIlIIllIlIIIIIllII, llllllllllllllIIlIIllIlIIIIIIIIl, llllllllllllllIIlIIllIlIIIIIlIlI, llllllllllllllIIlIIllIlIIIIIlIIl, llllllllllllllIIlIIllIlIIIIIllll);
        boolean llllllllllllllIIlIIllIIllllllIll;
        int llllllllllllllIIlIIllIIlllllllII = ((ModelRenderer[])(Object)(llllllllllllllIIlIIllIIllllllIll = (boolean)(Object)this.silverfishBodyParts)).length;
        for (char llllllllllllllIIlIIllIIlllllllIl = '\0'; llllllllllllllIIlIIllIIlllllllIl < llllllllllllllIIlIIllIIlllllllII; ++llllllllllllllIIlIIllIIlllllllIl) {
            final ModelRenderer llllllllllllllIIlIIllIlIIIIIlIII = llllllllllllllIIlIIllIIllllllIll[llllllllllllllIIlIIllIIlllllllIl];
            llllllllllllllIIlIIllIlIIIIIlIII.render(llllllllllllllIIlIIllIlIIIIIlIIl);
        }
        llllllllllllllIIlIIllIIlllllllII = ((ModelRenderer[])(Object)(llllllllllllllIIlIIllIIllllllIll = (boolean)(Object)this.silverfishWings)).length;
        for (char llllllllllllllIIlIIllIIlllllllIl = '\0'; llllllllllllllIIlIIllIIlllllllIl < llllllllllllllIIlIIllIIlllllllII; ++llllllllllllllIIlIIllIIlllllllIl) {
            final ModelRenderer llllllllllllllIIlIIllIlIIIIIIlll = llllllllllllllIIlIIllIIllllllIll[llllllllllllllIIlIIllIIlllllllIl];
            llllllllllllllIIlIIllIlIIIIIIlll.render(llllllllllllllIIlIIllIlIIIIIlIIl);
        }
    }
}
