package net.minecraft.pathfinding;

import java.util.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import javax.annotation.*;
import com.google.common.collect.*;
import net.minecraft.util.math.*;

public class PathFinder
{
    private final /* synthetic */ PathPoint[] pathOptions;
    private final /* synthetic */ NodeProcessor nodeProcessor;
    private final /* synthetic */ Set<PathPoint> closedSet;
    private final /* synthetic */ PathHeap path;
    
    @Nullable
    public Path findPath(final IBlockAccess llllllllllllllllIlIllllIllllIllI, final EntityLiving llllllllllllllllIlIllllIllllIlIl, final Entity llllllllllllllllIlIllllIllllIlII, final float llllllllllllllllIlIllllIllllIIll) {
        return this.findPath(llllllllllllllllIlIllllIllllIllI, llllllllllllllllIlIllllIllllIlIl, llllllllllllllllIlIllllIllllIlII.posX, llllllllllllllllIlIllllIllllIlII.getEntityBoundingBox().minY, llllllllllllllllIlIllllIllllIlII.posZ, llllllllllllllllIlIllllIllllIIll);
    }
    
    @Nullable
    private Path findPath(final IBlockAccess llllllllllllllllIlIllllIllIllIII, final EntityLiving llllllllllllllllIlIllllIllIlIlll, final double llllllllllllllllIlIllllIllIIllII, final double llllllllllllllllIlIllllIllIIlIll, final double llllllllllllllllIlIllllIllIlIlII, final float llllllllllllllllIlIllllIllIIlIIl) {
        this.path.clearPath();
        this.nodeProcessor.initProcessor(llllllllllllllllIlIllllIllIllIII, llllllllllllllllIlIllllIllIlIlll);
        final PathPoint llllllllllllllllIlIllllIllIlIIlI = this.nodeProcessor.getStart();
        final PathPoint llllllllllllllllIlIllllIllIlIIIl = this.nodeProcessor.getPathPointToCoords(llllllllllllllllIlIllllIllIIllII, llllllllllllllllIlIllllIllIIlIll, llllllllllllllllIlIllllIllIlIlII);
        final Path llllllllllllllllIlIllllIllIlIIII = this.findPath(llllllllllllllllIlIllllIllIlIIlI, llllllllllllllllIlIllllIllIlIIIl, llllllllllllllllIlIllllIllIIlIIl);
        this.nodeProcessor.postProcess();
        return llllllllllllllllIlIllllIllIlIIII;
    }
    
    @Nullable
    private Path findPath(final PathPoint llllllllllllllllIlIllllIlIlIlIll, final PathPoint llllllllllllllllIlIllllIlIlIlIlI, final float llllllllllllllllIlIllllIlIllIllI) {
        llllllllllllllllIlIllllIlIlIlIll.totalPathDistance = 0.0f;
        llllllllllllllllIlIllllIlIlIlIll.distanceToNext = llllllllllllllllIlIllllIlIlIlIll.distanceManhattan(llllllllllllllllIlIllllIlIlIlIlI);
        llllllllllllllllIlIllllIlIlIlIll.distanceToTarget = llllllllllllllllIlIllllIlIlIlIll.distanceToNext;
        this.path.clearPath();
        this.closedSet.clear();
        this.path.addPoint(llllllllllllllllIlIllllIlIlIlIll);
        PathPoint llllllllllllllllIlIllllIlIllIlIl = llllllllllllllllIlIllllIlIlIlIll;
        int llllllllllllllllIlIllllIlIllIlII = 0;
        while (!this.path.isPathEmpty()) {
            if (++llllllllllllllllIlIllllIlIllIlII >= 200) {
                break;
            }
            final PathPoint llllllllllllllllIlIllllIlIllIIll = this.path.dequeue();
            if (llllllllllllllllIlIllllIlIllIIll.equals(llllllllllllllllIlIllllIlIlIlIlI)) {
                llllllllllllllllIlIllllIlIllIlIl = llllllllllllllllIlIllllIlIlIlIlI;
                break;
            }
            if (llllllllllllllllIlIllllIlIllIIll.distanceManhattan(llllllllllllllllIlIllllIlIlIlIlI) < llllllllllllllllIlIllllIlIllIlIl.distanceManhattan(llllllllllllllllIlIllllIlIlIlIlI)) {
                llllllllllllllllIlIllllIlIllIlIl = llllllllllllllllIlIllllIlIllIIll;
            }
            llllllllllllllllIlIllllIlIllIIll.visited = true;
            for (int llllllllllllllllIlIllllIlIllIIlI = this.nodeProcessor.findPathOptions(this.pathOptions, llllllllllllllllIlIllllIlIllIIll, llllllllllllllllIlIllllIlIlIlIlI, llllllllllllllllIlIllllIlIllIllI), llllllllllllllllIlIllllIlIllIIIl = 0; llllllllllllllllIlIllllIlIllIIIl < llllllllllllllllIlIllllIlIllIIlI; ++llllllllllllllllIlIllllIlIllIIIl) {
                final PathPoint llllllllllllllllIlIllllIlIllIIII = this.pathOptions[llllllllllllllllIlIllllIlIllIIIl];
                final float llllllllllllllllIlIllllIlIlIllll = llllllllllllllllIlIllllIlIllIIll.distanceManhattan(llllllllllllllllIlIllllIlIllIIII);
                llllllllllllllllIlIllllIlIllIIII.distanceFromOrigin = llllllllllllllllIlIllllIlIllIIll.distanceFromOrigin + llllllllllllllllIlIllllIlIlIllll;
                llllllllllllllllIlIllllIlIllIIII.cost = llllllllllllllllIlIllllIlIlIllll + llllllllllllllllIlIllllIlIllIIII.costMalus;
                final float llllllllllllllllIlIllllIlIlIlllI = llllllllllllllllIlIllllIlIllIIll.totalPathDistance + llllllllllllllllIlIllllIlIllIIII.cost;
                if (llllllllllllllllIlIllllIlIllIIII.distanceFromOrigin < llllllllllllllllIlIllllIlIllIllI && (!llllllllllllllllIlIllllIlIllIIII.isAssigned() || llllllllllllllllIlIllllIlIlIlllI < llllllllllllllllIlIllllIlIllIIII.totalPathDistance)) {
                    llllllllllllllllIlIllllIlIllIIII.previous = llllllllllllllllIlIllllIlIllIIll;
                    llllllllllllllllIlIllllIlIllIIII.totalPathDistance = llllllllllllllllIlIllllIlIlIlllI;
                    llllllllllllllllIlIllllIlIllIIII.distanceToNext = llllllllllllllllIlIllllIlIllIIII.distanceManhattan(llllllllllllllllIlIllllIlIlIlIlI) + llllllllllllllllIlIllllIlIllIIII.costMalus;
                    if (llllllllllllllllIlIllllIlIllIIII.isAssigned()) {
                        this.path.changeDistance(llllllllllllllllIlIllllIlIllIIII, llllllllllllllllIlIllllIlIllIIII.totalPathDistance + llllllllllllllllIlIllllIlIllIIII.distanceToNext);
                    }
                    else {
                        llllllllllllllllIlIllllIlIllIIII.distanceToTarget = llllllllllllllllIlIllllIlIllIIII.totalPathDistance + llllllllllllllllIlIllllIlIllIIII.distanceToNext;
                        this.path.addPoint(llllllllllllllllIlIllllIlIllIIII);
                    }
                }
            }
        }
        if (llllllllllllllllIlIllllIlIllIlIl == llllllllllllllllIlIllllIlIlIlIll) {
            return null;
        }
        final Path llllllllllllllllIlIllllIlIlIllIl = this.createEntityPath(llllllllllllllllIlIllllIlIlIlIll, llllllllllllllllIlIllllIlIllIlIl);
        return llllllllllllllllIlIllllIlIlIllIl;
    }
    
