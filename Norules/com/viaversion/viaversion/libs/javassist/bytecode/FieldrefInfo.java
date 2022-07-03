package com.viaversion.viaversion.libs.javassist.bytecode;

import java.io.*;

class FieldrefInfo extends MemberrefInfo
{
    @Override
    public int getTag() {
        return 9;
    }
    
    static {
        tag = 9;
    }
    
    public FieldrefInfo(final DataInputStream lIllllllIIIllIl, final int lIllllllIIIlIIl) throws IOException {
        super(lIllllllIIIllIl, lIllllllIIIlIIl);
    }
    
    public FieldrefInfo(final int lIllllllIIlIlII, final int lIllllllIIlIlll, final int lIllllllIIlIIlI) {
        super(lIllllllIIlIlII, lIllllllIIlIlll, lIllllllIIlIIlI);
    }
    
    @Override
    public String getTagName() {
        return "Field";
    }
    
    @Override
    protected int copy2(final ConstPool lIllllllIIIIIlI, final int lIllllllIIIIIIl, final int lIlllllIlllllIl) {
        return lIllllllIIIIIlI.addFieldrefInfo(lIllllllIIIIIIl, lIlllllIlllllIl);
    }
}
