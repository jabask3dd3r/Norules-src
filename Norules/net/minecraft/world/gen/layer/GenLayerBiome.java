package net.minecraft.world.gen.layer;

import net.minecraft.world.biome.*;
import net.minecraft.world.gen.*;
import net.minecraft.init.*;
import net.minecraft.world.*;

public class GenLayerBiome extends GenLayer
{
    private final /* synthetic */ Biome[] iceBiomes;
    private final /* synthetic */ Biome[] mediumBiomes;
    private final /* synthetic */ Biome[] coldBiomes;
    private final /* synthetic */ ChunkGeneratorSettings settings;
    private /* synthetic */ Biome[] warmBiomes;
    
    @Override
    public int[] getInts(final int lllllllllllllIIllllIIlIlIIlIIlII, final int lllllllllllllIIllllIIlIlIIlIlllI, final int lllllllllllllIIllllIIlIlIIlIllIl, final int lllllllllllllIIllllIIlIlIIlIllII) {
        final int[] lllllllllllllIIllllIIlIlIIlIlIll = this.parent.getInts(lllllllllllllIIllllIIlIlIIlIIlII, lllllllllllllIIllllIIlIlIIlIlllI, lllllllllllllIIllllIIlIlIIlIllIl, lllllllllllllIIllllIIlIlIIlIllII);
        final int[] lllllllllllllIIllllIIlIlIIlIlIlI = IntCache.getIntCache(lllllllllllllIIllllIIlIlIIlIllIl * lllllllllllllIIllllIIlIlIIlIllII);
        for (int lllllllllllllIIllllIIlIlIIlIlIIl = 0; lllllllllllllIIllllIIlIlIIlIlIIl < lllllllllllllIIllllIIlIlIIlIllII; ++lllllllllllllIIllllIIlIlIIlIlIIl) {
            for (int lllllllllllllIIllllIIlIlIIlIlIII = 0; lllllllllllllIIllllIIlIlIIlIlIII < lllllllllllllIIllllIIlIlIIlIllIl; ++lllllllllllllIIllllIIlIlIIlIlIII) {
                this.initChunkSeed(lllllllllllllIIllllIIlIlIIlIlIII + lllllllllllllIIllllIIlIlIIlIIlII, lllllllllllllIIllllIIlIlIIlIlIIl + lllllllllllllIIllllIIlIlIIlIlllI);
                int lllllllllllllIIllllIIlIlIIlIIlll = lllllllllllllIIllllIIlIlIIlIlIll[lllllllllllllIIllllIIlIlIIlIlIII + lllllllllllllIIllllIIlIlIIlIlIIl * lllllllllllllIIllllIIlIlIIlIllIl];
                final int lllllllllllllIIllllIIlIlIIlIIllI = (lllllllllllllIIllllIIlIlIIlIIlll & 0xF00) >> 8;
                lllllllllllllIIllllIIlIlIIlIIlll &= 0xFFFFF0FF;
                if (this.settings != null && this.settings.fixedBiome >= 0) {
                    lllllllllllllIIllllIIlIlIIlIlIlI[lllllllllllllIIllllIIlIlIIlIlIII + lllllllllllllIIllllIIlIlIIlIlIIl * lllllllllllllIIllllIIlIlIIlIllIl] = this.settings.fixedBiome;
                }
                else if (GenLayer.isBiomeOceanic(lllllllllllllIIllllIIlIlIIlIIlll)) {
                    lllllllllllllIIllllIIlIlIIlIlIlI[lllllllllllllIIllllIIlIlIIlIlIII + lllllllllllllIIllllIIlIlIIlIlIIl * lllllllllllllIIllllIIlIlIIlIllIl] = lllllllllllllIIllllIIlIlIIlIIlll;
                }
                else if (lllllllllllllIIllllIIlIlIIlIIlll == Biome.getIdForBiome(Biomes.MUSHROOM_ISLAND)) {
                    lllllllllllllIIllllIIlIlIIlIlIlI[lllllllllllllIIllllIIlIlIIlIlIII + lllllllllllllIIllllIIlIlIIlIlIIl * lllllllllllllIIllllIIlIlIIlIllIl] = lllllllllllllIIllllIIlIlIIlIIlll;
                }
                else if (lllllllllllllIIllllIIlIlIIlIIlll == 1) {
                    if (lllllllllllllIIllllIIlIlIIlIIllI > 0) {
                        if (this.nextInt(3) == 0) {
                            lllllllllllllIIllllIIlIlIIlIlIlI[lllllllllllllIIllllIIlIlIIlIlIII + lllllllllllllIIllllIIlIlIIlIlIIl * lllllllllllllIIllllIIlIlIIlIllIl] = Biome.getIdForBiome(Biomes.MESA_CLEAR_ROCK);
                        }
                        else {
                            lllllllllllllIIllllIIlIlIIlIlIlI[lllllllllllllIIllllIIlIlIIlIlIII + lllllllllllllIIllllIIlIlIIlIlIIl * lllllllllllllIIllllIIlIlIIlIllIl] = Biome.getIdForBiome(Biomes.MESA_ROCK);
                        }
                    }
                    else {
                        lllllllllllllIIllllIIlIlIIlIlIlI[lllllllllllllIIllllIIlIlIIlIlIII + lllllllllllllIIllllIIlIlIIlIlIIl * lllllllllllllIIllllIIlIlIIlIllIl] = Biome.getIdForBiome(this.warmBiomes[this.nextInt(this.warmBiomes.length)]);
                    }
                }
                else if (lllllllllllllIIllllIIlIlIIlIIlll == 2) {
                    if (lllllllllllllIIllllIIlIlIIlIIllI > 0) {
                        lllllllllllllIIllllIIlIlIIlIlIlI[lllllllllllllIIllllIIlIlIIlIlIII + lllllllllllllIIllllIIlIlIIlIlIIl * lllllllllllllIIllllIIlIlIIlIllIl] = Biome.getIdForBiome(Biomes.JUNGLE);
                    }
                    else {
                        lllllllllllllIIllllIIlIlIIlIlIlI[lllllllllllllIIllllIIlIlIIlIlIII + lllllllllllllIIllllIIlIlIIlIlIIl * lllllllllllllIIllllIIlIlIIlIllIl] = Biome.getIdForBiome(this.mediumBiomes[this.nextInt(this.mediumBiomes.length)]);
                    }
                }
                else if (lllllllllllllIIllllIIlIlIIlIIlll == 3) {
                    if (lllllllllllllIIllllIIlIlIIlIIllI > 0) {
                        lllllllllllllIIllllIIlIlIIlIlIlI[lllllllllllllIIllllIIlIlIIlIlIII + lllllllllllllIIllllIIlIlIIlIlIIl * lllllllllllllIIllllIIlIlIIlIllIl] = Biome.getIdForBiome(Biomes.REDWOOD_TAIGA);
                    }
                    else {
                        lllllllllllllIIllllIIlIlIIlIlIlI[lllllllllllllIIllllIIlIlIIlIlIII + lllllllllllllIIllllIIlIlIIlIlIIl * lllllllllllllIIllllIIlIlIIlIllIl] = Biome.getIdForBiome(this.coldBiomes[this.nextInt(this.coldBiomes.length)]);
                    }
                }
                else if (lllllllllllllIIllllIIlIlIIlIIlll == 4) {
                    lllllllllllllIIllllIIlIlIIlIlIlI[lllllllllllllIIllllIIlIlIIlIlIII + lllllllllllllIIllllIIlIlIIlIlIIl * lllllllllllllIIllllIIlIlIIlIllIl] = Biome.getIdForBiome(this.iceBiomes[this.nextInt(this.iceBiomes.length)]);
                }
                else {
                    lllllllllllllIIllllIIlIlIIlIlIlI[lllllllllllllIIllllIIlIlIIlIlIII + lllllllllllllIIllllIIlIlIIlIlIIl * lllllllllllllIIllllIIlIlIIlIllIl] = Biome.getIdForBiome(Biomes.MUSHROOM_ISLAND);
                }
            }
        }
        return lllllllllllllIIllllIIlIlIIlIlIlI;
    }
    
