package net.minecraft.entity;

import net.minecraft.world.biome.*;
import net.minecraft.entity.ai.*;
import javax.annotation.*;
import net.minecraft.block.state.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.network.datasync.*;
import net.minecraft.world.storage.loot.*;
import net.minecraft.item.*;
import net.minecraft.enchantment.*;
import com.google.common.collect.*;
import net.minecraft.nbt.*;
import java.util.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.util.datafix.walkers.*;
import net.minecraft.util.datafix.*;
import net.minecraft.network.play.server.*;
import net.minecraft.network.*;
import net.minecraft.pathfinding.*;
import net.minecraft.entity.monster.*;
import net.minecraft.scoreboard.*;
import net.minecraft.util.math.*;
import optifine.*;
import net.minecraft.entity.item.*;
import net.minecraft.world.*;
import net.minecraft.init.*;
import net.minecraft.util.*;

public abstract class EntityLiving extends EntityLivingBase
{
    protected /* synthetic */ PathNavigate navigator;
    public /* synthetic */ int livingSoundTime;
    protected /* synthetic */ EntityJumpHelper jumpHelper;
    private /* synthetic */ EntityLivingBase attackTarget;
    private /* synthetic */ boolean isLeashed;
    private final /* synthetic */ EntityBodyHelper bodyHelper;
    private /* synthetic */ long deathLootTableSeed;
    protected /* synthetic */ int experienceValue;
    protected /* synthetic */ float[] inventoryHandsDropChances;
    private /* synthetic */ NBTTagCompound leashNBTTag;
    private final /* synthetic */ Map<PathNodeType, Float> mapPathPriority;
    public /* synthetic */ BlockPos spawnPosition;
    private /* synthetic */ String teamUuidString;
    protected final /* synthetic */ EntityAITasks tasks;
    private /* synthetic */ Entity leashedToEntity;
    private /* synthetic */ ResourceLocation deathLootTable;
    protected /* synthetic */ float[] inventoryArmorDropChances;
    private final /* synthetic */ NonNullList<ItemStack> inventoryArmor;
    public /* synthetic */ int randomMobsId;
    private final /* synthetic */ EntityLookHelper lookHelper;
    private /* synthetic */ UUID teamUuid;
    public /* synthetic */ Biome spawnBiome;
    private /* synthetic */ boolean persistenceRequired;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$inventory$EntityEquipmentSlot$Type;
    protected /* synthetic */ EntityMoveHelper moveHelper;
    private /* synthetic */ boolean canPickUpLoot;
    private final /* synthetic */ NonNullList<ItemStack> inventoryHands;
    private final /* synthetic */ EntitySenses senses;
    protected final /* synthetic */ EntityAITasks targetTasks;
    private static final /* synthetic */ DataParameter<Byte> AI_FLAGS;
    
    @Nullable
    public EntityLivingBase getAttackTarget() {
        return this.attackTarget;
    }
    
    @Override
    public Iterable<ItemStack> getArmorInventoryList() {
        return this.inventoryArmor;
    }
    
    public float getRenderSizeModifier() {
        return 1.0f;
    }
    
    public boolean getCanSpawnHere() {
        final IBlockState lllllllllllllllIIlIIIIIIlllIllIl = this.world.getBlockState(new BlockPos(this).down());
        return lllllllllllllllIIlIIIIIIlllIllIl.canEntitySpawn(this);
    }
    
    public boolean isNotColliding() {
        return !this.world.containsAnyLiquid(this.getEntityBoundingBox()) && this.world.getCollisionBoxes(this, this.getEntityBoundingBox()).isEmpty() && this.world.checkNoEntityCollision(this.getEntityBoundingBox(), this);
    }
    
    public EntitySenses getEntitySenses() {
        return this.senses;
    }
    
    @Override
    protected int getExperiencePoints(final EntityPlayer lllllllllllllllIIlIIIIlIIIIllIII) {
        if (this.experienceValue > 0) {
            int lllllllllllllllIIlIIIIlIIIIlIlll = this.experienceValue;
            for (int lllllllllllllllIIlIIIIlIIIIlIllI = 0; lllllllllllllllIIlIIIIlIIIIlIllI < this.inventoryArmor.size(); ++lllllllllllllllIIlIIIIlIIIIlIllI) {
                if (!this.inventoryArmor.get(lllllllllllllllIIlIIIIlIIIIlIllI).func_190926_b() && this.inventoryArmorDropChances[lllllllllllllllIIlIIIIlIIIIlIllI] <= 1.0f) {
                    lllllllllllllllIIlIIIIlIIIIlIlll += 1 + this.rand.nextInt(3);
                }
            }
            for (int lllllllllllllllIIlIIIIlIIIIlIlIl = 0; lllllllllllllllIIlIIIIlIIIIlIlIl < this.inventoryHands.size(); ++lllllllllllllllIIlIIIIlIIIIlIlIl) {
                if (!this.inventoryHands.get(lllllllllllllllIIlIIIIlIIIIlIlIl).func_190926_b() && this.inventoryHandsDropChances[lllllllllllllllIIlIIIIlIIIIlIlIl] <= 1.0f) {
                    lllllllllllllllIIlIIIIlIIIIlIlll += 1 + this.rand.nextInt(3);
                }
            }
            return lllllllllllllllIIlIIIIlIIIIlIlll;
        }
        return this.experienceValue;
    }
    
    public void setLeftHanded(final boolean lllllllllllllllIIIllllllllIllIlI) {
        final byte lllllllllllllllIIIllllllllIllIIl = this.dataManager.get(EntityLiving.AI_FLAGS);
        this.dataManager.set(EntityLiving.AI_FLAGS, lllllllllllllllIIIllllllllIllIlI ? ((byte)(lllllllllllllllIIIllllllllIllIIl | 0x2)) : ((byte)(lllllllllllllllIIIllllllllIllIIl & 0xFFFFFFFD)));
    }
    
    @Override
    protected void playHurtSound(final DamageSource lllllllllllllllIIlIIIIlIIIlIIIlI) {
        this.applyEntityAI();
        super.playHurtSound(lllllllllllllllIIlIIIIlIIIlIIIlI);
    }
    
