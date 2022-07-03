package net.minecraft.world.gen.feature;

import net.minecraft.block.state.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.block.material.*;
import java.util.*;
import net.minecraft.init.*;
import net.minecraft.util.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.*;

public class WorldGenSavannaTree extends WorldGenAbstractTree
{
    private static final /* synthetic */ IBlockState LEAF;
    private static final /* synthetic */ IBlockState TRUNK;
    
    private void placeLeafAt(final World llllllllllllllIllllIIIllIlIlIIIl, final BlockPos llllllllllllllIllllIIIllIlIIllII) {
        final Material llllllllllllllIllllIIIllIlIIllll = llllllllllllllIllllIIIllIlIlIIIl.getBlockState(llllllllllllllIllllIIIllIlIIllII).getMaterial();
        if (llllllllllllllIllllIIIllIlIIllll == Material.AIR || llllllllllllllIllllIIIllIlIIllll == Material.LEAVES) {
            this.setBlockAndNotifyAdequately(llllllllllllllIllllIIIllIlIlIIIl, llllllllllllllIllllIIIllIlIIllII, WorldGenSavannaTree.LEAF);
        }
    }
    
    @Override
    public boolean generate(final World llllllllllllllIllllIIIllIlllIIll, final Random llllllllllllllIllllIIIlllIIllIIl, final BlockPos llllllllllllllIllllIIIlllIIllIII) {
        final int llllllllllllllIllllIIIlllIIlIlll = llllllllllllllIllllIIIlllIIllIIl.nextInt(3) + llllllllllllllIllllIIIlllIIllIIl.nextInt(3) + 5;
        boolean llllllllllllllIllllIIIlllIIlIllI = true;
        if (llllllllllllllIllllIIIlllIIllIII.getY() < 1 || llllllllllllllIllllIIIlllIIllIII.getY() + llllllllllllllIllllIIIlllIIlIlll + 1 > 256) {
            return false;
        }
        for (int llllllllllllllIllllIIIlllIIlIlIl = llllllllllllllIllllIIIlllIIllIII.getY(); llllllllllllllIllllIIIlllIIlIlIl <= llllllllllllllIllllIIIlllIIllIII.getY() + 1 + llllllllllllllIllllIIIlllIIlIlll; ++llllllllllllllIllllIIIlllIIlIlIl) {
            int llllllllllllllIllllIIIlllIIlIlII = 1;
            if (llllllllllllllIllllIIIlllIIlIlIl == llllllllllllllIllllIIIlllIIllIII.getY()) {
                llllllllllllllIllllIIIlllIIlIlII = 0;
            }
            if (llllllllllllllIllllIIIlllIIlIlIl >= llllllllllllllIllllIIIlllIIllIII.getY() + 1 + llllllllllllllIllllIIIlllIIlIlll - 2) {
                llllllllllllllIllllIIIlllIIlIlII = 2;
            }
            final BlockPos.MutableBlockPos llllllllllllllIllllIIIlllIIlIIll = new BlockPos.MutableBlockPos();
            for (int llllllllllllllIllllIIIlllIIlIIlI = llllllllllllllIllllIIIlllIIllIII.getX() - llllllllllllllIllllIIIlllIIlIlII; llllllllllllllIllllIIIlllIIlIIlI <= llllllllllllllIllllIIIlllIIllIII.getX() + llllllllllllllIllllIIIlllIIlIlII && llllllllllllllIllllIIIlllIIlIllI; ++llllllllllllllIllllIIIlllIIlIIlI) {
                for (int llllllllllllllIllllIIIlllIIlIIIl = llllllllllllllIllllIIIlllIIllIII.getZ() - llllllllllllllIllllIIIlllIIlIlII; llllllllllllllIllllIIIlllIIlIIIl <= llllllllllllllIllllIIIlllIIllIII.getZ() + llllllllllllllIllllIIIlllIIlIlII && llllllllllllllIllllIIIlllIIlIllI; ++llllllllllllllIllllIIIlllIIlIIIl) {
                    if (llllllllllllllIllllIIIlllIIlIlIl >= 0 && llllllllllllllIllllIIIlllIIlIlIl < 256) {
                        if (!this.canGrowInto(llllllllllllllIllllIIIllIlllIIll.getBlockState(llllllllllllllIllllIIIlllIIlIIll.setPos(llllllllllllllIllllIIIlllIIlIIlI, llllllllllllllIllllIIIlllIIlIlIl, llllllllllllllIllllIIIlllIIlIIIl)).getBlock())) {
                            llllllllllllllIllllIIIlllIIlIllI = false;
                        }
                    }
                    else {
                        llllllllllllllIllllIIIlllIIlIllI = false;
                    }
                }
            }
        }
        if (!llllllllllllllIllllIIIlllIIlIllI) {
            return false;
        }
        final Block llllllllllllllIllllIIIlllIIlIIII = llllllllllllllIllllIIIllIlllIIll.getBlockState(llllllllllllllIllllIIIlllIIllIII.down()).getBlock();
        if ((llllllllllllllIllllIIIlllIIlIIII == Blocks.GRASS || llllllllllllllIllllIIIlllIIlIIII == Blocks.DIRT) && llllllllllllllIllllIIIlllIIllIII.getY() < 256 - llllllllllllllIllllIIIlllIIlIlll - 1) {
            this.setDirtAt(llllllllllllllIllllIIIllIlllIIll, llllllllllllllIllllIIIlllIIllIII.down());
            final EnumFacing llllllllllllllIllllIIIlllIIIllll = EnumFacing.Plane.HORIZONTAL.random(llllllllllllllIllllIIIlllIIllIIl);
            final int llllllllllllllIllllIIIlllIIIlllI = llllllllllllllIllllIIIlllIIlIlll - llllllllllllllIllllIIIlllIIllIIl.nextInt(4) - 1;
            int llllllllllllllIllllIIIlllIIIllIl = 3 - llllllllllllllIllllIIIlllIIllIIl.nextInt(3);
            int llllllllllllllIllllIIIlllIIIllII = llllllllllllllIllllIIIlllIIllIII.getX();
            int llllllllllllllIllllIIIlllIIIlIll = llllllllllllllIllllIIIlllIIllIII.getZ();
            int llllllllllllllIllllIIIlllIIIlIlI = 0;
            for (int llllllllllllllIllllIIIlllIIIlIIl = 0; llllllllllllllIllllIIIlllIIIlIIl < llllllllllllllIllllIIIlllIIlIlll; ++llllllllllllllIllllIIIlllIIIlIIl) {
                final int llllllllllllllIllllIIIlllIIIlIII = llllllllllllllIllllIIIlllIIllIII.getY() + llllllllllllllIllllIIIlllIIIlIIl;
                if (llllllllllllllIllllIIIlllIIIlIIl >= llllllllllllllIllllIIIlllIIIlllI && llllllllllllllIllllIIIlllIIIllIl > 0) {
                    llllllllllllllIllllIIIlllIIIllII += llllllllllllllIllllIIIlllIIIllll.getFrontOffsetX();
                    llllllllllllllIllllIIIlllIIIlIll += llllllllllllllIllllIIIlllIIIllll.getFrontOffsetZ();
                    --llllllllllllllIllllIIIlllIIIllIl;
                }
                final BlockPos llllllllllllllIllllIIIlllIIIIlll = new BlockPos(llllllllllllllIllllIIIlllIIIllII, llllllllllllllIllllIIIlllIIIlIII, llllllllllllllIllllIIIlllIIIlIll);
                final Material llllllllllllllIllllIIIlllIIIIllI = llllllllllllllIllllIIIllIlllIIll.getBlockState(llllllllllllllIllllIIIlllIIIIlll).getMaterial();
                if (llllllllllllllIllllIIIlllIIIIllI == Material.AIR || llllllllllllllIllllIIIlllIIIIllI == Material.LEAVES) {
                    this.placeLogAt(llllllllllllllIllllIIIllIlllIIll, llllllllllllllIllllIIIlllIIIIlll);
                    llllllllllllllIllllIIIlllIIIlIlI = llllllllllllllIllllIIIlllIIIlIII;
                }
            }
            BlockPos llllllllllllllIllllIIIlllIIIIlIl = new BlockPos(llllllllllllllIllllIIIlllIIIllII, llllllllllllllIllllIIIlllIIIlIlI, llllllllllllllIllllIIIlllIIIlIll);
            for (int llllllllllllllIllllIIIlllIIIIlII = -3; llllllllllllllIllllIIIlllIIIIlII <= 3; ++llllllllllllllIllllIIIlllIIIIlII) {
                for (int llllllllllllllIllllIIIlllIIIIIll = -3; llllllllllllllIllllIIIlllIIIIIll <= 3; ++llllllllllllllIllllIIIlllIIIIIll) {
                    if (Math.abs(llllllllllllllIllllIIIlllIIIIlII) != 3 || Math.abs(llllllllllllllIllllIIIlllIIIIIll) != 3) {
                        this.placeLeafAt(llllllllllllllIllllIIIllIlllIIll, llllllllllllllIllllIIIlllIIIIlIl.add(llllllllllllllIllllIIIlllIIIIlII, 0, llllllllllllllIllllIIIlllIIIIIll));
                    }
                }
            }
            llllllllllllllIllllIIIlllIIIIlIl = llllllllllllllIllllIIIlllIIIIlIl.up();
            for (int llllllllllllllIllllIIIlllIIIIIlI = -1; llllllllllllllIllllIIIlllIIIIIlI <= 1; ++llllllllllllllIllllIIIlllIIIIIlI) {
                for (int llllllllllllllIllllIIIlllIIIIIIl = -1; llllllllllllllIllllIIIlllIIIIIIl <= 1; ++llllllllllllllIllllIIIlllIIIIIIl) {
                    this.placeLeafAt(llllllllllllllIllllIIIllIlllIIll, llllllllllllllIllllIIIlllIIIIlIl.add(llllllllllllllIllllIIIlllIIIIIlI, 0, llllllllllllllIllllIIIlllIIIIIIl));
                }
            }
            this.placeLeafAt(llllllllllllllIllllIIIllIlllIIll, llllllllllllllIllllIIIlllIIIIlIl.east(2));
            this.placeLeafAt(llllllllllllllIllllIIIllIlllIIll, llllllllllllllIllllIIIlllIIIIlIl.west(2));
            this.placeLeafAt(llllllllllllllIllllIIIllIlllIIll, llllllllllllllIllllIIIlllIIIIlIl.south(2));
            this.placeLeafAt(llllllllllllllIllllIIIllIlllIIll, llllllllllllllIllllIIIlllIIIIlIl.north(2));
            llllllllllllllIllllIIIlllIIIllII = llllllllllllllIllllIIIlllIIllIII.getX();
            llllllllllllllIllllIIIlllIIIlIll = llllllllllllllIllllIIIlllIIllIII.getZ();
            final EnumFacing llllllllllllllIllllIIIlllIIIIIII = EnumFacing.Plane.HORIZONTAL.random(llllllllllllllIllllIIIlllIIllIIl);
            if (llllllllllllllIllllIIIlllIIIIIII != llllllllllllllIllllIIIlllIIIllll) {
                final int llllllllllllllIllllIIIllIlllllll = llllllllllllllIllllIIIlllIIIlllI - llllllllllllllIllllIIIlllIIllIIl.nextInt(2) - 1;
                int llllllllllllllIllllIIIllIllllllI = 1 + llllllllllllllIllllIIIlllIIllIIl.nextInt(3);
                llllllllllllllIllllIIIlllIIIlIlI = 0;
                for (int llllllllllllllIllllIIIllIlllllIl = llllllllllllllIllllIIIllIlllllll; llllllllllllllIllllIIIllIlllllIl < llllllllllllllIllllIIIlllIIlIlll && llllllllllllllIllllIIIllIllllllI > 0; ++llllllllllllllIllllIIIllIlllllIl, --llllllllllllllIllllIIIllIllllllI) {
                    if (llllllllllllllIllllIIIllIlllllIl >= 1) {
                        final int llllllllllllllIllllIIIllIlllllII = llllllllllllllIllllIIIlllIIllIII.getY() + llllllllllllllIllllIIIllIlllllIl;
                        llllllllllllllIllllIIIlllIIIllII += llllllllllllllIllllIIIlllIIIIIII.getFrontOffsetX();
                        llllllllllllllIllllIIIlllIIIlIll += llllllllllllllIllllIIIlllIIIIIII.getFrontOffsetZ();
                        final BlockPos llllllllllllllIllllIIIllIllllIll = new BlockPos(llllllllllllllIllllIIIlllIIIllII, llllllllllllllIllllIIIllIlllllII, llllllllllllllIllllIIIlllIIIlIll);
                        final Material llllllllllllllIllllIIIllIllllIlI = llllllllllllllIllllIIIllIlllIIll.getBlockState(llllllllllllllIllllIIIllIllllIll).getMaterial();
                        if (llllllllllllllIllllIIIllIllllIlI == Material.AIR || llllllllllllllIllllIIIllIllllIlI == Material.LEAVES) {
                            this.placeLogAt(llllllllllllllIllllIIIllIlllIIll, llllllllllllllIllllIIIllIllllIll);
                            llllllllllllllIllllIIIlllIIIlIlI = llllllllllllllIllllIIIllIlllllII;
                        }
                    }
                }
                if (llllllllllllllIllllIIIlllIIIlIlI > 0) {
                    BlockPos llllllllllllllIllllIIIllIllllIIl = new BlockPos(llllllllllllllIllllIIIlllIIIllII, llllllllllllllIllllIIIlllIIIlIlI, llllllllllllllIllllIIIlllIIIlIll);
                    for (int llllllllllllllIllllIIIllIllllIII = -2; llllllllllllllIllllIIIllIllllIII <= 2; ++llllllllllllllIllllIIIllIllllIII) {
                        for (int llllllllllllllIllllIIIllIlllIlll = -2; llllllllllllllIllllIIIllIlllIlll <= 2; ++llllllllllllllIllllIIIllIlllIlll) {
                            if (Math.abs(llllllllllllllIllllIIIllIllllIII) != 2 || Math.abs(llllllllllllllIllllIIIllIlllIlll) != 2) {
                                this.placeLeafAt(llllllllllllllIllllIIIllIlllIIll, llllllllllllllIllllIIIllIllllIIl.add(llllllllllllllIllllIIIllIllllIII, 0, llllllllllllllIllllIIIllIlllIlll));
                            }
                        }
                    }
                    llllllllllllllIllllIIIllIllllIIl = llllllllllllllIllllIIIllIllllIIl.up();
                    for (int llllllllllllllIllllIIIllIlllIllI = -1; llllllllllllllIllllIIIllIlllIllI <= 1; ++llllllllllllllIllllIIIllIlllIllI) {
                        for (int llllllllllllllIllllIIIllIlllIlIl = -1; llllllllllllllIllllIIIllIlllIlIl <= 1; ++llllllllllllllIllllIIIllIlllIlIl) {
                            this.placeLeafAt(llllllllllllllIllllIIIllIlllIIll, llllllllllllllIllllIIIllIllllIIl.add(llllllllllllllIllllIIIllIlllIllI, 0, llllllllllllllIllllIIIllIlllIlIl));
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }
    
    static {
        TRUNK = Blocks.LOG2.getDefaultState().withProperty(BlockNewLog.VARIANT, BlockPlanks.EnumType.ACACIA);
        LEAF = Blocks.LEAVES2.getDefaultState().withProperty(BlockNewLeaf.VARIANT, BlockPlanks.EnumType.ACACIA).withProperty((IProperty<Comparable>)BlockLeaves.CHECK_DECAY, false);
    }
    
    public WorldGenSavannaTree(final boolean llllllllllllllIllllIIIlllIllIIll) {
        super(llllllllllllllIllllIIIlllIllIIll);
    }
    
    private void placeLogAt(final World llllllllllllllIllllIIIllIlIllIll, final BlockPos llllllllllllllIllllIIIllIlIllIlI) {
        this.setBlockAndNotifyAdequately(llllllllllllllIllllIIIllIlIllIll, llllllllllllllIllllIIIllIlIllIlI, WorldGenSavannaTree.TRUNK);
    }
}
