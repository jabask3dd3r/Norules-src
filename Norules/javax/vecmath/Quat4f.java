package javax.vecmath;

import java.io.*;

public class Quat4f extends Tuple4f implements Serializable
{
    public final void set(final AxisAngle4f lllllllllllllllllIIllIIlIIlIlIll) {
        float lllllllllllllllllIIllIIlIIlIlIIl = (float)Math.sqrt(lllllllllllllllllIIllIIlIIlIlIll.x * lllllllllllllllllIIllIIlIIlIlIll.x + lllllllllllllllllIIllIIlIIlIlIll.y * lllllllllllllllllIIllIIlIIlIlIll.y + lllllllllllllllllIIllIIlIIlIlIll.z * lllllllllllllllllIIllIIlIIlIlIll.z);
        if (lllllllllllllllllIIllIIlIIlIlIIl < 1.0E-6) {
            this.w = 0.0f;
            this.x = 0.0f;
            this.y = 0.0f;
            this.z = 0.0f;
        }
        else {
            lllllllllllllllllIIllIIlIIlIlIIl = 1.0f / lllllllllllllllllIIllIIlIIlIlIIl;
            final float lllllllllllllllllIIllIIlIIlIlIlI = (float)Math.sin(lllllllllllllllllIIllIIlIIlIlIll.angle / 2.0);
            this.w = (float)Math.cos(lllllllllllllllllIIllIIlIIlIlIll.angle / 2.0);
            this.x = lllllllllllllllllIIllIIlIIlIlIll.x * lllllllllllllllllIIllIIlIIlIlIIl * lllllllllllllllllIIllIIlIIlIlIlI;
            this.y = lllllllllllllllllIIllIIlIIlIlIll.y * lllllllllllllllllIIllIIlIIlIlIIl * lllllllllllllllllIIllIIlIIlIlIlI;
            this.z = lllllllllllllllllIIllIIlIIlIlIll.z * lllllllllllllllllIIllIIlIIlIlIIl * lllllllllllllllllIIllIIlIIlIlIlI;
        }
    }
    
    public Quat4f(final Quat4f lllllllllllllllllIIllIIlllIIllll) {
        super(lllllllllllllllllIIllIIlllIIllll);
    }
    
    public final void inverse() {
        final float lllllllllllllllllIIllIIlIllIIllI = 1.0f / (this.w * this.w + this.x * this.x + this.y * this.y + this.z * this.z);
        this.w *= lllllllllllllllllIIllIIlIllIIllI;
        this.x *= -lllllllllllllllllIIllIIlIllIIllI;
        this.y *= -lllllllllllllllllIIllIIlIllIIllI;
        this.z *= -lllllllllllllllllIIllIIlIllIIllI;
    }
    
    public Quat4f(final float lllllllllllllllllIIllIIllllIIllI, final float lllllllllllllllllIIllIIllllIIlIl, final float lllllllllllllllllIIllIIlllIllllI, final float lllllllllllllllllIIllIIlllIlllIl) {
        final float lllllllllllllllllIIllIIllllIIIlI = (float)(1.0 / Math.sqrt(lllllllllllllllllIIllIIllllIIllI * lllllllllllllllllIIllIIllllIIllI + lllllllllllllllllIIllIIllllIIlIl * lllllllllllllllllIIllIIllllIIlIl + lllllllllllllllllIIllIIlllIllllI * lllllllllllllllllIIllIIlllIllllI + lllllllllllllllllIIllIIlllIlllIl * lllllllllllllllllIIllIIlllIlllIl));
        this.x = lllllllllllllllllIIllIIllllIIllI * lllllllllllllllllIIllIIllllIIIlI;
        this.y = lllllllllllllllllIIllIIllllIIlIl * lllllllllllllllllIIllIIllllIIIlI;
        this.z = lllllllllllllllllIIllIIlllIllllI * lllllllllllllllllIIllIIllllIIIlI;
        this.w = lllllllllllllllllIIllIIlllIlllIl * lllllllllllllllllIIllIIllllIIIlI;
    }
    
    public final void inverse(final Quat4f lllllllllllllllllIIllIIlIllIlllI) {
        final float lllllllllllllllllIIllIIlIllIllIl = 1.0f / (lllllllllllllllllIIllIIlIllIlllI.w * lllllllllllllllllIIllIIlIllIlllI.w + lllllllllllllllllIIllIIlIllIlllI.x * lllllllllllllllllIIllIIlIllIlllI.x + lllllllllllllllllIIllIIlIllIlllI.y * lllllllllllllllllIIllIIlIllIlllI.y + lllllllllllllllllIIllIIlIllIlllI.z * lllllllllllllllllIIllIIlIllIlllI.z);
        this.w = lllllllllllllllllIIllIIlIllIllIl * lllllllllllllllllIIllIIlIllIlllI.w;
        this.x = -lllllllllllllllllIIllIIlIllIllIl * lllllllllllllllllIIllIIlIllIlllI.x;
        this.y = -lllllllllllllllllIIllIIlIllIllIl * lllllllllllllllllIIllIIlIllIlllI.y;
        this.z = -lllllllllllllllllIIllIIlIllIllIl * lllllllllllllllllIIllIIlIllIlllI.z;
    }
    
