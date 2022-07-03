package net.minecraft.village;

import net.minecraft.util.*;
import net.minecraft.util.math.*;

public class VillageDoorInfo
{
    private final /* synthetic */ BlockPos insideBlock;
    private /* synthetic */ int lastActivityTimestamp;
    private /* synthetic */ boolean isDetachedFromVillageFlag;
    private final /* synthetic */ BlockPos doorBlockPos;
    private final /* synthetic */ EnumFacing insideDirection;
    private /* synthetic */ int doorOpeningRestrictionCounter;
    
    public VillageDoorInfo(final BlockPos lllllllllllllIlIIIllllIIlIIIIIII, final int lllllllllllllIlIIIllllIIlIIIIlII, final int lllllllllllllIlIIIllllIIIllllllI, final int lllllllllllllIlIIIllllIIIlllllIl) {
        this(lllllllllllllIlIIIllllIIlIIIIIII, getFaceDirection(lllllllllllllIlIIIllllIIlIIIIlII, lllllllllllllIlIIIllllIIIllllllI), lllllllllllllIlIIIllllIIIlllllIl);
    }
    
    public int getDoorOpeningRestrictionCounter() {
        return this.doorOpeningRestrictionCounter;
    }
    
    public void incrementDoorOpeningRestrictionCounter() {
        ++this.doorOpeningRestrictionCounter;
    }
    
    public int getInsidePosY() {
        return this.lastActivityTimestamp;
    }
    
    public boolean isInsideSide(final BlockPos lllllllllllllIlIIIllllIIIlIIllIl) {
        final int lllllllllllllIlIIIllllIIIlIIllII = lllllllllllllIlIIIllllIIIlIIllIl.getX() - this.doorBlockPos.getX();
        final int lllllllllllllIlIIIllllIIIlIIlIll = lllllllllllllIlIIIllllIIIlIIllIl.getZ() - this.doorBlockPos.getY();
        return lllllllllllllIlIIIllllIIIlIIllII * this.insideDirection.getFrontOffsetX() + lllllllllllllIlIIIllllIIIlIIlIll * this.insideDirection.getFrontOffsetZ() >= 0;
    }
    
    public BlockPos getDoorBlockPos() {
        return this.doorBlockPos;
    }
    
    public int getDistanceToDoorBlockSq(final BlockPos lllllllllllllIlIIIllllIIIlIllIIl) {
        return (int)lllllllllllllIlIIIllllIIIlIllIIl.distanceSq(this.getDoorBlockPos());
    }
    
    public int getDistanceSquared(final int lllllllllllllIlIIIllllIIIllIIlIl, final int lllllllllllllIlIIIllllIIIllIIIII, final int lllllllllllllIlIIIllllIIIlIlllll) {
        return (int)this.doorBlockPos.distanceSq(lllllllllllllIlIIIllllIIIllIIlIl, lllllllllllllIlIIIllllIIIllIIIII, lllllllllllllIlIIIllllIIIlIlllll);
    }
    
    public void setLastActivityTimestamp(final int lllllllllllllIlIIIllllIIIIlIlIll) {
        this.lastActivityTimestamp = lllllllllllllIlIIIllllIIIIlIlIll;
    }
    
    public void setIsDetachedFromVillageFlag(final boolean lllllllllllllIlIIIllllIIIIlIIIII) {
        this.isDetachedFromVillageFlag = lllllllllllllIlIIIllllIIIIlIIIII;
    }
    
    public VillageDoorInfo(final BlockPos lllllllllllllIlIIIllllIIIllIllIl, final EnumFacing lllllllllllllIlIIIllllIIIllIllII, final int lllllllllllllIlIIIllllIIIllIlIll) {
        this.doorBlockPos = lllllllllllllIlIIIllllIIIllIllIl;
        this.insideDirection = lllllllllllllIlIIIllllIIIllIllII;
        this.insideBlock = lllllllllllllIlIIIllllIIIllIllIl.offset(lllllllllllllIlIIIllllIIIllIllII, 2);
        this.lastActivityTimestamp = lllllllllllllIlIIIllllIIIllIlIll;
    }
    
    private static EnumFacing getFaceDirection(final int lllllllllllllIlIIIllllIIIllllIII, final int lllllllllllllIlIIIllllIIIllllIIl) {
        if (lllllllllllllIlIIIllllIIIllllIII < 0) {
            return EnumFacing.WEST;
        }
        if (lllllllllllllIlIIIllllIIIllllIII > 0) {
            return EnumFacing.EAST;
        }
        return (lllllllllllllIlIIIllllIIIllllIIl < 0) ? EnumFacing.NORTH : EnumFacing.SOUTH;
    }
    
    public int getInsideOffsetX() {
        return this.insideDirection.getFrontOffsetX() * 2;
    }
    
    public int getDistanceToInsideBlockSq(final BlockPos lllllllllllllIlIIIllllIIIlIlIlIl) {
        return (int)this.insideBlock.distanceSq(lllllllllllllIlIIIllllIIIlIlIlIl);
    }
    
    public EnumFacing getInsideDirection() {
        return this.insideDirection;
    }
    
    public int getInsideOffsetZ() {
        return this.insideDirection.getFrontOffsetZ() * 2;
    }
    
    public void resetDoorOpeningRestrictionCounter() {
        this.doorOpeningRestrictionCounter = 0;
    }
    
    public boolean getIsDetachedFromVillageFlag() {
        return this.isDetachedFromVillageFlag;
    }
    
    public BlockPos getInsideBlockPos() {
        return this.insideBlock;
    }
}
