package javax.vecmath;

import java.io.*;

public abstract class Tuple3b implements Cloneable, Serializable
{
    public /* synthetic */ byte y;
    public /* synthetic */ byte z;
    public /* synthetic */ byte x;
    
    public final void set(final Tuple3b llllllllllllllllIIllIIlIIlIIIIIl) {
        this.x = llllllllllllllllIIllIIlIIlIIIIIl.x;
        this.y = llllllllllllllllIIllIIlIIlIIIIIl.y;
        this.z = llllllllllllllllIIllIIlIIlIIIIIl.z;
    }
    
    public final void set(final byte[] llllllllllllllllIIllIIlIIIllllIl) {
        this.x = llllllllllllllllIIllIIlIIIllllIl[0];
        this.y = llllllllllllllllIIllIIlIIIllllIl[1];
        this.z = llllllllllllllllIIllIIlIIIllllIl[2];
    }
    
    public final byte getX() {
        return this.x;
    }
    
    public final void setZ(final byte llllllllllllllllIIllIIlIIIIIIIll) {
        this.z = llllllllllllllllIIllIIlIIIIIIIll;
    }
    
    public final void setY(final byte llllllllllllllllIIllIIlIIIIIllII) {
        this.y = llllllllllllllllIIllIIlIIIIIllII;
    }
    
    public final byte getY() {
        return this.y;
    }
    
    public boolean equals(final Tuple3b llllllllllllllllIIllIIlIIIllIllI) {
        try {
            return this.x == llllllllllllllllIIllIIlIIIllIllI.x && this.y == llllllllllllllllIIllIIlIIIllIllI.y && this.z == llllllllllllllllIIllIIlIIIllIllI.z;
        }
        catch (NullPointerException llllllllllllllllIIllIIlIIIllIlIl) {
            return false;
        }
    }
    
    @Override
    public boolean equals(final Object llllllllllllllllIIllIIlIIIlIllIl) {
        try {
            final Tuple3b llllllllllllllllIIllIIlIIIlIllII = (Tuple3b)llllllllllllllllIIllIIlIIIlIllIl;
            return this.x == llllllllllllllllIIllIIlIIIlIllII.x && this.y == llllllllllllllllIIllIIlIIIlIllII.y && this.z == llllllllllllllllIIllIIlIIIlIllII.z;
        }
        catch (NullPointerException llllllllllllllllIIllIIlIIIlIlIll) {
            return false;
        }
        catch (ClassCastException llllllllllllllllIIllIIlIIIlIlIlI) {
            return false;
        }
    }
    
    public Object clone() {
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException llllllllllllllllIIllIIlIIIlIIIII) {
            throw new InternalError();
        }
    }
    
    public Tuple3b(final Tuple3b llllllllllllllllIIllIIlIIlIllIll) {
        this.x = llllllllllllllllIIllIIlIIlIllIll.x;
        this.y = llllllllllllllllIIllIIlIIlIllIll.y;
        this.z = llllllllllllllllIIllIIlIIlIllIll.z;
    }
    
    public Tuple3b(final byte llllllllllllllllIIllIIlIIllIlIll, final byte llllllllllllllllIIllIIlIIllIIllI, final byte llllllllllllllllIIllIIlIIllIIlIl) {
        this.x = llllllllllllllllIIllIIlIIllIlIll;
        this.y = llllllllllllllllIIllIIlIIllIIllI;
        this.z = llllllllllllllllIIllIIlIIllIIlIl;
    }
    
    public final byte getZ() {
        return this.z;
    }
    
    public final void get(final byte[] llllllllllllllllIIllIIlIIlIIllIl) {
        llllllllllllllllIIllIIlIIlIIllIl[0] = this.x;
        llllllllllllllllIIllIIlIIlIIllIl[1] = this.y;
        llllllllllllllllIIllIIlIIlIIllIl[2] = this.z;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("(").append(this.x & 0xFF).append(", ").append(this.y & 0xFF).append(", ").append(this.z & 0xFF).append(")"));
    }
    
    public Tuple3b(final byte[] llllllllllllllllIIllIIlIIlIlllll) {
        this.x = llllllllllllllllIIllIIlIIlIlllll[0];
        this.y = llllllllllllllllIIllIIlIIlIlllll[1];
        this.z = llllllllllllllllIIllIIlIIlIlllll[2];
    }
    
    public final void setX(final byte llllllllllllllllIIllIIlIIIIlIlIl) {
        this.x = llllllllllllllllIIllIIlIIIIlIlIl;
    }
    
    @Override
    public int hashCode() {
        return (this.x & 0xFF) << 0 | (this.y & 0xFF) << 8 | (this.z & 0xFF) << 16;
    }
    
    public final void get(final Tuple3b llllllllllllllllIIllIIlIIlIIlIIl) {
        llllllllllllllllIIllIIlIIlIIlIIl.x = this.x;
        llllllllllllllllIIllIIlIIlIIlIIl.y = this.y;
        llllllllllllllllIIllIIlIIlIIlIIl.z = this.z;
    }
    
    public Tuple3b() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }
}
