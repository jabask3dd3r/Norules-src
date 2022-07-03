package net.minecraft.world.gen.layer;

import net.minecraft.world.*;
import net.minecraft.world.gen.*;
import net.minecraft.world.biome.*;
import net.minecraft.init.*;

public abstract class GenLayer
{
    private /* synthetic */ long chunkSeed;
    private /* synthetic */ long worldGenSeed;
    protected /* synthetic */ long baseSeed;
    protected /* synthetic */ GenLayer parent;
    
    public static GenLayer[] initializeAllBiomeGenerators(final long lllllllllllllIIlllIlIIlllIIlIllI, final WorldType lllllllllllllIIlllIlIIlllIllIlIl, final ChunkGeneratorSettings lllllllllllllIIlllIlIIlllIllIlII) {
        GenLayer lllllllllllllIIlllIlIIlllIllIIll = new GenLayerIsland(1L);
        lllllllllllllIIlllIlIIlllIllIIll = new GenLayerFuzzyZoom(2000L, lllllllllllllIIlllIlIIlllIllIIll);
        final GenLayer lllllllllllllIIlllIlIIlllIllIIlI = new GenLayerAddIsland(1L, lllllllllllllIIlllIlIIlllIllIIll);
        final GenLayer lllllllllllllIIlllIlIIlllIllIIIl = new GenLayerZoom(2001L, lllllllllllllIIlllIlIIlllIllIIlI);
        GenLayer lllllllllllllIIlllIlIIlllIllIIII = new GenLayerAddIsland(2L, lllllllllllllIIlllIlIIlllIllIIIl);
        lllllllllllllIIlllIlIIlllIllIIII = new GenLayerAddIsland(50L, lllllllllllllIIlllIlIIlllIllIIII);
        lllllllllllllIIlllIlIIlllIllIIII = new GenLayerAddIsland(70L, lllllllllllllIIlllIlIIlllIllIIII);
        final GenLayer lllllllllllllIIlllIlIIlllIlIllll = new GenLayerRemoveTooMuchOcean(2L, lllllllllllllIIlllIlIIlllIllIIII);
        final GenLayer lllllllllllllIIlllIlIIlllIlIlllI = new GenLayerAddSnow(2L, lllllllllllllIIlllIlIIlllIlIllll);
        final GenLayer lllllllllllllIIlllIlIIlllIlIllIl = new GenLayerAddIsland(3L, lllllllllllllIIlllIlIIlllIlIlllI);
        GenLayer lllllllllllllIIlllIlIIlllIlIllII = new GenLayerEdge(2L, lllllllllllllIIlllIlIIlllIlIllIl, GenLayerEdge.Mode.COOL_WARM);
        lllllllllllllIIlllIlIIlllIlIllII = new GenLayerEdge(2L, lllllllllllllIIlllIlIIlllIlIllII, GenLayerEdge.Mode.HEAT_ICE);
        lllllllllllllIIlllIlIIlllIlIllII = new GenLayerEdge(3L, lllllllllllllIIlllIlIIlllIlIllII, GenLayerEdge.Mode.SPECIAL);
        GenLayer lllllllllllllIIlllIlIIlllIlIlIll = new GenLayerZoom(2002L, lllllllllllllIIlllIlIIlllIlIllII);
        lllllllllllllIIlllIlIIlllIlIlIll = new GenLayerZoom(2003L, lllllllllllllIIlllIlIIlllIlIlIll);
        final GenLayer lllllllllllllIIlllIlIIlllIlIlIlI = new GenLayerAddIsland(4L, lllllllllllllIIlllIlIIlllIlIlIll);
        final GenLayer lllllllllllllIIlllIlIIlllIlIlIIl = new GenLayerAddMushroomIsland(5L, lllllllllllllIIlllIlIIlllIlIlIlI);
        final GenLayer lllllllllllllIIlllIlIIlllIlIlIII = new GenLayerDeepOcean(4L, lllllllllllllIIlllIlIIlllIlIlIIl);
        final GenLayer lllllllllllllIIlllIlIIlllIlIIlll = GenLayerZoom.magnify(1000L, lllllllllllllIIlllIlIIlllIlIlIII, 0);
        int lllllllllllllIIlllIlIIlllIlIIlIl;
        int lllllllllllllIIlllIlIIlllIlIIllI = lllllllllllllIIlllIlIIlllIlIIlIl = 4;
        if (lllllllllllllIIlllIlIIlllIllIlII != null) {
            lllllllllllllIIlllIlIIlllIlIIllI = lllllllllllllIIlllIlIIlllIllIlII.biomeSize;
            lllllllllllllIIlllIlIIlllIlIIlIl = lllllllllllllIIlllIlIIlllIllIlII.riverSize;
        }
        if (lllllllllllllIIlllIlIIlllIllIlIl == WorldType.LARGE_BIOMES) {
            lllllllllllllIIlllIlIIlllIlIIllI = 6;
        }
        final GenLayer lllllllllllllIIlllIlIIlllIlIIlII = GenLayerZoom.magnify(1000L, lllllllllllllIIlllIlIIlllIlIIlll, 0);
        final GenLayer lllllllllllllIIlllIlIIlllIlIIIll = new GenLayerRiverInit(100L, lllllllllllllIIlllIlIIlllIlIIlII);
        final GenLayer lllllllllllllIIlllIlIIlllIlIIIlI = new GenLayerBiome(200L, lllllllllllllIIlllIlIIlllIlIIlll, lllllllllllllIIlllIlIIlllIllIlIl, lllllllllllllIIlllIlIIlllIllIlII);
        final GenLayer lllllllllllllIIlllIlIIlllIlIIIIl = GenLayerZoom.magnify(1000L, lllllllllllllIIlllIlIIlllIlIIIlI, 2);
        final GenLayer lllllllllllllIIlllIlIIlllIlIIIII = new GenLayerBiomeEdge(1000L, lllllllllllllIIlllIlIIlllIlIIIIl);
        final GenLayer lllllllllllllIIlllIlIIlllIIlllll = GenLayerZoom.magnify(1000L, lllllllllllllIIlllIlIIlllIlIIIll, 2);
        GenLayer lllllllllllllIIlllIlIIlllIIllllI = new GenLayerHills(1000L, lllllllllllllIIlllIlIIlllIlIIIII, lllllllllllllIIlllIlIIlllIIlllll);
        GenLayer lllllllllllllIIlllIlIIlllIIlllIl = GenLayerZoom.magnify(1000L, lllllllllllllIIlllIlIIlllIlIIIll, 2);
        lllllllllllllIIlllIlIIlllIIlllIl = GenLayerZoom.magnify(1000L, lllllllllllllIIlllIlIIlllIIlllIl, lllllllllllllIIlllIlIIlllIlIIlIl);
        final GenLayer lllllllllllllIIlllIlIIlllIIlllII = new GenLayerRiver(1L, lllllllllllllIIlllIlIIlllIIlllIl);
        final GenLayer lllllllllllllIIlllIlIIlllIIllIll = new GenLayerSmooth(1000L, lllllllllllllIIlllIlIIlllIIlllII);
        lllllllllllllIIlllIlIIlllIIllllI = new GenLayerRareBiome(1001L, lllllllllllllIIlllIlIIlllIIllllI);
        for (int lllllllllllllIIlllIlIIlllIIllIlI = 0; lllllllllllllIIlllIlIIlllIIllIlI < lllllllllllllIIlllIlIIlllIlIIllI; ++lllllllllllllIIlllIlIIlllIIllIlI) {
            lllllllllllllIIlllIlIIlllIIllllI = new GenLayerZoom(1000 + lllllllllllllIIlllIlIIlllIIllIlI, lllllllllllllIIlllIlIIlllIIllllI);
            if (lllllllllllllIIlllIlIIlllIIllIlI == 0) {
                lllllllllllllIIlllIlIIlllIIllllI = new GenLayerAddIsland(3L, lllllllllllllIIlllIlIIlllIIllllI);
            }
            if (lllllllllllllIIlllIlIIlllIIllIlI == 1 || lllllllllllllIIlllIlIIlllIlIIllI == 1) {
                lllllllllllllIIlllIlIIlllIIllllI = new GenLayerShore(1000L, lllllllllllllIIlllIlIIlllIIllllI);
            }
        }
        final GenLayer lllllllllllllIIlllIlIIlllIIllIIl = new GenLayerSmooth(1000L, lllllllllllllIIlllIlIIlllIIllllI);
        final GenLayer lllllllllllllIIlllIlIIlllIIllIII = new GenLayerRiverMix(100L, lllllllllllllIIlllIlIIlllIIllIIl, lllllllllllllIIlllIlIIlllIIllIll);
        final GenLayer lllllllllllllIIlllIlIIlllIIlIlll = new GenLayerVoronoiZoom(10L, lllllllllllllIIlllIlIIlllIIllIII);
        lllllllllllllIIlllIlIIlllIIllIII.initWorldGenSeed(lllllllllllllIIlllIlIIlllIIlIllI);
        lllllllllllllIIlllIlIIlllIIlIlll.initWorldGenSeed(lllllllllllllIIlllIlIIlllIIlIllI);
        return new GenLayer[] { lllllllllllllIIlllIlIIlllIIllIII, lllllllllllllIIlllIlIIlllIIlIlll, lllllllllllllIIlllIlIIlllIIllIII };
    }
    
