package javax.vecmath;

import java.io.*;

public abstract class Tuple2f implements Cloneable, Serializable
{
    public /* synthetic */ float y;
    public /* synthetic */ float x;
    
    public final void set(final float llllllllllllllIIIllIIlIIIlIIlllI, final float llllllllllllllIIIllIIlIIIlIIllIl) {
        this.x = llllllllllllllIIIllIIlIIIlIIlllI;
        this.y = llllllllllllllIIIllIIlIIIlIIllIl;
    }
    
    public final void get(final float[] llllllllllllllIIIllIIlIIIIllIlll) {
        llllllllllllllIIIllIIlIIIIllIlll[0] = this.x;
        llllllllllllllIIIllIIlIIIIllIlll[1] = this.y;
    }
    
    public Tuple2f(final float llllllllllllllIIIllIIlIIIllIllII, final float llllllllllllllIIIllIIlIIIllIlIll) {
        this.x = llllllllllllllIIIllIIlIIIllIllII;
        this.y = llllllllllllllIIIllIIlIIIllIlIll;
    }
    
    public final void scaleAdd(final float llllllllllllllIIIllIIIlllllllIIl, final Tuple2f llllllllllllllIIIllIIIllllllIlII, final Tuple2f llllllllllllllIIIllIIIllllllIlll) {
        this.x = llllllllllllllIIIllIIIlllllllIIl * llllllllllllllIIIllIIIllllllIlII.x + llllllllllllllIIIllIIIllllllIlll.x;
        this.y = llllllllllllllIIIllIIIlllllllIIl * llllllllllllllIIIllIIIllllllIlII.y + llllllllllllllIIIllIIIllllllIlll.y;
    }
    
