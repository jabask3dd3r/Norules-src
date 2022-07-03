package com.viaversion.viaversion.protocols.protocol1_9to1_8.storage;

import java.util.*;
import com.viaversion.viaversion.api.connection.*;
import com.google.common.collect.*;

public class ClientChunks extends StoredObject
{
    private final /* synthetic */ Set<Long> loadedChunks;
    private final /* synthetic */ Set<Long> bulkChunks;
    
    public Set<Long> getBulkChunks() {
        return this.bulkChunks;
    }
    
    public Set<Long> getLoadedChunks() {
        return this.loadedChunks;
    }
    
    public ClientChunks(final UserConnection lllllllllllllllIlIIlIIIIllIIllIl) {
        super(lllllllllllllllIlIIlIIIIllIIllIl);
        this.loadedChunks = (Set<Long>)Sets.newConcurrentHashSet();
        this.bulkChunks = (Set<Long>)Sets.newConcurrentHashSet();
    }
    
    public static long toLong(final int lllllllllllllllIlIIlIIIIllIIlIlI, final int lllllllllllllllIlIIlIIIIllIIlIIl) {
        return ((long)lllllllllllllllIlIIlIIIIllIIlIlI << 32) + lllllllllllllllIlIIlIIIIllIIlIIl + 2147483648L;
    }
}
