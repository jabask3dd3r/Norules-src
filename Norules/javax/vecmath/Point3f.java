package javax.vecmath;

import java.io.*;

public class Point3f extends Tuple3f implements Serializable
{
    public Point3f(final Tuple3d llllllllllllllIIllllIlllIIIlIlll) {
        super(llllllllllllllIIllllIlllIIIlIlll);
    }
    
    public final float distanceSquared(final Point3f llllllllllllllIIllllIlllIIIIlIll) {
        final float llllllllllllllIIllllIlllIIIIlIlI = this.x - llllllllllllllIIllllIlllIIIIlIll.x;
        final float llllllllllllllIIllllIlllIIIIlIIl = this.y - llllllllllllllIIllllIlllIIIIlIll.y;
        final float llllllllllllllIIllllIlllIIIIlIII = this.z - llllllllllllllIIllllIlllIIIIlIll.z;
        return llllllllllllllIIllllIlllIIIIlIlI * llllllllllllllIIllllIlllIIIIlIlI + llllllllllllllIIllllIlllIIIIlIIl * llllllllllllllIIllllIlllIIIIlIIl + llllllllllllllIIllllIlllIIIIlIII * llllllllllllllIIllllIlllIIIIlIII;
    }
    
    public Point3f(final Tuple3f llllllllllllllIIllllIlllIIIllIll) {
        super(llllllllllllllIIllllIlllIIIllIll);
    }
    
    public Point3f(final Point3f llllllllllllllIIllllIlllIIlIlIIl) {
        super(llllllllllllllIIllllIlllIIlIlIIl);
    }
    
    public Point3f(final Point3d llllllllllllllIIllllIlllIIlIIIIl) {
        super(llllllllllllllIIllllIlllIIlIIIIl);
    }
    
    public final void project(final Point4f llllllllllllllIIllllIllIllIlllIl) {
        final float llllllllllllllIIllllIllIllIlllll = 1.0f / llllllllllllllIIllllIllIllIlllIl.w;
        this.x = llllllllllllllIIllllIllIllIlllIl.x * llllllllllllllIIllllIllIllIlllll;
        this.y = llllllllllllllIIllllIllIllIlllIl.y * llllllllllllllIIllllIllIllIlllll;
        this.z = llllllllllllllIIllllIllIllIlllIl.z * llllllllllllllIIllllIllIllIlllll;
    }
    
    public final float distanceLinf(final Point3f llllllllllllllIIllllIllIlllIIllI) {
        final float llllllllllllllIIllllIllIlllIlIII = Math.max(Math.abs(this.x - llllllllllllllIIllllIllIlllIIllI.x), Math.abs(this.y - llllllllllllllIIllllIllIlllIIllI.y));
        return Math.max(llllllllllllllIIllllIllIlllIlIII, Math.abs(this.z - llllllllllllllIIllllIllIlllIIllI.z));
    }
    
    public final float distanceL1(final Point3f llllllllllllllIIllllIllIlllIlllI) {
        return Math.abs(this.x - llllllllllllllIIllllIllIlllIlllI.x) + Math.abs(this.y - llllllllllllllIIllllIllIlllIlllI.y) + Math.abs(this.z - llllllllllllllIIllllIllIlllIlllI.z);
    }
    
    public Point3f(final float[] llllllllllllllIIllllIlllIIlIllIl) {
        super(llllllllllllllIIllllIlllIIlIllIl);
    }
    
    public Point3f() {
    }
    
    public final float distance(final Point3f llllllllllllllIIllllIllIllllllII) {
        final float llllllllllllllIIllllIllIlllllIll = this.x - llllllllllllllIIllllIllIllllllII.x;
        final float llllllllllllllIIllllIllIlllllIlI = this.y - llllllllllllllIIllllIllIllllllII.y;
        final float llllllllllllllIIllllIllIlllllIIl = this.z - llllllllllllllIIllllIllIllllllII.z;
        return (float)Math.sqrt(llllllllllllllIIllllIllIlllllIll * llllllllllllllIIllllIllIlllllIll + llllllllllllllIIllllIllIlllllIlI * llllllllllllllIIllllIllIlllllIlI + llllllllllllllIIllllIllIlllllIIl * llllllllllllllIIllllIllIlllllIIl);
    }
    
    public Point3f(final float llllllllllllllIIllllIlllIIlllIIl, final float llllllllllllllIIllllIlllIIllIlII, final float llllllllllllllIIllllIlllIIllIlll) {
        super(llllllllllllllIIllllIlllIIlllIIl, llllllllllllllIIllllIlllIIllIlII, llllllllllllllIIllllIlllIIllIlll);
    }
}
