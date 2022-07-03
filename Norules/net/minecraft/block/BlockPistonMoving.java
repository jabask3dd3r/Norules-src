package net.minecraft.block;

import net.minecraft.block.properties.*;
import javax.annotation.*;
import net.minecraft.tileentity.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.math.*;
import net.minecraft.block.state.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import net.minecraft.block.material.*;
import java.util.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public class BlockPistonMoving extends BlockContainer
{
    public static final /* synthetic */ PropertyDirection FACING;
    public static final /* synthetic */ PropertyEnum<BlockPistonExtension.EnumPistonType> TYPE;
    
    @Override
    public ItemStack getItem(final World lllllllllllllIlIIIllIIlIlIlIlIlI, final BlockPos lllllllllllllIlIIIllIIlIlIlIlIIl, final IBlockState lllllllllllllIlIIIllIIlIlIlIlIII) {
        return ItemStack.field_190927_a;
    }
    
    @Override
    public void neighborChanged(final IBlockState lllllllllllllIlIIIllIIlIlllIllIl, final World lllllllllllllIlIIIllIIlIlllIllII, final BlockPos lllllllllllllIlIIIllIIlIlllIIlll, final Block lllllllllllllIlIIIllIIlIlllIlIlI, final BlockPos lllllllllllllIlIIIllIIlIlllIlIIl) {
        if (!lllllllllllllIlIIIllIIlIlllIllII.isRemote) {
            lllllllllllllIlIIIllIIlIlllIllII.getTileEntity(lllllllllllllIlIIIllIIlIlllIIlll);
        }
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllIlIIIllIIlIlIIlIIII) {
        int lllllllllllllIlIIIllIIlIlIIIllll = 0;
        lllllllllllllIlIIIllIIlIlIIIllll |= lllllllllllllIlIIIllIIlIlIIlIIII.getValue((IProperty<EnumFacing>)BlockPistonMoving.FACING).getIndex();
        if (lllllllllllllIlIIIllIIlIlIIlIIII.getValue(BlockPistonMoving.TYPE) == BlockPistonExtension.EnumPistonType.STICKY) {
            lllllllllllllIlIIIllIIlIlIIIllll |= 0x8;
        }
        return lllllllllllllIlIIIllIIlIlIIIllll;
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllllIlIIIllIIllIIlIlIIl) {
        return false;
    }
    
    static {
        FACING = BlockPistonExtension.FACING;
        TYPE = BlockPistonExtension.TYPE;
    }
    
    @Nullable
    @Override
    public RayTraceResult collisionRayTrace(final IBlockState lllllllllllllIlIIIllIIlIllllIlIl, final World lllllllllllllIlIIIllIIlIllllIlII, final BlockPos lllllllllllllIlIIIllIIlIllllIIll, final Vec3d lllllllllllllIlIIIllIIlIllllIIlI, final Vec3d lllllllllllllIlIIIllIIlIllllIIIl) {
        return null;
    }
    
    @Override
    public void breakBlock(final World lllllllllllllIlIIIllIIllIllIIlIl, final BlockPos lllllllllllllIlIIIllIIllIllIIIll, final IBlockState lllllllllllllIlIIIllIIllIllIIIIl) {
        final TileEntity lllllllllllllIlIIIllIIllIlIlllll = lllllllllllllIlIIIllIIllIllIIlIl.getTileEntity(lllllllllllllIlIIIllIIllIllIIIll);
        if (lllllllllllllIlIIIllIIllIlIlllll instanceof TileEntityPiston) {
            ((TileEntityPiston)lllllllllllllIlIIIllIIllIlIlllll).clearPistonTileEntity();
        }
        else {
            super.breakBlock(lllllllllllllIlIIIllIIllIllIIlIl, lllllllllllllIlIIIllIIllIllIIIll, lllllllllllllIlIIIllIIllIllIIIIl);
        }
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllllIlIIIllIIlIlIIIlIII, final IBlockState lllllllllllllIlIIIllIIlIlIIIIlll, final BlockPos lllllllllllllIlIIIllIIlIlIIIIllI, final EnumFacing lllllllllllllIlIIIllIIlIlIIIIlIl) {
        return BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public void onBlockDestroyedByPlayer(final World lllllllllllllIlIIIllIIllIIllIllI, final BlockPos lllllllllllllIlIIIllIIllIIlllllI, final IBlockState lllllllllllllIlIIIllIIllIIllIIlI) {
        final BlockPos lllllllllllllIlIIIllIIllIIlllIlI = lllllllllllllIlIIIllIIllIIlllllI.offset(lllllllllllllIlIIIllIIllIIllIIlI.getValue((IProperty<EnumFacing>)BlockPistonMoving.FACING).getOpposite());
        final IBlockState lllllllllllllIlIIIllIIllIIlllIII = lllllllllllllIlIIIllIIllIIllIllI.getBlockState(lllllllllllllIlIIIllIIllIIlllIlI);
        if (lllllllllllllIlIIIllIIllIIlllIII.getBlock() instanceof BlockPistonBase && lllllllllllllIlIIIllIIllIIlllIII.getValue((IProperty<Boolean>)BlockPistonBase.EXTENDED)) {
            lllllllllllllIlIIIllIIllIIllIllI.setBlockToAir(lllllllllllllIlIIIllIIllIIlllIlI);
        }
    }
    
    @Override
    public IBlockState withMirror(final IBlockState lllllllllllllIlIIIllIIlIlIIlIlll, final Mirror lllllllllllllIlIIIllIIlIlIIlIllI) {
        return lllllllllllllIlIIIllIIlIlIIlIlll.withRotation(lllllllllllllIlIIIllIIlIlIIlIllI.toRotation(lllllllllllllIlIIIllIIlIlIIlIlll.getValue((IProperty<EnumFacing>)BlockPistonMoving.FACING)));
    }
    
    @Nullable
    @Override
    public TileEntity createNewTileEntity(final World lllllllllllllIlIIIllIIlllIIIlIIl, final int lllllllllllllIlIIIllIIlllIIIIlll) {
        return null;
    }
    
    @Override
    public boolean onBlockActivated(final World lllllllllllllIlIIIllIIllIIIlIlII, final BlockPos lllllllllllllIlIIIllIIllIIIlIIlI, final IBlockState lllllllllllllIlIIIllIIllIIIlllIl, final EntityPlayer lllllllllllllIlIIIllIIllIIIlllII, final EnumHand lllllllllllllIlIIIllIIllIIIllIll, final EnumFacing lllllllllllllIlIIIllIIllIIIllIlI, final float lllllllllllllIlIIIllIIllIIIllIII, final float lllllllllllllIlIIIllIIllIIIlIllI, final float lllllllllllllIlIIIllIIllIIIlIlIl) {
        if (!lllllllllllllIlIIIllIIllIIIlIlII.isRemote && lllllllllllllIlIIIllIIllIIIlIlII.getTileEntity(lllllllllllllIlIIIllIIllIIIlIIlI) == null) {
            lllllllllllllIlIIIllIIllIIIlIlII.setBlockToAir(lllllllllllllIlIIIllIIllIIIlIIlI);
            return true;
        }
        return false;
    }
    
    @Override
    public boolean canPlaceBlockOnSide(final World lllllllllllllIlIIIllIIllIlIlIIll, final BlockPos lllllllllllllIlIIIllIIllIlIlIIlI, final EnumFacing lllllllllllllIlIIIllIIllIlIlIIIl) {
        return false;
    }
    
    @Override
    public boolean canPlaceBlockAt(final World lllllllllllllIlIIIllIIllIlIlIllI, final BlockPos lllllllllllllIlIIIllIIllIlIlIlIl) {
        return false;
    }
    
    @Nullable
    private TileEntityPiston getTilePistonAt(final IBlockAccess lllllllllllllIlIIIllIIlIlIllIIIl, final BlockPos lllllllllllllIlIIIllIIlIlIlIllIl) {
        final TileEntity lllllllllllllIlIIIllIIlIlIlIllll = lllllllllllllIlIIIllIIlIlIllIIIl.getTileEntity(lllllllllllllIlIIIllIIlIlIlIllIl);
        return (lllllllllllllIlIIIllIIlIlIlIllll instanceof TileEntityPiston) ? ((TileEntityPiston)lllllllllllllIlIIIllIIlIlIlIllll) : null;
    }
    
    public static TileEntity createTilePiston(final IBlockState lllllllllllllIlIIIllIIllIllllIll, final EnumFacing lllllllllllllIlIIIllIIllIlllIllI, final boolean lllllllllllllIlIIIllIIllIlllIlIl, final boolean lllllllllllllIlIIIllIIllIllllIII) {
        return new TileEntityPiston(lllllllllllllIlIIIllIIllIllllIll, lllllllllllllIlIIIllIIllIlllIllI, lllllllllllllIlIIIllIIllIlllIlIl, lllllllllllllIlIIIllIIllIllllIII);
    }
    
    @Override
    public void dropBlockAsItemWithChance(final World lllllllllllllIlIIIllIIlIlllllIlI, final BlockPos lllllllllllllIlIIIllIIllIIIIIIIl, final IBlockState lllllllllllllIlIIIllIIllIIIIIIII, final float lllllllllllllIlIIIllIIlIllllllll, final int lllllllllllllIlIIIllIIlIlllllllI) {
        if (!lllllllllllllIlIIIllIIlIlllllIlI.isRemote) {
            final TileEntityPiston lllllllllllllIlIIIllIIlIllllllIl = this.getTilePistonAt(lllllllllllllIlIIIllIIlIlllllIlI, lllllllllllllIlIIIllIIllIIIIIIIl);
            if (lllllllllllllIlIIIllIIlIllllllIl != null) {
                final IBlockState lllllllllllllIlIIIllIIlIllllllII = lllllllllllllIlIIIllIIlIllllllIl.getPistonState();
                lllllllllllllIlIIIllIIlIllllllII.getBlock().dropBlockAsItem(lllllllllllllIlIIIllIIlIlllllIlI, lllllllllllllIlIIIllIIllIIIIIIIl, lllllllllllllIlIIIllIIlIllllllII, 0);
            }
        }
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllllIlIIIllIIlIlIllllIl, final IBlockAccess lllllllllllllIlIIIllIIlIlIlllIII, final BlockPos lllllllllllllIlIIIllIIlIlIlllIll) {
        final TileEntityPiston lllllllllllllIlIIIllIIlIlIlllIlI = this.getTilePistonAt(lllllllllllllIlIIIllIIlIlIlllIII, lllllllllllllIlIIIllIIlIlIlllIll);
        return (lllllllllllllIlIIIllIIlIlIlllIlI != null) ? lllllllllllllIlIIIllIIlIlIlllIlI.getAABB(lllllllllllllIlIIIllIIlIlIlllIII, lllllllllllllIlIIIllIIlIlIlllIll) : BlockPistonMoving.FULL_BLOCK_AABB;
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockPistonMoving.FACING, BlockPistonMoving.TYPE });
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllllIlIIIllIIllIIIIlllI, final Random lllllllllllllIlIIIllIIllIIIIllII, final int lllllllllllllIlIIIllIIllIIIIlIll) {
        return Items.field_190931_a;
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllllIlIIIllIIllIIlIIllI) {
        return false;
    }
    
    public BlockPistonMoving() {
        super(Material.PISTON);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockPistonMoving.FACING, EnumFacing.NORTH).withProperty(BlockPistonMoving.TYPE, BlockPistonExtension.EnumPistonType.DEFAULT));
        this.setHardness(-1.0f);
    }
    
    @Override
    public void addCollisionBoxToList(final IBlockState lllllllllllllIlIIIllIIlIllIlIIIl, final World lllllllllllllIlIIIllIIlIllIlIIII, final BlockPos lllllllllllllIlIIIllIIlIllIIllll, final AxisAlignedBB lllllllllllllIlIIIllIIlIllIIlllI, final List<AxisAlignedBB> lllllllllllllIlIIIllIIlIllIIllIl, @Nullable final Entity lllllllllllllIlIIIllIIlIllIIIlII, final boolean lllllllllllllIlIIIllIIlIllIIlIll) {
        final TileEntityPiston lllllllllllllIlIIIllIIlIllIIlIlI = this.getTilePistonAt(lllllllllllllIlIIIllIIlIllIlIIII, lllllllllllllIlIIIllIIlIllIIllll);
        if (lllllllllllllIlIIIllIIlIllIIlIlI != null) {
            lllllllllllllIlIIIllIIlIllIIlIlI.func_190609_a(lllllllllllllIlIIIllIIlIllIlIIII, lllllllllllllIlIIIllIIlIllIIllll, lllllllllllllIlIIIllIIlIllIIlllI, lllllllllllllIlIIIllIIlIllIIllIl, lllllllllllllIlIIIllIIlIllIIIlII);
        }
    }
    
    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final IBlockState lllllllllllllIlIIIllIIlIlllIIIIl, final IBlockAccess lllllllllllllIlIIIllIIlIllIlllII, final BlockPos lllllllllllllIlIIIllIIlIllIlllll) {
        final TileEntityPiston lllllllllllllIlIIIllIIlIllIllllI = this.getTilePistonAt(lllllllllllllIlIIIllIIlIllIlllII, lllllllllllllIlIIIllIIlIllIlllll);
        return (lllllllllllllIlIIIllIIlIllIllllI == null) ? null : lllllllllllllIlIIIllIIlIllIllllI.getAABB(lllllllllllllIlIIIllIIlIllIlllII, lllllllllllllIlIIIllIIlIllIlllll);
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllIlIIIllIIlIlIlIIlII) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockPistonMoving.FACING, BlockPistonExtension.getFacing(lllllllllllllIlIIIllIIlIlIlIIlII)).withProperty(BlockPistonMoving.TYPE, ((lllllllllllllIlIIIllIIlIlIlIIlII & 0x8) > 0) ? BlockPistonExtension.EnumPistonType.STICKY : BlockPistonExtension.EnumPistonType.DEFAULT);
    }
    
    @Override
    public IBlockState withRotation(final IBlockState lllllllllllllIlIIIllIIlIlIIlllII, final Rotation lllllllllllllIlIIIllIIlIlIIllIll) {
        return lllllllllllllIlIIIllIIlIlIIlllII.withProperty((IProperty<Comparable>)BlockPistonMoving.FACING, lllllllllllllIlIIIllIIlIlIIllIll.rotate(lllllllllllllIlIIIllIIlIlIIlllII.getValue((IProperty<EnumFacing>)BlockPistonMoving.FACING)));
    }
}
