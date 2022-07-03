package net.minecraft.entity.item;

import net.minecraft.block.state.*;
import javax.annotation.*;
import net.minecraft.nbt.*;
import net.minecraft.item.*;
import net.minecraft.util.math.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import net.minecraft.block.properties.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.monster.*;
import net.minecraft.server.*;
import net.minecraft.network.datasync.*;
import net.minecraft.util.datafix.*;
import java.util.*;
import com.google.common.collect.*;

public abstract class EntityMinecart extends Entity implements IWorldNameable
{
    private /* synthetic */ double minecartX;
    private /* synthetic */ double minecartZ;
    private static final /* synthetic */ DataParameter<Integer> ROLLING_AMPLITUDE;
    private /* synthetic */ double velocityY;
    private static final /* synthetic */ DataParameter<Float> DAMAGE;
    private static final /* synthetic */ DataParameter<Integer> ROLLING_DIRECTION;
    private /* synthetic */ double minecartY;
    private static final /* synthetic */ int[][][] MATRIX;
    private /* synthetic */ int turnProgress;
    private static final /* synthetic */ DataParameter<Integer> DISPLAY_TILE_OFFSET;
    private /* synthetic */ double minecartPitch;
    private /* synthetic */ double minecartYaw;
    private static final /* synthetic */ DataParameter<Integer> DISPLAY_TILE;
    private /* synthetic */ double velocityX;
    private /* synthetic */ double velocityZ;
    private static final /* synthetic */ DataParameter<Boolean> SHOW_BLOCK;
    private /* synthetic */ boolean isInReverse;
    
    @Override
    protected void entityInit() {
        this.dataManager.register(EntityMinecart.ROLLING_AMPLITUDE, 0);
        this.dataManager.register(EntityMinecart.ROLLING_DIRECTION, 1);
        this.dataManager.register(EntityMinecart.DAMAGE, 0.0f);
        this.dataManager.register(EntityMinecart.DISPLAY_TILE, 0);
        this.dataManager.register(EntityMinecart.DISPLAY_TILE_OFFSET, 6);
        this.dataManager.register(EntityMinecart.SHOW_BLOCK, false);
    }
    
    public int getRollingDirection() {
        return this.dataManager.get(EntityMinecart.ROLLING_DIRECTION);
    }
    
