package javax.vecmath;

import java.io.*;

public abstract class Tuple3f implements Cloneable, Serializable
{
    public /* synthetic */ float x;
    public /* synthetic */ float z;
    public /* synthetic */ float y;
    
    public final void clampMax(final float lllllllllllllIIllIlIlllIlIllIIII, final Tuple3f lllllllllllllIIllIlIlllIlIlIllll) {
        if (lllllllllllllIIllIlIlllIlIlIllll.x > lllllllllllllIIllIlIlllIlIllIIII) {
            this.x = lllllllllllllIIllIlIlllIlIllIIII;
        }
        else {
            this.x = lllllllllllllIIllIlIlllIlIlIllll.x;
        }
        if (lllllllllllllIIllIlIlllIlIlIllll.y > lllllllllllllIIllIlIlllIlIllIIII) {
            this.y = lllllllllllllIIllIlIlllIlIllIIII;
        }
        else {
            this.y = lllllllllllllIIllIlIlllIlIlIllll.y;
        }
        if (lllllllllllllIIllIlIlllIlIlIllll.z > lllllllllllllIIllIlIlllIlIllIIII) {
            this.z = lllllllllllllIIllIlIlllIlIllIIII;
        }
        else {
            this.z = lllllllllllllIIllIlIlllIlIlIllll.z;
        }
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("(").append(this.x).append(", ").append(this.y).append(", ").append(this.z).append(")"));
    }
    
    public final void get(final float[] lllllllllllllIIllIlIllllIlIIIIll) {
        lllllllllllllIIllIlIllllIlIIIIll[0] = this.x;
        lllllllllllllIIllIlIllllIlIIIIll[1] = this.y;
        lllllllllllllIIllIlIllllIlIIIIll[2] = this.z;
    }
    
    public final void interpolate(final Tuple3f lllllllllllllIIllIlIlllIIlllllIl, final float lllllllllllllIIllIlIlllIIllllIIl) {
        this.x = (1.0f - lllllllllllllIIllIlIlllIIllllIIl) * this.x + lllllllllllllIIllIlIlllIIllllIIl * lllllllllllllIIllIlIlllIIlllllIl.x;
        this.y = (1.0f - lllllllllllllIIllIlIlllIIllllIIl) * this.y + lllllllllllllIIllIlIlllIIllllIIl * lllllllllllllIIllIlIlllIIlllllIl.y;
        this.z = (1.0f - lllllllllllllIIllIlIlllIIllllIIl) * this.z + lllllllllllllIIllIlIlllIIllllIIl * lllllllllllllIIllIlIlllIIlllllIl.z;
    }
    
    public final float getY() {
        return this.y;
    }
    
    public final void clampMax(final float lllllllllllllIIllIlIlllIlIIlIIIl) {
        if (this.x > lllllllllllllIIllIlIlllIlIIlIIIl) {
            this.x = lllllllllllllIIllIlIlllIlIIlIIIl;
        }
        if (this.y > lllllllllllllIIllIlIlllIlIIlIIIl) {
            this.y = lllllllllllllIIllIlIlllIlIIlIIIl;
        }
        if (this.z > lllllllllllllIIllIlIlllIlIIlIIIl) {
            this.z = lllllllllllllIIllIlIlllIlIIlIIIl;
        }
    }
    
    public final void negate() {
        this.x = -this.x;
        this.y = -this.y;
        this.z = -this.z;
    }
    
    public final float getX() {
        return this.x;
    }
    
    public final void set(final Tuple3d lllllllllllllIIllIlIllllIlIIIlll) {
        this.x = (float)lllllllllllllIIllIlIllllIlIIIlll.x;
        this.y = (float)lllllllllllllIIllIlIllllIlIIIlll.y;
        this.z = (float)lllllllllllllIIllIlIllllIlIIIlll.z;
    }
    
    public final void clamp(final float lllllllllllllIIllIlIlllIlIIllllI, final float lllllllllllllIIllIlIlllIlIIlllIl) {
        if (this.x > lllllllllllllIIllIlIlllIlIIlllIl) {
            this.x = lllllllllllllIIllIlIlllIlIIlllIl;
        }
        else if (this.x < lllllllllllllIIllIlIlllIlIIllllI) {
            this.x = lllllllllllllIIllIlIlllIlIIllllI;
        }
        if (this.y > lllllllllllllIIllIlIlllIlIIlllIl) {
            this.y = lllllllllllllIIllIlIlllIlIIlllIl;
        }
        else if (this.y < lllllllllllllIIllIlIlllIlIIllllI) {
            this.y = lllllllllllllIIllIlIlllIlIIllllI;
        }
        if (this.z > lllllllllllllIIllIlIlllIlIIlllIl) {
            this.z = lllllllllllllIIllIlIlllIlIIlllIl;
        }
        else if (this.z < lllllllllllllIIllIlIlllIlIIllllI) {
            this.z = lllllllllllllIIllIlIlllIlIIllllI;
        }
    }
    
    public final void set(final Tuple3f lllllllllllllIIllIlIllllIlIIllIl) {
        this.x = lllllllllllllIIllIlIllllIlIIllIl.x;
        this.y = lllllllllllllIIllIlIllllIlIIllIl.y;
        this.z = lllllllllllllIIllIlIllllIlIIllIl.z;
    }
    
    public Object clone() {
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException lllllllllllllIIllIlIlllIIlllIlIl) {
            throw new InternalError();
        }
    }
    
    public final void sub(final Tuple3f lllllllllllllIIllIlIllllIIIlllll) {
        this.x -= lllllllllllllIIllIlIllllIIIlllll.x;
        this.y -= lllllllllllllIIllIlIllllIIIlllll.y;
        this.z -= lllllllllllllIIllIlIllllIIIlllll.z;
    }
    
    public Tuple3f(final float lllllllllllllIIllIlIllllIlllllll, final float lllllllllllllIIllIlIlllllIIIIIlI, final float lllllllllllllIIllIlIlllllIIIIIIl) {
        this.x = lllllllllllllIIllIlIllllIlllllll;
        this.y = lllllllllllllIIllIlIlllllIIIIIlI;
        this.z = lllllllllllllIIllIlIlllllIIIIIIl;
    }
    
    public final void setY(final float lllllllllllllIIllIlIlllIIllIIIIl) {
        this.y = lllllllllllllIIllIlIlllIIllIIIIl;
    }
    
    public final void add(final Tuple3f lllllllllllllIIllIlIllllIIlIlllI) {
        this.x += lllllllllllllIIllIlIllllIIlIlllI.x;
        this.y += lllllllllllllIIllIlIllllIIlIlllI.y;
        this.z += lllllllllllllIIllIlIllllIIlIlllI.z;
    }
    
    public final void scaleAdd(final float lllllllllllllIIllIlIlllIllllIlII, final Tuple3f lllllllllllllIIllIlIlllIllllIIII) {
        this.x = lllllllllllllIIllIlIlllIllllIlII * this.x + lllllllllllllIIllIlIlllIllllIIII.x;
        this.y = lllllllllllllIIllIlIlllIllllIlII * this.y + lllllllllllllIIllIlIlllIllllIIII.y;
        this.z = lllllllllllllIIllIlIlllIllllIlII * this.z + lllllllllllllIIllIlIlllIllllIIII.z;
    }
    
    public Tuple3f() {
        this.x = 0.0f;
        this.y = 0.0f;
        this.z = 0.0f;
    }
    
    public boolean epsilonEquals(final Tuple3f lllllllllllllIIllIlIlllIllIlIIlI, final float lllllllllllllIIllIlIlllIllIlIIIl) {
        float lllllllllllllIIllIlIlllIllIlIlII = this.x - lllllllllllllIIllIlIlllIllIlIIlI.x;
        if (Float.isNaN(lllllllllllllIIllIlIlllIllIlIlII)) {
            return false;
        }
        if (((lllllllllllllIIllIlIlllIllIlIlII < 0.0f) ? (-lllllllllllllIIllIlIlllIllIlIlII) : lllllllllllllIIllIlIlllIllIlIlII) > lllllllllllllIIllIlIlllIllIlIIIl) {
            return false;
        }
        lllllllllllllIIllIlIlllIllIlIlII = this.y - lllllllllllllIIllIlIlllIllIlIIlI.y;
        if (Float.isNaN(lllllllllllllIIllIlIlllIllIlIlII)) {
            return false;
        }
        if (((lllllllllllllIIllIlIlllIllIlIlII < 0.0f) ? (-lllllllllllllIIllIlIlllIllIlIlII) : lllllllllllllIIllIlIlllIllIlIlII) > lllllllllllllIIllIlIlllIllIlIIIl) {
            return false;
        }
        lllllllllllllIIllIlIlllIllIlIlII = this.z - lllllllllllllIIllIlIlllIllIlIIlI.z;
        return !Float.isNaN(lllllllllllllIIllIlIlllIllIlIlII) && ((lllllllllllllIIllIlIlllIllIlIlII < 0.0f) ? (-lllllllllllllIIllIlIlllIllIlIlII) : lllllllllllllIIllIlIlllIllIlIlII) <= lllllllllllllIIllIlIlllIllIlIIIl;
    }
    
    public final void interpolate(final Tuple3f lllllllllllllIIllIlIlllIlIIIIlII, final Tuple3f lllllllllllllIIllIlIlllIlIIIIIll, final float lllllllllllllIIllIlIlllIlIIIIIlI) {
        this.x = (1.0f - lllllllllllllIIllIlIlllIlIIIIIlI) * lllllllllllllIIllIlIlllIlIIIIlII.x + lllllllllllllIIllIlIlllIlIIIIIlI * lllllllllllllIIllIlIlllIlIIIIIll.x;
        this.y = (1.0f - lllllllllllllIIllIlIlllIlIIIIIlI) * lllllllllllllIIllIlIlllIlIIIIlII.y + lllllllllllllIIllIlIlllIlIIIIIlI * lllllllllllllIIllIlIlllIlIIIIIll.y;
        this.z = (1.0f - lllllllllllllIIllIlIlllIlIIIIIlI) * lllllllllllllIIllIlIlllIlIIIIlII.z + lllllllllllllIIllIlIlllIlIIIIIlI * lllllllllllllIIllIlIlllIlIIIIIll.z;
    }
    
    public final float getZ() {
        return this.z;
    }
    
    public final void absolute(final Tuple3f lllllllllllllIIllIlIlllIlIlIIllI) {
        this.x = Math.abs(lllllllllllllIIllIlIlllIlIlIIllI.x);
        this.y = Math.abs(lllllllllllllIIllIlIlllIlIlIIllI.y);
        this.z = Math.abs(lllllllllllllIIllIlIlllIlIlIIllI.z);
    }
    
    public boolean equals(final Tuple3f lllllllllllllIIllIlIlllIlllIlIII) {
        try {
            return this.x == lllllllllllllIIllIlIlllIlllIlIII.x && this.y == lllllllllllllIIllIlIlllIlllIlIII.y && this.z == lllllllllllllIIllIlIlllIlllIlIII.z;
        }
        catch (NullPointerException lllllllllllllIIllIlIlllIlllIlIlI) {
            return false;
        }
    }
    
    public final void clampMin(final float lllllllllllllIIllIlIlllIlIIlIlll) {
        if (this.x < lllllllllllllIIllIlIlllIlIIlIlll) {
            this.x = lllllllllllllIIllIlIlllIlIIlIlll;
        }
        if (this.y < lllllllllllllIIllIlIlllIlIIlIlll) {
            this.y = lllllllllllllIIllIlIlllIlIIlIlll;
        }
        if (this.z < lllllllllllllIIllIlIlllIlIIlIlll) {
            this.z = lllllllllllllIIllIlIlllIlIIlIlll;
        }
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIIllIlIlllIlllIIIlI) {
        try {
            final Tuple3f lllllllllllllIIllIlIlllIlllIIIIl = (Tuple3f)lllllllllllllIIllIlIlllIlllIIIlI;
            return this.x == lllllllllllllIIllIlIlllIlllIIIIl.x && this.y == lllllllllllllIIllIlIlllIlllIIIIl.y && this.z == lllllllllllllIIllIlIlllIlllIIIIl.z;
        }
        catch (NullPointerException lllllllllllllIIllIlIlllIlllIIIII) {
            return false;
        }
        catch (ClassCastException lllllllllllllIIllIlIlllIllIlllll) {
            return false;
        }
    }
    
    public final void set(final float[] lllllllllllllIIllIlIllllIlIlIlIl) {
        this.x = lllllllllllllIIllIlIllllIlIlIlIl[0];
        this.y = lllllllllllllIIllIlIllllIlIlIlIl[1];
        this.z = lllllllllllllIIllIlIllllIlIlIlIl[2];
    }
    
    public final void clamp(final float lllllllllllllIIllIlIlllIllIIIIII, final float lllllllllllllIIllIlIlllIllIIIIll, final Tuple3f lllllllllllllIIllIlIlllIlIlllllI) {
        if (lllllllllllllIIllIlIlllIlIlllllI.x > lllllllllllllIIllIlIlllIllIIIIll) {
            this.x = lllllllllllllIIllIlIlllIllIIIIll;
        }
        else if (lllllllllllllIIllIlIlllIlIlllllI.x < lllllllllllllIIllIlIlllIllIIIIII) {
            this.x = lllllllllllllIIllIlIlllIllIIIIII;
        }
        else {
            this.x = lllllllllllllIIllIlIlllIlIlllllI.x;
        }
        if (lllllllllllllIIllIlIlllIlIlllllI.y > lllllllllllllIIllIlIlllIllIIIIll) {
            this.y = lllllllllllllIIllIlIlllIllIIIIll;
        }
        else if (lllllllllllllIIllIlIlllIlIlllllI.y < lllllllllllllIIllIlIlllIllIIIIII) {
            this.y = lllllllllllllIIllIlIlllIllIIIIII;
        }
        else {
            this.y = lllllllllllllIIllIlIlllIlIlllllI.y;
        }
        if (lllllllllllllIIllIlIlllIlIlllllI.z > lllllllllllllIIllIlIlllIllIIIIll) {
            this.z = lllllllllllllIIllIlIlllIllIIIIll;
        }
        else if (lllllllllllllIIllIlIlllIlIlllllI.z < lllllllllllllIIllIlIlllIllIIIIII) {
            this.z = lllllllllllllIIllIlIlllIllIIIIII;
        }
        else {
            this.z = lllllllllllllIIllIlIlllIlIlllllI.z;
        }
    }
    
    public final void scale(final float lllllllllllllIIllIlIllllIIIIllII, final Tuple3f lllllllllllllIIllIlIllllIIIIlIll) {
        this.x = lllllllllllllIIllIlIllllIIIIllII * lllllllllllllIIllIlIllllIIIIlIll.x;
        this.y = lllllllllllllIIllIlIllllIIIIllII * lllllllllllllIIllIlIllllIIIIlIll.y;
        this.z = lllllllllllllIIllIlIllllIIIIllII * lllllllllllllIIllIlIllllIIIIlIll.z;
    }
    
    public Tuple3f(final Tuple3f lllllllllllllIIllIlIllllIlllIIll) {
        this.x = lllllllllllllIIllIlIllllIlllIIll.x;
        this.y = lllllllllllllIIllIlIllllIlllIIll.y;
        this.z = lllllllllllllIIllIlIllllIlllIIll.z;
    }
    
    public final void set(final float lllllllllllllIIllIlIllllIlIlllll, final float lllllllllllllIIllIlIllllIlIllIlI, final float lllllllllllllIIllIlIllllIlIllIIl) {
        this.x = lllllllllllllIIllIlIllllIlIlllll;
        this.y = lllllllllllllIIllIlIllllIlIllIlI;
        this.z = lllllllllllllIIllIlIllllIlIllIIl;
    }
    
    public final void setZ(final float lllllllllllllIIllIlIlllIIlIllIlI) {
        this.z = lllllllllllllIIllIlIlllIIlIllIlI;
    }
    
    public final void get(final Tuple3f lllllllllllllIIllIlIllllIIlllIll) {
        lllllllllllllIIllIlIllllIIlllIll.x = this.x;
        lllllllllllllIIllIlIllllIIlllIll.y = this.y;
        lllllllllllllIIllIlIllllIIlllIll.z = this.z;
    }
    
    public final void absolute() {
        this.x = Math.abs(this.x);
        this.y = Math.abs(this.y);
        this.z = Math.abs(this.z);
    }
    
    public final void setX(final float lllllllllllllIIllIlIlllIIllIlIlI) {
        this.x = lllllllllllllIIllIlIlllIIllIlIlI;
    }
    
    public Tuple3f(final float[] lllllllllllllIIllIlIllllIllllIIl) {
        this.x = lllllllllllllIIllIlIllllIllllIIl[0];
        this.y = lllllllllllllIIllIlIllllIllllIIl[1];
        this.z = lllllllllllllIIllIlIllllIllllIIl[2];
    }
    
    public final void scale(final float lllllllllllllIIllIlIllllIIIIIlll) {
        this.x *= lllllllllllllIIllIlIllllIIIIIlll;
        this.y *= lllllllllllllIIllIlIllllIIIIIlll;
        this.z *= lllllllllllllIIllIlIllllIIIIIlll;
    }
    
    @Override
    public int hashCode() {
        long lllllllllllllIIllIlIlllIllIIllII = 1L;
        lllllllllllllIIllIlIlllIllIIllII = VecMathUtil.hashFloatBits(lllllllllllllIIllIlIlllIllIIllII, this.x);
        lllllllllllllIIllIlIlllIllIIllII = VecMathUtil.hashFloatBits(lllllllllllllIIllIlIlllIllIIllII, this.y);
        lllllllllllllIIllIlIlllIllIIllII = VecMathUtil.hashFloatBits(lllllllllllllIIllIlIlllIllIIllII, this.z);
        return VecMathUtil.hashFinish(lllllllllllllIIllIlIlllIllIIllII);
    }
    
    public final void scaleAdd(final float lllllllllllllIIllIlIlllIlllllIll, final Tuple3f lllllllllllllIIllIlIlllIlllllIlI, final Tuple3f lllllllllllllIIllIlIlllIllllllIl) {
        this.x = lllllllllllllIIllIlIlllIlllllIll * lllllllllllllIIllIlIlllIlllllIlI.x + lllllllllllllIIllIlIlllIllllllIl.x;
        this.y = lllllllllllllIIllIlIlllIlllllIll * lllllllllllllIIllIlIlllIlllllIlI.y + lllllllllllllIIllIlIlllIllllllIl.y;
        this.z = lllllllllllllIIllIlIlllIlllllIll * lllllllllllllIIllIlIlllIlllllIlI.z + lllllllllllllIIllIlIlllIllllllIl.z;
    }
    
    public final void add(final Tuple3f lllllllllllllIIllIlIllllIIllIllI, final Tuple3f lllllllllllllIIllIlIllllIIllIIlI) {
        this.x = lllllllllllllIIllIlIllllIIllIllI.x + lllllllllllllIIllIlIllllIIllIIlI.x;
        this.y = lllllllllllllIIllIlIllllIIllIllI.y + lllllllllllllIIllIlIllllIIllIIlI.y;
        this.z = lllllllllllllIIllIlIllllIIllIllI.z + lllllllllllllIIllIlIllllIIllIIlI.z;
    }
    
    public final void clampMin(final float lllllllllllllIIllIlIlllIlIllIllI, final Tuple3f lllllllllllllIIllIlIlllIlIlllIII) {
        if (lllllllllllllIIllIlIlllIlIlllIII.x < lllllllllllllIIllIlIlllIlIllIllI) {
            this.x = lllllllllllllIIllIlIlllIlIllIllI;
        }
        else {
            this.x = lllllllllllllIIllIlIlllIlIlllIII.x;
        }
        if (lllllllllllllIIllIlIlllIlIlllIII.y < lllllllllllllIIllIlIlllIlIllIllI) {
            this.y = lllllllllllllIIllIlIlllIlIllIllI;
        }
        else {
            this.y = lllllllllllllIIllIlIlllIlIlllIII.y;
        }
        if (lllllllllllllIIllIlIlllIlIlllIII.z < lllllllllllllIIllIlIlllIlIllIllI) {
            this.z = lllllllllllllIIllIlIlllIlIllIllI;
        }
        else {
            this.z = lllllllllllllIIllIlIlllIlIlllIII.z;
        }
    }
    
    public final void negate(final Tuple3f lllllllllllllIIllIlIllllIIIllIIl) {
        this.x = -lllllllllllllIIllIlIllllIIIllIIl.x;
        this.y = -lllllllllllllIIllIlIllllIIIllIIl.y;
        this.z = -lllllllllllllIIllIlIllllIIIllIIl.z;
    }
    
    public final void sub(final Tuple3f lllllllllllllIIllIlIllllIIlIIlII, final Tuple3f lllllllllllllIIllIlIllllIIlIIIll) {
        this.x = lllllllllllllIIllIlIllllIIlIIlII.x - lllllllllllllIIllIlIllllIIlIIIll.x;
        this.y = lllllllllllllIIllIlIllllIIlIIlII.y - lllllllllllllIIllIlIllllIIlIIIll.y;
        this.z = lllllllllllllIIllIlIllllIIlIIlII.z - lllllllllllllIIllIlIllllIIlIIIll.z;
    }
    
    public Tuple3f(final Tuple3d lllllllllllllIIllIlIllllIllIllIl) {
        this.x = (float)lllllllllllllIIllIlIllllIllIllIl.x;
        this.y = (float)lllllllllllllIIllIlIllllIllIllIl.y;
        this.z = (float)lllllllllllllIIllIlIllllIllIllIl.z;
    }
}
