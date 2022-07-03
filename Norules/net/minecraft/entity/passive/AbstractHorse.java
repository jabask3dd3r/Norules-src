package net.minecraft.entity.passive;

import java.util.*;
import com.google.common.base.*;
import javax.annotation.*;
import net.minecraft.item.*;
import net.minecraft.block.*;
import net.minecraft.init.*;
import net.minecraft.util.math.*;
import net.minecraft.inventory.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.advancements.*;
import net.minecraft.nbt.*;
import net.minecraft.network.datasync.*;
import net.minecraft.entity.ai.*;
import net.minecraft.server.management.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.util.datafix.walkers.*;
import net.minecraft.util.datafix.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.block.material.*;
import net.minecraft.block.state.*;

public abstract class AbstractHorse extends EntityAnimal implements IJumpingMount, IInventoryChangedListener
{
    protected /* synthetic */ boolean horseJumping;
    private static final /* synthetic */ DataParameter<Optional<UUID>> OWNER_UNIQUE_ID;
    private /* synthetic */ float prevHeadLean;
    protected static final /* synthetic */ IAttribute JUMP_STRENGTH;
    private /* synthetic */ float prevRearingAmount;
    private /* synthetic */ int field_190689_bJ;
    protected /* synthetic */ int temper;
    public /* synthetic */ int sprintCounter;
    private /* synthetic */ float rearingAmount;
    private static final /* synthetic */ Predicate<Entity> IS_HORSE_BREEDING;
    private /* synthetic */ float mouthOpenness;
    private /* synthetic */ int openMouthCounter;
    private /* synthetic */ float headLean;
    private /* synthetic */ int jumpRearingCounter;
    private /* synthetic */ float prevMouthOpenness;
    protected /* synthetic */ int gallopTime;
    private static final /* synthetic */ DataParameter<Byte> STATUS;
    protected /* synthetic */ ContainerHorseChest horseChest;
    protected /* synthetic */ float jumpPower;
    protected /* synthetic */ boolean field_190688_bE;
    private /* synthetic */ boolean allowStandSliding;
    public /* synthetic */ int tailCounter;
    
    public boolean func_190677_dK() {
        return false;
    }
    
    public void setEatingHaystack(final boolean llllllllllllllllIIIllIlIIlIIIlII) {
        this.setHorseWatchableBoolean(16, llllllllllllllllIIIllIlIIlIIIlII);
    }
    
    public int func_190676_dC() {
        return 100;
    }
    
    public float getRearingAmount(final float llllllllllllllllIIIllIIlllIIlllI) {
        return this.prevRearingAmount + (this.rearingAmount - this.prevRearingAmount) * llllllllllllllllIIIllIIlllIIlllI;
    }
    
    public AbstractHorse(final World llllllllllllllllIIIllIlllIIIIlll) {
        super(llllllllllllllllIIIllIlllIIIIlll);
        this.field_190688_bE = true;
        this.setSize(1.3964844f, 1.6f);
        this.stepHeight = 1.0f;
        this.initHorseChest();
    }
    
    @Override
    public boolean canBePushed() {
        return !this.isBeingRidden();
    }
    
    public void setOwnerUniqueId(@Nullable final UUID llllllllllllllllIIIllIllIllIIIll) {
        this.dataManager.set(AbstractHorse.OWNER_UNIQUE_ID, (Optional<UUID>)Optional.fromNullable((Object)llllllllllllllllIIIllIllIllIIIll));
    }
    
