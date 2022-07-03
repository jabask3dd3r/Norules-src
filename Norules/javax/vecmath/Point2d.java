package javax.vecmath;

import java.io.*;

public class Point2d extends Tuple2d implements Serializable
{
    public final double distanceL1(final Point2d llllllllllllllIIlIIlIIlIIIIlllIl) {
        return Math.abs(this.x - llllllllllllllIIlIIlIIlIIIIlllIl.x) + Math.abs(this.y - llllllllllllllIIlIIlIIlIIIIlllIl.y);
    }
    
    public Point2d(final Tuple2f llllllllllllllIIlIIlIIlIIIllllII) {
        super(llllllllllllllIIlIIlIIlIIIllllII);
    }
    
    public final double distance(final Point2d llllllllllllllIIlIIlIIlIIIlIIlll) {
        final double llllllllllllllIIlIIlIIlIIIlIIllI = this.x - llllllllllllllIIlIIlIIlIIIlIIlll.x;
        final double llllllllllllllIIlIIlIIlIIIlIIlIl = this.y - llllllllllllllIIlIIlIIlIIIlIIlll.y;
        return Math.sqrt(llllllllllllllIIlIIlIIlIIIlIIllI * llllllllllllllIIlIIlIIlIIIlIIllI + llllllllllllllIIlIIlIIlIIIlIIlIl * llllllllllllllIIlIIlIIlIIIlIIlIl);
    }
    
    public final double distanceLinf(final Point2d llllllllllllllIIlIIlIIlIIIIlIlIl) {
        return Math.max(Math.abs(this.x - llllllllllllllIIlIIlIIlIIIIlIlIl.x), Math.abs(this.y - llllllllllllllIIlIIlIIlIIIIlIlIl.y));
    }
    
    public final double distanceSquared(final Point2d llllllllllllllIIlIIlIIlIIIllIIll) {
        final double llllllllllllllIIlIIlIIlIIIllIIlI = this.x - llllllllllllllIIlIIlIIlIIIllIIll.x;
        final double llllllllllllllIIlIIlIIlIIIllIIIl = this.y - llllllllllllllIIlIIlIIlIIIllIIll.y;
        return llllllllllllllIIlIIlIIlIIIllIIlI * llllllllllllllIIlIIlIIlIIIllIIlI + llllllllllllllIIlIIlIIlIIIllIIIl * llllllllllllllIIlIIlIIlIIIllIIIl;
    }
    
    public Point2d(final Tuple2d llllllllllllllIIlIIlIIlIIlIIIlII) {
        super(llllllllllllllIIlIIlIIlIIlIIIlII);
    }
    
    public Point2d(final Point2f llllllllllllllIIlIIlIIlIIlIIlIII) {
        super(llllllllllllllIIlIIlIIlIIlIIlIII);
    }
    
    public Point2d() {
    }
    
    public Point2d(final double[] llllllllllllllIIlIIlIIlIIlIlIlII) {
        super(llllllllllllllIIlIIlIIlIIlIlIlII);
    }
    
    public Point2d(final Point2d llllllllllllllIIlIIlIIlIIlIlIIII) {
        super(llllllllllllllIIlIIlIIlIIlIlIIII);
    }
    
    public Point2d(final double llllllllllllllIIlIIlIIlIIlIllllI, final double llllllllllllllIIlIIlIIlIIlIllIlI) {
        super(llllllllllllllIIlIIlIIlIIlIllllI, llllllllllllllIIlIIlIIlIIlIllIlI);
    }
}
