package com.viaversion.viaversion.libs.javassist.bytecode;

import java.util.*;
import java.io.*;

class Utf8Info extends ConstInfo
{
    /* synthetic */ String string;
    
    @Override
    public int hashCode() {
        return this.string.hashCode();
    }
    
    @Override
    public void print(final PrintWriter lllllllllllllIlllIlIllIlIIIlIIII) {
        lllllllllllllIlllIlIllIlIIIlIIII.print("UTF8 \"");
        lllllllllllllIlllIlIllIlIIIlIIII.print(this.string);
        lllllllllllllIlllIlIllIlIIIlIIII.println("\"");
    }
    
    @Override
    public int getTag() {
        return 1;
    }
    
    @Override
    public void write(final DataOutputStream lllllllllllllIlllIlIllIlIIIlIlII) throws IOException {
        lllllllllllllIlllIlIllIlIIIlIlII.writeByte(1);
        lllllllllllllIlllIlIllIlIIIlIlII.writeUTF(this.string);
    }
    
    @Override
    public int copy(final ConstPool lllllllllllllIlllIlIllIlIIIllllI, final ConstPool lllllllllllllIlllIlIllIlIIIlllIl, final Map<String, String> lllllllllllllIlllIlIllIlIIIlllII) {
        return lllllllllllllIlllIlIllIlIIIlllIl.addUtf8Info(this.string);
    }
    
    public Utf8Info(final DataInputStream lllllllllllllIlllIlIllIlIIllIIII, final int lllllllllllllIlllIlIllIlIIlIllll) throws IOException {
        super(lllllllllllllIlllIlIllIlIIlIllll);
        this.string = lllllllllllllIlllIlIllIlIIllIIII.readUTF();
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIlllIlIllIlIIlIIlIl) {
        return lllllllllllllIlllIlIllIlIIlIIlIl instanceof Utf8Info && ((Utf8Info)lllllllllllllIlllIlIllIlIIlIIlIl).string.equals(this.string);
    }
    
    public Utf8Info(final String lllllllllllllIlllIlIllIlIIllIllI, final int lllllllllllllIlllIlIllIlIIllIlIl) {
        super(lllllllllllllIlllIlIllIlIIllIlIl);
        this.string = lllllllllllllIlllIlIllIlIIllIllI;
    }
    
    static {
        tag = 1;
    }
}
