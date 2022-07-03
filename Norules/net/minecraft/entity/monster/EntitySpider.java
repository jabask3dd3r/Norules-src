package net.minecraft.entity.monster;

import net.minecraft.pathfinding.*;
import net.minecraft.network.datasync.*;
import net.minecraft.util.*;
import net.minecraft.world.storage.loot.*;
import javax.annotation.*;
import net.minecraft.util.datafix.*;
import net.minecraft.world.*;
import net.minecraft.potion.*;
import net.minecraft.entity.player.*;
import net.minecraft.init.*;
import net.minecraft.util.math.*;
import net.minecraft.block.*;
import net.minecraft.entity.*;
import java.util.*;
import net.minecraft.entity.ai.*;

public class EntitySpider extends EntityMob
{
    private static final /* synthetic */ DataParameter<Byte> CLIMBING;
    
    @Override
    protected PathNavigate getNewNavigator(final World lllllllllllllIIIlIIIlIIIIIllIlll) {
        return new PathNavigateClimber(this, lllllllllllllIIIlIIIlIIIIIllIlll);
    }
    
    @Override
    protected SoundEvent getHurtSound(final DamageSource lllllllllllllIIIlIIIlIIIIIlIlIIl) {
        return SoundEvents.ENTITY_SPIDER_HURT;
    }
    
    static {
        CLIMBING = EntityDataManager.createKey(EntitySpider.class, DataSerializers.BYTE);
    }
    
    @Override
    public void setInWeb() {
    }
    
    @Nullable
    @Override
    protected ResourceLocation getLootTable() {
        return LootTableList.ENTITIES_SPIDER;
    }
    
    @Override
    public void onUpdate() {
        super.onUpdate();
        if (!this.world.isRemote) {
            this.setBesideClimbableBlock(this.isCollidedHorizontally);
        }
    }
    
