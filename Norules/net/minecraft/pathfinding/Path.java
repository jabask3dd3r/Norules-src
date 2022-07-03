package net.minecraft.pathfinding;

import net.minecraft.util.math.*;
import net.minecraft.network.*;
import net.minecraft.entity.*;
import javax.annotation.*;

public class Path
{
    private /* synthetic */ PathPoint[] openSet;
    private /* synthetic */ PathPoint target;
    private /* synthetic */ PathPoint[] closedSet;
    private final /* synthetic */ PathPoint[] points;
    private /* synthetic */ int pathLength;
    private /* synthetic */ int currentPathIndex;
    
    public Vec3d getCurrentPos() {
        final PathPoint lIIlIlIlllIIl = this.points[this.currentPathIndex];
        return new Vec3d(lIIlIlIlllIIl.xCoord, lIIlIlIlllIIl.yCoord, lIIlIlIlllIIl.zCoord);
    }
    
    public int getCurrentPathLength() {
        return this.pathLength;
    }
    
    public void incrementPathIndex() {
        ++this.currentPathIndex;
    }
    
    public static Path read(final PacketBuffer lIIlIlIIlIIll) {
        final int lIIlIlIIlllII = lIIlIlIIlIIll.readInt();
        final PathPoint lIIlIlIIllIll = PathPoint.createFromBuffer(lIIlIlIIlIIll);
        final PathPoint[] lIIlIlIIllIlI = new PathPoint[lIIlIlIIlIIll.readInt()];
        for (int lIIlIlIIllIIl = 0; lIIlIlIIllIIl < lIIlIlIIllIlI.length; ++lIIlIlIIllIIl) {
            lIIlIlIIllIlI[lIIlIlIIllIIl] = PathPoint.createFromBuffer(lIIlIlIIlIIll);
        }
        final PathPoint[] lIIlIlIIllIII = new PathPoint[lIIlIlIIlIIll.readInt()];
        for (int lIIlIlIIlIlll = 0; lIIlIlIIlIlll < lIIlIlIIllIII.length; ++lIIlIlIIlIlll) {
            lIIlIlIIllIII[lIIlIlIIlIlll] = PathPoint.createFromBuffer(lIIlIlIIlIIll);
        }
        final PathPoint[] lIIlIlIIlIllI = new PathPoint[lIIlIlIIlIIll.readInt()];
        for (int lIIlIlIIlIlIl = 0; lIIlIlIIlIlIl < lIIlIlIIlIllI.length; ++lIIlIlIIlIlIl) {
            lIIlIlIIlIllI[lIIlIlIIlIlIl] = PathPoint.createFromBuffer(lIIlIlIIlIIll);
        }
        final Path lIIlIlIIlIlII = new Path(lIIlIlIIllIlI);
        lIIlIlIIlIlII.openSet = lIIlIlIIllIII;
        lIIlIlIIlIlII.closedSet = lIIlIlIIlIllI;
        lIIlIlIIlIlII.target = lIIlIlIIllIll;
        lIIlIlIIlIlII.currentPathIndex = lIIlIlIIlllII;
        return lIIlIlIIlIlII;
    }
    
    public boolean isFinished() {
        return this.currentPathIndex >= this.pathLength;
    }
    
    public Vec3d getPosition(final Entity lIIlIlIllllll) {
        return this.getVectorFromIndex(lIIlIlIllllll, this.currentPathIndex);
    }
    
    public int getCurrentPathIndex() {
        return this.currentPathIndex;
    }
    
    @Nullable
    public PathPoint getFinalPathPoint() {
        return (this.pathLength > 0) ? this.points[this.pathLength - 1] : null;
    }
    
    public void setCurrentPathIndex(final int lIIlIllIlIlIl) {
        this.currentPathIndex = lIIlIllIlIlIl;
    }
    
    public void setCurrentPathLength(final int lIIlIllIllllI) {
        this.pathLength = lIIlIllIllllI;
    }
    
    public PathPoint getTarget() {
        return this.target;
    }
    
    public PathPoint[] getClosedSet() {
        return this.closedSet;
    }
    
    public PathPoint[] getOpenSet() {
        return this.openSet;
    }
    
    public Path(final PathPoint[] lIIlIllllllll) {
        this.openSet = new PathPoint[0];
        this.closedSet = new PathPoint[0];
        this.points = lIIlIllllllll;
        this.pathLength = lIIlIllllllll.length;
    }
    
    public void setPoint(final int lIIlIlllIlIll, final PathPoint lIIlIlllIIlll) {
        this.points[lIIlIlllIlIll] = lIIlIlllIIlll;
    }
    
    public PathPoint getPathPointFromIndex(final int lIIlIllllIIII) {
        return this.points[lIIlIllllIIII];
    }
    
    public Vec3d getVectorFromIndex(final Entity lIIlIllIIIlll, final int lIIlIllIIllII) {
        final double lIIlIllIIlIll = this.points[lIIlIllIIllII].xCoord + (int)(lIIlIllIIIlll.width + 1.0f) * 0.5;
        final double lIIlIllIIlIlI = this.points[lIIlIllIIllII].yCoord;
        final double lIIlIllIIlIIl = this.points[lIIlIllIIllII].zCoord + (int)(lIIlIllIIIlll.width + 1.0f) * 0.5;
        return new Vec3d(lIIlIllIIlIll, lIIlIllIIlIlI, lIIlIllIIlIIl);
    }
    
    public boolean isSamePath(final Path lIIlIlIllIIlI) {
        if (lIIlIlIllIIlI == null) {
            return false;
        }
        if (lIIlIlIllIIlI.points.length != this.points.length) {
            return false;
        }
        for (int lIIlIlIllIIIl = 0; lIIlIlIllIIIl < this.points.length; ++lIIlIlIllIIIl) {
            if (this.points[lIIlIlIllIIIl].xCoord != lIIlIlIllIIlI.points[lIIlIlIllIIIl].xCoord || this.points[lIIlIlIllIIIl].yCoord != lIIlIlIllIIlI.points[lIIlIlIllIIIl].yCoord || this.points[lIIlIlIllIIIl].zCoord != lIIlIlIllIIlI.points[lIIlIlIllIIIl].zCoord) {
                return false;
            }
        }
        return true;
    }
}
