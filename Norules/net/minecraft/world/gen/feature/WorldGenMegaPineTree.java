package net.minecraft.world.gen.feature;

import net.minecraft.block.state.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.block.material.*;
import net.minecraft.init.*;
import net.minecraft.block.properties.*;
import net.minecraft.util.math.*;
import net.minecraft.block.*;

public class WorldGenMegaPineTree extends WorldGenHugeTrees
{
    private static final /* synthetic */ IBlockState PODZOL;
    private static final /* synthetic */ IBlockState LEAF;
    private static final /* synthetic */ IBlockState TRUNK;
    private final /* synthetic */ boolean useBaseHeight;
    
    public WorldGenMegaPineTree(final boolean lllllllllllllIIlIllIlIIIIIIIllIl, final boolean lllllllllllllIIlIllIlIIIIIIIllII) {
        super(lllllllllllllIIlIllIlIIIIIIIllIl, 13, 15, WorldGenMegaPineTree.TRUNK, WorldGenMegaPineTree.LEAF);
        this.useBaseHeight = lllllllllllllIIlIllIlIIIIIIIllII;
    }
    
    @Override
    public void generateSaplings(final World lllllllllllllIIlIllIIlllllIIIIIl, final Random lllllllllllllIIlIllIIlllllIIIIII, final BlockPos lllllllllllllIIlIllIIllllIllllll) {
        this.placePodzolCircle(lllllllllllllIIlIllIIlllllIIIIIl, lllllllllllllIIlIllIIllllIllllll.west().north());
        this.placePodzolCircle(lllllllllllllIIlIllIIlllllIIIIIl, lllllllllllllIIlIllIIllllIllllll.east(2).north());
        this.placePodzolCircle(lllllllllllllIIlIllIIlllllIIIIIl, lllllllllllllIIlIllIIllllIllllll.west().south(2));
        this.placePodzolCircle(lllllllllllllIIlIllIIlllllIIIIIl, lllllllllllllIIlIllIIllllIllllll.east(2).south(2));
        for (int lllllllllllllIIlIllIIlllllIIIllI = 0; lllllllllllllIIlIllIIlllllIIIllI < 5; ++lllllllllllllIIlIllIIlllllIIIllI) {
            final int lllllllllllllIIlIllIIlllllIIIlIl = lllllllllllllIIlIllIIlllllIIIIII.nextInt(64);
            final int lllllllllllllIIlIllIIlllllIIIlII = lllllllllllllIIlIllIIlllllIIIlIl % 8;
            final int lllllllllllllIIlIllIIlllllIIIIll = lllllllllllllIIlIllIIlllllIIIlIl / 8;
            if (lllllllllllllIIlIllIIlllllIIIlII == 0 || lllllllllllllIIlIllIIlllllIIIlII == 7 || lllllllllllllIIlIllIIlllllIIIIll == 0 || lllllllllllllIIlIllIIlllllIIIIll == 7) {
                this.placePodzolCircle(lllllllllllllIIlIllIIlllllIIIIIl, lllllllllllllIIlIllIIllllIllllll.add(-3 + lllllllllllllIIlIllIIlllllIIIlII, 0, -3 + lllllllllllllIIlIllIIlllllIIIIll));
            }
        }
    }
    
