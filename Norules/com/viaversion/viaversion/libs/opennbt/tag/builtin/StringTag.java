package com.viaversion.viaversion.libs.opennbt.tag.builtin;

import com.google.common.base.*;
import java.io.*;

public class StringTag extends Tag
{
    private /* synthetic */ String value;
    
    public StringTag(final String lllllllllllllIlIlIIlllIIIIIlllll) {
        Preconditions.checkNotNull((Object)lllllllllllllIlIlIIlllIIIIIlllll);
        this.value = lllllllllllllIlIlIIlllIIIIIlllll;
    }
    
    @Override
    public int getTagId() {
        return 8;
    }
    
    @Override
    public void read(final DataInput lllllllllllllIlIlIIlllIIIIIlIIII) throws IOException {
        this.value = lllllllllllllIlIlIIlllIIIIIlIIII.readUTF();
    }
    
    @Override
    public final StringTag clone() {
        return new StringTag(this.value);
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIlIlIIlllIIIIIIIIlI) {
        if (this == lllllllllllllIlIlIIlllIIIIIIIIlI) {
            return true;
        }
        if (lllllllllllllIlIlIIlllIIIIIIIIlI == null || this.getClass() != lllllllllllllIlIlIIlllIIIIIIIIlI.getClass()) {
            return false;
        }
        final StringTag lllllllllllllIlIlIIlllIIIIIIIlII = (StringTag)lllllllllllllIlIlIIlllIIIIIIIIlI;
        return this.value.equals(lllllllllllllIlIlIIlllIIIIIIIlII.value);
    }
    
    @Override
    public void write(final DataOutput lllllllllllllIlIlIIlllIIIIIIlIlI) throws IOException {
        lllllllllllllIlIlIIlllIIIIIIlIlI.writeUTF(this.value);
    }
    
    @Override
    public int hashCode() {
        return this.value.hashCode();
    }
    
    public StringTag() {
        this("");
    }
    
    @Override
    public String getValue() {
        return this.value;
    }
    
    static {
        ID = 8;
    }
    
    public void setValue(final String lllllllllllllIlIlIIlllIIIIIlIllI) {
        Preconditions.checkNotNull((Object)lllllllllllllIlIlIIlllIIIIIlIllI);
        this.value = lllllllllllllIlIlIIlllIIIIIlIllI;
    }
}
