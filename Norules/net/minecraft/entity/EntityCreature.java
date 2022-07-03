package net.minecraft.entity;

import net.minecraft.entity.ai.attributes.*;
import java.util.*;
import net.minecraft.entity.passive.*;
import net.minecraft.world.*;
import net.minecraft.pathfinding.*;
import net.minecraft.util.math.*;

public abstract class EntityCreature extends EntityLiving
{
    public static final /* synthetic */ UUID FLEEING_SPEED_MODIFIER_UUID;
    private /* synthetic */ float maximumHomeDistance;
    private final /* synthetic */ float restoreWaterCost;
    private /* synthetic */ BlockPos homePosition;
    
    public float getBlockPathWeight(final BlockPos lllllllllllllIIlIIlllIIIIIlIllII) {
        return 0.0f;
    }
    
    public void setHomePosAndDistance(final BlockPos lllllllllllllIIlIIlllIIIIIIlIlIl, final int lllllllllllllIIlIIlllIIIIIIlIlII) {
        this.homePosition = lllllllllllllIIlIIlllIIIIIIlIlIl;
        this.maximumHomeDistance = (float)lllllllllllllIIlIIlllIIIIIIlIlII;
    }
    
    public boolean isWithinHomeDistanceCurrentPosition() {
        return this.isWithinHomeDistanceFromPosition(new BlockPos(this));
    }
    
    @Override
    public boolean getCanSpawnHere() {
        return super.getCanSpawnHere() && this.getBlockPathWeight(new BlockPos(this.posX, this.getEntityBoundingBox().minY, this.posZ)) >= 0.0f;
    }
    
    protected double func_190634_dg() {
        return 1.0;
    }
    
    public BlockPos getHomePosition() {
        return this.homePosition;
    }
    
    @Override
    protected void updateLeashedState() {
        super.updateLeashedState();
        if (this.getLeashed() && this.getLeashedToEntity() != null && this.getLeashedToEntity().world == this.world) {
            final Entity lllllllllllllIIlIIllIlllllllllll = this.getLeashedToEntity();
            this.setHomePosAndDistance(new BlockPos((int)lllllllllllllIIlIIllIlllllllllll.posX, (int)lllllllllllllIIlIIllIlllllllllll.posY, (int)lllllllllllllIIlIIllIlllllllllll.posZ), 5);
            final float lllllllllllllIIlIIllIllllllllllI = this.getDistanceToEntity(lllllllllllllIIlIIllIlllllllllll);
            if (this instanceof EntityTameable && ((EntityTameable)this).isSitting()) {
                if (lllllllllllllIIlIIllIllllllllllI > 10.0f) {
                    this.clearLeashed(true, true);
                }
                return;
            }
            this.onLeashDistance(lllllllllllllIIlIIllIllllllllllI);
            if (lllllllllllllIIlIIllIllllllllllI > 10.0f) {
                this.clearLeashed(true, true);
                this.tasks.disableControlFlag(1);
            }
            else if (lllllllllllllIIlIIllIllllllllllI > 6.0f) {
                final double lllllllllllllIIlIIllIlllllllllIl = (lllllllllllllIIlIIllIlllllllllll.posX - this.posX) / lllllllllllllIIlIIllIllllllllllI;
                final double lllllllllllllIIlIIllIlllllllllII = (lllllllllllllIIlIIllIlllllllllll.posY - this.posY) / lllllllllllllIIlIIllIllllllllllI;
                final double lllllllllllllIIlIIllIllllllllIll = (lllllllllllllIIlIIllIlllllllllll.posZ - this.posZ) / lllllllllllllIIlIIllIllllllllllI;
                this.motionX += lllllllllllllIIlIIllIlllllllllIl * Math.abs(lllllllllllllIIlIIllIlllllllllIl) * 0.4;
                this.motionY += lllllllllllllIIlIIllIlllllllllII * Math.abs(lllllllllllllIIlIIllIlllllllllII) * 0.4;
                this.motionZ += lllllllllllllIIlIIllIllllllllIll * Math.abs(lllllllllllllIIlIIllIllllllllIll) * 0.4;
            }
            else {
                this.tasks.enableControlFlag(1);
                final float lllllllllllllIIlIIllIllllllllIlI = 2.0f;
                final Vec3d lllllllllllllIIlIIllIllllllllIIl = new Vec3d(lllllllllllllIIlIIllIlllllllllll.posX - this.posX, lllllllllllllIIlIIllIlllllllllll.posY - this.posY, lllllllllllllIIlIIllIlllllllllll.posZ - this.posZ).normalize().scale(Math.max(lllllllllllllIIlIIllIllllllllllI - 2.0f, 0.0f));
                this.getNavigator().tryMoveToXYZ(this.posX + lllllllllllllIIlIIllIllllllllIIl.xCoord, this.posY + lllllllllllllIIlIIllIllllllllIIl.yCoord, this.posZ + lllllllllllllIIlIIllIllllllllIIl.zCoord, this.func_190634_dg());
            }
        }
    }
    
    static {
        FLEEING_SPEED_MODIFIER_UUID = UUID.fromString("E199AD21-BA8A-4C53-8D13-6182D5C69D3A");
        FLEEING_SPEED_MODIFIER = new AttributeModifier(EntityCreature.FLEEING_SPEED_MODIFIER_UUID, "Fleeing speed bonus", 2.0, 2).setSaved(false);
    }
    
    public EntityCreature(final World lllllllllllllIIlIIlllIIIIIlIlllI) {
        super(lllllllllllllIIlIIlllIIIIIlIlllI);
        this.homePosition = BlockPos.ORIGIN;
        this.maximumHomeDistance = -1.0f;
        this.restoreWaterCost = PathNodeType.WATER.getPriority();
    }
    
    public boolean hasPath() {
        return !this.navigator.noPath();
    }
    
    public float getMaximumHomeDistance() {
        return this.maximumHomeDistance;
    }
    
    public boolean isWithinHomeDistanceFromPosition(final BlockPos lllllllllllllIIlIIlllIIIIIIlllIl) {
        return this.maximumHomeDistance == -1.0f || this.homePosition.distanceSq(lllllllllllllIIlIIlllIIIIIIlllIl) < this.maximumHomeDistance * this.maximumHomeDistance;
    }
    
    public boolean hasHome() {
        return this.maximumHomeDistance != -1.0f;
    }
    
    protected void onLeashDistance(final float lllllllllllllIIlIIllIllllllIllll) {
    }
    
    public void detachHome() {
        this.maximumHomeDistance = -1.0f;
    }
}
