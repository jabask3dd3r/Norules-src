package com.viaversion.viaversion.libs.javassist.bytecode;

import com.viaversion.viaversion.libs.javassist.*;
import java.util.*;
import java.io.*;

public class StackMapTable extends AttributeInfo
{
    @Override
    void write(final DataOutputStream lllllllllllllIIlIIlIlIllIIIIlIII) throws IOException {
        super.write(lllllllllllllIIlIIlIlIllIIIIlIII);
    }
    
    void shiftForSwitch(final int lllllllllllllIIlIIlIlIlIllIlIllI, final int lllllllllllllIIlIIlIlIlIllIlIlIl) throws BadBytecode {
        new SwitchShifter(this, lllllllllllllIIlIIlIlIlIllIlIllI, lllllllllllllIIlIIlIlIlIllIlIlIl).doit();
    }
    
    public void removeNew(final int lllllllllllllIIlIIlIlIlIllIIllII) throws CannotCompileException {
        try {
            final byte[] lllllllllllllIIlIIlIlIlIllIlIIIl = new NewRemover(this.get(), lllllllllllllIIlIIlIlIlIllIIllII).doit();
            this.set(lllllllllllllIIlIIlIlIlIllIlIIIl);
        }
        catch (BadBytecode lllllllllllllIIlIIlIlIlIllIlIIII) {
            throw new CannotCompileException("bad stack map table", lllllllllllllIIlIIlIlIlIllIlIIII);
        }
    }
    
    static {
        UNINIT = 8;
        FLOAT = 2;
        NULL = 5;
        INTEGER = 1;
        DOUBLE = 3;
        OBJECT = 7;
        tag = "StackMapTable";
        LONG = 4;
        THIS = 6;
        TOP = 0;
    }
    
    public static int typeTagOf(final char lllllllllllllIIlIIlIlIlIllllIllI) {
        switch (lllllllllllllIIlIIlIlIlIllllIllI) {
            case 'D': {
                return 3;
            }
            case 'F': {
                return 2;
            }
            case 'J': {
                return 4;
            }
            case 'L':
            case '[': {
                return 7;
            }
            default: {
                return 1;
            }
        }
    }
    
    StackMapTable(final ConstPool lllllllllllllIIlIIlIlIllIIlIlIlI, final byte[] lllllllllllllIIlIIlIlIllIIlIIllI) {
        super(lllllllllllllIIlIIlIlIllIIlIlIlI, "StackMapTable", lllllllllllllIIlIIlIlIllIIlIIllI);
    }
    
    void shiftPc(final int lllllllllllllIIlIIlIlIlIlllIIIII, final int lllllllllllllIIlIIlIlIlIlllIIIll, final boolean lllllllllllllIIlIIlIlIlIlllIIIlI) throws BadBytecode {
        new OffsetShifter(this, lllllllllllllIIlIIlIlIlIlllIIIII, lllllllllllllIIlIIlIlIlIlllIIIll).parse();
        new Shifter(this, lllllllllllllIIlIIlIlIlIlllIIIII, lllllllllllllIIlIIlIlIlIlllIIIll, lllllllllllllIIlIIlIlIlIlllIIIlI).doit();
    }
    
    public void println(final PrintWriter lllllllllllllIIlIIlIlIlIllllIIlI) {
        Printer.print(this, lllllllllllllIIlIIlIlIlIllllIIlI);
    }
    
    @Override
    public AttributeInfo copy(final ConstPool lllllllllllllIIlIIlIlIllIIIlIIll, final Map<String, String> lllllllllllllIIlIIlIlIllIIIIllll) throws RuntimeCopyException {
        try {
            return new StackMapTable(lllllllllllllIIlIIlIlIllIIIlIIll, new Copier(this.constPool, this.info, lllllllllllllIIlIIlIlIllIIIlIIll, lllllllllllllIIlIIlIlIllIIIIllll).doit());
        }
        catch (BadBytecode lllllllllllllIIlIIlIlIllIIIlIlIl) {
            throw new RuntimeCopyException("bad bytecode. fatal?");
        }
    }
    
    public void println(final PrintStream lllllllllllllIIlIIlIlIlIlllIlIlI) {
        Printer.print(this, new PrintWriter(lllllllllllllIIlIIlIlIlIlllIlIlI, true));
    }
    
    public void insertLocal(final int lllllllllllllIIlIIlIlIllIIIIIIIl, final int lllllllllllllIIlIIlIlIlIlllllIll, final int lllllllllllllIIlIIlIlIlIlllllIlI) throws BadBytecode {
        final byte[] lllllllllllllIIlIIlIlIlIlllllllI = new InsertLocal(this.get(), lllllllllllllIIlIIlIlIllIIIIIIIl, lllllllllllllIIlIIlIlIlIlllllIll, lllllllllllllIIlIIlIlIlIlllllIlI).doit();
        this.set(lllllllllllllIIlIIlIlIlIlllllllI);
    }
    
    StackMapTable(final ConstPool lllllllllllllIIlIIlIlIllIIlIIIII, final int lllllllllllllIIlIIlIlIllIIIllIll, final DataInputStream lllllllllllllIIlIIlIlIllIIIllIlI) throws IOException {
        super(lllllllllllllIIlIIlIlIllIIlIIIII, lllllllllllllIIlIIlIlIllIIIllIll, lllllllllllllIIlIIlIlIllIIIllIlI);
    }
    
    public static class RuntimeCopyException extends RuntimeException
    {
        public RuntimeCopyException(final String lllllllllllllIIIllIlIIlIIllIlIlI) {
            super(lllllllllllllIIIllIlIIlIIllIlIlI);
        }
    }
    
    static class SimpleCopy extends Walker
    {
        private /* synthetic */ Writer writer;
        
        @Override
        public void appendFrame(final int lllllllllllllllllllIlIIllIIlIIII, final int lllllllllllllllllllIlIIllIIIllll, final int[] lllllllllllllllllllIlIIllIIIlllI, final int[] lllllllllllllllllllIlIIllIIIllIl) {
            this.writer.appendFrame(lllllllllllllllllllIlIIllIIIllll, lllllllllllllllllllIlIIllIIIlllI, this.copyData(lllllllllllllllllllIlIIllIIIlllI, lllllllllllllllllllIlIIllIIIllIl));
        }
        
        public byte[] doit() throws BadBytecode {
            this.parse();
            return this.writer.toByteArray();
        }
        
        @Override
        public void sameFrame(final int lllllllllllllllllllIlIIllIllIIII, final int lllllllllllllllllllIlIIllIlIllll) {
            this.writer.sameFrame(lllllllllllllllllllIlIIllIlIllll);
        }
        
        public SimpleCopy(final byte[] lllllllllllllllllllIlIIllIlllIIl) {
            super(lllllllllllllllllllIlIIllIlllIIl);
            this.writer = new Writer(lllllllllllllllllllIlIIllIlllIIl.length);
        }
        
        protected int copyData(final int lllllllllllllllllllIlIIlIlllIIll, final int lllllllllllllllllllIlIIlIlllIIlI) {
            return lllllllllllllllllllIlIIlIlllIIlI;
        }
        
        protected int[] copyData(final int[] lllllllllllllllllllIlIIlIllIlllI, final int[] lllllllllllllllllllIlIIlIllIllII) {
            return lllllllllllllllllllIlIIlIllIllII;
        }
        
        @Override
        public void fullFrame(final int lllllllllllllllllllIlIIllIIIIIIl, final int lllllllllllllllllllIlIIllIIIIIII, final int[] lllllllllllllllllllIlIIlIllllIIl, final int[] lllllllllllllllllllIlIIlIllllIII, final int[] lllllllllllllllllllIlIIlIlllllIl, final int[] lllllllllllllllllllIlIIlIlllllII) {
            this.writer.fullFrame(lllllllllllllllllllIlIIllIIIIIII, lllllllllllllllllllIlIIlIllllIIl, this.copyData(lllllllllllllllllllIlIIlIllllIIl, lllllllllllllllllllIlIIlIllllIII), lllllllllllllllllllIlIIlIlllllIl, this.copyData(lllllllllllllllllllIlIIlIlllllIl, lllllllllllllllllllIlIIlIlllllII));
        }
        
