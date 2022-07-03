package com.viaversion.viaversion.libs.javassist.bytecode;

import java.util.*;
import java.io.*;

class IntegerInfo extends ConstInfo
{
    /* synthetic */ int value;
    
    @Override
    public int hashCode() {
        return this.value;
    }
    
    @Override
    public int copy(final ConstPool lllllllllllllIIIIIlllIllIIlIIIIl, final ConstPool lllllllllllllIIIIIlllIllIIlIIIII, final Map<String, String> lllllllllllllIIIIIlllIllIIIlllll) {
        return lllllllllllllIIIIIlllIllIIlIIIII.addIntegerInfo(this.value);
    }
    
    static {
        tag = 3;
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIIIIIlllIllIIlIIllI) {
        return lllllllllllllIIIIIlllIllIIlIIllI instanceof IntegerInfo && ((IntegerInfo)lllllllllllllIIIIIlllIllIIlIIllI).value == this.value;
    }
    
    @Override
    public void write(final DataOutputStream lllllllllllllIIIIIlllIllIIIlIlll) throws IOException {
        lllllllllllllIIIIIlllIllIIIlIlll.writeByte(3);
        lllllllllllllIIIIIlllIllIIIlIlll.writeInt(this.value);
    }
    
    @Override
    public void print(final PrintWriter lllllllllllllIIIIIlllIllIIIlIIll) {
        lllllllllllllIIIIIlllIllIIIlIIll.print("Integer ");
        lllllllllllllIIIIIlllIllIIIlIIll.println(this.value);
    }
    
    @Override
    public int getTag() {
        return 3;
    }
    
    public IntegerInfo(final DataInputStream lllllllllllllIIIIIlllIllIIllIIII, final int lllllllllllllIIIIIlllIllIIlIllll) throws IOException {
        super(lllllllllllllIIIIIlllIllIIlIllll);
        this.value = lllllllllllllIIIIIlllIllIIllIIII.readInt();
    }
    
    public IntegerInfo(final int lllllllllllllIIIIIlllIllIIlllIIl, final int lllllllllllllIIIIIlllIllIIlllIll) {
        super(lllllllllllllIIIIIlllIllIIlllIll);
        this.value = lllllllllllllIIIIIlllIllIIlllIIl;
    }
}
