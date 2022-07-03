package net.minecraft.world.gen.feature;

import net.minecraft.world.*;
import java.util.*;
import net.minecraft.block.material.*;
import net.minecraft.init.*;
import net.minecraft.block.state.*;
import net.minecraft.util.math.*;

public class WorldGenDeadBush extends WorldGenerator
{
    @Override
    public boolean generate(final World lllllllllllllllIIllIlllllIIIlllI, final Random lllllllllllllllIIllIlllllIIIllII, BlockPos lllllllllllllllIIllIlllllIIIIIII) {
        for (IBlockState lllllllllllllllIIllIlllllIIIlIIl = lllllllllllllllIIllIlllllIIIlllI.getBlockState((BlockPos)lllllllllllllllIIllIlllllIIIIIII); (lllllllllllllllIIllIlllllIIIlIIl.getMaterial() == Material.AIR || lllllllllllllllIIllIlllllIIIlIIl.getMaterial() == Material.LEAVES) && ((Vec3i)lllllllllllllllIIllIlllllIIIIIII).getY() > 0; lllllllllllllllIIllIlllllIIIIIII = ((BlockPos)lllllllllllllllIIllIlllllIIIIIII).down(), lllllllllllllllIIllIlllllIIIlIIl = lllllllllllllllIIllIlllllIIIlllI.getBlockState((BlockPos)lllllllllllllllIIllIlllllIIIIIII)) {}
        for (int lllllllllllllllIIllIlllllIIIIlll = 0; lllllllllllllllIIllIlllllIIIIlll < 4; ++lllllllllllllllIIllIlllllIIIIlll) {
            final BlockPos lllllllllllllllIIllIlllllIIIIlIl = ((BlockPos)lllllllllllllllIIllIlllllIIIIIII).add(lllllllllllllllIIllIlllllIIIllII.nextInt(8) - lllllllllllllllIIllIlllllIIIllII.nextInt(8), lllllllllllllllIIllIlllllIIIllII.nextInt(4) - lllllllllllllllIIllIlllllIIIllII.nextInt(4), lllllllllllllllIIllIlllllIIIllII.nextInt(8) - lllllllllllllllIIllIlllllIIIllII.nextInt(8));
            if (lllllllllllllllIIllIlllllIIIlllI.isAirBlock(lllllllllllllllIIllIlllllIIIIlIl) && Blocks.DEADBUSH.canBlockStay(lllllllllllllllIIllIlllllIIIlllI, lllllllllllllllIIllIlllllIIIIlIl, Blocks.DEADBUSH.getDefaultState())) {
                lllllllllllllllIIllIlllllIIIlllI.setBlockState(lllllllllllllllIIllIlllllIIIIlIl, Blocks.DEADBUSH.getDefaultState(), 2);
            }
        }
        return true;
    }
}
