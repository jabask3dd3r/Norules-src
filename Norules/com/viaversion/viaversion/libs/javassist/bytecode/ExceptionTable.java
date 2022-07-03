package com.viaversion.viaversion.libs.javassist.bytecode;

import java.io.*;
import java.util.*;

public class ExceptionTable implements Cloneable
{
    private /* synthetic */ ConstPool constPool;
    private /* synthetic */ List<ExceptionTableEntry> entries;
    
    public void setStartPc(final int llllllllllllllllIIlIlllllIIlIlIl, final int llllllllllllllllIIlIlllllIIIllll) {
        this.entries.get(llllllllllllllllIIlIlllllIIlIlIl).startPc = llllllllllllllllIIlIlllllIIIllll;
    }
    
    public ExceptionTable copy(final ConstPool llllllllllllllllIIlIlllIllIlIIll, final Map<String, String> llllllllllllllllIIlIlllIllIlIlll) {
        final ExceptionTable llllllllllllllllIIlIlllIllIlIllI = new ExceptionTable(llllllllllllllllIIlIlllIllIlIIll);
        final ConstPool llllllllllllllllIIlIlllIllIlIlIl = this.constPool;
        for (final ExceptionTableEntry llllllllllllllllIIlIlllIllIllIlI : this.entries) {
            final int llllllllllllllllIIlIlllIllIllIll = llllllllllllllllIIlIlllIllIlIlIl.copy(llllllllllllllllIIlIlllIllIllIlI.catchType, llllllllllllllllIIlIlllIllIlIIll, llllllllllllllllIIlIlllIllIlIlll);
            llllllllllllllllIIlIlllIllIlIllI.add(llllllllllllllllIIlIlllIllIllIlI.startPc, llllllllllllllllIIlIlllIllIllIlI.endPc, llllllllllllllllIIlIlllIllIllIlI.handlerPc, llllllllllllllllIIlIlllIllIllIll);
        }
        return llllllllllllllllIIlIlllIllIlIllI;
    }
    
    void write(final DataOutputStream llllllllllllllllIIlIlllIlIlIlIIl) throws IOException {
        llllllllllllllllIIlIlllIlIlIlIIl.writeShort(this.size());
        for (final ExceptionTableEntry llllllllllllllllIIlIlllIlIlIlIll : this.entries) {
            llllllllllllllllIIlIlllIlIlIlIIl.writeShort(llllllllllllllllIIlIlllIlIlIlIll.startPc);
            llllllllllllllllIIlIlllIlIlIlIIl.writeShort(llllllllllllllllIIlIlllIlIlIlIll.endPc);
            llllllllllllllllIIlIlllIlIlIlIIl.writeShort(llllllllllllllllIIlIlllIlIlIlIll.handlerPc);
            llllllllllllllllIIlIlllIlIlIlIIl.writeShort(llllllllllllllllIIlIlllIlIlIlIll.catchType);
        }
    }
    
    public int size() {
        return this.entries.size();
    }
    
    public int catchType(final int llllllllllllllllIIlIllllIlIIIllI) {
        return this.entries.get(llllllllllllllllIIlIllllIlIIIllI).catchType;
    }
    
    public void add(final int llllllllllllllllIIlIllllIIIllllI, final ExceptionTable llllllllllllllllIIlIllllIIlIIllI, final int llllllllllllllllIIlIllllIIlIIlII) {
        int llllllllllllllllIIlIllllIIlIIIlI = llllllllllllllllIIlIllllIIlIIllI.size();
        while (--llllllllllllllllIIlIllllIIlIIIlI >= 0) {
            final ExceptionTableEntry llllllllllllllllIIlIllllIIlIlIll = llllllllllllllllIIlIllllIIlIIllI.entries.get(llllllllllllllllIIlIllllIIlIIIlI);
            this.add(llllllllllllllllIIlIllllIIIllllI, llllllllllllllllIIlIllllIIlIlIll.startPc + llllllllllllllllIIlIllllIIlIIlII, llllllllllllllllIIlIllllIIlIlIll.endPc + llllllllllllllllIIlIllllIIlIIlII, llllllllllllllllIIlIllllIIlIlIll.handlerPc + llllllllllllllllIIlIllllIIlIIlII, llllllllllllllllIIlIllllIIlIlIll.catchType);
        }
    }
    
