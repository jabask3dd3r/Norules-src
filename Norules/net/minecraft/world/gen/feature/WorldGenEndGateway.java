package net.minecraft.world.gen.feature;

import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.math.*;
import net.minecraft.init.*;

public class WorldGenEndGateway extends WorldGenerator
{
    @Override
    public boolean generate(final World llllllllllllllIlIIIIIlIIlIllllIl, final Random llllllllllllllIlIIIIIlIIllIIIlIl, final BlockPos llllllllllllllIlIIIIIlIIlIllllII) {
        for (final BlockPos.MutableBlockPos llllllllllllllIlIIIIIlIIllIIIIll : BlockPos.getAllInBoxMutable(llllllllllllllIlIIIIIlIIlIllllII.add(-1, -2, -1), llllllllllllllIlIIIIIlIIlIllllII.add(1, 2, 1))) {
            final boolean llllllllllllllIlIIIIIlIIllIIIIlI = llllllllllllllIlIIIIIlIIllIIIIll.getX() == llllllllllllllIlIIIIIlIIlIllllII.getX();
            final boolean llllllllllllllIlIIIIIlIIllIIIIIl = llllllllllllllIlIIIIIlIIllIIIIll.getY() == llllllllllllllIlIIIIIlIIlIllllII.getY();
            final boolean llllllllllllllIlIIIIIlIIllIIIIII = llllllllllllllIlIIIIIlIIllIIIIll.getZ() == llllllllllllllIlIIIIIlIIlIllllII.getZ();
            final boolean llllllllllllllIlIIIIIlIIlIllllll = Math.abs(llllllllllllllIlIIIIIlIIllIIIIll.getY() - llllllllllllllIlIIIIIlIIlIllllII.getY()) == 2;
            if (llllllllllllllIlIIIIIlIIllIIIIlI && llllllllllllllIlIIIIIlIIllIIIIIl && llllllllllllllIlIIIIIlIIllIIIIII) {
                this.setBlockAndNotifyAdequately(llllllllllllllIlIIIIIlIIlIllllIl, new BlockPos(llllllllllllllIlIIIIIlIIllIIIIll), Blocks.END_GATEWAY.getDefaultState());
            }
            else if (llllllllllllllIlIIIIIlIIllIIIIIl) {
                this.setBlockAndNotifyAdequately(llllllllllllllIlIIIIIlIIlIllllIl, llllllllllllllIlIIIIIlIIllIIIIll, Blocks.AIR.getDefaultState());
            }
            else if (llllllllllllllIlIIIIIlIIlIllllll && llllllllllllllIlIIIIIlIIllIIIIlI && llllllllllllllIlIIIIIlIIllIIIIII) {
                this.setBlockAndNotifyAdequately(llllllllllllllIlIIIIIlIIlIllllIl, llllllllllllllIlIIIIIlIIllIIIIll, Blocks.BEDROCK.getDefaultState());
            }
            else if ((llllllllllllllIlIIIIIlIIllIIIIlI || llllllllllllllIlIIIIIlIIllIIIIII) && !llllllllllllllIlIIIIIlIIlIllllll) {
                this.setBlockAndNotifyAdequately(llllllllllllllIlIIIIIlIIlIllllIl, llllllllllllllIlIIIIIlIIllIIIIll, Blocks.BEDROCK.getDefaultState());
            }
            else {
                this.setBlockAndNotifyAdequately(llllllllllllllIlIIIIIlIIlIllllIl, llllllllllllllIlIIIIIlIIllIIIIll, Blocks.AIR.getDefaultState());
            }
        }
        return true;
    }
}
