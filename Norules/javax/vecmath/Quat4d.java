package javax.vecmath;

import java.io.*;

public class Quat4d extends Tuple4d implements Serializable
{
    public Quat4d(final double llllllllllllllIllllIlIIIllIIIIlI, final double llllllllllllllIllllIlIIIllIIIIIl, final double llllllllllllllIllllIlIIIllIIIllI, final double llllllllllllllIllllIlIIIllIIIlIl) {
        final double llllllllllllllIllllIlIIIllIIIlII = 1.0 / Math.sqrt(llllllllllllllIllllIlIIIllIIIIlI * llllllllllllllIllllIlIIIllIIIIlI + llllllllllllllIllllIlIIIllIIIIIl * llllllllllllllIllllIlIIIllIIIIIl + llllllllllllllIllllIlIIIllIIIllI * llllllllllllllIllllIlIIIllIIIllI + llllllllllllllIllllIlIIIllIIIlIl * llllllllllllllIllllIlIIIllIIIlIl);
        this.x = llllllllllllllIllllIlIIIllIIIIlI * llllllllllllllIllllIlIIIllIIIlII;
        this.y = llllllllllllllIllllIlIIIllIIIIIl * llllllllllllllIllllIlIIIllIIIlII;
        this.z = llllllllllllllIllllIlIIIllIIIllI * llllllllllllllIllllIlIIIllIIIlII;
        this.w = llllllllllllllIllllIlIIIllIIIlIl * llllllllllllllIllllIlIIIllIIIlII;
    }
    
    public Quat4d(final Tuple4f llllllllllllllIllllIlIIIlIlIIIIl) {
        final double llllllllllllllIllllIlIIIlIlIIIll = 1.0 / Math.sqrt(llllllllllllllIllllIlIIIlIlIIIIl.x * llllllllllllllIllllIlIIIlIlIIIIl.x + llllllllllllllIllllIlIIIlIlIIIIl.y * llllllllllllllIllllIlIIIlIlIIIIl.y + llllllllllllllIllllIlIIIlIlIIIIl.z * llllllllllllllIllllIlIIIlIlIIIIl.z + llllllllllllllIllllIlIIIlIlIIIIl.w * llllllllllllllIllllIlIIIlIlIIIIl.w);
        this.x = llllllllllllllIllllIlIIIlIlIIIIl.x * llllllllllllllIllllIlIIIlIlIIIll;
        this.y = llllllllllllllIllllIlIIIlIlIIIIl.y * llllllllllllllIllllIlIIIlIlIIIll;
        this.z = llllllllllllllIllllIlIIIlIlIIIIl.z * llllllllllllllIllllIlIIIlIlIIIll;
        this.w = llllllllllllllIllllIlIIIlIlIIIIl.w * llllllllllllllIllllIlIIIlIlIIIll;
    }
    
    public final void set(final Matrix3f llllllllllllllIllllIlIIIIIlIIIII) {
        double llllllllllllllIllllIlIIIIIIlllll = 0.25 * (llllllllllllllIllllIlIIIIIlIIIII.m00 + llllllllllllllIllllIlIIIIIlIIIII.m11 + llllllllllllllIllllIlIIIIIlIIIII.m22 + 1.0);
        if (llllllllllllllIllllIlIIIIIIlllll < 0.0) {
            this.w = 0.0;
            this.x = 0.0;
            this.y = 0.0;
            this.z = 1.0;
            return;
        }
        if (llllllllllllllIllllIlIIIIIIlllll >= 1.0E-30) {
            this.w = Math.sqrt(llllllllllllllIllllIlIIIIIIlllll);
            llllllllllllllIllllIlIIIIIIlllll = 0.25 / this.w;
            this.x = (llllllllllllllIllllIlIIIIIlIIIII.m21 - llllllllllllllIllllIlIIIIIlIIIII.m12) * llllllllllllllIllllIlIIIIIIlllll;
            this.y = (llllllllllllllIllllIlIIIIIlIIIII.m02 - llllllllllllllIllllIlIIIIIlIIIII.m20) * llllllllllllllIllllIlIIIIIIlllll;
            this.z = (llllllllllllllIllllIlIIIIIlIIIII.m10 - llllllllllllllIllllIlIIIIIlIIIII.m01) * llllllllllllllIllllIlIIIIIIlllll;
            return;
        }
        this.w = 0.0;
        llllllllllllllIllllIlIIIIIIlllll = -0.5 * (llllllllllllllIllllIlIIIIIlIIIII.m11 + llllllllllllllIllllIlIIIIIlIIIII.m22);
        if (llllllllllllllIllllIlIIIIIIlllll < 0.0) {
            this.x = 0.0;
            this.y = 0.0;
            this.z = 1.0;
            return;
        }
        if (llllllllllllllIllllIlIIIIIIlllll >= 1.0E-30) {
            this.x = Math.sqrt(llllllllllllllIllllIlIIIIIIlllll);
            llllllllllllllIllllIlIIIIIIlllll = 0.5 / this.x;
            this.y = llllllllllllllIllllIlIIIIIlIIIII.m10 * llllllllllllllIllllIlIIIIIIlllll;
            this.z = llllllllllllllIllllIlIIIIIlIIIII.m20 * llllllllllllllIllllIlIIIIIIlllll;
            return;
        }
        this.x = 0.0;
        llllllllllllllIllllIlIIIIIIlllll = 0.5 * (1.0 - llllllllllllllIllllIlIIIIIlIIIII.m22);
        if (llllllllllllllIllllIlIIIIIIlllll >= 1.0E-30) {
            this.y = Math.sqrt(llllllllllllllIllllIlIIIIIIlllll);
            this.z = llllllllllllllIllllIlIIIIIlIIIII.m21 / (2.0 * this.y);
        }
        this.y = 0.0;
        this.z = 1.0;
    }
    
