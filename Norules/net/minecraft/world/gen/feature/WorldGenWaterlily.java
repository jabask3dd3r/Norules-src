package net.minecraft.world.gen.feature;

import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.math.*;
import net.minecraft.init.*;

public class WorldGenWaterlily extends WorldGenerator
{
    @Override
    public boolean generate(final World lllllllllllllIIlIIlIIlllIlIIIIlI, final Random lllllllllllllIIlIIlIIlllIlIIIIIl, final BlockPos lllllllllllllIIlIIlIIlllIlIIIlll) {
        for (int lllllllllllllIIlIIlIIlllIlIIIllI = 0; lllllllllllllIIlIIlIIlllIlIIIllI < 10; ++lllllllllllllIIlIIlIIlllIlIIIllI) {
            final int lllllllllllllIIlIIlIIlllIlIIIlIl = lllllllllllllIIlIIlIIlllIlIIIlll.getX() + lllllllllllllIIlIIlIIlllIlIIIIIl.nextInt(8) - lllllllllllllIIlIIlIIlllIlIIIIIl.nextInt(8);
            final int lllllllllllllIIlIIlIIlllIlIIIlII = lllllllllllllIIlIIlIIlllIlIIIlll.getY() + lllllllllllllIIlIIlIIlllIlIIIIIl.nextInt(4) - lllllllllllllIIlIIlIIlllIlIIIIIl.nextInt(4);
            final int lllllllllllllIIlIIlIIlllIlIIIIll = lllllllllllllIIlIIlIIlllIlIIIlll.getZ() + lllllllllllllIIlIIlIIlllIlIIIIIl.nextInt(8) - lllllllllllllIIlIIlIIlllIlIIIIIl.nextInt(8);
            if (lllllllllllllIIlIIlIIlllIlIIIIlI.isAirBlock(new BlockPos(lllllllllllllIIlIIlIIlllIlIIIlIl, lllllllllllllIIlIIlIIlllIlIIIlII, lllllllllllllIIlIIlIIlllIlIIIIll)) && Blocks.WATERLILY.canPlaceBlockAt(lllllllllllllIIlIIlIIlllIlIIIIlI, new BlockPos(lllllllllllllIIlIIlIIlllIlIIIlIl, lllllllllllllIIlIIlIIlllIlIIIlII, lllllllllllllIIlIIlIIlllIlIIIIll))) {
                lllllllllllllIIlIIlIIlllIlIIIIlI.setBlockState(new BlockPos(lllllllllllllIIlIIlIIlllIlIIIlIl, lllllllllllllIIlIIlIIlllIlIIIlII, lllllllllllllIIlIIlIIlllIlIIIIll), Blocks.WATERLILY.getDefaultState(), 2);
            }
        }
        return true;
    }
}
