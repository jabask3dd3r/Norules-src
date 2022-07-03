package net.minecraft.block;

import net.minecraft.util.math.*;
import net.minecraft.tileentity.*;
import net.minecraft.block.material.*;
import net.minecraft.world.*;
import net.minecraft.util.text.translation.*;
import java.util.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import net.minecraft.entity.player.*;
import javax.annotation.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;
import net.minecraft.util.*;

public class BlockBanner extends BlockContainer
{
    public static final /* synthetic */ PropertyInteger ROTATION;
    protected static final /* synthetic */ AxisAlignedBB STANDING_AABB;
    public static final /* synthetic */ PropertyDirection FACING;
    
    private ItemStack getTileDataItemStack(final World llllllllllllllIIIllIIIIlllIlIIll, final BlockPos llllllllllllllIIIllIIIIlllIlIIlI) {
        final TileEntity llllllllllllllIIIllIIIIlllIlIlII = llllllllllllllIIIllIIIIlllIlIIll.getTileEntity(llllllllllllllIIIllIIIIlllIlIIlI);
        return (llllllllllllllIIIllIIIIlllIlIlII instanceof TileEntityBanner) ? ((TileEntityBanner)llllllllllllllIIIllIIIIlllIlIlII).func_190615_l() : ItemStack.field_190927_a;
    }
    
    protected BlockBanner() {
        super(Material.WOOD);
    }
    
    static {
        FACING = BlockHorizontal.FACING;
        ROTATION = PropertyInteger.create("rotation", 0, 15);
        STANDING_AABB = new AxisAlignedBB(0.25, 0.0, 0.25, 0.75, 1.0, 0.75);
    }
    
    @Override
    public boolean isPassable(final IBlockAccess llllllllllllllIIIllIIIIllllIIllI, final BlockPos llllllllllllllIIIllIIIIllllIIlIl) {
        return true;
    }
    