    @Override
    public boolean generate(final World lllllllllllllIIlIllIlIIIIIIIIIll, final Random lllllllllllllIIlIllIIllllllllIll, final BlockPos lllllllllllllIIlIllIIllllllllIlI) {
        final int lllllllllllllIIlIllIlIIIIIIIIIII = this.getHeight(lllllllllllllIIlIllIIllllllllIll);
        if (!this.ensureGrowable(lllllllllllllIIlIllIlIIIIIIIIIll, lllllllllllllIIlIllIIllllllllIll, lllllllllllllIIlIllIIllllllllIlI, lllllllllllllIIlIllIlIIIIIIIIIII)) {
            return false;
        }
        this.createCrown(lllllllllllllIIlIllIlIIIIIIIIIll, lllllllllllllIIlIllIIllllllllIlI.getX(), lllllllllllllIIlIllIIllllllllIlI.getZ(), lllllllllllllIIlIllIIllllllllIlI.getY() + lllllllllllllIIlIllIlIIIIIIIIIII, 0, lllllllllllllIIlIllIIllllllllIll);
        for (int lllllllllllllIIlIllIIlllllllllll = 0; lllllllllllllIIlIllIIlllllllllll < lllllllllllllIIlIllIlIIIIIIIIIII; ++lllllllllllllIIlIllIIlllllllllll) {
            IBlockState lllllllllllllIIlIllIIllllllllllI = lllllllllllllIIlIllIlIIIIIIIIIll.getBlockState(lllllllllllllIIlIllIIllllllllIlI.up(lllllllllllllIIlIllIIlllllllllll));
            if (lllllllllllllIIlIllIIllllllllllI.getMaterial() == Material.AIR || lllllllllllllIIlIllIIllllllllllI.getMaterial() == Material.LEAVES) {
                this.setBlockAndNotifyAdequately(lllllllllllllIIlIllIlIIIIIIIIIll, lllllllllllllIIlIllIIllllllllIlI.up(lllllllllllllIIlIllIIlllllllllll), this.woodMetadata);
            }
            if (lllllllllllllIIlIllIIlllllllllll < lllllllllllllIIlIllIlIIIIIIIIIII - 1) {
                lllllllllllllIIlIllIIllllllllllI = lllllllllllllIIlIllIlIIIIIIIIIll.getBlockState(lllllllllllllIIlIllIIllllllllIlI.add(1, lllllllllllllIIlIllIIlllllllllll, 0));
                if (lllllllllllllIIlIllIIllllllllllI.getMaterial() == Material.AIR || lllllllllllllIIlIllIIllllllllllI.getMaterial() == Material.LEAVES) {
                    this.setBlockAndNotifyAdequately(lllllllllllllIIlIllIlIIIIIIIIIll, lllllllllllllIIlIllIIllllllllIlI.add(1, lllllllllllllIIlIllIIlllllllllll, 0), this.woodMetadata);
                }
                lllllllllllllIIlIllIIllllllllllI = lllllllllllllIIlIllIlIIIIIIIIIll.getBlockState(lllllllllllllIIlIllIIllllllllIlI.add(1, lllllllllllllIIlIllIIlllllllllll, 1));
                if (lllllllllllllIIlIllIIllllllllllI.getMaterial() == Material.AIR || lllllllllllllIIlIllIIllllllllllI.getMaterial() == Material.LEAVES) {
                    this.setBlockAndNotifyAdequately(lllllllllllllIIlIllIlIIIIIIIIIll, lllllllllllllIIlIllIIllllllllIlI.add(1, lllllllllllllIIlIllIIlllllllllll, 1), this.woodMetadata);
                }
                lllllllllllllIIlIllIIllllllllllI = lllllllllllllIIlIllIlIIIIIIIIIll.getBlockState(lllllllllllllIIlIllIIllllllllIlI.add(0, lllllllllllllIIlIllIIlllllllllll, 1));
                if (lllllllllllllIIlIllIIllllllllllI.getMaterial() == Material.AIR || lllllllllllllIIlIllIIllllllllllI.getMaterial() == Material.LEAVES) {
                    this.setBlockAndNotifyAdequately(lllllllllllllIIlIllIlIIIIIIIIIll, lllllllllllllIIlIllIIllllllllIlI.add(0, lllllllllllllIIlIllIIlllllllllll, 1), this.woodMetadata);
                }
            }
        }
        return true;
    }
    
