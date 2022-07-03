package net.minecraft.entity;

import com.google.common.base.*;
import javax.annotation.*;
import net.minecraft.world.*;
import net.minecraft.nbt.*;
import net.minecraft.item.*;
import net.minecraft.entity.item.*;
import net.minecraft.entity.player.*;
import net.minecraft.block.*;
import net.minecraft.block.state.*;
import org.apache.commons.lang3.*;
import net.minecraft.entity.effect.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;

public abstract class EntityHanging extends Entity
{
    private static final /* synthetic */ Predicate<Entity> IS_HANGING_ENTITY;
    private /* synthetic */ int tickCounter1;
    @Nullable
    public /* synthetic */ EnumFacing facingDirection;
    protected /* synthetic */ BlockPos hangingPosition;
    
    @Override
    public boolean canBeCollidedWith() {
        return true;
    }
    
    public abstract void onBroken(final Entity p0);
    
    public EntityHanging(final World lllllllllllllIIllllIllIlIIIlIllI) {
        super(lllllllllllllIIllllIllIlIIIlIllI);
        this.setSize(0.5f, 0.5f);
    }
    
    public void readEntityFromNBT(final NBTTagCompound lllllllllllllIIllllIllIIlIIIIlII) {
        this.hangingPosition = new BlockPos(lllllllllllllIIllllIllIIlIIIIlII.getInteger("TileX"), lllllllllllllIIllllIllIIlIIIIlII.getInteger("TileY"), lllllllllllllIIllllIllIIlIIIIlII.getInteger("TileZ"));
        this.updateFacingWithBoundingBox(EnumFacing.getHorizontal(lllllllllllllIIllllIllIIlIIIIlII.getByte("Facing")));
    }
    
    @Override
    public EntityItem entityDropItem(final ItemStack lllllllllllllIIllllIllIIIllllIlI, final float lllllllllllllIIllllIllIIIllllIIl) {
        final EntityItem lllllllllllllIIllllIllIIIlllllII = new EntityItem(this.world, this.posX + this.facingDirection.getFrontOffsetX() * 0.15f, this.posY + lllllllllllllIIllllIllIIIllllIIl, this.posZ + this.facingDirection.getFrontOffsetZ() * 0.15f, lllllllllllllIIllllIllIIIllllIlI);
        lllllllllllllIIllllIllIIIlllllII.setDefaultPickupDelay();
        this.world.spawnEntityInWorld(lllllllllllllIIllllIllIIIlllllII);
        return lllllllllllllIIllllIllIIIlllllII;
    }
    
    @Override
    protected boolean shouldSetPosAfterLoading() {
        return false;
    }
    
    public EntityHanging(final World lllllllllllllIIllllIllIlIIIIlllI, final BlockPos lllllllllllllIIllllIllIlIIIlIIII) {
        this(lllllllllllllIIllllIllIlIIIIlllI);
        this.hangingPosition = lllllllllllllIIllllIllIlIIIlIIII;
    }
    
    public void writeEntityToNBT(final NBTTagCompound lllllllllllllIIllllIllIIlIIIlIll) {
        lllllllllllllIIllllIllIIlIIIlIll.setByte("Facing", (byte)this.facingDirection.getHorizontalIndex());
        final BlockPos lllllllllllllIIllllIllIIlIIIllIl = this.getHangingPosition();
        lllllllllllllIIllllIllIIlIIIlIll.setInteger("TileX", lllllllllllllIIllllIllIIlIIIllIl.getX());
        lllllllllllllIIllllIllIIlIIIlIll.setInteger("TileY", lllllllllllllIIllllIllIIlIIIllIl.getY());
        lllllllllllllIIllllIllIIlIIIlIll.setInteger("TileZ", lllllllllllllIIllllIllIIlIIIllIl.getZ());
    }
    
