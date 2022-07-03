package javax.vecmath;

import java.io.*;

public class AxisAngle4d implements Cloneable, Serializable
{
    public /* synthetic */ double angle;
    public /* synthetic */ double z;
    public /* synthetic */ double x;
    public /* synthetic */ double y;
    
    public double getZ() {
        return this.z;
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIllIIllIllIllllllII) {
        try {
            final AxisAngle4d lllllllllllllIllIIllIllIlllllIlI = (AxisAngle4d)lllllllllllllIllIIllIllIllllllII;
            return this.x == lllllllllllllIllIIllIllIlllllIlI.x && this.y == lllllllllllllIllIIllIllIlllllIlI.y && this.z == lllllllllllllIllIIllIllIlllllIlI.z && this.angle == lllllllllllllIllIIllIllIlllllIlI.angle;
        }
        catch (NullPointerException lllllllllllllIllIIllIllIlllllIII) {
            return false;
        }
        catch (ClassCastException lllllllllllllIllIIllIllIllllIllI) {
            return false;
        }
    }
    
    public double getX() {
        return this.x;
    }
    
    public boolean equals(final AxisAngle4d lllllllllllllIllIIllIlllIIIlIIIl) {
        try {
            return this.x == lllllllllllllIllIIllIlllIIIlIIIl.x && this.y == lllllllllllllIllIIllIlllIIIlIIIl.y && this.z == lllllllllllllIllIIllIlllIIIlIIIl.z && this.angle == lllllllllllllIllIIllIlllIIIlIIIl.angle;
        }
        catch (NullPointerException lllllllllllllIllIIllIlllIIIIllll) {
            return false;
        }
    }
    
    public final void setX(final double lllllllllllllIllIIllIllIllIIIIll) {
        this.x = lllllllllllllIllIIllIllIllIIIIll;
    }
    
    public final void get(final double[] lllllllllllllIllIIllIllllIllIllI) {
        lllllllllllllIllIIllIllllIllIllI[0] = this.x;
        lllllllllllllIllIIllIllllIllIllI[1] = this.y;
        lllllllllllllIllIIllIllllIllIllI[2] = this.z;
        lllllllllllllIllIIllIllllIllIllI[3] = this.angle;
    }
    
    public final void set(final Matrix4d lllllllllllllIllIIllIllllIIlIIIl) {
        final Matrix3d lllllllllllllIllIIllIllllIIlIlll = new Matrix3d();
        lllllllllllllIllIIllIllllIIlIIIl.get(lllllllllllllIllIIllIllllIIlIlll);
        this.x = (float)(lllllllllllllIllIIllIllllIIlIlll.m21 - lllllllllllllIllIIllIllllIIlIlll.m12);
        this.y = (float)(lllllllllllllIllIIllIllllIIlIlll.m02 - lllllllllllllIllIIllIllllIIlIlll.m20);
        this.z = (float)(lllllllllllllIllIIllIllllIIlIlll.m10 - lllllllllllllIllIIllIllllIIlIlll.m01);
        double lllllllllllllIllIIllIllllIIlIllI = this.x * this.x + this.y * this.y + this.z * this.z;
        if (lllllllllllllIllIIllIllllIIlIllI > 1.0E-12) {
            lllllllllllllIllIIllIllllIIlIllI = Math.sqrt(lllllllllllllIllIIllIllllIIlIllI);
            final double lllllllllllllIllIIllIllllIIlIlIl = 0.5 * lllllllllllllIllIIllIllllIIlIllI;
            final double lllllllllllllIllIIllIllllIIlIlII = 0.5 * (lllllllllllllIllIIllIllllIIlIlll.m00 + lllllllllllllIllIIllIllllIIlIlll.m11 + lllllllllllllIllIIllIllllIIlIlll.m22 - 1.0);
            this.angle = (float)Math.atan2(lllllllllllllIllIIllIllllIIlIlIl, lllllllllllllIllIIllIllllIIlIlII);
            final double lllllllllllllIllIIllIllllIIlIIll = 1.0 / lllllllllllllIllIIllIllllIIlIllI;
            this.x *= lllllllllllllIllIIllIllllIIlIIll;
            this.y *= lllllllllllllIllIIllIllllIIlIIll;
            this.z *= lllllllllllllIllIIllIllllIIlIIll;
        }
        else {
            this.x = 0.0;
            this.y = 1.0;
            this.z = 0.0;
            this.angle = 0.0;
        }
    }
    
