package com.viaversion.viaversion.libs.javassist.bytecode;

import java.io.*;
import com.viaversion.viaversion.libs.javassist.*;

public class InstructionPrinter implements Opcode
{
    private final /* synthetic */ PrintStream stream;
    private static final /* synthetic */ String[] opcodes;
    
    static {
        opcodes = Mnemonic.OPCODE;
    }
    
    public InstructionPrinter(final PrintStream lllllllllllllIIIIIIlIIllIIllIllI) {
        this.stream = lllllllllllllIIIIIIlIIllIIllIllI;
    }
    
    public void print(final CtMethod lllllllllllllIIIIIIlIIllIIlIIIll) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokevirtual   com/viaversion/viaversion/libs/javassist/CtMethod.getMethodInfo2:()Lcom/viaversion/viaversion/libs/javassist/bytecode/MethodInfo;
        //     4: astore_2        /* lllllllllllllIIIIIIlIIllIIIlllII */
        //     5: aload_2         /* lllllllllllllIIIIIIlIIllIIlIIIlI */
        //     6: invokevirtual   com/viaversion/viaversion/libs/javassist/bytecode/MethodInfo.getConstPool:()Lcom/viaversion/viaversion/libs/javassist/bytecode/ConstPool;
        //     9: astore_3        /* lllllllllllllIIIIIIlIIllIIIllIll */
        //    10: aload_2         /* lllllllllllllIIIIIIlIIllIIlIIIlI */
        //    11: invokevirtual   com/viaversion/viaversion/libs/javassist/bytecode/MethodInfo.getCodeAttribute:()Lcom/viaversion/viaversion/libs/javassist/bytecode/CodeAttribute;
        //    14: astore          lllllllllllllIIIIIIlIIllIIlIIIII
        //    16: aload           lllllllllllllIIIIIIlIIllIIlIIIII
        //    18: ifnonnull       22
        //    21: return         
        //    22: aload           lllllllllllllIIIIIIlIIllIIlIIIII
        //    24: invokevirtual   com/viaversion/viaversion/libs/javassist/bytecode/CodeAttribute.iterator:()Lcom/viaversion/viaversion/libs/javassist/bytecode/CodeIterator;
        //    27: astore          lllllllllllllIIIIIIlIIllIIIlllll
        //    29: aload           lllllllllllllIIIIIIlIIllIIIlllll
        //    31: invokevirtual   com/viaversion/viaversion/libs/javassist/bytecode/CodeIterator.hasNext:()Z
        //    34: ifeq            100
        //    37: aload           lllllllllllllIIIIIIlIIllIIIlllll
        //    39: invokevirtual   com/viaversion/viaversion/libs/javassist/bytecode/CodeIterator.next:()I
        //    42: istore          lllllllllllllIIIIIIlIIllIIlIIlll
        //    44: goto            59
        //    47: astore          lllllllllllllIIIIIIlIIllIIlIIllI
        //    49: new             Ljava/lang/RuntimeException;
        //    52: dup            
        //    53: aload           lllllllllllllIIIIIIlIIllIIlIIllI
        //    55: invokespecial   java/lang/RuntimeException.<init>:(Ljava/lang/Throwable;)V
        //    58: athrow         
        //    59: aload_0         /* lllllllllllllIIIIIIlIIllIIlIIlII */
        //    60: getfield        com/viaversion/viaversion/libs/javassist/bytecode/InstructionPrinter.stream:Ljava/io/PrintStream;
        //    63: new             Ljava/lang/StringBuilder;
        //    66: dup            
        //    67: invokespecial   java/lang/StringBuilder.<init>:()V
        //    70: iload           lllllllllllllIIIIIIlIIllIIlIIlIl
        //    72: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //    75: ldc             ": "
        //    77: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    80: aload           lllllllllllllIIIIIIlIIllIIIlllll
        //    82: iload           lllllllllllllIIIIIIlIIllIIlIIlIl
        //    84: aload_3         /* lllllllllllllIIIIIIlIIllIIlIIIIl */
        //    85: invokestatic    com/viaversion/viaversion/libs/javassist/bytecode/InstructionPrinter.instructionString:(Lcom/viaversion/viaversion/libs/javassist/bytecode/CodeIterator;ILcom/viaversion/viaversion/libs/javassist/bytecode/ConstPool;)Ljava/lang/String;
        //    88: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    91: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //    94: invokevirtual   java/io/PrintStream.println:(Ljava/lang/String;)V
        //    97: goto            29
        //   100: return         
        //    StackMapTable: 00 05 FE 00 16 07 00 2C 07 00 82 07 00 36 FC 00 06 07 00 3C 51 07 00 24 FC 00 0B 01 FA 00 28
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                                           
        //  -----  -----  -----  -----  ---------------------------------------------------------------
        //  37     44     47     59     Lcom/viaversion/viaversion/libs/javassist/bytecode/BadBytecode;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private static String wide(final CodeIterator lllllllllllllIIIIIIlIIlIllllllll, final int lllllllllllllIIIIIIlIIlIlllllllI) {
        final int lllllllllllllIIIIIIlIIllIIIIIIIl = lllllllllllllIIIIIIlIIlIllllllll.byteAt(lllllllllllllIIIIIIlIIlIlllllllI + 1);
        final int lllllllllllllIIIIIIlIIllIIIIIIII = lllllllllllllIIIIIIlIIlIllllllll.u16bitAt(lllllllllllllIIIIIIlIIlIlllllllI + 2);
        switch (lllllllllllllIIIIIIlIIllIIIIIIIl) {
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 132:
            case 169: {
                return String.valueOf(new StringBuilder().append(InstructionPrinter.opcodes[lllllllllllllIIIIIIlIIllIIIIIIIl]).append(" ").append(lllllllllllllIIIIIIlIIllIIIIIIII));
            }
            default: {
                throw new RuntimeException("Invalid WIDE operand");
            }
        }
    }
    
    public static void print(final CtMethod lllllllllllllIIIIIIlIIllIIllIIIl, final PrintStream lllllllllllllIIIIIIlIIllIIllIIII) {
        new InstructionPrinter(lllllllllllllIIIIIIlIIllIIllIIII).print(lllllllllllllIIIIIIlIIllIIllIIIl);
    }
    
    private static String interfaceMethodInfo(final ConstPool lllllllllllllIIIIIIlIIlIllllIIII, final int lllllllllllllIIIIIIlIIlIlllIllIl) {
        return String.valueOf(new StringBuilder().append("#").append(lllllllllllllIIIIIIlIIlIlllIllIl).append(" = Method ").append(lllllllllllllIIIIIIlIIlIllllIIII.getInterfaceMethodrefClassName(lllllllllllllIIIIIIlIIlIlllIllIl)).append(".").append(lllllllllllllIIIIIIlIIlIllllIIII.getInterfaceMethodrefName(lllllllllllllIIIIIIlIIlIlllIllIl)).append("(").append(lllllllllllllIIIIIIlIIlIllllIIII.getInterfaceMethodrefType(lllllllllllllIIIIIIlIIlIlllIllIl)).append(")"));
    }
    
    private static String fieldInfo(final ConstPool lllllllllllllIIIIIIlIIlIlllIIlII, final int lllllllllllllIIIIIIlIIlIlllIIIIl) {
        return String.valueOf(new StringBuilder().append("#").append(lllllllllllllIIIIIIlIIlIlllIIIIl).append(" = Field ").append(lllllllllllllIIIIIIlIIlIlllIIlII.getFieldrefClassName(lllllllllllllIIIIIIlIIlIlllIIIIl)).append(".").append(lllllllllllllIIIIIIlIIlIlllIIlII.getFieldrefName(lllllllllllllIIIIIIlIIlIlllIIIIl)).append("(").append(lllllllllllllIIIIIIlIIlIlllIIlII.getFieldrefType(lllllllllllllIIIIIIlIIlIlllIIIIl)).append(")"));
    }
    
    public static String instructionString(final CodeIterator lllllllllllllIIIIIIlIIllIIIIllII, final int lllllllllllllIIIIIIlIIllIIIIlIll, final ConstPool lllllllllllllIIIIIIlIIllIIIIlIlI) {
        final int lllllllllllllIIIIIIlIIllIIIIlllI = lllllllllllllIIIIIIlIIllIIIIllII.byteAt(lllllllllllllIIIIIIlIIllIIIIlIll);
        if (lllllllllllllIIIIIIlIIllIIIIlllI > InstructionPrinter.opcodes.length || lllllllllllllIIIIIIlIIllIIIIlllI < 0) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Invalid opcode, opcode: ").append(lllllllllllllIIIIIIlIIllIIIIlllI).append(" pos: ").append(lllllllllllllIIIIIIlIIllIIIIlIll)));
        }
        final String lllllllllllllIIIIIIlIIllIIIIllIl = InstructionPrinter.opcodes[lllllllllllllIIIIIIlIIllIIIIlllI];
        switch (lllllllllllllIIIIIIlIIllIIIIlllI) {
            case 16: {
                return String.valueOf(new StringBuilder().append(lllllllllllllIIIIIIlIIllIIIIllIl).append(" ").append(lllllllllllllIIIIIIlIIllIIIIllII.byteAt(lllllllllllllIIIIIIlIIllIIIIlIll + 1)));
            }
            case 17: {
                return String.valueOf(new StringBuilder().append(lllllllllllllIIIIIIlIIllIIIIllIl).append(" ").append(lllllllllllllIIIIIIlIIllIIIIllII.s16bitAt(lllllllllllllIIIIIIlIIllIIIIlIll + 1)));
            }
            case 18: {
                return String.valueOf(new StringBuilder().append(lllllllllllllIIIIIIlIIllIIIIllIl).append(" ").append(ldc(lllllllllllllIIIIIIlIIllIIIIlIlI, lllllllllllllIIIIIIlIIllIIIIllII.byteAt(lllllllllllllIIIIIIlIIllIIIIlIll + 1))));
            }
            case 19:
            case 20: {
                return String.valueOf(new StringBuilder().append(lllllllllllllIIIIIIlIIllIIIIllIl).append(" ").append(ldc(lllllllllllllIIIIIIlIIllIIIIlIlI, lllllllllllllIIIIIIlIIllIIIIllII.u16bitAt(lllllllllllllIIIIIIlIIllIIIIlIll + 1))));
            }
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58: {
                return String.valueOf(new StringBuilder().append(lllllllllllllIIIIIIlIIllIIIIllIl).append(" ").append(lllllllllllllIIIIIIlIIllIIIIllII.byteAt(lllllllllllllIIIIIIlIIllIIIIlIll + 1)));
            }
            case 153:
            case 154:
            case 155:
            case 156:
            case 157:
            case 158:
            case 159:
            case 160:
            case 161:
            case 162:
            case 163:
            case 164:
            case 165:
            case 166:
            case 198:
            case 199: {
                return String.valueOf(new StringBuilder().append(lllllllllllllIIIIIIlIIllIIIIllIl).append(" ").append(lllllllllllllIIIIIIlIIllIIIIllII.s16bitAt(lllllllllllllIIIIIIlIIllIIIIlIll + 1) + lllllllllllllIIIIIIlIIllIIIIlIll));
            }
            case 132: {
                return String.valueOf(new StringBuilder().append(lllllllllllllIIIIIIlIIllIIIIllIl).append(" ").append(lllllllllllllIIIIIIlIIllIIIIllII.byteAt(lllllllllllllIIIIIIlIIllIIIIlIll + 1)).append(", ").append(lllllllllllllIIIIIIlIIllIIIIllII.signedByteAt(lllllllllllllIIIIIIlIIllIIIIlIll + 2)));
            }
            case 167:
            case 168: {
                return String.valueOf(new StringBuilder().append(lllllllllllllIIIIIIlIIllIIIIllIl).append(" ").append(lllllllllllllIIIIIIlIIllIIIIllII.s16bitAt(lllllllllllllIIIIIIlIIllIIIIlIll + 1) + lllllllllllllIIIIIIlIIllIIIIlIll));
            }
            case 169: {
                return String.valueOf(new StringBuilder().append(lllllllllllllIIIIIIlIIllIIIIllIl).append(" ").append(lllllllllllllIIIIIIlIIllIIIIllII.byteAt(lllllllllllllIIIIIIlIIllIIIIlIll + 1)));
            }
            case 170: {
                return tableSwitch(lllllllllllllIIIIIIlIIllIIIIllII, lllllllllllllIIIIIIlIIllIIIIlIll);
            }
            case 171: {
                return lookupSwitch(lllllllllllllIIIIIIlIIllIIIIllII, lllllllllllllIIIIIIlIIllIIIIlIll);
            }
            case 178:
            case 179:
            case 180:
            case 181: {
                return String.valueOf(new StringBuilder().append(lllllllllllllIIIIIIlIIllIIIIllIl).append(" ").append(fieldInfo(lllllllllllllIIIIIIlIIllIIIIlIlI, lllllllllllllIIIIIIlIIllIIIIllII.u16bitAt(lllllllllllllIIIIIIlIIllIIIIlIll + 1))));
            }
            case 182:
            case 183:
            case 184: {
                return String.valueOf(new StringBuilder().append(lllllllllllllIIIIIIlIIllIIIIllIl).append(" ").append(methodInfo(lllllllllllllIIIIIIlIIllIIIIlIlI, lllllllllllllIIIIIIlIIllIIIIllII.u16bitAt(lllllllllllllIIIIIIlIIllIIIIlIll + 1))));
            }
            case 185: {
                return String.valueOf(new StringBuilder().append(lllllllllllllIIIIIIlIIllIIIIllIl).append(" ").append(interfaceMethodInfo(lllllllllllllIIIIIIlIIllIIIIlIlI, lllllllllllllIIIIIIlIIllIIIIllII.u16bitAt(lllllllllllllIIIIIIlIIllIIIIlIll + 1))));
            }
            case 186: {
                return String.valueOf(new StringBuilder().append(lllllllllllllIIIIIIlIIllIIIIllIl).append(" ").append(lllllllllllllIIIIIIlIIllIIIIllII.u16bitAt(lllllllllllllIIIIIIlIIllIIIIlIll + 1)));
            }
            case 187: {
                return String.valueOf(new StringBuilder().append(lllllllllllllIIIIIIlIIllIIIIllIl).append(" ").append(classInfo(lllllllllllllIIIIIIlIIllIIIIlIlI, lllllllllllllIIIIIIlIIllIIIIllII.u16bitAt(lllllllllllllIIIIIIlIIllIIIIlIll + 1))));
            }
            case 188: {
                return String.valueOf(new StringBuilder().append(lllllllllllllIIIIIIlIIllIIIIllIl).append(" ").append(arrayInfo(lllllllllllllIIIIIIlIIllIIIIllII.byteAt(lllllllllllllIIIIIIlIIllIIIIlIll + 1))));
            }
            case 189:
            case 192: {
                return String.valueOf(new StringBuilder().append(lllllllllllllIIIIIIlIIllIIIIllIl).append(" ").append(classInfo(lllllllllllllIIIIIIlIIllIIIIlIlI, lllllllllllllIIIIIIlIIllIIIIllII.u16bitAt(lllllllllllllIIIIIIlIIllIIIIlIll + 1))));
            }
            case 196: {
                return wide(lllllllllllllIIIIIIlIIllIIIIllII, lllllllllllllIIIIIIlIIllIIIIlIll);
            }
            case 197: {
                return String.valueOf(new StringBuilder().append(lllllllllllllIIIIIIlIIllIIIIllIl).append(" ").append(classInfo(lllllllllllllIIIIIIlIIllIIIIlIlI, lllllllllllllIIIIIIlIIllIIIIllII.u16bitAt(lllllllllllllIIIIIIlIIllIIIIlIll + 1))));
            }
            case 200:
            case 201: {
                return String.valueOf(new StringBuilder().append(lllllllllllllIIIIIIlIIllIIIIllIl).append(" ").append(lllllllllllllIIIIIIlIIllIIIIllII.s32bitAt(lllllllllllllIIIIIIlIIllIIIIlIll + 1) + lllllllllllllIIIIIIlIIllIIIIlIll));
            }
            default: {
                return lllllllllllllIIIIIIlIIllIIIIllIl;
            }
        }
    }
    
    private static String ldc(final ConstPool lllllllllllllIIIIIIlIIlIlIlIlIlI, final int lllllllllllllIIIIIIlIIlIlIlIlIIl) {
        final int lllllllllllllIIIIIIlIIlIlIlIlIII = lllllllllllllIIIIIIlIIlIlIlIlIlI.getTag(lllllllllllllIIIIIIlIIlIlIlIlIIl);
        switch (lllllllllllllIIIIIIlIIlIlIlIlIII) {
            case 8: {
                return String.valueOf(new StringBuilder().append("#").append(lllllllllllllIIIIIIlIIlIlIlIlIIl).append(" = \"").append(lllllllllllllIIIIIIlIIlIlIlIlIlI.getStringInfo(lllllllllllllIIIIIIlIIlIlIlIlIIl)).append("\""));
            }
            case 3: {
                return String.valueOf(new StringBuilder().append("#").append(lllllllllllllIIIIIIlIIlIlIlIlIIl).append(" = int ").append(lllllllllllllIIIIIIlIIlIlIlIlIlI.getIntegerInfo(lllllllllllllIIIIIIlIIlIlIlIlIIl)));
            }
            case 4: {
                return String.valueOf(new StringBuilder().append("#").append(lllllllllllllIIIIIIlIIlIlIlIlIIl).append(" = float ").append(lllllllllllllIIIIIIlIIlIlIlIlIlI.getFloatInfo(lllllllllllllIIIIIIlIIlIlIlIlIIl)));
            }
            case 5: {
                return String.valueOf(new StringBuilder().append("#").append(lllllllllllllIIIIIIlIIlIlIlIlIIl).append(" = long ").append(lllllllllllllIIIIIIlIIlIlIlIlIlI.getLongInfo(lllllllllllllIIIIIIlIIlIlIlIlIIl)));
            }
            case 6: {
                return String.valueOf(new StringBuilder().append("#").append(lllllllllllllIIIIIIlIIlIlIlIlIIl).append(" = double ").append(lllllllllllllIIIIIIlIIlIlIlIlIlI.getDoubleInfo(lllllllllllllIIIIIIlIIlIlIlIlIIl)));
            }
            case 7: {
                return classInfo(lllllllllllllIIIIIIlIIlIlIlIlIlI, lllllllllllllIIIIIIlIIlIlIlIlIIl);
            }
            default: {
                throw new RuntimeException(String.valueOf(new StringBuilder().append("bad LDC: ").append(lllllllllllllIIIIIIlIIlIlIlIlIII)));
            }
        }
    }
    
    private static String arrayInfo(final int lllllllllllllIIIIIIlIIlIlllllIlI) {
        switch (lllllllllllllIIIIIIlIIlIlllllIlI) {
            case 4: {
                return "boolean";
            }
            case 5: {
                return "char";
            }
            case 8: {
                return "byte";
            }
            case 9: {
                return "short";
            }
            case 10: {
                return "int";
            }
            case 11: {
                return "long";
            }
            case 6: {
                return "float";
            }
            case 7: {
                return "double";
            }
            default: {
                throw new RuntimeException("Invalid array type");
            }
        }
    }
    
    private static String classInfo(final ConstPool lllllllllllllIIIIIIlIIlIllllIllI, final int lllllllllllllIIIIIIlIIlIllllIIll) {
        return String.valueOf(new StringBuilder().append("#").append(lllllllllllllIIIIIIlIIlIllllIIll).append(" = Class ").append(lllllllllllllIIIIIIlIIlIllllIllI.getClassInfo(lllllllllllllIIIIIIlIIlIllllIIll)));
    }
    
    private static String lookupSwitch(final CodeIterator lllllllllllllIIIIIIlIIlIllIlIllI, final int lllllllllllllIIIIIIlIIlIllIlIlIl) {
        final StringBuffer lllllllllllllIIIIIIlIIlIllIlIlII = new StringBuffer("lookupswitch {\n");
        int lllllllllllllIIIIIIlIIlIllIlIIll = (lllllllllllllIIIIIIlIIlIllIlIlIl & 0xFFFFFFFC) + 4;
        lllllllllllllIIIIIIlIIlIllIlIlII.append("\t\tdefault: ").append(lllllllllllllIIIIIIlIIlIllIlIlIl + lllllllllllllIIIIIIlIIlIllIlIllI.s32bitAt(lllllllllllllIIIIIIlIIlIllIlIIll)).append("\n");
        lllllllllllllIIIIIIlIIlIllIlIIll += 4;
        final int lllllllllllllIIIIIIlIIlIllIlIIlI = lllllllllllllIIIIIIlIIlIllIlIllI.s32bitAt(lllllllllllllIIIIIIlIIlIllIlIIll);
        final int n = lllllllllllllIIIIIIlIIlIllIlIIlI * 8;
        lllllllllllllIIIIIIlIIlIllIlIIll += 4;
        for (int lllllllllllllIIIIIIlIIlIllIlIIIl = n + lllllllllllllIIIIIIlIIlIllIlIIll; lllllllllllllIIIIIIlIIlIllIlIIll < lllllllllllllIIIIIIlIIlIllIlIIIl; lllllllllllllIIIIIIlIIlIllIlIIll += 8) {
            final int lllllllllllllIIIIIIlIIlIllIllIII = lllllllllllllIIIIIIlIIlIllIlIllI.s32bitAt(lllllllllllllIIIIIIlIIlIllIlIIll);
            final int lllllllllllllIIIIIIlIIlIllIlIlll = lllllllllllllIIIIIIlIIlIllIlIllI.s32bitAt(lllllllllllllIIIIIIlIIlIllIlIIll + 4) + lllllllllllllIIIIIIlIIlIllIlIlIl;
            lllllllllllllIIIIIIlIIlIllIlIlII.append("\t\t").append(lllllllllllllIIIIIIlIIlIllIllIII).append(": ").append(lllllllllllllIIIIIIlIIlIllIlIlll).append("\n");
        }
        lllllllllllllIIIIIIlIIlIllIlIlII.setCharAt(lllllllllllllIIIIIIlIIlIllIlIlII.length() - 1, '}');
        return lllllllllllllIIIIIIlIIlIllIlIlII.toString();
    }
    
    private static String tableSwitch(final CodeIterator lllllllllllllIIIIIIlIIlIlIllllIl, final int lllllllllllllIIIIIIlIIlIlIllIlIl) {
        final StringBuffer lllllllllllllIIIIIIlIIlIlIlllIll = new StringBuffer("tableswitch {\n");
        int lllllllllllllIIIIIIlIIlIlIlllIlI = (lllllllllllllIIIIIIlIIlIlIllIlIl & 0xFFFFFFFC) + 4;
        lllllllllllllIIIIIIlIIlIlIlllIll.append("\t\tdefault: ").append(lllllllllllllIIIIIIlIIlIlIllIlIl + lllllllllllllIIIIIIlIIlIlIllllIl.s32bitAt(lllllllllllllIIIIIIlIIlIlIlllIlI)).append("\n");
        lllllllllllllIIIIIIlIIlIlIlllIlI += 4;
        final int lllllllllllllIIIIIIlIIlIlIlllIIl = lllllllllllllIIIIIIlIIlIlIllllIl.s32bitAt(lllllllllllllIIIIIIlIIlIlIlllIlI);
        lllllllllllllIIIIIIlIIlIlIlllIlI += 4;
        final int lllllllllllllIIIIIIlIIlIlIlllIII = lllllllllllllIIIIIIlIIlIlIllllIl.s32bitAt(lllllllllllllIIIIIIlIIlIlIlllIlI);
        final int n = (lllllllllllllIIIIIIlIIlIlIlllIII - lllllllllllllIIIIIIlIIlIlIlllIIl + 1) * 4;
        lllllllllllllIIIIIIlIIlIlIlllIlI += 4;
        for (int lllllllllllllIIIIIIlIIlIlIllIlll = n + lllllllllllllIIIIIIlIIlIlIlllIlI, lllllllllllllIIIIIIlIIlIlIlllllI = lllllllllllllIIIIIIlIIlIlIlllIIl; lllllllllllllIIIIIIlIIlIlIlllIlI < lllllllllllllIIIIIIlIIlIlIllIlll; lllllllllllllIIIIIIlIIlIlIlllIlI += 4, ++lllllllllllllIIIIIIlIIlIlIlllllI) {
            final int lllllllllllllIIIIIIlIIlIlIllllll = lllllllllllllIIIIIIlIIlIlIllllIl.s32bitAt(lllllllllllllIIIIIIlIIlIlIlllIlI) + lllllllllllllIIIIIIlIIlIlIllIlIl;
            lllllllllllllIIIIIIlIIlIlIlllIll.append("\t\t").append(lllllllllllllIIIIIIlIIlIlIlllllI).append(": ").append(lllllllllllllIIIIIIlIIlIlIllllll).append("\n");
        }
        lllllllllllllIIIIIIlIIlIlIlllIll.setCharAt(lllllllllllllIIIIIIlIIlIlIlllIll.length() - 1, '}');
        return lllllllllllllIIIIIIlIIlIlIlllIll.toString();
    }
    
    private static String methodInfo(final ConstPool lllllllllllllIIIIIIlIIlIlllIlIlI, final int lllllllllllllIIIIIIlIIlIlllIIlll) {
        return String.valueOf(new StringBuilder().append("#").append(lllllllllllllIIIIIIlIIlIlllIIlll).append(" = Method ").append(lllllllllllllIIIIIIlIIlIlllIlIlI.getMethodrefClassName(lllllllllllllIIIIIIlIIlIlllIIlll)).append(".").append(lllllllllllllIIIIIIlIIlIlllIlIlI.getMethodrefName(lllllllllllllIIIIIIlIIlIlllIIlll)).append("(").append(lllllllllllllIIIIIIlIIlIlllIlIlI.getMethodrefType(lllllllllllllIIIIIIlIIlIlllIIlll)).append(")"));
    }
}
