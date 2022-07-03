package net.minecraft.world.biome;

import java.util.*;
import it.unimi.dsi.fastutil.longs.*;
import com.google.common.collect.*;
import net.minecraft.server.*;

public class BiomeCache
{
    private final /* synthetic */ BiomeProvider chunkManager;
    private final /* synthetic */ List<Block> cache;
    private final /* synthetic */ Long2ObjectMap<Block> cacheMap;
    private /* synthetic */ long lastCleanupTime;
    
    public BiomeCache(final BiomeProvider lllllllllllllIlllIIIIIllllllIllI) {
        this.cacheMap = (Long2ObjectMap<Block>)new Long2ObjectOpenHashMap(4096);
        this.cache = (List<Block>)Lists.newArrayList();
        this.chunkManager = lllllllllllllIlllIIIIIllllllIllI;
    }
    
    public Biome getBiome(final int lllllllllllllIlllIIIIIllllIllIIl, final int lllllllllllllIlllIIIIIllllIlllIl, final Biome lllllllllllllIlllIIIIIllllIlIlll) {
        final Biome lllllllllllllIlllIIIIIllllIllIll = this.getBiomeCacheBlock(lllllllllllllIlllIIIIIllllIllIIl, lllllllllllllIlllIIIIIllllIlllIl).getBiome(lllllllllllllIlllIIIIIllllIllIIl, lllllllllllllIlllIIIIIllllIlllIl);
        return (lllllllllllllIlllIIIIIllllIllIll == null) ? lllllllllllllIlllIIIIIllllIlIlll : lllllllllllllIlllIIIIIllllIllIll;
    }
    
    public void cleanupCache() {
        final long lllllllllllllIlllIIIIIllllIIllIl = MinecraftServer.getCurrentTimeMillis();
        final long lllllllllllllIlllIIIIIllllIIllII = lllllllllllllIlllIIIIIllllIIllIl - this.lastCleanupTime;
        if (lllllllllllllIlllIIIIIllllIIllII > 7500L || lllllllllllllIlllIIIIIllllIIllII < 0L) {
            this.lastCleanupTime = lllllllllllllIlllIIIIIllllIIllIl;
            for (int lllllllllllllIlllIIIIIllllIIlIll = 0; lllllllllllllIlllIIIIIllllIIlIll < this.cache.size(); ++lllllllllllllIlllIIIIIllllIIlIll) {
                final Block lllllllllllllIlllIIIIIllllIIlIlI = this.cache.get(lllllllllllllIlllIIIIIllllIIlIll);
                final long lllllllllllllIlllIIIIIllllIIlIIl = lllllllllllllIlllIIIIIllllIIllIl - lllllllllllllIlllIIIIIllllIIlIlI.lastAccessTime;
                if (lllllllllllllIlllIIIIIllllIIlIIl > 30000L || lllllllllllllIlllIIIIIllllIIlIIl < 0L) {
                    this.cache.remove(lllllllllllllIlllIIIIIllllIIlIll--);
                    final long lllllllllllllIlllIIIIIllllIIlIII = ((long)lllllllllllllIlllIIIIIllllIIlIlI.xPosition & 0xFFFFFFFFL) | ((long)lllllllllllllIlllIIIIIllllIIlIlI.zPosition & 0xFFFFFFFFL) << 32;
                    this.cacheMap.remove(lllllllllllllIlllIIIIIllllIIlIII);
                }
            }
        }
    }
    
    public Biome[] getCachedBiomes(final int lllllllllllllIlllIIIIIlllIllllII, final int lllllllllllllIlllIIIIIlllIlllIII) {
        return this.getBiomeCacheBlock(lllllllllllllIlllIIIIIlllIllllII, lllllllllllllIlllIIIIIlllIlllIII).biomes;
    }
    
    public Block getBiomeCacheBlock(int lllllllllllllIlllIIIIIlllllIlIII, int lllllllllllllIlllIIIIIlllllIIlll) {
        lllllllllllllIlllIIIIIlllllIlIII >>= 4;
        lllllllllllllIlllIIIIIlllllIIlll >>= 4;
        final long lllllllllllllIlllIIIIIlllllIlIll = ((long)lllllllllllllIlllIIIIIlllllIlIII & 0xFFFFFFFFL) | ((long)lllllllllllllIlllIIIIIlllllIIlll & 0xFFFFFFFFL) << 32;
        Block lllllllllllllIlllIIIIIlllllIlIlI = (Block)this.cacheMap.get(lllllllllllllIlllIIIIIlllllIlIll);
        if (lllllllllllllIlllIIIIIlllllIlIlI == null) {
            lllllllllllllIlllIIIIIlllllIlIlI = new Block(lllllllllllllIlllIIIIIlllllIlIII, (int)lllllllllllllIlllIIIIIlllllIIlll);
            this.cacheMap.put(lllllllllllllIlllIIIIIlllllIlIll, (Object)lllllllllllllIlllIIIIIlllllIlIlI);
            this.cache.add(lllllllllllllIlllIIIIIlllllIlIlI);
        }
        lllllllllllllIlllIIIIIlllllIlIlI.lastAccessTime = MinecraftServer.getCurrentTimeMillis();
        return lllllllllllllIlllIIIIIlllllIlIlI;
    }
    
    public class Block
    {
        public /* synthetic */ long lastAccessTime;
        public /* synthetic */ int xPosition;
        public /* synthetic */ int zPosition;
        public /* synthetic */ Biome[] biomes;
        
        public Block(final int lllllllllllllIIllIIlIIllIIIlIlII, final int lllllllllllllIIllIIlIIllIIIlIIll) {
            this.biomes = new Biome[256];
            this.xPosition = lllllllllllllIIllIIlIIllIIIlIlII;
            this.zPosition = lllllllllllllIIllIIlIIllIIIlIIll;
            BiomeCache.this.chunkManager.getBiomes(this.biomes, lllllllllllllIIllIIlIIllIIIlIlII << 4, lllllllllllllIIllIIlIIllIIIlIIll << 4, 16, 16, false);
        }
        
        public Biome getBiome(final int lllllllllllllIIllIIlIIllIIIIlllI, final int lllllllllllllIIllIIlIIllIIIIlIlI) {
            return this.biomes[(lllllllllllllIIllIIlIIllIIIIlllI & 0xF) | (lllllllllllllIIllIIlIIllIIIIlIlI & 0xF) << 4];
        }
    }
}
