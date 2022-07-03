package com.viaversion.viaversion.libs.javassist.bytecode;

import java.io.*;
import java.util.*;

public class SyntheticAttribute extends AttributeInfo
{
    public SyntheticAttribute(final ConstPool llllllllllllllIIIIIIIlIIlIIlIlII) {
        super(llllllllllllllIIIIIIIlIIlIIlIlII, "Synthetic", new byte[0]);
    }
    
    SyntheticAttribute(final ConstPool llllllllllllllIIIIIIIlIIlIIlllII, final int llllllllllllllIIIIIIIlIIlIIlllll, final DataInputStream llllllllllllllIIIIIIIlIIlIIllllI) throws IOException {
        super(llllllllllllllIIIIIIIlIIlIIlllII, llllllllllllllIIIIIIIlIIlIIlllll, llllllllllllllIIIIIIIlIIlIIllllI);
    }
    
    static {
        tag = "Synthetic";
    }
    
    @Override
    public AttributeInfo copy(final ConstPool llllllllllllllIIIIIIIlIIlIIlIIIl, final Map<String, String> llllllllllllllIIIIIIIlIIlIIlIIII) {
        return new SyntheticAttribute(llllllllllllllIIIIIIIlIIlIIlIIIl);
    }
}