    public final void mulInverse(final Quat4d llllllllllllllIllllIlIIIIllIIlII, final Quat4d llllllllllllllIllllIlIIIIlIlllll) {
        final Quat4d llllllllllllllIllllIlIIIIllIIIlI = new Quat4d(llllllllllllllIllllIlIIIIlIlllll);
        llllllllllllllIllllIlIIIIllIIIlI.inverse();
        this.mul(llllllllllllllIllllIlIIIIllIIlII, llllllllllllllIllllIlIIIIllIIIlI);
    }
    
    public Quat4d(final Quat4f llllllllllllllIllllIlIIIlIlIlIIl) {
        super(llllllllllllllIllllIlIIIlIlIlIIl);
    }
    
    public final void mulInverse(final Quat4d llllllllllllllIllllIlIIIIlIllIIl) {
        final Quat4d llllllllllllllIllllIlIIIIlIllIII = new Quat4d(llllllllllllllIllllIlIIIIlIllIIl);
        llllllllllllllIllllIlIIIIlIllIII.inverse();
        this.mul(llllllllllllllIllllIlIIIIlIllIII);
    }
    
    public final void set(final Matrix4d llllllllllllllIllllIlIIIIIlIIllI) {
        double llllllllllllllIllllIlIIIIIlIlIII = 0.25 * (llllllllllllllIllllIlIIIIIlIIllI.m00 + llllllllllllllIllllIlIIIIIlIIllI.m11 + llllllllllllllIllllIlIIIIIlIIllI.m22 + llllllllllllllIllllIlIIIIIlIIllI.m33);
        if (llllllllllllllIllllIlIIIIIlIlIII < 0.0) {
            this.w = 0.0;
            this.x = 0.0;
            this.y = 0.0;
            this.z = 1.0;
            return;
        }
        if (llllllllllllllIllllIlIIIIIlIlIII >= 1.0E-30) {
            this.w = Math.sqrt(llllllllllllllIllllIlIIIIIlIlIII);
            llllllllllllllIllllIlIIIIIlIlIII = 0.25 / this.w;
            this.x = (llllllllllllllIllllIlIIIIIlIIllI.m21 - llllllllllllllIllllIlIIIIIlIIllI.m12) * llllllllllllllIllllIlIIIIIlIlIII;
            this.y = (llllllllllllllIllllIlIIIIIlIIllI.m02 - llllllllllllllIllllIlIIIIIlIIllI.m20) * llllllllllllllIllllIlIIIIIlIlIII;
            this.z = (llllllllllllllIllllIlIIIIIlIIllI.m10 - llllllllllllllIllllIlIIIIIlIIllI.m01) * llllllllllllllIllllIlIIIIIlIlIII;
            return;
        }
        this.w = 0.0;
        llllllllllllllIllllIlIIIIIlIlIII = -0.5 * (llllllllllllllIllllIlIIIIIlIIllI.m11 + llllllllllllllIllllIlIIIIIlIIllI.m22);
        if (llllllllllllllIllllIlIIIIIlIlIII < 0.0) {
            this.x = 0.0;
            this.y = 0.0;
            this.z = 1.0;
            return;
        }
        if (llllllllllllllIllllIlIIIIIlIlIII >= 1.0E-30) {
            this.x = Math.sqrt(llllllllllllllIllllIlIIIIIlIlIII);
            llllllllllllllIllllIlIIIIIlIlIII = 0.5 / this.x;
            this.y = llllllllllllllIllllIlIIIIIlIIllI.m10 * llllllllllllllIllllIlIIIIIlIlIII;
            this.z = llllllllllllllIllllIlIIIIIlIIllI.m20 * llllllllllllllIllllIlIIIIIlIlIII;
            return;
        }
        this.x = 0.0;
        llllllllllllllIllllIlIIIIIlIlIII = 0.5 * (1.0 - llllllllllllllIllllIlIIIIIlIIllI.m22);
        if (llllllllllllllIllllIlIIIIIlIlIII >= 1.0E-30) {
            this.y = Math.sqrt(llllllllllllllIllllIlIIIIIlIlIII);
            this.z = llllllllllllllIllllIlIIIIIlIIllI.m21 / (2.0 * this.y);
            return;
        }
        this.y = 0.0;
        this.z = 1.0;
    }
    
