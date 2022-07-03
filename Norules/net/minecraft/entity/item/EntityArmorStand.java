package net.minecraft.entity.item;

import com.google.common.base.*;
import net.minecraft.inventory.*;
import net.minecraft.entity.*;
import net.minecraft.nbt.*;
import net.minecraft.block.material.*;
import net.minecraft.network.datasync.*;
import javax.annotation.*;
import net.minecraft.util.datafix.walkers.*;
import net.minecraft.util.datafix.*;
import net.minecraft.entity.player.*;
import java.util.*;
import net.minecraft.entity.effect.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.init.*;
import net.minecraft.util.*;

public class EntityArmorStand extends EntityLivingBase
{
    private /* synthetic */ Rotations bodyRotation;
    public static final /* synthetic */ DataParameter<Rotations> HEAD_ROTATION;
    private /* synthetic */ Rotations leftLegRotation;
    private /* synthetic */ boolean canInteract;
    public static final /* synthetic */ DataParameter<Rotations> LEFT_LEG_ROTATION;
    private /* synthetic */ int disabledSlots;
    private /* synthetic */ Rotations leftArmRotation;
    public /* synthetic */ long punchCooldown;
    public static final /* synthetic */ DataParameter<Rotations> RIGHT_LEG_ROTATION;
    private static final /* synthetic */ Rotations DEFAULT_LEFTARM_ROTATION;
    private static final /* synthetic */ Rotations DEFAULT_RIGHTLEG_ROTATION;
    private /* synthetic */ Rotations rightLegRotation;
    private /* synthetic */ Rotations headRotation;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$inventory$EntityEquipmentSlot$Type;
    public static final /* synthetic */ DataParameter<Rotations> RIGHT_ARM_ROTATION;
    private final /* synthetic */ NonNullList<ItemStack> handItems;
    private static final /* synthetic */ Rotations DEFAULT_RIGHTARM_ROTATION;
    private static final /* synthetic */ Rotations DEFAULT_HEAD_ROTATION;
    private static final /* synthetic */ Predicate<Entity> IS_RIDEABLE_MINECART;
    private static final /* synthetic */ Rotations DEFAULT_LEFTLEG_ROTATION;
    public static final /* synthetic */ DataParameter<Rotations> BODY_ROTATION;
    public static final /* synthetic */ DataParameter<Rotations> LEFT_ARM_ROTATION;
    private static final /* synthetic */ Rotations DEFAULT_BODY_ROTATION;
    private final /* synthetic */ NonNullList<ItemStack> armorItems;
    private /* synthetic */ Rotations rightArmRotation;
    public static final /* synthetic */ DataParameter<Byte> STATUS;
    private /* synthetic */ boolean wasMarker;
    
    public boolean hasNoBasePlate() {
        return (this.dataManager.get(EntityArmorStand.STATUS) & 0x8) != 0x0;
    }
    
    @Override
    public boolean canBePushed() {
        return false;
    }
    
    @Override
    public boolean replaceItemInInventory(final int llllllllllllllIlllIllllIlIIlIIIl, final ItemStack llllllllllllllIlllIllllIlIIlIIII) {
        EntityEquipmentSlot llllllllllllllIlllIllllIlIIIlIlI = null;
        if (llllllllllllllIlllIllllIlIIlIIIl == 98) {
            final EntityEquipmentSlot llllllllllllllIlllIllllIlIIIllll = EntityEquipmentSlot.MAINHAND;
        }
        else if (llllllllllllllIlllIllllIlIIlIIIl == 99) {
            final EntityEquipmentSlot llllllllllllllIlllIllllIlIIIlllI = EntityEquipmentSlot.OFFHAND;
        }
        else if (llllllllllllllIlllIllllIlIIlIIIl == 100 + EntityEquipmentSlot.HEAD.getIndex()) {
            final EntityEquipmentSlot llllllllllllllIlllIllllIlIIIllIl = EntityEquipmentSlot.HEAD;
        }
        else if (llllllllllllllIlllIllllIlIIlIIIl == 100 + EntityEquipmentSlot.CHEST.getIndex()) {
            final EntityEquipmentSlot llllllllllllllIlllIllllIlIIIllII = EntityEquipmentSlot.CHEST;
        }
        else if (llllllllllllllIlllIllllIlIIlIIIl == 100 + EntityEquipmentSlot.LEGS.getIndex()) {
            final EntityEquipmentSlot llllllllllllllIlllIllllIlIIIlIll = EntityEquipmentSlot.LEGS;
        }
        else {
            if (llllllllllllllIlllIllllIlIIlIIIl != 100 + EntityEquipmentSlot.FEET.getIndex()) {
                return false;
            }
            llllllllllllllIlllIllllIlIIIlIlI = EntityEquipmentSlot.FEET;
        }
        if (!llllllllllllllIlllIllllIlIIlIIII.func_190926_b() && !EntityLiving.isItemStackInSlot(llllllllllllllIlllIllllIlIIIlIlI, llllllllllllllIlllIllllIlIIlIIII) && llllllllllllllIlllIllllIlIIIlIlI != EntityEquipmentSlot.HEAD) {
            return false;
        }
        this.setItemStackToSlot(llllllllllllllIlllIllllIlIIIlIlI, llllllllllllllIlllIllllIlIIlIIII);
        return true;
    }
    
    public EntityArmorStand(final World llllllllllllllIlllIllllIllIIlIlI, final double llllllllllllllIlllIllllIllIIlIIl, final double llllllllllllllIlllIllllIllIIlIII, final double llllllllllllllIlllIllllIllIIIlll) {
        this(llllllllllllllIlllIllllIllIIlIlI);
        this.setPosition(llllllllllllllIlllIllllIllIIlIIl, llllllllllllllIlllIllllIllIIlIII, llllllllllllllIlllIllllIllIIIlll);
    }
    
