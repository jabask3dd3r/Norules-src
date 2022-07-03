package net.minecraft.pathfinding;

import javax.annotation.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;
import net.minecraft.init.*;
import net.minecraft.block.state.*;
import net.minecraft.block.*;

public abstract class PathNavigate
{
    protected /* synthetic */ double speed;
    private /* synthetic */ int ticksAtLastPos;
    private /* synthetic */ long lastTimeUpdated;
    @Nullable
    protected /* synthetic */ Path currentPath;
    private /* synthetic */ double timeoutLimit;
    protected /* synthetic */ float maxDistanceToWaypoint;
    private /* synthetic */ BlockPos targetPos;
    protected /* synthetic */ EntityLiving theEntity;
    protected /* synthetic */ World worldObj;
    private /* synthetic */ Vec3d timeoutCachedNode;
    protected /* synthetic */ boolean tryUpdatePath;
    private /* synthetic */ long timeoutTimer;
    private /* synthetic */ long lastTimeoutCheck;
    private /* synthetic */ Vec3d lastPosCheck;
    private final /* synthetic */ PathFinder pathFinder;
    protected /* synthetic */ int totalTicks;
    private final /* synthetic */ IAttributeInstance pathSearchRange;
    protected /* synthetic */ NodeProcessor nodeProcessor;
    
    public float getPathSearchRange() {
        return (float)this.pathSearchRange.getAttributeValue();
    }
    
    public NodeProcessor getNodeProcessor() {
        return this.nodeProcessor;
    }
    
    @Nullable
    public Path getPathToPos(final BlockPos lllllllllllllIIIIlIIllIlIIlIIllI) {
        if (!this.canNavigate()) {
            return null;
        }
        if (this.currentPath != null && !this.currentPath.isFinished() && lllllllllllllIIIIlIIllIlIIlIIllI.equals(this.targetPos)) {
            return this.currentPath;
        }
        this.targetPos = lllllllllllllIIIIlIIllIlIIlIIllI;
        final float lllllllllllllIIIIlIIllIlIIlIllII = this.getPathSearchRange();
        this.worldObj.theProfiler.startSection("pathfind");
        final BlockPos lllllllllllllIIIIlIIllIlIIlIlIll = new BlockPos(this.theEntity);
        final int lllllllllllllIIIIlIIllIlIIlIlIlI = (int)(lllllllllllllIIIIlIIllIlIIlIllII + 8.0f);
        final ChunkCache lllllllllllllIIIIlIIllIlIIlIlIIl = new ChunkCache(this.worldObj, lllllllllllllIIIIlIIllIlIIlIlIll.add(-lllllllllllllIIIIlIIllIlIIlIlIlI, -lllllllllllllIIIIlIIllIlIIlIlIlI, -lllllllllllllIIIIlIIllIlIIlIlIlI), lllllllllllllIIIIlIIllIlIIlIlIll.add(lllllllllllllIIIIlIIllIlIIlIlIlI, lllllllllllllIIIIlIIllIlIIlIlIlI, lllllllllllllIIIIlIIllIlIIlIlIlI), 0);
        final Path lllllllllllllIIIIlIIllIlIIlIlIII = this.pathFinder.findPath(lllllllllllllIIIIlIIllIlIIlIlIIl, this.theEntity, this.targetPos, lllllllllllllIIIIlIIllIlIIlIllII);
        this.worldObj.theProfiler.endSection();
        return lllllllllllllIIIIlIIllIlIIlIlIII;
    }
    
