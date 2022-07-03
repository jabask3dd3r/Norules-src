package javax.vecmath;

import java.io.*;

public class AxisAngle4f implements Cloneable, Serializable
{
    public /* synthetic */ float angle;
    public /* synthetic */ float z;
    public /* synthetic */ float x;
    public /* synthetic */ float y;
    
    public final void set(final Matrix3f llllllllllllllIIllllIIIIlIIlIIll) {
        this.x = llllllllllllllIIllllIIIIlIIlIIll.m21 - llllllllllllllIIllllIIIIlIIlIIll.m12;
        this.y = llllllllllllllIIllllIIIIlIIlIIll.m02 - llllllllllllllIIllllIIIIlIIlIIll.m20;
        this.z = llllllllllllllIIllllIIIIlIIlIIll.m10 - llllllllllllllIIllllIIIIlIIlIIll.m01;
        double llllllllllllllIIllllIIIIlIIlIIlI = this.x * this.x + this.y * this.y + this.z * this.z;
        if (llllllllllllllIIllllIIIIlIIlIIlI > 1.0E-6) {
            llllllllllllllIIllllIIIIlIIlIIlI = Math.sqrt(llllllllllllllIIllllIIIIlIIlIIlI);
            final double llllllllllllllIIllllIIIIlIIlIIIl = 0.5 * llllllllllllllIIllllIIIIlIIlIIlI;
            final double llllllllllllllIIllllIIIIlIIlIIII = 0.5 * (llllllllllllllIIllllIIIIlIIlIIll.m00 + llllllllllllllIIllllIIIIlIIlIIll.m11 + llllllllllllllIIllllIIIIlIIlIIll.m22 - 1.0);
            this.angle = (float)Math.atan2(llllllllllllllIIllllIIIIlIIlIIIl, llllllllllllllIIllllIIIIlIIlIIII);
            final double llllllllllllllIIllllIIIIlIIIllll = 1.0 / llllllllllllllIIllllIIIIlIIlIIlI;
            this.x *= (float)llllllllllllllIIllllIIIIlIIIllll;
            this.y *= (float)llllllllllllllIIllllIIIIlIIIllll;
            this.z *= (float)llllllllllllllIIllllIIIIlIIIllll;
        }
        else {
            this.x = 0.0f;
            this.y = 1.0f;
            this.z = 0.0f;
            this.angle = 0.0f;
        }
    }
    
    public final void setY(final float llllllllllllllIIllllIIIIIIlIllIl) {
        this.y = llllllllllllllIIllllIIIIIIlIllIl;
    }
    
    public final float getZ() {
        return this.z;
    }
    
    @Override
    public int hashCode() {
        long llllllllllllllIIllllIIIIIlIlIIII = 1L;
        llllllllllllllIIllllIIIIIlIlIIII = VecMathUtil.hashFloatBits(llllllllllllllIIllllIIIIIlIlIIII, this.x);
        llllllllllllllIIllllIIIIIlIlIIII = VecMathUtil.hashFloatBits(llllllllllllllIIllllIIIIIlIlIIII, this.y);
        llllllllllllllIIllllIIIIIlIlIIII = VecMathUtil.hashFloatBits(llllllllllllllIIllllIIIIIlIlIIII, this.z);
        llllllllllllllIIllllIIIIIlIlIIII = VecMathUtil.hashFloatBits(llllllllllllllIIllllIIIIIlIlIIII, this.angle);
        return VecMathUtil.hashFinish(llllllllllllllIIllllIIIIIlIlIIII);
    }
    
    public AxisAngle4f(final float[] llllllllllllllIIllllIIIlIIlIIlll) {
        this.x = llllllllllllllIIllllIIIlIIlIIlll[0];
        this.y = llllllllllllllIIllllIIIlIIlIIlll[1];
        this.z = llllllllllllllIIllllIIIlIIlIIlll[2];
        this.angle = llllllllllllllIIllllIIIlIIlIIlll[3];
    }
    
