package net.minecraft.client.model;

public class ModelPig extends ModelQuadruped
{
    public ModelPig() {
        this(0.0f);
    }
    
    public ModelPig(final float lllllllllllllllllIIIlllIlIIllIII) {
        super(6, lllllllllllllllllIIIlllIlIIllIII);
        this.head.setTextureOffset(16, 16).addBox(-2.0f, 0.0f, -9.0f, 4, 3, 1, lllllllllllllllllIIIlllIlIIllIII);
        this.childYOffset = 4.0f;
    }
}
