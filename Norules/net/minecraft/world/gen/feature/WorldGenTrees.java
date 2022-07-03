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

public class WorldGenTrees extends WorldGenAbstractTree
{
    private static final /* synthetic */ IBlockState DEFAULT_LEAF;
    private final /* synthetic */ IBlockState metaLeaves;
    private static final /* synthetic */ IBlockState DEFAULT_TRUNK;
    private final /* synthetic */ int minTreeHeight;
    private final /* synthetic */ boolean vinesGrow;
    private final /* synthetic */ IBlockState metaWood;
    
    private void addHangingVine(final World lllllllllllllIIIIlIlIllIIllllIlI, final BlockPos lllllllllllllIIIIlIlIllIIlllIIll, final PropertyBool lllllllllllllIIIIlIlIllIIlllIIlI) {
        this.addVine(lllllllllllllIIIIlIlIllIIllllIlI, lllllllllllllIIIIlIlIllIIlllIIll, lllllllllllllIIIIlIlIllIIlllIIlI);
        int lllllllllllllIIIIlIlIllIIlllIlll = 4;
        for (BlockPos lllllllllllllIIIIlIlIllIIlllIllI = lllllllllllllIIIIlIlIllIIlllIIll.down(); lllllllllllllIIIIlIlIllIIllllIlI.getBlockState(lllllllllllllIIIIlIlIllIIlllIllI).getMaterial() == Material.AIR && lllllllllllllIIIIlIlIllIIlllIlll > 0; lllllllllllllIIIIlIlIllIIlllIllI = lllllllllllllIIIIlIlIllIIlllIllI.down(), --lllllllllllllIIIIlIlIllIIlllIlll) {
            this.addVine(lllllllllllllIIIIlIlIllIIllllIlI, lllllllllllllIIIIlIlIllIIlllIllI, lllllllllllllIIIIlIlIllIIlllIIlI);
        }
    }
    
