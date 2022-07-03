package net.minecraft.entity.monster;

import net.minecraft.network.datasync.*;
import net.minecraft.util.*;
import net.minecraft.inventory.*;
import net.minecraft.item.*;
import javax.annotation.*;
import java.util.*;
import net.minecraft.init.*;
import net.minecraft.nbt.*;
import net.minecraft.world.*;
import net.minecraft.entity.item.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.*;
import net.minecraft.block.*;
import net.minecraft.entity.projectile.*;

public abstract class AbstractSkeleton extends EntityMob implements IRangedAttackMob
{
    private static final /* synthetic */ DataParameter<Boolean> SWINGING_ARMS;
    private final /* synthetic */ EntityAIAttackMelee aiAttackOnCollide;
    private final /* synthetic */ EntityAIAttackRangedBow<AbstractSkeleton> aiArrowAttack;
    
    static {
        SWINGING_ARMS = EntityDataManager.createKey(AbstractSkeleton.class, DataSerializers.BOOLEAN);
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(AbstractSkeleton.SWINGING_ARMS, false);
    }
    
    @Override
    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute.UNDEAD;
    }
    
    public boolean isSwingingArms() {
        return this.dataManager.get(AbstractSkeleton.SWINGING_ARMS);
    }
    
    abstract SoundEvent func_190727_o();
    
    @Override
    protected void setEquipmentBasedOnDifficulty(final DifficultyInstance lllllllllllllIIIlIIlIIIllIIlllII) {
        super.setEquipmentBasedOnDifficulty(lllllllllllllIIIlIIlIIIllIIlllII);
        this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.BOW));
    }
    
    @Override
    public double getYOffset() {
        return -0.6;
    }
    
    @Override
    public void setItemStackToSlot(final EntityEquipmentSlot lllllllllllllIIIlIIlIIIlIlIllIII, final ItemStack lllllllllllllIIIlIIlIIIlIlIlIlll) {
        super.setItemStackToSlot(lllllllllllllIIIlIIlIIIlIlIllIII, lllllllllllllIIIlIIlIIIlIlIlIlll);
        if (!this.world.isRemote && lllllllllllllIIIlIIlIIIlIlIllIII == EntityEquipmentSlot.MAINHAND) {
            this.setCombatTask();
        }
    }
    
    @Nullable
    @Override
    public IEntityLivingData onInitialSpawn(final DifficultyInstance lllllllllllllIIIlIIlIIIllIIlIIlI, @Nullable IEntityLivingData lllllllllllllIIIlIIlIIIllIIlIIIl) {
        lllllllllllllIIIlIIlIIIllIIlIIIl = super.onInitialSpawn(lllllllllllllIIIlIIlIIIllIIlIIlI, lllllllllllllIIIlIIlIIIllIIlIIIl);
        this.setEquipmentBasedOnDifficulty(lllllllllllllIIIlIIlIIIllIIlIIlI);
        this.setEnchantmentBasedOnDifficulty(lllllllllllllIIIlIIlIIIllIIlIIlI);
        this.setCombatTask();
        this.setCanPickUpLoot(this.rand.nextFloat() < 0.55f * lllllllllllllIIIlIIlIIIllIIlIIlI.getClampedAdditionalDifficulty());
        if (this.getItemStackFromSlot(EntityEquipmentSlot.HEAD).func_190926_b()) {
            final Calendar lllllllllllllIIIlIIlIIIllIIlIlII = this.world.getCurrentDate();
            if (lllllllllllllIIIlIIlIIIllIIlIlII.get(2) + 1 == 10 && lllllllllllllIIIlIIlIIIllIIlIlII.get(5) == 31 && this.rand.nextFloat() < 0.25f) {
                this.setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack((this.rand.nextFloat() < 0.1f) ? Blocks.LIT_PUMPKIN : Blocks.PUMPKIN));
                this.inventoryArmorDropChances[EntityEquipmentSlot.HEAD.getIndex()] = 0.0f;
            }
        }
        return lllllllllllllIIIlIIlIIIllIIlIIIl;
    }
    
    @Override
    public void attackEntityWithRangedAttack(final EntityLivingBase lllllllllllllIIIlIIlIIIlIlllIlIl, final float lllllllllllllIIIlIIlIIIlIlllIlII) {
        final EntityArrow lllllllllllllIIIlIIlIIIlIllllIll = this.func_190726_a(lllllllllllllIIIlIIlIIIlIlllIlII);
        final double lllllllllllllIIIlIIlIIIlIllllIlI = lllllllllllllIIIlIIlIIIlIlllIlIl.posX - this.posX;
        final double lllllllllllllIIIlIIlIIIlIllllIIl = lllllllllllllIIIlIIlIIIlIlllIlIl.getEntityBoundingBox().minY + lllllllllllllIIIlIIlIIIlIlllIlIl.height / 3.0f - lllllllllllllIIIlIIlIIIlIllllIll.posY;
        final double lllllllllllllIIIlIIlIIIlIllllIII = lllllllllllllIIIlIIlIIIlIlllIlIl.posZ - this.posZ;
        final double lllllllllllllIIIlIIlIIIlIlllIlll = MathHelper.sqrt(lllllllllllllIIIlIIlIIIlIllllIlI * lllllllllllllIIIlIIlIIIlIllllIlI + lllllllllllllIIIlIIlIIIlIllllIII * lllllllllllllIIIlIIlIIIlIllllIII);
        lllllllllllllIIIlIIlIIIlIllllIll.setThrowableHeading(lllllllllllllIIIlIIlIIIlIllllIlI, lllllllllllllIIIlIIlIIIlIllllIIl + lllllllllllllIIIlIIlIIIlIlllIlll * 0.20000000298023224, lllllllllllllIIIlIIlIIIlIllllIII, 1.6f, (float)(14 - this.world.getDifficulty().getDifficultyId() * 4));
        this.playSound(SoundEvents.ENTITY_SKELETON_SHOOT, 1.0f, 1.0f / (this.getRNG().nextFloat() * 0.4f + 0.8f));
        this.world.spawnEntityInWorld(lllllllllllllIIIlIIlIIIlIllllIll);
    }
    
    @Override
    public void setSwingingArms(final boolean lllllllllllllIIIlIIlIIIlIlIIlllI) {
        this.dataManager.set(AbstractSkeleton.SWINGING_ARMS, lllllllllllllIIIlIIlIIIlIlIIlllI);
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound lllllllllllllIIIlIIlIIIlIllIIIlI) {
        super.readEntityFromNBT(lllllllllllllIIIlIIlIIIlIllIIIlI);
        this.setCombatTask();
    }
    
    public AbstractSkeleton(final World lllllllllllllIIIlIIlIIIlllIIlIII) {
        super(lllllllllllllIIIlIIlIIIlllIIlIII);
        this.aiArrowAttack = new EntityAIAttackRangedBow<AbstractSkeleton>(this, 1.0, 20, 15.0f);
        this.aiAttackOnCollide = new EntityAIAttackMelee((EntityCreature)this, 1.2, false) {
            @Override
            public void startExecuting() {
                super.startExecuting();
                AbstractSkeleton.this.setSwingingArms(true);
            }
            
            @Override
            public void resetTask() {
                super.resetTask();
                AbstractSkeleton.this.setSwingingArms(false);
            }
        };
        this.setSize(0.6f, 1.99f);
        this.setCombatTask();
    }
    
    @Override
    public float getEyeHeight() {
        return 1.74f;
    }
    
    public void setCombatTask() {
        if (this.world != null && !this.world.isRemote) {
            this.tasks.removeTask(this.aiAttackOnCollide);
            this.tasks.removeTask(this.aiArrowAttack);
            final ItemStack lllllllllllllIIIlIIlIIIllIIIlIll = this.getHeldItemMainhand();
            if (lllllllllllllIIIlIIlIIIllIIIlIll.getItem() == Items.BOW) {
                int lllllllllllllIIIlIIlIIIllIIIlIlI = 20;
                if (this.world.getDifficulty() != EnumDifficulty.HARD) {
                    lllllllllllllIIIlIIlIIIllIIIlIlI = 40;
                }
                this.aiArrowAttack.setAttackCooldown(lllllllllllllIIIlIIlIIIllIIIlIlI);
                this.tasks.addTask(4, this.aiArrowAttack);
            }
            else {
                this.tasks.addTask(4, this.aiAttackOnCollide);
            }
        }
    }
    
    @Override
    public void onLivingUpdate() {
        if (this.world.isDaytime() && !this.world.isRemote) {
            final float lllllllllllllIIIlIIlIIIllIllIIII = this.getBrightness();
            final BlockPos lllllllllllllIIIlIIlIIIllIlIllll = (this.getRidingEntity() instanceof EntityBoat) ? new BlockPos(this.posX, (double)Math.round(this.posY), this.posZ).up() : new BlockPos(this.posX, (double)Math.round(this.posY), this.posZ);
            if (lllllllllllllIIIlIIlIIIllIllIIII > 0.5f && this.rand.nextFloat() * 30.0f < (lllllllllllllIIIlIIlIIIllIllIIII - 0.4f) * 2.0f && this.world.canSeeSky(lllllllllllllIIIlIIlIIIllIlIllll)) {
                boolean lllllllllllllIIIlIIlIIIllIlIlllI = true;
                final ItemStack lllllllllllllIIIlIIlIIIllIlIllIl = this.getItemStackFromSlot(EntityEquipmentSlot.HEAD);
                if (!lllllllllllllIIIlIIlIIIllIlIllIl.func_190926_b()) {
                    if (lllllllllllllIIIlIIlIIIllIlIllIl.isItemStackDamageable()) {
                        lllllllllllllIIIlIIlIIIllIlIllIl.setItemDamage(lllllllllllllIIIlIIlIIIllIlIllIl.getItemDamage() + this.rand.nextInt(2));
                        if (lllllllllllllIIIlIIlIIIllIlIllIl.getItemDamage() >= lllllllllllllIIIlIIlIIIllIlIllIl.getMaxDamage()) {
                            this.renderBrokenItemStack(lllllllllllllIIIlIIlIIIllIlIllIl);
                            this.setItemStackToSlot(EntityEquipmentSlot.HEAD, ItemStack.field_190927_a);
                        }
                    }
                    lllllllllllllIIIlIIlIIIllIlIlllI = false;
                }
                if (lllllllllllllIIIlIIlIIIllIlIlllI) {
                    this.setFire(8);
                }
            }
        }
        super.onLivingUpdate();
    }
    
    @Override
    public void updateRidden() {
        super.updateRidden();
        if (this.getRidingEntity() instanceof EntityCreature) {
            final EntityCreature lllllllllllllIIIlIIlIIIllIlIIlII = (EntityCreature)this.getRidingEntity();
            this.renderYawOffset = lllllllllllllIIIlIIlIIIllIlIIlII.renderYawOffset;
        }
    }
    
    @Override
    protected void initEntityAI() {
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIRestrictSun(this));
        this.tasks.addTask(3, new EntityAIFleeSun(this, 1.0));
        this.tasks.addTask(3, new EntityAIAvoidEntity<Object>(this, EntityWolf.class, 6.0f, 1.0, 1.2));
        this.tasks.addTask(5, new EntityAIWanderAvoidWater(this, 1.0));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0f));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false, (Class<?>[])new Class[0]));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget<Object>(this, EntityPlayer.class, true));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget<Object>(this, EntityIronGolem.class, true));
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25);
    }
    
    @Override
    protected void playStepSound(final BlockPos lllllllllllllIIIlIIlIIIllIlllIlI, final Block lllllllllllllIIIlIIlIIIllIlllIIl) {
        this.playSound(this.func_190727_o(), 0.15f, 1.0f);
    }
    
    protected EntityArrow func_190726_a(final float lllllllllllllIIIlIIlIIIlIllIlIlI) {
        final EntityTippedArrow lllllllllllllIIIlIIlIIIlIllIlIIl = new EntityTippedArrow(this.world, this);
        lllllllllllllIIIlIIlIIIlIllIlIIl.func_190547_a(this, lllllllllllllIIIlIIlIIIlIllIlIlI);
        return lllllllllllllIIIlIIlIIIlIllIlIIl;
    }
}