    protected static boolean biomesEqualOrMesaPlateau(final int lllllllllllllIIlllIlIIllIlIlIIIl, final int lllllllllllllIIlllIlIIllIlIlIlII) {
        if (lllllllllllllIIlllIlIIllIlIlIIIl == lllllllllllllIIlllIlIIllIlIlIlII) {
            return true;
        }
        final Biome lllllllllllllIIlllIlIIllIlIlIIll = Biome.getBiome(lllllllllllllIIlllIlIIllIlIlIIIl);
        final Biome lllllllllllllIIlllIlIIllIlIlIIlI = Biome.getBiome(lllllllllllllIIlllIlIIllIlIlIlII);
        if (lllllllllllllIIlllIlIIllIlIlIIll == null || lllllllllllllIIlllIlIIllIlIlIIlI == null) {
            return false;
        }
        if (lllllllllllllIIlllIlIIllIlIlIIll != Biomes.MESA_ROCK && lllllllllllllIIlllIlIIllIlIlIIll != Biomes.MESA_CLEAR_ROCK) {
            return lllllllllllllIIlllIlIIllIlIlIIll == lllllllllllllIIlllIlIIllIlIlIIlI || lllllllllllllIIlllIlIIllIlIlIIll.getBiomeClass() == lllllllllllllIIlllIlIIllIlIlIIlI.getBiomeClass();
        }
        return lllllllllllllIIlllIlIIllIlIlIIlI == Biomes.MESA_ROCK || lllllllllllllIIlllIlIIllIlIlIIlI == Biomes.MESA_CLEAR_ROCK;
    }
    
