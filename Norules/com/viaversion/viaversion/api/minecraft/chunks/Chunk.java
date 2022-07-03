package com.viaversion.viaversion.api.minecraft.chunks;

import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import java.util.*;

public interface Chunk
{
    boolean isFullChunk();
    
    boolean isIgnoreOldLightData();
    
    void setSections(final ChunkSection[] p0);
    
    BitSet getChunkMask();
    
    ChunkSection[] getSections();
    
    void setIgnoreOldLightData(final boolean p0);
    
    void setBiomeData(final int[] p0);
    
    boolean isBiomeData();
    
    int getZ();
    
    void setHeightMap(final CompoundTag p0);
    
    int getX();
    
    int getBitmask();
    
    int[] getBiomeData();
    
    void setBitmask(final int p0);
    
    List<CompoundTag> getBlockEntities();
    
    void setChunkMask(final BitSet p0);
    
    CompoundTag getHeightMap();
}
