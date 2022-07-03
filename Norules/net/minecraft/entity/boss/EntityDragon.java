package net.minecraft.entity.boss;

import net.minecraft.entity.monster.*;
import net.minecraft.world.end.*;
import net.minecraft.entity.boss.dragon.phase.*;
import net.minecraft.nbt.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.entity.item.*;
import net.minecraft.pathfinding.*;
import net.minecraft.util.math.*;
import net.minecraft.block.material.*;
import net.minecraft.init.*;
import net.minecraft.block.state.*;
import net.minecraft.block.*;
import net.minecraft.util.datafix.*;
import javax.annotation.*;
import java.util.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import org.apache.logging.log4j.*;
import net.minecraft.network.datasync.*;
import net.minecraft.world.storage.loot.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.potion.*;

public class EntityDragon extends EntityLiving implements IEntityMultiPart, IMob
{
    public /* synthetic */ MultiPartEntityPart dragonPartWing1;
    public /* synthetic */ boolean slowed;
    public /* synthetic */ MultiPartEntityPart dragonPartTail2;
    private static final /* synthetic */ Logger LOGGER;
    public /* synthetic */ MultiPartEntityPart dragonPartHead;
    public /* synthetic */ MultiPartEntityPart dragonPartBody;
    private /* synthetic */ int growlTime;
    public /* synthetic */ int deathTicks;
    private final /* synthetic */ int[] neighbors;
    private final /* synthetic */ PathPoint[] pathPoints;
    private final /* synthetic */ PathHeap pathFindQueue;
    public /* synthetic */ MultiPartEntityPart dragonPartTail1;
    public /* synthetic */ MultiPartEntityPart dragonPartWing2;
    private /* synthetic */ int sittingDamageReceived;
    private final /* synthetic */ PhaseManager phaseManager;
    public /* synthetic */ float prevAnimTime;
    public /* synthetic */ double[][] ringBuffer;
    public static final /* synthetic */ DataParameter<Integer> PHASE;
    public /* synthetic */ MultiPartEntityPart dragonPartNeck;
    public /* synthetic */ MultiPartEntityPart dragonPartTail3;
    private final /* synthetic */ DragonFightManager fightManager;
    public /* synthetic */ EntityEnderCrystal healingEnderCrystal;
    public /* synthetic */ float animTime;
    public /* synthetic */ int ringBufferIndex;
    public /* synthetic */ MultiPartEntityPart[] dragonPartArray;
    
    public int initPathPoints() {
        if (this.pathPoints[0] == null) {
            for (int lIllllIIlIllI = 0; lIllllIIlIllI < 24; ++lIllllIIlIllI) {
                int lIllllIIlIlIl = 5;
                int lIllllIIlIIlI = 0;
                int lIllllIIIllll = 0;
                if (lIllllIIlIllI < 12) {
                    final int lIllllIIlIlII = (int)(60.0f * MathHelper.cos(2.0f * (-3.1415927f + 0.2617994f * lIllllIIlIllI)));
                    final int lIllllIIlIIIl = (int)(60.0f * MathHelper.sin(2.0f * (-3.1415927f + 0.2617994f * lIllllIIlIllI)));
                }
                else if (lIllllIIlIllI < 20) {
                    final int lIllllIIIlllI = lIllllIIlIllI - 12;
                    final int lIllllIIlIIll = (int)(40.0f * MathHelper.cos(2.0f * (-3.1415927f + 0.3926991f * lIllllIIIlllI)));
                    final int lIllllIIlIIII = (int)(40.0f * MathHelper.sin(2.0f * (-3.1415927f + 0.3926991f * lIllllIIIlllI)));
                    lIllllIIlIlIl += 10;
                }
                else {
                    final int lIllllIIIllIl = lIllllIIlIllI - 20;
                    lIllllIIlIIlI = (int)(20.0f * MathHelper.cos(2.0f * (-3.1415927f + 0.7853982f * lIllllIIIllIl)));
                    lIllllIIIllll = (int)(20.0f * MathHelper.sin(2.0f * (-3.1415927f + 0.7853982f * lIllllIIIllIl)));
                }
                final int lIllllIIIllII = Math.max(this.world.getSeaLevel() + 10, this.world.getTopSolidOrLiquidBlock(new BlockPos(lIllllIIlIIlI, 0, lIllllIIIllll)).getY() + lIllllIIlIlIl);
                this.pathPoints[lIllllIIlIllI] = new PathPoint(lIllllIIlIIlI, lIllllIIIllII, lIllllIIIllll);
            }
            this.neighbors[0] = 6146;
            this.neighbors[1] = 8197;
            this.neighbors[2] = 8202;
            this.neighbors[3] = 16404;
            this.neighbors[4] = 32808;
            this.neighbors[5] = 32848;
            this.neighbors[6] = 65696;
            this.neighbors[7] = 131392;
            this.neighbors[8] = 131712;
            this.neighbors[9] = 263424;
            this.neighbors[10] = 526848;
            this.neighbors[11] = 525313;
            this.neighbors[12] = 1581057;
            this.neighbors[13] = 3166214;
            this.neighbors[14] = 2138120;
            this.neighbors[15] = 6373424;
            this.neighbors[16] = 4358208;
            this.neighbors[17] = 12910976;
            this.neighbors[18] = 9044480;
            this.neighbors[19] = 9706496;
            this.neighbors[20] = 15216640;
            this.neighbors[21] = 13688832;
            this.neighbors[22] = 11763712;
            this.neighbors[23] = 8257536;
        }
        return this.getNearestPpIdx(this.posX, this.posY, this.posZ);
    }
    
    @Override
    public void notifyDataManagerChange(final DataParameter<?> lIllIlIlllllI) {
        if (EntityDragon.PHASE.equals(lIllIlIlllllI) && this.world.isRemote) {
            this.phaseManager.setPhase(PhaseList.getById(this.getDataManager().get(EntityDragon.PHASE)));
        }
        super.notifyDataManagerChange(lIllIlIlllllI);
    }
    
    @Override
    protected void despawnEntity() {
    }
    
    @Override
    public SoundCategory getSoundCategory() {
        return SoundCategory.HOSTILE;
    }
    
    @Override
    public boolean canBeCollidedWith() {
        return false;
    }
    
