package net.minecraft.entity.monster;

import net.minecraft.village.*;
import javax.annotation.*;
import net.minecraft.nbt.*;
import net.minecraft.network.datasync.*;
import net.minecraft.util.datafix.*;
import net.minecraft.init.*;
import net.minecraft.world.storage.loot.*;
import net.minecraft.util.math.*;
import net.minecraft.block.material.*;
import net.minecraft.block.*;
import net.minecraft.block.state.*;
import net.minecraft.entity.player.*;
import com.google.common.base.*;
import net.minecraft.entity.ai.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;

public class EntityIronGolem extends EntityGolem
{
    @Nullable
    /* synthetic */ Village villageObj;
    private /* synthetic */ int attackTimer;
    private /* synthetic */ int homeCheckTimer;
    protected static final /* synthetic */ DataParameter<Byte> PLAYER_CREATED;
    private /* synthetic */ int holdRoseTick;
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound llllllllllllllllIlIlllIlllIlllIl) {
        super.readEntityFromNBT(llllllllllllllllIlIlllIlllIlllIl);
        this.setPlayerCreated(llllllllllllllllIlIlllIlllIlllIl.getBoolean("PlayerCreated"));
    }
    
    static {
        PLAYER_CREATED = EntityDataManager.createKey(EntityIronGolem.class, DataSerializers.BYTE);
    }
    
    public static void registerFixesIronGolem(final DataFixer llllllllllllllllIlIlllIllllIIlll) {
        EntityLiving.registerFixesMob(llllllllllllllllIlIlllIllllIIlll, EntityIronGolem.class);
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(EntityIronGolem.PLAYER_CREATED, (Byte)0);
    }
    
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_IRONGOLEM_DEATH;
    }
    
    @Nullable
    @Override
    protected ResourceLocation getLootTable() {
        return LootTableList.ENTITIES_IRON_GOLEM;
    }
    
    public boolean isPlayerCreated() {
        return (this.dataManager.get(EntityIronGolem.PLAYER_CREATED) & 0x1) != 0x0;
    }
    
    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (this.attackTimer > 0) {
            --this.attackTimer;
        }
        if (this.holdRoseTick > 0) {
            --this.holdRoseTick;
        }
        if (this.motionX * this.motionX + this.motionZ * this.motionZ > 2.500000277905201E-7 && this.rand.nextInt(5) == 0) {
            final int llllllllllllllllIlIlllIllllllIII = MathHelper.floor(this.posX);
            final int llllllllllllllllIlIlllIlllllIlll = MathHelper.floor(this.posY - 0.20000000298023224);
            final int llllllllllllllllIlIlllIlllllIllI = MathHelper.floor(this.posZ);
            final IBlockState llllllllllllllllIlIlllIlllllIlIl = this.world.getBlockState(new BlockPos(llllllllllllllllIlIlllIllllllIII, llllllllllllllllIlIlllIlllllIlll, llllllllllllllllIlIlllIlllllIllI));
            if (llllllllllllllllIlIlllIlllllIlIl.getMaterial() != Material.AIR) {
                this.world.spawnParticle(EnumParticleTypes.BLOCK_CRACK, this.posX + (this.rand.nextFloat() - 0.5) * this.width, this.getEntityBoundingBox().minY + 0.1, this.posZ + (this.rand.nextFloat() - 0.5) * this.width, 4.0 * (this.rand.nextFloat() - 0.5), 0.5, (this.rand.nextFloat() - 0.5) * 4.0, Block.getStateId(llllllllllllllllIlIlllIlllllIlIl));
            }
        }
    }
    
    @Override
    protected void initEntityAI() {
        this.tasks.addTask(1, new EntityAIAttackMelee(this, 1.0, true));
        this.tasks.addTask(2, new EntityAIMoveTowardsTarget(this, 0.9, 32.0f));
        this.tasks.addTask(3, new EntityAIMoveThroughVillage(this, 0.6, true));
        this.tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, 1.0));
        this.tasks.addTask(5, new EntityAILookAtVillager(this));
        this.tasks.addTask(6, new EntityAIWanderAvoidWater(this, 0.6));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0f));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIDefendVillage(this));
        this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false, (Class<?>[])new Class[0]));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget<Object>(this, EntityLiving.class, 10, false, true, (com.google.common.base.Predicate<?>)new Predicate<EntityLiving>() {
            public boolean apply(@Nullable final EntityLiving lllllllllllllIIlllIIIIIIllIllIIl) {
                return lllllllllllllIIlllIIIIIIllIllIIl != null && IMob.VISIBLE_MOB_SELECTOR.apply((Object)lllllllllllllIIlllIIIIIIllIllIIl) && !(lllllllllllllIIlllIIIIIIllIllIIl instanceof EntityCreeper);
            }
        }));
    }
    
    public EntityIronGolem(final World llllllllllllllllIlIllllIIIIllIII) {
        super(llllllllllllllllIlIllllIIIIllIII);
        this.setSize(1.4f, 2.7f);
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100.0);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1.0);
    }
    
    public void setHoldingRose(final boolean llllllllllllllllIlIlllIlllIIIIlI) {
        if (llllllllllllllllIlIlllIlllIIIIlI) {
            this.holdRoseTick = 400;
            this.world.setEntityState(this, (byte)11);
        }
        else {
            this.holdRoseTick = 0;
            this.world.setEntityState(this, (byte)34);
        }
    }
    
    @Override
    public void onDeath(final DamageSource llllllllllllllllIlIlllIllIlIIlII) {
        if (!this.isPlayerCreated() && this.attackingPlayer != null && this.villageObj != null) {
            this.villageObj.modifyPlayerReputation(this.attackingPlayer.getName(), -5);
        }
        super.onDeath(llllllllllllllllIlIlllIllIlIIlII);
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound llllllllllllllllIlIlllIllllIIIll) {
        super.writeEntityToNBT(llllllllllllllllIlIlllIllllIIIll);
        llllllllllllllllIlIlllIllllIIIll.setBoolean("PlayerCreated", this.isPlayerCreated());
    }
    
    @Override
    public void handleStatusUpdate(final byte llllllllllllllllIlIlllIlllIIlllI) {
        if (llllllllllllllllIlIlllIlllIIlllI == 4) {
            this.attackTimer = 10;
            this.playSound(SoundEvents.ENTITY_IRONGOLEM_ATTACK, 1.0f, 1.0f);
        }
        else if (llllllllllllllllIlIlllIlllIIlllI == 11) {
            this.holdRoseTick = 400;
        }
        else if (llllllllllllllllIlIlllIlllIIlllI == 34) {
            this.holdRoseTick = 0;
        }
        else {
            super.handleStatusUpdate(llllllllllllllllIlIlllIlllIIlllI);
        }
    }
    
    @Override
    protected void playStepSound(final BlockPos llllllllllllllllIlIlllIllIlllIlI, final Block llllllllllllllllIlIlllIllIlllIIl) {
        this.playSound(SoundEvents.ENTITY_IRONGOLEM_STEP, 1.0f, 1.0f);
    }
    
    @Override
    public boolean attackEntityAsMob(final Entity llllllllllllllllIlIlllIlllIlIIll) {
        this.attackTimer = 10;
        this.world.setEntityState(this, (byte)4);
        final boolean llllllllllllllllIlIlllIlllIlIlIl = llllllllllllllllIlIlllIlllIlIIll.attackEntityFrom(DamageSource.causeMobDamage(this), (float)(7 + this.rand.nextInt(15)));
        if (llllllllllllllllIlIlllIlllIlIlIl) {
            llllllllllllllllIlIlllIlllIlIIll.motionY += 0.4000000059604645;
            this.applyEnchantments(this, llllllllllllllllIlIlllIlllIlIIll);
        }
        this.playSound(SoundEvents.ENTITY_IRONGOLEM_ATTACK, 1.0f, 1.0f);
        return llllllllllllllllIlIlllIlllIlIlIl;
    }
    
    @Override
    protected SoundEvent getHurtSound(final DamageSource llllllllllllllllIlIlllIllIlllllI) {
        return SoundEvents.ENTITY_IRONGOLEM_HURT;
    }
    
    public void setPlayerCreated(final boolean llllllllllllllllIlIlllIllIlIlIIl) {
        final byte llllllllllllllllIlIlllIllIlIlIll = this.dataManager.get(EntityIronGolem.PLAYER_CREATED);
        if (llllllllllllllllIlIlllIllIlIlIIl) {
            this.dataManager.set(EntityIronGolem.PLAYER_CREATED, (byte)(llllllllllllllllIlIlllIllIlIlIll | 0x1));
        }
        else {
            this.dataManager.set(EntityIronGolem.PLAYER_CREATED, (byte)(llllllllllllllllIlIlllIllIlIlIll & 0xFFFFFFFE));
        }
    }
    
    public int getHoldRoseTick() {
        return this.holdRoseTick;
    }
    
    @Override
    public boolean canAttackClass(final Class<? extends EntityLivingBase> llllllllllllllllIlIlllIllllIlIlI) {
        return (!this.isPlayerCreated() || !EntityPlayer.class.isAssignableFrom(llllllllllllllllIlIlllIllllIlIlI)) && llllllllllllllllIlIlllIllllIlIlI != EntityCreeper.class && super.canAttackClass(llllllllllllllllIlIlllIllllIlIlI);
    }
    
    public int getAttackTimer() {
        return this.attackTimer;
    }
    
    public Village getVillage() {
        return this.villageObj;
    }
    
    @Override
    protected void updateAITasks() {
        final int homeCheckTimer = this.homeCheckTimer - 1;
        this.homeCheckTimer = homeCheckTimer;
        if (homeCheckTimer <= 0) {
            this.homeCheckTimer = 70 + this.rand.nextInt(50);
            this.villageObj = this.world.getVillageCollection().getNearestVillage(new BlockPos(this), 32);
            if (this.villageObj == null) {
                this.detachHome();
            }
            else {
                final BlockPos llllllllllllllllIlIllllIIIIIlllI = this.villageObj.getCenter();
                this.setHomePosAndDistance(llllllllllllllllIlIllllIIIIIlllI, (int)(this.villageObj.getVillageRadius() * 0.6f));
            }
        }
        super.updateAITasks();
    }
    
    @Override
    protected int decreaseAirSupply(final int llllllllllllllllIlIllllIIIIIIlIl) {
        return llllllllllllllllIlIllllIIIIIIlIl;
    }
    
    @Override
    protected void collideWithEntity(final Entity llllllllllllllllIlIlllIlllllllll) {
        if (llllllllllllllllIlIlllIlllllllll instanceof IMob && !(llllllllllllllllIlIlllIlllllllll instanceof EntityCreeper) && this.getRNG().nextInt(20) == 0) {
            this.setAttackTarget((EntityLivingBase)llllllllllllllllIlIlllIlllllllll);
        }
        super.collideWithEntity(llllllllllllllllIlIlllIlllllllll);
    }
}