    public Rotations getHeadRotation() {
        return this.headRotation;
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound llllllllllllllIlllIllllIIllllIlI) {
        super.writeEntityToNBT(llllllllllllllIlllIllllIIllllIlI);
        final NBTTagList llllllllllllllIlllIllllIIllllIIl = new NBTTagList();
        for (final ItemStack llllllllllllllIlllIllllIIllllIII : this.armorItems) {
            final NBTTagCompound llllllllllllllIlllIllllIIlllIlll = new NBTTagCompound();
            if (!llllllllllllllIlllIllllIIllllIII.func_190926_b()) {
                llllllllllllllIlllIllllIIllllIII.writeToNBT(llllllllllllllIlllIllllIIlllIlll);
            }
            llllllllllllllIlllIllllIIllllIIl.appendTag(llllllllllllllIlllIllllIIlllIlll);
        }
        llllllllllllllIlllIllllIIllllIlI.setTag("ArmorItems", llllllllllllllIlllIllllIIllllIIl);
        final NBTTagList llllllllllllllIlllIllllIIlllIllI = new NBTTagList();
        for (final ItemStack llllllllllllllIlllIllllIIlllIlIl : this.handItems) {
            final NBTTagCompound llllllllllllllIlllIllllIIlllIlII = new NBTTagCompound();
            if (!llllllllllllllIlllIllllIIlllIlIl.func_190926_b()) {
                llllllllllllllIlllIllllIIlllIlIl.writeToNBT(llllllllllllllIlllIllllIIlllIlII);
            }
            llllllllllllllIlllIllllIIlllIllI.appendTag(llllllllllllllIlllIllllIIlllIlII);
        }
        llllllllllllllIlllIllllIIllllIlI.setTag("HandItems", llllllllllllllIlllIllllIIlllIllI);
        llllllllllllllIlllIllllIIllllIlI.setBoolean("Invisible", this.isInvisible());
        llllllllllllllIlllIllllIIllllIlI.setBoolean("Small", this.isSmall());
        llllllllllllllIlllIllllIIllllIlI.setBoolean("ShowArms", this.getShowArms());
        llllllllllllllIlllIllllIIllllIlI.setInteger("DisabledSlots", this.disabledSlots);
        llllllllllllllIlllIllllIIllllIlI.setBoolean("NoBasePlate", this.hasNoBasePlate());
        if (this.hasMarker()) {
            llllllllllllllIlllIllllIIllllIlI.setBoolean("Marker", this.hasMarker());
        }
        llllllllllllllIlllIllllIIllllIlI.setTag("Pose", this.readPoseFromNBT());
    }
    
    @Override
    public EnumPushReaction getPushReaction() {
        return this.hasMarker() ? EnumPushReaction.IGNORE : super.getPushReaction();
    }
    
    static {
        DEFAULT_HEAD_ROTATION = new Rotations(0.0f, 0.0f, 0.0f);
        DEFAULT_BODY_ROTATION = new Rotations(0.0f, 0.0f, 0.0f);
        DEFAULT_LEFTARM_ROTATION = new Rotations(-10.0f, 0.0f, -10.0f);
        DEFAULT_RIGHTARM_ROTATION = new Rotations(-15.0f, 0.0f, 10.0f);
        DEFAULT_LEFTLEG_ROTATION = new Rotations(-1.0f, 0.0f, -1.0f);
        DEFAULT_RIGHTLEG_ROTATION = new Rotations(1.0f, 0.0f, 1.0f);
        STATUS = EntityDataManager.createKey(EntityArmorStand.class, DataSerializers.BYTE);
        HEAD_ROTATION = EntityDataManager.createKey(EntityArmorStand.class, DataSerializers.ROTATIONS);
        BODY_ROTATION = EntityDataManager.createKey(EntityArmorStand.class, DataSerializers.ROTATIONS);
        LEFT_ARM_ROTATION = EntityDataManager.createKey(EntityArmorStand.class, DataSerializers.ROTATIONS);
        RIGHT_ARM_ROTATION = EntityDataManager.createKey(EntityArmorStand.class, DataSerializers.ROTATIONS);
        LEFT_LEG_ROTATION = EntityDataManager.createKey(EntityArmorStand.class, DataSerializers.ROTATIONS);
        RIGHT_LEG_ROTATION = EntityDataManager.createKey(EntityArmorStand.class, DataSerializers.ROTATIONS);
        IS_RIDEABLE_MINECART = (Predicate)new Predicate<Entity>() {
            public boolean apply(@Nullable final Entity lllllllllllllllllIlIllllllIIlIII) {
                return lllllllllllllllllIlIllllllIIlIII instanceof EntityMinecart && ((EntityMinecart)lllllllllllllllllIlIllllllIIlIII).getType() == EntityMinecart.Type.RIDEABLE;
            }
        };
    }
    
    private void damageArmorStand(final float llllllllllllllIlllIlllIlllIIIIIl) {
        float llllllllllllllIlllIlllIlllIIIIll = this.getHealth();
        llllllllllllllIlllIlllIlllIIIIll -= llllllllllllllIlllIlllIlllIIIIIl;
        if (llllllllllllllIlllIlllIlllIIIIll <= 0.5f) {
            this.dropContents();
            this.setDead();
        }
        else {
            this.setHealth(llllllllllllllIlllIlllIlllIIIIll);
        }
    }
    
    @Override
    public Iterable<ItemStack> getHeldEquipment() {
        return this.handItems;
    }
    
    @Override
    public EnumHandSide getPrimaryHand() {
        return EnumHandSide.RIGHT;
    }
    
    public void setRightLegRotation(final Rotations llllllllllllllIlllIlllIlIIIIIlll) {
        this.rightLegRotation = llllllllllllllIlllIlllIlIIIIIlll;
        this.dataManager.set(EntityArmorStand.RIGHT_LEG_ROTATION, llllllllllllllIlllIlllIlIIIIIlll);
    }
    
    public static void registerFixesArmorStand(final DataFixer llllllllllllllIlllIllllIlIIIIIll) {
        llllllllllllllIlllIllllIlIIIIIll.registerWalker(FixTypes.ENTITY, new ItemStackDataLists(EntityArmorStand.class, new String[] { "ArmorItems", "HandItems" }));
    }
    
    @Override
    protected SoundEvent getFallSound(final int llllllllllllllIlllIlllIIlllIllll) {
        return SoundEvents.ENTITY_ARMORSTAND_FALL;
    }
    
    @Override
    public void setItemStackToSlot(final EntityEquipmentSlot llllllllllllllIlllIllllIlIIllIII, final ItemStack llllllllllllllIlllIllllIlIIlIlll) {
        switch ($SWITCH_TABLE$net$minecraft$inventory$EntityEquipmentSlot$Type()[llllllllllllllIlllIllllIlIIllIII.getSlotType().ordinal()]) {
            case 1: {
                this.playEquipSound(llllllllllllllIlllIllllIlIIlIlll);
                this.handItems.set(llllllllllllllIlllIllllIlIIllIII.getIndex(), llllllllllllllIlllIllllIlIIlIlll);
                break;
            }
            case 2: {
                this.playEquipSound(llllllllllllllIlllIllllIlIIlIlll);
                this.armorItems.set(llllllllllllllIlllIllllIlIIllIII.getIndex(), llllllllllllllIlllIllllIlIIlIlll);
                break;
            }
        }
    }
    
