package net.minecraft.world.gen.feature;

import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.math.*;
import net.minecraft.block.material.*;
import net.minecraft.init.*;

public class WorldGenReed extends WorldGenerator
{
    @Override
    public boolean generate(final World llllllllllllllIllIIIllIlIlIlIlll, final Random llllllllllllllIllIIIllIlIlIIlllI, final BlockPos llllllllllllllIllIIIllIlIlIIllIl) {
        for (int llllllllllllllIllIIIllIlIlIlIlII = 0; llllllllllllllIllIIIllIlIlIlIlII < 20; ++llllllllllllllIllIIIllIlIlIlIlII) {
            final BlockPos llllllllllllllIllIIIllIlIlIlIIll = llllllllllllllIllIIIllIlIlIIllIl.add(llllllllllllllIllIIIllIlIlIIlllI.nextInt(4) - llllllllllllllIllIIIllIlIlIIlllI.nextInt(4), 0, llllllllllllllIllIIIllIlIlIIlllI.nextInt(4) - llllllllllllllIllIIIllIlIlIIlllI.nextInt(4));
            if (llllllllllllllIllIIIllIlIlIlIlll.isAirBlock(llllllllllllllIllIIIllIlIlIlIIll)) {
                final BlockPos llllllllllllllIllIIIllIlIlIlIIlI = llllllllllllllIllIIIllIlIlIlIIll.down();
                if (llllllllllllllIllIIIllIlIlIlIlll.getBlockState(llllllllllllllIllIIIllIlIlIlIIlI.west()).getMaterial() == Material.WATER || llllllllllllllIllIIIllIlIlIlIlll.getBlockState(llllllllllllllIllIIIllIlIlIlIIlI.east()).getMaterial() == Material.WATER || llllllllllllllIllIIIllIlIlIlIlll.getBlockState(llllllllllllllIllIIIllIlIlIlIIlI.north()).getMaterial() == Material.WATER || llllllllllllllIllIIIllIlIlIlIlll.getBlockState(llllllllllllllIllIIIllIlIlIlIIlI.south()).getMaterial() == Material.WATER) {
                    for (int llllllllllllllIllIIIllIlIlIlIIIl = 2 + llllllllllllllIllIIIllIlIlIIlllI.nextInt(llllllllllllllIllIIIllIlIlIIlllI.nextInt(3) + 1), llllllllllllllIllIIIllIlIlIlIIII = 0; llllllllllllllIllIIIllIlIlIlIIII < llllllllllllllIllIIIllIlIlIlIIIl; ++llllllllllllllIllIIIllIlIlIlIIII) {
                        if (Blocks.REEDS.canBlockStay(llllllllllllllIllIIIllIlIlIlIlll, llllllllllllllIllIIIllIlIlIlIIll)) {
                            llllllllllllllIllIIIllIlIlIlIlll.setBlockState(llllllllllllllIllIIIllIlIlIlIIll.up(llllllllllllllIllIIIllIlIlIlIIII), Blocks.REEDS.getDefaultState(), 2);
                        }
                    }
                }
            }
        }
        return true;
    }
}
