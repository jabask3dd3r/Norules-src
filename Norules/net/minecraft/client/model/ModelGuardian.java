package net.minecraft.client.model;

import net.minecraft.entity.*;
import net.minecraft.entity.monster.*;
import net.minecraft.client.*;
import net.minecraft.util.math.*;

public class ModelGuardian extends ModelBase
{
    private final /* synthetic */ ModelRenderer guardianEye;
    private final /* synthetic */ ModelRenderer[] guardianTail;
    private final /* synthetic */ ModelRenderer[] guardianSpines;
    private final /* synthetic */ ModelRenderer guardianBody;
    
    @Override
    public void setRotationAngles(final float lllllllllllllllIIlIIlIllIIlIlIIl, final float lllllllllllllllIIlIIlIllIIlIlIII, final float lllllllllllllllIIlIIlIllIIIIllll, final float lllllllllllllllIIlIIlIllIIlIIllI, final float lllllllllllllllIIlIIlIllIIIIllIl, final float lllllllllllllllIIlIIlIllIIlIIlII, final Entity lllllllllllllllIIlIIlIllIIIIllII) {
        final EntityGuardian lllllllllllllllIIlIIlIllIIlIIIlI = (EntityGuardian)lllllllllllllllIIlIIlIllIIIIllII;
        final float lllllllllllllllIIlIIlIllIIlIIIIl = lllllllllllllllIIlIIlIllIIIIllll - lllllllllllllllIIlIIlIllIIlIIIlI.ticksExisted;
        this.guardianBody.rotateAngleY = lllllllllllllllIIlIIlIllIIlIIllI * 0.017453292f;
        this.guardianBody.rotateAngleX = lllllllllllllllIIlIIlIllIIIIllIl * 0.017453292f;
        final float[] lllllllllllllllIIlIIlIllIIlIIIII = { 1.75f, 0.25f, 0.0f, 0.0f, 0.5f, 0.5f, 0.5f, 0.5f, 1.25f, 0.75f, 0.0f, 0.0f };
        final float[] lllllllllllllllIIlIIlIllIIIlllll = { 0.0f, 0.0f, 0.0f, 0.0f, 0.25f, 1.75f, 1.25f, 0.75f, 0.0f, 0.0f, 0.0f, 0.0f };
        final float[] lllllllllllllllIIlIIlIllIIIllllI = { 0.0f, 0.0f, 0.25f, 1.75f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.75f, 1.25f };
        final float[] lllllllllllllllIIlIIlIllIIIlllIl = { 0.0f, 0.0f, 8.0f, -8.0f, -8.0f, 8.0f, 8.0f, -8.0f, 0.0f, 0.0f, 8.0f, -8.0f };
        final float[] lllllllllllllllIIlIIlIllIIIlllII = { -8.0f, -8.0f, -8.0f, -8.0f, 0.0f, 0.0f, 0.0f, 0.0f, 8.0f, 8.0f, 8.0f, 8.0f };
        final float[] lllllllllllllllIIlIIlIllIIIllIll = { 8.0f, -8.0f, 0.0f, 0.0f, -8.0f, -8.0f, 8.0f, 8.0f, 8.0f, -8.0f, 0.0f, 0.0f };
        final float lllllllllllllllIIlIIlIllIIIllIlI = (1.0f - lllllllllllllllIIlIIlIllIIlIIIlI.getSpikesAnimation(lllllllllllllllIIlIIlIllIIlIIIIl)) * 0.55f;
        for (int lllllllllllllllIIlIIlIllIIIllIIl = 0; lllllllllllllllIIlIIlIllIIIllIIl < 12; ++lllllllllllllllIIlIIlIllIIIllIIl) {
            this.guardianSpines[lllllllllllllllIIlIIlIllIIIllIIl].rotateAngleX = 3.1415927f * lllllllllllllllIIlIIlIllIIlIIIII[lllllllllllllllIIlIIlIllIIIllIIl];
            this.guardianSpines[lllllllllllllllIIlIIlIllIIIllIIl].rotateAngleY = 3.1415927f * lllllllllllllllIIlIIlIllIIIlllll[lllllllllllllllIIlIIlIllIIIllIIl];
            this.guardianSpines[lllllllllllllllIIlIIlIllIIIllIIl].rotateAngleZ = 3.1415927f * lllllllllllllllIIlIIlIllIIIllllI[lllllllllllllllIIlIIlIllIIIllIIl];
            this.guardianSpines[lllllllllllllllIIlIIlIllIIIllIIl].rotationPointX = lllllllllllllllIIlIIlIllIIIlllIl[lllllllllllllllIIlIIlIllIIIllIIl] * (1.0f + MathHelper.cos(lllllllllllllllIIlIIlIllIIIIllll * 1.5f + lllllllllllllllIIlIIlIllIIIllIIl) * 0.01f - lllllllllllllllIIlIIlIllIIIllIlI);
            this.guardianSpines[lllllllllllllllIIlIIlIllIIIllIIl].rotationPointY = 16.0f + lllllllllllllllIIlIIlIllIIIlllII[lllllllllllllllIIlIIlIllIIIllIIl] * (1.0f + MathHelper.cos(lllllllllllllllIIlIIlIllIIIIllll * 1.5f + lllllllllllllllIIlIIlIllIIIllIIl) * 0.01f - lllllllllllllllIIlIIlIllIIIllIlI);
            this.guardianSpines[lllllllllllllllIIlIIlIllIIIllIIl].rotationPointZ = lllllllllllllllIIlIIlIllIIIllIll[lllllllllllllllIIlIIlIllIIIllIIl] * (1.0f + MathHelper.cos(lllllllllllllllIIlIIlIllIIIIllll * 1.5f + lllllllllllllllIIlIIlIllIIIllIIl) * 0.01f - lllllllllllllllIIlIIlIllIIIllIlI);
        }
        this.guardianEye.rotationPointZ = -8.25f;
        Entity lllllllllllllllIIlIIlIllIIIllIII = Minecraft.getMinecraft().getRenderViewEntity();
        if (lllllllllllllllIIlIIlIllIIlIIIlI.hasTargetedEntity()) {
            lllllllllllllllIIlIIlIllIIIllIII = lllllllllllllllIIlIIlIllIIlIIIlI.getTargetedEntity();
        }
        if (lllllllllllllllIIlIIlIllIIIllIII != null) {
            final Vec3d lllllllllllllllIIlIIlIllIIIlIlll = lllllllllllllllIIlIIlIllIIIllIII.getPositionEyes(0.0f);
            final Vec3d lllllllllllllllIIlIIlIllIIIlIllI = lllllllllllllllIIlIIlIllIIIIllII.getPositionEyes(0.0f);
            final double lllllllllllllllIIlIIlIllIIIlIlIl = lllllllllllllllIIlIIlIllIIIlIlll.yCoord - lllllllllllllllIIlIIlIllIIIlIllI.yCoord;
            if (lllllllllllllllIIlIIlIllIIIlIlIl > 0.0) {
                this.guardianEye.rotationPointY = 0.0f;
            }
            else {
                this.guardianEye.rotationPointY = 1.0f;
            }
            Vec3d lllllllllllllllIIlIIlIllIIIlIlII = lllllllllllllllIIlIIlIllIIIIllII.getLook(0.0f);
            lllllllllllllllIIlIIlIllIIIlIlII = new Vec3d(lllllllllllllllIIlIIlIllIIIlIlII.xCoord, 0.0, lllllllllllllllIIlIIlIllIIIlIlII.zCoord);
            final Vec3d lllllllllllllllIIlIIlIllIIIlIIll = new Vec3d(lllllllllllllllIIlIIlIllIIIlIllI.xCoord - lllllllllllllllIIlIIlIllIIIlIlll.xCoord, 0.0, lllllllllllllllIIlIIlIllIIIlIllI.zCoord - lllllllllllllllIIlIIlIllIIIlIlll.zCoord).normalize().rotateYaw(1.5707964f);
            final double lllllllllllllllIIlIIlIllIIIlIIlI = lllllllllllllllIIlIIlIllIIIlIlII.dotProduct(lllllllllllllllIIlIIlIllIIIlIIll);
            this.guardianEye.rotationPointX = MathHelper.sqrt((float)Math.abs(lllllllllllllllIIlIIlIllIIIlIIlI)) * 2.0f * (float)Math.signum(lllllllllllllllIIlIIlIllIIIlIIlI);
        }
        this.guardianEye.showModel = true;
        final float lllllllllllllllIIlIIlIllIIIlIIIl = lllllllllllllllIIlIIlIllIIlIIIlI.getTailAnimation(lllllllllllllllIIlIIlIllIIlIIIIl);
        this.guardianTail[0].rotateAngleY = MathHelper.sin(lllllllllllllllIIlIIlIllIIIlIIIl) * 3.1415927f * 0.05f;
        this.guardianTail[1].rotateAngleY = MathHelper.sin(lllllllllllllllIIlIIlIllIIIlIIIl) * 3.1415927f * 0.1f;
        this.guardianTail[1].rotationPointX = -1.5f;
        this.guardianTail[1].rotationPointY = 0.5f;
        this.guardianTail[1].rotationPointZ = 14.0f;
        this.guardianTail[2].rotateAngleY = MathHelper.sin(lllllllllllllllIIlIIlIllIIIlIIIl) * 3.1415927f * 0.15f;
        this.guardianTail[2].rotationPointX = 0.5f;
        this.guardianTail[2].rotationPointY = 0.5f;
        this.guardianTail[2].rotationPointZ = 6.0f;
    }
    
