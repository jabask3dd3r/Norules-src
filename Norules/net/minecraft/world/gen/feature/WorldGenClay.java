package net.minecraft.world.gen.feature;

import net.minecraft.block.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.math.*;
import net.minecraft.block.material.*;
import net.minecraft.init.*;

public class WorldGenClay extends WorldGenerator
{
    private final /* synthetic */ int numberOfBlocks;
    private final /* synthetic */ Block block;
    
    @Override
    public boolean generate(final World lllllllllllllllIIIIIIIlIIlIIIlll, final Random lllllllllllllllIIIIIIIlIIIlllIIl, final BlockPos lllllllllllllllIIIIIIIlIIIlllIII) {
        if (lllllllllllllllIIIIIIIlIIlIIIlll.getBlockState(lllllllllllllllIIIIIIIlIIIlllIII).getMaterial() != Material.WATER) {
            return false;
        }
        final int lllllllllllllllIIIIIIIlIIlIIIlII = lllllllllllllllIIIIIIIlIIIlllIIl.nextInt(this.numberOfBlocks - 2) + 2;
        final int lllllllllllllllIIIIIIIlIIlIIIIll = 1;
        for (int lllllllllllllllIIIIIIIlIIlIIIIlI = lllllllllllllllIIIIIIIlIIIlllIII.getX() - lllllllllllllllIIIIIIIlIIlIIIlII; lllllllllllllllIIIIIIIlIIlIIIIlI <= lllllllllllllllIIIIIIIlIIIlllIII.getX() + lllllllllllllllIIIIIIIlIIlIIIlII; ++lllllllllllllllIIIIIIIlIIlIIIIlI) {
            for (int lllllllllllllllIIIIIIIlIIlIIIIIl = lllllllllllllllIIIIIIIlIIIlllIII.getZ() - lllllllllllllllIIIIIIIlIIlIIIlII; lllllllllllllllIIIIIIIlIIlIIIIIl <= lllllllllllllllIIIIIIIlIIIlllIII.getZ() + lllllllllllllllIIIIIIIlIIlIIIlII; ++lllllllllllllllIIIIIIIlIIlIIIIIl) {
                final int lllllllllllllllIIIIIIIlIIlIIIIII = lllllllllllllllIIIIIIIlIIlIIIIlI - lllllllllllllllIIIIIIIlIIIlllIII.getX();
                final int lllllllllllllllIIIIIIIlIIIllllll = lllllllllllllllIIIIIIIlIIlIIIIIl - lllllllllllllllIIIIIIIlIIIlllIII.getZ();
                if (lllllllllllllllIIIIIIIlIIlIIIIII * lllllllllllllllIIIIIIIlIIlIIIIII + lllllllllllllllIIIIIIIlIIIllllll * lllllllllllllllIIIIIIIlIIIllllll <= lllllllllllllllIIIIIIIlIIlIIIlII * lllllllllllllllIIIIIIIlIIlIIIlII) {
                    for (int lllllllllllllllIIIIIIIlIIIlllllI = lllllllllllllllIIIIIIIlIIIlllIII.getY() - 1; lllllllllllllllIIIIIIIlIIIlllllI <= lllllllllllllllIIIIIIIlIIIlllIII.getY() + 1; ++lllllllllllllllIIIIIIIlIIIlllllI) {
                        final BlockPos lllllllllllllllIIIIIIIlIIIllllIl = new BlockPos(lllllllllllllllIIIIIIIlIIlIIIIlI, lllllllllllllllIIIIIIIlIIIlllllI, lllllllllllllllIIIIIIIlIIlIIIIIl);
                        final Block lllllllllllllllIIIIIIIlIIIllllII = lllllllllllllllIIIIIIIlIIlIIIlll.getBlockState(lllllllllllllllIIIIIIIlIIIllllIl).getBlock();
                        if (lllllllllllllllIIIIIIIlIIIllllII == Blocks.DIRT || lllllllllllllllIIIIIIIlIIIllllII == Blocks.CLAY) {
                            lllllllllllllllIIIIIIIlIIlIIIlll.setBlockState(lllllllllllllllIIIIIIIlIIIllllIl, this.block.getDefaultState(), 2);
                        }
                    }
                }
            }
        }
        return true;
    }
    
    public WorldGenClay(final int lllllllllllllllIIIIIIIlIIlIlIllI) {
        this.block = Blocks.CLAY;
        this.numberOfBlocks = lllllllllllllllIIIIIIIlIIlIlIllI;
    }
}
