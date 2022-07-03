package com.viaversion.viaversion.libs.javassist.tools.web;

import java.lang.reflect.*;
import java.net.*;
import java.io.*;

public class Viewer extends ClassLoader
{
    private /* synthetic */ int port;
    private /* synthetic */ String server;
    
    public void run(final String llllllllllllllllllIlIIIIIlllIlll, final String[] llllllllllllllllllIlIIIIIlllIIlI) throws Throwable {
        final Class<?> llllllllllllllllllIlIIIIIlllIlIl = this.loadClass(llllllllllllllllllIlIIIIIlllIlll);
        try {
            llllllllllllllllllIlIIIIIlllIlIl.getDeclaredMethod("main", String[].class).invoke(null, llllllllllllllllllIlIIIIIlllIIlI);
        }
        catch (InvocationTargetException llllllllllllllllllIlIIIIIllllIIl) {
            throw llllllllllllllllllIlIIIIIllllIIl.getTargetException();
        }
    }
    
    protected byte[] fetchClass(final String llllllllllllllllllIlIIIIIlIIlIlI) throws Exception {
        final URL llllllllllllllllllIlIIIIIlIIlIII = new URL("http", this.server, this.port, String.valueOf(new StringBuilder().append("/").append(llllllllllllllllllIlIIIIIlIIlIlI.replace('.', '/')).append(".class")));
        final URLConnection llllllllllllllllllIlIIIIIlIIIlll = llllllllllllllllllIlIIIIIlIIlIII.openConnection();
        llllllllllllllllllIlIIIIIlIIIlll.connect();
        final int llllllllllllllllllIlIIIIIlIIIllI = llllllllllllllllllIlIIIIIlIIIlll.getContentLength();
        final InputStream llllllllllllllllllIlIIIIIlIIIlIl = llllllllllllllllllIlIIIIIlIIIlll.getInputStream();
        byte[] llllllllllllllllllIlIIIIIlIIlIIl = null;
        if (llllllllllllllllllIlIIIIIlIIIllI <= 0) {
            final byte[] llllllllllllllllllIlIIIIIlIIlllI = this.readStream(llllllllllllllllllIlIIIIIlIIIlIl);
        }
        else {
            llllllllllllllllllIlIIIIIlIIlIIl = new byte[llllllllllllllllllIlIIIIIlIIIllI];
            int llllllllllllllllllIlIIIIIlIIllII = 0;
            do {
                final int llllllllllllllllllIlIIIIIlIIllIl = llllllllllllllllllIlIIIIIlIIIlIl.read(llllllllllllllllllIlIIIIIlIIlIIl, llllllllllllllllllIlIIIIIlIIllII, llllllllllllllllllIlIIIIIlIIIllI - llllllllllllllllllIlIIIIIlIIllII);
                if (llllllllllllllllllIlIIIIIlIIllIl < 0) {
                    llllllllllllllllllIlIIIIIlIIIlIl.close();
                    throw new IOException(String.valueOf(new StringBuilder().append("the stream was closed: ").append(llllllllllllllllllIlIIIIIlIIlIlI)));
                }
                llllllllllllllllllIlIIIIIlIIllII += llllllllllllllllllIlIIIIIlIIllIl;
            } while (llllllllllllllllllIlIIIIIlIIllII < llllllllllllllllllIlIIIIIlIIIllI);
        }
        llllllllllllllllllIlIIIIIlIIIlIl.close();
        return llllllllllllllllllIlIIIIIlIIlIIl;
    }
    
    public Viewer(final String llllllllllllllllllIlIIIIlIIIIllI, final int llllllllllllllllllIlIIIIlIIIIlIl) {
        this.server = llllllllllllllllllIlIIIIlIIIIllI;
        this.port = llllllllllllllllllIlIIIIlIIIIlIl;
    }
    
    public String getServer() {
        return this.server;
    }
    
    public static void main(final String[] llllllllllllllllllIlIIIIlIIlIIIl) throws Throwable {
        if (llllllllllllllllllIlIIIIlIIlIIIl.length >= 3) {
            final Viewer llllllllllllllllllIlIIIIlIIlIIll = new Viewer(llllllllllllllllllIlIIIIlIIlIIIl[0], Integer.parseInt(llllllllllllllllllIlIIIIlIIlIIIl[1]));
            final String[] llllllllllllllllllIlIIIIlIIlIIlI = new String[llllllllllllllllllIlIIIIlIIlIIIl.length - 3];
            System.arraycopy(llllllllllllllllllIlIIIIlIIlIIIl, 3, llllllllllllllllllIlIIIIlIIlIIlI, 0, llllllllllllllllllIlIIIIlIIlIIIl.length - 3);
            llllllllllllllllllIlIIIIlIIlIIll.run(llllllllllllllllllIlIIIIlIIlIIIl[2], llllllllllllllllllIlIIIIlIIlIIlI);
        }
        else {
            System.err.println("Usage: java javassist.tools.web.Viewer <host> <port> class [args ...]");
        }
    }
    
