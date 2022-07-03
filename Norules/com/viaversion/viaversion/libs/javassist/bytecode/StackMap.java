package com.viaversion.viaversion.libs.javassist.bytecode;

import com.viaversion.viaversion.libs.javassist.*;
import java.util.*;
import java.io.*;

public class StackMap extends AttributeInfo
{
    void shiftPc(final int llllllllllllllIllIlllllIlIlllIIl, final int llllllllllllllIllIlllllIlIllIlII, final boolean llllllllllllllIllIlllllIlIllIIll) throws BadBytecode {
        new Shifter(this, llllllllllllllIllIlllllIlIlllIIl, llllllllllllllIllIlllllIlIllIlII, llllllllllllllIllIlllllIlIllIIll).visit();
    }
    
    public void print(final PrintWriter llllllllllllllIllIlllllIlIIlllIl) {
        new Printer(this, llllllllllllllIllIlllllIlIIlllIl).print();
    }
    
    public void removeNew(final int llllllllllllllIllIlllllIlIlIIIlI) throws CannotCompileException {
        final byte[] llllllllllllllIllIlllllIlIlIIlII = new NewRemover(this, llllllllllllllIllIlllllIlIlIIIlI).doit();
        this.set(llllllllllllllIllIlllllIlIlIIlII);
    }
    
    public void insertLocal(final int llllllllllllllIllIlllllIllIIIIlI, final int llllllllllllllIllIlllllIllIIIllI, final int llllllllllllllIllIlllllIllIIIIII) throws BadBytecode {
        final byte[] llllllllllllllIllIlllllIllIIIlII = new InsertLocal(this, llllllllllllllIllIlllllIllIIIIlI, llllllllllllllIllIlllllIllIIIllI, llllllllllllllIllIlllllIllIIIIII).doit();
        this.set(llllllllllllllIllIlllllIllIIIlII);
    }
    
    static {
        tag = "StackMap";
        LONG = 4;
        OBJECT = 7;
        NULL = 5;
        FLOAT = 2;
        DOUBLE = 3;
        INTEGER = 1;
        TOP = 0;
        UNINIT = 8;
        THIS = 6;
    }
    
    StackMap(final ConstPool llllllllllllllIllIlllllIlllIlIlI, final byte[] llllllllllllllIllIlllllIlllIllII) {
        super(llllllllllllllIllIlllllIlllIlIlI, "StackMap", llllllllllllllIllIlllllIlllIllII);
    }
    
    void shiftForSwitch(final int llllllllllllllIllIlllllIlIlIlIll, final int llllllllllllllIllIlllllIlIlIlIlI) throws BadBytecode {
        new SwitchShifter(this, llllllllllllllIllIlllllIlIlIlIll, llllllllllllllIllIlllllIlIlIlIlI).visit();
    }
    
    @Override
    public AttributeInfo copy(final ConstPool llllllllllllllIllIlllllIllIlIlII, final Map<String, String> llllllllllllllIllIlllllIllIlIIll) {
        final Copier llllllllllllllIllIlllllIllIlIIlI = new Copier(this, llllllllllllllIllIlllllIllIlIlII, llllllllllllllIllIlllllIllIlIIll);
        llllllllllllllIllIlllllIllIlIIlI.visit();
        return llllllllllllllIllIlllllIllIlIIlI.getStackMap();
    }
    
    StackMap(final ConstPool llllllllllllllIllIlllllIllIlllll, final int llllllllllllllIllIlllllIlllIIIlI, final DataInputStream llllllllllllllIllIlllllIllIlllIl) throws IOException {
        super(llllllllllllllIllIlllllIllIlllll, llllllllllllllIllIlllllIlllIIIlI, llllllllllllllIllIlllllIllIlllIl);
    }
    
    public int numOfEntries() {
        return ByteArray.readU16bit(this.info, 0);
    }
    
    static class NewRemover extends SimpleCopy
    {
        /* synthetic */ int posOfNew;
        
        NewRemover(final StackMap lllllllllllllIIlIIlIIlIlIllIlllI, final int lllllllllllllIIlIIlIIlIlIllIllIl) {
            super(lllllllllllllIIlIIlIIlIlIllIlllI);
            this.posOfNew = lllllllllllllIIlIIlIIlIlIllIllIl;
        }
        
