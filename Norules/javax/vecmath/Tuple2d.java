package javax.vecmath;

import java.io.*;

public abstract class Tuple2d implements Cloneable, Serializable
{
    public /* synthetic */ double y;
    public /* synthetic */ double x;
    
    public final void interpolate(final Tuple2d llllllllllllIlllllIlIllIlIIlllII, final Tuple2d llllllllllllIlllllIlIllIlIIlllll, final double llllllllllllIlllllIlIllIlIIllllI) {
        this.x = (1.0 - llllllllllllIlllllIlIllIlIIllllI) * llllllllllllIlllllIlIllIlIIlllII.x + llllllllllllIlllllIlIllIlIIllllI * llllllllllllIlllllIlIllIlIIlllll.x;
        this.y = (1.0 - llllllllllllIlllllIlIllIlIIllllI) * llllllllllllIlllllIlIllIlIIlllII.y + llllllllllllIlllllIlIllIlIIllllI * llllllllllllIlllllIlIllIlIIlllll.y;
    }
    
    public final void scaleAdd(final double llllllllllllIlllllIlIlllIIIIllII, final Tuple2d llllllllllllIlllllIlIlllIIIIlIll) {
        this.x = llllllllllllIlllllIlIlllIIIIllII * this.x + llllllllllllIlllllIlIlllIIIIlIll.x;
        this.y = llllllllllllIlllllIlIlllIIIIllII * this.y + llllllllllllIlllllIlIlllIIIIlIll.y;
    }
    
    public Tuple2d(final Tuple2f llllllllllllIlllllIlIlllIllllIlI) {
        this.x = llllllllllllIlllllIlIlllIllllIlI.x;
        this.y = llllllllllllIlllllIlIlllIllllIlI.y;
    }
    
    public final void scale(final double llllllllllllIlllllIlIlllIIlIlIlI, final Tuple2d llllllllllllIlllllIlIlllIIlIIllI) {
        this.x = llllllllllllIlllllIlIlllIIlIlIlI * llllllllllllIlllllIlIlllIIlIIllI.x;
        this.y = llllllllllllIlllllIlIlllIIlIlIlI * llllllllllllIlllllIlIlllIIlIIllI.y;
    }
    
    public Tuple2d(final double llllllllllllIlllllIlIllllIIlIIII, final double llllllllllllIlllllIlIllllIIIllII) {
        this.x = llllllllllllIlllllIlIllllIIlIIII;
        this.y = llllllllllllIlllllIlIllllIIIllII;
    }
    
    public final void negate() {
        this.x = -this.x;
        this.y = -this.y;
    }
    
    public Tuple2d(final double[] llllllllllllIlllllIlIllllIIIIllI) {
        this.x = llllllllllllIlllllIlIllllIIIIllI[0];
        this.y = llllllllllllIlllllIlIllllIIIIllI[1];
    }
    
    @Override
    public int hashCode() {
        long llllllllllllIlllllIlIlllIIIIIlll = 1L;
        llllllllllllIlllllIlIlllIIIIIlll = VecMathUtil.hashDoubleBits(llllllllllllIlllllIlIlllIIIIIlll, this.x);
        llllllllllllIlllllIlIlllIIIIIlll = VecMathUtil.hashDoubleBits(llllllllllllIlllllIlIlllIIIIIlll, this.y);
        return VecMathUtil.hashFinish(llllllllllllIlllllIlIlllIIIIIlll);
    }
    
    public final void set(final double llllllllllllIlllllIlIlllIlllIIlI, final double llllllllllllIlllllIlIlllIlllIIIl) {
        this.x = llllllllllllIlllllIlIlllIlllIIlI;
        this.y = llllllllllllIlllllIlIlllIlllIIIl;
    }
    
    public final void add(final Tuple2d llllllllllllIlllllIlIlllIlIlIIIl, final Tuple2d llllllllllllIlllllIlIlllIlIIllIl) {
        this.x = llllllllllllIlllllIlIlllIlIlIIIl.x + llllllllllllIlllllIlIlllIlIIllIl.x;
        this.y = llllllllllllIlllllIlIlllIlIlIIIl.y + llllllllllllIlllllIlIlllIlIIllIl.y;
    }
    
