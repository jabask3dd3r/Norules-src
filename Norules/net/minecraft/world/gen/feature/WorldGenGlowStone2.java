package net.minecraft.world.gen.feature;

import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.math.*;
import net.minecraft.init.*;
import net.minecraft.block.material.*;
import net.minecraft.util.*;

public class WorldGenGlowStone2 extends WorldGenerator
{
    @Override
    public boolean generate(final World lllllllllllllIIIlIIIIlIIIIlIlIII, final Random lllllllllllllIIIlIIIIlIIIIllIIIl, final BlockPos lllllllllllllIIIlIIIIlIIIIlIllll) {
        if (!lllllllllllllIIIlIIIIlIIIIlIlIII.isAirBlock(lllllllllllllIIIlIIIIlIIIIlIllll)) {
            return false;
        }
        if (lllllllllllllIIIlIIIIlIIIIlIlIII.getBlockState(lllllllllllllIIIlIIIIlIIIIlIllll.up()).getBlock() != Blocks.NETHERRACK) {
            return false;
        }
        lllllllllllllIIIlIIIIlIIIIlIlIII.setBlockState(lllllllllllllIIIlIIIIlIIIIlIllll, Blocks.GLOWSTONE.getDefaultState(), 2);
        for (int lllllllllllllIIIlIIIIlIIIIlIllIl = 0; lllllllllllllIIIlIIIIlIIIIlIllIl < 1500; ++lllllllllllllIIIlIIIIlIIIIlIllIl) {
            final BlockPos lllllllllllllIIIlIIIIlIIIIlIlIll = lllllllllllllIIIlIIIIlIIIIlIllll.add(lllllllllllllIIIlIIIIlIIIIllIIIl.nextInt(8) - lllllllllllllIIIlIIIIlIIIIllIIIl.nextInt(8), -lllllllllllllIIIlIIIIlIIIIllIIIl.nextInt(12), lllllllllllllIIIlIIIIlIIIIllIIIl.nextInt(8) - lllllllllllllIIIlIIIIlIIIIllIIIl.nextInt(8));
            if (lllllllllllllIIIlIIIIlIIIIlIlIII.getBlockState(lllllllllllllIIIlIIIIlIIIIlIlIll).getMaterial() == Material.AIR) {
                int lllllllllllllIIIlIIIIlIIIIlIlIlI = 0;
                char lllllllllllllIIIlIIIIlIIIIIlllIl;
                for (float lllllllllllllIIIlIIIIlIIIIIllllI = ((EnumFacing[])(Object)(lllllllllllllIIIlIIIIlIIIIIlllIl = (char)(Object)EnumFacing.values())).length, lllllllllllllIIIlIIIIlIIIIIlllll = 0; lllllllllllllIIIlIIIIlIIIIIlllll < lllllllllllllIIIlIIIIlIIIIIllllI; ++lllllllllllllIIIlIIIIlIIIIIlllll) {
                    final EnumFacing lllllllllllllIIIlIIIIlIIIIlIlIIl = lllllllllllllIIIlIIIIlIIIIIlllIl[lllllllllllllIIIlIIIIlIIIIIlllll];
                    if (lllllllllllllIIIlIIIIlIIIIlIlIII.getBlockState(lllllllllllllIIIlIIIIlIIIIlIlIll.offset(lllllllllllllIIIlIIIIlIIIIlIlIIl)).getBlock() == Blocks.GLOWSTONE) {
                        ++lllllllllllllIIIlIIIIlIIIIlIlIlI;
                    }
                    if (lllllllllllllIIIlIIIIlIIIIlIlIlI > 1) {
                        break;
                    }
                }
                if (lllllllllllllIIIlIIIIlIIIIlIlIlI == 1) {
                    lllllllllllllIIIlIIIIlIIIIlIlIII.setBlockState(lllllllllllllIIIlIIIIlIIIIlIlIll, Blocks.GLOWSTONE.getDefaultState(), 2);
                }
            }
        }
        return true;
    }
}
