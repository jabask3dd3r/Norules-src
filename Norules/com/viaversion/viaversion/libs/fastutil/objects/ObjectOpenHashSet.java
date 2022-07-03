package com.viaversion.viaversion.libs.fastutil.objects;

import com.viaversion.viaversion.libs.fastutil.*;
import java.io.*;
import java.util.*;

public class ObjectOpenHashSet<K> extends AbstractObjectSet<K> implements Serializable, Cloneable, Hash
{
    protected final /* synthetic */ float f;
    protected final transient /* synthetic */ int minN;
    protected /* synthetic */ int size;
    protected transient /* synthetic */ int mask;
    protected transient /* synthetic */ int n;
    protected transient /* synthetic */ K[] key;
    protected transient /* synthetic */ boolean containsNull;
    protected transient /* synthetic */ int maxFill;
    
    @Override
    public int size() {
        return this.size;
    }
    
    private void checkTable() {
    }
    
    public ObjectOpenHashSet(final int llllllllllllllIlllllIlIlIlIlIIII) {
        this(llllllllllllllIlllllIlIlIlIlIIII, 0.75f);
    }
    
    public ObjectOpenHashSet() {
        this(16, 0.75f);
    }
    
    @Override
    public boolean contains(final Object llllllllllllllIlllllIlIIIIlIllIl) {
        if (llllllllllllllIlllllIlIIIIlIllIl == null) {
            return this.containsNull;
        }
        final K[] llllllllllllllIlllllIlIIIIllIIII = this.key;
        int llllllllllllllIlllllIlIIIIlIllll;
        K llllllllllllllIlllllIlIIIIllIIIl;
        if ((llllllllllllllIlllllIlIIIIllIIIl = llllllllllllllIlllllIlIIIIllIIII[llllllllllllllIlllllIlIIIIlIllll = (HashCommon.mix(llllllllllllllIlllllIlIIIIlIllIl.hashCode()) & this.mask)]) == null) {
            return false;
        }
        if (llllllllllllllIlllllIlIIIIlIllIl.equals(llllllllllllllIlllllIlIIIIllIIIl)) {
            return true;
        }
        while ((llllllllllllllIlllllIlIIIIllIIIl = llllllllllllllIlllllIlIIIIllIIII[llllllllllllllIlllllIlIIIIlIllll = (llllllllllllllIlllllIlIIIIlIllll + 1 & this.mask)]) != null) {
            if (llllllllllllllIlllllIlIIIIlIllIl.equals(llllllllllllllIlllllIlIIIIllIIIl)) {
                return true;
            }
        }
        return false;
    }
    
    public ObjectOpenHashSet(final K[] llllllllllllllIlllllIlIIlllIIlll, final int llllllllllllllIlllllIlIIlllIllIl, final int llllllllllllllIlllllIlIIlllIIIll) {
        this(llllllllllllllIlllllIlIIlllIIlll, llllllllllllllIlllllIlIIlllIllIl, llllllllllllllIlllllIlIIlllIIIll, 0.75f);
    }
    
    @Override
    public boolean addAll(final Collection<? extends K> llllllllllllllIlllllIlIIlIIIlllI) {
        if (this.f <= 0.5) {
            this.ensureCapacity(llllllllllllllIlllllIlIIlIIIlllI.size());
        }
        else {
            this.tryCapacity(this.size() + llllllllllllllIlllllIlIIlIIIlllI.size());
        }
        return super.addAll(llllllllllllllIlllllIlIIlIIIlllI);
    }
    
