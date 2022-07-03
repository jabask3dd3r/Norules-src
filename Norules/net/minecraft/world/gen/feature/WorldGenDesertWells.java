package net.minecraft.world.gen.feature;

import net.minecraft.block.state.*;
import net.minecraft.block.state.pattern.*;
import net.minecraft.init.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.*;
import com.google.common.base.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.util.*;
import java.util.*;

public class WorldGenDesertWells extends WorldGenerator
{
    private final /* synthetic */ IBlockState sandSlab;
    private static final /* synthetic */ BlockStateMatcher IS_SAND;
    private final /* synthetic */ IBlockState water;
    private final /* synthetic */ IBlockState sandstone;
    
    public WorldGenDesertWells() {
        this.sandSlab = Blocks.STONE_SLAB.getDefaultState().withProperty(BlockStoneSlab.VARIANT, BlockStoneSlab.EnumType.SAND).withProperty(BlockSlab.HALF, BlockSlab.EnumBlockHalf.BOTTOM);
        this.sandstone = Blocks.SANDSTONE.getDefaultState();
        this.water = Blocks.FLOWING_WATER.getDefaultState();
    }
    
    static {
        IS_SAND = BlockStateMatcher.forBlock(Blocks.SAND).where(BlockSand.VARIANT, (com.google.common.base.Predicate<? extends BlockSand.EnumType>)Predicates.equalTo((Object)BlockSand.EnumType.SAND));
    }
    
