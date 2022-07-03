package net.minecraft.entity.passive;

import javax.annotation.*;
import net.minecraft.item.*;
import net.minecraft.world.storage.loot.*;
import net.minecraft.util.math.*;
import net.minecraft.block.material.*;
import net.minecraft.entity.player.*;
import java.util.*;
import net.minecraft.block.state.*;
import net.minecraft.block.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.network.datasync.*;
import net.minecraft.init.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.nbt.*;
import net.minecraft.inventory.*;
import net.minecraft.entity.ai.*;
import com.google.common.base.*;

public class EntityLlama extends AbstractChestHorse implements IRangedAttackMob
{
    private static final /* synthetic */ DataParameter<Integer> field_190721_bH;
    @Nullable
    private /* synthetic */ EntityLlama field_190724_bK;
    private static final /* synthetic */ DataParameter<Integer> field_190720_bG;
    private /* synthetic */ boolean field_190723_bJ;
    @Nullable
    private /* synthetic */ EntityLlama field_190725_bL;
    private static final /* synthetic */ DataParameter<Integer> field_190722_bI;
    
    public void func_190710_o(final int lllllllllllllIIIIlIllIIIIlIlIIIl) {
        this.dataManager.set(EntityLlama.field_190722_bI, lllllllllllllIIIIlIllIIIIlIlIIIl);
    }
    
    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(EntityLlama.field_190720_bG, 0);
        this.dataManager.register(EntityLlama.field_190721_bH, -1);
        this.dataManager.register(EntityLlama.field_190722_bI, 0);
    }
    
    @Override
    public double getMountedYOffset() {
        return this.height * 0.67;
    }
    
    @Override
    public void updatePassenger(final Entity lllllllllllllIIIIlIllIIIIlIIIIII) {
        if (this.isPassenger(lllllllllllllIIIIlIllIIIIlIIIIII)) {
            final float lllllllllllllIIIIlIllIIIIlIIIlII = MathHelper.cos(this.renderYawOffset * 0.017453292f);
            final float lllllllllllllIIIIlIllIIIIlIIIIll = MathHelper.sin(this.renderYawOffset * 0.017453292f);
            final float lllllllllllllIIIIlIllIIIIlIIIIlI = 0.3f;
            lllllllllllllIIIIlIllIIIIlIIIIII.setPosition(this.posX + 0.3f * lllllllllllllIIIIlIllIIIIlIIIIll, this.posY + this.getMountedYOffset() + lllllllllllllIIIIlIllIIIIlIIIIII.getYOffset(), this.posZ - 0.3f * lllllllllllllIIIIlIllIIIIlIIIlII);
        }
    }
    
    private void func_190714_x(final boolean lllllllllllllIIIIlIlIllllIIlllll) {
        this.field_190723_bJ = lllllllllllllIIIIlIlIllllIIlllll;
    }
    
    @Override
    protected SoundEvent getAngrySound() {
        return SoundEvents.field_191250_dA;
    }
    
    private void func_190702_g(final ItemStack lllllllllllllIIIIlIlIlllllIlIllI) {
        if (this.func_190682_f(lllllllllllllIIIIlIlIlllllIlIllI)) {
            this.func_190711_a(EnumDyeColor.byMetadata(lllllllllllllIIIIlIlIlllllIlIllI.getMetadata()));
        }
        else {
            this.func_190711_a(null);
        }
    }
    
    @Override
    protected void updateHorseSlots() {
        if (!this.world.isRemote) {
            super.updateHorseSlots();
            this.func_190702_g(this.horseChest.getStackInSlot(1));
        }
    }
    
    @Override
    protected int func_190686_di() {
        return this.func_190695_dh() ? (2 + 3 * this.func_190696_dl()) : super.func_190686_di();
    }
    
    @Override
    protected SoundEvent getHurtSound(final DamageSource lllllllllllllIIIIlIllIIIIIIIlIlI) {
        return SoundEvents.field_191254_dE;
    }
    
    @Override
    public boolean func_190682_f(final ItemStack lllllllllllllIIIIlIlIlllllllIIll) {
        return lllllllllllllIIIIlIlIlllllllIIll.getItem() == Item.getItemFromBlock(Blocks.CARPET);
    }
    
    @Nullable
    @Override
    protected ResourceLocation getLootTable() {
        return LootTableList.field_191187_aw;
    }
    
    @Override
    public void setSwingingArms(final boolean lllllllllllllIIIIlIlIlllIllIlIIl) {
    }
    
    @Override
    public int func_190676_dC() {
        return 30;
    }
    
    @Override
    protected boolean isMovementBlocked() {
        return this.getHealth() <= 0.0f || this.isEatingHaystack();
    }
    
    @Override
    public boolean canBeSteered() {
        return false;
    }
    
    @Nullable
    @Override
    public IEntityLivingData onInitialSpawn(final DifficultyInstance lllllllllllllIIIIlIllIIIIIIllIII, @Nullable IEntityLivingData lllllllllllllIIIIlIllIIIIIIlIIlI) {
        lllllllllllllIIIIlIllIIIIIIlIIlI = super.onInitialSpawn(lllllllllllllIIIIlIllIIIIIIllIII, lllllllllllllIIIIlIllIIIIIIlIIlI);
        this.func_190705_dT();
        int lllllllllllllIIIIlIllIIIIIIlIlIl = 0;
        if (lllllllllllllIIIIlIllIIIIIIlIIlI instanceof GroupData) {
            final int lllllllllllllIIIIlIllIIIIIIlIllI = ((GroupData)lllllllllllllIIIIlIllIIIIIIlIIlI).field_190886_a;
        }
        else {
            lllllllllllllIIIIlIllIIIIIIlIlIl = this.rand.nextInt(4);
            lllllllllllllIIIIlIllIIIIIIlIIlI = new GroupData(lllllllllllllIIIIlIllIIIIIIlIlIl, null);
        }
        this.func_190710_o(lllllllllllllIIIIlIllIIIIIIlIlIl);
        return lllllllllllllIIIIlIllIIIIIIlIIlI;
    }
    
    @Override
    public boolean func_190677_dK() {
        return true;
    }
    
    @Override
    public void fall(final float lllllllllllllIIIIlIlIllllIIlIllI, final float lllllllllllllIIIIlIlIllllIIlIlIl) {
        final int lllllllllllllIIIIlIlIllllIIlIlII = MathHelper.ceil((lllllllllllllIIIIlIlIllllIIlIllI * 0.5f - 3.0f) * lllllllllllllIIIIlIlIllllIIlIlIl);
        if (lllllllllllllIIIIlIlIllllIIlIlII > 0) {
            if (lllllllllllllIIIIlIlIllllIIlIllI >= 6.0f) {
                this.attackEntityFrom(DamageSource.fall, (float)lllllllllllllIIIIlIlIllllIIlIlII);
                if (this.isBeingRidden()) {
                    for (final Entity lllllllllllllIIIIlIlIllllIIlIIll : this.getRecursivePassengers()) {
                        lllllllllllllIIIIlIlIllllIIlIIll.attackEntityFrom(DamageSource.fall, (float)lllllllllllllIIIIlIlIllllIIlIlII);
                    }
                }
            }
            final IBlockState lllllllllllllIIIIlIlIllllIIlIIlI = this.world.getBlockState(new BlockPos(this.posX, this.posY - 0.2 - this.prevRotationYaw, this.posZ));
            final Block lllllllllllllIIIIlIlIllllIIlIIIl = lllllllllllllIIIIlIlIllllIIlIIlI.getBlock();
            if (lllllllllllllIIIIlIlIllllIIlIIlI.getMaterial() != Material.AIR && !this.isSilent()) {
                final SoundType lllllllllllllIIIIlIlIllllIIlIIII = lllllllllllllIIIIlIlIllllIIlIIIl.getSoundType();
                this.world.playSound(null, this.posX, this.posY, this.posZ, lllllllllllllIIIIlIlIllllIIlIIII.getStepSound(), this.getSoundCategory(), lllllllllllllIIIIlIlIllllIIlIIII.getVolume() * 0.5f, lllllllllllllIIIIlIlIllllIIlIIII.getPitch() * 0.75f);
            }
        }
    }
    
    @Override
    public boolean func_190684_dE() {
        return false;
    }
    
    @Override
    protected void func_190679_dD() {
        if (!this.func_190718_dR() && this.isChild()) {
            super.func_190679_dD();
        }
    }
    
    @Override
    protected double func_190634_dg() {
        return 2.0;
    }
    
    private void func_190713_e(final EntityLivingBase lllllllllllllIIIIlIlIllllIlIlIlI) {
        final EntityLlamaSpit lllllllllllllIIIIlIlIllllIllIIII = new EntityLlamaSpit(this.world, this);
        final double lllllllllllllIIIIlIlIllllIlIllll = lllllllllllllIIIIlIlIllllIlIlIlI.posX - this.posX;
        final double lllllllllllllIIIIlIlIllllIlIlllI = lllllllllllllIIIIlIlIllllIlIlIlI.getEntityBoundingBox().minY + lllllllllllllIIIIlIlIllllIlIlIlI.height / 3.0f - lllllllllllllIIIIlIlIllllIllIIII.posY;
        final double lllllllllllllIIIIlIlIllllIlIllIl = lllllllllllllIIIIlIlIllllIlIlIlI.posZ - this.posZ;
        final float lllllllllllllIIIIlIlIllllIlIllII = MathHelper.sqrt(lllllllllllllIIIIlIlIllllIlIllll * lllllllllllllIIIIlIlIllllIlIllll + lllllllllllllIIIIlIlIllllIlIllIl * lllllllllllllIIIIlIlIllllIlIllIl) * 0.2f;
        lllllllllllllIIIIlIlIllllIllIIII.setThrowableHeading(lllllllllllllIIIIlIlIllllIlIllll, lllllllllllllIIIIlIlIllllIlIlllI + lllllllllllllIIIIlIlIllllIlIllII, lllllllllllllIIIIlIlIllllIlIllIl, 1.5f, 10.0f);
        this.world.playSound(null, this.posX, this.posY, this.posZ, SoundEvents.field_191255_dF, this.getSoundCategory(), 1.0f, 1.0f + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f);
        this.world.spawnEntityInWorld(lllllllllllllIIIIlIlIllllIllIIII);
        this.field_190723_bJ = true;
    }
    
    public int func_190719_dM() {
        return MathHelper.clamp(this.dataManager.get(EntityLlama.field_190722_bI), 0, 3);
    }
    
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.field_191260_dz;
    }
    
    static {
        field_190720_bG = EntityDataManager.createKey(EntityLlama.class, DataSerializers.VARINT);
        field_190721_bH = EntityDataManager.createKey(EntityLlama.class, DataSerializers.VARINT);
        field_190722_bI = EntityDataManager.createKey(EntityLlama.class, DataSerializers.VARINT);
    }
    
    public void func_190715_a(final EntityLlama lllllllllllllIIIIlIlIllllIIIIIlI) {
        this.field_190724_bK = lllllllllllllIIIIlIlIllllIIIIIlI;
        this.field_190724_bK.field_190725_bL = this;
    }
    
    public boolean func_190712_dQ() {
        return this.field_190725_bL != null;
    }
    
    public void func_190709_dP() {
        if (this.field_190724_bK != null) {
            this.field_190724_bK.field_190725_bL = null;
        }
        this.field_190724_bK = null;
    }
    
    @Nullable
    public EntityLlama func_190716_dS() {
        return this.field_190724_bK;
    }
    
    @Override
    protected boolean func_190678_b(final EntityPlayer lllllllllllllIIIIlIllIIIIIlIllll, final ItemStack lllllllllllllIIIIlIllIIIIIlIlllI) {
        int lllllllllllllIIIIlIllIIIIIlIllIl = 0;
        int lllllllllllllIIIIlIllIIIIIlIllII = 0;
        float lllllllllllllIIIIlIllIIIIIlIlIll = 0.0f;
        boolean lllllllllllllIIIIlIllIIIIIlIlIlI = false;
        final Item lllllllllllllIIIIlIllIIIIIlIlIIl = lllllllllllllIIIIlIllIIIIIlIlllI.getItem();
        if (lllllllllllllIIIIlIllIIIIIlIlIIl == Items.WHEAT) {
            lllllllllllllIIIIlIllIIIIIlIllIl = 10;
            lllllllllllllIIIIlIllIIIIIlIllII = 3;
            lllllllllllllIIIIlIllIIIIIlIlIll = 2.0f;
        }
        else if (lllllllllllllIIIIlIllIIIIIlIlIIl == Item.getItemFromBlock(Blocks.HAY_BLOCK)) {
            lllllllllllllIIIIlIllIIIIIlIllIl = 90;
            lllllllllllllIIIIlIllIIIIIlIllII = 6;
            lllllllllllllIIIIlIllIIIIIlIlIll = 10.0f;
            if (this.isTame() && this.getGrowingAge() == 0) {
                lllllllllllllIIIIlIllIIIIIlIlIlI = true;
                this.setInLove(lllllllllllllIIIIlIllIIIIIlIllll);
            }
        }
        if (this.getHealth() < this.getMaxHealth() && lllllllllllllIIIIlIllIIIIIlIlIll > 0.0f) {
            this.heal(lllllllllllllIIIIlIllIIIIIlIlIll);
            lllllllllllllIIIIlIllIIIIIlIlIlI = true;
        }
        if (this.isChild() && lllllllllllllIIIIlIllIIIIIlIllIl > 0) {
            this.world.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, this.posX + this.rand.nextFloat() * this.width * 2.0f - this.width, this.posY + 0.5 + this.rand.nextFloat() * this.height, this.posZ + this.rand.nextFloat() * this.width * 2.0f - this.width, 0.0, 0.0, 0.0, new int[0]);
            if (!this.world.isRemote) {
                this.addGrowth(lllllllllllllIIIIlIllIIIIIlIllIl);
            }
            lllllllllllllIIIIlIllIIIIIlIlIlI = true;
        }
        if (lllllllllllllIIIIlIllIIIIIlIllII > 0 && (lllllllllllllIIIIlIllIIIIIlIlIlI || !this.isTame()) && this.getTemper() < this.func_190676_dC()) {
            lllllllllllllIIIIlIllIIIIIlIlIlI = true;
            if (!this.world.isRemote) {
                this.increaseTemper(lllllllllllllIIIIlIllIIIIIlIllII);
            }
        }
        if (lllllllllllllIIIIlIllIIIIIlIlIlI && !this.isSilent()) {
            this.world.playSound(null, this.posX, this.posY, this.posZ, SoundEvents.field_191253_dD, this.getSoundCategory(), 1.0f, 1.0f + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f);
        }
        return lllllllllllllIIIIlIllIIIIIlIlIlI;
    }
    
    public EntityLlama(final World lllllllllllllIIIIlIllIIIIllllllI) {
        super(lllllllllllllIIIIlIllIIIIllllllI);
        this.setSize(0.9f, 1.87f);
    }
    
    private void func_190706_p(final int lllllllllllllIIIIlIllIIIIllllIII) {
        this.dataManager.set(EntityLlama.field_190720_bG, Math.max(1, Math.min(5, lllllllllllllIIIIlIllIIIIllllIII)));
    }
    
    public boolean func_190718_dR() {
        return this.field_190724_bK != null;
    }
    
    @Override
    protected void initEntityAI() {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIRunAroundLikeCrazy(this, 1.2));
        this.tasks.addTask(2, new EntityAILlamaFollowCaravan(this, 2.0999999046325684));
        this.tasks.addTask(3, new EntityAIAttackRanged(this, 1.25, 40, 20.0f));
        this.tasks.addTask(3, new EntityAIPanic(this, 1.2));
        this.tasks.addTask(4, new EntityAIMate(this, 1.0));
        this.tasks.addTask(5, new EntityAIFollowParent(this, 1.0));
        this.tasks.addTask(6, new EntityAIWanderAvoidWater(this, 0.7));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0f));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new AIHurtByTarget(this));
        this.targetTasks.addTask(2, new AIDefendTarget(this));
    }
    
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.field_191252_dC;
    }
    
    public boolean func_190717_dN() {
        return this.func_190704_dO() != null;
    }
    
    @Override
    public boolean func_190685_dA() {
        return false;
    }
    
    @Override
    protected void func_190697_dk() {
        this.playSound(SoundEvents.field_191251_dB, 1.0f, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.0f);
    }
    
    @Override
    public EntityLlama createChild(final EntityAgeable lllllllllllllIIIIlIlIlllllIIIIlI) {
        final EntityLlama lllllllllllllIIIIlIlIlllllIIIIIl = new EntityLlama(this.world);
        this.func_190681_a(lllllllllllllIIIIlIlIlllllIIIIlI, lllllllllllllIIIIlIlIlllllIIIIIl);
        final EntityLlama lllllllllllllIIIIlIlIlllllIIIIII = (EntityLlama)lllllllllllllIIIIlIlIlllllIIIIlI;
        int lllllllllllllIIIIlIlIllllIllllll = this.rand.nextInt(Math.max(this.func_190707_dL(), lllllllllllllIIIIlIlIlllllIIIIII.func_190707_dL())) + 1;
        if (this.rand.nextFloat() < 0.03f) {
            ++lllllllllllllIIIIlIlIllllIllllll;
        }
        lllllllllllllIIIIlIlIlllllIIIIIl.func_190706_p(lllllllllllllIIIIlIlIllllIllllll);
        lllllllllllllIIIIlIlIlllllIIIIIl.func_190710_o(this.rand.nextBoolean() ? this.func_190719_dM() : lllllllllllllIIIIlIlIlllllIIIIII.func_190719_dM());
        return lllllllllllllIIIIlIlIlllllIIIIIl;
    }
    
    private void func_190711_a(@Nullable final EnumDyeColor lllllllllllllIIIIlIlIlllllIlllII) {
        this.dataManager.set(EntityLlama.field_190721_bH, (lllllllllllllIIIIlIlIlllllIlllII == null) ? -1 : lllllllllllllIIIIlIlIlllllIlllII.getMetadata());
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(40.0);
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound lllllllllllllIIIIlIllIIIIllIIIll) {
        this.func_190706_p(lllllllllllllIIIIlIllIIIIllIIIll.getInteger("Strength"));
        super.readEntityFromNBT(lllllllllllllIIIIlIllIIIIllIIIll);
        this.func_190710_o(lllllllllllllIIIIlIllIIIIllIIIll.getInteger("Variant"));
        if (lllllllllllllIIIIlIllIIIIllIIIll.hasKey("DecorItem", 10)) {
            this.horseChest.setInventorySlotContents(1, new ItemStack(lllllllllllllIIIIlIllIIIIllIIIll.getCompoundTag("DecorItem")));
        }
        this.updateHorseSlots();
    }
    
    @Override
    protected void playStepSound(final BlockPos lllllllllllllIIIIlIllIIIIIIIIllI, final Block lllllllllllllIIIIlIllIIIIIIIIlIl) {
        this.playSound(SoundEvents.field_191256_dG, 0.15f, 1.0f);
    }
    
    @Override
    public void attackEntityWithRangedAttack(final EntityLivingBase lllllllllllllIIIIlIlIlllIllIlllI, final float lllllllllllllIIIIlIlIlllIllIllIl) {
        this.func_190713_e(lllllllllllllIIIIlIlIlllIllIlllI);
    }
    
    public int func_190707_dL() {
        return this.dataManager.get(EntityLlama.field_190720_bG);
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound lllllllllllllIIIIlIllIIIIllIlIIl) {
        super.writeEntityToNBT(lllllllllllllIIIIlIllIIIIllIlIIl);
        lllllllllllllIIIIlIllIIIIllIlIIl.setInteger("Variant", this.func_190719_dM());
        lllllllllllllIIIIlIllIIIIllIlIIl.setInteger("Strength", this.func_190707_dL());
        if (!this.horseChest.getStackInSlot(1).func_190926_b()) {
            lllllllllllllIIIIlIllIIIIllIlIIl.setTag("DecorItem", this.horseChest.getStackInSlot(1).writeToNBT(new NBTTagCompound()));
        }
    }
    
    private void func_190705_dT() {
        final int lllllllllllllIIIIlIllIIIIlllIIlI = (this.rand.nextFloat() < 0.04f) ? 5 : 3;
        this.func_190706_p(1 + this.rand.nextInt(lllllllllllllIIIIlIllIIIIlllIIlI));
    }
    
    @Override
    public int func_190696_dl() {
        return this.func_190707_dL();
    }
    
    @Override
    public boolean canMateWith(final EntityAnimal lllllllllllllIIIIlIlIlllllIIlIIl) {
        return lllllllllllllIIIIlIlIlllllIIlIIl != this && lllllllllllllIIIIlIlIlllllIIlIIl instanceof EntityLlama && this.canMate() && ((EntityLlama)lllllllllllllIIIIlIlIlllllIIlIIl).canMate();
    }
    
    @Override
    public void func_190687_dF() {
        final SoundEvent lllllllllllllIIIIlIlIlllllllllIl = this.getAngrySound();
        if (lllllllllllllIIIIlIlIlllllllllIl != null) {
            this.playSound(lllllllllllllIIIIlIlIlllllllllIl, this.getSoundVolume(), this.getSoundPitch());
        }
    }
    
    @Override
    public void onInventoryChanged(final IInventory lllllllllllllIIIIlIlIllllllIIlll) {
        final EnumDyeColor lllllllllllllIIIIlIlIllllllIlIlI = this.func_190704_dO();
        super.onInventoryChanged(lllllllllllllIIIIlIlIllllllIIlll);
        final EnumDyeColor lllllllllllllIIIIlIlIllllllIlIIl = this.func_190704_dO();
        if (this.ticksExisted > 20 && lllllllllllllIIIIlIlIllllllIlIIl != null && lllllllllllllIIIIlIlIllllllIlIIl != lllllllllllllIIIIlIlIllllllIlIlI) {
            this.playSound(SoundEvents.field_191257_dH, 0.5f, 1.0f);
        }
    }
    
    @Nullable
    public EnumDyeColor func_190704_dO() {
        final int lllllllllllllIIIIlIlIlllllIlIIlI = this.dataManager.get(EntityLlama.field_190721_bH);
        return (lllllllllllllIIIIlIlIlllllIlIIlI == -1) ? null : EnumDyeColor.byMetadata(lllllllllllllIIIIlIlIlllllIlIIlI);
    }
    
    static class AIHurtByTarget extends EntityAIHurtByTarget
    {
        @Override
        public boolean continueExecuting() {
            if (this.taskOwner instanceof EntityLlama) {
                final EntityLlama lllllllllllllllllllIlIlIlllIIlIl = (EntityLlama)this.taskOwner;
                if (lllllllllllllllllllIlIlIlllIIlIl.field_190723_bJ) {
                    lllllllllllllllllllIlIlIlllIIlIl.func_190714_x(false);
                    return false;
                }
            }
            return super.continueExecuting();
        }
        
        public AIHurtByTarget(final EntityLlama lllllllllllllllllllIlIlIlllIlIll) {
            super(lllllllllllllllllllIlIlIlllIlIll, false, (Class<?>[])new Class[0]);
        }
    }
    
    static class AIDefendTarget extends EntityAINearestAttackableTarget<EntityWolf>
    {
        @Override
        protected double getTargetDistance() {
            return super.getTargetDistance() * 0.25;
        }
        
        public AIDefendTarget(final EntityLlama llllllllllllllIllIIIlIIlIllllIIl) {
            super(llllllllllllllIllIIIlIIlIllllIIl, EntityWolf.class, 16, false, true, null);
        }
        
        @Override
        public boolean shouldExecute() {
            if (super.shouldExecute() && this.targetEntity != null && !((EntityWolf)this.targetEntity).isTamed()) {
                return true;
            }
            this.taskOwner.setAttackTarget(null);
            return false;
        }
    }
    
    static class GroupData implements IEntityLivingData
    {
        public /* synthetic */ int field_190886_a;
        
        private GroupData(final int lllllllllllllIlIIlIllllIlIllllIl) {
            this.field_190886_a = lllllllllllllIlIIlIllllIlIllllIl;
        }
    }
}