    public GenLayerBiome(final long lllllllllllllIIllllIIlIlIlIIIlII, final GenLayer lllllllllllllIIllllIIlIlIlIIIIll, final WorldType lllllllllllllIIllllIIlIlIlIIIIlI, final ChunkGeneratorSettings lllllllllllllIIllllIIlIlIIllllII) {
        super(lllllllllllllIIllllIIlIlIlIIIlII);
        this.warmBiomes = new Biome[] { Biomes.DESERT, Biomes.DESERT, Biomes.DESERT, Biomes.SAVANNA, Biomes.SAVANNA, Biomes.PLAINS };
        this.mediumBiomes = new Biome[] { Biomes.FOREST, Biomes.ROOFED_FOREST, Biomes.EXTREME_HILLS, Biomes.PLAINS, Biomes.BIRCH_FOREST, Biomes.SWAMPLAND };
        this.coldBiomes = new Biome[] { Biomes.FOREST, Biomes.EXTREME_HILLS, Biomes.TAIGA, Biomes.PLAINS };
        this.iceBiomes = new Biome[] { Biomes.ICE_PLAINS, Biomes.ICE_PLAINS, Biomes.ICE_PLAINS, Biomes.COLD_TAIGA };
        this.parent = lllllllllllllIIllllIIlIlIlIIIIll;
        if (lllllllllllllIIllllIIlIlIlIIIIlI == WorldType.DEFAULT_1_1) {
            this.warmBiomes = new Biome[] { Biomes.DESERT, Biomes.FOREST, Biomes.EXTREME_HILLS, Biomes.SWAMPLAND, Biomes.PLAINS, Biomes.TAIGA };
            this.settings = null;
        }
        else {
            this.settings = lllllllllllllIIllllIIlIlIIllllII;
        }
    }
}
