package com.viaversion.viaversion.libs.opennbt.tag.builtin;

import java.io.*;

public class LongTag extends NumberTag
{
    private /* synthetic */ long value;
    
    @Override
    public void write(final DataOutput lllllllllllllIlIlIlIlIlllIIlIlIl) throws IOException {
        lllllllllllllIlIlIlIlIlllIIlIlIl.writeLong(this.value);
    }
    
    @Override
    public int getTagId() {
        return 4;
    }
    
    @Override
    public short asShort() {
        return (short)this.value;
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIlIlIlIlIlllIIIllIl) {
        if (this == lllllllllllllIlIlIlIlIlllIIIllIl) {
            return true;
        }
        if (lllllllllllllIlIlIlIlIlllIIIllIl == null || this.getClass() != lllllllllllllIlIlIlIlIlllIIIllIl.getClass()) {
            return false;
        }
        final LongTag lllllllllllllIlIlIlIlIlllIIIllll = (LongTag)lllllllllllllIlIlIlIlIlllIIIllIl;
        return this.value == lllllllllllllIlIlIlIlIlllIIIllll.value;
    }
    
    @Override
    public long asLong() {
        return this.value;
    }
    
    public void setValue(final long lllllllllllllIlIlIlIlIlllIlIIIIl) {
        this.value = lllllllllllllIlIlIlIlIlllIlIIIIl;
    }
    
    public LongTag() {
        this(0L);
    }
    
    @Deprecated
    @Override
    public Long getValue() {
        return this.value;
    }
    
    @Override
    public float asFloat() {
        return (float)this.value;
    }
    
    @Override
    public int hashCode() {
        return Long.hashCode(this.value);
    }
    
    @Override
    public void read(final DataInput lllllllllllllIlIlIlIlIlllIIlllIl) throws IOException {
        this.value = lllllllllllllIlIlIlIlIlllIIlllIl.readLong();
    }
    
    @Override
    public final LongTag clone() {
        return new LongTag(this.value);
    }
    
    static {
        ID = 4;
    }
    
    @Override
    public double asDouble() {
        return (double)this.value;
    }
    
    @Override
    public byte asByte() {
        return (byte)this.value;
    }
    
    public LongTag(final long lllllllllllllIlIlIlIlIlllIlIlIlI) {
        this.value = lllllllllllllIlIlIlIlIlllIlIlIlI;
    }
    
    @Override
    public int asInt() {
        return (int)this.value;
    }
}
