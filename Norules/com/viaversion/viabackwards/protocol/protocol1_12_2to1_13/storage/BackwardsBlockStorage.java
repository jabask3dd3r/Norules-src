package com.viaversion.viabackwards.protocol.protocol1_12_2to1_13.storage;

import com.viaversion.viaversion.api.connection.*;
import java.util.*;
import com.viaversion.viaversion.api.minecraft.*;
import java.util.concurrent.*;
import com.viaversion.viaversion.libs.fastutil.ints.*;

public class BackwardsBlockStorage implements StorableObject
{
    private final /* synthetic */ Map<Position, Integer> blocks;
    private static final /* synthetic */ IntSet WHITELIST;
    
    public BackwardsBlockStorage() {
        this.blocks = new ConcurrentHashMap<Position, Integer>();
    }
    
    public Map<Position, Integer> getBlocks() {
        return this.blocks;
    }
    
    public void checkAndStore(final Position llllllllllllllIlIllIIIlllIIIIIIl, final int llllllllllllllIlIllIIIlllIIIIIll) {
        if (!BackwardsBlockStorage.WHITELIST.contains(llllllllllllllIlIllIIIlllIIIIIll)) {
            this.blocks.remove(llllllllllllllIlIllIIIlllIIIIIIl);
            return;
        }
        this.blocks.put(llllllllllllllIlIllIIIlllIIIIIIl, llllllllllllllIlIllIIIlllIIIIIll);
    }
    
    static {
        WHITELIST = new IntOpenHashSet(779);
        for (int llllllllllllllIlIllIIIllIllIlIII = 5265; llllllllllllllIlIllIIIllIllIlIII <= 5286; ++llllllllllllllIlIllIIIllIllIlIII) {
            BackwardsBlockStorage.WHITELIST.add(llllllllllllllIlIllIIIllIllIlIII);
        }
        for (int llllllllllllllIlIllIIIllIllIIlll = 0; llllllllllllllIlIllIIIllIllIIlll < 256; ++llllllllllllllIlIllIIIllIllIIlll) {
            BackwardsBlockStorage.WHITELIST.add(748 + llllllllllllllIlIllIIIllIllIIlll);
        }
        for (int llllllllllllllIlIllIIIllIllIIllI = 6854; llllllllllllllIlIllIIIllIllIIllI <= 7173; ++llllllllllllllIlIllIIIllIllIIllI) {
            BackwardsBlockStorage.WHITELIST.add(llllllllllllllIlIllIIIllIllIIllI);
        }
        BackwardsBlockStorage.WHITELIST.add(1647);
        for (int llllllllllllllIlIllIIIllIllIIlIl = 5447; llllllllllllllIlIllIIIllIllIIlIl <= 5566; ++llllllllllllllIlIllIIIllIllIIlIl) {
            BackwardsBlockStorage.WHITELIST.add(llllllllllllllIlIllIIIllIllIIlIl);
        }
        for (int llllllllllllllIlIllIIIllIllIIlII = 1028; llllllllllllllIlIllIIIllIllIIlII <= 1039; ++llllllllllllllIlIllIIIllIllIIlII) {
            BackwardsBlockStorage.WHITELIST.add(llllllllllllllIlIllIIIllIllIIlII);
        }
        for (int llllllllllllllIlIllIIIllIllIIIll = 1047; llllllllllllllIlIllIIIllIllIIIll <= 1082; ++llllllllllllllIlIllIIIllIllIIIll) {
            BackwardsBlockStorage.WHITELIST.add(llllllllllllllIlIllIIIllIllIIIll);
        }
        for (int llllllllllllllIlIllIIIllIllIIIlI = 1099; llllllllllllllIlIllIIIllIllIIIlI <= 1110; ++llllllllllllllIlIllIIIllIllIIIlI) {
            BackwardsBlockStorage.WHITELIST.add(llllllllllllllIlIllIIIllIllIIIlI);
        }
    }
    
    public void clear() {
        this.blocks.clear();
    }
    
    public int remove(final Position llllllllllllllIlIllIIIllIlllIIlI) {
        return this.blocks.remove(llllllllllllllIlIllIIIllIlllIIlI);
    }
    
    public boolean isWelcome(final int llllllllllllllIlIllIIIllIlllllII) {
        return BackwardsBlockStorage.WHITELIST.contains(llllllllllllllIlIllIIIllIlllllII);
    }
    
    public Integer get(final Position llllllllllllllIlIllIIIllIlllIllI) {
        return this.blocks.get(llllllllllllllIlIllIIIllIlllIllI);
    }
}
