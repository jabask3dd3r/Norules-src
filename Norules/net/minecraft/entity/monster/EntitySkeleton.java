package net.minecraft.entity.monster;

import net.minecraft.world.storage.loot.*;
import javax.annotation.*;
import net.minecraft.inventory.*;
import net.minecraft.init.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.util.datafix.*;
import net.minecraft.entity.*;

public class EntitySkeleton extends AbstractSkeleton
{
    @Nullable
    @Override
    protected ResourceLocation getLootTable() {
        return LootTableList.ENTITIES_SKELETON;
    }
    
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_SKELETON_DEATH;
    }
    
    @Override
    protected EntityArrow func_190726_a(final float lllllllllllllIIlllIlIllllIIIIlll) {
        final ItemStack lllllllllllllIIlllIlIllllIIIIllI = this.getItemStackFromSlot(EntityEquipmentSlot.OFFHAND);
        if (lllllllllllllIIlllIlIllllIIIIllI.getItem() == Items.SPECTRAL_ARROW) {
            final EntitySpectralArrow lllllllllllllIIlllIlIllllIIIIlIl = new EntitySpectralArrow(this.world, this);
            lllllllllllllIIlllIlIllllIIIIlIl.func_190547_a(this, lllllllllllllIIlllIlIllllIIIIlll);
            return lllllllllllllIIlllIlIllllIIIIlIl;
        }
        final EntityArrow lllllllllllllIIlllIlIllllIIIIlII = super.func_190726_a(lllllllllllllIIlllIlIllllIIIIlll);
        if (lllllllllllllIIlllIlIllllIIIIllI.getItem() == Items.TIPPED_ARROW && lllllllllllllIIlllIlIllllIIIIlII instanceof EntityTippedArrow) {
            ((EntityTippedArrow)lllllllllllllIIlllIlIllllIIIIlII).setPotionEffect(lllllllllllllIIlllIlIllllIIIIllI);
        }
        return lllllllllllllIIlllIlIllllIIIIlII;
    }
    
    @Override
    SoundEvent func_190727_o() {
        return SoundEvents.ENTITY_SKELETON_STEP;
    }
    
    @Override
    public void onDeath(final DamageSource lllllllllllllIIlllIlIllllIIlIIIl) {
        super.onDeath(lllllllllllllIIlllIlIllllIIlIIIl);
        if (lllllllllllllIIlllIlIllllIIlIIIl.getEntity() instanceof EntityCreeper) {
            final EntityCreeper lllllllllllllIIlllIlIllllIIlIIII = (EntityCreeper)lllllllllllllIIlllIlIllllIIlIIIl.getEntity();
            if (lllllllllllllIIlllIlIllllIIlIIII.getPowered() && lllllllllllllIIlllIlIllllIIlIIII.isAIEnabled()) {
                lllllllllllllIIlllIlIllllIIlIIII.incrementDroppedSkulls();
                this.entityDropItem(new ItemStack(Items.SKULL, 1, 0), 0.0f);
            }
        }
    }
    
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_SKELETON_AMBIENT;
    }
    
    @Override
    protected SoundEvent getHurtSound(final DamageSource lllllllllllllIIlllIlIllllIIllIII) {
        return SoundEvents.ENTITY_SKELETON_HURT;
    }
    
    public EntitySkeleton(final World lllllllllllllIIlllIlIllllIIlllll) {
        super(lllllllllllllIIlllIlIllllIIlllll);
    }
    
    public static void registerFixesSkeleton(final DataFixer lllllllllllllIIlllIlIllllIIlllII) {
        EntityLiving.registerFixesMob(lllllllllllllIIlllIlIllllIIlllII, EntitySkeleton.class);
    }
}