        @Override
        public int stack(final int lllllllllllllIIlIIlIIlIlIllIIIll, final int lllllllllllllIIlIIlIIlIlIllIIIlI, final int lllllllllllllIIlIIlIIlIlIllIIIIl) {
            return this.stackTypeInfoArray(lllllllllllllIIlIIlIIlIlIllIIIll, lllllllllllllIIlIIlIIlIlIllIIIlI, lllllllllllllIIlIIlIIlIlIllIIIIl);
        }
        
        private int stackTypeInfoArray(int lllllllllllllIIlIIlIIlIlIlIlIIII, final int lllllllllllllIIlIIlIIlIlIlIIllll, final int lllllllllllllIIlIIlIIlIlIlIIlIIl) {
            int lllllllllllllIIlIIlIIlIlIlIIllIl = lllllllllllllIIlIIlIIlIlIlIlIIII;
            int lllllllllllllIIlIIlIIlIlIlIIllII = 0;
            for (int lllllllllllllIIlIIlIIlIlIlIlIllI = 0; lllllllllllllIIlIIlIIlIlIlIlIllI < lllllllllllllIIlIIlIIlIlIlIIlIIl; ++lllllllllllllIIlIIlIIlIlIlIlIllI) {
                final byte lllllllllllllIIlIIlIIlIlIlIlIlll = this.info[lllllllllllllIIlIIlIIlIlIlIIllIl];
                if (lllllllllllllIIlIIlIIlIlIlIlIlll == 7) {
                    lllllllllllllIIlIIlIIlIlIlIIllIl += 3;
                }
                else if (lllllllllllllIIlIIlIIlIlIlIlIlll == 8) {
                    final int lllllllllllllIIlIIlIIlIlIlIllIII = ByteArray.readU16bit(this.info, lllllllllllllIIlIIlIIlIlIlIIllIl + 1);
                    if (lllllllllllllIIlIIlIIlIlIlIllIII == this.posOfNew) {
                        ++lllllllllllllIIlIIlIIlIlIlIIllII;
                    }
                    lllllllllllllIIlIIlIIlIlIlIIllIl += 3;
                }
                else {
                    ++lllllllllllllIIlIIlIIlIlIlIIllIl;
                }
            }
            this.writer.write16bit(lllllllllllllIIlIIlIIlIlIlIIlIIl - lllllllllllllIIlIIlIIlIlIlIIllII);
            for (int lllllllllllllIIlIIlIIlIlIlIlIIlI = 0; lllllllllllllIIlIIlIIlIlIlIlIIlI < lllllllllllllIIlIIlIIlIlIlIIlIIl; ++lllllllllllllIIlIIlIIlIlIlIlIIlI) {
                final byte lllllllllllllIIlIIlIIlIlIlIlIIll = this.info[lllllllllllllIIlIIlIIlIlIlIlIIII];
                if (lllllllllllllIIlIIlIIlIlIlIlIIll == 7) {
                    final int lllllllllllllIIlIIlIIlIlIlIlIlIl = ByteArray.readU16bit(this.info, lllllllllllllIIlIIlIIlIlIlIlIIII + 1);
                    this.objectVariable(lllllllllllllIIlIIlIIlIlIlIlIIII, lllllllllllllIIlIIlIIlIlIlIlIlIl);
                    lllllllllllllIIlIIlIIlIlIlIlIIII += 3;
                }
                else if (lllllllllllllIIlIIlIIlIlIlIlIIll == 8) {
                    final int lllllllllllllIIlIIlIIlIlIlIlIlII = ByteArray.readU16bit(this.info, lllllllllllllIIlIIlIIlIlIlIlIIII + 1);
                    if (lllllllllllllIIlIIlIIlIlIlIlIlII != this.posOfNew) {
                        this.uninitialized(lllllllllllllIIlIIlIIlIlIlIlIIII, lllllllllllllIIlIIlIIlIlIlIlIlII);
                    }
                    lllllllllllllIIlIIlIIlIlIlIlIIII += 3;
                }
                else {
                    this.typeInfo(lllllllllllllIIlIIlIIlIlIlIlIIII, lllllllllllllIIlIIlIIlIlIlIlIIll);
                    ++lllllllllllllIIlIIlIIlIlIlIlIIII;
                }
            }
            return lllllllllllllIIlIIlIIlIlIlIlIIII;
        }
    }
    
