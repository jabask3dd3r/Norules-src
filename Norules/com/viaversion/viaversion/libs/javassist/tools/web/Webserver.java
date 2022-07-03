package com.viaversion.viaversion.libs.javassist.tools.web;

import com.viaversion.viaversion.libs.javassist.*;
import java.net.*;
import java.util.*;
import java.io.*;

public class Webserver
{
    public /* synthetic */ String debugDir;
    public /* synthetic */ String htmlfileBase;
    private static final /* synthetic */ byte[] endofline;
    private /* synthetic */ ServerSocket socket;
    protected /* synthetic */ Translator translator;
    private /* synthetic */ ClassPool classPool;
    
    private void sendHeader(final OutputStream lIIIIIIlIlIIlIl, final long lIIIIIIlIlIIlII, final int lIIIIIIlIlIIIll) throws IOException {
        lIIIIIIlIlIIlIl.write("HTTP/1.0 200 OK".getBytes());
        lIIIIIIlIlIIlIl.write(Webserver.endofline);
        lIIIIIIlIlIIlIl.write("Content-Length: ".getBytes());
        lIIIIIIlIlIIlIl.write(Long.toString(lIIIIIIlIlIIlII).getBytes());
        lIIIIIIlIlIIlIl.write(Webserver.endofline);
        if (lIIIIIIlIlIIIll == 2) {
            lIIIIIIlIlIIlIl.write("Content-Type: application/octet-stream".getBytes());
        }
        else if (lIIIIIIlIlIIIll == 1) {
            lIIIIIIlIlIIlIl.write("Content-Type: text/html".getBytes());
        }
        else if (lIIIIIIlIlIIIll == 3) {
            lIIIIIIlIlIIlIl.write("Content-Type: image/gif".getBytes());
        }
        else if (lIIIIIIlIlIIIll == 4) {
            lIIIIIIlIlIIlIl.write("Content-Type: image/jpg".getBytes());
        }
        else if (lIIIIIIlIlIIIll == 5) {
            lIIIIIIlIlIIlIl.write("Content-Type: text/plain".getBytes());
        }
        lIIIIIIlIlIIlIl.write(Webserver.endofline);
        lIIIIIIlIlIIlIl.write(Webserver.endofline);
    }
    
    public Webserver(final int lIIIIIlIlIllIII) throws IOException {
        this.debugDir = null;
        this.htmlfileBase = null;
        this.socket = new ServerSocket(lIIIIIlIlIllIII);
        this.classPool = null;
        this.translator = null;
    }
    
    public void setClassPool(final ClassPool lIIIIIlIlIlIIII) {
        this.classPool = lIIIIIlIlIlIIII;
    }
    
    public void addTranslator(final ClassPool lIIIIIlIlIIlIII, final Translator lIIIIIlIlIIlIlI) throws CannotCompileException, NotFoundException {
        this.classPool = lIIIIIlIlIIlIII;
        this.translator = lIIIIIlIlIIlIlI;
        lIIIIIlIlIIlIlI.start(this.classPool);
    }
    
    public void logging(final String lIIIIIlIlIIIIIl) {
        System.out.println(lIIIIIlIlIIIIIl);
    }
    
    static {
        typeClass = 2;
        typeHtml = 1;
        typeText = 5;
        typeGif = 3;
        typeJpeg = 4;
        endofline = new byte[] { 13, 10 };
    }
    
    private void replyError(final OutputStream lIIIIIIlIIllllI, final BadHttpRequest lIIIIIIlIIllIlI) throws IOException {
        this.logging2(String.valueOf(new StringBuilder().append("bad request: ").append(lIIIIIIlIIllIlI.toString())));
        lIIIIIIlIIllllI.write("HTTP/1.0 400 Bad Request".getBytes());
        lIIIIIIlIIllllI.write(Webserver.endofline);
        lIIIIIIlIIllllI.write(Webserver.endofline);
        lIIIIIIlIIllllI.write("<H1>Bad Request</H1>".getBytes());
    }
    
