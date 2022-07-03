package net.minecraft.entity.ai;

import net.minecraft.util.math.*;
import net.minecraft.block.material.*;
import net.minecraft.block.state.*;
import net.minecraft.block.*;
import net.minecraft.entity.*;
import net.minecraft.pathfinding.*;

public abstract class EntityAIDoorInteract extends EntityAIBase
{
    protected /* synthetic */ BlockPos doorPosition;
    /* synthetic */ float entityPositionZ;
    protected /* synthetic */ BlockDoor doorBlock;
    /* synthetic */ boolean hasStoppedDoorInteraction;
    protected /* synthetic */ EntityLiving theEntity;
    /* synthetic */ float entityPositionX;
    
    @Override
    public void startExecuting() {
        this.hasStoppedDoorInteraction = false;
        this.entityPositionX = (float)(this.doorPosition.getX() + 0.5f - this.theEntity.posX);
        this.entityPositionZ = (float)(this.doorPosition.getZ() + 0.5f - this.theEntity.posZ);
    }
    
    @Override
    public void updateTask() {
        final float lllllllllllllIlIllllIlIIlIIllllI = (float)(this.doorPosition.getX() + 0.5f - this.theEntity.posX);
        final float lllllllllllllIlIllllIlIIlIIlllIl = (float)(this.doorPosition.getZ() + 0.5f - this.theEntity.posZ);
        final float lllllllllllllIlIllllIlIIlIIlllII = this.entityPositionX * lllllllllllllIlIllllIlIIlIIllllI + this.entityPositionZ * lllllllllllllIlIllllIlIIlIIlllIl;
        if (lllllllllllllIlIllllIlIIlIIlllII < 0.0f) {
            this.hasStoppedDoorInteraction = true;
        }
    }
    
    public EntityAIDoorInteract(final EntityLiving lllllllllllllIlIllllIlIIlIlllIll) {
        this.doorPosition = BlockPos.ORIGIN;
        this.theEntity = lllllllllllllIlIllllIlIIlIlllIll;
        if (!(lllllllllllllIlIllllIlIIlIlllIll.getNavigator() instanceof PathNavigateGround)) {
            throw new IllegalArgumentException("Unsupported mob type for DoorInteractGoal");
        }
    }
    
    private BlockDoor getBlockDoor(final BlockPos lllllllllllllIlIllllIlIIlIIIlllI) {
        final IBlockState lllllllllllllIlIllllIlIIlIIlIIIl = this.theEntity.world.getBlockState(lllllllllllllIlIllllIlIIlIIIlllI);
        final Block lllllllllllllIlIllllIlIIlIIlIIII = lllllllllllllIlIllllIlIIlIIlIIIl.getBlock();
        return (lllllllllllllIlIllllIlIIlIIlIIII instanceof BlockDoor && lllllllllllllIlIllllIlIIlIIlIIIl.getMaterial() == Material.WOOD) ? ((BlockDoor)lllllllllllllIlIllllIlIIlIIlIIII) : null;
    }
    
    @Override
    public boolean continueExecuting() {
        return !this.hasStoppedDoorInteraction;
    }
    
    @Override
    public boolean shouldExecute() {
        if (!this.theEntity.isCollidedHorizontally) {
            return false;
        }
        final PathNavigateGround lllllllllllllIlIllllIlIIlIllIIlI = (PathNavigateGround)this.theEntity.getNavigator();
        final Path lllllllllllllIlIllllIlIIlIllIIIl = lllllllllllllIlIllllIlIIlIllIIlI.getPath();
        if (lllllllllllllIlIllllIlIIlIllIIIl != null && !lllllllllllllIlIllllIlIIlIllIIIl.isFinished() && lllllllllllllIlIllllIlIIlIllIIlI.getEnterDoors()) {
            for (int lllllllllllllIlIllllIlIIlIllIIII = 0; lllllllllllllIlIllllIlIIlIllIIII < Math.min(lllllllllllllIlIllllIlIIlIllIIIl.getCurrentPathIndex() + 2, lllllllllllllIlIllllIlIIlIllIIIl.getCurrentPathLength()); ++lllllllllllllIlIllllIlIIlIllIIII) {
                final PathPoint lllllllllllllIlIllllIlIIlIlIllll = lllllllllllllIlIllllIlIIlIllIIIl.getPathPointFromIndex(lllllllllllllIlIllllIlIIlIllIIII);
                this.doorPosition = new BlockPos(lllllllllllllIlIllllIlIIlIlIllll.xCoord, lllllllllllllIlIllllIlIIlIlIllll.yCoord + 1, lllllllllllllIlIllllIlIIlIlIllll.zCoord);
                if (this.theEntity.getDistanceSq(this.doorPosition.getX(), this.theEntity.posY, this.doorPosition.getZ()) <= 2.25) {
                    this.doorBlock = this.getBlockDoor(this.doorPosition);
                    if (this.doorBlock != null) {
                        return true;
                    }
                }
            }
            this.doorPosition = new BlockPos(this.theEntity).up();
            this.doorBlock = this.getBlockDoor(this.doorPosition);
            return this.doorBlock != null;
        }
        return false;
    }
}
