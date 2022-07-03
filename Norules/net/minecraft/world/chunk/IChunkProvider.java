package net.minecraft.world.chunk;

import javax.annotation.*;

public interface IChunkProvider
{
    boolean func_191062_e(final int p0, final int p1);
    
    boolean unloadQueuedChunks();
    
    Chunk provideChunk(final int p0, final int p1);
    
    String makeString();
    
    @Nullable
    Chunk getLoadedChunk(final int p0, final int p1);
}
