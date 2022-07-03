package net.minecraft.entity.passive;

import javax.annotation.*;
import net.minecraft.inventory.*;
import net.minecraft.village.*;
import net.minecraft.entity.player.*;
import net.minecraft.advancements.*;
import net.minecraft.util.text.*;
import net.minecraft.scoreboard.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.item.*;
import net.minecraft.potion.*;
import net.minecraft.world.*;
import net.minecraft.world.storage.loot.*;
import net.minecraft.stats.*;
import net.minecraft.entity.effect.*;
import net.minecraft.entity.monster.*;
import net.minecraft.pathfinding.*;
import org.apache.logging.log4j.*;
import net.minecraft.network.datasync.*;
import net.minecraft.init.*;
import net.minecraft.util.datafix.walkers.*;
import net.minecraft.entity.*;
import net.minecraft.util.datafix.*;
import net.minecraft.nbt.*;
import net.minecraft.util.math.*;
import net.minecraft.util.*;
import net.minecraft.enchantment.*;
import net.minecraft.item.*;
import net.minecraft.world.storage.*;
import java.util.*;

public class EntityVillager extends EntityAgeable implements IMerchant, INpc
{
    private static final /* synthetic */ Logger field_190674_bx;
    private /* synthetic */ int timeUntilReset;
    private /* synthetic */ int careerLevel;
    private static final /* synthetic */ DataParameter<Integer> PROFESSION;
    private /* synthetic */ int randomTickDivider;
    @Nullable
    private /* synthetic */ MerchantRecipeList buyingList;
    /* synthetic */ Village villageObj;
    private /* synthetic */ boolean isMating;
    private final /* synthetic */ InventoryBasic villagerInventory;
    private /* synthetic */ boolean areAdditionalTasksSet;
    private /* synthetic */ String lastBuyingPlayer;
    private /* synthetic */ boolean needsInitilization;
    private static final /* synthetic */ ITradeList[][][][] DEFAULT_TRADE_LIST_MAP;
    private /* synthetic */ boolean isWillingToMate;
    private /* synthetic */ int wealth;
    private /* synthetic */ int careerId;
    @Nullable
    private /* synthetic */ EntityPlayer buyingPlayer;
    private /* synthetic */ boolean isPlaying;
    private /* synthetic */ boolean isLookingForHome;
    
    @Nullable
    @Override
    public EntityPlayer getCustomer() {
        return this.buyingPlayer;
    }
    
    @Override
    public boolean canBeLeashedTo(final EntityPlayer lllllllllllllllIlIIllllIIlIlIlII) {
        return false;
    }
    
    public boolean isTrading() {
        return this.buyingPlayer != null;
    }
    