    public static class Writer
    {
        private /* synthetic */ ByteArrayOutputStream output;
        
        public void writeVerifyTypeInfo(final int lllllllllllllIlllllIIllIllllIIII, final int lllllllllllllIlllllIIllIlllIlllI) {
            this.output.write(lllllllllllllIlllllIIllIllllIIII);
            if (lllllllllllllIlllllIIllIllllIIII == 7 || lllllllllllllIlllllIIllIllllIIII == 8) {
                this.write16bit(lllllllllllllIlllllIIllIlllIlllI);
            }
        }
        
        public Writer() {
            this.output = new ByteArrayOutputStream();
        }
        
        public byte[] toByteArray() {
            return this.output.toByteArray();
        }
        
        public StackMap toStackMap(final ConstPool lllllllllllllIlllllIIlllIIIIIIlI) {
            return new StackMap(lllllllllllllIlllllIIlllIIIIIIlI, this.output.toByteArray());
        }
        
        public void write16bit(final int lllllllllllllIlllllIIllIllIllllI) {
            this.output.write(lllllllllllllIlllllIIllIllIllllI >>> 8 & 0xFF);
            this.output.write(lllllllllllllIlllllIIllIllIllllI & 0xFF);
        }
    }
    
    static class SimpleCopy extends Walker
    {
        /* synthetic */ Writer writer;
        
        @Override
        public void typeInfo(final int lllllllllllllllllIllllIllIlIlIIl, final byte lllllllllllllllllIllllIllIlIlIII) {
            this.writer.writeVerifyTypeInfo(lllllllllllllllllIllllIllIlIlIII, 0);
        }
        
        @Override
        public int locals(final int lllllllllllllllllIllllIllIlllllI, final int lllllllllllllllllIllllIlllIIIIIl, final int lllllllllllllllllIllllIllIllllII) {
            this.writer.write16bit(lllllllllllllllllIllllIlllIIIIIl);
            return super.locals(lllllllllllllllllIllllIllIlllllI, lllllllllllllllllIllllIlllIIIIIl, lllllllllllllllllIllllIllIllllII);
        }
        
        @Override
        public void objectVariable(final int lllllllllllllllllIllllIllIlIIIlI, final int lllllllllllllllllIllllIllIIlllll) {
            this.writer.writeVerifyTypeInfo(7, lllllllllllllllllIllllIllIIlllll);
        }
        
        SimpleCopy(final StackMap lllllllllllllllllIllllIlllIlIIll) {
            super(lllllllllllllllllIllllIlllIlIIll);
            this.writer = new Writer();
        }
        
        @Override
        public void visit() {
            final int lllllllllllllllllIllllIlllIIlIlI = ByteArray.readU16bit(this.info, 0);
            this.writer.write16bit(lllllllllllllllllIllllIlllIIlIlI);
            super.visit();
        }
        
        @Override
        public void uninitialized(final int lllllllllllllllllIllllIllIIllIll, final int lllllllllllllllllIllllIllIIllIII) {
            this.writer.writeVerifyTypeInfo(8, lllllllllllllllllIllllIllIIllIII);
        }
        
        @Override
        public int typeInfoArray(final int lllllllllllllllllIllllIllIllIlIl, final int lllllllllllllllllIllllIllIlIllll, final int lllllllllllllllllIllllIllIlIlllI, final boolean lllllllllllllllllIllllIllIlIllIl) {
            this.writer.write16bit(lllllllllllllllllIllllIllIlIlllI);
            return super.typeInfoArray(lllllllllllllllllIllllIllIllIlIl, lllllllllllllllllIllllIllIlIllll, lllllllllllllllllIllllIllIlIlllI, lllllllllllllllllIllllIllIlIllIl);
        }
        
        byte[] doit() {
            this.visit();
            return this.writer.toByteArray();
        }
    }
    
    public static class Walker
    {
        /* synthetic */ byte[] info;
        
