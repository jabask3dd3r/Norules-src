package net.minecraft.entity.projectile;

import net.minecraft.entity.*;
import javax.annotation.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.init.*;
import net.minecraft.potion.*;
import com.google.common.collect.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.nbt.*;

public class EntityShulkerBullet extends Entity
{
    private /* synthetic */ Entity target;
    private /* synthetic */ EntityLivingBase owner;
    private /* synthetic */ double targetDeltaY;
    @Nullable
    private /* synthetic */ UUID ownerUniqueId;
    @Nullable
    private /* synthetic */ EnumFacing direction;
    private /* synthetic */ BlockPos ownerBlockPos;
    private /* synthetic */ double targetDeltaZ;
    private /* synthetic */ double targetDeltaX;
    @Nullable
    private /* synthetic */ UUID targetUniqueId;
    private /* synthetic */ int steps;
    private /* synthetic */ BlockPos targetBlockPos;
    
    @Override
    protected void readEntityFromNBT(final NBTTagCompound lllllllllllllllIIlllllIllIlIIllI) {
        this.steps = lllllllllllllllIIlllllIllIlIIllI.getInteger("Steps");
        this.targetDeltaX = lllllllllllllllIIlllllIllIlIIllI.getDouble("TXD");
        this.targetDeltaY = lllllllllllllllIIlllllIllIlIIllI.getDouble("TYD");
        this.targetDeltaZ = lllllllllllllllIIlllllIllIlIIllI.getDouble("TZD");
        if (lllllllllllllllIIlllllIllIlIIllI.hasKey("Dir", 99)) {
            this.direction = EnumFacing.getFront(lllllllllllllllIIlllllIllIlIIllI.getInteger("Dir"));
        }
        if (lllllllllllllllIIlllllIllIlIIllI.hasKey("Owner", 10)) {
            final NBTTagCompound lllllllllllllllIIlllllIllIlIlIIl = lllllllllllllllIIlllllIllIlIIllI.getCompoundTag("Owner");
            this.ownerUniqueId = NBTUtil.getUUIDFromTag(lllllllllllllllIIlllllIllIlIlIIl);
            this.ownerBlockPos = new BlockPos(lllllllllllllllIIlllllIllIlIlIIl.getInteger("X"), lllllllllllllllIIlllllIllIlIlIIl.getInteger("Y"), lllllllllllllllIIlllllIllIlIlIIl.getInteger("Z"));
        }
        if (lllllllllllllllIIlllllIllIlIIllI.hasKey("Target", 10)) {
            final NBTTagCompound lllllllllllllllIIlllllIllIlIlIII = lllllllllllllllIIlllllIllIlIIllI.getCompoundTag("Target");
            this.targetUniqueId = NBTUtil.getUUIDFromTag(lllllllllllllllIIlllllIllIlIlIII);
            this.targetBlockPos = new BlockPos(lllllllllllllllIIlllllIllIlIlIII.getInteger("X"), lllllllllllllllIIlllllIllIlIlIII.getInteger("Y"), lllllllllllllllIIlllllIllIlIlIII.getInteger("Z"));
        }
    }
    
    public EntityShulkerBullet(final World lllllllllllllllIIlllllIlllllIlIl) {
        super(lllllllllllllllIIlllllIlllllIlIl);
        this.setSize(0.3125f, 0.3125f);
        this.noClip = true;
    }
    