    @Override
    public boolean generate(final World lllllllllllllIIlIIlIllIllllIlIlI, final Random lllllllllllllIIlIIlIllIllllIlIIl, BlockPos lllllllllllllIIlIIlIllIlllIllIlI) {
        while (lllllllllllllIIlIIlIllIllllIlIlI.isAirBlock(lllllllllllllIIlIIlIllIlllIllIlI) && lllllllllllllIIlIIlIllIlllIllIlI.getY() > 2) {
            lllllllllllllIIlIIlIllIlllIllIlI = lllllllllllllIIlIIlIllIlllIllIlI.down();
        }
        if (!WorldGenDesertWells.IS_SAND.apply(lllllllllllllIIlIIlIllIllllIlIlI.getBlockState(lllllllllllllIIlIIlIllIlllIllIlI))) {
            return false;
        }
        for (int lllllllllllllIIlIIlIllIllllIIlll = -2; lllllllllllllIIlIIlIllIllllIIlll <= 2; ++lllllllllllllIIlIIlIllIllllIIlll) {
            for (int lllllllllllllIIlIIlIllIllllIIllI = -2; lllllllllllllIIlIIlIllIllllIIllI <= 2; ++lllllllllllllIIlIIlIllIllllIIllI) {
                if (lllllllllllllIIlIIlIllIllllIlIlI.isAirBlock(lllllllllllllIIlIIlIllIlllIllIlI.add(lllllllllllllIIlIIlIllIllllIIlll, -1, lllllllllllllIIlIIlIllIllllIIllI)) && lllllllllllllIIlIIlIllIllllIlIlI.isAirBlock(lllllllllllllIIlIIlIllIlllIllIlI.add(lllllllllllllIIlIIlIllIllllIIlll, -2, lllllllllllllIIlIIlIllIllllIIllI))) {
                    return false;
                }
            }
        }
        for (int lllllllllllllIIlIIlIllIllllIIlIl = -1; lllllllllllllIIlIIlIllIllllIIlIl <= 0; ++lllllllllllllIIlIIlIllIllllIIlIl) {
            for (int lllllllllllllIIlIIlIllIllllIIlII = -2; lllllllllllllIIlIIlIllIllllIIlII <= 2; ++lllllllllllllIIlIIlIllIllllIIlII) {
                for (int lllllllllllllIIlIIlIllIllllIIIll = -2; lllllllllllllIIlIIlIllIllllIIIll <= 2; ++lllllllllllllIIlIIlIllIllllIIIll) {
                    lllllllllllllIIlIIlIllIllllIlIlI.setBlockState(lllllllllllllIIlIIlIllIlllIllIlI.add(lllllllllllllIIlIIlIllIllllIIlII, lllllllllllllIIlIIlIllIllllIIlIl, lllllllllllllIIlIIlIllIllllIIIll), this.sandstone, 2);
                }
            }
        }
        lllllllllllllIIlIIlIllIllllIlIlI.setBlockState(lllllllllllllIIlIIlIllIlllIllIlI, this.water, 2);
        for (final EnumFacing lllllllllllllIIlIIlIllIllllIIIlI : EnumFacing.Plane.HORIZONTAL) {
            lllllllllllllIIlIIlIllIllllIlIlI.setBlockState(lllllllllllllIIlIIlIllIlllIllIlI.offset(lllllllllllllIIlIIlIllIllllIIIlI), this.water, 2);
        }
        for (int lllllllllllllIIlIIlIllIllllIIIIl = -2; lllllllllllllIIlIIlIllIllllIIIIl <= 2; ++lllllllllllllIIlIIlIllIllllIIIIl) {
            for (int lllllllllllllIIlIIlIllIllllIIIII = -2; lllllllllllllIIlIIlIllIllllIIIII <= 2; ++lllllllllllllIIlIIlIllIllllIIIII) {
                if (lllllllllllllIIlIIlIllIllllIIIIl == -2 || lllllllllllllIIlIIlIllIllllIIIIl == 2 || lllllllllllllIIlIIlIllIllllIIIII == -2 || lllllllllllllIIlIIlIllIllllIIIII == 2) {
                    lllllllllllllIIlIIlIllIllllIlIlI.setBlockState(lllllllllllllIIlIIlIllIlllIllIlI.add(lllllllllllllIIlIIlIllIllllIIIIl, 1, lllllllllllllIIlIIlIllIllllIIIII), this.sandstone, 2);
                }
            }
        }
        lllllllllllllIIlIIlIllIllllIlIlI.setBlockState(lllllllllllllIIlIIlIllIlllIllIlI.add(2, 1, 0), this.sandSlab, 2);
        lllllllllllllIIlIIlIllIllllIlIlI.setBlockState(lllllllllllllIIlIIlIllIlllIllIlI.add(-2, 1, 0), this.sandSlab, 2);
        lllllllllllllIIlIIlIllIllllIlIlI.setBlockState(lllllllllllllIIlIIlIllIlllIllIlI.add(0, 1, 2), this.sandSlab, 2);
        lllllllllllllIIlIIlIllIllllIlIlI.setBlockState(lllllllllllllIIlIIlIllIlllIllIlI.add(0, 1, -2), this.sandSlab, 2);
        for (int lllllllllllllIIlIIlIllIlllIlllll = -1; lllllllllllllIIlIIlIllIlllIlllll <= 1; ++lllllllllllllIIlIIlIllIlllIlllll) {
            for (int lllllllllllllIIlIIlIllIlllIllllI = -1; lllllllllllllIIlIIlIllIlllIllllI <= 1; ++lllllllllllllIIlIIlIllIlllIllllI) {
                if (lllllllllllllIIlIIlIllIlllIlllll == 0 && lllllllllllllIIlIIlIllIlllIllllI == 0) {
                    lllllllllllllIIlIIlIllIllllIlIlI.setBlockState(lllllllllllllIIlIIlIllIlllIllIlI.add(lllllllllllllIIlIIlIllIlllIlllll, 4, lllllllllllllIIlIIlIllIlllIllllI), this.sandstone, 2);
                }
                else {
                    lllllllllllllIIlIIlIllIllllIlIlI.setBlockState(lllllllllllllIIlIIlIllIlllIllIlI.add(lllllllllllllIIlIIlIllIlllIlllll, 4, lllllllllllllIIlIIlIllIlllIllllI), this.sandSlab, 2);
                }
            }
        }
        for (int lllllllllllllIIlIIlIllIlllIlllIl = 1; lllllllllllllIIlIIlIllIlllIlllIl <= 3; ++lllllllllllllIIlIIlIllIlllIlllIl) {
            lllllllllllllIIlIIlIllIllllIlIlI.setBlockState(lllllllllllllIIlIIlIllIlllIllIlI.add(-1, lllllllllllllIIlIIlIllIlllIlllIl, -1), this.sandstone, 2);
            lllllllllllllIIlIIlIllIllllIlIlI.setBlockState(lllllllllllllIIlIIlIllIlllIllIlI.add(-1, lllllllllllllIIlIIlIllIlllIlllIl, 1), this.sandstone, 2);
            lllllllllllllIIlIIlIllIllllIlIlI.setBlockState(lllllllllllllIIlIIlIllIlllIllIlI.add(1, lllllllllllllIIlIIlIllIlllIlllIl, -1), this.sandstone, 2);
            lllllllllllllIIlIIlIllIllllIlIlI.setBlockState(lllllllllllllIIlIIlIllIlllIllIlI.add(1, lllllllllllllIIlIIlIllIlllIlllIl, 1), this.sandstone, 2);
        }
        return true;
    }
}
