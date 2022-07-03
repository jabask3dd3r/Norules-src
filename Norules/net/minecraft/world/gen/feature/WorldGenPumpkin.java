package net.minecraft.world.gen.feature;

import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.math.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import net.minecraft.util.*;
import net.minecraft.block.properties.*;

public class WorldGenPumpkin extends WorldGenerator
{
    @Override
    public boolean generate(final World llIlIIIlIIllIIl, final Random llIlIIIlIIlllIl, final BlockPos llIlIIIlIIlllII) {
        for (int llIlIIIlIIllIll = 0; llIlIIIlIIllIll < 64; ++llIlIIIlIIllIll) {
            final BlockPos llIlIIIlIIllIlI = llIlIIIlIIlllII.add(llIlIIIlIIlllIl.nextInt(8) - llIlIIIlIIlllIl.nextInt(8), llIlIIIlIIlllIl.nextInt(4) - llIlIIIlIIlllIl.nextInt(4), llIlIIIlIIlllIl.nextInt(8) - llIlIIIlIIlllIl.nextInt(8));
            if (llIlIIIlIIllIIl.isAirBlock(llIlIIIlIIllIlI) && llIlIIIlIIllIIl.getBlockState(llIlIIIlIIllIlI.down()).getBlock() == Blocks.GRASS && Blocks.PUMPKIN.canPlaceBlockAt(llIlIIIlIIllIIl, llIlIIIlIIllIlI)) {
                llIlIIIlIIllIIl.setBlockState(llIlIIIlIIllIlI, Blocks.PUMPKIN.getDefaultState().withProperty((IProperty<Comparable>)BlockPumpkin.FACING, EnumFacing.Plane.HORIZONTAL.random(llIlIIIlIIlllIl)), 2);
            }
        }
        return true;
    }
}
