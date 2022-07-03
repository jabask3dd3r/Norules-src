package net.minecraft.entity.projectile;

import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.monster.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.util.datafix.*;

public class EntitySnowball extends EntityThrowable
{
    @Override
    public void handleStatusUpdate(final byte lllllllllllllllIIIIIIlIIllIlIIII) {
        if (lllllllllllllllIIIIIIlIIllIlIIII == 3) {
            for (int lllllllllllllllIIIIIIlIIllIlIIlI = 0; lllllllllllllllIIIIIIlIIllIlIIlI < 8; ++lllllllllllllllIIIIIIlIIllIlIIlI) {
                this.world.spawnParticle(EnumParticleTypes.SNOWBALL, this.posX, this.posY, this.posZ, 0.0, 0.0, 0.0, new int[0]);
            }
        }
    }
    
    public EntitySnowball(final World lllllllllllllllIIIIIIlIIlllIIIll, final double lllllllllllllllIIIIIIlIIlllIIIlI, final double lllllllllllllllIIIIIIlIIlllIIIIl, final double lllllllllllllllIIIIIIlIIllIllIll) {
        super(lllllllllllllllIIIIIIlIIlllIIIll, lllllllllllllllIIIIIIlIIlllIIIlI, lllllllllllllllIIIIIIlIIlllIIIIl, lllllllllllllllIIIIIIlIIllIllIll);
    }
    
    public EntitySnowball(final World lllllllllllllllIIIIIIlIIlllIlIll, final EntityLivingBase lllllllllllllllIIIIIIlIIlllIlIlI) {
        super(lllllllllllllllIIIIIIlIIlllIlIll, lllllllllllllllIIIIIIlIIlllIlIlI);
    }
    
    @Override
    protected void onImpact(final RayTraceResult lllllllllllllllIIIIIIlIIllIIIlll) {
        if (lllllllllllllllIIIIIIlIIllIIIlll.entityHit != null) {
            int lllllllllllllllIIIIIIlIIllIIlIIl = 0;
            if (lllllllllllllllIIIIIIlIIllIIIlll.entityHit instanceof EntityBlaze) {
                lllllllllllllllIIIIIIlIIllIIlIIl = 3;
            }
            lllllllllllllllIIIIIIlIIllIIIlll.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), (float)lllllllllllllllIIIIIIlIIllIIlIIl);
        }
        if (!this.world.isRemote) {
            this.world.setEntityState(this, (byte)3);
            this.setDead();
        }
    }
    
    public EntitySnowball(final World lllllllllllllllIIIIIIlIIllllIIll) {
        super(lllllllllllllllIIIIIIlIIllllIIll);
    }
    
    public static void registerFixesSnowball(final DataFixer lllllllllllllllIIIIIIlIIllIllIIl) {
        EntityThrowable.registerFixesThrowable(lllllllllllllllIIIIIIlIIllIllIIl, "Snowball");
    }
}