    public int endPc(final int llllllllllllllllIIlIlllllIIIIIlI) {
        return this.entries.get(llllllllllllllllIIlIlllllIIIIIlI).endPc;
    }
    
    public void setHandlerPc(final int llllllllllllllllIIlIllllIlIlIIll, final int llllllllllllllllIIlIllllIlIlIIlI) {
        this.entries.get(llllllllllllllllIIlIllllIlIlIIll).handlerPc = llllllllllllllllIIlIllllIlIlIIlI;
    }
    
    public ExceptionTable(final ConstPool llllllllllllllllIIlIlllllllllIlI) {
        this.constPool = llllllllllllllllIIlIlllllllllIlI;
        this.entries = new ArrayList<ExceptionTableEntry>();
    }
    
    public void add(final int llllllllllllllllIIlIlllIlllIllIl, final int llllllllllllllllIIlIlllIllllIIIl, final int llllllllllllllllIIlIlllIlllIlIll, final int llllllllllllllllIIlIlllIlllIllll) {
        if (llllllllllllllllIIlIlllIlllIllIl < llllllllllllllllIIlIlllIllllIIIl) {
            this.entries.add(new ExceptionTableEntry(llllllllllllllllIIlIlllIlllIllIl, llllllllllllllllIIlIlllIllllIIIl, llllllllllllllllIIlIlllIlllIlIll, llllllllllllllllIIlIlllIlllIllll));
        }
    }
    
    public void remove(final int llllllllllllllllIIlIlllIlllIIlII) {
        this.entries.remove(llllllllllllllllIIlIlllIlllIIlII);
    }
    
    ExceptionTable(final ConstPool llllllllllllllllIIlIllllllIIlIll, final DataInputStream llllllllllllllllIIlIllllllIIIIlI) throws IOException {
        this.constPool = llllllllllllllllIIlIllllllIIlIll;
        final int llllllllllllllllIIlIllllllIIlIII = llllllllllllllllIIlIllllllIIIIlI.readUnsignedShort();
        final List<ExceptionTableEntry> llllllllllllllllIIlIllllllIIIlll = new ArrayList<ExceptionTableEntry>(llllllllllllllllIIlIllllllIIlIII);
        for (int llllllllllllllllIIlIllllllIIllIl = 0; llllllllllllllllIIlIllllllIIllIl < llllllllllllllllIIlIllllllIIlIII; ++llllllllllllllllIIlIllllllIIllIl) {
            final int llllllllllllllllIIlIllllllIlIlII = llllllllllllllllIIlIllllllIIIIlI.readUnsignedShort();
            final int llllllllllllllllIIlIllllllIlIIll = llllllllllllllllIIlIllllllIIIIlI.readUnsignedShort();
            final int llllllllllllllllIIlIllllllIlIIIl = llllllllllllllllIIlIllllllIIIIlI.readUnsignedShort();
            final int llllllllllllllllIIlIllllllIIllll = llllllllllllllllIIlIllllllIIIIlI.readUnsignedShort();
            llllllllllllllllIIlIllllllIIIlll.add(new ExceptionTableEntry(llllllllllllllllIIlIllllllIlIlII, llllllllllllllllIIlIllllllIlIIll, llllllllllllllllIIlIllllllIlIIIl, llllllllllllllllIIlIllllllIIllll));
        }
        this.entries = llllllllllllllllIIlIllllllIIIlll;
    }
    
    public void setEndPc(final int llllllllllllllllIIlIllllIlllIlll, final int llllllllllllllllIIlIllllIlllIIII) {
        this.entries.get(llllllllllllllllIIlIllllIlllIlll).endPc = llllllllllllllllIIlIllllIlllIIII;
    }
    
