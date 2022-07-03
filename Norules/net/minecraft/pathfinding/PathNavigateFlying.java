package net.minecraft.pathfinding;

import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.*;

public class PathNavigateFlying extends PathNavigate
{
    public void func_192879_a(final boolean llllllllllllllllIIlIIllIIlIlIIII) {
        this.nodeProcessor.setCanBreakDoors(llllllllllllllllIIlIIllIIlIlIIII);
    }
    
    @Override
    public boolean canEntityStandOnPos(final BlockPos llllllllllllllllIIlIIllIIIlllIll) {
        return this.worldObj.getBlockState(llllllllllllllllIIlIIllIIIlllIll).isFullyOpaque();
    }
    
    @Override
    protected PathFinder getPathFinder() {
        this.nodeProcessor = new FlyingNodeProcessor();
        this.nodeProcessor.setCanEnterDoors(true);
        return new PathFinder(this.nodeProcessor);
    }
    
    public PathNavigateFlying(final EntityLiving llllllllllllllllIIlIIllIlIllllII, final World llllllllllllllllIIlIIllIlIlllIll) {
        super(llllllllllllllllIIlIIllIlIllllII, llllllllllllllllIIlIIllIlIlllIll);
    }
    
    @Override
    protected boolean isDirectPathBetweenPoints(final Vec3d llllllllllllllllIIlIIllIlIIIlIlI, final Vec3d llllllllllllllllIIlIIllIIllIllIl, final int llllllllllllllllIIlIIllIlIIIlIII, final int llllllllllllllllIIlIIllIlIIIIlll, final int llllllllllllllllIIlIIllIlIIIIllI) {
        int llllllllllllllllIIlIIllIlIIIIlIl = MathHelper.floor(llllllllllllllllIIlIIllIlIIIlIlI.xCoord);
        int llllllllllllllllIIlIIllIlIIIIlII = MathHelper.floor(llllllllllllllllIIlIIllIlIIIlIlI.yCoord);
        int llllllllllllllllIIlIIllIlIIIIIll = MathHelper.floor(llllllllllllllllIIlIIllIlIIIlIlI.zCoord);
        double llllllllllllllllIIlIIllIlIIIIIlI = llllllllllllllllIIlIIllIIllIllIl.xCoord - llllllllllllllllIIlIIllIlIIIlIlI.xCoord;
        double llllllllllllllllIIlIIllIlIIIIIIl = llllllllllllllllIIlIIllIIllIllIl.yCoord - llllllllllllllllIIlIIllIlIIIlIlI.yCoord;
        double llllllllllllllllIIlIIllIlIIIIIII = llllllllllllllllIIlIIllIIllIllIl.zCoord - llllllllllllllllIIlIIllIlIIIlIlI.zCoord;
        final double llllllllllllllllIIlIIllIIlllllll = llllllllllllllllIIlIIllIlIIIIIlI * llllllllllllllllIIlIIllIlIIIIIlI + llllllllllllllllIIlIIllIlIIIIIIl * llllllllllllllllIIlIIllIlIIIIIIl + llllllllllllllllIIlIIllIlIIIIIII * llllllllllllllllIIlIIllIlIIIIIII;
        if (llllllllllllllllIIlIIllIIlllllll < 1.0E-8) {
            return false;
        }
        final double llllllllllllllllIIlIIllIIllllllI = 1.0 / Math.sqrt(llllllllllllllllIIlIIllIIlllllll);
        llllllllllllllllIIlIIllIlIIIIIlI *= llllllllllllllllIIlIIllIIllllllI;
        llllllllllllllllIIlIIllIlIIIIIIl *= llllllllllllllllIIlIIllIIllllllI;
        llllllllllllllllIIlIIllIlIIIIIII *= llllllllllllllllIIlIIllIIllllllI;
        final double llllllllllllllllIIlIIllIIlllllIl = 1.0 / Math.abs(llllllllllllllllIIlIIllIlIIIIIlI);
        final double llllllllllllllllIIlIIllIIlllllII = 1.0 / Math.abs(llllllllllllllllIIlIIllIlIIIIIIl);
        final double llllllllllllllllIIlIIllIIllllIll = 1.0 / Math.abs(llllllllllllllllIIlIIllIlIIIIIII);
        double llllllllllllllllIIlIIllIIllllIlI = llllllllllllllllIIlIIllIlIIIIlIl - llllllllllllllllIIlIIllIlIIIlIlI.xCoord;
        double llllllllllllllllIIlIIllIIllllIIl = llllllllllllllllIIlIIllIlIIIIlII - llllllllllllllllIIlIIllIlIIIlIlI.yCoord;
        double llllllllllllllllIIlIIllIIllllIII = llllllllllllllllIIlIIllIlIIIIIll - llllllllllllllllIIlIIllIlIIIlIlI.zCoord;
        if (llllllllllllllllIIlIIllIlIIIIIlI >= 0.0) {
            ++llllllllllllllllIIlIIllIIllllIlI;
        }
        if (llllllllllllllllIIlIIllIlIIIIIIl >= 0.0) {
            ++llllllllllllllllIIlIIllIIllllIIl;
        }
        if (llllllllllllllllIIlIIllIlIIIIIII >= 0.0) {
            ++llllllllllllllllIIlIIllIIllllIII;
        }
        llllllllllllllllIIlIIllIIllllIlI /= llllllllllllllllIIlIIllIlIIIIIlI;
        llllllllllllllllIIlIIllIIllllIIl /= llllllllllllllllIIlIIllIlIIIIIIl;
        llllllllllllllllIIlIIllIIllllIII /= llllllllllllllllIIlIIllIlIIIIIII;
        final int llllllllllllllllIIlIIllIIlllIlll = (llllllllllllllllIIlIIllIlIIIIIlI < 0.0) ? -1 : 1;
        final int llllllllllllllllIIlIIllIIlllIllI = (llllllllllllllllIIlIIllIlIIIIIIl < 0.0) ? -1 : 1;
        final int llllllllllllllllIIlIIllIIlllIlIl = (llllllllllllllllIIlIIllIlIIIIIII < 0.0) ? -1 : 1;
        final int llllllllllllllllIIlIIllIIlllIlII = MathHelper.floor(llllllllllllllllIIlIIllIIllIllIl.xCoord);
        final int llllllllllllllllIIlIIllIIlllIIll = MathHelper.floor(llllllllllllllllIIlIIllIIllIllIl.yCoord);
        final int llllllllllllllllIIlIIllIIlllIIlI = MathHelper.floor(llllllllllllllllIIlIIllIIllIllIl.zCoord);
        int llllllllllllllllIIlIIllIIlllIIIl = llllllllllllllllIIlIIllIIlllIlII - llllllllllllllllIIlIIllIlIIIIlIl;
        int llllllllllllllllIIlIIllIIlllIIII = llllllllllllllllIIlIIllIIlllIIll - llllllllllllllllIIlIIllIlIIIIlII;
        int llllllllllllllllIIlIIllIIllIllll = llllllllllllllllIIlIIllIIlllIIlI - llllllllllllllllIIlIIllIlIIIIIll;
        while (llllllllllllllllIIlIIllIIlllIIIl * llllllllllllllllIIlIIllIIlllIlll > 0 || llllllllllllllllIIlIIllIIlllIIII * llllllllllllllllIIlIIllIIlllIllI > 0 || llllllllllllllllIIlIIllIIllIllll * llllllllllllllllIIlIIllIIlllIlIl > 0) {
            if (llllllllllllllllIIlIIllIIllllIlI < llllllllllllllllIIlIIllIIllllIII && llllllllllllllllIIlIIllIIllllIlI <= llllllllllllllllIIlIIllIIllllIIl) {
                llllllllllllllllIIlIIllIIllllIlI += llllllllllllllllIIlIIllIIlllllIl;
                llllllllllllllllIIlIIllIlIIIIlIl += llllllllllllllllIIlIIllIIlllIlll;
                llllllllllllllllIIlIIllIIlllIIIl = llllllllllllllllIIlIIllIIlllIlII - llllllllllllllllIIlIIllIlIIIIlIl;
            }
            else if (llllllllllllllllIIlIIllIIllllIIl < llllllllllllllllIIlIIllIIllllIlI && llllllllllllllllIIlIIllIIllllIIl <= llllllllllllllllIIlIIllIIllllIII) {
                llllllllllllllllIIlIIllIIllllIIl += llllllllllllllllIIlIIllIIlllllII;
                llllllllllllllllIIlIIllIlIIIIlII += llllllllllllllllIIlIIllIIlllIllI;
                llllllllllllllllIIlIIllIIlllIIII = llllllllllllllllIIlIIllIIlllIIll - llllllllllllllllIIlIIllIlIIIIlII;
            }
            else {
                llllllllllllllllIIlIIllIIllllIII += llllllllllllllllIIlIIllIIllllIll;
                llllllllllllllllIIlIIllIlIIIIIll += llllllllllllllllIIlIIllIIlllIlIl;
                llllllllllllllllIIlIIllIIllIllll = llllllllllllllllIIlIIllIIlllIIlI - llllllllllllllllIIlIIllIlIIIIIll;
            }
        }
        return true;
    }
    