    public final void set(final Matrix3d llllllllllllllIIllllIIIIIllllIll) {
        this.x = (float)(llllllllllllllIIllllIIIIIllllIll.m21 - llllllllllllllIIllllIIIIIllllIll.m12);
        this.y = (float)(llllllllllllllIIllllIIIIIllllIll.m02 - llllllllllllllIIllllIIIIIllllIll.m20);
        this.z = (float)(llllllllllllllIIllllIIIIIllllIll.m10 - llllllllllllllIIllllIIIIIllllIll.m01);
        double llllllllllllllIIllllIIIIlIIIIIII = this.x * this.x + this.y * this.y + this.z * this.z;
        if (llllllllllllllIIllllIIIIlIIIIIII > 1.0E-6) {
            llllllllllllllIIllllIIIIlIIIIIII = Math.sqrt(llllllllllllllIIllllIIIIlIIIIIII);
            final double llllllllllllllIIllllIIIIIlllllll = 0.5 * llllllllllllllIIllllIIIIlIIIIIII;
            final double llllllllllllllIIllllIIIIIllllllI = 0.5 * (llllllllllllllIIllllIIIIIllllIll.m00 + llllllllllllllIIllllIIIIIllllIll.m11 + llllllllllllllIIllllIIIIIllllIll.m22 - 1.0);
            this.angle = (float)Math.atan2(llllllllllllllIIllllIIIIIlllllll, llllllllllllllIIllllIIIIIllllllI);
            final double llllllllllllllIIllllIIIIIlllllIl = 1.0 / llllllllllllllIIllllIIIIlIIIIIII;
            this.x *= (float)llllllllllllllIIllllIIIIIlllllIl;
            this.y *= (float)llllllllllllllIIllllIIIIIlllllIl;
            this.z *= (float)llllllllllllllIIllllIIIIIlllllIl;
        }
        else {
            this.x = 0.0f;
            this.y = 1.0f;
            this.z = 0.0f;
            this.angle = 0.0f;
        }
    }
    
    public final void set(final Quat4d llllllllllllllIIllllIIIIllIIlIll) {
        double llllllllllllllIIllllIIIIllIIlIlI = llllllllllllllIIllllIIIIllIIlIll.x * llllllllllllllIIllllIIIIllIIlIll.x + llllllllllllllIIllllIIIIllIIlIll.y * llllllllllllllIIllllIIIIllIIlIll.y + llllllllllllllIIllllIIIIllIIlIll.z * llllllllllllllIIllllIIIIllIIlIll.z;
        if (llllllllllllllIIllllIIIIllIIlIlI > 1.0E-6) {
            llllllllllllllIIllllIIIIllIIlIlI = Math.sqrt(llllllllllllllIIllllIIIIllIIlIlI);
            final double llllllllllllllIIllllIIIIllIIlIIl = 1.0 / llllllllllllllIIllllIIIIllIIlIlI;
            this.x = (float)(llllllllllllllIIllllIIIIllIIlIll.x * llllllllllllllIIllllIIIIllIIlIIl);
            this.y = (float)(llllllllllllllIIllllIIIIllIIlIll.y * llllllllllllllIIllllIIIIllIIlIIl);
            this.z = (float)(llllllllllllllIIllllIIIIllIIlIll.z * llllllllllllllIIllllIIIIllIIlIIl);
            this.angle = (float)(2.0 * Math.atan2(llllllllllllllIIllllIIIIllIIlIlI, llllllllllllllIIllllIIIIllIIlIll.w));
        }
        else {
            this.x = 0.0f;
            this.y = 1.0f;
            this.z = 0.0f;
            this.angle = 0.0f;
        }
    }
    
    public final void set(final Vector3f llllllllllllllIIllllIIIIlllIIlII, final float llllllllllllllIIllllIIIIlllIIllI) {
        this.x = llllllllllllllIIllllIIIIlllIIlII.x;
        this.y = llllllllllllllIIllllIIIIlllIIlII.y;
        this.z = llllllllllllllIIllllIIIIlllIIlII.z;
        this.angle = llllllllllllllIIllllIIIIlllIIllI;
    }
    
    public boolean epsilonEquals(final AxisAngle4f llllllllllllllIIllllIIIIIlIllIlI, final float llllllllllllllIIllllIIIIIlIlIlIl) {
        float llllllllllllllIIllllIIIIIlIllIII = this.x - llllllllllllllIIllllIIIIIlIllIlI.x;
        if (((llllllllllllllIIllllIIIIIlIllIII < 0.0f) ? (-llllllllllllllIIllllIIIIIlIllIII) : llllllllllllllIIllllIIIIIlIllIII) > llllllllllllllIIllllIIIIIlIlIlIl) {
            return false;
        }
        llllllllllllllIIllllIIIIIlIllIII = this.y - llllllllllllllIIllllIIIIIlIllIlI.y;
        if (((llllllllllllllIIllllIIIIIlIllIII < 0.0f) ? (-llllllllllllllIIllllIIIIIlIllIII) : llllllllllllllIIllllIIIIIlIllIII) > llllllllllllllIIllllIIIIIlIlIlIl) {
            return false;
        }
        llllllllllllllIIllllIIIIIlIllIII = this.z - llllllllllllllIIllllIIIIIlIllIlI.z;
        if (((llllllllllllllIIllllIIIIIlIllIII < 0.0f) ? (-llllllllllllllIIllllIIIIIlIllIII) : llllllllllllllIIllllIIIIIlIllIII) > llllllllllllllIIllllIIIIIlIlIlIl) {
            return false;
        }
        llllllllllllllIIllllIIIIIlIllIII = this.angle - llllllllllllllIIllllIIIIIlIllIlI.angle;
        return ((llllllllllllllIIllllIIIIIlIllIII < 0.0f) ? (-llllllllllllllIIllllIIIIIlIllIII) : llllllllllllllIIllllIIIIIlIllIII) <= llllllllllllllIIllllIIIIIlIlIlIl;
    }
    
