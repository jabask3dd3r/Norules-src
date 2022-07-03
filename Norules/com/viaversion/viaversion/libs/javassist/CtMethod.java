package com.viaversion.viaversion.libs.javassist;

import com.viaversion.viaversion.libs.javassist.bytecode.*;

public final class CtMethod extends CtBehavior
{
    protected /* synthetic */ String cachedStringRep;
    
    public CtClass getReturnType() throws NotFoundException {
        return this.getReturnType0();
    }
    
    public static CtMethod make(final MethodInfo lllllllllllllIIIIIlIlIIIIIlIIlII, final CtClass lllllllllllllIIIIIlIlIIIIIlIIIll) throws CannotCompileException {
        if (lllllllllllllIIIIIlIlIIIIIlIIIll.getClassFile2().getConstPool() != lllllllllllllIIIIIlIlIIIIIlIIlII.getConstPool()) {
            throw new CannotCompileException("bad declaring class");
        }
        return new CtMethod(lllllllllllllIIIIIlIlIIIIIlIIlII, lllllllllllllIIIIIlIlIIIIIlIIIll);
    }
    
    public void setBody(final CtMethod lllllllllllllIIIIIlIIlllllllIlIl, final ClassMap lllllllllllllIIIIIlIIlllllllIIIl) throws CannotCompileException {
        CtBehavior.setBody0(lllllllllllllIIIIIlIIlllllllIlIl.declaringClass, lllllllllllllIIIIIlIIlllllllIlIl.methodInfo, this.declaringClass, this.methodInfo, lllllllllllllIIIIIlIIlllllllIIIl);
    }
    
    public static CtMethod make(final String lllllllllllllIIIIIlIlIIIIIlIlIlI, final CtClass lllllllllllllIIIIIlIlIIIIIlIlIIl) throws CannotCompileException {
        return CtNewMethod.make(lllllllllllllIIIIIlIlIIIIIlIlIlI, lllllllllllllIIIIIlIlIIIIIlIlIIl);
    }
    
    @Override
    public String getLongName() {
        return String.valueOf(new StringBuilder().append(this.getDeclaringClass().getName()).append(".").append(this.getName()).append(Descriptor.toString(this.getSignature())));
    }
    
    public CtMethod(final CtMethod lllllllllllllIIIIIlIlIIIIIllIlIl, final CtClass lllllllllllllIIIIIlIlIIIIIllIIII, final ClassMap lllllllllllllIIIIIlIlIIIIIlIllll) throws CannotCompileException {
        this(null, lllllllllllllIIIIIlIlIIIIIllIIII);
        this.copy(lllllllllllllIIIIIlIlIIIIIllIlIl, false, lllllllllllllIIIIIlIlIIIIIlIllll);
    }
    
