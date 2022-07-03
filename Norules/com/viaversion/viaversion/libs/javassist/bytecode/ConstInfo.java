package com.viaversion.viaversion.libs.javassist.bytecode;

import java.util.*;
import java.io.*;

abstract class ConstInfo
{
    /* synthetic */ int index;
    
    public abstract void print(final PrintWriter p0);
    
    public String getClassName(final ConstPool lllllllllllllIlIIIlIIIlIlIIllllI) {
        return null;
    }
    
    public void renameClass(final ConstPool lllllllllllllIlIIIlIIIlIlIIlIlll, final Map<String, String> lllllllllllllIlIIIlIIIlIlIIlIllI, final Map<ConstInfo, ConstInfo> lllllllllllllIlIIIlIIIlIlIIlIlIl) {
    }
    
    public abstract void write(final DataOutputStream p0) throws IOException;
    
    public abstract int getTag();
    
    public ConstInfo(final int lllllllllllllIlIIIlIIIlIlIlIIIlI) {
        this.index = lllllllllllllIlIIIlIIIlIlIlIIIlI;
    }
    
    public void renameClass(final ConstPool lllllllllllllIlIIIlIIIlIlIIlllII, final String lllllllllllllIlIIIlIIIlIlIIllIll, final String lllllllllllllIlIIIlIIIlIlIIllIlI, final Map<ConstInfo, ConstInfo> lllllllllllllIlIIIlIIIlIlIIllIIl) {
    }
    
    public abstract int copy(final ConstPool p0, final ConstPool p1, final Map<String, String> p2);
    
    @Override
    public String toString() {
        final ByteArrayOutputStream lllllllllllllIlIIIlIIIlIlIIlIIII = new ByteArrayOutputStream();
        final PrintWriter lllllllllllllIlIIIlIIIlIlIIIllll = new PrintWriter(lllllllllllllIlIIIlIIIlIlIIlIIII);
        this.print(lllllllllllllIlIIIlIIIlIlIIIllll);
        return lllllllllllllIlIIIlIIIlIlIIlIIII.toString();
    }
}
