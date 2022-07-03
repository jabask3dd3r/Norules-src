package net.minecraft.world.gen.feature;

import net.minecraft.block.state.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.block.material.*;
import java.util.*;
import net.minecraft.init.*;
import net.minecraft.block.*;

public abstract class WorldGenHugeTrees extends WorldGenAbstractTree
{
    protected /* synthetic */ int extraRandomHeight;
    protected final /* synthetic */ IBlockState woodMetadata;
    protected final /* synthetic */ int baseHeight;
    protected final /* synthetic */ IBlockState leavesMetadata;
    
    protected void growLeavesLayerStrict(final World lllllllllllllIIIllIIllIIlIIlIIIl, final BlockPos lllllllllllllIIIllIIllIIlIIllIll, final int lllllllllllllIIIllIIllIIlIIIllll) {
        final int lllllllllllllIIIllIIllIIlIIllIIl = lllllllllllllIIIllIIllIIlIIIllll * lllllllllllllIIIllIIllIIlIIIllll;
        for (int lllllllllllllIIIllIIllIIlIIllIII = -lllllllllllllIIIllIIllIIlIIIllll; lllllllllllllIIIllIIllIIlIIllIII <= lllllllllllllIIIllIIllIIlIIIllll + 1; ++lllllllllllllIIIllIIllIIlIIllIII) {
            for (int lllllllllllllIIIllIIllIIlIIlIlll = -lllllllllllllIIIllIIllIIlIIIllll; lllllllllllllIIIllIIllIIlIIlIlll <= lllllllllllllIIIllIIllIIlIIIllll + 1; ++lllllllllllllIIIllIIllIIlIIlIlll) {
                final int lllllllllllllIIIllIIllIIlIIlIllI = lllllllllllllIIIllIIllIIlIIllIII - 1;
                final int lllllllllllllIIIllIIllIIlIIlIlIl = lllllllllllllIIIllIIllIIlIIlIlll - 1;
                if (lllllllllllllIIIllIIllIIlIIllIII * lllllllllllllIIIllIIllIIlIIllIII + lllllllllllllIIIllIIllIIlIIlIlll * lllllllllllllIIIllIIllIIlIIlIlll <= lllllllllllllIIIllIIllIIlIIllIIl || lllllllllllllIIIllIIllIIlIIlIllI * lllllllllllllIIIllIIllIIlIIlIllI + lllllllllllllIIIllIIllIIlIIlIlIl * lllllllllllllIIIllIIllIIlIIlIlIl <= lllllllllllllIIIllIIllIIlIIllIIl || lllllllllllllIIIllIIllIIlIIllIII * lllllllllllllIIIllIIllIIlIIllIII + lllllllllllllIIIllIIllIIlIIlIlIl * lllllllllllllIIIllIIllIIlIIlIlIl <= lllllllllllllIIIllIIllIIlIIllIIl || lllllllllllllIIIllIIllIIlIIlIllI * lllllllllllllIIIllIIllIIlIIlIllI + lllllllllllllIIIllIIllIIlIIlIlll * lllllllllllllIIIllIIllIIlIIlIlll <= lllllllllllllIIIllIIllIIlIIllIIl) {
                    final BlockPos lllllllllllllIIIllIIllIIlIIlIlII = lllllllllllllIIIllIIllIIlIIllIll.add(lllllllllllllIIIllIIllIIlIIllIII, 0, lllllllllllllIIIllIIllIIlIIlIlll);
                    final Material lllllllllllllIIIllIIllIIlIIlIIll = lllllllllllllIIIllIIllIIlIIlIIIl.getBlockState(lllllllllllllIIIllIIllIIlIIlIlII).getMaterial();
                    if (lllllllllllllIIIllIIllIIlIIlIIll == Material.AIR || lllllllllllllIIIllIIllIIlIIlIIll == Material.LEAVES) {
                        this.setBlockAndNotifyAdequately(lllllllllllllIIIllIIllIIlIIlIIIl, lllllllllllllIIIllIIllIIlIIlIlII, this.leavesMetadata);
                    }
                }
            }
        }
    }
    
