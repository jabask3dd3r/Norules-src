package net.minecraft.world.gen.feature;

import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.math.*;
import net.minecraft.init.*;

public class WorldGenFire extends WorldGenerator
{
    @Override
    public boolean generate(final World llllllllllllllIIIlIIIllIIlIlllII, final Random llllllllllllllIIIlIIIllIIlIlIllI, final BlockPos llllllllllllllIIIlIIIllIIlIllIlI) {
        for (int llllllllllllllIIIlIIIllIIlIllIIl = 0; llllllllllllllIIIlIIIllIIlIllIIl < 64; ++llllllllllllllIIIlIIIllIIlIllIIl) {
            final BlockPos llllllllllllllIIIlIIIllIIlIllIII = llllllllllllllIIIlIIIllIIlIllIlI.add(llllllllllllllIIIlIIIllIIlIlIllI.nextInt(8) - llllllllllllllIIIlIIIllIIlIlIllI.nextInt(8), llllllllllllllIIIlIIIllIIlIlIllI.nextInt(4) - llllllllllllllIIIlIIIllIIlIlIllI.nextInt(4), llllllllllllllIIIlIIIllIIlIlIllI.nextInt(8) - llllllllllllllIIIlIIIllIIlIlIllI.nextInt(8));
            if (llllllllllllllIIIlIIIllIIlIlllII.isAirBlock(llllllllllllllIIIlIIIllIIlIllIII) && llllllllllllllIIIlIIIllIIlIlllII.getBlockState(llllllllllllllIIIlIIIllIIlIllIII.down()).getBlock() == Blocks.NETHERRACK) {
                llllllllllllllIIIlIIIllIIlIlllII.setBlockState(llllllllllllllIIIlIIIllIIlIllIII, Blocks.FIRE.getDefaultState(), 2);
            }
        }
        return true;
    }
}
