package com.viaversion.viaversion.libs.kyori.adventure.util;

import java.util.*;
import java.io.*;
import java.net.*;

public final class UTF8ResourceBundleControl extends ResourceBundle.Control
{
    private static final /* synthetic */ UTF8ResourceBundleControl INSTANCE;
    
    @Override
    public ResourceBundle newBundle(final String llllllllllllllllIllIIlIIllIIllIl, final Locale llllllllllllllllIllIIlIIllIIllll, final String llllllllllllllllIllIIlIIllIlIIII, final ClassLoader llllllllllllllllIllIIlIIllIlIIIl, final boolean llllllllllllllllIllIIlIIllIIlllI) throws IOException, InstantiationException, IllegalAccessException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "java.properties"
        //     3: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //     6: ifeq            122
        //     9: aload_0         /* llllllllllllllllIllIIlIIlIlllIIl */
        //    10: aload_1         /* llllllllllllllllIllIIlIIlIllIlll */
        //    11: aload_2         /* llllllllllllllllIllIIlIIlIllIlIl */
        //    12: invokevirtual   com/viaversion/viaversion/libs/kyori/adventure/util/UTF8ResourceBundleControl.toBundleName:(Ljava/lang/String;Ljava/util/Locale;)Ljava/lang/String;
        //    15: astore          llllllllllllllllIllIIlIIllIIlIIl
        //    17: aload_0         /* llllllllllllllllIllIIlIIlIlllIIl */
        //    18: aload           llllllllllllllllIllIIlIIllIIlIIl
        //    20: ldc             "properties"
        //    22: invokevirtual   com/viaversion/viaversion/libs/kyori/adventure/util/UTF8ResourceBundleControl.toResourceName:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //    25: astore          llllllllllllllllIllIIlIIllIIlIII
        //    27: iload           llllllllllllllllIllIIlIIlIlIllll
        //    29: aload           llllllllllllllllIllIIlIIlIllllII
        //    31: aload           llllllllllllllllIllIIlIIllIIlIII
        //    33: invokedynamic   BootstrapMethod #0, run:(ZLjava/lang/ClassLoader;Ljava/lang/String;)Ljava/security/PrivilegedExceptionAction;
        //    38: invokestatic    java/security/AccessController.doPrivileged:(Ljava/security/PrivilegedExceptionAction;)Ljava/lang/Object;
        //    41: checkcast       Ljava/io/InputStream;
        //    44: astore          llllllllllllllllIllIIlIIllIIllII
        //    46: goto            60
        //    49: astore          llllllllllllllllIllIIlIIllIIlIll
        //    51: aload           llllllllllllllllIllIIlIIllIIlIll
        //    53: invokevirtual   java/security/PrivilegedActionException.getException:()Ljava/lang/Exception;
        //    56: checkcast       Ljava/io/IOException;
        //    59: athrow         
        //    60: aload           llllllllllllllllIllIIlIIllIIIllI
        //    62: ifnull          120
        //    65: new             Ljava/io/InputStreamReader;
        //    68: dup            
        //    69: aload           llllllllllllllllIllIIlIIllIIIllI
        //    71: getstatic       java/nio/charset/StandardCharsets.UTF_8:Ljava/nio/charset/Charset;
        //    74: invokespecial   java/io/InputStreamReader.<init>:(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
        //    77: astore          llllllllllllllllIllIIlIIllIIlIlI
        //    79: new             Ljava/util/PropertyResourceBundle;
        //    82: dup            
        //    83: aload           llllllllllllllllIllIIlIIllIIlIlI
        //    85: invokespecial   java/util/PropertyResourceBundle.<init>:(Ljava/io/Reader;)V
        //    88: astore          llllllllllllllllIllIIlIIlIlIIlll
        //    90: aload           llllllllllllllllIllIIlIIllIIlIlI
        //    92: invokevirtual   java/io/InputStreamReader.close:()V
        //    95: aload           llllllllllllllllIllIIlIIlIlIIlll
        //    97: areturn        
        //    98: astore          llllllllllllllllIllIIlIIlIlIIlll
        //   100: aload           llllllllllllllllIllIIlIIllIIlIlI
        //   102: invokevirtual   java/io/InputStreamReader.close:()V
        //   105: goto            117
        //   108: astore          llllllllllllllllIllIIlIIlIlIIllI
        //   110: aload           llllllllllllllllIllIIlIIlIlIIlll
        //   112: aload           llllllllllllllllIllIIlIIlIlIIllI
        //   114: invokevirtual   java/lang/Throwable.addSuppressed:(Ljava/lang/Throwable;)V
        //   117: aload           llllllllllllllllIllIIlIIlIlIIlll
        //   119: athrow         
        //   120: aconst_null    
        //   121: areturn        
        //   122: aload_0         /* llllllllllllllllIllIIlIIlIlllIIl */
        //   123: aload_1         /* llllllllllllllllIllIIlIIlIllIlll */
        //   124: aload_2         /* llllllllllllllllIllIIlIIlIllIlIl */
        //   125: aload_3         /* llllllllllllllllIllIIlIIlIllIIll */
        //   126: aload           llllllllllllllllIllIIlIIlIllllII
        //   128: iload           llllllllllllllllIllIIlIIlIlIllll
        //   130: invokespecial   java/util/ResourceBundle$Control.newBundle:(Ljava/lang/String;Ljava/util/Locale;Ljava/lang/String;Ljava/lang/ClassLoader;Z)Ljava/util/ResourceBundle;
        //   133: areturn        
        //    Exceptions:
        //  throws java.io.IOException
        //  throws java.lang.InstantiationException
        //  throws java.lang.IllegalAccessException
        //    MethodParameters:
        //  Name                              Flags  
        //  --------------------------------  -----
        //  llllllllllllllllIllIIlIIllIIllIl  FINAL
        //  llllllllllllllllIllIIlIIllIIllll  FINAL
        //  llllllllllllllllIllIIlIIllIlIIII  FINAL
        //  llllllllllllllllIllIIlIIllIlIIIl  FINAL
        //  llllllllllllllllIllIIlIIllIIlllI  FINAL
        //    StackMapTable: 00 07 FF 00 31 00 08 07 00 02 07 00 23 07 00 95 07 00 23 07 00 97 01 07 00 23 07 00 23 00 01 07 00 1D FC 00 0A 07 00 4D FF 00 25 00 0A 07 00 02 07 00 23 07 00 95 07 00 23 07 00 97 01 07 00 23 07 00 23 07 00 4D 07 00 53 00 01 07 00 1F FF 00 09 00 0B 07 00 02 07 00 23 07 00 95 07 00 23 07 00 97 01 07 00 23 07 00 23 07 00 4D 07 00 53 07 00 1F 00 01 07 00 1F 08 F9 00 02 F8 00 01
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                     
        //  -----  -----  -----  -----  -----------------------------------------
        //  27     46     49     60     Ljava/security/PrivilegedActionException;
        //  79     90     98     120    Ljava/lang/Throwable;
        //  100    105    108    117    Ljava/lang/Throwable;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static ResourceBundle.Control get() {
        return UTF8ResourceBundleControl.INSTANCE;
    }
    
    static {
        INSTANCE = new UTF8ResourceBundleControl();
    }
}