        public int typeInfoArray(int llllllllllllllIIlIIlllIlIlIlllII, final int llllllllllllllIIlIIlllIlIllIIIII, final int llllllllllllllIIlIIlllIlIlIlllll, final boolean llllllllllllllIIlIIlllIlIlIllllI) {
            for (int llllllllllllllIIlIIlllIlIllIIIll = 0; llllllllllllllIIlIIlllIlIllIIIll < llllllllllllllIIlIIlllIlIlIlllll; ++llllllllllllllIIlIIlllIlIllIIIll) {
                llllllllllllllIIlIIlllIlIlIlllII = this.typeInfoArray2(llllllllllllllIIlIIlllIlIllIIIll, llllllllllllllIIlIIlllIlIlIlllII);
            }
            return llllllllllllllIIlIIlllIlIlIlllII;
        }
        
        public void uninitialized(final int llllllllllllllIIlIIlllIlIlIIIlII, final int llllllllllllllIIlIIlllIlIlIIIIll) {
        }
        
        public void visit() {
            final int llllllllllllllIIlIIlllIllIIIlIII = ByteArray.readU16bit(this.info, 0);
            int llllllllllllllIIlIIlllIllIIIIlll = 2;
            for (int llllllllllllllIIlIIlllIllIIIlIlI = 0; llllllllllllllIIlIIlllIllIIIlIlI < llllllllllllllIIlIIlllIllIIIlIII; ++llllllllllllllIIlIIlllIllIIIlIlI) {
                final int llllllllllllllIIlIIlllIllIIIllIl = ByteArray.readU16bit(this.info, llllllllllllllIIlIIlllIllIIIIlll);
                final int llllllllllllllIIlIIlllIllIIIllII = ByteArray.readU16bit(this.info, llllllllllllllIIlIIlllIllIIIIlll + 2);
                llllllllllllllIIlIIlllIllIIIIlll = this.locals(llllllllllllllIIlIIlllIllIIIIlll + 4, llllllllllllllIIlIIlllIllIIIllIl, llllllllllllllIIlIIlllIllIIIllII);
                final int llllllllllllllIIlIIlllIllIIIlIll = ByteArray.readU16bit(this.info, llllllllllllllIIlIIlllIllIIIIlll);
                llllllllllllllIIlIIlllIllIIIIlll = this.stack(llllllllllllllIIlIIlllIllIIIIlll + 2, llllllllllllllIIlIIlllIllIIIllIl, llllllllllllllIIlIIlllIllIIIlIll);
            }
        }
        
        public Walker(final StackMap llllllllllllllIIlIIlllIllIIlIlIl) {
            this.info = llllllllllllllIIlIIlllIllIIlIlIl.get();
        }
        
        public void objectVariable(final int llllllllllllllIIlIIlllIlIlIIIlll, final int llllllllllllllIIlIIlllIlIlIIIllI) {
        }
        
        public int stack(final int llllllllllllllIIlIIlllIlIllIlIlI, final int llllllllllllllIIlIIlllIlIllIllIl, final int llllllllllllllIIlIIlllIlIllIlIII) {
            return this.typeInfoArray(llllllllllllllIIlIIlllIlIllIlIlI, llllllllllllllIIlIIlllIlIllIllIl, llllllllllllllIIlIIlllIlIllIlIII, false);
        }
        
        public void typeInfo(final int llllllllllllllIIlIIlllIlIlIIlIlI, final byte llllllllllllllIIlIIlllIlIlIIlIIl) {
        }
        
        int typeInfoArray2(final int llllllllllllllIIlIIlllIlIlIlIIlI, int llllllllllllllIIlIIlllIlIlIIlllI) {
            final byte llllllllllllllIIlIIlllIlIlIlIIII = this.info[llllllllllllllIIlIIlllIlIlIIlllI];
            if (llllllllllllllIIlIIlllIlIlIlIIII == 7) {
                final int llllllllllllllIIlIIlllIlIlIlIlIl = ByteArray.readU16bit(this.info, llllllllllllllIIlIIlllIlIlIIlllI + 1);
                this.objectVariable(llllllllllllllIIlIIlllIlIlIIlllI, llllllllllllllIIlIIlllIlIlIlIlIl);
                llllllllllllllIIlIIlllIlIlIIlllI += 3;
            }
            else if (llllllllllllllIIlIIlllIlIlIlIIII == 8) {
                final int llllllllllllllIIlIIlllIlIlIlIlII = ByteArray.readU16bit(this.info, llllllllllllllIIlIIlllIlIlIIlllI + 1);
                this.uninitialized(llllllllllllllIIlIIlllIlIlIIlllI, llllllllllllllIIlIIlllIlIlIlIlII);
                llllllllllllllIIlIIlllIlIlIIlllI += 3;
            }
            else {
                this.typeInfo(llllllllllllllIIlIIlllIlIlIIlllI, llllllllllllllIIlIIlllIlIlIlIIII);
                ++llllllllllllllIIlIIlllIlIlIIlllI;
            }
            return llllllllllllllIIlIIlllIlIlIIlllI;
        }
        
