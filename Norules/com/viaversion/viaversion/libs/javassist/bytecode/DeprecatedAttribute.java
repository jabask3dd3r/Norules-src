package com.viaversion.viaversion.libs.javassist.bytecode;

import java.io.*;
import java.util.*;

public class DeprecatedAttribute extends AttributeInfo
{
    DeprecatedAttribute(final ConstPool llllllllllllllIIlIIIIlIllIlIlIlI, final int llllllllllllllIIlIIIIlIllIlIIlIl, final DataInputStream llllllllllllllIIlIIIIlIllIlIlIII) throws IOException {
        super(llllllllllllllIIlIIIIlIllIlIlIlI, llllllllllllllIIlIIIIlIllIlIIlIl, llllllllllllllIIlIIIIlIllIlIlIII);
    }
    
    static {
        tag = "Deprecated";
    }
    
    @Override
    public AttributeInfo copy(final ConstPool llllllllllllllIIlIIIIlIllIIllIIl, final Map<String, String> llllllllllllllIIlIIIIlIllIIllIlI) {
        return new DeprecatedAttribute(llllllllllllllIIlIIIIlIllIIllIIl);
    }
    
    public DeprecatedAttribute(final ConstPool llllllllllllllIIlIIIIlIllIIllllI) {
        super(llllllllllllllIIlIIIIlIllIIllllI, "Deprecated", new byte[0]);
    }
}