    @Override
    public boolean hitByEntity(final Entity lllllllllllllIIllllIllIIlIllIllI) {
        return lllllllllllllIIllllIllIIlIllIllI instanceof EntityPlayer && this.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer)lllllllllllllIIllllIllIIlIllIllI), 0.0f);
    }
    
    public BlockPos getHangingPosition() {
        return this.hangingPosition;
    }
    
    public abstract void playPlaceSound();
    
    @Override
    public void onUpdate() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (this.tickCounter1++ == 100 && !this.world.isRemote) {
            this.tickCounter1 = 0;
            if (!this.isDead && !this.onValidSurface()) {
                this.setDead();
                this.onBroken(null);
            }
        }
    }
    
    @Override
    public void moveEntity(final MoverType lllllllllllllIIllllIllIIlIlIIllI, final double lllllllllllllIIllllIllIIlIlIIIIl, final double lllllllllllllIIllllIllIIlIlIIIII, final double lllllllllllllIIllllIllIIlIIlllll) {
        if (!this.world.isRemote && !this.isDead && lllllllllllllIIllllIllIIlIlIIIIl * lllllllllllllIIllllIllIIlIlIIIIl + lllllllllllllIIllllIllIIlIlIIIII * lllllllllllllIIllllIllIIlIlIIIII + lllllllllllllIIllllIllIIlIIlllll * lllllllllllllIIllllIllIIlIIlllll > 0.0) {
            this.setDead();
            this.onBroken(null);
        }
    }
    
    @Override
    public EnumFacing getHorizontalFacing() {
        return this.facingDirection;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Rotation() {
        final int[] $switch_TABLE$net$minecraft$util$Rotation = EntityHanging.$SWITCH_TABLE$net$minecraft$util$Rotation;
        if ($switch_TABLE$net$minecraft$util$Rotation != null) {
            return $switch_TABLE$net$minecraft$util$Rotation;
        }
        final double lllllllllllllIIllllIllIIIlIlIlIl = (Object)new int[Rotation.values().length];
        try {
            lllllllllllllIIllllIllIIIlIlIlIl[Rotation.CLOCKWISE_180.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIIllllIllIIIlIlIlIl[Rotation.CLOCKWISE_90.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIIllllIllIIIlIlIlIl[Rotation.COUNTERCLOCKWISE_90.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllIIllllIllIIIlIlIlIl[Rotation.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return EntityHanging.$SWITCH_TABLE$net$minecraft$util$Rotation = (int[])(Object)lllllllllllllIIllllIllIIIlIlIlIl;
    }
    
    public boolean onValidSurface() {
        if (!this.world.getCollisionBoxes(this, this.getEntityBoundingBox()).isEmpty()) {
            return false;
        }
        final int lllllllllllllIIllllIllIIllIlIIIl = Math.max(1, this.getWidthPixels() / 16);
        final int lllllllllllllIIllllIllIIllIlIIII = Math.max(1, this.getHeightPixels() / 16);
        final BlockPos lllllllllllllIIllllIllIIllIIllll = this.hangingPosition.offset(this.facingDirection.getOpposite());
        final EnumFacing lllllllllllllIIllllIllIIllIIlllI = this.facingDirection.rotateYCCW();
        final BlockPos.MutableBlockPos lllllllllllllIIllllIllIIllIIllIl = new BlockPos.MutableBlockPos();
        for (int lllllllllllllIIllllIllIIllIIllII = 0; lllllllllllllIIllllIllIIllIIllII < lllllllllllllIIllllIllIIllIlIIIl; ++lllllllllllllIIllllIllIIllIIllII) {
            for (int lllllllllllllIIllllIllIIllIIlIll = 0; lllllllllllllIIllllIllIIllIIlIll < lllllllllllllIIllllIllIIllIlIIII; ++lllllllllllllIIllllIllIIllIIlIll) {
                final int lllllllllllllIIllllIllIIllIIlIlI = (lllllllllllllIIllllIllIIllIlIIIl - 1) / -2;
                final int lllllllllllllIIllllIllIIllIIlIIl = (lllllllllllllIIllllIllIIllIlIIII - 1) / -2;
                lllllllllllllIIllllIllIIllIIllIl.setPos(lllllllllllllIIllllIllIIllIIllll).move(lllllllllllllIIllllIllIIllIIlllI, lllllllllllllIIllllIllIIllIIllII + lllllllllllllIIllllIllIIllIIlIlI).move(EnumFacing.UP, lllllllllllllIIllllIllIIllIIlIll + lllllllllllllIIllllIllIIllIIlIIl);
                final IBlockState lllllllllllllIIllllIllIIllIIlIII = this.world.getBlockState(lllllllllllllIIllllIllIIllIIllIl);
                if (!lllllllllllllIIllllIllIIllIIlIII.getMaterial().isSolid() && !BlockRedstoneDiode.isDiode(lllllllllllllIIllllIllIIllIIlIII)) {
                    return false;
                }
            }
        }
        return this.world.getEntitiesInAABBexcluding(this, this.getEntityBoundingBox(), EntityHanging.IS_HANGING_ENTITY).isEmpty();
    }
    
    public abstract int getWidthPixels();
    
    @Override
    public float getRotatedYaw(final Rotation lllllllllllllIIllllIllIIIllIIIll) {
        if (this.facingDirection != null && this.facingDirection.getAxis() != EnumFacing.Axis.Y) {
            switch ($SWITCH_TABLE$net$minecraft$util$Rotation()[lllllllllllllIIllllIllIIIllIIIll.ordinal()]) {
                case 3: {
                    this.facingDirection = this.facingDirection.getOpposite();
                    break;
                }
                case 4: {
                    this.facingDirection = this.facingDirection.rotateYCCW();
                    break;
                }
                case 2: {
                    this.facingDirection = this.facingDirection.rotateY();
                    break;
                }
            }
        }
        final float lllllllllllllIIllllIllIIIllIIIlI = MathHelper.wrapDegrees(this.rotationYaw);
        switch ($SWITCH_TABLE$net$minecraft$util$Rotation()[lllllllllllllIIllllIllIIIllIIIll.ordinal()]) {
            case 3: {
                return lllllllllllllIIllllIllIIIllIIIlI + 180.0f;
            }
            case 4: {
                return lllllllllllllIIllllIllIIIllIIIlI + 90.0f;
            }
            case 2: {
                return lllllllllllllIIllllIllIIIllIIIlI + 270.0f;
            }
            default: {
                return lllllllllllllIIllllIllIIIllIIIlI;
            }
        }
    }
    
    protected void updateFacingWithBoundingBox(final EnumFacing lllllllllllllIIllllIllIlIIIIlIII) {
        Validate.notNull((Object)lllllllllllllIIllllIllIlIIIIlIII);
        Validate.isTrue(lllllllllllllIIllllIllIlIIIIlIII.getAxis().isHorizontal());
        this.facingDirection = lllllllllllllIIllllIllIlIIIIlIII;
        this.rotationYaw = (float)(this.facingDirection.getHorizontalIndex() * 90);
        this.prevRotationYaw = this.rotationYaw;
        this.updateBoundingBox();
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource lllllllllllllIIllllIllIIlIlIllll, final float lllllllllllllIIllllIllIIlIlIlllI) {
        if (this.isEntityInvulnerable(lllllllllllllIIllllIllIIlIlIllll)) {
            return false;
        }
        if (!this.isDead && !this.world.isRemote) {
            this.setDead();
            this.setBeenAttacked();
            this.onBroken(lllllllllllllIIllllIllIIlIlIllll.getEntity());
        }
        return true;
    }
    
    @Override
    public void onStruckByLightning(final EntityLightningBolt lllllllllllllIIllllIllIIIlIlIlll) {
    }
    
    @Override
    public void setPosition(final double lllllllllllllIIllllIllIIIllIllIl, final double lllllllllllllIIllllIllIIIlllIIII, final double lllllllllllllIIllllIllIIIllIlIll) {
        this.hangingPosition = new BlockPos(lllllllllllllIIllllIllIIIllIllIl, lllllllllllllIIllllIllIIIlllIIII, lllllllllllllIIllllIllIIIllIlIll);
        this.updateBoundingBox();
        this.isAirBorne = true;
    }
    
    private double offs(final int lllllllllllllIIllllIllIIlllIIIIl) {
        return (lllllllllllllIIllllIllIIlllIIIIl % 32 == 0) ? 0.5 : 0.0;
    }
    
    @Override
    public void addVelocity(final double lllllllllllllIIllllIllIIlIIllIIl, final double lllllllllllllIIllllIllIIlIIlIlII, final double lllllllllllllIIllllIllIIlIIlIIll) {
        if (!this.world.isRemote && !this.isDead && lllllllllllllIIllllIllIIlIIllIIl * lllllllllllllIIllllIllIIlIIllIIl + lllllllllllllIIllllIllIIlIIlIlII * lllllllllllllIIllllIllIIlIIlIlII + lllllllllllllIIllllIllIIlIIlIIll * lllllllllllllIIllllIllIIlIIlIIll > 0.0) {
            this.setDead();
            this.onBroken(null);
        }
    }
    
    public abstract int getHeightPixels();
    
    @Override
    protected void entityInit() {
    }
    
    static {
        IS_HANGING_ENTITY = (Predicate)new Predicate<Entity>() {
            public boolean apply(@Nullable final Entity lllllllllllllIlllIIIlIIlllIlllII) {
                return lllllllllllllIlllIIIlIIlllIlllII instanceof EntityHanging;
            }
        };
    }
    
    @Override
    public float getMirroredYaw(final Mirror lllllllllllllIIllllIllIIIlIllIll) {
        return this.getRotatedYaw(lllllllllllllIIllllIllIIIlIllIll.toRotation(this.facingDirection));
    }
    
    protected void updateBoundingBox() {
        if (this.facingDirection != null) {
            double lllllllllllllIIllllIllIIlllllIIl = this.hangingPosition.getX() + 0.5;
            double lllllllllllllIIllllIllIIlllllIII = this.hangingPosition.getY() + 0.5;
            double lllllllllllllIIllllIllIIllllIlll = this.hangingPosition.getZ() + 0.5;
            final double lllllllllllllIIllllIllIIllllIllI = 0.46875;
            final double lllllllllllllIIllllIllIIllllIlIl = this.offs(this.getWidthPixels());
            final double lllllllllllllIIllllIllIIllllIlII = this.offs(this.getHeightPixels());
            lllllllllllllIIllllIllIIlllllIIl -= this.facingDirection.getFrontOffsetX() * 0.46875;
            lllllllllllllIIllllIllIIllllIlll -= this.facingDirection.getFrontOffsetZ() * 0.46875;
            lllllllllllllIIllllIllIIlllllIII += lllllllllllllIIllllIllIIllllIlII;
            final EnumFacing lllllllllllllIIllllIllIIllllIIll = this.facingDirection.rotateYCCW();
            lllllllllllllIIllllIllIIlllllIIl += lllllllllllllIIllllIllIIllllIlIl * lllllllllllllIIllllIllIIllllIIll.getFrontOffsetX();
            lllllllllllllIIllllIllIIllllIlll += lllllllllllllIIllllIllIIllllIlIl * lllllllllllllIIllllIllIIllllIIll.getFrontOffsetZ();
            this.posX = lllllllllllllIIllllIllIIlllllIIl;
            this.posY = lllllllllllllIIllllIllIIlllllIII;
            this.posZ = lllllllllllllIIllllIllIIllllIlll;
            double lllllllllllllIIllllIllIIllllIIlI = this.getWidthPixels();
            double lllllllllllllIIllllIllIIllllIIIl = this.getHeightPixels();
            double lllllllllllllIIllllIllIIllllIIII = this.getWidthPixels();
            if (this.facingDirection.getAxis() == EnumFacing.Axis.Z) {
                lllllllllllllIIllllIllIIllllIIII = 1.0;
            }
            else {
                lllllllllllllIIllllIllIIllllIIlI = 1.0;
            }
            lllllllllllllIIllllIllIIllllIIlI /= 32.0;
            lllllllllllllIIllllIllIIllllIIIl /= 32.0;
            lllllllllllllIIllllIllIIllllIIII /= 32.0;
            this.setEntityBoundingBox(new AxisAlignedBB(lllllllllllllIIllllIllIIlllllIIl - lllllllllllllIIllllIllIIllllIIlI, lllllllllllllIIllllIllIIlllllIII - lllllllllllllIIllllIllIIllllIIIl, lllllllllllllIIllllIllIIllllIlll - lllllllllllllIIllllIllIIllllIIII, lllllllllllllIIllllIllIIlllllIIl + lllllllllllllIIllllIllIIllllIIlI, lllllllllllllIIllllIllIIlllllIII + lllllllllllllIIllllIllIIllllIIIl, lllllllllllllIIllllIllIIllllIlll + lllllllllllllIIllllIllIIllllIIII));
        }
    }
}
