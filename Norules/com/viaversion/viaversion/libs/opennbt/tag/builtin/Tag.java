package com.viaversion.viaversion.libs.opennbt.tag.builtin;

import java.lang.reflect.*;
import java.io.*;

public abstract class Tag implements Cloneable
{
    public abstract void write(final DataOutput p0) throws IOException;
    
    public abstract Tag clone();
    
    @Override
    public String toString() {
        String lllllllllllllIIIIlIIIIllllIIIlIl = "";
        if (this.getValue() != null) {
            lllllllllllllIIIIlIIIIllllIIIlIl = this.getValue().toString();
            if (this.getValue().getClass().isArray()) {
                final StringBuilder lllllllllllllIIIIlIIIIllllIIIlll = new StringBuilder();
                lllllllllllllIIIIlIIIIllllIIIlll.append("[");
                for (int lllllllllllllIIIIlIIIIllllIIlIII = 0; lllllllllllllIIIIlIIIIllllIIlIII < Array.getLength(this.getValue()); ++lllllllllllllIIIIlIIIIllllIIlIII) {
                    if (lllllllllllllIIIIlIIIIllllIIlIII > 0) {
                        lllllllllllllIIIIlIIIIllllIIIlll.append(", ");
                    }
                    lllllllllllllIIIIlIIIIllllIIIlll.append(Array.get(this.getValue(), lllllllllllllIIIIlIIIIllllIIlIII));
                }
                lllllllllllllIIIIlIIIIllllIIIlll.append("]");
                lllllllllllllIIIIlIIIIllllIIIlIl = String.valueOf(lllllllllllllIIIIlIIIIllllIIIlll);
            }
        }
        return String.valueOf(new StringBuilder().append(this.getClass().getSimpleName()).append(" { ").append(lllllllllllllIIIIlIIIIllllIIIlIl).append(" }"));
    }
    
    public abstract void read(final DataInput p0) throws IOException;
    
    public abstract int getTagId();
    
    public abstract Object getValue();
}