    public void func_192878_b(final boolean llllllllllllllllIIlIIllIIlIIlIlI) {
        this.nodeProcessor.setCanEnterDoors(llllllllllllllllIIlIIllIIlIIlIlI);
    }
    
    @Override
    public Path getPathToEntityLiving(final Entity llllllllllllllllIIlIIllIlIlIllII) {
        return this.getPathToPos(new BlockPos(llllllllllllllllIIlIIllIlIlIllII));
    }
    
    @Override
    protected Vec3d getEntityPosition() {
        return new Vec3d(this.theEntity.posX, this.theEntity.posY, this.theEntity.posZ);
    }
    
    @Override
    protected boolean canNavigate() {
        return (this.func_192880_g() && this.isInLiquid()) || !this.theEntity.isRiding();
    }
    
    public boolean func_192880_g() {
        return this.nodeProcessor.getCanSwim();
    }
    
    public void func_192877_c(final boolean llllllllllllllllIIlIIllIIlIIIlII) {
        this.nodeProcessor.setCanSwim(llllllllllllllllIIlIIllIIlIIIlII);
    }
    
    @Override
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
                final Vec3d llllllllllllllllIIlIIllIlIlIlIII = this.currentPath.getVectorFromIndex(this.theEntity, this.currentPath.getCurrentPathIndex());
                if (MathHelper.floor(this.theEntity.posX) == MathHelper.floor(llllllllllllllllIIlIIllIlIlIlIII.xCoord) && MathHelper.floor(this.theEntity.posY) == MathHelper.floor(llllllllllllllllIIlIIllIlIlIlIII.yCoord) && MathHelper.floor(this.theEntity.posZ) == MathHelper.floor(llllllllllllllllIIlIIllIlIlIlIII.zCoord)) {
                    this.currentPath.setCurrentPathIndex(this.currentPath.getCurrentPathIndex() + 1);
                }
            }
            this.func_192876_m();
            if (!this.noPath()) {
                final Vec3d llllllllllllllllIIlIIllIlIlIIlll = this.currentPath.getPosition(this.theEntity);
                this.theEntity.getMoveHelper().setMoveTo(llllllllllllllllIIlIIllIlIlIIlll.xCoord, llllllllllllllllIIlIIllIlIlIIlll.yCoord, llllllllllllllllIIlIIllIlIlIIlll.zCoord, this.speed);
            }
        }
    }
}