    public AxisAngle4d() {
        this.x = 0.0;
        this.y = 0.0;
        this.z = 1.0;
        this.angle = 0.0;
    }
    
    public boolean epsilonEquals(final AxisAngle4d lllllllllllllIllIIllIllIlllIlIIl, final double lllllllllllllIllIIllIllIlllIlIII) {
        double lllllllllllllIllIIllIllIlllIIllI = this.x - lllllllllllllIllIIllIllIlllIlIIl.x;
        if (((lllllllllllllIllIIllIllIlllIIllI < 0.0) ? (-lllllllllllllIllIIllIllIlllIIllI) : lllllllllllllIllIIllIllIlllIIllI) > lllllllllllllIllIIllIllIlllIlIII) {
            return false;
        }
        lllllllllllllIllIIllIllIlllIIllI = this.y - lllllllllllllIllIIllIllIlllIlIIl.y;
        if (((lllllllllllllIllIIllIllIlllIIllI < 0.0) ? (-lllllllllllllIllIIllIllIlllIIllI) : lllllllllllllIllIIllIllIlllIIllI) > lllllllllllllIllIIllIllIlllIlIII) {
            return false;
        }
        lllllllllllllIllIIllIllIlllIIllI = this.z - lllllllllllllIllIIllIllIlllIlIIl.z;
        if (((lllllllllllllIllIIllIllIlllIIllI < 0.0) ? (-lllllllllllllIllIIllIllIlllIIllI) : lllllllllllllIllIIllIllIlllIIllI) > lllllllllllllIllIIllIllIlllIlIII) {
            return false;
        }
        lllllllllllllIllIIllIllIlllIIllI = this.angle - lllllllllllllIllIIllIllIlllIlIIl.angle;
        return ((lllllllllllllIllIIllIllIlllIIllI < 0.0) ? (-lllllllllllllIllIIllIllIlllIIllI) : lllllllllllllIllIIllIllIlllIIllI) <= lllllllllllllIllIIllIllIlllIlIII;
    }
    
    public final double getAngle() {
        return this.angle;
    }
    
