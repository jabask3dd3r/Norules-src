package net.minecraft.client.model;

import net.minecraft.entity.*;
import net.minecraft.client.renderer.*;

public class ModelDragonHead extends ModelBase
{
    private final /* synthetic */ ModelRenderer head;
    private final /* synthetic */ ModelRenderer jaw;
    
    @Override
    public void render(final Entity lllllllllllllIlIIlllllllIllIIIlI, final float lllllllllllllIlIIlllllllIlIllIlI, final float lllllllllllllIlIIlllllllIllIIIII, final float lllllllllllllIlIIlllllllIlIlllll, final float lllllllllllllIlIIlllllllIlIllIIl, final float lllllllllllllIlIIlllllllIlIlllIl, final float lllllllllllllIlIIlllllllIlIlIlll) {
        this.jaw.rotateAngleX = (float)(Math.sin(lllllllllllllIlIIlllllllIlIllIlI * 3.1415927f * 0.2f) + 1.0) * 0.2f;
        this.head.rotateAngleY = lllllllllllllIlIIlllllllIlIllIIl * 0.017453292f;
        this.head.rotateAngleX = lllllllllllllIlIIlllllllIlIlllIl * 0.017453292f;
        GlStateManager.translate(0.0f, -0.374375f, 0.0f);
        GlStateManager.scale(0.75f, 0.75f, 0.75f);
        this.head.render(lllllllllllllIlIIlllllllIlIlIlll);
    }
    
    public ModelDragonHead(final float lllllllllllllIlIIlllllllIllIllII) {
        this.textureWidth = 256;
        this.textureHeight = 256;
        this.setTextureOffset("body.body", 0, 0);
        this.setTextureOffset("wing.skin", -56, 88);
        this.setTextureOffset("wingtip.skin", -56, 144);
        this.setTextureOffset("rearleg.main", 0, 0);
        this.setTextureOffset("rearfoot.main", 112, 0);
        this.setTextureOffset("rearlegtip.main", 196, 0);
        this.setTextureOffset("head.upperhead", 112, 30);
        this.setTextureOffset("wing.bone", 112, 88);
        this.setTextureOffset("head.upperlip", 176, 44);
        this.setTextureOffset("jaw.jaw", 176, 65);
        this.setTextureOffset("frontleg.main", 112, 104);
        this.setTextureOffset("wingtip.bone", 112, 136);
        this.setTextureOffset("frontfoot.main", 144, 104);
        this.setTextureOffset("neck.box", 192, 104);
        this.setTextureOffset("frontlegtip.main", 226, 138);
        this.setTextureOffset("body.scale", 220, 53);
        this.setTextureOffset("head.scale", 0, 0);
        this.setTextureOffset("neck.scale", 48, 0);
        this.setTextureOffset("head.nostril", 112, 0);
        final float lllllllllllllIlIIlllllllIllIlIll = -16.0f;
        this.head = new ModelRenderer(this, "head");
        this.head.addBox("upperlip", -6.0f, -1.0f, -24.0f, 12, 5, 16);
        this.head.addBox("upperhead", -8.0f, -8.0f, -10.0f, 16, 16, 16);
        this.head.mirror = true;
        this.head.addBox("scale", -5.0f, -12.0f, -4.0f, 2, 4, 6);
        this.head.addBox("nostril", -5.0f, -3.0f, -22.0f, 2, 2, 4);
        this.head.mirror = false;
        this.head.addBox("scale", 3.0f, -12.0f, -4.0f, 2, 4, 6);
        this.head.addBox("nostril", 3.0f, -3.0f, -22.0f, 2, 2, 4);
        this.jaw = new ModelRenderer(this, "jaw");
        this.jaw.setRotationPoint(0.0f, 4.0f, -8.0f);
        this.jaw.addBox("jaw", -6.0f, 0.0f, -16.0f, 12, 4, 16);
        this.head.addChild(this.jaw);
    }
}
