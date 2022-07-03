package javax.vecmath;

import java.io.*;

public abstract class Tuple4i implements Cloneable, Serializable
{
    public /* synthetic */ int w;
    public /* synthetic */ int z;
    public /* synthetic */ int x;
    public /* synthetic */ int y;
    
    public Tuple4i(final int llllllllllllllIIllIlIllIIlIllllI, final int llllllllllllllIIllIlIllIIlIllIII, final int llllllllllllllIIllIlIllIIlIlIlll, final int llllllllllllllIIllIlIllIIlIllIll) {
        this.x = llllllllllllllIIllIlIllIIlIllllI;
        this.y = llllllllllllllIIllIlIllIIlIllIII;
        this.z = llllllllllllllIIllIlIllIIlIlIlll;
        this.w = llllllllllllllIIllIlIllIIlIllIll;
    }
    
    public final void set(final int llllllllllllllIIllIlIllIIIlllIll, final int llllllllllllllIIllIlIllIIIllllll, final int llllllllllllllIIllIlIllIIIlllIIl, final int llllllllllllllIIllIlIllIIIlllIII) {
        this.x = llllllllllllllIIllIlIllIIIlllIll;
        this.y = llllllllllllllIIllIlIllIIIllllll;
        this.z = llllllllllllllIIllIlIllIIIlllIIl;
        this.w = llllllllllllllIIllIlIllIIIlllIII;
    }
    
    public final void set(final Tuple4i llllllllllllllIIllIlIllIIIlIlllI) {
        this.x = llllllllllllllIIllIlIllIIIlIlllI.x;
        this.y = llllllllllllllIIllIlIllIIIlIlllI.y;
        this.z = llllllllllllllIIllIlIllIIIlIlllI.z;
        this.w = llllllllllllllIIllIlIllIIIlIlllI.w;
    }
    
