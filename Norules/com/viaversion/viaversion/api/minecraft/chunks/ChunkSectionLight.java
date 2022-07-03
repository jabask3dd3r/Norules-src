package com.viaversion.viaversion.api.minecraft.chunks;

import io.netty.buffer.*;

public interface ChunkSectionLight
{
    void readSkyLight(final ByteBuf p0);
    
    void readBlockLight(final ByteBuf p0);
    
    NibbleArray getSkyLightNibbleArray();
    
    byte[] getSkyLight();
    
    boolean hasSkyLight();
    
    void writeSkyLight(final ByteBuf p0);
    
    void setSkyLight(final byte[] p0);
    
    byte[] getBlockLight();
    
    void setBlockLight(final byte[] p0);
    
    NibbleArray getBlockLightNibbleArray();
    
    boolean hasBlockLight();
    
    void writeBlockLight(final ByteBuf p0);
}
