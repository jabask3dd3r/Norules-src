package com.viaversion.viaversion.libs.gson.internal.bind;

import com.viaversion.viaversion.libs.gson.internal.*;
import com.viaversion.viaversion.libs.gson.reflect.*;
import com.viaversion.viaversion.libs.gson.*;
import com.viaversion.viaversion.libs.gson.annotations.*;

public final class JsonAdapterAnnotationTypeAdapterFactory implements TypeAdapterFactory
{
    private final /* synthetic */ ConstructorConstructor constructorConstructor;
    
    public JsonAdapterAnnotationTypeAdapterFactory(final ConstructorConstructor lllllllllllllllIIIllIlIlllllIllI) {
        this.constructorConstructor = lllllllllllllllIIIllIlIlllllIllI;
    }
    
    @Override
    public <T> TypeAdapter<T> create(final Gson lllllllllllllllIIIllIlIllllIlIII, final TypeToken<T> lllllllllllllllIIIllIlIllllIllII) {
        final Class<? super T> lllllllllllllllIIIllIlIllllIlIll = lllllllllllllllIIIllIlIllllIllII.getRawType();
        final JsonAdapter lllllllllllllllIIIllIlIllllIlIlI = lllllllllllllllIIIllIlIllllIlIll.getAnnotation(JsonAdapter.class);
        if (lllllllllllllllIIIllIlIllllIlIlI == null) {
            return null;
        }
        return (TypeAdapter<T>)this.getTypeAdapter(this.constructorConstructor, lllllllllllllllIIIllIlIllllIlIII, lllllllllllllllIIIllIlIllllIllII, lllllllllllllllIIIllIlIllllIlIlI);
    }
    