    public final void inverse(final Quat4d llllllllllllllIllllIlIIIIlIlIIII) {
        final double llllllllllllllIllllIlIIIIlIIllll = 1.0 / (llllllllllllllIllllIlIIIIlIlIIII.w * llllllllllllllIllllIlIIIIlIlIIII.w + llllllllllllllIllllIlIIIIlIlIIII.x * llllllllllllllIllllIlIIIIlIlIIII.x + llllllllllllllIllllIlIIIIlIlIIII.y * llllllllllllllIllllIlIIIIlIlIIII.y + llllllllllllllIllllIlIIIIlIlIIII.z * llllllllllllllIllllIlIIIIlIlIIII.z);
        this.w = llllllllllllllIllllIlIIIIlIIllll * llllllllllllllIllllIlIIIIlIlIIII.w;
        this.x = -llllllllllllllIllllIlIIIIlIIllll * llllllllllllllIllllIlIIIIlIlIIII.x;
        this.y = -llllllllllllllIllllIlIIIIlIIllll * llllllllllllllIllllIlIIIIlIlIIII.y;
        this.z = -llllllllllllllIllllIlIIIIlIIllll * llllllllllllllIllllIlIIIIlIlIIII.z;
    }
    
    public final void inverse() {
        final double llllllllllllllIllllIlIIIIlIIlIII = 1.0 / (this.w * this.w + this.x * this.x + this.y * this.y + this.z * this.z);
        this.w *= llllllllllllllIllllIlIIIIlIIlIII;
        this.x *= -llllllllllllllIllllIlIIIIlIIlIII;
        this.y *= -llllllllllllllIllllIlIIIIlIIlIII;
        this.z *= -llllllllllllllIllllIlIIIIlIIlIII;
    }
    
    public final void set(final Matrix3d llllllllllllllIllllIlIIIIIIlIlII) {
        double llllllllllllllIllllIlIIIIIIlIllI = 0.25 * (llllllllllllllIllllIlIIIIIIlIlII.m00 + llllllllllllllIllllIlIIIIIIlIlII.m11 + llllllllllllllIllllIlIIIIIIlIlII.m22 + 1.0);
        if (llllllllllllllIllllIlIIIIIIlIllI < 0.0) {
            this.w = 0.0;
            this.x = 0.0;
            this.y = 0.0;
            this.z = 1.0;
            return;
        }
        if (llllllllllllllIllllIlIIIIIIlIllI >= 1.0E-30) {
            this.w = Math.sqrt(llllllllllllllIllllIlIIIIIIlIllI);
            llllllllllllllIllllIlIIIIIIlIllI = 0.25 / this.w;
            this.x = (llllllllllllllIllllIlIIIIIIlIlII.m21 - llllllllllllllIllllIlIIIIIIlIlII.m12) * llllllllllllllIllllIlIIIIIIlIllI;
            this.y = (llllllllllllllIllllIlIIIIIIlIlII.m02 - llllllllllllllIllllIlIIIIIIlIlII.m20) * llllllllllllllIllllIlIIIIIIlIllI;
            this.z = (llllllllllllllIllllIlIIIIIIlIlII.m10 - llllllllllllllIllllIlIIIIIIlIlII.m01) * llllllllllllllIllllIlIIIIIIlIllI;
            return;
        }
        this.w = 0.0;
        llllllllllllllIllllIlIIIIIIlIllI = -0.5 * (llllllllllllllIllllIlIIIIIIlIlII.m11 + llllllllllllllIllllIlIIIIIIlIlII.m22);
        if (llllllllllllllIllllIlIIIIIIlIllI < 0.0) {
            this.x = 0.0;
            this.y = 0.0;
            this.z = 1.0;
            return;
        }
        if (llllllllllllllIllllIlIIIIIIlIllI >= 1.0E-30) {
            this.x = Math.sqrt(llllllllllllllIllllIlIIIIIIlIllI);
            llllllllllllllIllllIlIIIIIIlIllI = 0.5 / this.x;
            this.y = llllllllllllllIllllIlIIIIIIlIlII.m10 * llllllllllllllIllllIlIIIIIIlIllI;
            this.z = llllllllllllllIllllIlIIIIIIlIlII.m20 * llllllllllllllIllllIlIIIIIIlIllI;
            return;
        }
        this.x = 0.0;
        llllllllllllllIllllIlIIIIIIlIllI = 0.5 * (1.0 - llllllllllllllIllllIlIIIIIIlIlII.m22);
        if (llllllllllllllIllllIlIIIIIIlIllI >= 1.0E-30) {
            this.y = Math.sqrt(llllllllllllllIllllIlIIIIIIlIllI);
            this.z = llllllllllllllIllllIlIIIIIIlIlII.m21 / (2.0 * this.y);
            return;
        }
        this.y = 0.0;
        this.z = 1.0;
    }
    
