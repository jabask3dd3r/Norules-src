package com.viaversion.viaversion.api.minecraft.chunks;

import com.viaversion.viaversion.libs.fastutil.ints.*;

public class ChunkSectionImpl implements ChunkSection
{
    private /* synthetic */ ChunkSectionLight light;
    private final /* synthetic */ Int2IntMap inversePalette;
    private final /* synthetic */ IntList palette;
    private /* synthetic */ int nonAirBlocksCount;
    private final /* synthetic */ int[] blocks;
    
    @Override
    public int getPaletteEntry(final int lllllllllllllllIllIllIlllIllIlIl) {
        return this.palette.getInt(lllllllllllllllIllIllIlllIllIlIl);
    }
    
    @Override
    public void replacePaletteEntry(final int lllllllllllllllIllIllIlllIIIlIll, final int lllllllllllllllIllIllIlllIIIIllI) {
        final int lllllllllllllllIllIllIlllIIIlIIl = this.inversePalette.remove(lllllllllllllllIllIllIlllIIIlIll);
        if (lllllllllllllllIllIllIlllIIIlIIl == -1) {
            return;
        }
        this.inversePalette.put(lllllllllllllllIllIllIlllIIIIllI, lllllllllllllllIllIllIlllIIIlIIl);
        for (int lllllllllllllllIllIllIlllIIIllIl = 0; lllllllllllllllIllIllIlllIIIllIl < this.palette.size(); ++lllllllllllllllIllIllIlllIIIllIl) {
            if (this.palette.getInt(lllllllllllllllIllIllIlllIIIllIl) == lllllllllllllllIllIllIlllIIIlIll) {
                this.palette.set(lllllllllllllllIllIllIlllIIIllIl, lllllllllllllllIllIllIlllIIIIllI);
            }
        }
    }
    
    @Override
    public void addPaletteEntry(final int lllllllllllllllIllIllIllIllllllI) {
        this.inversePalette.put(lllllllllllllllIllIllIllIllllllI, this.palette.size());
        this.palette.add(lllllllllllllllIllIllIllIllllllI);
    }
    
    @Override
    public ChunkSectionLight getLight() {
        return this.light;
    }
    
    public ChunkSectionImpl(final boolean lllllllllllllllIllIllIlllllIlIIl) {
        this.blocks = new int[4096];
        this.palette = new IntArrayList();
        this.inversePalette = new Int2IntOpenHashMap();
        this.inversePalette.defaultReturnValue(-1);
        if (lllllllllllllllIllIllIlllllIlIIl) {
            this.light = new ChunkSectionLightImpl();
        }
    }
    
    @Override
    public void setNonAirBlocksCount(final int lllllllllllllllIllIllIllIlllIlII) {
        this.nonAirBlocksCount = lllllllllllllllIllIllIllIlllIlII;
    }
    
    public ChunkSectionImpl(final boolean lllllllllllllllIllIllIlllllIIIIl, final int lllllllllllllllIllIllIlllllIIIII) {
        this.blocks = new int[4096];
        if (lllllllllllllllIllIllIlllllIIIIl) {
            this.light = new ChunkSectionLightImpl();
        }
        this.palette = new IntArrayList(lllllllllllllllIllIllIlllllIIIII);
        this.inversePalette = new Int2IntOpenHashMap(lllllllllllllllIllIllIlllllIIIII);
        this.inversePalette.defaultReturnValue(-1);
    }
    
    @Override
    public int getPaletteIndex(final int lllllllllllllllIllIllIllllIIIlll) {
        return this.blocks[lllllllllllllllIllIllIllllIIIlll];
    }
    
    @Override
    public int getFlatBlock(final int lllllllllllllllIllIllIllllIllIII) {
        final int lllllllllllllllIllIllIllllIllIlI = this.blocks[lllllllllllllllIllIllIllllIllIII];
        return this.palette.getInt(lllllllllllllllIllIllIllllIllIlI);
    }
    
    @Override
    public void setFlatBlock(final int lllllllllllllllIllIllIllllIIllIl, final int lllllllllllllllIllIllIllllIIllII) {
        int lllllllllllllllIllIllIllllIIllll = this.inversePalette.get(lllllllllllllllIllIllIllllIIllII);
        if (lllllllllllllllIllIllIllllIIllll == -1) {
            lllllllllllllllIllIllIllllIIllll = this.palette.size();
            this.palette.add(lllllllllllllllIllIllIllllIIllII);
            this.inversePalette.put(lllllllllllllllIllIllIllllIIllII, lllllllllllllllIllIllIllllIIllll);
        }
        this.blocks[lllllllllllllllIllIllIllllIIllIl] = lllllllllllllllIllIllIllllIIllll;
    }
    
    @Override
    public void setLight(final ChunkSectionLight lllllllllllllllIllIllIllIllIlIIl) {
        this.light = lllllllllllllllIllIllIllIllIlIIl;
    }
    
    @Override
    public int getPaletteSize() {
        return this.palette.size();
    }
    
    @Override
    public int getNonAirBlocksCount() {
        return this.nonAirBlocksCount;
    }
    
    @Override
    public void setPaletteIndex(final int lllllllllllllllIllIllIlllIllllIl, final int lllllllllllllllIllIllIlllIllllII) {
        this.blocks[lllllllllllllllIllIllIlllIllllIl] = lllllllllllllllIllIllIlllIllllII;
    }
    
    @Override
    public void clearPalette() {
        this.palette.clear();
        this.inversePalette.clear();
    }
    
    @Override
    public void setPaletteEntry(final int lllllllllllllllIllIllIlllIlIlIlI, final int lllllllllllllllIllIllIlllIlIIIII) {
        final int lllllllllllllllIllIllIlllIlIIlll = this.palette.set(lllllllllllllllIllIllIlllIlIlIlI, lllllllllllllllIllIllIlllIlIIIII);
        if (lllllllllllllllIllIllIlllIlIIlll == lllllllllllllllIllIllIlllIlIIIII) {
            return;
        }
        this.inversePalette.put(lllllllllllllllIllIllIlllIlIIIII, lllllllllllllllIllIllIlllIlIlIlI);
        if (this.inversePalette.get(lllllllllllllllIllIllIlllIlIIlll) == lllllllllllllllIllIllIlllIlIlIlI) {
            this.inversePalette.remove(lllllllllllllllIllIllIlllIlIIlll);
            for (int lllllllllllllllIllIllIlllIlIllIl = 0; lllllllllllllllIllIllIlllIlIllIl < this.palette.size(); ++lllllllllllllllIllIllIlllIlIllIl) {
                if (this.palette.getInt(lllllllllllllllIllIllIlllIlIllIl) == lllllllllllllllIllIllIlllIlIIlll) {
                    this.inversePalette.put(lllllllllllllllIllIllIlllIlIIlll, lllllllllllllllIllIllIlllIlIllIl);
                    break;
                }
            }
        }
    }
}