    final void process(final Socket lIIIIIlIIIllIll) throws IOException {
        final InputStream lIIIIIlIIIllIlI = new BufferedInputStream(lIIIIIlIIIllIll.getInputStream());
        final String lIIIIIlIIIllIIl = this.readLine(lIIIIIlIIIllIlI);
        this.logging(lIIIIIlIIIllIll.getInetAddress().getHostName(), new Date().toString(), lIIIIIlIIIllIIl);
        while (this.skipLine(lIIIIIlIIIllIlI) > 0) {}
        final OutputStream lIIIIIlIIIllIII = new BufferedOutputStream(lIIIIIlIIIllIll.getOutputStream());
        try {
            this.doReply(lIIIIIlIIIllIlI, lIIIIIlIIIllIII, lIIIIIlIIIllIIl);
        }
        catch (BadHttpRequest lIIIIIlIIIlllIl) {
            this.replyError(lIIIIIlIIIllIII, lIIIIIlIIIlllIl);
        }
        lIIIIIlIIIllIII.flush();
        lIIIIIlIIIllIlI.close();
        lIIIIIlIIIllIII.close();
        lIIIIIlIIIllIll.close();
    }
    
    public void doReply(final InputStream lIIIIIIlllIIlII, final OutputStream lIIIIIIlllIIIll, final String lIIIIIIllIllIlI) throws IOException, BadHttpRequest {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc_w           "GET /"
        //     4: invokevirtual   java/lang/String.startsWith:(Ljava/lang/String;)Z
        //     7: ifeq            30
        //    10: aload_3         /* lIIIIIIlllIIIlI */
        //    11: iconst_5       
        //    12: aload_3         /* lIIIIIIlllIIIlI */
        //    13: bipush          32
        //    15: iconst_5       
        //    16: invokevirtual   java/lang/String.indexOf:(II)I
        //    19: invokevirtual   java/lang/String.substring:(II)Ljava/lang/String;
        //    22: dup            
        //    23: astore          lIIIIIIllllIIII
        //    25: astore          lIIIIIIllllIIIl
        //    27: goto            38
        //    30: new             Lcom/viaversion/viaversion/libs/javassist/tools/web/BadHttpRequest;
        //    33: dup            
        //    34: invokespecial   com/viaversion/viaversion/libs/javassist/tools/web/BadHttpRequest.<init>:()V
        //    37: athrow         
        //    38: aload           lIIIIIIllIlllll
        //    40: ldc_w           ".class"
        //    43: invokevirtual   java/lang/String.endsWith:(Ljava/lang/String;)Z
        //    46: ifeq            55
        //    49: iconst_2       
        //    50: istore          lIIIIIIlllIllll
        //    52: goto            120
        //    55: aload           lIIIIIIllIlllll
        //    57: ldc_w           ".html"
        //    60: invokevirtual   java/lang/String.endsWith:(Ljava/lang/String;)Z
        //    63: ifne            77
        //    66: aload           lIIIIIIllIlllll
        //    68: ldc_w           ".htm"
        //    71: invokevirtual   java/lang/String.endsWith:(Ljava/lang/String;)Z
        //    74: ifeq            83
        //    77: iconst_1       
        //    78: istore          lIIIIIIlllIlllI
        //    80: goto            120
        //    83: aload           lIIIIIIllIlllll
        //    85: ldc_w           ".gif"
        //    88: invokevirtual   java/lang/String.endsWith:(Ljava/lang/String;)Z
        //    91: ifeq            100
        //    94: iconst_3       
        //    95: istore          lIIIIIIlllIllIl
        //    97: goto            120
        //   100: aload           lIIIIIIllIlllll
        //   102: ldc_w           ".jpg"
        //   105: invokevirtual   java/lang/String.endsWith:(Ljava/lang/String;)Z
        //   108: ifeq            117
        //   111: iconst_4       
        //   112: istore          lIIIIIIlllIllII
        //   114: goto            120
        //   117: iconst_5       
        //   118: istore          lIIIIIIlllIIIII
        //   120: aload           lIIIIIIllIlllll
        //   122: invokevirtual   java/lang/String.length:()I
        //   125: istore          lIIIIIIlllIIIIl
        //   127: iload           lIIIIIIlllIIIII
        //   129: iconst_2       
        //   130: if_icmpne       146
        //   133: aload_0         /* lIIIIIIllIlllII */
        //   134: aload_2         /* lIIIIIIllIllIll */
        //   135: aload           lIIIIIIllIlllll
        //   137: iload           lIIIIIIlllIIIIl
        //   139: invokespecial   com/viaversion/viaversion/libs/javassist/tools/web/Webserver.letUsersSendClassfile:(Ljava/io/OutputStream;Ljava/lang/String;I)Z
        //   142: ifeq            146
        //   145: return         
        //   146: aload_0         /* lIIIIIIllIlllII */
        //   147: aload           lIIIIIIllIlllll
        //   149: iload           lIIIIIIlllIIIIl
        //   151: invokespecial   com/viaversion/viaversion/libs/javassist/tools/web/Webserver.checkFilename:(Ljava/lang/String;I)V
        //   154: aload_0         /* lIIIIIIllIlllII */
        //   155: getfield        com/viaversion/viaversion/libs/javassist/tools/web/Webserver.htmlfileBase:Ljava/lang/String;
        //   158: ifnull          185
        //   161: new             Ljava/lang/StringBuilder;
        //   164: dup            
        //   165: invokespecial   java/lang/StringBuilder.<init>:()V
        //   168: aload_0         /* lIIIIIIllIlllII */
        //   169: getfield        com/viaversion/viaversion/libs/javassist/tools/web/Webserver.htmlfileBase:Ljava/lang/String;
        //   172: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   175: aload           lIIIIIIllIlllll
        //   177: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   180: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   183: astore          lIIIIIIllIlllll
        //   185: getstatic       java/io/File.separatorChar:C
        //   188: bipush          47
        //   190: if_icmpeq       205
        //   193: aload           lIIIIIIllIlllll
        //   195: bipush          47
        //   197: getstatic       java/io/File.separatorChar:C
        //   200: invokevirtual   java/lang/String.replace:(CC)Ljava/lang/String;
        //   203: astore          lIIIIIIllIlllll
        //   205: new             Ljava/io/File;
        //   208: dup            
        //   209: aload           lIIIIIIllIlllll
        //   211: invokespecial   java/io/File.<init>:(Ljava/lang/String;)V
        //   214: astore          lIIIIIIllIlllIl
        //   216: aload           lIIIIIIllIlllIl
        //   218: invokevirtual   java/io/File.canRead:()Z
        //   221: ifeq            289
        //   224: aload_0         /* lIIIIIIllIlllII */
        //   225: aload_2         /* lIIIIIIllIllIll */
        //   226: aload           lIIIIIIllIlllIl
        //   228: invokevirtual   java/io/File.length:()J
        //   231: iload           lIIIIIIlllIIIII
        //   233: invokespecial   com/viaversion/viaversion/libs/javassist/tools/web/Webserver.sendHeader:(Ljava/io/OutputStream;JI)V
        //   236: new             Ljava/io/FileInputStream;
        //   239: dup            
        //   240: aload           lIIIIIIllIlllIl
        //   242: invokespecial   java/io/FileInputStream.<init>:(Ljava/io/File;)V
        //   245: astore          lIIIIIIlllIlIll
        //   247: sipush          4096
        //   250: newarray        B
        //   252: astore          lIIIIIIlllIlIlI
        //   254: aload           lIIIIIIlllIlIll
        //   256: aload           lIIIIIIlllIlIlI
        //   258: invokevirtual   java/io/FileInputStream.read:([B)I
        //   261: istore          lIIIIIIlllIIIIl
        //   263: iload           lIIIIIIlllIIIIl
        //   265: ifgt            271
        //   268: goto            283
        //   271: aload_2         /* lIIIIIIllIllIll */
        //   272: aload           lIIIIIIlllIlIlI
        //   274: iconst_0       
        //   275: iload           lIIIIIIlllIIIIl
        //   277: invokevirtual   java/io/OutputStream.write:([BII)V
        //   280: goto            254
        //   283: aload           lIIIIIIlllIlIll
        //   285: invokevirtual   java/io/FileInputStream.close:()V
        //   288: return         
        //   289: iload           lIIIIIIlllIIIII
        //   291: iconst_2       
        //   292: if_icmpne       405
        //   295: aload_0         /* lIIIIIIllIlllII */
        //   296: invokevirtual   java/lang/Object.getClass:()Ljava/lang/Class;
        //   299: new             Ljava/lang/StringBuilder;
        //   302: dup            
        //   303: invokespecial   java/lang/StringBuilder.<init>:()V
        //   306: ldc_w           "/"
        //   309: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   312: aload           lIIIIIIllIllllI
        //   314: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   317: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   320: invokevirtual   java/lang/Class.getResourceAsStream:(Ljava/lang/String;)Ljava/io/InputStream;
        //   323: astore          lIIIIIIlllIIllI
        //   325: aload           lIIIIIIlllIIllI
        //   327: ifnull          405
        //   330: new             Ljava/io/ByteArrayOutputStream;
        //   333: dup            
        //   334: invokespecial   java/io/ByteArrayOutputStream.<init>:()V
        //   337: astore          lIIIIIIlllIlIIl
        //   339: sipush          4096
        //   342: newarray        B
        //   344: astore          lIIIIIIlllIlIII
        //   346: aload           lIIIIIIlllIIllI
        //   348: aload           lIIIIIIlllIlIII
        //   350: invokevirtual   java/io/InputStream.read:([B)I
        //   353: istore          lIIIIIIlllIIIIl
        //   355: iload           lIIIIIIlllIIIIl
        //   357: ifgt            363
        //   360: goto            376
        //   363: aload           lIIIIIIlllIlIIl
        //   365: aload           lIIIIIIlllIlIII
        //   367: iconst_0       
        //   368: iload           lIIIIIIlllIIIIl
        //   370: invokevirtual   java/io/ByteArrayOutputStream.write:([BII)V
        //   373: goto            346
        //   376: aload           lIIIIIIlllIlIIl
        //   378: invokevirtual   java/io/ByteArrayOutputStream.toByteArray:()[B
        //   381: astore          lIIIIIIlllIIlll
        //   383: aload_0         /* lIIIIIIllIlllII */
        //   384: aload_2         /* lIIIIIIllIllIll */
        //   385: aload           lIIIIIIlllIIlll
        //   387: arraylength    
        //   388: i2l            
        //   389: iconst_2       
        //   390: invokespecial   com/viaversion/viaversion/libs/javassist/tools/web/Webserver.sendHeader:(Ljava/io/OutputStream;JI)V
        //   393: aload_2         /* lIIIIIIllIllIll */
        //   394: aload           lIIIIIIlllIIlll
        //   396: invokevirtual   java/io/OutputStream.write:([B)V
        //   399: aload           lIIIIIIlllIIllI
        //   401: invokevirtual   java/io/InputStream.close:()V
        //   404: return         
        //   405: new             Lcom/viaversion/viaversion/libs/javassist/tools/web/BadHttpRequest;
        //   408: dup            
        //   409: invokespecial   com/viaversion/viaversion/libs/javassist/tools/web/BadHttpRequest.<init>:()V
        //   412: athrow         
        //    Exceptions:
        //  throws java.io.IOException
        //  throws com.viaversion.viaversion.libs.javassist.tools.web.BadHttpRequest
        //    StackMapTable: 00 13 1E FF 00 07 00 08 07 00 02 07 00 EF 07 00 23 07 00 1D 00 00 07 00 1D 07 00 1D 00 00 10 15 05 10 10 FF 00 02 00 08 07 00 02 07 00 EF 07 00 23 07 00 1D 00 01 07 00 1D 07 00 1D 00 00 FF 00 19 00 08 07 00 02 07 00 EF 07 00 23 07 00 1D 01 01 07 00 1D 07 00 1D 00 00 26 13 FE 00 30 07 01 2C 07 01 40 07 01 85 10 0B F9 00 05 FE 00 38 07 00 EF 07 01 59 07 01 85 10 0C F8 00 1C
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public void run() {
        System.err.println("ready to service...");
    Label_0009_Outer:
        while (true) {
            while (true) {
                try {
                    while (true) {
                        final ServiceThread lIIIIIlIIlIlIII = new ServiceThread(this, this.socket.accept());
                        lIIIIIlIIlIlIII.start();
                    }
                }
                catch (IOException lIIIIIlIIlIIlll) {
                    this.logging(lIIIIIlIIlIIlll.toString());
                    continue Label_0009_Outer;
                }
                continue;
            }
        }
    }
    
    public void logging(final String lIIIIIlIIllllII, final String lIIIIIlIIlllIll) {
        System.out.print(lIIIIIlIIllllII);
        System.out.print(" ");
        System.out.println(lIIIIIlIIlllIll);
    }
    
    private int skipLine(final InputStream lIIIIIlIIIIIIll) throws IOException {
        int lIIIIIlIIIIIIIl = 0;
        int lIIIIIlIIIIIIlI;
        while ((lIIIIIlIIIIIIlI = lIIIIIlIIIIIIll.read()) >= 0 && lIIIIIlIIIIIIlI != 13) {
            ++lIIIIIlIIIIIIIl;
        }
        lIIIIIlIIIIIIll.read();
        return lIIIIIlIIIIIIIl;
    }
    
    public static void main(final String[] lIIIIIlIllIIIll) throws IOException {
        if (lIIIIIlIllIIIll.length == 1) {
            final Webserver lIIIIIlIllIIlIl = new Webserver(lIIIIIlIllIIIll[0]);
            lIIIIIlIllIIlIl.run();
        }
        else {
            System.err.println("Usage: java javassist.tools.web.Webserver <port number>");
        }
    }
    
    public void end() throws IOException {
        this.socket.close();
    }
    
    public Webserver(final String lIIIIIlIlIlllII) throws IOException {
        this(Integer.parseInt(lIIIIIlIlIlllII));
    }
    
    public void logging(final String lIIIIIlIIllIIIl, final String lIIIIIlIIllIIll, final String lIIIIIlIIllIIlI) {
        System.out.print(lIIIIIlIIllIIIl);
        System.out.print(" ");
        System.out.print(lIIIIIlIIllIIll);
        System.out.print(" ");
        System.out.println(lIIIIIlIIllIIlI);
    }
    
    private boolean letUsersSendClassfile(final OutputStream lIIIIIIlIlllIII, final String lIIIIIIlIllIlll, final int lIIIIIIlIllIllI) throws IOException, BadHttpRequest {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        com/viaversion/viaversion/libs/javassist/tools/web/Webserver.classPool:Lcom/viaversion/viaversion/libs/javassist/ClassPool;
        //     4: ifnonnull       9
        //     7: iconst_0       
        //     8: ireturn        
        //     9: aload_2         /* lIIIIIIlIllIIIl */
        //    10: iconst_0       
        //    11: iload_3         /* lIIIIIIlIllIIII */
        //    12: bipush          6
        //    14: isub           
        //    15: invokevirtual   java/lang/String.substring:(II)Ljava/lang/String;
        //    18: bipush          47
        //    20: bipush          46
        //    22: invokevirtual   java/lang/String.replace:(CC)Ljava/lang/String;
        //    25: astore          lIIIIIIlIllIlII
        //    27: aload_0         /* lIIIIIIlIllIIll */
        //    28: getfield        com/viaversion/viaversion/libs/javassist/tools/web/Webserver.translator:Lcom/viaversion/viaversion/libs/javassist/Translator;
        //    31: ifnull          49
        //    34: aload_0         /* lIIIIIIlIllIIll */
        //    35: getfield        com/viaversion/viaversion/libs/javassist/tools/web/Webserver.translator:Lcom/viaversion/viaversion/libs/javassist/Translator;
        //    38: aload_0         /* lIIIIIIlIllIIll */
        //    39: getfield        com/viaversion/viaversion/libs/javassist/tools/web/Webserver.classPool:Lcom/viaversion/viaversion/libs/javassist/ClassPool;
        //    42: aload           lIIIIIIlIllIlII
        //    44: invokeinterface com/viaversion/viaversion/libs/javassist/Translator.onLoad:(Lcom/viaversion/viaversion/libs/javassist/ClassPool;Ljava/lang/String;)V
        //    49: aload_0         /* lIIIIIIlIllIIll */
        //    50: getfield        com/viaversion/viaversion/libs/javassist/tools/web/Webserver.classPool:Lcom/viaversion/viaversion/libs/javassist/ClassPool;
        //    53: aload           lIIIIIIlIllIlII
        //    55: invokevirtual   com/viaversion/viaversion/libs/javassist/ClassPool.get:(Ljava/lang/String;)Lcom/viaversion/viaversion/libs/javassist/CtClass;
        //    58: astore          lIIIIIIlIllllII
        //    60: aload           lIIIIIIlIllllII
        //    62: invokevirtual   com/viaversion/viaversion/libs/javassist/CtClass.toBytecode:()[B
        //    65: astore          lIIIIIIlIlllIll
        //    67: aload_0         /* lIIIIIIlIllIIll */
        //    68: getfield        com/viaversion/viaversion/libs/javassist/tools/web/Webserver.debugDir:Ljava/lang/String;
        //    71: ifnull          83
        //    74: aload           lIIIIIIlIllllII
        //    76: aload_0         /* lIIIIIIlIllIIll */
        //    77: getfield        com/viaversion/viaversion/libs/javassist/tools/web/Webserver.debugDir:Ljava/lang/String;
        //    80: invokevirtual   com/viaversion/viaversion/libs/javassist/CtClass.writeFile:(Ljava/lang/String;)V
        //    83: goto            98
        //    86: astore          lIIIIIIlIlllIlI
        //    88: new             Lcom/viaversion/viaversion/libs/javassist/tools/web/BadHttpRequest;
        //    91: dup            
        //    92: aload           lIIIIIIlIlllIlI
        //    94: invokespecial   com/viaversion/viaversion/libs/javassist/tools/web/BadHttpRequest.<init>:(Ljava/lang/Exception;)V
        //    97: athrow         
        //    98: aload_0         /* lIIIIIIlIllIIll */
        //    99: aload_1         /* lIIIIIIlIllIIlI */
        //   100: aload           lIIIIIIlIllIlIl
        //   102: arraylength    
        //   103: i2l            
        //   104: iconst_2       
        //   105: invokespecial   com/viaversion/viaversion/libs/javassist/tools/web/Webserver.sendHeader:(Ljava/io/OutputStream;JI)V
        //   108: aload_1         /* lIIIIIIlIllIIlI */
        //   109: aload           lIIIIIIlIllIlIl
        //   111: invokevirtual   java/io/OutputStream.write:([B)V
        //   114: iconst_1       
        //   115: ireturn        
        //    Exceptions:
        //  throws java.io.IOException
        //  throws com.viaversion.viaversion.libs.javassist.tools.web.BadHttpRequest
        //    StackMapTable: 00 05 09 FD 00 27 00 07 00 1D FF 00 21 00 07 07 00 02 07 00 23 07 00 1D 01 07 01 85 07 00 1D 07 01 E4 00 00 FF 00 02 00 06 07 00 02 07 00 23 07 00 1D 01 00 07 00 1D 00 01 07 01 D8 FF 00 0B 00 07 07 00 02 07 00 23 07 00 1D 01 07 01 85 07 00 1D 07 01 E4 00 00
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  27     83     86     98     Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private void checkFilename(final String lIIIIIIllIIlIIl, final int lIIIIIIllIIlIII) throws BadHttpRequest {
        for (int lIIIIIIllIIlIll = 0; lIIIIIIllIIlIll < lIIIIIIllIIlIII; ++lIIIIIIllIIlIll) {
            final char lIIIIIIllIIllII = lIIIIIIllIIlIIl.charAt(lIIIIIIllIIlIll);
            if (!Character.isJavaIdentifierPart(lIIIIIIllIIllII) && lIIIIIIllIIllII != '.' && lIIIIIIllIIllII != '/') {
                throw new BadHttpRequest();
            }
        }
        if (lIIIIIIllIIlIIl.indexOf("..") >= 0) {
            throw new BadHttpRequest();
        }
    }
    
    public void logging2(final String lIIIIIlIIlIllII) {
        System.out.print("    ");
        System.out.println(lIIIIIlIIlIllII);
    }
    
    private String readLine(final InputStream lIIIIIlIIIIlIlI) throws IOException {
        final StringBuffer lIIIIIlIIIIllII = new StringBuffer();
        int lIIIIIlIIIIlIll;
        while ((lIIIIIlIIIIlIll = lIIIIIlIIIIlIlI.read()) >= 0 && lIIIIIlIIIIlIll != 13) {
            lIIIIIlIIIIllII.append((char)lIIIIIlIIIIlIll);
        }
        lIIIIIlIIIIlIlI.read();
        return lIIIIIlIIIIllII.toString();
    }
}
