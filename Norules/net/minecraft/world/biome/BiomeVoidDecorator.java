package net.minecraft.world.biome;

import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.math.*;
import net.minecraft.init.*;

public class BiomeVoidDecorator extends BiomeDecorator
{
    @Override
    public void decorate(final World lllllllllllllIlIlIIlIIIlIlllIllI, final Random lllllllllllllIlIlIIlIIIllIIIIIIl, final Biome lllllllllllllIlIlIIlIIIllIIIIIII, final BlockPos lllllllllllllIlIlIIlIIIlIlllllll) {
        final BlockPos lllllllllllllIlIlIIlIIIlIllllllI = lllllllllllllIlIlIIlIIIlIlllIllI.getSpawnPoint();
        final int lllllllllllllIlIlIIlIIIlIlllllIl = 16;
        final double lllllllllllllIlIlIIlIIIlIlllllII = lllllllllllllIlIlIIlIIIlIllllllI.distanceSq(lllllllllllllIlIlIIlIIIlIlllllll.add(8, lllllllllllllIlIlIIlIIIlIllllllI.getY(), 8));
        if (lllllllllllllIlIlIIlIIIlIlllllII <= 1024.0) {
            final BlockPos lllllllllllllIlIlIIlIIIlIllllIll = new BlockPos(lllllllllllllIlIlIIlIIIlIllllllI.getX() - 16, lllllllllllllIlIlIIlIIIlIllllllI.getY() - 1, lllllllllllllIlIlIIlIIIlIllllllI.getZ() - 16);
            final BlockPos lllllllllllllIlIlIIlIIIlIllllIlI = new BlockPos(lllllllllllllIlIlIIlIIIlIllllllI.getX() + 16, lllllllllllllIlIlIIlIIIlIllllllI.getY() - 1, lllllllllllllIlIlIIlIIIlIllllllI.getZ() + 16);
            final BlockPos.MutableBlockPos lllllllllllllIlIlIIlIIIlIllllIIl = new BlockPos.MutableBlockPos(lllllllllllllIlIlIIlIIIlIllllIll);
            for (int lllllllllllllIlIlIIlIIIlIllllIII = lllllllllllllIlIlIIlIIIlIlllllll.getZ(); lllllllllllllIlIlIIlIIIlIllllIII < lllllllllllllIlIlIIlIIIlIlllllll.getZ() + 16; ++lllllllllllllIlIlIIlIIIlIllllIII) {
                for (int lllllllllllllIlIlIIlIIIlIlllIlll = lllllllllllllIlIlIIlIIIlIlllllll.getX(); lllllllllllllIlIlIIlIIIlIlllIlll < lllllllllllllIlIlIIlIIIlIlllllll.getX() + 16; ++lllllllllllllIlIlIIlIIIlIlllIlll) {
                    if (lllllllllllllIlIlIIlIIIlIllllIII >= lllllllllllllIlIlIIlIIIlIllllIll.getZ() && lllllllllllllIlIlIIlIIIlIllllIII <= lllllllllllllIlIlIIlIIIlIllllIlI.getZ() && lllllllllllllIlIlIIlIIIlIlllIlll >= lllllllllllllIlIlIIlIIIlIllllIll.getX() && lllllllllllllIlIlIIlIIIlIlllIlll <= lllllllllllllIlIlIIlIIIlIllllIlI.getX()) {
                        lllllllllllllIlIlIIlIIIlIllllIIl.setPos(lllllllllllllIlIlIIlIIIlIlllIlll, lllllllllllllIlIlIIlIIIlIllllIIl.getY(), lllllllllllllIlIlIIlIIIlIllllIII);
                        if (lllllllllllllIlIlIIlIIIlIllllllI.getX() == lllllllllllllIlIlIIlIIIlIlllIlll && lllllllllllllIlIlIIlIIIlIllllllI.getZ() == lllllllllllllIlIlIIlIIIlIllllIII) {
                            lllllllllllllIlIlIIlIIIlIlllIllI.setBlockState(lllllllllllllIlIlIIlIIIlIllllIIl, Blocks.COBBLESTONE.getDefaultState(), 2);
                        }
                        else {
                            lllllllllllllIlIlIIlIIIlIlllIllI.setBlockState(lllllllllllllIlIlIIlIIIlIllllIIl, Blocks.STONE.getDefaultState(), 2);
                        }
                    }
                }
            }
        }
    }
}
