package com.viaversion.viaversion.libs.javassist.bytecode;

import java.util.*;
import java.io.*;

class ClassInfo extends ConstInfo
{
    /* synthetic */ int name;
    
    @Override
    public boolean equals(final Object lllllllllllllllIIIIlllIlIllIIIlI) {
        return lllllllllllllllIIIIlllIlIllIIIlI instanceof ClassInfo && ((ClassInfo)lllllllllllllllIIIIlllIlIllIIIlI).name == this.name;
    }
    
    @Override
    public int getTag() {
        return 7;
    }
    
    @Override
    public int hashCode() {
        return this.name;
    }
    
    @Override
    public void print(final PrintWriter lllllllllllllllIIIIlllIlIIIlIIIl) {
        lllllllllllllllIIIIlllIlIIIlIIIl.print("Class #");
        lllllllllllllllIIIIlllIlIIIlIIIl.println(this.name);
    }
    
    @Override
    public void renameClass(final ConstPool lllllllllllllllIIIIlllIlIlIlIIII, final String lllllllllllllllIIIIlllIlIlIIllll, final String lllllllllllllllIIIIlllIlIlIIlllI, final Map<ConstInfo, ConstInfo> lllllllllllllllIIIIlllIlIlIIIllI) {
        final String lllllllllllllllIIIIlllIlIlIIllII = lllllllllllllllIIIIlllIlIlIlIIII.getUtf8Info(this.name);
        String lllllllllllllllIIIIlllIlIlIIlIll = null;
        if (lllllllllllllllIIIIlllIlIlIIllII.equals(lllllllllllllllIIIIlllIlIlIIllll)) {
            lllllllllllllllIIIIlllIlIlIIlIll = lllllllllllllllIIIIlllIlIlIIlllI;
        }
        else if (lllllllllllllllIIIIlllIlIlIIllII.charAt(0) == '[') {
            final String lllllllllllllllIIIIlllIlIlIlIIlI = Descriptor.rename(lllllllllllllllIIIIlllIlIlIIllII, lllllllllllllllIIIIlllIlIlIIllll, lllllllllllllllIIIIlllIlIlIIlllI);
            if (lllllllllllllllIIIIlllIlIlIIllII != lllllllllllllllIIIIlllIlIlIlIIlI) {
                lllllllllllllllIIIIlllIlIlIIlIll = lllllllllllllllIIIIlllIlIlIlIIlI;
            }
        }
        if (lllllllllllllllIIIIlllIlIlIIlIll != null) {
            if (lllllllllllllllIIIIlllIlIlIIIllI == null) {
                this.name = lllllllllllllllIIIIlllIlIlIlIIII.addUtf8Info(lllllllllllllllIIIIlllIlIlIIlIll);
            }
            else {
                lllllllllllllllIIIIlllIlIlIIIllI.remove(this);
                this.name = lllllllllllllllIIIIlllIlIlIlIIII.addUtf8Info(lllllllllllllllIIIIlllIlIlIIlIll);
                lllllllllllllllIIIIlllIlIlIIIllI.put(this, this);
            }
        }
    }
    
    @Override
    public void write(final DataOutputStream lllllllllllllllIIIIlllIlIIIlIlll) throws IOException {
        lllllllllllllllIIIIlllIlIIIlIlll.writeByte(7);
        lllllllllllllllIIIIlllIlIIIlIlll.writeShort(this.name);
    }
    
    @Override
    public String getClassName(final ConstPool lllllllllllllllIIIIlllIlIlIllIll) {
        return lllllllllllllllIIIIlllIlIlIllIll.getUtf8Info(this.name);
    }
    
    public ClassInfo(final int lllllllllllllllIIIIlllIlIllllIII, final int lllllllllllllllIIIIlllIlIlllIlll) {
        super(lllllllllllllllIIIIlllIlIlllIlll);
        this.name = lllllllllllllllIIIIlllIlIllllIII;
    }
    
    @Override
    public int copy(final ConstPool lllllllllllllllIIIIlllIlIIIlllll, final ConstPool lllllllllllllllIIIIlllIlIIIllllI, final Map<String, String> lllllllllllllllIIIIlllIlIIlIIIlI) {
        String lllllllllllllllIIIIlllIlIIlIIIIl = lllllllllllllllIIIIlllIlIIIlllll.getUtf8Info(this.name);
        if (lllllllllllllllIIIIlllIlIIlIIIlI != null) {
            final String lllllllllllllllIIIIlllIlIIlIIllI = lllllllllllllllIIIIlllIlIIlIIIlI.get(lllllllllllllllIIIIlllIlIIlIIIIl);
            if (lllllllllllllllIIIIlllIlIIlIIllI != null) {
                lllllllllllllllIIIIlllIlIIlIIIIl = lllllllllllllllIIIIlllIlIIlIIllI;
            }
        }
        return lllllllllllllllIIIIlllIlIIIllllI.addClassInfo(lllllllllllllllIIIIlllIlIIlIIIIl);
    }
    
    static {
        tag = 7;
    }
    
    @Override
    public void renameClass(final ConstPool lllllllllllllllIIIIlllIlIIlllIII, final Map<String, String> lllllllllllllllIIIIlllIlIIllIlll, final Map<ConstInfo, ConstInfo> lllllllllllllllIIIIlllIlIIllIIII) {
        final String lllllllllllllllIIIIlllIlIIllIlIl = lllllllllllllllIIIIlllIlIIlllIII.getUtf8Info(this.name);
        String lllllllllllllllIIIIlllIlIIllIlII = null;
        if (lllllllllllllllIIIIlllIlIIllIlIl.charAt(0) == '[') {
            final String lllllllllllllllIIIIlllIlIIlllIll = Descriptor.rename(lllllllllllllllIIIIlllIlIIllIlIl, lllllllllllllllIIIIlllIlIIllIlll);
            if (lllllllllllllllIIIIlllIlIIllIlIl != lllllllllllllllIIIIlllIlIIlllIll) {
                lllllllllllllllIIIIlllIlIIllIlII = lllllllllllllllIIIIlllIlIIlllIll;
            }
        }
        else {
            final String lllllllllllllllIIIIlllIlIIlllIlI = lllllllllllllllIIIIlllIlIIllIlll.get(lllllllllllllllIIIIlllIlIIllIlIl);
            if (lllllllllllllllIIIIlllIlIIlllIlI != null && !lllllllllllllllIIIIlllIlIIlllIlI.equals(lllllllllllllllIIIIlllIlIIllIlIl)) {
                lllllllllllllllIIIIlllIlIIllIlII = lllllllllllllllIIIIlllIlIIlllIlI;
            }
        }
        if (lllllllllllllllIIIIlllIlIIllIlII != null) {
            if (lllllllllllllllIIIIlllIlIIllIIII == null) {
                this.name = lllllllllllllllIIIIlllIlIIlllIII.addUtf8Info(lllllllllllllllIIIIlllIlIIllIlII);
            }
            else {
                lllllllllllllllIIIIlllIlIIllIIII.remove(this);
                this.name = lllllllllllllllIIIIlllIlIIlllIII.addUtf8Info(lllllllllllllllIIIIlllIlIIllIlII);
                lllllllllllllllIIIIlllIlIIllIIII.put(this, this);
            }
        }
    }
    
    public ClassInfo(final DataInputStream lllllllllllllllIIIIlllIlIllIllII, final int lllllllllllllllIIIIlllIlIllIlIll) throws IOException {
        super(lllllllllllllllIIIIlllIlIllIlIll);
        this.name = lllllllllllllllIIIIlllIlIllIllII.readUnsignedShort();
    }
}
