package com.viaversion.viaversion.libs.javassist.bytecode;

import java.util.*;
import java.io.*;

class ModuleInfo extends ConstInfo
{
    /* synthetic */ int name;
    
    public ModuleInfo(final int llIIllIllIIIlIl, final int llIIllIllIIIlll) {
        super(llIIllIllIIIlll);
        this.name = llIIllIllIIIlIl;
    }
    
    public String getModuleName(final ConstPool llIIllIlIIlIIIl) {
        return llIIllIlIIlIIIl.getUtf8Info(this.name);
    }
    
    @Override
    public int hashCode() {
        return this.name;
    }
    
    @Override
    public void print(final PrintWriter llIIllIIlIlllII) {
        llIIllIIlIlllII.print("Module #");
        llIIllIIlIlllII.println(this.name);
    }
    
    public ModuleInfo(final DataInputStream llIIllIlIllIlIl, final int llIIllIlIllIlII) throws IOException {
        super(llIIllIlIllIlII);
        this.name = llIIllIlIllIlIl.readUnsignedShort();
    }
    
    @Override
    public int copy(final ConstPool llIIllIIlllllll, final ConstPool llIIllIlIIIIlll, final Map<String, String> llIIllIlIIIIllI) {
        final String llIIllIlIIIIlII = llIIllIIlllllll.getUtf8Info(this.name);
        final int llIIllIlIIIIIlI = llIIllIlIIIIlll.addUtf8Info(llIIllIlIIIIlII);
        return llIIllIlIIIIlll.addModuleInfo(llIIllIlIIIIIlI);
    }
    
    @Override
    public void write(final DataOutputStream llIIllIIllIlIII) throws IOException {
        llIIllIIllIlIII.writeByte(19);
        llIIllIIllIlIII.writeShort(this.name);
    }
    
    @Override
    public int getTag() {
        return 19;
    }
    
    @Override
    public boolean equals(final Object llIIllIlIIlllIl) {
        return llIIllIlIIlllIl instanceof ModuleInfo && ((ModuleInfo)llIIllIlIIlllIl).name == this.name;
    }
    
    static {
        tag = 19;
    }
}
