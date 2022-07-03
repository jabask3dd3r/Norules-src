package net.minecraft.util.math;

import com.google.common.annotations.*;
import javax.annotation.*;
import net.minecraft.util.*;

public class AxisAlignedBB
{
    public final /* synthetic */ double maxZ;
    public final /* synthetic */ double maxX;
    public final /* synthetic */ double minY;
    public final /* synthetic */ double minZ;
    public final /* synthetic */ double maxY;
    public final /* synthetic */ double minX;
    
    public AxisAlignedBB addCoord(final double llllllllllllllIIlIllIIIlllllllIl, final double llllllllllllllIIlIllIIIlllllIIIl, final double llllllllllllllIIlIllIIIlllllIIII) {
        double llllllllllllllIIlIllIIIllllllIlI = this.minX;
        double llllllllllllllIIlIllIIIllllllIIl = this.minY;
        double llllllllllllllIIlIllIIIllllllIII = this.minZ;
        double llllllllllllllIIlIllIIIlllllIlll = this.maxX;
        double llllllllllllllIIlIllIIIlllllIllI = this.maxY;
        double llllllllllllllIIlIllIIIlllllIlIl = this.maxZ;
        if (llllllllllllllIIlIllIIIlllllllIl < 0.0) {
            llllllllllllllIIlIllIIIllllllIlI += llllllllllllllIIlIllIIIlllllllIl;
        }
        else if (llllllllllllllIIlIllIIIlllllllIl > 0.0) {
            llllllllllllllIIlIllIIIlllllIlll += llllllllllllllIIlIllIIIlllllllIl;
        }
        if (llllllllllllllIIlIllIIIlllllIIIl < 0.0) {
            llllllllllllllIIlIllIIIllllllIIl += llllllllllllllIIlIllIIIlllllIIIl;
        }
        else if (llllllllllllllIIlIllIIIlllllIIIl > 0.0) {
            llllllllllllllIIlIllIIIlllllIllI += llllllllllllllIIlIllIIIlllllIIIl;
        }
        if (llllllllllllllIIlIllIIIlllllIIII < 0.0) {
            llllllllllllllIIlIllIIIllllllIII += llllllllllllllIIlIllIIIlllllIIII;
        }
        else if (llllllllllllllIIlIllIIIlllllIIII > 0.0) {
            llllllllllllllIIlIllIIIlllllIlIl += llllllllllllllIIlIllIIIlllllIIII;
        }
        return new AxisAlignedBB(llllllllllllllIIlIllIIIllllllIlI, llllllllllllllIIlIllIIIllllllIIl, llllllllllllllIIlIllIIIllllllIII, llllllllllllllIIlIllIIIlllllIlll, llllllllllllllIIlIllIIIlllllIllI, llllllllllllllIIlIllIIIlllllIlIl);
    }
    
    public boolean intersects(final Vec3d llllllllllllllIIlIllIIIlIIlllIII, final Vec3d llllllllllllllIIlIllIIIlIIllIlII) {
        return this.intersects(Math.min(llllllllllllllIIlIllIIIlIIlllIII.xCoord, llllllllllllllIIlIllIIIlIIllIlII.xCoord), Math.min(llllllllllllllIIlIllIIIlIIlllIII.yCoord, llllllllllllllIIlIllIIIlIIllIlII.yCoord), Math.min(llllllllllllllIIlIllIIIlIIlllIII.zCoord, llllllllllllllIIlIllIIIlIIllIlII.zCoord), Math.max(llllllllllllllIIlIllIIIlIIlllIII.xCoord, llllllllllllllIIlIllIIIlIIllIlII.xCoord), Math.max(llllllllllllllIIlIllIIIlIIlllIII.yCoord, llllllllllllllIIlIllIIIlIIllIlII.yCoord), Math.max(llllllllllllllIIlIllIIIlIIlllIII.zCoord, llllllllllllllIIlIllIIIlIIllIlII.zCoord));
    }
    
    @VisibleForTesting
    public boolean intersectsWithYZ(final Vec3d llllllllllllllIIlIllIIIIllIIllll) {
        return llllllllllllllIIlIllIIIIllIIllll.yCoord >= this.minY && llllllllllllllIIlIllIIIIllIIllll.yCoord <= this.maxY && llllllllllllllIIlIllIIIIllIIllll.zCoord >= this.minZ && llllllllllllllIIlIllIIIIllIIllll.zCoord <= this.maxZ;
    }
    
