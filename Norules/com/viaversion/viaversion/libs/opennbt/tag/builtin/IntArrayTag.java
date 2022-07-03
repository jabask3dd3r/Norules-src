package com.viaversion.viaversion.libs.opennbt.tag.builtin;

import java.util.*;
import com.google.common.base.*;
import java.io.*;

public class IntArrayTag extends Tag
{
    private /* synthetic */ int[] value;
    
    @Override
    public int hashCode() {
        return Arrays.hashCode(this.value);
    }
    
    @Override
    public void read(final DataInput llllllllllllIlllllIllIIlIIIlIIll) throws IOException {
        this.value = new int[llllllllllllIlllllIllIIlIIIlIIll.readInt()];
        for (int llllllllllllIlllllIllIIlIIIlIlll = 0; llllllllllllIlllllIllIIlIIIlIlll < this.value.length; ++llllllllllllIlllllIllIIlIIIlIlll) {
            this.value[llllllllllllIlllllIllIIlIIIlIlll] = llllllllllllIlllllIllIIlIIIlIIll.readInt();
        }
    }
    
    @Override
    public boolean equals(final Object llllllllllllIlllllIllIIIlllllIll) {
        if (this == llllllllllllIlllllIllIIIlllllIll) {
            return true;
        }
        if (llllllllllllIlllllIllIIIlllllIll == null || this.getClass() != llllllllllllIlllllIllIIIlllllIll.getClass()) {
            return false;
        }
        final IntArrayTag llllllllllllIlllllIllIIIllllllIl = (IntArrayTag)llllllllllllIlllllIllIIIlllllIll;
        return Arrays.equals(this.value, llllllllllllIlllllIllIIIllllllIl.value);
    }
    
    public IntArrayTag(final int[] llllllllllllIlllllIllIIlIIllIllI) {
        Preconditions.checkNotNull((Object)llllllllllllIlllllIllIIlIIllIllI);
        this.value = llllllllllllIlllllIllIIlIIllIllI;
    }
    
    @Override
    public int[] getValue() {
        return this.value;
    }
    
    public void setValue(final int llllllllllllIlllllIllIIlIIIlllll, final int llllllllllllIlllllIllIIlIIIllllI) {
        this.value[llllllllllllIlllllIllIIlIIIlllll] = llllllllllllIlllllIllIIlIIIllllI;
    }
    
    @Override
    public void write(final DataOutput llllllllllllIlllllIllIIlIIIIIlll) throws IOException {
        llllllllllllIlllllIllIIlIIIIIlll.writeInt(this.value.length);
        final float llllllllllllIlllllIllIIlIIIIIllI = (Object)this.value;
        final short llllllllllllIlllllIllIIlIIIIIlIl = (short)llllllllllllIlllllIllIIlIIIIIllI.length;
        for (boolean llllllllllllIlllllIllIIlIIIIIlII = false; (llllllllllllIlllllIllIIlIIIIIlII ? 1 : 0) < llllllllllllIlllllIllIIlIIIIIlIl; ++llllllllllllIlllllIllIIlIIIIIlII) {
            final int llllllllllllIlllllIllIIlIIIIlIll = llllllllllllIlllllIllIIlIIIIIllI[llllllllllllIlllllIllIIlIIIIIlII];
            llllllllllllIlllllIllIIlIIIIIlll.writeInt(llllllllllllIlllllIllIIlIIIIlIll);
        }
    }
    
    public int getValue(final int llllllllllllIlllllIllIIlIIlIlIIl) {
        return this.value[llllllllllllIlllllIllIIlIIlIlIIl];
    }
    
    @Override
    public final IntArrayTag clone() {
        return new IntArrayTag(this.value.clone());
    }
    
    public int length() {
        return this.value.length;
    }
    
    public IntArrayTag() {
        this(new int[0]);
    }
    
    @Override
    public int getTagId() {
        return 11;
    }
    
    public void setValue(final int[] llllllllllllIlllllIllIIlIIlIllIl) {
        Preconditions.checkNotNull((Object)llllllllllllIlllllIllIIlIIlIllIl);
        this.value = llllllllllllIlllllIllIIlIIlIllIl;
    }
    
    static {
        ID = 11;
    }
}