    protected boolean ensureGrowable(final World lllllllllllllIIIllIIllIIlIllIIII, final Random lllllllllllllIIIllIIllIIlIlIllll, final BlockPos lllllllllllllIIIllIIllIIlIlIlIlI, final int lllllllllllllIIIllIIllIIlIlIlIIl) {
        return this.isSpaceAt(lllllllllllllIIIllIIllIIlIllIIII, lllllllllllllIIIllIIllIIlIlIlIlI, lllllllllllllIIIllIIllIIlIlIlIIl) && this.ensureDirtsUnderneath(lllllllllllllIIIllIIllIIlIlIlIlI, lllllllllllllIIIllIIllIIlIllIIII);
    }
    
    protected int getHeight(final Random lllllllllllllIIIllIIllIIlllIIlII) {
        int lllllllllllllIIIllIIllIIlllIIIll = lllllllllllllIIIllIIllIIlllIIlII.nextInt(3) + this.baseHeight;
        if (this.extraRandomHeight > 1) {
            lllllllllllllIIIllIIllIIlllIIIll += lllllllllllllIIIllIIllIIlllIIlII.nextInt(this.extraRandomHeight);
        }
        return lllllllllllllIIIllIIllIIlllIIIll;
    }
    
    private boolean isSpaceAt(final World lllllllllllllIIIllIIllIIllIlIlIl, final BlockPos lllllllllllllIIIllIIllIIllIIlIll, final int lllllllllllllIIIllIIllIIllIIlIlI) {
        boolean lllllllllllllIIIllIIllIIllIlIIlI = true;
        if (lllllllllllllIIIllIIllIIllIIlIll.getY() >= 1 && lllllllllllllIIIllIIllIIllIIlIll.getY() + lllllllllllllIIIllIIllIIllIIlIlI + 1 <= 256) {
            for (int lllllllllllllIIIllIIllIIllIlIIIl = 0; lllllllllllllIIIllIIllIIllIlIIIl <= 1 + lllllllllllllIIIllIIllIIllIIlIlI; ++lllllllllllllIIIllIIllIIllIlIIIl) {
                int lllllllllllllIIIllIIllIIllIlIIII = 2;
                if (lllllllllllllIIIllIIllIIllIlIIIl == 0) {
                    lllllllllllllIIIllIIllIIllIlIIII = 1;
                }
                else if (lllllllllllllIIIllIIllIIllIlIIIl >= 1 + lllllllllllllIIIllIIllIIllIIlIlI - 2) {
                    lllllllllllllIIIllIIllIIllIlIIII = 2;
                }
                for (int lllllllllllllIIIllIIllIIllIIllll = -lllllllllllllIIIllIIllIIllIlIIII; lllllllllllllIIIllIIllIIllIIllll <= lllllllllllllIIIllIIllIIllIlIIII && lllllllllllllIIIllIIllIIllIlIIlI; ++lllllllllllllIIIllIIllIIllIIllll) {
                    for (int lllllllllllllIIIllIIllIIllIIlllI = -lllllllllllllIIIllIIllIIllIlIIII; lllllllllllllIIIllIIllIIllIIlllI <= lllllllllllllIIIllIIllIIllIlIIII && lllllllllllllIIIllIIllIIllIlIIlI; ++lllllllllllllIIIllIIllIIllIIlllI) {
                        if (lllllllllllllIIIllIIllIIllIIlIll.getY() + lllllllllllllIIIllIIllIIllIlIIIl < 0 || lllllllllllllIIIllIIllIIllIIlIll.getY() + lllllllllllllIIIllIIllIIllIlIIIl >= 256 || !this.canGrowInto(lllllllllllllIIIllIIllIIllIlIlIl.getBlockState(lllllllllllllIIIllIIllIIllIIlIll.add(lllllllllllllIIIllIIllIIllIIllll, lllllllllllllIIIllIIllIIllIlIIIl, lllllllllllllIIIllIIllIIllIIlllI)).getBlock())) {
                            lllllllllllllIIIllIIllIIllIlIIlI = false;
                        }
                    }
                }
            }
            return lllllllllllllIIIllIIllIIllIlIIlI;
        }
        return false;
    }
    
