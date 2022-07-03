package net.minecraft.world.gen.layer;

import net.minecraft.init.*;
import net.minecraft.world.biome.*;

public class GenLayerAddMushroomIsland extends GenLayer
{
    @Override
    public int[] getInts(final int llllllllllllllIlllIllllIllllllII, final int llllllllllllllIlllIllllIlllllIll, final int llllllllllllllIlllIllllIlllllIlI, final int llllllllllllllIlllIlllllIIIIlIll) {
        final int llllllllllllllIlllIlllllIIIIlIlI = llllllllllllllIlllIllllIllllllII - 1;
        final int llllllllllllllIlllIlllllIIIIlIIl = llllllllllllllIlllIllllIlllllIll - 1;
        final int llllllllllllllIlllIlllllIIIIlIII = llllllllllllllIlllIllllIlllllIlI + 2;
        final int llllllllllllllIlllIlllllIIIIIlll = llllllllllllllIlllIlllllIIIIlIll + 2;
        final int[] llllllllllllllIlllIlllllIIIIIllI = this.parent.getInts(llllllllllllllIlllIlllllIIIIlIlI, llllllllllllllIlllIlllllIIIIlIIl, llllllllllllllIlllIlllllIIIIlIII, llllllllllllllIlllIlllllIIIIIlll);
        final int[] llllllllllllllIlllIlllllIIIIIlIl = IntCache.getIntCache(llllllllllllllIlllIllllIlllllIlI * llllllllllllllIlllIlllllIIIIlIll);
        for (int llllllllllllllIlllIlllllIIIIIlII = 0; llllllllllllllIlllIlllllIIIIIlII < llllllllllllllIlllIlllllIIIIlIll; ++llllllllllllllIlllIlllllIIIIIlII) {
            for (int llllllllllllllIlllIlllllIIIIIIll = 0; llllllllllllllIlllIlllllIIIIIIll < llllllllllllllIlllIllllIlllllIlI; ++llllllllllllllIlllIlllllIIIIIIll) {
                final int llllllllllllllIlllIlllllIIIIIIlI = llllllllllllllIlllIlllllIIIIIllI[llllllllllllllIlllIlllllIIIIIIll + 0 + (llllllllllllllIlllIlllllIIIIIlII + 0) * llllllllllllllIlllIlllllIIIIlIII];
                final int llllllllllllllIlllIlllllIIIIIIIl = llllllllllllllIlllIlllllIIIIIllI[llllllllllllllIlllIlllllIIIIIIll + 2 + (llllllllllllllIlllIlllllIIIIIlII + 0) * llllllllllllllIlllIlllllIIIIlIII];
                final int llllllllllllllIlllIlllllIIIIIIII = llllllllllllllIlllIlllllIIIIIllI[llllllllllllllIlllIlllllIIIIIIll + 0 + (llllllllllllllIlllIlllllIIIIIlII + 2) * llllllllllllllIlllIlllllIIIIlIII];
                final int llllllllllllllIlllIllllIllllllll = llllllllllllllIlllIlllllIIIIIllI[llllllllllllllIlllIlllllIIIIIIll + 2 + (llllllllllllllIlllIlllllIIIIIlII + 2) * llllllllllllllIlllIlllllIIIIlIII];
                final int llllllllllllllIlllIllllIlllllllI = llllllllllllllIlllIlllllIIIIIllI[llllllllllllllIlllIlllllIIIIIIll + 1 + (llllllllllllllIlllIlllllIIIIIlII + 1) * llllllllllllllIlllIlllllIIIIlIII];
                this.initChunkSeed(llllllllllllllIlllIlllllIIIIIIll + llllllllllllllIlllIllllIllllllII, llllllllllllllIlllIlllllIIIIIlII + llllllllllllllIlllIllllIlllllIll);
                if (llllllllllllllIlllIllllIlllllllI == 0 && llllllllllllllIlllIlllllIIIIIIlI == 0 && llllllllllllllIlllIlllllIIIIIIIl == 0 && llllllllllllllIlllIlllllIIIIIIII == 0 && llllllllllllllIlllIllllIllllllll == 0 && this.nextInt(100) == 0) {
                    llllllllllllllIlllIlllllIIIIIlIl[llllllllllllllIlllIlllllIIIIIIll + llllllllllllllIlllIlllllIIIIIlII * llllllllllllllIlllIllllIlllllIlI] = Biome.getIdForBiome(Biomes.MUSHROOM_ISLAND);
                }
                else {
                    llllllllllllllIlllIlllllIIIIIlIl[llllllllllllllIlllIlllllIIIIIIll + llllllllllllllIlllIlllllIIIIIlII * llllllllllllllIlllIllllIlllllIlI] = llllllllllllllIlllIllllIlllllllI;
                }
            }
        }
        return llllllllllllllIlllIlllllIIIIIlIl;
    }
    
    public GenLayerAddMushroomIsland(final long llllllllllllllIlllIlllllIIlIIllI, final GenLayer llllllllllllllIlllIlllllIIlIIlIl) {
        super(llllllllllllllIlllIlllllIIlIIllI);
        this.parent = llllllllllllllIlllIlllllIIlIIlIl;
    }
}
