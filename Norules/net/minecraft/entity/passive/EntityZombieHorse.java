package net.minecraft.entity.passive;

import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.entity.*;
import net.minecraft.world.storage.loot.*;
import javax.annotation.*;
import net.minecraft.init.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.util.datafix.*;

public class EntityZombieHorse extends AbstractHorse
{
    @Override
    public boolean processInteract(final EntityPlayer llllllllllllIlllllllIlllllIIlIll, final EnumHand llllllllllllIlllllllIlllllIIllll) {
        final ItemStack llllllllllllIlllllllIlllllIIlllI = llllllllllllIlllllllIlllllIIlIll.getHeldItem(llllllllllllIlllllllIlllllIIllll);
        final boolean llllllllllllIlllllllIlllllIIllIl = !llllllllllllIlllllllIlllllIIlllI.func_190926_b();
        if (llllllllllllIlllllllIlllllIIllIl && llllllllllllIlllllllIlllllIIlllI.getItem() == Items.SPAWN_EGG) {
            return super.processInteract(llllllllllllIlllllllIlllllIIlIll, llllllllllllIlllllllIlllllIIllll);
        }
        if (!this.isTame()) {
            return false;
        }
        if (this.isChild()) {
            return super.processInteract(llllllllllllIlllllllIlllllIIlIll, llllllllllllIlllllllIlllllIIllll);
        }
        if (llllllllllllIlllllllIlllllIIlIll.isSneaking()) {
            this.openGUI(llllllllllllIlllllllIlllllIIlIll);
            return true;
        }
        if (this.isBeingRidden()) {
            return super.processInteract(llllllllllllIlllllllIlllllIIlIll, llllllllllllIlllllllIlllllIIllll);
        }
        if (llllllllllllIlllllllIlllllIIllIl) {
            if (!this.isHorseSaddled() && llllllllllllIlllllllIlllllIIlllI.getItem() == Items.SADDLE) {
                this.openGUI(llllllllllllIlllllllIlllllIIlIll);
                return true;
            }
            if (llllllllllllIlllllllIlllllIIlllI.interactWithEntity(llllllllllllIlllllllIlllllIIlIll, this, llllllllllllIlllllllIlllllIIllll)) {
                return true;
            }
        }
        this.mountTo(llllllllllllIlllllllIlllllIIlIll);
        return true;
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(15.0);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.20000000298023224);
        this.getEntityAttribute(EntityZombieHorse.JUMP_STRENGTH).setBaseValue(this.getModifiedJumpStrength());
    }
    
    @Override
    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute.UNDEAD;
    }
    
    @Nullable
    @Override
    protected ResourceLocation getLootTable() {
        return LootTableList.ENTITIES_ZOMBIE_HORSE;
    }
    
    @Override
    protected SoundEvent getDeathSound() {
        super.getDeathSound();
        return SoundEvents.ENTITY_ZOMBIE_HORSE_DEATH;
    }
    
    @Override
    protected SoundEvent getAmbientSound() {
        super.getAmbientSound();
        return SoundEvents.ENTITY_ZOMBIE_HORSE_AMBIENT;
    }
    
    public EntityZombieHorse(final World llllllllllllIlllllllIllllllIlIll) {
        super(llllllllllllIlllllllIllllllIlIll);
    }
    
    @Override
    protected SoundEvent getHurtSound(final DamageSource llllllllllllIlllllllIlllllIllIII) {
        super.getHurtSound(llllllllllllIlllllllIlllllIllIII);
        return SoundEvents.ENTITY_ZOMBIE_HORSE_HURT;
    }
    
    public static void func_190693_b(final DataFixer llllllllllllIlllllllIllllllIlIIl) {
        AbstractHorse.func_190683_c(llllllllllllIlllllllIllllllIlIIl, EntityZombieHorse.class);
    }
}
