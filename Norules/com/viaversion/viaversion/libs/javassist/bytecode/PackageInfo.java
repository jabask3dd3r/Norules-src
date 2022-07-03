package com.viaversion.viaversion.libs.javassist.bytecode;

import java.util.*;
import java.io.*;

class PackageInfo extends ConstInfo
{
    /* synthetic */ int name;
    
    @Override
    public int hashCode() {
        return this.name;
    }
    
    static {
        tag = 20;
    }
    
    @Override
    public void print(final PrintWriter lllllllllllllIIllIlllIlllIlllIII) {
        lllllllllllllIIllIlllIlllIlllIII.print("Package #");
        lllllllllllllIIllIlllIlllIlllIII.println(this.name);
    }
    
    public PackageInfo(final int lllllllllllllIIllIlllIlllllIllII, final int lllllllllllllIIllIlllIlllllIlIll) {
        super(lllllllllllllIIllIlllIlllllIlIll);
        this.name = lllllllllllllIIllIlllIlllllIllII;
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIIllIlllIllllIllIll) {
        return lllllllllllllIIllIlllIllllIllIll instanceof PackageInfo && ((PackageInfo)lllllllllllllIIllIlllIllllIllIll).name == this.name;
    }
    
    @Override
    public int copy(final ConstPool lllllllllllllIIllIlllIllllIIIlIl, final ConstPool lllllllllllllIIllIlllIllllIIlIlI, final Map<String, String> lllllllllllllIIllIlllIllllIIlIIl) {
        final String lllllllllllllIIllIlllIllllIIlIII = lllllllllllllIIllIlllIllllIIIlIl.getUtf8Info(this.name);
        final int lllllllllllllIIllIlllIllllIIIlll = lllllllllllllIIllIlllIllllIIlIlI.addUtf8Info(lllllllllllllIIllIlllIllllIIlIII);
        return lllllllllllllIIllIlllIllllIIlIlI.addModuleInfo(lllllllllllllIIllIlllIllllIIIlll);
    }
    
    public String getPackageName(final ConstPool lllllllllllllIIllIlllIllllIlIIlI) {
        return lllllllllllllIIllIlllIllllIlIIlI.getUtf8Info(this.name);
    }
    
    @Override
    public int getTag() {
        return 20;
    }
    
    public PackageInfo(final DataInputStream lllllllllllllIIllIlllIlllllIIIll, final int lllllllllllllIIllIlllIlllllIIlIl) throws IOException {
        super(lllllllllllllIIllIlllIlllllIIlIl);
        this.name = lllllllllllllIIllIlllIlllllIIIll.readUnsignedShort();
    }
    
    @Override
    public void write(final DataOutputStream lllllllllllllIIllIlllIlllIllllII) throws IOException {
        lllllllllllllIIllIlllIlllIllllII.writeByte(20);
        lllllllllllllIIllIlllIlllIllllII.writeShort(this.name);
    }
}