    @Override
    public String getLocalizedName() {
        return I18n.translateToLocal("item.banner.white.name");
    }
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllllllIIIllIIIIlllIlllIl, final Random llllllllllllllIIIllIIIIlllIlllII, final int llllllllllllllIIIllIIIIlllIllIll) {
        return Items.BANNER;
    }
    
    @Override
    public TileEntity createNewTileEntity(final World llllllllllllllIIIllIIIIllllIIIII, final int llllllllllllllIIIllIIIIlllIlllll) {
        return new TileEntityBanner();
    }
    
    @Override
    public void harvestBlock(final World llllllllllllllIIIllIIIIllIIllIll, final EntityPlayer llllllllllllllIIIllIIIIllIIllIlI, final BlockPos llllllllllllllIIIllIIIIllIIllIIl, final IBlockState llllllllllllllIIIllIIIIllIIIllll, @Nullable final TileEntity llllllllllllllIIIllIIIIllIIlIlll, final ItemStack llllllllllllllIIIllIIIIllIIlIllI) {
        if (llllllllllllllIIIllIIIIllIIlIlll instanceof TileEntityBanner) {
            final TileEntityBanner llllllllllllllIIIllIIIIllIIlIlIl = (TileEntityBanner)llllllllllllllIIIllIIIIllIIlIlll;
            final ItemStack llllllllllllllIIIllIIIIllIIlIlII = llllllllllllllIIIllIIIIllIIlIlIl.func_190615_l();
            Block.spawnAsEntity(llllllllllllllIIIllIIIIllIIllIll, llllllllllllllIIIllIIIIllIIllIIl, llllllllllllllIIIllIIIIllIIlIlII);
        }
        else {
            super.harvestBlock(llllllllllllllIIIllIIIIllIIllIll, llllllllllllllIIIllIIIIllIIllIlI, llllllllllllllIIIllIIIIllIIllIIl, llllllllllllllIIIllIIIIllIIIllll, null, llllllllllllllIIIllIIIIllIIlIllI);
        }
    }
    
    @Override
    public boolean isFullCube(final IBlockState llllllllllllllIIIllIIIIllllIlIII) {
        return false;
    }
    
    @Override
    public boolean canSpawnInBlock() {
        return true;
    }
    
    @Override
    public boolean canPlaceBlockAt(final World llllllllllllllIIIllIIIIllIlIlIlI, final BlockPos llllllllllllllIIIllIIIIllIlIlIIl) {
        return !this.hasInvalidNeighbor(llllllllllllllIIIllIIIIllIlIlIlI, llllllllllllllIIIllIIIIllIlIlIIl) && super.canPlaceBlockAt(llllllllllllllIIIllIIIIllIlIlIlI, llllllllllllllIIIllIIIIllIlIlIIl);
    }
    
    @Override
    public void dropBlockAsItemWithChance(final World llllllllllllllIIIllIIIIllIllIlII, final BlockPos llllllllllllllIIIllIIIIllIlllIlI, final IBlockState llllllllllllllIIIllIIIIllIllIIlI, final float llllllllllllllIIIllIIIIllIllIIIl, final int llllllllllllllIIIllIIIIllIllIlll) {
        final ItemStack llllllllllllllIIIllIIIIllIllIllI = this.getTileDataItemStack(llllllllllllllIIIllIIIIllIllIlII, llllllllllllllIIIllIIIIllIlllIlI);
        if (llllllllllllllIIIllIIIIllIllIllI.func_190926_b()) {
            super.dropBlockAsItemWithChance(llllllllllllllIIIllIIIIllIllIlII, llllllllllllllIIIllIIIIllIlllIlI, llllllllllllllIIIllIIIIllIllIIlI, llllllllllllllIIIllIIIIllIllIIIl, llllllllllllllIIIllIIIIllIllIlll);
        }
        else {
            Block.spawnAsEntity(llllllllllllllIIIllIIIIllIllIlII, llllllllllllllIIIllIIIIllIlllIlI, llllllllllllllIIIllIIIIllIllIllI);
        }
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState llllllllllllllIIIllIIIIllllIIIll) {
        return false;
    }
    
    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final IBlockState llllllllllllllIIIllIIIIllllIllII, final IBlockAccess llllllllllllllIIIllIIIIllllIlIll, final BlockPos llllllllllllllIIIllIIIIllllIlIlI) {
        return BlockBanner.NULL_AABB;
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess llllllllllllllIIIllIIIIllIIIlIIl, final IBlockState llllllllllllllIIIllIIIIllIIIlIII, final BlockPos llllllllllllllIIIllIIIIllIIIIlll, final EnumFacing llllllllllllllIIIllIIIIllIIIIllI) {
        return BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public ItemStack getItem(final World llllllllllllllIIIllIIIIlllIIlIll, final BlockPos llllllllllllllIIIllIIIIlllIIIlIl, final IBlockState llllllllllllllIIIllIIIIlllIIlIIl) {
        final ItemStack llllllllllllllIIIllIIIIlllIIlIII = this.getTileDataItemStack(llllllllllllllIIIllIIIIlllIIlIll, llllllllllllllIIIllIIIIlllIIIlIl);
        return llllllllllllllIIIllIIIIlllIIlIII.func_190926_b() ? new ItemStack(Items.BANNER) : llllllllllllllIIIllIIIIlllIIlIII;
    }
    
    public static class BlockBannerStanding extends BlockBanner
    {
        @Override
        public IBlockState withMirror(final IBlockState lllllllllllllIIlIIIllIllIlIlllll, final Mirror lllllllllllllIIlIIIllIllIlIlllII) {
            return lllllllllllllIIlIIIllIllIlIlllll.withProperty((IProperty<Comparable>)BlockBannerStanding.ROTATION, lllllllllllllIIlIIIllIllIlIlllII.mirrorRotation(lllllllllllllIIlIIIllIllIlIlllll.getValue((IProperty<Integer>)BlockBannerStanding.ROTATION), 16));
        }
        
        @Override
        public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllllIIlIIIllIllIllIllII, final IBlockAccess lllllllllllllIIlIIIllIllIllIlIll, final BlockPos lllllllllllllIIlIIIllIllIllIlIlI) {
            return BlockBannerStanding.STANDING_AABB;
        }
        
        @Override
        public int getMetaFromState(final IBlockState lllllllllllllIIlIIIllIllIIlIlIIl) {
            return lllllllllllllIIlIIIllIllIIlIlIIl.getValue((IProperty<Integer>)BlockBannerStanding.ROTATION);
        }
        
        @Override
        protected BlockStateContainer createBlockState() {
            return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockBannerStanding.ROTATION });
        }
        
        @Override
        public IBlockState withRotation(final IBlockState lllllllllllllIIlIIIllIllIllIIllI, final Rotation lllllllllllllIIlIIIllIllIllIIIll) {
            return lllllllllllllIIlIIIllIllIllIIllI.withProperty((IProperty<Comparable>)BlockBannerStanding.ROTATION, lllllllllllllIIlIIIllIllIllIIIll.rotate(lllllllllllllIIlIIIllIllIllIIllI.getValue((IProperty<Integer>)BlockBannerStanding.ROTATION), 16));
        }
        
        @Override
        public void neighborChanged(final IBlockState lllllllllllllIIlIIIllIllIlIIIlll, final World lllllllllllllIIlIIIllIllIlIIIlIl, final BlockPos lllllllllllllIIlIIIllIllIlIIIIll, final Block lllllllllllllIIlIIIllIllIlIIIIlI, final BlockPos lllllllllllllIIlIIIllIllIlIIIIIl) {
            if (!lllllllllllllIIlIIIllIllIlIIIlIl.getBlockState(lllllllllllllIIlIIIllIllIlIIIIll.down()).getMaterial().isSolid()) {
                this.dropBlockAsItem(lllllllllllllIIlIIIllIllIlIIIlIl, lllllllllllllIIlIIIllIllIlIIIIll, lllllllllllllIIlIIIllIllIlIIIlll, 0);
                lllllllllllllIIlIIIllIllIlIIIlIl.setBlockToAir(lllllllllllllIIlIIIllIllIlIIIIll);
            }
            super.neighborChanged(lllllllllllllIIlIIIllIllIlIIIlll, lllllllllllllIIlIIIllIllIlIIIlIl, lllllllllllllIIlIIIllIllIlIIIIll, lllllllllllllIIlIIIllIllIlIIIIlI, lllllllllllllIIlIIIllIllIlIIIIIl);
        }
        
        public BlockBannerStanding() {
            this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockBannerStanding.ROTATION, 0));
        }
        
        @Override
        public IBlockState getStateFromMeta(final int lllllllllllllIIlIIIllIllIIllIlll) {
            return this.getDefaultState().withProperty((IProperty<Comparable>)BlockBannerStanding.ROTATION, lllllllllllllIIlIIIllIllIIllIlll);
        }
    }
    
    public static class BlockBannerHanging extends BlockBanner
    {
        private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing;
        protected static final /* synthetic */ AxisAlignedBB EAST_AABB;
        protected static final /* synthetic */ AxisAlignedBB SOUTH_AABB;
        protected static final /* synthetic */ AxisAlignedBB NORTH_AABB;
        protected static final /* synthetic */ AxisAlignedBB WEST_AABB;
        
        public BlockBannerHanging() {
            this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockBannerHanging.FACING, EnumFacing.NORTH));
        }
        
        @Override
        public void neighborChanged(final IBlockState lllllllllllllIlIIlllIlIIIIIlllll, final World lllllllllllllIlIIlllIlIIIIlIIlIl, final BlockPos lllllllllllllIlIIlllIlIIIIlIIlII, final Block lllllllllllllIlIIlllIlIIIIIlllII, final BlockPos lllllllllllllIlIIlllIlIIIIIllIll) {
            final EnumFacing lllllllllllllIlIIlllIlIIIIlIIIIl = lllllllllllllIlIIlllIlIIIIIlllll.getValue((IProperty<EnumFacing>)BlockBannerHanging.FACING);
            if (!lllllllllllllIlIIlllIlIIIIlIIlIl.getBlockState(lllllllllllllIlIIlllIlIIIIlIIlII.offset(lllllllllllllIlIIlllIlIIIIlIIIIl.getOpposite())).getMaterial().isSolid()) {
                this.dropBlockAsItem(lllllllllllllIlIIlllIlIIIIlIIlIl, lllllllllllllIlIIlllIlIIIIlIIlII, lllllllllllllIlIIlllIlIIIIIlllll, 0);
                lllllllllllllIlIIlllIlIIIIlIIlIl.setBlockToAir(lllllllllllllIlIIlllIlIIIIlIIlII);
            }
            super.neighborChanged(lllllllllllllIlIIlllIlIIIIIlllll, lllllllllllllIlIIlllIlIIIIlIIlIl, lllllllllllllIlIIlllIlIIIIlIIlII, lllllllllllllIlIIlllIlIIIIIlllII, lllllllllllllIlIIlllIlIIIIIllIll);
        }
        
        @Override
        public IBlockState getStateFromMeta(final int lllllllllllllIlIIlllIlIIIIIlIIlI) {
            EnumFacing lllllllllllllIlIIlllIlIIIIIlIlII = EnumFacing.getFront(lllllllllllllIlIIlllIlIIIIIlIIlI);
            if (lllllllllllllIlIIlllIlIIIIIlIlII.getAxis() == EnumFacing.Axis.Y) {
                lllllllllllllIlIIlllIlIIIIIlIlII = EnumFacing.NORTH;
            }
            return this.getDefaultState().withProperty((IProperty<Comparable>)BlockBannerHanging.FACING, lllllllllllllIlIIlllIlIIIIIlIlII);
        }
        
        @Override
        public IBlockState withRotation(final IBlockState lllllllllllllIlIIlllIlIIIIllllIl, final Rotation lllllllllllllIlIIlllIlIIIIlllllI) {
            return lllllllllllllIlIIlllIlIIIIllllIl.withProperty((IProperty<Comparable>)BlockBannerHanging.FACING, lllllllllllllIlIIlllIlIIIIlllllI.rotate(lllllllllllllIlIIlllIlIIIIllllIl.getValue((IProperty<EnumFacing>)BlockBannerHanging.FACING)));
        }
        
        @Override
        protected BlockStateContainer createBlockState() {
            return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockBannerHanging.FACING });
        }
        
        @Override
        public int getMetaFromState(final IBlockState lllllllllllllIlIIlllIlIIIIIIllIl) {
            return lllllllllllllIlIIlllIlIIIIIIllIl.getValue((IProperty<EnumFacing>)BlockBannerHanging.FACING).getIndex();
        }
        
        static {
            NORTH_AABB = new AxisAlignedBB(0.0, 0.0, 0.875, 1.0, 0.78125, 1.0);
            SOUTH_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.78125, 0.125);
            WEST_AABB = new AxisAlignedBB(0.875, 0.0, 0.0, 1.0, 0.78125, 1.0);
            EAST_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 0.125, 0.78125, 1.0);
        }
        
        @Override
        public IBlockState withMirror(final IBlockState lllllllllllllIlIIlllIlIIIIlllIII, final Mirror lllllllllllllIlIIlllIlIIIIllIlIl) {
            return lllllllllllllIlIIlllIlIIIIlllIII.withRotation(lllllllllllllIlIIlllIlIIIIllIlIl.toRotation(lllllllllllllIlIIlllIlIIIIlllIII.getValue((IProperty<EnumFacing>)BlockBannerHanging.FACING)));
        }
        
        @Override
        public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllllIlIIlllIlIIIIlIllll, final IBlockAccess lllllllllllllIlIIlllIlIIIIllIIIl, final BlockPos lllllllllllllIlIIlllIlIIIIllIIII) {
            switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllllIlIIlllIlIIIIlIllll.getValue((IProperty<EnumFacing>)BlockBannerHanging.FACING).ordinal()]) {
                default: {
                    return BlockBannerHanging.NORTH_AABB;
                }
                case 4: {
                    return BlockBannerHanging.SOUTH_AABB;
                }
                case 5: {
                    return BlockBannerHanging.WEST_AABB;
                }
                case 6: {
                    return BlockBannerHanging.EAST_AABB;
                }
            }
        }
        
        static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
            final int[] $switch_TABLE$net$minecraft$util$EnumFacing = BlockBannerHanging.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
            if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
                return $switch_TABLE$net$minecraft$util$EnumFacing;
            }
            final String lllllllllllllIlIIlllIlIIIIIIlIII = (Object)new int[EnumFacing.values().length];
            try {
                lllllllllllllIlIIlllIlIIIIIIlIII[EnumFacing.DOWN.ordinal()] = true;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                lllllllllllllIlIIlllIlIIIIIIlIII[EnumFacing.EAST.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                lllllllllllllIlIIlllIlIIIIIIlIII[EnumFacing.NORTH.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                lllllllllllllIlIIlllIlIIIIIIlIII[EnumFacing.SOUTH.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
            try {
                lllllllllllllIlIIlllIlIIIIIIlIII[EnumFacing.UP.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError5) {}
            try {
                lllllllllllllIlIIlllIlIIIIIIlIII[EnumFacing.WEST.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError6) {}
            return BlockBannerHanging.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)lllllllllllllIlIIlllIlIIIIIIlIII;
        }
    }
}
