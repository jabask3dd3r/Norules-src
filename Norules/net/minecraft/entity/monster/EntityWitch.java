package net.minecraft.entity.monster;

import net.minecraft.network.datasync.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.ai.*;
import net.minecraft.world.storage.loot.*;
import javax.annotation.*;
import net.minecraft.util.datafix.*;
import net.minecraft.world.*;
import net.minecraft.inventory.*;
import net.minecraft.block.material.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import java.util.*;
import net.minecraft.potion.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.util.*;

public class EntityWitch extends EntityMob implements IRangedAttackMob
{
    private /* synthetic */ int witchAttackTimer;
    private static final /* synthetic */ AttributeModifier MODIFIER;
    private static final /* synthetic */ UUID MODIFIER_UUID;
    private static final /* synthetic */ DataParameter<Boolean> IS_AGGRESSIVE;
    
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_WITCH_DEATH;
    }
    
    static {
        MODIFIER_UUID = UUID.fromString("5CD17E52-A79A-43D3-A529-90FDE04B181E");
        MODIFIER = new AttributeModifier(EntityWitch.MODIFIER_UUID, "Drinking speed penalty", -0.25, 0).setSaved(false);
        IS_AGGRESSIVE = EntityDataManager.createKey(EntityWitch.class, DataSerializers.BOOLEAN);
    }
    
    public boolean isDrinkingPotion() {
        return this.getDataManager().get(EntityWitch.IS_AGGRESSIVE);
    }
    
    @Override
    protected void initEntityAI() {
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIAttackRanged(this, 1.0, 60, 10.0f));
        this.tasks.addTask(2, new EntityAIWanderAvoidWater(this, 1.0));
        this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0f));
        this.tasks.addTask(3, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false, (Class<?>[])new Class[0]));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget<Object>(this, EntityPlayer.class, true));
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(26.0);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25);
    }
    
    @Nullable
    @Override
    protected ResourceLocation getLootTable() {
        return LootTableList.ENTITIES_WITCH;
    }
    
    @Override
    public void setSwingingArms(final boolean lllIIlIIIlllIII) {
    }
    
    public static void registerFixesWitch(final DataFixer lllIIlIlIIlIIII) {
        EntityLiving.registerFixesMob(lllIIlIlIIlIIII, EntityWitch.class);
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.getDataManager().register(EntityWitch.IS_AGGRESSIVE, false);
    }
    
    public EntityWitch(final World lllIIlIlIIlIIll) {
        super(lllIIlIlIIlIIll);
        this.setSize(0.6f, 1.95f);
    }
    
    public void setAggressive(final boolean lllIIlIlIIIIIII) {
        this.getDataManager().set(EntityWitch.IS_AGGRESSIVE, lllIIlIlIIIIIII);
    }
    
    @Override
    protected float applyPotionDamageCalculations(final DamageSource lllIIlIIlIlllII, float lllIIlIIlIllIII) {
        lllIIlIIlIllIII = super.applyPotionDamageCalculations(lllIIlIIlIlllII, lllIIlIIlIllIII);
        if (lllIIlIIlIlllII.getEntity() == this) {
            lllIIlIIlIllIII = 0.0f;
        }
        if (lllIIlIIlIlllII.isMagicDamage()) {
            lllIIlIIlIllIII *= (float)0.15;
        }
        return lllIIlIIlIllIII;
    }
    
    @Override
    public float getEyeHeight() {
        return 1.62f;
    }
    
    @Override
    public void onLivingUpdate() {
        if (!this.world.isRemote) {
            if (this.isDrinkingPotion()) {
                if (this.witchAttackTimer-- <= 0) {
                    this.setAggressive(false);
                    final ItemStack lllIIlIIlllIIll = this.getHeldItemMainhand();
                    this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, ItemStack.field_190927_a);
                    if (lllIIlIIlllIIll.getItem() == Items.POTIONITEM) {
                        final List<PotionEffect> lllIIlIIlllIIlI = PotionUtils.getEffectsFromStack(lllIIlIIlllIIll);
                        if (lllIIlIIlllIIlI != null) {
                            for (final PotionEffect lllIIlIIlllIIIl : lllIIlIIlllIIlI) {
                                this.addPotionEffect(new PotionEffect(lllIIlIIlllIIIl));
                            }
                        }
                    }
                    this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).removeModifier(EntityWitch.MODIFIER);
                }
            }
            else {
                PotionType lllIIlIIlllIIII = null;
                if (this.rand.nextFloat() < 0.15f && this.isInsideOfMaterial(Material.WATER) && !this.isPotionActive(MobEffects.WATER_BREATHING)) {
                    lllIIlIIlllIIII = PotionTypes.WATER_BREATHING;
                }
                else if (this.rand.nextFloat() < 0.15f && (this.isBurning() || (this.getLastDamageSource() != null && this.getLastDamageSource().isFireDamage())) && !this.isPotionActive(MobEffects.FIRE_RESISTANCE)) {
                    lllIIlIIlllIIII = PotionTypes.FIRE_RESISTANCE;
                }
                else if (this.rand.nextFloat() < 0.05f && this.getHealth() < this.getMaxHealth()) {
                    lllIIlIIlllIIII = PotionTypes.HEALING;
                }
                else if (this.rand.nextFloat() < 0.5f && this.getAttackTarget() != null && !this.isPotionActive(MobEffects.SPEED) && this.getAttackTarget().getDistanceSqToEntity(this) > 121.0) {
                    lllIIlIIlllIIII = PotionTypes.SWIFTNESS;
                }
                if (lllIIlIIlllIIII != null) {
                    this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), lllIIlIIlllIIII));
                    this.witchAttackTimer = this.getHeldItemMainhand().getMaxItemUseDuration();
                    this.setAggressive(true);
                    this.world.playSound(null, this.posX, this.posY, this.posZ, SoundEvents.ENTITY_WITCH_DRINK, this.getSoundCategory(), 1.0f, 0.8f + this.rand.nextFloat() * 0.4f);
                    final IAttributeInstance lllIIlIIllIllll = this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED);
                    lllIIlIIllIllll.removeModifier(EntityWitch.MODIFIER);
                    lllIIlIIllIllll.applyModifier(EntityWitch.MODIFIER);
                }
            }
            if (this.rand.nextFloat() < 7.5E-4f) {
                this.world.setEntityState(this, (byte)15);
            }
        }
        super.onLivingUpdate();
    }
    
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_WITCH_AMBIENT;
    }
    
    @Override
    protected SoundEvent getHurtSound(final DamageSource lllIIlIlIIIIlll) {
        return SoundEvents.ENTITY_WITCH_HURT;
    }
    
    @Override
    public void attackEntityWithRangedAttack(final EntityLivingBase lllIIlIIlIIIIlI, final float lllIIlIIlIIlIll) {
        if (!this.isDrinkingPotion()) {
            final double lllIIlIIlIIlIlI = lllIIlIIlIIIIlI.posY + lllIIlIIlIIIIlI.getEyeHeight() - 1.100000023841858;
            final double lllIIlIIlIIlIIl = lllIIlIIlIIIIlI.posX + lllIIlIIlIIIIlI.motionX - this.posX;
            final double lllIIlIIlIIlIII = lllIIlIIlIIlIlI - this.posY;
            final double lllIIlIIlIIIlll = lllIIlIIlIIIIlI.posZ + lllIIlIIlIIIIlI.motionZ - this.posZ;
            final float lllIIlIIlIIIllI = MathHelper.sqrt(lllIIlIIlIIlIIl * lllIIlIIlIIlIIl + lllIIlIIlIIIlll * lllIIlIIlIIIlll);
            PotionType lllIIlIIlIIIlIl = PotionTypes.HARMING;
            if (lllIIlIIlIIIllI >= 8.0f && !lllIIlIIlIIIIlI.isPotionActive(MobEffects.SLOWNESS)) {
                lllIIlIIlIIIlIl = PotionTypes.SLOWNESS;
            }
            else if (lllIIlIIlIIIIlI.getHealth() >= 8.0f && !lllIIlIIlIIIIlI.isPotionActive(MobEffects.POISON)) {
                lllIIlIIlIIIlIl = PotionTypes.POISON;
            }
            else if (lllIIlIIlIIIllI <= 3.0f && !lllIIlIIlIIIIlI.isPotionActive(MobEffects.WEAKNESS) && this.rand.nextFloat() < 0.25f) {
                lllIIlIIlIIIlIl = PotionTypes.WEAKNESS;
            }
            final EntityPotion entityPotion;
            final EntityPotion lllIIlIIlIIIlII = entityPotion = new EntityPotion(this.world, this, PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), lllIIlIIlIIIlIl));
            entityPotion.rotationPitch += 20.0f;
            lllIIlIIlIIIlII.setThrowableHeading(lllIIlIIlIIlIIl, lllIIlIIlIIlIII + lllIIlIIlIIIllI * 0.2f, lllIIlIIlIIIlll, 0.75f, 8.0f);
            this.world.playSound(null, this.posX, this.posY, this.posZ, SoundEvents.ENTITY_WITCH_THROW, this.getSoundCategory(), 1.0f, 0.8f + this.rand.nextFloat() * 0.4f);
            this.world.spawnEntityInWorld(lllIIlIIlIIIlII);
        }
    }
    
    @Override
    public void handleStatusUpdate(final byte lllIIlIIllIIIlI) {
        if (lllIIlIIllIIIlI == 15) {
            for (int lllIIlIIllIIlII = 0; lllIIlIIllIIlII < this.rand.nextInt(35) + 10; ++lllIIlIIllIIlII) {
                this.world.spawnParticle(EnumParticleTypes.SPELL_WITCH, this.posX + this.rand.nextGaussian() * 0.12999999523162842, this.getEntityBoundingBox().maxY + 0.5 + this.rand.nextGaussian() * 0.12999999523162842, this.posZ + this.rand.nextGaussian() * 0.12999999523162842, 0.0, 0.0, 0.0, new int[0]);
            }
        }
        else {
            super.handleStatusUpdate(lllIIlIIllIIIlI);
        }
    }
}
