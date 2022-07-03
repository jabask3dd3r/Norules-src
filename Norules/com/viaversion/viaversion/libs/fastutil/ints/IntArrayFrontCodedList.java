package com.viaversion.viaversion.libs.fastutil.ints;

import com.viaversion.viaversion.libs.fastutil.*;
import com.viaversion.viaversion.libs.fastutil.objects.*;
import java.util.*;
import com.viaversion.viaversion.libs.fastutil.longs.*;
import java.io.*;

public class IntArrayFrontCodedList extends AbstractObjectList<int[]> implements Serializable, Cloneable, RandomAccess
{
    protected final /* synthetic */ int n;
    protected transient /* synthetic */ long[] p;
    protected final /* synthetic */ int ratio;
    protected final /* synthetic */ int[][] array;
    
    private static int readInt(final int[][] lIIIIlllllIIl, final long lIIIIlllllIII) {
        return BigArrays.get(lIIIIlllllIIl, lIIIIlllllIII);
    }
    
    @Override
    public int[] get(final int lIIIIlIIlllIl) {
        return this.getArray(lIIIIlIIlllIl);
    }
    
    public int arrayLength(final int lIIIIllIIllIl) {
        this.ensureRestrictedIndex(lIIIIllIIllIl);
        return this.length(lIIIIllIIllIl);
    }
    
