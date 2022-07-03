package net.minecraft.pathfinding;

import net.minecraft.util.math.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;

public class PathNavigateClimber extends PathNavigateGround
{
    private /* synthetic */ BlockPos targetPosition;
    
    @Override
    public boolean tryMoveToEntityLiving(final Entity llllllllllllllIIIlIIIllllllIlllI, final double llllllllllllllIIIlIIIlllllllIIIl) {
        final Path llllllllllllllIIIlIIIlllllllIIII = this.getPathToEntityLiving(llllllllllllllIIIlIIIllllllIlllI);
        if (llllllllllllllIIIlIIIlllllllIIII != null) {
            return this.setPath(llllllllllllllIIIlIIIlllllllIIII, llllllllllllllIIIlIIIlllllllIIIl);
        }
        this.targetPosition = new BlockPos(llllllllllllllIIIlIIIllllllIlllI);
        this.speed = llllllllllllllIIIlIIIlllllllIIIl;
        return true;
    }
    
    @Override
    public Path getPathToPos(final BlockPos llllllllllllllIIIlIIIllllllllllI) {
        this.targetPosition = llllllllllllllIIIlIIIllllllllllI;
        return super.getPathToPos(llllllllllllllIIIlIIIllllllllllI);
    }
    
    @Override
    public void onUpdateNavigation() {
        if (!this.noPath()) {
            super.onUpdateNavigation();
        }
        else if (this.targetPosition != null) {
            final double llllllllllllllIIIlIIIllllllIlIII = this.theEntity.width * this.theEntity.width;
            if (this.theEntity.getDistanceSqToCenter(this.targetPosition) >= llllllllllllllIIIlIIIllllllIlIII && (this.theEntity.posY <= this.targetPosition.getY() || this.theEntity.getDistanceSqToCenter(new BlockPos(this.targetPosition.getX(), MathHelper.floor(this.theEntity.posY), this.targetPosition.getZ())) >= llllllllllllllIIIlIIIllllllIlIII)) {
                this.theEntity.getMoveHelper().setMoveTo(this.targetPosition.getX(), this.targetPosition.getY(), this.targetPosition.getZ(), this.speed);
            }
            else {
                this.targetPosition = null;
            }
        }
    }
    
    public PathNavigateClimber(final EntityLiving llllllllllllllIIIlIIlIIIIIIIlIII, final World llllllllllllllIIIlIIlIIIIIIIIlII) {
        super(llllllllllllllIIIlIIlIIIIIIIlIII, llllllllllllllIIIlIIlIIIIIIIIlII);
    }
    
    @Override
    public Path getPathToEntityLiving(final Entity llllllllllllllIIIlIIIllllllllIlI) {
        this.targetPosition = new BlockPos(llllllllllllllIIIlIIIllllllllIlI);
        return super.getPathToEntityLiving(llllllllllllllIIIlIIIllllllllIlI);
    }
}
