package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.tileentity.*;
import javax.annotation.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import net.minecraft.entity.player.*;
import net.minecraft.stats.*;
import net.minecraft.world.*;
import net.minecraft.item.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.*;
import net.minecraft.inventory.*;
import net.minecraft.util.*;
import net.minecraft.block.state.*;

public class BlockChest extends BlockContainer
{
    protected static final /* synthetic */ AxisAlignedBB SOUTH_CHEST_AABB;
    protected static final /* synthetic */ AxisAlignedBB WEST_CHEST_AABB;
    public static final /* synthetic */ PropertyDirection FACING;
    protected static final /* synthetic */ AxisAlignedBB NOT_CONNECTED_AABB;
    public final /* synthetic */ Type chestType;
    protected static final /* synthetic */ AxisAlignedBB NORTH_CHEST_AABB;
    protected static final /* synthetic */ AxisAlignedBB EAST_CHEST_AABB;
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllIIIlIIIlIIlIllllIlI) {
        return lllllllllllllIIIlIIIlIIlIllllIlI.getValue((IProperty<EnumFacing>)BlockChest.FACING).getIndex();
    }
    
    @Override
    public int getComparatorInputOverride(final IBlockState lllllllllllllIIIlIIIlIIllIIIllII, final World lllllllllllllIIIlIIIlIIllIIIlIll, final BlockPos lllllllllllllIIIlIIIlIIllIIIlIlI) {
        return Container.calcRedstoneFromInventory(this.getLockableContainer(lllllllllllllIIIlIIIlIIllIIIlIll, lllllllllllllIIIlIIIlIIllIIIlIlI));
    }
    
    @Nullable
    public ILockableContainer getContainer(final World lllllllllllllIIIlIIIlIIllllIIIII, final BlockPos lllllllllllllIIIlIIIlIIlllIlllll, final boolean lllllllllllllIIIlIIIlIIlllIllllI) {
        final TileEntity lllllllllllllIIIlIIIlIIllllIIlll = lllllllllllllIIIlIIIlIIllllIIIII.getTileEntity(lllllllllllllIIIlIIIlIIlllIlllll);
        if (!(lllllllllllllIIIlIIIlIIllllIIlll instanceof TileEntityChest)) {
            return null;
        }
        ILockableContainer lllllllllllllIIIlIIIlIIllllIIllI = (TileEntityChest)lllllllllllllIIIlIIIlIIllllIIlll;
        if (!lllllllllllllIIIlIIIlIIlllIllllI && this.isBlocked(lllllllllllllIIIlIIIlIIllllIIIII, lllllllllllllIIIlIIIlIIlllIlllll)) {
            return null;
        }
        for (final EnumFacing lllllllllllllIIIlIIIlIIllllIIlIl : EnumFacing.Plane.HORIZONTAL) {
            final BlockPos lllllllllllllIIIlIIIlIIllllIIlII = lllllllllllllIIIlIIIlIIlllIlllll.offset(lllllllllllllIIIlIIIlIIllllIIlIl);
            final Block lllllllllllllIIIlIIIlIIllllIIIll = lllllllllllllIIIlIIIlIIllllIIIII.getBlockState(lllllllllllllIIIlIIIlIIllllIIlII).getBlock();
            if (lllllllllllllIIIlIIIlIIllllIIIll == this) {
                if (this.isBlocked(lllllllllllllIIIlIIIlIIllllIIIII, lllllllllllllIIIlIIIlIIllllIIlII)) {
                    return null;
                }
                final TileEntity lllllllllllllIIIlIIIlIIllllIIIlI = lllllllllllllIIIlIIIlIIllllIIIII.getTileEntity(lllllllllllllIIIlIIIlIIllllIIlII);
                if (!(lllllllllllllIIIlIIIlIIllllIIIlI instanceof TileEntityChest)) {
                    continue;
                }
                if (lllllllllllllIIIlIIIlIIllllIIlIl != EnumFacing.WEST && lllllllllllllIIIlIIIlIIllllIIlIl != EnumFacing.NORTH) {
                    lllllllllllllIIIlIIIlIIllllIIllI = new InventoryLargeChest("container.chestDouble", lllllllllllllIIIlIIIlIIllllIIllI, (ILockableContainer)lllllllllllllIIIlIIIlIIllllIIIlI);
                }
                else {
                    lllllllllllllIIIlIIIlIIllllIIllI = new InventoryLargeChest("container.chestDouble", (ILockableContainer)lllllllllllllIIIlIIIlIIllllIIIlI, lllllllllllllIIIlIIIlIIllllIIllI);
                }
            }
        }
        return lllllllllllllIIIlIIIlIIllllIIllI;
    }
    
    private boolean isBelowSolidBlock(final World lllllllllllllIIIlIIIlIIllIlIIIll, final BlockPos lllllllllllllIIIlIIIlIIllIlIIIlI) {
        return lllllllllllllIIIlIIIlIIllIlIIIll.getBlockState(lllllllllllllIIIlIIIlIIllIlIIIlI.up()).isNormalCube();
    }
    
    protected BlockChest(final Type lllllllllllllIIIlIIIlIllIllIlllI) {
        super(Material.WOOD);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockChest.FACING, EnumFacing.NORTH));
        this.chestType = lllllllllllllIIIlIIIlIllIllIlllI;
        this.setCreativeTab((lllllllllllllIIIlIIIlIllIllIlllI == Type.TRAP) ? CreativeTabs.REDSTONE : CreativeTabs.DECORATIONS);
    }
    
    @Override
    public boolean onBlockActivated(final World lllllllllllllIIIlIIIlIlIIIIIlllI, final BlockPos lllllllllllllIIIlIIIlIlIIIIIIIlI, final IBlockState lllllllllllllIIIlIIIlIlIIIIIllII, final EntityPlayer lllllllllllllIIIlIIIlIlIIIIIIIIl, final EnumHand lllllllllllllIIIlIIIlIlIIIIIlIlI, final EnumFacing lllllllllllllIIIlIIIlIlIIIIIlIIl, final float lllllllllllllIIIlIIIlIlIIIIIlIII, final float lllllllllllllIIIlIIIlIlIIIIIIlll, final float lllllllllllllIIIlIIIlIlIIIIIIllI) {
        if (lllllllllllllIIIlIIIlIlIIIIIlllI.isRemote) {
            return true;
        }
        final ILockableContainer lllllllllllllIIIlIIIlIlIIIIIIlIl = this.getLockableContainer(lllllllllllllIIIlIIIlIlIIIIIlllI, lllllllllllllIIIlIIIlIlIIIIIIIlI);
        if (lllllllllllllIIIlIIIlIlIIIIIIlIl != null) {
            lllllllllllllIIIlIIIlIlIIIIIIIIl.displayGUIChest(lllllllllllllIIIlIIIlIlIIIIIIlIl);
            if (this.chestType == Type.BASIC) {
                lllllllllllllIIIlIIIlIlIIIIIIIIl.addStat(StatList.CHEST_OPENED);
            }
            else if (this.chestType == Type.TRAP) {
                lllllllllllllIIIlIIIlIlIIIIIIIIl.addStat(StatList.TRAPPED_CHEST_TRIGGERED);
            }
        }
        return true;
    }
    
    public IBlockState correctFacing(final World lllllllllllllIIIlIIIlIlIlIIIIlIl, final BlockPos lllllllllllllIIIlIIIlIlIlIIIIIll, final IBlockState lllllllllllllIIIlIIIlIlIlIIIlllI) {
        EnumFacing lllllllllllllIIIlIIIlIlIlIIIllIl = null;
        for (final EnumFacing lllllllllllllIIIlIIIlIlIlIIIlIll : EnumFacing.Plane.HORIZONTAL) {
            final IBlockState lllllllllllllIIIlIIIlIlIlIIIlIIl = lllllllllllllIIIlIIIlIlIlIIIIlIl.getBlockState(lllllllllllllIIIlIIIlIlIlIIIIIll.offset(lllllllllllllIIIlIIIlIlIlIIIlIll));
            if (lllllllllllllIIIlIIIlIlIlIIIlIIl.getBlock() == this) {
                return lllllllllllllIIIlIIIlIlIlIIIlllI;
            }
            if (!lllllllllllllIIIlIIIlIlIlIIIlIIl.isFullBlock()) {
                continue;
            }
            if (lllllllllllllIIIlIIIlIlIlIIIllIl != null) {
                lllllllllllllIIIlIIIlIlIlIIIllIl = null;
                break;
            }
            lllllllllllllIIIlIIIlIlIlIIIllIl = lllllllllllllIIIlIIIlIlIlIIIlIll;
        }
        if (lllllllllllllIIIlIIIlIlIlIIIllIl != null) {
            return lllllllllllllIIIlIIIlIlIlIIIlllI.withProperty((IProperty<Comparable>)BlockChest.FACING, lllllllllllllIIIlIIIlIlIlIIIllIl.getOpposite());
        }
        EnumFacing lllllllllllllIIIlIIIlIlIlIIIIlll = lllllllllllllIIIlIIIlIlIlIIIlllI.getValue((IProperty<EnumFacing>)BlockChest.FACING);
        if (lllllllllllllIIIlIIIlIlIlIIIIlIl.getBlockState(lllllllllllllIIIlIIIlIlIlIIIIIll.offset(lllllllllllllIIIlIIIlIlIlIIIIlll)).isFullBlock()) {
            lllllllllllllIIIlIIIlIlIlIIIIlll = lllllllllllllIIIlIIIlIlIlIIIIlll.getOpposite();
        }
        if (lllllllllllllIIIlIIIlIlIlIIIIlIl.getBlockState(lllllllllllllIIIlIIIlIlIlIIIIIll.offset(lllllllllllllIIIlIIIlIlIlIIIIlll)).isFullBlock()) {
            lllllllllllllIIIlIIIlIlIlIIIIlll = lllllllllllllIIIlIIIlIlIlIIIIlll.rotateY();
        }
        if (lllllllllllllIIIlIIIlIlIlIIIIlIl.getBlockState(lllllllllllllIIIlIIIlIlIlIIIIIll.offset(lllllllllllllIIIlIIIlIlIlIIIIlll)).isFullBlock()) {
            lllllllllllllIIIlIIIlIlIlIIIIlll = lllllllllllllIIIlIIIlIlIlIIIIlll.getOpposite();
        }
        return lllllllllllllIIIlIIIlIlIlIIIlllI.withProperty((IProperty<Comparable>)BlockChest.FACING, lllllllllllllIIIlIIIlIlIlIIIIlll);
    }
    
    @Override
    public int getStrongPower(final IBlockState lllllllllllllIIIlIIIlIIllIllIlIl, final IBlockAccess lllllllllllllIIIlIIIlIIllIllIlII, final BlockPos lllllllllllllIIIlIIIlIIllIllIIll, final EnumFacing lllllllllllllIIIlIIIlIIllIllIIlI) {
        return (lllllllllllllIIIlIIIlIIllIllIIlI == EnumFacing.UP) ? lllllllllllllIIIlIIIlIIllIllIlIl.getWeakPower(lllllllllllllIIIlIIIlIIllIllIlII, lllllllllllllIIIlIIIlIIllIllIIll, lllllllllllllIIIlIIIlIIllIllIIlI) : 0;
    }
    
    @Override
    public void onBlockPlacedBy(final World lllllllllllllIIIlIIIlIllIIIlIlII, final BlockPos lllllllllllllIIIlIIIlIllIIlIIIll, IBlockState lllllllllllllIIIlIIIlIllIIIlIIlI, final EntityLivingBase lllllllllllllIIIlIIIlIllIIlIIIIl, final ItemStack lllllllllllllIIIlIIIlIllIIlIIIII) {
        final EnumFacing lllllllllllllIIIlIIIlIllIIIlllll = EnumFacing.getHorizontal(MathHelper.floor(lllllllllllllIIIlIIIlIllIIlIIIIl.rotationYaw * 4.0f / 360.0f + 0.5) & 0x3).getOpposite();
        lllllllllllllIIIlIIIlIllIIIlIIlI = lllllllllllllIIIlIIIlIllIIIlIIlI.withProperty((IProperty<Comparable>)BlockChest.FACING, lllllllllllllIIIlIIIlIllIIIlllll);
        final BlockPos lllllllllllllIIIlIIIlIllIIIllllI = lllllllllllllIIIlIIIlIllIIlIIIll.north();
        final BlockPos lllllllllllllIIIlIIIlIllIIIlllIl = lllllllllllllIIIlIIIlIllIIlIIIll.south();
        final BlockPos lllllllllllllIIIlIIIlIllIIIlllII = lllllllllllllIIIlIIIlIllIIlIIIll.west();
        final BlockPos lllllllllllllIIIlIIIlIllIIIllIll = lllllllllllllIIIlIIIlIllIIlIIIll.east();
        final boolean lllllllllllllIIIlIIIlIllIIIllIlI = this == lllllllllllllIIIlIIIlIllIIIlIlII.getBlockState(lllllllllllllIIIlIIIlIllIIIllllI).getBlock();
        final boolean lllllllllllllIIIlIIIlIllIIIllIIl = this == lllllllllllllIIIlIIIlIllIIIlIlII.getBlockState(lllllllllllllIIIlIIIlIllIIIlllIl).getBlock();
        final boolean lllllllllllllIIIlIIIlIllIIIllIII = this == lllllllllllllIIIlIIIlIllIIIlIlII.getBlockState(lllllllllllllIIIlIIIlIllIIIlllII).getBlock();
        final boolean lllllllllllllIIIlIIIlIllIIIlIlll = this == lllllllllllllIIIlIIIlIllIIIlIlII.getBlockState(lllllllllllllIIIlIIIlIllIIIllIll).getBlock();
        if (!lllllllllllllIIIlIIIlIllIIIllIlI && !lllllllllllllIIIlIIIlIllIIIllIIl && !lllllllllllllIIIlIIIlIllIIIllIII && !lllllllllllllIIIlIIIlIllIIIlIlll) {
            lllllllllllllIIIlIIIlIllIIIlIlII.setBlockState(lllllllllllllIIIlIIIlIllIIlIIIll, lllllllllllllIIIlIIIlIllIIIlIIlI, 3);
        }
        else if (lllllllllllllIIIlIIIlIllIIIlllll.getAxis() != EnumFacing.Axis.X || (!lllllllllllllIIIlIIIlIllIIIllIlI && !lllllllllllllIIIlIIIlIllIIIllIIl)) {
            if (lllllllllllllIIIlIIIlIllIIIlllll.getAxis() == EnumFacing.Axis.Z && (lllllllllllllIIIlIIIlIllIIIllIII || lllllllllllllIIIlIIIlIllIIIlIlll)) {
                if (lllllllllllllIIIlIIIlIllIIIllIII) {
                    lllllllllllllIIIlIIIlIllIIIlIlII.setBlockState(lllllllllllllIIIlIIIlIllIIIlllII, lllllllllllllIIIlIIIlIllIIIlIIlI, 3);
                }
                else {
                    lllllllllllllIIIlIIIlIllIIIlIlII.setBlockState(lllllllllllllIIIlIIIlIllIIIllIll, lllllllllllllIIIlIIIlIllIIIlIIlI, 3);
                }
                lllllllllllllIIIlIIIlIllIIIlIlII.setBlockState(lllllllllllllIIIlIIIlIllIIlIIIll, lllllllllllllIIIlIIIlIllIIIlIIlI, 3);
            }
        }
        else {
            if (lllllllllllllIIIlIIIlIllIIIllIlI) {
                lllllllllllllIIIlIIIlIllIIIlIlII.setBlockState(lllllllllllllIIIlIIIlIllIIIllllI, lllllllllllllIIIlIIIlIllIIIlIIlI, 3);
            }
            else {
                lllllllllllllIIIlIIIlIllIIIlIlII.setBlockState(lllllllllllllIIIlIIIlIllIIIlllIl, lllllllllllllIIIlIIIlIllIIIlIIlI, 3);
            }
            lllllllllllllIIIlIIIlIllIIIlIlII.setBlockState(lllllllllllllIIIlIIIlIllIIlIIIll, lllllllllllllIIIlIIIlIllIIIlIIlI, 3);
        }
        if (lllllllllllllIIIlIIIlIllIIlIIIII.hasDisplayName()) {
            final TileEntity lllllllllllllIIIlIIIlIllIIIlIllI = lllllllllllllIIIlIIIlIllIIIlIlII.getTileEntity(lllllllllllllIIIlIIIlIllIIlIIIll);
            if (lllllllllllllIIIlIIIlIllIIIlIllI instanceof TileEntityChest) {
                ((TileEntityChest)lllllllllllllIIIlIIIlIllIIIlIllI).func_190575_a(lllllllllllllIIIlIIIlIllIIlIIIII.getDisplayName());
            }
        }
    }
    
    public IBlockState checkForSurroundingChests(final World lllllllllllllIIIlIIIlIlIlIlllllI, final BlockPos lllllllllllllIIIlIIIlIlIlllIIIIl, IBlockState lllllllllllllIIIlIIIlIlIlIlllIll) {
        if (lllllllllllllIIIlIIIlIlIlIlllllI.isRemote) {
            return lllllllllllllIIIlIIIlIlIlIlllIll;
        }
        final IBlockState lllllllllllllIIIlIIIlIlIllIlllIl = lllllllllllllIIIlIIIlIlIlIlllllI.getBlockState(lllllllllllllIIIlIIIlIlIlllIIIIl.north());
        final IBlockState lllllllllllllIIIlIIIlIlIllIllIll = lllllllllllllIIIlIIIlIlIlIlllllI.getBlockState(lllllllllllllIIIlIIIlIlIlllIIIIl.south());
        final IBlockState lllllllllllllIIIlIIIlIlIllIllIlI = lllllllllllllIIIlIIIlIlIlIlllllI.getBlockState(lllllllllllllIIIlIIIlIlIlllIIIIl.west());
        final IBlockState lllllllllllllIIIlIIIlIlIllIllIII = lllllllllllllIIIlIIIlIlIlIlllllI.getBlockState(lllllllllllllIIIlIIIlIlIlllIIIIl.east());
        EnumFacing lllllllllllllIIIlIIIlIlIllIlIllI = lllllllllllllIIIlIIIlIlIlIlllIll.getValue((IProperty<EnumFacing>)BlockChest.FACING);
        if (lllllllllllllIIIlIIIlIlIllIlllIl.getBlock() != this && lllllllllllllIIIlIIIlIlIllIllIll.getBlock() != this) {
            final boolean lllllllllllllIIIlIIIlIlIllIlIlII = lllllllllllllIIIlIIIlIlIllIlllIl.isFullBlock();
            final boolean lllllllllllllIIIlIIIlIlIllIlIIlI = lllllllllllllIIIlIIIlIlIllIllIll.isFullBlock();
            if (lllllllllllllIIIlIIIlIlIllIllIlI.getBlock() == this || lllllllllllllIIIlIIIlIlIllIllIII.getBlock() == this) {
                final BlockPos lllllllllllllIIIlIIIlIlIllIlIIII = (lllllllllllllIIIlIIIlIlIllIllIlI.getBlock() == this) ? lllllllllllllIIIlIIIlIlIlllIIIIl.west() : lllllllllllllIIIlIIIlIlIlllIIIIl.east();
                final IBlockState lllllllllllllIIIlIIIlIlIllIIlllI = lllllllllllllIIIlIIIlIlIlIlllllI.getBlockState(lllllllllllllIIIlIIIlIlIllIlIIII.north());
                final IBlockState lllllllllllllIIIlIIIlIlIllIIllIl = lllllllllllllIIIlIIIlIlIlIlllllI.getBlockState(lllllllllllllIIIlIIIlIlIllIlIIII.south());
                lllllllllllllIIIlIIIlIlIllIlIllI = EnumFacing.SOUTH;
                EnumFacing lllllllllllllIIIlIIIlIlIllIIlIll = null;
                if (lllllllllllllIIIlIIIlIlIllIllIlI.getBlock() == this) {
                    final EnumFacing lllllllllllllIIIlIIIlIlIllIIllII = lllllllllllllIIIlIIIlIlIllIllIlI.getValue((IProperty<EnumFacing>)BlockChest.FACING);
                }
                else {
                    lllllllllllllIIIlIIIlIlIllIIlIll = lllllllllllllIIIlIIIlIlIllIllIII.getValue((IProperty<EnumFacing>)BlockChest.FACING);
                }
                if (lllllllllllllIIIlIIIlIlIllIIlIll == EnumFacing.NORTH) {
                    lllllllllllllIIIlIIIlIlIllIlIllI = EnumFacing.NORTH;
                }
                if ((lllllllllllllIIIlIIIlIlIllIlIlII || lllllllllllllIIIlIIIlIlIllIIlllI.isFullBlock()) && !lllllllllllllIIIlIIIlIlIllIlIIlI && !lllllllllllllIIIlIIIlIlIllIIllIl.isFullBlock()) {
                    lllllllllllllIIIlIIIlIlIllIlIllI = EnumFacing.SOUTH;
                }
                if ((lllllllllllllIIIlIIIlIlIllIlIIlI || lllllllllllllIIIlIIIlIlIllIIllIl.isFullBlock()) && !lllllllllllllIIIlIIIlIlIllIlIlII && !lllllllllllllIIIlIIIlIlIllIIlllI.isFullBlock()) {
                    lllllllllllllIIIlIIIlIlIllIlIllI = EnumFacing.NORTH;
                }
            }
        }
        else {
            final BlockPos lllllllllllllIIIlIIIlIlIllIIlIII = (lllllllllllllIIIlIIIlIlIllIlllIl.getBlock() == this) ? lllllllllllllIIIlIIIlIlIlllIIIIl.north() : lllllllllllllIIIlIIIlIlIlllIIIIl.south();
            final IBlockState lllllllllllllIIIlIIIlIlIllIIIllI = lllllllllllllIIIlIIIlIlIlIlllllI.getBlockState(lllllllllllllIIIlIIIlIlIllIIlIII.west());
            final IBlockState lllllllllllllIIIlIIIlIlIllIIIlIl = lllllllllllllIIIlIIIlIlIlIlllllI.getBlockState(lllllllllllllIIIlIIIlIlIllIIlIII.east());
            lllllllllllllIIIlIIIlIlIllIlIllI = EnumFacing.EAST;
            EnumFacing lllllllllllllIIIlIIIlIlIllIIIIlI = null;
            if (lllllllllllllIIIlIIIlIlIllIlllIl.getBlock() == this) {
                final EnumFacing lllllllllllllIIIlIIIlIlIllIIIlII = lllllllllllllIIIlIIIlIlIllIlllIl.getValue((IProperty<EnumFacing>)BlockChest.FACING);
            }
            else {
                lllllllllllllIIIlIIIlIlIllIIIIlI = lllllllllllllIIIlIIIlIlIllIllIll.getValue((IProperty<EnumFacing>)BlockChest.FACING);
            }
            if (lllllllllllllIIIlIIIlIlIllIIIIlI == EnumFacing.WEST) {
                lllllllllllllIIIlIIIlIlIllIlIllI = EnumFacing.WEST;
            }
            if ((lllllllllllllIIIlIIIlIlIllIllIlI.isFullBlock() || lllllllllllllIIIlIIIlIlIllIIIllI.isFullBlock()) && !lllllllllllllIIIlIIIlIlIllIllIII.isFullBlock() && !lllllllllllllIIIlIIIlIlIllIIIlIl.isFullBlock()) {
                lllllllllllllIIIlIIIlIlIllIlIllI = EnumFacing.EAST;
            }
            if ((lllllllllllllIIIlIIIlIlIllIllIII.isFullBlock() || lllllllllllllIIIlIIIlIlIllIIIlIl.isFullBlock()) && !lllllllllllllIIIlIIIlIlIllIllIlI.isFullBlock() && !lllllllllllllIIIlIIIlIlIllIIIllI.isFullBlock()) {
                lllllllllllllIIIlIIIlIlIllIlIllI = EnumFacing.WEST;
            }
        }
        lllllllllllllIIIlIIIlIlIlIlllIll = lllllllllllllIIIlIIIlIlIlIlllIll.withProperty((IProperty<Comparable>)BlockChest.FACING, lllllllllllllIIIlIIIlIlIllIlIllI);
        lllllllllllllIIIlIIIlIlIlIlllllI.setBlockState(lllllllllllllIIIlIIIlIlIlllIIIIl, lllllllllllllIIIlIIIlIlIlIlllIll, 3);
        return lllllllllllllIIIlIIIlIlIlIlllIll;
    }
    
    @Override
    public boolean func_190946_v(final IBlockState lllllllllllllIIIlIIIlIllIllIIllI) {
        return true;
    }
    
    @Override
    public int getWeakPower(final IBlockState lllllllllllllIIIlIIIlIIlllIIIIll, final IBlockAccess lllllllllllllIIIlIIIlIIlllIIlIII, final BlockPos lllllllllllllIIIlIIIlIIlllIIIIIl, final EnumFacing lllllllllllllIIIlIIIlIIlllIIIllI) {
        if (!lllllllllllllIIIlIIIlIIlllIIIIll.canProvidePower()) {
            return 0;
        }
        int lllllllllllllIIIlIIIlIIlllIIIlIl = 0;
        final TileEntity lllllllllllllIIIlIIIlIIlllIIIlII = lllllllllllllIIIlIIIlIIlllIIlIII.getTileEntity(lllllllllllllIIIlIIIlIIlllIIIIIl);
        if (lllllllllllllIIIlIIIlIIlllIIIlII instanceof TileEntityChest) {
            lllllllllllllIIIlIIIlIIlllIIIlIl = ((TileEntityChest)lllllllllllllIIIlIIIlIIlllIIIlII).numPlayersUsing;
        }
        return MathHelper.clamp(lllllllllllllIIIlIIIlIIlllIIIlIl, 0, 15);
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllIIIlIIIlIIlIlllllll) {
        EnumFacing lllllllllllllIIIlIIIlIIllIIIIIIl = EnumFacing.getFront(lllllllllllllIIIlIIIlIIlIlllllll);
        if (lllllllllllllIIIlIIIlIIllIIIIIIl.getAxis() == EnumFacing.Axis.Y) {
            lllllllllllllIIIlIIIlIIllIIIIIIl = EnumFacing.NORTH;
        }
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockChest.FACING, lllllllllllllIIIlIIIlIIllIIIIIIl);
    }
    
    @Override
    public void onBlockAdded(final World lllllllllllllIIIlIIIlIllIlIlIIII, final BlockPos lllllllllllllIIIlIIIlIllIlIIllll, final IBlockState lllllllllllllIIIlIIIlIllIlIIIlll) {
        this.checkForSurroundingChests(lllllllllllllIIIlIIIlIllIlIlIIII, lllllllllllllIIIlIIIlIllIlIIllll, lllllllllllllIIIlIIIlIllIlIIIlll);
        for (final EnumFacing lllllllllllllIIIlIIIlIllIlIIllIl : EnumFacing.Plane.HORIZONTAL) {
            final BlockPos lllllllllllllIIIlIIIlIllIlIIllII = lllllllllllllIIIlIIIlIllIlIIllll.offset(lllllllllllllIIIlIIIlIllIlIIllIl);
            final IBlockState lllllllllllllIIIlIIIlIllIlIIlIll = lllllllllllllIIIlIIIlIllIlIlIIII.getBlockState(lllllllllllllIIIlIIIlIllIlIIllII);
            if (lllllllllllllIIIlIIIlIllIlIIlIll.getBlock() == this) {
                this.checkForSurroundingChests(lllllllllllllIIIlIIIlIllIlIlIIII, lllllllllllllIIIlIIIlIllIlIIllII, lllllllllllllIIIlIIIlIllIlIIlIll);
            }
        }
    }
    
    @Override
    public EnumBlockRenderType getRenderType(final IBlockState lllllllllllllIIIlIIIlIllIllIIlII) {
        return EnumBlockRenderType.ENTITYBLOCK_ANIMATED;
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllllIIIlIIIlIllIllIlIlI) {
        return false;
    }
    
    private boolean isDoubleChest(final World lllllllllllllIIIlIIIlIlIIIllllII, final BlockPos lllllllllllllIIIlIIIlIlIIIlllIll) {
        if (lllllllllllllIIIlIIIlIlIIIllllII.getBlockState(lllllllllllllIIIlIIIlIlIIIlllIll).getBlock() != this) {
            return false;
        }
        for (final EnumFacing lllllllllllllIIIlIIIlIlIIIlllllI : EnumFacing.Plane.HORIZONTAL) {
            if (lllllllllllllIIIlIIIlIlIIIllllII.getBlockState(lllllllllllllIIIlIIIlIlIIIlllIll.offset(lllllllllllllIIIlIIIlIlIIIlllllI)).getBlock() == this) {
                return true;
            }
        }
        return false;
    }
    
    private boolean isOcelotSittingOnChest(final World lllllllllllllIIIlIIIlIIllIIlIlll, final BlockPos lllllllllllllIIIlIIIlIIllIIllIlI) {
        for (final Entity lllllllllllllIIIlIIIlIIllIIllIIl : lllllllllllllIIIlIIIlIIllIIlIlll.getEntitiesWithinAABB((Class<? extends Entity>)EntityOcelot.class, new AxisAlignedBB(lllllllllllllIIIlIIIlIIllIIllIlI.getX(), lllllllllllllIIIlIIIlIIllIIllIlI.getY() + 1, lllllllllllllIIIlIIIlIIllIIllIlI.getZ(), lllllllllllllIIIlIIIlIIllIIllIlI.getX() + 1, lllllllllllllIIIlIIIlIIllIIllIlI.getY() + 2, lllllllllllllIIIlIIIlIIllIIllIlI.getZ() + 1))) {
            final EntityOcelot lllllllllllllIIIlIIIlIIllIIllIII = (EntityOcelot)lllllllllllllIIIlIIIlIIllIIllIIl;
            if (lllllllllllllIIIlIIIlIIllIIllIII.isSitting()) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean canProvidePower(final IBlockState lllllllllllllIIIlIIIlIIlllIlIIIl) {
        return this.chestType == Type.TRAP;
    }
    
    @Override
    public boolean hasComparatorInputOverride(final IBlockState lllllllllllllIIIlIIIlIIllIIlIIIl) {
        return true;
    }
    
    @Nullable
    public ILockableContainer getLockableContainer(final World lllllllllllllIIIlIIIlIIllllllIII, final BlockPos lllllllllllllIIIlIIIlIIllllllIlI) {
        return this.getContainer(lllllllllllllIIIlIIIlIIllllllIII, lllllllllllllIIIlIIIlIIllllllIlI, false);
    }
    
    @Override
    public IBlockState withRotation(final IBlockState lllllllllllllIIIlIIIlIIlIlllIlII, final Rotation lllllllllllllIIIlIIIlIIlIlllIIll) {
        return lllllllllllllIIIlIIIlIIlIlllIlII.withProperty((IProperty<Comparable>)BlockChest.FACING, lllllllllllllIIIlIIIlIIlIlllIIll.rotate(lllllllllllllIIIlIIIlIIlIlllIlII.getValue((IProperty<EnumFacing>)BlockChest.FACING)));
    }
    
    @Override
    public void breakBlock(final World lllllllllllllIIIlIIIlIlIIIIllIII, final BlockPos lllllllllllllIIIlIIIlIlIIIIlllII, final IBlockState lllllllllllllIIIlIIIlIlIIIIlIllI) {
        final TileEntity lllllllllllllIIIlIIIlIlIIIIllIlI = lllllllllllllIIIlIIIlIlIIIIllIII.getTileEntity(lllllllllllllIIIlIIIlIlIIIIlllII);
        if (lllllllllllllIIIlIIIlIlIIIIllIlI instanceof IInventory) {
            InventoryHelper.dropInventoryItems(lllllllllllllIIIlIIIlIlIIIIllIII, lllllllllllllIIIlIIIlIlIIIIlllII, (IInventory)lllllllllllllIIIlIIIlIlIIIIllIlI);
            lllllllllllllIIIlIIIlIlIIIIllIII.updateComparatorOutputLevel(lllllllllllllIIIlIIIlIlIIIIlllII, this);
        }
        super.breakBlock(lllllllllllllIIIlIIIlIlIIIIllIII, lllllllllllllIIIlIIIlIlIIIIlllII, lllllllllllllIIIlIIIlIlIIIIlIllI);
    }
    
    @Override
    public IBlockState onBlockPlaced(final World lllllllllllllIIIlIIIlIllIIllllll, final BlockPos lllllllllllllIIIlIIIlIllIIlllllI, final EnumFacing lllllllllllllIIIlIIIlIllIIllllIl, final float lllllllllllllIIIlIIIlIllIIllllII, final float lllllllllllllIIIlIIIlIllIIlllIll, final float lllllllllllllIIIlIIIlIllIIlllIlI, final int lllllllllllllIIIlIIIlIllIIlllIIl, final EntityLivingBase lllllllllllllIIIlIIIlIllIIlllIII) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockChest.FACING, lllllllllllllIIIlIIIlIllIIlllIII.getHorizontalFacing());
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllllIIIlIIIlIllIllIlIII) {
        return false;
    }
    
    @Override
    public boolean canPlaceBlockAt(final World lllllllllllllIIIlIIIlIlIIlIlllIl, final BlockPos lllllllllllllIIIlIIIlIlIIlIllIll) {
        int lllllllllllllIIIlIIIlIlIIllIIlll = 0;
        final BlockPos lllllllllllllIIIlIIIlIlIIllIIlIl = lllllllllllllIIIlIIIlIlIIlIllIll.west();
        final BlockPos lllllllllllllIIIlIIIlIlIIllIIIll = lllllllllllllIIIlIIIlIlIIlIllIll.east();
        final BlockPos lllllllllllllIIIlIIIlIlIIllIIIlI = lllllllllllllIIIlIIIlIlIIlIllIll.north();
        final BlockPos lllllllllllllIIIlIIIlIlIIllIIIIl = lllllllllllllIIIlIIIlIlIIlIllIll.south();
        if (lllllllllllllIIIlIIIlIlIIlIlllIl.getBlockState(lllllllllllllIIIlIIIlIlIIllIIlIl).getBlock() == this) {
            if (this.isDoubleChest(lllllllllllllIIIlIIIlIlIIlIlllIl, lllllllllllllIIIlIIIlIlIIllIIlIl)) {
                return false;
            }
            ++lllllllllllllIIIlIIIlIlIIllIIlll;
        }
        if (lllllllllllllIIIlIIIlIlIIlIlllIl.getBlockState(lllllllllllllIIIlIIIlIlIIllIIIll).getBlock() == this) {
            if (this.isDoubleChest(lllllllllllllIIIlIIIlIlIIlIlllIl, lllllllllllllIIIlIIIlIlIIllIIIll)) {
                return false;
            }
            ++lllllllllllllIIIlIIIlIlIIllIIlll;
        }
        if (lllllllllllllIIIlIIIlIlIIlIlllIl.getBlockState(lllllllllllllIIIlIIIlIlIIllIIIlI).getBlock() == this) {
            if (this.isDoubleChest(lllllllllllllIIIlIIIlIlIIlIlllIl, lllllllllllllIIIlIIIlIlIIllIIIlI)) {
                return false;
            }
            ++lllllllllllllIIIlIIIlIlIIllIIlll;
        }
        if (lllllllllllllIIIlIIIlIlIIlIlllIl.getBlockState(lllllllllllllIIIlIIIlIlIIllIIIIl).getBlock() == this) {
            if (this.isDoubleChest(lllllllllllllIIIlIIIlIlIIlIlllIl, lllllllllllllIIIlIIIlIlIIllIIIIl)) {
                return false;
            }
            ++lllllllllllllIIIlIIIlIlIIllIIlll;
        }
        return lllllllllllllIIIlIIIlIlIIllIIlll <= 1;
    }
    
    static {
        FACING = BlockHorizontal.FACING;
        NORTH_CHEST_AABB = new AxisAlignedBB(0.0625, 0.0, 0.0, 0.9375, 0.875, 0.9375);
        SOUTH_CHEST_AABB = new AxisAlignedBB(0.0625, 0.0, 0.0625, 0.9375, 0.875, 1.0);
        WEST_CHEST_AABB = new AxisAlignedBB(0.0, 0.0, 0.0625, 0.9375, 0.875, 0.9375);
        EAST_CHEST_AABB = new AxisAlignedBB(0.0625, 0.0, 0.0625, 1.0, 0.875, 0.9375);
        NOT_CONNECTED_AABB = new AxisAlignedBB(0.0625, 0.0, 0.0625, 0.9375, 0.875, 0.9375);
    }
    
    private boolean isBlocked(final World lllllllllllllIIIlIIIlIIllIlIlIlI, final BlockPos lllllllllllllIIIlIIIlIIllIlIlIIl) {
        return this.isBelowSolidBlock(lllllllllllllIIIlIIIlIIllIlIlIlI, lllllllllllllIIIlIIIlIIllIlIlIIl) || this.isOcelotSittingOnChest(lllllllllllllIIIlIIIlIIllIlIlIlI, lllllllllllllIIIlIIIlIIllIlIlIIl);
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllllIIIlIIIlIIlIllIIlll, final IBlockState lllllllllllllIIIlIIIlIIlIllIIllI, final BlockPos lllllllllllllIIIlIIIlIIlIllIIlIl, final EnumFacing lllllllllllllIIIlIIIlIIlIllIIlII) {
        return BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public IBlockState withMirror(final IBlockState lllllllllllllIIIlIIIlIIlIllIllIl, final Mirror lllllllllllllIIIlIIIlIIlIllIllII) {
        return lllllllllllllIIIlIIIlIIlIllIllIl.withRotation(lllllllllllllIIIlIIIlIIlIllIllII.toRotation(lllllllllllllIIIlIIIlIIlIllIllIl.getValue((IProperty<EnumFacing>)BlockChest.FACING)));
    }
    
    @Override
    public TileEntity createNewTileEntity(final World lllllllllllllIIIlIIIlIIlllIlIlIl, final int lllllllllllllIIIlIIIlIIlllIlIlII) {
        return new TileEntityChest();
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllllIIIlIIIlIllIlIlllll, final IBlockAccess lllllllllllllIIIlIIIlIllIlIllIll, final BlockPos lllllllllllllIIIlIIIlIllIlIllIlI) {
        if (lllllllllllllIIIlIIIlIllIlIllIll.getBlockState(lllllllllllllIIIlIIIlIllIlIllIlI.north()).getBlock() == this) {
            return BlockChest.NORTH_CHEST_AABB;
        }
        if (lllllllllllllIIIlIIIlIllIlIllIll.getBlockState(lllllllllllllIIIlIIIlIllIlIllIlI.south()).getBlock() == this) {
            return BlockChest.SOUTH_CHEST_AABB;
        }
        if (lllllllllllllIIIlIIIlIllIlIllIll.getBlockState(lllllllllllllIIIlIIIlIllIlIllIlI.west()).getBlock() == this) {
            return BlockChest.WEST_CHEST_AABB;
        }
        return (lllllllllllllIIIlIIIlIllIlIllIll.getBlockState(lllllllllllllIIIlIIIlIllIlIllIlI.east()).getBlock() == this) ? BlockChest.EAST_CHEST_AABB : BlockChest.NOT_CONNECTED_AABB;
    }
    
    @Override
    public void neighborChanged(final IBlockState lllllllllllllIIIlIIIlIlIIIllIIII, final World lllllllllllllIIIlIIIlIlIIIlIllll, final BlockPos lllllllllllllIIIlIIIlIlIIIlIlllI, final Block lllllllllllllIIIlIIIlIlIIIlIllIl, final BlockPos lllllllllllllIIIlIIIlIlIIIlIllII) {
        super.neighborChanged(lllllllllllllIIIlIIIlIlIIIllIIII, lllllllllllllIIIlIIIlIlIIIlIllll, lllllllllllllIIIlIIIlIlIIIlIlllI, lllllllllllllIIIlIIIlIlIIIlIllIl, lllllllllllllIIIlIIIlIlIIIlIllII);
        final TileEntity lllllllllllllIIIlIIIlIlIIIlIlIll = lllllllllllllIIIlIIIlIlIIIlIllll.getTileEntity(lllllllllllllIIIlIIIlIlIIIlIlllI);
        if (lllllllllllllIIIlIIIlIlIIIlIlIll instanceof TileEntityChest) {
            lllllllllllllIIIlIIIlIlIIIlIlIll.updateContainingBlockInfo();
        }
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockChest.FACING });
    }
    
    public enum Type
    {
        BASIC("BASIC", 0), 
        TRAP("TRAP", 1);
        
        private Type(final String llllllllllllIlllllIllllIIllIllII, final int llllllllllllIlllllIllllIIllIlIll) {
        }
    }
}