    @Override
    public boolean add(final K llllllllllllllIlllllIlIIIlllIlIl) {
        if (llllllllllllllIlllllIlIIIlllIlIl == null) {
            if (this.containsNull) {
                return false;
            }
            this.containsNull = true;
        }
        else {
            final K[] llllllllllllllIlllllIlIIIllllIlI = this.key;
            int llllllllllllllIlllllIlIIIllllIIl;
            K llllllllllllllIlllllIlIIIllllIll;
            if ((llllllllllllllIlllllIlIIIllllIll = llllllllllllllIlllllIlIIIllllIlI[llllllllllllllIlllllIlIIIllllIIl = (HashCommon.mix(llllllllllllllIlllllIlIIIlllIlIl.hashCode()) & this.mask)]) != null) {
                if (llllllllllllllIlllllIlIIIllllIll.equals(llllllllllllllIlllllIlIIIlllIlIl)) {
                    return false;
                }
                while ((llllllllllllllIlllllIlIIIllllIll = llllllllllllllIlllllIlIIIllllIlI[llllllllllllllIlllllIlIIIllllIIl = (llllllllllllllIlllllIlIIIllllIIl + 1 & this.mask)]) != null) {
                    if (llllllllllllllIlllllIlIIIllllIll.equals(llllllllllllllIlllllIlIIIlllIlIl)) {
                        return false;
                    }
                }
            }
            llllllllllllllIlllllIlIIIllllIlI[llllllllllllllIlllllIlIIIllllIIl] = llllllllllllllIlllllIlIIIlllIlIl;
        }
        if (this.size++ >= this.maxFill) {
            this.rehash(HashCommon.arraySize(this.size + 1, this.f));
        }
        return true;
    }
    
    public K addOrGet(final K llllllllllllllIlllllIlIIIllIlIII) {
        if (llllllllllllllIlllllIlIIIllIlIII == null) {
            if (this.containsNull) {
                return this.key[this.n];
            }
            this.containsNull = true;
        }
        else {
            final K[] llllllllllllllIlllllIlIIIllIlIll = this.key;
            int llllllllllllllIlllllIlIIIllIlIlI;
            K llllllllllllllIlllllIlIIIllIllII;
            if ((llllllllllllllIlllllIlIIIllIllII = llllllllllllllIlllllIlIIIllIlIll[llllllllllllllIlllllIlIIIllIlIlI = (HashCommon.mix(llllllllllllllIlllllIlIIIllIlIII.hashCode()) & this.mask)]) != null) {
                if (llllllllllllllIlllllIlIIIllIllII.equals(llllllllllllllIlllllIlIIIllIlIII)) {
                    return llllllllllllllIlllllIlIIIllIllII;
                }
                while ((llllllllllllllIlllllIlIIIllIllII = llllllllllllllIlllllIlIIIllIlIll[llllllllllllllIlllllIlIIIllIlIlI = (llllllllllllllIlllllIlIIIllIlIlI + 1 & this.mask)]) != null) {
                    if (llllllllllllllIlllllIlIIIllIllII.equals(llllllllllllllIlllllIlIIIllIlIII)) {
                        return llllllllllllllIlllllIlIIIllIllII;
                    }
                }
            }
            llllllllllllllIlllllIlIIIllIlIll[llllllllllllllIlllllIlIIIllIlIlI] = llllllllllllllIlllllIlIIIllIlIII;
        }
        if (this.size++ >= this.maxFill) {
            this.rehash(HashCommon.arraySize(this.size + 1, this.f));
        }
        return llllllllllllllIlllllIlIIIllIlIII;
    }
    
    private void writeObject(final ObjectOutputStream llllllllllllllIlllllIIllllIIlIll) throws IOException {
        final ObjectIterator<K> llllllllllllllIlllllIIllllIIlIlI = this.iterator();
        llllllllllllllIlllllIIllllIIlIll.defaultWriteObject();
        int llllllllllllllIlllllIIllllIIllIl = this.size;
        while (llllllllllllllIlllllIIllllIIllIl-- != 0) {
            llllllllllllllIlllllIIllllIIlIll.writeObject(llllllllllllllIlllllIIllllIIlIlI.next());
        }
    }
    
    public ObjectOpenHashSet(final ObjectCollection<? extends K> llllllllllllllIlllllIlIlIIlllIIl, final float llllllllllllllIlllllIlIlIIllIlIl) {
        this(llllllllllllllIlllllIlIlIIlllIIl.size(), llllllllllllllIlllllIlIlIIllIlIl);
        this.addAll(llllllllllllllIlllllIlIlIIlllIIl);
    }
    
