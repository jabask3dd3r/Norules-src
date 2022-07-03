package net.minecraft.util;

import javax.annotation.*;

public class IntHashMap<V>
{
    private transient /* synthetic */ Entry<V>[] slots;
    private transient /* synthetic */ int count;
    private /* synthetic */ int threshold;
    
    @Nullable
    final Entry<V> removeEntry(final int lllllllllllllIIIlllllllIIlllIIlI) {
        final int lllllllllllllIIIlllllllIIlllIIIl = computeHash(lllllllllllllIIIlllllllIIlllIIlI);
        final int lllllllllllllIIIlllllllIIlllIIII = getSlotIndex(lllllllllllllIIIlllllllIIlllIIIl, this.slots.length);
        Entry<V> lllllllllllllIIIlllllllIIllIlllI;
        Entry<V> lllllllllllllIIIlllllllIIllIllIl;
        for (Entry<V> lllllllllllllIIIlllllllIIllIllll = lllllllllllllIIIlllllllIIllIlllI = this.slots[lllllllllllllIIIlllllllIIlllIIII]; lllllllllllllIIIlllllllIIllIlllI != null; lllllllllllllIIIlllllllIIllIlllI = lllllllllllllIIIlllllllIIllIllIl) {
            lllllllllllllIIIlllllllIIllIllIl = lllllllllllllIIIlllllllIIllIlllI.nextEntry;
            if (lllllllllllllIIIlllllllIIllIlllI.hashEntry == lllllllllllllIIIlllllllIIlllIIlI) {
                --this.count;
                if (lllllllllllllIIIlllllllIIllIllll == lllllllllllllIIIlllllllIIllIlllI) {
                    this.slots[lllllllllllllIIIlllllllIIlllIIII] = lllllllllllllIIIlllllllIIllIllIl;
                }
                else {
                    lllllllllllllIIIlllllllIIllIllll.nextEntry = lllllllllllllIIIlllllllIIllIllIl;
                }
                return lllllllllllllIIIlllllllIIllIlllI;
            }
            lllllllllllllIIIlllllllIIllIllll = lllllllllllllIIIlllllllIIllIlllI;
        }
        return lllllllllllllIIIlllllllIIllIlllI;
    }
    
    public void clearMap() {
        final Entry[] lllllllllllllIIIlllllllIIllIIIIl = this.slots;
        for (int lllllllllllllIIIlllllllIIllIIIII = 0; lllllllllllllIIIlllllllIIllIIIII < lllllllllllllIIIlllllllIIllIIIIl.length; ++lllllllllllllIIIlllllllIIllIIIII) {
            lllllllllllllIIIlllllllIIllIIIIl[lllllllllllllIIIlllllllIIllIIIII] = null;
        }
        this.count = 0;
    }
    
    private static int computeHash(int lllllllllllllIIIlllllllIlllIIIIl) {
        lllllllllllllIIIlllllllIlllIIIIl = (lllllllllllllIIIlllllllIlllIIIIl ^ lllllllllllllIIIlllllllIlllIIIIl >>> 20 ^ lllllllllllllIIIlllllllIlllIIIIl >>> 12);
        return lllllllllllllIIIlllllllIlllIIIIl ^ lllllllllllllIIIlllllllIlllIIIIl >>> 7 ^ lllllllllllllIIIlllllllIlllIIIIl >>> 4;
    }
    
    public void addKey(final int lllllllllllllIIIlllllllIlIllIlIl, final V lllllllllllllIIIlllllllIlIlIlllI) {
        final int lllllllllllllIIIlllllllIlIllIIll = computeHash(lllllllllllllIIIlllllllIlIllIlIl);
        final int lllllllllllllIIIlllllllIlIllIIlI = getSlotIndex(lllllllllllllIIIlllllllIlIllIIll, this.slots.length);
        for (Entry<V> lllllllllllllIIIlllllllIlIllIIIl = this.slots[lllllllllllllIIIlllllllIlIllIIlI]; lllllllllllllIIIlllllllIlIllIIIl != null; lllllllllllllIIIlllllllIlIllIIIl = lllllllllllllIIIlllllllIlIllIIIl.nextEntry) {
            if (lllllllllllllIIIlllllllIlIllIIIl.hashEntry == lllllllllllllIIIlllllllIlIllIlIl) {
                lllllllllllllIIIlllllllIlIllIIIl.valueEntry = lllllllllllllIIIlllllllIlIlIlllI;
                return;
            }
        }
        this.insert(lllllllllllllIIIlllllllIlIllIIll, lllllllllllllIIIlllllllIlIllIlIl, lllllllllllllIIIlllllllIlIlIlllI, lllllllllllllIIIlllllllIlIllIIlI);
    }
    