    public final int getY() {
        return this.y;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("(").append(this.x).append(", ").append(this.y).append(", ").append(this.z).append(", ").append(this.w).append(")"));
    }
    
    public final void setZ(final int llllllllllllllIIllIlIlIlIlIIlllI) {
        this.z = llllllllllllllIIllIlIlIlIlIIlllI;
    }
    
    @Override
    public boolean equals(final Object llllllllllllllIIllIlIlIllIllIlIl) {
        try {
            final Tuple4i llllllllllllllIIllIlIlIllIllIlII = (Tuple4i)llllllllllllllIIllIlIlIllIllIlIl;
            return this.x == llllllllllllllIIllIlIlIllIllIlII.x && this.y == llllllllllllllIIllIlIlIllIllIlII.y && this.z == llllllllllllllIIllIlIlIllIllIlII.z && this.w == llllllllllllllIIllIlIlIllIllIlII.w;
        }
        catch (NullPointerException llllllllllllllIIllIlIlIllIllIIll) {
            return false;
        }
        catch (ClassCastException llllllllllllllIIllIlIlIllIllIIlI) {
            return false;
        }
    }
    
    public final int getZ() {
        return this.z;
    }
    
    public final int getW() {
        return this.w;
    }
    
    public final void clampMax(final int llllllllllllllIIllIlIlIllIIIllll, final Tuple4i llllllllllllllIIllIlIlIllIIIlIll) {
        if (llllllllllllllIIllIlIlIllIIIlIll.x > llllllllllllllIIllIlIlIllIIIllll) {
            this.x = llllllllllllllIIllIlIlIllIIIllll;
        }
        else {
            this.x = llllllllllllllIIllIlIlIllIIIlIll.x;
        }
        if (llllllllllllllIIllIlIlIllIIIlIll.y > llllllllllllllIIllIlIlIllIIIllll) {
            this.y = llllllllllllllIIllIlIlIllIIIllll;
        }
        else {
            this.y = llllllllllllllIIllIlIlIllIIIlIll.y;
        }
        if (llllllllllllllIIllIlIlIllIIIlIll.z > llllllllllllllIIllIlIlIllIIIllll) {
            this.z = llllllllllllllIIllIlIlIllIIIllll;
        }
        else {
            this.z = llllllllllllllIIllIlIlIllIIIlIll.z;
        }
        if (llllllllllllllIIllIlIlIllIIIlIll.w > llllllllllllllIIllIlIlIllIIIllll) {
            this.w = llllllllllllllIIllIlIlIllIIIllll;
        }
        else {
            this.w = llllllllllllllIIllIlIlIllIIIlIll.z;
        }
    }
    
    public final void get(final Tuple4i llllllllllllllIIllIlIllIIIIlllll) {
        llllllllllllllIIllIlIllIIIIlllll.x = this.x;
        llllllllllllllIIllIlIllIIIIlllll.y = this.y;
        llllllllllllllIIllIlIllIIIIlllll.z = this.z;
        llllllllllllllIIllIlIllIIIIlllll.w = this.w;
    }
    
    public final void clampMax(final int llllllllllllllIIllIlIlIlIlllIIII) {
        if (this.x > llllllllllllllIIllIlIlIlIlllIIII) {
            this.x = llllllllllllllIIllIlIlIlIlllIIII;
        }
        if (this.y > llllllllllllllIIllIlIlIlIlllIIII) {
            this.y = llllllllllllllIIllIlIlIlIlllIIII;
        }
        if (this.z > llllllllllllllIIllIlIlIlIlllIIII) {
            this.z = llllllllllllllIIllIlIlIlIlllIIII;
        }
        if (this.w > llllllllllllllIIllIlIlIlIlllIIII) {
            this.w = llllllllllllllIIllIlIlIlIlllIIII;
        }
    }
    
    public final void get(final int[] llllllllllllllIIllIlIllIIIlIIllI) {
        llllllllllllllIIllIlIllIIIlIIllI[0] = this.x;
        llllllllllllllIIllIlIllIIIlIIllI[1] = this.y;
        llllllllllllllIIllIlIllIIIlIIllI[2] = this.z;
        llllllllllllllIIllIlIllIIIlIIllI[3] = this.w;
    }
    
    public final void negate(final Tuple4i llllllllllllllIIllIlIlIllllIIllI) {
        this.x = -llllllllllllllIIllIlIlIllllIIllI.x;
        this.y = -llllllllllllllIIllIlIlIllllIIllI.y;
        this.z = -llllllllllllllIIllIlIlIllllIIllI.z;
        this.w = -llllllllllllllIIllIlIlIllllIIllI.w;
    }
    
    public final void negate() {
        this.x = -this.x;
        this.y = -this.y;
        this.z = -this.z;
        this.w = -this.w;
    }
    
    public final void scale(final int llllllllllllllIIllIlIlIlllIlIIlI) {
        this.x *= llllllllllllllIIllIlIlIlllIlIIlI;
        this.y *= llllllllllllllIIllIlIlIlllIlIIlI;
        this.z *= llllllllllllllIIllIlIlIlllIlIIlI;
        this.w *= llllllllllllllIIllIlIlIlllIlIIlI;
    }
    
    public final void clampMin(final int llllllllllllllIIllIlIlIllIIllIII, final Tuple4i llllllllllllllIIllIlIlIllIIlIlII) {
        if (llllllllllllllIIllIlIlIllIIlIlII.x < llllllllllllllIIllIlIlIllIIllIII) {
            this.x = llllllllllllllIIllIlIlIllIIllIII;
        }
        else {
            this.x = llllllllllllllIIllIlIlIllIIlIlII.x;
        }
        if (llllllllllllllIIllIlIlIllIIlIlII.y < llllllllllllllIIllIlIlIllIIllIII) {
            this.y = llllllllllllllIIllIlIlIllIIllIII;
        }
        else {
            this.y = llllllllllllllIIllIlIlIllIIlIlII.y;
        }
        if (llllllllllllllIIllIlIlIllIIlIlII.z < llllllllllllllIIllIlIlIllIIllIII) {
            this.z = llllllllllllllIIllIlIlIllIIllIII;
        }
        else {
            this.z = llllllllllllllIIllIlIlIllIIlIlII.z;
        }
        if (llllllllllllllIIllIlIlIllIIlIlII.w < llllllllllllllIIllIlIlIllIIllIII) {
            this.w = llllllllllllllIIllIlIlIllIIllIII;
        }
        else {
            this.w = llllllllllllllIIllIlIlIllIIlIlII.w;
        }
    }
    
    @Override
    public int hashCode() {
        long llllllllllllllIIllIlIlIllIlIlIll = 1L;
        llllllllllllllIIllIlIlIllIlIlIll = 31L * llllllllllllllIIllIlIlIllIlIlIll + this.x;
        llllllllllllllIIllIlIlIllIlIlIll = 31L * llllllllllllllIIllIlIlIllIlIlIll + this.y;
        llllllllllllllIIllIlIlIllIlIlIll = 31L * llllllllllllllIIllIlIlIllIlIlIll + this.z;
        llllllllllllllIIllIlIlIllIlIlIll = 31L * llllllllllllllIIllIlIlIllIlIlIll + this.w;
        return (int)(llllllllllllllIIllIlIlIllIlIlIll ^ llllllllllllllIIllIlIlIllIlIlIll >> 32);
    }
    
    public final void setW(final int llllllllllllllIIllIlIlIlIlIIIlIl) {
        this.w = llllllllllllllIIllIlIlIlIlIIIlIl;
    }
    
    public final void set(final int[] llllllllllllllIIllIlIllIIIllIIlI) {
        this.x = llllllllllllllIIllIlIllIIIllIIlI[0];
        this.y = llllllllllllllIIllIlIllIIIllIIlI[1];
        this.z = llllllllllllllIIllIlIllIIIllIIlI[2];
        this.w = llllllllllllllIIllIlIllIIIllIIlI[3];
    }
    
    public final void clamp(final int llllllllllllllIIllIlIlIlIlllllIl, final int llllllllllllllIIllIlIlIlIlllllII) {
        if (this.x > llllllllllllllIIllIlIlIlIlllllII) {
            this.x = llllllllllllllIIllIlIlIlIlllllII;
        }
        else if (this.x < llllllllllllllIIllIlIlIlIlllllIl) {
            this.x = llllllllllllllIIllIlIlIlIlllllIl;
        }
        if (this.y > llllllllllllllIIllIlIlIlIlllllII) {
            this.y = llllllllllllllIIllIlIlIlIlllllII;
        }
        else if (this.y < llllllllllllllIIllIlIlIlIlllllIl) {
            this.y = llllllllllllllIIllIlIlIlIlllllIl;
        }
        if (this.z > llllllllllllllIIllIlIlIlIlllllII) {
            this.z = llllllllllllllIIllIlIlIlIlllllII;
        }
        else if (this.z < llllllllllllllIIllIlIlIlIlllllIl) {
            this.z = llllllllllllllIIllIlIlIlIlllllIl;
        }
        if (this.w > llllllllllllllIIllIlIlIlIlllllII) {
            this.w = llllllllllllllIIllIlIlIlIlllllII;
        }
        else if (this.w < llllllllllllllIIllIlIlIlIlllllIl) {
            this.w = llllllllllllllIIllIlIlIlIlllllIl;
        }
    }
    
    public final void scaleAdd(final int llllllllllllllIIllIlIlIlllIIllII, final Tuple4i llllllllllllllIIllIlIlIlllIIIlll, final Tuple4i llllllllllllllIIllIlIlIlllIIIllI) {
        this.x = llllllllllllllIIllIlIlIlllIIllII * llllllllllllllIIllIlIlIlllIIIlll.x + llllllllllllllIIllIlIlIlllIIIllI.x;
        this.y = llllllllllllllIIllIlIlIlllIIllII * llllllllllllllIIllIlIlIlllIIIlll.y + llllllllllllllIIllIlIlIlllIIIllI.y;
        this.z = llllllllllllllIIllIlIlIlllIIllII * llllllllllllllIIllIlIlIlllIIIlll.z + llllllllllllllIIllIlIlIlllIIIllI.z;
        this.w = llllllllllllllIIllIlIlIlllIIllII * llllllllllllllIIllIlIlIlllIIIlll.w + llllllllllllllIIllIlIlIlllIIIllI.w;
    }
    
    public final void add(final Tuple4i llllllllllllllIIllIlIllIIIIIllIl, final Tuple4i llllllllllllllIIllIlIllIIIIIllll) {
        this.x = llllllllllllllIIllIlIllIIIIIllIl.x + llllllllllllllIIllIlIllIIIIIllll.x;
        this.y = llllllllllllllIIllIlIllIIIIIllIl.y + llllllllllllllIIllIlIllIIIIIllll.y;
        this.z = llllllllllllllIIllIlIllIIIIIllIl.z + llllllllllllllIIllIlIllIIIIIllll.z;
        this.w = llllllllllllllIIllIlIllIIIIIllIl.w + llllllllllllllIIllIlIllIIIIIllll.w;
    }
    
    public final void absolute() {
        this.x = Math.abs(this.x);
        this.y = Math.abs(this.y);
        this.z = Math.abs(this.z);
        this.w = Math.abs(this.w);
    }
    
    public final void clampMin(final int llllllllllllllIIllIlIlIlIlllIllI) {
        if (this.x < llllllllllllllIIllIlIlIlIlllIllI) {
            this.x = llllllllllllllIIllIlIlIlIlllIllI;
        }
        if (this.y < llllllllllllllIIllIlIlIlIlllIllI) {
            this.y = llllllllllllllIIllIlIlIlIlllIllI;
        }
        if (this.z < llllllllllllllIIllIlIlIlIlllIllI) {
            this.z = llllllllllllllIIllIlIlIlIlllIllI;
        }
        if (this.w < llllllllllllllIIllIlIlIlIlllIllI) {
            this.w = llllllllllllllIIllIlIlIlIlllIllI;
        }
    }
    
    public Tuple4i(final Tuple4i llllllllllllllIIllIlIllIIlIIllII) {
        this.x = llllllllllllllIIllIlIllIIlIIllII.x;
        this.y = llllllllllllllIIllIlIllIIlIIllII.y;
        this.z = llllllllllllllIIllIlIllIIlIIllII.z;
        this.w = llllllllllllllIIllIlIllIIlIIllII.w;
    }
    
    public final void scale(final int llllllllllllllIIllIlIlIlllIlllII, final Tuple4i llllllllllllllIIllIlIlIlllIllIll) {
        this.x = llllllllllllllIIllIlIlIlllIlllII * llllllllllllllIIllIlIlIlllIllIll.x;
        this.y = llllllllllllllIIllIlIlIlllIlllII * llllllllllllllIIllIlIlIlllIllIll.y;
        this.z = llllllllllllllIIllIlIlIlllIlllII * llllllllllllllIIllIlIlIlllIllIll.z;
        this.w = llllllllllllllIIllIlIlIlllIlllII * llllllllllllllIIllIlIlIlllIllIll.w;
    }
    
    public Tuple4i() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.w = 0;
    }
    
    public final void clamp(final int llllllllllllllIIllIlIlIllIIlllll, final int llllllllllllllIIllIlIlIllIlIIIlI, final Tuple4i llllllllllllllIIllIlIlIllIlIIIIl) {
        if (llllllllllllllIIllIlIlIllIlIIIIl.x > llllllllllllllIIllIlIlIllIlIIIlI) {
            this.x = llllllllllllllIIllIlIlIllIlIIIlI;
        }
        else if (llllllllllllllIIllIlIlIllIlIIIIl.x < llllllllllllllIIllIlIlIllIIlllll) {
            this.x = llllllllllllllIIllIlIlIllIIlllll;
        }
        else {
            this.x = llllllllllllllIIllIlIlIllIlIIIIl.x;
        }
        if (llllllllllllllIIllIlIlIllIlIIIIl.y > llllllllllllllIIllIlIlIllIlIIIlI) {
            this.y = llllllllllllllIIllIlIlIllIlIIIlI;
        }
        else if (llllllllllllllIIllIlIlIllIlIIIIl.y < llllllllllllllIIllIlIlIllIIlllll) {
            this.y = llllllllllllllIIllIlIlIllIIlllll;
        }
        else {
            this.y = llllllllllllllIIllIlIlIllIlIIIIl.y;
        }
        if (llllllllllllllIIllIlIlIllIlIIIIl.z > llllllllllllllIIllIlIlIllIlIIIlI) {
            this.z = llllllllllllllIIllIlIlIllIlIIIlI;
        }
        else if (llllllllllllllIIllIlIlIllIlIIIIl.z < llllllllllllllIIllIlIlIllIIlllll) {
            this.z = llllllllllllllIIllIlIlIllIIlllll;
        }
        else {
            this.z = llllllllllllllIIllIlIlIllIlIIIIl.z;
        }
        if (llllllllllllllIIllIlIlIllIlIIIIl.w > llllllllllllllIIllIlIlIllIlIIIlI) {
            this.w = llllllllllllllIIllIlIlIllIlIIIlI;
        }
        else if (llllllllllllllIIllIlIlIllIlIIIIl.w < llllllllllllllIIllIlIlIllIIlllll) {
            this.w = llllllllllllllIIllIlIlIllIIlllll;
        }
        else {
            this.w = llllllllllllllIIllIlIlIllIlIIIIl.w;
        }
    }
    
    public final void sub(final Tuple4i llllllllllllllIIllIlIlIlllllIIIl, final Tuple4i llllllllllllllIIllIlIlIlllllIIll) {
        this.x = llllllllllllllIIllIlIlIlllllIIIl.x - llllllllllllllIIllIlIlIlllllIIll.x;
        this.y = llllllllllllllIIllIlIlIlllllIIIl.y - llllllllllllllIIllIlIlIlllllIIll.y;
        this.z = llllllllllllllIIllIlIlIlllllIIIl.z - llllllllllllllIIllIlIlIlllllIIll.z;
        this.w = llllllllllllllIIllIlIlIlllllIIIl.w - llllllllllllllIIllIlIlIlllllIIll.w;
    }
    
    public final void sub(final Tuple4i llllllllllllllIIllIlIlIllllIlIlI) {
        this.x -= llllllllllllllIIllIlIlIllllIlIlI.x;
        this.y -= llllllllllllllIIllIlIlIllllIlIlI.y;
        this.z -= llllllllllllllIIllIlIlIllllIlIlI.z;
        this.w -= llllllllllllllIIllIlIlIllllIlIlI.w;
    }
    
    public final void setY(final int llllllllllllllIIllIlIlIlIlIlIlIl) {
        this.y = llllllllllllllIIllIlIlIlIlIlIlIl;
    }
    
    public Object clone() {
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException llllllllllllllIIllIlIlIlIllIlIIl) {
            throw new InternalError();
        }
    }
    
    public final void scaleAdd(final int llllllllllllllIIllIlIlIllIlllllI, final Tuple4i llllllllllllllIIllIlIlIllIllllIl) {
        this.x = llllllllllllllIIllIlIlIllIlllllI * this.x + llllllllllllllIIllIlIlIllIllllIl.x;
        this.y = llllllllllllllIIllIlIlIllIlllllI * this.y + llllllllllllllIIllIlIlIllIllllIl.y;
        this.z = llllllllllllllIIllIlIlIllIlllllI * this.z + llllllllllllllIIllIlIlIllIllllIl.z;
        this.w = llllllllllllllIIllIlIlIllIlllllI * this.w + llllllllllllllIIllIlIlIllIllllIl.w;
    }
    
    public final int getX() {
        return this.x;
    }
    
    public final void absolute(final Tuple4i llllllllllllllIIllIlIlIllIIIIlll) {
        this.x = Math.abs(llllllllllllllIIllIlIlIllIIIIlll.x);
        this.y = Math.abs(llllllllllllllIIllIlIlIllIIIIlll.y);
        this.z = Math.abs(llllllllllllllIIllIlIlIllIIIIlll.z);
        this.w = Math.abs(llllllllllllllIIllIlIlIllIIIIlll.w);
    }
    
    public Tuple4i(final int[] llllllllllllllIIllIlIllIIlIlIIII) {
        this.x = llllllllllllllIIllIlIllIIlIlIIII[0];
        this.y = llllllllllllllIIllIlIllIIlIlIIII[1];
        this.z = llllllllllllllIIllIlIllIIlIlIIII[2];
        this.w = llllllllllllllIIllIlIllIIlIlIIII[3];
    }
    
    public final void setX(final int llllllllllllllIIllIlIlIlIllIIIII) {
        this.x = llllllllllllllIIllIlIlIlIllIIIII;
    }
    
    public final void add(final Tuple4i llllllllllllllIIllIlIllIIIIIIIIl) {
        this.x += llllllllllllllIIllIlIllIIIIIIIIl.x;
        this.y += llllllllllllllIIllIlIllIIIIIIIIl.y;
        this.z += llllllllllllllIIllIlIllIIIIIIIIl.z;
        this.w += llllllllllllllIIllIlIllIIIIIIIIl.w;
    }
}