    protected void rehash(final int llllllllllllllIlllllIIllllllIlII) {
        final K[] llllllllllllllIlllllIIllllllIIll = this.key;
        final int llllllllllllllIlllllIIllllllIIlI = llllllllllllllIlllllIIllllllIlII - 1;
        final K[] llllllllllllllIlllllIIllllllIIIl = (K[])new Object[llllllllllllllIlllllIIllllllIlII + 1];
        int llllllllllllllIlllllIIllllllIIII = this.n;
        int llllllllllllllIlllllIIllllllIllI = this.realSize();
        while (llllllllllllllIlllllIIllllllIllI-- != 0) {
            while (llllllllllllllIlllllIIllllllIIll[--llllllllllllllIlllllIIllllllIIII] == null) {}
            int llllllllllllllIlllllIIllllllIlll;
            if (llllllllllllllIlllllIIllllllIIIl[llllllllllllllIlllllIIllllllIlll = (HashCommon.mix(llllllllllllllIlllllIIllllllIIll[llllllllllllllIlllllIIllllllIIII].hashCode()) & llllllllllllllIlllllIIllllllIIlI)] != null) {
                while (llllllllllllllIlllllIIllllllIIIl[llllllllllllllIlllllIIllllllIlll = (llllllllllllllIlllllIIllllllIlll + 1 & llllllllllllllIlllllIIllllllIIlI)] != null) {}
            }
            llllllllllllllIlllllIIllllllIIIl[llllllllllllllIlllllIIllllllIlll] = llllllllllllllIlllllIIllllllIIll[llllllllllllllIlllllIIllllllIIII];
        }
        this.n = llllllllllllllIlllllIIllllllIlII;
        this.mask = llllllllllllllIlllllIIllllllIIlI;
        this.maxFill = HashCommon.maxFill(this.n, this.f);
        this.key = llllllllllllllIlllllIIllllllIIIl;
    }
    
    @Override
    public int hashCode() {
        int llllllllllllllIlllllIIllllIlIllI = 0;
        int llllllllllllllIlllllIIllllIllIIl = this.realSize();
        int llllllllllllllIlllllIIllllIllIII = 0;
        while (llllllllllllllIlllllIIllllIllIIl-- != 0) {
            while (this.key[llllllllllllllIlllllIIllllIllIII] == null) {
                ++llllllllllllllIlllllIIllllIllIII;
            }
            if (this != this.key[llllllllllllllIlllllIIllllIllIII]) {
                llllllllllllllIlllllIIllllIlIllI += this.key[llllllllllllllIlllllIIllllIllIII].hashCode();
            }
            ++llllllllllllllIlllllIIllllIllIII;
        }
        return llllllllllllllIlllllIIllllIlIllI;
    }
    
    @Override
    public boolean remove(final Object llllllllllllllIlllllIlIIIIllllII) {
        if (llllllllllllllIlllllIlIIIIllllII == null) {
            return this.containsNull && this.removeNullEntry();
        }
        final K[] llllllllllllllIlllllIlIIIIllllll = this.key;
        int llllllllllllllIlllllIlIIIIlllllI;
        K llllllllllllllIlllllIlIIIlIIIIII;
        if ((llllllllllllllIlllllIlIIIlIIIIII = llllllllllllllIlllllIlIIIIllllll[llllllllllllllIlllllIlIIIIlllllI = (HashCommon.mix(llllllllllllllIlllllIlIIIIllllII.hashCode()) & this.mask)]) == null) {
            return false;
        }
        if (llllllllllllllIlllllIlIIIIllllII.equals(llllllllllllllIlllllIlIIIlIIIIII)) {
            return this.removeEntry(llllllllllllllIlllllIlIIIIlllllI);
        }
        while ((llllllllllllllIlllllIlIIIlIIIIII = llllllllllllllIlllllIlIIIIllllll[llllllllllllllIlllllIlIIIIlllllI = (llllllllllllllIlllllIlIIIIlllllI + 1 & this.mask)]) != null) {
            if (llllllllllllllIlllllIlIIIIllllII.equals(llllllllllllllIlllllIlIIIlIIIIII)) {
                return this.removeEntry(llllllllllllllIlllllIlIIIIlllllI);
            }
        }
        return false;
    }
    
