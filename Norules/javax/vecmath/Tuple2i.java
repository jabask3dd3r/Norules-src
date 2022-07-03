package javax.vecmath;

import java.io.*;

public abstract class Tuple2i implements Cloneable, Serializable
{
    public /* synthetic */ int y;
    public /* synthetic */ int x;
    
    public final void get(final Tuple2i lllllllllllllIIlllllIlIlIIIIIIIl) {
        lllllllllllllIIlllllIlIlIIIIIIIl.x = this.x;
        lllllllllllllIIlllllIlIlIIIIIIIl.y = this.y;
    }
    
    public final void set(final int[] lllllllllllllIIlllllIlIlIIIlIIll) {
        this.x = lllllllllllllIIlllllIlIlIIIlIIll[0];
        this.y = lllllllllllllIIlllllIlIlIIIlIIll[1];
    }
    
    public Tuple2i(final int[] lllllllllllllIIlllllIlIlIIlIlIIl) {
        this.x = lllllllllllllIIlllllIlIlIIlIlIIl[0];
        this.y = lllllllllllllIIlllllIlIlIIlIlIIl[1];
    }
    
    public final void clampMax(final int lllllllllllllIIlllllIlIIlIIIIIll, final Tuple2i lllllllllllllIIlllllIlIIlIIIIIlI) {
        if (lllllllllllllIIlllllIlIIlIIIIIlI.x > lllllllllllllIIlllllIlIIlIIIIIll) {
            this.x = lllllllllllllIIlllllIlIIlIIIIIll;
        }
        else {
            this.x = lllllllllllllIIlllllIlIIlIIIIIlI.x;
        }
        if (lllllllllllllIIlllllIlIIlIIIIIlI.y > lllllllllllllIIlllllIlIIlIIIIIll) {
            this.y = lllllllllllllIIlllllIlIIlIIIIIll;
        }
        else {
            this.y = lllllllllllllIIlllllIlIIlIIIIIlI.y;
        }
    }
    
    public final int getX() {
        return this.x;
    }
    
    public final void set(final int lllllllllllllIIlllllIlIlIIIllIll, final int lllllllllllllIIlllllIlIlIIIlIlll) {
        this.x = lllllllllllllIIlllllIlIlIIIllIll;
        this.y = lllllllllllllIIlllllIlIlIIIlIlll;
    }
    
    public final void clamp(final int lllllllllllllIIlllllIlIIIlllIlll, final int lllllllllllllIIlllllIlIIIlllIllI) {
        if (this.x > lllllllllllllIIlllllIlIIIlllIllI) {
            this.x = lllllllllllllIIlllllIlIIIlllIllI;
        }
        else if (this.x < lllllllllllllIIlllllIlIIIlllIlll) {
            this.x = lllllllllllllIIlllllIlIIIlllIlll;
        }
        if (this.y > lllllllllllllIIlllllIlIIIlllIllI) {
            this.y = lllllllllllllIIlllllIlIIIlllIllI;
        }
        else if (this.y < lllllllllllllIIlllllIlIIIlllIlll) {
            this.y = lllllllllllllIIlllllIlIIIlllIlll;
        }
    }
    
    public final void add(final Tuple2i lllllllllllllIIlllllIlIIllllIIlI) {
        this.x += lllllllllllllIIlllllIlIIllllIIlI.x;
        this.y += lllllllllllllIIlllllIlIIllllIIlI.y;
    }
    
    public final void scaleAdd(final int lllllllllllllIIlllllIlIIlIllIlIl, final Tuple2i lllllllllllllIIlllllIlIIlIllIlII) {
        this.x = lllllllllllllIIlllllIlIIlIllIlIl * this.x + lllllllllllllIIlllllIlIIlIllIlII.x;
        this.y = lllllllllllllIIlllllIlIIlIllIlIl * this.y + lllllllllllllIIlllllIlIIlIllIlII.y;
    }
    
    public final void get(final int[] lllllllllllllIIlllllIlIlIIIIIlIl) {
        lllllllllllllIIlllllIlIlIIIIIlIl[0] = this.x;
        lllllllllllllIIlllllIlIlIIIIIlIl[1] = this.y;
    }
    
    public final void sub(final Tuple2i lllllllllllllIIlllllIlIIlllIlIII, final Tuple2i lllllllllllllIIlllllIlIIlllIlIlI) {
        this.x = lllllllllllllIIlllllIlIIlllIlIII.x - lllllllllllllIIlllllIlIIlllIlIlI.x;
        this.y = lllllllllllllIIlllllIlIIlllIlIII.y - lllllllllllllIIlllllIlIIlllIlIlI.y;
    }
    
