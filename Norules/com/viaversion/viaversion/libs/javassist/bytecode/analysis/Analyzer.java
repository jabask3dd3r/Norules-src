package com.viaversion.viaversion.libs.javassist.bytecode.analysis;

import com.viaversion.viaversion.libs.javassist.bytecode.*;
import com.viaversion.viaversion.libs.javassist.*;

public class Analyzer implements Opcode
{
    private /* synthetic */ Frame[] frames;
    private /* synthetic */ Subroutine[] subroutines;
    private /* synthetic */ ExceptionInfo[] exceptions;
    private /* synthetic */ CtClass clazz;
    private final /* synthetic */ SubroutineScanner scanner;
    
    public Analyzer() {
        this.scanner = new SubroutineScanner();
    }
    
    private int getNext(final CodeIterator llllllllllllllIlIIIIlIllIlIIlllI, final int llllllllllllllIlIIIIlIllIlIIllIl, final int llllllllllllllIlIIIIlIllIlIIllII) throws BadBytecode {
        llllllllllllllIlIIIIlIllIlIIlllI.move(llllllllllllllIlIIIIlIllIlIIllIl);
        llllllllllllllIlIIIIlIllIlIIlllI.next();
        final int llllllllllllllIlIIIIlIllIlIIlIll = llllllllllllllIlIIIIlIllIlIIlllI.lookAhead();
        llllllllllllllIlIIIIlIllIlIIlllI.move(llllllllllllllIlIIIIlIllIlIIllII);
        llllllllllllllIlIIIIlIllIlIIlllI.next();
        return llllllllllllllIlIIIIlIllIlIIlIll;
    }
    
    public Frame[] analyze(final CtClass llllllllllllllIlIIIIlIllllIIIlll, final MethodInfo llllllllllllllIlIIIIlIlllIllllII) throws BadBytecode {
        this.clazz = llllllllllllllIlIIIIlIllllIIIlll;
        final CodeAttribute llllllllllllllIlIIIIlIllllIIIlIl = llllllllllllllIlIIIIlIlllIllllII.getCodeAttribute();
        if (llllllllllllllIlIIIIlIllllIIIlIl == null) {
            return null;
        }
        final int llllllllllllllIlIIIIlIllllIIIlII = llllllllllllllIlIIIIlIllllIIIlIl.getMaxLocals();
        final int llllllllllllllIlIIIIlIllllIIIIll = llllllllllllllIlIIIIlIllllIIIlIl.getMaxStack();
        final int llllllllllllllIlIIIIlIllllIIIIlI = llllllllllllllIlIIIIlIllllIIIlIl.getCodeLength();
        final CodeIterator llllllllllllllIlIIIIlIllllIIIIIl = llllllllllllllIlIIIIlIllllIIIlIl.iterator();
        final IntQueue llllllllllllllIlIIIIlIllllIIIIII = new IntQueue();
        this.exceptions = this.buildExceptionInfo(llllllllllllllIlIIIIlIlllIllllII);
        this.subroutines = this.scanner.scan(llllllllllllllIlIIIIlIlllIllllII);
        final Executor llllllllllllllIlIIIIlIlllIllllll = new Executor(llllllllllllllIlIIIIlIllllIIIlll.getClassPool(), llllllllllllllIlIIIIlIlllIllllII.getConstPool());
        this.frames = new Frame[llllllllllllllIlIIIIlIllllIIIIlI];
        this.frames[llllllllllllllIlIIIIlIllllIIIIIl.lookAhead()] = this.firstFrame(llllllllllllllIlIIIIlIlllIllllII, llllllllllllllIlIIIIlIllllIIIlII, llllllllllllllIlIIIIlIllllIIIIll);
        llllllllllllllIlIIIIlIllllIIIIII.add(llllllllllllllIlIIIIlIllllIIIIIl.next());
        while (!llllllllllllllIlIIIIlIllllIIIIII.isEmpty()) {
            this.analyzeNextEntry(llllllllllllllIlIIIIlIlllIllllII, llllllllllllllIlIIIIlIllllIIIIIl, llllllllllllllIlIIIIlIllllIIIIII, llllllllllllllIlIIIIlIlllIllllll);
        }
        return this.frames;
    }
    
    public Frame[] analyze(final CtMethod llllllllllllllIlIIIIlIlllIlIllll) throws BadBytecode {
        return this.analyze(llllllllllllllIlIIIIlIlllIlIllll.getDeclaringClass(), llllllllllllllIlIIIIlIlllIlIllll.getMethodInfo2());
    }
    
    private int lookAhead(final CodeIterator llllllllllllllIlIIIIlIllIlIIIIIl, final int llllllllllllllIlIIIIlIllIlIIIIII) throws BadBytecode {
        if (!llllllllllllllIlIIIIlIllIlIIIIIl.hasNext()) {
            throw new BadBytecode(String.valueOf(new StringBuilder().append("Execution falls off end! [pos = ").append(llllllllllllllIlIIIIlIllIlIIIIII).append("]")));
        }
        return llllllllllllllIlIIIIlIllIlIIIIIl.lookAhead();
    }
    