        @Override
        public void sameLocals(final int lllllllllllllllllllIlIIllIlIIlll, final int lllllllllllllllllllIlIIllIlIIllI, final int lllllllllllllllllllIlIIllIlIIlIl, final int lllllllllllllllllllIlIIllIlIIlII) {
            this.writer.sameLocals(lllllllllllllllllllIlIIllIlIIllI, lllllllllllllllllllIlIIllIlIIlIl, this.copyData(lllllllllllllllllllIlIIllIlIIlIl, lllllllllllllllllllIlIIllIlIIlII));
        }
        
        @Override
        public void chopFrame(final int lllllllllllllllllllIlIIllIIllIll, final int lllllllllllllllllllIlIIllIIllIlI, final int lllllllllllllllllllIlIIllIIllIIl) {
            this.writer.chopFrame(lllllllllllllllllllIlIIllIIllIlI, lllllllllllllllllllIlIIllIIllIIl);
        }
    }
    
    public static class Writer
    {
        /* synthetic */ ByteArrayOutputStream output;
        /* synthetic */ int numOfEntries;
        
        public void chopFrame(final int llllllllllllllllIlllIllIIllllIII, final int llllllllllllllllIlllIllIIlllIlII) {
            ++this.numOfEntries;
            this.output.write(251 - llllllllllllllllIlllIllIIlllIlII);
            this.write16(llllllllllllllllIlllIllIIllllIII);
        }
        
        public Writer(final int llllllllllllllllIlllIllIlIIllIll) {
            this.output = new ByteArrayOutputStream(llllllllllllllllIlllIllIlIIllIll);
            this.numOfEntries = 0;
            this.output.write(0);
            this.output.write(0);
        }
        
        public void sameFrame(final int llllllllllllllllIlllIllIlIIIlIIl) {
            ++this.numOfEntries;
            if (llllllllllllllllIlllIllIlIIIlIIl < 64) {
                this.output.write(llllllllllllllllIlllIllIlIIIlIIl);
            }
            else {
                this.output.write(251);
                this.write16(llllllllllllllllIlllIllIlIIIlIIl);
            }
        }
        
        public StackMapTable toStackMapTable(final ConstPool llllllllllllllllIlllIllIlIIlIIIl) {
            return new StackMapTable(llllllllllllllllIlllIllIlIIlIIIl, this.toByteArray());
        }
        
        private void write16(final int llllllllllllllllIlllIllIIIllllII) {
            this.output.write(llllllllllllllllIlllIllIIIllllII >>> 8 & 0xFF);
            this.output.write(llllllllllllllllIlllIllIIIllllII & 0xFF);
        }
        
        public void sameLocals(final int llllllllllllllllIlllIllIIlllllll, final int llllllllllllllllIlllIllIIllllllI, final int llllllllllllllllIlllIllIIlllllIl) {
            ++this.numOfEntries;
            if (llllllllllllllllIlllIllIIlllllll < 64) {
                this.output.write(llllllllllllllllIlllIllIIlllllll + 64);
            }
            else {
                this.output.write(247);
                this.write16(llllllllllllllllIlllIllIIlllllll);
            }
            this.writeTypeInfo(llllllllllllllllIlllIllIIllllllI, llllllllllllllllIlllIllIIlllllIl);
        }
        
        public void fullFrame(final int llllllllllllllllIlllIllIIlIlIllI, final int[] llllllllllllllllIlllIllIIlIlIlIl, final int[] llllllllllllllllIlllIllIIlIIllIl, final int[] llllllllllllllllIlllIllIIlIlIIll, final int[] llllllllllllllllIlllIllIIlIIlIll) {
            ++this.numOfEntries;
            this.output.write(255);
            this.write16(llllllllllllllllIlllIllIIlIlIllI);
            int llllllllllllllllIlllIllIIlIlIIIl = llllllllllllllllIlllIllIIlIlIlIl.length;
            this.write16(llllllllllllllllIlllIllIIlIlIIIl);
            for (int llllllllllllllllIlllIllIIlIllIIl = 0; llllllllllllllllIlllIllIIlIllIIl < llllllllllllllllIlllIllIIlIlIIIl; ++llllllllllllllllIlllIllIIlIllIIl) {
                this.writeTypeInfo(llllllllllllllllIlllIllIIlIlIlIl[llllllllllllllllIlllIllIIlIllIIl], llllllllllllllllIlllIllIIlIIllIl[llllllllllllllllIlllIllIIlIllIIl]);
            }
            llllllllllllllllIlllIllIIlIlIIIl = llllllllllllllllIlllIllIIlIlIIll.length;
            this.write16(llllllllllllllllIlllIllIIlIlIIIl);
            for (int llllllllllllllllIlllIllIIlIllIII = 0; llllllllllllllllIlllIllIIlIllIII < llllllllllllllllIlllIllIIlIlIIIl; ++llllllllllllllllIlllIllIIlIllIII) {
                this.writeTypeInfo(llllllllllllllllIlllIllIIlIlIIll[llllllllllllllllIlllIllIIlIllIII], llllllllllllllllIlllIllIIlIIlIll[llllllllllllllllIlllIllIIlIllIII]);
            }
        }
        
        private void writeTypeInfo(final int llllllllllllllllIlllIllIIlIIIlII, final int llllllllllllllllIlllIllIIlIIIIll) {
            this.output.write(llllllllllllllllIlllIllIIlIIIlII);
            if (llllllllllllllllIlllIllIIlIIIlII == 7 || llllllllllllllllIlllIllIIlIIIlII == 8) {
                this.write16(llllllllllllllllIlllIllIIlIIIIll);
            }
        }
        
        public byte[] toByteArray() {
            final byte[] llllllllllllllllIlllIllIlIIlIlll = this.output.toByteArray();
            ByteArray.write16bit(this.numOfEntries, llllllllllllllllIlllIllIlIIlIlll, 0);
            return llllllllllllllllIlllIllIlIIlIlll;
        }
        
        public void appendFrame(final int llllllllllllllllIlllIllIIllIlIll, final int[] llllllllllllllllIlllIllIIllIlIlI, final int[] llllllllllllllllIlllIllIIllIIlII) {
            ++this.numOfEntries;
            final int llllllllllllllllIlllIllIIllIlIII = llllllllllllllllIlllIllIIllIlIlI.length;
            this.output.write(llllllllllllllllIlllIllIIllIlIII + 251);
            this.write16(llllllllllllllllIlllIllIIllIlIll);
            for (int llllllllllllllllIlllIllIIllIllIl = 0; llllllllllllllllIlllIllIIllIllIl < llllllllllllllllIlllIllIIllIlIII; ++llllllllllllllllIlllIllIIllIllIl) {
                this.writeTypeInfo(llllllllllllllllIlllIllIIllIlIlI[llllllllllllllllIlllIllIIllIllIl], llllllllllllllllIlllIllIIllIIlII[llllllllllllllllIlllIllIIllIllIl]);
            }
        }
    }
    
    public static class Walker
    {
        /* synthetic */ byte[] info;
        /* synthetic */ int numOfEntries;
        
        public Walker(final StackMapTable lllllllllllllIIIllIllIIlIlIIlIll) {
            this(lllllllllllllIIIllIllIIlIlIIlIll.get());
        }
        
        private int verifyTypeInfo(int lllllllllllllIIIllIllIIIlIlIllll, final int lllllllllllllIIIllIllIIIlIlIlllI, final int[] lllllllllllllIIIllIllIIIlIlIlIII, final int[] lllllllllllllIIIllIllIIIlIlIllII) {
            for (int lllllllllllllIIIllIllIIIlIllIIIl = 0; lllllllllllllIIIllIllIIIlIllIIIl < lllllllllllllIIIllIllIIIlIlIlllI; ++lllllllllllllIIIllIllIIIlIllIIIl) {
                final int lllllllllllllIIIllIllIIIlIllIIlI = this.info[lllllllllllllIIIllIllIIIlIlIllll++] & 0xFF;
                lllllllllllllIIIllIllIIIlIlIlIII[lllllllllllllIIIllIllIIIlIllIIIl] = lllllllllllllIIIllIllIIIlIllIIlI;
                if (lllllllllllllIIIllIllIIIlIllIIlI == 7 || lllllllllllllIIIllIllIIIlIllIIlI == 8) {
                    this.objectOrUninitialized(lllllllllllllIIIllIllIIIlIllIIlI, lllllllllllllIIIllIllIIIlIlIllII[lllllllllllllIIIllIllIIIlIllIIIl] = ByteArray.readU16bit(this.info, lllllllllllllIIIllIllIIIlIlIllll), lllllllllllllIIIllIllIIIlIlIllll);
                    lllllllllllllIIIllIllIIIlIlIllll += 2;
                }
            }
            return lllllllllllllIIIllIllIIIlIlIllll;
        }
        