    @Override
    public ObjectListIterator<int[]> listIterator(final int lIIIIIllIllIl) {
        this.ensureIndex(lIIIIIllIllIl);
        return new ObjectListIterator<int[]>() {
            /* synthetic */ long pos = 0L;
            /* synthetic */ boolean inSync;
            /* synthetic */ int i = 0;
            /* synthetic */ int[] s = IntArrays.EMPTY_ARRAY;
            
            @Override
            public int[] previous() {
                if (!this.hasPrevious()) {
                    throw new NoSuchElementException();
                }
                this.inSync = false;
                final IntArrayFrontCodedList this$0 = IntArrayFrontCodedList.this;
                final int n = this.i - 1;
                this.i = n;
                return this$0.getArray(n);
            }
            
            @Override
            public int previousIndex() {
                return this.i - 1;
            }
            
            @Override
            public boolean hasNext() {
                return this.i < IntArrayFrontCodedList.this.n;
            }
            
            @Override
            public boolean hasPrevious() {
                return this.i > 0;
            }
            
            @Override
            public int[] next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                int lllllllllllllIIIIlIIIlIIlIIIlIll = 0;
                if (this.i % IntArrayFrontCodedList.this.ratio == 0) {
                    this.pos = IntArrayFrontCodedList.this.p[this.i / IntArrayFrontCodedList.this.ratio];
                    final int lllllllllllllIIIIlIIIlIIlIIIllll = readInt(IntArrayFrontCodedList.this.array, this.pos);
                    this.s = IntArrays.ensureCapacity(this.s, lllllllllllllIIIIlIIIlIIlIIIllll, 0);
                    BigArrays.copyFromBig(IntArrayFrontCodedList.this.array, this.pos + count(lllllllllllllIIIIlIIIlIIlIIIllll), this.s, 0, lllllllllllllIIIIlIIIlIIlIIIllll);
                    this.pos += lllllllllllllIIIIlIIIlIIlIIIllll + count(lllllllllllllIIIIlIIIlIIlIIIllll);
                    this.inSync = true;
                }
                else if (this.inSync) {
                    int lllllllllllllIIIIlIIIlIIlIIIlllI = readInt(IntArrayFrontCodedList.this.array, this.pos);
                    final int lllllllllllllIIIIlIIIlIIlIIIllIl = readInt(IntArrayFrontCodedList.this.array, this.pos + count(lllllllllllllIIIIlIIIlIIlIIIlllI));
                    this.s = IntArrays.ensureCapacity(this.s, lllllllllllllIIIIlIIIlIIlIIIlllI + lllllllllllllIIIIlIIIlIIlIIIllIl, lllllllllllllIIIIlIIIlIIlIIIllIl);
                    BigArrays.copyFromBig(IntArrayFrontCodedList.this.array, this.pos + count(lllllllllllllIIIIlIIIlIIlIIIlllI) + count(lllllllllllllIIIIlIIIlIIlIIIllIl), this.s, lllllllllllllIIIIlIIIlIIlIIIllIl, lllllllllllllIIIIlIIIlIIlIIIlllI);
                    this.pos += count(lllllllllllllIIIIlIIIlIIlIIIlllI) + count(lllllllllllllIIIIlIIIlIIlIIIllIl) + lllllllllllllIIIIlIIIlIIlIIIlllI;
                    lllllllllllllIIIIlIIIlIIlIIIlllI += lllllllllllllIIIIlIIIlIIlIIIllIl;
                }
                else {
                    this.s = IntArrays.ensureCapacity(this.s, lllllllllllllIIIIlIIIlIIlIIIlIll = IntArrayFrontCodedList.this.length(this.i), 0);
                    IntArrayFrontCodedList.this.extract(this.i, this.s, 0, lllllllllllllIIIIlIIIlIIlIIIlIll);
                }
                ++this.i;
                return IntArrays.copy(this.s, 0, lllllllllllllIIIIlIIIlIIlIIIlIll);
            }
            
            @Override
            public int nextIndex() {
                return this.i;
            }
            
            {
                if (lIIIIIllIllIl != 0) {
                    if (lIIIIIllIllIl == IntArrayFrontCodedList.this.n) {
                        this.i = lIIIIIllIllIl;
                    }
                    else {
                        this.pos = IntArrayFrontCodedList.this.p[lIIIIIllIllIl / IntArrayFrontCodedList.this.ratio];
                        int lllllllllllllIIIIlIIIlIIlIlIIlIl = lIIIIIllIllIl % IntArrayFrontCodedList.this.ratio;
                        this.i = lIIIIIllIllIl - lllllllllllllIIIIlIIIlIIlIlIIlIl;
                        while (lllllllllllllIIIIlIIIlIIlIlIIlIl-- != 0) {
                            this.next();
                        }
                    }
                }
            }
        };
    }
    
    private static int writeInt(final int[][] lIIIIllllIIll, final int lIIIIlllIllll, final long lIIIIllllIIIl) {
        BigArrays.set(lIIIIllllIIll, lIIIIllllIIIl, lIIIIlllIllll);
        return 1;
    }
    
    public int get(final int lIIIIIlllIlll, final int[] lIIIIIlllIllI) {
        return this.get(lIIIIIlllIlll, lIIIIIlllIllI, 0, lIIIIIlllIllI.length);
    }
    
    protected long[] rebuildPointerArray() {
        final long[] lIIIIIlIlIIIl = new long[(this.n + this.ratio - 1) / this.ratio];
        final int[][] lIIIIIlIlIIII = this.array;
        long lIIIIIlIIllll = 0L;
        int lIIIIIlIlIlIl = 0;
        int lIIIIIlIlIlII = 0;
        int lIIIIIlIlIIll = this.ratio - 1;
        while (lIIIIIlIlIlIl < this.n) {
            final int lIIIIIlIlIlll = readInt(lIIIIIlIlIIII, lIIIIIlIIllll);
            final int lIIIIIlIlIllI = count(lIIIIIlIlIlll);
            if (++lIIIIIlIlIIll == this.ratio) {
                lIIIIIlIlIIll = 0;
                lIIIIIlIlIIIl[lIIIIIlIlIlII++] = lIIIIIlIIllll;
                lIIIIIlIIllll += lIIIIIlIlIllI + lIIIIIlIlIlll;
            }
            else {
                lIIIIIlIIllll += lIIIIIlIlIllI + count(readInt(lIIIIIlIlIIII, lIIIIIlIIllll + lIIIIIlIlIllI)) + lIIIIIlIlIlll;
            }
            ++lIIIIIlIlIlIl;
        }
        return lIIIIIlIlIIIl;
    }
    
    public IntArrayFrontCodedList(final Collection<int[]> lIIIlIIIIIIlI, final int lIIIlIIIIIIIl) {
        this(lIIIlIIIIIIlI.iterator(), lIIIlIIIIIIIl);
    }
    
    public int ratio() {
        return this.ratio;
    }
    
    private static int count(final int lIIIIllllIlll) {
        return 1;
    }
    
    public int get(final int lIIIIlIIIIIll, final int[] lIIIIlIIIIIlI, final int lIIIIlIIIIlll, final int lIIIIlIIIIllI) {
        this.ensureRestrictedIndex(lIIIIlIIIIIll);
        IntArrays.ensureOffsetLength(lIIIIlIIIIIlI, lIIIIlIIIIlll, lIIIIlIIIIllI);
        final int lIIIIlIIIIlIl = this.extract(lIIIIlIIIIIll, lIIIIlIIIIIlI, lIIIIlIIIIlll, lIIIIlIIIIllI);
        if (lIIIIlIIIIllI >= lIIIIlIIIIlIl) {
            return lIIIIlIIIIlIl;
        }
        return lIIIIlIIIIllI - lIIIIlIIIIlIl;
    }
    
    private int extract(final int lIIIIlIlIllll, final int[] lIIIIlIlIlllI, final int lIIIIlIlllIII, final int lIIIIlIllIlll) {
        final int lIIIIlIllIllI = lIIIIlIlIllll % this.ratio;
        final long lIIIIlIllIlIl = this.p[lIIIIlIlIllll / this.ratio];
        long lIIIIlIllIlII;
        int lIIIIlIllIIll = readInt(this.array, lIIIIlIllIlII = lIIIIlIllIlIl);
        int lIIIIlIllIIlI = 0;
        if (lIIIIlIllIllI == 0) {
            lIIIIlIllIlII = this.p[lIIIIlIlIllll / this.ratio] + count(lIIIIlIllIIll);
            BigArrays.copyFromBig(this.array, lIIIIlIllIlII, lIIIIlIlIlllI, lIIIIlIlllIII, Math.min(lIIIIlIllIlll, lIIIIlIllIIll));
            return lIIIIlIllIIll;
        }
        int lIIIIlIllIIIl = 0;
        for (int lIIIIlIllllII = 0; lIIIIlIllllII < lIIIIlIllIllI; ++lIIIIlIllllII) {
            final long lIIIIlIlllllI = lIIIIlIllIlII + count(lIIIIlIllIIll) + ((lIIIIlIllllII != 0) ? count(lIIIIlIllIIIl) : 0);
            lIIIIlIllIlII = lIIIIlIlllllI + lIIIIlIllIIll;
            lIIIIlIllIIll = readInt(this.array, lIIIIlIllIlII);
            lIIIIlIllIIIl = readInt(this.array, lIIIIlIllIlII + count(lIIIIlIllIIll));
            final int lIIIIlIllllIl = Math.min(lIIIIlIllIIIl, lIIIIlIllIlll);
            if (lIIIIlIllllIl <= lIIIIlIllIIlI) {
                lIIIIlIllIIlI = lIIIIlIllllIl;
            }
            else {
                BigArrays.copyFromBig(this.array, lIIIIlIlllllI, lIIIIlIlIlllI, lIIIIlIllIIlI + lIIIIlIlllIII, lIIIIlIllllIl - lIIIIlIllIIlI);
                lIIIIlIllIIlI = lIIIIlIllllIl;
            }
        }
        if (lIIIIlIllIIlI < lIIIIlIllIlll) {
            BigArrays.copyFromBig(this.array, lIIIIlIllIlII + count(lIIIIlIllIIll) + count(lIIIIlIllIIIl), lIIIIlIlIlllI, lIIIIlIllIIlI + lIIIIlIlllIII, Math.min(lIIIIlIllIIll, lIIIIlIllIlll - lIIIIlIllIIlI));
        }
        return lIIIIlIllIIll + lIIIIlIllIIIl;
    }
    
    public IntArrayFrontCodedList clone() {
        return this;
    }
    
    public IntArrayFrontCodedList(final Iterator<int[]> lIIIlIIIlIIIl, final int lIIIlIIIllIIl) {
        if (lIIIlIIIllIIl < 1) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Illegal ratio (").append(lIIIlIIIllIIl).append(")")));
        }
        int[][] lIIIlIIIllIII = IntBigArrays.EMPTY_BIG_ARRAY;
        long[] lIIIlIIIlIlll = LongArrays.EMPTY_ARRAY;
        final int[][] lIIIlIIIlIllI = new int[2][];
        long lIIIlIIIlIlIl = 0L;
        int lIIIlIIIlIlII = 0;
        int lIIIlIIIlIIll = 0;
        while (lIIIlIIIlIIIl.hasNext()) {
            lIIIlIIIlIllI[lIIIlIIIlIIll] = lIIIlIIIlIIIl.next();
            int lIIIlIIIlllII = lIIIlIIIlIllI[lIIIlIIIlIIll].length;
            if (lIIIlIIIlIlII % lIIIlIIIllIIl == 0) {
                lIIIlIIIlIlll = LongArrays.grow(lIIIlIIIlIlll, lIIIlIIIlIlII / lIIIlIIIllIIl + 1);
                lIIIlIIIlIlll[lIIIlIIIlIlII / lIIIlIIIllIIl] = lIIIlIIIlIlIl;
                lIIIlIIIllIII = BigArrays.grow(lIIIlIIIllIII, lIIIlIIIlIlIl + count(lIIIlIIIlllII) + lIIIlIIIlllII, lIIIlIIIlIlIl);
                lIIIlIIIlIlIl += writeInt(lIIIlIIIllIII, lIIIlIIIlllII, lIIIlIIIlIlIl);
                BigArrays.copyToBig(lIIIlIIIlIllI[lIIIlIIIlIIll], 0, lIIIlIIIllIII, lIIIlIIIlIlIl, lIIIlIIIlllII);
                lIIIlIIIlIlIl += lIIIlIIIlllII;
            }
            else {
                int lIIIlIIIlllIl = lIIIlIIIlIllI[1 - lIIIlIIIlIIll].length;
                if (lIIIlIIIlllII < lIIIlIIIlllIl) {
                    lIIIlIIIlllIl = lIIIlIIIlllII;
                }
                int lIIIlIIIllllI;
                for (lIIIlIIIllllI = 0; lIIIlIIIllllI < lIIIlIIIlllIl && lIIIlIIIlIllI[0][lIIIlIIIllllI] == lIIIlIIIlIllI[1][lIIIlIIIllllI]; ++lIIIlIIIllllI) {}
                lIIIlIIIlllII -= lIIIlIIIllllI;
                lIIIlIIIllIII = BigArrays.grow(lIIIlIIIllIII, lIIIlIIIlIlIl + count(lIIIlIIIlllII) + count(lIIIlIIIllllI) + lIIIlIIIlllII, lIIIlIIIlIlIl);
                lIIIlIIIlIlIl += writeInt(lIIIlIIIllIII, lIIIlIIIlllII, lIIIlIIIlIlIl);
                lIIIlIIIlIlIl += writeInt(lIIIlIIIllIII, lIIIlIIIllllI, lIIIlIIIlIlIl);
                BigArrays.copyToBig(lIIIlIIIlIllI[lIIIlIIIlIIll], lIIIlIIIllllI, lIIIlIIIllIII, lIIIlIIIlIlIl, lIIIlIIIlllII);
                lIIIlIIIlIlIl += lIIIlIIIlllII;
            }
            lIIIlIIIlIIll = 1 - lIIIlIIIlIIll;
            ++lIIIlIIIlIlII;
        }
        this.n = lIIIlIIIlIlII;
        this.ratio = lIIIlIIIllIIl;
        this.array = BigArrays.trim(lIIIlIIIllIII, lIIIlIIIlIlIl);
        this.p = LongArrays.trim(lIIIlIIIlIlll, (lIIIlIIIlIlII + lIIIlIIIllIIl - 1) / lIIIlIIIllIIl);
    }
    
    private void readObject(final ObjectInputStream lIIIIIlIIIIlI) throws IOException, ClassNotFoundException {
        lIIIIIlIIIIlI.defaultReadObject();
        this.p = this.rebuildPointerArray();
    }
    
    private int length(final int lIIIIllIllIIl) {
        final int[][] lIIIIllIlllll = this.array;
        final int lIIIIllIllllI = lIIIIllIllIIl % this.ratio;
        long lIIIIllIlllIl = this.p[lIIIIllIllIIl / this.ratio];
        int lIIIIllIlllII = readInt(lIIIIllIlllll, lIIIIllIlllIl);
        if (lIIIIllIllllI == 0) {
            return lIIIIllIlllII;
        }
        lIIIIllIlllIl += count(lIIIIllIlllII) + lIIIIllIlllII;
        lIIIIllIlllII = readInt(lIIIIllIlllll, lIIIIllIlllIl);
        int lIIIIllIllIll = readInt(lIIIIllIlllll, lIIIIllIlllIl + count(lIIIIllIlllII));
        for (int lIIIIlllIIIlI = 0; lIIIIlllIIIlI < lIIIIllIllllI - 1; ++lIIIIlllIIIlI) {
            lIIIIllIlllIl += count(lIIIIllIlllII) + count(lIIIIllIllIll) + lIIIIllIlllII;
            lIIIIllIlllII = readInt(lIIIIllIlllll, lIIIIllIlllIl);
            lIIIIllIllIll = readInt(lIIIIllIlllll, lIIIIllIlllIl + count(lIIIIllIlllII));
        }
        return lIIIIllIlllII + lIIIIllIllIll;
    }
    
    public int[] getArray(final int lIIIIlIIlIlll) {
        this.ensureRestrictedIndex(lIIIIlIIlIlll);
        final int lIIIIlIIlIllI = this.length(lIIIIlIIlIlll);
        final int[] lIIIIlIIlIlIl = new int[lIIIIlIIlIllI];
        this.extract(lIIIIlIIlIlll, lIIIIlIIlIlIl, 0, lIIIIlIIlIllI);
        return lIIIIlIIlIlIl;
    }
    
    @Override
    public int size() {
        return this.n;
    }
    
    @Override
    public String toString() {
        final StringBuffer lIIIIIllIIlII = new StringBuffer();
        lIIIIIllIIlII.append("[");
        for (int lIIIIIllIIllI = 0; lIIIIIllIIllI < this.n; ++lIIIIIllIIllI) {
            if (lIIIIIllIIllI != 0) {
                lIIIIIllIIlII.append(", ");
            }
            lIIIIIllIIlII.append(IntArrayList.wrap(this.getArray(lIIIIIllIIllI)).toString());
        }
        lIIIIIllIIlII.append("]");
        return lIIIIIllIIlII.toString();
    }
}
