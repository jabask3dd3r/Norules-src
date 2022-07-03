package net.minecraft.entity.ai;

import net.minecraft.util.math.*;
import net.minecraft.entity.*;
import net.minecraft.entity.passive.*;

public class EntityAIHurtByTarget extends EntityAITarget
{
    private final /* synthetic */ Class<?>[] targetClasses;
    private final /* synthetic */ boolean entityCallsForHelp;
    private /* synthetic */ int revengeTimerOld;
    
    public EntityAIHurtByTarget(final EntityCreature lllllllllllllIIIIlIlllIlllIllIlI, final boolean lllllllllllllIIIIlIlllIlllIlllIl, final Class<?>... lllllllllllllIIIIlIlllIlllIllIII) {
        super(lllllllllllllIIIIlIlllIlllIllIlI, true);
        this.entityCallsForHelp = lllllllllllllIIIIlIlllIlllIlllIl;
        this.targetClasses = lllllllllllllIIIIlIlllIlllIllIII;
        this.setMutexBits(1);
    }
    
    protected void setEntityAttackTarget(final EntityCreature lllllllllllllIIIIlIlllIllIlIllll, final EntityLivingBase lllllllllllllIIIIlIlllIllIllIIII) {
        lllllllllllllIIIIlIlllIllIlIllll.setAttackTarget(lllllllllllllIIIIlIlllIllIllIIII);
    }
    
    @Override
    public void startExecuting() {
        this.taskOwner.setAttackTarget(this.taskOwner.getAITarget());
        this.target = this.taskOwner.getAttackTarget();
        this.revengeTimerOld = this.taskOwner.getRevengeTimer();
        this.unseenMemoryTicks = 300;
        if (this.entityCallsForHelp) {
            this.alertOthers();
        }
        super.startExecuting();
    }
    
    @Override
    public boolean shouldExecute() {
        final int lllllllllllllIIIIlIlllIlllIlIIll = this.taskOwner.getRevengeTimer();
        final EntityLivingBase lllllllllllllIIIIlIlllIlllIlIIlI = this.taskOwner.getAITarget();
        return lllllllllllllIIIIlIlllIlllIlIIll != this.revengeTimerOld && lllllllllllllIIIIlIlllIlllIlIIlI != null && this.isSuitableTarget(lllllllllllllIIIIlIlllIlllIlIIlI, false);
    }
    
    protected void alertOthers() {
        final double lllllllllllllIIIIlIlllIlllIIIIIl = this.getTargetDistance();
        for (final EntityCreature lllllllllllllIIIIlIlllIlllIIIIII : this.taskOwner.world.getEntitiesWithinAABB((Class<? extends Entity>)this.taskOwner.getClass(), new AxisAlignedBB(this.taskOwner.posX, this.taskOwner.posY, this.taskOwner.posZ, this.taskOwner.posX + 1.0, this.taskOwner.posY + 1.0, this.taskOwner.posZ + 1.0).expand(lllllllllllllIIIIlIlllIlllIIIIIl, 10.0, lllllllllllllIIIIlIlllIlllIIIIIl))) {
            if (this.taskOwner != lllllllllllllIIIIlIlllIlllIIIIII && lllllllllllllIIIIlIlllIlllIIIIII.getAttackTarget() == null && (!(this.taskOwner instanceof EntityTameable) || ((EntityTameable)this.taskOwner).getOwner() == ((EntityTameable)lllllllllllllIIIIlIlllIlllIIIIII).getOwner()) && !lllllllllllllIIIIlIlllIlllIIIIII.isOnSameTeam(this.taskOwner.getAITarget())) {
                boolean lllllllllllllIIIIlIlllIllIllllll = false;
                final long lllllllllllllIIIIlIlllIllIllIlIl;
                final char lllllllllllllIIIIlIlllIllIllIllI = (char)((Class<?>[])(Object)(lllllllllllllIIIIlIlllIllIllIlIl = (long)(Object)this.targetClasses)).length;
                for (String lllllllllllllIIIIlIlllIllIllIlll = (String)0; lllllllllllllIIIIlIlllIllIllIlll < lllllllllllllIIIIlIlllIllIllIllI; ++lllllllllllllIIIIlIlllIllIllIlll) {
                    final Class<?> lllllllllllllIIIIlIlllIllIlllllI = lllllllllllllIIIIlIlllIllIllIlIl[lllllllllllllIIIIlIlllIllIllIlll];
                    if (lllllllllllllIIIIlIlllIlllIIIIII.getClass() == lllllllllllllIIIIlIlllIllIlllllI) {
                        lllllllllllllIIIIlIlllIllIllllll = true;
                        break;
                    }
                }
                if (lllllllllllllIIIIlIlllIllIllllll) {
                    continue;
                }
                this.setEntityAttackTarget(lllllllllllllIIIIlIlllIlllIIIIII, this.taskOwner.getAITarget());
            }
        }
    }
}
