package net.minecraft.world.gen.layer;

import net.minecraft.init.*;
import net.minecraft.world.biome.*;

public class GenLayerBiomeEdge extends GenLayer
{
    private boolean replaceBiomeEdgeIfNecessary(final int[] llllllllllllllIIllIIlIIlIlIIlllI, final int[] llllllllllllllIIllIIlIIlIlIIllIl, final int llllllllllllllIIllIIlIIlIlIllIIl, final int llllllllllllllIIllIIlIIlIlIllIII, final int llllllllllllllIIllIIlIIlIlIIlIlI, final int llllllllllllllIIllIIlIIlIlIlIllI, final int llllllllllllllIIllIIlIIlIlIlIlIl, final int llllllllllllllIIllIIlIIlIlIIIlll) {
        if (!GenLayer.biomesEqualOrMesaPlateau(llllllllllllllIIllIIlIIlIlIlIllI, llllllllllllllIIllIIlIIlIlIlIlIl)) {
            return false;
        }
        final int llllllllllllllIIllIIlIIlIlIlIIll = llllllllllllllIIllIIlIIlIlIIlllI[llllllllllllllIIllIIlIIlIlIllIIl + 1 + (llllllllllllllIIllIIlIIlIlIllIII + 1 - 1) * (llllllllllllllIIllIIlIIlIlIIlIlI + 2)];
        final int llllllllllllllIIllIIlIIlIlIlIIlI = llllllllllllllIIllIIlIIlIlIIlllI[llllllllllllllIIllIIlIIlIlIllIIl + 1 + 1 + (llllllllllllllIIllIIlIIlIlIllIII + 1) * (llllllllllllllIIllIIlIIlIlIIlIlI + 2)];
        final int llllllllllllllIIllIIlIIlIlIlIIIl = llllllllllllllIIllIIlIIlIlIIlllI[llllllllllllllIIllIIlIIlIlIllIIl + 1 - 1 + (llllllllllllllIIllIIlIIlIlIllIII + 1) * (llllllllllllllIIllIIlIIlIlIIlIlI + 2)];
        final int llllllllllllllIIllIIlIIlIlIlIIII = llllllllllllllIIllIIlIIlIlIIlllI[llllllllllllllIIllIIlIIlIlIllIIl + 1 + (llllllllllllllIIllIIlIIlIlIllIII + 1 + 1) * (llllllllllllllIIllIIlIIlIlIIlIlI + 2)];
        if (this.canBiomesBeNeighbors(llllllllllllllIIllIIlIIlIlIlIIll, llllllllllllllIIllIIlIIlIlIlIlIl) && this.canBiomesBeNeighbors(llllllllllllllIIllIIlIIlIlIlIIlI, llllllllllllllIIllIIlIIlIlIlIlIl) && this.canBiomesBeNeighbors(llllllllllllllIIllIIlIIlIlIlIIIl, llllllllllllllIIllIIlIIlIlIlIlIl) && this.canBiomesBeNeighbors(llllllllllllllIIllIIlIIlIlIlIIII, llllllllllllllIIllIIlIIlIlIlIlIl)) {
            llllllllllllllIIllIIlIIlIlIIllIl[llllllllllllllIIllIIlIIlIlIllIIl + llllllllllllllIIllIIlIIlIlIllIII * llllllllllllllIIllIIlIIlIlIIlIlI] = llllllllllllllIIllIIlIIlIlIlIllI;
        }
        else {
            llllllllllllllIIllIIlIIlIlIIllIl[llllllllllllllIIllIIlIIlIlIllIIl + llllllllllllllIIllIIlIIlIlIllIII * llllllllllllllIIllIIlIIlIlIIlIlI] = llllllllllllllIIllIIlIIlIlIIIlll;
        }
        return true;
    }
    
    public GenLayerBiomeEdge(final long llllllllllllllIIllIIlIIllIIlllII, final GenLayer llllllllllllllIIllIIlIIllIIllIII) {
        super(llllllllllllllIIllIIlIIllIIlllII);
        this.parent = llllllllllllllIIllIIlIIllIIllIII;
    }
    