    public AxisAlignedBB func_191500_a(final AxisAlignedBB llllllllllllllIIlIllIIIllIllIlIl) {
        final double llllllllllllllIIlIllIIIllIllllII = Math.max(this.minX, llllllllllllllIIlIllIIIllIllIlIl.minX);
        final double llllllllllllllIIlIllIIIllIlllIll = Math.max(this.minY, llllllllllllllIIlIllIIIllIllIlIl.minY);
        final double llllllllllllllIIlIllIIIllIlllIlI = Math.max(this.minZ, llllllllllllllIIlIllIIIllIllIlIl.minZ);
        final double llllllllllllllIIlIllIIIllIlllIIl = Math.min(this.maxX, llllllllllllllIIlIllIIIllIllIlIl.maxX);
        final double llllllllllllllIIlIllIIIllIlllIII = Math.min(this.maxY, llllllllllllllIIlIllIIIllIllIlIl.maxY);
        final double llllllllllllllIIlIllIIIllIllIlll = Math.min(this.maxZ, llllllllllllllIIlIllIIIllIllIlIl.maxZ);
        return new AxisAlignedBB(llllllllllllllIIlIllIIIllIllllII, llllllllllllllIIlIllIIIllIlllIll, llllllllllllllIIlIllIIIllIlllIlI, llllllllllllllIIlIllIIIllIlllIIl, llllllllllllllIIlIllIIIllIlllIII, llllllllllllllIIlIllIIIllIllIlll);
    }
    
    @VisibleForTesting
    public boolean intersectsWithXY(final Vec3d llllllllllllllIIlIllIIIIllIIIIIl) {
        return llllllllllllllIIlIllIIIIllIIIIIl.xCoord >= this.minX && llllllllllllllIIlIllIIIIllIIIIIl.xCoord <= this.maxX && llllllllllllllIIlIllIIIIllIIIIIl.yCoord >= this.minY && llllllllllllllIIlIllIIIIllIIIIIl.yCoord <= this.maxY;
    }
    
    public boolean isVecInside(final Vec3d llllllllllllllIIlIllIIIlIIllIIII) {
        return llllllllllllllIIlIllIIIlIIllIIII.xCoord > this.minX && llllllllllllllIIlIllIIIlIIllIIII.xCoord < this.maxX && (llllllllllllllIIlIllIIIlIIllIIII.yCoord > this.minY && llllllllllllllIIlIllIIIlIIllIIII.yCoord < this.maxY) && (llllllllllllllIIlIllIIIlIIllIIII.zCoord > this.minZ && llllllllllllllIIlIllIIIlIIllIIII.zCoord < this.maxZ);
    }
    
    @VisibleForTesting
    public boolean intersectsWithXZ(final Vec3d llllllllllllllIIlIllIIIIllIIIlll) {
        return llllllllllllllIIlIllIIIIllIIIlll.xCoord >= this.minX && llllllllllllllIIlIllIIIIllIIIlll.xCoord <= this.maxX && llllllllllllllIIlIllIIIIllIIIlll.zCoord >= this.minZ && llllllllllllllIIlIllIIIIllIIIlll.zCoord <= this.maxZ;
    }
    
    public AxisAlignedBB(final BlockPos llllllllllllllIIlIllIIlIIlIlllIl) {
        this(llllllllllllllIIlIllIIlIIlIlllIl.getX(), llllllllllllllIIlIllIIlIIlIlllIl.getY(), llllllllllllllIIlIllIIlIIlIlllIl.getZ(), llllllllllllllIIlIllIIlIIlIlllIl.getX() + 1, llllllllllllllIIlIllIIlIIlIlllIl.getY() + 1, llllllllllllllIIlIllIIlIIlIlllIl.getZ() + 1);
    }
    
    @VisibleForTesting
    boolean isClosest(final Vec3d llllllllllllllIIlIllIIIlIIIIIlIl, @Nullable final Vec3d llllllllllllllIIlIllIIIlIIIIIlII, final Vec3d llllllllllllllIIlIllIIIlIIIIIIII) {
        return llllllllllllllIIlIllIIIlIIIIIlII == null || llllllllllllllIIlIllIIIlIIIIIlIl.squareDistanceTo(llllllllllllllIIlIllIIIlIIIIIIII) < llllllllllllllIIlIllIIIlIIIIIlIl.squareDistanceTo(llllllllllllllIIlIllIIIlIIIIIlII);
    }
    
    public AxisAlignedBB offset(final BlockPos llllllllllllllIIlIllIIIllIIIIlll) {
        return new AxisAlignedBB(this.minX + llllllllllllllIIlIllIIIllIIIIlll.getX(), this.minY + llllllllllllllIIlIllIIIllIIIIlll.getY(), this.minZ + llllllllllllllIIlIllIIIllIIIIlll.getZ(), this.maxX + llllllllllllllIIlIllIIIllIIIIlll.getX(), this.maxY + llllllllllllllIIlIllIIIllIIIIlll.getY(), this.maxZ + llllllllllllllIIlIllIIIllIIIIlll.getZ());
    }
    