    public final void interpolate(final Quat4d llllllllllllllIllllIIlllllllIIIl, final double llllllllllllllIllllIIlllllllIIII) {
        double llllllllllllllIllllIIllllllIllll = this.x * llllllllllllllIllllIIlllllllIIIl.x + this.y * llllllllllllllIllllIIlllllllIIIl.y + this.z * llllllllllllllIllllIIlllllllIIIl.z + this.w * llllllllllllllIllllIIlllllllIIIl.w;
        if (llllllllllllllIllllIIllllllIllll < 0.0) {
            llllllllllllllIllllIIlllllllIIIl.x = -llllllllllllllIllllIIlllllllIIIl.x;
            llllllllllllllIllllIIlllllllIIIl.y = -llllllllllllllIllllIIlllllllIIIl.y;
            llllllllllllllIllllIIlllllllIIIl.z = -llllllllllllllIllllIIlllllllIIIl.z;
            llllllllllllllIllllIIlllllllIIIl.w = -llllllllllllllIllllIIlllllllIIIl.w;
            llllllllllllllIllllIIllllllIllll = -llllllllllllllIllllIIllllllIllll;
        }
        double llllllllllllllIllllIIllllllIllIl = 0.0;
        double llllllllllllllIllllIIllllllIlIll = 0.0;
        if (1.0 - llllllllllllllIllllIIllllllIllll > 1.0E-12) {
            final double llllllllllllllIllllIIllllllIlIlI = Math.acos(llllllllllllllIllllIIllllllIllll);
            final double llllllllllllllIllllIIllllllIlIIl = Math.sin(llllllllllllllIllllIIllllllIlIlI);
            final double llllllllllllllIllllIIllllllIlllI = Math.sin((1.0 - llllllllllllllIllllIIlllllllIIII) * llllllllllllllIllllIIllllllIlIlI) / llllllllllllllIllllIIllllllIlIIl;
            final double llllllllllllllIllllIIllllllIllII = Math.sin(llllllllllllllIllllIIlllllllIIII * llllllllllllllIllllIIllllllIlIlI) / llllllllllllllIllllIIllllllIlIIl;
        }
        else {
            llllllllllllllIllllIIllllllIllIl = 1.0 - llllllllllllllIllllIIlllllllIIII;
            llllllllllllllIllllIIllllllIlIll = llllllllllllllIllllIIlllllllIIII;
        }
        this.w = llllllllllllllIllllIIllllllIllIl * this.w + llllllllllllllIllllIIllllllIlIll * llllllllllllllIllllIIlllllllIIIl.w;
        this.x = llllllllllllllIllllIIllllllIllIl * this.x + llllllllllllllIllllIIllllllIlIll * llllllllllllllIllllIIlllllllIIIl.x;
        this.y = llllllllllllllIllllIIllllllIllIl * this.y + llllllllllllllIllllIIllllllIlIll * llllllllllllllIllllIIlllllllIIIl.y;
        this.z = llllllllllllllIllllIIllllllIllIl * this.z + llllllllllllllIllllIIllllllIlIll * llllllllllllllIllllIIlllllllIIIl.z;
    }
    
    public Quat4d(final Quat4d llllllllllllllIllllIlIIIlIlIllll) {
        super(llllllllllllllIllllIlIIIlIlIllll);
    }
    
    public final void set(final AxisAngle4d llllllllllllllIllllIIlllllllllIl) {
        double llllllllllllllIllllIIlllllllllll = Math.sqrt(llllllllllllllIllllIIlllllllllIl.x * llllllllllllllIllllIIlllllllllIl.x + llllllllllllllIllllIIlllllllllIl.y * llllllllllllllIllllIIlllllllllIl.y + llllllllllllllIllllIIlllllllllIl.z * llllllllllllllIllllIIlllllllllIl.z);
        if (llllllllllllllIllllIIlllllllllll < 1.0E-12) {
            this.w = 0.0;
            this.x = 0.0;
            this.y = 0.0;
            this.z = 0.0;
        }
        else {
            llllllllllllllIllllIIlllllllllll = 1.0 / llllllllllllllIllllIIlllllllllll;
            final double llllllllllllllIllllIlIIIIIIIIIII = Math.sin(llllllllllllllIllllIIlllllllllIl.angle / 2.0);
            this.w = Math.cos(llllllllllllllIllllIIlllllllllIl.angle / 2.0);
            this.x = llllllllllllllIllllIIlllllllllIl.x * llllllllllllllIllllIIlllllllllll * llllllllllllllIllllIlIIIIIIIIIII;
            this.y = llllllllllllllIllllIIlllllllllIl.y * llllllllllllllIllllIIlllllllllll * llllllllllllllIllllIlIIIIIIIIIII;
            this.z = llllllllllllllIllllIIlllllllllIl.z * llllllllllllllIllllIIlllllllllll * llllllllllllllIllllIlIIIIIIIIIII;
        }
    }
    
