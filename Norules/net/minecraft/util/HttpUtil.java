package net.minecraft.util;

import java.util.concurrent.atomic.*;
import java.util.*;
import javax.annotation.*;
import java.net.*;
import java.io.*;
import java.util.concurrent.*;
import com.google.common.util.concurrent.*;
import org.apache.logging.log4j.*;

public class HttpUtil
{
    public static final /* synthetic */ ListeningExecutorService DOWNLOADER_EXECUTOR;
    
    public static String buildPostString(final Map<String, Object> llllllllllllllIlIIlIlllIlIllIlll) {
        final StringBuilder llllllllllllllIlIIlIlllIlIlllIll = new StringBuilder();
        for (final Map.Entry<String, Object> llllllllllllllIlIIlIlllIlIlllIlI : llllllllllllllIlIIlIlllIlIllIlll.entrySet()) {
            if (llllllllllllllIlIIlIlllIlIlllIll.length() > 0) {
                llllllllllllllIlIIlIlllIlIlllIll.append('&');
            }
            try {
                llllllllllllllIlIIlIlllIlIlllIll.append(URLEncoder.encode(llllllllllllllIlIIlIlllIlIlllIlI.getKey(), "UTF-8"));
            }
            catch (UnsupportedEncodingException llllllllllllllIlIIlIlllIlIlllIIl) {
                llllllllllllllIlIIlIlllIlIlllIIl.printStackTrace();
            }
            if (llllllllllllllIlIIlIlllIlIlllIlI.getValue() != null) {
                llllllllllllllIlIIlIlllIlIlllIll.append('=');
                try {
                    llllllllllllllIlIIlIlllIlIlllIll.append(URLEncoder.encode(llllllllllllllIlIIlIlllIlIlllIlI.getValue().toString(), "UTF-8"));
                }
                catch (UnsupportedEncodingException llllllllllllllIlIIlIlllIlIlllIII) {
                    llllllllllllllIlIIlIlllIlIlllIII.printStackTrace();
                }
            }
        }
        return String.valueOf(llllllllllllllIlIIlIlllIlIlllIll);
    }
    
    public static String postMap(final URL llllllllllllllIlIIlIlllIlIlIlIlI, final Map<String, Object> llllllllllllllIlIIlIlllIlIlIlIIl, final boolean llllllllllllllIlIIlIlllIlIlIlIII, @Nullable final Proxy llllllllllllllIlIIlIlllIlIlIIlll) {
        return post(llllllllllllllIlIIlIlllIlIlIlIlI, buildPostString(llllllllllllllIlIIlIlllIlIlIlIIl), llllllllllllllIlIIlIlllIlIlIlIII, llllllllllllllIlIIlIlllIlIlIIlll);
    }
    
    public static int getSuitableLanPort() throws IOException {
        ServerSocket llllllllllllllIlIIlIlllIIlllIIII = null;
        int llllllllllllllIlIIlIlllIIllIllll = -1;
        try {
            llllllllllllllIlIIlIlllIIlllIIII = new ServerSocket(0);
            llllllllllllllIlIIlIlllIIllIllll = llllllllllllllIlIIlIlllIIlllIIII.getLocalPort();
        }
        finally {
            try {
                if (llllllllllllllIlIIlIlllIIlllIIII != null) {
                    llllllllllllllIlIIlIlllIIlllIIII.close();
                }
            }
            catch (IOException ex) {}
        }
        try {
            if (llllllllllllllIlIIlIlllIIlllIIII != null) {
                llllllllllllllIlIIlIlllIIlllIIII.close();
            }
        }
        catch (IOException ex2) {}
        return llllllllllllllIlIIlIlllIIllIllll;
    }
    
