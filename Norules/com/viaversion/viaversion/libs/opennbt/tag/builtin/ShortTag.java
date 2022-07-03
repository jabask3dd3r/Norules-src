package com.viaversion.viaversion.libs.opennbt.tag.builtin;

import java.io.*;

public class ShortTag extends NumberTag
{
    private /* synthetic */ short value;
    
    @Override
    public boolean equals(final Object llllllllllllllIIIIIIIlllIlIlIIlI) {
        if (this == llllllllllllllIIIIIIIlllIlIlIIlI) {
            return true;
        }
        if (llllllllllllllIIIIIIIlllIlIlIIlI == null || this.getClass() != llllllllllllllIIIIIIIlllIlIlIIlI.getClass()) {
            return false;
        }
        final ShortTag llllllllllllllIIIIIIIlllIlIlIIIl = (ShortTag)llllllllllllllIIIIIIIlllIlIlIIlI;
        return this.value == llllllllllllllIIIIIIIlllIlIlIIIl.value;
    }
    
    @Override
    public double asDouble() {
        return this.value;
    }
    
    @Deprecated
    @Override
    public Short getValue() {
        return this.value;
    }
    
    @Override
    public void write(final DataOutput llllllllllllllIIIIIIIlllIlIlIlll) throws IOException {
        llllllllllllllIIIIIIIlllIlIlIlll.writeShort(this.value);
    }
    
    @Override
    public byte asByte() {
        return (byte)this.value;
    }
    
    @Override
    public float asFloat() {
        return this.value;
    }
    
    @Override
    public final ShortTag clone() {
        return new ShortTag(this.value);
    }
    
    @Override
    public int asInt() {
        return this.value;
    }
    
    @Override
    public void read(final DataInput llllllllllllllIIIIIIIlllIlIlllIl) throws IOException {
        this.value = llllllllllllllIIIIIIIlllIlIlllIl.readShort();
    }
    
    public ShortTag() {
        this((short)0);
    }
    
    @Override
    public int getTagId() {
        return 2;
    }
    
    public void setValue(final short llllllllllllllIIIIIIIlllIllIIIll) {
        this.value = llllllllllllllIIIIIIIlllIllIIIll;
    }
    
    @Override
    public long asLong() {
        return this.value;
    }
    
    static {
        ID = 2;
    }
    
    public ShortTag(final short llllllllllllllIIIIIIIlllIllIlllI) {
        this.value = llllllllllllllIIIIIIIlllIllIlllI;
    }
    
    @Override
    public int hashCode() {
        return this.value;
    }
    
    @Override
    public short asShort() {
        return this.value;
    }
}
