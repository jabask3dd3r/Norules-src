package javax.vecmath;

import java.io.*;

public abstract class Tuple4f implements Serializable, Cloneable
{
    public /* synthetic */ float w;
    public /* synthetic */ float x;
    public /* synthetic */ float z;
    public /* synthetic */ float y;
    
    public final void negate() {
        this.x = -this.x;
        this.y = -this.y;
        this.z = -this.z;
        this.w = -this.w;
    }
    
    public boolean epsilonEquals(final Tuple4f lllllllllllllIIlIIIIllIIlIlllIlI, final float lllllllllllllIIlIIIIllIIlIllllIl) {
        float lllllllllllllIIlIIIIllIIlIllllII = this.x - lllllllllllllIIlIIIIllIIlIlllIlI.x;
        if (Float.isNaN(lllllllllllllIIlIIIIllIIlIllllII)) {
            return false;
        }
        if (((lllllllllllllIIlIIIIllIIlIllllII < 0.0f) ? (-lllllllllllllIIlIIIIllIIlIllllII) : lllllllllllllIIlIIIIllIIlIllllII) > lllllllllllllIIlIIIIllIIlIllllIl) {
            return false;
        }
        lllllllllllllIIlIIIIllIIlIllllII = this.y - lllllllllllllIIlIIIIllIIlIlllIlI.y;
        if (Float.isNaN(lllllllllllllIIlIIIIllIIlIllllII)) {
            return false;
        }
        if (((lllllllllllllIIlIIIIllIIlIllllII < 0.0f) ? (-lllllllllllllIIlIIIIllIIlIllllII) : lllllllllllllIIlIIIIllIIlIllllII) > lllllllllllllIIlIIIIllIIlIllllIl) {
            return false;
        }
        lllllllllllllIIlIIIIllIIlIllllII = this.z - lllllllllllllIIlIIIIllIIlIlllIlI.z;
        if (Float.isNaN(lllllllllllllIIlIIIIllIIlIllllII)) {
            return false;
        }
        if (((lllllllllllllIIlIIIIllIIlIllllII < 0.0f) ? (-lllllllllllllIIlIIIIllIIlIllllII) : lllllllllllllIIlIIIIllIIlIllllII) > lllllllllllllIIlIIIIllIIlIllllIl) {
            return false;
        }
        lllllllllllllIIlIIIIllIIlIllllII = this.w - lllllllllllllIIlIIIIllIIlIlllIlI.w;
        return !Float.isNaN(lllllllllllllIIlIIIIllIIlIllllII) && ((lllllllllllllIIlIIIIllIIlIllllII < 0.0f) ? (-lllllllllllllIIlIIIIllIIlIllllII) : lllllllllllllIIlIIIIllIIlIllllII) <= lllllllllllllIIlIIIIllIIlIllllIl;
    }
    
    public final void clampMin(final float lllllllllllllIIlIIIIllIIlIIllllI, final Tuple4f lllllllllllllIIlIIIIllIIlIIlllIl) {
        if (lllllllllllllIIlIIIIllIIlIIlllIl.x < lllllllllllllIIlIIIIllIIlIIllllI) {
            this.x = lllllllllllllIIlIIIIllIIlIIllllI;
        }
        else {
            this.x = lllllllllllllIIlIIIIllIIlIIlllIl.x;
        }
        if (lllllllllllllIIlIIIIllIIlIIlllIl.y < lllllllllllllIIlIIIIllIIlIIllllI) {
            this.y = lllllllllllllIIlIIIIllIIlIIllllI;
        }
        else {
            this.y = lllllllllllllIIlIIIIllIIlIIlllIl.y;
        }
        if (lllllllllllllIIlIIIIllIIlIIlllIl.z < lllllllllllllIIlIIIIllIIlIIllllI) {
            this.z = lllllllllllllIIlIIIIllIIlIIllllI;
        }
        else {
            this.z = lllllllllllllIIlIIIIllIIlIIlllIl.z;
        }
        if (lllllllllllllIIlIIIIllIIlIIlllIl.w < lllllllllllllIIlIIIIllIIlIIllllI) {
            this.w = lllllllllllllIIlIIIIllIIlIIllllI;
        }
        else {
            this.w = lllllllllllllIIlIIIIllIIlIIlllIl.w;
        }
    }
    
