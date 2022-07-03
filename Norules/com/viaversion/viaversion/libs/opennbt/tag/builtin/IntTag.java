package com.viaversion.viaversion.libs.opennbt.tag.builtin;

import java.io.*;

public class IntTag extends NumberTag
{
    private /* synthetic */ int value;
    
    @Override
    public final IntTag clone() {
        return new IntTag(this.value);
    }
    
    public IntTag(final int lllllllllllllIIlllllllllIlIIlIIl) {
        this.value = lllllllllllllIIlllllllllIlIIlIIl;
    }
    
    @Override
    public byte asByte() {
        return (byte)this.value;
    }
    
    @Override
    public void write(final DataOutput lllllllllllllIIlllllllllIIllIlII) throws IOException {
        lllllllllllllIIlllllllllIIllIlII.writeInt(this.value);
    }
    
    @Override
    public float asFloat() {
        return (float)this.value;
    }
    
    @Deprecated
    @Override
    public Integer getValue() {
        return this.value;
    }
    
    @Override
    public short asShort() {
        return (short)this.value;
    }
    
    @Override
    public void read(final DataInput lllllllllllllIIlllllllllIIlllIII) throws IOException {
        this.value = lllllllllllllIIlllllllllIIlllIII.readInt();
    }
    
    @Override
    public int getTagId() {
        return 3;
    }
    
    public void setValue(final int lllllllllllllIIlllllllllIIlllllI) {
        this.value = lllllllllllllIIlllllllllIIlllllI;
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIIlllllllllIIlIlIlI) {
        if (this == lllllllllllllIIlllllllllIIlIlIlI) {
            return true;
        }
        if (lllllllllllllIIlllllllllIIlIlIlI == null || this.getClass() != lllllllllllllIIlllllllllIIlIlIlI.getClass()) {
            return false;
        }
        final IntTag lllllllllllllIIlllllllllIIlIllII = (IntTag)lllllllllllllIIlllllllllIIlIlIlI;
        return this.value == lllllllllllllIIlllllllllIIlIllII.value;
    }
    
    @Override
    public int asInt() {
        return this.value;
    }
    
    public IntTag() {
        this(0);
    }
    
    @Override
    public int hashCode() {
        return this.value;
    }
    
    @Override
    public double asDouble() {
        return this.value;
    }
    
    @Override
    public long asLong() {
        return this.value;
    }
    
    static {
        ID = 3;
    }
}