    @Override
    public void onUpdate() {
        if (!this.world.isRemote && this.world.getDifficulty() == EnumDifficulty.PEACEFUL) {
            this.setDead();
        }
        else {
            super.onUpdate();
            if (!this.world.isRemote) {
                if (this.target == null && this.targetUniqueId != null) {
                    for (final EntityLivingBase lllllllllllllllIIlllllIlIllIlllI : this.world.getEntitiesWithinAABB((Class<? extends Entity>)EntityLivingBase.class, new AxisAlignedBB(this.targetBlockPos.add(-2, -2, -2), this.targetBlockPos.add(2, 2, 2)))) {
                        if (lllllllllllllllIIlllllIlIllIlllI.getUniqueID().equals(this.targetUniqueId)) {
                            this.target = lllllllllllllllIIlllllIlIllIlllI;
                            break;
                        }
                    }
                    this.targetUniqueId = null;
                }
                if (this.owner == null && this.ownerUniqueId != null) {
                    for (final EntityLivingBase lllllllllllllllIIlllllIlIllIllIl : this.world.getEntitiesWithinAABB((Class<? extends Entity>)EntityLivingBase.class, new AxisAlignedBB(this.ownerBlockPos.add(-2, -2, -2), this.ownerBlockPos.add(2, 2, 2)))) {
                        if (lllllllllllllllIIlllllIlIllIllIl.getUniqueID().equals(this.ownerUniqueId)) {
                            this.owner = lllllllllllllllIIlllllIlIllIllIl;
                            break;
                        }
                    }
                    this.ownerUniqueId = null;
                }
                if (this.target == null || !this.target.isEntityAlive() || (this.target instanceof EntityPlayer && ((EntityPlayer)this.target).isSpectator())) {
                    if (!this.hasNoGravity()) {
                        this.motionY -= 0.04;
                    }
                }
                else {
                    this.targetDeltaX = MathHelper.clamp(this.targetDeltaX * 1.025, -1.0, 1.0);
                    this.targetDeltaY = MathHelper.clamp(this.targetDeltaY * 1.025, -1.0, 1.0);
                    this.targetDeltaZ = MathHelper.clamp(this.targetDeltaZ * 1.025, -1.0, 1.0);
                    this.motionX += (this.targetDeltaX - this.motionX) * 0.2;
                    this.motionY += (this.targetDeltaY - this.motionY) * 0.2;
                    this.motionZ += (this.targetDeltaZ - this.motionZ) * 0.2;
                }
                final RayTraceResult lllllllllllllllIIlllllIlIllIllII = ProjectileHelper.forwardsRaycast(this, true, false, this.owner);
                if (lllllllllllllllIIlllllIlIllIllII != null) {
                    this.bulletHit(lllllllllllllllIIlllllIlIllIllII);
                }
            }
            this.setPosition(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
            ProjectileHelper.rotateTowardsMovement(this, 0.5f);
            if (this.world.isRemote) {
                this.world.spawnParticle(EnumParticleTypes.END_ROD, this.posX - this.motionX, this.posY - this.motionY + 0.15, this.posZ - this.motionZ, 0.0, 0.0, 0.0, new int[0]);
            }
            else if (this.target != null && !this.target.isDead) {
                if (this.steps > 0) {
                    --this.steps;
                    if (this.steps == 0) {
                        this.selectNextMoveDirection((this.direction == null) ? null : this.direction.getAxis());
                    }
                }
                if (this.direction != null) {
                    final BlockPos lllllllllllllllIIlllllIlIllIlIll = new BlockPos(this);
                    final EnumFacing.Axis lllllllllllllllIIlllllIlIllIlIlI = this.direction.getAxis();
                    if (this.world.isBlockNormalCube(lllllllllllllllIIlllllIlIllIlIll.offset(this.direction), false)) {
                        this.selectNextMoveDirection(lllllllllllllllIIlllllIlIllIlIlI);
                    }
                    else {
                        final BlockPos lllllllllllllllIIlllllIlIllIlIIl = new BlockPos(this.target);
                        if ((lllllllllllllllIIlllllIlIllIlIlI == EnumFacing.Axis.X && lllllllllllllllIIlllllIlIllIlIll.getX() == lllllllllllllllIIlllllIlIllIlIIl.getX()) || (lllllllllllllllIIlllllIlIllIlIlI == EnumFacing.Axis.Z && lllllllllllllllIIlllllIlIllIlIll.getZ() == lllllllllllllllIIlllllIlIllIlIIl.getZ()) || (lllllllllllllllIIlllllIlIllIlIlI == EnumFacing.Axis.Y && lllllllllllllllIIlllllIlIllIlIll.getY() == lllllllllllllllIIlllllIlIllIlIIl.getY())) {
                            this.selectNextMoveDirection(lllllllllllllllIIlllllIlIllIlIlI);
                        }
                    }
                }
            }
        }
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource lllllllllllllllIIlllllIlIlIlIIIl, final float lllllllllllllllIIlllllIlIlIlIIII) {
        if (!this.world.isRemote) {
            this.playSound(SoundEvents.ENTITY_SHULKER_BULLET_HURT, 1.0f, 1.0f);
            ((WorldServer)this.world).spawnParticle(EnumParticleTypes.CRIT, this.posX, this.posY, this.posZ, 15, 0.2, 0.2, 0.2, 0.0, new int[0]);
            this.setDead();
        }
        return true;
    }
    
    @Override
    public int getBrightnessForRender() {
        return 15728880;
    }
    
    @Override
    public boolean isInRangeToRenderDist(final double lllllllllllllllIIlllllIlIllIIIIl) {
        return lllllllllllllllIIlllllIlIllIIIIl < 16384.0;
    }
    
    @Override
    public boolean isBurning() {
        return false;
    }
    
    @Override
    public float getBrightness() {
        return 1.0f;
    }
    
    public EntityShulkerBullet(final World lllllllllllllllIIlllllIlllIIllIl, final EntityLivingBase lllllllllllllllIIlllllIlllIIllII, final Entity lllllllllllllllIIlllllIlllIIIIlI, final EnumFacing.Axis lllllllllllllllIIlllllIlllIIlIlI) {
        this(lllllllllllllllIIlllllIlllIIllIl);
        this.owner = lllllllllllllllIIlllllIlllIIllII;
        final BlockPos lllllllllllllllIIlllllIlllIIlIIl = new BlockPos(lllllllllllllllIIlllllIlllIIllII);
        final double lllllllllllllllIIlllllIlllIIlIII = lllllllllllllllIIlllllIlllIIlIIl.getX() + 0.5;
        final double lllllllllllllllIIlllllIlllIIIlll = lllllllllllllllIIlllllIlllIIlIIl.getY() + 0.5;
        final double lllllllllllllllIIlllllIlllIIIllI = lllllllllllllllIIlllllIlllIIlIIl.getZ() + 0.5;
        this.setLocationAndAngles(lllllllllllllllIIlllllIlllIIlIII, lllllllllllllllIIlllllIlllIIIlll, lllllllllllllllIIlllllIlllIIIllI, this.rotationYaw, this.rotationPitch);
        this.target = lllllllllllllllIIlllllIlllIIIIlI;
        this.direction = EnumFacing.UP;
        this.selectNextMoveDirection(lllllllllllllllIIlllllIlllIIlIlI);
    }
    
    protected void bulletHit(final RayTraceResult lllllllllllllllIIlllllIlIlIlIllI) {
        if (lllllllllllllllIIlllllIlIlIlIllI.entityHit == null) {
            ((WorldServer)this.world).spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, this.posX, this.posY, this.posZ, 2, 0.2, 0.2, 0.2, 0.0, new int[0]);
            this.playSound(SoundEvents.ENTITY_SHULKER_BULLET_HIT, 1.0f, 1.0f);
        }
        else {
            final boolean lllllllllllllllIIlllllIlIlIllIII = lllllllllllllllIIlllllIlIlIlIllI.entityHit.attackEntityFrom(DamageSource.causeIndirectDamage(this, this.owner).setProjectile(), 4.0f);
            if (lllllllllllllllIIlllllIlIlIllIII) {
                this.applyEnchantments(this.owner, lllllllllllllllIIlllllIlIlIlIllI.entityHit);
                if (lllllllllllllllIIlllllIlIlIlIllI.entityHit instanceof EntityLivingBase) {
                    ((EntityLivingBase)lllllllllllllllIIlllllIlIlIlIllI.entityHit).addPotionEffect(new PotionEffect(MobEffects.LEVITATION, 200));
                }
            }
        }
        this.setDead();
    }
    
