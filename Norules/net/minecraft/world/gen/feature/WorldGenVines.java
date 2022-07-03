package net.minecraft.world.gen.feature;

import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;

public class WorldGenVines extends WorldGenerator
{
    @Override
    public boolean generate(final World lllllllllllllIllllllIlIIllIIIllI, final Random lllllllllllllIllllllIlIIllIIIlIl, BlockPos lllllllllllllIllllllIlIIlIllllll) {
        while (lllllllllllllIllllllIlIIlIllllll.getY() < 128) {
            if (lllllllllllllIllllllIlIIllIIIllI.isAirBlock(lllllllllllllIllllllIlIIlIllllll)) {
                final float lllllllllllllIllllllIlIIlIlllIll;
                final float lllllllllllllIllllllIlIIlIllllII = ((EnumFacing[])(Object)(lllllllllllllIllllllIlIIlIlllIll = (float)(Object)EnumFacing.Plane.HORIZONTAL.facings())).length;
                for (String lllllllllllllIllllllIlIIlIllllIl = (String)0; lllllllllllllIllllllIlIIlIllllIl < lllllllllllllIllllllIlIIlIllllII; ++lllllllllllllIllllllIlIIlIllllIl) {
                    final EnumFacing lllllllllllllIllllllIlIIllIIIIll = lllllllllllllIllllllIlIIlIlllIll[lllllllllllllIllllllIlIIlIllllIl];
                    if (Blocks.VINE.canPlaceBlockOnSide(lllllllllllllIllllllIlIIllIIIllI, lllllllllllllIllllllIlIIlIllllll, lllllllllllllIllllllIlIIllIIIIll)) {
                        final IBlockState lllllllllllllIllllllIlIIllIIIIlI = Blocks.VINE.getDefaultState().withProperty((IProperty<Comparable>)BlockVine.NORTH, lllllllllllllIllllllIlIIllIIIIll == EnumFacing.NORTH).withProperty((IProperty<Comparable>)BlockVine.EAST, lllllllllllllIllllllIlIIllIIIIll == EnumFacing.EAST).withProperty((IProperty<Comparable>)BlockVine.SOUTH, lllllllllllllIllllllIlIIllIIIIll == EnumFacing.SOUTH).withProperty((IProperty<Comparable>)BlockVine.WEST, lllllllllllllIllllllIlIIllIIIIll == EnumFacing.WEST);
                        lllllllllllllIllllllIlIIllIIIllI.setBlockState(lllllllllllllIllllllIlIIlIllllll, lllllllllllllIllllllIlIIllIIIIlI, 2);
                        break;
                    }
                }
            }
            else {
                lllllllllllllIllllllIlIIlIllllll = lllllllllllllIllllllIlIIlIllllll.add(lllllllllllllIllllllIlIIllIIIlIl.nextInt(4) - lllllllllllllIllllllIlIIllIIIlIl.nextInt(4), 0, lllllllllllllIllllllIlIIllIIIlIl.nextInt(4) - lllllllllllllIllllllIlIIllIIIlIl.nextInt(4));
            }
            lllllllllllllIllllllIlIIlIllllll = lllllllllllllIllllllIlIIlIllllll.up();
        }
        return true;
    }
}
