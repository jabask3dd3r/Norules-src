package net.minecraft.world.gen.feature;

import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.math.*;
import net.minecraft.init.*;

public class WorldGenMelon extends WorldGenerator
{
    @Override
    public boolean generate(final World llllllllllllllIIIlIIIlIlllIIlIlI, final Random llllllllllllllIIIlIIIlIlllIIlIIl, final BlockPos llllllllllllllIIIlIIIlIlllIIlIII) {
        for (int llllllllllllllIIIlIIIlIlllIIllII = 0; llllllllllllllIIIlIIIlIlllIIllII < 64; ++llllllllllllllIIIlIIIlIlllIIllII) {
            final BlockPos llllllllllllllIIIlIIIlIlllIIlIll = llllllllllllllIIIlIIIlIlllIIlIII.add(llllllllllllllIIIlIIIlIlllIIlIIl.nextInt(8) - llllllllllllllIIIlIIIlIlllIIlIIl.nextInt(8), llllllllllllllIIIlIIIlIlllIIlIIl.nextInt(4) - llllllllllllllIIIlIIIlIlllIIlIIl.nextInt(4), llllllllllllllIIIlIIIlIlllIIlIIl.nextInt(8) - llllllllllllllIIIlIIIlIlllIIlIIl.nextInt(8));
            if (Blocks.MELON_BLOCK.canPlaceBlockAt(llllllllllllllIIIlIIIlIlllIIlIlI, llllllllllllllIIIlIIIlIlllIIlIll) && llllllllllllllIIIlIIIlIlllIIlIlI.getBlockState(llllllllllllllIIIlIIIlIlllIIlIll.down()).getBlock() == Blocks.GRASS) {
                llllllllllllllIIIlIIIlIlllIIlIlI.setBlockState(llllllllllllllIIIlIIIlIlllIIlIll, Blocks.MELON_BLOCK.getDefaultState(), 2);
            }
        }
        return true;
    }
}
