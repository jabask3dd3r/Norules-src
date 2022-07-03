package net.minecraft.entity.ai;

import net.minecraft.entity.passive.*;
import net.minecraft.entity.*;
import java.util.*;
import net.minecraft.util.math.*;

public class EntityAILlamaFollowCaravan extends EntityAIBase
{
    private /* synthetic */ int field_190861_c;
    private /* synthetic */ double field_190860_b;
    public /* synthetic */ EntityLlama field_190859_a;
    
    @Override
    public boolean shouldExecute() {
        if (this.field_190859_a.getLeashed() || this.field_190859_a.func_190718_dR()) {
            return false;
        }
        final List<EntityLlama> lllllllllllllIlIIlIlIIllIllllIIl = this.field_190859_a.world.getEntitiesWithinAABB(this.field_190859_a.getClass(), this.field_190859_a.getEntityBoundingBox().expand(9.0, 4.0, 9.0));
        EntityLlama lllllllllllllIlIIlIlIIllIllllIII = null;
        double lllllllllllllIlIIlIlIIllIlllIlll = Double.MAX_VALUE;
        for (final EntityLlama lllllllllllllIlIIlIlIIllIlllIllI : lllllllllllllIlIIlIlIIllIllllIIl) {
            if (lllllllllllllIlIIlIlIIllIlllIllI.func_190718_dR() && !lllllllllllllIlIIlIlIIllIlllIllI.func_190712_dQ()) {
                final double lllllllllllllIlIIlIlIIllIlllIlIl = this.field_190859_a.getDistanceSqToEntity(lllllllllllllIlIIlIlIIllIlllIllI);
                if (lllllllllllllIlIIlIlIIllIlllIlIl > lllllllllllllIlIIlIlIIllIlllIlll) {
                    continue;
                }
                lllllllllllllIlIIlIlIIllIlllIlll = lllllllllllllIlIIlIlIIllIlllIlIl;
                lllllllllllllIlIIlIlIIllIllllIII = lllllllllllllIlIIlIlIIllIlllIllI;
            }
        }
        if (lllllllllllllIlIIlIlIIllIllllIII == null) {
            for (final EntityLlama lllllllllllllIlIIlIlIIllIlllIlII : lllllllllllllIlIIlIlIIllIllllIIl) {
                if (lllllllllllllIlIIlIlIIllIlllIlII.getLeashed() && !lllllllllllllIlIIlIlIIllIlllIlII.func_190712_dQ()) {
                    final double lllllllllllllIlIIlIlIIllIlllIIll = this.field_190859_a.getDistanceSqToEntity(lllllllllllllIlIIlIlIIllIlllIlII);
                    if (lllllllllllllIlIIlIlIIllIlllIIll > lllllllllllllIlIIlIlIIllIlllIlll) {
                        continue;
                    }
                    lllllllllllllIlIIlIlIIllIlllIlll = lllllllllllllIlIIlIlIIllIlllIIll;
                    lllllllllllllIlIIlIlIIllIllllIII = lllllllllllllIlIIlIlIIllIlllIlII;
                }
            }
        }
        if (lllllllllllllIlIIlIlIIllIllllIII == null) {
            return false;
        }
        if (lllllllllllllIlIIlIlIIllIlllIlll < 4.0) {
            return false;
        }
        if (!lllllllllllllIlIIlIlIIllIllllIII.getLeashed() && !this.func_190858_a(lllllllllllllIlIIlIlIIllIllllIII, 1)) {
            return false;
        }
        this.field_190859_a.func_190715_a(lllllllllllllIlIIlIlIIllIllllIII);
        return true;
    }
    
    @Override
    public void resetTask() {
        this.field_190859_a.func_190709_dP();
        this.field_190860_b = 2.1;
    }
    
    @Override
    public void updateTask() {
        if (this.field_190859_a.func_190718_dR()) {
            final EntityLlama lllllllllllllIlIIlIlIIllIlIlllII = this.field_190859_a.func_190716_dS();
            final double lllllllllllllIlIIlIlIIllIlIllIll = this.field_190859_a.getDistanceToEntity(lllllllllllllIlIIlIlIIllIlIlllII);
            final float lllllllllllllIlIIlIlIIllIlIllIlI = 2.0f;
            final Vec3d lllllllllllllIlIIlIlIIllIlIllIIl = new Vec3d(lllllllllllllIlIIlIlIIllIlIlllII.posX - this.field_190859_a.posX, lllllllllllllIlIIlIlIIllIlIlllII.posY - this.field_190859_a.posY, lllllllllllllIlIIlIlIIllIlIlllII.posZ - this.field_190859_a.posZ).normalize().scale(Math.max(lllllllllllllIlIIlIlIIllIlIllIll - 2.0, 0.0));
            this.field_190859_a.getNavigator().tryMoveToXYZ(this.field_190859_a.posX + lllllllllllllIlIIlIlIIllIlIllIIl.xCoord, this.field_190859_a.posY + lllllllllllllIlIIlIlIIllIlIllIIl.yCoord, this.field_190859_a.posZ + lllllllllllllIlIIlIlIIllIlIllIIl.zCoord, this.field_190860_b);
        }
    }
    
    private boolean func_190858_a(final EntityLlama lllllllllllllIlIIlIlIIllIlIIlllI, int lllllllllllllIlIIlIlIIllIlIIllIl) {
        if (lllllllllllllIlIIlIlIIllIlIIllIl > 8) {
            return false;
        }
        if (!lllllllllllllIlIIlIlIIllIlIIlllI.func_190718_dR()) {
            return false;
        }
        if (lllllllllllllIlIIlIlIIllIlIIlllI.func_190716_dS().getLeashed()) {
            return true;
        }
        final EntityLlama lllllllllllllIlIIlIlIIllIlIIllII = lllllllllllllIlIIlIlIIllIlIIlllI.func_190716_dS();
        ++lllllllllllllIlIIlIlIIllIlIIllIl;
        return this.func_190858_a(lllllllllllllIlIIlIlIIllIlIIllII, lllllllllllllIlIIlIlIIllIlIIllIl);
    }
    
    public EntityAILlamaFollowCaravan(final EntityLlama lllllllllllllIlIIlIlIIlllIIIIllI, final double lllllllllllllIlIIlIlIIlllIIIIlIl) {
        this.field_190859_a = lllllllllllllIlIIlIlIIlllIIIIllI;
        this.field_190860_b = lllllllllllllIlIIlIlIIlllIIIIlIl;
        this.setMutexBits(1);
    }
    
    @Override
    public boolean continueExecuting() {
        if (this.field_190859_a.func_190718_dR() && this.field_190859_a.func_190716_dS().isEntityAlive() && this.func_190858_a(this.field_190859_a, 0)) {
            final double lllllllllllllIlIIlIlIIllIllIlIII = this.field_190859_a.getDistanceSqToEntity(this.field_190859_a.func_190716_dS());
            if (lllllllllllllIlIIlIlIIllIllIlIII > 676.0) {
                if (this.field_190860_b <= 3.0) {
                    this.field_190860_b *= 1.2;
                    this.field_190861_c = 40;
                    return true;
                }
                if (this.field_190861_c == 0) {
                    return false;
                }
            }
            if (this.field_190861_c > 0) {
                --this.field_190861_c;
            }
            return true;
        }
        return false;
    }
}
