package com.viaversion.viaversion.libs.opennbt.tag.builtin;

import java.util.*;
import java.io.*;

public class ByteArrayTag extends Tag
{
    private /* synthetic */ byte[] value;
    
    public ByteArrayTag(final byte[] lllllllllllllllIIIlllIllllIlllll) {
        this.value = lllllllllllllllIIIlllIllllIlllll;
    }
    
    static {
        ID = 7;
    }
    
    @Override
    public boolean equals(final Object lllllllllllllllIIIlllIlllIllIIll) {
        if (this == lllllllllllllllIIIlllIlllIllIIll) {
            return true;
        }
        if (lllllllllllllllIIIlllIlllIllIIll == null || this.getClass() != lllllllllllllllIIIlllIlllIllIIll.getClass()) {
            return false;
        }
        final ByteArrayTag lllllllllllllllIIIlllIlllIllIIlI = (ByteArrayTag)lllllllllllllllIIIlllIlllIllIIll;
        return Arrays.equals(this.value, lllllllllllllllIIIlllIlllIllIIlI.value);
    }
    
    public ByteArrayTag() {
        this(new byte[0]);
    }
    
    public byte getValue(final int lllllllllllllllIIIlllIllllIlIIII) {
        return this.value[lllllllllllllllIIIlllIllllIlIIII];
    }
    
    @Override
    public final ByteArrayTag clone() {
        return new ByteArrayTag(this.value);
    }
    
    public void setValue(final int lllllllllllllllIIIlllIllllIIlIll, final byte lllllllllllllllIIIlllIllllIIlIlI) {
        this.value[lllllllllllllllIIIlllIllllIIlIll] = lllllllllllllllIIIlllIllllIIlIlI;
    }
    
    @Override
    public void read(final DataInput lllllllllllllllIIIlllIllllIIIIII) throws IOException {
        this.value = new byte[lllllllllllllllIIIlllIllllIIIIII.readInt()];
        lllllllllllllllIIIlllIllllIIIIII.readFully(this.value);
    }
    
    public void setValue(final byte[] lllllllllllllllIIIlllIllllIllIII) {
        if (lllllllllllllllIIIlllIllllIllIII == null) {
            return;
        }
        this.value = lllllllllllllllIIIlllIllllIllIII;
    }
    
    @Override
    public int hashCode() {
        return Arrays.hashCode(this.value);
    }
    
    @Override
    public byte[] getValue() {
        return this.value;
    }
    
    @Override
    public void write(final DataOutput lllllllllllllllIIIlllIlllIlllIlI) throws IOException {
        lllllllllllllllIIIlllIlllIlllIlI.writeInt(this.value.length);
        lllllllllllllllIIIlllIlllIlllIlI.write(this.value);
    }
    
    public int length() {
        return this.value.length;
    }
    
    @Override
    public int getTagId() {
        return 7;
    }
}