        private int appendFrame(final int lllllllllllllIIIllIllIIIlllIllII, final int lllllllllllllIIIllIllIIIllllIIll) throws BadBytecode {
            final int lllllllllllllIIIllIllIIIllllIIlI = lllllllllllllIIIllIllIIIllllIIll - 251;
            final int lllllllllllllIIIllIllIIIllllIIIl = ByteArray.readU16bit(this.info, lllllllllllllIIIllIllIIIlllIllII + 1);
            final int[] lllllllllllllIIIllIllIIIllllIIII = new int[lllllllllllllIIIllIllIIIllllIIlI];
            final int[] lllllllllllllIIIllIllIIIlllIllll = new int[lllllllllllllIIIllIllIIIllllIIlI];
            int lllllllllllllIIIllIllIIIlllIlllI = lllllllllllllIIIllIllIIIlllIllII + 3;
            for (int lllllllllllllIIIllIllIIIllllIllI = 0; lllllllllllllIIIllIllIIIllllIllI < lllllllllllllIIIllIllIIIllllIIlI; ++lllllllllllllIIIllIllIIIllllIllI) {
                final int lllllllllllllIIIllIllIIIllllIlll = this.info[lllllllllllllIIIllIllIIIlllIlllI] & 0xFF;
                lllllllllllllIIIllIllIIIllllIIII[lllllllllllllIIIllIllIIIllllIllI] = lllllllllllllIIIllIllIIIllllIlll;
                if (lllllllllllllIIIllIllIIIllllIlll == 7 || lllllllllllllIIIllIllIIIllllIlll == 8) {
                    this.objectOrUninitialized(lllllllllllllIIIllIllIIIllllIlll, lllllllllllllIIIllIllIIIlllIllll[lllllllllllllIIIllIllIIIllllIllI] = ByteArray.readU16bit(this.info, lllllllllllllIIIllIllIIIlllIlllI + 1), lllllllllllllIIIllIllIIIlllIlllI + 1);
                    lllllllllllllIIIllIllIIIlllIlllI += 3;
                }
                else {
                    lllllllllllllIIIllIllIIIlllIllll[lllllllllllllIIIllIllIIIllllIllI] = 0;
                    ++lllllllllllllIIIllIllIIIlllIlllI;
                }
            }
            this.appendFrame(lllllllllllllIIIllIllIIIlllIllII, lllllllllllllIIIllIllIIIllllIIIl, lllllllllllllIIIllIllIIIllllIIII, lllllllllllllIIIllIllIIIlllIllll);
            return lllllllllllllIIIllIllIIIlllIlllI;
        }
        
        int stackMapFrames(int lllllllllllllIIIllIllIIlIIlIIlll, final int lllllllllllllIIIllIllIIlIIlIIllI) throws BadBytecode {
            final int lllllllllllllIIIllIllIIlIIlIlIIl = this.info[lllllllllllllIIIllIllIIlIIlIIlll] & 0xFF;
            if (lllllllllllllIIIllIllIIlIIlIlIIl < 64) {
                this.sameFrame(lllllllllllllIIIllIllIIlIIlIIlll, lllllllllllllIIIllIllIIlIIlIlIIl);
                ++lllllllllllllIIIllIllIIlIIlIIlll;
            }
            else if (lllllllllllllIIIllIllIIlIIlIlIIl < 128) {
                lllllllllllllIIIllIllIIlIIlIIlll = this.sameLocals(lllllllllllllIIIllIllIIlIIlIIlll, lllllllllllllIIIllIllIIlIIlIlIIl);
            }
            else {
                if (lllllllllllllIIIllIllIIlIIlIlIIl < 247) {
                    throw new BadBytecode(String.valueOf(new StringBuilder().append("bad frame_type ").append(lllllllllllllIIIllIllIIlIIlIlIIl).append(" in StackMapTable (pos: ").append(lllllllllllllIIIllIllIIlIIlIIlll).append(", frame no.:").append(lllllllllllllIIIllIllIIlIIlIIllI).append(")")));
                }
                if (lllllllllllllIIIllIllIIlIIlIlIIl == 247) {
                    lllllllllllllIIIllIllIIlIIlIIlll = this.sameLocals(lllllllllllllIIIllIllIIlIIlIIlll, lllllllllllllIIIllIllIIlIIlIlIIl);
                }
                else if (lllllllllllllIIIllIllIIlIIlIlIIl < 251) {
                    final int lllllllllllllIIIllIllIIlIIlIlllI = ByteArray.readU16bit(this.info, lllllllllllllIIIllIllIIlIIlIIlll + 1);
                    this.chopFrame(lllllllllllllIIIllIllIIlIIlIIlll, lllllllllllllIIIllIllIIlIIlIlllI, 251 - lllllllllllllIIIllIllIIlIIlIlIIl);
                    lllllllllllllIIIllIllIIlIIlIIlll += 3;
                }
                else if (lllllllllllllIIIllIllIIlIIlIlIIl == 251) {
                    final int lllllllllllllIIIllIllIIlIIlIllIl = ByteArray.readU16bit(this.info, lllllllllllllIIIllIllIIlIIlIIlll + 1);
                    this.sameFrame(lllllllllllllIIIllIllIIlIIlIIlll, lllllllllllllIIIllIllIIlIIlIllIl);
                    lllllllllllllIIIllIllIIlIIlIIlll += 3;
                }
                else if (lllllllllllllIIIllIllIIlIIlIlIIl < 255) {
                    lllllllllllllIIIllIllIIlIIlIIlll = this.appendFrame(lllllllllllllIIIllIllIIlIIlIIlll, lllllllllllllIIIllIllIIlIIlIlIIl);
                }
                else {
                    lllllllllllllIIIllIllIIlIIlIIlll = this.fullFrame(lllllllllllllIIIllIllIIlIIlIIlll);
                }
            }
            return lllllllllllllIIIllIllIIlIIlIIlll;
        }
        
        public void objectOrUninitialized(final int lllllllllllllIIIllIllIIIlIlIIIll, final int lllllllllllllIIIllIllIIIlIlIIIlI, final int lllllllllllllIIIllIllIIIlIlIIIIl) {
        }
        
        private int sameLocals(int lllllllllllllIIIllIllIIlIIIlIIII, final int lllllllllllllIIIllIllIIlIIIIllll) throws BadBytecode {
            final int lllllllllllllIIIllIllIIlIIIlIlIl = lllllllllllllIIIllIllIIlIIIlIIII;
            int lllllllllllllIIIllIllIIlIIIlIlII = 0;
            if (lllllllllllllIIIllIllIIlIIIIllll < 128) {
                final int lllllllllllllIIIllIllIIlIIIllIIl = lllllllllllllIIIllIllIIlIIIIllll - 64;
            }
            else {
                lllllllllllllIIIllIllIIlIIIlIlII = ByteArray.readU16bit(this.info, lllllllllllllIIIllIllIIlIIIlIIII + 1);
                lllllllllllllIIIllIllIIlIIIlIIII += 2;
            }
            final int lllllllllllllIIIllIllIIlIIIlIIll = this.info[lllllllllllllIIIllIllIIlIIIlIIII + 1] & 0xFF;
            int lllllllllllllIIIllIllIIlIIIlIIlI = 0;
            if (lllllllllllllIIIllIllIIlIIIlIIll == 7 || lllllllllllllIIIllIllIIlIIIlIIll == 8) {
                lllllllllllllIIIllIllIIlIIIlIIlI = ByteArray.readU16bit(this.info, lllllllllllllIIIllIllIIlIIIlIIII + 2);
                this.objectOrUninitialized(lllllllllllllIIIllIllIIlIIIlIIll, lllllllllllllIIIllIllIIlIIIlIIlI, lllllllllllllIIIllIllIIlIIIlIIII + 2);
                lllllllllllllIIIllIllIIlIIIlIIII += 2;
            }
            this.sameLocals(lllllllllllllIIIllIllIIlIIIlIlIl, lllllllllllllIIIllIllIIlIIIlIlII, lllllllllllllIIIllIllIIlIIIlIIll, lllllllllllllIIIllIllIIlIIIlIIlI);
            return lllllllllllllIIIllIllIIlIIIlIIII + 2;
        }
        