    public int getNearestPpIdx(final double lIlllIlllIIII, final double lIlllIllllIIl, final double lIlllIllllIII) {
        float lIlllIlllIlll = 10000.0f;
        int lIlllIlllIllI = 0;
        final PathPoint lIlllIlllIlIl = new PathPoint(MathHelper.floor(lIlllIlllIIII), MathHelper.floor(lIlllIllllIIl), MathHelper.floor(lIlllIllllIII));
        int lIlllIlllIlII = 0;
        if (this.fightManager == null || this.fightManager.getNumAliveCrystals() == 0) {
            lIlllIlllIlII = 12;
        }
        for (int lIlllIlllIIll = lIlllIlllIlII; lIlllIlllIIll < 24; ++lIlllIlllIIll) {
            if (this.pathPoints[lIlllIlllIIll] != null) {
                final float lIlllIlllIIlI = this.pathPoints[lIlllIlllIIll].distanceToSquared(lIlllIlllIlIl);
                if (lIlllIlllIIlI < lIlllIlllIlll) {
                    lIlllIlllIlll = lIlllIlllIIlI;
                    lIlllIlllIllI = lIlllIlllIIll;
                }
            }
        }
        return lIlllIlllIllI;
    }
    
    private float simplifyAngle(final double llIIIIIIIllIl) {
        return (float)MathHelper.wrapDegrees(llIIIIIIIllIl);
    }
    