    public final void normalize(final Quat4d llllllllllllllIllllIlIIIIIlllllI) {
        double llllllllllllllIllllIlIIIIlIIIIII = llllllllllllllIllllIlIIIIIlllllI.x * llllllllllllllIllllIlIIIIIlllllI.x + llllllllllllllIllllIlIIIIIlllllI.y * llllllllllllllIllllIlIIIIIlllllI.y + llllllllllllllIllllIlIIIIIlllllI.z * llllllllllllllIllllIlIIIIIlllllI.z + llllllllllllllIllllIlIIIIIlllllI.w * llllllllllllllIllllIlIIIIIlllllI.w;
        if (llllllllllllllIllllIlIIIIlIIIIII > 0.0) {
            llllllllllllllIllllIlIIIIlIIIIII = 1.0 / Math.sqrt(llllllllllllllIllllIlIIIIlIIIIII);
            this.x = llllllllllllllIllllIlIIIIlIIIIII * llllllllllllllIllllIlIIIIIlllllI.x;
            this.y = llllllllllllllIllllIlIIIIlIIIIII * llllllllllllllIllllIlIIIIIlllllI.y;
            this.z = llllllllllllllIllllIlIIIIlIIIIII * llllllllllllllIllllIlIIIIIlllllI.z;
            this.w = llllllllllllllIllllIlIIIIlIIIIII * llllllllllllllIllllIlIIIIIlllllI.w;
        }
        else {
            this.x = 0.0;
            this.y = 0.0;
            this.z = 0.0;
            this.w = 0.0;
        }
    }
    
    public final void set(final AxisAngle4f llllllllllllllIllllIlIIIIIIIllIl) {
        double llllllllllllllIllllIlIIIIIIIlIll = Math.sqrt(llllllllllllllIllllIlIIIIIIIllIl.x * llllllllllllllIllllIlIIIIIIIllIl.x + llllllllllllllIllllIlIIIIIIIllIl.y * llllllllllllllIllllIlIIIIIIIllIl.y + llllllllllllllIllllIlIIIIIIIllIl.z * llllllllllllllIllllIlIIIIIIIllIl.z);
        if (llllllllllllllIllllIlIIIIIIIlIll < 1.0E-12) {
            this.w = 0.0;
            this.x = 0.0;
            this.y = 0.0;
            this.z = 0.0;
        }
        else {
            final double llllllllllllllIllllIlIIIIIIIllII = Math.sin(llllllllllllllIllllIlIIIIIIIllIl.angle / 2.0);
            llllllllllllllIllllIlIIIIIIIlIll = 1.0 / llllllllllllllIllllIlIIIIIIIlIll;
            this.w = Math.cos(llllllllllllllIllllIlIIIIIIIllIl.angle / 2.0);
            this.x = llllllllllllllIllllIlIIIIIIIllIl.x * llllllllllllllIllllIlIIIIIIIlIll * llllllllllllllIllllIlIIIIIIIllII;
            this.y = llllllllllllllIllllIlIIIIIIIllIl.y * llllllllllllllIllllIlIIIIIIIlIll * llllllllllllllIllllIlIIIIIIIllII;
            this.z = llllllllllllllIllllIlIIIIIIIllIl.z * llllllllllllllIllllIlIIIIIIIlIll * llllllllllllllIllllIlIIIIIIIllII;
        }
    }
    
    public final void conjugate() {
        this.x = -this.x;
        this.y = -this.y;
        this.z = -this.z;
    }
    
    public Quat4d(final Tuple4d llllllllllllllIllllIlIIIlIIllIII) {
        final double llllllllllllllIllllIlIIIlIIllIlI = 1.0 / Math.sqrt(llllllllllllllIllllIlIIIlIIllIII.x * llllllllllllllIllllIlIIIlIIllIII.x + llllllllllllllIllllIlIIIlIIllIII.y * llllllllllllllIllllIlIIIlIIllIII.y + llllllllllllllIllllIlIIIlIIllIII.z * llllllllllllllIllllIlIIIlIIllIII.z + llllllllllllllIllllIlIIIlIIllIII.w * llllllllllllllIllllIlIIIlIIllIII.w);
        this.x = llllllllllllllIllllIlIIIlIIllIII.x * llllllllllllllIllllIlIIIlIIllIlI;
        this.y = llllllllllllllIllllIlIIIlIIllIII.y * llllllllllllllIllllIlIIIlIIllIlI;
        this.z = llllllllllllllIllllIlIIIlIIllIII.z * llllllllllllllIllllIlIIIlIIllIlI;
        this.w = llllllllllllllIllllIlIIIlIIllIII.w * llllllllllllllIllllIlIIIlIIllIlI;
    }
    
