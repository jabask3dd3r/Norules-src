package net.minecraft.world.gen.feature;

import net.minecraft.world.*;
import java.util.*;
import net.minecraft.init.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;
import net.minecraft.util.math.*;
import net.minecraft.block.*;

public class WorldGenMegaJungle extends WorldGenHugeTrees
{
    private void placeVine(final World llllllllllllllIlIIlIIllIIIllIllI, final Random llllllllllllllIlIIlIIllIIIllIIII, final BlockPos llllllllllllllIlIIlIIllIIIlIllll, final PropertyBool llllllllllllllIlIIlIIllIIIlIlllI) {
        if (llllllllllllllIlIIlIIllIIIllIIII.nextInt(3) > 0 && llllllllllllllIlIIlIIllIIIllIllI.isAirBlock(llllllllllllllIlIIlIIllIIIlIllll)) {
            this.setBlockAndNotifyAdequately(llllllllllllllIlIIlIIllIIIllIllI, llllllllllllllIlIIlIIllIIIlIllll, Blocks.VINE.getDefaultState().withProperty((IProperty<Comparable>)llllllllllllllIlIIlIIllIIIlIlllI, true));
        }
    }
    
    public WorldGenMegaJungle(final boolean llllllllllllllIlIIlIIllIIlllIlII, final int llllllllllllllIlIIlIIllIIllIllIl, final int llllllllllllllIlIIlIIllIIlllIIlI, final IBlockState llllllllllllllIlIIlIIllIIllIlIll, final IBlockState llllllllllllllIlIIlIIllIIllIlIlI) {
        super(llllllllllllllIlIIlIIllIIlllIlII, llllllllllllllIlIIlIIllIIllIllIl, llllllllllllllIlIIlIIllIIlllIIlI, llllllllllllllIlIIlIIllIIllIlIll, llllllllllllllIlIIlIIllIIllIlIlI);
    }
    
