package net.minecraft.entity.passive;

import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import javax.annotation.*;
import net.minecraft.world.*;
import net.minecraft.util.datafix.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import net.minecraft.entity.*;
import com.google.common.base.*;
import net.minecraft.entity.monster.*;
import net.minecraft.world.storage.loot.*;
import net.minecraft.nbt.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.util.math.*;
import net.minecraft.util.*;
import net.minecraft.network.datasync.*;
import java.util.*;
import net.minecraft.entity.ai.*;

public class EntityWolf extends EntityTameable
{
    private /* synthetic */ boolean isWet;
    private static final /* synthetic */ DataParameter<Boolean> BEGGING;
    private static final /* synthetic */ DataParameter<Float> DATA_HEALTH_ID;
    private /* synthetic */ float timeWolfIsShaking;
    private /* synthetic */ float prevTimeWolfIsShaking;
    private /* synthetic */ boolean isShaking;
    private static final /* synthetic */ DataParameter<Integer> COLLAR_COLOR;
    private /* synthetic */ float headRotationCourse;
    private /* synthetic */ float headRotationCourseOld;
    
    public void setBegging(final boolean llIIlIlIlIIlIII) {
        this.dataManager.set(EntityWolf.BEGGING, llIIlIlIlIIlIII);
    }
    
    @Override
    public boolean canBeLeashedTo(final EntityPlayer llIIlIlIIlIllII) {
        return !this.isAngry() && super.canBeLeashedTo(llIIlIlIIlIllII);
    }
    
    @Override
    public boolean shouldAttackEntity(final EntityLivingBase llIIlIlIIllIlIl, final EntityLivingBase llIIlIlIIllIIIl) {
        if (!(llIIlIlIIllIlIl instanceof EntityCreeper) && !(llIIlIlIIllIlIl instanceof EntityGhast)) {
            if (llIIlIlIIllIlIl instanceof EntityWolf) {
                final EntityWolf llIIlIlIIllIIll = (EntityWolf)llIIlIlIIllIlIl;
                if (llIIlIlIIllIIll.isTamed() && llIIlIlIIllIIll.getOwner() == llIIlIlIIllIIIl) {
                    return false;
                }
            }
            return (!(llIIlIlIIllIlIl instanceof EntityPlayer) || !(llIIlIlIIllIIIl instanceof EntityPlayer) || ((EntityPlayer)llIIlIlIIllIIIl).canAttackPlayer((EntityPlayer)llIIlIlIIllIlIl)) && (!(llIIlIlIIllIlIl instanceof AbstractHorse) || !((AbstractHorse)llIIlIlIIllIlIl).isTame());
        }
        return false;
    }
    
    @Override
    public boolean processInteract(final EntityPlayer llIIlIlIlllllII, final EnumHand llIIlIllIIIIIIl) {
        final ItemStack llIIlIllIIIIIII = llIIlIlIlllllII.getHeldItem(llIIlIllIIIIIIl);
        if (this.isTamed()) {
            if (!llIIlIllIIIIIII.func_190926_b()) {
                if (llIIlIllIIIIIII.getItem() instanceof ItemFood) {
                    final ItemFood llIIlIlIlllllll = (ItemFood)llIIlIllIIIIIII.getItem();
                    if (llIIlIlIlllllll.isWolfsFavoriteMeat() && this.dataManager.get(EntityWolf.DATA_HEALTH_ID) < 20.0f) {
                        if (!llIIlIlIlllllII.capabilities.isCreativeMode) {
                            llIIlIllIIIIIII.func_190918_g(1);
                        }
                        this.heal((float)llIIlIlIlllllll.getHealAmount(llIIlIllIIIIIII));
                        return true;
                    }
                }
                else if (llIIlIllIIIIIII.getItem() == Items.DYE) {
                    final EnumDyeColor llIIlIlIllllllI = EnumDyeColor.byDyeDamage(llIIlIllIIIIIII.getMetadata());
                    if (llIIlIlIllllllI != this.getCollarColor()) {
                        this.setCollarColor(llIIlIlIllllllI);
                        if (!llIIlIlIlllllII.capabilities.isCreativeMode) {
                            llIIlIllIIIIIII.func_190918_g(1);
                        }
                        return true;
                    }
                }
            }
            if (this.isOwner(llIIlIlIlllllII) && !this.world.isRemote && !this.isBreedingItem(llIIlIllIIIIIII)) {
                this.aiSit.setSitting(!this.isSitting());
                this.isJumping = false;
                this.navigator.clearPathEntity();
                this.setAttackTarget(null);
            }
        }
        else if (llIIlIllIIIIIII.getItem() == Items.BONE && !this.isAngry()) {
            if (!llIIlIlIlllllII.capabilities.isCreativeMode) {
                llIIlIllIIIIIII.func_190918_g(1);
            }
            if (!this.world.isRemote) {
                if (this.rand.nextInt(3) == 0) {
                    this.func_193101_c(llIIlIlIlllllII);
                    this.navigator.clearPathEntity();
                    this.setAttackTarget(null);
                    this.aiSit.setSitting(true);
                    this.setHealth(20.0f);
                    this.playTameEffect(true);
                    this.world.setEntityState(this, (byte)7);
                }
                else {
                    this.playTameEffect(false);
                    this.world.setEntityState(this, (byte)6);
                }
            }
            return true;
        }
        return super.processInteract(llIIlIlIlllllII, llIIlIllIIIIIIl);
    }
    
