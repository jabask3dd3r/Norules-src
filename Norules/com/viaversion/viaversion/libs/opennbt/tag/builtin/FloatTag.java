package com.viaversion.viaversion.libs.opennbt.tag.builtin;

import java.io.*;

public class FloatTag extends NumberTag
{
    private /* synthetic */ float value;
    
    @Override
    public double asDouble() {
        return this.value;
    }
    
    @Override
    public byte asByte() {
        return (byte)this.value;
    }
    
    @Override
    public int hashCode() {
        return Float.hashCode(this.value);
    }
    
    @Override
    public int getTagId() {
        return 5;
    }
    
    @Override
    public float asFloat() {
        return this.value;
    }
    
    @Deprecated
    @Override
    public Float getValue() {
        return this.value;
    }
    
    public void setValue(final float lllllllllllllIIIIllllllIIlIIllll) {
        this.value = lllllllllllllIIIIllllllIIlIIllll;
    }
    
    static {
        ID = 5;
    }
    
    public FloatTag() {
        this(0.0f);
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIIIIllllllIIIllllII) {
        if (this == lllllllllllllIIIIllllllIIIllllII) {
            return true;
        }
        if (lllllllllllllIIIIllllllIIIllllII == null || this.getClass() != lllllllllllllIIIIllllllIIIllllII.getClass()) {
            return false;
        }
        final FloatTag lllllllllllllIIIIllllllIIIlllIll = (FloatTag)lllllllllllllIIIIllllllIIIllllII;
        return this.value == lllllllllllllIIIIllllllIIIlllIll.value;
    }
    
    @Override
    public short asShort() {
        return (short)this.value;
    }
    
    public FloatTag(final float lllllllllllllIIIIllllllIIlIllIII) {
        this.value = lllllllllllllIIIIllllllIIlIllIII;
    }
    
    @Override
    public final FloatTag clone() {
        return new FloatTag(this.value);
    }
    
    @Override
    public void write(final DataOutput lllllllllllllIIIIllllllIIlIIIIll) throws IOException {
        lllllllllllllIIIIllllllIIlIIIIll.writeFloat(this.value);
    }
    
    @Override
    public void read(final DataInput lllllllllllllIIIIllllllIIlIIlIIl) throws IOException {
        this.value = lllllllllllllIIIIllllllIIlIIlIIl.readFloat();
    }
    
    @Override
    public long asLong() {
        return (long)this.value;
    }
    
    @Override
    public int asInt() {
        return (int)this.value;
    }
}