    public Quat4f(final float[] lllllllllllllllllIIllIIlllIlIlII) {
        final float lllllllllllllllllIIllIIlllIlIllI = (float)(1.0 / Math.sqrt(lllllllllllllllllIIllIIlllIlIlII[0] * lllllllllllllllllIIllIIlllIlIlII[0] + lllllllllllllllllIIllIIlllIlIlII[1] * lllllllllllllllllIIllIIlllIlIlII[1] + lllllllllllllllllIIllIIlllIlIlII[2] * lllllllllllllllllIIllIIlllIlIlII[2] + lllllllllllllllllIIllIIlllIlIlII[3] * lllllllllllllllllIIllIIlllIlIlII[3]));
        this.x = lllllllllllllllllIIllIIlllIlIlII[0] * lllllllllllllllllIIllIIlllIlIllI;
        this.y = lllllllllllllllllIIllIIlllIlIlII[1] * lllllllllllllllllIIllIIlllIlIllI;
        this.z = lllllllllllllllllIIllIIlllIlIlII[2] * lllllllllllllllllIIllIIlllIlIllI;
        this.w = lllllllllllllllllIIllIIlllIlIlII[3] * lllllllllllllllllIIllIIlllIlIllI;
    }
    
    public Quat4f(final Quat4d lllllllllllllllllIIllIIlllIIlIIl) {
        super(lllllllllllllllllIIllIIlllIIlIIl);
    }
    
    public final void set(final Matrix4d lllllllllllllllllIIllIIlIlIIIlll) {
        double lllllllllllllllllIIllIIlIlIIIllI = 0.25 * (lllllllllllllllllIIllIIlIlIIIlll.m00 + lllllllllllllllllIIllIIlIlIIIlll.m11 + lllllllllllllllllIIllIIlIlIIIlll.m22 + lllllllllllllllllIIllIIlIlIIIlll.m33);
        if (lllllllllllllllllIIllIIlIlIIIllI < 0.0) {
            this.w = 0.0f;
            this.x = 0.0f;
            this.y = 0.0f;
            this.z = 1.0f;
            return;
        }
        if (lllllllllllllllllIIllIIlIlIIIllI >= 1.0E-30) {
            this.w = (float)Math.sqrt(lllllllllllllllllIIllIIlIlIIIllI);
            lllllllllllllllllIIllIIlIlIIIllI = 0.25 / this.w;
            this.x = (float)((lllllllllllllllllIIllIIlIlIIIlll.m21 - lllllllllllllllllIIllIIlIlIIIlll.m12) * lllllllllllllllllIIllIIlIlIIIllI);
            this.y = (float)((lllllllllllllllllIIllIIlIlIIIlll.m02 - lllllllllllllllllIIllIIlIlIIIlll.m20) * lllllllllllllllllIIllIIlIlIIIllI);
            this.z = (float)((lllllllllllllllllIIllIIlIlIIIlll.m10 - lllllllllllllllllIIllIIlIlIIIlll.m01) * lllllllllllllllllIIllIIlIlIIIllI);
            return;
        }
        this.w = 0.0f;
        lllllllllllllllllIIllIIlIlIIIllI = -0.5 * (lllllllllllllllllIIllIIlIlIIIlll.m11 + lllllllllllllllllIIllIIlIlIIIlll.m22);
        if (lllllllllllllllllIIllIIlIlIIIllI < 0.0) {
            this.x = 0.0f;
            this.y = 0.0f;
            this.z = 1.0f;
            return;
        }
        if (lllllllllllllllllIIllIIlIlIIIllI >= 1.0E-30) {
            this.x = (float)Math.sqrt(lllllllllllllllllIIllIIlIlIIIllI);
            lllllllllllllllllIIllIIlIlIIIllI = 0.5 / this.x;
            this.y = (float)(lllllllllllllllllIIllIIlIlIIIlll.m10 * lllllllllllllllllIIllIIlIlIIIllI);
            this.z = (float)(lllllllllllllllllIIllIIlIlIIIlll.m20 * lllllllllllllllllIIllIIlIlIIIllI);
            return;
        }
        this.x = 0.0f;
        lllllllllllllllllIIllIIlIlIIIllI = 0.5 * (1.0 - lllllllllllllllllIIllIIlIlIIIlll.m22);
        if (lllllllllllllllllIIllIIlIlIIIllI >= 1.0E-30) {
            this.y = (float)Math.sqrt(lllllllllllllllllIIllIIlIlIIIllI);
            this.z = (float)(lllllllllllllllllIIllIIlIlIIIlll.m21 / (2.0 * this.y));
            return;
        }
        this.y = 0.0f;
        this.z = 1.0f;
    }
    
