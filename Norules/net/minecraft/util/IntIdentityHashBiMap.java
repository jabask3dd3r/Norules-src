package net.minecraft.util;

import javax.annotation.*;
import com.google.common.collect.*;
import com.google.common.base.*;
import net.minecraft.util.math.*;
import java.util.*;

public class IntIdentityHashBiMap<K> implements IObjectIntIterable<K>
{
    private /* synthetic */ K[] byId;
    private /* synthetic */ int[] intKeys;
    private /* synthetic */ K[] values;
    private static final /* synthetic */ Object EMPTY;
    private /* synthetic */ int mapSize;
    private /* synthetic */ int nextFreeIndex;
    
    @Nullable
    public K get(final int llllllllllllllIlIlIIIllIIlllIIII) {
        return (llllllllllllllIlIlIIIllIIlllIIII >= 0 && llllllllllllllIlIlIIIllIIlllIIII < this.byId.length) ? this.byId[llllllllllllllIlIlIIIllIIlllIIII] : null;
    }
    
    @Override
    public Iterator<K> iterator() {
        return (Iterator<K>)Iterators.filter((Iterator)Iterators.forArray((Object[])this.byId), Predicates.notNull());
    }
    
    public int size() {
        return this.mapSize;
    }
    
    public void put(final K llllllllllllllIlIlIIIllIIlIIlIII, final int llllllllllllllIlIlIIIllIIlIIIIIl) {
        final int llllllllllllllIlIlIIIllIIlIIIllI = Math.max(llllllllllllllIlIlIIIllIIlIIIIIl, this.mapSize + 1);
        if (llllllllllllllIlIlIIIllIIlIIIllI >= this.values.length * 0.8f) {
            int llllllllllllllIlIlIIIllIIlIIIlIl;
            for (llllllllllllllIlIlIIIllIIlIIIlIl = this.values.length << 1; llllllllllllllIlIlIIIllIIlIIIlIl < llllllllllllllIlIlIIIllIIlIIIIIl; llllllllllllllIlIlIIIllIIlIIIlIl <<= 1) {}
            this.grow(llllllllllllllIlIlIIIllIIlIIIlIl);
        }
        final int llllllllllllllIlIlIIIllIIlIIIlII = this.findEmpty(this.hashObject(llllllllllllllIlIlIIIllIIlIIlIII));
        this.values[llllllllllllllIlIlIIIllIIlIIIlII] = llllllllllllllIlIlIIIllIIlIIlIII;
        this.intKeys[llllllllllllllIlIlIIIllIIlIIIlII] = llllllllllllllIlIlIIIllIIlIIIIIl;
        this.byId[llllllllllllllIlIlIIIllIIlIIIIIl] = llllllllllllllIlIlIIIllIIlIIlIII;
        ++this.mapSize;
        if (llllllllllllllIlIlIIIllIIlIIIIIl == this.nextFreeIndex) {
            ++this.nextFreeIndex;
        }
    }
    
    private int hashObject(@Nullable final K llllllllllllllIlIlIIIllIIIlllIIl) {
        return (MathHelper.hash(System.identityHashCode(llllllllllllllIlIlIIIllIIIlllIIl)) & Integer.MAX_VALUE) % this.values.length;
    }
    
    private void grow(final int llllllllllllllIlIlIIIllIIlIlIlll) {
        final Object[] llllllllllllllIlIlIIIllIIlIlIllI = this.values;
        final int[] llllllllllllllIlIlIIIllIIlIlIlIl = this.intKeys;
        this.values = (K[])new Object[llllllllllllllIlIlIIIllIIlIlIlll];
        this.intKeys = new int[llllllllllllllIlIlIIIllIIlIlIlll];
        this.byId = (K[])new Object[llllllllllllllIlIlIIIllIIlIlIlll];
        this.nextFreeIndex = 0;
        this.mapSize = 0;
        for (int llllllllllllllIlIlIIIllIIlIlIlII = 0; llllllllllllllIlIlIIIllIIlIlIlII < llllllllllllllIlIlIIIllIIlIlIllI.length; ++llllllllllllllIlIlIIIllIIlIlIlII) {
            if (llllllllllllllIlIlIIIllIIlIlIllI[llllllllllllllIlIlIIIllIIlIlIlII] != null) {
                this.put(llllllllllllllIlIlIIIllIIlIlIllI[llllllllllllllIlIlIIIllIIlIlIlII], llllllllllllllIlIlIIIllIIlIlIlIl[llllllllllllllIlIlIIIllIIlIlIlII]);
            }
        }
    }
    
