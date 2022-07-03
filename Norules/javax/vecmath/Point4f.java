package javax.vecmath;

import java.io.*;

public class Point4f extends Tuple4f implements Serializable
{
    public Point4f(final Point4f lllllllllllllllIIlllIIIIlIIlllIl) {
        super(lllllllllllllllIIlllIIIIlIIlllIl);
    }
    
    public Point4f(final Tuple3f lllllllllllllllIIlllIIIIlIIIIlll) {
        super(lllllllllllllllIIlllIIIIlIIIIlll.x, lllllllllllllllIIlllIIIIlIIIIlll.y, lllllllllllllllIIlllIIIIlIIIIlll.z, 1.0f);
    }
    
    public Point4f(final Tuple4d lllllllllllllllIIlllIIIIlIIIllIl) {
        super(lllllllllllllllIIlllIIIIlIIIllIl);
    }
    
    public final float distance(final Point4f lllllllllllllllIIlllIIIIIllIIIlI) {
        final float lllllllllllllllIIlllIIIIIllIIIIl = this.x - lllllllllllllllIIlllIIIIIllIIIlI.x;
        final float lllllllllllllllIIlllIIIIIllIIIII = this.y - lllllllllllllllIIlllIIIIIllIIIlI.y;
        final float lllllllllllllllIIlllIIIIIlIlllll = this.z - lllllllllllllllIIlllIIIIIllIIIlI.z;
        final float lllllllllllllllIIlllIIIIIlIllllI = this.w - lllllllllllllllIIlllIIIIIllIIIlI.w;
        return (float)Math.sqrt(lllllllllllllllIIlllIIIIIllIIIIl * lllllllllllllllIIlllIIIIIllIIIIl + lllllllllllllllIIlllIIIIIllIIIII * lllllllllllllllIIlllIIIIIllIIIII + lllllllllllllllIIlllIIIIIlIlllll * lllllllllllllllIIlllIIIIIlIlllll + lllllllllllllllIIlllIIIIIlIllllI * lllllllllllllllIIlllIIIIIlIllllI);
    }
    
    public Point4f(final Point4d lllllllllllllllIIlllIIIIlIIllIIl) {
        super(lllllllllllllllIIlllIIIIlIIllIIl);
    }
    
    public final float distanceLinf(final Point4f lllllllllllllllIIlllIIIIIlIIlIII) {
        final float lllllllllllllllIIlllIIIIIlIIlIll = Math.max(Math.abs(this.x - lllllllllllllllIIlllIIIIIlIIlIII.x), Math.abs(this.y - lllllllllllllllIIlllIIIIIlIIlIII.y));
        final float lllllllllllllllIIlllIIIIIlIIlIlI = Math.max(Math.abs(this.z - lllllllllllllllIIlllIIIIIlIIlIII.z), Math.abs(this.w - lllllllllllllllIIlllIIIIIlIIlIII.w));
        return Math.max(lllllllllllllllIIlllIIIIIlIIlIll, lllllllllllllllIIlllIIIIIlIIlIlI);
    }
    
    public final float distanceSquared(final Point4f lllllllllllllllIIlllIIIIIlllIlII) {
        final float lllllllllllllllIIlllIIIIIlllIIll = this.x - lllllllllllllllIIlllIIIIIlllIlII.x;
        final float lllllllllllllllIIlllIIIIIlllIIlI = this.y - lllllllllllllllIIlllIIIIIlllIlII.y;
        final float lllllllllllllllIIlllIIIIIlllIIIl = this.z - lllllllllllllllIIlllIIIIIlllIlII.z;
        final float lllllllllllllllIIlllIIIIIlllIIII = this.w - lllllllllllllllIIlllIIIIIlllIlII.w;
        return lllllllllllllllIIlllIIIIIlllIIll * lllllllllllllllIIlllIIIIIlllIIll + lllllllllllllllIIlllIIIIIlllIIlI * lllllllllllllllIIlllIIIIIlllIIlI + lllllllllllllllIIlllIIIIIlllIIIl * lllllllllllllllIIlllIIIIIlllIIIl + lllllllllllllllIIlllIIIIIlllIIII * lllllllllllllllIIlllIIIIIlllIIII;
    }
    
    public final void project(final Point4f lllllllllllllllIIlllIIIIIlIIIIIl) {
        final float lllllllllllllllIIlllIIIIIlIIIIII = 1.0f / lllllllllllllllIIlllIIIIIlIIIIIl.w;
        this.x = lllllllllllllllIIlllIIIIIlIIIIIl.x * lllllllllllllllIIlllIIIIIlIIIIII;
        this.y = lllllllllllllllIIlllIIIIIlIIIIIl.y * lllllllllllllllIIlllIIIIIlIIIIII;
        this.z = lllllllllllllllIIlllIIIIIlIIIIIl.z * lllllllllllllllIIlllIIIIIlIIIIII;
        this.w = 1.0f;
    }
    
    public Point4f(final Tuple4f lllllllllllllllIIlllIIIIlIIlIIll) {
        super(lllllllllllllllIIlllIIIIlIIlIIll);
    }
    
    public Point4f(final float[] lllllllllllllllIIlllIIIIlIlIIIll) {
        super(lllllllllllllllIIlllIIIIlIlIIIll);
    }
    
    public Point4f(final float lllllllllllllllIIlllIIIIlIlIllII, final float lllllllllllllllIIlllIIIIlIlIlIll, final float lllllllllllllllIIlllIIIIlIlIlIlI, final float lllllllllllllllIIlllIIIIlIlIlIIl) {
        super(lllllllllllllllIIlllIIIIlIlIllII, lllllllllllllllIIlllIIIIlIlIlIll, lllllllllllllllIIlllIIIIlIlIlIlI, lllllllllllllllIIlllIIIIlIlIlIIl);
    }
    
    public final float distanceL1(final Point4f lllllllllllllllIIlllIIIIIlIlIlII) {
        return Math.abs(this.x - lllllllllllllllIIlllIIIIIlIlIlII.x) + Math.abs(this.y - lllllllllllllllIIlllIIIIIlIlIlII.y) + Math.abs(this.z - lllllllllllllllIIlllIIIIIlIlIlII.z) + Math.abs(this.w - lllllllllllllllIIlllIIIIIlIlIlII.w);
    }
    
    public Point4f() {
    }
    
    public final void set(final Tuple3f lllllllllllllllIIlllIIIIIlllllII) {
        this.x = lllllllllllllllIIlllIIIIIlllllII.x;
        this.y = lllllllllllllllIIlllIIIIIlllllII.y;
        this.z = lllllllllllllllIIlllIIIIIlllllII.z;
        this.w = 1.0f;
    }
}
