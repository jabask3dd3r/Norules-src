package net.minecraft.entity.item;

import net.minecraft.entity.player.*;
import net.minecraft.block.material.*;
import net.minecraft.util.math.*;
import net.minecraft.util.*;
import net.minecraft.nbt.*;
import net.minecraft.init.*;
import net.minecraft.enchantment.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.world.*;

public class EntityXPOrb extends Entity
{
    private /* synthetic */ int xpValue;
    private /* synthetic */ EntityPlayer closestPlayer;
    public /* synthetic */ int xpColor;
    public /* synthetic */ int delayBeforeCanPickup;
    private /* synthetic */ int xpOrbHealth;
    private /* synthetic */ int xpTargetColor;
    public /* synthetic */ int xpOrbAge;
    
    private int durabilityToXp(final int lllllllllllllIlIlIlllIllIIIlIllI) {
        return lllllllllllllIlIlIlllIllIIIlIllI / 2;
    }
    
    public static int getXPSplit(final int lllllllllllllIlIlIlllIllIIIIlIlI) {
        if (lllllllllllllIlIlIlllIllIIIIlIlI >= 2477) {
            return 2477;
        }
        if (lllllllllllllIlIlIlllIllIIIIlIlI >= 1237) {
            return 1237;
        }
        if (lllllllllllllIlIlIlllIllIIIIlIlI >= 617) {
            return 617;
        }
        if (lllllllllllllIlIlIlllIllIIIIlIlI >= 307) {
            return 307;
        }
        if (lllllllllllllIlIlIlllIllIIIIlIlI >= 149) {
            return 149;
        }
        if (lllllllllllllIlIlIlllIllIIIIlIlI >= 73) {
            return 73;
        }
        if (lllllllllllllIlIlIlllIllIIIIlIlI >= 37) {
            return 37;
        }
        if (lllllllllllllIlIlIlllIllIIIIlIlI >= 17) {
            return 17;
        }
        if (lllllllllllllIlIlIlllIllIIIIlIlI >= 7) {
            return 7;
        }
        return (lllllllllllllIlIlIlllIllIIIIlIlI >= 3) ? 3 : 1;
    }
    
