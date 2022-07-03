package net.minecraft.entity.boss;

import net.minecraft.entity.monster.*;
import net.minecraft.util.math.*;
import com.google.common.base.*;
import net.minecraft.block.material.*;
import java.util.*;
import net.minecraft.block.state.*;
import net.minecraft.block.*;
import net.minecraft.entity.ai.*;
import net.minecraft.world.*;
import net.minecraft.pathfinding.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.datafix.*;
import net.minecraft.potion.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.entity.item.*;
import net.minecraft.nbt.*;
import net.minecraft.network.datasync.*;
import javax.annotation.*;
import net.minecraft.entity.projectile.*;

public class EntityWither extends EntityMob implements IRangedAttackMob
{
    private static final /* synthetic */ DataParameter<Integer>[] HEAD_TARGETS;
    private static final /* synthetic */ DataParameter<Integer> FIRST_HEAD_TARGET;
    private final /* synthetic */ int[] idleHeadUpdates;
    private final /* synthetic */ float[] yRotOHeads;
    private final /* synthetic */ float[] yRotationHeads;
    private final /* synthetic */ float[] xRotOHeads;
    private static final /* synthetic */ Predicate<Entity> NOT_UNDEAD;
    private static final /* synthetic */ DataParameter<Integer> SECOND_HEAD_TARGET;
    private static final /* synthetic */ DataParameter<Integer> THIRD_HEAD_TARGET;
    private final /* synthetic */ float[] xRotationHeads;
    private final /* synthetic */ BossInfoServer bossInfo;
    private static final /* synthetic */ DataParameter<Integer> INVULNERABILITY_TIME;
    private /* synthetic */ int blockBreakCounter;
    private final /* synthetic */ int[] nextHeadUpdate;
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(300.0);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.6000000238418579);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(40.0);
        this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(4.0);
    }
    
    @Override
    protected void updateAITasks() {
        if (this.getInvulTime() > 0) {
            final int llllllllllllIllllllIlIlIIllllllI = this.getInvulTime() - 1;
            if (llllllllllllIllllllIlIlIIllllllI <= 0) {
                this.world.newExplosion(this, this.posX, this.posY + this.getEyeHeight(), this.posZ, 7.0f, false, this.world.getGameRules().getBoolean("mobGriefing"));
                this.world.playBroadcastSound(1023, new BlockPos(this), 0);
            }
            this.setInvulTime(llllllllllllIllllllIlIlIIllllllI);
            if (this.ticksExisted % 10 == 0) {
                this.heal(10.0f);
            }
        }
        else {
            super.updateAITasks();
            for (int llllllllllllIllllllIlIlIIlllllIl = 1; llllllllllllIllllllIlIlIIlllllIl < 3; ++llllllllllllIllllllIlIlIIlllllIl) {
                if (this.ticksExisted >= this.nextHeadUpdate[llllllllllllIllllllIlIlIIlllllIl - 1]) {
                    this.nextHeadUpdate[llllllllllllIllllllIlIlIIlllllIl - 1] = this.ticksExisted + 10 + this.rand.nextInt(10);
                    if (this.world.getDifficulty() == EnumDifficulty.NORMAL || this.world.getDifficulty() == EnumDifficulty.HARD) {
                        final int llllllllllllIllllllIlIlIIlllllII = llllllllllllIllllllIlIlIIlllllIl - 1;
                        final int llllllllllllIllllllIlIlIIllllIll = this.idleHeadUpdates[llllllllllllIllllllIlIlIIlllllIl - 1];
                        this.idleHeadUpdates[llllllllllllIllllllIlIlIIlllllII] = this.idleHeadUpdates[llllllllllllIllllllIlIlIIlllllIl - 1] + 1;
                        if (llllllllllllIllllllIlIlIIllllIll > 15) {
                            final float llllllllllllIllllllIlIlIIllllIlI = 10.0f;
                            final float llllllllllllIllllllIlIlIIllllIIl = 5.0f;
                            final double llllllllllllIllllllIlIlIIllllIII = MathHelper.nextDouble(this.rand, this.posX - 10.0, this.posX + 10.0);
                            final double llllllllllllIllllllIlIlIIlllIlll = MathHelper.nextDouble(this.rand, this.posY - 5.0, this.posY + 5.0);
                            final double llllllllllllIllllllIlIlIIlllIllI = MathHelper.nextDouble(this.rand, this.posZ - 10.0, this.posZ + 10.0);
                            this.launchWitherSkullToCoords(llllllllllllIllllllIlIlIIlllllIl + 1, llllllllllllIllllllIlIlIIllllIII, llllllllllllIllllllIlIlIIlllIlll, llllllllllllIllllllIlIlIIlllIllI, true);
                            this.idleHeadUpdates[llllllllllllIllllllIlIlIIlllllIl - 1] = 0;
                        }
                    }
                    final int llllllllllllIllllllIlIlIIlllIlIl = this.getWatchedTargetId(llllllllllllIllllllIlIlIIlllllIl);
                    if (llllllllllllIllllllIlIlIIlllIlIl > 0) {
                        final Entity llllllllllllIllllllIlIlIIlllIlII = this.world.getEntityByID(llllllllllllIllllllIlIlIIlllIlIl);
                        if (llllllllllllIllllllIlIlIIlllIlII != null && llllllllllllIllllllIlIlIIlllIlII.isEntityAlive() && this.getDistanceSqToEntity(llllllllllllIllllllIlIlIIlllIlII) <= 900.0 && this.canEntityBeSeen(llllllllllllIllllllIlIlIIlllIlII)) {
                            if (llllllllllllIllllllIlIlIIlllIlII instanceof EntityPlayer && ((EntityPlayer)llllllllllllIllllllIlIlIIlllIlII).capabilities.disableDamage) {
                                this.updateWatchedTargetId(llllllllllllIllllllIlIlIIlllllIl, 0);
                            }
                            else {
                                this.launchWitherSkullToEntity(llllllllllllIllllllIlIlIIlllllIl + 1, (EntityLivingBase)llllllllllllIllllllIlIlIIlllIlII);
                                this.nextHeadUpdate[llllllllllllIllllllIlIlIIlllllIl - 1] = this.ticksExisted + 40 + this.rand.nextInt(20);
                                this.idleHeadUpdates[llllllllllllIllllllIlIlIIlllllIl - 1] = 0;
                            }
                        }
                        else {
                            this.updateWatchedTargetId(llllllllllllIllllllIlIlIIlllllIl, 0);
                        }
                    }
                    else {
                        final List<EntityLivingBase> llllllllllllIllllllIlIlIIlllIIll = this.world.getEntitiesWithinAABB((Class<? extends EntityLivingBase>)EntityLivingBase.class, this.getEntityBoundingBox().expand(20.0, 8.0, 20.0), (com.google.common.base.Predicate<? super EntityLivingBase>)Predicates.and((Predicate)EntityWither.NOT_UNDEAD, (Predicate)EntitySelectors.NOT_SPECTATING));
                        int llllllllllllIllllllIlIlIIlllIIlI = 0;
                        while (llllllllllllIllllllIlIlIIlllIIlI < 10 && !llllllllllllIllllllIlIlIIlllIIll.isEmpty()) {
                            final EntityLivingBase llllllllllllIllllllIlIlIIlllIIIl = llllllllllllIllllllIlIlIIlllIIll.get(this.rand.nextInt(llllllllllllIllllllIlIlIIlllIIll.size()));
                            if (llllllllllllIllllllIlIlIIlllIIIl != this && llllllllllllIllllllIlIlIIlllIIIl.isEntityAlive() && this.canEntityBeSeen(llllllllllllIllllllIlIlIIlllIIIl)) {
                                if (!(llllllllllllIllllllIlIlIIlllIIIl instanceof EntityPlayer)) {
                                    this.updateWatchedTargetId(llllllllllllIllllllIlIlIIlllllIl, llllllllllllIllllllIlIlIIlllIIIl.getEntityId());
                                    break;
                                }
                                if (!((EntityPlayer)llllllllllllIllllllIlIlIIlllIIIl).capabilities.disableDamage) {
                                    this.updateWatchedTargetId(llllllllllllIllllllIlIlIIlllllIl, llllllllllllIllllllIlIlIIlllIIIl.getEntityId());
                                    break;
                                }
                                break;
                            }
                            else {
                                llllllllllllIllllllIlIlIIlllIIll.remove(llllllllllllIllllllIlIlIIlllIIIl);
                                ++llllllllllllIllllllIlIlIIlllIIlI;
                            }
                        }
                    }
                }
            }
            if (this.getAttackTarget() != null) {
                this.updateWatchedTargetId(0, this.getAttackTarget().getEntityId());
            }
            else {
                this.updateWatchedTargetId(0, 0);
            }
            if (this.blockBreakCounter > 0) {
                --this.blockBreakCounter;
                if (this.blockBreakCounter == 0 && this.world.getGameRules().getBoolean("mobGriefing")) {
                    final int llllllllllllIllllllIlIlIIlllIIII = MathHelper.floor(this.posY);
                    final int llllllllllllIllllllIlIlIIllIllll = MathHelper.floor(this.posX);
                    final int llllllllllllIllllllIlIlIIllIlllI = MathHelper.floor(this.posZ);
                    boolean llllllllllllIllllllIlIlIIllIllIl = false;
                    for (int llllllllllllIllllllIlIlIIllIllII = -1; llllllllllllIllllllIlIlIIllIllII <= 1; ++llllllllllllIllllllIlIlIIllIllII) {
                        for (int llllllllllllIllllllIlIlIIllIlIll = -1; llllllllllllIllllllIlIlIIllIlIll <= 1; ++llllllllllllIllllllIlIlIIllIlIll) {
                            for (int llllllllllllIllllllIlIlIIllIlIlI = 0; llllllllllllIllllllIlIlIIllIlIlI <= 3; ++llllllllllllIllllllIlIlIIllIlIlI) {
                                final int llllllllllllIllllllIlIlIIllIlIIl = llllllllllllIllllllIlIlIIllIllll + llllllllllllIllllllIlIlIIllIllII;
                                final int llllllllllllIllllllIlIlIIllIlIII = llllllllllllIllllllIlIlIIlllIIII + llllllllllllIllllllIlIlIIllIlIlI;
                                final int llllllllllllIllllllIlIlIIllIIlll = llllllllllllIllllllIlIlIIllIlllI + llllllllllllIllllllIlIlIIllIlIll;
                                final BlockPos llllllllllllIllllllIlIlIIllIIllI = new BlockPos(llllllllllllIllllllIlIlIIllIlIIl, llllllllllllIllllllIlIlIIllIlIII, llllllllllllIllllllIlIlIIllIIlll);
                                final IBlockState llllllllllllIllllllIlIlIIllIIlIl = this.world.getBlockState(llllllllllllIllllllIlIlIIllIIllI);
                                final Block llllllllllllIllllllIlIlIIllIIlII = llllllllllllIllllllIlIlIIllIIlIl.getBlock();
                                if (llllllllllllIllllllIlIlIIllIIlIl.getMaterial() != Material.AIR && canDestroyBlock(llllllllllllIllllllIlIlIIllIIlII)) {
                                    llllllllllllIllllllIlIlIIllIllIl = (this.world.destroyBlock(llllllllllllIllllllIlIlIIllIIllI, true) || llllllllllllIllllllIlIlIIllIllIl);
                                }
                            }
                        }
                    }
                    if (llllllllllllIllllllIlIlIIllIllIl) {
                        this.world.playEvent(null, 1022, new BlockPos(this), 0);
                    }
                }
            }
            if (this.ticksExisted % 20 == 0) {
                this.heal(1.0f);
            }
            this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
        }
    }
    
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_WITHER_AMBIENT;
    }
    
    @Override
    protected void initEntityAI() {
        this.tasks.addTask(0, new AIDoNothing());
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIAttackRanged(this, 1.0, 40, 20.0f));
        this.tasks.addTask(5, new EntityAIWanderAvoidWater(this, 1.0));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0f));
        this.tasks.addTask(7, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false, (Class<?>[])new Class[0]));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget<Object>(this, EntityLiving.class, 0, false, false, EntityWither.NOT_UNDEAD));
    }
    
    @Override
    public void setCustomNameTag(final String llllllllllllIllllllIlIlIllIIlIIl) {
        super.setCustomNameTag(llllllllllllIllllllIlIlIllIIlIIl);
        this.bossInfo.setName(this.getDisplayName());
    }
    
    private double getHeadZ(final int llllllllllllIllllllIlIlIIIlIlIll) {
        if (llllllllllllIllllllIlIlIIIlIlIll <= 0) {
            return this.posZ;
        }
        final float llllllllllllIllllllIlIlIIIlIlIlI = (this.renderYawOffset + 180 * (llllllllllllIllllllIlIlIIIlIlIll - 1)) * 0.017453292f;
        final float llllllllllllIllllllIlIlIIIlIlIIl = MathHelper.sin(llllllllllllIllllllIlIlIIIlIlIlI);
        return this.posZ + llllllllllllIllllllIlIlIIIlIlIIl * 1.3;
    }
    
    public void setInvulTime(final int llllllllllllIllllllIlIIllIlIlIII) {
        this.dataManager.set(EntityWither.INVULNERABILITY_TIME, llllllllllllIllllllIlIIllIlIlIII);
    }
    
    @Override
    public void fall(final float llllllllllllIllllllIlIIlllIIIIll, final float llllllllllllIllllllIlIIlllIIIIlI) {
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(EntityWither.FIRST_HEAD_TARGET, 0);
        this.dataManager.register(EntityWither.SECOND_HEAD_TARGET, 0);
        this.dataManager.register(EntityWither.THIRD_HEAD_TARGET, 0);
        this.dataManager.register(EntityWither.INVULNERABILITY_TIME, 0);
    }
    
    @Override
    protected SoundEvent getHurtSound(final DamageSource llllllllllllIllllllIlIlIllIIIllI) {
        return SoundEvents.ENTITY_WITHER_HURT;
    }
    
    public EntityWither(final World llllllllllllIllllllIlIlIlllIIllI) {
        super(llllllllllllIllllllIlIlIlllIIllI);
        this.xRotationHeads = new float[2];
        this.yRotationHeads = new float[2];
        this.xRotOHeads = new float[2];
        this.yRotOHeads = new float[2];
        this.nextHeadUpdate = new int[2];
        this.idleHeadUpdates = new int[2];
        this.bossInfo = (BossInfoServer)new BossInfoServer(this.getDisplayName(), BossInfo.Color.PURPLE, BossInfo.Overlay.PROGRESS).setDarkenSky(true);
        this.setHealth(this.getMaxHealth());
        this.setSize(0.9f, 3.5f);
        this.isImmuneToFire = true;
        ((PathNavigateGround)this.getNavigator()).setCanSwim(true);
        this.experienceValue = 50;
    }
    
    public void updateWatchedTargetId(final int llllllllllllIllllllIlIIllIIllIlI, final int llllllllllllIllllllIlIIllIIllIIl) {
        this.dataManager.set(EntityWither.HEAD_TARGETS[llllllllllllIllllllIlIIllIIllIlI], llllllllllllIllllllIlIIllIIllIIl);
    }
    
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_WITHER_DEATH;
    }
    
    public int getWatchedTargetId(final int llllllllllllIllllllIlIIllIlIIlII) {
        return this.dataManager.get(EntityWither.HEAD_TARGETS[llllllllllllIllllllIlIIllIlIIlII]);
    }
    
    @Override
    public void removeTrackingPlayer(final EntityPlayerMP llllllllllllIllllllIlIlIIlIIIIll) {
        super.removeTrackingPlayer(llllllllllllIllllllIlIlIIlIIIIll);
        this.bossInfo.removePlayer(llllllllllllIllllllIlIlIIlIIIIll);
    }
    
    public float getHeadXRotation(final int llllllllllllIllllllIlIIllIllIIIl) {
        return this.xRotationHeads[llllllllllllIllllllIlIIllIllIIIl];
    }
    
    public static boolean canDestroyBlock(final Block llllllllllllIllllllIlIlIIlIlIlII) {
        return llllllllllllIllllllIlIlIIlIlIlII != Blocks.BEDROCK && llllllllllllIllllllIlIlIIlIlIlII != Blocks.END_PORTAL && llllllllllllIllllllIlIlIIlIlIlII != Blocks.END_PORTAL_FRAME && llllllllllllIllllllIlIlIIlIlIlII != Blocks.COMMAND_BLOCK && llllllllllllIllllllIlIlIIlIlIlII != Blocks.REPEATING_COMMAND_BLOCK && llllllllllllIllllllIlIlIIlIlIlII != Blocks.CHAIN_COMMAND_BLOCK && llllllllllllIllllllIlIlIIlIlIlII != Blocks.BARRIER && llllllllllllIllllllIlIlIIlIlIlII != Blocks.STRUCTURE_BLOCK && llllllllllllIllllllIlIlIIlIlIlII != Blocks.STRUCTURE_VOID && llllllllllllIllllllIlIlIIlIlIlII != Blocks.PISTON_EXTENSION && llllllllllllIllllllIlIlIIlIlIlII != Blocks.END_GATEWAY;
    }
    
    private double getHeadX(final int llllllllllllIllllllIlIlIIIllllIl) {
        if (llllllllllllIllllllIlIlIIIllllIl <= 0) {
            return this.posX;
        }
        final float llllllllllllIllllllIlIlIIIllllII = (this.renderYawOffset + 180 * (llllllllllllIllllllIlIlIIIllllIl - 1)) * 0.017453292f;
        final float llllllllllllIllllllIlIlIIIlllIll = MathHelper.cos(llllllllllllIllllllIlIlIIIllllII);
        return this.posX + llllllllllllIllllllIlIlIIIlllIll * 1.3;
    }
    
    @Override
    protected boolean canBeRidden(final Entity llllllllllllIllllllIlIIllIIlIIll) {
        return false;
    }
    
    public boolean isArmored() {
        return this.getHealth() <= this.getMaxHealth() / 2.0f;
    }
    
    private double getHeadY(final int llllllllllllIllllllIlIlIIIllIIll) {
        return (llllllllllllIllllllIlIlIIIllIIll <= 0) ? (this.posY + 3.0) : (this.posY + 2.2);
    }
    
    public static void registerFixesWither(final DataFixer llllllllllllIllllllIlIlIllIlllII) {
        EntityLiving.registerFixesMob(llllllllllllIllllllIlIlIllIlllII, EntityWither.class);
    }
    
    @Override
    public void addPotionEffect(final PotionEffect llllllllllllIllllllIlIIlllIIIIII) {
    }
    
    @Override
    protected void despawnEntity() {
        this.entityAge = 0;
    }
    
    @Override
    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute.UNDEAD;
    }
    
    @Override
    public void onLivingUpdate() {
        this.motionY *= 0.6000000238418579;
        if (!this.world.isRemote && this.getWatchedTargetId(0) > 0) {
            final Entity llllllllllllIllllllIlIlIlIllIlII = this.world.getEntityByID(this.getWatchedTargetId(0));
            if (llllllllllllIllllllIlIlIlIllIlII != null) {
                if (this.posY < llllllllllllIllllllIlIlIlIllIlII.posY || (!this.isArmored() && this.posY < llllllllllllIllllllIlIlIlIllIlII.posY + 5.0)) {
                    if (this.motionY < 0.0) {
                        this.motionY = 0.0;
                    }
                    this.motionY += (0.5 - this.motionY) * 0.6000000238418579;
                }
                final double llllllllllllIllllllIlIlIlIllIIll = llllllllllllIllllllIlIlIlIllIlII.posX - this.posX;
                final double llllllllllllIllllllIlIlIlIllIIlI = llllllllllllIllllllIlIlIlIllIlII.posZ - this.posZ;
                final double llllllllllllIllllllIlIlIlIllIIIl = llllllllllllIllllllIlIlIlIllIIll * llllllllllllIllllllIlIlIlIllIIll + llllllllllllIllllllIlIlIlIllIIlI * llllllllllllIllllllIlIlIlIllIIlI;
                if (llllllllllllIllllllIlIlIlIllIIIl > 9.0) {
                    final double llllllllllllIllllllIlIlIlIllIIII = MathHelper.sqrt(llllllllllllIllllllIlIlIlIllIIIl);
                    this.motionX += (llllllllllllIllllllIlIlIlIllIIll / llllllllllllIllllllIlIlIlIllIIII * 0.5 - this.motionX) * 0.6000000238418579;
                    this.motionZ += (llllllllllllIllllllIlIlIlIllIIlI / llllllllllllIllllllIlIlIlIllIIII * 0.5 - this.motionZ) * 0.6000000238418579;
                }
            }
        }
        if (this.motionX * this.motionX + this.motionZ * this.motionZ > 0.05000000074505806) {
            this.rotationYaw = (float)MathHelper.atan2(this.motionZ, this.motionX) * 57.295776f - 90.0f;
        }
        super.onLivingUpdate();
        for (int llllllllllllIllllllIlIlIlIlIllll = 0; llllllllllllIllllllIlIlIlIlIllll < 2; ++llllllllllllIllllllIlIlIlIlIllll) {
            this.yRotOHeads[llllllllllllIllllllIlIlIlIlIllll] = this.yRotationHeads[llllllllllllIllllllIlIlIlIlIllll];
            this.xRotOHeads[llllllllllllIllllllIlIlIlIlIllll] = this.xRotationHeads[llllllllllllIllllllIlIlIlIlIllll];
        }
        for (int llllllllllllIllllllIlIlIlIlIlllI = 0; llllllllllllIllllllIlIlIlIlIlllI < 2; ++llllllllllllIllllllIlIlIlIlIlllI) {
            final int llllllllllllIllllllIlIlIlIlIllIl = this.getWatchedTargetId(llllllllllllIllllllIlIlIlIlIlllI + 1);
            Entity llllllllllllIllllllIlIlIlIlIllII = null;
            if (llllllllllllIllllllIlIlIlIlIllIl > 0) {
                llllllllllllIllllllIlIlIlIlIllII = this.world.getEntityByID(llllllllllllIllllllIlIlIlIlIllIl);
            }
            if (llllllllllllIllllllIlIlIlIlIllII != null) {
                final double llllllllllllIllllllIlIlIlIlIlIll = this.getHeadX(llllllllllllIllllllIlIlIlIlIlllI + 1);
                final double llllllllllllIllllllIlIlIlIlIlIlI = this.getHeadY(llllllllllllIllllllIlIlIlIlIlllI + 1);
                final double llllllllllllIllllllIlIlIlIlIlIIl = this.getHeadZ(llllllllllllIllllllIlIlIlIlIlllI + 1);
                final double llllllllllllIllllllIlIlIlIlIlIII = llllllllllllIllllllIlIlIlIlIllII.posX - llllllllllllIllllllIlIlIlIlIlIll;
                final double llllllllllllIllllllIlIlIlIlIIlll = llllllllllllIllllllIlIlIlIlIllII.posY + llllllllllllIllllllIlIlIlIlIllII.getEyeHeight() - llllllllllllIllllllIlIlIlIlIlIlI;
                final double llllllllllllIllllllIlIlIlIlIIllI = llllllllllllIllllllIlIlIlIlIllII.posZ - llllllllllllIllllllIlIlIlIlIlIIl;
                final double llllllllllllIllllllIlIlIlIlIIlIl = MathHelper.sqrt(llllllllllllIllllllIlIlIlIlIlIII * llllllllllllIllllllIlIlIlIlIlIII + llllllllllllIllllllIlIlIlIlIIllI * llllllllllllIllllllIlIlIlIlIIllI);
                final float llllllllllllIllllllIlIlIlIlIIlII = (float)(MathHelper.atan2(llllllllllllIllllllIlIlIlIlIIllI, llllllllllllIllllllIlIlIlIlIlIII) * 57.29577951308232) - 90.0f;
                final float llllllllllllIllllllIlIlIlIlIIIll = (float)(-(MathHelper.atan2(llllllllllllIllllllIlIlIlIlIIlll, llllllllllllIllllllIlIlIlIlIIlIl) * 57.29577951308232));
                this.xRotationHeads[llllllllllllIllllllIlIlIlIlIlllI] = this.rotlerp(this.xRotationHeads[llllllllllllIllllllIlIlIlIlIlllI], llllllllllllIllllllIlIlIlIlIIIll, 40.0f);
                this.yRotationHeads[llllllllllllIllllllIlIlIlIlIlllI] = this.rotlerp(this.yRotationHeads[llllllllllllIllllllIlIlIlIlIlllI], llllllllllllIllllllIlIlIlIlIIlII, 10.0f);
            }
            else {
                this.yRotationHeads[llllllllllllIllllllIlIlIlIlIlllI] = this.rotlerp(this.yRotationHeads[llllllllllllIllllllIlIlIlIlIlllI], this.renderYawOffset, 10.0f);
            }
        }
        final boolean llllllllllllIllllllIlIlIlIlIIIlI = this.isArmored();
        for (int llllllllllllIllllllIlIlIlIlIIIIl = 0; llllllllllllIllllllIlIlIlIlIIIIl < 3; ++llllllllllllIllllllIlIlIlIlIIIIl) {
            final double llllllllllllIllllllIlIlIlIlIIIII = this.getHeadX(llllllllllllIllllllIlIlIlIlIIIIl);
            final double llllllllllllIllllllIlIlIlIIlllll = this.getHeadY(llllllllllllIllllllIlIlIlIlIIIIl);
            final double llllllllllllIllllllIlIlIlIIllllI = this.getHeadZ(llllllllllllIllllllIlIlIlIlIIIIl);
            this.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, llllllllllllIllllllIlIlIlIlIIIII + this.rand.nextGaussian() * 0.30000001192092896, llllllllllllIllllllIlIlIlIIlllll + this.rand.nextGaussian() * 0.30000001192092896, llllllllllllIllllllIlIlIlIIllllI + this.rand.nextGaussian() * 0.30000001192092896, 0.0, 0.0, 0.0, new int[0]);
            if (llllllllllllIllllllIlIlIlIlIIIlI && this.world.rand.nextInt(4) == 0) {
                this.world.spawnParticle(EnumParticleTypes.SPELL_MOB, llllllllllllIllllllIlIlIlIlIIIII + this.rand.nextGaussian() * 0.30000001192092896, llllllllllllIllllllIlIlIlIIlllll + this.rand.nextGaussian() * 0.30000001192092896, llllllllllllIllllllIlIlIlIIllllI + this.rand.nextGaussian() * 0.30000001192092896, 0.699999988079071, 0.699999988079071, 0.5, new int[0]);
            }
        }
        if (this.getInvulTime() > 0) {
            for (int llllllllllllIllllllIlIlIlIIlllIl = 0; llllllllllllIllllllIlIlIlIIlllIl < 3; ++llllllllllllIllllllIlIlIlIIlllIl) {
                this.world.spawnParticle(EnumParticleTypes.SPELL_MOB, this.posX + this.rand.nextGaussian(), this.posY + this.rand.nextFloat() * 3.3f, this.posZ + this.rand.nextGaussian(), 0.699999988079071, 0.699999988079071, 0.8999999761581421, new int[0]);
            }
        }
    }
    
    private float rotlerp(final float llllllllllllIllllllIlIlIIIIlllll, final float llllllllllllIllllllIlIlIIIIllIlI, final float llllllllllllIllllllIlIlIIIIlllIl) {
        float llllllllllllIllllllIlIlIIIIlllII = MathHelper.wrapDegrees(llllllllllllIllllllIlIlIIIIllIlI - llllllllllllIllllllIlIlIIIIlllll);
        if (llllllllllllIllllllIlIlIIIIlllII > llllllllllllIllllllIlIlIIIIlllIl) {
            llllllllllllIllllllIlIlIIIIlllII = llllllllllllIllllllIlIlIIIIlllIl;
        }
        if (llllllllllllIllllllIlIlIIIIlllII < -llllllllllllIllllllIlIlIIIIlllIl) {
            llllllllllllIllllllIlIlIIIIlllII = -llllllllllllIllllllIlIlIIIIlllIl;
        }
        return llllllllllllIllllllIlIlIIIIlllll + llllllllllllIllllllIlIlIIIIlllII;
    }
    
    @Override
    protected void dropFewItems(final boolean llllllllllllIllllllIlIIlllIIllIl, final int llllllllllllIllllllIlIIlllIIllII) {
        final EntityItem llllllllllllIllllllIlIIlllIIlIll = this.dropItem(Items.NETHER_STAR, 1);
        if (llllllllllllIllllllIlIIlllIIlIll != null) {
            llllllllllllIllllllIlIIlllIIlIll.setNoDespawn();
        }
    }
    
    private void launchWitherSkullToCoords(final int llllllllllllIllllllIlIlIIIIIIIII, final double llllllllllllIllllllIlIIlllllllll, final double llllllllllllIllllllIlIIllllllllI, final double llllllllllllIllllllIlIIlllllllIl, final boolean llllllllllllIllllllIlIIlllllllII) {
        this.world.playEvent(null, 1024, new BlockPos(this), 0);
        final double llllllllllllIllllllIlIIllllllIll = this.getHeadX(llllllllllllIllllllIlIlIIIIIIIII);
        final double llllllllllllIllllllIlIIllllllIlI = this.getHeadY(llllllllllllIllllllIlIlIIIIIIIII);
        final double llllllllllllIllllllIlIIllllllIIl = this.getHeadZ(llllllllllllIllllllIlIlIIIIIIIII);
        final double llllllllllllIllllllIlIIllllllIII = llllllllllllIllllllIlIIlllllllll - llllllllllllIllllllIlIIllllllIll;
        final double llllllllllllIllllllIlIIlllllIlll = llllllllllllIllllllIlIIllllllllI - llllllllllllIllllllIlIIllllllIlI;
        final double llllllllllllIllllllIlIIlllllIllI = llllllllllllIllllllIlIIlllllllIl - llllllllllllIllllllIlIIllllllIIl;
        final EntityWitherSkull llllllllllllIllllllIlIIlllllIlIl = new EntityWitherSkull(this.world, this, llllllllllllIllllllIlIIllllllIII, llllllllllllIllllllIlIIlllllIlll, llllllllllllIllllllIlIIlllllIllI);
        if (llllllllllllIllllllIlIIlllllllII) {
            llllllllllllIllllllIlIIlllllIlIl.setInvulnerable(true);
        }
        llllllllllllIllllllIlIIlllllIlIl.posY = llllllllllllIllllllIlIIllllllIlI;
        llllllllllllIllllllIlIIlllllIlIl.posX = llllllllllllIllllllIlIIllllllIll;
        llllllllllllIllllllIlIIlllllIlIl.posZ = llllllllllllIllllllIlIIllllllIIl;
        this.world.spawnEntityInWorld(llllllllllllIllllllIlIIlllllIlIl);
    }
    
    public int getInvulTime() {
        return this.dataManager.get(EntityWither.INVULNERABILITY_TIME);
    }
    
    @Override
    public boolean isNonBoss() {
        return false;
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound llllllllllllIllllllIlIlIllIlIlIl) {
        super.writeEntityToNBT(llllllllllllIllllllIlIlIllIlIlIl);
        llllllllllllIllllllIlIlIllIlIlIl.setInteger("Invul", this.getInvulTime());
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound llllllllllllIllllllIlIlIllIlIIIl) {
        super.readEntityFromNBT(llllllllllllIllllllIlIlIllIlIIIl);
        this.setInvulTime(llllllllllllIllllllIlIlIllIlIIIl.getInteger("Invul"));
        if (this.hasCustomName()) {
            this.bossInfo.setName(this.getDisplayName());
        }
    }
    
    public float getHeadYRotation(final int llllllllllllIllllllIlIIllIlllIIl) {
        return this.yRotationHeads[llllllllllllIllllllIlIIllIlllIIl];
    }
    
    public void ignite() {
        this.setInvulTime(220);
        this.setHealth(this.getMaxHealth() / 3.0f);
    }
    
    private void launchWitherSkullToEntity(final int llllllllllllIllllllIlIlIIIIlIIll, final EntityLivingBase llllllllllllIllllllIlIlIIIIlIIlI) {
        this.launchWitherSkullToCoords(llllllllllllIllllllIlIlIIIIlIIll, llllllllllllIllllllIlIlIIIIlIIlI.posX, llllllllllllIllllllIlIlIIIIlIIlI.posY + llllllllllllIllllllIlIlIIIIlIIlI.getEyeHeight() * 0.5, llllllllllllIllllllIlIlIIIIlIIlI.posZ, llllllllllllIllllllIlIlIIIIlIIll == 0 && this.rand.nextFloat() < 0.001f);
    }
    
    @Override
    public void setInWeb() {
    }
    
    static {
        FIRST_HEAD_TARGET = EntityDataManager.createKey(EntityWither.class, DataSerializers.VARINT);
        SECOND_HEAD_TARGET = EntityDataManager.createKey(EntityWither.class, DataSerializers.VARINT);
        THIRD_HEAD_TARGET = EntityDataManager.createKey(EntityWither.class, DataSerializers.VARINT);
        HEAD_TARGETS = new DataParameter[] { EntityWither.FIRST_HEAD_TARGET, EntityWither.SECOND_HEAD_TARGET, EntityWither.THIRD_HEAD_TARGET };
        INVULNERABILITY_TIME = EntityDataManager.createKey(EntityWither.class, DataSerializers.VARINT);
        NOT_UNDEAD = (Predicate)new Predicate<Entity>() {
            public boolean apply(@Nullable final Entity lllllllllllllIlllIIlIllIIIIllIIl) {
                return lllllllllllllIlllIIlIllIIIIllIIl instanceof EntityLivingBase && ((EntityLivingBase)lllllllllllllIlllIIlIllIIIIllIIl).getCreatureAttribute() != EnumCreatureAttribute.UNDEAD && ((EntityLivingBase)lllllllllllllIlllIIlIllIIIIllIIl).func_190631_cK();
            }
        };
    }
    
    @Override
    public void attackEntityWithRangedAttack(final EntityLivingBase llllllllllllIllllllIlIIllllIIlII, final float llllllllllllIllllllIlIIllllIIIll) {
        this.launchWitherSkullToEntity(0, llllllllllllIllllllIlIIllllIIlII);
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource llllllllllllIllllllIlIIlllIllIlI, final float llllllllllllIllllllIlIIlllIlIIll) {
        if (this.isEntityInvulnerable(llllllllllllIllllllIlIIlllIllIlI)) {
            return false;
        }
        if (llllllllllllIllllllIlIIlllIllIlI == DamageSource.drown || llllllllllllIllllllIlIIlllIllIlI.getEntity() instanceof EntityWither) {
            return false;
        }
        if (this.getInvulTime() > 0 && llllllllllllIllllllIlIIlllIllIlI != DamageSource.outOfWorld) {
            return false;
        }
        if (this.isArmored()) {
            final Entity llllllllllllIllllllIlIIlllIllIII = llllllllllllIllllllIlIIlllIllIlI.getSourceOfDamage();
            if (llllllllllllIllllllIlIIlllIllIII instanceof EntityArrow) {
                return false;
            }
        }
        final Entity llllllllllllIllllllIlIIlllIlIlll = llllllllllllIllllllIlIIlllIllIlI.getEntity();
        if (llllllllllllIllllllIlIIlllIlIlll != null && !(llllllllllllIllllllIlIIlllIlIlll instanceof EntityPlayer) && llllllllllllIllllllIlIIlllIlIlll instanceof EntityLivingBase && ((EntityLivingBase)llllllllllllIllllllIlIIlllIlIlll).getCreatureAttribute() == this.getCreatureAttribute()) {
            return false;
        }
        if (this.blockBreakCounter <= 0) {
            this.blockBreakCounter = 20;
        }
        for (int llllllllllllIllllllIlIIlllIlIllI = 0; llllllllllllIllllllIlIIlllIlIllI < this.idleHeadUpdates.length; ++llllllllllllIllllllIlIIlllIlIllI) {
            final int[] idleHeadUpdates = this.idleHeadUpdates;
            final int n = llllllllllllIllllllIlIIlllIlIllI;
            idleHeadUpdates[n] += 3;
        }
        return super.attackEntityFrom(llllllllllllIllllllIlIIlllIllIlI, llllllllllllIllllllIlIIlllIlIIll);
    }
    
    @Override
    public void setSwingingArms(final boolean llllllllllllIllllllIlIIllIIlIIII) {
    }
    
    @Override
    public int getBrightnessForRender() {
        return 15728880;
    }
    
    @Override
    public void addTrackingPlayer(final EntityPlayerMP llllllllllllIllllllIlIlIIlIIlIIl) {
        super.addTrackingPlayer(llllllllllllIllllllIlIlIIlIIlIIl);
        this.bossInfo.addPlayer(llllllllllllIllllllIlIlIIlIIlIIl);
    }
    
    class AIDoNothing extends EntityAIBase
    {
        @Override
        public boolean shouldExecute() {
            return EntityWither.this.getInvulTime() > 0;
        }
        
        public AIDoNothing() {
            this.setMutexBits(7);
        }
    }
}