    public static ListenableFuture<Object> downloadResourcePack(final File llllllllllllllIlIIlIlllIlIIIIIlI, final String llllllllllllllIlIIlIlllIIllllIlI, final Map<String, String> llllllllllllllIlIIlIlllIlIIIIIII, final int llllllllllllllIlIIlIlllIIllllIII, @Nullable final IProgressUpdate llllllllllllllIlIIlIlllIIllllllI, final Proxy llllllllllllllIlIIlIlllIIlllllIl) {
        final ListenableFuture<?> llllllllllllllIlIIlIlllIIlllllII = (ListenableFuture<?>)HttpUtil.DOWNLOADER_EXECUTOR.submit((Runnable)new Runnable() {
            @Override
            public void run() {
                // 
                // This method could not be decompiled.
                // 
                // Original Bytecode:
                // 
                //     1: astore_1        /* lllllllllllllIlllIlIIIIIlIIIlIII */
                //     2: aconst_null    
                //     3: astore_2        /* lllllllllllllIlllIlIIIIIlIIlIlll */
                //     4: aconst_null    
                //     5: astore_3        /* lllllllllllllIlllIlIIIIIlIIlIllI */
                //     6: aload_0         /* lllllllllllllIlllIlIIIIIlIIllIIl */
                //     7: getfield        net/minecraft/util/HttpUtil$1.val$p_180192_4_:Lnet/minecraft/util/IProgressUpdate;
                //    10: ifnull          41
                //    13: aload_0         /* lllllllllllllIlllIlIIIIIlIIllIIl */
                //    14: getfield        net/minecraft/util/HttpUtil$1.val$p_180192_4_:Lnet/minecraft/util/IProgressUpdate;
                //    17: ldc             "resourcepack.downloading"
                //    19: invokestatic    net/minecraft/util/text/translation/I18n.translateToLocal:(Ljava/lang/String;)Ljava/lang/String;
                //    22: invokeinterface net/minecraft/util/IProgressUpdate.resetProgressAndMessage:(Ljava/lang/String;)V
                //    27: aload_0         /* lllllllllllllIlllIlIIIIIlIIllIIl */
                //    28: getfield        net/minecraft/util/HttpUtil$1.val$p_180192_4_:Lnet/minecraft/util/IProgressUpdate;
                //    31: ldc             "resourcepack.requesting"
                //    33: invokestatic    net/minecraft/util/text/translation/I18n.translateToLocal:(Ljava/lang/String;)Ljava/lang/String;
                //    36: invokeinterface net/minecraft/util/IProgressUpdate.displayLoadingString:(Ljava/lang/String;)V
                //    41: sipush          4096
                //    44: newarray        B
                //    46: astore          lllllllllllllIlllIlIIIIIlIIlIlIl
                //    48: new             Ljava/net/URL;
                //    51: dup            
                //    52: aload_0         /* lllllllllllllIlllIlIIIIIlIIllIIl */
                //    53: getfield        net/minecraft/util/HttpUtil$1.val$packUrl:Ljava/lang/String;
                //    56: invokespecial   java/net/URL.<init>:(Ljava/lang/String;)V
                //    59: astore          lllllllllllllIlllIlIIIIIlIIlIlII
                //    61: aload           lllllllllllllIlllIlIIIIIlIIlIlII
                //    63: aload_0         /* lllllllllllllIlllIlIIIIIlIIllIIl */
                //    64: getfield        net/minecraft/util/HttpUtil$1.val$p_180192_5_:Ljava/net/Proxy;
                //    67: invokevirtual   java/net/URL.openConnection:(Ljava/net/Proxy;)Ljava/net/URLConnection;
                //    70: checkcast       Ljava/net/HttpURLConnection;
                //    73: astore_1        /* lllllllllllllIlllIlIIIIIlIIllIII */
                //    74: aload_1         /* lllllllllllllIlllIlIIIIIlIIllIII */
                //    75: iconst_1       
                //    76: invokevirtual   java/net/HttpURLConnection.setInstanceFollowRedirects:(Z)V
                //    79: fconst_0       
                //    80: fstore          lllllllllllllIlllIlIIIIIlIIlIIll
                //    82: aload_0         /* lllllllllllllIlllIlIIIIIlIIllIIl */
                //    83: getfield        net/minecraft/util/HttpUtil$1.val$p_180192_2_:Ljava/util/Map;
                //    86: invokeinterface java/util/Map.entrySet:()Ljava/util/Set;
                //    91: invokeinterface java/util/Set.size:()I
                //    96: i2f            
                //    97: fstore          lllllllllllllIlllIlIIIIIlIIlIIlI
                //    99: aload_0         /* lllllllllllllIlllIlIIIIIlIIllIIl */
                //   100: getfield        net/minecraft/util/HttpUtil$1.val$p_180192_2_:Ljava/util/Map;
                //   103: invokeinterface java/util/Map.entrySet:()Ljava/util/Set;
                //   108: invokeinterface java/util/Set.iterator:()Ljava/util/Iterator;
                //   113: astore          lllllllllllllIlllIlIIIIIlIIIIIII
                //   115: goto            184
                //   118: aload           lllllllllllllIlllIlIIIIIlIIIIIII
                //   120: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
                //   125: checkcast       Ljava/util/Map$Entry;
                //   128: astore          lllllllllllllIlllIlIIIIIlIIlIIIl
                //   130: aload_1         /* lllllllllllllIlllIlIIIIIlIIllIII */
                //   131: aload           lllllllllllllIlllIlIIIIIlIIlIIIl
                //   133: invokeinterface java/util/Map$Entry.getKey:()Ljava/lang/Object;
                //   138: checkcast       Ljava/lang/String;
                //   141: aload           lllllllllllllIlllIlIIIIIlIIlIIIl
                //   143: invokeinterface java/util/Map$Entry.getValue:()Ljava/lang/Object;
                //   148: checkcast       Ljava/lang/String;
                //   151: invokevirtual   java/net/HttpURLConnection.setRequestProperty:(Ljava/lang/String;Ljava/lang/String;)V
                //   154: aload_0         /* lllllllllllllIlllIlIIIIIlIIllIIl */
                //   155: getfield        net/minecraft/util/HttpUtil$1.val$p_180192_4_:Lnet/minecraft/util/IProgressUpdate;
                //   158: ifnull          184
                //   161: aload_0         /* lllllllllllllIlllIlIIIIIlIIllIIl */
                //   162: getfield        net/minecraft/util/HttpUtil$1.val$p_180192_4_:Lnet/minecraft/util/IProgressUpdate;
                //   165: fload           lllllllllllllIlllIlIIIIIlIIlIIll
                //   167: fconst_1       
                //   168: fadd           
                //   169: dup            
                //   170: fstore          lllllllllllllIlllIlIIIIIlIIlIIll
                //   172: fload           lllllllllllllIlllIlIIIIIlIIlIIlI
                //   174: fdiv           
                //   175: ldc             100.0
                //   177: fmul           
                //   178: f2i            
                //   179: invokeinterface net/minecraft/util/IProgressUpdate.setLoadingProgress:(I)V
                //   184: aload           lllllllllllllIlllIlIIIIIlIIIIIII
                //   186: invokeinterface java/util/Iterator.hasNext:()Z
                //   191: ifne            118
                //   194: aload_1         /* lllllllllllllIlllIlIIIIIlIIllIII */
                //   195: invokevirtual   java/net/HttpURLConnection.getInputStream:()Ljava/io/InputStream;
                //   198: astore_2        /* lllllllllllllIlllIlIIIIIlIIlIlll */
                //   199: aload_1         /* lllllllllllllIlllIlIIIIIlIIllIII */
                //   200: invokevirtual   java/net/HttpURLConnection.getContentLength:()I
                //   203: i2f            
                //   204: fstore          lllllllllllllIlllIlIIIIIlIIlIIlI
                //   206: aload_1         /* lllllllllllllIlllIlIIIIIlIIllIII */
                //   207: invokevirtual   java/net/HttpURLConnection.getContentLength:()I
                //   210: istore          lllllllllllllIlllIlIIIIIlIIlIIII
                //   212: aload_0         /* lllllllllllllIlllIlIIIIIlIIllIIl */
                //   213: getfield        net/minecraft/util/HttpUtil$1.val$p_180192_4_:Lnet/minecraft/util/IProgressUpdate;
                //   216: ifnull          263
                //   219: aload_0         /* lllllllllllllIlllIlIIIIIlIIllIIl */
                //   220: getfield        net/minecraft/util/HttpUtil$1.val$p_180192_4_:Lnet/minecraft/util/IProgressUpdate;
                //   223: ldc             "resourcepack.progress"
                //   225: iconst_1       
                //   226: anewarray       Ljava/lang/Object;
                //   229: dup            
                //   230: iconst_0       
                //   231: ldc             "%.2f"
                //   233: iconst_1       
                //   234: anewarray       Ljava/lang/Object;
                //   237: dup            
                //   238: iconst_0       
                //   239: fload           lllllllllllllIlllIlIIIIIlIIlIIlI
                //   241: ldc             1000.0
                //   243: fdiv           
                //   244: ldc             1000.0
                //   246: fdiv           
                //   247: invokestatic    java/lang/Float.valueOf:(F)Ljava/lang/Float;
                //   250: aastore        
                //   251: invokestatic    java/lang/String.format:(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
                //   254: aastore        
                //   255: invokestatic    net/minecraft/util/text/translation/I18n.translateToLocalFormatted:(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
                //   258: invokeinterface net/minecraft/util/IProgressUpdate.displayLoadingString:(Ljava/lang/String;)V
                //   263: aload_0         /* lllllllllllllIlllIlIIIIIlIIllIIl */
                //   264: getfield        net/minecraft/util/HttpUtil$1.val$saveFile:Ljava/io/File;
                //   267: invokevirtual   java/io/File.exists:()Z
                //   270: ifeq            351
                //   273: aload_0         /* lllllllllllllIlllIlIIIIIlIIllIIl */
                //   274: getfield        net/minecraft/util/HttpUtil$1.val$saveFile:Ljava/io/File;
                //   277: invokevirtual   java/io/File.length:()J
                //   280: lstore          lllllllllllllIlllIlIIIIIlIIIllll
                //   282: lload           lllllllllllllIlllIlIIIIIlIIIllll
                //   284: iload           lllllllllllllIlllIlIIIIIlIIlIIII
                //   286: i2l            
                //   287: lcmp           
                //   288: ifne            316
                //   291: aload_0         /* lllllllllllllIlllIlIIIIIlIIllIIl */
                //   292: getfield        net/minecraft/util/HttpUtil$1.val$p_180192_4_:Lnet/minecraft/util/IProgressUpdate;
                //   295: ifnull          307
                //   298: aload_0         /* lllllllllllllIlllIlIIIIIlIIllIIl */
                //   299: getfield        net/minecraft/util/HttpUtil$1.val$p_180192_4_:Lnet/minecraft/util/IProgressUpdate;
                //   302: invokeinterface net/minecraft/util/IProgressUpdate.setDoneWorking:()V
                //   307: aload_2         /* lllllllllllllIlllIlIIIIIlIIlIlll */
                //   308: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/InputStream;)V
                //   311: aload_3         /* lllllllllllllIlllIlIIIIIlIIlIllI */
                //   312: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/OutputStream;)V
                //   315: return         
                //   316: invokestatic    net/minecraft/util/HttpUtil.access$0:()Lorg/apache/logging/log4j/Logger;
                //   319: ldc             "Deleting {} as it does not match what we currently have ({} vs our {})."
                //   321: aload_0         /* lllllllllllllIlllIlIIIIIlIIllIIl */
                //   322: getfield        net/minecraft/util/HttpUtil$1.val$saveFile:Ljava/io/File;
                //   325: iload           lllllllllllllIlllIlIIIIIlIIlIIII
                //   327: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
                //   330: lload           lllllllllllllIlllIlIIIIIlIIIllll
                //   332: invokestatic    java/lang/Long.valueOf:(J)Ljava/lang/Long;
                //   335: invokeinterface org/apache/logging/log4j/Logger.warn:(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
                //   340: aload_0         /* lllllllllllllIlllIlIIIIIlIIllIIl */
                //   341: getfield        net/minecraft/util/HttpUtil$1.val$saveFile:Ljava/io/File;
                //   344: invokestatic    org/apache/commons/io/FileUtils.deleteQuietly:(Ljava/io/File;)Z
                //   347: pop            
                //   348: goto            372
                //   351: aload_0         /* lllllllllllllIlllIlIIIIIlIIllIIl */
                //   352: getfield        net/minecraft/util/HttpUtil$1.val$saveFile:Ljava/io/File;
                //   355: invokevirtual   java/io/File.getParentFile:()Ljava/io/File;
                //   358: ifnull          372
                //   361: aload_0         /* lllllllllllllIlllIlIIIIIlIIllIIl */
                //   362: getfield        net/minecraft/util/HttpUtil$1.val$saveFile:Ljava/io/File;
                //   365: invokevirtual   java/io/File.getParentFile:()Ljava/io/File;
                //   368: invokevirtual   java/io/File.mkdirs:()Z
                //   371: pop            
                //   372: new             Ljava/io/DataOutputStream;
                //   375: dup            
                //   376: new             Ljava/io/FileOutputStream;
                //   379: dup            
                //   380: aload_0         /* lllllllllllllIlllIlIIIIIlIIllIIl */
                //   381: getfield        net/minecraft/util/HttpUtil$1.val$saveFile:Ljava/io/File;
                //   384: invokespecial   java/io/FileOutputStream.<init>:(Ljava/io/File;)V
                //   387: invokespecial   java/io/DataOutputStream.<init>:(Ljava/io/OutputStream;)V
                //   390: astore_3        /* lllllllllllllIlllIlIIIIIlIIlIllI */
                //   391: aload_0         /* lllllllllllllIlllIlIIIIIlIIllIIl */
                //   392: getfield        net/minecraft/util/HttpUtil$1.val$maxSize:I
                //   395: ifle            627
                //   398: fload           lllllllllllllIlllIlIIIIIlIIlIIlI
                //   400: aload_0         /* lllllllllllllIlllIlIIIIIlIIllIIl */
                //   401: getfield        net/minecraft/util/HttpUtil$1.val$maxSize:I
                //   404: i2f            
                //   405: fcmpl          
                //   406: ifle            627
                //   409: aload_0         /* lllllllllllllIlllIlIIIIIlIIllIIl */
                //   410: getfield        net/minecraft/util/HttpUtil$1.val$p_180192_4_:Lnet/minecraft/util/IProgressUpdate;
                //   413: ifnull          425
                //   416: aload_0         /* lllllllllllllIlllIlIIIIIlIIllIIl */
                //   417: getfield        net/minecraft/util/HttpUtil$1.val$p_180192_4_:Lnet/minecraft/util/IProgressUpdate;
                //   420: invokeinterface net/minecraft/util/IProgressUpdate.setDoneWorking:()V
                //   425: new             Ljava/io/IOException;
                //   428: dup            
                //   429: new             Ljava/lang/StringBuilder;
                //   432: dup            
                //   433: ldc             "Filesize is bigger than maximum allowed (file is "
                //   435: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
                //   438: fload           lllllllllllllIlllIlIIIIIlIIlIIll
                //   440: invokevirtual   java/lang/StringBuilder.append:(F)Ljava/lang/StringBuilder;
                //   443: ldc             ", limit is "
                //   445: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
                //   448: aload_0         /* lllllllllllllIlllIlIIIIIlIIllIIl */
                //   449: getfield        net/minecraft/util/HttpUtil$1.val$maxSize:I
                //   452: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
                //   455: ldc             ")"
                //   457: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
                //   460: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
                //   463: invokespecial   java/io/IOException.<init>:(Ljava/lang/String;)V
                //   466: athrow         
                //   467: fload           lllllllllllllIlllIlIIIIIlIIlIIll
                //   469: iload           lllllllllllllIlllIlIIIIIlIIIlllI
                //   471: i2f            
                //   472: fadd           
                //   473: fstore          lllllllllllllIlllIlIIIIIlIIlIIll
                //   475: aload_0         /* lllllllllllllIlllIlIIIIIlIIllIIl */
                //   476: getfield        net/minecraft/util/HttpUtil$1.val$p_180192_4_:Lnet/minecraft/util/IProgressUpdate;
                //   479: ifnull          500
                //   482: aload_0         /* lllllllllllllIlllIlIIIIIlIIllIIl */
                //   483: getfield        net/minecraft/util/HttpUtil$1.val$p_180192_4_:Lnet/minecraft/util/IProgressUpdate;
                //   486: fload           lllllllllllllIlllIlIIIIIlIIlIIll
                //   488: fload           lllllllllllllIlllIlIIIIIlIIlIIlI
                //   490: fdiv           
                //   491: ldc             100.0
                //   493: fmul           
                //   494: f2i            
                //   495: invokeinterface net/minecraft/util/IProgressUpdate.setLoadingProgress:(I)V
                //   500: aload_0         /* lllllllllllllIlllIlIIIIIlIIllIIl */
                //   501: getfield        net/minecraft/util/HttpUtil$1.val$maxSize:I
                //   504: ifle            576
                //   507: fload           lllllllllllllIlllIlIIIIIlIIlIIll
                //   509: aload_0         /* lllllllllllllIlllIlIIIIIlIIllIIl */
                //   510: getfield        net/minecraft/util/HttpUtil$1.val$maxSize:I
                //   513: i2f            
                //   514: fcmpl          
                //   515: ifle            576
                //   518: aload_0         /* lllllllllllllIlllIlIIIIIlIIllIIl */
                //   519: getfield        net/minecraft/util/HttpUtil$1.val$p_180192_4_:Lnet/minecraft/util/IProgressUpdate;
                //   522: ifnull          534
                //   525: aload_0         /* lllllllllllllIlllIlIIIIIlIIllIIl */
                //   526: getfield        net/minecraft/util/HttpUtil$1.val$p_180192_4_:Lnet/minecraft/util/IProgressUpdate;
                //   529: invokeinterface net/minecraft/util/IProgressUpdate.setDoneWorking:()V
                //   534: new             Ljava/io/IOException;
                //   537: dup            
                //   538: new             Ljava/lang/StringBuilder;
                //   541: dup            
                //   542: ldc             "Filesize was bigger than maximum allowed (got >= "
                //   544: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
                //   547: fload           lllllllllllllIlllIlIIIIIlIIlIIll
                //   549: invokevirtual   java/lang/StringBuilder.append:(F)Ljava/lang/StringBuilder;
                //   552: ldc             ", limit was "
                //   554: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
                //   557: aload_0         /* lllllllllllllIlllIlIIIIIlIIllIIl */
                //   558: getfield        net/minecraft/util/HttpUtil$1.val$maxSize:I
                //   561: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
                //   564: ldc             ")"
                //   566: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
                //   569: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
                //   572: invokespecial   java/io/IOException.<init>:(Ljava/lang/String;)V
                //   575: athrow         
                //   576: invokestatic    java/lang/Thread.interrupted:()Z
                //   579: ifeq            618
                //   582: invokestatic    net/minecraft/util/HttpUtil.access$0:()Lorg/apache/logging/log4j/Logger;
                //   585: ldc_w           "INTERRUPTED"
                //   588: invokeinterface org/apache/logging/log4j/Logger.error:(Ljava/lang/String;)V
                //   593: aload_0         /* lllllllllllllIlllIlIIIIIlIIllIIl */
                //   594: getfield        net/minecraft/util/HttpUtil$1.val$p_180192_4_:Lnet/minecraft/util/IProgressUpdate;
                //   597: ifnull          609
                //   600: aload_0         /* lllllllllllllIlllIlIIIIIlIIllIIl */
                //   601: getfield        net/minecraft/util/HttpUtil$1.val$p_180192_4_:Lnet/minecraft/util/IProgressUpdate;
                //   604: invokeinterface net/minecraft/util/IProgressUpdate.setDoneWorking:()V
                //   609: aload_2         /* lllllllllllllIlllIlIIIIIlIIlIlll */
                //   610: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/InputStream;)V
                //   613: aload_3         /* lllllllllllllIlllIlIIIIIlIIlIllI */
                //   614: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/OutputStream;)V
                //   617: return         
                //   618: aload_3         /* lllllllllllllIlllIlIIIIIlIIlIllI */
                //   619: aload           lllllllllllllIlllIlIIIIIlIIlIlIl
                //   621: iconst_0       
                //   622: iload           lllllllllllllIlllIlIIIIIlIIIlllI
                //   624: invokevirtual   java/io/OutputStream.write:([BII)V
                //   627: aload_2         /* lllllllllllllIlllIlIIIIIlIIlIlll */
                //   628: aload           lllllllllllllIlllIlIIIIIlIIlIlIl
                //   630: invokevirtual   java/io/InputStream.read:([B)I
                //   633: dup            
                //   634: istore          lllllllllllllIlllIlIIIIIlIIIllIl
                //   636: ifge            467
                //   639: aload_0         /* lllllllllllllIlllIlIIIIIlIIllIIl */
                //   640: getfield        net/minecraft/util/HttpUtil$1.val$p_180192_4_:Lnet/minecraft/util/IProgressUpdate;
                //   643: ifnull          742
                //   646: aload_0         /* lllllllllllllIlllIlIIIIIlIIllIIl */
                //   647: getfield        net/minecraft/util/HttpUtil$1.val$p_180192_4_:Lnet/minecraft/util/IProgressUpdate;
                //   650: invokeinterface net/minecraft/util/IProgressUpdate.setDoneWorking:()V
                //   655: aload_2         /* lllllllllllllIlllIlIIIIIlIIlIlll */
                //   656: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/InputStream;)V
                //   659: aload_3         /* lllllllllllllIlllIlIIIIIlIIlIllI */
                //   660: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/OutputStream;)V
                //   663: return         
                //   664: astore          lllllllllllllIlllIlIIIIIlIIIllII
                //   666: aload           lllllllllllllIlllIlIIIIIlIIIllII
                //   668: invokevirtual   java/lang/Throwable.printStackTrace:()V
                //   671: aload_1         /* lllllllllllllIlllIlIIIIIlIIllIII */
                //   672: ifnull          704
                //   675: aload_1         /* lllllllllllllIlllIlIIIIIlIIllIII */
                //   676: invokevirtual   java/net/HttpURLConnection.getErrorStream:()Ljava/io/InputStream;
                //   679: astore          lllllllllllllIlllIlIIIIIlIIIlIll
                //   681: invokestatic    net/minecraft/util/HttpUtil.access$0:()Lorg/apache/logging/log4j/Logger;
                //   684: aload           lllllllllllllIlllIlIIIIIlIIIlIll
                //   686: invokestatic    org/apache/commons/io/IOUtils.toString:(Ljava/io/InputStream;)Ljava/lang/String;
                //   689: invokeinterface org/apache/logging/log4j/Logger.error:(Ljava/lang/String;)V
                //   694: goto            704
                //   697: astore          lllllllllllllIlllIlIIIIIlIIIlIlI
                //   699: aload           lllllllllllllIlllIlIIIIIlIIIlIlI
                //   701: invokevirtual   java/io/IOException.printStackTrace:()V
                //   704: aload_0         /* lllllllllllllIlllIlIIIIIlIIllIIl */
                //   705: getfield        net/minecraft/util/HttpUtil$1.val$p_180192_4_:Lnet/minecraft/util/IProgressUpdate;
                //   708: ifnull          742
                //   711: aload_0         /* lllllllllllllIlllIlIIIIIlIIllIIl */
                //   712: getfield        net/minecraft/util/HttpUtil$1.val$p_180192_4_:Lnet/minecraft/util/IProgressUpdate;
                //   715: invokeinterface net/minecraft/util/IProgressUpdate.setDoneWorking:()V
                //   720: aload_2         /* lllllllllllllIlllIlIIIIIlIIlIlll */
                //   721: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/InputStream;)V
                //   724: aload_3         /* lllllllllllllIlllIlIIIIIlIIlIllI */
                //   725: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/OutputStream;)V
                //   728: return         
                //   729: astore          lllllllllllllIlllIlIIIIIIlllllll
                //   731: aload_2         /* lllllllllllllIlllIlIIIIIlIIlIlll */
                //   732: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/InputStream;)V
                //   735: aload_3         /* lllllllllllllIlllIlIIIIIlIIlIllI */
                //   736: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/OutputStream;)V
                //   739: aload           lllllllllllllIlllIlIIIIIIlllllll
                //   741: athrow         
                //   742: aload_2         /* lllllllllllllIlllIlIIIIIlIIlIlll */
                //   743: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/InputStream;)V
                //   746: aload_3         /* lllllllllllllIlllIlIIIIIlIIlIllI */
                //   747: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/OutputStream;)V
                //   750: return         
                //    StackMapTable: 00 15 FE 00 29 05 05 05 FF 00 4C 00 0A 07 00 02 07 00 5D 05 05 07 01 49 07 00 55 02 02 00 07 00 71 00 00 FB 00 41 FF 00 4E 00 0A 07 00 02 07 00 5D 07 01 11 05 07 01 49 07 00 55 02 02 01 07 00 71 00 00 FF 00 2B 00 0A 07 00 02 07 00 5D 07 01 11 05 07 01 49 07 00 55 02 02 01 04 00 00 08 FF 00 22 00 0A 07 00 02 07 00 5D 07 01 11 05 07 01 49 07 00 55 02 02 01 07 00 71 00 00 FA 00 14 FF 00 34 00 09 07 00 02 07 00 5D 07 01 11 07 00 DD 07 01 49 07 00 55 02 02 01 00 00 FC 00 29 01 20 21 29 20 08 FA 00 08 FF 00 24 00 04 07 00 02 07 00 5D 07 01 11 07 00 DD 00 01 07 00 3E FF 00 20 00 06 07 00 02 07 00 5D 07 01 11 07 00 DD 07 00 3E 07 01 11 00 01 07 00 40 FA 00 06 FF 00 18 00 04 07 00 02 07 00 5D 07 01 11 07 00 DD 00 01 07 00 3E FC 00 0C 07 00 04
                //    Exceptions:
                //  Try           Handler
                //  Start  End    Start  End    Type                 
                //  -----  -----  -----  -----  ---------------------
                //  41     307    664    729    Ljava/lang/Throwable;
                //  316    609    664    729    Ljava/lang/Throwable;
                //  618    655    664    729    Ljava/lang/Throwable;
                //  681    694    697    704    Ljava/io/IOException;
                //  41     307    729    742    Any
                //  316    609    729    742    Any
                //  618    655    729    742    Any
                //  664    720    729    742    Any
                // 
                // The error that occurred was:
                // 
                // java.lang.NullPointerException
                // 
                throw new IllegalStateException("An error occurred while decompiling this method.");
            }
        });
        return (ListenableFuture<Object>)llllllllllllllIlIIlIlllIIlllllII;
    }
    
