package javax.vecmath;

import java.io.*;

public class Point4d extends Tuple4d implements Serializable
{
    public Point4d(final double lllllllllllllIIllIlIlIllIllIIIlI, final double lllllllllllllIIllIlIlIllIlIlllII, final double lllllllllllllIIllIlIlIllIllIIIII, final double lllllllllllllIIllIlIlIllIlIllIlI) {
        super(lllllllllllllIIllIlIlIllIllIIIlI, lllllllllllllIIllIlIlIllIlIlllII, lllllllllllllIIllIlIlIllIllIIIII, lllllllllllllIIllIlIlIllIlIllIlI);
    }
    
    public Point4d(final double[] lllllllllllllIIllIlIlIllIlIlIllI) {
        super(lllllllllllllIIllIlIlIllIlIlIllI);
    }
    
    public final double distanceSquared(final Point4d lllllllllllllIIllIlIlIllIIIlllll) {
        final double lllllllllllllIIllIlIlIllIIlIIlII = this.x - lllllllllllllIIllIlIlIllIIIlllll.x;
        final double lllllllllllllIIllIlIlIllIIlIIIll = this.y - lllllllllllllIIllIlIlIllIIIlllll.y;
        final double lllllllllllllIIllIlIlIllIIlIIIlI = this.z - lllllllllllllIIllIlIlIllIIIlllll.z;
        final double lllllllllllllIIllIlIlIllIIlIIIIl = this.w - lllllllllllllIIllIlIlIllIIIlllll.w;
        return lllllllllllllIIllIlIlIllIIlIIlII * lllllllllllllIIllIlIlIllIIlIIlII + lllllllllllllIIllIlIlIllIIlIIIll * lllllllllllllIIllIlIlIllIIlIIIll + lllllllllllllIIllIlIlIllIIlIIIlI * lllllllllllllIIllIlIlIllIIlIIIlI + lllllllllllllIIllIlIlIllIIlIIIIl * lllllllllllllIIllIlIlIllIIlIIIIl;
    }
    
    public final double distance(final Point4d lllllllllllllIIllIlIlIllIIIlIIll) {
        final double lllllllllllllIIllIlIlIllIIIlIIlI = this.x - lllllllllllllIIllIlIlIllIIIlIIll.x;
        final double lllllllllllllIIllIlIlIllIIIlIIIl = this.y - lllllllllllllIIllIlIlIllIIIlIIll.y;
        final double lllllllllllllIIllIlIlIllIIIlIIII = this.z - lllllllllllllIIllIlIlIllIIIlIIll.z;
        final double lllllllllllllIIllIlIlIllIIIIllll = this.w - lllllllllllllIIllIlIlIllIIIlIIll.w;
        return Math.sqrt(lllllllllllllIIllIlIlIllIIIlIIlI * lllllllllllllIIllIlIlIllIIIlIIlI + lllllllllllllIIllIlIlIllIIIlIIIl * lllllllllllllIIllIlIlIllIIIlIIIl + lllllllllllllIIllIlIlIllIIIlIIII * lllllllllllllIIllIlIlIllIIIlIIII + lllllllllllllIIllIlIlIllIIIIllll * lllllllllllllIIllIlIlIllIIIIllll);
    }
    
    public Point4d(final Point4d lllllllllllllIIllIlIlIllIlIIlllI) {
        super(lllllllllllllIIllIlIlIllIlIIlllI);
    }
    
    public Point4d(final Point4f lllllllllllllIIllIlIlIllIlIIlIII) {
        super(lllllllllllllIIllIlIlIllIlIIlIII);
    }
    
    public Point4d(final Tuple3d lllllllllllllIIllIlIlIllIIllIllI) {
        super(lllllllllllllIIllIlIlIllIIllIllI.x, lllllllllllllIIllIlIlIllIIllIllI.y, lllllllllllllIIllIlIlIllIIllIllI.z, 1.0);
    }
    
    public Point4d(final Tuple4d lllllllllllllIIllIlIlIllIIllllII) {
        super(lllllllllllllIIllIlIlIllIIllllII);
    }
    
    public Point4d() {
    }
    
    public Point4d(final Tuple4f lllllllllllllIIllIlIlIllIlIIIlII) {
        super(lllllllllllllIIllIlIlIllIlIIIlII);
    }
    
    public final void project(final Point4d lllllllllllllIIllIlIlIlIlllIllll) {
        final double lllllllllllllIIllIlIlIlIllllIIIl = 1.0 / lllllllllllllIIllIlIlIlIlllIllll.w;
        this.x = lllllllllllllIIllIlIlIlIlllIllll.x * lllllllllllllIIllIlIlIlIllllIIIl;
        this.y = lllllllllllllIIllIlIlIlIlllIllll.y * lllllllllllllIIllIlIlIlIllllIIIl;
        this.z = lllllllllllllIIllIlIlIlIlllIllll.z * lllllllllllllIIllIlIlIlIllllIIIl;
        this.w = 1.0;
    }
    
    public final double distanceL1(final Point4d lllllllllllllIIllIlIlIllIIIIIlIl) {
        return Math.abs(this.x - lllllllllllllIIllIlIlIllIIIIIlIl.x) + Math.abs(this.y - lllllllllllllIIllIlIlIllIIIIIlIl.y) + Math.abs(this.z - lllllllllllllIIllIlIlIllIIIIIlIl.z) + Math.abs(this.w - lllllllllllllIIllIlIlIllIIIIIlIl.w);
    }
    
    public final void set(final Tuple3d lllllllllllllIIllIlIlIllIIlIllll) {
        this.x = lllllllllllllIIllIlIlIllIIlIllll.x;
        this.y = lllllllllllllIIllIlIlIllIIlIllll.y;
        this.z = lllllllllllllIIllIlIlIllIIlIllll.z;
        this.w = 1.0;
    }
    
    public final double distanceLinf(final Point4d lllllllllllllIIllIlIlIlIllllllIl) {
        final double lllllllllllllIIllIlIlIlIllllllII = Math.max(Math.abs(this.x - lllllllllllllIIllIlIlIlIllllllIl.x), Math.abs(this.y - lllllllllllllIIllIlIlIlIllllllIl.y));
        final double lllllllllllllIIllIlIlIlIlllllIll = Math.max(Math.abs(this.z - lllllllllllllIIllIlIlIlIllllllIl.z), Math.abs(this.w - lllllllllllllIIllIlIlIlIllllllIl.w));
        return Math.max(lllllllllllllIIllIlIlIlIllllllII, lllllllllllllIIllIlIlIlIlllllIll);
    }
}
