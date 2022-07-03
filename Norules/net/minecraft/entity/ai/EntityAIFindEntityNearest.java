package net.minecraft.entity.ai;

import com.google.common.base.*;
import net.minecraft.entity.player.*;
import org.apache.logging.log4j.*;
import java.util.*;
import javax.annotation.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;

public class EntityAIFindEntityNearest extends EntityAIBase
{
    private final /* synthetic */ EntityLiving mob;
    private final /* synthetic */ EntityAINearestAttackableTarget.Sorter sorter;
    private final /* synthetic */ Predicate<EntityLivingBase> predicate;
    private final /* synthetic */ Class<? extends EntityLivingBase> classToCheck;
    private /* synthetic */ EntityLivingBase target;
    private static final /* synthetic */ Logger LOGGER;
    
    @Override
    public boolean continueExecuting() {
        final EntityLivingBase llllllllllllllIlIlIllIlIlIIIllll = this.mob.getAttackTarget();
        if (llllllllllllllIlIlIllIlIlIIIllll == null) {
            return false;
        }
        if (!llllllllllllllIlIlIllIlIlIIIllll.isEntityAlive()) {
            return false;
        }
        final double llllllllllllllIlIlIllIlIlIIIlllI = this.getFollowRange();
        return this.mob.getDistanceSqToEntity(llllllllllllllIlIlIllIlIlIIIllll) <= llllllllllllllIlIlIllIlIlIIIlllI * llllllllllllllIlIlIllIlIlIIIlllI && (!(llllllllllllllIlIlIllIlIlIIIllll instanceof EntityPlayerMP) || !((EntityPlayerMP)llllllllllllllIlIlIllIlIlIIIllll).interactionManager.isCreative());
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    @Override
    public boolean shouldExecute() {
        final double llllllllllllllIlIlIllIlIlIIllIII = this.getFollowRange();
        final List<EntityLivingBase> llllllllllllllIlIlIllIlIlIIlIlll = this.mob.world.getEntitiesWithinAABB(this.classToCheck, this.mob.getEntityBoundingBox().expand(llllllllllllllIlIlIllIlIlIIllIII, 4.0, llllllllllllllIlIlIllIlIlIIllIII), (com.google.common.base.Predicate<? super EntityLivingBase>)this.predicate);
        Collections.sort(llllllllllllllIlIlIllIlIlIIlIlll, this.sorter);
        if (llllllllllllllIlIlIllIlIlIIlIlll.isEmpty()) {
            return false;
        }
        this.target = llllllllllllllIlIlIllIlIlIIlIlll.get(0);
        return true;
    }
    
    @Override
    public void resetTask() {
        this.mob.setAttackTarget(null);
        super.startExecuting();
    }
    
    public EntityAIFindEntityNearest(final EntityLiving llllllllllllllIlIlIllIlIlIIllllI, final Class<? extends EntityLivingBase> llllllllllllllIlIlIllIlIlIIlllIl) {
        this.mob = llllllllllllllIlIlIllIlIlIIllllI;
        this.classToCheck = llllllllllllllIlIlIllIlIlIIlllIl;
        if (llllllllllllllIlIlIllIlIlIIllllI instanceof EntityCreature) {
            EntityAIFindEntityNearest.LOGGER.warn("Use NearestAttackableTargetGoal.class for PathfinerMob mobs!");
        }
        this.predicate = (Predicate<EntityLivingBase>)new Predicate<EntityLivingBase>() {
            public boolean apply(@Nullable final EntityLivingBase llllllllllllllIlIlIlllllllIllllI) {
                double llllllllllllllIlIlIlllllllIlllIl = EntityAIFindEntityNearest.this.getFollowRange();
                if (llllllllllllllIlIlIlllllllIllllI.isSneaking()) {
                    llllllllllllllIlIlIlllllllIlllIl *= 0.800000011920929;
                }
                return !llllllllllllllIlIlIlllllllIllllI.isInvisible() && llllllllllllllIlIlIlllllllIllllI.getDistanceToEntity(EntityAIFindEntityNearest.this.mob) <= llllllllllllllIlIlIlllllllIlllIl && EntityAITarget.isSuitableTarget(EntityAIFindEntityNearest.this.mob, llllllllllllllIlIlIlllllllIllllI, false, true);
            }
        };
        this.sorter = new EntityAINearestAttackableTarget.Sorter(llllllllllllllIlIlIllIlIlIIllllI);
    }
    
    protected double getFollowRange() {
        final IAttributeInstance llllllllllllllIlIlIllIlIlIIIIIIl = this.mob.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE);
        return (llllllllllllllIlIlIllIlIlIIIIIIl == null) ? 16.0 : llllllllllllllIlIlIllIlIlIIIIIIl.getAttributeValue();
    }
    
    @Override
    public void startExecuting() {
        this.mob.setAttackTarget(this.target);
        super.startExecuting();
    }
}
