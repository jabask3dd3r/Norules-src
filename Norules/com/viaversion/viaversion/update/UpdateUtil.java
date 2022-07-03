package com.viaversion.viaversion.update;

import java.util.*;
import com.viaversion.viaversion.api.*;

public class UpdateUtil
{
    static {
        URL = "https://api.spiget.org/v2/resources/";
        LATEST_VERSION = "/versions/latest";
        PLUGIN = 19254;
        PREFIX = "§a§l[ViaVersion] §a";
    }
    
    public static void sendUpdateMessage(final UUID lllllllllllllIlIIIIIIlIIIllllIll) {
        final String lllllllllllllIlIIIIIIlIIIlIIIlll;
        Via.getPlatform().runAsync(() -> {
            lllllllllllllIlIIIIIIlIIIlIIIlll = getUpdateMessage(false);
            if (lllllllllllllIlIIIIIIlIIIlIIIlll != null) {
                Via.getPlatform().runSync(() -> Via.getPlatform().sendMessage(lllllllllllllIlIIIIIIlIIIllllIll, String.valueOf(new StringBuilder().append("§a§l[ViaVersion] §a").append(lllllllllllllIlIIIIIIlIIIlIIIlll))));
            }
        });
    }
    
    private static String getUpdateMessage(final boolean lllllllllllllIlIIIIIIlIIIlllIIIl) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: invokeinterface com/viaversion/viaversion/api/platform/ViaPlatform.getPluginVersion:()Ljava/lang/String;
        //     8: ldc             "${version}"
        //    10: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //    13: ifeq            19
        //    16: ldc             "You are using a debug/custom version, consider updating."
        //    18: areturn        
        //    19: invokestatic    com/viaversion/viaversion/update/UpdateUtil.getNewestVersion:()Ljava/lang/String;
        //    22: astore_1        /* lllllllllllllIlIIIIIIlIIIllIllII */
        //    23: aload_1         /* lllllllllllllIlIIIIIIlIIIlllIIII */
        //    24: ifnonnull       36
        //    27: iload_0         /* lllllllllllllIlIIIIIIlIIIllIllIl */
        //    28: ifeq            34
        //    31: ldc             "Could not check for updates, check your connection."
        //    33: areturn        
        //    34: aconst_null    
        //    35: areturn        
        //    36: new             Lcom/viaversion/viaversion/update/Version;
        //    39: dup            
        //    40: invokestatic    com/viaversion/viaversion/api/Via.getPlatform:()Lcom/viaversion/viaversion/api/platform/ViaPlatform;
        //    43: invokeinterface com/viaversion/viaversion/api/platform/ViaPlatform.getPluginVersion:()Ljava/lang/String;
        //    48: invokespecial   com/viaversion/viaversion/update/Version.<init>:(Ljava/lang/String;)V
        //    51: astore_2        /* lllllllllllllIlIIIIIIlIIIlllIlII */
        //    52: goto            59
        //    55: astore_3        /* lllllllllllllIlIIIIIIlIIIllIlIlI */
        //    56: ldc             "You are using a custom version, consider updating."
        //    58: areturn        
        //    59: new             Lcom/viaversion/viaversion/update/Version;
        //    62: dup            
        //    63: aload_1         /* lllllllllllllIlIIIIIIlIIIlllIIII */
        //    64: invokespecial   com/viaversion/viaversion/update/Version.<init>:(Ljava/lang/String;)V
        //    67: astore_3        /* lllllllllllllIlIIIIIIlIIIllIlIlI */
        //    68: aload_2         /* lllllllllllllIlIIIIIIlIIIllIllll */
        //    69: aload_3         /* lllllllllllllIlIIIIIIlIIIllIlllI */
        //    70: invokevirtual   com/viaversion/viaversion/update/Version.compareTo:(Lcom/viaversion/viaversion/update/Version;)I
        //    73: ifge            105
        //    76: new             Ljava/lang/StringBuilder;
        //    79: dup            
        //    80: invokespecial   java/lang/StringBuilder.<init>:()V
        //    83: ldc             "There is a newer plugin version available: "
        //    85: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    88: aload_3         /* lllllllllllllIlIIIIIIlIIIllIlllI */
        //    89: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //    92: ldc             ", you're on: "
        //    94: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    97: aload_2         /* lllllllllllllIlIIIIIIlIIIllIllll */
        //    98: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   101: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   104: areturn        
        //   105: iload_0         /* lllllllllllllIlIIIIIIlIIIllIllIl */
        //   106: ifeq            155
        //   109: aload_2         /* lllllllllllllIlIIIIIIlIIIllIllll */
        //   110: aload_3         /* lllllllllllllIlIIIIIIlIIIllIlllI */
        //   111: invokevirtual   com/viaversion/viaversion/update/Version.compareTo:(Lcom/viaversion/viaversion/update/Version;)I
        //   114: ifeq            155
        //   117: aload_2         /* lllllllllllllIlIIIIIIlIIIllIllll */
        //   118: invokevirtual   com/viaversion/viaversion/update/Version.getTag:()Ljava/lang/String;
        //   121: getstatic       java/util/Locale.ROOT:Ljava/util/Locale;
        //   124: invokevirtual   java/lang/String.toLowerCase:(Ljava/util/Locale;)Ljava/lang/String;
        //   127: astore          lllllllllllllIlIIIIIIlIIIlllIIlI
        //   129: aload           lllllllllllllIlIIIIIIlIIIlllIIlI
        //   131: ldc             "dev"
        //   133: invokevirtual   java/lang/String.startsWith:(Ljava/lang/String;)Z
        //   136: ifne            149
        //   139: aload           lllllllllllllIlIIIIIIlIIIlllIIlI
        //   141: ldc             "snapshot"
        //   143: invokevirtual   java/lang/String.startsWith:(Ljava/lang/String;)Z
        //   146: ifeq            152
        //   149: ldc             "You are running a development version of the plugin, please report any bugs to GitHub."
        //   151: areturn        
        //   152: ldc             "You are running a newer version of the plugin than is released!"
        //   154: areturn        
        //   155: aconst_null    
        //   156: areturn        
        //    RuntimeVisibleTypeAnnotations: 00 01 14 00 00 72 00 00
        //    StackMapTable: 00 09 13 FC 00 0E 07 00 3B 01 52 07 00 74 FC 00 03 07 00 87 FC 00 2D 07 00 87 FC 00 2B 07 00 3B 02 FA 00 02
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                
        //  -----  -----  -----  -----  ------------------------------------
        //  36     52     55     59     Ljava/lang/IllegalArgumentException;
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
    
