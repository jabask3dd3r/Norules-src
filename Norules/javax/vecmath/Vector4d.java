package javax.vecmath;

import java.io.*;

public class Vector4d extends Tuple4d implements Serializable
{
    public Vector4d() {
    }
    
    public final double lengthSquared() {
        return this.x * this.x + this.y * this.y + this.z * this.z + this.w * this.w;
    }
    
    public Vector4d(final double[] lllllllllllllIIIIlllIIIlIIlIlIIl) {
        super(lllllllllllllIIIIlllIIIlIIlIlIIl);
    }
    
    public final void normalize(final Vector4d lllllllllllllIIIIlllIIIIlllIllll) {
        final double lllllllllllllIIIIlllIIIIlllIlllI = 1.0 / Math.sqrt(lllllllllllllIIIIlllIIIIlllIllll.x * lllllllllllllIIIIlllIIIIlllIllll.x + lllllllllllllIIIIlllIIIIlllIllll.y * lllllllllllllIIIIlllIIIIlllIllll.y + lllllllllllllIIIIlllIIIIlllIllll.z * lllllllllllllIIIIlllIIIIlllIllll.z + lllllllllllllIIIIlllIIIIlllIllll.w * lllllllllllllIIIIlllIIIIlllIllll.w);
        this.x = lllllllllllllIIIIlllIIIIlllIllll.x * lllllllllllllIIIIlllIIIIlllIlllI;
        this.y = lllllllllllllIIIIlllIIIIlllIllll.y * lllllllllllllIIIIlllIIIIlllIlllI;
        this.z = lllllllllllllIIIIlllIIIIlllIllll.z * lllllllllllllIIIIlllIIIIlllIlllI;
        this.w = lllllllllllllIIIIlllIIIIlllIllll.w * lllllllllllllIIIIlllIIIIlllIlllI;
    }
    
    public Vector4d(final Tuple4f lllllllllllllIIIIlllIIIlIIIlIlIl) {
        super(lllllllllllllIIIIlllIIIlIIIlIlIl);
    }
    
    public final double length() {
        return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z + this.w * this.w);
    }
    
    public Vector4d(final Tuple4d lllllllllllllIIIIlllIIIlIIIlIIIl) {
        super(lllllllllllllIIIIlllIIIlIIIlIIIl);
    }
    
    public final void set(final Tuple3d lllllllllllllIIIIlllIIIlIIIIIIlI) {
        this.x = lllllllllllllIIIIlllIIIlIIIIIIlI.x;
        this.y = lllllllllllllIIIIlllIIIlIIIIIIlI.y;
        this.z = lllllllllllllIIIIlllIIIlIIIIIIlI.z;
        this.w = 0.0;
    }
    
    public final void normalize() {
        final double lllllllllllllIIIIlllIIIIlllIIlll = 1.0 / Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z + this.w * this.w);
        this.x *= lllllllllllllIIIIlllIIIIlllIIlll;
        this.y *= lllllllllllllIIIIlllIIIIlllIIlll;
        this.z *= lllllllllllllIIIIlllIIIIlllIIlll;
        this.w *= lllllllllllllIIIIlllIIIIlllIIlll;
    }
    
    public Vector4d(final Vector4d lllllllllllllIIIIlllIIIlIIlIIIll) {
        super(lllllllllllllIIIIlllIIIlIIlIIIll);
    }
    
    public Vector4d(final Vector4f lllllllllllllIIIIlllIIIlIIIlllIl) {
        super(lllllllllllllIIIIlllIIIlIIIlllIl);
    }
    
    public final double angle(final Vector4d lllllllllllllIIIIlllIIIIllIlllIl) {
        double lllllllllllllIIIIlllIIIIllIlllll = this.dot(lllllllllllllIIIIlllIIIIllIlllIl) / (this.length() * lllllllllllllIIIIlllIIIIllIlllIl.length());
        if (lllllllllllllIIIIlllIIIIllIlllll < -1.0) {
            lllllllllllllIIIIlllIIIIllIlllll = -1.0;
        }
        if (lllllllllllllIIIIlllIIIIllIlllll > 1.0) {
            lllllllllllllIIIIlllIIIIllIlllll = 1.0;
        }
        return Math.acos(lllllllllllllIIIIlllIIIIllIlllll);
    }
    
    public Vector4d(final double lllllllllllllIIIIlllIIIlIIllIIII, final double lllllllllllllIIIIlllIIIlIIllIlII, final double lllllllllllllIIIIlllIIIlIIlIlllI, final double lllllllllllllIIIIlllIIIlIIllIIlI) {
        super(lllllllllllllIIIIlllIIIlIIllIIII, lllllllllllllIIIIlllIIIlIIllIlII, lllllllllllllIIIIlllIIIlIIlIlllI, lllllllllllllIIIIlllIIIlIIllIIlI);
    }
    
    public Vector4d(final Tuple3d lllllllllllllIIIIlllIIIlIIIIlIIl) {
        super(lllllllllllllIIIIlllIIIlIIIIlIIl.x, lllllllllllllIIIIlllIIIlIIIIlIIl.y, lllllllllllllIIIIlllIIIlIIIIlIIl.z, 0.0);
    }
    
    public final double dot(final Vector4d lllllllllllllIIIIlllIIIIllllIlII) {
        return this.x * lllllllllllllIIIIlllIIIIllllIlII.x + this.y * lllllllllllllIIIIlllIIIIllllIlII.y + this.z * lllllllllllllIIIIlllIIIIllllIlII.z + this.w * lllllllllllllIIIIlllIIIIllllIlII.w;
    }
}
