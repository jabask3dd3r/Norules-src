package net.minecraft.entity.monster;

import net.minecraft.pathfinding.*;
import net.minecraft.entity.player.*;
import net.minecraft.nbt.*;
import javax.annotation.*;
import com.google.common.base.*;
import net.minecraft.inventory.*;
import net.minecraft.item.*;
import java.util.*;
import net.minecraft.world.*;
import net.minecraft.init.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.network.datasync.*;
import net.minecraft.entity.*;
import net.minecraft.entity.passive.*;
import net.minecraft.util.*;
import net.minecraft.world.storage.loot.*;
import net.minecraft.util.datafix.*;
import net.minecraft.entity.ai.*;
import net.minecraft.block.*;
import net.minecraft.util.math.*;

public class EntityZombie extends EntityMob
{
    private final /* synthetic */ EntityAIBreakDoor breakDoor;
    private /* synthetic */ float zombieHeight;
    private static final /* synthetic */ DataParameter<Boolean> ARMS_RAISED;
    private /* synthetic */ float zombieWidth;
    private static final /* synthetic */ DataParameter<Integer> VILLAGER_TYPE;
    protected static final /* synthetic */ IAttribute SPAWN_REINFORCEMENTS_CHANCE;
    private static final /* synthetic */ UUID BABY_SPEED_BOOST_ID;
    private static final /* synthetic */ AttributeModifier BABY_SPEED_BOOST;
    private /* synthetic */ boolean isBreakDoorsTaskSet;
    private static final /* synthetic */ DataParameter<Boolean> IS_CHILD;
    
    public void setArmsRaised(final boolean llllllllllllllIIlllIlIlIIIlIllll) {
        this.getDataManager().set(EntityZombie.ARMS_RAISED, llllllllllllllIIlllIlIlIIIlIllll);
    }
    