    public final void set(final Tuple2f llllllllllllllIIIllIIlIIIlIIIIll) {
        this.x = llllllllllllllIIIllIIlIIIlIIIIll.x;
        this.y = llllllllllllllIIIllIIlIIIlIIIIll.y;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("(").append(this.x).append(", ").append(this.y).append(")"));
    }
    
    public final void scale(final float llllllllllllllIIIllIIlIIIIIIIIIl) {
        this.x *= llllllllllllllIIIllIIlIIIIIIIIIl;
        this.y *= llllllllllllllIIIllIIlIIIIIIIIIl;
    }
    
    public final void negate() {
        this.x = -this.x;
        this.y = -this.y;
    }
    
    public final void clampMin(final float llllllllllllllIIIllIIIlllIIlIIII) {
        if (this.x < llllllllllllllIIIllIIIlllIIlIIII) {
            this.x = llllllllllllllIIIllIIIlllIIlIIII;
        }
        if (this.y < llllllllllllllIIIllIIIlllIIlIIII) {
            this.y = llllllllllllllIIIllIIIlllIIlIIII;
        }
    }
    
    public final float getX() {
        return this.x;
    }
    
    @Override
    public boolean equals(final Object llllllllllllllIIIllIIIllllIlIIIl) {
        try {
            final Tuple2f llllllllllllllIIIllIIIllllIlIlIl = (Tuple2f)llllllllllllllIIIllIIIllllIlIIIl;
            return this.x == llllllllllllllIIIllIIIllllIlIlIl.x && this.y == llllllllllllllIIIllIIIllllIlIlIl.y;
        }
        catch (NullPointerException llllllllllllllIIIllIIIllllIlIlII) {
            return false;
        }
        catch (ClassCastException llllllllllllllIIIllIIIllllIlIIll) {
            return false;
        }
    }
    
    public final void clamp(final float llllllllllllllIIIllIIIlllIlllIll, final float llllllllllllllIIIllIIIlllIllIllI, final Tuple2f llllllllllllllIIIllIIIlllIlllIIl) {
        if (llllllllllllllIIIllIIIlllIlllIIl.x > llllllllllllllIIIllIIIlllIllIllI) {
            this.x = llllllllllllllIIIllIIIlllIllIllI;
        }
        else if (llllllllllllllIIIllIIIlllIlllIIl.x < llllllllllllllIIIllIIIlllIlllIll) {
            this.x = llllllllllllllIIIllIIIlllIlllIll;
        }
        else {
            this.x = llllllllllllllIIIllIIIlllIlllIIl.x;
        }
        if (llllllllllllllIIIllIIIlllIlllIIl.y > llllllllllllllIIIllIIIlllIllIllI) {
            this.y = llllllllllllllIIIllIIIlllIllIllI;
        }
        else if (llllllllllllllIIIllIIIlllIlllIIl.y < llllllllllllllIIIllIIIlllIlllIll) {
            this.y = llllllllllllllIIIllIIIlllIlllIll;
        }
        else {
            this.y = llllllllllllllIIIllIIIlllIlllIIl.y;
        }
    }
    
    public final void sub(final Tuple2f llllllllllllllIIIllIIlIIIIIlIlll) {
        this.x -= llllllllllllllIIIllIIlIIIIIlIlll.x;
        this.y -= llllllllllllllIIIllIIlIIIIIlIlll.y;
    }
    
    public final void absolute() {
        this.x = Math.abs(this.x);
        this.y = Math.abs(this.y);
    }
    
    public final void clamp(final float llllllllllllllIIIllIIIlllIIlIlIl, final float llllllllllllllIIIllIIIlllIIlIlll) {
        if (this.x > llllllllllllllIIIllIIIlllIIlIlll) {
            this.x = llllllllllllllIIIllIIIlllIIlIlll;
        }
        else if (this.x < llllllllllllllIIIllIIIlllIIlIlIl) {
            this.x = llllllllllllllIIIllIIIlllIIlIlIl;
        }
        if (this.y > llllllllllllllIIIllIIIlllIIlIlll) {
            this.y = llllllllllllllIIIllIIIlllIIlIlll;
        }
        else if (this.y < llllllllllllllIIIllIIIlllIIlIlIl) {
            this.y = llllllllllllllIIIllIIIlllIIlIlIl;
        }
    }
    
    public Object clone() {
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException llllllllllllllIIIllIIIllIllIllII) {
            throw new InternalError();
        }
    }
    
    public final void clampMin(final float llllllllllllllIIIllIIIlllIlIllIl, final Tuple2f llllllllllllllIIIllIIIlllIlIllII) {
        if (llllllllllllllIIIllIIIlllIlIllII.x < llllllllllllllIIIllIIIlllIlIllIl) {
            this.x = llllllllllllllIIIllIIIlllIlIllIl;
        }
        else {
            this.x = llllllllllllllIIIllIIIlllIlIllII.x;
        }
        if (llllllllllllllIIIllIIIlllIlIllII.y < llllllllllllllIIIllIIIlllIlIllIl) {
            this.y = llllllllllllllIIIllIIIlllIlIllIl;
        }
        else {
            this.y = llllllllllllllIIIllIIIlllIlIllII.y;
        }
    }
    
    public final void negate(final Tuple2f llllllllllllllIIIllIIlIIIIIlIIIl) {
        this.x = -llllllllllllllIIIllIIlIIIIIlIIIl.x;
        this.y = -llllllllllllllIIIllIIlIIIIIlIIIl.y;
    }
    
    public final void set(final Tuple2d llllllllllllllIIIllIIlIIIIlllIll) {
        this.x = (float)llllllllllllllIIIllIIlIIIIlllIll.x;
        this.y = (float)llllllllllllllIIIllIIlIIIIlllIll.y;
    }
    
    public final void add(final Tuple2f llllllllllllllIIIllIIlIIIIlIIllI) {
        this.x += llllllllllllllIIIllIIlIIIIlIIllI.x;
        this.y += llllllllllllllIIIllIIlIIIIlIIllI.y;
    }
    
    public final void scale(final float llllllllllllllIIIllIIlIIIIIIlIIl, final Tuple2f llllllllllllllIIIllIIlIIIIIIlIII) {
        this.x = llllllllllllllIIIllIIlIIIIIIlIIl * llllllllllllllIIIllIIlIIIIIIlIII.x;
        this.y = llllllllllllllIIIllIIlIIIIIIlIIl * llllllllllllllIIIllIIlIIIIIIlIII.y;
    }
    
    public final void setY(final float llllllllllllllIIIllIIIllIlIllIII) {
        this.y = llllllllllllllIIIllIIIllIlIllIII;
    }
    
    public final void interpolate(final Tuple2f llllllllllllllIIIllIIIllIlllIIIl, final float llllllllllllllIIIllIIIllIlllIIll) {
        this.x = (1.0f - llllllllllllllIIIllIIIllIlllIIll) * this.x + llllllllllllllIIIllIIIllIlllIIll * llllllllllllllIIIllIIIllIlllIIIl.x;
        this.y = (1.0f - llllllllllllllIIIllIIIllIlllIIll) * this.y + llllllllllllllIIIllIIIllIlllIIll * llllllllllllllIIIllIIIllIlllIIIl.y;
    }
    
    public final void clampMax(final float llllllllllllllIIIllIIIlllIIIlIII) {
        if (this.x > llllllllllllllIIIllIIIlllIIIlIII) {
            this.x = llllllllllllllIIIllIIIlllIIIlIII;
        }
        if (this.y > llllllllllllllIIIllIIIlllIIIlIII) {
            this.y = llllllllllllllIIIllIIIlllIIIlIII;
        }
    }
    
    public final float getY() {
        return this.y;
    }
    
    public final void interpolate(final Tuple2f llllllllllllllIIIllIIIllIlllllll, final Tuple2f llllllllllllllIIIllIIIllIllllIlI, final float llllllllllllllIIIllIIIllIllllIIl) {
        this.x = (1.0f - llllllllllllllIIIllIIIllIllllIIl) * llllllllllllllIIIllIIIllIlllllll.x + llllllllllllllIIIllIIIllIllllIIl * llllllllllllllIIIllIIIllIllllIlI.x;
        this.y = (1.0f - llllllllllllllIIIllIIIllIllllIIl) * llllllllllllllIIIllIIIllIlllllll.y + llllllllllllllIIIllIIIllIllllIIl * llllllllllllllIIIllIIIllIllllIlI.y;
    }
    
    public final void scaleAdd(final float llllllllllllllIIIllIIIlllllIlllI, final Tuple2f llllllllllllllIIIllIIIlllllIllIl) {
        this.x = llllllllllllllIIIllIIIlllllIlllI * this.x + llllllllllllllIIIllIIIlllllIllIl.x;
        this.y = llllllllllllllIIIllIIIlllllIlllI * this.y + llllllllllllllIIIllIIIlllllIllIl.y;
    }
    
    public final void clampMax(final float llllllllllllllIIIllIIIlllIlIIlll, final Tuple2f llllllllllllllIIIllIIIlllIlIIIll) {
        if (llllllllllllllIIIllIIIlllIlIIIll.x > llllllllllllllIIIllIIIlllIlIIlll) {
            this.x = llllllllllllllIIIllIIIlllIlIIlll;
        }
        else {
            this.x = llllllllllllllIIIllIIIlllIlIIIll.x;
        }
        if (llllllllllllllIIIllIIIlllIlIIIll.y > llllllllllllllIIIllIIIlllIlIIlll) {
            this.y = llllllllllllllIIIllIIIlllIlIIlll;
        }
        else {
            this.y = llllllllllllllIIIllIIIlllIlIIIll.y;
        }
    }
    
    public boolean epsilonEquals(final Tuple2f llllllllllllllIIIllIIIllllIIlIlI, final float llllllllllllllIIIllIIIllllIIIlIl) {
        float llllllllllllllIIIllIIIllllIIlIII = this.x - llllllllllllllIIIllIIIllllIIlIlI.x;
        if (Float.isNaN(llllllllllllllIIIllIIIllllIIlIII)) {
            return false;
        }
        if (((llllllllllllllIIIllIIIllllIIlIII < 0.0f) ? (-llllllllllllllIIIllIIIllllIIlIII) : llllllllllllllIIIllIIIllllIIlIII) > llllllllllllllIIIllIIIllllIIIlIl) {
            return false;
        }
        llllllllllllllIIIllIIIllllIIlIII = this.y - llllllllllllllIIIllIIIllllIIlIlI.y;
        return !Float.isNaN(llllllllllllllIIIllIIIllllIIlIII) && ((llllllllllllllIIIllIIIllllIIlIII < 0.0f) ? (-llllllllllllllIIIllIIIllllIIlIII) : llllllllllllllIIIllIIIllllIIlIII) <= llllllllllllllIIIllIIIllllIIIlIl;
    }
    
    public Tuple2f(final Tuple2d llllllllllllllIIIllIIlIIIlIllIll) {
        this.x = (float)llllllllllllllIIIllIIlIIIlIllIll.x;
        this.y = (float)llllllllllllllIIIllIIlIIIlIllIll.y;
    }
    
    public final void add(final Tuple2f llllllllllllllIIIllIIlIIIIllIIII, final Tuple2f llllllllllllllIIIllIIlIIIIlIllII) {
        this.x = llllllllllllllIIIllIIlIIIIllIIII.x + llllllllllllllIIIllIIlIIIIlIllII.x;
        this.y = llllllllllllllIIIllIIlIIIIllIIII.y + llllllllllllllIIIllIIlIIIIlIllII.y;
    }
    
    public final void absolute(final Tuple2f llllllllllllllIIIllIIIlllIIlllIl) {
        this.x = Math.abs(llllllllllllllIIIllIIIlllIIlllIl.x);
        this.y = Math.abs(llllllllllllllIIIllIIIlllIIlllIl.y);
    }
    
    public final void set(final float[] llllllllllllllIIIllIIlIIIlIIIlll) {
        this.x = llllllllllllllIIIllIIlIIIlIIIlll[0];
        this.y = llllllllllllllIIIllIIlIIIlIIIlll[1];
    }
    
    public boolean equals(final Tuple2f llllllllllllllIIIllIIIllllIlllll) {
        try {
            return this.x == llllllllllllllIIIllIIIllllIlllll.x && this.y == llllllllllllllIIIllIIIllllIlllll.y;
        }
        catch (NullPointerException llllllllllllllIIIllIIIllllIllllI) {
            return false;
        }
    }
    
    @Override
    public int hashCode() {
        long llllllllllllllIIIllIIIlllllIIllI = 1L;
        llllllllllllllIIIllIIIlllllIIllI = VecMathUtil.hashFloatBits(llllllllllllllIIIllIIIlllllIIllI, this.x);
        llllllllllllllIIIllIIIlllllIIllI = VecMathUtil.hashFloatBits(llllllllllllllIIIllIIIlllllIIllI, this.y);
        return VecMathUtil.hashFinish(llllllllllllllIIIllIIIlllllIIllI);
    }
    
    public final void sub(final Tuple2f llllllllllllllIIIllIIlIIIIlIIIIl, final Tuple2f llllllllllllllIIIllIIlIIIIlIIIII) {
        this.x = llllllllllllllIIIllIIlIIIIlIIIIl.x - llllllllllllllIIIllIIlIIIIlIIIII.x;
        this.y = llllllllllllllIIIllIIlIIIIlIIIIl.y - llllllllllllllIIIllIIlIIIIlIIIII.y;
    }
    
    public Tuple2f() {
        this.x = 0.0f;
        this.y = 0.0f;
    }
    
    public Tuple2f(final float[] llllllllllllllIIIllIIlIIIllIIlIl) {
        this.x = llllllllllllllIIIllIIlIIIllIIlIl[0];
        this.y = llllllllllllllIIIllIIlIIIllIIlIl[1];
    }
    
    public Tuple2f(final Tuple2f llllllllllllllIIIllIIlIIIllIIIIl) {
        this.x = llllllllllllllIIIllIIlIIIllIIIIl.x;
        this.y = llllllllllllllIIIllIIlIIIllIIIIl.y;
    }
    
    public final void setX(final float llllllllllllllIIIllIIIllIllIIIll) {
        this.x = llllllllllllllIIIllIIIllIllIIIll;
    }
}