    private int nextId() {
        while (this.nextFreeIndex < this.byId.length && this.byId[this.nextFreeIndex] != null) {
            ++this.nextFreeIndex;
        }
        return this.nextFreeIndex;
    }
    
    private int getValue(final int llllllllllllllIlIlIIIllIIllIlIlI) {
        return (llllllllllllllIlIlIIIllIIllIlIlI == -1) ? -1 : this.intKeys[llllllllllllllIlIlIIIllIIllIlIlI];
    }
    
    public int getId(@Nullable final K llllllllllllllIlIlIIIllIIlllIllI) {
        return this.getValue(this.getIndex(llllllllllllllIlIlIIIllIIlllIllI, this.hashObject(llllllllllllllIlIlIIIllIIlllIllI)));
    }
    
    public void clear() {
        Arrays.fill(this.values, null);
        Arrays.fill(this.byId, null);
        this.nextFreeIndex = 0;
        this.mapSize = 0;
    }
    
    private int getIndex(@Nullable final K llllllllllllllIlIlIIIllIIIlIllIl, final int llllllllllllllIlIlIIIllIIIllIIlI) {
        for (int llllllllllllllIlIlIIIllIIIllIIIl = llllllllllllllIlIlIIIllIIIllIIlI; llllllllllllllIlIlIIIllIIIllIIIl < this.values.length; ++llllllllllllllIlIlIIIllIIIllIIIl) {
            if (this.values[llllllllllllllIlIlIIIllIIIllIIIl] == llllllllllllllIlIlIIIllIIIlIllIl) {
                return llllllllllllllIlIlIIIllIIIllIIIl;
            }
            if (this.values[llllllllllllllIlIlIIIllIIIllIIIl] == IntIdentityHashBiMap.EMPTY) {
                return -1;
            }
        }
        for (int llllllllllllllIlIlIIIllIIIllIIII = 0; llllllllllllllIlIlIIIllIIIllIIII < llllllllllllllIlIlIIIllIIIllIIlI; ++llllllllllllllIlIlIIIllIIIllIIII) {
            if (this.values[llllllllllllllIlIlIIIllIIIllIIII] == llllllllllllllIlIlIIIllIIIlIllIl) {
                return llllllllllllllIlIlIIIllIIIllIIII;
            }
            if (this.values[llllllllllllllIlIlIIIllIIIllIIII] == IntIdentityHashBiMap.EMPTY) {
                return -1;
            }
        }
        return -1;
    }
    
    public IntIdentityHashBiMap(int llllllllllllllIlIlIIIllIIlllllII) {
        llllllllllllllIlIlIIIllIIlllllII = (int)(llllllllllllllIlIlIIIllIIlllllII / 0.8f);
        this.values = (K[])new Object[llllllllllllllIlIlIIIllIIlllllII];
        this.intKeys = new int[llllllllllllllIlIlIIIllIIlllllII];
        this.byId = (K[])new Object[llllllllllllllIlIlIIIllIIlllllII];
    }
    
    static {
        EMPTY = null;
    }
    
    public int add(final K llllllllllllllIlIlIIIllIIllIIlIl) {
        final int llllllllllllllIlIlIIIllIIllIIlII = this.nextId();
        this.put(llllllllllllllIlIlIIIllIIllIIlIl, llllllllllllllIlIlIIIllIIllIIlII);
        return llllllllllllllIlIlIIIllIIllIIlII;
    }
    
    private int findEmpty(final int llllllllllllllIlIlIIIllIIIIlIIlI) {
        for (int llllllllllllllIlIlIIIllIIIIllIII = llllllllllllllIlIlIIIllIIIIlIIlI; llllllllllllllIlIlIIIllIIIIllIII < this.values.length; ++llllllllllllllIlIlIIIllIIIIllIII) {
            if (this.values[llllllllllllllIlIlIIIllIIIIllIII] == IntIdentityHashBiMap.EMPTY) {
                return llllllllllllllIlIlIIIllIIIIllIII;
            }
        }
        for (int llllllllllllllIlIlIIIllIIIIlIllI = 0; llllllllllllllIlIlIIIllIIIIlIllI < llllllllllllllIlIlIIIllIIIIlIIlI; ++llllllllllllllIlIlIIIllIIIIlIllI) {
            if (this.values[llllllllllllllIlIlIIIllIIIIlIllI] == IntIdentityHashBiMap.EMPTY) {
                return llllllllllllllIlIlIIIllIIIIlIllI;
            }
        }
        throw new RuntimeException("Overflowed :(");
    }
}