    private static String post(final URL llllllllllllllIlIIlIlllIlIIlIIlI, final String llllllllllllllIlIIlIlllIlIIlllII, final boolean llllllllllllllIlIIlIlllIlIIlIIII, @Nullable final Proxy llllllllllllllIlIIlIlllIlIIllIlI) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ifnonnull       8
        //     4: getstatic       java/net/Proxy.NO_PROXY:Ljava/net/Proxy;
        //     7: astore_3        /* llllllllllllllIlIIlIlllIlIIIllll */
        //     8: aload_0         /* llllllllllllllIlIIlIlllIlIIlllIl */
        //     9: aload_3         /* llllllllllllllIlIIlIlllIlIIIllll */
        //    10: invokevirtual   java/net/URL.openConnection:(Ljava/net/Proxy;)Ljava/net/URLConnection;
        //    13: checkcast       Ljava/net/HttpURLConnection;
        //    16: astore          llllllllllllllIlIIlIlllIlIIllIIl
        //    18: aload           llllllllllllllIlIIlIlllIlIIllIIl
        //    20: ldc             "POST"
        //    22: invokevirtual   java/net/HttpURLConnection.setRequestMethod:(Ljava/lang/String;)V
        //    25: aload           llllllllllllllIlIIlIlllIlIIllIIl
        //    27: ldc             "Content-Type"
        //    29: ldc             "application/x-www-form-urlencoded"
        //    31: invokevirtual   java/net/HttpURLConnection.setRequestProperty:(Ljava/lang/String;Ljava/lang/String;)V
        //    34: aload           llllllllllllllIlIIlIlllIlIIllIIl
        //    36: ldc             "Content-Length"
        //    38: new             Ljava/lang/StringBuilder;
        //    41: dup            
        //    42: invokespecial   java/lang/StringBuilder.<init>:()V
        //    45: aload_1         /* llllllllllllllIlIIlIlllIlIIlIIIl */
        //    46: invokevirtual   java/lang/String.getBytes:()[B
        //    49: arraylength    
        //    50: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //    53: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //    56: invokevirtual   java/net/HttpURLConnection.setRequestProperty:(Ljava/lang/String;Ljava/lang/String;)V
        //    59: aload           llllllllllllllIlIIlIlllIlIIllIIl
        //    61: ldc             "Content-Language"
        //    63: ldc             "en-US"
        //    65: invokevirtual   java/net/HttpURLConnection.setRequestProperty:(Ljava/lang/String;Ljava/lang/String;)V
        //    68: aload           llllllllllllllIlIIlIlllIlIIllIIl
        //    70: iconst_0       
        //    71: invokevirtual   java/net/HttpURLConnection.setUseCaches:(Z)V
        //    74: aload           llllllllllllllIlIIlIlllIlIIllIIl
        //    76: iconst_1       
        //    77: invokevirtual   java/net/HttpURLConnection.setDoInput:(Z)V
        //    80: aload           llllllllllllllIlIIlIlllIlIIllIIl
        //    82: iconst_1       
        //    83: invokevirtual   java/net/HttpURLConnection.setDoOutput:(Z)V
        //    86: new             Ljava/io/DataOutputStream;
        //    89: dup            
        //    90: aload           llllllllllllllIlIIlIlllIlIIllIIl
        //    92: invokevirtual   java/net/HttpURLConnection.getOutputStream:()Ljava/io/OutputStream;
        //    95: invokespecial   java/io/DataOutputStream.<init>:(Ljava/io/OutputStream;)V
        //    98: astore          llllllllllllllIlIIlIlllIlIIllIII
        //   100: aload           llllllllllllllIlIIlIlllIlIIllIII
        //   102: aload_1         /* llllllllllllllIlIIlIlllIlIIlIIIl */
        //   103: invokevirtual   java/io/DataOutputStream.writeBytes:(Ljava/lang/String;)V
        //   106: aload           llllllllllllllIlIIlIlllIlIIllIII
        //   108: invokevirtual   java/io/DataOutputStream.flush:()V
        //   111: aload           llllllllllllllIlIIlIlllIlIIllIII
        //   113: invokevirtual   java/io/DataOutputStream.close:()V
        //   116: new             Ljava/io/BufferedReader;
        //   119: dup            
        //   120: new             Ljava/io/InputStreamReader;
        //   123: dup            
        //   124: aload           llllllllllllllIlIIlIlllIlIIllIIl
        //   126: invokevirtual   java/net/HttpURLConnection.getInputStream:()Ljava/io/InputStream;
        //   129: invokespecial   java/io/InputStreamReader.<init>:(Ljava/io/InputStream;)V
        //   132: invokespecial   java/io/BufferedReader.<init>:(Ljava/io/Reader;)V
        //   135: astore          llllllllllllllIlIIlIlllIlIIlIlll
        //   137: new             Ljava/lang/StringBuffer;
        //   140: dup            
        //   141: invokespecial   java/lang/StringBuffer.<init>:()V
        //   144: astore          llllllllllllllIlIIlIlllIlIIlIllI
        //   146: goto            165
        //   149: aload           llllllllllllllIlIIlIlllIlIIlIllI
        //   151: aload           llllllllllllllIlIIlIlllIlIIlIlIl
        //   153: invokevirtual   java/lang/StringBuffer.append:(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //   156: pop            
        //   157: aload           llllllllllllllIlIIlIlllIlIIlIllI
        //   159: bipush          13
        //   161: invokevirtual   java/lang/StringBuffer.append:(C)Ljava/lang/StringBuffer;
        //   164: pop            
        //   165: aload           llllllllllllllIlIIlIlllIlIIlIlll
        //   167: invokevirtual   java/io/BufferedReader.readLine:()Ljava/lang/String;
        //   170: dup            
        //   171: astore          llllllllllllllIlIIlIlllIlIIlIlII
        //   173: ifnonnull       149
        //   176: aload           llllllllllllllIlIIlIlllIlIIlIlll
        //   178: invokevirtual   java/io/BufferedReader.close:()V
        //   181: aload           llllllllllllllIlIIlIlllIlIIlIllI
        //   183: invokevirtual   java/lang/StringBuffer.toString:()Ljava/lang/String;
        //   186: areturn        
        //   187: astore          llllllllllllllIlIIlIlllIlIIlIIll
        //   189: iload_2         /* llllllllllllllIlIIlIlllIlIIllIll */
        //   190: ifne            207
        //   193: getstatic       net/minecraft/util/HttpUtil.LOGGER:Lorg/apache/logging/log4j/Logger;
        //   196: ldc_w           "Could not post to {}"
        //   199: aload_0         /* llllllllllllllIlIIlIlllIlIIlllIl */
        //   200: aload           llllllllllllllIlIIlIlllIlIIlIIll
        //   202: invokeinterface org/apache/logging/log4j/Logger.error:(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
        //   207: ldc_w           ""
        //   210: areturn        
        //    RuntimeVisibleTypeAnnotations: 00 01 16 03 00 00 6F 00 00
        //    StackMapTable: 00 05 08 FF 00 8C 00 09 07 00 C5 07 00 39 01 07 00 C0 07 00 CB 07 00 F2 07 01 02 07 01 10 07 00 39 00 00 FA 00 0F FF 00 15 00 04 07 00 C5 07 00 39 01 07 00 C0 00 01 07 00 BE FC 00 13 07 00 BE
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  0      186    187    211    Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    static {
        DOWNLOADER_EXECUTOR = MoreExecutors.listeningDecorator(Executors.newCachedThreadPool(new ThreadFactoryBuilder().setDaemon(true).setNameFormat("Downloader %d").build()));
        DOWNLOAD_THREADS_STARTED = new AtomicInteger(0);
        LOGGER = LogManager.getLogger();
    }
}
