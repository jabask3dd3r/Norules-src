package com.viaversion.viaversion.libs.javassist.bytecode;

import java.util.*;
import java.io.*;

public class LocalVariableTypeAttribute extends LocalVariableAttribute
{
    private LocalVariableTypeAttribute(final ConstPool lllllllllllllIllIIlllIllIllIIlIl, final byte[] lllllllllllllIllIIlllIllIllIIIll) {
        super(lllllllllllllIllIIlllIllIllIIlIl, "LocalVariableTypeTable", lllllllllllllIllIIlllIllIllIIIll);
    }
    
    @Override
    LocalVariableAttribute makeThisAttr(final ConstPool lllllllllllllIllIIlllIllIIllIlIl, final byte[] lllllllllllllIllIIlllIllIIllIllI) {
        return new LocalVariableTypeAttribute(lllllllllllllIllIIlllIllIIllIlIl, lllllllllllllIllIIlllIllIIllIllI);
    }
    
    static {
        tag = "LocalVariableTypeTable";
    }
    
    @Override
    String renameEntry(final String lllllllllllllIllIIlllIllIIllllIl, final Map<String, String> lllllllllllllIllIIlllIllIIlllIll) {
        return SignatureAttribute.renameClass(lllllllllllllIllIIlllIllIIllllIl, lllllllllllllIllIIlllIllIIlllIll);
    }
    
    public LocalVariableTypeAttribute(final ConstPool lllllllllllllIllIIlllIllIllllllI) {
        super(lllllllllllllIllIIlllIllIllllllI, "LocalVariableTypeTable", new byte[2]);
        ByteArray.write16bit(0, this.info, 0);
    }
    
    LocalVariableTypeAttribute(final ConstPool lllllllllllllIllIIlllIllIlllIIlI, final int lllllllllllllIllIIlllIllIlllIlIl, final DataInputStream lllllllllllllIllIIlllIllIlllIIII) throws IOException {
        super(lllllllllllllIllIIlllIllIlllIIlI, lllllllllllllIllIIlllIllIlllIlIl, lllllllllllllIllIIlllIllIlllIIII);
    }
    
    @Override
    String renameEntry(final String lllllllllllllIllIIlllIllIlIIllIl, final String lllllllllllllIllIIlllIllIlIlIIIl, final String lllllllllllllIllIIlllIllIlIIlIIl) {
        return SignatureAttribute.renameClass(lllllllllllllIllIIlllIllIlIIllIl, lllllllllllllIllIIlllIllIlIlIIIl, lllllllllllllIllIIlllIllIlIIlIIl);
    }
}
