package com.viaversion.viaversion.api.minecraft;

public class Vector
{
    private /* synthetic */ int blockZ;
    private /* synthetic */ int blockY;
    private /* synthetic */ int blockX;
    
    public void setBlockZ(final int lllllllllllllllIllIlIIlIlIIIIlll) {
        this.blockZ = lllllllllllllllIllIlIIlIlIIIIlll;
    }
    
    public void setBlockX(final int lllllllllllllllIllIlIIlIlIlIlIll) {
        this.blockX = lllllllllllllllIllIlIIlIlIlIlIll;
    }
    
    public int getBlockY() {
        return this.blockY;
    }
    
    public Vector(final int lllllllllllllllIllIlIIlIllIIlIIl, final int lllllllllllllllIllIlIIlIlIlllllI, final int lllllllllllllllIllIlIIlIllIIIlIl) {
        this.blockX = lllllllllllllllIllIlIIlIllIIlIIl;
        this.blockY = lllllllllllllllIllIlIIlIlIlllllI;
        this.blockZ = lllllllllllllllIllIlIIlIllIIIlIl;
    }
    
    public int getBlockZ() {
        return this.blockZ;
    }
    
    public int getBlockX() {
        return this.blockX;
    }
    
    public void setBlockY(final int lllllllllllllllIllIlIIlIlIIlIlII) {
        this.blockY = lllllllllllllllIllIlIIlIlIIlIlII;
    }
}
