package net.minecraft.world.gen.feature;

import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.math.*;
import net.minecraft.init.*;
import net.minecraft.block.material.*;
import net.minecraft.util.*;

public class WorldGenGlowStone1 extends WorldGenerator
{
    @Override
    public boolean generate(final World llIlIllllIIllll, final Random llIlIllllIIIlll, final BlockPos llIlIllllIIIllI) {
        if (!llIlIllllIIllll.isAirBlock(llIlIllllIIIllI)) {
            return false;
        }
        if (llIlIllllIIllll.getBlockState(llIlIllllIIIllI.up()).getBlock() != Blocks.NETHERRACK) {
            return false;
        }
        llIlIllllIIllll.setBlockState(llIlIllllIIIllI, Blocks.GLOWSTONE.getDefaultState(), 2);
        for (int llIlIllllIIllII = 0; llIlIllllIIllII < 1500; ++llIlIllllIIllII) {
            final BlockPos llIlIllllIIlIll = llIlIllllIIIllI.add(llIlIllllIIIlll.nextInt(8) - llIlIllllIIIlll.nextInt(8), -llIlIllllIIIlll.nextInt(12), llIlIllllIIIlll.nextInt(8) - llIlIllllIIIlll.nextInt(8));
            if (llIlIllllIIllll.getBlockState(llIlIllllIIlIll).getMaterial() == Material.AIR) {
                int llIlIllllIIlIlI = 0;
                final Exception llIlIlllIllllll;
                final char llIlIllllIIIIII = (char)((EnumFacing[])(Object)(llIlIlllIllllll = (Exception)(Object)EnumFacing.values())).length;
                for (long llIlIllllIIIIIl = 0; llIlIllllIIIIIl < llIlIllllIIIIII; ++llIlIllllIIIIIl) {
                    final EnumFacing llIlIllllIIlIIl = llIlIlllIllllll[llIlIllllIIIIIl];
                    if (llIlIllllIIllll.getBlockState(llIlIllllIIlIll.offset(llIlIllllIIlIIl)).getBlock() == Blocks.GLOWSTONE) {
                        ++llIlIllllIIlIlI;
                    }
                    if (llIlIllllIIlIlI > 1) {
                        break;
                    }
                }
                if (llIlIllllIIlIlI == 1) {
                    llIlIllllIIllll.setBlockState(llIlIllllIIlIll, Blocks.GLOWSTONE.getDefaultState(), 2);
                }
            }
        }
        return true;
    }
}