    private boolean replaceBiomeEdge(final int[] llllllllllllllIIllIIlIIlIIllIlIl, final int[] llllllllllllllIIllIIlIIlIIlIlIII, final int llllllllllllllIIllIIlIIlIIllIIll, final int llllllllllllllIIllIIlIIlIIlIIllI, final int llllllllllllllIIllIIlIIlIIllIIIl, final int llllllllllllllIIllIIlIIlIIlIIlII, final int llllllllllllllIIllIIlIIlIIlIIIll, final int llllllllllllllIIllIIlIIlIIlIlllI) {
        if (llllllllllllllIIllIIlIIlIIlIIlII != llllllllllllllIIllIIlIIlIIlIIIll) {
            return false;
        }
        final int llllllllllllllIIllIIlIIlIIlIllIl = llllllllllllllIIllIIlIIlIIllIlIl[llllllllllllllIIllIIlIIlIIllIIll + 1 + (llllllllllllllIIllIIlIIlIIlIIllI + 1 - 1) * (llllllllllllllIIllIIlIIlIIllIIIl + 2)];
        final int llllllllllllllIIllIIlIIlIIlIllII = llllllllllllllIIllIIlIIlIIllIlIl[llllllllllllllIIllIIlIIlIIllIIll + 1 + 1 + (llllllllllllllIIllIIlIIlIIlIIllI + 1) * (llllllllllllllIIllIIlIIlIIllIIIl + 2)];
        final int llllllllllllllIIllIIlIIlIIlIlIll = llllllllllllllIIllIIlIIlIIllIlIl[llllllllllllllIIllIIlIIlIIllIIll + 1 - 1 + (llllllllllllllIIllIIlIIlIIlIIllI + 1) * (llllllllllllllIIllIIlIIlIIllIIIl + 2)];
        final int llllllllllllllIIllIIlIIlIIlIlIlI = llllllllllllllIIllIIlIIlIIllIlIl[llllllllllllllIIllIIlIIlIIllIIll + 1 + (llllllllllllllIIllIIlIIlIIlIIllI + 1 + 1) * (llllllllllllllIIllIIlIIlIIllIIIl + 2)];
        if (GenLayer.biomesEqualOrMesaPlateau(llllllllllllllIIllIIlIIlIIlIllIl, llllllllllllllIIllIIlIIlIIlIIIll) && GenLayer.biomesEqualOrMesaPlateau(llllllllllllllIIllIIlIIlIIlIllII, llllllllllllllIIllIIlIIlIIlIIIll) && GenLayer.biomesEqualOrMesaPlateau(llllllllllllllIIllIIlIIlIIlIlIll, llllllllllllllIIllIIlIIlIIlIIIll) && GenLayer.biomesEqualOrMesaPlateau(llllllllllllllIIllIIlIIlIIlIlIlI, llllllllllllllIIllIIlIIlIIlIIIll)) {
            llllllllllllllIIllIIlIIlIIlIlIII[llllllllllllllIIllIIlIIlIIllIIll + llllllllllllllIIllIIlIIlIIlIIllI * llllllllllllllIIllIIlIIlIIllIIIl] = llllllllllllllIIllIIlIIlIIlIIlII;
        }
        else {
            llllllllllllllIIllIIlIIlIIlIlIII[llllllllllllllIIllIIlIIlIIllIIll + llllllllllllllIIllIIlIIlIIlIIllI * llllllllllllllIIllIIlIIlIIllIIIl] = llllllllllllllIIllIIlIIlIIlIlllI;
        }
        return true;
    }
    
