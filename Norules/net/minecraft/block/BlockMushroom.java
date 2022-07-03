package net.minecraft.block;

import net.minecraft.util.math.*;
import net.minecraft.block.state.*;
import net.minecraft.init.*;
import net.minecraft.block.properties.*;
import java.util.*;
import net.minecraft.world.*;
import net.minecraft.world.gen.feature.*;

public class BlockMushroom extends BlockBush implements IGrowable
{
    protected static final /* synthetic */ AxisAlignedBB MUSHROOM_AABB;
    
    @Override
    public boolean canPlaceBlockAt(final World lllllllllllllllIIIlIllIllIIlllIl, final BlockPos lllllllllllllllIIIlIllIllIIlllll) {
        return super.canPlaceBlockAt(lllllllllllllllIIIlIllIllIIlllIl, lllllllllllllllIIIlIllIllIIlllll) && this.canBlockStay(lllllllllllllllIIIlIllIllIIlllIl, lllllllllllllllIIIlIllIllIIlllll, this.getDefaultState());
    }
    
    @Override
    public boolean canGrow(final World lllllllllllllllIIIlIllIlIlllIlll, final BlockPos lllllllllllllllIIIlIllIlIlllIllI, final IBlockState lllllllllllllllIIIlIllIlIlllIlIl, final boolean lllllllllllllllIIIlIllIlIlllIlII) {
        return true;
    }
    
    protected BlockMushroom() {
        this.setTickRandomly(true);
    }
    
    @Override
    public boolean canBlockStay(final World lllllllllllllllIIIlIllIllIIIllIl, final BlockPos lllllllllllllllIIIlIllIllIIIllII, final IBlockState lllllllllllllllIIIlIllIllIIlIIII) {
        if (lllllllllllllllIIIlIllIllIIIllII.getY() >= 0 && lllllllllllllllIIIlIllIllIIIllII.getY() < 256) {
            final IBlockState lllllllllllllllIIIlIllIllIIIllll = lllllllllllllllIIIlIllIllIIIllIl.getBlockState(lllllllllllllllIIIlIllIllIIIllII.down());
            return lllllllllllllllIIIlIllIllIIIllll.getBlock() == Blocks.MYCELIUM || (lllllllllllllllIIIlIllIllIIIllll.getBlock() == Blocks.DIRT && lllllllllllllllIIIlIllIllIIIllll.getValue(BlockDirt.VARIANT) == BlockDirt.DirtType.PODZOL) || (lllllllllllllllIIIlIllIllIIIllIl.getLight(lllllllllllllllIIIlIllIllIIIllII) < 13 && this.canSustainBush(lllllllllllllllIIIlIllIllIIIllll));
        }
        return false;
    }
    
    @Override
    public boolean canUseBonemeal(final World lllllllllllllllIIIlIllIlIlllIIIl, final Random lllllllllllllllIIIlIllIlIllIllIl, final BlockPos lllllllllllllllIIIlIllIlIllIllll, final IBlockState lllllllllllllllIIIlIllIlIllIlllI) {
        return lllllllllllllllIIIlIllIlIllIllIl.nextFloat() < 0.4;
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllllllIIIlIllIlllIIIIIl, final IBlockAccess lllllllllllllllIIIlIllIlllIIIIII, final BlockPos lllllllllllllllIIIlIllIllIllllll) {
        return BlockMushroom.MUSHROOM_AABB;
    }
    
    @Override
    public void grow(final World lllllllllllllllIIIlIllIlIllIIllI, final Random lllllllllllllllIIIlIllIlIllIIIII, final BlockPos lllllllllllllllIIIlIllIlIlIlllll, final IBlockState lllllllllllllllIIIlIllIlIllIIIll) {
        this.generateBigMushroom(lllllllllllllllIIIlIllIlIllIIllI, lllllllllllllllIIIlIllIlIlIlllll, lllllllllllllllIIIlIllIlIllIIIll, lllllllllllllllIIIlIllIlIllIIIII);
    }
    
    @Override
    protected boolean canSustainBush(final IBlockState lllllllllllllllIIIlIllIllIIllIII) {
        return lllllllllllllllIIIlIllIllIIllIII.isFullBlock();
    }
    
    static {
        MUSHROOM_AABB = new AxisAlignedBB(0.30000001192092896, 0.0, 0.30000001192092896, 0.699999988079071, 0.4000000059604645, 0.699999988079071);
    }
    
