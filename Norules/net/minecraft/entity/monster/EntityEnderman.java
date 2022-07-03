package net.minecraft.entity.monster;

import net.minecraft.block.state.*;
import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.nbt.*;
import net.minecraft.block.material.*;
import net.minecraft.util.datafix.*;
import net.minecraft.world.*;
import net.minecraft.pathfinding.*;
import javax.annotation.*;
import net.minecraft.world.storage.loot.*;
import net.minecraft.entity.player.*;
import net.minecraft.init.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import com.google.common.collect.*;
import net.minecraft.network.datasync.*;
import java.util.*;
import net.minecraft.util.math.*;
import com.google.common.base.*;

public class EntityEnderman extends EntityMob
{
    private static final /* synthetic */ DataParameter<Boolean> SCREAMING;
    private static final /* synthetic */ DataParameter<Optional<IBlockState>> CARRIED_BLOCK;
    private /* synthetic */ int targetChangeTime;
    private static final /* synthetic */ Set<Block> CARRIABLE_BLOCKS;
    private /* synthetic */ int lastCreepySound;
    private static final /* synthetic */ UUID ATTACKING_SPEED_BOOST_ID;
    private static final /* synthetic */ AttributeModifier ATTACKING_SPEED_BOOST;
    
    @Override
    protected void dropEquipment(final boolean lllllllllllllIIlIIIlIlllllllIlIl, final int lllllllllllllIIlIIIlIlllllllIlII) {
        super.dropEquipment(lllllllllllllIIlIIIlIlllllllIlIl, lllllllllllllIIlIIIlIlllllllIlII);
        final IBlockState lllllllllllllIIlIIIlIllllllllIIl = this.getHeldBlockState();
        if (lllllllllllllIIlIIIlIllllllllIIl != null) {
            final Item lllllllllllllIIlIIIlIllllllllIII = Item.getItemFromBlock(lllllllllllllIIlIIIlIllllllllIIl.getBlock());
            final int lllllllllllllIIlIIIlIlllllllIlll = lllllllllllllIIlIIIlIllllllllIII.getHasSubtypes() ? lllllllllllllIIlIIIlIllllllllIIl.getBlock().getMetaFromState(lllllllllllllIIlIIIlIllllllllIIl) : 0;
            this.entityDropItem(new ItemStack(lllllllllllllIIlIIIlIllllllllIII, 1, lllllllllllllIIlIIIlIlllllllIlll), 0.0f);
        }
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound lllllllllllllIIlIIIllIIIIlIlllII) {
        super.readEntityFromNBT(lllllllllllllIIlIIIllIIIIlIlllII);
        IBlockState lllllllllllllIIlIIIllIIIIlIllllI = null;
        if (lllllllllllllIIlIIIllIIIIlIlllII.hasKey("carried", 8)) {
            final IBlockState lllllllllllllIIlIIIllIIIIlIlllll = Block.getBlockFromName(lllllllllllllIIlIIIllIIIIlIlllII.getString("carried")).getStateFromMeta(lllllllllllllIIlIIIllIIIIlIlllII.getShort("carriedData") & 0xFFFF);
        }
        else {
            lllllllllllllIIlIIIllIIIIlIllllI = Block.getBlockById(lllllllllllllIIlIIIllIIIIlIlllII.getShort("carried")).getStateFromMeta(lllllllllllllIIlIIIllIIIIlIlllII.getShort("carriedData") & 0xFFFF);
        }
        if (lllllllllllllIIlIIIllIIIIlIllllI == null || lllllllllllllIIlIIIllIIIIlIllllI.getBlock() == null || lllllllllllllIIlIIIllIIIIlIllllI.getMaterial() == Material.AIR) {
            lllllllllllllIIlIIIllIIIIlIllllI = null;
        }
        this.setHeldBlockState(lllllllllllllIIlIIIllIIIIlIllllI);
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound lllllllllllllIIlIIIllIIIIllIlIIl) {
        super.writeEntityToNBT(lllllllllllllIIlIIIllIIIIllIlIIl);
        final IBlockState lllllllllllllIIlIIIllIIIIllIlIII = this.getHeldBlockState();
        if (lllllllllllllIIlIIIllIIIIllIlIII != null) {
            lllllllllllllIIlIIIllIIIIllIlIIl.setShort("carried", (short)Block.getIdFromBlock(lllllllllllllIIlIIIllIIIIllIlIII.getBlock()));
            lllllllllllllIIlIIIllIIIIllIlIIl.setShort("carriedData", (short)lllllllllllllIIlIIIllIIIIllIlIII.getBlock().getMetaFromState(lllllllllllllIIlIIIllIIIIllIlIII));
        }
    }
    