    public final void absolute() {
        this.x = Math.abs(this.x);
        this.y = Math.abs(this.y);
        this.z = Math.abs(this.z);
        this.w = Math.abs(this.w);
    }
    
    public Tuple4f(final float[] lllllllllllllIIlIIIIllIlIllIIlII) {
        this.x = lllllllllllllIIlIIIIllIlIllIIlII[0];
        this.y = lllllllllllllIIlIIIIllIlIllIIlII[1];
        this.z = lllllllllllllIIlIIIIllIlIllIIlII[2];
        this.w = lllllllllllllIIlIIIIllIlIllIIlII[3];
    }
    
    public Object clone() {
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException lllllllllllllIIlIIIIllIIIlIlllIl) {
            throw new InternalError();
        }
    }
    
    public Tuple4f() {
        this.x = 0.0f;
        this.y = 0.0f;
        this.z = 0.0f;
        this.w = 0.0f;
    }
    
    public Tuple4f(final Tuple4d lllllllllllllIIlIIIIllIlIlIllIII) {
        this.x = (float)lllllllllllllIIlIIIIllIlIlIllIII.x;
        this.y = (float)lllllllllllllIIlIIIIllIlIlIllIII.y;
        this.z = (float)lllllllllllllIIlIIIIllIlIlIllIII.z;
        this.w = (float)lllllllllllllIIlIIIIllIlIlIllIII.w;
    }
    
    public final void sub(final Tuple4f lllllllllllllIIlIIIIllIlIIIIllll, final Tuple4f lllllllllllllIIlIIIIllIlIIIlIIIl) {
        this.x = lllllllllllllIIlIIIIllIlIIIIllll.x - lllllllllllllIIlIIIIllIlIIIlIIIl.x;
        this.y = lllllllllllllIIlIIIIllIlIIIIllll.y - lllllllllllllIIlIIIIllIlIIIlIIIl.y;
        this.z = lllllllllllllIIlIIIIllIlIIIIllll.z - lllllllllllllIIlIIIIllIlIIIlIIIl.z;
        this.w = lllllllllllllIIlIIIIllIlIIIIllll.w - lllllllllllllIIlIIIIllIlIIIlIIIl.w;
    }
    
    public final float getX() {
        return this.x;
    }
    
    public final void setX(final float lllllllllllllIIlIIIIllIIIlIlIlII) {
        this.x = lllllllllllllIIlIIIIllIIIlIlIlII;
    }
    
    public final void clamp(final float lllllllllllllIIlIIIIllIIlIIIlIIl, final float lllllllllllllIIlIIIIllIIlIIIlIII) {
        if (this.x > lllllllllllllIIlIIIIllIIlIIIlIII) {
            this.x = lllllllllllllIIlIIIIllIIlIIIlIII;
        }
        else if (this.x < lllllllllllllIIlIIIIllIIlIIIlIIl) {
            this.x = lllllllllllllIIlIIIIllIIlIIIlIIl;
        }
        if (this.y > lllllllllllllIIlIIIIllIIlIIIlIII) {
            this.y = lllllllllllllIIlIIIIllIIlIIIlIII;
        }
        else if (this.y < lllllllllllllIIlIIIIllIIlIIIlIIl) {
            this.y = lllllllllllllIIlIIIIllIIlIIIlIIl;
        }
        if (this.z > lllllllllllllIIlIIIIllIIlIIIlIII) {
            this.z = lllllllllllllIIlIIIIllIIlIIIlIII;
        }
        else if (this.z < lllllllllllllIIlIIIIllIIlIIIlIIl) {
            this.z = lllllllllllllIIlIIIIllIIlIIIlIIl;
        }
        if (this.w > lllllllllllllIIlIIIIllIIlIIIlIII) {
            this.w = lllllllllllllIIlIIIIllIIlIIIlIII;
        }
        else if (this.w < lllllllllllllIIlIIIIllIIlIIIlIIl) {
            this.w = lllllllllllllIIlIIIIllIIlIIIlIIl;
        }
    }
    
    public final void set(final float lllllllllllllIIlIIIIllIlIlIIIlll, final float lllllllllllllIIlIIIIllIlIlIIlIll, final float lllllllllllllIIlIIIIllIlIlIIIlIl, final float lllllllllllllIIlIIIIllIlIlIIlIIl) {
        this.x = lllllllllllllIIlIIIIllIlIlIIIlll;
        this.y = lllllllllllllIIlIIIIllIlIlIIlIll;
        this.z = lllllllllllllIIlIIIIllIlIlIIIlIl;
        this.w = lllllllllllllIIlIIIIllIlIlIIlIIl;
    }
    
    public final void setY(final float lllllllllllllIIlIIIIllIIIlIIlIIl) {
        this.y = lllllllllllllIIlIIIIllIIIlIIlIIl;
    }
    
    public Tuple4f(final Tuple4f lllllllllllllIIlIIIIllIlIlIllllI) {
        this.x = lllllllllllllIIlIIIIllIlIlIllllI.x;
        this.y = lllllllllllllIIlIIIIllIlIlIllllI.y;
        this.z = lllllllllllllIIlIIIIllIlIlIllllI.z;
        this.w = lllllllllllllIIlIIIIllIlIlIllllI.w;
    }
    
    public final void sub(final Tuple4f lllllllllllllIIlIIIIllIlIIIIlIlI) {
        this.x -= lllllllllllllIIlIIIIllIlIIIIlIlI.x;
        this.y -= lllllllllllllIIlIIIIllIlIIIIlIlI.y;
        this.z -= lllllllllllllIIlIIIIllIlIIIIlIlI.z;
        this.w -= lllllllllllllIIlIIIIllIlIIIIlIlI.w;
    }
    
    public final void scaleAdd(final float lllllllllllllIIlIIIIllIIllIlllll, final Tuple4f lllllllllllllIIlIIIIllIIllIllIll) {
        this.x = lllllllllllllIIlIIIIllIIllIlllll * this.x + lllllllllllllIIlIIIIllIIllIllIll.x;
        this.y = lllllllllllllIIlIIIIllIIllIlllll * this.y + lllllllllllllIIlIIIIllIIllIllIll.y;
        this.z = lllllllllllllIIlIIIIllIIllIlllll * this.z + lllllllllllllIIlIIIIllIIllIllIll.z;
        this.w = lllllllllllllIIlIIIIllIIllIlllll * this.w + lllllllllllllIIlIIIIllIIllIllIll.w;
    }
    
    public final void get(final Tuple4f lllllllllllllIIlIIIIllIlIIlIlIII) {
        lllllllllllllIIlIIIIllIlIIlIlIII.x = this.x;
        lllllllllllllIIlIIIIllIlIIlIlIII.y = this.y;
        lllllllllllllIIlIIIIllIlIIlIlIII.z = this.z;
        lllllllllllllIIlIIIIllIlIIlIlIII.w = this.w;
    }
    
    public final void clampMax(final float lllllllllllllIIlIIIIllIIIllllIll) {
        if (this.x > lllllllllllllIIlIIIIllIIIllllIll) {
            this.x = lllllllllllllIIlIIIIllIIIllllIll;
        }
        if (this.y > lllllllllllllIIlIIIIllIIIllllIll) {
            this.y = lllllllllllllIIlIIIIllIIIllllIll;
        }
        if (this.z > lllllllllllllIIlIIIIllIIIllllIll) {
            this.z = lllllllllllllIIlIIIIllIIIllllIll;
        }
        if (this.w > lllllllllllllIIlIIIIllIIIllllIll) {
            this.w = lllllllllllllIIlIIIIllIIIllllIll;
        }
    }
    
    public final void clampMin(final float lllllllllllllIIlIIIIllIIIlllllll) {
        if (this.x < lllllllllllllIIlIIIIllIIIlllllll) {
            this.x = lllllllllllllIIlIIIIllIIIlllllll;
        }
        if (this.y < lllllllllllllIIlIIIIllIIIlllllll) {
            this.y = lllllllllllllIIlIIIIllIIIlllllll;
        }
        if (this.z < lllllllllllllIIlIIIIllIIIlllllll) {
            this.z = lllllllllllllIIlIIIIllIIIlllllll;
        }
        if (this.w < lllllllllllllIIlIIIIllIIIlllllll) {
            this.w = lllllllllllllIIlIIIIllIIIlllllll;
        }
    }
    
    public final void scaleAdd(final float lllllllllllllIIlIIIIllIIlllIIllI, final Tuple4f lllllllllllllIIlIIIIllIIlllIIlIl, final Tuple4f lllllllllllllIIlIIIIllIIlllIIlII) {
        this.x = lllllllllllllIIlIIIIllIIlllIIllI * lllllllllllllIIlIIIIllIIlllIIlIl.x + lllllllllllllIIlIIIIllIIlllIIlII.x;
        this.y = lllllllllllllIIlIIIIllIIlllIIllI * lllllllllllllIIlIIIIllIIlllIIlIl.y + lllllllllllllIIlIIIIllIIlllIIlII.y;
        this.z = lllllllllllllIIlIIIIllIIlllIIllI * lllllllllllllIIlIIIIllIIlllIIlIl.z + lllllllllllllIIlIIIIllIIlllIIlII.z;
        this.w = lllllllllllllIIlIIIIllIIlllIIllI * lllllllllllllIIlIIIIllIIlllIIlIl.w + lllllllllllllIIlIIIIllIIlllIIlII.w;
    }
    
    public final void negate(final Tuple4f lllllllllllllIIlIIIIllIlIIIIIIlI) {
        this.x = -lllllllllllllIIlIIIIllIlIIIIIIlI.x;
        this.y = -lllllllllllllIIlIIIIllIlIIIIIIlI.y;
        this.z = -lllllllllllllIIlIIIIllIlIIIIIIlI.z;
        this.w = -lllllllllllllIIlIIIIllIlIIIIIIlI.w;
    }
    
    public final void setZ(final float lllllllllllllIIlIIIIllIIIlIIIIlI) {
        this.z = lllllllllllllIIlIIIIllIIIlIIIIlI;
    }
    
    @Override
    public int hashCode() {
        long lllllllllllllIIlIIIIllIIlIllIlII = 1L;
        lllllllllllllIIlIIIIllIIlIllIlII = VecMathUtil.hashFloatBits(lllllllllllllIIlIIIIllIIlIllIlII, this.x);
        lllllllllllllIIlIIIIllIIlIllIlII = VecMathUtil.hashFloatBits(lllllllllllllIIlIIIIllIIlIllIlII, this.y);
        lllllllllllllIIlIIIIllIIlIllIlII = VecMathUtil.hashFloatBits(lllllllllllllIIlIIIIllIIlIllIlII, this.z);
        lllllllllllllIIlIIIIllIIlIllIlII = VecMathUtil.hashFloatBits(lllllllllllllIIlIIIIllIIlIllIlII, this.w);
        return VecMathUtil.hashFinish(lllllllllllllIIlIIIIllIIlIllIlII);
    }
    
    public final float getW() {
        return this.w;
    }
    
    public final void clamp(final float lllllllllllllIIlIIIIllIIlIlIllII, final float lllllllllllllIIlIIIIllIIlIlIlIll, final Tuple4f lllllllllllllIIlIIIIllIIlIlIIllI) {
        if (lllllllllllllIIlIIIIllIIlIlIIllI.x > lllllllllllllIIlIIIIllIIlIlIlIll) {
            this.x = lllllllllllllIIlIIIIllIIlIlIlIll;
        }
        else if (lllllllllllllIIlIIIIllIIlIlIIllI.x < lllllllllllllIIlIIIIllIIlIlIllII) {
            this.x = lllllllllllllIIlIIIIllIIlIlIllII;
        }
        else {
            this.x = lllllllllllllIIlIIIIllIIlIlIIllI.x;
        }
        if (lllllllllllllIIlIIIIllIIlIlIIllI.y > lllllllllllllIIlIIIIllIIlIlIlIll) {
            this.y = lllllllllllllIIlIIIIllIIlIlIlIll;
        }
        else if (lllllllllllllIIlIIIIllIIlIlIIllI.y < lllllllllllllIIlIIIIllIIlIlIllII) {
            this.y = lllllllllllllIIlIIIIllIIlIlIllII;
        }
        else {
            this.y = lllllllllllllIIlIIIIllIIlIlIIllI.y;
        }
        if (lllllllllllllIIlIIIIllIIlIlIIllI.z > lllllllllllllIIlIIIIllIIlIlIlIll) {
            this.z = lllllllllllllIIlIIIIllIIlIlIlIll;
        }
        else if (lllllllllllllIIlIIIIllIIlIlIIllI.z < lllllllllllllIIlIIIIllIIlIlIllII) {
            this.z = lllllllllllllIIlIIIIllIIlIlIllII;
        }
        else {
            this.z = lllllllllllllIIlIIIIllIIlIlIIllI.z;
        }
        if (lllllllllllllIIlIIIIllIIlIlIIllI.w > lllllllllllllIIlIIIIllIIlIlIlIll) {
            this.w = lllllllllllllIIlIIIIllIIlIlIlIll;
        }
        else if (lllllllllllllIIlIIIIllIIlIlIIllI.w < lllllllllllllIIlIIIIllIIlIlIllII) {
            this.w = lllllllllllllIIlIIIIllIIlIlIllII;
        }
        else {
            this.w = lllllllllllllIIlIIIIllIIlIlIIllI.w;
        }
    }
    
    public final void set(final Tuple4d lllllllllllllIIlIIIIllIlIIllIlII) {
        this.x = (float)lllllllllllllIIlIIIIllIlIIllIlII.x;
        this.y = (float)lllllllllllllIIlIIIIllIlIIllIlII.y;
        this.z = (float)lllllllllllllIIlIIIIllIlIIllIlII.z;
        this.w = (float)lllllllllllllIIlIIIIllIlIIllIlII.w;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("(").append(this.x).append(", ").append(this.y).append(", ").append(this.z).append(", ").append(this.w).append(")"));
    }
    
    public final void set(final float[] lllllllllllllIIlIIIIllIlIlIIIIII) {
        this.x = lllllllllllllIIlIIIIllIlIlIIIIII[0];
        this.y = lllllllllllllIIlIIIIllIlIlIIIIII[1];
        this.z = lllllllllllllIIlIIIIllIlIlIIIIII[2];
        this.w = lllllllllllllIIlIIIIllIlIlIIIIII[3];
    }
    
    public void interpolate(final Tuple4f lllllllllllllIIlIIIIllIIIllIIIlI, final float lllllllllllllIIlIIIIllIIIllIIIIl) {
        this.x = (1.0f - lllllllllllllIIlIIIIllIIIllIIIIl) * this.x + lllllllllllllIIlIIIIllIIIllIIIIl * lllllllllllllIIlIIIIllIIIllIIIlI.x;
        this.y = (1.0f - lllllllllllllIIlIIIIllIIIllIIIIl) * this.y + lllllllllllllIIlIIIIllIIIllIIIIl * lllllllllllllIIlIIIIllIIIllIIIlI.y;
        this.z = (1.0f - lllllllllllllIIlIIIIllIIIllIIIIl) * this.z + lllllllllllllIIlIIIIllIIIllIIIIl * lllllllllllllIIlIIIIllIIIllIIIlI.z;
        this.w = (1.0f - lllllllllllllIIlIIIIllIIIllIIIIl) * this.w + lllllllllllllIIlIIIIllIIIllIIIIl * lllllllllllllIIlIIIIllIIIllIIIlI.w;
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIIlIIIIllIIllIIlIlI) {
        try {
            final Tuple4f lllllllllllllIIlIIIIllIIllIIlIIl = (Tuple4f)lllllllllllllIIlIIIIllIIllIIlIlI;
            return this.x == lllllllllllllIIlIIIIllIIllIIlIIl.x && this.y == lllllllllllllIIlIIIIllIIllIIlIIl.y && this.z == lllllllllllllIIlIIIIllIIllIIlIIl.z && this.w == lllllllllllllIIlIIIIllIIllIIlIIl.w;
        }
        catch (NullPointerException lllllllllllllIIlIIIIllIIllIIlIII) {
            return false;
        }
        catch (ClassCastException lllllllllllllIIlIIIIllIIllIIIlll) {
            return false;
        }
    }
    
    public final float getY() {
        return this.y;
    }
    
    public final void scale(final float lllllllllllllIIlIIIIllIIllllIIlI) {
        this.x *= lllllllllllllIIlIIIIllIIllllIIlI;
        this.y *= lllllllllllllIIlIIIIllIIllllIIlI;
        this.z *= lllllllllllllIIlIIIIllIIllllIIlI;
        this.w *= lllllllllllllIIlIIIIllIIllllIIlI;
    }
    
    public final void clampMax(final float lllllllllllllIIlIIIIllIIlIIlIlIl, final Tuple4f lllllllllllllIIlIIIIllIIlIIlIlII) {
        if (lllllllllllllIIlIIIIllIIlIIlIlII.x > lllllllllllllIIlIIIIllIIlIIlIlIl) {
            this.x = lllllllllllllIIlIIIIllIIlIIlIlIl;
        }
        else {
            this.x = lllllllllllllIIlIIIIllIIlIIlIlII.x;
        }
        if (lllllllllllllIIlIIIIllIIlIIlIlII.y > lllllllllllllIIlIIIIllIIlIIlIlIl) {
            this.y = lllllllllllllIIlIIIIllIIlIIlIlIl;
        }
        else {
            this.y = lllllllllllllIIlIIIIllIIlIIlIlII.y;
        }
        if (lllllllllllllIIlIIIIllIIlIIlIlII.z > lllllllllllllIIlIIIIllIIlIIlIlIl) {
            this.z = lllllllllllllIIlIIIIllIIlIIlIlIl;
        }
        else {
            this.z = lllllllllllllIIlIIIIllIIlIIlIlII.z;
        }
        if (lllllllllllllIIlIIIIllIIlIIlIlII.w > lllllllllllllIIlIIIIllIIlIIlIlIl) {
            this.w = lllllllllllllIIlIIIIllIIlIIlIlIl;
        }
        else {
            this.w = lllllllllllllIIlIIIIllIIlIIlIlII.z;
        }
    }
    
    public final void set(final Tuple4f lllllllllllllIIlIIIIllIlIIlllIlI) {
        this.x = lllllllllllllIIlIIIIllIlIIlllIlI.x;
        this.y = lllllllllllllIIlIIIIllIlIIlllIlI.y;
        this.z = lllllllllllllIIlIIIIllIlIIlllIlI.z;
        this.w = lllllllllllllIIlIIIIllIlIIlllIlI.w;
    }
    
    public final void setW(final float lllllllllllllIIlIIIIllIIIIlllIIl) {
        this.w = lllllllllllllIIlIIIIllIIIIlllIIl;
    }
    
    public void interpolate(final Tuple4f lllllllllllllIIlIIIIllIIIlllIIII, final Tuple4f lllllllllllllIIlIIIIllIIIllIlIll, final float lllllllllllllIIlIIIIllIIIllIlllI) {
        this.x = (1.0f - lllllllllllllIIlIIIIllIIIllIlllI) * lllllllllllllIIlIIIIllIIIlllIIII.x + lllllllllllllIIlIIIIllIIIllIlllI * lllllllllllllIIlIIIIllIIIllIlIll.x;
        this.y = (1.0f - lllllllllllllIIlIIIIllIIIllIlllI) * lllllllllllllIIlIIIIllIIIlllIIII.y + lllllllllllllIIlIIIIllIIIllIlllI * lllllllllllllIIlIIIIllIIIllIlIll.y;
        this.z = (1.0f - lllllllllllllIIlIIIIllIIIllIlllI) * lllllllllllllIIlIIIIllIIIlllIIII.z + lllllllllllllIIlIIIIllIIIllIlllI * lllllllllllllIIlIIIIllIIIllIlIll.z;
        this.w = (1.0f - lllllllllllllIIlIIIIllIIIllIlllI) * lllllllllllllIIlIIIIllIIIlllIIII.w + lllllllllllllIIlIIIIllIIIllIlllI * lllllllllllllIIlIIIIllIIIllIlIll.w;
    }
    
    public boolean equals(final Tuple4f lllllllllllllIIlIIIIllIIllIlIIll) {
        try {
            return this.x == lllllllllllllIIlIIIIllIIllIlIIll.x && this.y == lllllllllllllIIlIIIIllIIllIlIIll.y && this.z == lllllllllllllIIlIIIIllIIllIlIIll.z && this.w == lllllllllllllIIlIIIIllIIllIlIIll.w;
        }
        catch (NullPointerException lllllllllllllIIlIIIIllIIllIlIIlI) {
            return false;
        }
    }
    
    public final void add(final Tuple4f lllllllllllllIIlIIIIllIlIIlIIIIl, final Tuple4f lllllllllllllIIlIIIIllIlIIIlllIl) {
        this.x = lllllllllllllIIlIIIIllIlIIlIIIIl.x + lllllllllllllIIlIIIIllIlIIIlllIl.x;
        this.y = lllllllllllllIIlIIIIllIlIIlIIIIl.y + lllllllllllllIIlIIIIllIlIIIlllIl.y;
        this.z = lllllllllllllIIlIIIIllIlIIlIIIIl.z + lllllllllllllIIlIIIIllIlIIIlllIl.z;
        this.w = lllllllllllllIIlIIIIllIlIIlIIIIl.w + lllllllllllllIIlIIIIllIlIIIlllIl.w;
    }
    
    public final void absolute(final Tuple4f lllllllllllllIIlIIIIllIIlIIlIIII) {
        this.x = Math.abs(lllllllllllllIIlIIIIllIIlIIlIIII.x);
        this.y = Math.abs(lllllllllllllIIlIIIIllIIlIIlIIII.y);
        this.z = Math.abs(lllllllllllllIIlIIIIllIIlIIlIIII.z);
        this.w = Math.abs(lllllllllllllIIlIIIIllIIlIIlIIII.w);
    }
    
    public final void get(final float[] lllllllllllllIIlIIIIllIlIIlIlllI) {
        lllllllllllllIIlIIIIllIlIIlIlllI[0] = this.x;
        lllllllllllllIIlIIIIllIlIIlIlllI[1] = this.y;
        lllllllllllllIIlIIIIllIlIIlIlllI[2] = this.z;
        lllllllllllllIIlIIIIllIlIIlIlllI[3] = this.w;
    }
    
    public final float getZ() {
        return this.z;
    }
    
    public Tuple4f(final float lllllllllllllIIlIIIIllIlIllIlIll, final float lllllllllllllIIlIIIIllIlIllIlIlI, final float lllllllllllllIIlIIIIllIlIllIlIIl, final float lllllllllllllIIlIIIIllIlIllIllIl) {
        this.x = lllllllllllllIIlIIIIllIlIllIlIll;
        this.y = lllllllllllllIIlIIIIllIlIllIlIlI;
        this.z = lllllllllllllIIlIIIIllIlIllIlIIl;
        this.w = lllllllllllllIIlIIIIllIlIllIllIl;
    }
    
    public final void scale(final float lllllllllllllIIlIIIIllIIllllIlll, final Tuple4f lllllllllllllIIlIIIIllIIlllllIIl) {
        this.x = lllllllllllllIIlIIIIllIIllllIlll * lllllllllllllIIlIIIIllIIlllllIIl.x;
        this.y = lllllllllllllIIlIIIIllIIllllIlll * lllllllllllllIIlIIIIllIIlllllIIl.y;
        this.z = lllllllllllllIIlIIIIllIIllllIlll * lllllllllllllIIlIIIIllIIlllllIIl.z;
        this.w = lllllllllllllIIlIIIIllIIllllIlll * lllllllllllllIIlIIIIllIIlllllIIl.w;
    }
    
    public final void add(final Tuple4f lllllllllllllIIlIIIIllIlIIIlIlll) {
        this.x += lllllllllllllIIlIIIIllIlIIIlIlll.x;
        this.y += lllllllllllllIIlIIIIllIlIIIlIlll.y;
        this.z += lllllllllllllIIlIIIIllIlIIIlIlll.z;
        this.w += lllllllllllllIIlIIIIllIlIIIlIlll.w;
    }
}