    public final void clamp(final double llllllllllllIlllllIlIllIlIlllIIl, final double llllllllllllIlllllIlIllIlIlllIII) {
        if (this.x > llllllllllllIlllllIlIllIlIlllIII) {
            this.x = llllllllllllIlllllIlIllIlIlllIII;
        }
        else if (this.x < llllllllllllIlllllIlIllIlIlllIIl) {
            this.x = llllllllllllIlllllIlIllIlIlllIIl;
        }
        if (this.y > llllllllllllIlllllIlIllIlIlllIII) {
            this.y = llllllllllllIlllllIlIllIlIlllIII;
        }
        else if (this.y < llllllllllllIlllllIlIllIlIlllIIl) {
            this.y = llllllllllllIlllllIlIllIlIlllIIl;
        }
    }
    
    public final void clamp(final double llllllllllllIlllllIlIllIllIllIII, final double llllllllllllIlllllIlIllIllIllIll, final Tuple2d llllllllllllIlllllIlIllIllIlIllI) {
        if (llllllllllllIlllllIlIllIllIlIllI.x > llllllllllllIlllllIlIllIllIllIll) {
            this.x = llllllllllllIlllllIlIllIllIllIll;
        }
        else if (llllllllllllIlllllIlIllIllIlIllI.x < llllllllllllIlllllIlIllIllIllIII) {
            this.x = llllllllllllIlllllIlIllIllIllIII;
        }
        else {
            this.x = llllllllllllIlllllIlIllIllIlIllI.x;
        }
        if (llllllllllllIlllllIlIllIllIlIllI.y > llllllllllllIlllllIlIllIllIllIll) {
            this.y = llllllllllllIlllllIlIllIllIllIll;
        }
        else if (llllllllllllIlllllIlIllIllIlIllI.y < llllllllllllIlllllIlIllIllIllIII) {
            this.y = llllllllllllIlllllIlIllIllIllIII;
        }
        else {
            this.y = llllllllllllIlllllIlIllIllIlIllI.y;
        }
    }
    
    public final void sub(final Tuple2d llllllllllllIlllllIlIlllIlIIIIlI, final Tuple2d llllllllllllIlllllIlIlllIIlllllI) {
        this.x = llllllllllllIlllllIlIlllIlIIIIlI.x - llllllllllllIlllllIlIlllIIlllllI.x;
        this.y = llllllllllllIlllllIlIlllIlIIIIlI.y - llllllllllllIlllllIlIlllIIlllllI.y;
    }
    
    public final void scale(final double llllllllllllIlllllIlIlllIIlIIIlI) {
        this.x *= llllllllllllIlllllIlIlllIIlIIIlI;
        this.y *= llllllllllllIlllllIlIlllIIlIIIlI;
    }
    
    public final void scaleAdd(final double llllllllllllIlllllIlIlllIIIllIlI, final Tuple2d llllllllllllIlllllIlIlllIIIllIIl, final Tuple2d llllllllllllIlllllIlIlllIIIlIlII) {
        this.x = llllllllllllIlllllIlIlllIIIllIlI * llllllllllllIlllllIlIlllIIIllIIl.x + llllllllllllIlllllIlIlllIIIlIlII.x;
        this.y = llllllllllllIlllllIlIlllIIIllIlI * llllllllllllIlllllIlIlllIIIllIIl.y + llllllllllllIlllllIlIlllIIIlIlII.y;
    }
    