        public void appendFrame(final int lllllllllllllIIIllIllIIIlllIIIlI, final int lllllllllllllIIIllIllIIIlllIIIIl, final int[] lllllllllllllIIIllIllIIIlllIIIII, final int[] lllllllllllllIIIllIllIIIllIlllll) throws BadBytecode {
        }
        
        public final int size() {
            return this.numOfEntries;
        }
        
        public Walker(final byte[] lllllllllllllIIIllIllIIlIlIIIlIl) {
            this.info = lllllllllllllIIIllIllIIlIlIIIlIl;
            this.numOfEntries = ByteArray.readU16bit(lllllllllllllIIIllIllIIlIlIIIlIl, 0);
        }
        
        public void fullFrame(final int lllllllllllllIIIllIllIIIlIllllll, final int lllllllllllllIIIllIllIIIlIlllllI, final int[] lllllllllllllIIIllIllIIIlIllllIl, final int[] lllllllllllllIIIllIllIIIlIllllII, final int[] lllllllllllllIIIllIllIIIlIlllIll, final int[] lllllllllllllIIIllIllIIIlIlllIlI) throws BadBytecode {
        }
        
        public void sameFrame(final int lllllllllllllIIIllIllIIlIIlIIIlI, final int lllllllllllllIIIllIllIIlIIlIIIIl) throws BadBytecode {
        }
        
        public void sameLocals(final int lllllllllllllIIIllIllIIlIIIIlIIl, final int lllllllllllllIIIllIllIIlIIIIlIII, final int lllllllllllllIIIllIllIIlIIIIIlll, final int lllllllllllllIIIllIllIIlIIIIIllI) throws BadBytecode {
        }
        
        public void parse() throws BadBytecode {
            final int lllllllllllllIIIllIllIIlIIlllIIl = this.numOfEntries;
            int lllllllllllllIIIllIllIIlIIlllIII = 2;
            for (int lllllllllllllIIIllIllIIlIIlllIll = 0; lllllllllllllIIIllIllIIlIIlllIll < lllllllllllllIIIllIllIIlIIlllIIl; ++lllllllllllllIIIllIllIIlIIlllIll) {
                lllllllllllllIIIllIllIIlIIlllIII = this.stackMapFrames(lllllllllllllIIIllIllIIlIIlllIII, lllllllllllllIIIllIllIIlIIlllIll);
            }
        }
        
        public void chopFrame(final int lllllllllllllIIIllIllIIlIIIIIlII, final int lllllllllllllIIIllIllIIlIIIIIIll, final int lllllllllllllIIIllIllIIlIIIIIIlI) throws BadBytecode {
        }
        
        private int fullFrame(final int lllllllllllllIIIllIllIIIllIlIIll) throws BadBytecode {
            final int lllllllllllllIIIllIllIIIllIlIIlI = ByteArray.readU16bit(this.info, lllllllllllllIIIllIllIIIllIlIIll + 1);
            final int lllllllllllllIIIllIllIIIllIlIIIl = ByteArray.readU16bit(this.info, lllllllllllllIIIllIllIIIllIlIIll + 3);
            final int[] lllllllllllllIIIllIllIIIllIlIIII = new int[lllllllllllllIIIllIllIIIllIlIIIl];
            final int[] lllllllllllllIIIllIllIIIllIIllll = new int[lllllllllllllIIIllIllIIIllIlIIIl];
            int lllllllllllllIIIllIllIIIllIIlllI = this.verifyTypeInfo(lllllllllllllIIIllIllIIIllIlIIll + 5, lllllllllllllIIIllIllIIIllIlIIIl, lllllllllllllIIIllIllIIIllIlIIII, lllllllllllllIIIllIllIIIllIIllll);
            final int lllllllllllllIIIllIllIIIllIIllIl = ByteArray.readU16bit(this.info, lllllllllllllIIIllIllIIIllIIlllI);
            final int[] lllllllllllllIIIllIllIIIllIIllII = new int[lllllllllllllIIIllIllIIIllIIllIl];
            final int[] lllllllllllllIIIllIllIIIllIIlIll = new int[lllllllllllllIIIllIllIIIllIIllIl];
            lllllllllllllIIIllIllIIIllIIlllI = this.verifyTypeInfo(lllllllllllllIIIllIllIIIllIIlllI + 2, lllllllllllllIIIllIllIIIllIIllIl, lllllllllllllIIIllIllIIIllIIllII, lllllllllllllIIIllIllIIIllIIlIll);
            this.fullFrame(lllllllllllllIIIllIllIIIllIlIIll, lllllllllllllIIIllIllIIIllIlIIlI, lllllllllllllIIIllIllIIIllIlIIII, lllllllllllllIIIllIllIIIllIIllll, lllllllllllllIIIllIllIIIllIIllII, lllllllllllllIIIllIllIIIllIIlIll);
            return lllllllllllllIIIllIllIIIllIIlllI;
        }
    }
    
    static class OffsetShifter extends Walker
    {
        /* synthetic */ int where;
        /* synthetic */ int gap;
        
        public OffsetShifter(final StackMapTable lllllllllllllIIIIllIIlllIlIllIII, final int lllllllllllllIIIIllIIlllIlIlIlll, final int lllllllllllllIIIIllIIlllIlIlIllI) {
            super(lllllllllllllIIIIllIIlllIlIllIII);
            this.where = lllllllllllllIIIIllIIlllIlIlIlll;
            this.gap = lllllllllllllIIIIllIIlllIlIlIllI;
        }
        
        @Override
        public void objectOrUninitialized(final int lllllllllllllIIIIllIIlllIlIIllII, final int lllllllllllllIIIIllIIlllIlIIllll, final int lllllllllllllIIIIllIIlllIlIIlIlI) {
            if (lllllllllllllIIIIllIIlllIlIIllII == 8 && this.where <= lllllllllllllIIIIllIIlllIlIIllll) {
                ByteArray.write16bit(lllllllllllllIIIIllIIlllIlIIllll + this.gap, this.info, lllllllllllllIIIIllIIlllIlIIlIlI);
            }
        }
    }
    
    static class InsertLocal extends SimpleCopy
    {
        private /* synthetic */ int varTag;
        private /* synthetic */ int varData;
        private /* synthetic */ int varIndex;
        
        public InsertLocal(final byte[] lllllllllllllIlIIlIIIlllIIIIIIII, final int lllllllllllllIlIIlIIIllIllllllll, final int lllllllllllllIlIIlIIIllIlllllllI, final int lllllllllllllIlIIlIIIllIllllllIl) {
            super(lllllllllllllIlIIlIIIlllIIIIIIII);
            this.varIndex = lllllllllllllIlIIlIIIllIllllllll;
            this.varTag = lllllllllllllIlIIlIIIllIlllllllI;
            this.varData = lllllllllllllIlIIlIIIllIllllllIl;
        }
        