    @Override
    public void onLivingUpdate() {
        if (this.world.isRemote) {
            this.setHealth(this.getHealth());
            if (!this.isSilent()) {
                final float llIIIlIIlllII = MathHelper.cos(this.animTime * 6.2831855f);
                final float llIIIlIIllIll = MathHelper.cos(this.prevAnimTime * 6.2831855f);
                if (llIIIlIIllIll <= -0.3f && llIIIlIIlllII >= -0.3f) {
                    this.world.playSound(this.posX, this.posY, this.posZ, SoundEvents.ENTITY_ENDERDRAGON_FLAP, this.getSoundCategory(), 5.0f, 0.8f + this.rand.nextFloat() * 0.3f, false);
                }
                if (!this.phaseManager.getCurrentPhase().getIsStationary() && --this.growlTime < 0) {
                    this.world.playSound(this.posX, this.posY, this.posZ, SoundEvents.ENTITY_ENDERDRAGON_GROWL, this.getSoundCategory(), 2.5f, 0.8f + this.rand.nextFloat() * 0.3f, false);
                    this.growlTime = 200 + this.rand.nextInt(200);
                }
            }
        }
        this.prevAnimTime = this.animTime;
        if (this.getHealth() <= 0.0f) {
            final float llIIIlIIllIlI = (this.rand.nextFloat() - 0.5f) * 8.0f;
            final float llIIIlIIllIIl = (this.rand.nextFloat() - 0.5f) * 4.0f;
            final float llIIIlIIllIII = (this.rand.nextFloat() - 0.5f) * 8.0f;
            this.world.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, this.posX + llIIIlIIllIlI, this.posY + 2.0 + llIIIlIIllIIl, this.posZ + llIIIlIIllIII, 0.0, 0.0, 0.0, new int[0]);
        }
        else {
            this.updateDragonEnderCrystal();
            float llIIIlIIlIlll = 0.2f / (MathHelper.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ) * 10.0f + 1.0f);
            llIIIlIIlIlll *= (float)Math.pow(2.0, this.motionY);
            if (this.phaseManager.getCurrentPhase().getIsStationary()) {
                this.animTime += 0.1f;
            }
            else if (this.slowed) {
                this.animTime += llIIIlIIlIlll * 0.5f;
            }
            else {
                this.animTime += llIIIlIIlIlll;
            }
            this.rotationYaw = MathHelper.wrapDegrees(this.rotationYaw);
            if (this.isAIDisabled()) {
                this.animTime = 0.5f;
            }
            else {
                if (this.ringBufferIndex < 0) {
                    for (int llIIIlIIlIllI = 0; llIIIlIIlIllI < this.ringBuffer.length; ++llIIIlIIlIllI) {
                        this.ringBuffer[llIIIlIIlIllI][0] = this.rotationYaw;
                        this.ringBuffer[llIIIlIIlIllI][1] = this.posY;
                    }
                }
                if (++this.ringBufferIndex == this.ringBuffer.length) {
                    this.ringBufferIndex = 0;
                }
                this.ringBuffer[this.ringBufferIndex][0] = this.rotationYaw;
                this.ringBuffer[this.ringBufferIndex][1] = this.posY;
                if (this.world.isRemote) {
                    if (this.newPosRotationIncrements > 0) {
                        final double llIIIlIIlIlIl = this.posX + (this.interpTargetX - this.posX) / this.newPosRotationIncrements;
                        final double llIIIlIIlIlII = this.posY + (this.interpTargetY - this.posY) / this.newPosRotationIncrements;
                        final double llIIIlIIlIIll = this.posZ + (this.interpTargetZ - this.posZ) / this.newPosRotationIncrements;
                        final double llIIIlIIlIIlI = MathHelper.wrapDegrees(this.interpTargetYaw - this.rotationYaw);
                        this.rotationYaw += (float)(llIIIlIIlIIlI / this.newPosRotationIncrements);
                        this.rotationPitch += (float)((this.interpTargetPitch - this.rotationPitch) / this.newPosRotationIncrements);
                        --this.newPosRotationIncrements;
                        this.setPosition(llIIIlIIlIlIl, llIIIlIIlIlII, llIIIlIIlIIll);
                        this.setRotation(this.rotationYaw, this.rotationPitch);
                    }
                    this.phaseManager.getCurrentPhase().doClientRenderEffects();
                }
                else {
                    IPhase llIIIlIIlIIIl = this.phaseManager.getCurrentPhase();
                    llIIIlIIlIIIl.doLocalUpdate();
                    if (this.phaseManager.getCurrentPhase() != llIIIlIIlIIIl) {
                        llIIIlIIlIIIl = this.phaseManager.getCurrentPhase();
                        llIIIlIIlIIIl.doLocalUpdate();
                    }
                    final Vec3d llIIIlIIlIIII = llIIIlIIlIIIl.getTargetLocation();
                    if (llIIIlIIlIIII != null) {
                        final double llIIIlIIIllll = llIIIlIIlIIII.xCoord - this.posX;
                        double llIIIlIIIlllI = llIIIlIIlIIII.yCoord - this.posY;
                        final double llIIIlIIIllIl = llIIIlIIlIIII.zCoord - this.posZ;
                        final double llIIIlIIIllII = llIIIlIIIllll * llIIIlIIIllll + llIIIlIIIlllI * llIIIlIIIlllI + llIIIlIIIllIl * llIIIlIIIllIl;
                        final float llIIIlIIIlIll = llIIIlIIlIIIl.getMaxRiseOrFall();
                        llIIIlIIIlllI = MathHelper.clamp(llIIIlIIIlllI / MathHelper.sqrt(llIIIlIIIllll * llIIIlIIIllll + llIIIlIIIllIl * llIIIlIIIllIl), -llIIIlIIIlIll, llIIIlIIIlIll);
                        this.motionY += llIIIlIIIlllI * 0.10000000149011612;
                        this.rotationYaw = MathHelper.wrapDegrees(this.rotationYaw);
                        final double llIIIlIIIlIlI = MathHelper.clamp(MathHelper.wrapDegrees(180.0 - MathHelper.atan2(llIIIlIIIllll, llIIIlIIIllIl) * 57.29577951308232 - this.rotationYaw), -50.0, 50.0);
                        final Vec3d llIIIlIIIlIIl = new Vec3d(llIIIlIIlIIII.xCoord - this.posX, llIIIlIIlIIII.yCoord - this.posY, llIIIlIIlIIII.zCoord - this.posZ).normalize();
                        final Vec3d llIIIlIIIlIII = new Vec3d(MathHelper.sin(this.rotationYaw * 0.017453292f), this.motionY, -MathHelper.cos(this.rotationYaw * 0.017453292f)).normalize();
                        final float llIIIlIIIIlll = Math.max(((float)llIIIlIIIlIII.dotProduct(llIIIlIIIlIIl) + 0.5f) / 1.5f, 0.0f);
                        this.randomYawVelocity *= 0.8f;
                        this.randomYawVelocity += (float)(llIIIlIIIlIlI * llIIIlIIlIIIl.getYawFactor());
                        this.rotationYaw += this.randomYawVelocity * 0.1f;
                        final float llIIIlIIIIllI = (float)(2.0 / (llIIIlIIIllII + 1.0));
                        final float llIIIlIIIIlIl = 0.06f;
                        this.func_191958_b(0.0f, 0.0f, -1.0f, 0.06f * (llIIIlIIIIlll * llIIIlIIIIllI + (1.0f - llIIIlIIIIllI)));
                        if (this.slowed) {
                            this.moveEntity(MoverType.SELF, this.motionX * 0.800000011920929, this.motionY * 0.800000011920929, this.motionZ * 0.800000011920929);
                        }
                        else {
                            this.moveEntity(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
                        }
                        final Vec3d llIIIlIIIIlII = new Vec3d(this.motionX, this.motionY, this.motionZ).normalize();
                        float llIIIlIIIIIll = ((float)llIIIlIIIIlII.dotProduct(llIIIlIIIlIII) + 1.0f) / 2.0f;
                        llIIIlIIIIIll = 0.8f + 0.15f * llIIIlIIIIIll;
                        this.motionX *= llIIIlIIIIIll;
                        this.motionZ *= llIIIlIIIIIll;
                        this.motionY *= 0.9100000262260437;
                    }
                }
                this.renderYawOffset = this.rotationYaw;
                this.dragonPartHead.width = 1.0f;
                this.dragonPartHead.height = 1.0f;
                this.dragonPartNeck.width = 3.0f;
                this.dragonPartNeck.height = 3.0f;
                this.dragonPartTail1.width = 2.0f;
                this.dragonPartTail1.height = 2.0f;
                this.dragonPartTail2.width = 2.0f;
                this.dragonPartTail2.height = 2.0f;
                this.dragonPartTail3.width = 2.0f;
                this.dragonPartTail3.height = 2.0f;
                this.dragonPartBody.height = 3.0f;
                this.dragonPartBody.width = 5.0f;
                this.dragonPartWing1.height = 2.0f;
                this.dragonPartWing1.width = 4.0f;
                this.dragonPartWing2.height = 3.0f;
                this.dragonPartWing2.width = 4.0f;
                final Vec3d[] llIIIlIIIIIlI = new Vec3d[this.dragonPartArray.length];
                for (int llIIIlIIIIIIl = 0; llIIIlIIIIIIl < this.dragonPartArray.length; ++llIIIlIIIIIIl) {
                    llIIIlIIIIIlI[llIIIlIIIIIIl] = new Vec3d(this.dragonPartArray[llIIIlIIIIIIl].posX, this.dragonPartArray[llIIIlIIIIIIl].posY, this.dragonPartArray[llIIIlIIIIIIl].posZ);
                }
                final float llIIIlIIIIIII = (float)(this.getMovementOffsets(5, 1.0f)[1] - this.getMovementOffsets(10, 1.0f)[1]) * 10.0f * 0.017453292f;
                final float llIIIIlllllll = MathHelper.cos(llIIIlIIIIIII);
                final float llIIIIllllllI = MathHelper.sin(llIIIlIIIIIII);
                final float llIIIIlllllIl = this.rotationYaw * 0.017453292f;
                final float llIIIIlllllII = MathHelper.sin(llIIIIlllllIl);
                final float llIIIIllllIll = MathHelper.cos(llIIIIlllllIl);
                this.dragonPartBody.onUpdate();
                this.dragonPartBody.setLocationAndAngles(this.posX + llIIIIlllllII * 0.5f, this.posY, this.posZ - llIIIIllllIll * 0.5f, 0.0f, 0.0f);
                this.dragonPartWing1.onUpdate();
                this.dragonPartWing1.setLocationAndAngles(this.posX + llIIIIllllIll * 4.5f, this.posY + 2.0, this.posZ + llIIIIlllllII * 4.5f, 0.0f, 0.0f);
                this.dragonPartWing2.onUpdate();
                this.dragonPartWing2.setLocationAndAngles(this.posX - llIIIIllllIll * 4.5f, this.posY + 2.0, this.posZ - llIIIIlllllII * 4.5f, 0.0f, 0.0f);
                if (!this.world.isRemote && this.hurtTime == 0) {
                    this.collideWithEntities(this.world.getEntitiesWithinAABBExcludingEntity(this, this.dragonPartWing1.getEntityBoundingBox().expand(4.0, 2.0, 4.0).offset(0.0, -2.0, 0.0)));
                    this.collideWithEntities(this.world.getEntitiesWithinAABBExcludingEntity(this, this.dragonPartWing2.getEntityBoundingBox().expand(4.0, 2.0, 4.0).offset(0.0, -2.0, 0.0)));
                    this.attackEntitiesInList(this.world.getEntitiesWithinAABBExcludingEntity(this, this.dragonPartHead.getEntityBoundingBox().expandXyz(1.0)));
                    this.attackEntitiesInList(this.world.getEntitiesWithinAABBExcludingEntity(this, this.dragonPartNeck.getEntityBoundingBox().expandXyz(1.0)));
                }
                final double[] llIIIIllllIlI = this.getMovementOffsets(5, 1.0f);
                final float llIIIIllllIIl = MathHelper.sin(this.rotationYaw * 0.017453292f - this.randomYawVelocity * 0.01f);
                final float llIIIIllllIII = MathHelper.cos(this.rotationYaw * 0.017453292f - this.randomYawVelocity * 0.01f);
                this.dragonPartHead.onUpdate();
                this.dragonPartNeck.onUpdate();
                final float llIIIIlllIlll = this.getHeadYOffset(1.0f);
                this.dragonPartHead.setLocationAndAngles(this.posX + llIIIIllllIIl * 6.5f * llIIIIlllllll, this.posY + llIIIIlllIlll + llIIIIllllllI * 6.5f, this.posZ - llIIIIllllIII * 6.5f * llIIIIlllllll, 0.0f, 0.0f);
                this.dragonPartNeck.setLocationAndAngles(this.posX + llIIIIllllIIl * 5.5f * llIIIIlllllll, this.posY + llIIIIlllIlll + llIIIIllllllI * 5.5f, this.posZ - llIIIIllllIII * 5.5f * llIIIIlllllll, 0.0f, 0.0f);
                for (int llIIIIlllIllI = 0; llIIIIlllIllI < 3; ++llIIIIlllIllI) {
                    MultiPartEntityPart llIIIIlllIlIl = null;
                    if (llIIIIlllIllI == 0) {
                        llIIIIlllIlIl = this.dragonPartTail1;
                    }
                    if (llIIIIlllIllI == 1) {
                        llIIIIlllIlIl = this.dragonPartTail2;
                    }
                    if (llIIIIlllIllI == 2) {
                        llIIIIlllIlIl = this.dragonPartTail3;
                    }
                    final double[] llIIIIlllIlII = this.getMovementOffsets(12 + llIIIIlllIllI * 2, 1.0f);
                    final float llIIIIlllIIll = this.rotationYaw * 0.017453292f + this.simplifyAngle(llIIIIlllIlII[0] - llIIIIllllIlI[0]) * 0.017453292f;
                    final float llIIIIlllIIlI = MathHelper.sin(llIIIIlllIIll);
                    final float llIIIIlllIIIl = MathHelper.cos(llIIIIlllIIll);
                    final float llIIIIlllIIII = 1.5f;
                    final float llIIIIllIllll = (llIIIIlllIllI + 1) * 2.0f;
                    llIIIIlllIlIl.onUpdate();
                    llIIIIlllIlIl.setLocationAndAngles(this.posX - (llIIIIlllllII * 1.5f + llIIIIlllIIlI * llIIIIllIllll) * llIIIIlllllll, this.posY + (llIIIIlllIlII[1] - llIIIIllllIlI[1]) - (llIIIIllIllll + 1.5f) * llIIIIllllllI + 1.5, this.posZ + (llIIIIllllIll * 1.5f + llIIIIlllIIIl * llIIIIllIllll) * llIIIIlllllll, 0.0f, 0.0f);
                }
                if (!this.world.isRemote) {
                    this.slowed = (this.destroyBlocksInAABB(this.dragonPartHead.getEntityBoundingBox()) | this.destroyBlocksInAABB(this.dragonPartNeck.getEntityBoundingBox()) | this.destroyBlocksInAABB(this.dragonPartBody.getEntityBoundingBox()));
                    if (this.fightManager != null) {
                        this.fightManager.dragonUpdate(this);
                    }
                }
                for (int llIIIIllIlllI = 0; llIIIIllIlllI < this.dragonPartArray.length; ++llIIIIllIlllI) {
                    this.dragonPartArray[llIIIIllIlllI].prevPosX = llIIIlIIIIIlI[llIIIIllIlllI].xCoord;
                    this.dragonPartArray[llIIIIllIlllI].prevPosY = llIIIlIIIIIlI[llIIIIllIlllI].yCoord;
                    this.dragonPartArray[llIIIIllIlllI].prevPosZ = llIIIlIIIIIlI[llIIIIllIlllI].zCoord;
                }
            }
        }
    }
    
    @Override
    public boolean isNonBoss() {
        return false;
    }
    
    @Override
    public World getWorld() {
        return this.world;
    }
    
    public double[] getMovementOffsets(final int llIIIlIlllIlI, float llIIIlIlllIIl) {
        if (this.getHealth() <= 0.0f) {
            llIIIlIlllIIl = 0.0f;
        }
        llIIIlIlllIIl = 1.0f - llIIIlIlllIIl;
        final int llIIIllIIIIII = this.ringBufferIndex - llIIIlIlllIlI & 0x3F;
        final int llIIIlIllllll = this.ringBufferIndex - llIIIlIlllIlI - 1 & 0x3F;
        final double[] llIIIlIlllllI = new double[3];
        double llIIIlIllllIl = this.ringBuffer[llIIIllIIIIII][0];
        double llIIIlIllllII = MathHelper.wrapDegrees(this.ringBuffer[llIIIlIllllll][0] - llIIIlIllllIl);
        llIIIlIlllllI[0] = llIIIlIllllIl + llIIIlIllllII * llIIIlIlllIIl;
        llIIIlIllllIl = this.ringBuffer[llIIIllIIIIII][1];
        llIIIlIllllII = this.ringBuffer[llIIIlIllllll][1] - llIIIlIllllIl;
        llIIIlIlllllI[1] = llIIIlIllllIl + llIIIlIllllII * llIIIlIlllIIl;
        llIIIlIlllllI[2] = this.ringBuffer[llIIIllIIIIII][2] + (this.ringBuffer[llIIIlIllllll][2] - this.ringBuffer[llIIIllIIIIII][2]) * llIIIlIlllIIl;
        return llIIIlIlllllI;
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound lIlllIIlIIIII) {
        super.readEntityFromNBT(lIlllIIlIIIII);
        if (lIlllIIlIIIII.hasKey("DragonPhase")) {
            this.phaseManager.setPhase(PhaseList.getById(lIlllIIlIIIII.getInteger("DragonPhase")));
        }
    }
    
    public float getHeadPartYOffset(final int lIllIlllllIll, final double[] lIllIlllllIlI, final double[] lIllIlllllIIl) {
        final IPhase lIlllIIIIIlII = this.phaseManager.getCurrentPhase();
        final PhaseList<? extends IPhase> lIlllIIIIIIll = lIlllIIIIIlII.getPhaseList();
        double lIllIllllllll = 0.0;
        if (lIlllIIIIIIll != PhaseList.LANDING && lIlllIIIIIIll != PhaseList.TAKEOFF) {
            if (lIlllIIIIIlII.getIsStationary()) {
                final double lIlllIIIIIIlI = lIllIlllllIll;
            }
            else if (lIllIlllllIll == 6) {
                final double lIlllIIIIIIIl = 0.0;
            }
            else {
                final double lIlllIIIIIIII = lIllIlllllIIl[1] - lIllIlllllIlI[1];
            }
        }
        else {
            final BlockPos lIllIlllllllI = this.world.getTopSolidOrLiquidBlock(WorldGenEndPodium.END_PODIUM_LOCATION);
            final float lIllIllllllIl = Math.max(MathHelper.sqrt(this.getDistanceSqToCenter(lIllIlllllllI)) / 4.0f, 1.0f);
            lIllIllllllll = lIllIlllllIll / lIllIllllllIl;
        }
        return (float)lIllIllllllll;
    }
    
    private void dropExperience(int lIllllIIlllll) {
        while (lIllllIIlllll > 0) {
            final int lIllllIlIIIIl = EntityXPOrb.getXPSplit(lIllllIIlllll);
            lIllllIIlllll -= lIllllIlIIIIl;
            this.world.spawnEntityInWorld(new EntityXPOrb(this.world, this.posX, this.posY, this.posZ, lIllllIlIIIIl));
        }
    }
    
    private Path makePath(final PathPoint lIlllIIlllIII, final PathPoint lIlllIIllIIlI) {
        int lIlllIIllIllI = 1;
        for (PathPoint lIlllIIllIlIl = lIlllIIllIIlI; lIlllIIllIlIl.previous != null; lIlllIIllIlIl = lIlllIIllIlIl.previous) {
            ++lIlllIIllIllI;
        }
        final PathPoint[] lIlllIIllIlII = new PathPoint[lIlllIIllIllI];
        PathPoint lIlllIIllIIll = lIlllIIllIIlI;
        --lIlllIIllIllI;
        lIlllIIllIlII[lIlllIIllIllI] = lIlllIIllIIlI;
        while (lIlllIIllIIll.previous != null) {
            lIlllIIllIIll = lIlllIIllIIll.previous;
            --lIlllIIllIllI;
            lIlllIIllIlII[lIlllIIllIllI] = lIlllIIllIIll;
        }
        return new Path(lIlllIIllIlII);
    }
    
    private boolean destroyBlocksInAABB(final AxisAlignedBB lIllllllIIlll) {
        final int lIllllllllIIl = MathHelper.floor(lIllllllIIlll.minX);
        final int lIllllllllIII = MathHelper.floor(lIllllllIIlll.minY);
        final int lIlllllllIlll = MathHelper.floor(lIllllllIIlll.minZ);
        final int lIlllllllIllI = MathHelper.floor(lIllllllIIlll.maxX);
        final int lIlllllllIlIl = MathHelper.floor(lIllllllIIlll.maxY);
        final int lIlllllllIlII = MathHelper.floor(lIllllllIIlll.maxZ);
        boolean lIlllllllIIll = false;
        boolean lIlllllllIIlI = false;
        for (int lIlllllllIIIl = lIllllllllIIl; lIlllllllIIIl <= lIlllllllIllI; ++lIlllllllIIIl) {
            for (int lIlllllllIIII = lIllllllllIII; lIlllllllIIII <= lIlllllllIlIl; ++lIlllllllIIII) {
                for (int lIllllllIllll = lIlllllllIlll; lIllllllIllll <= lIlllllllIlII; ++lIllllllIllll) {
                    final BlockPos lIllllllIlllI = new BlockPos(lIlllllllIIIl, lIlllllllIIII, lIllllllIllll);
                    final IBlockState lIllllllIllIl = this.world.getBlockState(lIllllllIlllI);
                    final Block lIllllllIllII = lIllllllIllIl.getBlock();
                    if (lIllllllIllIl.getMaterial() != Material.AIR && lIllllllIllIl.getMaterial() != Material.FIRE) {
                        if (!this.world.getGameRules().getBoolean("mobGriefing")) {
                            lIlllllllIIll = true;
                        }
                        else if (lIllllllIllII != Blocks.BARRIER && lIllllllIllII != Blocks.OBSIDIAN && lIllllllIllII != Blocks.END_STONE && lIllllllIllII != Blocks.BEDROCK && lIllllllIllII != Blocks.END_PORTAL && lIllllllIllII != Blocks.END_PORTAL_FRAME) {
                            if (lIllllllIllII != Blocks.COMMAND_BLOCK && lIllllllIllII != Blocks.REPEATING_COMMAND_BLOCK && lIllllllIllII != Blocks.CHAIN_COMMAND_BLOCK && lIllllllIllII != Blocks.IRON_BARS && lIllllllIllII != Blocks.END_GATEWAY) {
                                lIlllllllIIlI = (this.world.setBlockToAir(lIllllllIlllI) || lIlllllllIIlI);
                            }
                            else {
                                lIlllllllIIll = true;
                            }
                        }
                        else {
                            lIlllllllIIll = true;
                        }
                    }
                }
            }
        }
        if (lIlllllllIIlI) {
            final double lIllllllIlIll = lIllllllIIlll.minX + (lIllllllIIlll.maxX - lIllllllIIlll.minX) * this.rand.nextFloat();
            final double lIllllllIlIlI = lIllllllIIlll.minY + (lIllllllIIlll.maxY - lIllllllIIlll.minY) * this.rand.nextFloat();
            final double lIllllllIlIIl = lIllllllIIlll.minZ + (lIllllllIIlll.maxZ - lIllllllIIlll.minZ) * this.rand.nextFloat();
            this.world.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, lIllllllIlIll, lIllllllIlIlI, lIllllllIlIIl, 0.0, 0.0, 0.0, new int[0]);
        }
        return lIlllllllIIll;
    }
    
    public static void registerFixesDragon(final DataFixer lIlllIIlIllIl) {
        EntityLiving.registerFixesMob(lIlllIIlIllIl, EntityDragon.class);
    }
    
    @Override
    public Entity[] getParts() {
        return this.dragonPartArray;
    }
    
    @Nullable
    public Path findPath(final int lIlllIlIllIIl, final int lIlllIlIllIII, @Nullable final PathPoint lIlllIlIlIlll) {
        for (int lIlllIlIlIllI = 0; lIlllIlIlIllI < 24; ++lIlllIlIlIllI) {
            final PathPoint lIlllIlIlIlIl = this.pathPoints[lIlllIlIlIllI];
            lIlllIlIlIlIl.visited = false;
            lIlllIlIlIlIl.distanceToTarget = 0.0f;
            lIlllIlIlIlIl.totalPathDistance = 0.0f;
            lIlllIlIlIlIl.distanceToNext = 0.0f;
            lIlllIlIlIlIl.previous = null;
            lIlllIlIlIlIl.index = -1;
        }
        final PathPoint lIlllIlIlIlII = this.pathPoints[lIlllIlIllIIl];
        PathPoint lIlllIlIlIIll = this.pathPoints[lIlllIlIllIII];
        lIlllIlIlIlII.totalPathDistance = 0.0f;
        lIlllIlIlIlII.distanceToNext = lIlllIlIlIlII.distanceTo(lIlllIlIlIIll);
        lIlllIlIlIlII.distanceToTarget = lIlllIlIlIlII.distanceToNext;
        this.pathFindQueue.clearPath();
        this.pathFindQueue.addPoint(lIlllIlIlIlII);
        PathPoint lIlllIlIlIIlI = lIlllIlIlIlII;
        int lIlllIlIlIIIl = 0;
        if (this.fightManager == null || this.fightManager.getNumAliveCrystals() == 0) {
            lIlllIlIlIIIl = 12;
        }
        while (!this.pathFindQueue.isPathEmpty()) {
            final PathPoint lIlllIlIlIIII = this.pathFindQueue.dequeue();
            if (lIlllIlIlIIII.equals(lIlllIlIlIIll)) {
                if (lIlllIlIlIlll != null) {
                    lIlllIlIlIlll.previous = lIlllIlIlIIll;
                    lIlllIlIlIIll = lIlllIlIlIlll;
                }
                return this.makePath(lIlllIlIlIlII, lIlllIlIlIIll);
            }
            if (lIlllIlIlIIII.distanceTo(lIlllIlIlIIll) < lIlllIlIlIIlI.distanceTo(lIlllIlIlIIll)) {
                lIlllIlIlIIlI = lIlllIlIlIIII;
            }
            lIlllIlIlIIII.visited = true;
            int lIlllIlIIllll = 0;
            for (int lIlllIlIIlllI = 0; lIlllIlIIlllI < 24; ++lIlllIlIIlllI) {
                if (this.pathPoints[lIlllIlIIlllI] == lIlllIlIlIIII) {
                    lIlllIlIIllll = lIlllIlIIlllI;
                    break;
                }
            }
            for (int lIlllIlIIllIl = lIlllIlIlIIIl; lIlllIlIIllIl < 24; ++lIlllIlIIllIl) {
                if ((this.neighbors[lIlllIlIIllll] & 1 << lIlllIlIIllIl) > 0) {
                    final PathPoint lIlllIlIIllII = this.pathPoints[lIlllIlIIllIl];
                    if (!lIlllIlIIllII.visited) {
                        final float lIlllIlIIlIll = lIlllIlIlIIII.totalPathDistance + lIlllIlIlIIII.distanceTo(lIlllIlIIllII);
                        if (!lIlllIlIIllII.isAssigned() || lIlllIlIIlIll < lIlllIlIIllII.totalPathDistance) {
                            lIlllIlIIllII.previous = lIlllIlIlIIII;
                            lIlllIlIIllII.totalPathDistance = lIlllIlIIlIll;
                            lIlllIlIIllII.distanceToNext = lIlllIlIIllII.distanceTo(lIlllIlIlIIll);
                            if (lIlllIlIIllII.isAssigned()) {
                                this.pathFindQueue.changeDistance(lIlllIlIIllII, lIlllIlIIllII.totalPathDistance + lIlllIlIIllII.distanceToNext);
                            }
                            else {
                                lIlllIlIIllII.distanceToTarget = lIlllIlIIllII.totalPathDistance + lIlllIlIIllII.distanceToNext;
                                this.pathFindQueue.addPoint(lIlllIlIIllII);
                            }
                        }
                    }
                }
            }
        }
        if (lIlllIlIlIIlI == lIlllIlIlIlII) {
            return null;
        }
        EntityDragon.LOGGER.debug("Failed to find path from {} to {}", (Object)lIlllIlIllIIl, (Object)lIlllIlIllIII);
        if (lIlllIlIlIlll != null) {
            lIlllIlIlIlll.previous = lIlllIlIlIIlI;
            lIlllIlIlIIlI = lIlllIlIlIlll;
        }
        return this.makePath(lIlllIlIlIlII, lIlllIlIlIIlI);
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound lIlllIIlIlIII) {
        super.writeEntityToNBT(lIlllIIlIlIII);
        lIlllIIlIlIII.setInteger("DragonPhase", this.phaseManager.getCurrentPhase().getPhaseList().getId());
    }
    
    protected boolean attackDragonFrom(final DamageSource lIllllIlllIIl, final float lIllllIlllIII) {
        return super.attackEntityFrom(lIllllIlllIIl, lIllllIlllIII);
    }
    
    @Override
    public void onKillCommand() {
        this.setDead();
        if (this.fightManager != null) {
            this.fightManager.dragonUpdate(this);
            this.fightManager.processDragonDeath(this);
        }
    }
    
    private void collideWithEntities(final List<Entity> llIIIIIlIlIll) {
        final double llIIIIIlIlIlI = (this.dragonPartBody.getEntityBoundingBox().minX + this.dragonPartBody.getEntityBoundingBox().maxX) / 2.0;
        final double llIIIIIlIlIIl = (this.dragonPartBody.getEntityBoundingBox().minZ + this.dragonPartBody.getEntityBoundingBox().maxZ) / 2.0;
        for (final Entity llIIIIIlIlIII : llIIIIIlIlIll) {
            if (llIIIIIlIlIII instanceof EntityLivingBase) {
                final double llIIIIIlIIlll = llIIIIIlIlIII.posX - llIIIIIlIlIlI;
                final double llIIIIIlIIllI = llIIIIIlIlIII.posZ - llIIIIIlIlIIl;
                final double llIIIIIlIIlIl = llIIIIIlIIlll * llIIIIIlIIlll + llIIIIIlIIllI * llIIIIIlIIllI;
                llIIIIIlIlIII.addVelocity(llIIIIIlIIlll / llIIIIIlIIlIl * 4.0, 0.20000000298023224, llIIIIIlIIllI / llIIIIIlIIlIl * 4.0);
                if (this.phaseManager.getCurrentPhase().getIsStationary() || ((EntityLivingBase)llIIIIIlIlIII).getRevengeTimer() >= llIIIIIlIlIII.ticksExisted - 2) {
                    continue;
                }
                llIIIIIlIlIII.attackEntityFrom(DamageSource.causeMobDamage(this), 5.0f);
                this.applyEnchantments(this, llIIIIIlIlIII);
            }
        }
    }
    
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_ENDERDRAGON_AMBIENT;
    }
    
    public PhaseManager getPhaseManager() {
        return this.phaseManager;
    }
    
    public EntityDragon(final World llIIIllIlIlII) {
        super(llIIIllIlIlII);
        this.ringBuffer = new double[64][3];
        this.ringBufferIndex = -1;
        this.dragonPartHead = new MultiPartEntityPart(this, "head", 6.0f, 6.0f);
        this.dragonPartNeck = new MultiPartEntityPart(this, "neck", 6.0f, 6.0f);
        this.dragonPartBody = new MultiPartEntityPart(this, "body", 8.0f, 8.0f);
        this.dragonPartTail1 = new MultiPartEntityPart(this, "tail", 4.0f, 4.0f);
        this.dragonPartTail2 = new MultiPartEntityPart(this, "tail", 4.0f, 4.0f);
        this.dragonPartTail3 = new MultiPartEntityPart(this, "tail", 4.0f, 4.0f);
        this.dragonPartWing1 = new MultiPartEntityPart(this, "wing", 4.0f, 4.0f);
        this.dragonPartWing2 = new MultiPartEntityPart(this, "wing", 4.0f, 4.0f);
        this.growlTime = 200;
        this.pathPoints = new PathPoint[24];
        this.neighbors = new int[24];
        this.pathFindQueue = new PathHeap();
        this.dragonPartArray = new MultiPartEntityPart[] { this.dragonPartHead, this.dragonPartNeck, this.dragonPartBody, this.dragonPartTail1, this.dragonPartTail2, this.dragonPartTail3, this.dragonPartWing1, this.dragonPartWing2 };
        this.setHealth(this.getMaxHealth());
        this.setSize(16.0f, 8.0f);
        this.noClip = true;
        this.isImmuneToFire = true;
        this.growlTime = 100;
        this.ignoreFrustumCheck = true;
        if (!llIIIllIlIlII.isRemote && llIIIllIlIlII.provider instanceof WorldProviderEnd) {
            this.fightManager = ((WorldProviderEnd)llIIIllIlIlII.provider).getDragonFightManager();
        }
        else {
            this.fightManager = null;
        }
        this.phaseManager = new PhaseManager(this);
    }
    
    @Override
    protected boolean canBeRidden(final Entity lIllIlIllIIlI) {
        return false;
    }
    
    @Override
    protected SoundEvent getHurtSound(final DamageSource lIlllIIIlIlII) {
        return SoundEvents.ENTITY_ENDERDRAGON_HURT;
    }
    
    private void attackEntitiesInList(final List<Entity> llIIIIIIlIllI) {
        for (int llIIIIIIlIlIl = 0; llIIIIIIlIlIl < llIIIIIIlIllI.size(); ++llIIIIIIlIlIl) {
            final Entity llIIIIIIlIlII = llIIIIIIlIllI.get(llIIIIIIlIlIl);
            if (llIIIIIIlIlII instanceof EntityLivingBase) {
                llIIIIIIlIlII.attackEntityFrom(DamageSource.causeMobDamage(this), 10.0f);
                this.applyEnchantments(this, llIIIIIIlIlII);
            }
        }
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(200.0);
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.getDataManager().register(EntityDragon.PHASE, PhaseList.HOVER.getId());
    }
    
    static {
        LOGGER = LogManager.getLogger();
        PHASE = EntityDataManager.createKey(EntityDragon.class, DataSerializers.VARINT);
    }
    
    @Nullable
    @Override
    protected ResourceLocation getLootTable() {
        return LootTableList.field_191189_ay;
    }
    
    @Nullable
    public DragonFightManager getFightManager() {
        return this.fightManager;
    }
    
    private void updateDragonEnderCrystal() {
        if (this.healingEnderCrystal != null) {
            if (this.healingEnderCrystal.isDead) {
                this.healingEnderCrystal = null;
            }
            else if (this.ticksExisted % 10 == 0 && this.getHealth() < this.getMaxHealth()) {
                this.setHealth(this.getHealth() + 1.0f);
            }
        }
        if (this.rand.nextInt(10) == 0) {
            final List<EntityEnderCrystal> llIIIIlIIIIIl = this.world.getEntitiesWithinAABB((Class<? extends EntityEnderCrystal>)EntityEnderCrystal.class, this.getEntityBoundingBox().expandXyz(32.0));
            EntityEnderCrystal llIIIIlIIIIII = null;
            double llIIIIIllllll = Double.MAX_VALUE;
            for (final EntityEnderCrystal llIIIIIlllllI : llIIIIlIIIIIl) {
                final double llIIIIIllllIl = llIIIIIlllllI.getDistanceSqToEntity(this);
                if (llIIIIIllllIl < llIIIIIllllll) {
                    llIIIIIllllll = llIIIIIllllIl;
                    llIIIIlIIIIII = llIIIIIlllllI;
                }
            }
            this.healingEnderCrystal = llIIIIlIIIIII;
        }
    }
    
    @Override
    protected void onDeathUpdate() {
        if (this.fightManager != null) {
            this.fightManager.dragonUpdate(this);
        }
        ++this.deathTicks;
        if (this.deathTicks >= 180 && this.deathTicks <= 200) {
            final float lIllllIlIllll = (this.rand.nextFloat() - 0.5f) * 8.0f;
            final float lIllllIlIlllI = (this.rand.nextFloat() - 0.5f) * 4.0f;
            final float lIllllIlIllIl = (this.rand.nextFloat() - 0.5f) * 8.0f;
            this.world.spawnParticle(EnumParticleTypes.EXPLOSION_HUGE, this.posX + lIllllIlIllll, this.posY + 2.0 + lIllllIlIlllI, this.posZ + lIllllIlIllIl, 0.0, 0.0, 0.0, new int[0]);
        }
        final boolean lIllllIlIllII = this.world.getGameRules().getBoolean("doMobLoot");
        int lIllllIlIlIll = 500;
        if (this.fightManager != null && !this.fightManager.hasPreviouslyKilledDragon()) {
            lIllllIlIlIll = 12000;
        }
        if (!this.world.isRemote) {
            if (this.deathTicks > 150 && this.deathTicks % 5 == 0 && lIllllIlIllII) {
                this.dropExperience(MathHelper.floor(lIllllIlIlIll * 0.08f));
            }
            if (this.deathTicks == 1) {
                this.world.playBroadcastSound(1028, new BlockPos(this), 0);
            }
        }
        this.moveEntity(MoverType.SELF, 0.0, 0.10000000149011612, 0.0);
        this.rotationYaw += 20.0f;
        this.renderYawOffset = this.rotationYaw;
        if (this.deathTicks == 200 && !this.world.isRemote) {
            if (lIllllIlIllII) {
                this.dropExperience(MathHelper.floor(lIllllIlIlIll * 0.2f));
            }
            if (this.fightManager != null) {
                this.fightManager.processDragonDeath(this);
            }
            this.setDead();
        }
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource lIlllllIIIlIl, final float lIlllllIIIlII) {
        if (lIlllllIIIlIl instanceof EntityDamageSource && ((EntityDamageSource)lIlllllIIIlIl).getIsThornsDamage()) {
            this.attackEntityFromPart(this.dragonPartBody, lIlllllIIIlIl, lIlllllIIIlII);
        }
        return false;
    }
    
    public void onCrystalDestroyed(final EntityEnderCrystal lIllIllIIIlIl, final BlockPos lIllIllIIIlII, final DamageSource lIllIllIIlIIl) {
        EntityPlayer lIllIllIIIlll = null;
        if (lIllIllIIlIIl.getEntity() instanceof EntityPlayer) {
            final EntityPlayer lIllIllIIlIII = (EntityPlayer)lIllIllIIlIIl.getEntity();
        }
        else {
            lIllIllIIIlll = this.world.getNearestAttackablePlayer(lIllIllIIIlII, 64.0, 64.0);
        }
        if (lIllIllIIIlIl == this.healingEnderCrystal) {
            this.attackEntityFromPart(this.dragonPartHead, DamageSource.causeExplosionDamage(lIllIllIIIlll), 10.0f);
        }
        this.phaseManager.getCurrentPhase().onCrystalDestroyed(lIllIllIIIlIl, lIllIllIIIlII, lIllIllIIlIIl, lIllIllIIIlll);
    }
    
    @Override
    protected float getSoundVolume() {
        return 5.0f;
    }
    
    private float getHeadYOffset(final float llIIIIlIlIIlI) {
        double llIIIIlIlIIII = 0.0;
        if (this.phaseManager.getCurrentPhase().getIsStationary()) {
            final double llIIIIlIlIIIl = -1.0;
        }
        else {
            final double[] llIIIIlIIllll = this.getMovementOffsets(5, 1.0f);
            final double[] llIIIIlIIlllI = this.getMovementOffsets(0, 1.0f);
            llIIIIlIlIIII = llIIIIlIIllll[1] - llIIIIlIIlllI[1];
        }
        return (float)llIIIIlIlIIII;
    }
    
    public Vec3d getHeadLookVec(final float lIllIlllIlIII) {
        final IPhase lIllIlllIIlll = this.phaseManager.getCurrentPhase();
        final PhaseList<? extends IPhase> lIllIlllIIllI = lIllIlllIIlll.getPhaseList();
        Vec3d lIllIlllIIIll = null;
        if (lIllIlllIIllI != PhaseList.LANDING && lIllIlllIIllI != PhaseList.TAKEOFF) {
            if (lIllIlllIIlll.getIsStationary()) {
                final float lIllIlllIIIlI = this.rotationPitch;
                final float lIllIlllIIIIl = 1.5f;
                this.rotationPitch = -45.0f;
                final Vec3d lIllIlllIIlIl = this.getLook(lIllIlllIlIII);
                this.rotationPitch = lIllIlllIIIlI;
            }
            else {
                final Vec3d lIllIlllIIlII = this.getLook(lIllIlllIlIII);
            }
        }
        else {
            final BlockPos lIllIlllIIIII = this.world.getTopSolidOrLiquidBlock(WorldGenEndPodium.END_PODIUM_LOCATION);
            final float lIllIllIlllll = Math.max(MathHelper.sqrt(this.getDistanceSqToCenter(lIllIlllIIIII)) / 4.0f, 1.0f);
            final float lIllIllIllllI = 6.0f / lIllIllIlllll;
            final float lIllIllIlllIl = this.rotationPitch;
            final float lIllIllIlllII = 1.5f;
            this.rotationPitch = -lIllIllIllllI * 1.5f * 5.0f;
            lIllIlllIIIll = this.getLook(lIllIlllIlIII);
            this.rotationPitch = lIllIllIlllIl;
        }
        return lIllIlllIIIll;
    }
    
    @Override
    public void addPotionEffect(final PotionEffect lIllIlIllIlII) {
    }
    
    @Override
    public boolean attackEntityFromPart(final MultiPartEntityPart lIlllllIIllIl, final DamageSource lIlllllIIllII, float lIlllllIIlIll) {
        lIlllllIIlIll = this.phaseManager.getCurrentPhase().getAdjustedDamage(lIlllllIIllIl, lIlllllIIllII, lIlllllIIlIll);
        if (lIlllllIIllIl != this.dragonPartHead) {
            lIlllllIIlIll = lIlllllIIlIll / 4.0f + Math.min(lIlllllIIlIll, 1.0f);
        }
        if (lIlllllIIlIll < 0.01f) {
            return false;
        }
        if (lIlllllIIllII.getEntity() instanceof EntityPlayer || lIlllllIIllII.isExplosion()) {
            final float lIlllllIIllll = this.getHealth();
            this.attackDragonFrom(lIlllllIIllII, lIlllllIIlIll);
            if (this.getHealth() <= 0.0f && !this.phaseManager.getCurrentPhase().getIsStationary()) {
                this.setHealth(1.0f);
                this.phaseManager.setPhase(PhaseList.DYING);
            }
            if (this.phaseManager.getCurrentPhase().getIsStationary()) {
                this.sittingDamageReceived += (int)(lIlllllIIllll - this.getHealth());
                if (this.sittingDamageReceived > 0.25f * this.getMaxHealth()) {
                    this.sittingDamageReceived = 0;
                    this.phaseManager.setPhase(PhaseList.TAKEOFF);
                }
            }
        }
        return true;
    }
}
