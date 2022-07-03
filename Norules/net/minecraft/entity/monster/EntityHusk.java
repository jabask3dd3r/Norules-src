package net.minecraft.entity.monster;

import net.minecraft.util.datafix.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;
import net.minecraft.init.*;
import net.minecraft.potion.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.world.storage.loot.*;
import javax.annotation.*;
import net.minecraft.world.*;

public class EntityHusk extends EntityZombie
{
    @Override
    protected SoundEvent getHurtSound(final DamageSource llllllllllllIlllllIlllllllIlIIll) {
        return SoundEvents.ENTITY_HUSK_HURT;
    }
    
    public static void func_190740_b(final DataFixer llllllllllllIlllllIlllllllIllIlI) {
        EntityLiving.registerFixesMob(llllllllllllIlllllIlllllllIllIlI, EntityHusk.class);
    }
    
    @Override
    protected SoundEvent func_190731_di() {
        return SoundEvents.ENTITY_HUSK_STEP;
    }
    
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_HUSK_DEATH;
    }
    
    @Override
    public boolean attackEntityAsMob(final Entity llllllllllllIlllllIlllllllIIIllI) {
        final boolean llllllllllllIlllllIlllllllIIlIIl = super.attackEntityAsMob(llllllllllllIlllllIlllllllIIIllI);
        if (llllllllllllIlllllIlllllllIIlIIl && this.getHeldItemMainhand().func_190926_b() && llllllllllllIlllllIlllllllIIIllI instanceof EntityLivingBase) {
            final float llllllllllllIlllllIlllllllIIlIII = this.world.getDifficultyForLocation(new BlockPos(this)).getAdditionalDifficulty();
            ((EntityLivingBase)llllllllllllIlllllIlllllllIIIllI).addPotionEffect(new PotionEffect(MobEffects.HUNGER, 140 * (int)llllllllllllIlllllIlllllllIIlIII));
        }
        return llllllllllllIlllllIlllllllIIlIIl;
    }
    
    @Override
    protected ItemStack func_190732_dj() {
        return ItemStack.field_190927_a;
    }
    
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_HUSK_AMBIENT;
    }
    
    @Nullable
    @Override
    protected ResourceLocation getLootTable() {
        return LootTableList.field_191182_ar;
    }
    
    @Override
    public boolean getCanSpawnHere() {
        return super.getCanSpawnHere() && this.world.canSeeSky(new BlockPos(this));
    }
    
    public EntityHusk(final World llllllllllllIlllllIlllllllIlllIl) {
        super(llllllllllllIlllllIlllllllIlllIl);
    }
    
    @Override
    protected boolean func_190730_o() {
        return false;
    }
}
