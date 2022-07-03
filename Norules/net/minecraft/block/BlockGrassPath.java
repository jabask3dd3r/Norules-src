package net.minecraft.block;

import java.util.*;
import net.minecraft.init.*;
import net.minecraft.block.properties.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.item.*;
import net.minecraft.block.material.*;
import net.minecraft.block.state.*;

public class BlockGrassPath extends Block
{
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing;
    protected static final /* synthetic */ AxisAlignedBB GRASS_PATH_AABB;
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllllllIlIlIIIlIllIIllIII, final Random llllllllllllllIlIlIIIlIllIIlIlll, final int llllllllllllllIlIlIIIlIllIIlIllI) {
        return Blocks.DIRT.getItemDropped(Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.DIRT), llllllllllllllIlIlIIIlIllIIlIlll, llllllllllllllIlIlIIIlIllIIlIllI);
    }
    
    static {
        GRASS_PATH_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.9375, 1.0);
    }
    
    @Override
    public boolean isFullCube(final IBlockState llllllllllllllIlIlIIIlIllIIlllII) {
        return false;
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState llllllllllllllIlIlIIIlIllIlIIIlI, final IBlockAccess llllllllllllllIlIlIIIlIllIlIIIIl, final BlockPos llllllllllllllIlIlIIIlIllIlIIIII) {
        return BlockGrassPath.GRASS_PATH_AABB;
    }
    
    @Override
    public void neighborChanged(final IBlockState llllllllllllllIlIlIIIlIllIIIIllI, final World llllllllllllllIlIlIIIlIlIlllllll, final BlockPos llllllllllllllIlIlIIIlIlIllllllI, final Block llllllllllllllIlIlIIIlIllIIIIIll, final BlockPos llllllllllllllIlIlIIIlIllIIIIIlI) {
        super.neighborChanged(llllllllllllllIlIlIIIlIllIIIIllI, llllllllllllllIlIlIIIlIlIlllllll, llllllllllllllIlIlIIIlIlIllllllI, llllllllllllllIlIlIIIlIllIIIIIll, llllllllllllllIlIlIIIlIllIIIIIlI);
        this.func_190971_b(llllllllllllllIlIlIIIlIlIlllllll, llllllllllllllIlIlIIIlIlIllllllI);
    }
    
    @Override
    public boolean shouldSideBeRendered(final IBlockState llllllllllllllIlIlIIIlIllIllllII, final IBlockAccess llllllllllllllIlIlIIIlIlllIIIIlI, final BlockPos llllllllllllllIlIlIIIlIlllIIIIIl, final EnumFacing llllllllllllllIlIlIIIlIlllIIIIII) {
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[llllllllllllllIlIlIIIlIlllIIIIII.ordinal()]) {
            case 2: {
                return true;
            }
            case 3:
            case 4:
            case 5:
            case 6: {
                final IBlockState llllllllllllllIlIlIIIlIllIllllll = llllllllllllllIlIlIIIlIlllIIIIlI.getBlockState(llllllllllllllIlIlIIIlIlllIIIIIl.offset(llllllllllllllIlIlIIIlIlllIIIIII));
                final Block llllllllllllllIlIlIIIlIllIlllllI = llllllllllllllIlIlIIIlIllIllllll.getBlock();
                return !llllllllllllllIlIlIIIlIllIllllll.isOpaqueCube() && llllllllllllllIlIlIIIlIllIlllllI != Blocks.FARMLAND && llllllllllllllIlIlIIIlIllIlllllI != Blocks.GRASS_PATH;
            }
            default: {
                return super.shouldSideBeRendered(llllllllllllllIlIlIIIlIllIllllII, llllllllllllllIlIlIIIlIlllIIIIlI, llllllllllllllIlIlIIIlIlllIIIIIl, llllllllllllllIlIlIIIlIlllIIIIII);
            }
        }
    }
    
    @Override
    public ItemStack getItem(final World llllllllllllllIlIlIIIlIllIIlIIIl, final BlockPos llllllllllllllIlIlIIIlIllIIlIIII, final IBlockState llllllllllllllIlIlIIIlIllIIIllll) {
        return new ItemStack(this);
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing = BlockGrassPath.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
        if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing;
        }
        final short llllllllllllllIlIlIIIlIlIlllIIll = (Object)new int[EnumFacing.values().length];
        try {
            llllllllllllllIlIlIIIlIlIlllIIll[EnumFacing.DOWN.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllIlIlIIIlIlIlllIIll[EnumFacing.EAST.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllllIlIlIIIlIlIlllIIll[EnumFacing.NORTH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllllIlIlIIIlIlIlllIIll[EnumFacing.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            llllllllllllllIlIlIIIlIlIlllIIll[EnumFacing.UP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            llllllllllllllIlIlIIIlIlIlllIIll[EnumFacing.WEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return BlockGrassPath.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)llllllllllllllIlIlIIIlIlIlllIIll;
    }
    
    protected BlockGrassPath() {
        super(Material.GROUND);
        this.setLightOpacity(255);
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState llllllllllllllIlIlIIIlIllIIllllI) {
        return false;
    }
    
    private void func_190971_b(final World llllllllllllllIlIlIIIlIllIlIIlll, final BlockPos llllllllllllllIlIlIIIlIllIlIIlII) {
        if (llllllllllllllIlIlIIIlIllIlIIlll.getBlockState(llllllllllllllIlIlIIIlIllIlIIlII.up()).getMaterial().isSolid()) {
            BlockFarmland.func_190970_b(llllllllllllllIlIlIIIlIllIlIIlll, llllllllllllllIlIlIIIlIllIlIIlII);
        }
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess llllllllllllllIlIlIIIlIlIllllIIl, final IBlockState llllllllllllllIlIlIIIlIlIllllIII, final BlockPos llllllllllllllIlIlIIIlIlIlllIlll, final EnumFacing llllllllllllllIlIlIIIlIlIlllIllI) {
        return (llllllllllllllIlIlIIIlIlIlllIllI == EnumFacing.DOWN) ? BlockFaceShape.SOLID : BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public void onBlockAdded(final World llllllllllllllIlIlIIIlIllIlIllIl, final BlockPos llllllllllllllIlIlIIIlIllIllIIII, final IBlockState llllllllllllllIlIlIIIlIllIlIlIll) {
        super.onBlockAdded(llllllllllllllIlIlIIIlIllIlIllIl, llllllllllllllIlIlIIIlIllIllIIII, llllllllllllllIlIlIIIlIllIlIlIll);
        this.func_190971_b(llllllllllllllIlIlIIIlIllIlIllIl, llllllllllllllIlIlIIIlIllIllIIII);
    }
}