    public Quat4f(final Tuple4d lllllllllllllllllIIllIIllIlllIIl) {
        final double lllllllllllllllllIIllIIllIlllIII = 1.0 / Math.sqrt(lllllllllllllllllIIllIIllIlllIIl.x * lllllllllllllllllIIllIIllIlllIIl.x + lllllllllllllllllIIllIIllIlllIIl.y * lllllllllllllllllIIllIIllIlllIIl.y + lllllllllllllllllIIllIIllIlllIIl.z * lllllllllllllllllIIllIIllIlllIIl.z + lllllllllllllllllIIllIIllIlllIIl.w * lllllllllllllllllIIllIIllIlllIIl.w);
        this.x = (float)(lllllllllllllllllIIllIIllIlllIIl.x * lllllllllllllllllIIllIIllIlllIII);
        this.y = (float)(lllllllllllllllllIIllIIllIlllIIl.y * lllllllllllllllllIIllIIllIlllIII);
        this.z = (float)(lllllllllllllllllIIllIIllIlllIIl.z * lllllllllllllllllIIllIIllIlllIII);
        this.w = (float)(lllllllllllllllllIIllIIllIlllIIl.w * lllllllllllllllllIIllIIllIlllIII);
    }
    
    public final void interpolate(final Quat4f lllllllllllllllllIIllIIIllllIlII, final Quat4f lllllllllllllllllIIllIIIlllIlIII, final float lllllllllllllllllIIllIIIllllIIlI) {
        double lllllllllllllllllIIllIIIllllIIIl = lllllllllllllllllIIllIIIlllIlIII.x * lllllllllllllllllIIllIIIllllIlII.x + lllllllllllllllllIIllIIIlllIlIII.y * lllllllllllllllllIIllIIIllllIlII.y + lllllllllllllllllIIllIIIlllIlIII.z * lllllllllllllllllIIllIIIllllIlII.z + lllllllllllllllllIIllIIIlllIlIII.w * lllllllllllllllllIIllIIIllllIlII.w;
        if (lllllllllllllllllIIllIIIllllIIIl < 0.0) {
            lllllllllllllllllIIllIIIllllIlII.x = -lllllllllllllllllIIllIIIllllIlII.x;
            lllllllllllllllllIIllIIIllllIlII.y = -lllllllllllllllllIIllIIIllllIlII.y;
            lllllllllllllllllIIllIIIllllIlII.z = -lllllllllllllllllIIllIIIllllIlII.z;
            lllllllllllllllllIIllIIIllllIlII.w = -lllllllllllllllllIIllIIIllllIlII.w;
            lllllllllllllllllIIllIIIllllIIIl = -lllllllllllllllllIIllIIIllllIIIl;
        }
        double lllllllllllllllllIIllIIIlllIllll = 0.0;
        double lllllllllllllllllIIllIIIlllIllIl = 0.0;
        if (1.0 - lllllllllllllllllIIllIIIllllIIIl > 1.0E-6) {
            final double lllllllllllllllllIIllIIIlllIllII = Math.acos(lllllllllllllllllIIllIIIllllIIIl);
            final double lllllllllllllllllIIllIIIlllIlIll = Math.sin(lllllllllllllllllIIllIIIlllIllII);
            final double lllllllllllllllllIIllIIIllllIIII = Math.sin((1.0 - lllllllllllllllllIIllIIIllllIIlI) * lllllllllllllllllIIllIIIlllIllII) / lllllllllllllllllIIllIIIlllIlIll;
            final double lllllllllllllllllIIllIIIlllIlllI = Math.sin(lllllllllllllllllIIllIIIllllIIlI * lllllllllllllllllIIllIIIlllIllII) / lllllllllllllllllIIllIIIlllIlIll;
        }
        else {
            lllllllllllllllllIIllIIIlllIllll = 1.0 - lllllllllllllllllIIllIIIllllIIlI;
            lllllllllllllllllIIllIIIlllIllIl = lllllllllllllllllIIllIIIllllIIlI;
        }
        this.w = (float)(lllllllllllllllllIIllIIIlllIllll * lllllllllllllllllIIllIIIllllIlII.w + lllllllllllllllllIIllIIIlllIllIl * lllllllllllllllllIIllIIIlllIlIII.w);
        this.x = (float)(lllllllllllllllllIIllIIIlllIllll * lllllllllllllllllIIllIIIllllIlII.x + lllllllllllllllllIIllIIIlllIllIl * lllllllllllllllllIIllIIIlllIlIII.x);
        this.y = (float)(lllllllllllllllllIIllIIIlllIllll * lllllllllllllllllIIllIIIllllIlII.y + lllllllllllllllllIIllIIIlllIllIl * lllllllllllllllllIIllIIIlllIlIII.y);
        this.z = (float)(lllllllllllllllllIIllIIIlllIllll * lllllllllllllllllIIllIIIllllIlII.z + lllllllllllllllllIIllIIIlllIllIl * lllllllllllllllllIIllIIIlllIlIII.z);
    }
    
    public final void mulInverse(final Quat4f lllllllllllllllllIIllIIlIlllIlII) {
        final Quat4f lllllllllllllllllIIllIIlIlllIllI = new Quat4f(lllllllllllllllllIIllIIlIlllIlII);
        lllllllllllllllllIIllIIlIlllIllI.inverse();
        this.mul(lllllllllllllllllIIllIIlIlllIllI);
    }
    
