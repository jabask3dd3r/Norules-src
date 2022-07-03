package net.minecraft.pathfinding;

import net.minecraft.util.math.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;

public class PathNavigateGround extends PathNavigate
{
    private /* synthetic */ boolean shouldAvoidSun;
    
    @Override
    protected Vec3d getEntityPosition() {
        return new Vec3d(this.theEntity.posX, this.getPathablePosY(), this.theEntity.posZ);
    }
    
    @Override
    public Path getPathToEntityLiving(final Entity lllllllllllllIlIlIlIlIlIlIlIllll) {
        return this.getPathToPos(new BlockPos(lllllllllllllIlIlIlIlIlIlIlIllll));
    }
    
    private boolean isSafeToStandAt(final int lllllllllllllIlIlIlIlIlIIIllIIlI, final int lllllllllllllIlIlIlIlIlIIIllIIIl, final int lllllllllllllIlIlIlIlIlIIlIIIIlI, final int lllllllllllllIlIlIlIlIlIIlIIIIIl, final int lllllllllllllIlIlIlIlIlIIlIIIIII, final int lllllllllllllIlIlIlIlIlIIIlIllIl, final Vec3d lllllllllllllIlIlIlIlIlIIIlllllI, final double lllllllllllllIlIlIlIlIlIIIlIlIll, final double lllllllllllllIlIlIlIlIlIIIllllII) {
        final int lllllllllllllIlIlIlIlIlIIIlllIll = lllllllllllllIlIlIlIlIlIIIllIIlI - lllllllllllllIlIlIlIlIlIIlIIIIIl / 2;
        final int lllllllllllllIlIlIlIlIlIIIlllIlI = lllllllllllllIlIlIlIlIlIIlIIIIlI - lllllllllllllIlIlIlIlIlIIIlIllIl / 2;
        if (!this.isPositionClear(lllllllllllllIlIlIlIlIlIIIlllIll, lllllllllllllIlIlIlIlIlIIIllIIIl, lllllllllllllIlIlIlIlIlIIIlllIlI, lllllllllllllIlIlIlIlIlIIlIIIIIl, lllllllllllllIlIlIlIlIlIIlIIIIII, lllllllllllllIlIlIlIlIlIIIlIllIl, lllllllllllllIlIlIlIlIlIIIlllllI, lllllllllllllIlIlIlIlIlIIIlIlIll, lllllllllllllIlIlIlIlIlIIIllllII)) {
            return false;
        }
        for (int lllllllllllllIlIlIlIlIlIIIlllIIl = lllllllllllllIlIlIlIlIlIIIlllIll; lllllllllllllIlIlIlIlIlIIIlllIIl < lllllllllllllIlIlIlIlIlIIIlllIll + lllllllllllllIlIlIlIlIlIIlIIIIIl; ++lllllllllllllIlIlIlIlIlIIIlllIIl) {
            for (int lllllllllllllIlIlIlIlIlIIIlllIII = lllllllllllllIlIlIlIlIlIIIlllIlI; lllllllllllllIlIlIlIlIlIIIlllIII < lllllllllllllIlIlIlIlIlIIIlllIlI + lllllllllllllIlIlIlIlIlIIIlIllIl; ++lllllllllllllIlIlIlIlIlIIIlllIII) {
                final double lllllllllllllIlIlIlIlIlIIIllIlll = lllllllllllllIlIlIlIlIlIIIlllIIl + 0.5 - lllllllllllllIlIlIlIlIlIIIlllllI.xCoord;
                final double lllllllllllllIlIlIlIlIlIIIllIllI = lllllllllllllIlIlIlIlIlIIIlllIII + 0.5 - lllllllllllllIlIlIlIlIlIIIlllllI.zCoord;
                if (lllllllllllllIlIlIlIlIlIIIllIlll * lllllllllllllIlIlIlIlIlIIIlIlIll + lllllllllllllIlIlIlIlIlIIIllIllI * lllllllllllllIlIlIlIlIlIIIllllII >= 0.0) {
                    PathNodeType lllllllllllllIlIlIlIlIlIIIllIlIl = this.nodeProcessor.getPathNodeType(this.worldObj, lllllllllllllIlIlIlIlIlIIIlllIIl, lllllllllllllIlIlIlIlIlIIIllIIIl - 1, lllllllllllllIlIlIlIlIlIIIlllIII, this.theEntity, lllllllllllllIlIlIlIlIlIIlIIIIIl, lllllllllllllIlIlIlIlIlIIlIIIIII, lllllllllllllIlIlIlIlIlIIIlIllIl, true, true);
                    if (lllllllllllllIlIlIlIlIlIIIllIlIl == PathNodeType.WATER) {
                        return false;
                    }
                    if (lllllllllllllIlIlIlIlIlIIIllIlIl == PathNodeType.LAVA) {
                        return false;
                    }
                    if (lllllllllllllIlIlIlIlIlIIIllIlIl == PathNodeType.OPEN) {
                        return false;
                    }
                    lllllllllllllIlIlIlIlIlIIIllIlIl = this.nodeProcessor.getPathNodeType(this.worldObj, lllllllllllllIlIlIlIlIlIIIlllIIl, lllllllllllllIlIlIlIlIlIIIllIIIl, lllllllllllllIlIlIlIlIlIIIlllIII, this.theEntity, lllllllllllllIlIlIlIlIlIIlIIIIIl, lllllllllllllIlIlIlIlIlIIlIIIIII, lllllllllllllIlIlIlIlIlIIIlIllIl, true, true);
                    final float lllllllllllllIlIlIlIlIlIIIllIlII = this.theEntity.getPathPriority(lllllllllllllIlIlIlIlIlIIIllIlIl);
                    if (lllllllllllllIlIlIlIlIlIIIllIlII < 0.0f || lllllllllllllIlIlIlIlIlIIIllIlII >= 8.0f) {
                        return false;
                    }
                    if (lllllllllllllIlIlIlIlIlIIIllIlIl == PathNodeType.DAMAGE_FIRE || lllllllllllllIlIlIlIlIlIIIllIlIl == PathNodeType.DANGER_FIRE || lllllllllllllIlIlIlIlIlIIIllIlIl == PathNodeType.DAMAGE_OTHER) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    @Override
    protected boolean isDirectPathBetweenPoints(final Vec3d lllllllllllllIlIlIlIlIlIlIIIIIlI, final Vec3d lllllllllllllIlIlIlIlIlIIllIlIll, int lllllllllllllIlIlIlIlIlIlIIIIIII, final int lllllllllllllIlIlIlIlIlIIllIlIIl, int lllllllllllllIlIlIlIlIlIIllllllI) {
        int lllllllllllllIlIlIlIlIlIIlllllIl = MathHelper.floor(lllllllllllllIlIlIlIlIlIlIIIIIlI.xCoord);
        int lllllllllllllIlIlIlIlIlIIlllllII = MathHelper.floor(lllllllllllllIlIlIlIlIlIlIIIIIlI.zCoord);
        double lllllllllllllIlIlIlIlIlIIllllIll = lllllllllllllIlIlIlIlIlIIllIlIll.xCoord - lllllllllllllIlIlIlIlIlIlIIIIIlI.xCoord;
        double lllllllllllllIlIlIlIlIlIIllllIlI = lllllllllllllIlIlIlIlIlIIllIlIll.zCoord - lllllllllllllIlIlIlIlIlIlIIIIIlI.zCoord;
        final double lllllllllllllIlIlIlIlIlIIllllIIl = lllllllllllllIlIlIlIlIlIIllllIll * lllllllllllllIlIlIlIlIlIIllllIll + lllllllllllllIlIlIlIlIlIIllllIlI * lllllllllllllIlIlIlIlIlIIllllIlI;
        if (lllllllllllllIlIlIlIlIlIIllllIIl < 1.0E-8) {
            return false;
        }
        final double lllllllllllllIlIlIlIlIlIIllllIII = 1.0 / Math.sqrt(lllllllllllllIlIlIlIlIlIIllllIIl);
        lllllllllllllIlIlIlIlIlIIllllIll *= lllllllllllllIlIlIlIlIlIIllllIII;
        lllllllllllllIlIlIlIlIlIIllllIlI *= lllllllllllllIlIlIlIlIlIIllllIII;
        lllllllllllllIlIlIlIlIlIlIIIIIII += 2;
        lllllllllllllIlIlIlIlIlIIllllllI += 2;
        if (!this.isSafeToStandAt(lllllllllllllIlIlIlIlIlIIlllllIl, (int)lllllllllllllIlIlIlIlIlIlIIIIIlI.yCoord, lllllllllllllIlIlIlIlIlIIlllllII, lllllllllllllIlIlIlIlIlIlIIIIIII, lllllllllllllIlIlIlIlIlIIllIlIIl, lllllllllllllIlIlIlIlIlIIllllllI, lllllllllllllIlIlIlIlIlIlIIIIIlI, lllllllllllllIlIlIlIlIlIIllllIll, lllllllllllllIlIlIlIlIlIIllllIlI)) {
            return false;
        }
        lllllllllllllIlIlIlIlIlIlIIIIIII -= 2;
        lllllllllllllIlIlIlIlIlIIllllllI -= 2;
        final double lllllllllllllIlIlIlIlIlIIlllIlll = 1.0 / Math.abs(lllllllllllllIlIlIlIlIlIIllllIll);
        final double lllllllllllllIlIlIlIlIlIIlllIllI = 1.0 / Math.abs(lllllllllllllIlIlIlIlIlIIllllIlI);
        double lllllllllllllIlIlIlIlIlIIlllIlIl = lllllllllllllIlIlIlIlIlIIlllllIl - lllllllllllllIlIlIlIlIlIlIIIIIlI.xCoord;
        double lllllllllllllIlIlIlIlIlIIlllIlII = lllllllllllllIlIlIlIlIlIIlllllII - lllllllllllllIlIlIlIlIlIlIIIIIlI.zCoord;
        if (lllllllllllllIlIlIlIlIlIIllllIll >= 0.0) {
            ++lllllllllllllIlIlIlIlIlIIlllIlIl;
        }
        if (lllllllllllllIlIlIlIlIlIIllllIlI >= 0.0) {
            ++lllllllllllllIlIlIlIlIlIIlllIlII;
        }
        lllllllllllllIlIlIlIlIlIIlllIlIl /= lllllllllllllIlIlIlIlIlIIllllIll;
        lllllllllllllIlIlIlIlIlIIlllIlII /= lllllllllllllIlIlIlIlIlIIllllIlI;
        final int lllllllllllllIlIlIlIlIlIIlllIIll = (lllllllllllllIlIlIlIlIlIIllllIll < 0.0) ? -1 : 1;
        final int lllllllllllllIlIlIlIlIlIIlllIIlI = (lllllllllllllIlIlIlIlIlIIllllIlI < 0.0) ? -1 : 1;
        final int lllllllllllllIlIlIlIlIlIIlllIIIl = MathHelper.floor(lllllllllllllIlIlIlIlIlIIllIlIll.xCoord);
        final int lllllllllllllIlIlIlIlIlIIlllIIII = MathHelper.floor(lllllllllllllIlIlIlIlIlIIllIlIll.zCoord);
        int lllllllllllllIlIlIlIlIlIIllIllll = lllllllllllllIlIlIlIlIlIIlllIIIl - lllllllllllllIlIlIlIlIlIIlllllIl;
        int lllllllllllllIlIlIlIlIlIIllIlllI = lllllllllllllIlIlIlIlIlIIlllIIII - lllllllllllllIlIlIlIlIlIIlllllII;
        while (lllllllllllllIlIlIlIlIlIIllIllll * lllllllllllllIlIlIlIlIlIIlllIIll > 0 || lllllllllllllIlIlIlIlIlIIllIlllI * lllllllllllllIlIlIlIlIlIIlllIIlI > 0) {
            if (lllllllllllllIlIlIlIlIlIIlllIlIl < lllllllllllllIlIlIlIlIlIIlllIlII) {
                lllllllllllllIlIlIlIlIlIIlllIlIl += lllllllllllllIlIlIlIlIlIIlllIlll;
                lllllllllllllIlIlIlIlIlIIlllllIl += lllllllllllllIlIlIlIlIlIIlllIIll;
                lllllllllllllIlIlIlIlIlIIllIllll = lllllllllllllIlIlIlIlIlIIlllIIIl - lllllllllllllIlIlIlIlIlIIlllllIl;
            }
            else {
                lllllllllllllIlIlIlIlIlIIlllIlII += lllllllllllllIlIlIlIlIlIIlllIllI;
                lllllllllllllIlIlIlIlIlIIlllllII += lllllllllllllIlIlIlIlIlIIlllIIlI;
                lllllllllllllIlIlIlIlIlIIllIlllI = lllllllllllllIlIlIlIlIlIIlllIIII - lllllllllllllIlIlIlIlIlIIlllllII;
            }
            if (!this.isSafeToStandAt(lllllllllllllIlIlIlIlIlIIlllllIl, (int)lllllllllllllIlIlIlIlIlIlIIIIIlI.yCoord, lllllllllllllIlIlIlIlIlIIlllllII, lllllllllllllIlIlIlIlIlIlIIIIIII, lllllllllllllIlIlIlIlIlIIllIlIIl, lllllllllllllIlIlIlIlIlIIllllllI, lllllllllllllIlIlIlIlIlIlIIIIIlI, lllllllllllllIlIlIlIlIlIIllllIll, lllllllllllllIlIlIlIlIlIIllllIlI)) {
                return false;
            }
        }
        return true;
    }
    
    public void setCanSwim(final boolean lllllllllllllIlIlIlIlIIllllIIIIl) {
        this.nodeProcessor.setCanSwim(lllllllllllllIlIlIlIlIIllllIIIIl);
    }
    
    private int getPathablePosY() {
        if (this.theEntity.isInWater() && this.getCanSwim()) {
            int lllllllllllllIlIlIlIlIlIlIlIlIIl = (int)this.theEntity.getEntityBoundingBox().minY;
            Block lllllllllllllIlIlIlIlIlIlIlIlIII = this.worldObj.getBlockState(new BlockPos(MathHelper.floor(this.theEntity.posX), lllllllllllllIlIlIlIlIlIlIlIlIIl, MathHelper.floor(this.theEntity.posZ))).getBlock();
            int lllllllllllllIlIlIlIlIlIlIlIIlll = 0;
            while (lllllllllllllIlIlIlIlIlIlIlIlIII == Blocks.FLOWING_WATER || lllllllllllllIlIlIlIlIlIlIlIlIII == Blocks.WATER) {
                ++lllllllllllllIlIlIlIlIlIlIlIlIIl;
                lllllllllllllIlIlIlIlIlIlIlIlIII = this.worldObj.getBlockState(new BlockPos(MathHelper.floor(this.theEntity.posX), lllllllllllllIlIlIlIlIlIlIlIlIIl, MathHelper.floor(this.theEntity.posZ))).getBlock();
                if (++lllllllllllllIlIlIlIlIlIlIlIIlll > 16) {
                    return (int)this.theEntity.getEntityBoundingBox().minY;
                }
            }
            return lllllllllllllIlIlIlIlIlIlIlIlIIl;
        }
        return (int)(this.theEntity.getEntityBoundingBox().minY + 0.5);
    }
    
    public void setEnterDoors(final boolean lllllllllllllIlIlIlIlIIllllIllII) {
        this.nodeProcessor.setCanEnterDoors(lllllllllllllIlIlIlIlIIllllIllII);
    }
    
    @Override
    public Path getPathToPos(BlockPos lllllllllllllIlIlIlIlIlIlIllIllI) {
        if (this.worldObj.getBlockState((BlockPos)lllllllllllllIlIlIlIlIlIlIllIllI).getMaterial() == Material.AIR) {
            BlockPos lllllllllllllIlIlIlIlIlIlIlllIIl;
            for (lllllllllllllIlIlIlIlIlIlIlllIIl = ((BlockPos)lllllllllllllIlIlIlIlIlIlIllIllI).down(); lllllllllllllIlIlIlIlIlIlIlllIIl.getY() > 0 && this.worldObj.getBlockState(lllllllllllllIlIlIlIlIlIlIlllIIl).getMaterial() == Material.AIR; lllllllllllllIlIlIlIlIlIlIlllIIl = lllllllllllllIlIlIlIlIlIlIlllIIl.down()) {}
            if (lllllllllllllIlIlIlIlIlIlIlllIIl.getY() > 0) {
                return super.getPathToPos(lllllllllllllIlIlIlIlIlIlIlllIIl.up());
            }
            while (lllllllllllllIlIlIlIlIlIlIlllIIl.getY() < this.worldObj.getHeight() && this.worldObj.getBlockState(lllllllllllllIlIlIlIlIlIlIlllIIl).getMaterial() == Material.AIR) {
                lllllllllllllIlIlIlIlIlIlIlllIIl = lllllllllllllIlIlIlIlIlIlIlllIIl.up();
            }
            lllllllllllllIlIlIlIlIlIlIllIllI = lllllllllllllIlIlIlIlIlIlIlllIIl;
        }
        if (!this.worldObj.getBlockState((BlockPos)lllllllllllllIlIlIlIlIlIlIllIllI).getMaterial().isSolid()) {
            return super.getPathToPos((BlockPos)lllllllllllllIlIlIlIlIlIlIllIllI);
        }
        BlockPos lllllllllllllIlIlIlIlIlIlIlllIII;
        for (lllllllllllllIlIlIlIlIlIlIlllIII = ((BlockPos)lllllllllllllIlIlIlIlIlIlIllIllI).up(); lllllllllllllIlIlIlIlIlIlIlllIII.getY() < this.worldObj.getHeight() && this.worldObj.getBlockState(lllllllllllllIlIlIlIlIlIlIlllIII).getMaterial().isSolid(); lllllllllllllIlIlIlIlIlIlIlllIII = lllllllllllllIlIlIlIlIlIlIlllIII.up()) {}
        return super.getPathToPos(lllllllllllllIlIlIlIlIlIlIlllIII);
    }
    
    public PathNavigateGround(final EntityLiving lllllllllllllIlIlIlIlIlIllIIllII, final World lllllllllllllIlIlIlIlIlIllIIlIll) {
        super(lllllllllllllIlIlIlIlIlIllIIllII, lllllllllllllIlIlIlIlIlIllIIlIll);
    }
    
    public boolean getEnterDoors() {
        return this.nodeProcessor.getCanEnterDoors();
    }
    
    private boolean isPositionClear(final int lllllllllllllIlIlIlIlIlIIIIlIIIl, final int lllllllllllllIlIlIlIlIlIIIIIIIlI, final int lllllllllllllIlIlIlIlIlIIIIIIIIl, final int lllllllllllllIlIlIlIlIlIIIIIlllI, final int lllllllllllllIlIlIlIlIIlllllllll, final int lllllllllllllIlIlIlIlIIllllllllI, final Vec3d lllllllllllllIlIlIlIlIIlllllllIl, final double lllllllllllllIlIlIlIlIIlllllllII, final double lllllllllllllIlIlIlIlIIllllllIll) {
        for (final BlockPos lllllllllllllIlIlIlIlIlIIIIIlIII : BlockPos.getAllInBox(new BlockPos(lllllllllllllIlIlIlIlIlIIIIlIIIl, lllllllllllllIlIlIlIlIlIIIIIIIlI, lllllllllllllIlIlIlIlIlIIIIIIIIl), new BlockPos(lllllllllllllIlIlIlIlIlIIIIlIIIl + lllllllllllllIlIlIlIlIlIIIIIlllI - 1, lllllllllllllIlIlIlIlIlIIIIIIIlI + lllllllllllllIlIlIlIlIIlllllllll - 1, lllllllllllllIlIlIlIlIlIIIIIIIIl + lllllllllllllIlIlIlIlIIllllllllI - 1))) {
            final double lllllllllllllIlIlIlIlIlIIIIIIlll = lllllllllllllIlIlIlIlIlIIIIIlIII.getX() + 0.5 - lllllllllllllIlIlIlIlIIlllllllIl.xCoord;
            final double lllllllllllllIlIlIlIlIlIIIIIIllI = lllllllllllllIlIlIlIlIlIIIIIlIII.getZ() + 0.5 - lllllllllllllIlIlIlIlIIlllllllIl.zCoord;
            if (lllllllllllllIlIlIlIlIlIIIIIIlll * lllllllllllllIlIlIlIlIIlllllllII + lllllllllllllIlIlIlIlIlIIIIIIllI * lllllllllllllIlIlIlIlIIllllllIll >= 0.0) {
                final Block lllllllllllllIlIlIlIlIlIIIIIIlIl = this.worldObj.getBlockState(lllllllllllllIlIlIlIlIlIIIIIlIII).getBlock();
                if (!lllllllllllllIlIlIlIlIlIIIIIIlIl.isPassable(this.worldObj, lllllllllllllIlIlIlIlIlIIIIIlIII)) {
                    return false;
                }
                continue;
            }
        }
        return true;
    }
    
    @Override
    protected void removeSunnyPath() {
        super.removeSunnyPath();
        if (this.shouldAvoidSun) {
            if (this.worldObj.canSeeSky(new BlockPos(MathHelper.floor(this.theEntity.posX), (int)(this.theEntity.getEntityBoundingBox().minY + 0.5), MathHelper.floor(this.theEntity.posZ)))) {
                return;
            }
            for (int lllllllllllllIlIlIlIlIlIlIIllllI = 0; lllllllllllllIlIlIlIlIlIlIIllllI < this.currentPath.getCurrentPathLength(); ++lllllllllllllIlIlIlIlIlIlIIllllI) {
                final PathPoint lllllllllllllIlIlIlIlIlIlIIlllIl = this.currentPath.getPathPointFromIndex(lllllllllllllIlIlIlIlIlIlIIllllI);
                if (this.worldObj.canSeeSky(new BlockPos(lllllllllllllIlIlIlIlIlIlIIlllIl.xCoord, lllllllllllllIlIlIlIlIlIlIIlllIl.yCoord, lllllllllllllIlIlIlIlIlIlIIlllIl.zCoord))) {
                    this.currentPath.setCurrentPathLength(lllllllllllllIlIlIlIlIlIlIIllllI - 1);
                    return;
                }
            }
        }
    }
    
    public boolean getCanSwim() {
        return this.nodeProcessor.getCanSwim();
    }
    
    public void setAvoidSun(final boolean lllllllllllllIlIlIlIlIIlllIllIII) {
        this.shouldAvoidSun = lllllllllllllIlIlIlIlIIlllIllIII;
    }
    
    public void setBreakDoors(final boolean lllllllllllllIlIlIlIlIIlllllIIlI) {
        this.nodeProcessor.setCanBreakDoors(lllllllllllllIlIlIlIlIIlllllIIlI);
    }
    
    @Override
    protected PathFinder getPathFinder() {
        this.nodeProcessor = new WalkNodeProcessor();
        this.nodeProcessor.setCanEnterDoors(true);
        return new PathFinder(this.nodeProcessor);
    }
    
    @Override
    protected boolean canNavigate() {
        return this.theEntity.onGround || (this.getCanSwim() && this.isInLiquid()) || this.theEntity.isRiding();
    }
}
