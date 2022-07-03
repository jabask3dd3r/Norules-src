package javax.vecmath;

import java.io.*;

public abstract class Tuple3i implements Serializable, Cloneable
{
    public /* synthetic */ int y;
    public /* synthetic */ int z;
    public /* synthetic */ int x;
    
    public final void get(final Tuple3i lllllllllllllIllIlIIllllllIIIlIl) {
        lllllllllllllIllIlIIllllllIIIlIl.x = this.x;
        lllllllllllllIllIlIIllllllIIIlIl.y = this.y;
        lllllllllllllIllIlIIllllllIIIlIl.z = this.z;
    }
    
    public final void scaleAdd(final int lllllllllllllIllIlIIlllllIIIIIll, final Tuple3i lllllllllllllIllIlIIlllllIIIIIlI, final Tuple3i lllllllllllllIllIlIIlllllIIIIIIl) {
        this.x = lllllllllllllIllIlIIlllllIIIIIll * lllllllllllllIllIlIIlllllIIIIIlI.x + lllllllllllllIllIlIIlllllIIIIIIl.x;
        this.y = lllllllllllllIllIlIIlllllIIIIIll * lllllllllllllIllIlIIlllllIIIIIlI.y + lllllllllllllIllIlIIlllllIIIIIIl.y;
        this.z = lllllllllllllIllIlIIlllllIIIIIll * lllllllllllllIllIlIIlllllIIIIIlI.z + lllllllllllllIllIlIIlllllIIIIIIl.z;
    }
    
