package net.minecraft.world.gen.layer;

import net.minecraft.init.*;
import net.minecraft.world.biome.*;

public class GenLayerRiver extends GenLayer
{
    private int riverFilter(final int lllllllllllllIllllIIlllIIlIIIIIl) {
        return (lllllllllllllIllllIIlllIIlIIIIIl >= 2) ? (2 + (lllllllllllllIllllIIlllIIlIIIIIl & 0x1)) : lllllllllllllIllllIIlllIIlIIIIIl;
    }
    
    public GenLayerRiver(final long lllllllllllllIllllIIlllIIllllllI, final GenLayer lllllllllllllIllllIIlllIIllllIlI) {
        super(lllllllllllllIllllIIlllIIllllllI);
        super.parent = lllllllllllllIllllIIlllIIllllIlI;
    }
    
    @Override
    public int[] getInts(final int lllllllllllllIllllIIlllIIllIIllI, final int lllllllllllllIllllIIlllIIlIlIIll, final int lllllllllllllIllllIIlllIIlIlIIlI, final int lllllllllllllIllllIIlllIIlIlIIIl) {
        final int lllllllllllllIllllIIlllIIllIIIlI = lllllllllllllIllllIIlllIIllIIllI - 1;
        final int lllllllllllllIllllIIlllIIllIIIIl = lllllllllllllIllllIIlllIIlIlIIll - 1;
        final int lllllllllllllIllllIIlllIIllIIIII = lllllllllllllIllllIIlllIIlIlIIlI + 2;
        final int lllllllllllllIllllIIlllIIlIlllll = lllllllllllllIllllIIlllIIlIlIIIl + 2;
        final int[] lllllllllllllIllllIIlllIIlIllllI = this.parent.getInts(lllllllllllllIllllIIlllIIllIIIlI, lllllllllllllIllllIIlllIIllIIIIl, lllllllllllllIllllIIlllIIllIIIII, lllllllllllllIllllIIlllIIlIlllll);
        final int[] lllllllllllllIllllIIlllIIlIlllIl = IntCache.getIntCache(lllllllllllllIllllIIlllIIlIlIIlI * lllllllllllllIllllIIlllIIlIlIIIl);
        for (int lllllllllllllIllllIIlllIIlIlllII = 0; lllllllllllllIllllIIlllIIlIlllII < lllllllllllllIllllIIlllIIlIlIIIl; ++lllllllllllllIllllIIlllIIlIlllII) {
            for (int lllllllllllllIllllIIlllIIlIllIll = 0; lllllllllllllIllllIIlllIIlIllIll < lllllllllllllIllllIIlllIIlIlIIlI; ++lllllllllllllIllllIIlllIIlIllIll) {
                final int lllllllllllllIllllIIlllIIlIllIlI = this.riverFilter(lllllllllllllIllllIIlllIIlIllllI[lllllllllllllIllllIIlllIIlIllIll + 0 + (lllllllllllllIllllIIlllIIlIlllII + 1) * lllllllllllllIllllIIlllIIllIIIII]);
                final int lllllllllllllIllllIIlllIIlIllIIl = this.riverFilter(lllllllllllllIllllIIlllIIlIllllI[lllllllllllllIllllIIlllIIlIllIll + 2 + (lllllllllllllIllllIIlllIIlIlllII + 1) * lllllllllllllIllllIIlllIIllIIIII]);
                final int lllllllllllllIllllIIlllIIlIllIII = this.riverFilter(lllllllllllllIllllIIlllIIlIllllI[lllllllllllllIllllIIlllIIlIllIll + 1 + (lllllllllllllIllllIIlllIIlIlllII + 0) * lllllllllllllIllllIIlllIIllIIIII]);
                final int lllllllllllllIllllIIlllIIlIlIlll = this.riverFilter(lllllllllllllIllllIIlllIIlIllllI[lllllllllllllIllllIIlllIIlIllIll + 1 + (lllllllllllllIllllIIlllIIlIlllII + 2) * lllllllllllllIllllIIlllIIllIIIII]);
                final int lllllllllllllIllllIIlllIIlIlIllI = this.riverFilter(lllllllllllllIllllIIlllIIlIllllI[lllllllllllllIllllIIlllIIlIllIll + 1 + (lllllllllllllIllllIIlllIIlIlllII + 1) * lllllllllllllIllllIIlllIIllIIIII]);
                if (lllllllllllllIllllIIlllIIlIlIllI == lllllllllllllIllllIIlllIIlIllIlI && lllllllllllllIllllIIlllIIlIlIllI == lllllllllllllIllllIIlllIIlIllIII && lllllllllllllIllllIIlllIIlIlIllI == lllllllllllllIllllIIlllIIlIllIIl && lllllllllllllIllllIIlllIIlIlIllI == lllllllllllllIllllIIlllIIlIlIlll) {
                    lllllllllllllIllllIIlllIIlIlllIl[lllllllllllllIllllIIlllIIlIllIll + lllllllllllllIllllIIlllIIlIlllII * lllllllllllllIllllIIlllIIlIlIIlI] = -1;
                }
                else {
                    lllllllllllllIllllIIlllIIlIlllIl[lllllllllllllIllllIIlllIIlIllIll + lllllllllllllIllllIIlllIIlIlllII * lllllllllllllIllllIIlllIIlIlIIlI] = Biome.getIdForBiome(Biomes.RIVER);
                }
            }
        }
        return lllllllllllllIllllIIlllIIlIlllIl;
    }
}