    protected int selectRandom(final int... lllllllllllllIIlllIlIIllIlIIIlII) {
        return lllllllllllllIIlllIlIIllIlIIIlII[this.nextInt(lllllllllllllIIlllIlIIllIlIIIlII.length)];
    }
    
    public void initChunkSeed(final long lllllllllllllIIlllIlIIllIllIIlII, final long lllllllllllllIIlllIlIIllIllIIIll) {
        this.chunkSeed = this.worldGenSeed;
        this.chunkSeed *= this.chunkSeed * 6364136223846793005L + 1442695040888963407L;
        this.chunkSeed += lllllllllllllIIlllIlIIllIllIIlII;
        this.chunkSeed *= this.chunkSeed * 6364136223846793005L + 1442695040888963407L;
        this.chunkSeed += lllllllllllllIIlllIlIIllIllIIIll;
        this.chunkSeed *= this.chunkSeed * 6364136223846793005L + 1442695040888963407L;
        this.chunkSeed += lllllllllllllIIlllIlIIllIllIIlII;
        this.chunkSeed *= this.chunkSeed * 6364136223846793005L + 1442695040888963407L;
        this.chunkSeed += lllllllllllllIIlllIlIIllIllIIIll;
    }
    
    public abstract int[] getInts(final int p0, final int p1, final int p2, final int p3);
    
