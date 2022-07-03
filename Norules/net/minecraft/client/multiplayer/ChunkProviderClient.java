package net.minecraft.client.multiplayer;

import net.minecraft.world.*;
import net.minecraft.util.math.*;
import javax.annotation.*;
import com.google.common.base.*;
import it.unimi.dsi.fastutil.longs.*;
import net.minecraft.world.chunk.*;
import org.apache.logging.log4j.*;
import it.unimi.dsi.fastutil.objects.*;

public class ChunkProviderClient implements IChunkProvider
{
    private static final /* synthetic */ Logger LOGGER;
    private final /* synthetic */ Long2ObjectMap<Chunk> chunkMapping;
    private final /* synthetic */ World worldObj;
    private final /* synthetic */ Chunk blankChunk;
    
    @Nullable
    @Override
    public Chunk getLoadedChunk(final int lllllllllllllllIIlIIIIllIlIIlIll, final int lllllllllllllllIIlIIIIllIlIIIlll) {
        return (Chunk)this.chunkMapping.get(ChunkPos.asLong(lllllllllllllllIIlIIIIllIlIIlIll, lllllllllllllllIIlIIIIllIlIIIlll));
    }
    
    @Override
    public Chunk provideChunk(final int lllllllllllllllIIlIIIIllIIllIllI, final int lllllllllllllllIIlIIIIllIIllIlIl) {
        return (Chunk)MoreObjects.firstNonNull((Object)this.getLoadedChunk(lllllllllllllllIIlIIIIllIIllIllI, lllllllllllllllIIlIIIIllIIllIlIl), (Object)this.blankChunk);
    }
    
    @Override
    public boolean func_191062_e(final int lllllllllllllllIIlIIIIllIIIllIll, final int lllllllllllllllIIlIIIIllIIIllIlI) {
        return this.chunkMapping.containsKey(ChunkPos.asLong(lllllllllllllllIIlIIIIllIIIllIll, lllllllllllllllIIlIIIIllIIIllIlI));
    }
    
    public ChunkProviderClient(final World lllllllllllllllIIlIIIIllIlIlllII) {
        this.chunkMapping = (Long2ObjectMap<Chunk>)new Long2ObjectOpenHashMap<Chunk>(8192) {
            protected void rehash(final int lllllllllllllIIlIllIllIIlllIlllI) {
                if (lllllllllllllIIlIllIllIIlllIlllI > this.key.length) {
                    super.rehash(lllllllllllllIIlIllIllIIlllIlllI);
                }
            }
        };
        this.blankChunk = new EmptyChunk(lllllllllllllllIIlIIIIllIlIlllII, 0, 0);
        this.worldObj = lllllllllllllllIIlIIIIllIlIlllII;
    }
    
    public Chunk loadChunk(final int lllllllllllllllIIlIIIIllIlIIIIIl, final int lllllllllllllllIIlIIIIllIlIIIIII) {
        final Chunk lllllllllllllllIIlIIIIllIIllllll = new Chunk(this.worldObj, lllllllllllllllIIlIIIIllIlIIIIIl, lllllllllllllllIIlIIIIllIlIIIIII);
        this.chunkMapping.put(ChunkPos.asLong(lllllllllllllllIIlIIIIllIlIIIIIl, lllllllllllllllIIlIIIIllIlIIIIII), (Object)lllllllllllllllIIlIIIIllIIllllll);
        lllllllllllllllIIlIIIIllIIllllll.setChunkLoaded(true);
        return lllllllllllllllIIlIIIIllIIllllll;
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    @Override
    public String makeString() {
        return String.valueOf(new StringBuilder("MultiplayerChunkCache: ").append(this.chunkMapping.size()).append(", ").append(this.chunkMapping.size()));
    }
    
    public void unloadChunk(final int lllllllllllllllIIlIIIIllIlIlIIlI, final int lllllllllllllllIIlIIIIllIlIlIlIl) {
        final Chunk lllllllllllllllIIlIIIIllIlIlIlII = this.provideChunk(lllllllllllllllIIlIIIIllIlIlIIlI, lllllllllllllllIIlIIIIllIlIlIlIl);
        if (!lllllllllllllllIIlIIIIllIlIlIlII.isEmpty()) {
            lllllllllllllllIIlIIIIllIlIlIlII.onChunkUnload();
        }
        this.chunkMapping.remove(ChunkPos.asLong(lllllllllllllllIIlIIIIllIlIlIIlI, lllllllllllllllIIlIIIIllIlIlIlIl));
    }
    
    @Override
    public boolean unloadQueuedChunks() {
        final long lllllllllllllllIIlIIIIllIIlIllII = System.currentTimeMillis();
        for (final Chunk lllllllllllllllIIlIIIIllIIlIlIlI : this.chunkMapping.values()) {
            lllllllllllllllIIlIIIIllIIlIlIlI.onTick(System.currentTimeMillis() - lllllllllllllllIIlIIIIllIIlIllII > 5L);
        }
        if (System.currentTimeMillis() - lllllllllllllllIIlIIIIllIIlIllII > 100L) {
            ChunkProviderClient.LOGGER.info("Warning: Clientside chunk ticking took {} ms", (Object)(System.currentTimeMillis() - lllllllllllllllIIlIIIIllIIlIllII));
        }
        return false;
    }
}