    public final void interpolate(final Quat4d llllllllllllllIllllIIlllllIIlIll, final Quat4d llllllllllllllIllllIIlllllIlIlIl, final double llllllllllllllIllllIIlllllIIlIIl) {
        double llllllllllllllIllllIIlllllIlIIll = llllllllllllllIllllIIlllllIlIlIl.x * llllllllllllllIllllIIlllllIIlIll.x + llllllllllllllIllllIIlllllIlIlIl.y * llllllllllllllIllllIIlllllIIlIll.y + llllllllllllllIllllIIlllllIlIlIl.z * llllllllllllllIllllIIlllllIIlIll.z + llllllllllllllIllllIIlllllIlIlIl.w * llllllllllllllIllllIIlllllIIlIll.w;
        if (llllllllllllllIllllIIlllllIlIIll < 0.0) {
            llllllllllllllIllllIIlllllIIlIll.x = -llllllllllllllIllllIIlllllIIlIll.x;
            llllllllllllllIllllIIlllllIIlIll.y = -llllllllllllllIllllIIlllllIIlIll.y;
            llllllllllllllIllllIIlllllIIlIll.z = -llllllllllllllIllllIIlllllIIlIll.z;
            llllllllllllllIllllIIlllllIIlIll.w = -llllllllllllllIllllIIlllllIIlIll.w;
            llllllllllllllIllllIIlllllIlIIll = -llllllllllllllIllllIIlllllIlIIll;
        }
        double llllllllllllllIllllIIlllllIlIIIl = 0.0;
        double llllllllllllllIllllIIlllllIIllll = 0.0;
        if (1.0 - llllllllllllllIllllIIlllllIlIIll > 1.0E-12) {
            final double llllllllllllllIllllIIlllllIIlllI = Math.acos(llllllllllllllIllllIIlllllIlIIll);
            final double llllllllllllllIllllIIlllllIIllIl = Math.sin(llllllllllllllIllllIIlllllIIlllI);
            final double llllllllllllllIllllIIlllllIlIIlI = Math.sin((1.0 - llllllllllllllIllllIIlllllIIlIIl) * llllllllllllllIllllIIlllllIIlllI) / llllllllllllllIllllIIlllllIIllIl;
            final double llllllllllllllIllllIIlllllIlIIII = Math.sin(llllllllllllllIllllIIlllllIIlIIl * llllllllllllllIllllIIlllllIIlllI) / llllllllllllllIllllIIlllllIIllIl;
        }
        else {
            llllllllllllllIllllIIlllllIlIIIl = 1.0 - llllllllllllllIllllIIlllllIIlIIl;
            llllllllllllllIllllIIlllllIIllll = llllllllllllllIllllIIlllllIIlIIl;
        }
        this.w = llllllllllllllIllllIIlllllIlIIIl * llllllllllllllIllllIIlllllIIlIll.w + llllllllllllllIllllIIlllllIIllll * llllllllllllllIllllIIlllllIlIlIl.w;
        this.x = llllllllllllllIllllIIlllllIlIIIl * llllllllllllllIllllIIlllllIIlIll.x + llllllllllllllIllllIIlllllIIllll * llllllllllllllIllllIIlllllIlIlIl.x;
        this.y = llllllllllllllIllllIIlllllIlIIIl * llllllllllllllIllllIIlllllIIlIll.y + llllllllllllllIllllIIlllllIIllll * llllllllllllllIllllIIlllllIlIlIl.y;
        this.z = llllllllllllllIllllIIlllllIlIIIl * llllllllllllllIllllIIlllllIIlIll.z + llllllllllllllIllllIIlllllIIllll * llllllllllllllIllllIIlllllIlIlIl.z;
    }
    
    public final void conjugate(final Quat4d llllllllllllllIllllIlIIIlIIlIIII) {
        this.x = -llllllllllllllIllllIlIIIlIIlIIII.x;
        this.y = -llllllllllllllIllllIlIIIlIIlIIII.y;
        this.z = -llllllllllllllIllllIlIIIlIIlIIII.z;
        this.w = llllllllllllllIllllIlIIIlIIlIIII.w;
    }
    
