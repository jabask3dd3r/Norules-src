package net.minecraft.entity.player;

import net.minecraft.entity.projectile.*;
import javax.annotation.*;
import com.mojang.authlib.*;
import net.minecraft.util.math.*;
import net.minecraft.block.properties.*;
import net.minecraft.entity.monster.*;
import com.google.common.base.*;
import net.minecraft.network.datasync.*;
import net.minecraft.client.*;
import me.nrules.event.events.*;
import net.minecraft.block.*;
import net.minecraft.stats.*;
import net.minecraft.block.state.*;
import net.minecraft.enchantment.*;
import net.minecraft.block.material.*;
import net.minecraft.init.*;
import net.minecraft.entity.item.*;
import java.util.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.util.datafix.*;
import net.minecraft.nbt.*;
import net.minecraft.inventory.*;
import net.minecraft.entity.passive.*;
import com.google.common.collect.*;
import net.minecraft.item.crafting.*;
import net.minecraft.tileentity.*;
import java.nio.charset.*;
import net.minecraft.util.*;
import net.minecraft.scoreboard.*;
import net.minecraft.util.text.*;
import net.minecraft.util.text.event.*;
import me.nrules.*;
import me.nrules.module.player.*;
import net.minecraft.world.*;
import net.minecraft.item.*;
import me.nrules.module.movement.*;
import net.minecraft.network.play.server.*;
import net.minecraft.network.*;
import net.minecraft.entity.*;

public abstract class EntityPlayer extends EntityLivingBase
{
    protected /* synthetic */ boolean sleeping;
    private final /* synthetic */ CooldownTracker cooldownTracker;
    private /* synthetic */ BlockPos spawnChunk;
    protected static final /* synthetic */ DataParameter<NBTTagCompound> field_192032_bt;
    private static final /* synthetic */ DataParameter<Float> ABSORPTION;
    public /* synthetic */ int xpCooldown;
    public /* synthetic */ double prevChasingPosX;
    public /* synthetic */ int experienceLevel;
    private /* synthetic */ boolean spawnForced;
    private /* synthetic */ ItemStack itemStackMainHand;
    public /* synthetic */ double chasingPosZ;
    protected /* synthetic */ InventoryEnderChest theInventoryEnderChest;
    public /* synthetic */ int experienceTotal;
    public /* synthetic */ double prevChasingPosZ;
    public /* synthetic */ float cameraYaw;
    protected static final /* synthetic */ DataParameter<Byte> PLAYER_MODEL_FLAG;
    public /* synthetic */ double prevChasingPosY;
    public /* synthetic */ PlayerCapabilities capabilities;
    public /* synthetic */ float speedInAir;
    protected static final /* synthetic */ DataParameter<NBTTagCompound> field_192033_bu;
    protected static final /* synthetic */ DataParameter<Byte> MAIN_HAND;
    public /* synthetic */ Container inventoryContainer;
    public /* synthetic */ float experience;
    public /* synthetic */ double chasingPosX;
    public /* synthetic */ float renderOffsetX;
    private /* synthetic */ int sleepTimer;
    private static final /* synthetic */ DataParameter<Integer> PLAYER_SCORE;
    public /* synthetic */ InventoryPlayer inventory;
    public /* synthetic */ double chasingPosY;
    protected /* synthetic */ int xpSeed;
    public /* synthetic */ float prevCameraYaw;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing;
    private /* synthetic */ int lastXPSound;
    protected /* synthetic */ FoodStats foodStats;
    protected /* synthetic */ int flyToggleTimer;
    public /* synthetic */ BlockPos bedLocation;
    public /* synthetic */ float renderOffsetZ;
    private final /* synthetic */ GameProfile gameProfile;
    public /* synthetic */ Container openContainer;
    private /* synthetic */ boolean hasReducedDebug;
    
    public boolean isWearing(final EnumPlayerModelParts lllllllllllllIIIIllllIIIlIllIllI) {
        return (this.getDataManager().get(EntityPlayer.PLAYER_MODEL_FLAG) & lllllllllllllIIIIllllIIIlIllIllI.getPartMask()) == lllllllllllllIIIIllllIIIlIllIllI.getPartMask();
    }
    
    protected void updateSize() {
        float lllllllllllllIIIIlllllIIIIlIllll = 0.0f;
        float lllllllllllllIIIIlllllIIIIlIlIll = 0.0f;
        if (this.isElytraFlying()) {
            final float lllllllllllllIIIIlllllIIIIllIIlI = 0.6f;
            final float lllllllllllllIIIIlllllIIIIlIlllI = 0.6f;
        }
        else if (this.isPlayerSleeping()) {
            final float lllllllllllllIIIIlllllIIIIllIIIl = 0.2f;
            final float lllllllllllllIIIIlllllIIIIlIllIl = 0.2f;
        }
        else if (this.isSneaking()) {
            final float lllllllllllllIIIIlllllIIIIllIIII = 0.6f;
            final float lllllllllllllIIIIlllllIIIIlIllII = 1.65f;
        }
        else {
            lllllllllllllIIIIlllllIIIIlIllll = 0.6f;
            lllllllllllllIIIIlllllIIIIlIlIll = 1.8f;
        }
        if (lllllllllllllIIIIlllllIIIIlIllll != this.width || lllllllllllllIIIIlllllIIIIlIlIll != this.height) {
            AxisAlignedBB lllllllllllllIIIIlllllIIIIlIlIlI = this.getEntityBoundingBox();
            lllllllllllllIIIIlllllIIIIlIlIlI = new AxisAlignedBB(lllllllllllllIIIIlllllIIIIlIlIlI.minX, lllllllllllllIIIIlllllIIIIlIlIlI.minY, lllllllllllllIIIIlllllIIIIlIlIlI.minZ, lllllllllllllIIIIlllllIIIIlIlIlI.minX + lllllllllllllIIIIlllllIIIIlIllll, lllllllllllllIIIIlllllIIIIlIlIlI.minY + lllllllllllllIIIIlllllIIIIlIlIll, lllllllllllllIIIIlllllIIIIlIlIlI.minZ + lllllllllllllIIIIlllllIIIIlIllll);
            if (!this.world.collidesWithAnyBlock(lllllllllllllIIIIlllllIIIIlIlIlI)) {
                this.setSize(lllllllllllllIIIIlllllIIIIlIllll, lllllllllllllIIIIlllllIIIIlIlIll);
            }
        }
    }
    
    @Override
    public void onDeath(final DamageSource lllllllllllllIIIIllllIlllIlIlllI) {
        super.onDeath(lllllllllllllIIIIllllIlllIlIlllI);
        this.setSize(0.2f, 0.2f);
        this.setPosition(this.posX, this.posY, this.posZ);
        this.motionY = 0.10000000149011612;
        if ("Notch".equals(this.getName())) {
            this.dropItem(new ItemStack(Items.APPLE, 1), true, false);
        }
        if (!this.world.getGameRules().getBoolean("keepInventory") && !this.isSpectator()) {
            this.func_190776_cN();
            this.inventory.dropAllItems();
        }
        if (lllllllllllllIIIIllllIlllIlIlllI != null) {
            this.motionX = -MathHelper.cos((this.attackedAtYaw + this.rotationYaw) * 0.017453292f) * 0.1f;
            this.motionZ = -MathHelper.sin((this.attackedAtYaw + this.rotationYaw) * 0.017453292f) * 0.1f;
        }
        else {
            this.motionX = 0.0;
            this.motionZ = 0.0;
        }
        this.addStat(StatList.DEATHS);
        this.takeStat(StatList.TIME_SINCE_DEATH);
        this.extinguish();
        this.setFlag(0, false);
    }
    
    public float getCooldownPeriod() {
        return (float)(1.0 / this.getEntityAttribute(SharedMonsterAttributes.ATTACK_SPEED).getAttributeValue() * 20.0);
    }
    
    public SleepResult trySleep(final BlockPos lllllllllllllIIIIllllIlIIlIlIlIl) {
        final EnumFacing lllllllllllllIIIIllllIlIIlIlllII = this.world.getBlockState(lllllllllllllIIIIllllIlIIlIlIlIl).getValue((IProperty<EnumFacing>)BlockHorizontal.FACING);
        if (!this.world.isRemote) {
            if (this.isPlayerSleeping() || !this.isEntityAlive()) {
                return SleepResult.OTHER_PROBLEM;
            }
            if (!this.world.provider.isSurfaceWorld()) {
                return SleepResult.NOT_POSSIBLE_HERE;
            }
            if (this.world.isDaytime()) {
                return SleepResult.NOT_POSSIBLE_NOW;
            }
            if (!this.func_190774_a(lllllllllllllIIIIllllIlIIlIlIlIl, lllllllllllllIIIIllllIlIIlIlllII)) {
                return SleepResult.TOO_FAR_AWAY;
            }
            final double lllllllllllllIIIIllllIlIIlIllIll = 8.0;
            final double lllllllllllllIIIIllllIlIIlIllIlI = 5.0;
            final List<EntityMob> lllllllllllllIIIIllllIlIIlIllIIl = this.world.getEntitiesWithinAABB((Class<? extends EntityMob>)EntityMob.class, new AxisAlignedBB(lllllllllllllIIIIllllIlIIlIlIlIl.getX() - 8.0, lllllllllllllIIIIllllIlIIlIlIlIl.getY() - 5.0, lllllllllllllIIIIllllIlIIlIlIlIl.getZ() - 8.0, lllllllllllllIIIIllllIlIIlIlIlIl.getX() + 8.0, lllllllllllllIIIIllllIlIIlIlIlIl.getY() + 5.0, lllllllllllllIIIIllllIlIIlIlIlIl.getZ() + 8.0), (com.google.common.base.Predicate<? super EntityMob>)new SleepEnemyPredicate(this, null));
            if (!lllllllllllllIIIIllllIlIIlIllIIl.isEmpty()) {
                return SleepResult.NOT_SAFE;
            }
        }
        if (this.isRiding()) {
            this.dismountRidingEntity();
        }
        this.func_192030_dh();
        this.setSize(0.2f, 0.2f);
        if (this.world.isBlockLoaded(lllllllllllllIIIIllllIlIIlIlIlIl)) {
            final float lllllllllllllIIIIllllIlIIlIllIII = 0.5f + lllllllllllllIIIIllllIlIIlIlllII.getFrontOffsetX() * 0.4f;
            final float lllllllllllllIIIIllllIlIIlIlIlll = 0.5f + lllllllllllllIIIIllllIlIIlIlllII.getFrontOffsetZ() * 0.4f;
            this.setRenderOffsetForSleep(lllllllllllllIIIIllllIlIIlIlllII);
            this.setPosition(lllllllllllllIIIIllllIlIIlIlIlIl.getX() + lllllllllllllIIIIllllIlIIlIllIII, lllllllllllllIIIIllllIlIIlIlIlIl.getY() + 0.6875f, lllllllllllllIIIIllllIlIIlIlIlIl.getZ() + lllllllllllllIIIIllllIlIIlIlIlll);
        }
        else {
            this.setPosition(lllllllllllllIIIIllllIlIIlIlIlIl.getX() + 0.5f, lllllllllllllIIIIllllIlIIlIlIlIl.getY() + 0.6875f, lllllllllllllIIIIllllIlIIlIlIlIl.getZ() + 0.5f);
        }
        this.sleeping = true;
        this.sleepTimer = 0;
        this.bedLocation = lllllllllllllIIIIllllIlIIlIlIlIl;
        this.motionX = 0.0;
        this.motionY = 0.0;
        this.motionZ = 0.0;
        if (!this.world.isRemote) {
            this.world.updateAllPlayersSleepingFlag();
        }
        return SleepResult.OK;
    }
    
    @Override
    public boolean isPlayerSleeping() {
        return this.sleeping;
    }
    
    static {
        ABSORPTION = EntityDataManager.createKey(EntityPlayer.class, DataSerializers.FLOAT);
        PLAYER_SCORE = EntityDataManager.createKey(EntityPlayer.class, DataSerializers.VARINT);
        PLAYER_MODEL_FLAG = EntityDataManager.createKey(EntityPlayer.class, DataSerializers.BYTE);
        MAIN_HAND = EntityDataManager.createKey(EntityPlayer.class, DataSerializers.BYTE);
        field_192032_bt = EntityDataManager.createKey(EntityPlayer.class, DataSerializers.field_192734_n);
        field_192033_bu = EntityDataManager.createKey(EntityPlayer.class, DataSerializers.field_192734_n);
    }
    
    public void jump() {
        if (this == Minecraft.getMinecraft().player) {
            final JumpEvent lllllllllllllIIIIllllIIllllIIIIl = new JumpEvent();
            lllllllllllllIIIIllllIIllllIIIIl.call();
            if (lllllllllllllIIIIllllIIllllIIIIl.isCancelled()) {
                return;
            }
        }
        super.jump();
        this.addStat(StatList.JUMP);
        if (this.isSprinting()) {
            this.addExhaustion(0.2f);
        }
        else {
            this.addExhaustion(0.05f);
        }
    }
    
    public void preparePlayerToSpawn() {
        this.setSize(0.6f, 1.8f);
        super.preparePlayerToSpawn();
        this.setHealth(this.getMaxHealth());
        this.deathTime = 0;
    }
    
    public void displayVillagerTradeGui(final IMerchant lllllllllllllIIIIllllIlIlllIlIll) {
    }
    
    protected CooldownTracker createCooldownTracker() {
        return new CooldownTracker();
    }
    
    public void func_192024_a(final ItemStack lllllllllllllIIIIllllIIlIlllIIll, final int lllllllllllllIIIIllllIIlIlllIIII) {
        this.experienceLevel -= lllllllllllllIIIIllllIIlIlllIIII;
        if (this.experienceLevel < 0) {
            this.experienceLevel = 0;
            this.experience = 0.0f;
            this.experienceTotal = 0;
        }
        this.xpSeed = this.rand.nextInt();
    }
    
    public boolean isPlayerFullyAsleep() {
        return this.sleeping && this.sleepTimer >= 100;
    }
    
    public void func_193102_a(final ResourceLocation[] lllllllllllllIIIIllllIIllllIIlll) {
    }
    