    public final void mulInverse(final Quat4f lllllllllllllllllIIllIIllIIIIIlI, final Quat4f lllllllllllllllllIIllIIllIIIIIIl) {
        final Quat4f lllllllllllllllllIIllIIllIIIIIII = new Quat4f(lllllllllllllllllIIllIIllIIIIIIl);
        lllllllllllllllllIIllIIllIIIIIII.inverse();
        this.mul(lllllllllllllllllIIllIIllIIIIIlI, lllllllllllllllllIIllIIllIIIIIII);
    }
    
    public final void mul(final Quat4f lllllllllllllllllIIllIIllIIIlIll) {
        final float lllllllllllllllllIIllIIllIIIllIl = this.w * lllllllllllllllllIIllIIllIIIlIll.w - this.x * lllllllllllllllllIIllIIllIIIlIll.x - this.y * lllllllllllllllllIIllIIllIIIlIll.y - this.z * lllllllllllllllllIIllIIllIIIlIll.z;
        final float lllllllllllllllllIIllIIllIIIllll = this.w * lllllllllllllllllIIllIIllIIIlIll.x + lllllllllllllllllIIllIIllIIIlIll.w * this.x + this.y * lllllllllllllllllIIllIIllIIIlIll.z - this.z * lllllllllllllllllIIllIIllIIIlIll.y;
        final float lllllllllllllllllIIllIIllIIIlllI = this.w * lllllllllllllllllIIllIIllIIIlIll.y + lllllllllllllllllIIllIIllIIIlIll.w * this.y - this.x * lllllllllllllllllIIllIIllIIIlIll.z + this.z * lllllllllllllllllIIllIIllIIIlIll.x;
        this.z = this.w * lllllllllllllllllIIllIIllIIIlIll.z + lllllllllllllllllIIllIIllIIIlIll.w * this.z + this.x * lllllllllllllllllIIllIIllIIIlIll.y - this.y * lllllllllllllllllIIllIIllIIIlIll.x;
        this.w = lllllllllllllllllIIllIIllIIIllIl;
        this.x = lllllllllllllllllIIllIIllIIIllll;
        this.y = lllllllllllllllllIIllIIllIIIlllI;
    }
    
    public Quat4f(final Tuple4f lllllllllllllllllIIllIIllIllllll) {
        final float lllllllllllllllllIIllIIlllIIIIIl = (float)(1.0 / Math.sqrt(lllllllllllllllllIIllIIllIllllll.x * lllllllllllllllllIIllIIllIllllll.x + lllllllllllllllllIIllIIllIllllll.y * lllllllllllllllllIIllIIllIllllll.y + lllllllllllllllllIIllIIllIllllll.z * lllllllllllllllllIIllIIllIllllll.z + lllllllllllllllllIIllIIllIllllll.w * lllllllllllllllllIIllIIllIllllll.w));
        this.x = lllllllllllllllllIIllIIllIllllll.x * lllllllllllllllllIIllIIlllIIIIIl;
        this.y = lllllllllllllllllIIllIIllIllllll.y * lllllllllllllllllIIllIIlllIIIIIl;
        this.z = lllllllllllllllllIIllIIllIllllll.z * lllllllllllllllllIIllIIlllIIIIIl;
        this.w = lllllllllllllllllIIllIIllIllllll.w * lllllllllllllllllIIllIIlllIIIIIl;
    }
    
    public final void set(final Matrix3f lllllllllllllllllIIllIIlIIlllllI) {
        float lllllllllllllllllIIllIIlIIllllIl = 0.25f * (lllllllllllllllllIIllIIlIIlllllI.m00 + lllllllllllllllllIIllIIlIIlllllI.m11 + lllllllllllllllllIIllIIlIIlllllI.m22 + 1.0f);
        if (lllllllllllllllllIIllIIlIIllllIl < 0.0f) {
            this.w = 0.0f;
            this.x = 0.0f;
            this.y = 0.0f;
            this.z = 1.0f;
            return;
        }
        if (lllllllllllllllllIIllIIlIIllllIl >= 1.0E-30) {
            this.w = (float)Math.sqrt(lllllllllllllllllIIllIIlIIllllIl);
            lllllllllllllllllIIllIIlIIllllIl = 0.25f / this.w;
            this.x = (lllllllllllllllllIIllIIlIIlllllI.m21 - lllllllllllllllllIIllIIlIIlllllI.m12) * lllllllllllllllllIIllIIlIIllllIl;
            this.y = (lllllllllllllllllIIllIIlIIlllllI.m02 - lllllllllllllllllIIllIIlIIlllllI.m20) * lllllllllllllllllIIllIIlIIllllIl;
            this.z = (lllllllllllllllllIIllIIlIIlllllI.m10 - lllllllllllllllllIIllIIlIIlllllI.m01) * lllllllllllllllllIIllIIlIIllllIl;
            return;
        }
        this.w = 0.0f;
        lllllllllllllllllIIllIIlIIllllIl = -0.5f * (lllllllllllllllllIIllIIlIIlllllI.m11 + lllllllllllllllllIIllIIlIIlllllI.m22);
        if (lllllllllllllllllIIllIIlIIllllIl < 0.0f) {
            this.x = 0.0f;
            this.y = 0.0f;
            this.z = 1.0f;
            return;
        }
        if (lllllllllllllllllIIllIIlIIllllIl >= 1.0E-30) {
            this.x = (float)Math.sqrt(lllllllllllllllllIIllIIlIIllllIl);
            lllllllllllllllllIIllIIlIIllllIl = 0.5f / this.x;
            this.y = lllllllllllllllllIIllIIlIIlllllI.m10 * lllllllllllllllllIIllIIlIIllllIl;
            this.z = lllllllllllllllllIIllIIlIIlllllI.m20 * lllllllllllllllllIIllIIlIIllllIl;
            return;
        }
        this.x = 0.0f;
        lllllllllllllllllIIllIIlIIllllIl = 0.5f * (1.0f - lllllllllllllllllIIllIIlIIlllllI.m22);
        if (lllllllllllllllllIIllIIlIIllllIl >= 1.0E-30) {
            this.y = (float)Math.sqrt(lllllllllllllllllIIllIIlIIllllIl);
            this.z = lllllllllllllllllIIllIIlIIlllllI.m21 / (2.0f * this.y);
            return;
        }
        this.y = 0.0f;
        this.z = 1.0f;
    }
    