    @Override
    public void setAttackTarget(@Nullable final EntityLivingBase llIIlIlllllllII) {
        super.setAttackTarget(llIIlIlllllllII);
        if (llIIlIlllllllII == null) {
            this.setAngry(false);
        }
        else if (!this.isTamed()) {
            this.setAngry(true);
        }
    }
    
    public float getTailRotation() {
        if (this.isAngry()) {
            return 1.5393804f;
        }
        return this.isTamed() ? ((0.55f - (this.getMaxHealth() - this.dataManager.get(EntityWolf.DATA_HEALTH_ID)) * 0.02f) * 3.1415927f) : 0.62831855f;
    }
    
    public EntityWolf(final World llIIllIIIIIlIII) {
        super(llIIllIIIIIlIII);
        this.setSize(0.6f, 0.85f);
        this.setTamed(false);
    }
    
    @Override
    public void handleStatusUpdate(final byte llIIlIlIlllIIll) {
        if (llIIlIlIlllIIll == 8) {
            this.isShaking = true;
            this.timeWolfIsShaking = 0.0f;
            this.prevTimeWolfIsShaking = 0.0f;
        }
        else {
            super.handleStatusUpdate(llIIlIlIlllIIll);
        }
    }
    
    @Override
    public boolean canMateWith(final EntityAnimal llIIlIlIIlllllI) {
        if (llIIlIlIIlllllI == this) {
            return false;
        }
        if (!this.isTamed()) {
            return false;
        }
        if (!(llIIlIlIIlllllI instanceof EntityWolf)) {
            return false;
        }
        final EntityWolf llIIlIlIlIIIIII = (EntityWolf)llIIlIlIIlllllI;
        return llIIlIlIlIIIIII.isTamed() && !llIIlIlIlIIIIII.isSitting() && (this.isInLove() && llIIlIlIlIIIIII.isInLove());
    }
    
    @Override
    public boolean attackEntityAsMob(final Entity llIIlIllIIlIIll) {
        final boolean llIIlIllIIlIIlI = llIIlIllIIlIIll.attackEntityFrom(DamageSource.causeMobDamage(this), (float)(int)this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue());
        if (llIIlIllIIlIIlI) {
            this.applyEnchantments(this, llIIlIllIIlIIll);
        }
        return llIIlIllIIlIIlI;
    }
    
    public static void registerFixesWolf(final DataFixer llIIlIllllIllll) {
        EntityLiving.registerFixesMob(llIIlIllllIllll, EntityWolf.class);
    }
    
    public float getShadingWhileWet(final float llIIlIllIlllllI) {
        return 0.75f + (this.prevTimeWolfIsShaking + (this.timeWolfIsShaking - this.prevTimeWolfIsShaking) * llIIlIllIlllllI) / 2.0f * 0.25f;
    }
    
    public void setAngry(final boolean llIIlIlIllIIIII) {
        final byte llIIlIlIllIIIlI = this.dataManager.get(EntityWolf.TAMED);
        if (llIIlIlIllIIIII) {
            this.dataManager.set(EntityWolf.TAMED, (byte)(llIIlIlIllIIIlI | 0x2));
        }
        else {
            this.dataManager.set(EntityWolf.TAMED, (byte)(llIIlIlIllIIIlI & 0xFFFFFFFD));
        }
    }
    
