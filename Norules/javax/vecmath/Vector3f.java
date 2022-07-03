package javax.vecmath;

import java.io.*;

public class Vector3f extends Tuple3f implements Serializable
{
    public Vector3f(final Tuple3d lllllllllllllllIIllIlIIIlIlIIlII) {
        super(lllllllllllllllIIllIlIIIlIlIIlII);
    }
    
    public Vector3f() {
    }
    
    public Vector3f(final Vector3d lllllllllllllllIIllIlIIIlIlIlllI) {
        super(lllllllllllllllIIllIlIIIlIlIlllI);
    }
    
    public Vector3f(final float[] lllllllllllllllIIllIlIIIlIlllIlI) {
        super(lllllllllllllllIIllIlIIIlIlllIlI);
    }
    
    public final void cross(final Vector3f lllllllllllllllIIllIlIIIlIIIllIl, final Vector3f lllllllllllllllIIllIlIIIlIIlIIIl) {
        final float lllllllllllllllIIllIlIIIlIIlIIII = lllllllllllllllIIllIlIIIlIIIllIl.y * lllllllllllllllIIllIlIIIlIIlIIIl.z - lllllllllllllllIIllIlIIIlIIIllIl.z * lllllllllllllllIIllIlIIIlIIlIIIl.y;
        final float lllllllllllllllIIllIlIIIlIIIllll = lllllllllllllllIIllIlIIIlIIlIIIl.x * lllllllllllllllIIllIlIIIlIIIllIl.z - lllllllllllllllIIllIlIIIlIIlIIIl.z * lllllllllllllllIIllIlIIIlIIIllIl.x;
        this.z = lllllllllllllllIIllIlIIIlIIIllIl.x * lllllllllllllllIIllIlIIIlIIlIIIl.y - lllllllllllllllIIllIlIIIlIIIllIl.y * lllllllllllllllIIllIlIIIlIIlIIIl.x;
        this.x = lllllllllllllllIIllIlIIIlIIlIIII;
        this.y = lllllllllllllllIIllIlIIIlIIIllll;
    }
    
    public final float angle(final Vector3f lllllllllllllllIIllIlIIIIlllIIII) {
        double lllllllllllllllIIllIlIIIIllIllll = this.dot(lllllllllllllllIIllIlIIIIlllIIII) / (this.length() * lllllllllllllllIIllIlIIIIlllIIII.length());
        if (lllllllllllllllIIllIlIIIIllIllll < -1.0) {
            lllllllllllllllIIllIlIIIIllIllll = -1.0;
        }
        if (lllllllllllllllIIllIlIIIIllIllll > 1.0) {
            lllllllllllllllIIllIlIIIIllIllll = 1.0;
        }
        return (float)Math.acos(lllllllllllllllIIllIlIIIIllIllll);
    }
    
    public final void normalize() {
        final float lllllllllllllllIIllIlIIIIlllIlll = (float)(1.0 / Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z));
        this.x *= lllllllllllllllIIllIlIIIIlllIlll;
        this.y *= lllllllllllllllIIllIlIIIIlllIlll;
        this.z *= lllllllllllllllIIllIlIIIIlllIlll;
    }
    
    public final float length() {
        return (float)Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
    }
    
    public final void normalize(final Vector3f lllllllllllllllIIllIlIIIIlllllll) {
        final float lllllllllllllllIIllIlIIIIllllllI = (float)(1.0 / Math.sqrt(lllllllllllllllIIllIlIIIIlllllll.x * lllllllllllllllIIllIlIIIIlllllll.x + lllllllllllllllIIllIlIIIIlllllll.y * lllllllllllllllIIllIlIIIIlllllll.y + lllllllllllllllIIllIlIIIIlllllll.z * lllllllllllllllIIllIlIIIIlllllll.z));
        this.x = lllllllllllllllIIllIlIIIIlllllll.x * lllllllllllllllIIllIlIIIIllllllI;
        this.y = lllllllllllllllIIllIlIIIIlllllll.y * lllllllllllllllIIllIlIIIIllllllI;
        this.z = lllllllllllllllIIllIlIIIIlllllll.z * lllllllllllllllIIllIlIIIIllllllI;
    }
    
    public Vector3f(final Tuple3f lllllllllllllllIIllIlIIIlIlIlIII) {
        super(lllllllllllllllIIllIlIIIlIlIlIII);
    }
    
    public Vector3f(final Vector3f lllllllllllllllIIllIlIIIlIllIllI) {
        super(lllllllllllllllIIllIlIIIlIllIllI);
    }
    
    public final float dot(final Vector3f lllllllllllllllIIllIlIIIlIIIIlII) {
        return this.x * lllllllllllllllIIllIlIIIlIIIIlII.x + this.y * lllllllllllllllIIllIlIIIlIIIIlII.y + this.z * lllllllllllllllIIllIlIIIlIIIIlII.z;
    }
    
    public final float lengthSquared() {
        return this.x * this.x + this.y * this.y + this.z * this.z;
    }
    
    public Vector3f(final float lllllllllllllllIIllIlIIIllIIIIlI, final float lllllllllllllllIIllIlIIIllIIIIIl, final float lllllllllllllllIIllIlIIIllIIIIII) {
        super(lllllllllllllllIIllIlIIIllIIIIlI, lllllllllllllllIIllIlIIIllIIIIIl, lllllllllllllllIIllIlIIIllIIIIII);
    }
}