    protected int selectModeOrRandom(final int lllllllllllllIIlllIlIIllIIlllIll, final int lllllllllllllIIlllIlIIllIIllIlIl, final int lllllllllllllIIlllIlIIllIIlllIIl, final int lllllllllllllIIlllIlIIllIIlllIII) {
        if (lllllllllllllIIlllIlIIllIIllIlIl == lllllllllllllIIlllIlIIllIIlllIIl && lllllllllllllIIlllIlIIllIIlllIIl == lllllllllllllIIlllIlIIllIIlllIII) {
            return lllllllllllllIIlllIlIIllIIllIlIl;
        }
        if (lllllllllllllIIlllIlIIllIIlllIll == lllllllllllllIIlllIlIIllIIllIlIl && lllllllllllllIIlllIlIIllIIlllIll == lllllllllllllIIlllIlIIllIIlllIIl) {
            return lllllllllllllIIlllIlIIllIIlllIll;
        }
        if (lllllllllllllIIlllIlIIllIIlllIll == lllllllllllllIIlllIlIIllIIllIlIl && lllllllllllllIIlllIlIIllIIlllIll == lllllllllllllIIlllIlIIllIIlllIII) {
            return lllllllllllllIIlllIlIIllIIlllIll;
        }
        if (lllllllllllllIIlllIlIIllIIlllIll == lllllllllllllIIlllIlIIllIIlllIIl && lllllllllllllIIlllIlIIllIIlllIll == lllllllllllllIIlllIlIIllIIlllIII) {
            return lllllllllllllIIlllIlIIllIIlllIll;
        }
        if (lllllllllllllIIlllIlIIllIIlllIll == lllllllllllllIIlllIlIIllIIllIlIl && lllllllllllllIIlllIlIIllIIlllIIl != lllllllllllllIIlllIlIIllIIlllIII) {
            return lllllllllllllIIlllIlIIllIIlllIll;
        }
        if (lllllllllllllIIlllIlIIllIIlllIll == lllllllllllllIIlllIlIIllIIlllIIl && lllllllllllllIIlllIlIIllIIllIlIl != lllllllllllllIIlllIlIIllIIlllIII) {
            return lllllllllllllIIlllIlIIllIIlllIll;
        }
        if (lllllllllllllIIlllIlIIllIIlllIll == lllllllllllllIIlllIlIIllIIlllIII && lllllllllllllIIlllIlIIllIIllIlIl != lllllllllllllIIlllIlIIllIIlllIIl) {
            return lllllllllllllIIlllIlIIllIIlllIll;
        }
        if (lllllllllllllIIlllIlIIllIIllIlIl == lllllllllllllIIlllIlIIllIIlllIIl && lllllllllllllIIlllIlIIllIIlllIll != lllllllllllllIIlllIlIIllIIlllIII) {
            return lllllllllllllIIlllIlIIllIIllIlIl;
        }
        if (lllllllllllllIIlllIlIIllIIllIlIl == lllllllllllllIIlllIlIIllIIlllIII && lllllllllllllIIlllIlIIllIIlllIll != lllllllllllllIIlllIlIIllIIlllIIl) {
            return lllllllllllllIIlllIlIIllIIllIlIl;
        }
        return (lllllllllllllIIlllIlIIllIIlllIIl == lllllllllllllIIlllIlIIllIIlllIII && lllllllllllllIIlllIlIIllIIlllIll != lllllllllllllIIlllIlIIllIIllIlIl) ? lllllllllllllIIlllIlIIllIIlllIIl : this.selectRandom(lllllllllllllIIlllIlIIllIIlllIll, lllllllllllllIIlllIlIIllIIllIlIl, lllllllllllllIIlllIlIIllIIlllIIl, lllllllllllllIIlllIlIIllIIlllIII);
    }
    
    public GenLayer(final long lllllllllllllIIlllIlIIllIlllIIlI) {
        this.baseSeed = lllllllllllllIIlllIlIIllIlllIIlI;
        this.baseSeed *= this.baseSeed * 6364136223846793005L + 1442695040888963407L;
        this.baseSeed += lllllllllllllIIlllIlIIllIlllIIlI;
        this.baseSeed *= this.baseSeed * 6364136223846793005L + 1442695040888963407L;
        this.baseSeed += lllllllllllllIIlllIlIIllIlllIIlI;
        this.baseSeed *= this.baseSeed * 6364136223846793005L + 1442695040888963407L;
        this.baseSeed += lllllllllllllIIlllIlIIllIlllIIlI;
    }
    
    protected int nextInt(final int lllllllllllllIIlllIlIIllIlIllllI) {
        int lllllllllllllIIlllIlIIllIlIlllIl = (int)((this.chunkSeed >> 24) % lllllllllllllIIlllIlIIllIlIllllI);
        if (lllllllllllllIIlllIlIIllIlIlllIl < 0) {
            lllllllllllllIIlllIlIIllIlIlllIl += lllllllllllllIIlllIlIIllIlIllllI;
        }
        this.chunkSeed *= this.chunkSeed * 6364136223846793005L + 1442695040888963407L;
        this.chunkSeed += this.worldGenSeed;
        return lllllllllllllIIlllIlIIllIlIlllIl;
    }
    
    public void initWorldGenSeed(final long lllllllllllllIIlllIlIIllIllIllII) {
        this.worldGenSeed = lllllllllllllIIlllIlIIllIllIllII;
        if (this.parent != null) {
            this.parent.initWorldGenSeed(lllllllllllllIIlllIlIIllIllIllII);
        }
        this.worldGenSeed *= this.worldGenSeed * 6364136223846793005L + 1442695040888963407L;
        this.worldGenSeed += this.baseSeed;
        this.worldGenSeed *= this.worldGenSeed * 6364136223846793005L + 1442695040888963407L;
        this.worldGenSeed += this.baseSeed;
        this.worldGenSeed *= this.worldGenSeed * 6364136223846793005L + 1442695040888963407L;
        this.worldGenSeed += this.baseSeed;
    }
    
    protected static boolean isBiomeOceanic(final int lllllllllllllIIlllIlIIllIlIIlIll) {
        final Biome lllllllllllllIIlllIlIIllIlIIlIlI = Biome.getBiome(lllllllllllllIIlllIlIIllIlIIlIll);
        return lllllllllllllIIlllIlIIllIlIIlIlI == Biomes.OCEAN || lllllllllllllIIlllIlIIllIlIIlIlI == Biomes.DEEP_OCEAN || lllllllllllllIIlllIlIIllIlIIlIlI == Biomes.FROZEN_OCEAN;
    }
}
