package com.viaversion.viaversion.libs.javassist.bytecode;

import java.io.*;
import java.util.*;

public class BootstrapMethodsAttribute extends AttributeInfo
{
    public BootstrapMethod[] getMethods() {
        final byte[] lllllllllllllIlIIIIllIllIIlllIIl = this.get();
        final int lllllllllllllIlIIIIllIllIIlllIII = ByteArray.readU16bit(lllllllllllllIlIIIIllIllIIlllIIl, 0);
        final BootstrapMethod[] lllllllllllllIlIIIIllIllIIllIlll = new BootstrapMethod[lllllllllllllIlIIIIllIllIIlllIII];
        int lllllllllllllIlIIIIllIllIIllIllI = 2;
        for (int lllllllllllllIlIIIIllIllIIlllIll = 0; lllllllllllllIlIIIIllIllIIlllIll < lllllllllllllIlIIIIllIllIIlllIII; ++lllllllllllllIlIIIIllIllIIlllIll) {
            final int lllllllllllllIlIIIIllIllIIlllllI = ByteArray.readU16bit(lllllllllllllIlIIIIllIllIIlllIIl, lllllllllllllIlIIIIllIllIIllIllI);
            final int lllllllllllllIlIIIIllIllIIllllIl = ByteArray.readU16bit(lllllllllllllIlIIIIllIllIIlllIIl, lllllllllllllIlIIIIllIllIIllIllI + 2);
            final int[] lllllllllllllIlIIIIllIllIIllllII = new int[lllllllllllllIlIIIIllIllIIllllIl];
            lllllllllllllIlIIIIllIllIIllIllI += 4;
            for (int lllllllllllllIlIIIIllIllIIllllll = 0; lllllllllllllIlIIIIllIllIIllllll < lllllllllllllIlIIIIllIllIIllllIl; ++lllllllllllllIlIIIIllIllIIllllll) {
                lllllllllllllIlIIIIllIllIIllllII[lllllllllllllIlIIIIllIllIIllllll] = ByteArray.readU16bit(lllllllllllllIlIIIIllIllIIlllIIl, lllllllllllllIlIIIIllIllIIllIllI);
                lllllllllllllIlIIIIllIllIIllIllI += 2;
            }
            lllllllllllllIlIIIIllIllIIllIlll[lllllllllllllIlIIIIllIllIIlllIll] = new BootstrapMethod(lllllllllllllIlIIIIllIllIIlllllI, lllllllllllllIlIIIIllIllIIllllII);
        }
        return lllllllllllllIlIIIIllIllIIllIlll;
    }
    
    BootstrapMethodsAttribute(final ConstPool lllllllllllllIlIIIIllIllIllIlIII, final int lllllllllllllIlIIIIllIllIllIIlll, final DataInputStream lllllllllllllIlIIIIllIllIllIlIlI) throws IOException {
        super(lllllllllllllIlIIIIllIllIllIlIII, lllllllllllllIlIIIIllIllIllIIlll, lllllllllllllIlIIIIllIllIllIlIlI);
    }
    
    static {
        tag = "BootstrapMethods";
    }
    
