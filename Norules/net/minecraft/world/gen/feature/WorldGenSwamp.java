package net.minecraft.world.gen.feature;

import net.minecraft.block.state.*;
import net.minecraft.init.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.math.*;
import net.minecraft.block.material.*;
import net.minecraft.block.*;
import net.minecraft.block.properties.*;

public class WorldGenSwamp extends WorldGenAbstractTree
{
    private static final /* synthetic */ IBlockState LEAF;
    private static final /* synthetic */ IBlockState TRUNK;
    
    static {
        TRUNK = Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.OAK);
        LEAF = Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.OAK).withProperty((IProperty<Comparable>)BlockOldLeaf.CHECK_DECAY, false);
    }
    
    @Override
    public boolean generate(final World llllllllllllIllllIlllllIlIIIIlIl, final Random llllllllllllIllllIlllllIlIIIIlII, BlockPos llllllllllllIllllIlllllIIllIIIII) {
        final int llllllllllllIllllIlllllIlIIIIIlI = llllllllllllIllllIlllllIlIIIIlII.nextInt(4) + 5;
        while (llllllllllllIllllIlllllIlIIIIlIl.getBlockState(llllllllllllIllllIlllllIIllIIIII.down()).getMaterial() == Material.WATER) {
            llllllllllllIllllIlllllIIllIIIII = llllllllllllIllllIlllllIIllIIIII.down();
        }
        boolean llllllllllllIllllIlllllIlIIIIIIl = true;
        if (llllllllllllIllllIlllllIIllIIIII.getY() < 1 || llllllllllllIllllIlllllIIllIIIII.getY() + llllllllllllIllllIlllllIlIIIIIlI + 1 > 256) {
            return false;
        }
        for (int llllllllllllIllllIlllllIlIIIIIII = llllllllllllIllllIlllllIIllIIIII.getY(); llllllllllllIllllIlllllIlIIIIIII <= llllllllllllIllllIlllllIIllIIIII.getY() + 1 + llllllllllllIllllIlllllIlIIIIIlI; ++llllllllllllIllllIlllllIlIIIIIII) {
            int llllllllllllIllllIlllllIIlllllll = 1;
            if (llllllllllllIllllIlllllIlIIIIIII == llllllllllllIllllIlllllIIllIIIII.getY()) {
                llllllllllllIllllIlllllIIlllllll = 0;
            }
            if (llllllllllllIllllIlllllIlIIIIIII >= llllllllllllIllllIlllllIIllIIIII.getY() + 1 + llllllllllllIllllIlllllIlIIIIIlI - 2) {
                llllllllllllIllllIlllllIIlllllll = 3;
            }
            final BlockPos.MutableBlockPos llllllllllllIllllIlllllIIllllllI = new BlockPos.MutableBlockPos();
            for (int llllllllllllIllllIlllllIIlllllIl = llllllllllllIllllIlllllIIllIIIII.getX() - llllllllllllIllllIlllllIIlllllll; llllllllllllIllllIlllllIIlllllIl <= llllllllllllIllllIlllllIIllIIIII.getX() + llllllllllllIllllIlllllIIlllllll && llllllllllllIllllIlllllIlIIIIIIl; ++llllllllllllIllllIlllllIIlllllIl) {
                for (int llllllllllllIllllIlllllIIlllllII = llllllllllllIllllIlllllIIllIIIII.getZ() - llllllllllllIllllIlllllIIlllllll; llllllllllllIllllIlllllIIlllllII <= llllllllllllIllllIlllllIIllIIIII.getZ() + llllllllllllIllllIlllllIIlllllll && llllllllllllIllllIlllllIlIIIIIIl; ++llllllllllllIllllIlllllIIlllllII) {
                    if (llllllllllllIllllIlllllIlIIIIIII >= 0 && llllllllllllIllllIlllllIlIIIIIII < 256) {
                        final IBlockState llllllllllllIllllIlllllIIllllIll = llllllllllllIllllIlllllIlIIIIlIl.getBlockState(llllllllllllIllllIlllllIIllllllI.setPos(llllllllllllIllllIlllllIIlllllIl, llllllllllllIllllIlllllIlIIIIIII, llllllllllllIllllIlllllIIlllllII));
                        final Block llllllllllllIllllIlllllIIllllIlI = llllllllllllIllllIlllllIIllllIll.getBlock();
                        if (llllllllllllIllllIlllllIIllllIll.getMaterial() != Material.AIR && llllllllllllIllllIlllllIIllllIll.getMaterial() != Material.LEAVES) {
                            if (llllllllllllIllllIlllllIIllllIlI != Blocks.WATER && llllllllllllIllllIlllllIIllllIlI != Blocks.FLOWING_WATER) {
                                llllllllllllIllllIlllllIlIIIIIIl = false;
                            }
                            else if (llllllllllllIllllIlllllIlIIIIIII > llllllllllllIllllIlllllIIllIIIII.getY()) {
                                llllllllllllIllllIlllllIlIIIIIIl = false;
                            }
                        }
                    }
                    else {
                        llllllllllllIllllIlllllIlIIIIIIl = false;
                    }
                }
            }
        }
        if (!llllllllllllIllllIlllllIlIIIIIIl) {
            return false;
        }
        final Block llllllllllllIllllIlllllIIllllIIl = llllllllllllIllllIlllllIlIIIIlIl.getBlockState(llllllllllllIllllIlllllIIllIIIII.down()).getBlock();
        if ((llllllllllllIllllIlllllIIllllIIl == Blocks.GRASS || llllllllllllIllllIlllllIIllllIIl == Blocks.DIRT) && llllllllllllIllllIlllllIIllIIIII.getY() < 256 - llllllllllllIllllIlllllIlIIIIIlI - 1) {
            this.setDirtAt(llllllllllllIllllIlllllIlIIIIlIl, llllllllllllIllllIlllllIIllIIIII.down());
            for (int llllllllllllIllllIlllllIIllllIII = llllllllllllIllllIlllllIIllIIIII.getY() - 3 + llllllllllllIllllIlllllIlIIIIIlI; llllllllllllIllllIlllllIIllllIII <= llllllllllllIllllIlllllIIllIIIII.getY() + llllllllllllIllllIlllllIlIIIIIlI; ++llllllllllllIllllIlllllIIllllIII) {
                final int llllllllllllIllllIlllllIIlllIlll = llllllllllllIllllIlllllIIllllIII - (llllllllllllIllllIlllllIIllIIIII.getY() + llllllllllllIllllIlllllIlIIIIIlI);
                for (int llllllllllllIllllIlllllIIlllIllI = 2 - llllllllllllIllllIlllllIIlllIlll / 2, llllllllllllIllllIlllllIIlllIlIl = llllllllllllIllllIlllllIIllIIIII.getX() - llllllllllllIllllIlllllIIlllIllI; llllllllllllIllllIlllllIIlllIlIl <= llllllllllllIllllIlllllIIllIIIII.getX() + llllllllllllIllllIlllllIIlllIllI; ++llllllllllllIllllIlllllIIlllIlIl) {
                    final int llllllllllllIllllIlllllIIlllIlII = llllllllllllIllllIlllllIIlllIlIl - llllllllllllIllllIlllllIIllIIIII.getX();
                    for (int llllllllllllIllllIlllllIIlllIIll = llllllllllllIllllIlllllIIllIIIII.getZ() - llllllllllllIllllIlllllIIlllIllI; llllllllllllIllllIlllllIIlllIIll <= llllllllllllIllllIlllllIIllIIIII.getZ() + llllllllllllIllllIlllllIIlllIllI; ++llllllllllllIllllIlllllIIlllIIll) {
                        final int llllllllllllIllllIlllllIIlllIIlI = llllllllllllIllllIlllllIIlllIIll - llllllllllllIllllIlllllIIllIIIII.getZ();
                        if (Math.abs(llllllllllllIllllIlllllIIlllIlII) != llllllllllllIllllIlllllIIlllIllI || Math.abs(llllllllllllIllllIlllllIIlllIIlI) != llllllllllllIllllIlllllIIlllIllI || (llllllllllllIllllIlllllIlIIIIlII.nextInt(2) != 0 && llllllllllllIllllIlllllIIlllIlll != 0)) {
                            final BlockPos llllllllllllIllllIlllllIIlllIIIl = new BlockPos(llllllllllllIllllIlllllIIlllIlIl, llllllllllllIllllIlllllIIllllIII, llllllllllllIllllIlllllIIlllIIll);
                            if (!llllllllllllIllllIlllllIlIIIIlIl.getBlockState(llllllllllllIllllIlllllIIlllIIIl).isFullBlock()) {
                                this.setBlockAndNotifyAdequately(llllllllllllIllllIlllllIlIIIIlIl, llllllllllllIllllIlllllIIlllIIIl, WorldGenSwamp.LEAF);
                            }
                        }
                    }
                }
            }
            for (int llllllllllllIllllIlllllIIlllIIII = 0; llllllllllllIllllIlllllIIlllIIII < llllllllllllIllllIlllllIlIIIIIlI; ++llllllllllllIllllIlllllIIlllIIII) {
                final IBlockState llllllllllllIllllIlllllIIllIllll = llllllllllllIllllIlllllIlIIIIlIl.getBlockState(llllllllllllIllllIlllllIIllIIIII.up(llllllllllllIllllIlllllIIlllIIII));
                final Block llllllllllllIllllIlllllIIllIlllI = llllllllllllIllllIlllllIIllIllll.getBlock();
                if (llllllllllllIllllIlllllIIllIllll.getMaterial() == Material.AIR || llllllllllllIllllIlllllIIllIllll.getMaterial() == Material.LEAVES || llllllllllllIllllIlllllIIllIlllI == Blocks.FLOWING_WATER || llllllllllllIllllIlllllIIllIlllI == Blocks.WATER) {
                    this.setBlockAndNotifyAdequately(llllllllllllIllllIlllllIlIIIIlIl, llllllllllllIllllIlllllIIllIIIII.up(llllllllllllIllllIlllllIIlllIIII), WorldGenSwamp.TRUNK);
                }
            }
            for (int llllllllllllIllllIlllllIIllIllIl = llllllllllllIllllIlllllIIllIIIII.getY() - 3 + llllllllllllIllllIlllllIlIIIIIlI; llllllllllllIllllIlllllIIllIllIl <= llllllllllllIllllIlllllIIllIIIII.getY() + llllllllllllIllllIlllllIlIIIIIlI; ++llllllllllllIllllIlllllIIllIllIl) {
                final int llllllllllllIllllIlllllIIllIllII = llllllllllllIllllIlllllIIllIllIl - (llllllllllllIllllIlllllIIllIIIII.getY() + llllllllllllIllllIlllllIlIIIIIlI);
                final int llllllllllllIllllIlllllIIllIlIll = 2 - llllllllllllIllllIlllllIIllIllII / 2;
                final BlockPos.MutableBlockPos llllllllllllIllllIlllllIIllIlIlI = new BlockPos.MutableBlockPos();
                for (int llllllllllllIllllIlllllIIllIlIIl = llllllllllllIllllIlllllIIllIIIII.getX() - llllllllllllIllllIlllllIIllIlIll; llllllllllllIllllIlllllIIllIlIIl <= llllllllllllIllllIlllllIIllIIIII.getX() + llllllllllllIllllIlllllIIllIlIll; ++llllllllllllIllllIlllllIIllIlIIl) {
                    for (int llllllllllllIllllIlllllIIllIlIII = llllllllllllIllllIlllllIIllIIIII.getZ() - llllllllllllIllllIlllllIIllIlIll; llllllllllllIllllIlllllIIllIlIII <= llllllllllllIllllIlllllIIllIIIII.getZ() + llllllllllllIllllIlllllIIllIlIll; ++llllllllllllIllllIlllllIIllIlIII) {
                        llllllllllllIllllIlllllIIllIlIlI.setPos(llllllllllllIllllIlllllIIllIlIIl, llllllllllllIllllIlllllIIllIllIl, llllllllllllIllllIlllllIIllIlIII);
                        if (llllllllllllIllllIlllllIlIIIIlIl.getBlockState(llllllllllllIllllIlllllIIllIlIlI).getMaterial() == Material.LEAVES) {
                            final BlockPos llllllllllllIllllIlllllIIllIIlll = llllllllllllIllllIlllllIIllIlIlI.west();
                            final BlockPos llllllllllllIllllIlllllIIllIIllI = llllllllllllIllllIlllllIIllIlIlI.east();
                            final BlockPos llllllllllllIllllIlllllIIllIIlIl = llllllllllllIllllIlllllIIllIlIlI.north();
                            final BlockPos llllllllllllIllllIlllllIIllIIlII = llllllllllllIllllIlllllIIllIlIlI.south();
                            if (llllllllllllIllllIlllllIlIIIIlII.nextInt(4) == 0 && llllllllllllIllllIlllllIlIIIIlIl.getBlockState(llllllllllllIllllIlllllIIllIIlll).getMaterial() == Material.AIR) {
                                this.addVine(llllllllllllIllllIlllllIlIIIIlIl, llllllllllllIllllIlllllIIllIIlll, BlockVine.EAST);
                            }
                            if (llllllllllllIllllIlllllIlIIIIlII.nextInt(4) == 0 && llllllllllllIllllIlllllIlIIIIlIl.getBlockState(llllllllllllIllllIlllllIIllIIllI).getMaterial() == Material.AIR) {
                                this.addVine(llllllllllllIllllIlllllIlIIIIlIl, llllllllllllIllllIlllllIIllIIllI, BlockVine.WEST);
                            }
                            if (llllllllllllIllllIlllllIlIIIIlII.nextInt(4) == 0 && llllllllllllIllllIlllllIlIIIIlIl.getBlockState(llllllllllllIllllIlllllIIllIIlIl).getMaterial() == Material.AIR) {
                                this.addVine(llllllllllllIllllIlllllIlIIIIlIl, llllllllllllIllllIlllllIIllIIlIl, BlockVine.SOUTH);
                            }
                            if (llllllllllllIllllIlllllIlIIIIlII.nextInt(4) == 0 && llllllllllllIllllIlllllIlIIIIlIl.getBlockState(llllllllllllIllllIlllllIIllIIlII).getMaterial() == Material.AIR) {
                                this.addVine(llllllllllllIllllIlllllIlIIIIlIl, llllllllllllIllllIlllllIIllIIlII, BlockVine.NORTH);
                            }
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }
    
    public WorldGenSwamp() {
        super(false);
    }
    
    private void addVine(final World llllllllllllIllllIlllllIIlIIIIll, final BlockPos llllllllllllIllllIlllllIIlIIIIlI, final PropertyBool llllllllllllIllllIlllllIIlIIIIIl) {
        final IBlockState llllllllllllIllllIlllllIIlIIIlll = Blocks.VINE.getDefaultState().withProperty((IProperty<Comparable>)llllllllllllIllllIlllllIIlIIIIIl, true);
        this.setBlockAndNotifyAdequately(llllllllllllIllllIlllllIIlIIIIll, llllllllllllIllllIlllllIIlIIIIlI, llllllllllllIllllIlllllIIlIIIlll);
        int llllllllllllIllllIlllllIIlIIIllI = 4;
        for (BlockPos llllllllllllIllllIlllllIIlIIIlIl = llllllllllllIllllIlllllIIlIIIIlI.down(); llllllllllllIllllIlllllIIlIIIIll.getBlockState(llllllllllllIllllIlllllIIlIIIlIl).getMaterial() == Material.AIR && llllllllllllIllllIlllllIIlIIIllI > 0; llllllllllllIllllIlllllIIlIIIlIl = llllllllllllIllllIlllllIIlIIIlIl.down(), --llllllllllllIllllIlllllIIlIIIllI) {
            this.setBlockAndNotifyAdequately(llllllllllllIllllIlllllIIlIIIIll, llllllllllllIllllIlllllIIlIIIlIl, llllllllllllIllllIlllllIIlIIIlll);
        }
    }
}