    @Override
    public void render(final Entity lllllllllllllllIIlIIlIllIlIIlllI, final float lllllllllllllllIIlIIlIllIlIIIlIl, final float lllllllllllllllIIlIIlIllIlIIllII, final float lllllllllllllllIIlIIlIllIlIIlIll, final float lllllllllllllllIIlIIlIllIlIIIIlI, final float lllllllllllllllIIlIIlIllIlIIIIIl, final float lllllllllllllllIIlIIlIllIlIIIIII) {
        this.setRotationAngles(lllllllllllllllIIlIIlIllIlIIIlIl, lllllllllllllllIIlIIlIllIlIIllII, lllllllllllllllIIlIIlIllIlIIlIll, lllllllllllllllIIlIIlIllIlIIIIlI, lllllllllllllllIIlIIlIllIlIIIIIl, lllllllllllllllIIlIIlIllIlIIIIII, lllllllllllllllIIlIIlIllIlIIlllI);
        this.guardianBody.render(lllllllllllllllIIlIIlIllIlIIIIII);
    }
    
    public ModelGuardian() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.guardianSpines = new ModelRenderer[12];
        this.guardianBody = new ModelRenderer(this);
        this.guardianBody.setTextureOffset(0, 0).addBox(-6.0f, 10.0f, -8.0f, 12, 12, 16);
        this.guardianBody.setTextureOffset(0, 28).addBox(-8.0f, 10.0f, -6.0f, 2, 12, 12);
        this.guardianBody.setTextureOffset(0, 28).addBox(6.0f, 10.0f, -6.0f, 2, 12, 12, true);
        this.guardianBody.setTextureOffset(16, 40).addBox(-6.0f, 8.0f, -6.0f, 12, 2, 12);
        this.guardianBody.setTextureOffset(16, 40).addBox(-6.0f, 22.0f, -6.0f, 12, 2, 12);
        for (int lllllllllllllllIIlIIlIllIlIllIlI = 0; lllllllllllllllIIlIIlIllIlIllIlI < this.guardianSpines.length; ++lllllllllllllllIIlIIlIllIlIllIlI) {
            (this.guardianSpines[lllllllllllllllIIlIIlIllIlIllIlI] = new ModelRenderer(this, 0, 0)).addBox(-1.0f, -4.5f, -1.0f, 2, 9, 2);
            this.guardianBody.addChild(this.guardianSpines[lllllllllllllllIIlIIlIllIlIllIlI]);
        }
        this.guardianEye = new ModelRenderer(this, 8, 0);
        this.guardianEye.addBox(-1.0f, 15.0f, 0.0f, 2, 2, 1);
        this.guardianBody.addChild(this.guardianEye);
        this.guardianTail = new ModelRenderer[3];
        (this.guardianTail[0] = new ModelRenderer(this, 40, 0)).addBox(-2.0f, 14.0f, 7.0f, 4, 4, 8);
        (this.guardianTail[1] = new ModelRenderer(this, 0, 54)).addBox(0.0f, 14.0f, 0.0f, 3, 3, 7);
        this.guardianTail[2] = new ModelRenderer(this);
        this.guardianTail[2].setTextureOffset(41, 32).addBox(0.0f, 14.0f, 0.0f, 2, 2, 6);
        this.guardianTail[2].setTextureOffset(25, 19).addBox(1.0f, 10.5f, 3.0f, 1, 9, 9);
        this.guardianBody.addChild(this.guardianTail[0]);
        this.guardianTail[0].addChild(this.guardianTail[1]);
        this.guardianTail[1].addChild(this.guardianTail[2]);
    }
}
