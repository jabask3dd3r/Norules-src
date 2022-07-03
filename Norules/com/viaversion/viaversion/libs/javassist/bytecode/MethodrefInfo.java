package com.viaversion.viaversion.libs.javassist.bytecode;

import java.io.*;

class MethodrefInfo extends MemberrefInfo
{
    @Override
    public String getTagName() {
        return "Method";
    }
    
    public MethodrefInfo(final int llllllllllllllllIIllIlllIlllIlll, final int llllllllllllllllIIllIlllIlllIIlI, final int llllllllllllllllIIllIlllIlllIlIl) {
        super(llllllllllllllllIIllIlllIlllIlll, llllllllllllllllIIllIlllIlllIIlI, llllllllllllllllIIllIlllIlllIlIl);
    }
    
    static {
        tag = 10;
    }
    
    @Override
    public int getTag() {
        return 10;
    }
    
    @Override
    protected int copy2(final ConstPool llllllllllllllllIIllIlllIlIllllI, final int llllllllllllllllIIllIlllIlIlllIl, final int llllllllllllllllIIllIlllIlIlllll) {
        return llllllllllllllllIIllIlllIlIllllI.addMethodrefInfo(llllllllllllllllIIllIlllIlIlllIl, llllllllllllllllIIllIlllIlIlllll);
    }
    
    public MethodrefInfo(final DataInputStream llllllllllllllllIIllIlllIllIlIIl, final int llllllllllllllllIIllIlllIllIlIII) throws IOException {
        super(llllllllllllllllIIllIlllIllIlIIl, llllllllllllllllIIllIlllIllIlIII);
    }
}
