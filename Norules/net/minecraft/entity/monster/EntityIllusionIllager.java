package net.minecraft.entity.monster;

import net.minecraft.world.storage.loot.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.entity.*;
import net.minecraft.inventory.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.potion.*;
import javax.annotation.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

public class EntityIllusionIllager extends EntitySpellcasterIllager implements IRangedAttackMob
{
    private /* synthetic */ int field_193099_c;
    private final /* synthetic */ Vec3d[][] field_193100_bx;
    
    @Override
    protected ResourceLocation getLootTable() {
        return LootTableList.EMPTY;
    }
    
    @Override
    public void setSwingingArms(final boolean lllllllllllllIllIlIIIIlIlllIIIll) {
        this.func_193079_a(1, lllllllllllllIllIlIIIIlIlllIIIll);
    }
    
    public EntityIllusionIllager(final World lllllllllllllIllIlIIIIllIlIIllIl) {
        super(lllllllllllllIllIlIIIIllIlIIllIl);
        this.setSize(0.6f, 1.95f);
        this.experienceValue = 5;
        this.field_193100_bx = new Vec3d[2][4];
        for (int lllllllllllllIllIlIIIIllIlIIllII = 0; lllllllllllllIllIlIIIIllIlIIllII < 4; ++lllllllllllllIllIlIIIIllIlIIllII) {
            this.field_193100_bx[0][lllllllllllllIllIlIIIIllIlIIllII] = new Vec3d(0.0, 0.0, 0.0);
            this.field_193100_bx[1][lllllllllllllIllIlIIIIllIlIIllII] = new Vec3d(0.0, 0.0, 0.0);
        }
    }
    