    public final void conjugate() {
        this.x = -this.x;
        this.y = -this.y;
        this.z = -this.z;
    }
    
    public final void set(final Matrix3d lllllllllllllllllIIllIIlIIllIIlI) {
        double lllllllllllllllllIIllIIlIIllIlII = 0.25 * (lllllllllllllllllIIllIIlIIllIIlI.m00 + lllllllllllllllllIIllIIlIIllIIlI.m11 + lllllllllllllllllIIllIIlIIllIIlI.m22 + 1.0);
        if (lllllllllllllllllIIllIIlIIllIlII < 0.0) {
            this.w = 0.0f;
            this.x = 0.0f;
            this.y = 0.0f;
            this.z = 1.0f;
            return;
        }
        if (lllllllllllllllllIIllIIlIIllIlII >= 1.0E-30) {
            this.w = (float)Math.sqrt(lllllllllllllllllIIllIIlIIllIlII);
            lllllllllllllllllIIllIIlIIllIlII = 0.25 / this.w;
            this.x = (float)((lllllllllllllllllIIllIIlIIllIIlI.m21 - lllllllllllllllllIIllIIlIIllIIlI.m12) * lllllllllllllllllIIllIIlIIllIlII);
            this.y = (float)((lllllllllllllllllIIllIIlIIllIIlI.m02 - lllllllllllllllllIIllIIlIIllIIlI.m20) * lllllllllllllllllIIllIIlIIllIlII);
            this.z = (float)((lllllllllllllllllIIllIIlIIllIIlI.m10 - lllllllllllllllllIIllIIlIIllIIlI.m01) * lllllllllllllllllIIllIIlIIllIlII);
            return;
        }
        this.w = 0.0f;
        lllllllllllllllllIIllIIlIIllIlII = -0.5 * (lllllllllllllllllIIllIIlIIllIIlI.m11 + lllllllllllllllllIIllIIlIIllIIlI.m22);
        if (lllllllllllllllllIIllIIlIIllIlII < 0.0) {
            this.x = 0.0f;
            this.y = 0.0f;
            this.z = 1.0f;
            return;
        }
        if (lllllllllllllllllIIllIIlIIllIlII >= 1.0E-30) {
            this.x = (float)Math.sqrt(lllllllllllllllllIIllIIlIIllIlII);
            lllllllllllllllllIIllIIlIIllIlII = 0.5 / this.x;
            this.y = (float)(lllllllllllllllllIIllIIlIIllIIlI.m10 * lllllllllllllllllIIllIIlIIllIlII);
            this.z = (float)(lllllllllllllllllIIllIIlIIllIIlI.m20 * lllllllllllllllllIIllIIlIIllIlII);
            return;
        }
        this.x = 0.0f;
        lllllllllllllllllIIllIIlIIllIlII = 0.5 * (1.0 - lllllllllllllllllIIllIIlIIllIIlI.m22);
        if (lllllllllllllllllIIllIIlIIllIlII >= 1.0E-30) {
            this.y = (float)Math.sqrt(lllllllllllllllllIIllIIlIIllIlII);
            this.z = (float)(lllllllllllllllllIIllIIlIIllIIlI.m21 / (2.0 * this.y));
            return;
        }
        this.y = 0.0f;
        this.z = 1.0f;
    }
    
    public final void normalize() {
        float lllllllllllllllllIIllIIlIlIlIlll = this.x * this.x + this.y * this.y + this.z * this.z + this.w * this.w;
        if (lllllllllllllllllIIllIIlIlIlIlll > 0.0f) {
            lllllllllllllllllIIllIIlIlIlIlll = 1.0f / (float)Math.sqrt(lllllllllllllllllIIllIIlIlIlIlll);
            this.x *= lllllllllllllllllIIllIIlIlIlIlll;
            this.y *= lllllllllllllllllIIllIIlIlIlIlll;
            this.z *= lllllllllllllllllIIllIIlIlIlIlll;
            this.w *= lllllllllllllllllIIllIIlIlIlIlll;
        }
        else {
            this.x = 0.0f;
            this.y = 0.0f;
            this.z = 0.0f;
            this.w = 0.0f;
        }
    }
    