    public void setWrappedBody(final CtMethod lllllllllllllIIIIIlIIllllllIIlII, final ConstParameter lllllllllllllIIIIIlIIllllllIIIll) throws CannotCompileException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        com/viaversion/viaversion/libs/javassist/CtMethod.declaringClass:Lcom/viaversion/viaversion/libs/javassist/CtClass;
        //     4: invokevirtual   com/viaversion/viaversion/libs/javassist/CtClass.checkModify:()V
        //     7: aload_0         /* lllllllllllllIIIIIlIIlllllIlllIl */
        //     8: invokevirtual   com/viaversion/viaversion/libs/javassist/CtMethod.getDeclaringClass:()Lcom/viaversion/viaversion/libs/javassist/CtClass;
        //    11: astore_3        /* lllllllllllllIIIIIlIIllllllIIIlI */
        //    12: aload_0         /* lllllllllllllIIIIIlIIlllllIlllIl */
        //    13: invokevirtual   com/viaversion/viaversion/libs/javassist/CtMethod.getParameterTypes:()[Lcom/viaversion/viaversion/libs/javassist/CtClass;
        //    16: astore          lllllllllllllIIIIIlIIllllllIlIII
        //    18: aload_0         /* lllllllllllllIIIIIlIIlllllIlllIl */
        //    19: invokevirtual   com/viaversion/viaversion/libs/javassist/CtMethod.getReturnType:()Lcom/viaversion/viaversion/libs/javassist/CtClass;
        //    22: astore          lllllllllllllIIIIIlIIllllllIIlll
        //    24: goto            39
        //    27: astore          lllllllllllllIIIIIlIIllllllIIllI
        //    29: new             Lcom/viaversion/viaversion/libs/javassist/CannotCompileException;
        //    32: dup            
        //    33: aload           lllllllllllllIIIIIlIIllllllIIllI
        //    35: invokespecial   com/viaversion/viaversion/libs/javassist/CannotCompileException.<init>:(Lcom/viaversion/viaversion/libs/javassist/NotFoundException;)V
        //    38: athrow         
        //    39: aload_3         /* lllllllllllllIIIIIlIIllllllIIIlI */
        //    40: aload_3         /* lllllllllllllIIIIIlIIllllllIIIlI */
        //    41: invokevirtual   com/viaversion/viaversion/libs/javassist/CtClass.getClassFile2:()Lcom/viaversion/viaversion/libs/javassist/bytecode/ClassFile;
        //    44: aload_1         /* lllllllllllllIIIIIlIIlllllIlllII */
        //    45: aload           lllllllllllllIIIIIlIIllllllIIIIl
        //    47: aload           lllllllllllllIIIIIlIIllllllIIIII
        //    49: aload_2         /* lllllllllllllIIIIIlIIlllllIllIll */
        //    50: invokestatic    com/viaversion/viaversion/libs/javassist/CtNewWrappedMethod.makeBody:(Lcom/viaversion/viaversion/libs/javassist/CtClass;Lcom/viaversion/viaversion/libs/javassist/bytecode/ClassFile;Lcom/viaversion/viaversion/libs/javassist/CtMethod;[Lcom/viaversion/viaversion/libs/javassist/CtClass;Lcom/viaversion/viaversion/libs/javassist/CtClass;Lcom/viaversion/viaversion/libs/javassist/CtMethod$ConstParameter;)Lcom/viaversion/viaversion/libs/javassist/bytecode/Bytecode;
        //    53: astore          lllllllllllllIIIIIlIIlllllIlllll
        //    55: aload           lllllllllllllIIIIIlIIlllllIlllll
        //    57: invokevirtual   com/viaversion/viaversion/libs/javassist/bytecode/Bytecode.toCodeAttribute:()Lcom/viaversion/viaversion/libs/javassist/bytecode/CodeAttribute;
        //    60: astore          lllllllllllllIIIIIlIIlllllIllllI
        //    62: aload_0         /* lllllllllllllIIIIIlIIlllllIlllIl */
        //    63: getfield        com/viaversion/viaversion/libs/javassist/CtMethod.methodInfo:Lcom/viaversion/viaversion/libs/javassist/bytecode/MethodInfo;
        //    66: aload           lllllllllllllIIIIIlIIlllllIllllI
        //    68: invokevirtual   com/viaversion/viaversion/libs/javassist/bytecode/MethodInfo.setCodeAttribute:(Lcom/viaversion/viaversion/libs/javassist/bytecode/CodeAttribute;)V
        //    71: aload_0         /* lllllllllllllIIIIIlIIlllllIlllIl */
        //    72: getfield        com/viaversion/viaversion/libs/javassist/CtMethod.methodInfo:Lcom/viaversion/viaversion/libs/javassist/bytecode/MethodInfo;
        //    75: aload_0         /* lllllllllllllIIIIIlIIlllllIlllIl */
        //    76: getfield        com/viaversion/viaversion/libs/javassist/CtMethod.methodInfo:Lcom/viaversion/viaversion/libs/javassist/bytecode/MethodInfo;
        //    79: invokevirtual   com/viaversion/viaversion/libs/javassist/bytecode/MethodInfo.getAccessFlags:()I
        //    82: sipush          -1025
        //    85: iand           
        //    86: invokevirtual   com/viaversion/viaversion/libs/javassist/bytecode/MethodInfo.setAccessFlags:(I)V
        //    89: return         
        //    Exceptions:
        //  throws com.viaversion.viaversion.libs.javassist.CannotCompileException
        //    StackMapTable: 00 02 FF 00 1B 00 04 07 00 02 07 00 02 07 00 09 07 00 23 00 01 07 00 16 FD 00 0B 07 00 D1 07 00 23
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                                        
        //  -----  -----  -----  -----  ------------------------------------------------------------
        //  12     24     27     39     Lcom/viaversion/viaversion/libs/javassist/NotFoundException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    CtMethod(final MethodInfo lllllllllllllIIIIIlIlIIIIlIlIlII, final CtClass lllllllllllllIIIIIlIlIIIIlIlIIll) {
        super(lllllllllllllIIIIIlIlIIIIlIlIIll, lllllllllllllIIIIIlIlIIIIlIlIlII);
        this.cachedStringRep = null;
    }
    
    @Override
    void nameReplaced() {
        this.cachedStringRep = null;
    }
    
    public void setName(final String lllllllllllllIIIIIlIlIIIIIIIlIlI) {
        this.declaringClass.checkModify();
        this.methodInfo.setName(lllllllllllllIIIIIlIlIIIIIIIlIlI);
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIIIIIlIlIIIIIIlIlII) {
        return lllllllllllllIIIIIlIlIIIIIIlIlII != null && lllllllllllllIIIIIlIlIIIIIIlIlII instanceof CtMethod && ((CtMethod)lllllllllllllIIIIIlIlIIIIIIlIlII).getStringRep().equals(this.getStringRep());
    }
    
    final String getStringRep() {
        if (this.cachedStringRep == null) {
            this.cachedStringRep = String.valueOf(new StringBuilder().append(this.methodInfo.getName()).append(Descriptor.getParamDescriptor(this.methodInfo.getDescriptor())));
        }
        return this.cachedStringRep;
    }
    
    public CtMethod(final CtClass lllllllllllllIIIIIlIlIIIIlIIIlll, final String lllllllllllllIIIIIlIlIIIIIllllll, final CtClass[] lllllllllllllIIIIIlIlIIIIlIIIlIl, final CtClass lllllllllllllIIIIIlIlIIIIIllllIl) {
        this(null, lllllllllllllIIIIIlIlIIIIIllllIl);
        final ConstPool lllllllllllllIIIIIlIlIIIIlIIIIll = lllllllllllllIIIIIlIlIIIIIllllIl.getClassFile2().getConstPool();
        final String lllllllllllllIIIIIlIlIIIIlIIIIlI = Descriptor.ofMethod(lllllllllllllIIIIIlIlIIIIlIIIlll, lllllllllllllIIIIIlIlIIIIlIIIlIl);
        this.methodInfo = new MethodInfo(lllllllllllllIIIIIlIlIIIIlIIIIll, lllllllllllllIIIIIlIlIIIIIllllll, lllllllllllllIIIIIlIlIIIIlIIIIlI);
        this.setModifiers(1025);
    }
    
    @Override
    public String getName() {
        return this.methodInfo.getName();
    }
    
    @Override
    public boolean isEmpty() {
        final CodeAttribute lllllllllllllIIIIIlIIlllllllllll = this.getMethodInfo2().getCodeAttribute();
        if (lllllllllllllIIIIIlIIlllllllllll == null) {
            return (this.getModifiers() & 0x400) != 0x0;
        }
        final CodeIterator lllllllllllllIIIIIlIIllllllllllI = lllllllllllllIIIIIlIIlllllllllll.iterator();
        try {
            return lllllllllllllIIIIIlIIllllllllllI.hasNext() && lllllllllllllIIIIIlIIllllllllllI.byteAt(lllllllllllllIIIIIlIIllllllllllI.next()) == 177 && !lllllllllllllIIIIIlIIllllllllllI.hasNext();
        }
        catch (BadBytecode lllllllllllllIIIIIlIIllllllllIlI) {
            return false;
        }
    }
    
    @Override
    public int hashCode() {
        return this.getStringRep().hashCode();
    }
    
    static class LongConstParameter extends ConstParameter
    {
        /* synthetic */ long param;
        
        @Override
        String constDescriptor() {
            return "([Ljava/lang/Object;J)V";
        }
        
        LongConstParameter(final long lllllllllllllIllllllIllIllIIIlII) {
            this.param = lllllllllllllIllllllIllIllIIIlII;
        }
        
        @Override
        String descriptor() {
            return "([Ljava/lang/Object;J)Ljava/lang/Object;";
        }
        
        @Override
        int compile(final Bytecode lllllllllllllIllllllIllIllIIIIII) throws CannotCompileException {
            lllllllllllllIllllllIllIllIIIIII.addLconst(this.param);
            return 2;
        }
    }
    
    public static class ConstParameter
    {
        public static ConstParameter integer(final int lllllllllllllIlIIIIllllIIIllllII) {
            return new IntConstParameter(lllllllllllllIlIIIIllllIIIllllII);
        }
        
        String descriptor() {
            return defaultDescriptor();
        }
        
        ConstParameter() {
        }
        
        static String defaultDescriptor() {
            return "([Ljava/lang/Object;)Ljava/lang/Object;";
        }
        
        public static ConstParameter integer(final long lllllllllllllIlIIIIllllIIIlllIIl) {
            return new LongConstParameter(lllllllllllllIlIIIIllllIIIlllIIl);
        }
        
        static String defaultConstDescriptor() {
            return "([Ljava/lang/Object;)V";
        }
        
        int compile(final Bytecode lllllllllllllIlIIIIllllIIIllIIIl) throws CannotCompileException {
            return 0;
        }
        
        String constDescriptor() {
            return defaultConstDescriptor();
        }
        
        public static ConstParameter string(final String lllllllllllllIlIIIIllllIIIllIllI) {
            return new StringConstParameter(lllllllllllllIlIIIIllllIIIllIllI);
        }
    }
    
    static class StringConstParameter extends ConstParameter
    {
        /* synthetic */ String param;
        
        StringConstParameter(final String lllllllllllllIlIIlIlIlllIIlIIlll) {
            this.param = lllllllllllllIlIIlIlIlllIIlIIlll;
        }
        
        @Override
        String descriptor() {
            return "([Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;";
        }
        
        @Override
        String constDescriptor() {
            return "([Ljava/lang/Object;Ljava/lang/String;)V";
        }
        
        @Override
        int compile(final Bytecode lllllllllllllIlIIlIlIlllIIlIIIll) throws CannotCompileException {
            lllllllllllllIlIIlIlIlllIIlIIIll.addLdc(this.param);
            return 1;
        }
    }
    
    static class IntConstParameter extends ConstParameter
    {
        /* synthetic */ int param;
        
        @Override
        int compile(final Bytecode lllllllllllllIlIIlIIlIlIllIIIIII) throws CannotCompileException {
            lllllllllllllIlIIlIIlIlIllIIIIII.addIconst(this.param);
            return 1;
        }
        
        @Override
        String descriptor() {
            return "([Ljava/lang/Object;I)Ljava/lang/Object;";
        }
        
        IntConstParameter(final int lllllllllllllIlIIlIIlIlIllIIIllI) {
            this.param = lllllllllllllIlIIlIIlIlIllIIIllI;
        }
        
        @Override
        String constDescriptor() {
            return "([Ljava/lang/Object;I)V";
        }
    }
}
