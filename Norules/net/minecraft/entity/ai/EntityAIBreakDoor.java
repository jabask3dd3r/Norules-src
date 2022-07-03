package net.minecraft.entity.ai;

import net.minecraft.block.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;

public class EntityAIBreakDoor extends EntityAIDoorInteract
{
    private /* synthetic */ int previousBreakProgress;
    private /* synthetic */ int breakingTime;
    
    @Override
    public void updateTask() {
        super.updateTask();
        if (this.theEntity.getRNG().nextInt(20) == 0) {
            this.theEntity.world.playEvent(1019, this.doorPosition, 0);
        }
        ++this.breakingTime;
        final int lllllllllllllIIIIIlIlIIIlIIIllIl = (int)(this.breakingTime / 240.0f * 10.0f);
        if (lllllllllllllIIIIIlIlIIIlIIIllIl != this.previousBreakProgress) {
            this.theEntity.world.sendBlockBreakProgress(this.theEntity.getEntityId(), this.doorPosition, lllllllllllllIIIIIlIlIIIlIIIllIl);
            this.previousBreakProgress = lllllllllllllIIIIIlIlIIIlIIIllIl;
        }
        if (this.breakingTime == 240 && this.theEntity.world.getDifficulty() == EnumDifficulty.HARD) {
            this.theEntity.world.setBlockToAir(this.doorPosition);
            this.theEntity.world.playEvent(1021, this.doorPosition, 0);
            this.theEntity.world.playEvent(2001, this.doorPosition, Block.getIdFromBlock(this.doorBlock));
        }
    }
    
    @Override
    public void startExecuting() {
        super.startExecuting();
        this.breakingTime = 0;
    }
    
    @Override
    public boolean continueExecuting() {
        final double lllllllllllllIIIIIlIlIIIlIIllIll = this.theEntity.getDistanceSq(this.doorPosition);
        if (this.breakingTime <= 240) {
            final BlockDoor lllllllllllllIIIIIlIlIIIlIIllIII = this.doorBlock;
            if (!BlockDoor.isOpen(this.theEntity.world, this.doorPosition) && lllllllllllllIIIIIlIlIIIlIIllIll < 4.0) {
                final boolean lllllllllllllIIIIIlIlIIIlIIllIlI = true;
                return lllllllllllllIIIIIlIlIIIlIIllIlI;
            }
        }
        final boolean lllllllllllllIIIIIlIlIIIlIIllIIl = false;
        return lllllllllllllIIIIIlIlIIIlIIllIIl;
    }
    
    @Override
    public boolean shouldExecute() {
        if (!super.shouldExecute()) {
            return false;
        }
        if (!this.theEntity.world.getGameRules().getBoolean("mobGriefing")) {
            return false;
        }
        final BlockDoor lllllllllllllIIIIIlIlIIIlIlIIllI = this.doorBlock;
        return !BlockDoor.isOpen(this.theEntity.world, this.doorPosition);
    }
    
    public EntityAIBreakDoor(final EntityLiving lllllllllllllIIIIIlIlIIIlIlIllII) {
        super(lllllllllllllIIIIIlIlIIIlIlIllII);
        this.previousBreakProgress = -1;
    }
    
    @Override
    public void resetTask() {
        super.resetTask();
        this.theEntity.world.sendBlockBreakProgress(this.theEntity.getEntityId(), this.doorPosition, -1);
    }
}
