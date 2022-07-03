package net.minecraft.entity.monster;

import net.minecraft.entity.passive.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import net.minecraft.network.datasync.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.world.storage.loot.*;
import javax.annotation.*;
import net.minecraft.item.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.ai.*;
import com.google.common.base.*;

public class EntityPolarBear extends EntityAnimal
{
    private /* synthetic */ int warningSoundTicks;
    private static final /* synthetic */ DataParameter<Boolean> IS_STANDING;
    private /* synthetic */ float clientSideStandAnimation;
    private /* synthetic */ float clientSideStandAnimation0;
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(EntityPolarBear.IS_STANDING, false);
    }
    
    @Override
    protected float getWaterSlowDown() {
        return 0.98f;
    }
    
    public float getStandingAnimationScale(final float llllllllllllllIllllIIIIIlllIIlll) {
        return (this.clientSideStandAnimation0 + (this.clientSideStandAnimation - this.clientSideStandAnimation0) * llllllllllllllIllllIIIIIlllIIlll) / 6.0f;
    }
    
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_POLAR_BEAR_DEATH;
    }
    
    @Override
    public EntityAgeable createChild(final EntityAgeable llllllllllllllIllllIIIIlIIIlllIl) {
        return new EntityPolarBear(this.world);
    }
    
    @Override
    protected void playStepSound(final BlockPos llllllllllllllIllllIIIIlIIIIlIll, final Block llllllllllllllIllllIIIIlIIIIlIlI) {
        this.playSound(SoundEvents.ENTITY_POLAR_BEAR_STEP, 0.15f, 1.0f);
    }
    
    @Override
    public boolean attackEntityAsMob(final Entity llllllllllllllIllllIIIIIlllllIlI) {
        final boolean llllllllllllllIllllIIIIIlllllIIl = llllllllllllllIllllIIIIIlllllIlI.attackEntityFrom(DamageSource.causeMobDamage(this), (float)(int)this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue());
        if (llllllllllllllIllllIIIIIlllllIIl) {
            this.applyEnchantments(this, llllllllllllllIllllIIIIIlllllIlI);
        }
        return llllllllllllllIllllIIIIIlllllIIl;
    }
    
    public boolean isStanding() {
        return this.dataManager.get(EntityPolarBear.IS_STANDING);
    }
    
    public void setStanding(final boolean llllllllllllllIllllIIIIIlllIllIl) {
        this.dataManager.set(EntityPolarBear.IS_STANDING, llllllllllllllIllllIIIIIlllIllIl);
    }
    
    static {
        IS_STANDING = EntityDataManager.createKey(EntityPolarBear.class, DataSerializers.BOOLEAN);
    }
    
    @Override
    protected SoundEvent getHurtSound(final DamageSource llllllllllllllIllllIIIIlIIIIllll) {
        return SoundEvents.ENTITY_POLAR_BEAR_HURT;
    }
    
    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new AIMeleeAttack());
        this.tasks.addTask(1, new AIPanic());
        this.tasks.addTask(4, new EntityAIFollowParent(this, 1.25));
        this.tasks.addTask(5, new EntityAIWander(this, 1.0));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0f));
        this.tasks.addTask(7, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new AIHurtByTarget());
        this.targetTasks.addTask(2, new AIAttackPlayer());
    }
    
    public EntityPolarBear(final World llllllllllllllIllllIIIIlIIlIIIII) {
        super(llllllllllllllIllllIIIIlIIlIIIII);
        this.setSize(1.3f, 1.4f);
    }
    
    @Override
    public IEntityLivingData onInitialSpawn(final DifficultyInstance llllllllllllllIllllIIIIIlllIIIIl, IEntityLivingData llllllllllllllIllllIIIIIllIlllIl) {
        if (llllllllllllllIllllIIIIIllIlllIl instanceof GroupData) {
            if (((GroupData)llllllllllllllIllllIIIIIllIlllIl).madeParent) {
                this.setGrowingAge(-24000);
            }
        }
        else {
            final GroupData llllllllllllllIllllIIIIIllIlllll = new GroupData(null);
            llllllllllllllIllllIIIIIllIlllll.madeParent = true;
            llllllllllllllIllllIIIIIllIlllIl = llllllllllllllIllllIIIIIllIlllll;
        }
        return llllllllllllllIllllIIIIIllIlllIl;
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20.0);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6.0);
    }
    
    @Nullable
    @Override
    protected ResourceLocation getLootTable() {
        return LootTableList.ENTITIES_POLAR_BEAR;
    }
    
    @Override
    public boolean isBreedingItem(final ItemStack llllllllllllllIllllIIIIlIIIllIlI) {
        return false;
    }
    
    @Override
    public void onUpdate() {
        super.onUpdate();
        if (this.world.isRemote) {
            this.clientSideStandAnimation0 = this.clientSideStandAnimation;
            if (this.isStanding()) {
                this.clientSideStandAnimation = MathHelper.clamp(this.clientSideStandAnimation + 1.0f, 0.0f, 6.0f);
            }
            else {
                this.clientSideStandAnimation = MathHelper.clamp(this.clientSideStandAnimation - 1.0f, 0.0f, 6.0f);
            }
        }
        if (this.warningSoundTicks > 0) {
            --this.warningSoundTicks;
        }
    }
    
    protected void playWarningSound() {
        if (this.warningSoundTicks <= 0) {
            this.playSound(SoundEvents.ENTITY_POLAR_BEAR_WARNING, 1.0f, 1.0f);
            this.warningSoundTicks = 40;
        }
    }
    
    @Override
    protected SoundEvent getAmbientSound() {
        return this.isChild() ? SoundEvents.ENTITY_POLAR_BEAR_BABY_AMBIENT : SoundEvents.ENTITY_POLAR_BEAR_AMBIENT;
    }
    
    class AIPanic extends EntityAIPanic
    {
        @Override
        public boolean shouldExecute() {
            return (EntityPolarBear.this.isChild() || EntityPolarBear.this.isBurning()) && super.shouldExecute();
        }
        
        public AIPanic() {
            super(EntityPolarBear.this, 2.0);
        }
    }
    
    class AIHurtByTarget extends EntityAIHurtByTarget
    {
        @Override
        public void startExecuting() {
            super.startExecuting();
            if (EntityPolarBear.this.isChild()) {
                this.alertOthers();
                this.resetTask();
            }
        }
        
        @Override
        protected void setEntityAttackTarget(final EntityCreature lIIlIIIllIIlllI, final EntityLivingBase lIIlIIIllIIlIlI) {
            if (lIIlIIIllIIlllI instanceof EntityPolarBear && !lIIlIIIllIIlllI.isChild()) {
                super.setEntityAttackTarget(lIIlIIIllIIlllI, lIIlIIIllIIlIlI);
            }
        }
        
        public AIHurtByTarget() {
            super(EntityPolarBear.this, false, (Class<?>[])new Class[0]);
        }
    }
    
    class AIMeleeAttack extends EntityAIAttackMelee
    {
        public AIMeleeAttack() {
            super(EntityPolarBear.this, 1.25, true);
        }
        
        @Override
        public void resetTask() {
            EntityPolarBear.this.setStanding(false);
            super.resetTask();
        }
        
        @Override
        protected double getAttackReachSqr(final EntityLivingBase lllllllllllllIlIIlllIIllIIIIIIIl) {
            return 4.0f + lllllllllllllIlIIlllIIllIIIIIIIl.width;
        }
        
        @Override
        protected void checkAndPerformAttack(final EntityLivingBase lllllllllllllIlIIlllIIllIIIlIIlI, final double lllllllllllllIlIIlllIIllIIIlIlIl) {
            final double lllllllllllllIlIIlllIIllIIIlIlII = this.getAttackReachSqr(lllllllllllllIlIIlllIIllIIIlIIlI);
            if (lllllllllllllIlIIlllIIllIIIlIlIl <= lllllllllllllIlIIlllIIllIIIlIlII && this.attackTick <= 0) {
                this.attackTick = 20;
                this.attacker.attackEntityAsMob(lllllllllllllIlIIlllIIllIIIlIIlI);
                EntityPolarBear.this.setStanding(false);
            }
            else if (lllllllllllllIlIIlllIIllIIIlIlIl <= lllllllllllllIlIIlllIIllIIIlIlII * 2.0) {
                if (this.attackTick <= 0) {
                    EntityPolarBear.this.setStanding(false);
                    this.attackTick = 20;
                }
                if (this.attackTick <= 10) {
                    EntityPolarBear.this.setStanding(true);
                    EntityPolarBear.this.playWarningSound();
                }
            }
            else {
                this.attackTick = 20;
                EntityPolarBear.this.setStanding(false);
            }
        }
    }
    
    class AIAttackPlayer extends EntityAINearestAttackableTarget<EntityPlayer>
    {
        @Override
        public boolean shouldExecute() {
            if (EntityPolarBear.this.isChild()) {
                return false;
            }
            if (super.shouldExecute()) {
                for (final EntityPolarBear lllllllllllllIIlIllIIIlIIllIlIIl : EntityPolarBear.this.world.getEntitiesWithinAABB((Class<? extends Entity>)EntityPolarBear.class, EntityPolarBear.this.getEntityBoundingBox().expand(8.0, 4.0, 8.0))) {
                    if (lllllllllllllIIlIllIIIlIIllIlIIl.isChild()) {
                        return true;
                    }
                }
            }
            EntityPolarBear.this.setAttackTarget(null);
            return false;
        }
        
        @Override
        protected double getTargetDistance() {
            return super.getTargetDistance() * 0.5;
        }
        
        public AIAttackPlayer() {
            super(EntityPolarBear.this, EntityPlayer.class, 20, true, true, null);
        }
    }
    
    static class GroupData implements IEntityLivingData
    {
        public /* synthetic */ boolean madeParent;
        
        private GroupData() {
        }
    }
}
