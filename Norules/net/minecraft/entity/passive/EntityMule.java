package net.minecraft.entity.passive;

import net.minecraft.init.*;
import net.minecraft.util.datafix.*;
import net.minecraft.util.*;
import net.minecraft.world.storage.loot.*;
import javax.annotation.*;
import net.minecraft.world.*;

public class EntityMule extends AbstractChestHorse
{
    @Override
    protected void func_190697_dk() {
        this.playSound(SoundEvents.field_191259_dX, 1.0f, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.0f);
    }
    
    @Override
    protected SoundEvent getDeathSound() {
        super.getDeathSound();
        return SoundEvents.ENTITY_MULE_DEATH;
    }
    
    @Override
    protected SoundEvent getHurtSound(final DamageSource lllllllllllllIIIIllllllIllIlIIll) {
        super.getHurtSound(lllllllllllllIIIIllllllIllIlIIll);
        return SoundEvents.ENTITY_MULE_HURT;
    }
    
    public static void func_190700_b(final DataFixer lllllllllllllIIIIllllllIlllIIIIl) {
        AbstractChestHorse.func_190694_b(lllllllllllllIIIIllllllIlllIIIIl, EntityMule.class);
    }
    
    @Nullable
    @Override
    protected ResourceLocation getLootTable() {
        return LootTableList.field_191191_I;
    }
    
    @Override
    protected SoundEvent getAmbientSound() {
        super.getAmbientSound();
        return SoundEvents.ENTITY_MULE_AMBIENT;
    }
    
    public EntityMule(final World lllllllllllllIIIIllllllIlllIIIll) {
        super(lllllllllllllIIIIllllllIlllIIIll);
    }
}
