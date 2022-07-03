package net.minecraft.entity.ai;

import net.minecraft.util.math.*;
import net.minecraft.entity.*;
import net.minecraft.village.*;

public class EntityAIMoveIndoors extends EntityAIBase
{
    private /* synthetic */ int insidePosX;
    private /* synthetic */ VillageDoorInfo doorInfo;
    private final /* synthetic */ EntityCreature entityObj;
    private /* synthetic */ int insidePosZ;
    
    @Override
    public void startExecuting() {
        this.insidePosX = -1;
        final BlockPos lllllllllllllIIlIlIlIlIllIlIlllI = this.doorInfo.getInsideBlockPos();
        final int lllllllllllllIIlIlIlIlIllIlIllIl = lllllllllllllIIlIlIlIlIllIlIlllI.getX();
        final int lllllllllllllIIlIlIlIlIllIlIllII = lllllllllllllIIlIlIlIlIllIlIlllI.getY();
        final int lllllllllllllIIlIlIlIlIllIlIlIll = lllllllllllllIIlIlIlIlIllIlIlllI.getZ();
        if (this.entityObj.getDistanceSq(lllllllllllllIIlIlIlIlIllIlIlllI) > 256.0) {
            final Vec3d lllllllllllllIIlIlIlIlIllIlIlIlI = RandomPositionGenerator.findRandomTargetBlockTowards(this.entityObj, 14, 3, new Vec3d(lllllllllllllIIlIlIlIlIllIlIllIl + 0.5, lllllllllllllIIlIlIlIlIllIlIllII, lllllllllllllIIlIlIlIlIllIlIlIll + 0.5));
            if (lllllllllllllIIlIlIlIlIllIlIlIlI != null) {
                this.entityObj.getNavigator().tryMoveToXYZ(lllllllllllllIIlIlIlIlIllIlIlIlI.xCoord, lllllllllllllIIlIlIlIlIllIlIlIlI.yCoord, lllllllllllllIIlIlIlIlIllIlIlIlI.zCoord, 1.0);
            }
        }
        else {
            this.entityObj.getNavigator().tryMoveToXYZ(lllllllllllllIIlIlIlIlIllIlIllIl + 0.5, lllllllllllllIIlIlIlIlIllIlIllII, lllllllllllllIIlIlIlIlIllIlIlIll + 0.5, 1.0);
        }
    }
    
    public EntityAIMoveIndoors(final EntityCreature lllllllllllllIIlIlIlIlIlllIIIIlI) {
        this.insidePosX = -1;
        this.insidePosZ = -1;
        this.entityObj = lllllllllllllIIlIlIlIlIlllIIIIlI;
        this.setMutexBits(1);
    }
    
    @Override
    public boolean continueExecuting() {
        return !this.entityObj.getNavigator().noPath();
    }
    
    @Override
    public void resetTask() {
        this.insidePosX = this.doorInfo.getInsideBlockPos().getX();
        this.insidePosZ = this.doorInfo.getInsideBlockPos().getZ();
        this.doorInfo = null;
    }
    
    @Override
    public boolean shouldExecute() {
        final BlockPos lllllllllllllIIlIlIlIlIllIllllIl = new BlockPos(this.entityObj);
        if ((this.entityObj.world.isDaytime() && (!this.entityObj.world.isRaining() || this.entityObj.world.getBiome(lllllllllllllIIlIlIlIlIllIllllIl).canRain())) || !this.entityObj.world.provider.func_191066_m()) {
            return false;
        }
        if (this.entityObj.getRNG().nextInt(50) != 0) {
            return false;
        }
        if (this.insidePosX != -1 && this.entityObj.getDistanceSq(this.insidePosX, this.entityObj.posY, this.insidePosZ) < 4.0) {
            return false;
        }
        final Village lllllllllllllIIlIlIlIlIllIllllII = this.entityObj.world.getVillageCollection().getNearestVillage(lllllllllllllIIlIlIlIlIllIllllIl, 14);
        if (lllllllllllllIIlIlIlIlIllIllllII == null) {
            return false;
        }
        this.doorInfo = lllllllllllllIIlIlIlIlIllIllllII.getDoorInfo(lllllllllllllIIlIlIlIlIllIllllIl);
        return this.doorInfo != null;
    }
}
