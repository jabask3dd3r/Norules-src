package com.viaversion.viaversion.libs.javassist.bytecode;

import java.util.*;
import java.io.*;

public class ExceptionsAttribute extends AttributeInfo
{
    public int getException(final int llllllllllllllllIIIlllIlIIlIIlII) {
        final int llllllllllllllllIIIlllIlIIlIIIll = llllllllllllllllIIIlllIlIIlIIlII * 2 + 2;
        return (this.info[llllllllllllllllIIIlllIlIIlIIIll] & 0xFF) << 8 | (this.info[llllllllllllllllIIIlllIlIIlIIIll + 1] & 0xFF);
    }
    
    public void setExceptionIndexes(final int[] llllllllllllllllIIIlllIlIlIIIIlI) {
        final int llllllllllllllllIIIlllIlIlIIIIIl = llllllllllllllllIIIlllIlIlIIIIlI.length;
        final byte[] llllllllllllllllIIIlllIlIlIIIIII = new byte[llllllllllllllllIIIlllIlIlIIIIIl * 2 + 2];
        ByteArray.write16bit(llllllllllllllllIIIlllIlIlIIIIIl, llllllllllllllllIIIlllIlIlIIIIII, 0);
        for (int llllllllllllllllIIIlllIlIlIIIlII = 0; llllllllllllllllIIIlllIlIlIIIlII < llllllllllllllllIIIlllIlIlIIIIIl; ++llllllllllllllllIIIlllIlIlIIIlII) {
            ByteArray.write16bit(llllllllllllllllIIIlllIlIlIIIIlI[llllllllllllllllIIIlllIlIlIIIlII], llllllllllllllllIIIlllIlIlIIIIII, llllllllllllllllIIIlllIlIlIIIlII * 2 + 2);
        }
        this.info = llllllllllllllllIIIlllIlIlIIIIII;
    }
    
    public int[] getExceptionIndexes() {
        final byte[] llllllllllllllllIIIlllIlIllIlIII = this.info;
        final int llllllllllllllllIIIlllIlIllIIlll = llllllllllllllllIIIlllIlIllIlIII.length;
        if (llllllllllllllllIIIlllIlIllIIlll <= 2) {
            return null;
        }
        final int[] llllllllllllllllIIIlllIlIllIIllI = new int[llllllllllllllllIIIlllIlIllIIlll / 2 - 1];
        int llllllllllllllllIIIlllIlIllIIlIl = 0;
        for (int llllllllllllllllIIIlllIlIllIlIlI = 2; llllllllllllllllIIIlllIlIllIlIlI < llllllllllllllllIIIlllIlIllIIlll; llllllllllllllllIIIlllIlIllIlIlI += 2) {
            llllllllllllllllIIIlllIlIllIIllI[llllllllllllllllIIIlllIlIllIIlIl++] = ((llllllllllllllllIIIlllIlIllIlIII[llllllllllllllllIIIlllIlIllIlIlI] & 0xFF) << 8 | (llllllllllllllllIIIlllIlIllIlIII[llllllllllllllllIIIlllIlIllIlIlI + 1] & 0xFF));
        }
        return llllllllllllllllIIIlllIlIllIIllI;
    }
    
    private ExceptionsAttribute(final ConstPool llllllllllllllllIIIlllIllIlIIIll, final ExceptionsAttribute llllllllllllllllIIIlllIllIlIIllI, final Map<String, String> llllllllllllllllIIIlllIllIlIIIIl) {
        super(llllllllllllllllIIIlllIllIlIIIll, "Exceptions");
        this.copyFrom(llllllllllllllllIIIlllIllIlIIllI, llllllllllllllllIIIlllIllIlIIIIl);
    }
    
    public String[] getExceptions() {
        final byte[] llllllllllllllllIIIlllIlIlIlIlII = this.info;
        final int llllllllllllllllIIIlllIlIlIlIIll = llllllllllllllllIIIlllIlIlIlIlII.length;
        if (llllllllllllllllIIIlllIlIlIlIIll <= 2) {
            return null;
        }
        final String[] llllllllllllllllIIIlllIlIlIlIIlI = new String[llllllllllllllllIIIlllIlIlIlIIll / 2 - 1];
        int llllllllllllllllIIIlllIlIlIlIIIl = 0;
        for (int llllllllllllllllIIIlllIlIlIlIllI = 2; llllllllllllllllIIIlllIlIlIlIllI < llllllllllllllllIIIlllIlIlIlIIll; llllllllllllllllIIIlllIlIlIlIllI += 2) {
            final int llllllllllllllllIIIlllIlIlIlIlll = (llllllllllllllllIIIlllIlIlIlIlII[llllllllllllllllIIIlllIlIlIlIllI] & 0xFF) << 8 | (llllllllllllllllIIIlllIlIlIlIlII[llllllllllllllllIIIlllIlIlIlIllI + 1] & 0xFF);
            llllllllllllllllIIIlllIlIlIlIIlI[llllllllllllllllIIIlllIlIlIlIIIl++] = this.constPool.getClassInfo(llllllllllllllllIIIlllIlIlIlIlll);
        }
        return llllllllllllllllIIIlllIlIlIlIIlI;
    }
    