    private void ensureCapacity(final int llllllllllllllIlllllIlIIlIllIIlI) {
        final int llllllllllllllIlllllIlIIlIllIlII = HashCommon.arraySize(llllllllllllllIlllllIlIIlIllIIlI, this.f);
        if (llllllllllllllIlllllIlIIlIllIlII > this.n) {
            this.rehash(llllllllllllllIlllllIlIIlIllIlII);
        }
    }
    
    private boolean removeNullEntry() {
        this.containsNull = false;
        this.key[this.n] = null;
        --this.size;
        if (this.n > this.minN && this.size < this.maxFill / 4 && this.n > 16) {
            this.rehash(this.n / 2);
        }
        return true;
    }
    
    public ObjectOpenHashSet(final K[] llllllllllllllIlllllIlIlIIIIlIII, final int llllllllllllllIlllllIlIlIIIIIllI, final int llllllllllllllIlllllIlIlIIIIIlII, final float llllllllllllllIlllllIlIlIIIIIIlI) {
        this((llllllllllllllIlllllIlIlIIIIIlII < 0) ? 0 : llllllllllllllIlllllIlIlIIIIIlII, llllllllllllllIlllllIlIlIIIIIIlI);
        ObjectArrays.ensureOffsetLength(llllllllllllllIlllllIlIlIIIIlIII, llllllllllllllIlllllIlIlIIIIIllI, llllllllllllllIlllllIlIlIIIIIlII);
        for (int llllllllllllllIlllllIlIlIIIIlIll = 0; llllllllllllllIlllllIlIlIIIIlIll < llllllllllllllIlllllIlIlIIIIIlII; ++llllllllllllllIlllllIlIlIIIIlIll) {
            this.add(llllllllllllllIlllllIlIlIIIIlIII[llllllllllllllIlllllIlIlIIIIIllI + llllllllllllllIlllllIlIlIIIIlIll]);
        }
    }
    
    private int realSize() {
        return this.containsNull ? (this.size - 1) : this.size;
    }
    
    private void tryCapacity(final long llllllllllllllIlllllIlIIlIlIIlIl) {
        final int llllllllllllllIlllllIlIIlIlIIlII = (int)Math.min(1073741824L, Math.max(2L, HashCommon.nextPowerOfTwo((long)Math.ceil(llllllllllllllIlllllIlIIlIlIIlIl / this.f))));
        if (llllllllllllllIlllllIlIIlIlIIlII > this.n) {
            this.rehash(llllllllllllllIlllllIlIIlIlIIlII);
        }
    }
    
    public K get(final Object llllllllllllllIlllllIlIIIIIllllI) {
        if (llllllllllllllIlllllIlIIIIIllllI == null) {
            return this.key[this.n];
        }
        final K[] llllllllllllllIlllllIlIIIIlIIIIl = this.key;
        int llllllllllllllIlllllIlIIIIlIIIII;
        K llllllllllllllIlllllIlIIIIlIIIlI;
        if ((llllllllllllllIlllllIlIIIIlIIIlI = llllllllllllllIlllllIlIIIIlIIIIl[llllllllllllllIlllllIlIIIIlIIIII = (HashCommon.mix(llllllllllllllIlllllIlIIIIIllllI.hashCode()) & this.mask)]) == null) {
            return null;
        }
        if (llllllllllllllIlllllIlIIIIIllllI.equals(llllllllllllllIlllllIlIIIIlIIIlI)) {
            return llllllllllllllIlllllIlIIIIlIIIlI;
        }
        while ((llllllllllllllIlllllIlIIIIlIIIlI = llllllllllllllIlllllIlIIIIlIIIIl[llllllllllllllIlllllIlIIIIlIIIII = (llllllllllllllIlllllIlIIIIlIIIII + 1 & this.mask)]) != null) {
            if (llllllllllllllIlllllIlIIIIIllllI.equals(llllllllllllllIlllllIlIIIIlIIIlI)) {
                return llllllllllllllIlllllIlIIIIlIIIlI;
            }
        }
        return null;
    }
    