    public final void mul(final Quat4d llllllllllllllIllllIlIIIlIIIIIll, final Quat4d llllllllllllllIllllIlIIIlIIIIIlI) {
        if (this != llllllllllllllIllllIlIIIlIIIIIll && this != llllllllllllllIllllIlIIIlIIIIIlI) {
            this.w = llllllllllllllIllllIlIIIlIIIIIll.w * llllllllllllllIllllIlIIIlIIIIIlI.w - llllllllllllllIllllIlIIIlIIIIIll.x * llllllllllllllIllllIlIIIlIIIIIlI.x - llllllllllllllIllllIlIIIlIIIIIll.y * llllllllllllllIllllIlIIIlIIIIIlI.y - llllllllllllllIllllIlIIIlIIIIIll.z * llllllllllllllIllllIlIIIlIIIIIlI.z;
            this.x = llllllllllllllIllllIlIIIlIIIIIll.w * llllllllllllllIllllIlIIIlIIIIIlI.x + llllllllllllllIllllIlIIIlIIIIIlI.w * llllllllllllllIllllIlIIIlIIIIIll.x + llllllllllllllIllllIlIIIlIIIIIll.y * llllllllllllllIllllIlIIIlIIIIIlI.z - llllllllllllllIllllIlIIIlIIIIIll.z * llllllllllllllIllllIlIIIlIIIIIlI.y;
            this.y = llllllllllllllIllllIlIIIlIIIIIll.w * llllllllllllllIllllIlIIIlIIIIIlI.y + llllllllllllllIllllIlIIIlIIIIIlI.w * llllllllllllllIllllIlIIIlIIIIIll.y - llllllllllllllIllllIlIIIlIIIIIll.x * llllllllllllllIllllIlIIIlIIIIIlI.z + llllllllllllllIllllIlIIIlIIIIIll.z * llllllllllllllIllllIlIIIlIIIIIlI.x;
            this.z = llllllllllllllIllllIlIIIlIIIIIll.w * llllllllllllllIllllIlIIIlIIIIIlI.z + llllllllllllllIllllIlIIIlIIIIIlI.w * llllllllllllllIllllIlIIIlIIIIIll.z + llllllllllllllIllllIlIIIlIIIIIll.x * llllllllllllllIllllIlIIIlIIIIIlI.y - llllllllllllllIllllIlIIIlIIIIIll.y * llllllllllllllIllllIlIIIlIIIIIlI.x;
        }
        else {
            final double llllllllllllllIllllIlIIIIlllllll = llllllllllllllIllllIlIIIlIIIIIll.w * llllllllllllllIllllIlIIIlIIIIIlI.w - llllllllllllllIllllIlIIIlIIIIIll.x * llllllllllllllIllllIlIIIlIIIIIlI.x - llllllllllllllIllllIlIIIlIIIIIll.y * llllllllllllllIllllIlIIIlIIIIIlI.y - llllllllllllllIllllIlIIIlIIIIIll.z * llllllllllllllIllllIlIIIlIIIIIlI.z;
            final double llllllllllllllIllllIlIIIlIIIIIIl = llllllllllllllIllllIlIIIlIIIIIll.w * llllllllllllllIllllIlIIIlIIIIIlI.x + llllllllllllllIllllIlIIIlIIIIIlI.w * llllllllllllllIllllIlIIIlIIIIIll.x + llllllllllllllIllllIlIIIlIIIIIll.y * llllllllllllllIllllIlIIIlIIIIIlI.z - llllllllllllllIllllIlIIIlIIIIIll.z * llllllllllllllIllllIlIIIlIIIIIlI.y;
            final double llllllllllllllIllllIlIIIlIIIIIII = llllllllllllllIllllIlIIIlIIIIIll.w * llllllllllllllIllllIlIIIlIIIIIlI.y + llllllllllllllIllllIlIIIlIIIIIlI.w * llllllllllllllIllllIlIIIlIIIIIll.y - llllllllllllllIllllIlIIIlIIIIIll.x * llllllllllllllIllllIlIIIlIIIIIlI.z + llllllllllllllIllllIlIIIlIIIIIll.z * llllllllllllllIllllIlIIIlIIIIIlI.x;
            this.z = llllllllllllllIllllIlIIIlIIIIIll.w * llllllllllllllIllllIlIIIlIIIIIlI.z + llllllllllllllIllllIlIIIlIIIIIlI.w * llllllllllllllIllllIlIIIlIIIIIll.z + llllllllllllllIllllIlIIIlIIIIIll.x * llllllllllllllIllllIlIIIlIIIIIlI.y - llllllllllllllIllllIlIIIlIIIIIll.y * llllllllllllllIllllIlIIIlIIIIIlI.x;
            this.w = llllllllllllllIllllIlIIIIlllllll;
            this.x = llllllllllllllIllllIlIIIlIIIIIIl;
            this.y = llllllllllllllIllllIlIIIlIIIIIII;
        }
    }
    
    public final void mul(final Quat4d llllllllllllllIllllIlIIIIllIllIl) {
        final double llllllllllllllIllllIlIIIIllIllll = this.w * llllllllllllllIllllIlIIIIllIllIl.w - this.x * llllllllllllllIllllIlIIIIllIllIl.x - this.y * llllllllllllllIllllIlIIIIllIllIl.y - this.z * llllllllllllllIllllIlIIIIllIllIl.z;
        final double llllllllllllllIllllIlIIIIlllIIIl = this.w * llllllllllllllIllllIlIIIIllIllIl.x + llllllllllllllIllllIlIIIIllIllIl.w * this.x + this.y * llllllllllllllIllllIlIIIIllIllIl.z - this.z * llllllllllllllIllllIlIIIIllIllIl.y;
        final double llllllllllllllIllllIlIIIIlllIIII = this.w * llllllllllllllIllllIlIIIIllIllIl.y + llllllllllllllIllllIlIIIIllIllIl.w * this.y - this.x * llllllllllllllIllllIlIIIIllIllIl.z + this.z * llllllllllllllIllllIlIIIIllIllIl.x;
        this.z = this.w * llllllllllllllIllllIlIIIIllIllIl.z + llllllllllllllIllllIlIIIIllIllIl.w * this.z + this.x * llllllllllllllIllllIlIIIIllIllIl.y - this.y * llllllllllllllIllllIlIIIIllIllIl.x;
        this.w = llllllllllllllIllllIlIIIIllIllll;
        this.x = llllllllllllllIllllIlIIIIlllIIIl;
        this.y = llllllllllllllIllllIlIIIIlllIIII;
    }
    
