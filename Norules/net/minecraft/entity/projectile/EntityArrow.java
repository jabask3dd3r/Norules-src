package net.minecraft.entity.projectile;

import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.entity.monster.*;
import net.minecraft.enchantment.*;
import net.minecraft.entity.player.*;
import net.minecraft.network.play.server.*;
import net.minecraft.network.*;
import net.minecraft.block.material.*;
import net.minecraft.block.state.*;
import net.minecraft.entity.*;
import net.minecraft.nbt.*;
import net.minecraft.util.datafix.*;
import net.minecraft.init.*;
import java.util.*;
import net.minecraft.util.math.*;
import javax.annotation.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import com.google.common.base.*;
import net.minecraft.network.datasync.*;

public abstract class EntityArrow extends Entity implements IProjectile
{
    public /* synthetic */ Entity shootingEntity;
    private /* synthetic */ int ticksInAir;
    protected /* synthetic */ boolean inGround;
    private /* synthetic */ double damage;
    private /* synthetic */ int knockbackStrength;
    private static final /* synthetic */ DataParameter<Byte> CRITICAL;
    private /* synthetic */ int inData;
    private static final /* synthetic */ Predicate<Entity> ARROW_TARGETS;
    protected /* synthetic */ int timeInGround;
    public /* synthetic */ PickupStatus pickupStatus;
    private /* synthetic */ int ticksInGround;
    public /* synthetic */ int arrowShake;
    private /* synthetic */ int yTile;
    private /* synthetic */ int zTile;
    private /* synthetic */ int xTile;
    private /* synthetic */ Block inTile;
    
    protected abstract ItemStack getArrowStack();
    
    public double getDamage() {
        return this.damage;
    }
    
    @Override
    public boolean canBeAttackedWithItem() {
        return false;
    }
    
    public EntityArrow(final World llllllllllllllIllIllllIIIIlIllII, final EntityLivingBase llllllllllllllIllIllllIIIIlIlIII) {
        this(llllllllllllllIllIllllIIIIlIllII, llllllllllllllIllIllllIIIIlIlIII.posX, llllllllllllllIllIllllIIIIlIlIII.posY + llllllllllllllIllIllllIIIIlIlIII.getEyeHeight() - 0.10000000149011612, llllllllllllllIllIllllIIIIlIlIII.posZ);
        this.shootingEntity = llllllllllllllIllIllllIIIIlIlIII;
        if (llllllllllllllIllIllllIIIIlIlIII instanceof EntityPlayer) {
            this.pickupStatus = PickupStatus.ALLOWED;
        }
    }
    
