package javax.vecmath;

import java.io.*;

public abstract class Tuple4b implements Serializable, Cloneable
{
    public /* synthetic */ byte z;
    public /* synthetic */ byte y;
    public /* synthetic */ byte w;
    public /* synthetic */ byte x;
    
    public final void setY(final byte llllllllllllllllllIllIIIllIllIll) {
        this.y = llllllllllllllllllIllIIIllIllIll;
    }
    
    public final byte getY() {
        return this.y;
    }
    
    public final void set(final byte[] llllllllllllllllllIllIIlIIIIlIlI) {
        this.x = llllllllllllllllllIllIIlIIIIlIlI[0];
        this.y = llllllllllllllllllIllIIlIIIIlIlI[1];
        this.z = llllllllllllllllllIllIIlIIIIlIlI[2];
        this.w = llllllllllllllllllIllIIlIIIIlIlI[3];
    }
    
    public Tuple4b(final byte llllllllllllllllllIllIIlIIllllII, final byte llllllllllllllllllIllIIlIIllIllI, final byte llllllllllllllllllIllIIlIIllIlIl, final byte llllllllllllllllllIllIIlIIllIlII) {
        this.x = llllllllllllllllllIllIIlIIllllII;
        this.y = llllllllllllllllllIllIIlIIllIllI;
        this.z = llllllllllllllllllIllIIlIIllIlIl;
        this.w = llllllllllllllllllIllIIlIIllIlII;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("(").append(this.x & 0xFF).append(", ").append(this.y & 0xFF).append(", ").append(this.z & 0xFF).append(", ").append(this.w & 0xFF).append(")"));
    }
    
    public final void setX(final byte llllllllllllllllllIllIIIlllIIllI) {
        this.x = llllllllllllllllllIllIIIlllIIllI;
    }
    
    public Tuple4b(final byte[] llllllllllllllllllIllIIlIIlIlllI) {
        this.x = llllllllllllllllllIllIIlIIlIlllI[0];
        this.y = llllllllllllllllllIllIIlIIlIlllI[1];
        this.z = llllllllllllllllllIllIIlIIlIlllI[2];
        this.w = llllllllllllllllllIllIIlIIlIlllI[3];
    }
    
    public final void set(final Tuple4b llllllllllllllllllIllIIlIIIlIIlI) {
        this.x = llllllllllllllllllIllIIlIIIlIIlI.x;
        this.y = llllllllllllllllllIllIIlIIIlIIlI.y;
        this.z = llllllllllllllllllIllIIlIIIlIIlI.z;
        this.w = llllllllllllllllllIllIIlIIIlIIlI.w;
    }
    
    public final void setW(final byte llllllllllllllllllIllIIIllIIlIll) {
        this.w = llllllllllllllllllIllIIIllIIlIll;
    }
    
    public final void setZ(final byte llllllllllllllllllIllIIIllIlIIlI) {
        this.z = llllllllllllllllllIllIIIllIlIIlI;
    }
    
    public final byte getW() {
        return this.w;
    }
    
    public final byte getZ() {
        return this.z;
    }
    
    public final void get(final Tuple4b llllllllllllllllllIllIIlIIIllIII) {
        llllllllllllllllllIllIIlIIIllIII.x = this.x;
        llllllllllllllllllIllIIlIIIllIII.y = this.y;
        llllllllllllllllllIllIIlIIIllIII.z = this.z;
        llllllllllllllllllIllIIlIIIllIII.w = this.w;
    }
    
    public final byte getX() {
        return this.x;
    }
    
    @Override
    public boolean equals(final Object llllllllllllllllllIllIIIllllllII) {
        try {
            final Tuple4b llllllllllllllllllIllIIIlllllIll = (Tuple4b)llllllllllllllllllIllIIIllllllII;
            return this.x == llllllllllllllllllIllIIIlllllIll.x && this.y == llllllllllllllllllIllIIIlllllIll.y && this.z == llllllllllllllllllIllIIIlllllIll.z && this.w == llllllllllllllllllIllIIIlllllIll.w;
        }
        catch (NullPointerException llllllllllllllllllIllIIIlllllIlI) {
            return false;
        }
        catch (ClassCastException llllllllllllllllllIllIIIlllllIIl) {
            return false;
        }
    }
    
    @Override
    public int hashCode() {
        return (this.x & 0xFF) << 0 | (this.y & 0xFF) << 8 | (this.z & 0xFF) << 16 | (this.w & 0xFF) << 24;
    }
    
    public final void get(final byte[] llllllllllllllllllIllIIlIIIllllI) {
        llllllllllllllllllIllIIlIIIllllI[0] = this.x;
        llllllllllllllllllIllIIlIIIllllI[1] = this.y;
        llllllllllllllllllIllIIlIIIllllI[2] = this.z;
        llllllllllllllllllIllIIlIIIllllI[3] = this.w;
    }
    
    public Object clone() {
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException llllllllllllllllllIllIIIlllIllll) {
            throw new InternalError();
        }
    }
    
    public Tuple4b() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.w = 0;
    }
    
    public boolean equals(final Tuple4b llllllllllllllllllIllIIlIIIIIlIl) {
        try {
            return this.x == llllllllllllllllllIllIIlIIIIIlIl.x && this.y == llllllllllllllllllIllIIlIIIIIlIl.y && this.z == llllllllllllllllllIllIIlIIIIIlIl.z && this.w == llllllllllllllllllIllIIlIIIIIlIl.w;
        }
        catch (NullPointerException llllllllllllllllllIllIIlIIIIIlII) {
            return false;
        }
    }
    
    public Tuple4b(final Tuple4b llllllllllllllllllIllIIlIIlIlIlI) {
        this.x = llllllllllllllllllIllIIlIIlIlIlI.x;
        this.y = llllllllllllllllllIllIIlIIlIlIlI.y;
        this.z = llllllllllllllllllIllIIlIIlIlIlI.z;
        this.w = llllllllllllllllllIllIIlIIlIlIlI.w;
    }
}
