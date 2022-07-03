package javax.vecmath;

import java.io.*;

public class Point2f extends Tuple2f implements Serializable
{
    public Point2f() {
    }
    
    public Point2f(final Tuple2f lllllllllllllIIlIlIIIlIlIIllIllI) {
        super(lllllllllllllIIlIlIIIlIlIIllIllI);
    }
    
    public final float distanceLinf(final Point2f lllllllllllllIIlIlIIIlIlIIIIllIl) {
        return Math.max(Math.abs(this.x - lllllllllllllIIlIlIIIlIlIIIIllIl.x), Math.abs(this.y - lllllllllllllIIlIlIIIlIlIIIIllIl.y));
    }
    
    public final float distanceSquared(final Point2f lllllllllllllIIlIlIIIlIlIIlIIlll) {
        final float lllllllllllllIIlIlIIIlIlIIlIlIlI = this.x - lllllllllllllIIlIlIIIlIlIIlIIlll.x;
        final float lllllllllllllIIlIlIIIlIlIIlIlIIl = this.y - lllllllllllllIIlIlIIIlIlIIlIIlll.y;
        return lllllllllllllIIlIlIIIlIlIIlIlIlI * lllllllllllllIIlIlIIIlIlIIlIlIlI + lllllllllllllIIlIlIIIlIlIIlIlIIl * lllllllllllllIIlIlIIIlIlIIlIlIIl;
    }
    
    public final float distanceL1(final Point2f lllllllllllllIIlIlIIIlIlIIIlIlIl) {
        return Math.abs(this.x - lllllllllllllIIlIlIIIlIlIIIlIlIl.x) + Math.abs(this.y - lllllllllllllIIlIlIIIlIlIIIlIlIl.y);
    }
    
    public Point2f(final float lllllllllllllIIlIlIIIlIlIlIlIllI, final float lllllllllllllIIlIlIIIlIlIlIlIIlI) {
        super(lllllllllllllIIlIlIIIlIlIlIlIllI, lllllllllllllIIlIlIIIlIlIlIlIIlI);
    }
    
    public Point2f(final Point2d lllllllllllllIIlIlIIIlIlIlIIIIII) {
        super(lllllllllllllIIlIlIIIlIlIlIIIIII);
    }
    
    public Point2f(final Point2f lllllllllllllIIlIlIIIlIlIlIIlIII) {
        super(lllllllllllllIIlIlIIIlIlIlIIlIII);
    }
    
    public Point2f(final float[] lllllllllllllIIlIlIIIlIlIlIIllII) {
        super(lllllllllllllIIlIlIIIlIlIlIIllII);
    }
    
    public final float distance(final Point2f lllllllllllllIIlIlIIIlIlIIIllIll) {
        final float lllllllllllllIIlIlIIIlIlIIIllllI = this.x - lllllllllllllIIlIlIIIlIlIIIllIll.x;
        final float lllllllllllllIIlIlIIIlIlIIIlllIl = this.y - lllllllllllllIIlIlIIIlIlIIIllIll.y;
        return (float)Math.sqrt(lllllllllllllIIlIlIIIlIlIIIllllI * lllllllllllllIIlIlIIIlIlIIIllllI + lllllllllllllIIlIlIIIlIlIIIlllIl * lllllllllllllIIlIlIIIlIlIIIlllIl);
    }
    
    public Point2f(final Tuple2d lllllllllllllIIlIlIIIlIlIIllllII) {
        super(lllllllllllllIIlIlIIIlIlIIllllII);
    }
}