    public ObjectOpenHashSet(final ObjectCollection<? extends K> llllllllllllllIlllllIlIlIIlIllll) {
        this(llllllllllllllIlllllIlIlIIlIllll, 0.75f);
    }
    
    @Override
    public void clear() {
        if (this.size == 0) {
            return;
        }
        this.size = 0;
        this.containsNull = false;
        Arrays.fill(this.key, null);
    }
    
    public ObjectOpenHashSet(final K[] llllllllllllllIlllllIlIIllIIIlll) {
        this(llllllllllllllIlllllIlIIllIIIlll, 0.75f);
    }
    
    public boolean trim(final int llllllllllllllIlllllIlIIIIIIIIlI) {
        final int llllllllllllllIlllllIlIIIIIIIlII = HashCommon.nextPowerOfTwo((int)Math.ceil(llllllllllllllIlllllIlIIIIIIIIlI / this.f));
        if (llllllllllllllIlllllIlIIIIIIIlII >= this.n || this.size > HashCommon.maxFill(llllllllllllllIlllllIlIIIIIIIlII, this.f)) {
            return true;
        }
        try {
            this.rehash(llllllllllllllIlllllIlIIIIIIIlII);
        }
        catch (OutOfMemoryError llllllllllllllIlllllIlIIIIIIIlll) {
            return false;
        }
        return true;
    }
    
    public ObjectOpenHashSet(final Iterator<? extends K> llllllllllllllIlllllIlIlIIlIIlll, final float llllllllllllllIlllllIlIlIIlIlIIl) {
        this(16, llllllllllllllIlllllIlIlIIlIlIIl);
        while (llllllllllllllIlllllIlIlIIlIIlll.hasNext()) {
            this.add(llllllllllllllIlllllIlIlIIlIIlll.next());
        }
    }
    
    public ObjectOpenHashSet(final Collection<? extends K> llllllllllllllIlllllIlIlIIlllllI) {
        this(llllllllllllllIlllllIlIlIIlllllI, 0.75f);
    }
    
    public ObjectOpenHashSet(final K[] llllllllllllllIlllllIlIIllIllIII, final float llllllllllllllIlllllIlIIllIlIIII) {
        this(llllllllllllllIlllllIlIIllIllIII, 0, llllllllllllllIlllllIlIIllIllIII.length, llllllllllllllIlllllIlIIllIlIIII);
    }
    
    @Override
    public ObjectIterator<K> iterator() {
        return new SetIterator();
    }
    
    static {
        ASSERTS = false;
    }
    
    public ObjectOpenHashSet(final Collection<? extends K> llllllllllllllIlllllIlIlIlIIIlIl, final float llllllllllllllIlllllIlIlIlIIIlII) {
        this(llllllllllllllIlllllIlIlIlIIIlIl.size(), llllllllllllllIlllllIlIlIlIIIlII);
        this.addAll(llllllllllllllIlllllIlIlIlIIIlIl);
    }
    
