package net.minecraft.world.gen.feature;

import net.minecraft.block.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.init.*;
import net.minecraft.util.math.*;

public class WorldGenBlockBlob extends WorldGenerator
{
    private final /* synthetic */ int startRadius;
    private final /* synthetic */ Block block;
    
    public WorldGenBlockBlob(final Block lllllllllllllIIlIIIIlIlIlllIIIIl, final int lllllllllllllIIlIIIIlIlIllIlllIl) {
        super(false);
        this.block = lllllllllllllIIlIIIIlIlIlllIIIIl;
        this.startRadius = lllllllllllllIIlIIIIlIlIllIlllIl;
    }
    
    @Override
    public boolean generate(final World lllllllllllllIIlIIIIlIlIllIIIIll, final Random lllllllllllllIIlIIIIlIlIllIIlllI, BlockPos lllllllllllllIIlIIIIlIlIllIIIIIl) {
        while (((Vec3i)lllllllllllllIIlIIIIlIlIllIIIIIl).getY() > 3) {
            if (!lllllllllllllIIlIIIIlIlIllIIIIll.isAirBlock(((BlockPos)lllllllllllllIIlIIIIlIlIllIIIIIl).down())) {
                final Block lllllllllllllIIlIIIIlIlIllIIllII = lllllllllllllIIlIIIIlIlIllIIIIll.getBlockState(((BlockPos)lllllllllllllIIlIIIIlIlIllIIIIIl).down()).getBlock();
                if (lllllllllllllIIlIIIIlIlIllIIllII == Blocks.GRASS || lllllllllllllIIlIIIIlIlIllIIllII == Blocks.DIRT || lllllllllllllIIlIIIIlIlIllIIllII == Blocks.STONE) {
                    break;
                }
            }
            lllllllllllllIIlIIIIlIlIllIIIIIl = ((BlockPos)lllllllllllllIIlIIIIlIlIllIIIIIl).down();
        }
        if (((Vec3i)lllllllllllllIIlIIIIlIlIllIIIIIl).getY() <= 3) {
            return false;
        }
        for (int lllllllllllllIIlIIIIlIlIllIIlIll = this.startRadius, lllllllllllllIIlIIIIlIlIllIIlIlI = 0; lllllllllllllIIlIIIIlIlIllIIlIll >= 0 && lllllllllllllIIlIIIIlIlIllIIlIlI < 3; ++lllllllllllllIIlIIIIlIlIllIIlIlI) {
            final int lllllllllllllIIlIIIIlIlIllIIlIIl = lllllllllllllIIlIIIIlIlIllIIlIll + lllllllllllllIIlIIIIlIlIllIIlllI.nextInt(2);
            final int lllllllllllllIIlIIIIlIlIllIIlIII = lllllllllllllIIlIIIIlIlIllIIlIll + lllllllllllllIIlIIIIlIlIllIIlllI.nextInt(2);
            final int lllllllllllllIIlIIIIlIlIllIIIlll = lllllllllllllIIlIIIIlIlIllIIlIll + lllllllllllllIIlIIIIlIlIllIIlllI.nextInt(2);
            final float lllllllllllllIIlIIIIlIlIllIIIllI = (lllllllllllllIIlIIIIlIlIllIIlIIl + lllllllllllllIIlIIIIlIlIllIIlIII + lllllllllllllIIlIIIIlIlIllIIIlll) * 0.333f + 0.5f;
            for (final BlockPos lllllllllllllIIlIIIIlIlIllIIIlIl : BlockPos.getAllInBox(((BlockPos)lllllllllllllIIlIIIIlIlIllIIIIIl).add(-lllllllllllllIIlIIIIlIlIllIIlIIl, -lllllllllllllIIlIIIIlIlIllIIlIII, -lllllllllllllIIlIIIIlIlIllIIIlll), ((BlockPos)lllllllllllllIIlIIIIlIlIllIIIIIl).add(lllllllllllllIIlIIIIlIlIllIIlIIl, lllllllllllllIIlIIIIlIlIllIIlIII, lllllllllllllIIlIIIIlIlIllIIIlll))) {
                if (lllllllllllllIIlIIIIlIlIllIIIlIl.distanceSq((Vec3i)lllllllllllllIIlIIIIlIlIllIIIIIl) <= lllllllllllllIIlIIIIlIlIllIIIllI * lllllllllllllIIlIIIIlIlIllIIIllI) {
                    lllllllllllllIIlIIIIlIlIllIIIIll.setBlockState(lllllllllllllIIlIIIIlIlIllIIIlIl, this.block.getDefaultState(), 4);
                }
            }
            lllllllllllllIIlIIIIlIlIllIIIIIl = ((BlockPos)lllllllllllllIIlIIIIlIlIllIIIIIl).add(-(lllllllllllllIIlIIIIlIlIllIIlIll + 1) + lllllllllllllIIlIIIIlIlIllIIlllI.nextInt(2 + lllllllllllllIIlIIIIlIlIllIIlIll * 2), 0 - lllllllllllllIIlIIIIlIlIllIIlllI.nextInt(2), -(lllllllllllllIIlIIIIlIlIllIIlIll + 1) + lllllllllllllIIlIIIIlIlIllIIlllI.nextInt(2 + lllllllllllllIIlIIIIlIlIllIIlIll * 2));
        }
        return true;
    }
}