    @Override
    public void updateTick(final World lllllllllllllllIIIlIllIllIlIlIll, BlockPos lllllllllllllllIIIlIllIllIlIlIlI, final IBlockState lllllllllllllllIIIlIllIllIllIIll, final Random lllllllllllllllIIIlIllIllIllIIlI) {
        if (lllllllllllllllIIIlIllIllIllIIlI.nextInt(25) == 0) {
            int lllllllllllllllIIIlIllIllIllIIIl = 5;
            final int lllllllllllllllIIIlIllIllIllIIII = 4;
            for (final BlockPos lllllllllllllllIIIlIllIllIlIllll : BlockPos.getAllInBoxMutable(((BlockPos)lllllllllllllllIIIlIllIllIlIlIlI).add(-4, -1, -4), ((BlockPos)lllllllllllllllIIIlIllIllIlIlIlI).add(4, 1, 4))) {
                if (lllllllllllllllIIIlIllIllIlIlIll.getBlockState(lllllllllllllllIIIlIllIllIlIllll).getBlock() == this && --lllllllllllllllIIIlIllIllIllIIIl <= 0) {
                    return;
                }
            }
            BlockPos lllllllllllllllIIIlIllIllIlIlllI = ((BlockPos)lllllllllllllllIIIlIllIllIlIlIlI).add(lllllllllllllllIIIlIllIllIllIIlI.nextInt(3) - 1, lllllllllllllllIIIlIllIllIllIIlI.nextInt(2) - lllllllllllllllIIIlIllIllIllIIlI.nextInt(2), lllllllllllllllIIIlIllIllIllIIlI.nextInt(3) - 1);
            for (int lllllllllllllllIIIlIllIllIlIllIl = 0; lllllllllllllllIIIlIllIllIlIllIl < 4; ++lllllllllllllllIIIlIllIllIlIllIl) {
                if (lllllllllllllllIIIlIllIllIlIlIll.isAirBlock(lllllllllllllllIIIlIllIllIlIlllI) && this.canBlockStay(lllllllllllllllIIIlIllIllIlIlIll, lllllllllllllllIIIlIllIllIlIlllI, this.getDefaultState())) {
                    lllllllllllllllIIIlIllIllIlIlIlI = lllllllllllllllIIIlIllIllIlIlllI;
                }
                lllllllllllllllIIIlIllIllIlIlllI = ((BlockPos)lllllllllllllllIIIlIllIllIlIlIlI).add(lllllllllllllllIIIlIllIllIllIIlI.nextInt(3) - 1, lllllllllllllllIIIlIllIllIllIIlI.nextInt(2) - lllllllllllllllIIIlIllIllIllIIlI.nextInt(2), lllllllllllllllIIIlIllIllIllIIlI.nextInt(3) - 1);
            }
            if (lllllllllllllllIIIlIllIllIlIlIll.isAirBlock(lllllllllllllllIIIlIllIllIlIlllI) && this.canBlockStay(lllllllllllllllIIIlIllIllIlIlIll, lllllllllllllllIIIlIllIllIlIlllI, this.getDefaultState())) {
                lllllllllllllllIIIlIllIllIlIlIll.setBlockState(lllllllllllllllIIIlIllIllIlIlllI, this.getDefaultState(), 2);
            }
        }
    }
    
    public boolean generateBigMushroom(final World lllllllllllllllIIIlIllIlIlllllIl, final BlockPos lllllllllllllllIIIlIllIlIlllllII, final IBlockState lllllllllllllllIIIlIllIllIIIIIIl, final Random lllllllllllllllIIIlIllIlIllllIlI) {
        lllllllllllllllIIIlIllIlIlllllIl.setBlockToAir(lllllllllllllllIIIlIllIlIlllllII);
        WorldGenerator lllllllllllllllIIIlIllIlIlllllll = null;
        if (this == Blocks.BROWN_MUSHROOM) {
            lllllllllllllllIIIlIllIlIlllllll = new WorldGenBigMushroom(Blocks.BROWN_MUSHROOM_BLOCK);
        }
        else if (this == Blocks.RED_MUSHROOM) {
            lllllllllllllllIIIlIllIlIlllllll = new WorldGenBigMushroom(Blocks.RED_MUSHROOM_BLOCK);
        }
        if (lllllllllllllllIIIlIllIlIlllllll != null && lllllllllllllllIIIlIllIlIlllllll.generate(lllllllllllllllIIIlIllIlIlllllIl, lllllllllllllllIIIlIllIlIllllIlI, lllllllllllllllIIIlIllIlIlllllII)) {
            return true;
        }
        lllllllllllllllIIIlIllIlIlllllIl.setBlockState(lllllllllllllllIIIlIllIlIlllllII, lllllllllllllllIIIlIllIllIIIIIIl, 3);
        return false;
    }
}
