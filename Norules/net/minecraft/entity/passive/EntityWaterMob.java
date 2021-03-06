package net.minecraft.entity.passive;

import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;

public abstract class EntityWaterMob extends EntityLiving implements IAnimals
{
    @Override
    protected int getExperiencePoints(final EntityPlayer lllllllllllllIllllIlllIllllIlllI) {
        return 1 + this.world.rand.nextInt(3);
    }
    
    @Override
    protected boolean canDespawn() {
        return true;
    }
    
    @Override
    public void onEntityUpdate() {
        int lllllllllllllIllllIlllIllllIlIIl = this.getAir();
        super.onEntityUpdate();
        if (this.isEntityAlive() && !this.isInWater()) {
            --lllllllllllllIllllIlllIllllIlIIl;
            this.setAir(lllllllllllllIllllIlllIllllIlIIl);
            if (this.getAir() == -20) {
                this.setAir(0);
                this.attackEntityFrom(DamageSource.drown, 2.0f);
            }
        }
        else {
            this.setAir(300);
        }
    }
    
    @Override
    public boolean canBreatheUnderwater() {
        return true;
    }
    
    public EntityWaterMob(final World lllllllllllllIllllIlllIllllllIlI) {
        super(lllllllllllllIllllIlllIllllllIlI);
    }
    
    @Override
    public boolean isNotColliding() {
        return this.world.checkNoEntityCollision(this.getEntityBoundingBox(), this);
    }
    
    @Override
    public boolean isPushedByWater() {
        return false;
    }
    
    @Override
    public boolean getCanSpawnHere() {
        return true;
    }
    
    @Override
    public int getTalkInterval() {
        return 120;
    }
}
