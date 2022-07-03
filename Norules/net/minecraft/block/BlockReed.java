package net.minecraft.block;

import net.minecraft.util.math.*;
import net.minecraft.world.*;
import javax.annotation.*;
import net.minecraft.init.*;
import net.minecraft.block.material.*;
import net.minecraft.block.properties.*;
import java.util.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.block.state.*;

public class BlockReed extends Block
{
    public static final /* synthetic */ PropertyInteger AGE;
    protected static final /* synthetic */ AxisAlignedBB REED_AABB;
    
    @Override
    public boolean isFullCube(final IBlockState llllllllllllllIlIIllIIlIIlIlIIlI) {
        return false;
    }
    
    @Override
    public ItemStack getItem(final World llllllllllllllIlIIllIIlIIlIlIIII, final BlockPos llllllllllllllIlIIllIIlIIlIIllll, final IBlockState llllllllllllllIlIIllIIlIIlIIlllI) {
        return new ItemStack(Items.REEDS);
    }
    
    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final IBlockState llllllllllllllIlIIllIIlIIlIlllII, final IBlockAccess llllllllllllllIlIIllIIlIIlIllIll, final BlockPos llllllllllllllIlIIllIIlIIlIllIlI) {
        return BlockReed.NULL_AABB;
    }
    
    @Override
    public boolean canPlaceBlockAt(final World llllllllllllllIlIIllIIlIlIIIIlll, final BlockPos llllllllllllllIlIIllIIlIlIIIIllI) {
        final Block llllllllllllllIlIIllIIlIlIIIllII = llllllllllllllIlIIllIIlIlIIIIlll.getBlockState(llllllllllllllIlIIllIIlIlIIIIllI.down()).getBlock();
        if (llllllllllllllIlIIllIIlIlIIIllII == this) {
            return true;
        }
        if (llllllllllllllIlIIllIIlIlIIIllII != Blocks.GRASS && llllllllllllllIlIIllIIlIlIIIllII != Blocks.DIRT && llllllllllllllIlIIllIIlIlIIIllII != Blocks.SAND) {
            return false;
        }
        final BlockPos llllllllllllllIlIIllIIlIlIIIlIll = llllllllllllllIlIIllIIlIlIIIIllI.down();
        for (final EnumFacing llllllllllllllIlIIllIIlIlIIIlIlI : EnumFacing.Plane.HORIZONTAL) {
            final IBlockState llllllllllllllIlIIllIIlIlIIIlIIl = llllllllllllllIlIIllIIlIlIIIIlll.getBlockState(llllllllllllllIlIIllIIlIlIIIlIll.offset(llllllllllllllIlIIllIIlIlIIIlIlI));
            if (llllllllllllllIlIIllIIlIlIIIlIIl.getMaterial() == Material.WATER || llllllllllllllIlIIllIIlIlIIIlIIl.getBlock() == Blocks.FROSTED_ICE) {
                return true;
            }
        }
        return false;
    }
    
    protected final boolean checkForDrop(final World llllllllllllllIlIIllIIlIIllIlIIl, final BlockPos llllllllllllllIlIIllIIlIIllIllII, final IBlockState llllllllllllllIlIIllIIlIIllIlIll) {
        if (this.canBlockStay(llllllllllllllIlIIllIIlIIllIlIIl, llllllllllllllIlIIllIIlIIllIllII)) {
            return true;
        }
        this.dropBlockAsItem(llllllllllllllIlIIllIIlIIllIlIIl, llllllllllllllIlIIllIIlIIllIllII, llllllllllllllIlIIllIIlIIllIlIll, 0);
        llllllllllllllIlIIllIIlIIllIlIIl.setBlockToAir(llllllllllllllIlIIllIIlIIllIllII);
        return false;
    }
    
    @Override
    public void neighborChanged(final IBlockState llllllllllllllIlIIllIIlIIllllIll, final World llllllllllllllIlIIllIIlIIllllIlI, final BlockPos llllllllllllllIlIIllIIlIIlllIIll, final Block llllllllllllllIlIIllIIlIIllllIII, final BlockPos llllllllllllllIlIIllIIlIIlllIlll) {
        this.checkForDrop(llllllllllllllIlIIllIIlIIllllIlI, llllllllllllllIlIIllIIlIIlllIIll, llllllllllllllIlIIllIIlIIllllIll);
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockReed.AGE });
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllllIlIIllIIlIIlIIIIll) {
        return llllllllllllllIlIIllIIlIIlIIIIll.getValue((IProperty<Integer>)BlockReed.AGE);
    }
    
    static {
        AGE = PropertyInteger.create("age", 0, 15);
        REED_AABB = new AxisAlignedBB(0.125, 0.0, 0.125, 0.875, 1.0, 0.875);
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState llllllllllllllIlIIllIIlIIlIlIlII) {
        return false;
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState llllllllllllllIlIIllIIlIlIlIllIl, final IBlockAccess llllllllllllllIlIIllIIlIlIlIllII, final BlockPos llllllllllllllIlIIllIIlIlIlIlIll) {
        return BlockReed.REED_AABB;
    }
    
    @Override
    public void updateTick(final World llllllllllllllIlIIllIIlIlIIlllII, final BlockPos llllllllllllllIlIIllIIlIlIIllIll, final IBlockState llllllllllllllIlIIllIIlIlIIllIlI, final Random llllllllllllllIlIIllIIlIlIlIIIII) {
        if ((llllllllllllllIlIIllIIlIlIIlllII.getBlockState(llllllllllllllIlIIllIIlIlIIllIll.down()).getBlock() == Blocks.REEDS || this.checkForDrop(llllllllllllllIlIIllIIlIlIIlllII, llllllllllllllIlIIllIIlIlIIllIll, llllllllllllllIlIIllIIlIlIIllIlI)) && llllllllllllllIlIIllIIlIlIIlllII.isAirBlock(llllllllllllllIlIIllIIlIlIIllIll.up())) {
            int llllllllllllllIlIIllIIlIlIIlllll;
            for (llllllllllllllIlIIllIIlIlIIlllll = 1; llllllllllllllIlIIllIIlIlIIlllII.getBlockState(llllllllllllllIlIIllIIlIlIIllIll.down(llllllllllllllIlIIllIIlIlIIlllll)).getBlock() == this; ++llllllllllllllIlIIllIIlIlIIlllll) {}
            if (llllllllllllllIlIIllIIlIlIIlllll < 3) {
                final int llllllllllllllIlIIllIIlIlIIllllI = llllllllllllllIlIIllIIlIlIIllIlI.getValue((IProperty<Integer>)BlockReed.AGE);
                if (llllllllllllllIlIIllIIlIlIIllllI == 15) {
                    llllllllllllllIlIIllIIlIlIIlllII.setBlockState(llllllllllllllIlIIllIIlIlIIllIll.up(), this.getDefaultState());
                    llllllllllllllIlIIllIIlIlIIlllII.setBlockState(llllllllllllllIlIIllIIlIlIIllIll, llllllllllllllIlIIllIIlIlIIllIlI.withProperty((IProperty<Comparable>)BlockReed.AGE, 0), 4);
                }
                else {
                    llllllllllllllIlIIllIIlIlIIlllII.setBlockState(llllllllllllllIlIIllIIlIlIIllIll, llllllllllllllIlIIllIIlIlIIllIlI.withProperty((IProperty<Comparable>)BlockReed.AGE, llllllllllllllIlIIllIIlIlIIllllI + 1), 4);
                }
            }
        }
    }
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllllllIlIIllIIlIIlIllIII, final Random llllllllllllllIlIIllIIlIIlIlIlll, final int llllllllllllllIlIIllIIlIIlIlIllI) {
        return Items.REEDS;
    }
    
    public boolean canBlockStay(final World llllllllllllllIlIIllIIlIIlIlllll, final BlockPos llllllllllllllIlIIllIIlIIllIIIIl) {
        return this.canPlaceBlockAt(llllllllllllllIlIIllIIlIIlIlllll, llllllllllllllIlIIllIIlIIllIIIIl);
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllllIlIIllIIlIIlIIlIIl) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockReed.AGE, llllllllllllllIlIIllIIlIIlIIlIIl);
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess llllllllllllllIlIIllIIlIIIlllIll, final IBlockState llllllllllllllIlIIllIIlIIIlllIlI, final BlockPos llllllllllllllIlIIllIIlIIIlllIIl, final EnumFacing llllllllllllllIlIIllIIlIIIlllIII) {
        return BlockFaceShape.UNDEFINED;
    }
    
    protected BlockReed() {
        super(Material.PLANTS);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockReed.AGE, 0));
        this.setTickRandomly(true);
    }
}