    public boolean epsilonEquals(final Tuple2d llllllllllllIlllllIlIllIlllIlIll, final double llllllllllllIlllllIlIllIlllIlIlI) {
        double llllllllllllIlllllIlIllIlllIlIIl = this.x - llllllllllllIlllllIlIllIlllIlIll.x;
        if (Double.isNaN(llllllllllllIlllllIlIllIlllIlIIl)) {
            return false;
        }
        if (((llllllllllllIlllllIlIllIlllIlIIl < 0.0) ? (-llllllllllllIlllllIlIllIlllIlIIl) : llllllllllllIlllllIlIllIlllIlIIl) > llllllllllllIlllllIlIllIlllIlIlI) {
            return false;
        }
        llllllllllllIlllllIlIllIlllIlIIl = this.y - llllllllllllIlllllIlIllIlllIlIll.y;
        return !Double.isNaN(llllllllllllIlllllIlIllIlllIlIIl) && ((llllllllllllIlllllIlIllIlllIlIIl < 0.0) ? (-llllllllllllIlllllIlIllIlllIlIIl) : llllllllllllIlllllIlIllIlllIlIIl) <= llllllllllllIlllllIlIllIlllIlIlI;
    }
    
    public final void get(final double[] llllllllllllIlllllIlIlllIlIllIII) {
        llllllllllllIlllllIlIlllIlIllIII[0] = this.x;
        llllllllllllIlllllIlIlllIlIllIII[1] = this.y;
    }
    