    private void selectNextMoveDirection(@Nullable final EnumFacing.Axis lllllllllllllllIIlllllIlIlllllll) {
        double lllllllllllllllIIlllllIllIIIlllI = 0.5;
        BlockPos lllllllllllllllIIlllllIllIIIllII = null;
        if (this.target == null) {
            final BlockPos lllllllllllllllIIlllllIllIIIllIl = new BlockPos(this).down();
        }
        else {
            lllllllllllllllIIlllllIllIIIlllI = this.target.height * 0.5;
            lllllllllllllllIIlllllIllIIIllII = new BlockPos(this.target.posX, this.target.posY + lllllllllllllllIIlllllIllIIIlllI, this.target.posZ);
        }
        double lllllllllllllllIIlllllIllIIIlIll = lllllllllllllllIIlllllIllIIIllII.getX() + 0.5;
        double lllllllllllllllIIlllllIllIIIlIlI = lllllllllllllllIIlllllIllIIIllII.getY() + lllllllllllllllIIlllllIllIIIlllI;
        double lllllllllllllllIIlllllIllIIIlIIl = lllllllllllllllIIlllllIllIIIllII.getZ() + 0.5;
        EnumFacing lllllllllllllllIIlllllIllIIIlIII = null;
        if (lllllllllllllllIIlllllIllIIIllII.distanceSqToCenter(this.posX, this.posY, this.posZ) >= 4.0) {
            final BlockPos lllllllllllllllIIlllllIllIIIIlll = new BlockPos(this);
            final List<EnumFacing> lllllllllllllllIIlllllIllIIIIllI = (List<EnumFacing>)Lists.newArrayList();
            if (lllllllllllllllIIlllllIlIlllllll != EnumFacing.Axis.X) {
                if (lllllllllllllllIIlllllIllIIIIlll.getX() < lllllllllllllllIIlllllIllIIIllII.getX() && this.world.isAirBlock(lllllllllllllllIIlllllIllIIIIlll.east())) {
                    lllllllllllllllIIlllllIllIIIIllI.add(EnumFacing.EAST);
                }
                else if (lllllllllllllllIIlllllIllIIIIlll.getX() > lllllllllllllllIIlllllIllIIIllII.getX() && this.world.isAirBlock(lllllllllllllllIIlllllIllIIIIlll.west())) {
                    lllllllllllllllIIlllllIllIIIIllI.add(EnumFacing.WEST);
                }
            }
            if (lllllllllllllllIIlllllIlIlllllll != EnumFacing.Axis.Y) {
                if (lllllllllllllllIIlllllIllIIIIlll.getY() < lllllllllllllllIIlllllIllIIIllII.getY() && this.world.isAirBlock(lllllllllllllllIIlllllIllIIIIlll.up())) {
                    lllllllllllllllIIlllllIllIIIIllI.add(EnumFacing.UP);
                }
                else if (lllllllllllllllIIlllllIllIIIIlll.getY() > lllllllllllllllIIlllllIllIIIllII.getY() && this.world.isAirBlock(lllllllllllllllIIlllllIllIIIIlll.down())) {
                    lllllllllllllllIIlllllIllIIIIllI.add(EnumFacing.DOWN);
                }
            }
            if (lllllllllllllllIIlllllIlIlllllll != EnumFacing.Axis.Z) {
                if (lllllllllllllllIIlllllIllIIIIlll.getZ() < lllllllllllllllIIlllllIllIIIllII.getZ() && this.world.isAirBlock(lllllllllllllllIIlllllIllIIIIlll.south())) {
                    lllllllllllllllIIlllllIllIIIIllI.add(EnumFacing.SOUTH);
                }
                else if (lllllllllllllllIIlllllIllIIIIlll.getZ() > lllllllllllllllIIlllllIllIIIllII.getZ() && this.world.isAirBlock(lllllllllllllllIIlllllIllIIIIlll.north())) {
                    lllllllllllllllIIlllllIllIIIIllI.add(EnumFacing.NORTH);
                }
            }
            lllllllllllllllIIlllllIllIIIlIII = EnumFacing.random(this.rand);
            if (lllllllllllllllIIlllllIllIIIIllI.isEmpty()) {
                for (int lllllllllllllllIIlllllIllIIIIlIl = 5; !this.world.isAirBlock(lllllllllllllllIIlllllIllIIIIlll.offset(lllllllllllllllIIlllllIllIIIlIII)); lllllllllllllllIIlllllIllIIIlIII = EnumFacing.random(this.rand), --lllllllllllllllIIlllllIllIIIIlIl) {
                    if (lllllllllllllllIIlllllIllIIIIlIl <= 0) {
                        break;
                    }
                }
            }
            else {
                lllllllllllllllIIlllllIllIIIlIII = lllllllllllllllIIlllllIllIIIIllI.get(this.rand.nextInt(lllllllllllllllIIlllllIllIIIIllI.size()));
            }
            lllllllllllllllIIlllllIllIIIlIll = this.posX + lllllllllllllllIIlllllIllIIIlIII.getFrontOffsetX();
            lllllllllllllllIIlllllIllIIIlIlI = this.posY + lllllllllllllllIIlllllIllIIIlIII.getFrontOffsetY();
            lllllllllllllllIIlllllIllIIIlIIl = this.posZ + lllllllllllllllIIlllllIllIIIlIII.getFrontOffsetZ();
        }
        this.setDirection(lllllllllllllllIIlllllIllIIIlIII);
        final double lllllllllllllllIIlllllIllIIIIlII = lllllllllllllllIIlllllIllIIIlIll - this.posX;
        final double lllllllllllllllIIlllllIllIIIIIll = lllllllllllllllIIlllllIllIIIlIlI - this.posY;
        final double lllllllllllllllIIlllllIllIIIIIlI = lllllllllllllllIIlllllIllIIIlIIl - this.posZ;
        final double lllllllllllllllIIlllllIllIIIIIIl = MathHelper.sqrt(lllllllllllllllIIlllllIllIIIIlII * lllllllllllllllIIlllllIllIIIIlII + lllllllllllllllIIlllllIllIIIIIll * lllllllllllllllIIlllllIllIIIIIll + lllllllllllllllIIlllllIllIIIIIlI * lllllllllllllllIIlllllIllIIIIIlI);
        if (lllllllllllllllIIlllllIllIIIIIIl == 0.0) {
            this.targetDeltaX = 0.0;
            this.targetDeltaY = 0.0;
            this.targetDeltaZ = 0.0;
        }
        else {
            this.targetDeltaX = lllllllllllllllIIlllllIllIIIIlII / lllllllllllllllIIlllllIllIIIIIIl * 0.15;
            this.targetDeltaY = lllllllllllllllIIlllllIllIIIIIll / lllllllllllllllIIlllllIllIIIIIIl * 0.15;
            this.targetDeltaZ = lllllllllllllllIIlllllIllIIIIIlI / lllllllllllllllIIlllllIllIIIIIIl * 0.15;
        }
        this.isAirBorne = true;
        this.steps = 10 + this.rand.nextInt(5) * 10;
    }
    
