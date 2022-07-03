package com.viaversion.viaversion.api.minecraft.chunks;

public interface ChunkSection
{
    default void setBlockWithData(final int llllllllllllllIIIlIIIIlIIllIlllI, final int llllllllllllllIIIlIIIIlIIllIIlll, final int llllllllllllllIIIlIIIIlIIllIllII, final int llllllllllllllIIIlIIIIlIIllIIlIl, final int llllllllllllllIIIlIIIIlIIllIlIlI) {
        this.setFlatBlock(index(llllllllllllllIIIlIIIIlIIllIlllI, llllllllllllllIIIlIIIIlIIllIIlll, llllllllllllllIIIlIIIIlIIllIllII), llllllllllllllIIIlIIIIlIIllIIlIl << 4 | (llllllllllllllIIIlIIIIlIIllIlIlI & 0xF));
    }
    
    void clearPalette();
    
    default void setBlockWithData(final int llllllllllllllIIIlIIIIlIIlIllIlI, final int llllllllllllllIIIlIIIIlIIlIllIIl, final int llllllllllllllIIIlIIIIlIIlIllIII) {
        this.setFlatBlock(llllllllllllllIIIlIIIIlIIlIllIlI, llllllllllllllIIIlIIIIlIIlIllIIl << 4 | (llllllllllllllIIIlIIIIlIIlIllIII & 0xF));
    }
    
    void setLight(final ChunkSectionLight p0);
    
    void setPaletteEntry(final int p0, final int p1);
    
    default void setFlatBlock(final int llllllllllllllIIIlIIIIlIlIIlIllI, final int llllllllllllllIIIlIIIIlIlIIlIlIl, final int llllllllllllllIIIlIIIIlIlIIlIlII, final int llllllllllllllIIIlIIIIlIlIIlIIll) {
        this.setFlatBlock(index(llllllllllllllIIIlIIIIlIlIIlIllI, llllllllllllllIIIlIIIIlIlIIlIlIl, llllllllllllllIIIlIIIIlIlIIlIlII), llllllllllllllIIIlIIIIlIlIIlIIll);
    }
    
    default int getBlockWithoutData(final int llllllllllllllIIIlIIIIlIlIIIlIII, final int llllllllllllllIIIlIIIIlIlIIIIIll, final int llllllllllllllIIIlIIIIlIlIIIIllI) {
        return this.getFlatBlock(llllllllllllllIIIlIIIIlIlIIIlIII, llllllllllllllIIIlIIIIlIlIIIIIll, llllllllllllllIIIlIIIIlIlIIIIllI) >> 4;
    }
    
    int getPaletteSize();
    
    void replacePaletteEntry(final int p0, final int p1);
    
    void setNonAirBlocksCount(final int p0);
    
    void addPaletteEntry(final int p0);
    
    default int getFlatBlock(final int llllllllllllllIIIlIIIIlIlIlIIIll, final int llllllllllllllIIIlIIIIlIlIIllllI, final int llllllllllllllIIIlIIIIlIlIlIIIIl) {
        return this.getFlatBlock(index(llllllllllllllIIIlIIIIlIlIlIIIll, llllllllllllllIIIlIIIIlIlIIllllI, llllllllllllllIIIlIIIIlIlIlIIIIl));
    }
    
    ChunkSectionLight getLight();
    
    int getFlatBlock(final int p0);
    
    void setFlatBlock(final int p0, final int p1);
    
    int getPaletteEntry(final int p0);
    
    int getNonAirBlocksCount();
    
    default boolean hasLight() {
        return this.getLight() != null;
    }
    
    int getPaletteIndex(final int p0);
    
    void setPaletteIndex(final int p0, final int p1);
    
    default int index(final int llllllllllllllIIIlIIIIlIlIlIlIll, final int llllllllllllllIIIlIIIIlIlIlIllIl, final int llllllllllllllIIIlIIIIlIlIlIllII) {
        return llllllllllllllIIIlIIIIlIlIlIllIl << 8 | llllllllllllllIIIlIIIIlIlIlIllII << 4 | llllllllllllllIIIlIIIIlIlIlIlIll;
    }
    
    default int getBlockData(final int llllllllllllllIIIlIIIIlIIlllllII, final int llllllllllllllIIIlIIIIlIIllllIll, final int llllllllllllllIIIlIIIIlIIllllIlI) {
        return this.getFlatBlock(llllllllllllllIIIlIIIIlIIlllllII, llllllllllllllIIIlIIIIlIIllllIll, llllllllllllllIIIlIIIIlIIllllIlI) & 0xF;
    }
}
