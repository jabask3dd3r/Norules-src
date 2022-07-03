package net.minecraft.world.gen.layer;

import net.minecraft.init.*;
import net.minecraft.world.biome.*;

public class GenLayerDeepOcean extends GenLayer
{
    public GenLayerDeepOcean(final long llllllllllllllIIlIllIlIlllIllIll, final GenLayer llllllllllllllIIlIllIlIlllIlIlll) {
        super(llllllllllllllIIlIllIlIlllIllIll);
        this.parent = llllllllllllllIIlIllIlIlllIlIlll;
    }
    
    @Override
    public int[] getInts(final int llllllllllllllIIlIllIlIlllIIIIlI, final int llllllllllllllIIlIllIlIlllIIIIIl, final int llllllllllllllIIlIllIlIllIlIllIl, final int llllllllllllllIIlIllIlIllIlIllII) {
        final int llllllllllllllIIlIllIlIllIlllllI = llllllllllllllIIlIllIlIlllIIIIlI - 1;
        final int llllllllllllllIIlIllIlIllIllllIl = llllllllllllllIIlIllIlIlllIIIIIl - 1;
        final int llllllllllllllIIlIllIlIllIllllII = llllllllllllllIIlIllIlIllIlIllIl + 2;
        final int llllllllllllllIIlIllIlIllIlllIll = llllllllllllllIIlIllIlIllIlIllII + 2;
        final int[] llllllllllllllIIlIllIlIllIlllIlI = this.parent.getInts(llllllllllllllIIlIllIlIllIlllllI, llllllllllllllIIlIllIlIllIllllIl, llllllllllllllIIlIllIlIllIllllII, llllllllllllllIIlIllIlIllIlllIll);
        final int[] llllllllllllllIIlIllIlIllIlllIIl = IntCache.getIntCache(llllllllllllllIIlIllIlIllIlIllIl * llllllllllllllIIlIllIlIllIlIllII);
        for (int llllllllllllllIIlIllIlIllIlllIII = 0; llllllllllllllIIlIllIlIllIlllIII < llllllllllllllIIlIllIlIllIlIllII; ++llllllllllllllIIlIllIlIllIlllIII) {
            for (int llllllllllllllIIlIllIlIllIllIlll = 0; llllllllllllllIIlIllIlIllIllIlll < llllllllllllllIIlIllIlIllIlIllIl; ++llllllllllllllIIlIllIlIllIllIlll) {
                final int llllllllllllllIIlIllIlIllIllIllI = llllllllllllllIIlIllIlIllIlllIlI[llllllllllllllIIlIllIlIllIllIlll + 1 + (llllllllllllllIIlIllIlIllIlllIII + 1 - 1) * (llllllllllllllIIlIllIlIllIlIllIl + 2)];
                final int llllllllllllllIIlIllIlIllIllIlIl = llllllllllllllIIlIllIlIllIlllIlI[llllllllllllllIIlIllIlIllIllIlll + 1 + 1 + (llllllllllllllIIlIllIlIllIlllIII + 1) * (llllllllllllllIIlIllIlIllIlIllIl + 2)];
                final int llllllllllllllIIlIllIlIllIllIlII = llllllllllllllIIlIllIlIllIlllIlI[llllllllllllllIIlIllIlIllIllIlll + 1 - 1 + (llllllllllllllIIlIllIlIllIlllIII + 1) * (llllllllllllllIIlIllIlIllIlIllIl + 2)];
                final int llllllllllllllIIlIllIlIllIllIIll = llllllllllllllIIlIllIlIllIlllIlI[llllllllllllllIIlIllIlIllIllIlll + 1 + (llllllllllllllIIlIllIlIllIlllIII + 1 + 1) * (llllllllllllllIIlIllIlIllIlIllIl + 2)];
                final int llllllllllllllIIlIllIlIllIllIIlI = llllllllllllllIIlIllIlIllIlllIlI[llllllllllllllIIlIllIlIllIllIlll + 1 + (llllllllllllllIIlIllIlIllIlllIII + 1) * llllllllllllllIIlIllIlIllIllllII];
                int llllllllllllllIIlIllIlIllIllIIIl = 0;
                if (llllllllllllllIIlIllIlIllIllIllI == 0) {
                    ++llllllllllllllIIlIllIlIllIllIIIl;
                }
                if (llllllllllllllIIlIllIlIllIllIlIl == 0) {
                    ++llllllllllllllIIlIllIlIllIllIIIl;
                }
                if (llllllllllllllIIlIllIlIllIllIlII == 0) {
                    ++llllllllllllllIIlIllIlIllIllIIIl;
                }
                if (llllllllllllllIIlIllIlIllIllIIll == 0) {
                    ++llllllllllllllIIlIllIlIllIllIIIl;
                }
                if (llllllllllllllIIlIllIlIllIllIIlI == 0 && llllllllllllllIIlIllIlIllIllIIIl > 3) {
                    llllllllllllllIIlIllIlIllIlllIIl[llllllllllllllIIlIllIlIllIllIlll + llllllllllllllIIlIllIlIllIlllIII * llllllllllllllIIlIllIlIllIlIllIl] = Biome.getIdForBiome(Biomes.DEEP_OCEAN);
                }
                else {
                    llllllllllllllIIlIllIlIllIlllIIl[llllllllllllllIIlIllIlIllIllIlll + llllllllllllllIIlIllIlIllIlllIII * llllllllllllllIIlIllIlIllIlIllIl] = llllllllllllllIIlIllIlIllIllIIlI;
                }
            }
        }
        return llllllllllllllIIlIllIlIllIlllIIl;
    }
}