    public AxisAngle4f(final AxisAngle4d llllllllllllllIIllllIIIlIIIllIll) {
        this.x = (float)llllllllllllllIIllllIIIlIIIllIll.x;
        this.y = (float)llllllllllllllIIllllIIIlIIIllIll.y;
        this.z = (float)llllllllllllllIIllllIIIlIIIllIll.z;
        this.angle = (float)llllllllllllllIIllllIIIlIIIllIll.angle;
    }
    
    public final float getX() {
        return this.x;
    }
    
    public AxisAngle4f(final Vector3f llllllllllllllIIllllIIIlIIIlIIIl, final float llllllllllllllIIllllIIIlIIIlIIll) {
        this.x = llllllllllllllIIllllIIIlIIIlIIIl.x;
        this.y = llllllllllllllIIllllIIIlIIIlIIIl.y;
        this.z = llllllllllllllIIllllIIIlIIIlIIIl.z;
        this.angle = llllllllllllllIIllllIIIlIIIlIIll;
    }
    
    public AxisAngle4f(final float llllllllllllllIIllllIIIlIIllIIll, final float llllllllllllllIIllllIIIlIIlIllIl, final float llllllllllllllIIllllIIIlIIllIIIl, final float llllllllllllllIIllllIIIlIIllIIII) {
        this.x = llllllllllllllIIllllIIIlIIllIIll;
        this.y = llllllllllllllIIllllIIIlIIlIllIl;
        this.z = llllllllllllllIIllllIIIlIIllIIIl;
        this.angle = llllllllllllllIIllllIIIlIIllIIII;
    }
    
    public AxisAngle4f(final AxisAngle4f llllllllllllllIIllllIIIlIIlIIIIl) {
        this.x = llllllllllllllIIllllIIIlIIlIIIIl.x;
        this.y = llllllllllllllIIllllIIIlIIlIIIIl.y;
        this.z = llllllllllllllIIllllIIIlIIlIIIIl.z;
        this.angle = llllllllllllllIIllllIIIlIIlIIIIl.angle;
    }
    
    public final float getY() {
        return this.y;
    }
    