        @Override
        public void fullFrame(final int lllllllllllllIlIIlIIIllIllIlllll, final int lllllllllllllIlIIlIIIllIlllIlIll, final int[] lllllllllllllIlIIlIIIllIlllIlIlI, final int[] lllllllllllllIlIIlIIIllIlllIlIIl, final int[] lllllllllllllIlIIlIIIllIllIllIll, final int[] lllllllllllllIlIIlIIIllIlllIIlll) {
            final int lllllllllllllIlIIlIIIllIlllIIllI = lllllllllllllIlIIlIIIllIlllIlIlI.length;
            if (lllllllllllllIlIIlIIIllIlllIIllI < this.varIndex) {
                super.fullFrame(lllllllllllllIlIIlIIIllIllIlllll, lllllllllllllIlIIlIIIllIlllIlIll, lllllllllllllIlIIlIIIllIlllIlIlI, lllllllllllllIlIIlIIIllIlllIlIIl, lllllllllllllIlIIlIIIllIllIllIll, lllllllllllllIlIIlIIIllIlllIIlll);
                return;
            }
            final int lllllllllllllIlIIlIIIllIlllIIlIl = (this.varTag == 4 || this.varTag == 3) ? 2 : 1;
            final int[] lllllllllllllIlIIlIIIllIlllIIlII = new int[lllllllllllllIlIIlIIIllIlllIIllI + lllllllllllllIlIIlIIIllIlllIIlIl];
            final int[] lllllllllllllIlIIlIIIllIlllIIIll = new int[lllllllllllllIlIIlIIIllIlllIIllI + lllllllllllllIlIIlIIIllIlllIIlIl];
            final int lllllllllllllIlIIlIIIllIlllIIIlI = this.varIndex;
            int lllllllllllllIlIIlIIIllIlllIIIIl = 0;
            for (int lllllllllllllIlIIlIIIllIlllIlllI = 0; lllllllllllllIlIIlIIIllIlllIlllI < lllllllllllllIlIIlIIIllIlllIIllI; ++lllllllllllllIlIIlIIIllIlllIlllI) {
                if (lllllllllllllIlIIlIIIllIlllIIIIl == lllllllllllllIlIIlIIIllIlllIIIlI) {
                    lllllllllllllIlIIlIIIllIlllIIIIl += lllllllllllllIlIIlIIIllIlllIIlIl;
                }
                lllllllllllllIlIIlIIIllIlllIIlII[lllllllllllllIlIIlIIIllIlllIIIIl] = lllllllllllllIlIIlIIIllIlllIlIlI[lllllllllllllIlIIlIIIllIlllIlllI];
                lllllllllllllIlIIlIIIllIlllIIIll[lllllllllllllIlIIlIIIllIlllIIIIl++] = lllllllllllllIlIIlIIIllIlllIlIIl[lllllllllllllIlIIlIIIllIlllIlllI];
            }
            lllllllllllllIlIIlIIIllIlllIIlII[lllllllllllllIlIIlIIIllIlllIIIlI] = this.varTag;
            lllllllllllllIlIIlIIIllIlllIIIll[lllllllllllllIlIIlIIIllIlllIIIlI] = this.varData;
            if (lllllllllllllIlIIlIIIllIlllIIlIl > 1) {
                lllllllllllllIlIIlIIIllIlllIIIll[lllllllllllllIlIIlIIIllIlllIIIlI + 1] = (lllllllllllllIlIIlIIIllIlllIIlII[lllllllllllllIlIIlIIIllIlllIIIlI + 1] = 0);
            }
            super.fullFrame(lllllllllllllIlIIlIIIllIllIlllll, lllllllllllllIlIIlIIIllIlllIlIll, lllllllllllllIlIIlIIIllIlllIIlII, lllllllllllllIlIIlIIIllIlllIIIll, lllllllllllllIlIIlIIIllIllIllIll, lllllllllllllIlIIlIIIllIlllIIlll);
        }
    }
    
    static class SwitchShifter extends Shifter
    {
        SwitchShifter(final StackMapTable lllllllllllllIIllIIIlIlllIIlIIll, final int lllllllllllllIIllIIIlIlllIIIlllI, final int lllllllllllllIIllIIIlIlllIIlIIIl) {
            super(lllllllllllllIIllIIIlIlllIIlIIll, lllllllllllllIIllIIIlIlllIIIlllI, lllllllllllllIIllIIIlIlllIIlIIIl, false);
        }
        
        @Override
        void update(final int lllllllllllllIIllIIIlIlllIIIIIIl, final int lllllllllllllIIllIIIlIllIllllIIl, final int lllllllllllllIIllIIIlIllIlllllll, final int lllllllllllllIIllIIIlIllIlllIlll) {
            final int lllllllllllllIIllIIIlIllIlllllIl = this.position;
            this.position = lllllllllllllIIllIIIlIllIlllllIl + lllllllllllllIIllIIIlIllIllllIIl + ((lllllllllllllIIllIIIlIllIlllllIl != 0) ? 1 : 0);
            int lllllllllllllIIllIIIlIllIlllllII = lllllllllllllIIllIIIlIllIllllIIl;
            if (this.where == this.position) {
                lllllllllllllIIllIIIlIllIlllllII = lllllllllllllIIllIIIlIllIllllIIl - this.gap;
            }
            else {
                if (this.where != lllllllllllllIIllIIIlIllIlllllIl) {
                    return;
                }
                lllllllllllllIIllIIIlIllIlllllII = lllllllllllllIIllIIIlIllIllllIIl + this.gap;
            }
            if (lllllllllllllIIllIIIlIllIllllIIl < 64) {
                if (lllllllllllllIIllIIIlIllIlllllII < 64) {
                    this.info[lllllllllllllIIllIIIlIlllIIIIIIl] = (byte)(lllllllllllllIIllIIIlIllIlllllII + lllllllllllllIIllIIIlIllIlllllll);
                }
                else {
                    final byte[] lllllllllllllIIllIIIlIlllIIIIlII = Shifter.insertGap(this.info, lllllllllllllIIllIIIlIlllIIIIIIl, 2);
                    lllllllllllllIIllIIIlIlllIIIIlII[lllllllllllllIIllIIIlIlllIIIIIIl] = (byte)lllllllllllllIIllIIIlIllIlllIlll;
                    ByteArray.write16bit(lllllllllllllIIllIIIlIllIlllllII, lllllllllllllIIllIIIlIlllIIIIlII, lllllllllllllIIllIIIlIlllIIIIIIl + 1);
                    this.updatedInfo = lllllllllllllIIllIIIlIlllIIIIlII;
                }
            }
            else if (lllllllllllllIIllIIIlIllIlllllII < 64) {
                final byte[] lllllllllllllIIllIIIlIlllIIIIIll = deleteGap(this.info, lllllllllllllIIllIIIlIlllIIIIIIl, 2);
                lllllllllllllIIllIIIlIlllIIIIIll[lllllllllllllIIllIIIlIlllIIIIIIl] = (byte)(lllllllllllllIIllIIIlIllIlllllII + lllllllllllllIIllIIIlIllIlllllll);
                this.updatedInfo = lllllllllllllIIllIIIlIlllIIIIIll;
            }
            else {
                ByteArray.write16bit(lllllllllllllIIllIIIlIllIlllllII, this.info, lllllllllllllIIllIIIlIlllIIIIIIl + 1);
            }
        }
        
        @Override
        void update(final int lllllllllllllIIllIIIlIllIlIllIll, final int lllllllllllllIIllIIIlIllIlIllIlI) {
            final int lllllllllllllIIllIIIlIllIlIllIIl = this.position;
            this.position = lllllllllllllIIllIIIlIllIlIllIIl + lllllllllllllIIllIIIlIllIlIllIlI + ((lllllllllllllIIllIIIlIllIlIllIIl != 0) ? 1 : 0);
            int lllllllllllllIIllIIIlIllIlIllIII = lllllllllllllIIllIIIlIllIlIllIlI;
            if (this.where == this.position) {
                lllllllllllllIIllIIIlIllIlIllIII = lllllllllllllIIllIIIlIllIlIllIlI - this.gap;
            }
            else {
                if (this.where != lllllllllllllIIllIIIlIllIlIllIIl) {
                    return;
                }
                lllllllllllllIIllIIIlIllIlIllIII = lllllllllllllIIllIIIlIllIlIllIlI + this.gap;
            }
            ByteArray.write16bit(lllllllllllllIIllIIIlIllIlIllIII, this.info, lllllllllllllIIllIIIlIllIlIllIll + 1);
        }
        
