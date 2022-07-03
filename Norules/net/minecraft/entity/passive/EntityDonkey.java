package net.minecraft.entity.passive;

import net.minecraft.entity.*;
import net.minecraft.init.*;
import net.minecraft.world.*;
import net.minecraft.util.datafix.*;
import net.minecraft.world.storage.loot.*;
import javax.annotation.*;
import net.minecraft.util.*;

public class EntityDonkey extends AbstractChestHorse
{
    @Override
    public EntityAgeable createChild(final EntityAgeable llllllllllllllIlIlIIllllIlIllIII) {
        final AbstractHorse llllllllllllllIlIlIIllllIlIllIlI = (llllllllllllllIlIlIIllllIlIllIII instanceof EntityHorse) ? new EntityMule(this.world) : new EntityDonkey(this.world);
        this.func_190681_a(llllllllllllllIlIlIIllllIlIllIII, llllllllllllllIlIlIIllllIlIllIlI);
        return llllllllllllllIlIlIIllllIlIllIlI;
    }
    
    @Override
    protected SoundEvent getAmbientSound() {
        super.getAmbientSound();
        return SoundEvents.ENTITY_DONKEY_AMBIENT;
    }
    
    public EntityDonkey(final World llllllllllllllIlIlIIllllIllllIII) {
        super(llllllllllllllIlIlIIllllIllllIII);
    }
    
    public static void func_190699_b(final DataFixer llllllllllllllIlIlIIllllIlllIIll) {
        AbstractChestHorse.func_190694_b(llllllllllllllIlIlIIllllIlllIIll, EntityDonkey.class);
    }
    
    @Nullable
    @Override
    protected ResourceLocation getLootTable() {
        return LootTableList.field_191190_H;
    }
    
    @Override
    public boolean canMateWith(final EntityAnimal llllllllllllllIlIlIIllllIllIIIlI) {
        return llllllllllllllIlIlIIllllIllIIIlI != this && (llllllllllllllIlIlIIllllIllIIIlI instanceof EntityDonkey || llllllllllllllIlIlIIllllIllIIIlI instanceof EntityHorse) && (this.canMate() && ((AbstractHorse)llllllllllllllIlIlIIllllIllIIIlI).canMate());
    }
    
    @Override
    protected SoundEvent getDeathSound() {
        super.getDeathSound();
        return SoundEvents.ENTITY_DONKEY_DEATH;
    }
    
    @Override
    protected SoundEvent getHurtSound(final DamageSource llllllllllllllIlIlIIllllIllIIllI) {
        super.getHurtSound(llllllllllllllIlIlIIllllIllIIllI);
        return SoundEvents.ENTITY_DONKEY_HURT;
    }
}
