package net.minecraft.entity.ai;

import net.minecraft.util.math.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;

public abstract class EntityAIMoveToBlock extends EntityAIBase
{
    private /* synthetic */ int maxStayTicks;
    private final /* synthetic */ EntityCreature theEntity;
    private /* synthetic */ int timeoutCounter;
    private /* synthetic */ boolean isAboveDestination;
    private final /* synthetic */ double movementSpeed;
    private final /* synthetic */ int searchLength;
    protected /* synthetic */ int runDelay;
    protected /* synthetic */ BlockPos destinationBlock;
    
    @Override
    public void startExecuting() {
        this.theEntity.getNavigator().tryMoveToXYZ((float)this.destinationBlock.getX() + 0.5, this.destinationBlock.getY() + 1, (float)this.destinationBlock.getZ() + 0.5, this.movementSpeed);
        this.timeoutCounter = 0;
        this.maxStayTicks = this.theEntity.getRNG().nextInt(this.theEntity.getRNG().nextInt(1200) + 1200) + 1200;
    }
    
    @Override
    public boolean shouldExecute() {
        if (this.runDelay > 0) {
            --this.runDelay;
            return false;
        }
        this.runDelay = 200 + this.theEntity.getRNG().nextInt(200);
        return this.searchForDestination();
    }
    
    @Override
    public boolean continueExecuting() {
        return this.timeoutCounter >= -this.maxStayTicks && this.timeoutCounter <= 1200 && this.shouldMoveTo(this.theEntity.world, this.destinationBlock);
    }
    
    private boolean searchForDestination() {
        final int lllllllllllllIIIIlIllIIllllIIIll = this.searchLength;
        final int lllllllllllllIIIIlIllIIllllIIIlI = 1;
        final BlockPos lllllllllllllIIIIlIllIIllllIIIIl = new BlockPos(this.theEntity);
        for (int lllllllllllllIIIIlIllIIllllIIIII = 0; lllllllllllllIIIIlIllIIllllIIIII <= 1; lllllllllllllIIIIlIllIIllllIIIII = ((lllllllllllllIIIIlIllIIllllIIIII > 0) ? (-lllllllllllllIIIIlIllIIllllIIIII) : (1 - lllllllllllllIIIIlIllIIllllIIIII))) {
            for (int lllllllllllllIIIIlIllIIlllIlllll = 0; lllllllllllllIIIIlIllIIlllIlllll < lllllllllllllIIIIlIllIIllllIIIll; ++lllllllllllllIIIIlIllIIlllIlllll) {
                for (int lllllllllllllIIIIlIllIIlllIllllI = 0; lllllllllllllIIIIlIllIIlllIllllI <= lllllllllllllIIIIlIllIIlllIlllll; lllllllllllllIIIIlIllIIlllIllllI = ((lllllllllllllIIIIlIllIIlllIllllI > 0) ? (-lllllllllllllIIIIlIllIIlllIllllI) : (1 - lllllllllllllIIIIlIllIIlllIllllI))) {
                    for (int lllllllllllllIIIIlIllIIlllIlllIl = (lllllllllllllIIIIlIllIIlllIllllI < lllllllllllllIIIIlIllIIlllIlllll && lllllllllllllIIIIlIllIIlllIllllI > -lllllllllllllIIIIlIllIIlllIlllll) ? lllllllllllllIIIIlIllIIlllIlllll : 0; lllllllllllllIIIIlIllIIlllIlllIl <= lllllllllllllIIIIlIllIIlllIlllll; lllllllllllllIIIIlIllIIlllIlllIl = ((lllllllllllllIIIIlIllIIlllIlllIl > 0) ? (-lllllllllllllIIIIlIllIIlllIlllIl) : (1 - lllllllllllllIIIIlIllIIlllIlllIl))) {
                        final BlockPos lllllllllllllIIIIlIllIIlllIlllII = lllllllllllllIIIIlIllIIllllIIIIl.add(lllllllllllllIIIIlIllIIlllIllllI, lllllllllllllIIIIlIllIIllllIIIII - 1, lllllllllllllIIIIlIllIIlllIlllIl);
                        if (this.theEntity.isWithinHomeDistanceFromPosition(lllllllllllllIIIIlIllIIlllIlllII) && this.shouldMoveTo(this.theEntity.world, lllllllllllllIIIIlIllIIlllIlllII)) {
                            this.destinationBlock = lllllllllllllIIIIlIllIIlllIlllII;
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    
    protected boolean getIsAboveDestination() {
        return this.isAboveDestination;
    }
    
    protected abstract boolean shouldMoveTo(final World p0, final BlockPos p1);
    
    @Override
    public void updateTask() {
        if (this.theEntity.getDistanceSqToCenter(this.destinationBlock.up()) > 1.0) {
            this.isAboveDestination = false;
            ++this.timeoutCounter;
            if (this.timeoutCounter % 40 == 0) {
                this.theEntity.getNavigator().tryMoveToXYZ((float)this.destinationBlock.getX() + 0.5, this.destinationBlock.getY() + 1, (float)this.destinationBlock.getZ() + 0.5, this.movementSpeed);
            }
        }
        else {
            this.isAboveDestination = true;
            --this.timeoutCounter;
        }
    }
    
    public EntityAIMoveToBlock(final EntityCreature lllllllllllllIIIIlIllIlIIIIIIIll, final double lllllllllllllIIIIlIllIIllllllllI, final int lllllllllllllIIIIlIllIlIIIIIIIIl) {
        this.destinationBlock = BlockPos.ORIGIN;
        this.theEntity = lllllllllllllIIIIlIllIlIIIIIIIll;
        this.movementSpeed = lllllllllllllIIIIlIllIIllllllllI;
        this.searchLength = lllllllllllllIIIIlIllIlIIIIIIIIl;
        this.setMutexBits(5);
    }
}
