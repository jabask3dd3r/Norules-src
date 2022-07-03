package com.viaversion.viaversion.libs.javassist;

import java.util.*;
import com.viaversion.viaversion.libs.javassist.bytecode.*;
import com.viaversion.viaversion.libs.javassist.compiler.*;

class CtNewWrappedMethod
{
    private static String addBodyMethod(final CtClassType llllllllllllllllIlllIlllIlIllIIl, final ClassFile llllllllllllllllIlllIlllIlIllIII, final CtMethod llllllllllllllllIlllIlllIlIlIlll) throws BadBytecode, CannotCompileException {
        final Map<CtMethod, String> llllllllllllllllIlllIlllIlIllIll = llllllllllllllllIlllIlllIlIllIIl.getHiddenMethods();
        String llllllllllllllllIlllIlllIlIllIlI = llllllllllllllllIlllIlllIlIllIll.get(llllllllllllllllIlllIlllIlIlIlll);
        if (llllllllllllllllIlllIlllIlIllIlI == null) {
            do {
                llllllllllllllllIlllIlllIlIllIlI = String.valueOf(new StringBuilder().append("_added_m$").append(llllllllllllllllIlllIlllIlIllIIl.getUniqueNumber()));
            } while (llllllllllllllllIlllIlllIlIllIII.getMethod(llllllllllllllllIlllIlllIlIllIlI) != null);
            final ClassMap llllllllllllllllIlllIlllIllIIIlI = new ClassMap();
            llllllllllllllllIlllIlllIllIIIlI.put(llllllllllllllllIlllIlllIlIlIlll.getDeclaringClass().getName(), llllllllllllllllIlllIlllIlIllIIl.getName());
            final MethodInfo llllllllllllllllIlllIlllIllIIIIl = new MethodInfo(llllllllllllllllIlllIlllIlIllIII.getConstPool(), llllllllllllllllIlllIlllIlIllIlI, llllllllllllllllIlllIlllIlIlIlll.getMethodInfo2(), llllllllllllllllIlllIlllIllIIIlI);
            final int llllllllllllllllIlllIlllIllIIIII = llllllllllllllllIlllIlllIllIIIIl.getAccessFlags();
            llllllllllllllllIlllIlllIllIIIIl.setAccessFlags(AccessFlag.setPrivate(llllllllllllllllIlllIlllIllIIIII));
            llllllllllllllllIlllIlllIllIIIIl.addAttribute(new SyntheticAttribute(llllllllllllllllIlllIlllIlIllIII.getConstPool()));
            llllllllllllllllIlllIlllIlIllIII.addMethod(llllllllllllllllIlllIlllIllIIIIl);
            llllllllllllllllIlllIlllIlIllIll.put(llllllllllllllllIlllIlllIlIlIlll, llllllllllllllllIlllIlllIlIllIlI);
            final CtMember.Cache llllllllllllllllIlllIlllIlIlllll = llllllllllllllllIlllIlllIlIllIIl.hasMemberCache();
            if (llllllllllllllllIlllIlllIlIlllll != null) {
                llllllllllllllllIlllIlllIlIlllll.addMethod(new CtMethod(llllllllllllllllIlllIlllIllIIIIl, llllllllllllllllIlllIlllIlIllIIl));
            }
        }
        return llllllllllllllllIlllIlllIlIllIlI;
    }
    
    static int compileParameterList(final Bytecode llllllllllllllllIlllIlllIlIIllIl, final CtClass[] llllllllllllllllIlllIlllIlIIlIIl, final int llllllllllllllllIlllIlllIlIIlIll) {
        return JvstCodeGen.compileParameterList(llllllllllllllllIlllIlllIlIIllIl, llllllllllllllllIlllIlllIlIIlIIl, llllllllllllllllIlllIlllIlIIlIll);
    }
    
    static {
        addedWrappedMethod = "_added_m$";
    }
    