    @Override
    protected synchronized Class<?> loadClass(final String llllllllllllllllllIlIIIIIllIIllI, final boolean llllllllllllllllllIlIIIIIllIIlIl) throws ClassNotFoundException {
        Class<?> llllllllllllllllllIlIIIIIllIlIII = this.findLoadedClass(llllllllllllllllllIlIIIIIllIIllI);
        if (llllllllllllllllllIlIIIIIllIlIII == null) {
            llllllllllllllllllIlIIIIIllIlIII = this.findClass(llllllllllllllllllIlIIIIIllIIllI);
        }
        if (llllllllllllllllllIlIIIIIllIlIII == null) {
            throw new ClassNotFoundException(llllllllllllllllllIlIIIIIllIIllI);
        }
        if (llllllllllllllllllIlIIIIIllIIlIl) {
            this.resolveClass(llllllllllllllllllIlIIIIIllIlIII);
        }
        return llllllllllllllllllIlIIIIIllIlIII;
    }
    
    public int getPort() {
        return this.port;
    }
    
    @Override
    protected Class<?> findClass(final String llllllllllllllllllIlIIIIIlIlllIl) throws ClassNotFoundException {
        Class<?> llllllllllllllllllIlIIIIIlIlllII = null;
        if (llllllllllllllllllIlIIIIIlIlllIl.startsWith("java.") || llllllllllllllllllIlIIIIIlIlllIl.startsWith("javax.") || llllllllllllllllllIlIIIIIlIlllIl.equals("com.viaversion.viaversion.libs.javassist.tools.web.Viewer")) {
            llllllllllllllllllIlIIIIIlIlllII = this.findSystemClass(llllllllllllllllllIlIIIIIlIlllIl);
        }
        if (llllllllllllllllllIlIIIIIlIlllII == null) {
            try {
                final byte[] llllllllllllllllllIlIIIIIlIlllll = this.fetchClass(llllllllllllllllllIlIIIIIlIlllIl);
                if (llllllllllllllllllIlIIIIIlIlllll != null) {
                    llllllllllllllllllIlIIIIIlIlllII = this.defineClass(llllllllllllllllllIlIIIIIlIlllIl, llllllllllllllllllIlIIIIIlIlllll, 0, llllllllllllllllllIlIIIIIlIlllll.length);
                }
            }
            catch (Exception ex) {}
        }
        return llllllllllllllllllIlIIIIIlIlllII;
    }
    
    private byte[] readStream(final InputStream llllllllllllllllllIlIIIIIIllIlII) throws IOException {
        byte[] llllllllllllllllllIlIIIIIIllIIll = new byte[4096];
        int llllllllllllllllllIlIIIIIIllIIlI = 0;
        int llllllllllllllllllIlIIIIIIllIIIl = 0;
        do {
            llllllllllllllllllIlIIIIIIllIIlI += llllllllllllllllllIlIIIIIIllIIIl;
            if (llllllllllllllllllIlIIIIIIllIIll.length - llllllllllllllllllIlIIIIIIllIIlI <= 0) {
                final byte[] llllllllllllllllllIlIIIIIIllIllI = new byte[llllllllllllllllllIlIIIIIIllIIll.length * 2];
                System.arraycopy(llllllllllllllllllIlIIIIIIllIIll, 0, llllllllllllllllllIlIIIIIIllIllI, 0, llllllllllllllllllIlIIIIIIllIIlI);
                llllllllllllllllllIlIIIIIIllIIll = llllllllllllllllllIlIIIIIIllIllI;
            }
            llllllllllllllllllIlIIIIIIllIIIl = llllllllllllllllllIlIIIIIIllIlII.read(llllllllllllllllllIlIIIIIIllIIll, llllllllllllllllllIlIIIIIIllIIlI, llllllllllllllllllIlIIIIIIllIIll.length - llllllllllllllllllIlIIIIIIllIIlI);
        } while (llllllllllllllllllIlIIIIIIllIIIl >= 0);
        final byte[] llllllllllllllllllIlIIIIIIllIIII = new byte[llllllllllllllllllIlIIIIIIllIIlI];
        System.arraycopy(llllllllllllllllllIlIIIIIIllIIll, 0, llllllllllllllllllIlIIIIIIllIIII, 0, llllllllllllllllllIlIIIIIIllIIlI);
        return llllllllllllllllllIlIIIIIIllIIII;
    }
}