    @Override
    public void onUpdate() {
        super.onUpdate();
        if (this.delayBeforeCanPickup > 0) {
            --this.delayBeforeCanPickup;
        }
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (!this.hasNoGravity()) {
            this.motionY -= 0.029999999329447746;
        }
        if (this.world.getBlockState(new BlockPos(this)).getMaterial() == Material.LAVA) {
            this.motionY = 0.20000000298023224;
            this.motionX = (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f;
            this.motionZ = (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f;
            this.playSound(SoundEvents.ENTITY_GENERIC_BURN, 0.4f, 2.0f + this.rand.nextFloat() * 0.4f);
        }
        this.pushOutOfBlocks(this.posX, (this.getEntityBoundingBox().minY + this.getEntityBoundingBox().maxY) / 2.0, this.posZ);
        final double lllllllllllllIlIlIlllIllIlIlIIIl = 8.0;
        if (this.xpTargetColor < this.xpColor - 20 + this.getEntityId() % 100) {
            if (this.closestPlayer == null || this.closestPlayer.getDistanceSqToEntity(this) > 64.0) {
                this.closestPlayer = this.world.getClosestPlayerToEntity(this, 8.0);
            }
            this.xpTargetColor = this.xpColor;
        }
        if (this.closestPlayer != null && this.closestPlayer.isSpectator()) {
            this.closestPlayer = null;
        }
        if (this.closestPlayer != null) {
            final double lllllllllllllIlIlIlllIllIlIlIIII = (this.closestPlayer.posX - this.posX) / 8.0;
            final double lllllllllllllIlIlIlllIllIlIIllll = (this.closestPlayer.posY + this.closestPlayer.getEyeHeight() / 2.0 - this.posY) / 8.0;
            final double lllllllllllllIlIlIlllIllIlIIlllI = (this.closestPlayer.posZ - this.posZ) / 8.0;
            final double lllllllllllllIlIlIlllIllIlIIllIl = Math.sqrt(lllllllllllllIlIlIlllIllIlIlIIII * lllllllllllllIlIlIlllIllIlIlIIII + lllllllllllllIlIlIlllIllIlIIllll * lllllllllllllIlIlIlllIllIlIIllll + lllllllllllllIlIlIlllIllIlIIlllI * lllllllllllllIlIlIlllIllIlIIlllI);
            double lllllllllllllIlIlIlllIllIlIIllII = 1.0 - lllllllllllllIlIlIlllIllIlIIllIl;
            if (lllllllllllllIlIlIlllIllIlIIllII > 0.0) {
                lllllllllllllIlIlIlllIllIlIIllII *= lllllllllllllIlIlIlllIllIlIIllII;
                this.motionX += lllllllllllllIlIlIlllIllIlIlIIII / lllllllllllllIlIlIlllIllIlIIllIl * lllllllllllllIlIlIlllIllIlIIllII * 0.1;
                this.motionY += lllllllllllllIlIlIlllIllIlIIllll / lllllllllllllIlIlIlllIllIlIIllIl * lllllllllllllIlIlIlllIllIlIIllII * 0.1;
                this.motionZ += lllllllllllllIlIlIlllIllIlIIlllI / lllllllllllllIlIlIlllIllIlIIllIl * lllllllllllllIlIlIlllIllIlIIllII * 0.1;
            }
        }
        this.moveEntity(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
        float lllllllllllllIlIlIlllIllIlIIlIll = 0.98f;
        if (this.onGround) {
            lllllllllllllIlIlIlllIllIlIIlIll = this.world.getBlockState(new BlockPos(MathHelper.floor(this.posX), MathHelper.floor(this.getEntityBoundingBox().minY) - 1, MathHelper.floor(this.posZ))).getBlock().slipperiness * 0.98f;
        }
        this.motionX *= lllllllllllllIlIlIlllIllIlIIlIll;
        this.motionY *= 0.9800000190734863;
        this.motionZ *= lllllllllllllIlIlIlllIllIlIIlIll;
        if (this.onGround) {
            this.motionY *= -0.8999999761581421;
        }
        ++this.xpColor;
        ++this.xpOrbAge;
        if (this.xpOrbAge >= 6000) {
            this.setDead();
        }
    }
    
    @Override
    protected void dealFireDamage(final int lllllllllllllIlIlIlllIllIIlllIll) {
        this.attackEntityFrom(DamageSource.inFire, (float)lllllllllllllIlIlIlllIllIIlllIll);
    }
    
    @Override
    protected boolean canTriggerWalking() {
        return false;
    }
    
    @Override
    public int getBrightnessForRender() {
        float lllllllllllllIlIlIlllIllIllIIIlI = 0.5f;
        lllllllllllllIlIlIlllIllIllIIIlI = MathHelper.clamp(lllllllllllllIlIlIlllIllIllIIIlI, 0.0f, 1.0f);
        final int lllllllllllllIlIlIlllIllIllIIIIl = super.getBrightnessForRender();
        int lllllllllllllIlIlIlllIllIllIIIII = lllllllllllllIlIlIlllIllIllIIIIl & 0xFF;
        final int lllllllllllllIlIlIlllIllIlIlllll = lllllllllllllIlIlIlllIllIllIIIIl >> 16 & 0xFF;
        lllllllllllllIlIlIlllIllIllIIIII += (int)(lllllllllllllIlIlIlllIllIllIIIlI * 15.0f * 16.0f);
        if (lllllllllllllIlIlIlllIllIllIIIII > 240) {
            lllllllllllllIlIlIlllIllIllIIIII = 240;
        }
        return lllllllllllllIlIlIlllIllIllIIIII | lllllllllllllIlIlIlllIllIlIlllll << 16;
    }
    
    public void readEntityFromNBT(final NBTTagCompound lllllllllllllIlIlIlllIllIIlIlIII) {
        this.xpOrbHealth = lllllllllllllIlIlIlllIllIIlIlIII.getShort("Health");
        this.xpOrbAge = lllllllllllllIlIlIlllIllIIlIlIII.getShort("Age");
        this.xpValue = lllllllllllllIlIlIlllIllIIlIlIII.getShort("Value");
    }
    
    public int getXpValue() {
        return this.xpValue;
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource lllllllllllllIlIlIlllIllIIllIllI, final float lllllllllllllIlIlIlllIllIIllIlIl) {
        if (this.isEntityInvulnerable(lllllllllllllIlIlIlllIllIIllIllI)) {
            return false;
        }
        this.setBeenAttacked();
        this.xpOrbHealth -= (int)lllllllllllllIlIlIlllIllIIllIlIl;
        if (this.xpOrbHealth <= 0) {
            this.setDead();
        }
        return false;
    }
    
    @Override
    public void onCollideWithPlayer(final EntityPlayer lllllllllllllIlIlIlllIllIIIlllII) {
        if (!this.world.isRemote && this.delayBeforeCanPickup == 0 && lllllllllllllIlIlIlllIllIIIlllII.xpCooldown == 0) {
            lllllllllllllIlIlIlllIllIIIlllII.xpCooldown = 2;
            lllllllllllllIlIlIlllIllIIIlllII.onItemPickup(this, 1);
            final ItemStack lllllllllllllIlIlIlllIllIIIlllll = EnchantmentHelper.getEnchantedItem(Enchantments.MENDING, lllllllllllllIlIlIlllIllIIIlllII);
            if (!lllllllllllllIlIlIlllIllIIIlllll.func_190926_b() && lllllllllllllIlIlIlllIllIIIlllll.isItemDamaged()) {
                final int lllllllllllllIlIlIlllIllIIIllllI = Math.min(this.xpToDurability(this.xpValue), lllllllllllllIlIlIlllIllIIIlllll.getItemDamage());
                this.xpValue -= this.durabilityToXp(lllllllllllllIlIlIlllIllIIIllllI);
                lllllllllllllIlIlIlllIllIIIlllll.setItemDamage(lllllllllllllIlIlIlllIllIIIlllll.getItemDamage() - lllllllllllllIlIlIlllIllIIIllllI);
            }
            if (this.xpValue > 0) {
                lllllllllllllIlIlIlllIllIIIlllII.addExperience(this.xpValue);
            }
            this.setDead();
        }
    }
    
    @Override
    public boolean handleWaterMovement() {
        return this.world.handleMaterialAcceleration(this.getEntityBoundingBox(), Material.WATER, this);
    }
    
    @Override
    public boolean canBeAttackedWithItem() {
        return false;
    }
    
    public EntityXPOrb(final World lllllllllllllIlIlIlllIllIllIllII) {
        super(lllllllllllllIlIlIlllIllIllIllII);
        this.xpOrbHealth = 5;
        this.setSize(0.25f, 0.25f);
    }
    
    private int xpToDurability(final int lllllllllllllIlIlIlllIllIIIlIIlI) {
        return lllllllllllllIlIlIlllIllIIIlIIlI * 2;
    }
    
    public EntityXPOrb(final World lllllllllllllIlIlIlllIllIllllIll, final double lllllllllllllIlIlIlllIllIlllIlII, final double lllllllllllllIlIlIlllIllIlllIIll, final double lllllllllllllIlIlIlllIllIlllIIlI, final int lllllllllllllIlIlIlllIllIlllIIIl) {
        super(lllllllllllllIlIlIlllIllIllllIll);
        this.xpOrbHealth = 5;
        this.setSize(0.5f, 0.5f);
        this.setPosition(lllllllllllllIlIlIlllIllIlllIlII, lllllllllllllIlIlIlllIllIlllIIll, lllllllllllllIlIlIlllIllIlllIIlI);
        this.rotationYaw = (float)(Math.random() * 360.0);
        this.motionX = (float)(Math.random() * 0.20000000298023224 - 0.10000000149011612) * 2.0f;
        this.motionY = (float)(Math.random() * 0.2) * 2.0f;
        this.motionZ = (float)(Math.random() * 0.20000000298023224 - 0.10000000149011612) * 2.0f;
        this.xpValue = lllllllllllllIlIlIlllIllIlllIIIl;
    }
    
    @Override
    protected void entityInit() {
    }
    
    public void writeEntityToNBT(final NBTTagCompound lllllllllllllIlIlIlllIllIIlIlllI) {
        lllllllllllllIlIlIlllIllIIlIlllI.setShort("Health", (short)this.xpOrbHealth);
        lllllllllllllIlIlIlllIllIIlIlllI.setShort("Age", (short)this.xpOrbAge);
        lllllllllllllIlIlIlllIllIIlIlllI.setShort("Value", (short)this.xpValue);
    }
    
    public int getTextureByXP() {
        if (this.xpValue >= 2477) {
            return 10;
        }
        if (this.xpValue >= 1237) {
            return 9;
        }
        if (this.xpValue >= 617) {
            return 8;
        }
        if (this.xpValue >= 307) {
            return 7;
        }
        if (this.xpValue >= 149) {
            return 6;
        }
        if (this.xpValue >= 73) {
            return 5;
        }
        if (this.xpValue >= 37) {
            return 4;
        }
        if (this.xpValue >= 17) {
            return 3;
        }
        if (this.xpValue >= 7) {
            return 2;
        }
        return (this.xpValue >= 3) ? 1 : 0;
    }
}