    @Override
    public int[] getInts(final int llllllllllllllIIllIIlIIllIIIlIII, final int llllllllllllllIIllIIlIIlIlllIlIl, final int llllllllllllllIIllIIlIIlIlllIlII, final int llllllllllllllIIllIIlIIllIIIIlIl) {
        final int[] llllllllllllllIIllIIlIIllIIIIlII = this.parent.getInts(llllllllllllllIIllIIlIIllIIIlIII - 1, llllllllllllllIIllIIlIIlIlllIlIl - 1, llllllllllllllIIllIIlIIlIlllIlII + 2, llllllllllllllIIllIIlIIllIIIIlIl + 2);
        final int[] llllllllllllllIIllIIlIIllIIIIIll = IntCache.getIntCache(llllllllllllllIIllIIlIIlIlllIlII * llllllllllllllIIllIIlIIllIIIIlIl);
        for (int llllllllllllllIIllIIlIIllIIIIIlI = 0; llllllllllllllIIllIIlIIllIIIIIlI < llllllllllllllIIllIIlIIllIIIIlIl; ++llllllllllllllIIllIIlIIllIIIIIlI) {
            for (int llllllllllllllIIllIIlIIllIIIIIIl = 0; llllllllllllllIIllIIlIIllIIIIIIl < llllllllllllllIIllIIlIIlIlllIlII; ++llllllllllllllIIllIIlIIllIIIIIIl) {
                this.initChunkSeed(llllllllllllllIIllIIlIIllIIIIIIl + llllllllllllllIIllIIlIIllIIIlIII, llllllllllllllIIllIIlIIllIIIIIlI + llllllllllllllIIllIIlIIlIlllIlIl);
                final int llllllllllllllIIllIIlIIllIIIIIII = llllllllllllllIIllIIlIIllIIIIlII[llllllllllllllIIllIIlIIllIIIIIIl + 1 + (llllllllllllllIIllIIlIIllIIIIIlI + 1) * (llllllllllllllIIllIIlIIlIlllIlII + 2)];
                if (!this.replaceBiomeEdgeIfNecessary(llllllllllllllIIllIIlIIllIIIIlII, llllllllllllllIIllIIlIIllIIIIIll, llllllllllllllIIllIIlIIllIIIIIIl, llllllllllllllIIllIIlIIllIIIIIlI, llllllllllllllIIllIIlIIlIlllIlII, llllllllllllllIIllIIlIIllIIIIIII, Biome.getIdForBiome(Biomes.EXTREME_HILLS), Biome.getIdForBiome(Biomes.EXTREME_HILLS_EDGE)) && !this.replaceBiomeEdge(llllllllllllllIIllIIlIIllIIIIlII, llllllllllllllIIllIIlIIllIIIIIll, llllllllllllllIIllIIlIIllIIIIIIl, llllllllllllllIIllIIlIIllIIIIIlI, llllllllllllllIIllIIlIIlIlllIlII, llllllllllllllIIllIIlIIllIIIIIII, Biome.getIdForBiome(Biomes.MESA_ROCK), Biome.getIdForBiome(Biomes.MESA)) && !this.replaceBiomeEdge(llllllllllllllIIllIIlIIllIIIIlII, llllllllllllllIIllIIlIIllIIIIIll, llllllllllllllIIllIIlIIllIIIIIIl, llllllllllllllIIllIIlIIllIIIIIlI, llllllllllllllIIllIIlIIlIlllIlII, llllllllllllllIIllIIlIIllIIIIIII, Biome.getIdForBiome(Biomes.MESA_CLEAR_ROCK), Biome.getIdForBiome(Biomes.MESA)) && !this.replaceBiomeEdge(llllllllllllllIIllIIlIIllIIIIlII, llllllllllllllIIllIIlIIllIIIIIll, llllllllllllllIIllIIlIIllIIIIIIl, llllllllllllllIIllIIlIIllIIIIIlI, llllllllllllllIIllIIlIIlIlllIlII, llllllllllllllIIllIIlIIllIIIIIII, Biome.getIdForBiome(Biomes.REDWOOD_TAIGA), Biome.getIdForBiome(Biomes.TAIGA))) {
                    if (llllllllllllllIIllIIlIIllIIIIIII == Biome.getIdForBiome(Biomes.DESERT)) {
                        final int llllllllllllllIIllIIlIIlIlllllll = llllllllllllllIIllIIlIIllIIIIlII[llllllllllllllIIllIIlIIllIIIIIIl + 1 + (llllllllllllllIIllIIlIIllIIIIIlI + 1 - 1) * (llllllllllllllIIllIIlIIlIlllIlII + 2)];
                        final int llllllllllllllIIllIIlIIlIllllllI = llllllllllllllIIllIIlIIllIIIIlII[llllllllllllllIIllIIlIIllIIIIIIl + 1 + 1 + (llllllllllllllIIllIIlIIllIIIIIlI + 1) * (llllllllllllllIIllIIlIIlIlllIlII + 2)];
                        final int llllllllllllllIIllIIlIIlIlllllIl = llllllllllllllIIllIIlIIllIIIIlII[llllllllllllllIIllIIlIIllIIIIIIl + 1 - 1 + (llllllllllllllIIllIIlIIllIIIIIlI + 1) * (llllllllllllllIIllIIlIIlIlllIlII + 2)];
                        final int llllllllllllllIIllIIlIIlIlllllII = llllllllllllllIIllIIlIIllIIIIlII[llllllllllllllIIllIIlIIllIIIIIIl + 1 + (llllllllllllllIIllIIlIIllIIIIIlI + 1 + 1) * (llllllllllllllIIllIIlIIlIlllIlII + 2)];
                        if (llllllllllllllIIllIIlIIlIlllllll != Biome.getIdForBiome(Biomes.ICE_PLAINS) && llllllllllllllIIllIIlIIlIllllllI != Biome.getIdForBiome(Biomes.ICE_PLAINS) && llllllllllllllIIllIIlIIlIlllllIl != Biome.getIdForBiome(Biomes.ICE_PLAINS) && llllllllllllllIIllIIlIIlIlllllII != Biome.getIdForBiome(Biomes.ICE_PLAINS)) {
                            llllllllllllllIIllIIlIIllIIIIIll[llllllllllllllIIllIIlIIllIIIIIIl + llllllllllllllIIllIIlIIllIIIIIlI * llllllllllllllIIllIIlIIlIlllIlII] = llllllllllllllIIllIIlIIllIIIIIII;
                        }
                        else {
                            llllllllllllllIIllIIlIIllIIIIIll[llllllllllllllIIllIIlIIllIIIIIIl + llllllllllllllIIllIIlIIllIIIIIlI * llllllllllllllIIllIIlIIlIlllIlII] = Biome.getIdForBiome(Biomes.EXTREME_HILLS_WITH_TREES);
                        }
                    }
                    else if (llllllllllllllIIllIIlIIllIIIIIII == Biome.getIdForBiome(Biomes.SWAMPLAND)) {
                        final int llllllllllllllIIllIIlIIlIllllIll = llllllllllllllIIllIIlIIllIIIIlII[llllllllllllllIIllIIlIIllIIIIIIl + 1 + (llllllllllllllIIllIIlIIllIIIIIlI + 1 - 1) * (llllllllllllllIIllIIlIIlIlllIlII + 2)];
                        final int llllllllllllllIIllIIlIIlIllllIlI = llllllllllllllIIllIIlIIllIIIIlII[llllllllllllllIIllIIlIIllIIIIIIl + 1 + 1 + (llllllllllllllIIllIIlIIllIIIIIlI + 1) * (llllllllllllllIIllIIlIIlIlllIlII + 2)];
                        final int llllllllllllllIIllIIlIIlIllllIIl = llllllllllllllIIllIIlIIllIIIIlII[llllllllllllllIIllIIlIIllIIIIIIl + 1 - 1 + (llllllllllllllIIllIIlIIllIIIIIlI + 1) * (llllllllllllllIIllIIlIIlIlllIlII + 2)];
                        final int llllllllllllllIIllIIlIIlIllllIII = llllllllllllllIIllIIlIIllIIIIlII[llllllllllllllIIllIIlIIllIIIIIIl + 1 + (llllllllllllllIIllIIlIIllIIIIIlI + 1 + 1) * (llllllllllllllIIllIIlIIlIlllIlII + 2)];
                        if (llllllllllllllIIllIIlIIlIllllIll != Biome.getIdForBiome(Biomes.DESERT) && llllllllllllllIIllIIlIIlIllllIlI != Biome.getIdForBiome(Biomes.DESERT) && llllllllllllllIIllIIlIIlIllllIIl != Biome.getIdForBiome(Biomes.DESERT) && llllllllllllllIIllIIlIIlIllllIII != Biome.getIdForBiome(Biomes.DESERT) && llllllllllllllIIllIIlIIlIllllIll != Biome.getIdForBiome(Biomes.COLD_TAIGA) && llllllllllllllIIllIIlIIlIllllIlI != Biome.getIdForBiome(Biomes.COLD_TAIGA) && llllllllllllllIIllIIlIIlIllllIIl != Biome.getIdForBiome(Biomes.COLD_TAIGA) && llllllllllllllIIllIIlIIlIllllIII != Biome.getIdForBiome(Biomes.COLD_TAIGA) && llllllllllllllIIllIIlIIlIllllIll != Biome.getIdForBiome(Biomes.ICE_PLAINS) && llllllllllllllIIllIIlIIlIllllIlI != Biome.getIdForBiome(Biomes.ICE_PLAINS) && llllllllllllllIIllIIlIIlIllllIIl != Biome.getIdForBiome(Biomes.ICE_PLAINS) && llllllllllllllIIllIIlIIlIllllIII != Biome.getIdForBiome(Biomes.ICE_PLAINS)) {
                            if (llllllllllllllIIllIIlIIlIllllIll != Biome.getIdForBiome(Biomes.JUNGLE) && llllllllllllllIIllIIlIIlIllllIII != Biome.getIdForBiome(Biomes.JUNGLE) && llllllllllllllIIllIIlIIlIllllIlI != Biome.getIdForBiome(Biomes.JUNGLE) && llllllllllllllIIllIIlIIlIllllIIl != Biome.getIdForBiome(Biomes.JUNGLE)) {
                                llllllllllllllIIllIIlIIllIIIIIll[llllllllllllllIIllIIlIIllIIIIIIl + llllllllllllllIIllIIlIIllIIIIIlI * llllllllllllllIIllIIlIIlIlllIlII] = llllllllllllllIIllIIlIIllIIIIIII;
                            }
                            else {
                                llllllllllllllIIllIIlIIllIIIIIll[llllllllllllllIIllIIlIIllIIIIIIl + llllllllllllllIIllIIlIIllIIIIIlI * llllllllllllllIIllIIlIIlIlllIlII] = Biome.getIdForBiome(Biomes.JUNGLE_EDGE);
                            }
                        }
                        else {
                            llllllllllllllIIllIIlIIllIIIIIll[llllllllllllllIIllIIlIIllIIIIIIl + llllllllllllllIIllIIlIIllIIIIIlI * llllllllllllllIIllIIlIIlIlllIlII] = Biome.getIdForBiome(Biomes.PLAINS);
                        }
                    }
                    else {
                        llllllllllllllIIllIIlIIllIIIIIll[llllllllllllllIIllIIlIIllIIIIIIl + llllllllllllllIIllIIlIIllIIIIIlI * llllllllllllllIIllIIlIIlIlllIlII] = llllllllllllllIIllIIlIIllIIIIIII;
                    }
                }
            }
        }
        return llllllllllllllIIllIIlIIllIIIIIll;
    }
    