    public final void set(final Matrix4f llllllllllllllIllllIlIIIIIlIllll) {
        double llllllllllllllIllllIlIIIIIllIIIl = 0.25 * (llllllllllllllIllllIlIIIIIlIllll.m00 + llllllllllllllIllllIlIIIIIlIllll.m11 + llllllllllllllIllllIlIIIIIlIllll.m22 + llllllllllllllIllllIlIIIIIlIllll.m33);
        if (llllllllllllllIllllIlIIIIIllIIIl < 0.0) {
            this.w = 0.0;
            this.x = 0.0;
            this.y = 0.0;
            this.z = 1.0;
            return;
        }
        if (llllllllllllllIllllIlIIIIIllIIIl >= 1.0E-30) {
            this.w = Math.sqrt(llllllllllllllIllllIlIIIIIllIIIl);
            llllllllllllllIllllIlIIIIIllIIIl = 0.25 / this.w;
            this.x = (llllllllllllllIllllIlIIIIIlIllll.m21 - llllllllllllllIllllIlIIIIIlIllll.m12) * llllllllllllllIllllIlIIIIIllIIIl;
            this.y = (llllllllllllllIllllIlIIIIIlIllll.m02 - llllllllllllllIllllIlIIIIIlIllll.m20) * llllllllllllllIllllIlIIIIIllIIIl;
            this.z = (llllllllllllllIllllIlIIIIIlIllll.m10 - llllllllllllllIllllIlIIIIIlIllll.m01) * llllllllllllllIllllIlIIIIIllIIIl;
            return;
        }
        this.w = 0.0;
        llllllllllllllIllllIlIIIIIllIIIl = -0.5 * (llllllllllllllIllllIlIIIIIlIllll.m11 + llllllllllllllIllllIlIIIIIlIllll.m22);
        if (llllllllllllllIllllIlIIIIIllIIIl < 0.0) {
            this.x = 0.0;
            this.y = 0.0;
            this.z = 1.0;
            return;
        }
        if (llllllllllllllIllllIlIIIIIllIIIl >= 1.0E-30) {
            this.x = Math.sqrt(llllllllllllllIllllIlIIIIIllIIIl);
            llllllllllllllIllllIlIIIIIllIIIl = 1.0 / (2.0 * this.x);
            this.y = llllllllllllllIllllIlIIIIIlIllll.m10 * llllllllllllllIllllIlIIIIIllIIIl;
            this.z = llllllllllllllIllllIlIIIIIlIllll.m20 * llllllllllllllIllllIlIIIIIllIIIl;
            return;
        }
        this.x = 0.0;
        llllllllllllllIllllIlIIIIIllIIIl = 0.5 * (1.0 - llllllllllllllIllllIlIIIIIlIllll.m22);
        if (llllllllllllllIllllIlIIIIIllIIIl >= 1.0E-30) {
            this.y = Math.sqrt(llllllllllllllIllllIlIIIIIllIIIl);
            this.z = llllllllllllllIllllIlIIIIIlIllll.m21 / (2.0 * this.y);
            return;
        }
        this.y = 0.0;
        this.z = 1.0;
    }
    
    public Quat4d() {
    }
    
    public final void normalize() {
        double llllllllllllllIllllIlIIIIIlllIIl = this.x * this.x + this.y * this.y + this.z * this.z + this.w * this.w;
        if (llllllllllllllIllllIlIIIIIlllIIl > 0.0) {
            llllllllllllllIllllIlIIIIIlllIIl = 1.0 / Math.sqrt(llllllllllllllIllllIlIIIIIlllIIl);
            this.x *= llllllllllllllIllllIlIIIIIlllIIl;
            this.y *= llllllllllllllIllllIlIIIIIlllIIl;
            this.z *= llllllllllllllIllllIlIIIIIlllIIl;
            this.w *= llllllllllllllIllllIlIIIIIlllIIl;
        }
        else {
            this.x = 0.0;
            this.y = 0.0;
            this.z = 0.0;
            this.w = 0.0;
        }
    }
    
    public Quat4d(final double[] llllllllllllllIllllIlIIIlIllIllI) {
        final double llllllllllllllIllllIlIIIlIlllIII = 1.0 / Math.sqrt(llllllllllllllIllllIlIIIlIllIllI[0] * llllllllllllllIllllIlIIIlIllIllI[0] + llllllllllllllIllllIlIIIlIllIllI[1] * llllllllllllllIllllIlIIIlIllIllI[1] + llllllllllllllIllllIlIIIlIllIllI[2] * llllllllllllllIllllIlIIIlIllIllI[2] + llllllllllllllIllllIlIIIlIllIllI[3] * llllllllllllllIllllIlIIIlIllIllI[3]);
        this.x = llllllllllllllIllllIlIIIlIllIllI[0] * llllllllllllllIllllIlIIIlIlllIII;
        this.y = llllllllllllllIllllIlIIIlIllIllI[1] * llllllllllllllIllllIlIIIlIlllIII;
        this.z = llllllllllllllIllllIlIIIlIllIllI[2] * llllllllllllllIllllIlIIIlIlllIII;
        this.w = llllllllllllllIllllIlIIIlIllIllI[3] * llllllllllllllIllllIlIIIlIlllIII;
    }
}
