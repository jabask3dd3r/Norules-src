package com.viaversion.viaversion.libs.opennbt.tag.builtin;

import com.google.common.base.*;
import java.io.*;
import java.util.*;

public class LongArrayTag extends Tag
{
    private /* synthetic */ long[] value;
    
    @Override
    public void read(final DataInput lllllllllllllIllIIllllIIlllIlIll) throws IOException {
        this.value = new long[lllllllllllllIllIIllllIIlllIlIll.readInt()];
        for (int lllllllllllllIllIIllllIIlllIllll = 0; lllllllllllllIllIIllllIIlllIllll < this.value.length; ++lllllllllllllIllIIllllIIlllIllll) {
            this.value[lllllllllllllIllIIllllIIlllIllll] = lllllllllllllIllIIllllIIlllIlIll.readLong();
        }
    }
    
    public int length() {
        return this.value.length;
    }
    
    public LongArrayTag(final long[] lllllllllllllIllIIllllIlIIIlIIII) {
        Preconditions.checkNotNull((Object)lllllllllllllIllIIllllIlIIIlIIII);
        this.value = lllllllllllllIllIIllllIlIIIlIIII;
    }
    
    @Override
    public long[] getValue() {
        return this.value;
    }
    
    @Override
    public final LongArrayTag clone() {
        return new LongArrayTag(this.value.clone());
    }
    
    @Override
    public void write(final DataOutput lllllllllllllIllIIllllIIlllIIIIl) throws IOException {
        lllllllllllllIllIIllllIIlllIIIIl.writeInt(this.value.length);
        final boolean lllllllllllllIllIIllllIIllIllllI = (Object)this.value;
        final double lllllllllllllIllIIllllIIllIlllIl = lllllllllllllIllIIllllIIllIllllI.length;
        for (byte lllllllllllllIllIIllllIIllIlllII = 0; lllllllllllllIllIIllllIIllIlllII < lllllllllllllIllIIllllIIllIlllIl; ++lllllllllllllIllIIllllIIllIlllII) {
            final long lllllllllllllIllIIllllIIlllIIIll = lllllllllllllIllIIllllIIllIllllI[lllllllllllllIllIIllllIIllIlllII];
            lllllllllllllIllIIllllIIlllIIIIl.writeLong(lllllllllllllIllIIllllIIlllIIIll);
        }
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIllIIllllIIllIlIIll) {
        if (this == lllllllllllllIllIIllllIIllIlIIll) {
            return true;
        }
        if (lllllllllllllIllIIllllIIllIlIIll == null || this.getClass() != lllllllllllllIllIIllllIIllIlIIll.getClass()) {
            return false;
        }
        final LongArrayTag lllllllllllllIllIIllllIIllIlIlIl = (LongArrayTag)lllllllllllllIllIIllllIIllIlIIll;
        return Arrays.equals(this.value, lllllllllllllIllIIllllIIllIlIlIl.value);
    }
    
    @Override
    public int getTagId() {
        return 12;
    }
    
    public LongArrayTag() {
        this(new long[0]);
    }
    
    public long getValue(final int lllllllllllllIllIIllllIlIIIIIIIl) {
        return this.value[lllllllllllllIllIIllllIlIIIIIIIl];
    }
    
    static {
        ID = 12;
    }
    
    public void setValue(final long[] lllllllllllllIllIIllllIlIIIIIlIl) {
        Preconditions.checkNotNull((Object)lllllllllllllIllIIllllIlIIIIIlIl);
        this.value = lllllllllllllIllIIllllIlIIIIIlIl;
    }
    
    public void setValue(final int lllllllllllllIllIIllllIIlllllIlI, final long lllllllllllllIllIIllllIIlllllIIl) {
        this.value[lllllllllllllIllIIllllIIlllllIlI] = lllllllllllllIllIIllllIIlllllIIl;
    }
    
    @Override
    public int hashCode() {
        return Arrays.hashCode(this.value);
    }
}
