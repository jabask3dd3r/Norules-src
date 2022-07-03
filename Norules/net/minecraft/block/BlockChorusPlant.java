package net.minecraft.block;

import net.minecraft.util.math.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import javax.annotation.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import net.minecraft.block.state.*;

public class BlockChorusPlant extends Block
{
    public static final /* synthetic */ PropertyBool SOUTH;
    public static final /* synthetic */ PropertyBool EAST;
    public static final /* synthetic */ PropertyBool DOWN;
    public static final /* synthetic */ PropertyBool WEST;
    public static final /* synthetic */ PropertyBool NORTH;
    public static final /* synthetic */ PropertyBool UP;
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllIIllIlIlIIlI, final IBlockState lllIIllIlIlIIIl, final BlockPos lllIIllIlIlIIII, final EnumFacing lllIIllIlIIllll) {
        return BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState lllIIllllIllIlI, final IBlockAccess lllIIlllllIIIll, final BlockPos lllIIllllIllIII) {
        lllIIllllIllIlI = (float)((IBlockProperties)lllIIllllIllIlI).getActualState(lllIIlllllIIIll, lllIIllllIllIII);
        final float lllIIlllllIIIIl = 0.1875f;
        final float lllIIlllllIIIII = ((IBlockState)lllIIllllIllIlI).getValue((IProperty<Boolean>)BlockChorusPlant.WEST) ? 0.0f : 0.1875f;
        final float lllIIllllIlllll = ((IBlockState)lllIIllllIllIlI).getValue((IProperty<Boolean>)BlockChorusPlant.DOWN) ? 0.0f : 0.1875f;
        final float lllIIllllIllllI = ((IBlockState)lllIIllllIllIlI).getValue((IProperty<Boolean>)BlockChorusPlant.NORTH) ? 0.0f : 0.1875f;
        final float lllIIllllIlllIl = ((IBlockState)lllIIllllIllIlI).getValue((IProperty<Boolean>)BlockChorusPlant.EAST) ? 1.0f : 0.8125f;
        final float lllIIllllIlllII = ((IBlockState)lllIIllllIllIlI).getValue((IProperty<Boolean>)BlockChorusPlant.UP) ? 1.0f : 0.8125f;
        final float lllIIllllIllIll = ((IBlockState)lllIIllllIllIlI).getValue((IProperty<Boolean>)BlockChorusPlant.SOUTH) ? 1.0f : 0.8125f;
        return new AxisAlignedBB(lllIIlllllIIIII, lllIIllllIlllll, lllIIllllIllllI, lllIIllllIlllIl, lllIIllllIlllII, lllIIllllIllIll);
    }
    
    @Override
    public boolean isPassable(final IBlockAccess lllIIllIlIlIlIl, final BlockPos lllIIllIlIlIlII) {
        return false;
    }
    
    protected BlockChorusPlant() {
        super(Material.PLANTS, MapColor.PURPLE);
        this.setCreativeTab(CreativeTabs.DECORATIONS);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockChorusPlant.NORTH, false).withProperty((IProperty<Comparable>)BlockChorusPlant.EAST, false).withProperty((IProperty<Comparable>)BlockChorusPlant.SOUTH, false).withProperty((IProperty<Comparable>)BlockChorusPlant.WEST, false).withProperty((IProperty<Comparable>)BlockChorusPlant.UP, false).withProperty((IProperty<Comparable>)BlockChorusPlant.DOWN, false));
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllIIlllIllIlIl) {
        return 0;
    }
    
    @Override
    public void addCollisionBoxToList(IBlockState lllIIlllIlllllI, final World lllIIlllIllllIl, final BlockPos lllIIllllIIIlIl, final AxisAlignedBB lllIIlllIlllIll, final List<AxisAlignedBB> lllIIllllIIIIll, @Nullable final Entity lllIIllllIIIIlI, final boolean lllIIllllIIIIIl) {
        if (!lllIIllllIIIIIl) {
            lllIIlllIlllllI = ((IBlockProperties)lllIIlllIlllllI).getActualState(lllIIlllIllllIl, lllIIllllIIIlIl);
        }
        final float lllIIllllIIIIII = 0.1875f;
        final float lllIIlllIllllll = 0.8125f;
        Block.addCollisionBoxToList(lllIIllllIIIlIl, lllIIlllIlllIll, lllIIllllIIIIll, new AxisAlignedBB(0.1875, 0.1875, 0.1875, 0.8125, 0.8125, 0.8125));
        if (((IBlockState)lllIIlllIlllllI).getValue((IProperty<Boolean>)BlockChorusPlant.WEST)) {
            Block.addCollisionBoxToList(lllIIllllIIIlIl, lllIIlllIlllIll, lllIIllllIIIIll, new AxisAlignedBB(0.0, 0.1875, 0.1875, 0.1875, 0.8125, 0.8125));
        }
        if (((IBlockState)lllIIlllIlllllI).getValue((IProperty<Boolean>)BlockChorusPlant.EAST)) {
            Block.addCollisionBoxToList(lllIIllllIIIlIl, lllIIlllIlllIll, lllIIllllIIIIll, new AxisAlignedBB(0.8125, 0.1875, 0.1875, 1.0, 0.8125, 0.8125));
        }
        if (((IBlockState)lllIIlllIlllllI).getValue((IProperty<Boolean>)BlockChorusPlant.UP)) {
            Block.addCollisionBoxToList(lllIIllllIIIlIl, lllIIlllIlllIll, lllIIllllIIIIll, new AxisAlignedBB(0.1875, 0.8125, 0.1875, 0.8125, 1.0, 0.8125));
        }
        if (((IBlockState)lllIIlllIlllllI).getValue((IProperty<Boolean>)BlockChorusPlant.DOWN)) {
            Block.addCollisionBoxToList(lllIIllllIIIlIl, lllIIlllIlllIll, lllIIllllIIIIll, new AxisAlignedBB(0.1875, 0.0, 0.1875, 0.8125, 0.1875, 0.8125));
        }
        if (((IBlockState)lllIIlllIlllllI).getValue((IProperty<Boolean>)BlockChorusPlant.NORTH)) {
            Block.addCollisionBoxToList(lllIIllllIIIlIl, lllIIlllIlllIll, lllIIllllIIIIll, new AxisAlignedBB(0.1875, 0.1875, 0.0, 0.8125, 0.8125, 0.1875));
        }
        if (((IBlockState)lllIIlllIlllllI).getValue((IProperty<Boolean>)BlockChorusPlant.SOUTH)) {
            Block.addCollisionBoxToList(lllIIllllIIIlIl, lllIIlllIlllIll, lllIIllllIIIIll, new AxisAlignedBB(0.1875, 0.1875, 0.8125, 0.8125, 0.8125, 1.0));
        }
    }
    
    public boolean canSurviveAt(final World lllIIllIlllllIl, final BlockPos lllIIllIlllIIlI) {
        final boolean lllIIllIllllIll = lllIIllIlllllIl.isAirBlock(lllIIllIlllIIlI.up());
        final boolean lllIIllIllllIlI = lllIIllIlllllIl.isAirBlock(lllIIllIlllIIlI.down());
        for (final EnumFacing lllIIllIllllIIl : EnumFacing.Plane.HORIZONTAL) {
            final BlockPos lllIIllIllllIII = lllIIllIlllIIlI.offset(lllIIllIllllIIl);
            final Block lllIIllIlllIlll = lllIIllIlllllIl.getBlockState(lllIIllIllllIII).getBlock();
            if (lllIIllIlllIlll == this) {
                if (!lllIIllIllllIll && !lllIIllIllllIlI) {
                    return false;
                }
                final Block lllIIllIlllIllI = lllIIllIlllllIl.getBlockState(lllIIllIllllIII.down()).getBlock();
                if (lllIIllIlllIllI == this || lllIIllIlllIllI == Blocks.END_STONE) {
                    return true;
                }
                continue;
            }
        }
        final Block lllIIllIlllIlIl = lllIIllIlllllIl.getBlockState(lllIIllIlllIIlI.down()).getBlock();
        return lllIIllIlllIlIl == this || lllIIllIlllIlIl == Blocks.END_STONE;
    }
    
    static {
        NORTH = PropertyBool.create("north");
        EAST = PropertyBool.create("east");
        SOUTH = PropertyBool.create("south");
        WEST = PropertyBool.create("west");
        UP = PropertyBool.create("up");
        DOWN = PropertyBool.create("down");
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllIIlllIlIIIII) {
        return false;
    }
    
    @Override
    public void neighborChanged(final IBlockState lllIIlllIIlIIII, final World lllIIlllIIIlIlI, final BlockPos lllIIlllIIIlllI, final Block lllIIlllIIIllIl, final BlockPos lllIIlllIIIllII) {
        if (!this.canSurviveAt(lllIIlllIIIlIlI, lllIIlllIIIlllI)) {
            lllIIlllIIIlIlI.scheduleUpdate(lllIIlllIIIlllI, this, 1);
        }
    }
    
    @Override
    public void updateTick(final World lllIIlllIlIlIll, final BlockPos lllIIlllIlIllll, final IBlockState lllIIlllIlIlllI, final Random lllIIlllIlIllIl) {
        if (!this.canSurviveAt(lllIIlllIlIlIll, lllIIlllIlIllll)) {
            lllIIlllIlIlIll.destroyBlock(lllIIlllIlIllll, true);
        }
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }
    
    @Override
    public int quantityDropped(final Random lllIIlllIlIIIll) {
        return lllIIlllIlIIIll.nextInt(2);
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllIIlllIIllllI) {
        return false;
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockChorusPlant.NORTH, BlockChorusPlant.EAST, BlockChorusPlant.SOUTH, BlockChorusPlant.WEST, BlockChorusPlant.UP, BlockChorusPlant.DOWN });
    }
    
    @Override
    public IBlockState getActualState(final IBlockState lllIIlllllllIII, final IBlockAccess lllIIllllllIlll, final BlockPos lllIIllllllIllI) {
        final Block lllIIllllllllll = lllIIllllllIlll.getBlockState(lllIIllllllIllI.down()).getBlock();
        final Block lllIIlllllllllI = lllIIllllllIlll.getBlockState(lllIIllllllIllI.up()).getBlock();
        final Block lllIIllllllllIl = lllIIllllllIlll.getBlockState(lllIIllllllIllI.north()).getBlock();
        final Block lllIIllllllllII = lllIIllllllIlll.getBlockState(lllIIllllllIllI.east()).getBlock();
        final Block lllIIlllllllIll = lllIIllllllIlll.getBlockState(lllIIllllllIllI.south()).getBlock();
        final Block lllIIlllllllIlI = lllIIllllllIlll.getBlockState(lllIIllllllIllI.west()).getBlock();
        return lllIIlllllllIII.withProperty((IProperty<Comparable>)BlockChorusPlant.DOWN, lllIIllllllllll == this || lllIIllllllllll == Blocks.CHORUS_FLOWER || lllIIllllllllll == Blocks.END_STONE).withProperty((IProperty<Comparable>)BlockChorusPlant.UP, lllIIlllllllllI == this || lllIIlllllllllI == Blocks.CHORUS_FLOWER).withProperty((IProperty<Comparable>)BlockChorusPlant.NORTH, lllIIllllllllIl == this || lllIIllllllllIl == Blocks.CHORUS_FLOWER).withProperty((IProperty<Comparable>)BlockChorusPlant.EAST, lllIIllllllllII == this || lllIIllllllllII == Blocks.CHORUS_FLOWER).withProperty((IProperty<Comparable>)BlockChorusPlant.SOUTH, lllIIlllllllIll == this || lllIIlllllllIll == Blocks.CHORUS_FLOWER).withProperty((IProperty<Comparable>)BlockChorusPlant.WEST, lllIIlllllllIlI == this || lllIIlllllllIlI == Blocks.CHORUS_FLOWER);
    }
    
    @Override
    public boolean canPlaceBlockAt(final World lllIIlllIIllIIl, final BlockPos lllIIlllIIllIII) {
        return super.canPlaceBlockAt(lllIIlllIIllIIl, lllIIlllIIllIII) && this.canSurviveAt(lllIIlllIIllIIl, lllIIlllIIllIII);
    }
    
    @Override
    public boolean shouldSideBeRendered(final IBlockState lllIIllIllIIIll, final IBlockAccess lllIIllIllIIIlI, final BlockPos lllIIllIllIIIIl, final EnumFacing lllIIllIllIIIII) {
        final Block lllIIllIlIlllll = lllIIllIllIIIlI.getBlockState(lllIIllIllIIIIl.offset(lllIIllIllIIIII)).getBlock();
        return lllIIllIlIlllll != this && lllIIllIlIlllll != Blocks.CHORUS_FLOWER && (lllIIllIllIIIII != EnumFacing.DOWN || lllIIllIlIlllll != Blocks.END_STONE);
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllIIlllIlIlIII, final Random lllIIlllIlIIlll, final int lllIIlllIlIIllI) {
        return Items.CHORUS_FRUIT;
    }
}
