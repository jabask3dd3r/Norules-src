package net.minecraft.block;

import net.minecraft.util.math.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;
import net.minecraft.block.material.*;
import net.minecraft.item.*;
import net.minecraft.entity.*;
import net.minecraft.init.*;
import net.minecraft.util.*;

public class BlockCocoa extends BlockHorizontal implements IGrowable
{
    protected static final /* synthetic */ AxisAlignedBB[] COCOA_WEST_AABB;
    public static final /* synthetic */ PropertyInteger AGE;
    protected static final /* synthetic */ AxisAlignedBB[] COCOA_EAST_AABB;
    protected static final /* synthetic */ AxisAlignedBB[] COCOA_NORTH_AABB;
    protected static final /* synthetic */ AxisAlignedBB[] COCOA_SOUTH_AABB;
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess llllllllllllllIIIIIIlIlIlIIllIlI, final IBlockState llllllllllllllIIIIIIlIlIlIIllIIl, final BlockPos llllllllllllllIIIIIIlIlIlIIllIII, final EnumFacing llllllllllllllIIIIIIlIlIlIIlIlll) {
        return BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public void grow(final World llllllllllllllIIIIIIlIlIlIlIllll, final Random llllllllllllllIIIIIIlIlIlIllIIlI, final BlockPos llllllllllllllIIIIIIlIlIlIllIIIl, final IBlockState llllllllllllllIIIIIIlIlIlIlIllIl) {
        llllllllllllllIIIIIIlIlIlIlIllll.setBlockState(llllllllllllllIIIIIIlIlIlIllIIIl, llllllllllllllIIIIIIlIlIlIlIllIl.withProperty((IProperty<Comparable>)BlockCocoa.AGE, llllllllllllllIIIIIIlIlIlIlIllIl.getValue((IProperty<Integer>)BlockCocoa.AGE) + 1), 2);
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockCocoa.FACING, BlockCocoa.AGE });
    }
    
    static {
        AGE = PropertyInteger.create("age", 0, 2);
        COCOA_EAST_AABB = new AxisAlignedBB[] { new AxisAlignedBB(0.6875, 0.4375, 0.375, 0.9375, 0.75, 0.625), new AxisAlignedBB(0.5625, 0.3125, 0.3125, 0.9375, 0.75, 0.6875), new AxisAlignedBB(0.4375, 0.1875, 0.25, 0.9375, 0.75, 0.75) };
        COCOA_WEST_AABB = new AxisAlignedBB[] { new AxisAlignedBB(0.0625, 0.4375, 0.375, 0.3125, 0.75, 0.625), new AxisAlignedBB(0.0625, 0.3125, 0.3125, 0.4375, 0.75, 0.6875), new AxisAlignedBB(0.0625, 0.1875, 0.25, 0.5625, 0.75, 0.75) };
        COCOA_NORTH_AABB = new AxisAlignedBB[] { new AxisAlignedBB(0.375, 0.4375, 0.0625, 0.625, 0.75, 0.3125), new AxisAlignedBB(0.3125, 0.3125, 0.0625, 0.6875, 0.75, 0.4375), new AxisAlignedBB(0.25, 0.1875, 0.0625, 0.75, 0.75, 0.5625) };
        COCOA_SOUTH_AABB = new AxisAlignedBB[] { new AxisAlignedBB(0.375, 0.4375, 0.6875, 0.625, 0.75, 0.9375), new AxisAlignedBB(0.3125, 0.3125, 0.5625, 0.6875, 0.75, 0.9375), new AxisAlignedBB(0.25, 0.1875, 0.4375, 0.75, 0.75, 0.9375) };
    }
    
    @Override
    public void updateTick(final World llllllllllllllIIIIIIllIIIlIllllI, final BlockPos llllllllllllllIIIIIIllIIIlIlllIl, final IBlockState llllllllllllllIIIIIIllIIIlIlIllI, final Random llllllllllllllIIIIIIllIIIlIllIll) {
        if (!this.canBlockStay(llllllllllllllIIIIIIllIIIlIllllI, llllllllllllllIIIIIIllIIIlIlllIl, llllllllllllllIIIIIIllIIIlIlIllI)) {
            this.dropBlock(llllllllllllllIIIIIIllIIIlIllllI, llllllllllllllIIIIIIllIIIlIlllIl, llllllllllllllIIIIIIllIIIlIlIllI);
        }
        else if (llllllllllllllIIIIIIllIIIlIllllI.rand.nextInt(5) == 0) {
            final int llllllllllllllIIIIIIllIIIlIllIlI = llllllllllllllIIIIIIllIIIlIlIllI.getValue((IProperty<Integer>)BlockCocoa.AGE);
            if (llllllllllllllIIIIIIllIIIlIllIlI < 2) {
                llllllllllllllIIIIIIllIIIlIllllI.setBlockState(llllllllllllllIIIIIIllIIIlIlllIl, llllllllllllllIIIIIIllIIIlIlIllI.withProperty((IProperty<Comparable>)BlockCocoa.AGE, llllllllllllllIIIIIIllIIIlIllIlI + 1), 2);
            }
        }
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing = BlockCocoa.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
        if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing;
        }
        final boolean llllllllllllllIIIIIIlIlIlIIlIlIl = (Object)new int[EnumFacing.values().length];
        try {
            llllllllllllllIIIIIIlIlIlIIlIlIl[EnumFacing.DOWN.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllIIIIIIlIlIlIIlIlIl[EnumFacing.EAST.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllllIIIIIIlIlIlIIlIlIl[EnumFacing.NORTH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllllIIIIIIlIlIlIIlIlIl[EnumFacing.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            llllllllllllllIIIIIIlIlIlIIlIlIl[EnumFacing.UP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            llllllllllllllIIIIIIlIlIlIIlIlIl[EnumFacing.WEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return BlockCocoa.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)llllllllllllllIIIIIIlIlIlIIlIlIl;
    }
    
    @Override
    public boolean canUseBonemeal(final World llllllllllllllIIIIIIlIlllIlllIII, final Random llllllllllllllIIIIIIlIlllIllIlll, final BlockPos llllllllllllllIIIIIIlIlllIllIllI, final IBlockState llllllllllllllIIIIIIlIlllIllIlIl) {
        return true;
    }
    
    @Override
    public IBlockState withMirror(final IBlockState llllllllllllllIIIIIIllIIIIllIIII, final Mirror llllllllllllllIIIIIIllIIIIlIllll) {
        return llllllllllllllIIIIIIllIIIIllIIII.withRotation(llllllllllllllIIIIIIllIIIIlIllll.toRotation(llllllllllllllIIIIIIllIIIIllIIII.getValue((IProperty<EnumFacing>)BlockCocoa.FACING)));
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllllIIIIIIlIlIlIlIIIII) {
        int llllllllllllllIIIIIIlIlIlIlIIIIl = 0;
        llllllllllllllIIIIIIlIlIlIlIIIIl |= llllllllllllllIIIIIIlIlIlIlIIIII.getValue((IProperty<EnumFacing>)BlockCocoa.FACING).getHorizontalIndex();
        llllllllllllllIIIIIIlIlIlIlIIIIl |= llllllllllllllIIIIIIlIlIlIlIIIII.getValue((IProperty<Integer>)BlockCocoa.AGE) << 2;
        return llllllllllllllIIIIIIlIlIlIlIIIIl;
    }
    
    public BlockCocoa() {
        super(Material.PLANTS);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockCocoa.FACING, EnumFacing.NORTH).withProperty((IProperty<Comparable>)BlockCocoa.AGE, 0));
        this.setTickRandomly(true);
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState llllllllllllllIIIIIIllIIIlIIIIII, final IBlockAccess llllllllllllllIIIIIIllIIIIllllll, final BlockPos llllllllllllllIIIIIIllIIIIlllllI) {
        final int llllllllllllllIIIIIIllIIIIllllIl = llllllllllllllIIIIIIllIIIlIIIIII.getValue((IProperty<Integer>)BlockCocoa.AGE);
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[llllllllllllllIIIIIIllIIIlIIIIII.getValue((IProperty<EnumFacing>)BlockCocoa.FACING).ordinal()]) {
            case 4: {
                return BlockCocoa.COCOA_SOUTH_AABB[llllllllllllllIIIIIIllIIIIllllIl];
            }
            default: {
                return BlockCocoa.COCOA_NORTH_AABB[llllllllllllllIIIIIIllIIIIllllIl];
            }
            case 5: {
                return BlockCocoa.COCOA_WEST_AABB[llllllllllllllIIIIIIllIIIIllllIl];
            }
            case 6: {
                return BlockCocoa.COCOA_EAST_AABB[llllllllllllllIIIIIIllIIIIllllIl];
            }
        }
    }
    
    @Override
    public void dropBlockAsItemWithChance(final World llllllllllllllIIIIIIlIllllIIlIlI, final BlockPos llllllllllllllIIIIIIlIllllIlIIIl, final IBlockState llllllllllllllIIIIIIlIllllIIlIII, final float llllllllllllllIIIIIIlIllllIIllll, final int llllllllllllllIIIIIIlIllllIIlllI) {
        final int llllllllllllllIIIIIIlIllllIIllIl = llllllllllllllIIIIIIlIllllIIlIII.getValue((IProperty<Integer>)BlockCocoa.AGE);
        int llllllllllllllIIIIIIlIllllIIllII = 1;
        if (llllllllllllllIIIIIIlIllllIIllIl >= 2) {
            llllllllllllllIIIIIIlIllllIIllII = 3;
        }
        for (int llllllllllllllIIIIIIlIllllIIlIll = 0; llllllllllllllIIIIIIlIllllIIlIll < llllllllllllllIIIIIIlIllllIIllII; ++llllllllllllllIIIIIIlIllllIIlIll) {
            Block.spawnAsEntity(llllllllllllllIIIIIIlIllllIIlIlI, llllllllllllllIIIIIIlIllllIlIIIl, new ItemStack(Items.DYE, 1, EnumDyeColor.BROWN.getDyeDamage()));
        }
    }
    
    @Override
    public IBlockState onBlockPlaced(final World llllllllllllllIIIIIIllIIIIIllIII, final BlockPos llllllllllllllIIIIIIllIIIIIlIlll, EnumFacing llllllllllllllIIIIIIllIIIIIIllll, final float llllllllllllllIIIIIIllIIIIIlIlIl, final float llllllllllllllIIIIIIllIIIIIlIlII, final float llllllllllllllIIIIIIllIIIIIlIIll, final int llllllllllllllIIIIIIllIIIIIlIIlI, final EntityLivingBase llllllllllllllIIIIIIllIIIIIlIIIl) {
        if (!((EnumFacing)llllllllllllllIIIIIIllIIIIIIllll).getAxis().isHorizontal()) {
            llllllllllllllIIIIIIllIIIIIIllll = EnumFacing.NORTH;
        }
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockCocoa.FACING, ((EnumFacing)llllllllllllllIIIIIIllIIIIIIllll).getOpposite()).withProperty((IProperty<Comparable>)BlockCocoa.AGE, 0);
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState llllllllllllllIIIIIIllIIIlIIIlII) {
        return false;
    }
    
    @Override
    public ItemStack getItem(final World llllllllllllllIIIIIIlIllllIIIIll, final BlockPos llllllllllllllIIIIIIlIllllIIIIlI, final IBlockState llllllllllllllIIIIIIlIllllIIIIIl) {
        return new ItemStack(Items.DYE, 1, EnumDyeColor.BROWN.getDyeDamage());
    }
    
    @Override
    public void neighborChanged(final IBlockState llllllllllllllIIIIIIllIIIIIIIIll, final World llllllllllllllIIIIIIllIIIIIIlIII, final BlockPos llllllllllllllIIIIIIllIIIIIIIlll, final Block llllllllllllllIIIIIIllIIIIIIIllI, final BlockPos llllllllllllllIIIIIIllIIIIIIIlIl) {
        if (!this.canBlockStay(llllllllllllllIIIIIIllIIIIIIlIII, llllllllllllllIIIIIIllIIIIIIIlll, llllllllllllllIIIIIIllIIIIIIIIll)) {
            this.dropBlock(llllllllllllllIIIIIIllIIIIIIlIII, llllllllllllllIIIIIIllIIIIIIIlll, llllllllllllllIIIIIIllIIIIIIIIll);
        }
    }
    
    public boolean canBlockStay(final World llllllllllllllIIIIIIllIIIlIIllll, BlockPos llllllllllllllIIIIIIllIIIlIIlIlI, final IBlockState llllllllllllllIIIIIIllIIIlIIlIIl) {
        llllllllllllllIIIIIIllIIIlIIlIlI = (char)((BlockPos)llllllllllllllIIIIIIllIIIlIIlIlI).offset(llllllllllllllIIIIIIllIIIlIIlIIl.getValue((IProperty<EnumFacing>)BlockCocoa.FACING));
        final IBlockState llllllllllllllIIIIIIllIIIlIIllII = llllllllllllllIIIIIIllIIIlIIllll.getBlockState((BlockPos)llllllllllllllIIIIIIllIIIlIIlIlI);
        return llllllllllllllIIIIIIllIIIlIIllII.getBlock() == Blocks.LOG && llllllllllllllIIIIIIllIIIlIIllII.getValue(BlockOldLog.VARIANT) == BlockPlanks.EnumType.JUNGLE;
    }
    
    @Override
    public boolean canGrow(final World llllllllllllllIIIIIIlIlllIlllllI, final BlockPos llllllllllllllIIIIIIlIlllIllllIl, final IBlockState llllllllllllllIIIIIIlIlllIllllII, final boolean llllllllllllllIIIIIIlIlllIlllIll) {
        return llllllllllllllIIIIIIlIlllIllllII.getValue((IProperty<Integer>)BlockCocoa.AGE) < 2;
    }
    
    private void dropBlock(final World llllllllllllllIIIIIIlIllllllIIIl, final BlockPos llllllllllllllIIIIIIlIlllllIllll, final IBlockState llllllllllllllIIIIIIlIlllllIllIl) {
        llllllllllllllIIIIIIlIllllllIIIl.setBlockState(llllllllllllllIIIIIIlIlllllIllll, Blocks.AIR.getDefaultState(), 3);
        this.dropBlockAsItem(llllllllllllllIIIIIIlIllllllIIIl, llllllllllllllIIIIIIlIlllllIllll, llllllllllllllIIIIIIlIlllllIllIl, 0);
    }
    
    @Override
    public IBlockState withRotation(final IBlockState llllllllllllllIIIIIIllIIIIllIlll, final Rotation llllllllllllllIIIIIIllIIIIllIllI) {
        return llllllllllllllIIIIIIllIIIIllIlll.withProperty((IProperty<Comparable>)BlockCocoa.FACING, llllllllllllllIIIIIIllIIIIllIllI.rotate(llllllllllllllIIIIIIllIIIIllIlll.getValue((IProperty<EnumFacing>)BlockCocoa.FACING)));
    }
    
    @Override
    public void onBlockPlacedBy(final World llllllllllllllIIIIIIllIIIIlIIllI, final BlockPos llllllllllllllIIIIIIllIIIIlIIlIl, final IBlockState llllllllllllllIIIIIIllIIIIIllllI, final EntityLivingBase llllllllllllllIIIIIIllIIIIlIIIll, final ItemStack llllllllllllllIIIIIIllIIIIlIIIlI) {
        final EnumFacing llllllllllllllIIIIIIllIIIIlIIIIl = EnumFacing.fromAngle(llllllllllllllIIIIIIllIIIIlIIIll.rotationYaw);
        llllllllllllllIIIIIIllIIIIlIIllI.setBlockState(llllllllllllllIIIIIIllIIIIlIIlIl, llllllllllllllIIIIIIllIIIIIllllI.withProperty((IProperty<Comparable>)BlockCocoa.FACING, llllllllllllllIIIIIIllIIIIlIIIIl), 2);
    }
    
    @Override
    public boolean isFullCube(final IBlockState llllllllllllllIIIIIIllIIIlIIIllI) {
        return false;
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllllIIIIIIlIlIlIlIIllI) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockCocoa.FACING, EnumFacing.getHorizontal(llllllllllllllIIIIIIlIlIlIlIIllI)).withProperty((IProperty<Comparable>)BlockCocoa.AGE, (llllllllllllllIIIIIIlIlIlIlIIllI & 0xF) >> 2);
    }
}
