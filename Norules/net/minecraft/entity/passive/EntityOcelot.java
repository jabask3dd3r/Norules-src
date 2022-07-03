package net.minecraft.entity.passive;

import net.minecraft.entity.player.*;
import javax.annotation.*;
import net.minecraft.nbt.*;
import net.minecraft.util.datafix.*;
import net.minecraft.item.*;
import net.minecraft.util.text.translation.*;
import net.minecraft.entity.ai.*;
import com.google.common.base.*;
import net.minecraft.util.*;
import net.minecraft.world.storage.loot.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;
import net.minecraft.init.*;
import net.minecraft.block.material.*;
import net.minecraft.block.state.*;
import net.minecraft.block.*;
import net.minecraft.network.datasync.*;

public class EntityOcelot extends EntityTameable
{
    private /* synthetic */ EntityAIAvoidEntity<EntityPlayer> avoidEntity;
    private /* synthetic */ EntityAITempt aiTempt;
    private static final /* synthetic */ DataParameter<Integer> OCELOT_VARIANT;
    
    @Override
    public EntityOcelot createChild(final EntityAgeable lllllllllllllllIIllIIlllIIllllll) {
        final EntityOcelot lllllllllllllllIIllIIlllIIlllllI = new EntityOcelot(this.world);
        if (this.isTamed()) {
            lllllllllllllllIIllIIlllIIlllllI.setOwnerId(this.getOwnerId());
            lllllllllllllllIIllIIlllIIlllllI.setTamed(true);
            lllllllllllllllIIllIIlllIIlllllI.setTameSkin(this.getTameSkin());
        }
        return lllllllllllllllIIllIIlllIIlllllI;
    }
    
    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        if (!this.isTamed()) {
            return null;
        }
        if (this.isInLove()) {
            return SoundEvents.ENTITY_CAT_PURR;
        }
        return (this.rand.nextInt(4) == 0) ? SoundEvents.ENTITY_CAT_PURREOW : SoundEvents.ENTITY_CAT_AMBIENT;
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(EntityOcelot.OCELOT_VARIANT, 0);
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound lllllllllllllllIIllIIlllIllIlllI) {
        super.writeEntityToNBT(lllllllllllllllIIllIIlllIllIlllI);
        lllllllllllllllIIllIIlllIllIlllI.setInteger("CatType", this.getTameSkin());
    }
    
    @Override
    protected SoundEvent getHurtSound(final DamageSource lllllllllllllllIIllIIlllIllIIIIl) {
        return SoundEvents.ENTITY_CAT_HURT;
    }
    
    public static void registerFixesOcelot(final DataFixer lllllllllllllllIIllIIlllIlllIIll) {
        EntityLiving.registerFixesMob(lllllllllllllllIIllIIlllIlllIIll, EntityOcelot.class);
    }
    
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_CAT_DEATH;
    }
    
    @Override
    protected boolean canDespawn() {
        return !this.isTamed() && this.ticksExisted > 2400;
    }
    
    @Override
    public boolean isBreedingItem(final ItemStack lllllllllllllllIIllIIlllIIlllIII) {
        return lllllllllllllllIIllIIlllIIlllIII.getItem() == Items.FISH;
    }
    
    @Override
    protected void setupTamedAI() {
        if (this.avoidEntity == null) {
            this.avoidEntity = new EntityAIAvoidEntity<EntityPlayer>(this, EntityPlayer.class, 16.0f, 0.8, 1.33);
        }
        this.tasks.removeTask(this.avoidEntity);
        if (!this.isTamed()) {
            this.tasks.addTask(4, this.avoidEntity);
        }
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound lllllllllllllllIIllIIlllIllIIllI) {
        super.readEntityFromNBT(lllllllllllllllIIllIIlllIllIIllI);
        this.setTameSkin(lllllllllllllllIIllIIlllIllIIllI.getInteger("CatType"));
    }
    
    public void updateAITasks() {
        if (this.getMoveHelper().isUpdating()) {
            final double lllllllllllllllIIllIIllllIIIIIII = this.getMoveHelper().getSpeed();
            if (lllllllllllllllIIllIIllllIIIIIII == 0.6) {
                this.setSneaking(true);
                this.setSprinting(false);
            }
            else if (lllllllllllllllIIllIIllllIIIIIII == 1.33) {
                this.setSneaking(false);
                this.setSprinting(true);
            }
            else {
                this.setSneaking(false);
                this.setSprinting(false);
            }
        }
        else {
            this.setSneaking(false);
            this.setSprinting(false);
        }
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.30000001192092896);
    }
    
    public int getTameSkin() {
        return this.dataManager.get(EntityOcelot.OCELOT_VARIANT);
    }
    
    @Override
    public boolean processInteract(final EntityPlayer lllllllllllllllIIllIIlllIlIIlIIl, final EnumHand lllllllllllllllIIllIIlllIlIIlIII) {
        final ItemStack lllllllllllllllIIllIIlllIlIIIlll = lllllllllllllllIIllIIlllIlIIlIIl.getHeldItem(lllllllllllllllIIllIIlllIlIIlIII);
        if (this.isTamed()) {
            if (this.isOwner(lllllllllllllllIIllIIlllIlIIlIIl) && !this.world.isRemote && !this.isBreedingItem(lllllllllllllllIIllIIlllIlIIIlll)) {
                this.aiSit.setSitting(!this.isSitting());
            }
        }
        else if ((this.aiTempt == null || this.aiTempt.isRunning()) && lllllllllllllllIIllIIlllIlIIIlll.getItem() == Items.FISH && lllllllllllllllIIllIIlllIlIIlIIl.getDistanceSqToEntity(this) < 9.0) {
            if (!lllllllllllllllIIllIIlllIlIIlIIl.capabilities.isCreativeMode) {
                lllllllllllllllIIllIIlllIlIIIlll.func_190918_g(1);
            }
            if (!this.world.isRemote) {
                if (this.rand.nextInt(3) == 0) {
                    this.func_193101_c(lllllllllllllllIIllIIlllIlIIlIIl);
                    this.setTameSkin(1 + this.world.rand.nextInt(3));
                    this.playTameEffect(true);
                    this.aiSit.setSitting(true);
                    this.world.setEntityState(this, (byte)7);
                }
                else {
                    this.playTameEffect(false);
                    this.world.setEntityState(this, (byte)6);
                }
            }
            return true;
        }
        return super.processInteract(lllllllllllllllIIllIIlllIlIIlIIl, lllllllllllllllIIllIIlllIlIIlIII);
    }
    
    @Override
    protected float getSoundVolume() {
        return 0.4f;
    }
    
    @Override
    public String getName() {
        if (this.hasCustomName()) {
            return this.getCustomNameTag();
        }
        return this.isTamed() ? I18n.translateToLocal("entity.Cat.name") : super.getName();
    }
    
    @Override
    protected void initEntityAI() {
        this.aiSit = new EntityAISit(this);
        this.aiTempt = new EntityAITempt(this, 0.6, Items.FISH, true);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, this.aiSit);
        this.tasks.addTask(3, this.aiTempt);
        this.tasks.addTask(5, new EntityAIFollowOwner(this, 1.0, 10.0f, 5.0f));
        this.tasks.addTask(6, new EntityAIOcelotSit(this, 0.8));
        this.tasks.addTask(7, new EntityAILeapAtTarget(this, 0.3f));
        this.tasks.addTask(8, new EntityAIOcelotAttack(this));
        this.tasks.addTask(9, new EntityAIMate(this, 0.8));
        this.tasks.addTask(10, new EntityAIWanderAvoidWater(this, 0.8, 1.0000001E-5f));
        this.tasks.addTask(11, new EntityAIWatchClosest(this, EntityPlayer.class, 10.0f));
        this.targetTasks.addTask(1, new EntityAITargetNonTamed<Object>(this, EntityChicken.class, false, null));
    }
    
    @Nullable
    @Override
    protected ResourceLocation getLootTable() {
        return LootTableList.ENTITIES_OCELOT;
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource lllllllllllllllIIllIIlllIlIlIIIl, final float lllllllllllllllIIllIIlllIlIlIIII) {
        if (this.isEntityInvulnerable(lllllllllllllllIIllIIlllIlIlIIIl)) {
            return false;
        }
        if (this.aiSit != null) {
            this.aiSit.setSitting(false);
        }
        return super.attackEntityFrom(lllllllllllllllIIllIIlllIlIlIIIl, lllllllllllllllIIllIIlllIlIlIIII);
    }
    
    public EntityOcelot(final World lllllllllllllllIIllIIllllIIIllII) {
        super(lllllllllllllllIIllIIllllIIIllII);
        this.setSize(0.6f, 0.7f);
    }
    
    @Nullable
    @Override
    public IEntityLivingData onInitialSpawn(final DifficultyInstance lllllllllllllllIIllIIlllIIIIIlIl, @Nullable IEntityLivingData lllllllllllllllIIllIIlllIIIIIlII) {
        lllllllllllllllIIllIIlllIIIIIlII = super.onInitialSpawn(lllllllllllllllIIllIIlllIIIIIlIl, lllllllllllllllIIllIIlllIIIIIlII);
        if (this.getTameSkin() == 0 && this.world.rand.nextInt(7) == 0) {
            for (int lllllllllllllllIIllIIlllIIIIlIII = 0; lllllllllllllllIIllIIlllIIIIlIII < 2; ++lllllllllllllllIIllIIlllIIIIlIII) {
                final EntityOcelot lllllllllllllllIIllIIlllIIIIIlll = new EntityOcelot(this.world);
                lllllllllllllllIIllIIlllIIIIIlll.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0f);
                lllllllllllllllIIllIIlllIIIIIlll.setGrowingAge(-24000);
                this.world.spawnEntityInWorld(lllllllllllllllIIllIIlllIIIIIlll);
            }
        }
        return lllllllllllllllIIllIIlllIIIIIlII;
    }
    
    @Override
    public boolean getCanSpawnHere() {
        return this.world.rand.nextInt(3) != 0;
    }
    
    @Override
    public boolean isNotColliding() {
        if (this.world.checkNoEntityCollision(this.getEntityBoundingBox(), this) && this.world.getCollisionBoxes(this, this.getEntityBoundingBox()).isEmpty() && !this.world.containsAnyLiquid(this.getEntityBoundingBox())) {
            final BlockPos lllllllllllllllIIllIIlllIIIlllIl = new BlockPos(this.posX, this.getEntityBoundingBox().minY, this.posZ);
            if (lllllllllllllllIIllIIlllIIIlllIl.getY() < this.world.getSeaLevel()) {
                return false;
            }
            final IBlockState lllllllllllllllIIllIIlllIIIlllII = this.world.getBlockState(lllllllllllllllIIllIIlllIIIlllIl.down());
            final Block lllllllllllllllIIllIIlllIIIllIll = lllllllllllllllIIllIIlllIIIlllII.getBlock();
            if (lllllllllllllllIIllIIlllIIIllIll == Blocks.GRASS || lllllllllllllllIIllIIlllIIIlllII.getMaterial() == Material.LEAVES) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean canMateWith(final EntityAnimal lllllllllllllllIIllIIlllIIllIIII) {
        if (lllllllllllllllIIllIIlllIIllIIII == this) {
            return false;
        }
        if (!this.isTamed()) {
            return false;
        }
        if (!(lllllllllllllllIIllIIlllIIllIIII instanceof EntityOcelot)) {
            return false;
        }
        final EntityOcelot lllllllllllllllIIllIIlllIIllIIlI = (EntityOcelot)lllllllllllllllIIllIIlllIIllIIII;
        return lllllllllllllllIIllIIlllIIllIIlI.isTamed() && (this.isInLove() && lllllllllllllllIIllIIlllIIllIIlI.isInLove());
    }
    
    public void setTameSkin(final int lllllllllllllllIIllIIlllIIlIlIII) {
        this.dataManager.set(EntityOcelot.OCELOT_VARIANT, lllllllllllllllIIllIIlllIIlIlIII);
    }
    
    @Override
    public void fall(final float lllllllllllllllIIllIIlllIlllIllI, final float lllllllllllllllIIllIIlllIlllIlIl) {
    }
    
    static {
        OCELOT_VARIANT = EntityDataManager.createKey(EntityOcelot.class, DataSerializers.VARINT);
    }
    
    @Override
    public boolean attackEntityAsMob(final Entity lllllllllllllllIIllIIlllIlIllIIl) {
        return lllllllllllllllIIllIIlllIlIllIIl.attackEntityFrom(DamageSource.causeMobDamage(this), 3.0f);
    }
}
