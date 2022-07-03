package net.minecraft.world.gen.feature;

import net.minecraft.block.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.math.*;

public class WorldGenBush extends WorldGenerator
{
    private final /* synthetic */ BlockBush block;
    
    public WorldGenBush(final BlockBush llllllllllllllIlIIIlIIlIIlIlIlll) {
        this.block = llllllllllllllIlIIIlIIlIIlIlIlll;
    }
    
    @Override
    public boolean generate(final World llllllllllllllIlIIIlIIlIIlIIllll, final Random llllllllllllllIlIIIlIIlIIlIIlIII, final BlockPos llllllllllllllIlIIIlIIlIIlIIIlll) {
        for (int llllllllllllllIlIIIlIIlIIlIIllII = 0; llllllllllllllIlIIIlIIlIIlIIllII < 64; ++llllllllllllllIlIIIlIIlIIlIIllII) {
            final BlockPos llllllllllllllIlIIIlIIlIIlIIlIll = llllllllllllllIlIIIlIIlIIlIIIlll.add(llllllllllllllIlIIIlIIlIIlIIlIII.nextInt(8) - llllllllllllllIlIIIlIIlIIlIIlIII.nextInt(8), llllllllllllllIlIIIlIIlIIlIIlIII.nextInt(4) - llllllllllllllIlIIIlIIlIIlIIlIII.nextInt(4), llllllllllllllIlIIIlIIlIIlIIlIII.nextInt(8) - llllllllllllllIlIIIlIIlIIlIIlIII.nextInt(8));
            if (llllllllllllllIlIIIlIIlIIlIIllll.isAirBlock(llllllllllllllIlIIIlIIlIIlIIlIll) && (!llllllllllllllIlIIIlIIlIIlIIllll.provider.getHasNoSky() || llllllllllllllIlIIIlIIlIIlIIlIll.getY() < 255) && this.block.canBlockStay(llllllllllllllIlIIIlIIlIIlIIllll, llllllllllllllIlIIIlIIlIIlIIlIll, this.block.getDefaultState())) {
                llllllllllllllIlIIIlIIlIIlIIllll.setBlockState(llllllllllllllIlIIIlIIlIIlIIlIll, this.block.getDefaultState(), 2);
            }
        }
        return true;
    }
}
