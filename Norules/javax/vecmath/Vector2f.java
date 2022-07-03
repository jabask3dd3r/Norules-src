package javax.vecmath;

import java.io.*;

public class Vector2f extends Tuple2f implements Serializable
{
    public final float length() {
        return (float)Math.sqrt(this.x * this.x + this.y * this.y);
    }
    
    public Vector2f(final float[] lllllllllllllIIIlIIllIlIIIIIllII) {
        super(lllllllllllllIIIlIIllIlIIIIIllII);
    }
    
    public final void normalize(final Vector2f lllllllllllllIIIlIIllIIlllIlllIl) {
        final float lllllllllllllIIIlIIllIIlllIlllll = (float)(1.0 / Math.sqrt(lllllllllllllIIIlIIllIIlllIlllIl.x * lllllllllllllIIIlIIllIIlllIlllIl.x + lllllllllllllIIIlIIllIIlllIlllIl.y * lllllllllllllIIIlIIllIIlllIlllIl.y));
        this.x = lllllllllllllIIIlIIllIIlllIlllIl.x * lllllllllllllIIIlIIllIIlllIlllll;
        this.y = lllllllllllllIIIlIIllIIlllIlllIl.y * lllllllllllllIIIlIIllIIlllIlllll;
    }
    
    public Vector2f(final float lllllllllllllIIIlIIllIlIIIIlIIll, final float lllllllllllllIIIlIIllIlIIIIlIlIl) {
        super(lllllllllllllIIIlIIllIlIIIIlIIll, lllllllllllllIIIlIIllIlIIIIlIlIl);
    }
    
    public Vector2f(final Tuple2d lllllllllllllIIIlIIllIIlllllIlII) {
        super(lllllllllllllIIIlIIllIIlllllIlII);
    }
    
    public final float angle(final Vector2f lllllllllllllIIIlIIllIIlllIIlllI) {
        double lllllllllllllIIIlIIllIIlllIlIIII = this.dot(lllllllllllllIIIlIIllIIlllIIlllI) / (this.length() * lllllllllllllIIIlIIllIIlllIIlllI.length());
        if (lllllllllllllIIIlIIllIIlllIlIIII < -1.0) {
            lllllllllllllIIIlIIllIIlllIlIIII = -1.0;
        }
        if (lllllllllllllIIIlIIllIIlllIlIIII > 1.0) {
            lllllllllllllIIIlIIllIIlllIlIIII = 1.0;
        }
        return (float)Math.acos(lllllllllllllIIIlIIllIIlllIlIIII);
    }
    
    public Vector2f(final Vector2d lllllllllllllIIIlIIllIlIIIIIIIlI) {
        super(lllllllllllllIIIlIIllIlIIIIIIIlI);
    }
    
    public final float lengthSquared() {
        return this.x * this.x + this.y * this.y;
    }
    
    public final float dot(final Vector2f lllllllllllllIIIlIIllIIllllIllIl) {
        return this.x * lllllllllllllIIIlIIllIIllllIllIl.x + this.y * lllllllllllllIIIlIIllIIllllIllIl.y;
    }
    
    public final void normalize() {
        final float lllllllllllllIIIlIIllIIlllIllIII = (float)(1.0 / Math.sqrt(this.x * this.x + this.y * this.y));
        this.x *= lllllllllllllIIIlIIllIIlllIllIII;
        this.y *= lllllllllllllIIIlIIllIIlllIllIII;
    }
    
    public Vector2f(final Vector2f lllllllllllllIIIlIIllIlIIIIIIllI) {
        super(lllllllllllllIIIlIIllIlIIIIIIllI);
    }
    
    public Vector2f() {
    }
    
    public Vector2f(final Tuple2f lllllllllllllIIIlIIllIIllllllIlI) {
        super(lllllllllllllIIIlIIllIIllllllIlI);
    }
}