    public final void set(final AxisAngle4d lllllllllllllllllIIllIIlIIIllIll) {
        float lllllllllllllllllIIllIIlIIIlllIl = (float)(1.0 / Math.sqrt(lllllllllllllllllIIllIIlIIIllIll.x * lllllllllllllllllIIllIIlIIIllIll.x + lllllllllllllllllIIllIIlIIIllIll.y * lllllllllllllllllIIllIIlIIIllIll.y + lllllllllllllllllIIllIIlIIIllIll.z * lllllllllllllllllIIllIIlIIIllIll.z));
        if (lllllllllllllllllIIllIIlIIIlllIl < 1.0E-6) {
            this.w = 0.0f;
            this.x = 0.0f;
            this.y = 0.0f;
            this.z = 0.0f;
        }
        else {
            lllllllllllllllllIIllIIlIIIlllIl = 1.0f / lllllllllllllllllIIllIIlIIIlllIl;
            final float lllllllllllllllllIIllIIlIIIllllI = (float)Math.sin(lllllllllllllllllIIllIIlIIIllIll.angle / 2.0);
            this.w = (float)Math.cos(lllllllllllllllllIIllIIlIIIllIll.angle / 2.0);
            this.x = (float)lllllllllllllllllIIllIIlIIIllIll.x * lllllllllllllllllIIllIIlIIIlllIl * lllllllllllllllllIIllIIlIIIllllI;
            this.y = (float)lllllllllllllllllIIllIIlIIIllIll.y * lllllllllllllllllIIllIIlIIIlllIl * lllllllllllllllllIIllIIlIIIllllI;
            this.z = (float)lllllllllllllllllIIllIIlIIIllIll.z * lllllllllllllllllIIllIIlIIIlllIl * lllllllllllllllllIIllIIlIIIllllI;
        }
    }
    
    public final void mul(final Quat4f lllllllllllllllllIIllIIllIlIIIIl, final Quat4f lllllllllllllllllIIllIIllIIllIlI) {
        if (this != lllllllllllllllllIIllIIllIlIIIIl && this != lllllllllllllllllIIllIIllIIllIlI) {
            this.w = lllllllllllllllllIIllIIllIlIIIIl.w * lllllllllllllllllIIllIIllIIllIlI.w - lllllllllllllllllIIllIIllIlIIIIl.x * lllllllllllllllllIIllIIllIIllIlI.x - lllllllllllllllllIIllIIllIlIIIIl.y * lllllllllllllllllIIllIIllIIllIlI.y - lllllllllllllllllIIllIIllIlIIIIl.z * lllllllllllllllllIIllIIllIIllIlI.z;
            this.x = lllllllllllllllllIIllIIllIlIIIIl.w * lllllllllllllllllIIllIIllIIllIlI.x + lllllllllllllllllIIllIIllIIllIlI.w * lllllllllllllllllIIllIIllIlIIIIl.x + lllllllllllllllllIIllIIllIlIIIIl.y * lllllllllllllllllIIllIIllIIllIlI.z - lllllllllllllllllIIllIIllIlIIIIl.z * lllllllllllllllllIIllIIllIIllIlI.y;
            this.y = lllllllllllllllllIIllIIllIlIIIIl.w * lllllllllllllllllIIllIIllIIllIlI.y + lllllllllllllllllIIllIIllIIllIlI.w * lllllllllllllllllIIllIIllIlIIIIl.y - lllllllllllllllllIIllIIllIlIIIIl.x * lllllllllllllllllIIllIIllIIllIlI.z + lllllllllllllllllIIllIIllIlIIIIl.z * lllllllllllllllllIIllIIllIIllIlI.x;
            this.z = lllllllllllllllllIIllIIllIlIIIIl.w * lllllllllllllllllIIllIIllIIllIlI.z + lllllllllllllllllIIllIIllIIllIlI.w * lllllllllllllllllIIllIIllIlIIIIl.z + lllllllllllllllllIIllIIllIlIIIIl.x * lllllllllllllllllIIllIIllIIllIlI.y - lllllllllllllllllIIllIIllIlIIIIl.y * lllllllllllllllllIIllIIllIIllIlI.x;
        }
        else {
            final float lllllllllllllllllIIllIIllIIlllIl = lllllllllllllllllIIllIIllIlIIIIl.w * lllllllllllllllllIIllIIllIIllIlI.w - lllllllllllllllllIIllIIllIlIIIIl.x * lllllllllllllllllIIllIIllIIllIlI.x - lllllllllllllllllIIllIIllIlIIIIl.y * lllllllllllllllllIIllIIllIIllIlI.y - lllllllllllllllllIIllIIllIlIIIIl.z * lllllllllllllllllIIllIIllIIllIlI.z;
            final float lllllllllllllllllIIllIIllIIlllll = lllllllllllllllllIIllIIllIlIIIIl.w * lllllllllllllllllIIllIIllIIllIlI.x + lllllllllllllllllIIllIIllIIllIlI.w * lllllllllllllllllIIllIIllIlIIIIl.x + lllllllllllllllllIIllIIllIlIIIIl.y * lllllllllllllllllIIllIIllIIllIlI.z - lllllllllllllllllIIllIIllIlIIIIl.z * lllllllllllllllllIIllIIllIIllIlI.y;
            final float lllllllllllllllllIIllIIllIIllllI = lllllllllllllllllIIllIIllIlIIIIl.w * lllllllllllllllllIIllIIllIIllIlI.y + lllllllllllllllllIIllIIllIIllIlI.w * lllllllllllllllllIIllIIllIlIIIIl.y - lllllllllllllllllIIllIIllIlIIIIl.x * lllllllllllllllllIIllIIllIIllIlI.z + lllllllllllllllllIIllIIllIlIIIIl.z * lllllllllllllllllIIllIIllIIllIlI.x;
            this.z = lllllllllllllllllIIllIIllIlIIIIl.w * lllllllllllllllllIIllIIllIIllIlI.z + lllllllllllllllllIIllIIllIIllIlI.w * lllllllllllllllllIIllIIllIlIIIIl.z + lllllllllllllllllIIllIIllIlIIIIl.x * lllllllllllllllllIIllIIllIIllIlI.y - lllllllllllllllllIIllIIllIlIIIIl.y * lllllllllllllllllIIllIIllIIllIlI.x;
            this.w = lllllllllllllllllIIllIIllIIlllIl;
            this.x = lllllllllllllllllIIllIIllIIlllll;
            this.y = lllllllllllllllllIIllIIllIIllllI;
        }
    }
    
