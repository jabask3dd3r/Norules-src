package com.viaversion.viaversion.libs.javassist;

import java.net.*;
import java.io.*;

public class URLClassPath implements ClassPath
{
    protected /* synthetic */ String packageName;
    protected /* synthetic */ int port;
    protected /* synthetic */ String hostname;
    protected /* synthetic */ String directory;
    
    @Override
    public URL find(final String lllllllllllllIIlIlIIIllIllllllll) {
        try {
            final URLConnection lllllllllllllIIlIlIIIlllIIIIIIlI = this.openClassfile0(lllllllllllllIIlIlIIIllIllllllll);
            final InputStream lllllllllllllIIlIlIIIlllIIIIIIIl = lllllllllllllIIlIlIIIlllIIIIIIlI.getInputStream();
            if (lllllllllllllIIlIlIIIlllIIIIIIIl != null) {
                lllllllllllllIIlIlIIIlllIIIIIIIl.close();
                return lllllllllllllIIlIlIIIlllIIIIIIlI.getURL();
            }
        }
        catch (IOException ex) {}
        return null;
    }
    
    private static URLConnection fetchClass0(final String lllllllllllllIIlIlIIIllIllIlIIIl, final int lllllllllllllIIlIlIIIllIllIlIIII, final String lllllllllllllIIlIlIIIllIllIIllll) throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: dup            
        //     4: ldc             "http"
        //     6: aload_0         /* lllllllllllllIIlIlIIIllIllIIllII */
        //     7: iload_1         /* lllllllllllllIIlIlIIIllIllIIlIll */
        //     8: aload_2         /* lllllllllllllIIlIlIIIllIllIIlIlI */
        //     9: invokespecial   java/net/URL.<init>:(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
        //    12: astore_3        /* lllllllllllllIIlIlIIIllIllIlIIll */
        //    13: goto            28
        //    16: astore          lllllllllllllIIlIlIIIllIllIlIIlI
        //    18: new             Ljava/io/IOException;
        //    21: dup            
        //    22: ldc             "invalid URL?"
        //    24: invokespecial   java/io/IOException.<init>:(Ljava/lang/String;)V
        //    27: athrow         
        //    28: aload_3         /* lllllllllllllIIlIlIIIllIllIIlllI */
        //    29: invokevirtual   java/net/URL.openConnection:()Ljava/net/URLConnection;
        //    32: astore          lllllllllllllIIlIlIIIllIllIIllIl
        //    34: aload           lllllllllllllIIlIlIIIllIllIIllIl
        //    36: invokevirtual   java/net/URLConnection.connect:()V
        //    39: aload           lllllllllllllIIlIlIIIllIllIIllIl
        //    41: areturn        
        //    Exceptions:
        //  throws java.io.IOException
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                            
        //  -----  -----  -----  -----  --------------------------------
        //  0      13     16     28     Ljava/net/MalformedURLException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append(this.hostname).append(":").append(this.port).append(this.directory));
    }
    
    private URLConnection openClassfile0(final String lllllllllllllIIlIlIIIlllIIIIlIII) throws IOException {
        if (this.packageName == null || lllllllllllllIIlIlIIIlllIIIIlIII.startsWith(this.packageName)) {
            final String lllllllllllllIIlIlIIIlllIIIIllII = String.valueOf(new StringBuilder().append(this.directory).append(lllllllllllllIIlIlIIIlllIIIIlIII.replace('.', '/')).append(".class"));
            return fetchClass0(this.hostname, this.port, lllllllllllllIIlIlIIIlllIIIIllII);
        }
        return null;
    }
    
    @Override
    public InputStream openClassfile(final String lllllllllllllIIlIlIIIlllIIIlIIll) {
        try {
            final URLConnection lllllllllllllIIlIlIIIlllIIIlIlIl = this.openClassfile0(lllllllllllllIIlIlIIIlllIIIlIIll);
            if (lllllllllllllIIlIlIIIlllIIIlIlIl != null) {
                return lllllllllllllIIlIlIIIlllIIIlIlIl.getInputStream();
            }
        }
        catch (IOException ex) {}
        return null;
    }
    
    public URLClassPath(final String lllllllllllllIIlIlIIIlllIIIlllll, final int lllllllllllllIIlIlIIIlllIIIllllI, final String lllllllllllllIIlIlIIIlllIIIlllIl, final String lllllllllllllIIlIlIIIlllIIIlllII) {
        this.hostname = lllllllllllllIIlIlIIIlllIIIlllll;
        this.port = lllllllllllllIIlIlIIIlllIIIllllI;
        this.directory = lllllllllllllIIlIlIIIlllIIIlllIl;
        this.packageName = lllllllllllllIIlIlIIIlllIIIlllII;
    }
    
    public static byte[] fetchClass(final String lllllllllllllIIlIlIIIllIlllIIIll, final int lllllllllllllIIlIlIIIllIlllIIIlI, final String lllllllllllllIIlIlIIIllIlllIIIIl, final String lllllllllllllIIlIlIIIllIlllIlIII) throws IOException {
        final URLConnection lllllllllllllIIlIlIIIllIlllIIllI = fetchClass0(lllllllllllllIIlIlIIIllIlllIIIll, lllllllllllllIIlIlIIIllIlllIIIlI, String.valueOf(new StringBuilder().append(lllllllllllllIIlIlIIIllIlllIIIIl).append(lllllllllllllIIlIlIIIllIlllIlIII.replace('.', '/')).append(".class")));
        final int lllllllllllllIIlIlIIIllIlllIIlIl = lllllllllllllIIlIlIIIllIlllIIllI.getContentLength();
        final InputStream lllllllllllllIIlIlIIIllIlllIIlII = lllllllllllllIIlIlIIIllIlllIIllI.getInputStream();
        try {
            if (lllllllllllllIIlIlIIIllIlllIIlIl <= 0) {
                final byte[] lllllllllllllIIlIlIIIllIlllIllll = ClassPoolTail.readStream(lllllllllllllIIlIlIIIllIlllIIlII);
            }
            else {
                final byte[] lllllllllllllIIlIlIIIllIlllIllII = new byte[lllllllllllllIIlIlIIIllIlllIIlIl];
                int lllllllllllllIIlIlIIIllIlllIllIl = 0;
                do {
                    final int lllllllllllllIIlIlIIIllIlllIlllI = lllllllllllllIIlIlIIIllIlllIIlII.read(lllllllllllllIIlIlIIIllIlllIllII, lllllllllllllIIlIlIIIllIlllIllIl, lllllllllllllIIlIlIIIllIlllIIlIl - lllllllllllllIIlIlIIIllIlllIllIl);
                    if (lllllllllllllIIlIlIIIllIlllIlllI < 0) {
                        throw new IOException(String.valueOf(new StringBuilder().append("the stream was closed: ").append(lllllllllllllIIlIlIIIllIlllIlIII)));
                    }
                    lllllllllllllIIlIlIIIllIlllIllIl += lllllllllllllIIlIlIIIllIlllIlllI;
                } while (lllllllllllllIIlIlIIIllIlllIllIl < lllllllllllllIIlIlIIIllIlllIIlIl);
            }
        }
        finally {
            lllllllllllllIIlIlIIIllIlllIIlII.close();
        }
        final byte[] lllllllllllllIIlIlIIIllIlllIIlll;
        return lllllllllllllIIlIlIIIllIlllIIlll;
    }
}
