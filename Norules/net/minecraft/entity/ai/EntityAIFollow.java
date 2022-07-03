package net.minecraft.entity.ai;

import com.google.common.base.*;
import java.util.*;
import net.minecraft.entity.*;
import javax.annotation.*;
import net.minecraft.pathfinding.*;

public class EntityAIFollow extends EntityAIBase
{
    private /* synthetic */ float field_192379_h;
    private final /* synthetic */ double field_192375_d;
    private /* synthetic */ EntityLiving field_192374_c;
    private final /* synthetic */ PathNavigate field_192376_e;
    private final /* synthetic */ Predicate<EntityLiving> field_192373_b;
    private final /* synthetic */ float field_192378_g;
    private final /* synthetic */ float field_192380_i;
    private final /* synthetic */ EntityLiving field_192372_a;
    private /* synthetic */ int field_192377_f;
    
    @Override
    public void resetTask() {
        this.field_192374_c = null;
        this.field_192376_e.clearPathEntity();
        this.field_192372_a.setPathPriority(PathNodeType.WATER, this.field_192379_h);
    }
    
    @Override
    public void startExecuting() {
        this.field_192377_f = 0;
        this.field_192379_h = this.field_192372_a.getPathPriority(PathNodeType.WATER);
        this.field_192372_a.setPathPriority(PathNodeType.WATER, 0.0f);
    }
    
    @Override
    public boolean shouldExecute() {
        final List<EntityLiving> lllllllllllllIIlIIIllIlIIllIIlIl = this.field_192372_a.world.getEntitiesWithinAABB((Class<? extends EntityLiving>)EntityLiving.class, this.field_192372_a.getEntityBoundingBox().expandXyz(this.field_192380_i), (com.google.common.base.Predicate<? super EntityLiving>)this.field_192373_b);
        if (!lllllllllllllIIlIIIllIlIIllIIlIl.isEmpty()) {
            for (final EntityLiving lllllllllllllIIlIIIllIlIIllIIlII : lllllllllllllIIlIIIllIlIIllIIlIl) {
                if (!lllllllllllllIIlIIIllIlIIllIIlII.isInvisible()) {
                    this.field_192374_c = lllllllllllllIIlIIIllIlIIllIIlII;
                    return true;
                }
            }
        }
        return false;
    }
    
    @Override
    public void updateTask() {
        if (this.field_192374_c != null && !this.field_192372_a.getLeashed()) {
            this.field_192372_a.getLookHelper().setLookPositionWithEntity(this.field_192374_c, 10.0f, (float)this.field_192372_a.getVerticalFaceSpeed());
            if (--this.field_192377_f <= 0) {
                this.field_192377_f = 10;
                final double lllllllllllllIIlIIIllIlIIIllIlII = this.field_192372_a.posX - this.field_192374_c.posX;
                final double lllllllllllllIIlIIIllIlIIIllIIll = this.field_192372_a.posY - this.field_192374_c.posY;
                final double lllllllllllllIIlIIIllIlIIIllIIlI = this.field_192372_a.posZ - this.field_192374_c.posZ;
                final double lllllllllllllIIlIIIllIlIIIllIIIl = lllllllllllllIIlIIIllIlIIIllIlII * lllllllllllllIIlIIIllIlIIIllIlII + lllllllllllllIIlIIIllIlIIIllIIll * lllllllllllllIIlIIIllIlIIIllIIll + lllllllllllllIIlIIIllIlIIIllIIlI * lllllllllllllIIlIIIllIlIIIllIIlI;
                if (lllllllllllllIIlIIIllIlIIIllIIIl > this.field_192378_g * this.field_192378_g) {
                    this.field_192376_e.tryMoveToEntityLiving(this.field_192374_c, this.field_192375_d);
                }
                else {
                    this.field_192376_e.clearPathEntity();
                    final EntityLookHelper lllllllllllllIIlIIIllIlIIIllIIII = this.field_192374_c.getLookHelper();
                    if (lllllllllllllIIlIIIllIlIIIllIIIl <= this.field_192378_g || (lllllllllllllIIlIIIllIlIIIllIIII.getLookPosX() == this.field_192372_a.posX && lllllllllllllIIlIIIllIlIIIllIIII.getLookPosY() == this.field_192372_a.posY && lllllllllllllIIlIIIllIlIIIllIIII.getLookPosZ() == this.field_192372_a.posZ)) {
                        final double lllllllllllllIIlIIIllIlIIIlIllll = this.field_192374_c.posX - this.field_192372_a.posX;
                        final double lllllllllllllIIlIIIllIlIIIlIlllI = this.field_192374_c.posZ - this.field_192372_a.posZ;
                        this.field_192376_e.tryMoveToXYZ(this.field_192372_a.posX - lllllllllllllIIlIIIllIlIIIlIllll, this.field_192372_a.posY, this.field_192372_a.posZ - lllllllllllllIIlIIIllIlIIIlIlllI, this.field_192375_d);
                    }
                }
            }
        }
    }
    
    @Override
    public boolean continueExecuting() {
        return this.field_192374_c != null && !this.field_192376_e.noPath() && this.field_192372_a.getDistanceSqToEntity(this.field_192374_c) > this.field_192378_g * this.field_192378_g;
    }
    
    public EntityAIFollow(final EntityLiving lllllllllllllIIlIIIllIlIIlllIlIl, final double lllllllllllllIIlIIIllIlIIlllIlII, final float lllllllllllllIIlIIIllIlIIllIlllI, final float lllllllllllllIIlIIIllIlIIllIllIl) {
        this.field_192372_a = lllllllllllllIIlIIIllIlIIlllIlIl;
        this.field_192373_b = (Predicate<EntityLiving>)new Predicate<EntityLiving>() {
            public boolean apply(@Nullable final EntityLiving lllllllllllllIlIlIlllllllIlIIllI) {
                return lllllllllllllIlIlIlllllllIlIIllI != null && lllllllllllllIIlIIIllIlIIlllIlIl.getClass() != lllllllllllllIlIlIlllllllIlIIllI.getClass();
            }
        };
        this.field_192375_d = lllllllllllllIIlIIIllIlIIlllIlII;
        this.field_192376_e = lllllllllllllIIlIIIllIlIIlllIlIl.getNavigator();
        this.field_192378_g = lllllllllllllIIlIIIllIlIIllIlllI;
        this.field_192380_i = lllllllllllllIIlIIIllIlIIllIllIl;
        this.setMutexBits(3);
        if (!(lllllllllllllIIlIIIllIlIIlllIlIl.getNavigator() instanceof PathNavigateGround) && !(lllllllllllllIIlIIIllIlIIlllIlIl.getNavigator() instanceof PathNavigateFlying)) {
            throw new IllegalArgumentException("Unsupported mob type for FollowMobGoal");
        }
    }
}