    @Override
    protected SoundEvent getHurtSound(final DamageSource llIIlIlllIlllIl) {
        return SoundEvents.ENTITY_WOLF_HURT;
    }
    
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_WOLF_DEATH;
    }
    
    public EnumDyeColor getCollarColor() {
        return EnumDyeColor.byDyeDamage(this.dataManager.get(EntityWolf.COLLAR_COLOR) & 0xF);
    }
    
    @Override
    protected void playStepSound(final BlockPos llIIlIlllllIIll, final Block llIIlIlllllIIlI) {
        this.playSound(SoundEvents.ENTITY_WOLF_STEP, 0.15f, 1.0f);
    }
    
    @Override
    protected void initEntityAI() {
        this.aiSit = new EntityAISit(this);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, this.aiSit);
        this.tasks.addTask(3, new AIAvoidEntity<Object>(this, EntityLlama.class, 24.0f, 1.5, 1.5));
        this.tasks.addTask(4, new EntityAILeapAtTarget(this, 0.4f));
        this.tasks.addTask(5, new EntityAIAttackMelee(this, 1.0, true));
        this.tasks.addTask(6, new EntityAIFollowOwner(this, 1.0, 10.0f, 2.0f));
        this.tasks.addTask(7, new EntityAIMate(this, 1.0));
        this.tasks.addTask(8, new EntityAIWanderAvoidWater(this, 1.0));
        this.tasks.addTask(9, new EntityAIBeg(this, 8.0f));
        this.tasks.addTask(10, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0f));
        this.tasks.addTask(10, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
        this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true, (Class<?>[])new Class[0]));
        this.targetTasks.addTask(4, new EntityAITargetNonTamed<Object>(this, EntityAnimal.class, false, (com.google.common.base.Predicate<?>)new Predicate<Entity>() {
            public boolean apply(@Nullable final Entity llllllllllllllllIllIlllllIlIIIll) {
                return llllllllllllllllIllIlllllIlIIIll instanceof EntitySheep || llllllllllllllllIllIlllllIlIIIll instanceof EntityRabbit;
            }
        }));
        this.targetTasks.addTask(5, new EntityAINearestAttackableTarget<Object>(this, AbstractSkeleton.class, false));
    }
    
    @Nullable
    @Override
    protected ResourceLocation getLootTable() {
        return LootTableList.ENTITIES_WOLF;
    }
    
    @Override
    protected SoundEvent getAmbientSound() {
        if (this.isAngry()) {
            return SoundEvents.ENTITY_WOLF_GROWL;
        }
        if (this.rand.nextInt(3) == 0) {
            return (this.isTamed() && this.dataManager.get(EntityWolf.DATA_HEALTH_ID) < 10.0f) ? SoundEvents.ENTITY_WOLF_WHINE : SoundEvents.ENTITY_WOLF_PANT;
        }
        return SoundEvents.ENTITY_WOLF_AMBIENT;
    }
    
    public boolean isAngry() {
        return (this.dataManager.get(EntityWolf.TAMED) & 0x2) != 0x0;
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound llIIlIllllIlIlI) {
        super.writeEntityToNBT(llIIlIllllIlIlI);
        llIIlIllllIlIlI.setBoolean("Angry", this.isAngry());
        llIIlIllllIlIlI.setByte("CollarColor", (byte)this.getCollarColor().getDyeDamage());
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource llIIlIllIIllIlI, float llIIlIllIIllIIl) {
        if (this.isEntityInvulnerable(llIIlIllIIllIlI)) {
            return false;
        }
        final Entity llIIlIllIIlllII = llIIlIllIIllIlI.getEntity();
        if (this.aiSit != null) {
            this.aiSit.setSitting(false);
        }
        if (llIIlIllIIlllII != null && !(llIIlIllIIlllII instanceof EntityPlayer) && !(llIIlIllIIlllII instanceof EntityArrow)) {
            llIIlIllIIllIIl = (llIIlIllIIllIIl + 1.0f) / 2.0f;
        }
        return super.attackEntityFrom(llIIlIllIIllIlI, llIIlIllIIllIIl);
    }
    
    public boolean isBegging() {
        return this.dataManager.get(EntityWolf.BEGGING);
    }
    
    @Override
    protected void updateAITasks() {
        this.dataManager.set(EntityWolf.DATA_HEALTH_ID, this.getHealth());
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.30000001192092896);
        if (this.isTamed()) {
            this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0);
        }
        else {
            this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(8.0);
        }
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.0);
    }
    
    @Override
    public int getMaxSpawnedInChunk() {
        return 8;
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound llIIlIllllIIlII) {
        super.readEntityFromNBT(llIIlIllllIIlII);
        this.setAngry(llIIlIllllIIlII.getBoolean("Angry"));
        if (llIIlIllllIIlII.hasKey("CollarColor", 99)) {
            this.setCollarColor(EnumDyeColor.byDyeDamage(llIIlIllllIIlII.getByte("CollarColor")));
        }
    }
    
    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (!this.world.isRemote && this.isWet && !this.isShaking && !this.hasPath() && this.onGround) {
            this.isShaking = true;
            this.timeWolfIsShaking = 0.0f;
            this.prevTimeWolfIsShaking = 0.0f;
            this.world.setEntityState(this, (byte)8);
        }
        if (!this.world.isRemote && this.getAttackTarget() == null && this.isAngry()) {
            this.setAngry(false);
        }
    }
    
    @Override
    public void onUpdate() {
        super.onUpdate();
        this.headRotationCourseOld = this.headRotationCourse;
        if (this.isBegging()) {
            this.headRotationCourse += (1.0f - this.headRotationCourse) * 0.4f;
        }
        else {
            this.headRotationCourse += (0.0f - this.headRotationCourse) * 0.4f;
        }
        if (this.isWet()) {
            this.isWet = true;
            this.isShaking = false;
            this.timeWolfIsShaking = 0.0f;
            this.prevTimeWolfIsShaking = 0.0f;
        }
        else if ((this.isWet || this.isShaking) && this.isShaking) {
            if (this.timeWolfIsShaking == 0.0f) {
                this.playSound(SoundEvents.ENTITY_WOLF_SHAKE, this.getSoundVolume(), (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.0f);
            }
            this.prevTimeWolfIsShaking = this.timeWolfIsShaking;
            this.timeWolfIsShaking += 0.05f;
            if (this.prevTimeWolfIsShaking >= 2.0f) {
                this.isWet = false;
                this.isShaking = false;
                this.prevTimeWolfIsShaking = 0.0f;
                this.timeWolfIsShaking = 0.0f;
            }
            if (this.timeWolfIsShaking > 0.4f) {
                final float llIIlIlllIIllll = (float)this.getEntityBoundingBox().minY;
                for (int llIIlIlllIIlllI = (int)(MathHelper.sin((this.timeWolfIsShaking - 0.4f) * 3.1415927f) * 7.0f), llIIlIlllIIllIl = 0; llIIlIlllIIllIl < llIIlIlllIIlllI; ++llIIlIlllIIllIl) {
                    final float llIIlIlllIIllII = (this.rand.nextFloat() * 2.0f - 1.0f) * this.width * 0.5f;
                    final float llIIlIlllIIlIll = (this.rand.nextFloat() * 2.0f - 1.0f) * this.width * 0.5f;
                    this.world.spawnParticle(EnumParticleTypes.WATER_SPLASH, this.posX + llIIlIlllIIllII, llIIlIlllIIllll + 0.8f, this.posZ + llIIlIlllIIlIll, this.motionX, this.motionY, this.motionZ, new int[0]);
                }
            }
        }
    }
    
    static {
        DATA_HEALTH_ID = EntityDataManager.createKey(EntityWolf.class, DataSerializers.FLOAT);
        BEGGING = EntityDataManager.createKey(EntityWolf.class, DataSerializers.BOOLEAN);
        COLLAR_COLOR = EntityDataManager.createKey(EntityWolf.class, DataSerializers.VARINT);
    }
    
    @Override
    public void setTamed(final boolean llIIlIllIIIlIIl) {
        super.setTamed(llIIlIllIIIlIIl);
        if (llIIlIllIIIlIIl) {
            this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0);
        }
        else {
            this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(8.0);
        }
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.0);
    }
    
    public void setCollarColor(final EnumDyeColor llIIlIlIlIlIllI) {
        this.dataManager.set(EntityWolf.COLLAR_COLOR, llIIlIlIlIlIllI.getDyeDamage());
    }
    
    @Override
    public boolean isBreedingItem(final ItemStack llIIlIlIllIllIl) {
        return llIIlIlIllIllIl.getItem() instanceof ItemFood && ((ItemFood)llIIlIlIllIllIl.getItem()).isWolfsFavoriteMeat();
    }
    
    @Override
    public float getEyeHeight() {
        return this.height * 0.8f;
    }
    
    @Override
    public EntityWolf createChild(final EntityAgeable llIIlIlIlIlIIIl) {
        final EntityWolf llIIlIlIlIlIIII = new EntityWolf(this.world);
        final UUID llIIlIlIlIIllll = this.getOwnerId();
        if (llIIlIlIlIIllll != null) {
            llIIlIlIlIlIIII.setOwnerId(llIIlIlIlIIllll);
            llIIlIlIlIlIIII.setTamed(true);
        }
        return llIIlIlIlIlIIII;
    }
    
    @Override
    public int getVerticalFaceSpeed() {
        return this.isSitting() ? 20 : super.getVerticalFaceSpeed();
    }
    
    public float getInterestedAngle(final float llIIlIllIlIlIlI) {
        return (this.headRotationCourseOld + (this.headRotationCourse - this.headRotationCourseOld) * llIIlIllIlIlIlI) * 0.15f * 3.1415927f;
    }
    
    public float getShakeAngle(final float llIIlIllIllIIlI, final float llIIlIllIllIlIl) {
        float llIIlIllIllIlII = (this.prevTimeWolfIsShaking + (this.timeWolfIsShaking - this.prevTimeWolfIsShaking) * llIIlIllIllIIlI + llIIlIllIllIlIl) / 1.8f;
        if (llIIlIllIllIlII < 0.0f) {
            llIIlIllIllIlII = 0.0f;
        }
        else if (llIIlIllIllIlII > 1.0f) {
            llIIlIllIllIlII = 1.0f;
        }
        return MathHelper.sin(llIIlIllIllIlII * 3.1415927f) * MathHelper.sin(llIIlIllIllIlII * 3.1415927f * 11.0f) * 0.15f * 3.1415927f;
    }
    
    public boolean isWolfWet() {
        return this.isWet;
    }
    
    @Override
    protected float getSoundVolume() {
        return 0.4f;
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(EntityWolf.DATA_HEALTH_ID, this.getHealth());
        this.dataManager.register(EntityWolf.BEGGING, false);
        this.dataManager.register(EntityWolf.COLLAR_COLOR, EnumDyeColor.RED.getDyeDamage());
    }
    
    class AIAvoidEntity<T extends Entity> extends EntityAIAvoidEntity<T>
    {
        public AIAvoidEntity(final Class<T> lllllllllllllIlIIllIlllllIlIIIIl, final float lllllllllllllIlIIllIlllllIlIIlll, final double lllllllllllllIlIIllIlllllIlIIllI, final double lllllllllllllIlIIllIlllllIlIIlIl) {
            super(EntityWolf.this, lllllllllllllIlIIllIlllllIlIIIIl, lllllllllllllIlIIllIlllllIlIIlll, lllllllllllllIlIIllIlllllIlIIllI, lllllllllllllIlIIllIlllllIlIIlIl);
        }
        
        private boolean func_190854_a(final EntityLlama lllllllllllllIlIIllIlllllIIlIlll) {
            return lllllllllllllIlIIllIlllllIIlIlll.func_190707_dL() >= EntityWolf.this.rand.nextInt(5);
        }
        
        @Override
        public boolean shouldExecute() {
            return super.shouldExecute() && this.closestLivingEntity instanceof EntityLlama && (!EntityWolf.this.isTamed() && this.func_190854_a((EntityLlama)this.closestLivingEntity));
        }
        
        @Override
        public void startExecuting() {
            EntityWolf.this.setAttackTarget(null);
            super.startExecuting();
        }
        
        @Override
        public void updateTask() {
            EntityWolf.this.setAttackTarget(null);
            super.updateTask();
        }
    }
}