    protected void onHit(final RayTraceResult llllllllllllllIllIlllIlllIIIllll) {
        final Entity llllllllllllllIllIlllIlllIIIlllI = llllllllllllllIllIlllIlllIIIllll.entityHit;
        if (llllllllllllllIllIlllIlllIIIlllI != null) {
            final float llllllllllllllIllIlllIlllIIIllIl = MathHelper.sqrt(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
            int llllllllllllllIllIlllIlllIIIllII = MathHelper.ceil(llllllllllllllIllIlllIlllIIIllIl * this.damage);
            if (this.getIsCritical()) {
                llllllllllllllIllIlllIlllIIIllII += this.rand.nextInt(llllllllllllllIllIlllIlllIIIllII / 2 + 2);
            }
            DamageSource llllllllllllllIllIlllIlllIIIlIlI = null;
            if (this.shootingEntity == null) {
                final DamageSource llllllllllllllIllIlllIlllIIIlIll = DamageSource.causeArrowDamage(this, this);
            }
            else {
                llllllllllllllIllIlllIlllIIIlIlI = DamageSource.causeArrowDamage(this, this.shootingEntity);
            }
            if (this.isBurning() && !(llllllllllllllIllIlllIlllIIIlllI instanceof EntityEnderman)) {
                llllllllllllllIllIlllIlllIIIlllI.setFire(5);
            }
            if (llllllllllllllIllIlllIlllIIIlllI.attackEntityFrom(llllllllllllllIllIlllIlllIIIlIlI, (float)llllllllllllllIllIlllIlllIIIllII)) {
                if (llllllllllllllIllIlllIlllIIIlllI instanceof EntityLivingBase) {
                    final EntityLivingBase llllllllllllllIllIlllIlllIIIlIIl = (EntityLivingBase)llllllllllllllIllIlllIlllIIIlllI;
                    if (!this.world.isRemote) {
                        llllllllllllllIllIlllIlllIIIlIIl.setArrowCountInEntity(llllllllllllllIllIlllIlllIIIlIIl.getArrowCountInEntity() + 1);
                    }
                    if (this.knockbackStrength > 0) {
                        final float llllllllllllllIllIlllIlllIIIlIII = MathHelper.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
                        if (llllllllllllllIllIlllIlllIIIlIII > 0.0f) {
                            llllllllllllllIllIlllIlllIIIlIIl.addVelocity(this.motionX * this.knockbackStrength * 0.6000000238418579 / llllllllllllllIllIlllIlllIIIlIII, 0.1, this.motionZ * this.knockbackStrength * 0.6000000238418579 / llllllllllllllIllIlllIlllIIIlIII);
                        }
                    }
                    if (this.shootingEntity instanceof EntityLivingBase) {
                        EnchantmentHelper.applyThornEnchantments(llllllllllllllIllIlllIlllIIIlIIl, this.shootingEntity);
                        EnchantmentHelper.applyArthropodEnchantments((EntityLivingBase)this.shootingEntity, llllllllllllllIllIlllIlllIIIlIIl);
                    }
                    this.arrowHit(llllllllllllllIllIlllIlllIIIlIIl);
                    if (this.shootingEntity != null && llllllllllllllIllIlllIlllIIIlIIl != this.shootingEntity && llllllllllllllIllIlllIlllIIIlIIl instanceof EntityPlayer && this.shootingEntity instanceof EntityPlayerMP) {
                        ((EntityPlayerMP)this.shootingEntity).connection.sendPacket(new SPacketChangeGameState(6, 0.0f));
                    }
                }
                this.playSound(SoundEvents.ENTITY_ARROW_HIT, 1.0f, 1.2f / (this.rand.nextFloat() * 0.2f + 0.9f));
                if (!(llllllllllllllIllIlllIlllIIIlllI instanceof EntityEnderman)) {
                    this.setDead();
                }
            }
            else {
                this.motionX *= -0.10000000149011612;
                this.motionY *= -0.10000000149011612;
                this.motionZ *= -0.10000000149011612;
                this.rotationYaw += 180.0f;
                this.prevRotationYaw += 180.0f;
                this.ticksInAir = 0;
                if (!this.world.isRemote && this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ < 0.0010000000474974513) {
                    if (this.pickupStatus == PickupStatus.ALLOWED) {
                        this.entityDropItem(this.getArrowStack(), 0.1f);
                    }
                    this.setDead();
                }
            }
        }
        else {
            final BlockPos llllllllllllllIllIlllIlllIIIIlll = llllllllllllllIllIlllIlllIIIllll.getBlockPos();
            this.xTile = llllllllllllllIllIlllIlllIIIIlll.getX();
            this.yTile = llllllllllllllIllIlllIlllIIIIlll.getY();
            this.zTile = llllllllllllllIllIlllIlllIIIIlll.getZ();
            final IBlockState llllllllllllllIllIlllIlllIIIIllI = this.world.getBlockState(llllllllllllllIllIlllIlllIIIIlll);
            this.inTile = llllllllllllllIllIlllIlllIIIIllI.getBlock();
            this.inData = this.inTile.getMetaFromState(llllllllllllllIllIlllIlllIIIIllI);
            this.motionX = (float)(llllllllllllllIllIlllIlllIIIllll.hitVec.xCoord - this.posX);
            this.motionY = (float)(llllllllllllllIllIlllIlllIIIllll.hitVec.yCoord - this.posY);
            this.motionZ = (float)(llllllllllllllIllIlllIlllIIIllll.hitVec.zCoord - this.posZ);
            final float llllllllllllllIllIlllIlllIIIIlIl = MathHelper.sqrt(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
            this.posX -= this.motionX / llllllllllllllIllIlllIlllIIIIlIl * 0.05000000074505806;
            this.posY -= this.motionY / llllllllllllllIllIlllIlllIIIIlIl * 0.05000000074505806;
            this.posZ -= this.motionZ / llllllllllllllIllIlllIlllIIIIlIl * 0.05000000074505806;
            this.playSound(SoundEvents.ENTITY_ARROW_HIT, 1.0f, 1.2f / (this.rand.nextFloat() * 0.2f + 0.9f));
            this.inGround = true;
            this.arrowShake = 7;
            this.setIsCritical(false);
            if (llllllllllllllIllIlllIlllIIIIllI.getMaterial() != Material.AIR) {
                this.inTile.onEntityCollidedWithBlock(this.world, llllllllllllllIllIlllIlllIIIIlll, llllllllllllllIllIlllIlllIIIIllI, this);
            }
        }
    }
    
    @Override
    protected boolean canTriggerWalking() {
        return false;
    }
    
    @Override
    public void moveEntity(final MoverType llllllllllllllIllIlllIllIlllIIIl, final double llllllllllllllIllIlllIllIlllIIII, final double llllllllllllllIllIlllIllIlllIlII, final double llllllllllllllIllIlllIllIllIlllI) {
        super.moveEntity(llllllllllllllIllIlllIllIlllIIIl, llllllllllllllIllIlllIllIlllIIII, llllllllllllllIllIlllIllIlllIlII, llllllllllllllIllIlllIllIllIlllI);
        if (this.inGround) {
            this.xTile = MathHelper.floor(this.posX);
            this.yTile = MathHelper.floor(this.posY);
            this.zTile = MathHelper.floor(this.posZ);
        }
    }
    
    public void readEntityFromNBT(final NBTTagCompound llllllllllllllIllIlllIllIIllIlll) {
        this.xTile = llllllllllllllIllIlllIllIIllIlll.getInteger("xTile");
        this.yTile = llllllllllllllIllIlllIllIIllIlll.getInteger("yTile");
        this.zTile = llllllllllllllIllIlllIllIIllIlll.getInteger("zTile");
        this.ticksInGround = llllllllllllllIllIlllIllIIllIlll.getShort("life");
        if (llllllllllllllIllIlllIllIIllIlll.hasKey("inTile", 8)) {
            this.inTile = Block.getBlockFromName(llllllllllllllIllIlllIllIIllIlll.getString("inTile"));
        }
        else {
            this.inTile = Block.getBlockById(llllllllllllllIllIlllIllIIllIlll.getByte("inTile") & 0xFF);
        }
        this.inData = (llllllllllllllIllIlllIllIIllIlll.getByte("inData") & 0xFF);
        this.arrowShake = (llllllllllllllIllIlllIllIIllIlll.getByte("shake") & 0xFF);
        this.inGround = (llllllllllllllIllIlllIllIIllIlll.getByte("inGround") == 1);
        if (llllllllllllllIllIlllIllIIllIlll.hasKey("damage", 99)) {
            this.damage = llllllllllllllIllIlllIllIIllIlll.getDouble("damage");
        }
        if (llllllllllllllIllIlllIllIIllIlll.hasKey("pickup", 99)) {
            this.pickupStatus = PickupStatus.getByOrdinal(llllllllllllllIllIlllIllIIllIlll.getByte("pickup"));
        }
        else if (llllllllllllllIllIlllIllIIllIlll.hasKey("player", 99)) {
            this.pickupStatus = (llllllllllllllIllIlllIllIIllIlll.getBoolean("player") ? PickupStatus.ALLOWED : PickupStatus.DISALLOWED);
        }
        this.setIsCritical(llllllllllllllIllIlllIllIIllIlll.getBoolean("crit"));
    }
    
    public void setDamage(final double llllllllllllllIllIlllIllIIlIlIIl) {
        this.damage = llllllllllllllIllIlllIllIIlIlIIl;
    }
    
    protected void arrowHit(final EntityLivingBase llllllllllllllIllIlllIllIllIllII) {
    }
    
    public static void registerFixesArrow(final DataFixer llllllllllllllIllIlllIllIlIIlIlI, final String llllllllllllllIllIlllIllIlIIlIIl) {
    }
    
    @Override
    public void onCollideWithPlayer(final EntityPlayer llllllllllllllIllIlllIllIIllIIlI) {
        if (!this.world.isRemote && this.inGround && this.arrowShake <= 0) {
            boolean llllllllllllllIllIlllIllIIllIIIl = this.pickupStatus == PickupStatus.ALLOWED || (this.pickupStatus == PickupStatus.CREATIVE_ONLY && llllllllllllllIllIlllIllIIllIIlI.capabilities.isCreativeMode);
            if (this.pickupStatus == PickupStatus.ALLOWED && !llllllllllllllIllIlllIllIIllIIlI.inventory.addItemStackToInventory(this.getArrowStack())) {
                llllllllllllllIllIlllIllIIllIIIl = false;
            }
            if (llllllllllllllIllIlllIllIIllIIIl) {
                llllllllllllllIllIlllIllIIllIIlI.onItemPickup(this, 1);
                this.setDead();
            }
        }
    }
    
    public void setKnockbackStrength(final int llllllllllllllIllIlllIllIIlIIIII) {
        this.knockbackStrength = llllllllllllllIllIlllIllIIlIIIII;
    }
    
    public void setAim(final Entity llllllllllllllIllIllllIIIIIIIlll, final float llllllllllllllIllIllllIIIIIlIIII, final float llllllllllllllIllIllllIIIIIIllll, final float llllllllllllllIllIllllIIIIIIlllI, final float llllllllllllllIllIllllIIIIIIIlII, final float llllllllllllllIllIllllIIIIIIllII) {
        final float llllllllllllllIllIllllIIIIIIlIll = -MathHelper.sin(llllllllllllllIllIllllIIIIIIllll * 0.017453292f) * MathHelper.cos(llllllllllllllIllIllllIIIIIlIIII * 0.017453292f);
        final float llllllllllllllIllIllllIIIIIIlIlI = -MathHelper.sin(llllllllllllllIllIllllIIIIIlIIII * 0.017453292f);
        final float llllllllllllllIllIllllIIIIIIlIIl = MathHelper.cos(llllllllllllllIllIllllIIIIIIllll * 0.017453292f) * MathHelper.cos(llllllllllllllIllIllllIIIIIlIIII * 0.017453292f);
        this.setThrowableHeading(llllllllllllllIllIllllIIIIIIlIll, llllllllllllllIllIllllIIIIIIlIlI, llllllllllllllIllIllllIIIIIIlIIl, llllllllllllllIllIllllIIIIIIIlII, llllllllllllllIllIllllIIIIIIllII);
        this.motionX += llllllllllllllIllIllllIIIIIIIlll.motionX;
        this.motionZ += llllllllllllllIllIllllIIIIIIIlll.motionZ;
        if (!llllllllllllllIllIllllIIIIIIIlll.onGround) {
            this.motionY += llllllllllllllIllIllllIIIIIIIlll.motionY;
        }
    }
    
    public boolean getIsCritical() {
        final byte llllllllllllllIllIlllIllIIIIllll = this.dataManager.get(EntityArrow.CRITICAL);
        return (llllllllllllllIllIlllIllIIIIllll & 0x1) != 0x0;
    }
    
    public void setIsCritical(final boolean llllllllllllllIllIlllIllIIIlIlll) {
        final byte llllllllllllllIllIlllIllIIIlIllI = this.dataManager.get(EntityArrow.CRITICAL);
        if (llllllllllllllIllIlllIllIIIlIlll) {
            this.dataManager.set(EntityArrow.CRITICAL, (byte)(llllllllllllllIllIlllIllIIIlIllI | 0x1));
        }
        else {
            this.dataManager.set(EntityArrow.CRITICAL, (byte)(llllllllllllllIllIlllIllIIIlIllI & 0xFFFFFFFE));
        }
    }
    
    @Override
    public void setPositionAndRotationDirect(final double llllllllllllllIllIlllIllllIllIII, final double llllllllllllllIllIlllIllllIlllll, final double llllllllllllllIllIlllIllllIllllI, final float llllllllllllllIllIlllIllllIlllIl, final float llllllllllllllIllIlllIllllIlIlII, final int llllllllllllllIllIlllIllllIllIll, final boolean llllllllllllllIllIlllIllllIllIlI) {
        this.setPosition(llllllllllllllIllIlllIllllIllIII, llllllllllllllIllIlllIllllIlllll, llllllllllllllIllIlllIllllIllllI);
        this.setRotation(llllllllllllllIllIlllIllllIlllIl, llllllllllllllIllIlllIllllIlIlII);
    }
    
    @Override
    public void setVelocity(final double llllllllllllllIllIlllIllllIIllIl, final double llllllllllllllIllIlllIllllIIllII, final double llllllllllllllIllIlllIllllIIIllI) {
        this.motionX = llllllllllllllIllIlllIllllIIllIl;
        this.motionY = llllllllllllllIllIlllIllllIIllII;
        this.motionZ = llllllllllllllIllIlllIllllIIIllI;
        if (this.prevRotationPitch == 0.0f && this.prevRotationYaw == 0.0f) {
            final float llllllllllllllIllIlllIllllIIlIlI = MathHelper.sqrt(llllllllllllllIllIlllIllllIIllIl * llllllllllllllIllIlllIllllIIllIl + llllllllllllllIllIlllIllllIIIllI * llllllllllllllIllIlllIllllIIIllI);
            this.rotationPitch = (float)(MathHelper.atan2(llllllllllllllIllIlllIllllIIllII, llllllllllllllIllIlllIllllIIlIlI) * 57.29577951308232);
            this.rotationYaw = (float)(MathHelper.atan2(llllllllllllllIllIlllIllllIIllIl, llllllllllllllIllIlllIllllIIIllI) * 57.29577951308232);
            this.prevRotationPitch = this.rotationPitch;
            this.prevRotationYaw = this.rotationYaw;
            this.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
            this.ticksInGround = 0;
        }
    }
    
    @Override
    public void setThrowableHeading(double llllllllllllllIllIlllIllllllIllI, double llllllllllllllIllIlllIllllllIlIl, double llllllllllllllIllIlllIllllllIlII, final float llllllllllllllIllIlllIlllllIlIll, final float llllllllllllllIllIlllIlllllIlIlI) {
        final float llllllllllllllIllIlllIllllllIIIl = MathHelper.sqrt(llllllllllllllIllIlllIllllllIllI * llllllllllllllIllIlllIllllllIllI + llllllllllllllIllIlllIllllllIlIl * llllllllllllllIllIlllIllllllIlIl + llllllllllllllIllIlllIllllllIlII * llllllllllllllIllIlllIllllllIlII);
        llllllllllllllIllIlllIllllllIllI /= llllllllllllllIllIlllIllllllIIIl;
        llllllllllllllIllIlllIllllllIlIl /= llllllllllllllIllIlllIllllllIIIl;
        llllllllllllllIllIlllIllllllIlII /= llllllllllllllIllIlllIllllllIIIl;
        llllllllllllllIllIlllIllllllIllI += this.rand.nextGaussian() * 0.007499999832361937 * llllllllllllllIllIlllIlllllIlIlI;
        llllllllllllllIllIlllIllllllIlIl += this.rand.nextGaussian() * 0.007499999832361937 * llllllllllllllIllIlllIlllllIlIlI;
        llllllllllllllIllIlllIllllllIlII += this.rand.nextGaussian() * 0.007499999832361937 * llllllllllllllIllIlllIlllllIlIlI;
        llllllllllllllIllIlllIllllllIllI *= llllllllllllllIllIlllIlllllIlIll;
        llllllllllllllIllIlllIllllllIlIl *= llllllllllllllIllIlllIlllllIlIll;
        llllllllllllllIllIlllIllllllIlII *= llllllllllllllIllIlllIlllllIlIll;
        this.motionX = llllllllllllllIllIlllIllllllIllI;
        this.motionY = llllllllllllllIllIlllIllllllIlIl;
        this.motionZ = llllllllllllllIllIlllIllllllIlII;
        final float llllllllllllllIllIlllIllllllIIII = MathHelper.sqrt(llllllllllllllIllIlllIllllllIllI * llllllllllllllIllIlllIllllllIllI + llllllllllllllIllIlllIllllllIlII * llllllllllllllIllIlllIllllllIlII);
        this.rotationYaw = (float)(MathHelper.atan2(llllllllllllllIllIlllIllllllIllI, llllllllllllllIllIlllIllllllIlII) * 57.29577951308232);
        this.rotationPitch = (float)(MathHelper.atan2(llllllllllllllIllIlllIllllllIlIl, llllllllllllllIllIlllIllllllIIII) * 57.29577951308232);
        this.prevRotationYaw = this.rotationYaw;
        this.prevRotationPitch = this.rotationPitch;
        this.ticksInGround = 0;
    }
    
    public void func_190547_a(final EntityLivingBase llllllllllllllIllIlllIllIIIIIIIl, final float llllllllllllllIllIlllIllIIIIIlIl) {
        final int llllllllllllllIllIlllIllIIIIIlII = EnchantmentHelper.getMaxEnchantmentLevel(Enchantments.POWER, llllllllllllllIllIlllIllIIIIIIIl);
        final int llllllllllllllIllIlllIllIIIIIIll = EnchantmentHelper.getMaxEnchantmentLevel(Enchantments.PUNCH, llllllllllllllIllIlllIllIIIIIIIl);
        this.setDamage(llllllllllllllIllIlllIllIIIIIlIl * 2.0f + this.rand.nextGaussian() * 0.25 + this.world.getDifficulty().getDifficultyId() * 0.11f);
        if (llllllllllllllIllIlllIllIIIIIlII > 0) {
            this.setDamage(this.getDamage() + llllllllllllllIllIlllIllIIIIIlII * 0.5 + 0.5);
        }
        if (llllllllllllllIllIlllIllIIIIIIll > 0) {
            this.setKnockbackStrength(llllllllllllllIllIlllIllIIIIIIll);
        }
        if (EnchantmentHelper.getMaxEnchantmentLevel(Enchantments.FLAME, llllllllllllllIllIlllIllIIIIIIIl) > 0) {
            this.setFire(100);
        }
    }
    
    @Nullable
    protected Entity findEntityOnPath(final Vec3d llllllllllllllIllIlllIllIlIlIlII, final Vec3d llllllllllllllIllIlllIllIlIllllI) {
        Entity llllllllllllllIllIlllIllIlIlllIl = null;
        final List<Entity> llllllllllllllIllIlllIllIlIlllII = this.world.getEntitiesInAABBexcluding(this, this.getEntityBoundingBox().addCoord(this.motionX, this.motionY, this.motionZ).expandXyz(1.0), EntityArrow.ARROW_TARGETS);
        double llllllllllllllIllIlllIllIlIllIll = 0.0;
        for (int llllllllllllllIllIlllIllIlIllIlI = 0; llllllllllllllIllIlllIllIlIllIlI < llllllllllllllIllIlllIllIlIlllII.size(); ++llllllllllllllIllIlllIllIlIllIlI) {
            final Entity llllllllllllllIllIlllIllIlIllIIl = llllllllllllllIllIlllIllIlIlllII.get(llllllllllllllIllIlllIllIlIllIlI);
            if (llllllllllllllIllIlllIllIlIllIIl != this.shootingEntity || this.ticksInAir >= 5) {
                final AxisAlignedBB llllllllllllllIllIlllIllIlIllIII = llllllllllllllIllIlllIllIlIllIIl.getEntityBoundingBox().expandXyz(0.30000001192092896);
                final RayTraceResult llllllllllllllIllIlllIllIlIlIlll = llllllllllllllIllIlllIllIlIllIII.calculateIntercept(llllllllllllllIllIlllIllIlIlIlII, llllllllllllllIllIlllIllIlIllllI);
                if (llllllllllllllIllIlllIllIlIlIlll != null) {
                    final double llllllllllllllIllIlllIllIlIlIllI = llllllllllllllIllIlllIllIlIlIlII.squareDistanceTo(llllllllllllllIllIlllIllIlIlIlll.hitVec);
                    if (llllllllllllllIllIlllIllIlIlIllI < llllllllllllllIllIlllIllIlIllIll || llllllllllllllIllIlllIllIlIllIll == 0.0) {
                        llllllllllllllIllIlllIllIlIlllIl = llllllllllllllIllIlllIllIlIllIIl;
                        llllllllllllllIllIlllIllIlIllIll = llllllllllllllIllIlllIllIlIlIllI;
                    }
                }
            }
        }
        return llllllllllllllIllIlllIllIlIlllIl;
    }
    
    public void writeEntityToNBT(final NBTTagCompound llllllllllllllIllIlllIllIlIIIIIl) {
        llllllllllllllIllIlllIllIlIIIIIl.setInteger("xTile", this.xTile);
        llllllllllllllIllIlllIllIlIIIIIl.setInteger("yTile", this.yTile);
        llllllllllllllIllIlllIllIlIIIIIl.setInteger("zTile", this.zTile);
        llllllllllllllIllIlllIllIlIIIIIl.setShort("life", (short)this.ticksInGround);
        final ResourceLocation llllllllllllllIllIlllIllIlIIIIII = Block.REGISTRY.getNameForObject(this.inTile);
        llllllllllllllIllIlllIllIlIIIIIl.setString("inTile", (llllllllllllllIllIlllIllIlIIIIII == null) ? "" : llllllllllllllIllIlllIllIlIIIIII.toString());
        llllllllllllllIllIlllIllIlIIIIIl.setByte("inData", (byte)this.inData);
        llllllllllllllIllIlllIllIlIIIIIl.setByte("shake", (byte)this.arrowShake);
        llllllllllllllIllIlllIllIlIIIIIl.setByte("inGround", (byte)(this.inGround ? 1 : 0));
        llllllllllllllIllIlllIllIlIIIIIl.setByte("pickup", (byte)this.pickupStatus.ordinal());
        llllllllllllllIllIlllIllIlIIIIIl.setDouble("damage", this.damage);
        llllllllllllllIllIlllIllIlIIIIIl.setBoolean("crit", this.getIsCritical());
    }
    
    @Override
    public boolean isInRangeToRenderDist(final double llllllllllllllIllIllllIIIIlIIIll) {
        double llllllllllllllIllIllllIIIIlIIIlI = this.getEntityBoundingBox().getAverageEdgeLength() * 10.0;
        if (Double.isNaN(llllllllllllllIllIllllIIIIlIIIlI)) {
            llllllllllllllIllIllllIIIIlIIIlI = 1.0;
        }
        llllllllllllllIllIllllIIIIlIIIlI = llllllllllllllIllIllllIIIIlIIIlI * 64.0 * getRenderDistanceWeight();
        return llllllllllllllIllIllllIIIIlIIIll < llllllllllllllIllIllllIIIIlIIIlI * llllllllllllllIllIllllIIIIlIIIlI;
    }
    
    @Override
    public void onUpdate() {
        super.onUpdate();
        if (this.prevRotationPitch == 0.0f && this.prevRotationYaw == 0.0f) {
            final float llllllllllllllIllIlllIlllIllIllI = MathHelper.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
            this.rotationYaw = (float)(MathHelper.atan2(this.motionX, this.motionZ) * 57.29577951308232);
            this.rotationPitch = (float)(MathHelper.atan2(this.motionY, llllllllllllllIllIlllIlllIllIllI) * 57.29577951308232);
            this.prevRotationYaw = this.rotationYaw;
            this.prevRotationPitch = this.rotationPitch;
        }
        final BlockPos llllllllllllllIllIlllIlllIllIlIl = new BlockPos(this.xTile, this.yTile, this.zTile);
        final IBlockState llllllllllllllIllIlllIlllIllIlII = this.world.getBlockState(llllllllllllllIllIlllIlllIllIlIl);
        final Block llllllllllllllIllIlllIlllIllIIll = llllllllllllllIllIlllIlllIllIlII.getBlock();
        if (llllllllllllllIllIlllIlllIllIlII.getMaterial() != Material.AIR) {
            final AxisAlignedBB llllllllllllllIllIlllIlllIllIIlI = llllllllllllllIllIlllIlllIllIlII.getCollisionBoundingBox(this.world, llllllllllllllIllIlllIlllIllIlIl);
            if (llllllllllllllIllIlllIlllIllIIlI != Block.NULL_AABB && llllllllllllllIllIlllIlllIllIIlI.offset(llllllllllllllIllIlllIlllIllIlIl).isVecInside(new Vec3d(this.posX, this.posY, this.posZ))) {
                this.inGround = true;
            }
        }
        if (this.arrowShake > 0) {
            --this.arrowShake;
        }
        if (this.inGround) {
            final int llllllllllllllIllIlllIlllIllIIIl = llllllllllllllIllIlllIlllIllIIll.getMetaFromState(llllllllllllllIllIlllIlllIllIlII);
            if ((llllllllllllllIllIlllIlllIllIIll != this.inTile || llllllllllllllIllIlllIlllIllIIIl != this.inData) && !this.world.collidesWithAnyBlock(this.getEntityBoundingBox().expandXyz(0.05))) {
                this.inGround = false;
                this.motionX *= this.rand.nextFloat() * 0.2f;
                this.motionY *= this.rand.nextFloat() * 0.2f;
                this.motionZ *= this.rand.nextFloat() * 0.2f;
                this.ticksInGround = 0;
                this.ticksInAir = 0;
            }
            else {
                ++this.ticksInGround;
                if (this.ticksInGround >= 1200) {
                    this.setDead();
                }
            }
            ++this.timeInGround;
        }
        else {
            this.timeInGround = 0;
            ++this.ticksInAir;
            Vec3d llllllllllllllIllIlllIlllIllIIII = new Vec3d(this.posX, this.posY, this.posZ);
            Vec3d llllllllllllllIllIlllIlllIlIllll = new Vec3d(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
            RayTraceResult llllllllllllllIllIlllIlllIlIlllI = this.world.rayTraceBlocks(llllllllllllllIllIlllIlllIllIIII, llllllllllllllIllIlllIlllIlIllll, false, true, false);
            llllllllllllllIllIlllIlllIllIIII = new Vec3d(this.posX, this.posY, this.posZ);
            llllllllllllllIllIlllIlllIlIllll = new Vec3d(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
            if (llllllllllllllIllIlllIlllIlIlllI != null) {
                llllllllllllllIllIlllIlllIlIllll = new Vec3d(llllllllllllllIllIlllIlllIlIlllI.hitVec.xCoord, llllllllllllllIllIlllIlllIlIlllI.hitVec.yCoord, llllllllllllllIllIlllIlllIlIlllI.hitVec.zCoord);
            }
            final Entity llllllllllllllIllIlllIlllIlIllIl = this.findEntityOnPath(llllllllllllllIllIlllIlllIllIIII, llllllllllllllIllIlllIlllIlIllll);
            if (llllllllllllllIllIlllIlllIlIllIl != null) {
                llllllllllllllIllIlllIlllIlIlllI = new RayTraceResult(llllllllllllllIllIlllIlllIlIllIl);
            }
            if (llllllllllllllIllIlllIlllIlIlllI != null && llllllllllllllIllIlllIlllIlIlllI.entityHit instanceof EntityPlayer) {
                final EntityPlayer llllllllllllllIllIlllIlllIlIllII = (EntityPlayer)llllllllllllllIllIlllIlllIlIlllI.entityHit;
                if (this.shootingEntity instanceof EntityPlayer && !((EntityPlayer)this.shootingEntity).canAttackPlayer(llllllllllllllIllIlllIlllIlIllII)) {
                    llllllllllllllIllIlllIlllIlIlllI = null;
                }
            }
            if (llllllllllllllIllIlllIlllIlIlllI != null) {
                this.onHit(llllllllllllllIllIlllIlllIlIlllI);
            }
            if (this.getIsCritical()) {
                for (int llllllllllllllIllIlllIlllIlIlIll = 0; llllllllllllllIllIlllIlllIlIlIll < 4; ++llllllllllllllIllIlllIlllIlIlIll) {
                    this.world.spawnParticle(EnumParticleTypes.CRIT, this.posX + this.motionX * llllllllllllllIllIlllIlllIlIlIll / 4.0, this.posY + this.motionY * llllllllllllllIllIlllIlllIlIlIll / 4.0, this.posZ + this.motionZ * llllllllllllllIllIlllIlllIlIlIll / 4.0, -this.motionX, -this.motionY + 0.2, -this.motionZ, new int[0]);
                }
            }
            this.posX += this.motionX;
            this.posY += this.motionY;
            this.posZ += this.motionZ;
            final float llllllllllllllIllIlllIlllIlIlIlI = MathHelper.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
            this.rotationYaw = (float)(MathHelper.atan2(this.motionX, this.motionZ) * 57.29577951308232);
            this.rotationPitch = (float)(MathHelper.atan2(this.motionY, llllllllllllllIllIlllIlllIlIlIlI) * 57.29577951308232);
            while (this.rotationPitch - this.prevRotationPitch < -180.0f) {
                this.prevRotationPitch -= 360.0f;
            }
            while (this.rotationPitch - this.prevRotationPitch >= 180.0f) {
                this.prevRotationPitch += 360.0f;
            }
            while (this.rotationYaw - this.prevRotationYaw < -180.0f) {
                this.prevRotationYaw -= 360.0f;
            }
            while (this.rotationYaw - this.prevRotationYaw >= 180.0f) {
                this.prevRotationYaw += 360.0f;
            }
            this.rotationPitch = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2f;
            this.rotationYaw = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2f;
            float llllllllllllllIllIlllIlllIlIlIIl = 0.99f;
            final float llllllllllllllIllIlllIlllIlIlIII = 0.05f;
            if (this.isInWater()) {
                for (int llllllllllllllIllIlllIlllIlIIlll = 0; llllllllllllllIllIlllIlllIlIIlll < 4; ++llllllllllllllIllIlllIlllIlIIlll) {
                    final float llllllllllllllIllIlllIlllIlIIllI = 0.25f;
                    this.world.spawnParticle(EnumParticleTypes.WATER_BUBBLE, this.posX - this.motionX * 0.25, this.posY - this.motionY * 0.25, this.posZ - this.motionZ * 0.25, this.motionX, this.motionY, this.motionZ, new int[0]);
                }
                llllllllllllllIllIlllIlllIlIlIIl = 0.6f;
            }
            if (this.isWet()) {
                this.extinguish();
            }
            this.motionX *= llllllllllllllIllIlllIlllIlIlIIl;
            this.motionY *= llllllllllllllIllIlllIlllIlIlIIl;
            this.motionZ *= llllllllllllllIllIlllIlllIlIlIIl;
            if (!this.hasNoGravity()) {
                this.motionY -= 0.05000000074505806;
            }
            this.setPosition(this.posX, this.posY, this.posZ);
            this.doBlockCollisions();
        }
    }
    
    @Override
    public float getEyeHeight() {
        return 0.0f;
    }
    
    static {
        ARROW_TARGETS = Predicates.and(new Predicate[] { EntitySelectors.NOT_SPECTATING, EntitySelectors.IS_ALIVE, (Predicate)new Predicate<Entity>() {
                public boolean apply(@Nullable final Entity llllllllllllllIlIlIIIllllIIllllI) {
                    return llllllllllllllIlIlIIIllllIIllllI.canBeCollidedWith();
                }
            } });
        CRITICAL = EntityDataManager.createKey(EntityArrow.class, DataSerializers.BYTE);
    }
    
    public static void registerFixesArrow(final DataFixer llllllllllllllIllIlllIllIlIIIlll) {
        registerFixesArrow(llllllllllllllIllIlllIllIlIIIlll, "Arrow");
    }
    
    public EntityArrow(final World llllllllllllllIllIllllIIIIlllIIl, final double llllllllllllllIllIllllIIIIllIIll, final double llllllllllllllIllIllllIIIIllIlll, final double llllllllllllllIllIllllIIIIllIIIl) {
        this(llllllllllllllIllIllllIIIIlllIIl);
        this.setPosition(llllllllllllllIllIllllIIIIllIIll, llllllllllllllIllIllllIIIIllIlll, llllllllllllllIllIllllIIIIllIIIl);
    }
    
    @Override
    protected void entityInit() {
        this.dataManager.register(EntityArrow.CRITICAL, (Byte)0);
    }
    
    public EntityArrow(final World llllllllllllllIllIllllIIIlIIIIII) {
        super(llllllllllllllIllIllllIIIlIIIIII);
        this.xTile = -1;
        this.yTile = -1;
        this.zTile = -1;
        this.pickupStatus = PickupStatus.DISALLOWED;
        this.damage = 2.0;
        this.setSize(0.5f, 0.5f);
    }
    
    public enum PickupStatus
    {
        DISALLOWED("DISALLOWED", 0), 
        CREATIVE_ONLY("CREATIVE_ONLY", 2), 
        ALLOWED("ALLOWED", 1);
        
        public static PickupStatus getByOrdinal(int lllllllllllllIIIIIlllllllllllIll) {
            if (lllllllllllllIIIIIlllllllllllIll < 0 || lllllllllllllIIIIIlllllllllllIll > values().length) {
                lllllllllllllIIIIIlllllllllllIll = 0;
            }
            return values()[lllllllllllllIIIIIlllllllllllIll];
        }
        
        private PickupStatus(final String lllllllllllllIIIIIllllllllllllll, final int lllllllllllllIIIIIlllllllllllllI) {
        }
    }
}
