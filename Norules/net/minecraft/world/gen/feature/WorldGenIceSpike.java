package net.minecraft.world.gen.feature;

import net.minecraft.world.*;
import java.util.*;
import net.minecraft.init.*;
import net.minecraft.block.material.*;
import net.minecraft.block.state.*;
import net.minecraft.block.*;
import net.minecraft.util.math.*;

public class WorldGenIceSpike extends WorldGenerator
{
    @Override
    public boolean generate(final World llllllllllllllllllllllIIIlIIIlIl, final Random llllllllllllllllllllllIIIlIllIlI, BlockPos llllllllllllllllllllllIIIlIIIIll) {
        while (llllllllllllllllllllllIIIlIIIlIl.isAirBlock((BlockPos)llllllllllllllllllllllIIIlIIIIll) && ((Vec3i)llllllllllllllllllllllIIIlIIIIll).getY() > 2) {
            llllllllllllllllllllllIIIlIIIIll = ((BlockPos)llllllllllllllllllllllIIIlIIIIll).down();
        }
        if (llllllllllllllllllllllIIIlIIIlIl.getBlockState((BlockPos)llllllllllllllllllllllIIIlIIIIll).getBlock() != Blocks.SNOW) {
            return false;
        }
        llllllllllllllllllllllIIIlIIIIll = ((BlockPos)llllllllllllllllllllllIIIlIIIIll).up(llllllllllllllllllllllIIIlIllIlI.nextInt(4));
        final int llllllllllllllllllllllIIIlIllIII = llllllllllllllllllllllIIIlIllIlI.nextInt(4) + 7;
        final int llllllllllllllllllllllIIIlIlIlll = llllllllllllllllllllllIIIlIllIII / 4 + llllllllllllllllllllllIIIlIllIlI.nextInt(2);
        if (llllllllllllllllllllllIIIlIlIlll > 1 && llllllllllllllllllllllIIIlIllIlI.nextInt(60) == 0) {
            llllllllllllllllllllllIIIlIIIIll = ((BlockPos)llllllllllllllllllllllIIIlIIIIll).up(10 + llllllllllllllllllllllIIIlIllIlI.nextInt(30));
        }
        for (int llllllllllllllllllllllIIIlIlIllI = 0; llllllllllllllllllllllIIIlIlIllI < llllllllllllllllllllllIIIlIllIII; ++llllllllllllllllllllllIIIlIlIllI) {
            final float llllllllllllllllllllllIIIlIlIlIl = (1.0f - llllllllllllllllllllllIIIlIlIllI / (float)llllllllllllllllllllllIIIlIllIII) * llllllllllllllllllllllIIIlIlIlll;
            for (int llllllllllllllllllllllIIIlIlIlII = MathHelper.ceil(llllllllllllllllllllllIIIlIlIlIl), llllllllllllllllllllllIIIlIlIIll = -llllllllllllllllllllllIIIlIlIlII; llllllllllllllllllllllIIIlIlIIll <= llllllllllllllllllllllIIIlIlIlII; ++llllllllllllllllllllllIIIlIlIIll) {
                final float llllllllllllllllllllllIIIlIlIIlI = MathHelper.abs(llllllllllllllllllllllIIIlIlIIll) - 0.25f;
                for (int llllllllllllllllllllllIIIlIlIIIl = -llllllllllllllllllllllIIIlIlIlII; llllllllllllllllllllllIIIlIlIIIl <= llllllllllllllllllllllIIIlIlIlII; ++llllllllllllllllllllllIIIlIlIIIl) {
                    final float llllllllllllllllllllllIIIlIlIIII = MathHelper.abs(llllllllllllllllllllllIIIlIlIIIl) - 0.25f;
                    if (((llllllllllllllllllllllIIIlIlIIll == 0 && llllllllllllllllllllllIIIlIlIIIl == 0) || llllllllllllllllllllllIIIlIlIIlI * llllllllllllllllllllllIIIlIlIIlI + llllllllllllllllllllllIIIlIlIIII * llllllllllllllllllllllIIIlIlIIII <= llllllllllllllllllllllIIIlIlIlIl * llllllllllllllllllllllIIIlIlIlIl) && ((llllllllllllllllllllllIIIlIlIIll != -llllllllllllllllllllllIIIlIlIlII && llllllllllllllllllllllIIIlIlIIll != llllllllllllllllllllllIIIlIlIlII && llllllllllllllllllllllIIIlIlIIIl != -llllllllllllllllllllllIIIlIlIlII && llllllllllllllllllllllIIIlIlIIIl != llllllllllllllllllllllIIIlIlIlII) || llllllllllllllllllllllIIIlIllIlI.nextFloat() <= 0.75f)) {
                        IBlockState llllllllllllllllllllllIIIlIIllll = llllllllllllllllllllllIIIlIIIlIl.getBlockState(((BlockPos)llllllllllllllllllllllIIIlIIIIll).add(llllllllllllllllllllllIIIlIlIIll, llllllllllllllllllllllIIIlIlIllI, llllllllllllllllllllllIIIlIlIIIl));
                        Block llllllllllllllllllllllIIIlIIlllI = llllllllllllllllllllllIIIlIIllll.getBlock();
                        if (llllllllllllllllllllllIIIlIIllll.getMaterial() == Material.AIR || llllllllllllllllllllllIIIlIIlllI == Blocks.DIRT || llllllllllllllllllllllIIIlIIlllI == Blocks.SNOW || llllllllllllllllllllllIIIlIIlllI == Blocks.ICE) {
                            this.setBlockAndNotifyAdequately(llllllllllllllllllllllIIIlIIIlIl, ((BlockPos)llllllllllllllllllllllIIIlIIIIll).add(llllllllllllllllllllllIIIlIlIIll, llllllllllllllllllllllIIIlIlIllI, llllllllllllllllllllllIIIlIlIIIl), Blocks.PACKED_ICE.getDefaultState());
                        }
                        if (llllllllllllllllllllllIIIlIlIllI != 0 && llllllllllllllllllllllIIIlIlIlII > 1) {
                            llllllllllllllllllllllIIIlIIllll = llllllllllllllllllllllIIIlIIIlIl.getBlockState(((BlockPos)llllllllllllllllllllllIIIlIIIIll).add(llllllllllllllllllllllIIIlIlIIll, -llllllllllllllllllllllIIIlIlIllI, llllllllllllllllllllllIIIlIlIIIl));
                            llllllllllllllllllllllIIIlIIlllI = llllllllllllllllllllllIIIlIIllll.getBlock();
                            if (llllllllllllllllllllllIIIlIIllll.getMaterial() == Material.AIR || llllllllllllllllllllllIIIlIIlllI == Blocks.DIRT || llllllllllllllllllllllIIIlIIlllI == Blocks.SNOW || llllllllllllllllllllllIIIlIIlllI == Blocks.ICE) {
                                this.setBlockAndNotifyAdequately(llllllllllllllllllllllIIIlIIIlIl, ((BlockPos)llllllllllllllllllllllIIIlIIIIll).add(llllllllllllllllllllllIIIlIlIIll, -llllllllllllllllllllllIIIlIlIllI, llllllllllllllllllllllIIIlIlIIIl), Blocks.PACKED_ICE.getDefaultState());
                            }
                        }
                    }
                }
            }
        }
        int llllllllllllllllllllllIIIlIIllIl = llllllllllllllllllllllIIIlIlIlll - 1;
        if (llllllllllllllllllllllIIIlIIllIl < 0) {
            llllllllllllllllllllllIIIlIIllIl = 0;
        }
        else if (llllllllllllllllllllllIIIlIIllIl > 1) {
            llllllllllllllllllllllIIIlIIllIl = 1;
        }
        for (int llllllllllllllllllllllIIIlIIllII = -llllllllllllllllllllllIIIlIIllIl; llllllllllllllllllllllIIIlIIllII <= llllllllllllllllllllllIIIlIIllIl; ++llllllllllllllllllllllIIIlIIllII) {
            for (int llllllllllllllllllllllIIIlIIlIll = -llllllllllllllllllllllIIIlIIllIl; llllllllllllllllllllllIIIlIIlIll <= llllllllllllllllllllllIIIlIIllIl; ++llllllllllllllllllllllIIIlIIlIll) {
                BlockPos llllllllllllllllllllllIIIlIIlIlI = ((BlockPos)llllllllllllllllllllllIIIlIIIIll).add(llllllllllllllllllllllIIIlIIllII, -1, llllllllllllllllllllllIIIlIIlIll);
                int llllllllllllllllllllllIIIlIIlIIl = 50;
                if (Math.abs(llllllllllllllllllllllIIIlIIllII) == 1 && Math.abs(llllllllllllllllllllllIIIlIIlIll) == 1) {
                    llllllllllllllllllllllIIIlIIlIIl = llllllllllllllllllllllIIIlIllIlI.nextInt(5);
                }
                while (llllllllllllllllllllllIIIlIIlIlI.getY() > 50) {
                    final IBlockState llllllllllllllllllllllIIIlIIlIII = llllllllllllllllllllllIIIlIIIlIl.getBlockState(llllllllllllllllllllllIIIlIIlIlI);
                    final Block llllllllllllllllllllllIIIlIIIlll = llllllllllllllllllllllIIIlIIlIII.getBlock();
                    if (llllllllllllllllllllllIIIlIIlIII.getMaterial() != Material.AIR && llllllllllllllllllllllIIIlIIIlll != Blocks.DIRT && llllllllllllllllllllllIIIlIIIlll != Blocks.SNOW && llllllllllllllllllllllIIIlIIIlll != Blocks.ICE && llllllllllllllllllllllIIIlIIIlll != Blocks.PACKED_ICE) {
                        break;
                    }
                    this.setBlockAndNotifyAdequately(llllllllllllllllllllllIIIlIIIlIl, llllllllllllllllllllllIIIlIIlIlI, Blocks.PACKED_ICE.getDefaultState());
                    llllllllllllllllllllllIIIlIIlIlI = llllllllllllllllllllllIIIlIIlIlI.down();
                    if (--llllllllllllllllllllllIIIlIIlIIl > 0) {
                        continue;
                    }
                    llllllllllllllllllllllIIIlIIlIlI = llllllllllllllllllllllIIIlIIlIlI.down(llllllllllllllllllllllIIIlIllIlI.nextInt(5) + 1);
                    llllllllllllllllllllllIIIlIIlIIl = llllllllllllllllllllllIIIlIllIlI.nextInt(5);
                }
            }
        }
        return true;
    }
}