    public AxisAlignedBB setMaxY(final double llllllllllllllIIlIllIIlIIIlllIIl) {
        return new AxisAlignedBB(this.minX, this.minY, this.minZ, this.maxX, llllllllllllllIIlIllIIlIIIlllIIl, this.maxZ);
    }
    
    public AxisAlignedBB expand(final double llllllllllllllIIlIllIIIlllIlIlIl, final double llllllllllllllIIlIllIIIlllIlIIll, final double llllllllllllllIIlIllIIIlllIlllIl) {
        final double llllllllllllllIIlIllIIIlllIlllII = this.minX - llllllllllllllIIlIllIIIlllIlIlIl;
        final double llllllllllllllIIlIllIIIlllIllIll = this.minY - llllllllllllllIIlIllIIIlllIlIIll;
        final double llllllllllllllIIlIllIIIlllIllIlI = this.minZ - llllllllllllllIIlIllIIIlllIlllIl;
        final double llllllllllllllIIlIllIIIlllIllIIl = this.maxX + llllllllllllllIIlIllIIIlllIlIlIl;
        final double llllllllllllllIIlIllIIIlllIllIII = this.maxY + llllllllllllllIIlIllIIIlllIlIIll;
        final double llllllllllllllIIlIllIIIlllIlIlll = this.maxZ + llllllllllllllIIlIllIIIlllIlllIl;
        return new AxisAlignedBB(llllllllllllllIIlIllIIIlllIlllII, llllllllllllllIIlIllIIIlllIllIll, llllllllllllllIIlIllIIIlllIllIlI, llllllllllllllIIlIllIIIlllIllIIl, llllllllllllllIIlIllIIIlllIllIII, llllllllllllllIIlIllIIIlllIlIlll);
    }
    
    public AxisAlignedBB offset(final double llllllllllllllIIlIllIIIllIIlIIIl, final double llllllllllllllIIlIllIIIllIIIllII, final double llllllllllllllIIlIllIIIllIIIlIll) {
        return new AxisAlignedBB(this.minX + llllllllllllllIIlIllIIIllIIlIIIl, this.minY + llllllllllllllIIlIllIIIllIIIllII, this.minZ + llllllllllllllIIlIllIIIllIIIlIll, this.maxX + llllllllllllllIIlIllIIIllIIlIIIl, this.maxY + llllllllllllllIIlIllIIIllIIIllII, this.maxZ + llllllllllllllIIlIllIIIllIIIlIll);
    }
    
    public boolean intersectsWith(final AxisAlignedBB llllllllllllllIIlIllIIIlIlIlIlII) {
        return this.intersects(llllllllllllllIIlIllIIIlIlIlIlII.minX, llllllllllllllIIlIllIIIlIlIlIlII.minY, llllllllllllllIIlIllIIIlIlIlIlII.minZ, llllllllllllllIIlIllIIIlIlIlIlII.maxX, llllllllllllllIIlIllIIIlIlIlIlII.maxY, llllllllllllllIIlIllIIIlIlIlIlII.maxZ);
    }
    