        static byte[] deleteGap(final byte[] lllllllllllllIIllIIIlIllIllIllII, int lllllllllllllIIllIIIlIllIllIIllI, final int lllllllllllllIIllIIIlIllIllIlIlI) {
            lllllllllllllIIllIIIlIllIllIIllI += lllllllllllllIIllIIIlIllIllIlIlI;
            final int lllllllllllllIIllIIIlIllIllIlIIl = lllllllllllllIIllIIIlIllIllIllII.length;
            final byte[] lllllllllllllIIllIIIlIllIllIlIII = new byte[lllllllllllllIIllIIIlIllIllIlIIl - lllllllllllllIIllIIIlIllIllIlIlI];
            for (int lllllllllllllIIllIIIlIllIllIllIl = 0; lllllllllllllIIllIIIlIllIllIllIl < lllllllllllllIIllIIIlIllIllIlIIl; ++lllllllllllllIIllIIIlIllIllIllIl) {
                lllllllllllllIIllIIIlIllIllIlIII[lllllllllllllIIllIIIlIllIllIllIl - ((lllllllllllllIIllIIIlIllIllIllIl < lllllllllllllIIllIIIlIllIllIIllI) ? 0 : lllllllllllllIIllIIIlIllIllIlIlI)] = lllllllllllllIIllIIIlIllIllIllII[lllllllllllllIIllIIIlIllIllIllIl];
            }
            return lllllllllllllIIllIIIlIllIllIlIII;
        }
    }
    
    static class Shifter extends Walker
    {
        /* synthetic */ boolean exclusive;
        /* synthetic */ byte[] updatedInfo;
        /* synthetic */ int gap;
        private /* synthetic */ StackMapTable stackMap;
        /* synthetic */ int position;
        /* synthetic */ int where;
        
        @Override
        public void appendFrame(final int llllllllllllIllllllIIlIIIlIlIIlI, final int llllllllllllIllllllIIlIIIlIlIllI, final int[] llllllllllllIllllllIIlIIIlIlIlIl, final int[] llllllllllllIllllllIIlIIIlIlIlII) {
            this.update(llllllllllllIllllllIIlIIIlIlIIlI, llllllllllllIllllllIIlIIIlIlIllI);
        }
        
        public void doit() throws BadBytecode {
            this.parse();
            if (this.updatedInfo != null) {
                this.stackMap.set(this.updatedInfo);
            }
        }
        
        @Override
        public void fullFrame(final int llllllllllllIllllllIIlIIIlIIllII, final int llllllllllllIllllllIIlIIIlIIlIll, final int[] llllllllllllIllllllIIlIIIlIIlIlI, final int[] llllllllllllIllllllIIlIIIlIIlIIl, final int[] llllllllllllIllllllIIlIIIlIIlIII, final int[] llllllllllllIllllllIIlIIIlIIIlll) {
            this.update(llllllllllllIllllllIIlIIIlIIllII, llllllllllllIllllllIIlIIIlIIlIll);
        }
        
        static byte[] insertGap(final byte[] llllllllllllIllllllIIlIIIllIlIll, final int llllllllllllIllllllIIlIIIllIlIlI, final int llllllllllllIllllllIIlIIIllIlllI) {
            final int llllllllllllIllllllIIlIIIllIllIl = llllllllllllIllllllIIlIIIllIlIll.length;
            final byte[] llllllllllllIllllllIIlIIIllIllII = new byte[llllllllllllIllllllIIlIIIllIllIl + llllllllllllIllllllIIlIIIllIlllI];
            for (int llllllllllllIllllllIIlIIIlllIIIl = 0; llllllllllllIllllllIIlIIIlllIIIl < llllllllllllIllllllIIlIIIllIllIl; ++llllllllllllIllllllIIlIIIlllIIIl) {
                llllllllllllIllllllIIlIIIllIllII[llllllllllllIllllllIIlIIIlllIIIl + ((llllllllllllIllllllIIlIIIlllIIIl < llllllllllllIllllllIIlIIIllIlIlI) ? 0 : llllllllllllIllllllIIlIIIllIlllI)] = llllllllllllIllllllIIlIIIllIlIll[llllllllllllIllllllIIlIIIlllIIIl];
            }
            return llllllllllllIllllllIIlIIIllIllII;
        }
        
        public Shifter(final int llllllllllllIllllllIIlIIlIllIlIl, final int llllllllllllIllllllIIlIIlIlIllll, final boolean llllllllllllIllllllIIlIIlIlIlllI) {
            super(StackMapTable.this);
            this.where = llllllllllllIllllllIIlIIlIllIlIl;
            this.gap = llllllllllllIllllllIIlIIlIlIllll;
            this.position = 0;
            this.updatedInfo = null;
            this.exclusive = llllllllllllIllllllIIlIIlIlIlllI;
        }
        
        @Override
        public void sameLocals(final int llllllllllllIllllllIIlIIlIIllIII, final int llllllllllllIllllllIIlIIlIIlllII, final int llllllllllllIllllllIIlIIlIIllIll, final int llllllllllllIllllllIIlIIlIIllIlI) {
            this.update(llllllllllllIllllllIIlIIlIIllIII, llllllllllllIllllllIIlIIlIIlllII, 64, 247);
        }
        
        @Override
        public void chopFrame(final int llllllllllllIllllllIIlIIIllIIIIl, final int llllllllllllIllllllIIlIIIlIlllII, final int llllllllllllIllllllIIlIIIlIlllll) {
            this.update(llllllllllllIllllllIIlIIIllIIIIl, llllllllllllIllllllIIlIIIlIlllII);
        }
        
        @Override
        public void sameFrame(final int llllllllllllIllllllIIlIIlIlIIllI, final int llllllllllllIllllllIIlIIlIlIIIlI) {
            this.update(llllllllllllIllllllIIlIIlIlIIllI, llllllllllllIllllllIIlIIlIlIIIlI, 0, 251);
        }
        
        void update(final int llllllllllllIllllllIIlIIIIlllIlI, final int llllllllllllIllllllIIlIIIIlllIIl) {
            final int llllllllllllIllllllIIlIIIIlllIII = this.position;
            this.position = llllllllllllIllllllIIlIIIIlllIII + llllllllllllIllllllIIlIIIIlllIIl + ((llllllllllllIllllllIIlIIIIlllIII != 0) ? 1 : 0);
            boolean llllllllllllIllllllIIlIIIIllIlll = false;
            if (this.exclusive) {
                final boolean llllllllllllIllllllIIlIIIIllllIl = (llllllllllllIllllllIIlIIIIlllIII == 0 && this.where == 0) || (llllllllllllIllllllIIlIIIIlllIII < this.where && this.where <= this.position);
            }
            else {
                llllllllllllIllllllIIlIIIIllIlll = (llllllllllllIllllllIIlIIIIlllIII <= this.where && this.where < this.position);
            }
            if (llllllllllllIllllllIIlIIIIllIlll) {
                final int llllllllllllIllllllIIlIIIIllllII = llllllllllllIllllllIIlIIIIlllIIl + this.gap;
                ByteArray.write16bit(llllllllllllIllllllIIlIIIIllllII, this.info, llllllllllllIllllllIIlIIIIlllIlI + 1);
                this.position += this.gap;
            }
        }
        
