package javax.vecmath;

import java.io.*;

public class Vector4f extends Tuple4f implements Serializable
{
    public Vector4f(final Tuple4d llllllllllllllIIIlIIIllllIlIIlIl) {
        super(llllllllllllllIIIlIIIllllIlIIlIl);
    }
    
    public Vector4f(final Vector4d llllllllllllllIIIlIIIllllIllIIll) {
        super(llllllllllllllIIIlIIIllllIllIIll);
    }
    
    public final void set(final Tuple3f llllllllllllllIIIlIIIllllIIllIII) {
        this.x = llllllllllllllIIIlIIIllllIIllIII.x;
        this.y = llllllllllllllIIIlIIIllllIIllIII.y;
        this.z = llllllllllllllIIIlIIIllllIIllIII.z;
        this.w = 0.0f;
    }
    
    public Vector4f(final Vector4f llllllllllllllIIIlIIIllllIlllIIl) {
        super(llllllllllllllIIIlIIIllllIlllIIl);
    }
    
    public final void normalize() {
        final float llllllllllllllIIIlIIIlllIlllllIl = (float)(1.0 / Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z + this.w * this.w));
        this.x *= llllllllllllllIIIlIIIlllIlllllIl;
        this.y *= llllllllllllllIIIlIIIlllIlllllIl;
        this.z *= llllllllllllllIIIlIIIlllIlllllIl;
        this.w *= llllllllllllllIIIlIIIlllIlllllIl;
    }
    
    public Vector4f() {
    }
    
    public Vector4f(final Tuple4f llllllllllllllIIIlIIIllllIlIlIll) {
        super(llllllllllllllIIIlIIIllllIlIlIll);
    }
    
    public final float lengthSquared() {
        return this.x * this.x + this.y * this.y + this.z * this.z + this.w * this.w;
    }
    
    public final float dot(final Vector4f llllllllllllllIIIlIIIllllIIIlIlI) {
        return this.x * llllllllllllllIIIlIIIllllIIIlIlI.x + this.y * llllllllllllllIIIlIIIllllIIIlIlI.y + this.z * llllllllllllllIIIlIIIllllIIIlIlI.z + this.w * llllllllllllllIIIlIIIllllIIIlIlI.w;
    }
    
    public final float length() {
        return (float)Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z + this.w * this.w);
    }
    
    public Vector4f(final Tuple3f llllllllllllllIIIlIIIllllIlIIIIl) {
        super(llllllllllllllIIIlIIIllllIlIIIIl.x, llllllllllllllIIIlIIIllllIlIIIIl.y, llllllllllllllIIIlIIIllllIlIIIIl.z, 0.0f);
    }
    
    public final float angle(final Vector4f llllllllllllllIIIlIIIlllIlllIIll) {
        double llllllllllllllIIIlIIIlllIlllIlIl = this.dot(llllllllllllllIIIlIIIlllIlllIIll) / (this.length() * llllllllllllllIIIlIIIlllIlllIIll.length());
        if (llllllllllllllIIIlIIIlllIlllIlIl < -1.0) {
            llllllllllllllIIIlIIIlllIlllIlIl = -1.0;
        }
        if (llllllllllllllIIIlIIIlllIlllIlIl > 1.0) {
            llllllllllllllIIIlIIIlllIlllIlIl = 1.0;
        }
        return (float)Math.acos(llllllllllllllIIIlIIIlllIlllIlIl);
    }
    
    public final void normalize(final Vector4f llllllllllllllIIIlIIIllllIIIIlIl) {
        final float llllllllllllllIIIlIIIllllIIIIlII = (float)(1.0 / Math.sqrt(llllllllllllllIIIlIIIllllIIIIlIl.x * llllllllllllllIIIlIIIllllIIIIlIl.x + llllllllllllllIIIlIIIllllIIIIlIl.y * llllllllllllllIIIlIIIllllIIIIlIl.y + llllllllllllllIIIlIIIllllIIIIlIl.z * llllllllllllllIIIlIIIllllIIIIlIl.z + llllllllllllllIIIlIIIllllIIIIlIl.w * llllllllllllllIIIlIIIllllIIIIlIl.w));
        this.x = llllllllllllllIIIlIIIllllIIIIlIl.x * llllllllllllllIIIlIIIllllIIIIlII;
        this.y = llllllllllllllIIIlIIIllllIIIIlIl.y * llllllllllllllIIIlIIIllllIIIIlII;
        this.z = llllllllllllllIIIlIIIllllIIIIlIl.z * llllllllllllllIIIlIIIllllIIIIlII;
        this.w = llllllllllllllIIIlIIIllllIIIIlIl.w * llllllllllllllIIIlIIIllllIIIIlII;
    }
    
    public Vector4f(final float[] llllllllllllllIIIlIIIllllIllllIl) {
        super(llllllllllllllIIIlIIIllllIllllIl);
    }
    
    public Vector4f(final float llllllllllllllIIIlIIIlllllIIlIll, final float llllllllllllllIIIlIIIlllllIIlIlI, final float llllllllllllllIIIlIIIlllllIIlIIl, final float llllllllllllllIIIlIIIlllllIIlIII) {
        super(llllllllllllllIIIlIIIlllllIIlIll, llllllllllllllIIIlIIIlllllIIlIlI, llllllllllllllIIIlIIIlllllIIlIIl, llllllllllllllIIIlIIIlllllIIlIII);
    }
}