    protected final void shiftKeys(int llllllllllllllIlllllIlIIIlIlIlIl) {
        final K[] llllllllllllllIlllllIlIIIlIlIlll = this.key;
        int llllllllllllllIlllllIlIIIlIllIlI = 0;
    Label_0006:
        while (true) {
            llllllllllllllIlllllIlIIIlIlIlIl = ((llllllllllllllIlllllIlIIIlIllIlI = llllllllllllllIlllllIlIIIlIlIlIl) + 1 & this.mask);
            K llllllllllllllIlllllIlIIIlIllIII;
            while ((llllllllllllllIlllllIlIIIlIllIII = llllllllllllllIlllllIlIIIlIlIlll[llllllllllllllIlllllIlIIIlIlIlIl]) != null) {
                final int llllllllllllllIlllllIlIIIlIllIIl = HashCommon.mix(llllllllllllllIlllllIlIIIlIllIII.hashCode()) & this.mask;
                Label_0090: {
                    if (llllllllllllllIlllllIlIIIlIllIlI <= llllllllllllllIlllllIlIIIlIlIlIl) {
                        if (llllllllllllllIlllllIlIIIlIllIlI >= llllllllllllllIlllllIlIIIlIllIIl) {
                            break Label_0090;
                        }
                        if (llllllllllllllIlllllIlIIIlIllIIl > llllllllllllllIlllllIlIIIlIlIlIl) {
                            break Label_0090;
                        }
                    }
                    else if (llllllllllllllIlllllIlIIIlIllIlI >= llllllllllllllIlllllIlIIIlIllIIl && llllllllllllllIlllllIlIIIlIllIIl > llllllllllllllIlllllIlIIIlIlIlIl) {
                        break Label_0090;
                    }
                    llllllllllllllIlllllIlIIIlIlIlIl = (llllllllllllllIlllllIlIIIlIlIlIl + 1 & this.mask);
                    continue;
                }
                llllllllllllllIlllllIlIIIlIlIlll[llllllllllllllIlllllIlIIIlIllIlI] = llllllllllllllIlllllIlIIIlIllIII;
                continue Label_0006;
            }
            break;
        }
        llllllllllllllIlllllIlIIIlIlIlll[llllllllllllllIlllllIlIIIlIllIlI] = null;
    }
    
    private boolean removeEntry(final int llllllllllllllIlllllIlIIIlIIllIl) {
        --this.size;
        this.shiftKeys(llllllllllllllIlllllIlIIIlIIllIl);
        if (this.n > this.minN && this.size < this.maxFill / 4 && this.n > 16) {
            this.rehash(this.n / 2);
        }
        return true;
    }
    
    public ObjectOpenHashSet(final int llllllllllllllIlllllIlIlIlIllIlI, final float llllllllllllllIlllllIlIlIlIlIllI) {
        if (llllllllllllllIlllllIlIlIlIlIllI <= 0.0f || llllllllllllllIlllllIlIlIlIlIllI > 1.0f) {
            throw new IllegalArgumentException("Load factor must be greater than 0 and smaller than or equal to 1");
        }
        if (llllllllllllllIlllllIlIlIlIllIlI < 0) {
            throw new IllegalArgumentException("The expected number of elements must be nonnegative");
        }
        this.f = llllllllllllllIlllllIlIlIlIlIllI;
        final int arraySize = HashCommon.arraySize(llllllllllllllIlllllIlIlIlIllIlI, llllllllllllllIlllllIlIlIlIlIllI);
        this.n = arraySize;
        this.minN = arraySize;
        this.mask = this.n - 1;
        this.maxFill = HashCommon.maxFill(this.n, llllllllllllllIlllllIlIlIlIlIllI);
        this.key = (K[])new Object[this.n + 1];
    }
    
    public ObjectOpenHashSet(final Iterator<? extends K> llllllllllllllIlllllIlIlIIIllllI) {
        this(llllllllllllllIlllllIlIlIIIllllI, 0.75f);
    }
    