    public final void set(final double lllllllllllllIllIIllIlllllIllIlI, final double lllllllllllllIllIIllIlllllIllIIl, final double lllllllllllllIllIIllIlllllIllIII, final double lllllllllllllIllIIllIlllllIlIlll) {
        this.x = lllllllllllllIllIIllIlllllIllIlI;
        this.y = lllllllllllllIllIIllIlllllIllIIl;
        this.z = lllllllllllllIllIIllIlllllIllIII;
        this.angle = lllllllllllllIllIIllIlllllIlIlll;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("(").append(this.x).append(", ").append(this.y).append(", ").append(this.z).append(", ").append(this.angle).append(")"));
    }
    
    public AxisAngle4d(final Vector3d lllllllllllllIllIIllIllllllIlIlI, final double lllllllllllllIllIIllIllllllIllII) {
        this.x = lllllllllllllIllIIllIllllllIlIlI.x;
        this.y = lllllllllllllIllIIllIllllllIlIlI.y;
        this.z = lllllllllllllIllIIllIllllllIlIlI.z;
        this.angle = lllllllllllllIllIIllIllllllIllII;
    }
    
    public final void set(final Matrix4f lllllllllllllIllIIllIllllIlIIllI) {
        final Matrix3d lllllllllllllIllIIllIllllIlIllII = new Matrix3d();
        lllllllllllllIllIIllIllllIlIIllI.get(lllllllllllllIllIIllIllllIlIllII);
        this.x = (float)(lllllllllllllIllIIllIllllIlIllII.m21 - lllllllllllllIllIIllIllllIlIllII.m12);
        this.y = (float)(lllllllllllllIllIIllIllllIlIllII.m02 - lllllllllllllIllIIllIllllIlIllII.m20);
        this.z = (float)(lllllllllllllIllIIllIllllIlIllII.m10 - lllllllllllllIllIIllIllllIlIllII.m01);
        double lllllllllllllIllIIllIllllIlIlIll = this.x * this.x + this.y * this.y + this.z * this.z;
        if (lllllllllllllIllIIllIllllIlIlIll > 1.0E-12) {
            lllllllllllllIllIIllIllllIlIlIll = Math.sqrt(lllllllllllllIllIIllIllllIlIlIll);
            final double lllllllllllllIllIIllIllllIlIlIlI = 0.5 * lllllllllllllIllIIllIllllIlIlIll;
            final double lllllllllllllIllIIllIllllIlIlIIl = 0.5 * (lllllllllllllIllIIllIllllIlIllII.m00 + lllllllllllllIllIIllIllllIlIllII.m11 + lllllllllllllIllIIllIllllIlIllII.m22 - 1.0);
            this.angle = (float)Math.atan2(lllllllllllllIllIIllIllllIlIlIlI, lllllllllllllIllIIllIllllIlIlIIl);
            final double lllllllllllllIllIIllIllllIlIlIII = 1.0 / lllllllllllllIllIIllIllllIlIlIll;
            this.x *= lllllllllllllIllIIllIllllIlIlIII;
            this.y *= lllllllllllllIllIIllIllllIlIlIII;
            this.z *= lllllllllllllIllIIllIllllIlIlIII;
        }
        else {
            this.x = 0.0;
            this.y = 1.0;
            this.z = 0.0;
            this.angle = 0.0;
        }
    }
    
    public final void set(final Matrix3d lllllllllllllIllIIllIlllIlIllIlI) {
        this.x = (float)(lllllllllllllIllIIllIlllIlIllIlI.m21 - lllllllllllllIllIIllIlllIlIllIlI.m12);
        this.y = (float)(lllllllllllllIllIIllIlllIlIllIlI.m02 - lllllllllllllIllIIllIlllIlIllIlI.m20);
        this.z = (float)(lllllllllllllIllIIllIlllIlIllIlI.m10 - lllllllllllllIllIIllIlllIlIllIlI.m01);
        double lllllllllllllIllIIllIlllIlIllIIl = this.x * this.x + this.y * this.y + this.z * this.z;
        if (lllllllllllllIllIIllIlllIlIllIIl > 1.0E-12) {
            lllllllllllllIllIIllIlllIlIllIIl = Math.sqrt(lllllllllllllIllIIllIlllIlIllIIl);
            final double lllllllllllllIllIIllIlllIlIllIII = 0.5 * lllllllllllllIllIIllIlllIlIllIIl;
            final double lllllllllllllIllIIllIlllIlIlIlll = 0.5 * (lllllllllllllIllIIllIlllIlIllIlI.m00 + lllllllllllllIllIIllIlllIlIllIlI.m11 + lllllllllllllIllIIllIlllIlIllIlI.m22 - 1.0);
            this.angle = (float)Math.atan2(lllllllllllllIllIIllIlllIlIllIII, lllllllllllllIllIIllIlllIlIlIlll);
            final double lllllllllllllIllIIllIlllIlIlIllI = 1.0 / lllllllllllllIllIIllIlllIlIllIIl;
            this.x *= lllllllllllllIllIIllIlllIlIlIllI;
            this.y *= lllllllllllllIllIIllIlllIlIlIllI;
            this.z *= lllllllllllllIllIIllIlllIlIlIllI;
        }
        else {
            this.x = 0.0;
            this.y = 1.0;
            this.z = 0.0;
            this.angle = 0.0;
        }
    }
    
    public final void set(final Quat4d lllllllllllllIllIIllIlllIIllIIIl) {
        double lllllllllllllIllIIllIlllIIllIIII = lllllllllllllIllIIllIlllIIllIIIl.x * lllllllllllllIllIIllIlllIIllIIIl.x + lllllllllllllIllIIllIlllIIllIIIl.y * lllllllllllllIllIIllIlllIIllIIIl.y + lllllllllllllIllIIllIlllIIllIIIl.z * lllllllllllllIllIIllIlllIIllIIIl.z;
        if (lllllllllllllIllIIllIlllIIllIIII > 1.0E-12) {
            lllllllllllllIllIIllIlllIIllIIII = Math.sqrt(lllllllllllllIllIIllIlllIIllIIII);
            final double lllllllllllllIllIIllIlllIIlIllll = 1.0 / lllllllllllllIllIIllIlllIIllIIII;
            this.x = lllllllllllllIllIIllIlllIIllIIIl.x * lllllllllllllIllIIllIlllIIlIllll;
            this.y = lllllllllllllIllIIllIlllIIllIIIl.y * lllllllllllllIllIIllIlllIIlIllll;
            this.z = lllllllllllllIllIIllIlllIIllIIIl.z * lllllllllllllIllIIllIlllIIlIllll;
            this.angle = 2.0 * Math.atan2(lllllllllllllIllIIllIlllIIllIIII, lllllllllllllIllIIllIlllIIllIIIl.w);
        }
        else {
            this.x = 0.0;
            this.y = 1.0;
            this.z = 0.0;
            this.angle = 0.0;
        }
    }
    
    public AxisAngle4d(final double lllllllllllllIllIIlllIIIIIIIIlll, final double lllllllllllllIllIIlllIIIIIIIlIll, final double lllllllllllllIllIIlllIIIIIIIlIlI, final double lllllllllllllIllIIlllIIIIIIIlIIl) {
        this.x = lllllllllllllIllIIlllIIIIIIIIlll;
        this.y = lllllllllllllIllIIlllIIIIIIIlIll;
        this.z = lllllllllllllIllIIlllIIIIIIIlIlI;
        this.angle = lllllllllllllIllIIlllIIIIIIIlIIl;
    }
    
    public final void set(final double[] lllllllllllllIllIIllIlllllIlIIll) {
        this.x = lllllllllllllIllIIllIlllllIlIIll[0];
        this.y = lllllllllllllIllIIllIlllllIlIIll[1];
        this.z = lllllllllllllIllIIllIlllllIlIIll[2];
        this.angle = lllllllllllllIllIIllIlllllIlIIll[3];
    }
    
    public final void set(final Vector3d lllllllllllllIllIIllIlllllIIIIII, final double lllllllllllllIllIIllIllllIllllll) {
        this.x = lllllllllllllIllIIllIlllllIIIIII.x;
        this.y = lllllllllllllIllIIllIlllllIIIIII.y;
        this.z = lllllllllllllIllIIllIlllllIIIIII.z;
        this.angle = lllllllllllllIllIIllIllllIllllll;
    }
    
    public final void set(final AxisAngle4d lllllllllllllIllIIllIlllllIIlIll) {
        this.x = lllllllllllllIllIIllIlllllIIlIll.x;
        this.y = lllllllllllllIllIIllIlllllIIlIll.y;
        this.z = lllllllllllllIllIIllIlllllIIlIll.z;
        this.angle = lllllllllllllIllIIllIlllllIIlIll.angle;
    }
    
    public final void set(final AxisAngle4f lllllllllllllIllIIllIlllllIIIlIl) {
        this.x = lllllllllllllIllIIllIlllllIIIlIl.x;
        this.y = lllllllllllllIllIIllIlllllIIIlIl.y;
        this.z = lllllllllllllIllIIllIlllllIIIlIl.z;
        this.angle = lllllllllllllIllIIllIlllllIIIlIl.angle;
    }
    
    public final void set(final Quat4f lllllllllllllIllIIllIlllIlIIIllI) {
        double lllllllllllllIllIIllIlllIlIIlIIl = lllllllllllllIllIIllIlllIlIIIllI.x * lllllllllllllIllIIllIlllIlIIIllI.x + lllllllllllllIllIIllIlllIlIIIllI.y * lllllllllllllIllIIllIlllIlIIIllI.y + lllllllllllllIllIIllIlllIlIIIllI.z * lllllllllllllIllIIllIlllIlIIIllI.z;
        if (lllllllllllllIllIIllIlllIlIIlIIl > 1.0E-12) {
            lllllllllllllIllIIllIlllIlIIlIIl = Math.sqrt(lllllllllllllIllIIllIlllIlIIlIIl);
            final double lllllllllllllIllIIllIlllIlIIlIII = 1.0 / lllllllllllllIllIIllIlllIlIIlIIl;
            this.x = lllllllllllllIllIIllIlllIlIIIllI.x * lllllllllllllIllIIllIlllIlIIlIII;
            this.y = lllllllllllllIllIIllIlllIlIIIllI.y * lllllllllllllIllIIllIlllIlIIlIII;
            this.z = lllllllllllllIllIIllIlllIlIIIllI.z * lllllllllllllIllIIllIlllIlIIlIII;
            this.angle = 2.0 * Math.atan2(lllllllllllllIllIIllIlllIlIIlIIl, lllllllllllllIllIIllIlllIlIIIllI.w);
        }
        else {
            this.x = 0.0;
            this.y = 1.0;
            this.z = 0.0;
            this.angle = 0.0;
        }
    }
    
    public final void setZ(final double lllllllllllllIllIIllIllIlIlIllll) {
        this.z = lllllllllllllIllIIllIllIlIlIllll;
    }
    
    public Object clone() {
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException lllllllllllllIllIIllIllIllIlIlIl) {
            throw new InternalError();
        }
    }
    
    public AxisAngle4d(final double[] lllllllllllllIllIIllIllllllllllI) {
        this.x = lllllllllllllIllIIllIllllllllllI[0];
        this.y = lllllllllllllIllIIllIllllllllllI[1];
        this.z = lllllllllllllIllIIllIllllllllllI[2];
        this.angle = lllllllllllllIllIIllIllllllllllI[3];
    }
    
    public final void set(final Matrix3f lllllllllllllIllIIllIlllIllllIlI) {
        this.x = lllllllllllllIllIIllIlllIllllIlI.m21 - lllllllllllllIllIIllIlllIllllIlI.m12;
        this.y = lllllllllllllIllIIllIlllIllllIlI.m02 - lllllllllllllIllIIllIlllIllllIlI.m20;
        this.z = lllllllllllllIllIIllIlllIllllIlI.m10 - lllllllllllllIllIIllIlllIllllIlI.m01;
        double lllllllllllllIllIIllIllllIIIIIll = this.x * this.x + this.y * this.y + this.z * this.z;
        if (lllllllllllllIllIIllIllllIIIIIll > 1.0E-12) {
            lllllllllllllIllIIllIllllIIIIIll = Math.sqrt(lllllllllllllIllIIllIllllIIIIIll);
            final double lllllllllllllIllIIllIllllIIIIIIl = 0.5 * lllllllllllllIllIIllIllllIIIIIll;
            final double lllllllllllllIllIIllIllllIIIIIII = 0.5 * (lllllllllllllIllIIllIlllIllllIlI.m00 + lllllllllllllIllIIllIlllIllllIlI.m11 + lllllllllllllIllIIllIlllIllllIlI.m22 - 1.0);
            this.angle = (float)Math.atan2(lllllllllllllIllIIllIllllIIIIIIl, lllllllllllllIllIIllIllllIIIIIII);
            final double lllllllllllllIllIIllIlllIllllllI = 1.0 / lllllllllllllIllIIllIllllIIIIIll;
            this.x *= lllllllllllllIllIIllIlllIllllllI;
            this.y *= lllllllllllllIllIIllIlllIllllllI;
            this.z *= lllllllllllllIllIIllIlllIllllllI;
        }
        else {
            this.x = 0.0;
            this.y = 1.0;
            this.z = 0.0;
            this.angle = 0.0;
        }
    }
    
    public final void setY(final double lllllllllllllIllIIllIllIlIlllIlI) {
        this.y = lllllllllllllIllIIllIllIlIlllIlI;
    }
    
    public final double getY() {
        return this.y;
    }
    
    public final void setAngle(final double lllllllllllllIllIIllIllIllIIlIlI) {
        this.angle = lllllllllllllIllIIllIllIllIIlIlI;
    }
    
    public AxisAngle4d(final AxisAngle4d lllllllllllllIllIIllIllllllllIII) {
        this.x = lllllllllllllIllIIllIllllllllIII.x;
        this.y = lllllllllllllIllIIllIllllllllIII.y;
        this.z = lllllllllllllIllIIllIllllllllIII.z;
        this.angle = lllllllllllllIllIIllIllllllllIII.angle;
    }
    
    public AxisAngle4d(final AxisAngle4f lllllllllllllIllIIllIlllllllIIlI) {
        this.x = lllllllllllllIllIIllIlllllllIIlI.x;
        this.y = lllllllllllllIllIIllIlllllllIIlI.y;
        this.z = lllllllllllllIllIIllIlllllllIIlI.z;
        this.angle = lllllllllllllIllIIllIlllllllIIlI.angle;
    }
    
    @Override
    public int hashCode() {
        long lllllllllllllIllIIllIllIllIllIll = 1L;
        lllllllllllllIllIIllIllIllIllIll = VecMathUtil.hashDoubleBits(lllllllllllllIllIIllIllIllIllIll, this.x);
        lllllllllllllIllIIllIllIllIllIll = VecMathUtil.hashDoubleBits(lllllllllllllIllIIllIllIllIllIll, this.y);
        lllllllllllllIllIIllIllIllIllIll = VecMathUtil.hashDoubleBits(lllllllllllllIllIIllIllIllIllIll, this.z);
        lllllllllllllIllIIllIllIllIllIll = VecMathUtil.hashDoubleBits(lllllllllllllIllIIllIllIllIllIll, this.angle);
        return VecMathUtil.hashFinish(lllllllllllllIllIIllIllIllIllIll);
    }
}