    public Object clone() {
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException llllllllllllIlllllIlIllIlIIIllIl) {
            throw new InternalError();
        }
    }
    
    public final void absolute() {
        this.x = Math.abs(this.x);
        this.y = Math.abs(this.y);
    }
    
    public final void clampMin(final double llllllllllllIlllllIlIllIllIlIIIl, final Tuple2d llllllllllllIlllllIlIllIllIIllIl) {
        if (llllllllllllIlllllIlIllIllIIllIl.x < llllllllllllIlllllIlIllIllIlIIIl) {
            this.x = llllllllllllIlllllIlIllIllIlIIIl;
        }
        else {
            this.x = llllllllllllIlllllIlIllIllIIllIl.x;
        }
        if (llllllllllllIlllllIlIllIllIIllIl.y < llllllllllllIlllllIlIllIllIlIIIl) {
            this.y = llllllllllllIlllllIlIllIllIlIIIl;
        }
        else {
            this.y = llllllllllllIlllllIlIllIllIIllIl.y;
        }
    }
    
    @Override
    public boolean equals(final Object llllllllllllIlllllIlIllIllllIlll) {
        try {
            final Tuple2d llllllllllllIlllllIlIllIllllIllI = (Tuple2d)llllllllllllIlllllIlIllIllllIlll;
            return this.x == llllllllllllIlllllIlIllIllllIllI.x && this.y == llllllllllllIlllllIlIllIllllIllI.y;
        }
        catch (NullPointerException llllllllllllIlllllIlIllIllllIlIl) {
            return false;
        }
        catch (ClassCastException llllllllllllIlllllIlIllIllllIlII) {
            return false;
        }
    }
    
    public Tuple2d() {
        this.x = 0.0;
        this.y = 0.0;
    }
    
    public Tuple2d(final Tuple2d llllllllllllIlllllIlIllllIIIIIlI) {
        this.x = llllllllllllIlllllIlIllllIIIIIlI.x;
        this.y = llllllllllllIlllllIlIllllIIIIIlI.y;
    }
    
    public final void set(final double[] llllllllllllIlllllIlIlllIllIlIII) {
        this.x = llllllllllllIlllllIlIlllIllIlIII[0];
        this.y = llllllllllllIlllllIlIlllIllIlIII[1];
    }
    
    public final void set(final Tuple2f llllllllllllIlllllIlIlllIlIllllI) {
        this.x = llllllllllllIlllllIlIlllIlIllllI.x;
        this.y = llllllllllllIlllllIlIlllIlIllllI.y;
    }
    
    public final void clampMin(final double llllllllllllIlllllIlIllIlIllIIIl) {
        if (this.x < llllllllllllIlllllIlIllIlIllIIIl) {
            this.x = llllllllllllIlllllIlIllIlIllIIIl;
        }
        if (this.y < llllllllllllIlllllIlIllIlIllIIIl) {
            this.y = llllllllllllIlllllIlIllIlIllIIIl;
        }
    }
    
    public final void setY(final double llllllllllllIlllllIlIllIIllllIIl) {
        this.y = llllllllllllIlllllIlIllIIllllIIl;
    }
    
    public final void clampMax(final double llllllllllllIlllllIlIllIllIIIlIl, final Tuple2d llllllllllllIlllllIlIllIllIIIlll) {
        if (llllllllllllIlllllIlIllIllIIIlll.x > llllllllllllIlllllIlIllIllIIIlIl) {
            this.x = llllllllllllIlllllIlIllIllIIIlIl;
        }
        else {
            this.x = llllllllllllIlllllIlIllIllIIIlll.x;
        }
        if (llllllllllllIlllllIlIllIllIIIlll.y > llllllllllllIlllllIlIllIllIIIlIl) {
            this.y = llllllllllllIlllllIlIllIllIIIlIl;
        }
        else {
            this.y = llllllllllllIlllllIlIllIllIIIlll.y;
        }
    }
    
    public final double getY() {
        return this.y;
    }
    
    public final void set(final Tuple2d llllllllllllIlllllIlIlllIllIIIlI) {
        this.x = llllllllllllIlllllIlIlllIllIIIlI.x;
        this.y = llllllllllllIlllllIlIlllIllIIIlI.y;
    }
    
    public final void absolute(final Tuple2d llllllllllllIlllllIlIllIllIIIIII) {
        this.x = Math.abs(llllllllllllIlllllIlIllIllIIIIII.x);
        this.y = Math.abs(llllllllllllIlllllIlIllIllIIIIII.y);
    }
    
    public boolean equals(final Tuple2d llllllllllllIlllllIlIllIllllllIl) {
        try {
            return this.x == llllllllllllIlllllIlIllIllllllIl.x && this.y == llllllllllllIlllllIlIllIllllllIl.y;
        }
        catch (NullPointerException llllllllllllIlllllIlIllIllllllll) {
            return false;
        }
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("(").append(this.x).append(", ").append(this.y).append(")"));
    }
    
    public final double getX() {
        return this.x;
    }
    
    public final void sub(final Tuple2d llllllllllllIlllllIlIlllIIlllIII) {
        this.x -= llllllllllllIlllllIlIlllIIlllIII.x;
        this.y -= llllllllllllIlllllIlIlllIIlllIII.y;
    }
    
    public final void setX(final double llllllllllllIlllllIlIllIlIIIIlII) {
        this.x = llllllllllllIlllllIlIllIlIIIIlII;
    }
    
    public final void interpolate(final Tuple2d llllllllllllIlllllIlIllIlIIlIlIl, final double llllllllllllIlllllIlIllIlIIlIIIl) {
        this.x = (1.0 - llllllllllllIlllllIlIllIlIIlIIIl) * this.x + llllllllllllIlllllIlIllIlIIlIIIl * llllllllllllIlllllIlIllIlIIlIlIl.x;
        this.y = (1.0 - llllllllllllIlllllIlIllIlIIlIIIl) * this.y + llllllllllllIlllllIlIllIlIIlIIIl * llllllllllllIlllllIlIllIlIIlIlIl.y;
    }
    
    public final void clampMax(final double llllllllllllIlllllIlIllIlIlIlIll) {
        if (this.x > llllllllllllIlllllIlIllIlIlIlIll) {
            this.x = llllllllllllIlllllIlIllIlIlIlIll;
        }
        if (this.y > llllllllllllIlllllIlIllIlIlIlIll) {
            this.y = llllllllllllIlllllIlIllIlIlIlIll;
        }
    }
    
    public final void negate(final Tuple2d llllllllllllIlllllIlIlllIIllIIlI) {
        this.x = -llllllllllllIlllllIlIlllIIllIIlI.x;
        this.y = -llllllllllllIlllllIlIlllIIllIIlI.y;
    }
    
    public final void add(final Tuple2d llllllllllllIlllllIlIlllIlIIIlll) {
        this.x += llllllllllllIlllllIlIlllIlIIIlll.x;
        this.y += llllllllllllIlllllIlIlllIlIIIlll.y;
    }
}
