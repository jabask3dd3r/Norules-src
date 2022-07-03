package net.minecraft.pathfinding;

public class PathHeap
{
    private /* synthetic */ int count;
    private /* synthetic */ PathPoint[] pathPoints;
    
    public void clearPath() {
        this.count = 0;
    }
    
    public boolean isPathEmpty() {
        return this.count == 0;
    }
    
    private void sortForward(int lllllllllllllIIIIIlIlIllIIlIlIlI) {
        final PathPoint lllllllllllllIIIIIlIlIllIIllIlIl = this.pathPoints[lllllllllllllIIIIIlIlIllIIlIlIlI];
        final float lllllllllllllIIIIIlIlIllIIllIlII = lllllllllllllIIIIIlIlIllIIllIlIl.distanceToTarget;
        while (true) {
            final int lllllllllllllIIIIIlIlIllIIllIIll = 1 + (lllllllllllllIIIIIlIlIllIIlIlIlI << 1);
            final int lllllllllllllIIIIIlIlIllIIllIIlI = lllllllllllllIIIIIlIlIllIIllIIll + 1;
            if (lllllllllllllIIIIIlIlIllIIllIIll >= this.count) {
                break;
            }
            final PathPoint lllllllllllllIIIIIlIlIllIIllIIIl = this.pathPoints[lllllllllllllIIIIIlIlIllIIllIIll];
            final float lllllllllllllIIIIIlIlIllIIllIIII = lllllllllllllIIIIIlIlIllIIllIIIl.distanceToTarget;
            PathPoint lllllllllllllIIIIIlIlIllIIlIlllI = null;
            float lllllllllllllIIIIIlIlIllIIlIllII = 0.0f;
            if (lllllllllllllIIIIIlIlIllIIllIIlI >= this.count) {
                final PathPoint lllllllllllllIIIIIlIlIllIIlIllll = null;
                final float lllllllllllllIIIIIlIlIllIIlIllIl = Float.POSITIVE_INFINITY;
            }
            else {
                lllllllllllllIIIIIlIlIllIIlIlllI = this.pathPoints[lllllllllllllIIIIIlIlIllIIllIIlI];
                lllllllllllllIIIIIlIlIllIIlIllII = lllllllllllllIIIIIlIlIllIIlIlllI.distanceToTarget;
            }
            if (lllllllllllllIIIIIlIlIllIIllIIII < lllllllllllllIIIIIlIlIllIIlIllII) {
                if (lllllllllllllIIIIIlIlIllIIllIIII >= lllllllllllllIIIIIlIlIllIIllIlII) {
                    break;
                }
                this.pathPoints[lllllllllllllIIIIIlIlIllIIlIlIlI] = lllllllllllllIIIIIlIlIllIIllIIIl;
                lllllllllllllIIIIIlIlIllIIllIIIl.index = lllllllllllllIIIIIlIlIllIIlIlIlI;
                lllllllllllllIIIIIlIlIllIIlIlIlI = lllllllllllllIIIIIlIlIllIIllIIll;
            }
            else {
                if (lllllllllllllIIIIIlIlIllIIlIllII >= lllllllllllllIIIIIlIlIllIIllIlII) {
                    break;
                }
                this.pathPoints[lllllllllllllIIIIIlIlIllIIlIlIlI] = lllllllllllllIIIIIlIlIllIIlIlllI;
                lllllllllllllIIIIIlIlIllIIlIlllI.index = lllllllllllllIIIIIlIlIllIIlIlIlI;
                lllllllllllllIIIIIlIlIllIIlIlIlI = lllllllllllllIIIIIlIlIllIIllIIlI;
            }
        }
        this.pathPoints[lllllllllllllIIIIIlIlIllIIlIlIlI] = lllllllllllllIIIIIlIlIllIIllIlIl;
        lllllllllllllIIIIIlIlIllIIllIlIl.index = lllllllllllllIIIIIlIlIllIIlIlIlI;
    }
    
