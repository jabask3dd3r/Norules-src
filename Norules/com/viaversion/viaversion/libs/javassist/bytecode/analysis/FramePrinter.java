package com.viaversion.viaversion.libs.javassist.bytecode.analysis;

import java.io.*;
import com.viaversion.viaversion.libs.javassist.bytecode.*;
import com.viaversion.viaversion.libs.javassist.*;

public final class FramePrinter
{
    private final /* synthetic */ PrintStream stream;
    
    public void print(final CtMethod lllllllllllllllIlllIllllllllIllI) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        com/viaversion/viaversion/libs/javassist/bytecode/analysis/FramePrinter.stream:Ljava/io/PrintStream;
        //     4: new             Ljava/lang/StringBuilder;
        //     7: dup            
        //     8: invokespecial   java/lang/StringBuilder.<init>:()V
        //    11: ldc             "\n"
        //    13: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    16: aload_0         /* lllllllllllllllIlllIlllllllIllll */
        //    17: aload_1         /* lllllllllllllllIlllIlllllllIlllI */
        //    18: invokespecial   com/viaversion/viaversion/libs/javassist/bytecode/analysis/FramePrinter.getMethodString:(Lcom/viaversion/viaversion/libs/javassist/CtMethod;)Ljava/lang/String;
        //    21: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    24: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //    27: invokevirtual   java/io/PrintStream.println:(Ljava/lang/String;)V
        //    30: aload_1         /* lllllllllllllllIlllIlllllllIlllI */
        //    31: invokevirtual   com/viaversion/viaversion/libs/javassist/CtMethod.getMethodInfo2:()Lcom/viaversion/viaversion/libs/javassist/bytecode/MethodInfo;
        //    34: astore_2        /* lllllllllllllllIlllIlllllllIllIl */
        //    35: aload_2         /* lllllllllllllllIlllIllllllllIlIl */
        //    36: invokevirtual   com/viaversion/viaversion/libs/javassist/bytecode/MethodInfo.getConstPool:()Lcom/viaversion/viaversion/libs/javassist/bytecode/ConstPool;
        //    39: astore_3        /* lllllllllllllllIlllIllllllllIlII */
        //    40: aload_2         /* lllllllllllllllIlllIllllllllIlIl */
        //    41: invokevirtual   com/viaversion/viaversion/libs/javassist/bytecode/MethodInfo.getCodeAttribute:()Lcom/viaversion/viaversion/libs/javassist/bytecode/CodeAttribute;
        //    44: astore          lllllllllllllllIlllIllllllllIIll
        //    46: aload           lllllllllllllllIlllIllllllllIIll
        //    48: ifnonnull       52
        //    51: return         
        //    52: new             Lcom/viaversion/viaversion/libs/javassist/bytecode/analysis/Analyzer;
        //    55: dup            
        //    56: invokespecial   com/viaversion/viaversion/libs/javassist/bytecode/analysis/Analyzer.<init>:()V
        //    59: aload_1         /* lllllllllllllllIlllIlllllllIlllI */
        //    60: invokevirtual   com/viaversion/viaversion/libs/javassist/CtMethod.getDeclaringClass:()Lcom/viaversion/viaversion/libs/javassist/CtClass;
        //    63: aload_2         /* lllllllllllllllIlllIllllllllIlIl */
        //    64: invokevirtual   com/viaversion/viaversion/libs/javassist/bytecode/analysis/Analyzer.analyze:(Lcom/viaversion/viaversion/libs/javassist/CtClass;Lcom/viaversion/viaversion/libs/javassist/bytecode/MethodInfo;)[Lcom/viaversion/viaversion/libs/javassist/bytecode/analysis/Frame;
        //    67: astore          lllllllllllllllIlllIllllllllllIl
        //    69: goto            84
        //    72: astore          lllllllllllllllIlllIllllllllllII
        //    74: new             Ljava/lang/RuntimeException;
        //    77: dup            
        //    78: aload           lllllllllllllllIlllIllllllllllII
        //    80: invokespecial   java/lang/RuntimeException.<init>:(Ljava/lang/Throwable;)V
        //    83: athrow         
        //    84: aload           lllllllllllllllIlllIllllllllIIll
        //    86: invokevirtual   com/viaversion/viaversion/libs/javassist/bytecode/CodeAttribute.getCodeLength:()I
        //    89: invokestatic    java/lang/String.valueOf:(I)Ljava/lang/String;
        //    92: invokevirtual   java/lang/String.length:()I
        //    95: istore          lllllllllllllllIlllIllllllllIIIl
        //    97: aload           lllllllllllllllIlllIllllllllIIll
        //    99: invokevirtual   com/viaversion/viaversion/libs/javassist/bytecode/CodeAttribute.iterator:()Lcom/viaversion/viaversion/libs/javassist/bytecode/CodeIterator;
        //   102: astore          lllllllllllllllIlllIllllllllIIII
        //   104: aload           lllllllllllllllIlllIllllllllIIII
        //   106: invokevirtual   com/viaversion/viaversion/libs/javassist/bytecode/CodeIterator.hasNext:()Z
        //   109: ifeq            227
        //   112: aload           lllllllllllllllIlllIllllllllIIII
        //   114: invokevirtual   com/viaversion/viaversion/libs/javassist/bytecode/CodeIterator.next:()I
        //   117: istore          lllllllllllllllIlllIlllllllllIll
        //   119: goto            134
        //   122: astore          lllllllllllllllIlllIlllllllllIlI
        //   124: new             Ljava/lang/RuntimeException;
        //   127: dup            
        //   128: aload           lllllllllllllllIlllIlllllllllIlI
        //   130: invokespecial   java/lang/RuntimeException.<init>:(Ljava/lang/Throwable;)V
        //   133: athrow         
        //   134: aload_0         /* lllllllllllllllIlllIlllllllIllll */
        //   135: getfield        com/viaversion/viaversion/libs/javassist/bytecode/analysis/FramePrinter.stream:Ljava/io/PrintStream;
        //   138: new             Ljava/lang/StringBuilder;
        //   141: dup            
        //   142: invokespecial   java/lang/StringBuilder.<init>:()V
        //   145: iload           lllllllllllllllIlllIlllllllllIIl
        //   147: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   150: ldc             ": "
        //   152: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   155: aload           lllllllllllllllIlllIllllllllIIII
        //   157: iload           lllllllllllllllIlllIlllllllllIIl
        //   159: aload_3         /* lllllllllllllllIlllIllllllllIlII */
        //   160: invokestatic    com/viaversion/viaversion/libs/javassist/bytecode/InstructionPrinter.instructionString:(Lcom/viaversion/viaversion/libs/javassist/bytecode/CodeIterator;ILcom/viaversion/viaversion/libs/javassist/bytecode/ConstPool;)Ljava/lang/String;
        //   163: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   166: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   169: invokevirtual   java/io/PrintStream.println:(Ljava/lang/String;)V
        //   172: aload_0         /* lllllllllllllllIlllIlllllllIllll */
        //   173: iload           lllllllllllllllIlllIllllllllIIIl
        //   175: iconst_3       
        //   176: iadd           
        //   177: invokespecial   com/viaversion/viaversion/libs/javassist/bytecode/analysis/FramePrinter.addSpacing:(I)V
        //   180: aload           lllllllllllllllIlllIllllllllIIlI
        //   182: iload           lllllllllllllllIlllIlllllllllIIl
        //   184: aaload         
        //   185: astore          lllllllllllllllIlllIlllllllllIII
        //   187: aload           lllllllllllllllIlllIlllllllllIII
        //   189: ifnonnull       204
        //   192: aload_0         /* lllllllllllllllIlllIlllllllIllll */
        //   193: getfield        com/viaversion/viaversion/libs/javassist/bytecode/analysis/FramePrinter.stream:Ljava/io/PrintStream;
        //   196: ldc             "--DEAD CODE--"
        //   198: invokevirtual   java/io/PrintStream.println:(Ljava/lang/String;)V
        //   201: goto            104
        //   204: aload_0         /* lllllllllllllllIlllIlllllllIllll */
        //   205: aload           lllllllllllllllIlllIlllllllllIII
        //   207: invokespecial   com/viaversion/viaversion/libs/javassist/bytecode/analysis/FramePrinter.printStack:(Lcom/viaversion/viaversion/libs/javassist/bytecode/analysis/Frame;)V
        //   210: aload_0         /* lllllllllllllllIlllIlllllllIllll */
        //   211: iload           lllllllllllllllIlllIllllllllIIIl
        //   213: iconst_3       
        //   214: iadd           
        //   215: invokespecial   com/viaversion/viaversion/libs/javassist/bytecode/analysis/FramePrinter.addSpacing:(I)V
        //   218: aload_0         /* lllllllllllllllIlllIlllllllIllll */
        //   219: aload           lllllllllllllllIlllIlllllllllIII
        //   221: invokespecial   com/viaversion/viaversion/libs/javassist/bytecode/analysis/FramePrinter.printLocals:(Lcom/viaversion/viaversion/libs/javassist/bytecode/analysis/Frame;)V
        //   224: goto            104
        //   227: return         
        //    StackMapTable: 00 08 FE 00 34 07 00 30 07 00 A2 07 00 4A 53 07 00 0A FC 00 0B 07 00 A3 FD 00 13 01 07 00 5A 51 07 00 0A FC 00 0B 01 FC 00 45 07 00 A5 F9 00 16
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                                           
        //  -----  -----  -----  -----  ---------------------------------------------------------------
        //  52     69     72     84     Lcom/viaversion/viaversion/libs/javassist/bytecode/BadBytecode;
        //  112    119    122    134    Lcom/viaversion/viaversion/libs/javassist/bytecode/BadBytecode;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private void printStack(final Frame lllllllllllllllIlllIllllllIllIlI) {
        this.stream.print("stack [");
        for (int lllllllllllllllIlllIllllllIlllII = lllllllllllllllIlllIllllllIllIlI.getTopIndex(), lllllllllllllllIlllIllllllIlllll = 0; lllllllllllllllIlllIllllllIlllll <= lllllllllllllllIlllIllllllIlllII; ++lllllllllllllllIlllIllllllIlllll) {
            if (lllllllllllllllIlllIllllllIlllll > 0) {
                this.stream.print(", ");
            }
            final Type lllllllllllllllIlllIlllllllIIIII = lllllllllllllllIlllIllllllIllIlI.getStack(lllllllllllllllIlllIllllllIlllll);
            this.stream.print(lllllllllllllllIlllIlllllllIIIII);
        }
        this.stream.println("]");
    }
    
    private void printLocals(final Frame lllllllllllllllIlllIllllllIIlIll) {
        this.stream.print("locals [");
        for (int lllllllllllllllIlllIllllllIIllIl = lllllllllllllllIlllIllllllIIlIll.localsLength(), lllllllllllllllIlllIllllllIlIIII = 0; lllllllllllllllIlllIllllllIlIIII < lllllllllllllllIlllIllllllIIllIl; ++lllllllllllllllIlllIllllllIlIIII) {
            if (lllllllllllllllIlllIllllllIlIIII > 0) {
                this.stream.print(", ");
            }
            final Type lllllllllllllllIlllIllllllIlIIIl = lllllllllllllllIlllIllllllIIlIll.getLocal(lllllllllllllllIlllIllllllIlIIII);
            this.stream.print((lllllllllllllllIlllIllllllIlIIIl == null) ? "empty" : lllllllllllllllIlllIllllllIlIIIl.toString());
        }
        this.stream.println("]");
    }
    
    private String getMethodString(final CtMethod lllllllllllllllIllllIIIIIIIIlIIl) {
        try {
            return String.valueOf(new StringBuilder().append(Modifier.toString(lllllllllllllllIllllIIIIIIIIlIIl.getModifiers())).append(" ").append(lllllllllllllllIllllIIIIIIIIlIIl.getReturnType().getName()).append(" ").append(lllllllllllllllIllllIIIIIIIIlIIl.getName()).append(Descriptor.toString(lllllllllllllllIllllIIIIIIIIlIIl.getSignature())).append(";"));
        }
        catch (NotFoundException lllllllllllllllIllllIIIIIIIIllII) {
            throw new RuntimeException(lllllllllllllllIllllIIIIIIIIllII);
        }
    }
    
    public FramePrinter(final PrintStream lllllllllllllllIllllIIIIIIlIIIll) {
        this.stream = lllllllllllllllIllllIIIIIIlIIIll;
    }
    
    public static void print(final CtClass lllllllllllllllIllllIIIIIIIllllI, final PrintStream lllllllllllllllIllllIIIIIIIllIll) {
        new FramePrinter(lllllllllllllllIllllIIIIIIIllIll).print(lllllllllllllllIllllIIIIIIIllllI);
    }
    
    public void print(final CtClass lllllllllllllllIllllIIIIIIIlIIIl) {
        final CtMethod[] lllllllllllllllIllllIIIIIIIlIIll = lllllllllllllllIllllIIIIIIIlIIIl.getDeclaredMethods();
        for (int lllllllllllllllIllllIIIIIIIlIllI = 0; lllllllllllllllIllllIIIIIIIlIllI < lllllllllllllllIllllIIIIIIIlIIll.length; ++lllllllllllllllIllllIIIIIIIlIllI) {
            this.print(lllllllllllllllIllllIIIIIIIlIIll[lllllllllllllllIllllIIIIIIIlIllI]);
        }
    }
    
    private void addSpacing(int lllllllllllllllIlllIllllllIIIIlI) {
        while (lllllllllllllllIlllIllllllIIIIlI-- > 0) {
            this.stream.print(' ');
        }
    }
}
