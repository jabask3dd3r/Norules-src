package net.minecraft.entity.monster;

import net.minecraft.block.material.*;
import net.minecraft.init.*;
import net.minecraft.util.datafix.*;
import net.minecraft.world.storage.loot.*;
import javax.annotation.*;
import net.minecraft.util.*;
import net.minecraft.network.datasync.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import com.google.common.base.*;
import net.minecraft.pathfinding.*;
import net.minecraft.entity.passive.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.ai.*;

public class EntityGuardian extends EntityMob
{
    private /* synthetic */ boolean clientSideTouchedGround;
    protected /* synthetic */ EntityAIWander wander;
    private static final /* synthetic */ DataParameter<Integer> TARGET_ENTITY;
    private /* synthetic */ int clientSideAttackTime;
    private /* synthetic */ EntityLivingBase targetedEntity;
    protected /* synthetic */ float clientSideTailAnimation;
    protected /* synthetic */ float clientSideTailAnimationSpeed;
    protected /* synthetic */ float clientSideSpikesAnimationO;
    protected /* synthetic */ float clientSideTailAnimationO;
    private static final /* synthetic */ DataParameter<Boolean> field_190766_bz;
    protected /* synthetic */ float clientSideSpikesAnimation;
    
    public float getAttackAnimationScale(final float lllllllllllllIIIllIlIIlllIllIlll) {
        return (this.clientSideAttackTime + lllllllllllllIIIllIlIIlllIllIlll) / this.getAttackDuration();
    }
    
    @Override
    protected boolean canTriggerWalking() {
        return false;
    }
    
