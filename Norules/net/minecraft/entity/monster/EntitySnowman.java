package net.minecraft.entity.monster;

import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import javax.annotation.*;
import net.minecraft.util.datafix.*;
import net.minecraft.util.*;
import net.minecraft.world.storage.loot.*;
import net.minecraft.world.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.nbt.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import com.google.common.base.*;
import net.minecraft.util.math.*;
import net.minecraft.block.material.*;
import net.minecraft.init.*;
import net.minecraft.network.datasync.*;

public class EntitySnowman extends EntityGolem implements IRangedAttackMob
{
    private static final /* synthetic */ DataParameter<Byte> PUMPKIN_EQUIPPED;
    
    @Override
    protected boolean processInteract(final EntityPlayer lllllllllllllIlIlIIlllIIlIIlIIIl, final EnumHand lllllllllllllIlIlIIlllIIlIIlIIII) {
        final ItemStack lllllllllllllIlIlIIlllIIlIIlIIll = lllllllllllllIlIlIIlllIIlIIlIIIl.getHeldItem(lllllllllllllIlIlIIlllIIlIIlIIII);
        if (lllllllllllllIlIlIIlllIIlIIlIIll.getItem() == Items.SHEARS && this.isPumpkinEquipped() && !this.world.isRemote) {
            this.setPumpkinEquipped(false);
            lllllllllllllIlIlIIlllIIlIIlIIll.damageItem(1, lllllllllllllIlIlIIlllIIlIIlIIIl);
        }
        return super.processInteract(lllllllllllllIlIlIIlllIIlIIlIIIl, lllllllllllllIlIlIIlllIIlIIlIIII);
    }
    
