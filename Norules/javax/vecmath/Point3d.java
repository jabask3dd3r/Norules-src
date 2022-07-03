package javax.vecmath;

import java.io.*;

public class Point3d extends Tuple3d implements Serializable
{
    public final double distanceSquared(final Point3d lllllllllllllIIlIIlIllllIIllIlll) {
        final double lllllllllllllIIlIIlIllllIIlllIll = this.x - lllllllllllllIIlIIlIllllIIllIlll.x;
        final double lllllllllllllIIlIIlIllllIIlllIlI = this.y - lllllllllllllIIlIIlIllllIIllIlll.y;
        final double lllllllllllllIIlIIlIllllIIlllIIl = this.z - lllllllllllllIIlIIlIllllIIllIlll.z;
        return lllllllllllllIIlIIlIllllIIlllIll * lllllllllllllIIlIIlIllllIIlllIll + lllllllllllllIIlIIlIllllIIlllIlI * lllllllllllllIIlIIlIllllIIlllIlI + lllllllllllllIIlIIlIllllIIlllIIl * lllllllllllllIIlIIlIllllIIlllIIl;
    }
    
    public final double distance(final Point3d lllllllllllllIIlIIlIllllIIlIllIl) {
        final double lllllllllllllIIlIIlIllllIIlIllII = this.x - lllllllllllllIIlIIlIllllIIlIllIl.x;
        final double lllllllllllllIIlIIlIllllIIlIlIll = this.y - lllllllllllllIIlIIlIllllIIlIllIl.y;
        final double lllllllllllllIIlIIlIllllIIlIlIlI = this.z - lllllllllllllIIlIIlIllllIIlIllIl.z;
        return Math.sqrt(lllllllllllllIIlIIlIllllIIlIllII * lllllllllllllIIlIIlIllllIIlIllII + lllllllllllllIIlIIlIllllIIlIlIll * lllllllllllllIIlIIlIllllIIlIlIll + lllllllllllllIIlIIlIllllIIlIlIlI * lllllllllllllIIlIIlIllllIIlIlIlI);
    }
    
    public Point3d() {
    }
    
    public Point3d(final Point3d lllllllllllllIIlIIlIllllIlIllIlI) {
        super(lllllllllllllIIlIIlIllllIlIllIlI);
    }
    
    public Point3d(final Tuple3f lllllllllllllIIlIIlIllllIlIIlllI) {
        super(lllllllllllllIIlIIlIllllIlIIlllI);
    }
    
    public Point3d(final Tuple3d lllllllllllllIIlIIlIllllIlIIIllI) {
        super(lllllllllllllIIlIIlIllllIlIIIllI);
    }
    
    public final double distanceL1(final Point3d lllllllllllllIIlIIlIllllIIIlllll) {
        return Math.abs(this.x - lllllllllllllIIlIIlIllllIIIlllll.x) + Math.abs(this.y - lllllllllllllIIlIIlIllllIIIlllll.y) + Math.abs(this.z - lllllllllllllIIlIIlIllllIIIlllll.z);
    }
    
    public Point3d(final double lllllllllllllIIlIIlIllllIllIIllI, final double lllllllllllllIIlIIlIllllIllIIlIl, final double lllllllllllllIIlIIlIllllIllIlIII) {
        super(lllllllllllllIIlIIlIllllIllIIllI, lllllllllllllIIlIIlIllllIllIIlIl, lllllllllllllIIlIIlIllllIllIlIII);
    }
    
    public Point3d(final Point3f lllllllllllllIIlIIlIllllIlIlIlII) {
        super(lllllllllllllIIlIIlIllllIlIlIlII);
    }
    
    public final double distanceLinf(final Point3d lllllllllllllIIlIIlIllllIIIlIlll) {
        final double lllllllllllllIIlIIlIllllIIIllIIl = Math.max(Math.abs(this.x - lllllllllllllIIlIIlIllllIIIlIlll.x), Math.abs(this.y - lllllllllllllIIlIIlIllllIIIlIlll.y));
        return Math.max(lllllllllllllIIlIIlIllllIIIllIIl, Math.abs(this.z - lllllllllllllIIlIIlIllllIIIlIlll.z));
    }
    
    public Point3d(final double[] lllllllllllllIIlIIlIllllIllIIIII) {
        super(lllllllllllllIIlIIlIllllIllIIIII);
    }
    
    public final void project(final Point4d lllllllllllllIIlIIlIllllIIIIlllI) {
        final double lllllllllllllIIlIIlIllllIIIlIIII = 1.0 / lllllllllllllIIlIIlIllllIIIIlllI.w;
        this.x = lllllllllllllIIlIIlIllllIIIIlllI.x * lllllllllllllIIlIIlIllllIIIlIIII;
        this.y = lllllllllllllIIlIIlIllllIIIIlllI.y * lllllllllllllIIlIIlIllllIIIlIIII;
        this.z = lllllllllllllIIlIIlIllllIIIIlllI.z * lllllllllllllIIlIIlIllllIIIlIIII;
    }
}
