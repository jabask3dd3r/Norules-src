package net.minecraft.world.gen.feature;

import net.minecraft.block.state.*;
import net.minecraft.init.*;
import net.minecraft.block.properties.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.math.*;
import net.minecraft.block.material.*;
import net.minecraft.block.*;

public class WorldGenTaiga1 extends WorldGenAbstractTree
{
    private static final /* synthetic */ IBlockState TRUNK;
    private static final /* synthetic */ IBlockState LEAF;
    
    public WorldGenTaiga1() {
        super(false);
    }
    
    static {
        TRUNK = Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE);
        LEAF = Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.SPRUCE).withProperty((IProperty<Comparable>)BlockLeaves.CHECK_DECAY, false);
    }
    
    @Override
    public boolean generate(final World lIIllIIlIlIIlI, final Random lIIllIIllIlIIl, final BlockPos lIIllIIlIlIIII) {
        final int lIIllIIllIIlll = lIIllIIllIlIIl.nextInt(5) + 7;
        final int lIIllIIllIIllI = lIIllIIllIIlll - lIIllIIllIlIIl.nextInt(2) - 3;
        final int lIIllIIllIIlIl = lIIllIIllIIlll - lIIllIIllIIllI;
        final int lIIllIIllIIlII = 1 + lIIllIIllIlIIl.nextInt(lIIllIIllIIlIl + 1);
        if (lIIllIIlIlIIII.getY() < 1 || lIIllIIlIlIIII.getY() + lIIllIIllIIlll + 1 > 256) {
            return false;
        }
        boolean lIIllIIllIIIll = true;
        for (int lIIllIIllIIIlI = lIIllIIlIlIIII.getY(); lIIllIIllIIIlI <= lIIllIIlIlIIII.getY() + 1 + lIIllIIllIIlll && lIIllIIllIIIll; ++lIIllIIllIIIlI) {
            int lIIllIIllIIIIl = 1;
            if (lIIllIIllIIIlI - lIIllIIlIlIIII.getY() < lIIllIIllIIllI) {
                lIIllIIllIIIIl = 0;
            }
            else {
                lIIllIIllIIIIl = lIIllIIllIIlII;
            }
            final BlockPos.MutableBlockPos lIIllIIllIIIII = new BlockPos.MutableBlockPos();
            for (int lIIllIIlIlllll = lIIllIIlIlIIII.getX() - lIIllIIllIIIIl; lIIllIIlIlllll <= lIIllIIlIlIIII.getX() + lIIllIIllIIIIl && lIIllIIllIIIll; ++lIIllIIlIlllll) {
                for (int lIIllIIlIllllI = lIIllIIlIlIIII.getZ() - lIIllIIllIIIIl; lIIllIIlIllllI <= lIIllIIlIlIIII.getZ() + lIIllIIllIIIIl && lIIllIIllIIIll; ++lIIllIIlIllllI) {
                    if (lIIllIIllIIIlI >= 0 && lIIllIIllIIIlI < 256) {
                        if (!this.canGrowInto(lIIllIIlIlIIlI.getBlockState(lIIllIIllIIIII.setPos(lIIllIIlIlllll, lIIllIIllIIIlI, lIIllIIlIllllI)).getBlock())) {
                            lIIllIIllIIIll = false;
                        }
                    }
                    else {
                        lIIllIIllIIIll = false;
                    }
                }
            }
        }
        if (!lIIllIIllIIIll) {
            return false;
        }
        final Block lIIllIIlIlllIl = lIIllIIlIlIIlI.getBlockState(lIIllIIlIlIIII.down()).getBlock();
        if ((lIIllIIlIlllIl == Blocks.GRASS || lIIllIIlIlllIl == Blocks.DIRT) && lIIllIIlIlIIII.getY() < 256 - lIIllIIllIIlll - 1) {
            this.setDirtAt(lIIllIIlIlIIlI, lIIllIIlIlIIII.down());
            int lIIllIIlIlllII = 0;
            for (int lIIllIIlIllIll = lIIllIIlIlIIII.getY() + lIIllIIllIIlll; lIIllIIlIllIll >= lIIllIIlIlIIII.getY() + lIIllIIllIIllI; --lIIllIIlIllIll) {
                for (int lIIllIIlIllIlI = lIIllIIlIlIIII.getX() - lIIllIIlIlllII; lIIllIIlIllIlI <= lIIllIIlIlIIII.getX() + lIIllIIlIlllII; ++lIIllIIlIllIlI) {
                    final int lIIllIIlIllIIl = lIIllIIlIllIlI - lIIllIIlIlIIII.getX();
                    for (int lIIllIIlIllIII = lIIllIIlIlIIII.getZ() - lIIllIIlIlllII; lIIllIIlIllIII <= lIIllIIlIlIIII.getZ() + lIIllIIlIlllII; ++lIIllIIlIllIII) {
                        final int lIIllIIlIlIlll = lIIllIIlIllIII - lIIllIIlIlIIII.getZ();
                        if (Math.abs(lIIllIIlIllIIl) != lIIllIIlIlllII || Math.abs(lIIllIIlIlIlll) != lIIllIIlIlllII || lIIllIIlIlllII <= 0) {
                            final BlockPos lIIllIIlIlIllI = new BlockPos(lIIllIIlIllIlI, lIIllIIlIllIll, lIIllIIlIllIII);
                            if (!lIIllIIlIlIIlI.getBlockState(lIIllIIlIlIllI).isFullBlock()) {
                                this.setBlockAndNotifyAdequately(lIIllIIlIlIIlI, lIIllIIlIlIllI, WorldGenTaiga1.LEAF);
                            }
                        }
                    }
                }
                if (lIIllIIlIlllII >= 1 && lIIllIIlIllIll == lIIllIIlIlIIII.getY() + lIIllIIllIIllI + 1) {
                    --lIIllIIlIlllII;
                }
                else if (lIIllIIlIlllII < lIIllIIllIIlII) {
                    ++lIIllIIlIlllII;
                }
            }
            for (int lIIllIIlIlIlIl = 0; lIIllIIlIlIlIl < lIIllIIllIIlll - 1; ++lIIllIIlIlIlIl) {
                final Material lIIllIIlIlIlII = lIIllIIlIlIIlI.getBlockState(lIIllIIlIlIIII.up(lIIllIIlIlIlIl)).getMaterial();
                if (lIIllIIlIlIlII == Material.AIR || lIIllIIlIlIlII == Material.LEAVES) {
                    this.setBlockAndNotifyAdequately(lIIllIIlIlIIlI, lIIllIIlIlIIII.up(lIIllIIlIlIlIl), WorldGenTaiga1.TRUNK);
                }
            }
            return true;
        }
        return false;
    }
}
