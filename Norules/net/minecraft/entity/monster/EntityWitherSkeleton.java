package net.minecraft.entity.monster;

import net.minecraft.item.*;
import net.minecraft.inventory.*;
import javax.annotation.*;
import net.minecraft.util.datafix.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.util.*;
import net.minecraft.world.storage.loot.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.init.*;
import net.minecraft.potion.*;

public class EntityWitherSkeleton extends AbstractSkeleton
{
    @Override
    public void onDeath(final DamageSource lllllllllllllIIIlllllIlIlIlIIIlI) {
        super.onDeath(lllllllllllllIIIlllllIlIlIlIIIlI);
        if (lllllllllllllIIIlllllIlIlIlIIIlI.getEntity() instanceof EntityCreeper) {
            final EntityCreeper lllllllllllllIIIlllllIlIlIlIIlII = (EntityCreeper)lllllllllllllIIIlllllIlIlIlIIIlI.getEntity();
            if (lllllllllllllIIIlllllIlIlIlIIlII.getPowered() && lllllllllllllIIIlllllIlIlIlIIlII.isAIEnabled()) {
                lllllllllllllIIIlllllIlIlIlIIlII.incrementDroppedSkulls();
                this.entityDropItem(new ItemStack(Items.SKULL, 1, 1), 0.0f);
            }
        }
    }
    
    @Override
    SoundEvent func_190727_o() {
        return SoundEvents.ENTITY_WITHER_SKELETON_STEP;
    }
    
    @Override
    protected void setEquipmentBasedOnDifficulty(final DifficultyInstance lllllllllllllIIIlllllIlIlIIllllI) {
        this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.STONE_SWORD));
    }
    
    @Nullable
    @Override
    public IEntityLivingData onInitialSpawn(final DifficultyInstance lllllllllllllIIIlllllIlIlIIlIlIl, @Nullable final IEntityLivingData lllllllllllllIIIlllllIlIlIIlIlII) {
        final IEntityLivingData lllllllllllllIIIlllllIlIlIIlIIll = super.onInitialSpawn(lllllllllllllIIIlllllIlIlIIlIlIl, lllllllllllllIIIlllllIlIlIIlIlII);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.0);
        this.setCombatTask();
        return lllllllllllllIIIlllllIlIlIIlIIll;
    }
    
    @Override
    public float getEyeHeight() {
        return 2.1f;
    }
    
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_WITHER_SKELETON_DEATH;
    }
    
    public static void func_190729_b(final DataFixer lllllllllllllIIIlllllIlIlIllIIII) {
        EntityLiving.registerFixesMob(lllllllllllllIIIlllllIlIlIllIIII, EntityWitherSkeleton.class);
    }
    
    @Override
    protected EntityArrow func_190726_a(final float lllllllllllllIIIlllllIlIlIIIIIll) {
        final EntityArrow lllllllllllllIIIlllllIlIlIIIIIlI = super.func_190726_a(lllllllllllllIIIlllllIlIlIIIIIll);
        lllllllllllllIIIlllllIlIlIIIIIlI.setFire(100);
        return lllllllllllllIIIlllllIlIlIIIIIlI;
    }
    
    @Nullable
    @Override
    protected ResourceLocation getLootTable() {
        return LootTableList.ENTITIES_WITHER_SKELETON;
    }
    
    @Override
    protected SoundEvent getHurtSound(final DamageSource lllllllllllllIIIlllllIlIlIlIllII) {
        return SoundEvents.ENTITY_WITHER_SKELETON_HURT;
    }
    
    @Override
    protected void setEnchantmentBasedOnDifficulty(final DifficultyInstance lllllllllllllIIIlllllIlIlIIllIll) {
    }
    
    public EntityWitherSkeleton(final World lllllllllllllIIIlllllIlIlIllIIll) {
        super(lllllllllllllIIIlllllIlIlIllIIll);
        this.setSize(0.7f, 2.4f);
        this.isImmuneToFire = true;
    }
    
    @Override
    public boolean attackEntityAsMob(final Entity lllllllllllllIIIlllllIlIlIIIlIII) {
        if (!super.attackEntityAsMob(lllllllllllllIIIlllllIlIlIIIlIII)) {
            return false;
        }
        if (lllllllllllllIIIlllllIlIlIIIlIII instanceof EntityLivingBase) {
            ((EntityLivingBase)lllllllllllllIIIlllllIlIlIIIlIII).addPotionEffect(new PotionEffect(MobEffects.WITHER, 200));
        }
        return true;
    }
    
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_WITHER_SKELETON_AMBIENT;
    }
}