    public Object clone() {
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException llllllllllllllIIllllIIIIIlIIlIlI) {
            throw new InternalError();
        }
    }
    
    public final float getAngle() {
        return this.angle;
    }
    
    public final void set(final float llllllllllllllIIllllIIIlIIIIIIIl, final float llllllllllllllIIllllIIIlIIIIIIII, final float llllllllllllllIIllllIIIIllllllll, final float llllllllllllllIIllllIIIIlllllllI) {
        this.x = llllllllllllllIIllllIIIlIIIIIIIl;
        this.y = llllllllllllllIIllllIIIlIIIIIIII;
        this.z = llllllllllllllIIllllIIIIllllllll;
        this.angle = llllllllllllllIIllllIIIIlllllllI;
    }
    
    @Override
    public boolean equals(final Object llllllllllllllIIllllIIIIIllIIIIl) {
        try {
            final AxisAngle4f llllllllllllllIIllllIIIIIllIIlIl = (AxisAngle4f)llllllllllllllIIllllIIIIIllIIIIl;
            return this.x == llllllllllllllIIllllIIIIIllIIlIl.x && this.y == llllllllllllllIIllllIIIIIllIIlIl.y && this.z == llllllllllllllIIllllIIIIIllIIlIl.z && this.angle == llllllllllllllIIllllIIIIIllIIlIl.angle;
        }
        catch (NullPointerException llllllllllllllIIllllIIIIIllIIlII) {
            return false;
        }
        catch (ClassCastException llllllllllllllIIllllIIIIIllIIIll) {
            return false;
        }
    }
    
    public final void set(final AxisAngle4d llllllllllllllIIllllIIIIlllIlllI) {
        this.x = (float)llllllllllllllIIllllIIIIlllIlllI.x;
        this.y = (float)llllllllllllllIIllllIIIIlllIlllI.y;
        this.z = (float)llllllllllllllIIllllIIIIlllIlllI.z;
        this.angle = (float)llllllllllllllIIllllIIIIlllIlllI.angle;
    }
    
    public AxisAngle4f() {
        this.x = 0.0f;
        this.y = 0.0f;
        this.z = 1.0f;
        this.angle = 0.0f;
    }
    
    public final void setZ(final float llllllllllllllIIllllIIIIIIlIIllI) {
        this.z = llllllllllllllIIllllIIIIIIlIIllI;
    }
    
    public final void set(final Quat4f llllllllllllllIIllllIIIIllIlIlll) {
        double llllllllllllllIIllllIIIIllIlIllI = llllllllllllllIIllllIIIIllIlIlll.x * llllllllllllllIIllllIIIIllIlIlll.x + llllllllllllllIIllllIIIIllIlIlll.y * llllllllllllllIIllllIIIIllIlIlll.y + llllllllllllllIIllllIIIIllIlIlll.z * llllllllllllllIIllllIIIIllIlIlll.z;
        if (llllllllllllllIIllllIIIIllIlIllI > 1.0E-6) {
            llllllllllllllIIllllIIIIllIlIllI = Math.sqrt(llllllllllllllIIllllIIIIllIlIllI);
            final double llllllllllllllIIllllIIIIllIlIlIl = 1.0 / llllllllllllllIIllllIIIIllIlIllI;
            this.x = (float)(llllllllllllllIIllllIIIIllIlIlll.x * llllllllllllllIIllllIIIIllIlIlIl);
            this.y = (float)(llllllllllllllIIllllIIIIllIlIlll.y * llllllllllllllIIllllIIIIllIlIlIl);
            this.z = (float)(llllllllllllllIIllllIIIIllIlIlll.z * llllllllllllllIIllllIIIIllIlIlIl);
            this.angle = (float)(2.0 * Math.atan2(llllllllllllllIIllllIIIIllIlIllI, llllllllllllllIIllllIIIIllIlIlll.w));
        }
        else {
            this.x = 0.0f;
            this.y = 1.0f;
            this.z = 0.0f;
            this.angle = 0.0f;
        }
    }
    
    public final void set(final float[] llllllllllllllIIllllIIIIlllllIlI) {
        this.x = llllllllllllllIIllllIIIIlllllIlI[0];
        this.y = llllllllllllllIIllllIIIIlllllIlI[1];
        this.z = llllllllllllllIIllllIIIIlllllIlI[2];
        this.angle = llllllllllllllIIllllIIIIlllllIlI[3];
    }
    
    public boolean equals(final AxisAngle4f llllllllllllllIIllllIIIIIllIllll) {
        try {
            return this.x == llllllllllllllIIllllIIIIIllIllll.x && this.y == llllllllllllllIIllllIIIIIllIllll.y && this.z == llllllllllllllIIllllIIIIIllIllll.z && this.angle == llllllllllllllIIllllIIIIIllIllll.angle;
        }
        catch (NullPointerException llllllllllllllIIllllIIIIIllIlllI) {
            return false;
        }
    }
    
    public final void setX(final float llllllllllllllIIllllIIIIIIlllIII) {
        this.x = llllllllllllllIIllllIIIIIIlllIII;
    }
    
    public final void setAngle(final float llllllllllllllIIllllIIIIIIllllll) {
        this.angle = llllllllllllllIIllllIIIIIIllllll;
    }
    
    public final void set(final AxisAngle4f llllllllllllllIIllllIIIIllllIlII) {
        this.x = llllllllllllllIIllllIIIIllllIlII.x;
        this.y = llllllllllllllIIllllIIIIllllIlII.y;
        this.z = llllllllllllllIIllllIIIIllllIlII.z;
        this.angle = llllllllllllllIIllllIIIIllllIlII.angle;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("(").append(this.x).append(", ").append(this.y).append(", ").append(this.z).append(", ").append(this.angle).append(")"));
    }
    
    public final void get(final float[] llllllllllllllIIllllIIIIllIlllll) {
        llllllllllllllIIllllIIIIllIlllll[0] = this.x;
        llllllllllllllIIllllIIIIllIlllll[1] = this.y;
        llllllllllllllIIllllIIIIllIlllll[2] = this.z;
        llllllllllllllIIllllIIIIllIlllll[3] = this.angle;
    }
    
    public final void set(final Matrix4f llllllllllllllIIllllIIIIlIllllII) {
        final Matrix3f llllllllllllllIIllllIIIIlIlllIll = new Matrix3f();
        llllllllllllllIIllllIIIIlIllllII.get(llllllllllllllIIllllIIIIlIlllIll);
        this.x = llllllllllllllIIllllIIIIlIlllIll.m21 - llllllllllllllIIllllIIIIlIlllIll.m12;
        this.y = llllllllllllllIIllllIIIIlIlllIll.m02 - llllllllllllllIIllllIIIIlIlllIll.m20;
        this.z = llllllllllllllIIllllIIIIlIlllIll.m10 - llllllllllllllIIllllIIIIlIlllIll.m01;
        double llllllllllllllIIllllIIIIlIlllIlI = this.x * this.x + this.y * this.y + this.z * this.z;
        if (llllllllllllllIIllllIIIIlIlllIlI > 1.0E-6) {
            llllllllllllllIIllllIIIIlIlllIlI = Math.sqrt(llllllllllllllIIllllIIIIlIlllIlI);
            final double llllllllllllllIIllllIIIIlIlllIIl = 0.5 * llllllllllllllIIllllIIIIlIlllIlI;
            final double llllllllllllllIIllllIIIIlIlllIII = 0.5 * (llllllllllllllIIllllIIIIlIlllIll.m00 + llllllllllllllIIllllIIIIlIlllIll.m11 + llllllllllllllIIllllIIIIlIlllIll.m22 - 1.0);
            this.angle = (float)Math.atan2(llllllllllllllIIllllIIIIlIlllIIl, llllllllllllllIIllllIIIIlIlllIII);
            final double llllllllllllllIIllllIIIIlIllIlll = 1.0 / llllllllllllllIIllllIIIIlIlllIlI;
            this.x *= (float)llllllllllllllIIllllIIIIlIllIlll;
            this.y *= (float)llllllllllllllIIllllIIIIlIllIlll;
            this.z *= (float)llllllllllllllIIllllIIIIlIllIlll;
        }
        else {
            this.x = 0.0f;
            this.y = 1.0f;
            this.z = 0.0f;
            this.angle = 0.0f;
        }
    }
    
    public final void set(final Matrix4d llllllllllllllIIllllIIIIlIlIIlll) {
        final Matrix3d llllllllllllllIIllllIIIIlIlIIllI = new Matrix3d();
        llllllllllllllIIllllIIIIlIlIIlll.get(llllllllllllllIIllllIIIIlIlIIllI);
        this.x = (float)(llllllllllllllIIllllIIIIlIlIIllI.m21 - llllllllllllllIIllllIIIIlIlIIllI.m12);
        this.y = (float)(llllllllllllllIIllllIIIIlIlIIllI.m02 - llllllllllllllIIllllIIIIlIlIIllI.m20);
        this.z = (float)(llllllllllllllIIllllIIIIlIlIIllI.m10 - llllllllllllllIIllllIIIIlIlIIllI.m01);
        double llllllllllllllIIllllIIIIlIlIIlIl = this.x * this.x + this.y * this.y + this.z * this.z;
        if (llllllllllllllIIllllIIIIlIlIIlIl > 1.0E-6) {
            llllllllllllllIIllllIIIIlIlIIlIl = Math.sqrt(llllllllllllllIIllllIIIIlIlIIlIl);
            final double llllllllllllllIIllllIIIIlIlIIlII = 0.5 * llllllllllllllIIllllIIIIlIlIIlIl;
            final double llllllllllllllIIllllIIIIlIlIIIll = 0.5 * (llllllllllllllIIllllIIIIlIlIIllI.m00 + llllllllllllllIIllllIIIIlIlIIllI.m11 + llllllllllllllIIllllIIIIlIlIIllI.m22 - 1.0);
            this.angle = (float)Math.atan2(llllllllllllllIIllllIIIIlIlIIlII, llllllllllllllIIllllIIIIlIlIIIll);
            final double llllllllllllllIIllllIIIIlIlIIIlI = 1.0 / llllllllllllllIIllllIIIIlIlIIlIl;
            this.x *= (float)llllllllllllllIIllllIIIIlIlIIIlI;
            this.y *= (float)llllllllllllllIIllllIIIIlIlIIIlI;
            this.z *= (float)llllllllllllllIIllllIIIIlIlIIIlI;
        }
        else {
            this.x = 0.0f;
            this.y = 1.0f;
            this.z = 0.0f;
            this.angle = 0.0f;
        }
    }
}
