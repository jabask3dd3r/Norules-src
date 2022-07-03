package com.viaversion.viaversion.protocols.protocol1_13to1_12_2.storage;

import com.viaversion.viaversion.api.connection.*;
import java.util.*;
import com.viaversion.viaversion.api.minecraft.*;
import com.viaversion.viaversion.libs.fastutil.ints.*;
import java.util.concurrent.*;

public class BlockStorage implements StorableObject
{
    private static final /* synthetic */ IntSet WHITELIST;
    private final /* synthetic */ Map<Position, ReplacementData> blocks;
    
    static {
        (WHITELIST = new IntOpenHashSet(46, 1.0f)).add(5266);
        for (int lllllllllllllIlIIlIlIlIIIIlIlllI = 0; lllllllllllllIlIIlIlIlIIIIlIlllI < 16; ++lllllllllllllIlIIlIlIlIIIIlIlllI) {
            BlockStorage.WHITELIST.add(972 + lllllllllllllIlIIlIlIlIIIIlIlllI);
        }
        for (int lllllllllllllIlIIlIlIlIIIIlIllIl = 0; lllllllllllllIlIIlIlIlIIIIlIllIl < 20; ++lllllllllllllIlIIlIlIlIIIIlIllIl) {
            BlockStorage.WHITELIST.add(6854 + lllllllllllllIlIIlIlIlIIIIlIllIl);
        }
        for (int lllllllllllllIlIIlIlIlIIIIlIllII = 0; lllllllllllllIlIIlIlIlIIIIlIllII < 4; ++lllllllllllllIlIIlIlIlIIIIlIllII) {
            BlockStorage.WHITELIST.add(7110 + lllllllllllllIlIIlIlIlIIIIlIllII);
        }
        for (int lllllllllllllIlIIlIlIlIIIIlIlIll = 0; lllllllllllllIlIIlIlIlIIIIlIlIll < 5; ++lllllllllllllIlIIlIlIlIIIIlIlIll) {
            BlockStorage.WHITELIST.add(5447 + lllllllllllllIlIIlIlIlIIIIlIlIll);
        }
    }
    
    public boolean isWelcome(final int lllllllllllllIlIIlIlIlIIIlIIIIlI) {
        return BlockStorage.WHITELIST.contains(lllllllllllllIlIIlIlIlIIIlIIIIlI);
    }
    
    public BlockStorage() {
        this.blocks = new ConcurrentHashMap<Position, ReplacementData>();
    }
    
    public void store(final Position lllllllllllllIlIIlIlIlIIIlIIllII, final int lllllllllllllIlIIlIlIlIIIlIIlIll, final int lllllllllllllIlIIlIlIlIIIlIIlIlI) {
        if (!BlockStorage.WHITELIST.contains(lllllllllllllIlIIlIlIlIIIlIIlIll)) {
            return;
        }
        this.blocks.put(lllllllllllllIlIIlIlIlIIIlIIllII, new ReplacementData(lllllllllllllIlIIlIlIlIIIlIIlIll, lllllllllllllIlIIlIlIlIIIlIIlIlI));
    }
    
    public ReplacementData remove(final Position lllllllllllllIlIIlIlIlIIIIllIIlI) {
        return this.blocks.remove(lllllllllllllIlIIlIlIlIIIIllIIlI);
    }
    
    public boolean contains(final Position lllllllllllllIlIIlIlIlIIIIlllllI) {
        return this.blocks.containsKey(lllllllllllllIlIIlIlIlIIIIlllllI);
    }
    
    public ReplacementData get(final Position lllllllllllllIlIIlIlIlIIIIllIllI) {
        return this.blocks.get(lllllllllllllIlIIlIlIlIIIIllIllI);
    }
    
    public void store(final Position lllllllllllllIlIIlIlIlIIIlIlIllI, final int lllllllllllllIlIIlIlIlIIIlIlIIlI) {
        this.store(lllllllllllllIlIIlIlIlIIIlIlIllI, lllllllllllllIlIIlIlIlIIIlIlIIlI, -1);
    }
    
    public static class ReplacementData
    {
        private /* synthetic */ int original;
        private /* synthetic */ int replacement;
        
        public void setReplacement(final int llllllllllllllIIlIlIIllIIIIIlIll) {
            this.replacement = llllllllllllllIIlIlIIllIIIIIlIll;
        }
        
        public int getReplacement() {
            return this.replacement;
        }
        
        public ReplacementData(final int llllllllllllllIIlIlIIllIIIIllllI, final int llllllllllllllIIlIlIIllIIIlIIIII) {
            this.original = llllllllllllllIIlIlIIllIIIIllllI;
            this.replacement = llllllllllllllIIlIlIIllIIIlIIIII;
        }
        
        public void setOriginal(final int llllllllllllllIIlIlIIllIIIIlIlII) {
            this.original = llllllllllllllIIlIlIIllIIIIlIlII;
        }
        
        public int getOriginal() {
            return this.original;
        }
    }
}
