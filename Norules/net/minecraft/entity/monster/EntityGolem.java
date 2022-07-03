package net.minecraft.entity.monster;

import net.minecraft.entity.*;
import net.minecraft.entity.passive.*;
import javax.annotation.*;
import net.minecraft.util.*;
import net.minecraft.world.*;

public abstract class EntityGolem extends EntityCreature implements IAnimals
{
    @Override
    public int getTalkInterval() {
        return 120;
    }
    
    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return null;
    }
    
    @Nullable
    @Override
    protected SoundEvent getHurtSound(final DamageSource llllllllllllllIIIIllllIlIIlIllII) {
        return null;
    }
    
    @Override
    public void fall(final float llllllllllllllIIIIllllIlIIllIIII, final float llllllllllllllIIIIllllIlIIlIllll) {
    }
    
    @Override
    protected boolean canDespawn() {
        return false;
    }
    
    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return null;
    }
    
    public EntityGolem(final World llllllllllllllIIIIllllIlIIllIlII) {
        super(llllllllllllllIIIIllllIlIIllIlII);
    }
}
