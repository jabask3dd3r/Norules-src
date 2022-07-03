package optifine;

import net.minecraft.client.*;
import java.util.*;
import java.io.*;

public class HttpUtils
{
    private static /* synthetic */ String playerItemsUrl;
    
    static {
        SERVER_URL = "http://s.optifine.net";
        POST_URL = "http://optifine.net";
        HttpUtils.playerItemsUrl = null;
    }
    
    public static synchronized String getPlayerItemsUrl() {
        if (HttpUtils.playerItemsUrl == null) {
            try {
                final boolean llllllllllllllIllIllIIlIIlllIlll = Config.parseBoolean(System.getProperty("player.models.local"), false);
                if (llllllllllllllIllIllIIlIIlllIlll) {
                    final File llllllllllllllIllIllIIlIIlllIllI = Minecraft.getMinecraft().mcDataDir;
                    final File llllllllllllllIllIllIIlIIlllIlIl = new File(llllllllllllllIllIllIIlIIlllIllI, "playermodels");
                    HttpUtils.playerItemsUrl = llllllllllllllIllIllIIlIIlllIlIl.toURI().toURL().toExternalForm();
                }
            }
            catch (Exception llllllllllllllIllIllIIlIIlllIlII) {
                Config.warn(String.valueOf(new StringBuilder().append(llllllllllllllIllIllIIlIIlllIlII.getClass().getName()).append(": ").append(llllllllllllllIllIllIIlIIlllIlII.getMessage())));
            }
            if (HttpUtils.playerItemsUrl == null) {
                HttpUtils.playerItemsUrl = "http://s.optifine.net";
            }
        }
        return HttpUtils.playerItemsUrl;
    }
    
