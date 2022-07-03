package net.minecraft.entity.ai;

import net.minecraft.entity.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import java.util.*;
import javax.annotation.*;
import net.minecraft.inventory.*;

public class EntityAIFleeSun extends EntityAIBase
{
    private /* synthetic */ double shelterZ;
    private final /* synthetic */ EntityCreature theCreature;
    private final /* synthetic */ World theWorld;
    private final /* synthetic */ double movementSpeed;
    private /* synthetic */ double shelterY;
    private /* synthetic */ double shelterX;
    
    @Override
    public void startExecuting() {
        this.theCreature.getNavigator().tryMoveToXYZ(this.shelterX, this.shelterY, this.shelterZ, this.movementSpeed);
    }
    
    @Nullable
    private Vec3d findPossibleShelter() {
        final Random lllllllllllllIlIIIIlIIIIlIlIlllI = this.theCreature.getRNG();
        final BlockPos lllllllllllllIlIIIIlIIIIlIlIllIl = new BlockPos(this.theCreature.posX, this.theCreature.getEntityBoundingBox().minY, this.theCreature.posZ);
        for (int lllllllllllllIlIIIIlIIIIlIlIllII = 0; lllllllllllllIlIIIIlIIIIlIlIllII < 10; ++lllllllllllllIlIIIIlIIIIlIlIllII) {
            final BlockPos lllllllllllllIlIIIIlIIIIlIlIlIll = lllllllllllllIlIIIIlIIIIlIlIllIl.add(lllllllllllllIlIIIIlIIIIlIlIlllI.nextInt(20) - 10, lllllllllllllIlIIIIlIIIIlIlIlllI.nextInt(6) - 3, lllllllllllllIlIIIIlIIIIlIlIlllI.nextInt(20) - 10);
            if (!this.theWorld.canSeeSky(lllllllllllllIlIIIIlIIIIlIlIlIll) && this.theCreature.getBlockPathWeight(lllllllllllllIlIIIIlIIIIlIlIlIll) < 0.0f) {
                return new Vec3d(lllllllllllllIlIIIIlIIIIlIlIlIll.getX(), lllllllllllllIlIIIIlIIIIlIlIlIll.getY(), lllllllllllllIlIIIIlIIIIlIlIlIll.getZ());
            }
        }
        return null;
    }
    
    public EntityAIFleeSun(final EntityCreature lllllllllllllIlIIIIlIIIIllIIIIlI, final double lllllllllllllIlIIIIlIIIIllIIIlII) {
        this.theCreature = lllllllllllllIlIIIIlIIIIllIIIIlI;
        this.movementSpeed = lllllllllllllIlIIIIlIIIIllIIIlII;
        this.theWorld = lllllllllllllIlIIIIlIIIIllIIIIlI.world;
        this.setMutexBits(1);
    }
    
    @Override
    public boolean continueExecuting() {
        return !this.theCreature.getNavigator().noPath();
    }
    
    @Override
    public boolean shouldExecute() {
        if (!this.theWorld.isDaytime()) {
            return false;
        }
        if (!this.theCreature.isBurning()) {
            return false;
        }
        if (!this.theWorld.canSeeSky(new BlockPos(this.theCreature.posX, this.theCreature.getEntityBoundingBox().minY, this.theCreature.posZ))) {
            return false;
        }
        if (!this.theCreature.getItemStackFromSlot(EntityEquipmentSlot.HEAD).func_190926_b()) {
            return false;
        }
        final Vec3d lllllllllllllIlIIIIlIIIIlIllllIl = this.findPossibleShelter();
        if (lllllllllllllIlIIIIlIIIIlIllllIl == null) {
            return false;
        }
        this.shelterX = lllllllllllllIlIIIIlIIIIlIllllIl.xCoord;
        this.shelterY = lllllllllllllIlIIIIlIIIIlIllllIl.yCoord;
        this.shelterZ = lllllllllllllIlIIIIlIIIIlIllllIl.zCoord;
        return true;
    }
}
