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

public class WorldGenCanopyTree extends WorldGenAbstractTree
{
    private static final /* synthetic */ IBlockState DARK_OAK_LEAVES;
    private static final /* synthetic */ IBlockState DARK_OAK_LOG;
    
    private void placeLogAt(final World lllllllllllllIIIlllIIlIIllIIllII, final BlockPos lllllllllllllIIIlllIIlIIllIIlllI) {
        if (this.canGrowInto(lllllllllllllIIIlllIIlIIllIIllII.getBlockState(lllllllllllllIIIlllIIlIIllIIlllI).getBlock())) {
            this.setBlockAndNotifyAdequately(lllllllllllllIIIlllIIlIIllIIllII, lllllllllllllIIIlllIIlIIllIIlllI, WorldGenCanopyTree.DARK_OAK_LOG);
        }
    }
    
    private boolean placeTreeOfHeight(final World lllllllllllllIIIlllIIlIIllIllllI, final BlockPos lllllllllllllIIIlllIIlIIllIlllIl, final int lllllllllllllIIIlllIIlIIlllIlIII) {
        final int lllllllllllllIIIlllIIlIIlllIIlll = lllllllllllllIIIlllIIlIIllIlllIl.getX();
        final int lllllllllllllIIIlllIIlIIlllIIllI = lllllllllllllIIIlllIIlIIllIlllIl.getY();
        final int lllllllllllllIIIlllIIlIIlllIIlIl = lllllllllllllIIIlllIIlIIllIlllIl.getZ();
        final BlockPos.MutableBlockPos lllllllllllllIIIlllIIlIIlllIIlII = new BlockPos.MutableBlockPos();
        for (int lllllllllllllIIIlllIIlIIlllIIIll = 0; lllllllllllllIIIlllIIlIIlllIIIll <= lllllllllllllIIIlllIIlIIlllIlIII + 1; ++lllllllllllllIIIlllIIlIIlllIIIll) {
            int lllllllllllllIIIlllIIlIIlllIIIlI = 1;
            if (lllllllllllllIIIlllIIlIIlllIIIll == 0) {
                lllllllllllllIIIlllIIlIIlllIIIlI = 0;
            }
            if (lllllllllllllIIIlllIIlIIlllIIIll >= lllllllllllllIIIlllIIlIIlllIlIII - 1) {
                lllllllllllllIIIlllIIlIIlllIIIlI = 2;
            }
            for (int lllllllllllllIIIlllIIlIIlllIIIIl = -lllllllllllllIIIlllIIlIIlllIIIlI; lllllllllllllIIIlllIIlIIlllIIIIl <= lllllllllllllIIIlllIIlIIlllIIIlI; ++lllllllllllllIIIlllIIlIIlllIIIIl) {
                for (int lllllllllllllIIIlllIIlIIlllIIIII = -lllllllllllllIIIlllIIlIIlllIIIlI; lllllllllllllIIIlllIIlIIlllIIIII <= lllllllllllllIIIlllIIlIIlllIIIlI; ++lllllllllllllIIIlllIIlIIlllIIIII) {
                    if (!this.canGrowInto(lllllllllllllIIIlllIIlIIllIllllI.getBlockState(lllllllllllllIIIlllIIlIIlllIIlII.setPos(lllllllllllllIIIlllIIlIIlllIIlll + lllllllllllllIIIlllIIlIIlllIIIIl, lllllllllllllIIIlllIIlIIlllIIllI + lllllllllllllIIIlllIIlIIlllIIIll, lllllllllllllIIIlllIIlIIlllIIlIl + lllllllllllllIIIlllIIlIIlllIIIII)).getBlock())) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    private void placeLeafAt(final World lllllllllllllIIIlllIIlIIlIlllIll, final int lllllllllllllIIIlllIIlIIlIlllIlI, final int lllllllllllllIIIlllIIlIIlIlllIIl, final int lllllllllllllIIIlllIIlIIlIllllll) {
        final BlockPos lllllllllllllIIIlllIIlIIlIlllllI = new BlockPos(lllllllllllllIIIlllIIlIIlIlllIlI, lllllllllllllIIIlllIIlIIlIlllIIl, lllllllllllllIIIlllIIlIIlIllllll);
        final Material lllllllllllllIIIlllIIlIIlIllllIl = lllllllllllllIIIlllIIlIIlIlllIll.getBlockState(lllllllllllllIIIlllIIlIIlIlllllI).getMaterial();
        if (lllllllllllllIIIlllIIlIIlIllllIl == Material.AIR) {
            this.setBlockAndNotifyAdequately(lllllllllllllIIIlllIIlIIlIlllIll, lllllllllllllIIIlllIIlIIlIlllllI, WorldGenCanopyTree.DARK_OAK_LEAVES);
        }
    }
    
    @Override
    public boolean generate(final World lllllllllllllIIIlllIIlIlIIIIlIll, final Random lllllllllllllIIIlllIIlIlIIlIlIll, final BlockPos lllllllllllllIIIlllIIlIlIIIIlIIl) {
        final int lllllllllllllIIIlllIIlIlIIlIlIIl = lllllllllllllIIIlllIIlIlIIlIlIll.nextInt(3) + lllllllllllllIIIlllIIlIlIIlIlIll.nextInt(2) + 6;
        final int lllllllllllllIIIlllIIlIlIIlIlIII = lllllllllllllIIIlllIIlIlIIIIlIIl.getX();
        final int lllllllllllllIIIlllIIlIlIIlIIlll = lllllllllllllIIIlllIIlIlIIIIlIIl.getY();
        final int lllllllllllllIIIlllIIlIlIIlIIllI = lllllllllllllIIIlllIIlIlIIIIlIIl.getZ();
        if (lllllllllllllIIIlllIIlIlIIlIIlll < 1 || lllllllllllllIIIlllIIlIlIIlIIlll + lllllllllllllIIIlllIIlIlIIlIlIIl + 1 >= 256) {
            return false;
        }
        final BlockPos lllllllllllllIIIlllIIlIlIIlIIlIl = lllllllllllllIIIlllIIlIlIIIIlIIl.down();
        final Block lllllllllllllIIIlllIIlIlIIlIIlII = lllllllllllllIIIlllIIlIlIIIIlIll.getBlockState(lllllllllllllIIIlllIIlIlIIlIIlIl).getBlock();
        if (lllllllllllllIIIlllIIlIlIIlIIlII != Blocks.GRASS && lllllllllllllIIIlllIIlIlIIlIIlII != Blocks.DIRT) {
            return false;
        }
        if (!this.placeTreeOfHeight(lllllllllllllIIIlllIIlIlIIIIlIll, lllllllllllllIIIlllIIlIlIIIIlIIl, lllllllllllllIIIlllIIlIlIIlIlIIl)) {
            return false;
        }
        this.setDirtAt(lllllllllllllIIIlllIIlIlIIIIlIll, lllllllllllllIIIlllIIlIlIIlIIlIl);
        this.setDirtAt(lllllllllllllIIIlllIIlIlIIIIlIll, lllllllllllllIIIlllIIlIlIIlIIlIl.east());
        this.setDirtAt(lllllllllllllIIIlllIIlIlIIIIlIll, lllllllllllllIIIlllIIlIlIIlIIlIl.south());
        this.setDirtAt(lllllllllllllIIIlllIIlIlIIIIlIll, lllllllllllllIIIlllIIlIlIIlIIlIl.south().east());
        final EnumFacing lllllllllllllIIIlllIIlIlIIlIIIll = EnumFacing.Plane.HORIZONTAL.random(lllllllllllllIIIlllIIlIlIIlIlIll);
        final int lllllllllllllIIIlllIIlIlIIlIIIlI = lllllllllllllIIIlllIIlIlIIlIlIIl - lllllllllllllIIIlllIIlIlIIlIlIll.nextInt(4);
        int lllllllllllllIIIlllIIlIlIIlIIIIl = 2 - lllllllllllllIIIlllIIlIlIIlIlIll.nextInt(3);
        int lllllllllllllIIIlllIIlIlIIlIIIII = lllllllllllllIIIlllIIlIlIIlIlIII;
        int lllllllllllllIIIlllIIlIlIIIlllll = lllllllllllllIIIlllIIlIlIIlIIllI;
        final int lllllllllllllIIIlllIIlIlIIIllllI = lllllllllllllIIIlllIIlIlIIlIIlll + lllllllllllllIIIlllIIlIlIIlIlIIl - 1;
        for (int lllllllllllllIIIlllIIlIlIIIlllIl = 0; lllllllllllllIIIlllIIlIlIIIlllIl < lllllllllllllIIIlllIIlIlIIlIlIIl; ++lllllllllllllIIIlllIIlIlIIIlllIl) {
            if (lllllllllllllIIIlllIIlIlIIIlllIl >= lllllllllllllIIIlllIIlIlIIlIIIlI && lllllllllllllIIIlllIIlIlIIlIIIIl > 0) {
                lllllllllllllIIIlllIIlIlIIlIIIII += lllllllllllllIIIlllIIlIlIIlIIIll.getFrontOffsetX();
                lllllllllllllIIIlllIIlIlIIIlllll += lllllllllllllIIIlllIIlIlIIlIIIll.getFrontOffsetZ();
                --lllllllllllllIIIlllIIlIlIIlIIIIl;
            }
            final int lllllllllllllIIIlllIIlIlIIIlllII = lllllllllllllIIIlllIIlIlIIlIIlll + lllllllllllllIIIlllIIlIlIIIlllIl;
            final BlockPos lllllllllllllIIIlllIIlIlIIIllIll = new BlockPos(lllllllllllllIIIlllIIlIlIIlIIIII, lllllllllllllIIIlllIIlIlIIIlllII, lllllllllllllIIIlllIIlIlIIIlllll);
            final Material lllllllllllllIIIlllIIlIlIIIllIlI = lllllllllllllIIIlllIIlIlIIIIlIll.getBlockState(lllllllllllllIIIlllIIlIlIIIllIll).getMaterial();
            if (lllllllllllllIIIlllIIlIlIIIllIlI == Material.AIR || lllllllllllllIIIlllIIlIlIIIllIlI == Material.LEAVES) {
                this.placeLogAt(lllllllllllllIIIlllIIlIlIIIIlIll, lllllllllllllIIIlllIIlIlIIIllIll);
                this.placeLogAt(lllllllllllllIIIlllIIlIlIIIIlIll, lllllllllllllIIIlllIIlIlIIIllIll.east());
                this.placeLogAt(lllllllllllllIIIlllIIlIlIIIIlIll, lllllllllllllIIIlllIIlIlIIIllIll.south());
                this.placeLogAt(lllllllllllllIIIlllIIlIlIIIIlIll, lllllllllllllIIIlllIIlIlIIIllIll.east().south());
            }
        }
        for (int lllllllllllllIIIlllIIlIlIIIllIIl = -2; lllllllllllllIIIlllIIlIlIIIllIIl <= 0; ++lllllllllllllIIIlllIIlIlIIIllIIl) {
            for (int lllllllllllllIIIlllIIlIlIIIllIII = -2; lllllllllllllIIIlllIIlIlIIIllIII <= 0; ++lllllllllllllIIIlllIIlIlIIIllIII) {
                int lllllllllllllIIIlllIIlIlIIIlIlll = -1;
                this.placeLeafAt(lllllllllllllIIIlllIIlIlIIIIlIll, lllllllllllllIIIlllIIlIlIIlIIIII + lllllllllllllIIIlllIIlIlIIIllIIl, lllllllllllllIIIlllIIlIlIIIllllI + lllllllllllllIIIlllIIlIlIIIlIlll, lllllllllllllIIIlllIIlIlIIIlllll + lllllllllllllIIIlllIIlIlIIIllIII);
                this.placeLeafAt(lllllllllllllIIIlllIIlIlIIIIlIll, 1 + lllllllllllllIIIlllIIlIlIIlIIIII - lllllllllllllIIIlllIIlIlIIIllIIl, lllllllllllllIIIlllIIlIlIIIllllI + lllllllllllllIIIlllIIlIlIIIlIlll, lllllllllllllIIIlllIIlIlIIIlllll + lllllllllllllIIIlllIIlIlIIIllIII);
                this.placeLeafAt(lllllllllllllIIIlllIIlIlIIIIlIll, lllllllllllllIIIlllIIlIlIIlIIIII + lllllllllllllIIIlllIIlIlIIIllIIl, lllllllllllllIIIlllIIlIlIIIllllI + lllllllllllllIIIlllIIlIlIIIlIlll, 1 + lllllllllllllIIIlllIIlIlIIIlllll - lllllllllllllIIIlllIIlIlIIIllIII);
                this.placeLeafAt(lllllllllllllIIIlllIIlIlIIIIlIll, 1 + lllllllllllllIIIlllIIlIlIIlIIIII - lllllllllllllIIIlllIIlIlIIIllIIl, lllllllllllllIIIlllIIlIlIIIllllI + lllllllllllllIIIlllIIlIlIIIlIlll, 1 + lllllllllllllIIIlllIIlIlIIIlllll - lllllllllllllIIIlllIIlIlIIIllIII);
                if ((lllllllllllllIIIlllIIlIlIIIllIIl > -2 || lllllllllllllIIIlllIIlIlIIIllIII > -1) && (lllllllllllllIIIlllIIlIlIIIllIIl != -1 || lllllllllllllIIIlllIIlIlIIIllIII != -2)) {
                    lllllllllllllIIIlllIIlIlIIIlIlll = 1;
                    this.placeLeafAt(lllllllllllllIIIlllIIlIlIIIIlIll, lllllllllllllIIIlllIIlIlIIlIIIII + lllllllllllllIIIlllIIlIlIIIllIIl, lllllllllllllIIIlllIIlIlIIIllllI + lllllllllllllIIIlllIIlIlIIIlIlll, lllllllllllllIIIlllIIlIlIIIlllll + lllllllllllllIIIlllIIlIlIIIllIII);
                    this.placeLeafAt(lllllllllllllIIIlllIIlIlIIIIlIll, 1 + lllllllllllllIIIlllIIlIlIIlIIIII - lllllllllllllIIIlllIIlIlIIIllIIl, lllllllllllllIIIlllIIlIlIIIllllI + lllllllllllllIIIlllIIlIlIIIlIlll, lllllllllllllIIIlllIIlIlIIIlllll + lllllllllllllIIIlllIIlIlIIIllIII);
                    this.placeLeafAt(lllllllllllllIIIlllIIlIlIIIIlIll, lllllllllllllIIIlllIIlIlIIlIIIII + lllllllllllllIIIlllIIlIlIIIllIIl, lllllllllllllIIIlllIIlIlIIIllllI + lllllllllllllIIIlllIIlIlIIIlIlll, 1 + lllllllllllllIIIlllIIlIlIIIlllll - lllllllllllllIIIlllIIlIlIIIllIII);
                    this.placeLeafAt(lllllllllllllIIIlllIIlIlIIIIlIll, 1 + lllllllllllllIIIlllIIlIlIIlIIIII - lllllllllllllIIIlllIIlIlIIIllIIl, lllllllllllllIIIlllIIlIlIIIllllI + lllllllllllllIIIlllIIlIlIIIlIlll, 1 + lllllllllllllIIIlllIIlIlIIIlllll - lllllllllllllIIIlllIIlIlIIIllIII);
                }
            }
        }
        if (lllllllllllllIIIlllIIlIlIIlIlIll.nextBoolean()) {
            this.placeLeafAt(lllllllllllllIIIlllIIlIlIIIIlIll, lllllllllllllIIIlllIIlIlIIlIIIII, lllllllllllllIIIlllIIlIlIIIllllI + 2, lllllllllllllIIIlllIIlIlIIIlllll);
            this.placeLeafAt(lllllllllllllIIIlllIIlIlIIIIlIll, lllllllllllllIIIlllIIlIlIIlIIIII + 1, lllllllllllllIIIlllIIlIlIIIllllI + 2, lllllllllllllIIIlllIIlIlIIIlllll);
            this.placeLeafAt(lllllllllllllIIIlllIIlIlIIIIlIll, lllllllllllllIIIlllIIlIlIIlIIIII + 1, lllllllllllllIIIlllIIlIlIIIllllI + 2, lllllllllllllIIIlllIIlIlIIIlllll + 1);
            this.placeLeafAt(lllllllllllllIIIlllIIlIlIIIIlIll, lllllllllllllIIIlllIIlIlIIlIIIII, lllllllllllllIIIlllIIlIlIIIllllI + 2, lllllllllllllIIIlllIIlIlIIIlllll + 1);
        }
        for (int lllllllllllllIIIlllIIlIlIIIlIllI = -3; lllllllllllllIIIlllIIlIlIIIlIllI <= 4; ++lllllllllllllIIIlllIIlIlIIIlIllI) {
            for (int lllllllllllllIIIlllIIlIlIIIlIlIl = -3; lllllllllllllIIIlllIIlIlIIIlIlIl <= 4; ++lllllllllllllIIIlllIIlIlIIIlIlIl) {
                if ((lllllllllllllIIIlllIIlIlIIIlIllI != -3 || lllllllllllllIIIlllIIlIlIIIlIlIl != -3) && (lllllllllllllIIIlllIIlIlIIIlIllI != -3 || lllllllllllllIIIlllIIlIlIIIlIlIl != 4) && (lllllllllllllIIIlllIIlIlIIIlIllI != 4 || lllllllllllllIIIlllIIlIlIIIlIlIl != -3) && (lllllllllllllIIIlllIIlIlIIIlIllI != 4 || lllllllllllllIIIlllIIlIlIIIlIlIl != 4) && (Math.abs(lllllllllllllIIIlllIIlIlIIIlIllI) < 3 || Math.abs(lllllllllllllIIIlllIIlIlIIIlIlIl) < 3)) {
                    this.placeLeafAt(lllllllllllllIIIlllIIlIlIIIIlIll, lllllllllllllIIIlllIIlIlIIlIIIII + lllllllllllllIIIlllIIlIlIIIlIllI, lllllllllllllIIIlllIIlIlIIIllllI, lllllllllllllIIIlllIIlIlIIIlllll + lllllllllllllIIIlllIIlIlIIIlIlIl);
                }
            }
        }
        for (int lllllllllllllIIIlllIIlIlIIIlIlII = -1; lllllllllllllIIIlllIIlIlIIIlIlII <= 2; ++lllllllllllllIIIlllIIlIlIIIlIlII) {
            for (int lllllllllllllIIIlllIIlIlIIIlIIll = -1; lllllllllllllIIIlllIIlIlIIIlIIll <= 2; ++lllllllllllllIIIlllIIlIlIIIlIIll) {
                if ((lllllllllllllIIIlllIIlIlIIIlIlII < 0 || lllllllllllllIIIlllIIlIlIIIlIlII > 1 || lllllllllllllIIIlllIIlIlIIIlIIll < 0 || lllllllllllllIIIlllIIlIlIIIlIIll > 1) && lllllllllllllIIIlllIIlIlIIlIlIll.nextInt(3) <= 0) {
                    for (int lllllllllllllIIIlllIIlIlIIIlIIlI = lllllllllllllIIIlllIIlIlIIlIlIll.nextInt(3) + 2, lllllllllllllIIIlllIIlIlIIIlIIIl = 0; lllllllllllllIIIlllIIlIlIIIlIIIl < lllllllllllllIIIlllIIlIlIIIlIIlI; ++lllllllllllllIIIlllIIlIlIIIlIIIl) {
                        this.placeLogAt(lllllllllllllIIIlllIIlIlIIIIlIll, new BlockPos(lllllllllllllIIIlllIIlIlIIlIlIII + lllllllllllllIIIlllIIlIlIIIlIlII, lllllllllllllIIIlllIIlIlIIIllllI - lllllllllllllIIIlllIIlIlIIIlIIIl - 1, lllllllllllllIIIlllIIlIlIIlIIllI + lllllllllllllIIIlllIIlIlIIIlIIll));
                    }
                    for (int lllllllllllllIIIlllIIlIlIIIlIIII = -1; lllllllllllllIIIlllIIlIlIIIlIIII <= 1; ++lllllllllllllIIIlllIIlIlIIIlIIII) {
                        for (int lllllllllllllIIIlllIIlIlIIIIllll = -1; lllllllllllllIIIlllIIlIlIIIIllll <= 1; ++lllllllllllllIIIlllIIlIlIIIIllll) {
                            this.placeLeafAt(lllllllllllllIIIlllIIlIlIIIIlIll, lllllllllllllIIIlllIIlIlIIlIIIII + lllllllllllllIIIlllIIlIlIIIlIlII + lllllllllllllIIIlllIIlIlIIIlIIII, lllllllllllllIIIlllIIlIlIIIllllI, lllllllllllllIIIlllIIlIlIIIlllll + lllllllllllllIIIlllIIlIlIIIlIIll + lllllllllllllIIIlllIIlIlIIIIllll);
                        }
                    }
                    for (int lllllllllllllIIIlllIIlIlIIIIlllI = -2; lllllllllllllIIIlllIIlIlIIIIlllI <= 2; ++lllllllllllllIIIlllIIlIlIIIIlllI) {
                        for (int lllllllllllllIIIlllIIlIlIIIIllIl = -2; lllllllllllllIIIlllIIlIlIIIIllIl <= 2; ++lllllllllllllIIIlllIIlIlIIIIllIl) {
                            if (Math.abs(lllllllllllllIIIlllIIlIlIIIIlllI) != 2 || Math.abs(lllllllllllllIIIlllIIlIlIIIIllIl) != 2) {
                                this.placeLeafAt(lllllllllllllIIIlllIIlIlIIIIlIll, lllllllllllllIIIlllIIlIlIIlIIIII + lllllllllllllIIIlllIIlIlIIIlIlII + lllllllllllllIIIlllIIlIlIIIIlllI, lllllllllllllIIIlllIIlIlIIIllllI - 1, lllllllllllllIIIlllIIlIlIIIlllll + lllllllllllllIIIlllIIlIlIIIlIIll + lllllllllllllIIIlllIIlIlIIIIllIl);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
    
    public WorldGenCanopyTree(final boolean lllllllllllllIIIlllIIlIlIlIIIIll) {
        super(lllllllllllllIIIlllIIlIlIlIIIIll);
    }
    
    static {
        DARK_OAK_LOG = Blocks.LOG2.getDefaultState().withProperty(BlockNewLog.VARIANT, BlockPlanks.EnumType.DARK_OAK);
        DARK_OAK_LEAVES = Blocks.LEAVES2.getDefaultState().withProperty(BlockNewLeaf.VARIANT, BlockPlanks.EnumType.DARK_OAK).withProperty((IProperty<Comparable>)BlockLeaves.CHECK_DECAY, false);
    }
}
