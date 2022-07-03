package net.minecraft.client.model;

import net.minecraft.util.math.*;

public class PositionTextureVertex
{
    public /* synthetic */ float texturePositionY;
    public /* synthetic */ Vec3d vector3D;
    public /* synthetic */ float texturePositionX;
    
    public PositionTextureVertex(final Vec3d llllllllllllllIlllIllIlIIIIlIlIl, final float llllllllllllllIlllIllIlIIIIlIlII, final float llllllllllllllIlllIllIlIIIIlIlll) {
        this.vector3D = llllllllllllllIlllIllIlIIIIlIlIl;
        this.texturePositionX = llllllllllllllIlllIllIlIIIIlIlII;
        this.texturePositionY = llllllllllllllIlllIllIlIIIIlIlll;
    }
    
    public PositionTextureVertex(final float llllllllllllllIlllIllIlIIIlllllI, final float llllllllllllllIlllIllIlIIIllllIl, final float llllllllllllllIlllIllIlIIIllIllI, final float llllllllllllllIlllIllIlIIIlllIll, final float llllllllllllllIlllIllIlIIIlllIlI) {
        this(new Vec3d(llllllllllllllIlllIllIlIIIlllllI, llllllllllllllIlllIllIlIIIllllIl, llllllllllllllIlllIllIlIIIllIllI), llllllllllllllIlllIllIlIIIlllIll, llllllllllllllIlllIllIlIIIlllIlI);
    }
    
    public PositionTextureVertex setTexturePosition(final float llllllllllllllIlllIllIlIIIlIllll, final float llllllllllllllIlllIllIlIIIlIlllI) {
        return new PositionTextureVertex(this, llllllllllllllIlllIllIlIIIlIllll, llllllllllllllIlllIllIlIIIlIlllI);
    }
    
    public PositionTextureVertex(final PositionTextureVertex llllllllllllllIlllIllIlIIIlIIIIl, final float llllllllllllllIlllIllIlIIIlIIlII, final float llllllllllllllIlllIllIlIIIlIIIll) {
        this.vector3D = llllllllllllllIlllIllIlIIIlIIIIl.vector3D;
        this.texturePositionX = llllllllllllllIlllIllIlIIIlIIlII;
        this.texturePositionY = llllllllllllllIlllIllIlIIIlIIIll;
    }
}