    @Nullable
    @VisibleForTesting
    Vec3d collideWithXPlane(final double llllllllllllllIIlIllIIIIlllllIIl, final Vec3d llllllllllllllIIlIllIIIIlllllIII, final Vec3d llllllllllllllIIlIllIIIIllllIIlI) {
        final Vec3d llllllllllllllIIlIllIIIIllllIllI = llllllllllllllIIlIllIIIIlllllIII.getIntermediateWithXValue(llllllllllllllIIlIllIIIIllllIIlI, llllllllllllllIIlIllIIIIlllllIIl);
        return (llllllllllllllIIlIllIIIIllllIllI != null && this.intersectsWithYZ(llllllllllllllIIlIllIIIIllllIllI)) ? llllllllllllllIIlIllIIIIllllIllI : null;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("box[").append(this.minX).append(", ").append(this.minY).append(", ").append(this.minZ).append(" -> ").append(this.maxX).append(", ").append(this.maxY).append(", ").append(this.maxZ).append("]"));
    }
    
    public double calculateXOffset(final AxisAlignedBB llllllllllllllIIlIllIIIlIlllIlII, double llllllllllllllIIlIllIIIlIlllIIll) {
        if (llllllllllllllIIlIllIIIlIlllIlII.maxY > this.minY && llllllllllllllIIlIllIIIlIlllIlII.minY < this.maxY && llllllllllllllIIlIllIIIlIlllIlII.maxZ > this.minZ && llllllllllllllIIlIllIIIlIlllIlII.minZ < this.maxZ) {
            if (llllllllllllllIIlIllIIIlIlllIIll > 0.0 && llllllllllllllIIlIllIIIlIlllIlII.maxX <= this.minX) {
                final double llllllllllllllIIlIllIIIlIlllIlll = this.minX - llllllllllllllIIlIllIIIlIlllIlII.maxX;
                if (llllllllllllllIIlIllIIIlIlllIlll < llllllllllllllIIlIllIIIlIlllIIll) {
                    llllllllllllllIIlIllIIIlIlllIIll = llllllllllllllIIlIllIIIlIlllIlll;
                }
            }
            else if (llllllllllllllIIlIllIIIlIlllIIll < 0.0 && llllllllllllllIIlIllIIIlIlllIlII.minX >= this.maxX) {
                final double llllllllllllllIIlIllIIIlIlllIllI = this.maxX - llllllllllllllIIlIllIIIlIlllIlII.minX;
                if (llllllllllllllIIlIllIIIlIlllIllI > llllllllllllllIIlIllIIIlIlllIIll) {
                    llllllllllllllIIlIllIIIlIlllIIll = llllllllllllllIIlIllIIIlIlllIllI;
                }
            }
            return llllllllllllllIIlIllIIIlIlllIIll;
        }
        return llllllllllllllIIlIllIIIlIlllIIll;
    }
    
    public AxisAlignedBB(final double llllllllllllllIIlIllIIlIIllIlllI, final double llllllllllllllIIlIllIIlIIlllIlIl, final double llllllllllllllIIlIllIIlIIllIllII, final double llllllllllllllIIlIllIIlIIlllIIlI, final double llllllllllllllIIlIllIIlIIllIlIlI, final double llllllllllllllIIlIllIIlIIllIlIIl) {
        this.minX = Math.min(llllllllllllllIIlIllIIlIIllIlllI, llllllllllllllIIlIllIIlIIlllIIlI);
        this.minY = Math.min(llllllllllllllIIlIllIIlIIlllIlIl, llllllllllllllIIlIllIIlIIllIlIlI);
        this.minZ = Math.min(llllllllllllllIIlIllIIlIIllIllII, llllllllllllllIIlIllIIlIIllIlIIl);
        this.maxX = Math.max(llllllllllllllIIlIllIIlIIllIlllI, llllllllllllllIIlIllIIlIIlllIIlI);
        this.maxY = Math.max(llllllllllllllIIlIllIIlIIlllIlIl, llllllllllllllIIlIllIIlIIllIlIlI);
        this.maxZ = Math.max(llllllllllllllIIlIllIIlIIllIllII, llllllllllllllIIlIllIIlIIllIlIIl);
    }
    
    public double calculateYOffset(final AxisAlignedBB llllllllllllllIIlIllIIIlIllIllII, double llllllllllllllIIlIllIIIlIllIIllI) {
        if (llllllllllllllIIlIllIIIlIllIllII.maxX > this.minX && llllllllllllllIIlIllIIIlIllIllII.minX < this.maxX && llllllllllllllIIlIllIIIlIllIllII.maxZ > this.minZ && llllllllllllllIIlIllIIIlIllIllII.minZ < this.maxZ) {
            if (llllllllllllllIIlIllIIIlIllIIllI > 0.0 && llllllllllllllIIlIllIIIlIllIllII.maxY <= this.minY) {
                final double llllllllllllllIIlIllIIIlIllIlIlI = this.minY - llllllllllllllIIlIllIIIlIllIllII.maxY;
                if (llllllllllllllIIlIllIIIlIllIlIlI < llllllllllllllIIlIllIIIlIllIIllI) {
                    llllllllllllllIIlIllIIIlIllIIllI = llllllllllllllIIlIllIIIlIllIlIlI;
                }
            }
            else if (llllllllllllllIIlIllIIIlIllIIllI < 0.0 && llllllllllllllIIlIllIIIlIllIllII.minY >= this.maxY) {
                final double llllllllllllllIIlIllIIIlIllIlIIl = this.maxY - llllllllllllllIIlIllIIIlIllIllII.minY;
                if (llllllllllllllIIlIllIIIlIllIlIIl > llllllllllllllIIlIllIIIlIllIIllI) {
                    llllllllllllllIIlIllIIIlIllIIllI = llllllllllllllIIlIllIIIlIllIlIIl;
                }
            }
            return (double)llllllllllllllIIlIllIIIlIllIIllI;
        }
        return (double)llllllllllllllIIlIllIIIlIllIIllI;
    }
    
    public AxisAlignedBB(final BlockPos llllllllllllllIIlIllIIlIIlIlIIII, final BlockPos llllllllllllllIIlIllIIlIIlIIlIlI) {
        this(llllllllllllllIIlIllIIlIIlIlIIII.getX(), llllllllllllllIIlIllIIlIIlIlIIII.getY(), llllllllllllllIIlIllIIlIIlIlIIII.getZ(), llllllllllllllIIlIllIIlIIlIIlIlI.getX(), llllllllllllllIIlIllIIlIIlIIlIlI.getY(), llllllllllllllIIlIllIIlIIlIIlIlI.getZ());
    }
    
    @Nullable
    public RayTraceResult calculateIntercept(final Vec3d llllllllllllllIIlIllIIIlIIIlIlII, final Vec3d llllllllllllllIIlIllIIIlIIIlIIll) {
        Vec3d llllllllllllllIIlIllIIIlIIIlIIlI = this.collideWithXPlane(this.minX, llllllllllllllIIlIllIIIlIIIlIlII, llllllllllllllIIlIllIIIlIIIlIIll);
        EnumFacing llllllllllllllIIlIllIIIlIIIlIIIl = EnumFacing.WEST;
        Vec3d llllllllllllllIIlIllIIIlIIIlIIII = this.collideWithXPlane(this.maxX, llllllllllllllIIlIllIIIlIIIlIlII, llllllllllllllIIlIllIIIlIIIlIIll);
        if (llllllllllllllIIlIllIIIlIIIlIIII != null && this.isClosest(llllllllllllllIIlIllIIIlIIIlIlII, llllllllllllllIIlIllIIIlIIIlIIlI, llllllllllllllIIlIllIIIlIIIlIIII)) {
            llllllllllllllIIlIllIIIlIIIlIIlI = llllllllllllllIIlIllIIIlIIIlIIII;
            llllllllllllllIIlIllIIIlIIIlIIIl = EnumFacing.EAST;
        }
        llllllllllllllIIlIllIIIlIIIlIIII = this.collideWithYPlane(this.minY, llllllllllllllIIlIllIIIlIIIlIlII, llllllllllllllIIlIllIIIlIIIlIIll);
        if (llllllllllllllIIlIllIIIlIIIlIIII != null && this.isClosest(llllllllllllllIIlIllIIIlIIIlIlII, llllllllllllllIIlIllIIIlIIIlIIlI, llllllllllllllIIlIllIIIlIIIlIIII)) {
            llllllllllllllIIlIllIIIlIIIlIIlI = llllllllllllllIIlIllIIIlIIIlIIII;
            llllllllllllllIIlIllIIIlIIIlIIIl = EnumFacing.DOWN;
        }
        llllllllllllllIIlIllIIIlIIIlIIII = this.collideWithYPlane(this.maxY, llllllllllllllIIlIllIIIlIIIlIlII, llllllllllllllIIlIllIIIlIIIlIIll);
        if (llllllllllllllIIlIllIIIlIIIlIIII != null && this.isClosest(llllllllllllllIIlIllIIIlIIIlIlII, llllllllllllllIIlIllIIIlIIIlIIlI, llllllllllllllIIlIllIIIlIIIlIIII)) {
            llllllllllllllIIlIllIIIlIIIlIIlI = llllllllllllllIIlIllIIIlIIIlIIII;
            llllllllllllllIIlIllIIIlIIIlIIIl = EnumFacing.UP;
        }
        llllllllllllllIIlIllIIIlIIIlIIII = this.collideWithZPlane(this.minZ, llllllllllllllIIlIllIIIlIIIlIlII, llllllllllllllIIlIllIIIlIIIlIIll);
        if (llllllllllllllIIlIllIIIlIIIlIIII != null && this.isClosest(llllllllllllllIIlIllIIIlIIIlIlII, llllllllllllllIIlIllIIIlIIIlIIlI, llllllllllllllIIlIllIIIlIIIlIIII)) {
            llllllllllllllIIlIllIIIlIIIlIIlI = llllllllllllllIIlIllIIIlIIIlIIII;
            llllllllllllllIIlIllIIIlIIIlIIIl = EnumFacing.NORTH;
        }
        llllllllllllllIIlIllIIIlIIIlIIII = this.collideWithZPlane(this.maxZ, llllllllllllllIIlIllIIIlIIIlIlII, llllllllllllllIIlIllIIIlIIIlIIll);
        if (llllllllllllllIIlIllIIIlIIIlIIII != null && this.isClosest(llllllllllllllIIlIllIIIlIIIlIlII, llllllllllllllIIlIllIIIlIIIlIIlI, llllllllllllllIIlIllIIIlIIIlIIII)) {
            llllllllllllllIIlIllIIIlIIIlIIlI = llllllllllllllIIlIllIIIlIIIlIIII;
            llllllllllllllIIlIllIIIlIIIlIIIl = EnumFacing.SOUTH;
        }
        return (llllllllllllllIIlIllIIIlIIIlIIlI == null) ? null : new RayTraceResult(llllllllllllllIIlIllIIIlIIIlIIlI, llllllllllllllIIlIllIIIlIIIlIIIl);
    }
    
    public double calculateZOffset(final AxisAlignedBB llllllllllllllIIlIllIIIlIlIlllll, double llllllllllllllIIlIllIIIlIlIllIIl) {
        if (llllllllllllllIIlIllIIIlIlIlllll.maxX > this.minX && llllllllllllllIIlIllIIIlIlIlllll.minX < this.maxX && llllllllllllllIIlIllIIIlIlIlllll.maxY > this.minY && llllllllllllllIIlIllIIIlIlIlllll.minY < this.maxY) {
            if (llllllllllllllIIlIllIIIlIlIllIIl > 0.0 && llllllllllllllIIlIllIIIlIlIlllll.maxZ <= this.minZ) {
                final double llllllllllllllIIlIllIIIlIlIlllIl = this.minZ - llllllllllllllIIlIllIIIlIlIlllll.maxZ;
                if (llllllllllllllIIlIllIIIlIlIlllIl < llllllllllllllIIlIllIIIlIlIllIIl) {
                    llllllllllllllIIlIllIIIlIlIllIIl = llllllllllllllIIlIllIIIlIlIlllIl;
                }
            }
            else if (llllllllllllllIIlIllIIIlIlIllIIl < 0.0 && llllllllllllllIIlIllIIIlIlIlllll.minZ >= this.maxZ) {
                final double llllllllllllllIIlIllIIIlIlIlllII = this.maxZ - llllllllllllllIIlIllIIIlIlIlllll.minZ;
                if (llllllllllllllIIlIllIIIlIlIlllII > llllllllllllllIIlIllIIIlIlIllIIl) {
                    llllllllllllllIIlIllIIIlIlIllIIl = llllllllllllllIIlIllIIIlIlIlllII;
                }
            }
            return llllllllllllllIIlIllIIIlIlIllIIl;
        }
        return llllllllllllllIIlIllIIIlIlIllIIl;
    }
    
    @Nullable
    @VisibleForTesting
    Vec3d collideWithZPlane(final double llllllllllllllIIlIllIIIIllIlIllI, final Vec3d llllllllllllllIIlIllIIIIllIlIlIl, final Vec3d llllllllllllllIIlIllIIIIllIllIIl) {
        final Vec3d llllllllllllllIIlIllIIIIllIllIII = llllllllllllllIIlIllIIIIllIlIlIl.getIntermediateWithZValue(llllllllllllllIIlIllIIIIllIllIIl, llllllllllllllIIlIllIIIIllIlIllI);
        return (llllllllllllllIIlIllIIIIllIllIII != null && this.intersectsWithXY(llllllllllllllIIlIllIIIIllIllIII)) ? llllllllllllllIIlIllIIIIllIllIII : null;
    }
    
    public AxisAlignedBB contract(final double llllllllllllllIIlIllIIIlIIIllllI) {
        return this.expandXyz(-llllllllllllllIIlIllIIIlIIIllllI);
    }
    
    public boolean intersects(final double llllllllllllllIIlIllIIIlIlIIIIlI, final double llllllllllllllIIlIllIIIlIlIIlIII, final double llllllllllllllIIlIllIIIlIlIIIIII, final double llllllllllllllIIlIllIIIlIlIIIllI, final double llllllllllllllIIlIllIIIlIlIIIlIl, final double llllllllllllllIIlIllIIIlIIllllIl) {
        return this.minX < llllllllllllllIIlIllIIIlIlIIIllI && this.maxX > llllllllllllllIIlIllIIIlIlIIIIlI && this.minY < llllllllllllllIIlIllIIIlIlIIIlIl && this.maxY > llllllllllllllIIlIllIIIlIlIIlIII && this.minZ < llllllllllllllIIlIllIIIlIIllllIl && this.maxZ > llllllllllllllIIlIllIIIlIlIIIIII;
    }
    
    @Override
    public boolean equals(final Object llllllllllllllIIlIllIIlIIIllIIIl) {
        if (this == llllllllllllllIIlIllIIlIIIllIIIl) {
            return true;
        }
        if (!(llllllllllllllIIlIllIIlIIIllIIIl instanceof AxisAlignedBB)) {
            return false;
        }
        final AxisAlignedBB llllllllllllllIIlIllIIlIIIllIIll = (AxisAlignedBB)llllllllllllllIIlIllIIlIIIllIIIl;
        return Double.compare(llllllllllllllIIlIllIIlIIIllIIll.minX, this.minX) == 0 && Double.compare(llllllllllllllIIlIllIIlIIIllIIll.minY, this.minY) == 0 && Double.compare(llllllllllllllIIlIllIIlIIIllIIll.minZ, this.minZ) == 0 && Double.compare(llllllllllllllIIlIllIIlIIIllIIll.maxX, this.maxX) == 0 && Double.compare(llllllllllllllIIlIllIIlIIIllIIll.maxY, this.maxY) == 0 && Double.compare(llllllllllllllIIlIllIIlIIIllIIll.maxZ, this.maxZ) == 0;
    }
    
    public AxisAlignedBB expandXyz(final double llllllllllllllIIlIllIIIlllIIIlll) {
        return this.expand(llllllllllllllIIlIllIIIlllIIIlll, llllllllllllllIIlIllIIIlllIIIlll, llllllllllllllIIlIllIIIlllIIIlll);
    }
    
    public Vec3d getCenter() {
        return new Vec3d(this.minX + (this.maxX - this.minX) * 0.5, this.minY + (this.maxY - this.minY) * 0.5, this.minZ + (this.maxZ - this.minZ) * 0.5);
    }
    
    @Nullable
    @VisibleForTesting
    Vec3d collideWithYPlane(final double llllllllllllllIIlIllIIIIlllIIlIl, final Vec3d llllllllllllllIIlIllIIIIlllIIlII, final Vec3d llllllllllllllIIlIllIIIIlllIlIII) {
        final Vec3d llllllllllllllIIlIllIIIIlllIIlll = llllllllllllllIIlIllIIIIlllIIlII.getIntermediateWithYValue(llllllllllllllIIlIllIIIIlllIlIII, llllllllllllllIIlIllIIIIlllIIlIl);
        return (llllllllllllllIIlIllIIIIlllIIlll != null && this.intersectsWithXZ(llllllllllllllIIlIllIIIIlllIIlll)) ? llllllllllllllIIlIllIIIIlllIIlll : null;
    }
    
    public AxisAlignedBB(final Vec3d llllllllllllllIIlIllIIlIIlIIIIll, final Vec3d llllllllllllllIIlIllIIlIIIllllll) {
        this(llllllllllllllIIlIllIIlIIlIIIIll.xCoord, llllllllllllllIIlIllIIlIIlIIIIll.yCoord, llllllllllllllIIlIllIIlIIlIIIIll.zCoord, llllllllllllllIIlIllIIlIIIllllll.xCoord, llllllllllllllIIlIllIIlIIIllllll.yCoord, llllllllllllllIIlIllIIlIIIllllll.zCoord);
    }
    
    public double getAverageEdgeLength() {
        final double llllllllllllllIIlIllIIIlIIlIlIII = this.maxX - this.minX;
        final double llllllllllllllIIlIllIIIlIIlIIlll = this.maxY - this.minY;
        final double llllllllllllllIIlIllIIIlIIlIIllI = this.maxZ - this.minZ;
        return (llllllllllllllIIlIllIIIlIIlIlIII + llllllllllllllIIlIllIIIlIIlIIlll + llllllllllllllIIlIllIIIlIIlIIllI) / 3.0;
    }
    
    @Override
    public int hashCode() {
        long llllllllllllllIIlIllIIlIIIlIlIll = Double.doubleToLongBits(this.minX);
        int llllllllllllllIIlIllIIlIIIlIlIlI = (int)(llllllllllllllIIlIllIIlIIIlIlIll ^ llllllllllllllIIlIllIIlIIIlIlIll >>> 32);
        llllllllllllllIIlIllIIlIIIlIlIll = Double.doubleToLongBits(this.minY);
        llllllllllllllIIlIllIIlIIIlIlIlI = 31 * llllllllllllllIIlIllIIlIIIlIlIlI + (int)(llllllllllllllIIlIllIIlIIIlIlIll ^ llllllllllllllIIlIllIIlIIIlIlIll >>> 32);
        llllllllllllllIIlIllIIlIIIlIlIll = Double.doubleToLongBits(this.minZ);
        llllllllllllllIIlIllIIlIIIlIlIlI = 31 * llllllllllllllIIlIllIIlIIIlIlIlI + (int)(llllllllllllllIIlIllIIlIIIlIlIll ^ llllllllllllllIIlIllIIlIIIlIlIll >>> 32);
        llllllllllllllIIlIllIIlIIIlIlIll = Double.doubleToLongBits(this.maxX);
        llllllllllllllIIlIllIIlIIIlIlIlI = 31 * llllllllllllllIIlIllIIlIIIlIlIlI + (int)(llllllllllllllIIlIllIIlIIIlIlIll ^ llllllllllllllIIlIllIIlIIIlIlIll >>> 32);
        llllllllllllllIIlIllIIlIIIlIlIll = Double.doubleToLongBits(this.maxY);
        llllllllllllllIIlIllIIlIIIlIlIlI = 31 * llllllllllllllIIlIllIIlIIIlIlIlI + (int)(llllllllllllllIIlIllIIlIIIlIlIll ^ llllllllllllllIIlIllIIlIIIlIlIll >>> 32);
        llllllllllllllIIlIllIIlIIIlIlIll = Double.doubleToLongBits(this.maxZ);
        llllllllllllllIIlIllIIlIIIlIlIlI = 31 * llllllllllllllIIlIllIIlIIIlIlIlI + (int)(llllllllllllllIIlIllIIlIIIlIlIll ^ llllllllllllllIIlIllIIlIIIlIlIll >>> 32);
        return llllllllllllllIIlIllIIlIIIlIlIlI;
    }
    
    public AxisAlignedBB func_191194_a(final Vec3d llllllllllllllIIlIllIIIllIIIIIIl) {
        return this.offset(llllllllllllllIIlIllIIIllIIIIIIl.xCoord, llllllllllllllIIlIllIIIllIIIIIIl.yCoord, llllllllllllllIIlIllIIIllIIIIIIl.zCoord);
    }
    
    public boolean hasNaN() {
        return Double.isNaN(this.minX) || Double.isNaN(this.minY) || Double.isNaN(this.minZ) || Double.isNaN(this.maxX) || Double.isNaN(this.maxY) || Double.isNaN(this.maxZ);
    }
    
    public AxisAlignedBB func_191195_a(final double llllllllllllllIIlIllIIlIIIIlIIII, final double llllllllllllllIIlIllIIlIIIIIllll, final double llllllllllllllIIlIllIIlIIIIllIIl) {
        double llllllllllllllIIlIllIIlIIIIllIII = this.minX;
        double llllllllllllllIIlIllIIlIIIIlIlll = this.minY;
        double llllllllllllllIIlIllIIlIIIIlIllI = this.minZ;
        double llllllllllllllIIlIllIIlIIIIlIlIl = this.maxX;
        double llllllllllllllIIlIllIIlIIIIlIlII = this.maxY;
        double llllllllllllllIIlIllIIlIIIIlIIll = this.maxZ;
        if (llllllllllllllIIlIllIIlIIIIlIIII < 0.0) {
            llllllllllllllIIlIllIIlIIIIllIII -= llllllllllllllIIlIllIIlIIIIlIIII;
        }
        else if (llllllllllllllIIlIllIIlIIIIlIIII > 0.0) {
            llllllllllllllIIlIllIIlIIIIlIlIl -= llllllllllllllIIlIllIIlIIIIlIIII;
        }
        if (llllllllllllllIIlIllIIlIIIIIllll < 0.0) {
            llllllllllllllIIlIllIIlIIIIlIlll -= llllllllllllllIIlIllIIlIIIIIllll;
        }
        else if (llllllllllllllIIlIllIIlIIIIIllll > 0.0) {
            llllllllllllllIIlIllIIlIIIIlIlII -= llllllllllllllIIlIllIIlIIIIIllll;
        }
        if (llllllllllllllIIlIllIIlIIIIllIIl < 0.0) {
            llllllllllllllIIlIllIIlIIIIlIllI -= llllllllllllllIIlIllIIlIIIIllIIl;
        }
        else if (llllllllllllllIIlIllIIlIIIIllIIl > 0.0) {
            llllllllllllllIIlIllIIlIIIIlIIll -= llllllllllllllIIlIllIIlIIIIllIIl;
        }
        return new AxisAlignedBB(llllllllllllllIIlIllIIlIIIIllIII, llllllllllllllIIlIllIIlIIIIlIlll, llllllllllllllIIlIllIIlIIIIlIllI, llllllllllllllIIlIllIIlIIIIlIlIl, llllllllllllllIIlIllIIlIIIIlIlII, llllllllllllllIIlIllIIlIIIIlIIll);
    }
    
    public AxisAlignedBB union(final AxisAlignedBB llllllllllllllIIlIllIIIllIIlllIl) {
        final double llllllllllllllIIlIllIIIllIlIIlII = Math.min(this.minX, llllllllllllllIIlIllIIIllIIlllIl.minX);
        final double llllllllllllllIIlIllIIIllIlIIIll = Math.min(this.minY, llllllllllllllIIlIllIIIllIIlllIl.minY);
        final double llllllllllllllIIlIllIIIllIlIIIlI = Math.min(this.minZ, llllllllllllllIIlIllIIIllIIlllIl.minZ);
        final double llllllllllllllIIlIllIIIllIlIIIIl = Math.max(this.maxX, llllllllllllllIIlIllIIIllIIlllIl.maxX);
        final double llllllllllllllIIlIllIIIllIlIIIII = Math.max(this.maxY, llllllllllllllIIlIllIIIllIIlllIl.maxY);
        final double llllllllllllllIIlIllIIIllIIlllll = Math.max(this.maxZ, llllllllllllllIIlIllIIIllIIlllIl.maxZ);
        return new AxisAlignedBB(llllllllllllllIIlIllIIIllIlIIlII, llllllllllllllIIlIllIIIllIlIIIll, llllllllllllllIIlIllIIIllIlIIIlI, llllllllllllllIIlIllIIIllIlIIIIl, llllllllllllllIIlIllIIIllIlIIIII, llllllllllllllIIlIllIIIllIIlllll);
    }
}
