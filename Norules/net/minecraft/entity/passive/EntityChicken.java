package net.minecraft.entity.passive;

import java.util.*;
import com.google.common.collect.*;
import net.minecraft.init.*;
import net.minecraft.nbt.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.pathfinding.*;
import net.minecraft.util.datafix.*;
import net.minecraft.entity.ai.*;
import net.minecraft.world.storage.loot.*;
import javax.annotation.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.block.*;
import net.minecraft.item.*;

public class EntityChicken extends EntityAnimal
{
    public /* synthetic */ float wingRotation;
    public /* synthetic */ float destPos;
    public /* synthetic */ float oFlapSpeed;
    private static final /* synthetic */ Set<Item> TEMPTATION_ITEMS;
    public /* synthetic */ boolean chickenJockey;
    public /* synthetic */ float wingRotDelta;
    public /* synthetic */ float oFlap;
    public /* synthetic */ int timeUntilNextEgg;
    
    static {
        TEMPTATION_ITEMS = Sets.newHashSet((Object[])new Item[] { Items.WHEAT_SEEDS, Items.MELON_SEEDS, Items.PUMPKIN_SEEDS, Items.BEETROOT_SEEDS });
    }
    
    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        this.oFlap = this.wingRotation;
        this.oFlapSpeed = this.destPos;
        this.destPos += (float)((this.onGround ? -1 : 4) * 0.3);
        this.destPos = MathHelper.clamp(this.destPos, 0.0f, 1.0f);
        if (!this.onGround && this.wingRotDelta < 1.0f) {
            this.wingRotDelta = 1.0f;
        }
        this.wingRotDelta *= (float)0.9;
        if (!this.onGround && this.motionY < 0.0) {
            this.motionY *= 0.6;
        }
        this.wingRotation += this.wingRotDelta * 2.0f;
        if (!this.world.isRemote && !this.isChild() && !this.isChickenJockey() && --this.timeUntilNextEgg <= 0) {
            this.playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0f, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.0f);
            this.dropItem(Items.EGG, 1);
            this.timeUntilNextEgg = this.rand.nextInt(6000) + 6000;
        }
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound lllllllllllllIIllIIllIIIIIlllIlI) {
        super.readEntityFromNBT(lllllllllllllIIllIIllIIIIIlllIlI);
        this.chickenJockey = lllllllllllllIIllIIllIIIIIlllIlI.getBoolean("IsChickenJockey");
        if (lllllllllllllIIllIIllIIIIIlllIlI.hasKey("EggLayTime")) {
            this.timeUntilNextEgg = lllllllllllllIIllIIllIIIIIlllIlI.getInteger("EggLayTime");
        }
    }
    
    @Override
    public EntityChicken createChild(final EntityAgeable lllllllllllllIIllIIllIIIIlIIllII) {
        return new EntityChicken(this.world);
    }
    
    @Override
    protected int getExperiencePoints(final EntityPlayer lllllllllllllIIllIIllIIIIlIIIIIl) {
        return this.isChickenJockey() ? 10 : super.getExperiencePoints(lllllllllllllIIllIIllIIIIlIIIIIl);
    }
    
    public EntityChicken(final World lllllllllllllIIllIIllIIIIllIlIII) {
        super(lllllllllllllIIllIIllIIIIllIlIII);
        this.wingRotDelta = 1.0f;
        this.setSize(0.4f, 0.7f);
        this.timeUntilNextEgg = this.rand.nextInt(6000) + 6000;
        this.setPathPriority(PathNodeType.WATER, 0.0f);
    }
    
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_CHICKEN_AMBIENT;
    }
    
    @Override
    public float getEyeHeight() {
        return this.height;
    }
    
    public static void registerFixesChicken(final DataFixer lllllllllllllIIllIIllIIIIIllllll) {
        EntityLiving.registerFixesMob(lllllllllllllIIllIIllIIIIIllllll, EntityChicken.class);
    }
    
    @Override
    protected boolean canDespawn() {
        return this.isChickenJockey() && !this.isBeingRidden();
    }
    
    @Override
    protected void initEntityAI() {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 1.4));
        this.tasks.addTask(2, new EntityAIMate(this, 1.0));
        this.tasks.addTask(3, new EntityAITempt(this, 1.0, false, EntityChicken.TEMPTATION_ITEMS));
        this.tasks.addTask(4, new EntityAIFollowParent(this, 1.1));
        this.tasks.addTask(5, new EntityAIWanderAvoidWater(this, 1.0));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0f));
        this.tasks.addTask(7, new EntityAILookIdle(this));
    }
    
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_CHICKEN_DEATH;
    }
    
    @Override
    public void fall(final float lllllllllllllIIllIIllIIIIlIllIlI, final float lllllllllllllIIllIIllIIIIlIllIIl) {
    }
    
    @Nullable
    @Override
    protected ResourceLocation getLootTable() {
        return LootTableList.ENTITIES_CHICKEN;
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(4.0);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25);
    }
    
    @Override
    public void updatePassenger(final Entity lllllllllllllIIllIIllIIIIIlIIlll) {
        super.updatePassenger(lllllllllllllIIllIIllIIIIIlIIlll);
        final float lllllllllllllIIllIIllIIIIIlIIllI = MathHelper.sin(this.renderYawOffset * 0.017453292f);
        final float lllllllllllllIIllIIllIIIIIlIIlIl = MathHelper.cos(this.renderYawOffset * 0.017453292f);
        final float lllllllllllllIIllIIllIIIIIlIIlII = 0.1f;
        final float lllllllllllllIIllIIllIIIIIlIIIll = 0.0f;
        lllllllllllllIIllIIllIIIIIlIIlll.setPosition(this.posX + 0.1f * lllllllllllllIIllIIllIIIIIlIIllI, this.posY + this.height * 0.5f + lllllllllllllIIllIIllIIIIIlIIlll.getYOffset() + 0.0, this.posZ - 0.1f * lllllllllllllIIllIIllIIIIIlIIlIl);
        if (lllllllllllllIIllIIllIIIIIlIIlll instanceof EntityLivingBase) {
            ((EntityLivingBase)lllllllllllllIIllIIllIIIIIlIIlll).renderYawOffset = this.renderYawOffset;
        }
    }
    
    public void setChickenJockey(final boolean lllllllllllllIIllIIllIIIIIIlIllI) {
        this.chickenJockey = lllllllllllllIIllIIllIIIIIIlIllI;
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound lllllllllllllIIllIIllIIIIIllIlII) {
        super.writeEntityToNBT(lllllllllllllIIllIIllIIIIIllIlII);
        lllllllllllllIIllIIllIIIIIllIlII.setBoolean("IsChickenJockey", this.chickenJockey);
        lllllllllllllIIllIIllIIIIIllIlII.setInteger("EggLayTime", this.timeUntilNextEgg);
    }
    
    @Override
    protected SoundEvent getHurtSound(final DamageSource lllllllllllllIIllIIllIIIIlIlIllI) {
        return SoundEvents.ENTITY_CHICKEN_HURT;
    }
    
    @Override
    protected void playStepSound(final BlockPos lllllllllllllIIllIIllIIIIlIlIIlI, final Block lllllllllllllIIllIIllIIIIlIlIIIl) {
        this.playSound(SoundEvents.ENTITY_CHICKEN_STEP, 0.15f, 1.0f);
    }
    
    @Override
    public boolean isBreedingItem(final ItemStack lllllllllllllIIllIIllIIIIlIIlIII) {
        return EntityChicken.TEMPTATION_ITEMS.contains(lllllllllllllIIllIIllIIIIlIIlIII.getItem());
    }
    
    public boolean isChickenJockey() {
        return this.chickenJockey;
    }
}
