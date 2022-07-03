package net.minecraft.world.chunk.storage;

import net.minecraft.world.chunk.*;
import java.io.*;
import net.minecraft.world.*;
import javax.annotation.*;

public interface IChunkLoader
{
    boolean func_191063_a(final int p0, final int p1);
    
    void saveChunk(final World p0, final Chunk p1) throws IOException, MinecraftException;
    
    @Nullable
    Chunk loadChunk(final World p0, final int p1, final int p2) throws IOException;
    
    void saveExtraData();
    
    void saveExtraChunkData(final World p0, final Chunk p1) throws IOException;
    
    void chunkTick();
}