    private boolean ensureDirtsUnderneath(final BlockPos lllllllllllllIIIllIIllIIlIlllIIl, final World lllllllllllllIIIllIIllIIlIlllIII) {
        final BlockPos lllllllllllllIIIllIIllIIlIllllII = lllllllllllllIIIllIIllIIlIlllIIl.down();
        final Block lllllllllllllIIIllIIllIIlIlllIll = lllllllllllllIIIllIIllIIlIlllIII.getBlockState(lllllllllllllIIIllIIllIIlIllllII).getBlock();
        if ((lllllllllllllIIIllIIllIIlIlllIll == Blocks.GRASS || lllllllllllllIIIllIIllIIlIlllIll == Blocks.DIRT) && lllllllllllllIIIllIIllIIlIlllIIl.getY() >= 2) {
            this.setDirtAt(lllllllllllllIIIllIIllIIlIlllIII, lllllllllllllIIIllIIllIIlIllllII);
            this.setDirtAt(lllllllllllllIIIllIIllIIlIlllIII, lllllllllllllIIIllIIllIIlIllllII.east());
            this.setDirtAt(lllllllllllllIIIllIIllIIlIlllIII, lllllllllllllIIIllIIllIIlIllllII.south());
            this.setDirtAt(lllllllllllllIIIllIIllIIlIlllIII, lllllllllllllIIIllIIllIIlIllllII.south().east());
            return true;
        }
        return false;
    }
    
    public WorldGenHugeTrees(final boolean lllllllllllllIIIllIIllIIllllIIll, final int lllllllllllllIIIllIIllIIlllIllII, final int lllllllllllllIIIllIIllIIllllIIIl, final IBlockState lllllllllllllIIIllIIllIIllllIIII, final IBlockState lllllllllllllIIIllIIllIIlllIllll) {
        super(lllllllllllllIIIllIIllIIllllIIll);
        this.baseHeight = lllllllllllllIIIllIIllIIlllIllII;
        this.extraRandomHeight = lllllllllllllIIIllIIllIIllllIIIl;
        this.woodMetadata = lllllllllllllIIIllIIllIIllllIIII;
        this.leavesMetadata = lllllllllllllIIIllIIllIIlllIllll;
    }
    
    protected void growLeavesLayer(final World lllllllllllllIIIllIIllIIIlllllIl, final BlockPos lllllllllllllIIIllIIllIIIlllIIll, final int lllllllllllllIIIllIIllIIIllllIll) {
        final int lllllllllllllIIIllIIllIIIllllIlI = lllllllllllllIIIllIIllIIIllllIll * lllllllllllllIIIllIIllIIIllllIll;
        for (int lllllllllllllIIIllIIllIIIllllIIl = -lllllllllllllIIIllIIllIIIllllIll; lllllllllllllIIIllIIllIIIllllIIl <= lllllllllllllIIIllIIllIIIllllIll; ++lllllllllllllIIIllIIllIIIllllIIl) {
            for (int lllllllllllllIIIllIIllIIIllllIII = -lllllllllllllIIIllIIllIIIllllIll; lllllllllllllIIIllIIllIIIllllIII <= lllllllllllllIIIllIIllIIIllllIll; ++lllllllllllllIIIllIIllIIIllllIII) {
                if (lllllllllllllIIIllIIllIIIllllIIl * lllllllllllllIIIllIIllIIIllllIIl + lllllllllllllIIIllIIllIIIllllIII * lllllllllllllIIIllIIllIIIllllIII <= lllllllllllllIIIllIIllIIIllllIlI) {
                    final BlockPos lllllllllllllIIIllIIllIIIlllIlll = lllllllllllllIIIllIIllIIIlllIIll.add(lllllllllllllIIIllIIllIIIllllIIl, 0, lllllllllllllIIIllIIllIIIllllIII);
                    final Material lllllllllllllIIIllIIllIIIlllIllI = lllllllllllllIIIllIIllIIIlllllIl.getBlockState(lllllllllllllIIIllIIllIIIlllIlll).getMaterial();
                    if (lllllllllllllIIIllIIllIIIlllIllI == Material.AIR || lllllllllllllIIIllIIllIIIlllIllI == Material.LEAVES) {
                        this.setBlockAndNotifyAdequately(lllllllllllllIIIllIIllIIIlllllIl, lllllllllllllIIIllIIllIIIlllIlll, this.leavesMetadata);
                    }
                }
            }
        }
    }
}