    public static CtMethod wrapped(final CtClass llllllllllllllllIlllIlllllIIlIlI, final String llllllllllllllllIlllIllllIllllll, final CtClass[] llllllllllllllllIlllIlllllIIlIII, final CtClass[] llllllllllllllllIlllIlllllIIIlll, final CtMethod llllllllllllllllIlllIlllllIIIllI, final CtMethod.ConstParameter llllllllllllllllIlllIllllIlllIll, final CtClass llllllllllllllllIlllIllllIlllIlI) throws CannotCompileException {
        final CtMethod llllllllllllllllIlllIlllllIIIIll = new CtMethod(llllllllllllllllIlllIlllllIIlIlI, llllllllllllllllIlllIllllIllllll, llllllllllllllllIlllIlllllIIlIII, llllllllllllllllIlllIllllIlllIlI);
        llllllllllllllllIlllIlllllIIIIll.setModifiers(llllllllllllllllIlllIlllllIIIllI.getModifiers());
        try {
            llllllllllllllllIlllIlllllIIIIll.setExceptionTypes(llllllllllllllllIlllIlllllIIIlll);
        }
        catch (NotFoundException llllllllllllllllIlllIlllllIIlIll) {
            throw new CannotCompileException(llllllllllllllllIlllIlllllIIlIll);
        }
        final Bytecode llllllllllllllllIlllIlllllIIIIlI = makeBody(llllllllllllllllIlllIllllIlllIlI, llllllllllllllllIlllIllllIlllIlI.getClassFile2(), llllllllllllllllIlllIlllllIIIllI, llllllllllllllllIlllIlllllIIlIII, llllllllllllllllIlllIlllllIIlIlI, llllllllllllllllIlllIllllIlllIll);
        final MethodInfo llllllllllllllllIlllIlllllIIIIIl = llllllllllllllllIlllIlllllIIIIll.getMethodInfo2();
        llllllllllllllllIlllIlllllIIIIIl.setCodeAttribute(llllllllllllllllIlllIlllllIIIIlI.toCodeAttribute());
        return llllllllllllllllIlllIlllllIIIIll;
    }
    
