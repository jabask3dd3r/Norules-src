package net.minecraft.entity.item;

import net.minecraft.entity.projectile.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import javax.annotation.*;
import net.minecraft.entity.player.*;
import net.minecraft.advancements.*;
import net.minecraft.util.*;
import net.minecraft.entity.monster.*;
import net.minecraft.util.math.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.datafix.*;

public class EntityEnderPearl extends EntityThrowable
{
    private /* synthetic */ EntityLivingBase thrower;
    
    @Override
    public void onUpdate() {
        final EntityLivingBase lllllllllllllIllIIIlllIIlllIIIlI = this.getThrower();
        if (lllllllllllllIllIIIlllIIlllIIIlI != null && lllllllllllllIllIIIlllIIlllIIIlI instanceof EntityPlayer && !lllllllllllllIllIIIlllIIlllIIIlI.isEntityAlive()) {
            this.setDead();
        }
        else {
            super.onUpdate();
        }
    }
    
    public EntityEnderPearl(final World lllllllllllllIllIIIlllIlIIIlIllI) {
        super(lllllllllllllIllIIIlllIlIIIlIllI);
    }
    
    public EntityEnderPearl(final World lllllllllllllIllIIIlllIlIIIIIllI, final double lllllllllllllIllIIIlllIlIIIIIIII, final double lllllllllllllIllIIIlllIIllllllll, final double lllllllllllllIllIIIlllIIlllllllI) {
        super(lllllllllllllIllIIIlllIlIIIIIllI, lllllllllllllIllIIIlllIlIIIIIIII, lllllllllllllIllIIIlllIIllllllll, lllllllllllllIllIIIlllIIlllllllI);
    }
    
    @Nullable
    @Override
    public Entity changeDimension(final int lllllllllllllIllIIIlllIIllIllIlI) {
        if (this.thrower.dimension != lllllllllllllIllIIIlllIIllIllIlI) {
            this.thrower = null;
        }
        return super.changeDimension(lllllllllllllIllIIIlllIIllIllIlI);
    }
    
    @Override
    protected void onImpact(final RayTraceResult lllllllllllllIllIIIlllIIllllIIll) {
        final EntityLivingBase lllllllllllllIllIIIlllIIllllIIlI = this.getThrower();
        if (lllllllllllllIllIIIlllIIllllIIll.entityHit != null) {
            if (lllllllllllllIllIIIlllIIllllIIll.entityHit == this.thrower) {
                return;
            }
            lllllllllllllIllIIIlllIIllllIIll.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, lllllllllllllIllIIIlllIIllllIIlI), 0.0f);
        }
        if (lllllllllllllIllIIIlllIIllllIIll.typeOfHit == RayTraceResult.Type.BLOCK) {
            final BlockPos lllllllllllllIllIIIlllIIllllIIIl = lllllllllllllIllIIIlllIIllllIIll.getBlockPos();
            final TileEntity lllllllllllllIllIIIlllIIllllIIII = this.world.getTileEntity(lllllllllllllIllIIIlllIIllllIIIl);
            if (lllllllllllllIllIIIlllIIllllIIII instanceof TileEntityEndGateway) {
                final TileEntityEndGateway lllllllllllllIllIIIlllIIlllIllll = (TileEntityEndGateway)lllllllllllllIllIIIlllIIllllIIII;
                if (lllllllllllllIllIIIlllIIllllIIlI != null) {
                    if (lllllllllllllIllIIIlllIIllllIIlI instanceof EntityPlayerMP) {
                        CriteriaTriggers.field_192124_d.func_192193_a((EntityPlayerMP)lllllllllllllIllIIIlllIIllllIIlI, this.world.getBlockState(lllllllllllllIllIIIlllIIllllIIIl));
                    }
                    lllllllllllllIllIIIlllIIlllIllll.teleportEntity(lllllllllllllIllIIIlllIIllllIIlI);
                    this.setDead();
                    return;
                }
                lllllllllllllIllIIIlllIIlllIllll.teleportEntity(this);
                return;
            }
        }
        for (int lllllllllllllIllIIIlllIIlllIlllI = 0; lllllllllllllIllIIIlllIIlllIlllI < 32; ++lllllllllllllIllIIIlllIIlllIlllI) {
            this.world.spawnParticle(EnumParticleTypes.PORTAL, this.posX, this.posY + this.rand.nextDouble() * 2.0, this.posZ, this.rand.nextGaussian(), 0.0, this.rand.nextGaussian(), new int[0]);
        }
        if (!this.world.isRemote) {
            if (lllllllllllllIllIIIlllIIllllIIlI instanceof EntityPlayerMP) {
                final EntityPlayerMP lllllllllllllIllIIIlllIIlllIllIl = (EntityPlayerMP)lllllllllllllIllIIIlllIIllllIIlI;
                if (lllllllllllllIllIIIlllIIlllIllIl.connection.getNetworkManager().isChannelOpen() && lllllllllllllIllIIIlllIIlllIllIl.world == this.world && !lllllllllllllIllIIIlllIIlllIllIl.isPlayerSleeping()) {
                    if (this.rand.nextFloat() < 0.05f && this.world.getGameRules().getBoolean("doMobSpawning")) {
                        final EntityEndermite lllllllllllllIllIIIlllIIlllIllII = new EntityEndermite(this.world);
                        lllllllllllllIllIIIlllIIlllIllII.setSpawnedByPlayer(true);
                        lllllllllllllIllIIIlllIIlllIllII.setLocationAndAngles(lllllllllllllIllIIIlllIIllllIIlI.posX, lllllllllllllIllIIIlllIIllllIIlI.posY, lllllllllllllIllIIIlllIIllllIIlI.posZ, lllllllllllllIllIIIlllIIllllIIlI.rotationYaw, lllllllllllllIllIIIlllIIllllIIlI.rotationPitch);
                        this.world.spawnEntityInWorld(lllllllllllllIllIIIlllIIlllIllII);
                    }
                    if (lllllllllllllIllIIIlllIIllllIIlI.isRiding()) {
                        lllllllllllllIllIIIlllIIllllIIlI.dismountRidingEntity();
                    }
                    lllllllllllllIllIIIlllIIllllIIlI.setPositionAndUpdate(this.posX, this.posY, this.posZ);
                    lllllllllllllIllIIIlllIIllllIIlI.fallDistance = 0.0f;
                    lllllllllllllIllIIIlllIIllllIIlI.attackEntityFrom(DamageSource.fall, 5.0f);
                }
            }
            else if (lllllllllllllIllIIIlllIIllllIIlI != null) {
                lllllllllllllIllIIIlllIIllllIIlI.setPositionAndUpdate(this.posX, this.posY, this.posZ);
                lllllllllllllIllIIIlllIIllllIIlI.fallDistance = 0.0f;
            }
            this.setDead();
        }
    }
    
    public EntityEnderPearl(final World lllllllllllllIllIIIlllIlIIIIlllI, final EntityLivingBase lllllllllllllIllIIIlllIlIIIlIIII) {
        super(lllllllllllllIllIIIlllIlIIIIlllI, lllllllllllllIllIIIlllIlIIIlIIII);
        this.thrower = lllllllllllllIllIIIlllIlIIIlIIII;
    }
    
    public static void registerFixesEnderPearl(final DataFixer lllllllllllllIllIIIlllIIllllllII) {
        EntityThrowable.registerFixesThrowable(lllllllllllllIllIIIlllIIllllllII, "ThrownEnderpearl");
    }
}
