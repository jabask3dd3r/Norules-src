package javax.vecmath;

import java.io.*;

public abstract class Tuple4d implements Cloneable, Serializable
{
    public /* synthetic */ double y;
    public /* synthetic */ double x;
    public /* synthetic */ double w;
    public /* synthetic */ double z;
    
    public final void setX(final double llllllllllllllllIIlIIIIlllIllllI) {
        this.x = llllllllllllllllIIlIIIIlllIllllI;
    }
    
    public Tuple4d(final double[] llllllllllllllllIIlIIIllIIllllll) {
        this.x = llllllllllllllllIIlIIIllIIllllll[0];
        this.y = llllllllllllllllIIlIIIllIIllllll[1];
        this.z = llllllllllllllllIIlIIIllIIllllll[2];
        this.w = llllllllllllllllIIlIIIllIIllllll[3];
    }
    
    @Deprecated
    public void interpolate(final Tuple4d llllllllllllllllIIlIIIIlllllIlll, final float llllllllllllllllIIlIIIIlllllIllI) {
        this.interpolate(llllllllllllllllIIlIIIIlllllIlll, (double)llllllllllllllllIIlIIIIlllllIllI);
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("(").append(this.x).append(", ").append(this.y).append(", ").append(this.z).append(", ").append(this.w).append(")"));
    }
    
    public final void clampMax(final double llllllllllllllllIIlIIIlIIlIIlllI, final Tuple4d llllllllllllllllIIlIIIlIIlIIlIlI) {
        if (llllllllllllllllIIlIIIlIIlIIlIlI.x > llllllllllllllllIIlIIIlIIlIIlllI) {
            this.x = llllllllllllllllIIlIIIlIIlIIlllI;
        }
        else {
            this.x = llllllllllllllllIIlIIIlIIlIIlIlI.x;
        }
        if (llllllllllllllllIIlIIIlIIlIIlIlI.y > llllllllllllllllIIlIIIlIIlIIlllI) {
            this.y = llllllllllllllllIIlIIIlIIlIIlllI;
        }
        else {
            this.y = llllllllllllllllIIlIIIlIIlIIlIlI.y;
        }
        if (llllllllllllllllIIlIIIlIIlIIlIlI.z > llllllllllllllllIIlIIIlIIlIIlllI) {
            this.z = llllllllllllllllIIlIIIlIIlIIlllI;
        }
        else {
            this.z = llllllllllllllllIIlIIIlIIlIIlIlI.z;
        }
        if (llllllllllllllllIIlIIIlIIlIIlIlI.w > llllllllllllllllIIlIIIlIIlIIlllI) {
            this.w = llllllllllllllllIIlIIIlIIlIIlllI;
        }
        else {
            this.w = llllllllllllllllIIlIIIlIIlIIlIlI.z;
        }
    }
    
    @Deprecated
    public void interpolate(final Tuple4d llllllllllllllllIIlIIIlIIIIlIIIl, final Tuple4d llllllllllllllllIIlIIIlIIIIlIIII, final float llllllllllllllllIIlIIIlIIIIIlIll) {
        this.interpolate(llllllllllllllllIIlIIIlIIIIlIIIl, llllllllllllllllIIlIIIlIIIIlIIII, (double)llllllllllllllllIIlIIIlIIIIIlIll);
    }
    
    public boolean epsilonEquals(final Tuple4d llllllllllllllllIIlIIIlIlIIIlllI, final double llllllllllllllllIIlIIIlIlIIIllIl) {
        double llllllllllllllllIIlIIIlIlIIlIIII = this.x - llllllllllllllllIIlIIIlIlIIIlllI.x;
        if (Double.isNaN(llllllllllllllllIIlIIIlIlIIlIIII)) {
            return false;
        }
        if (((llllllllllllllllIIlIIIlIlIIlIIII < 0.0) ? (-llllllllllllllllIIlIIIlIlIIlIIII) : llllllllllllllllIIlIIIlIlIIlIIII) > llllllllllllllllIIlIIIlIlIIIllIl) {
            return false;
        }
        llllllllllllllllIIlIIIlIlIIlIIII = this.y - llllllllllllllllIIlIIIlIlIIIlllI.y;
        if (Double.isNaN(llllllllllllllllIIlIIIlIlIIlIIII)) {
            return false;
        }
        if (((llllllllllllllllIIlIIIlIlIIlIIII < 0.0) ? (-llllllllllllllllIIlIIIlIlIIlIIII) : llllllllllllllllIIlIIIlIlIIlIIII) > llllllllllllllllIIlIIIlIlIIIllIl) {
            return false;
        }
        llllllllllllllllIIlIIIlIlIIlIIII = this.z - llllllllllllllllIIlIIIlIlIIIlllI.z;
        if (Double.isNaN(llllllllllllllllIIlIIIlIlIIlIIII)) {
            return false;
        }
        if (((llllllllllllllllIIlIIIlIlIIlIIII < 0.0) ? (-llllllllllllllllIIlIIIlIlIIlIIII) : llllllllllllllllIIlIIIlIlIIlIIII) > llllllllllllllllIIlIIIlIlIIIllIl) {
            return false;
        }
        llllllllllllllllIIlIIIlIlIIlIIII = this.w - llllllllllllllllIIlIIIlIlIIIlllI.w;
        return !Double.isNaN(llllllllllllllllIIlIIIlIlIIlIIII) && ((llllllllllllllllIIlIIIlIlIIlIIII < 0.0) ? (-llllllllllllllllIIlIIIlIlIIlIIII) : llllllllllllllllIIlIIIlIlIIlIIII) <= llllllllllllllllIIlIIIlIlIIIllIl;
    }
    
    public final void get(final Tuple4d llllllllllllllllIIlIIIllIIIIIlIl) {
        llllllllllllllllIIlIIIllIIIIIlIl.x = this.x;
        llllllllllllllllIIlIIIllIIIIIlIl.y = this.y;
        llllllllllllllllIIlIIIllIIIIIlIl.z = this.z;
        llllllllllllllllIIlIIIllIIIIIlIl.w = this.w;
    }
    
    public final double getW() {
        return this.w;
    }
    
    public final void clampMin(final double llllllllllllllllIIlIIIlIIlIlllIl, final Tuple4d llllllllllllllllIIlIIIlIIlIlllll) {
        if (llllllllllllllllIIlIIIlIIlIlllll.x < llllllllllllllllIIlIIIlIIlIlllIl) {
            this.x = llllllllllllllllIIlIIIlIIlIlllIl;
        }
        else {
            this.x = llllllllllllllllIIlIIIlIIlIlllll.x;
        }
        if (llllllllllllllllIIlIIIlIIlIlllll.y < llllllllllllllllIIlIIIlIIlIlllIl) {
            this.y = llllllllllllllllIIlIIIlIIlIlllIl;
        }
        else {
            this.y = llllllllllllllllIIlIIIlIIlIlllll.y;
        }
        if (llllllllllllllllIIlIIIlIIlIlllll.z < llllllllllllllllIIlIIIlIIlIlllIl) {
            this.z = llllllllllllllllIIlIIIlIIlIlllIl;
        }
        else {
            this.z = llllllllllllllllIIlIIIlIIlIlllll.z;
        }
        if (llllllllllllllllIIlIIIlIIlIlllll.w < llllllllllllllllIIlIIIlIIlIlllIl) {
            this.w = llllllllllllllllIIlIIIlIIlIlllIl;
        }
        else {
            this.w = llllllllllllllllIIlIIIlIIlIlllll.w;
        }
    }
    
    public final void scale(final double llllllllllllllllIIlIIIlIllIIllIl) {
        this.x *= llllllllllllllllIIlIIIlIllIIllIl;
        this.y *= llllllllllllllllIIlIIIlIllIIllIl;
        this.z *= llllllllllllllllIIlIIIlIllIIllIl;
        this.w *= llllllllllllllllIIlIIIlIllIIllIl;
    }
    
    @Deprecated
    public final void scaleAdd(final float llllllllllllllllIIlIIIlIlIllllII, final Tuple4d llllllllllllllllIIlIIIlIlIlllIll) {
        this.scaleAdd((double)llllllllllllllllIIlIIIlIlIllllII, llllllllllllllllIIlIIIlIlIlllIll);
    }
    
    public Object clone() {
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException llllllllllllllllIIlIIIIllllIlIIl) {
            throw new InternalError();
        }
    }
    
    public Tuple4d() {
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
        this.w = 0.0;
    }
    
    @Deprecated
    public final void clampMin(final float llllllllllllllllIIlIIIlIIIlIlllI) {
        this.clampMin((double)llllllllllllllllIIlIIIlIIIlIlllI);
    }
    
    @Deprecated
    public final void clampMax(final float llllllllllllllllIIlIIIlIIIlIIIlI) {
        this.clampMax((double)llllllllllllllllIIlIIIlIIIlIIIlI);
    }
    
    @Deprecated
    public final void clampMax(final float llllllllllllllllIIlIIIlIIlIlIlII, final Tuple4d llllllllllllllllIIlIIIlIIlIlIIll) {
        this.clampMax((double)llllllllllllllllIIlIIIlIIlIlIlII, llllllllllllllllIIlIIIlIIlIlIIll);
    }
    
    @Deprecated
    public final void clamp(final float llllllllllllllllIIlIIIlIIIllllll, final float llllllllllllllllIIlIIIlIIIlllIll) {
        this.clamp(llllllllllllllllIIlIIIlIIIllllll, (double)llllllllllllllllIIlIIIlIIIlllIll);
    }
    
    public final void set(final double llllllllllllllllIIlIIIllIIlIIlII, final double llllllllllllllllIIlIIIllIIlIlIII, final double llllllllllllllllIIlIIIllIIlIIlll, final double llllllllllllllllIIlIIIllIIlIIIIl) {
        this.x = llllllllllllllllIIlIIIllIIlIIlII;
        this.y = llllllllllllllllIIlIIIllIIlIlIII;
        this.z = llllllllllllllllIIlIIIllIIlIIlll;
        this.w = llllllllllllllllIIlIIIllIIlIIIIl;
    }
    
    public final void clampMax(final double llllllllllllllllIIlIIIlIIIIlllII) {
        if (this.x > llllllllllllllllIIlIIIlIIIIlllII) {
            this.x = llllllllllllllllIIlIIIlIIIIlllII;
        }
        if (this.y > llllllllllllllllIIlIIIlIIIIlllII) {
            this.y = llllllllllllllllIIlIIIlIIIIlllII;
        }
        if (this.z > llllllllllllllllIIlIIIlIIIIlllII) {
            this.z = llllllllllllllllIIlIIIlIIIIlllII;
        }
        if (this.w > llllllllllllllllIIlIIIlIIIIlllII) {
            this.w = llllllllllllllllIIlIIIlIIIIlllII;
        }
    }
    
    public final void set(final double[] llllllllllllllllIIlIIIllIIIllIll) {
        this.x = llllllllllllllllIIlIIIllIIIllIll[0];
        this.y = llllllllllllllllIIlIIIllIIIllIll[1];
        this.z = llllllllllllllllIIlIIIllIIIllIll[2];
        this.w = llllllllllllllllIIlIIIllIIIllIll[3];
    }
    
    public boolean equals(final Tuple4d llllllllllllllllIIlIIIlIlIlIIlll) {
        try {
            return this.x == llllllllllllllllIIlIIIlIlIlIIlll.x && this.y == llllllllllllllllIIlIIIlIlIlIIlll.y && this.z == llllllllllllllllIIlIIIlIlIlIIlll.z && this.w == llllllllllllllllIIlIIIlIlIlIIlll.w;
        }
        catch (NullPointerException llllllllllllllllIIlIIIlIlIlIIllI) {
            return false;
        }
    }
    
    public final void absolute(final Tuple4d llllllllllllllllIIlIIIlIIlIIIlII) {
        this.x = Math.abs(llllllllllllllllIIlIIIlIIlIIIlII.x);
        this.y = Math.abs(llllllllllllllllIIlIIIlIIlIIIlII.y);
        this.z = Math.abs(llllllllllllllllIIlIIIlIIlIIIlII.z);
        this.w = Math.abs(llllllllllllllllIIlIIIlIIlIIIlII.w);
    }
    
    public final double getX() {
        return this.x;
    }
    
    public final void setY(final double llllllllllllllllIIlIIIIlllIlIlIl) {
        this.y = llllllllllllllllIIlIIIIlllIlIlIl;
    }
    
    public final void scale(final double llllllllllllllllIIlIIIlIllIlIlII, final Tuple4d llllllllllllllllIIlIIIlIllIlIllI) {
        this.x = llllllllllllllllIIlIIIlIllIlIlII * llllllllllllllllIIlIIIlIllIlIllI.x;
        this.y = llllllllllllllllIIlIIIlIllIlIlII * llllllllllllllllIIlIIIlIllIlIllI.y;
        this.z = llllllllllllllllIIlIIIlIllIlIlII * llllllllllllllllIIlIIIlIllIlIllI.z;
        this.w = llllllllllllllllIIlIIIlIllIlIlII * llllllllllllllllIIlIIIlIllIlIllI.w;
    }
    
    public final void setZ(final double llllllllllllllllIIlIIIIlllIIlllI) {
        this.z = llllllllllllllllIIlIIIIlllIIlllI;
    }
    
    public final void sub(final Tuple4d llllllllllllllllIIlIIIlIlllIIlIl) {
        this.x -= llllllllllllllllIIlIIIlIlllIIlIl.x;
        this.y -= llllllllllllllllIIlIIIlIlllIIlIl.y;
        this.z -= llllllllllllllllIIlIIIlIlllIIlIl.z;
        this.w -= llllllllllllllllIIlIIIlIlllIIlIl.w;
    }
    
    @Override
    public boolean equals(final Object llllllllllllllllIIlIIIlIlIIllllI) {
        try {
            final Tuple4d llllllllllllllllIIlIIIlIlIIlllIl = (Tuple4d)llllllllllllllllIIlIIIlIlIIllllI;
            return this.x == llllllllllllllllIIlIIIlIlIIlllIl.x && this.y == llllllllllllllllIIlIIIlIlIIlllIl.y && this.z == llllllllllllllllIIlIIIlIlIIlllIl.z && this.w == llllllllllllllllIIlIIIlIlIIlllIl.w;
        }
        catch (NullPointerException llllllllllllllllIIlIIIlIlIIlllII) {
            return false;
        }
        catch (ClassCastException llllllllllllllllIIlIIIlIlIIllIll) {
            return false;
        }
    }
    
    public final void scaleAdd(final double llllllllllllllllIIlIIIlIllIIIlll, final Tuple4d llllllllllllllllIIlIIIlIllIIIllI, final Tuple4d llllllllllllllllIIlIIIlIllIIIIIl) {
        this.x = llllllllllllllllIIlIIIlIllIIIlll * llllllllllllllllIIlIIIlIllIIIllI.x + llllllllllllllllIIlIIIlIllIIIIIl.x;
        this.y = llllllllllllllllIIlIIIlIllIIIlll * llllllllllllllllIIlIIIlIllIIIllI.y + llllllllllllllllIIlIIIlIllIIIIIl.y;
        this.z = llllllllllllllllIIlIIIlIllIIIlll * llllllllllllllllIIlIIIlIllIIIllI.z + llllllllllllllllIIlIIIlIllIIIIIl.z;
        this.w = llllllllllllllllIIlIIIlIllIIIlll * llllllllllllllllIIlIIIlIllIIIllI.w + llllllllllllllllIIlIIIlIllIIIIIl.w;
    }
    
    public final void get(final double[] llllllllllllllllIIlIIIllIIIIlIll) {
        llllllllllllllllIIlIIIllIIIIlIll[0] = this.x;
        llllllllllllllllIIlIIIllIIIIlIll[1] = this.y;
        llllllllllllllllIIlIIIllIIIIlIll[2] = this.z;
        llllllllllllllllIIlIIIllIIIIlIll[3] = this.w;
    }
    
    public final void clampMin(final double llllllllllllllllIIlIIIlIIIlIIllI) {
        if (this.x < llllllllllllllllIIlIIIlIIIlIIllI) {
            this.x = llllllllllllllllIIlIIIlIIIlIIllI;
        }
        if (this.y < llllllllllllllllIIlIIIlIIIlIIllI) {
            this.y = llllllllllllllllIIlIIIlIIIlIIllI;
        }
        if (this.z < llllllllllllllllIIlIIIlIIIlIIllI) {
            this.z = llllllllllllllllIIlIIIlIIIlIIllI;
        }
        if (this.w < llllllllllllllllIIlIIIlIIIlIIllI) {
            this.w = llllllllllllllllIIlIIIlIIIlIIllI;
        }
    }
    
    public final void absolute() {
        this.x = Math.abs(this.x);
        this.y = Math.abs(this.y);
        this.z = Math.abs(this.z);
        this.w = Math.abs(this.w);
    }
    
    public final void negate(final Tuple4d llllllllllllllllIIlIIIlIlllIIIIl) {
        this.x = -llllllllllllllllIIlIIIlIlllIIIIl.x;
        this.y = -llllllllllllllllIIlIIIlIlllIIIIl.y;
        this.z = -llllllllllllllllIIlIIIlIlllIIIIl.z;
        this.w = -llllllllllllllllIIlIIIlIlllIIIIl.w;
    }
    
    public final void add(final Tuple4d llllllllllllllllIIlIIIlIlllllIll, final Tuple4d llllllllllllllllIIlIIIlIlllllIlI) {
        this.x = llllllllllllllllIIlIIIlIlllllIll.x + llllllllllllllllIIlIIIlIlllllIlI.x;
        this.y = llllllllllllllllIIlIIIlIlllllIll.y + llllllllllllllllIIlIIIlIlllllIlI.y;
        this.z = llllllllllllllllIIlIIIlIlllllIll.z + llllllllllllllllIIlIIIlIlllllIlI.z;
        this.w = llllllllllllllllIIlIIIlIlllllIll.w + llllllllllllllllIIlIIIlIlllllIlI.w;
    }
    
    public final double getZ() {
        return this.z;
    }
    
    public Tuple4d(final double llllllllllllllllIIlIIIllIlIIlIII, final double llllllllllllllllIIlIIIllIlIIllII, final double llllllllllllllllIIlIIIllIlIIIllI, final double llllllllllllllllIIlIIIllIlIIIlIl) {
        this.x = llllllllllllllllIIlIIIllIlIIlIII;
        this.y = llllllllllllllllIIlIIIllIlIIllII;
        this.z = llllllllllllllllIIlIIIllIlIIIllI;
        this.w = llllllllllllllllIIlIIIllIlIIIlIl;
    }
    
    public final void scaleAdd(final double llllllllllllllllIIlIIIlIlIllIIll, final Tuple4d llllllllllllllllIIlIIIlIlIllIIlI) {
        this.x = llllllllllllllllIIlIIIlIlIllIIll * this.x + llllllllllllllllIIlIIIlIlIllIIlI.x;
        this.y = llllllllllllllllIIlIIIlIlIllIIll * this.y + llllllllllllllllIIlIIIlIlIllIIlI.y;
        this.z = llllllllllllllllIIlIIIlIlIllIIll * this.z + llllllllllllllllIIlIIIlIlIllIIlI.z;
        this.w = llllllllllllllllIIlIIIlIlIllIIll * this.w + llllllllllllllllIIlIIIlIlIllIIlI.w;
    }
    
    public Tuple4d(final Tuple4f llllllllllllllllIIlIIIllIIllIlIl) {
        this.x = llllllllllllllllIIlIIIllIIllIlIl.x;
        this.y = llllllllllllllllIIlIIIllIIllIlIl.y;
        this.z = llllllllllllllllIIlIIIllIIllIlIl.z;
        this.w = llllllllllllllllIIlIIIllIIllIlIl.w;
    }
    
    public final void set(final Tuple4d llllllllllllllllIIlIIIllIIIlIlIl) {
        this.x = llllllllllllllllIIlIIIllIIIlIlIl.x;
        this.y = llllllllllllllllIIlIIIllIIIlIlIl.y;
        this.z = llllllllllllllllIIlIIIllIIIlIlIl.z;
        this.w = llllllllllllllllIIlIIIllIIIlIlIl.w;
    }
    
    public final double getY() {
        return this.y;
    }
    
    public Tuple4d(final Tuple4d llllllllllllllllIIlIIIllIIlllIIl) {
        this.x = llllllllllllllllIIlIIIllIIlllIIl.x;
        this.y = llllllllllllllllIIlIIIllIIlllIIl.y;
        this.z = llllllllllllllllIIlIIIllIIlllIIl.z;
        this.w = llllllllllllllllIIlIIIllIIlllIIl.w;
    }
    
    @Deprecated
    public final void clampMin(final float llllllllllllllllIIlIIIlIIllIIllI, final Tuple4d llllllllllllllllIIlIIIlIIllIIlIl) {
        this.clampMin((double)llllllllllllllllIIlIIIlIIllIIllI, llllllllllllllllIIlIIIlIIllIIlIl);
    }
    
    public final void clamp(final double llllllllllllllllIIlIIIlIIlllIIII, final double llllllllllllllllIIlIIIlIIlllIIll, final Tuple4d llllllllllllllllIIlIIIlIIllIlllI) {
        if (llllllllllllllllIIlIIIlIIllIlllI.x > llllllllllllllllIIlIIIlIIlllIIll) {
            this.x = llllllllllllllllIIlIIIlIIlllIIll;
        }
        else if (llllllllllllllllIIlIIIlIIllIlllI.x < llllllllllllllllIIlIIIlIIlllIIII) {
            this.x = llllllllllllllllIIlIIIlIIlllIIII;
        }
        else {
            this.x = llllllllllllllllIIlIIIlIIllIlllI.x;
        }
        if (llllllllllllllllIIlIIIlIIllIlllI.y > llllllllllllllllIIlIIIlIIlllIIll) {
            this.y = llllllllllllllllIIlIIIlIIlllIIll;
        }
        else if (llllllllllllllllIIlIIIlIIllIlllI.y < llllllllllllllllIIlIIIlIIlllIIII) {
            this.y = llllllllllllllllIIlIIIlIIlllIIII;
        }
        else {
            this.y = llllllllllllllllIIlIIIlIIllIlllI.y;
        }
        if (llllllllllllllllIIlIIIlIIllIlllI.z > llllllllllllllllIIlIIIlIIlllIIll) {
            this.z = llllllllllllllllIIlIIIlIIlllIIll;
        }
        else if (llllllllllllllllIIlIIIlIIllIlllI.z < llllllllllllllllIIlIIIlIIlllIIII) {
            this.z = llllllllllllllllIIlIIIlIIlllIIII;
        }
        else {
            this.z = llllllllllllllllIIlIIIlIIllIlllI.z;
        }
        if (llllllllllllllllIIlIIIlIIllIlllI.w > llllllllllllllllIIlIIIlIIlllIIll) {
            this.w = llllllllllllllllIIlIIIlIIlllIIll;
        }
        else if (llllllllllllllllIIlIIIlIIllIlllI.w < llllllllllllllllIIlIIIlIIlllIIII) {
            this.w = llllllllllllllllIIlIIIlIIlllIIII;
        }
        else {
            this.w = llllllllllllllllIIlIIIlIIllIlllI.w;
        }
    }
    
    public void interpolate(final Tuple4d llllllllllllllllIIlIIIlIIIIIIIIl, final Tuple4d llllllllllllllllIIlIIIlIIIIIIlII, final double llllllllllllllllIIlIIIlIIIIIIIll) {
        this.x = (1.0 - llllllllllllllllIIlIIIlIIIIIIIll) * llllllllllllllllIIlIIIlIIIIIIIIl.x + llllllllllllllllIIlIIIlIIIIIIIll * llllllllllllllllIIlIIIlIIIIIIlII.x;
        this.y = (1.0 - llllllllllllllllIIlIIIlIIIIIIIll) * llllllllllllllllIIlIIIlIIIIIIIIl.y + llllllllllllllllIIlIIIlIIIIIIIll * llllllllllllllllIIlIIIlIIIIIIlII.y;
        this.z = (1.0 - llllllllllllllllIIlIIIlIIIIIIIll) * llllllllllllllllIIlIIIlIIIIIIIIl.z + llllllllllllllllIIlIIIlIIIIIIIll * llllllllllllllllIIlIIIlIIIIIIlII.z;
        this.w = (1.0 - llllllllllllllllIIlIIIlIIIIIIIll) * llllllllllllllllIIlIIIlIIIIIIIIl.w + llllllllllllllllIIlIIIlIIIIIIIll * llllllllllllllllIIlIIIlIIIIIIlII.w;
    }
    
    public final void clamp(final double llllllllllllllllIIlIIIlIIIllIllI, final double llllllllllllllllIIlIIIlIIIllIIlI) {
        if (this.x > llllllllllllllllIIlIIIlIIIllIIlI) {
            this.x = llllllllllllllllIIlIIIlIIIllIIlI;
        }
        else if (this.x < llllllllllllllllIIlIIIlIIIllIllI) {
            this.x = llllllllllllllllIIlIIIlIIIllIllI;
        }
        if (this.y > llllllllllllllllIIlIIIlIIIllIIlI) {
            this.y = llllllllllllllllIIlIIIlIIIllIIlI;
        }
        else if (this.y < llllllllllllllllIIlIIIlIIIllIllI) {
            this.y = llllllllllllllllIIlIIIlIIIllIllI;
        }
        if (this.z > llllllllllllllllIIlIIIlIIIllIIlI) {
            this.z = llllllllllllllllIIlIIIlIIIllIIlI;
        }
        else if (this.z < llllllllllllllllIIlIIIlIIIllIllI) {
            this.z = llllllllllllllllIIlIIIlIIIllIllI;
        }
        if (this.w > llllllllllllllllIIlIIIlIIIllIIlI) {
            this.w = llllllllllllllllIIlIIIlIIIllIIlI;
        }
        else if (this.w < llllllllllllllllIIlIIIlIIIllIllI) {
            this.w = llllllllllllllllIIlIIIlIIIllIllI;
        }
    }
    
    public final void set(final Tuple4f llllllllllllllllIIlIIIllIIIlIIIl) {
        this.x = llllllllllllllllIIlIIIllIIIlIIIl.x;
        this.y = llllllllllllllllIIlIIIllIIIlIIIl.y;
        this.z = llllllllllllllllIIlIIIllIIIlIIIl.z;
        this.w = llllllllllllllllIIlIIIllIIIlIIIl.w;
    }
    
    public final void sub(final Tuple4d llllllllllllllllIIlIIIlIlllIllII, final Tuple4d llllllllllllllllIIlIIIlIlllIlllI) {
        this.x = llllllllllllllllIIlIIIlIlllIllII.x - llllllllllllllllIIlIIIlIlllIlllI.x;
        this.y = llllllllllllllllIIlIIIlIlllIllII.y - llllllllllllllllIIlIIIlIlllIlllI.y;
        this.z = llllllllllllllllIIlIIIlIlllIllII.z - llllllllllllllllIIlIIIlIlllIlllI.z;
        this.w = llllllllllllllllIIlIIIlIlllIllII.w - llllllllllllllllIIlIIIlIlllIlllI.w;
    }
    
    public final void negate() {
        this.x = -this.x;
        this.y = -this.y;
        this.z = -this.z;
        this.w = -this.w;
    }
    
    @Deprecated
    public final void clamp(final float llllllllllllllllIIlIIIlIlIIIIIII, final float llllllllllllllllIIlIIIlIIllllIll, final Tuple4d llllllllllllllllIIlIIIlIIllllIlI) {
        this.clamp(llllllllllllllllIIlIIIlIlIIIIIII, (double)llllllllllllllllIIlIIIlIIllllIll, llllllllllllllllIIlIIIlIIllllIlI);
    }
    
    @Override
    public int hashCode() {
        long llllllllllllllllIIlIIIlIlIIIlIII = 1L;
        llllllllllllllllIIlIIIlIlIIIlIII = VecMathUtil.hashDoubleBits(llllllllllllllllIIlIIIlIlIIIlIII, this.x);
        llllllllllllllllIIlIIIlIlIIIlIII = VecMathUtil.hashDoubleBits(llllllllllllllllIIlIIIlIlIIIlIII, this.y);
        llllllllllllllllIIlIIIlIlIIIlIII = VecMathUtil.hashDoubleBits(llllllllllllllllIIlIIIlIlIIIlIII, this.z);
        llllllllllllllllIIlIIIlIlIIIlIII = VecMathUtil.hashDoubleBits(llllllllllllllllIIlIIIlIlIIIlIII, this.w);
        return VecMathUtil.hashFinish(llllllllllllllllIIlIIIlIlIIIlIII);
    }
    
    public final void setW(final double llllllllllllllllIIlIIIIlllIIIlIl) {
        this.w = llllllllllllllllIIlIIIIlllIIIlIl;
    }
    
    public void interpolate(final Tuple4d llllllllllllllllIIlIIIIllllIlllI, final double llllllllllllllllIIlIIIIlllllIIII) {
        this.x = (1.0 - llllllllllllllllIIlIIIIlllllIIII) * this.x + llllllllllllllllIIlIIIIlllllIIII * llllllllllllllllIIlIIIIllllIlllI.x;
        this.y = (1.0 - llllllllllllllllIIlIIIIlllllIIII) * this.y + llllllllllllllllIIlIIIIlllllIIII * llllllllllllllllIIlIIIIllllIlllI.y;
        this.z = (1.0 - llllllllllllllllIIlIIIIlllllIIII) * this.z + llllllllllllllllIIlIIIIlllllIIII * llllllllllllllllIIlIIIIllllIlllI.z;
        this.w = (1.0 - llllllllllllllllIIlIIIIlllllIIII) * this.w + llllllllllllllllIIlIIIIlllllIIII * llllllllllllllllIIlIIIIllllIlllI.w;
    }
    
    public final void add(final Tuple4d llllllllllllllllIIlIIIlIllllIlII) {
        this.x += llllllllllllllllIIlIIIlIllllIlII.x;
        this.y += llllllllllllllllIIlIIIlIllllIlII.y;
        this.z += llllllllllllllllIIlIIIlIllllIlII.z;
        this.w += llllllllllllllllIIlIIIlIllllIlII.w;
    }
}
