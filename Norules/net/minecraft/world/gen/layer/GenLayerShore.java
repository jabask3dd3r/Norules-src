package net.minecraft.world.gen.layer;

import net.minecraft.world.biome.*;
import net.minecraft.init.*;

public class GenLayerShore extends GenLayer
{
    private boolean isMesa(final int lllllllllllllllIllIIIIlllIlIlllI) {
        return Biome.getBiome(lllllllllllllllIllIIIIlllIlIlllI) instanceof BiomeMesa;
    }
    
    private boolean isJungleCompatible(final int lllllllllllllllIllIIIIlllIllIIlI) {
        return (Biome.getBiome(lllllllllllllllIllIIIIlllIllIIlI) != null && Biome.getBiome(lllllllllllllllIllIIIIlllIllIIlI).getBiomeClass() == BiomeJungle.class) || lllllllllllllllIllIIIIlllIllIIlI == Biome.getIdForBiome(Biomes.JUNGLE_EDGE) || lllllllllllllllIllIIIIlllIllIIlI == Biome.getIdForBiome(Biomes.JUNGLE) || lllllllllllllllIllIIIIlllIllIIlI == Biome.getIdForBiome(Biomes.JUNGLE_HILLS) || lllllllllllllllIllIIIIlllIllIIlI == Biome.getIdForBiome(Biomes.FOREST) || lllllllllllllllIllIIIIlllIllIIlI == Biome.getIdForBiome(Biomes.TAIGA) || GenLayer.isBiomeOceanic(lllllllllllllllIllIIIIlllIllIIlI);
    }
    
    public GenLayerShore(final long lllllllllllllllIllIIIlIIIIIlIlIl, final GenLayer lllllllllllllllIllIIIlIIIIIlIlII) {
        super(lllllllllllllllIllIIIlIIIIIlIlIl);
        this.parent = lllllllllllllllIllIIIlIIIIIlIlII;
    }
    
    private void replaceIfNeighborOcean(final int[] lllllllllllllllIllIIIIllllIIlIll, final int[] lllllllllllllllIllIIIIllllIIlIlI, final int lllllllllllllllIllIIIIlllIlllllI, final int lllllllllllllllIllIIIIllllIIlIII, final int lllllllllllllllIllIIIIlllIllllII, final int lllllllllllllllIllIIIIlllIlllIll, final int lllllllllllllllIllIIIIllllIIIlIl) {
        if (GenLayer.isBiomeOceanic(lllllllllllllllIllIIIIlllIlllIll)) {
            lllllllllllllllIllIIIIllllIIlIlI[lllllllllllllllIllIIIIlllIlllllI + lllllllllllllllIllIIIIllllIIlIII * lllllllllllllllIllIIIIlllIllllII] = lllllllllllllllIllIIIIlllIlllIll;
        }
        else {
            final int lllllllllllllllIllIIIIllllIIIlII = lllllllllllllllIllIIIIllllIIlIll[lllllllllllllllIllIIIIlllIlllllI + 1 + (lllllllllllllllIllIIIIllllIIlIII + 1 - 1) * (lllllllllllllllIllIIIIlllIllllII + 2)];
            final int lllllllllllllllIllIIIIllllIIIIll = lllllllllllllllIllIIIIllllIIlIll[lllllllllllllllIllIIIIlllIlllllI + 1 + 1 + (lllllllllllllllIllIIIIllllIIlIII + 1) * (lllllllllllllllIllIIIIlllIllllII + 2)];
            final int lllllllllllllllIllIIIIllllIIIIlI = lllllllllllllllIllIIIIllllIIlIll[lllllllllllllllIllIIIIlllIlllllI + 1 - 1 + (lllllllllllllllIllIIIIllllIIlIII + 1) * (lllllllllllllllIllIIIIlllIllllII + 2)];
            final int lllllllllllllllIllIIIIllllIIIIIl = lllllllllllllllIllIIIIllllIIlIll[lllllllllllllllIllIIIIlllIlllllI + 1 + (lllllllllllllllIllIIIIllllIIlIII + 1 + 1) * (lllllllllllllllIllIIIIlllIllllII + 2)];
            if (!GenLayer.isBiomeOceanic(lllllllllllllllIllIIIIllllIIIlII) && !GenLayer.isBiomeOceanic(lllllllllllllllIllIIIIllllIIIIll) && !GenLayer.isBiomeOceanic(lllllllllllllllIllIIIIllllIIIIlI) && !GenLayer.isBiomeOceanic(lllllllllllllllIllIIIIllllIIIIIl)) {
                lllllllllllllllIllIIIIllllIIlIlI[lllllllllllllllIllIIIIlllIlllllI + lllllllllllllllIllIIIIllllIIlIII * lllllllllllllllIllIIIIlllIllllII] = lllllllllllllllIllIIIIlllIlllIll;
            }
            else {
                lllllllllllllllIllIIIIllllIIlIlI[lllllllllllllllIllIIIIlllIlllllI + lllllllllllllllIllIIIIllllIIlIII * lllllllllllllllIllIIIIlllIllllII] = lllllllllllllllIllIIIIllllIIIlIl;
            }
        }
    }
    