    @Override
    protected boolean isValidLightLevel() {
        return true;
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6.0);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(16.0);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0);
    }
    
    @Override
    public float getBlockPathWeight(final BlockPos lllllllllllllIIIllIlIIlllllIIllI) {
        return (this.world.getBlockState(lllllllllllllIIIllIlIIlllllIIllI).getMaterial() == Material.WATER) ? (10.0f + this.world.getLightBrightness(lllllllllllllIIIllIlIIlllllIIllI) - 0.5f) : super.getBlockPathWeight(lllllllllllllIIIllIlIIlllllIIllI);
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource lllllllllllllIIIllIlIIlllIlIlIIl, final float lllllllllllllIIIllIlIIlllIlIIlII) {
        if (!this.isMoving() && !lllllllllllllIIIllIlIIlllIlIlIIl.isMagicDamage() && lllllllllllllIIIllIlIIlllIlIlIIl.getSourceOfDamage() instanceof EntityLivingBase) {
            final EntityLivingBase lllllllllllllIIIllIlIIlllIlIIlll = (EntityLivingBase)lllllllllllllIIIllIlIIlllIlIlIIl.getSourceOfDamage();
            if (!lllllllllllllIIIllIlIIlllIlIlIIl.isExplosion()) {
                lllllllllllllIIIllIlIIlllIlIIlll.attackEntityFrom(DamageSource.causeThornsDamage(this), 2.0f);
            }
        }
        if (this.wander != null) {
            this.wander.makeUpdate();
        }
        return super.attackEntityFrom(lllllllllllllIIIllIlIIlllIlIlIIl, lllllllllllllIIIllIlIIlllIlIIlII);
    }
    
    @Override
    public boolean isNotColliding() {
        return this.world.checkNoEntityCollision(this.getEntityBoundingBox(), this) && this.world.getCollisionBoxes(this, this.getEntityBoundingBox()).isEmpty();
    }
    
    @Override
    protected SoundEvent getAmbientSound() {
        return this.isInWater() ? SoundEvents.ENTITY_GUARDIAN_AMBIENT : SoundEvents.ENTITY_GUARDIAN_AMBIENT_LAND;
    }
    
    @Override
    public void func_191986_a(final float lllllllllllllIIIllIlIIlllIIlllII, final float lllllllllllllIIIllIlIIlllIIllIll, final float lllllllllllllIIIllIlIIlllIIllIlI) {
        if (this.isServerWorld() && this.isInWater()) {
            this.func_191958_b(lllllllllllllIIIllIlIIlllIIlllII, lllllllllllllIIIllIlIIlllIIllIll, lllllllllllllIIIllIlIIlllIIllIlI, 0.1f);
            this.moveEntity(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
            this.motionX *= 0.8999999761581421;
            this.motionY *= 0.8999999761581421;
            this.motionZ *= 0.8999999761581421;
            if (!this.isMoving() && this.getAttackTarget() == null) {
                this.motionY -= 0.005;
            }
        }
        else {
            super.func_191986_a(lllllllllllllIIIllIlIIlllIIlllII, lllllllllllllIIIllIlIIlllIIllIll, lllllllllllllIIIllIlIIlllIIllIlI);
        }
    }
    
    public static void registerFixesGuardian(final DataFixer lllllllllllllIIIllIlIlIIIIlIIIlI) {
        EntityLiving.registerFixesMob(lllllllllllllIIIllIlIlIIIIlIIIlI, EntityGuardian.class);
    }
    
    private void setTargetedEntity(final int lllllllllllllIIIllIlIlIIIIIIlIlI) {
        this.dataManager.set(EntityGuardian.TARGET_ENTITY, lllllllllllllIIIllIlIlIIIIIIlIlI);
    }
    
    public float getSpikesAnimation(final float lllllllllllllIIIllIlIIlllIllllll) {
        return this.clientSideSpikesAnimationO + (this.clientSideSpikesAnimation - this.clientSideSpikesAnimationO) * lllllllllllllIIIllIlIIlllIllllll;
    }
    
    @Nullable
    @Override
    protected ResourceLocation getLootTable() {
        return LootTableList.ENTITIES_GUARDIAN;
    }
    
    public boolean isMoving() {
        return this.dataManager.get(EntityGuardian.field_190766_bz);
    }
    
    public float getTailAnimation(final float lllllllllllllIIIllIlIIllllIIIlIl) {
        return this.clientSideTailAnimationO + (this.clientSideTailAnimation - this.clientSideTailAnimationO) * lllllllllllllIIIllIlIIllllIIIlIl;
    }
    
    protected SoundEvent func_190765_dj() {
        return SoundEvents.ENTITY_GUARDIAN_FLOP;
    }
    
    @Override
    public void notifyDataManagerChange(final DataParameter<?> lllllllllllllIIIllIlIIlllllllIIl) {
        super.notifyDataManagerChange(lllllllllllllIIIllIlIIlllllllIIl);
        if (EntityGuardian.TARGET_ENTITY.equals(lllllllllllllIIIllIlIIlllllllIIl)) {
            this.clientSideAttackTime = 0;
            this.targetedEntity = null;
        }
    }
    
    public int getAttackDuration() {
        return 80;
    }
    
    @Override
    public int getTalkInterval() {
        return 160;
    }
    
    @Override
    protected SoundEvent getHurtSound(final DamageSource lllllllllllllIIIllIlIIllllllIIlI) {
        return this.isInWater() ? SoundEvents.ENTITY_GUARDIAN_HURT : SoundEvents.ENTITY_GUARDIAN_HURT_LAND;
    }
    
    @Override
    public void onLivingUpdate() {
        if (this.world.isRemote) {
            this.clientSideTailAnimationO = this.clientSideTailAnimation;
            if (!this.isInWater()) {
                this.clientSideTailAnimationSpeed = 2.0f;
                if (this.motionY > 0.0 && this.clientSideTouchedGround && !this.isSilent()) {
                    this.world.playSound(this.posX, this.posY, this.posZ, this.func_190765_dj(), this.getSoundCategory(), 1.0f, 1.0f, false);
                }
                this.clientSideTouchedGround = (this.motionY < 0.0 && this.world.isBlockNormalCube(new BlockPos(this).down(), false));
            }
            else if (this.isMoving()) {
                if (this.clientSideTailAnimationSpeed < 0.5f) {
                    this.clientSideTailAnimationSpeed = 4.0f;
                }
                else {
                    this.clientSideTailAnimationSpeed += (0.5f - this.clientSideTailAnimationSpeed) * 0.1f;
                }
            }
            else {
                this.clientSideTailAnimationSpeed += (0.125f - this.clientSideTailAnimationSpeed) * 0.2f;
            }
            this.clientSideTailAnimation += this.clientSideTailAnimationSpeed;
            this.clientSideSpikesAnimationO = this.clientSideSpikesAnimation;
            if (!this.isInWater()) {
                this.clientSideSpikesAnimation = this.rand.nextFloat();
            }
            else if (this.isMoving()) {
                this.clientSideSpikesAnimation += (0.0f - this.clientSideSpikesAnimation) * 0.25f;
            }
            else {
                this.clientSideSpikesAnimation += (1.0f - this.clientSideSpikesAnimation) * 0.06f;
            }
            if (this.isMoving() && this.isInWater()) {
                final Vec3d lllllllllllllIIIllIlIIllllIllIlI = this.getLook(0.0f);
                for (int lllllllllllllIIIllIlIIllllIllIIl = 0; lllllllllllllIIIllIlIIllllIllIIl < 2; ++lllllllllllllIIIllIlIIllllIllIIl) {
                    this.world.spawnParticle(EnumParticleTypes.WATER_BUBBLE, this.posX + (this.rand.nextDouble() - 0.5) * this.width - lllllllllllllIIIllIlIIllllIllIlI.xCoord * 1.5, this.posY + this.rand.nextDouble() * this.height - lllllllllllllIIIllIlIIllllIllIlI.yCoord * 1.5, this.posZ + (this.rand.nextDouble() - 0.5) * this.width - lllllllllllllIIIllIlIIllllIllIlI.zCoord * 1.5, 0.0, 0.0, 0.0, new int[0]);
                }
            }
            if (this.hasTargetedEntity()) {
                if (this.clientSideAttackTime < this.getAttackDuration()) {
                    ++this.clientSideAttackTime;
                }
                final EntityLivingBase lllllllllllllIIIllIlIIllllIllIII = this.getTargetedEntity();
                if (lllllllllllllIIIllIlIIllllIllIII != null) {
                    this.getLookHelper().setLookPositionWithEntity(lllllllllllllIIIllIlIIllllIllIII, 90.0f, 90.0f);
                    this.getLookHelper().onUpdateLook();
                    final double lllllllllllllIIIllIlIIllllIlIlll = this.getAttackAnimationScale(0.0f);
                    double lllllllllllllIIIllIlIIllllIlIllI = lllllllllllllIIIllIlIIllllIllIII.posX - this.posX;
                    double lllllllllllllIIIllIlIIllllIlIlIl = lllllllllllllIIIllIlIIllllIllIII.posY + lllllllllllllIIIllIlIIllllIllIII.height * 0.5f - (this.posY + this.getEyeHeight());
                    double lllllllllllllIIIllIlIIllllIlIlII = lllllllllllllIIIllIlIIllllIllIII.posZ - this.posZ;
                    final double lllllllllllllIIIllIlIIllllIlIIll = Math.sqrt(lllllllllllllIIIllIlIIllllIlIllI * lllllllllllllIIIllIlIIllllIlIllI + lllllllllllllIIIllIlIIllllIlIlIl * lllllllllllllIIIllIlIIllllIlIlIl + lllllllllllllIIIllIlIIllllIlIlII * lllllllllllllIIIllIlIIllllIlIlII);
                    lllllllllllllIIIllIlIIllllIlIllI /= lllllllllllllIIIllIlIIllllIlIIll;
                    lllllllllllllIIIllIlIIllllIlIlIl /= lllllllllllllIIIllIlIIllllIlIIll;
                    lllllllllllllIIIllIlIIllllIlIlII /= lllllllllllllIIIllIlIIllllIlIIll;
                    double lllllllllllllIIIllIlIIllllIlIIlI = this.rand.nextDouble();
                    while (lllllllllllllIIIllIlIIllllIlIIlI < lllllllllllllIIIllIlIIllllIlIIll) {
                        lllllllllllllIIIllIlIIllllIlIIlI += 1.8 - lllllllllllllIIIllIlIIllllIlIlll + this.rand.nextDouble() * (1.7 - lllllllllllllIIIllIlIIllllIlIlll);
                        this.world.spawnParticle(EnumParticleTypes.WATER_BUBBLE, this.posX + lllllllllllllIIIllIlIIllllIlIllI * lllllllllllllIIIllIlIIllllIlIIlI, this.posY + lllllllllllllIIIllIlIIllllIlIlIl * lllllllllllllIIIllIlIIllllIlIIlI + this.getEyeHeight(), this.posZ + lllllllllllllIIIllIlIIllllIlIlII * lllllllllllllIIIllIlIIllllIlIIlI, 0.0, 0.0, 0.0, new int[0]);
                    }
                }
            }
        }
        if (this.inWater) {
            this.setAir(300);
        }
        else if (this.onGround) {
            this.motionY += 0.5;
            this.motionX += (this.rand.nextFloat() * 2.0f - 1.0f) * 0.4f;
            this.motionZ += (this.rand.nextFloat() * 2.0f - 1.0f) * 0.4f;
            this.rotationYaw = this.rand.nextFloat() * 360.0f;
            this.onGround = false;
            this.isAirBorne = true;
        }
        if (this.hasTargetedEntity()) {
            this.rotationYaw = this.rotationYawHead;
        }
        super.onLivingUpdate();
    }
    
    private void setMoving(final boolean lllllllllllllIIIllIlIlIIIIIIllll) {
        this.dataManager.set(EntityGuardian.field_190766_bz, lllllllllllllIIIllIlIlIIIIIIllll);
    }
    
    static {
        field_190766_bz = EntityDataManager.createKey(EntityGuardian.class, DataSerializers.BOOLEAN);
        TARGET_ENTITY = EntityDataManager.createKey(EntityGuardian.class, DataSerializers.VARINT);
    }
    
    @Override
    public int getVerticalFaceSpeed() {
        return 180;
    }
    
    @Override
    protected SoundEvent getDeathSound() {
        return this.isInWater() ? SoundEvents.ENTITY_GUARDIAN_DEATH : SoundEvents.ENTITY_GUARDIAN_DEATH_LAND;
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(EntityGuardian.field_190766_bz, false);
        this.dataManager.register(EntityGuardian.TARGET_ENTITY, 0);
    }
    
    @Override
    public boolean getCanSpawnHere() {
        return (this.rand.nextInt(20) == 0 || !this.world.canBlockSeeSky(new BlockPos(this))) && super.getCanSpawnHere();
    }
    
    @Nullable
    public EntityLivingBase getTargetedEntity() {
        if (!this.hasTargetedEntity()) {
            return null;
        }
        if (!this.world.isRemote) {
            return this.getAttackTarget();
        }
        if (this.targetedEntity != null) {
            return this.targetedEntity;
        }
        final Entity lllllllllllllIIIllIlIlIIIIIIIIIl = this.world.getEntityByID(this.dataManager.get(EntityGuardian.TARGET_ENTITY));
        if (lllllllllllllIIIllIlIlIIIIIIIIIl instanceof EntityLivingBase) {
            this.targetedEntity = (EntityLivingBase)lllllllllllllIIIllIlIlIIIIIIIIIl;
            return this.targetedEntity;
        }
        return null;
    }
    
    public boolean hasTargetedEntity() {
        return this.dataManager.get(EntityGuardian.TARGET_ENTITY) != 0;
    }
    
    @Override
    public float getEyeHeight() {
        return this.height * 0.5f;
    }
    
    public EntityGuardian(final World lllllllllllllIIIllIlIlIIIIlIllIl) {
        super(lllllllllllllIIIllIlIlIIIIlIllIl);
        this.experienceValue = 10;
        this.setSize(0.85f, 0.85f);
        this.moveHelper = new GuardianMoveHelper(this);
        this.clientSideTailAnimation = this.rand.nextFloat();
        this.clientSideTailAnimationO = this.clientSideTailAnimation;
    }
    
    @Override
    protected void initEntityAI() {
        final EntityAIMoveTowardsRestriction lllllllllllllIIIllIlIlIIIIlIlIIl = new EntityAIMoveTowardsRestriction(this, 1.0);
        this.wander = new EntityAIWander(this, 1.0, 80);
        this.tasks.addTask(4, new AIGuardianAttack(this));
        this.tasks.addTask(5, lllllllllllllIIIllIlIlIIIIlIlIIl);
        this.tasks.addTask(7, this.wander);
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0f));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityGuardian.class, 12.0f, 0.01f));
        this.tasks.addTask(9, new EntityAILookIdle(this));
        this.wander.setMutexBits(3);
        lllllllllllllIIIllIlIlIIIIlIlIIl.setMutexBits(3);
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget<Object>(this, EntityLivingBase.class, 10, true, false, (com.google.common.base.Predicate<?>)new GuardianTargetSelector(this)));
    }
    
    @Override
    protected PathNavigate getNewNavigator(final World lllllllllllllIIIllIlIlIIIIIllIll) {
        return new PathNavigateSwimmer(this, lllllllllllllIIIllIlIlIIIIIllIll);
    }
    
    static class GuardianTargetSelector implements Predicate<EntityLivingBase>
    {
        private final /* synthetic */ EntityGuardian parentEntity;
        
        public GuardianTargetSelector() {
        }
        
        public boolean apply(@Nullable final EntityLivingBase lllllllllllllllllIllIIIIlIlIIlII) {
            return (lllllllllllllllllIllIIIIlIlIIlII instanceof EntityPlayer || lllllllllllllllllIllIIIIlIlIIlII instanceof EntitySquid) && lllllllllllllllllIllIIIIlIlIIlII.getDistanceSqToEntity(this.parentEntity) > 9.0;
        }
    }
    
    static class AIGuardianAttack extends EntityAIBase
    {
        private final /* synthetic */ boolean field_190881_c;
        private /* synthetic */ int tickCounter;
        private final /* synthetic */ EntityGuardian theEntity;
        
        @Override
        public void startExecuting() {
            this.tickCounter = -10;
            this.theEntity.getNavigator().clearPathEntity();
            this.theEntity.getLookHelper().setLookPositionWithEntity(this.theEntity.getAttackTarget(), 90.0f, 90.0f);
            this.theEntity.isAirBorne = true;
        }
        
        @Override
        public void resetTask() {
            EntityGuardian.this.setTargetedEntity(0);
            this.theEntity.setAttackTarget(null);
            this.theEntity.wander.makeUpdate();
        }
        
        @Override
        public void updateTask() {
            final EntityLivingBase lllllllllllllIIlIlIIlIllIlllIIII = this.theEntity.getAttackTarget();
            this.theEntity.getNavigator().clearPathEntity();
            this.theEntity.getLookHelper().setLookPositionWithEntity(lllllllllllllIIlIlIIlIllIlllIIII, 90.0f, 90.0f);
            if (!this.theEntity.canEntityBeSeen(lllllllllllllIIlIlIIlIllIlllIIII)) {
                this.theEntity.setAttackTarget(null);
            }
            else {
                ++this.tickCounter;
                if (this.tickCounter == 0) {
                    EntityGuardian.this.setTargetedEntity(this.theEntity.getAttackTarget().getEntityId());
                    this.theEntity.world.setEntityState(this.theEntity, (byte)21);
                }
                else if (this.tickCounter >= this.theEntity.getAttackDuration()) {
                    float lllllllllllllIIlIlIIlIllIllIllll = 1.0f;
                    if (this.theEntity.world.getDifficulty() == EnumDifficulty.HARD) {
                        lllllllllllllIIlIlIIlIllIllIllll += 2.0f;
                    }
                    if (this.field_190881_c) {
                        lllllllllllllIIlIlIIlIllIllIllll += 2.0f;
                    }
                    lllllllllllllIIlIlIIlIllIlllIIII.attackEntityFrom(DamageSource.causeIndirectMagicDamage(this.theEntity, this.theEntity), lllllllllllllIIlIlIIlIllIllIllll);
                    lllllllllllllIIlIlIIlIllIlllIIII.attackEntityFrom(DamageSource.causeMobDamage(this.theEntity), (float)this.theEntity.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue());
                    this.theEntity.setAttackTarget(null);
                }
                super.updateTask();
            }
        }
        
        @Override
        public boolean shouldExecute() {
            final EntityLivingBase lllllllllllllIIlIlIIlIlllIIIIIII = this.theEntity.getAttackTarget();
            return lllllllllllllIIlIlIIlIlllIIIIIII != null && lllllllllllllIIlIlIIlIlllIIIIIII.isEntityAlive();
        }
        
        @Override
        public boolean continueExecuting() {
            return super.continueExecuting() && (this.field_190881_c || this.theEntity.getDistanceSqToEntity(this.theEntity.getAttackTarget()) > 9.0);
        }
        
        public AIGuardianAttack() {
            this.field_190881_c = (EntityGuardian.this instanceof EntityElderGuardian);
            this.setMutexBits(3);
        }
    }
    
    static class GuardianMoveHelper extends EntityMoveHelper
    {
        private final /* synthetic */ EntityGuardian entityGuardian;
        
        public GuardianMoveHelper() {
            super(EntityGuardian.this);
        }
        
        @Override
        public void onUpdateMoveHelper() {
            if (this.action == Action.MOVE_TO && !this.entityGuardian.getNavigator().noPath()) {
                final double lllllllllllllllIlllIllllIlIIIllI = this.posX - this.entityGuardian.posX;
                double lllllllllllllllIlllIllllIlIIIlIl = this.posY - this.entityGuardian.posY;
                final double lllllllllllllllIlllIllllIlIIIlII = this.posZ - this.entityGuardian.posZ;
                final double lllllllllllllllIlllIllllIlIIIIll = MathHelper.sqrt(lllllllllllllllIlllIllllIlIIIllI * lllllllllllllllIlllIllllIlIIIllI + lllllllllllllllIlllIllllIlIIIlIl * lllllllllllllllIlllIllllIlIIIlIl + lllllllllllllllIlllIllllIlIIIlII * lllllllllllllllIlllIllllIlIIIlII);
                lllllllllllllllIlllIllllIlIIIlIl /= lllllllllllllllIlllIllllIlIIIIll;
                final float lllllllllllllllIlllIllllIlIIIIlI = (float)(MathHelper.atan2(lllllllllllllllIlllIllllIlIIIlII, lllllllllllllllIlllIllllIlIIIllI) * 57.29577951308232) - 90.0f;
                this.entityGuardian.rotationYaw = this.limitAngle(this.entityGuardian.rotationYaw, lllllllllllllllIlllIllllIlIIIIlI, 90.0f);
                this.entityGuardian.renderYawOffset = this.entityGuardian.rotationYaw;
                final float lllllllllllllllIlllIllllIlIIIIIl = (float)(this.speed * this.entityGuardian.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue());
                this.entityGuardian.setAIMoveSpeed(this.entityGuardian.getAIMoveSpeed() + (lllllllllllllllIlllIllllIlIIIIIl - this.entityGuardian.getAIMoveSpeed()) * 0.125f);
                double lllllllllllllllIlllIllllIlIIIIII = Math.sin((this.entityGuardian.ticksExisted + this.entityGuardian.getEntityId()) * 0.5) * 0.05;
                final double lllllllllllllllIlllIllllIIllllll = Math.cos(this.entityGuardian.rotationYaw * 0.017453292f);
                final double lllllllllllllllIlllIllllIIlllllI = Math.sin(this.entityGuardian.rotationYaw * 0.017453292f);
                final EntityGuardian entityGuardian = this.entityGuardian;
                entityGuardian.motionX += lllllllllllllllIlllIllllIlIIIIII * lllllllllllllllIlllIllllIIllllll;
                final EntityGuardian entityGuardian2 = this.entityGuardian;
                entityGuardian2.motionZ += lllllllllllllllIlllIllllIlIIIIII * lllllllllllllllIlllIllllIIlllllI;
                lllllllllllllllIlllIllllIlIIIIII = Math.sin((this.entityGuardian.ticksExisted + this.entityGuardian.getEntityId()) * 0.75) * 0.05;
                final EntityGuardian entityGuardian3 = this.entityGuardian;
                entityGuardian3.motionY += lllllllllllllllIlllIllllIlIIIIII * (lllllllllllllllIlllIllllIIlllllI + lllllllllllllllIlllIllllIIllllll) * 0.25;
                final EntityGuardian entityGuardian4 = this.entityGuardian;
                entityGuardian4.motionY += this.entityGuardian.getAIMoveSpeed() * lllllllllllllllIlllIllllIlIIIlIl * 0.1;
                final EntityLookHelper lllllllllllllllIlllIllllIIllllIl = this.entityGuardian.getLookHelper();
                final double lllllllllllllllIlllIllllIIllllII = this.entityGuardian.posX + lllllllllllllllIlllIllllIlIIIllI / lllllllllllllllIlllIllllIlIIIIll * 2.0;
                final double lllllllllllllllIlllIllllIIlllIll = this.entityGuardian.getEyeHeight() + this.entityGuardian.posY + lllllllllllllllIlllIllllIlIIIlIl / lllllllllllllllIlllIllllIlIIIIll;
                final double lllllllllllllllIlllIllllIIlllIlI = this.entityGuardian.posZ + lllllllllllllllIlllIllllIlIIIlII / lllllllllllllllIlllIllllIlIIIIll * 2.0;
                double lllllllllllllllIlllIllllIIlllIIl = lllllllllllllllIlllIllllIIllllIl.getLookPosX();
                double lllllllllllllllIlllIllllIIlllIII = lllllllllllllllIlllIllllIIllllIl.getLookPosY();
                double lllllllllllllllIlllIllllIIllIlll = lllllllllllllllIlllIllllIIllllIl.getLookPosZ();
                if (!lllllllllllllllIlllIllllIIllllIl.getIsLooking()) {
                    lllllllllllllllIlllIllllIIlllIIl = lllllllllllllllIlllIllllIIllllII;
                    lllllllllllllllIlllIllllIIlllIII = lllllllllllllllIlllIllllIIlllIll;
                    lllllllllllllllIlllIllllIIllIlll = lllllllllllllllIlllIllllIIlllIlI;
                }
                this.entityGuardian.getLookHelper().setLookPosition(lllllllllllllllIlllIllllIIlllIIl + (lllllllllllllllIlllIllllIIllllII - lllllllllllllllIlllIllllIIlllIIl) * 0.125, lllllllllllllllIlllIllllIIlllIII + (lllllllllllllllIlllIllllIIlllIll - lllllllllllllllIlllIllllIIlllIII) * 0.125, lllllllllllllllIlllIllllIIllIlll + (lllllllllllllllIlllIllllIIlllIlI - lllllllllllllllIlllIllllIIllIlll) * 0.125, 10.0f, 40.0f);
                EntityGuardian.this.setMoving(true);
            }
            else {
                this.entityGuardian.setAIMoveSpeed(0.0f);
                EntityGuardian.this.setMoving(false);
            }
        }
    }
}
