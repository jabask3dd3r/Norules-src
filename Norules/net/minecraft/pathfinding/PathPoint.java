package net.minecraft.pathfinding;

import net.minecraft.network.*;
import net.minecraft.util.math.*;

public class PathPoint
{
    public final /* synthetic */ int zCoord;
    public final /* synthetic */ int yCoord;
    private final /* synthetic */ int hash;
    public /* synthetic */ float costMalus;
    public /* synthetic */ PathNodeType nodeType;
    public /* synthetic */ boolean visited;
    public /* synthetic */ PathPoint previous;
    public final /* synthetic */ int xCoord;
    public /* synthetic */ int index;
    public /* synthetic */ float totalPathDistance;
    public /* synthetic */ float distanceToNext;
    public /* synthetic */ float cost;
    public /* synthetic */ float distanceToTarget;
    public /* synthetic */ float distanceFromOrigin;
    
    public static PathPoint createFromBuffer(final PacketBuffer lllllllllllllIlllIIlIlIIIllIlllI) {
        final PathPoint lllllllllllllIlllIIlIlIIIllIllll = new PathPoint(lllllllllllllIlllIIlIlIIIllIlllI.readInt(), lllllllllllllIlllIIlIlIIIllIlllI.readInt(), lllllllllllllIlllIIlIlIIIllIlllI.readInt());
        lllllllllllllIlllIIlIlIIIllIllll.distanceFromOrigin = lllllllllllllIlllIIlIlIIIllIlllI.readFloat();
        lllllllllllllIlllIIlIlIIIllIllll.cost = lllllllllllllIlllIIlIlIIIllIlllI.readFloat();
        lllllllllllllIlllIIlIlIIIllIllll.costMalus = lllllllllllllIlllIIlIlIIIllIlllI.readFloat();
        lllllllllllllIlllIIlIlIIIllIllll.visited = lllllllllllllIlllIIlIlIIIllIlllI.readBoolean();
        lllllllllllllIlllIIlIlIIIllIllll.nodeType = PathNodeType.values()[lllllllllllllIlllIIlIlIIIllIlllI.readInt()];
        lllllllllllllIlllIIlIlIIIllIllll.distanceToTarget = lllllllllllllIlllIIlIlIIIllIlllI.readFloat();
        return lllllllllllllIlllIIlIlIIIllIllll;
    }
    
    public float distanceToSquared(final PathPoint lllllllllllllIlllIIlIlIIlIIlllII) {
        final float lllllllllllllIlllIIlIlIIlIIllIll = (float)(lllllllllllllIlllIIlIlIIlIIlllII.xCoord - this.xCoord);
        final float lllllllllllllIlllIIlIlIIlIIllIlI = (float)(lllllllllllllIlllIIlIlIIlIIlllII.yCoord - this.yCoord);
        final float lllllllllllllIlllIIlIlIIlIIllIIl = (float)(lllllllllllllIlllIIlIlIIlIIlllII.zCoord - this.zCoord);
        return lllllllllllllIlllIIlIlIIlIIllIll * lllllllllllllIlllIIlIlIIlIIllIll + lllllllllllllIlllIIlIlIIlIIllIlI * lllllllllllllIlllIIlIlIIlIIllIlI + lllllllllllllIlllIIlIlIIlIIllIIl * lllllllllllllIlllIIlIlIIlIIllIIl;
    }
    
    public float distanceManhattan(final PathPoint lllllllllllllIlllIIlIlIIlIIIllIl) {
        final float lllllllllllllIlllIIlIlIIlIIIllII = (float)Math.abs(lllllllllllllIlllIIlIlIIlIIIllIl.xCoord - this.xCoord);
        final float lllllllllllllIlllIIlIlIIlIIIlIll = (float)Math.abs(lllllllllllllIlllIIlIlIIlIIIllIl.yCoord - this.yCoord);
        final float lllllllllllllIlllIIlIlIIlIIIlIlI = (float)Math.abs(lllllllllllllIlllIIlIlIIlIIIllIl.zCoord - this.zCoord);
        return lllllllllllllIlllIIlIlIIlIIIllII + lllllllllllllIlllIIlIlIIlIIIlIll + lllllllllllllIlllIIlIlIIlIIIlIlI;
    }
    
