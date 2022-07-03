package net.minecraft.entity.ai;

import java.util.*;
import net.minecraft.entity.player.*;
import com.google.common.collect.*;
import net.minecraft.pathfinding.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;

public class EntityAITempt extends EntityAIBase
{
    private /* synthetic */ boolean isRunning;
    private final /* synthetic */ Set<Item> temptItem;
    private /* synthetic */ double targetX;
    private /* synthetic */ double targetY;
    private /* synthetic */ double yaw;
    private final /* synthetic */ EntityCreature temptedEntity;
    private /* synthetic */ int delayTemptCounter;
    private final /* synthetic */ boolean scaredByPlayerMovement;
    private /* synthetic */ EntityPlayer temptingPlayer;
    private /* synthetic */ double targetZ;
    private final /* synthetic */ double speed;
    private /* synthetic */ double pitch;
    
    public EntityAITempt(final EntityCreature lllllllllllllllIlIlllIlIIIIIIllI, final double lllllllllllllllIlIlllIlIIIIIlIlI, final Item lllllllllllllllIlIlllIlIIIIIlIIl, final boolean lllllllllllllllIlIlllIlIIIIIIIll) {
        this(lllllllllllllllIlIlllIlIIIIIIllI, lllllllllllllllIlIlllIlIIIIIlIlI, lllllllllllllllIlIlllIlIIIIIIIll, Sets.newHashSet((Object[])new Item[] { lllllllllllllllIlIlllIlIIIIIlIIl }));
    }
    
    public EntityAITempt(final EntityCreature lllllllllllllllIlIlllIIlllllllII, final double lllllllllllllllIlIlllIIlllllIllI, final boolean lllllllllllllllIlIlllIIlllllIlIl, final Set<Item> lllllllllllllllIlIlllIIllllllIIl) {
        this.temptedEntity = lllllllllllllllIlIlllIIlllllllII;
        this.speed = lllllllllllllllIlIlllIIlllllIllI;
        this.temptItem = lllllllllllllllIlIlllIIllllllIIl;
        this.scaredByPlayerMovement = lllllllllllllllIlIlllIIlllllIlIl;
        this.setMutexBits(3);
        if (!(lllllllllllllllIlIlllIIlllllllII.getNavigator() instanceof PathNavigateGround)) {
            throw new IllegalArgumentException("Unsupported mob type for TemptGoal");
        }
    }
    
    @Override
    public void startExecuting() {
        this.targetX = this.temptingPlayer.posX;
        this.targetY = this.temptingPlayer.posY;
        this.targetZ = this.temptingPlayer.posZ;
        this.isRunning = true;
    }
    
    @Override
    public boolean shouldExecute() {
        if (this.delayTemptCounter > 0) {
            --this.delayTemptCounter;
            return false;
        }
        this.temptingPlayer = this.temptedEntity.world.getClosestPlayerToEntity(this.temptedEntity, 10.0);
        return this.temptingPlayer != null && (this.isTempting(this.temptingPlayer.getHeldItemMainhand()) || this.isTempting(this.temptingPlayer.getHeldItemOffhand()));
    }
    
    protected boolean isTempting(final ItemStack lllllllllllllllIlIlllIIllllIlIll) {
        return this.temptItem.contains(lllllllllllllllIlIlllIIllllIlIll.getItem());
    }
    
    @Override
    public void resetTask() {
        this.temptingPlayer = null;
        this.temptedEntity.getNavigator().clearPathEntity();
        this.delayTemptCounter = 100;
        this.isRunning = false;
    }
    
    @Override
    public boolean continueExecuting() {
        if (this.scaredByPlayerMovement) {
            if (this.temptedEntity.getDistanceSqToEntity(this.temptingPlayer) < 36.0) {
                if (this.temptingPlayer.getDistanceSq(this.targetX, this.targetY, this.targetZ) > 0.010000000000000002) {
                    return false;
                }
                if (Math.abs(this.temptingPlayer.rotationPitch - this.pitch) > 5.0 || Math.abs(this.temptingPlayer.rotationYaw - this.yaw) > 5.0) {
                    return false;
                }
            }
            else {
                this.targetX = this.temptingPlayer.posX;
                this.targetY = this.temptingPlayer.posY;
                this.targetZ = this.temptingPlayer.posZ;
            }
            this.pitch = this.temptingPlayer.rotationPitch;
            this.yaw = this.temptingPlayer.rotationYaw;
        }
        return this.shouldExecute();
    }
    
    public boolean isRunning() {
        return this.isRunning;
    }
    
    @Override
    public void updateTask() {
        this.temptedEntity.getLookHelper().setLookPositionWithEntity(this.temptingPlayer, (float)(this.temptedEntity.getHorizontalFaceSpeed() + 20), (float)this.temptedEntity.getVerticalFaceSpeed());
        if (this.temptedEntity.getDistanceSqToEntity(this.temptingPlayer) < 6.25) {
            this.temptedEntity.getNavigator().clearPathEntity();
        }
        else {
            this.temptedEntity.getNavigator().tryMoveToEntityLiving(this.temptingPlayer, this.speed);
        }
    }
}