    @Override
    public boolean generate(final World lllllllllllllIIIIlIlIllIllIlIlII, final Random lllllllllllllIIIIlIlIllIllIlIIll, final BlockPos lllllllllllllIIIIlIlIllIlIlIllII) {
        final int lllllllllllllIIIIlIlIllIllIlIIIl = lllllllllllllIIIIlIlIllIllIlIIll.nextInt(3) + this.minTreeHeight;
        boolean lllllllllllllIIIIlIlIllIllIlIIII = true;
        if (lllllllllllllIIIIlIlIllIlIlIllII.getY() < 1 || lllllllllllllIIIIlIlIllIlIlIllII.getY() + lllllllllllllIIIIlIlIllIllIlIIIl + 1 > 256) {
            return false;
        }
        for (int lllllllllllllIIIIlIlIllIllIIllll = lllllllllllllIIIIlIlIllIlIlIllII.getY(); lllllllllllllIIIIlIlIllIllIIllll <= lllllllllllllIIIIlIlIllIlIlIllII.getY() + 1 + lllllllllllllIIIIlIlIllIllIlIIIl; ++lllllllllllllIIIIlIlIllIllIIllll) {
            int lllllllllllllIIIIlIlIllIllIIlllI = 1;
            if (lllllllllllllIIIIlIlIllIllIIllll == lllllllllllllIIIIlIlIllIlIlIllII.getY()) {
                lllllllllllllIIIIlIlIllIllIIlllI = 0;
            }
            if (lllllllllllllIIIIlIlIllIllIIllll >= lllllllllllllIIIIlIlIllIlIlIllII.getY() + 1 + lllllllllllllIIIIlIlIllIllIlIIIl - 2) {
                lllllllllllllIIIIlIlIllIllIIlllI = 2;
            }
            final BlockPos.MutableBlockPos lllllllllllllIIIIlIlIllIllIIllIl = new BlockPos.MutableBlockPos();
            for (int lllllllllllllIIIIlIlIllIllIIllII = lllllllllllllIIIIlIlIllIlIlIllII.getX() - lllllllllllllIIIIlIlIllIllIIlllI; lllllllllllllIIIIlIlIllIllIIllII <= lllllllllllllIIIIlIlIllIlIlIllII.getX() + lllllllllllllIIIIlIlIllIllIIlllI && lllllllllllllIIIIlIlIllIllIlIIII; ++lllllllllllllIIIIlIlIllIllIIllII) {
                for (int lllllllllllllIIIIlIlIllIllIIlIll = lllllllllllllIIIIlIlIllIlIlIllII.getZ() - lllllllllllllIIIIlIlIllIllIIlllI; lllllllllllllIIIIlIlIllIllIIlIll <= lllllllllllllIIIIlIlIllIlIlIllII.getZ() + lllllllllllllIIIIlIlIllIllIIlllI && lllllllllllllIIIIlIlIllIllIlIIII; ++lllllllllllllIIIIlIlIllIllIIlIll) {
                    if (lllllllllllllIIIIlIlIllIllIIllll >= 0 && lllllllllllllIIIIlIlIllIllIIllll < 256) {
                        if (!this.canGrowInto(lllllllllllllIIIIlIlIllIllIlIlII.getBlockState(lllllllllllllIIIIlIlIllIllIIllIl.setPos(lllllllllllllIIIIlIlIllIllIIllII, lllllllllllllIIIIlIlIllIllIIllll, lllllllllllllIIIIlIlIllIllIIlIll)).getBlock())) {
                            lllllllllllllIIIIlIlIllIllIlIIII = false;
                        }
                    }
                    else {
                        lllllllllllllIIIIlIlIllIllIlIIII = false;
                    }
                }
            }
        }
        if (!lllllllllllllIIIIlIlIllIllIlIIII) {
            return false;
        }
        final Block lllllllllllllIIIIlIlIllIllIIlIlI = lllllllllllllIIIIlIlIllIllIlIlII.getBlockState(lllllllllllllIIIIlIlIllIlIlIllII.down()).getBlock();
        if ((lllllllllllllIIIIlIlIllIllIIlIlI == Blocks.GRASS || lllllllllllllIIIIlIlIllIllIIlIlI == Blocks.DIRT || lllllllllllllIIIIlIlIllIllIIlIlI == Blocks.FARMLAND) && lllllllllllllIIIIlIlIllIlIlIllII.getY() < 256 - lllllllllllllIIIIlIlIllIllIlIIIl - 1) {
            this.setDirtAt(lllllllllllllIIIIlIlIllIllIlIlII, lllllllllllllIIIIlIlIllIlIlIllII.down());
            final int lllllllllllllIIIIlIlIllIllIIlIIl = 3;
            final int lllllllllllllIIIIlIlIllIllIIlIII = 0;
            for (int lllllllllllllIIIIlIlIllIllIIIlll = lllllllllllllIIIIlIlIllIlIlIllII.getY() - 3 + lllllllllllllIIIIlIlIllIllIlIIIl; lllllllllllllIIIIlIlIllIllIIIlll <= lllllllllllllIIIIlIlIllIlIlIllII.getY() + lllllllllllllIIIIlIlIllIllIlIIIl; ++lllllllllllllIIIIlIlIllIllIIIlll) {
                final int lllllllllllllIIIIlIlIllIllIIIllI = lllllllllllllIIIIlIlIllIllIIIlll - (lllllllllllllIIIIlIlIllIlIlIllII.getY() + lllllllllllllIIIIlIlIllIllIlIIIl);
                for (int lllllllllllllIIIIlIlIllIllIIIlIl = 1 - lllllllllllllIIIIlIlIllIllIIIllI / 2, lllllllllllllIIIIlIlIllIllIIIlII = lllllllllllllIIIIlIlIllIlIlIllII.getX() - lllllllllllllIIIIlIlIllIllIIIlIl; lllllllllllllIIIIlIlIllIllIIIlII <= lllllllllllllIIIIlIlIllIlIlIllII.getX() + lllllllllllllIIIIlIlIllIllIIIlIl; ++lllllllllllllIIIIlIlIllIllIIIlII) {
                    final int lllllllllllllIIIIlIlIllIllIIIIll = lllllllllllllIIIIlIlIllIllIIIlII - lllllllllllllIIIIlIlIllIlIlIllII.getX();
                    for (int lllllllllllllIIIIlIlIllIllIIIIlI = lllllllllllllIIIIlIlIllIlIlIllII.getZ() - lllllllllllllIIIIlIlIllIllIIIlIl; lllllllllllllIIIIlIlIllIllIIIIlI <= lllllllllllllIIIIlIlIllIlIlIllII.getZ() + lllllllllllllIIIIlIlIllIllIIIlIl; ++lllllllllllllIIIIlIlIllIllIIIIlI) {
                        final int lllllllllllllIIIIlIlIllIllIIIIIl = lllllllllllllIIIIlIlIllIllIIIIlI - lllllllllllllIIIIlIlIllIlIlIllII.getZ();
                        if (Math.abs(lllllllllllllIIIIlIlIllIllIIIIll) != lllllllllllllIIIIlIlIllIllIIIlIl || Math.abs(lllllllllllllIIIIlIlIllIllIIIIIl) != lllllllllllllIIIIlIlIllIllIIIlIl || (lllllllllllllIIIIlIlIllIllIlIIll.nextInt(2) != 0 && lllllllllllllIIIIlIlIllIllIIIllI != 0)) {
                            final BlockPos lllllllllllllIIIIlIlIllIllIIIIII = new BlockPos(lllllllllllllIIIIlIlIllIllIIIlII, lllllllllllllIIIIlIlIllIllIIIlll, lllllllllllllIIIIlIlIllIllIIIIlI);
                            final Material lllllllllllllIIIIlIlIllIlIllllll = lllllllllllllIIIIlIlIllIllIlIlII.getBlockState(lllllllllllllIIIIlIlIllIllIIIIII).getMaterial();
                            if (lllllllllllllIIIIlIlIllIlIllllll == Material.AIR || lllllllllllllIIIIlIlIllIlIllllll == Material.LEAVES || lllllllllllllIIIIlIlIllIlIllllll == Material.VINE) {
                                this.setBlockAndNotifyAdequately(lllllllllllllIIIIlIlIllIllIlIlII, lllllllllllllIIIIlIlIllIllIIIIII, this.metaLeaves);
                            }
                        }
                    }
                }
            }
            for (int lllllllllllllIIIIlIlIllIlIlllllI = 0; lllllllllllllIIIIlIlIllIlIlllllI < lllllllllllllIIIIlIlIllIllIlIIIl; ++lllllllllllllIIIIlIlIllIlIlllllI) {
                final Material lllllllllllllIIIIlIlIllIlIllllIl = lllllllllllllIIIIlIlIllIllIlIlII.getBlockState(lllllllllllllIIIIlIlIllIlIlIllII.up(lllllllllllllIIIIlIlIllIlIlllllI)).getMaterial();
                if (lllllllllllllIIIIlIlIllIlIllllIl == Material.AIR || lllllllllllllIIIIlIlIllIlIllllIl == Material.LEAVES || lllllllllllllIIIIlIlIllIlIllllIl == Material.VINE) {
                    this.setBlockAndNotifyAdequately(lllllllllllllIIIIlIlIllIllIlIlII, lllllllllllllIIIIlIlIllIlIlIllII.up(lllllllllllllIIIIlIlIllIlIlllllI), this.metaWood);
                    if (this.vinesGrow && lllllllllllllIIIIlIlIllIlIlllllI > 0) {
                        if (lllllllllllllIIIIlIlIllIllIlIIll.nextInt(3) > 0 && lllllllllllllIIIIlIlIllIllIlIlII.isAirBlock(lllllllllllllIIIIlIlIllIlIlIllII.add(-1, lllllllllllllIIIIlIlIllIlIlllllI, 0))) {
                            this.addVine(lllllllllllllIIIIlIlIllIllIlIlII, lllllllllllllIIIIlIlIllIlIlIllII.add(-1, lllllllllllllIIIIlIlIllIlIlllllI, 0), BlockVine.EAST);
                        }
                        if (lllllllllllllIIIIlIlIllIllIlIIll.nextInt(3) > 0 && lllllllllllllIIIIlIlIllIllIlIlII.isAirBlock(lllllllllllllIIIIlIlIllIlIlIllII.add(1, lllllllllllllIIIIlIlIllIlIlllllI, 0))) {
                            this.addVine(lllllllllllllIIIIlIlIllIllIlIlII, lllllllllllllIIIIlIlIllIlIlIllII.add(1, lllllllllllllIIIIlIlIllIlIlllllI, 0), BlockVine.WEST);
                        }
                        if (lllllllllllllIIIIlIlIllIllIlIIll.nextInt(3) > 0 && lllllllllllllIIIIlIlIllIllIlIlII.isAirBlock(lllllllllllllIIIIlIlIllIlIlIllII.add(0, lllllllllllllIIIIlIlIllIlIlllllI, -1))) {
                            this.addVine(lllllllllllllIIIIlIlIllIllIlIlII, lllllllllllllIIIIlIlIllIlIlIllII.add(0, lllllllllllllIIIIlIlIllIlIlllllI, -1), BlockVine.SOUTH);
                        }
                        if (lllllllllllllIIIIlIlIllIllIlIIll.nextInt(3) > 0 && lllllllllllllIIIIlIlIllIllIlIlII.isAirBlock(lllllllllllllIIIIlIlIllIlIlIllII.add(0, lllllllllllllIIIIlIlIllIlIlllllI, 1))) {
                            this.addVine(lllllllllllllIIIIlIlIllIllIlIlII, lllllllllllllIIIIlIlIllIlIlIllII.add(0, lllllllllllllIIIIlIlIllIlIlllllI, 1), BlockVine.NORTH);
                        }
                    }
                }
            }
            if (this.vinesGrow) {
                for (int lllllllllllllIIIIlIlIllIlIllllII = lllllllllllllIIIIlIlIllIlIlIllII.getY() - 3 + lllllllllllllIIIIlIlIllIllIlIIIl; lllllllllllllIIIIlIlIllIlIllllII <= lllllllllllllIIIIlIlIllIlIlIllII.getY() + lllllllllllllIIIIlIlIllIllIlIIIl; ++lllllllllllllIIIIlIlIllIlIllllII) {
                    final int lllllllllllllIIIIlIlIllIlIlllIll = lllllllllllllIIIIlIlIllIlIllllII - (lllllllllllllIIIIlIlIllIlIlIllII.getY() + lllllllllllllIIIIlIlIllIllIlIIIl);
                    final int lllllllllllllIIIIlIlIllIlIlllIlI = 2 - lllllllllllllIIIIlIlIllIlIlllIll / 2;
                    final BlockPos.MutableBlockPos lllllllllllllIIIIlIlIllIlIlllIIl = new BlockPos.MutableBlockPos();
                    for (int lllllllllllllIIIIlIlIllIlIlllIII = lllllllllllllIIIIlIlIllIlIlIllII.getX() - lllllllllllllIIIIlIlIllIlIlllIlI; lllllllllllllIIIIlIlIllIlIlllIII <= lllllllllllllIIIIlIlIllIlIlIllII.getX() + lllllllllllllIIIIlIlIllIlIlllIlI; ++lllllllllllllIIIIlIlIllIlIlllIII) {
                        for (int lllllllllllllIIIIlIlIllIlIllIlll = lllllllllllllIIIIlIlIllIlIlIllII.getZ() - lllllllllllllIIIIlIlIllIlIlllIlI; lllllllllllllIIIIlIlIllIlIllIlll <= lllllllllllllIIIIlIlIllIlIlIllII.getZ() + lllllllllllllIIIIlIlIllIlIlllIlI; ++lllllllllllllIIIIlIlIllIlIllIlll) {
                            lllllllllllllIIIIlIlIllIlIlllIIl.setPos(lllllllllllllIIIIlIlIllIlIlllIII, lllllllllllllIIIIlIlIllIlIllllII, lllllllllllllIIIIlIlIllIlIllIlll);
                            if (lllllllllllllIIIIlIlIllIllIlIlII.getBlockState(lllllllllllllIIIIlIlIllIlIlllIIl).getMaterial() == Material.LEAVES) {
                                final BlockPos lllllllllllllIIIIlIlIllIlIllIllI = lllllllllllllIIIIlIlIllIlIlllIIl.west();
                                final BlockPos lllllllllllllIIIIlIlIllIlIllIlIl = lllllllllllllIIIIlIlIllIlIlllIIl.east();
                                final BlockPos lllllllllllllIIIIlIlIllIlIllIlII = lllllllllllllIIIIlIlIllIlIlllIIl.north();
                                final BlockPos lllllllllllllIIIIlIlIllIlIllIIll = lllllllllllllIIIIlIlIllIlIlllIIl.south();
                                if (lllllllllllllIIIIlIlIllIllIlIIll.nextInt(4) == 0 && lllllllllllllIIIIlIlIllIllIlIlII.getBlockState(lllllllllllllIIIIlIlIllIlIllIllI).getMaterial() == Material.AIR) {
                                    this.addHangingVine(lllllllllllllIIIIlIlIllIllIlIlII, lllllllllllllIIIIlIlIllIlIllIllI, BlockVine.EAST);
                                }
                                if (lllllllllllllIIIIlIlIllIllIlIIll.nextInt(4) == 0 && lllllllllllllIIIIlIlIllIllIlIlII.getBlockState(lllllllllllllIIIIlIlIllIlIllIlIl).getMaterial() == Material.AIR) {
                                    this.addHangingVine(lllllllllllllIIIIlIlIllIllIlIlII, lllllllllllllIIIIlIlIllIlIllIlIl, BlockVine.WEST);
                                }
                                if (lllllllllllllIIIIlIlIllIllIlIIll.nextInt(4) == 0 && lllllllllllllIIIIlIlIllIllIlIlII.getBlockState(lllllllllllllIIIIlIlIllIlIllIlII).getMaterial() == Material.AIR) {
                                    this.addHangingVine(lllllllllllllIIIIlIlIllIllIlIlII, lllllllllllllIIIIlIlIllIlIllIlII, BlockVine.SOUTH);
                                }
                                if (lllllllllllllIIIIlIlIllIllIlIIll.nextInt(4) == 0 && lllllllllllllIIIIlIlIllIllIlIlII.getBlockState(lllllllllllllIIIIlIlIllIlIllIIll).getMaterial() == Material.AIR) {
                                    this.addHangingVine(lllllllllllllIIIIlIlIllIllIlIlII, lllllllllllllIIIIlIlIllIlIllIIll, BlockVine.NORTH);
                                }
                            }
                        }
                    }
                }
                if (lllllllllllllIIIIlIlIllIllIlIIll.nextInt(5) == 0 && lllllllllllllIIIIlIlIllIllIlIIIl > 5) {
                    for (int lllllllllllllIIIIlIlIllIlIllIIlI = 0; lllllllllllllIIIIlIlIllIlIllIIlI < 2; ++lllllllllllllIIIIlIlIllIlIllIIlI) {
                        for (final EnumFacing lllllllllllllIIIIlIlIllIlIllIIIl : EnumFacing.Plane.HORIZONTAL) {
                            if (lllllllllllllIIIIlIlIllIllIlIIll.nextInt(4 - lllllllllllllIIIIlIlIllIlIllIIlI) == 0) {
                                final EnumFacing lllllllllllllIIIIlIlIllIlIllIIII = lllllllllllllIIIIlIlIllIlIllIIIl.getOpposite();
                                this.placeCocoa(lllllllllllllIIIIlIlIllIllIlIlII, lllllllllllllIIIIlIlIllIllIlIIll.nextInt(3), lllllllllllllIIIIlIlIllIlIlIllII.add(lllllllllllllIIIIlIlIllIlIllIIII.getFrontOffsetX(), lllllllllllllIIIIlIlIllIllIlIIIl - 5 + lllllllllllllIIIIlIlIllIlIllIIlI, lllllllllllllIIIIlIlIllIlIllIIII.getFrontOffsetZ()), lllllllllllllIIIIlIlIllIlIllIIIl);
                            }
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }
    
    public WorldGenTrees(final boolean lllllllllllllIIIIlIlIllIllllIIll, final int lllllllllllllIIIIlIlIllIllllIIlI, final IBlockState lllllllllllllIIIIlIlIllIlllIlIll, final IBlockState lllllllllllllIIIIlIlIllIlllIlIlI, final boolean lllllllllllllIIIIlIlIllIlllIlIIl) {
        super(lllllllllllllIIIIlIlIllIllllIIll);
        this.minTreeHeight = lllllllllllllIIIIlIlIllIllllIIlI;
        this.metaWood = lllllllllllllIIIIlIlIllIlllIlIll;
        this.metaLeaves = lllllllllllllIIIIlIlIllIlllIlIlI;
        this.vinesGrow = lllllllllllllIIIIlIlIllIlllIlIIl;
    }
    
    private void placeCocoa(final World lllllllllllllIIIIlIlIllIlIIlIllI, final int lllllllllllllIIIIlIlIllIlIIlIIII, final BlockPos lllllllllllllIIIIlIlIllIlIIlIlII, final EnumFacing lllllllllllllIIIIlIlIllIlIIIlllI) {
        this.setBlockAndNotifyAdequately(lllllllllllllIIIIlIlIllIlIIlIllI, lllllllllllllIIIIlIlIllIlIIlIlII, Blocks.COCOA.getDefaultState().withProperty((IProperty<Comparable>)BlockCocoa.AGE, lllllllllllllIIIIlIlIllIlIIlIIII).withProperty((IProperty<Comparable>)BlockCocoa.FACING, lllllllllllllIIIIlIlIllIlIIIlllI));
    }
    
    private void addVine(final World lllllllllllllIIIIlIlIllIlIIIlIII, final BlockPos lllllllllllllIIIIlIlIllIlIIIIIll, final PropertyBool lllllllllllllIIIIlIlIllIlIIIIIlI) {
        this.setBlockAndNotifyAdequately(lllllllllllllIIIIlIlIllIlIIIlIII, lllllllllllllIIIIlIlIllIlIIIIIll, Blocks.VINE.getDefaultState().withProperty((IProperty<Comparable>)lllllllllllllIIIIlIlIllIlIIIIIlI, true));
    }
    
    static {
        DEFAULT_TRUNK = Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.OAK);
        DEFAULT_LEAF = Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.OAK).withProperty((IProperty<Comparable>)BlockLeaves.CHECK_DECAY, false);
    }
    
    public WorldGenTrees(final boolean lllllllllllllIIIIlIlIllIlllllIll) {
        this(lllllllllllllIIIIlIlIllIlllllIll, 4, WorldGenTrees.DEFAULT_TRUNK, WorldGenTrees.DEFAULT_LEAF, false);
    }
}