    private Path createEntityPath(final PathPoint llllllllllllllllIlIllllIlIIllIll, final PathPoint llllllllllllllllIlIllllIlIIllIlI) {
        int llllllllllllllllIlIllllIlIIllIIl = 1;
        for (PathPoint llllllllllllllllIlIllllIlIIllIII = llllllllllllllllIlIllllIlIIllIlI; llllllllllllllllIlIllllIlIIllIII.previous != null; llllllllllllllllIlIllllIlIIllIII = llllllllllllllllIlIllllIlIIllIII.previous) {
            ++llllllllllllllllIlIllllIlIIllIIl;
        }
        final PathPoint[] llllllllllllllllIlIllllIlIIlIlll = new PathPoint[llllllllllllllllIlIllllIlIIllIIl];
        PathPoint llllllllllllllllIlIllllIlIIlIllI = llllllllllllllllIlIllllIlIIllIlI;
        --llllllllllllllllIlIllllIlIIllIIl;
        llllllllllllllllIlIllllIlIIlIlll[llllllllllllllllIlIllllIlIIllIIl] = llllllllllllllllIlIllllIlIIllIlI;
        while (llllllllllllllllIlIllllIlIIlIllI.previous != null) {
            llllllllllllllllIlIllllIlIIlIllI = llllllllllllllllIlIllllIlIIlIllI.previous;
            --llllllllllllllllIlIllllIlIIllIIl;
            llllllllllllllllIlIllllIlIIlIlll[llllllllllllllllIlIllllIlIIllIIl] = llllllllllllllllIlIllllIlIIlIllI;
        }
        return new Path(llllllllllllllllIlIllllIlIIlIlll);
    }
    
    public PathFinder(final NodeProcessor llllllllllllllllIlIlllllIIIIIlII) {
        this.path = new PathHeap();
        this.closedSet = (Set<PathPoint>)Sets.newHashSet();
        this.pathOptions = new PathPoint[32];
        this.nodeProcessor = llllllllllllllllIlIlllllIIIIIlII;
    }
    
    @Nullable
    public Path findPath(final IBlockAccess llllllllllllllllIlIllllIlllIllII, final EntityLiving llllllllllllllllIlIllllIlllIlIll, final BlockPos llllllllllllllllIlIllllIlllIIlIl, final float llllllllllllllllIlIllllIlllIlIIl) {
        return this.findPath(llllllllllllllllIlIllllIlllIllII, llllllllllllllllIlIllllIlllIlIll, llllllllllllllllIlIllllIlllIIlIl.getX() + 0.5f, llllllllllllllllIlIllllIlllIIlIl.getY() + 0.5f, llllllllllllllllIlIllllIlllIIlIl.getZ() + 0.5f, llllllllllllllllIlIllllIlllIlIIl);
    }
}