    public static void registerFixesEnderman(final DataFixer lllllllllllllIIlIIIllIIIIllIlllI) {
        EntityLiving.registerFixesMob(lllllllllllllIIlIIIllIIIIllIlllI, EntityEnderman.class);
    }
    
    protected boolean teleportRandomly() {
        final double lllllllllllllIIlIIIllIIIIIllIIll = this.posX + (this.rand.nextDouble() - 0.5) * 64.0;
        final double lllllllllllllIIlIIIllIIIIIllIIlI = this.posY + (this.rand.nextInt(64) - 32);
        final double lllllllllllllIIlIIIllIIIIIllIIIl = this.posZ + (this.rand.nextDouble() - 0.5) * 64.0;
        return this.teleportTo(lllllllllllllIIlIIIllIIIIIllIIll, lllllllllllllIIlIIIllIIIIIllIIlI, lllllllllllllIIlIIIllIIIIIllIIIl);
    }
    
    public EntityEnderman(final World lllllllllllllIIlIIIllIIIlIIIllII) {
        super(lllllllllllllIIlIIIllIIIlIIIllII);
        this.setSize(0.6f, 2.9f);
        this.stepHeight = 1.0f;
        this.setPathPriority(PathNodeType.WATER, -1.0f);
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40.0);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.30000001192092896);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(7.0);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(64.0);
    }
    
    @Nullable
    public IBlockState getHeldBlockState() {
        return (IBlockState)this.dataManager.get(EntityEnderman.CARRIED_BLOCK).orNull();
    }
    
    public void setHeldBlockState(@Nullable final IBlockState lllllllllllllIIlIIIlIllllllIIlll) {
        this.dataManager.set(EntityEnderman.CARRIED_BLOCK, (Optional<IBlockState>)Optional.fromNullable((Object)lllllllllllllIIlIIIlIllllllIIlll));
    }
    
    public boolean isScreaming() {
        return this.dataManager.get(EntityEnderman.SCREAMING);
    }
    
    @Nullable
    @Override
    protected ResourceLocation getLootTable() {
        return LootTableList.ENTITIES_ENDERMAN;
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource lllllllllllllIIlIIIlIlllllIIIlll, final float lllllllllllllIIlIIIlIlllllIIIlIl) {
        if (this.isEntityInvulnerable(lllllllllllllIIlIIIlIlllllIIIlll)) {
            return false;
        }
        if (lllllllllllllIIlIIIlIlllllIIIlll instanceof EntityDamageSourceIndirect) {
            for (int lllllllllllllIIlIIIlIlllllIIlIlI = 0; lllllllllllllIIlIIIlIlllllIIlIlI < 64; ++lllllllllllllIIlIIIlIlllllIIlIlI) {
                if (this.teleportRandomly()) {
                    return true;
                }
            }
            return false;
        }
        final boolean lllllllllllllIIlIIIlIlllllIIlIIl = super.attackEntityFrom(lllllllllllllIIlIIIlIlllllIIIlll, lllllllllllllIIlIIIlIlllllIIIlIl);
        if (lllllllllllllIIlIIIlIlllllIIIlll.isUnblockable() && this.rand.nextInt(10) != 0) {
            this.teleportRandomly();
        }
        return lllllllllllllIIlIIIlIlllllIIlIIl;
    }
    
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_ENDERMEN_DEATH;
    }
    
    @Override
    protected void updateAITasks() {
        if (this.isWet()) {
            this.attackEntityFrom(DamageSource.drown, 1.0f);
        }
        if (this.world.isDaytime() && this.ticksExisted >= this.targetChangeTime + 600) {
            final float lllllllllllllIIlIIIllIIIIIlllIll = this.getBrightness();
            if (lllllllllllllIIlIIIllIIIIIlllIll > 0.5f && this.world.canSeeSky(new BlockPos(this)) && this.rand.nextFloat() * 30.0f < (lllllllllllllIIlIIIllIIIIIlllIll - 0.4f) * 2.0f) {
                this.setAttackTarget(null);
                this.teleportRandomly();
            }
        }
        super.updateAITasks();
    }
    
    public void playEndermanSound() {
        if (this.ticksExisted >= this.lastCreepySound + 400) {
            this.lastCreepySound = this.ticksExisted;
            if (!this.isSilent()) {
                this.world.playSound(this.posX, this.posY + this.getEyeHeight(), this.posZ, SoundEvents.ENTITY_ENDERMEN_STARE, this.getSoundCategory(), 2.5f, 1.0f, false);
            }
        }
    }
    
    private boolean shouldAttackPlayer(final EntityPlayer lllllllllllllIIlIIIllIIIIlIIlIll) {
        final ItemStack lllllllllllllIIlIIIllIIIIlIlIIIl = lllllllllllllIIlIIIllIIIIlIIlIll.inventory.armorInventory.get(3);
        if (lllllllllllllIIlIIIllIIIIlIlIIIl.getItem() == Item.getItemFromBlock(Blocks.PUMPKIN)) {
            return false;
        }
        final Vec3d lllllllllllllIIlIIIllIIIIlIlIIII = lllllllllllllIIlIIIllIIIIlIIlIll.getLook(1.0f).normalize();
        Vec3d lllllllllllllIIlIIIllIIIIlIIllll = new Vec3d(this.posX - lllllllllllllIIlIIIllIIIIlIIlIll.posX, this.getEntityBoundingBox().minY + this.getEyeHeight() - (lllllllllllllIIlIIIllIIIIlIIlIll.posY + lllllllllllllIIlIIIllIIIIlIIlIll.getEyeHeight()), this.posZ - lllllllllllllIIlIIIllIIIIlIIlIll.posZ);
        final double lllllllllllllIIlIIIllIIIIlIIlllI = lllllllllllllIIlIIIllIIIIlIIllll.lengthVector();
        lllllllllllllIIlIIIllIIIIlIIllll = lllllllllllllIIlIIIllIIIIlIIllll.normalize();
        final double lllllllllllllIIlIIIllIIIIlIIllIl = lllllllllllllIIlIIIllIIIIlIlIIII.dotProduct(lllllllllllllIIlIIIllIIIIlIIllll);
        return lllllllllllllIIlIIIllIIIIlIIllIl > 1.0 - 0.025 / lllllllllllllIIlIIIllIIIIlIIlllI && lllllllllllllIIlIIIllIIIIlIIlIll.canEntityBeSeen(this);
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(EntityEnderman.CARRIED_BLOCK, (Optional<IBlockState>)Optional.absent());
        this.dataManager.register(EntityEnderman.SCREAMING, false);
    }
    
    @Override
    public void setAttackTarget(@Nullable final EntityLivingBase lllllllllllllIIlIIIllIIIIllllllI) {
        super.setAttackTarget(lllllllllllllIIlIIIllIIIIllllllI);
        final IAttributeInstance lllllllllllllIIlIIIllIIIlIIIIIII = this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED);
        if (lllllllllllllIIlIIIllIIIIllllllI == null) {
            this.targetChangeTime = 0;
            this.dataManager.set(EntityEnderman.SCREAMING, false);
            lllllllllllllIIlIIIllIIIlIIIIIII.removeModifier(EntityEnderman.ATTACKING_SPEED_BOOST);
        }
        else {
            this.targetChangeTime = this.ticksExisted;
            this.dataManager.set(EntityEnderman.SCREAMING, true);
            if (!lllllllllllllIIlIIIllIIIlIIIIIII.hasModifier(EntityEnderman.ATTACKING_SPEED_BOOST)) {
                lllllllllllllIIlIIIllIIIlIIIIIII.applyModifier(EntityEnderman.ATTACKING_SPEED_BOOST);
            }
        }
    }
    
    @Override
    protected SoundEvent getAmbientSound() {
        return this.isScreaming() ? SoundEvents.ENTITY_ENDERMEN_SCREAM : SoundEvents.ENTITY_ENDERMEN_AMBIENT;
    }
    
    @Override
    public void onLivingUpdate() {
        if (this.world.isRemote) {
            for (int lllllllllllllIIlIIIllIIIIlIIIIIl = 0; lllllllllllllIIlIIIllIIIIlIIIIIl < 2; ++lllllllllllllIIlIIIllIIIIlIIIIIl) {
                this.world.spawnParticle(EnumParticleTypes.PORTAL, this.posX + (this.rand.nextDouble() - 0.5) * this.width, this.posY + this.rand.nextDouble() * this.height - 0.25, this.posZ + (this.rand.nextDouble() - 0.5) * this.width, (this.rand.nextDouble() - 0.5) * 2.0, -this.rand.nextDouble(), (this.rand.nextDouble() - 0.5) * 2.0, new int[0]);
            }
        }
        this.isJumping = false;
        super.onLivingUpdate();
    }
    
    @Override
    public float getEyeHeight() {
        return 2.55f;
    }
    
    @Override
    protected void initEntityAI() {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIAttackMelee(this, 1.0, false));
        this.tasks.addTask(7, new EntityAIWanderAvoidWater(this, 1.0, 0.0f));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0f));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.tasks.addTask(10, new AIPlaceBlock(this));
        this.tasks.addTask(11, new AITakeBlock(this));
        this.targetTasks.addTask(1, new AIFindPlayer(this));
        this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false, (Class<?>[])new Class[0]));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget<Object>(this, EntityEndermite.class, 10, true, false, (com.google.common.base.Predicate<?>)new Predicate<EntityEndermite>() {
            public boolean apply(@Nullable final EntityEndermite lllllllllllllIllIlIIlIlIlIIlIlII) {
                return lllllllllllllIllIlIIlIlIlIIlIlII.isSpawnedByPlayer();
            }
        }));
    }
    
    private boolean teleportTo(final double lllllllllllllIIlIIIllIIIIIIlIIIl, final double lllllllllllllIIlIIIllIIIIIIIlIll, final double lllllllllllllIIlIIIllIIIIIIIllll) {
        final boolean lllllllllllllIIlIIIllIIIIIIIlllI = this.attemptTeleport(lllllllllllllIIlIIIllIIIIIIlIIIl, lllllllllllllIIlIIIllIIIIIIIlIll, lllllllllllllIIlIIIllIIIIIIIllll);
        if (lllllllllllllIIlIIIllIIIIIIIlllI) {
            this.world.playSound(null, this.prevPosX, this.prevPosY, this.prevPosZ, SoundEvents.ENTITY_ENDERMEN_TELEPORT, this.getSoundCategory(), 1.0f, 1.0f);
            this.playSound(SoundEvents.ENTITY_ENDERMEN_TELEPORT, 1.0f, 1.0f);
        }
        return lllllllllllllIIlIIIllIIIIIIIlllI;
    }
    
    @Override
    protected SoundEvent getHurtSound(final DamageSource lllllllllllllIIlIIIllIIIIIIIIlII) {
        return SoundEvents.ENTITY_ENDERMEN_HURT;
    }
    
    static {
        ATTACKING_SPEED_BOOST_ID = UUID.fromString("020E0DFB-87AE-4653-9556-831010E291A0");
        ATTACKING_SPEED_BOOST = new AttributeModifier(EntityEnderman.ATTACKING_SPEED_BOOST_ID, "Attacking speed boost", 0.15000000596046448, 0).setSaved(false);
        CARRIABLE_BLOCKS = Sets.newIdentityHashSet();
        CARRIED_BLOCK = EntityDataManager.createKey(EntityEnderman.class, DataSerializers.OPTIONAL_BLOCK_STATE);
        SCREAMING = EntityDataManager.createKey(EntityEnderman.class, DataSerializers.BOOLEAN);
        EntityEnderman.CARRIABLE_BLOCKS.add(Blocks.GRASS);
        EntityEnderman.CARRIABLE_BLOCKS.add(Blocks.DIRT);
        EntityEnderman.CARRIABLE_BLOCKS.add(Blocks.SAND);
        EntityEnderman.CARRIABLE_BLOCKS.add(Blocks.GRAVEL);
        EntityEnderman.CARRIABLE_BLOCKS.add(Blocks.YELLOW_FLOWER);
        EntityEnderman.CARRIABLE_BLOCKS.add(Blocks.RED_FLOWER);
        EntityEnderman.CARRIABLE_BLOCKS.add(Blocks.BROWN_MUSHROOM);
        EntityEnderman.CARRIABLE_BLOCKS.add(Blocks.RED_MUSHROOM);
        EntityEnderman.CARRIABLE_BLOCKS.add(Blocks.TNT);
        EntityEnderman.CARRIABLE_BLOCKS.add(Blocks.CACTUS);
        EntityEnderman.CARRIABLE_BLOCKS.add(Blocks.CLAY);
        EntityEnderman.CARRIABLE_BLOCKS.add(Blocks.PUMPKIN);
        EntityEnderman.CARRIABLE_BLOCKS.add(Blocks.MELON_BLOCK);
        EntityEnderman.CARRIABLE_BLOCKS.add(Blocks.MYCELIUM);
        EntityEnderman.CARRIABLE_BLOCKS.add(Blocks.NETHERRACK);
    }
    
    protected boolean teleportToEntity(final Entity lllllllllllllIIlIIIllIIIIIlIIlII) {
        Vec3d lllllllllllllIIlIIIllIIIIIlIIIll = new Vec3d(this.posX - lllllllllllllIIlIIIllIIIIIlIIlII.posX, this.getEntityBoundingBox().minY + this.height / 2.0f - lllllllllllllIIlIIIllIIIIIlIIlII.posY + lllllllllllllIIlIIIllIIIIIlIIlII.getEyeHeight(), this.posZ - lllllllllllllIIlIIIllIIIIIlIIlII.posZ);
        lllllllllllllIIlIIIllIIIIIlIIIll = lllllllllllllIIlIIIllIIIIIlIIIll.normalize();
        final double lllllllllllllIIlIIIllIIIIIlIIIlI = 16.0;
        final double lllllllllllllIIlIIIllIIIIIlIIIIl = this.posX + (this.rand.nextDouble() - 0.5) * 8.0 - lllllllllllllIIlIIIllIIIIIlIIIll.xCoord * 16.0;
        final double lllllllllllllIIlIIIllIIIIIlIIIII = this.posY + (this.rand.nextInt(16) - 8) - lllllllllllllIIlIIIllIIIIIlIIIll.yCoord * 16.0;
        final double lllllllllllllIIlIIIllIIIIIIlllll = this.posZ + (this.rand.nextDouble() - 0.5) * 8.0 - lllllllllllllIIlIIIllIIIIIlIIIll.zCoord * 16.0;
        return this.teleportTo(lllllllllllllIIlIIIllIIIIIlIIIIl, lllllllllllllIIlIIIllIIIIIlIIIII, lllllllllllllIIlIIIllIIIIIIlllll);
    }
    
    @Override
    public void notifyDataManagerChange(final DataParameter<?> lllllllllllllIIlIIIllIIIIlllIIIl) {
        if (EntityEnderman.SCREAMING.equals(lllllllllllllIIlIIIllIIIIlllIIIl) && this.isScreaming() && this.world.isRemote) {
            this.playEndermanSound();
        }
        super.notifyDataManagerChange(lllllllllllllIIlIIIllIIIIlllIIIl);
    }
    
    static class AITakeBlock extends EntityAIBase
    {
        private final /* synthetic */ EntityEnderman enderman;
        
        @Override
        public boolean shouldExecute() {
            return this.enderman.getHeldBlockState() == null && this.enderman.world.getGameRules().getBoolean("mobGriefing") && this.enderman.getRNG().nextInt(20) == 0;
        }
        
        public AITakeBlock() {
        }
        
        @Override
        public void updateTask() {
            final Random lllllllllllllIlIllIIlIlIllllIlll = this.enderman.getRNG();
            final World lllllllllllllIlIllIIlIlIllllIllI = this.enderman.world;
            final int lllllllllllllIlIllIIlIlIllllIlIl = MathHelper.floor(this.enderman.posX - 2.0 + lllllllllllllIlIllIIlIlIllllIlll.nextDouble() * 4.0);
            final int lllllllllllllIlIllIIlIlIllllIlII = MathHelper.floor(this.enderman.posY + lllllllllllllIlIllIIlIlIllllIlll.nextDouble() * 3.0);
            final int lllllllllllllIlIllIIlIlIllllIIll = MathHelper.floor(this.enderman.posZ - 2.0 + lllllllllllllIlIllIIlIlIllllIlll.nextDouble() * 4.0);
            final BlockPos lllllllllllllIlIllIIlIlIllllIIlI = new BlockPos(lllllllllllllIlIllIIlIlIllllIlIl, lllllllllllllIlIllIIlIlIllllIlII, lllllllllllllIlIllIIlIlIllllIIll);
            final IBlockState lllllllllllllIlIllIIlIlIllllIIIl = lllllllllllllIlIllIIlIlIllllIllI.getBlockState(lllllllllllllIlIllIIlIlIllllIIlI);
            final Block lllllllllllllIlIllIIlIlIllllIIII = lllllllllllllIlIllIIlIlIllllIIIl.getBlock();
            final RayTraceResult lllllllllllllIlIllIIlIlIlllIllll = lllllllllllllIlIllIIlIlIllllIllI.rayTraceBlocks(new Vec3d(MathHelper.floor(this.enderman.posX) + 0.5f, lllllllllllllIlIllIIlIlIllllIlII + 0.5f, MathHelper.floor(this.enderman.posZ) + 0.5f), new Vec3d(lllllllllllllIlIllIIlIlIllllIlIl + 0.5f, lllllllllllllIlIllIIlIlIllllIlII + 0.5f, lllllllllllllIlIllIIlIlIllllIIll + 0.5f), false, true, false);
            final boolean lllllllllllllIlIllIIlIlIlllIlllI = lllllllllllllIlIllIIlIlIlllIllll != null && lllllllllllllIlIllIIlIlIlllIllll.getBlockPos().equals(lllllllllllllIlIllIIlIlIllllIIlI);
            if (EntityEnderman.CARRIABLE_BLOCKS.contains(lllllllllllllIlIllIIlIlIllllIIII) && lllllllllllllIlIllIIlIlIlllIlllI) {
                this.enderman.setHeldBlockState(lllllllllllllIlIllIIlIlIllllIIIl);
                lllllllllllllIlIllIIlIlIllllIllI.setBlockToAir(lllllllllllllIlIllIIlIlIllllIIlI);
            }
        }
    }
    
    static class AIPlaceBlock extends EntityAIBase
    {
        private final /* synthetic */ EntityEnderman enderman;
        
        @Override
        public boolean shouldExecute() {
            return this.enderman.getHeldBlockState() != null && this.enderman.world.getGameRules().getBoolean("mobGriefing") && this.enderman.getRNG().nextInt(2000) == 0;
        }
        
        @Override
        public void updateTask() {
            final Random lllllllllllllIIIlIIllIIlIlIIIlIl = this.enderman.getRNG();
            final World lllllllllllllIIIlIIllIIlIlIIIlII = this.enderman.world;
            final int lllllllllllllIIIlIIllIIlIlIIIIll = MathHelper.floor(this.enderman.posX - 1.0 + lllllllllllllIIIlIIllIIlIlIIIlIl.nextDouble() * 2.0);
            final int lllllllllllllIIIlIIllIIlIlIIIIlI = MathHelper.floor(this.enderman.posY + lllllllllllllIIIlIIllIIlIlIIIlIl.nextDouble() * 2.0);
            final int lllllllllllllIIIlIIllIIlIlIIIIIl = MathHelper.floor(this.enderman.posZ - 1.0 + lllllllllllllIIIlIIllIIlIlIIIlIl.nextDouble() * 2.0);
            final BlockPos lllllllllllllIIIlIIllIIlIlIIIIII = new BlockPos(lllllllllllllIIIlIIllIIlIlIIIIll, lllllllllllllIIIlIIllIIlIlIIIIlI, lllllllllllllIIIlIIllIIlIlIIIIIl);
            final IBlockState lllllllllllllIIIlIIllIIlIIllllll = lllllllllllllIIIlIIllIIlIlIIIlII.getBlockState(lllllllllllllIIIlIIllIIlIlIIIIII);
            final IBlockState lllllllllllllIIIlIIllIIlIIlllllI = lllllllllllllIIIlIIllIIlIlIIIlII.getBlockState(lllllllllllllIIIlIIllIIlIlIIIIII.down());
            final IBlockState lllllllllllllIIIlIIllIIlIIllllIl = this.enderman.getHeldBlockState();
            if (lllllllllllllIIIlIIllIIlIIllllIl != null && this.canPlaceBlock(lllllllllllllIIIlIIllIIlIlIIIlII, lllllllllllllIIIlIIllIIlIlIIIIII, lllllllllllllIIIlIIllIIlIIllllIl.getBlock(), lllllllllllllIIIlIIllIIlIIllllll, lllllllllllllIIIlIIllIIlIIlllllI)) {
                lllllllllllllIIIlIIllIIlIlIIIlII.setBlockState(lllllllllllllIIIlIIllIIlIlIIIIII, lllllllllllllIIIlIIllIIlIIllllIl, 3);
                this.enderman.setHeldBlockState(null);
            }
        }
        
        private boolean canPlaceBlock(final World lllllllllllllIIIlIIllIIlIIlIllII, final BlockPos lllllllllllllIIIlIIllIIlIIlIIllI, final Block lllllllllllllIIIlIIllIIlIIlIIlIl, final IBlockState lllllllllllllIIIlIIllIIlIIlIIlII, final IBlockState lllllllllllllIIIlIIllIIlIIlIlIII) {
            return lllllllllllllIIIlIIllIIlIIlIIlIl.canPlaceBlockAt(lllllllllllllIIIlIIllIIlIIlIllII, lllllllllllllIIIlIIllIIlIIlIIllI) && lllllllllllllIIIlIIllIIlIIlIIlII.getMaterial() == Material.AIR && lllllllllllllIIIlIIllIIlIIlIlIII.getMaterial() != Material.AIR && lllllllllllllIIIlIIllIIlIIlIlIII.isFullCube();
        }
        
        public AIPlaceBlock() {
        }
    }
    
    static class AIFindPlayer extends EntityAINearestAttackableTarget<EntityPlayer>
    {
        private /* synthetic */ int teleportTime;
        private /* synthetic */ int aggroTime;
        private /* synthetic */ EntityPlayer player;
        private final /* synthetic */ EntityEnderman enderman;
        
        @Override
        public boolean shouldExecute() {
            final double lllllllllllllIIlllIllIlIllllIIll = this.getTargetDistance();
            this.player = this.enderman.world.getNearestAttackablePlayer(this.enderman.posX, this.enderman.posY, this.enderman.posZ, lllllllllllllIIlllIllIlIllllIIll, lllllllllllllIIlllIllIlIllllIIll, null, (Predicate<EntityPlayer>)new Predicate<EntityPlayer>() {
                public boolean apply(@Nullable final EntityPlayer llllllllllllllllllIlllIlllIlllIl) {
                    return llllllllllllllllllIlllIlllIlllIl != null && EntityEnderman.this.shouldAttackPlayer(llllllllllllllllllIlllIlllIlllIl);
                }
            });
            return this.player != null;
        }
        
        @Override
        public boolean continueExecuting() {
            if (this.player == null) {
                return (this.targetEntity != null && ((EntityPlayer)this.targetEntity).isEntityAlive()) || super.continueExecuting();
            }
            if (!EntityEnderman.this.shouldAttackPlayer(this.player)) {
                return false;
            }
            this.enderman.faceEntity(this.player, 10.0f, 10.0f);
            return true;
        }
        
        public AIFindPlayer() {
            super(EntityEnderman.this, EntityPlayer.class, false);
        }
        
        @Override
        public void updateTask() {
            if (this.player != null) {
                if (--this.aggroTime <= 0) {
                    this.targetEntity = (T)this.player;
                    this.player = null;
                    super.startExecuting();
                }
            }
            else {
                if (this.targetEntity != null) {
                    if (EntityEnderman.this.shouldAttackPlayer((EntityPlayer)this.targetEntity)) {
                        if (((EntityPlayer)this.targetEntity).getDistanceSqToEntity(this.enderman) < 16.0) {
                            this.enderman.teleportRandomly();
                        }
                        this.teleportTime = 0;
                    }
                    else if (((EntityPlayer)this.targetEntity).getDistanceSqToEntity(this.enderman) > 256.0 && this.teleportTime++ >= 30 && this.enderman.teleportToEntity(this.targetEntity)) {
                        this.teleportTime = 0;
                    }
                }
                super.updateTask();
            }
        }
        
        @Override
        public void startExecuting() {
            this.aggroTime = 5;
            this.teleportTime = 0;
        }
        
        @Override
        public void resetTask() {
            this.player = null;
            super.resetTask();
        }
    }
}
