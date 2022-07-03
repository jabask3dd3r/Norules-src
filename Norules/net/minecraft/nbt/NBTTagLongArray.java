package net.minecraft.nbt;

import java.util.*;
import java.io.*;

public class NBTTagLongArray extends NBTBase
{
    private /* synthetic */ long[] field_193587_b;
    
    public NBTTagLongArray(final long[] lllllllllllllIIIIIIIIllllIlIlIIl) {
        this.field_193587_b = lllllllllllllIIIIIIIIllllIlIlIIl;
    }
    
    @Override
    public int hashCode() {
        return super.hashCode() ^ Arrays.hashCode(this.field_193587_b);
    }
    
    @Override
    public byte getId() {
        return 12;
    }
    
    NBTTagLongArray() {
    }
    
    public NBTTagLongArray(final List<Long> lllllllllllllIIIIIIIIllllIlIIIIl) {
        this(func_193586_a(lllllllllllllIIIIIIIIllllIlIIIIl));
    }
    
    @Override
    void write(final DataOutput lllllllllllllIIIIIIIIllllIIIlIlI) throws IOException {
        lllllllllllllIIIIIIIIllllIIIlIlI.writeInt(this.field_193587_b.length);
        final Exception lllllllllllllIIIIIIIIllllIIIIllI;
        final String lllllllllllllIIIIIIIIllllIIIIlll = (String)((long[])(Object)(lllllllllllllIIIIIIIIllllIIIIllI = (Exception)(Object)this.field_193587_b)).length;
        for (byte lllllllllllllIIIIIIIIllllIIIlIII = 0; lllllllllllllIIIIIIIIllllIIIlIII < lllllllllllllIIIIIIIIllllIIIIlll; ++lllllllllllllIIIIIIIIllllIIIlIII) {
            final long lllllllllllllIIIIIIIIllllIIIllII = lllllllllllllIIIIIIIIllllIIIIllI[lllllllllllllIIIIIIIIllllIIIlIII];
            lllllllllllllIIIIIIIIllllIIIlIlI.writeLong(lllllllllllllIIIIIIIIllllIIIllII);
        }
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIIIIIIIIlllIllIIIII) {
        return super.equals(lllllllllllllIIIIIIIIlllIllIIIII) && Arrays.equals(this.field_193587_b, ((NBTTagLongArray)lllllllllllllIIIIIIIIlllIllIIIII).field_193587_b);
    }
    
    @Override
    void read(final DataInput lllllllllllllIIIIIIIIlllIllllIIl, final int lllllllllllllIIIIIIIIlllIllllllI, final NBTSizeTracker lllllllllllllIIIIIIIIlllIlllllIl) throws IOException {
        lllllllllllllIIIIIIIIlllIlllllIl.read(192L);
        final int lllllllllllllIIIIIIIIlllIlllllII = lllllllllllllIIIIIIIIlllIllllIIl.readInt();
        lllllllllllllIIIIIIIIlllIlllllIl.read(64 * lllllllllllllIIIIIIIIlllIlllllII);
        this.field_193587_b = new long[lllllllllllllIIIIIIIIlllIlllllII];
        for (int lllllllllllllIIIIIIIIlllIllllIll = 0; lllllllllllllIIIIIIIIlllIllllIll < lllllllllllllIIIIIIIIlllIlllllII; ++lllllllllllllIIIIIIIIlllIllllIll) {
            this.field_193587_b[lllllllllllllIIIIIIIIlllIllllIll] = lllllllllllllIIIIIIIIlllIllllIIl.readLong();
        }
    }
    
    private static long[] func_193586_a(final List<Long> lllllllllllllIIIIIIIIllllIIlllII) {
        final long[] lllllllllllllIIIIIIIIllllIIllIll = new long[lllllllllllllIIIIIIIIllllIIlllII.size()];
        for (int lllllllllllllIIIIIIIIllllIIllIlI = 0; lllllllllllllIIIIIIIIllllIIllIlI < lllllllllllllIIIIIIIIllllIIlllII.size(); ++lllllllllllllIIIIIIIIllllIIllIlI) {
            final Long lllllllllllllIIIIIIIIllllIIllIIl = lllllllllllllIIIIIIIIllllIIlllII.get(lllllllllllllIIIIIIIIllllIIllIlI);
            lllllllllllllIIIIIIIIllllIIllIll[lllllllllllllIIIIIIIIllllIIllIlI] = ((lllllllllllllIIIIIIIIllllIIllIIl == null) ? 0L : lllllllllllllIIIIIIIIllllIIllIIl);
        }
        return lllllllllllllIIIIIIIIllllIIllIll;
    }
    
    @Override
    public NBTTagLongArray copy() {
        final long[] lllllllllllllIIIIIIIIlllIllIlIII = new long[this.field_193587_b.length];
        System.arraycopy(this.field_193587_b, 0, lllllllllllllIIIIIIIIlllIllIlIII, 0, this.field_193587_b.length);
        return new NBTTagLongArray(lllllllllllllIIIIIIIIlllIllIlIII);
    }
    
    @Override
    public String toString() {
        final StringBuilder lllllllllllllIIIIIIIIlllIlllIIII = new StringBuilder("[L;");
        for (int lllllllllllllIIIIIIIIlllIllIllll = 0; lllllllllllllIIIIIIIIlllIllIllll < this.field_193587_b.length; ++lllllllllllllIIIIIIIIlllIllIllll) {
            if (lllllllllllllIIIIIIIIlllIllIllll != 0) {
                lllllllllllllIIIIIIIIlllIlllIIII.append(',');
            }
            lllllllllllllIIIIIIIIlllIlllIIII.append(this.field_193587_b[lllllllllllllIIIIIIIIlllIllIllll]).append('L');
        }
        return String.valueOf(lllllllllllllIIIIIIIIlllIlllIIII.append(']'));
    }
}
