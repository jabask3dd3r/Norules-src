package com.viaversion.viaversion.protocols.protocol1_13to1_12_2.blockconnections.providers;

import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.storage.*;

public class PacketBlockConnectionProvider extends BlockConnectionProvider
{
    @Override
    public void clearStorage(final UserConnection llllllllllllllIIIlllIllIlllIIIII) {
        llllllllllllllIIIlllIllIlllIIIII.get(BlockConnectionStorage.class).clear();
    }
    
    @Override
    public void removeBlock(final UserConnection llllllllllllllIIIlllIllIlllllIII, final int llllllllllllllIIIlllIllIllllIlll, final int llllllllllllllIIIlllIllIllllIllI, final int llllllllllllllIIIlllIllIllllIIIl) {
        llllllllllllllIIIlllIllIlllllIII.get(BlockConnectionStorage.class).remove(llllllllllllllIIIlllIllIllllIlll, llllllllllllllIIIlllIllIllllIllI, llllllllllllllIIIlllIllIllllIIIl);
    }
    
    @Override
    public boolean storesBlocks() {
        return true;
    }
    
    @Override
    public void storeBlock(final UserConnection llllllllllllllIIIlllIlllIIIIIIlI, final int llllllllllllllIIIlllIlllIIIIIllI, final int llllllllllllllIIIlllIlllIIIIIIII, final int llllllllllllllIIIlllIllIllllllll, final int llllllllllllllIIIlllIllIlllllllI) {
        llllllllllllllIIIlllIlllIIIIIIlI.get(BlockConnectionStorage.class).store(llllllllllllllIIIlllIlllIIIIIllI, llllllllllllllIIIlllIlllIIIIIIII, llllllllllllllIIIlllIllIllllllll, llllllllllllllIIIlllIllIlllllllI);
    }
    
    @Override
    public int getBlockData(final UserConnection llllllllllllllIIIlllIllIlllIlIll, final int llllllllllllllIIIlllIllIlllIlIlI, final int llllllllllllllIIIlllIllIlllIIlIl, final int llllllllllllllIIIlllIllIlllIIlII) {
        return llllllllllllllIIIlllIllIlllIlIll.get(BlockConnectionStorage.class).get(llllllllllllllIIIlllIllIlllIlIlI, llllllllllllllIIIlllIllIlllIIlIl, llllllllllllllIIIlllIllIlllIIlII);
    }
    
    @Override
    public void unloadChunk(final UserConnection llllllllllllllIIIlllIllIllIllIll, final int llllllllllllllIIIlllIllIllIllIlI, final int llllllllllllllIIIlllIllIllIllIIl) {
        llllllllllllllIIIlllIllIllIllIll.get(BlockConnectionStorage.class).unloadChunk(llllllllllllllIIIlllIllIllIllIlI, llllllllllllllIIIlllIllIllIllIIl);
    }
}