    public void setDropChance(final EntityEquipmentSlot lllllllllllllllIIlIIIIIIIlIlllll, final float lllllllllllllllIIlIIIIIIIlIllIll) {
        switch ($SWITCH_TABLE$net$minecraft$inventory$EntityEquipmentSlot$Type()[lllllllllllllllIIlIIIIIIIlIlllll.getSlotType().ordinal()]) {
            case 1: {
                this.inventoryHandsDropChances[lllllllllllllllIIlIIIIIIIlIlllll.getIndex()] = lllllllllllllllIIlIIIIIIIlIllIll;
                break;
            }
            case 2: {
                this.inventoryArmorDropChances[lllllllllllllllIIlIIIIIIIlIlllll.getIndex()] = lllllllllllllllIIlIIIIIIIlIllIll;
                break;
            }
        }
    }
    
    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        this.world.theProfiler.startSection("looting");
        if (!this.world.isRemote && this.canPickUpLoot() && !this.dead && this.world.getGameRules().getBoolean("mobGriefing")) {
            for (final EntityItem lllllllllllllllIIlIIIIIlIllIIlIl : this.world.getEntitiesWithinAABB((Class<? extends Entity>)EntityItem.class, this.getEntityBoundingBox().expand(1.0, 0.0, 1.0))) {
                if (!lllllllllllllllIIlIIIIIlIllIIlIl.isDead && !lllllllllllllllIIlIIIIIlIllIIlIl.getEntityItem().func_190926_b() && !lllllllllllllllIIlIIIIIlIllIIlIl.cannotPickup()) {
                    this.updateEquipmentIfNeeded(lllllllllllllllIIlIIIIIlIllIIlIl);
                }
            }
        }
        this.world.theProfiler.endSection();
    }
    
    @Override
    protected void dropFewItems(final boolean lllllllllllllllIIlIIIIIllllIIIIl, final int lllllllllllllllIIlIIIIIllllIIIII) {
        final Item lllllllllllllllIIlIIIIIlllIlllll = this.getDropItem();
        if (lllllllllllllllIIlIIIIIlllIlllll != null) {
            int lllllllllllllllIIlIIIIIlllIllllI = this.rand.nextInt(3);
            if (lllllllllllllllIIlIIIIIllllIIIII > 0) {
                lllllllllllllllIIlIIIIIlllIllllI += this.rand.nextInt(lllllllllllllllIIlIIIIIllllIIIII + 1);
            }
            for (int lllllllllllllllIIlIIIIIlllIlllIl = 0; lllllllllllllllIIlIIIIIlllIlllIl < lllllllllllllllIIlIIIIIlllIllllI; ++lllllllllllllllIIlIIIIIlllIlllIl) {
                this.dropItem(lllllllllllllllIIlIIIIIlllIlllll, 1);
            }
        }
    }
    
    public EntityMoveHelper getMoveHelper() {
        return this.moveHelper;
    }
    
    public boolean canPickUpLoot() {
        return this.canPickUpLoot;
    }
    
    static {
        AI_FLAGS = EntityDataManager.createKey(EntityLiving.class, DataSerializers.BYTE);
    }
    
    public boolean isLeftHanded() {
        return (this.dataManager.get(EntityLiving.AI_FLAGS) & 0x2) != 0x0;
    }
    
    @Override
    protected void dropLoot(final boolean lllllllllllllllIIlIIIIIllIIlIIIl, final int lllllllllllllllIIlIIIIIllIIlIIII, final DamageSource lllllllllllllllIIlIIIIIllIIIllll) {
        ResourceLocation lllllllllllllllIIlIIIIIllIIIlllI = this.deathLootTable;
        if (lllllllllllllllIIlIIIIIllIIIlllI == null) {
            lllllllllllllllIIlIIIIIllIIIlllI = this.getLootTable();
        }
        if (lllllllllllllllIIlIIIIIllIIIlllI != null) {
            final LootTable lllllllllllllllIIlIIIIIllIIIllIl = this.world.getLootTableManager().getLootTableFromLocation(lllllllllllllllIIlIIIIIllIIIlllI);
            this.deathLootTable = null;
            LootContext.Builder lllllllllllllllIIlIIIIIllIIIllII = new LootContext.Builder((WorldServer)this.world).withLootedEntity(this).withDamageSource(lllllllllllllllIIlIIIIIllIIIllll);
            if (lllllllllllllllIIlIIIIIllIIlIIIl && this.attackingPlayer != null) {
                lllllllllllllllIIlIIIIIllIIIllII = lllllllllllllllIIlIIIIIllIIIllII.withPlayer(this.attackingPlayer).withLuck(this.attackingPlayer.getLuck());
            }
            for (final ItemStack lllllllllllllllIIlIIIIIllIIIlIll : lllllllllllllllIIlIIIIIllIIIllIl.generateLootForPools((this.deathLootTableSeed == 0L) ? this.rand : new Random(this.deathLootTableSeed), lllllllllllllllIIlIIIIIllIIIllII.build())) {
                this.entityDropItem(lllllllllllllllIIlIIIIIllIIIlIll, 0.0f);
            }
            this.dropEquipment(lllllllllllllllIIlIIIIIllIIlIIIl, lllllllllllllllIIlIIIIIllIIlIIII);
        }
        else {
            super.dropLoot(lllllllllllllllIIlIIIIIllIIlIIIl, lllllllllllllllIIlIIIIIllIIlIIII, lllllllllllllllIIlIIIIIllIIIllll);
        }
    }
    
    public float getPathPriority(final PathNodeType lllllllllllllllIIlIIIIlIIlIlllIl) {
        final Float lllllllllllllllIIlIIIIlIIlIlllll = this.mapPathPriority.get(lllllllllllllllIIlIIIIlIIlIlllIl);
        return (lllllllllllllllIIlIIIIlIIlIlllll == null) ? lllllllllllllllIIlIIIIlIIlIlllIl.getPriority() : lllllllllllllllIIlIIIIlIIlIlllll;
    }
    
    protected void updateEquipmentIfNeeded(final EntityItem lllllllllllllllIIlIIIIIlIlIllIII) {
        final ItemStack lllllllllllllllIIlIIIIIlIlIlIlll = lllllllllllllllIIlIIIIIlIlIllIII.getEntityItem();
        final EntityEquipmentSlot lllllllllllllllIIlIIIIIlIlIlIllI = getSlotForItemStack(lllllllllllllllIIlIIIIIlIlIlIlll);
        boolean lllllllllllllllIIlIIIIIlIlIlIlIl = true;
        final ItemStack lllllllllllllllIIlIIIIIlIlIlIlII = this.getItemStackFromSlot(lllllllllllllllIIlIIIIIlIlIlIllI);
        if (!lllllllllllllllIIlIIIIIlIlIlIlII.func_190926_b()) {
            if (lllllllllllllllIIlIIIIIlIlIlIllI.getSlotType() == EntityEquipmentSlot.Type.HAND) {
                if (lllllllllllllllIIlIIIIIlIlIlIlll.getItem() instanceof ItemSword && !(lllllllllllllllIIlIIIIIlIlIlIlII.getItem() instanceof ItemSword)) {
                    lllllllllllllllIIlIIIIIlIlIlIlIl = true;
                }
                else if (lllllllllllllllIIlIIIIIlIlIlIlll.getItem() instanceof ItemSword && lllllllllllllllIIlIIIIIlIlIlIlII.getItem() instanceof ItemSword) {
                    final ItemSword lllllllllllllllIIlIIIIIlIlIlIIll = (ItemSword)lllllllllllllllIIlIIIIIlIlIlIlll.getItem();
                    final ItemSword lllllllllllllllIIlIIIIIlIlIlIIlI = (ItemSword)lllllllllllllllIIlIIIIIlIlIlIlII.getItem();
                    if (lllllllllllllllIIlIIIIIlIlIlIIll.getDamageVsEntity() == lllllllllllllllIIlIIIIIlIlIlIIlI.getDamageVsEntity()) {
                        lllllllllllllllIIlIIIIIlIlIlIlIl = (lllllllllllllllIIlIIIIIlIlIlIlll.getMetadata() > lllllllllllllllIIlIIIIIlIlIlIlII.getMetadata() || (lllllllllllllllIIlIIIIIlIlIlIlll.hasTagCompound() && !lllllllllllllllIIlIIIIIlIlIlIlII.hasTagCompound()));
                    }
                    else {
                        lllllllllllllllIIlIIIIIlIlIlIlIl = (lllllllllllllllIIlIIIIIlIlIlIIll.getDamageVsEntity() > lllllllllllllllIIlIIIIIlIlIlIIlI.getDamageVsEntity());
                    }
                }
                else {
                    lllllllllllllllIIlIIIIIlIlIlIlIl = (lllllllllllllllIIlIIIIIlIlIlIlll.getItem() instanceof ItemBow && lllllllllllllllIIlIIIIIlIlIlIlII.getItem() instanceof ItemBow && lllllllllllllllIIlIIIIIlIlIlIlll.hasTagCompound() && !lllllllllllllllIIlIIIIIlIlIlIlII.hasTagCompound());
                }
            }
            else if (lllllllllllllllIIlIIIIIlIlIlIlll.getItem() instanceof ItemArmor && !(lllllllllllllllIIlIIIIIlIlIlIlII.getItem() instanceof ItemArmor)) {
                lllllllllllllllIIlIIIIIlIlIlIlIl = true;
            }
            else if (lllllllllllllllIIlIIIIIlIlIlIlll.getItem() instanceof ItemArmor && lllllllllllllllIIlIIIIIlIlIlIlII.getItem() instanceof ItemArmor && !EnchantmentHelper.func_190938_b(lllllllllllllllIIlIIIIIlIlIlIlII)) {
                final ItemArmor lllllllllllllllIIlIIIIIlIlIlIIIl = (ItemArmor)lllllllllllllllIIlIIIIIlIlIlIlll.getItem();
                final ItemArmor lllllllllllllllIIlIIIIIlIlIlIIII = (ItemArmor)lllllllllllllllIIlIIIIIlIlIlIlII.getItem();
                if (lllllllllllllllIIlIIIIIlIlIlIIIl.damageReduceAmount == lllllllllllllllIIlIIIIIlIlIlIIII.damageReduceAmount) {
                    lllllllllllllllIIlIIIIIlIlIlIlIl = (lllllllllllllllIIlIIIIIlIlIlIlll.getMetadata() > lllllllllllllllIIlIIIIIlIlIlIlII.getMetadata() || (lllllllllllllllIIlIIIIIlIlIlIlll.hasTagCompound() && !lllllllllllllllIIlIIIIIlIlIlIlII.hasTagCompound()));
                }
                else {
                    lllllllllllllllIIlIIIIIlIlIlIlIl = (lllllllllllllllIIlIIIIIlIlIlIIIl.damageReduceAmount > lllllllllllllllIIlIIIIIlIlIlIIII.damageReduceAmount);
                }
            }
            else {
                lllllllllllllllIIlIIIIIlIlIlIlIl = false;
            }
        }
        if (lllllllllllllllIIlIIIIIlIlIlIlIl && this.canEquipItem(lllllllllllllllIIlIIIIIlIlIlIlll)) {
            final double lllllllllllllllIIlIIIIIlIlIIllIl;
            switch ($SWITCH_TABLE$net$minecraft$inventory$EntityEquipmentSlot$Type()[lllllllllllllllIIlIIIIIlIlIlIllI.getSlotType().ordinal()]) {
                case 1: {
                    final double lllllllllllllllIIlIIIIIlIlIIllll = this.inventoryHandsDropChances[lllllllllllllllIIlIIIIIlIlIlIllI.getIndex()];
                    break;
                }
                case 2: {
                    final double lllllllllllllllIIlIIIIIlIlIIlllI = this.inventoryArmorDropChances[lllllllllllllllIIlIIIIIlIlIlIllI.getIndex()];
                    break;
                }
                default: {
                    lllllllllllllllIIlIIIIIlIlIIllIl = 0.0;
                    break;
                }
            }
            if (!lllllllllllllllIIlIIIIIlIlIlIlII.func_190926_b() && this.rand.nextFloat() - 0.1f < lllllllllllllllIIlIIIIIlIlIIllIl) {
                this.entityDropItem(lllllllllllllllIIlIIIIIlIlIlIlII, 0.0f);
            }
            this.setItemStackToSlot(lllllllllllllllIIlIIIIIlIlIlIllI, lllllllllllllllIIlIIIIIlIlIlIlll);
            switch ($SWITCH_TABLE$net$minecraft$inventory$EntityEquipmentSlot$Type()[lllllllllllllllIIlIIIIIlIlIlIllI.getSlotType().ordinal()]) {
                case 1: {
                    this.inventoryHandsDropChances[lllllllllllllllIIlIIIIIlIlIlIllI.getIndex()] = 2.0f;
                    break;
                }
                case 2: {
                    this.inventoryArmorDropChances[lllllllllllllllIIlIIIIIlIlIlIllI.getIndex()] = 2.0f;
                    break;
                }
            }
            this.persistenceRequired = true;
            this.onItemPickup(lllllllllllllllIIlIIIIIlIlIllIII, lllllllllllllllIIlIIIIIlIlIlIlll.func_190916_E());
            lllllllllllllllIIlIIIIIlIlIllIII.setDead();
        }
    }
    
    public boolean canAttackClass(final Class<? extends EntityLivingBase> lllllllllllllllIIlIIIIlIIIllIlII) {
        return lllllllllllllllIIlIIIIlIIIllIlII != EntityGhast.class;
    }
    
    @Override
    public void onEntityUpdate() {
        super.onEntityUpdate();
        this.world.theProfiler.startSection("mobBaseTick");
        if (this.isEntityAlive() && this.rand.nextInt(1000) < this.livingSoundTime++) {
            this.applyEntityAI();
            this.playLivingSound();
        }
        this.world.theProfiler.endSection();
    }
    
    private void onUpdateMinimal() {
        ++this.entityAge;
        if (this instanceof EntityMob) {
            final float lllllllllllllllIIIlllllllIllIlll = this.getBrightness();
            if (lllllllllllllllIIIlllllllIllIlll > 0.5f) {
                this.entityAge += 2;
            }
        }
        this.despawnEntity();
    }
    
    public boolean getLeashed() {
        return this.isLeashed;
    }
    
    @Nullable
    protected ResourceLocation getLootTable() {
        return null;
    }
    
    public PathNavigate getNavigator() {
        return this.navigator;
    }
    
    protected boolean canDespawn() {
        return true;
    }
    
    public int getTalkInterval() {
        return 80;
    }
    
    private void applyEntityAI() {
        this.livingSoundTime = -this.getTalkInterval();
    }
    
    protected boolean canEquipItem(final ItemStack lllllllllllllllIIlIIIIIlIlIIIIll) {
        return true;
    }
    
    public void playLivingSound() {
        final SoundEvent lllllllllllllllIIlIIIIlIIIlIlIll = this.getAmbientSound();
        if (lllllllllllllllIIlIIIIlIIIlIlIll != null) {
            this.playSound(lllllllllllllllIIlIIIIlIIIlIlIll, this.getSoundVolume(), this.getSoundPitch());
        }
    }
    
    public EntityLiving(final World lllllllllllllllIIlIIIIlIIlllIlIl) {
        super(lllllllllllllllIIlIIIIlIIlllIlIl);
        this.inventoryHands = NonNullList.func_191197_a(2, ItemStack.field_190927_a);
        this.inventoryHandsDropChances = new float[2];
        this.inventoryArmor = NonNullList.func_191197_a(4, ItemStack.field_190927_a);
        this.inventoryArmorDropChances = new float[4];
        this.mapPathPriority = (Map<PathNodeType, Float>)Maps.newEnumMap((Class)PathNodeType.class);
        this.randomMobsId = 0;
        this.spawnBiome = null;
        this.spawnPosition = null;
        this.teamUuid = null;
        this.teamUuidString = null;
        this.tasks = new EntityAITasks((lllllllllllllllIIlIIIIlIIlllIlIl != null && lllllllllllllllIIlIIIIlIIlllIlIl.theProfiler != null) ? lllllllllllllllIIlIIIIlIIlllIlIl.theProfiler : null);
        this.targetTasks = new EntityAITasks((lllllllllllllllIIlIIIIlIIlllIlIl != null && lllllllllllllllIIlIIIIlIIlllIlIl.theProfiler != null) ? lllllllllllllllIIlIIIIlIIlllIlIl.theProfiler : null);
        this.lookHelper = new EntityLookHelper(this);
        this.moveHelper = new EntityMoveHelper(this);
        this.jumpHelper = new EntityJumpHelper(this);
        this.bodyHelper = this.createBodyHelper();
        this.navigator = this.getNewNavigator(lllllllllllllllIIlIIIIlIIlllIlIl);
        this.senses = new EntitySenses(this);
        Arrays.fill(this.inventoryArmorDropChances, 0.085f);
        Arrays.fill(this.inventoryHandsDropChances, 0.085f);
        if (lllllllllllllllIIlIIIIlIIlllIlIl != null && !lllllllllllllllIIlIIIIlIIlllIlIl.isRemote) {
            this.initEntityAI();
        }
        final UUID lllllllllllllllIIlIIIIlIIlllIlII = this.getUniqueID();
        final long lllllllllllllllIIlIIIIlIIlllIIll = lllllllllllllllIIlIIIIlIIlllIlII.getLeastSignificantBits();
        this.randomMobsId = (int)(lllllllllllllllIIlIIIIlIIlllIIll & 0x7FFFFFFFL);
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound lllllllllllllllIIlIIIIIlllIIIllI) {
        super.writeEntityToNBT(lllllllllllllllIIlIIIIIlllIIIllI);
        lllllllllllllllIIlIIIIIlllIIIllI.setBoolean("CanPickUpLoot", this.canPickUpLoot());
        lllllllllllllllIIlIIIIIlllIIIllI.setBoolean("PersistenceRequired", this.persistenceRequired);
        final NBTTagList lllllllllllllllIIlIIIIIlllIIIlIl = new NBTTagList();
        for (final ItemStack lllllllllllllllIIlIIIIIlllIIIlII : this.inventoryArmor) {
            final NBTTagCompound lllllllllllllllIIlIIIIIlllIIIIll = new NBTTagCompound();
            if (!lllllllllllllllIIlIIIIIlllIIIlII.func_190926_b()) {
                lllllllllllllllIIlIIIIIlllIIIlII.writeToNBT(lllllllllllllllIIlIIIIIlllIIIIll);
            }
            lllllllllllllllIIlIIIIIlllIIIlIl.appendTag(lllllllllllllllIIlIIIIIlllIIIIll);
        }
        lllllllllllllllIIlIIIIIlllIIIllI.setTag("ArmorItems", lllllllllllllllIIlIIIIIlllIIIlIl);
        final NBTTagList lllllllllllllllIIlIIIIIlllIIIIlI = new NBTTagList();
        for (final ItemStack lllllllllllllllIIlIIIIIlllIIIIIl : this.inventoryHands) {
            final NBTTagCompound lllllllllllllllIIlIIIIIlllIIIIII = new NBTTagCompound();
            if (!lllllllllllllllIIlIIIIIlllIIIIIl.func_190926_b()) {
                lllllllllllllllIIlIIIIIlllIIIIIl.writeToNBT(lllllllllllllllIIlIIIIIlllIIIIII);
            }
            lllllllllllllllIIlIIIIIlllIIIIlI.appendTag(lllllllllllllllIIlIIIIIlllIIIIII);
        }
        lllllllllllllllIIlIIIIIlllIIIllI.setTag("HandItems", lllllllllllllllIIlIIIIIlllIIIIlI);
        final NBTTagList lllllllllllllllIIlIIIIIllIllllll = new NBTTagList();
        String lllllllllllllllIIlIIIIIllIllIIII;
        for (int length = (lllllllllllllllIIlIIIIIllIllIIII = (String)(Object)this.inventoryArmorDropChances).length, i = 0; i < length; ++i) {
            final float lllllllllllllllIIlIIIIIllIlllllI = lllllllllllllllIIlIIIIIllIllIIII[i];
            lllllllllllllllIIlIIIIIllIllllll.appendTag(new NBTTagFloat(lllllllllllllllIIlIIIIIllIlllllI));
        }
        lllllllllllllllIIlIIIIIlllIIIllI.setTag("ArmorDropChances", lllllllllllllllIIlIIIIIllIllllll);
        final NBTTagList lllllllllllllllIIlIIIIIllIllllIl = new NBTTagList();
        final short lllllllllllllllIIlIIIIIllIlIllll;
        lllllllllllllllIIlIIIIIllIllIIII = (String)((float[])(Object)(lllllllllllllllIIlIIIIIllIlIllll = (short)(Object)this.inventoryHandsDropChances)).length;
        for (final float lllllllllllllllIIlIIIIIllIllllII : lllllllllllllllIIlIIIIIllIlIllll) {
            lllllllllllllllIIlIIIIIllIllllIl.appendTag(new NBTTagFloat(lllllllllllllllIIlIIIIIllIllllII));
        }
        lllllllllllllllIIlIIIIIlllIIIllI.setTag("HandDropChances", lllllllllllllllIIlIIIIIllIllllIl);
        lllllllllllllllIIlIIIIIlllIIIllI.setBoolean("Leashed", this.isLeashed);
        if (this.leashedToEntity != null) {
            final NBTTagCompound lllllllllllllllIIlIIIIIllIlllIll = new NBTTagCompound();
            if (this.leashedToEntity instanceof EntityLivingBase) {
                final UUID lllllllllllllllIIlIIIIIllIlllIlI = this.leashedToEntity.getUniqueID();
                lllllllllllllllIIlIIIIIllIlllIll.setUniqueId("UUID", lllllllllllllllIIlIIIIIllIlllIlI);
            }
            else if (this.leashedToEntity instanceof EntityHanging) {
                final BlockPos lllllllllllllllIIlIIIIIllIlllIIl = ((EntityHanging)this.leashedToEntity).getHangingPosition();
                lllllllllllllllIIlIIIIIllIlllIll.setInteger("X", lllllllllllllllIIlIIIIIllIlllIIl.getX());
                lllllllllllllllIIlIIIIIllIlllIll.setInteger("Y", lllllllllllllllIIlIIIIIllIlllIIl.getY());
                lllllllllllllllIIlIIIIIllIlllIll.setInteger("Z", lllllllllllllllIIlIIIIIllIlllIIl.getZ());
            }
            lllllllllllllllIIlIIIIIlllIIIllI.setTag("Leash", lllllllllllllllIIlIIIIIllIlllIll);
        }
        lllllllllllllllIIlIIIIIlllIIIllI.setBoolean("LeftHanded", this.isLeftHanded());
        if (this.deathLootTable != null) {
            lllllllllllllllIIlIIIIIlllIIIllI.setString("DeathLootTable", this.deathLootTable.toString());
            if (this.deathLootTableSeed != 0L) {
                lllllllllllllllIIlIIIIIlllIIIllI.setLong("DeathLootTableSeed", this.deathLootTableSeed);
            }
        }
        if (this.isAIDisabled()) {
            lllllllllllllllIIlIIIIIlllIIIllI.setBoolean("NoAI", this.isAIDisabled());
        }
    }
    
    private void recreateLeash() {
        if (this.isLeashed && this.leashNBTTag != null) {
            if (this.leashNBTTag.hasUniqueId("UUID")) {
                final UUID lllllllllllllllIIlIIIIIIIIIIllll = this.leashNBTTag.getUniqueId("UUID");
                for (final EntityLivingBase lllllllllllllllIIlIIIIIIIIIIlllI : this.world.getEntitiesWithinAABB((Class<? extends Entity>)EntityLivingBase.class, this.getEntityBoundingBox().expandXyz(10.0))) {
                    if (lllllllllllllllIIlIIIIIIIIIIlllI.getUniqueID().equals(lllllllllllllllIIlIIIIIIIIIIllll)) {
                        this.setLeashedToEntity(lllllllllllllllIIlIIIIIIIIIIlllI, true);
                        break;
                    }
                }
            }
            else if (this.leashNBTTag.hasKey("X", 99) && this.leashNBTTag.hasKey("Y", 99) && this.leashNBTTag.hasKey("Z", 99)) {
                final BlockPos lllllllllllllllIIlIIIIIIIIIIllIl = new BlockPos(this.leashNBTTag.getInteger("X"), this.leashNBTTag.getInteger("Y"), this.leashNBTTag.getInteger("Z"));
                EntityLeashKnot lllllllllllllllIIlIIIIIIIIIIllII = EntityLeashKnot.getKnotForPosition(this.world, lllllllllllllllIIlIIIIIIIIIIllIl);
                if (lllllllllllllllIIlIIIIIIIIIIllII == null) {
                    lllllllllllllllIIlIIIIIIIIIIllII = EntityLeashKnot.createKnot(this.world, lllllllllllllllIIlIIIIIIIIIIllIl);
                }
                this.setLeashedToEntity(lllllllllllllllIIlIIIIIIIIIIllII, true);
            }
            else {
                this.clearLeashed(false, true);
            }
        }
        this.leashNBTTag = null;
    }
    
    @Nullable
    public IEntityLivingData onInitialSpawn(final DifficultyInstance lllllllllllllllIIlIIIIIIIllIlIll, @Nullable final IEntityLivingData lllllllllllllllIIlIIIIIIIllIlIlI) {
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).applyModifier(new AttributeModifier("Random spawn bonus", this.rand.nextGaussian() * 0.05, 1));
        if (this.rand.nextFloat() < 0.05f) {
            this.setLeftHanded(true);
        }
        else {
            this.setLeftHanded(false);
        }
        return lllllllllllllllIIlIIIIIIIllIlIlI;
    }
    
    @Override
    public ItemStack getItemStackFromSlot(final EntityEquipmentSlot lllllllllllllllIIlIIIIIIllIlIllI) {
        switch ($SWITCH_TABLE$net$minecraft$inventory$EntityEquipmentSlot$Type()[lllllllllllllllIIlIIIIIIllIlIllI.getSlotType().ordinal()]) {
            case 1: {
                return this.inventoryHands.get(lllllllllllllllIIlIIIIIIllIlIllI.getIndex());
            }
            case 2: {
                return this.inventoryArmor.get(lllllllllllllllIIlIIIIIIllIlIllI.getIndex());
            }
            default: {
                return ItemStack.field_190927_a;
            }
        }
    }
    
    public void eatGrassBonus() {
    }
    
    public static void registerFixesMob(final DataFixer lllllllllllllllIIlIIIIIlllIlIlIl, final Class<?> lllllllllllllllIIlIIIIIlllIlIIlI) {
        lllllllllllllllIIlIIIIIlllIlIlIl.registerWalker(FixTypes.ENTITY, new ItemStackDataLists(lllllllllllllllIIlIIIIIlllIlIIlI, new String[] { "ArmorItems", "HandItems" }));
    }
    
    @Override
    public void handleStatusUpdate(final byte lllllllllllllllIIlIIIIIllllllIlI) {
        if (lllllllllllllllIIlIIIIIllllllIlI == 20) {
            this.spawnExplosionParticle();
        }
        else {
            super.handleStatusUpdate(lllllllllllllllIIlIIIIIllllllIlI);
        }
    }
    
    public void clearLeashed(final boolean lllllllllllllllIIlIIIIIIIIlllIII, final boolean lllllllllllllllIIlIIIIIIIIllIlll) {
        if (this.isLeashed) {
            this.isLeashed = false;
            this.leashedToEntity = null;
            if (!this.world.isRemote && lllllllllllllllIIlIIIIIIIIllIlll) {
                this.dropItem(Items.LEAD, 1);
            }
            if (!this.world.isRemote && lllllllllllllllIIlIIIIIIIIlllIII && this.world instanceof WorldServer) {
                ((WorldServer)this.world).getEntityTracker().sendToAllTrackingEntity(this, new SPacketEntityAttach(this, null));
            }
        }
    }
    
    public boolean canBeSteered() {
        return false;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$inventory$EntityEquipmentSlot() {
        final int[] $switch_TABLE$net$minecraft$inventory$EntityEquipmentSlot = EntityLiving.$SWITCH_TABLE$net$minecraft$inventory$EntityEquipmentSlot;
        if ($switch_TABLE$net$minecraft$inventory$EntityEquipmentSlot != null) {
            return $switch_TABLE$net$minecraft$inventory$EntityEquipmentSlot;
        }
        final String lllllllllllllllIIIlllllllIlIlIll = (Object)new int[EntityEquipmentSlot.values().length];
        try {
            lllllllllllllllIIIlllllllIlIlIll[EntityEquipmentSlot.CHEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllllIIIlllllllIlIlIll[EntityEquipmentSlot.FEET.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllllIIIlllllllIlIlIll[EntityEquipmentSlot.HEAD.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllllIIIlllllllIlIlIll[EntityEquipmentSlot.LEGS.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllllllIIIlllllllIlIlIll[EntityEquipmentSlot.MAINHAND.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllllllIIIlllllllIlIlIll[EntityEquipmentSlot.OFFHAND.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return EntityLiving.$SWITCH_TABLE$net$minecraft$inventory$EntityEquipmentSlot = (int[])(Object)lllllllllllllllIIIlllllllIlIlIll;
    }
    
    protected void updateAITasks() {
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(EntityLiving.AI_FLAGS, (Byte)0);
    }
    
    @Override
    public void setItemStackToSlot(final EntityEquipmentSlot lllllllllllllllIIlIIIIIIllIIllll, final ItemStack lllllllllllllllIIlIIIIIIllIIlllI) {
        switch ($SWITCH_TABLE$net$minecraft$inventory$EntityEquipmentSlot$Type()[lllllllllllllllIIlIIIIIIllIIllll.getSlotType().ordinal()]) {
            case 1: {
                this.inventoryHands.set(lllllllllllllllIIlIIIIIIllIIllll.getIndex(), lllllllllllllllIIlIIIIIIllIIlllI);
                break;
            }
            case 2: {
                this.inventoryArmor.set(lllllllllllllllIIlIIIIIIllIIllll.getIndex(), lllllllllllllllIIlIIIIIIllIIlllI);
                break;
            }
        }
    }
    
    public void setMoveForward(final float lllllllllllllllIIlIIIIIlIllllIII) {
        this.moveForward = lllllllllllllllIIlIIIIIlIllllIII;
    }
    
    protected void updateLeashedState() {
        if (this.leashNBTTag != null) {
            this.recreateLeash();
        }
        if (this.isLeashed) {
            if (!this.isEntityAlive()) {
                this.clearLeashed(true, true);
            }
            if (this.leashedToEntity == null || this.leashedToEntity.isDead) {
                this.clearLeashed(true, true);
            }
        }
    }
    
    public boolean isNoDespawnRequired() {
        return this.persistenceRequired;
    }
    
    @Override
    public int getMaxFallHeight() {
        if (this.getAttackTarget() == null) {
            return 3;
        }
        int lllllllllllllllIIlIIIIIIlllIIIlI = (int)(this.getHealth() - this.getMaxHealth() * 0.33f);
        lllllllllllllllIIlIIIIIIlllIIIlI -= (3 - this.world.getDifficulty().getDifficultyId()) * 4;
        if (lllllllllllllllIIlIIIIIIlllIIIlI < 0) {
            lllllllllllllllIIlIIIIIIlllIIIlI = 0;
        }
        return lllllllllllllllIIlIIIIIIlllIIIlI + 3;
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(16.0);
    }
    
    protected PathNavigate getNewNavigator(final World lllllllllllllllIIlIIIIlIIllIIlIl) {
        return new PathNavigateGround(this, lllllllllllllllIIlIIIIlIIllIIlIl);
    }
    
    public void setCanPickUpLoot(final boolean lllllllllllllllIIlIIIIIIIlIlIIlI) {
        this.canPickUpLoot = lllllllllllllllIIlIIIIIIIlIlIIlI;
    }
    
    public int getHorizontalFaceSpeed() {
        return 10;
    }
    
    @Nullable
    public static Item getArmorByChance(final EntityEquipmentSlot lllllllllllllllIIlIIIIIIlIIIIlIl, final int lllllllllllllllIIlIIIIIIlIIIIllI) {
        switch ($SWITCH_TABLE$net$minecraft$inventory$EntityEquipmentSlot()[lllllllllllllllIIlIIIIIIlIIIIlIl.ordinal()]) {
            case 6: {
                if (lllllllllllllllIIlIIIIIIlIIIIllI == 0) {
                    return Items.LEATHER_HELMET;
                }
                if (lllllllllllllllIIlIIIIIIlIIIIllI == 1) {
                    return Items.GOLDEN_HELMET;
                }
                if (lllllllllllllllIIlIIIIIIlIIIIllI == 2) {
                    return Items.CHAINMAIL_HELMET;
                }
                if (lllllllllllllllIIlIIIIIIlIIIIllI == 3) {
                    return Items.IRON_HELMET;
                }
                if (lllllllllllllllIIlIIIIIIlIIIIllI == 4) {
                    return Items.DIAMOND_HELMET;
                }
            }
            case 5: {
                if (lllllllllllllllIIlIIIIIIlIIIIllI == 0) {
                    return Items.LEATHER_CHESTPLATE;
                }
                if (lllllllllllllllIIlIIIIIIlIIIIllI == 1) {
                    return Items.GOLDEN_CHESTPLATE;
                }
                if (lllllllllllllllIIlIIIIIIlIIIIllI == 2) {
                    return Items.CHAINMAIL_CHESTPLATE;
                }
                if (lllllllllllllllIIlIIIIIIlIIIIllI == 3) {
                    return Items.IRON_CHESTPLATE;
                }
                if (lllllllllllllllIIlIIIIIIlIIIIllI == 4) {
                    return Items.DIAMOND_CHESTPLATE;
                }
            }
            case 4: {
                if (lllllllllllllllIIlIIIIIIlIIIIllI == 0) {
                    return Items.LEATHER_LEGGINGS;
                }
                if (lllllllllllllllIIlIIIIIIlIIIIllI == 1) {
                    return Items.GOLDEN_LEGGINGS;
                }
                if (lllllllllllllllIIlIIIIIIlIIIIllI == 2) {
                    return Items.CHAINMAIL_LEGGINGS;
                }
                if (lllllllllllllllIIlIIIIIIlIIIIllI == 3) {
                    return Items.IRON_LEGGINGS;
                }
                if (lllllllllllllllIIlIIIIIIlIIIIllI == 4) {
                    return Items.DIAMOND_LEGGINGS;
                }
            }
            case 3: {
                if (lllllllllllllllIIlIIIIIIlIIIIllI == 0) {
                    return Items.LEATHER_BOOTS;
                }
                if (lllllllllllllllIIlIIIIIIlIIIIllI == 1) {
                    return Items.GOLDEN_BOOTS;
                }
                if (lllllllllllllllIIlIIIIIIlIIIIllI == 2) {
                    return Items.CHAINMAIL_BOOTS;
                }
                if (lllllllllllllllIIlIIIIIIlIIIIllI == 3) {
                    return Items.IRON_BOOTS;
                }
                if (lllllllllllllllIIlIIIIIIlIIIIllI == 4) {
                    return Items.DIAMOND_BOOTS;
                }
                break;
            }
        }
        return null;
    }
    
    @Override
    public boolean canPassengerSteer() {
        return this.canBeSteered() && super.canPassengerSteer();
    }
    
    @Override
    public boolean startRiding(final Entity lllllllllllllllIIlIIIIIIIIIlIlll, final boolean lllllllllllllllIIlIIIIIIIIIllIlI) {
        final boolean lllllllllllllllIIlIIIIIIIIIllIIl = super.startRiding(lllllllllllllllIIlIIIIIIIIIlIlll, lllllllllllllllIIlIIIIIIIIIllIlI);
        if (lllllllllllllllIIlIIIIIIIIIllIIl && this.getLeashed()) {
            this.clearLeashed(true, true);
        }
        return lllllllllllllllIIlIIIIIIIIIllIIl;
    }
    
    public void setAttackTarget(@Nullable final EntityLivingBase lllllllllllllllIIlIIIIlIIIlllIII) {
        this.attackTarget = lllllllllllllllIIlIIIIlIIIlllIII;
        Reflector.callVoid(Reflector.ForgeHooks_onLivingSetAttackTarget, this, lllllllllllllllIIlIIIIlIIIlllIII);
    }
    
    public boolean isAIDisabled() {
        return (this.dataManager.get(EntityLiving.AI_FLAGS) & 0x1) != 0x0;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$inventory$EntityEquipmentSlot$Type() {
        final int[] $switch_TABLE$net$minecraft$inventory$EntityEquipmentSlot$Type = EntityLiving.$SWITCH_TABLE$net$minecraft$inventory$EntityEquipmentSlot$Type;
        if ($switch_TABLE$net$minecraft$inventory$EntityEquipmentSlot$Type != null) {
            return $switch_TABLE$net$minecraft$inventory$EntityEquipmentSlot$Type;
        }
        final boolean lllllllllllllllIIIlllllllIlIllIl = (Object)new int[EntityEquipmentSlot.Type.values().length];
        try {
            lllllllllllllllIIIlllllllIlIllIl[EntityEquipmentSlot.Type.ARMOR.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllllIIIlllllllIlIllIl[EntityEquipmentSlot.Type.HAND.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        return EntityLiving.$SWITCH_TABLE$net$minecraft$inventory$EntityEquipmentSlot$Type = (int[])(Object)lllllllllllllllIIIlllllllIlIllIl;
    }
    
    @Override
    public void setAIMoveSpeed(final float lllllllllllllllIIlIIIIIlIllIlIlI) {
        super.setAIMoveSpeed(lllllllllllllllIIlIIIIIlIllIlIlI);
        this.func_191989_p(lllllllllllllllIIlIIIIIlIllIlIlI);
    }
    
    public void setMoveStrafing(final float lllllllllllllllIIlIIIIIlIlllIIlI) {
        this.moveStrafing = lllllllllllllllIIlIIIIIlIlllIIlI;
    }
    
    public int getMaxSpawnedInChunk() {
        return 4;
    }
    
    public void enablePersistence() {
        this.persistenceRequired = true;
    }
    
    protected void despawnEntity() {
        Object lllllllllllllllIIlIIIIIlIIllIlll = null;
        final Object lllllllllllllllIIlIIIIIlIIllIllI = Reflector.getFieldValue(Reflector.Event_Result_DEFAULT);
        final Object lllllllllllllllIIlIIIIIlIIllIlIl = Reflector.getFieldValue(Reflector.Event_Result_DENY);
        if (this.persistenceRequired) {
            this.entityAge = 0;
        }
        else if ((this.entityAge & 0x1F) == 0x1F && (lllllllllllllllIIlIIIIIlIIllIlll = Reflector.call(Reflector.ForgeEventFactory_canEntityDespawn, this)) != lllllllllllllllIIlIIIIIlIIllIllI) {
            if (lllllllllllllllIIlIIIIIlIIllIlll == lllllllllllllllIIlIIIIIlIIllIlIl) {
                this.entityAge = 0;
            }
            else {
                this.setDead();
            }
        }
        else {
            final Entity lllllllllllllllIIlIIIIIlIIllIlII = this.world.getClosestPlayerToEntity(this, -1.0);
            if (lllllllllllllllIIlIIIIIlIIllIlII != null) {
                final double lllllllllllllllIIlIIIIIlIIllIIll = lllllllllllllllIIlIIIIIlIIllIlII.posX - this.posX;
                final double lllllllllllllllIIlIIIIIlIIllIIlI = lllllllllllllllIIlIIIIIlIIllIlII.posY - this.posY;
                final double lllllllllllllllIIlIIIIIlIIllIIIl = lllllllllllllllIIlIIIIIlIIllIlII.posZ - this.posZ;
                final double lllllllllllllllIIlIIIIIlIIllIIII = lllllllllllllllIIlIIIIIlIIllIIll * lllllllllllllllIIlIIIIIlIIllIIll + lllllllllllllllIIlIIIIIlIIllIIlI * lllllllllllllllIIlIIIIIlIIllIIlI + lllllllllllllllIIlIIIIIlIIllIIIl * lllllllllllllllIIlIIIIIlIIllIIIl;
                if (this.canDespawn() && lllllllllllllllIIlIIIIIlIIllIIII > 16384.0) {
                    this.setDead();
                }
                if (this.entityAge > 600 && this.rand.nextInt(800) == 0 && lllllllllllllllIIlIIIIIlIIllIIII > 1024.0 && this.canDespawn()) {
                    this.setDead();
                }
                else if (lllllllllllllllIIlIIIIIlIIllIIII < 1024.0) {
                    this.entityAge = 0;
                }
            }
        }
    }
    
    public void spawnExplosionParticle() {
        if (this.world.isRemote) {
            for (int lllllllllllllllIIlIIIIlIIIIIlIlI = 0; lllllllllllllllIIlIIIIlIIIIIlIlI < 20; ++lllllllllllllllIIlIIIIlIIIIIlIlI) {
                final double lllllllllllllllIIlIIIIlIIIIIlIIl = this.rand.nextGaussian() * 0.02;
                final double lllllllllllllllIIlIIIIlIIIIIlIII = this.rand.nextGaussian() * 0.02;
                final double lllllllllllllllIIlIIIIlIIIIIIlll = this.rand.nextGaussian() * 0.02;
                final double lllllllllllllllIIlIIIIlIIIIIIllI = 10.0;
                this.world.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, this.posX + this.rand.nextFloat() * this.width * 2.0f - this.width - lllllllllllllllIIlIIIIlIIIIIlIIl * 10.0, this.posY + this.rand.nextFloat() * this.height - lllllllllllllllIIlIIIIlIIIIIlIII * 10.0, this.posZ + this.rand.nextFloat() * this.width * 2.0f - this.width - lllllllllllllllIIlIIIIlIIIIIIlll * 10.0, lllllllllllllllIIlIIIIlIIIIIlIIl, lllllllllllllllIIlIIIIlIIIIIlIII, lllllllllllllllIIlIIIIlIIIIIIlll, new int[0]);
            }
        }
        else {
            this.world.setEntityState(this, (byte)20);
        }
    }
    
    @Override
    protected final void updateEntityActionState() {
        ++this.entityAge;
        this.world.theProfiler.startSection("checkDespawn");
        this.despawnEntity();
        this.world.theProfiler.endSection();
        this.world.theProfiler.startSection("sensing");
        this.senses.clearSensingCache();
        this.world.theProfiler.endSection();
        this.world.theProfiler.startSection("targetSelector");
        this.targetTasks.onUpdateTasks();
        this.world.theProfiler.endSection();
        this.world.theProfiler.startSection("goalSelector");
        this.tasks.onUpdateTasks();
        this.world.theProfiler.endSection();
        this.world.theProfiler.startSection("navigation");
        this.navigator.onUpdateNavigation();
        this.world.theProfiler.endSection();
        this.world.theProfiler.startSection("mob tick");
        this.updateAITasks();
        this.world.theProfiler.endSection();
        if (this.isRiding() && this.getRidingEntity() instanceof EntityLiving) {
            final EntityLiving lllllllllllllllIIlIIIIIlIIlIIIll = (EntityLiving)this.getRidingEntity();
            lllllllllllllllIIlIIIIIlIIlIIIll.getNavigator().setPath(this.getNavigator().getPath(), 1.5);
            lllllllllllllllIIlIIIIIlIIlIIIll.getMoveHelper().read(this.getMoveHelper());
        }
        this.world.theProfiler.startSection("controls");
        this.world.theProfiler.startSection("move");
        this.moveHelper.onUpdateMoveHelper();
        this.world.theProfiler.endStartSection("look");
        this.lookHelper.onUpdateLook();
        this.world.theProfiler.endStartSection("jump");
        this.jumpHelper.doJump();
        this.world.theProfiler.endSection();
        this.world.theProfiler.endSection();
    }
    
    public void setNoAI(final boolean lllllllllllllllIIIlllllllllIIIII) {
        final byte lllllllllllllllIIIlllllllllIIIlI = this.dataManager.get(EntityLiving.AI_FLAGS);
        this.dataManager.set(EntityLiving.AI_FLAGS, lllllllllllllllIIIlllllllllIIIII ? ((byte)(lllllllllllllllIIIlllllllllIIIlI | 0x1)) : ((byte)(lllllllllllllllIIIlllllllllIIIlI & 0xFFFFFFFE)));
    }
    
    public boolean canBeLeashedTo(final EntityPlayer lllllllllllllllIIlIIIIIIIIllIIIl) {
        return !this.getLeashed() && !(this instanceof IMob);
    }
    
    @Override
    public Team getTeam() {
        final UUID lllllllllllllllIIIlllllllIllIIIl = this.getUniqueID();
        if (this.teamUuid != lllllllllllllllIIIlllllllIllIIIl) {
            this.teamUuid = lllllllllllllllIIIlllllllIllIIIl;
            this.teamUuidString = lllllllllllllllIIIlllllllIllIIIl.toString();
        }
        return this.world.getScoreboard().getPlayersTeam(this.teamUuidString);
    }
    
    public void faceEntity(final Entity lllllllllllllllIIlIIIIIlIIIlIIlI, final float lllllllllllllllIIlIIIIIlIIIIIlIl, final float lllllllllllllllIIlIIIIIlIIIIIlII) {
        final double lllllllllllllllIIlIIIIIlIIIIllll = lllllllllllllllIIlIIIIIlIIIlIIlI.posX - this.posX;
        final double lllllllllllllllIIlIIIIIlIIIIlllI = lllllllllllllllIIlIIIIIlIIIlIIlI.posZ - this.posZ;
        double lllllllllllllllIIlIIIIIlIIIIllII = 0.0;
        if (lllllllllllllllIIlIIIIIlIIIlIIlI instanceof EntityLivingBase) {
            final EntityLivingBase lllllllllllllllIIlIIIIIlIIIIlIll = (EntityLivingBase)lllllllllllllllIIlIIIIIlIIIlIIlI;
            final double lllllllllllllllIIlIIIIIlIIIIllIl = lllllllllllllllIIlIIIIIlIIIIlIll.posY + lllllllllllllllIIlIIIIIlIIIIlIll.getEyeHeight() - (this.posY + this.getEyeHeight());
        }
        else {
            lllllllllllllllIIlIIIIIlIIIIllII = (lllllllllllllllIIlIIIIIlIIIlIIlI.getEntityBoundingBox().minY + lllllllllllllllIIlIIIIIlIIIlIIlI.getEntityBoundingBox().maxY) / 2.0 - (this.posY + this.getEyeHeight());
        }
        final double lllllllllllllllIIlIIIIIlIIIIlIlI = MathHelper.sqrt(lllllllllllllllIIlIIIIIlIIIIllll * lllllllllllllllIIlIIIIIlIIIIllll + lllllllllllllllIIlIIIIIlIIIIlllI * lllllllllllllllIIlIIIIIlIIIIlllI);
        final float lllllllllllllllIIlIIIIIlIIIIlIIl = (float)(MathHelper.atan2(lllllllllllllllIIlIIIIIlIIIIlllI, lllllllllllllllIIlIIIIIlIIIIllll) * 57.29577951308232) - 90.0f;
        final float lllllllllllllllIIlIIIIIlIIIIlIII = (float)(-(MathHelper.atan2(lllllllllllllllIIlIIIIIlIIIIllII, lllllllllllllllIIlIIIIIlIIIIlIlI) * 57.29577951308232));
        this.rotationPitch = this.updateRotation(this.rotationPitch, lllllllllllllllIIlIIIIIlIIIIlIII, lllllllllllllllIIlIIIIIlIIIIIlII);
        this.rotationYaw = this.updateRotation(this.rotationYaw, lllllllllllllllIIlIIIIIlIIIIlIIl, lllllllllllllllIIlIIIIIlIIIIIlIl);
    }
    
    @Override
    public void onUpdate() {
        if (Config.isSmoothWorld() && this.canSkipUpdate()) {
            this.onUpdateMinimal();
        }
        else {
            super.onUpdate();
            if (!this.world.isRemote) {
                this.updateLeashedState();
                if (this.ticksExisted % 5 == 0) {
                    final boolean lllllllllllllllIIlIIIIIlllllIlIl = !(this.getControllingPassenger() instanceof EntityLiving);
                    final boolean lllllllllllllllIIlIIIIIlllllIlII = !(this.getRidingEntity() instanceof EntityBoat);
                    this.tasks.setControlFlag(1, lllllllllllllllIIlIIIIIlllllIlIl);
                    this.tasks.setControlFlag(4, lllllllllllllllIIlIIIIIlllllIlIl && lllllllllllllllIIlIIIIIlllllIlII);
                    this.tasks.setControlFlag(2, lllllllllllllllIIlIIIIIlllllIlIl);
                }
            }
        }
    }
    
    protected void setEnchantmentBasedOnDifficulty(final DifficultyInstance lllllllllllllllIIlIIIIIIIllllIlI) {
        final float lllllllllllllllIIlIIIIIIIllllIIl = lllllllllllllllIIlIIIIIIIllllIlI.getClampedAdditionalDifficulty();
        if (!this.getHeldItemMainhand().func_190926_b() && this.rand.nextFloat() < 0.25f * lllllllllllllllIIlIIIIIIIllllIIl) {
            this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, EnchantmentHelper.addRandomEnchantment(this.rand, this.getHeldItemMainhand(), (int)(5.0f + lllllllllllllllIIlIIIIIIIllllIIl * this.rand.nextInt(18)), false));
        }
        final int lllllllllllllllIIlIIIIIIIlllIIII;
        final int lllllllllllllllIIlIIIIIIIlllIIIl = ((EntityEquipmentSlot[])(Object)(lllllllllllllllIIlIIIIIIIlllIIII = (int)(Object)EntityEquipmentSlot.values())).length;
        for (double lllllllllllllllIIlIIIIIIIlllIIlI = 0; lllllllllllllllIIlIIIIIIIlllIIlI < lllllllllllllllIIlIIIIIIIlllIIIl; ++lllllllllllllllIIlIIIIIIIlllIIlI) {
            final EntityEquipmentSlot lllllllllllllllIIlIIIIIIIllllIII = lllllllllllllllIIlIIIIIIIlllIIII[lllllllllllllllIIlIIIIIIIlllIIlI];
            if (lllllllllllllllIIlIIIIIIIllllIII.getSlotType() == EntityEquipmentSlot.Type.ARMOR) {
                final ItemStack lllllllllllllllIIlIIIIIIIlllIlll = this.getItemStackFromSlot(lllllllllllllllIIlIIIIIIIllllIII);
                if (!lllllllllllllllIIlIIIIIIIlllIlll.func_190926_b() && this.rand.nextFloat() < 0.5f * lllllllllllllllIIlIIIIIIIllllIIl) {
                    this.setItemStackToSlot(lllllllllllllllIIlIIIIIIIllllIII, EnchantmentHelper.addRandomEnchantment(this.rand, lllllllllllllllIIlIIIIIIIlllIlll, (int)(5.0f + lllllllllllllllIIlIIIIIIIllllIIl * this.rand.nextInt(18)), false));
                }
            }
        }
    }
    
    protected EntityBodyHelper createBodyHelper() {
        return new EntityBodyHelper(this);
    }
    
    protected void setEquipmentBasedOnDifficulty(final DifficultyInstance lllllllllllllllIIlIIIIIIlIlIIIIl) {
        if (this.rand.nextFloat() < 0.15f * lllllllllllllllIIlIIIIIIlIlIIIIl.getClampedAdditionalDifficulty()) {
            int lllllllllllllllIIlIIIIIIlIlIIIII = this.rand.nextInt(2);
            final float lllllllllllllllIIlIIIIIIlIIlllll = (this.world.getDifficulty() == EnumDifficulty.HARD) ? 0.1f : 0.25f;
            if (this.rand.nextFloat() < 0.095f) {
                ++lllllllllllllllIIlIIIIIIlIlIIIII;
            }
            if (this.rand.nextFloat() < 0.095f) {
                ++lllllllllllllllIIlIIIIIIlIlIIIII;
            }
            if (this.rand.nextFloat() < 0.095f) {
                ++lllllllllllllllIIlIIIIIIlIlIIIII;
            }
            boolean lllllllllllllllIIlIIIIIIlIIllllI = true;
            final float lllllllllllllllIIlIIIIIIlIIlIIlI;
            final boolean lllllllllllllllIIlIIIIIIlIIlIIll = ((EntityEquipmentSlot[])(Object)(lllllllllllllllIIlIIIIIIlIIlIIlI = (float)(Object)EntityEquipmentSlot.values())).length != 0;
            for (double lllllllllllllllIIlIIIIIIlIIlIlII = 0; lllllllllllllllIIlIIIIIIlIIlIlII < (lllllllllllllllIIlIIIIIIlIIlIIll ? 1 : 0); ++lllllllllllllllIIlIIIIIIlIIlIlII) {
                final EntityEquipmentSlot lllllllllllllllIIlIIIIIIlIIlllIl = lllllllllllllllIIlIIIIIIlIIlIIlI[lllllllllllllllIIlIIIIIIlIIlIlII];
                if (lllllllllllllllIIlIIIIIIlIIlllIl.getSlotType() == EntityEquipmentSlot.Type.ARMOR) {
                    final ItemStack lllllllllllllllIIlIIIIIIlIIlllII = this.getItemStackFromSlot(lllllllllllllllIIlIIIIIIlIIlllIl);
                    if (!lllllllllllllllIIlIIIIIIlIIllllI && this.rand.nextFloat() < lllllllllllllllIIlIIIIIIlIIlllll) {
                        break;
                    }
                    lllllllllllllllIIlIIIIIIlIIllllI = false;
                    if (lllllllllllllllIIlIIIIIIlIIlllII.func_190926_b()) {
                        final Item lllllllllllllllIIlIIIIIIlIIllIll = getArmorByChance(lllllllllllllllIIlIIIIIIlIIlllIl, lllllllllllllllIIlIIIIIIlIlIIIII);
                        if (lllllllllllllllIIlIIIIIIlIIllIll != null) {
                            this.setItemStackToSlot(lllllllllllllllIIlIIIIIIlIIlllIl, new ItemStack(lllllllllllllllIIlIIIIIIlIIllIll));
                        }
                    }
                }
            }
        }
    }
    
    protected boolean processInteract(final EntityPlayer lllllllllllllllIIlIIIIIIIlIIIIIl, final EnumHand lllllllllllllllIIlIIIIIIIlIIIIII) {
        return false;
    }
    
    @Override
    public final boolean processInitialInteract(final EntityPlayer lllllllllllllllIIlIIIIIIIlIIlIIl, final EnumHand lllllllllllllllIIlIIIIIIIlIIIlII) {
        if (this.getLeashed() && this.getLeashedToEntity() == lllllllllllllllIIlIIIIIIIlIIlIIl) {
            this.clearLeashed(true, !lllllllllllllllIIlIIIIIIIlIIlIIl.capabilities.isCreativeMode);
            return true;
        }
        final ItemStack lllllllllllllllIIlIIIIIIIlIIIlll = lllllllllllllllIIlIIIIIIIlIIlIIl.getHeldItem(lllllllllllllllIIlIIIIIIIlIIIlII);
        if (lllllllllllllllIIlIIIIIIIlIIIlll.getItem() == Items.LEAD && this.canBeLeashedTo(lllllllllllllllIIlIIIIIIIlIIlIIl)) {
            this.setLeashedToEntity(lllllllllllllllIIlIIIIIIIlIIlIIl, true);
            lllllllllllllllIIlIIIIIIIlIIIlll.func_190918_g(1);
            return true;
        }
        return this.processInteract(lllllllllllllllIIlIIIIIIIlIIlIIl, lllllllllllllllIIlIIIIIIIlIIIlII) || super.processInitialInteract(lllllllllllllllIIlIIIIIIIlIIlIIl, lllllllllllllllIIlIIIIIIIlIIIlII);
    }
    
    public void func_191989_p(final float lllllllllllllllIIlIIIIIlIlllllII) {
        this.field_191988_bg = lllllllllllllllIIlIIIIIlIlllllII;
    }
    
    public static boolean isItemStackInSlot(final EntityEquipmentSlot lllllllllllllllIIIllllllllllIIII, final ItemStack lllllllllllllllIIIlllllllllIllll) {
        final EntityEquipmentSlot lllllllllllllllIIIlllllllllIlllI = getSlotForItemStack(lllllllllllllllIIIlllllllllIllll);
        return lllllllllllllllIIIlllllllllIlllI == lllllllllllllllIIIllllllllllIIII || (lllllllllllllllIIIlllllllllIlllI == EntityEquipmentSlot.MAINHAND && lllllllllllllllIIIllllllllllIIII == EntityEquipmentSlot.OFFHAND) || (lllllllllllllllIIIlllllllllIlllI == EntityEquipmentSlot.OFFHAND && lllllllllllllllIIIllllllllllIIII == EntityEquipmentSlot.MAINHAND);
    }
    
    public static EntityEquipmentSlot getSlotForItemStack(final ItemStack lllllllllllllllIIlIIIIIIlIIIlIll) {
        if (lllllllllllllllIIlIIIIIIlIIIlIll.getItem() == Item.getItemFromBlock(Blocks.PUMPKIN) || lllllllllllllllIIlIIIIIIlIIIlIll.getItem() == Items.SKULL) {
            return EntityEquipmentSlot.HEAD;
        }
        if (lllllllllllllllIIlIIIIIIlIIIlIll.getItem() instanceof ItemArmor) {
            return ((ItemArmor)lllllllllllllllIIlIIIIIIlIIIlIll.getItem()).armorType;
        }
        if (lllllllllllllllIIlIIIIIIlIIIlIll.getItem() == Items.ELYTRA) {
            return EntityEquipmentSlot.CHEST;
        }
        boolean lllllllllllllllIIlIIIIIIlIIIllII = lllllllllllllllIIlIIIIIIlIIIlIll.getItem() == Items.SHIELD;
        if (Reflector.ForgeItem_isShield.exists()) {
            lllllllllllllllIIlIIIIIIlIIIllII = Reflector.callBoolean(lllllllllllllllIIlIIIIIIlIIIlIll.getItem(), Reflector.ForgeItem_isShield, lllllllllllllllIIlIIIIIIlIIIlIll, null);
        }
        return lllllllllllllllIIlIIIIIIlIIIllII ? EntityEquipmentSlot.OFFHAND : EntityEquipmentSlot.MAINHAND;
    }
    
    public void setPathPriority(final PathNodeType lllllllllllllllIIlIIIIlIIlIlIlII, final float lllllllllllllllIIlIIIIlIIlIlIllI) {
        this.mapPathPriority.put(lllllllllllllllIIlIIIIlIIlIlIlII, lllllllllllllllIIlIIIIlIIlIlIllI);
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound lllllllllllllllIIlIIIIIllIIlllll) {
        super.readEntityFromNBT(lllllllllllllllIIlIIIIIllIIlllll);
        if (lllllllllllllllIIlIIIIIllIIlllll.hasKey("CanPickUpLoot", 1)) {
            this.setCanPickUpLoot(lllllllllllllllIIlIIIIIllIIlllll.getBoolean("CanPickUpLoot"));
        }
        this.persistenceRequired = lllllllllllllllIIlIIIIIllIIlllll.getBoolean("PersistenceRequired");
        if (lllllllllllllllIIlIIIIIllIIlllll.hasKey("ArmorItems", 9)) {
            final NBTTagList lllllllllllllllIIlIIIIIllIlIlIII = lllllllllllllllIIlIIIIIllIIlllll.getTagList("ArmorItems", 10);
            for (int lllllllllllllllIIlIIIIIllIlIIlll = 0; lllllllllllllllIIlIIIIIllIlIIlll < this.inventoryArmor.size(); ++lllllllllllllllIIlIIIIIllIlIIlll) {
                this.inventoryArmor.set(lllllllllllllllIIlIIIIIllIlIIlll, new ItemStack(lllllllllllllllIIlIIIIIllIlIlIII.getCompoundTagAt(lllllllllllllllIIlIIIIIllIlIIlll)));
            }
        }
        if (lllllllllllllllIIlIIIIIllIIlllll.hasKey("HandItems", 9)) {
            final NBTTagList lllllllllllllllIIlIIIIIllIlIIllI = lllllllllllllllIIlIIIIIllIIlllll.getTagList("HandItems", 10);
            for (int lllllllllllllllIIlIIIIIllIlIIlIl = 0; lllllllllllllllIIlIIIIIllIlIIlIl < this.inventoryHands.size(); ++lllllllllllllllIIlIIIIIllIlIIlIl) {
                this.inventoryHands.set(lllllllllllllllIIlIIIIIllIlIIlIl, new ItemStack(lllllllllllllllIIlIIIIIllIlIIllI.getCompoundTagAt(lllllllllllllllIIlIIIIIllIlIIlIl)));
            }
        }
        if (lllllllllllllllIIlIIIIIllIIlllll.hasKey("ArmorDropChances", 9)) {
            final NBTTagList lllllllllllllllIIlIIIIIllIlIIlII = lllllllllllllllIIlIIIIIllIIlllll.getTagList("ArmorDropChances", 5);
            for (int lllllllllllllllIIlIIIIIllIlIIIll = 0; lllllllllllllllIIlIIIIIllIlIIIll < lllllllllllllllIIlIIIIIllIlIIlII.tagCount(); ++lllllllllllllllIIlIIIIIllIlIIIll) {
                this.inventoryArmorDropChances[lllllllllllllllIIlIIIIIllIlIIIll] = lllllllllllllllIIlIIIIIllIlIIlII.getFloatAt(lllllllllllllllIIlIIIIIllIlIIIll);
            }
        }
        if (lllllllllllllllIIlIIIIIllIIlllll.hasKey("HandDropChances", 9)) {
            final NBTTagList lllllllllllllllIIlIIIIIllIlIIIlI = lllllllllllllllIIlIIIIIllIIlllll.getTagList("HandDropChances", 5);
            for (int lllllllllllllllIIlIIIIIllIlIIIIl = 0; lllllllllllllllIIlIIIIIllIlIIIIl < lllllllllllllllIIlIIIIIllIlIIIlI.tagCount(); ++lllllllllllllllIIlIIIIIllIlIIIIl) {
                this.inventoryHandsDropChances[lllllllllllllllIIlIIIIIllIlIIIIl] = lllllllllllllllIIlIIIIIllIlIIIlI.getFloatAt(lllllllllllllllIIlIIIIIllIlIIIIl);
            }
        }
        this.isLeashed = lllllllllllllllIIlIIIIIllIIlllll.getBoolean("Leashed");
        if (this.isLeashed && lllllllllllllllIIlIIIIIllIIlllll.hasKey("Leash", 10)) {
            this.leashNBTTag = lllllllllllllllIIlIIIIIllIIlllll.getCompoundTag("Leash");
        }
        this.setLeftHanded(lllllllllllllllIIlIIIIIllIIlllll.getBoolean("LeftHanded"));
        if (lllllllllllllllIIlIIIIIllIIlllll.hasKey("DeathLootTable", 8)) {
            this.deathLootTable = new ResourceLocation(lllllllllllllllIIlIIIIIllIIlllll.getString("DeathLootTable"));
            this.deathLootTableSeed = lllllllllllllllIIlIIIIIllIIlllll.getLong("DeathLootTableSeed");
        }
        this.setNoAI(lllllllllllllllIIlIIIIIllIIlllll.getBoolean("NoAI"));
    }
    
    @Override
    protected float updateDistance(final float lllllllllllllllIIlIIIIIllllIllIl, final float lllllllllllllllIIlIIIIIllllIlIlI) {
        this.bodyHelper.updateRenderAngles();
        return lllllllllllllllIIlIIIIIllllIlIlI;
    }
    
    public EntityLookHelper getLookHelper() {
        return this.lookHelper;
    }
    
    protected void initEntityAI() {
    }
    
    private boolean canSkipUpdate() {
        if (this.isChild()) {
            return false;
        }
        if (this.hurtTime > 0) {
            return false;
        }
        if (this.ticksExisted < 20) {
            return false;
        }
        final World lllllllllllllllIIIllllllllIIIlIl = this.getEntityWorld();
        if (lllllllllllllllIIIllllllllIIIlIl == null) {
            return false;
        }
        if (lllllllllllllllIIIllllllllIIIlIl.playerEntities.size() != 1) {
            return false;
        }
        final Entity lllllllllllllllIIIllllllllIIIlII = lllllllllllllllIIIllllllllIIIlIl.playerEntities.get(0);
        final double lllllllllllllllIIIllllllllIIIIll = Math.max(Math.abs(this.posX - lllllllllllllllIIIllllllllIIIlII.posX) - 16.0, 0.0);
        final double lllllllllllllllIIIllllllllIIIIlI = Math.max(Math.abs(this.posZ - lllllllllllllllIIIllllllllIIIlII.posZ) - 16.0, 0.0);
        final double lllllllllllllllIIIllllllllIIIIIl = lllllllllllllllIIIllllllllIIIIll * lllllllllllllllIIIllllllllIIIIll + lllllllllllllllIIIllllllllIIIIlI * lllllllllllllllIIIllllllllIIIIlI;
        return !this.isInRangeToRenderDist(lllllllllllllllIIIllllllllIIIIIl);
    }
    
    public int getVerticalFaceSpeed() {
        return 40;
    }
    
    public void setLeashedToEntity(final Entity lllllllllllllllIIlIIIIIIIIlIIIlI, final boolean lllllllllllllllIIlIIIIIIIIlIIIIl) {
        this.isLeashed = true;
        this.leashedToEntity = lllllllllllllllIIlIIIIIIIIlIIIlI;
        if (!this.world.isRemote && lllllllllllllllIIlIIIIIIIIlIIIIl && this.world instanceof WorldServer) {
            ((WorldServer)this.world).getEntityTracker().sendToAllTrackingEntity(this, new SPacketEntityAttach(this, this.leashedToEntity));
        }
        if (this.isRiding()) {
            this.dismountRidingEntity();
        }
    }
    
    @Override
    public boolean isServerWorld() {
        return super.isServerWorld() && !this.isAIDisabled();
    }
    
    public EntityJumpHelper getJumpHelper() {
        return this.jumpHelper;
    }
    
    public Entity getLeashedToEntity() {
        return this.leashedToEntity;
    }
    
    @Override
    protected void dropEquipment(final boolean lllllllllllllllIIlIIIIIIlIllIllI, final int lllllllllllllllIIlIIIIIIlIllIlIl) {
        final long lllllllllllllllIIlIIIIIIlIllIIIl;
        final int lllllllllllllllIIlIIIIIIlIllIIlI = ((EntityEquipmentSlot[])(Object)(lllllllllllllllIIlIIIIIIlIllIIIl = (long)(Object)EntityEquipmentSlot.values())).length;
        for (String lllllllllllllllIIlIIIIIIlIllIIll = (String)0; lllllllllllllllIIlIIIIIIlIllIIll < lllllllllllllllIIlIIIIIIlIllIIlI; ++lllllllllllllllIIlIIIIIIlIllIIll) {
            final EntityEquipmentSlot lllllllllllllllIIlIIIIIIlIllllIl = lllllllllllllllIIlIIIIIIlIllIIIl[lllllllllllllllIIlIIIIIIlIllIIll];
            final ItemStack lllllllllllllllIIlIIIIIIlIllllII = this.getItemStackFromSlot(lllllllllllllllIIlIIIIIIlIllllIl);
            final double lllllllllllllllIIlIIIIIIlIlllIIl;
            switch ($SWITCH_TABLE$net$minecraft$inventory$EntityEquipmentSlot$Type()[lllllllllllllllIIlIIIIIIlIllllIl.getSlotType().ordinal()]) {
                case 1: {
                    final double lllllllllllllllIIlIIIIIIlIlllIll = this.inventoryHandsDropChances[lllllllllllllllIIlIIIIIIlIllllIl.getIndex()];
                    break;
                }
                case 2: {
                    final double lllllllllllllllIIlIIIIIIlIlllIlI = this.inventoryArmorDropChances[lllllllllllllllIIlIIIIIIlIllllIl.getIndex()];
                    break;
                }
                default: {
                    lllllllllllllllIIlIIIIIIlIlllIIl = 0.0;
                    break;
                }
            }
            final boolean lllllllllllllllIIlIIIIIIlIlllIII = lllllllllllllllIIlIIIIIIlIlllIIl > 1.0;
            if (!lllllllllllllllIIlIIIIIIlIllllII.func_190926_b() && !EnchantmentHelper.func_190939_c(lllllllllllllllIIlIIIIIIlIllllII) && (lllllllllllllllIIlIIIIIIlIllIllI || lllllllllllllllIIlIIIIIIlIlllIII) && this.rand.nextFloat() - lllllllllllllllIIlIIIIIIlIllIlIl * 0.01f < lllllllllllllllIIlIIIIIIlIlllIIl) {
                if (!lllllllllllllllIIlIIIIIIlIlllIII && lllllllllllllllIIlIIIIIIlIllllII.isItemStackDamageable()) {
                    lllllllllllllllIIlIIIIIIlIllllII.setItemDamage(lllllllllllllllIIlIIIIIIlIllllII.getMaxDamage() - this.rand.nextInt(1 + this.rand.nextInt(Math.max(lllllllllllllllIIlIIIIIIlIllllII.getMaxDamage() - 3, 1))));
                }
                this.entityDropItem(lllllllllllllllIIlIIIIIIlIllllII, 0.0f);
            }
        }
    }
    
    @Override
    public boolean replaceItemInInventory(final int lllllllllllllllIIlIIIIIIIIIIIIlI, final ItemStack lllllllllllllllIIIlllllllllllIII) {
        EntityEquipmentSlot lllllllllllllllIIIlllllllllllIll = null;
        if (lllllllllllllllIIlIIIIIIIIIIIIlI == 98) {
            final EntityEquipmentSlot lllllllllllllllIIlIIIIIIIIIIIIII = EntityEquipmentSlot.MAINHAND;
        }
        else if (lllllllllllllllIIlIIIIIIIIIIIIlI == 99) {
            final EntityEquipmentSlot lllllllllllllllIIIllllllllllllll = EntityEquipmentSlot.OFFHAND;
        }
        else if (lllllllllllllllIIlIIIIIIIIIIIIlI == 100 + EntityEquipmentSlot.HEAD.getIndex()) {
            final EntityEquipmentSlot lllllllllllllllIIIlllllllllllllI = EntityEquipmentSlot.HEAD;
        }
        else if (lllllllllllllllIIlIIIIIIIIIIIIlI == 100 + EntityEquipmentSlot.CHEST.getIndex()) {
            final EntityEquipmentSlot lllllllllllllllIIIllllllllllllIl = EntityEquipmentSlot.CHEST;
        }
        else if (lllllllllllllllIIlIIIIIIIIIIIIlI == 100 + EntityEquipmentSlot.LEGS.getIndex()) {
            final EntityEquipmentSlot lllllllllllllllIIIllllllllllllII = EntityEquipmentSlot.LEGS;
        }
        else {
            if (lllllllllllllllIIlIIIIIIIIIIIIlI != 100 + EntityEquipmentSlot.FEET.getIndex()) {
                return false;
            }
            lllllllllllllllIIIlllllllllllIll = EntityEquipmentSlot.FEET;
        }
        if (!lllllllllllllllIIIlllllllllllIII.func_190926_b() && !isItemStackInSlot(lllllllllllllllIIIlllllllllllIll, lllllllllllllllIIIlllllllllllIII) && lllllllllllllllIIIlllllllllllIll != EntityEquipmentSlot.HEAD) {
            return false;
        }
        this.setItemStackToSlot(lllllllllllllllIIIlllllllllllIll, lllllllllllllllIIIlllllllllllIII);
        return true;
    }
    
    @Nullable
    protected Item getDropItem() {
        return null;
    }
    
    @Override
    public EnumHandSide getPrimaryHand() {
        return this.isLeftHanded() ? EnumHandSide.LEFT : EnumHandSide.RIGHT;
    }
    
    private float updateRotation(final float lllllllllllllllIIlIIIIIIllllIlII, final float lllllllllllllllIIlIIIIIIllllIIll, final float lllllllllllllllIIlIIIIIIllllIIlI) {
        float lllllllllllllllIIlIIIIIIllllIlIl = MathHelper.wrapDegrees(lllllllllllllllIIlIIIIIIllllIIll - lllllllllllllllIIlIIIIIIllllIlII);
        if (lllllllllllllllIIlIIIIIIllllIlIl > lllllllllllllllIIlIIIIIIllllIIlI) {
            lllllllllllllllIIlIIIIIIllllIlIl = lllllllllllllllIIlIIIIIIllllIIlI;
        }
        if (lllllllllllllllIIlIIIIIIllllIlIl < -lllllllllllllllIIlIIIIIIllllIIlI) {
            lllllllllllllllIIlIIIIIIllllIlIl = -lllllllllllllllIIlIIIIIIllllIIlI;
        }
        return lllllllllllllllIIlIIIIIIllllIlII + lllllllllllllllIIlIIIIIIllllIlIl;
    }
    
    @Override
    public Iterable<ItemStack> getHeldEquipment() {
        return this.inventoryHands;
    }
    
    @Nullable
    protected SoundEvent getAmbientSound() {
        return null;
    }
    
    public enum SpawnPlacementType
    {
        IN_WATER("IN_WATER", 2), 
        ON_GROUND("ON_GROUND", 0), 
        IN_AIR("IN_AIR", 1);
        
        private SpawnPlacementType(final String lllllllllllllIIIllIllIllllllIlII, final int lllllllllllllIIIllIllIllllllIIll) {
        }
    }
}