    protected void pathFollow() {
        final Vec3d lllllllllllllIIIIlIIllIIllIIIllI = this.getEntityPosition();
        int lllllllllllllIIIIlIIllIIllIIIlIl = this.currentPath.getCurrentPathLength();
        for (int lllllllllllllIIIIlIIllIIllIIIlII = this.currentPath.getCurrentPathIndex(); lllllllllllllIIIIlIIllIIllIIIlII < this.currentPath.getCurrentPathLength(); ++lllllllllllllIIIIlIIllIIllIIIlII) {
            if (this.currentPath.getPathPointFromIndex(lllllllllllllIIIIlIIllIIllIIIlII).yCoord != Math.floor(lllllllllllllIIIIlIIllIIllIIIllI.yCoord)) {
                lllllllllllllIIIIlIIllIIllIIIlIl = lllllllllllllIIIIlIIllIIllIIIlII;
                break;
            }
        }
        this.maxDistanceToWaypoint = ((this.theEntity.width > 0.75f) ? (this.theEntity.width / 2.0f) : (0.75f - this.theEntity.width / 2.0f));
        final Vec3d lllllllllllllIIIIlIIllIIllIIIIll = this.currentPath.getCurrentPos();
        if (MathHelper.abs((float)(this.theEntity.posX - (lllllllllllllIIIIlIIllIIllIIIIll.xCoord + 0.5))) < this.maxDistanceToWaypoint && MathHelper.abs((float)(this.theEntity.posZ - (lllllllllllllIIIIlIIllIIllIIIIll.zCoord + 0.5))) < this.maxDistanceToWaypoint && Math.abs(this.theEntity.posY - lllllllllllllIIIIlIIllIIllIIIIll.yCoord) < 1.0) {
            this.currentPath.setCurrentPathIndex(this.currentPath.getCurrentPathIndex() + 1);
        }
        final int lllllllllllllIIIIlIIllIIllIIIIlI = MathHelper.ceil(this.theEntity.width);
        final int lllllllllllllIIIIlIIllIIllIIIIIl = MathHelper.ceil(this.theEntity.height);
        final int lllllllllllllIIIIlIIllIIllIIIIII = lllllllllllllIIIIlIIllIIllIIIIlI;
        for (int lllllllllllllIIIIlIIllIIlIllllll = lllllllllllllIIIIlIIllIIllIIIlIl - 1; lllllllllllllIIIIlIIllIIlIllllll >= this.currentPath.getCurrentPathIndex(); --lllllllllllllIIIIlIIllIIlIllllll) {
            if (this.isDirectPathBetweenPoints(lllllllllllllIIIIlIIllIIllIIIllI, this.currentPath.getVectorFromIndex(this.theEntity, lllllllllllllIIIIlIIllIIlIllllll), lllllllllllllIIIIlIIllIIllIIIIlI, lllllllllllllIIIIlIIllIIllIIIIIl, lllllllllllllIIIIlIIllIIllIIIIII)) {
                this.currentPath.setCurrentPathIndex(lllllllllllllIIIIlIIllIIlIllllll);
                break;
            }
        }
        this.checkForStuck(lllllllllllllIIIIlIIllIIllIIIllI);
    }
    
    public void clearPathEntity() {
        this.currentPath = null;
    }
    
    public boolean tryMoveToXYZ(final double lllllllllllllIIIIlIIllIlIIIIIIlI, final double lllllllllllllIIIIlIIllIIllllllII, final double lllllllllllllIIIIlIIllIIlllllIll, final double lllllllllllllIIIIlIIllIIlllllIlI) {
        return this.setPath(this.getPathToXYZ(lllllllllllllIIIIlIIllIlIIIIIIlI, lllllllllllllIIIIlIIllIIllllllII, lllllllllllllIIIIlIIllIIlllllIll), lllllllllllllIIIIlIIllIIlllllIlI);
    }
    
    protected boolean isInLiquid() {
        return this.theEntity.isInWater() || this.theEntity.isInLava();
    }
    
    public boolean setPath(@Nullable final Path lllllllllllllIIIIlIIllIIlllIIlII, final double lllllllllllllIIIIlIIllIIlllIIlll) {
        if (lllllllllllllIIIIlIIllIIlllIIlII == null) {
            this.currentPath = null;
            return false;
        }
        if (!lllllllllllllIIIIlIIllIIlllIIlII.isSamePath(this.currentPath)) {
            this.currentPath = lllllllllllllIIIIlIIllIIlllIIlII;
        }
        this.removeSunnyPath();
        if (this.currentPath.getCurrentPathLength() <= 0) {
            return false;
        }
        this.speed = lllllllllllllIIIIlIIllIIlllIIlll;
        final Vec3d lllllllllllllIIIIlIIllIIlllIIllI = this.getEntityPosition();
        this.ticksAtLastPos = this.totalTicks;
        this.lastPosCheck = lllllllllllllIIIIlIIllIIlllIIllI;
        return true;
    }
    
