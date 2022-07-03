package net.minecraft.entity.passive;

import net.minecraft.util.datafix.*;
import net.minecraft.world.storage.loot.*;
import javax.annotation.*;
import net.minecraft.util.math.*;
import net.minecraft.block.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;

public class EntityCow extends EntityAnimal
{
    @Override
    public EntityCow createChild(final EntityAgeable llllllllllllllIlIlIIllIIlIIlIlII) {
        return new EntityCow(this.world);
    }
    
    public static void registerFixesCow(final DataFixer llllllllllllllIlIlIIllIIlIllIlII) {
        EntityLiving.registerFixesMob(llllllllllllllIlIlIIllIIlIllIlII, EntityCow.class);
    }
    
    @Override
    protected SoundEvent getHurtSound(final DamageSource llllllllllllllIlIlIIllIIlIlIlIll) {
        return SoundEvents.ENTITY_COW_HURT;
    }
    
    @Nullable
    @Override
    protected ResourceLocation getLootTable() {
        return LootTableList.ENTITIES_COW;
    }
    
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_COW_AMBIENT;
    }
    
    @Override
    protected float getSoundVolume() {
        return 0.4f;
    }
    
    @Override
    public float getEyeHeight() {
        return this.isChild() ? this.height : 1.3f;
    }
    
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_COW_DEATH;
    }
    
    @Override
    protected void playStepSound(final BlockPos llllllllllllllIlIlIIllIIlIlIIlll, final Block llllllllllllllIlIlIIllIIlIlIIllI) {
        this.playSound(SoundEvents.ENTITY_COW_STEP, 0.15f, 1.0f);
    }
    
    @Override
    public boolean processInteract(final EntityPlayer llllllllllllllIlIlIIllIIlIIlllIl, final EnumHand llllllllllllllIlIlIIllIIlIIllIII) {
        final ItemStack llllllllllllllIlIlIIllIIlIIllIll = llllllllllllllIlIlIIllIIlIIlllIl.getHeldItem(llllllllllllllIlIlIIllIIlIIllIII);
        if (llllllllllllllIlIlIIllIIlIIllIll.getItem() == Items.BUCKET && !llllllllllllllIlIlIIllIIlIIlllIl.capabilities.isCreativeMode && !this.isChild()) {
            llllllllllllllIlIlIIllIIlIIlllIl.playSound(SoundEvents.ENTITY_COW_MILK, 1.0f, 1.0f);
            llllllllllllllIlIlIIllIIlIIllIll.func_190918_g(1);
            if (llllllllllllllIlIlIIllIIlIIllIll.func_190926_b()) {
                llllllllllllllIlIlIIllIIlIIlllIl.setHeldItem(llllllllllllllIlIlIIllIIlIIllIII, new ItemStack(Items.MILK_BUCKET));
            }
            else if (!llllllllllllllIlIlIIllIIlIIlllIl.inventory.addItemStackToInventory(new ItemStack(Items.MILK_BUCKET))) {
                llllllllllllllIlIlIIllIIlIIlllIl.dropItem(new ItemStack(Items.MILK_BUCKET), false);
            }
            return true;
        }
        return super.processInteract(llllllllllllllIlIlIIllIIlIIlllIl, llllllllllllllIlIlIIllIIlIIllIII);
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.20000000298023224);
    }
    
    public EntityCow(final World llllllllllllllIlIlIIllIIlIllIlll) {
        super(llllllllllllllIlIlIIllIIlIllIlll);
        this.setSize(0.9f, 1.4f);
    }
    
    @Override
    protected void initEntityAI() {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 2.0));
        this.tasks.addTask(2, new EntityAIMate(this, 1.0));
        this.tasks.addTask(3, new EntityAITempt(this, 1.25, Items.WHEAT, false));
        this.tasks.addTask(4, new EntityAIFollowParent(this, 1.25));
        this.tasks.addTask(5, new EntityAIWanderAvoidWater(this, 1.0));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0f));
        this.tasks.addTask(7, new EntityAILookIdle(this));
    }
}
