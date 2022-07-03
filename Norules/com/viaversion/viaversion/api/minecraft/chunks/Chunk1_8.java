package com.viaversion.viaversion.api.minecraft.chunks;

import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import java.util.*;

public class Chunk1_8 extends BaseChunk
{
    private /* synthetic */ boolean unloadPacket;
    
    public Chunk1_8(final int llllllllllllIllllllIIllllllllIll, final int llllllllllllIllllllIlIIIIIIIIIlI, final boolean llllllllllllIllllllIlIIIIIIIIIIl, final int llllllllllllIllllllIlIIIIIIIIIII, final ChunkSection[] llllllllllllIllllllIIlllllllllll, final int[] llllllllllllIllllllIIlllllllIllI, final List<CompoundTag> llllllllllllIllllllIIlllllllllIl) {
        super(llllllllllllIllllllIIllllllllIll, llllllllllllIllllllIlIIIIIIIIIlI, llllllllllllIllllllIlIIIIIIIIIIl, false, llllllllllllIllllllIlIIIIIIIIIII, llllllllllllIllllllIIlllllllllll, llllllllllllIllllllIIlllllllIllI, llllllllllllIllllllIIlllllllllIl);
    }
    
    public boolean hasBiomeData() {
        return this.biomeData != null && this.fullChunk;
    }
    
    public Chunk1_8(final int llllllllllllIllllllIIllllllIllIl, final int llllllllllllIllllllIIllllllIllII) {
        this(llllllllllllIllllllIIllllllIllIl, llllllllllllIllllllIIllllllIllII, true, 0, new ChunkSection[16], null, new ArrayList<CompoundTag>());
        this.unloadPacket = true;
    }
    
    public boolean isUnloadPacket() {
        return this.unloadPacket;
    }
}
