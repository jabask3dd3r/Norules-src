package net.minecraft.entity.ai;

import net.minecraft.util.math.*;
import net.minecraft.entity.*;
import net.minecraft.village.*;
import net.minecraft.pathfinding.*;

public class EntityAIRestrictOpenDoor extends EntityAIBase
{
    private final /* synthetic */ EntityCreature entityObj;
    private /* synthetic */ VillageDoorInfo frontDoor;
    
    @Override
    public boolean shouldExecute() {
        if (this.entityObj.world.isDaytime()) {
            return false;
        }
        final BlockPos lllllllllllllllIIIlllIlIlIllIIlI = new BlockPos(this.entityObj);
        final Village lllllllllllllllIIIlllIlIlIllIIIl = this.entityObj.world.getVillageCollection().getNearestVillage(lllllllllllllllIIIlllIlIlIllIIlI, 16);
        if (lllllllllllllllIIIlllIlIlIllIIIl == null) {
            return false;
        }
        this.frontDoor = lllllllllllllllIIIlllIlIlIllIIIl.getNearestDoor(lllllllllllllllIIIlllIlIlIllIIlI);
        return this.frontDoor != null && this.frontDoor.getDistanceToInsideBlockSq(lllllllllllllllIIIlllIlIlIllIIlI) < 2.25;
    }
    
    @Override
    public boolean continueExecuting() {
        return !this.entityObj.world.isDaytime() && (!this.frontDoor.getIsDetachedFromVillageFlag() && this.frontDoor.isInsideSide(new BlockPos(this.entityObj)));
    }
    
    @Override
    public void startExecuting() {
        ((PathNavigateGround)this.entityObj.getNavigator()).setBreakDoors(false);
        ((PathNavigateGround)this.entityObj.getNavigator()).setEnterDoors(false);
    }
    
    public EntityAIRestrictOpenDoor(final EntityCreature lllllllllllllllIIIlllIlIlIlllIIl) {
        this.entityObj = lllllllllllllllIIIlllIlIlIlllIIl;
        if (!(lllllllllllllllIIIlllIlIlIlllIIl.getNavigator() instanceof PathNavigateGround)) {
            throw new IllegalArgumentException("Unsupported mob type for RestrictOpenDoorGoal");
        }
    }
    
    @Override
    public void resetTask() {
        ((PathNavigateGround)this.entityObj.getNavigator()).setBreakDoors(true);
        ((PathNavigateGround)this.entityObj.getNavigator()).setEnterDoors(true);
        this.frontDoor = null;
    }
    
    @Override
    public void updateTask() {
        this.frontDoor.incrementDoorOpeningRestrictionCounter();
    }
}
