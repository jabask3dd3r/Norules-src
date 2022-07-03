package net.minecraft.entity;

import net.minecraft.inventory.*;
import net.minecraft.network.*;
import net.minecraft.entity.player.*;
import net.minecraft.advancements.*;
import javax.annotation.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.world.*;
import net.minecraft.block.state.*;
import net.minecraft.block.material.*;
import com.google.common.base.*;
import net.minecraft.network.play.server.*;
import com.google.common.collect.*;
import net.minecraft.entity.item.*;
import net.minecraft.entity.passive.*;
import net.minecraft.util.math.*;
import net.minecraft.util.*;
import net.minecraft.block.properties.*;
import org.apache.logging.log4j.*;
import net.minecraft.network.datasync.*;
import java.util.*;
import net.minecraft.item.*;
import net.minecraft.nbt.*;
import net.minecraft.init.*;
import net.minecraft.enchantment.*;
import net.minecraft.potion.*;
import net.minecraft.stats.*;
import me.nrules.*;
import me.nrules.module.player.*;
import net.minecraft.block.*;
import me.nrules.module.render.*;
import net.minecraft.entity.ai.attributes.*;

public abstract class EntityLivingBase extends Entity
{
    protected /* synthetic */ int ticksElytraFlying;
    protected /* synthetic */ double interpTargetX;
    public /* synthetic */ float jumpMovementFactor;
    private final /* synthetic */ Map<Potion, PotionEffect> activePotionsMap;
    public /* synthetic */ float moveStrafing;
    protected /* synthetic */ int scoreValue;
    public /* synthetic */ float swingProgress;
    private /* synthetic */ float landMovementFactor;
    protected /* synthetic */ double interpTargetPitch;
    protected /* synthetic */ float movedDistance;
    private /* synthetic */ AbstractAttributeMap attributeMap;
    public /* synthetic */ int maxHurtTime;
    public /* synthetic */ int maxHurtResistantTime;
    private final /* synthetic */ NonNullList<ItemStack> handInventory;
    protected /* synthetic */ int newPosRotationIncrements;
    public /* synthetic */ float limbSwingAmount;
    protected /* synthetic */ float lastDamage;
    protected /* synthetic */ int activeItemStackUseCount;
    protected /* synthetic */ double interpTargetZ;
    public /* synthetic */ boolean isSwingInProgress;
    protected /* synthetic */ boolean dead;
    public /* synthetic */ float rotationPitchHead;
    public /* synthetic */ float prevRotationYawHead;
    protected /* synthetic */ ItemStack activeItemStack;
    private static final /* synthetic */ DataParameter<Integer> ARROW_COUNT_IN_ENTITY;
    public /* synthetic */ float prevLimbSwingAmount;
    private /* synthetic */ EntityLivingBase lastAttacker;
    public /* synthetic */ float randomUnused1;
    protected /* synthetic */ int entityAge;
    private static final /* synthetic */ Logger field_190632_a;
    public /* synthetic */ EnumHand swingingHand;
    private static final /* synthetic */ AttributeModifier SPRINTING_SPEED_BOOST;
    private /* synthetic */ int revengeTimer;
    public /* synthetic */ int swingProgressInt;
    public /* synthetic */ float field_191988_bg;
    private /* synthetic */ EntityLivingBase entityLivingToAttack;
    public /* synthetic */ float renderYawOffset;
    public /* synthetic */ int arrowHitTimer;
    public /* synthetic */ float attackedAtYaw;
    public /* synthetic */ float randomYawVelocity;
    private /* synthetic */ BlockPos prevBlockpos;
    protected /* synthetic */ int recentlyHit;
    protected /* synthetic */ double interpTargetYaw;
    private final /* synthetic */ NonNullList<ItemStack> armorArray;
    public /* synthetic */ float prevRenderYawOffset;
    protected static final /* synthetic */ DataParameter<Byte> HAND_STATES;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$inventory$EntityEquipmentSlot$Type;
    protected /* synthetic */ boolean isJumping;
    public /* synthetic */ float rotationYawHead;
    private static final /* synthetic */ UUID SPRINTING_SPEED_BOOST_ID;
    public /* synthetic */ float cameraPitch;
    private /* synthetic */ boolean potionsNeedUpdate;
    public /* synthetic */ float moveForward;
    private static final /* synthetic */ DataParameter<Boolean> HIDE_PARTICLES;
    public /* synthetic */ float prevRotationPitchHead;
    private /* synthetic */ int lastAttackerTime;
    protected /* synthetic */ float onGroundSpeedFactor;
    protected /* synthetic */ float prevMovedDistance;
    public /* synthetic */ int hurtTime;
    public /* synthetic */ int jumpTicks;
    public /* synthetic */ float randomUnused2;
    private static final /* synthetic */ DataParameter<Integer> POTION_EFFECTS;
    public /* synthetic */ float prevCameraPitch;
    public /* synthetic */ float prevSwingProgress;
    private /* synthetic */ DamageSource lastDamageSource;
    private /* synthetic */ long lastDamageStamp;
    private final /* synthetic */ CombatTracker _combatTracker;
    public /* synthetic */ float limbSwing;
    public /* synthetic */ int deathTime;
    protected /* synthetic */ EntityPlayer attackingPlayer;
    private static final /* synthetic */ DataParameter<Float> HEALTH;
    private /* synthetic */ float absorptionAmount;
    protected /* synthetic */ double interpTargetY;
    protected /* synthetic */ float prevOnGroundSpeedFactor;
    
    protected boolean isMovementBlocked() {
        return this.getHealth() <= 0.0f;
    }
    
