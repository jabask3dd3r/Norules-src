package net.minecraft.world.gen.feature;

import net.minecraft.block.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.math.*;
import net.minecraft.block.material.*;
import net.minecraft.init.*;

public class WorldGenSand extends WorldGenerator
{
    private final /* synthetic */ Block block;
    private final /* synthetic */ int radius;
    
    @Override
    public boolean generate(final World llllllllllllllIlIlIIllIlIlIIllIl, final Random llllllllllllllIlIlIIllIlIlIIllII, final BlockPos llllllllllllllIlIlIIllIlIlIllIII) {
        if (llllllllllllllIlIlIIllIlIlIIllIl.getBlockState(llllllllllllllIlIlIIllIlIlIllIII).getMaterial() != Material.WATER) {
            return false;
        }
        final int llllllllllllllIlIlIIllIlIlIlIlll = llllllllllllllIlIlIIllIlIlIIllII.nextInt(this.radius - 2) + 2;
        final int llllllllllllllIlIlIIllIlIlIlIllI = 2;
        for (int llllllllllllllIlIlIIllIlIlIlIlIl = llllllllllllllIlIlIIllIlIlIllIII.getX() - llllllllllllllIlIlIIllIlIlIlIlll; llllllllllllllIlIlIIllIlIlIlIlIl <= llllllllllllllIlIlIIllIlIlIllIII.getX() + llllllllllllllIlIlIIllIlIlIlIlll; ++llllllllllllllIlIlIIllIlIlIlIlIl) {
            for (int llllllllllllllIlIlIIllIlIlIlIlII = llllllllllllllIlIlIIllIlIlIllIII.getZ() - llllllllllllllIlIlIIllIlIlIlIlll; llllllllllllllIlIlIIllIlIlIlIlII <= llllllllllllllIlIlIIllIlIlIllIII.getZ() + llllllllllllllIlIlIIllIlIlIlIlll; ++llllllllllllllIlIlIIllIlIlIlIlII) {
                final int llllllllllllllIlIlIIllIlIlIlIIll = llllllllllllllIlIlIIllIlIlIlIlIl - llllllllllllllIlIlIIllIlIlIllIII.getX();
                final int llllllllllllllIlIlIIllIlIlIlIIlI = llllllllllllllIlIlIIllIlIlIlIlII - llllllllllllllIlIlIIllIlIlIllIII.getZ();
                if (llllllllllllllIlIlIIllIlIlIlIIll * llllllllllllllIlIlIIllIlIlIlIIll + llllllllllllllIlIlIIllIlIlIlIIlI * llllllllllllllIlIlIIllIlIlIlIIlI <= llllllllllllllIlIlIIllIlIlIlIlll * llllllllllllllIlIlIIllIlIlIlIlll) {
                    for (int llllllllllllllIlIlIIllIlIlIlIIIl = llllllllllllllIlIlIIllIlIlIllIII.getY() - 2; llllllllllllllIlIlIIllIlIlIlIIIl <= llllllllllllllIlIlIIllIlIlIllIII.getY() + 2; ++llllllllllllllIlIlIIllIlIlIlIIIl) {
                        final BlockPos llllllllllllllIlIlIIllIlIlIlIIII = new BlockPos(llllllllllllllIlIlIIllIlIlIlIlIl, llllllllllllllIlIlIIllIlIlIlIIIl, llllllllllllllIlIlIIllIlIlIlIlII);
                        final Block llllllllllllllIlIlIIllIlIlIIllll = llllllllllllllIlIlIIllIlIlIIllIl.getBlockState(llllllllllllllIlIlIIllIlIlIlIIII).getBlock();
                        if (llllllllllllllIlIlIIllIlIlIIllll == Blocks.DIRT || llllllllllllllIlIlIIllIlIlIIllll == Blocks.GRASS) {
                            llllllllllllllIlIlIIllIlIlIIllIl.setBlockState(llllllllllllllIlIlIIllIlIlIlIIII, this.block.getDefaultState(), 2);
                        }
                    }
                }
            }
        }
        return true;
    }
    
    public WorldGenSand(final Block llllllllllllllIlIlIIllIlIllIlIlI, final int llllllllllllllIlIlIIllIlIllIlIIl) {
        this.block = llllllllllllllIlIlIIllIlIllIlIlI;
        this.radius = llllllllllllllIlIlIIllIlIllIlIIl;
    }
}