    public boolean isFarmItemInInventory() {
        for (int lllllllllllllllIlIIllllIIIIlIlll = 0; lllllllllllllllIlIIllllIIIIlIlll < this.villagerInventory.getSizeInventory(); ++lllllllllllllllIlIIllllIIIIlIlll) {
            final ItemStack lllllllllllllllIlIIllllIIIIlIllI = this.villagerInventory.getStackInSlot(lllllllllllllllIlIIllllIIIIlIlll);
            if (!lllllllllllllllIlIIllllIIIIlIllI.func_190926_b() && (lllllllllllllllIlIIllllIIIIlIllI.getItem() == Items.WHEAT_SEEDS || lllllllllllllllIlIIllllIIIIlIllI.getItem() == Items.POTATO || lllllllllllllllIlIIllllIIIIlIllI.getItem() == Items.CARROT || lllllllllllllllIlIIllllIIIIlIllI.getItem() == Items.BEETROOT_SEEDS)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    protected SoundEvent getAmbientSound() {
        return this.isTrading() ? SoundEvents.ENTITY_VILLAGER_TRADING : SoundEvents.ENTITY_VILLAGER_AMBIENT;
    }
    
    public boolean canAbondonItems() {
        return this.hasEnoughItems(2);
    }
    
    @Override
    public void setRevengeTarget(@Nullable final EntityLivingBase lllllllllllllllIlIIlllllIIIIIlII) {
        super.setRevengeTarget(lllllllllllllllIlIIlllllIIIIIlII);
        if (this.villageObj != null && lllllllllllllllIlIIlllllIIIIIlII != null) {
            this.villageObj.addOrRenewAgressor(lllllllllllllllIlIIlllllIIIIIlII);
            if (lllllllllllllllIlIIlllllIIIIIlII instanceof EntityPlayer) {
                int lllllllllllllllIlIIlllllIIIIIllI = -1;
                if (this.isChild()) {
                    lllllllllllllllIlIIlllllIIIIIllI = -3;
                }
                this.villageObj.modifyPlayerReputation(lllllllllllllllIlIIlllllIIIIIlII.getName(), lllllllllllllllIlIIlllllIIIIIllI);
                if (this.isEntityAlive()) {
                    this.world.setEntityState(this, (byte)13);
                }
            }
        }
    }
    
    @Override
    public EntityVillager createChild(final EntityAgeable lllllllllllllllIlIIllllIIlIllIIl) {
        final EntityVillager lllllllllllllllIlIIllllIIlIllIII = new EntityVillager(this.world);
        lllllllllllllllIlIIllllIIlIllIII.onInitialSpawn(this.world.getDifficultyForLocation(new BlockPos(lllllllllllllllIlIIllllIIlIllIII)), null);
        return lllllllllllllllIlIIllllIIlIllIII;
    }
    
    @Override
    public void handleStatusUpdate(final byte lllllllllllllllIlIIllllIlIIIlIIl) {
        if (lllllllllllllllIlIIllllIlIIIlIIl == 12) {
            this.spawnParticles(EnumParticleTypes.HEART);
        }
        else if (lllllllllllllllIlIIllllIlIIIlIIl == 13) {
            this.spawnParticles(EnumParticleTypes.VILLAGER_ANGRY);
        }
        else if (lllllllllllllllIlIIllllIlIIIlIIl == 14) {
            this.spawnParticles(EnumParticleTypes.VILLAGER_HAPPY);
        }
        else {
            super.handleStatusUpdate(lllllllllllllllIlIIllllIlIIIlIIl);
        }
    }
    
    private boolean hasEnoughItems(final int lllllllllllllllIlIIllllIIIlIIlII) {
        final boolean lllllllllllllllIlIIllllIIIlIIIll = this.getProfession() == 0;
        for (int lllllllllllllllIlIIllllIIIlIIIlI = 0; lllllllllllllllIlIIllllIIIlIIIlI < this.villagerInventory.getSizeInventory(); ++lllllllllllllllIlIIllllIIIlIIIlI) {
            final ItemStack lllllllllllllllIlIIllllIIIlIIIIl = this.villagerInventory.getStackInSlot(lllllllllllllllIlIIllllIIIlIIIlI);
            if (!lllllllllllllllIlIIllllIIIlIIIIl.func_190926_b()) {
                if ((lllllllllllllllIlIIllllIIIlIIIIl.getItem() == Items.BREAD && lllllllllllllllIlIIllllIIIlIIIIl.func_190916_E() >= 3 * lllllllllllllllIlIIllllIIIlIIlII) || (lllllllllllllllIlIIllllIIIlIIIIl.getItem() == Items.POTATO && lllllllllllllllIlIIllllIIIlIIIIl.func_190916_E() >= 12 * lllllllllllllllIlIIllllIIIlIIlII) || (lllllllllllllllIlIIllllIIIlIIIIl.getItem() == Items.CARROT && lllllllllllllllIlIIllllIIIlIIIIl.func_190916_E() >= 12 * lllllllllllllllIlIIllllIIIlIIlII) || (lllllllllllllllIlIIllllIIIlIIIIl.getItem() == Items.BEETROOT && lllllllllllllllIlIIllllIIIlIIIIl.func_190916_E() >= 12 * lllllllllllllllIlIIllllIIIlIIlII)) {
                    return true;
                }
                if (lllllllllllllllIlIIllllIIIlIIIll && lllllllllllllllIlIIllllIIIlIIIIl.getItem() == Items.WHEAT && lllllllllllllllIlIIllllIIIlIIIIl.func_190916_E() >= 9 * lllllllllllllllIlIIllllIIIlIIlII) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public EntityVillager(final World lllllllllllllllIlIIlllllllIIIIlI) {
        this(lllllllllllllllIlIIlllllllIIIIlI, 0);
    }
    
    @Override
    public void useRecipe(final MerchantRecipe lllllllllllllllIlIIllllIllIIlllI) {
        lllllllllllllllIlIIllllIllIIlllI.incrementToolUses();
        this.livingSoundTime = -this.getTalkInterval();
        this.playSound(SoundEvents.ENTITY_VILLAGER_YES, this.getSoundVolume(), this.getSoundPitch());
        int lllllllllllllllIlIIllllIllIlIIII = 3 + this.rand.nextInt(4);
        if (lllllllllllllllIlIIllllIllIIlllI.getToolUses() == 1 || this.rand.nextInt(5) == 0) {
            this.timeUntilReset = 40;
            this.needsInitilization = true;
            this.isWillingToMate = true;
            if (this.buyingPlayer != null) {
                this.lastBuyingPlayer = this.buyingPlayer.getName();
            }
            else {
                this.lastBuyingPlayer = null;
            }
            lllllllllllllllIlIIllllIllIlIIII += 5;
        }
        if (lllllllllllllllIlIIllllIllIIlllI.getItemToBuy().getItem() == Items.EMERALD) {
            this.wealth += lllllllllllllllIlIIllllIllIIlllI.getItemToBuy().func_190916_E();
        }
        if (lllllllllllllllIlIIllllIllIIlllI.getRewardsExp()) {
            this.world.spawnEntityInWorld(new EntityXPOrb(this.world, this.posX, this.posY + 0.5, this.posZ, lllllllllllllllIlIIllllIllIlIIII));
        }
        if (this.buyingPlayer instanceof EntityPlayerMP) {
            CriteriaTriggers.field_192138_r.func_192234_a((EntityPlayerMP)this.buyingPlayer, this, lllllllllllllllIlIIllllIllIIlllI.getItemToSell());
        }
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5);
    }
    
    @Override
    public ITextComponent getDisplayName() {
        final Team lllllllllllllllIlIIllllIlIIllIIl = this.getTeam();
        final String lllllllllllllllIlIIllllIlIIllIII = this.getCustomNameTag();
        if (lllllllllllllllIlIIllllIlIIllIII != null && !lllllllllllllllIlIIllllIlIIllIII.isEmpty()) {
            final TextComponentString lllllllllllllllIlIIllllIlIIlIlll = new TextComponentString(ScorePlayerTeam.formatPlayerName(lllllllllllllllIlIIllllIlIIllIIl, lllllllllllllllIlIIllllIlIIllIII));
            lllllllllllllllIlIIllllIlIIlIlll.getStyle().setHoverEvent(this.getHoverEvent());
            lllllllllllllllIlIIllllIlIIlIlll.getStyle().setInsertion(this.getCachedUniqueIdString());
            return lllllllllllllllIlIIllllIlIIlIlll;
        }
        if (this.buyingList == null) {
            this.populateBuyingList();
        }
        String lllllllllllllllIlIIllllIlIIlIllI = null;
        switch (this.getProfession()) {
            case 0: {
                if (this.careerId == 1) {
                    lllllllllllllllIlIIllllIlIIlIllI = "farmer";
                    break;
                }
                if (this.careerId == 2) {
                    lllllllllllllllIlIIllllIlIIlIllI = "fisherman";
                    break;
                }
                if (this.careerId == 3) {
                    lllllllllllllllIlIIllllIlIIlIllI = "shepherd";
                    break;
                }
                if (this.careerId == 4) {
                    lllllllllllllllIlIIllllIlIIlIllI = "fletcher";
                    break;
                }
                break;
            }
            case 1: {
                if (this.careerId == 1) {
                    lllllllllllllllIlIIllllIlIIlIllI = "librarian";
                    break;
                }
                if (this.careerId == 2) {
                    lllllllllllllllIlIIllllIlIIlIllI = "cartographer";
                    break;
                }
                break;
            }
            case 2: {
                lllllllllllllllIlIIllllIlIIlIllI = "cleric";
                break;
            }
            case 3: {
                if (this.careerId == 1) {
                    lllllllllllllllIlIIllllIlIIlIllI = "armor";
                    break;
                }
                if (this.careerId == 2) {
                    lllllllllllllllIlIIllllIlIIlIllI = "weapon";
                    break;
                }
                if (this.careerId == 3) {
                    lllllllllllllllIlIIllllIlIIlIllI = "tool";
                    break;
                }
                break;
            }
            case 4: {
                if (this.careerId == 1) {
                    lllllllllllllllIlIIllllIlIIlIllI = "butcher";
                    break;
                }
                if (this.careerId == 2) {
                    lllllllllllllllIlIIllllIlIIlIllI = "leather";
                    break;
                }
                break;
            }
            case 5: {
                lllllllllllllllIlIIllllIlIIlIllI = "nitwit";
                break;
            }
        }
        if (lllllllllllllllIlIIllllIlIIlIllI != null) {
            final ITextComponent lllllllllllllllIlIIllllIlIIlIlIl = new TextComponentTranslation(String.valueOf(new StringBuilder("entity.Villager.").append(lllllllllllllllIlIIllllIlIIlIllI)), new Object[0]);
            lllllllllllllllIlIIllllIlIIlIlIl.getStyle().setHoverEvent(this.getHoverEvent());
            lllllllllllllllIlIIllllIlIIlIlIl.getStyle().setInsertion(this.getCachedUniqueIdString());
            if (lllllllllllllllIlIIllllIlIIllIIl != null) {
                lllllllllllllllIlIIllllIlIIlIlIl.getStyle().setColor(lllllllllllllllIlIIllllIlIIllIIl.getChatFormat());
            }
            return lllllllllllllllIlIIllllIlIIlIlIl;
        }
        return super.getDisplayName();
    }
    
    @Override
    public World func_190670_t_() {
        return this.world;
    }
    
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_VILLAGER_DEATH;
    }
    
    @Override
    protected void initEntityAI() {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIAvoidEntity<Object>(this, EntityZombie.class, 8.0f, 0.6, 0.6));
        this.tasks.addTask(1, new EntityAIAvoidEntity<Object>(this, EntityEvoker.class, 12.0f, 0.8, 0.8));
        this.tasks.addTask(1, new EntityAIAvoidEntity<Object>(this, EntityVindicator.class, 8.0f, 0.8, 0.8));
        this.tasks.addTask(1, new EntityAIAvoidEntity<Object>(this, EntityVex.class, 8.0f, 0.6, 0.6));
        this.tasks.addTask(1, new EntityAITradePlayer(this));
        this.tasks.addTask(1, new EntityAILookAtTradePlayer(this));
        this.tasks.addTask(2, new EntityAIMoveIndoors(this));
        this.tasks.addTask(3, new EntityAIRestrictOpenDoor(this));
        this.tasks.addTask(4, new EntityAIOpenDoor(this, true));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 0.6));
        this.tasks.addTask(6, new EntityAIVillagerMate(this));
        this.tasks.addTask(7, new EntityAIFollowGolem(this));
        this.tasks.addTask(9, new EntityAIWatchClosest2(this, EntityPlayer.class, 3.0f, 1.0f));
        this.tasks.addTask(9, new EntityAIVillagerInteract(this));
        this.tasks.addTask(9, new EntityAIWanderAvoidWater(this, 0.6));
        this.tasks.addTask(10, new EntityAIWatchClosest(this, EntityLiving.class, 8.0f));
    }
    
    private void setAdditionalAItasks() {
        if (!this.areAdditionalTasksSet) {
            this.areAdditionalTasksSet = true;
            if (this.isChild()) {
                this.tasks.addTask(8, new EntityAIPlay(this, 0.32));
            }
            else if (this.getProfession() == 0) {
                this.tasks.addTask(6, new EntityAIHarvestFarmland(this, 0.6));
            }
        }
    }
    
    @Override
    protected void updateEquipmentIfNeeded(final EntityItem lllllllllllllllIlIIllllIIIlllllI) {
        final ItemStack lllllllllllllllIlIIllllIIlIIIIlI = lllllllllllllllIlIIllllIIIlllllI.getEntityItem();
        final Item lllllllllllllllIlIIllllIIlIIIIIl = lllllllllllllllIlIIllllIIlIIIIlI.getItem();
        if (this.canVillagerPickupItem(lllllllllllllllIlIIllllIIlIIIIIl)) {
            final ItemStack lllllllllllllllIlIIllllIIlIIIIII = this.villagerInventory.addItem(lllllllllllllllIlIIllllIIlIIIIlI);
            if (lllllllllllllllIlIIllllIIlIIIIII.func_190926_b()) {
                lllllllllllllllIlIIllllIIIlllllI.setDead();
            }
            else {
                lllllllllllllllIlIIllllIIlIIIIlI.func_190920_e(lllllllllllllllIlIIllllIIlIIIIII.func_190916_E());
            }
        }
    }
    
    private void spawnParticles(final EnumParticleTypes lllllllllllllllIlIIllllIIlllllll) {
        for (int lllllllllllllllIlIIllllIIllllllI = 0; lllllllllllllllIlIIllllIIllllllI < 5; ++lllllllllllllllIlIIllllIIllllllI) {
            final double lllllllllllllllIlIIllllIIlllllIl = this.rand.nextGaussian() * 0.02;
            final double lllllllllllllllIlIIllllIIlllllII = this.rand.nextGaussian() * 0.02;
            final double lllllllllllllllIlIIllllIIllllIll = this.rand.nextGaussian() * 0.02;
            this.world.spawnParticle(lllllllllllllllIlIIllllIIlllllll, this.posX + this.rand.nextFloat() * this.width * 2.0f - this.width, this.posY + 1.0 + this.rand.nextFloat() * this.height, this.posZ + this.rand.nextFloat() * this.width * 2.0f - this.width, lllllllllllllllIlIIllllIIlllllIl, lllllllllllllllIlIIllllIIlllllII, lllllllllllllllIlIIllllIIllllIll, new int[0]);
        }
    }
    
    @Override
    public void setCustomer(@Nullable final EntityPlayer lllllllllllllllIlIIllllIllllIIll) {
        this.buyingPlayer = lllllllllllllllIlIIllllIllllIIll;
    }
    
    public boolean wantsMoreFood() {
        final boolean lllllllllllllllIlIIllllIIIlIllIl = this.getProfession() == 0;
        if (lllllllllllllllIlIIllllIIIlIllIl) {
            return !this.hasEnoughItems(5);
        }
        return !this.hasEnoughItems(1);
    }
    
    public void setMating(final boolean lllllllllllllllIlIIlllllIIIlIlll) {
        this.isMating = lllllllllllllllIlIIlllllIIIlIlll;
    }
    
    public boolean isMating() {
        return this.isMating;
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(EntityVillager.PROFESSION, 0);
    }
    
    @Override
    protected void updateAITasks() {
        final int randomTickDivider = this.randomTickDivider - 1;
        this.randomTickDivider = randomTickDivider;
        if (randomTickDivider <= 0) {
            final BlockPos lllllllllllllllIlIIllllllIlIIllI = new BlockPos(this);
            this.world.getVillageCollection().addToVillagerPositionList(lllllllllllllllIlIIllllllIlIIllI);
            this.randomTickDivider = 70 + this.rand.nextInt(50);
            this.villageObj = this.world.getVillageCollection().getNearestVillage(lllllllllllllllIlIIllllllIlIIllI, 32);
            if (this.villageObj == null) {
                this.detachHome();
            }
            else {
                final BlockPos lllllllllllllllIlIIllllllIlIIlIl = this.villageObj.getCenter();
                this.setHomePosAndDistance(lllllllllllllllIlIIllllllIlIIlIl, this.villageObj.getVillageRadius());
                if (this.isLookingForHome) {
                    this.isLookingForHome = false;
                    this.villageObj.setDefaultPlayerReputation(5);
                }
            }
        }
        if (!this.isTrading() && this.timeUntilReset > 0) {
            --this.timeUntilReset;
            if (this.timeUntilReset <= 0) {
                if (this.needsInitilization) {
                    for (final MerchantRecipe lllllllllllllllIlIIllllllIlIIlII : this.buyingList) {
                        if (lllllllllllllllIlIIllllllIlIIlII.isRecipeDisabled()) {
                            lllllllllllllllIlIIllllllIlIIlII.increaseMaxTradeUses(this.rand.nextInt(6) + this.rand.nextInt(6) + 2);
                        }
                    }
                    this.populateBuyingList();
                    this.needsInitilization = false;
                    if (this.villageObj != null && this.lastBuyingPlayer != null) {
                        this.world.setEntityState(this, (byte)14);
                        this.villageObj.modifyPlayerReputation(this.lastBuyingPlayer, 1);
                    }
                }
                this.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 200, 0));
            }
        }
        super.updateAITasks();
    }
    
    public void setIsWillingToMate(final boolean lllllllllllllllIlIIllllIllIllIII) {
        this.isWillingToMate = lllllllllllllllIlIIllllIllIllIII;
    }
    
    @Nullable
    @Override
    public IEntityLivingData onInitialSpawn(final DifficultyInstance lllllllllllllllIlIIllllIIllIllIl, @Nullable final IEntityLivingData lllllllllllllllIlIIllllIIllIllII) {
        return this.func_190672_a(lllllllllllllllIlIIllllIIllIllIl, lllllllllllllllIlIIllllIIllIllII, true);
    }
    
    @Override
    public BlockPos func_190671_u_() {
        return new BlockPos(this);
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound lllllllllllllllIlIIlllllIIlllllI) {
        super.readEntityFromNBT(lllllllllllllllIlIIlllllIIlllllI);
        this.setProfession(lllllllllllllllIlIIlllllIIlllllI.getInteger("Profession"));
        this.wealth = lllllllllllllllIlIIlllllIIlllllI.getInteger("Riches");
        this.careerId = lllllllllllllllIlIIlllllIIlllllI.getInteger("Career");
        this.careerLevel = lllllllllllllllIlIIlllllIIlllllI.getInteger("CareerLevel");
        this.isWillingToMate = lllllllllllllllIlIIlllllIIlllllI.getBoolean("Willing");
        if (lllllllllllllllIlIIlllllIIlllllI.hasKey("Offers", 10)) {
            final NBTTagCompound lllllllllllllllIlIIlllllIIllllII = lllllllllllllllIlIIlllllIIlllllI.getCompoundTag("Offers");
            this.buyingList = new MerchantRecipeList(lllllllllllllllIlIIlllllIIllllII);
        }
        final NBTTagList lllllllllllllllIlIIlllllIIlllIlI = lllllllllllllllIlIIlllllIIlllllI.getTagList("Inventory", 10);
        for (int lllllllllllllllIlIIlllllIIlllIIl = 0; lllllllllllllllIlIIlllllIIlllIIl < lllllllllllllllIlIIlllllIIlllIlI.tagCount(); ++lllllllllllllllIlIIlllllIIlllIIl) {
            final ItemStack lllllllllllllllIlIIlllllIIlllIII = new ItemStack(lllllllllllllllIlIIlllllIIlllIlI.getCompoundTagAt(lllllllllllllllIlIIlllllIIlllIIl));
            if (!lllllllllllllllIlIIlllllIIlllIII.func_190926_b()) {
                this.villagerInventory.addItem(lllllllllllllllIlIIlllllIIlllIII);
            }
        }
        this.setCanPickUpLoot(true);
        this.setAdditionalAItasks();
    }
    
    @Nullable
    @Override
    protected ResourceLocation getLootTable() {
        return LootTableList.field_191184_at;
    }
    
    @Override
    public boolean processInteract(final EntityPlayer lllllllllllllllIlIIllllllIIIlIIl, final EnumHand lllllllllllllllIlIIllllllIIIllIl) {
        final ItemStack lllllllllllllllIlIIllllllIIIllII = lllllllllllllllIlIIllllllIIIlIIl.getHeldItem(lllllllllllllllIlIIllllllIIIllIl);
        final boolean lllllllllllllllIlIIllllllIIIlIll = lllllllllllllllIlIIllllllIIIllII.getItem() == Items.NAME_TAG;
        if (lllllllllllllllIlIIllllllIIIlIll) {
            lllllllllllllllIlIIllllllIIIllII.interactWithEntity(lllllllllllllllIlIIllllllIIIlIIl, this, lllllllllllllllIlIIllllllIIIllIl);
            return true;
        }
        if (!this.func_190669_a(lllllllllllllllIlIIllllllIIIllII, this.getClass()) && this.isEntityAlive() && !this.isTrading() && !this.isChild()) {
            if (this.buyingList == null) {
                this.populateBuyingList();
            }
            if (lllllllllllllllIlIIllllllIIIllIl == EnumHand.MAIN_HAND) {
                lllllllllllllllIlIIllllllIIIlIIl.addStat(StatList.TALKED_TO_VILLAGER);
            }
            if (!this.world.isRemote && !this.buyingList.isEmpty()) {
                this.setCustomer(lllllllllllllllIlIIllllllIIIlIIl);
                lllllllllllllllIlIIllllllIIIlIIl.displayVillagerTradeGui(this);
            }
            else if (this.buyingList.isEmpty()) {
                return super.processInteract(lllllllllllllllIlIIllllllIIIlIIl, lllllllllllllllIlIIllllllIIIllIl);
            }
            return true;
        }
        return super.processInteract(lllllllllllllllIlIIllllllIIIlIIl, lllllllllllllllIlIIllllllIIIllIl);
    }
    
    public InventoryBasic getVillagerInventory() {
        return this.villagerInventory;
    }
    
    public boolean isPlaying() {
        return this.isPlaying;
    }
    
    public boolean hasEnoughFoodToBreed() {
        return this.hasEnoughItems(1);
    }
    
    public boolean getIsWillingToMate(final boolean lllllllllllllllIlIIllllIllIlllll) {
        if (!this.isWillingToMate && lllllllllllllllIlIIllllIllIlllll && this.hasEnoughFoodToBreed()) {
            boolean lllllllllllllllIlIIllllIlllIIIll = false;
            for (int lllllllllllllllIlIIllllIlllIIIlI = 0; lllllllllllllllIlIIllllIlllIIIlI < this.villagerInventory.getSizeInventory(); ++lllllllllllllllIlIIllllIlllIIIlI) {
                final ItemStack lllllllllllllllIlIIllllIlllIIIIl = this.villagerInventory.getStackInSlot(lllllllllllllllIlIIllllIlllIIIlI);
                if (!lllllllllllllllIlIIllllIlllIIIIl.func_190926_b()) {
                    if (lllllllllllllllIlIIllllIlllIIIIl.getItem() == Items.BREAD && lllllllllllllllIlIIllllIlllIIIIl.func_190916_E() >= 3) {
                        lllllllllllllllIlIIllllIlllIIIll = true;
                        this.villagerInventory.decrStackSize(lllllllllllllllIlIIllllIlllIIIlI, 3);
                    }
                    else if ((lllllllllllllllIlIIllllIlllIIIIl.getItem() == Items.POTATO || lllllllllllllllIlIIllllIlllIIIIl.getItem() == Items.CARROT) && lllllllllllllllIlIIllllIlllIIIIl.func_190916_E() >= 12) {
                        lllllllllllllllIlIIllllIlllIIIll = true;
                        this.villagerInventory.decrStackSize(lllllllllllllllIlIIllllIlllIIIlI, 12);
                    }
                }
                if (lllllllllllllllIlIIllllIlllIIIll) {
                    this.world.setEntityState(this, (byte)18);
                    this.isWillingToMate = true;
                    break;
                }
            }
        }
        return this.isWillingToMate;
    }
    
    @Override
    public void onStruckByLightning(final EntityLightningBolt lllllllllllllllIlIIllllIIlIlIIII) {
        if (!this.world.isRemote && !this.isDead) {
            final EntityWitch lllllllllllllllIlIIllllIIlIIllll = new EntityWitch(this.world);
            lllllllllllllllIlIIllllIIlIIllll.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
            lllllllllllllllIlIIllllIIlIIllll.onInitialSpawn(this.world.getDifficultyForLocation(new BlockPos(lllllllllllllllIlIIllllIIlIIllll)), null);
            lllllllllllllllIlIIllllIIlIIllll.setNoAI(this.isAIDisabled());
            if (this.hasCustomName()) {
                lllllllllllllllIlIIllllIIlIIllll.setCustomNameTag(this.getCustomNameTag());
                lllllllllllllllIlIIllllIIlIIllll.setAlwaysRenderNameTag(this.getAlwaysRenderNameTag());
            }
            this.world.spawnEntityInWorld(lllllllllllllllIlIIllllIIlIIllll);
            this.setDead();
        }
    }
    
    @Override
    protected SoundEvent getHurtSound(final DamageSource lllllllllllllllIlIIlllllIIlIlIIl) {
        return SoundEvents.ENTITY_VILLAGER_HURT;
    }
    
    @Override
    public void onDeath(final DamageSource lllllllllllllllIlIIllllIlllllIIl) {
        if (this.villageObj != null) {
            final Entity lllllllllllllllIlIIllllIllllllII = lllllllllllllllIlIIllllIlllllIIl.getEntity();
            if (lllllllllllllllIlIIllllIllllllII != null) {
                if (lllllllllllllllIlIIllllIllllllII instanceof EntityPlayer) {
                    this.villageObj.modifyPlayerReputation(lllllllllllllllIlIIllllIllllllII.getName(), -2);
                }
                else if (lllllllllllllllIlIIllllIllllllII instanceof IMob) {
                    this.villageObj.endMatingSeason();
                }
            }
            else {
                final EntityPlayer lllllllllllllllIlIIllllIlllllIll = this.world.getClosestPlayerToEntity(this, 16.0);
                if (lllllllllllllllIlIIllllIlllllIll != null) {
                    this.villageObj.endMatingSeason();
                }
            }
        }
        super.onDeath(lllllllllllllllIlIIllllIlllllIIl);
    }
    
    public void setProfession(final int lllllllllllllllIlIIlllllIIlIIIIl) {
        this.dataManager.set(EntityVillager.PROFESSION, lllllllllllllllIlIIlllllIIlIIIIl);
    }
    
    public EntityVillager(final World lllllllllllllllIlIIllllllIlllIll, final int lllllllllllllllIlIIllllllIlllIlI) {
        super(lllllllllllllllIlIIllllllIlllIll);
        this.villagerInventory = new InventoryBasic("Items", false, 8);
        this.setProfession(lllllllllllllllIlIIllllllIlllIlI);
        this.setSize(0.6f, 1.95f);
        ((PathNavigateGround)this.getNavigator()).setBreakDoors(true);
        this.setCanPickUpLoot(true);
    }
    
    @Override
    public void setRecipes(@Nullable final MerchantRecipeList lllllllllllllllIlIIllllIlIlIIllI) {
    }
    
    private boolean canVillagerPickupItem(final Item lllllllllllllllIlIIllllIIIllIlll) {
        return lllllllllllllllIlIIllllIIIllIlll == Items.BREAD || lllllllllllllllIlIIllllIIIllIlll == Items.POTATO || lllllllllllllllIlIIllllIIIllIlll == Items.CARROT || lllllllllllllllIlIIllllIIIllIlll == Items.WHEAT || lllllllllllllllIlIIllllIIIllIlll == Items.WHEAT_SEEDS || lllllllllllllllIlIIllllIIIllIlll == Items.BEETROOT || lllllllllllllllIlIIllllIIIllIlll == Items.BEETROOT_SEEDS;
    }
    
    public IEntityLivingData func_190672_a(final DifficultyInstance lllllllllllllllIlIIllllIIllIIllI, @Nullable IEntityLivingData lllllllllllllllIlIIllllIIllIIIIl, final boolean lllllllllllllllIlIIllllIIllIIIII) {
        lllllllllllllllIlIIllllIIllIIIIl = (float)super.onInitialSpawn(lllllllllllllllIlIIllllIIllIIllI, (IEntityLivingData)lllllllllllllllIlIIllllIIllIIIIl);
        if (lllllllllllllllIlIIllllIIllIIIII) {
            this.setProfession(this.world.rand.nextInt(6));
        }
        this.setAdditionalAItasks();
        this.populateBuyingList();
        return (IEntityLivingData)lllllllllllllllIlIIllllIIllIIIIl;
    }
    
    private void populateBuyingList() {
        final ITradeList[][][] lllllllllllllllIlIIllllIlIllIlll = EntityVillager.DEFAULT_TRADE_LIST_MAP[this.getProfession()];
        if (this.careerId != 0 && this.careerLevel != 0) {
            ++this.careerLevel;
        }
        else {
            this.careerId = this.rand.nextInt(lllllllllllllllIlIIllllIlIllIlll.length) + 1;
            this.careerLevel = 1;
        }
        if (this.buyingList == null) {
            this.buyingList = new MerchantRecipeList();
        }
        final int lllllllllllllllIlIIllllIlIllIllI = this.careerId - 1;
        final int lllllllllllllllIlIIllllIlIllIlIl = this.careerLevel - 1;
        if (lllllllllllllllIlIIllllIlIllIllI >= 0 && lllllllllllllllIlIIllllIlIllIllI < lllllllllllllllIlIIllllIlIllIlll.length) {
            final ITradeList[][] lllllllllllllllIlIIllllIlIllIlII = lllllllllllllllIlIIllllIlIllIlll[lllllllllllllllIlIIllllIlIllIllI];
            if (lllllllllllllllIlIIllllIlIllIlIl >= 0 && lllllllllllllllIlIIllllIlIllIlIl < lllllllllllllllIlIIllllIlIllIlII.length) {
                final ITradeList[] lllllllllllllllIlIIllllIlIllIIll = lllllllllllllllIlIIllllIlIllIlII[lllllllllllllllIlIIllllIlIllIlIl];
                final float lllllllllllllllIlIIllllIlIlIlIII;
                final Exception lllllllllllllllIlIIllllIlIlIlIIl = (Exception)((ITradeList[])(Object)(lllllllllllllllIlIIllllIlIlIlIII = (float)(Object)lllllllllllllllIlIIllllIlIllIIll)).length;
                for (long lllllllllllllllIlIIllllIlIlIlIlI = 0; lllllllllllllllIlIIllllIlIlIlIlI < lllllllllllllllIlIIllllIlIlIlIIl; ++lllllllllllllllIlIIllllIlIlIlIlI) {
                    final ITradeList lllllllllllllllIlIIllllIlIllIIlI = lllllllllllllllIlIIllllIlIlIlIII[lllllllllllllllIlIIllllIlIlIlIlI];
                    lllllllllllllllIlIIllllIlIllIIlI.func_190888_a(this, this.buyingList, this.rand);
                }
            }
        }
    }
    
    @Override
    public void verifySellingItem(final ItemStack lllllllllllllllIlIIllllIllIIIlll) {
        if (!this.world.isRemote && this.livingSoundTime > -this.getTalkInterval() + 20) {
            this.livingSoundTime = -this.getTalkInterval();
            this.playSound(lllllllllllllllIlIIllllIllIIIlll.func_190926_b() ? SoundEvents.ENTITY_VILLAGER_NO : SoundEvents.ENTITY_VILLAGER_YES, this.getSoundVolume(), this.getSoundPitch());
        }
    }
    
    static {
        field_190674_bx = LogManager.getLogger();
        PROFESSION = EntityDataManager.createKey(EntityVillager.class, DataSerializers.VARINT);
        DEFAULT_TRADE_LIST_MAP = new ITradeList[][][][] { { { { new EmeraldForItems(Items.WHEAT, new PriceInfo(18, 22)), new EmeraldForItems(Items.POTATO, new PriceInfo(15, 19)), new EmeraldForItems(Items.CARROT, new PriceInfo(15, 19)), new ListItemForEmeralds(Items.BREAD, new PriceInfo(-4, -2)) }, { new EmeraldForItems(Item.getItemFromBlock(Blocks.PUMPKIN), new PriceInfo(8, 13)), new ListItemForEmeralds(Items.PUMPKIN_PIE, new PriceInfo(-3, -2)) }, { new EmeraldForItems(Item.getItemFromBlock(Blocks.MELON_BLOCK), new PriceInfo(7, 12)), new ListItemForEmeralds(Items.APPLE, new PriceInfo(-7, -5)) }, { new ListItemForEmeralds(Items.COOKIE, new PriceInfo(-10, -6)), new ListItemForEmeralds(Items.CAKE, new PriceInfo(1, 1)) } }, { { new EmeraldForItems(Items.STRING, new PriceInfo(15, 20)), new EmeraldForItems(Items.COAL, new PriceInfo(16, 24)), new ItemAndEmeraldToItem(Items.FISH, new PriceInfo(6, 6), Items.COOKED_FISH, new PriceInfo(6, 6)) }, { new ListEnchantedItemForEmeralds(Items.FISHING_ROD, new PriceInfo(7, 8)) } }, { { new EmeraldForItems(Item.getItemFromBlock(Blocks.WOOL), new PriceInfo(16, 22)), new ListItemForEmeralds(Items.SHEARS, new PriceInfo(3, 4)) }, { new ListItemForEmeralds(new ItemStack(Item.getItemFromBlock(Blocks.WOOL)), new PriceInfo(1, 2)), new ListItemForEmeralds(new ItemStack(Item.getItemFromBlock(Blocks.WOOL), 1, 1), new PriceInfo(1, 2)), new ListItemForEmeralds(new ItemStack(Item.getItemFromBlock(Blocks.WOOL), 1, 2), new PriceInfo(1, 2)), new ListItemForEmeralds(new ItemStack(Item.getItemFromBlock(Blocks.WOOL), 1, 3), new PriceInfo(1, 2)), new ListItemForEmeralds(new ItemStack(Item.getItemFromBlock(Blocks.WOOL), 1, 4), new PriceInfo(1, 2)), new ListItemForEmeralds(new ItemStack(Item.getItemFromBlock(Blocks.WOOL), 1, 5), new PriceInfo(1, 2)), new ListItemForEmeralds(new ItemStack(Item.getItemFromBlock(Blocks.WOOL), 1, 6), new PriceInfo(1, 2)), new ListItemForEmeralds(new ItemStack(Item.getItemFromBlock(Blocks.WOOL), 1, 7), new PriceInfo(1, 2)), new ListItemForEmeralds(new ItemStack(Item.getItemFromBlock(Blocks.WOOL), 1, 8), new PriceInfo(1, 2)), new ListItemForEmeralds(new ItemStack(Item.getItemFromBlock(Blocks.WOOL), 1, 9), new PriceInfo(1, 2)), new ListItemForEmeralds(new ItemStack(Item.getItemFromBlock(Blocks.WOOL), 1, 10), new PriceInfo(1, 2)), new ListItemForEmeralds(new ItemStack(Item.getItemFromBlock(Blocks.WOOL), 1, 11), new PriceInfo(1, 2)), new ListItemForEmeralds(new ItemStack(Item.getItemFromBlock(Blocks.WOOL), 1, 12), new PriceInfo(1, 2)), new ListItemForEmeralds(new ItemStack(Item.getItemFromBlock(Blocks.WOOL), 1, 13), new PriceInfo(1, 2)), new ListItemForEmeralds(new ItemStack(Item.getItemFromBlock(Blocks.WOOL), 1, 14), new PriceInfo(1, 2)), new ListItemForEmeralds(new ItemStack(Item.getItemFromBlock(Blocks.WOOL), 1, 15), new PriceInfo(1, 2)) } }, { { new EmeraldForItems(Items.STRING, new PriceInfo(15, 20)), new ListItemForEmeralds(Items.ARROW, new PriceInfo(-12, -8)) }, { new ListItemForEmeralds(Items.BOW, new PriceInfo(2, 3)), new ItemAndEmeraldToItem(Item.getItemFromBlock(Blocks.GRAVEL), new PriceInfo(10, 10), Items.FLINT, new PriceInfo(6, 10)) } } }, { { { new EmeraldForItems(Items.PAPER, new PriceInfo(24, 36)), new ListEnchantedBookForEmeralds() }, { new EmeraldForItems(Items.BOOK, new PriceInfo(8, 10)), new ListItemForEmeralds(Items.COMPASS, new PriceInfo(10, 12)), new ListItemForEmeralds(Item.getItemFromBlock(Blocks.BOOKSHELF), new PriceInfo(3, 4)) }, { new EmeraldForItems(Items.WRITTEN_BOOK, new PriceInfo(2, 2)), new ListItemForEmeralds(Items.CLOCK, new PriceInfo(10, 12)), new ListItemForEmeralds(Item.getItemFromBlock(Blocks.GLASS), new PriceInfo(-5, -3)) }, { new ListEnchantedBookForEmeralds() }, { new ListEnchantedBookForEmeralds() }, { new ListItemForEmeralds(Items.NAME_TAG, new PriceInfo(20, 22)) } }, { { new EmeraldForItems(Items.PAPER, new PriceInfo(24, 36)) }, { new EmeraldForItems(Items.COMPASS, new PriceInfo(1, 1)) }, { new ListItemForEmeralds(Items.MAP, new PriceInfo(7, 11)) }, { new TreasureMapForEmeralds(new PriceInfo(12, 20), "Monument", MapDecoration.Type.MONUMENT), new TreasureMapForEmeralds(new PriceInfo(16, 28), "Mansion", MapDecoration.Type.MANSION) } } }, { { { new EmeraldForItems(Items.ROTTEN_FLESH, new PriceInfo(36, 40)), new EmeraldForItems(Items.GOLD_INGOT, new PriceInfo(8, 10)) }, { new ListItemForEmeralds(Items.REDSTONE, new PriceInfo(-4, -1)), new ListItemForEmeralds(new ItemStack(Items.DYE, 1, EnumDyeColor.BLUE.getDyeDamage()), new PriceInfo(-2, -1)) }, { new ListItemForEmeralds(Items.ENDER_PEARL, new PriceInfo(4, 7)), new ListItemForEmeralds(Item.getItemFromBlock(Blocks.GLOWSTONE), new PriceInfo(-3, -1)) }, { new ListItemForEmeralds(Items.EXPERIENCE_BOTTLE, new PriceInfo(3, 11)) } } }, { { { new EmeraldForItems(Items.COAL, new PriceInfo(16, 24)), new ListItemForEmeralds(Items.IRON_HELMET, new PriceInfo(4, 6)) }, { new EmeraldForItems(Items.IRON_INGOT, new PriceInfo(7, 9)), new ListItemForEmeralds(Items.IRON_CHESTPLATE, new PriceInfo(10, 14)) }, { new EmeraldForItems(Items.DIAMOND, new PriceInfo(3, 4)), new ListEnchantedItemForEmeralds(Items.DIAMOND_CHESTPLATE, new PriceInfo(16, 19)) }, { new ListItemForEmeralds(Items.CHAINMAIL_BOOTS, new PriceInfo(5, 7)), new ListItemForEmeralds(Items.CHAINMAIL_LEGGINGS, new PriceInfo(9, 11)), new ListItemForEmeralds(Items.CHAINMAIL_HELMET, new PriceInfo(5, 7)), new ListItemForEmeralds(Items.CHAINMAIL_CHESTPLATE, new PriceInfo(11, 15)) } }, { { new EmeraldForItems(Items.COAL, new PriceInfo(16, 24)), new ListItemForEmeralds(Items.IRON_AXE, new PriceInfo(6, 8)) }, { new EmeraldForItems(Items.IRON_INGOT, new PriceInfo(7, 9)), new ListEnchantedItemForEmeralds(Items.IRON_SWORD, new PriceInfo(9, 10)) }, { new EmeraldForItems(Items.DIAMOND, new PriceInfo(3, 4)), new ListEnchantedItemForEmeralds(Items.DIAMOND_SWORD, new PriceInfo(12, 15)), new ListEnchantedItemForEmeralds(Items.DIAMOND_AXE, new PriceInfo(9, 12)) } }, { { new EmeraldForItems(Items.COAL, new PriceInfo(16, 24)), new ListEnchantedItemForEmeralds(Items.IRON_SHOVEL, new PriceInfo(5, 7)) }, { new EmeraldForItems(Items.IRON_INGOT, new PriceInfo(7, 9)), new ListEnchantedItemForEmeralds(Items.IRON_PICKAXE, new PriceInfo(9, 11)) }, { new EmeraldForItems(Items.DIAMOND, new PriceInfo(3, 4)), new ListEnchantedItemForEmeralds(Items.DIAMOND_PICKAXE, new PriceInfo(12, 15)) } } }, { { { new EmeraldForItems(Items.PORKCHOP, new PriceInfo(14, 18)), new EmeraldForItems(Items.CHICKEN, new PriceInfo(14, 18)) }, { new EmeraldForItems(Items.COAL, new PriceInfo(16, 24)), new ListItemForEmeralds(Items.COOKED_PORKCHOP, new PriceInfo(-7, -5)), new ListItemForEmeralds(Items.COOKED_CHICKEN, new PriceInfo(-8, -6)) } }, { { new EmeraldForItems(Items.LEATHER, new PriceInfo(9, 12)), new ListItemForEmeralds(Items.LEATHER_LEGGINGS, new PriceInfo(2, 4)) }, { new ListEnchantedItemForEmeralds(Items.LEATHER_CHESTPLATE, new PriceInfo(7, 12)) }, { new ListItemForEmeralds(Items.SADDLE, new PriceInfo(8, 10)) } } }, { new ITradeList[0][] } };
    }
    
    public static void registerFixesVillager(final DataFixer lllllllllllllllIlIIlllllIlllIlII) {
        EntityLiving.registerFixesMob(lllllllllllllllIlIIlllllIlllIlII, EntityVillager.class);
        lllllllllllllllIlIIlllllIlllIlII.registerWalker(FixTypes.ENTITY, new ItemStackDataLists(EntityVillager.class, new String[] { "Inventory" }));
        lllllllllllllllIlIIlllllIlllIlII.registerWalker(FixTypes.ENTITY, new IDataWalker() {
            @Override
            public NBTTagCompound process(final IDataFixer lllllllllllllllllIlIlllIIIIIIIII, final NBTTagCompound lllllllllllllllllIlIllIlllllllll, final int lllllllllllllllllIlIlllIIIIIIlIl) {
                if (EntityList.func_191306_a(EntityVillager.class).equals(new ResourceLocation(lllllllllllllllllIlIllIlllllllll.getString("id"))) && lllllllllllllllllIlIllIlllllllll.hasKey("Offers", 10)) {
                    final NBTTagCompound lllllllllllllllllIlIlllIIIIIIlII = lllllllllllllllllIlIllIlllllllll.getCompoundTag("Offers");
                    if (lllllllllllllllllIlIlllIIIIIIlII.hasKey("Recipes", 9)) {
                        final NBTTagList lllllllllllllllllIlIlllIIIIIIIll = lllllllllllllllllIlIlllIIIIIIlII.getTagList("Recipes", 10);
                        for (int lllllllllllllllllIlIlllIIIIIIIlI = 0; lllllllllllllllllIlIlllIIIIIIIlI < lllllllllllllllllIlIlllIIIIIIIll.tagCount(); ++lllllllllllllllllIlIlllIIIIIIIlI) {
                            final NBTTagCompound lllllllllllllllllIlIlllIIIIIIIIl = lllllllllllllllllIlIlllIIIIIIIll.getCompoundTagAt(lllllllllllllllllIlIlllIIIIIIIlI);
                            DataFixesManager.processItemStack(lllllllllllllllllIlIlllIIIIIIIII, lllllllllllllllllIlIlllIIIIIIIIl, lllllllllllllllllIlIlllIIIIIIlIl, "buy");
                            DataFixesManager.processItemStack(lllllllllllllllllIlIlllIIIIIIIII, lllllllllllllllllIlIlllIIIIIIIIl, lllllllllllllllllIlIlllIIIIIIlIl, "buyB");
                            DataFixesManager.processItemStack(lllllllllllllllllIlIlllIIIIIIIII, lllllllllllllllllIlIlllIIIIIIIIl, lllllllllllllllllIlIlllIIIIIIlIl, "sell");
                            lllllllllllllllllIlIlllIIIIIIIll.set(lllllllllllllllllIlIlllIIIIIIIlI, lllllllllllllllllIlIlllIIIIIIIIl);
                        }
                    }
                }
                return lllllllllllllllllIlIllIlllllllll;
            }
        });
    }
    
    @Override
    protected boolean canDespawn() {
        return false;
    }
    
    public void setPlaying(final boolean lllllllllllllllIlIIlllllIIIlIIIl) {
        this.isPlaying = lllllllllllllllIlIIlllllIIIlIIIl;
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound lllllllllllllllIlIIlllllIlIlllll) {
        super.writeEntityToNBT(lllllllllllllllIlIIlllllIlIlllll);
        lllllllllllllllIlIIlllllIlIlllll.setInteger("Profession", this.getProfession());
        lllllllllllllllIlIIlllllIlIlllll.setInteger("Riches", this.wealth);
        lllllllllllllllIlIIlllllIlIlllll.setInteger("Career", this.careerId);
        lllllllllllllllIlIIlllllIlIlllll.setInteger("CareerLevel", this.careerLevel);
        lllllllllllllllIlIIlllllIlIlllll.setBoolean("Willing", this.isWillingToMate);
        if (this.buyingList != null) {
            lllllllllllllllIlIIlllllIlIlllll.setTag("Offers", this.buyingList.getRecipiesAsTags());
        }
        final NBTTagList lllllllllllllllIlIIlllllIlIlllIl = new NBTTagList();
        for (int lllllllllllllllIlIIlllllIlIlllII = 0; lllllllllllllllIlIIlllllIlIlllII < this.villagerInventory.getSizeInventory(); ++lllllllllllllllIlIIlllllIlIlllII) {
            final ItemStack lllllllllllllllIlIIlllllIlIllIll = this.villagerInventory.getStackInSlot(lllllllllllllllIlIIlllllIlIlllII);
            if (!lllllllllllllllIlIIlllllIlIllIll.func_190926_b()) {
                lllllllllllllllIlIIlllllIlIlllIl.appendTag(lllllllllllllllIlIIlllllIlIllIll.writeToNBT(new NBTTagCompound()));
            }
        }
        lllllllllllllllIlIIlllllIlIlllll.setTag("Inventory", lllllllllllllllIlIIlllllIlIlllIl);
    }
    
    public void setLookingForHome() {
        this.isLookingForHome = true;
    }
    
    @Override
    public boolean replaceItemInInventory(final int lllllllllllllllIlIIllllIIIIIlIIl, final ItemStack lllllllllllllllIlIIllllIIIIIllII) {
        if (super.replaceItemInInventory(lllllllllllllllIlIIllllIIIIIlIIl, lllllllllllllllIlIIllllIIIIIllII)) {
            return true;
        }
        final int lllllllllllllllIlIIllllIIIIIlIll = lllllllllllllllIlIIllllIIIIIlIIl - 300;
        if (lllllllllllllllIlIIllllIIIIIlIll >= 0 && lllllllllllllllIlIIllllIIIIIlIll < this.villagerInventory.getSizeInventory()) {
            this.villagerInventory.setInventorySlotContents(lllllllllllllllIlIIllllIIIIIlIll, lllllllllllllllIlIIllllIIIIIllII);
            return true;
        }
        return false;
    }
    
    @Override
    protected void onGrowingAdult() {
        if (this.getProfession() == 0) {
            this.tasks.addTask(8, new EntityAIHarvestFarmland(this, 0.6));
        }
        super.onGrowingAdult();
    }
    
    public int getProfession() {
        return Math.max(this.dataManager.get(EntityVillager.PROFESSION) % 6, 0);
    }
    
    @Nullable
    @Override
    public MerchantRecipeList getRecipes(final EntityPlayer lllllllllllllllIlIIllllIllIIIlII) {
        if (this.buyingList == null) {
            this.populateBuyingList();
        }
        return this.buyingList;
    }
    
    @Override
    public float getEyeHeight() {
        return this.isChild() ? 0.81f : 1.62f;
    }
    
    static class ListEnchantedBookForEmeralds implements ITradeList
    {
        @Override
        public void func_190888_a(final IMerchant lllllllllllllIlllllllIllllIlIlII, final MerchantRecipeList lllllllllllllIlllllllIllllIIllIl, final Random lllllllllllllIlllllllIllllIlIIlI) {
            final Enchantment lllllllllllllIlllllllIllllIlIIIl = Enchantment.REGISTRY.getRandomObject(lllllllllllllIlllllllIllllIlIIlI);
            final int lllllllllllllIlllllllIllllIlIIII = MathHelper.getInt(lllllllllllllIlllllllIllllIlIIlI, lllllllllllllIlllllllIllllIlIIIl.getMinLevel(), lllllllllllllIlllllllIllllIlIIIl.getMaxLevel());
            final ItemStack lllllllllllllIlllllllIllllIIllll = ItemEnchantedBook.getEnchantedItemStack(new EnchantmentData(lllllllllllllIlllllllIllllIlIIIl, lllllllllllllIlllllllIllllIlIIII));
            int lllllllllllllIlllllllIllllIIlllI = 2 + lllllllllllllIlllllllIllllIlIIlI.nextInt(5 + lllllllllllllIlllllllIllllIlIIII * 10) + 3 * lllllllllllllIlllllllIllllIlIIII;
            if (lllllllllllllIlllllllIllllIlIIIl.isTreasureEnchantment()) {
                lllllllllllllIlllllllIllllIIlllI *= 2;
            }
            if (lllllllllllllIlllllllIllllIIlllI > 64) {
                lllllllllllllIlllllllIllllIIlllI = 64;
            }
            lllllllllllllIlllllllIllllIIllIl.add(new MerchantRecipe(new ItemStack(Items.BOOK), new ItemStack(Items.EMERALD, lllllllllllllIlllllllIllllIIlllI), lllllllllllllIlllllllIllllIIllll));
        }
    }
    
    interface ITradeList
    {
        void func_190888_a(final IMerchant p0, final MerchantRecipeList p1, final Random p2);
    }
    
    static class PriceInfo extends Tuple<Integer, Integer>
    {
        public int getPrice(final Random llllllllllllllIlIIlIIIlIlIlIllII) {
            return (((Tuple<Integer, B>)this).getFirst() >= ((Tuple<A, Integer>)this).getSecond()) ? ((Tuple<Integer, B>)this).getFirst() : (((Tuple<Integer, B>)this).getFirst() + llllllllllllllIlIIlIIIlIlIlIllII.nextInt(((Tuple<A, Integer>)this).getSecond() - ((Tuple<Integer, B>)this).getFirst() + 1));
        }
        
        public PriceInfo(final int llllllllllllllIlIIlIIIlIlIllIllI, final int llllllllllllllIlIIlIIIlIlIllIlIl) {
            super(llllllllllllllIlIIlIIIlIlIllIllI, llllllllllllllIlIIlIIIlIlIllIlIl);
            if (llllllllllllllIlIIlIIIlIlIllIlIl < llllllllllllllIlIIlIIIlIlIllIllI) {
                EntityVillager.field_190674_bx.warn("PriceRange({}, {}) invalid, {} smaller than {}", (Object)llllllllllllllIlIIlIIIlIlIllIllI, (Object)llllllllllllllIlIIlIIIlIlIllIlIl, (Object)llllllllllllllIlIIlIIIlIlIllIlIl, (Object)llllllllllllllIlIIlIIIlIlIllIllI);
            }
        }
    }
    
    static class EmeraldForItems implements ITradeList
    {
        public /* synthetic */ PriceInfo price;
        public /* synthetic */ Item buyingItem;
        
        public EmeraldForItems(final Item llllllllllllllIlIIIllIIlllIlIlll, final PriceInfo llllllllllllllIlIIIllIIlllIllIIl) {
            this.buyingItem = llllllllllllllIlIIIllIIlllIlIlll;
            this.price = llllllllllllllIlIIIllIIlllIllIIl;
        }
        
        @Override
        public void func_190888_a(final IMerchant llllllllllllllIlIIIllIIlllIlIIII, final MerchantRecipeList llllllllllllllIlIIIllIIlllIIllll, final Random llllllllllllllIlIIIllIIlllIIlllI) {
            int llllllllllllllIlIIIllIIlllIIllIl = 1;
            if (this.price != null) {
                llllllllllllllIlIIIllIIlllIIllIl = this.price.getPrice(llllllllllllllIlIIIllIIlllIIlllI);
            }
            llllllllllllllIlIIIllIIlllIIllll.add(new MerchantRecipe(new ItemStack(this.buyingItem, llllllllllllllIlIIIllIIlllIIllIl, 0), Items.EMERALD));
        }
    }
    
    static class ItemAndEmeraldToItem implements ITradeList
    {
        public /* synthetic */ PriceInfo sellingPriceInfo;
        public /* synthetic */ ItemStack sellingItemstack;
        public /* synthetic */ ItemStack buyingItemStack;
        public /* synthetic */ PriceInfo buyingPriceInfo;
        
        public ItemAndEmeraldToItem(final Item llllllllllllllIlIIIllIlIIIIIIIll, final PriceInfo llllllllllllllIlIIIllIlIIIIIIIlI, final Item llllllllllllllIlIIIllIlIIIIIIIIl, final PriceInfo llllllllllllllIlIIIllIIllllllIll) {
            this.buyingItemStack = new ItemStack(llllllllllllllIlIIIllIlIIIIIIIll);
            this.buyingPriceInfo = llllllllllllllIlIIIllIlIIIIIIIlI;
            this.sellingItemstack = new ItemStack(llllllllllllllIlIIIllIlIIIIIIIIl);
            this.sellingPriceInfo = llllllllllllllIlIIIllIIllllllIll;
        }
        
        @Override
        public void func_190888_a(final IMerchant llllllllllllllIlIIIllIIlllllIlII, final MerchantRecipeList llllllllllllllIlIIIllIIllllIlllI, final Random llllllllllllllIlIIIllIIlllllIIlI) {
            final int llllllllllllllIlIIIllIIlllllIIIl = this.buyingPriceInfo.getPrice(llllllllllllllIlIIIllIIlllllIIlI);
            final int llllllllllllllIlIIIllIIlllllIIII = this.sellingPriceInfo.getPrice(llllllllllllllIlIIIllIIlllllIIlI);
            llllllllllllllIlIIIllIIllllIlllI.add(new MerchantRecipe(new ItemStack(this.buyingItemStack.getItem(), llllllllllllllIlIIIllIIlllllIIIl, this.buyingItemStack.getMetadata()), new ItemStack(Items.EMERALD), new ItemStack(this.sellingItemstack.getItem(), llllllllllllllIlIIIllIIlllllIIII, this.sellingItemstack.getMetadata())));
        }
    }
    
    static class ListItemForEmeralds implements ITradeList
    {
        public /* synthetic */ PriceInfo priceInfo;
        public /* synthetic */ ItemStack itemToBuy;
        
        public ListItemForEmeralds(final Item lllllllllllllIlIIlIlIllIIIIlIlII, final PriceInfo lllllllllllllIlIIlIlIllIIIIlIIII) {
            this.itemToBuy = new ItemStack(lllllllllllllIlIIlIlIllIIIIlIlII);
            this.priceInfo = lllllllllllllIlIIlIlIllIIIIlIIII;
        }
        
        public ListItemForEmeralds(final ItemStack lllllllllllllIlIIlIlIllIIIIIlIll, final PriceInfo lllllllllllllIlIIlIlIllIIIIIlIlI) {
            this.itemToBuy = lllllllllllllIlIIlIlIllIIIIIlIll;
            this.priceInfo = lllllllllllllIlIIlIlIllIIIIIlIlI;
        }
        
        @Override
        public void func_190888_a(final IMerchant lllllllllllllIlIIlIlIlIlllllllll, final MerchantRecipeList lllllllllllllIlIIlIlIlIlllllIllI, final Random lllllllllllllIlIIlIlIlIlllllllIl) {
            int lllllllllllllIlIIlIlIlIlllllllII = 1;
            if (this.priceInfo != null) {
                lllllllllllllIlIIlIlIlIlllllllII = this.priceInfo.getPrice(lllllllllllllIlIIlIlIlIlllllllIl);
            }
            ItemStack lllllllllllllIlIIlIlIlIllllllIlI = null;
            ItemStack lllllllllllllIlIIlIlIlIllllllIII = null;
            if (lllllllllllllIlIIlIlIlIlllllllII < 0) {
                final ItemStack lllllllllllllIlIIlIlIlIllllllIll = new ItemStack(Items.EMERALD);
                final ItemStack lllllllllllllIlIIlIlIlIllllllIIl = new ItemStack(this.itemToBuy.getItem(), -lllllllllllllIlIIlIlIlIlllllllII, this.itemToBuy.getMetadata());
            }
            else {
                lllllllllllllIlIIlIlIlIllllllIlI = new ItemStack(Items.EMERALD, lllllllllllllIlIIlIlIlIlllllllII, 0);
                lllllllllllllIlIIlIlIlIllllllIII = new ItemStack(this.itemToBuy.getItem(), 1, this.itemToBuy.getMetadata());
            }
            lllllllllllllIlIIlIlIlIlllllIllI.add(new MerchantRecipe(lllllllllllllIlIIlIlIlIllllllIlI, lllllllllllllIlIIlIlIlIllllllIII));
        }
    }
    
    static class ListEnchantedItemForEmeralds implements ITradeList
    {
        public /* synthetic */ ItemStack enchantedItemStack;
        public /* synthetic */ PriceInfo priceInfo;
        
        @Override
        public void func_190888_a(final IMerchant llllllllllllllIlIIIlIIlIIllIlIlI, final MerchantRecipeList llllllllllllllIlIIIlIIlIIllIIIll, final Random llllllllllllllIlIIIlIIlIIllIlIII) {
            int llllllllllllllIlIIIlIIlIIllIIlll = 1;
            if (this.priceInfo != null) {
                llllllllllllllIlIIIlIIlIIllIIlll = this.priceInfo.getPrice(llllllllllllllIlIIIlIIlIIllIlIII);
            }
            final ItemStack llllllllllllllIlIIIlIIlIIllIIllI = new ItemStack(Items.EMERALD, llllllllllllllIlIIIlIIlIIllIIlll, 0);
            final ItemStack llllllllllllllIlIIIlIIlIIllIIlIl = EnchantmentHelper.addRandomEnchantment(llllllllllllllIlIIIlIIlIIllIlIII, new ItemStack(this.enchantedItemStack.getItem(), 1, this.enchantedItemStack.getMetadata()), 5 + llllllllllllllIlIIIlIIlIIllIlIII.nextInt(15), false);
            llllllllllllllIlIIIlIIlIIllIIIll.add(new MerchantRecipe(llllllllllllllIlIIIlIIlIIllIIllI, llllllllllllllIlIIIlIIlIIllIIlIl));
        }
        
        public ListEnchantedItemForEmeralds(final Item llllllllllllllIlIIIlIIlIIlllIllI, final PriceInfo llllllllllllllIlIIIlIIlIIlllIIlI) {
            this.enchantedItemStack = new ItemStack(llllllllllllllIlIIIlIIlIIlllIllI);
            this.priceInfo = llllllllllllllIlIIIlIIlIIlllIIlI;
        }
    }
    
    static class TreasureMapForEmeralds implements ITradeList
    {
        public /* synthetic */ PriceInfo field_190889_a;
        public /* synthetic */ MapDecoration.Type field_190891_c;
        public /* synthetic */ String field_190890_b;
        
        public TreasureMapForEmeralds(final PriceInfo lllllllllllllIlllllIIlIIlIllIIII, final String lllllllllllllIlllllIIlIIlIlIllll, final MapDecoration.Type lllllllllllllIlllllIIlIIlIlIlllI) {
            this.field_190889_a = lllllllllllllIlllllIIlIIlIllIIII;
            this.field_190890_b = lllllllllllllIlllllIIlIIlIlIllll;
            this.field_190891_c = lllllllllllllIlllllIIlIIlIlIlllI;
        }
        
        @Override
        public void func_190888_a(final IMerchant lllllllllllllIlllllIIlIIlIlIIlII, final MerchantRecipeList lllllllllllllIlllllIIlIIlIIllIll, final Random lllllllllllllIlllllIIlIIlIIllIlI) {
            final int lllllllllllllIlllllIIlIIlIlIIIIl = this.field_190889_a.getPrice(lllllllllllllIlllllIIlIIlIIllIlI);
            final World lllllllllllllIlllllIIlIIlIlIIIII = lllllllllllllIlllllIIlIIlIlIIlII.func_190670_t_();
            final BlockPos lllllllllllllIlllllIIlIIlIIlllll = lllllllllllllIlllllIIlIIlIlIIIII.func_190528_a(this.field_190890_b, lllllllllllllIlllllIIlIIlIlIIlII.func_190671_u_(), true);
            if (lllllllllllllIlllllIIlIIlIIlllll != null) {
                final ItemStack lllllllllllllIlllllIIlIIlIIllllI = ItemMap.func_190906_a(lllllllllllllIlllllIIlIIlIlIIIII, lllllllllllllIlllllIIlIIlIIlllll.getX(), lllllllllllllIlllllIIlIIlIIlllll.getZ(), (byte)2, true, true);
                ItemMap.func_190905_a(lllllllllllllIlllllIIlIIlIlIIIII, lllllllllllllIlllllIIlIIlIIllllI);
                MapData.func_191094_a(lllllllllllllIlllllIIlIIlIIllllI, lllllllllllllIlllllIIlIIlIIlllll, "+", this.field_190891_c);
                lllllllllllllIlllllIIlIIlIIllllI.func_190924_f(String.valueOf(new StringBuilder("filled_map.").append(this.field_190890_b.toLowerCase(Locale.ROOT))));
                lllllllllllllIlllllIIlIIlIIllIll.add(new MerchantRecipe(new ItemStack(Items.EMERALD, lllllllllllllIlllllIIlIIlIlIIIIl), new ItemStack(Items.COMPASS), lllllllllllllIlllllIIlIIlIIllllI));
            }
        }
    }
}
