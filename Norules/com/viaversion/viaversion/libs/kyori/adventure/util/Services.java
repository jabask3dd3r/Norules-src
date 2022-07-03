package com.viaversion.viaversion.libs.kyori.adventure.util;

import org.jetbrains.annotations.*;
import java.util.*;

public final class Services
{
    static {
        SERVICE_LOAD_FAILURES_ARE_FATAL = Boolean.parseBoolean(System.getProperty(String.join(".", "net", "kyori", "adventure", "serviceLoadFailuresAreFatal"), String.valueOf(true)));
    }
    
    @NotNull
    public static <P> Optional<P> service(@NotNull final Class<P> lllllllllllllllllllIlllIIIlIIIlI) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokestatic    com/viaversion/viaversion/libs/kyori/adventure/util/Services0.loader:(Ljava/lang/Class;)Ljava/util/ServiceLoader;
        //     4: astore_1        /* lllllllllllllllllllIlllIIIIlllIl */
        //     5: aload_1         /* lllllllllllllllllllIlllIIIIlllIl */
        //     6: invokevirtual   java/util/ServiceLoader.iterator:()Ljava/util/Iterator;
        //     9: astore_2        /* lllllllllllllllllllIlllIIIIlllII */
        //    10: aload_2         /* lllllllllllllllllllIlllIIIIlllII */
        //    11: invokeinterface java/util/Iterator.hasNext:()Z
        //    16: ifeq            115
        //    19: aload_2         /* lllllllllllllllllllIlllIIIIlllII */
        //    20: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    25: astore_3        /* lllllllllllllllllllIlllIIIlIIIIl */
        //    26: goto            69
        //    29: astore          lllllllllllllllllllIlllIIIlIIIII
        //    31: getstatic       com/viaversion/viaversion/libs/kyori/adventure/util/Services.SERVICE_LOAD_FAILURES_ARE_FATAL:Z
        //    34: ifeq            66
        //    37: new             Ljava/lang/IllegalStateException;
        //    40: dup            
        //    41: new             Ljava/lang/StringBuilder;
        //    44: dup            
        //    45: invokespecial   java/lang/StringBuilder.<init>:()V
        //    48: ldc             "Encountered an exception loading service "
        //    50: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    53: aload_0         /* lllllllllllllllllllIlllIIIIllIll */
        //    54: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //    57: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //    60: aload           lllllllllllllllllllIlllIIIlIIIII
        //    62: invokespecial   java/lang/IllegalStateException.<init>:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //    65: athrow         
        //    66: goto            10
        //    69: aload_2         /* lllllllllllllllllllIlllIIIIlllII */
        //    70: invokeinterface java/util/Iterator.hasNext:()Z
        //    75: ifeq            110
        //    78: new             Ljava/lang/IllegalStateException;
        //    81: dup            
        //    82: new             Ljava/lang/StringBuilder;
        //    85: dup            
        //    86: invokespecial   java/lang/StringBuilder.<init>:()V
        //    89: ldc             "Expected to find one service "
        //    91: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    94: aload_0         /* lllllllllllllllllllIlllIIIIllIll */
        //    95: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //    98: ldc             ", found multiple"
        //   100: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   103: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   106: invokespecial   java/lang/IllegalStateException.<init>:(Ljava/lang/String;)V
        //   109: athrow         
        //   110: aload_3         /* lllllllllllllllllllIlllIIIIlllll */
        //   111: invokestatic    java/util/Optional.of:(Ljava/lang/Object;)Ljava/util/Optional;
        //   114: areturn        
        //   115: invokestatic    java/util/Optional.empty:()Ljava/util/Optional;
        //   118: areturn        
        //    Signature:
        //  <P:Ljava/lang/Object;>(Ljava/lang/Class<TP;>;)Ljava/util/Optional<TP;>;
        //    RuntimeInvisibleTypeAnnotations: 00 02 14 00 00 31 00 00 16 00 00 00 31 00 00
        //    MethodParameters:
        //  Name                              Flags  
        //  --------------------------------  -----
        //  lllllllllllllllllllIlllIIIlIIIlI  FINAL
        //    StackMapTable: 00 06 FD 00 0A 07 00 3B 07 00 41 52 07 00 33 FD 00 24 00 07 00 33 FF 00 02 00 04 07 00 8A 07 00 3B 07 00 41 07 00 04 00 00 28 FA 00 04
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  19     26     29     69     Ljava/lang/Throwable;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        //     at com.strobel.decompiler.ast.AstBuilder.convertLocalVariables(AstBuilder.java:2895)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2445)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at us.deathmarine.luyten.FileSaver.doSaveJarDecompiled(FileSaver.java:192)
        //     at us.deathmarine.luyten.FileSaver.access$300(FileSaver.java:45)
        //     at us.deathmarine.luyten.FileSaver$4.run(FileSaver.java:112)
        //     at java.lang.Thread.run(Unknown Source)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private Services() {
    }
}
