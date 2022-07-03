package com.viaversion.viaversion.api.minecraft.chunks;

import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import java.util.*;

public class BaseChunk implements Chunk
{
    protected final /* synthetic */ boolean fullChunk;
    protected final /* synthetic */ List<CompoundTag> blockEntities;
    protected final /* synthetic */ int x;
    protected final /* synthetic */ int z;
    protected /* synthetic */ int bitmask;
    protected /* synthetic */ BitSet chunkSectionBitSet;
    protected /* synthetic */ int[] biomeData;
    protected /* synthetic */ boolean ignoreOldLightData;
    protected /* synthetic */ CompoundTag heightMap;
    protected /* synthetic */ ChunkSection[] sections;
    
    @Override
    public boolean isFullChunk() {
        return this.fullChunk;
    }
    
    @Override
    public int getBitmask() {
        return this.bitmask;
    }
    
    @Override
    public void setChunkMask(final BitSet lllllllllllllIlIIlIIIllllIlIIlIl) {
        this.chunkSectionBitSet = lllllllllllllIlIIlIIIllllIlIIlIl;
    }
    
    @Override
    public ChunkSection[] getSections() {
        return this.sections;
    }
    
    @Override
    public int getZ() {
        return this.z;
    }
    
    public BaseChunk(final int lllllllllllllIlIIlIIIlllllIlllII, final int lllllllllllllIlIIlIIIlllllIlIIlI, final boolean lllllllllllllIlIIlIIIlllllIllIlI, final boolean lllllllllllllIlIIlIIIlllllIllIIl, final int lllllllllllllIlIIlIIIlllllIllIII, final ChunkSection[] lllllllllllllIlIIlIIIlllllIlIlll, final int[] lllllllllllllIlIIlIIIlllllIIllIl, final List<CompoundTag> lllllllllllllIlIIlIIIlllllIIllII) {
        this(lllllllllllllIlIIlIIIlllllIlllII, lllllllllllllIlIIlIIIlllllIlIIlI, lllllllllllllIlIIlIIIlllllIllIlI, lllllllllllllIlIIlIIIlllllIllIIl, lllllllllllllIlIIlIIIlllllIllIII, lllllllllllllIlIIlIIIlllllIlIlll, lllllllllllllIlIIlIIIlllllIIllIl, null, lllllllllllllIlIIlIIIlllllIIllII);
    }
    
    public BaseChunk(final int lllllllllllllIlIIlIIIllllllllIIl, final int lllllllllllllIlIIlIIIllllllllIII, final boolean lllllllllllllIlIIlIIIlllllllIlll, final boolean lllllllllllllIlIIlIIIllllllIllII, final int lllllllllllllIlIIlIIIlllllllIlIl, final ChunkSection[] lllllllllllllIlIIlIIIllllllIlIlI, final int[] lllllllllllllIlIIlIIIllllllIlIIl, final CompoundTag lllllllllllllIlIIlIIIllllllIlIII, final List<CompoundTag> lllllllllllllIlIIlIIIlllllllIIIl) {
        this(lllllllllllllIlIIlIIIllllllllIIl, lllllllllllllIlIIlIIIllllllllIII, lllllllllllllIlIIlIIIlllllllIlll, lllllllllllllIlIIlIIIllllllIllII, null, lllllllllllllIlIIlIIIllllllIlIlI, lllllllllllllIlIIlIIIllllllIlIIl, lllllllllllllIlIIlIIIllllllIlIII, lllllllllllllIlIIlIIIlllllllIIIl);
        this.bitmask = lllllllllllllIlIIlIIIlllllllIlIl;
    }
    
    @Override
    public boolean isIgnoreOldLightData() {
        return this.ignoreOldLightData;
    }
    
    @Override
    public int getX() {
        return this.x;
    }
    
    @Override
    public void setHeightMap(final CompoundTag lllllllllllllIlIIlIIIllllIIIllII) {
        this.heightMap = lllllllllllllIlIIlIIIllllIIIllII;
    }
    
    @Override
    public BitSet getChunkMask() {
        return this.chunkSectionBitSet;
    }
    
    @Override
    public void setIgnoreOldLightData(final boolean lllllllllllllIlIIlIIIllllIllIlll) {
        this.ignoreOldLightData = lllllllllllllIlIIlIIIllllIllIlll;
    }
    
    @Override
    public List<CompoundTag> getBlockEntities() {
        return this.blockEntities;
    }
    
    @Override
    public void setBiomeData(final int[] lllllllllllllIlIIlIIIllllIIlIlIl) {
        this.biomeData = lllllllllllllIlIIlIIIllllIIlIlIl;
    }
    
    @Override
    public int[] getBiomeData() {
        return this.biomeData;
    }
    
    @Override
    public boolean isBiomeData() {
        return this.biomeData != null;
    }
    
    public BaseChunk(final int lllllllllllllIlIIlIIlIIIIIIlIlll, final int lllllllllllllIlIIlIIlIIIIIIlIllI, final boolean lllllllllllllIlIIlIIlIIIIIIIlIll, final boolean lllllllllllllIlIIlIIlIIIIIIlIlII, final BitSet lllllllllllllIlIIlIIlIIIIIIIlIIl, final ChunkSection[] lllllllllllllIlIIlIIlIIIIIIlIIlI, final int[] lllllllllllllIlIIlIIlIIIIIIIIlll, final CompoundTag lllllllllllllIlIIlIIlIIIIIIIIllI, final List<CompoundTag> lllllllllllllIlIIlIIlIIIIIIIllll) {
        this.x = lllllllllllllIlIIlIIlIIIIIIlIlll;
        this.z = lllllllllllllIlIIlIIlIIIIIIlIllI;
        this.fullChunk = lllllllllllllIlIIlIIlIIIIIIIlIll;
        this.ignoreOldLightData = lllllllllllllIlIIlIIlIIIIIIlIlII;
        this.chunkSectionBitSet = lllllllllllllIlIIlIIlIIIIIIIlIIl;
        this.sections = lllllllllllllIlIIlIIlIIIIIIlIIlI;
        this.biomeData = lllllllllllllIlIIlIIlIIIIIIIIlll;
        this.heightMap = lllllllllllllIlIIlIIlIIIIIIIIllI;
        this.blockEntities = lllllllllllllIlIIlIIlIIIIIIIllll;
    }
    
    @Override
    public void setSections(final ChunkSection[] lllllllllllllIlIIlIIIllllIIlllII) {
        this.sections = lllllllllllllIlIIlIIIllllIIlllII;
    }
    
    @Override
    public void setBitmask(final int lllllllllllllIlIIlIIIllllIllIIII) {
        this.bitmask = lllllllllllllIlIIlIIIllllIllIIII;
    }
    
    @Override
    public CompoundTag getHeightMap() {
        return this.heightMap;
    }
}
