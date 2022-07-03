package net.minecraft.entity.projectile;

import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.util.datafix.*;

public class EntitySmallFireball extends EntityFireball
{
    @Override
    public boolean canBeCollidedWith() {
        return false;
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource llllllllllllIlllllIIIIIlIllllIII, final float llllllllllllIlllllIIIIIlIlllIlll) {
        return false;
    }
    
    @Override
    protected void onImpact(final RayTraceResult llllllllllllIlllllIIIIIllIIIIIlI) {
        if (!this.world.isRemote) {
            if (llllllllllllIlllllIIIIIllIIIIIlI.entityHit != null) {
                if (!llllllllllllIlllllIIIIIllIIIIIlI.entityHit.isImmuneToFire()) {
                    final boolean llllllllllllIlllllIIIIIllIIIIIIl = llllllllllllIlllllIIIIIllIIIIIlI.entityHit.attackEntityFrom(DamageSource.causeFireballDamage(this, this.shootingEntity), 5.0f);
                    if (llllllllllllIlllllIIIIIllIIIIIIl) {
                        this.applyEnchantments(this.shootingEntity, llllllllllllIlllllIIIIIllIIIIIlI.entityHit);
                        llllllllllllIlllllIIIIIllIIIIIlI.entityHit.setFire(5);
                    }
                }
            }
            else {
                boolean llllllllllllIlllllIIIIIllIIIIIII = true;
                if (this.shootingEntity != null && this.shootingEntity instanceof EntityLiving) {
                    llllllllllllIlllllIIIIIllIIIIIII = this.world.getGameRules().getBoolean("mobGriefing");
                }
                if (llllllllllllIlllllIIIIIllIIIIIII) {
                    final BlockPos llllllllllllIlllllIIIIIlIlllllll = llllllllllllIlllllIIIIIllIIIIIlI.getBlockPos().offset(llllllllllllIlllllIIIIIllIIIIIlI.sideHit);
                    if (this.world.isAirBlock(llllllllllllIlllllIIIIIlIlllllll)) {
                        this.world.setBlockState(llllllllllllIlllllIIIIIlIlllllll, Blocks.FIRE.getDefaultState());
                    }
                }
            }
            this.setDead();
        }
    }
    
    public EntitySmallFireball(final World llllllllllllIlllllIIIIIllIlIllIl, final EntityLivingBase llllllllllllIlllllIIIIIllIlIIllI, final double llllllllllllIlllllIIIIIllIlIlIll, final double llllllllllllIlllllIIIIIllIlIlIlI, final double llllllllllllIlllllIIIIIllIlIlIIl) {
        super(llllllllllllIlllllIIIIIllIlIllIl, llllllllllllIlllllIIIIIllIlIIllI, llllllllllllIlllllIIIIIllIlIlIll, llllllllllllIlllllIIIIIllIlIlIlI, llllllllllllIlllllIIIIIllIlIlIIl);
        this.setSize(0.3125f, 0.3125f);
    }
    
    public EntitySmallFireball(final World llllllllllllIlllllIIIIIllIIllIIl, final double llllllllllllIlllllIIIIIllIIlIIII, final double llllllllllllIlllllIIIIIllIIIllll, final double llllllllllllIlllllIIIIIllIIlIllI, final double llllllllllllIlllllIIIIIllIIlIlIl, final double llllllllllllIlllllIIIIIllIIIllII, final double llllllllllllIlllllIIIIIllIIlIIll) {
        super(llllllllllllIlllllIIIIIllIIllIIl, llllllllllllIlllllIIIIIllIIlIIII, llllllllllllIlllllIIIIIllIIIllll, llllllllllllIlllllIIIIIllIIlIllI, llllllllllllIlllllIIIIIllIIlIlIl, llllllllllllIlllllIIIIIllIIIllII, llllllllllllIlllllIIIIIllIIlIIll);
        this.setSize(0.3125f, 0.3125f);
    }
    
    public EntitySmallFireball(final World llllllllllllIlllllIIIIIllIllIlIl) {
        super(llllllllllllIlllllIIIIIllIllIlIl);
        this.setSize(0.3125f, 0.3125f);
    }
    
    public static void registerFixesSmallFireball(final DataFixer llllllllllllIlllllIIIIIllIIIlIII) {
        EntityFireball.registerFixesFireball(llllllllllllIlllllIIIIIllIIIlIII, "SmallFireball");
    }
}