    ExceptionsAttribute(final ConstPool llllllllllllllllIIIlllIllIllIIll, final int llllllllllllllllIIIlllIllIllIIlI, final DataInputStream llllllllllllllllIIIlllIllIlIllIl) throws IOException {
        super(llllllllllllllllIIIlllIllIllIIll, llllllllllllllllIIIlllIllIllIIlI, llllllllllllllllIIIlllIllIlIllIl);
    }
    
    public int tableLength() {
        return this.info.length / 2 - 1;
    }
    
    public void setExceptions(final String[] llllllllllllllllIIIlllIlIIlIllll) {
        final int llllllllllllllllIIIlllIlIIllIIlI = llllllllllllllllIIIlllIlIIlIllll.length;
        final byte[] llllllllllllllllIIIlllIlIIllIIIl = new byte[llllllllllllllllIIIlllIlIIllIIlI * 2 + 2];
        ByteArray.write16bit(llllllllllllllllIIIlllIlIIllIIlI, llllllllllllllllIIIlllIlIIllIIIl, 0);
        for (int llllllllllllllllIIIlllIlIIllIlIl = 0; llllllllllllllllIIIlllIlIIllIlIl < llllllllllllllllIIIlllIlIIllIIlI; ++llllllllllllllllIIIlllIlIIllIlIl) {
            ByteArray.write16bit(this.constPool.addClassInfo(llllllllllllllllIIIlllIlIIlIllll[llllllllllllllllIIIlllIlIIllIlIl]), llllllllllllllllIIIlllIlIIllIIIl, llllllllllllllllIIIlllIlIIllIlIl * 2 + 2);
        }
        this.info = llllllllllllllllIIIlllIlIIllIIIl;
    }
    
    static {
        tag = "Exceptions";
    }
    
    public ExceptionsAttribute(final ConstPool llllllllllllllllIIIlllIllIIllIIl) {
        super(llllllllllllllllIIIlllIllIIllIIl, "Exceptions");
        final byte[] llllllllllllllllIIIlllIllIIllIll = new byte[2];
        llllllllllllllllIIIlllIllIIllIll[0] = (llllllllllllllllIIIlllIllIIllIll[1] = 0);
        this.info = llllllllllllllllIIIlllIllIIllIll;
    }
    
    private void copyFrom(final ExceptionsAttribute llllllllllllllllIIIlllIlIllllIIl, final Map<String, String> llllllllllllllllIIIlllIlIllllIII) {
        final ConstPool llllllllllllllllIIIlllIlIlllllll = llllllllllllllllIIIlllIlIllllIIl.constPool;
        final ConstPool llllllllllllllllIIIlllIlIllllllI = this.constPool;
        final byte[] llllllllllllllllIIIlllIlIlllllIl = llllllllllllllllIIIlllIlIllllIIl.info;
        final int llllllllllllllllIIIlllIlIlllllII = llllllllllllllllIIIlllIlIlllllIl.length;
        final byte[] llllllllllllllllIIIlllIlIllllIll = new byte[llllllllllllllllIIIlllIlIlllllII];
        llllllllllllllllIIIlllIlIllllIll[0] = llllllllllllllllIIIlllIlIlllllIl[0];
        llllllllllllllllIIIlllIlIllllIll[1] = llllllllllllllllIIIlllIlIlllllIl[1];
        for (int llllllllllllllllIIIlllIllIIIIIll = 2; llllllllllllllllIIIlllIllIIIIIll < llllllllllllllllIIIlllIlIlllllII; llllllllllllllllIIIlllIllIIIIIll += 2) {
            final int llllllllllllllllIIIlllIllIIIIlII = ByteArray.readU16bit(llllllllllllllllIIIlllIlIlllllIl, llllllllllllllllIIIlllIllIIIIIll);
            ByteArray.write16bit(llllllllllllllllIIIlllIlIlllllll.copy(llllllllllllllllIIIlllIllIIIIlII, llllllllllllllllIIIlllIlIllllllI, llllllllllllllllIIIlllIlIllllIII), llllllllllllllllIIIlllIlIllllIll, llllllllllllllllIIIlllIllIIIIIll);
        }
        this.info = llllllllllllllllIIIlllIlIllllIll;
    }
    
    @Override
    public AttributeInfo copy(final ConstPool llllllllllllllllIIIlllIllIIlIIll, final Map<String, String> llllllllllllllllIIIlllIllIIIllll) {
        return new ExceptionsAttribute(llllllllllllllllIIIlllIllIIlIIll, this, llllllllllllllllIIIlllIllIIIllll);
    }
}
