package net.minecraft.world.gen.feature;

import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.math.*;
import net.minecraft.init.*;
import net.minecraft.block.material.*;
import net.minecraft.block.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;

public class WorldGenBigMushroom extends WorldGenerator
{
    private final /* synthetic */ Block mushroomType;
    
    @Override
    public boolean generate(final World lllllllllllllIlIllIlIlIlllllllII, final Random lllllllllllllIlIllIlIlIllllllIll, final BlockPos lllllllllllllIlIllIlIlIllllllIlI) {
        Block lllllllllllllIlIllIlIlIllllllIIl = this.mushroomType;
        if (lllllllllllllIlIllIlIlIllllllIIl == null) {
            lllllllllllllIlIllIlIlIllllllIIl = (lllllllllllllIlIllIlIlIllllllIll.nextBoolean() ? Blocks.BROWN_MUSHROOM_BLOCK : Blocks.RED_MUSHROOM_BLOCK);
        }
        int lllllllllllllIlIllIlIlIllllllIII = lllllllllllllIlIllIlIlIllllllIll.nextInt(3) + 4;
        if (lllllllllllllIlIllIlIlIllllllIll.nextInt(12) == 0) {
            lllllllllllllIlIllIlIlIllllllIII *= 2;
        }
        boolean lllllllllllllIlIllIlIlIlllllIlll = true;
        if (lllllllllllllIlIllIlIlIllllllIlI.getY() < 1 || lllllllllllllIlIllIlIlIllllllIlI.getY() + lllllllllllllIlIllIlIlIllllllIII + 1 >= 256) {
            return false;
        }
        for (int lllllllllllllIlIllIlIlIlllllIllI = lllllllllllllIlIllIlIlIllllllIlI.getY(); lllllllllllllIlIllIlIlIlllllIllI <= lllllllllllllIlIllIlIlIllllllIlI.getY() + 1 + lllllllllllllIlIllIlIlIllllllIII; ++lllllllllllllIlIllIlIlIlllllIllI) {
            int lllllllllllllIlIllIlIlIlllllIlIl = 3;
            if (lllllllllllllIlIllIlIlIlllllIllI <= lllllllllllllIlIllIlIlIllllllIlI.getY() + 3) {
                lllllllllllllIlIllIlIlIlllllIlIl = 0;
            }
            final BlockPos.MutableBlockPos lllllllllllllIlIllIlIlIlllllIlII = new BlockPos.MutableBlockPos();
            for (int lllllllllllllIlIllIlIlIlllllIIll = lllllllllllllIlIllIlIlIllllllIlI.getX() - lllllllllllllIlIllIlIlIlllllIlIl; lllllllllllllIlIllIlIlIlllllIIll <= lllllllllllllIlIllIlIlIllllllIlI.getX() + lllllllllllllIlIllIlIlIlllllIlIl && lllllllllllllIlIllIlIlIlllllIlll; ++lllllllllllllIlIllIlIlIlllllIIll) {
                for (int lllllllllllllIlIllIlIlIlllllIIlI = lllllllllllllIlIllIlIlIllllllIlI.getZ() - lllllllllllllIlIllIlIlIlllllIlIl; lllllllllllllIlIllIlIlIlllllIIlI <= lllllllllllllIlIllIlIlIllllllIlI.getZ() + lllllllllllllIlIllIlIlIlllllIlIl && lllllllllllllIlIllIlIlIlllllIlll; ++lllllllllllllIlIllIlIlIlllllIIlI) {
                    if (lllllllllllllIlIllIlIlIlllllIllI >= 0 && lllllllllllllIlIllIlIlIlllllIllI < 256) {
                        final Material lllllllllllllIlIllIlIlIlllllIIIl = lllllllllllllIlIllIlIlIlllllllII.getBlockState(lllllllllllllIlIllIlIlIlllllIlII.setPos(lllllllllllllIlIllIlIlIlllllIIll, lllllllllllllIlIllIlIlIlllllIllI, lllllllllllllIlIllIlIlIlllllIIlI)).getMaterial();
                        if (lllllllllllllIlIllIlIlIlllllIIIl != Material.AIR && lllllllllllllIlIllIlIlIlllllIIIl != Material.LEAVES) {
                            lllllllllllllIlIllIlIlIlllllIlll = false;
                        }
                    }
                    else {
                        lllllllllllllIlIllIlIlIlllllIlll = false;
                    }
                }
            }
        }
        if (!lllllllllllllIlIllIlIlIlllllIlll) {
            return false;
        }
        final Block lllllllllllllIlIllIlIlIlllllIIII = lllllllllllllIlIllIlIlIlllllllII.getBlockState(lllllllllllllIlIllIlIlIllllllIlI.down()).getBlock();
        if (lllllllllllllIlIllIlIlIlllllIIII != Blocks.DIRT && lllllllllllllIlIllIlIlIlllllIIII != Blocks.GRASS && lllllllllllllIlIllIlIlIlllllIIII != Blocks.MYCELIUM) {
            return false;
        }
        int lllllllllllllIlIllIlIlIllllIllll = lllllllllllllIlIllIlIlIllllllIlI.getY() + lllllllllllllIlIllIlIlIllllllIII;
        if (lllllllllllllIlIllIlIlIllllllIIl == Blocks.RED_MUSHROOM_BLOCK) {
            lllllllllllllIlIllIlIlIllllIllll = lllllllllllllIlIllIlIlIllllllIlI.getY() + lllllllllllllIlIllIlIlIllllllIII - 3;
        }
        for (int lllllllllllllIlIllIlIlIllllIlllI = lllllllllllllIlIllIlIlIllllIllll; lllllllllllllIlIllIlIlIllllIlllI <= lllllllllllllIlIllIlIlIllllllIlI.getY() + lllllllllllllIlIllIlIlIllllllIII; ++lllllllllllllIlIllIlIlIllllIlllI) {
            int lllllllllllllIlIllIlIlIllllIllIl = 1;
            if (lllllllllllllIlIllIlIlIllllIlllI < lllllllllllllIlIllIlIlIllllllIlI.getY() + lllllllllllllIlIllIlIlIllllllIII) {
                ++lllllllllllllIlIllIlIlIllllIllIl;
            }
            if (lllllllllllllIlIllIlIlIllllllIIl == Blocks.BROWN_MUSHROOM_BLOCK) {
                lllllllllllllIlIllIlIlIllllIllIl = 3;
            }
            final int lllllllllllllIlIllIlIlIllllIllII = lllllllllllllIlIllIlIlIllllllIlI.getX() - lllllllllllllIlIllIlIlIllllIllIl;
            final int lllllllllllllIlIllIlIlIllllIlIll = lllllllllllllIlIllIlIlIllllllIlI.getX() + lllllllllllllIlIllIlIlIllllIllIl;
            final int lllllllllllllIlIllIlIlIllllIlIlI = lllllllllllllIlIllIlIlIllllllIlI.getZ() - lllllllllllllIlIllIlIlIllllIllIl;
            final int lllllllllllllIlIllIlIlIllllIlIIl = lllllllllllllIlIllIlIlIllllllIlI.getZ() + lllllllllllllIlIllIlIlIllllIllIl;
            for (int lllllllllllllIlIllIlIlIllllIIlll = lllllllllllllIlIllIlIlIllllIllII; lllllllllllllIlIllIlIlIllllIIlll <= lllllllllllllIlIllIlIlIllllIlIll; ++lllllllllllllIlIllIlIlIllllIIlll) {
                for (int lllllllllllllIlIllIlIlIllllIIlIl = lllllllllllllIlIllIlIlIllllIlIlI; lllllllllllllIlIllIlIlIllllIIlIl <= lllllllllllllIlIllIlIlIllllIlIIl; ++lllllllllllllIlIllIlIlIllllIIlIl) {
                    int lllllllllllllIlIllIlIlIllllIIlII = 5;
                    if (lllllllllllllIlIllIlIlIllllIIlll == lllllllllllllIlIllIlIlIllllIllII) {
                        --lllllllllllllIlIllIlIlIllllIIlII;
                    }
                    else if (lllllllllllllIlIllIlIlIllllIIlll == lllllllllllllIlIllIlIlIllllIlIll) {
                        ++lllllllllllllIlIllIlIlIllllIIlII;
                    }
                    if (lllllllllllllIlIllIlIlIllllIIlIl == lllllllllllllIlIllIlIlIllllIlIlI) {
                        lllllllllllllIlIllIlIlIllllIIlII -= 3;
                    }
                    else if (lllllllllllllIlIllIlIlIllllIIlIl == lllllllllllllIlIllIlIlIllllIlIIl) {
                        lllllllllllllIlIllIlIlIllllIIlII += 3;
                    }
                    BlockHugeMushroom.EnumType lllllllllllllIlIllIlIlIllllIIIlI = BlockHugeMushroom.EnumType.byMetadata(lllllllllllllIlIllIlIlIllllIIlII);
                    if (lllllllllllllIlIllIlIlIllllllIIl == Blocks.BROWN_MUSHROOM_BLOCK || lllllllllllllIlIllIlIlIllllIlllI < lllllllllllllIlIllIlIlIllllllIlI.getY() + lllllllllllllIlIllIlIlIllllllIII) {
                        if (lllllllllllllIlIllIlIlIllllIIlll == lllllllllllllIlIllIlIlIllllIllII || lllllllllllllIlIllIlIlIllllIIlll == lllllllllllllIlIllIlIlIllllIlIll) {
                            if (lllllllllllllIlIllIlIlIllllIIlIl == lllllllllllllIlIllIlIlIllllIlIlI) {
                                continue;
                            }
                            if (lllllllllllllIlIllIlIlIllllIIlIl == lllllllllllllIlIllIlIlIllllIlIIl) {
                                continue;
                            }
                        }
                        if (lllllllllllllIlIllIlIlIllllIIlll == lllllllllllllIlIllIlIlIllllllIlI.getX() - (lllllllllllllIlIllIlIlIllllIllIl - 1) && lllllllllllllIlIllIlIlIllllIIlIl == lllllllllllllIlIllIlIlIllllIlIlI) {
                            lllllllllllllIlIllIlIlIllllIIIlI = BlockHugeMushroom.EnumType.NORTH_WEST;
                        }
                        if (lllllllllllllIlIllIlIlIllllIIlll == lllllllllllllIlIllIlIlIllllIllII && lllllllllllllIlIllIlIlIllllIIlIl == lllllllllllllIlIllIlIlIllllllIlI.getZ() - (lllllllllllllIlIllIlIlIllllIllIl - 1)) {
                            lllllllllllllIlIllIlIlIllllIIIlI = BlockHugeMushroom.EnumType.NORTH_WEST;
                        }
                        if (lllllllllllllIlIllIlIlIllllIIlll == lllllllllllllIlIllIlIlIllllllIlI.getX() + (lllllllllllllIlIllIlIlIllllIllIl - 1) && lllllllllllllIlIllIlIlIllllIIlIl == lllllllllllllIlIllIlIlIllllIlIlI) {
                            lllllllllllllIlIllIlIlIllllIIIlI = BlockHugeMushroom.EnumType.NORTH_EAST;
                        }
                        if (lllllllllllllIlIllIlIlIllllIIlll == lllllllllllllIlIllIlIlIllllIlIll && lllllllllllllIlIllIlIlIllllIIlIl == lllllllllllllIlIllIlIlIllllllIlI.getZ() - (lllllllllllllIlIllIlIlIllllIllIl - 1)) {
                            lllllllllllllIlIllIlIlIllllIIIlI = BlockHugeMushroom.EnumType.NORTH_EAST;
                        }
                        if (lllllllllllllIlIllIlIlIllllIIlll == lllllllllllllIlIllIlIlIllllllIlI.getX() - (lllllllllllllIlIllIlIlIllllIllIl - 1) && lllllllllllllIlIllIlIlIllllIIlIl == lllllllllllllIlIllIlIlIllllIlIIl) {
                            lllllllllllllIlIllIlIlIllllIIIlI = BlockHugeMushroom.EnumType.SOUTH_WEST;
                        }
                        if (lllllllllllllIlIllIlIlIllllIIlll == lllllllllllllIlIllIlIlIllllIllII && lllllllllllllIlIllIlIlIllllIIlIl == lllllllllllllIlIllIlIlIllllllIlI.getZ() + (lllllllllllllIlIllIlIlIllllIllIl - 1)) {
                            lllllllllllllIlIllIlIlIllllIIIlI = BlockHugeMushroom.EnumType.SOUTH_WEST;
                        }
                        if (lllllllllllllIlIllIlIlIllllIIlll == lllllllllllllIlIllIlIlIllllllIlI.getX() + (lllllllllllllIlIllIlIlIllllIllIl - 1) && lllllllllllllIlIllIlIlIllllIIlIl == lllllllllllllIlIllIlIlIllllIlIIl) {
                            lllllllllllllIlIllIlIlIllllIIIlI = BlockHugeMushroom.EnumType.SOUTH_EAST;
                        }
                        if (lllllllllllllIlIllIlIlIllllIIlll == lllllllllllllIlIllIlIlIllllIlIll && lllllllllllllIlIllIlIlIllllIIlIl == lllllllllllllIlIllIlIlIllllllIlI.getZ() + (lllllllllllllIlIllIlIlIllllIllIl - 1)) {
                            lllllllllllllIlIllIlIlIllllIIIlI = BlockHugeMushroom.EnumType.SOUTH_EAST;
                        }
                    }
                    if (lllllllllllllIlIllIlIlIllllIIIlI == BlockHugeMushroom.EnumType.CENTER && lllllllllllllIlIllIlIlIllllIlllI < lllllllllllllIlIllIlIlIllllllIlI.getY() + lllllllllllllIlIllIlIlIllllllIII) {
                        lllllllllllllIlIllIlIlIllllIIIlI = BlockHugeMushroom.EnumType.ALL_INSIDE;
                    }
                    if (lllllllllllllIlIllIlIlIllllllIlI.getY() >= lllllllllllllIlIllIlIlIllllllIlI.getY() + lllllllllllllIlIllIlIlIllllllIII - 1 || lllllllllllllIlIllIlIlIllllIIIlI != BlockHugeMushroom.EnumType.ALL_INSIDE) {
                        final BlockPos lllllllllllllIlIllIlIlIllllIIIII = new BlockPos(lllllllllllllIlIllIlIlIllllIIlll, lllllllllllllIlIllIlIlIllllIlllI, lllllllllllllIlIllIlIlIllllIIlIl);
                        if (!lllllllllllllIlIllIlIlIlllllllII.getBlockState(lllllllllllllIlIllIlIlIllllIIIII).isFullBlock()) {
                            this.setBlockAndNotifyAdequately(lllllllllllllIlIllIlIlIlllllllII, lllllllllllllIlIllIlIlIllllIIIII, lllllllllllllIlIllIlIlIllllllIIl.getDefaultState().withProperty(BlockHugeMushroom.VARIANT, lllllllllllllIlIllIlIlIllllIIIlI));
                        }
                    }
                }
            }
        }
        for (int lllllllllllllIlIllIlIlIlllIllllI = 0; lllllllllllllIlIllIlIlIlllIllllI < lllllllllllllIlIllIlIlIllllllIII; ++lllllllllllllIlIllIlIlIlllIllllI) {
            final IBlockState lllllllllllllIlIllIlIlIlllIlllII = lllllllllllllIlIllIlIlIlllllllII.getBlockState(lllllllllllllIlIllIlIlIllllllIlI.up(lllllllllllllIlIllIlIlIlllIllllI));
            if (!lllllllllllllIlIllIlIlIlllIlllII.isFullBlock()) {
                this.setBlockAndNotifyAdequately(lllllllllllllIlIllIlIlIlllllllII, lllllllllllllIlIllIlIlIllllllIlI.up(lllllllllllllIlIllIlIlIlllIllllI), lllllllllllllIlIllIlIlIllllllIIl.getDefaultState().withProperty(BlockHugeMushroom.VARIANT, BlockHugeMushroom.EnumType.STEM));
            }
        }
        return true;
    }
    
    public WorldGenBigMushroom() {
        super(false);
        this.mushroomType = null;
    }
    
    public WorldGenBigMushroom(final Block lllllllllllllIlIllIlIllIIIIlIlll) {
        super(true);
        this.mushroomType = lllllllllllllIlIllIlIllIIIIlIlll;
    }
}