    public float distanceTo(final PathPoint lllllllllllllIlllIIlIlIIlIlIIllI) {
        final float lllllllllllllIlllIIlIlIIlIlIlIlI = (float)(lllllllllllllIlllIIlIlIIlIlIIllI.xCoord - this.xCoord);
        final float lllllllllllllIlllIIlIlIIlIlIlIIl = (float)(lllllllllllllIlllIIlIlIIlIlIIllI.yCoord - this.yCoord);
        final float lllllllllllllIlllIIlIlIIlIlIlIII = (float)(lllllllllllllIlllIIlIlIIlIlIIllI.zCoord - this.zCoord);
        return MathHelper.sqrt(lllllllllllllIlllIIlIlIIlIlIlIlI * lllllllllllllIlllIIlIlIIlIlIlIlI + lllllllllllllIlllIIlIlIIlIlIlIIl * lllllllllllllIlllIIlIlIIlIlIlIIl + lllllllllllllIlllIIlIlIIlIlIlIII * lllllllllllllIlllIIlIlIIlIlIlIII);
    }
    
    public PathPoint cloneMove(final int lllllllllllllIlllIIlIlIIlIlllllI, final int lllllllllllllIlllIIlIlIIllIIIIlI, final int lllllllllllllIlllIIlIlIIllIIIIIl) {
        final PathPoint lllllllllllllIlllIIlIlIIllIIIIII = new PathPoint(lllllllllllllIlllIIlIlIIlIlllllI, lllllllllllllIlllIIlIlIIllIIIIlI, lllllllllllllIlllIIlIlIIllIIIIIl);
        lllllllllllllIlllIIlIlIIllIIIIII.index = this.index;
        lllllllllllllIlllIIlIlIIllIIIIII.totalPathDistance = this.totalPathDistance;
        lllllllllllllIlllIIlIlIIllIIIIII.distanceToNext = this.distanceToNext;
        lllllllllllllIlllIIlIlIIllIIIIII.distanceToTarget = this.distanceToTarget;
        lllllllllllllIlllIIlIlIIllIIIIII.previous = this.previous;
        lllllllllllllIlllIIlIlIIllIIIIII.visited = this.visited;
        lllllllllllllIlllIIlIlIIllIIIIII.distanceFromOrigin = this.distanceFromOrigin;
        lllllllllllllIlllIIlIlIIllIIIIII.cost = this.cost;
        lllllllllllllIlllIIlIlIIllIIIIII.costMalus = this.costMalus;
        lllllllllllllIlllIIlIlIIllIIIIII.nodeType = this.nodeType;
        return lllllllllllllIlllIIlIlIIllIIIIII;
    }
    
    @Override
    public int hashCode() {
        return this.hash;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder(String.valueOf(this.xCoord)).append(", ").append(this.yCoord).append(", ").append(this.zCoord));
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIlllIIlIlIIIlllllIl) {
        if (!(lllllllllllllIlllIIlIlIIIlllllIl instanceof PathPoint)) {
            return false;
        }
        final PathPoint lllllllllllllIlllIIlIlIIIlllllll = (PathPoint)lllllllllllllIlllIIlIlIIIlllllIl;
        return this.hash == lllllllllllllIlllIIlIlIIIlllllll.hash && this.xCoord == lllllllllllllIlllIIlIlIIIlllllll.xCoord && this.yCoord == lllllllllllllIlllIIlIlIIIlllllll.yCoord && this.zCoord == lllllllllllllIlllIIlIlIIIlllllll.zCoord;
    }
    
    public PathPoint(final int lllllllllllllIlllIIlIlIIllIlIIII, final int lllllllllllllIlllIIlIlIIllIIllll, final int lllllllllllllIlllIIlIlIIllIIlllI) {
        this.index = -1;
        this.nodeType = PathNodeType.BLOCKED;
        this.xCoord = lllllllllllllIlllIIlIlIIllIlIIII;
        this.yCoord = lllllllllllllIlllIIlIlIIllIIllll;
        this.zCoord = lllllllllllllIlllIIlIlIIllIIlllI;
        this.hash = makeHash(lllllllllllllIlllIIlIlIIllIlIIII, lllllllllllllIlllIIlIlIIllIIllll, lllllllllllllIlllIIlIlIIllIIlllI);
    }
    
    public static int makeHash(final int lllllllllllllIlllIIlIlIIlIllIlII, final int lllllllllllllIlllIIlIlIIlIllIIll, final int lllllllllllllIlllIIlIlIIlIllIlIl) {
        return (lllllllllllllIlllIIlIlIIlIllIIll & 0xFF) | (lllllllllllllIlllIIlIlIIlIllIlII & 0x7FFF) << 8 | (lllllllllllllIlllIIlIlIIlIllIlIl & 0x7FFF) << 24 | ((lllllllllllllIlllIIlIlIIlIllIlII < 0) ? Integer.MIN_VALUE : 0) | ((lllllllllllllIlllIIlIlIIlIllIlIl < 0) ? 32768 : 0);
    }
    
    public boolean isAssigned() {
        return this.index >= 0;
    }
}
