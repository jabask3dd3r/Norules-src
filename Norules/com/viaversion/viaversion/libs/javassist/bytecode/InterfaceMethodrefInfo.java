package com.viaversion.viaversion.libs.javassist.bytecode;

import java.io.*;

class InterfaceMethodrefInfo extends MemberrefInfo
{
    public InterfaceMethodrefInfo(final int lllllllllllllIllllIIlIIlIllIIlll, final int lllllllllllllIllllIIlIIlIllIIllI, final int lllllllllllllIllllIIlIIlIllIIIIl) {
        super(lllllllllllllIllllIIlIIlIllIIlll, lllllllllllllIllllIIlIIlIllIIllI, lllllllllllllIllllIIlIIlIllIIIIl);
    }
    
    @Override
    protected int copy2(final ConstPool lllllllllllllIllllIIlIIlIlIlIIIl, final int lllllllllllllIllllIIlIIlIlIlIIII, final int lllllllllllllIllllIIlIIlIlIIllII) {
        return lllllllllllllIllllIIlIIlIlIlIIIl.addInterfaceMethodrefInfo(lllllllllllllIllllIIlIIlIlIlIIII, lllllllllllllIllllIIlIIlIlIIllII);
    }
    
    static {
        tag = 11;
    }
    
    @Override
    public String getTagName() {
        return "Interface";
    }
    
    public InterfaceMethodrefInfo(final DataInputStream lllllllllllllIllllIIlIIlIlIlllII, final int lllllllllllllIllllIIlIIlIlIllIll) throws IOException {
        super(lllllllllllllIllllIIlIIlIlIlllII, lllllllllllllIllllIIlIIlIlIllIll);
    }
    
    @Override
    public int getTag() {
        return 11;
    }
}