    public PathPoint dequeue() {
        final PathPoint lllllllllllllIIIIIlIlIllIllIIIlI = this.pathPoints[0];
        final PathPoint[] pathPoints = this.pathPoints;
        final int n = 0;
        final PathPoint[] pathPoints2 = this.pathPoints;
        final int count = this.count - 1;
        this.count = count;
        pathPoints[n] = pathPoints2[count];
        this.pathPoints[this.count] = null;
        if (this.count > 0) {
            this.sortForward(0);
        }
        lllllllllllllIIIIIlIlIllIllIIIlI.index = -1;
        return lllllllllllllIIIIIlIlIllIllIIIlI;
    }
    
    public PathPoint addPoint(final PathPoint lllllllllllllIIIIIlIlIllIllIllIl) {
        if (lllllllllllllIIIIIlIlIllIllIllIl.index >= 0) {
            throw new IllegalStateException("OW KNOWS!");
        }
        if (this.count == this.pathPoints.length) {
            final PathPoint[] lllllllllllllIIIIIlIlIllIllIllII = new PathPoint[this.count << 1];
            System.arraycopy(this.pathPoints, 0, lllllllllllllIIIIIlIlIllIllIllII, 0, this.count);
            this.pathPoints = lllllllllllllIIIIIlIlIllIllIllII;
        }
        this.pathPoints[this.count] = lllllllllllllIIIIIlIlIllIllIllIl;
        lllllllllllllIIIIIlIlIllIllIllIl.index = this.count;
        this.sortBack(this.count++);
        return lllllllllllllIIIIIlIlIllIllIllIl;
    }
    
    public PathHeap() {
        this.pathPoints = new PathPoint[128];
    }
    
    public void changeDistance(final PathPoint lllllllllllllIIIIIlIlIllIlIllIlI, final float lllllllllllllIIIIIlIlIllIlIllIIl) {
        final float lllllllllllllIIIIIlIlIllIlIllIII = lllllllllllllIIIIIlIlIllIlIllIlI.distanceToTarget;
        lllllllllllllIIIIIlIlIllIlIllIlI.distanceToTarget = lllllllllllllIIIIIlIlIllIlIllIIl;
        if (lllllllllllllIIIIIlIlIllIlIllIIl < lllllllllllllIIIIIlIlIllIlIllIII) {
            this.sortBack(lllllllllllllIIIIIlIlIllIlIllIlI.index);
        }
        else {
            this.sortForward(lllllllllllllIIIIIlIlIllIlIllIlI.index);
        }
    }
    
    private void sortBack(int lllllllllllllIIIIIlIlIllIlIIIllI) {
        final PathPoint lllllllllllllIIIIIlIlIllIlIIlIll = this.pathPoints[lllllllllllllIIIIIlIlIllIlIIIllI];
        final float lllllllllllllIIIIIlIlIllIlIIlIIl = lllllllllllllIIIIIlIlIllIlIIlIll.distanceToTarget;
        while (lllllllllllllIIIIIlIlIllIlIIIllI > 0) {
            final int lllllllllllllIIIIIlIlIllIlIIlIlI = lllllllllllllIIIIIlIlIllIlIIIllI - 1 >> 1;
            final PathPoint lllllllllllllIIIIIlIlIllIlIIlIII = this.pathPoints[lllllllllllllIIIIIlIlIllIlIIlIlI];
            if (lllllllllllllIIIIIlIlIllIlIIlIIl >= lllllllllllllIIIIIlIlIllIlIIlIII.distanceToTarget) {
                break;
            }
            this.pathPoints[lllllllllllllIIIIIlIlIllIlIIIllI] = lllllllllllllIIIIIlIlIllIlIIlIII;
            lllllllllllllIIIIIlIlIllIlIIlIII.index = lllllllllllllIIIIIlIlIllIlIIIllI;
            lllllllllllllIIIIIlIlIllIlIIIllI = lllllllllllllIIIIIlIlIllIlIIlIlI;
        }
        this.pathPoints[lllllllllllllIIIIIlIlIllIlIIIllI] = lllllllllllllIIIIIlIlIllIlIIlIll;
        lllllllllllllIIIIIlIlIllIlIIlIll.index = lllllllllllllIIIIIlIlIllIlIIIllI;
    }
}
