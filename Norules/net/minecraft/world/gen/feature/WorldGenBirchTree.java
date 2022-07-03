package net.minecraft.world.gen.feature;

import net.minecraft.block.state.*;
import net.minecraft.init.*;
import net.minecraft.block.properties.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.math.*;
import net.minecraft.block.material.*;
import net.minecraft.block.*;

public class WorldGenBirchTree extends WorldGenAbstractTree
{
    private static final /* synthetic */ IBlockState LOG;
    private final /* synthetic */ boolean useExtraRandomHeight;
    private static final /* synthetic */ IBlockState LEAF;
    
    static {
        LOG = Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.BIRCH);
        LEAF = Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.BIRCH).withProperty((IProperty<Comparable>)BlockOldLeaf.CHECK_DECAY, false);
    }
    
    public WorldGenBirchTree(final boolean lllllllllllllIIIIIlIIIlIlIIIIllI, final boolean lllllllllllllIIIIIlIIIlIlIIIlIII) {
        super(lllllllllllllIIIIIlIIIlIlIIIIllI);
        this.useExtraRandomHeight = lllllllllllllIIIIIlIIIlIlIIIlIII;
    }
    
    @Override
    public boolean generate(final World lllllllllllllIIIIIlIIIlIIlllIIll, final Random lllllllllllllIIIIIlIIIlIIlllIIlI, final BlockPos lllllllllllllIIIIIlIIIlIIlIllIlI) {
        int lllllllllllllIIIIIlIIIlIIlllIIII = lllllllllllllIIIIIlIIIlIIlllIIlI.nextInt(3) + 5;
        if (this.useExtraRandomHeight) {
            lllllllllllllIIIIIlIIIlIIlllIIII += lllllllllllllIIIIIlIIIlIIlllIIlI.nextInt(7);
        }
        boolean lllllllllllllIIIIIlIIIlIIllIllll = true;
        if (lllllllllllllIIIIIlIIIlIIlIllIlI.getY() < 1 || lllllllllllllIIIIIlIIIlIIlIllIlI.getY() + lllllllllllllIIIIIlIIIlIIlllIIII + 1 > 256) {
            return false;
        }
        for (int lllllllllllllIIIIIlIIIlIIllIlllI = lllllllllllllIIIIIlIIIlIIlIllIlI.getY(); lllllllllllllIIIIIlIIIlIIllIlllI <= lllllllllllllIIIIIlIIIlIIlIllIlI.getY() + 1 + lllllllllllllIIIIIlIIIlIIlllIIII; ++lllllllllllllIIIIIlIIIlIIllIlllI) {
            int lllllllllllllIIIIIlIIIlIIllIllIl = 1;
            if (lllllllllllllIIIIIlIIIlIIllIlllI == lllllllllllllIIIIIlIIIlIIlIllIlI.getY()) {
                lllllllllllllIIIIIlIIIlIIllIllIl = 0;
            }
            if (lllllllllllllIIIIIlIIIlIIllIlllI >= lllllllllllllIIIIIlIIIlIIlIllIlI.getY() + 1 + lllllllllllllIIIIIlIIIlIIlllIIII - 2) {
                lllllllllllllIIIIIlIIIlIIllIllIl = 2;
            }
            final BlockPos.MutableBlockPos lllllllllllllIIIIIlIIIlIIllIllII = new BlockPos.MutableBlockPos();
            for (int lllllllllllllIIIIIlIIIlIIllIlIll = lllllllllllllIIIIIlIIIlIIlIllIlI.getX() - lllllllllllllIIIIIlIIIlIIllIllIl; lllllllllllllIIIIIlIIIlIIllIlIll <= lllllllllllllIIIIIlIIIlIIlIllIlI.getX() + lllllllllllllIIIIIlIIIlIIllIllIl && lllllllllllllIIIIIlIIIlIIllIllll; ++lllllllllllllIIIIIlIIIlIIllIlIll) {
                for (int lllllllllllllIIIIIlIIIlIIllIlIlI = lllllllllllllIIIIIlIIIlIIlIllIlI.getZ() - lllllllllllllIIIIIlIIIlIIllIllIl; lllllllllllllIIIIIlIIIlIIllIlIlI <= lllllllllllllIIIIIlIIIlIIlIllIlI.getZ() + lllllllllllllIIIIIlIIIlIIllIllIl && lllllllllllllIIIIIlIIIlIIllIllll; ++lllllllllllllIIIIIlIIIlIIllIlIlI) {
                    if (lllllllllllllIIIIIlIIIlIIllIlllI >= 0 && lllllllllllllIIIIIlIIIlIIllIlllI < 256) {
                        if (!this.canGrowInto(lllllllllllllIIIIIlIIIlIIlllIIll.getBlockState(lllllllllllllIIIIIlIIIlIIllIllII.setPos(lllllllllllllIIIIIlIIIlIIllIlIll, lllllllllllllIIIIIlIIIlIIllIlllI, lllllllllllllIIIIIlIIIlIIllIlIlI)).getBlock())) {
                            lllllllllllllIIIIIlIIIlIIllIllll = false;
                        }
                    }
                    else {
                        lllllllllllllIIIIIlIIIlIIllIllll = false;
                    }
                }
            }
        }
        if (!lllllllllllllIIIIIlIIIlIIllIllll) {
            return false;
        }
        final Block lllllllllllllIIIIIlIIIlIIllIlIIl = lllllllllllllIIIIIlIIIlIIlllIIll.getBlockState(lllllllllllllIIIIIlIIIlIIlIllIlI.down()).getBlock();
        if ((lllllllllllllIIIIIlIIIlIIllIlIIl == Blocks.GRASS || lllllllllllllIIIIIlIIIlIIllIlIIl == Blocks.DIRT || lllllllllllllIIIIIlIIIlIIllIlIIl == Blocks.FARMLAND) && lllllllllllllIIIIIlIIIlIIlIllIlI.getY() < 256 - lllllllllllllIIIIIlIIIlIIlllIIII - 1) {
            this.setDirtAt(lllllllllllllIIIIIlIIIlIIlllIIll, lllllllllllllIIIIIlIIIlIIlIllIlI.down());
            for (int lllllllllllllIIIIIlIIIlIIllIlIII = lllllllllllllIIIIIlIIIlIIlIllIlI.getY() - 3 + lllllllllllllIIIIIlIIIlIIlllIIII; lllllllllllllIIIIIlIIIlIIllIlIII <= lllllllllllllIIIIIlIIIlIIlIllIlI.getY() + lllllllllllllIIIIIlIIIlIIlllIIII; ++lllllllllllllIIIIIlIIIlIIllIlIII) {
                final int lllllllllllllIIIIIlIIIlIIllIIlll = lllllllllllllIIIIIlIIIlIIllIlIII - (lllllllllllllIIIIIlIIIlIIlIllIlI.getY() + lllllllllllllIIIIIlIIIlIIlllIIII);
                for (int lllllllllllllIIIIIlIIIlIIllIIllI = 1 - lllllllllllllIIIIIlIIIlIIllIIlll / 2, lllllllllllllIIIIIlIIIlIIllIIlIl = lllllllllllllIIIIIlIIIlIIlIllIlI.getX() - lllllllllllllIIIIIlIIIlIIllIIllI; lllllllllllllIIIIIlIIIlIIllIIlIl <= lllllllllllllIIIIIlIIIlIIlIllIlI.getX() + lllllllllllllIIIIIlIIIlIIllIIllI; ++lllllllllllllIIIIIlIIIlIIllIIlIl) {
                    final int lllllllllllllIIIIIlIIIlIIllIIlII = lllllllllllllIIIIIlIIIlIIllIIlIl - lllllllllllllIIIIIlIIIlIIlIllIlI.getX();
                    for (int lllllllllllllIIIIIlIIIlIIllIIIll = lllllllllllllIIIIIlIIIlIIlIllIlI.getZ() - lllllllllllllIIIIIlIIIlIIllIIllI; lllllllllllllIIIIIlIIIlIIllIIIll <= lllllllllllllIIIIIlIIIlIIlIllIlI.getZ() + lllllllllllllIIIIIlIIIlIIllIIllI; ++lllllllllllllIIIIIlIIIlIIllIIIll) {
                        final int lllllllllllllIIIIIlIIIlIIllIIIlI = lllllllllllllIIIIIlIIIlIIllIIIll - lllllllllllllIIIIIlIIIlIIlIllIlI.getZ();
                        if (Math.abs(lllllllllllllIIIIIlIIIlIIllIIlII) != lllllllllllllIIIIIlIIIlIIllIIllI || Math.abs(lllllllllllllIIIIIlIIIlIIllIIIlI) != lllllllllllllIIIIIlIIIlIIllIIllI || (lllllllllllllIIIIIlIIIlIIlllIIlI.nextInt(2) != 0 && lllllllllllllIIIIIlIIIlIIllIIlll != 0)) {
                            final BlockPos lllllllllllllIIIIIlIIIlIIllIIIIl = new BlockPos(lllllllllllllIIIIIlIIIlIIllIIlIl, lllllllllllllIIIIIlIIIlIIllIlIII, lllllllllllllIIIIIlIIIlIIllIIIll);
                            final Material lllllllllllllIIIIIlIIIlIIllIIIII = lllllllllllllIIIIIlIIIlIIlllIIll.getBlockState(lllllllllllllIIIIIlIIIlIIllIIIIl).getMaterial();
                            if (lllllllllllllIIIIIlIIIlIIllIIIII == Material.AIR || lllllllllllllIIIIIlIIIlIIllIIIII == Material.LEAVES) {
                                this.setBlockAndNotifyAdequately(lllllllllllllIIIIIlIIIlIIlllIIll, lllllllllllllIIIIIlIIIlIIllIIIIl, WorldGenBirchTree.LEAF);
                            }
                        }
                    }
                }
            }
            for (int lllllllllllllIIIIIlIIIlIIlIlllll = 0; lllllllllllllIIIIIlIIIlIIlIlllll < lllllllllllllIIIIIlIIIlIIlllIIII; ++lllllllllllllIIIIIlIIIlIIlIlllll) {
                final Material lllllllllllllIIIIIlIIIlIIlIllllI = lllllllllllllIIIIIlIIIlIIlllIIll.getBlockState(lllllllllllllIIIIIlIIIlIIlIllIlI.up(lllllllllllllIIIIIlIIIlIIlIlllll)).getMaterial();
                if (lllllllllllllIIIIIlIIIlIIlIllllI == Material.AIR || lllllllllllllIIIIIlIIIlIIlIllllI == Material.LEAVES) {
                    this.setBlockAndNotifyAdequately(lllllllllllllIIIIIlIIIlIIlllIIll, lllllllllllllIIIIIlIIIlIIlIllIlI.up(lllllllllllllIIIIIlIIIlIIlIlllll), WorldGenBirchTree.LOG);
                }
            }
            return true;
        }
        return false;
    }
}
