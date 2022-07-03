package net.minecraft.world.gen.feature;

import net.minecraft.block.*;
import net.minecraft.init.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.math.*;

public class WorldGenIcePath extends WorldGenerator
{
    private final /* synthetic */ Block block;
    private final /* synthetic */ int basePathWidth;
    
    public WorldGenIcePath(final int llllllllllllllllllIIIlIlIIlIIlll) {
        this.block = Blocks.PACKED_ICE;
        this.basePathWidth = llllllllllllllllllIIIlIlIIlIIlll;
    }
    
    @Override
    public boolean generate(final World llllllllllllllllllIIIlIlIIIllIII, final Random llllllllllllllllllIIIlIlIIIlIlll, BlockPos llllllllllllllllllIIIlIlIIIIlIIl) {
        while (llllllllllllllllllIIIlIlIIIllIII.isAirBlock(llllllllllllllllllIIIlIlIIIIlIIl) && llllllllllllllllllIIIlIlIIIIlIIl.getY() > 2) {
            llllllllllllllllllIIIlIlIIIIlIIl = llllllllllllllllllIIIlIlIIIIlIIl.down();
        }
        if (llllllllllllllllllIIIlIlIIIllIII.getBlockState(llllllllllllllllllIIIlIlIIIIlIIl).getBlock() != Blocks.SNOW) {
            return false;
        }
        final int llllllllllllllllllIIIlIlIIIlIlIl = llllllllllllllllllIIIlIlIIIlIlll.nextInt(this.basePathWidth - 2) + 2;
        final int llllllllllllllllllIIIlIlIIIlIlII = 1;
        for (int llllllllllllllllllIIIlIlIIIlIIll = llllllllllllllllllIIIlIlIIIIlIIl.getX() - llllllllllllllllllIIIlIlIIIlIlIl; llllllllllllllllllIIIlIlIIIlIIll <= llllllllllllllllllIIIlIlIIIIlIIl.getX() + llllllllllllllllllIIIlIlIIIlIlIl; ++llllllllllllllllllIIIlIlIIIlIIll) {
            for (int llllllllllllllllllIIIlIlIIIlIIlI = llllllllllllllllllIIIlIlIIIIlIIl.getZ() - llllllllllllllllllIIIlIlIIIlIlIl; llllllllllllllllllIIIlIlIIIlIIlI <= llllllllllllllllllIIIlIlIIIIlIIl.getZ() + llllllllllllllllllIIIlIlIIIlIlIl; ++llllllllllllllllllIIIlIlIIIlIIlI) {
                final int llllllllllllllllllIIIlIlIIIlIIIl = llllllllllllllllllIIIlIlIIIlIIll - llllllllllllllllllIIIlIlIIIIlIIl.getX();
                final int llllllllllllllllllIIIlIlIIIlIIII = llllllllllllllllllIIIlIlIIIlIIlI - llllllllllllllllllIIIlIlIIIIlIIl.getZ();
                if (llllllllllllllllllIIIlIlIIIlIIIl * llllllllllllllllllIIIlIlIIIlIIIl + llllllllllllllllllIIIlIlIIIlIIII * llllllllllllllllllIIIlIlIIIlIIII <= llllllllllllllllllIIIlIlIIIlIlIl * llllllllllllllllllIIIlIlIIIlIlIl) {
                    for (int llllllllllllllllllIIIlIlIIIIllll = llllllllllllllllllIIIlIlIIIIlIIl.getY() - 1; llllllllllllllllllIIIlIlIIIIllll <= llllllllllllllllllIIIlIlIIIIlIIl.getY() + 1; ++llllllllllllllllllIIIlIlIIIIllll) {
                        final BlockPos llllllllllllllllllIIIlIlIIIIlllI = new BlockPos(llllllllllllllllllIIIlIlIIIlIIll, llllllllllllllllllIIIlIlIIIIllll, llllllllllllllllllIIIlIlIIIlIIlI);
                        final Block llllllllllllllllllIIIlIlIIIIllIl = llllllllllllllllllIIIlIlIIIllIII.getBlockState(llllllllllllllllllIIIlIlIIIIlllI).getBlock();
                        if (llllllllllllllllllIIIlIlIIIIllIl == Blocks.DIRT || llllllllllllllllllIIIlIlIIIIllIl == Blocks.SNOW || llllllllllllllllllIIIlIlIIIIllIl == Blocks.ICE) {
                            llllllllllllllllllIIIlIlIIIllIII.setBlockState(llllllllllllllllllIIIlIlIIIIlllI, this.block.getDefaultState(), 2);
                        }
                    }
                }
            }
        }
        return true;
    }
}