    public int startPc(final int llllllllllllllllIIlIlllllIIlllll) {
        return this.entries.get(llllllllllllllllIIlIlllllIIlllll).startPc;
    }
    
    public void setCatchType(final int llllllllllllllllIIlIllllIIlllllI, final int llllllllllllllllIIlIllllIIllllIl) {
        this.entries.get(llllllllllllllllIIlIllllIIlllllI).catchType = llllllllllllllllIIlIllllIIllllIl;
    }
    
    private static int shiftPc(int llllllllllllllllIIlIlllIlIllIIll, final int llllllllllllllllIIlIlllIlIllIllI, final int llllllllllllllllIIlIlllIlIllIlIl, final boolean llllllllllllllllIIlIlllIlIllIlII) {
        if (llllllllllllllllIIlIlllIlIllIIll > llllllllllllllllIIlIlllIlIllIllI || (llllllllllllllllIIlIlllIlIllIlII && llllllllllllllllIIlIlllIlIllIIll == llllllllllllllllIIlIlllIlIllIllI)) {
            llllllllllllllllIIlIlllIlIllIIll += llllllllllllllllIIlIlllIlIllIlIl;
        }
        return llllllllllllllllIIlIlllIlIllIIll;
    }
    
    public int handlerPc(final int llllllllllllllllIIlIllllIllIIllI) {
        return this.entries.get(llllllllllllllllIIlIllllIllIIllI).handlerPc;
    }
    
    public Object clone() throws CloneNotSupportedException {
        final ExceptionTable llllllllllllllllIIlIlllllIllIIll = (ExceptionTable)super.clone();
        llllllllllllllllIIlIlllllIllIIll.entries = new ArrayList<ExceptionTableEntry>(this.entries);
        return llllllllllllllllIIlIlllllIllIIll;
    }
    
    public void add(final int llllllllllllllllIIlIllllIIIIIlII, final int llllllllllllllllIIlIllllIIIIIIlI, final int llllllllllllllllIIlIlllIlllllIll, final int llllllllllllllllIIlIllllIIIIIIII, final int llllllllllllllllIIlIlllIlllllIIl) {
        if (llllllllllllllllIIlIllllIIIIIIlI < llllllllllllllllIIlIlllIlllllIll) {
            this.entries.add(llllllllllllllllIIlIllllIIIIIlII, new ExceptionTableEntry(llllllllllllllllIIlIllllIIIIIIlI, llllllllllllllllIIlIlllIlllllIll, llllllllllllllllIIlIllllIIIIIIII, llllllllllllllllIIlIlllIlllllIIl));
        }
    }
    
    void shiftPc(final int llllllllllllllllIIlIlllIllIIIIII, final int llllllllllllllllIIlIlllIllIIIIll, final boolean llllllllllllllllIIlIlllIllIIIIlI) {
        for (final ExceptionTableEntry llllllllllllllllIIlIlllIllIIIllI : this.entries) {
            llllllllllllllllIIlIlllIllIIIllI.startPc = shiftPc(llllllllllllllllIIlIlllIllIIIllI.startPc, llllllllllllllllIIlIlllIllIIIIII, llllllllllllllllIIlIlllIllIIIIll, llllllllllllllllIIlIlllIllIIIIlI);
            llllllllllllllllIIlIlllIllIIIllI.endPc = shiftPc(llllllllllllllllIIlIlllIllIIIllI.endPc, llllllllllllllllIIlIlllIllIIIIII, llllllllllllllllIIlIlllIllIIIIll, llllllllllllllllIIlIlllIllIIIIlI);
            llllllllllllllllIIlIlllIllIIIllI.handlerPc = shiftPc(llllllllllllllllIIlIlllIllIIIllI.handlerPc, llllllllllllllllIIlIlllIllIIIIII, llllllllllllllllIIlIlllIllIIIIll, llllllllllllllllIIlIlllIllIIIIlI);
        }
    }
}