    private Type zeroExtend(final Type llllllllllllllIlIIIIlIlIlIIIlllI) {
        if (llllllllllllllIlIIIIlIlIlIIIlllI == Type.SHORT || llllllllllllllIlIIIIlIlIlIIIlllI == Type.BYTE || llllllllllllllIlIIIIlIlIlIIIlllI == Type.CHAR || llllllllllllllIlIIIIlIlIlIIIlllI == Type.BOOLEAN) {
            return Type.INTEGER;
        }
        return llllllllllllllIlIIIIlIlIlIIIlllI;
    }
    
    private void mergeRet(final IntQueue llllllllllllllIlIIIIlIlIlIllllIl, final CodeIterator llllllllllllllIlIIIIlIlIllIIIIlI, final int llllllllllllllIlIIIIlIlIlIlllIll, final Frame llllllllllllllIlIIIIlIlIllIIIIII, final Subroutine llllllllllllllIlIIIIlIlIlIlllIIl) throws BadBytecode {
        if (llllllllllllllIlIIIIlIlIlIlllIIl == null) {
            throw new BadBytecode(String.valueOf(new StringBuilder().append("Ret on no subroutine! [pos = ").append(llllllllllllllIlIIIIlIlIlIlllIll).append("]")));
        }
        for (final int llllllllllllllIlIIIIlIlIllIIIlIl : llllllllllllllIlIIIIlIlIlIlllIIl.callers()) {
            final int llllllllllllllIlIIIIlIlIllIIlIII = this.getNext(llllllllllllllIlIIIIlIlIllIIIIlI, llllllllllllllIlIIIIlIlIllIIIlIl, llllllllllllllIlIIIIlIlIlIlllIll);
            boolean llllllllllllllIlIIIIlIlIllIIIlll = false;
            Frame llllllllllllllIlIIIIlIlIllIIIllI = this.frames[llllllllllllllIlIIIIlIlIllIIlIII];
            if (llllllllllllllIlIIIIlIlIllIIIllI == null) {
                final Frame[] frames = this.frames;
                final int n = llllllllllllllIlIIIIlIlIllIIlIII;
                final Frame copyStack = llllllllllllllIlIIIIlIlIllIIIIII.copyStack();
                frames[n] = copyStack;
                llllllllllllllIlIIIIlIlIllIIIllI = copyStack;
                llllllllllllllIlIIIIlIlIllIIIlll = true;
            }
            else {
                llllllllllllllIlIIIIlIlIllIIIlll = llllllllllllllIlIIIIlIlIllIIIllI.mergeStack(llllllllllllllIlIIIIlIlIllIIIIII);
            }
            for (final int llllllllllllllIlIIIIlIlIllIIlIIl : llllllllllllllIlIIIIlIlIlIlllIIl.accessed()) {
                final Type llllllllllllllIlIIIIlIlIllIIlIll = llllllllllllllIlIIIIlIlIllIIIllI.getLocal(llllllllllllllIlIIIIlIlIllIIlIIl);
                final Type llllllllllllllIlIIIIlIlIllIIlIlI = llllllllllllllIlIIIIlIlIllIIIIII.getLocal(llllllllllllllIlIIIIlIlIllIIlIIl);
                if (llllllllllllllIlIIIIlIlIllIIlIll != llllllllllllllIlIIIIlIlIllIIlIlI) {
                    llllllllllllllIlIIIIlIlIllIIIllI.setLocal(llllllllllllllIlIIIIlIlIllIIlIIl, llllllllllllllIlIIIIlIlIllIIlIlI);
                    llllllllllllllIlIIIIlIlIllIIIlll = true;
                }
            }
            if (!llllllllllllllIlIIIIlIlIllIIIllI.isRetMerged()) {
                llllllllllllllIlIIIIlIlIllIIIllI.setRetMerged(true);
                llllllllllllllIlIIIIlIlIllIIIlll = true;
            }
            if (llllllllllllllIlIIIIlIlIllIIIlll && llllllllllllllIlIIIIlIlIllIIIllI.isJsrMerged()) {
                llllllllllllllIlIIIIlIlIlIllllIl.add(llllllllllllllIlIIIIlIlIllIIlIII);
            }
        }
    }
    