    protected boolean func_190678_b(final EntityPlayer llllllllllllllllIIIllIlIlIIIIIlI, final ItemStack llllllllllllllllIIIllIlIlIIIIIIl) {
        boolean llllllllllllllllIIIllIlIlIIIIIII = false;
        float llllllllllllllllIIIllIlIIlllllll = 0.0f;
        int llllllllllllllllIIIllIlIIllllllI = 0;
        int llllllllllllllllIIIllIlIIlllllIl = 0;
        final Item llllllllllllllllIIIllIlIIlllllII = llllllllllllllllIIIllIlIlIIIIIIl.getItem();
        if (llllllllllllllllIIIllIlIIlllllII == Items.WHEAT) {
            llllllllllllllllIIIllIlIIlllllll = 2.0f;
            llllllllllllllllIIIllIlIIllllllI = 20;
            llllllllllllllllIIIllIlIIlllllIl = 3;
        }
        else if (llllllllllllllllIIIllIlIIlllllII == Items.SUGAR) {
            llllllllllllllllIIIllIlIIlllllll = 1.0f;
            llllllllllllllllIIIllIlIIllllllI = 30;
            llllllllllllllllIIIllIlIIlllllIl = 3;
        }
        else if (llllllllllllllllIIIllIlIIlllllII == Item.getItemFromBlock(Blocks.HAY_BLOCK)) {
            llllllllllllllllIIIllIlIIlllllll = 20.0f;
            llllllllllllllllIIIllIlIIllllllI = 180;
        }
        else if (llllllllllllllllIIIllIlIIlllllII == Items.APPLE) {
            llllllllllllllllIIIllIlIIlllllll = 3.0f;
            llllllllllllllllIIIllIlIIllllllI = 60;
            llllllllllllllllIIIllIlIIlllllIl = 3;
        }
        else if (llllllllllllllllIIIllIlIIlllllII == Items.GOLDEN_CARROT) {
            llllllllllllllllIIIllIlIIlllllll = 4.0f;
            llllllllllllllllIIIllIlIIllllllI = 60;
            llllllllllllllllIIIllIlIIlllllIl = 5;
            if (this.isTame() && this.getGrowingAge() == 0 && !this.isInLove()) {
                llllllllllllllllIIIllIlIlIIIIIII = true;
                this.setInLove(llllllllllllllllIIIllIlIlIIIIIlI);
            }
        }
        else if (llllllllllllllllIIIllIlIIlllllII == Items.GOLDEN_APPLE) {
            llllllllllllllllIIIllIlIIlllllll = 10.0f;
            llllllllllllllllIIIllIlIIllllllI = 240;
            llllllllllllllllIIIllIlIIlllllIl = 10;
            if (this.isTame() && this.getGrowingAge() == 0 && !this.isInLove()) {
                llllllllllllllllIIIllIlIlIIIIIII = true;
                this.setInLove(llllllllllllllllIIIllIlIlIIIIIlI);
            }
        }
        if (this.getHealth() < this.getMaxHealth() && llllllllllllllllIIIllIlIIlllllll > 0.0f) {
            this.heal(llllllllllllllllIIIllIlIIlllllll);
            llllllllllllllllIIIllIlIlIIIIIII = true;
        }
        if (this.isChild() && llllllllllllllllIIIllIlIIllllllI > 0) {
            this.world.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, this.posX + this.rand.nextFloat() * this.width * 2.0f - this.width, this.posY + 0.5 + this.rand.nextFloat() * this.height, this.posZ + this.rand.nextFloat() * this.width * 2.0f - this.width, 0.0, 0.0, 0.0, new int[0]);
            if (!this.world.isRemote) {
                this.addGrowth(llllllllllllllllIIIllIlIIllllllI);
            }
            llllllllllllllllIIIllIlIlIIIIIII = true;
        }
        if (llllllllllllllllIIIllIlIIlllllIl > 0 && (llllllllllllllllIIIllIlIlIIIIIII || !this.isTame()) && this.getTemper() < this.func_190676_dC()) {
            llllllllllllllllIIIllIlIlIIIIIII = true;
            if (!this.world.isRemote) {
                this.increaseTemper(llllllllllllllllIIIllIlIIlllllIl);
            }
        }
        if (llllllllllllllllIIIllIlIlIIIIIII) {
            this.eatingHorse();
        }
        return llllllllllllllllIIIllIlIlIIIIIII;
    }
    
    @Override
    protected void playStepSound(final BlockPos llllllllllllllllIIIllIlIlIlIIIIl, final Block llllllllllllllllIIIllIlIlIlIIlII) {
        if (!llllllllllllllllIIIllIlIlIlIIlII.getDefaultState().getMaterial().isLiquid()) {
            SoundType llllllllllllllllIIIllIlIlIlIIIll = llllllllllllllllIIIllIlIlIlIIlII.getSoundType();
            if (this.world.getBlockState(llllllllllllllllIIIllIlIlIlIIIIl.up()).getBlock() == Blocks.SNOW_LAYER) {
                llllllllllllllllIIIllIlIlIlIIIll = Blocks.SNOW_LAYER.getSoundType();
            }
            if (this.isBeingRidden() && this.field_190688_bE) {
                ++this.gallopTime;
                if (this.gallopTime > 5 && this.gallopTime % 3 == 0) {
                    this.func_190680_a(llllllllllllllllIIIllIlIlIlIIIll);
                }
                else if (this.gallopTime <= 5) {
                    this.playSound(SoundEvents.ENTITY_HORSE_STEP_WOOD, llllllllllllllllIIIllIlIlIlIIIll.getVolume() * 0.15f, llllllllllllllllIIIllIlIlIlIIIll.getPitch());
                }
            }
            else if (llllllllllllllllIIIllIlIlIlIIIll == SoundType.WOOD) {
                this.playSound(SoundEvents.ENTITY_HORSE_STEP_WOOD, llllllllllllllllIIIllIlIlIlIIIll.getVolume() * 0.15f, llllllllllllllllIIIllIlIlIlIIIll.getPitch());
            }
            else {
                this.playSound(SoundEvents.ENTITY_HORSE_STEP, llllllllllllllllIIIllIlIlIlIIIll.getVolume() * 0.15f, llllllllllllllllIIIllIlIlIlIIIll.getPitch());
            }
        }
    }
    
    public boolean func_190684_dE() {
        return true;
    }
    
    protected float getModifiedMaxHealth() {
        return 15.0f + this.rand.nextInt(8) + this.rand.nextInt(9);
    }
    
    public boolean isTame() {
        return this.getHorseWatchableBoolean(2);
    }
    
    @Override
    public boolean replaceItemInInventory(final int llllllllllllllllIIIllIIlIlllIlIl, final ItemStack llllllllllllllllIIIllIIlIlllIlII) {
        final int llllllllllllllllIIIllIIlIlllIIll = llllllllllllllllIIIllIIlIlllIlIl - 400;
        if (llllllllllllllllIIIllIIlIlllIIll >= 0 && llllllllllllllllIIIllIIlIlllIIll < 2 && llllllllllllllllIIIllIIlIlllIIll < this.horseChest.getSizeInventory()) {
            if (llllllllllllllllIIIllIIlIlllIIll == 0 && llllllllllllllllIIIllIIlIlllIlII.getItem() != Items.SADDLE) {
                return false;
            }
            if (llllllllllllllllIIIllIIlIlllIIll != 1 || (this.func_190677_dK() && this.func_190682_f(llllllllllllllllIIIllIIlIlllIlII))) {
                this.horseChest.setInventorySlotContents(llllllllllllllllIIIllIIlIlllIIll, llllllllllllllllIIIllIIlIlllIlII);
                this.updateHorseSlots();
                return true;
            }
            return false;
        }
        else {
            final int llllllllllllllllIIIllIIlIlllIIlI = llllllllllllllllIIIllIIlIlllIlIl - 500 + 2;
            if (llllllllllllllllIIIllIIlIlllIIlI >= 2 && llllllllllllllllIIIllIIlIlllIIlI < this.horseChest.getSizeInventory()) {
                this.horseChest.setInventorySlotContents(llllllllllllllllIIIllIIlIlllIIlI, llllllllllllllllIIIllIIlIlllIlII);
                return true;
            }
            return false;
        }
    }
    
    protected boolean getHorseWatchableBoolean(final int llllllllllllllllIIIllIllIllllIIl) {
        return (this.dataManager.get(AbstractHorse.STATUS) & llllllllllllllllIIIllIllIllllIIl) != 0x0;
    }
    
    public boolean isHorseJumping() {
        return this.horseJumping;
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource llllllllllllllllIIIllIllIIIlIIlI, final float llllllllllllllllIIIllIllIIIlIIIl) {
        final Entity llllllllllllllllIIIllIllIIIlIIII = llllllllllllllllIIIllIllIIIlIIlI.getEntity();
        return (!this.isBeingRidden() || llllllllllllllllIIIllIllIIIlIIII == null || !this.isRidingOrBeingRiddenBy(llllllllllllllllIIIllIllIIIlIIII)) && super.attackEntityFrom(llllllllllllllllIIIllIllIIIlIIlI, llllllllllllllllIIIllIllIIIlIIIl);
    }
    
    protected void mountTo(final EntityPlayer llllllllllllllllIIIllIlIIllIlllI) {
        llllllllllllllllIIIllIlIIllIlllI.rotationYaw = this.rotationYaw;
        llllllllllllllllIIIllIlIIllIlllI.rotationPitch = this.rotationPitch;
        this.setEatingHaystack(false);
        this.setRearing(false);
        if (!this.world.isRemote) {
            llllllllllllllllIIIllIlIIllIlllI.startRiding(this);
        }
    }
    
    public void setRearing(final boolean llllllllllllllllIIIllIlIIlIIIIII) {
        if (llllllllllllllllIIIllIlIIlIIIIII) {
            this.setEatingHaystack(false);
        }
        this.setHorseWatchableBoolean(32, llllllllllllllllIIIllIlIIlIIIIII);
    }
    
    @Override
    public void func_191986_a(float llllllllllllllllIIIllIlIIIIllIlI, final float llllllllllllllllIIIllIlIIIlIIIll, float llllllllllllllllIIIllIlIIIIllIII) {
        if (this.isBeingRidden() && this.canBeSteered() && this.isHorseSaddled()) {
            final EntityLivingBase llllllllllllllllIIIllIlIIIlIIIIl = (EntityLivingBase)this.getControllingPassenger();
            this.rotationYaw = llllllllllllllllIIIllIlIIIlIIIIl.rotationYaw;
            this.prevRotationYaw = this.rotationYaw;
            this.rotationPitch = llllllllllllllllIIIllIlIIIlIIIIl.rotationPitch * 0.5f;
            this.setRotation(this.rotationYaw, this.rotationPitch);
            this.renderYawOffset = this.rotationYaw;
            this.rotationYawHead = this.renderYawOffset;
            llllllllllllllllIIIllIlIIIIllIlI = (long)(llllllllllllllllIIIllIlIIIlIIIIl.moveStrafing * 0.5f);
            llllllllllllllllIIIllIlIIIIllIII = llllllllllllllllIIIllIlIIIlIIIIl.field_191988_bg;
            if (llllllllllllllllIIIllIlIIIIllIII <= 0.0f) {
                llllllllllllllllIIIllIlIIIIllIII *= 0.25f;
                this.gallopTime = 0;
            }
            if (this.onGround && this.jumpPower == 0.0f && this.isRearing() && !this.allowStandSliding) {
                llllllllllllllllIIIllIlIIIIllIlI = (long)0.0f;
                llllllllllllllllIIIllIlIIIIllIII = 0.0f;
            }
            if (this.jumpPower > 0.0f && !this.isHorseJumping() && this.onGround) {
                this.motionY = this.getHorseJumpStrength() * this.jumpPower;
                if (this.isPotionActive(MobEffects.JUMP_BOOST)) {
                    this.motionY += (this.getActivePotionEffect(MobEffects.JUMP_BOOST).getAmplifier() + 1) * 0.1f;
                }
                this.setHorseJumping(true);
                this.isAirBorne = true;
                if (llllllllllllllllIIIllIlIIIIllIII > 0.0f) {
                    final float llllllllllllllllIIIllIlIIIlIIIII = MathHelper.sin(this.rotationYaw * 0.017453292f);
                    final float llllllllllllllllIIIllIlIIIIlllll = MathHelper.cos(this.rotationYaw * 0.017453292f);
                    this.motionX += -0.4f * llllllllllllllllIIIllIlIIIlIIIII * this.jumpPower;
                    this.motionZ += 0.4f * llllllllllllllllIIIllIlIIIIlllll * this.jumpPower;
                    this.playSound(SoundEvents.ENTITY_HORSE_JUMP, 0.4f, 1.0f);
                }
                this.jumpPower = 0.0f;
            }
            this.jumpMovementFactor = this.getAIMoveSpeed() * 0.1f;
            if (this.canPassengerSteer()) {
                this.setAIMoveSpeed((float)this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue());
                super.func_191986_a((float)llllllllllllllllIIIllIlIIIIllIlI, llllllllllllllllIIIllIlIIIlIIIll, llllllllllllllllIIIllIlIIIIllIII);
            }
            else if (llllllllllllllllIIIllIlIIIlIIIIl instanceof EntityPlayer) {
                this.motionX = 0.0;
                this.motionY = 0.0;
                this.motionZ = 0.0;
            }
            if (this.onGround) {
                this.jumpPower = 0.0f;
                this.setHorseJumping(false);
            }
            this.prevLimbSwingAmount = this.limbSwingAmount;
            final double llllllllllllllllIIIllIlIIIIllllI = this.posX - this.prevPosX;
            final double llllllllllllllllIIIllIlIIIIlllIl = this.posZ - this.prevPosZ;
            float llllllllllllllllIIIllIlIIIIlllII = MathHelper.sqrt(llllllllllllllllIIIllIlIIIIllllI * llllllllllllllllIIIllIlIIIIllllI + llllllllllllllllIIIllIlIIIIlllIl * llllllllllllllllIIIllIlIIIIlllIl) * 4.0f;
            if (llllllllllllllllIIIllIlIIIIlllII > 1.0f) {
                llllllllllllllllIIIllIlIIIIlllII = 1.0f;
            }
            this.limbSwingAmount += (llllllllllllllllIIIllIlIIIIlllII - this.limbSwingAmount) * 0.4f;
            this.limbSwing += this.limbSwingAmount;
        }
        else {
            this.jumpMovementFactor = 0.02f;
            super.func_191986_a((float)llllllllllllllllIIIllIlIIIIllIlI, llllllllllllllllIIIllIlIIIlIIIll, llllllllllllllllIIIllIlIIIIllIII);
        }
    }
    
    public boolean isEatingHaystack() {
        return this.getHorseWatchableBoolean(16);
    }
    
    public int getTemper() {
        return this.temper;
    }
    
    @Override
    public void handleStartJump(final int llllllllllllllllIIIllIIllIllllII) {
        this.allowStandSliding = true;
        this.makeHorseRear();
    }
    
    public void openGUI(final EntityPlayer llllllllllllllllIIIllIlIlIIIlllI) {
        if (!this.world.isRemote && (!this.isBeingRidden() || this.isPassenger(llllllllllllllllIIIllIlIlIIIlllI)) && this.isTame()) {
            this.horseChest.setCustomName(this.getName());
            llllllllllllllllIIIllIlIlIIIlllI.openGuiHorseInventory(this, this.horseChest);
        }
    }
    
    private void openHorseMouth() {
        if (!this.world.isRemote) {
            this.openMouthCounter = 1;
            this.setHorseWatchableBoolean(64, true);
        }
    }
    
    public float getHorseSize() {
        return 0.5f;
    }
    
    public float getMouthOpennessAngle(final float llllllllllllllllIIIllIIlllIIlIII) {
        return this.prevMouthOpenness + (this.mouthOpenness - this.prevMouthOpenness) * llllllllllllllllIIIllIIlllIIlIII;
    }
    
    public void setBreeding(final boolean llllllllllllllllIIIllIllIIllIIII) {
        this.setHorseWatchableBoolean(8, llllllllllllllllIIIllIllIIllIIII);
    }
    
    public int increaseTemper(final int llllllllllllllllIIIllIllIIIlllII) {
        final int llllllllllllllllIIIllIllIIIllIll = MathHelper.clamp(this.getTemper() + llllllllllllllllIIIllIllIIIlllII, 0, this.func_190676_dC());
        this.setTemper(llllllllllllllllIIIllIllIIIllIll);
        return llllllllllllllllIIIllIllIIIllIll;
    }
    
    @Override
    protected boolean isMovementBlocked() {
        return (super.isMovementBlocked() && this.isBeingRidden() && this.isHorseSaddled()) || this.isEatingHaystack() || this.isRearing();
    }
    
    public boolean func_190685_dA() {
        return true;
    }
    
    protected void func_190679_dD() {
        if (this.isBreeding() && this.isChild() && !this.isEatingHaystack()) {
            final AbstractHorse llllllllllllllllIIIllIlIIlIlIIll = this.getClosestHorse(this, 16.0);
            if (llllllllllllllllIIIllIlIIlIlIIll != null && this.getDistanceSqToEntity(llllllllllllllllIIIllIlIIlIlIIll) > 4.0) {
                this.navigator.getPathToEntityLiving(llllllllllllllllIIIllIlIIlIlIIll);
            }
        }
    }
    
    public float getGrassEatingAmount(final float llllllllllllllllIIIllIIlllIlIlII) {
        return this.prevHeadLean + (this.headLean - this.prevHeadLean) * llllllllllllllllIIIllIIlllIlIlII;
    }
    
    public boolean isRearing() {
        return this.getHorseWatchableBoolean(32);
    }
    
    @Override
    public boolean canBeLeashedTo(final EntityPlayer llllllllllllllllIIIllIllIlIIIlll) {
        return super.canBeLeashedTo(llllllllllllllllIIIllIllIlIIIlll) && this.getCreatureAttribute() != EnumCreatureAttribute.UNDEAD;
    }
    
    @Nullable
    @Override
    protected SoundEvent getHurtSound(final DamageSource llllllllllllllllIIIllIlIlIllIllI) {
        this.openHorseMouth();
        if (this.rand.nextInt(3) == 0) {
            this.makeHorseRear();
        }
        return null;
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(AbstractHorse.STATUS, (Byte)0);
        this.dataManager.register(AbstractHorse.OWNER_UNIQUE_ID, (Optional<UUID>)Optional.absent());
    }
    
    @Override
    public boolean canBeSteered() {
        return this.getControllingPassenger() instanceof EntityLivingBase;
    }
    
    public void setTemper(final int llllllllllllllllIIIllIllIIlIIIIl) {
        this.temper = llllllllllllllllIIIllIllIIlIIIIl;
    }
    
    public boolean setTamedBy(final EntityPlayer llllllllllllllllIIIllIlIIIllIIIl) {
        this.setOwnerUniqueId(llllllllllllllllIIIllIlIIIllIIIl.getUniqueID());
        this.setHorseTamed(true);
        if (llllllllllllllllIIIllIlIIIllIIIl instanceof EntityPlayerMP) {
            CriteriaTriggers.field_193136_w.func_193178_a((EntityPlayerMP)llllllllllllllllIIIllIlIIIllIIIl, this);
        }
        this.world.setEntityState(this, (byte)7);
        return true;
    }
    
    public void func_190687_dF() {
        this.makeHorseRear();
        final SoundEvent llllllllllllllllIIIllIlIIIllIlll = this.getAngrySound();
        if (llllllllllllllllIIIllIlIIIllIlll != null) {
            this.playSound(llllllllllllllllIIIllIlIIIllIlll, this.getSoundVolume(), this.getSoundPitch());
        }
    }
    
    protected void updateHorseSlots() {
        if (!this.world.isRemote) {
            this.setHorseSaddled(!this.horseChest.getStackInSlot(0).func_190926_b() && this.func_190685_dA());
        }
    }
    
    @Override
    protected float getSoundVolume() {
        return 0.8f;
    }
    
    public void setHorseSaddled(final boolean llllllllllllllllIIIllIllIIlIlIlI) {
        this.setHorseWatchableBoolean(4, llllllllllllllllIIIllIllIIlIlIlI);
    }
    
    public void setHorseTamed(final boolean llllllllllllllllIIIllIllIlIlIIIl) {
        this.setHorseWatchableBoolean(2, llllllllllllllllIIIllIllIlIlIIIl);
    }
    
    @Override
    public float getEyeHeight() {
        return this.height;
    }
    
    public boolean isHorseSaddled() {
        return this.getHorseWatchableBoolean(4);
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound llllllllllllllllIIIllIlIIIIIlIIl) {
        super.writeEntityToNBT(llllllllllllllllIIIllIlIIIIIlIIl);
        llllllllllllllllIIIllIlIIIIIlIIl.setBoolean("EatingHaystack", this.isEatingHaystack());
        llllllllllllllllIIIllIlIIIIIlIIl.setBoolean("Bred", this.isBreeding());
        llllllllllllllllIIIllIlIIIIIlIIl.setInteger("Temper", this.getTemper());
        llllllllllllllllIIIllIlIIIIIlIIl.setBoolean("Tame", this.isTame());
        if (this.getOwnerUniqueId() != null) {
            llllllllllllllllIIIllIlIIIIIlIIl.setString("OwnerUUID", this.getOwnerUniqueId().toString());
        }
        if (!this.horseChest.getStackInSlot(0).func_190926_b()) {
            llllllllllllllllIIIllIlIIIIIlIIl.setTag("SaddleItem", this.horseChest.getStackInSlot(0).writeToNBT(new NBTTagCompound()));
        }
    }
    
    public boolean func_190682_f(final ItemStack llllllllllllllllIIIllIIlIlllllII) {
        return false;
    }
    
    protected void setHorseWatchableBoolean(final int llllllllllllllllIIIllIllIlllIIll, final boolean llllllllllllllllIIIllIllIllIlllI) {
        final byte llllllllllllllllIIIllIllIlllIIIl = this.dataManager.get(AbstractHorse.STATUS);
        if (llllllllllllllllIIIllIllIllIlllI) {
            this.dataManager.set(AbstractHorse.STATUS, (byte)(llllllllllllllllIIIllIllIlllIIIl | llllllllllllllllIIIllIllIlllIIll));
        }
        else {
            this.dataManager.set(AbstractHorse.STATUS, (byte)(llllllllllllllllIIIllIllIlllIIIl & ~llllllllllllllllIIIllIllIlllIIll));
        }
    }
    
    @Override
    public boolean canMateWith(final EntityAnimal llllllllllllllllIIIllIIlllllIlII) {
        return false;
    }
    
    @Override
    public void onInventoryChanged(final IInventory llllllllllllllllIIIllIlIllIllIIl) {
        final boolean llllllllllllllllIIIllIlIllIllIII = this.isHorseSaddled();
        this.updateHorseSlots();
        if (this.ticksExisted > 20 && !llllllllllllllllIIIllIlIllIllIII && this.isHorseSaddled()) {
            this.playSound(SoundEvents.ENTITY_HORSE_SADDLE, 0.5f, 1.0f);
        }
    }
    
    @Nullable
    @Override
    public Entity getControllingPassenger() {
        return this.getPassengers().isEmpty() ? null : this.getPassengers().get(0);
    }
    
    @Override
    public boolean isBreedingItem(final ItemStack llllllllllllllllIIIllIlIIllIlIIl) {
        return false;
    }
    
    static {
        IS_HORSE_BREEDING = (Predicate)new Predicate<Entity>() {
            public boolean apply(@Nullable final Entity lllllllllllllllIIlIllIlIllllllIl) {
                return lllllllllllllllIIlIllIlIllllllIl instanceof AbstractHorse && ((AbstractHorse)lllllllllllllllIIlIllIlIllllllIl).isBreeding();
            }
        };
        JUMP_STRENGTH = new RangedAttribute(null, "horse.jumpStrength", 0.7, 0.0, 2.0).setDescription("Jump Strength").setShouldWatch(true);
        STATUS = EntityDataManager.createKey(AbstractHorse.class, DataSerializers.BYTE);
        OWNER_UNIQUE_ID = EntityDataManager.createKey(AbstractHorse.class, DataSerializers.OPTIONAL_UNIQUE_ID);
    }
    
    protected void func_190680_a(final SoundType llllllllllllllllIIIllIlIlIIllIIl) {
        this.playSound(SoundEvents.ENTITY_HORSE_GALLOP, llllllllllllllllIIIllIlIlIIllIIl.getVolume() * 0.15f, llllllllllllllllIIIllIlIlIIllIIl.getPitch());
    }
    
    public boolean isBreeding() {
        return this.getHorseWatchableBoolean(8);
    }
    
    protected void spawnHorseParticles(final boolean llllllllllllllllIIIllIIllIllIIIl) {
        final EnumParticleTypes llllllllllllllllIIIllIIllIllIIII = llllllllllllllllIIIllIIllIllIIIl ? EnumParticleTypes.HEART : EnumParticleTypes.SMOKE_NORMAL;
        for (int llllllllllllllllIIIllIIllIlIllll = 0; llllllllllllllllIIIllIIllIlIllll < 7; ++llllllllllllllllIIIllIIllIlIllll) {
            final double llllllllllllllllIIIllIIllIlIlllI = this.rand.nextGaussian() * 0.02;
            final double llllllllllllllllIIIllIIllIlIllIl = this.rand.nextGaussian() * 0.02;
            final double llllllllllllllllIIIllIIllIlIllII = this.rand.nextGaussian() * 0.02;
            this.world.spawnParticle(llllllllllllllllIIIllIIllIllIIII, this.posX + this.rand.nextFloat() * this.width * 2.0f - this.width, this.posY + 0.5 + this.rand.nextFloat() * this.height, this.posZ + this.rand.nextFloat() * this.width * 2.0f - this.width, llllllllllllllllIIIllIIllIlIlllI, llllllllllllllllIIIllIIllIlIllIl, llllllllllllllllIIIllIIllIlIllII, new int[0]);
        }
    }
    
    @Override
    public int getMaxSpawnedInChunk() {
        return 6;
    }
    
    protected boolean canMate() {
        return !this.isBeingRidden() && !this.isRiding() && this.isTame() && !this.isChild() && this.getHealth() >= this.getMaxHealth() && this.isInLove();
    }
    
    protected double getModifiedJumpStrength() {
        return 0.4000000059604645 + this.rand.nextDouble() * 0.2 + this.rand.nextDouble() * 0.2 + this.rand.nextDouble() * 0.2;
    }
    
    @Override
    protected void initEntityAI() {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 1.2));
        this.tasks.addTask(1, new EntityAIRunAroundLikeCrazy(this, 1.2));
        this.tasks.addTask(2, new EntityAIMate(this, 1.0, AbstractHorse.class));
        this.tasks.addTask(4, new EntityAIFollowParent(this, 1.0));
        this.tasks.addTask(6, new EntityAIWanderAvoidWater(this, 0.7));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0f));
        this.tasks.addTask(8, new EntityAILookIdle(this));
    }
    
    private void eatingHorse() {
        this.openHorseMouth();
        if (!this.isSilent()) {
            this.world.playSound(null, this.posX, this.posY, this.posZ, SoundEvents.ENTITY_HORSE_EAT, this.getSoundCategory(), 1.0f, 1.0f + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f);
        }
    }
    
    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        this.openHorseMouth();
        return null;
    }
    
    @Nullable
    public UUID getOwnerUniqueId() {
        return (UUID)this.dataManager.get(AbstractHorse.OWNER_UNIQUE_ID).orNull();
    }
    
    @Nullable
    @Override
    public EntityAgeable createChild(final EntityAgeable llllllllllllllllIIIllIIllllIllll) {
        return null;
    }
    
    protected void func_190681_a(final EntityAgeable llllllllllllllllIIIllIIllllIIlll, final AbstractHorse llllllllllllllllIIIllIIllllIIIII) {
        final double llllllllllllllllIIIllIIllllIIlIl = this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).getBaseValue() + llllllllllllllllIIIllIIllllIIlll.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).getBaseValue() + this.getModifiedMaxHealth();
        llllllllllllllllIIIllIIllllIIIII.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(llllllllllllllllIIIllIIllllIIlIl / 3.0);
        final double llllllllllllllllIIIllIIllllIIlII = this.getEntityAttribute(AbstractHorse.JUMP_STRENGTH).getBaseValue() + llllllllllllllllIIIllIIllllIIlll.getEntityAttribute(AbstractHorse.JUMP_STRENGTH).getBaseValue() + this.getModifiedJumpStrength();
        llllllllllllllllIIIllIIllllIIIII.getEntityAttribute(AbstractHorse.JUMP_STRENGTH).setBaseValue(llllllllllllllllIIIllIIllllIIlII / 3.0);
        final double llllllllllllllllIIIllIIllllIIIll = this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getBaseValue() + llllllllllllllllIIIllIIllllIIlll.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getBaseValue() + this.getModifiedMovementSpeed();
        llllllllllllllllIIIllIIllllIIIII.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(llllllllllllllllIIIllIIllllIIIll / 3.0);
    }
    
    private void makeHorseRear() {
        if (this.canPassengerSteer()) {
            this.jumpRearingCounter = 1;
            this.setRearing(true);
        }
    }
    
    @Override
    public void handleStopJump() {
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getAttributeMap().registerAttribute(AbstractHorse.JUMP_STRENGTH);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(53.0);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.22499999403953552);
    }
    
    protected void initHorseChest() {
        final ContainerHorseChest llllllllllllllllIIIllIlIlllIlIII = this.horseChest;
        this.horseChest = new ContainerHorseChest("HorseChest", this.func_190686_di());
        this.horseChest.setCustomName(this.getName());
        if (llllllllllllllllIIIllIlIlllIlIII != null) {
            llllllllllllllllIIIllIlIlllIlIII.removeInventoryChangeListener(this);
            for (int llllllllllllllllIIIllIlIlllIIlll = Math.min(llllllllllllllllIIIllIlIlllIlIII.getSizeInventory(), this.horseChest.getSizeInventory()), llllllllllllllllIIIllIlIlllIIllI = 0; llllllllllllllllIIIllIlIlllIIllI < llllllllllllllllIIIllIlIlllIIlll; ++llllllllllllllllIIIllIlIlllIIllI) {
                final ItemStack llllllllllllllllIIIllIlIlllIIlIl = llllllllllllllllIIIllIlIlllIlIII.getStackInSlot(llllllllllllllllIIIllIlIlllIIllI);
                if (!llllllllllllllllIIIllIlIlllIIlIl.func_190926_b()) {
                    this.horseChest.setInventorySlotContents(llllllllllllllllIIIllIlIlllIIllI, llllllllllllllllIIIllIlIlllIIlIl.copy());
                }
            }
        }
        this.horseChest.addInventoryChangeListener(this);
        this.updateHorseSlots();
    }
    
    @Override
    public void onLivingUpdate() {
        if (this.rand.nextInt(200) == 0) {
            this.moveTail();
        }
        super.onLivingUpdate();
        if (!this.world.isRemote) {
            if (this.rand.nextInt(900) == 0 && this.deathTime == 0) {
                this.heal(1.0f);
            }
            if (this.func_190684_dE()) {
                if (!this.isEatingHaystack() && !this.isBeingRidden() && this.rand.nextInt(300) == 0 && this.world.getBlockState(new BlockPos(MathHelper.floor(this.posX), MathHelper.floor(this.posY) - 1, MathHelper.floor(this.posZ))).getBlock() == Blocks.GRASS) {
                    this.setEatingHaystack(true);
                }
                if (this.isEatingHaystack() && ++this.field_190689_bJ > 50) {
                    this.field_190689_bJ = 0;
                    this.setEatingHaystack(false);
                }
            }
            this.func_190679_dD();
        }
    }
    
    @Override
    protected void onLeashDistance(final float llllllllllllllllIIIllIllIlIIIIIl) {
        if (llllllllllllllllIIIllIllIlIIIIIl > 6.0f && this.isEatingHaystack()) {
            this.setEatingHaystack(false);
        }
    }
    
    protected double getModifiedMovementSpeed() {
        return (0.44999998807907104 + this.rand.nextDouble() * 0.3 + this.rand.nextDouble() * 0.3 + this.rand.nextDouble() * 0.3) * 0.25;
    }
    
    public double getHorseJumpStrength() {
        return this.getEntityAttribute(AbstractHorse.JUMP_STRENGTH).getAttributeValue();
    }
    
    private void moveTail() {
        this.tailCounter = 1;
    }
    
    @Nullable
    protected SoundEvent getAngrySound() {
        this.openHorseMouth();
        this.makeHorseRear();
        return null;
    }
    
    @Override
    public int getTalkInterval() {
        return 400;
    }
    
    @Nullable
    protected AbstractHorse getClosestHorse(final Entity llllllllllllllllIIIllIlIllIIllII, final double llllllllllllllllIIIllIlIllIIIlII) {
        double llllllllllllllllIIIllIlIllIIlIlI = Double.MAX_VALUE;
        Entity llllllllllllllllIIIllIlIllIIlIIl = null;
        for (final Entity llllllllllllllllIIIllIlIllIIlIII : this.world.getEntitiesInAABBexcluding(llllllllllllllllIIIllIlIllIIllII, llllllllllllllllIIIllIlIllIIllII.getEntityBoundingBox().addCoord(llllllllllllllllIIIllIlIllIIIlII, llllllllllllllllIIIllIlIllIIIlII, llllllllllllllllIIIllIlIllIIIlII), AbstractHorse.IS_HORSE_BREEDING)) {
            final double llllllllllllllllIIIllIlIllIIIlll = llllllllllllllllIIIllIlIllIIlIII.getDistanceSq(llllllllllllllllIIIllIlIllIIllII.posX, llllllllllllllllIIIllIlIllIIllII.posY, llllllllllllllllIIIllIlIllIIllII.posZ);
            if (llllllllllllllllIIIllIlIllIIIlll < llllllllllllllllIIIllIlIllIIlIlI) {
                llllllllllllllllIIIllIlIllIIlIIl = llllllllllllllllIIIllIlIllIIlIII;
                llllllllllllllllIIIllIlIllIIlIlI = llllllllllllllllIIIllIlIllIIIlll;
            }
        }
        return (AbstractHorse)llllllllllllllllIIIllIlIllIIlIIl;
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound llllllllllllllllIIIllIIllllllIIl) {
        super.readEntityFromNBT(llllllllllllllllIIIllIIllllllIIl);
        this.setEatingHaystack(llllllllllllllllIIIllIIllllllIIl.getBoolean("EatingHaystack"));
        this.setBreeding(llllllllllllllllIIIllIIllllllIIl.getBoolean("Bred"));
        this.setTemper(llllllllllllllllIIIllIIllllllIIl.getInteger("Temper"));
        this.setHorseTamed(llllllllllllllllIIIllIIllllllIIl.getBoolean("Tame"));
        String llllllllllllllllIIIllIIllllllllI = null;
        if (llllllllllllllllIIIllIIllllllIIl.hasKey("OwnerUUID", 8)) {
            final String llllllllllllllllIIIllIIlllllllll = llllllllllllllllIIIllIIllllllIIl.getString("OwnerUUID");
        }
        else {
            final String llllllllllllllllIIIllIIlllllllIl = llllllllllllllllIIIllIIllllllIIl.getString("Owner");
            llllllllllllllllIIIllIIllllllllI = PreYggdrasilConverter.convertMobOwnerIfNeeded(this.getServer(), llllllllllllllllIIIllIIlllllllIl);
        }
        if (!llllllllllllllllIIIllIIllllllllI.isEmpty()) {
            this.setOwnerUniqueId(UUID.fromString(llllllllllllllllIIIllIIllllllllI));
        }
        final IAttributeInstance llllllllllllllllIIIllIIlllllllII = this.getAttributeMap().getAttributeInstanceByName("Speed");
        if (llllllllllllllllIIIllIIlllllllII != null) {
            this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(llllllllllllllllIIIllIIlllllllII.getBaseValue() * 0.25);
        }
        if (llllllllllllllllIIIllIIllllllIIl.hasKey("SaddleItem", 10)) {
            final ItemStack llllllllllllllllIIIllIIllllllIll = new ItemStack(llllllllllllllllIIIllIIllllllIIl.getCompoundTag("SaddleItem"));
            if (llllllllllllllllIIIllIIllllllIll.getItem() == Items.SADDLE) {
                this.horseChest.setInventorySlotContents(0, llllllllllllllllIIIllIIllllllIll);
            }
        }
        this.updateHorseSlots();
    }
    
    @Override
    public void onDeath(final DamageSource llllllllllllllllIIIllIlIIlIlllII) {
        super.onDeath(llllllllllllllllIIIllIlIIlIlllII);
        if (!this.world.isRemote && this.horseChest != null) {
            for (int llllllllllllllllIIIllIlIIlIlllll = 0; llllllllllllllllIIIllIlIIlIlllll < this.horseChest.getSizeInventory(); ++llllllllllllllllIIIllIlIIlIlllll) {
                final ItemStack llllllllllllllllIIIllIlIIlIllllI = this.horseChest.getStackInSlot(llllllllllllllllIIIllIlIIlIlllll);
                if (!llllllllllllllllIIIllIlIIlIllllI.func_190926_b()) {
                    this.entityDropItem(llllllllllllllllIIIllIlIIlIllllI, 0.0f);
                }
            }
        }
    }
    
    @Override
    public void setJumpPower(int llllllllllllllllIIIllIIlllIIIIlI) {
        if (this.isHorseSaddled()) {
            if (llllllllllllllllIIIllIIlllIIIIlI < 0) {
                llllllllllllllllIIIllIIlllIIIIlI = 0;
            }
            else {
                this.allowStandSliding = true;
                this.makeHorseRear();
            }
            if (llllllllllllllllIIIllIIlllIIIIlI >= 90) {
                this.jumpPower = 1.0f;
            }
            else {
                this.jumpPower = 0.4f + 0.4f * llllllllllllllllIIIllIIlllIIIIlI / 90.0f;
            }
        }
    }
    
    public static void func_190683_c(final DataFixer llllllllllllllllIIIllIlIIIIIlllI, final Class<?> llllllllllllllllIIIllIlIIIIIllIl) {
        EntityLiving.registerFixesMob(llllllllllllllllIIIllIlIIIIIlllI, llllllllllllllllIIIllIlIIIIIllIl);
        llllllllllllllllIIIllIlIIIIIlllI.registerWalker(FixTypes.ENTITY, new ItemStackData(llllllllllllllllIIIllIlIIIIIllIl, new String[] { "SaddleItem" }));
    }
    
    @Override
    public boolean isOnLadder() {
        return false;
    }
    
    @Override
    public void setScaleForAge(final boolean llllllllllllllllIIIllIllIlIllIlI) {
        this.setScale(llllllllllllllllIIIllIllIlIllIlI ? this.getHorseSize() : 1.0f);
    }
    
    @Override
    public boolean canJump() {
        return this.isHorseSaddled();
    }
    
    protected int func_190686_di() {
        return 2;
    }
    
    @Nullable
    @Override
    public IEntityLivingData onInitialSpawn(final DifficultyInstance llllllllllllllllIIIllIIlIllIIIlI, @Nullable IEntityLivingData llllllllllllllllIIIllIIlIllIIIIl) {
        llllllllllllllllIIIllIIlIllIIIIl = (long)super.onInitialSpawn(llllllllllllllllIIIllIIlIllIIIlI, (IEntityLivingData)llllllllllllllllIIIllIIlIllIIIIl);
        if (this.rand.nextInt(5) == 0) {
            this.setGrowingAge(-24000);
        }
        return (IEntityLivingData)llllllllllllllllIIIllIIlIllIIIIl;
    }
    
    @Override
    public void updatePassenger(final Entity llllllllllllllllIIIllIIllIIlIlll) {
        super.updatePassenger(llllllllllllllllIIIllIIllIIlIlll);
        if (llllllllllllllllIIIllIIllIIlIlll instanceof EntityLiving) {
            final EntityLiving llllllllllllllllIIIllIIllIIlIllI = (EntityLiving)llllllllllllllllIIIllIIllIIlIlll;
            this.renderYawOffset = llllllllllllllllIIIllIIllIIlIllI.renderYawOffset;
        }
        if (this.prevRearingAmount > 0.0f) {
            final float llllllllllllllllIIIllIIllIIlIlIl = MathHelper.sin(this.renderYawOffset * 0.017453292f);
            final float llllllllllllllllIIIllIIllIIlIlII = MathHelper.cos(this.renderYawOffset * 0.017453292f);
            final float llllllllllllllllIIIllIIllIIlIIll = 0.7f * this.prevRearingAmount;
            final float llllllllllllllllIIIllIIllIIlIIlI = 0.15f * this.prevRearingAmount;
            llllllllllllllllIIIllIIllIIlIlll.setPosition(this.posX + llllllllllllllllIIIllIIllIIlIIll * llllllllllllllllIIIllIIllIIlIlIl, this.posY + this.getMountedYOffset() + llllllllllllllllIIIllIIllIIlIlll.getYOffset() + llllllllllllllllIIIllIIllIIlIIlI, this.posZ - llllllllllllllllIIIllIIllIIlIIll * llllllllllllllllIIIllIIllIIlIlII);
            if (llllllllllllllllIIIllIIllIIlIlll instanceof EntityLivingBase) {
                ((EntityLivingBase)llllllllllllllllIIIllIIllIIlIlll).renderYawOffset = this.renderYawOffset;
            }
        }
    }
    
    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        this.openHorseMouth();
        if (this.rand.nextInt(10) == 0 && !this.isMovementBlocked()) {
            this.makeHorseRear();
        }
        return null;
    }
    
    @Override
    public void fall(final float llllllllllllllllIIIllIlIllllIlIl, final float llllllllllllllllIIIllIlIllllIlII) {
        if (llllllllllllllllIIIllIlIllllIlIl > 1.0f) {
            this.playSound(SoundEvents.ENTITY_HORSE_LAND, 0.4f, 1.0f);
        }
        final int llllllllllllllllIIIllIlIlllllIll = MathHelper.ceil((llllllllllllllllIIIllIlIllllIlIl * 0.5f - 3.0f) * llllllllllllllllIIIllIlIllllIlII);
        if (llllllllllllllllIIIllIlIlllllIll > 0) {
            this.attackEntityFrom(DamageSource.fall, (float)llllllllllllllllIIIllIlIlllllIll);
            if (this.isBeingRidden()) {
                for (final Entity llllllllllllllllIIIllIlIlllllIlI : this.getRecursivePassengers()) {
                    llllllllllllllllIIIllIlIlllllIlI.attackEntityFrom(DamageSource.fall, (float)llllllllllllllllIIIllIlIlllllIll);
                }
            }
            final IBlockState llllllllllllllllIIIllIlIlllllIIl = this.world.getBlockState(new BlockPos(this.posX, this.posY - 0.2 - this.prevRotationYaw, this.posZ));
            final Block llllllllllllllllIIIllIlIlllllIII = llllllllllllllllIIIllIlIlllllIIl.getBlock();
            if (llllllllllllllllIIIllIlIlllllIIl.getMaterial() != Material.AIR && !this.isSilent()) {
                final SoundType llllllllllllllllIIIllIlIllllIlll = llllllllllllllllIIIllIlIlllllIII.getSoundType();
                this.world.playSound(null, this.posX, this.posY, this.posZ, llllllllllllllllIIIllIlIllllIlll.getStepSound(), this.getSoundCategory(), llllllllllllllllIIIllIlIllllIlll.getVolume() * 0.5f, llllllllllllllllIIIllIlIllllIlll.getPitch() * 0.75f);
            }
        }
    }
    
    @Override
    public void handleStatusUpdate(final byte llllllllllllllllIIIllIIllIlIIIIl) {
        if (llllllllllllllllIIIllIIllIlIIIIl == 7) {
            this.spawnHorseParticles(true);
        }
        else if (llllllllllllllllIIIllIIllIlIIIIl == 6) {
            this.spawnHorseParticles(false);
        }
        else {
            super.handleStatusUpdate(llllllllllllllllIIIllIIllIlIIIIl);
        }
    }
    
    public void setHorseJumping(final boolean llllllllllllllllIIIllIllIlIIlIll) {
        this.horseJumping = llllllllllllllllIIIllIllIlIIlIll;
    }
    
    @Override
    public void onUpdate() {
        super.onUpdate();
        if (this.openMouthCounter > 0 && ++this.openMouthCounter > 30) {
            this.openMouthCounter = 0;
            this.setHorseWatchableBoolean(64, false);
        }
        if (this.canPassengerSteer() && this.jumpRearingCounter > 0 && ++this.jumpRearingCounter > 20) {
            this.jumpRearingCounter = 0;
            this.setRearing(false);
        }
        if (this.tailCounter > 0 && ++this.tailCounter > 8) {
            this.tailCounter = 0;
        }
        if (this.sprintCounter > 0) {
            ++this.sprintCounter;
            if (this.sprintCounter > 300) {
                this.sprintCounter = 0;
            }
        }
        this.prevHeadLean = this.headLean;
        if (this.isEatingHaystack()) {
            this.headLean += (1.0f - this.headLean) * 0.4f + 0.05f;
            if (this.headLean > 1.0f) {
                this.headLean = 1.0f;
            }
        }
        else {
            this.headLean += (0.0f - this.headLean) * 0.4f - 0.05f;
            if (this.headLean < 0.0f) {
                this.headLean = 0.0f;
            }
        }
        this.prevRearingAmount = this.rearingAmount;
        if (this.isRearing()) {
            this.headLean = 0.0f;
            this.prevHeadLean = this.headLean;
            this.rearingAmount += (1.0f - this.rearingAmount) * 0.4f + 0.05f;
            if (this.rearingAmount > 1.0f) {
                this.rearingAmount = 1.0f;
            }
        }
        else {
            this.allowStandSliding = false;
            this.rearingAmount += (0.8f * this.rearingAmount * this.rearingAmount * this.rearingAmount - this.rearingAmount) * 0.6f - 0.05f;
            if (this.rearingAmount < 0.0f) {
                this.rearingAmount = 0.0f;
            }
        }
        this.prevMouthOpenness = this.mouthOpenness;
        if (this.getHorseWatchableBoolean(64)) {
            this.mouthOpenness += (1.0f - this.mouthOpenness) * 0.7f + 0.05f;
            if (this.mouthOpenness > 1.0f) {
                this.mouthOpenness = 1.0f;
            }
        }
        else {
            this.mouthOpenness += (0.0f - this.mouthOpenness) * 0.7f - 0.05f;
            if (this.mouthOpenness < 0.0f) {
                this.mouthOpenness = 0.0f;
            }
        }
    }
}
