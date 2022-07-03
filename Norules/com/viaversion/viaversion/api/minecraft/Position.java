package com.viaversion.viaversion.api.minecraft;

public class Position
{
    private final /* synthetic */ int x;
    private final /* synthetic */ int z;
    private final /* synthetic */ int y;
    
    public Position(final Position lllllllllllllllIlllIlIIIIlIIIlll) {
        this(lllllllllllllllIlllIlIIIIlIIIlll.getX(), lllllllllllllllIlllIlIIIIlIIIlll.getY(), lllllllllllllllIlllIlIIIIlIIIlll.getZ());
    }
    
    @Override
    public int hashCode() {
        int lllllllllllllllIlllIlIIIIIlIIIlI = this.x;
        lllllllllllllllIlllIlIIIIIlIIIlI = 31 * lllllllllllllllIlllIlIIIIIlIIIlI + this.y;
        lllllllllllllllIlllIlIIIIIlIIIlI = 31 * lllllllllllllllIlllIlIIIIIlIIIlI + this.z;
        return lllllllllllllllIlllIlIIIIIlIIIlI;
    }
    
    public Position(final int lllllllllllllllIlllIlIIIIlIlllIl, final int lllllllllllllllIlllIlIIIIlIllIII, final int lllllllllllllllIlllIlIIIIlIllIll) {
        this.x = lllllllllllllllIlllIlIIIIlIlllIl;
        this.y = lllllllllllllllIlllIlIIIIlIllIII;
        this.z = lllllllllllllllIlllIlIIIIlIllIll;
    }
    
    public int getZ() {
        return this.z;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append("Position{x=").append(this.x).append(", y=").append(this.y).append(", z=").append(this.z).append('}'));
    }
    
    public Position(final int lllllllllllllllIlllIlIIIIlIIllIl, final short lllllllllllllllIlllIlIIIIlIIllII, final int lllllllllllllllIlllIlIIIIlIIllll) {
        this.x = lllllllllllllllIlllIlIIIIlIIllIl;
        this.y = lllllllllllllllIlllIlIIIIlIIllII;
        this.z = lllllllllllllllIlllIlIIIIlIIllll;
    }
    
    public Position getRelative(final BlockFace lllllllllllllllIlllIlIIIIIllllll) {
        return new Position(this.x + lllllllllllllllIlllIlIIIIIllllll.getModX(), (short)(this.y + lllllllllllllllIlllIlIIIIIllllll.getModY()), this.z + lllllllllllllllIlllIlIIIIIllllll.getModZ());
    }
    
    public int getY() {
        return this.y;
    }
    
    public int getX() {
        return this.x;
    }
    
    @Override
    public boolean equals(final Object lllllllllllllllIlllIlIIIIIllIIIl) {
        if (this == lllllllllllllllIlllIlIIIIIllIIIl) {
            return true;
        }
        if (lllllllllllllllIlllIlIIIIIllIIIl == null || this.getClass() != lllllllllllllllIlllIlIIIIIllIIIl.getClass()) {
            return false;
        }
        final Position lllllllllllllllIlllIlIIIIIllIIII = (Position)lllllllllllllllIlllIlIIIIIllIIIl;
        return this.x == lllllllllllllllIlllIlIIIIIllIIII.x && this.y == lllllllllllllllIlllIlIIIIIllIIII.y && this.z == lllllllllllllllIlllIlIIIIIllIIII.z;
    }
}