    public static String post(final String llllllllllllllIllIllIIlIlIIIIlll, final Map llllllllllllllIllIllIIlIlIIIIllI, final byte[] llllllllllllllIllIllIIlIlIIIIlIl) throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore_3        /* llllllllllllllIllIllIIlIlIIIIlII */
        //     2: new             Ljava/net/URL;
        //     5: dup            
        //     6: aload_0         /* llllllllllllllIllIllIIlIlIIllIll */
        //     7: invokespecial   java/net/URL.<init>:(Ljava/lang/String;)V
        //    10: astore          llllllllllllllIllIllIIlIlIIlIlII
        //    12: aload           llllllllllllllIllIllIIlIlIIlIlII
        //    14: invokestatic    net/minecraft/client/Minecraft.getMinecraft:()Lnet/minecraft/client/Minecraft;
        //    17: invokevirtual   net/minecraft/client/Minecraft.getProxy:()Ljava/net/Proxy;
        //    20: invokevirtual   java/net/URL.openConnection:(Ljava/net/Proxy;)Ljava/net/URLConnection;
        //    23: checkcast       Ljava/net/HttpURLConnection;
        //    26: astore_3        /* llllllllllllllIllIllIIlIlIIlIlll */
        //    27: aload_3         /* llllllllllllllIllIllIIlIlIIlIlll */
        //    28: ldc             "POST"
        //    30: invokevirtual   java/net/HttpURLConnection.setRequestMethod:(Ljava/lang/String;)V
        //    33: aload_1         /* llllllllllllllIllIllIIlIlIIllIIl */
        //    34: ifnull          106
        //    37: aload_1         /* llllllllllllllIllIllIIlIlIIllIIl */
        //    38: invokeinterface java/util/Map.keySet:()Ljava/util/Set;
        //    43: invokeinterface java/util/Set.iterator:()Ljava/util/Iterator;
        //    48: astore          llllllllllllllIllIllIIlIlIIIIIII
        //    50: goto            96
        //    53: aload           llllllllllllllIllIllIIlIlIIIIIII
        //    55: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    60: astore          llllllllllllllIllIllIIlIlIIlIIll
        //    62: new             Ljava/lang/StringBuilder;
        //    65: dup            
        //    66: invokespecial   java/lang/StringBuilder.<init>:()V
        //    69: aload_1         /* llllllllllllllIllIllIIlIlIIllIIl */
        //    70: aload           llllllllllllllIllIllIIlIlIIlIIll
        //    72: invokeinterface java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //    77: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //    80: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //    83: astore          llllllllllllllIllIllIIlIlIIlIIlI
        //    85: aload_3         /* llllllllllllllIllIllIIlIlIIlIlll */
        //    86: aload           llllllllllllllIllIllIIlIlIIlIIll
        //    88: checkcast       Ljava/lang/String;
        //    91: aload           llllllllllllllIllIllIIlIlIIlIIlI
        //    93: invokevirtual   java/net/HttpURLConnection.setRequestProperty:(Ljava/lang/String;Ljava/lang/String;)V
        //    96: aload           llllllllllllllIllIllIIlIlIIIIIII
        //    98: invokeinterface java/util/Iterator.hasNext:()Z
        //   103: ifne            53
        //   106: aload_3         /* llllllllllllllIllIllIIlIlIIlIlll */
        //   107: ldc             "Content-Type"
        //   109: ldc             "text/plain"
        //   111: invokevirtual   java/net/HttpURLConnection.setRequestProperty:(Ljava/lang/String;Ljava/lang/String;)V
        //   114: aload_3         /* llllllllllllllIllIllIIlIlIIlIlll */
        //   115: ldc             "Content-Length"
        //   117: new             Ljava/lang/StringBuilder;
        //   120: dup            
        //   121: invokespecial   java/lang/StringBuilder.<init>:()V
        //   124: aload_2         /* llllllllllllllIllIllIIlIlIIllIII */
        //   125: arraylength    
        //   126: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   129: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   132: invokevirtual   java/net/HttpURLConnection.setRequestProperty:(Ljava/lang/String;Ljava/lang/String;)V
        //   135: aload_3         /* llllllllllllllIllIllIIlIlIIlIlll */
        //   136: ldc             "Content-Language"
        //   138: ldc             "en-US"
        //   140: invokevirtual   java/net/HttpURLConnection.setRequestProperty:(Ljava/lang/String;Ljava/lang/String;)V
        //   143: aload_3         /* llllllllllllllIllIllIIlIlIIlIlll */
        //   144: iconst_0       
        //   145: invokevirtual   java/net/HttpURLConnection.setUseCaches:(Z)V
        //   148: aload_3         /* llllllllllllllIllIllIIlIlIIlIlll */
        //   149: iconst_1       
        //   150: invokevirtual   java/net/HttpURLConnection.setDoInput:(Z)V
        //   153: aload_3         /* llllllllllllllIllIllIIlIlIIlIlll */
        //   154: iconst_1       
        //   155: invokevirtual   java/net/HttpURLConnection.setDoOutput:(Z)V
        //   158: aload_3         /* llllllllllllllIllIllIIlIlIIlIlll */
        //   159: invokevirtual   java/net/HttpURLConnection.getOutputStream:()Ljava/io/OutputStream;
        //   162: astore          llllllllllllllIllIllIIlIlIIlIIII
        //   164: aload           llllllllllllllIllIllIIlIlIIlIIII
        //   166: aload_2         /* llllllllllllllIllIllIIlIlIIllIII */
        //   167: invokevirtual   java/io/OutputStream.write:([B)V
        //   170: aload           llllllllllllllIllIllIIlIlIIlIIII
        //   172: invokevirtual   java/io/OutputStream.flush:()V
        //   175: aload           llllllllllllllIllIllIIlIlIIlIIII
        //   177: invokevirtual   java/io/OutputStream.close:()V
        //   180: aload_3         /* llllllllllllllIllIllIIlIlIIlIlll */
        //   181: invokevirtual   java/net/HttpURLConnection.getInputStream:()Ljava/io/InputStream;
        //   184: astore          llllllllllllllIllIllIIlIlIIIllll
        //   186: new             Ljava/io/InputStreamReader;
        //   189: dup            
        //   190: aload           llllllllllllllIllIllIIlIlIIIllll
        //   192: ldc             "ASCII"
        //   194: invokespecial   java/io/InputStreamReader.<init>:(Ljava/io/InputStream;Ljava/lang/String;)V
        //   197: astore          llllllllllllllIllIllIIlIlIIIllII
        //   199: new             Ljava/io/BufferedReader;
        //   202: dup            
        //   203: aload           llllllllllllllIllIllIIlIlIIIllII
        //   205: invokespecial   java/io/BufferedReader.<init>:(Ljava/io/Reader;)V
        //   208: astore          llllllllllllllIllIllIIlIlIIIlIll
        //   210: new             Ljava/lang/StringBuffer;
        //   213: dup            
        //   214: invokespecial   java/lang/StringBuffer.<init>:()V
        //   217: astore          llllllllllllllIllIllIIlIlIIIlIlI
        //   219: goto            238
        //   222: aload           llllllllllllllIllIllIIlIlIIIlIlI
        //   224: aload           llllllllllllllIllIllIIlIlIIIlIIl
        //   226: invokevirtual   java/lang/StringBuffer.append:(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //   229: pop            
        //   230: aload           llllllllllllllIllIllIIlIlIIIlIlI
        //   232: bipush          13
        //   234: invokevirtual   java/lang/StringBuffer.append:(C)Ljava/lang/StringBuffer;
        //   237: pop            
        //   238: aload           llllllllllllllIllIllIIlIlIIIlIll
        //   240: invokevirtual   java/io/BufferedReader.readLine:()Ljava/lang/String;
        //   243: dup            
        //   244: astore          llllllllllllllIllIllIIlIlIIIlIII
        //   246: ifnonnull       222
        //   249: aload           llllllllllllllIllIllIIlIlIIIlIll
        //   251: invokevirtual   java/io/BufferedReader.close:()V
        //   254: aload           llllllllllllllIllIllIIlIlIIIlIlI
        //   256: invokevirtual   java/lang/StringBuffer.toString:()Ljava/lang/String;
        //   259: astore          llllllllllllllIllIllIIlIlIIlIllI
        //   261: goto            277
        //   264: astore          llllllllllllllIllIllIIlIIllllIll
        //   266: aload_3         /* llllllllllllllIllIllIIlIlIIlIlll */
        //   267: ifnull          274
        //   270: aload_3         /* llllllllllllllIllIllIIlIlIIlIlll */
        //   271: invokevirtual   java/net/HttpURLConnection.disconnect:()V
        //   274: aload           llllllllllllllIllIllIIlIIllllIll
        //   276: athrow         
        //   277: aload_3         /* llllllllllllllIllIllIIlIlIIlIlll */
        //   278: ifnull          285
        //   281: aload_3         /* llllllllllllllIllIllIIlIlIIlIlll */
        //   282: invokevirtual   java/net/HttpURLConnection.disconnect:()V
        //   285: aload           llllllllllllllIllIllIIlIlIIlIlIl
        //   287: areturn        
        //    Exceptions:
        //  throws java.io.IOException
        //    StackMapTable: 00 09 FF 00 35 00 08 07 00 5F 07 00 89 07 01 1E 07 00 82 00 07 00 44 00 07 00 95 00 00 2A F9 00 09 FF 00 73 00 0C 07 00 5F 07 00 89 07 01 1E 07 00 82 00 07 00 44 07 00 C5 07 01 20 07 00 D5 07 00 DC 07 00 E1 07 00 5F 00 00 FA 00 0F FF 00 19 00 04 07 00 5F 07 00 89 07 01 1E 07 00 82 00 01 07 01 22 FF 00 09 00 0D 07 00 5F 07 00 89 07 01 1E 07 00 82 00 00 00 00 00 00 00 00 07 01 22 00 00 FF 00 02 00 0C 07 00 5F 07 00 89 07 01 1E 07 00 82 07 00 5F 07 00 44 07 00 C5 07 01 20 07 00 D5 07 00 DC 07 00 E1 07 00 5F 00 00 07
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  2      264    264    277    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static byte[] get(final String llllllllllllllIllIllIIlIllIIIlIl) throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore_1        /* llllllllllllllIllIllIIlIllIIIlII */
        //     2: new             Ljava/net/URL;
        //     5: dup            
        //     6: aload_0         /* llllllllllllllIllIllIIlIllIlIIIl */
        //     7: invokespecial   java/net/URL.<init>:(Ljava/lang/String;)V
        //    10: astore_3        /* llllllllllllllIllIllIIlIllIIllIl */
        //    11: aload_3         /* llllllllllllllIllIllIIlIllIIllIl */
        //    12: invokestatic    net/minecraft/client/Minecraft.getMinecraft:()Lnet/minecraft/client/Minecraft;
        //    15: invokevirtual   net/minecraft/client/Minecraft.getProxy:()Ljava/net/Proxy;
        //    18: invokevirtual   java/net/URL.openConnection:(Ljava/net/Proxy;)Ljava/net/URLConnection;
        //    21: checkcast       Ljava/net/HttpURLConnection;
        //    24: astore_1        /* llllllllllllllIllIllIIlIllIlIIII */
        //    25: aload_1         /* llllllllllllllIllIllIIlIllIlIIII */
        //    26: iconst_1       
        //    27: invokevirtual   java/net/HttpURLConnection.setDoInput:(Z)V
        //    30: aload_1         /* llllllllllllllIllIllIIlIllIlIIII */
        //    31: iconst_0       
        //    32: invokevirtual   java/net/HttpURLConnection.setDoOutput:(Z)V
        //    35: aload_1         /* llllllllllllllIllIllIIlIllIlIIII */
        //    36: invokevirtual   java/net/HttpURLConnection.connect:()V
        //    39: aload_1         /* llllllllllllllIllIllIIlIllIlIIII */
        //    40: invokevirtual   java/net/HttpURLConnection.getResponseCode:()I
        //    43: bipush          100
        //    45: idiv           
        //    46: iconst_2       
        //    47: if_icmpeq       93
        //    50: aload_1         /* llllllllllllllIllIllIIlIllIlIIII */
        //    51: invokevirtual   java/net/HttpURLConnection.getErrorStream:()Ljava/io/InputStream;
        //    54: ifnull          65
        //    57: aload_1         /* llllllllllllllIllIllIIlIllIlIIII */
        //    58: invokevirtual   java/net/HttpURLConnection.getErrorStream:()Ljava/io/InputStream;
        //    61: invokestatic    optifine/Config.readAll:(Ljava/io/InputStream;)[B
        //    64: pop            
        //    65: new             Ljava/io/IOException;
        //    68: dup            
        //    69: new             Ljava/lang/StringBuilder;
        //    72: dup            
        //    73: ldc_w           "HTTP response: "
        //    76: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //    79: aload_1         /* llllllllllllllIllIllIIlIllIlIIII */
        //    80: invokevirtual   java/net/HttpURLConnection.getResponseCode:()I
        //    83: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //    86: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //    89: invokespecial   java/io/IOException.<init>:(Ljava/lang/String;)V
        //    92: athrow         
        //    93: aload_1         /* llllllllllllllIllIllIIlIllIlIIII */
        //    94: invokevirtual   java/net/HttpURLConnection.getInputStream:()Ljava/io/InputStream;
        //    97: astore          llllllllllllllIllIllIIlIllIIlIll
        //    99: aload_1         /* llllllllllllllIllIllIIlIllIlIIII */
        //   100: invokevirtual   java/net/HttpURLConnection.getContentLength:()I
        //   103: newarray        B
        //   105: astore          llllllllllllllIllIllIIlIllIIlIlI
        //   107: iconst_0       
        //   108: istore          llllllllllllllIllIllIIlIllIIlIII
        //   110: aload           llllllllllllllIllIllIIlIllIIlIll
        //   112: aload           llllllllllllllIllIllIIlIllIIlIlI
        //   114: iload           llllllllllllllIllIllIIlIllIIlIII
        //   116: aload           llllllllllllllIllIllIIlIllIIlIlI
        //   118: arraylength    
        //   119: iload           llllllllllllllIllIllIIlIllIIlIII
        //   121: isub           
        //   122: invokevirtual   java/io/InputStream.read:([BII)I
        //   125: istore          llllllllllllllIllIllIIlIllIIIlll
        //   127: iload           llllllllllllllIllIllIIlIllIIIlll
        //   129: ifge            157
        //   132: new             Ljava/io/IOException;
        //   135: dup            
        //   136: new             Ljava/lang/StringBuilder;
        //   139: dup            
        //   140: ldc_w           "Input stream closed: "
        //   143: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   146: aload_0         /* llllllllllllllIllIllIIlIllIlIIIl */
        //   147: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   150: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   153: invokespecial   java/io/IOException.<init>:(Ljava/lang/String;)V
        //   156: athrow         
        //   157: iload           llllllllllllllIllIllIIlIllIIlIII
        //   159: iload           llllllllllllllIllIllIIlIllIIIlll
        //   161: iadd           
        //   162: istore          llllllllllllllIllIllIIlIllIIlIII
        //   164: iload           llllllllllllllIllIllIIlIllIIlIII
        //   166: aload           llllllllllllllIllIllIIlIllIIlIlI
        //   168: arraylength    
        //   169: if_icmplt       110
        //   172: aload           llllllllllllllIllIllIIlIllIIlIlI
        //   174: astore_2        /* llllllllllllllIllIllIIlIllIIllll */
        //   175: goto            191
        //   178: astore          llllllllllllllIllIllIIlIlIlllIII
        //   180: aload_1         /* llllllllllllllIllIllIIlIllIlIIII */
        //   181: ifnull          188
        //   184: aload_1         /* llllllllllllllIllIllIIlIllIlIIII */
        //   185: invokevirtual   java/net/HttpURLConnection.disconnect:()V
        //   188: aload           llllllllllllllIllIllIIlIlIlllIII
        //   190: athrow         
        //   191: aload_1         /* llllllllllllllIllIllIIlIllIlIIII */
        //   192: ifnull          199
        //   195: aload_1         /* llllllllllllllIllIllIIlIllIlIIII */
        //   196: invokevirtual   java/net/HttpURLConnection.disconnect:()V
        //   199: aload_2         /* llllllllllllllIllIllIIlIllIIlllI */
        //   200: areturn        
        //    Exceptions:
        //  throws java.io.IOException
        //    StackMapTable: 00 08 FE 00 41 07 00 82 00 07 00 44 1B FE 00 10 07 01 20 07 01 1E 01 FC 00 2E 01 FF 00 14 00 02 07 00 5F 07 00 82 00 01 07 01 22 FF 00 09 00 09 07 00 5F 07 00 82 00 00 00 00 00 00 07 01 22 00 00 FF 00 02 00 08 07 00 5F 07 00 82 07 01 1E 07 00 44 07 01 20 07 01 1E 01 01 00 00 07
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  2      178    178    191    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
}