    public ObjectOpenHashSet<K> clone() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokespecial   java/lang/Object.clone:()Ljava/lang/Object;
        //     4: checkcast       Lcom/viaversion/viaversion/libs/fastutil/objects/ObjectOpenHashSet;
        //     7: astore_1        /* llllllllllllllIlllllIIlllllIIlII */
        //     8: goto            20
        //    11: astore_2        /* llllllllllllllIlllllIIlllllIIIll */
        //    12: new             Ljava/lang/InternalError;
        //    15: dup            
        //    16: invokespecial   java/lang/InternalError.<init>:()V
        //    19: athrow         
        //    20: aload_1         /* llllllllllllllIlllllIIlllllIIIIl */
        //    21: aload_0         /* llllllllllllllIlllllIIlllllIIIII */
        //    22: getfield        com/viaversion/viaversion/libs/fastutil/objects/ObjectOpenHashSet.key:[Ljava/lang/Object;
        //    25: invokevirtual   [java/lang/Object.clone:()Ljava/lang/Object;
        //    28: checkcast       [Ljava/lang/Object;
        //    31: putfield        com/viaversion/viaversion/libs/fastutil/objects/ObjectOpenHashSet.key:[Ljava/lang/Object;
        //    34: aload_1         /* llllllllllllllIlllllIIlllllIIIIl */
        //    35: aload_0         /* llllllllllllllIlllllIIlllllIIIII */
        //    36: getfield        com/viaversion/viaversion/libs/fastutil/objects/ObjectOpenHashSet.containsNull:Z
        //    39: putfield        com/viaversion/viaversion/libs/fastutil/objects/ObjectOpenHashSet.containsNull:Z
        //    42: aload_1         /* llllllllllllllIlllllIIlllllIIIIl */
        //    43: areturn        
        //    Signature:
        //  ()Lcom/viaversion/viaversion/libs/fastutil/objects/ObjectOpenHashSet<TK;>;
        //    StackMapTable: 00 02 4B 07 01 6A FC 00 08 07 00 02
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                  
        //  -----  -----  -----  -----  --------------------------------------
        //  0      8      11     20     Ljava/lang/CloneNotSupportedException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private void readObject(final ObjectInputStream llllllllllllllIlllllIIlllIllIlll) throws ClassNotFoundException, IOException {
        llllllllllllllIlllllIIlllIllIlll.defaultReadObject();
        this.n = HashCommon.arraySize(this.size, this.f);
        this.maxFill = HashCommon.maxFill(this.n, this.f);
        this.mask = this.n - 1;
        final Object[] key = new Object[this.n + 1];
        this.key = (K[])key;
        final K[] llllllllllllllIlllllIIlllIlllIIl = (K[])key;
        int llllllllllllllIlllllIIlllIllllIl = this.size;
        while (llllllllllllllIlllllIIlllIllllIl-- != 0) {
            final K llllllllllllllIlllllIIlllIlllllI = (K)llllllllllllllIlllllIIlllIllIlll.readObject();
            int llllllllllllllIlllllIIlllIllllII = 0;
            if (llllllllllllllIlllllIIlllIlllllI == null) {
                final int llllllllllllllIlllllIIlllIllllll = this.n;
                this.containsNull = true;
            }
            else if (llllllllllllllIlllllIIlllIlllIIl[llllllllllllllIlllllIIlllIllllII = (HashCommon.mix(llllllllllllllIlllllIIlllIlllllI.hashCode()) & this.mask)] != null) {
                while (llllllllllllllIlllllIIlllIlllIIl[llllllllllllllIlllllIIlllIllllII = (llllllllllllllIlllllIIlllIllllII + 1 & this.mask)] != null) {}
            }
            llllllllllllllIlllllIIlllIlllIIl[llllllllllllllIlllllIIlllIllllII] = llllllllllllllIlllllIIlllIlllllI;
        }
    }
    
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    public boolean trim() {
        return this.trim(this.size);
    }
    
    private class SetIterator implements ObjectIterator<K>
    {
        /* synthetic */ int last;
        /* synthetic */ int pos;
        /* synthetic */ int c;
        /* synthetic */ boolean mustReturnNull;
        /* synthetic */ ObjectArrayList<K> wrapped;
        
        private final void shiftKeys(int lllllllllllllIIlIIllIlllIlllIIII) {
            final K[] lllllllllllllIIlIIllIlllIlllIIlI = ObjectOpenHashSet.this.key;
            int lllllllllllllIIlIIllIlllIlllIlIl = 0;
        Label_0009:
            while (true) {
                lllllllllllllIIlIIllIlllIlllIIII = ((lllllllllllllIIlIIllIlllIlllIlIl = lllllllllllllIIlIIllIlllIlllIIII) + 1 & ObjectOpenHashSet.this.mask);
                K lllllllllllllIIlIIllIlllIlllIIll;
                while ((lllllllllllllIIlIIllIlllIlllIIll = lllllllllllllIIlIIllIlllIlllIIlI[lllllllllllllIIlIIllIlllIlllIIII]) != null) {
                    final int lllllllllllllIIlIIllIlllIlllIlII = HashCommon.mix(lllllllllllllIIlIIllIlllIlllIIll.hashCode()) & ObjectOpenHashSet.this.mask;
                    Label_0102: {
                        if (lllllllllllllIIlIIllIlllIlllIlIl <= lllllllllllllIIlIIllIlllIlllIIII) {
                            if (lllllllllllllIIlIIllIlllIlllIlIl >= lllllllllllllIIlIIllIlllIlllIlII) {
                                break Label_0102;
                            }
                            if (lllllllllllllIIlIIllIlllIlllIlII > lllllllllllllIIlIIllIlllIlllIIII) {
                                break Label_0102;
                            }
                        }
                        else if (lllllllllllllIIlIIllIlllIlllIlIl >= lllllllllllllIIlIIllIlllIlllIlII && lllllllllllllIIlIIllIlllIlllIlII > lllllllllllllIIlIIllIlllIlllIIII) {
                            break Label_0102;
                        }
                        lllllllllllllIIlIIllIlllIlllIIII = (lllllllllllllIIlIIllIlllIlllIIII + 1 & ObjectOpenHashSet.this.mask);
                        continue;
                    }
                    if (lllllllllllllIIlIIllIlllIlllIIII < lllllllllllllIIlIIllIlllIlllIlIl) {
                        if (this.wrapped == null) {
                            this.wrapped = new ObjectArrayList<K>(2);
                        }
                        this.wrapped.add(lllllllllllllIIlIIllIlllIlllIIlI[lllllllllllllIIlIIllIlllIlllIIII]);
                    }
                    lllllllllllllIIlIIllIlllIlllIIlI[lllllllllllllIIlIIllIlllIlllIlIl] = lllllllllllllIIlIIllIlllIlllIIll;
                    continue Label_0009;
                }
                break;
            }
            lllllllllllllIIlIIllIlllIlllIIlI[lllllllllllllIIlIIllIlllIlllIlIl] = null;
        }
        
        @Override
        public void remove() {
            if (this.last == -1) {
                throw new IllegalStateException();
            }
            if (this.last == ObjectOpenHashSet.this.n) {
                ObjectOpenHashSet.this.containsNull = false;
                ObjectOpenHashSet.this.key[ObjectOpenHashSet.this.n] = null;
            }
            else {
                if (this.pos < 0) {
                    ObjectOpenHashSet.this.remove(this.wrapped.set(-this.pos - 1, null));
                    this.last = -1;
                    return;
                }
                this.shiftKeys(this.last);
            }
            final ObjectOpenHashSet this$0 = ObjectOpenHashSet.this;
            --this$0.size;
            this.last = -1;
        }
        
        @Override
        public K next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            --this.c;
            if (this.mustReturnNull) {
                this.mustReturnNull = false;
                this.last = ObjectOpenHashSet.this.n;
                return ObjectOpenHashSet.this.key[ObjectOpenHashSet.this.n];
            }
            final K[] lllllllllllllIIlIIllIllllIIIIIII = ObjectOpenHashSet.this.key;
            while (--this.pos >= 0) {
                if (lllllllllllllIIlIIllIllllIIIIIII[this.pos] != null) {
                    final K[] array = lllllllllllllIIlIIllIllllIIIIIII;
                    final int pos = this.pos;
                    this.last = pos;
                    return array[pos];
                }
            }
            this.last = Integer.MIN_VALUE;
            return this.wrapped.get(-this.pos - 1);
        }
        
        @Override
        public boolean hasNext() {
            return this.c != 0;
        }
        
        private SetIterator() {
            this.pos = ObjectOpenHashSet.this.n;
            this.last = -1;
            this.c = ObjectOpenHashSet.this.size;
            this.mustReturnNull = ObjectOpenHashSet.this.containsNull;
        }
    }
}
