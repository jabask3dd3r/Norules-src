package com.viaversion.viaversion.protocols.protocol1_13to1_12_2.blockconnections.providers;

import com.viaversion.viaversion.api.platform.providers.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.*;

public class BlockConnectionProvider implements Provider
{
    public int getBlockData(final UserConnection lllllllllllllIIlIIlIIlIllIllIIll, final int lllllllllllllIIlIIlIIlIllIlIllII, final int lllllllllllllIIlIIlIIlIllIllIIIl, final int lllllllllllllIIlIIlIIlIllIllIIII) {
        final int lllllllllllllIIlIIlIIlIllIlIllll = this.getWorldBlockData(lllllllllllllIIlIIlIIlIllIllIIll, lllllllllllllIIlIIlIIlIllIlIllII, lllllllllllllIIlIIlIIlIllIllIIIl, lllllllllllllIIlIIlIIlIllIllIIII);
        return Protocol1_13To1_12_2.MAPPINGS.getBlockMappings().getNewId(lllllllllllllIIlIIlIIlIllIlIllll);
    }
    
    public void clearStorage(final UserConnection lllllllllllllIIlIIlIIlIllIIlIlll) {
    }
    
    public void storeBlock(final UserConnection lllllllllllllIIlIIlIIlIllIlIIIlI, final int lllllllllllllIIlIIlIIlIllIlIIIIl, final int lllllllllllllIIlIIlIIlIllIlIIIII, final int lllllllllllllIIlIIlIIlIllIIlllll, final int lllllllllllllIIlIIlIIlIllIIllllI) {
    }
    
    public boolean storesBlocks() {
        return false;
    }
    
    public int getWorldBlockData(final UserConnection lllllllllllllIIlIIlIIlIllIlIIlll, final int lllllllllllllIIlIIlIIlIllIlIIllI, final int lllllllllllllIIlIIlIIlIllIlIIlIl, final int lllllllllllllIIlIIlIIlIllIlIIlII) {
        return -1;
    }
    
    public void unloadChunk(final UserConnection lllllllllllllIIlIIlIIlIllIIlIlIl, final int lllllllllllllIIlIIlIIlIllIIlIlII, final int lllllllllllllIIlIIlIIlIllIIlIIll) {
    }
    
    public void removeBlock(final UserConnection lllllllllllllIIlIIlIIlIllIIlllII, final int lllllllllllllIIlIIlIIlIllIIllIll, final int lllllllllllllIIlIIlIIlIllIIllIlI, final int lllllllllllllIIlIIlIIlIllIIllIIl) {
    }
}