    public BootstrapMethodsAttribute(final ConstPool lllllllllllllIlIIIIllIllIlIlIlll, final BootstrapMethod[] lllllllllllllIlIIIIllIllIlIlIIII) {
        super(lllllllllllllIlIIIIllIllIlIlIlll, "BootstrapMethods");
        int lllllllllllllIlIIIIllIllIlIlIlIl = 2;
        for (int lllllllllllllIlIIIIllIllIlIlllII = 0; lllllllllllllIlIIIIllIllIlIlllII < lllllllllllllIlIIIIllIllIlIlIIII.length; ++lllllllllllllIlIIIIllIllIlIlllII) {
            lllllllllllllIlIIIIllIllIlIlIlIl += 4 + lllllllllllllIlIIIIllIllIlIlIIII[lllllllllllllIlIIIIllIllIlIlllII].arguments.length * 2;
        }
        final byte[] lllllllllllllIlIIIIllIllIlIlIlII = new byte[lllllllllllllIlIIIIllIllIlIlIlIl];
        ByteArray.write16bit(lllllllllllllIlIIIIllIllIlIlIIII.length, lllllllllllllIlIIIIllIllIlIlIlII, 0);
        int lllllllllllllIlIIIIllIllIlIlIIll = 2;
        for (int lllllllllllllIlIIIIllIllIlIllIIl = 0; lllllllllllllIlIIIIllIllIlIllIIl < lllllllllllllIlIIIIllIllIlIlIIII.length; ++lllllllllllllIlIIIIllIllIlIllIIl) {
            ByteArray.write16bit(lllllllllllllIlIIIIllIllIlIlIIII[lllllllllllllIlIIIIllIllIlIllIIl].methodRef, lllllllllllllIlIIIIllIllIlIlIlII, lllllllllllllIlIIIIllIllIlIlIIll);
            ByteArray.write16bit(lllllllllllllIlIIIIllIllIlIlIIII[lllllllllllllIlIIIIllIllIlIllIIl].arguments.length, lllllllllllllIlIIIIllIllIlIlIlII, lllllllllllllIlIIIIllIllIlIlIIll + 2);
            final int[] lllllllllllllIlIIIIllIllIlIllIlI = lllllllllllllIlIIIIllIllIlIlIIII[lllllllllllllIlIIIIllIllIlIllIIl].arguments;
            lllllllllllllIlIIIIllIllIlIlIIll += 4;
            for (int lllllllllllllIlIIIIllIllIlIllIll = 0; lllllllllllllIlIIIIllIllIlIllIll < lllllllllllllIlIIIIllIllIlIllIlI.length; ++lllllllllllllIlIIIIllIllIlIllIll) {
                ByteArray.write16bit(lllllllllllllIlIIIIllIllIlIllIlI[lllllllllllllIlIIIIllIllIlIllIll], lllllllllllllIlIIIIllIllIlIlIlII, lllllllllllllIlIIIIllIllIlIlIIll);
                lllllllllllllIlIIIIllIllIlIlIIll += 2;
            }
        }
        this.set(lllllllllllllIlIIIIllIllIlIlIlII);
    }
    
    @Override
    public AttributeInfo copy(final ConstPool lllllllllllllIlIIIIllIllIIIllIlI, final Map<String, String> lllllllllllllIlIIIIllIllIIIllIIl) {
        final BootstrapMethod[] lllllllllllllIlIIIIllIllIIIlllIl = this.getMethods();
        final ConstPool lllllllllllllIlIIIIllIllIIIlllII = this.getConstPool();
        for (int lllllllllllllIlIIIIllIllIIlIIIIl = 0; lllllllllllllIlIIIIllIllIIlIIIIl < lllllllllllllIlIIIIllIllIIIlllIl.length; ++lllllllllllllIlIIIIllIllIIlIIIIl) {
            final BootstrapMethod lllllllllllllIlIIIIllIllIIlIIIlI = lllllllllllllIlIIIIllIllIIIlllIl[lllllllllllllIlIIIIllIllIIlIIIIl];
            lllllllllllllIlIIIIllIllIIlIIIlI.methodRef = lllllllllllllIlIIIIllIllIIIlllII.copy(lllllllllllllIlIIIIllIllIIlIIIlI.methodRef, lllllllllllllIlIIIIllIllIIIllIlI, lllllllllllllIlIIIIllIllIIIllIIl);
            for (int lllllllllllllIlIIIIllIllIIlIIIll = 0; lllllllllllllIlIIIIllIllIIlIIIll < lllllllllllllIlIIIIllIllIIlIIIlI.arguments.length; ++lllllllllllllIlIIIIllIllIIlIIIll) {
                lllllllllllllIlIIIIllIllIIlIIIlI.arguments[lllllllllllllIlIIIIllIllIIlIIIll] = lllllllllllllIlIIIIllIllIIIlllII.copy(lllllllllllllIlIIIIllIllIIlIIIlI.arguments[lllllllllllllIlIIIIllIllIIlIIIll], lllllllllllllIlIIIIllIllIIIllIlI, lllllllllllllIlIIIIllIllIIIllIIl);
            }
        }
        return new BootstrapMethodsAttribute(lllllllllllllIlIIIIllIllIIIllIlI, lllllllllllllIlIIIIllIllIIIlllIl);
    }
    
    public static class BootstrapMethod
    {
        public /* synthetic */ int methodRef;
        public /* synthetic */ int[] arguments;
        
        public BootstrapMethod(final int llllllllllllllllIllIIllIlIIllIIl, final int[] llllllllllllllllIllIIllIlIIllIII) {
            this.methodRef = llllllllllllllllIllIIllIlIIllIIl;
            this.arguments = llllllllllllllllIllIIllIlIIllIII;
        }
    }
}