    private Frame firstFrame(final MethodInfo llllllllllllllIlIIIIlIllIllIIIlI, final int llllllllllllllIlIIIIlIllIlIllIlI, final int llllllllllllllIlIIIIlIllIlIllIIl) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: istore          llllllllllllllIlIIIIlIllIlIlllll
        //     3: new             Lcom/viaversion/viaversion/libs/javassist/bytecode/analysis/Frame;
        //     6: dup            
        //     7: iload_2         /* llllllllllllllIlIIIIlIllIllIIIIl */
        //     8: iload_3         /* llllllllllllllIlIIIIlIllIllIIIII */
        //     9: invokespecial   com/viaversion/viaversion/libs/javassist/bytecode/analysis/Frame.<init>:(II)V
        //    12: astore          llllllllllllllIlIIIIlIllIlIllllI
        //    14: aload_1         /* llllllllllllllIlIIIIlIllIlIllIll */
        //    15: invokevirtual   com/viaversion/viaversion/libs/javassist/bytecode/MethodInfo.getAccessFlags:()I
        //    18: bipush          8
        //    20: iand           
        //    21: ifne            41
        //    24: aload           llllllllllllllIlIIIIlIllIlIllllI
        //    26: iload           llllllllllllllIlIIIIlIllIlIlllll
        //    28: iinc            llllllllllllllIlIIIIlIllIlIlllll, 1
        //    31: aload_0         /* llllllllllllllIlIIIIlIllIllIIIll */
        //    32: getfield        com/viaversion/viaversion/libs/javassist/bytecode/analysis/Analyzer.clazz:Lcom/viaversion/viaversion/libs/javassist/CtClass;
        //    35: invokestatic    com/viaversion/viaversion/libs/javassist/bytecode/analysis/Type.get:(Lcom/viaversion/viaversion/libs/javassist/CtClass;)Lcom/viaversion/viaversion/libs/javassist/bytecode/analysis/Type;
        //    38: invokevirtual   com/viaversion/viaversion/libs/javassist/bytecode/analysis/Frame.setLocal:(ILcom/viaversion/viaversion/libs/javassist/bytecode/analysis/Type;)V
        //    41: aload_1         /* llllllllllllllIlIIIIlIllIlIllIll */
        //    42: invokevirtual   com/viaversion/viaversion/libs/javassist/bytecode/MethodInfo.getDescriptor:()Ljava/lang/String;
        //    45: aload_0         /* llllllllllllllIlIIIIlIllIllIIIll */
        //    46: getfield        com/viaversion/viaversion/libs/javassist/bytecode/analysis/Analyzer.clazz:Lcom/viaversion/viaversion/libs/javassist/CtClass;
        //    49: invokevirtual   com/viaversion/viaversion/libs/javassist/CtClass.getClassPool:()Lcom/viaversion/viaversion/libs/javassist/ClassPool;
        //    52: invokestatic    com/viaversion/viaversion/libs/javassist/bytecode/Descriptor.getParameterTypes:(Ljava/lang/String;Lcom/viaversion/viaversion/libs/javassist/ClassPool;)[Lcom/viaversion/viaversion/libs/javassist/CtClass;
        //    55: astore          llllllllllllllIlIIIIlIllIllIIlll
        //    57: goto            72
        //    60: astore          llllllllllllllIlIIIIlIllIllIIllI
        //    62: new             Ljava/lang/RuntimeException;
        //    65: dup            
        //    66: aload           llllllllllllllIlIIIIlIllIllIIllI
        //    68: invokespecial   java/lang/RuntimeException.<init>:(Ljava/lang/Throwable;)V
        //    71: athrow         
        //    72: iconst_0       
        //    73: istore          llllllllllllllIlIIIIlIllIllIIlII
        //    75: iload           llllllllllllllIlIIIIlIllIllIIlII
        //    77: aload           llllllllllllllIlIIIIlIllIlIlllIl
        //    79: arraylength    
        //    80: if_icmpge       137
        //    83: aload_0         /* llllllllllllllIlIIIIlIllIllIIIll */
        //    84: aload           llllllllllllllIlIIIIlIllIlIlllIl
        //    86: iload           llllllllllllllIlIIIIlIllIllIIlII
        //    88: aaload         
        //    89: invokestatic    com/viaversion/viaversion/libs/javassist/bytecode/analysis/Type.get:(Lcom/viaversion/viaversion/libs/javassist/CtClass;)Lcom/viaversion/viaversion/libs/javassist/bytecode/analysis/Type;
        //    92: invokespecial   com/viaversion/viaversion/libs/javassist/bytecode/analysis/Analyzer.zeroExtend:(Lcom/viaversion/viaversion/libs/javassist/bytecode/analysis/Type;)Lcom/viaversion/viaversion/libs/javassist/bytecode/analysis/Type;
        //    95: astore          llllllllllllllIlIIIIlIllIllIIlIl
        //    97: aload           llllllllllllllIlIIIIlIllIlIllllI
        //    99: iload           llllllllllllllIlIIIIlIllIlIlllll
        //   101: iinc            llllllllllllllIlIIIIlIllIlIlllll, 1
        //   104: aload           llllllllllllllIlIIIIlIllIllIIlIl
        //   106: invokevirtual   com/viaversion/viaversion/libs/javassist/bytecode/analysis/Frame.setLocal:(ILcom/viaversion/viaversion/libs/javassist/bytecode/analysis/Type;)V
        //   109: aload           llllllllllllllIlIIIIlIllIllIIlIl
        //   111: invokevirtual   com/viaversion/viaversion/libs/javassist/bytecode/analysis/Type.getSize:()I
        //   114: iconst_2       
        //   115: if_icmpne       131
        //   118: aload           llllllllllllllIlIIIIlIllIlIllllI
        //   120: iload           llllllllllllllIlIIIIlIllIlIlllll
        //   122: iinc            llllllllllllllIlIIIIlIllIlIlllll, 1
        //   125: getstatic       com/viaversion/viaversion/libs/javassist/bytecode/analysis/Type.TOP:Lcom/viaversion/viaversion/libs/javassist/bytecode/analysis/Type;
        //   128: invokevirtual   com/viaversion/viaversion/libs/javassist/bytecode/analysis/Frame.setLocal:(ILcom/viaversion/viaversion/libs/javassist/bytecode/analysis/Type;)V
        //   131: iinc            llllllllllllllIlIIIIlIllIllIIlII, 1
        //   134: goto            75
        //   137: aload           llllllllllllllIlIIIIlIllIlIllllI
        //   139: areturn        
        //    StackMapTable: 00 06 FD 00 29 01 07 00 7A 52 07 01 4A FC 00 0B 07 01 82 FC 00 02 01 FC 00 37 07 00 DD FA 00 05
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                                        
        //  -----  -----  -----  -----  ------------------------------------------------------------
        //  41     57     60     72     Lcom/viaversion/viaversion/libs/javassist/NotFoundException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private void merge(final IntQueue llllllllllllllIlIIIIlIllIIllIlll, final Frame llllllllllllllIlIIIIlIllIIllIIII, final int llllllllllllllIlIIIIlIllIIlIllll) {
        final Frame llllllllllllllIlIIIIlIllIIllIlII = this.frames[llllllllllllllIlIIIIlIllIIlIllll];
        boolean llllllllllllllIlIIIIlIllIIllIIll = false;
        if (llllllllllllllIlIIIIlIllIIllIlII == null) {
            this.frames[llllllllllllllIlIIIIlIllIIlIllll] = llllllllllllllIlIIIIlIllIIllIIII.copy();
            final boolean llllllllllllllIlIIIIlIllIIlllIIl = true;
        }
        else {
            llllllllllllllIlIIIIlIllIIllIIll = llllllllllllllIlIIIIlIllIIllIlII.merge(llllllllllllllIlIIIIlIllIIllIIII);
        }
        if (llllllllllllllIlIIIIlIllIIllIIll) {
            llllllllllllllIlIIIIlIllIIllIlll.add(llllllllllllllIlIIIIlIllIIlIllll);
        }
    }
    
    private void mergeLookupSwitch(final IntQueue llllllllllllllIlIIIIlIlIlllIlIlI, final int llllllllllllllIlIIIIlIlIlllIlIIl, final CodeIterator llllllllllllllIlIIIIlIlIlllIlIII, final Frame llllllllllllllIlIIIIlIlIllIlllll) throws BadBytecode {
        int llllllllllllllIlIIIIlIlIlllIIllI = (llllllllllllllIlIIIIlIlIlllIlIIl & 0xFFFFFFFC) + 4;
        this.merge(llllllllllllllIlIIIIlIlIlllIlIlI, llllllllllllllIlIIIIlIlIllIlllll, llllllllllllllIlIIIIlIlIlllIlIIl + llllllllllllllIlIIIIlIlIlllIlIII.s32bitAt(llllllllllllllIlIIIIlIlIlllIIllI));
        llllllllllllllIlIIIIlIlIlllIIllI += 4;
        final int llllllllllllllIlIIIIlIlIlllIIlIl = llllllllllllllIlIIIIlIlIlllIlIII.s32bitAt(llllllllllllllIlIIIIlIlIlllIIllI);
        final int n = llllllllllllllIlIIIIlIlIlllIIlIl * 8;
        for (llllllllllllllIlIIIIlIlIlllIIllI += 4, final int llllllllllllllIlIIIIlIlIlllIIlII = n + llllllllllllllIlIIIIlIlIlllIIllI, llllllllllllllIlIIIIlIlIlllIIllI += 4; llllllllllllllIlIIIIlIlIlllIIllI < llllllllllllllIlIIIIlIlIlllIIlII; llllllllllllllIlIIIIlIlIlllIIllI += 8) {
            final int llllllllllllllIlIIIIlIlIlllIllII = llllllllllllllIlIIIIlIlIlllIlIII.s32bitAt(llllllllllllllIlIIIIlIlIlllIIllI) + llllllllllllllIlIIIIlIlIlllIlIIl;
            this.merge(llllllllllllllIlIIIIlIlIlllIlIlI, llllllllllllllIlIIIIlIlIllIlllll, llllllllllllllIlIIIIlIlIlllIllII);
        }
    }
    
    private void mergeJsr(final IntQueue llllllllllllllIlIIIIlIllIIIIIlll, final Frame llllllllllllllIlIIIIlIlIlllllllI, final Subroutine llllllllllllllIlIIIIlIllIIIIIlIl, final int llllllllllllllIlIIIIlIllIIIIIlII, final int llllllllllllllIlIIIIlIllIIIIIIll) throws BadBytecode {
        if (llllllllllllllIlIIIIlIllIIIIIlIl == null) {
            throw new BadBytecode(String.valueOf(new StringBuilder().append("No subroutine at jsr target! [pos = ").append(llllllllllllllIlIIIIlIllIIIIIlII).append("]")));
        }
        Frame llllllllllllllIlIIIIlIllIIIIIIlI = this.frames[llllllllllllllIlIIIIlIllIIIIIIll];
        boolean llllllllllllllIlIIIIlIllIIIIIIIl = false;
        if (llllllllllllllIlIIIIlIllIIIIIIlI == null) {
            final Frame[] frames = this.frames;
            final Frame copy = llllllllllllllIlIIIIlIlIlllllllI.copy();
            frames[llllllllllllllIlIIIIlIllIIIIIIll] = copy;
            llllllllllllllIlIIIIlIllIIIIIIlI = copy;
            llllllllllllllIlIIIIlIllIIIIIIIl = true;
        }
        else {
            for (int llllllllllllllIlIIIIlIllIIIIlIIl = 0; llllllllllllllIlIIIIlIllIIIIlIIl < llllllllllllllIlIIIIlIlIlllllllI.localsLength(); ++llllllllllllllIlIIIIlIllIIIIlIIl) {
                if (!llllllllllllllIlIIIIlIllIIIIIlIl.isAccessed(llllllllllllllIlIIIIlIllIIIIlIIl)) {
                    final Type llllllllllllllIlIIIIlIllIIIIlIll = llllllllllllllIlIIIIlIllIIIIIIlI.getLocal(llllllllllllllIlIIIIlIllIIIIlIIl);
                    Type llllllllllllllIlIIIIlIllIIIIlIlI = llllllllllllllIlIIIIlIlIlllllllI.getLocal(llllllllllllllIlIIIIlIllIIIIlIIl);
                    if (llllllllllllllIlIIIIlIllIIIIlIll == null) {
                        llllllllllllllIlIIIIlIllIIIIIIlI.setLocal(llllllllllllllIlIIIIlIllIIIIlIIl, llllllllllllllIlIIIIlIllIIIIlIlI);
                        llllllllllllllIlIIIIlIllIIIIIIIl = true;
                    }
                    else {
                        llllllllllllllIlIIIIlIllIIIIlIlI = llllllllllllllIlIIIIlIllIIIIlIll.merge(llllllllllllllIlIIIIlIllIIIIlIlI);
                        llllllllllllllIlIIIIlIllIIIIIIlI.setLocal(llllllllllllllIlIIIIlIllIIIIlIIl, llllllllllllllIlIIIIlIllIIIIlIlI);
                        if (!llllllllllllllIlIIIIlIllIIIIlIlI.equals(llllllllllllllIlIIIIlIllIIIIlIll) || llllllllllllllIlIIIIlIllIIIIlIlI.popChanged()) {
                            llllllllllllllIlIIIIlIllIIIIIIIl = true;
                        }
                    }
                }
            }
        }
        if (!llllllllllllllIlIIIIlIllIIIIIIlI.isJsrMerged()) {
            llllllllllllllIlIIIIlIllIIIIIIlI.setJsrMerged(true);
            llllllllllllllIlIIIIlIllIIIIIIIl = true;
        }
        if (llllllllllllllIlIIIIlIllIIIIIIIl && llllllllllllllIlIIIIlIllIIIIIIlI.isRetMerged()) {
            llllllllllllllIlIIIIlIllIIIIIlll.add(llllllllllllllIlIIIIlIllIIIIIIll);
        }
    }
    
    private void mergeTableSwitch(final IntQueue llllllllllllllIlIIIIlIlIlIlIIIll, final int llllllllllllllIlIIIIlIlIlIlIIIlI, final CodeIterator llllllllllllllIlIIIIlIlIlIIllIII, final Frame llllllllllllllIlIIIIlIlIlIlIIIII) throws BadBytecode {
        int llllllllllllllIlIIIIlIlIlIIlllll = (llllllllllllllIlIIIIlIlIlIlIIIlI & 0xFFFFFFFC) + 4;
        this.merge(llllllllllllllIlIIIIlIlIlIlIIIll, llllllllllllllIlIIIIlIlIlIlIIIII, llllllllllllllIlIIIIlIlIlIlIIIlI + llllllllllllllIlIIIIlIlIlIIllIII.s32bitAt(llllllllllllllIlIIIIlIlIlIIlllll));
        llllllllllllllIlIIIIlIlIlIIlllll += 4;
        final int llllllllllllllIlIIIIlIlIlIIllllI = llllllllllllllIlIIIIlIlIlIIllIII.s32bitAt(llllllllllllllIlIIIIlIlIlIIlllll);
        llllllllllllllIlIIIIlIlIlIIlllll += 4;
        final int llllllllllllllIlIIIIlIlIlIIlllIl = llllllllllllllIlIIIIlIlIlIIllIII.s32bitAt(llllllllllllllIlIIIIlIlIlIIlllll);
        final int n = (llllllllllllllIlIIIIlIlIlIIlllIl - llllllllllllllIlIIIIlIlIlIIllllI + 1) * 4;
        llllllllllllllIlIIIIlIlIlIIlllll += 4;
        for (int llllllllllllllIlIIIIlIlIlIIlllII = n + llllllllllllllIlIIIIlIlIlIIlllll; llllllllllllllIlIIIIlIlIlIIlllll < llllllllllllllIlIIIIlIlIlIIlllII; llllllllllllllIlIIIIlIlIlIIlllll += 4) {
            final int llllllllllllllIlIIIIlIlIlIlIIlIl = llllllllllllllIlIIIIlIlIlIIllIII.s32bitAt(llllllllllllllIlIIIIlIlIlIIlllll) + llllllllllllllIlIIIIlIlIlIlIIIlI;
            this.merge(llllllllllllllIlIIIIlIlIlIlIIIll, llllllllllllllIlIIIIlIlIlIlIIIII, llllllllllllllIlIIIIlIlIlIlIIlIl);
        }
    }
    
    private void analyzeNextEntry(final MethodInfo llllllllllllllIlIIIIlIlllIlIIIIl, final CodeIterator llllllllllllllIlIIIIlIlllIIlIlll, final IntQueue llllllllllllllIlIIIIlIlllIIlIllI, final Executor llllllllllllllIlIIIIlIlllIIlIlIl) throws BadBytecode {
        final int llllllllllllllIlIIIIlIlllIIlllIl = llllllllllllllIlIIIIlIlllIIlIllI.take();
        llllllllllllllIlIIIIlIlllIIlIlll.move(llllllllllllllIlIIIIlIlllIIlllIl);
        llllllllllllllIlIIIIlIlllIIlIlll.next();
        final Frame llllllllllllllIlIIIIlIlllIIlllII = this.frames[llllllllllllllIlIIIIlIlllIIlllIl].copy();
        final Subroutine llllllllllllllIlIIIIlIlllIIllIll = this.subroutines[llllllllllllllIlIIIIlIlllIIlllIl];
        try {
            llllllllllllllIlIIIIlIlllIIlIlIl.execute(llllllllllllllIlIIIIlIlllIlIIIIl, llllllllllllllIlIIIIlIlllIIlllIl, llllllllllllllIlIIIIlIlllIIlIlll, llllllllllllllIlIIIIlIlllIIlllII, llllllllllllllIlIIIIlIlllIIllIll);
        }
        catch (RuntimeException llllllllllllllIlIIIIlIlllIlIIlII) {
            throw new BadBytecode(String.valueOf(new StringBuilder().append(llllllllllllllIlIIIIlIlllIlIIlII.getMessage()).append("[pos = ").append(llllllllllllllIlIIIIlIlllIIlllIl).append("]")), llllllllllllllIlIIIIlIlllIlIIlII);
        }
        final int llllllllllllllIlIIIIlIlllIIllIlI = llllllllllllllIlIIIIlIlllIIlIlll.byteAt(llllllllllllllIlIIIIlIlllIIlllIl);
        if (llllllllllllllIlIIIIlIlllIIllIlI == 170) {
            this.mergeTableSwitch(llllllllllllllIlIIIIlIlllIIlIllI, llllllllllllllIlIIIIlIlllIIlllIl, llllllllllllllIlIIIIlIlllIIlIlll, llllllllllllllIlIIIIlIlllIIlllII);
        }
        else if (llllllllllllllIlIIIIlIlllIIllIlI == 171) {
            this.mergeLookupSwitch(llllllllllllllIlIIIIlIlllIIlIllI, llllllllllllllIlIIIIlIlllIIlllIl, llllllllllllllIlIIIIlIlllIIlIlll, llllllllllllllIlIIIIlIlllIIlllII);
        }
        else if (llllllllllllllIlIIIIlIlllIIllIlI == 169) {
            this.mergeRet(llllllllllllllIlIIIIlIlllIIlIllI, llllllllllllllIlIIIIlIlllIIlIlll, llllllllllllllIlIIIIlIlllIIlllIl, llllllllllllllIlIIIIlIlllIIlllII, llllllllllllllIlIIIIlIlllIIllIll);
        }
        else if (Util.isJumpInstruction(llllllllllllllIlIIIIlIlllIIllIlI)) {
            final int llllllllllllllIlIIIIlIlllIlIIIll = Util.getJumpTarget(llllllllllllllIlIIIIlIlllIIlllIl, llllllllllllllIlIIIIlIlllIIlIlll);
            if (Util.isJsr(llllllllllllllIlIIIIlIlllIIllIlI)) {
                this.mergeJsr(llllllllllllllIlIIIIlIlllIIlIllI, this.frames[llllllllllllllIlIIIIlIlllIIlllIl], this.subroutines[llllllllllllllIlIIIIlIlllIlIIIll], llllllllllllllIlIIIIlIlllIIlllIl, this.lookAhead(llllllllllllllIlIIIIlIlllIIlIlll, llllllllllllllIlIIIIlIlllIIlllIl));
            }
            else if (!Util.isGoto(llllllllllllllIlIIIIlIlllIIllIlI)) {
                this.merge(llllllllllllllIlIIIIlIlllIIlIllI, llllllllllllllIlIIIIlIlllIIlllII, this.lookAhead(llllllllllllllIlIIIIlIlllIIlIlll, llllllllllllllIlIIIIlIlllIIlllIl));
            }
            this.merge(llllllllllllllIlIIIIlIlllIIlIllI, llllllllllllllIlIIIIlIlllIIlllII, llllllllllllllIlIIIIlIlllIlIIIll);
        }
        else if (llllllllllllllIlIIIIlIlllIIllIlI != 191 && !Util.isReturn(llllllllllllllIlIIIIlIlllIIllIlI)) {
            this.merge(llllllllllllllIlIIIIlIlllIIlIllI, llllllllllllllIlIIIIlIlllIIlllII, this.lookAhead(llllllllllllllIlIIIIlIlllIIlIlll, llllllllllllllIlIIIIlIlllIIlllIl));
        }
        this.mergeExceptionHandlers(llllllllllllllIlIIIIlIlllIIlIllI, llllllllllllllIlIIIIlIlllIlIIIIl, llllllllllllllIlIIIIlIlllIIlllIl, llllllllllllllIlIIIIlIlllIIlllII);
    }
    
    private ExceptionInfo[] buildExceptionInfo(final MethodInfo llllllllllllllIlIIIIlIllIlllllll) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokevirtual   com/viaversion/viaversion/libs/javassist/bytecode/MethodInfo.getConstPool:()Lcom/viaversion/viaversion/libs/javassist/bytecode/ConstPool;
        //     4: astore_2        /* llllllllllllllIlIIIIlIllIllllIII */
        //     5: aload_0         /* llllllllllllllIlIIIIlIllIllllIlI */
        //     6: getfield        com/viaversion/viaversion/libs/javassist/bytecode/analysis/Analyzer.clazz:Lcom/viaversion/viaversion/libs/javassist/CtClass;
        //     9: invokevirtual   com/viaversion/viaversion/libs/javassist/CtClass.getClassPool:()Lcom/viaversion/viaversion/libs/javassist/ClassPool;
        //    12: astore_3        /* llllllllllllllIlIIIIlIllIlllIlll */
        //    13: aload_1         /* llllllllllllllIlIIIIlIllIllllIIl */
        //    14: invokevirtual   com/viaversion/viaversion/libs/javassist/bytecode/MethodInfo.getCodeAttribute:()Lcom/viaversion/viaversion/libs/javassist/bytecode/CodeAttribute;
        //    17: invokevirtual   com/viaversion/viaversion/libs/javassist/bytecode/CodeAttribute.getExceptionTable:()Lcom/viaversion/viaversion/libs/javassist/bytecode/ExceptionTable;
        //    20: astore          llllllllllllllIlIIIIlIllIlllllII
        //    22: aload           llllllllllllllIlIIIIlIllIlllllII
        //    24: invokevirtual   com/viaversion/viaversion/libs/javassist/bytecode/ExceptionTable.size:()I
        //    27: anewarray       Lcom/viaversion/viaversion/libs/javassist/bytecode/analysis/Analyzer$ExceptionInfo;
        //    30: astore          llllllllllllllIlIIIIlIllIllllIll
        //    32: iconst_0       
        //    33: istore          llllllllllllllIlIIIIlIlllIIIIIIl
        //    35: iload           llllllllllllllIlIIIIlIlllIIIIIIl
        //    37: aload           llllllllllllllIlIIIIlIllIlllllII
        //    39: invokevirtual   com/viaversion/viaversion/libs/javassist/bytecode/ExceptionTable.size:()I
        //    42: if_icmpge       140
        //    45: aload           llllllllllllllIlIIIIlIllIlllllII
        //    47: iload           llllllllllllllIlIIIIlIlllIIIIIIl
        //    49: invokevirtual   com/viaversion/viaversion/libs/javassist/bytecode/ExceptionTable.catchType:(I)I
        //    52: istore          llllllllllllllIlIIIIlIlllIIIIIll
        //    54: iload           llllllllllllllIlIIIIlIlllIIIIIll
        //    56: ifne            65
        //    59: getstatic       com/viaversion/viaversion/libs/javassist/bytecode/analysis/Type.THROWABLE:Lcom/viaversion/viaversion/libs/javassist/bytecode/analysis/Type;
        //    62: goto            78
        //    65: aload_3         /* llllllllllllllIlIIIIlIllIlllllIl */
        //    66: aload_2         /* llllllllllllllIlIIIIlIllIllllllI */
        //    67: iload           llllllllllllllIlIIIIlIlllIIIIIll
        //    69: invokevirtual   com/viaversion/viaversion/libs/javassist/bytecode/ConstPool.getClassInfo:(I)Ljava/lang/String;
        //    72: invokevirtual   com/viaversion/viaversion/libs/javassist/ClassPool.get:(Ljava/lang/String;)Lcom/viaversion/viaversion/libs/javassist/CtClass;
        //    75: invokestatic    com/viaversion/viaversion/libs/javassist/bytecode/analysis/Type.get:(Lcom/viaversion/viaversion/libs/javassist/CtClass;)Lcom/viaversion/viaversion/libs/javassist/bytecode/analysis/Type;
        //    78: astore          llllllllllllllIlIIIIlIlllIIIIlIl
        //    80: goto            98
        //    83: astore          llllllllllllllIlIIIIlIlllIIIIlII
        //    85: new             Ljava/lang/IllegalStateException;
        //    88: dup            
        //    89: aload           llllllllllllllIlIIIIlIlllIIIIlII
        //    91: invokevirtual   com/viaversion/viaversion/libs/javassist/NotFoundException.getMessage:()Ljava/lang/String;
        //    94: invokespecial   java/lang/IllegalStateException.<init>:(Ljava/lang/String;)V
        //    97: athrow         
        //    98: aload           llllllllllllllIlIIIIlIllIllllIll
        //   100: iload           llllllllllllllIlIIIIlIlllIIIIIIl
        //   102: new             Lcom/viaversion/viaversion/libs/javassist/bytecode/analysis/Analyzer$ExceptionInfo;
        //   105: dup            
        //   106: aload           llllllllllllllIlIIIIlIllIlllllII
        //   108: iload           llllllllllllllIlIIIIlIlllIIIIIIl
        //   110: invokevirtual   com/viaversion/viaversion/libs/javassist/bytecode/ExceptionTable.startPc:(I)I
        //   113: aload           llllllllllllllIlIIIIlIllIlllllII
        //   115: iload           llllllllllllllIlIIIIlIlllIIIIIIl
        //   117: invokevirtual   com/viaversion/viaversion/libs/javassist/bytecode/ExceptionTable.endPc:(I)I
        //   120: aload           llllllllllllllIlIIIIlIllIlllllII
        //   122: iload           llllllllllllllIlIIIIlIlllIIIIIIl
        //   124: invokevirtual   com/viaversion/viaversion/libs/javassist/bytecode/ExceptionTable.handlerPc:(I)I
        //   127: aload           llllllllllllllIlIIIIlIlllIIIIIlI
        //   129: aconst_null    
        //   130: invokespecial   com/viaversion/viaversion/libs/javassist/bytecode/analysis/Analyzer$ExceptionInfo.<init>:(IIILcom/viaversion/viaversion/libs/javassist/bytecode/analysis/Type;Lcom/viaversion/viaversion/libs/javassist/bytecode/analysis/Analyzer$1;)V
        //   133: aastore        
        //   134: iinc            llllllllllllllIlIIIIlIlllIIIIIIl, 1
        //   137: goto            35
        //   140: aload           llllllllllllllIlIIIIlIllIllllIll
        //   142: areturn        
        //    StackMapTable: 00 06 FF 00 23 00 07 07 00 02 07 00 47 07 02 4C 07 02 52 07 02 41 07 02 7E 01 00 00 FC 00 1D 01 4C 07 00 DD 44 07 01 4A FC 00 0E 07 00 DD F9 00 29
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                                        
        //  -----  -----  -----  -----  ------------------------------------------------------------
        //  54     80     83     98     Lcom/viaversion/viaversion/libs/javassist/NotFoundException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private void mergeExceptionHandlers(final IntQueue llllllllllllllIlIIIIlIllIIlIIIIl, final MethodInfo llllllllllllllIlIIIIlIllIIlIIIII, final int llllllllllllllIlIIIIlIllIIIlllll, final Frame llllllllllllllIlIIIIlIllIIIllIlI) {
        for (int llllllllllllllIlIIIIlIllIIlIIIll = 0; llllllllllllllIlIIIIlIllIIlIIIll < this.exceptions.length; ++llllllllllllllIlIIIIlIllIIlIIIll) {
            final ExceptionInfo llllllllllllllIlIIIIlIllIIlIIlII = this.exceptions[llllllllllllllIlIIIIlIllIIlIIIll];
            if (llllllllllllllIlIIIIlIllIIIlllll >= llllllllllllllIlIIIIlIllIIlIIlII.start && llllllllllllllIlIIIIlIllIIIlllll < llllllllllllllIlIIIIlIllIIlIIlII.end) {
                final Frame llllllllllllllIlIIIIlIllIIlIIlIl = llllllllllllllIlIIIIlIllIIIllIlI.copy();
                llllllllllllllIlIIIIlIllIIlIIlIl.clearStack();
                llllllllllllllIlIIIIlIllIIlIIlIl.push(llllllllllllllIlIIIIlIllIIlIIlII.type);
                this.merge(llllllllllllllIlIIIIlIllIIlIIIIl, llllllllllllllIlIIIIlIllIIlIIlIl, llllllllllllllIlIIIIlIllIIlIIlII.handler);
            }
        }
    }
    
    private static class ExceptionInfo
    {
        private /* synthetic */ int end;
        private /* synthetic */ int handler;
        private /* synthetic */ int start;
        private /* synthetic */ Type type;
        
        private ExceptionInfo(final int llllllllllllllIlIIIllIlIIllIlIll, final int llllllllllllllIlIIIllIlIIllIllll, final int llllllllllllllIlIIIllIlIIllIlllI, final Type llllllllllllllIlIIIllIlIIllIllIl) {
            this.start = llllllllllllllIlIIIllIlIIllIlIll;
            this.end = llllllllllllllIlIIIllIlIIllIllll;
            this.handler = llllllllllllllIlIIIllIlIIllIlllI;
            this.type = llllllllllllllIlIIIllIlIIllIllIl;
        }
    }
}
