package net.minecraft.entity.passive;

import java.util.*;
import net.minecraft.block.*;
import net.minecraft.item.*;
import javax.annotation.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.nbt.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.init.*;
import net.minecraft.util.*;

public abstract class EntityAnimal extends EntityAgeable implements IAnimals
{
    private /* synthetic */ int inLove;
    private /* synthetic */ UUID playerInLove;
    protected /* synthetic */ Block spawnableBlock;
    
    public boolean isBreedingItem(final ItemStack llllllllllllllIIIllIlIlIlIIllIIl) {
        return llllllllllllllIIIllIlIlIlIIllIIl.getItem() == Items.WHEAT;
    }
    
    @Override
    public void handleStatusUpdate(final byte llllllllllllllIIIllIlIlIIlIlllll) {
        if (llllllllllllllIIIllIlIlIIlIlllll == 18) {
            for (int llllllllllllllIIIllIlIlIIllIIlII = 0; llllllllllllllIIIllIlIlIIllIIlII < 7; ++llllllllllllllIIIllIlIlIIllIIlII) {
                final double llllllllllllllIIIllIlIlIIllIIIll = this.rand.nextGaussian() * 0.02;
                final double llllllllllllllIIIllIlIlIIllIIIlI = this.rand.nextGaussian() * 0.02;
                final double llllllllllllllIIIllIlIlIIllIIIIl = this.rand.nextGaussian() * 0.02;
                this.world.spawnParticle(EnumParticleTypes.HEART, this.posX + this.rand.nextFloat() * this.width * 2.0f - this.width, this.posY + 0.5 + this.rand.nextFloat() * this.height, this.posZ + this.rand.nextFloat() * this.width * 2.0f - this.width, llllllllllllllIIIllIlIlIIllIIIll, llllllllllllllIIIllIlIlIIllIIIlI, llllllllllllllIIIllIlIlIIllIIIIl, new int[0]);
            }
        }
        else {
            super.handleStatusUpdate(llllllllllllllIIIllIlIlIIlIlllll);
        }
    }
    
    public boolean isInLove() {
        return this.inLove > 0;
    }
    
    @Override
    public int getTalkInterval() {
        return 120;
    }
    
    public void setInLove(@Nullable final EntityPlayer llllllllllllllIIIllIlIlIIlllllll) {
        this.inLove = 600;
        if (llllllllllllllIIIllIlIlIIlllllll != null) {
            this.playerInLove = llllllllllllllIIIllIlIlIIlllllll.getUniqueID();
        }
        this.world.setEntityState(this, (byte)18);
    }
    
