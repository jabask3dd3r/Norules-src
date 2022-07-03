package net.minecraft.world.gen.feature;

import net.minecraft.world.*;
import java.util.*;
import net.minecraft.util.math.*;
import net.minecraft.init.*;

public class WorldGenEndIsland extends WorldGenerator
{
    @Override
    public boolean generate(final World llllllllllllllIlIIllllIIlllllllI, final Random llllllllllllllIlIIllllIIllllllIl, final BlockPos llllllllllllllIlIIllllIIllllllII) {
        float llllllllllllllIlIIllllIIlllllIll = (float)(llllllllllllllIlIIllllIIllllllIl.nextInt(3) + 4);
        for (int llllllllllllllIlIIllllIIlllllIlI = 0; llllllllllllllIlIIllllIIlllllIll > 0.5f; llllllllllllllIlIIllllIIlllllIll -= (float)(llllllllllllllIlIIllllIIllllllIl.nextInt(2) + 0.5), --llllllllllllllIlIIllllIIlllllIlI) {
            for (int llllllllllllllIlIIllllIIlllllIIl = MathHelper.floor(-llllllllllllllIlIIllllIIlllllIll); llllllllllllllIlIIllllIIlllllIIl <= MathHelper.ceil(llllllllllllllIlIIllllIIlllllIll); ++llllllllllllllIlIIllllIIlllllIIl) {
                for (int llllllllllllllIlIIllllIIlllllIII = MathHelper.floor(-llllllllllllllIlIIllllIIlllllIll); llllllllllllllIlIIllllIIlllllIII <= MathHelper.ceil(llllllllllllllIlIIllllIIlllllIll); ++llllllllllllllIlIIllllIIlllllIII) {
                    if (llllllllllllllIlIIllllIIlllllIIl * llllllllllllllIlIIllllIIlllllIIl + llllllllllllllIlIIllllIIlllllIII * llllllllllllllIlIIllllIIlllllIII <= (llllllllllllllIlIIllllIIlllllIll + 1.0f) * (llllllllllllllIlIIllllIIlllllIll + 1.0f)) {
                        this.setBlockAndNotifyAdequately(llllllllllllllIlIIllllIIlllllllI, llllllllllllllIlIIllllIIllllllII.add(llllllllllllllIlIIllllIIlllllIIl, llllllllllllllIlIIllllIIlllllIlI, llllllllllllllIlIIllllIIlllllIII), Blocks.END_STONE.getDefaultState());
                    }
                }
            }
        }
        return true;
    }
}