    protected static int makeBody0(final CtClass llllllllllllllllIlllIllllIIIlIlI, final ClassFile llllllllllllllllIlllIllllIIIlIIl, final CtMethod llllllllllllllllIlllIlllIlllllII, final boolean llllllllllllllllIlllIllllIIIIlll, final CtClass[] llllllllllllllllIlllIllllIIIIllI, final CtClass llllllllllllllllIlllIlllIllllIIl, final CtMethod.ConstParameter llllllllllllllllIlllIlllIllllIII, final Bytecode llllllllllllllllIlllIlllIlllIlll) throws CannotCompileException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: instanceof      Lcom/viaversion/viaversion/libs/javassist/CtClassType;
        //     4: ifne            38
        //     7: new             Lcom/viaversion/viaversion/libs/javassist/CannotCompileException;
        //    10: dup            
        //    11: new             Ljava/lang/StringBuilder;
        //    14: dup            
        //    15: invokespecial   java/lang/StringBuilder.<init>:()V
        //    18: ldc_w           "bad declaring class"
        //    21: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    24: aload_0         /* llllllllllllllllIlllIlllIllllllI */
        //    25: invokevirtual   com/viaversion/viaversion/libs/javassist/CtClass.getName:()Ljava/lang/String;
        //    28: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    31: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //    34: invokespecial   com/viaversion/viaversion/libs/javassist/CannotCompileException.<init>:(Ljava/lang/String;)V
        //    37: athrow         
        //    38: iload_3         /* llllllllllllllllIlllIlllIllllIll */
        //    39: ifne            48
        //    42: aload           llllllllllllllllIlllIllllIIIIIll
        //    44: iconst_0       
        //    45: invokevirtual   com/viaversion/viaversion/libs/javassist/bytecode/Bytecode.addAload:(I)V
        //    48: aload           llllllllllllllllIlllIllllIIIIIll
        //    50: aload           llllllllllllllllIlllIlllIllllIlI
        //    52: iload_3         /* llllllllllllllllIlllIlllIllllIll */
        //    53: ifeq            60
        //    56: iconst_0       
        //    57: goto            61
        //    60: iconst_1       
        //    61: invokestatic    com/viaversion/viaversion/libs/javassist/CtNewWrappedMethod.compileParameterList:(Lcom/viaversion/viaversion/libs/javassist/bytecode/Bytecode;[Lcom/viaversion/viaversion/libs/javassist/CtClass;I)I
        //    64: istore          llllllllllllllllIlllIllllIIIIIlI
        //    66: aload           llllllllllllllllIlllIllllIIIIlII
        //    68: ifnonnull       82
        //    71: iconst_0       
        //    72: istore          llllllllllllllllIlllIllllIIIlllI
        //    74: invokestatic    com/viaversion/viaversion/libs/javassist/CtMethod$ConstParameter.defaultDescriptor:()Ljava/lang/String;
        //    77: astore          llllllllllllllllIlllIllllIIIllIl
        //    79: goto            98
        //    82: aload           llllllllllllllllIlllIllllIIIIlII
        //    84: aload           llllllllllllllllIlllIllllIIIIIll
        //    86: invokevirtual   com/viaversion/viaversion/libs/javassist/CtMethod$ConstParameter.compile:(Lcom/viaversion/viaversion/libs/javassist/bytecode/Bytecode;)I
        //    89: istore          llllllllllllllllIlllIllllIIIIIIl
        //    91: aload           llllllllllllllllIlllIllllIIIIlII
        //    93: invokevirtual   com/viaversion/viaversion/libs/javassist/CtMethod$ConstParameter.descriptor:()Ljava/lang/String;
        //    96: astore          llllllllllllllllIlllIllllIIIIIII
        //    98: aload_2         /* llllllllllllllllIlllIllllIIIlIII */
        //    99: aload           llllllllllllllllIlllIllllIIIIIII
        //   101: invokestatic    com/viaversion/viaversion/libs/javassist/CtNewWrappedMethod.checkSignature:(Lcom/viaversion/viaversion/libs/javassist/CtMethod;Ljava/lang/String;)V
        //   104: aload_0         /* llllllllllllllllIlllIlllIllllllI */
        //   105: checkcast       Lcom/viaversion/viaversion/libs/javassist/CtClassType;
        //   108: aload_1         /* llllllllllllllllIlllIlllIlllllIl */
        //   109: aload_2         /* llllllllllllllllIlllIllllIIIlIII */
        //   110: invokestatic    com/viaversion/viaversion/libs/javassist/CtNewWrappedMethod.addBodyMethod:(Lcom/viaversion/viaversion/libs/javassist/CtClassType;Lcom/viaversion/viaversion/libs/javassist/bytecode/ClassFile;Lcom/viaversion/viaversion/libs/javassist/CtMethod;)Ljava/lang/String;
        //   113: astore          llllllllllllllllIlllIllllIIIllII
        //   115: goto            130
        //   118: astore          llllllllllllllllIlllIllllIIIlIll
        //   120: new             Lcom/viaversion/viaversion/libs/javassist/CannotCompileException;
        //   123: dup            
        //   124: aload           llllllllllllllllIlllIllllIIIlIll
        //   126: invokespecial   com/viaversion/viaversion/libs/javassist/CannotCompileException.<init>:(Ljava/lang/Throwable;)V
        //   129: athrow         
        //   130: iload_3         /* llllllllllllllllIlllIlllIllllIll */
        //   131: ifeq            149
        //   134: aload           llllllllllllllllIlllIllllIIIIIll
        //   136: getstatic       com/viaversion/viaversion/libs/javassist/bytecode/Bytecode.THIS:Lcom/viaversion/viaversion/libs/javassist/CtClass;
        //   139: aload           llllllllllllllllIlllIlllIlllllll
        //   141: aload           llllllllllllllllIlllIllllIIIIIII
        //   143: invokevirtual   com/viaversion/viaversion/libs/javassist/bytecode/Bytecode.addInvokestatic:(Lcom/viaversion/viaversion/libs/javassist/CtClass;Ljava/lang/String;Ljava/lang/String;)V
        //   146: goto            161
        //   149: aload           llllllllllllllllIlllIllllIIIIIll
        //   151: getstatic       com/viaversion/viaversion/libs/javassist/bytecode/Bytecode.THIS:Lcom/viaversion/viaversion/libs/javassist/CtClass;
        //   154: aload           llllllllllllllllIlllIlllIlllllll
        //   156: aload           llllllllllllllllIlllIllllIIIIIII
        //   158: invokevirtual   com/viaversion/viaversion/libs/javassist/bytecode/Bytecode.addInvokespecial:(Lcom/viaversion/viaversion/libs/javassist/CtClass;Ljava/lang/String;Ljava/lang/String;)V
        //   161: aload           llllllllllllllllIlllIllllIIIIIll
        //   163: aload           llllllllllllllllIlllIllllIIIIlIl
        //   165: invokestatic    com/viaversion/viaversion/libs/javassist/CtNewWrappedMethod.compileReturn:(Lcom/viaversion/viaversion/libs/javassist/bytecode/Bytecode;Lcom/viaversion/viaversion/libs/javassist/CtClass;)V
        //   168: iload           llllllllllllllllIlllIllllIIIIIlI
        //   170: iload           llllllllllllllllIlllIllllIIIIIIl
        //   172: iconst_2       
        //   173: iadd           
        //   174: if_icmpge       183
        //   177: iload           llllllllllllllllIlllIllllIIIIIIl
        //   179: iconst_2       
        //   180: iadd           
        //   181: istore          llllllllllllllllIlllIllllIIIIIlI
        //   183: iload           llllllllllllllllIlllIllllIIIIIlI
        //   185: ireturn        
        //    Exceptions:
        //  throws com.viaversion.viaversion.libs.javassist.CannotCompileException
        //    StackMapTable: 00 0B 26 09 FF 00 0B 00 08 07 00 4A 07 00 3D 07 00 0D 01 07 00 F9 07 00 4A 07 00 0B 07 00 D5 00 02 07 00 D5 07 00 F9 FF 00 00 00 08 07 00 4A 07 00 3D 07 00 0D 01 07 00 F9 07 00 4A 07 00 0B 07 00 D5 00 03 07 00 D5 07 00 F9 01 FC 00 14 01 FD 00 0F 01 07 00 24 53 07 00 14 FC 00 0B 07 00 24 12 0B 15
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                                           
        //  -----  -----  -----  -----  ---------------------------------------------------------------
        //  104    115    118    130    Lcom/viaversion/viaversion/libs/javassist/bytecode/BadBytecode;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private static void compileReturn(final Bytecode llllllllllllllllIlllIlllIlIIIIIl, final CtClass llllllllllllllllIlllIlllIIlllllI) {
        if (llllllllllllllllIlllIlllIIlllllI.isPrimitive()) {
            final CtPrimitiveType llllllllllllllllIlllIlllIlIIIIlI = (CtPrimitiveType)llllllllllllllllIlllIlllIIlllllI;
            if (llllllllllllllllIlllIlllIlIIIIlI != CtClass.voidType) {
                final String llllllllllllllllIlllIlllIlIIIIll = llllllllllllllllIlllIlllIlIIIIlI.getWrapperName();
                llllllllllllllllIlllIlllIlIIIIIl.addCheckcast(llllllllllllllllIlllIlllIlIIIIll);
                llllllllllllllllIlllIlllIlIIIIIl.addInvokevirtual(llllllllllllllllIlllIlllIlIIIIll, llllllllllllllllIlllIlllIlIIIIlI.getGetMethodName(), llllllllllllllllIlllIlllIlIIIIlI.getGetMethodDescriptor());
            }
            llllllllllllllllIlllIlllIlIIIIIl.addOpcode(llllllllllllllllIlllIlllIlIIIIlI.getReturnOp());
        }
        else {
            llllllllllllllllIlllIlllIlIIIIIl.addCheckcast(llllllllllllllllIlllIlllIIlllllI);
            llllllllllllllllIlllIlllIlIIIIIl.addOpcode(176);
        }
    }
    
    static Bytecode makeBody(final CtClass llllllllllllllllIlllIllllIlIllIl, final ClassFile llllllllllllllllIlllIllllIlIIIll, final CtMethod llllllllllllllllIlllIllllIlIIIlI, final CtClass[] llllllllllllllllIlllIllllIlIIIIl, final CtClass llllllllllllllllIlllIllllIlIIIII, final CtMethod.ConstParameter llllllllllllllllIlllIllllIlIlIII) throws CannotCompileException {
        final boolean llllllllllllllllIlllIllllIlIIlll = Modifier.isStatic(llllllllllllllllIlllIllllIlIIIlI.getModifiers());
        final Bytecode llllllllllllllllIlllIllllIlIIllI = new Bytecode(llllllllllllllllIlllIllllIlIIIll.getConstPool(), 0, 0);
        final int llllllllllllllllIlllIllllIlIIlIl = makeBody0(llllllllllllllllIlllIllllIlIllIl, llllllllllllllllIlllIllllIlIIIll, llllllllllllllllIlllIllllIlIIIlI, llllllllllllllllIlllIllllIlIIlll, llllllllllllllllIlllIllllIlIIIIl, llllllllllllllllIlllIllllIlIIIII, llllllllllllllllIlllIllllIlIlIII, llllllllllllllllIlllIllllIlIIllI);
        llllllllllllllllIlllIllllIlIIllI.setMaxStack(llllllllllllllllIlllIllllIlIIlIl);
        llllllllllllllllIlllIllllIlIIllI.setMaxLocals(llllllllllllllllIlllIllllIlIIlll, llllllllllllllllIlllIllllIlIIIIl, 0);
        return llllllllllllllllIlllIllllIlIIllI;
    }
    
    private static void checkSignature(final CtMethod llllllllllllllllIlllIlllIllIllIl, final String llllllllllllllllIlllIlllIllIllII) throws CannotCompileException {
        if (!llllllllllllllllIlllIlllIllIllII.equals(llllllllllllllllIlllIlllIllIllIl.getMethodInfo2().getDescriptor())) {
            throw new CannotCompileException(String.valueOf(new StringBuilder().append("wrapped method with a bad signature: ").append(llllllllllllllllIlllIlllIllIllIl.getDeclaringClass().getName()).append('.').append(llllllllllllllllIlllIlllIllIllIl.getName())));
        }
    }
}
