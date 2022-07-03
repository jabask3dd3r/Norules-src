package net.minecraft.entity.passive;

import java.util.*;
import net.minecraft.nbt.*;
import javax.annotation.*;
import net.minecraft.entity.effect.*;
import net.minecraft.entity.monster.*;
import net.minecraft.inventory.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.datafix.*;
import net.minecraft.block.*;
import net.minecraft.util.*;
import net.minecraft.world.storage.loot.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.network.datasync.*;
import com.google.common.collect.*;

public class EntityPig extends EntityAnimal
{
    private /* synthetic */ int boostTime;
    private static final /* synthetic */ DataParameter<Integer> field_191520_bx;
    private static final /* synthetic */ Set<Item> TEMPTATION_ITEMS;
    private /* synthetic */ boolean boosting;
    private /* synthetic */ int totalBoostTime;
    private static final /* synthetic */ DataParameter<Boolean> SADDLED;
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound llllllllllllllIlIlIllllIIlIIIIll) {
        super.readEntityFromNBT(llllllllllllllIlIlIllllIIlIIIIll);
        this.setSaddled(llllllllllllllIlIlIllllIIlIIIIll.getBoolean("Saddle"));
    }
    
    @Override
    public EntityPig createChild(final EntityAgeable llllllllllllllIlIlIlllIlllllIllI) {
        return new EntityPig(this.world);
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(EntityPig.SADDLED, false);
        this.dataManager.register(EntityPig.field_191520_bx, 0);
    }
    
    @Nullable
    @Override
    public Entity getControllingPassenger() {
        return this.getPassengers().isEmpty() ? null : this.getPassengers().get(0);
    }
    
    @Override
    protected SoundEvent getHurtSound(final DamageSource llllllllllllllIlIlIllllIIIlllllI) {
        return SoundEvents.ENTITY_PIG_HURT;
    }
    
    @Override
    public void onStruckByLightning(final EntityLightningBolt llllllllllllllIlIlIllllIIIIllIII) {
        if (!this.world.isRemote && !this.isDead) {
            final EntityPigZombie llllllllllllllIlIlIllllIIIIlIlll = new EntityPigZombie(this.world);
            llllllllllllllIlIlIllllIIIIlIlll.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.GOLDEN_SWORD));
            llllllllllllllIlIlIllllIIIIlIlll.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
            llllllllllllllIlIlIllllIIIIlIlll.setNoAI(this.isAIDisabled());
            if (this.hasCustomName()) {
                llllllllllllllIlIlIllllIIIIlIlll.setCustomNameTag(this.getCustomNameTag());
                llllllllllllllIlIlIllllIIIIlIlll.setAlwaysRenderNameTag(this.getAlwaysRenderNameTag());
            }
            this.world.spawnEntityInWorld(llllllllllllllIlIlIllllIIIIlIlll);
            this.setDead();
        }
    }
    
    @Override
    public boolean processInteract(final EntityPlayer llllllllllllllIlIlIllllIIIllIIlI, final EnumHand llllllllllllllIlIlIllllIIIllIIIl) {
        if (super.processInteract(llllllllllllllIlIlIllllIIIllIIlI, llllllllllllllIlIlIllllIIIllIIIl)) {
            return true;
        }
        final ItemStack llllllllllllllIlIlIllllIIIllIIII = llllllllllllllIlIlIllllIIIllIIlI.getHeldItem(llllllllllllllIlIlIllllIIIllIIIl);
        if (llllllllllllllIlIlIllllIIIllIIII.getItem() == Items.NAME_TAG) {
            llllllllllllllIlIlIllllIIIllIIII.interactWithEntity(llllllllllllllIlIlIllllIIIllIIlI, this, llllllllllllllIlIlIllllIIIllIIIl);
            return true;
        }
        if (this.getSaddled() && !this.isBeingRidden()) {
            if (!this.world.isRemote) {
                llllllllllllllIlIlIllllIIIllIIlI.startRiding(this);
            }
            return true;
        }
        if (llllllllllllllIlIlIllllIIIllIIII.getItem() == Items.SADDLE) {
            llllllllllllllIlIlIllllIIIllIIII.interactWithEntity(llllllllllllllIlIlIllllIIIllIIlI, this, llllllllllllllIlIlIllllIIIllIIIl);
            return true;
        }
        return false;
    }
    
    public static void registerFixesPig(final DataFixer llllllllllllllIlIlIllllIIlIIllIl) {
        EntityLiving.registerFixesMob(llllllllllllllIlIlIllllIIlIIllIl, EntityPig.class);
    }
    
    @Override
    public boolean isBreedingItem(final ItemStack llllllllllllllIlIlIlllIlllllIIIl) {
        return EntityPig.TEMPTATION_ITEMS.contains(llllllllllllllIlIlIlllIlllllIIIl.getItem());
    }
    
    @Override
    public boolean canBeSteered() {
        final Entity llllllllllllllIlIlIllllIIllIIIlI = this.getControllingPassenger();
        if (!(llllllllllllllIlIlIllllIIllIIIlI instanceof EntityPlayer)) {
            return false;
        }
        final EntityPlayer llllllllllllllIlIlIllllIIllIIIIl = (EntityPlayer)llllllllllllllIlIlIllllIIllIIIlI;
        return llllllllllllllIlIlIllllIIllIIIIl.getHeldItemMainhand().getItem() == Items.CARROT_ON_A_STICK || llllllllllllllIlIlIllllIIllIIIIl.getHeldItemOffhand().getItem() == Items.CARROT_ON_A_STICK;
    }
    
    @Override
    protected void playStepSound(final BlockPos llllllllllllllIlIlIllllIIIlllIlI, final Block llllllllllllllIlIlIllllIIIlllIIl) {
        this.playSound(SoundEvents.ENTITY_PIG_STEP, 0.15f, 1.0f);
    }
    
    public boolean boost() {
        if (this.boosting) {
            return false;
        }
        this.boosting = true;
        this.boostTime = 0;
        this.totalBoostTime = this.getRNG().nextInt(841) + 140;
        this.getDataManager().set(EntityPig.field_191520_bx, this.totalBoostTime);
        return true;
    }
    
    public void setSaddled(final boolean llllllllllllllIlIlIllllIIIIllllI) {
        if (llllllllllllllIlIlIllllIIIIllllI) {
            this.dataManager.set(EntityPig.SADDLED, true);
        }
        else {
            this.dataManager.set(EntityPig.SADDLED, false);
        }
    }
    
    @Nullable
    @Override
    protected ResourceLocation getLootTable() {
        return LootTableList.ENTITIES_PIG;
    }
    
    @Override
    public void func_191986_a(final float llllllllllllllIlIlIllllIIIIIlIll, final float llllllllllllllIlIlIllllIIIIIlIlI, final float llllllllllllllIlIlIllllIIIIIlIIl) {
        final Entity llllllllllllllIlIlIllllIIIIIlIII = this.getPassengers().isEmpty() ? null : this.getPassengers().get(0);
        if (this.isBeingRidden() && this.canBeSteered()) {
            this.rotationYaw = llllllllllllllIlIlIllllIIIIIlIII.rotationYaw;
            this.prevRotationYaw = this.rotationYaw;
            this.rotationPitch = llllllllllllllIlIlIllllIIIIIlIII.rotationPitch * 0.5f;
            this.setRotation(this.rotationYaw, this.rotationPitch);
            this.renderYawOffset = this.rotationYaw;
            this.rotationYawHead = this.rotationYaw;
            this.stepHeight = 1.0f;
            this.jumpMovementFactor = this.getAIMoveSpeed() * 0.1f;
            if (this.boosting && this.boostTime++ > this.totalBoostTime) {
                this.boosting = false;
            }
            if (this.canPassengerSteer()) {
                float llllllllllllllIlIlIllllIIIIIIlll = (float)this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue() * 0.225f;
                if (this.boosting) {
                    llllllllllllllIlIlIllllIIIIIIlll += llllllllllllllIlIlIllllIIIIIIlll * 1.15f * MathHelper.sin(this.boostTime / (float)this.totalBoostTime * 3.1415927f);
                }
                this.setAIMoveSpeed(llllllllllllllIlIlIllllIIIIIIlll);
                super.func_191986_a(0.0f, 0.0f, 1.0f);
            }
            else {
                this.motionX = 0.0;
                this.motionY = 0.0;
                this.motionZ = 0.0;
            }
            this.prevLimbSwingAmount = this.limbSwingAmount;
            final double llllllllllllllIlIlIllllIIIIIIllI = this.posX - this.prevPosX;
            final double llllllllllllllIlIlIllllIIIIIIlIl = this.posZ - this.prevPosZ;
            float llllllllllllllIlIlIllllIIIIIIlII = MathHelper.sqrt(llllllllllllllIlIlIllllIIIIIIllI * llllllllllllllIlIlIllllIIIIIIllI + llllllllllllllIlIlIllllIIIIIIlIl * llllllllllllllIlIlIllllIIIIIIlIl) * 4.0f;
            if (llllllllllllllIlIlIllllIIIIIIlII > 1.0f) {
                llllllllllllllIlIlIllllIIIIIIlII = 1.0f;
            }
            this.limbSwingAmount += (llllllllllllllIlIlIllllIIIIIIlII - this.limbSwingAmount) * 0.4f;
            this.limbSwing += this.limbSwingAmount;
        }
        else {
            this.stepHeight = 0.5f;
            this.jumpMovementFactor = 0.02f;
            super.func_191986_a(llllllllllllllIlIlIllllIIIIIlIll, llllllllllllllIlIlIllllIIIIIlIlI, llllllllllllllIlIlIllllIIIIIlIIl);
        }
    }
    
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_PIG_DEATH;
    }
    
    public EntityPig(final World llllllllllllllIlIlIllllIlIIIlIlI) {
        super(llllllllllllllIlIlIllllIlIIIlIlI);
        this.setSize(0.9f, 0.9f);
    }
    
    @Override
    protected void initEntityAI() {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 1.25));
        this.tasks.addTask(3, new EntityAIMate(this, 1.0));
        this.tasks.addTask(4, new EntityAITempt(this, 1.2, Items.CARROT_ON_A_STICK, false));
        this.tasks.addTask(4, new EntityAITempt(this, 1.2, false, EntityPig.TEMPTATION_ITEMS));
        this.tasks.addTask(5, new EntityAIFollowParent(this, 1.1));
        this.tasks.addTask(6, new EntityAIWanderAvoidWater(this, 1.0));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0f));
        this.tasks.addTask(8, new EntityAILookIdle(this));
    }
    
    @Override
    public void onDeath(final DamageSource llllllllllllllIlIlIllllIIIlIlIII) {
        super.onDeath(llllllllllllllIlIlIllllIIIlIlIII);
        if (!this.world.isRemote && this.getSaddled()) {
            this.dropItem(Items.SADDLE, 1);
        }
    }
    
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_PIG_AMBIENT;
    }
    
    @Override
    public void notifyDataManagerChange(final DataParameter<?> llllllllllllllIlIlIllllIIlIlIlIl) {
        if (EntityPig.field_191520_bx.equals(llllllllllllllIlIlIllllIIlIlIlIl) && this.world.isRemote) {
            this.boosting = true;
            this.boostTime = 0;
            this.totalBoostTime = this.dataManager.get(EntityPig.field_191520_bx);
        }
        super.notifyDataManagerChange(llllllllllllllIlIlIllllIIlIlIlIl);
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25);
    }
    
    static {
        SADDLED = EntityDataManager.createKey(EntityPig.class, DataSerializers.BOOLEAN);
        field_191520_bx = EntityDataManager.createKey(EntityPig.class, DataSerializers.VARINT);
        TEMPTATION_ITEMS = Sets.newHashSet((Object[])new Item[] { Items.CARROT, Items.POTATO, Items.BEETROOT });
    }
    
    public boolean getSaddled() {
        return this.dataManager.get(EntityPig.SADDLED);
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound llllllllllllllIlIlIllllIIlIIlIIl) {
        super.writeEntityToNBT(llllllllllllllIlIlIllllIIlIIlIIl);
        llllllllllllllIlIlIllllIIlIIlIIl.setBoolean("Saddle", this.getSaddled());
    }
}