    public boolean func_193096_dj() {
        return this.func_193078_a(1);
    }
    
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.field_193786_de;
    }
    
    @Override
    public boolean isOnSameTeam(final Entity lllllllllllllIllIlIIIIllIIIlIIII) {
        return super.isOnSameTeam(lllllllllllllIllIlIIIIllIIIlIIII) || (lllllllllllllIllIlIIIIllIIIlIIII instanceof EntityLivingBase && ((EntityLivingBase)lllllllllllllIllIlIIIIllIIIlIIII).getCreatureAttribute() == EnumCreatureAttribute.ILLAGER && (this.getTeam() == null && lllllllllllllIllIlIIIIllIIIlIIII.getTeam() == null));
    }
    
    public Vec3d[] func_193098_a(final float lllllllllllllIllIlIIIIllIIIllIIl) {
        if (this.field_193099_c <= 0) {
            return this.field_193100_bx[1];
        }
        double lllllllllllllIllIlIIIIllIIIlllIl = (this.field_193099_c - lllllllllllllIllIlIIIIllIIIllIIl) / 3.0f;
        lllllllllllllIllIlIIIIllIIIlllIl = Math.pow(lllllllllllllIllIlIIIIllIIIlllIl, 0.25);
        final Vec3d[] lllllllllllllIllIlIIIIllIIIlllII = new Vec3d[4];
        for (int lllllllllllllIllIlIIIIllIIIllIll = 0; lllllllllllllIllIlIIIIllIIIllIll < 4; ++lllllllllllllIllIlIIIIllIIIllIll) {
            lllllllllllllIllIlIIIIllIIIlllII[lllllllllllllIllIlIIIIllIIIllIll] = this.field_193100_bx[1][lllllllllllllIllIlIIIIllIIIllIll].scale(1.0 - lllllllllllllIllIlIIIIllIIIlllIl).add(this.field_193100_bx[0][lllllllllllllIllIlIIIIllIIIllIll].scale(lllllllllllllIllIlIIIIllIIIlllIl));
        }
        return lllllllllllllIllIlIIIIllIIIlllII;
    }
    
    @Override
    public void attackEntityWithRangedAttack(final EntityLivingBase lllllllllllllIllIlIIIIllIIIIIIIl, final float lllllllllllllIllIlIIIIlIlllllIII) {
        final EntityArrow lllllllllllllIllIlIIIIlIllllllll = this.func_193097_t(lllllllllllllIllIlIIIIlIlllllIII);
        final double lllllllllllllIllIlIIIIlIlllllllI = lllllllllllllIllIlIIIIllIIIIIIIl.posX - this.posX;
        final double lllllllllllllIllIlIIIIlIllllllIl = lllllllllllllIllIlIIIIllIIIIIIIl.getEntityBoundingBox().minY + lllllllllllllIllIlIIIIllIIIIIIIl.height / 3.0f - lllllllllllllIllIlIIIIlIllllllll.posY;
        final double lllllllllllllIllIlIIIIlIllllllII = lllllllllllllIllIlIIIIllIIIIIIIl.posZ - this.posZ;
        final double lllllllllllllIllIlIIIIlIlllllIll = MathHelper.sqrt(lllllllllllllIllIlIIIIlIlllllllI * lllllllllllllIllIlIIIIlIlllllllI + lllllllllllllIllIlIIIIlIllllllII * lllllllllllllIllIlIIIIlIllllllII);
        lllllllllllllIllIlIIIIlIllllllll.setThrowableHeading(lllllllllllllIllIlIIIIlIlllllllI, lllllllllllllIllIlIIIIlIllllllIl + lllllllllllllIllIlIIIIlIlllllIll * 0.20000000298023224, lllllllllllllIllIlIIIIlIllllllII, 1.6f, (float)(14 - this.world.getDifficulty().getDifficultyId() * 4));
        this.playSound(SoundEvents.ENTITY_SKELETON_SHOOT, 1.0f, 1.0f / (this.getRNG().nextFloat() * 0.4f + 0.8f));
        this.world.spawnEntityInWorld(lllllllllllllIllIlIIIIlIllllllll);
    }
    
    @Override
    public IllagerArmPose func_193077_p() {
        if (this.func_193082_dl()) {
            return IllagerArmPose.SPELLCASTING;
        }
        return this.func_193096_dj() ? IllagerArmPose.BOW_AND_ARROW : IllagerArmPose.CROSSED;
    }
    
    @Override
    protected SoundEvent func_193086_dk() {
        return SoundEvents.field_193784_dd;
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(18.0);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(32.0);
    }
    
    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new AICastingApell());
        this.tasks.addTask(4, new AIMirriorSpell((AIMirriorSpell)null));
        this.tasks.addTask(5, new AIBlindnessSpell((AIBlindnessSpell)null));
        this.tasks.addTask(6, new EntityAIAttackRangedBow<Object>(this, 0.5, 20, 15.0f));
        this.tasks.addTask(8, new EntityAIWander(this, 0.6));
        this.tasks.addTask(9, new EntityAIWatchClosest(this, EntityPlayer.class, 3.0f, 1.0f));
        this.tasks.addTask(10, new EntityAIWatchClosest(this, EntityLiving.class, 8.0f));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, (Class<?>[])new Class[] { EntityIllusionIllager.class }));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget<Object>(this, EntityPlayer.class, true).func_190882_b(300));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget<Object>(this, EntityVillager.class, false).func_190882_b(300));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget<Object>(this, EntityIronGolem.class, false).func_190882_b(300));
    }
    
    protected EntityArrow func_193097_t(final float lllllllllllllIllIlIIIIlIlllIlIll) {
        final EntityTippedArrow lllllllllllllIllIlIIIIlIlllIllIl = new EntityTippedArrow(this.world, this);
        lllllllllllllIllIlIIIIlIlllIllIl.func_190547_a(this, lllllllllllllIllIlIIIIlIlllIlIll);
        return lllllllllllllIllIlIIIIlIlllIllIl;
    }
    
    @Override
    public IEntityLivingData onInitialSpawn(final DifficultyInstance lllllllllllllIllIlIIIIllIIlllIll, final IEntityLivingData lllllllllllllIllIlIIIIllIIllllIl) {
        this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.BOW));
        return super.onInitialSpawn(lllllllllllllIllIlIIIIllIIlllIll, lllllllllllllIllIlIIIIllIIllllIl);
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
    }
    
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.field_193783_dc;
    }
    
    @Override
    public AxisAlignedBB getRenderBoundingBox() {
        return this.getEntityBoundingBox().expand(3.0, 0.0, 3.0);
    }
    
    @Override
    protected SoundEvent getHurtSound(final DamageSource lllllllllllllIllIlIIIIllIIIIllII) {
        return SoundEvents.field_193787_df;
    }
    
    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (this.world.isRemote && this.isInvisible()) {
            --this.field_193099_c;
            if (this.field_193099_c < 0) {
                this.field_193099_c = 0;
            }
            if (this.hurtTime != 1 && this.ticksExisted % 1200 != 0) {
                if (this.hurtTime == this.maxHurtTime - 1) {
                    this.field_193099_c = 3;
                    for (int lllllllllllllIllIlIIIIllIIlIllIl = 0; lllllllllllllIllIlIIIIllIIlIllIl < 4; ++lllllllllllllIllIlIIIIllIIlIllIl) {
                        this.field_193100_bx[0][lllllllllllllIllIlIIIIllIIlIllIl] = this.field_193100_bx[1][lllllllllllllIllIlIIIIllIIlIllIl];
                        this.field_193100_bx[1][lllllllllllllIllIlIIIIllIIlIllIl] = new Vec3d(0.0, 0.0, 0.0);
                    }
                }
            }
            else {
                this.field_193099_c = 3;
                final float lllllllllllllIllIlIIIIllIIlIllII = -6.0f;
                final int lllllllllllllIllIlIIIIllIIlIlIll = 13;
                for (int lllllllllllllIllIlIIIIllIIlIlIlI = 0; lllllllllllllIllIlIIIIllIIlIlIlI < 4; ++lllllllllllllIllIlIIIIllIIlIlIlI) {
                    this.field_193100_bx[0][lllllllllllllIllIlIIIIllIIlIlIlI] = this.field_193100_bx[1][lllllllllllllIllIlIIIIllIIlIlIlI];
                    this.field_193100_bx[1][lllllllllllllIllIlIIIIllIIlIlIlI] = new Vec3d((-6.0f + this.rand.nextInt(13)) * 0.5, Math.max(0, this.rand.nextInt(6) - 4), (-6.0f + this.rand.nextInt(13)) * 0.5);
                }
                for (int lllllllllllllIllIlIIIIllIIlIlIIl = 0; lllllllllllllIllIlIIIIllIIlIlIIl < 16; ++lllllllllllllIllIlIIIIllIIlIlIIl) {
                    this.world.spawnParticle(EnumParticleTypes.CLOUD, this.posX + (this.rand.nextDouble() - 0.5) * this.width, this.posY + this.rand.nextDouble() * this.height, this.posZ + (this.rand.nextDouble() - 0.5) * this.width, 0.0, 0.0, 0.0, new int[0]);
                }
                this.world.playSound(this.posX, this.posY, this.posZ, SoundEvents.field_193788_dg, this.getSoundCategory(), 1.0f, 1.0f, false);
            }
        }
    }
    
    class AIMirriorSpell extends AIUseSpell
    {
        @Override
        protected int func_190872_i() {
            return 340;
        }
        
        @Override
        protected void func_190868_j() {
            EntityIllusionIllager.this.addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 1200));
        }
        
        private AIMirriorSpell() {
        }
        
        @Override
        public boolean shouldExecute() {
            return super.shouldExecute() && !EntityIllusionIllager.this.isPotionActive(MobEffects.INVISIBILITY);
        }
        
        @Nullable
        @Override
        protected SoundEvent func_190871_k() {
            return SoundEvents.field_193790_di;
        }
        
        @Override
        protected int func_190869_f() {
            return 20;
        }
        
        @Override
        protected SpellType func_193320_l() {
            return SpellType.DISAPPEAR;
        }
    }
    
    class AIBlindnessSpell extends AIUseSpell
    {
        private /* synthetic */ int field_193325_b;
        
        @Override
        public void startExecuting() {
            super.startExecuting();
            this.field_193325_b = EntityIllusionIllager.this.getAttackTarget().getEntityId();
        }
        
        @Override
        public boolean shouldExecute() {
            return super.shouldExecute() && EntityIllusionIllager.this.getAttackTarget() != null && EntityIllusionIllager.this.getAttackTarget().getEntityId() != this.field_193325_b && EntityIllusionIllager.this.world.getDifficultyForLocation(new BlockPos(EntityIllusionIllager.this)).func_193845_a((float)EnumDifficulty.NORMAL.ordinal());
        }
        
        @Override
        protected int func_190872_i() {
            return 180;
        }
        
        private AIBlindnessSpell() {
        }
        
        @Override
        protected void func_190868_j() {
            EntityIllusionIllager.this.getAttackTarget().addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 400));
        }
        
        @Override
        protected SoundEvent func_190871_k() {
            return SoundEvents.field_193789_dh;
        }
        
        @Override
        protected SpellType func_193320_l() {
            return SpellType.BLINDNESS;
        }
        
        @Override
        protected int func_190869_f() {
            return 20;
        }
    }
}