        void update(final int llllllllllllIllllllIIlIIlIIIIlll, final int llllllllllllIllllllIIlIIlIIIIllI, final int llllllllllllIllllllIIlIIIllllllI, final int llllllllllllIllllllIIlIIlIIIIlII) {
            final int llllllllllllIllllllIIlIIlIIIIIll = this.position;
            this.position = llllllllllllIllllllIIlIIlIIIIIll + llllllllllllIllllllIIlIIlIIIIllI + ((llllllllllllIllllllIIlIIlIIIIIll != 0) ? 1 : 0);
            boolean llllllllllllIllllllIIlIIlIIIIIlI = false;
            if (this.exclusive) {
                final boolean llllllllllllIllllllIIlIIlIIIllII = (llllllllllllIllllllIIlIIlIIIIIll == 0 && this.where == 0) || (llllllllllllIllllllIIlIIlIIIIIll < this.where && this.where <= this.position);
            }
            else {
                llllllllllllIllllllIIlIIlIIIIIlI = (llllllllllllIllllllIIlIIlIIIIIll <= this.where && this.where < this.position);
            }
            if (llllllllllllIllllllIIlIIlIIIIIlI) {
                final int llllllllllllIllllllIIlIIlIIIlIlI = this.info[llllllllllllIllllllIIlIIlIIIIlll] & 0xFF;
                final int llllllllllllIllllllIIlIIlIIIlIIl = llllllllllllIllllllIIlIIlIIIIllI + this.gap;
                this.position += this.gap;
                if (llllllllllllIllllllIIlIIlIIIlIIl < 64) {
                    this.info[llllllllllllIllllllIIlIIlIIIIlll] = (byte)(llllllllllllIllllllIIlIIlIIIlIIl + llllllllllllIllllllIIlIIIllllllI);
                }
                else if (llllllllllllIllllllIIlIIlIIIIllI < 64 && llllllllllllIllllllIIlIIlIIIlIlI != llllllllllllIllllllIIlIIlIIIIlII) {
                    final byte[] llllllllllllIllllllIIlIIlIIIlIll = insertGap(this.info, llllllllllllIllllllIIlIIlIIIIlll, 2);
                    llllllllllllIllllllIIlIIlIIIlIll[llllllllllllIllllllIIlIIlIIIIlll] = (byte)llllllllllllIllllllIIlIIlIIIIlII;
                    ByteArray.write16bit(llllllllllllIllllllIIlIIlIIIlIIl, llllllllllllIllllllIIlIIlIIIlIll, llllllllllllIllllllIIlIIlIIIIlll + 1);
                    this.updatedInfo = llllllllllllIllllllIIlIIlIIIlIll;
                }
                else {
                    ByteArray.write16bit(llllllllllllIllllllIIlIIlIIIlIIl, this.info, llllllllllllIllllllIIlIIlIIIIlll + 1);
                }
            }
        }
    }
    
    static class Printer extends Walker
    {
        private /* synthetic */ int offset;
        private /* synthetic */ PrintWriter writer;
        
        @Override
        public void chopFrame(final int lllllllllllllllIIlllIllllIlIlIlI, final int lllllllllllllllIIlllIllllIlIlIIl, final int lllllllllllllllIIlllIllllIlIIlll) {
            this.offset += lllllllllllllllIIlllIllllIlIlIIl + 1;
            this.writer.println(String.valueOf(new StringBuilder().append(this.offset).append(" chop frame: ").append(lllllllllllllllIIlllIllllIlIlIIl).append(",    ").append(lllllllllllllllIIlllIllllIlIIlll).append(" last locals")));
        }
        
        @Override
        public void sameLocals(final int lllllllllllllllIIlllIllllIllIllI, final int lllllllllllllllIIlllIllllIllIIIl, final int lllllllllllllllIIlllIllllIllIIII, final int lllllllllllllllIIlllIllllIlIllll) {
            this.offset += lllllllllllllllIIlllIllllIllIIIl + 1;
            this.writer.println(String.valueOf(new StringBuilder().append(this.offset).append(" same locals: ").append(lllllllllllllllIIlllIllllIllIIIl)));
            this.printTypeInfo(lllllllllllllllIIlllIllllIllIIII, lllllllllllllllIIlllIllllIlIllll);
        }
        
        Printer(final byte[] lllllllllllllllIIlllIlllllIlIlII, final PrintWriter lllllllllllllllIIlllIlllllIlIIlI) {
            super(lllllllllllllllIIlllIlllllIlIlII);
            this.writer = lllllllllllllllIIlllIlllllIlIIlI;
            this.offset = -1;
        }
        
        @Override
        public void appendFrame(final int lllllllllllllllIIlllIllllIIIlIIl, final int lllllllllllllllIIlllIllllIIIIlll, final int[] lllllllllllllllIIlllIlllIllllllI, final int[] lllllllllllllllIIlllIllllIIIIlII) {
            this.offset += lllllllllllllllIIlllIllllIIIIlll + 1;
            this.writer.println(String.valueOf(new StringBuilder().append(this.offset).append(" append frame: ").append(lllllllllllllllIIlllIllllIIIIlll)));
            for (int lllllllllllllllIIlllIllllIIIllIl = 0; lllllllllllllllIIlllIllllIIIllIl < lllllllllllllllIIlllIlllIllllllI.length; ++lllllllllllllllIIlllIllllIIIllIl) {
                this.printTypeInfo(lllllllllllllllIIlllIlllIllllllI[lllllllllllllllIIlllIllllIIIllIl], lllllllllllllllIIlllIllllIIIIlII[lllllllllllllllIIlllIllllIIIllIl]);
            }
        }
        
        public static void print(final StackMapTable lllllllllllllllIIlllIlllllIlllIl, final PrintWriter lllllllllllllllIIlllIlllllIlllII) {
            try {
                new Printer(lllllllllllllllIIlllIlllllIlllIl.get(), lllllllllllllllIIlllIlllllIlllII).parse();
            }
            catch (BadBytecode lllllllllllllllIIlllIllllllIIIII) {
                lllllllllllllllIIlllIlllllIlllII.println(lllllllllllllllIIlllIllllllIIIII.getMessage());
            }
        }
        
        private void printTypeInfo(final int lllllllllllllllIIlllIlllIlIIIIIl, final int lllllllllllllllIIlllIlllIIllllll) {
            String lllllllllllllllIIlllIlllIIllllIl = null;
            switch (lllllllllllllllIIlllIlllIlIIIIIl) {
                case 0: {
                    lllllllllllllllIIlllIlllIIllllIl = "top";
                    break;
                }
                case 1: {
                    lllllllllllllllIIlllIlllIIllllIl = "integer";
                    break;
                }
                case 2: {
                    lllllllllllllllIIlllIlllIIllllIl = "float";
                    break;
                }
                case 3: {
                    lllllllllllllllIIlllIlllIIllllIl = "double";
                    break;
                }
                case 4: {
                    lllllllllllllllIIlllIlllIIllllIl = "long";
                    break;
                }
                case 5: {
                    lllllllllllllllIIlllIlllIIllllIl = "null";
                    break;
                }
                case 6: {
                    lllllllllllllllIIlllIlllIIllllIl = "this";
                    break;
                }
                case 7: {
                    lllllllllllllllIIlllIlllIIllllIl = String.valueOf(new StringBuilder().append("object (cpool_index ").append(lllllllllllllllIIlllIlllIIllllll).append(")"));
                    break;
                }
                case 8: {
                    lllllllllllllllIIlllIlllIIllllIl = String.valueOf(new StringBuilder().append("uninitialized (offset ").append(lllllllllllllllIIlllIlllIIllllll).append(")"));
                    break;
                }
            }
            this.writer.print("    ");
            this.writer.println(lllllllllllllllIIlllIlllIIllllIl);
        }
        
        @Override
        public void fullFrame(final int lllllllllllllllIIlllIlllIllIlIIl, final int lllllllllllllllIIlllIlllIllIlIII, final int[] lllllllllllllllIIlllIlllIllIIIIl, final int[] lllllllllllllllIIlllIlllIllIIIII, final int[] lllllllllllllllIIlllIlllIllIIlIl, final int[] lllllllllllllllIIlllIlllIllIIlII) {
            this.offset += lllllllllllllllIIlllIlllIllIlIII + 1;
            this.writer.println(String.valueOf(new StringBuilder().append(this.offset).append(" full frame: ").append(lllllllllllllllIIlllIlllIllIlIII)));
            this.writer.println("[locals]");
            for (int lllllllllllllllIIlllIlllIllIllII = 0; lllllllllllllllIIlllIlllIllIllII < lllllllllllllllIIlllIlllIllIIIIl.length; ++lllllllllllllllIIlllIlllIllIllII) {
                this.printTypeInfo(lllllllllllllllIIlllIlllIllIIIIl[lllllllllllllllIIlllIlllIllIllII], lllllllllllllllIIlllIlllIllIIIII[lllllllllllllllIIlllIlllIllIllII]);
            }
            this.writer.println("[stack]");
            for (int lllllllllllllllIIlllIlllIllIlIll = 0; lllllllllllllllIIlllIlllIllIlIll < lllllllllllllllIIlllIlllIllIIlIl.length; ++lllllllllllllllIIlllIlllIllIlIll) {
                this.printTypeInfo(lllllllllllllllIIlllIlllIllIIlIl[lllllllllllllllIIlllIlllIllIlIll], lllllllllllllllIIlllIlllIllIIlII[lllllllllllllllIIlllIlllIllIlIll]);
            }
        }
        
