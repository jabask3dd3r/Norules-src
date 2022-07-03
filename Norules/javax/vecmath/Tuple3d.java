package javax.vecmath;

import java.io.*;

public abstract class Tuple3d implements Serializable, Cloneable
{
    public /* synthetic */ double x;
    public /* synthetic */ double z;
    public /* synthetic */ double y;
    
    @Deprecated
    public final void clamp(final float llllllllllllllllllIIIllIlllllIlI, final float llllllllllllllllllIIIllIlllllIIl) {
        this.clamp(llllllllllllllllllIIIllIlllllIlI, (double)llllllllllllllllllIIIllIlllllIIl);
    }
    
    public Object clone() {
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException llllllllllllllllllIIIllIlIlIIlll) {
            throw new InternalError();
        }
    }
    
    public final void set(final double llllllllllllllllllIIIllllllIIlIl, final double llllllllllllllllllIIIllllllIIlII, final double llllllllllllllllllIIIllllllIIIll) {
        this.x = llllllllllllllllllIIIllllllIIlIl;
        this.y = llllllllllllllllllIIIllllllIIlII;
        this.z = llllllllllllllllllIIIllllllIIIll;
    }
    
    public final void clamp(final double llllllllllllllllllIIIlllIIllIIlI, final double llllllllllllllllllIIIlllIIlIllIl, final Tuple3d llllllllllllllllllIIIlllIIlIllII) {
        if (llllllllllllllllllIIIlllIIlIllII.x > llllllllllllllllllIIIlllIIlIllIl) {
            this.x = llllllllllllllllllIIIlllIIlIllIl;
        }
        else if (llllllllllllllllllIIIlllIIlIllII.x < llllllllllllllllllIIIlllIIllIIlI) {
            this.x = llllllllllllllllllIIIlllIIllIIlI;
        }
        else {
            this.x = llllllllllllllllllIIIlllIIlIllII.x;
        }
        if (llllllllllllllllllIIIlllIIlIllII.y > llllllllllllllllllIIIlllIIlIllIl) {
            this.y = llllllllllllllllllIIIlllIIlIllIl;
        }
        else if (llllllllllllllllllIIIlllIIlIllII.y < llllllllllllllllllIIIlllIIllIIlI) {
            this.y = llllllllllllllllllIIIlllIIllIIlI;
        }
        else {
            this.y = llllllllllllllllllIIIlllIIlIllII.y;
        }
        if (llllllllllllllllllIIIlllIIlIllII.z > llllllllllllllllllIIIlllIIlIllIl) {
            this.z = llllllllllllllllllIIIlllIIlIllIl;
        }
        else if (llllllllllllllllllIIIlllIIlIllII.z < llllllllllllllllllIIIlllIIllIIlI) {
            this.z = llllllllllllllllllIIIlllIIllIIlI;
        }
        else {
            this.z = llllllllllllllllllIIIlllIIlIllII.z;
        }
    }
    
    @Deprecated
    public final void interpolate(final Tuple3d llllllllllllllllllIIIllIlIlllIII, final float llllllllllllllllllIIIllIlIllIlll) {
        this.interpolate(llllllllllllllllllIIIllIlIlllIII, (double)llllllllllllllllllIIIllIlIllIlll);
    }
    
    @Deprecated
    public final void clamp(final float llllllllllllllllllIIIlllIIlllllI, final float llllllllllllllllllIIIlllIIlllIIl, final Tuple3d llllllllllllllllllIIIlllIIllllII) {
        this.clamp(llllllllllllllllllIIIlllIIlllllI, (double)llllllllllllllllllIIIlllIIlllIIl, llllllllllllllllllIIIlllIIllllII);
    }
    
    public Tuple3d(final double llllllllllllllllllIIlIIIIIIIIIlI, final double llllllllllllllllllIIlIIIIIIIIIIl, final double llllllllllllllllllIIlIIIIIIIIIII) {
        this.x = llllllllllllllllllIIlIIIIIIIIIlI;
        this.y = llllllllllllllllllIIlIIIIIIIIIIl;
        this.z = llllllllllllllllllIIlIIIIIIIIIII;
    }
    
    public Tuple3d(final double[] llllllllllllllllllIIIlllllllllII) {
        this.x = llllllllllllllllllIIIlllllllllII[0];
        this.y = llllllllllllllllllIIIlllllllllII[1];
        this.z = llllllllllllllllllIIIlllllllllII[2];
    }
    
    @Deprecated
    public final void interpolate(final Tuple3d llllllllllllllllllIIIllIllIIlIll, final Tuple3d llllllllllllllllllIIIllIllIIlIlI, final float llllllllllllllllllIIIllIllIIlIIl) {
        this.interpolate(llllllllllllllllllIIIllIllIIlIll, llllllllllllllllllIIIllIllIIlIlI, (double)llllllllllllllllllIIIllIllIIlIIl);
    }
    
    public final void setZ(final double llllllllllllllllllIIIllIIllllIIl) {
        this.z = llllllllllllllllllIIIllIIllllIIl;
    }
    
    public final void add(final Tuple3d llllllllllllllllllIIIllllIllIlII) {
        this.x += llllllllllllllllllIIIllllIllIlII.x;
        this.y += llllllllllllllllllIIIllllIllIlII.y;
        this.z += llllllllllllllllllIIIllllIllIlII.z;
    }
    
    public final void set(final Tuple3d llllllllllllllllllIIIlllllIlIlIl) {
        this.x = llllllllllllllllllIIIlllllIlIlIl.x;
        this.y = llllllllllllllllllIIIlllllIlIlIl.y;
        this.z = llllllllllllllllllIIIlllllIlIlIl.z;
    }
    
    public final double getY() {
        return this.y;
    }
    
    public final void set(final Tuple3f llllllllllllllllllIIIlllllIIllIl) {
        this.x = llllllllllllllllllIIIlllllIIllIl.x;
        this.y = llllllllllllllllllIIIlllllIIllIl.y;
        this.z = llllllllllllllllllIIIlllllIIllIl.z;
    }
    
    public final void clampMin(final double llllllllllllllllllIIIlllIIIllIll, final Tuple3d llllllllllllllllllIIIlllIIIlllIl) {
        if (llllllllllllllllllIIIlllIIIlllIl.x < llllllllllllllllllIIIlllIIIllIll) {
            this.x = llllllllllllllllllIIIlllIIIllIll;
        }
        else {
            this.x = llllllllllllllllllIIIlllIIIlllIl.x;
        }
        if (llllllllllllllllllIIIlllIIIlllIl.y < llllllllllllllllllIIIlllIIIllIll) {
            this.y = llllllllllllllllllIIIlllIIIllIll;
        }
        else {
            this.y = llllllllllllllllllIIIlllIIIlllIl.y;
        }
        if (llllllllllllllllllIIIlllIIIlllIl.z < llllllllllllllllllIIIlllIIIllIll) {
            this.z = llllllllllllllllllIIIlllIIIllIll;
        }
        else {
            this.z = llllllllllllllllllIIIlllIIIlllIl.z;
        }
    }
    
    public final void sub(final Tuple3d llllllllllllllllllIIIllllIlIllIl, final Tuple3d llllllllllllllllllIIIllllIlIlIIl) {
        this.x = llllllllllllllllllIIIllllIlIllIl.x - llllllllllllllllllIIIllllIlIlIIl.x;
        this.y = llllllllllllllllllIIIllllIlIllIl.y - llllllllllllllllllIIIllllIlIlIIl.y;
        this.z = llllllllllllllllllIIIllllIlIllIl.z - llllllllllllllllllIIIllllIlIlIIl.z;
    }
    
    public final void negate() {
        this.x = -this.x;
        this.y = -this.y;
        this.z = -this.z;
    }
    
    @Deprecated
    public final void clampMin(final float llllllllllllllllllIIIllIlllIlIlI) {
        this.clampMin((double)llllllllllllllllllIIIllIlllIlIlI);
    }
    
    public final void clampMax(final double llllllllllllllllllIIIlllIIIIllII, final Tuple3d llllllllllllllllllIIIlllIIIIlIII) {
        if (llllllllllllllllllIIIlllIIIIlIII.x > llllllllllllllllllIIIlllIIIIllII) {
            this.x = llllllllllllllllllIIIlllIIIIllII;
        }
        else {
            this.x = llllllllllllllllllIIIlllIIIIlIII.x;
        }
        if (llllllllllllllllllIIIlllIIIIlIII.y > llllllllllllllllllIIIlllIIIIllII) {
            this.y = llllllllllllllllllIIIlllIIIIllII;
        }
        else {
            this.y = llllllllllllllllllIIIlllIIIIlIII.y;
        }
        if (llllllllllllllllllIIIlllIIIIlIII.z > llllllllllllllllllIIIlllIIIIllII) {
            this.z = llllllllllllllllllIIIlllIIIIllII;
        }
        else {
            this.z = llllllllllllllllllIIIlllIIIIlIII.z;
        }
    }
    
    @Deprecated
    public final void clampMax(final float llllllllllllllllllIIIllIlllIIIII) {
        this.clampMax((double)llllllllllllllllllIIIllIlllIIIII);
    }
    
    public final void interpolate(final Tuple3d llllllllllllllllllIIIllIlIlIllll, final double llllllllllllllllllIIIllIlIlIlIll) {
        this.x = (1.0 - llllllllllllllllllIIIllIlIlIlIll) * this.x + llllllllllllllllllIIIllIlIlIlIll * llllllllllllllllllIIIllIlIlIllll.x;
        this.y = (1.0 - llllllllllllllllllIIIllIlIlIlIll) * this.y + llllllllllllllllllIIIllIlIlIlIll * llllllllllllllllllIIIllIlIlIllll.y;
        this.z = (1.0 - llllllllllllllllllIIIllIlIlIlIll) * this.z + llllllllllllllllllIIIllIlIlIlIll * llllllllllllllllllIIIllIlIlIllll.z;
    }
    
    public final void absolute() {
        this.x = Math.abs(this.x);
        this.y = Math.abs(this.y);
        this.z = Math.abs(this.z);
    }
    
    public final void sub(final Tuple3d llllllllllllllllllIIIllllIlIIIll) {
        this.x -= llllllllllllllllllIIIllllIlIIIll.x;
        this.y -= llllllllllllllllllIIIllllIlIIIll.y;
        this.z -= llllllllllllllllllIIIllllIlIIIll.z;
    }
    
    public final void clampMin(final double llllllllllllllllllIIIllIlllIIllI) {
        if (this.x < llllllllllllllllllIIIllIlllIIllI) {
            this.x = llllllllllllllllllIIIllIlllIIllI;
        }
        if (this.y < llllllllllllllllllIIIllIlllIIllI) {
            this.y = llllllllllllllllllIIIllIlllIIllI;
        }
        if (this.z < llllllllllllllllllIIIllIlllIIllI) {
            this.z = llllllllllllllllllIIIllIlllIIllI;
        }
    }
    
    public boolean equals(final Tuple3d llllllllllllllllllIIIlllIlIlllII) {
        try {
            return this.x == llllllllllllllllllIIIlllIlIlllII.x && this.y == llllllllllllllllllIIIlllIlIlllII.y && this.z == llllllllllllllllllIIIlllIlIlllII.z;
        }
        catch (NullPointerException llllllllllllllllllIIIlllIlIllllI) {
            return false;
        }
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("(").append(this.x).append(", ").append(this.y).append(", ").append(this.z).append(")"));
    }
    
    @Deprecated
    public final void scaleAdd(final double llllllllllllllllllIIIlllIlllIlll, final Tuple3f llllllllllllllllllIIIlllIllllIIl) {
        this.scaleAdd(llllllllllllllllllIIIlllIlllIlll, new Point3d(llllllllllllllllllIIIlllIllllIIl));
    }
    
    public final void absolute(final Tuple3d llllllllllllllllllIIIlllIIIIIlII) {
        this.x = Math.abs(llllllllllllllllllIIIlllIIIIIlII.x);
        this.y = Math.abs(llllllllllllllllllIIIlllIIIIIlII.y);
        this.z = Math.abs(llllllllllllllllllIIIlllIIIIIlII.z);
    }
    
    @Deprecated
    public final void clampMax(final float llllllllllllllllllIIIlllIIIlIIlI, final Tuple3d llllllllllllllllllIIIlllIIIlIlII) {
        this.clampMax((double)llllllllllllllllllIIIlllIIIlIIlI, llllllllllllllllllIIIlllIIIlIlII);
    }
    
    public final void negate(final Tuple3d llllllllllllllllllIIIllllIIlllIl) {
        this.x = -llllllllllllllllllIIIllllIIlllIl.x;
        this.y = -llllllllllllllllllIIIllllIIlllIl.y;
        this.z = -llllllllllllllllllIIIllllIIlllIl.z;
    }
    
    public final void setX(final double llllllllllllllllllIIIllIlIIllIIl) {
        this.x = llllllllllllllllllIIIllIlIIllIIl;
    }
    
    public final void scaleAdd(final double llllllllllllllllllIIIlllIlllIIIl, final Tuple3d llllllllllllllllllIIIlllIlllIIII) {
        this.x = llllllllllllllllllIIIlllIlllIIIl * this.x + llllllllllllllllllIIIlllIlllIIII.x;
        this.y = llllllllllllllllllIIIlllIlllIIIl * this.y + llllllllllllllllllIIIlllIlllIIII.y;
        this.z = llllllllllllllllllIIIlllIlllIIIl * this.z + llllllllllllllllllIIIlllIlllIIII.z;
    }
    
    public Tuple3d(final Tuple3d llllllllllllllllllIIIlllllllIllI) {
        this.x = llllllllllllllllllIIIlllllllIllI.x;
        this.y = llllllllllllllllllIIIlllllllIllI.y;
        this.z = llllllllllllllllllIIIlllllllIllI.z;
    }
    
    public final void clampMax(final double llllllllllllllllllIIIllIllIllIII) {
        if (this.x > llllllllllllllllllIIIllIllIllIII) {
            this.x = llllllllllllllllllIIIllIllIllIII;
        }
        if (this.y > llllllllllllllllllIIIllIllIllIII) {
            this.y = llllllllllllllllllIIIllIllIllIII;
        }
        if (this.z > llllllllllllllllllIIIllIllIllIII) {
            this.z = llllllllllllllllllIIIllIllIllIII;
        }
    }
    
    public final void set(final double[] llllllllllllllllllIIIlllllIllIIl) {
        this.x = llllllllllllllllllIIIlllllIllIIl[0];
        this.y = llllllllllllllllllIIIlllllIllIIl[1];
        this.z = llllllllllllllllllIIIlllllIllIIl[2];
    }
    
    public boolean epsilonEquals(final Tuple3d llllllllllllllllllIIIlllIlIIIllI, final double llllllllllllllllllIIIlllIlIIlIIl) {
        double llllllllllllllllllIIIlllIlIIlIII = this.x - llllllllllllllllllIIIlllIlIIIllI.x;
        if (Double.isNaN(llllllllllllllllllIIIlllIlIIlIII)) {
            return false;
        }
        if (((llllllllllllllllllIIIlllIlIIlIII < 0.0) ? (-llllllllllllllllllIIIlllIlIIlIII) : llllllllllllllllllIIIlllIlIIlIII) > llllllllllllllllllIIIlllIlIIlIIl) {
            return false;
        }
        llllllllllllllllllIIIlllIlIIlIII = this.y - llllllllllllllllllIIIlllIlIIIllI.y;
        if (Double.isNaN(llllllllllllllllllIIIlllIlIIlIII)) {
            return false;
        }
        if (((llllllllllllllllllIIIlllIlIIlIII < 0.0) ? (-llllllllllllllllllIIIlllIlIIlIII) : llllllllllllllllllIIIlllIlIIlIII) > llllllllllllllllllIIIlllIlIIlIIl) {
            return false;
        }
        llllllllllllllllllIIIlllIlIIlIII = this.z - llllllllllllllllllIIIlllIlIIIllI.z;
        return !Double.isNaN(llllllllllllllllllIIIlllIlIIlIII) && ((llllllllllllllllllIIIlllIlIIlIII < 0.0) ? (-llllllllllllllllllIIIlllIlIIlIII) : llllllllllllllllllIIIlllIlIIlIII) <= llllllllllllllllllIIIlllIlIIlIIl;
    }
    
    public final void scale(final double llllllllllllllllllIIIllllIIIllIl) {
        this.x *= llllllllllllllllllIIIllllIIIllIl;
        this.y *= llllllllllllllllllIIIllllIIIllIl;
        this.z *= llllllllllllllllllIIIllllIIIllIl;
    }
    
    public final void setY(final double llllllllllllllllllIIIllIlIIIlIll) {
        this.y = llllllllllllllllllIIIllIlIIIlIll;
    }
    
    public final void add(final Tuple3d llllllllllllllllllIIIllllIllllII, final Tuple3d llllllllllllllllllIIIllllIlllIll) {
        this.x = llllllllllllllllllIIIllllIllllII.x + llllllllllllllllllIIIllllIlllIll.x;
        this.y = llllllllllllllllllIIIllllIllllII.y + llllllllllllllllllIIIllllIlllIll.y;
        this.z = llllllllllllllllllIIIllllIllllII.z + llllllllllllllllllIIIllllIlllIll.z;
    }
    
    public final void get(final Tuple3d llllllllllllllllllIIIlllllIIIIIl) {
        llllllllllllllllllIIIlllllIIIIIl.x = this.x;
        llllllllllllllllllIIIlllllIIIIIl.y = this.y;
        llllllllllllllllllIIIlllllIIIIIl.z = this.z;
    }
    
    public final double getZ() {
        return this.z;
    }
    
    @Override
    public int hashCode() {
        long llllllllllllllllllIIIlllIllIIllI = 1L;
        llllllllllllllllllIIIlllIllIIllI = VecMathUtil.hashDoubleBits(llllllllllllllllllIIIlllIllIIllI, this.x);
        llllllllllllllllllIIIlllIllIIllI = VecMathUtil.hashDoubleBits(llllllllllllllllllIIIlllIllIIllI, this.y);
        llllllllllllllllllIIIlllIllIIllI = VecMathUtil.hashDoubleBits(llllllllllllllllllIIIlllIllIIllI, this.z);
        return VecMathUtil.hashFinish(llllllllllllllllllIIIlllIllIIllI);
    }
    
    public final void clamp(final double llllllllllllllllllIIIllIllllIIIl, final double llllllllllllllllllIIIllIllllIIII) {
        if (this.x > llllllllllllllllllIIIllIllllIIII) {
            this.x = llllllllllllllllllIIIllIllllIIII;
        }
        else if (this.x < llllllllllllllllllIIIllIllllIIIl) {
            this.x = llllllllllllllllllIIIllIllllIIIl;
        }
        if (this.y > llllllllllllllllllIIIllIllllIIII) {
            this.y = llllllllllllllllllIIIllIllllIIII;
        }
        else if (this.y < llllllllllllllllllIIIllIllllIIIl) {
            this.y = llllllllllllllllllIIIllIllllIIIl;
        }
        if (this.z > llllllllllllllllllIIIllIllllIIII) {
            this.z = llllllllllllllllllIIIllIllllIIII;
        }
        else if (this.z < llllllllllllllllllIIIllIllllIIIl) {
            this.z = llllllllllllllllllIIIllIllllIIIl;
        }
    }
    
    @Override
    public boolean equals(final Object llllllllllllllllllIIIlllIlIlIllI) {
        try {
            final Tuple3d llllllllllllllllllIIIlllIlIlIlIl = (Tuple3d)llllllllllllllllllIIIlllIlIlIllI;
            return this.x == llllllllllllllllllIIIlllIlIlIlIl.x && this.y == llllllllllllllllllIIIlllIlIlIlIl.y && this.z == llllllllllllllllllIIIlllIlIlIlIl.z;
        }
        catch (ClassCastException llllllllllllllllllIIIlllIlIlIlII) {
            return false;
        }
        catch (NullPointerException llllllllllllllllllIIIlllIlIlIIll) {
            return false;
        }
    }
    
    public Tuple3d(final Tuple3f llllllllllllllllllIIIlllllllIIII) {
        this.x = llllllllllllllllllIIIlllllllIIII.x;
        this.y = llllllllllllllllllIIIlllllllIIII.y;
        this.z = llllllllllllllllllIIIlllllllIIII.z;
    }
    
    public final void get(final double[] llllllllllllllllllIIIlllllIIlIIl) {
        llllllllllllllllllIIIlllllIIlIIl[0] = this.x;
        llllllllllllllllllIIIlllllIIlIIl[1] = this.y;
        llllllllllllllllllIIIlllllIIlIIl[2] = this.z;
    }
    
    public final void scaleAdd(final double llllllllllllllllllIIIllllIIIIIIl, final Tuple3d llllllllllllllllllIIIllllIIIIIII, final Tuple3d llllllllllllllllllIIIllllIIIIIll) {
        this.x = llllllllllllllllllIIIllllIIIIIIl * llllllllllllllllllIIIllllIIIIIII.x + llllllllllllllllllIIIllllIIIIIll.x;
        this.y = llllllllllllllllllIIIllllIIIIIIl * llllllllllllllllllIIIllllIIIIIII.y + llllllllllllllllllIIIllllIIIIIll.y;
        this.z = llllllllllllllllllIIIllllIIIIIIl * llllllllllllllllllIIIllllIIIIIII.z + llllllllllllllllllIIIllllIIIIIll.z;
    }
    
    public final void interpolate(final Tuple3d llllllllllllllllllIIIllIlIllllll, final Tuple3d llllllllllllllllllIIIllIllIIIIlI, final double llllllllllllllllllIIIllIllIIIIIl) {
        this.x = (1.0 - llllllllllllllllllIIIllIllIIIIIl) * llllllllllllllllllIIIllIlIllllll.x + llllllllllllllllllIIIllIllIIIIIl * llllllllllllllllllIIIllIllIIIIlI.x;
        this.y = (1.0 - llllllllllllllllllIIIllIllIIIIIl) * llllllllllllllllllIIIllIlIllllll.y + llllllllllllllllllIIIllIllIIIIIl * llllllllllllllllllIIIllIllIIIIlI.y;
        this.z = (1.0 - llllllllllllllllllIIIllIllIIIIIl) * llllllllllllllllllIIIllIlIllllll.z + llllllllllllllllllIIIllIllIIIIIl * llllllllllllllllllIIIllIllIIIIlI.z;
    }
    
    public final double getX() {
        return this.x;
    }
    
    public Tuple3d() {
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
    }
    
    @Deprecated
    public final void clampMin(final float llllllllllllllllllIIIlllIIlIIlII, final Tuple3d llllllllllllllllllIIIlllIIlIIllI) {
        this.clampMin((double)llllllllllllllllllIIIlllIIlIIlII, llllllllllllllllllIIIlllIIlIIllI);
    }
    
    public final void scale(final double llllllllllllllllllIIIllllIIlIlIl, final Tuple3d llllllllllllllllllIIIllllIIlIIIl) {
        this.x = llllllllllllllllllIIIllllIIlIlIl * llllllllllllllllllIIIllllIIlIIIl.x;
        this.y = llllllllllllllllllIIIllllIIlIlIl * llllllllllllllllllIIIllllIIlIIIl.y;
        this.z = llllllllllllllllllIIIllllIIlIlIl * llllllllllllllllllIIIllllIIlIIIl.z;
    }
}
