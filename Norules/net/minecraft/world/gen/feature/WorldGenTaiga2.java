package net.minecraft.world.gen.feature;

import net.minecraft.block.state.*;
import net.minecraft.init.*;
import net.minecraft.block.properties.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.math.*;
import net.minecraft.block.material.*;
import net.minecraft.block.*;

public class WorldGenTaiga2 extends WorldGenAbstractTree
{
    private static final /* synthetic */ IBlockState LEAF;
    private static final /* synthetic */ IBlockState TRUNK;
    
    static {
        TRUNK = Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE);
        LEAF = Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.SPRUCE).withProperty((IProperty<Comparable>)BlockLeaves.CHECK_DECAY, false);
    }
    
    @Override
    public boolean generate(final World lllllllllllllllllIlllllIIIlIlIIl, final Random lllllllllllllllllIlllllIIIIIlIlI, final BlockPos lllllllllllllllllIlllllIIIIIlIIl) {
        final int lllllllllllllllllIlllllIIIlIIllI = lllllllllllllllllIlllllIIIIIlIlI.nextInt(4) + 6;
        final int lllllllllllllllllIlllllIIIlIIlIl = 1 + lllllllllllllllllIlllllIIIIIlIlI.nextInt(2);
        final int lllllllllllllllllIlllllIIIlIIlII = lllllllllllllllllIlllllIIIlIIllI - lllllllllllllllllIlllllIIIlIIlIl;
        final int lllllllllllllllllIlllllIIIlIIIll = 2 + lllllllllllllllllIlllllIIIIIlIlI.nextInt(2);
        boolean lllllllllllllllllIlllllIIIlIIIlI = true;
        if (lllllllllllllllllIlllllIIIIIlIIl.getY() < 1 || lllllllllllllllllIlllllIIIIIlIIl.getY() + lllllllllllllllllIlllllIIIlIIllI + 1 > 256) {
            return false;
        }
        for (int lllllllllllllllllIlllllIIIlIIIIl = lllllllllllllllllIlllllIIIIIlIIl.getY(); lllllllllllllllllIlllllIIIlIIIIl <= lllllllllllllllllIlllllIIIIIlIIl.getY() + 1 + lllllllllllllllllIlllllIIIlIIllI && lllllllllllllllllIlllllIIIlIIIlI; ++lllllllllllllllllIlllllIIIlIIIIl) {
            int lllllllllllllllllIlllllIIIIlllll = 0;
            if (lllllllllllllllllIlllllIIIlIIIIl - lllllllllllllllllIlllllIIIIIlIIl.getY() < lllllllllllllllllIlllllIIIlIIlIl) {
                final int lllllllllllllllllIlllllIIIlIIIII = 0;
            }
            else {
                lllllllllllllllllIlllllIIIIlllll = lllllllllllllllllIlllllIIIlIIIll;
            }
            final BlockPos.MutableBlockPos lllllllllllllllllIlllllIIIIllllI = new BlockPos.MutableBlockPos();
            for (int lllllllllllllllllIlllllIIIIlllIl = lllllllllllllllllIlllllIIIIIlIIl.getX() - lllllllllllllllllIlllllIIIIlllll; lllllllllllllllllIlllllIIIIlllIl <= lllllllllllllllllIlllllIIIIIlIIl.getX() + lllllllllllllllllIlllllIIIIlllll && lllllllllllllllllIlllllIIIlIIIlI; ++lllllllllllllllllIlllllIIIIlllIl) {
                for (int lllllllllllllllllIlllllIIIIlllII = lllllllllllllllllIlllllIIIIIlIIl.getZ() - lllllllllllllllllIlllllIIIIlllll; lllllllllllllllllIlllllIIIIlllII <= lllllllllllllllllIlllllIIIIIlIIl.getZ() + lllllllllllllllllIlllllIIIIlllll && lllllllllllllllllIlllllIIIlIIIlI; ++lllllllllllllllllIlllllIIIIlllII) {
                    if (lllllllllllllllllIlllllIIIlIIIIl >= 0 && lllllllllllllllllIlllllIIIlIIIIl < 256) {
                        final Material lllllllllllllllllIlllllIIIIllIll = lllllllllllllllllIlllllIIIlIlIIl.getBlockState(lllllllllllllllllIlllllIIIIllllI.setPos(lllllllllllllllllIlllllIIIIlllIl, lllllllllllllllllIlllllIIIlIIIIl, lllllllllllllllllIlllllIIIIlllII)).getMaterial();
                        if (lllllllllllllllllIlllllIIIIllIll != Material.AIR && lllllllllllllllllIlllllIIIIllIll != Material.LEAVES) {
                            lllllllllllllllllIlllllIIIlIIIlI = false;
                        }
                    }
                    else {
                        lllllllllllllllllIlllllIIIlIIIlI = false;
                    }
                }
            }
        }
        if (!lllllllllllllllllIlllllIIIlIIIlI) {
            return false;
        }
        final Block lllllllllllllllllIlllllIIIIllIlI = lllllllllllllllllIlllllIIIlIlIIl.getBlockState(lllllllllllllllllIlllllIIIIIlIIl.down()).getBlock();
        if ((lllllllllllllllllIlllllIIIIllIlI == Blocks.GRASS || lllllllllllllllllIlllllIIIIllIlI == Blocks.DIRT || lllllllllllllllllIlllllIIIIllIlI == Blocks.FARMLAND) && lllllllllllllllllIlllllIIIIIlIIl.getY() < 256 - lllllllllllllllllIlllllIIIlIIllI - 1) {
            this.setDirtAt(lllllllllllllllllIlllllIIIlIlIIl, lllllllllllllllllIlllllIIIIIlIIl.down());
            int lllllllllllllllllIlllllIIIIllIIl = lllllllllllllllllIlllllIIIIIlIlI.nextInt(2);
            int lllllllllllllllllIlllllIIIIllIII = 1;
            int lllllllllllllllllIlllllIIIIlIlll = 0;
            for (int lllllllllllllllllIlllllIIIIlIllI = 0; lllllllllllllllllIlllllIIIIlIllI <= lllllllllllllllllIlllllIIIlIIlII; ++lllllllllllllllllIlllllIIIIlIllI) {
                final int lllllllllllllllllIlllllIIIIlIlIl = lllllllllllllllllIlllllIIIIIlIIl.getY() + lllllllllllllllllIlllllIIIlIIllI - lllllllllllllllllIlllllIIIIlIllI;
                for (int lllllllllllllllllIlllllIIIIlIlII = lllllllllllllllllIlllllIIIIIlIIl.getX() - lllllllllllllllllIlllllIIIIllIIl; lllllllllllllllllIlllllIIIIlIlII <= lllllllllllllllllIlllllIIIIIlIIl.getX() + lllllllllllllllllIlllllIIIIllIIl; ++lllllllllllllllllIlllllIIIIlIlII) {
                    final int lllllllllllllllllIlllllIIIIlIIll = lllllllllllllllllIlllllIIIIlIlII - lllllllllllllllllIlllllIIIIIlIIl.getX();
                    for (int lllllllllllllllllIlllllIIIIlIIlI = lllllllllllllllllIlllllIIIIIlIIl.getZ() - lllllllllllllllllIlllllIIIIllIIl; lllllllllllllllllIlllllIIIIlIIlI <= lllllllllllllllllIlllllIIIIIlIIl.getZ() + lllllllllllllllllIlllllIIIIllIIl; ++lllllllllllllllllIlllllIIIIlIIlI) {
                        final int lllllllllllllllllIlllllIIIIlIIIl = lllllllllllllllllIlllllIIIIlIIlI - lllllllllllllllllIlllllIIIIIlIIl.getZ();
                        if (Math.abs(lllllllllllllllllIlllllIIIIlIIll) != lllllllllllllllllIlllllIIIIllIIl || Math.abs(lllllllllllllllllIlllllIIIIlIIIl) != lllllllllllllllllIlllllIIIIllIIl || lllllllllllllllllIlllllIIIIllIIl <= 0) {
                            final BlockPos lllllllllllllllllIlllllIIIIlIIII = new BlockPos(lllllllllllllllllIlllllIIIIlIlII, lllllllllllllllllIlllllIIIIlIlIl, lllllllllllllllllIlllllIIIIlIIlI);
                            if (!lllllllllllllllllIlllllIIIlIlIIl.getBlockState(lllllllllllllllllIlllllIIIIlIIII).isFullBlock()) {
                                this.setBlockAndNotifyAdequately(lllllllllllllllllIlllllIIIlIlIIl, lllllllllllllllllIlllllIIIIlIIII, WorldGenTaiga2.LEAF);
                            }
                        }
                    }
                }
                if (lllllllllllllllllIlllllIIIIllIIl >= lllllllllllllllllIlllllIIIIllIII) {
                    lllllllllllllllllIlllllIIIIllIIl = lllllllllllllllllIlllllIIIIlIlll;
                    lllllllllllllllllIlllllIIIIlIlll = 1;
                    if (++lllllllllllllllllIlllllIIIIllIII > lllllllllllllllllIlllllIIIlIIIll) {
                        lllllllllllllllllIlllllIIIIllIII = lllllllllllllllllIlllllIIIlIIIll;
                    }
                }
                else {
                    ++lllllllllllllllllIlllllIIIIllIIl;
                }
            }
            for (int lllllllllllllllllIlllllIIIIIllll = lllllllllllllllllIlllllIIIIIlIlI.nextInt(3), lllllllllllllllllIlllllIIIIIlllI = 0; lllllllllllllllllIlllllIIIIIlllI < lllllllllllllllllIlllllIIIlIIllI - lllllllllllllllllIlllllIIIIIllll; ++lllllllllllllllllIlllllIIIIIlllI) {
                final Material lllllllllllllllllIlllllIIIIIllIl = lllllllllllllllllIlllllIIIlIlIIl.getBlockState(lllllllllllllllllIlllllIIIIIlIIl.up(lllllllllllllllllIlllllIIIIIlllI)).getMaterial();
                if (lllllllllllllllllIlllllIIIIIllIl == Material.AIR || lllllllllllllllllIlllllIIIIIllIl == Material.LEAVES) {
                    this.setBlockAndNotifyAdequately(lllllllllllllllllIlllllIIIlIlIIl, lllllllllllllllllIlllllIIIIIlIIl.up(lllllllllllllllllIlllllIIIIIlllI), WorldGenTaiga2.TRUNK);
                }
            }
            return true;
        }
        return false;
    }
    
    public WorldGenTaiga2(final boolean lllllllllllllllllIlllllIIlIIIIIl) {
        super(lllllllllllllllllIlllllIIlIIIIIl);
    }
}
