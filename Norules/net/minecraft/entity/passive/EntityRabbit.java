package net.minecraft.entity.passive;

import net.minecraft.network.datasync.*;
import net.minecraft.util.datafix.*;
import net.minecraft.block.*;
import net.minecraft.block.state.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import net.minecraft.nbt.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.text.translation.*;
import net.minecraft.world.storage.loot.*;
import javax.annotation.*;
import net.minecraft.world.biome.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.pathfinding.*;
import net.minecraft.entity.monster.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.block.properties.*;
import net.minecraft.entity.ai.*;

public class EntityRabbit extends EntityAnimal
{
    private /* synthetic */ boolean wasOnGround;
    private /* synthetic */ int currentMoveTypeDuration;
    private /* synthetic */ int jumpDuration;
    private /* synthetic */ int carrotTicks;
    private static final /* synthetic */ DataParameter<Integer> RABBIT_TYPE;
    private /* synthetic */ int jumpTicks;
    
    static {
        RABBIT_TYPE = EntityDataManager.createKey(EntityRabbit.class, DataSerializers.VARINT);
    }
    
    @Override
    public void spawnRunningParticles() {
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(3.0);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.30000001192092896);
    }
    
    @Override
    public boolean isBreedingItem(final ItemStack lllllllllllllllllIlIllIIIIIllIIl) {
        return this.isRabbitBreedingItem(lllllllllllllllllIlIllIIIIIllIIl.getItem());
    }
    
    private void disableJumpControl() {
        ((RabbitJumpHelper)this.jumpHelper).setCanJump(false);
    }
    
    public static void registerFixesRabbit(final DataFixer lllllllllllllllllIlIllIIIlIlIlII) {
        EntityLiving.registerFixesMob(lllllllllllllllllIlIllIIIlIlIlII, EntityRabbit.class);
    }
    
    protected void createEatingParticles() {
        final BlockCarrot lllllllllllllllllIlIlIllllllIIII = (BlockCarrot)Blocks.CARROTS;
        final IBlockState lllllllllllllllllIlIlIlllllIllll = lllllllllllllllllIlIlIllllllIIII.withAge(lllllllllllllllllIlIlIllllllIIII.getMaxAge());
        this.world.spawnParticle(EnumParticleTypes.BLOCK_DUST, this.posX + this.rand.nextFloat() * this.width * 2.0f - this.width, this.posY + 0.5 + this.rand.nextFloat() * this.height, this.posZ + this.rand.nextFloat() * this.width * 2.0f - this.width, 0.0, 0.0, 0.0, Block.getStateId(lllllllllllllllllIlIlIlllllIllll));
        this.carrotTicks = 40;
    }
    
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_RABBIT_AMBIENT;
    }
    
    private void enableJumpControl() {
        ((RabbitJumpHelper)this.jumpHelper).setCanJump(true);
    }
    
    @Override
    public SoundCategory getSoundCategory() {
        return (this.getRabbitType() == 99) ? SoundCategory.HOSTILE : SoundCategory.NEUTRAL;
    }
    
    private void calculateRotationYaw(final double lllllllllllllllllIlIllIIIllIllII, final double lllllllllllllllllIlIllIIIllIlIll) {
        this.rotationYaw = (float)(MathHelper.atan2(lllllllllllllllllIlIllIIIllIlIll - this.posZ, lllllllllllllllllIlIllIIIllIllII - this.posX) * 57.29577951308232) - 90.0f;
    }
    
    @Override
    public EntityRabbit createChild(final EntityAgeable lllllllllllllllllIlIllIIIIlIIlIl) {
        final EntityRabbit lllllllllllllllllIlIllIIIIlIIlII = new EntityRabbit(this.world);
        int lllllllllllllllllIlIllIIIIlIIIll = this.getRandomRabbitType();
        if (this.rand.nextInt(20) != 0) {
            if (lllllllllllllllllIlIllIIIIlIIlIl instanceof EntityRabbit && this.rand.nextBoolean()) {
                lllllllllllllllllIlIllIIIIlIIIll = ((EntityRabbit)lllllllllllllllllIlIllIIIIlIIlIl).getRabbitType();
            }
            else {
                lllllllllllllllllIlIllIIIIlIIIll = this.getRabbitType();
            }
        }
        lllllllllllllllllIlIllIIIIlIIlII.setRabbitType(lllllllllllllllllIlIllIIIIlIIIll);
        return lllllllllllllllllIlIllIIIIlIIlII;
    }
    
    private boolean isRabbitBreedingItem(final Item lllllllllllllllllIlIllIIIIlIllII) {
        return lllllllllllllllllIlIllIIIIlIllII == Items.CARROT || lllllllllllllllllIlIllIIIIlIllII == Items.GOLDEN_CARROT || lllllllllllllllllIlIllIIIIlIllII == Item.getItemFromBlock(Blocks.YELLOW_FLOWER);
    }
    
    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (this.jumpTicks != this.jumpDuration) {
            ++this.jumpTicks;
        }
        else if (this.jumpDuration != 0) {
            this.jumpTicks = 0;
            this.jumpDuration = 0;
            this.setJumping(false);
        }
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound lllllllllllllllllIlIllIIIlIIllll) {
        super.writeEntityToNBT(lllllllllllllllllIlIllIIIlIIllll);
        lllllllllllllllllIlIllIIIlIIllll.setInteger("RabbitType", this.getRabbitType());
        lllllllllllllllllIlIllIIIlIIllll.setInteger("MoreCarrotTicks", this.carrotTicks);
    }
    
    private boolean isCarrotEaten() {
        return this.carrotTicks == 0;
    }
    
    protected SoundEvent getJumpSound() {
        return SoundEvents.ENTITY_RABBIT_JUMP;
    }
    
    public void setRabbitType(final int lllllllllllllllllIlIllIIIIIlIIII) {
        if (lllllllllllllllllIlIllIIIIIlIIII == 99) {
            this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(8.0);
            this.tasks.addTask(4, new AIEvilAttack(this));
            this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false, (Class<?>[])new Class[0]));
            this.targetTasks.addTask(2, new EntityAINearestAttackableTarget<Object>(this, EntityPlayer.class, true));
            this.targetTasks.addTask(2, new EntityAINearestAttackableTarget<Object>(this, EntityWolf.class, true));
            if (!this.hasCustomName()) {
                this.setCustomNameTag(I18n.translateToLocal("entity.KillerBunny.name"));
            }
        }
        this.dataManager.set(EntityRabbit.RABBIT_TYPE, lllllllllllllllllIlIllIIIIIlIIII);
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(EntityRabbit.RABBIT_TYPE, 0);
    }
    
    @Nullable
    @Override
    protected ResourceLocation getLootTable() {
        return LootTableList.ENTITIES_RABBIT;
    }
    
    public EntityRabbit(final World lllllllllllllllllIlIllIIlIlIllII) {
        super(lllllllllllllllllIlIllIIlIlIllII);
        this.setSize(0.4f, 0.5f);
        this.jumpHelper = new RabbitJumpHelper(this);
        this.moveHelper = new RabbitMoveHelper(this);
        this.setMovementSpeed(0.0);
    }
    
    private void checkLandingDelay() {
        this.updateMoveTypeDuration();
        this.disableJumpControl();
    }
    
    private int getRandomRabbitType() {
        final Biome lllllllllllllllllIlIlIllllllllII = this.world.getBiome(new BlockPos(this));
        final int lllllllllllllllllIlIlIlllllllIll = this.rand.nextInt(100);
        if (lllllllllllllllllIlIlIllllllllII.isSnowyBiome()) {
            return (lllllllllllllllllIlIlIlllllllIll < 80) ? 1 : 3;
        }
        if (lllllllllllllllllIlIlIllllllllII instanceof BiomeDesert) {
            return 4;
        }
        return (lllllllllllllllllIlIlIlllllllIll < 50) ? 0 : ((lllllllllllllllllIlIlIlllllllIll < 90) ? 5 : 2);
    }
    
    @Override
    protected SoundEvent getHurtSound(final DamageSource lllllllllllllllllIlIllIIIlIIIIll) {
        return SoundEvents.ENTITY_RABBIT_HURT;
    }
    
    public float setJumpCompletion(final float lllllllllllllllllIlIllIIlIIlIIIl) {
        return (this.jumpDuration == 0) ? 0.0f : ((this.jumpTicks + lllllllllllllllllIlIllIIlIIlIIIl) / this.jumpDuration);
    }
    
    public void setMovementSpeed(final double lllllllllllllllllIlIllIIlIIIlIll) {
        this.getNavigator().setSpeed(lllllllllllllllllIlIllIIlIIIlIll);
        this.moveHelper.setMoveTo(this.moveHelper.getX(), this.moveHelper.getY(), this.moveHelper.getZ(), lllllllllllllllllIlIllIIlIIIlIll);
    }
    
    public int getRabbitType() {
        return this.dataManager.get(EntityRabbit.RABBIT_TYPE);
    }
    
    private void updateMoveTypeDuration() {
        if (this.moveHelper.getSpeed() < 2.2) {
            this.currentMoveTypeDuration = 10;
        }
        else {
            this.currentMoveTypeDuration = 1;
        }
    }
    
    @Override
    public void setJumping(final boolean lllllllllllllllllIlIllIIlIIIIlll) {
        super.setJumping(lllllllllllllllllIlIllIIlIIIIlll);
        if (lllllllllllllllllIlIllIIlIIIIlll) {
            this.playSound(this.getJumpSound(), this.getSoundVolume(), ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.0f) * 0.8f);
        }
    }
    
    @Override
    public void handleStatusUpdate(final byte lllllllllllllllllIlIlIlllllIlIII) {
        if (lllllllllllllllllIlIlIlllllIlIII == 1) {
            this.createRunningParticles();
            this.jumpDuration = 10;
            this.jumpTicks = 0;
        }
        else {
            super.handleStatusUpdate(lllllllllllllllllIlIlIlllllIlIII);
        }
    }
    
    public void updateAITasks() {
        if (this.currentMoveTypeDuration > 0) {
            --this.currentMoveTypeDuration;
        }
        if (this.carrotTicks > 0) {
            this.carrotTicks -= this.rand.nextInt(3);
            if (this.carrotTicks < 0) {
                this.carrotTicks = 0;
            }
        }
        if (this.onGround) {
            if (!this.wasOnGround) {
                this.setJumping(false);
                this.checkLandingDelay();
            }
            if (this.getRabbitType() == 99 && this.currentMoveTypeDuration == 0) {
                final EntityLivingBase lllllllllllllllllIlIllIIIllllIIl = this.getAttackTarget();
                if (lllllllllllllllllIlIllIIIllllIIl != null && this.getDistanceSqToEntity(lllllllllllllllllIlIllIIIllllIIl) < 16.0) {
                    this.calculateRotationYaw(lllllllllllllllllIlIllIIIllllIIl.posX, lllllllllllllllllIlIllIIIllllIIl.posZ);
                    this.moveHelper.setMoveTo(lllllllllllllllllIlIllIIIllllIIl.posX, lllllllllllllllllIlIllIIIllllIIl.posY, lllllllllllllllllIlIllIIIllllIIl.posZ, this.moveHelper.getSpeed());
                    this.startJumping();
                    this.wasOnGround = true;
                }
            }
            final RabbitJumpHelper lllllllllllllllllIlIllIIIllllIII = (RabbitJumpHelper)this.jumpHelper;
            if (!lllllllllllllllllIlIllIIIllllIII.getIsJumping()) {
                if (this.moveHelper.isUpdating() && this.currentMoveTypeDuration == 0) {
                    final Path lllllllllllllllllIlIllIIIlllIlll = this.navigator.getPath();
                    Vec3d lllllllllllllllllIlIllIIIlllIllI = new Vec3d(this.moveHelper.getX(), this.moveHelper.getY(), this.moveHelper.getZ());
                    if (lllllllllllllllllIlIllIIIlllIlll != null && lllllllllllllllllIlIllIIIlllIlll.getCurrentPathIndex() < lllllllllllllllllIlIllIIIlllIlll.getCurrentPathLength()) {
                        lllllllllllllllllIlIllIIIlllIllI = lllllllllllllllllIlIllIIIlllIlll.getPosition(this);
                    }
                    this.calculateRotationYaw(lllllllllllllllllIlIllIIIlllIllI.xCoord, lllllllllllllllllIlIllIIIlllIllI.zCoord);
                    this.startJumping();
                }
            }
            else if (!lllllllllllllllllIlIllIIIllllIII.canJump()) {
                this.enableJumpControl();
            }
        }
        this.wasOnGround = this.onGround;
    }
    
    @Override
    protected void initEntityAI() {
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(1, new AIPanic(this, 2.2));
        this.tasks.addTask(2, new EntityAIMate(this, 0.8));
        this.tasks.addTask(3, new EntityAITempt(this, 1.0, Items.CARROT, false));
        this.tasks.addTask(3, new EntityAITempt(this, 1.0, Items.GOLDEN_CARROT, false));
        this.tasks.addTask(3, new EntityAITempt(this, 1.0, Item.getItemFromBlock(Blocks.YELLOW_FLOWER), false));
        this.tasks.addTask(4, new AIAvoidEntity<Object>(this, EntityPlayer.class, 8.0f, 2.2, 2.2));
        this.tasks.addTask(4, new AIAvoidEntity<Object>(this, EntityWolf.class, 10.0f, 2.2, 2.2));
        this.tasks.addTask(4, new AIAvoidEntity<Object>(this, EntityMob.class, 4.0f, 2.2, 2.2));
        this.tasks.addTask(5, new AIRaidFarm(this));
        this.tasks.addTask(6, new EntityAIWanderAvoidWater(this, 0.6));
        this.tasks.addTask(11, new EntityAIWatchClosest(this, EntityPlayer.class, 10.0f));
    }
    
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_RABBIT_DEATH;
    }
    
    @Override
    protected float getJumpUpwardsMotion() {
        if (!this.isCollidedHorizontally && (!this.moveHelper.isUpdating() || this.moveHelper.getY() <= this.posY + 0.5)) {
            final Path lllllllllllllllllIlIllIIlIlIIlII = this.navigator.getPath();
            if (lllllllllllllllllIlIllIIlIlIIlII != null && lllllllllllllllllIlIllIIlIlIIlII.getCurrentPathIndex() < lllllllllllllllllIlIllIIlIlIIlII.getCurrentPathLength()) {
                final Vec3d lllllllllllllllllIlIllIIlIlIIIll = lllllllllllllllllIlIllIIlIlIIlII.getPosition(this);
                if (lllllllllllllllllIlIllIIlIlIIIll.yCoord > this.posY + 0.5) {
                    return 0.5f;
                }
            }
            return (this.moveHelper.getSpeed() <= 0.6) ? 0.2f : 0.3f;
        }
        return 0.5f;
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource lllllllllllllllllIlIllIIIIllIlII, final float lllllllllllllllllIlIllIIIIllIIII) {
        return !this.isEntityInvulnerable(lllllllllllllllllIlIllIIIIllIlII) && super.attackEntityFrom(lllllllllllllllllIlIllIIIIllIlII, lllllllllllllllllIlIllIIIIllIIII);
    }
    
    @Override
    public boolean attackEntityAsMob(final Entity lllllllllllllllllIlIllIIIIlllllI) {
        if (this.getRabbitType() == 99) {
            this.playSound(SoundEvents.ENTITY_RABBIT_ATTACK, 1.0f, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.0f);
            return lllllllllllllllllIlIllIIIIlllllI.attackEntityFrom(DamageSource.causeMobDamage(this), 8.0f);
        }
        return lllllllllllllllllIlIllIIIIlllllI.attackEntityFrom(DamageSource.causeMobDamage(this), 3.0f);
    }
    
    @Nullable
    @Override
    public IEntityLivingData onInitialSpawn(final DifficultyInstance lllllllllllllllllIlIllIIIIIIlIIl, @Nullable IEntityLivingData lllllllllllllllllIlIllIIIIIIIIll) {
        lllllllllllllllllIlIllIIIIIIIIll = super.onInitialSpawn(lllllllllllllllllIlIllIIIIIIlIIl, lllllllllllllllllIlIllIIIIIIIIll);
        int lllllllllllllllllIlIllIIIIIIIlll = this.getRandomRabbitType();
        boolean lllllllllllllllllIlIllIIIIIIIllI = false;
        if (lllllllllllllllllIlIllIIIIIIIIll instanceof RabbitTypeData) {
            lllllllllllllllllIlIllIIIIIIIlll = ((RabbitTypeData)lllllllllllllllllIlIllIIIIIIIIll).typeData;
            lllllllllllllllllIlIllIIIIIIIllI = true;
        }
        else {
            lllllllllllllllllIlIllIIIIIIIIll = new RabbitTypeData(lllllllllllllllllIlIllIIIIIIIlll);
        }
        this.setRabbitType(lllllllllllllllllIlIllIIIIIIIlll);
        if (lllllllllllllllllIlIllIIIIIIIllI) {
            this.setGrowingAge(-24000);
        }
        return lllllllllllllllllIlIllIIIIIIIIll;
    }
    
    @Override
    protected void jump() {
        super.jump();
        final double lllllllllllllllllIlIllIIlIIllIll = this.moveHelper.getSpeed();
        if (lllllllllllllllllIlIllIIlIIllIll > 0.0) {
            final double lllllllllllllllllIlIllIIlIIllIlI = this.motionX * this.motionX + this.motionZ * this.motionZ;
            if (lllllllllllllllllIlIllIIlIIllIlI < 0.010000000000000002) {
                this.func_191958_b(0.0f, 0.0f, 1.0f, 0.1f);
            }
        }
        if (!this.world.isRemote) {
            this.world.setEntityState(this, (byte)1);
        }
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound lllllllllllllllllIlIllIIIlIIIlll) {
        super.readEntityFromNBT(lllllllllllllllllIlIllIIIlIIIlll);
        this.setRabbitType(lllllllllllllllllIlIllIIIlIIIlll.getInteger("RabbitType"));
        this.carrotTicks = lllllllllllllllllIlIllIIIlIIIlll.getInteger("MoreCarrotTicks");
    }
    
    public void startJumping() {
        this.setJumping(true);
        this.jumpDuration = 10;
        this.jumpTicks = 0;
    }
    
    static class AIRaidFarm extends EntityAIMoveToBlock
    {
        private final /* synthetic */ EntityRabbit rabbit;
        private /* synthetic */ boolean wantsToRaid;
        private /* synthetic */ boolean canRaid;
        
        @Override
        protected boolean shouldMoveTo(final World lllllllllllllIIIllIIlIllllllIllI, BlockPos lllllllllllllIIIllIIlIllllllIIII) {
            Block lllllllllllllIIIllIIlIllllllIlII = lllllllllllllIIIllIIlIllllllIllI.getBlockState(lllllllllllllIIIllIIlIllllllIIII).getBlock();
            if (lllllllllllllIIIllIIlIllllllIlII == Blocks.FARMLAND && this.wantsToRaid && !this.canRaid) {
                lllllllllllllIIIllIIlIllllllIIII = lllllllllllllIIIllIIlIllllllIIII.up();
                final IBlockState lllllllllllllIIIllIIlIllllllIIll = lllllllllllllIIIllIIlIllllllIllI.getBlockState(lllllllllllllIIIllIIlIllllllIIII);
                lllllllllllllIIIllIIlIllllllIlII = lllllllllllllIIIllIIlIllllllIIll.getBlock();
                if (lllllllllllllIIIllIIlIllllllIlII instanceof BlockCarrot && ((BlockCarrot)lllllllllllllIIIllIIlIllllllIlII).isMaxAge(lllllllllllllIIIllIIlIllllllIIll)) {
                    this.canRaid = true;
                    return true;
                }
            }
            return false;
        }
        
        @Override
        public void updateTask() {
            super.updateTask();
            this.rabbit.getLookHelper().setLookPosition(this.destinationBlock.getX() + 0.5, this.destinationBlock.getY() + 1, this.destinationBlock.getZ() + 0.5, 10.0f, (float)this.rabbit.getVerticalFaceSpeed());
            if (this.getIsAboveDestination()) {
                final World lllllllllllllIIIllIIllIIIIIIllll = this.rabbit.world;
                final BlockPos lllllllllllllIIIllIIllIIIIIIllIl = this.destinationBlock.up();
                final IBlockState lllllllllllllIIIllIIllIIIIIIlIll = lllllllllllllIIIllIIllIIIIIIllll.getBlockState(lllllllllllllIIIllIIllIIIIIIllIl);
                final Block lllllllllllllIIIllIIllIIIIIIlIlI = lllllllllllllIIIllIIllIIIIIIlIll.getBlock();
                if (this.canRaid && lllllllllllllIIIllIIllIIIIIIlIlI instanceof BlockCarrot) {
                    final Integer lllllllllllllIIIllIIllIIIIIIlIIl = lllllllllllllIIIllIIllIIIIIIlIll.getValue((IProperty<Integer>)BlockCarrot.AGE);
                    if (lllllllllllllIIIllIIllIIIIIIlIIl == 0) {
                        lllllllllllllIIIllIIllIIIIIIllll.setBlockState(lllllllllllllIIIllIIllIIIIIIllIl, Blocks.AIR.getDefaultState(), 2);
                        lllllllllllllIIIllIIllIIIIIIllll.destroyBlock(lllllllllllllIIIllIIllIIIIIIllIl, true);
                    }
                    else {
                        lllllllllllllIIIllIIllIIIIIIllll.setBlockState(lllllllllllllIIIllIIllIIIIIIllIl, lllllllllllllIIIllIIllIIIIIIlIll.withProperty((IProperty<Comparable>)BlockCarrot.AGE, lllllllllllllIIIllIIllIIIIIIlIIl - 1), 2);
                        lllllllllllllIIIllIIllIIIIIIllll.playEvent(2001, lllllllllllllIIIllIIllIIIIIIllIl, Block.getStateId(lllllllllllllIIIllIIllIIIIIIlIll));
                    }
                    this.rabbit.createEatingParticles();
                }
                this.canRaid = false;
                this.runDelay = 10;
            }
        }
        
        public AIRaidFarm() {
            super(EntityRabbit.this, 0.699999988079071, 16);
        }
        
        @Override
        public boolean shouldExecute() {
            if (this.runDelay <= 0) {
                if (!this.rabbit.world.getGameRules().getBoolean("mobGriefing")) {
                    return false;
                }
                this.canRaid = false;
                this.wantsToRaid = EntityRabbit.this.isCarrotEaten();
                this.wantsToRaid = true;
            }
            return super.shouldExecute();
        }
        
        @Override
        public boolean continueExecuting() {
            return this.canRaid && super.continueExecuting();
        }
    }
    
    public class RabbitJumpHelper extends EntityJumpHelper
    {
        private /* synthetic */ boolean canJump;
        
        @Override
        public void doJump() {
            if (this.isJumping) {
                EntityRabbit.this.startJumping();
                this.isJumping = false;
            }
        }
        
        public void setCanJump(final boolean lllllllllllllllIIIllIlllIIlIIlII) {
            this.canJump = lllllllllllllllIIIllIlllIIlIIlII;
        }
        
        public boolean getIsJumping() {
            return this.isJumping;
        }
        
        public boolean canJump() {
            return this.canJump;
        }
        
        public RabbitJumpHelper() {
            super(EntityRabbit.this);
        }
    }
    
    static class AIPanic extends EntityAIPanic
    {
        private final /* synthetic */ EntityRabbit theEntity;
        
        public AIPanic(final double lllllllllllllIlIlIllIIIlIIllllIl) {
            super(EntityRabbit.this, lllllllllllllIlIlIllIIIlIIllllIl);
        }
        
        @Override
        public void updateTask() {
            super.updateTask();
            this.theEntity.setMovementSpeed(this.speed);
        }
    }
    
    static class RabbitMoveHelper extends EntityMoveHelper
    {
        private /* synthetic */ double nextJumpSpeed;
        private final /* synthetic */ EntityRabbit theEntity;
        
        public RabbitMoveHelper() {
            super(EntityRabbit.this);
        }
        
        @Override
        public void onUpdateMoveHelper() {
            if (this.theEntity.onGround && !this.theEntity.isJumping && !((RabbitJumpHelper)this.theEntity.jumpHelper).getIsJumping()) {
                this.theEntity.setMovementSpeed(0.0);
            }
            else if (this.isUpdating()) {
                this.theEntity.setMovementSpeed(this.nextJumpSpeed);
            }
            super.onUpdateMoveHelper();
        }
        
        @Override
        public void setMoveTo(final double llllllllllllllIlIlIllllllllllllI, final double llllllllllllllIlIlIlllllllllllIl, final double llllllllllllllIlIlIlllllllllIlll, double llllllllllllllIlIlIlllllllllIllI) {
            if (this.theEntity.isInWater()) {
                llllllllllllllIlIlIlllllllllIllI = 1.5;
            }
            super.setMoveTo(llllllllllllllIlIlIllllllllllllI, llllllllllllllIlIlIlllllllllllIl, llllllllllllllIlIlIlllllllllIlll, llllllllllllllIlIlIlllllllllIllI);
            if (llllllllllllllIlIlIlllllllllIllI > 0.0) {
                this.nextJumpSpeed = llllllllllllllIlIlIlllllllllIllI;
            }
        }
    }
    
    public static class RabbitTypeData implements IEntityLivingData
    {
        public /* synthetic */ int typeData;
        
        public RabbitTypeData(final int lllllllllllllllIIIlllIlIIlIIIlll) {
            this.typeData = lllllllllllllllIIIlllIlIIlIIIlll;
        }
    }
    
    static class AIEvilAttack extends EntityAIAttackMelee
    {
        public AIEvilAttack(final EntityRabbit lllllllllllllllllIIllIIIlIIlIIll) {
            super(lllllllllllllllllIIllIIIlIIlIIll, 1.4, true);
        }
        
        @Override
        protected double getAttackReachSqr(final EntityLivingBase lllllllllllllllllIIllIIIlIIIllIl) {
            return 4.0f + lllllllllllllllllIIllIIIlIIIllIl.width;
        }
    }
    
    static class AIAvoidEntity<T extends Entity> extends EntityAIAvoidEntity<T>
    {
        private final /* synthetic */ EntityRabbit entityInstance;
        
        public AIAvoidEntity(final Class<T> lllllllllllllllIIIllIllIIIIIlIII, final float lllllllllllllllIIIllIllIIIIIllIl, final double lllllllllllllllIIIllIllIIIIIllII, final double lllllllllllllllIIIllIllIIIIIlIll) {
            super(EntityRabbit.this, lllllllllllllllIIIllIllIIIIIlIII, lllllllllllllllIIIllIllIIIIIllIl, lllllllllllllllIIIllIllIIIIIllII, lllllllllllllllIIIllIllIIIIIlIll);
        }
        
        @Override
        public boolean shouldExecute() {
            return this.entityInstance.getRabbitType() != 99 && super.shouldExecute();
        }
    }
}
