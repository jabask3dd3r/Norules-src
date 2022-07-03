package net.minecraft.entity.ai;

import com.google.common.base.*;
import net.minecraft.entity.player.*;
import net.minecraft.scoreboard.*;
import javax.annotation.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import java.util.*;
import org.apache.logging.log4j.*;

public class EntityAIFindEntityNearestPlayer extends EntityAIBase
{
    private static final /* synthetic */ Logger LOGGER;
    private final /* synthetic */ EntityAINearestAttackableTarget.Sorter sorter;
    private /* synthetic */ EntityLivingBase entityTarget;
    private final /* synthetic */ EntityLiving entityLiving;
    private final /* synthetic */ Predicate<Entity> predicate;
    
    @Override
    public boolean continueExecuting() {
        final EntityLivingBase llllIlllIIIllIl = this.entityLiving.getAttackTarget();
        if (llllIlllIIIllIl == null) {
            return false;
        }
        if (!llllIlllIIIllIl.isEntityAlive()) {
            return false;
        }
        if (llllIlllIIIllIl instanceof EntityPlayer && ((EntityPlayer)llllIlllIIIllIl).capabilities.disableDamage) {
            return false;
        }
        final Team llllIlllIIIllII = this.entityLiving.getTeam();
        final Team llllIlllIIIlIll = llllIlllIIIllIl.getTeam();
        if (llllIlllIIIllII != null && llllIlllIIIlIll == llllIlllIIIllII) {
            return false;
        }
        final double llllIlllIIIlIlI = this.maxTargetRange();
        return this.entityLiving.getDistanceSqToEntity(llllIlllIIIllIl) <= llllIlllIIIlIlI * llllIlllIIIlIlI && (!(llllIlllIIIllIl instanceof EntityPlayerMP) || !((EntityPlayerMP)llllIlllIIIllIl).interactionManager.isCreative());
    }
    
    public EntityAIFindEntityNearestPlayer(final EntityLiving llllIlllIIlllll) {
        this.entityLiving = llllIlllIIlllll;
        if (llllIlllIIlllll instanceof EntityCreature) {
            EntityAIFindEntityNearestPlayer.LOGGER.warn("Use NearestAttackableTargetGoal.class for PathfinerMob mobs!");
        }
        this.predicate = (Predicate<Entity>)new Predicate<Entity>() {
            public boolean apply(@Nullable final Entity lllllllllllllIIIIIllIIlIIlllIlIl) {
                if (!(lllllllllllllIIIIIllIIlIIlllIlIl instanceof EntityPlayer)) {
                    return false;
                }
                if (((EntityPlayer)lllllllllllllIIIIIllIIlIIlllIlIl).capabilities.disableDamage) {
                    return false;
                }
                double lllllllllllllIIIIIllIIlIIlllIlII = EntityAIFindEntityNearestPlayer.this.maxTargetRange();
                if (lllllllllllllIIIIIllIIlIIlllIlIl.isSneaking()) {
                    lllllllllllllIIIIIllIIlIIlllIlII *= 0.800000011920929;
                }
                if (lllllllllllllIIIIIllIIlIIlllIlIl.isInvisible()) {
                    float lllllllllllllIIIIIllIIlIIlllIIll = ((EntityPlayer)lllllllllllllIIIIIllIIlIIlllIlIl).getArmorVisibility();
                    if (lllllllllllllIIIIIllIIlIIlllIIll < 0.1f) {
                        lllllllllllllIIIIIllIIlIIlllIIll = 0.1f;
                    }
                    lllllllllllllIIIIIllIIlIIlllIlII *= 0.7f * lllllllllllllIIIIIllIIlIIlllIIll;
                }
                return lllllllllllllIIIIIllIIlIIlllIlIl.getDistanceToEntity(EntityAIFindEntityNearestPlayer.this.entityLiving) <= lllllllllllllIIIIIllIIlIIlllIlII && EntityAITarget.isSuitableTarget(EntityAIFindEntityNearestPlayer.this.entityLiving, (EntityLivingBase)lllllllllllllIIIIIllIIlIIlllIlIl, false, true);
            }
        };
        this.sorter = new EntityAINearestAttackableTarget.Sorter(llllIlllIIlllll);
    }
    
    @Override
    public void resetTask() {
        this.entityLiving.setAttackTarget(null);
        super.startExecuting();
    }
    
    protected double maxTargetRange() {
        final IAttributeInstance llllIllIllllIll = this.entityLiving.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE);
        return (llllIllIllllIll == null) ? 16.0 : llllIllIllllIll.getAttributeValue();
    }
    
    @Override
    public void startExecuting() {
        this.entityLiving.setAttackTarget(this.entityTarget);
        super.startExecuting();
    }
    
    @Override
    public boolean shouldExecute() {
        final double llllIlllIIllIII = this.maxTargetRange();
        final List<EntityPlayer> llllIlllIIlIlll = this.entityLiving.world.getEntitiesWithinAABB((Class<? extends EntityPlayer>)EntityPlayer.class, this.entityLiving.getEntityBoundingBox().expand(llllIlllIIllIII, 4.0, llllIlllIIllIII), (com.google.common.base.Predicate<? super EntityPlayer>)this.predicate);
        Collections.sort(llllIlllIIlIlll, this.sorter);
        if (llllIlllIIlIlll.isEmpty()) {
            return false;
        }
        this.entityTarget = llllIlllIIlIlll.get(0);
        return true;
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
}
