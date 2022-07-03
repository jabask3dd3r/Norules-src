package javax.vecmath;

import java.io.*;

public class Vector3d extends Tuple3d implements Serializable
{
    public final double angle(final Vector3d lllIllIlllIlII) {
        double lllIllIlllIIll = this.dot(lllIllIlllIlII) / (this.length() * lllIllIlllIlII.length());
        if (lllIllIlllIIll < -1.0) {
            lllIllIlllIIll = -1.0;
        }
        if (lllIllIlllIIll > 1.0) {
            lllIllIlllIIll = 1.0;
        }
        return Math.acos(lllIllIlllIIll);
    }
    
    public final double lengthSquared() {
        return this.x * this.x + this.y * this.y + this.z * this.z;
    }
    
    public Vector3d(final double[] llllIIIIIlIlll) {
        super(llllIIIIIlIlll);
    }
    
    public final void cross(final Vector3d lllIllllIIlllI, final Vector3d lllIllllIIllIl) {
        final double lllIllllIIlIll = lllIllllIIlllI.y * lllIllllIIllIl.z - lllIllllIIlllI.z * lllIllllIIllIl.y;
        final double lllIllllIIlIIl = lllIllllIIllIl.x * lllIllllIIlllI.z - lllIllllIIllIl.z * lllIllllIIlllI.x;
        this.z = lllIllllIIlllI.x * lllIllllIIllIl.y - lllIllllIIlllI.y * lllIllllIIllIl.x;
        this.x = lllIllllIIlIll;
        this.y = lllIllllIIlIIl;
    }
    
    public final double length() {
        return Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
    }
    
    public final void normalize(final Vector3d lllIlllIllIIII) {
        final double lllIlllIlIlllI = 1.0 / Math.sqrt(lllIlllIllIIII.x * lllIlllIllIIII.x + lllIlllIllIIII.y * lllIlllIllIIII.y + lllIlllIllIIII.z * lllIlllIllIIII.z);
        this.x = lllIlllIllIIII.x * lllIlllIlIlllI;
        this.y = lllIlllIllIIII.y * lllIlllIlIlllI;
        this.z = lllIlllIllIIII.z * lllIlllIlIlllI;
    }
    
    public Vector3d(final double llllIIIIlIIIIl, final double llllIIIIlIIllI, final double llllIIIIlIIlII) {
        super(llllIIIIlIIIIl, llllIIIIlIIllI, llllIIIIlIIlII);
    }
    
    public Vector3d(final Vector3f lllIllllllllII) {
        super(lllIllllllllII);
    }
    
    public final void normalize() {
        final double lllIlllIIlllIl = 1.0 / Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
        this.x *= lllIlllIIlllIl;
        this.y *= lllIlllIIlllIl;
        this.z *= lllIlllIIlllIl;
    }
    
    public final double dot(final Vector3d lllIlllIIIlllI) {
        return this.x * lllIlllIIIlllI.x + this.y * lllIlllIIIlllI.y + this.z * lllIlllIIIlllI.z;
    }
    
    public Vector3d() {
    }
    
    public Vector3d(final Tuple3f lllIllllllIIlI) {
        super(lllIllllllIIlI);
    }
    
    public Vector3d(final Vector3d llllIIIIIIIllI) {
        super(llllIIIIIIIllI);
    }
    
    public Vector3d(final Tuple3d lllIlllllIlIlI) {
        super(lllIlllllIlIlI);
    }
}
