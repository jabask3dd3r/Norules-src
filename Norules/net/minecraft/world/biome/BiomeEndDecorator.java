package net.minecraft.world.biome;

import net.minecraft.world.gen.feature.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import java.util.concurrent.*;
import com.google.common.cache.*;
import com.google.common.collect.*;
import java.util.*;

public class BiomeEndDecorator extends BiomeDecorator
{
    private final /* synthetic */ WorldGenSpikes spikeGen;
    private static final /* synthetic */ LoadingCache<Long, WorldGenSpikes.EndSpike[]> SPIKE_CACHE;
    
    @Override
    protected void genDecorations(final Biome lllllllllllllIIIlIlIIllIIllIIIll, final World lllllllllllllIIIlIlIIllIIlIlllIl, final Random lllllllllllllIIIlIlIIllIIllIIIIl) {
        this.generateOres(lllllllllllllIIIlIlIIllIIlIlllIl, lllllllllllllIIIlIlIIllIIllIIIIl);
        final WorldGenSpikes.EndSpike[] lllllllllllllIIIlIlIIllIIllIIIII = getSpikesForWorld(lllllllllllllIIIlIlIIllIIlIlllIl);
        final short lllllllllllllIIIlIlIIllIIlIlIlll;
        final long lllllllllllllIIIlIlIIllIIlIllIII = ((WorldGenSpikes.EndSpike[])(Object)(lllllllllllllIIIlIlIIllIIlIlIlll = (short)(Object)lllllllllllllIIIlIlIIllIIllIIIII)).length;
        for (char lllllllllllllIIIlIlIIllIIlIllIIl = '\0'; lllllllllllllIIIlIlIIllIIlIllIIl < lllllllllllllIIIlIlIIllIIlIllIII; ++lllllllllllllIIIlIlIIllIIlIllIIl) {
            final WorldGenSpikes.EndSpike lllllllllllllIIIlIlIIllIIlIlllll = lllllllllllllIIIlIlIIllIIlIlIlll[lllllllllllllIIIlIlIIllIIlIllIIl];
            if (lllllllllllllIIIlIlIIllIIlIlllll.doesStartInChunk(this.chunkPos)) {
                this.spikeGen.setSpike(lllllllllllllIIIlIlIIllIIlIlllll);
                this.spikeGen.generate(lllllllllllllIIIlIlIIllIIlIlllIl, lllllllllllllIIIlIlIIllIIllIIIIl, new BlockPos(lllllllllllllIIIlIlIIllIIlIlllll.getCenterX(), 45, lllllllllllllIIIlIlIIllIIlIlllll.getCenterZ()));
            }
        }
    }
    
    static {
        SPIKE_CACHE = CacheBuilder.newBuilder().expireAfterWrite(5L, TimeUnit.MINUTES).build((CacheLoader)new SpikeCacheLoader(null));
    }
    
    public static WorldGenSpikes.EndSpike[] getSpikesForWorld(final World lllllllllllllIIIlIlIIllIIlIlIIll) {
        final Random lllllllllllllIIIlIlIIllIIlIlIIlI = new Random(lllllllllllllIIIlIlIIllIIlIlIIll.getSeed());
        final long lllllllllllllIIIlIlIIllIIlIlIIIl = lllllllllllllIIIlIlIIllIIlIlIIlI.nextLong() & 0xFFFFL;
        return (WorldGenSpikes.EndSpike[])BiomeEndDecorator.SPIKE_CACHE.getUnchecked((Object)lllllllllllllIIIlIlIIllIIlIlIIIl);
    }
    
    public BiomeEndDecorator() {
        this.spikeGen = new WorldGenSpikes();
    }
    
    static class SpikeCacheLoader extends CacheLoader<Long, WorldGenSpikes.EndSpike[]>
    {
        public WorldGenSpikes.EndSpike[] load(final Long lllllllllllllllIlIlllIlllIlIIllI) throws Exception {
            final List<Integer> lllllllllllllllIlIlllIlllIlIIlIl = (List<Integer>)Lists.newArrayList((Iterable)ContiguousSet.create(Range.closedOpen((Comparable)0, (Comparable)10), DiscreteDomain.integers()));
            Collections.shuffle(lllllllllllllllIlIlllIlllIlIIlIl, new Random(lllllllllllllllIlIlllIlllIlIIllI));
            final WorldGenSpikes.EndSpike[] lllllllllllllllIlIlllIlllIlIIlII = new WorldGenSpikes.EndSpike[10];
            for (int lllllllllllllllIlIlllIlllIlIIIll = 0; lllllllllllllllIlIlllIlllIlIIIll < 10; ++lllllllllllllllIlIlllIlllIlIIIll) {
                final int lllllllllllllllIlIlllIlllIlIIIlI = (int)(42.0 * Math.cos(2.0 * (-3.141592653589793 + 0.3141592653589793 * lllllllllllllllIlIlllIlllIlIIIll)));
                final int lllllllllllllllIlIlllIlllIlIIIIl = (int)(42.0 * Math.sin(2.0 * (-3.141592653589793 + 0.3141592653589793 * lllllllllllllllIlIlllIlllIlIIIll)));
                final int lllllllllllllllIlIlllIlllIlIIIII = lllllllllllllllIlIlllIlllIlIIlIl.get(lllllllllllllllIlIlllIlllIlIIIll);
                final int lllllllllllllllIlIlllIlllIIlllll = 2 + lllllllllllllllIlIlllIlllIlIIIII / 3;
                final int lllllllllllllllIlIlllIlllIIllllI = 76 + lllllllllllllllIlIlllIlllIlIIIII * 3;
                final boolean lllllllllllllllIlIlllIlllIIlllIl = lllllllllllllllIlIlllIlllIlIIIII == 1 || lllllllllllllllIlIlllIlllIlIIIII == 2;
                lllllllllllllllIlIlllIlllIlIIlII[lllllllllllllllIlIlllIlllIlIIIll] = new WorldGenSpikes.EndSpike(lllllllllllllllIlIlllIlllIlIIIlI, lllllllllllllllIlIlllIlllIlIIIIl, lllllllllllllllIlIlllIlllIIlllll, lllllllllllllllIlIlllIlllIIllllI, lllllllllllllllIlIlllIlllIIlllIl);
            }
            return lllllllllllllllIlIlllIlllIlIIlII;
        }
        
        private SpikeCacheLoader() {
        }
    }
}