    private static int getSlotIndex(final int lllllllllllllIIIlllllllIllIlllII, final int lllllllllllllIIIlllllllIllIllIll) {
        return lllllllllllllIIIlllllllIllIlllII & lllllllllllllIIIlllllllIllIllIll - 1;
    }
    
    @Nullable
    final Entry<V> lookupEntry(final int lllllllllllllIIIlllllllIlIllllll) {
        final int lllllllllllllIIIlllllllIllIIIIlI = computeHash(lllllllllllllIIIlllllllIlIllllll);
        for (Entry<V> lllllllllllllIIIlllllllIllIIIIIl = this.slots[getSlotIndex(lllllllllllllIIIlllllllIllIIIIlI, this.slots.length)]; lllllllllllllIIIlllllllIllIIIIIl != null; lllllllllllllIIIlllllllIllIIIIIl = lllllllllllllIIIlllllllIllIIIIIl.nextEntry) {
            if (lllllllllllllIIIlllllllIllIIIIIl.hashEntry == lllllllllllllIIIlllllllIlIllllll) {
                return lllllllllllllIIIlllllllIllIIIIIl;
            }
        }
        return null;
    }
    
    @Nullable
    public V removeObject(final int lllllllllllllIIIlllllllIIlllllll) {
        final Entry<V> lllllllllllllIIIlllllllIIllllllI = this.removeEntry(lllllllllllllIIIlllllllIIlllllll);
        return (lllllllllllllIIIlllllllIIllllllI == null) ? null : lllllllllllllIIIlllllllIIllllllI.valueEntry;
    }
    
    private void insert(final int lllllllllllllIIIlllllllIIlIlIlIl, final int lllllllllllllIIIlllllllIIlIIlllI, final V lllllllllllllIIIlllllllIIlIIllIl, final int lllllllllllllIIIlllllllIIlIlIIlI) {
        final Entry<V> lllllllllllllIIIlllllllIIlIlIIIl = this.slots[lllllllllllllIIIlllllllIIlIlIIlI];
        this.slots[lllllllllllllIIIlllllllIIlIlIIlI] = new Entry<V>(lllllllllllllIIIlllllllIIlIlIlIl, lllllllllllllIIIlllllllIIlIIlllI, lllllllllllllIIIlllllllIIlIIllIl, lllllllllllllIIIlllllllIIlIlIIIl);
        if (this.count++ >= this.threshold) {
            this.grow(2 * this.slots.length);
        }
    }
    
    public IntHashMap() {
        this.slots = (Entry<V>[])new Entry[16];
        this.threshold = 12;
    }
    
    private void copyTo(final Entry<V>[] lllllllllllllIIIlllllllIlIIIlIlI) {
        final Entry[] lllllllllllllIIIlllllllIlIIlIIIl = this.slots;
        final int lllllllllllllIIIlllllllIlIIlIIII = lllllllllllllIIIlllllllIlIIIlIlI.length;
        for (int lllllllllllllIIIlllllllIlIIIllll = 0; lllllllllllllIIIlllllllIlIIIllll < lllllllllllllIIIlllllllIlIIlIIIl.length; ++lllllllllllllIIIlllllllIlIIIllll) {
            Entry<V> lllllllllllllIIIlllllllIlIIIlllI = (Entry<V>)lllllllllllllIIIlllllllIlIIlIIIl[lllllllllllllIIIlllllllIlIIIllll];
            if (lllllllllllllIIIlllllllIlIIIlllI != null) {
                lllllllllllllIIIlllllllIlIIlIIIl[lllllllllllllIIIlllllllIlIIIllll] = null;
                Entry<V> lllllllllllllIIIlllllllIlIIIllIl;
                do {
                    lllllllllllllIIIlllllllIlIIIllIl = lllllllllllllIIIlllllllIlIIIlllI.nextEntry;
                    final int lllllllllllllIIIlllllllIlIIIllII = getSlotIndex(lllllllllllllIIIlllllllIlIIIlllI.slotHash, lllllllllllllIIIlllllllIlIIlIIII);
                    lllllllllllllIIIlllllllIlIIIlllI.nextEntry = lllllllllllllIIIlllllllIlIIIlIlI[lllllllllllllIIIlllllllIlIIIllII];
                    lllllllllllllIIIlllllllIlIIIlIlI[lllllllllllllIIIlllllllIlIIIllII] = lllllllllllllIIIlllllllIlIIIlllI;
                } while ((lllllllllllllIIIlllllllIlIIIlllI = lllllllllllllIIIlllllllIlIIIllIl) != null);
            }
        }
    }
    
