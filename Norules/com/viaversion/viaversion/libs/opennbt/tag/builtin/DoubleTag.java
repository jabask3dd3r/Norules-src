package com.viaversion.viaversion.libs.opennbt.tag.builtin;

import java.io.*;

public class DoubleTag extends NumberTag
{
    private /* synthetic */ double value;
    
    @Override
    public int getTagId() {
        return 6;
    }
    
    @Override
    public float asFloat() {
        return (float)this.value;
    }
    
    @Override
    public int asInt() {
        return (int)this.value;
    }
    
    @Override
    public void write(final DataOutput lllllllllllllllIIIIIIIllIIlllIll) throws IOException {
        lllllllllllllllIIIIIIIllIIlllIll.writeDouble(this.value);
    }
    
    @Override
    public int hashCode() {
        return Double.hashCode(this.value);
    }
    
    @Override
    public double asDouble() {
        return this.value;
    }
    
    @Override
    public long asLong() {
        return (long)this.value;
    }
    
    @Override
    public boolean equals(final Object lllllllllllllllIIIIIIIllIIllIlII) {
        if (this == lllllllllllllllIIIIIIIllIIllIlII) {
            return true;
        }
        if (lllllllllllllllIIIIIIIllIIllIlII == null || this.getClass() != lllllllllllllllIIIIIIIllIIllIlII.getClass()) {
            return false;
        }
        final DoubleTag lllllllllllllllIIIIIIIllIIllIIll = (DoubleTag)lllllllllllllllIIIIIIIllIIllIlII;
        return this.value == lllllllllllllllIIIIIIIllIIllIIll.value;
    }
    
    @Override
    public void read(final DataInput lllllllllllllllIIIIIIIllIIllllll) throws IOException {
        this.value = lllllllllllllllIIIIIIIllIIllllll.readDouble();
    }
    
    public DoubleTag(final double lllllllllllllllIIIIIIIllIlIlIIII) {
        this.value = lllllllllllllllIIIIIIIllIlIlIIII;
    }
    
    @Override
    public final DoubleTag clone() {
        return new DoubleTag(this.value);
    }
    
    @Deprecated
    @Override
    public Double getValue() {
        return this.value;
    }
    
    @Override
    public short asShort() {
        return (short)this.value;
    }
    
    public DoubleTag() {
        this(0.0);
    }
    
    @Override
    public byte asByte() {
        return (byte)this.value;
    }
    
    public void setValue(final double lllllllllllllllIIIIIIIllIlIIIlll) {
        this.value = lllllllllllllllIIIIIIIllIlIIIlll;
    }
    
    static {
        ID = 6;
    }
}