    private boolean canBiomesBeNeighbors(final int llllllllllllllIIllIIlIIlIIIlIllI, final int llllllllllllllIIllIIlIIlIIIlIlIl) {
        if (GenLayer.biomesEqualOrMesaPlateau(llllllllllllllIIllIIlIIlIIIlIllI, llllllllllllllIIllIIlIIlIIIlIlIl)) {
            return true;
        }
        final Biome llllllllllllllIIllIIlIIlIIIlIlII = Biome.getBiome(llllllllllllllIIllIIlIIlIIIlIllI);
        final Biome llllllllllllllIIllIIlIIlIIIlIIll = Biome.getBiome(llllllllllllllIIllIIlIIlIIIlIlIl);
        if (llllllllllllllIIllIIlIIlIIIlIlII != null && llllllllllllllIIllIIlIIlIIIlIIll != null) {
            final Biome.TempCategory llllllllllllllIIllIIlIIlIIIlIIlI = llllllllllllllIIllIIlIIlIIIlIlII.getTempCategory();
            final Biome.TempCategory llllllllllllllIIllIIlIIlIIIlIIIl = llllllllllllllIIllIIlIIlIIIlIIll.getTempCategory();
            return llllllllllllllIIllIIlIIlIIIlIIlI == llllllllllllllIIllIIlIIlIIIlIIIl || llllllllllllllIIllIIlIIlIIIlIIlI == Biome.TempCategory.MEDIUM || llllllllllllllIIllIIlIIlIIIlIIIl == Biome.TempCategory.MEDIUM;
        }
        return false;
    }
}
