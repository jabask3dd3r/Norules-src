package com.viaversion.viaversion.libs.javassist.bytecode;

import java.util.*;
import java.io.*;

public class LineNumberAttribute extends AttributeInfo
{
    public int lineNumber(final int llllllllllllllIlIlllllIllIIlIllI) {
        return ByteArray.readU16bit(this.info, llllllllllllllIlIlllllIllIIlIllI * 4 + 4);
    }
    
    @Override
    public AttributeInfo copy(final ConstPool llllllllllllllIlIlllllIlIlIllIII, final Map<String, String> llllllllllllllIlIlllllIlIlIllllI) {
        final byte[] llllllllllllllIlIlllllIlIlIlllIl = this.info;
        final int llllllllllllllIlIlllllIlIlIlllII = llllllllllllllIlIlllllIlIlIlllIl.length;
        final byte[] llllllllllllllIlIlllllIlIlIllIll = new byte[llllllllllllllIlIlllllIlIlIlllII];
        for (int llllllllllllllIlIlllllIlIllIIIIl = 0; llllllllllllllIlIlllllIlIllIIIIl < llllllllllllllIlIlllllIlIlIlllII; ++llllllllllllllIlIlllllIlIllIIIIl) {
            llllllllllllllIlIlllllIlIlIllIll[llllllllllllllIlIlllllIlIllIIIIl] = llllllllllllllIlIlllllIlIlIlllIl[llllllllllllllIlIlllllIlIllIIIIl];
        }
        final LineNumberAttribute llllllllllllllIlIlllllIlIlIllIlI = new LineNumberAttribute(llllllllllllllIlIlllllIlIlIllIII, llllllllllllllIlIlllllIlIlIllIll);
        return llllllllllllllIlIlllllIlIlIllIlI;
    }
    
    LineNumberAttribute(final ConstPool llllllllllllllIlIlllllIllIllIIII, final int llllllllllllllIlIlllllIllIlIllll, final DataInputStream llllllllllllllIlIlllllIllIllIIlI) throws IOException {
        super(llllllllllllllIlIlllllIllIllIIII, llllllllllllllIlIlllllIllIlIllll, llllllllllllllIlIlllllIllIllIIlI);
    }
    
    void shiftPc(final int llllllllllllllIlIlllllIlIlIIIIlI, final int llllllllllllllIlIlllllIlIlIIIIIl, final boolean llllllllllllllIlIlllllIlIlIIIlIl) {
        for (int llllllllllllllIlIlllllIlIlIIIlII = this.tableLength(), llllllllllllllIlIlllllIlIlIIlIIl = 0; llllllllllllllIlIlllllIlIlIIlIIl < llllllllllllllIlIlllllIlIlIIIlII; ++llllllllllllllIlIlllllIlIlIIlIIl) {
            final int llllllllllllllIlIlllllIlIlIIlIll = llllllllllllllIlIlllllIlIlIIlIIl * 4 + 2;
            final int llllllllllllllIlIlllllIlIlIIlIlI = ByteArray.readU16bit(this.info, llllllllllllllIlIlllllIlIlIIlIll);
            if (llllllllllllllIlIlllllIlIlIIlIlI > llllllllllllllIlIlllllIlIlIIIIlI || (llllllllllllllIlIlllllIlIlIIIlIl && llllllllllllllIlIlllllIlIlIIlIlI == llllllllllllllIlIlllllIlIlIIIIlI)) {
                ByteArray.write16bit(llllllllllllllIlIlllllIlIlIIlIlI + llllllllllllllIlIlllllIlIlIIIIIl, this.info, llllllllllllllIlIlllllIlIlIIlIll);
            }
        }
    }
    