    @Override
    public float getEyeHeight() {
        return 1.7f;
    }
    
    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_SNOWMAN_DEATH;
    }
    
    public static void registerFixesSnowman(final DataFixer lllllllllllllIlIlIIlllIIllIlllIl) {
        EntityLiving.registerFixesMob(lllllllllllllIlIlIIlllIIllIlllIl, EntitySnowman.class);
    }
    
    @Nullable
    @Override
    protected SoundEvent getHurtSound(final DamageSource lllllllllllllIlIlIIlllIIlIIIIIII) {
        return SoundEvents.ENTITY_SNOWMAN_HURT;
    }
    
    public void setPumpkinEquipped(final boolean lllllllllllllIlIlIIlllIIlIIIIlll) {
        final byte lllllllllllllIlIlIIlllIIlIIIIllI = this.dataManager.get(EntitySnowman.PUMPKIN_EQUIPPED);
        if (lllllllllllllIlIlIIlllIIlIIIIlll) {
            this.dataManager.set(EntitySnowman.PUMPKIN_EQUIPPED, (byte)(lllllllllllllIlIlIIlllIIlIIIIllI | 0x10));
        }
        else {
            this.dataManager.set(EntitySnowman.PUMPKIN_EQUIPPED, (byte)(lllllllllllllIlIlIIlllIIlIIIIllI & 0xFFFFFFEF));
        }
    }
    
    @Nullable
    @Override
    protected ResourceLocation getLootTable() {
        return LootTableList.ENTITIES_SNOWMAN;
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(4.0);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.20000000298023224);
    }
    
    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_SNOWMAN_AMBIENT;
    }
    
    public EntitySnowman(final World lllllllllllllIlIlIIlllIIlllIIIII) {
        super(lllllllllllllIlIlIIlllIIlllIIIII);
        this.setSize(0.7f, 1.9f);
    }
    
    @Override
    public void setSwingingArms(final boolean lllllllllllllIlIlIIlllIIIlllllIl) {
    }
    
    @Override
    public void attackEntityWithRangedAttack(final EntityLivingBase lllllllllllllIlIlIIlllIIlIlIlIll, final float lllllllllllllIlIlIIlllIIlIlIlIlI) {
        final EntitySnowball lllllllllllllIlIlIIlllIIlIlIlIIl = new EntitySnowball(this.world, this);
        final double lllllllllllllIlIlIIlllIIlIlIlIII = lllllllllllllIlIlIIlllIIlIlIlIll.posY + lllllllllllllIlIlIIlllIIlIlIlIll.getEyeHeight() - 1.100000023841858;
        final double lllllllllllllIlIlIIlllIIlIlIIlll = lllllllllllllIlIlIIlllIIlIlIlIll.posX - this.posX;
        final double lllllllllllllIlIlIIlllIIlIlIIllI = lllllllllllllIlIlIIlllIIlIlIlIII - lllllllllllllIlIlIIlllIIlIlIlIIl.posY;
        final double lllllllllllllIlIlIIlllIIlIlIIlIl = lllllllllllllIlIlIIlllIIlIlIlIll.posZ - this.posZ;
        final float lllllllllllllIlIlIIlllIIlIlIIlII = MathHelper.sqrt(lllllllllllllIlIlIIlllIIlIlIIlll * lllllllllllllIlIlIIlllIIlIlIIlll + lllllllllllllIlIlIIlllIIlIlIIlIl * lllllllllllllIlIlIIlllIIlIlIIlIl) * 0.2f;
        lllllllllllllIlIlIIlllIIlIlIlIIl.setThrowableHeading(lllllllllllllIlIlIIlllIIlIlIIlll, lllllllllllllIlIlIIlllIIlIlIIllI + lllllllllllllIlIlIIlllIIlIlIIlII, lllllllllllllIlIlIIlllIIlIlIIlIl, 1.6f, 12.0f);
        this.playSound(SoundEvents.ENTITY_SNOWMAN_SHOOT, 1.0f, 1.0f / (this.getRNG().nextFloat() * 0.4f + 0.8f));
        this.world.spawnEntityInWorld(lllllllllllllIlIlIIlllIIlIlIlIIl);
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound lllllllllllllIlIlIIlllIIllIIlIlI) {
        super.readEntityFromNBT(lllllllllllllIlIlIIlllIIllIIlIlI);
        if (lllllllllllllIlIlIIlllIIllIIlIlI.hasKey("Pumpkin")) {
            this.setPumpkinEquipped(lllllllllllllIlIlIIlllIIllIIlIlI.getBoolean("Pumpkin"));
        }
    }
    
    @Override
    protected void initEntityAI() {
        this.tasks.addTask(1, new EntityAIAttackRanged(this, 1.25, 20, 10.0f));
        this.tasks.addTask(2, new EntityAIWanderAvoidWater(this, 1.0, 1.0000001E-5f));
        this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0f));
        this.tasks.addTask(4, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget<Object>(this, EntityLiving.class, 10, true, false, IMob.MOB_SELECTOR));
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound lllllllllllllIlIlIIlllIIllIlIIII) {
        super.writeEntityToNBT(lllllllllllllIlIlIIlllIIllIlIIII);
        lllllllllllllIlIlIIlllIIllIlIIII.setBoolean("Pumpkin", this.isPumpkinEquipped());
    }
    
    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (!this.world.isRemote) {
            int lllllllllllllIlIlIIlllIIllIIIIII = MathHelper.floor(this.posX);
            int lllllllllllllIlIlIIlllIIlIllllll = MathHelper.floor(this.posY);
            int lllllllllllllIlIlIIlllIIlIlllllI = MathHelper.floor(this.posZ);
            if (this.isWet()) {
                this.attackEntityFrom(DamageSource.drown, 1.0f);
            }
            if (this.world.getBiome(new BlockPos(lllllllllllllIlIlIIlllIIllIIIIII, 0, lllllllllllllIlIlIIlllIIlIlllllI)).getFloatTemperature(new BlockPos(lllllllllllllIlIlIIlllIIllIIIIII, lllllllllllllIlIlIIlllIIlIllllll, lllllllllllllIlIlIIlllIIlIlllllI)) > 1.0f) {
                this.attackEntityFrom(DamageSource.onFire, 1.0f);
            }
            if (!this.world.getGameRules().getBoolean("mobGriefing")) {
                return;
            }
            for (int lllllllllllllIlIlIIlllIIlIllllIl = 0; lllllllllllllIlIlIIlllIIlIllllIl < 4; ++lllllllllllllIlIlIIlllIIlIllllIl) {
                lllllllllllllIlIlIIlllIIllIIIIII = MathHelper.floor(this.posX + (lllllllllllllIlIlIIlllIIlIllllIl % 2 * 2 - 1) * 0.25f);
                lllllllllllllIlIlIIlllIIlIllllll = MathHelper.floor(this.posY);
                lllllllllllllIlIlIIlllIIlIlllllI = MathHelper.floor(this.posZ + (lllllllllllllIlIlIIlllIIlIllllIl / 2 % 2 * 2 - 1) * 0.25f);
                final BlockPos lllllllllllllIlIlIIlllIIlIllllII = new BlockPos(lllllllllllllIlIlIIlllIIllIIIIII, lllllllllllllIlIlIIlllIIlIllllll, lllllllllllllIlIlIIlllIIlIlllllI);
                if (this.world.getBlockState(lllllllllllllIlIlIIlllIIlIllllII).getMaterial() == Material.AIR && this.world.getBiome(lllllllllllllIlIlIIlllIIlIllllII).getFloatTemperature(lllllllllllllIlIlIIlllIIlIllllII) < 0.8f && Blocks.SNOW_LAYER.canPlaceBlockAt(this.world, lllllllllllllIlIlIIlllIIlIllllII)) {
                    this.world.setBlockState(lllllllllllllIlIlIIlllIIlIllllII, Blocks.SNOW_LAYER.getDefaultState());
                }
            }
        }
    }
    
    public boolean isPumpkinEquipped() {
        return (this.dataManager.get(EntitySnowman.PUMPKIN_EQUIPPED) & 0x10) != 0x0;
    }
    
    static {
        PUMPKIN_EQUIPPED = EntityDataManager.createKey(EntitySnowman.class, DataSerializers.BYTE);
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(EntitySnowman.PUMPKIN_EQUIPPED, (Byte)16);
    }
}