    public final void absolute() {
        this.x = Math.abs(this.x);
        this.y = Math.abs(this.y);
    }
    
    public final void absolute(final Tuple2i lllllllllllllIIlllllIlIIIllllllI) {
        this.x = Math.abs(lllllllllllllIIlllllIlIIIllllllI.x);
        this.y = Math.abs(lllllllllllllIIlllllIlIIIllllllI.y);
    }
    
    public final void clampMin(final int lllllllllllllIIlllllIlIIlIIIllII, final Tuple2i lllllllllllllIIlllllIlIIlIIIlllI) {
        if (lllllllllllllIIlllllIlIIlIIIlllI.x < lllllllllllllIIlllllIlIIlIIIllII) {
            this.x = lllllllllllllIIlllllIlIIlIIIllII;
        }
        else {
            this.x = lllllllllllllIIlllllIlIIlIIIlllI.x;
        }
        if (lllllllllllllIIlllllIlIIlIIIlllI.y < lllllllllllllIIlllllIlIIlIIIllII) {
            this.y = lllllllllllllIIlllllIlIIlIIIllII;
        }
        else {
            this.y = lllllllllllllIIlllllIlIIlIIIlllI.y;
        }
    }
    
    public final void clamp(final int lllllllllllllIIlllllIlIIlIIllIlI, final int lllllllllllllIIlllllIlIIlIIllIIl, final Tuple2i lllllllllllllIIlllllIlIIlIIlIlII) {
        if (lllllllllllllIIlllllIlIIlIIlIlII.x > lllllllllllllIIlllllIlIIlIIllIIl) {
            this.x = lllllllllllllIIlllllIlIIlIIllIIl;
        }
        else if (lllllllllllllIIlllllIlIIlIIlIlII.x < lllllllllllllIIlllllIlIIlIIllIlI) {
            this.x = lllllllllllllIIlllllIlIIlIIllIlI;
        }
        else {
            this.x = lllllllllllllIIlllllIlIIlIIlIlII.x;
        }
        if (lllllllllllllIIlllllIlIIlIIlIlII.y > lllllllllllllIIlllllIlIIlIIllIIl) {
            this.y = lllllllllllllIIlllllIlIIlIIllIIl;
        }
        else if (lllllllllllllIIlllllIlIIlIIlIlII.y < lllllllllllllIIlllllIlIIlIIllIlI) {
            this.y = lllllllllllllIIlllllIlIIlIIllIlI;
        }
        else {
            this.y = lllllllllllllIIlllllIlIIlIIlIlII.y;
        }
    }
    
    public final void setY(final int lllllllllllllIIlllllIlIIIlIIllII) {
        this.y = lllllllllllllIIlllllIlIIIlIIllII;
    }
    
    public Tuple2i(final int lllllllllllllIIlllllIlIlIIllIIII, final int lllllllllllllIIlllllIlIlIIllIIlI) {
        this.x = lllllllllllllIIlllllIlIlIIllIIII;
        this.y = lllllllllllllIIlllllIlIlIIllIIlI;
    }
    