    private void grow(final int lllllllllllllIIIlllllllIlIIlllll) {
        final Entry[] lllllllllllllIIIlllllllIlIlIIIll = this.slots;
        final int lllllllllllllIIIlllllllIlIlIIIlI = lllllllllllllIIIlllllllIlIlIIIll.length;
        if (lllllllllllllIIIlllllllIlIlIIIlI == 1073741824) {
            this.threshold = Integer.MAX_VALUE;
        }
        else {
            final Entry[] lllllllllllllIIIlllllllIlIlIIIIl = new Entry[lllllllllllllIIIlllllllIlIIlllll];
            this.copyTo(lllllllllllllIIIlllllllIlIlIIIIl);
            this.slots = (Entry<V>[])lllllllllllllIIIlllllllIlIlIIIIl;
            this.threshold = (int)(lllllllllllllIIIlllllllIlIIlllll * 0.75f);
        }
    }
    
    @Nullable
    public V lookup(final int lllllllllllllIIIlllllllIllIlIIIl) {
        final int lllllllllllllIIIlllllllIllIlIlII = computeHash(lllllllllllllIIIlllllllIllIlIIIl);
        for (Entry<V> lllllllllllllIIIlllllllIllIlIIll = this.slots[getSlotIndex(lllllllllllllIIIlllllllIllIlIlII, this.slots.length)]; lllllllllllllIIIlllllllIllIlIIll != null; lllllllllllllIIIlllllllIllIlIIll = lllllllllllllIIIlllllllIllIlIIll.nextEntry) {
            if (lllllllllllllIIIlllllllIllIlIIll.hashEntry == lllllllllllllIIIlllllllIllIlIIIl) {
                return lllllllllllllIIIlllllllIllIlIIll.valueEntry;
            }
        }
        return null;
    }
    
    public boolean containsItem(final int lllllllllllllIIIlllllllIllIIlIIl) {
        return this.lookupEntry(lllllllllllllIIIlllllllIllIIlIIl) != null;
    }
    
    static class Entry<V>
    {
        final /* synthetic */ int slotHash;
        /* synthetic */ Entry<V> nextEntry;
        final /* synthetic */ int hashEntry;
        /* synthetic */ V valueEntry;
        
        @Override
        public final String toString() {
            return String.valueOf(new StringBuilder(String.valueOf(this.getHash())).append("=").append(this.getValue()));
        }
        
        @Override
        public final int hashCode() {
            return computeHash(this.hashEntry);
        }
        
        public final int getHash() {
            return this.hashEntry;
        }
        
        @Override
        public final boolean equals(final Object lllllllllllllllIllllIlllIIIIIlll) {
            if (!(lllllllllllllllIllllIlllIIIIIlll instanceof Entry)) {
                return false;
            }
            final Entry<V> lllllllllllllllIllllIlllIIIIIllI = (Entry<V>)lllllllllllllllIllllIlllIIIIIlll;
            if (this.hashEntry == lllllllllllllllIllllIlllIIIIIllI.hashEntry) {
                final Object lllllllllllllllIllllIlllIIIIIlIl = this.getValue();
                final Object lllllllllllllllIllllIlllIIIIIlII = lllllllllllllllIllllIlllIIIIIllI.getValue();
                if (lllllllllllllllIllllIlllIIIIIlIl == lllllllllllllllIllllIlllIIIIIlII || (lllllllllllllllIllllIlllIIIIIlIl != null && lllllllllllllllIllllIlllIIIIIlIl.equals(lllllllllllllllIllllIlllIIIIIlII))) {
                    return true;
                }
            }
            return false;
        }
        
        public final V getValue() {
            return this.valueEntry;
        }
        
        Entry(final int lllllllllllllllIllllIlllIIlIIlll, final int lllllllllllllllIllllIlllIIIlllll, final V lllllllllllllllIllllIlllIIlIIIll, final Entry<V> lllllllllllllllIllllIlllIIIlllIl) {
            this.valueEntry = lllllllllllllllIllllIlllIIlIIIll;
            this.nextEntry = lllllllllllllllIllllIlllIIIlllIl;
            this.hashEntry = lllllllllllllllIllllIlllIIIlllll;
            this.slotHash = lllllllllllllllIllllIlllIIlIIlll;
        }
    }
}
