package net.minecraft.world.gen.layer;

import net.minecraft.world.biome.*;
import net.minecraft.init.*;
import org.apache.logging.log4j.*;

public class GenLayerHills extends GenLayer
{
    private static final /* synthetic */ Logger LOGGER;
    private final /* synthetic */ GenLayer riverLayer;
    
    public GenLayerHills(final long llllllllllllllIIIlIIIlIlIllIlIll, final GenLayer llllllllllllllIIIlIIIlIlIllIlIlI, final GenLayer llllllllllllllIIIlIIIlIlIllIllIl) {
        super(llllllllllllllIIIlIIIlIlIllIlIll);
        this.parent = llllllllllllllIIIlIIIlIlIllIlIlI;
        this.riverLayer = llllllllllllllIIIlIIIlIlIllIllIl;
    }
    
    @Override
    public int[] getInts(final int llllllllllllllIIIlIIIlIlIlIlIIIl, final int llllllllllllllIIIlIIIlIlIIllIlll, final int llllllllllllllIIIlIIIlIlIIllIllI, final int llllllllllllllIIIlIIIlIlIIllIlIl) {
        final int[] llllllllllllllIIIlIIIlIlIlIIllIl = this.parent.getInts(llllllllllllllIIIlIIIlIlIlIlIIIl - 1, llllllllllllllIIIlIIIlIlIIllIlll - 1, llllllllllllllIIIlIIIlIlIIllIllI + 2, llllllllllllllIIIlIIIlIlIIllIlIl + 2);
        final int[] llllllllllllllIIIlIIIlIlIlIIllII = this.riverLayer.getInts(llllllllllllllIIIlIIIlIlIlIlIIIl - 1, llllllllllllllIIIlIIIlIlIIllIlll - 1, llllllllllllllIIIlIIIlIlIIllIllI + 2, llllllllllllllIIIlIIIlIlIIllIlIl + 2);
        final int[] llllllllllllllIIIlIIIlIlIlIIlIll = IntCache.getIntCache(llllllllllllllIIIlIIIlIlIIllIllI * llllllllllllllIIIlIIIlIlIIllIlIl);
        for (int llllllllllllllIIIlIIIlIlIlIIlIlI = 0; llllllllllllllIIIlIIIlIlIlIIlIlI < llllllllllllllIIIlIIIlIlIIllIlIl; ++llllllllllllllIIIlIIIlIlIlIIlIlI) {
            for (int llllllllllllllIIIlIIIlIlIlIIlIIl = 0; llllllllllllllIIIlIIIlIlIlIIlIIl < llllllllllllllIIIlIIIlIlIIllIllI; ++llllllllllllllIIIlIIIlIlIlIIlIIl) {
                this.initChunkSeed(llllllllllllllIIIlIIIlIlIlIIlIIl + llllllllllllllIIIlIIIlIlIlIlIIIl, llllllllllllllIIIlIIIlIlIlIIlIlI + llllllllllllllIIIlIIIlIlIIllIlll);
                final int llllllllllllllIIIlIIIlIlIlIIlIII = llllllllllllllIIIlIIIlIlIlIIllIl[llllllllllllllIIIlIIIlIlIlIIlIIl + 1 + (llllllllllllllIIIlIIIlIlIlIIlIlI + 1) * (llllllllllllllIIIlIIIlIlIIllIllI + 2)];
                final int llllllllllllllIIIlIIIlIlIlIIIlll = llllllllllllllIIIlIIIlIlIlIIllII[llllllllllllllIIIlIIIlIlIlIIlIIl + 1 + (llllllllllllllIIIlIIIlIlIlIIlIlI + 1) * (llllllllllllllIIIlIIIlIlIIllIllI + 2)];
                final boolean llllllllllllllIIIlIIIlIlIlIIIllI = (llllllllllllllIIIlIIIlIlIlIIIlll - 2) % 29 == 0;
                if (llllllllllllllIIIlIIIlIlIlIIlIII > 255) {
                    GenLayerHills.LOGGER.debug("old! {}", (Object)llllllllllllllIIIlIIIlIlIlIIlIII);
                }
                final Biome llllllllllllllIIIlIIIlIlIlIIIlIl = Biome.getBiomeForId(llllllllllllllIIIlIIIlIlIlIIlIII);
                final boolean llllllllllllllIIIlIIIlIlIlIIIlII = llllllllllllllIIIlIIIlIlIlIIIlIl != null && llllllllllllllIIIlIIIlIlIlIIIlIl.isMutation();
                if (llllllllllllllIIIlIIIlIlIlIIlIII != 0 && llllllllllllllIIIlIIIlIlIlIIIlll >= 2 && (llllllllllllllIIIlIIIlIlIlIIIlll - 2) % 29 == 1 && !llllllllllllllIIIlIIIlIlIlIIIlII) {
                    final Biome llllllllllllllIIIlIIIlIlIlIIIIll = Biome.getMutationForBiome(llllllllllllllIIIlIIIlIlIlIIIlIl);
                    llllllllllllllIIIlIIIlIlIlIIlIll[llllllllllllllIIIlIIIlIlIlIIlIIl + llllllllllllllIIIlIIIlIlIlIIlIlI * llllllllllllllIIIlIIIlIlIIllIllI] = ((llllllllllllllIIIlIIIlIlIlIIIIll == null) ? llllllllllllllIIIlIIIlIlIlIIlIII : Biome.getIdForBiome(llllllllllllllIIIlIIIlIlIlIIIIll));
                }
                else if (this.nextInt(3) != 0 && !llllllllllllllIIIlIIIlIlIlIIIllI) {
                    llllllllllllllIIIlIIIlIlIlIIlIll[llllllllllllllIIIlIIIlIlIlIIlIIl + llllllllllllllIIIlIIIlIlIlIIlIlI * llllllllllllllIIIlIIIlIlIIllIllI] = llllllllllllllIIIlIIIlIlIlIIlIII;
                }
                else {
                    Biome llllllllllllllIIIlIIIlIlIlIIIIlI;
                    if ((llllllllllllllIIIlIIIlIlIlIIIIlI = llllllllllllllIIIlIIIlIlIlIIIlIl) == Biomes.DESERT) {
                        llllllllllllllIIIlIIIlIlIlIIIIlI = Biomes.DESERT_HILLS;
                    }
                    else if (llllllllllllllIIIlIIIlIlIlIIIlIl == Biomes.FOREST) {
                        llllllllllllllIIIlIIIlIlIlIIIIlI = Biomes.FOREST_HILLS;
                    }
                    else if (llllllllllllllIIIlIIIlIlIlIIIlIl == Biomes.BIRCH_FOREST) {
                        llllllllllllllIIIlIIIlIlIlIIIIlI = Biomes.BIRCH_FOREST_HILLS;
                    }
                    else if (llllllllllllllIIIlIIIlIlIlIIIlIl == Biomes.ROOFED_FOREST) {
                        llllllllllllllIIIlIIIlIlIlIIIIlI = Biomes.PLAINS;
                    }
                    else if (llllllllllllllIIIlIIIlIlIlIIIlIl == Biomes.TAIGA) {
                        llllllllllllllIIIlIIIlIlIlIIIIlI = Biomes.TAIGA_HILLS;
                    }
                    else if (llllllllllllllIIIlIIIlIlIlIIIlIl == Biomes.REDWOOD_TAIGA) {
                        llllllllllllllIIIlIIIlIlIlIIIIlI = Biomes.REDWOOD_TAIGA_HILLS;
                    }
                    else if (llllllllllllllIIIlIIIlIlIlIIIlIl == Biomes.COLD_TAIGA) {
                        llllllllllllllIIIlIIIlIlIlIIIIlI = Biomes.COLD_TAIGA_HILLS;
                    }
                    else if (llllllllllllllIIIlIIIlIlIlIIIlIl == Biomes.PLAINS) {
                        if (this.nextInt(3) == 0) {
                            llllllllllllllIIIlIIIlIlIlIIIIlI = Biomes.FOREST_HILLS;
                        }
                        else {
                            llllllllllllllIIIlIIIlIlIlIIIIlI = Biomes.FOREST;
                        }
                    }
                    else if (llllllllllllllIIIlIIIlIlIlIIIlIl == Biomes.ICE_PLAINS) {
                        llllllllllllllIIIlIIIlIlIlIIIIlI = Biomes.ICE_MOUNTAINS;
                    }
                    else if (llllllllllllllIIIlIIIlIlIlIIIlIl == Biomes.JUNGLE) {
                        llllllllllllllIIIlIIIlIlIlIIIIlI = Biomes.JUNGLE_HILLS;
                    }
                    else if (llllllllllllllIIIlIIIlIlIlIIIlIl == Biomes.OCEAN) {
                        llllllllllllllIIIlIIIlIlIlIIIIlI = Biomes.DEEP_OCEAN;
                    }
                    else if (llllllllllllllIIIlIIIlIlIlIIIlIl == Biomes.EXTREME_HILLS) {
                        llllllllllllllIIIlIIIlIlIlIIIIlI = Biomes.EXTREME_HILLS_WITH_TREES;
                    }
                    else if (llllllllllllllIIIlIIIlIlIlIIIlIl == Biomes.SAVANNA) {
                        llllllllllllllIIIlIIIlIlIlIIIIlI = Biomes.SAVANNA_PLATEAU;
                    }
                    else if (GenLayer.biomesEqualOrMesaPlateau(llllllllllllllIIIlIIIlIlIlIIlIII, Biome.getIdForBiome(Biomes.MESA_ROCK))) {
                        llllllllllllllIIIlIIIlIlIlIIIIlI = Biomes.MESA;
                    }
                    else if (llllllllllllllIIIlIIIlIlIlIIIlIl == Biomes.DEEP_OCEAN && this.nextInt(3) == 0) {
                        final int llllllllllllllIIIlIIIlIlIlIIIIIl = this.nextInt(2);
                        if (llllllllllllllIIIlIIIlIlIlIIIIIl == 0) {
                            llllllllllllllIIIlIIIlIlIlIIIIlI = Biomes.PLAINS;
                        }
                        else {
                            llllllllllllllIIIlIIIlIlIlIIIIlI = Biomes.FOREST;
                        }
                    }
                    int llllllllllllllIIIlIIIlIlIlIIIIII = Biome.getIdForBiome(llllllllllllllIIIlIIIlIlIlIIIIlI);
                    if (llllllllllllllIIIlIIIlIlIlIIIllI && llllllllllllllIIIlIIIlIlIlIIIIII != llllllllllllllIIIlIIIlIlIlIIlIII) {
                        final Biome llllllllllllllIIIlIIIlIlIIllllll = Biome.getMutationForBiome(llllllllllllllIIIlIIIlIlIlIIIIlI);
                        llllllllllllllIIIlIIIlIlIlIIIIII = ((llllllllllllllIIIlIIIlIlIIllllll == null) ? llllllllllllllIIIlIIIlIlIlIIlIII : Biome.getIdForBiome(llllllllllllllIIIlIIIlIlIIllllll));
                    }
                    if (llllllllllllllIIIlIIIlIlIlIIIIII == llllllllllllllIIIlIIIlIlIlIIlIII) {
                        llllllllllllllIIIlIIIlIlIlIIlIll[llllllllllllllIIIlIIIlIlIlIIlIIl + llllllllllllllIIIlIIIlIlIlIIlIlI * llllllllllllllIIIlIIIlIlIIllIllI] = llllllllllllllIIIlIIIlIlIlIIlIII;
                    }
                    else {
                        final int llllllllllllllIIIlIIIlIlIIlllllI = llllllllllllllIIIlIIIlIlIlIIllIl[llllllllllllllIIIlIIIlIlIlIIlIIl + 1 + (llllllllllllllIIIlIIIlIlIlIIlIlI + 0) * (llllllllllllllIIIlIIIlIlIIllIllI + 2)];
                        final int llllllllllllllIIIlIIIlIlIIllllIl = llllllllllllllIIIlIIIlIlIlIIllIl[llllllllllllllIIIlIIIlIlIlIIlIIl + 2 + (llllllllllllllIIIlIIIlIlIlIIlIlI + 1) * (llllllllllllllIIIlIIIlIlIIllIllI + 2)];
                        final int llllllllllllllIIIlIIIlIlIIllllII = llllllllllllllIIIlIIIlIlIlIIllIl[llllllllllllllIIIlIIIlIlIlIIlIIl + 0 + (llllllllllllllIIIlIIIlIlIlIIlIlI + 1) * (llllllllllllllIIIlIIIlIlIIllIllI + 2)];
                        final int llllllllllllllIIIlIIIlIlIIlllIll = llllllllllllllIIIlIIIlIlIlIIllIl[llllllllllllllIIIlIIIlIlIlIIlIIl + 1 + (llllllllllllllIIIlIIIlIlIlIIlIlI + 2) * (llllllllllllllIIIlIIIlIlIIllIllI + 2)];
                        int llllllllllllllIIIlIIIlIlIIlllIlI = 0;
                        if (GenLayer.biomesEqualOrMesaPlateau(llllllllllllllIIIlIIIlIlIIlllllI, llllllllllllllIIIlIIIlIlIlIIlIII)) {
                            ++llllllllllllllIIIlIIIlIlIIlllIlI;
                        }
                        if (GenLayer.biomesEqualOrMesaPlateau(llllllllllllllIIIlIIIlIlIIllllIl, llllllllllllllIIIlIIIlIlIlIIlIII)) {
                            ++llllllllllllllIIIlIIIlIlIIlllIlI;
                        }
                        if (GenLayer.biomesEqualOrMesaPlateau(llllllllllllllIIIlIIIlIlIIllllII, llllllllllllllIIIlIIIlIlIlIIlIII)) {
                            ++llllllllllllllIIIlIIIlIlIIlllIlI;
                        }
                        if (GenLayer.biomesEqualOrMesaPlateau(llllllllllllllIIIlIIIlIlIIlllIll, llllllllllllllIIIlIIIlIlIlIIlIII)) {
                            ++llllllllllllllIIIlIIIlIlIIlllIlI;
                        }
                        if (llllllllllllllIIIlIIIlIlIIlllIlI >= 3) {
                            llllllllllllllIIIlIIIlIlIlIIlIll[llllllllllllllIIIlIIIlIlIlIIlIIl + llllllllllllllIIIlIIIlIlIlIIlIlI * llllllllllllllIIIlIIIlIlIIllIllI] = llllllllllllllIIIlIIIlIlIlIIIIII;
                        }
                        else {
                            llllllllllllllIIIlIIIlIlIlIIlIll[llllllllllllllIIIlIIIlIlIlIIlIIl + llllllllllllllIIIlIIIlIlIlIIlIlI * llllllllllllllIIIlIIIlIlIIllIllI] = llllllllllllllIIIlIIIlIlIlIIlIII;
                        }
                    }
                }
            }
        }
        return llllllllllllllIIIlIIIlIlIlIIlIll;
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
}
