package net.minecraft.entity.ai;

import net.minecraft.entity.passive.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.block.state.*;
import net.minecraft.pathfinding.*;
import net.minecraft.entity.player.*;

public class EntityAIFollowOwner extends EntityAIBase
{
    /* synthetic */ float maxDist;
    private final /* synthetic */ EntityTameable thePet;
    private final /* synthetic */ PathNavigate petPathfinder;
    private /* synthetic */ EntityLivingBase theOwner;
    private /* synthetic */ int timeToRecalcPath;
    private /* synthetic */ float oldWaterCost;
    /* synthetic */ World theWorld;
    /* synthetic */ float minDist;
    private final /* synthetic */ double followSpeed;
    
    @Override
    public void startExecuting() {
        this.timeToRecalcPath = 0;
        this.oldWaterCost = this.thePet.getPathPriority(PathNodeType.WATER);
        this.thePet.setPathPriority(PathNodeType.WATER, 0.0f);
    }
    
    @Override
    public void updateTask() {
        this.thePet.getLookHelper().setLookPositionWithEntity(this.theOwner, 10.0f, (float)this.thePet.getVerticalFaceSpeed());
        if (!this.thePet.isSitting() && --this.timeToRecalcPath <= 0) {
            this.timeToRecalcPath = 10;
            if (!this.petPathfinder.tryMoveToEntityLiving(this.theOwner, this.followSpeed) && !this.thePet.getLeashed() && !this.thePet.isRiding() && this.thePet.getDistanceSqToEntity(this.theOwner) >= 144.0) {
                final int lllllllllllllIIlllIIlllIlIllIllI = MathHelper.floor(this.theOwner.posX) - 2;
                final int lllllllllllllIIlllIIlllIlIllIlIl = MathHelper.floor(this.theOwner.posZ) - 2;
                final int lllllllllllllIIlllIIlllIlIllIlII = MathHelper.floor(this.theOwner.getEntityBoundingBox().minY);
                for (int lllllllllllllIIlllIIlllIlIllIIll = 0; lllllllllllllIIlllIIlllIlIllIIll <= 4; ++lllllllllllllIIlllIIlllIlIllIIll) {
                    for (int lllllllllllllIIlllIIlllIlIllIIlI = 0; lllllllllllllIIlllIIlllIlIllIIlI <= 4; ++lllllllllllllIIlllIIlllIlIllIIlI) {
                        if ((lllllllllllllIIlllIIlllIlIllIIll < 1 || lllllllllllllIIlllIIlllIlIllIIlI < 1 || lllllllllllllIIlllIIlllIlIllIIll > 3 || lllllllllllllIIlllIIlllIlIllIIlI > 3) && this.func_192381_a(lllllllllllllIIlllIIlllIlIllIllI, lllllllllllllIIlllIIlllIlIllIlIl, lllllllllllllIIlllIIlllIlIllIlII, lllllllllllllIIlllIIlllIlIllIIll, lllllllllllllIIlllIIlllIlIllIIlI)) {
                            this.thePet.setLocationAndAngles(lllllllllllllIIlllIIlllIlIllIllI + lllllllllllllIIlllIIlllIlIllIIll + 0.5f, lllllllllllllIIlllIIlllIlIllIlII, lllllllllllllIIlllIIlllIlIllIlIl + lllllllllllllIIlllIIlllIlIllIIlI + 0.5f, this.thePet.rotationYaw, this.thePet.rotationPitch);
                            this.petPathfinder.clearPathEntity();
                            return;
                        }
                    }
                }
            }
        }
    }
    
    protected boolean func_192381_a(final int lllllllllllllIIlllIIlllIlIIllIlI, final int lllllllllllllIIlllIIlllIlIIllIIl, final int lllllllllllllIIlllIIlllIlIlIIIII, final int lllllllllllllIIlllIIlllIlIIlllll, final int lllllllllllllIIlllIIlllIlIIlIllI) {
        final BlockPos lllllllllllllIIlllIIlllIlIIlllIl = new BlockPos(lllllllllllllIIlllIIlllIlIIllIlI + lllllllllllllIIlllIIlllIlIIlllll, lllllllllllllIIlllIIlllIlIlIIIII - 1, lllllllllllllIIlllIIlllIlIIllIIl + lllllllllllllIIlllIIlllIlIIlIllI);
        final IBlockState lllllllllllllIIlllIIlllIlIIlllII = this.theWorld.getBlockState(lllllllllllllIIlllIIlllIlIIlllIl);
        return lllllllllllllIIlllIIlllIlIIlllII.func_193401_d(this.theWorld, lllllllllllllIIlllIIlllIlIIlllIl, EnumFacing.DOWN) == BlockFaceShape.SOLID && lllllllllllllIIlllIIlllIlIIlllII.canEntitySpawn(this.thePet) && this.theWorld.isAirBlock(lllllllllllllIIlllIIlllIlIIlllIl.up()) && this.theWorld.isAirBlock(lllllllllllllIIlllIIlllIlIIlllIl.up(2));
    }
    
    public EntityAIFollowOwner(final EntityTameable lllllllllllllIIlllIIlllIllIlIIII, final double lllllllllllllIIlllIIlllIllIIllll, final float lllllllllllllIIlllIIlllIllIlIIll, final float lllllllllllllIIlllIIlllIllIIllIl) {
        this.thePet = lllllllllllllIIlllIIlllIllIlIIII;
        this.theWorld = lllllllllllllIIlllIIlllIllIlIIII.world;
        this.followSpeed = lllllllllllllIIlllIIlllIllIIllll;
        this.petPathfinder = lllllllllllllIIlllIIlllIllIlIIII.getNavigator();
        this.minDist = lllllllllllllIIlllIIlllIllIlIIll;
        this.maxDist = lllllllllllllIIlllIIlllIllIIllIl;
        this.setMutexBits(3);
        if (!(lllllllllllllIIlllIIlllIllIlIIII.getNavigator() instanceof PathNavigateGround) && !(lllllllllllllIIlllIIlllIllIlIIII.getNavigator() instanceof PathNavigateFlying)) {
            throw new IllegalArgumentException("Unsupported mob type for FollowOwnerGoal");
        }
    }
    
    @Override
    public boolean shouldExecute() {
        final EntityLivingBase lllllllllllllIIlllIIlllIllIIlIIl = this.thePet.getOwner();
        if (lllllllllllllIIlllIIlllIllIIlIIl == null) {
            return false;
        }
        if (lllllllllllllIIlllIIlllIllIIlIIl instanceof EntityPlayer && ((EntityPlayer)lllllllllllllIIlllIIlllIllIIlIIl).isSpectator()) {
            return false;
        }
        if (this.thePet.isSitting()) {
            return false;
        }
        if (this.thePet.getDistanceSqToEntity(lllllllllllllIIlllIIlllIllIIlIIl) < this.minDist * this.minDist) {
            return false;
        }
        this.theOwner = lllllllllllllIIlllIIlllIllIIlIIl;
        return true;
    }
    
    @Override
    public void resetTask() {
        this.theOwner = null;
        this.petPathfinder.clearPathEntity();
        this.thePet.setPathPriority(PathNodeType.WATER, this.oldWaterCost);
    }
    
    @Override
    public boolean continueExecuting() {
        return !this.petPathfinder.noPath() && this.thePet.getDistanceSqToEntity(this.theOwner) > this.maxDist * this.maxDist && !this.thePet.isSitting();
    }
}
