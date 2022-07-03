package net.minecraft.entity.ai;

import net.minecraft.entity.player.*;
import net.minecraft.scoreboard.*;
import javax.annotation.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.util.math.*;
import net.minecraft.pathfinding.*;

public abstract class EntityAITarget extends EntityAIBase
{
    private /* synthetic */ int targetSearchStatus;
    private /* synthetic */ int targetSearchDelay;
    protected /* synthetic */ boolean shouldCheckSight;
    protected final /* synthetic */ EntityCreature taskOwner;
    private final /* synthetic */ boolean nearbyOnly;
    protected /* synthetic */ int unseenMemoryTicks;
    private /* synthetic */ int targetUnseenTicks;
    protected /* synthetic */ EntityLivingBase target;
    
    @Override
    public boolean continueExecuting() {
        EntityLivingBase lllllllllllllIIlIIIllIlllllllIlI = this.taskOwner.getAttackTarget();
        if (lllllllllllllIIlIIIllIlllllllIlI == null) {
            lllllllllllllIIlIIIllIlllllllIlI = this.target;
        }
        if (lllllllllllllIIlIIIllIlllllllIlI == null) {
            return false;
        }
        if (!lllllllllllllIIlIIIllIlllllllIlI.isEntityAlive()) {
            return false;
        }
        final Team lllllllllllllIIlIIIllIlllllllIIl = this.taskOwner.getTeam();
        final Team lllllllllllllIIlIIIllIlllllllIII = lllllllllllllIIlIIIllIlllllllIlI.getTeam();
        if (lllllllllllllIIlIIIllIlllllllIIl != null && lllllllllllllIIlIIIllIlllllllIII == lllllllllllllIIlIIIllIlllllllIIl) {
            return false;
        }
        final double lllllllllllllIIlIIIllIllllllIlll = this.getTargetDistance();
        if (this.taskOwner.getDistanceSqToEntity(lllllllllllllIIlIIIllIlllllllIlI) > lllllllllllllIIlIIIllIllllllIlll * lllllllllllllIIlIIIllIllllllIlll) {
            return false;
        }
        if (this.shouldCheckSight) {
            if (this.taskOwner.getEntitySenses().canSee(lllllllllllllIIlIIIllIlllllllIlI)) {
                this.targetUnseenTicks = 0;
            }
            else if (++this.targetUnseenTicks > this.unseenMemoryTicks) {
                return false;
            }
        }
        if (lllllllllllllIIlIIIllIlllllllIlI instanceof EntityPlayer && ((EntityPlayer)lllllllllllllIIlIIIllIlllllllIlI).capabilities.disableDamage) {
            return false;
        }
        this.taskOwner.setAttackTarget(lllllllllllllIIlIIIllIlllllllIlI);
        return true;
    }
    
    public static boolean isSuitableTarget(final EntityLiving lllllllllllllIIlIIIllIlllllIIIIl, @Nullable final EntityLivingBase lllllllllllllIIlIIIllIllllIlllII, final boolean lllllllllllllIIlIIIllIllllIlllll, final boolean lllllllllllllIIlIIIllIllllIllllI) {
        if (lllllllllllllIIlIIIllIllllIlllII == null) {
            return false;
        }
        if (lllllllllllllIIlIIIllIllllIlllII == lllllllllllllIIlIIIllIlllllIIIIl) {
            return false;
        }
        if (!lllllllllllllIIlIIIllIllllIlllII.isEntityAlive()) {
            return false;
        }
        if (!lllllllllllllIIlIIIllIlllllIIIIl.canAttackClass(lllllllllllllIIlIIIllIllllIlllII.getClass())) {
            return false;
        }
        if (lllllllllllllIIlIIIllIlllllIIIIl.isOnSameTeam(lllllllllllllIIlIIIllIllllIlllII)) {
            return false;
        }
        if (lllllllllllllIIlIIIllIlllllIIIIl instanceof IEntityOwnable && ((IEntityOwnable)lllllllllllllIIlIIIllIlllllIIIIl).getOwnerId() != null) {
            if (lllllllllllllIIlIIIllIllllIlllII instanceof IEntityOwnable && ((IEntityOwnable)lllllllllllllIIlIIIllIlllllIIIIl).getOwnerId().equals(((IEntityOwnable)lllllllllllllIIlIIIllIllllIlllII).getOwnerId())) {
                return false;
            }
            if (lllllllllllllIIlIIIllIllllIlllII == ((IEntityOwnable)lllllllllllllIIlIIIllIlllllIIIIl).getOwner()) {
                return false;
            }
        }
        else if (lllllllllllllIIlIIIllIllllIlllII instanceof EntityPlayer && !lllllllllllllIIlIIIllIllllIlllll && ((EntityPlayer)lllllllllllllIIlIIIllIllllIlllII).capabilities.disableDamage) {
            return false;
        }
        return !lllllllllllllIIlIIIllIllllIllllI || lllllllllllllIIlIIIllIlllllIIIIl.getEntitySenses().canSee(lllllllllllllIIlIIIllIllllIlllII);
    }
    
