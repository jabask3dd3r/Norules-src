package net.minecraft.entity.monster;

import net.minecraft.util.datafix.*;
import net.minecraft.world.*;
import net.minecraft.pathfinding.*;
import net.minecraft.world.storage.loot.*;
import javax.annotation.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.init.*;
import net.minecraft.network.datasync.*;
import net.minecraft.util.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.projectile.*;

public class EntityBlaze extends EntityMob
{
    private /* synthetic */ int heightOffsetUpdateTime;
    private /* synthetic */ float heightOffset;
    private static final /* synthetic */ DataParameter<Byte> ON_FIRE;
    
    @Override
    public boolean isBurning() {
        return this.isCharged();
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(EntityBlaze.ON_FIRE, (Byte)0);
    }
    
    public boolean isCharged() {
        return (this.dataManager.get(EntityBlaze.ON_FIRE) & 0x1) != 0x0;
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6.0);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.23000000417232513);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(48.0);
    }
    
    public static void registerFixesBlaze(final DataFixer llllllllllllllIIlllIIIllllIIIIIl) {
        EntityLiving.registerFixesMob(llllllllllllllIIlllIIIllllIIIIIl, EntityBlaze.class);
    }
    
    public EntityBlaze(final World llllllllllllllIIlllIIIllllIIIllI) {
        super(llllllllllllllIIlllIIIllllIIIllI);
        this.heightOffset = 0.5f;
        this.setPathPriority(PathNodeType.WATER, -1.0f);
        this.setPathPriority(PathNodeType.LAVA, 8.0f);
        this.setPathPriority(PathNodeType.DANGER_FIRE, 0.0f);
        this.setPathPriority(PathNodeType.DAMAGE_FIRE, 0.0f);
        this.isImmuneToFire = true;
        this.experienceValue = 10;
    }
    
    @Override
    public int getBrightnessForRender() {
        return 15728880;
    }
    
    @Override
    protected void updateAITasks() {
        if (this.isWet()) {
            this.attackEntityFrom(DamageSource.drown, 1.0f);
        }
        --this.heightOffsetUpdateTime;
        if (this.heightOffsetUpdateTime <= 0) {
            this.heightOffsetUpdateTime = 100;
            this.heightOffset = 0.5f + (float)this.rand.nextGaussian() * 3.0f;
        }
        final EntityLivingBase llllllllllllllIIlllIIIlllIlIlIII = this.getAttackTarget();
        if (llllllllllllllIIlllIIIlllIlIlIII != null && llllllllllllllIIlllIIIlllIlIlIII.posY + llllllllllllllIIlllIIIlllIlIlIII.getEyeHeight() > this.posY + this.getEyeHeight() + this.heightOffset) {
            this.motionY += (0.30000001192092896 - this.motionY) * 0.30000001192092896;
            this.isAirBorne = true;
        }
        super.updateAITasks();
    }
    
    @Override
    public void fall(final float llllllllllllllIIlllIIIlllIlIIlII, final float llllllllllllllIIlllIIIlllIlIIIll) {
    }
    
    @Override
    public float getBrightness() {
        return 1.0f;
    }
    
    @Nullable
    @Override
    protected ResourceLocation getLootTable() {
        return LootTableList.ENTITIES_BLAZE;
    }
    
    @Override
    protected void initEntityAI() {
        this.tasks.addTask(4, new AIFireballAttack(this));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0));
        this.tasks.addTask(7, new EntityAIWanderAvoidWater(this, 1.0, 0.0f));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0f));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, (Class<?>[])new Class[0]));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget<Object>(this, EntityPlayer.class, true));
    }
    
    @Override
    public void onLivingUpdate() {
        if (!this.onGround && this.motionY < 0.0) {
            this.motionY *= 0.6;
        }
        if (this.world.isRemote) {
            if (this.rand.nextInt(24) == 0 && !this.isSilent()) {
                this.world.playSound(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, SoundEvents.ENTITY_BLAZE_BURN, this.getSoundCategory(), 1.0f + this.rand.nextFloat(), this.rand.nextFloat() * 0.7f + 0.3f, false);
            }
            for (int llllllllllllllIIlllIIIlllIlIlllI = 0; llllllllllllllIIlllIIIlllIlIlllI < 2; ++llllllllllllllIIlllIIIlllIlIlllI) {
                this.world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, this.posX + (this.rand.nextDouble() - 0.5) * this.width, this.posY + this.rand.nextDouble() * this.height, this.posZ + (this.rand.nextDouble() - 0.5) * this.width, 0.0, 0.0, 0.0, new int[0]);
            }
        }
        super.onLivingUpdate();
    }
    
    static {
        ON_FIRE = EntityDataManager.createKey(EntityBlaze.class, DataSerializers.BYTE);
    }
    
    @Override
    protected boolean isValidLightLevel() {
        return true;
    }
    
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_BLAZE_DEATH;
    }
    
    public void setOnFire(final boolean llllllllllllllIIlllIIIlllIIlIlII) {
        byte llllllllllllllIIlllIIIlllIIlIllI = this.dataManager.get(EntityBlaze.ON_FIRE);
        if (llllllllllllllIIlllIIIlllIIlIlII) {
            llllllllllllllIIlllIIIlllIIlIllI |= 0x1;
        }
        else {
            llllllllllllllIIlllIIIlllIIlIllI &= 0xFFFFFFFE;
        }
        this.dataManager.set(EntityBlaze.ON_FIRE, llllllllllllllIIlllIIIlllIIlIllI);
    }
    
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_BLAZE_AMBIENT;
    }
    
    @Override
    protected SoundEvent getHurtSound(final DamageSource llllllllllllllIIlllIIIlllIllIlIl) {
        return SoundEvents.ENTITY_BLAZE_HURT;
    }
    
    static class AIFireballAttack extends EntityAIBase
    {
        private /* synthetic */ int attackTime;
        private final /* synthetic */ EntityBlaze blaze;
        private /* synthetic */ int attackStep;
        
        @Override
        public void resetTask() {
            this.blaze.setOnFire(false);
        }
        
        @Override
        public boolean shouldExecute() {
            final EntityLivingBase lllllllllllllIIllIIlIIllIIIIIIII = this.blaze.getAttackTarget();
            return lllllllllllllIIllIIlIIllIIIIIIII != null && lllllllllllllIIllIIlIIllIIIIIIII.isEntityAlive();
        }
        
        @Override
        public void startExecuting() {
            this.attackStep = 0;
        }
        
        private double func_191523_f() {
            final IAttributeInstance lllllllllllllIIllIIlIIlIllIllIIl = this.blaze.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE);
            return (lllllllllllllIIllIIlIIlIllIllIIl == null) ? 16.0 : lllllllllllllIIllIIlIIlIllIllIIl.getAttributeValue();
        }
        
        @Override
        public void updateTask() {
            --this.attackTime;
            final EntityLivingBase lllllllllllllIIllIIlIIlIlllIllIl = this.blaze.getAttackTarget();
            final double lllllllllllllIIllIIlIIlIlllIllII = this.blaze.getDistanceSqToEntity(lllllllllllllIIllIIlIIlIlllIllIl);
            if (lllllllllllllIIllIIlIIlIlllIllII < 4.0) {
                if (this.attackTime <= 0) {
                    this.attackTime = 20;
                    this.blaze.attackEntityAsMob(lllllllllllllIIllIIlIIlIlllIllIl);
                }
                this.blaze.getMoveHelper().setMoveTo(lllllllllllllIIllIIlIIlIlllIllIl.posX, lllllllllllllIIllIIlIIlIlllIllIl.posY, lllllllllllllIIllIIlIIlIlllIllIl.posZ, 1.0);
            }
            else if (lllllllllllllIIllIIlIIlIlllIllII < this.func_191523_f() * this.func_191523_f()) {
                final double lllllllllllllIIllIIlIIlIlllIlIll = lllllllllllllIIllIIlIIlIlllIllIl.posX - this.blaze.posX;
                final double lllllllllllllIIllIIlIIlIlllIlIlI = lllllllllllllIIllIIlIIlIlllIllIl.getEntityBoundingBox().minY + lllllllllllllIIllIIlIIlIlllIllIl.height / 2.0f - (this.blaze.posY + this.blaze.height / 2.0f);
                final double lllllllllllllIIllIIlIIlIlllIlIIl = lllllllllllllIIllIIlIIlIlllIllIl.posZ - this.blaze.posZ;
                if (this.attackTime <= 0) {
                    ++this.attackStep;
                    if (this.attackStep == 1) {
                        this.attackTime = 60;
                        this.blaze.setOnFire(true);
                    }
                    else if (this.attackStep <= 4) {
                        this.attackTime = 6;
                    }
                    else {
                        this.attackTime = 100;
                        this.attackStep = 0;
                        this.blaze.setOnFire(false);
                    }
                    if (this.attackStep > 1) {
                        final float lllllllllllllIIllIIlIIlIlllIlIII = MathHelper.sqrt(MathHelper.sqrt(lllllllllllllIIllIIlIIlIlllIllII)) * 0.5f;
                        this.blaze.world.playEvent(null, 1018, new BlockPos((int)this.blaze.posX, (int)this.blaze.posY, (int)this.blaze.posZ), 0);
                        for (int lllllllllllllIIllIIlIIlIlllIIlll = 0; lllllllllllllIIllIIlIIlIlllIIlll < 1; ++lllllllllllllIIllIIlIIlIlllIIlll) {
                            final EntitySmallFireball lllllllllllllIIllIIlIIlIlllIIllI = new EntitySmallFireball(this.blaze.world, this.blaze, lllllllllllllIIllIIlIIlIlllIlIll + this.blaze.getRNG().nextGaussian() * lllllllllllllIIllIIlIIlIlllIlIII, lllllllllllllIIllIIlIIlIlllIlIlI, lllllllllllllIIllIIlIIlIlllIlIIl + this.blaze.getRNG().nextGaussian() * lllllllllllllIIllIIlIIlIlllIlIII);
                            lllllllllllllIIllIIlIIlIlllIIllI.posY = this.blaze.posY + this.blaze.height / 2.0f + 0.5;
                            this.blaze.world.spawnEntityInWorld(lllllllllllllIIllIIlIIlIlllIIllI);
                        }
                    }
                }
                this.blaze.getLookHelper().setLookPositionWithEntity(lllllllllllllIIllIIlIIlIlllIllIl, 10.0f, 10.0f);
            }
            else {
                this.blaze.getNavigator().clearPathEntity();
                this.blaze.getMoveHelper().setMoveTo(lllllllllllllIIllIIlIIlIlllIllIl.posX, lllllllllllllIIllIIlIIlIlllIllIl.posY, lllllllllllllIIllIIlIIlIlllIllIl.posZ, 1.0);
            }
            super.updateTask();
        }
        
        public AIFireballAttack() {
            this.setMutexBits(3);
        }
    }
}
