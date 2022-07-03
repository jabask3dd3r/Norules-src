package net.minecraft.entity.passive;

import net.minecraft.nbt.*;
import net.minecraft.util.datafix.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;
import net.minecraft.world.storage.loot.*;
import javax.annotation.*;
import net.minecraft.entity.ai.*;
import net.minecraft.util.*;
import net.minecraft.init.*;

public class EntitySkeletonHorse extends AbstractHorse
{
    private final /* synthetic */ EntityAISkeletonRiders skeletonTrapAI;
    private /* synthetic */ int skeletonTrapTime;
    private /* synthetic */ boolean skeletonTrap;
    
    @Override
    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute.UNDEAD;
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound llllllllllllllIllIlIlllIIIIllIIl) {
        super.readEntityFromNBT(llllllllllllllIllIlIlllIIIIllIIl);
        this.func_190691_p(llllllllllllllIllIlIlllIIIIllIIl.getBoolean("SkeletonTrap"));
        this.skeletonTrapTime = llllllllllllllIllIlIlllIIIIllIIl.getInteger("SkeletonTrapTime");
    }
    
    public static void func_190692_b(final DataFixer llllllllllllllIllIlIlllIIIlIIlIl) {
        AbstractHorse.func_190683_c(llllllllllllllIllIlIlllIIIlIIlIl, EntitySkeletonHorse.class);
    }
    
    @Override
    public boolean processInteract(final EntityPlayer llllllllllllllIllIlIlllIIIIIIlII, final EnumHand llllllllllllllIllIlIlllIIIIIIIll) {
        final ItemStack llllllllllllllIllIlIlllIIIIIIlll = llllllllllllllIllIlIlllIIIIIIlII.getHeldItem(llllllllllllllIllIlIlllIIIIIIIll);
        final boolean llllllllllllllIllIlIlllIIIIIIllI = !llllllllllllllIllIlIlllIIIIIIlll.func_190926_b();
        if (llllllllllllllIllIlIlllIIIIIIllI && llllllllllllllIllIlIlllIIIIIIlll.getItem() == Items.SPAWN_EGG) {
            return super.processInteract(llllllllllllllIllIlIlllIIIIIIlII, llllllllllllllIllIlIlllIIIIIIIll);
        }
        if (!this.isTame()) {
            return false;
        }
        if (this.isChild()) {
            return super.processInteract(llllllllllllllIllIlIlllIIIIIIlII, llllllllllllllIllIlIlllIIIIIIIll);
        }
        if (llllllllllllllIllIlIlllIIIIIIlII.isSneaking()) {
            this.openGUI(llllllllllllllIllIlIlllIIIIIIlII);
            return true;
        }
        if (this.isBeingRidden()) {
            return super.processInteract(llllllllllllllIllIlIlllIIIIIIlII, llllllllllllllIllIlIlllIIIIIIIll);
        }
        if (llllllllllllllIllIlIlllIIIIIIllI) {
            if (llllllllllllllIllIlIlllIIIIIIlll.getItem() == Items.SADDLE && !this.isHorseSaddled()) {
                this.openGUI(llllllllllllllIllIlIlllIIIIIIlII);
                return true;
            }
            if (llllllllllllllIllIlIlllIIIIIIlll.interactWithEntity(llllllllllllllIllIlIlllIIIIIIlII, this, llllllllllllllIllIlIlllIIIIIIIll)) {
                return true;
            }
        }
        this.mountTo(llllllllllllllIllIlIlllIIIIIIlII);
        return true;
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(15.0);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.20000000298023224);
        this.getEntityAttribute(EntitySkeletonHorse.JUMP_STRENGTH).setBaseValue(this.getModifiedJumpStrength());
    }
    
    public EntitySkeletonHorse(final World llllllllllllllIllIlIlllIIIllllll) {
        super(llllllllllllllIllIlIlllIIIllllll);
        this.skeletonTrapAI = new EntityAISkeletonRiders(this);
    }
    
    @Nullable
    @Override
    protected ResourceLocation getLootTable() {
        return LootTableList.ENTITIES_SKELETON_HORSE;
    }
    
    public void func_190691_p(final boolean llllllllllllllIllIlIlllIIIIlIIlI) {
        if (llllllllllllllIllIlIlllIIIIlIIlI != this.skeletonTrap) {
            this.skeletonTrap = llllllllllllllIllIlIlllIIIIlIIlI;
            if (llllllllllllllIllIlIlllIIIIlIIlI) {
                this.tasks.addTask(1, this.skeletonTrapAI);
            }
            else {
                this.tasks.removeTask(this.skeletonTrapAI);
            }
        }
    }
    
    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (this.func_190690_dh() && this.skeletonTrapTime++ >= 18000) {
            this.setDead();
        }
    }
    
    @Override
    protected SoundEvent getHurtSound(final DamageSource llllllllllllllIllIlIlllIIIllIIlI) {
        super.getHurtSound(llllllllllllllIllIlIlllIIIllIIlI);
        return SoundEvents.ENTITY_SKELETON_HORSE_HURT;
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound llllllllllllllIllIlIlllIIIlIIIIl) {
        super.writeEntityToNBT(llllllllllllllIllIlIlllIIIlIIIIl);
        llllllllllllllIllIlIlllIIIlIIIIl.setBoolean("SkeletonTrap", this.func_190690_dh());
        llllllllllllllIllIlIlllIIIlIIIIl.setInteger("SkeletonTrapTime", this.skeletonTrapTime);
    }
    
    @Override
    public double getMountedYOffset() {
        return super.getMountedYOffset() - 0.1875;
    }
    
    @Override
    protected SoundEvent getAmbientSound() {
        super.getAmbientSound();
        return SoundEvents.ENTITY_SKELETON_HORSE_AMBIENT;
    }
    
    @Override
    protected SoundEvent getDeathSound() {
        super.getDeathSound();
        return SoundEvents.ENTITY_SKELETON_HORSE_DEATH;
    }
    
    public boolean func_190690_dh() {
        return this.skeletonTrap;
    }
}
