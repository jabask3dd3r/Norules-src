package com.viaversion.viaversion.libs.javassist.bytecode;

import java.util.*;

public class CodeIterator implements Opcode
{
    protected /* synthetic */ int mark;
    protected /* synthetic */ int currentPos;
    protected /* synthetic */ int mark2;
    protected /* synthetic */ CodeAttribute codeAttr;
    protected /* synthetic */ int endPos;
    protected /* synthetic */ byte[] bytecode;
    
    public int getMark2() {
        return this.mark2;
    }
    
    private static void addLdcW(final CodeAttribute.LdcEntry lllIIllIllIIIl, final List<Branch> lllIIllIllIIII) {
        final int lllIIllIllIlII = lllIIllIllIIIl.where;
        final LdcW lllIIllIllIIll = new LdcW(lllIIllIllIlII, lllIIllIllIIIl.index);
        for (int lllIIllIllIIlI = lllIIllIllIIII.size(), lllIIllIllIlll = 0; lllIIllIllIlll < lllIIllIllIIlI; ++lllIIllIllIlll) {
            if (lllIIllIllIlII < lllIIllIllIIII.get(lllIIllIllIlll).orgPos) {
                lllIIllIllIIII.add(lllIIllIllIlll, lllIIllIllIIll);
                return;
            }
        }
        lllIIllIllIIII.add(lllIIllIllIIll);
    }
    
    public int insertEx(final byte[] lllIllIIIllllI) throws BadBytecode {
        return this.insert0(this.currentPos, lllIllIIIllllI, true);
    }
    
    public void insert(final ExceptionTable lllIlIlIllIlII, final int lllIlIlIllIIll) {
        this.codeAttr.getExceptionTable().add(0, lllIlIlIllIlII, lllIlIlIllIIll);
    }
    
    public int skipThisConstructor() throws BadBytecode {
        return this.skipSuperConstructor0(1);
    }
    
    public int s16bitAt(final int lllIlllIlllIlI) {
        return ByteArray.readS16bit(this.bytecode, lllIlllIlllIlI);
    }
    
