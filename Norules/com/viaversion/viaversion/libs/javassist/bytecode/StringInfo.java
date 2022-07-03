package com.viaversion.viaversion.libs.javassist.bytecode;

import java.util.*;
import java.io.*;

class StringInfo extends ConstInfo
{
    /* synthetic */ int string;
    
    @Override
    public int copy(final ConstPool lllIlIlIlIlIlII, final ConstPool lllIlIlIlIlIlll, final Map<String, String> lllIlIlIlIlIllI) {
        return lllIlIlIlIlIlll.addStringInfo(lllIlIlIlIlIlII.getUtf8Info(this.string));
    }
    
    @Override
    public int hashCode() {
        return this.string;
    }
    
    public StringInfo(final int lllIlIlIlllIIIl, final int lllIlIlIlllIIII) {
        super(lllIlIlIlllIIII);
        this.string = lllIlIlIlllIIIl;
    }
    
    static {
        tag = 8;
    }
    
    @Override
    public boolean equals(final Object lllIlIlIlIllllI) {
        return lllIlIlIlIllllI instanceof StringInfo && ((StringInfo)lllIlIlIlIllllI).string == this.string;
    }
    
    @Override
    public int getTag() {
        return 8;
    }
    
    public StringInfo(final DataInputStream lllIlIlIllIlIll, final int lllIlIlIllIlIlI) throws IOException {
        super(lllIlIlIllIlIlI);
        this.string = lllIlIlIllIlIll.readUnsignedShort();
    }
    
    @Override
    public void write(final DataOutputStream lllIlIlIlIIllll) throws IOException {
        lllIlIlIlIIllll.writeByte(8);
        lllIlIlIlIIllll.writeShort(this.string);
    }
    
    @Override
    public void print(final PrintWriter lllIlIlIlIIlIIl) {
        lllIlIlIlIIlIIl.print("String #");
        lllIlIlIlIIlIIl.println(this.string);
    }
}
