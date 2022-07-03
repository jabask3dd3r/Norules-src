package net.minecraft.entity.ai;

import net.minecraft.entity.passive.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.stats.*;
import net.minecraft.advancements.*;
import net.minecraft.util.*;
import net.minecraft.entity.item.*;
import net.minecraft.entity.player.*;
import java.util.*;

public class EntityAIMate extends EntityAIBase
{
    private final /* synthetic */ EntityAnimal theAnimal;
    private final /* synthetic */ Class<? extends EntityAnimal> field_190857_e;
    /* synthetic */ World theWorld;
    /* synthetic */ double moveSpeed;
    private /* synthetic */ EntityAnimal targetMate;
    /* synthetic */ int spawnBabyDelay;
    
    @Override
    public void resetTask() {
        this.targetMate = null;
        this.spawnBabyDelay = 0;
    }
    
    @Override
    public boolean continueExecuting() {
        return this.targetMate.isEntityAlive() && this.targetMate.isInLove() && this.spawnBabyDelay < 60;
    }
    
    @Override
    public void updateTask() {
        this.theAnimal.getLookHelper().setLookPositionWithEntity(this.targetMate, 10.0f, (float)this.theAnimal.getVerticalFaceSpeed());
        this.theAnimal.getNavigator().tryMoveToEntityLiving(this.targetMate, this.moveSpeed);
        ++this.spawnBabyDelay;
        if (this.spawnBabyDelay >= 60 && this.theAnimal.getDistanceSqToEntity(this.targetMate) < 9.0) {
            this.spawnBaby();
        }
    }
    
    @Override
    public boolean shouldExecute() {
        if (!this.theAnimal.isInLove()) {
            return false;
        }
        this.targetMate = this.getNearbyMate();
        return this.targetMate != null;
    }
    
    private EntityAnimal getNearbyMate() {
        final List<EntityAnimal> lllllllllllllIIlIIIllIllIllllIII = this.theWorld.getEntitiesWithinAABB(this.field_190857_e, this.theAnimal.getEntityBoundingBox().expandXyz(8.0));
        double lllllllllllllIIlIIIllIllIlllIlll = Double.MAX_VALUE;
        EntityAnimal lllllllllllllIIlIIIllIllIlllIllI = null;
        for (final EntityAnimal lllllllllllllIIlIIIllIllIlllIlIl : lllllllllllllIIlIIIllIllIllllIII) {
            if (this.theAnimal.canMateWith(lllllllllllllIIlIIIllIllIlllIlIl) && this.theAnimal.getDistanceSqToEntity(lllllllllllllIIlIIIllIllIlllIlIl) < lllllllllllllIIlIIIllIllIlllIlll) {
                lllllllllllllIIlIIIllIllIlllIllI = lllllllllllllIIlIIIllIllIlllIlIl;
                lllllllllllllIIlIIIllIllIlllIlll = this.theAnimal.getDistanceSqToEntity(lllllllllllllIIlIIIllIllIlllIlIl);
            }
        }
        return lllllllllllllIIlIIIllIllIlllIllI;
    }
    
    public EntityAIMate(final EntityAnimal lllllllllllllIIlIIIllIlllIIIlllI, final double lllllllllllllIIlIIIllIlllIIIllIl, final Class<? extends EntityAnimal> lllllllllllllIIlIIIllIlllIIlIIII) {
        this.theAnimal = lllllllllllllIIlIIIllIlllIIIlllI;
        this.theWorld = lllllllllllllIIlIIIllIlllIIIlllI.world;
        this.field_190857_e = lllllllllllllIIlIIIllIlllIIlIIII;
        this.moveSpeed = lllllllllllllIIlIIIllIlllIIIllIl;
        this.setMutexBits(3);
    }
    
    public EntityAIMate(final EntityAnimal lllllllllllllIIlIIIllIlllIIllIIl, final double lllllllllllllIIlIIIllIlllIIllIll) {
        this(lllllllllllllIIlIIIllIlllIIllIIl, lllllllllllllIIlIIIllIlllIIllIll, lllllllllllllIIlIIIllIlllIIllIIl.getClass());
    }
    
