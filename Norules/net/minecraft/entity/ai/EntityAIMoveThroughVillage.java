package net.minecraft.entity.ai;

import java.util.*;
import com.google.common.collect.*;
import net.minecraft.pathfinding.*;
import net.minecraft.village.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;

public class EntityAIMoveThroughVillage extends EntityAIBase
{
    private final /* synthetic */ boolean isNocturnal;
    private final /* synthetic */ double movementSpeed;
    private /* synthetic */ VillageDoorInfo doorInfo;
    private final /* synthetic */ List<VillageDoorInfo> doorList;
    private /* synthetic */ Path entityPathNavigate;
    private final /* synthetic */ EntityCreature theEntity;
    
    @Override
    public void startExecuting() {
        this.theEntity.getNavigator().setPath(this.entityPathNavigate, this.movementSpeed);
    }
    
    private void resizeDoorList() {
        if (this.doorList.size() > 15) {
            this.doorList.remove(0);
        }
    }
    
    @Override
    public boolean continueExecuting() {
        if (this.theEntity.getNavigator().noPath()) {
            return false;
        }
        final float lllllllllllllllIIIllIlIlIIlIIIIl = this.theEntity.width + 4.0f;
        return this.theEntity.getDistanceSq(this.doorInfo.getDoorBlockPos()) > lllllllllllllllIIIllIlIlIIlIIIIl * lllllllllllllllIIIllIlIlIIlIIIIl;
    }
    
    @Override
    public void resetTask() {
        if (this.theEntity.getNavigator().noPath() || this.theEntity.getDistanceSq(this.doorInfo.getDoorBlockPos()) < 16.0) {
            this.doorList.add(this.doorInfo);
        }
    }
    
    public EntityAIMoveThroughVillage(final EntityCreature lllllllllllllllIIIllIlIlIIllIllI, final double lllllllllllllllIIIllIlIlIIllIlIl, final boolean lllllllllllllllIIIllIlIlIIllIlII) {
        this.doorList = (List<VillageDoorInfo>)Lists.newArrayList();
        this.theEntity = lllllllllllllllIIIllIlIlIIllIllI;
        this.movementSpeed = lllllllllllllllIIIllIlIlIIllIlIl;
        this.isNocturnal = lllllllllllllllIIIllIlIlIIllIlII;
        this.setMutexBits(1);
        if (!(lllllllllllllllIIIllIlIlIIllIllI.getNavigator() instanceof PathNavigateGround)) {
            throw new IllegalArgumentException("Unsupported mob for MoveThroughVillageGoal");
        }
    }
    
    private boolean doesDoorListContain(final VillageDoorInfo lllllllllllllllIIIllIlIIllllllll) {
        for (final VillageDoorInfo lllllllllllllllIIIllIlIIlllllllI : this.doorList) {
            if (lllllllllllllllIIIllIlIIllllllll.getDoorBlockPos().equals(lllllllllllllllIIIllIlIIlllllllI.getDoorBlockPos())) {
                return true;
            }
        }
        return false;
    }
    
    private VillageDoorInfo findNearestDoor(final Village lllllllllllllllIIIllIlIlIIIlIIII) {
        VillageDoorInfo lllllllllllllllIIIllIlIlIIIIllll = null;
        int lllllllllllllllIIIllIlIlIIIIlllI = Integer.MAX_VALUE;
        for (final VillageDoorInfo lllllllllllllllIIIllIlIlIIIIllIl : lllllllllllllllIIIllIlIlIIIlIIII.getVillageDoorInfoList()) {
            final int lllllllllllllllIIIllIlIlIIIIllII = lllllllllllllllIIIllIlIlIIIIllIl.getDistanceSquared(MathHelper.floor(this.theEntity.posX), MathHelper.floor(this.theEntity.posY), MathHelper.floor(this.theEntity.posZ));
            if (lllllllllllllllIIIllIlIlIIIIllII < lllllllllllllllIIIllIlIlIIIIlllI && !this.doesDoorListContain(lllllllllllllllIIIllIlIlIIIIllIl)) {
                lllllllllllllllIIIllIlIlIIIIllll = lllllllllllllllIIIllIlIlIIIIllIl;
                lllllllllllllllIIIllIlIlIIIIlllI = lllllllllllllllIIIllIlIlIIIIllII;
            }
        }
        return lllllllllllllllIIIllIlIlIIIIllll;
    }
    
    @Override
    public boolean shouldExecute() {
        this.resizeDoorList();
        if (this.isNocturnal && this.theEntity.world.isDaytime()) {
            return false;
        }
        final Village lllllllllllllllIIIllIlIlIIlIllIl = this.theEntity.world.getVillageCollection().getNearestVillage(new BlockPos(this.theEntity), 0);
        if (lllllllllllllllIIIllIlIlIIlIllIl == null) {
            return false;
        }
        this.doorInfo = this.findNearestDoor(lllllllllllllllIIIllIlIlIIlIllIl);
        if (this.doorInfo == null) {
            return false;
        }
        final PathNavigateGround lllllllllllllllIIIllIlIlIIlIllII = (PathNavigateGround)this.theEntity.getNavigator();
        final boolean lllllllllllllllIIIllIlIlIIlIlIll = lllllllllllllllIIIllIlIlIIlIllII.getEnterDoors();
        lllllllllllllllIIIllIlIlIIlIllII.setBreakDoors(false);
        this.entityPathNavigate = lllllllllllllllIIIllIlIlIIlIllII.getPathToPos(this.doorInfo.getDoorBlockPos());
        lllllllllllllllIIIllIlIlIIlIllII.setBreakDoors(lllllllllllllllIIIllIlIlIIlIlIll);
        if (this.entityPathNavigate != null) {
            return true;
        }
        final Vec3d lllllllllllllllIIIllIlIlIIlIlIlI = RandomPositionGenerator.findRandomTargetBlockTowards(this.theEntity, 10, 7, new Vec3d(this.doorInfo.getDoorBlockPos().getX(), this.doorInfo.getDoorBlockPos().getY(), this.doorInfo.getDoorBlockPos().getZ()));
        if (lllllllllllllllIIIllIlIlIIlIlIlI == null) {
            return false;
        }
        lllllllllllllllIIIllIlIlIIlIllII.setBreakDoors(false);
        this.entityPathNavigate = this.theEntity.getNavigator().getPathToXYZ(lllllllllllllllIIIllIlIlIIlIlIlI.xCoord, lllllllllllllllIIIllIlIlIIlIlIlI.yCoord, lllllllllllllllIIIllIlIlIIlIlIlI.zCoord);
        lllllllllllllllIIIllIlIlIIlIllII.setBreakDoors(lllllllllllllllIIIllIlIlIIlIlIll);
        return this.entityPathNavigate != null;
    }
}