    @Override
    public boolean generate(final World llllllllllllllIlIIlIIllIIlIIlIII, final Random llllllllllllllIlIIlIIllIIlIllIlI, final BlockPos llllllllllllllIlIIlIIllIIlIllIIl) {
        final int llllllllllllllIlIIlIIllIIlIllIII = this.getHeight(llllllllllllllIlIIlIIllIIlIllIlI);
        if (!this.ensureGrowable(llllllllllllllIlIIlIIllIIlIIlIII, llllllllllllllIlIIlIIllIIlIllIlI, llllllllllllllIlIIlIIllIIlIllIIl, llllllllllllllIlIIlIIllIIlIllIII)) {
            return false;
        }
        this.createCrown(llllllllllllllIlIIlIIllIIlIIlIII, llllllllllllllIlIIlIIllIIlIllIIl.up(llllllllllllllIlIIlIIllIIlIllIII), 2);
        for (int llllllllllllllIlIIlIIllIIlIlIlll = llllllllllllllIlIIlIIllIIlIllIIl.getY() + llllllllllllllIlIIlIIllIIlIllIII - 2 - llllllllllllllIlIIlIIllIIlIllIlI.nextInt(4); llllllllllllllIlIIlIIllIIlIlIlll > llllllllllllllIlIIlIIllIIlIllIIl.getY() + llllllllllllllIlIIlIIllIIlIllIII / 2; llllllllllllllIlIIlIIllIIlIlIlll -= 2 + llllllllllllllIlIIlIIllIIlIllIlI.nextInt(4)) {
            final float llllllllllllllIlIIlIIllIIlIlIllI = llllllllllllllIlIIlIIllIIlIllIlI.nextFloat() * 6.2831855f;
            int llllllllllllllIlIIlIIllIIlIlIlIl = llllllllllllllIlIIlIIllIIlIllIIl.getX() + (int)(0.5f + MathHelper.cos(llllllllllllllIlIIlIIllIIlIlIllI) * 4.0f);
            int llllllllllllllIlIIlIIllIIlIlIlII = llllllllllllllIlIIlIIllIIlIllIIl.getZ() + (int)(0.5f + MathHelper.sin(llllllllllllllIlIIlIIllIIlIlIllI) * 4.0f);
            for (int llllllllllllllIlIIlIIllIIlIlIIll = 0; llllllllllllllIlIIlIIllIIlIlIIll < 5; ++llllllllllllllIlIIlIIllIIlIlIIll) {
                llllllllllllllIlIIlIIllIIlIlIlIl = llllllllllllllIlIIlIIllIIlIllIIl.getX() + (int)(1.5f + MathHelper.cos(llllllllllllllIlIIlIIllIIlIlIllI) * llllllllllllllIlIIlIIllIIlIlIIll);
                llllllllllllllIlIIlIIllIIlIlIlII = llllllllllllllIlIIlIIllIIlIllIIl.getZ() + (int)(1.5f + MathHelper.sin(llllllllllllllIlIIlIIllIIlIlIllI) * llllllllllllllIlIIlIIllIIlIlIIll);
                this.setBlockAndNotifyAdequately(llllllllllllllIlIIlIIllIIlIIlIII, new BlockPos(llllllllllllllIlIIlIIllIIlIlIlIl, llllllllllllllIlIIlIIllIIlIlIlll - 3 + llllllllllllllIlIIlIIllIIlIlIIll / 2, llllllllllllllIlIIlIIllIIlIlIlII), this.woodMetadata);
            }
            final int llllllllllllllIlIIlIIllIIlIlIIlI = 1 + llllllllllllllIlIIlIIllIIlIllIlI.nextInt(2);
            for (int llllllllllllllIlIIlIIllIIlIlIIIl = llllllllllllllIlIIlIIllIIlIlIlll, llllllllllllllIlIIlIIllIIlIlIIII = llllllllllllllIlIIlIIllIIlIlIlll - llllllllllllllIlIIlIIllIIlIlIIlI; llllllllllllllIlIIlIIllIIlIlIIII <= llllllllllllllIlIIlIIllIIlIlIIIl; ++llllllllllllllIlIIlIIllIIlIlIIII) {
                final int llllllllllllllIlIIlIIllIIlIIllll = llllllllllllllIlIIlIIllIIlIlIIII - llllllllllllllIlIIlIIllIIlIlIIIl;
                this.growLeavesLayer(llllllllllllllIlIIlIIllIIlIIlIII, new BlockPos(llllllllllllllIlIIlIIllIIlIlIlIl, llllllllllllllIlIIlIIllIIlIlIIII, llllllllllllllIlIIlIIllIIlIlIlII), 1 - llllllllllllllIlIIlIIllIIlIIllll);
            }
        }
        for (int llllllllllllllIlIIlIIllIIlIIlllI = 0; llllllllllllllIlIIlIIllIIlIIlllI < llllllllllllllIlIIlIIllIIlIllIII; ++llllllllllllllIlIIlIIllIIlIIlllI) {
            final BlockPos llllllllllllllIlIIlIIllIIlIIllIl = llllllllllllllIlIIlIIllIIlIllIIl.up(llllllllllllllIlIIlIIllIIlIIlllI);
            if (this.canGrowInto(llllllllllllllIlIIlIIllIIlIIlIII.getBlockState(llllllllllllllIlIIlIIllIIlIIllIl).getBlock())) {
                this.setBlockAndNotifyAdequately(llllllllllllllIlIIlIIllIIlIIlIII, llllllllllllllIlIIlIIllIIlIIllIl, this.woodMetadata);
                if (llllllllllllllIlIIlIIllIIlIIlllI > 0) {
                    this.placeVine(llllllllllllllIlIIlIIllIIlIIlIII, llllllllllllllIlIIlIIllIIlIllIlI, llllllllllllllIlIIlIIllIIlIIllIl.west(), BlockVine.EAST);
                    this.placeVine(llllllllllllllIlIIlIIllIIlIIlIII, llllllllllllllIlIIlIIllIIlIllIlI, llllllllllllllIlIIlIIllIIlIIllIl.north(), BlockVine.SOUTH);
                }
            }
            if (llllllllllllllIlIIlIIllIIlIIlllI < llllllllllllllIlIIlIIllIIlIllIII - 1) {
                final BlockPos llllllllllllllIlIIlIIllIIlIIllII = llllllllllllllIlIIlIIllIIlIIllIl.east();
                if (this.canGrowInto(llllllllllllllIlIIlIIllIIlIIlIII.getBlockState(llllllllllllllIlIIlIIllIIlIIllII).getBlock())) {
                    this.setBlockAndNotifyAdequately(llllllllllllllIlIIlIIllIIlIIlIII, llllllllllllllIlIIlIIllIIlIIllII, this.woodMetadata);
                    if (llllllllllllllIlIIlIIllIIlIIlllI > 0) {
                        this.placeVine(llllllllllllllIlIIlIIllIIlIIlIII, llllllllllllllIlIIlIIllIIlIllIlI, llllllllllllllIlIIlIIllIIlIIllII.east(), BlockVine.WEST);
                        this.placeVine(llllllllllllllIlIIlIIllIIlIIlIII, llllllllllllllIlIIlIIllIIlIllIlI, llllllllllllllIlIIlIIllIIlIIllII.north(), BlockVine.SOUTH);
                    }
                }
                final BlockPos llllllllllllllIlIIlIIllIIlIIlIll = llllllllllllllIlIIlIIllIIlIIllIl.south().east();
                if (this.canGrowInto(llllllllllllllIlIIlIIllIIlIIlIII.getBlockState(llllllllllllllIlIIlIIllIIlIIlIll).getBlock())) {
                    this.setBlockAndNotifyAdequately(llllllllllllllIlIIlIIllIIlIIlIII, llllllllllllllIlIIlIIllIIlIIlIll, this.woodMetadata);
                    if (llllllllllllllIlIIlIIllIIlIIlllI > 0) {
                        this.placeVine(llllllllllllllIlIIlIIllIIlIIlIII, llllllllllllllIlIIlIIllIIlIllIlI, llllllllllllllIlIIlIIllIIlIIlIll.east(), BlockVine.WEST);
                        this.placeVine(llllllllllllllIlIIlIIllIIlIIlIII, llllllllllllllIlIIlIIllIIlIllIlI, llllllllllllllIlIIlIIllIIlIIlIll.south(), BlockVine.NORTH);
                    }
                }
                final BlockPos llllllllllllllIlIIlIIllIIlIIlIlI = llllllllllllllIlIIlIIllIIlIIllIl.south();
                if (this.canGrowInto(llllllllllllllIlIIlIIllIIlIIlIII.getBlockState(llllllllllllllIlIIlIIllIIlIIlIlI).getBlock())) {
                    this.setBlockAndNotifyAdequately(llllllllllllllIlIIlIIllIIlIIlIII, llllllllllllllIlIIlIIllIIlIIlIlI, this.woodMetadata);
                    if (llllllllllllllIlIIlIIllIIlIIlllI > 0) {
                        this.placeVine(llllllllllllllIlIIlIIllIIlIIlIII, llllllllllllllIlIIlIIllIIlIllIlI, llllllllllllllIlIIlIIllIIlIIlIlI.west(), BlockVine.EAST);
                        this.placeVine(llllllllllllllIlIIlIIllIIlIIlIII, llllllllllllllIlIIlIIllIIlIllIlI, llllllllllllllIlIIlIIllIIlIIlIlI.south(), BlockVine.NORTH);
                    }
                }
            }
        }
        return true;
    }
    
    private void createCrown(final World llllllllllllllIlIIlIIllIIIlIIllI, final BlockPos llllllllllllllIlIIlIIllIIIIlllll, final int llllllllllllllIlIIlIIllIIIlIIlII) {
        final int llllllllllllllIlIIlIIllIIIlIIIll = 2;
        for (int llllllllllllllIlIIlIIllIIIlIIIlI = -2; llllllllllllllIlIIlIIllIIIlIIIlI <= 0; ++llllllllllllllIlIIlIIllIIIlIIIlI) {
            this.growLeavesLayerStrict(llllllllllllllIlIIlIIllIIIlIIllI, llllllllllllllIlIIlIIllIIIIlllll.up(llllllllllllllIlIIlIIllIIIlIIIlI), llllllllllllllIlIIlIIllIIIlIIlII + 1 - llllllllllllllIlIIlIIllIIIlIIIlI);
        }
    }
}