    static {
        TRUNK = Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE);
        LEAF = Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.SPRUCE).withProperty((IProperty<Comparable>)BlockLeaves.CHECK_DECAY, false);
        PODZOL = Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.PODZOL);
    }
    
    private void placePodzolCircle(final World lllllllllllllIIlIllIIllllIlIllll, final BlockPos lllllllllllllIIlIllIIllllIllIIll) {
        for (int lllllllllllllIIlIllIIllllIllIIlI = -2; lllllllllllllIIlIllIIllllIllIIlI <= 2; ++lllllllllllllIIlIllIIllllIllIIlI) {
            for (int lllllllllllllIIlIllIIllllIllIIIl = -2; lllllllllllllIIlIllIIllllIllIIIl <= 2; ++lllllllllllllIIlIllIIllllIllIIIl) {
                if (Math.abs(lllllllllllllIIlIllIIllllIllIIlI) != 2 || Math.abs(lllllllllllllIIlIllIIllllIllIIIl) != 2) {
                    this.placePodzolAt(lllllllllllllIIlIllIIllllIlIllll, lllllllllllllIIlIllIIllllIllIIll.add(lllllllllllllIIlIllIIllllIllIIlI, 0, lllllllllllllIIlIllIIllllIllIIIl));
                }
            }
        }
    }
    
    private void createCrown(final World lllllllllllllIIlIllIIllllllIlIIl, final int lllllllllllllIIlIllIIlllllIlllII, final int lllllllllllllIIlIllIIlllllIllIll, final int lllllllllllllIIlIllIIlllllIllIlI, final int lllllllllllllIIlIllIIlllllIllIIl, final Random lllllllllllllIIlIllIIlllllIllIII) {
        final int lllllllllllllIIlIllIIllllllIIIll = lllllllllllllIIlIllIIlllllIllIII.nextInt(5) + (this.useBaseHeight ? this.baseHeight : 3);
        int lllllllllllllIIlIllIIllllllIIIlI = 0;
        for (int lllllllllllllIIlIllIIllllllIIIIl = lllllllllllllIIlIllIIlllllIllIlI - lllllllllllllIIlIllIIllllllIIIll; lllllllllllllIIlIllIIllllllIIIIl <= lllllllllllllIIlIllIIlllllIllIlI; ++lllllllllllllIIlIllIIllllllIIIIl) {
            final int lllllllllllllIIlIllIIllllllIIIII = lllllllllllllIIlIllIIlllllIllIlI - lllllllllllllIIlIllIIllllllIIIIl;
            final int lllllllllllllIIlIllIIlllllIlllll = lllllllllllllIIlIllIIlllllIllIIl + MathHelper.floor(lllllllllllllIIlIllIIllllllIIIII / (float)lllllllllllllIIlIllIIllllllIIIll * 3.5f);
            this.growLeavesLayerStrict(lllllllllllllIIlIllIIllllllIlIIl, new BlockPos(lllllllllllllIIlIllIIlllllIlllII, lllllllllllllIIlIllIIllllllIIIIl, lllllllllllllIIlIllIIlllllIllIll), lllllllllllllIIlIllIIlllllIlllll + ((lllllllllllllIIlIllIIllllllIIIII > 0 && lllllllllllllIIlIllIIlllllIlllll == lllllllllllllIIlIllIIllllllIIIlI && (lllllllllllllIIlIllIIllllllIIIIl & 0x1) == 0x0) ? 1 : 0));
            lllllllllllllIIlIllIIllllllIIIlI = lllllllllllllIIlIllIIlllllIlllll;
        }
    }
    
    private void placePodzolAt(final World lllllllllllllIIlIllIIllllIIlllII, final BlockPos lllllllllllllIIlIllIIllllIIllIll) {
        for (int lllllllllllllIIlIllIIllllIlIIIIl = 2; lllllllllllllIIlIllIIllllIlIIIIl >= -3; --lllllllllllllIIlIllIIllllIlIIIIl) {
            final BlockPos lllllllllllllIIlIllIIllllIlIIIII = lllllllllllllIIlIllIIllllIIllIll.up(lllllllllllllIIlIllIIllllIlIIIIl);
            final IBlockState lllllllllllllIIlIllIIllllIIlllll = lllllllllllllIIlIllIIllllIIlllII.getBlockState(lllllllllllllIIlIllIIllllIlIIIII);
            final Block lllllllllllllIIlIllIIllllIIllllI = lllllllllllllIIlIllIIllllIIlllll.getBlock();
            if (lllllllllllllIIlIllIIllllIIllllI == Blocks.GRASS || lllllllllllllIIlIllIIllllIIllllI == Blocks.DIRT) {
                this.setBlockAndNotifyAdequately(lllllllllllllIIlIllIIllllIIlllII, lllllllllllllIIlIllIIllllIlIIIII, WorldGenMegaPineTree.PODZOL);
                break;
            }
            if (lllllllllllllIIlIllIIllllIIlllll.getMaterial() != Material.AIR && lllllllllllllIIlIllIIllllIlIIIIl < 0) {
                break;
            }
        }
    }
}
