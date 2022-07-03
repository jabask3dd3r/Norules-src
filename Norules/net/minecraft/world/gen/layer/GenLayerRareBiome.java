package net.minecraft.world.gen.layer;

import net.minecraft.init.*;
import net.minecraft.world.biome.*;

public class GenLayerRareBiome extends GenLayer
{
    public GenLayerRareBiome(final long llllllllllllllllIIIIIIIlIlIlIlll, final GenLayer llllllllllllllllIIIIIIIlIlIlIIll) {
        super(llllllllllllllllIIIIIIIlIlIlIlll);
        this.parent = llllllllllllllllIIIIIIIlIlIlIIll;
    }
    
    @Override
    public int[] getInts(final int llllllllllllllllIIIIIIIlIlIIIlll, final int llllllllllllllllIIIIIIIlIIlllIIl, final int llllllllllllllllIIIIIIIlIIlllIII, final int llllllllllllllllIIIIIIIlIlIIIlII) {
        final int[] llllllllllllllllIIIIIIIlIlIIIIll = this.parent.getInts(llllllllllllllllIIIIIIIlIlIIIlll - 1, llllllllllllllllIIIIIIIlIIlllIIl - 1, llllllllllllllllIIIIIIIlIIlllIII + 2, llllllllllllllllIIIIIIIlIlIIIlII + 2);
        final int[] llllllllllllllllIIIIIIIlIlIIIIlI = IntCache.getIntCache(llllllllllllllllIIIIIIIlIIlllIII * llllllllllllllllIIIIIIIlIlIIIlII);
        for (int llllllllllllllllIIIIIIIlIlIIIIII = 0; llllllllllllllllIIIIIIIlIlIIIIII < llllllllllllllllIIIIIIIlIlIIIlII; ++llllllllllllllllIIIIIIIlIlIIIIII) {
            for (int llllllllllllllllIIIIIIIlIIllllll = 0; llllllllllllllllIIIIIIIlIIllllll < llllllllllllllllIIIIIIIlIIlllIII; ++llllllllllllllllIIIIIIIlIIllllll) {
                this.initChunkSeed(llllllllllllllllIIIIIIIlIIllllll + llllllllllllllllIIIIIIIlIlIIIlll, llllllllllllllllIIIIIIIlIlIIIIII + llllllllllllllllIIIIIIIlIIlllIIl);
                final int llllllllllllllllIIIIIIIlIIllllIl = llllllllllllllllIIIIIIIlIlIIIIll[llllllllllllllllIIIIIIIlIIllllll + 1 + (llllllllllllllllIIIIIIIlIlIIIIII + 1) * (llllllllllllllllIIIIIIIlIIlllIII + 2)];
                if (this.nextInt(57) == 0) {
                    if (llllllllllllllllIIIIIIIlIIllllIl == Biome.getIdForBiome(Biomes.PLAINS)) {
                        llllllllllllllllIIIIIIIlIlIIIIlI[llllllllllllllllIIIIIIIlIIllllll + llllllllllllllllIIIIIIIlIlIIIIII * llllllllllllllllIIIIIIIlIIlllIII] = Biome.getIdForBiome(Biomes.MUTATED_PLAINS);
                    }
                    else {
                        llllllllllllllllIIIIIIIlIlIIIIlI[llllllllllllllllIIIIIIIlIIllllll + llllllllllllllllIIIIIIIlIlIIIIII * llllllllllllllllIIIIIIIlIIlllIII] = llllllllllllllllIIIIIIIlIIllllIl;
                    }
                }
                else {
                    llllllllllllllllIIIIIIIlIlIIIIlI[llllllllllllllllIIIIIIIlIIllllll + llllllllllllllllIIIIIIIlIlIIIIII * llllllllllllllllIIIIIIIlIIlllIII] = llllllllllllllllIIIIIIIlIIllllIl;
                }
            }
        }
        return llllllllllllllllIIIIIIIlIlIIIIlI;
    }
}
