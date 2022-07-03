package net.minecraft.entity.monster;

import net.minecraft.world.storage.loot.*;
import javax.annotation.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.init.*;
import net.minecraft.potion.*;
import net.minecraft.world.*;
import net.minecraft.util.datafix.*;
import net.minecraft.entity.*;

public class EntityStray extends AbstractSkeleton
{
    @Nullable
    @Override
    protected ResourceLocation getLootTable() {
        return LootTableList.ENTITIES_STRAY;
    }
    
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_STRAY_AMBIENT;
    }
    
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_STRAY_DEATH;
    }
    
    @Override
    protected SoundEvent getHurtSound(final DamageSource lllllllllllllIIlIlIlIIlllIllllII) {
        return SoundEvents.ENTITY_STRAY_HURT;
    }
    
    @Override
    public boolean getCanSpawnHere() {
        return super.getCanSpawnHere() && this.world.canSeeSky(new BlockPos(this));
    }
    
    @Override
    SoundEvent func_190727_o() {
        return SoundEvents.ENTITY_STRAY_STEP;
    }
    
    @Override
    protected EntityArrow func_190726_a(final float lllllllllllllIIlIlIlIIlllIllIIlI) {
        final EntityArrow lllllllllllllIIlIlIlIIlllIllIlII = super.func_190726_a(lllllllllllllIIlIlIlIIlllIllIIlI);
        if (lllllllllllllIIlIlIlIIlllIllIlII instanceof EntityTippedArrow) {
            ((EntityTippedArrow)lllllllllllllIIlIlIlIIlllIllIlII).addEffect(new PotionEffect(MobEffects.SLOWNESS, 600));
        }
        return lllllllllllllIIlIlIlIIlllIllIlII;
    }
    
    public EntityStray(final World lllllllllllllIIlIlIlIIllllIIIllI) {
        super(lllllllllllllIIlIlIlIIllllIIIllI);
    }
    
    public static void func_190728_b(final DataFixer lllllllllllllIIlIlIlIIllllIIIIll) {
        EntityLiving.registerFixesMob(lllllllllllllIIlIlIlIIllllIIIIll, EntityStray.class);
    }
}
