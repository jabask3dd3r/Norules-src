package net.minecraft.entity.monster;

import net.minecraft.util.math.*;
import net.minecraft.world.chunk.*;
import net.minecraft.world.biome.*;
import net.minecraft.world.storage.loot.*;
import javax.annotation.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.nbt.*;
import net.minecraft.util.datafix.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.network.datasync.*;
import net.minecraft.entity.ai.*;
import net.minecraft.init.*;
import net.minecraft.pathfinding.*;

public class EntitySlime extends EntityLiving implements IMob
{
    private static final /* synthetic */ DataParameter<Integer> SLIME_SIZE;
    public /* synthetic */ float prevSquishFactor;
    private /* synthetic */ boolean wasOnGround;
    public /* synthetic */ float squishAmount;
    public /* synthetic */ float squishFactor;
    
    @Override
    public boolean getCanSpawnHere() {
        final BlockPos llllllllllllllllIlIlIIIIIlllllll = new BlockPos(MathHelper.floor(this.posX), 0, MathHelper.floor(this.posZ));
        final Chunk llllllllllllllllIlIlIIIIIllllllI = this.world.getChunkFromBlockCoords(llllllllllllllllIlIlIIIIIlllllll);
        if (this.world.getWorldInfo().getTerrainType() == WorldType.FLAT && this.rand.nextInt(4) != 1) {
            return false;
        }
        if (this.world.getDifficulty() != EnumDifficulty.PEACEFUL) {
            final Biome llllllllllllllllIlIlIIIIIlllllIl = this.world.getBiome(llllllllllllllllIlIlIIIIIlllllll);
            if (llllllllllllllllIlIlIIIIIlllllIl == Biomes.SWAMPLAND && this.posY > 50.0 && this.posY < 70.0 && this.rand.nextFloat() < 0.5f && this.rand.nextFloat() < this.world.getCurrentMoonPhaseFactor() && this.world.getLightFromNeighbors(new BlockPos(this)) <= this.rand.nextInt(8)) {
                return super.getCanSpawnHere();
            }
            if (this.rand.nextInt(10) == 0 && llllllllllllllllIlIlIIIIIllllllI.getRandomWithSeed(987234911L).nextInt(10) == 0 && this.posY < 40.0) {
                return super.getCanSpawnHere();
            }
        }
        return false;
    }
    
    protected SoundEvent getSquishSound() {
        return this.isSmallSlime() ? SoundEvents.ENTITY_SMALL_SLIME_SQUISH : SoundEvents.ENTITY_SLIME_SQUISH;
    }
    
    @Nullable
    @Override
    protected ResourceLocation getLootTable() {
        return (this.getSlimeSize() == 1) ? LootTableList.ENTITIES_SLIME : LootTableList.EMPTY;
    }
    
    @Override
    protected void jump() {
        this.motionY = 0.41999998688697815;
        this.isAirBorne = true;
    }
    
    protected SoundEvent getJumpSound() {
        return this.isSmallSlime() ? SoundEvents.ENTITY_SMALL_SLIME_JUMP : SoundEvents.ENTITY_SLIME_JUMP;
    }
    