    public void resetInLove() {
        this.inLove = 0;
    }
    
    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (this.getGrowingAge() != 0) {
            this.inLove = 0;
        }
        if (this.inLove > 0) {
            --this.inLove;
            if (this.inLove % 10 == 0) {
                final double llllllllllllllIIIllIlIlIllIlIllI = this.rand.nextGaussian() * 0.02;
                final double llllllllllllllIIIllIlIlIllIlIlIl = this.rand.nextGaussian() * 0.02;
                final double llllllllllllllIIIllIlIlIllIlIlII = this.rand.nextGaussian() * 0.02;
                this.world.spawnParticle(EnumParticleTypes.HEART, this.posX + this.rand.nextFloat() * this.width * 2.0f - this.width, this.posY + 0.5 + this.rand.nextFloat() * this.height, this.posZ + this.rand.nextFloat() * this.width * 2.0f - this.width, llllllllllllllIIIllIlIlIllIlIllI, llllllllllllllIIIllIlIlIllIlIlIl, llllllllllllllIIIllIlIlIllIlIlII, new int[0]);
            }
        }
    }
    
    @Nullable
    public EntityPlayerMP func_191993_do() {
        if (this.playerInLove == null) {
            return null;
        }
        final EntityPlayer llllllllllllllIIIllIlIlIIllllIll = this.world.getPlayerEntityByUUID(this.playerInLove);
        return (llllllllllllllIIIllIlIlIIllllIll instanceof EntityPlayerMP) ? ((EntityPlayerMP)llllllllllllllIIIllIlIlIIllllIll) : null;
    }
    
    @Override
    public void readEntityFromNBT(final NBTTagCompound llllllllllllllIIIllIlIlIlIllIIIl) {
        super.readEntityFromNBT(llllllllllllllIIIllIlIlIlIllIIIl);
        this.inLove = llllllllllllllIIIllIlIlIlIllIIIl.getInteger("InLove");
        this.playerInLove = (llllllllllllllIIIllIlIlIlIllIIIl.hasUniqueId("LoveCause") ? llllllllllllllIIIllIlIlIlIllIIIl.getUniqueId("LoveCause") : null);
    }
    
    protected void consumeItemFromStack(final EntityPlayer llllllllllllllIIIllIlIlIlIIIlIII, final ItemStack llllllllllllllIIIllIlIlIlIIIIlll) {
        if (!llllllllllllllIIIllIlIlIlIIIlIII.capabilities.isCreativeMode) {
            llllllllllllllIIIllIlIlIlIIIIlll.func_190918_g(1);
        }
    }
    
    @Override
    public boolean processInteract(final EntityPlayer llllllllllllllIIIllIlIlIlIIlIIlI, final EnumHand llllllllllllllIIIllIlIlIlIIlIIIl) {
        final ItemStack llllllllllllllIIIllIlIlIlIIlIIII = llllllllllllllIIIllIlIlIlIIlIIlI.getHeldItem(llllllllllllllIIIllIlIlIlIIlIIIl);
        if (!llllllllllllllIIIllIlIlIlIIlIIII.func_190926_b()) {
            if (this.isBreedingItem(llllllllllllllIIIllIlIlIlIIlIIII) && this.getGrowingAge() == 0 && this.inLove <= 0) {
                this.consumeItemFromStack(llllllllllllllIIIllIlIlIlIIlIIlI, llllllllllllllIIIllIlIlIlIIlIIII);
                this.setInLove(llllllllllllllIIIllIlIlIlIIlIIlI);
                return true;
            }
            if (this.isChild() && this.isBreedingItem(llllllllllllllIIIllIlIlIlIIlIIII)) {
                this.consumeItemFromStack(llllllllllllllIIIllIlIlIlIIlIIlI, llllllllllllllIIIllIlIlIlIIlIIII);
                this.ageUp((int)(-this.getGrowingAge() / 20 * 0.1f), true);
                return true;
            }
        }
        return super.processInteract(llllllllllllllIIIllIlIlIlIIlIIlI, llllllllllllllIIIllIlIlIlIIlIIIl);
    }
    
    @Override
    public double getYOffset() {
        return 0.14;
    }
    
    @Override
    public float getBlockPathWeight(final BlockPos llllllllllllllIIIllIlIlIllIIIIll) {
        return (this.world.getBlockState(llllllllllllllIIIllIlIlIllIIIIll.down()).getBlock() == this.spawnableBlock) ? 10.0f : (this.world.getLightBrightness(llllllllllllllIIIllIlIlIllIIIIll) - 0.5f);
    }
    
    @Override
    public boolean getCanSpawnHere() {
        final int llllllllllllllIIIllIlIlIlIlIlIlI = MathHelper.floor(this.posX);
        final int llllllllllllllIIIllIlIlIlIlIlIIl = MathHelper.floor(this.getEntityBoundingBox().minY);
        final int llllllllllllllIIIllIlIlIlIlIlIII = MathHelper.floor(this.posZ);
        final BlockPos llllllllllllllIIIllIlIlIlIlIIlll = new BlockPos(llllllllllllllIIIllIlIlIlIlIlIlI, llllllllllllllIIIllIlIlIlIlIlIIl, llllllllllllllIIIllIlIlIlIlIlIII);
        return this.world.getBlockState(llllllllllllllIIIllIlIlIlIlIIlll.down()).getBlock() == this.spawnableBlock && this.world.getLight(llllllllllllllIIIllIlIlIlIlIIlll) > 8 && super.getCanSpawnHere();
    }
    
    public boolean canMateWith(final EntityAnimal llllllllllllllIIIllIlIlIIllIllll) {
        return llllllllllllllIIIllIlIlIIllIllll != this && llllllllllllllIIIllIlIlIIllIllll.getClass() == this.getClass() && (this.isInLove() && llllllllllllllIIIllIlIlIIllIllll.isInLove());
    }
    
    @Override
    protected void updateAITasks() {
        if (this.getGrowingAge() != 0) {
            this.inLove = 0;
        }
        super.updateAITasks();
    }
    
    @Override
    protected int getExperiencePoints(final EntityPlayer llllllllllllllIIIllIlIlIlIIlllIl) {
        return 1 + this.world.rand.nextInt(3);
    }
    
    public EntityAnimal(final World llllllllllllllIIIllIlIlIllIlllll) {
        super(llllllllllllllIIIllIlIlIllIlllll);
        this.spawnableBlock = Blocks.GRASS;
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource llllllllllllllIIIllIlIlIllIIlIII, final float llllllllllllllIIIllIlIlIllIIIlll) {
        if (this.isEntityInvulnerable(llllllllllllllIIIllIlIlIllIIlIII)) {
            return false;
        }
        this.inLove = 0;
        return super.attackEntityFrom(llllllllllllllIIIllIlIlIllIIlIII, llllllllllllllIIIllIlIlIllIIIlll);
    }
    
    @Override
    protected boolean canDespawn() {
        return false;
    }
    
    @Override
    public void writeEntityToNBT(final NBTTagCompound llllllllllllllIIIllIlIlIlIlllIll) {
        super.writeEntityToNBT(llllllllllllllIIIllIlIlIlIlllIll);
        llllllllllllllIIIllIlIlIlIlllIll.setInteger("InLove", this.inLove);
        if (this.playerInLove != null) {
            llllllllllllllIIIllIlIlIlIlllIll.setUniqueId("LoveCause", this.playerInLove);
        }
    }
}