        public int locals(final int llllllllllllllIIlIIlllIlIlllIllI, final int llllllllllllllIIlIIlllIlIlllIlIl, final int llllllllllllllIIlIIlllIlIlllIlII) {
            return this.typeInfoArray(llllllllllllllIIlIIlllIlIlllIllI, llllllllllllllIIlIIlllIlIlllIlIl, llllllllllllllIIlIIlllIlIlllIlII, true);
        }
    }
    
    static class Copier extends Walker
    {
        /* synthetic */ ConstPool destCp;
        /* synthetic */ ConstPool srcCp;
        /* synthetic */ byte[] dest;
        /* synthetic */ Map<String, String> classnames;
        
        @Override
        public int typeInfoArray(final int llllllllllllllllIlIlIlllIIIIIllI, final int llllllllllllllllIlIlIlllIIIIIlIl, final int llllllllllllllllIlIlIllIllllllll, final boolean llllllllllllllllIlIlIlllIIIIIIll) {
            ByteArray.write16bit(llllllllllllllllIlIlIllIllllllll, this.dest, llllllllllllllllIlIlIlllIIIIIllI - 2);
            return super.typeInfoArray(llllllllllllllllIlIlIlllIIIIIllI, llllllllllllllllIlIlIlllIIIIIlIl, llllllllllllllllIlIlIllIllllllll, llllllllllllllllIlIlIlllIIIIIIll);
        }
        
        @Override
        public void typeInfo(final int llllllllllllllllIlIlIllIllllIllI, final byte llllllllllllllllIlIlIllIlllllIII) {
            this.dest[llllllllllllllllIlIlIllIllllIllI] = llllllllllllllllIlIlIllIlllllIII;
        }
        
        @Override
        public void uninitialized(final int llllllllllllllllIlIlIllIlllIIIIl, final int llllllllllllllllIlIlIllIlllIIIll) {
            this.dest[llllllllllllllllIlIlIllIlllIIIIl] = 8;
            ByteArray.write16bit(llllllllllllllllIlIlIllIlllIIIll, this.dest, llllllllllllllllIlIlIllIlllIIIIl + 1);
        }
        
        @Override
        public int locals(final int llllllllllllllllIlIlIlllIIIIllll, final int llllllllllllllllIlIlIlllIIIIlllI, final int llllllllllllllllIlIlIlllIIIIllIl) {
            ByteArray.write16bit(llllllllllllllllIlIlIlllIIIIlllI, this.dest, llllllllllllllllIlIlIlllIIIIllll - 4);
            return super.locals(llllllllllllllllIlIlIlllIIIIllll, llllllllllllllllIlIlIlllIIIIlllI, llllllllllllllllIlIlIlllIIIIllIl);
        }
        
        Copier(final StackMap llllllllllllllllIlIlIlllIIlIIlIl, final ConstPool llllllllllllllllIlIlIlllIIlIIIII, final Map<String, String> llllllllllllllllIlIlIlllIIlIIIll) {
            super(llllllllllllllllIlIlIlllIIlIIlIl);
            this.srcCp = llllllllllllllllIlIlIlllIIlIIlIl.getConstPool();
            this.dest = new byte[this.info.length];
            this.destCp = llllllllllllllllIlIlIlllIIlIIIII;
            this.classnames = llllllllllllllllIlIlIlllIIlIIIll;
        }
        
        public StackMap getStackMap() {
            return new StackMap(this.destCp, this.dest);
        }
        
        @Override
        public void visit() {
            final int llllllllllllllllIlIlIlllIIIllIll = ByteArray.readU16bit(this.info, 0);
            ByteArray.write16bit(llllllllllllllllIlIlIlllIIIllIll, this.dest, 0);
            super.visit();
        }
        