    public Pc toNearPc(final int llllllllllllllIlIlllllIlIlllIIll) {
        final int llllllllllllllIlIlllllIlIlllIIlI = this.tableLength();
        int llllllllllllllIlIlllllIlIlllIIIl = 0;
        int llllllllllllllIlIlllllIlIlllIIII = 0;
        if (llllllllllllllIlIlllllIlIlllIIlI > 0) {
            llllllllllllllIlIlllllIlIlllIIII = this.lineNumber(0) - llllllllllllllIlIlllllIlIlllIIll;
            llllllllllllllIlIlllllIlIlllIIIl = this.startPc(0);
        }
        for (int llllllllllllllIlIlllllIlIlllIlIl = 1; llllllllllllllIlIlllllIlIlllIlIl < llllllllllllllIlIlllllIlIlllIIlI; ++llllllllllllllIlIlllllIlIlllIlIl) {
            final int llllllllllllllIlIlllllIlIlllIllI = this.lineNumber(llllllllllllllIlIlllllIlIlllIlIl) - llllllllllllllIlIlllllIlIlllIIll;
            if ((llllllllllllllIlIlllllIlIlllIllI < 0 && llllllllllllllIlIlllllIlIlllIllI > llllllllllllllIlIlllllIlIlllIIII) || (llllllllllllllIlIlllllIlIlllIllI >= 0 && (llllllllllllllIlIlllllIlIlllIllI < llllllllllllllIlIlllllIlIlllIIII || llllllllllllllIlIlllllIlIlllIIII < 0))) {
                llllllllllllllIlIlllllIlIlllIIII = llllllllllllllIlIlllllIlIlllIllI;
                llllllllllllllIlIlllllIlIlllIIIl = this.startPc(llllllllllllllIlIlllllIlIlllIlIl);
            }
        }
        final Pc llllllllllllllIlIlllllIlIllIllll = new Pc();
        llllllllllllllIlIlllllIlIllIllll.index = llllllllllllllIlIlllllIlIlllIIIl;
        llllllllllllllIlIlllllIlIllIllll.line = llllllllllllllIlIlllllIlIlllIIll + llllllllllllllIlIlllllIlIlllIIII;
        return llllllllllllllIlIlllllIlIllIllll;
    }
    
    public int startPc(final int llllllllllllllIlIlllllIllIIllllI) {
        return ByteArray.readU16bit(this.info, llllllllllllllIlIlllllIllIIllllI * 4 + 2);
    }
    
    public int tableLength() {
        return ByteArray.readU16bit(this.info, 0);
    }
    
    public int toLineNumber(final int llllllllllllllIlIlllllIllIIlIIII) {
        final int llllllllllllllIlIlllllIllIIIllll = this.tableLength();
        int llllllllllllllIlIlllllIllIIIlllI = 0;
        while (llllllllllllllIlIlllllIllIIIlllI < llllllllllllllIlIlllllIllIIIllll) {
            if (llllllllllllllIlIlllllIllIIlIIII < this.startPc(llllllllllllllIlIlllllIllIIIlllI)) {
                if (llllllllllllllIlIlllllIllIIIlllI == 0) {
                    return this.lineNumber(0);
                }
                break;
            }
            else {
                ++llllllllllllllIlIlllllIllIIIlllI;
            }
        }
        return this.lineNumber(llllllllllllllIlIlllllIllIIIlllI - 1);
    }
    
    static {
        tag = "LineNumberTable";
    }
    
    private LineNumberAttribute(final ConstPool llllllllllllllIlIlllllIllIlIlIIl, final byte[] llllllllllllllIlIlllllIllIlIlIII) {
        super(llllllllllllllIlIlllllIllIlIlIIl, "LineNumberTable", llllllllllllllIlIlllllIllIlIlIII);
    }
    
    public int toStartPc(final int llllllllllllllIlIlllllIllIIIIIll) {
        for (int llllllllllllllIlIlllllIllIIIIIlI = this.tableLength(), llllllllllllllIlIlllllIllIIIIlIl = 0; llllllllllllllIlIlllllIllIIIIlIl < llllllllllllllIlIlllllIllIIIIIlI; ++llllllllllllllIlIlllllIllIIIIlIl) {
            if (llllllllllllllIlIlllllIllIIIIIll == this.lineNumber(llllllllllllllIlIlllllIllIIIIlIl)) {
                return this.startPc(llllllllllllllIlIlllllIllIIIIlIl);
            }
        }
        return -1;
    }
    
    public static class Pc
    {
        public /* synthetic */ int line;
        public /* synthetic */ int index;
    }
}