        @Override
        public void sameFrame(final int lllllllllllllllIIlllIlllllIIIIIl, final int lllllllllllllllIIlllIllllIllllll) {
            this.offset += lllllllllllllllIIlllIllllIllllll + 1;
            this.writer.println(String.valueOf(new StringBuilder().append(this.offset).append(" same frame: ").append(lllllllllllllllIIlllIllllIllllll)));
        }
    }
    
    static class NewRemover extends SimpleCopy
    {
        /* synthetic */ int posOfNew;
        
        public NewRemover(final byte[] llllllllllllllIlIIllllIIlllIIlIl, final int llllllllllllllIlIIllllIIlllIIlII) {
            super(llllllllllllllIlIIllllIIlllIIlIl);
            this.posOfNew = llllllllllllllIlIIllllIIlllIIlII;
        }
        
        @Override
        public void fullFrame(final int llllllllllllllIlIIllllIIlIlllllI, final int llllllllllllllIlIIllllIIlIllllIl, final int[] llllllllllllllIlIIllllIIlIllIlII, final int[] llllllllllllllIlIIllllIIlIllIIll, int[] llllllllllllllIlIIllllIIlIllIIlI, int[] llllllllllllllIlIIllllIIlIllIIIl) {
            for (int llllllllllllllIlIIllllIIlIlllIII = llllllllllllllIlIIllllIIlIllIIlI.length - 1, llllllllllllllIlIIllllIIllIIIIII = 0; llllllllllllllIlIIllllIIllIIIIII < llllllllllllllIlIIllllIIlIlllIII; ++llllllllllllllIlIIllllIIllIIIIII) {
                if (llllllllllllllIlIIllllIIlIllIIlI[llllllllllllllIlIIllllIIllIIIIII] == 8 && llllllllllllllIlIIllllIIlIllIIIl[llllllllllllllIlIIllllIIllIIIIII] == this.posOfNew && llllllllllllllIlIIllllIIlIllIIlI[llllllllllllllIlIIllllIIllIIIIII + 1] == 8 && llllllllllllllIlIIllllIIlIllIIIl[llllllllllllllIlIIllllIIllIIIIII + 1] == this.posOfNew) {
                    final int[] llllllllllllllIlIIllllIIllIIIIll = new int[++llllllllllllllIlIIllllIIlIlllIII - 2];
                    final int[] llllllllllllllIlIIllllIIllIIIIlI = new int[llllllllllllllIlIIllllIIlIlllIII - 2];
                    int llllllllllllllIlIIllllIIllIIIIIl = 0;
                    for (int llllllllllllllIlIIllllIIllIIIlII = 0; llllllllllllllIlIIllllIIllIIIlII < llllllllllllllIlIIllllIIlIlllIII; ++llllllllllllllIlIIllllIIllIIIlII) {
                        if (llllllllllllllIlIIllllIIllIIIlII == llllllllllllllIlIIllllIIllIIIIII) {
                            ++llllllllllllllIlIIllllIIllIIIlII;
                        }
                        else {
                            llllllllllllllIlIIllllIIllIIIIll[llllllllllllllIlIIllllIIllIIIIIl] = llllllllllllllIlIIllllIIlIllIIlI[llllllllllllllIlIIllllIIllIIIlII];
                            llllllllllllllIlIIllllIIllIIIIlI[llllllllllllllIlIIllllIIllIIIIIl++] = llllllllllllllIlIIllllIIlIllIIIl[llllllllllllllIlIIllllIIllIIIlII];
                        }
                    }
                    llllllllllllllIlIIllllIIlIllIIlI = llllllllllllllIlIIllllIIllIIIIll;
                    llllllllllllllIlIIllllIIlIllIIIl = llllllllllllllIlIIllllIIllIIIIlI;
                    break;
                }
            }
            super.fullFrame(llllllllllllllIlIIllllIIlIlllllI, llllllllllllllIlIIllllIIlIllllIl, llllllllllllllIlIIllllIIlIllIlII, llllllllllllllIlIIllllIIlIllIIll, (int[])llllllllllllllIlIIllllIIlIllIIlI, (int[])llllllllllllllIlIIllllIIlIllIIIl);
        }
        
        @Override
        public void sameLocals(final int llllllllllllllIlIIllllIIllIlIlIl, final int llllllllllllllIlIIllllIIllIlIlII, final int llllllllllllllIlIIllllIIllIllIII, final int llllllllllllllIlIIllllIIllIlIlll) {
            if (llllllllllllllIlIIllllIIllIllIII == 8 && llllllllllllllIlIIllllIIllIlIlll == this.posOfNew) {
                super.sameFrame(llllllllllllllIlIIllllIIllIlIlIl, llllllllllllllIlIIllllIIllIlIlII);
            }
            else {
                super.sameLocals(llllllllllllllIlIIllllIIllIlIlIl, llllllllllllllIlIIllllIIllIlIlII, llllllllllllllIlIIllllIIllIllIII, llllllllllllllIlIIllllIIllIlIlll);
            }
        }
    }
    
    static class Copier extends SimpleCopy
    {
        private /* synthetic */ Map<String, String> classnames;
        private /* synthetic */ ConstPool destPool;
        private /* synthetic */ ConstPool srcPool;
        
        @Override
        protected int copyData(final int lllllllllllllIlllIIllIIIIIIIlIII, final int lllllllllllllIlllIIllIIIIIIIlIlI) {
            if (lllllllllllllIlllIIllIIIIIIIlIII == 7) {
                return this.srcPool.copy(lllllllllllllIlllIIllIIIIIIIlIlI, this.destPool, this.classnames);
            }
            return lllllllllllllIlllIIllIIIIIIIlIlI;
        }
        
        public Copier(final ConstPool lllllllllllllIlllIIllIIIIIIlIIll, final byte[] lllllllllllllIlllIIllIIIIIIlIlll, final ConstPool lllllllllllllIlllIIllIIIIIIlIIIl, final Map<String, String> lllllllllllllIlllIIllIIIIIIlIlIl) {
            super(lllllllllllllIlllIIllIIIIIIlIlll);
            this.srcPool = lllllllllllllIlllIIllIIIIIIlIIll;
            this.destPool = lllllllllllllIlllIIllIIIIIIlIIIl;
            this.classnames = lllllllllllllIlllIIllIIIIIIlIlIl;
        }
        
        @Override
        protected int[] copyData(final int[] lllllllllllllIlllIIlIlllllllllll, final int[] lllllllllllllIlllIIlIllllllllIlI) {
            final int[] lllllllllllllIlllIIlIlllllllllIl = new int[lllllllllllllIlllIIlIllllllllIlI.length];
            for (int lllllllllllllIlllIIllIIIIIIIIIIl = 0; lllllllllllllIlllIIllIIIIIIIIIIl < lllllllllllllIlllIIlIllllllllIlI.length; ++lllllllllllllIlllIIllIIIIIIIIIIl) {
                if (lllllllllllllIlllIIlIlllllllllll[lllllllllllllIlllIIllIIIIIIIIIIl] == 7) {
                    lllllllllllllIlllIIlIlllllllllIl[lllllllllllllIlllIIllIIIIIIIIIIl] = this.srcPool.copy(lllllllllllllIlllIIlIllllllllIlI[lllllllllllllIlllIIllIIIIIIIIIIl], this.destPool, this.classnames);
                }
                else {
                    lllllllllllllIlllIIlIlllllllllIl[lllllllllllllIlllIIllIIIIIIIIIIl] = lllllllllllllIlllIIlIllllllllIlI[lllllllllllllIlllIIllIIIIIIIIIIl];
                }
            }
            return lllllllllllllIlllIIlIlllllllllIl;
        }
    }
}