        @Override
        public void objectVariable(final int llllllllllllllllIlIlIllIlllIlIll, final int llllllllllllllllIlIlIllIlllIlllI) {
            this.dest[llllllllllllllllIlIlIllIlllIlIll] = 7;
            final int llllllllllllllllIlIlIllIlllIllIl = this.srcCp.copy(llllllllllllllllIlIlIllIlllIlllI, this.destCp, this.classnames);
            ByteArray.write16bit(llllllllllllllllIlIlIllIlllIllIl, this.dest, llllllllllllllllIlIlIllIlllIlIll + 1);
        }
    }
    
    static class InsertLocal extends SimpleCopy
    {
        private /* synthetic */ int varIndex;
        private /* synthetic */ int varTag;
        private /* synthetic */ int varData;
        
        @Override
        public int typeInfoArray(int llllllllllllIllllllIIIIIlIIlllII, final int llllllllllllIllllllIIIIIlIlIIIII, final int llllllllllllIllllllIIIIIlIIllIlI, final boolean llllllllllllIllllllIIIIIlIIllllI) {
            if (!llllllllllllIllllllIIIIIlIIllllI || llllllllllllIllllllIIIIIlIIllIlI < this.varIndex) {
                return super.typeInfoArray(llllllllllllIllllllIIIIIlIIlllII, llllllllllllIllllllIIIIIlIlIIIII, llllllllllllIllllllIIIIIlIIllIlI, llllllllllllIllllllIIIIIlIIllllI);
            }
            this.writer.write16bit(llllllllllllIllllllIIIIIlIIllIlI + 1);
            for (int llllllllllllIllllllIIIIIlIlIIIll = 0; llllllllllllIllllllIIIIIlIlIIIll < llllllllllllIllllllIIIIIlIIllIlI; ++llllllllllllIllllllIIIIIlIlIIIll) {
                if (llllllllllllIllllllIIIIIlIlIIIll == this.varIndex) {
                    this.writeVarTypeInfo();
                }
                llllllllllllIllllllIIIIIlIIlllII = this.typeInfoArray2(llllllllllllIllllllIIIIIlIlIIIll, llllllllllllIllllllIIIIIlIIlllII);
            }
            if (llllllllllllIllllllIIIIIlIIllIlI == this.varIndex) {
                this.writeVarTypeInfo();
            }
            return llllllllllllIllllllIIIIIlIIlllII;
        }
        
        private void writeVarTypeInfo() {
            if (this.varTag == 7) {
                this.writer.writeVerifyTypeInfo(7, this.varData);
            }
            else if (this.varTag == 8) {
                this.writer.writeVerifyTypeInfo(8, this.varData);
            }
            else {
                this.writer.writeVerifyTypeInfo(this.varTag, 0);
            }
        }
        
        InsertLocal(final StackMap llllllllllllIllllllIIIIIlIlIllIl, final int llllllllllllIllllllIIIIIlIlIllII, final int llllllllllllIllllllIIIIIlIlIlIll, final int llllllllllllIllllllIIIIIlIlIllll) {
            super(llllllllllllIllllllIIIIIlIlIllIl);
            this.varIndex = llllllllllllIllllllIIIIIlIlIllII;
            this.varTag = llllllllllllIllllllIIIIIlIlIlIll;
            this.varData = llllllllllllIllllllIIIIIlIlIllll;
        }
    }
    
    static class Shifter extends Walker
    {
        private /* synthetic */ int where;
        private /* synthetic */ boolean exclusive;
        private /* synthetic */ int gap;
        
        public Shifter(final StackMap lllllllllllllIIllIllIlIlllIIIlll, final int lllllllllllllIIllIllIlIlllIIlIll, final int lllllllllllllIIllIllIlIlllIIIlIl, final boolean lllllllllllllIIllIllIlIlllIIIlII) {
            super(lllllllllllllIIllIllIlIlllIIIlll);
            this.where = lllllllllllllIIllIllIlIlllIIlIll;
            this.gap = lllllllllllllIIllIllIlIlllIIIlIl;
            this.exclusive = lllllllllllllIIllIllIlIlllIIIlII;
        }
        