    public final void scale(final int lllllllllllllIIlllllIlIIllIlIIll, final Tuple2i lllllllllllllIIlllllIlIIllIIllll) {
        this.x = lllllllllllllIIlllllIlIIllIlIIll * lllllllllllllIIlllllIlIIllIIllll.x;
        this.y = lllllllllllllIIlllllIlIIllIlIIll * lllllllllllllIIlllllIlIIllIIllll.y;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("(").append(this.x).append(", ").append(this.y).append(")"));
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIIlllllIlIIlIlIllII) {
        try {
            final Tuple2i lllllllllllllIIlllllIlIIlIlIlIll = (Tuple2i)lllllllllllllIIlllllIlIIlIlIllII;
            return this.x == lllllllllllllIIlllllIlIIlIlIlIll.x && this.y == lllllllllllllIIlllllIlIIlIlIlIll.y;
        }
        catch (NullPointerException lllllllllllllIIlllllIlIIlIlIlIlI) {
            return false;
        }
        catch (ClassCastException lllllllllllllIIlllllIlIIlIlIlIIl) {
            return false;
        }
    }
    
    public Object clone() {
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException lllllllllllllIIlllllIlIIIllIIIII) {
            throw new InternalError();
        }
    }
    
    public Tuple2i() {
        this.x = 0;
        this.y = 0;
    }
    
    public final int getY() {
        return this.y;
    }
    
    public final void negate(final Tuple2i lllllllllllllIIlllllIlIIllIllIll) {
        this.x = -lllllllllllllIIlllllIlIIllIllIll.x;
        this.y = -lllllllllllllIIlllllIlIIllIllIll.y;
    }
    
    public Tuple2i(final Tuple2i lllllllllllllIIlllllIlIlIIlIIlIl) {
        this.x = lllllllllllllIIlllllIlIlIIlIIlIl.x;
        this.y = lllllllllllllIIlllllIlIlIIlIIlIl.y;
    }
    
    @Override
    public int hashCode() {
        long lllllllllllllIIlllllIlIIlIlIIIlI = 1L;
        lllllllllllllIIlllllIlIIlIlIIIlI = 31L * lllllllllllllIIlllllIlIIlIlIIIlI + this.x;
        lllllllllllllIIlllllIlIIlIlIIIlI = 31L * lllllllllllllIIlllllIlIIlIlIIIlI + this.y;
        return (int)(lllllllllllllIIlllllIlIIlIlIIIlI ^ lllllllllllllIIlllllIlIIlIlIIIlI >> 32);
    }
    
    public final void setX(final int lllllllllllllIIlllllIlIIIlIlIlll) {
        this.x = lllllllllllllIIlllllIlIIIlIlIlll;
    }
    
    public final void add(final Tuple2i lllllllllllllIIlllllIlIIllllIlll, final Tuple2i lllllllllllllIIlllllIlIIllllIllI) {
        this.x = lllllllllllllIIlllllIlIIllllIlll.x + lllllllllllllIIlllllIlIIllllIllI.x;
        this.y = lllllllllllllIIlllllIlIIllllIlll.y + lllllllllllllIIlllllIlIIllllIllI.y;
    }
    
    public final void clampMax(final int lllllllllllllIIlllllIlIIIllIlIIl) {
        if (this.x > lllllllllllllIIlllllIlIIIllIlIIl) {
            this.x = lllllllllllllIIlllllIlIIIllIlIIl;
        }
        if (this.y > lllllllllllllIIlllllIlIIIllIlIIl) {
            this.y = lllllllllllllIIlllllIlIIIllIlIIl;
        }
    }
    
    public final void set(final Tuple2i lllllllllllllIIlllllIlIlIIIIllIl) {
        this.x = lllllllllllllIIlllllIlIlIIIIllIl.x;
        this.y = lllllllllllllIIlllllIlIlIIIIllIl.y;
    }
    
    public final void sub(final Tuple2i lllllllllllllIIlllllIlIIlllIIIll) {
        this.x -= lllllllllllllIIlllllIlIIlllIIIll.x;
        this.y -= lllllllllllllIIlllllIlIIlllIIIll.y;
    }
    
    public final void clampMin(final int lllllllllllllIIlllllIlIIIllIllIl) {
        if (this.x < lllllllllllllIIlllllIlIIIllIllIl) {
            this.x = lllllllllllllIIlllllIlIIIllIllIl;
        }
        if (this.y < lllllllllllllIIlllllIlIIIllIllIl) {
            this.y = lllllllllllllIIlllllIlIIIllIllIl;
        }
    }
    
    public final void scaleAdd(final int lllllllllllllIIlllllIlIIllIIIIll, final Tuple2i lllllllllllllIIlllllIlIIlIlllllI, final Tuple2i lllllllllllllIIlllllIlIIlIllllIl) {
        this.x = lllllllllllllIIlllllIlIIllIIIIll * lllllllllllllIIlllllIlIIlIlllllI.x + lllllllllllllIIlllllIlIIlIllllIl.x;
        this.y = lllllllllllllIIlllllIlIIllIIIIll * lllllllllllllIIlllllIlIIlIlllllI.y + lllllllllllllIIlllllIlIIlIllllIl.y;
    }
    
    public final void negate() {
        this.x = -this.x;
        this.y = -this.y;
    }
    
    public final void scale(final int lllllllllllllIIlllllIlIIllIIlIll) {
        this.x *= lllllllllllllIIlllllIlIIllIIlIll;
        this.y *= lllllllllllllIIlllllIlIIllIIlIll;
    }
}