    public ItemStack getHeldItemMainhand() {
        return this.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND);
    }
    
    public int getTicksElytraFlying() {
        return this.ticksElytraFlying;
    }
    
    public void setHeldItem(final EnumHand lllllllllllllIlIlllIlIlllIllIlIl, final ItemStack lllllllllllllIlIlllIlIlllIllIlll) {
        if (lllllllllllllIlIlllIlIlllIllIlIl == EnumHand.MAIN_HAND) {
            this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, lllllllllllllIlIlllIlIlllIllIlll);
        }
        else {
            if (lllllllllllllIlIlllIlIlllIllIlIl != EnumHand.OFF_HAND) {
                throw new IllegalArgumentException(String.valueOf(new StringBuilder("Invalid hand ").append(lllllllllllllIlIlllIlIlllIllIlIl)));
            }
            this.setItemStackToSlot(EntityEquipmentSlot.OFFHAND, lllllllllllllIlIlllIlIlllIllIlll);
        }
    }
    
    public void swingArm(final EnumHand lllllllllllllIlIlllIlIllllllIllI) {
        if (!this.isSwingInProgress || this.swingProgressInt >= this.getArmSwingAnimationEnd() / 2 || this.swingProgressInt < 0) {
            this.swingProgressInt = -1;
            this.isSwingInProgress = true;
            this.swingingHand = lllllllllllllIlIlllIlIllllllIllI;
            if (this.world instanceof WorldServer) {
                ((WorldServer)this.world).getEntityTracker().sendToAllTrackingEntity(this, new SPacketAnimation(this, (lllllllllllllIlIlllIlIllllllIllI == EnumHand.MAIN_HAND) ? 0 : 3));
            }
        }
    }
    
    public void heal(final float lllllllllllllIlIlllIllIlIlIIIIIl) {
        final float lllllllllllllIlIlllIllIlIlIIIIII = this.getHealth();
        if (lllllllllllllIlIlllIllIlIlIIIIII > 0.0f) {
            this.setHealth(lllllllllllllIlIlllIllIlIlIIIIII + lllllllllllllIlIlllIllIlIlIIIIIl);
        }
    }
    
    public boolean func_190630_a(final EntityEquipmentSlot lllllllllllllIlIlllIlIlllIlIlllI) {
        return !this.getItemStackFromSlot(lllllllllllllIlIlllIlIlllIlIlllI).func_190926_b();
    }
    
    protected SoundEvent getFallSound(final int lllllllllllllIlIlllIllIIlIIlIlII) {
        return (lllllllllllllIlIlllIllIIlIIlIlII > 4) ? SoundEvents.ENTITY_GENERIC_BIG_FALL : SoundEvents.ENTITY_GENERIC_SMALL_FALL;
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource lllllllllllllIlIlllIllIlIIlIlIIl, float lllllllllllllIlIlllIllIlIIIllIII) {
        if (this.isEntityInvulnerable(lllllllllllllIlIlllIllIlIIlIlIIl)) {
            return false;
        }
        if (this.world.isRemote) {
            return false;
        }
        this.entityAge = 0;
        if (this.getHealth() <= 0.0f) {
            return false;
        }
        if (lllllllllllllIlIlllIllIlIIlIlIIl.isFireDamage() && this.isPotionActive(MobEffects.FIRE_RESISTANCE)) {
            return false;
        }
        final float lllllllllllllIlIlllIllIlIIlIIlll = lllllllllllllIlIlllIllIlIIIllIII;
        if ((lllllllllllllIlIlllIllIlIIlIlIIl == DamageSource.anvil || lllllllllllllIlIlllIllIlIIlIlIIl == DamageSource.fallingBlock) && !this.getItemStackFromSlot(EntityEquipmentSlot.HEAD).func_190926_b()) {
            this.getItemStackFromSlot(EntityEquipmentSlot.HEAD).damageItem((int)(lllllllllllllIlIlllIllIlIIIllIII * 4.0f + this.rand.nextFloat() * lllllllllllllIlIlllIllIlIIIllIII * 2.0f), this);
            lllllllllllllIlIlllIllIlIIIllIII *= 0.75f;
        }
        boolean lllllllllllllIlIlllIllIlIIlIIllI = false;
        if (lllllllllllllIlIlllIllIlIIIllIII > 0.0f && this.canBlockDamageSource(lllllllllllllIlIlllIllIlIIlIlIIl)) {
            this.damageShield(lllllllllllllIlIlllIllIlIIIllIII);
            lllllllllllllIlIlllIllIlIIIllIII = 0.0f;
            if (!lllllllllllllIlIlllIllIlIIlIlIIl.isProjectile()) {
                final Entity lllllllllllllIlIlllIllIlIIlIIlIl = lllllllllllllIlIlllIllIlIIlIlIIl.getSourceOfDamage();
                if (lllllllllllllIlIlllIllIlIIlIIlIl instanceof EntityLivingBase) {
                    this.func_190629_c((EntityLivingBase)lllllllllllllIlIlllIllIlIIlIIlIl);
                }
            }
            lllllllllllllIlIlllIllIlIIlIIllI = true;
        }
        this.limbSwingAmount = 1.5f;
        boolean lllllllllllllIlIlllIllIlIIlIIlII = true;
        if (this.hurtResistantTime > this.maxHurtResistantTime / 2.0f) {
            if (lllllllllllllIlIlllIllIlIIIllIII <= this.lastDamage) {
                return false;
            }
            this.damageEntity(lllllllllllllIlIlllIllIlIIlIlIIl, lllllllllllllIlIlllIllIlIIIllIII - this.lastDamage);
            this.lastDamage = lllllllllllllIlIlllIllIlIIIllIII;
            lllllllllllllIlIlllIllIlIIlIIlII = false;
        }
        else {
            this.lastDamage = lllllllllllllIlIlllIllIlIIIllIII;
            this.hurtResistantTime = this.maxHurtResistantTime;
            this.damageEntity(lllllllllllllIlIlllIllIlIIlIlIIl, lllllllllllllIlIlllIllIlIIIllIII);
            this.maxHurtTime = 10;
            this.hurtTime = this.maxHurtTime;
        }
        this.attackedAtYaw = 0.0f;
        final Entity lllllllllllllIlIlllIllIlIIlIIIll = lllllllllllllIlIlllIllIlIIlIlIIl.getEntity();
        if (lllllllllllllIlIlllIllIlIIlIIIll != null) {
            if (lllllllllllllIlIlllIllIlIIlIIIll instanceof EntityLivingBase) {
                this.setRevengeTarget((EntityLivingBase)lllllllllllllIlIlllIllIlIIlIIIll);
            }
            if (lllllllllllllIlIlllIllIlIIlIIIll instanceof EntityPlayer) {
                this.recentlyHit = 100;
                this.attackingPlayer = (EntityPlayer)lllllllllllllIlIlllIllIlIIlIIIll;
            }
            else if (lllllllllllllIlIlllIllIlIIlIIIll instanceof EntityWolf) {
                final EntityWolf lllllllllllllIlIlllIllIlIIlIIIlI = (EntityWolf)lllllllllllllIlIlllIllIlIIlIIIll;
                if (lllllllllllllIlIlllIllIlIIlIIIlI.isTamed()) {
                    this.recentlyHit = 100;
                    this.attackingPlayer = null;
                }
            }
        }
        if (lllllllllllllIlIlllIllIlIIlIIlII) {
            if (lllllllllllllIlIlllIllIlIIlIIllI) {
                this.world.setEntityState(this, (byte)29);
            }
            else if (lllllllllllllIlIlllIllIlIIlIlIIl instanceof EntityDamageSource && ((EntityDamageSource)lllllllllllllIlIlllIllIlIIlIlIIl).getIsThornsDamage()) {
                this.world.setEntityState(this, (byte)33);
            }
            else {
                byte lllllllllllllIlIlllIllIlIIIlllll = 0;
                if (lllllllllllllIlIlllIllIlIIlIlIIl == DamageSource.drown) {
                    final byte lllllllllllllIlIlllIllIlIIlIIIIl = 36;
                }
                else if (lllllllllllllIlIlllIllIlIIlIlIIl.isFireDamage()) {
                    final byte lllllllllllllIlIlllIllIlIIlIIIII = 37;
                }
                else {
                    lllllllllllllIlIlllIllIlIIIlllll = 2;
                }
                this.world.setEntityState(this, lllllllllllllIlIlllIllIlIIIlllll);
            }
            if (lllllllllllllIlIlllIllIlIIlIlIIl != DamageSource.drown && (!lllllllllllllIlIlllIllIlIIlIIllI || lllllllllllllIlIlllIllIlIIIllIII > 0.0f)) {
                this.setBeenAttacked();
            }
            if (lllllllllllllIlIlllIllIlIIlIIIll != null) {
                double lllllllllllllIlIlllIllIlIIIllllI;
                double lllllllllllllIlIlllIllIlIIIlllIl;
                for (lllllllllllllIlIlllIllIlIIIllllI = lllllllllllllIlIlllIllIlIIlIIIll.posX - this.posX, lllllllllllllIlIlllIllIlIIIlllIl = lllllllllllllIlIlllIllIlIIlIIIll.posZ - this.posZ; lllllllllllllIlIlllIllIlIIIllllI * lllllllllllllIlIlllIllIlIIIllllI + lllllllllllllIlIlllIllIlIIIlllIl * lllllllllllllIlIlllIllIlIIIlllIl < 1.0E-4; lllllllllllllIlIlllIllIlIIIllllI = (Math.random() - Math.random()) * 0.01, lllllllllllllIlIlllIllIlIIIlllIl = (Math.random() - Math.random()) * 0.01) {}
                this.attackedAtYaw = (float)(MathHelper.atan2(lllllllllllllIlIlllIllIlIIIlllIl, lllllllllllllIlIlllIllIlIIIllllI) * 57.29577951308232 - this.rotationYaw);
                this.knockBack(lllllllllllllIlIlllIllIlIIlIIIll, 0.4f, lllllllllllllIlIlllIllIlIIIllllI, lllllllllllllIlIlllIllIlIIIlllIl);
            }
            else {
                this.attackedAtYaw = (float)((int)(Math.random() * 2.0) * 180);
            }
        }
        if (this.getHealth() <= 0.0f) {
            if (!this.func_190628_d(lllllllllllllIlIlllIllIlIIlIlIIl)) {
                final SoundEvent lllllllllllllIlIlllIllIlIIIlllII = this.getDeathSound();
                if (lllllllllllllIlIlllIllIlIIlIIlII && lllllllllllllIlIlllIllIlIIIlllII != null) {
                    this.playSound(lllllllllllllIlIlllIllIlIIIlllII, this.getSoundVolume(), this.getSoundPitch());
                }
                this.onDeath(lllllllllllllIlIlllIllIlIIlIlIIl);
            }
        }
        else if (lllllllllllllIlIlllIllIlIIlIIlII) {
            this.playHurtSound(lllllllllllllIlIlllIllIlIIlIlIIl);
        }
        final boolean lllllllllllllIlIlllIllIlIIIllIll = !lllllllllllllIlIlllIllIlIIlIIllI || lllllllllllllIlIlllIllIlIIIllIII > 0.0f;
        if (lllllllllllllIlIlllIllIlIIIllIll) {
            this.lastDamageSource = lllllllllllllIlIlllIllIlIIlIlIIl;
            this.lastDamageStamp = this.world.getTotalWorldTime();
        }
        if (this instanceof EntityPlayerMP) {
            CriteriaTriggers.field_192128_h.func_192200_a((EntityPlayerMP)this, lllllllllllllIlIlllIllIlIIlIlIIl, lllllllllllllIlIlllIllIlIIlIIlll, lllllllllllllIlIlllIllIlIIIllIII, lllllllllllllIlIlllIllIlIIlIIllI);
        }
        if (lllllllllllllIlIlllIllIlIIlIIIll instanceof EntityPlayerMP) {
            CriteriaTriggers.field_192127_g.func_192220_a((EntityPlayerMP)lllllllllllllIlIlllIllIlIIlIIIll, this, lllllllllllllIlIlllIllIlIIlIlIIl, lllllllllllllIlIlllIllIlIIlIIlll, lllllllllllllIlIlllIllIlIIIllIII, lllllllllllllIlIlllIllIlIIlIIllI);
        }
        return lllllllllllllIlIlllIllIlIIIllIll;
    }
    
    public void addPotionEffect(final PotionEffect lllllllllllllIlIlllIllIlIlllllIl) {
        if (this.isPotionApplicable(lllllllllllllIlIlllIllIlIlllllIl)) {
            final PotionEffect lllllllllllllIlIlllIllIlIlllllII = this.activePotionsMap.get(lllllllllllllIlIlllIllIlIlllllIl.getPotion());
            if (lllllllllllllIlIlllIllIlIlllllII == null) {
                this.activePotionsMap.put(lllllllllllllIlIlllIllIlIlllllIl.getPotion(), lllllllllllllIlIlllIllIlIlllllIl);
                this.onNewPotionEffect(lllllllllllllIlIlllIllIlIlllllIl);
            }
            else {
                lllllllllllllIlIlllIllIlIlllllII.combine(lllllllllllllIlIlllIllIlIlllllIl);
                this.onChangedPotionEffect(lllllllllllllIlIlllIllIlIlllllII, true);
            }
        }
    }
    
    public int getItemInUseMaxCount() {
        return this.isHandActive() ? (this.activeItemStack.getMaxItemUseDuration() - this.getItemInUseCount()) : 0;
    }
    
    public boolean isServerWorld() {
        return !this.world.isRemote;
    }
    
    public float getAIMoveSpeed() {
        return this.landMovementFactor;
    }
    
    public AbstractAttributeMap getAttributeMap() {
        if (this.attributeMap == null) {
            this.attributeMap = new AttributeMap();
        }
        return this.attributeMap;
    }
    
    @Override
    protected void entityInit() {
        this.dataManager.register(EntityLivingBase.HAND_STATES, (Byte)0);
        this.dataManager.register(EntityLivingBase.POTION_EFFECTS, 0);
        this.dataManager.register(EntityLivingBase.HIDE_PARTICLES, false);
        this.dataManager.register(EntityLivingBase.ARROW_COUNT_IN_ENTITY, 0);
        this.dataManager.register(EntityLivingBase.HEALTH, 1.0f);
    }
    
    protected void playHurtSound(final DamageSource lllllllllllllIlIlllIllIIlllIlIll) {
        final SoundEvent lllllllllllllIlIlllIllIIlllIllIl = this.getHurtSound(lllllllllllllIlIlllIllIIlllIlIll);
        if (lllllllllllllIlIlllIllIIlllIllIl != null) {
            this.playSound(lllllllllllllIlIlllIllIIlllIllIl, this.getSoundVolume(), this.getSoundPitch());
        }
    }
    
    protected void onChangedPotionEffect(final PotionEffect lllllllllllllIlIlllIllIlIlIIlllI, final boolean lllllllllllllIlIlllIllIlIlIlIIIl) {
        this.potionsNeedUpdate = true;
        if (lllllllllllllIlIlllIllIlIlIlIIIl && !this.world.isRemote) {
            final Potion lllllllllllllIlIlllIllIlIlIlIIII = lllllllllllllIlIlllIllIlIlIIlllI.getPotion();
            lllllllllllllIlIlllIllIlIlIlIIII.removeAttributesModifiersFromEntity(this, this.getAttributeMap(), lllllllllllllIlIlllIllIlIlIIlllI.getAmplifier());
            lllllllllllllIlIlllIllIlIlIlIIII.applyAttributesModifiersToEntity(this, this.getAttributeMap(), lllllllllllllIlIlllIllIlIlIIlllI.getAmplifier());
        }
    }
    
    public void clearActivePotions() {
        if (!this.world.isRemote) {
            final Iterator<PotionEffect> lllllllllllllIlIlllIllIllIIlIllI = this.activePotionsMap.values().iterator();
            while (lllllllllllllIlIlllIllIllIIlIllI.hasNext()) {
                this.onFinishedPotionEffect(lllllllllllllIlIlllIllIllIIlIllI.next());
                lllllllllllllIlIlllIllIllIIlIllI.remove();
            }
        }
    }
    
    public boolean isPotionApplicable(final PotionEffect lllllllllllllIlIlllIllIlIlllIIIl) {
        if (this.getCreatureAttribute() == EnumCreatureAttribute.UNDEAD) {
            final Potion lllllllllllllIlIlllIllIlIlllIIll = lllllllllllllIlIlllIllIlIlllIIIl.getPotion();
            if (lllllllllllllIlIlllIllIlIlllIIll == MobEffects.REGENERATION || lllllllllllllIlIlllIllIlIlllIIll == MobEffects.POISON) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    protected void setBeenAttacked() {
        this.velocityChanged = (this.rand.nextDouble() >= this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).getAttributeValue());
    }
    
    public EnumHand getActiveHand() {
        return ((this.dataManager.get(EntityLivingBase.HAND_STATES) & 0x2) > 0) ? EnumHand.OFF_HAND : EnumHand.MAIN_HAND;
    }
    
    protected void handleJumpWater() {
        this.motionY += 0.03999999910593033;
    }
    
    public Random getRNG() {
        return this.rand;
    }
    
    public int getTotalArmorValue() {
        final IAttributeInstance lllllllllllllIlIlllIllIIIlIIIlII = this.getEntityAttribute(SharedMonsterAttributes.ARMOR);
        return MathHelper.floor(lllllllllllllIlIlllIllIIIlIIIlII.getAttributeValue());
    }
    
    protected void updateActiveHand() {
        if (this.isHandActive()) {
            final ItemStack lllllllllllllIlIlllIlIlIIIIIlIll = this.getHeldItem(this.getActiveHand());
            if (lllllllllllllIlIlllIlIlIIIIIlIll == this.activeItemStack) {
                if (this.getItemInUseCount() <= 25 && this.getItemInUseCount() % 4 == 0) {
                    this.updateItemUse(this.activeItemStack, 5);
                }
                if (--this.activeItemStackUseCount == 0 && !this.world.isRemote) {
                    this.onItemUseFinish();
                }
            }
            else {
                this.resetActiveHand();
            }
        }
    }
    
    @Nullable
    public EntityLivingBase getAttackingEntity() {
        if (this._combatTracker.getBestAttacker() != null) {
            return this._combatTracker.getBestAttacker();
        }
        if (this.attackingPlayer != null) {
            return this.attackingPlayer;
        }
        return (this.entityLivingToAttack != null) ? this.entityLivingToAttack : null;
    }
    
    @Override
    public boolean canBeCollidedWith() {
        return !this.isDead;
    }
    
    public void onItemPickup(final Entity lllllllllllllIlIlllIlIlIIlIlllll, final int lllllllllllllIlIlllIlIlIIlIllllI) {
        if (!lllllllllllllIlIlllIlIlIIlIlllll.isDead && !this.world.isRemote) {
            final EntityTracker lllllllllllllIlIlllIlIlIIlIlllIl = ((WorldServer)this.world).getEntityTracker();
            if (lllllllllllllIlIlllIlIlIIlIlllll instanceof EntityItem || lllllllllllllIlIlllIlIlIIlIlllll instanceof EntityArrow || lllllllllllllIlIlllIlIlIIlIlllll instanceof EntityXPOrb) {
                lllllllllllllIlIlllIlIlIIlIlllIl.sendToAllTrackingEntity(lllllllllllllIlIlllIlIlIIlIlllll, new SPacketCollectItem(lllllllllllllIlIlllIlIlIIlIlllll.getEntityId(), this.getEntityId(), lllllllllllllIlIlllIlIlIIlIllllI));
            }
        }
    }
    
    public boolean attackEntityAsMob(final Entity lllllllllllllIlIlllIlIlIllllIIll) {
        this.setLastAttacker(lllllllllllllIlIlllIlIlIllllIIll);
        return false;
    }
    
    @Nullable
    public EntityLivingBase getAITarget() {
        return this.entityLivingToAttack;
    }
    
    public void setAIMoveSpeed(final float lllllllllllllIlIlllIlIlIlllllIIl) {
        this.landMovementFactor = lllllllllllllIlIlllIlIlIlllllIIl;
    }
    
    public void readEntityFromNBT(final NBTTagCompound lllllllllllllIlIlllIllIlllIIlIlI) {
        this.setAbsorptionAmount(lllllllllllllIlIlllIllIlllIIlIlI.getFloat("AbsorptionAmount"));
        if (lllllllllllllIlIlllIllIlllIIlIlI.hasKey("Attributes", 9) && this.world != null && !this.world.isRemote) {
            SharedMonsterAttributes.setAttributeModifiers(this.getAttributeMap(), lllllllllllllIlIlllIllIlllIIlIlI.getTagList("Attributes", 10));
        }
        if (lllllllllllllIlIlllIllIlllIIlIlI.hasKey("ActiveEffects", 9)) {
            final NBTTagList lllllllllllllIlIlllIllIlllIlIIIl = lllllllllllllIlIlllIllIlllIIlIlI.getTagList("ActiveEffects", 10);
            for (int lllllllllllllIlIlllIllIlllIlIIII = 0; lllllllllllllIlIlllIllIlllIlIIII < lllllllllllllIlIlllIllIlllIlIIIl.tagCount(); ++lllllllllllllIlIlllIllIlllIlIIII) {
                final NBTTagCompound lllllllllllllIlIlllIllIlllIIllll = lllllllllllllIlIlllIllIlllIlIIIl.getCompoundTagAt(lllllllllllllIlIlllIllIlllIlIIII);
                final PotionEffect lllllllllllllIlIlllIllIlllIIlllI = PotionEffect.readCustomPotionEffectFromNBT(lllllllllllllIlIlllIllIlllIIllll);
                if (lllllllllllllIlIlllIllIlllIIlllI != null) {
                    this.activePotionsMap.put(lllllllllllllIlIlllIllIlllIIlllI.getPotion(), lllllllllllllIlIlllIllIlllIIlllI);
                }
            }
        }
        if (lllllllllllllIlIlllIllIlllIIlIlI.hasKey("Health", 99)) {
            this.setHealth(lllllllllllllIlIlllIllIlllIIlIlI.getFloat("Health"));
        }
        this.hurtTime = lllllllllllllIlIlllIllIlllIIlIlI.getShort("HurtTime");
        this.deathTime = lllllllllllllIlIlllIllIlllIIlIlI.getShort("DeathTime");
        this.revengeTimer = lllllllllllllIlIlllIllIlllIIlIlI.getInteger("HurtByTimestamp");
        if (lllllllllllllIlIlllIllIlllIIlIlI.hasKey("Team", 8)) {
            final String lllllllllllllIlIlllIllIlllIIllIl = lllllllllllllIlIlllIllIlllIIlIlI.getString("Team");
            final boolean lllllllllllllIlIlllIllIlllIIllII = this.world.getScoreboard().addPlayerToTeam(this.getCachedUniqueIdString(), lllllllllllllIlIlllIllIlllIIllIl);
            if (!lllllllllllllIlIlllIllIlllIIllII) {
                EntityLivingBase.field_190632_a.warn(String.valueOf(new StringBuilder("Unable to add mob to team \"").append(lllllllllllllIlIlllIllIlllIIllIl).append("\" (that team probably doesn't exist)")));
            }
        }
        if (lllllllllllllIlIlllIllIlllIIlIlI.getBoolean("FallFlying")) {
            this.setFlag(7, true);
        }
    }
    
    public final void setArrowCountInEntity(final int lllllllllllllIlIlllIllIIIIIIIIIl) {
        this.dataManager.set(EntityLivingBase.ARROW_COUNT_IN_ENTITY, lllllllllllllIlIlllIllIIIIIIIIIl);
    }
    
    public CombatTracker getCombatTracker() {
        return this._combatTracker;
    }
    
    public boolean attemptTeleport(final double lllllllllllllIlIlllIlIIllIlIlllI, final double lllllllllllllIlIlllIlIIllIIlIllI, final double lllllllllllllIlIlllIlIIllIIlIlIl) {
        final double lllllllllllllIlIlllIlIIllIlIlIll = this.posX;
        final double lllllllllllllIlIlllIlIIllIlIlIlI = this.posY;
        final double lllllllllllllIlIlllIlIIllIlIlIIl = this.posZ;
        this.posX = lllllllllllllIlIlllIlIIllIlIlllI;
        this.posY = lllllllllllllIlIlllIlIIllIIlIllI;
        this.posZ = lllllllllllllIlIlllIlIIllIIlIlIl;
        boolean lllllllllllllIlIlllIlIIllIlIlIII = false;
        BlockPos lllllllllllllIlIlllIlIIllIlIIlll = new BlockPos(this);
        final World lllllllllllllIlIlllIlIIllIlIIllI = this.world;
        final Random lllllllllllllIlIlllIlIIllIlIIlIl = this.getRNG();
        if (lllllllllllllIlIlllIlIIllIlIIllI.isBlockLoaded(lllllllllllllIlIlllIlIIllIlIIlll)) {
            boolean lllllllllllllIlIlllIlIIllIlIIlII = false;
            while (!lllllllllllllIlIlllIlIIllIlIIlII && lllllllllllllIlIlllIlIIllIlIIlll.getY() > 0) {
                final BlockPos lllllllllllllIlIlllIlIIllIlIIIll = lllllllllllllIlIlllIlIIllIlIIlll.down();
                final IBlockState lllllllllllllIlIlllIlIIllIlIIIlI = lllllllllllllIlIlllIlIIllIlIIllI.getBlockState(lllllllllllllIlIlllIlIIllIlIIIll);
                if (lllllllllllllIlIlllIlIIllIlIIIlI.getMaterial().blocksMovement()) {
                    lllllllllllllIlIlllIlIIllIlIIlII = true;
                }
                else {
                    --this.posY;
                    lllllllllllllIlIlllIlIIllIlIIlll = lllllllllllllIlIlllIlIIllIlIIIll;
                }
            }
            if (lllllllllllllIlIlllIlIIllIlIIlII) {
                this.setPositionAndUpdate(this.posX, this.posY, this.posZ);
                if (lllllllllllllIlIlllIlIIllIlIIllI.getCollisionBoxes(this, this.getEntityBoundingBox()).isEmpty() && !lllllllllllllIlIlllIlIIllIlIIllI.containsAnyLiquid(this.getEntityBoundingBox())) {
                    lllllllllllllIlIlllIlIIllIlIlIII = true;
                }
            }
        }
        if (!lllllllllllllIlIlllIlIIllIlIlIII) {
            this.setPositionAndUpdate(lllllllllllllIlIlllIlIIllIlIlIll, lllllllllllllIlIlllIlIIllIlIlIlI, lllllllllllllIlIlllIlIIllIlIlIIl);
            return false;
        }
        final int lllllllllllllIlIlllIlIIllIlIIIIl = 128;
        for (int lllllllllllllIlIlllIlIIllIlIIIII = 0; lllllllllllllIlIlllIlIIllIlIIIII < 128; ++lllllllllllllIlIlllIlIIllIlIIIII) {
            final double lllllllllllllIlIlllIlIIllIIlllll = lllllllllllllIlIlllIlIIllIlIIIII / 127.0;
            final float lllllllllllllIlIlllIlIIllIIllllI = (lllllllllllllIlIlllIlIIllIlIIlIl.nextFloat() - 0.5f) * 0.2f;
            final float lllllllllllllIlIlllIlIIllIIlllIl = (lllllllllllllIlIlllIlIIllIlIIlIl.nextFloat() - 0.5f) * 0.2f;
            final float lllllllllllllIlIlllIlIIllIIlllII = (lllllllllllllIlIlllIlIIllIlIIlIl.nextFloat() - 0.5f) * 0.2f;
            final double lllllllllllllIlIlllIlIIllIIllIll = lllllllllllllIlIlllIlIIllIlIlIll + (this.posX - lllllllllllllIlIlllIlIIllIlIlIll) * lllllllllllllIlIlllIlIIllIIlllll + (lllllllllllllIlIlllIlIIllIlIIlIl.nextDouble() - 0.5) * this.width * 2.0;
            final double lllllllllllllIlIlllIlIIllIIllIlI = lllllllllllllIlIlllIlIIllIlIlIlI + (this.posY - lllllllllllllIlIlllIlIIllIlIlIlI) * lllllllllllllIlIlllIlIIllIIlllll + lllllllllllllIlIlllIlIIllIlIIlIl.nextDouble() * this.height;
            final double lllllllllllllIlIlllIlIIllIIllIIl = lllllllllllllIlIlllIlIIllIlIlIIl + (this.posZ - lllllllllllllIlIlllIlIIllIlIlIIl) * lllllllllllllIlIlllIlIIllIIlllll + (lllllllllllllIlIlllIlIIllIlIIlIl.nextDouble() - 0.5) * this.width * 2.0;
            lllllllllllllIlIlllIlIIllIlIIllI.spawnParticle(EnumParticleTypes.PORTAL, lllllllllllllIlIlllIlIIllIIllIll, lllllllllllllIlIlllIlIIllIIllIlI, lllllllllllllIlIlllIlIIllIIllIIl, lllllllllllllIlIlllIlIIllIIllllI, lllllllllllllIlIlllIlIIllIIlllIl, lllllllllllllIlIlllIlIIllIIlllII, new int[0]);
        }
        if (this instanceof EntityCreature) {
            ((EntityCreature)this).getNavigator().clearPathEntity();
        }
        return true;
    }
    
    public void sendEnterCombat() {
    }
    
    @Override
    protected void kill() {
        this.attackEntityFrom(DamageSource.outOfWorld, 4.0f);
    }
    
    public boolean canBreatheUnderwater() {
        return false;
    }
    
    public final float getMaxHealth() {
        return (float)this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).getAttributeValue();
    }
    
    public void knockBack(final Entity lllllllllllllIlIlllIllIIlIlIIIll, final float lllllllllllllIlIlllIllIIlIIlllIl, final double lllllllllllllIlIlllIllIIlIlIIIIl, final double lllllllllllllIlIlllIllIIlIlIIIII) {
        if (this.rand.nextDouble() >= this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).getAttributeValue()) {
            this.isAirBorne = true;
            final float lllllllllllllIlIlllIllIIlIIlllll = MathHelper.sqrt(lllllllllllllIlIlllIllIIlIlIIIIl * lllllllllllllIlIlllIllIIlIlIIIIl + lllllllllllllIlIlllIllIIlIlIIIII * lllllllllllllIlIlllIllIIlIlIIIII);
            this.motionX /= 2.0;
            this.motionZ /= 2.0;
            this.motionX -= lllllllllllllIlIlllIllIIlIlIIIIl / lllllllllllllIlIlllIllIIlIIlllll * lllllllllllllIlIlllIllIIlIIlllIl;
            this.motionZ -= lllllllllllllIlIlllIllIIlIlIIIII / lllllllllllllIlIlllIllIIlIIlllll * lllllllllllllIlIlllIllIIlIIlllIl;
            if (this.onGround) {
                this.motionY /= 2.0;
                this.motionY += lllllllllllllIlIlllIllIIlIIlllIl;
                if (this.motionY > 0.4000000059604645) {
                    this.motionY = 0.4000000059604645;
                }
            }
        }
    }
    
    public void setRevengeTarget(@Nullable final EntityLivingBase lllllllllllllIlIlllIlllIIIIIlIll) {
        this.entityLivingToAttack = lllllllllllllIlIlllIlllIIIIIlIll;
        this.revengeTimer = this.ticksExisted;
    }
    
    public void setHealth(final float lllllllllllllIlIlllIllIlIIllIllI) {
        this.dataManager.set(EntityLivingBase.HEALTH, MathHelper.clamp(lllllllllllllIlIlllIllIlIIllIllI, 0.0f, this.getMaxHealth()));
    }
    
    @Override
    public Vec3d getLook(final float lllllllllllllIlIlllIlIlIIlIIlIIl) {
        if (lllllllllllllIlIlllIlIlIIlIIlIIl == 1.0f) {
            return this.getVectorForRotation(this.rotationPitchHead, this.rotationYawHead);
        }
        final float lllllllllllllIlIlllIlIlIIlIIllII = this.prevRotationPitch + (this.rotationPitchHead - this.prevRotationPitchHead) * lllllllllllllIlIlllIlIlIIlIIlIIl;
        final float lllllllllllllIlIlllIlIlIIlIIlIll = this.prevRotationYawHead + (this.rotationYawHead - this.prevRotationYawHead) * lllllllllllllIlIlllIlIlIIlIIlIIl;
        return this.getVectorForRotation(lllllllllllllIlIlllIlIlIIlIIllII, lllllllllllllIlIlllIlIlIIlIIlIll);
    }
    
    @Override
    public void setRotationYawHead(final float lllllllllllllIlIlllIlIlIIIlIlIll) {
        this.rotationYawHead = lllllllllllllIlIlllIlIlIIIlIlIll;
    }
    
    public boolean isPotionActive(final Potion lllllllllllllIlIlllIllIllIIIlIlI) {
        return this.activePotionsMap.containsKey(lllllllllllllIlIlllIllIllIIIlIlI);
    }
    
    public void resetActiveHand() {
        if (!this.world.isRemote) {
            this.dataManager.set(EntityLivingBase.HAND_STATES, (Byte)0);
        }
        this.activeItemStack = ItemStack.field_190927_a;
        this.activeItemStackUseCount = 0;
    }
    
    @Override
    public float getRotationYawHead() {
        return this.rotationYawHead;
    }
    
    protected void func_190629_c(final EntityLivingBase lllllllllllllIlIlllIllIlIIIIlllI) {
        lllllllllllllIlIlllIllIlIIIIlllI.knockBack(this, 0.5f, this.posX - lllllllllllllIlIlllIllIlIIIIlllI.posX, this.posZ - lllllllllllllIlIlllIllIlIIIIlllI.posZ);
    }
    
    public ItemStack getActiveItemStack() {
        return this.activeItemStack;
    }
    
    public final int getArrowCountInEntity() {
        return this.dataManager.get(EntityLivingBase.ARROW_COUNT_IN_ENTITY);
    }
    
    protected boolean isPlayer() {
        return false;
    }
    
    private boolean canBlockDamageSource(final DamageSource lllllllllllllIlIlllIllIIlllIIIll) {
        if (!lllllllllllllIlIlllIllIIlllIIIll.isUnblockable() && this.isActiveItemStackBlocking()) {
            final Vec3d lllllllllllllIlIlllIllIIlllIIIlI = lllllllllllllIlIlllIllIIlllIIIll.getDamageLocation();
            if (lllllllllllllIlIlllIllIIlllIIIlI != null) {
                final Vec3d lllllllllllllIlIlllIllIIlllIIIIl = this.getLook(1.0f);
                Vec3d lllllllllllllIlIlllIllIIlllIIIII = lllllllllllllIlIlllIllIIlllIIIlI.subtractReverse(new Vec3d(this.posX, this.posY, this.posZ)).normalize();
                lllllllllllllIlIlllIllIIlllIIIII = new Vec3d(lllllllllllllIlIlllIllIIlllIIIII.xCoord, 0.0, lllllllllllllIlIlllIllIIlllIIIII.zCoord);
                if (lllllllllllllIlIlllIllIIlllIIIII.dotProduct(lllllllllllllIlIlllIllIIlllIIIIl) < 0.0) {
                    return true;
                }
            }
        }
        return false;
    }
    
    @Override
    public void onEntityUpdate() {
        this.prevSwingProgress = this.swingProgress;
        super.onEntityUpdate();
        this.world.theProfiler.startSection("livingEntityBaseTick");
        final boolean lllllllllllllIlIlllIlllIIlIlIIll = this instanceof EntityPlayer;
        if (this.isEntityAlive()) {
            if (this.isEntityInsideOpaqueBlock()) {
                this.attackEntityFrom(DamageSource.inWall, 1.0f);
            }
            else if (lllllllllllllIlIlllIlllIIlIlIIll && !this.world.getWorldBorder().contains(this.getEntityBoundingBox())) {
                final double lllllllllllllIlIlllIlllIIlIlIIlI = this.world.getWorldBorder().getClosestDistance(this) + this.world.getWorldBorder().getDamageBuffer();
                if (lllllllllllllIlIlllIlllIIlIlIIlI < 0.0) {
                    final double lllllllllllllIlIlllIlllIIlIlIIIl = this.world.getWorldBorder().getDamageAmount();
                    if (lllllllllllllIlIlllIlllIIlIlIIIl > 0.0) {
                        this.attackEntityFrom(DamageSource.inWall, (float)Math.max(1, MathHelper.floor(-lllllllllllllIlIlllIlllIIlIlIIlI * lllllllllllllIlIlllIlllIIlIlIIIl)));
                    }
                }
            }
        }
        if (this.isImmuneToFire() || this.world.isRemote) {
            this.extinguish();
        }
        final boolean lllllllllllllIlIlllIlllIIlIlIIII = lllllllllllllIlIlllIlllIIlIlIIll && ((EntityPlayer)this).capabilities.disableDamage;
        if (this.isEntityAlive()) {
            if (!this.isInsideOfMaterial(Material.WATER)) {
                this.setAir(300);
            }
            else {
                if (!this.canBreatheUnderwater() && !this.isPotionActive(MobEffects.WATER_BREATHING) && !lllllllllllllIlIlllIlllIIlIlIIII) {
                    this.setAir(this.decreaseAirSupply(this.getAir()));
                    if (this.getAir() == -20) {
                        this.setAir(0);
                        for (int lllllllllllllIlIlllIlllIIlIIllll = 0; lllllllllllllIlIlllIlllIIlIIllll < 8; ++lllllllllllllIlIlllIlllIIlIIllll) {
                            final float lllllllllllllIlIlllIlllIIlIIlllI = this.rand.nextFloat() - this.rand.nextFloat();
                            final float lllllllllllllIlIlllIlllIIlIIllIl = this.rand.nextFloat() - this.rand.nextFloat();
                            final float lllllllllllllIlIlllIlllIIlIIllII = this.rand.nextFloat() - this.rand.nextFloat();
                            this.world.spawnParticle(EnumParticleTypes.WATER_BUBBLE, this.posX + lllllllllllllIlIlllIlllIIlIIlllI, this.posY + lllllllllllllIlIlllIlllIIlIIllIl, this.posZ + lllllllllllllIlIlllIlllIIlIIllII, this.motionX, this.motionY, this.motionZ, new int[0]);
                        }
                        this.attackEntityFrom(DamageSource.drown, 2.0f);
                    }
                }
                if (!this.world.isRemote && this.isRiding() && this.getRidingEntity() instanceof EntityLivingBase) {
                    this.dismountRidingEntity();
                }
            }
            if (!this.world.isRemote) {
                final BlockPos lllllllllllllIlIlllIlllIIlIIlIll = new BlockPos(this);
                if (!Objects.equal((Object)this.prevBlockpos, (Object)lllllllllllllIlIlllIlllIIlIIlIll)) {
                    this.prevBlockpos = lllllllllllllIlIlllIlllIIlIIlIll;
                    this.frostWalk(lllllllllllllIlIlllIlllIIlIIlIll);
                }
            }
        }
        if (this.isEntityAlive() && this.isWet()) {
            this.extinguish();
        }
        this.prevCameraPitch = this.cameraPitch;
        if (this.hurtTime > 0) {
            --this.hurtTime;
        }
        if (this.hurtResistantTime > 0 && !(this instanceof EntityPlayerMP)) {
            --this.hurtResistantTime;
        }
        if (this.getHealth() <= 0.0f) {
            this.onDeathUpdate();
        }
        if (this.recentlyHit > 0) {
            --this.recentlyHit;
        }
        else {
            this.attackingPlayer = null;
        }
        if (this.lastAttacker != null && !this.lastAttacker.isEntityAlive()) {
            this.lastAttacker = null;
        }
        if (this.entityLivingToAttack != null) {
            if (!this.entityLivingToAttack.isEntityAlive()) {
                this.setRevengeTarget(null);
            }
            else if (this.ticksExisted - this.revengeTimer > 100) {
                this.setRevengeTarget(null);
            }
        }
        this.updatePotionEffects();
        this.prevMovedDistance = this.movedDistance;
        this.prevRenderYawOffset = this.renderYawOffset;
        this.prevRotationYawHead = this.rotationYawHead;
        this.prevRotationPitchHead = this.rotationPitchHead;
        this.prevRotationYaw = this.rotationYaw;
        this.prevRotationPitch = this.rotationPitch;
        this.world.theProfiler.endSection();
    }
    
    @Override
    public void onKillCommand() {
        this.attackEntityFrom(DamageSource.outOfWorld, Float.MAX_VALUE);
    }
    
    @Override
    public void setRenderYawOffset(final float lllllllllllllIlIlllIlIlIIIlIIlIl) {
        this.renderYawOffset = lllllllllllllIlIlllIlIlIIIlIIlIl;
    }
    
    @Override
    public void setSprinting(final boolean lllllllllllllIlIlllIlIlllIlIlIIl) {
        super.setSprinting(lllllllllllllIlIlllIlIlllIlIlIIl);
        final IAttributeInstance lllllllllllllIlIlllIlIlllIlIlIII = this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED);
        if (lllllllllllllIlIlllIlIlllIlIlIII.getModifier(EntityLivingBase.SPRINTING_SPEED_BOOST_ID) != null) {
            lllllllllllllIlIlllIlIlllIlIlIII.removeModifier(EntityLivingBase.SPRINTING_SPEED_BOOST);
        }
        if (lllllllllllllIlIlllIlIlllIlIlIIl) {
            lllllllllllllIlIlllIlIlllIlIlIII.applyModifier(EntityLivingBase.SPRINTING_SPEED_BOOST);
        }
    }
    
    protected int getExperiencePoints(final EntityPlayer lllllllllllllIlIlllIlllIIIIllIll) {
        return 0;
    }
    
    protected void damageArmor(final float lllllllllllllIlIlllIllIIIlIIIIII) {
    }
    
    @Nullable
    protected SoundEvent getHurtSound(final DamageSource lllllllllllllIlIlllIllIIlIIllIII) {
        return SoundEvents.ENTITY_GENERIC_HURT;
    }
    
    public void func_191986_a(final float lllllllllllllIlIlllIlIllIIlIlllI, final float lllllllllllllIlIlllIlIllIIIIlllI, final float lllllllllllllIlIlllIlIllIIlIllII) {
        if (this.isServerWorld() || this.canPassengerSteer()) {
            if (!this.isInWater() || (this instanceof EntityPlayer && ((EntityPlayer)this).capabilities.isFlying)) {
                if (!this.isInLava() || (this instanceof EntityPlayer && ((EntityPlayer)this).capabilities.isFlying)) {
                    if (this.isElytraFlying()) {
                        if (this.motionY > -0.5) {
                            this.fallDistance = 1.0f;
                        }
                        final Vec3d lllllllllllllIlIlllIlIllIIlIlIll = this.getLookVec();
                        final float lllllllllllllIlIlllIlIllIIlIlIlI = this.rotationPitch * 0.017453292f;
                        final double lllllllllllllIlIlllIlIllIIlIlIIl = Math.sqrt(lllllllllllllIlIlllIlIllIIlIlIll.xCoord * lllllllllllllIlIlllIlIllIIlIlIll.xCoord + lllllllllllllIlIlllIlIllIIlIlIll.zCoord * lllllllllllllIlIlllIlIllIIlIlIll.zCoord);
                        final double lllllllllllllIlIlllIlIllIIlIlIII = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
                        final double lllllllllllllIlIlllIlIllIIlIIlll = lllllllllllllIlIlllIlIllIIlIlIll.lengthVector();
                        float lllllllllllllIlIlllIlIllIIlIIllI = MathHelper.cos(lllllllllllllIlIlllIlIllIIlIlIlI);
                        lllllllllllllIlIlllIlIllIIlIIllI = (float)(lllllllllllllIlIlllIlIllIIlIIllI * (double)lllllllllllllIlIlllIlIllIIlIIllI * Math.min(1.0, lllllllllllllIlIlllIlIllIIlIIlll / 0.4));
                        this.motionY += -0.08 + lllllllllllllIlIlllIlIllIIlIIllI * 0.06;
                        if (this.motionY < 0.0 && lllllllllllllIlIlllIlIllIIlIlIIl > 0.0) {
                            final double lllllllllllllIlIlllIlIllIIlIIlIl = this.motionY * -0.1 * lllllllllllllIlIlllIlIllIIlIIllI;
                            this.motionY += lllllllllllllIlIlllIlIllIIlIIlIl;
                            this.motionX += lllllllllllllIlIlllIlIllIIlIlIll.xCoord * lllllllllllllIlIlllIlIllIIlIIlIl / lllllllllllllIlIlllIlIllIIlIlIIl;
                            this.motionZ += lllllllllllllIlIlllIlIllIIlIlIll.zCoord * lllllllllllllIlIlllIlIllIIlIIlIl / lllllllllllllIlIlllIlIllIIlIlIIl;
                        }
                        if (lllllllllllllIlIlllIlIllIIlIlIlI < 0.0f) {
                            final double lllllllllllllIlIlllIlIllIIlIIlII = lllllllllllllIlIlllIlIllIIlIlIII * -MathHelper.sin(lllllllllllllIlIlllIlIllIIlIlIlI) * 0.04;
                            this.motionY += lllllllllllllIlIlllIlIllIIlIIlII * 3.2;
                            this.motionX -= lllllllllllllIlIlllIlIllIIlIlIll.xCoord * lllllllllllllIlIlllIlIllIIlIIlII / lllllllllllllIlIlllIlIllIIlIlIIl;
                            this.motionZ -= lllllllllllllIlIlllIlIllIIlIlIll.zCoord * lllllllllllllIlIlllIlIllIIlIIlII / lllllllllllllIlIlllIlIllIIlIlIIl;
                        }
                        if (lllllllllllllIlIlllIlIllIIlIlIIl > 0.0) {
                            this.motionX += (lllllllllllllIlIlllIlIllIIlIlIll.xCoord / lllllllllllllIlIlllIlIllIIlIlIIl * lllllllllllllIlIlllIlIllIIlIlIII - this.motionX) * 0.1;
                            this.motionZ += (lllllllllllllIlIlllIlIllIIlIlIll.zCoord / lllllllllllllIlIlllIlIllIIlIlIIl * lllllllllllllIlIlllIlIllIIlIlIII - this.motionZ) * 0.1;
                        }
                        this.moveEntity(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
                        if (this.isCollidedHorizontally && !this.world.isRemote) {
                            final double lllllllllllllIlIlllIlIllIIlIIIll = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
                            final double lllllllllllllIlIlllIlIllIIlIIIlI = lllllllllllllIlIlllIlIllIIlIlIII - lllllllllllllIlIlllIlIllIIlIIIll;
                            final float lllllllllllllIlIlllIlIllIIlIIIIl = (float)(lllllllllllllIlIlllIlIllIIlIIIlI * 10.0 - 3.0);
                            if (lllllllllllllIlIlllIlIllIIlIIIIl > 0.0f) {
                                this.playSound(this.getFallSound((int)lllllllllllllIlIlllIlIllIIlIIIIl), 1.0f, 1.0f);
                                this.attackEntityFrom(DamageSource.flyIntoWall, lllllllllllllIlIlllIlIllIIlIIIIl);
                            }
                        }
                        if (this.onGround && !this.world.isRemote) {
                            this.setFlag(7, false);
                        }
                    }
                    else {
                        float lllllllllllllIlIlllIlIllIIlIIIII = 0.91f;
                        final BlockPos.PooledMutableBlockPos lllllllllllllIlIlllIlIllIIIlllll = BlockPos.PooledMutableBlockPos.retain(this.posX, this.getEntityBoundingBox().minY - 1.0, this.posZ);
                        if (this.onGround) {
                            lllllllllllllIlIlllIlIllIIlIIIII = this.world.getBlockState(lllllllllllllIlIlllIlIllIIIlllll).getBlock().slipperiness * 0.91f;
                        }
                        final float lllllllllllllIlIlllIlIllIIIllllI = 0.16277136f / (lllllllllllllIlIlllIlIllIIlIIIII * lllllllllllllIlIlllIlIllIIlIIIII * lllllllllllllIlIlllIlIllIIlIIIII);
                        float lllllllllllllIlIlllIlIllIIIlllII = 0.0f;
                        if (this.onGround) {
                            final float lllllllllllllIlIlllIlIllIIIlllIl = this.getAIMoveSpeed() * lllllllllllllIlIlllIlIllIIIllllI;
                        }
                        else {
                            lllllllllllllIlIlllIlIllIIIlllII = this.jumpMovementFactor;
                        }
                        this.func_191958_b(lllllllllllllIlIlllIlIllIIlIlllI, lllllllllllllIlIlllIlIllIIIIlllI, lllllllllllllIlIlllIlIllIIlIllII, lllllllllllllIlIlllIlIllIIIlllII);
                        lllllllllllllIlIlllIlIllIIlIIIII = 0.91f;
                        if (this.onGround) {
                            lllllllllllllIlIlllIlIllIIlIIIII = this.world.getBlockState(lllllllllllllIlIlllIlIllIIIlllll.setPos(this.posX, this.getEntityBoundingBox().minY - 1.0, this.posZ)).getBlock().slipperiness * 0.91f;
                        }
                        if (this.isOnLadder()) {
                            final float lllllllllllllIlIlllIlIllIIIllIll = 0.15f;
                            this.motionX = MathHelper.clamp(this.motionX, -0.15000000596046448, 0.15000000596046448);
                            this.motionZ = MathHelper.clamp(this.motionZ, -0.15000000596046448, 0.15000000596046448);
                            this.fallDistance = 0.0f;
                            if (this.motionY < -0.15) {
                                this.motionY = -0.15;
                            }
                            final boolean lllllllllllllIlIlllIlIllIIIllIlI = this.isSneaking() && this instanceof EntityPlayer;
                            if (lllllllllllllIlIlllIlIllIIIllIlI && this.motionY < 0.0) {
                                this.motionY = 0.0;
                            }
                        }
                        this.moveEntity(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
                        if (this.isCollidedHorizontally && this.isOnLadder()) {
                            this.motionY = 0.2;
                        }
                        if (this.isPotionActive(MobEffects.LEVITATION)) {
                            this.motionY += (0.05 * (this.getActivePotionEffect(MobEffects.LEVITATION).getAmplifier() + 1) - this.motionY) * 0.2;
                        }
                        else {
                            lllllllllllllIlIlllIlIllIIIlllll.setPos(this.posX, 0.0, this.posZ);
                            if (!this.world.isRemote || (this.world.isBlockLoaded(lllllllllllllIlIlllIlIllIIIlllll) && this.world.getChunkFromBlockCoords(lllllllllllllIlIlllIlIllIIIlllll).isLoaded())) {
                                if (!this.hasNoGravity()) {
                                    this.motionY -= 0.08;
                                }
                            }
                            else if (this.posY > 0.0) {
                                this.motionY = -0.1;
                            }
                            else {
                                this.motionY = 0.0;
                            }
                        }
                        this.motionY *= 0.9800000190734863;
                        this.motionX *= lllllllllllllIlIlllIlIllIIlIIIII;
                        this.motionZ *= lllllllllllllIlIlllIlIllIIlIIIII;
                        lllllllllllllIlIlllIlIllIIIlllll.release();
                    }
                }
                else {
                    final double lllllllllllllIlIlllIlIllIIIllIIl = this.posY;
                    this.func_191958_b(lllllllllllllIlIlllIlIllIIlIlllI, lllllllllllllIlIlllIlIllIIIIlllI, lllllllllllllIlIlllIlIllIIlIllII, 0.02f);
                    this.moveEntity(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
                    this.motionX *= 0.5;
                    this.motionY *= 0.5;
                    this.motionZ *= 0.5;
                    if (!this.hasNoGravity()) {
                        this.motionY -= 0.02;
                    }
                    if (this.isCollidedHorizontally && this.isOffsetPositionInLiquid(this.motionX, this.motionY + 0.6000000238418579 - this.posY + lllllllllllllIlIlllIlIllIIIllIIl, this.motionZ)) {
                        this.motionY = 0.30000001192092896;
                    }
                }
            }
            else {
                final double lllllllllllllIlIlllIlIllIIIllIII = this.posY;
                float lllllllllllllIlIlllIlIllIIIlIlll = this.getWaterSlowDown();
                float lllllllllllllIlIlllIlIllIIIlIllI = 0.02f;
                float lllllllllllllIlIlllIlIllIIIlIlIl = (float)EnchantmentHelper.getDepthStriderModifier(this);
                if (lllllllllllllIlIlllIlIllIIIlIlIl > 3.0f) {
                    lllllllllllllIlIlllIlIllIIIlIlIl = 3.0f;
                }
                if (!this.onGround) {
                    lllllllllllllIlIlllIlIllIIIlIlIl *= 0.5f;
                }
                if (lllllllllllllIlIlllIlIllIIIlIlIl > 0.0f) {
                    lllllllllllllIlIlllIlIllIIIlIlll += (0.54600006f - lllllllllllllIlIlllIlIllIIIlIlll) * lllllllllllllIlIlllIlIllIIIlIlIl / 3.0f;
                    lllllllllllllIlIlllIlIllIIIlIllI += (this.getAIMoveSpeed() - lllllllllllllIlIlllIlIllIIIlIllI) * lllllllllllllIlIlllIlIllIIIlIlIl / 3.0f;
                }
                this.func_191958_b(lllllllllllllIlIlllIlIllIIlIlllI, lllllllllllllIlIlllIlIllIIIIlllI, lllllllllllllIlIlllIlIllIIlIllII, lllllllllllllIlIlllIlIllIIIlIllI);
                this.moveEntity(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
                this.motionX *= lllllllllllllIlIlllIlIllIIIlIlll;
                this.motionY *= 0.800000011920929;
                this.motionZ *= lllllllllllllIlIlllIlIllIIIlIlll;
                if (!this.hasNoGravity()) {
                    this.motionY -= 0.02;
                }
                if (this.isCollidedHorizontally && this.isOffsetPositionInLiquid(this.motionX, this.motionY + 0.6000000238418579 - this.posY + lllllllllllllIlIlllIlIllIIIllIII, this.motionZ)) {
                    this.motionY = 0.30000001192092896;
                }
            }
        }
        this.prevLimbSwingAmount = this.limbSwingAmount;
        final double lllllllllllllIlIlllIlIllIIIlIlII = this.posX - this.prevPosX;
        final double lllllllllllllIlIlllIlIllIIIlIIll = this.posZ - this.prevPosZ;
        final double lllllllllllllIlIlllIlIllIIIlIIlI = (this instanceof EntityFlying) ? (this.posY - this.prevPosY) : 0.0;
        float lllllllllllllIlIlllIlIllIIIlIIIl = MathHelper.sqrt(lllllllllllllIlIlllIlIllIIIlIlII * lllllllllllllIlIlllIlIllIIIlIlII + lllllllllllllIlIlllIlIllIIIlIIlI * lllllllllllllIlIlllIlIllIIIlIIlI + lllllllllllllIlIlllIlIllIIIlIIll * lllllllllllllIlIlllIlIllIIIlIIll) * 4.0f;
        if (lllllllllllllIlIlllIlIllIIIlIIIl > 1.0f) {
            lllllllllllllIlIlllIlIllIIIlIIIl = 1.0f;
        }
        this.limbSwingAmount += (lllllllllllllIlIlllIlIllIIIlIIIl - this.limbSwingAmount) * 0.4f;
        this.limbSwing += this.limbSwingAmount;
    }
    
    protected float applyPotionDamageCalculations(final DamageSource lllllllllllllIlIlllIllIIIIlIIllI, float lllllllllllllIlIlllIllIIIIlIIlIl) {
        if (lllllllllllllIlIlllIllIIIIlIIllI.isDamageAbsolute()) {
            return lllllllllllllIlIlllIllIIIIlIIlIl;
        }
        if (this.isPotionActive(MobEffects.RESISTANCE) && lllllllllllllIlIlllIllIIIIlIIllI != DamageSource.outOfWorld) {
            final int lllllllllllllIlIlllIllIIIIlIlIll = (this.getActivePotionEffect(MobEffects.RESISTANCE).getAmplifier() + 1) * 5;
            final int lllllllllllllIlIlllIllIIIIlIlIlI = 25 - lllllllllllllIlIlllIllIIIIlIlIll;
            final float lllllllllllllIlIlllIllIIIIlIlIIl = lllllllllllllIlIlllIllIIIIlIIlIl * lllllllllllllIlIlllIllIIIIlIlIlI;
            lllllllllllllIlIlllIllIIIIlIIlIl = lllllllllllllIlIlllIllIIIIlIlIIl / 25.0f;
        }
        if (lllllllllllllIlIlllIllIIIIlIIlIl <= 0.0f) {
            return 0.0f;
        }
        final int lllllllllllllIlIlllIllIIIIlIlIII = EnchantmentHelper.getEnchantmentModifierDamage(this.getArmorInventoryList(), lllllllllllllIlIlllIllIIIIlIIllI);
        if (lllllllllllllIlIlllIllIIIIlIlIII > 0) {
            lllllllllllllIlIlllIllIIIIlIIlIl = CombatRules.getDamageAfterMagicAbsorb(lllllllllllllIlIlllIllIIIIlIIlIl, (float)lllllllllllllIlIlllIllIIIIlIlIII);
        }
        return lllllllllllllIlIlllIllIIIIlIIlIl;
    }
    
    protected void collideWithNearbyEntities() {
        final List<Entity> lllllllllllllIlIlllIlIlIlIIllIlI = this.world.getEntitiesInAABBexcluding(this, this.getEntityBoundingBox(), EntitySelectors.getTeamCollisionPredicate(this));
        if (!lllllllllllllIlIlllIlIlIlIIllIlI.isEmpty()) {
            final int lllllllllllllIlIlllIlIlIlIIllIIl = this.world.getGameRules().getInt("maxEntityCramming");
            if (lllllllllllllIlIlllIlIlIlIIllIIl > 0 && lllllllllllllIlIlllIlIlIlIIllIlI.size() > lllllllllllllIlIlllIlIlIlIIllIIl - 1 && this.rand.nextInt(4) == 0) {
                int lllllllllllllIlIlllIlIlIlIIllIII = 0;
                for (int lllllllllllllIlIlllIlIlIlIIlIlll = 0; lllllllllllllIlIlllIlIlIlIIlIlll < lllllllllllllIlIlllIlIlIlIIllIlI.size(); ++lllllllllllllIlIlllIlIlIlIIlIlll) {
                    if (!lllllllllllllIlIlllIlIlIlIIllIlI.get(lllllllllllllIlIlllIlIlIlIIlIlll).isRiding()) {
                        ++lllllllllllllIlIlllIlIlIlIIllIII;
                    }
                }
                if (lllllllllllllIlIlllIlIlIlIIllIII > lllllllllllllIlIlllIlIlIlIIllIIl - 1) {
                    this.attackEntityFrom(DamageSource.field_191291_g, 6.0f);
                }
            }
            for (int lllllllllllllIlIlllIlIlIlIIlIllI = 0; lllllllllllllIlIlllIlIlIlIIlIllI < lllllllllllllIlIlllIlIlIlIIllIlI.size(); ++lllllllllllllIlIlllIlIlIlIIlIllI) {
                final Entity lllllllllllllIlIlllIlIlIlIIlIlIl = lllllllllllllIlIlllIlIlIlIIllIlI.get(lllllllllllllIlIlllIlIlIlIIlIllI);
                this.collideWithEntity(lllllllllllllIlIlllIlIlIlIIlIlIl);
            }
        }
    }
    
    public int getRevengeTimer() {
        return this.revengeTimer;
    }
    
    @Override
    public void dismountRidingEntity() {
        final Entity lllllllllllllIlIlllIlIlIlIIIIllI = this.getRidingEntity();
        super.dismountRidingEntity();
        if (lllllllllllllIlIlllIlIlIlIIIIllI != null && lllllllllllllIlIlllIlIlIlIIIIllI != this.getRidingEntity() && !this.world.isRemote) {
            this.dismountEntity(lllllllllllllIlIlllIlIlIlIIIIllI);
        }
    }
    
    public ItemStack getHeldItem(final EnumHand lllllllllllllIlIlllIlIlllIllllll) {
        if (lllllllllllllIlIlllIlIlllIllllll == EnumHand.MAIN_HAND) {
            return this.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND);
        }
        if (lllllllllllllIlIlllIlIlllIllllll == EnumHand.OFF_HAND) {
            return this.getItemStackFromSlot(EntityEquipmentSlot.OFFHAND);
        }
        throw new IllegalArgumentException(String.valueOf(new StringBuilder("Invalid hand ").append(lllllllllllllIlIlllIlIlllIllllll)));
    }
    
    @Override
    public void onUpdate() {
        super.onUpdate();
        this.updateActiveHand();
        if (!this.world.isRemote) {
            final int lllllllllllllIlIlllIlIlIlllIIlIl = this.getArrowCountInEntity();
            if (lllllllllllllIlIlllIlIlIlllIIlIl > 0) {
                if (this.arrowHitTimer <= 0) {
                    this.arrowHitTimer = 20 * (30 - lllllllllllllIlIlllIlIlIlllIIlIl);
                }
                --this.arrowHitTimer;
                if (this.arrowHitTimer <= 0) {
                    this.setArrowCountInEntity(lllllllllllllIlIlllIlIlIlllIIlIl - 1);
                }
            }
            final EntityEquipmentSlot[] values;
            final byte lllllllllllllIlIlllIlIlIllIlIIlI = (byte)(values = EntityEquipmentSlot.values()).length;
            for (short lllllllllllllIlIlllIlIlIllIlIIll = 0; lllllllllllllIlIlllIlIlIllIlIIll < lllllllllllllIlIlllIlIlIllIlIIlI; ++lllllllllllllIlIlllIlIlIllIlIIll) {
                final EntityEquipmentSlot lllllllllllllIlIlllIlIlIlllIIlII = values[lllllllllllllIlIlllIlIlIllIlIIll];
                switch ($SWITCH_TABLE$net$minecraft$inventory$EntityEquipmentSlot$Type()[lllllllllllllIlIlllIlIlIlllIIlII.getSlotType().ordinal()]) {
                    case 1: {
                        final ItemStack lllllllllllllIlIlllIlIlIlllIIIll = this.handInventory.get(lllllllllllllIlIlllIlIlIlllIIlII.getIndex());
                        break;
                    }
                    case 2: {
                        final ItemStack lllllllllllllIlIlllIlIlIlllIIIlI = this.armorArray.get(lllllllllllllIlIlllIlIlIlllIIlII.getIndex());
                        break;
                    }
                    default: {
                        continue;
                    }
                }
                final ItemStack lllllllllllllIlIlllIlIlIlllIIIII = this.getItemStackFromSlot(lllllllllllllIlIlllIlIlIlllIIlII);
                final ItemStack lllllllllllllIlIlllIlIlIlllIIIIl;
                if (!ItemStack.areItemStacksEqual(lllllllllllllIlIlllIlIlIlllIIIII, lllllllllllllIlIlllIlIlIlllIIIIl)) {
                    ((WorldServer)this.world).getEntityTracker().sendToAllTrackingEntity(this, new SPacketEntityEquipment(this.getEntityId(), lllllllllllllIlIlllIlIlIlllIIlII, lllllllllllllIlIlllIlIlIlllIIIII));
                    if (!lllllllllllllIlIlllIlIlIlllIIIIl.func_190926_b()) {
                        this.getAttributeMap().removeAttributeModifiers(lllllllllllllIlIlllIlIlIlllIIIIl.getAttributeModifiers(lllllllllllllIlIlllIlIlIlllIIlII));
                    }
                    if (!lllllllllllllIlIlllIlIlIlllIIIII.func_190926_b()) {
                        this.getAttributeMap().applyAttributeModifiers(lllllllllllllIlIlllIlIlIlllIIIII.getAttributeModifiers(lllllllllllllIlIlllIlIlIlllIIlII));
                    }
                    switch ($SWITCH_TABLE$net$minecraft$inventory$EntityEquipmentSlot$Type()[lllllllllllllIlIlllIlIlIlllIIlII.getSlotType().ordinal()]) {
                        case 1: {
                            this.handInventory.set(lllllllllllllIlIlllIlIlIlllIIlII.getIndex(), lllllllllllllIlIlllIlIlIlllIIIII.func_190926_b() ? ItemStack.field_190927_a : lllllllllllllIlIlllIlIlIlllIIIII.copy());
                            break;
                        }
                        case 2: {
                            this.armorArray.set(lllllllllllllIlIlllIlIlIlllIIlII.getIndex(), lllllllllllllIlIlllIlIlIlllIIIII.func_190926_b() ? ItemStack.field_190927_a : lllllllllllllIlIlllIlIlIlllIIIII.copy());
                            break;
                        }
                    }
                }
            }
            if (this.ticksExisted % 20 == 0) {
                this.getCombatTracker().reset();
            }
            if (!this.glowing) {
                final boolean lllllllllllllIlIlllIlIlIllIlllll = this.isPotionActive(MobEffects.GLOWING);
                if (this.getFlag(6) != lllllllllllllIlIlllIlIlIllIlllll) {
                    this.setFlag(6, lllllllllllllIlIlllIlIlIllIlllll);
                }
            }
        }
        this.onLivingUpdate();
        final double lllllllllllllIlIlllIlIlIllIllllI = this.posX - this.prevPosX;
        final double lllllllllllllIlIlllIlIlIllIlllIl = this.posZ - this.prevPosZ;
        final float lllllllllllllIlIlllIlIlIllIlllII = (float)(lllllllllllllIlIlllIlIlIllIllllI * lllllllllllllIlIlllIlIlIllIllllI + lllllllllllllIlIlllIlIlIllIlllIl * lllllllllllllIlIlllIlIlIllIlllIl);
        float lllllllllllllIlIlllIlIlIllIllIll = this.renderYawOffset;
        float lllllllllllllIlIlllIlIlIllIllIlI = 0.0f;
        this.prevOnGroundSpeedFactor = this.onGroundSpeedFactor;
        float lllllllllllllIlIlllIlIlIllIllIIl = 0.0f;
        if (lllllllllllllIlIlllIlIlIllIlllII > 0.0025000002f) {
            lllllllllllllIlIlllIlIlIllIllIIl = 1.0f;
            lllllllllllllIlIlllIlIlIllIllIlI = (float)Math.sqrt(lllllllllllllIlIlllIlIlIllIlllII) * 3.0f;
            final float lllllllllllllIlIlllIlIlIllIllIII = (float)MathHelper.atan2(lllllllllllllIlIlllIlIlIllIlllIl, lllllllllllllIlIlllIlIlIllIllllI) * 57.295776f - 90.0f;
            final float lllllllllllllIlIlllIlIlIllIlIlll = MathHelper.abs(MathHelper.wrapDegrees(this.rotationYaw) - lllllllllllllIlIlllIlIlIllIllIII);
            if (95.0f < lllllllllllllIlIlllIlIlIllIlIlll && lllllllllllllIlIlllIlIlIllIlIlll < 265.0f) {
                lllllllllllllIlIlllIlIlIllIllIll = lllllllllllllIlIlllIlIlIllIllIII - 180.0f;
            }
            else {
                lllllllllllllIlIlllIlIlIllIllIll = lllllllllllllIlIlllIlIlIllIllIII;
            }
        }
        if (this.swingProgress > 0.0f) {
            lllllllllllllIlIlllIlIlIllIllIll = this.rotationYaw;
        }
        if (!this.onGround) {
            lllllllllllllIlIlllIlIlIllIllIIl = 0.0f;
        }
        this.onGroundSpeedFactor += (lllllllllllllIlIlllIlIlIllIllIIl - this.onGroundSpeedFactor) * 0.3f;
        this.world.theProfiler.startSection("headTurn");
        lllllllllllllIlIlllIlIlIllIllIlI = this.updateDistance(lllllllllllllIlIlllIlIlIllIllIll, lllllllllllllIlIlllIlIlIllIllIlI);
        this.world.theProfiler.endSection();
        this.world.theProfiler.startSection("rangeChecks");
        while (this.rotationYaw - this.prevRotationYaw < -180.0f) {
            this.prevRotationYaw -= 360.0f;
        }
        while (this.rotationYaw - this.prevRotationYaw >= 180.0f) {
            this.prevRotationYaw += 360.0f;
        }
        while (this.renderYawOffset - this.prevRenderYawOffset < -180.0f) {
            this.prevRenderYawOffset -= 360.0f;
        }
        while (this.renderYawOffset - this.prevRenderYawOffset >= 180.0f) {
            this.prevRenderYawOffset += 360.0f;
        }
        while (this.rotationPitch - this.prevRotationPitch < -180.0f) {
            this.prevRotationPitch -= 360.0f;
        }
        while (this.rotationPitch - this.prevRotationPitch >= 180.0f) {
            this.prevRotationPitch += 360.0f;
        }
        while (this.rotationYawHead - this.prevRotationYawHead < -180.0f) {
            this.prevRotationYawHead -= 360.0f;
        }
        while (this.rotationYawHead - this.prevRotationYawHead >= 180.0f) {
            this.prevRotationYawHead += 360.0f;
        }
        while (this.rotationPitchHead - this.prevRotationPitchHead < -180.0f) {
            this.prevRotationPitchHead -= 360.0f;
        }
        while (this.rotationPitchHead - this.prevRotationPitchHead >= 180.0f) {
            this.prevRotationPitchHead += 360.0f;
        }
        this.world.theProfiler.endSection();
        this.movedDistance += lllllllllllllIlIlllIlIlIllIllIlI;
        if (this.isElytraFlying()) {
            ++this.ticksElytraFlying;
        }
        else {
            this.ticksElytraFlying = 0;
        }
    }
    
    public void removePotionEffect(final Potion lllllllllllllIlIlllIllIlIlIlllll) {
        final PotionEffect lllllllllllllIlIlllIllIlIllIIIIl = this.removeActivePotionEffect(lllllllllllllIlIlllIllIlIlIlllll);
        if (lllllllllllllIlIlllIllIlIllIIIIl != null) {
            this.onFinishedPotionEffect(lllllllllllllIlIlllIllIlIllIIIIl);
        }
    }
    
    public boolean isChild() {
        return false;
    }
    
    protected float updateDistance(final float lllllllllllllIlIlllIlIlIllIIIlII, float lllllllllllllIlIlllIlIlIlIllllIl) {
        final float lllllllllllllIlIlllIlIlIllIIIIlI = MathHelper.wrapDegrees(lllllllllllllIlIlllIlIlIllIIIlII - this.renderYawOffset);
        this.renderYawOffset += lllllllllllllIlIlllIlIlIllIIIIlI * 0.3f;
        float lllllllllllllIlIlllIlIlIllIIIIIl = MathHelper.wrapDegrees(this.rotationYaw - this.renderYawOffset);
        final boolean lllllllllllllIlIlllIlIlIllIIIIII = lllllllllllllIlIlllIlIlIllIIIIIl < -90.0f || lllllllllllllIlIlllIlIlIllIIIIIl >= 90.0f;
        if (lllllllllllllIlIlllIlIlIllIIIIIl < -75.0f) {
            lllllllllllllIlIlllIlIlIllIIIIIl = -75.0f;
        }
        if (lllllllllllllIlIlllIlIlIllIIIIIl >= 75.0f) {
            lllllllllllllIlIlllIlIlIllIIIIIl = 75.0f;
        }
        this.renderYawOffset = this.rotationYaw - lllllllllllllIlIlllIlIlIllIIIIIl;
        if (lllllllllllllIlIlllIlIlIllIIIIIl * lllllllllllllIlIlllIlIlIllIIIIIl > 2500.0f) {
            this.renderYawOffset += lllllllllllllIlIlllIlIlIllIIIIIl * 0.2f;
        }
        if (lllllllllllllIlIlllIlIlIllIIIIII) {
            lllllllllllllIlIlllIlIlIlIllllIl *= -1.0f;
        }
        return lllllllllllllIlIlllIlIlIlIllllIl;
    }
    
    public int getAge() {
        return this.entityAge;
    }
    
    public EntityLivingBase(final World lllllllllllllIlIlllIlllIIlllllIl) {
        super(lllllllllllllIlIlllIlllIIlllllIl);
        this._combatTracker = new CombatTracker(this);
        this.activePotionsMap = (Map<Potion, PotionEffect>)Maps.newHashMap();
        this.handInventory = NonNullList.func_191197_a(2, ItemStack.field_190927_a);
        this.armorArray = NonNullList.func_191197_a(4, ItemStack.field_190927_a);
        this.maxHurtResistantTime = 20;
        this.jumpMovementFactor = 0.02f;
        this.potionsNeedUpdate = true;
        this.activeItemStack = ItemStack.field_190927_a;
        this.applyEntityAttributes();
        this.setHealth(this.getMaxHealth());
        this.preventEntitySpawning = true;
        this.randomUnused1 = (float)((Math.random() + 1.0) * 0.009999999776482582);
        this.setPosition(this.posX, this.posY, this.posZ);
        this.randomUnused2 = (float)Math.random() * 12398.0f;
        this.rotationYaw = (float)(Math.random() * 6.283185307179586);
        this.rotationYawHead = this.rotationYaw;
        this.rotationPitchHead = this.rotationPitch;
        this.stepHeight = 0.6f;
    }
    
    protected float getJumpUpwardsMotion() {
        return 0.42f;
    }
    
    @Override
    public void updateRidden() {
        super.updateRidden();
        this.prevOnGroundSpeedFactor = this.onGroundSpeedFactor;
        this.onGroundSpeedFactor = 0.0f;
        this.fallDistance = 0.0f;
    }
    
    public void dismountEntity(final Entity lllllllllllllIlIlllIlIlllIIIIIll) {
        if (!(lllllllllllllIlIlllIlIlllIIIIIll instanceof EntityBoat) && !(lllllllllllllIlIlllIlIlllIIIIIll instanceof AbstractHorse)) {
            double lllllllllllllIlIlllIlIlllIIIIIlI = lllllllllllllIlIlllIlIlllIIIIIll.posX;
            double lllllllllllllIlIlllIlIlllIIIIIIl = lllllllllllllIlIlllIlIlllIIIIIll.getEntityBoundingBox().minY + lllllllllllllIlIlllIlIlllIIIIIll.height;
            double lllllllllllllIlIlllIlIlllIIIIIII = lllllllllllllIlIlllIlIlllIIIIIll.posZ;
            final EnumFacing lllllllllllllIlIlllIlIllIlllllll = lllllllllllllIlIlllIlIlllIIIIIll.getAdjustedHorizontalFacing();
            if (lllllllllllllIlIlllIlIllIlllllll != null) {
                final EnumFacing lllllllllllllIlIlllIlIllIllllllI = lllllllllllllIlIlllIlIllIlllllll.rotateY();
                final int[][] lllllllllllllIlIlllIlIllIlllllIl = { { 0, 1 }, { 0, -1 }, { -1, 1 }, { -1, -1 }, { 1, 1 }, { 1, -1 }, { -1, 0 }, { 1, 0 }, { 0, 1 } };
                final double lllllllllllllIlIlllIlIllIlllllII = Math.floor(this.posX) + 0.5;
                final double lllllllllllllIlIlllIlIllIllllIll = Math.floor(this.posZ) + 0.5;
                final double lllllllllllllIlIlllIlIllIllllIlI = this.getEntityBoundingBox().maxX - this.getEntityBoundingBox().minX;
                final double lllllllllllllIlIlllIlIllIllllIIl = this.getEntityBoundingBox().maxZ - this.getEntityBoundingBox().minZ;
                final AxisAlignedBB lllllllllllllIlIlllIlIllIllllIII = new AxisAlignedBB(lllllllllllllIlIlllIlIllIlllllII - lllllllllllllIlIlllIlIllIllllIlI / 2.0, lllllllllllllIlIlllIlIlllIIIIIll.getEntityBoundingBox().minY, lllllllllllllIlIlllIlIllIllllIll - lllllllllllllIlIlllIlIllIllllIIl / 2.0, lllllllllllllIlIlllIlIllIlllllII + lllllllllllllIlIlllIlIllIllllIlI / 2.0, Math.floor(lllllllllllllIlIlllIlIlllIIIIIll.getEntityBoundingBox().minY) + this.height, lllllllllllllIlIlllIlIllIllllIll + lllllllllllllIlIlllIlIllIllllIIl / 2.0);
                final Exception lllllllllllllIlIlllIlIllIlIlIllI;
                final long lllllllllllllIlIlllIlIllIlIlIlll = ((int[][])(Object)(lllllllllllllIlIlllIlIllIlIlIllI = (Exception)(Object)lllllllllllllIlIlllIlIllIlllllIl)).length;
                for (byte lllllllllllllIlIlllIlIllIlIllIII = 0; lllllllllllllIlIlllIlIllIlIllIII < lllllllllllllIlIlllIlIllIlIlIlll; ++lllllllllllllIlIlllIlIllIlIllIII) {
                    final int[] lllllllllllllIlIlllIlIllIlllIlll = lllllllllllllIlIlllIlIllIlIlIllI[lllllllllllllIlIlllIlIllIlIllIII];
                    final double lllllllllllllIlIlllIlIllIlllIllI = lllllllllllllIlIlllIlIllIlllllll.getFrontOffsetX() * lllllllllllllIlIlllIlIllIlllIlll[0] + lllllllllllllIlIlllIlIllIllllllI.getFrontOffsetX() * lllllllllllllIlIlllIlIllIlllIlll[1];
                    final double lllllllllllllIlIlllIlIllIlllIlIl = lllllllllllllIlIlllIlIllIlllllll.getFrontOffsetZ() * lllllllllllllIlIlllIlIllIlllIlll[0] + lllllllllllllIlIlllIlIllIllllllI.getFrontOffsetZ() * lllllllllllllIlIlllIlIllIlllIlll[1];
                    final double lllllllllllllIlIlllIlIllIlllIlII = lllllllllllllIlIlllIlIllIlllllII + lllllllllllllIlIlllIlIllIlllIllI;
                    final double lllllllllllllIlIlllIlIllIlllIIll = lllllllllllllIlIlllIlIllIllllIll + lllllllllllllIlIlllIlIllIlllIlIl;
                    final AxisAlignedBB lllllllllllllIlIlllIlIllIlllIIlI = lllllllllllllIlIlllIlIllIllllIII.offset(lllllllllllllIlIlllIlIllIlllIllI, 0.0, lllllllllllllIlIlllIlIllIlllIlIl);
                    if (!this.world.collidesWithAnyBlock(lllllllllllllIlIlllIlIllIlllIIlI)) {
                        if (this.world.getBlockState(new BlockPos(lllllllllllllIlIlllIlIllIlllIlII, this.posY, lllllllllllllIlIlllIlIllIlllIIll)).isFullyOpaque()) {
                            this.setPositionAndUpdate(lllllllllllllIlIlllIlIllIlllIlII, this.posY + 1.0, lllllllllllllIlIlllIlIllIlllIIll);
                            return;
                        }
                        final BlockPos lllllllllllllIlIlllIlIllIlllIIIl = new BlockPos(lllllllllllllIlIlllIlIllIlllIlII, this.posY - 1.0, lllllllllllllIlIlllIlIllIlllIIll);
                        if (this.world.getBlockState(lllllllllllllIlIlllIlIllIlllIIIl).isFullyOpaque() || this.world.getBlockState(lllllllllllllIlIlllIlIllIlllIIIl).getMaterial() == Material.WATER) {
                            lllllllllllllIlIlllIlIlllIIIIIlI = lllllllllllllIlIlllIlIllIlllIlII;
                            lllllllllllllIlIlllIlIlllIIIIIIl = this.posY + 1.0;
                            lllllllllllllIlIlllIlIlllIIIIIII = lllllllllllllIlIlllIlIllIlllIIll;
                        }
                    }
                    else if (!this.world.collidesWithAnyBlock(lllllllllllllIlIlllIlIllIlllIIlI.offset(0.0, 1.0, 0.0)) && this.world.getBlockState(new BlockPos(lllllllllllllIlIlllIlIllIlllIlII, this.posY + 1.0, lllllllllllllIlIlllIlIllIlllIIll)).isFullyOpaque()) {
                        lllllllllllllIlIlllIlIlllIIIIIlI = lllllllllllllIlIlllIlIllIlllIlII;
                        lllllllllllllIlIlllIlIlllIIIIIIl = this.posY + 2.0;
                        lllllllllllllIlIlllIlIlllIIIIIII = lllllllllllllIlIlllIlIllIlllIIll;
                    }
                }
            }
            this.setPositionAndUpdate(lllllllllllllIlIlllIlIlllIIIIIlI, lllllllllllllIlIlllIlIlllIIIIIIl, lllllllllllllIlIlllIlIlllIIIIIII);
        }
        else {
            final double lllllllllllllIlIlllIlIllIlllIIII = this.width / 2.0f + lllllllllllllIlIlllIlIlllIIIIIll.width / 2.0f + 0.4;
            float lllllllllllllIlIlllIlIllIllIlllI = 0.0f;
            if (lllllllllllllIlIlllIlIlllIIIIIll instanceof EntityBoat) {
                final float lllllllllllllIlIlllIlIllIllIllll = 0.0f;
            }
            else {
                lllllllllllllIlIlllIlIllIllIlllI = 1.5707964f * ((this.getPrimaryHand() == EnumHandSide.RIGHT) ? -1 : 1);
            }
            final float lllllllllllllIlIlllIlIllIllIllIl = -MathHelper.sin(-this.rotationYaw * 0.017453292f - 3.1415927f + lllllllllllllIlIlllIlIllIllIlllI);
            final float lllllllllllllIlIlllIlIllIllIllII = -MathHelper.cos(-this.rotationYaw * 0.017453292f - 3.1415927f + lllllllllllllIlIlllIlIllIllIlllI);
            final double lllllllllllllIlIlllIlIllIllIlIll = (Math.abs(lllllllllllllIlIlllIlIllIllIllIl) > Math.abs(lllllllllllllIlIlllIlIllIllIllII)) ? (lllllllllllllIlIlllIlIllIlllIIII / Math.abs(lllllllllllllIlIlllIlIllIllIllIl)) : (lllllllllllllIlIlllIlIllIlllIIII / Math.abs(lllllllllllllIlIlllIlIllIllIllII));
            final double lllllllllllllIlIlllIlIllIllIlIlI = this.posX + lllllllllllllIlIlllIlIllIllIllIl * lllllllllllllIlIlllIlIllIllIlIll;
            final double lllllllllllllIlIlllIlIllIllIlIIl = this.posZ + lllllllllllllIlIlllIlIllIllIllII * lllllllllllllIlIlllIlIllIllIlIll;
            this.setPosition(lllllllllllllIlIlllIlIllIllIlIlI, lllllllllllllIlIlllIlIlllIIIIIll.posY + lllllllllllllIlIlllIlIlllIIIIIll.height + 0.001, lllllllllllllIlIlllIlIllIllIlIIl);
            if (this.world.collidesWithAnyBlock(this.getEntityBoundingBox())) {
                this.setPosition(lllllllllllllIlIlllIlIllIllIlIlI, lllllllllllllIlIlllIlIlllIIIIIll.posY + lllllllllllllIlIlllIlIlllIIIIIll.height + 1.001, lllllllllllllIlIlllIlIllIllIlIIl);
                if (this.world.collidesWithAnyBlock(this.getEntityBoundingBox())) {
                    this.setPosition(lllllllllllllIlIlllIlIlllIIIIIll.posX, lllllllllllllIlIlllIlIlllIIIIIll.posY + this.height + 0.001, lllllllllllllIlIlllIlIlllIIIIIll.posZ);
                }
            }
        }
    }
    
    protected void damageEntity(final DamageSource lllllllllllllIlIlllIllIIIIIllIll, float lllllllllllllIlIlllIllIIIIIlIlIl) {
        if (!this.isEntityInvulnerable(lllllllllllllIlIlllIllIIIIIllIll)) {
            lllllllllllllIlIlllIllIIIIIlIlIl = this.applyArmorCalculations(lllllllllllllIlIlllIllIIIIIllIll, lllllllllllllIlIlllIllIIIIIlIlIl);
            final float lllllllllllllIlIlllIllIIIIIllIIl;
            lllllllllllllIlIlllIllIIIIIlIlIl = (lllllllllllllIlIlllIllIIIIIllIIl = this.applyPotionDamageCalculations(lllllllllllllIlIlllIllIIIIIllIll, lllllllllllllIlIlllIllIIIIIlIlIl));
            lllllllllllllIlIlllIllIIIIIlIlIl = Math.max(lllllllllllllIlIlllIllIIIIIlIlIl - this.getAbsorptionAmount(), 0.0f);
            this.setAbsorptionAmount(this.getAbsorptionAmount() - (lllllllllllllIlIlllIllIIIIIllIIl - lllllllllllllIlIlllIllIIIIIlIlIl));
            if (lllllllllllllIlIlllIllIIIIIlIlIl != 0.0f) {
                final float lllllllllllllIlIlllIllIIIIIllIII = this.getHealth();
                this.setHealth(lllllllllllllIlIlllIllIIIIIllIII - lllllllllllllIlIlllIllIIIIIlIlIl);
                this.getCombatTracker().trackDamage(lllllllllllllIlIlllIllIIIIIllIll, lllllllllllllIlIlllIllIIIIIllIII, lllllllllllllIlIlllIllIIIIIlIlIl);
                this.setAbsorptionAmount(this.getAbsorptionAmount() - lllllllllllllIlIlllIllIIIIIlIlIl);
            }
        }
    }
    
    public boolean isHandActive() {
        return (this.dataManager.get(EntityLivingBase.HAND_STATES) & 0x1) > 0;
    }
    
    protected void damageShield(final float lllllllllllllIlIlllIllIIIIlllllI) {
    }
    
    public int getItemInUseCount() {
        return this.activeItemStackUseCount;
    }
    
    public boolean canEntityBeSeen(final Entity lllllllllllllIlIlllIlIlIIlIlIIll) {
        return this.world.rayTraceBlocks(new Vec3d(this.posX, this.posY + this.getEyeHeight(), this.posZ), new Vec3d(lllllllllllllIlIlllIlIlIIlIlIIll.posX, lllllllllllllIlIlllIlIlIIlIlIIll.posY + lllllllllllllIlIlllIlIlIIlIlIIll.getEyeHeight(), lllllllllllllIlIlllIlIlIIlIlIIll.posZ), false, true, false) == null;
    }
    
    public void setJumping(final boolean lllllllllllllIlIlllIlIlIIllIIlll) {
        this.isJumping = lllllllllllllIlIlllIlIlIIllIIlll;
    }
    
    protected void updateArmSwingProgress() {
        final int lllllllllllllIlIlllIlIllllIlIlIl = this.getArmSwingAnimationEnd();
        if (this.isSwingInProgress) {
            ++this.swingProgressInt;
            if (this.swingProgressInt >= lllllllllllllIlIlllIlIllllIlIlIl) {
                this.swingProgressInt = 0;
                this.isSwingInProgress = false;
            }
        }
        else {
            this.swingProgressInt = 0;
        }
        this.swingProgress = this.swingProgressInt / (float)lllllllllllllIlIlllIlIllllIlIlIl;
    }
    
    public boolean isElytraFlying() {
        return this.getFlag(7);
    }
    
    @Override
    protected void updateFallState(final double lllllllllllllIlIlllIlllIIllIIIll, final boolean lllllllllllllIlIlllIlllIIllIIIlI, final IBlockState lllllllllllllIlIlllIlllIIllIIIIl, final BlockPos lllllllllllllIlIlllIlllIIllIIIII) {
        if (!this.isInWater()) {
            this.handleWaterMovement();
        }
        if (!this.world.isRemote && this.fallDistance > 3.0f && lllllllllllllIlIlllIlllIIllIIIlI) {
            final float lllllllllllllIlIlllIlllIIllIIlll = (float)MathHelper.ceil(this.fallDistance - 3.0f);
            if (lllllllllllllIlIlllIlllIIllIIIIl.getMaterial() != Material.AIR) {
                final double lllllllllllllIlIlllIlllIIllIIllI = Math.min(0.2f + lllllllllllllIlIlllIlllIIllIIlll / 15.0f, 2.5);
                final int lllllllllllllIlIlllIlllIIllIIlIl = (int)(150.0 * lllllllllllllIlIlllIlllIIllIIllI);
                ((WorldServer)this.world).spawnParticle(EnumParticleTypes.BLOCK_DUST, this.posX, this.posY, this.posZ, lllllllllllllIlIlllIlllIIllIIlIl, 0.0, 0.0, 0.0, 0.15000000596046448, Block.getStateId(lllllllllllllIlIlllIlllIIllIIIIl));
            }
        }
        super.updateFallState(lllllllllllllIlIlllIlllIIllIIIll, lllllllllllllIlIlllIlllIIllIIIlI, lllllllllllllIlIlllIlllIIllIIIIl, lllllllllllllIlIlllIlllIIllIIIII);
    }
    
    protected void dropLoot(final boolean lllllllllllllIlIlllIllIIlIllIIlI, final int lllllllllllllIlIlllIllIIlIllIIIl, final DamageSource lllllllllllllIlIlllIllIIlIllIIII) {
        this.dropFewItems(lllllllllllllIlIlllIllIIlIllIIlI, lllllllllllllIlIlllIllIIlIllIIIl);
        this.dropEquipment(lllllllllllllIlIlllIllIIlIllIIlI, lllllllllllllIlIlllIllIIlIllIIIl);
    }
    
    protected float getSoundPitch() {
        return this.isChild() ? ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.5f) : ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.0f);
    }
    
    private boolean canGoThroughtTrapDoorOnLadder(final BlockPos lllllllllllllIlIlllIllIIIlllIlIl, final IBlockState lllllllllllllIlIlllIllIIIlllIIII) {
        if (lllllllllllllIlIlllIllIIIlllIIII.getValue((IProperty<Boolean>)BlockTrapDoor.OPEN)) {
            final IBlockState lllllllllllllIlIlllIllIIIlllIIll = this.world.getBlockState(lllllllllllllIlIlllIllIIIlllIlIl.down());
            if (lllllllllllllIlIlllIllIIIlllIIll.getBlock() == Blocks.LADDER && lllllllllllllIlIlllIllIIIlllIIll.getValue((IProperty<Comparable>)BlockLadder.FACING) == lllllllllllllIlIlllIllIIIlllIIII.getValue((IProperty<Comparable>)BlockTrapDoor.FACING)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isActiveItemStackBlocking() {
        if (this.isHandActive() && !this.activeItemStack.func_190926_b()) {
            final Item lllllllllllllIlIlllIlIIlllIIllII = this.activeItemStack.getItem();
            return lllllllllllllIlIlllIlIIlllIIllII.getItemUseAction(this.activeItemStack) == EnumAction.BLOCK && lllllllllllllIlIlllIlIIlllIIllII.getMaxItemUseDuration(this.activeItemStack) - this.activeItemStackUseCount >= 5;
        }
        return false;
    }
    
    public void renderBrokenItemStack(final ItemStack lllllllllllllIlIlllIllIIllIlIIll) {
        this.playSound(SoundEvents.ENTITY_ITEM_BREAK, 0.8f, 0.8f + this.world.rand.nextFloat() * 0.4f);
        for (int lllllllllllllIlIlllIllIIllIlIIlI = 0; lllllllllllllIlIlllIllIIllIlIIlI < 5; ++lllllllllllllIlIlllIllIIllIlIIlI) {
            Vec3d lllllllllllllIlIlllIllIIllIlIIIl = new Vec3d((this.rand.nextFloat() - 0.5) * 0.1, Math.random() * 0.1 + 0.1, 0.0);
            lllllllllllllIlIlllIllIIllIlIIIl = lllllllllllllIlIlllIllIIllIlIIIl.rotatePitch(-this.rotationPitch * 0.017453292f);
            lllllllllllllIlIlllIllIIllIlIIIl = lllllllllllllIlIlllIllIIllIlIIIl.rotateYaw(-this.rotationYaw * 0.017453292f);
            final double lllllllllllllIlIlllIllIIllIlIIII = -this.rand.nextFloat() * 0.6 - 0.3;
            Vec3d lllllllllllllIlIlllIllIIllIIllll = new Vec3d((this.rand.nextFloat() - 0.5) * 0.3, lllllllllllllIlIlllIllIIllIlIIII, 0.6);
            lllllllllllllIlIlllIllIIllIIllll = lllllllllllllIlIlllIllIIllIIllll.rotatePitch(-this.rotationPitch * 0.017453292f);
            lllllllllllllIlIlllIllIIllIIllll = lllllllllllllIlIlllIllIIllIIllll.rotateYaw(-this.rotationYaw * 0.017453292f);
            lllllllllllllIlIlllIllIIllIIllll = lllllllllllllIlIlllIllIIllIIllll.addVector(this.posX, this.posY + this.getEyeHeight(), this.posZ);
            this.world.spawnParticle(EnumParticleTypes.ITEM_CRACK, lllllllllllllIlIlllIllIIllIIllll.xCoord, lllllllllllllIlIlllIllIIllIIllll.yCoord, lllllllllllllIlIlllIllIIllIIllll.zCoord, lllllllllllllIlIlllIllIIllIlIIIl.xCoord, lllllllllllllIlIlllIllIIllIlIIIl.yCoord + 0.05, lllllllllllllIlIlllIllIIllIlIIIl.zCoord, Item.getIdFromItem(lllllllllllllIlIlllIllIIllIlIIll.getItem()));
        }
    }
    
    protected void onFinishedPotionEffect(final PotionEffect lllllllllllllIlIlllIllIlIlIIlIII) {
        this.potionsNeedUpdate = true;
        if (!this.world.isRemote) {
            lllllllllllllIlIlllIllIlIlIIlIII.getPotion().removeAttributesModifiersFromEntity(this, this.getAttributeMap(), lllllllllllllIlIlllIllIlIlIIlIII.getAmplifier());
        }
    }
    
    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute.UNDEFINED;
    }
    
    @Override
    public abstract void setItemStackToSlot(final EntityEquipmentSlot p0, final ItemStack p1);
    
    protected void updatePotionEffects() {
        final Iterator<Potion> lllllllllllllIlIlllIllIllIllllII = this.activePotionsMap.keySet().iterator();
        try {
            while (lllllllllllllIlIlllIllIllIllllII.hasNext()) {
                final Potion lllllllllllllIlIlllIllIllIlllIll = lllllllllllllIlIlllIllIllIllllII.next();
                final PotionEffect lllllllllllllIlIlllIllIllIlllIlI = this.activePotionsMap.get(lllllllllllllIlIlllIllIllIlllIll);
                if (!lllllllllllllIlIlllIllIllIlllIlI.onUpdate(this)) {
                    if (this.world.isRemote) {
                        continue;
                    }
                    lllllllllllllIlIlllIllIllIllllII.remove();
                    this.onFinishedPotionEffect(lllllllllllllIlIlllIllIllIlllIlI);
                }
                else {
                    if (lllllllllllllIlIlllIllIllIlllIlI.getDuration() % 600 != 0) {
                        continue;
                    }
                    this.onChangedPotionEffect(lllllllllllllIlIlllIllIllIlllIlI, false);
                }
            }
        }
        catch (ConcurrentModificationException ex) {}
        if (this.potionsNeedUpdate) {
            if (!this.world.isRemote) {
                this.updatePotionMetadata();
            }
            this.potionsNeedUpdate = false;
        }
        final int lllllllllllllIlIlllIllIllIlllIIl = this.dataManager.get(EntityLivingBase.POTION_EFFECTS);
        final boolean lllllllllllllIlIlllIllIllIlllIII = this.dataManager.get(EntityLivingBase.HIDE_PARTICLES);
        if (lllllllllllllIlIlllIllIllIlllIIl > 0) {
            boolean lllllllllllllIlIlllIllIllIllIllI = false;
            if (this.isInvisible()) {
                final boolean lllllllllllllIlIlllIllIllIllIlll = this.rand.nextInt(15) == 0;
            }
            else {
                lllllllllllllIlIlllIllIllIllIllI = this.rand.nextBoolean();
            }
            if (lllllllllllllIlIlllIllIllIlllIII) {
                lllllllllllllIlIlllIllIllIllIllI &= (this.rand.nextInt(5) == 0);
            }
            if (lllllllllllllIlIlllIllIllIllIllI && lllllllllllllIlIlllIllIllIlllIIl > 0) {
                final double lllllllllllllIlIlllIllIllIllIlIl = (lllllllllllllIlIlllIllIllIlllIIl >> 16 & 0xFF) / 255.0;
                final double lllllllllllllIlIlllIllIllIllIlII = (lllllllllllllIlIlllIllIllIlllIIl >> 8 & 0xFF) / 255.0;
                final double lllllllllllllIlIlllIllIllIllIIll = (lllllllllllllIlIlllIllIllIlllIIl >> 0 & 0xFF) / 255.0;
                this.world.spawnParticle(lllllllllllllIlIlllIllIllIlllIII ? EnumParticleTypes.SPELL_MOB_AMBIENT : EnumParticleTypes.SPELL_MOB, this.posX + (this.rand.nextDouble() - 0.5) * this.width, this.posY + this.rand.nextDouble() * this.height, this.posZ + (this.rand.nextDouble() - 0.5) * this.width, lllllllllllllIlIlllIllIllIllIlIl, lllllllllllllIlIlllIllIllIllIlII, lllllllllllllIlIlllIllIllIllIIll, new int[0]);
            }
        }
    }
    
    @Nullable
    public PotionEffect removeActivePotionEffect(@Nullable final Potion lllllllllllllIlIlllIllIlIllIlIIl) {
        return this.activePotionsMap.remove(lllllllllllllIlIlllIllIlIllIlIIl);
    }
    
    protected void applyEntityAttributes() {
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.MAX_HEALTH);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.MOVEMENT_SPEED);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ARMOR);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS);
    }
    
    public boolean canBeHitWithPotion() {
        return true;
    }
    
    public float getAbsorptionAmount() {
        return this.absorptionAmount;
    }
    
    public Map<Potion, PotionEffect> func_193076_bZ() {
        return this.activePotionsMap;
    }
    
    public int getLastAttackerTime() {
        return this.lastAttackerTime;
    }
    
    public boolean func_190631_cK() {
        return true;
    }
    
    protected void dropEquipment(final boolean lllllllllllllIlIlllIllIIlIlIlIll, final int lllllllllllllIlIlllIllIIlIlIlIlI) {
    }
    
    @Override
    public boolean getAlwaysRenderNameTagForRender() {
        return this.getAlwaysRenderNameTag();
    }
    
    public void stopActiveHand() {
        if (!this.activeItemStack.func_190926_b()) {
            this.activeItemStack.onPlayerStoppedUsing(this.world, this, this.getItemInUseCount());
        }
        this.resetActiveHand();
    }
    
    public void sendEndCombat() {
    }
    
    static {
        field_190632_a = LogManager.getLogger();
        SPRINTING_SPEED_BOOST_ID = UUID.fromString("662A6B8D-DA3E-4C1C-8813-96EA6097278D");
        SPRINTING_SPEED_BOOST = new AttributeModifier(EntityLivingBase.SPRINTING_SPEED_BOOST_ID, "Sprinting speed boost", 0.30000001192092896, 2).setSaved(false);
        HAND_STATES = EntityDataManager.createKey(EntityLivingBase.class, DataSerializers.BYTE);
        HEALTH = EntityDataManager.createKey(EntityLivingBase.class, DataSerializers.FLOAT);
        POTION_EFFECTS = EntityDataManager.createKey(EntityLivingBase.class, DataSerializers.VARINT);
        HIDE_PARTICLES = EntityDataManager.createKey(EntityLivingBase.class, DataSerializers.BOOLEAN);
        ARROW_COUNT_IN_ENTITY = EntityDataManager.createKey(EntityLivingBase.class, DataSerializers.VARINT);
    }
    
    public EntityLivingBase getLastAttacker() {
        return this.lastAttacker;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$inventory$EntityEquipmentSlot$Type() {
        final int[] $switch_TABLE$net$minecraft$inventory$EntityEquipmentSlot$Type = EntityLivingBase.$SWITCH_TABLE$net$minecraft$inventory$EntityEquipmentSlot$Type;
        if ($switch_TABLE$net$minecraft$inventory$EntityEquipmentSlot$Type != null) {
            return $switch_TABLE$net$minecraft$inventory$EntityEquipmentSlot$Type;
        }
        final byte lllllllllllllIlIlllIlIIlIllllllI = (Object)new int[EntityEquipmentSlot.Type.values().length];
        try {
            lllllllllllllIlIlllIlIIlIllllllI[EntityEquipmentSlot.Type.ARMOR.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIlIlllIlIIlIllllllI[EntityEquipmentSlot.Type.HAND.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        return EntityLivingBase.$SWITCH_TABLE$net$minecraft$inventory$EntityEquipmentSlot$Type = (int[])(Object)lllllllllllllIlIlllIlIIlIllllllI;
    }
    
    public boolean isPlayerSleeping() {
        return false;
    }
    
    protected void jump() {
        this.motionY = this.getJumpUpwardsMotion();
        if (this.isPotionActive(MobEffects.JUMP_BOOST)) {
            this.motionY += (this.getActivePotionEffect(MobEffects.JUMP_BOOST).getAmplifier() + 1) * 0.1f;
        }
        if (this.isSprinting()) {
            final float lllllllllllllIlIlllIlIllIlIIlIII = this.rotationYaw * 0.017453292f;
            this.motionX -= MathHelper.sin(lllllllllllllIlIlllIlIllIlIIlIII) * 0.2f;
            this.motionZ += MathHelper.cos(lllllllllllllIlIlllIlIllIlIIlIII) * 0.2f;
        }
        this.isAirBorne = true;
    }
    
    @Nullable
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_GENERIC_DEATH;
    }
    
    public static boolean areAllPotionsAmbient(final Collection<PotionEffect> lllllllllllllIlIlllIllIllIIlllll) {
        for (final PotionEffect lllllllllllllIlIlllIllIllIlIIIII : lllllllllllllIlIlllIllIllIIlllll) {
            if (!lllllllllllllIlIlllIllIllIlIIIII.getIsAmbient()) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public void notifyDataManagerChange(final DataParameter<?> lllllllllllllIlIlllIlIIllllllIIl) {
        super.notifyDataManagerChange(lllllllllllllIlIlllIlIIllllllIIl);
        if (EntityLivingBase.HAND_STATES.equals(lllllllllllllIlIlllIlIIllllllIIl) && this.world.isRemote) {
            if (this.isHandActive() && this.activeItemStack.func_190926_b()) {
                this.activeItemStack = this.getHeldItem(this.getActiveHand());
                if (!this.activeItemStack.func_190926_b()) {
                    this.activeItemStackUseCount = this.activeItemStack.getMaxItemUseDuration();
                }
            }
            else if (!this.isHandActive() && !this.activeItemStack.func_190926_b()) {
                this.activeItemStack = ItemStack.field_190927_a;
                this.activeItemStackUseCount = 0;
            }
        }
    }
    
    protected void playEquipSound(final ItemStack lllllllllllllIlIlllIllIlllllIIlI) {
        if (!lllllllllllllIlIlllIllIlllllIIlI.func_190926_b()) {
            SoundEvent lllllllllllllIlIlllIllIlllllIlIl = SoundEvents.ITEM_ARMOR_EQUIP_GENERIC;
            final Item lllllllllllllIlIlllIllIlllllIlII = lllllllllllllIlIlllIllIlllllIIlI.getItem();
            if (lllllllllllllIlIlllIllIlllllIlII instanceof ItemArmor) {
                lllllllllllllIlIlllIllIlllllIlIl = ((ItemArmor)lllllllllllllIlIlllIllIlllllIlII).getArmorMaterial().getSoundEvent();
            }
            else if (lllllllllllllIlIlllIllIlllllIlII == Items.ELYTRA) {
                lllllllllllllIlIlllIllIlllllIlIl = SoundEvents.field_191258_p;
            }
            this.playSound(lllllllllllllIlIlllIllIlllllIlIl, 1.0f, 1.0f);
        }
    }
    
    protected void resetPotionEffectMetadata() {
        this.dataManager.set(EntityLivingBase.HIDE_PARTICLES, false);
        this.dataManager.set(EntityLivingBase.POTION_EFFECTS, 0);
    }
    
    public abstract ItemStack getItemStackFromSlot(final EntityEquipmentSlot p0);
    
    protected float getWaterSlowDown() {
        return 0.8f;
    }
    
    public void func_191987_a(final BlockPos lllllllllllllIlIlllIlIIllIIIIIIl, final boolean lllllllllllllIlIlllIlIIllIIIIIII) {
    }
    
    protected float getSoundVolume() {
        return 1.0f;
    }
    
    @Override
    public void handleStatusUpdate(final byte lllllllllllllIlIlllIlIlllllIIIIl) {
        final boolean lllllllllllllIlIlllIlIlllllIlIlI = lllllllllllllIlIlllIlIlllllIIIIl == 33;
        final boolean lllllllllllllIlIlllIlIlllllIlIIl = lllllllllllllIlIlllIlIlllllIIIIl == 36;
        final boolean lllllllllllllIlIlllIlIlllllIlIII = lllllllllllllIlIlllIlIlllllIIIIl == 37;
        if (lllllllllllllIlIlllIlIlllllIIIIl != 2 && !lllllllllllllIlIlllIlIlllllIlIlI && !lllllllllllllIlIlllIlIlllllIlIIl && !lllllllllllllIlIlllIlIlllllIlIII) {
            if (lllllllllllllIlIlllIlIlllllIIIIl == 3) {
                final SoundEvent lllllllllllllIlIlllIlIlllllIIlll = this.getDeathSound();
                if (lllllllllllllIlIlllIlIlllllIIlll != null) {
                    this.playSound(lllllllllllllIlIlllIlIlllllIIlll, this.getSoundVolume(), (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.0f);
                }
                this.setHealth(0.0f);
                this.onDeath(DamageSource.generic);
            }
            else if (lllllllllllllIlIlllIlIlllllIIIIl == 30) {
                this.playSound(SoundEvents.ITEM_SHIELD_BREAK, 0.8f, 0.8f + this.world.rand.nextFloat() * 0.4f);
            }
            else if (lllllllllllllIlIlllIlIlllllIIIIl == 29) {
                this.playSound(SoundEvents.ITEM_SHIELD_BLOCK, 1.0f, 0.8f + this.world.rand.nextFloat() * 0.4f);
            }
            else {
                super.handleStatusUpdate(lllllllllllllIlIlllIlIlllllIIIIl);
            }
        }
        else {
            this.limbSwingAmount = 1.5f;
            this.hurtResistantTime = this.maxHurtResistantTime;
            this.maxHurtTime = 10;
            this.hurtTime = this.maxHurtTime;
            this.attackedAtYaw = 0.0f;
            if (lllllllllllllIlIlllIlIlllllIlIlI) {
                this.playSound(SoundEvents.ENCHANT_THORNS_HIT, this.getSoundVolume(), (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.0f);
            }
            DamageSource lllllllllllllIlIlllIlIlllllIIlII = null;
            if (lllllllllllllIlIlllIlIlllllIlIII) {
                final DamageSource lllllllllllllIlIlllIlIlllllIIllI = DamageSource.onFire;
            }
            else if (lllllllllllllIlIlllIlIlllllIlIIl) {
                final DamageSource lllllllllllllIlIlllIlIlllllIIlIl = DamageSource.drown;
            }
            else {
                lllllllllllllIlIlllIlIlllllIIlII = DamageSource.generic;
            }
            final SoundEvent lllllllllllllIlIlllIlIlllllIIIll = this.getHurtSound(lllllllllllllIlIlllIlIlllllIIlII);
            if (lllllllllllllIlIlllIlIlllllIIIll != null) {
                this.playSound(lllllllllllllIlIlllIlIlllllIIIll, this.getSoundVolume(), (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.0f);
            }
            this.attackEntityFrom(DamageSource.generic, 0.0f);
        }
    }
    
    private void updateElytra() {
        boolean lllllllllllllIlIlllIlIlIlIlIIllI = this.getFlag(7);
        if (lllllllllllllIlIlllIlIlIlIlIIllI && !this.onGround && !this.isRiding()) {
            final ItemStack lllllllllllllIlIlllIlIlIlIlIIlIl = this.getItemStackFromSlot(EntityEquipmentSlot.CHEST);
            if (lllllllllllllIlIlllIlIlIlIlIIlIl.getItem() == Items.ELYTRA && ItemElytra.isBroken(lllllllllllllIlIlllIlIlIlIlIIlIl)) {
                lllllllllllllIlIlllIlIlIlIlIIllI = true;
                if (!this.world.isRemote && (this.ticksElytraFlying + 1) % 20 == 0) {
                    lllllllllllllIlIlllIlIlIlIlIIlIl.damageItem(1, this);
                }
            }
            else {
                lllllllllllllIlIlllIlIlIlIlIIllI = false;
            }
        }
        else {
            lllllllllllllIlIlllIlIlIlIlIIllI = false;
        }
        if (!this.world.isRemote) {
            this.setFlag(7, lllllllllllllIlIlllIlIlIlIlIIllI);
        }
    }
    
    public Collection<PotionEffect> getActivePotionEffects() {
        return this.activePotionsMap.values();
    }
    
    public void writeEntityToNBT(final NBTTagCompound lllllllllllllIlIlllIllIllllIIlll) {
        lllllllllllllIlIlllIllIllllIIlll.setFloat("Health", this.getHealth());
        lllllllllllllIlIlllIllIllllIIlll.setShort("HurtTime", (short)this.hurtTime);
        lllllllllllllIlIlllIllIllllIIlll.setInteger("HurtByTimestamp", this.revengeTimer);
        lllllllllllllIlIlllIllIllllIIlll.setShort("DeathTime", (short)this.deathTime);
        lllllllllllllIlIlllIllIllllIIlll.setFloat("AbsorptionAmount", this.getAbsorptionAmount());
        int lllllllllllllIlIlllIllIlllIllIll;
        for (byte lllllllllllllIlIlllIllIlllIlllII = (byte)((EntityEquipmentSlot[])(Object)(lllllllllllllIlIlllIllIlllIllIll = (int)(Object)EntityEquipmentSlot.values())).length, b = 0; b < lllllllllllllIlIlllIllIlllIlllII; ++b) {
            final EntityEquipmentSlot lllllllllllllIlIlllIllIllllIIllI = lllllllllllllIlIlllIllIlllIllIll[b];
            final ItemStack lllllllllllllIlIlllIllIllllIIlIl = this.getItemStackFromSlot(lllllllllllllIlIlllIllIllllIIllI);
            if (!lllllllllllllIlIlllIllIllllIIlIl.func_190926_b()) {
                this.getAttributeMap().removeAttributeModifiers(lllllllllllllIlIlllIllIllllIIlIl.getAttributeModifiers(lllllllllllllIlIlllIllIllllIIllI));
            }
        }
        lllllllllllllIlIlllIllIllllIIlll.setTag("Attributes", SharedMonsterAttributes.writeBaseAttributeMapToNBT(this.getAttributeMap()));
        for (byte lllllllllllllIlIlllIllIlllIlllII = (byte)((EntityEquipmentSlot[])(Object)(lllllllllllllIlIlllIllIlllIllIll = (int)(Object)EntityEquipmentSlot.values())).length, b2 = 0; b2 < lllllllllllllIlIlllIllIlllIlllII; ++b2) {
            final EntityEquipmentSlot lllllllllllllIlIlllIllIllllIIlII = lllllllllllllIlIlllIllIlllIllIll[b2];
            final ItemStack lllllllllllllIlIlllIllIllllIIIll = this.getItemStackFromSlot(lllllllllllllIlIlllIllIllllIIlII);
            if (!lllllllllllllIlIlllIllIllllIIIll.func_190926_b()) {
                this.getAttributeMap().applyAttributeModifiers(lllllllllllllIlIlllIllIllllIIIll.getAttributeModifiers(lllllllllllllIlIlllIllIllllIIlII));
            }
        }
        if (!this.activePotionsMap.isEmpty()) {
            final NBTTagList lllllllllllllIlIlllIllIllllIIIlI = new NBTTagList();
            for (final PotionEffect lllllllllllllIlIlllIllIllllIIIIl : this.activePotionsMap.values()) {
                lllllllllllllIlIlllIllIllllIIIlI.appendTag(lllllllllllllIlIlllIllIllllIIIIl.writeCustomPotionEffectToNBT(new NBTTagCompound()));
            }
            lllllllllllllIlIlllIllIllllIIlll.setTag("ActiveEffects", lllllllllllllIlIlllIllIllllIIIlI);
        }
        lllllllllllllIlIlllIllIllllIIlll.setBoolean("FallFlying", this.isElytraFlying());
    }
    
    public float getSwingProgress(final float lllllllllllllIlIlllIlIlIIIllllll) {
        float lllllllllllllIlIlllIlIlIIlIIIIIl = this.swingProgress - this.prevSwingProgress;
        if (lllllllllllllIlIlllIlIlIIlIIIIIl < 0.0f) {
            ++lllllllllllllIlIlllIlIlIIlIIIIIl;
        }
        return this.prevSwingProgress + lllllllllllllIlIlllIlIlIIlIIIIIl * lllllllllllllIlIlllIlIlIIIllllll;
    }
    
    protected void frostWalk(final BlockPos lllllllllllllIlIlllIlllIIIllllII) {
        final int lllllllllllllIlIlllIlllIIIlllllI = EnchantmentHelper.getMaxEnchantmentLevel(Enchantments.FROST_WALKER, this);
        if (lllllllllllllIlIlllIlllIIIlllllI > 0) {
            EnchantmentFrostWalker.freezeNearby(this, this.world, lllllllllllllIlIlllIlllIIIllllII, lllllllllllllIlIlllIlllIIIlllllI);
        }
    }
    
    protected void onNewPotionEffect(final PotionEffect lllllllllllllIlIlllIllIlIlIllIlI) {
        this.potionsNeedUpdate = true;
        if (!this.world.isRemote) {
            lllllllllllllIlIlllIllIlIlIllIlI.getPotion().applyAttributesModifiersToEntity(this, this.getAttributeMap(), lllllllllllllIlIlllIllIlIlIllIlI.getAmplifier());
        }
    }
    
    public boolean isEntityUndead() {
        return this.getCreatureAttribute() == EnumCreatureAttribute.UNDEAD;
    }
    
    protected void updatePotionMetadata() {
        if (this.activePotionsMap.isEmpty()) {
            this.resetPotionEffectMetadata();
            this.setInvisible(false);
        }
        else {
            final Collection<PotionEffect> lllllllllllllIlIlllIllIllIlIIlll = this.activePotionsMap.values();
            this.dataManager.set(EntityLivingBase.HIDE_PARTICLES, areAllPotionsAmbient(lllllllllllllIlIlllIllIllIlIIlll));
            this.dataManager.set(EntityLivingBase.POTION_EFFECTS, PotionUtils.getPotionColorFromEffectList(lllllllllllllIlIlllIllIllIlIIlll));
            this.setInvisible(this.isPotionActive(MobEffects.INVISIBILITY));
        }
    }
    
    public abstract EnumHandSide getPrimaryHand();
    
    @Override
    public void setPositionAndRotationDirect(final double lllllllllllllIlIlllIlIlIIllllIII, final double lllllllllllllIlIlllIlIlIIlllIlll, final double lllllllllllllIlIlllIlIlIIlllIllI, final float lllllllllllllIlIlllIlIlIIllIllIl, final float lllllllllllllIlIlllIlIlIIlllIlII, final int lllllllllllllIlIlllIlIlIIllIlIll, final boolean lllllllllllllIlIlllIlIlIIlllIIlI) {
        this.interpTargetX = lllllllllllllIlIlllIlIlIIllllIII;
        this.interpTargetY = lllllllllllllIlIlllIlIlIIlllIlll;
        this.interpTargetZ = lllllllllllllIlIlllIlIlIIlllIllI;
        this.interpTargetYaw = lllllllllllllIlIlllIlIlIIllIllIl;
        this.interpTargetPitch = lllllllllllllIlIlllIlIlIIlllIlII;
        this.newPosRotationIncrements = lllllllllllllIlIlllIlIlIIllIlIll;
    }
    
    public ItemStack getHeldItemOffhand() {
        return this.getItemStackFromSlot(EntityEquipmentSlot.OFFHAND);
    }
    
    private boolean func_190628_d(final DamageSource lllllllllllllIlIlllIllIlIIIIIIlI) {
        if (lllllllllllllIlIlllIllIlIIIIIIlI.canHarmInCreative()) {
            return false;
        }
        ItemStack lllllllllllllIlIlllIllIlIIIIIIIl = null;
        final boolean lllllllllllllIlIlllIllIIllllIlll;
        final String lllllllllllllIlIlllIllIIlllllIII = (String)((EnumHand[])(Object)(lllllllllllllIlIlllIllIIllllIlll = (boolean)(Object)EnumHand.values())).length;
        for (short lllllllllllllIlIlllIllIIlllllIIl = 0; lllllllllllllIlIlllIllIIlllllIIl < lllllllllllllIlIlllIllIIlllllIII; ++lllllllllllllIlIlllIllIIlllllIIl) {
            final EnumHand lllllllllllllIlIlllIllIlIIIIIIII = lllllllllllllIlIlllIllIIllllIlll[lllllllllllllIlIlllIllIIlllllIIl];
            final ItemStack lllllllllllllIlIlllIllIIllllllll = this.getHeldItem(lllllllllllllIlIlllIllIlIIIIIIII);
            if (lllllllllllllIlIlllIllIIllllllll.getItem() == Items.field_190929_cY) {
                lllllllllllllIlIlllIllIlIIIIIIIl = lllllllllllllIlIlllIllIIllllllll.copy();
                lllllllllllllIlIlllIllIIllllllll.func_190918_g(1);
                break;
            }
        }
        if (lllllllllllllIlIlllIllIlIIIIIIIl != null) {
            if (this instanceof EntityPlayerMP) {
                final EntityPlayerMP lllllllllllllIlIlllIllIIlllllllI = (EntityPlayerMP)this;
                lllllllllllllIlIlllIllIIlllllllI.addStat(StatList.getObjectUseStats(Items.field_190929_cY));
                CriteriaTriggers.field_193130_A.func_193187_a(lllllllllllllIlIlllIllIIlllllllI, lllllllllllllIlIlllIllIlIIIIIIIl);
            }
            this.setHealth(1.0f);
            this.clearActivePotions();
            this.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 900, 1));
            this.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 100, 1));
            this.world.setEntityState(this, (byte)35);
        }
        return lllllllllllllIlIlllIllIlIIIIIIIl != null;
    }
    
    protected int decreaseAirSupply(final int lllllllllllllIlIlllIlllIIIlIIIIl) {
        final int lllllllllllllIlIlllIlllIIIlIIIII = EnchantmentHelper.getRespirationModifier(this);
        return (lllllllllllllIlIlllIlllIIIlIIIII > 0 && this.rand.nextInt(lllllllllllllIlIlllIlllIIIlIIIII + 1) > 0) ? lllllllllllllIlIlllIlllIIIlIIIIl : (lllllllllllllIlIlllIlllIIIlIIIIl - 1);
    }
    
    public void onDeath(final DamageSource lllllllllllllIlIlllIllIIllIIIIIl) {
        if (!this.dead) {
            final Entity lllllllllllllIlIlllIllIIllIIIIII = lllllllllllllIlIlllIllIIllIIIIIl.getEntity();
            final EntityLivingBase lllllllllllllIlIlllIllIIlIllllll = this.getAttackingEntity();
            if (this.scoreValue >= 0 && lllllllllllllIlIlllIllIIlIllllll != null) {
                lllllllllllllIlIlllIllIIlIllllll.func_191956_a(this, this.scoreValue, lllllllllllllIlIlllIllIIllIIIIIl);
            }
            if (lllllllllllllIlIlllIllIIllIIIIII != null) {
                lllllllllllllIlIlllIllIIllIIIIII.onKillEntity(this);
            }
            this.dead = true;
            this.getCombatTracker().reset();
            if (!this.world.isRemote) {
                int lllllllllllllIlIlllIllIIlIlllllI = 0;
                if (lllllllllllllIlIlllIllIIllIIIIII instanceof EntityPlayer) {
                    lllllllllllllIlIlllIllIIlIlllllI = EnchantmentHelper.getLootingModifier((EntityLivingBase)lllllllllllllIlIlllIllIIllIIIIII);
                }
                if (this.canDropLoot() && this.world.getGameRules().getBoolean("doMobLoot")) {
                    final boolean lllllllllllllIlIlllIllIIlIllllIl = this.recentlyHit > 0;
                    this.dropLoot(lllllllllllllIlIlllIllIIlIllllIl, lllllllllllllIlIlllIllIIlIlllllI, lllllllllllllIlIlllIllIIllIIIIIl);
                }
            }
            this.world.setEntityState(this, (byte)3);
        }
    }
    
    @Override
    public boolean isEntityAlive() {
        return !this.isDead && this.getHealth() > 0.0f;
    }
    
    protected void handleJumpLava() {
        this.motionY += 0.03999999910593033;
    }
    
    protected void onItemUseFinish() {
        if (!this.activeItemStack.func_190926_b() && this.isHandActive()) {
            this.updateItemUse(this.activeItemStack, 16);
            this.setHeldItem(this.getActiveHand(), this.activeItemStack.onItemUseFinish(this.world, this));
            this.resetActiveHand();
        }
    }
    
    public void setLastAttacker(final Entity lllllllllllllIlIlllIllIlllllllll) {
        if (lllllllllllllIlIlllIllIlllllllll instanceof EntityLivingBase) {
            this.lastAttacker = (EntityLivingBase)lllllllllllllIlIlllIllIlllllllll;
        }
        else {
            this.lastAttacker = null;
        }
        this.lastAttackerTime = this.ticksExisted;
    }
    
    @Override
    public boolean canBePushed() {
        return (!Main.moduleManager.getModule(NoPush.class).isToggled() || !NoPush.players.getValBoolean()) && (this.isEntityAlive() && !this.isOnLadder());
    }
    
    @Override
    public void fall(final float lllllllllllllIlIlllIllIIIlIlIlII, final float lllllllllllllIlIlllIllIIIlIlIIll) {
        super.fall(lllllllllllllIlIlllIllIIIlIlIlII, lllllllllllllIlIlllIllIIIlIlIIll);
        final PotionEffect lllllllllllllIlIlllIllIIIlIlllIl = this.getActivePotionEffect(MobEffects.JUMP_BOOST);
        final float lllllllllllllIlIlllIllIIIlIlllII = (lllllllllllllIlIlllIllIIIlIlllIl == null) ? 0.0f : ((float)(lllllllllllllIlIlllIllIIIlIlllIl.getAmplifier() + 1));
        final int lllllllllllllIlIlllIllIIIlIllIll = MathHelper.ceil((lllllllllllllIlIlllIllIIIlIlIlII - 3.0f - lllllllllllllIlIlllIllIIIlIlllII) * lllllllllllllIlIlllIllIIIlIlIIll);
        if (lllllllllllllIlIlllIllIIIlIllIll > 0) {
            this.playSound(this.getFallSound(lllllllllllllIlIlllIllIIIlIllIll), 1.0f, 1.0f);
            this.attackEntityFrom(DamageSource.fall, (float)lllllllllllllIlIlllIllIIIlIllIll);
            final int lllllllllllllIlIlllIllIIIlIllIlI = MathHelper.floor(this.posX);
            final int lllllllllllllIlIlllIllIIIlIllIIl = MathHelper.floor(this.posY - 0.20000000298023224);
            final int lllllllllllllIlIlllIllIIIlIllIII = MathHelper.floor(this.posZ);
            final IBlockState lllllllllllllIlIlllIllIIIlIlIlll = this.world.getBlockState(new BlockPos(lllllllllllllIlIlllIllIIIlIllIlI, lllllllllllllIlIlllIllIIIlIllIIl, lllllllllllllIlIlllIllIIIlIllIII));
            if (lllllllllllllIlIlllIllIIIlIlIlll.getMaterial() != Material.AIR) {
                final SoundType lllllllllllllIlIlllIllIIIlIlIllI = lllllllllllllIlIlllIllIIIlIlIlll.getBlock().getSoundType();
                this.playSound(lllllllllllllIlIlllIllIIIlIlIllI.getFallSound(), lllllllllllllIlIlllIllIIIlIlIllI.getVolume() * 0.5f, lllllllllllllIlIlllIllIIIlIlIllI.getPitch() * 0.75f);
            }
        }
    }
    
    protected void collideWithEntity(final Entity lllllllllllllIlIlllIlIlIlIIIlIlI) {
        lllllllllllllIlIlllIlIlIlIIIlIlI.applyEntityCollision(this);
    }
    
    protected float applyArmorCalculations(final DamageSource lllllllllllllIlIlllIllIIIIlllIIl, float lllllllllllllIlIlllIllIIIIllIlIl) {
        if (!lllllllllllllIlIlllIllIIIIlllIIl.isUnblockable()) {
            this.damageArmor(lllllllllllllIlIlllIllIIIIllIlIl);
            lllllllllllllIlIlllIllIIIIllIlIl = CombatRules.getDamageAfterAbsorb(lllllllllllllIlIlllIllIIIIllIlIl, (float)this.getTotalArmorValue(), (float)this.getEntityAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).getAttributeValue());
        }
        return lllllllllllllIlIlllIllIIIIllIlIl;
    }
    
    protected void dropFewItems(final boolean lllllllllllllIlIlllIllIIlIIlIIIl, final int lllllllllllllIlIlllIllIIlIIlIIII) {
    }
    
    protected void updateEntityActionState() {
    }
    
    public void onLivingUpdate() {
        if (this.jumpTicks > 0) {
            --this.jumpTicks;
        }
        if (this.newPosRotationIncrements > 0 && !this.canPassengerSteer()) {
            final double lllllllllllllIlIlllIlIlIlIllIIll = this.posX + (this.interpTargetX - this.posX) / this.newPosRotationIncrements;
            final double lllllllllllllIlIlllIlIlIlIllIIlI = this.posY + (this.interpTargetY - this.posY) / this.newPosRotationIncrements;
            final double lllllllllllllIlIlllIlIlIlIllIIIl = this.posZ + (this.interpTargetZ - this.posZ) / this.newPosRotationIncrements;
            final double lllllllllllllIlIlllIlIlIlIllIIII = MathHelper.wrapDegrees(this.interpTargetYaw - this.rotationYaw);
            this.rotationYaw += (float)(lllllllllllllIlIlllIlIlIlIllIIII / this.newPosRotationIncrements);
            this.rotationPitch += (float)((this.interpTargetPitch - this.rotationPitch) / this.newPosRotationIncrements);
            --this.newPosRotationIncrements;
            this.setPosition(lllllllllllllIlIlllIlIlIlIllIIll, lllllllllllllIlIlllIlIlIlIllIIlI, lllllllllllllIlIlllIlIlIlIllIIIl);
            this.setRotation(this.rotationYaw, this.rotationPitch);
        }
        else if (!this.isServerWorld()) {
            this.motionX *= 0.98;
            this.motionY *= 0.98;
            this.motionZ *= 0.98;
        }
        if (Math.abs(this.motionX) < 0.003) {
            this.motionX = 0.0;
        }
        if (Math.abs(this.motionY) < 0.003) {
            this.motionY = 0.0;
        }
        if (Math.abs(this.motionZ) < 0.003) {
            this.motionZ = 0.0;
        }
        this.world.theProfiler.startSection("ai");
        if (this.isMovementBlocked()) {
            this.isJumping = false;
            this.moveStrafing = 0.0f;
            this.field_191988_bg = 0.0f;
            this.randomYawVelocity = 0.0f;
        }
        else if (this.isServerWorld()) {
            this.world.theProfiler.startSection("newAi");
            this.updateEntityActionState();
            this.world.theProfiler.endSection();
        }
        this.world.theProfiler.endSection();
        this.world.theProfiler.startSection("jump");
        if (this.isJumping) {
            if (this.isInWater()) {
                this.handleJumpWater();
            }
            else if (this.isInLava()) {
                this.handleJumpLava();
            }
            else if (this.onGround && this.jumpTicks == 0) {
                this.jump();
                this.jumpTicks = 10;
            }
        }
        else {
            this.jumpTicks = 0;
        }
        this.world.theProfiler.endSection();
        this.world.theProfiler.startSection("travel");
        this.moveStrafing *= 0.98f;
        this.field_191988_bg *= 0.98f;
        this.randomYawVelocity *= 0.9f;
        this.updateElytra();
        this.func_191986_a(this.moveStrafing, this.moveForward, this.field_191988_bg);
        this.world.theProfiler.endSection();
        this.world.theProfiler.startSection("push");
        this.collideWithNearbyEntities();
        this.world.theProfiler.endSection();
    }
    
    @Nullable
    public PotionEffect getActivePotionEffect(final Potion lllllllllllllIlIlllIllIllIIIIIlI) {
        return this.activePotionsMap.get(lllllllllllllIlIlllIllIllIIIIIlI);
    }
    
    @Override
    public void performHurtAnimation() {
        this.maxHurtTime = 10;
        this.hurtTime = this.maxHurtTime;
        this.attackedAtYaw = 0.0f;
    }
    
    protected void onDeathUpdate() {
        ++this.deathTime;
        if (this.deathTime == 20) {
            if (!this.world.isRemote && (this.isPlayer() || (this.recentlyHit > 0 && this.canDropLoot() && this.world.getGameRules().getBoolean("doMobLoot")))) {
                int lllllllllllllIlIlllIlllIIIllIIll = this.getExperiencePoints(this.attackingPlayer);
                while (lllllllllllllIlIlllIlllIIIllIIll > 0) {
                    final int lllllllllllllIlIlllIlllIIIllIIlI = EntityXPOrb.getXPSplit(lllllllllllllIlIlllIlllIIIllIIll);
                    lllllllllllllIlIlllIlllIIIllIIll -= lllllllllllllIlIlllIlllIIIllIIlI;
                    this.world.spawnEntityInWorld(new EntityXPOrb(this.world, this.posX, this.posY, this.posZ, lllllllllllllIlIlllIlllIIIllIIlI));
                }
            }
            this.setDead();
            for (int lllllllllllllIlIlllIlllIIIllIIIl = 0; lllllllllllllIlIlllIlllIIIllIIIl < 20; ++lllllllllllllIlIlllIlllIIIllIIIl) {
                final double lllllllllllllIlIlllIlllIIIllIIII = this.rand.nextGaussian() * 0.02;
                final double lllllllllllllIlIlllIlllIIIlIllll = this.rand.nextGaussian() * 0.02;
                final double lllllllllllllIlIlllIlllIIIlIlllI = this.rand.nextGaussian() * 0.02;
                this.world.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, this.posX + this.rand.nextFloat() * this.width * 2.0f - this.width, this.posY + this.rand.nextFloat() * this.height, this.posZ + this.rand.nextFloat() * this.width * 2.0f - this.width, lllllllllllllIlIlllIlllIIIllIIII, lllllllllllllIlIlllIlllIIIlIllll, lllllllllllllIlIlllIlllIIIlIlllI, new int[0]);
            }
        }
    }
    
    private int getArmSwingAnimationEnd() {
        if (this.isPotionActive(MobEffects.HASTE)) {
            final int lllllllllllllIlIlllIlIllllllllIl = (int)(Main.moduleManager.getModule(Animation.class).isToggled() ? Animation.animation.getValDouble() : 6.0);
            return lllllllllllllIlIlllIlIllllllllIl - (1 + this.getActivePotionEffect(MobEffects.HASTE).getAmplifier());
        }
        final int lllllllllllllIlIlllIlIllllllllII = (int)(Main.moduleManager.getModule(Animation.class).isToggled() ? Animation.animation.getValDouble() : 6.0);
        return this.isPotionActive(MobEffects.MINING_FATIGUE) ? (lllllllllllllIlIlllIlIllllllllII + (1 + this.getActivePotionEffect(MobEffects.MINING_FATIGUE).getAmplifier()) * 2) : lllllllllllllIlIlllIlIllllllllII;
    }
    
    public boolean isOnLadder() {
        final int lllllllllllllIlIlllIllIIlIIIIlll = MathHelper.floor(this.posX);
        final int lllllllllllllIlIlllIllIIlIIIIllI = MathHelper.floor(this.getEntityBoundingBox().minY);
        final int lllllllllllllIlIlllIllIIlIIIIlIl = MathHelper.floor(this.posZ);
        if (this instanceof EntityPlayer && ((EntityPlayer)this).isSpectator()) {
            return false;
        }
        final BlockPos lllllllllllllIlIlllIllIIlIIIIlII = new BlockPos(lllllllllllllIlIlllIllIIlIIIIlll, lllllllllllllIlIlllIllIIlIIIIllI, lllllllllllllIlIlllIllIIlIIIIlIl);
        final IBlockState lllllllllllllIlIlllIllIIlIIIIIll = this.world.getBlockState(lllllllllllllIlIlllIllIIlIIIIlII);
        final Block lllllllllllllIlIlllIllIIlIIIIIlI = lllllllllllllIlIlllIllIIlIIIIIll.getBlock();
        return lllllllllllllIlIlllIllIIlIIIIIlI == Blocks.LADDER || lllllllllllllIlIlllIllIIlIIIIIlI == Blocks.VINE || (lllllllllllllIlIlllIllIIlIIIIIlI instanceof BlockTrapDoor && this.canGoThroughtTrapDoorOnLadder(lllllllllllllIlIlllIllIIlIIIIlII, lllllllllllllIlIlllIllIIlIIIIIll));
    }
    
    protected void updateItemUse(final ItemStack lllllllllllllIlIlllIlIIllllIlllI, final int lllllllllllllIlIlllIlIIllllIIllI) {
        if (!lllllllllllllIlIlllIlIIllllIlllI.func_190926_b() && this.isHandActive()) {
            if (lllllllllllllIlIlllIlIIllllIlllI.getItemUseAction() == EnumAction.DRINK) {
                this.playSound(SoundEvents.ENTITY_GENERIC_DRINK, 0.5f, this.world.rand.nextFloat() * 0.1f + 0.9f);
            }
            if (lllllllllllllIlIlllIlIIllllIlllI.getItemUseAction() == EnumAction.EAT) {
                for (int lllllllllllllIlIlllIlIIllllIllII = 0; lllllllllllllIlIlllIlIIllllIllII < lllllllllllllIlIlllIlIIllllIIllI; ++lllllllllllllIlIlllIlIIllllIllII) {
                    Vec3d lllllllllllllIlIlllIlIIllllIlIll = new Vec3d((this.rand.nextFloat() - 0.5) * 0.1, Math.random() * 0.1 + 0.1, 0.0);
                    lllllllllllllIlIlllIlIIllllIlIll = lllllllllllllIlIlllIlIIllllIlIll.rotatePitch(-this.rotationPitch * 0.017453292f);
                    lllllllllllllIlIlllIlIIllllIlIll = lllllllllllllIlIlllIlIIllllIlIll.rotateYaw(-this.rotationYaw * 0.017453292f);
                    final double lllllllllllllIlIlllIlIIllllIlIlI = -this.rand.nextFloat() * 0.6 - 0.3;
                    Vec3d lllllllllllllIlIlllIlIIllllIlIIl = new Vec3d((this.rand.nextFloat() - 0.5) * 0.3, lllllllllllllIlIlllIlIIllllIlIlI, 0.6);
                    lllllllllllllIlIlllIlIIllllIlIIl = lllllllllllllIlIlllIlIIllllIlIIl.rotatePitch(-this.rotationPitch * 0.017453292f);
                    lllllllllllllIlIlllIlIIllllIlIIl = lllllllllllllIlIlllIlIIllllIlIIl.rotateYaw(-this.rotationYaw * 0.017453292f);
                    lllllllllllllIlIlllIlIIllllIlIIl = lllllllllllllIlIlllIlIIllllIlIIl.addVector(this.posX, this.posY + this.getEyeHeight(), this.posZ);
                    if (lllllllllllllIlIlllIlIIllllIlllI.getHasSubtypes()) {
                        this.world.spawnParticle(EnumParticleTypes.ITEM_CRACK, lllllllllllllIlIlllIlIIllllIlIIl.xCoord, lllllllllllllIlIlllIlIIllllIlIIl.yCoord, lllllllllllllIlIlllIlIIllllIlIIl.zCoord, lllllllllllllIlIlllIlIIllllIlIll.xCoord, lllllllllllllIlIlllIlIIllllIlIll.yCoord + 0.05, lllllllllllllIlIlllIlIIllllIlIll.zCoord, Item.getIdFromItem(lllllllllllllIlIlllIlIIllllIlllI.getItem()), lllllllllllllIlIlllIlIIllllIlllI.getMetadata());
                    }
                    else {
                        this.world.spawnParticle(EnumParticleTypes.ITEM_CRACK, lllllllllllllIlIlllIlIIllllIlIIl.xCoord, lllllllllllllIlIlllIlIIllllIlIIl.yCoord, lllllllllllllIlIlllIlIIllllIlIIl.zCoord, lllllllllllllIlIlllIlIIllllIlIll.xCoord, lllllllllllllIlIlllIlIIllllIlIll.yCoord + 0.05, lllllllllllllIlIlllIlIIllllIlIll.zCoord, Item.getIdFromItem(lllllllllllllIlIlllIlIIllllIlllI.getItem()));
                    }
                }
                this.playSound(SoundEvents.ENTITY_GENERIC_EAT, 0.5f + 0.5f * this.rand.nextInt(2), (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.0f);
            }
        }
    }
    
    @Override
    public abstract Iterable<ItemStack> getArmorInventoryList();
    
    @Nullable
    public DamageSource getLastDamageSource() {
        if (this.world.getTotalWorldTime() - this.lastDamageStamp > 40L) {
            this.lastDamageSource = null;
        }
        return this.lastDamageSource;
    }
    
    protected boolean canDropLoot() {
        return !this.isChild();
    }
    
    public final float getHealth() {
        return this.dataManager.get(EntityLivingBase.HEALTH);
    }
    
    public IAttributeInstance getEntityAttribute(final IAttribute lllllllllllllIlIlllIlIllllIIllll) {
        return this.getAttributeMap().getAttributeInstance(lllllllllllllIlIlllIlIllllIIllll);
    }
    
    public void setAbsorptionAmount(float lllllllllllllIlIlllIlIlIIIIllIlI) {
        if (lllllllllllllIlIlllIlIlIIIIllIlI < 0.0f) {
            lllllllllllllIlIlllIlIlIIIIllIlI = 0.0f;
        }
        this.absorptionAmount = (float)lllllllllllllIlIlllIlIlIIIIllIlI;
    }
    
    protected void markPotionsDirty() {
        this.potionsNeedUpdate = true;
    }
    
    public void setActiveHand(final EnumHand lllllllllllllIlIlllIlIIlllllllll) {
        final ItemStack lllllllllllllIlIlllIlIlIIIIIIIlI = this.getHeldItem(lllllllllllllIlIlllIlIIlllllllll);
        if (!lllllllllllllIlIlllIlIlIIIIIIIlI.func_190926_b() && !this.isHandActive()) {
            this.activeItemStack = lllllllllllllIlIlllIlIlIIIIIIIlI;
            this.activeItemStackUseCount = lllllllllllllIlIlllIlIlIIIIIIIlI.getMaxItemUseDuration();
            if (!this.world.isRemote) {
                int lllllllllllllIlIlllIlIlIIIIIIIIl = 1;
                if (lllllllllllllIlIlllIlIIlllllllll == EnumHand.OFF_HAND) {
                    lllllllllllllIlIlllIlIlIIIIIIIIl |= 0x2;
                }
                this.dataManager.set(EntityLivingBase.HAND_STATES, (byte)lllllllllllllIlIlllIlIlIIIIIIIIl);
            }
        }
    }
}
