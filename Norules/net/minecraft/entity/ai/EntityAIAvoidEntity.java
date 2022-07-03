package net.minecraft.entity.ai;

import net.minecraft.pathfinding.*;
import net.minecraft.entity.*;
import javax.annotation.*;
import com.google.common.base.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import java.util.*;

public class EntityAIAvoidEntity<T extends Entity> extends EntityAIBase
{
    private final /* synthetic */ PathNavigate entityPathNavigate;
    private final /* synthetic */ Predicate<? super T> avoidTargetSelector;
    private /* synthetic */ Path entityPathEntity;
    private final /* synthetic */ float avoidDistance;
    private final /* synthetic */ Class<T> classToAvoid;
    protected /* synthetic */ T closestLivingEntity;
    private final /* synthetic */ Predicate<Entity> canBeSeenSelector;
    protected /* synthetic */ EntityCreature theEntity;
    private final /* synthetic */ double farSpeed;
    private final /* synthetic */ double nearSpeed;
    
    @Override
    public void resetTask() {
        this.closestLivingEntity = null;
    }
    
    public EntityAIAvoidEntity(final EntityCreature lllllllllllllIIIllllllIIlIllIIlI, final Class<T> lllllllllllllIIIllllllIIlIllIIIl, final Predicate<? super T> lllllllllllllIIIllllllIIlIllIIII, final float lllllllllllllIIIllllllIIlIllIllI, final double lllllllllllllIIIllllllIIlIlIlllI, final double lllllllllllllIIIllllllIIlIllIlII) {
        this.canBeSeenSelector = (Predicate<Entity>)new Predicate<Entity>() {
            public boolean apply(@Nullable final Entity llllllllllllllIIlIlIIlllIIlllIII) {
                return llllllllllllllIIlIlIIlllIIlllIII.isEntityAlive() && EntityAIAvoidEntity.this.theEntity.getEntitySenses().canSee(llllllllllllllIIlIlIIlllIIlllIII) && !EntityAIAvoidEntity.this.theEntity.isOnSameTeam(llllllllllllllIIlIlIIlllIIlllIII);
            }
        };
        this.theEntity = lllllllllllllIIIllllllIIlIllIIlI;
        this.classToAvoid = lllllllllllllIIIllllllIIlIllIIIl;
        this.avoidTargetSelector = lllllllllllllIIIllllllIIlIllIIII;
        this.avoidDistance = lllllllllllllIIIllllllIIlIllIllI;
        this.farSpeed = lllllllllllllIIIllllllIIlIlIlllI;
        this.nearSpeed = lllllllllllllIIIllllllIIlIllIlII;
        this.entityPathNavigate = lllllllllllllIIIllllllIIlIllIIlI.getNavigator();
        this.setMutexBits(1);
    }
    
    @Override
    public void startExecuting() {
        this.entityPathNavigate.setPath(this.entityPathEntity, this.farSpeed);
    }
    
    @Override
    public boolean continueExecuting() {
        return !this.entityPathNavigate.noPath();
    }
    
    public EntityAIAvoidEntity(final EntityCreature lllllllllllllIIIllllllIIllIIIllI, final Class<T> lllllllllllllIIIllllllIIllIIIlIl, final float lllllllllllllIIIllllllIIllIIIlII, final double lllllllllllllIIIllllllIIllIIlIIl, final double lllllllllllllIIIllllllIIllIIlIII) {
        this(lllllllllllllIIIllllllIIllIIIllI, (Class)lllllllllllllIIIllllllIIllIIIlIl, Predicates.alwaysTrue(), lllllllllllllIIIllllllIIllIIIlII, lllllllllllllIIIllllllIIllIIlIIl, lllllllllllllIIIllllllIIllIIlIII);
    }
    
    @Override
    public boolean shouldExecute() {
        final List<T> lllllllllllllIIIllllllIIlIlIlIII = this.theEntity.world.getEntitiesWithinAABB((Class<? extends T>)this.classToAvoid, this.theEntity.getEntityBoundingBox().expand(this.avoidDistance, 3.0, this.avoidDistance), (com.google.common.base.Predicate<? super T>)Predicates.and(new Predicate[] { EntitySelectors.CAN_AI_TARGET, this.canBeSeenSelector, this.avoidTargetSelector }));
        if (lllllllllllllIIIllllllIIlIlIlIII.isEmpty()) {
            return false;
        }
        this.closestLivingEntity = lllllllllllllIIIllllllIIlIlIlIII.get(0);
        final Vec3d lllllllllllllIIIllllllIIlIlIIlll = RandomPositionGenerator.findRandomTargetBlockAwayFrom(this.theEntity, 16, 7, new Vec3d(this.closestLivingEntity.posX, this.closestLivingEntity.posY, this.closestLivingEntity.posZ));
        if (lllllllllllllIIIllllllIIlIlIIlll == null) {
            return false;
        }
        if (this.closestLivingEntity.getDistanceSq(lllllllllllllIIIllllllIIlIlIIlll.xCoord, lllllllllllllIIIllllllIIlIlIIlll.yCoord, lllllllllllllIIIllllllIIlIlIIlll.zCoord) < this.closestLivingEntity.getDistanceSqToEntity(this.theEntity)) {
            return false;
        }
        this.entityPathEntity = this.entityPathNavigate.getPathToXYZ(lllllllllllllIIIllllllIIlIlIIlll.xCoord, lllllllllllllIIIllllllIIlIlIIlll.yCoord, lllllllllllllIIIllllllIIlIlIIlll.zCoord);
        return this.entityPathEntity != null;
    }
    
    @Override
    public void updateTask() {
        if (this.theEntity.getDistanceSqToEntity(this.closestLivingEntity) < 49.0) {
            this.theEntity.getNavigator().setSpeed(this.nearSpeed);
        }
        else {
            this.theEntity.getNavigator().setSpeed(this.farSpeed);
        }
    }
}