    public Quat4f() {
    }
    
    public final void set(final Matrix4f lllllllllllllllllIIllIIlIlIIllIl) {
        float lllllllllllllllllIIllIIlIlIIllll = 0.25f * (lllllllllllllllllIIllIIlIlIIllIl.m00 + lllllllllllllllllIIllIIlIlIIllIl.m11 + lllllllllllllllllIIllIIlIlIIllIl.m22 + lllllllllllllllllIIllIIlIlIIllIl.m33);
        if (lllllllllllllllllIIllIIlIlIIllll < 0.0f) {
            this.w = 0.0f;
            this.x = 0.0f;
            this.y = 0.0f;
            this.z = 1.0f;
            return;
        }
        if (lllllllllllllllllIIllIIlIlIIllll >= 1.0E-30) {
            this.w = (float)Math.sqrt(lllllllllllllllllIIllIIlIlIIllll);
            lllllllllllllllllIIllIIlIlIIllll = 0.25f / this.w;
            this.x = (lllllllllllllllllIIllIIlIlIIllIl.m21 - lllllllllllllllllIIllIIlIlIIllIl.m12) * lllllllllllllllllIIllIIlIlIIllll;
            this.y = (lllllllllllllllllIIllIIlIlIIllIl.m02 - lllllllllllllllllIIllIIlIlIIllIl.m20) * lllllllllllllllllIIllIIlIlIIllll;
            this.z = (lllllllllllllllllIIllIIlIlIIllIl.m10 - lllllllllllllllllIIllIIlIlIIllIl.m01) * lllllllllllllllllIIllIIlIlIIllll;
            return;
        }
        this.w = 0.0f;
        lllllllllllllllllIIllIIlIlIIllll = -0.5f * (lllllllllllllllllIIllIIlIlIIllIl.m11 + lllllllllllllllllIIllIIlIlIIllIl.m22);
        if (lllllllllllllllllIIllIIlIlIIllll < 0.0f) {
            this.x = 0.0f;
            this.y = 0.0f;
            this.z = 1.0f;
            return;
        }
        if (lllllllllllllllllIIllIIlIlIIllll >= 1.0E-30) {
            this.x = (float)Math.sqrt(lllllllllllllllllIIllIIlIlIIllll);
            lllllllllllllllllIIllIIlIlIIllll = 1.0f / (2.0f * this.x);
            this.y = lllllllllllllllllIIllIIlIlIIllIl.m10 * lllllllllllllllllIIllIIlIlIIllll;
            this.z = lllllllllllllllllIIllIIlIlIIllIl.m20 * lllllllllllllllllIIllIIlIlIIllll;
            return;
        }
        this.x = 0.0f;
        lllllllllllllllllIIllIIlIlIIllll = 0.5f * (1.0f - lllllllllllllllllIIllIIlIlIIllIl.m22);
        if (lllllllllllllllllIIllIIlIlIIllll >= 1.0E-30) {
            this.y = (float)Math.sqrt(lllllllllllllllllIIllIIlIlIIllll);
            this.z = lllllllllllllllllIIllIIlIlIIllIl.m21 / (2.0f * this.y);
            return;
        }
        this.y = 0.0f;
        this.z = 1.0f;
    }
    
