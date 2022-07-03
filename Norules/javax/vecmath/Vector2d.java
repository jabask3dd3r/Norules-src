package javax.vecmath;

import java.io.*;

public class Vector2d extends Tuple2d implements Serializable
{
    public Vector2d(final double[] llllllllllllllllllIlIllIIIllIlII) {
        super(llllllllllllllllllIlIllIIIllIlII);
    }
    
    public Vector2d(final Vector2d llllllllllllllllllIlIllIIIlIlllI) {
        super(llllllllllllllllllIlIllIIIlIlllI);
    }
    
    public final void normalize() {
        final double llllllllllllllllllIlIllIIIIIIIII = 1.0 / Math.sqrt(this.x * this.x + this.y * this.y);
        this.x *= llllllllllllllllllIlIllIIIIIIIII;
        this.y *= llllllllllllllllllIlIllIIIIIIIII;
    }
    
    public final double dot(final Vector2d llllllllllllllllllIlIllIIIIlIlIl) {
        return this.x * llllllllllllllllllIlIllIIIIlIlIl.x + this.y * llllllllllllllllllIlIllIIIIlIlIl.y;
    }
    
    public Vector2d(final double llllllllllllllllllIlIllIIIlllIll, final double llllllllllllllllllIlIllIIIlllIlI) {
        super(llllllllllllllllllIlIllIIIlllIll, llllllllllllllllllIlIllIIIlllIlI);
    }
    
    public Vector2d() {
    }
    
    public Vector2d(final Vector2f llllllllllllllllllIlIllIIIlIlIII) {
        super(llllllllllllllllllIlIllIIIlIlIII);
    }
    
    public Vector2d(final Tuple2d llllllllllllllllllIlIllIIIlIIIlI) {
        super(llllllllllllllllllIlIllIIIlIIIlI);
    }
    
    public final double length() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }
    
    public final void normalize(final Vector2d llllllllllllllllllIlIllIIIIIIlIl) {
        final double llllllllllllllllllIlIllIIIIIIlll = 1.0 / Math.sqrt(llllllllllllllllllIlIllIIIIIIlIl.x * llllllllllllllllllIlIllIIIIIIlIl.x + llllllllllllllllllIlIllIIIIIIlIl.y * llllllllllllllllllIlIllIIIIIIlIl.y);
        this.x = llllllllllllllllllIlIllIIIIIIlIl.x * llllllllllllllllllIlIllIIIIIIlll;
        this.y = llllllllllllllllllIlIllIIIIIIlIl.y * llllllllllllllllllIlIllIIIIIIlll;
    }
    
    public Vector2d(final Tuple2f llllllllllllllllllIlIllIIIIlllII) {
        super(llllllllllllllllllIlIllIIIIlllII);
    }
    
    public final double angle(final Vector2d llllllllllllllllllIlIlIllllllIIl) {
        double llllllllllllllllllIlIlIllllllIII = this.dot(llllllllllllllllllIlIlIllllllIIl) / (this.length() * llllllllllllllllllIlIlIllllllIIl.length());
        if (llllllllllllllllllIlIlIllllllIII < -1.0) {
            llllllllllllllllllIlIlIllllllIII = -1.0;
        }
        if (llllllllllllllllllIlIlIllllllIII > 1.0) {
            llllllllllllllllllIlIlIllllllIII = 1.0;
        }
        return Math.acos(llllllllllllllllllIlIlIllllllIII);
    }
    
    public final double lengthSquared() {
        return this.x * this.x + this.y * this.y;
    }
}