    TypeAdapter<?> getTypeAdapter(final ConstructorConstructor lllllllllllllllIIIllIlIlllIlIIII, final Gson lllllllllllllllIIIllIlIlllIlIlIl, final TypeToken<?> lllllllllllllllIIIllIlIlllIIlllI, final JsonAdapter lllllllllllllllIIIllIlIlllIlIIll) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: invokeinterface com/viaversion/viaversion/libs/gson/annotations/JsonAdapter.value:()Ljava/lang/Class;
        //     8: invokestatic    com/viaversion/viaversion/libs/gson/reflect/TypeToken.get:(Ljava/lang/Class;)Lcom/viaversion/viaversion/libs/gson/reflect/TypeToken;
        //    11: invokevirtual   com/viaversion/viaversion/libs/gson/internal/ConstructorConstructor.get:(Lcom/viaversion/viaversion/libs/gson/reflect/TypeToken;)Lcom/viaversion/viaversion/libs/gson/internal/ObjectConstructor;
        //    14: invokeinterface com/viaversion/viaversion/libs/gson/internal/ObjectConstructor.construct:()Ljava/lang/Object;
        //    19: astore          lllllllllllllllIIIllIlIlllIlIIlI
        //    21: aload           lllllllllllllllIIIllIlIlllIlIIlI
        //    23: instanceof      Lcom/viaversion/viaversion/libs/gson/TypeAdapter;
        //    26: ifeq            39
        //    29: aload           lllllllllllllllIIIllIlIlllIlIIlI
        //    31: checkcast       Lcom/viaversion/viaversion/libs/gson/TypeAdapter;
        //    34: astore          lllllllllllllllIIIllIlIlllIlllII
        //    36: goto            188
        //    39: aload           lllllllllllllllIIIllIlIlllIlIIlI
        //    41: instanceof      Lcom/viaversion/viaversion/libs/gson/TypeAdapterFactory;
        //    44: ifeq            64
        //    47: aload           lllllllllllllllIIIllIlIlllIlIIlI
        //    49: checkcast       Lcom/viaversion/viaversion/libs/gson/TypeAdapterFactory;
        //    52: aload_2         /* lllllllllllllllIIIllIlIlllIIllll */
        //    53: aload_3         /* lllllllllllllllIIIllIlIlllIlIlII */
        //    54: invokeinterface com/viaversion/viaversion/libs/gson/TypeAdapterFactory.create:(Lcom/viaversion/viaversion/libs/gson/Gson;Lcom/viaversion/viaversion/libs/gson/reflect/TypeToken;)Lcom/viaversion/viaversion/libs/gson/TypeAdapter;
        //    59: astore          lllllllllllllllIIIllIlIlllIllIll
        //    61: goto            188
        //    64: aload           lllllllllllllllIIIllIlIlllIlIIlI
        //    66: instanceof      Lcom/viaversion/viaversion/libs/gson/JsonSerializer;
        //    69: ifne            80
        //    72: aload           lllllllllllllllIIIllIlIlllIlIIlI
        //    74: instanceof      Lcom/viaversion/viaversion/libs/gson/JsonDeserializer;
        //    77: ifeq            137
        //    80: aload           lllllllllllllllIIIllIlIlllIlIIlI
        //    82: instanceof      Lcom/viaversion/viaversion/libs/gson/JsonSerializer;
        //    85: ifeq            96
        //    88: aload           lllllllllllllllIIIllIlIlllIlIIlI
        //    90: checkcast       Lcom/viaversion/viaversion/libs/gson/JsonSerializer;
        //    93: goto            97
        //    96: aconst_null    
        //    97: astore          lllllllllllllllIIIllIlIlllIllIlI
        //    99: aload           lllllllllllllllIIIllIlIlllIlIIlI
        //   101: instanceof      Lcom/viaversion/viaversion/libs/gson/JsonDeserializer;
        //   104: ifeq            115
        //   107: aload           lllllllllllllllIIIllIlIlllIlIIlI
        //   109: checkcast       Lcom/viaversion/viaversion/libs/gson/JsonDeserializer;
        //   112: goto            116
        //   115: aconst_null    
        //   116: astore          lllllllllllllllIIIllIlIlllIllIIl
        //   118: new             Lcom/viaversion/viaversion/libs/gson/internal/bind/TreeTypeAdapter;
        //   121: dup            
        //   122: aload           lllllllllllllllIIIllIlIlllIllIlI
        //   124: aload           lllllllllllllllIIIllIlIlllIllIIl
        //   126: aload_2         /* lllllllllllllllIIIllIlIlllIIllll */
        //   127: aload_3         /* lllllllllllllllIIIllIlIlllIlIlII */
        //   128: aconst_null    
        //   129: invokespecial   com/viaversion/viaversion/libs/gson/internal/bind/TreeTypeAdapter.<init>:(Lcom/viaversion/viaversion/libs/gson/JsonSerializer;Lcom/viaversion/viaversion/libs/gson/JsonDeserializer;Lcom/viaversion/viaversion/libs/gson/Gson;Lcom/viaversion/viaversion/libs/gson/reflect/TypeToken;Lcom/viaversion/viaversion/libs/gson/TypeAdapterFactory;)V
        //   132: astore          lllllllllllllllIIIllIlIlllIllIII
        //   134: goto            188
        //   137: new             Ljava/lang/IllegalArgumentException;
        //   140: dup            
        //   141: new             Ljava/lang/StringBuilder;
        //   144: dup            
        //   145: invokespecial   java/lang/StringBuilder.<init>:()V
        //   148: ldc             "Invalid attempt to bind an instance of "
        //   150: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   153: aload           lllllllllllllllIIIllIlIlllIlIIlI
        //   155: invokevirtual   java/lang/Object.getClass:()Ljava/lang/Class;
        //   158: invokevirtual   java/lang/Class.getName:()Ljava/lang/String;
        //   161: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   164: ldc             " as a @JsonAdapter for "
        //   166: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   169: aload_3         /* lllllllllllllllIIIllIlIlllIlIlII */
        //   170: invokevirtual   com/viaversion/viaversion/libs/gson/reflect/TypeToken.toString:()Ljava/lang/String;
        //   173: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   176: ldc             ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer."
        //   178: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   181: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   184: invokespecial   java/lang/IllegalArgumentException.<init>:(Ljava/lang/String;)V
        //   187: athrow         
        //   188: aload           lllllllllllllllIIIllIlIlllIlIIIl
        //   190: ifnull          210
        //   193: aload           lllllllllllllllIIIllIlIlllIIllIl
        //   195: invokeinterface com/viaversion/viaversion/libs/gson/annotations/JsonAdapter.nullSafe:()Z
        //   200: ifeq            210
        //   203: aload           lllllllllllllllIIIllIlIlllIlIIIl
        //   205: invokevirtual   com/viaversion/viaversion/libs/gson/TypeAdapter.nullSafe:()Lcom/viaversion/viaversion/libs/gson/TypeAdapter;
        //   208: astore          lllllllllllllllIIIllIlIlllIlIIIl
        //   210: aload           lllllllllllllllIIIllIlIlllIlIIIl
        //   212: areturn        
        //    Signature:
        //  (Lcom/viaversion/viaversion/libs/gson/internal/ConstructorConstructor;Lcom/viaversion/viaversion/libs/gson/Gson;Lcom/viaversion/viaversion/libs/gson/reflect/TypeToken<*>;Lcom/viaversion/viaversion/libs/gson/annotations/JsonAdapter;)Lcom/viaversion/viaversion/libs/gson/TypeAdapter<*>;
        // 
        // The error that occurred was:
        // 
        // java.lang.UnsupportedOperationException
        //     at java.util.Collections$1.remove(Unknown Source)
        //     at java.util.AbstractCollection.removeAll(Unknown Source)
        //     at com.strobel.decompiler.ast.AstBuilder.convertLocalVariables(AstBuilder.java:2968)
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
}