    private void spawnBaby() {
        final EntityAgeable lllllllllllllIIlIIIllIllIIllllll = this.theAnimal.createChild(this.targetMate);
        if (lllllllllllllIIlIIIllIllIIllllll != null) {
            EntityPlayerMP lllllllllllllIIlIIIllIllIIlllllI = this.theAnimal.func_191993_do();
            if (lllllllllllllIIlIIIllIllIIlllllI == null && this.targetMate.func_191993_do() != null) {
                lllllllllllllIIlIIIllIllIIlllllI = this.targetMate.func_191993_do();
            }
            if (lllllllllllllIIlIIIllIllIIlllllI != null) {
                lllllllllllllIIlIIIllIllIIlllllI.addStat(StatList.ANIMALS_BRED);
                CriteriaTriggers.field_192134_n.func_192168_a(lllllllllllllIIlIIIllIllIIlllllI, this.theAnimal, this.targetMate, lllllllllllllIIlIIIllIllIIllllll);
            }
            this.theAnimal.setGrowingAge(6000);
            this.targetMate.setGrowingAge(6000);
            this.theAnimal.resetInLove();
            this.targetMate.resetInLove();
            lllllllllllllIIlIIIllIllIIllllll.setGrowingAge(-24000);
            lllllllllllllIIlIIIllIllIIllllll.setLocationAndAngles(this.theAnimal.posX, this.theAnimal.posY, this.theAnimal.posZ, 0.0f, 0.0f);
            this.theWorld.spawnEntityInWorld(lllllllllllllIIlIIIllIllIIllllll);
            final Random lllllllllllllIIlIIIllIllIIllllII = this.theAnimal.getRNG();
            for (int lllllllllllllIIlIIIllIllIIlllIlI = 0; lllllllllllllIIlIIIllIllIIlllIlI < 7; ++lllllllllllllIIlIIIllIllIIlllIlI) {
                final double lllllllllllllIIlIIIllIllIIlllIII = lllllllllllllIIlIIIllIllIIllllII.nextGaussian() * 0.02;
                final double lllllllllllllIIlIIIllIllIIllIlII = lllllllllllllIIlIIIllIllIIllllII.nextGaussian() * 0.02;
                final double lllllllllllllIIlIIIllIllIIllIIll = lllllllllllllIIlIIIllIllIIllllII.nextGaussian() * 0.02;
                final double lllllllllllllIIlIIIllIllIIllIIlI = lllllllllllllIIlIIIllIllIIllllII.nextDouble() * this.theAnimal.width * 2.0 - this.theAnimal.width;
                final double lllllllllllllIIlIIIllIllIIllIIIl = 0.5 + lllllllllllllIIlIIIllIllIIllllII.nextDouble() * this.theAnimal.height;
                final double lllllllllllllIIlIIIllIllIIllIIII = lllllllllllllIIlIIIllIllIIllllII.nextDouble() * this.theAnimal.width * 2.0 - this.theAnimal.width;
                this.theWorld.spawnParticle(EnumParticleTypes.HEART, this.theAnimal.posX + lllllllllllllIIlIIIllIllIIllIIlI, this.theAnimal.posY + lllllllllllllIIlIIIllIllIIllIIIl, this.theAnimal.posZ + lllllllllllllIIlIIIllIllIIllIIII, lllllllllllllIIlIIIllIllIIlllIII, lllllllllllllIIlIIIllIllIIllIlII, lllllllllllllIIlIIIllIllIIllIIll, new int[0]);
            }
            if (this.theWorld.getGameRules().getBoolean("doMobLoot")) {
                this.theWorld.spawnEntityInWorld(new EntityXPOrb(this.theWorld, this.theAnimal.posX, this.theAnimal.posY, this.theAnimal.posZ, lllllllllllllIIlIIIllIllIIllllII.nextInt(7) + 1));
            }
        }
    }
}
