package net.minecraft.entity.monster;

import net.minecraft.world.storage.loot.*;
import javax.annotation.*;
import net.minecraft.init.*;
import net.minecraft.util.datafix.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.world.*;

public class EntityMagmaCube extends EntitySlime
{
    public EntityMagmaCube(final World llllllllllllllllllIIlIIllIllIIIl) {
        super(llllllllllllllllllIIlIIllIllIIIl);
        this.isImmuneToFire = true;
    }
    
    @Nullable
    @Override
    protected ResourceLocation getLootTable() {
        return this.isSmallSlime() ? LootTableList.EMPTY : LootTableList.ENTITIES_MAGMA_CUBE;
    }
    
    @Override
    protected boolean canDamagePlayer() {
        return true;
    }
    
    @Override
    protected EntitySlime createInstance() {
        return new EntityMagmaCube(this.world);
    }
    
    @Override
    public boolean isNotColliding() {
        return this.world.checkNoEntityCollision(this.getEntityBoundingBox(), this) && this.world.getCollisionBoxes(this, this.getEntityBoundingBox()).isEmpty() && !this.world.containsAnyLiquid(this.getEntityBoundingBox());
    }
    
    @Override
    protected int getJumpDelay() {
        return super.getJumpDelay() * 4;
    }
    
    @Override
    protected SoundEvent getJumpSound() {
        return SoundEvents.ENTITY_MAGMACUBE_JUMP;
    }
    
    @Override
    protected void setSlimeSize(final int llllllllllllllllllIIlIIllIIllllI, final boolean llllllllllllllllllIIlIIllIIllIlI) {
        super.setSlimeSize(llllllllllllllllllIIlIIllIIllllI, llllllllllllllllllIIlIIllIIllIlI);
        this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(llllllllllllllllllIIlIIllIIllllI * 3);
    }
    
    @Override
    protected EnumParticleTypes getParticleType() {
        return EnumParticleTypes.FLAME;
    }
    
    @Override
    public void fall(final float llllllllllllllllllIIlIIllIIIIIlI, final float llllllllllllllllllIIlIIllIIIIIIl) {
    }
    
    @Override
    protected void handleJumpLava() {
        this.motionY = 0.22f + this.getSlimeSize() * 0.05f;
        this.isAirBorne = true;
    }
    
    public static void registerFixesMagmaCube(final DataFixer llllllllllllllllllIIlIIllIlIllIl) {
        EntityLiving.registerFixesMob(llllllllllllllllllIIlIIllIlIllIl, EntityMagmaCube.class);
    }
    
    @Override
    protected SoundEvent getDeathSound() {
        return this.isSmallSlime() ? SoundEvents.ENTITY_SMALL_MAGMACUBE_DEATH : SoundEvents.ENTITY_MAGMACUBE_DEATH;
    }
    
    @Override
    protected void jump() {
        this.motionY = 0.42f + this.getSlimeSize() * 0.1f;
        this.isAirBorne = true;
    }
    
    @Override
    protected SoundEvent getSquishSound() {
        return this.isSmallSlime() ? SoundEvents.ENTITY_SMALL_MAGMACUBE_SQUISH : SoundEvents.ENTITY_MAGMACUBE_SQUISH;
    }
    
    @Override
    public boolean isBurning() {
        return false;
    }
    
    @Override
    public int getBrightnessForRender() {
        return 15728880;
    }
    
    @Override
    protected SoundEvent getHurtSound(final DamageSource llllllllllllllllllIIlIIlIllllIlI) {
        return this.isSmallSlime() ? SoundEvents.ENTITY_SMALL_MAGMACUBE_HURT : SoundEvents.ENTITY_MAGMACUBE_HURT;
    }
    
    @Override
    public boolean getCanSpawnHere() {
        return this.world.getDifficulty() != EnumDifficulty.PEACEFUL;
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.20000000298023224);
    }
    
    @Override
    public float getBrightness() {
        return 1.0f;
    }
    
    @Override
    protected void alterSquishAmount() {
        this.squishAmount *= 0.9f;
    }
    
    @Override
    protected int getAttackStrength() {
        return super.getAttackStrength() + 2;
    }
}