    @Override
    public double getMountedYOffset() {
        return this.height * 0.5f;
    }
    
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_SPIDER_DEATH;
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(16.0);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.30000001192092896);
    }
    
    public static void registerFixesSpider(final DataFixer lllllllllllllIIIlIIIlIIIIlIIIIIl) {
        EntityLiving.registerFixesMob(lllllllllllllIIIlIIIlIIIIlIIIIIl, EntitySpider.class);
    }
    
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_SPIDER_AMBIENT;
    }
    
    @Override
    public float getEyeHeight() {
        return 0.65f;
    }
    
    @Nullable
    @Override
    public IEntityLivingData onInitialSpawn(final DifficultyInstance lllllllllllllIIIlIIIlIIIIIIIIIII, @Nullable IEntityLivingData lllllllllllllIIIlIIIIlllllllllll) {
        lllllllllllllIIIlIIIIlllllllllll = super.onInitialSpawn(lllllllllllllIIIlIIIlIIIIIIIIIII, lllllllllllllIIIlIIIIlllllllllll);
        if (this.world.rand.nextInt(100) == 0) {
            final EntitySkeleton lllllllllllllIIIlIIIlIIIIIIIIIll = new EntitySkeleton(this.world);
            lllllllllllllIIIlIIIlIIIIIIIIIll.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0f);
            lllllllllllllIIIlIIIlIIIIIIIIIll.onInitialSpawn(lllllllllllllIIIlIIIlIIIIIIIIIII, null);
            this.world.spawnEntityInWorld(lllllllllllllIIIlIIIlIIIIIIIIIll);
            lllllllllllllIIIlIIIlIIIIIIIIIll.startRiding(this);
        }
        if (lllllllllllllIIIlIIIIlllllllllll == null) {
            lllllllllllllIIIlIIIIlllllllllll = new GroupData();
            if (this.world.getDifficulty() == EnumDifficulty.HARD && this.world.rand.nextFloat() < 0.1f * lllllllllllllIIIlIIIlIIIIIIIIIII.getClampedAdditionalDifficulty()) {
                ((GroupData)lllllllllllllIIIlIIIIlllllllllll).setRandomEffect(this.world.rand);
            }
        }
        if (lllllllllllllIIIlIIIIlllllllllll instanceof GroupData) {
            final Potion lllllllllllllIIIlIIIlIIIIIIIIIlI = ((GroupData)lllllllllllllIIIlIIIIlllllllllll).effect;
            if (lllllllllllllIIIlIIIlIIIIIIIIIlI != null) {
                this.addPotionEffect(new PotionEffect(lllllllllllllIIIlIIIlIIIIIIIIIlI, Integer.MAX_VALUE));
            }
        }
        return lllllllllllllIIIlIIIIlllllllllll;
    }
    
    @Override
    protected void initEntityAI() {
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(3, new EntityAILeapAtTarget(this, 0.4f));
        this.tasks.addTask(4, new AISpiderAttack(this));
        this.tasks.addTask(5, new EntityAIWanderAvoidWater(this, 0.8));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0f));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false, (Class<?>[])new Class[0]));
        this.targetTasks.addTask(2, new AISpiderTarget<Object>(this, EntityPlayer.class));
        this.targetTasks.addTask(3, new AISpiderTarget<Object>(this, EntityIronGolem.class));
    }
    
    @Override
    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute.ARTHROPOD;
    }
    
    public boolean isBesideClimbableBlock() {
        return (this.dataManager.get(EntitySpider.CLIMBING) & 0x1) != 0x0;
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(EntitySpider.CLIMBING, (Byte)0);
    }
    
    @Override
    public boolean isOnLadder() {
        return this.isBesideClimbableBlock();
    }
    
    public EntitySpider(final World lllllllllllllIIIlIIIlIIIIlIIIlII) {
        super(lllllllllllllIIIlIIIlIIIIlIIIlII);
        this.setSize(1.4f, 0.9f);
    }
    
    public void setBesideClimbableBlock(final boolean lllllllllllllIIIlIIIlIIIIIIIllII) {
        byte lllllllllllllIIIlIIIlIIIIIIIlllI = this.dataManager.get(EntitySpider.CLIMBING);
        if (lllllllllllllIIIlIIIlIIIIIIIllII) {
            lllllllllllllIIIlIIIlIIIIIIIlllI |= 0x1;
        }
        else {
            lllllllllllllIIIlIIIlIIIIIIIlllI &= 0xFFFFFFFE;
        }
        this.dataManager.set(EntitySpider.CLIMBING, lllllllllllllIIIlIIIlIIIIIIIlllI);
    }
    
    @Override
    public boolean isPotionApplicable(final PotionEffect lllllllllllllIIIlIIIlIIIIIIllIIl) {
        return lllllllllllllIIIlIIIlIIIIIIllIIl.getPotion() != MobEffects.POISON && super.isPotionApplicable(lllllllllllllIIIlIIIlIIIIIIllIIl);
    }
    
    @Override
    protected void playStepSound(final BlockPos lllllllllllllIIIlIIIlIIIIIlIIlIl, final Block lllllllllllllIIIlIIIlIIIIIlIIlII) {
        this.playSound(SoundEvents.ENTITY_SPIDER_STEP, 0.15f, 1.0f);
    }
    
    static class AISpiderAttack extends EntityAIAttackMelee
    {
        @Override
        public boolean continueExecuting() {
            final float lllllllllllllIIIIIllIIIIlIIlllll = this.attacker.getBrightness();
            if (lllllllllllllIIIIIllIIIIlIIlllll >= 0.5f && this.attacker.getRNG().nextInt(100) == 0) {
                this.attacker.setAttackTarget(null);
                return false;
            }
            return super.continueExecuting();
        }
        
        @Override
        protected double getAttackReachSqr(final EntityLivingBase lllllllllllllIIIIIllIIIIlIIllIlI) {
            return 4.0f + lllllllllllllIIIIIllIIIIlIIllIlI.width;
        }
        
        public AISpiderAttack(final EntitySpider lllllllllllllIIIIIllIIIIlIlIIlIl) {
            super(lllllllllllllIIIIIllIIIIlIlIIlIl, 1.0, true);
        }
    }
    
    public static class GroupData implements IEntityLivingData
    {
        public /* synthetic */ Potion effect;
        
        public void setRandomEffect(final Random lllllllllllllllIllIIlllIlIIIllII) {
            final int lllllllllllllllIllIIlllIlIIIlIll = lllllllllllllllIllIIlllIlIIIllII.nextInt(5);
            if (lllllllllllllllIllIIlllIlIIIlIll <= 1) {
                this.effect = MobEffects.SPEED;
            }
            else if (lllllllllllllllIllIIlllIlIIIlIll <= 2) {
                this.effect = MobEffects.STRENGTH;
            }
            else if (lllllllllllllllIllIIlllIlIIIlIll <= 3) {
                this.effect = MobEffects.REGENERATION;
            }
            else if (lllllllllllllllIllIIlllIlIIIlIll <= 4) {
                this.effect = MobEffects.INVISIBILITY;
            }
        }
    }
    
    static class AISpiderTarget<T extends EntityLivingBase> extends EntityAINearestAttackableTarget<T>
    {
        @Override
        public boolean shouldExecute() {
            final float llllllllllllllIlllIlIIlIllllllII = this.taskOwner.getBrightness();
            return llllllllllllllIlllIlIIlIllllllII < 0.5f && super.shouldExecute();
        }
        
        public AISpiderTarget(final EntitySpider llllllllllllllIlllIlIIllIIIIIlII, final Class<T> llllllllllllllIlllIlIIllIIIIIIII) {
            super(llllllllllllllIlllIlIIllIIIIIlII, llllllllllllllIlllIlIIllIIIIIIII, true);
        }
    }
}