    public EntityShulkerBullet(final World lllllllllllllllIIlllllIlllIllllI, final double lllllllllllllllIIlllllIllllIIlIl, final double lllllllllllllllIIlllllIllllIIlII, final double lllllllllllllllIIlllllIllllIIIll, final double lllllllllllllllIIlllllIlllIllIlI, final double lllllllllllllllIIlllllIllllIIIIl, final double lllllllllllllllIIlllllIllllIIIII) {
        this(lllllllllllllllIIlllllIlllIllllI);
        this.setLocationAndAngles(lllllllllllllllIIlllllIllllIIlIl, lllllllllllllllIIlllllIllllIIlII, lllllllllllllllIIlllllIllllIIIll, this.rotationYaw, this.rotationPitch);
        this.motionX = lllllllllllllllIIlllllIlllIllIlI;
        this.motionY = lllllllllllllllIIlllllIllllIIIIl;
        this.motionZ = lllllllllllllllIIlllllIllllIIIII;
    }
    
    private void setDirection(@Nullable final EnumFacing lllllllllllllllIIlllllIllIlIIIII) {
        this.direction = lllllllllllllllIIlllllIllIlIIIII;
    }
    
    @Override
    public boolean canBeCollidedWith() {
        return true;
    }
    
    @Override
    protected void entityInit() {
    }
    
