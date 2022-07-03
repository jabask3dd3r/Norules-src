package net.minecraft.entity.ai;

import net.minecraft.world.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.*;
import net.minecraft.entity.monster.*;
import net.minecraft.inventory.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.enchantment.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.effect.*;

public class EntityAISkeletonRiders extends EntityAIBase
{
    private final /* synthetic */ EntitySkeletonHorse horse;
    
    private AbstractHorse createHorse(final DifficultyInstance llllllllllllllIlIIlIlIlIIIllIllI) {
        final EntitySkeletonHorse llllllllllllllIlIIlIlIlIIIlllIII = new EntitySkeletonHorse(this.horse.world);
        llllllllllllllIlIIlIlIlIIIlllIII.onInitialSpawn(llllllllllllllIlIIlIlIlIIIllIllI, null);
        llllllllllllllIlIIlIlIlIIIlllIII.setPosition(this.horse.posX, this.horse.posY, this.horse.posZ);
        llllllllllllllIlIIlIlIlIIIlllIII.hurtResistantTime = 60;
        llllllllllllllIlIIlIlIlIIIlllIII.enablePersistence();
        llllllllllllllIlIIlIlIlIIIlllIII.setHorseTamed(true);
        llllllllllllllIlIIlIlIlIIIlllIII.setGrowingAge(0);
        llllllllllllllIlIIlIlIlIIIlllIII.world.spawnEntityInWorld(llllllllllllllIlIIlIlIlIIIlllIII);
        return llllllllllllllIlIIlIlIlIIIlllIII;
    }
    
    private EntitySkeleton createSkeleton(final DifficultyInstance llllllllllllllIlIIlIlIlIIIllIIII, final AbstractHorse llllllllllllllIlIIlIlIlIIIlIllII) {
        final EntitySkeleton llllllllllllllIlIIlIlIlIIIlIlllI = new EntitySkeleton(llllllllllllllIlIIlIlIlIIIlIllII.world);
        llllllllllllllIlIIlIlIlIIIlIlllI.onInitialSpawn(llllllllllllllIlIIlIlIlIIIllIIII, null);
        llllllllllllllIlIIlIlIlIIIlIlllI.setPosition(llllllllllllllIlIIlIlIlIIIlIllII.posX, llllllllllllllIlIIlIlIlIIIlIllII.posY, llllllllllllllIlIIlIlIlIIIlIllII.posZ);
        llllllllllllllIlIIlIlIlIIIlIlllI.hurtResistantTime = 60;
        llllllllllllllIlIIlIlIlIIIlIlllI.enablePersistence();
        if (llllllllllllllIlIIlIlIlIIIlIlllI.getItemStackFromSlot(EntityEquipmentSlot.HEAD).func_190926_b()) {
            llllllllllllllIlIIlIlIlIIIlIlllI.setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(Items.IRON_HELMET));
        }
        llllllllllllllIlIIlIlIlIIIlIlllI.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, EnchantmentHelper.addRandomEnchantment(llllllllllllllIlIIlIlIlIIIlIlllI.getRNG(), llllllllllllllIlIIlIlIlIIIlIlllI.getHeldItemMainhand(), (int)(5.0f + llllllllllllllIlIIlIlIlIIIllIIII.getClampedAdditionalDifficulty() * llllllllllllllIlIIlIlIlIIIlIlllI.getRNG().nextInt(18)), false));
        llllllllllllllIlIIlIlIlIIIlIlllI.setItemStackToSlot(EntityEquipmentSlot.HEAD, EnchantmentHelper.addRandomEnchantment(llllllllllllllIlIIlIlIlIIIlIlllI.getRNG(), llllllllllllllIlIIlIlIlIIIlIlllI.getItemStackFromSlot(EntityEquipmentSlot.HEAD), (int)(5.0f + llllllllllllllIlIIlIlIlIIIllIIII.getClampedAdditionalDifficulty() * llllllllllllllIlIIlIlIlIIIlIlllI.getRNG().nextInt(18)), false));
        llllllllllllllIlIIlIlIlIIIlIlllI.world.spawnEntityInWorld(llllllllllllllIlIIlIlIlIIIlIlllI);
        return llllllllllllllIlIIlIlIlIIIlIlllI;
    }
    
    @Override
    public void updateTask() {
        final DifficultyInstance llllllllllllllIlIIlIlIlIIlIIlIII = this.horse.world.getDifficultyForLocation(new BlockPos(this.horse));
        this.horse.func_190691_p(false);
        this.horse.setHorseTamed(true);
        this.horse.setGrowingAge(0);
        this.horse.world.addWeatherEffect(new EntityLightningBolt(this.horse.world, this.horse.posX, this.horse.posY, this.horse.posZ, true));
        final EntitySkeleton llllllllllllllIlIIlIlIlIIlIIIlll = this.createSkeleton(llllllllllllllIlIIlIlIlIIlIIlIII, this.horse);
        llllllllllllllIlIIlIlIlIIlIIIlll.startRiding(this.horse);
        for (int llllllllllllllIlIIlIlIlIIlIIIllI = 0; llllllllllllllIlIIlIlIlIIlIIIllI < 3; ++llllllllllllllIlIIlIlIlIIlIIIllI) {
            final AbstractHorse llllllllllllllIlIIlIlIlIIlIIIlIl = this.createHorse(llllllllllllllIlIIlIlIlIIlIIlIII);
            final EntitySkeleton llllllllllllllIlIIlIlIlIIlIIIlII = this.createSkeleton(llllllllllllllIlIIlIlIlIIlIIlIII, llllllllllllllIlIIlIlIlIIlIIIlIl);
            llllllllllllllIlIIlIlIlIIlIIIlII.startRiding(llllllllllllllIlIIlIlIlIIlIIIlIl);
            llllllllllllllIlIIlIlIlIIlIIIlIl.addVelocity(this.horse.getRNG().nextGaussian() * 0.5, 0.0, this.horse.getRNG().nextGaussian() * 0.5);
        }
    }
    
    public EntityAISkeletonRiders(final EntitySkeletonHorse llllllllllllllIlIIlIlIlIIlIlIIll) {
        this.horse = llllllllllllllIlIIlIlIlIIlIlIIll;
    }
    
    @Override
    public boolean shouldExecute() {
        return this.horse.world.isAnyPlayerWithinRangeAt(this.horse.posX, this.horse.posY, this.horse.posZ, 10.0);
    }
}