    public static void sendUpdateMessage() {
        final String lllllllllllllIlIIIIIIlIIIlIIllll;
        Via.getPlatform().runAsync(() -> {
            lllllllllllllIlIIIIIIlIIIlIIllll = getUpdateMessage(true);
            if (lllllllllllllIlIIIIIIlIIIlIIllll != null) {
                Via.getPlatform().runSync(() -> Via.getPlatform().getLogger().warning(lllllllllllllIlIIIIIIlIIIlIIllll));
            }
        });
    }
    
    private static String getNewestVersion() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: new             Ljava/lang/StringBuilder;
        //     7: dup            
        //     8: invokespecial   java/lang/StringBuilder.<init>:()V
        //    11: ldc             "https://api.spiget.org/v2/resources/19254/versions/latest?"
        //    13: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    16: invokestatic    java/lang/System.currentTimeMillis:()J
        //    19: invokevirtual   java/lang/StringBuilder.append:(J)Ljava/lang/StringBuilder;
        //    22: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //    25: invokespecial   java/net/URL.<init>:(Ljava/lang/String;)V
        //    28: astore_0        /* lllllllllllllIlIIIIIIlIIIlIlllll */
        //    29: aload_0         /* lllllllllllllIlIIIIIIlIIIlIlllll */
        //    30: invokevirtual   java/net/URL.openConnection:()Ljava/net/URLConnection;
        //    33: checkcast       Ljava/net/HttpURLConnection;
        //    36: astore_1        /* lllllllllllllIlIIIIIIlIIIlIllllI */
        //    37: aload_1         /* lllllllllllllIlIIIIIIlIIIlIllllI */
        //    38: iconst_1       
        //    39: invokevirtual   java/net/HttpURLConnection.setUseCaches:(Z)V
        //    42: aload_1         /* lllllllllllllIlIIIIIIlIIIlIllllI */
        //    43: ldc             "User-Agent"
        //    45: new             Ljava/lang/StringBuilder;
        //    48: dup            
        //    49: invokespecial   java/lang/StringBuilder.<init>:()V
        //    52: ldc             "ViaVersion "
        //    54: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    57: invokestatic    com/viaversion/viaversion/api/Via.getPlatform:()Lcom/viaversion/viaversion/api/platform/ViaPlatform;
        //    60: invokeinterface com/viaversion/viaversion/api/platform/ViaPlatform.getPluginVersion:()Ljava/lang/String;
        //    65: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    68: ldc             " "
        //    70: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    73: invokestatic    com/viaversion/viaversion/api/Via.getPlatform:()Lcom/viaversion/viaversion/api/platform/ViaPlatform;
        //    76: invokeinterface com/viaversion/viaversion/api/platform/ViaPlatform.getPlatformName:()Ljava/lang/String;
        //    81: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    84: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //    87: invokevirtual   java/net/HttpURLConnection.addRequestProperty:(Ljava/lang/String;Ljava/lang/String;)V
        //    90: aload_1         /* lllllllllllllIlIIIIIIlIIIlIllllI */
        //    91: iconst_1       
        //    92: invokevirtual   java/net/HttpURLConnection.setDoOutput:(Z)V
        //    95: new             Ljava/io/BufferedReader;
        //    98: dup            
        //    99: new             Ljava/io/InputStreamReader;
        //   102: dup            
        //   103: aload_1         /* lllllllllllllIlIIIIIIlIIIlIllllI */
        //   104: invokevirtual   java/net/HttpURLConnection.getInputStream:()Ljava/io/InputStream;
        //   107: invokespecial   java/io/InputStreamReader.<init>:(Ljava/io/InputStream;)V
        //   110: invokespecial   java/io/BufferedReader.<init>:(Ljava/io/Reader;)V
        //   113: astore_2        /* lllllllllllllIlIIIIIIlIIIlIlllIl */
        //   114: new             Ljava/lang/StringBuilder;
        //   117: dup            
        //   118: invokespecial   java/lang/StringBuilder.<init>:()V
        //   121: astore          lllllllllllllIlIIIIIIlIIIlIllIll
        //   123: aload_2         /* lllllllllllllIlIIIIIIlIIIlIlllIl */
        //   124: invokevirtual   java/io/BufferedReader.readLine:()Ljava/lang/String;
        //   127: dup            
        //   128: astore_3        /* lllllllllllllIlIIIIIIlIIIlIlIlII */
        //   129: ifnull          142
        //   132: aload           lllllllllllllIlIIIIIIlIIIlIllIll
        //   134: aload_3         /* lllllllllllllIlIIIIIIlIIIlIlllII */
        //   135: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   138: pop            
        //   139: goto            123
        //   142: aload_2         /* lllllllllllllIlIIIIIIlIIIlIlllIl */
        //   143: invokevirtual   java/io/BufferedReader.close:()V
        //   146: invokestatic    com/viaversion/viaversion/util/GsonUtil.getGson:()Lcom/viaversion/viaversion/libs/gson/Gson;
        //   149: aload           lllllllllllllIlIIIIIIlIIIlIllIll
        //   151: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   154: ldc_w           Lcom/viaversion/viaversion/libs/gson/JsonObject;.class
        //   157: invokevirtual   com/viaversion/viaversion/libs/gson/Gson.fromJson:(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
        //   160: checkcast       Lcom/viaversion/viaversion/libs/gson/JsonObject;
        //   163: astore          lllllllllllllIlIIIIIIlIIIllIIIIl
        //   165: goto            177
        //   168: astore          lllllllllllllIlIIIIIIlIIIllIIIII
        //   170: aload           lllllllllllllIlIIIIIIlIIIllIIIII
        //   172: invokevirtual   com/viaversion/viaversion/libs/gson/JsonParseException.printStackTrace:()V
        //   175: aconst_null    
        //   176: areturn        
        //   177: aload           lllllllllllllIlIIIIIIlIIIlIllIlI
        //   179: ldc_w           "name"
        //   182: invokevirtual   com/viaversion/viaversion/libs/gson/JsonObject.get:(Ljava/lang/String;)Lcom/viaversion/viaversion/libs/gson/JsonElement;
        //   185: invokevirtual   com/viaversion/viaversion/libs/gson/JsonElement.getAsString:()Ljava/lang/String;
        //   188: areturn        
        //   189: astore_0        /* lllllllllllllIlIIIIIIlIIIlIlllll */
        //   190: aconst_null    
        //   191: areturn        
        //   192: astore_0        /* lllllllllllllIlIIIIIIlIIIlIllIIl */
        //   193: aconst_null    
        //   194: areturn        
        //    RuntimeVisibleTypeAnnotations: 00 01 14 00 00 72 00 00
        //    StackMapTable: 00 06 FF 00 7B 00 05 07 00 D9 07 00 EB 07 01 01 00 07 00 5F 00 00 FF 00 12 00 05 07 00 D9 07 00 EB 07 01 01 07 00 3B 07 00 5F 00 00 59 07 00 D3 FC 00 08 07 01 1B FF 00 0B 00 00 00 01 07 00 D5 42 07 00 D7
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                                    
        //  -----  -----  -----  -----  --------------------------------------------------------
        //  146    165    168    177    Lcom/viaversion/viaversion/libs/gson/JsonParseException;
        //  0      176    189    192    Ljava/net/MalformedURLException;
        //  177    188    189    192    Ljava/net/MalformedURLException;
        //  0      176    192    195    Ljava/io/IOException;
        //  177    188    192    195    Ljava/io/IOException;
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
}