    @Override
    public Iterable<ItemStack> getArmorInventoryList() {
        return this.armorItems;
    }
    
    @Override
    public boolean isInRangeToRenderDist(final double llllllllllllllIlllIlllIlllIIllIl) {
        double llllllllllllllIlllIlllIlllIIllll = this.getEntityBoundingBox().getAverageEdgeLength() * 4.0;
        if (Double.isNaN(llllllllllllllIlllIlllIlllIIllll) || llllllllllllllIlllIlllIlllIIllll == 0.0) {
            llllllllllllllIlllIlllIlllIIllll = 4.0;
        }
        llllllllllllllIlllIlllIlllIIllll *= 64.0;
        return llllllllllllllIlllIlllIlllIIllIl < llllllllllllllIlllIlllIlllIIllll * llllllllllllllIlllIlllIlllIIllll;
    }
    
    @Nullable
    @Override
    protected SoundEvent getHurtSound(final DamageSource llllllllllllllIlllIlllIIlllIllIl) {
        return SoundEvents.ENTITY_ARMORSTAND_HIT;
    }
    
    @Override
    public boolean canBeCollidedWith() {
        return super.canBeCollidedWith() && !this.hasMarker();
    }
    
    private void swapItem(final EntityPlayer llllllllllllllIlllIlllIllllllIII, final EntityEquipmentSlot llllllllllllllIlllIlllIllllIllll, final ItemStack llllllllllllllIlllIlllIlllllIllI, final EnumHand llllllllllllllIlllIlllIllllIllIl) {
        final ItemStack llllllllllllllIlllIlllIlllllIlII = this.getItemStackFromSlot(llllllllllllllIlllIlllIllllIllll);
        if ((llllllllllllllIlllIlllIlllllIlII.func_190926_b() || (this.disabledSlots & 1 << llllllllllllllIlllIlllIllllIllll.getSlotIndex() + 8) == 0x0) && (!llllllllllllllIlllIlllIlllllIlII.func_190926_b() || (this.disabledSlots & 1 << llllllllllllllIlllIlllIllllIllll.getSlotIndex() + 16) == 0x0)) {
            if (llllllllllllllIlllIlllIllllllIII.capabilities.isCreativeMode && llllllllllllllIlllIlllIlllllIlII.func_190926_b() && !llllllllllllllIlllIlllIlllllIllI.func_190926_b()) {
                final ItemStack llllllllllllllIlllIlllIlllllIIll = llllllllllllllIlllIlllIlllllIllI.copy();
                llllllllllllllIlllIlllIlllllIIll.func_190920_e(1);
                this.setItemStackToSlot(llllllllllllllIlllIlllIllllIllll, llllllllllllllIlllIlllIlllllIIll);
            }
            else if (!llllllllllllllIlllIlllIlllllIllI.func_190926_b() && llllllllllllllIlllIlllIlllllIllI.func_190916_E() > 1) {
                if (llllllllllllllIlllIlllIlllllIlII.func_190926_b()) {
                    final ItemStack llllllllllllllIlllIlllIlllllIIlI = llllllllllllllIlllIlllIlllllIllI.copy();
                    llllllllllllllIlllIlllIlllllIIlI.func_190920_e(1);
                    this.setItemStackToSlot(llllllllllllllIlllIlllIllllIllll, llllllllllllllIlllIlllIlllllIIlI);
                    llllllllllllllIlllIlllIlllllIllI.func_190918_g(1);
                }
            }
            else {
                this.setItemStackToSlot(llllllllllllllIlllIlllIllllIllll, llllllllllllllIlllIlllIlllllIllI);
                llllllllllllllIlllIlllIllllllIII.setHeldItem(llllllllllllllIlllIlllIllllIllIl, llllllllllllllIlllIlllIlllllIlII);
            }
        }
    }
    
    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_ARMORSTAND_BREAK;
    }
    
    @Override
    protected void collideWithNearbyEntities() {
        final List<Entity> llllllllllllllIlllIllllIIIllIlll = this.world.getEntitiesInAABBexcluding(this, this.getEntityBoundingBox(), EntityArmorStand.IS_RIDEABLE_MINECART);
        for (int llllllllllllllIlllIllllIIIllIllI = 0; llllllllllllllIlllIllllIIIllIllI < llllllllllllllIlllIllllIIIllIlll.size(); ++llllllllllllllIlllIllllIIIllIllI) {
            final Entity llllllllllllllIlllIllllIIIllIlIl = llllllllllllllIlllIllllIIIllIlll.get(llllllllllllllIlllIllllIIIllIllI);
            if (this.getDistanceSqToEntity(llllllllllllllIlllIllllIIIllIlIl) <= 0.2) {
                llllllllllllllIlllIllllIIIllIlIl.applyEntityCollision(this);
            }
        }
    }
    
    @Override
    public boolean canBeHitWithPotion() {
        return false;
    }
    
    @Override
    public ItemStack getItemStackFromSlot(final EntityEquipmentSlot llllllllllllllIlllIllllIlIlIIIlI) {
        switch ($SWITCH_TABLE$net$minecraft$inventory$EntityEquipmentSlot$Type()[llllllllllllllIlllIllllIlIlIIIlI.getSlotType().ordinal()]) {
            case 1: {
                return this.handItems.get(llllllllllllllIlllIllllIlIlIIIlI.getIndex());
            }
            case 2: {
                return this.armorItems.get(llllllllllllllIlllIllllIlIlIIIlI.getIndex());
            }
            default: {
                return ItemStack.field_190927_a;
            }
        }
    }
    
    public boolean hasMarker() {
        return (this.dataManager.get(EntityArmorStand.STATUS) & 0x10) != 0x0;
    }
    
    public boolean isSmall() {
        return (this.dataManager.get(EntityArmorStand.STATUS) & 0x1) != 0x0;
    }
    
    @Override
    public void onStruckByLightning(final EntityLightningBolt llllllllllllllIlllIlllIIlllIlIlI) {
    }
    
    public void setRightArmRotation(final Rotations llllllllllllllIlllIlllIlIIIlIIll) {
        this.rightArmRotation = llllllllllllllIlllIlllIlIIIlIIll;
        this.dataManager.set(EntityArmorStand.RIGHT_ARM_ROTATION, llllllllllllllIlllIlllIlIIIlIIll);
    }
    
    public Rotations getBodyRotation() {
        return this.bodyRotation;
    }
    
    public void setBodyRotation(final Rotations llllllllllllllIlllIlllIlIIlIIIIl) {
        this.bodyRotation = llllllllllllllIlllIlllIlIIlIIIIl;
        this.dataManager.set(EntityArmorStand.BODY_ROTATION, llllllllllllllIlllIlllIlIIlIIIIl);
    }
    
    @Override
    public boolean isServerWorld() {
        return super.isServerWorld() && !this.hasNoGravity();
    }
    
    @Override
    public void setInvisible(final boolean llllllllllllllIlllIlllIlIllIIlll) {
        this.canInteract = llllllllllllllIlllIlllIlIllIIlll;
        super.setInvisible(llllllllllllllIlllIlllIlIllIIlll);
    }
    
    private void setSmall(final boolean llllllllllllllIlllIlllIlIlIlIIll) {
        this.dataManager.set(EntityArmorStand.STATUS, this.setBit(this.dataManager.get(EntityArmorStand.STATUS), 1, llllllllllllllIlllIlllIlIlIlIIll));
        this.setSize(0.5f, 1.975f);
    }
    
    private void setShowArms(final boolean llllllllllllllIlllIlllIlIlIIllII) {
        this.dataManager.set(EntityArmorStand.STATUS, this.setBit(this.dataManager.get(EntityArmorStand.STATUS), 4, llllllllllllllIlllIlllIlIlIIllII));
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource llllllllllllllIlllIlllIlllIllllI, final float llllllllllllllIlllIlllIllllIIIll) {
        if (this.world.isRemote || this.isDead) {
            return false;
        }
        if (DamageSource.outOfWorld.equals(llllllllllllllIlllIlllIlllIllllI)) {
            this.setDead();
            return false;
        }
        if (this.isEntityInvulnerable(llllllllllllllIlllIlllIlllIllllI) || this.canInteract || this.hasMarker()) {
            return false;
        }
        if (llllllllllllllIlllIlllIlllIllllI.isExplosion()) {
            this.dropContents();
            this.setDead();
            return false;
        }
        if (DamageSource.inFire.equals(llllllllllllllIlllIlllIlllIllllI)) {
            if (this.isBurning()) {
                this.damageArmorStand(0.15f);
            }
            else {
                this.setFire(5);
            }
            return false;
        }
        if (DamageSource.onFire.equals(llllllllllllllIlllIlllIlllIllllI) && this.getHealth() > 0.5f) {
            this.damageArmorStand(4.0f);
            return false;
        }
        final boolean llllllllllllllIlllIlllIllllIIIlI = "arrow".equals(llllllllllllllIlllIlllIlllIllllI.getDamageType());
        final boolean llllllllllllllIlllIlllIllllIIIIl = "player".equals(llllllllllllllIlllIlllIlllIllllI.getDamageType());
        if (!llllllllllllllIlllIlllIllllIIIIl && !llllllllllllllIlllIlllIllllIIIlI) {
            return false;
        }
        if (llllllllllllllIlllIlllIlllIllllI.getSourceOfDamage() instanceof EntityArrow) {
            llllllllllllllIlllIlllIlllIllllI.getSourceOfDamage().setDead();
        }
        if (llllllllllllllIlllIlllIlllIllllI.getEntity() instanceof EntityPlayer && !((EntityPlayer)llllllllllllllIlllIlllIlllIllllI.getEntity()).capabilities.allowEdit) {
            return false;
        }
        if (llllllllllllllIlllIlllIlllIllllI.isCreativePlayer()) {
            this.func_190773_I();
            this.playParticles();
            this.setDead();
            return false;
        }
        final long llllllllllllllIlllIlllIllllIIIII = this.world.getTotalWorldTime();
        if (llllllllllllllIlllIlllIllllIIIII - this.punchCooldown > 5L && !llllllllllllllIlllIlllIllllIIIlI) {
            this.world.setEntityState(this, (byte)32);
            this.punchCooldown = llllllllllllllIlllIlllIllllIIIII;
        }
        else {
            this.dropBlock();
            this.playParticles();
            this.setDead();
        }
        return false;
    }
    
    public boolean getShowArms() {
        return (this.dataManager.get(EntityArmorStand.STATUS) & 0x4) != 0x0;
    }
    
    private void updateBoundingBox(final boolean llllllllllllllIlllIlllIlIlllIIII) {
        if (llllllllllllllIlllIlllIlIlllIIII) {
            this.setSize(0.0f, 0.0f);
        }
        else {
            this.setSize(0.5f, 1.975f);
        }
    }
    
    @Override
    protected void collideWithEntity(final Entity llllllllllllllIlllIllllIIIllllIl) {
    }
    
    private void dropContents() {
        this.func_190773_I();
        for (int llllllllllllllIlllIlllIllIlllIII = 0; llllllllllllllIlllIlllIllIlllIII < this.handItems.size(); ++llllllllllllllIlllIlllIllIlllIII) {
            final ItemStack llllllllllllllIlllIlllIllIllIlll = this.handItems.get(llllllllllllllIlllIlllIllIlllIII);
            if (!llllllllllllllIlllIlllIllIllIlll.func_190926_b()) {
                Block.spawnAsEntity(this.world, new BlockPos(this).up(), llllllllllllllIlllIlllIllIllIlll);
                this.handItems.set(llllllllllllllIlllIlllIllIlllIII, ItemStack.field_190927_a);
            }
        }
        for (int llllllllllllllIlllIlllIllIllIllI = 0; llllllllllllllIlllIlllIllIllIllI < this.armorItems.size(); ++llllllllllllllIlllIlllIllIllIllI) {
            final ItemStack llllllllllllllIlllIlllIllIllIlIl = this.armorItems.get(llllllllllllllIlllIlllIllIllIllI);
            if (!llllllllllllllIlllIlllIllIllIlIl.func_190926_b()) {
                Block.spawnAsEntity(this.world, new BlockPos(this).up(), llllllllllllllIlllIlllIllIllIlIl);
                this.armorItems.set(llllllllllllllIlllIlllIllIllIllI, ItemStack.field_190927_a);
            }
        }
    }
    
    @Override
    protected final void setSize(final float llllllllllllllIlllIllllIlIllIlll, final float llllllllllllllIlllIllllIlIllIllI) {
        final double llllllllllllllIlllIllllIlIllllII = this.posX;
        final double llllllllllllllIlllIllllIlIlllIll = this.posY;
        final double llllllllllllllIlllIllllIlIlllIlI = this.posZ;
        final float llllllllllllllIlllIllllIlIlllIIl = this.hasMarker() ? 0.0f : (this.isChild() ? 0.5f : 1.0f);
        super.setSize(llllllllllllllIlllIllllIlIllIlll * llllllllllllllIlllIllllIlIlllIIl, llllllllllllllIlllIllllIlIllIllI * llllllllllllllIlllIllllIlIlllIIl);
        this.setPosition(llllllllllllllIlllIllllIlIllllII, llllllllllllllIlllIllllIlIlllIll, llllllllllllllIlllIllllIlIlllIlI);
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(EntityArmorStand.STATUS, (Byte)0);
        this.dataManager.register(EntityArmorStand.HEAD_ROTATION, EntityArmorStand.DEFAULT_HEAD_ROTATION);
        this.dataManager.register(EntityArmorStand.BODY_ROTATION, EntityArmorStand.DEFAULT_BODY_ROTATION);
        this.dataManager.register(EntityArmorStand.LEFT_ARM_ROTATION, EntityArmorStand.DEFAULT_LEFTARM_ROTATION);
        this.dataManager.register(EntityArmorStand.RIGHT_ARM_ROTATION, EntityArmorStand.DEFAULT_RIGHTARM_ROTATION);
        this.dataManager.register(EntityArmorStand.LEFT_LEG_ROTATION, EntityArmorStand.DEFAULT_LEFTLEG_ROTATION);
        this.dataManager.register(EntityArmorStand.RIGHT_LEG_ROTATION, EntityArmorStand.DEFAULT_RIGHTLEG_ROTATION);
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$inventory$EntityEquipmentSlot$Type() {
        final int[] $switch_TABLE$net$minecraft$inventory$EntityEquipmentSlot$Type = EntityArmorStand.$SWITCH_TABLE$net$minecraft$inventory$EntityEquipmentSlot$Type;
        if ($switch_TABLE$net$minecraft$inventory$EntityEquipmentSlot$Type != null) {
            return $switch_TABLE$net$minecraft$inventory$EntityEquipmentSlot$Type;
        }
        final char llllllllllllllIlllIlllIIlllIIIII = (Object)new int[EntityEquipmentSlot.Type.values().length];
        try {
            llllllllllllllIlllIlllIIlllIIIII[EntityEquipmentSlot.Type.ARMOR.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllIlllIlllIIlllIIIII[EntityEquipmentSlot.Type.HAND.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        return EntityArmorStand.$SWITCH_TABLE$net$minecraft$inventory$EntityEquipmentSlot$Type = (int[])(Object)llllllllllllllIlllIlllIIlllIIIII;
    }
    
    private void dropBlock() {
        Block.spawnAsEntity(this.world, new BlockPos(this), new ItemStack(Items.ARMOR_STAND));
        this.dropContents();
    }
    
    protected EntityEquipmentSlot func_190772_a(final Vec3d llllllllllllllIlllIllllIIIIlIIIl) {
        EntityEquipmentSlot llllllllllllllIlllIllllIIIIlIIII = EntityEquipmentSlot.MAINHAND;
        final boolean llllllllllllllIlllIllllIIIIIllll = this.isSmall();
        final double llllllllllllllIlllIllllIIIIIlllI = llllllllllllllIlllIllllIIIIIllll ? (llllllllllllllIlllIllllIIIIlIIIl.yCoord * 2.0) : llllllllllllllIlllIllllIIIIlIIIl.yCoord;
        final EntityEquipmentSlot llllllllllllllIlllIllllIIIIIllIl = EntityEquipmentSlot.FEET;
        if (llllllllllllllIlllIllllIIIIIlllI >= 0.1 && llllllllllllllIlllIllllIIIIIlllI < 0.1 + (llllllllllllllIlllIllllIIIIIllll ? 0.8 : 0.45) && this.func_190630_a(llllllllllllllIlllIllllIIIIIllIl)) {
            llllllllllllllIlllIllllIIIIlIIII = EntityEquipmentSlot.FEET;
        }
        else if (llllllllllllllIlllIllllIIIIIlllI >= 0.9 + (llllllllllllllIlllIllllIIIIIllll ? 0.3 : 0.0) && llllllllllllllIlllIllllIIIIIlllI < 0.9 + (llllllllllllllIlllIllllIIIIIllll ? 1.0 : 0.7) && this.func_190630_a(EntityEquipmentSlot.CHEST)) {
            llllllllllllllIlllIllllIIIIlIIII = EntityEquipmentSlot.CHEST;
        }
        else if (llllllllllllllIlllIllllIIIIIlllI >= 0.4 && llllllllllllllIlllIllllIIIIIlllI < 0.4 + (llllllllllllllIlllIllllIIIIIllll ? 1.0 : 0.8) && this.func_190630_a(EntityEquipmentSlot.LEGS)) {
            llllllllllllllIlllIllllIIIIlIIII = EntityEquipmentSlot.LEGS;
        }
        else if (llllllllllllllIlllIllllIIIIIlllI >= 1.6 && this.func_190630_a(EntityEquipmentSlot.HEAD)) {
            llllllllllllllIlllIllllIIIIlIIII = EntityEquipmentSlot.HEAD;
        }
        return llllllllllllllIlllIllllIIIIlIIII;
    }
    
    @Override
    public float getEyeHeight() {
        return this.isChild() ? (this.height * 0.5f) : (this.height * 0.9f);
    }
    
    private void setMarker(final boolean llllllllllllllIlllIlllIlIIlllIII) {
        this.dataManager.set(EntityArmorStand.STATUS, this.setBit(this.dataManager.get(EntityArmorStand.STATUS), 16, llllllllllllllIlllIlllIlIIlllIII));
        this.setSize(0.5f, 1.975f);
    }
    
    @Override
    public void handleStatusUpdate(final byte llllllllllllllIlllIlllIlllIlIlll) {
        if (llllllllllllllIlllIlllIlllIlIlll == 32) {
            if (this.world.isRemote) {
                this.world.playSound(this.posX, this.posY, this.posZ, SoundEvents.ENTITY_ARMORSTAND_HIT, this.getSoundCategory(), 0.3f, 1.0f, false);
                this.punchCooldown = this.world.getTotalWorldTime();
            }
        }
        else {
            super.handleStatusUpdate(llllllllllllllIlllIlllIlllIlIlll);
        }
    }
    
    @Override
    public void notifyDataManagerChange(final DataParameter<?> llllllllllllllIlllIlllIIlllIIIll) {
        if (EntityArmorStand.STATUS.equals(llllllllllllllIlllIlllIIlllIIIll)) {
            this.setSize(0.5f, 1.975f);
        }
        super.notifyDataManagerChange(llllllllllllllIlllIlllIIlllIIIll);
    }
    
    @Override
    public boolean isImmuneToExplosions() {
        return this.isInvisible();
    }
    
    private NBTTagCompound readPoseFromNBT() {
        final NBTTagCompound llllllllllllllIlllIllllIIlIIIIlI = new NBTTagCompound();
        if (!EntityArmorStand.DEFAULT_HEAD_ROTATION.equals(this.headRotation)) {
            llllllllllllllIlllIllllIIlIIIIlI.setTag("Head", this.headRotation.writeToNBT());
        }
        if (!EntityArmorStand.DEFAULT_BODY_ROTATION.equals(this.bodyRotation)) {
            llllllllllllllIlllIllllIIlIIIIlI.setTag("Body", this.bodyRotation.writeToNBT());
        }
        if (!EntityArmorStand.DEFAULT_LEFTARM_ROTATION.equals(this.leftArmRotation)) {
            llllllllllllllIlllIllllIIlIIIIlI.setTag("LeftArm", this.leftArmRotation.writeToNBT());
        }
        if (!EntityArmorStand.DEFAULT_RIGHTARM_ROTATION.equals(this.rightArmRotation)) {
            llllllllllllllIlllIllllIIlIIIIlI.setTag("RightArm", this.rightArmRotation.writeToNBT());
        }
        if (!EntityArmorStand.DEFAULT_LEFTLEG_ROTATION.equals(this.leftLegRotation)) {
            llllllllllllllIlllIllllIIlIIIIlI.setTag("LeftLeg", this.leftLegRotation.writeToNBT());
        }
        if (!EntityArmorStand.DEFAULT_RIGHTLEG_ROTATION.equals(this.rightLegRotation)) {
            llllllllllllllIlllIllllIIlIIIIlI.setTag("RightLeg", this.rightLegRotation.writeToNBT());
        }
        return llllllllllllllIlllIllllIIlIIIIlI;
    }
    
    @Override
    public boolean func_190631_cK() {
        return false;
    }
    
    @Override
    public void setRenderYawOffset(final float llllllllllllllIlllIlllIllIIlIIlI) {
        this.prevRotationYaw = llllllllllllllIlllIlllIllIIlIIlI;
        this.prevRenderYawOffset = llllllllllllllIlllIlllIllIIlIIlI;
        this.rotationYawHead = llllllllllllllIlllIlllIllIIlIIlI;
        this.prevRotationYawHead = llllllllllllllIlllIlllIllIIlIIlI;
    }
    
    public Rotations getRightArmRotation() {
        return this.rightArmRotation;
    }
    
    public void setHeadRotation(final Rotations llllllllllllllIlllIlllIlIIlIIlIl) {
        this.headRotation = llllllllllllllIlllIlllIlIIlIIlIl;
        this.dataManager.set(EntityArmorStand.HEAD_ROTATION, llllllllllllllIlllIlllIlIIlIIlIl);
    }
    
    @Override
    protected float updateDistance(final float llllllllllllllIlllIlllIllIlIllII, final float llllllllllllllIlllIlllIllIlIlIll) {
        this.prevRenderYawOffset = this.prevRotationYaw;
        this.renderYawOffset = this.rotationYaw;
        return 0.0f;
    }
    
    @Override
    public boolean isChild() {
        return this.isSmall();
    }
    
    @Override
    public void func_191986_a(final float llllllllllllllIlllIlllIllIIllIlI, final float llllllllllllllIlllIlllIllIIlllIl, final float llllllllllllllIlllIlllIllIIllIII) {
        if (!this.hasNoGravity()) {
            super.func_191986_a(llllllllllllllIlllIlllIllIIllIlI, llllllllllllllIlllIlllIllIIlllIl, llllllllllllllIlllIlllIllIIllIII);
        }
    }
    
    private void playParticles() {
        if (this.world instanceof WorldServer) {
            ((WorldServer)this.world).spawnParticle(EnumParticleTypes.BLOCK_DUST, this.posX, this.posY + this.height / 1.5, this.posZ, 10, this.width / 4.0f, this.height / 4.0f, this.width / 4.0f, 0.05, Block.getStateId(Blocks.PLANKS.getDefaultState()));
        }
    }
    
    @Override
    public EnumActionResult applyPlayerInteraction(final EntityPlayer llllllllllllllIlllIllllIIIIlllll, final Vec3d llllllllllllllIlllIllllIIIIllllI, final EnumHand llllllllllllllIlllIllllIIIIlllIl) {
        final ItemStack llllllllllllllIlllIllllIIIlIIlII = llllllllllllllIlllIllllIIIIlllll.getHeldItem(llllllllllllllIlllIllllIIIIlllIl);
        if (this.hasMarker() || llllllllllllllIlllIllllIIIlIIlII.getItem() == Items.NAME_TAG) {
            return EnumActionResult.PASS;
        }
        if (!this.world.isRemote && !llllllllllllllIlllIllllIIIIlllll.isSpectator()) {
            final EntityEquipmentSlot llllllllllllllIlllIllllIIIlIIIll = EntityLiving.getSlotForItemStack(llllllllllllllIlllIllllIIIlIIlII);
            if (llllllllllllllIlllIllllIIIlIIlII.func_190926_b()) {
                final EntityEquipmentSlot llllllllllllllIlllIllllIIIlIIIlI = this.func_190772_a(llllllllllllllIlllIllllIIIIllllI);
                final EntityEquipmentSlot llllllllllllllIlllIllllIIIlIIIIl = this.isDisabled(llllllllllllllIlllIllllIIIlIIIlI) ? llllllllllllllIlllIllllIIIlIIIll : llllllllllllllIlllIllllIIIlIIIlI;
                if (this.func_190630_a(llllllllllllllIlllIllllIIIlIIIIl)) {
                    this.swapItem(llllllllllllllIlllIllllIIIIlllll, llllllllllllllIlllIllllIIIlIIIIl, llllllllllllllIlllIllllIIIlIIlII, llllllllllllllIlllIllllIIIIlllIl);
                }
            }
            else {
                if (this.isDisabled(llllllllllllllIlllIllllIIIlIIIll)) {
                    return EnumActionResult.FAIL;
                }
                if (llllllllllllllIlllIllllIIIlIIIll.getSlotType() == EntityEquipmentSlot.Type.HAND && !this.getShowArms()) {
                    return EnumActionResult.FAIL;
                }
                this.swapItem(llllllllllllllIlllIllllIIIIlllll, llllllllllllllIlllIllllIIIlIIIll, llllllllllllllIlllIllllIIIlIIlII, llllllllllllllIlllIllllIIIIlllIl);
            }
            return EnumActionResult.SUCCESS;
        }
        return EnumActionResult.SUCCESS;
    }
    
    @Override
    public void onUpdate() {
        super.onUpdate();
        final Rotations llllllllllllllIlllIlllIllIIIIIlI = this.dataManager.get(EntityArmorStand.HEAD_ROTATION);
        if (!this.headRotation.equals(llllllllllllllIlllIlllIllIIIIIlI)) {
            this.setHeadRotation(llllllllllllllIlllIlllIllIIIIIlI);
        }
        final Rotations llllllllllllllIlllIlllIllIIIIIIl = this.dataManager.get(EntityArmorStand.BODY_ROTATION);
        if (!this.bodyRotation.equals(llllllllllllllIlllIlllIllIIIIIIl)) {
            this.setBodyRotation(llllllllllllllIlllIlllIllIIIIIIl);
        }
        final Rotations llllllllllllllIlllIlllIllIIIIIII = this.dataManager.get(EntityArmorStand.LEFT_ARM_ROTATION);
        if (!this.leftArmRotation.equals(llllllllllllllIlllIlllIllIIIIIII)) {
            this.setLeftArmRotation(llllllllllllllIlllIlllIllIIIIIII);
        }
        final Rotations llllllllllllllIlllIlllIlIlllllll = this.dataManager.get(EntityArmorStand.RIGHT_ARM_ROTATION);
        if (!this.rightArmRotation.equals(llllllllllllllIlllIlllIlIlllllll)) {
            this.setRightArmRotation(llllllllllllllIlllIlllIlIlllllll);
        }
        final Rotations llllllllllllllIlllIlllIlIllllllI = this.dataManager.get(EntityArmorStand.LEFT_LEG_ROTATION);
        if (!this.leftLegRotation.equals(llllllllllllllIlllIlllIlIllllllI)) {
            this.setLeftLegRotation(llllllllllllllIlllIlllIlIllllllI);
        }
        final Rotations llllllllllllllIlllIlllIlIlllllIl = this.dataManager.get(EntityArmorStand.RIGHT_LEG_ROTATION);
        if (!this.rightLegRotation.equals(llllllllllllllIlllIlllIlIlllllIl)) {
            this.setRightLegRotation(llllllllllllllIlllIlllIlIlllllIl);
        }
        final boolean llllllllllllllIlllIlllIlIlllllII = this.hasMarker();
        if (this.wasMarker != llllllllllllllIlllIlllIlIlllllII) {
            this.updateBoundingBox(llllllllllllllIlllIlllIlIlllllII);
            this.preventEntitySpawning = !llllllllllllllIlllIlllIlIlllllII;
            this.wasMarker = llllllllllllllIlllIlllIlIlllllII;
        }
    }
    
    public EntityArmorStand(final World llllllllllllllIlllIllllIllIllIII) {
        super(llllllllllllllIlllIllllIllIllIII);
        this.handItems = NonNullList.func_191197_a(2, ItemStack.field_190927_a);
        this.armorItems = NonNullList.func_191197_a(4, ItemStack.field_190927_a);
        this.headRotation = EntityArmorStand.DEFAULT_HEAD_ROTATION;
        this.bodyRotation = EntityArmorStand.DEFAULT_BODY_ROTATION;
        this.leftArmRotation = EntityArmorStand.DEFAULT_LEFTARM_ROTATION;
        this.rightArmRotation = EntityArmorStand.DEFAULT_RIGHTARM_ROTATION;
        this.leftLegRotation = EntityArmorStand.DEFAULT_LEFTLEG_ROTATION;
        this.rightLegRotation = EntityArmorStand.DEFAULT_RIGHTLEG_ROTATION;
        this.noClip = this.hasNoGravity();
        this.setSize(0.5f, 1.975f);
    }
    
    @Override
    protected void updatePotionMetadata() {
        this.setInvisible(this.canInteract);
    }
    
    public void setLeftArmRotation(final Rotations llllllllllllllIlllIlllIlIIIllIIl) {
        this.leftArmRotation = llllllllllllllIlllIlllIlIIIllIIl;
        this.dataManager.set(EntityArmorStand.LEFT_ARM_ROTATION, llllllllllllllIlllIlllIlIIIllIIl);
    }
    
    public Rotations getLeftArmRotation() {
        return this.leftArmRotation;
    }
    
    private boolean isDisabled(final EntityEquipmentSlot llllllllllllllIlllIllllIIIIIIIIl) {
        return (this.disabledSlots & 1 << llllllllllllllIlllIllllIIIIIIIIl.getSlotIndex()) != 0x0;
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound llllllllllllllIlllIllllIIllIIlll) {
        super.readEntityFromNBT(llllllllllllllIlllIllllIIllIIlll);
        if (llllllllllllllIlllIllllIIllIIlll.hasKey("ArmorItems", 9)) {
            final NBTTagList llllllllllllllIlllIllllIIllIIllI = llllllllllllllIlllIllllIIllIIlll.getTagList("ArmorItems", 10);
            for (int llllllllllllllIlllIllllIIllIIlIl = 0; llllllllllllllIlllIllllIIllIIlIl < this.armorItems.size(); ++llllllllllllllIlllIllllIIllIIlIl) {
                this.armorItems.set(llllllllllllllIlllIllllIIllIIlIl, new ItemStack(llllllllllllllIlllIllllIIllIIllI.getCompoundTagAt(llllllllllllllIlllIllllIIllIIlIl)));
            }
        }
        if (llllllllllllllIlllIllllIIllIIlll.hasKey("HandItems", 9)) {
            final NBTTagList llllllllllllllIlllIllllIIllIIlII = llllllllllllllIlllIllllIIllIIlll.getTagList("HandItems", 10);
            for (int llllllllllllllIlllIllllIIllIIIll = 0; llllllllllllllIlllIllllIIllIIIll < this.handItems.size(); ++llllllllllllllIlllIllllIIllIIIll) {
                this.handItems.set(llllllllllllllIlllIllllIIllIIIll, new ItemStack(llllllllllllllIlllIllllIIllIIlII.getCompoundTagAt(llllllllllllllIlllIllllIIllIIIll)));
            }
        }
        this.setInvisible(llllllllllllllIlllIllllIIllIIlll.getBoolean("Invisible"));
        this.setSmall(llllllllllllllIlllIllllIIllIIlll.getBoolean("Small"));
        this.setShowArms(llllllllllllllIlllIllllIIllIIlll.getBoolean("ShowArms"));
        this.disabledSlots = llllllllllllllIlllIllllIIllIIlll.getInteger("DisabledSlots");
        this.setNoBasePlate(llllllllllllllIlllIllllIIllIIlll.getBoolean("NoBasePlate"));
        this.setMarker(llllllllllllllIlllIllllIIllIIlll.getBoolean("Marker"));
        this.wasMarker = !this.hasMarker();
        this.noClip = this.hasNoGravity();
        final NBTTagCompound llllllllllllllIlllIllllIIllIIIlI = llllllllllllllIlllIllllIIllIIlll.getCompoundTag("Pose");
        this.writePoseToNBT(llllllllllllllIlllIllllIIllIIIlI);
    }
    
    private byte setBit(byte llllllllllllllIlllIlllIlIIlIllIl, final int llllllllllllllIlllIlllIlIIlIllll, final boolean llllllllllllllIlllIlllIlIIlIlIll) {
        if (llllllllllllllIlllIlllIlIIlIlIll) {
            llllllllllllllIlllIlllIlIIlIllIl = (byte)(llllllllllllllIlllIlllIlIIlIllIl | llllllllllllllIlllIlllIlIIlIllll);
        }
        else {
            llllllllllllllIlllIlllIlIIlIllIl = (byte)(llllllllllllllIlllIlllIlIIlIllIl & ~llllllllllllllIlllIlllIlIIlIllll);
        }
        return (byte)llllllllllllllIlllIlllIlIIlIllIl;
    }
    
    public Rotations getLeftLegRotation() {
        return this.leftLegRotation;
    }
    
    public Rotations getRightLegRotation() {
        return this.rightLegRotation;
    }
    
    private void writePoseToNBT(final NBTTagCompound llllllllllllllIlllIllllIIlIIllII) {
        final NBTTagList llllllllllllllIlllIllllIIlIlIIll = llllllllllllllIlllIllllIIlIIllII.getTagList("Head", 5);
        this.setHeadRotation(llllllllllllllIlllIllllIIlIlIIll.hasNoTags() ? EntityArmorStand.DEFAULT_HEAD_ROTATION : new Rotations(llllllllllllllIlllIllllIIlIlIIll));
        final NBTTagList llllllllllllllIlllIllllIIlIlIIlI = llllllllllllllIlllIllllIIlIIllII.getTagList("Body", 5);
        this.setBodyRotation(llllllllllllllIlllIllllIIlIlIIlI.hasNoTags() ? EntityArmorStand.DEFAULT_BODY_ROTATION : new Rotations(llllllllllllllIlllIllllIIlIlIIlI));
        final NBTTagList llllllllllllllIlllIllllIIlIlIIIl = llllllllllllllIlllIllllIIlIIllII.getTagList("LeftArm", 5);
        this.setLeftArmRotation(llllllllllllllIlllIllllIIlIlIIIl.hasNoTags() ? EntityArmorStand.DEFAULT_LEFTARM_ROTATION : new Rotations(llllllllllllllIlllIllllIIlIlIIIl));
        final NBTTagList llllllllllllllIlllIllllIIlIlIIII = llllllllllllllIlllIllllIIlIIllII.getTagList("RightArm", 5);
        this.setRightArmRotation(llllllllllllllIlllIllllIIlIlIIII.hasNoTags() ? EntityArmorStand.DEFAULT_RIGHTARM_ROTATION : new Rotations(llllllllllllllIlllIllllIIlIlIIII));
        final NBTTagList llllllllllllllIlllIllllIIlIIllll = llllllllllllllIlllIllllIIlIIllII.getTagList("LeftLeg", 5);
        this.setLeftLegRotation(llllllllllllllIlllIllllIIlIIllll.hasNoTags() ? EntityArmorStand.DEFAULT_LEFTLEG_ROTATION : new Rotations(llllllllllllllIlllIllllIIlIIllll));
        final NBTTagList llllllllllllllIlllIllllIIlIIlllI = llllllllllllllIlllIllllIIlIIllII.getTagList("RightLeg", 5);
        this.setRightLegRotation(llllllllllllllIlllIllllIIlIIlllI.hasNoTags() ? EntityArmorStand.DEFAULT_RIGHTLEG_ROTATION : new Rotations(llllllllllllllIlllIllllIIlIIlllI));
    }
    
    private void setNoBasePlate(final boolean llllllllllllllIlllIlllIlIlIIIIIl) {
        this.dataManager.set(EntityArmorStand.STATUS, this.setBit(this.dataManager.get(EntityArmorStand.STATUS), 8, llllllllllllllIlllIlllIlIlIIIIIl));
    }
    
    public void setLeftLegRotation(final Rotations llllllllllllllIlllIlllIlIIIIllll) {
        this.leftLegRotation = llllllllllllllIlllIlllIlIIIIllll;
        this.dataManager.set(EntityArmorStand.LEFT_LEG_ROTATION, llllllllllllllIlllIlllIlIIIIllll);
    }
    
    @Override
    public double getYOffset() {
        return this.hasMarker() ? 0.0 : 0.10000000149011612;
    }
    
    @Override
    public void onKillCommand() {
        this.setDead();
    }
    
    private void func_190773_I() {
        this.world.playSound(null, this.posX, this.posY, this.posZ, SoundEvents.ENTITY_ARMORSTAND_BREAK, this.getSoundCategory(), 1.0f, 1.0f);
    }
    
    @Override
    public void setRotationYawHead(final float llllllllllllllIlllIlllIllIIIllII) {
        this.prevRotationYaw = llllllllllllllIlllIlllIllIIIllII;
        this.prevRenderYawOffset = llllllllllllllIlllIlllIllIIIllII;
        this.rotationYawHead = llllllllllllllIlllIlllIllIIIllII;
        this.prevRotationYawHead = llllllllllllllIlllIlllIllIIIllII;
    }
}