    public Object clone() {
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException lllllllllllllIllIlIIllllIIlIIlII) {
            throw new InternalError();
        }
    }
    
    public final void get(final int[] lllllllllllllIllIlIIllllllIIlIIl) {
        lllllllllllllIllIlIIllllllIIlIIl[0] = this.x;
        lllllllllllllIllIlIIllllllIIlIIl[1] = this.y;
        lllllllllllllIllIlIIllllllIIlIIl[2] = this.z;
    }
    
    public final void set(final int[] lllllllllllllIllIlIIllllllIlIlll) {
        this.x = lllllllllllllIllIlIIllllllIlIlll[0];
        this.y = lllllllllllllIllIlIIllllllIlIlll[1];
        this.z = lllllllllllllIllIlIIllllllIlIlll[2];
    }
    
    public final void clamp(final int lllllllllllllIllIlIIllllIlIllIlI, final int lllllllllllllIllIlIIllllIlIllIIl, final Tuple3i lllllllllllllIllIlIIllllIlIllIII) {
        if (lllllllllllllIllIlIIllllIlIllIII.x > lllllllllllllIllIlIIllllIlIllIIl) {
            this.x = lllllllllllllIllIlIIllllIlIllIIl;
        }
        else if (lllllllllllllIllIlIIllllIlIllIII.x < lllllllllllllIllIlIIllllIlIllIlI) {
            this.x = lllllllllllllIllIlIIllllIlIllIlI;
        }
        else {
            this.x = lllllllllllllIllIlIIllllIlIllIII.x;
        }
        if (lllllllllllllIllIlIIllllIlIllIII.y > lllllllllllllIllIlIIllllIlIllIIl) {
            this.y = lllllllllllllIllIlIIllllIlIllIIl;
        }
        else if (lllllllllllllIllIlIIllllIlIllIII.y < lllllllllllllIllIlIIllllIlIllIlI) {
            this.y = lllllllllllllIllIlIIllllIlIllIlI;
        }
        else {
            this.y = lllllllllllllIllIlIIllllIlIllIII.y;
        }
        if (lllllllllllllIllIlIIllllIlIllIII.z > lllllllllllllIllIlIIllllIlIllIIl) {
            this.z = lllllllllllllIllIlIIllllIlIllIIl;
        }
        else if (lllllllllllllIllIlIIllllIlIllIII.z < lllllllllllllIllIlIIllllIlIllIlI) {
            this.z = lllllllllllllIllIlIIllllIlIllIlI;
        }
        else {
            this.z = lllllllllllllIllIlIIllllIlIllIII.z;
        }
    }
    
    public final void scaleAdd(final int lllllllllllllIllIlIIllllIlllllII, final Tuple3i lllllllllllllIllIlIIllllIllllIII) {
        this.x = lllllllllllllIllIlIIllllIlllllII * this.x + lllllllllllllIllIlIIllllIllllIII.x;
        this.y = lllllllllllllIllIlIIllllIlllllII * this.y + lllllllllllllIllIlIIllllIllllIII.y;
        this.z = lllllllllllllIllIlIIllllIlllllII * this.z + lllllllllllllIllIlIIllllIllllIII.z;
    }
    
    public final int getY() {
        return this.y;
    }
    
    public final void negate(final Tuple3i lllllllllllllIllIlIIlllllIIlllll) {
        this.x = -lllllllllllllIllIlIIlllllIIlllll.x;
        this.y = -lllllllllllllIllIlIIlllllIIlllll.y;
        this.z = -lllllllllllllIllIlIIlllllIIlllll.z;
    }
    
    public final void sub(final Tuple3i lllllllllllllIllIlIIlllllIlIIlIl) {
        this.x -= lllllllllllllIllIlIIlllllIlIIlIl.x;
        this.y -= lllllllllllllIllIlIIlllllIlIIlIl.y;
        this.z -= lllllllllllllIllIlIIlllllIlIIlIl.z;
    }
    
    public final void clampMax(final int lllllllllllllIllIlIIllllIlIIIlll, final Tuple3i lllllllllllllIllIlIIllllIlIIIllI) {
        if (lllllllllllllIllIlIIllllIlIIIllI.x > lllllllllllllIllIlIIllllIlIIIlll) {
            this.x = lllllllllllllIllIlIIllllIlIIIlll;
        }
        else {
            this.x = lllllllllllllIllIlIIllllIlIIIllI.x;
        }
        if (lllllllllllllIllIlIIllllIlIIIllI.y > lllllllllllllIllIlIIllllIlIIIlll) {
            this.y = lllllllllllllIllIlIIllllIlIIIlll;
        }
        else {
            this.y = lllllllllllllIllIlIIllllIlIIIllI.y;
        }
        if (lllllllllllllIllIlIIllllIlIIIllI.z > lllllllllllllIllIlIIllllIlIIIlll) {
            this.z = lllllllllllllIllIlIIllllIlIIIlll;
        }
        else {
            this.z = lllllllllllllIllIlIIllllIlIIIllI.z;
        }
    }
    
    public final void scale(final int lllllllllllllIllIlIIlllllIIlIlII, final Tuple3i lllllllllllllIllIlIIlllllIIlIllI) {
        this.x = lllllllllllllIllIlIIlllllIIlIlII * lllllllllllllIllIlIIlllllIIlIllI.x;
        this.y = lllllllllllllIllIlIIlllllIIlIlII * lllllllllllllIllIlIIlllllIIlIllI.y;
        this.z = lllllllllllllIllIlIIlllllIIlIlII * lllllllllllllIllIlIIlllllIIlIllI.z;
    }
    
    public final int getZ() {
        return this.z;
    }
    
    @Override
    public int hashCode() {
        long lllllllllllllIllIlIIllllIllIIllI = 1L;
        lllllllllllllIllIlIIllllIllIIllI = 31L * lllllllllllllIllIlIIllllIllIIllI + this.x;
        lllllllllllllIllIlIIllllIllIIllI = 31L * lllllllllllllIllIlIIllllIllIIllI + this.y;
        lllllllllllllIllIlIIllllIllIIllI = 31L * lllllllllllllIllIlIIllllIllIIllI + this.z;
        return (int)(lllllllllllllIllIlIIllllIllIIllI ^ lllllllllllllIllIlIIllllIllIIllI >> 32);
    }
    
    public final void negate() {
        this.x = -this.x;
        this.y = -this.y;
        this.z = -this.z;
    }
    
    public final int getX() {
        return this.x;
    }
    
    public final void setX(final int lllllllllllllIllIlIIllllIIIllIll) {
        this.x = lllllllllllllIllIlIIllllIIIllIll;
    }
    
    public final void add(final Tuple3i lllllllllllllIllIlIIlllllIlllIll, final Tuple3i lllllllllllllIllIlIIlllllIllllIl) {
        this.x = lllllllllllllIllIlIIlllllIlllIll.x + lllllllllllllIllIlIIlllllIllllIl.x;
        this.y = lllllllllllllIllIlIIlllllIlllIll.y + lllllllllllllIllIlIIlllllIllllIl.y;
        this.z = lllllllllllllIllIlIIlllllIlllIll.z + lllllllllllllIllIlIIlllllIllllIl.z;
    }
    
    public final void clampMin(final int lllllllllllllIllIlIIllllIlIlIIII, final Tuple3i lllllllllllllIllIlIIllllIlIIllll) {
        if (lllllllllllllIllIlIIllllIlIIllll.x < lllllllllllllIllIlIIllllIlIlIIII) {
            this.x = lllllllllllllIllIlIIllllIlIlIIII;
        }
        else {
            this.x = lllllllllllllIllIlIIllllIlIIllll.x;
        }
        if (lllllllllllllIllIlIIllllIlIIllll.y < lllllllllllllIllIlIIllllIlIlIIII) {
            this.y = lllllllllllllIllIlIIllllIlIlIIII;
        }
        else {
            this.y = lllllllllllllIllIlIIllllIlIIllll.y;
        }
        if (lllllllllllllIllIlIIllllIlIIllll.z < lllllllllllllIllIlIIllllIlIlIIII) {
            this.z = lllllllllllllIllIlIIllllIlIlIIII;
        }
        else {
            this.z = lllllllllllllIllIlIIllllIlIIllll.z;
        }
    }
    
    public final void scale(final int lllllllllllllIllIlIIlllllIIIllll) {
        this.x *= lllllllllllllIllIlIIlllllIIIllll;
        this.y *= lllllllllllllIllIlIIlllllIIIllll;
        this.z *= lllllllllllllIllIlIIlllllIIIllll;
    }
    
    public final void sub(final Tuple3i lllllllllllllIllIlIIlllllIlIllll, final Tuple3i lllllllllllllIllIlIIlllllIlIlIll) {
        this.x = lllllllllllllIllIlIIlllllIlIllll.x - lllllllllllllIllIlIIlllllIlIlIll.x;
        this.y = lllllllllllllIllIlIIlllllIlIllll.y - lllllllllllllIllIlIIlllllIlIlIll.y;
        this.z = lllllllllllllIllIlIIlllllIlIllll.z - lllllllllllllIllIlIIlllllIlIlIll.z;
    }
    
    public final void add(final Tuple3i lllllllllllllIllIlIIlllllIllIllI) {
        this.x += lllllllllllllIllIlIIlllllIllIllI.x;
        this.y += lllllllllllllIllIlIIlllllIllIllI.y;
        this.z += lllllllllllllIllIlIIlllllIllIllI.z;
    }
    
    public Tuple3i(final int[] lllllllllllllIllIlIIllllllllIIII) {
        this.x = lllllllllllllIllIlIIllllllllIIII[0];
        this.y = lllllllllllllIllIlIIllllllllIIII[1];
        this.z = lllllllllllllIllIlIIllllllllIIII[2];
    }
    
    public final void clampMax(final int lllllllllllllIllIlIIllllIIlIlIll) {
        if (this.x > lllllllllllllIllIlIIllllIIlIlIll) {
            this.x = lllllllllllllIllIlIIllllIIlIlIll;
        }
        if (this.y > lllllllllllllIllIlIIllllIIlIlIll) {
            this.y = lllllllllllllIllIlIIllllIIlIlIll;
        }
        if (this.z > lllllllllllllIllIlIIllllIIlIlIll) {
            this.z = lllllllllllllIllIlIIllllIIlIlIll;
        }
    }
    
    public Tuple3i() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }
    
    public final void setZ(final int lllllllllllllIllIlIIllllIIIIlIIl) {
        this.z = lllllllllllllIllIlIIllllIIIIlIIl;
    }
    
    public final void clamp(final int lllllllllllllIllIlIIllllIIlllIII, final int lllllllllllllIllIlIIllllIIlllIlI) {
        if (this.x > lllllllllllllIllIlIIllllIIlllIlI) {
            this.x = lllllllllllllIllIlIIllllIIlllIlI;
        }
        else if (this.x < lllllllllllllIllIlIIllllIIlllIII) {
            this.x = lllllllllllllIllIlIIllllIIlllIII;
        }
        if (this.y > lllllllllllllIllIlIIllllIIlllIlI) {
            this.y = lllllllllllllIllIlIIllllIIlllIlI;
        }
        else if (this.y < lllllllllllllIllIlIIllllIIlllIII) {
            this.y = lllllllllllllIllIlIIllllIIlllIII;
        }
        if (this.z > lllllllllllllIllIlIIllllIIlllIlI) {
            this.z = lllllllllllllIllIlIIllllIIlllIlI;
        }
        else if (this.z < lllllllllllllIllIlIIllllIIlllIII) {
            this.z = lllllllllllllIllIlIIllllIIlllIII;
        }
    }
    
    public final void absolute(final Tuple3i lllllllllllllIllIlIIllllIlIIIIII) {
        this.x = Math.abs(lllllllllllllIllIlIIllllIlIIIIII.x);
        this.y = Math.abs(lllllllllllllIllIlIIllllIlIIIIII.y);
        this.z = Math.abs(lllllllllllllIllIlIIllllIlIIIIII.z);
    }
    
    public final void setY(final int lllllllllllllIllIlIIllllIIIlIIII) {
        this.y = lllllllllllllIllIlIIllllIIIlIIII;
    }
    
    public final void set(final Tuple3i lllllllllllllIllIlIIllllllIlIIIl) {
        this.x = lllllllllllllIllIlIIllllllIlIIIl.x;
        this.y = lllllllllllllIllIlIIllllllIlIIIl.y;
        this.z = lllllllllllllIllIlIIllllllIlIIIl.z;
    }
    
    public final void set(final int lllllllllllllIllIlIIllllllIlllIl, final int lllllllllllllIllIlIIllllllIlllII, final int lllllllllllllIllIlIIllllllIllIll) {
        this.x = lllllllllllllIllIlIIllllllIlllIl;
        this.y = lllllllllllllIllIlIIllllllIlllII;
        this.z = lllllllllllllIllIlIIllllllIllIll;
    }
    
    public Tuple3i(final Tuple3i lllllllllllllIllIlIIlllllllIlIlI) {
        this.x = lllllllllllllIllIlIIlllllllIlIlI.x;
        this.y = lllllllllllllIllIlIIlllllllIlIlI.y;
        this.z = lllllllllllllIllIlIIlllllllIlIlI.z;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("(").append(this.x).append(", ").append(this.y).append(", ").append(this.z).append(")"));
    }
    
    public final void clampMin(final int lllllllllllllIllIlIIllllIIllIIIl) {
        if (this.x < lllllllllllllIllIlIIllllIIllIIIl) {
            this.x = lllllllllllllIllIlIIllllIIllIIIl;
        }
        if (this.y < lllllllllllllIllIlIIllllIIllIIIl) {
            this.y = lllllllllllllIllIlIIllllIIllIIIl;
        }
        if (this.z < lllllllllllllIllIlIIllllIIllIIIl) {
            this.z = lllllllllllllIllIlIIllllIIllIIIl;
        }
    }
    
    public final void absolute() {
        this.x = Math.abs(this.x);
        this.y = Math.abs(this.y);
        this.z = Math.abs(this.z);
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIllIlIIllllIllIlIll) {
        try {
            final Tuple3i lllllllllllllIllIlIIllllIllIllll = (Tuple3i)lllllllllllllIllIlIIllllIllIlIll;
            return this.x == lllllllllllllIllIlIIllllIllIllll.x && this.y == lllllllllllllIllIlIIllllIllIllll.y && this.z == lllllllllllllIllIlIIllllIllIllll.z;
        }
        catch (NullPointerException lllllllllllllIllIlIIllllIllIlllI) {
            return false;
        }
        catch (ClassCastException lllllllllllllIllIlIIllllIllIllIl) {
            return false;
        }
    }
    
    public Tuple3i(final int lllllllllllllIllIlIIllllllllllII, final int lllllllllllllIllIlIIllllllllIlll, final int lllllllllllllIllIlIIllllllllIllI) {
        this.x = lllllllllllllIllIlIIllllllllllII;
        this.y = lllllllllllllIllIlIIllllllllIlll;
        this.z = lllllllllllllIllIlIIllllllllIllI;
    }
}