    static {
        opcodeLength = new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 3, 2, 3, 3, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 0, 0, 1, 1, 1, 1, 1, 1, 3, 3, 3, 3, 3, 3, 3, 5, 5, 3, 2, 3, 1, 1, 3, 3, 1, 1, 0, 4, 3, 3, 5, 5 };
    }
    
    public void appendGap(final int lllIlIlIIlIIll) {
        final byte[] lllIlIlIIllIII = this.bytecode;
        final int lllIlIlIIlIlll = lllIlIlIIllIII.length;
        final byte[] lllIlIlIIlIllI = new byte[lllIlIlIIlIlll + lllIlIlIIlIIll];
        for (int lllIlIlIIlIlIl = 0; lllIlIlIIlIlIl < lllIlIlIIlIlll; ++lllIlIlIIlIlIl) {
            lllIlIlIIlIllI[lllIlIlIIlIlIl] = lllIlIlIIllIII[lllIlIlIIlIlIl];
        }
        for (int lllIlIlIIlIlIl = lllIlIlIIlIlll; lllIlIlIIlIlIl < lllIlIlIIlIlll + lllIlIlIIlIIll; ++lllIlIlIIlIlIl) {
            lllIlIlIIlIllI[lllIlIlIIlIlIl] = 0;
        }
        this.codeAttr.setCode(lllIlIlIIlIllI);
        this.bytecode = lllIlIlIIlIllI;
        this.endPos = this.getCodeLength();
    }
    
    public void begin() {
        final int currentPos = 0;
        this.mark2 = currentPos;
        this.mark = currentPos;
        this.currentPos = currentPos;
        this.endPos = this.getCodeLength();
    }
    
    public int getCodeLength() {
        return this.bytecode.length;
    }
    
    public int next() throws BadBytecode {
        final int lllIllIllIIlIl = this.currentPos;
        this.currentPos = nextOpcode(this.bytecode, lllIllIllIIlIl);
        return lllIllIllIIlIl;
    }
    
    public int getMark() {
        return this.mark;
    }
    
    private static int copyGapBytes(final byte[] lllIIllllIlllI, int lllIIllllIlIII, final byte[] lllIIllllIllII, int lllIIllllIlIll, final int lllIIllllIlIlI) {
        switch (lllIIllllIlIlI - lllIIllllIlIll) {
            case 4: {
                lllIIllllIlllI[lllIIllllIlIII++] = lllIIllllIllII[lllIIllllIlIll++];
            }
            case 3: {
                lllIIllllIlllI[lllIIllllIlIII++] = lllIIllllIllII[lllIIllllIlIll++];
            }
            case 2: {
                lllIIllllIlllI[lllIIllllIlIII++] = lllIIllllIllII[lllIIllllIlIll++];
            }
            case 1: {
                lllIIllllIlllI[lllIIllllIlIII++] = lllIIllllIllII[lllIIllllIlIll++];
                break;
            }
        }
        return lllIIllllIlIII;
    }
    
    public int byteAt(final int lllIlllllIIlll) {
        return this.bytecode[lllIlllllIIlll] & 0xFF;
    }
    
    private static byte[] insertGap2w(final byte[] lllIIlIlllIIIl, final int lllIIlIlllIIII, final int lllIIlIllIlIII, final boolean lllIIlIllIlllI, final List<Branch> lllIIlIllIIllI, final Pointers lllIIlIllIIlIl) throws BadBytecode {
        if (lllIIlIllIlIII > 0) {
            lllIIlIllIIlIl.shiftPc(lllIIlIlllIIII, lllIIlIllIlIII, lllIIlIllIlllI);
            for (final Branch lllIIlIllllIlI : lllIIlIllIIllI) {
                lllIIlIllllIlI.shift(lllIIlIlllIIII, lllIIlIllIlIII, lllIIlIllIlllI);
            }
        }
        boolean lllIIlIllIlIll = true;
        while (true) {
            if (lllIIlIllIlIll) {
                lllIIlIllIlIll = false;
                for (final Branch lllIIlIlllIllI : lllIIlIllIIllI) {
                    if (lllIIlIlllIllI.expanded()) {
                        lllIIlIllIlIll = true;
                        final int lllIIlIllllIII = lllIIlIlllIllI.pos;
                        final int lllIIlIlllIlll = lllIIlIlllIllI.deltaSize();
                        lllIIlIllIIlIl.shiftPc(lllIIlIllllIII, lllIIlIlllIlll, false);
                        for (final Branch lllIIlIllllIIl : lllIIlIllIIllI) {
                            lllIIlIllllIIl.shift(lllIIlIllllIII, lllIIlIlllIlll, false);
                        }
                    }
                }
            }
            else {
                for (final Branch lllIIlIlllIIlI : lllIIlIllIIllI) {
                    final int lllIIlIlllIIll = lllIIlIlllIIlI.gapChanged();
                    if (lllIIlIlllIIll > 0) {
                        lllIIlIllIlIll = true;
                        final int lllIIlIlllIlII = lllIIlIlllIIlI.pos;
                        lllIIlIllIIlIl.shiftPc(lllIIlIlllIlII, lllIIlIlllIIll, false);
                        for (final Branch lllIIlIlllIlIl : lllIIlIllIIllI) {
                            lllIIlIlllIlIl.shift(lllIIlIlllIlII, lllIIlIlllIIll, false);
                        }
                    }
                }
                if (!lllIIlIllIlIll) {
                    break;
                }
                continue;
            }
        }
        return makeExapndedCode(lllIIlIlllIIIl, lllIIlIllIIllI, lllIIlIlllIIII, lllIIlIllIlIII);
    }
    
    public void append(final ExceptionTable lllIlIlIIIIlIl, final int lllIlIlIIIlIII) {
        final ExceptionTable lllIlIlIIIIlll = this.codeAttr.getExceptionTable();
        lllIlIlIIIIlll.add(lllIlIlIIIIlll.size(), lllIlIlIIIIlIl, lllIlIlIIIlIII);
    }
    
    public void setMark2(final int llllIIIIIlIIIl) {
        this.mark2 = llllIIIIIlIIIl;
    }
    
    static int nextOpcode(final byte[] lllIlIIlllIIIl, final int lllIlIIlllIIll) throws BadBytecode {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: iload_1         /* lllIlIIlllIIII */
        //     2: baload         
        //     3: sipush          255
        //     6: iand           
        //     7: istore_2        /* lllIlIIllllIll */
        //     8: goto            23
        //    11: astore_3        /* lllIlIIllllIlI */
        //    12: new             Lcom/viaversion/viaversion/libs/javassist/bytecode/BadBytecode;
        //    15: dup            
        //    16: ldc_w           "invalid opcode address"
        //    19: invokespecial   com/viaversion/viaversion/libs/javassist/bytecode/BadBytecode.<init>:(Ljava/lang/String;)V
        //    22: athrow         
        //    23: getstatic       com/viaversion/viaversion/libs/javassist/bytecode/CodeIterator.opcodeLength:[I
        //    26: iload_2         /* lllIlIIlllIIlI */
        //    27: iaload         
        //    28: istore_3        /* lllIlIIlllIllI */
        //    29: iload_3         /* lllIlIIlllIllI */
        //    30: ifle            37
        //    33: iload_1         /* lllIlIIlllIIII */
        //    34: iload_3         /* lllIlIIlllIllI */
        //    35: iadd           
        //    36: ireturn        
        //    37: iload_2         /* lllIlIIlllIIlI */
        //    38: sipush          196
        //    41: if_icmpne       63
        //    44: aload_0         /* lllIlIIlllIlII */
        //    45: iload_1         /* lllIlIIlllIIII */
        //    46: iconst_1       
        //    47: iadd           
        //    48: baload         
        //    49: bipush          -124
        //    51: if_icmpne       59
        //    54: iload_1         /* lllIlIIlllIIII */
        //    55: bipush          6
        //    57: iadd           
        //    58: ireturn        
        //    59: iload_1         /* lllIlIIlllIIII */
        //    60: iconst_4       
        //    61: iadd           
        //    62: ireturn        
        //    63: iload_1         /* lllIlIIlllIIII */
        //    64: bipush          -4
        //    66: iand           
        //    67: bipush          8
        //    69: iadd           
        //    70: istore          lllIlIIlllIlIl
        //    72: iload_2         /* lllIlIIlllIIlI */
        //    73: sipush          171
        //    76: if_icmpne       98
        //    79: aload_0         /* lllIlIIlllIlII */
        //    80: iload           lllIlIIlllIlIl
        //    82: invokestatic    com/viaversion/viaversion/libs/javassist/bytecode/ByteArray.read32bit:([BI)I
        //    85: istore          lllIlIIllllIIl
        //    87: iload           lllIlIIlllIlIl
        //    89: iload           lllIlIIllllIIl
        //    91: bipush          8
        //    93: imul           
        //    94: iadd           
        //    95: iconst_4       
        //    96: iadd           
        //    97: ireturn        
        //    98: iload_2         /* lllIlIIlllIIlI */
        //    99: sipush          170
        //   102: if_icmpne       139
        //   105: aload_0         /* lllIlIIlllIlII */
        //   106: iload           lllIlIIlllIlIl
        //   108: invokestatic    com/viaversion/viaversion/libs/javassist/bytecode/ByteArray.read32bit:([BI)I
        //   111: istore          lllIlIIllllIII
        //   113: aload_0         /* lllIlIIlllIlII */
        //   114: iload           lllIlIIlllIlIl
        //   116: iconst_4       
        //   117: iadd           
        //   118: invokestatic    com/viaversion/viaversion/libs/javassist/bytecode/ByteArray.read32bit:([BI)I
        //   121: istore          lllIlIIlllIlll
        //   123: iload           lllIlIIlllIlIl
        //   125: iload           lllIlIIlllIlll
        //   127: iload           lllIlIIllllIII
        //   129: isub           
        //   130: iconst_1       
        //   131: iadd           
        //   132: iconst_4       
        //   133: imul           
        //   134: iadd           
        //   135: bipush          8
        //   137: iadd           
        //   138: ireturn        
        //   139: goto            143
        //   142: astore_3       
        //   143: new             Lcom/viaversion/viaversion/libs/javassist/bytecode/BadBytecode;
        //   146: dup            
        //   147: iload_2         /* lllIlIIlllIIlI */
        //   148: invokespecial   com/viaversion/viaversion/libs/javassist/bytecode/BadBytecode.<init>:(I)V
        //   151: athrow         
        //    Exceptions:
        //  throws com.viaversion.viaversion.libs.javassist.bytecode.BadBytecode
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                 
        //  -----  -----  -----  -----  -------------------------------------
        //  0      8      11     23     Ljava/lang/IndexOutOfBoundsException;
        //  23     36     142    143    Ljava/lang/IndexOutOfBoundsException;
        //  37     58     142    143    Ljava/lang/IndexOutOfBoundsException;
        //  59     62     142    143    Ljava/lang/IndexOutOfBoundsException;
        //  63     97     142    143    Ljava/lang/IndexOutOfBoundsException;
        //  98     138    142    143    Ljava/lang/IndexOutOfBoundsException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public int skipConstructor() throws BadBytecode {
        return this.skipSuperConstructor0(-1);
    }
    
    public Gap insertGapAt(int lllIlIllIIIlIl, final int lllIlIllIIlIll, final boolean lllIlIllIIlIlI) throws BadBytecode {
        final Gap lllIlIllIIlIIl = new Gap();
        if (lllIlIllIIlIll <= 0) {
            lllIlIllIIlIIl.position = lllIlIllIIIlIl;
            lllIlIllIIlIIl.length = 0;
            return lllIlIllIIlIIl;
        }
        byte[] lllIlIllIIlIII = null;
        int lllIlIllIIIlll = 0;
        if (this.bytecode.length + lllIlIllIIlIll > 32767) {
            final byte[] lllIlIllIlIIII = this.insertGapCore0w(this.bytecode, lllIlIllIIIlIl, lllIlIllIIlIll, lllIlIllIIlIlI, this.get().getExceptionTable(), this.codeAttr, lllIlIllIIlIIl);
            lllIlIllIIIlIl = lllIlIllIIlIIl.position;
            final int lllIlIllIIllll = lllIlIllIIlIll;
        }
        else {
            final int lllIlIllIIlllI = this.currentPos;
            lllIlIllIIlIII = insertGapCore0(this.bytecode, lllIlIllIIIlIl, lllIlIllIIlIll, lllIlIllIIlIlI, this.get().getExceptionTable(), this.codeAttr);
            lllIlIllIIIlll = lllIlIllIIlIII.length - this.bytecode.length;
            lllIlIllIIlIIl.position = lllIlIllIIIlIl;
            lllIlIllIIlIIl.length = lllIlIllIIIlll;
            if (lllIlIllIIlllI >= lllIlIllIIIlIl) {
                this.currentPos = lllIlIllIIlllI + lllIlIllIIIlll;
            }
            if (this.mark > lllIlIllIIIlIl || (this.mark == lllIlIllIIIlIl && lllIlIllIIlIlI)) {
                this.mark += lllIlIllIIIlll;
            }
            if (this.mark2 > lllIlIllIIIlIl || (this.mark2 == lllIlIllIIIlIl && lllIlIllIIlIlI)) {
                this.mark2 += lllIlIllIIIlll;
            }
        }
        this.codeAttr.setCode(lllIlIllIIlIII);
        this.bytecode = lllIlIllIIlIII;
        this.endPos = this.getCodeLength();
        this.updateCursors(lllIlIllIIIlIl, lllIlIllIIIlll);
        return lllIlIllIIlIIl;
    }
    
    private static void insertGap2(final byte[] lllIlIIIIIIIll, final int lllIlIIIIIlIlI, final int lllIlIIIIIIIIl, final int lllIlIIIIIIIII, final byte[] lllIlIIIIIIlll, final boolean lllIIllllllllI) throws BadBytecode, AlignmentException {
        int lllIlIIIIIIlIl = 0;
        int lllIlIIIIIIlII = 0;
        while (lllIlIIIIIIlIl < lllIlIIIIIIIII) {
            if (lllIlIIIIIIlIl == lllIlIIIIIlIlI) {
                for (int lllIlIIIIllIll = lllIlIIIIIIlII + lllIlIIIIIIIIl; lllIlIIIIIIlII < lllIlIIIIllIll; lllIlIIIIIIlll[lllIlIIIIIIlII++] = 0) {}
            }
            final int lllIlIIIIIllII = nextOpcode(lllIlIIIIIIIll, lllIlIIIIIIlIl);
            final int lllIlIIIIIllIl = lllIlIIIIIIIll[lllIlIIIIIIlIl] & 0xFF;
            if ((153 <= lllIlIIIIIllIl && lllIlIIIIIllIl <= 168) || lllIlIIIIIllIl == 198 || lllIlIIIIIllIl == 199) {
                int lllIlIIIIllIlI = lllIlIIIIIIIll[lllIlIIIIIIlIl + 1] << 8 | (lllIlIIIIIIIll[lllIlIIIIIIlIl + 2] & 0xFF);
                lllIlIIIIllIlI = newOffset(lllIlIIIIIIlIl, lllIlIIIIllIlI, lllIlIIIIIlIlI, lllIlIIIIIIIIl, lllIIllllllllI);
                lllIlIIIIIIlll[lllIlIIIIIIlII] = lllIlIIIIIIIll[lllIlIIIIIIlIl];
                ByteArray.write16bit(lllIlIIIIllIlI, lllIlIIIIIIlll, lllIlIIIIIIlII + 1);
                lllIlIIIIIIlII += 3;
            }
            else if (lllIlIIIIIllIl == 200 || lllIlIIIIIllIl == 201) {
                int lllIlIIIIllIIl = ByteArray.read32bit(lllIlIIIIIIIll, lllIlIIIIIIlIl + 1);
                lllIlIIIIllIIl = newOffset(lllIlIIIIIIlIl, lllIlIIIIllIIl, lllIlIIIIIlIlI, lllIlIIIIIIIIl, lllIIllllllllI);
                lllIlIIIIIIlll[lllIlIIIIIIlII++] = lllIlIIIIIIIll[lllIlIIIIIIlIl];
                ByteArray.write32bit(lllIlIIIIllIIl, lllIlIIIIIIlll, lllIlIIIIIIlII);
                lllIlIIIIIIlII += 4;
            }
            else if (lllIlIIIIIllIl == 170) {
                if (lllIlIIIIIIlIl != lllIlIIIIIIlII && (lllIlIIIIIIIIl & 0x3) != 0x0) {
                    throw new AlignmentException();
                }
                int lllIlIIIIlIlll = (lllIlIIIIIIlIl & 0xFFFFFFFC) + 4;
                lllIlIIIIIIlII = copyGapBytes(lllIlIIIIIIlll, lllIlIIIIIIlII, lllIlIIIIIIIll, lllIlIIIIIIlIl, lllIlIIIIlIlll);
                final int lllIlIIIIlIllI = newOffset(lllIlIIIIIIlIl, ByteArray.read32bit(lllIlIIIIIIIll, lllIlIIIIlIlll), lllIlIIIIIlIlI, lllIlIIIIIIIIl, lllIIllllllllI);
                ByteArray.write32bit(lllIlIIIIlIllI, lllIlIIIIIIlll, lllIlIIIIIIlII);
                final int lllIlIIIIlIlIl = ByteArray.read32bit(lllIlIIIIIIIll, lllIlIIIIlIlll + 4);
                ByteArray.write32bit(lllIlIIIIlIlIl, lllIlIIIIIIlll, lllIlIIIIIIlII + 4);
                final int lllIlIIIIlIlII = ByteArray.read32bit(lllIlIIIIIIIll, lllIlIIIIlIlll + 8);
                ByteArray.write32bit(lllIlIIIIlIlII, lllIlIIIIIIlll, lllIlIIIIIIlII + 8);
                lllIlIIIIIIlII += 12;
                int lllIlIIIIlIIll;
                for (lllIlIIIIlIIll = lllIlIIIIlIlll + 12, lllIlIIIIlIlll = lllIlIIIIlIIll + (lllIlIIIIlIlII - lllIlIIIIlIlIl + 1) * 4; lllIlIIIIlIIll < lllIlIIIIlIlll; lllIlIIIIlIIll += 4) {
                    final int lllIlIIIIllIII = newOffset(lllIlIIIIIIlIl, ByteArray.read32bit(lllIlIIIIIIIll, lllIlIIIIlIIll), lllIlIIIIIlIlI, lllIlIIIIIIIIl, lllIIllllllllI);
                    ByteArray.write32bit(lllIlIIIIllIII, lllIlIIIIIIlll, lllIlIIIIIIlII);
                    lllIlIIIIIIlII += 4;
                }
            }
            else if (lllIlIIIIIllIl == 171) {
                if (lllIlIIIIIIlIl != lllIlIIIIIIlII && (lllIlIIIIIIIIl & 0x3) != 0x0) {
                    throw new AlignmentException();
                }
                int lllIlIIIIlIIIl = (lllIlIIIIIIlIl & 0xFFFFFFFC) + 4;
                lllIlIIIIIIlII = copyGapBytes(lllIlIIIIIIlll, lllIlIIIIIIlII, lllIlIIIIIIIll, lllIlIIIIIIlIl, lllIlIIIIlIIIl);
                final int lllIlIIIIlIIII = newOffset(lllIlIIIIIIlIl, ByteArray.read32bit(lllIlIIIIIIIll, lllIlIIIIlIIIl), lllIlIIIIIlIlI, lllIlIIIIIIIIl, lllIIllllllllI);
                ByteArray.write32bit(lllIlIIIIlIIII, lllIlIIIIIIlll, lllIlIIIIIIlII);
                final int lllIlIIIIIllll = ByteArray.read32bit(lllIlIIIIIIIll, lllIlIIIIlIIIl + 4);
                ByteArray.write32bit(lllIlIIIIIllll, lllIlIIIIIIlll, lllIlIIIIIIlII + 4);
                lllIlIIIIIIlII += 8;
                int lllIlIIIIIlllI;
                for (lllIlIIIIIlllI = lllIlIIIIlIIIl + 8, lllIlIIIIlIIIl = lllIlIIIIIlllI + lllIlIIIIIllll * 8; lllIlIIIIIlllI < lllIlIIIIlIIIl; lllIlIIIIIlllI += 8) {
                    ByteArray.copy32bit(lllIlIIIIIIIll, lllIlIIIIIlllI, lllIlIIIIIIlll, lllIlIIIIIIlII);
                    final int lllIlIIIIlIIlI = newOffset(lllIlIIIIIIlIl, ByteArray.read32bit(lllIlIIIIIIIll, lllIlIIIIIlllI + 4), lllIlIIIIIlIlI, lllIlIIIIIIIIl, lllIIllllllllI);
                    ByteArray.write32bit(lllIlIIIIlIIlI, lllIlIIIIIIlll, lllIlIIIIIIlII + 4);
                    lllIlIIIIIIlII += 8;
                }
            }
            else {
                while (lllIlIIIIIIlIl < lllIlIIIIIllII) {
                    lllIlIIIIIIlll[lllIlIIIIIIlII++] = lllIlIIIIIIIll[lllIlIIIIIIlIl++];
                }
            }
            lllIlIIIIIIlIl = lllIlIIIIIllII;
        }
    }
    
    public int insertExAt(final int lllIllIIIlIIII, final byte[] lllIllIIIIllll) throws BadBytecode {
        return this.insert0(lllIllIIIlIIII, lllIllIIIIllll, true);
    }
    
    public CodeAttribute get() {
        return this.codeAttr;
    }
    
    public int insert(final byte[] lllIllIIlllIII) throws BadBytecode {
        return this.insert0(this.currentPos, lllIllIIlllIII, false);
    }
    
    public void writeByte(final int lllIllllIllIIl, final int lllIllllIlIIlI) {
        this.bytecode[lllIllllIlIIlI] = (byte)lllIllllIllIIl;
    }
    
    protected void updateCursors(final int lllIlIlIllllIl, final int lllIlIlIllllII) {
    }
    
    public int u16bitAt(final int lllIllllIIIllI) {
        return ByteArray.readU16bit(this.bytecode, lllIllllIIIllI);
    }
    
    public int append(final byte[] lllIlIlIlIlIlI) {
        final int lllIlIlIlIlIIl = this.getCodeLength();
        final int lllIlIlIlIlIII = lllIlIlIlIlIlI.length;
        if (lllIlIlIlIlIII <= 0) {
            return lllIlIlIlIlIIl;
        }
        this.appendGap(lllIlIlIlIlIII);
        final byte[] lllIlIlIlIIlll = this.bytecode;
        for (int lllIlIlIlIllII = 0; lllIlIlIlIllII < lllIlIlIlIlIII; ++lllIlIlIlIllII) {
            lllIlIlIlIIlll[lllIlIlIlIllII + lllIlIlIlIlIIl] = lllIlIlIlIlIlI[lllIlIlIlIllII];
        }
        return lllIlIlIlIlIIl;
    }
    
    public int signedByteAt(final int lllIllllIllllI) {
        return this.bytecode[lllIllllIllllI];
    }
    
    public int insertExGap(final int lllIlIllIlllIl, final int lllIlIllIllIIl) throws BadBytecode {
        return this.insertGapAt(lllIlIllIlllIl, lllIlIllIllIIl, true).length;
    }
    
    public void write(final byte[] lllIllIlllllII, int lllIllIllllIlI) {
        for (int lllIllIllllllI = lllIllIlllllII.length, lllIlllIIIIlIl = 0; lllIlllIIIIlIl < lllIllIllllllI; ++lllIlllIIIIlIl) {
            this.bytecode[lllIllIllllIlI++] = lllIllIlllllII[lllIlllIIIIlIl];
        }
    }
    
    public int skipSuperConstructor() throws BadBytecode {
        return this.skipSuperConstructor0(0);
    }
    
    static byte[] insertGapCore0(final byte[] lllIlIIllIIIII, final int lllIlIIlIlllll, final int lllIlIIlIllIII, final boolean lllIlIIlIlllIl, final ExceptionTable lllIlIIlIlllII, final CodeAttribute lllIlIIlIllIll) throws BadBytecode {
        if (lllIlIIlIllIII <= 0) {
            return lllIlIIllIIIII;
        }
        try {
            return insertGapCore1(lllIlIIllIIIII, lllIlIIlIlllll, lllIlIIlIllIII, lllIlIIlIlllIl, lllIlIIlIlllII, lllIlIIlIllIll);
        }
        catch (AlignmentException lllIlIIllIIIIl) {
            try {
                return insertGapCore1(lllIlIIllIIIII, lllIlIIlIlllll, lllIlIIlIllIII + 3 & 0xFFFFFFFC, lllIlIIlIlllIl, lllIlIIlIlllII, lllIlIIlIllIll);
            }
            catch (AlignmentException lllIlIIllIIIlI) {
                throw new RuntimeException("fatal error?");
            }
        }
    }
    
    private static int newOffset(final int lllIIlllIllllI, int lllIIlllIlIlll, final int lllIIlllIlllII, final int lllIIlllIllIll, final boolean lllIIlllIllIlI) {
        final int lllIIlllIllIIl = lllIIlllIllllI + lllIIlllIlIlll;
        if (lllIIlllIllllI < lllIIlllIlllII) {
            if (lllIIlllIlllII < lllIIlllIllIIl || (lllIIlllIllIlI && lllIIlllIlllII == lllIIlllIllIIl)) {
                lllIIlllIlIlll += lllIIlllIllIll;
            }
        }
        else if (lllIIlllIllllI == lllIIlllIlllII) {
            if (lllIIlllIllIIl < lllIIlllIlllII) {
                lllIIlllIlIlll -= lllIIlllIllIll;
            }
        }
        else if (lllIIlllIllIIl < lllIIlllIlllII || (!lllIIlllIllIlI && lllIIlllIlllII == lllIIlllIllIIl)) {
            lllIIlllIlIlll -= lllIIlllIllIll;
        }
        return lllIIlllIlIlll;
    }
    
    private static byte[] insertGapCore1(final byte[] lllIlIIlIIIlIl, final int lllIlIIlIIIlII, final int lllIlIIIllIllI, final boolean lllIlIIIllIlIl, final ExceptionTable lllIlIIIllIlII, final CodeAttribute lllIlIIIllIIll) throws AlignmentException, BadBytecode {
        final int lllIlIIIllllll = lllIlIIlIIIlIl.length;
        final byte[] lllIlIIIlllllI = new byte[lllIlIIIllllll + lllIlIIIllIllI];
        insertGap2(lllIlIIlIIIlIl, lllIlIIlIIIlII, lllIlIIIllIllI, lllIlIIIllllll, lllIlIIIlllllI, lllIlIIIllIlIl);
        lllIlIIIllIlII.shiftPc(lllIlIIlIIIlII, lllIlIIIllIllI, lllIlIIIllIlIl);
        final LineNumberAttribute lllIlIIIllllIl = (LineNumberAttribute)lllIlIIIllIIll.getAttribute("LineNumberTable");
        if (lllIlIIIllllIl != null) {
            lllIlIIIllllIl.shiftPc(lllIlIIlIIIlII, lllIlIIIllIllI, lllIlIIIllIlIl);
        }
        final LocalVariableAttribute lllIlIIIllllII = (LocalVariableAttribute)lllIlIIIllIIll.getAttribute("LocalVariableTable");
        if (lllIlIIIllllII != null) {
            lllIlIIIllllII.shiftPc(lllIlIIlIIIlII, lllIlIIIllIllI, lllIlIIIllIlIl);
        }
        final LocalVariableAttribute lllIlIIIlllIll = (LocalVariableAttribute)lllIlIIIllIIll.getAttribute("LocalVariableTypeTable");
        if (lllIlIIIlllIll != null) {
            lllIlIIIlllIll.shiftPc(lllIlIIlIIIlII, lllIlIIIllIllI, lllIlIIIllIlIl);
        }
        final StackMapTable lllIlIIIlllIlI = (StackMapTable)lllIlIIIllIIll.getAttribute("StackMapTable");
        if (lllIlIIIlllIlI != null) {
            lllIlIIIlllIlI.shiftPc(lllIlIIlIIIlII, lllIlIIIllIllI, lllIlIIIllIlIl);
        }
        final StackMap lllIlIIIlllIIl = (StackMap)lllIlIIIllIIll.getAttribute("StackMap");
        if (lllIlIIIlllIIl != null) {
            lllIlIIIlllIIl.shiftPc(lllIlIIlIIIlII, lllIlIIIllIllI, lllIlIIIllIlIl);
        }
        return lllIlIIIlllllI;
    }
    
    private byte[] insertGapCore0w(final byte[] lllIIllIIllllI, final int lllIIllIIlllIl, final int lllIIllIIlllII, final boolean lllIIllIIIllll, final ExceptionTable lllIIllIIllIlI, final CodeAttribute lllIIllIIllIIl, final Gap lllIIllIIIllII) throws BadBytecode {
        if (lllIIllIIlllII <= 0) {
            return lllIIllIIllllI;
        }
        final Pointers lllIIllIIlIlll = new Pointers(this.currentPos, this.mark, this.mark2, lllIIllIIlllIl, lllIIllIIllIlI, lllIIllIIllIIl);
        final List<Branch> lllIIllIIlIllI = makeJumpList(lllIIllIIllllI, lllIIllIIllllI.length, lllIIllIIlIlll);
        final byte[] lllIIllIIlIlIl = insertGap2w(lllIIllIIllllI, lllIIllIIlllIl, lllIIllIIlllII, lllIIllIIIllll, lllIIllIIlIllI, lllIIllIIlIlll);
        this.currentPos = lllIIllIIlIlll.cursor;
        this.mark = lllIIllIIlIlll.mark;
        this.mark2 = lllIIllIIlIlll.mark2;
        int lllIIllIIlIlII = lllIIllIIlIlll.mark0;
        if (lllIIllIIlIlII == this.currentPos && !lllIIllIIIllll) {
            this.currentPos += lllIIllIIlllII;
        }
        if (lllIIllIIIllll) {
            lllIIllIIlIlII -= lllIIllIIlllII;
        }
        lllIIllIIIllII.position = lllIIllIIlIlII;
        lllIIllIIIllII.length = lllIIllIIlllII;
        return lllIIllIIlIlIl;
    }
    
    public void setMark(final int llllIIIIIllIll) {
        this.mark = llllIIIIIllIll;
    }
    
    static byte[] changeLdcToLdcW(final byte[] lllIIlllIIlIll, final ExceptionTable lllIIlllIIIIll, final CodeAttribute lllIIlllIIIIlI, CodeAttribute.LdcEntry lllIIlllIIIIIl) throws BadBytecode {
        final Pointers lllIIlllIIIlll = new Pointers(0, 0, 0, 0, lllIIlllIIIIll, lllIIlllIIIIlI);
        final List<Branch> lllIIlllIIIllI = makeJumpList(lllIIlllIIlIll, lllIIlllIIlIll.length, lllIIlllIIIlll);
        while (lllIIlllIIIIIl != null) {
            addLdcW((CodeAttribute.LdcEntry)lllIIlllIIIIIl, lllIIlllIIIllI);
            lllIIlllIIIIIl = ((CodeAttribute.LdcEntry)lllIIlllIIIIIl).next;
        }
        final byte[] lllIIlllIIIlIl = insertGap2w(lllIIlllIIlIll, 0, 0, false, lllIIlllIIIllI, lllIIlllIIIlll);
        return lllIIlllIIIlIl;
    }
    
    public int lookAhead() {
        return this.currentPos;
    }
    
    public int s32bitAt(final int lllIlllIlIIIll) {
        return ByteArray.read32bit(this.bytecode, lllIlllIlIIIll);
    }
    
    public int insertExGap(final int lllIlIlllIIlII) throws BadBytecode {
        return this.insertGapAt(this.currentPos, lllIlIlllIIlII, true).position;
    }
    
    private int insert0(int lllIlIllllllII, final byte[] lllIllIIIIIIIl, final boolean lllIlIlllllIlI) throws BadBytecode {
        final int lllIlIllllllll = lllIllIIIIIIIl.length;
        if (lllIlIllllllll <= 0) {
            return lllIlIllllllII;
        }
        int lllIlIlllllllI;
        lllIlIllllllII = (lllIlIlllllllI = this.insertGapAt(lllIlIllllllII, lllIlIllllllll, lllIlIlllllIlI).position);
        for (int lllIllIIIIIlII = 0; lllIllIIIIIlII < lllIlIllllllll; ++lllIllIIIIIlII) {
            this.bytecode[lllIlIlllllllI++] = lllIllIIIIIIIl[lllIllIIIIIlII];
        }
        return lllIlIllllllII;
    }
    
    public int insertGap(final int lllIlIllllIIIl) throws BadBytecode {
        return this.insertGapAt(this.currentPos, lllIlIllllIIIl, false).position;
    }
    
    public boolean hasNext() {
        return this.currentPos < this.endPos;
    }
    
    public void write32bit(final int lllIlllIIlIlIl, final int lllIlllIIlIlII) {
        ByteArray.write32bit(lllIlllIIlIlIl, this.bytecode, lllIlllIIlIlII);
    }
    
    public void insert(final int lllIllIIllIIIl, final byte[] lllIllIIlIllIl) throws BadBytecode {
        this.insert0(lllIllIIllIIIl, lllIllIIlIllIl, false);
    }
    
    public int insertAt(final int lllIllIIlIIlIl, final byte[] lllIllIIlIIlII) throws BadBytecode {
        return this.insert0(lllIllIIlIIlIl, lllIllIIlIIlII, false);
    }
    
    private static List<Branch> makeJumpList(final byte[] lllIIlIIlllIII, final int lllIIlIIllIIll, final Pointers lllIIlIIllIIlI) throws BadBytecode {
        final List<Branch> lllIIlIIllIlIl = new ArrayList<Branch>();
        int lllIIlIIlllIlI;
        for (int lllIIlIIlllIIl = 0; lllIIlIIlllIIl < lllIIlIIllIIll; lllIIlIIlllIIl = lllIIlIIlllIlI) {
            lllIIlIIlllIlI = nextOpcode(lllIIlIIlllIII, lllIIlIIlllIIl);
            final int lllIIlIIlllIll = lllIIlIIlllIII[lllIIlIIlllIIl] & 0xFF;
            if ((153 <= lllIIlIIlllIll && lllIIlIIlllIll <= 168) || lllIIlIIlllIll == 198 || lllIIlIIlllIll == 199) {
                final int lllIIlIlIIllIl = lllIIlIIlllIII[lllIIlIIlllIIl + 1] << 8 | (lllIIlIIlllIII[lllIIlIIlllIIl + 2] & 0xFF);
                Branch lllIIlIlIIllII = null;
                if (lllIIlIIlllIll == 167 || lllIIlIIlllIll == 168) {
                    final Branch lllIIlIlIIlllI = new Jump16(lllIIlIIlllIIl, lllIIlIlIIllIl);
                }
                else {
                    lllIIlIlIIllII = new If16(lllIIlIIlllIIl, lllIIlIlIIllIl);
                }
                lllIIlIIllIlIl.add(lllIIlIlIIllII);
            }
            else if (lllIIlIIlllIll == 200 || lllIIlIIlllIll == 201) {
                final int lllIIlIlIIlIll = ByteArray.read32bit(lllIIlIIlllIII, lllIIlIIlllIIl + 1);
                lllIIlIIllIlIl.add(new Jump32(lllIIlIIlllIIl, lllIIlIlIIlIll));
            }
            else if (lllIIlIIlllIll == 170) {
                final int lllIIlIlIIlIIl = (lllIIlIIlllIIl & 0xFFFFFFFC) + 4;
                final int lllIIlIlIIlIII = ByteArray.read32bit(lllIIlIIlllIII, lllIIlIlIIlIIl);
                final int lllIIlIlIIIlll = ByteArray.read32bit(lllIIlIIlllIII, lllIIlIlIIlIIl + 4);
                final int lllIIlIlIIIllI = ByteArray.read32bit(lllIIlIIlllIII, lllIIlIlIIlIIl + 8);
                int lllIIlIlIIIlIl = lllIIlIlIIlIIl + 12;
                final int lllIIlIlIIIlII = lllIIlIlIIIllI - lllIIlIlIIIlll + 1;
                final int[] lllIIlIlIIIIll = new int[lllIIlIlIIIlII];
                for (int lllIIlIlIIlIlI = 0; lllIIlIlIIlIlI < lllIIlIlIIIlII; ++lllIIlIlIIlIlI) {
                    lllIIlIlIIIIll[lllIIlIlIIlIlI] = ByteArray.read32bit(lllIIlIIlllIII, lllIIlIlIIIlIl);
                    lllIIlIlIIIlIl += 4;
                }
                lllIIlIIllIlIl.add(new Table(lllIIlIIlllIIl, lllIIlIlIIlIII, lllIIlIlIIIlll, lllIIlIlIIIllI, lllIIlIlIIIIll, lllIIlIIllIIlI));
            }
            else if (lllIIlIIlllIll == 171) {
                final int lllIIlIlIIIIIl = (lllIIlIIlllIIl & 0xFFFFFFFC) + 4;
                final int lllIIlIlIIIIII = ByteArray.read32bit(lllIIlIIlllIII, lllIIlIlIIIIIl);
                final int lllIIlIIllllll = ByteArray.read32bit(lllIIlIIlllIII, lllIIlIlIIIIIl + 4);
                int lllIIlIIlllllI = lllIIlIlIIIIIl + 8;
                final int[] lllIIlIIllllIl = new int[lllIIlIIllllll];
                final int[] lllIIlIIllllII = new int[lllIIlIIllllll];
                for (int lllIIlIlIIIIlI = 0; lllIIlIlIIIIlI < lllIIlIIllllll; ++lllIIlIlIIIIlI) {
                    lllIIlIIllllIl[lllIIlIlIIIIlI] = ByteArray.read32bit(lllIIlIIlllIII, lllIIlIIlllllI);
                    lllIIlIIllllII[lllIIlIlIIIIlI] = ByteArray.read32bit(lllIIlIIlllIII, lllIIlIIlllllI + 4);
                    lllIIlIIlllllI += 8;
                }
                lllIIlIIllIlIl.add(new Lookup(lllIIlIIlllIIl, lllIIlIlIIIIII, lllIIlIIllllIl, lllIIlIIllllII, lllIIlIIllIIlI));
            }
        }
        return lllIIlIIllIlIl;
    }
    
    public void insertEx(final int lllIllIIIlIllI, final byte[] lllIllIIIllIII) throws BadBytecode {
        this.insert0(lllIllIIIlIllI, lllIllIIIllIII, true);
    }
    
    public int insertGap(final int lllIlIlllIllII, final int lllIlIlllIlIll) throws BadBytecode {
        return this.insertGapAt(lllIlIlllIllII, lllIlIlllIlIll, false).length;
    }
    
    public void move(final int llllIIIIlIlIIl) {
        this.currentPos = llllIIIIlIlIIl;
    }
    
    protected CodeIterator(final CodeAttribute llllIIIIllIlIl) {
        this.codeAttr = llllIIIIllIlIl;
        this.bytecode = llllIIIIllIlIl.getCode();
        this.begin();
    }
    
    private int skipSuperConstructor0(final int lllIllIlIIlIII) throws BadBytecode {
        this.begin();
        final ConstPool lllIllIlIIIlll = this.codeAttr.getConstPool();
        final String lllIllIlIIIllI = this.codeAttr.getDeclaringClass();
        int lllIllIlIIIlIl = 0;
        while (this.hasNext()) {
            final int lllIllIlIIlIll = this.next();
            final int lllIllIlIIlIlI = this.byteAt(lllIllIlIIlIll);
            if (lllIllIlIIlIlI == 187) {
                ++lllIllIlIIIlIl;
            }
            else {
                if (lllIllIlIIlIlI != 183) {
                    continue;
                }
                final int lllIllIlIIllII = ByteArray.readU16bit(this.bytecode, lllIllIlIIlIll + 1);
                if (!lllIllIlIIIlll.getMethodrefName(lllIllIlIIllII).equals("<init>") || --lllIllIlIIIlIl >= 0) {
                    continue;
                }
                if (lllIllIlIIlIII < 0) {
                    return lllIllIlIIlIll;
                }
                final String lllIllIlIIllIl = lllIllIlIIIlll.getMethodrefClassName(lllIllIlIIllII);
                if (lllIllIlIIllIl.equals(lllIllIlIIIllI) == lllIllIlIIlIII > 0) {
                    return lllIllIlIIlIll;
                }
                break;
            }
        }
        this.begin();
        return -1;
    }
    
    private static byte[] makeExapndedCode(final byte[] lllIIlIIIlIIlI, final List<Branch> lllIIlIIIIIlII, final int lllIIlIIIlIIII, final int lllIIlIIIIIIlI) throws BadBytecode {
        final int lllIIlIIIIlllI = lllIIlIIIIIlII.size();
        int lllIIlIIIIllIl = lllIIlIIIlIIlI.length + lllIIlIIIIIIlI;
        for (final Branch lllIIlIIIlIlll : lllIIlIIIIIlII) {
            lllIIlIIIIllIl += lllIIlIIIlIlll.deltaSize();
        }
        final byte[] lllIIlIIIIllII = new byte[lllIIlIIIIllIl];
        int lllIIlIIIIlIll = 0;
        int lllIIlIIIIlIlI = 0;
        int lllIIlIIIIlIIl = 0;
        final int lllIIlIIIIlIII = lllIIlIIIlIIlI.length;
        Branch lllIIlIIIIIlll = null;
        int lllIIlIIIIIllI = 0;
        if (0 < lllIIlIIIIlllI) {
            final Branch lllIIlIIIlIllI = lllIIlIIIIIlII.get(0);
            final int lllIIlIIIlIlIl = lllIIlIIIlIllI.orgPos;
        }
        else {
            lllIIlIIIIIlll = null;
            lllIIlIIIIIllI = lllIIlIIIIlIII;
        }
        while (lllIIlIIIIlIll < lllIIlIIIIlIII) {
            if (lllIIlIIIIlIll == lllIIlIIIlIIII) {
                for (int lllIIlIIIlIlII = lllIIlIIIIlIlI + lllIIlIIIIIIlI; lllIIlIIIIlIlI < lllIIlIIIlIlII; lllIIlIIIIllII[lllIIlIIIIlIlI++] = 0) {}
            }
            if (lllIIlIIIIlIll != lllIIlIIIIIllI) {
                lllIIlIIIIllII[lllIIlIIIIlIlI++] = lllIIlIIIlIIlI[lllIIlIIIIlIll++];
            }
            else {
                final int lllIIlIIIlIIll = lllIIlIIIIIlll.write(lllIIlIIIIlIll, lllIIlIIIlIIlI, lllIIlIIIIlIlI, lllIIlIIIIllII);
                lllIIlIIIIlIll += lllIIlIIIlIIll;
                lllIIlIIIIlIlI += lllIIlIIIlIIll + lllIIlIIIIIlll.deltaSize();
                if (++lllIIlIIIIlIIl < lllIIlIIIIlllI) {
                    lllIIlIIIIIlll = lllIIlIIIIIlII.get(lllIIlIIIIlIIl);
                    lllIIlIIIIIllI = lllIIlIIIIIlll.orgPos;
                }
                else {
                    lllIIlIIIIIlll = null;
                    lllIIlIIIIIllI = lllIIlIIIIlIII;
                }
            }
        }
        return lllIIlIIIIllII;
    }
    
    public void write16bit(final int lllIlllIllIIll, final int lllIlllIllIIIl) {
        ByteArray.write16bit(lllIlllIllIIll, this.bytecode, lllIlllIllIIIl);
    }
    
    static class AlignmentException extends Exception
    {
    }
    
    static class Lookup extends Switcher
    {
        /* synthetic */ int[] matches;
        
        Lookup(final int lllllllllllllllllllIlIllIIIllIlI, final int lllllllllllllllllllIlIllIIIlIIll, final int[] lllllllllllllllllllIlIllIIIlIIlI, final int[] lllllllllllllllllllIlIllIIIlIlll, final Pointers lllllllllllllllllllIlIllIIIlIIII) {
            super(lllllllllllllllllllIlIllIIIllIlI, lllllllllllllllllllIlIllIIIlIIll, lllllllllllllllllllIlIllIIIlIlll, lllllllllllllllllllIlIllIIIlIIII);
            this.matches = lllllllllllllllllllIlIllIIIlIIlI;
        }
        
        @Override
        int write2(int lllllllllllllllllllIlIllIIIIlIII, final byte[] lllllllllllllllllllIlIllIIIIIIll) {
            final int lllllllllllllllllllIlIllIIIIIllI = this.matches.length;
            ByteArray.write32bit(lllllllllllllllllllIlIllIIIIIllI, lllllllllllllllllllIlIllIIIIIIll, lllllllllllllllllllIlIllIIIIlIII);
            lllllllllllllllllllIlIllIIIIlIII += 4;
            for (int lllllllllllllllllllIlIllIIIIlIlI = 0; lllllllllllllllllllIlIllIIIIlIlI < lllllllllllllllllllIlIllIIIIIllI; ++lllllllllllllllllllIlIllIIIIlIlI) {
                ByteArray.write32bit(this.matches[lllllllllllllllllllIlIllIIIIlIlI], lllllllllllllllllllIlIllIIIIIIll, lllllllllllllllllllIlIllIIIIlIII);
                ByteArray.write32bit(this.offsets[lllllllllllllllllllIlIllIIIIlIlI], lllllllllllllllllllIlIllIIIIIIll, lllllllllllllllllllIlIllIIIIlIII + 4);
                lllllllllllllllllllIlIllIIIIlIII += 8;
            }
            return 4 + 8 * lllllllllllllllllllIlIllIIIIIllI;
        }
        
        @Override
        int tableSize() {
            return 4 + 8 * this.matches.length;
        }
    }
    
    abstract static class Switcher extends Branch
    {
        /* synthetic */ int defaultByte;
        /* synthetic */ int[] offsets;
        /* synthetic */ Pointers pointers;
        /* synthetic */ int gap;
        
        @Override
        int write(final int llllllllllllllIllIllIlllIlIlIIIl, final byte[] llllllllllllllIllIllIlllIlIIIlll, int llllllllllllllIllIllIlllIlIIIllI, final byte[] llllllllllllllIllIllIlllIlIIIlIl) throws BadBytecode {
            int llllllllllllllIllIllIlllIlIIllIl = 3 - (this.pos & 0x3);
            int llllllllllllllIllIllIlllIlIIllII = this.gap - llllllllllllllIllIllIlllIlIIllIl;
            final int llllllllllllllIllIllIlllIlIIlIll = 5 + (3 - (this.orgPos & 0x3)) + this.tableSize();
            if (llllllllllllllIllIllIlllIlIIllII > 0) {
                this.adjustOffsets(llllllllllllllIllIllIlllIlIIlIll, llllllllllllllIllIllIlllIlIIllII);
            }
            llllllllllllllIllIllIlllIlIIIlIl[llllllllllllllIllIllIlllIlIIIllI++] = llllllllllllllIllIllIlllIlIIIlll[llllllllllllllIllIllIlllIlIlIIIl];
            while (llllllllllllllIllIllIlllIlIIllIl-- > 0) {
                llllllllllllllIllIllIlllIlIIIlIl[llllllllllllllIllIllIlllIlIIIllI++] = 0;
            }
            ByteArray.write32bit(this.defaultByte, llllllllllllllIllIllIlllIlIIIlIl, llllllllllllllIllIllIlllIlIIIllI);
            final int llllllllllllllIllIllIlllIlIIlIlI = this.write2(llllllllllllllIllIllIlllIlIIIllI + 4, llllllllllllllIllIllIlllIlIIIlIl);
            llllllllllllllIllIllIlllIlIIIllI += llllllllllllllIllIllIlllIlIIlIlI + 4;
            while (llllllllllllllIllIllIlllIlIIllII-- > 0) {
                llllllllllllllIllIllIlllIlIIIlIl[llllllllllllllIllIllIlllIlIIIllI++] = 0;
            }
            return 5 + (3 - (this.orgPos & 0x3)) + llllllllllllllIllIllIlllIlIIlIlI;
        }
        
        abstract int write2(final int p0, final byte[] p1);
        
        void adjustOffsets(final int llllllllllllllIllIllIlllIIllIlll, final int llllllllllllllIllIllIlllIIlllIIl) throws BadBytecode {
            this.pointers.shiftForSwitch(this.pos + llllllllllllllIllIllIlllIIllIlll, llllllllllllllIllIllIlllIIlllIIl);
            if (this.defaultByte == llllllllllllllIllIllIlllIIllIlll) {
                this.defaultByte -= llllllllllllllIllIllIlllIIlllIIl;
            }
            for (int llllllllllllllIllIllIlllIIllllII = 0; llllllllllllllIllIllIlllIIllllII < this.offsets.length; ++llllllllllllllIllIllIlllIIllllII) {
                if (this.offsets[llllllllllllllIllIllIlllIIllllII] == llllllllllllllIllIllIlllIIllIlll) {
                    final int[] offsets = this.offsets;
                    final int n = llllllllllllllIllIllIlllIIllllII;
                    offsets[n] -= llllllllllllllIllIllIlllIIlllIIl;
                }
            }
        }
        
        Switcher(final int llllllllllllllIllIllIllllIIIIlIl, final int llllllllllllllIllIllIllllIIIIlII, final int[] llllllllllllllIllIllIlllIllllllI, final Pointers llllllllllllllIllIllIllllIIIIIlI) {
            super(llllllllllllllIllIllIllllIIIIlIl);
            this.gap = 3 - (llllllllllllllIllIllIllllIIIIlIl & 0x3);
            this.defaultByte = llllllllllllllIllIllIllllIIIIlII;
            this.offsets = llllllllllllllIllIllIlllIllllllI;
            this.pointers = llllllllllllllIllIllIllllIIIIIlI;
        }
        
        abstract int tableSize();
        
        @Override
        int deltaSize() {
            return this.gap - (3 - (this.orgPos & 0x3));
        }
        
        @Override
        void shift(final int llllllllllllllIllIllIlllIlllIIll, final int llllllllllllllIllIllIlllIllIllII, final boolean llllllllllllllIllIllIlllIllIlIll) {
            final int llllllllllllllIllIllIlllIlllIIII = this.pos;
            this.defaultByte = Branch.shiftOffset(llllllllllllllIllIllIlllIlllIIII, this.defaultByte, llllllllllllllIllIllIlllIlllIIll, llllllllllllllIllIllIlllIllIllII, llllllllllllllIllIllIlllIllIlIll);
            for (int llllllllllllllIllIllIlllIllIllll = this.offsets.length, llllllllllllllIllIllIlllIlllIlIl = 0; llllllllllllllIllIllIlllIlllIlIl < llllllllllllllIllIllIlllIllIllll; ++llllllllllllllIllIllIlllIlllIlIl) {
                this.offsets[llllllllllllllIllIllIlllIlllIlIl] = Branch.shiftOffset(llllllllllllllIllIllIlllIlllIIII, this.offsets[llllllllllllllIllIllIlllIlllIlIl], llllllllllllllIllIllIlllIlllIIll, llllllllllllllIllIllIlllIllIllII, llllllllllllllIllIllIlllIllIlIll);
            }
            super.shift(llllllllllllllIllIllIlllIlllIIll, llllllllllllllIllIllIlllIllIllII, llllllllllllllIllIllIlllIllIlIll);
        }
        
        @Override
        int gapChanged() {
            final int llllllllllllllIllIllIlllIllIIIlI = 3 - (this.pos & 0x3);
            if (llllllllllllllIllIllIlllIllIIIlI > this.gap) {
                final int llllllllllllllIllIllIlllIllIIlII = llllllllllllllIllIllIlllIllIIIlI - this.gap;
                this.gap = llllllllllllllIllIllIlllIllIIIlI;
                return llllllllllllllIllIllIlllIllIIlII;
            }
            return 0;
        }
    }
    
    abstract static class Branch
    {
        /* synthetic */ int pos;
        /* synthetic */ int orgPos;
        
        abstract int write(final int p0, final byte[] p1, final int p2, final byte[] p3) throws BadBytecode;
        
        int gapChanged() {
            return 0;
        }
        
        int deltaSize() {
            return 0;
        }
        
        static int shiftOffset(final int lllllllllllllIlIIIlIlIlIIIIlIlll, int lllllllllllllIlIIIlIlIlIIIIlIIII, final int lllllllllllllIlIIIlIlIlIIIIlIlIl, final int lllllllllllllIlIIIlIlIlIIIIlIlII, final boolean lllllllllllllIlIIIlIlIlIIIIlIIll) {
            final int lllllllllllllIlIIIlIlIlIIIIlIIlI = lllllllllllllIlIIIlIlIlIIIIlIlll + lllllllllllllIlIIIlIlIlIIIIlIIII;
            if (lllllllllllllIlIIIlIlIlIIIIlIlll < lllllllllllllIlIIIlIlIlIIIIlIlIl) {
                if (lllllllllllllIlIIIlIlIlIIIIlIlIl < lllllllllllllIlIIIlIlIlIIIIlIIlI || (lllllllllllllIlIIIlIlIlIIIIlIIll && lllllllllllllIlIIIlIlIlIIIIlIlIl == lllllllllllllIlIIIlIlIlIIIIlIIlI)) {
                    lllllllllllllIlIIIlIlIlIIIIlIIII += lllllllllllllIlIIIlIlIlIIIIlIlII;
                }
            }
            else if (lllllllllllllIlIIIlIlIlIIIIlIlll == lllllllllllllIlIIIlIlIlIIIIlIlIl) {
                if (lllllllllllllIlIIIlIlIlIIIIlIIlI < lllllllllllllIlIIIlIlIlIIIIlIlIl && lllllllllllllIlIIIlIlIlIIIIlIIll) {
                    lllllllllllllIlIIIlIlIlIIIIlIIII -= lllllllllllllIlIIIlIlIlIIIIlIlII;
                }
                else if (lllllllllllllIlIIIlIlIlIIIIlIlIl < lllllllllllllIlIIIlIlIlIIIIlIIlI && !lllllllllllllIlIIIlIlIlIIIIlIIll) {
                    lllllllllllllIlIIIlIlIlIIIIlIIII += lllllllllllllIlIIIlIlIlIIIIlIlII;
                }
            }
            else if (lllllllllllllIlIIIlIlIlIIIIlIIlI < lllllllllllllIlIIIlIlIlIIIIlIlIl || (!lllllllllllllIlIIIlIlIlIIIIlIIll && lllllllllllllIlIIIlIlIlIIIIlIlIl == lllllllllllllIlIIIlIlIlIIIIlIIlI)) {
                lllllllllllllIlIIIlIlIlIIIIlIIII -= lllllllllllllIlIIIlIlIlIIIIlIlII;
            }
            return lllllllllllllIlIIIlIlIlIIIIlIIII;
        }
        
        boolean expanded() {
            return false;
        }
        
        Branch(final int lllllllllllllIlIIIlIlIlIIIlIllII) {
            this.orgPos = lllllllllllllIlIIIlIlIlIIIlIllII;
            this.pos = lllllllllllllIlIIIlIlIlIIIlIllII;
        }
        
        void shift(final int lllllllllllllIlIIIlIlIlIIIlIIlII, final int lllllllllllllIlIIIlIlIlIIIIlllll, final boolean lllllllllllllIlIIIlIlIlIIIIllllI) {
            if (lllllllllllllIlIIIlIlIlIIIlIIlII < this.pos || (lllllllllllllIlIIIlIlIlIIIlIIlII == this.pos && lllllllllllllIlIIIlIlIlIIIIllllI)) {
                this.pos += lllllllllllllIlIIIlIlIlIIIIlllll;
            }
        }
    }
    
    static class Pointers
    {
        /* synthetic */ int mark2;
        /* synthetic */ int cursor;
        /* synthetic */ int mark0;
        /* synthetic */ LineNumberAttribute line;
        /* synthetic */ ExceptionTable etable;
        /* synthetic */ LocalVariableAttribute types;
        /* synthetic */ StackMapTable stack;
        /* synthetic */ StackMap stack2;
        /* synthetic */ int mark;
        /* synthetic */ LocalVariableAttribute vars;
        
        void shiftForSwitch(final int lllllllllllllIIIlIIlllllIlllllIl, final int lllllllllllllIIIlIIlllllIlllllII) throws BadBytecode {
            if (this.stack != null) {
                this.stack.shiftForSwitch(lllllllllllllIIIlIIlllllIlllllIl, lllllllllllllIIIlIIlllllIlllllII);
            }
            if (this.stack2 != null) {
                this.stack2.shiftForSwitch(lllllllllllllIIIlIIlllllIlllllIl, lllllllllllllIIIlIIlllllIlllllII);
            }
        }
        
        void shiftPc(final int lllllllllllllIIIlIIllllllIIIlIII, final int lllllllllllllIIIlIIllllllIIIIIll, final boolean lllllllllllllIIIlIIllllllIIIIllI) throws BadBytecode {
            if (lllllllllllllIIIlIIllllllIIIlIII < this.cursor || (lllllllllllllIIIlIIllllllIIIlIII == this.cursor && lllllllllllllIIIlIIllllllIIIIllI)) {
                this.cursor += lllllllllllllIIIlIIllllllIIIIIll;
            }
            if (lllllllllllllIIIlIIllllllIIIlIII < this.mark || (lllllllllllllIIIlIIllllllIIIlIII == this.mark && lllllllllllllIIIlIIllllllIIIIllI)) {
                this.mark += lllllllllllllIIIlIIllllllIIIIIll;
            }
            if (lllllllllllllIIIlIIllllllIIIlIII < this.mark2 || (lllllllllllllIIIlIIllllllIIIlIII == this.mark2 && lllllllllllllIIIlIIllllllIIIIllI)) {
                this.mark2 += lllllllllllllIIIlIIllllllIIIIIll;
            }
            if (lllllllllllllIIIlIIllllllIIIlIII < this.mark0 || (lllllllllllllIIIlIIllllllIIIlIII == this.mark0 && lllllllllllllIIIlIIllllllIIIIllI)) {
                this.mark0 += lllllllllllllIIIlIIllllllIIIIIll;
            }
            this.etable.shiftPc(lllllllllllllIIIlIIllllllIIIlIII, lllllllllllllIIIlIIllllllIIIIIll, lllllllllllllIIIlIIllllllIIIIllI);
            if (this.line != null) {
                this.line.shiftPc(lllllllllllllIIIlIIllllllIIIlIII, lllllllllllllIIIlIIllllllIIIIIll, lllllllllllllIIIlIIllllllIIIIllI);
            }
            if (this.vars != null) {
                this.vars.shiftPc(lllllllllllllIIIlIIllllllIIIlIII, lllllllllllllIIIlIIllllllIIIIIll, lllllllllllllIIIlIIllllllIIIIllI);
            }
            if (this.types != null) {
                this.types.shiftPc(lllllllllllllIIIlIIllllllIIIlIII, lllllllllllllIIIlIIllllllIIIIIll, lllllllllllllIIIlIIllllllIIIIllI);
            }
            if (this.stack != null) {
                this.stack.shiftPc(lllllllllllllIIIlIIllllllIIIlIII, lllllllllllllIIIlIIllllllIIIIIll, lllllllllllllIIIlIIllllllIIIIllI);
            }
            if (this.stack2 != null) {
                this.stack2.shiftPc(lllllllllllllIIIlIIllllllIIIlIII, lllllllllllllIIIlIIllllllIIIIIll, lllllllllllllIIIlIIllllllIIIIllI);
            }
        }
        
        Pointers(final int lllllllllllllIIIlIIllllllIIllIlI, final int lllllllllllllIIIlIIllllllIIlIIlI, final int lllllllllllllIIIlIIllllllIIlIIIl, final int lllllllllllllIIIlIIllllllIIlIlll, final ExceptionTable lllllllllllllIIIlIIllllllIIIllll, final CodeAttribute lllllllllllllIIIlIIllllllIIlIlIl) {
            this.cursor = lllllllllllllIIIlIIllllllIIllIlI;
            this.mark = lllllllllllllIIIlIIllllllIIlIIlI;
            this.mark2 = lllllllllllllIIIlIIllllllIIlIIIl;
            this.mark0 = lllllllllllllIIIlIIllllllIIlIlll;
            this.etable = lllllllllllllIIIlIIllllllIIIllll;
            this.line = (LineNumberAttribute)lllllllllllllIIIlIIllllllIIlIlIl.getAttribute("LineNumberTable");
            this.vars = (LocalVariableAttribute)lllllllllllllIIIlIIllllllIIlIlIl.getAttribute("LocalVariableTable");
            this.types = (LocalVariableAttribute)lllllllllllllIIIlIIllllllIIlIlIl.getAttribute("LocalVariableTypeTable");
            this.stack = (StackMapTable)lllllllllllllIIIlIIllllllIIlIlIl.getAttribute("StackMapTable");
            this.stack2 = (StackMap)lllllllllllllIIIlIIllllllIIlIlIl.getAttribute("StackMap");
        }
    }
    
    abstract static class Branch16 extends Branch
    {
        /* synthetic */ int state;
        /* synthetic */ int offset;
        
        @Override
        abstract int deltaSize();
        
        @Override
        boolean expanded() {
            if (this.state == 1) {
                this.state = 2;
                return true;
            }
            return false;
        }
        
        @Override
        void shift(final int llllllllllllllIlIlllIIlIIIlIIllI, final int llllllllllllllIlIlllIIlIIIlIllII, final boolean llllllllllllllIlIlllIIlIIIlIIIlI) {
            this.offset = Branch.shiftOffset(this.pos, this.offset, llllllllllllllIlIlllIIlIIIlIIllI, llllllllllllllIlIlllIIlIIIlIllII, llllllllllllllIlIlllIIlIIIlIIIlI);
            super.shift(llllllllllllllIlIlllIIlIIIlIIllI, llllllllllllllIlIlllIIlIIIlIllII, llllllllllllllIlIlllIIlIIIlIIIlI);
            if (this.state == 0 && (this.offset < -32768 || 32767 < this.offset)) {
                this.state = 1;
            }
        }
        
        Branch16(final int llllllllllllllIlIlllIIlIIIlllIII, final int llllllllllllllIlIlllIIlIIIllllII) {
            super(llllllllllllllIlIlllIIlIIIlllIII);
            this.offset = llllllllllllllIlIlllIIlIIIllllII;
            this.state = 0;
        }
        
        abstract void write32(final int p0, final byte[] p1, final int p2, final byte[] p3);
        
        @Override
        int write(final int llllllllllllllIlIlllIIlIIIIlIIII, final byte[] llllllllllllllIlIlllIIlIIIIIllll, final int llllllllllllllIlIlllIIlIIIIIlllI, final byte[] llllllllllllllIlIlllIIlIIIIlIIlI) {
            if (this.state == 2) {
                this.write32(llllllllllllllIlIlllIIlIIIIlIIII, llllllllllllllIlIlllIIlIIIIIllll, llllllllllllllIlIlllIIlIIIIIlllI, llllllllllllllIlIlllIIlIIIIlIIlI);
            }
            else {
                llllllllllllllIlIlllIIlIIIIlIIlI[llllllllllllllIlIlllIIlIIIIIlllI] = llllllllllllllIlIlllIIlIIIIIllll[llllllllllllllIlIlllIIlIIIIlIIII];
                ByteArray.write16bit(this.offset, llllllllllllllIlIlllIIlIIIIlIIlI, llllllllllllllIlIlllIIlIIIIIlllI + 1);
            }
            return 3;
        }
        
        static {
            EXPAND = 1;
            BIT32 = 2;
            BIT16 = 0;
        }
    }
    
    static class Table extends Switcher
    {
        /* synthetic */ int low;
        /* synthetic */ int high;
        
        @Override
        int tableSize() {
            return 8 + 4 * this.offsets.length;
        }
        
        Table(final int lllllllllllllllIllIIIIIlIIIIIllI, final int lllllllllllllllIllIIIIIlIIIIllII, final int lllllllllllllllIllIIIIIlIIIIlIll, final int lllllllllllllllIllIIIIIlIIIIIIll, final int[] lllllllllllllllIllIIIIIlIIIIlIIl, final Pointers lllllllllllllllIllIIIIIlIIIIlIII) {
            super(lllllllllllllllIllIIIIIlIIIIIllI, lllllllllllllllIllIIIIIlIIIIllII, lllllllllllllllIllIIIIIlIIIIlIIl, lllllllllllllllIllIIIIIlIIIIlIII);
            this.low = lllllllllllllllIllIIIIIlIIIIlIll;
            this.high = lllllllllllllllIllIIIIIlIIIIIIll;
        }
        
        @Override
        int write2(int lllllllllllllllIllIIIIIIllllIIII, final byte[] lllllllllllllllIllIIIIIIlllIllll) {
            ByteArray.write32bit(this.low, lllllllllllllllIllIIIIIIlllIllll, lllllllllllllllIllIIIIIIllllIIII);
            ByteArray.write32bit(this.high, lllllllllllllllIllIIIIIIlllIllll, lllllllllllllllIllIIIIIIllllIIII + 4);
            final int lllllllllllllllIllIIIIIIlllIlllI = this.offsets.length;
            lllllllllllllllIllIIIIIIllllIIII += 8;
            for (int lllllllllllllllIllIIIIIIllllIIlI = 0; lllllllllllllllIllIIIIIIllllIIlI < lllllllllllllllIllIIIIIIlllIlllI; ++lllllllllllllllIllIIIIIIllllIIlI) {
                ByteArray.write32bit(this.offsets[lllllllllllllllIllIIIIIIllllIIlI], lllllllllllllllIllIIIIIIlllIllll, lllllllllllllllIllIIIIIIllllIIII);
                lllllllllllllllIllIIIIIIllllIIII += 4;
            }
            return 8 + 4 * lllllllllllllllIllIIIIIIlllIlllI;
        }
    }
    
    static class Jump16 extends Branch16
    {
        @Override
        int deltaSize() {
            return (this.state == 2) ? 2 : 0;
        }
        
        Jump16(final int lllllllllllllIIIIIllllIIIIllllII, final int lllllllllllllIIIIIllllIIIIlllIII) {
            super(lllllllllllllIIIIIllllIIIIllllII, lllllllllllllIIIIIllllIIIIlllIII);
        }
        
        @Override
        void write32(final int lllllllllllllIIIIIllllIIIIlIlllI, final byte[] lllllllllllllIIIIIllllIIIIlIlIII, final int lllllllllllllIIIIIllllIIIIlIllII, final byte[] lllllllllllllIIIIIllllIIIIlIIllI) {
            lllllllllllllIIIIIllllIIIIlIIllI[lllllllllllllIIIIIllllIIIIlIllII] = (byte)(((lllllllllllllIIIIIllllIIIIlIlIII[lllllllllllllIIIIIllllIIIIlIlllI] & 0xFF) == 0xA7) ? 200 : 201);
            ByteArray.write32bit(this.offset, lllllllllllllIIIIIllllIIIIlIIllI, lllllllllllllIIIIIllllIIIIlIllII + 1);
        }
    }
    
    public static class Gap
    {
        public /* synthetic */ int position;
        public /* synthetic */ int length;
    }
    
    static class Jump32 extends Branch
    {
        /* synthetic */ int offset;
        
        @Override
        void shift(final int llllllllllllllIlIlllllIlllIIllll, final int llllllllllllllIlIlllllIlllIIlllI, final boolean llllllllllllllIlIlllllIlllIIlIIl) {
            this.offset = Branch.shiftOffset(this.pos, this.offset, llllllllllllllIlIlllllIlllIIllll, llllllllllllllIlIlllllIlllIIlllI, llllllllllllllIlIlllllIlllIIlIIl);
            super.shift(llllllllllllllIlIlllllIlllIIllll, llllllllllllllIlIlllllIlllIIlllI, llllllllllllllIlIlllllIlllIIlIIl);
        }
        
        Jump32(final int llllllllllllllIlIlllllIlllIllIIl, final int llllllllllllllIlIlllllIlllIlIlIl) {
            super(llllllllllllllIlIlllllIlllIllIIl);
            this.offset = llllllllllllllIlIlllllIlllIlIlIl;
        }
        
        @Override
        int write(final int llllllllllllllIlIlllllIlllIIIIlI, final byte[] llllllllllllllIlIlllllIllIllllII, final int llllllllllllllIlIlllllIllIlllIll, final byte[] llllllllllllllIlIlllllIllIlllIlI) {
            llllllllllllllIlIlllllIllIlllIlI[llllllllllllllIlIlllllIllIlllIll] = llllllllllllllIlIlllllIllIllllII[llllllllllllllIlIlllllIlllIIIIlI];
            ByteArray.write32bit(this.offset, llllllllllllllIlIlllllIllIlllIlI, llllllllllllllIlIlllllIllIlllIll + 1);
            return 5;
        }
    }
    
    static class LdcW extends Branch
    {
        /* synthetic */ boolean state;
        /* synthetic */ int index;
        
        @Override
        int write(final int lllllllllllllIIIlIIIIllIIIlIIlIl, final byte[] lllllllllllllIIIlIIIIllIIIlIIlII, final int lllllllllllllIIIlIIIIllIIIlIIIII, final byte[] lllllllllllllIIIlIIIIllIIIlIIIlI) {
            lllllllllllllIIIlIIIIllIIIlIIIlI[lllllllllllllIIIlIIIIllIIIlIIIII] = 19;
            ByteArray.write16bit(this.index, lllllllllllllIIIlIIIIllIIIlIIIlI, lllllllllllllIIIlIIIIllIIIlIIIII + 1);
            return 2;
        }
        
        @Override
        int deltaSize() {
            return 1;
        }
        
        @Override
        boolean expanded() {
            if (this.state) {
                this.state = false;
                return true;
            }
            return false;
        }
        
        LdcW(final int lllllllllllllIIIlIIIIllIIIlIllll, final int lllllllllllllIIIlIIIIllIIIlIlllI) {
            super(lllllllllllllIIIlIIIIllIIIlIllll);
            this.index = lllllllllllllIIIlIIIIllIIIlIlllI;
            this.state = true;
        }
    }
    
    static class If16 extends Branch16
    {
        @Override
        int deltaSize() {
            return (this.state == 2) ? 5 : 0;
        }
        
        int opcode(final int lllllllllllllllIIlIlIIlllIllIIll) {
            if (lllllllllllllllIIlIlIIlllIllIIll == 198) {
                return 199;
            }
            if (lllllllllllllllIIlIlIIlllIllIIll == 199) {
                return 198;
            }
            if ((lllllllllllllllIIlIlIIlllIllIIll - 153 & 0x1) == 0x0) {
                return lllllllllllllllIIlIlIIlllIllIIll + 1;
            }
            return lllllllllllllllIIlIlIIlllIllIIll - 1;
        }
        
        @Override
        void write32(final int lllllllllllllllIIlIlIIlllIllllIl, final byte[] lllllllllllllllIIlIlIIllllIIIIIl, final int lllllllllllllllIIlIlIIllllIIIIII, final byte[] lllllllllllllllIIlIlIIlllIlllIlI) {
            lllllllllllllllIIlIlIIlllIlllIlI[lllllllllllllllIIlIlIIllllIIIIII] = (byte)this.opcode(lllllllllllllllIIlIlIIllllIIIIIl[lllllllllllllllIIlIlIIlllIllllIl] & 0xFF);
            lllllllllllllllIIlIlIIlllIlllIlI[lllllllllllllllIIlIlIIllllIIIIII + 1] = 0;
            lllllllllllllllIIlIlIIlllIlllIlI[lllllllllllllllIIlIlIIllllIIIIII + 2] = 8;
            lllllllllllllllIIlIlIIlllIlllIlI[lllllllllllllllIIlIlIIllllIIIIII + 3] = -56;
            ByteArray.write32bit(this.offset - 3, lllllllllllllllIIlIlIIlllIlllIlI, lllllllllllllllIIlIlIIllllIIIIII + 4);
        }
        
        If16(final int lllllllllllllllIIlIlIIllllIllIll, final int lllllllllllllllIIlIlIIllllIlllll) {
            super(lllllllllllllllIIlIlIIllllIllIll, lllllllllllllllIIlIlIIllllIlllll);
        }
    }
}