    @Override
    public SoundCategory getSoundCategory() {
        return SoundCategory.HOSTILE;
    }
    
    @Override
    protected void writeEntityToNBT(final NBTTagCompound lllllllllllllllIIlllllIllIllIlll) {
        if (this.owner != null) {
            final BlockPos lllllllllllllllIIlllllIllIllIllI = new BlockPos(this.owner);
            final NBTTagCompound lllllllllllllllIIlllllIllIllIlIl = NBTUtil.createUUIDTag(this.owner.getUniqueID());
            lllllllllllllllIIlllllIllIllIlIl.setInteger("X", lllllllllllllllIIlllllIllIllIllI.getX());
            lllllllllllllllIIlllllIllIllIlIl.setInteger("Y", lllllllllllllllIIlllllIllIllIllI.getY());
            lllllllllllllllIIlllllIllIllIlIl.setInteger("Z", lllllllllllllllIIlllllIllIllIllI.getZ());
            lllllllllllllllIIlllllIllIllIlll.setTag("Owner", lllllllllllllllIIlllllIllIllIlIl);
        }
        if (this.target != null) {
            final BlockPos lllllllllllllllIIlllllIllIllIlII = new BlockPos(this.target);
            final NBTTagCompound lllllllllllllllIIlllllIllIllIIll = NBTUtil.createUUIDTag(this.target.getUniqueID());
            lllllllllllllllIIlllllIllIllIIll.setInteger("X", lllllllllllllllIIlllllIllIllIlII.getX());
            lllllllllllllllIIlllllIllIllIIll.setInteger("Y", lllllllllllllllIIlllllIllIllIlII.getY());
            lllllllllllllllIIlllllIllIllIIll.setInteger("Z", lllllllllllllllIIlllllIllIllIlII.getZ());
            lllllllllllllllIIlllllIllIllIlll.setTag("Target", lllllllllllllllIIlllllIllIllIIll);
        }
        if (this.direction != null) {
            lllllllllllllllIIlllllIllIllIlll.setInteger("Dir", this.direction.getIndex());
        }
        lllllllllllllllIIlllllIllIllIlll.setInteger("Steps", this.steps);
        lllllllllllllllIIlllllIllIllIlll.setDouble("TXD", this.targetDeltaX);
        lllllllllllllllIIlllllIllIllIlll.setDouble("TYD", this.targetDeltaY);
        lllllllllllllllIIlllllIllIllIlll.setDouble("TZD", this.targetDeltaZ);
    }
}
