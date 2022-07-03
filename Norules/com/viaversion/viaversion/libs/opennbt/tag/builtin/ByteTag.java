package com.viaversion.viaversion.libs.opennbt.tag.builtin;

import java.io.*;

public class ByteTag extends NumberTag
{
    private /* synthetic */ byte value;
    
    @Override
    public long asLong() {
        return this.value;
    }
    
    public ByteTag() {
        this((byte)0);
    }
    
    @Override
    public double asDouble() {
        return this.value;
    }
    
    @Deprecated
    @Override
    public Byte getValue() {
        return this.value;
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIIIIlIllIlIlIIIIllI) {
        if (this == lllllllllllllIIIIlIllIlIlIIIIllI) {
            return true;
        }
        if (lllllllllllllIIIIlIllIlIlIIIIllI == null || this.getClass() != lllllllllllllIIIIlIllIlIlIIIIllI.getClass()) {
            return false;
        }
        final ByteTag lllllllllllllIIIIlIllIlIlIIIlIII = (ByteTag)lllllllllllllIIIIlIllIlIlIIIIllI;
        return this.value == lllllllllllllIIIIlIllIlIlIIIlIII.value;
    }
    
    @Override
    public float asFloat() {
        return this.value;
    }
    
    @Override
    public int getTagId() {
        return 1;
    }
    
    @Override
    public short asShort() {
        return this.value;
    }
    
    @Override
    public int hashCode() {
        return this.value;
    }
    
    @Override
    public int asInt() {
        return this.value;
    }
    
    @Override
    public void read(final DataInput lllllllllllllIIIIlIllIlIlIIlIlII) throws IOException {
        this.value = lllllllllllllIIIIlIllIlIlIIlIlII.readByte();
    }
    
    @Override
    public void write(final DataOutput lllllllllllllIIIIlIllIlIlIIIlllI) throws IOException {
        lllllllllllllIIIIlIllIlIlIIIlllI.writeByte(this.value);
    }
    
    static {
        ID = 1;
    }
    
    @Override
    public byte asByte() {
        return this.value;
    }
    
    public void setValue(final byte lllllllllllllIIIIlIllIlIlIIllIlI) {
        this.value = lllllllllllllIIIIlIllIlIlIIllIlI;
    }
    
    @Override
    public final ByteTag clone() {
        return new ByteTag(this.value);
    }
    
    public ByteTag(final byte lllllllllllllIIIIlIllIlIlIlIIIll) {
        this.value = lllllllllllllIIIIlIllIlIlIlIIIll;
    }
}