    public abstract boolean isCreative();
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound lllllllllllllIIIIllllIllIlIIIlII) {
        super.readEntityFromNBT(lllllllllllllIIIIllllIllIlIIIlII);
        this.setUniqueId(getUUID(this.gameProfile));
        final NBTTagList lllllllllllllIIIIllllIllIlIIIlll = lllllllllllllIIIIllllIllIlIIIlII.getTagList("Inventory", 10);
        this.inventory.readFromNBT(lllllllllllllIIIIllllIllIlIIIlll);
        this.inventory.currentItem = lllllllllllllIIIIllllIllIlIIIlII.getInteger("SelectedItemSlot");
        this.sleeping = lllllllllllllIIIIllllIllIlIIIlII.getBoolean("Sleeping");
        this.sleepTimer = lllllllllllllIIIIllllIllIlIIIlII.getShort("SleepTimer");
        this.experience = lllllllllllllIIIIllllIllIlIIIlII.getFloat("XpP");
        this.experienceLevel = lllllllllllllIIIIllllIllIlIIIlII.getInteger("XpLevel");
        this.experienceTotal = lllllllllllllIIIIllllIllIlIIIlII.getInteger("XpTotal");
        this.xpSeed = lllllllllllllIIIIllllIllIlIIIlII.getInteger("XpSeed");
        if (this.xpSeed == 0) {
            this.xpSeed = this.rand.nextInt();
        }
        this.setScore(lllllllllllllIIIIllllIllIlIIIlII.getInteger("Score"));
        if (this.sleeping) {
            this.bedLocation = new BlockPos(this);
            this.wakeUpPlayer(true, true, false);
        }
        if (lllllllllllllIIIIllllIllIlIIIlII.hasKey("SpawnX", 99) && lllllllllllllIIIIllllIllIlIIIlII.hasKey("SpawnY", 99) && lllllllllllllIIIIllllIllIlIIIlII.hasKey("SpawnZ", 99)) {
            this.spawnChunk = new BlockPos(lllllllllllllIIIIllllIllIlIIIlII.getInteger("SpawnX"), lllllllllllllIIIIllllIllIlIIIlII.getInteger("SpawnY"), lllllllllllllIIIIllllIllIlIIIlII.getInteger("SpawnZ"));
            this.spawnForced = lllllllllllllIIIIllllIllIlIIIlII.getBoolean("SpawnForced");
        }
        this.foodStats.readNBT(lllllllllllllIIIIllllIllIlIIIlII);
        this.capabilities.readCapabilitiesFromNBT(lllllllllllllIIIIllllIllIlIIIlII);
        if (lllllllllllllIIIIllllIllIlIIIlII.hasKey("EnderItems", 9)) {
            final NBTTagList lllllllllllllIIIIllllIllIlIIIllI = lllllllllllllIIIIllllIllIlIIIlII.getTagList("EnderItems", 10);
            this.theInventoryEnderChest.loadInventoryFromNBT(lllllllllllllIIIIllllIllIlIIIllI);
        }
        if (lllllllllllllIIIIllllIllIlIIIlII.hasKey("ShoulderEntityLeft", 10)) {
            this.func_192029_h(lllllllllllllIIIIllllIllIlIIIlII.getCompoundTag("ShoulderEntityLeft"));
        }
        if (lllllllllllllIIIIllllIllIlIIIlII.hasKey("ShoulderEntityRight", 10)) {
            this.func_192031_i(lllllllllllllIIIIllllIllIlIIIlII.getCompoundTag("ShoulderEntityRight"));
        }
    }
    
    public int xpBarCap() {
        if (this.experienceLevel >= 30) {
            return 112 + (this.experienceLevel - 30) * 9;
        }
        return (this.experienceLevel >= 15) ? (37 + (this.experienceLevel - 15) * 5) : (7 + this.experienceLevel * 2);
    }
    
    @Override
    public int getMaxInPortalTime() {
        return this.capabilities.disableDamage ? 1 : 80;
    }
    
    public void resetCooldown() {
        this.ticksSinceLastSwing = 0;
    }
    
    public boolean isUser() {
        return false;
    }
    
    public void addExhaustion(final float lllllllllllllIIIIllllIIlIlIllllI) {
        if (!this.capabilities.disableDamage && !this.world.isRemote) {
            this.foodStats.addExhaustion(lllllllllllllIIIIllllIIlIlIllllI);
        }
    }
    
    @Override
    public boolean replaceItemInInventory(final int lllllllllllllIIIIllllIIIlIlIllII, final ItemStack lllllllllllllIIIIllllIIIlIlIlIll) {
        if (lllllllllllllIIIIllllIIIlIlIllII >= 0 && lllllllllllllIIIIllllIIIlIlIllII < this.inventory.mainInventory.size()) {
            this.inventory.setInventorySlotContents(lllllllllllllIIIIllllIIIlIlIllII, lllllllllllllIIIIllllIIIlIlIlIll);
            return true;
        }
        EntityEquipmentSlot lllllllllllllIIIIllllIIIlIlIIllI = null;
        if (lllllllllllllIIIIllllIIIlIlIllII == 100 + EntityEquipmentSlot.HEAD.getIndex()) {
            final EntityEquipmentSlot lllllllllllllIIIIllllIIIlIlIlIlI = EntityEquipmentSlot.HEAD;
        }
        else if (lllllllllllllIIIIllllIIIlIlIllII == 100 + EntityEquipmentSlot.CHEST.getIndex()) {
            final EntityEquipmentSlot lllllllllllllIIIIllllIIIlIlIlIIl = EntityEquipmentSlot.CHEST;
        }
        else if (lllllllllllllIIIIllllIIIlIlIllII == 100 + EntityEquipmentSlot.LEGS.getIndex()) {
            final EntityEquipmentSlot lllllllllllllIIIIllllIIIlIlIlIII = EntityEquipmentSlot.LEGS;
        }
        else if (lllllllllllllIIIIllllIIIlIlIllII == 100 + EntityEquipmentSlot.FEET.getIndex()) {
            final EntityEquipmentSlot lllllllllllllIIIIllllIIIlIlIIlll = EntityEquipmentSlot.FEET;
        }
        else {
            lllllllllllllIIIIllllIIIlIlIIllI = null;
        }
        if (lllllllllllllIIIIllllIIIlIlIllII == 98) {
            this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, lllllllllllllIIIIllllIIIlIlIlIll);
            return true;
        }
        if (lllllllllllllIIIIllllIIIlIlIllII == 99) {
            this.setItemStackToSlot(EntityEquipmentSlot.OFFHAND, lllllllllllllIIIIllllIIIlIlIlIll);
            return true;
        }
        if (lllllllllllllIIIIllllIIIlIlIIllI != null) {
            if (!lllllllllllllIIIIllllIIIlIlIlIll.func_190926_b()) {
                if (!(lllllllllllllIIIIllllIIIlIlIlIll.getItem() instanceof ItemArmor) && !(lllllllllllllIIIIllllIIIlIlIlIll.getItem() instanceof ItemElytra)) {
                    if (lllllllllllllIIIIllllIIIlIlIIllI != EntityEquipmentSlot.HEAD) {
                        return false;
                    }
                }
                else if (EntityLiving.getSlotForItemStack(lllllllllllllIIIIllllIIIlIlIlIll) != lllllllllllllIIIIllllIIIlIlIIllI) {
                    return false;
                }
            }
            this.inventory.setInventorySlotContents(lllllllllllllIIIIllllIIIlIlIIllI.getIndex() + this.inventory.mainInventory.size(), lllllllllllllIIIIllllIIIlIlIlIll);
            return true;
        }
        final int lllllllllllllIIIIllllIIIlIlIIlIl = lllllllllllllIIIIllllIIIlIlIllII - 200;
        if (lllllllllllllIIIIllllIIIlIlIIlIl >= 0 && lllllllllllllIIIIllllIIIlIlIIlIl < this.theInventoryEnderChest.getSizeInventory()) {
            this.theInventoryEnderChest.setInventorySlotContents(lllllllllllllIIIIllllIIIlIlIIlIl, lllllllllllllIIIIllllIIIlIlIlIll);
            return true;
        }
        return false;
    }
    
    public Scoreboard getWorldScoreboard() {
        return this.world.getScoreboard();
    }
    
    public BlockPos getBedLocation() {
        return this.spawnChunk;
    }
    
    @Override
    protected void damageEntity(final DamageSource lllllllllllllIIIIllllIlIllllllIl, float lllllllllllllIIIIllllIlIllllIlll) {
        if (!this.isEntityInvulnerable(lllllllllllllIIIIllllIlIllllllIl)) {
            lllllllllllllIIIIllllIlIllllIlll = (short)this.applyArmorCalculations(lllllllllllllIIIIllllIlIllllllIl, lllllllllllllIIIIllllIlIllllIlll);
            final float lllllllllllllIIIIllllIlIlllllIll;
            lllllllllllllIIIIllllIlIllllIlll = (short)(lllllllllllllIIIIllllIlIlllllIll = this.applyPotionDamageCalculations(lllllllllllllIIIIllllIlIllllllIl, lllllllllllllIIIIllllIlIllllIlll));
            lllllllllllllIIIIllllIlIllllIlll = (short)Math.max(lllllllllllllIIIIllllIlIllllIlll - this.getAbsorptionAmount(), 0.0f);
            this.setAbsorptionAmount(this.getAbsorptionAmount() - (lllllllllllllIIIIllllIlIlllllIll - lllllllllllllIIIIllllIlIllllIlll));
            if (lllllllllllllIIIIllllIlIllllIlll != 0.0f) {
                this.addExhaustion(lllllllllllllIIIIllllIlIllllllIl.getHungerDamage());
                final float lllllllllllllIIIIllllIlIlllllIlI = this.getHealth();
                this.setHealth(this.getHealth() - lllllllllllllIIIIllllIlIllllIlll);
                this.getCombatTracker().trackDamage(lllllllllllllIIIIllllIlIllllllIl, lllllllllllllIIIIllllIlIlllllIlI, lllllllllllllIIIIllllIlIllllIlll);
                if (lllllllllllllIIIIllllIlIllllIlll < 3.4028235E37f) {
                    this.addStat(StatList.DAMAGE_TAKEN, Math.round(lllllllllllllIIIIllllIlIllllIlll * 10.0f));
                }
            }
        }
    }
    
    @Override
    public void func_191986_a(final float lllllllllllllIIIIllllIIlllIlIlII, final float lllllllllllllIIIIllllIIlllIlIIll, final float lllllllllllllIIIIllllIIlllIIlIIl) {
        final double lllllllllllllIIIIllllIIlllIlIIIl = this.posX;
        final double lllllllllllllIIIIllllIIlllIlIIII = this.posY;
        final double lllllllllllllIIIIllllIIlllIIllll = this.posZ;
        if (this.capabilities.isFlying && !this.isRiding()) {
            final double lllllllllllllIIIIllllIIlllIIlllI = this.motionY;
            final float lllllllllllllIIIIllllIIlllIIllIl = this.jumpMovementFactor;
            this.jumpMovementFactor = this.capabilities.getFlySpeed() * (this.isSprinting() ? 2 : 1);
            super.func_191986_a(lllllllllllllIIIIllllIIlllIlIlII, lllllllllllllIIIIllllIIlllIlIIll, lllllllllllllIIIIllllIIlllIIlIIl);
            this.motionY = lllllllllllllIIIIllllIIlllIIlllI * 0.6;
            this.jumpMovementFactor = lllllllllllllIIIIllllIIlllIIllIl;
            this.fallDistance = 0.0f;
            this.setFlag(7, false);
        }
        else {
            super.func_191986_a(lllllllllllllIIIIllllIIlllIlIlII, lllllllllllllIIIIllllIIlllIlIIll, lllllllllllllIIIIllllIIlllIIlIIl);
        }
        this.addMovementStat(this.posX - lllllllllllllIIIIllllIIlllIlIIIl, this.posY - lllllllllllllIIIIllllIIlllIlIIII, this.posZ - lllllllllllllIIIIllllIIlllIIllll);
    }
    
    public float getBedOrientationInDegrees() {
        if (this.bedLocation != null) {
            final EnumFacing lllllllllllllIIIIllllIlIIIIlIIll = this.world.getBlockState(this.bedLocation).getValue((IProperty<EnumFacing>)BlockHorizontal.FACING);
            switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllllIIIIllllIlIIIIlIIll.ordinal()]) {
                case 4: {
                    return 90.0f;
                }
                case 5: {
                    return 0.0f;
                }
                case 3: {
                    return 270.0f;
                }
                case 6: {
                    return 180.0f;
                }
            }
        }
        return 0.0f;
    }
    
    @Nullable
    public static BlockPos getBedSpawnLocation(final World lllllllllllllIIIIllllIlIIIIlllII, final BlockPos lllllllllllllIIIIllllIlIIIIllIll, final boolean lllllllllllllIIIIllllIlIIIIllIlI) {
        final Block lllllllllllllIIIIllllIlIIIIlllll = lllllllllllllIIIIllllIlIIIIlllII.getBlockState(lllllllllllllIIIIllllIlIIIIllIll).getBlock();
        if (lllllllllllllIIIIllllIlIIIIlllll == Blocks.BED) {
            return BlockBed.getSafeExitLocation(lllllllllllllIIIIllllIlIIIIlllII, lllllllllllllIIIIllllIlIIIIllIll, 0);
        }
        if (!lllllllllllllIIIIllllIlIIIIllIlI) {
            return null;
        }
        final boolean lllllllllllllIIIIllllIlIIIIllllI = lllllllllllllIIIIllllIlIIIIlllll.canSpawnInBlock();
        final boolean lllllllllllllIIIIllllIlIIIIlllIl = lllllllllllllIIIIllllIlIIIIlllII.getBlockState(lllllllllllllIIIIllllIlIIIIllIll.up()).getBlock().canSpawnInBlock();
        return (lllllllllllllIIIIllllIlIIIIllllI && lllllllllllllIIIIllllIlIIIIlllIl) ? lllllllllllllIIIIllllIlIIIIllIll : null;
    }
    
    @Override
    protected void resetHeight() {
        if (!this.isSpectator()) {
            super.resetHeight();
        }
    }
    
    public NBTTagCompound func_192023_dk() {
        return this.dataManager.get(EntityPlayer.field_192032_bt);
    }
    
    public void openGuiHorseInventory(final AbstractHorse lllllllllllllIIIIllllIlIlllIIlll, final IInventory lllllllllllllIIIIllllIlIlllIIllI) {
    }
    
    @Override
    public void applyEntityCollision(final Entity lllllllllllllIIIIllllIIIIllIIlll) {
        if (!this.isPlayerSleeping()) {
            super.applyEntityCollision(lllllllllllllIIIIllllIIIIllIIlll);
        }
    }
    
    public void openEditStructure(final TileEntityStructure lllllllllllllIIIIllllIlIlllIllIl) {
    }
    
    public GameProfile getGameProfile() {
        return this.gameProfile;
    }
    
    public int getXPSeed() {
        return this.xpSeed;
    }
    
    @Override
    public void onKillEntity(final EntityLivingBase lllllllllllllIIIIllllIIllIIIlIlI) {
        final EntityList.EntityEggInfo lllllllllllllIIIIllllIIllIIIlIIl = EntityList.ENTITY_EGGS.get(EntityList.func_191301_a(lllllllllllllIIIIllllIIllIIIlIlI));
        if (lllllllllllllIIIIllllIIllIIIlIIl != null) {
            this.addStat(lllllllllllllIIIIllllIIllIIIlIIl.killEntityStat);
        }
    }
    
    protected void func_192031_i(final NBTTagCompound lllllllllllllIIIIllllIIIIllllllI) {
        this.dataManager.set(EntityPlayer.field_192033_bu, lllllllllllllIIIIllllIIIIllllllI);
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(1.0);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.10000000149011612);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_SPEED);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.LUCK);
    }
    
    public void takeStat(final StatBase lllllllllllllIIIIllllIIllllIlIll) {
    }
    
    public ItemStack getEquipmentInSlot(final int lllllllllllllIIIIllllIllIlIlIIII) {
        return (lllllllllllllIIIIllllIllIlIlIIII == 0) ? this.inventory.getCurrentItem() : this.inventory.armorInventory.get(lllllllllllllIIIIllllIllIlIlIIII - 1);
    }
    
    @Override
    public void updateRidden() {
        if (!this.world.isRemote && this.isSneaking() && this.isRiding()) {
            this.dismountRidingEntity();
            this.setSneaking(false);
        }
        else {
            final double lllllllllllllIIIIllllIlllllllllI = this.posX;
            final double lllllllllllllIIIIllllIllllllllIl = this.posY;
            final double lllllllllllllIIIIllllIllllllllII = this.posZ;
            final float lllllllllllllIIIIllllIlllllllIll = this.rotationYaw;
            final float lllllllllllllIIIIllllIlllllllIlI = this.rotationPitch;
            super.updateRidden();
            this.prevCameraYaw = this.cameraYaw;
            this.cameraYaw = 0.0f;
            this.addMountedMovementStat(this.posX - lllllllllllllIIIIllllIlllllllllI, this.posY - lllllllllllllIIIIllllIllllllllIl, this.posZ - lllllllllllllIIIIllllIllllllllII);
            if (this.getRidingEntity() instanceof EntityPig) {
                this.rotationPitch = lllllllllllllIIIIllllIlllllllIlI;
                this.rotationYaw = lllllllllllllIIIIllllIlllllllIll;
                this.renderYawOffset = ((EntityPig)this.getRidingEntity()).renderYawOffset;
            }
        }
    }
    
    private void collideWithPlayer(final Entity lllllllllllllIIIIllllIllllIIlIII) {
        lllllllllllllIIIIllllIllllIIlIII.onCollideWithPlayer(this);
    }
    
    @Nullable
    public EntityItem dropItem(final ItemStack lllllllllllllIIIIllllIllIlllllII, final boolean lllllllllllllIIIIllllIlllIIIIllI, final boolean lllllllllllllIIIIllllIlllIIIIlIl) {
        if (lllllllllllllIIIIllllIllIlllllII.func_190926_b()) {
            return null;
        }
        final double lllllllllllllIIIIllllIlllIIIIlII = this.posY - 0.30000001192092896 + this.getEyeHeight();
        final EntityItem lllllllllllllIIIIllllIlllIIIIIll = new EntityItem(this.world, this.posX, lllllllllllllIIIIllllIlllIIIIlII, this.posZ, lllllllllllllIIIIllllIllIlllllII);
        lllllllllllllIIIIllllIlllIIIIIll.setPickupDelay(40);
        if (lllllllllllllIIIIllllIlllIIIIlIl) {
            lllllllllllllIIIIllllIlllIIIIIll.setThrower(this.getName());
        }
        if (lllllllllllllIIIIllllIlllIIIIllI) {
            final float lllllllllllllIIIIllllIlllIIIIIlI = this.rand.nextFloat() * 0.5f;
            final float lllllllllllllIIIIllllIlllIIIIIIl = this.rand.nextFloat() * 6.2831855f;
            lllllllllllllIIIIllllIlllIIIIIll.motionX = -MathHelper.sin(lllllllllllllIIIIllllIlllIIIIIIl) * lllllllllllllIIIIllllIlllIIIIIlI;
            lllllllllllllIIIIllllIlllIIIIIll.motionZ = MathHelper.cos(lllllllllllllIIIIllllIlllIIIIIIl) * lllllllllllllIIIIllllIlllIIIIIlI;
            lllllllllllllIIIIllllIlllIIIIIll.motionY = 0.20000000298023224;
        }
        else {
            float lllllllllllllIIIIllllIlllIIIIIII = 0.3f;
            lllllllllllllIIIIllllIlllIIIIIll.motionX = -MathHelper.sin(this.rotationYaw * 0.017453292f) * MathHelper.cos(this.rotationPitch * 0.017453292f) * lllllllllllllIIIIllllIlllIIIIIII;
            lllllllllllllIIIIllllIlllIIIIIll.motionZ = MathHelper.cos(this.rotationYaw * 0.017453292f) * MathHelper.cos(this.rotationPitch * 0.017453292f) * lllllllllllllIIIIllllIlllIIIIIII;
            lllllllllllllIIIIllllIlllIIIIIll.motionY = -MathHelper.sin(this.rotationPitch * 0.017453292f) * lllllllllllllIIIIllllIlllIIIIIII + 0.1f;
            final float lllllllllllllIIIIllllIllIlllllll = this.rand.nextFloat() * 6.2831855f;
            lllllllllllllIIIIllllIlllIIIIIII = 0.02f * this.rand.nextFloat();
            final EntityItem entityItem = lllllllllllllIIIIllllIlllIIIIIll;
            entityItem.motionX += Math.cos(lllllllllllllIIIIllllIllIlllllll) * lllllllllllllIIIIllllIlllIIIIIII;
            final EntityItem entityItem2 = lllllllllllllIIIIllllIlllIIIIIll;
            entityItem2.motionY += (this.rand.nextFloat() - this.rand.nextFloat()) * 0.1f;
            final EntityItem entityItem3 = lllllllllllllIIIIllllIlllIIIIIll;
            entityItem3.motionZ += Math.sin(lllllllllllllIIIIllllIllIlllllll) * lllllllllllllIIIIllllIlllIIIIIII;
        }
        final ItemStack lllllllllllllIIIIllllIllIllllllI = this.dropItemAndGetStack(lllllllllllllIIIIllllIlllIIIIIll);
        if (lllllllllllllIIIIllllIlllIIIIlIl) {
            if (!lllllllllllllIIIIllllIllIllllllI.func_190926_b()) {
                this.addStat(StatList.getDroppedObjectStats(lllllllllllllIIIIllllIllIllllllI.getItem()), lllllllllllllIIIIllllIllIlllllII.func_190916_E());
            }
            this.addStat(StatList.DROP);
        }
        return lllllllllllllIIIIllllIlllIIIIIll;
    }
    
    public float getDigSpeed(final IBlockState lllllllllllllIIIIllllIllIllIIIII) {
        float lllllllllllllIIIIllllIllIllIlIII = this.inventory.getStrVsBlock(lllllllllllllIIIIllllIllIllIIIII);
        if (lllllllllllllIIIIllllIllIllIlIII > 1.0f) {
            final int lllllllllllllIIIIllllIllIllIIlll = EnchantmentHelper.getEfficiencyModifier(this);
            final ItemStack lllllllllllllIIIIllllIllIllIIllI = this.getHeldItemMainhand();
            if (lllllllllllllIIIIllllIllIllIIlll > 0 && !lllllllllllllIIIIllllIllIllIIllI.func_190926_b()) {
                lllllllllllllIIIIllllIllIllIlIII += lllllllllllllIIIIllllIllIllIIlll * lllllllllllllIIIIllllIllIllIIlll + 1;
            }
        }
        if (this.isPotionActive(MobEffects.HASTE)) {
            lllllllllllllIIIIllllIllIllIlIII *= 1.0f + (this.getActivePotionEffect(MobEffects.HASTE).getAmplifier() + 1) * 0.2f;
        }
        if (this.isPotionActive(MobEffects.MINING_FATIGUE)) {
            final float lllllllllllllIIIIllllIllIllIIIlI;
            switch (this.getActivePotionEffect(MobEffects.MINING_FATIGUE).getAmplifier()) {
                case 0: {
                    final float lllllllllllllIIIIllllIllIllIIlIl = 0.3f;
                    break;
                }
                case 1: {
                    final float lllllllllllllIIIIllllIllIllIIlII = 0.09f;
                    break;
                }
                case 2: {
                    final float lllllllllllllIIIIllllIllIllIIIll = 0.0027f;
                    break;
                }
                default: {
                    lllllllllllllIIIIllllIllIllIIIlI = 8.1E-4f;
                    break;
                }
            }
            lllllllllllllIIIIllllIllIllIlIII *= lllllllllllllIIIIllllIllIllIIIlI;
        }
        if (this.isInsideOfMaterial(Material.WATER) && !EnchantmentHelper.getAquaAffinityModifier(this)) {
            lllllllllllllIIIIllllIllIllIlIII /= 5.0f;
        }
        if (!this.onGround) {
            lllllllllllllIIIIllllIllIllIlIII /= 5.0f;
        }
        return lllllllllllllIIIIllllIllIllIlIII;
    }
    
    public float getCooledAttackStrength(final float lllllllllllllIIIIllllIIIIlllIlIl) {
        return MathHelper.clamp((this.ticksSinceLastSwing + lllllllllllllIIIIllllIIIIlllIlIl) / this.getCooldownPeriod(), 0.0f, 1.0f);
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(EntityPlayer.ABSORPTION, 0.0f);
        this.dataManager.register(EntityPlayer.PLAYER_SCORE, 0);
        this.dataManager.register(EntityPlayer.PLAYER_MODEL_FLAG, (Byte)0);
        this.dataManager.register(EntityPlayer.MAIN_HAND, (Byte)1);
        this.dataManager.register(EntityPlayer.field_192032_bt, new NBTTagCompound());
        this.dataManager.register(EntityPlayer.field_192033_bu, new NBTTagCompound());
    }
    
    @Override
    protected boolean isMovementBlocked() {
        return this.getHealth() <= 0.0f || this.isPlayerSleeping();
    }
    
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_PLAYER_DEATH;
    }
    
    protected void func_192029_h(final NBTTagCompound lllllllllllllIIIIllllIIIlIIIIlll) {
        this.dataManager.set(EntityPlayer.field_192032_bt, lllllllllllllIIIIllllIIIlIIIIlll);
    }
    
    private void addMountedMovementStat(final double lllllllllllllIIIIllllIIllIlIIlll, final double lllllllllllllIIIIllllIIllIlIIllI, final double lllllllllllllIIIIllllIIllIlIIIII) {
        if (this.isRiding()) {
            final int lllllllllllllIIIIllllIIllIlIIlII = Math.round(MathHelper.sqrt(lllllllllllllIIIIllllIIllIlIIlll * lllllllllllllIIIIllllIIllIlIIlll + lllllllllllllIIIIllllIIllIlIIllI * lllllllllllllIIIIllllIIllIlIIllI + lllllllllllllIIIIllllIIllIlIIIII * lllllllllllllIIIIllllIIllIlIIIII) * 100.0f);
            if (lllllllllllllIIIIllllIIllIlIIlII > 0) {
                if (this.getRidingEntity() instanceof EntityMinecart) {
                    this.addStat(StatList.MINECART_ONE_CM, lllllllllllllIIIIllllIIllIlIIlII);
                }
                else if (this.getRidingEntity() instanceof EntityBoat) {
                    this.addStat(StatList.BOAT_ONE_CM, lllllllllllllIIIIllllIIllIlIIlII);
                }
                else if (this.getRidingEntity() instanceof EntityPig) {
                    this.addStat(StatList.PIG_ONE_CM, lllllllllllllIIIIllllIIllIlIIlII);
                }
                else if (this.getRidingEntity() instanceof AbstractHorse) {
                    this.addStat(StatList.HORSE_ONE_CM, lllllllllllllIIIIllllIIllIlIIlII);
                }
            }
        }
    }
    
    @Override
    protected boolean canTriggerWalking() {
        return !this.capabilities.isFlying;
    }
    
    public NBTTagCompound func_192025_dl() {
        return this.dataManager.get(EntityPlayer.field_192033_bu);
    }
    
    public boolean func_191521_c(final ItemStack lllllllllllllIIIIllllIIlIIIIllIl) {
        this.playEquipSound(lllllllllllllIIIIllllIIlIIIIllIl);
        return this.inventory.addItemStackToInventory(lllllllllllllIIIIllllIIlIIIIllIl);
    }
    
    public float getLuck() {
        return (float)this.getEntityAttribute(SharedMonsterAttributes.LUCK).getAttributeValue();
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing = EntityPlayer.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
        if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing;
        }
        final short lllllllllllllIIIIllllIIIIlIlllll = (Object)new int[EnumFacing.values().length];
        try {
            lllllllllllllIIIIllllIIIIlIlllll[EnumFacing.DOWN.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIIIIllllIIIIlIlllll[EnumFacing.EAST.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIIIIllllIIIIlIlllll[EnumFacing.NORTH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllIIIIllllIIIIlIlllll[EnumFacing.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllllIIIIllllIIIIlIlllll[EnumFacing.UP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllllIIIIllllIIIIlIlllll[EnumFacing.WEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return EntityPlayer.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)lllllllllllllIIIIllllIIIIlIlllll;
    }
    
    public static UUID getUUID(final GameProfile lllllllllllllIIIIllllIIIllIIlIIl) {
        UUID lllllllllllllIIIIllllIIIllIIlIlI = lllllllllllllIIIIllllIIIllIIlIIl.getId();
        if (lllllllllllllIIIIllllIIIllIIlIlI == null) {
            lllllllllllllIIIIllllIIIllIIlIlI = getOfflineUUID(lllllllllllllIIIIllllIIIllIIlIIl.getName());
        }
        return lllllllllllllIIIIllllIIIllIIlIlI;
    }
    
    @Override
    public boolean getAlwaysRenderNameTagForRender() {
        return true;
    }
    
    public boolean canAttackPlayer(final EntityPlayer lllllllllllllIIIIllllIllIIlIIlll) {
        final Team lllllllllllllIIIIllllIllIIlIIllI = this.getTeam();
        final Team lllllllllllllIIIIllllIllIIlIIlIl = lllllllllllllIIIIllllIllIIlIIlll.getTeam();
        return lllllllllllllIIIIllllIllIIlIIllI == null || !lllllllllllllIIIIllllIllIIlIIllI.isSameTeam(lllllllllllllIIIIllllIllIIlIIlIl) || lllllllllllllIIIIllllIllIIlIIllI.getAllowFriendlyFire();
    }
    
    @Override
    public void onLivingUpdate() {
        if (this.flyToggleTimer > 0) {
            --this.flyToggleTimer;
        }
        if (this.world.getDifficulty() == EnumDifficulty.PEACEFUL && this.world.getGameRules().getBoolean("naturalRegeneration")) {
            if (this.getHealth() < this.getMaxHealth() && this.ticksExisted % 20 == 0) {
                this.heal(1.0f);
            }
            if (this.foodStats.needFood() && this.ticksExisted % 10 == 0) {
                this.foodStats.setFoodLevel(this.foodStats.getFoodLevel() + 1);
            }
        }
        this.inventory.decrementAnimations();
        this.prevCameraYaw = this.cameraYaw;
        super.onLivingUpdate();
        final IAttributeInstance lllllllllllllIIIIllllIlllllIIlII = this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED);
        if (!this.world.isRemote) {
            lllllllllllllIIIIllllIlllllIIlII.setBaseValue(this.capabilities.getWalkSpeed());
        }
        this.jumpMovementFactor = this.speedInAir;
        if (this.isSprinting()) {
            this.jumpMovementFactor += (float)(this.speedInAir * 0.3);
        }
        this.setAIMoveSpeed((float)lllllllllllllIIIIllllIlllllIIlII.getAttributeValue());
        float lllllllllllllIIIIllllIlllllIIIll = MathHelper.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
        float lllllllllllllIIIIllllIlllllIIIlI = (float)(Math.atan(-this.motionY * 0.20000000298023224) * 15.0);
        if (lllllllllllllIIIIllllIlllllIIIll > 0.1f) {
            lllllllllllllIIIIllllIlllllIIIll = 0.1f;
        }
        if (!this.onGround || this.getHealth() <= 0.0f) {
            lllllllllllllIIIIllllIlllllIIIll = 0.0f;
        }
        if (this.onGround || this.getHealth() <= 0.0f) {
            lllllllllllllIIIIllllIlllllIIIlI = 0.0f;
        }
        this.cameraYaw += (lllllllllllllIIIIllllIlllllIIIll - this.cameraYaw) * 0.4f;
        this.cameraPitch += (lllllllllllllIIIIllllIlllllIIIlI - this.cameraPitch) * 0.8f;
        if (this.getHealth() > 0.0f && !this.isSpectator()) {
            AxisAlignedBB lllllllllllllIIIIllllIlllllIIIII = null;
            if (this.isRiding() && !this.getRidingEntity().isDead) {
                final AxisAlignedBB lllllllllllllIIIIllllIlllllIIIIl = this.getEntityBoundingBox().union(this.getRidingEntity().getEntityBoundingBox()).expand(1.0, 0.0, 1.0);
            }
            else {
                lllllllllllllIIIIllllIlllllIIIII = this.getEntityBoundingBox().expand(1.0, 0.5, 1.0);
            }
            final List<Entity> lllllllllllllIIIIllllIllllIlllll = this.world.getEntitiesWithinAABBExcludingEntity(this, lllllllllllllIIIIllllIlllllIIIII);
            for (int lllllllllllllIIIIllllIllllIllllI = 0; lllllllllllllIIIIllllIllllIllllI < lllllllllllllIIIIllllIllllIlllll.size(); ++lllllllllllllIIIIllllIllllIllllI) {
                final Entity lllllllllllllIIIIllllIllllIlllIl = lllllllllllllIIIIllllIllllIlllll.get(lllllllllllllIIIIllllIllllIllllI);
                if (!lllllllllllllIIIIllllIllllIlllIl.isDead) {
                    this.collideWithPlayer(lllllllllllllIIIIllllIllllIlllIl);
                }
            }
        }
        this.func_192028_j(this.func_192023_dk());
        this.func_192028_j(this.func_192025_dl());
        if ((!this.world.isRemote && (this.fallDistance > 0.5f || this.isInWater() || this.isRiding())) || this.capabilities.isFlying) {
            this.func_192030_dh();
        }
    }
    
    @Override
    public ItemStack getItemStackFromSlot(final EntityEquipmentSlot lllllllllllllIIIIllllIIlIIIllllI) {
        if (lllllllllllllIIIIllllIIlIIIllllI == EntityEquipmentSlot.MAINHAND) {
            return this.inventory.getCurrentItem();
        }
        if (lllllllllllllIIIIllllIIlIIIllllI == EntityEquipmentSlot.OFFHAND) {
            return this.inventory.offHandInventory.get(0);
        }
        return (lllllllllllllIIIIllllIIlIIIllllI.getSlotType() == EntityEquipmentSlot.Type.ARMOR) ? this.inventory.armorInventory.get(lllllllllllllIIIIllllIIlIIIllllI.getIndex()) : ItemStack.field_190927_a;
    }
    
    public boolean canUseCommandBlock() {
        return this.capabilities.isCreativeMode && this.canCommandSenderUseCommand(2, "");
    }
    
    @Override
    public void handleStatusUpdate(final byte lllllllllllllIIIIlllllIIIIIIllII) {
        if (lllllllllllllIIIIlllllIIIIIIllII == 9) {
            this.onItemUseFinish();
        }
        else if (lllllllllllllIIIIlllllIIIIIIllII == 23) {
            this.hasReducedDebug = false;
        }
        else if (lllllllllllllIIIIlllllIIIIIIllII == 22) {
            this.hasReducedDebug = true;
        }
        else {
            super.handleStatusUpdate(lllllllllllllIIIIlllllIIIIIIllII);
        }
    }
    
    @Override
    protected void func_190629_c(final EntityLivingBase lllllllllllllIIIIllllIllIIlIllIl) {
        super.func_190629_c(lllllllllllllIIIIllllIllIIlIllIl);
        if (lllllllllllllIIIIllllIllIIlIllIl.getHeldItemMainhand().getItem() instanceof ItemAxe) {
            this.func_190777_m(true);
        }
    }
    
    public boolean shouldHeal() {
        return this.getHealth() > 0.0f && this.getHealth() < this.getMaxHealth();
    }
    
    public boolean canEat(final boolean lllllllllllllIIIIllllIIlIlIlIlll) {
        return (lllllllllllllIIIIllllIIlIlIlIlll || this.foodStats.needFood()) && !this.capabilities.disableDamage;
    }
    
    private void updateCape() {
        this.prevChasingPosX = this.chasingPosX;
        this.prevChasingPosY = this.chasingPosY;
        this.prevChasingPosZ = this.chasingPosZ;
        final double lllllllllllllIIIIlllllIIIlIIIIII = this.posX - this.chasingPosX;
        final double lllllllllllllIIIIlllllIIIIllllll = this.posY - this.chasingPosY;
        final double lllllllllllllIIIIlllllIIIIlllllI = this.posZ - this.chasingPosZ;
        final double lllllllllllllIIIIlllllIIIIllllIl = 10.0;
        if (lllllllllllllIIIIlllllIIIlIIIIII > 10.0) {
            this.chasingPosX = this.posX;
            this.prevChasingPosX = this.chasingPosX;
        }
        if (lllllllllllllIIIIlllllIIIIlllllI > 10.0) {
            this.chasingPosZ = this.posZ;
            this.prevChasingPosZ = this.chasingPosZ;
        }
        if (lllllllllllllIIIIlllllIIIIllllll > 10.0) {
            this.chasingPosY = this.posY;
            this.prevChasingPosY = this.chasingPosY;
        }
        if (lllllllllllllIIIIlllllIIIlIIIIII < -10.0) {
            this.chasingPosX = this.posX;
            this.prevChasingPosX = this.chasingPosX;
        }
        if (lllllllllllllIIIIlllllIIIIlllllI < -10.0) {
            this.chasingPosZ = this.posZ;
            this.prevChasingPosZ = this.chasingPosZ;
        }
        if (lllllllllllllIIIIlllllIIIIllllll < -10.0) {
            this.chasingPosY = this.posY;
            this.prevChasingPosY = this.chasingPosY;
        }
        this.chasingPosX += lllllllllllllIIIIlllllIIIlIIIIII * 0.25;
        this.chasingPosZ += lllllllllllllIIIIlllllIIIIlllllI * 0.25;
        this.chasingPosY += lllllllllllllIIIIlllllIIIIllllll * 0.25;
    }
    
    @Override
    protected boolean isPlayer() {
        return true;
    }
    
    public void addMovementStat(final double lllllllllllllIIIIllllIIllIllIIIl, final double lllllllllllllIIIIllllIIllIllIIII, final double lllllllllllllIIIIllllIIllIlllIII) {
        if (!this.isRiding()) {
            if (this.isInsideOfMaterial(Material.WATER)) {
                final int lllllllllllllIIIIllllIIllIllIlll = Math.round(MathHelper.sqrt(lllllllllllllIIIIllllIIllIllIIIl * lllllllllllllIIIIllllIIllIllIIIl + lllllllllllllIIIIllllIIllIllIIII * lllllllllllllIIIIllllIIllIllIIII + lllllllllllllIIIIllllIIllIlllIII * lllllllllllllIIIIllllIIllIlllIII) * 100.0f);
                if (lllllllllllllIIIIllllIIllIllIlll > 0) {
                    this.addStat(StatList.DIVE_ONE_CM, lllllllllllllIIIIllllIIllIllIlll);
                    this.addExhaustion(0.01f * lllllllllllllIIIIllllIIllIllIlll * 0.01f);
                }
            }
            else if (this.isInWater()) {
                final int lllllllllllllIIIIllllIIllIllIllI = Math.round(MathHelper.sqrt(lllllllllllllIIIIllllIIllIllIIIl * lllllllllllllIIIIllllIIllIllIIIl + lllllllllllllIIIIllllIIllIlllIII * lllllllllllllIIIIllllIIllIlllIII) * 100.0f);
                if (lllllllllllllIIIIllllIIllIllIllI > 0) {
                    this.addStat(StatList.SWIM_ONE_CM, lllllllllllllIIIIllllIIllIllIllI);
                    this.addExhaustion(0.01f * lllllllllllllIIIIllllIIllIllIllI * 0.01f);
                }
            }
            else if (this.isOnLadder()) {
                if (lllllllllllllIIIIllllIIllIllIIII > 0.0) {
                    this.addStat(StatList.CLIMB_ONE_CM, (int)Math.round(lllllllllllllIIIIllllIIllIllIIII * 100.0));
                }
            }
            else if (this.onGround) {
                final int lllllllllllllIIIIllllIIllIllIlIl = Math.round(MathHelper.sqrt(lllllllllllllIIIIllllIIllIllIIIl * lllllllllllllIIIIllllIIllIllIIIl + lllllllllllllIIIIllllIIllIlllIII * lllllllllllllIIIIllllIIllIlllIII) * 100.0f);
                if (lllllllllllllIIIIllllIIllIllIlIl > 0) {
                    if (this.isSprinting()) {
                        this.addStat(StatList.SPRINT_ONE_CM, lllllllllllllIIIIllllIIllIllIlIl);
                        this.addExhaustion(0.1f * lllllllllllllIIIIllllIIllIllIlIl * 0.01f);
                    }
                    else if (this.isSneaking()) {
                        this.addStat(StatList.CROUCH_ONE_CM, lllllllllllllIIIIllllIIllIllIlIl);
                        this.addExhaustion(0.0f * lllllllllllllIIIIllllIIllIllIlIl * 0.01f);
                    }
                    else {
                        this.addStat(StatList.WALK_ONE_CM, lllllllllllllIIIIllllIIllIllIlIl);
                        this.addExhaustion(0.0f * lllllllllllllIIIIllllIIllIllIlIl * 0.01f);
                    }
                }
            }
            else if (this.isElytraFlying()) {
                final int lllllllllllllIIIIllllIIllIllIlII = Math.round(MathHelper.sqrt(lllllllllllllIIIIllllIIllIllIIIl * lllllllllllllIIIIllllIIllIllIIIl + lllllllllllllIIIIllllIIllIllIIII * lllllllllllllIIIIllllIIllIllIIII + lllllllllllllIIIIllllIIllIlllIII * lllllllllllllIIIIllllIIllIlllIII) * 100.0f);
                this.addStat(StatList.AVIATE_ONE_CM, lllllllllllllIIIIllllIIllIllIlII);
            }
            else {
                final int lllllllllllllIIIIllllIIllIllIIll = Math.round(MathHelper.sqrt(lllllllllllllIIIIllllIIllIllIIIl * lllllllllllllIIIIllllIIllIllIIIl + lllllllllllllIIIIllllIIllIlllIII * lllllllllllllIIIIllllIIllIlllIII) * 100.0f);
                if (lllllllllllllIIIIllllIIllIllIIll > 25) {
                    this.addStat(StatList.FLY_ONE_CM, lllllllllllllIIIIllllIIllIllIIll);
                }
            }
        }
    }
    
    public void setSpawnPoint(final BlockPos lllllllllllllIIIIllllIIllllllIlI, final boolean lllllllllllllIIIIllllIIllllllIIl) {
        if (lllllllllllllIIIIllllIIllllllIlI != null) {
            this.spawnChunk = lllllllllllllIIIIllllIIllllllIlI;
            this.spawnForced = lllllllllllllIIIIllllIIllllllIIl;
        }
        else {
            this.spawnChunk = null;
            this.spawnForced = false;
        }
    }
    
    public static void registerFixesPlayer(final DataFixer lllllllllllllIIIIllllIllIlIlIlIl) {
        lllllllllllllIIIIllllIllIlIlIlIl.registerWalker(FixTypes.PLAYER, new IDataWalker() {
            @Override
            public NBTTagCompound process(final IDataFixer lllllllllllllIIIIlllllIllIllIIll, final NBTTagCompound lllllllllllllIIIIlllllIllIllIIlI, final int lllllllllllllIIIIlllllIllIllIlII) {
                DataFixesManager.processInventory(lllllllllllllIIIIlllllIllIllIIll, lllllllllllllIIIIlllllIllIllIIlI, lllllllllllllIIIIlllllIllIllIlII, "Inventory");
                DataFixesManager.processInventory(lllllllllllllIIIIlllllIllIllIIll, lllllllllllllIIIIlllllIllIllIIlI, lllllllllllllIIIIlllllIllIllIlII, "EnderItems");
                if (lllllllllllllIIIIlllllIllIllIIlI.hasKey("ShoulderEntityLeft", 10)) {
                    lllllllllllllIIIIlllllIllIllIIlI.setTag("ShoulderEntityLeft", lllllllllllllIIIIlllllIllIllIIll.process(FixTypes.ENTITY, lllllllllllllIIIIlllllIllIllIIlI.getCompoundTag("ShoulderEntityLeft"), lllllllllllllIIIIlllllIllIllIlII));
                }
                if (lllllllllllllIIIIlllllIllIllIIlI.hasKey("ShoulderEntityRight", 10)) {
                    lllllllllllllIIIIlllllIllIllIIlI.setTag("ShoulderEntityRight", lllllllllllllIIIIlllllIllIllIIll.process(FixTypes.ENTITY, lllllllllllllIIIIlllllIllIllIIlI.getCompoundTag("ShoulderEntityRight"), lllllllllllllIIIIlllllIllIllIlII));
                }
                return lllllllllllllIIIIlllllIllIllIIlI;
            }
        });
    }
    
    public void setScore(final int lllllllllllllIIIIllllIlllIllllIl) {
        this.dataManager.set(EntityPlayer.PLAYER_SCORE, lllllllllllllIIIIllllIlllIllllIl);
    }
    
    public CooldownTracker getCooldownTracker() {
        return this.cooldownTracker;
    }
    
    private void func_192026_k(@Nullable final NBTTagCompound lllllllllllllIIIIllllIIIlllllIIl) {
        if (!this.world.isRemote && !lllllllllllllIIIIllllIIIlllllIIl.hasNoTags()) {
            final Entity lllllllllllllIIIIllllIIIlllllIII = EntityList.createEntityFromNBT(lllllllllllllIIIIllllIIIlllllIIl, this.world);
            if (lllllllllllllIIIIllllIIIlllllIII instanceof EntityTameable) {
                ((EntityTameable)lllllllllllllIIIIllllIIIlllllIII).setOwnerId(this.entityUniqueID);
            }
            lllllllllllllIIIIllllIIIlllllIII.setPosition(this.posX, this.posY + 0.699999988079071, this.posZ);
            this.world.spawnEntityInWorld(lllllllllllllIIIIllllIIIlllllIII);
        }
    }
    
    public void openEditSign(final TileEntitySign lllllllllllllIIIIllllIlIllllIIll) {
    }
    
    public boolean canPlayerEdit(final BlockPos lllllllllllllIIIIllllIIlIlIIIlll, final EnumFacing lllllllllllllIIIIllllIIlIlIIIllI, final ItemStack lllllllllllllIIIIllllIIlIlIIIlIl) {
        if (this.capabilities.allowEdit) {
            return true;
        }
        if (lllllllllllllIIIIllllIIlIlIIIlIl.func_190926_b()) {
            return false;
        }
        final BlockPos lllllllllllllIIIIllllIIlIlIIIlII = lllllllllllllIIIIllllIIlIlIIIlll.offset(lllllllllllllIIIIllllIIlIlIIIllI.getOpposite());
        final Block lllllllllllllIIIIllllIIlIlIIIIll = this.world.getBlockState(lllllllllllllIIIIllllIIlIlIIIlII).getBlock();
        return lllllllllllllIIIIllllIIlIlIIIlIl.canPlaceOn(lllllllllllllIIIIllllIIlIlIIIIll) || lllllllllllllIIIIllllIIlIlIIIlIl.canEditBlocks();
    }
    
    public int getScore() {
        return this.dataManager.get(EntityPlayer.PLAYER_SCORE);
    }
    
    @Override
    public float getAIMoveSpeed() {
        return (float)this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue();
    }
    
    public String setName(final String lllllllllllllIIIIllllIIlIIlIIlIl) {
        return this.gameProfile.getName().replace(this.gameProfile.getName(), lllllllllllllIIIIllllIIlIIlIIlIl);
    }
    
    public EntityPlayer(final World lllllllllllllIIIIlllllIIIlIllllI, final GameProfile lllllllllllllIIIIlllllIIIlIlllIl) {
        super(lllllllllllllIIIIlllllIIIlIllllI);
        this.inventory = new InventoryPlayer(this);
        this.theInventoryEnderChest = new InventoryEnderChest();
        this.foodStats = new FoodStats();
        this.capabilities = new PlayerCapabilities();
        this.speedInAir = 0.02f;
        this.itemStackMainHand = ItemStack.field_190927_a;
        this.cooldownTracker = this.createCooldownTracker();
        this.setUniqueId(getUUID(lllllllllllllIIIIlllllIIIlIlllIl));
        this.gameProfile = lllllllllllllIIIIlllllIIIlIlllIl;
        this.inventoryContainer = new ContainerPlayer(this.inventory, !lllllllllllllIIIIlllllIIIlIllllI.isRemote, this);
        this.openContainer = this.inventoryContainer;
        final BlockPos lllllllllllllIIIIlllllIIIllIIIII = lllllllllllllIIIIlllllIIIlIllllI.getSpawnPoint();
        this.setLocationAndAngles(lllllllllllllIIIIlllllIIIllIIIII.getX() + 0.5, lllllllllllllIIIIlllllIIIllIIIII.getY() + 1, lllllllllllllIIIIlllllIIIllIIIII.getZ() + 0.5, 0.0f, 0.0f);
        this.unused180 = 180.0f;
    }
    
    public void addStat(final StatBase lllllllllllllIIIIllllIIlllllIIII) {
        this.addStat(lllllllllllllIIIIllllIIlllllIIII, 1);
    }
    
    private void func_192028_j(@Nullable final NBTTagCompound lllllllllllllIIIIllllIllllIlIIII) {
        if ((lllllllllllllIIIIllllIllllIlIIII != null && !lllllllllllllIIIIllllIllllIlIIII.hasKey("Silent")) || !lllllllllllllIIIIllllIllllIlIIII.getBoolean("Silent")) {
            final String lllllllllllllIIIIllllIllllIIllll = lllllllllllllIIIIllllIllllIlIIII.getString("id");
            if (lllllllllllllIIIIllllIllllIIllll.equals(EntityList.func_191306_a(EntityParrot.class).toString())) {
                EntityParrot.func_192005_a(this.world, this);
            }
        }
    }
    
    public void displayGui(final IInteractionObject lllllllllllllIIIIllllIlIlllIIlII) {
    }
    
    @Override
    protected void damageArmor(final float lllllllllllllIIIIllllIllIIIlllIl) {
        this.inventory.damageArmor(lllllllllllllIIIIllllIllIIIlllIl);
    }
    
    @Override
    public float getAbsorptionAmount() {
        return this.getDataManager().get(EntityPlayer.ABSORPTION);
    }
    
    @Override
    protected SoundEvent getSplashSound() {
        return SoundEvents.ENTITY_PLAYER_SPLASH;
    }
    
    private boolean func_190774_a(final BlockPos lllllllllllllIIIIllllIlIIlIIIllI, final EnumFacing lllllllllllllIIIIllllIlIIlIIIlIl) {
        if (Math.abs(this.posX - lllllllllllllIIIIllllIlIIlIIIllI.getX()) <= 3.0 && Math.abs(this.posY - lllllllllllllIIIIllllIlIIlIIIllI.getY()) <= 2.0 && Math.abs(this.posZ - lllllllllllllIIIIllllIlIIlIIIllI.getZ()) <= 3.0) {
            return true;
        }
        final BlockPos lllllllllllllIIIIllllIlIIlIIlIII = lllllllllllllIIIIllllIlIIlIIIllI.offset(lllllllllllllIIIIllllIlIIlIIIlIl.getOpposite());
        return Math.abs(this.posX - lllllllllllllIIIIllllIlIIlIIlIII.getX()) <= 3.0 && Math.abs(this.posY - lllllllllllllIIIIllllIlIIlIIlIII.getY()) <= 2.0 && Math.abs(this.posZ - lllllllllllllIIIIllllIlIIlIIlIII.getZ()) <= 3.0;
    }
    
    public void addStat(final StatBase lllllllllllllIIIIllllIIllllIlllI, final int lllllllllllllIIIIllllIIllllIllIl) {
    }
    
    public void spawnSweepParticles() {
        final double lllllllllllllIIIIllllIlIIlllIlIl = -MathHelper.sin(this.rotationYaw * 0.017453292f);
        final double lllllllllllllIIIIllllIlIIlllIlII = MathHelper.cos(this.rotationYaw * 0.017453292f);
        if (this.world instanceof WorldServer) {
            ((WorldServer)this.world).spawnParticle(EnumParticleTypes.SWEEP_ATTACK, this.posX + lllllllllllllIIIIllllIlIIlllIlIl, this.posY + this.height * 0.5, this.posZ + lllllllllllllIIIIllllIlIIlllIlII, 0, lllllllllllllIIIIllllIlIIlllIlIl, 0.0, lllllllllllllIIIIllllIlIIlllIlII, 0.0, new int[0]);
        }
    }
    
    @Override
    protected SoundEvent getHurtSound(final DamageSource lllllllllllllIIIIllllIlllIlIIIIl) {
        if (lllllllllllllIIIIllllIlllIlIIIIl == DamageSource.onFire) {
            return SoundEvents.field_193806_fH;
        }
        return (lllllllllllllIIIIllllIlllIlIIIIl == DamageSource.drown) ? SoundEvents.field_193805_fG : SoundEvents.ENTITY_PLAYER_HURT;
    }
    
    @Override
    public Iterable<ItemStack> getHeldEquipment() {
        return (Iterable<ItemStack>)Lists.newArrayList((Object[])new ItemStack[] { this.getHeldItemMainhand(), this.getHeldItemOffhand() });
    }
    
    @Override
    protected int func_190531_bD() {
        return 20;
    }
    
    @Override
    protected SoundEvent getFallSound(final int lllllllllllllIIIIllllIIllIIlIIII) {
        return (lllllllllllllIIIIllllIIllIIlIIII > 4) ? SoundEvents.ENTITY_PLAYER_BIG_FALL : SoundEvents.ENTITY_PLAYER_SMALL_FALL;
    }
    
    public FoodStats getFoodStats() {
        return this.foodStats;
    }
    
    @Override
    public void setItemStackToSlot(final EntityEquipmentSlot lllllllllllllIIIIllllIIlIIIlIlll, final ItemStack lllllllllllllIIIIllllIIlIIIlIllI) {
        if (lllllllllllllIIIIllllIIlIIIlIlll == EntityEquipmentSlot.MAINHAND) {
            this.playEquipSound(lllllllllllllIIIIllllIIlIIIlIllI);
            this.inventory.mainInventory.set(this.inventory.currentItem, lllllllllllllIIIIllllIIlIIIlIllI);
        }
        else if (lllllllllllllIIIIllllIIlIIIlIlll == EntityEquipmentSlot.OFFHAND) {
            this.playEquipSound(lllllllllllllIIIIllllIIlIIIlIllI);
            this.inventory.offHandInventory.set(0, lllllllllllllIIIIllllIIlIIIlIllI);
        }
        else if (lllllllllllllIIIIllllIIlIIIlIlll.getSlotType() == EntityEquipmentSlot.Type.ARMOR) {
            this.playEquipSound(lllllllllllllIIIIllllIIlIIIlIllI);
            this.inventory.armorInventory.set(lllllllllllllIIIIllllIIlIIIlIlll.getIndex(), lllllllllllllIIIIllllIIlIIIlIllI);
        }
    }
    
    protected void func_192030_dh() {
        this.func_192026_k(this.func_192023_dk());
        this.func_192029_h(new NBTTagCompound());
        this.func_192026_k(this.func_192025_dl());
        this.func_192031_i(new NBTTagCompound());
    }
    
    public void displayGuiCommandBlock(final TileEntityCommandBlock lllllllllllllIIIIllllIlIlllIllll) {
    }
    
    public void displayGUIChest(final IInventory lllllllllllllIIIIllllIlIlllIlIIl) {
    }
    
    public void func_192021_a(final List<IRecipe> lllllllllllllIIIIllllIIllllIlIIl) {
    }
    
    @Nullable
    public EntityItem dropItem(final ItemStack lllllllllllllIIIIllllIlllIIlIIlI, final boolean lllllllllllllIIIIllllIlllIIlIlII) {
        return this.dropItem(lllllllllllllIIIIllllIlllIIlIIlI, false, lllllllllllllIIIIllllIlllIIlIlII);
    }
    
    public boolean isSpawnForced() {
        return this.spawnForced;
    }
    
    @Nullable
    public EntityItem dropItem(final boolean lllllllllllllIIIIllllIlllIIlllII) {
        return this.dropItem(this.inventory.decrStackSize(this.inventory.currentItem, (lllllllllllllIIIIllllIlllIIlllII && !this.inventory.getCurrentItem().func_190926_b()) ? this.inventory.getCurrentItem().func_190916_E() : 1), false, true);
    }
    
    public void displayGuiEditCommandCart(final CommandBlockBaseLogic lllllllllllllIIIIllllIlIllllIIIl) {
    }
    
    @Override
    public void setAbsorptionAmount(float lllllllllllllIIIIllllIIIllIlIIIl) {
        if (lllllllllllllIIIIllllIIIllIlIIIl < 0.0f) {
            lllllllllllllIIIIllllIIIllIlIIIl = 0.0f;
        }
        this.getDataManager().set(EntityPlayer.ABSORPTION, lllllllllllllIIIIllllIIIllIlIIIl);
    }
    
    public EnumActionResult func_190775_a(final Entity lllllllllllllIIIIllllIlIllIllIlI, final EnumHand lllllllllllllIIIIllllIlIllIlIlII) {
        if (this.isSpectator()) {
            if (lllllllllllllIIIIllllIlIllIllIlI instanceof IInventory) {
                this.displayGUIChest((IInventory)lllllllllllllIIIIllllIlIllIllIlI);
            }
            return EnumActionResult.PASS;
        }
        ItemStack lllllllllllllIIIIllllIlIllIllIII = this.getHeldItem(lllllllllllllIIIIllllIlIllIlIlII);
        final ItemStack lllllllllllllIIIIllllIlIllIlIlll = lllllllllllllIIIIllllIlIllIllIII.func_190926_b() ? ItemStack.field_190927_a : lllllllllllllIIIIllllIlIllIllIII.copy();
        if (lllllllllllllIIIIllllIlIllIllIlI.processInitialInteract(this, lllllllllllllIIIIllllIlIllIlIlII)) {
            if (this.capabilities.isCreativeMode && lllllllllllllIIIIllllIlIllIllIII == this.getHeldItem(lllllllllllllIIIIllllIlIllIlIlII) && lllllllllllllIIIIllllIlIllIllIII.func_190916_E() < lllllllllllllIIIIllllIlIllIlIlll.func_190916_E()) {
                lllllllllllllIIIIllllIlIllIllIII.func_190920_e(lllllllllllllIIIIllllIlIllIlIlll.func_190916_E());
            }
            return EnumActionResult.SUCCESS;
        }
        if (!lllllllllllllIIIIllllIlIllIllIII.func_190926_b() && lllllllllllllIIIIllllIlIllIllIlI instanceof EntityLivingBase) {
            if (this.capabilities.isCreativeMode) {
                lllllllllllllIIIIllllIlIllIllIII = lllllllllllllIIIIllllIlIllIlIlll;
            }
            if (lllllllllllllIIIIllllIlIllIllIII.interactWithEntity(this, (EntityLivingBase)lllllllllllllIIIIllllIlIllIllIlI, lllllllllllllIIIIllllIlIllIlIlII)) {
                if (lllllllllllllIIIIllllIlIllIllIII.func_190926_b() && !this.capabilities.isCreativeMode) {
                    this.setHeldItem(lllllllllllllIIIIllllIlIllIlIlII, ItemStack.field_190927_a);
                }
                return EnumActionResult.SUCCESS;
            }
        }
        return EnumActionResult.PASS;
    }
    
    public static UUID getOfflineUUID(final String lllllllllllllIIIIllllIIIllIIIllI) {
        return UUID.nameUUIDFromBytes(String.valueOf(new StringBuilder("OfflinePlayer:").append(lllllllllllllIIIIllllIIIllIIIllI)).getBytes(StandardCharsets.UTF_8));
    }
    
    public boolean func_192027_g(final NBTTagCompound lllllllllllllIIIIllllIIlIIIIIIIl) {
        if (this.isRiding() || !this.onGround || this.isInWater()) {
            return false;
        }
        if (this.func_192023_dk().hasNoTags()) {
            this.func_192029_h(lllllllllllllIIIIllllIIlIIIIIIIl);
            return true;
        }
        if (this.func_192025_dl().hasNoTags()) {
            this.func_192031_i(lllllllllllllIIIIllllIIlIIIIIIIl);
            return true;
        }
        return false;
    }
    
    @Override
    public float getEyeHeight() {
        float lllllllllllllIIIIllllIIIllIllIIl = 1.62f;
        if (this.isPlayerSleeping()) {
            lllllllllllllIIIIllllIIIllIllIIl = 0.2f;
        }
        else if (!this.isSneaking() && this.height != 1.65f) {
            if (this.isElytraFlying() || this.height == 0.6f) {
                lllllllllllllIIIIllllIIIllIllIIl = 0.4f;
            }
        }
        else {
            lllllllllllllIIIIllllIIIllIllIIl -= 0.08f;
        }
        return lllllllllllllIIIIllllIIIllIllIIl;
    }
    
    @Override
    public EnumHandSide getPrimaryHand() {
        return (this.dataManager.get(EntityPlayer.MAIN_HAND) == 0) ? EnumHandSide.LEFT : EnumHandSide.RIGHT;
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound lllllllllllllIIIIllllIllIIllllII) {
        super.writeEntityToNBT(lllllllllllllIIIIllllIllIIllllII);
        lllllllllllllIIIIllllIllIIllllII.setInteger("DataVersion", 1343);
        lllllllllllllIIIIllllIllIIllllII.setTag("Inventory", this.inventory.writeToNBT(new NBTTagList()));
        lllllllllllllIIIIllllIllIIllllII.setInteger("SelectedItemSlot", this.inventory.currentItem);
        lllllllllllllIIIIllllIllIIllllII.setBoolean("Sleeping", this.sleeping);
        lllllllllllllIIIIllllIllIIllllII.setShort("SleepTimer", (short)this.sleepTimer);
        lllllllllllllIIIIllllIllIIllllII.setFloat("XpP", this.experience);
        lllllllllllllIIIIllllIllIIllllII.setInteger("XpLevel", this.experienceLevel);
        lllllllllllllIIIIllllIllIIllllII.setInteger("XpTotal", this.experienceTotal);
        lllllllllllllIIIIllllIllIIllllII.setInteger("XpSeed", this.xpSeed);
        lllllllllllllIIIIllllIllIIllllII.setInteger("Score", this.getScore());
        if (this.spawnChunk != null) {
            lllllllllllllIIIIllllIllIIllllII.setInteger("SpawnX", this.spawnChunk.getX());
            lllllllllllllIIIIllllIllIIllllII.setInteger("SpawnY", this.spawnChunk.getY());
            lllllllllllllIIIIllllIllIIllllII.setInteger("SpawnZ", this.spawnChunk.getZ());
            lllllllllllllIIIIllllIllIIllllII.setBoolean("SpawnForced", this.spawnForced);
        }
        this.foodStats.writeNBT(lllllllllllllIIIIllllIllIIllllII);
        this.capabilities.writeCapabilitiesToNBT(lllllllllllllIIIIllllIllIIllllII);
        lllllllllllllIIIIllllIllIIllllII.setTag("EnderItems", this.theInventoryEnderChest.saveInventoryToNBT());
        if (!this.func_192023_dk().hasNoTags()) {
            lllllllllllllIIIIllllIllIIllllII.setTag("ShoulderEntityLeft", this.func_192023_dk());
        }
        if (!this.func_192025_dl().hasNoTags()) {
            lllllllllllllIIIIllllIllIIllllII.setTag("ShoulderEntityRight", this.func_192025_dl());
        }
    }
    
    @Override
    public String getName() {
        return this.gameProfile.getName();
    }
    
    @Override
    public void onUpdate() {
        this.noClip = this.isSpectator();
        if (this.isSpectator()) {
            this.onGround = false;
        }
        if (this.xpCooldown > 0) {
            --this.xpCooldown;
        }
        if (this.isPlayerSleeping()) {
            ++this.sleepTimer;
            if (this.sleepTimer > 100) {
                this.sleepTimer = 100;
            }
            if (!this.world.isRemote) {
                if (!this.isInBed()) {
                    this.wakeUpPlayer(true, true, false);
                }
                else if (this.world.isDaytime()) {
                    this.wakeUpPlayer(false, true, true);
                }
            }
        }
        else if (this.sleepTimer > 0) {
            ++this.sleepTimer;
            if (this.sleepTimer >= 110) {
                this.sleepTimer = 0;
            }
        }
        super.onUpdate();
        if (!this.world.isRemote && this.openContainer != null && !this.openContainer.canInteractWith(this)) {
            this.closeScreen();
            this.openContainer = this.inventoryContainer;
        }
        if (this.isBurning() && this.capabilities.disableDamage) {
            this.extinguish();
        }
        this.updateCape();
        if (!this.world.isRemote) {
            this.foodStats.onUpdate(this);
            this.addStat(StatList.PLAY_ONE_MINUTE);
            if (this.isEntityAlive()) {
                this.addStat(StatList.TIME_SINCE_DEATH);
            }
            if (this.isSneaking()) {
                this.addStat(StatList.SNEAK_TIME);
            }
        }
        final int lllllllllllllIIIIlllllIIIlIIllll = 29999999;
        final double lllllllllllllIIIIlllllIIIlIIlllI = MathHelper.clamp(this.posX, -2.9999999E7, 2.9999999E7);
        final double lllllllllllllIIIIlllllIIIlIIllIl = MathHelper.clamp(this.posZ, -2.9999999E7, 2.9999999E7);
        if (lllllllllllllIIIIlllllIIIlIIlllI != this.posX || lllllllllllllIIIIlllllIIIlIIllIl != this.posZ) {
            this.setPosition(lllllllllllllIIIIlllllIIIlIIlllI, this.posY, lllllllllllllIIIIlllllIIIlIIllIl);
        }
        ++this.ticksSinceLastSwing;
        final ItemStack lllllllllllllIIIIlllllIIIlIIllII = this.getHeldItemMainhand();
        if (!ItemStack.areItemStacksEqual(this.itemStackMainHand, lllllllllllllIIIIlllllIIIlIIllII)) {
            if (!ItemStack.areItemsEqualIgnoreDurability(this.itemStackMainHand, lllllllllllllIIIIlllllIIIlIIllII)) {
                this.resetCooldown();
            }
            this.itemStackMainHand = (lllllllllllllIIIIlllllIIIlIIllII.func_190926_b() ? ItemStack.field_190927_a : lllllllllllllIIIIlllllIIIlIIllII.copy());
        }
        this.cooldownTracker.tick();
        this.updateSize();
    }
    
    public boolean isAllowEdit() {
        return this.capabilities.allowEdit;
    }
    
    protected void func_190776_cN() {
        for (int lllllllllllllIIIIllllIlllIlIlIIl = 0; lllllllllllllIIIIllllIlllIlIlIIl < this.inventory.getSizeInventory(); ++lllllllllllllIIIIllllIlllIlIlIIl) {
            final ItemStack lllllllllllllIIIIllllIlllIlIlIII = this.inventory.getStackInSlot(lllllllllllllIIIIllllIlllIlIlIIl);
            if (!lllllllllllllIIIIllllIlllIlIlIII.func_190926_b() && EnchantmentHelper.func_190939_c(lllllllllllllIIIIllllIlllIlIlIII)) {
                this.inventory.removeStackFromSlot(lllllllllllllIIIIllllIlllIlIlIIl);
            }
        }
    }
    
    public void openBook(final ItemStack lllllllllllllIIIIllllIlIlllIIIlI, final EnumHand lllllllllllllIIIIllllIlIlllIIIIl) {
    }
    
    @Override
    public int getPortalCooldown() {
        return 10;
    }
    
    public float getArmorVisibility() {
        int lllllllllllllIIIIllllIllIIIIlIIl = 0;
        for (final ItemStack lllllllllllllIIIIllllIllIIIIlIII : this.inventory.armorInventory) {
            if (!lllllllllllllIIIIllllIllIIIIlIII.func_190926_b()) {
                ++lllllllllllllIIIIllllIllIIIIlIIl;
            }
        }
        return lllllllllllllIIIIllllIllIIIIlIIl / (float)this.inventory.armorInventory.size();
    }
    
    @Override
    public void fall(final float lllllllllllllIIIIllllIIllIIlIlll, final float lllllllllllllIIIIllllIIllIIlIllI) {
        if (!this.capabilities.allowFlying) {
            if (lllllllllllllIIIIllllIIllIIlIlll >= 2.0f) {
                this.addStat(StatList.FALL_ONE_CM, (int)Math.round(lllllllllllllIIIIllllIIllIIlIlll * 100.0));
            }
            super.fall(lllllllllllllIIIIllllIIllIIlIlll, lllllllllllllIIIIllllIIllIIlIllI);
        }
    }
    
    public void setPrimaryHand(final EnumHandSide lllllllllllllIIIIllllIIIlIIlIIII) {
        this.dataManager.set(EntityPlayer.MAIN_HAND, (byte)((lllllllllllllIIIIllllIIIlIIlIIII != EnumHandSide.LEFT) ? 1 : 0));
    }
    
    public void func_190777_m(final boolean lllllllllllllIIIIllllIlIlIIIIIlI) {
        float lllllllllllllIIIIllllIlIlIIIIIIl = 0.25f + EnchantmentHelper.getEfficiencyModifier(this) * 0.05f;
        if (lllllllllllllIIIIllllIlIlIIIIIlI) {
            lllllllllllllIIIIllllIlIlIIIIIIl += 0.75f;
        }
        if (this.rand.nextFloat() < lllllllllllllIIIIllllIlIlIIIIIIl) {
            this.getCooldownTracker().setCooldown(Items.SHIELD, 100);
            this.resetActiveHand();
            this.world.setEntityState(this, (byte)30);
        }
    }
    
    @Override
    public void dismountRidingEntity() {
        super.dismountRidingEntity();
        this.rideCooldown = 0;
    }
    
    public abstract boolean isSpectator();
    
    public boolean canHarvestBlock(final IBlockState lllllllllllllIIIIllllIllIlIlIlll) {
        return this.inventory.canHarvestBlock(lllllllllllllIIIIllllIllIlIlIlll);
    }
    
    protected void closeScreen() {
        this.openContainer = this.inventoryContainer;
    }
    
    @Override
    public void setDead() {
        super.setDead();
        this.inventoryContainer.onContainerClosed(this);
        if (this.openContainer != null) {
            this.openContainer.onContainerClosed(this);
        }
    }
    
    public void respawnPlayer() {
    }
    
    public void wakeUpPlayer(final boolean lllllllllllllIIIIllllIlIIIllIIII, final boolean lllllllllllllIIIIllllIlIIIllIlIl, final boolean lllllllllllllIIIIllllIlIIIllIlII) {
        this.setSize(0.6f, 1.8f);
        final IBlockState lllllllllllllIIIIllllIlIIIllIIll = this.world.getBlockState(this.bedLocation);
        if (this.bedLocation != null && lllllllllllllIIIIllllIlIIIllIIll.getBlock() == Blocks.BED) {
            this.world.setBlockState(this.bedLocation, lllllllllllllIIIIllllIlIIIllIIll.withProperty((IProperty<Comparable>)BlockBed.OCCUPIED, false), 4);
            BlockPos lllllllllllllIIIIllllIlIIIllIIlI = BlockBed.getSafeExitLocation(this.world, this.bedLocation, 0);
            if (lllllllllllllIIIIllllIlIIIllIIlI == null) {
                lllllllllllllIIIIllllIlIIIllIIlI = this.bedLocation.up();
            }
            this.setPosition(lllllllllllllIIIIllllIlIIIllIIlI.getX() + 0.5f, lllllllllllllIIIIllllIlIIIllIIlI.getY() + 0.1f, lllllllllllllIIIIllllIlIIIllIIlI.getZ() + 0.5f);
        }
        this.sleeping = false;
        if (!this.world.isRemote && lllllllllllllIIIIllllIlIIIllIlIl) {
            this.world.updateAllPlayersSleepingFlag();
        }
        this.sleepTimer = (lllllllllllllIIIIllllIlIIIllIIII ? 0 : 100);
        if (lllllllllllllIIIIllllIlIIIllIlII) {
            this.setSpawnPoint(this.bedLocation, false);
        }
    }
    
    private void setRenderOffsetForSleep(final EnumFacing lllllllllllllIIIIllllIlIIIlllllI) {
        this.renderOffsetX = -1.8f * lllllllllllllIIIIllllIlIIIlllllI.getFrontOffsetX();
        this.renderOffsetZ = -1.8f * lllllllllllllIIIIllllIlIIIlllllI.getFrontOffsetZ();
    }
    
    public void setGameType(final GameType lllllllllllllIIIIllllIIlIIlIlllI) {
    }
    
    @Override
    public SoundCategory getSoundCategory() {
        return SoundCategory.PLAYERS;
    }
    
    @Override
    public void setInWeb() {
        if (!this.capabilities.isFlying) {
            super.setInWeb();
        }
    }
    
    @Override
    public ITextComponent getDisplayName() {
        final ITextComponent lllllllllllllIIIIllllIIIllIlllll = new TextComponentString(ScorePlayerTeam.formatPlayerName(this.getTeam(), this.getName()));
        lllllllllllllIIIIllllIIIllIlllll.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, String.valueOf(new StringBuilder("/msg ").append(this.getName()).append(" "))));
        lllllllllllllIIIIllllIIIllIlllll.getStyle().setHoverEvent(this.getHoverEvent());
        lllllllllllllIIIIllllIIIllIlllll.getStyle().setInsertion(this.getName());
        return lllllllllllllIIIIllllIIIllIlllll;
    }
    
    protected ItemStack dropItemAndGetStack(final EntityItem lllllllllllllIIIIllllIllIlllIIII) {
        this.world.spawnEntityInWorld(lllllllllllllIIIIllllIllIlllIIII);
        return lllllllllllllIIIIllllIllIlllIIII.getEntityItem();
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource lllllllllllllIIIIllllIllIIllIlII, float lllllllllllllIIIIllllIllIIllIIll) {
        if (this.isEntityInvulnerable(lllllllllllllIIIIllllIllIIllIlII)) {
            return false;
        }
        if (this.capabilities.disableDamage && !lllllllllllllIIIIllllIllIIllIlII.canHarmInCreative()) {
            return false;
        }
        this.entityAge = 0;
        if (this.getHealth() <= 0.0f) {
            return false;
        }
        if (this.isPlayerSleeping() && !this.world.isRemote) {
            this.wakeUpPlayer(true, true, false);
        }
        this.func_192030_dh();
        if (lllllllllllllIIIIllllIllIIllIlII.isDifficultyScaled()) {
            if (this.world.getDifficulty() == EnumDifficulty.PEACEFUL) {
                lllllllllllllIIIIllllIllIIllIIll = 0.0f;
            }
            if (this.world.getDifficulty() == EnumDifficulty.EASY) {
                lllllllllllllIIIIllllIllIIllIIll = Math.min(lllllllllllllIIIIllllIllIIllIIll / 2.0f + 1.0f, lllllllllllllIIIIllllIllIIllIIll);
            }
            if (this.world.getDifficulty() == EnumDifficulty.HARD) {
                lllllllllllllIIIIllllIllIIllIIll = lllllllllllllIIIIllllIllIIllIIll * 3.0f / 2.0f;
            }
        }
        return lllllllllllllIIIIllllIllIIllIIll != 0.0f && super.attackEntityFrom(lllllllllllllIIIIllllIllIIllIlII, lllllllllllllIIIIllllIllIIllIIll);
    }
    
    @Override
    public boolean isPushedByWater() {
        return (!Main.moduleManager.getModule(NoPush.class).isToggled() || !NoPush.water.getValBoolean()) && !this.capabilities.isFlying;
    }
    
    @Override
    protected void damageShield(final float lllllllllllllIIIIllllIllIIIlIlIl) {
        if (lllllllllllllIIIIllllIllIIIlIlIl >= 3.0f && this.activeItemStack.getItem() == Items.SHIELD) {
            final int lllllllllllllIIIIllllIllIIIlIlII = 1 + MathHelper.floor(lllllllllllllIIIIllllIllIIIlIlIl);
            this.activeItemStack.damageItem(lllllllllllllIIIIllllIllIIIlIlII, this);
            if (this.activeItemStack.func_190926_b()) {
                final EnumHand lllllllllllllIIIIllllIllIIIlIIll = this.getActiveHand();
                if (lllllllllllllIIIIllllIllIIIlIIll == EnumHand.MAIN_HAND) {
                    this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, ItemStack.field_190927_a);
                }
                else {
                    this.setItemStackToSlot(EntityEquipmentSlot.OFFHAND, ItemStack.field_190927_a);
                }
                this.activeItemStack = ItemStack.field_190927_a;
                this.playSound(SoundEvents.ITEM_SHIELD_BREAK, 0.8f, 0.8f + this.world.rand.nextFloat() * 0.4f);
            }
        }
    }
    
    public void addExperience(int lllllllllllllIIIIllllIIlIllllIll) {
        this.addScore(lllllllllllllIIIIllllIIlIllllIll);
        final int lllllllllllllIIIIllllIIlIlllllIl = Integer.MAX_VALUE - this.experienceTotal;
        if (lllllllllllllIIIIllllIIlIllllIll > lllllllllllllIIIIllllIIlIlllllIl) {
            lllllllllllllIIIIllllIIlIllllIll = lllllllllllllIIIIllllIIlIlllllIl;
        }
        this.experience += lllllllllllllIIIIllllIIlIllllIll / (float)this.xpBarCap();
        this.experienceTotal += lllllllllllllIIIIllllIIlIllllIll;
        while (this.experience >= 1.0f) {
            this.experience = (this.experience - 1.0f) * this.xpBarCap();
            this.addExperienceLevel(1);
            this.experience /= this.xpBarCap();
        }
    }
    
    public int getSleepTimer() {
        return this.sleepTimer;
    }
    
    @Override
    public boolean sendCommandFeedback() {
        return this.getServer().worldServers[0].getGameRules().getBoolean("sendCommandFeedback");
    }
    
    @Override
    public boolean isInvisibleToPlayer(final EntityPlayer lllllllllllllIIIIllllIIIllllIIII) {
        if (!this.isInvisible()) {
            return false;
        }
        if (lllllllllllllIIIIllllIIIllllIIII.isSpectator()) {
            return false;
        }
        final Team lllllllllllllIIIIllllIIIlllIllll = this.getTeam();
        return lllllllllllllIIIIllllIIIlllIllll == null || lllllllllllllIIIIllllIIIllllIIII == null || lllllllllllllIIIIllllIIIllllIIII.getTeam() != lllllllllllllIIIIllllIIIlllIllll || !lllllllllllllIIIIllllIIIlllIllll.getSeeFriendlyInvisiblesEnabled();
    }
    
    @Override
    protected SoundEvent getSwimSound() {
        return SoundEvents.ENTITY_PLAYER_SWIM;
    }
    
    public boolean canOpen(final LockCode lllllllllllllIIIIllllIIIlIllllIl) {
        if (lllllllllllllIIIIllllIIIlIllllIl.isEmpty()) {
            return true;
        }
        final ItemStack lllllllllllllIIIIllllIIIlIllllll = this.getHeldItemMainhand();
        return !lllllllllllllIIIIllllIIIlIllllll.func_190926_b() && lllllllllllllIIIIllllIIIlIllllll.hasDisplayName() && lllllllllllllIIIIllllIIIlIllllll.getDisplayName().equals(lllllllllllllIIIIllllIIIlIllllIl.getLock());
    }
    
    public void onCriticalHit(final Entity lllllllllllllIIIIllllIlIIlllllII) {
    }
    
    public void onEnchantmentCritical(final Entity lllllllllllllIIIIllllIlIIllllIlI) {
    }
    
    public void addScore(final int lllllllllllllIIIIllllIlllIllIlIl) {
        final int lllllllllllllIIIIllllIlllIllIlll = this.getScore();
        this.dataManager.set(EntityPlayer.PLAYER_SCORE, lllllllllllllIIIIllllIlllIllIlll + lllllllllllllIIIIllllIlllIllIlIl);
    }
    
    public InventoryEnderChest getInventoryEnderChest() {
        return this.theInventoryEnderChest;
    }
    
    public void func_192022_b(final List<IRecipe> lllllllllllllIIIIllllIIllllIIlIl) {
    }
    
    public void sendPlayerAbilities() {
    }
    
    @Override
    protected void updateEntityActionState() {
        super.updateEntityActionState();
        this.updateArmSwingProgress();
        this.rotationYawHead = this.rotationYaw;
        this.rotationPitchHead = this.rotationPitch;
    }
    
    private boolean isInBed() {
        return this.world.getBlockState(this.bedLocation).getBlock() == Blocks.BED;
    }
    
    @Override
    public boolean isEntityInsideOpaqueBlock() {
        return !this.sleeping && super.isEntityInsideOpaqueBlock();
    }
    
    public void addExperienceLevel(final int lllllllllllllIIIIllllIIlIllIlIll) {
        this.experienceLevel += lllllllllllllIIIIllllIIlIllIlIll;
        if (this.experienceLevel < 0) {
            this.experienceLevel = 0;
            this.experience = 0.0f;
            this.experienceTotal = 0;
        }
        if (lllllllllllllIIIIllllIIlIllIlIll > 0 && this.experienceLevel % 5 == 0 && this.lastXPSound < this.ticksExisted - 100.0f) {
            final float lllllllllllllIIIIllllIIlIllIlIlI = (this.experienceLevel > 30) ? 1.0f : (this.experienceLevel / 30.0f);
            this.world.playSound(null, this.posX, this.posY, this.posZ, SoundEvents.ENTITY_PLAYER_LEVELUP, this.getSoundCategory(), lllllllllllllIIIIllllIIlIllIlIlI * 0.75f, 1.0f);
            this.lastXPSound = this.ticksExisted;
        }
    }
    
    @Override
    public void playSound(final SoundEvent lllllllllllllIIIIlllllIIIIIllIlI, final float lllllllllllllIIIIlllllIIIIIllIIl, final float lllllllllllllIIIIlllllIIIIIlIlII) {
        this.world.playSound(this, this.posX, this.posY, this.posZ, lllllllllllllIIIIlllllIIIIIllIlI, this.getSoundCategory(), lllllllllllllIIIIlllllIIIIIllIIl, lllllllllllllIIIIlllllIIIIIlIlII);
    }
    
    public void setReducedDebug(final boolean lllllllllllllIIIIllllIIIlIIllIIl) {
        this.hasReducedDebug = lllllllllllllIIIIllllIIIlIIllIIl;
    }
    
    @Override
    public Team getTeam() {
        return this.getWorldScoreboard().getPlayersTeam(this.getName());
    }
    
    @Override
    protected int getExperiencePoints(final EntityPlayer lllllllllllllIIIIllllIIlIIlllIIl) {
        if (!this.world.getGameRules().getBoolean("keepInventory") && !this.isSpectator()) {
            final int lllllllllllllIIIIllllIIlIIlllIII = this.experienceLevel * 7;
            return (lllllllllllllIIIIllllIIlIIlllIII > 100) ? 100 : lllllllllllllIIIIllllIIlIIlllIII;
        }
        return 0;
    }
    
    public void attackTargetEntityWithCurrentItem(final Entity lllllllllllllIIIIllllIlIlIIllIll) {
        if (lllllllllllllIIIIllllIlIlIIllIll.canBeAttackedWithItem() && !lllllllllllllIIIIllllIlIlIIllIll.hitByEntity(this)) {
            float lllllllllllllIIIIllllIlIlIllIlIl = (float)this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue();
            float lllllllllllllIIIIllllIlIlIllIIll = 0.0f;
            if (lllllllllllllIIIIllllIlIlIIllIll instanceof EntityLivingBase) {
                final float lllllllllllllIIIIllllIlIlIllIlII = EnchantmentHelper.getModifierForCreature(this.getHeldItemMainhand(), ((EntityLivingBase)lllllllllllllIIIIllllIlIlIIllIll).getCreatureAttribute());
            }
            else {
                lllllllllllllIIIIllllIlIlIllIIll = EnchantmentHelper.getModifierForCreature(this.getHeldItemMainhand(), EnumCreatureAttribute.UNDEFINED);
            }
            final float lllllllllllllIIIIllllIlIlIllIIlI = this.getCooledAttackStrength(0.5f);
            lllllllllllllIIIIllllIlIlIllIlIl *= 0.2f + lllllllllllllIIIIllllIlIlIllIIlI * lllllllllllllIIIIllllIlIlIllIIlI * 0.8f;
            lllllllllllllIIIIllllIlIlIllIIll *= lllllllllllllIIIIllllIlIlIllIIlI;
            this.resetCooldown();
            if (lllllllllllllIIIIllllIlIlIllIlIl > 0.0f || lllllllllllllIIIIllllIlIlIllIIll > 0.0f) {
                final boolean lllllllllllllIIIIllllIlIlIllIIIl = lllllllllllllIIIIllllIlIlIllIIlI > 0.9f;
                boolean lllllllllllllIIIIllllIlIlIllIIII = false;
                int lllllllllllllIIIIllllIlIlIlIllll = 0;
                lllllllllllllIIIIllllIlIlIlIllll += EnchantmentHelper.getKnockbackModifier(this);
                if (this.isSprinting() && lllllllllllllIIIIllllIlIlIllIIIl) {
                    this.world.playSound(null, this.posX, this.posY, this.posZ, SoundEvents.ENTITY_PLAYER_ATTACK_KNOCKBACK, this.getSoundCategory(), 1.0f, 1.0f);
                    ++lllllllllllllIIIIllllIlIlIlIllll;
                    lllllllllllllIIIIllllIlIlIllIIII = true;
                }
                boolean lllllllllllllIIIIllllIlIlIlIlllI = lllllllllllllIIIIllllIlIlIllIIIl && this.fallDistance > 0.0f && !this.onGround && !this.isOnLadder() && !this.isInWater() && !this.isPotionActive(MobEffects.BLINDNESS) && !this.isRiding() && lllllllllllllIIIIllllIlIlIIllIll instanceof EntityLivingBase;
                lllllllllllllIIIIllllIlIlIlIlllI = (lllllllllllllIIIIllllIlIlIlIlllI && !this.isSprinting());
                if (lllllllllllllIIIIllllIlIlIlIlllI) {
                    lllllllllllllIIIIllllIlIlIllIlIl *= 1.5f;
                }
                lllllllllllllIIIIllllIlIlIllIlIl += lllllllllllllIIIIllllIlIlIllIIll;
                boolean lllllllllllllIIIIllllIlIlIlIllIl = false;
                final double lllllllllllllIIIIllllIlIlIlIllII = this.distanceWalkedModified - this.prevDistanceWalkedModified;
                if (lllllllllllllIIIIllllIlIlIllIIIl && !lllllllllllllIIIIllllIlIlIlIlllI && !lllllllllllllIIIIllllIlIlIllIIII && this.onGround && lllllllllllllIIIIllllIlIlIlIllII < this.getAIMoveSpeed()) {
                    final ItemStack lllllllllllllIIIIllllIlIlIlIlIll = this.getHeldItem(EnumHand.MAIN_HAND);
                    if (lllllllllllllIIIIllllIlIlIlIlIll.getItem() instanceof ItemSword) {
                        lllllllllllllIIIIllllIlIlIlIllIl = true;
                    }
                }
                float lllllllllllllIIIIllllIlIlIlIlIlI = 0.0f;
                boolean lllllllllllllIIIIllllIlIlIlIlIIl = false;
                final int lllllllllllllIIIIllllIlIlIlIlIII = EnchantmentHelper.getFireAspectModifier(this);
                if (lllllllllllllIIIIllllIlIlIIllIll instanceof EntityLivingBase) {
                    lllllllllllllIIIIllllIlIlIlIlIlI = ((EntityLivingBase)lllllllllllllIIIIllllIlIlIIllIll).getHealth();
                    if (lllllllllllllIIIIllllIlIlIlIlIII > 0 && !lllllllllllllIIIIllllIlIlIIllIll.isBurning()) {
                        lllllllllllllIIIIllllIlIlIlIlIIl = true;
                        lllllllllllllIIIIllllIlIlIIllIll.setFire(1);
                    }
                }
                final double lllllllllllllIIIIllllIlIlIlIIlll = lllllllllllllIIIIllllIlIlIIllIll.motionX;
                final double lllllllllllllIIIIllllIlIlIlIIllI = lllllllllllllIIIIllllIlIlIIllIll.motionY;
                final double lllllllllllllIIIIllllIlIlIlIIlIl = lllllllllllllIIIIllllIlIlIIllIll.motionZ;
                final boolean lllllllllllllIIIIllllIlIlIlIIlII = lllllllllllllIIIIllllIlIlIIllIll.attackEntityFrom(DamageSource.causePlayerDamage(this), lllllllllllllIIIIllllIlIlIllIlIl);
                if (lllllllllllllIIIIllllIlIlIlIIlII) {
                    if (lllllllllllllIIIIllllIlIlIlIllll > 0) {
                        if (lllllllllllllIIIIllllIlIlIIllIll instanceof EntityLivingBase) {
                            ((EntityLivingBase)lllllllllllllIIIIllllIlIlIIllIll).knockBack(this, lllllllllllllIIIIllllIlIlIlIllll * 0.5f, MathHelper.sin(this.rotationYaw * 0.017453292f), -MathHelper.cos(this.rotationYaw * 0.017453292f));
                        }
                        else {
                            lllllllllllllIIIIllllIlIlIIllIll.addVelocity(-MathHelper.sin(this.rotationYaw * 0.017453292f) * lllllllllllllIIIIllllIlIlIlIllll * 0.5f, 0.1, MathHelper.cos(this.rotationYaw * 0.017453292f) * lllllllllllllIIIIllllIlIlIlIllll * 0.5f);
                        }
                        if (Main.moduleManager.getModule(Sprint.class).isToggled() && Sprint.keepsprint.getValBoolean()) {
                            this.setSprinting(true);
                        }
                        else {
                            this.motionX *= 0.6;
                            this.motionZ *= 0.6;
                            this.setSprinting(false);
                        }
                    }
                    if (lllllllllllllIIIIllllIlIlIlIllIl) {
                        final float lllllllllllllIIIIllllIlIlIlIIIll = 1.0f + EnchantmentHelper.func_191527_a(this) * lllllllllllllIIIIllllIlIlIllIlIl;
                        for (final EntityLivingBase lllllllllllllIIIIllllIlIlIlIIIlI : this.world.getEntitiesWithinAABB((Class<? extends Entity>)EntityLivingBase.class, lllllllllllllIIIIllllIlIlIIllIll.getEntityBoundingBox().expand(1.0, 0.25, 1.0))) {
                            if (lllllllllllllIIIIllllIlIlIlIIIlI != this && lllllllllllllIIIIllllIlIlIlIIIlI != lllllllllllllIIIIllllIlIlIIllIll && !this.isOnSameTeam(lllllllllllllIIIIllllIlIlIlIIIlI) && this.getDistanceSqToEntity(lllllllllllllIIIIllllIlIlIlIIIlI) < 9.0) {
                                lllllllllllllIIIIllllIlIlIlIIIlI.knockBack(this, 0.4f, MathHelper.sin(this.rotationYaw * 0.017453292f), -MathHelper.cos(this.rotationYaw * 0.017453292f));
                                lllllllllllllIIIIllllIlIlIlIIIlI.attackEntityFrom(DamageSource.causePlayerDamage(this), lllllllllllllIIIIllllIlIlIlIIIll);
                            }
                        }
                        this.world.playSound(null, this.posX, this.posY, this.posZ, SoundEvents.ENTITY_PLAYER_ATTACK_SWEEP, this.getSoundCategory(), 1.0f, 1.0f);
                        this.spawnSweepParticles();
                    }
                    if (lllllllllllllIIIIllllIlIlIIllIll instanceof EntityPlayerMP && lllllllllllllIIIIllllIlIlIIllIll.velocityChanged) {
                        ((EntityPlayerMP)lllllllllllllIIIIllllIlIlIIllIll).connection.sendPacket(new SPacketEntityVelocity(lllllllllllllIIIIllllIlIlIIllIll));
                        lllllllllllllIIIIllllIlIlIIllIll.velocityChanged = false;
                        lllllllllllllIIIIllllIlIlIIllIll.motionX = lllllllllllllIIIIllllIlIlIlIIlll;
                        lllllllllllllIIIIllllIlIlIIllIll.motionY = lllllllllllllIIIIllllIlIlIlIIllI;
                        lllllllllllllIIIIllllIlIlIIllIll.motionZ = lllllllllllllIIIIllllIlIlIlIIlIl;
                    }
                    if (lllllllllllllIIIIllllIlIlIlIlllI) {
                        this.world.playSound(null, this.posX, this.posY, this.posZ, SoundEvents.ENTITY_PLAYER_ATTACK_CRIT, this.getSoundCategory(), 1.0f, 1.0f);
                        this.onCriticalHit(lllllllllllllIIIIllllIlIlIIllIll);
                    }
                    if (!lllllllllllllIIIIllllIlIlIlIlllI && !lllllllllllllIIIIllllIlIlIlIllIl) {
                        if (lllllllllllllIIIIllllIlIlIllIIIl) {
                            this.world.playSound(null, this.posX, this.posY, this.posZ, SoundEvents.ENTITY_PLAYER_ATTACK_STRONG, this.getSoundCategory(), 1.0f, 1.0f);
                        }
                        else {
                            this.world.playSound(null, this.posX, this.posY, this.posZ, SoundEvents.ENTITY_PLAYER_ATTACK_WEAK, this.getSoundCategory(), 1.0f, 1.0f);
                        }
                    }
                    if (lllllllllllllIIIIllllIlIlIllIIll > 0.0f) {
                        this.onEnchantmentCritical(lllllllllllllIIIIllllIlIlIIllIll);
                    }
                    this.setLastAttacker(lllllllllllllIIIIllllIlIlIIllIll);
                    if (lllllllllllllIIIIllllIlIlIIllIll instanceof EntityLivingBase) {
                        EnchantmentHelper.applyThornEnchantments((EntityLivingBase)lllllllllllllIIIIllllIlIlIIllIll, this);
                    }
                    EnchantmentHelper.applyArthropodEnchantments(this, lllllllllllllIIIIllllIlIlIIllIll);
                    final ItemStack lllllllllllllIIIIllllIlIlIlIIIIl = this.getHeldItemMainhand();
                    Entity lllllllllllllIIIIllllIlIlIlIIIII = lllllllllllllIIIIllllIlIlIIllIll;
                    if (lllllllllllllIIIIllllIlIlIIllIll instanceof MultiPartEntityPart) {
                        final IEntityMultiPart lllllllllllllIIIIllllIlIlIIlllll = ((MultiPartEntityPart)lllllllllllllIIIIllllIlIlIIllIll).entityDragonObj;
                        if (lllllllllllllIIIIllllIlIlIIlllll instanceof EntityLivingBase) {
                            lllllllllllllIIIIllllIlIlIlIIIII = (EntityLivingBase)lllllllllllllIIIIllllIlIlIIlllll;
                        }
                    }
                    if (!lllllllllllllIIIIllllIlIlIlIIIIl.func_190926_b() && lllllllllllllIIIIllllIlIlIlIIIII instanceof EntityLivingBase) {
                        lllllllllllllIIIIllllIlIlIlIIIIl.hitEntity((EntityLivingBase)lllllllllllllIIIIllllIlIlIlIIIII, this);
                        if (lllllllllllllIIIIllllIlIlIlIIIIl.func_190926_b()) {
                            this.setHeldItem(EnumHand.MAIN_HAND, ItemStack.field_190927_a);
                        }
                    }
                    if (lllllllllllllIIIIllllIlIlIIllIll instanceof EntityLivingBase) {
                        final float lllllllllllllIIIIllllIlIlIIllllI = lllllllllllllIIIIllllIlIlIlIlIlI - ((EntityLivingBase)lllllllllllllIIIIllllIlIlIIllIll).getHealth();
                        this.addStat(StatList.DAMAGE_DEALT, Math.round(lllllllllllllIIIIllllIlIlIIllllI * 10.0f));
                        if (lllllllllllllIIIIllllIlIlIlIlIII > 0) {
                            lllllllllllllIIIIllllIlIlIIllIll.setFire(lllllllllllllIIIIllllIlIlIlIlIII * 4);
                        }
                        if (this.world instanceof WorldServer && lllllllllllllIIIIllllIlIlIIllllI > 2.0f) {
                            final int lllllllllllllIIIIllllIlIlIIlllIl = (int)(lllllllllllllIIIIllllIlIlIIllllI * 0.5);
                            ((WorldServer)this.world).spawnParticle(EnumParticleTypes.DAMAGE_INDICATOR, lllllllllllllIIIIllllIlIlIIllIll.posX, lllllllllllllIIIIllllIlIlIIllIll.posY + lllllllllllllIIIIllllIlIlIIllIll.height * 0.5f, lllllllllllllIIIIllllIlIlIIllIll.posZ, lllllllllllllIIIIllllIlIlIIlllIl, 0.1, 0.0, 0.1, 0.2, new int[0]);
                        }
                    }
                    this.addExhaustion(0.1f);
                }
                else {
                    this.world.playSound(null, this.posX, this.posY, this.posZ, SoundEvents.ENTITY_PLAYER_ATTACK_NODAMAGE, this.getSoundCategory(), 1.0f, 1.0f);
                    if (lllllllllllllIIIIllllIlIlIlIlIIl) {
                        lllllllllllllIIIIllllIlIlIIllIll.extinguish();
                    }
                }
            }
        }
    }
    
    @Override
    public double getYOffset() {
        return -0.35;
    }
    
    public boolean hasReducedDebug() {
        return this.hasReducedDebug;
    }
    
    public void addChatComponentMessage(final ITextComponent lllllllllllllIIIIllllIlIIIIIIllI, final boolean lllllllllllllIIIIllllIlIIIIIIlIl) {
    }
    
    @Override
    public Iterable<ItemStack> getArmorInventoryList() {
        return this.inventory.armorInventory;
    }
    
    static class SleepEnemyPredicate implements Predicate<EntityMob>
    {
        private final /* synthetic */ EntityPlayer field_192387_a;
        
        public boolean apply(@Nullable final EntityMob lllllllllllllIlllIllIllIIlIIllII) {
            return lllllllllllllIlllIllIllIIlIIllII.func_191990_c(this.field_192387_a);
        }
        
        private SleepEnemyPredicate() {
        }
    }
    
    public enum SleepResult
    {
        NOT_POSSIBLE_HERE("NOT_POSSIBLE_HERE", 1), 
        NOT_SAFE("NOT_SAFE", 5), 
        OTHER_PROBLEM("OTHER_PROBLEM", 4), 
        OK("OK", 0), 
        NOT_POSSIBLE_NOW("NOT_POSSIBLE_NOW", 2), 
        TOO_FAR_AWAY("TOO_FAR_AWAY", 3);
        
        private SleepResult(final String llllllllllllllIllIIIllIlIIllIlII, final int llllllllllllllIllIIIllIlIIllIIll) {
        }
    }
    
    public enum EnumChatVisibility
    {
        SYSTEM("SYSTEM", 1, 1, "options.chat.visibility.system"), 
        FULL("FULL", 0, 0, "options.chat.visibility.full");
        
        private static final /* synthetic */ EnumChatVisibility[] ID_LOOKUP;
        private final /* synthetic */ String resourceKey;
        private final /* synthetic */ int chatVisibility;
        
        HIDDEN("HIDDEN", 2, 2, "options.chat.visibility.hidden");
        
        public int getChatVisibility() {
            return this.chatVisibility;
        }
        
        public static EnumChatVisibility getEnumChatVisibility(final int llllllllllllllIlIlIIlllIlIIIIlII) {
            return EnumChatVisibility.ID_LOOKUP[llllllllllllllIlIlIIlllIlIIIIlII % EnumChatVisibility.ID_LOOKUP.length];
        }
        
        private EnumChatVisibility(final String llllllllllllllIlIlIIlllIlIIIllII, final int llllllllllllllIlIlIIlllIlIIIlIll, final int llllllllllllllIlIlIIlllIlIIIlIlI, final String llllllllllllllIlIlIIlllIlIIIlllI) {
            this.chatVisibility = llllllllllllllIlIlIIlllIlIIIlIlI;
            this.resourceKey = llllllllllllllIlIlIIlllIlIIIlllI;
        }
        
        static {
            ID_LOOKUP = new EnumChatVisibility[values().length];
            final char llllllllllllllIlIlIIlllIlIIlIllI;
            final byte llllllllllllllIlIlIIlllIlIIlIlll = (byte)((EnumChatVisibility[])(Object)(llllllllllllllIlIlIIlllIlIIlIllI = (char)(Object)values())).length;
            for (Exception llllllllllllllIlIlIIlllIlIIllIII = (Exception)0; llllllllllllllIlIlIIlllIlIIllIII < llllllllllllllIlIlIIlllIlIIlIlll; ++llllllllllllllIlIlIIlllIlIIllIII) {
                final EnumChatVisibility llllllllllllllIlIlIIlllIlIIllIlI = llllllllllllllIlIlIIlllIlIIlIllI[llllllllllllllIlIlIIlllIlIIllIII];
                EnumChatVisibility.ID_LOOKUP[llllllllllllllIlIlIIlllIlIIllIlI.chatVisibility] = llllllllllllllIlIlIIlllIlIIllIlI;
            }
        }
        
        public String getResourceKey() {
            return this.resourceKey;
        }
    }
}