    protected void setSlimeSize(final int llllllllllllllllIlIlIIIlIIIllIII, final boolean llllllllllllllllIlIlIIIlIIIlIlll) {
        this.dataManager.set(EntitySlime.SLIME_SIZE, llllllllllllllllIlIlIIIlIIIllIII);
        this.setSize(0.51000005f * llllllllllllllllIlIlIIIlIIIllIII, 0.51000005f * llllllllllllllllIlIlIIIlIIIllIII);
        this.setPosition(this.posX, this.posY, this.posZ);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(llllllllllllllllIlIlIIIlIIIllIII * llllllllllllllllIlIlIIIlIIIllIII);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2f + 0.1f * llllllllllllllllIlIlIIIlIIIllIII);
        if (llllllllllllllllIlIlIIIlIIIlIlll) {
            this.setHealth(this.getMaxHealth());
        }
        this.experienceValue = llllllllllllllllIlIlIIIlIIIllIII;
    }
    
    protected boolean canDamagePlayer() {
        return !this.isSmallSlime();
    }
    
    @Nullable
    @Override
    public IEntityLivingData onInitialSpawn(final DifficultyInstance llllllllllllllllIlIlIIIIIllIlIII, @Nullable final IEntityLivingData llllllllllllllllIlIlIIIIIllIIlll) {
        int llllllllllllllllIlIlIIIIIllIIllI = this.rand.nextInt(3);
        if (llllllllllllllllIlIlIIIIIllIIllI < 2 && this.rand.nextFloat() < 0.5f * llllllllllllllllIlIlIIIIIllIlIII.getClampedAdditionalDifficulty()) {
            ++llllllllllllllllIlIlIIIIIllIIllI;
        }
        final int llllllllllllllllIlIlIIIIIllIIlIl = 1 << llllllllllllllllIlIlIIIIIllIIllI;
        this.setSlimeSize(llllllllllllllllIlIlIIIIIllIIlIl, true);
        return super.onInitialSpawn(llllllllllllllllIlIlIIIIIllIlIII, llllllllllllllllIlIlIIIIIllIIlll);
    }
    
    public boolean isSmallSlime() {
        return this.getSlimeSize() <= 1;
    }
    
    protected int getAttackStrength() {
        return this.getSlimeSize();
    }
    
    @Override
    protected Item getDropItem() {
        return (this.getSlimeSize() == 1) ? Items.SLIME_BALL : null;
    }
    
    public EntitySlime(final World llllllllllllllllIlIlIIIlIIlIIIll) {
        super(llllllllllllllllIlIlIIIlIIlIIIll);
        this.moveHelper = new SlimeMoveHelper(this);
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound llllllllllllllllIlIlIIIlIIIIlIlI) {
        super.writeEntityToNBT(llllllllllllllllIlIlIIIlIIIIlIlI);
        llllllllllllllllIlIlIIIlIIIIlIlI.setInteger("Size", this.getSlimeSize() - 1);
        llllllllllllllllIlIlIIIlIIIIlIlI.setBoolean("wasOnGround", this.wasOnGround);
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(EntitySlime.SLIME_SIZE, 1);
    }
    
    @Override
    public void onUpdate() {
        if (!this.world.isRemote && this.world.getDifficulty() == EnumDifficulty.PEACEFUL && this.getSlimeSize() > 0) {
            this.isDead = true;
        }
        this.squishFactor += (this.squishAmount - this.squishFactor) * 0.5f;
        this.prevSquishFactor = this.squishFactor;
        super.onUpdate();
        if (this.onGround && !this.wasOnGround) {
            for (int llllllllllllllllIlIlIIIIlllIlllI = this.getSlimeSize(), llllllllllllllllIlIlIIIIlllIllIl = 0; llllllllllllllllIlIlIIIIlllIllIl < llllllllllllllllIlIlIIIIlllIlllI * 8; ++llllllllllllllllIlIlIIIIlllIllIl) {
                final float llllllllllllllllIlIlIIIIlllIllII = this.rand.nextFloat() * 6.2831855f;
                final float llllllllllllllllIlIlIIIIlllIlIll = this.rand.nextFloat() * 0.5f + 0.5f;
                final float llllllllllllllllIlIlIIIIlllIlIlI = MathHelper.sin(llllllllllllllllIlIlIIIIlllIllII) * llllllllllllllllIlIlIIIIlllIlllI * 0.5f * llllllllllllllllIlIlIIIIlllIlIll;
                final float llllllllllllllllIlIlIIIIlllIlIIl = MathHelper.cos(llllllllllllllllIlIlIIIIlllIllII) * llllllllllllllllIlIlIIIIlllIlllI * 0.5f * llllllllllllllllIlIlIIIIlllIlIll;
                final World llllllllllllllllIlIlIIIIlllIlIII = this.world;
                final EnumParticleTypes llllllllllllllllIlIlIIIIlllIIlll = this.getParticleType();
                final double llllllllllllllllIlIlIIIIlllIIllI = this.posX + llllllllllllllllIlIlIIIIlllIlIlI;
                final double llllllllllllllllIlIlIIIIlllIIlIl = this.posZ + llllllllllllllllIlIlIIIIlllIlIIl;
                llllllllllllllllIlIlIIIIlllIlIII.spawnParticle(llllllllllllllllIlIlIIIIlllIIlll, llllllllllllllllIlIlIIIIlllIIllI, this.getEntityBoundingBox().minY, llllllllllllllllIlIlIIIIlllIIlIl, 0.0, 0.0, 0.0, new int[0]);
            }
            this.playSound(this.getSquishSound(), this.getSoundVolume(), ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.0f) / 0.8f);
            this.squishAmount = -0.5f;
        }
        else if (!this.onGround && this.wasOnGround) {
            this.squishAmount = 1.0f;
        }
        this.wasOnGround = this.onGround;
        this.alterSquishAmount();
    }
    
    public static void registerFixesSlime(final DataFixer llllllllllllllllIlIlIIIlIIIIllll) {
        EntityLiving.registerFixesMob(llllllllllllllllIlIlIIIlIIIIllll, EntitySlime.class);
    }
    
    protected void dealDamage(final EntityLivingBase llllllllllllllllIlIlIIIIlIIlllll) {
        final int llllllllllllllllIlIlIIIIlIlIIIIl = this.getSlimeSize();
        if (this.canEntityBeSeen(llllllllllllllllIlIlIIIIlIIlllll) && this.getDistanceSqToEntity(llllllllllllllllIlIlIIIIlIIlllll) < 0.6 * llllllllllllllllIlIlIIIIlIlIIIIl * 0.6 * llllllllllllllllIlIlIIIIlIlIIIIl && llllllllllllllllIlIlIIIIlIIlllll.attackEntityFrom(DamageSource.causeMobDamage(this), (float)this.getAttackStrength())) {
            this.playSound(SoundEvents.ENTITY_SLIME_ATTACK, 1.0f, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.0f);
            this.applyEnchantments(this, llllllllllllllllIlIlIIIIlIIlllll);
        }
    }
    
    protected EnumParticleTypes getParticleType() {
        return EnumParticleTypes.SLIME;
    }
    
    protected int getJumpDelay() {
        return this.rand.nextInt(20) + 10;
    }
    
    @Override
    public void onCollideWithPlayer(final EntityPlayer llllllllllllllllIlIlIIIIlIlIlIIl) {
        if (this.canDamagePlayer()) {
            this.dealDamage(llllllllllllllllIlIlIIIIlIlIlIIl);
        }
    }
    
    @Override
    public float getEyeHeight() {
        return 0.625f * this.height;
    }
    
    @Override
    public void applyEntityCollision(final Entity llllllllllllllllIlIlIIIIlIlIllll) {
        super.applyEntityCollision(llllllllllllllllIlIlIIIIlIlIllll);
        if (llllllllllllllllIlIlIIIIlIlIllll instanceof EntityIronGolem && this.canDamagePlayer()) {
            this.dealDamage((EntityLivingBase)llllllllllllllllIlIlIIIIlIlIllll);
        }
    }
    
    @Override
    protected SoundEvent getHurtSound(final DamageSource llllllllllllllllIlIlIIIIlIIlIIlI) {
        return this.isSmallSlime() ? SoundEvents.ENTITY_SMALL_SLIME_HURT : SoundEvents.ENTITY_SLIME_HURT;
    }
    
    @Override
    protected float getSoundVolume() {
        return 0.4f * this.getSlimeSize();
    }
    
    protected EntitySlime createInstance() {
        return new EntitySlime(this.world);
    }
    
    @Override
    public int getVerticalFaceSpeed() {
        return 0;
    }
    
    @Override
    public void notifyDataManagerChange(final DataParameter<?> llllllllllllllllIlIlIIIIllIIlIIl) {
        if (EntitySlime.SLIME_SIZE.equals(llllllllllllllllIlIlIIIIllIIlIIl)) {
            final int llllllllllllllllIlIlIIIIllIIlIll = this.getSlimeSize();
            this.setSize(0.51000005f * llllllllllllllllIlIlIIIIllIIlIll, 0.51000005f * llllllllllllllllIlIlIIIIllIIlIll);
            this.rotationYaw = this.rotationYawHead;
            this.renderYawOffset = this.rotationYawHead;
            if (this.isInWater() && this.rand.nextInt(20) == 0) {
                this.resetHeight();
            }
        }
        super.notifyDataManagerChange(llllllllllllllllIlIlIIIIllIIlIIl);
    }
    
    protected void alterSquishAmount() {
        this.squishAmount *= 0.6f;
    }
    
    @Override
    protected void initEntityAI() {
        this.tasks.addTask(1, new AISlimeFloat(this));
        this.tasks.addTask(2, new AISlimeAttack(this));
        this.tasks.addTask(3, new AISlimeFaceRandom(this));
        this.tasks.addTask(5, new AISlimeHop(this));
        this.targetTasks.addTask(1, new EntityAIFindEntityNearestPlayer(this));
        this.targetTasks.addTask(3, new EntityAIFindEntityNearest(this, EntityIronGolem.class));
    }
    
    static {
        SLIME_SIZE = EntityDataManager.createKey(EntitySlime.class, DataSerializers.VARINT);
    }
    
    @Override
    protected SoundEvent getDeathSound() {
        return this.isSmallSlime() ? SoundEvents.ENTITY_SMALL_SLIME_DEATH : SoundEvents.ENTITY_SLIME_DEATH;
    }
    
    protected boolean makesSoundOnJump() {
        return this.getSlimeSize() > 0;
    }
    
    @Override
    public void setDead() {
        final int llllllllllllllllIlIlIIIIlIllllll = this.getSlimeSize();
        if (!this.world.isRemote && llllllllllllllllIlIlIIIIlIllllll > 1 && this.getHealth() <= 0.0f) {
            for (int llllllllllllllllIlIlIIIIlIlllllI = 2 + this.rand.nextInt(3), llllllllllllllllIlIlIIIIlIllllIl = 0; llllllllllllllllIlIlIIIIlIllllIl < llllllllllllllllIlIlIIIIlIlllllI; ++llllllllllllllllIlIlIIIIlIllllIl) {
                final float llllllllllllllllIlIlIIIIlIllllII = (llllllllllllllllIlIlIIIIlIllllIl % 2 - 0.5f) * llllllllllllllllIlIlIIIIlIllllll / 4.0f;
                final float llllllllllllllllIlIlIIIIlIlllIll = (llllllllllllllllIlIlIIIIlIllllIl / 2 - 0.5f) * llllllllllllllllIlIlIIIIlIllllll / 4.0f;
                final EntitySlime llllllllllllllllIlIlIIIIlIlllIlI = this.createInstance();
                if (this.hasCustomName()) {
                    llllllllllllllllIlIlIIIIlIlllIlI.setCustomNameTag(this.getCustomNameTag());
                }
                if (this.isNoDespawnRequired()) {
                    llllllllllllllllIlIlIIIIlIlllIlI.enablePersistence();
                }
                llllllllllllllllIlIlIIIIlIlllIlI.setSlimeSize(llllllllllllllllIlIlIIIIlIllllll / 2, true);
                llllllllllllllllIlIlIIIIlIlllIlI.setLocationAndAngles(this.posX + llllllllllllllllIlIlIIIIlIllllII, this.posY + 0.5, this.posZ + llllllllllllllllIlIlIIIIlIlllIll, this.rand.nextFloat() * 360.0f, 0.0f);
                this.world.spawnEntityInWorld(llllllllllllllllIlIlIIIIlIlllIlI);
            }
        }
        super.setDead();
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound llllllllllllllllIlIlIIIlIIIIIIll) {
        super.readEntityFromNBT(llllllllllllllllIlIlIIIlIIIIIIll);
        int llllllllllllllllIlIlIIIlIIIIIIlI = llllllllllllllllIlIlIIIlIIIIIIll.getInteger("Size");
        if (llllllllllllllllIlIlIIIlIIIIIIlI < 0) {
            llllllllllllllllIlIlIIIlIIIIIIlI = 0;
        }
        this.setSlimeSize(llllllllllllllllIlIlIIIlIIIIIIlI + 1, false);
        this.wasOnGround = llllllllllllllllIlIlIIIlIIIIIIll.getBoolean("wasOnGround");
    }
    
    public int getSlimeSize() {
        return this.dataManager.get(EntitySlime.SLIME_SIZE);
    }
    
    static class SlimeMoveHelper extends EntityMoveHelper
    {
        private /* synthetic */ boolean isAggressive;
        private /* synthetic */ int jumpDelay;
        private final /* synthetic */ EntitySlime slime;
        private /* synthetic */ float yRot;
        
        public void setDirection(final float lllllllllllllIlIIllIlIlIllIIlIll, final boolean lllllllllllllIlIIllIlIlIllIIllIl) {
            this.yRot = lllllllllllllIlIIllIlIlIllIIlIll;
            this.isAggressive = lllllllllllllIlIIllIlIlIllIIllIl;
        }
        
        @Override
        public void onUpdateMoveHelper() {
            this.entity.rotationYaw = this.limitAngle(this.entity.rotationYaw, this.yRot, 90.0f);
            this.entity.rotationYawHead = this.entity.rotationYaw;
            this.entity.renderYawOffset = this.entity.rotationYaw;
            if (this.action != Action.MOVE_TO) {
                this.entity.func_191989_p(0.0f);
            }
            else {
                this.action = Action.WAIT;
                if (this.entity.onGround) {
                    this.entity.setAIMoveSpeed((float)(this.speed * this.entity.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue()));
                    if (this.jumpDelay-- <= 0) {
                        this.jumpDelay = this.slime.getJumpDelay();
                        if (this.isAggressive) {
                            this.jumpDelay /= 3;
                        }
                        this.slime.getJumpHelper().setJumping();
                        if (this.slime.makesSoundOnJump()) {
                            this.slime.playSound(this.slime.getJumpSound(), this.slime.getSoundVolume(), ((this.slime.getRNG().nextFloat() - this.slime.getRNG().nextFloat()) * 0.2f + 1.0f) * 0.8f);
                        }
                    }
                    else {
                        this.slime.moveStrafing = 0.0f;
                        this.slime.field_191988_bg = 0.0f;
                        this.entity.setAIMoveSpeed(0.0f);
                    }
                }
                else {
                    this.entity.setAIMoveSpeed((float)(this.speed * this.entity.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue()));
                }
            }
        }
        
        public void setSpeed(final double lllllllllllllIlIIllIlIlIllIIIlII) {
            this.speed = lllllllllllllIlIIllIlIlIllIIIlII;
            this.action = Action.MOVE_TO;
        }
        
        public SlimeMoveHelper() {
            super(EntitySlime.this);
            this.yRot = 180.0f * EntitySlime.this.rotationYaw / 3.1415927f;
        }
    }
    
    static class AISlimeFaceRandom extends EntityAIBase
    {
        private /* synthetic */ float chosenDegrees;
        private final /* synthetic */ EntitySlime slime;
        private /* synthetic */ int nextRandomizeTime;
        
        public AISlimeFaceRandom() {
            this.setMutexBits(2);
        }
        
        @Override
        public void updateTask() {
            final int nextRandomizeTime = this.nextRandomizeTime - 1;
            this.nextRandomizeTime = nextRandomizeTime;
            if (nextRandomizeTime <= 0) {
                this.nextRandomizeTime = 40 + this.slime.getRNG().nextInt(60);
                this.chosenDegrees = (float)this.slime.getRNG().nextInt(360);
            }
            ((SlimeMoveHelper)this.slime.getMoveHelper()).setDirection(this.chosenDegrees, false);
        }
        
        @Override
        public boolean shouldExecute() {
            return this.slime.getAttackTarget() == null && (this.slime.onGround || this.slime.isInWater() || this.slime.isInLava() || this.slime.isPotionActive(MobEffects.LEVITATION));
        }
    }
    
    static class AISlimeHop extends EntityAIBase
    {
        private final /* synthetic */ EntitySlime slime;
        
        @Override
        public void updateTask() {
            ((SlimeMoveHelper)this.slime.getMoveHelper()).setSpeed(1.0);
        }
        
        @Override
        public boolean shouldExecute() {
            return true;
        }
        
        public AISlimeHop() {
            this.setMutexBits(5);
        }
    }
    
    static class AISlimeFloat extends EntityAIBase
    {
        private final /* synthetic */ EntitySlime slime;
        
        @Override
        public void updateTask() {
            if (this.slime.getRNG().nextFloat() < 0.8f) {
                this.slime.getJumpHelper().setJumping();
            }
            ((SlimeMoveHelper)this.slime.getMoveHelper()).setSpeed(1.2);
        }
        
        public AISlimeFloat() {
            this.setMutexBits(5);
            ((PathNavigateGround)EntitySlime.this.getNavigator()).setCanSwim(true);
        }
        
        @Override
        public boolean shouldExecute() {
            return this.slime.isInWater() || this.slime.isInLava();
        }
    }
    
    static class AISlimeAttack extends EntityAIBase
    {
        private final /* synthetic */ EntitySlime slime;
        private /* synthetic */ int growTieredTimer;
        
        @Override
        public void startExecuting() {
            this.growTieredTimer = 300;
            super.startExecuting();
        }
        
        @Override
        public boolean shouldExecute() {
            final EntityLivingBase llllllllllllllIIIllllIlllllllIll = this.slime.getAttackTarget();
            return llllllllllllllIIIllllIlllllllIll != null && llllllllllllllIIIllllIlllllllIll.isEntityAlive() && (!(llllllllllllllIIIllllIlllllllIll instanceof EntityPlayer) || !((EntityPlayer)llllllllllllllIIIllllIlllllllIll).capabilities.disableDamage);
        }
        
        @Override
        public void updateTask() {
            this.slime.faceEntity(this.slime.getAttackTarget(), 10.0f, 10.0f);
            ((SlimeMoveHelper)this.slime.getMoveHelper()).setDirection(this.slime.rotationYaw, this.slime.canDamagePlayer());
        }
        
        public AISlimeAttack() {
            this.setMutexBits(2);
        }
        
        @Override
        public boolean continueExecuting() {
            final EntityLivingBase llllllllllllllIIIllllIllllllIIlI = this.slime.getAttackTarget();
            return llllllllllllllIIIllllIllllllIIlI != null && llllllllllllllIIIllllIllllllIIlI.isEntityAlive() && (!(llllllllllllllIIIllllIllllllIIlI instanceof EntityPlayer) || !((EntityPlayer)llllllllllllllIIIllllIllllllIIlI).capabilities.disableDamage) && --this.growTieredTimer > 0;
        }
    }
}