    @Override
    public int[] getInts(final int lllllllllllllllIllIIIlIIIIIIIIII, final int lllllllllllllllIllIIIIllllllllll, final int lllllllllllllllIllIIIIlllllllllI, final int lllllllllllllllIllIIIIllllllllIl) {
        final int[] lllllllllllllllIllIIIIllllllllII = this.parent.getInts(lllllllllllllllIllIIIlIIIIIIIIII - 1, lllllllllllllllIllIIIIllllllllll - 1, lllllllllllllllIllIIIIlllllllllI + 2, lllllllllllllllIllIIIIllllllllIl + 2);
        final int[] lllllllllllllllIllIIIIlllllllIll = IntCache.getIntCache(lllllllllllllllIllIIIIlllllllllI * lllllllllllllllIllIIIIllllllllIl);
        for (int lllllllllllllllIllIIIIlllllllIlI = 0; lllllllllllllllIllIIIIlllllllIlI < lllllllllllllllIllIIIIllllllllIl; ++lllllllllllllllIllIIIIlllllllIlI) {
            for (int lllllllllllllllIllIIIIlllllllIIl = 0; lllllllllllllllIllIIIIlllllllIIl < lllllllllllllllIllIIIIlllllllllI; ++lllllllllllllllIllIIIIlllllllIIl) {
                this.initChunkSeed(lllllllllllllllIllIIIIlllllllIIl + lllllllllllllllIllIIIlIIIIIIIIII, lllllllllllllllIllIIIIlllllllIlI + lllllllllllllllIllIIIIllllllllll);
                final int lllllllllllllllIllIIIIlllllllIII = lllllllllllllllIllIIIIllllllllII[lllllllllllllllIllIIIIlllllllIIl + 1 + (lllllllllllllllIllIIIIlllllllIlI + 1) * (lllllllllllllllIllIIIIlllllllllI + 2)];
                final Biome lllllllllllllllIllIIIIllllllIlll = Biome.getBiome(lllllllllllllllIllIIIIlllllllIII);
                if (lllllllllllllllIllIIIIlllllllIII == Biome.getIdForBiome(Biomes.MUSHROOM_ISLAND)) {
                    final int lllllllllllllllIllIIIIllllllIllI = lllllllllllllllIllIIIIllllllllII[lllllllllllllllIllIIIIlllllllIIl + 1 + (lllllllllllllllIllIIIIlllllllIlI + 1 - 1) * (lllllllllllllllIllIIIIlllllllllI + 2)];
                    final int lllllllllllllllIllIIIIllllllIlIl = lllllllllllllllIllIIIIllllllllII[lllllllllllllllIllIIIIlllllllIIl + 1 + 1 + (lllllllllllllllIllIIIIlllllllIlI + 1) * (lllllllllllllllIllIIIIlllllllllI + 2)];
                    final int lllllllllllllllIllIIIIllllllIlII = lllllllllllllllIllIIIIllllllllII[lllllllllllllllIllIIIIlllllllIIl + 1 - 1 + (lllllllllllllllIllIIIIlllllllIlI + 1) * (lllllllllllllllIllIIIIlllllllllI + 2)];
                    final int lllllllllllllllIllIIIIllllllIIll = lllllllllllllllIllIIIIllllllllII[lllllllllllllllIllIIIIlllllllIIl + 1 + (lllllllllllllllIllIIIIlllllllIlI + 1 + 1) * (lllllllllllllllIllIIIIlllllllllI + 2)];
                    if (lllllllllllllllIllIIIIllllllIllI != Biome.getIdForBiome(Biomes.OCEAN) && lllllllllllllllIllIIIIllllllIlIl != Biome.getIdForBiome(Biomes.OCEAN) && lllllllllllllllIllIIIIllllllIlII != Biome.getIdForBiome(Biomes.OCEAN) && lllllllllllllllIllIIIIllllllIIll != Biome.getIdForBiome(Biomes.OCEAN)) {
                        lllllllllllllllIllIIIIlllllllIll[lllllllllllllllIllIIIIlllllllIIl + lllllllllllllllIllIIIIlllllllIlI * lllllllllllllllIllIIIIlllllllllI] = lllllllllllllllIllIIIIlllllllIII;
                    }
                    else {
                        lllllllllllllllIllIIIIlllllllIll[lllllllllllllllIllIIIIlllllllIIl + lllllllllllllllIllIIIIlllllllIlI * lllllllllllllllIllIIIIlllllllllI] = Biome.getIdForBiome(Biomes.MUSHROOM_ISLAND_SHORE);
                    }
                }
                else if (lllllllllllllllIllIIIIllllllIlll != null && lllllllllllllllIllIIIIllllllIlll.getBiomeClass() == BiomeJungle.class) {
                    final int lllllllllllllllIllIIIIllllllIIlI = lllllllllllllllIllIIIIllllllllII[lllllllllllllllIllIIIIlllllllIIl + 1 + (lllllllllllllllIllIIIIlllllllIlI + 1 - 1) * (lllllllllllllllIllIIIIlllllllllI + 2)];
                    final int lllllllllllllllIllIIIIllllllIIIl = lllllllllllllllIllIIIIllllllllII[lllllllllllllllIllIIIIlllllllIIl + 1 + 1 + (lllllllllllllllIllIIIIlllllllIlI + 1) * (lllllllllllllllIllIIIIlllllllllI + 2)];
                    final int lllllllllllllllIllIIIIllllllIIII = lllllllllllllllIllIIIIllllllllII[lllllllllllllllIllIIIIlllllllIIl + 1 - 1 + (lllllllllllllllIllIIIIlllllllIlI + 1) * (lllllllllllllllIllIIIIlllllllllI + 2)];
                    final int lllllllllllllllIllIIIIlllllIllll = lllllllllllllllIllIIIIllllllllII[lllllllllllllllIllIIIIlllllllIIl + 1 + (lllllllllllllllIllIIIIlllllllIlI + 1 + 1) * (lllllllllllllllIllIIIIlllllllllI + 2)];
                    if (this.isJungleCompatible(lllllllllllllllIllIIIIllllllIIlI) && this.isJungleCompatible(lllllllllllllllIllIIIIllllllIIIl) && this.isJungleCompatible(lllllllllllllllIllIIIIllllllIIII) && this.isJungleCompatible(lllllllllllllllIllIIIIlllllIllll)) {
                        if (!GenLayer.isBiomeOceanic(lllllllllllllllIllIIIIllllllIIlI) && !GenLayer.isBiomeOceanic(lllllllllllllllIllIIIIllllllIIIl) && !GenLayer.isBiomeOceanic(lllllllllllllllIllIIIIllllllIIII) && !GenLayer.isBiomeOceanic(lllllllllllllllIllIIIIlllllIllll)) {
                            lllllllllllllllIllIIIIlllllllIll[lllllllllllllllIllIIIIlllllllIIl + lllllllllllllllIllIIIIlllllllIlI * lllllllllllllllIllIIIIlllllllllI] = lllllllllllllllIllIIIIlllllllIII;
                        }
                        else {
                            lllllllllllllllIllIIIIlllllllIll[lllllllllllllllIllIIIIlllllllIIl + lllllllllllllllIllIIIIlllllllIlI * lllllllllllllllIllIIIIlllllllllI] = Biome.getIdForBiome(Biomes.BEACH);
                        }
                    }
                    else {
                        lllllllllllllllIllIIIIlllllllIll[lllllllllllllllIllIIIIlllllllIIl + lllllllllllllllIllIIIIlllllllIlI * lllllllllllllllIllIIIIlllllllllI] = Biome.getIdForBiome(Biomes.JUNGLE_EDGE);
                    }
                }
                else if (lllllllllllllllIllIIIIlllllllIII != Biome.getIdForBiome(Biomes.EXTREME_HILLS) && lllllllllllllllIllIIIIlllllllIII != Biome.getIdForBiome(Biomes.EXTREME_HILLS_WITH_TREES) && lllllllllllllllIllIIIIlllllllIII != Biome.getIdForBiome(Biomes.EXTREME_HILLS_EDGE)) {
                    if (lllllllllllllllIllIIIIllllllIlll != null && lllllllllllllllIllIIIIllllllIlll.isSnowyBiome()) {
                        this.replaceIfNeighborOcean(lllllllllllllllIllIIIIllllllllII, lllllllllllllllIllIIIIlllllllIll, lllllllllllllllIllIIIIlllllllIIl, lllllllllllllllIllIIIIlllllllIlI, lllllllllllllllIllIIIIlllllllllI, lllllllllllllllIllIIIIlllllllIII, Biome.getIdForBiome(Biomes.COLD_BEACH));
                    }
                    else if (lllllllllllllllIllIIIIlllllllIII != Biome.getIdForBiome(Biomes.MESA) && lllllllllllllllIllIIIIlllllllIII != Biome.getIdForBiome(Biomes.MESA_ROCK)) {
                        if (lllllllllllllllIllIIIIlllllllIII != Biome.getIdForBiome(Biomes.OCEAN) && lllllllllllllllIllIIIIlllllllIII != Biome.getIdForBiome(Biomes.DEEP_OCEAN) && lllllllllllllllIllIIIIlllllllIII != Biome.getIdForBiome(Biomes.RIVER) && lllllllllllllllIllIIIIlllllllIII != Biome.getIdForBiome(Biomes.SWAMPLAND)) {
                            final int lllllllllllllllIllIIIIlllllIlllI = lllllllllllllllIllIIIIllllllllII[lllllllllllllllIllIIIIlllllllIIl + 1 + (lllllllllllllllIllIIIIlllllllIlI + 1 - 1) * (lllllllllllllllIllIIIIlllllllllI + 2)];
                            final int lllllllllllllllIllIIIIlllllIllIl = lllllllllllllllIllIIIIllllllllII[lllllllllllllllIllIIIIlllllllIIl + 1 + 1 + (lllllllllllllllIllIIIIlllllllIlI + 1) * (lllllllllllllllIllIIIIlllllllllI + 2)];
                            final int lllllllllllllllIllIIIIlllllIllII = lllllllllllllllIllIIIIllllllllII[lllllllllllllllIllIIIIlllllllIIl + 1 - 1 + (lllllllllllllllIllIIIIlllllllIlI + 1) * (lllllllllllllllIllIIIIlllllllllI + 2)];
                            final int lllllllllllllllIllIIIIlllllIlIll = lllllllllllllllIllIIIIllllllllII[lllllllllllllllIllIIIIlllllllIIl + 1 + (lllllllllllllllIllIIIIlllllllIlI + 1 + 1) * (lllllllllllllllIllIIIIlllllllllI + 2)];
                            if (!GenLayer.isBiomeOceanic(lllllllllllllllIllIIIIlllllIlllI) && !GenLayer.isBiomeOceanic(lllllllllllllllIllIIIIlllllIllIl) && !GenLayer.isBiomeOceanic(lllllllllllllllIllIIIIlllllIllII) && !GenLayer.isBiomeOceanic(lllllllllllllllIllIIIIlllllIlIll)) {
                                lllllllllllllllIllIIIIlllllllIll[lllllllllllllllIllIIIIlllllllIIl + lllllllllllllllIllIIIIlllllllIlI * lllllllllllllllIllIIIIlllllllllI] = lllllllllllllllIllIIIIlllllllIII;
                            }
                            else {
                                lllllllllllllllIllIIIIlllllllIll[lllllllllllllllIllIIIIlllllllIIl + lllllllllllllllIllIIIIlllllllIlI * lllllllllllllllIllIIIIlllllllllI] = Biome.getIdForBiome(Biomes.BEACH);
                            }
                        }
                        else {
                            lllllllllllllllIllIIIIlllllllIll[lllllllllllllllIllIIIIlllllllIIl + lllllllllllllllIllIIIIlllllllIlI * lllllllllllllllIllIIIIlllllllllI] = lllllllllllllllIllIIIIlllllllIII;
                        }
                    }
                    else {
                        final int lllllllllllllllIllIIIIlllllIlIlI = lllllllllllllllIllIIIIllllllllII[lllllllllllllllIllIIIIlllllllIIl + 1 + (lllllllllllllllIllIIIIlllllllIlI + 1 - 1) * (lllllllllllllllIllIIIIlllllllllI + 2)];
                        final int lllllllllllllllIllIIIIlllllIlIIl = lllllllllllllllIllIIIIllllllllII[lllllllllllllllIllIIIIlllllllIIl + 1 + 1 + (lllllllllllllllIllIIIIlllllllIlI + 1) * (lllllllllllllllIllIIIIlllllllllI + 2)];
                        final int lllllllllllllllIllIIIIlllllIlIII = lllllllllllllllIllIIIIllllllllII[lllllllllllllllIllIIIIlllllllIIl + 1 - 1 + (lllllllllllllllIllIIIIlllllllIlI + 1) * (lllllllllllllllIllIIIIlllllllllI + 2)];
                        final int lllllllllllllllIllIIIIlllllIIlll = lllllllllllllllIllIIIIllllllllII[lllllllllllllllIllIIIIlllllllIIl + 1 + (lllllllllllllllIllIIIIlllllllIlI + 1 + 1) * (lllllllllllllllIllIIIIlllllllllI + 2)];
                        if (!GenLayer.isBiomeOceanic(lllllllllllllllIllIIIIlllllIlIlI) && !GenLayer.isBiomeOceanic(lllllllllllllllIllIIIIlllllIlIIl) && !GenLayer.isBiomeOceanic(lllllllllllllllIllIIIIlllllIlIII) && !GenLayer.isBiomeOceanic(lllllllllllllllIllIIIIlllllIIlll)) {
                            if (this.isMesa(lllllllllllllllIllIIIIlllllIlIlI) && this.isMesa(lllllllllllllllIllIIIIlllllIlIIl) && this.isMesa(lllllllllllllllIllIIIIlllllIlIII) && this.isMesa(lllllllllllllllIllIIIIlllllIIlll)) {
                                lllllllllllllllIllIIIIlllllllIll[lllllllllllllllIllIIIIlllllllIIl + lllllllllllllllIllIIIIlllllllIlI * lllllllllllllllIllIIIIlllllllllI] = lllllllllllllllIllIIIIlllllllIII;
                            }
                            else {
                                lllllllllllllllIllIIIIlllllllIll[lllllllllllllllIllIIIIlllllllIIl + lllllllllllllllIllIIIIlllllllIlI * lllllllllllllllIllIIIIlllllllllI] = Biome.getIdForBiome(Biomes.DESERT);
                            }
                        }
                        else {
                            lllllllllllllllIllIIIIlllllllIll[lllllllllllllllIllIIIIlllllllIIl + lllllllllllllllIllIIIIlllllllIlI * lllllllllllllllIllIIIIlllllllllI] = lllllllllllllllIllIIIIlllllllIII;
                        }
                    }
                }
                else {
                    this.replaceIfNeighborOcean(lllllllllllllllIllIIIIllllllllII, lllllllllllllllIllIIIIlllllllIll, lllllllllllllllIllIIIIlllllllIIl, lllllllllllllllIllIIIIlllllllIlI, lllllllllllllllIllIIIIlllllllllI, lllllllllllllllIllIIIIlllllllIII, Biome.getIdForBiome(Biomes.STONE_BEACH));
                }
            }
        }
        return lllllllllllllllIllIIIIlllllllIll;
    }
}