    public void setSpeed(final double lllllllllllllIIIIlIIllIlIlIIlIll) {
        this.speed = lllllllllllllIIIIlIIllIlIlIIlIll;
    }
    
    public PathNavigate(final EntityLiving lllllllllllllIIIIlIIllIlIlIlIlIl, final World lllllllllllllIIIIlIIllIlIlIlIIIl) {
        this.lastPosCheck = Vec3d.ZERO;
        this.timeoutCachedNode = Vec3d.ZERO;
        this.maxDistanceToWaypoint = 0.5f;
        this.theEntity = lllllllllllllIIIIlIIllIlIlIlIlIl;
        this.worldObj = lllllllllllllIIIIlIIllIlIlIlIIIl;
        this.pathSearchRange = lllllllllllllIIIIlIIllIlIlIlIlIl.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE);
        this.pathFinder = this.getPathFinder();
    }
    
    public void onUpdateNavigation() {
        ++this.totalTicks;
        if (this.tryUpdatePath) {
            this.updatePath();
        }
        if (!this.noPath()) {
            if (this.canNavigate()) {
                this.pathFollow();
            }
            else if (this.currentPath != null && this.currentPath.getCurrentPathIndex() < this.currentPath.getCurrentPathLength()) {
                final Vec3d lllllllllllllIIIIlIIllIIllIllIIl = this.getEntityPosition();
                final Vec3d lllllllllllllIIIIlIIllIIllIllIII = this.currentPath.getVectorFromIndex(this.theEntity, this.currentPath.getCurrentPathIndex());
                if (lllllllllllllIIIIlIIllIIllIllIIl.yCoord > lllllllllllllIIIIlIIllIIllIllIII.yCoord && !this.theEntity.onGround && MathHelper.floor(lllllllllllllIIIIlIIllIIllIllIIl.xCoord) == MathHelper.floor(lllllllllllllIIIIlIIllIIllIllIII.xCoord) && MathHelper.floor(lllllllllllllIIIIlIIllIIllIllIIl.zCoord) == MathHelper.floor(lllllllllllllIIIIlIIllIIllIllIII.zCoord)) {
                    this.currentPath.setCurrentPathIndex(this.currentPath.getCurrentPathIndex() + 1);
                }
            }
            this.func_192876_m();
            if (!this.noPath()) {
                Vec3d lllllllllllllIIIIlIIllIIllIlIlll = this.currentPath.getPosition(this.theEntity);
                final BlockPos lllllllllllllIIIIlIIllIIllIlIllI = new BlockPos(lllllllllllllIIIIlIIllIIllIlIlll).down();
                final AxisAlignedBB lllllllllllllIIIIlIIllIIllIlIlIl = this.worldObj.getBlockState(lllllllllllllIIIIlIIllIIllIlIllI).getBoundingBox(this.worldObj, lllllllllllllIIIIlIIllIIllIlIllI);
                lllllllllllllIIIIlIIllIIllIlIlll = lllllllllllllIIIIlIIllIIllIlIlll.subtract(0.0, 1.0 - lllllllllllllIIIIlIIllIIllIlIlIl.maxY, 0.0);
                this.theEntity.getMoveHelper().setMoveTo(lllllllllllllIIIIlIIllIIllIlIlll.xCoord, lllllllllllllIIIIlIIllIIllIlIlll.yCoord, lllllllllllllIIIIlIIllIIllIlIlll.zCoord, this.speed);
            }
        }
    }
    
    @Nullable
    public Path getPathToEntityLiving(final Entity lllllllllllllIIIIlIIllIlIIIlIlll) {
        if (!this.canNavigate()) {
            return null;
        }
        final BlockPos lllllllllllllIIIIlIIllIlIIIlIllI = new BlockPos(lllllllllllllIIIIlIIllIlIIIlIlll);
        if (this.currentPath != null && !this.currentPath.isFinished() && lllllllllllllIIIIlIIllIlIIIlIllI.equals(this.targetPos)) {
            return this.currentPath;
        }
        this.targetPos = lllllllllllllIIIIlIIllIlIIIlIllI;
        final float lllllllllllllIIIIlIIllIlIIIlIlIl = this.getPathSearchRange();
        this.worldObj.theProfiler.startSection("pathfind");
        final BlockPos lllllllllllllIIIIlIIllIlIIIlIlII = new BlockPos(this.theEntity).up();
        final int lllllllllllllIIIIlIIllIlIIIlIIll = (int)(lllllllllllllIIIIlIIllIlIIIlIlIl + 16.0f);
        final ChunkCache lllllllllllllIIIIlIIllIlIIIlIIlI = new ChunkCache(this.worldObj, lllllllllllllIIIIlIIllIlIIIlIlII.add(-lllllllllllllIIIIlIIllIlIIIlIIll, -lllllllllllllIIIIlIIllIlIIIlIIll, -lllllllllllllIIIIlIIllIlIIIlIIll), lllllllllllllIIIIlIIllIlIIIlIlII.add(lllllllllllllIIIIlIIllIlIIIlIIll, lllllllllllllIIIIlIIllIlIIIlIIll, lllllllllllllIIIIlIIllIlIIIlIIll), 0);
        final Path lllllllllllllIIIIlIIllIlIIIlIIIl = this.pathFinder.findPath(lllllllllllllIIIIlIIllIlIIIlIIlI, this.theEntity, lllllllllllllIIIIlIIllIlIIIlIlll, lllllllllllllIIIIlIIllIlIIIlIlIl);
        this.worldObj.theProfiler.endSection();
        return lllllllllllllIIIIlIIllIlIIIlIIIl;
    }
    
    public boolean noPath() {
        return this.currentPath == null || this.currentPath.isFinished();
    }
    
    public boolean canUpdatePathOnTimeout() {
        return this.tryUpdatePath;
    }
    
    public void updatePath() {
        if (this.worldObj.getTotalWorldTime() - this.lastTimeUpdated > 20L) {
            if (this.targetPos != null) {
                this.currentPath = null;
                this.currentPath = this.getPathToPos(this.targetPos);
                this.lastTimeUpdated = this.worldObj.getTotalWorldTime();
                this.tryUpdatePath = false;
            }
        }
        else {
            this.tryUpdatePath = true;
        }
    }
    
    protected abstract boolean isDirectPathBetweenPoints(final Vec3d p0, final Vec3d p1, final int p2, final int p3, final int p4);
    
    protected void removeSunnyPath() {
        if (this.currentPath != null) {
            for (int lllllllllllllIIIIlIIllIIlIIllIlI = 0; lllllllllllllIIIIlIIllIIlIIllIlI < this.currentPath.getCurrentPathLength(); ++lllllllllllllIIIIlIIllIIlIIllIlI) {
                final PathPoint lllllllllllllIIIIlIIllIIlIIllIIl = this.currentPath.getPathPointFromIndex(lllllllllllllIIIIlIIllIIlIIllIlI);
                final PathPoint lllllllllllllIIIIlIIllIIlIIllIII = (lllllllllllllIIIIlIIllIIlIIllIlI + 1 < this.currentPath.getCurrentPathLength()) ? this.currentPath.getPathPointFromIndex(lllllllllllllIIIIlIIllIIlIIllIlI + 1) : null;
                final IBlockState lllllllllllllIIIIlIIllIIlIIlIlll = this.worldObj.getBlockState(new BlockPos(lllllllllllllIIIIlIIllIIlIIllIIl.xCoord, lllllllllllllIIIIlIIllIIlIIllIIl.yCoord, lllllllllllllIIIIlIIllIIlIIllIIl.zCoord));
                final Block lllllllllllllIIIIlIIllIIlIIlIllI = lllllllllllllIIIIlIIllIIlIIlIlll.getBlock();
                if (lllllllllllllIIIIlIIllIIlIIlIllI == Blocks.CAULDRON) {
                    this.currentPath.setPoint(lllllllllllllIIIIlIIllIIlIIllIlI, lllllllllllllIIIIlIIllIIlIIllIIl.cloneMove(lllllllllllllIIIIlIIllIIlIIllIIl.xCoord, lllllllllllllIIIIlIIllIIlIIllIIl.yCoord + 1, lllllllllllllIIIIlIIllIIlIIllIIl.zCoord));
                    if (lllllllllllllIIIIlIIllIIlIIllIII != null && lllllllllllllIIIIlIIllIIlIIllIIl.yCoord >= lllllllllllllIIIIlIIllIIlIIllIII.yCoord) {
                        this.currentPath.setPoint(lllllllllllllIIIIlIIllIIlIIllIlI + 1, lllllllllllllIIIIlIIllIIlIIllIII.cloneMove(lllllllllllllIIIIlIIllIIlIIllIII.xCoord, lllllllllllllIIIIlIIllIIlIIllIIl.yCoord + 1, lllllllllllllIIIIlIIllIIlIIllIII.zCoord));
                    }
                }
            }
        }
    }
    
    protected void func_192876_m() {
    }
    
    protected abstract Vec3d getEntityPosition();
    
    public boolean canEntityStandOnPos(final BlockPos lllllllllllllIIIIlIIllIIlIIIlIlI) {
        return this.worldObj.getBlockState(lllllllllllllIIIIlIIllIIlIIIlIlI.down()).isFullBlock();
    }
    
    protected abstract boolean canNavigate();
    
    @Nullable
    public final Path getPathToXYZ(final double lllllllllllllIIIIlIIllIlIIlllIII, final double lllllllllllllIIIIlIIllIlIIllIlll, final double lllllllllllllIIIIlIIllIlIIlllIlI) {
        return this.getPathToPos(new BlockPos(lllllllllllllIIIIlIIllIlIIlllIII, lllllllllllllIIIIlIIllIlIIllIlll, lllllllllllllIIIIlIIllIlIIlllIlI));
    }
    
    public boolean tryMoveToEntityLiving(final Entity lllllllllllllIIIIlIIllIIllllIlII, final double lllllllllllllIIIIlIIllIIllllIIll) {
        final Path lllllllllllllIIIIlIIllIIllllIIlI = this.getPathToEntityLiving(lllllllllllllIIIIlIIllIIllllIlII);
        return lllllllllllllIIIIlIIllIIllllIIlI != null && this.setPath(lllllllllllllIIIIlIIllIIllllIIlI, lllllllllllllIIIIlIIllIIllllIIll);
    }
    
    protected void checkForStuck(final Vec3d lllllllllllllIIIIlIIllIIlIllIIIl) {
        if (this.totalTicks - this.ticksAtLastPos > 100) {
            if (lllllllllllllIIIIlIIllIIlIllIIIl.squareDistanceTo(this.lastPosCheck) < 2.25) {
                this.clearPathEntity();
            }
            this.ticksAtLastPos = this.totalTicks;
            this.lastPosCheck = lllllllllllllIIIIlIIllIIlIllIIIl;
        }
        if (this.currentPath != null && !this.currentPath.isFinished()) {
            final Vec3d lllllllllllllIIIIlIIllIIlIllIIII = this.currentPath.getCurrentPos();
            if (lllllllllllllIIIIlIIllIIlIllIIII.equals(this.timeoutCachedNode)) {
                this.timeoutTimer += System.currentTimeMillis() - this.lastTimeoutCheck;
            }
            else {
                this.timeoutCachedNode = lllllllllllllIIIIlIIllIIlIllIIII;
                final double lllllllllllllIIIIlIIllIIlIlIllll = lllllllllllllIIIIlIIllIIlIllIIIl.distanceTo(this.timeoutCachedNode);
                this.timeoutLimit = ((this.theEntity.getAIMoveSpeed() > 0.0f) ? (lllllllllllllIIIIlIIllIIlIlIllll / this.theEntity.getAIMoveSpeed() * 1000.0) : 0.0);
            }
            if (this.timeoutLimit > 0.0 && this.timeoutTimer > this.timeoutLimit * 3.0) {
                this.timeoutCachedNode = Vec3d.ZERO;
                this.timeoutTimer = 0L;
                this.timeoutLimit = 0.0;
                this.clearPathEntity();
            }
            this.lastTimeoutCheck = System.currentTimeMillis();
        }
    }
    
    protected abstract PathFinder getPathFinder();
    
    @Nullable
    public Path getPath() {
        return this.currentPath;
    }
}
