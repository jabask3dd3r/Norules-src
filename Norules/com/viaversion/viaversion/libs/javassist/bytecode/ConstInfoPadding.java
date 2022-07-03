package com.viaversion.viaversion.libs.javassist.bytecode;

import java.util.*;
import java.io.*;

class ConstInfoPadding extends ConstInfo
{
    @Override
    public int copy(final ConstPool llllllllllllllIIIlIlllIIIIlIIIIl, final ConstPool llllllllllllllIIIlIlllIIIIlIIIII, final Map<String, String> llllllllllllllIIIlIlllIIIIIlllll) {
        return llllllllllllllIIIlIlllIIIIlIIIII.addConstInfoPadding();
    }
    
    @Override
    public void print(final PrintWriter llllllllllllllIIIlIlllIIIIIllIII) {
        llllllllllllllIIIlIlllIIIIIllIII.println("padding");
    }
    
    public ConstInfoPadding(final int llllllllllllllIIIlIlllIIIIlIIlIl) {
        super(llllllllllllllIIIlIlllIIIIlIIlIl);
    }
    
    @Override
    public void write(final DataOutputStream llllllllllllllIIIlIlllIIIIIlllII) throws IOException {
    }
    
    @Override
    public int getTag() {
        return 0;
    }
}
