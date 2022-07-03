package net.minecraft.world.gen.feature;

import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.math.*;
import net.minecraft.init.*;

public class WorldGenCactus extends WorldGenerator
{
    @Override
    public boolean generate(final World lllllllllllllIIIIIllllIIllllllll, final Random lllllllllllllIIIIIllllIlIIIIIlIl, final BlockPos lllllllllllllIIIIIllllIlIIIIIlII) {
        for (int lllllllllllllIIIIIllllIlIIIIIIll = 0; lllllllllllllIIIIIllllIlIIIIIIll < 10; ++lllllllllllllIIIIIllllIlIIIIIIll) {
            final BlockPos lllllllllllllIIIIIllllIlIIIIIIlI = lllllllllllllIIIIIllllIlIIIIIlII.add(lllllllllllllIIIIIllllIlIIIIIlIl.nextInt(8) - lllllllllllllIIIIIllllIlIIIIIlIl.nextInt(8), lllllllllllllIIIIIllllIlIIIIIlIl.nextInt(4) - lllllllllllllIIIIIllllIlIIIIIlIl.nextInt(4), lllllllllllllIIIIIllllIlIIIIIlIl.nextInt(8) - lllllllllllllIIIIIllllIlIIIIIlIl.nextInt(8));
            if (lllllllllllllIIIIIllllIIllllllll.isAirBlock(lllllllllllllIIIIIllllIlIIIIIIlI)) {
                for (int lllllllllllllIIIIIllllIlIIIIIIIl = 1 + lllllllllllllIIIIIllllIlIIIIIlIl.nextInt(lllllllllllllIIIIIllllIlIIIIIlIl.nextInt(3) + 1), lllllllllllllIIIIIllllIlIIIIIIII = 0; lllllllllllllIIIIIllllIlIIIIIIII < lllllllllllllIIIIIllllIlIIIIIIIl; ++lllllllllllllIIIIIllllIlIIIIIIII) {
                    if (Blocks.CACTUS.canBlockStay(lllllllllllllIIIIIllllIIllllllll, lllllllllllllIIIIIllllIlIIIIIIlI)) {
                        lllllllllllllIIIIIllllIIllllllll.setBlockState(lllllllllllllIIIIIllllIlIIIIIIlI.up(lllllllllllllIIIIIllllIlIIIIIIII), Blocks.CACTUS.getDefaultState(), 2);
                    }
                }
            }
        }
        return true;
    }
}