    public final void normalize(final Quat4f lllllllllllllllllIIllIIlIlIlllll) {
        float lllllllllllllllllIIllIIlIlIllllI = lllllllllllllllllIIllIIlIlIlllll.x * lllllllllllllllllIIllIIlIlIlllll.x + lllllllllllllllllIIllIIlIlIlllll.y * lllllllllllllllllIIllIIlIlIlllll.y + lllllllllllllllllIIllIIlIlIlllll.z * lllllllllllllllllIIllIIlIlIlllll.z + lllllllllllllllllIIllIIlIlIlllll.w * lllllllllllllllllIIllIIlIlIlllll.w;
        if (lllllllllllllllllIIllIIlIlIllllI > 0.0f) {
            lllllllllllllllllIIllIIlIlIllllI = 1.0f / (float)Math.sqrt(lllllllllllllllllIIllIIlIlIllllI);
            this.x = lllllllllllllllllIIllIIlIlIllllI * lllllllllllllllllIIllIIlIlIlllll.x;
            this.y = lllllllllllllllllIIllIIlIlIllllI * lllllllllllllllllIIllIIlIlIlllll.y;
            this.z = lllllllllllllllllIIllIIlIlIllllI * lllllllllllllllllIIllIIlIlIlllll.z;
            this.w = lllllllllllllllllIIllIIlIlIllllI * lllllllllllllllllIIllIIlIlIlllll.w;
        }
        else {
            this.x = 0.0f;
            this.y = 0.0f;
            this.z = 0.0f;
            this.w = 0.0f;
        }
    }
    
    public final void interpolate(final Quat4f lllllllllllllllllIIllIIlIIIIllll, final float lllllllllllllllllIIllIIlIIIIIlII) {
        double lllllllllllllllllIIllIIlIIIIllIl = this.x * lllllllllllllllllIIllIIlIIIIllll.x + this.y * lllllllllllllllllIIllIIlIIIIllll.y + this.z * lllllllllllllllllIIllIIlIIIIllll.z + this.w * lllllllllllllllllIIllIIlIIIIllll.w;
        if (lllllllllllllllllIIllIIlIIIIllIl < 0.0) {
            lllllllllllllllllIIllIIlIIIIllll.x = -lllllllllllllllllIIllIIlIIIIllll.x;
            lllllllllllllllllIIllIIlIIIIllll.y = -lllllllllllllllllIIllIIlIIIIllll.y;
            lllllllllllllllllIIllIIlIIIIllll.z = -lllllllllllllllllIIllIIlIIIIllll.z;
            lllllllllllllllllIIllIIlIIIIllll.w = -lllllllllllllllllIIllIIlIIIIllll.w;
            lllllllllllllllllIIllIIlIIIIllIl = -lllllllllllllllllIIllIIlIIIIllIl;
        }
        double lllllllllllllllllIIllIIlIIIIlIll = 0.0;
        double lllllllllllllllllIIllIIlIIIIlIIl = 0.0;
        if (1.0 - lllllllllllllllllIIllIIlIIIIllIl > 1.0E-6) {
            final double lllllllllllllllllIIllIIlIIIIlIII = Math.acos(lllllllllllllllllIIllIIlIIIIllIl);
            final double lllllllllllllllllIIllIIlIIIIIlll = Math.sin(lllllllllllllllllIIllIIlIIIIlIII);
            final double lllllllllllllllllIIllIIlIIIIllII = Math.sin((1.0 - lllllllllllllllllIIllIIlIIIIIlII) * lllllllllllllllllIIllIIlIIIIlIII) / lllllllllllllllllIIllIIlIIIIIlll;
            final double lllllllllllllllllIIllIIlIIIIlIlI = Math.sin(lllllllllllllllllIIllIIlIIIIIlII * lllllllllllllllllIIllIIlIIIIlIII) / lllllllllllllllllIIllIIlIIIIIlll;
        }
        else {
            lllllllllllllllllIIllIIlIIIIlIll = 1.0 - lllllllllllllllllIIllIIlIIIIIlII;
            lllllllllllllllllIIllIIlIIIIlIIl = lllllllllllllllllIIllIIlIIIIIlII;
        }
        this.w = (float)(lllllllllllllllllIIllIIlIIIIlIll * this.w + lllllllllllllllllIIllIIlIIIIlIIl * lllllllllllllllllIIllIIlIIIIllll.w);
        this.x = (float)(lllllllllllllllllIIllIIlIIIIlIll * this.x + lllllllllllllllllIIllIIlIIIIlIIl * lllllllllllllllllIIllIIlIIIIllll.x);
        this.y = (float)(lllllllllllllllllIIllIIlIIIIlIll * this.y + lllllllllllllllllIIllIIlIIIIlIIl * lllllllllllllllllIIllIIlIIIIllll.y);
        this.z = (float)(lllllllllllllllllIIllIIlIIIIlIll * this.z + lllllllllllllllllIIllIIlIIIIlIIl * lllllllllllllllllIIllIIlIIIIllll.z);
    }
    
    public final void conjugate(final Quat4f lllllllllllllllllIIllIIllIlIlllI) {
        this.x = -lllllllllllllllllIIllIIllIlIlllI.x;
        this.y = -lllllllllllllllllIIllIIllIlIlllI.y;
        this.z = -lllllllllllllllllIIllIIllIlIlllI.z;
        this.w = lllllllllllllllllIIllIIllIlIlllI.w;
    }
}