    public void setChild(final boolean llllllllllllllIIlllIlIlIIIIlIIlI) {
        this.getDataManager().set(EntityZombie.IS_CHILD, llllllllllllllIIlllIlIlIIIIlIIlI);
        if (this.world != null && !this.world.isRemote) {
            final IAttributeInstance llllllllllllllIIlllIlIlIIIIlIlII = this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED);
            llllllllllllllIIlllIlIlIIIIlIlII.removeModifier(EntityZombie.BABY_SPEED_BOOST);
            if (llllllllllllllIIlllIlIlIIIIlIIlI) {
                llllllllllllllIIlllIlIlIIIIlIlII.applyModifier(EntityZombie.BABY_SPEED_BOOST);
            }
        }
        this.setChildSize(llllllllllllllIIlllIlIlIIIIlIIlI);
    }
    
    @Override
    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute.UNDEAD;
    }
    
    @Override
    public boolean isChild() {
        return this.getDataManager().get(EntityZombie.IS_CHILD);
    }
    
    public EntityZombie(final World llllllllllllllIIlllIlIlIIlIIIIll) {
        super(llllllllllllllIIlllIlIlIIlIIIIll);
        this.breakDoor = new EntityAIBreakDoor(this);
        this.zombieWidth = -1.0f;
        this.setSize(0.6f, 1.95f);
    }
    
    @Override
    protected final void setSize(final float llllllllllllllIIlllIlIIlIllIlIlI, final float llllllllllllllIIlllIlIIlIllIllIl) {
        final boolean llllllllllllllIIlllIlIIlIllIllII = this.zombieWidth > 0.0f && this.zombieHeight > 0.0f;
        this.zombieWidth = llllllllllllllIIlllIlIIlIllIlIlI;
        this.zombieHeight = llllllllllllllIIlllIlIIlIllIllIl;
        if (!llllllllllllllIIlllIlIIlIllIllII) {
            this.multiplySize(1.0f);
        }
    }
    
    public void setBreakDoorsAItask(final boolean llllllllllllllIIlllIlIlIIIlIIlIl) {
        if (this.isBreakDoorsTaskSet != llllllllllllllIIlllIlIlIIIlIIlIl) {
            this.isBreakDoorsTaskSet = llllllllllllllIIlllIlIlIIIlIIlIl;
            ((PathNavigateGround)this.getNavigator()).setBreakDoors(llllllllllllllIIlllIlIlIIIlIIlIl);
            if (llllllllllllllIIlllIlIlIIIlIIlIl) {
                this.tasks.addTask(1, this.breakDoor);
            }
            else {
                this.tasks.removeTask(this.breakDoor);
            }
        }
    }
    
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_ZOMBIE_DEATH;
    }
    
    @Override
    protected SoundEvent getHurtSound(final DamageSource llllllllllllllIIlllIlIIlllIIlIll) {
        return SoundEvents.ENTITY_ZOMBIE_HURT;
    }
    
    @Override
    protected void initEntityAI() {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIZombieAttack(this, 1.0, false));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0));
        this.tasks.addTask(7, new EntityAIWanderAvoidWater(this, 1.0));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0f));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.applyEntityAI();
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound llllllllllllllIIlllIlIIllIlIllII) {
        super.readEntityFromNBT(llllllllllllllIIlllIlIIllIlIllII);
        if (llllllllllllllIIlllIlIIllIlIllII.getBoolean("IsBaby")) {
            this.setChild(true);
        }
        this.setBreakDoorsAItask(llllllllllllllIIlllIlIIllIlIllII.getBoolean("CanBreakDoors"));
    }
    
    protected boolean func_190730_o() {
        return true;
    }
    
    @Nullable
    @Override
    public IEntityLivingData onInitialSpawn(final DifficultyInstance llllllllllllllIIlllIlIIlIlllllll, @Nullable IEntityLivingData llllllllllllllIIlllIlIIlIllllllI) {
        llllllllllllllIIlllIlIIlIllllllI = (boolean)super.onInitialSpawn(llllllllllllllIIlllIlIIlIlllllll, (IEntityLivingData)llllllllllllllIIlllIlIIlIllllllI);
        final float llllllllllllllIIlllIlIIllIIIIlll = llllllllllllllIIlllIlIIlIlllllll.getClampedAdditionalDifficulty();
        this.setCanPickUpLoot(this.rand.nextFloat() < 0.55f * llllllllllllllIIlllIlIIllIIIIlll);
        if (llllllllllllllIIlllIlIIlIllllllI == null) {
            llllllllllllllIIlllIlIIlIllllllI = (boolean)new GroupData(this.world.rand.nextFloat() < 0.05f, (GroupData)null);
        }
        if (llllllllllllllIIlllIlIIlIllllllI instanceof GroupData) {
            final GroupData llllllllllllllIIlllIlIIllIIIIllI = (GroupData)llllllllllllllIIlllIlIIlIllllllI;
            if (llllllllllllllIIlllIlIIllIIIIllI.isChild) {
                this.setChild(true);
                if (this.world.rand.nextFloat() < 0.05) {
                    final List<EntityChicken> llllllllllllllIIlllIlIIllIIIIlIl = this.world.getEntitiesWithinAABB((Class<? extends EntityChicken>)EntityChicken.class, this.getEntityBoundingBox().expand(5.0, 3.0, 5.0), (com.google.common.base.Predicate<? super EntityChicken>)EntitySelectors.IS_STANDALONE);
                    if (!llllllllllllllIIlllIlIIllIIIIlIl.isEmpty()) {
                        final EntityChicken llllllllllllllIIlllIlIIllIIIIlII = llllllllllllllIIlllIlIIllIIIIlIl.get(0);
                        llllllllllllllIIlllIlIIllIIIIlII.setChickenJockey(true);
                        this.startRiding(llllllllllllllIIlllIlIIllIIIIlII);
                    }
                }
                else if (this.world.rand.nextFloat() < 0.05) {
                    final EntityChicken llllllllllllllIIlllIlIIllIIIIIll = new EntityChicken(this.world);
                    llllllllllllllIIlllIlIIllIIIIIll.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0f);
                    llllllllllllllIIlllIlIIllIIIIIll.onInitialSpawn(llllllllllllllIIlllIlIIlIlllllll, null);
                    llllllllllllllIIlllIlIIllIIIIIll.setChickenJockey(true);
                    this.world.spawnEntityInWorld(llllllllllllllIIlllIlIIllIIIIIll);
                    this.startRiding(llllllllllllllIIlllIlIIllIIIIIll);
                }
            }
        }
        this.setBreakDoorsAItask(this.rand.nextFloat() < llllllllllllllIIlllIlIIllIIIIlll * 0.1f);
        this.setEquipmentBasedOnDifficulty(llllllllllllllIIlllIlIIlIlllllll);
        this.setEnchantmentBasedOnDifficulty(llllllllllllllIIlllIlIIlIlllllll);
        if (this.getItemStackFromSlot(EntityEquipmentSlot.HEAD).func_190926_b()) {
            final Calendar llllllllllllllIIlllIlIIllIIIIIlI = this.world.getCurrentDate();
            if (llllllllllllllIIlllIlIIllIIIIIlI.get(2) + 1 == 10 && llllllllllllllIIlllIlIIllIIIIIlI.get(5) == 31 && this.rand.nextFloat() < 0.25f) {
                this.setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack((this.rand.nextFloat() < 0.1f) ? Blocks.LIT_PUMPKIN : Blocks.PUMPKIN));
                this.inventoryArmorDropChances[EntityEquipmentSlot.HEAD.getIndex()] = 0.0f;
            }
        }
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).applyModifier(new AttributeModifier("Random spawn bonus", this.rand.nextDouble() * 0.05000000074505806, 0));
        final double llllllllllllllIIlllIlIIllIIIIIIl = this.rand.nextDouble() * 1.5 * llllllllllllllIIlllIlIIllIIIIlll;
        if (llllllllllllllIIlllIlIIllIIIIIIl > 1.0) {
            this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).applyModifier(new AttributeModifier("Random zombie-spawn bonus", llllllllllllllIIlllIlIIllIIIIIIl, 2));
        }
        if (this.rand.nextFloat() < llllllllllllllIIlllIlIIllIIIIlll * 0.05f) {
            this.getEntityAttribute(EntityZombie.SPAWN_REINFORCEMENTS_CHANCE).applyModifier(new AttributeModifier("Leader zombie bonus", this.rand.nextDouble() * 0.25 + 0.5, 0));
            this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).applyModifier(new AttributeModifier("Leader zombie bonus", this.rand.nextDouble() * 3.0 + 1.0, 2));
            this.setBreakDoorsAItask(true);
        }
        return (IEntityLivingData)llllllllllllllIIlllIlIIlIllllllI;
    }
    
    @Override
    public float getEyeHeight() {
        float llllllllllllllIIlllIlIIllIIllIlI = 1.74f;
        if (this.isChild()) {
            llllllllllllllIIlllIlIIllIIllIlI -= (float)0.81;
        }
        return llllllllllllllIIlllIlIIllIIllIlI;
    }
    
    public void setChildSize(final boolean llllllllllllllIIlllIlIIlIlllIlII) {
        this.multiplySize(llllllllllllllIIlllIlIIlIlllIlII ? 0.5f : 1.0f);
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound llllllllllllllIIlllIlIIllIllIIII) {
        super.writeEntityToNBT(llllllllllllllIIlllIlIIllIllIIII);
        if (this.isChild()) {
            llllllllllllllIIlllIlIIllIllIIII.setBoolean("IsBaby", true);
        }
        llllllllllllllIIlllIlIIllIllIIII.setBoolean("CanBreakDoors", this.isBreakDoorsTaskSet());
    }
    
    @Override
    protected void setEquipmentBasedOnDifficulty(final DifficultyInstance llllllllllllllIIlllIlIIllIllllIl) {
        super.setEquipmentBasedOnDifficulty(llllllllllllllIIlllIlIIllIllllIl);
        if (this.rand.nextFloat() < ((this.world.getDifficulty() == EnumDifficulty.HARD) ? 0.05f : 0.01f)) {
            final int llllllllllllllIIlllIlIIllIllllII = this.rand.nextInt(3);
            if (llllllllllllllIIlllIlIIllIllllII == 0) {
                this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.IRON_SWORD));
            }
            else {
                this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.IRON_SHOVEL));
            }
        }
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.getDataManager().register(EntityZombie.IS_CHILD, false);
        this.getDataManager().register(EntityZombie.VILLAGER_TYPE, 0);
        this.getDataManager().register(EntityZombie.ARMS_RAISED, false);
    }
    
    @Override
    public void onDeath(final DamageSource llllllllllllllIIlllIlIIlIlIlIlIl) {
        super.onDeath(llllllllllllllIIlllIlIIlIlIlIlIl);
        if (llllllllllllllIIlllIlIIlIlIlIlIl.getEntity() instanceof EntityCreeper) {
            final EntityCreeper llllllllllllllIIlllIlIIlIlIllIII = (EntityCreeper)llllllllllllllIIlllIlIIlIlIlIlIl.getEntity();
            if (llllllllllllllIIlllIlIIlIlIllIII.getPowered() && llllllllllllllIIlllIlIIlIlIllIII.isAIEnabled()) {
                llllllllllllllIIlllIlIIlIlIllIII.incrementDroppedSkulls();
                final ItemStack llllllllllllllIIlllIlIIlIlIlIlll = this.func_190732_dj();
                if (!llllllllllllllIIlllIlIIlIlIlIlll.func_190926_b()) {
                    this.entityDropItem(llllllllllllllIIlllIlIIlIlIlIlll, 0.0f);
                }
            }
        }
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.23000000417232513);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0);
        this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(2.0);
        this.getAttributeMap().registerAttribute(EntityZombie.SPAWN_REINFORCEMENTS_CHANCE).setBaseValue(this.rand.nextDouble() * 0.10000000149011612);
    }
    
    @Override
    public void onLivingUpdate() {
        if (this.world.isDaytime() && !this.world.isRemote && !this.isChild() && this.func_190730_o()) {
            final float llllllllllllllIIlllIlIlIIIIIIlIl = this.getBrightness();
            if (llllllllllllllIIlllIlIlIIIIIIlIl > 0.5f && this.rand.nextFloat() * 30.0f < (llllllllllllllIIlllIlIlIIIIIIlIl - 0.4f) * 2.0f && this.world.canSeeSky(new BlockPos(this.posX, this.posY + this.getEyeHeight(), this.posZ))) {
                boolean llllllllllllllIIlllIlIlIIIIIIlII = true;
                final ItemStack llllllllllllllIIlllIlIlIIIIIIIll = this.getItemStackFromSlot(EntityEquipmentSlot.HEAD);
                if (!llllllllllllllIIlllIlIlIIIIIIIll.func_190926_b()) {
                    if (llllllllllllllIIlllIlIlIIIIIIIll.isItemStackDamageable()) {
                        llllllllllllllIIlllIlIlIIIIIIIll.setItemDamage(llllllllllllllIIlllIlIlIIIIIIIll.getItemDamage() + this.rand.nextInt(2));
                        if (llllllllllllllIIlllIlIlIIIIIIIll.getItemDamage() >= llllllllllllllIIlllIlIlIIIIIIIll.getMaxDamage()) {
                            this.renderBrokenItemStack(llllllllllllllIIlllIlIlIIIIIIIll);
                            this.setItemStackToSlot(EntityEquipmentSlot.HEAD, ItemStack.field_190927_a);
                        }
                    }
                    llllllllllllllIIlllIlIlIIIIIIlII = false;
                }
                if (llllllllllllllIIlllIlIlIIIIIIlII) {
                    this.setFire(8);
                }
            }
        }
        super.onLivingUpdate();
    }
    
    static {
        SPAWN_REINFORCEMENTS_CHANCE = new RangedAttribute(null, "zombie.spawnReinforcements", 0.0, 0.0, 1.0).setDescription("Spawn Reinforcements Chance");
        BABY_SPEED_BOOST_ID = UUID.fromString("B9766B59-9566-4402-BC1F-2EE2A276D836");
        BABY_SPEED_BOOST = new AttributeModifier(EntityZombie.BABY_SPEED_BOOST_ID, "Baby speed boost", 0.5, 1);
        IS_CHILD = EntityDataManager.createKey(EntityZombie.class, DataSerializers.BOOLEAN);
        VILLAGER_TYPE = EntityDataManager.createKey(EntityZombie.class, DataSerializers.VARINT);
        ARMS_RAISED = EntityDataManager.createKey(EntityZombie.class, DataSerializers.BOOLEAN);
    }
    
    @Override
    public void onKillEntity(final EntityLivingBase llllllllllllllIIlllIlIIllIlIIIII) {
        super.onKillEntity(llllllllllllllIIlllIlIIllIlIIIII);
        if ((this.world.getDifficulty() == EnumDifficulty.NORMAL || this.world.getDifficulty() == EnumDifficulty.HARD) && llllllllllllllIIlllIlIIllIlIIIII instanceof EntityVillager) {
            if (this.world.getDifficulty() != EnumDifficulty.HARD && this.rand.nextBoolean()) {
                return;
            }
            final EntityVillager llllllllllllllIIlllIlIIllIlIIIll = (EntityVillager)llllllllllllllIIlllIlIIllIlIIIII;
            final EntityZombieVillager llllllllllllllIIlllIlIIllIlIIIlI = new EntityZombieVillager(this.world);
            llllllllllllllIIlllIlIIllIlIIIlI.copyLocationAndAnglesFrom(llllllllllllllIIlllIlIIllIlIIIll);
            this.world.removeEntity(llllllllllllllIIlllIlIIllIlIIIll);
            llllllllllllllIIlllIlIIllIlIIIlI.onInitialSpawn(this.world.getDifficultyForLocation(new BlockPos(llllllllllllllIIlllIlIIllIlIIIlI)), new GroupData(false, (GroupData)null));
            llllllllllllllIIlllIlIIllIlIIIlI.func_190733_a(llllllllllllllIIlllIlIIllIlIIIll.getProfession());
            llllllllllllllIIlllIlIIllIlIIIlI.setChild(llllllllllllllIIlllIlIIllIlIIIll.isChild());
            llllllllllllllIIlllIlIIllIlIIIlI.setNoAI(llllllllllllllIIlllIlIIllIlIIIll.isAIDisabled());
            if (llllllllllllllIIlllIlIIllIlIIIll.hasCustomName()) {
                llllllllllllllIIlllIlIIllIlIIIlI.setCustomNameTag(llllllllllllllIIlllIlIIllIlIIIll.getCustomNameTag());
                llllllllllllllIIlllIlIIllIlIIIlI.setAlwaysRenderNameTag(llllllllllllllIIlllIlIIllIlIIIll.getAlwaysRenderNameTag());
            }
            this.world.spawnEntityInWorld(llllllllllllllIIlllIlIIllIlIIIlI);
            this.world.playEvent(null, 1026, new BlockPos(this), 0);
        }
    }
    
    protected final void multiplySize(final float llllllllllllllIIlllIlIIlIllIIIlI) {
        super.setSize(this.zombieWidth * llllllllllllllIIlllIlIIlIllIIIlI, this.zombieHeight * llllllllllllllIIlllIlIIlIllIIIlI);
    }
    
    @Override
    public double getYOffset() {
        return this.isChild() ? 0.0 : -0.45;
    }
    
    public boolean isBreakDoorsTaskSet() {
        return this.isBreakDoorsTaskSet;
    }
    
    @Override
    protected boolean canEquipItem(final ItemStack llllllllllllllIIlllIlIIllIIlIlII) {
        return (llllllllllllllIIlllIlIIllIIlIlII.getItem() != Items.EGG || !this.isChild() || !this.isRiding()) && super.canEquipItem(llllllllllllllIIlllIlIIllIIlIlII);
    }
    
    @Nullable
    @Override
    protected ResourceLocation getLootTable() {
        return LootTableList.ENTITIES_ZOMBIE;
    }
    
    public static void registerFixesZombie(final DataFixer llllllllllllllIIlllIlIIllIllIllI) {
        EntityLiving.registerFixesMob(llllllllllllllIIlllIlIIllIllIllI, EntityZombie.class);
    }
    
    protected void applyEntityAI() {
        this.tasks.addTask(6, new EntityAIMoveThroughVillage(this, 1.0, false));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, (Class<?>[])new Class[] { EntityPigZombie.class }));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget<Object>(this, EntityPlayer.class, true));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget<Object>(this, EntityVillager.class, false));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget<Object>(this, EntityIronGolem.class, true));
    }
    
    @Override
    public boolean attackEntityAsMob(final Entity llllllllllllllIIlllIlIIlllIlIIII) {
        final boolean llllllllllllllIIlllIlIIlllIlIIll = super.attackEntityAsMob(llllllllllllllIIlllIlIIlllIlIIII);
        if (llllllllllllllIIlllIlIIlllIlIIll) {
            final float llllllllllllllIIlllIlIIlllIlIIlI = this.world.getDifficultyForLocation(new BlockPos(this)).getAdditionalDifficulty();
            if (this.getHeldItemMainhand().func_190926_b() && this.isBurning() && this.rand.nextFloat() < llllllllllllllIIlllIlIIlllIlIIlI * 0.3f) {
                llllllllllllllIIlllIlIIlllIlIIII.setFire(2 * (int)llllllllllllllIIlllIlIIlllIlIIlI);
            }
        }
        return llllllllllllllIIlllIlIIlllIlIIll;
    }
    
    @Override
    protected void playStepSound(final BlockPos llllllllllllllIIlllIlIIlllIIIllI, final Block llllllllllllllIIlllIlIIlllIIIlIl) {
        this.playSound(this.func_190731_di(), 0.15f, 1.0f);
    }
    
    public boolean isArmsRaised() {
        return this.getDataManager().get(EntityZombie.ARMS_RAISED);
    }
    
    @Override
    public void notifyDataManagerChange(final DataParameter<?> llllllllllllllIIlllIlIlIIIIIlIll) {
        if (EntityZombie.IS_CHILD.equals(llllllllllllllIIlllIlIlIIIIIlIll)) {
            this.setChildSize(this.isChild());
        }
        super.notifyDataManagerChange(llllllllllllllIIlllIlIlIIIIIlIll);
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource llllllllllllllIIlllIlIIllllIIlII, final float llllllllllllllIIlllIlIIllllIllll) {
        if (super.attackEntityFrom(llllllllllllllIIlllIlIIllllIIlII, llllllllllllllIIlllIlIIllllIllll)) {
            EntityLivingBase llllllllllllllIIlllIlIIllllIlllI = this.getAttackTarget();
            if (llllllllllllllIIlllIlIIllllIlllI == null && llllllllllllllIIlllIlIIllllIIlII.getEntity() instanceof EntityLivingBase) {
                llllllllllllllIIlllIlIIllllIlllI = (EntityLivingBase)llllllllllllllIIlllIlIIllllIIlII.getEntity();
            }
            if (llllllllllllllIIlllIlIIllllIlllI != null && this.world.getDifficulty() == EnumDifficulty.HARD && this.rand.nextFloat() < this.getEntityAttribute(EntityZombie.SPAWN_REINFORCEMENTS_CHANCE).getAttributeValue() && this.world.getGameRules().getBoolean("doMobSpawning")) {
                final int llllllllllllllIIlllIlIIllllIllIl = MathHelper.floor(this.posX);
                final int llllllllllllllIIlllIlIIllllIllII = MathHelper.floor(this.posY);
                final int llllllllllllllIIlllIlIIllllIlIll = MathHelper.floor(this.posZ);
                final EntityZombie llllllllllllllIIlllIlIIllllIlIlI = new EntityZombie(this.world);
                for (int llllllllllllllIIlllIlIIllllIlIIl = 0; llllllllllllllIIlllIlIIllllIlIIl < 50; ++llllllllllllllIIlllIlIIllllIlIIl) {
                    final int llllllllllllllIIlllIlIIllllIlIII = llllllllllllllIIlllIlIIllllIllIl + MathHelper.getInt(this.rand, 7, 40) * MathHelper.getInt(this.rand, -1, 1);
                    final int llllllllllllllIIlllIlIIllllIIlll = llllllllllllllIIlllIlIIllllIllII + MathHelper.getInt(this.rand, 7, 40) * MathHelper.getInt(this.rand, -1, 1);
                    final int llllllllllllllIIlllIlIIllllIIllI = llllllllllllllIIlllIlIIllllIlIll + MathHelper.getInt(this.rand, 7, 40) * MathHelper.getInt(this.rand, -1, 1);
                    if (this.world.getBlockState(new BlockPos(llllllllllllllIIlllIlIIllllIlIII, llllllllllllllIIlllIlIIllllIIlll - 1, llllllllllllllIIlllIlIIllllIIllI)).isFullyOpaque() && this.world.getLightFromNeighbors(new BlockPos(llllllllllllllIIlllIlIIllllIlIII, llllllllllllllIIlllIlIIllllIIlll, llllllllllllllIIlllIlIIllllIIllI)) < 10) {
                        llllllllllllllIIlllIlIIllllIlIlI.setPosition(llllllllllllllIIlllIlIIllllIlIII, llllllllllllllIIlllIlIIllllIIlll, llllllllllllllIIlllIlIIllllIIllI);
                        if (!this.world.isAnyPlayerWithinRangeAt(llllllllllllllIIlllIlIIllllIlIII, llllllllllllllIIlllIlIIllllIIlll, llllllllllllllIIlllIlIIllllIIllI, 7.0) && this.world.checkNoEntityCollision(llllllllllllllIIlllIlIIllllIlIlI.getEntityBoundingBox(), llllllllllllllIIlllIlIIllllIlIlI) && this.world.getCollisionBoxes(llllllllllllllIIlllIlIIllllIlIlI, llllllllllllllIIlllIlIIllllIlIlI.getEntityBoundingBox()).isEmpty() && !this.world.containsAnyLiquid(llllllllllllllIIlllIlIIllllIlIlI.getEntityBoundingBox())) {
                            this.world.spawnEntityInWorld(llllllllllllllIIlllIlIIllllIlIlI);
                            llllllllllllllIIlllIlIIllllIlIlI.setAttackTarget(llllllllllllllIIlllIlIIllllIlllI);
                            llllllllllllllIIlllIlIIllllIlIlI.onInitialSpawn(this.world.getDifficultyForLocation(new BlockPos(llllllllllllllIIlllIlIIllllIlIlI)), null);
                            this.getEntityAttribute(EntityZombie.SPAWN_REINFORCEMENTS_CHANCE).applyModifier(new AttributeModifier("Zombie reinforcement caller charge", -0.05000000074505806, 0));
                            llllllllllllllIIlllIlIIllllIlIlI.getEntityAttribute(EntityZombie.SPAWN_REINFORCEMENTS_CHANCE).applyModifier(new AttributeModifier("Zombie reinforcement callee charge", -0.05000000074505806, 0));
                            break;
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }
    
    @Override
    protected int getExperiencePoints(final EntityPlayer llllllllllllllIIlllIlIlIIIIllIlI) {
        if (this.isChild()) {
            this.experienceValue *= (int)2.5f;
        }
        return super.getExperiencePoints(llllllllllllllIIlllIlIlIIIIllIlI);
    }
    
    protected ItemStack func_190732_dj() {
        return new ItemStack(Items.SKULL, 1, 2);
    }
    
    protected SoundEvent func_190731_di() {
        return SoundEvents.ENTITY_ZOMBIE_STEP;
    }
    
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_ZOMBIE_AMBIENT;
    }
    
    class GroupData implements IEntityLivingData
    {
        public /* synthetic */ boolean isChild;
        
        private GroupData(final boolean lllllllllllllIlIlIlllIIIlIIIIlll) {
            this.isChild = lllllllllllllIlIlIlllIIIlIIIIlll;
        }
    }
}
