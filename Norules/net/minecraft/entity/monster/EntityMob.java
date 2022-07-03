package net.minecraft.entity.monster;

import net.minecraft.entity.*;
import net.minecraft.enchantment.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.util.*;

public abstract class EntityMob extends EntityCreature implements IMob
{
    @Override
    protected SoundEvent getHurtSound(final DamageSource lllllllllllllIIlIIlIllIIllIlllIl) {
        return SoundEvents.ENTITY_HOSTILE_HURT;
    }
    
    @Override
    public boolean attackEntityAsMob(final Entity lllllllllllllIIlIIlIllIIllIIIIlI) {
        float lllllllllllllIIlIIlIllIIllIIlIll = (float)this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue();
        int lllllllllllllIIlIIlIllIIllIIlIlI = 0;
        if (lllllllllllllIIlIIlIllIIllIIIIlI instanceof EntityLivingBase) {
            lllllllllllllIIlIIlIllIIllIIlIll += EnchantmentHelper.getModifierForCreature(this.getHeldItemMainhand(), ((EntityLivingBase)lllllllllllllIIlIIlIllIIllIIIIlI).getCreatureAttribute());
            lllllllllllllIIlIIlIllIIllIIlIlI += EnchantmentHelper.getKnockbackModifier(this);
        }
        final boolean lllllllllllllIIlIIlIllIIllIIlIIl = lllllllllllllIIlIIlIllIIllIIIIlI.attackEntityFrom(DamageSource.causeMobDamage(this), lllllllllllllIIlIIlIllIIllIIlIll);
        if (lllllllllllllIIlIIlIllIIllIIlIIl) {
            if (lllllllllllllIIlIIlIllIIllIIlIlI > 0 && lllllllllllllIIlIIlIllIIllIIIIlI instanceof EntityLivingBase) {
                ((EntityLivingBase)lllllllllllllIIlIIlIllIIllIIIIlI).knockBack(this, lllllllllllllIIlIIlIllIIllIIlIlI * 0.5f, MathHelper.sin(this.rotationYaw * 0.017453292f), -MathHelper.cos(this.rotationYaw * 0.017453292f));
                this.motionX *= 0.6;
                this.motionZ *= 0.6;
            }
            final int lllllllllllllIIlIIlIllIIllIIlIII = EnchantmentHelper.getFireAspectModifier(this);
            if (lllllllllllllIIlIIlIllIIllIIlIII > 0) {
                lllllllllllllIIlIIlIllIIllIIIIlI.setFire(lllllllllllllIIlIIlIllIIllIIlIII * 4);
            }
            if (lllllllllllllIIlIIlIllIIllIIIIlI instanceof EntityPlayer) {
                final EntityPlayer lllllllllllllIIlIIlIllIIllIIIlll = (EntityPlayer)lllllllllllllIIlIIlIllIIllIIIIlI;
                final ItemStack lllllllllllllIIlIIlIllIIllIIIllI = this.getHeldItemMainhand();
                final ItemStack lllllllllllllIIlIIlIllIIllIIIlIl = lllllllllllllIIlIIlIllIIllIIIlll.isHandActive() ? lllllllllllllIIlIIlIllIIllIIIlll.getActiveItemStack() : ItemStack.field_190927_a;
                if (!lllllllllllllIIlIIlIllIIllIIIllI.func_190926_b() && !lllllllllllllIIlIIlIllIIllIIIlIl.func_190926_b() && lllllllllllllIIlIIlIllIIllIIIllI.getItem() instanceof ItemAxe && lllllllllllllIIlIIlIllIIllIIIlIl.getItem() == Items.SHIELD) {
                    final float lllllllllllllIIlIIlIllIIllIIIlII = 0.25f + EnchantmentHelper.getEfficiencyModifier(this) * 0.05f;
                    if (this.rand.nextFloat() < lllllllllllllIIlIIlIllIIllIIIlII) {
                        lllllllllllllIIlIIlIllIIllIIIlll.getCooldownTracker().setCooldown(Items.SHIELD, 100);
                        this.world.setEntityState(lllllllllllllIIlIIlIllIIllIIIlll, (byte)30);
                    }
                }
            }
            this.applyEnchantments(this, lllllllllllllIIlIIlIllIIllIIIIlI);
        }
        return lllllllllllllIIlIIlIllIIllIIlIIl;
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
    }
    
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_HOSTILE_DEATH;
    }
    
    @Override
    protected SoundEvent getFallSound(final int lllllllllllllIIlIIlIllIIllIllIIl) {
        return (lllllllllllllIIlIIlIllIIllIllIIl > 4) ? SoundEvents.ENTITY_HOSTILE_BIG_FALL : SoundEvents.ENTITY_HOSTILE_SMALL_FALL;
    }
    
    protected boolean isValidLightLevel() {
        final BlockPos lllllllllllllIIlIIlIllIIlIlIlllI = new BlockPos(this.posX, this.getEntityBoundingBox().minY, this.posZ);
        if (this.world.getLightFor(EnumSkyBlock.SKY, lllllllllllllIIlIIlIllIIlIlIlllI) > this.rand.nextInt(32)) {
            return false;
        }
        int lllllllllllllIIlIIlIllIIlIlIllIl = this.world.getLightFromNeighbors(lllllllllllllIIlIIlIllIIlIlIlllI);
        if (this.world.isThundering()) {
            final int lllllllllllllIIlIIlIllIIlIlIllII = this.world.getSkylightSubtracted();
            this.world.setSkylightSubtracted(10);
            lllllllllllllIIlIIlIllIIlIlIllIl = this.world.getLightFromNeighbors(lllllllllllllIIlIIlIllIIlIlIlllI);
            this.world.setSkylightSubtracted(lllllllllllllIIlIIlIllIIlIlIllII);
        }
        return lllllllllllllIIlIIlIllIIlIlIllIl <= this.rand.nextInt(8);
    }
    
    @Override
    protected SoundEvent getSwimSound() {
        return SoundEvents.ENTITY_HOSTILE_SWIM;
    }
    
    public EntityMob(final World lllllllllllllIIlIIlIllIIllllIlII) {
        super(lllllllllllllIIlIIlIllIIllllIlII);
        this.experienceValue = 5;
    }
    
    @Override
    public void onLivingUpdate() {
        this.updateArmSwingProgress();
        final float lllllllllllllIIlIIlIllIIlllIllll = this.getBrightness();
        if (lllllllllllllIIlIIlIllIIlllIllll > 0.5f) {
            this.entityAge += 2;
        }
        super.onLivingUpdate();
    }
    
    @Override
    protected boolean canDropLoot() {
        return true;
    }
    
    @Override
    protected SoundEvent getSplashSound() {
        return SoundEvents.ENTITY_HOSTILE_SPLASH;
    }
    
    @Override
    public void onUpdate() {
        super.onUpdate();
        if (!this.world.isRemote && this.world.getDifficulty() == EnumDifficulty.PEACEFUL) {
            this.setDead();
        }
    }
    
    @Override
    public SoundCategory getSoundCategory() {
        return SoundCategory.HOSTILE;
    }
    
    @Override
    public boolean getCanSpawnHere() {
        return this.world.getDifficulty() != EnumDifficulty.PEACEFUL && this.isValidLightLevel() && super.getCanSpawnHere();
    }
    
    public boolean func_191990_c(final EntityPlayer lllllllllllllIIlIIlIllIIlIIlllll) {
        return true;
    }
    
    @Override
    public float getBlockPathWeight(final BlockPos lllllllllllllIIlIIlIllIIlIllIlII) {
        return 0.5f - this.world.getLightBrightness(lllllllllllllIIlIIlIllIIlIllIlII);
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource lllllllllllllIIlIIlIllIIlllIIIII, final float lllllllllllllIIlIIlIllIIlllIIIlI) {
        return !this.isEntityInvulnerable(lllllllllllllIIlIIlIllIIlllIIIII) && super.attackEntityFrom(lllllllllllllIIlIIlIllIIlllIIIII, lllllllllllllIIlIIlIllIIlllIIIlI);
    }
}