        @Override
        public int locals(final int lllllllllllllIIllIllIlIllIlllIlI, final int lllllllllllllIIllIllIlIllIllllIl, final int lllllllllllllIIllIllIlIllIlllIII) {
            if (this.exclusive) {
                if (this.where > lllllllllllllIIllIllIlIllIllllIl) {
                    return super.locals(lllllllllllllIIllIllIlIllIlllIlI, lllllllllllllIIllIllIlIllIllllIl, lllllllllllllIIllIllIlIllIlllIII);
                }
            }
            else if (this.where >= lllllllllllllIIllIllIlIllIllllIl) {
                return super.locals(lllllllllllllIIllIllIlIllIlllIlI, lllllllllllllIIllIllIlIllIllllIl, lllllllllllllIIllIllIlIllIlllIII);
            }
            ByteArray.write16bit(lllllllllllllIIllIllIlIllIllllIl + this.gap, this.info, lllllllllllllIIllIllIlIllIlllIlI - 4);
            return super.locals(lllllllllllllIIllIllIlIllIlllIlI, lllllllllllllIIllIllIlIllIllllIl, lllllllllllllIIllIllIlIllIlllIII);
        }
        
        @Override
        public void uninitialized(final int lllllllllllllIIllIllIlIllIllIIll, final int lllllllllllllIIllIllIlIllIlIllll) {
            if (this.where <= lllllllllllllIIllIllIlIllIlIllll) {
                ByteArray.write16bit(lllllllllllllIIllIllIlIllIlIllll + this.gap, this.info, lllllllllllllIIllIllIlIllIllIIll + 1);
            }
        }
    }
    
    static class SwitchShifter extends Walker
    {
        private /* synthetic */ int gap;
        private /* synthetic */ int where;
        
        @Override
        public int locals(final int lllllllllllllIIIlllllIlllIIllIlI, final int lllllllllllllIIIlllllIlllIIlIlIl, final int lllllllllllllIIIlllllIlllIIllIII) {
            if (this.where == lllllllllllllIIIlllllIlllIIllIlI + lllllllllllllIIIlllllIlllIIlIlIl) {
                ByteArray.write16bit(lllllllllllllIIIlllllIlllIIlIlIl - this.gap, this.info, lllllllllllllIIIlllllIlllIIllIlI - 4);
            }
            else if (this.where == lllllllllllllIIIlllllIlllIIllIlI) {
                ByteArray.write16bit(lllllllllllllIIIlllllIlllIIlIlIl + this.gap, this.info, lllllllllllllIIIlllllIlllIIllIlI - 4);
            }
            return super.locals(lllllllllllllIIIlllllIlllIIllIlI, lllllllllllllIIIlllllIlllIIlIlIl, lllllllllllllIIIlllllIlllIIllIII);
        }
        
        public SwitchShifter(final StackMap lllllllllllllIIIlllllIlllIlIIllI, final int lllllllllllllIIIlllllIlllIlIIlIl, final int lllllllllllllIIIlllllIlllIlIIIII) {
            super(lllllllllllllIIIlllllIlllIlIIllI);
            this.where = lllllllllllllIIIlllllIlllIlIIlIl;
            this.gap = lllllllllllllIIIlllllIlllIlIIIII;
        }
    }
    
    static class Printer extends Walker
    {
        private /* synthetic */ PrintWriter writer;
        
        public void print() {
            final int lllllllllllllIIIllIlIlIlIIIIIIlI = ByteArray.readU16bit(this.info, 0);
            this.writer.println(String.valueOf(new StringBuilder().append(lllllllllllllIIIllIlIlIlIIIIIIlI).append(" entries")));
            this.visit();
        }
        
        public Printer(final StackMap lllllllllllllIIIllIlIlIlIIIIIlll, final PrintWriter lllllllllllllIIIllIlIlIlIIIIlIIl) {
            super(lllllllllllllIIIllIlIlIlIIIIIlll);
            this.writer = lllllllllllllIIIllIlIlIlIIIIlIIl;
        }
        
        @Override
        public int locals(final int lllllllllllllIIIllIlIlIIlllllIlI, final int lllllllllllllIIIllIlIlIIllllIlIl, final int lllllllllllllIIIllIlIlIIlllllIII) {
            this.writer.println(String.valueOf(new StringBuilder().append("  * offset ").append(lllllllllllllIIIllIlIlIIllllIlIl)));
            return super.locals(lllllllllllllIIIllIlIlIIlllllIlI, lllllllllllllIIIllIlIlIIllllIlIl, lllllllllllllIIIllIlIlIIlllllIII);
        }
    }
}