    public EntityAITarget func_190882_b(final int lllllllllllllIIlIIIllIlllIlllIll) {
        this.unseenMemoryTicks = lllllllllllllIIlIIIllIlllIlllIll;
        return this;
    }
    
    public EntityAITarget(final EntityCreature lllllllllllllIIlIIIlllIIIIIlIIIl, final boolean lllllllllllllIIlIIIlllIIIIIlIIII) {
        this(lllllllllllllIIlIIIlllIIIIIlIIIl, lllllllllllllIIlIIIlllIIIIIlIIII, false);
    }
    
    protected boolean isSuitableTarget(@Nullable final EntityLivingBase lllllllllllllIIlIIIllIllllIlIlIl, final boolean lllllllllllllIIlIIIllIllllIlIlII) {
        if (!isSuitableTarget(this.taskOwner, lllllllllllllIIlIIIllIllllIlIlIl, lllllllllllllIIlIIIllIllllIlIlII, this.shouldCheckSight)) {
            return false;
        }
        if (!this.taskOwner.isWithinHomeDistanceFromPosition(new BlockPos(lllllllllllllIIlIIIllIllllIlIlIl))) {
            return false;
        }
        if (this.nearbyOnly) {
            if (--this.targetSearchDelay <= 0) {
                this.targetSearchStatus = 0;
            }
            if (this.targetSearchStatus == 0) {
                this.targetSearchStatus = (this.canEasilyReach(lllllllllllllIIlIIIllIllllIlIlIl) ? 1 : 2);
            }
            if (this.targetSearchStatus == 2) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public void resetTask() {
        this.taskOwner.setAttackTarget(null);
        this.target = null;
    }
    
    protected double getTargetDistance() {
        final IAttributeInstance lllllllllllllIIlIIIllIlllllIlllI = this.taskOwner.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE);
        return (lllllllllllllIIlIIIllIlllllIlllI == null) ? 16.0 : lllllllllllllIIlIIIllIlllllIlllI.getAttributeValue();
    }
    
    private boolean canEasilyReach(final EntityLivingBase lllllllllllllIIlIIIllIllllIIIIll) {
        this.targetSearchDelay = 10 + this.taskOwner.getRNG().nextInt(5);
        final Path lllllllllllllIIlIIIllIllllIIlIII = this.taskOwner.getNavigator().getPathToEntityLiving(lllllllllllllIIlIIIllIllllIIIIll);
        if (lllllllllllllIIlIIIllIllllIIlIII == null) {
            return false;
        }
        final PathPoint lllllllllllllIIlIIIllIllllIIIlll = lllllllllllllIIlIIIllIllllIIlIII.getFinalPathPoint();
        if (lllllllllllllIIlIIIllIllllIIIlll == null) {
            return false;
        }
        final int lllllllllllllIIlIIIllIllllIIIllI = lllllllllllllIIlIIIllIllllIIIlll.xCoord - MathHelper.floor(lllllllllllllIIlIIIllIllllIIIIll.posX);
        final int lllllllllllllIIlIIIllIllllIIIlIl = lllllllllllllIIlIIIllIllllIIIlll.zCoord - MathHelper.floor(lllllllllllllIIlIIIllIllllIIIIll.posZ);
        return lllllllllllllIIlIIIllIllllIIIllI * lllllllllllllIIlIIIllIllllIIIllI + lllllllllllllIIlIIIllIllllIIIlIl * lllllllllllllIIlIIIllIllllIIIlIl <= 2.25;
    }
    
    public EntityAITarget(final EntityCreature lllllllllllllIIlIIIlllIIIIIIIlll, final boolean lllllllllllllIIlIIIlllIIIIIIIIlI, final boolean lllllllllllllIIlIIIlllIIIIIIIlIl) {
        this.unseenMemoryTicks = 60;
        this.taskOwner = lllllllllllllIIlIIIlllIIIIIIIlll;
        this.shouldCheckSight = lllllllllllllIIlIIIlllIIIIIIIIlI;
        this.nearbyOnly = lllllllllllllIIlIIIlllIIIIIIIlIl;
    }
    
    @Override
    public void startExecuting() {
        this.targetSearchStatus = 0;
        this.targetSearchDelay = 0;
        this.targetUnseenTicks = 0;
    }
}