    public void setDisplayTile(final IBlockState llllllllllllllllIlIIIIlIIlIIIlIl) {
        this.getDataManager().set(EntityMinecart.DISPLAY_TILE, Block.getStateId(llllllllllllllllIlIIIIlIIlIIIlIl));
        this.setHasDisplayTile(true);
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$entity$item$EntityMinecart$Type() {
        final int[] $switch_TABLE$net$minecraft$entity$item$EntityMinecart$Type = EntityMinecart.$SWITCH_TABLE$net$minecraft$entity$item$EntityMinecart$Type;
        if ($switch_TABLE$net$minecraft$entity$item$EntityMinecart$Type != null) {
            return $switch_TABLE$net$minecraft$entity$item$EntityMinecart$Type;
        }
        final String llllllllllllllllIlIIIIlIIIllIIlI = (Object)new int[Type.values().length];
        try {
            llllllllllllllllIlIIIIlIIIllIIlI[Type.CHEST.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllllIlIIIIlIIIllIIlI[Type.COMMAND_BLOCK.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllllllIlIIIIlIIIllIIlI[Type.FURNACE.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllllllIlIIIIlIIIllIIlI[Type.HOPPER.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            llllllllllllllllIlIIIIlIIIllIIlI[Type.RIDEABLE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            llllllllllllllllIlIIIIlIIIllIIlI[Type.SPAWNER.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        try {
            llllllllllllllllIlIIIIlIIIllIIlI[Type.TNT.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError7) {}
        return EntityMinecart.$SWITCH_TABLE$net$minecraft$entity$item$EntityMinecart$Type = (int[])(Object)llllllllllllllllIlIIIIlIIIllIIlI;
    }
    
    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox() {
        return null;
    }
    
    @Override
    public void applyEntityCollision(final Entity llllllllllllllllIlIIIIlIlIIllIIl) {
        if (!this.world.isRemote && !llllllllllllllllIlIIIIlIlIIllIIl.noClip && !this.noClip && !this.isPassenger(llllllllllllllllIlIIIIlIlIIllIIl)) {
            double llllllllllllllllIlIIIIlIlIlIIlIl = llllllllllllllllIlIIIIlIlIIllIIl.posX - this.posX;
            double llllllllllllllllIlIIIIlIlIlIIlII = llllllllllllllllIlIIIIlIlIIllIIl.posZ - this.posZ;
            double llllllllllllllllIlIIIIlIlIlIIIll = llllllllllllllllIlIIIIlIlIlIIlIl * llllllllllllllllIlIIIIlIlIlIIlIl + llllllllllllllllIlIIIIlIlIlIIlII * llllllllllllllllIlIIIIlIlIlIIlII;
            if (llllllllllllllllIlIIIIlIlIlIIIll >= 9.999999747378752E-5) {
                llllllllllllllllIlIIIIlIlIlIIIll = MathHelper.sqrt(llllllllllllllllIlIIIIlIlIlIIIll);
                llllllllllllllllIlIIIIlIlIlIIlIl /= llllllllllllllllIlIIIIlIlIlIIIll;
                llllllllllllllllIlIIIIlIlIlIIlII /= llllllllllllllllIlIIIIlIlIlIIIll;
                double llllllllllllllllIlIIIIlIlIlIIIlI = 1.0 / llllllllllllllllIlIIIIlIlIlIIIll;
                if (llllllllllllllllIlIIIIlIlIlIIIlI > 1.0) {
                    llllllllllllllllIlIIIIlIlIlIIIlI = 1.0;
                }
                llllllllllllllllIlIIIIlIlIlIIlIl *= llllllllllllllllIlIIIIlIlIlIIIlI;
                llllllllllllllllIlIIIIlIlIlIIlII *= llllllllllllllllIlIIIIlIlIlIIIlI;
                llllllllllllllllIlIIIIlIlIlIIlIl *= 0.10000000149011612;
                llllllllllllllllIlIIIIlIlIlIIlII *= 0.10000000149011612;
                llllllllllllllllIlIIIIlIlIlIIlIl *= 1.0f - this.entityCollisionReduction;
                llllllllllllllllIlIIIIlIlIlIIlII *= 1.0f - this.entityCollisionReduction;
                llllllllllllllllIlIIIIlIlIlIIlIl *= 0.5;
                llllllllllllllllIlIIIIlIlIlIIlII *= 0.5;
                if (llllllllllllllllIlIIIIlIlIIllIIl instanceof EntityMinecart) {
                    final double llllllllllllllllIlIIIIlIlIlIIIIl = llllllllllllllllIlIIIIlIlIIllIIl.posX - this.posX;
                    final double llllllllllllllllIlIIIIlIlIlIIIII = llllllllllllllllIlIIIIlIlIIllIIl.posZ - this.posZ;
                    final Vec3d llllllllllllllllIlIIIIlIlIIlllll = new Vec3d(llllllllllllllllIlIIIIlIlIlIIIIl, 0.0, llllllllllllllllIlIIIIlIlIlIIIII).normalize();
                    final Vec3d llllllllllllllllIlIIIIlIlIIllllI = new Vec3d(MathHelper.cos(this.rotationYaw * 0.017453292f), 0.0, MathHelper.sin(this.rotationYaw * 0.017453292f)).normalize();
                    final double llllllllllllllllIlIIIIlIlIIlllIl = Math.abs(llllllllllllllllIlIIIIlIlIIlllll.dotProduct(llllllllllllllllIlIIIIlIlIIllllI));
                    if (llllllllllllllllIlIIIIlIlIIlllIl < 0.800000011920929) {
                        return;
                    }
                    double llllllllllllllllIlIIIIlIlIIlllII = llllllllllllllllIlIIIIlIlIIllIIl.motionX + this.motionX;
                    double llllllllllllllllIlIIIIlIlIIllIll = llllllllllllllllIlIIIIlIlIIllIIl.motionZ + this.motionZ;
                    if (((EntityMinecart)llllllllllllllllIlIIIIlIlIIllIIl).getType() == Type.FURNACE && this.getType() != Type.FURNACE) {
                        this.motionX *= 0.20000000298023224;
                        this.motionZ *= 0.20000000298023224;
                        this.addVelocity(llllllllllllllllIlIIIIlIlIIllIIl.motionX - llllllllllllllllIlIIIIlIlIlIIlIl, 0.0, llllllllllllllllIlIIIIlIlIIllIIl.motionZ - llllllllllllllllIlIIIIlIlIlIIlII);
                        llllllllllllllllIlIIIIlIlIIllIIl.motionX *= 0.949999988079071;
                        llllllllllllllllIlIIIIlIlIIllIIl.motionZ *= 0.949999988079071;
                    }
                    else if (((EntityMinecart)llllllllllllllllIlIIIIlIlIIllIIl).getType() != Type.FURNACE && this.getType() == Type.FURNACE) {
                        llllllllllllllllIlIIIIlIlIIllIIl.motionX *= 0.20000000298023224;
                        llllllllllllllllIlIIIIlIlIIllIIl.motionZ *= 0.20000000298023224;
                        llllllllllllllllIlIIIIlIlIIllIIl.addVelocity(this.motionX + llllllllllllllllIlIIIIlIlIlIIlIl, 0.0, this.motionZ + llllllllllllllllIlIIIIlIlIlIIlII);
                        this.motionX *= 0.949999988079071;
                        this.motionZ *= 0.949999988079071;
                    }
                    else {
                        llllllllllllllllIlIIIIlIlIIlllII /= 2.0;
                        llllllllllllllllIlIIIIlIlIIllIll /= 2.0;
                        this.motionX *= 0.20000000298023224;
                        this.motionZ *= 0.20000000298023224;
                        this.addVelocity(llllllllllllllllIlIIIIlIlIIlllII - llllllllllllllllIlIIIIlIlIlIIlIl, 0.0, llllllllllllllllIlIIIIlIlIIllIll - llllllllllllllllIlIIIIlIlIlIIlII);
                        llllllllllllllllIlIIIIlIlIIllIIl.motionX *= 0.20000000298023224;
                        llllllllllllllllIlIIIIlIlIIllIIl.motionZ *= 0.20000000298023224;
                        llllllllllllllllIlIIIIlIlIIllIIl.addVelocity(llllllllllllllllIlIIIIlIlIIlllII + llllllllllllllllIlIIIIlIlIlIIlIl, 0.0, llllllllllllllllIlIIIIlIlIIllIll + llllllllllllllllIlIIIIlIlIlIIlII);
                    }
                }
                else {
                    this.addVelocity(-llllllllllllllllIlIIIIlIlIlIIlIl, 0.0, -llllllllllllllllIlIIIIlIlIlIIlII);
                    llllllllllllllllIlIIIIlIlIIllIIl.addVelocity(llllllllllllllllIlIIIIlIlIlIIlIl / 4.0, 0.0, llllllllllllllllIlIIIIlIlIlIIlII / 4.0);
                }
            }
        }
    }
    
    @Override
    protected void writeEntityToNBT(final NBTTagCompound llllllllllllllllIlIIIIlIlIllIlll) {
        if (this.hasDisplayTile()) {
            llllllllllllllllIlIIIIlIlIllIlll.setBoolean("CustomDisplayTile", true);
            final IBlockState llllllllllllllllIlIIIIlIlIlllIlI = this.getDisplayTile();
            final ResourceLocation llllllllllllllllIlIIIIlIlIlllIIl = Block.REGISTRY.getNameForObject(llllllllllllllllIlIIIIlIlIlllIlI.getBlock());
            llllllllllllllllIlIIIIlIlIllIlll.setString("DisplayTile", (llllllllllllllllIlIIIIlIlIlllIIl == null) ? "" : llllllllllllllllIlIIIIlIlIlllIIl.toString());
            llllllllllllllllIlIIIIlIlIllIlll.setInteger("DisplayData", llllllllllllllllIlIIIIlIlIlllIlI.getBlock().getMetaFromState(llllllllllllllllIlIIIIlIlIlllIlI));
            llllllllllllllllIlIIIIlIlIllIlll.setInteger("DisplayOffset", this.getDisplayTileOffset());
        }
    }
    
    @Override
    public EnumFacing getAdjustedHorizontalFacing() {
        return this.isInReverse ? this.getHorizontalFacing().getOpposite().rotateY() : this.getHorizontalFacing().rotateY();
    }
    
    public EntityMinecart(final World llllllllllllllllIlIIIlIIIllIIIIl, final double llllllllllllllllIlIIIlIIIlIllIII, final double llllllllllllllllIlIIIlIIIlIlllll, final double llllllllllllllllIlIIIlIIIlIlllIl) {
        this(llllllllllllllllIlIIIlIIIllIIIIl);
        this.setPosition(llllllllllllllllIlIIIlIIIlIllIII, llllllllllllllllIlIIIlIIIlIlllll, llllllllllllllllIlIIIlIIIlIlllIl);
        this.motionX = 0.0;
        this.motionY = 0.0;
        this.motionZ = 0.0;
        this.prevPosX = llllllllllllllllIlIIIlIIIlIllIII;
        this.prevPosY = llllllllllllllllIlIIIlIIIlIlllll;
        this.prevPosZ = llllllllllllllllIlIIIlIIIlIlllIl;
    }
    
    public void killMinecart(final DamageSource llllllllllllllllIlIIIlIIIIlIIllI) {
        this.setDead();
        if (this.world.getGameRules().getBoolean("doEntityDrops")) {
            final ItemStack llllllllllllllllIlIIIlIIIIlIIlII = new ItemStack(Items.MINECART, 1);
            if (this.hasCustomName()) {
                llllllllllllllllIlIIIlIIIIlIIlII.setStackDisplayName(this.getCustomNameTag());
            }
            this.entityDropItem(llllllllllllllllIlIIIlIIIIlIIlII, 0.0f);
        }
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection() {
        final int[] $switch_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection = EntityMinecart.$SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection;
        if ($switch_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection != null) {
            return $switch_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection;
        }
        final char llllllllllllllllIlIIIIlIIIllIIII = (Object)new int[BlockRailBase.EnumRailDirection.values().length];
        try {
            llllllllllllllllIlIIIIlIIIllIIII[BlockRailBase.EnumRailDirection.ASCENDING_EAST.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllllIlIIIIlIIIllIIII[BlockRailBase.EnumRailDirection.ASCENDING_NORTH.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllllllIlIIIIlIIIllIIII[BlockRailBase.EnumRailDirection.ASCENDING_SOUTH.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllllllIlIIIIlIIIllIIII[BlockRailBase.EnumRailDirection.ASCENDING_WEST.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            llllllllllllllllIlIIIIlIIIllIIII[BlockRailBase.EnumRailDirection.EAST_WEST.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            llllllllllllllllIlIIIIlIIIllIIII[BlockRailBase.EnumRailDirection.NORTH_EAST.ordinal()] = 10;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        try {
            llllllllllllllllIlIIIIlIIIllIIII[BlockRailBase.EnumRailDirection.NORTH_SOUTH.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError7) {}
        try {
            llllllllllllllllIlIIIIlIIIllIIII[BlockRailBase.EnumRailDirection.NORTH_WEST.ordinal()] = 9;
        }
        catch (NoSuchFieldError noSuchFieldError8) {}
        try {
            llllllllllllllllIlIIIIlIIIllIIII[BlockRailBase.EnumRailDirection.SOUTH_EAST.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError9) {}
        try {
            llllllllllllllllIlIIIIlIIIllIIII[BlockRailBase.EnumRailDirection.SOUTH_WEST.ordinal()] = 8;
        }
        catch (NoSuchFieldError noSuchFieldError10) {}
        return EntityMinecart.$SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection = (int[])(Object)llllllllllllllllIlIIIIlIIIllIIII;
    }
    
    public IBlockState getDisplayTile() {
        return this.hasDisplayTile() ? Block.getStateById(this.getDataManager().get(EntityMinecart.DISPLAY_TILE)) : this.getDefaultDisplayTile();
    }
    
    @Override
    public void setPositionAndRotationDirect(final double llllllllllllllllIlIIIIlIIlllllIl, final double llllllllllllllllIlIIIIlIlIIIIlII, final double llllllllllllllllIlIIIIlIIllllIll, final float llllllllllllllllIlIIIIlIlIIIIIlI, final float llllllllllllllllIlIIIIlIlIIIIIIl, final int llllllllllllllllIlIIIIlIIllllIII, final boolean llllllllllllllllIlIIIIlIIlllllll) {
        this.minecartX = llllllllllllllllIlIIIIlIIlllllIl;
        this.minecartY = llllllllllllllllIlIIIIlIlIIIIlII;
        this.minecartZ = llllllllllllllllIlIIIIlIIllllIll;
        this.minecartYaw = llllllllllllllllIlIIIIlIlIIIIIlI;
        this.minecartPitch = llllllllllllllllIlIIIIlIlIIIIIIl;
        this.turnProgress = llllllllllllllllIlIIIIlIIllllIII + 2;
        this.motionX = this.velocityX;
        this.motionY = this.velocityY;
        this.motionZ = this.velocityZ;
    }
    
    protected void moveAlongTrack(final BlockPos llllllllllllllllIlIIIIlllIIllIll, final IBlockState llllllllllllllllIlIIIIllIlllIIll) {
        this.fallDistance = 0.0f;
        final Vec3d llllllllllllllllIlIIIIlllIIllIIl = this.getPos(this.posX, this.posY, this.posZ);
        this.posY = llllllllllllllllIlIIIIlllIIllIll.getY();
        boolean llllllllllllllllIlIIIIlllIIllIII = false;
        boolean llllllllllllllllIlIIIIlllIIlIlll = false;
        final BlockRailBase llllllllllllllllIlIIIIlllIIlIllI = (BlockRailBase)llllllllllllllllIlIIIIllIlllIIll.getBlock();
        if (llllllllllllllllIlIIIIlllIIlIllI == Blocks.GOLDEN_RAIL) {
            llllllllllllllllIlIIIIlllIIllIII = llllllllllllllllIlIIIIllIlllIIll.getValue((IProperty<Boolean>)BlockRailPowered.POWERED);
            llllllllllllllllIlIIIIlllIIlIlll = !llllllllllllllllIlIIIIlllIIllIII;
        }
        final double llllllllllllllllIlIIIIlllIIlIlIl = 0.0078125;
        final BlockRailBase.EnumRailDirection llllllllllllllllIlIIIIlllIIlIlII = llllllllllllllllIlIIIIllIlllIIll.getValue(llllllllllllllllIlIIIIlllIIlIllI.getShapeProperty());
        switch ($SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection()[llllllllllllllllIlIIIIlllIIlIlII.ordinal()]) {
            case 3: {
                this.motionX -= 0.0078125;
                ++this.posY;
                break;
            }
            case 4: {
                this.motionX += 0.0078125;
                ++this.posY;
                break;
            }
            case 5: {
                this.motionZ += 0.0078125;
                ++this.posY;
                break;
            }
            case 6: {
                this.motionZ -= 0.0078125;
                ++this.posY;
                break;
            }
        }
        final int[][] llllllllllllllllIlIIIIlllIIlIIll = EntityMinecart.MATRIX[llllllllllllllllIlIIIIlllIIlIlII.getMetadata()];
        double llllllllllllllllIlIIIIlllIIlIIlI = llllllllllllllllIlIIIIlllIIlIIll[1][0] - llllllllllllllllIlIIIIlllIIlIIll[0][0];
        double llllllllllllllllIlIIIIlllIIlIIIl = llllllllllllllllIlIIIIlllIIlIIll[1][2] - llllllllllllllllIlIIIIlllIIlIIll[0][2];
        final double llllllllllllllllIlIIIIlllIIlIIII = Math.sqrt(llllllllllllllllIlIIIIlllIIlIIlI * llllllllllllllllIlIIIIlllIIlIIlI + llllllllllllllllIlIIIIlllIIlIIIl * llllllllllllllllIlIIIIlllIIlIIIl);
        final double llllllllllllllllIlIIIIlllIIIllll = this.motionX * llllllllllllllllIlIIIIlllIIlIIlI + this.motionZ * llllllllllllllllIlIIIIlllIIlIIIl;
        if (llllllllllllllllIlIIIIlllIIIllll < 0.0) {
            llllllllllllllllIlIIIIlllIIlIIlI = -llllllllllllllllIlIIIIlllIIlIIlI;
            llllllllllllllllIlIIIIlllIIlIIIl = -llllllllllllllllIlIIIIlllIIlIIIl;
        }
        double llllllllllllllllIlIIIIlllIIIlllI = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
        if (llllllllllllllllIlIIIIlllIIIlllI > 2.0) {
            llllllllllllllllIlIIIIlllIIIlllI = 2.0;
        }
        this.motionX = llllllllllllllllIlIIIIlllIIIlllI * llllllllllllllllIlIIIIlllIIlIIlI / llllllllllllllllIlIIIIlllIIlIIII;
        this.motionZ = llllllllllllllllIlIIIIlllIIIlllI * llllllllllllllllIlIIIIlllIIlIIIl / llllllllllllllllIlIIIIlllIIlIIII;
        final Entity llllllllllllllllIlIIIIlllIIIllIl = this.getPassengers().isEmpty() ? null : this.getPassengers().get(0);
        if (llllllllllllllllIlIIIIlllIIIllIl instanceof EntityLivingBase) {
            final double llllllllllllllllIlIIIIlllIIIllII = ((EntityLivingBase)llllllllllllllllIlIIIIlllIIIllIl).field_191988_bg;
            if (llllllllllllllllIlIIIIlllIIIllII > 0.0) {
                final double llllllllllllllllIlIIIIlllIIIlIll = -Math.sin(llllllllllllllllIlIIIIlllIIIllIl.rotationYaw * 0.017453292f);
                final double llllllllllllllllIlIIIIlllIIIlIlI = Math.cos(llllllllllllllllIlIIIIlllIIIllIl.rotationYaw * 0.017453292f);
                final double llllllllllllllllIlIIIIlllIIIlIIl = this.motionX * this.motionX + this.motionZ * this.motionZ;
                if (llllllllllllllllIlIIIIlllIIIlIIl < 0.01) {
                    this.motionX += llllllllllllllllIlIIIIlllIIIlIll * 0.1;
                    this.motionZ += llllllllllllllllIlIIIIlllIIIlIlI * 0.1;
                    llllllllllllllllIlIIIIlllIIlIlll = false;
                }
            }
        }
        if (llllllllllllllllIlIIIIlllIIlIlll) {
            final double llllllllllllllllIlIIIIlllIIIlIII = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
            if (llllllllllllllllIlIIIIlllIIIlIII < 0.03) {
                this.motionX *= 0.0;
                this.motionY *= 0.0;
                this.motionZ *= 0.0;
            }
            else {
                this.motionX *= 0.5;
                this.motionY *= 0.0;
                this.motionZ *= 0.5;
            }
        }
        final double llllllllllllllllIlIIIIlllIIIIlll = llllllllllllllllIlIIIIlllIIllIll.getX() + 0.5 + llllllllllllllllIlIIIIlllIIlIIll[0][0] * 0.5;
        final double llllllllllllllllIlIIIIlllIIIIllI = llllllllllllllllIlIIIIlllIIllIll.getZ() + 0.5 + llllllllllllllllIlIIIIlllIIlIIll[0][2] * 0.5;
        final double llllllllllllllllIlIIIIlllIIIIlIl = llllllllllllllllIlIIIIlllIIllIll.getX() + 0.5 + llllllllllllllllIlIIIIlllIIlIIll[1][0] * 0.5;
        final double llllllllllllllllIlIIIIlllIIIIlII = llllllllllllllllIlIIIIlllIIllIll.getZ() + 0.5 + llllllllllllllllIlIIIIlllIIlIIll[1][2] * 0.5;
        llllllllllllllllIlIIIIlllIIlIIlI = llllllllllllllllIlIIIIlllIIIIlIl - llllllllllllllllIlIIIIlllIIIIlll;
        llllllllllllllllIlIIIIlllIIlIIIl = llllllllllllllllIlIIIIlllIIIIlII - llllllllllllllllIlIIIIlllIIIIllI;
        double llllllllllllllllIlIIIIlllIIIIIIl = 0.0;
        if (llllllllllllllllIlIIIIlllIIlIIlI == 0.0) {
            this.posX = llllllllllllllllIlIIIIlllIIllIll.getX() + 0.5;
            final double llllllllllllllllIlIIIIlllIIIIIll = this.posZ - llllllllllllllllIlIIIIlllIIllIll.getZ();
        }
        else if (llllllllllllllllIlIIIIlllIIlIIIl == 0.0) {
            this.posZ = llllllllllllllllIlIIIIlllIIllIll.getZ() + 0.5;
            final double llllllllllllllllIlIIIIlllIIIIIlI = this.posX - llllllllllllllllIlIIIIlllIIllIll.getX();
        }
        else {
            final double llllllllllllllllIlIIIIlllIIIIIII = this.posX - llllllllllllllllIlIIIIlllIIIIlll;
            final double llllllllllllllllIlIIIIllIlllllll = this.posZ - llllllllllllllllIlIIIIlllIIIIllI;
            llllllllllllllllIlIIIIlllIIIIIIl = (llllllllllllllllIlIIIIlllIIIIIII * llllllllllllllllIlIIIIlllIIlIIlI + llllllllllllllllIlIIIIllIlllllll * llllllllllllllllIlIIIIlllIIlIIIl) * 2.0;
        }
        this.posX = llllllllllllllllIlIIIIlllIIIIlll + llllllllllllllllIlIIIIlllIIlIIlI * llllllllllllllllIlIIIIlllIIIIIIl;
        this.posZ = llllllllllllllllIlIIIIlllIIIIllI + llllllllllllllllIlIIIIlllIIlIIIl * llllllllllllllllIlIIIIlllIIIIIIl;
        this.setPosition(this.posX, this.posY, this.posZ);
        double llllllllllllllllIlIIIIllIllllllI = this.motionX;
        double llllllllllllllllIlIIIIllIlllllIl = this.motionZ;
        if (this.isBeingRidden()) {
            llllllllllllllllIlIIIIllIllllllI *= 0.75;
            llllllllllllllllIlIIIIllIlllllIl *= 0.75;
        }
        final double llllllllllllllllIlIIIIllIlllllII = this.getMaximumSpeed();
        llllllllllllllllIlIIIIllIllllllI = MathHelper.clamp(llllllllllllllllIlIIIIllIllllllI, -llllllllllllllllIlIIIIllIlllllII, llllllllllllllllIlIIIIllIlllllII);
        llllllllllllllllIlIIIIllIlllllIl = MathHelper.clamp(llllllllllllllllIlIIIIllIlllllIl, -llllllllllllllllIlIIIIllIlllllII, llllllllllllllllIlIIIIllIlllllII);
        this.moveEntity(MoverType.SELF, llllllllllllllllIlIIIIllIllllllI, 0.0, llllllllllllllllIlIIIIllIlllllIl);
        if (llllllllllllllllIlIIIIlllIIlIIll[0][1] != 0 && MathHelper.floor(this.posX) - llllllllllllllllIlIIIIlllIIllIll.getX() == llllllllllllllllIlIIIIlllIIlIIll[0][0] && MathHelper.floor(this.posZ) - llllllllllllllllIlIIIIlllIIllIll.getZ() == llllllllllllllllIlIIIIlllIIlIIll[0][2]) {
            this.setPosition(this.posX, this.posY + llllllllllllllllIlIIIIlllIIlIIll[0][1], this.posZ);
        }
        else if (llllllllllllllllIlIIIIlllIIlIIll[1][1] != 0 && MathHelper.floor(this.posX) - llllllllllllllllIlIIIIlllIIllIll.getX() == llllllllllllllllIlIIIIlllIIlIIll[1][0] && MathHelper.floor(this.posZ) - llllllllllllllllIlIIIIlllIIllIll.getZ() == llllllllllllllllIlIIIIlllIIlIIll[1][2]) {
            this.setPosition(this.posX, this.posY + llllllllllllllllIlIIIIlllIIlIIll[1][1], this.posZ);
        }
        this.applyDrag();
        final Vec3d llllllllllllllllIlIIIIllIllllIll = this.getPos(this.posX, this.posY, this.posZ);
        if (llllllllllllllllIlIIIIllIllllIll != null && llllllllllllllllIlIIIIlllIIllIIl != null) {
            final double llllllllllllllllIlIIIIllIllllIlI = (llllllllllllllllIlIIIIlllIIllIIl.yCoord - llllllllllllllllIlIIIIllIllllIll.yCoord) * 0.05;
            llllllllllllllllIlIIIIlllIIIlllI = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
            if (llllllllllllllllIlIIIIlllIIIlllI > 0.0) {
                this.motionX = this.motionX / llllllllllllllllIlIIIIlllIIIlllI * (llllllllllllllllIlIIIIlllIIIlllI + llllllllllllllllIlIIIIllIllllIlI);
                this.motionZ = this.motionZ / llllllllllllllllIlIIIIlllIIIlllI * (llllllllllllllllIlIIIIlllIIIlllI + llllllllllllllllIlIIIIllIllllIlI);
            }
            this.setPosition(this.posX, llllllllllllllllIlIIIIllIllllIll.yCoord, this.posZ);
        }
        final int llllllllllllllllIlIIIIllIllllIIl = MathHelper.floor(this.posX);
        final int llllllllllllllllIlIIIIllIllllIII = MathHelper.floor(this.posZ);
        if (llllllllllllllllIlIIIIllIllllIIl != llllllllllllllllIlIIIIlllIIllIll.getX() || llllllllllllllllIlIIIIllIllllIII != llllllllllllllllIlIIIIlllIIllIll.getZ()) {
            llllllllllllllllIlIIIIlllIIIlllI = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
            this.motionX = llllllllllllllllIlIIIIlllIIIlllI * (llllllllllllllllIlIIIIllIllllIIl - llllllllllllllllIlIIIIlllIIllIll.getX());
            this.motionZ = llllllllllllllllIlIIIIlllIIIlllI * (llllllllllllllllIlIIIIllIllllIII - llllllllllllllllIlIIIIlllIIllIll.getZ());
        }
        if (llllllllllllllllIlIIIIlllIIllIII) {
            final double llllllllllllllllIlIIIIllIlllIlll = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
            if (llllllllllllllllIlIIIIllIlllIlll > 0.01) {
                final double llllllllllllllllIlIIIIllIlllIllI = 0.06;
                this.motionX += this.motionX / llllllllllllllllIlIIIIllIlllIlll * 0.06;
                this.motionZ += this.motionZ / llllllllllllllllIlIIIIllIlllIlll * 0.06;
            }
            else if (llllllllllllllllIlIIIIlllIIlIlII == BlockRailBase.EnumRailDirection.EAST_WEST) {
                if (this.world.getBlockState(llllllllllllllllIlIIIIlllIIllIll.west()).isNormalCube()) {
                    this.motionX = 0.02;
                }
                else if (this.world.getBlockState(llllllllllllllllIlIIIIlllIIllIll.east()).isNormalCube()) {
                    this.motionX = -0.02;
                }
            }
            else if (llllllllllllllllIlIIIIlllIIlIlII == BlockRailBase.EnumRailDirection.NORTH_SOUTH) {
                if (this.world.getBlockState(llllllllllllllllIlIIIIlllIIllIll.north()).isNormalCube()) {
                    this.motionZ = 0.02;
                }
                else if (this.world.getBlockState(llllllllllllllllIlIIIIlllIIllIll.south()).isNormalCube()) {
                    this.motionZ = -0.02;
                }
            }
        }
    }
    
    public void onActivatorRailPass(final int llllllllllllllllIlIIIIllllIIIIll, final int llllllllllllllllIlIIIIllllIIIIlI, final int llllllllllllllllIlIIIIllllIIIIIl, final boolean llllllllllllllllIlIIIIllllIIIIII) {
    }
    
    public IBlockState getDefaultDisplayTile() {
        return Blocks.AIR.getDefaultState();
    }
    
    @Override
    public void onUpdate() {
        if (this.getRollingAmplitude() > 0) {
            this.setRollingAmplitude(this.getRollingAmplitude() - 1);
        }
        if (this.getDamage() > 0.0f) {
            this.setDamage(this.getDamage() - 1.0f);
        }
        if (this.posY < -64.0) {
            this.kill();
        }
        if (!this.world.isRemote && this.world instanceof WorldServer) {
            this.world.theProfiler.startSection("portal");
            final MinecraftServer llllllllllllllllIlIIIIlllllIIllI = this.world.getMinecraftServer();
            final int llllllllllllllllIlIIIIlllllIIlIl = this.getMaxInPortalTime();
            if (this.inPortal) {
                if (llllllllllllllllIlIIIIlllllIIllI.getAllowNether()) {
                    if (!this.isRiding() && this.portalCounter++ >= llllllllllllllllIlIIIIlllllIIlIl) {
                        this.portalCounter = llllllllllllllllIlIIIIlllllIIlIl;
                        this.timeUntilPortal = this.getPortalCooldown();
                        int llllllllllllllllIlIIIIlllllIIIll = 0;
                        if (this.world.provider.getDimensionType().getId() == -1) {
                            final int llllllllllllllllIlIIIIlllllIIlII = 0;
                        }
                        else {
                            llllllllllllllllIlIIIIlllllIIIll = -1;
                        }
                        this.changeDimension(llllllllllllllllIlIIIIlllllIIIll);
                    }
                    this.inPortal = false;
                }
            }
            else {
                if (this.portalCounter > 0) {
                    this.portalCounter -= 4;
                }
                if (this.portalCounter < 0) {
                    this.portalCounter = 0;
                }
            }
            if (this.timeUntilPortal > 0) {
                --this.timeUntilPortal;
            }
            this.world.theProfiler.endSection();
        }
        if (this.world.isRemote) {
            if (this.turnProgress > 0) {
                final double llllllllllllllllIlIIIIlllllIIIlI = this.posX + (this.minecartX - this.posX) / this.turnProgress;
                final double llllllllllllllllIlIIIIlllllIIIIl = this.posY + (this.minecartY - this.posY) / this.turnProgress;
                final double llllllllllllllllIlIIIIlllllIIIII = this.posZ + (this.minecartZ - this.posZ) / this.turnProgress;
                final double llllllllllllllllIlIIIIllllIlllll = MathHelper.wrapDegrees(this.minecartYaw - this.rotationYaw);
                this.rotationYaw += (float)(llllllllllllllllIlIIIIllllIlllll / this.turnProgress);
                this.rotationPitch += (float)((this.minecartPitch - this.rotationPitch) / this.turnProgress);
                --this.turnProgress;
                this.setPosition(llllllllllllllllIlIIIIlllllIIIlI, llllllllllllllllIlIIIIlllllIIIIl, llllllllllllllllIlIIIIlllllIIIII);
                this.setRotation(this.rotationYaw, this.rotationPitch);
            }
            else {
                this.setPosition(this.posX, this.posY, this.posZ);
                this.setRotation(this.rotationYaw, this.rotationPitch);
            }
        }
        else {
            this.prevPosX = this.posX;
            this.prevPosY = this.posY;
            this.prevPosZ = this.posZ;
            if (!this.hasNoGravity()) {
                this.motionY -= 0.03999999910593033;
            }
            final int llllllllllllllllIlIIIIllllIllllI = MathHelper.floor(this.posX);
            int llllllllllllllllIlIIIIllllIlllIl = MathHelper.floor(this.posY);
            final int llllllllllllllllIlIIIIllllIlllII = MathHelper.floor(this.posZ);
            if (BlockRailBase.isRailBlock(this.world, new BlockPos(llllllllllllllllIlIIIIllllIllllI, llllllllllllllllIlIIIIllllIlllIl - 1, llllllllllllllllIlIIIIllllIlllII))) {
                --llllllllllllllllIlIIIIllllIlllIl;
            }
            final BlockPos llllllllllllllllIlIIIIllllIllIll = new BlockPos(llllllllllllllllIlIIIIllllIllllI, llllllllllllllllIlIIIIllllIlllIl, llllllllllllllllIlIIIIllllIlllII);
            final IBlockState llllllllllllllllIlIIIIllllIllIlI = this.world.getBlockState(llllllllllllllllIlIIIIllllIllIll);
            if (BlockRailBase.isRailBlock(llllllllllllllllIlIIIIllllIllIlI)) {
                this.moveAlongTrack(llllllllllllllllIlIIIIllllIllIll, llllllllllllllllIlIIIIllllIllIlI);
                if (llllllllllllllllIlIIIIllllIllIlI.getBlock() == Blocks.ACTIVATOR_RAIL) {
                    this.onActivatorRailPass(llllllllllllllllIlIIIIllllIllllI, llllllllllllllllIlIIIIllllIlllIl, llllllllllllllllIlIIIIllllIlllII, llllllllllllllllIlIIIIllllIllIlI.getValue((IProperty<Boolean>)BlockRailPowered.POWERED));
                }
            }
            else {
                this.moveDerailedMinecart();
            }
            this.doBlockCollisions();
            this.rotationPitch = 0.0f;
            final double llllllllllllllllIlIIIIllllIllIIl = this.prevPosX - this.posX;
            final double llllllllllllllllIlIIIIllllIllIII = this.prevPosZ - this.posZ;
            if (llllllllllllllllIlIIIIllllIllIIl * llllllllllllllllIlIIIIllllIllIIl + llllllllllllllllIlIIIIllllIllIII * llllllllllllllllIlIIIIllllIllIII > 0.001) {
                this.rotationYaw = (float)(MathHelper.atan2(llllllllllllllllIlIIIIllllIllIII, llllllllllllllllIlIIIIllllIllIIl) * 180.0 / 3.141592653589793);
                if (this.isInReverse) {
                    this.rotationYaw += 180.0f;
                }
            }
            final double llllllllllllllllIlIIIIllllIlIlll = MathHelper.wrapDegrees(this.rotationYaw - this.prevRotationYaw);
            if (llllllllllllllllIlIIIIllllIlIlll < -170.0 || llllllllllllllllIlIIIIllllIlIlll >= 170.0) {
                this.rotationYaw += 180.0f;
                this.isInReverse = !this.isInReverse;
            }
            this.setRotation(this.rotationYaw, this.rotationPitch);
            if (this.getType() == Type.RIDEABLE && this.motionX * this.motionX + this.motionZ * this.motionZ > 0.01) {
                final List<Entity> llllllllllllllllIlIIIIllllIlIllI = this.world.getEntitiesInAABBexcluding(this, this.getEntityBoundingBox().expand(0.20000000298023224, 0.0, 0.20000000298023224), EntitySelectors.getTeamCollisionPredicate(this));
                if (!llllllllllllllllIlIIIIllllIlIllI.isEmpty()) {
                    for (int llllllllllllllllIlIIIIllllIlIlIl = 0; llllllllllllllllIlIIIIllllIlIlIl < llllllllllllllllIlIIIIllllIlIllI.size(); ++llllllllllllllllIlIIIIllllIlIlIl) {
                        final Entity llllllllllllllllIlIIIIllllIlIlII = llllllllllllllllIlIIIIllllIlIllI.get(llllllllllllllllIlIIIIllllIlIlIl);
                        if (!(llllllllllllllllIlIIIIllllIlIlII instanceof EntityPlayer) && !(llllllllllllllllIlIIIIllllIlIlII instanceof EntityIronGolem) && !(llllllllllllllllIlIIIIllllIlIlII instanceof EntityMinecart) && !this.isBeingRidden() && !llllllllllllllllIlIIIIllllIlIlII.isRiding()) {
                            llllllllllllllllIlIIIIllllIlIlII.startRiding(this);
                        }
                        else {
                            llllllllllllllllIlIIIIllllIlIlII.applyEntityCollision(this);
                        }
                    }
                }
            }
            else {
                for (final Entity llllllllllllllllIlIIIIllllIlIIll : this.world.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox().expand(0.20000000298023224, 0.0, 0.20000000298023224))) {
                    if (!this.isPassenger(llllllllllllllllIlIIIIllllIlIIll) && llllllllllllllllIlIIIIllllIlIIll.canBePushed() && llllllllllllllllIlIIIIllllIlIIll instanceof EntityMinecart) {
                        llllllllllllllllIlIIIIllllIlIIll.applyEntityCollision(this);
                    }
                }
            }
            this.handleWaterMovement();
        }
    }
    
    public void setDisplayTileOffset(final int llllllllllllllllIlIIIIlIIIllllIl) {
        this.getDataManager().set(EntityMinecart.DISPLAY_TILE_OFFSET, llllllllllllllllIlIIIIlIIIllllIl);
        this.setHasDisplayTile(true);
    }
    
    public void setHasDisplayTile(final boolean llllllllllllllllIlIIIIlIIIllIlII) {
        this.getDataManager().set(EntityMinecart.SHOW_BLOCK, llllllllllllllllIlIIIIlIIIllIlII);
    }
    
    @Override
    public boolean attackEntityFrom(final DamageSource llllllllllllllllIlIIIlIIIIllIlll, final float llllllllllllllllIlIIIlIIIIllllIl) {
        if (this.world.isRemote || this.isDead) {
            return true;
        }
        if (this.isEntityInvulnerable(llllllllllllllllIlIIIlIIIIllIlll)) {
            return false;
        }
        this.setRollingDirection(-this.getRollingDirection());
        this.setRollingAmplitude(10);
        this.setBeenAttacked();
        this.setDamage(this.getDamage() + llllllllllllllllIlIIIlIIIIllllIl * 10.0f);
        final boolean llllllllllllllllIlIIIlIIIIlllIll = llllllllllllllllIlIIIlIIIIllIlll.getEntity() instanceof EntityPlayer && ((EntityPlayer)llllllllllllllllIlIIIlIIIIllIlll.getEntity()).capabilities.isCreativeMode;
        if (llllllllllllllllIlIIIlIIIIlllIll || this.getDamage() > 40.0f) {
            this.removePassengers();
            if (llllllllllllllllIlIIIlIIIIlllIll && !this.hasCustomName()) {
                this.setDead();
            }
            else {
                this.killMinecart(llllllllllllllllIlIIIlIIIIllIlll);
            }
        }
        return true;
    }
    
    public static EntityMinecart create(final World llllllllllllllllIlIIIlIIlIIIIIIl, final double llllllllllllllllIlIIIlIIlIIIIlIl, final double llllllllllllllllIlIIIlIIlIIIIlII, final double llllllllllllllllIlIIIlIIIllllllI, final Type llllllllllllllllIlIIIlIIIlllllIl) {
        switch ($SWITCH_TABLE$net$minecraft$entity$item$EntityMinecart$Type()[llllllllllllllllIlIIIlIIIlllllIl.ordinal()]) {
            case 2: {
                return new EntityMinecartChest(llllllllllllllllIlIIIlIIlIIIIIIl, llllllllllllllllIlIIIlIIlIIIIlIl, llllllllllllllllIlIIIlIIlIIIIlII, llllllllllllllllIlIIIlIIIllllllI);
            }
            case 3: {
                return new EntityMinecartFurnace(llllllllllllllllIlIIIlIIlIIIIIIl, llllllllllllllllIlIIIlIIlIIIIlIl, llllllllllllllllIlIIIlIIlIIIIlII, llllllllllllllllIlIIIlIIIllllllI);
            }
            case 4: {
                return new EntityMinecartTNT(llllllllllllllllIlIIIlIIlIIIIIIl, llllllllllllllllIlIIIlIIlIIIIlIl, llllllllllllllllIlIIIlIIlIIIIlII, llllllllllllllllIlIIIlIIIllllllI);
            }
            case 5: {
                return new EntityMinecartMobSpawner(llllllllllllllllIlIIIlIIlIIIIIIl, llllllllllllllllIlIIIlIIlIIIIlIl, llllllllllllllllIlIIIlIIlIIIIlII, llllllllllllllllIlIIIlIIIllllllI);
            }
            case 6: {
                return new EntityMinecartHopper(llllllllllllllllIlIIIlIIlIIIIIIl, llllllllllllllllIlIIIlIIlIIIIlIl, llllllllllllllllIlIIIlIIlIIIIlII, llllllllllllllllIlIIIlIIIllllllI);
            }
            case 7: {
                return new EntityMinecartCommandBlock(llllllllllllllllIlIIIlIIlIIIIIIl, llllllllllllllllIlIIIlIIlIIIIlIl, llllllllllllllllIlIIIlIIlIIIIlII, llllllllllllllllIlIIIlIIIllllllI);
            }
            default: {
                return new EntityMinecartEmpty(llllllllllllllllIlIIIlIIlIIIIIIl, llllllllllllllllIlIIIlIIlIIIIlIl, llllllllllllllllIlIIIlIIlIIIIlII, llllllllllllllllIlIIIlIIIllllllI);
            }
        }
    }
    
    @Override
    public void setVelocity(final double llllllllllllllllIlIIIIlIIllIlllI, final double llllllllllllllllIlIIIIlIIllIllIl, final double llllllllllllllllIlIIIIlIIllIllII) {
        this.motionX = llllllllllllllllIlIIIIlIIllIlllI;
        this.motionY = llllllllllllllllIlIIIIlIIllIllIl;
        this.motionZ = llllllllllllllllIlIIIIlIIllIllII;
        this.velocityX = this.motionX;
        this.velocityY = this.motionY;
        this.velocityZ = this.motionZ;
    }
    
    @Override
    public void setPosition(final double llllllllllllllllIlIIIIllIlIIlIII, final double llllllllllllllllIlIIIIllIlIIllIl, final double llllllllllllllllIlIIIIllIlIIllII) {
        this.posX = llllllllllllllllIlIIIIllIlIIlIII;
        this.posY = llllllllllllllllIlIIIIllIlIIllIl;
        this.posZ = llllllllllllllllIlIIIIllIlIIllII;
        final float llllllllllllllllIlIIIIllIlIIlIll = this.width / 2.0f;
        final float llllllllllllllllIlIIIIllIlIIlIlI = this.height;
        this.setEntityBoundingBox(new AxisAlignedBB(llllllllllllllllIlIIIIllIlIIlIII - llllllllllllllllIlIIIIllIlIIlIll, llllllllllllllllIlIIIIllIlIIllIl, llllllllllllllllIlIIIIllIlIIllII - llllllllllllllllIlIIIIllIlIIlIll, llllllllllllllllIlIIIIllIlIIlIII + llllllllllllllllIlIIIIllIlIIlIll, llllllllllllllllIlIIIIllIlIIllIl + llllllllllllllllIlIIIIllIlIIlIlI, llllllllllllllllIlIIIIllIlIIllII + llllllllllllllllIlIIIIllIlIIlIll));
    }
    
    protected void applyDrag() {
        if (this.isBeingRidden()) {
            this.motionX *= 0.996999979019165;
            this.motionY *= 0.0;
            this.motionZ *= 0.996999979019165;
        }
        else {
            this.motionX *= 0.9599999785423279;
            this.motionY *= 0.0;
            this.motionZ *= 0.9599999785423279;
        }
    }
    
    public abstract Type getType();
    
    public boolean hasDisplayTile() {
        return this.getDataManager().get(EntityMinecart.SHOW_BLOCK);
    }
    
    public int getDefaultDisplayTileOffset() {
        return 6;
    }
    
    public int getRollingAmplitude() {
        return this.dataManager.get(EntityMinecart.ROLLING_AMPLITUDE);
    }
    
    public EntityMinecart(final World llllllllllllllllIlIIIlIIlIIlIlll) {
        super(llllllllllllllllIlIIIlIIlIIlIlll);
        this.preventEntitySpawning = true;
        this.setSize(0.98f, 0.7f);
    }
    
    static {
        ROLLING_AMPLITUDE = EntityDataManager.createKey(EntityMinecart.class, DataSerializers.VARINT);
        ROLLING_DIRECTION = EntityDataManager.createKey(EntityMinecart.class, DataSerializers.VARINT);
        DAMAGE = EntityDataManager.createKey(EntityMinecart.class, DataSerializers.FLOAT);
        DISPLAY_TILE = EntityDataManager.createKey(EntityMinecart.class, DataSerializers.VARINT);
        DISPLAY_TILE_OFFSET = EntityDataManager.createKey(EntityMinecart.class, DataSerializers.VARINT);
        SHOW_BLOCK = EntityDataManager.createKey(EntityMinecart.class, DataSerializers.BOOLEAN);
        MATRIX = new int[][][] { { { 0, 0, -1 }, { 0, 0, 1 } }, { { -1, 0, 0 }, { 1, 0, 0 } }, { { -1, -1, 0 }, { 1, 0, 0 } }, { { -1, 0, 0 }, { 1, -1, 0 } }, { { 0, 0, -1 }, { 0, -1, 1 } }, { { 0, -1, -1 }, { 0, 0, 1 } }, { { 0, 0, 1 }, { 1, 0, 0 } }, { { 0, 0, 1 }, { -1, 0, 0 } }, { { 0, 0, -1 }, { -1, 0, 0 } }, { { 0, 0, -1 }, { 1, 0, 0 } } };
    }
    
    @Override
    public void performHurtAnimation() {
        this.setRollingDirection(-this.getRollingDirection());
        this.setRollingAmplitude(10);
        this.setDamage(this.getDamage() + this.getDamage() * 10.0f);
    }
    
    protected double getMaximumSpeed() {
        return 0.4;
    }
    
    public void setRollingAmplitude(final int llllllllllllllllIlIIIIlIIlIlllll) {
        this.dataManager.set(EntityMinecart.ROLLING_AMPLITUDE, llllllllllllllllIlIIIIlIIlIlllll);
    }
    
    @Override
    protected void readEntityFromNBT(final NBTTagCompound llllllllllllllllIlIIIIlIllIIlIII) {
        if (llllllllllllllllIlIIIIlIllIIlIII.getBoolean("CustomDisplayTile")) {
            Block llllllllllllllllIlIIIIlIllIIIllI = null;
            if (llllllllllllllllIlIIIIlIllIIlIII.hasKey("DisplayTile", 8)) {
                final Block llllllllllllllllIlIIIIlIllIIIlll = Block.getBlockFromName(llllllllllllllllIlIIIIlIllIIlIII.getString("DisplayTile"));
            }
            else {
                llllllllllllllllIlIIIIlIllIIIllI = Block.getBlockById(llllllllllllllllIlIIIIlIllIIlIII.getInteger("DisplayTile"));
            }
            final int llllllllllllllllIlIIIIlIllIIIlIl = llllllllllllllllIlIIIIlIllIIlIII.getInteger("DisplayData");
            this.setDisplayTile((llllllllllllllllIlIIIIlIllIIIllI == null) ? Blocks.AIR.getDefaultState() : llllllllllllllllIlIIIIlIllIIIllI.getStateFromMeta(llllllllllllllllIlIIIIlIllIIIlIl));
            this.setDisplayTileOffset(llllllllllllllllIlIIIIlIllIIlIII.getInteger("DisplayOffset"));
        }
    }
    
    @Nullable
    public Vec3d getPos(double llllllllllllllllIlIIIIlIlllIlIlI, double llllllllllllllllIlIIIIlIlllIlIII, double llllllllllllllllIlIIIIlIlllIIllI) {
        final int llllllllllllllllIlIIIIlIllllllll = MathHelper.floor(llllllllllllllllIlIIIIlIlllIlIlI);
        int llllllllllllllllIlIIIIlIlllllllI = MathHelper.floor(llllllllllllllllIlIIIIlIlllIlIII);
        final int llllllllllllllllIlIIIIlIllllllIl = MathHelper.floor(llllllllllllllllIlIIIIlIlllIIllI);
        if (BlockRailBase.isRailBlock(this.world, new BlockPos(llllllllllllllllIlIIIIlIllllllll, llllllllllllllllIlIIIIlIlllllllI - 1, llllllllllllllllIlIIIIlIllllllIl))) {
            --llllllllllllllllIlIIIIlIlllllllI;
        }
        final IBlockState llllllllllllllllIlIIIIlIllllllII = this.world.getBlockState(new BlockPos(llllllllllllllllIlIIIIlIllllllll, llllllllllllllllIlIIIIlIlllllllI, llllllllllllllllIlIIIIlIllllllIl));
        if (BlockRailBase.isRailBlock(llllllllllllllllIlIIIIlIllllllII)) {
            final BlockRailBase.EnumRailDirection llllllllllllllllIlIIIIlIlllllIll = llllllllllllllllIlIIIIlIllllllII.getValue(((BlockRailBase)llllllllllllllllIlIIIIlIllllllII.getBlock()).getShapeProperty());
            final int[][] llllllllllllllllIlIIIIlIlllllIlI = EntityMinecart.MATRIX[llllllllllllllllIlIIIIlIlllllIll.getMetadata()];
            final double llllllllllllllllIlIIIIlIlllllIIl = llllllllllllllllIlIIIIlIllllllll + 0.5 + llllllllllllllllIlIIIIlIlllllIlI[0][0] * 0.5;
            final double llllllllllllllllIlIIIIlIlllllIII = llllllllllllllllIlIIIIlIlllllllI + 0.0625 + llllllllllllllllIlIIIIlIlllllIlI[0][1] * 0.5;
            final double llllllllllllllllIlIIIIlIllllIlll = llllllllllllllllIlIIIIlIllllllIl + 0.5 + llllllllllllllllIlIIIIlIlllllIlI[0][2] * 0.5;
            final double llllllllllllllllIlIIIIlIllllIllI = llllllllllllllllIlIIIIlIllllllll + 0.5 + llllllllllllllllIlIIIIlIlllllIlI[1][0] * 0.5;
            final double llllllllllllllllIlIIIIlIllllIlIl = llllllllllllllllIlIIIIlIlllllllI + 0.0625 + llllllllllllllllIlIIIIlIlllllIlI[1][1] * 0.5;
            final double llllllllllllllllIlIIIIlIllllIlII = llllllllllllllllIlIIIIlIllllllIl + 0.5 + llllllllllllllllIlIIIIlIlllllIlI[1][2] * 0.5;
            final double llllllllllllllllIlIIIIlIllllIIll = llllllllllllllllIlIIIIlIllllIllI - llllllllllllllllIlIIIIlIlllllIIl;
            final double llllllllllllllllIlIIIIlIllllIIlI = (llllllllllllllllIlIIIIlIllllIlIl - llllllllllllllllIlIIIIlIlllllIII) * 2.0;
            final double llllllllllllllllIlIIIIlIllllIIIl = llllllllllllllllIlIIIIlIllllIlII - llllllllllllllllIlIIIIlIllllIlll;
            double llllllllllllllllIlIIIIlIlllIlllI = 0.0;
            if (llllllllllllllllIlIIIIlIllllIIll == 0.0) {
                final double llllllllllllllllIlIIIIlIllllIIII = llllllllllllllllIlIIIIlIlllIIllI - llllllllllllllllIlIIIIlIllllllIl;
            }
            else if (llllllllllllllllIlIIIIlIllllIIIl == 0.0) {
                final double llllllllllllllllIlIIIIlIlllIllll = llllllllllllllllIlIIIIlIlllIlIlI - llllllllllllllllIlIIIIlIllllllll;
            }
            else {
                final double llllllllllllllllIlIIIIlIlllIllIl = llllllllllllllllIlIIIIlIlllIlIlI - llllllllllllllllIlIIIIlIlllllIIl;
                final double llllllllllllllllIlIIIIlIlllIllII = llllllllllllllllIlIIIIlIlllIIllI - llllllllllllllllIlIIIIlIllllIlll;
                llllllllllllllllIlIIIIlIlllIlllI = (llllllllllllllllIlIIIIlIlllIllIl * llllllllllllllllIlIIIIlIllllIIll + llllllllllllllllIlIIIIlIlllIllII * llllllllllllllllIlIIIIlIllllIIIl) * 2.0;
            }
            llllllllllllllllIlIIIIlIlllIlIlI = llllllllllllllllIlIIIIlIlllllIIl + llllllllllllllllIlIIIIlIllllIIll * llllllllllllllllIlIIIIlIlllIlllI;
            llllllllllllllllIlIIIIlIlllIlIII = llllllllllllllllIlIIIIlIlllllIII + llllllllllllllllIlIIIIlIllllIIlI * llllllllllllllllIlIIIIlIlllIlllI;
            llllllllllllllllIlIIIIlIlllIIllI = llllllllllllllllIlIIIIlIllllIlll + llllllllllllllllIlIIIIlIllllIIIl * llllllllllllllllIlIIIIlIlllIlllI;
            if (llllllllllllllllIlIIIIlIllllIIlI < 0.0) {
                ++llllllllllllllllIlIIIIlIlllIlIII;
            }
            if (llllllllllllllllIlIIIIlIllllIIlI > 0.0) {
                llllllllllllllllIlIIIIlIlllIlIII += 0.5;
            }
            return new Vec3d(llllllllllllllllIlIIIIlIlllIlIlI, llllllllllllllllIlIIIIlIlllIlIII, llllllllllllllllIlIIIIlIlllIIllI);
        }
        return null;
    }
    
    @Override
    public boolean canBeCollidedWith() {
        return !this.isDead;
    }
    
    @Override
    protected boolean canTriggerWalking() {
        return false;
    }
    
    public void setRollingDirection(final int llllllllllllllllIlIIIIlIIlIlIllI) {
        this.dataManager.set(EntityMinecart.ROLLING_DIRECTION, llllllllllllllllIlIIIIlIIlIlIllI);
    }
    
    @Override
    public AxisAlignedBB getRenderBoundingBox() {
        final AxisAlignedBB llllllllllllllllIlIIIIlIllIlIIlI = this.getEntityBoundingBox();
        return this.hasDisplayTile() ? llllllllllllllllIlIIIIlIllIlIIlI.expandXyz(Math.abs(this.getDisplayTileOffset()) / 16.0) : llllllllllllllllIlIIIIlIllIlIIlI;
    }
    
    @Override
    public double getMountedYOffset() {
        return 0.0;
    }
    
    public int getDisplayTileOffset() {
        return this.hasDisplayTile() ? this.getDataManager().get(EntityMinecart.DISPLAY_TILE_OFFSET) : this.getDefaultDisplayTileOffset();
    }
    
    protected void moveDerailedMinecart() {
        final double llllllllllllllllIlIIIIlllIllllII = this.getMaximumSpeed();
        this.motionX = MathHelper.clamp(this.motionX, -llllllllllllllllIlIIIIlllIllllII, llllllllllllllllIlIIIIlllIllllII);
        this.motionZ = MathHelper.clamp(this.motionZ, -llllllllllllllllIlIIIIlllIllllII, llllllllllllllllIlIIIIlllIllllII);
        if (this.onGround) {
            this.motionX *= 0.5;
            this.motionY *= 0.5;
            this.motionZ *= 0.5;
        }
        this.moveEntity(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
        if (!this.onGround) {
            this.motionX *= 0.949999988079071;
            this.motionY *= 0.949999988079071;
            this.motionZ *= 0.949999988079071;
        }
    }
    
    @Override
    public boolean canBePushed() {
        return true;
    }
    
    public float getDamage() {
        return this.dataManager.get(EntityMinecart.DAMAGE);
    }
    
    @Nullable
    @Override
    public AxisAlignedBB getCollisionBox(final Entity llllllllllllllllIlIIIlIIIlllIIIl) {
        return llllllllllllllllIlIIIlIIIlllIIIl.canBePushed() ? llllllllllllllllIlIIIlIIIlllIIIl.getEntityBoundingBox() : null;
    }
    
    public void setDamage(final float llllllllllllllllIlIIIIlIIllIlIII) {
        this.dataManager.set(EntityMinecart.DAMAGE, llllllllllllllllIlIIIIlIIllIlIII);
    }
    
    @Nullable
    public Vec3d getPosOffset(double llllllllllllllllIlIIIIllIIlIIllI, double llllllllllllllllIlIIIIllIIlIIlIl, double llllllllllllllllIlIIIIllIIlIIlII, final double llllllllllllllllIlIIIIllIIllIIIl) {
        final int llllllllllllllllIlIIIIllIIllIIII = MathHelper.floor(llllllllllllllllIlIIIIllIIlIIllI);
        int llllllllllllllllIlIIIIllIIlIllll = MathHelper.floor(llllllllllllllllIlIIIIllIIlIIlIl);
        final int llllllllllllllllIlIIIIllIIlIlllI = MathHelper.floor(llllllllllllllllIlIIIIllIIlIIlII);
        if (BlockRailBase.isRailBlock(this.world, new BlockPos(llllllllllllllllIlIIIIllIIllIIII, llllllllllllllllIlIIIIllIIlIllll - 1, llllllllllllllllIlIIIIllIIlIlllI))) {
            --llllllllllllllllIlIIIIllIIlIllll;
        }
        final IBlockState llllllllllllllllIlIIIIllIIlIllIl = this.world.getBlockState(new BlockPos(llllllllllllllllIlIIIIllIIllIIII, llllllllllllllllIlIIIIllIIlIllll, llllllllllllllllIlIIIIllIIlIlllI));
        if (BlockRailBase.isRailBlock(llllllllllllllllIlIIIIllIIlIllIl)) {
            final BlockRailBase.EnumRailDirection llllllllllllllllIlIIIIllIIlIllII = llllllllllllllllIlIIIIllIIlIllIl.getValue(((BlockRailBase)llllllllllllllllIlIIIIllIIlIllIl.getBlock()).getShapeProperty());
            llllllllllllllllIlIIIIllIIlIIlIl = llllllllllllllllIlIIIIllIIlIllll;
            if (llllllllllllllllIlIIIIllIIlIllII.isAscending()) {
                llllllllllllllllIlIIIIllIIlIIlIl = llllllllllllllllIlIIIIllIIlIllll + 1;
            }
            final int[][] llllllllllllllllIlIIIIllIIlIlIll = EntityMinecart.MATRIX[llllllllllllllllIlIIIIllIIlIllII.getMetadata()];
            double llllllllllllllllIlIIIIllIIlIlIlI = llllllllllllllllIlIIIIllIIlIlIll[1][0] - llllllllllllllllIlIIIIllIIlIlIll[0][0];
            double llllllllllllllllIlIIIIllIIlIlIIl = llllllllllllllllIlIIIIllIIlIlIll[1][2] - llllllllllllllllIlIIIIllIIlIlIll[0][2];
            final double llllllllllllllllIlIIIIllIIlIlIII = Math.sqrt(llllllllllllllllIlIIIIllIIlIlIlI * llllllllllllllllIlIIIIllIIlIlIlI + llllllllllllllllIlIIIIllIIlIlIIl * llllllllllllllllIlIIIIllIIlIlIIl);
            llllllllllllllllIlIIIIllIIlIlIlI /= llllllllllllllllIlIIIIllIIlIlIII;
            llllllllllllllllIlIIIIllIIlIlIIl /= llllllllllllllllIlIIIIllIIlIlIII;
            llllllllllllllllIlIIIIllIIlIIllI += llllllllllllllllIlIIIIllIIlIlIlI * llllllllllllllllIlIIIIllIIllIIIl;
            llllllllllllllllIlIIIIllIIlIIlII += llllllllllllllllIlIIIIllIIlIlIIl * llllllllllllllllIlIIIIllIIllIIIl;
            if (llllllllllllllllIlIIIIllIIlIlIll[0][1] != 0 && MathHelper.floor(llllllllllllllllIlIIIIllIIlIIllI) - llllllllllllllllIlIIIIllIIllIIII == llllllllllllllllIlIIIIllIIlIlIll[0][0] && MathHelper.floor(llllllllllllllllIlIIIIllIIlIIlII) - llllllllllllllllIlIIIIllIIlIlllI == llllllllllllllllIlIIIIllIIlIlIll[0][2]) {
                llllllllllllllllIlIIIIllIIlIIlIl += llllllllllllllllIlIIIIllIIlIlIll[0][1];
            }
            else if (llllllllllllllllIlIIIIllIIlIlIll[1][1] != 0 && MathHelper.floor(llllllllllllllllIlIIIIllIIlIIllI) - llllllllllllllllIlIIIIllIIllIIII == llllllllllllllllIlIIIIllIIlIlIll[1][0] && MathHelper.floor(llllllllllllllllIlIIIIllIIlIIlII) - llllllllllllllllIlIIIIllIIlIlllI == llllllllllllllllIlIIIIllIIlIlIll[1][2]) {
                llllllllllllllllIlIIIIllIIlIIlIl += llllllllllllllllIlIIIIllIIlIlIll[1][1];
            }
            return this.getPos(llllllllllllllllIlIIIIllIIlIIllI, llllllllllllllllIlIIIIllIIlIIlIl, llllllllllllllllIlIIIIllIIlIIlII);
        }
        return null;
    }
    
    public static void registerFixesMinecart(final DataFixer llllllllllllllllIlIIIIlIllIIllll, final Class<?> llllllllllllllllIlIIIIlIllIIlllI) {
    }
    
    public enum Type
    {
        private final /* synthetic */ int id;
        
        SPAWNER("SPAWNER", 4, 4, "MinecartSpawner"), 
        RIDEABLE("RIDEABLE", 0, 0, "MinecartRideable"), 
        HOPPER("HOPPER", 5, 5, "MinecartHopper"), 
        TNT("TNT", 3, 3, "MinecartTNT"), 
        FURNACE("FURNACE", 2, 2, "MinecartFurnace");
        
        private final /* synthetic */ String name;
        
        CHEST("CHEST", 1, 1, "MinecartChest");
        
        private static final /* synthetic */ Map<Integer, Type> BY_ID;
        
        COMMAND_BLOCK("COMMAND_BLOCK", 6, 6, "MinecartCommandBlock");
        
        public static Type getById(final int lllllllllllllIIIIlIIllIIIIIlllll) {
            final Type lllllllllllllIIIIlIIllIIIIlIIIII = Type.BY_ID.get(lllllllllllllIIIIlIIllIIIIIlllll);
            return (lllllllllllllIIIIlIIllIIIIlIIIII == null) ? Type.RIDEABLE : lllllllllllllIIIIlIIllIIIIlIIIII;
        }
        
        static {
            BY_ID = Maps.newHashMap();
            final int lllllllllllllIIIIlIIllIIIIllIlll;
            final String lllllllllllllIIIIlIIllIIIIlllIII = (String)((Type[])(Object)(lllllllllllllIIIIlIIllIIIIllIlll = (int)(Object)values())).length;
            for (char lllllllllllllIIIIlIIllIIIIlllIIl = '\0'; lllllllllllllIIIIlIIllIIIIlllIIl < lllllllllllllIIIIlIIllIIIIlllIII; ++lllllllllllllIIIIlIIllIIIIlllIIl) {
                final Type lllllllllllllIIIIlIIllIIIIlllIll = lllllllllllllIIIIlIIllIIIIllIlll[lllllllllllllIIIIlIIllIIIIlllIIl];
                Type.BY_ID.put(lllllllllllllIIIIlIIllIIIIlllIll.getId(), lllllllllllllIIIIlIIllIIIIlllIll);
            }
        }
        
        public int getId() {
            return this.id;
        }
        
        public String getName() {
            return this.name;
        }
        
        private Type(final String lllllllllllllIIIIlIIllIIIIlIllIl, final int lllllllllllllIIIIlIIllIIIIlIllII, final int lllllllllllllIIIIlIIllIIIIllIIII, final String lllllllllllllIIIIlIIllIIIIlIllll) {
            this.id = lllllllllllllIIIIlIIllIIIIllIIII;
            this.name = lllllllllllllIIIIlIIllIIIIlIllll;
        }
    }
}
