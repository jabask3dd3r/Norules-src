package com.viaversion.viaversion.libs.javassist;

import com.viaversion.viaversion.libs.javassist.bytecode.*;
import java.io.*;
import java.net.*;

final class ClassPoolTail
{
    protected /* synthetic */ ClassPathList pathList;
    
    public synchronized void removeClassPath(final ClassPath lllllllllllllIllIIIlIIlllllIlIIl) {
        ClassPathList lllllllllllllIllIIIlIIlllllIlIll = this.pathList;
        if (lllllllllllllIllIIIlIIlllllIlIll != null) {
            if (lllllllllllllIllIIIlIIlllllIlIll.path == lllllllllllllIllIIIlIIlllllIlIIl) {
                this.pathList = lllllllllllllIllIIIlIIlllllIlIll.next;
            }
            else {
                while (lllllllllllllIllIIIlIIlllllIlIll.next != null) {
                    if (lllllllllllllIllIIIlIIlllllIlIll.next.path == lllllllllllllIllIIIlIIlllllIlIIl) {
                        lllllllllllllIllIIIlIIlllllIlIll.next = lllllllllllllIllIIIlIIlllllIlIll.next.next;
                    }
                    else {
                        lllllllllllllIllIIIlIIlllllIlIll = lllllllllllllIllIIIlIIlllllIlIll.next;
                    }
                }
            }
        }
    }
    
    void writeClassfile(final String lllllllllllllIllIIIlIIllllIIIIll, final OutputStream lllllllllllllIllIIIlIIlllIlllllI) throws NotFoundException, CannotCompileException, IOException {
        final InputStream lllllllllllllIllIIIlIIllllIIIIIl = this.openClassfile(lllllllllllllIllIIIlIIllllIIIIll);
        if (lllllllllllllIllIIIlIIllllIIIIIl == null) {
            throw new NotFoundException(lllllllllllllIllIIIlIIllllIIIIll);
        }
        try {
            copyStream(lllllllllllllIllIIIlIIllllIIIIIl, lllllllllllllIllIIIlIIlllIlllllI);
        }
        finally {
            lllllllllllllIllIIIlIIllllIIIIIl.close();
        }
    }
    
    public static byte[] readStream(final InputStream lllllllllllllIllIIIlIIlllIIIlllI) throws IOException {
        final byte[][] lllllllllllllIllIIIlIIlllIIIllIl = new byte[8][];
        int lllllllllllllIllIIIlIIlllIIIllII = 4096;
        for (int lllllllllllllIllIIIlIIlllIIIllll = 0; lllllllllllllIllIIIlIIlllIIIllll < 8; ++lllllllllllllIllIIIlIIlllIIIllll) {
            lllllllllllllIllIIIlIIlllIIIllIl[lllllllllllllIllIIIlIIlllIIIllll] = new byte[lllllllllllllIllIIIlIIlllIIIllII];
            int lllllllllllllIllIIIlIIlllIIlIIIl = 0;
            int lllllllllllllIllIIIlIIlllIIlIIII = 0;
            do {
                lllllllllllllIllIIIlIIlllIIlIIII = lllllllllllllIllIIIlIIlllIIIlllI.read(lllllllllllllIllIIIlIIlllIIIllIl[lllllllllllllIllIIIlIIlllIIIllll], lllllllllllllIllIIIlIIlllIIlIIIl, lllllllllllllIllIIIlIIlllIIIllII - lllllllllllllIllIIIlIIlllIIlIIIl);
                if (lllllllllllllIllIIIlIIlllIIlIIII < 0) {
                    final byte[] lllllllllllllIllIIIlIIlllIIlIIll = new byte[lllllllllllllIllIIIlIIlllIIIllII - 4096 + lllllllllllllIllIIIlIIlllIIlIIIl];
                    int lllllllllllllIllIIIlIIlllIIlIIlI = 0;
                    for (int lllllllllllllIllIIIlIIlllIIlIlII = 0; lllllllllllllIllIIIlIIlllIIlIlII < lllllllllllllIllIIIlIIlllIIIllll; ++lllllllllllllIllIIIlIIlllIIlIlII) {
                        System.arraycopy(lllllllllllllIllIIIlIIlllIIIllIl[lllllllllllllIllIIIlIIlllIIlIlII], 0, lllllllllllllIllIIIlIIlllIIlIIll, lllllllllllllIllIIIlIIlllIIlIIlI, lllllllllllllIllIIIlIIlllIIlIIlI + 4096);
                        lllllllllllllIllIIIlIIlllIIlIIlI = lllllllllllllIllIIIlIIlllIIlIIlI + lllllllllllllIllIIIlIIlllIIlIIlI + 4096;
                    }
                    System.arraycopy(lllllllllllllIllIIIlIIlllIIIllIl[lllllllllllllIllIIIlIIlllIIIllll], 0, lllllllllllllIllIIIlIIlllIIlIIll, lllllllllllllIllIIIlIIlllIIlIIlI, lllllllllllllIllIIIlIIlllIIlIIIl);
                    return lllllllllllllIllIIIlIIlllIIlIIll;
                }
                lllllllllllllIllIIIlIIlllIIlIIIl += lllllllllllllIllIIIlIIlllIIlIIII;
            } while (lllllllllllllIllIIIlIIlllIIlIIIl < lllllllllllllIllIIIlIIlllIIIllII);
            lllllllllllllIllIIIlIIlllIIIllII *= 2;
        }
        throw new IOException("too much data");
    }
    
    public ClassPath appendSystemPath() {
        if (ClassFile.MAJOR_VERSION < 53) {
            return this.appendClassPath(new ClassClassPath());
        }
        final ClassLoader lllllllllllllIllIIIlIIlllllIIlII = Thread.currentThread().getContextClassLoader();
        return this.appendClassPath(new LoaderClassPath(lllllllllllllIllIIIlIIlllllIIlII));
    }
    
    public ClassPath insertClassPath(final String lllllllllllllIllIIIlIIllllIlllII) throws NotFoundException {
        return this.insertClassPath(makePathObject(lllllllllllllIllIIIlIIllllIlllII));
    }
    
    public ClassPoolTail() {
        this.pathList = null;
    }
    
    public synchronized ClassPath appendClassPath(final ClassPath lllllllllllllIllIIIlIIllllllIlll) {
        final ClassPathList lllllllllllllIllIIIlIIllllllIllI = new ClassPathList(lllllllllllllIllIIIlIIllllllIlll, null);
        ClassPathList lllllllllllllIllIIIlIIllllllIlIl = this.pathList;
        if (lllllllllllllIllIIIlIIllllllIlIl == null) {
            this.pathList = lllllllllllllIllIIIlIIllllllIllI;
        }
        else {
            while (lllllllllllllIllIIIlIIllllllIlIl.next != null) {
                lllllllllllllIllIIIlIIllllllIlIl = lllllllllllllIllIIIlIIllllllIlIl.next;
            }
            lllllllllllllIllIIIlIIllllllIlIl.next = lllllllllllllIllIIIlIIllllllIllI;
        }
        return lllllllllllllIllIIIlIIllllllIlll;
    }
    
    public ClassPath appendClassPath(final String lllllllllllllIllIIIlIIllllIllIII) throws NotFoundException {
        return this.appendClassPath(makePathObject(lllllllllllllIllIIIlIIllllIllIII));
    }
    
    @Override
    public String toString() {
        final StringBuffer lllllllllllllIllIIIlIlIIIIIIIlll = new StringBuffer();
        lllllllllllllIllIIIlIlIIIIIIIlll.append("[class path: ");
        for (ClassPathList lllllllllllllIllIIIlIlIIIIIIIllI = this.pathList; lllllllllllllIllIIIlIlIIIIIIIllI != null; lllllllllllllIllIIIlIlIIIIIIIllI = lllllllllllllIllIIIlIlIIIIIIIllI.next) {
            lllllllllllllIllIIIlIlIIIIIIIlll.append(lllllllllllllIllIIIlIlIIIIIIIllI.path.toString());
            lllllllllllllIllIIIlIlIIIIIIIlll.append(File.pathSeparatorChar);
        }
        lllllllllllllIllIIIlIlIIIIIIIlll.append(']');
        return lllllllllllllIllIIIlIlIIIIIIIlll.toString();
    }
    
    private static ClassPath makePathObject(final String lllllllllllllIllIIIlIIllllIIllIl) throws NotFoundException {
        final String lllllllllllllIllIIIlIIllllIIllll = lllllllllllllIllIIIlIIllllIIllIl.toLowerCase();
        if (lllllllllllllIllIIIlIIllllIIllll.endsWith(".jar") || lllllllllllllIllIIIlIIllllIIllll.endsWith(".zip")) {
            return new JarClassPath(lllllllllllllIllIIIlIIllllIIllIl);
        }
        final int lllllllllllllIllIIIlIIllllIIlllI = lllllllllllllIllIIIlIIllllIIllIl.length();
        if (lllllllllllllIllIIIlIIllllIIlllI > 2 && lllllllllllllIllIIIlIIllllIIllIl.charAt(lllllllllllllIllIIIlIIllllIIlllI - 1) == '*' && (lllllllllllllIllIIIlIIllllIIllIl.charAt(lllllllllllllIllIIIlIIllllIIlllI - 2) == '/' || lllllllllllllIllIIIlIIllllIIllIl.charAt(lllllllllllllIllIIIlIIllllIIlllI - 2) == File.separatorChar)) {
            final String lllllllllllllIllIIIlIIllllIlIIIl = lllllllllllllIllIIIlIIllllIIllIl.substring(0, lllllllllllllIllIIIlIIllllIIlllI - 2);
            return new JarDirClassPath(lllllllllllllIllIIIlIIllllIlIIIl);
        }
        return new DirClassPath(lllllllllllllIllIIIlIIllllIIllIl);
    }
    
    public URL find(final String lllllllllllllIllIIIlIIlllIlIIlII) {
        ClassPathList lllllllllllllIllIIIlIIlllIlIIIll = this.pathList;
        URL lllllllllllllIllIIIlIIlllIlIIIlI = null;
        while (lllllllllllllIllIIIlIIlllIlIIIll != null) {
            lllllllllllllIllIIIlIIlllIlIIIlI = lllllllllllllIllIIIlIIlllIlIIIll.path.find(lllllllllllllIllIIIlIIlllIlIIlII);
            if (lllllllllllllIllIIIlIIlllIlIIIlI != null) {
                return lllllllllllllIllIIIlIIlllIlIIIlI;
            }
            lllllllllllllIllIIIlIIlllIlIIIll = lllllllllllllIllIIIlIIlllIlIIIll.next;
        }
        return null;
    }
    
    InputStream openClassfile(final String lllllllllllllIllIIIlIIlllIlIlllI) throws NotFoundException {
        ClassPathList lllllllllllllIllIIIlIIlllIllIIlI = this.pathList;
        InputStream lllllllllllllIllIIIlIIlllIllIIIl = null;
        NotFoundException lllllllllllllIllIIIlIIlllIllIIII = null;
        while (lllllllllllllIllIIIlIIlllIllIIlI != null) {
            try {
                lllllllllllllIllIIIlIIlllIllIIIl = lllllllllllllIllIIIlIIlllIllIIlI.path.openClassfile(lllllllllllllIllIIIlIIlllIlIlllI);
            }
            catch (NotFoundException lllllllllllllIllIIIlIIlllIllIlIl) {
                if (lllllllllllllIllIIIlIIlllIllIIII == null) {
                    lllllllllllllIllIIIlIIlllIllIIII = lllllllllllllIllIIIlIIlllIllIlIl;
                }
            }
            if (lllllllllllllIllIIIlIIlllIllIIIl != null) {
                return lllllllllllllIllIIIlIIlllIllIIIl;
            }
            lllllllllllllIllIIIlIIlllIllIIlI = lllllllllllllIllIIIlIIlllIllIIlI.next;
        }
        if (lllllllllllllIllIIIlIIlllIllIIII != null) {
            throw lllllllllllllIllIIIlIIlllIllIIII;
        }
        return null;
    }
    
    public static void copyStream(final InputStream lllllllllllllIllIIIlIIllIlllIlII, final OutputStream lllllllllllllIllIIIlIIllIlllIIll) throws IOException {
        int lllllllllllllIllIIIlIIllIlllIllI = 4096;
        byte[] lllllllllllllIllIIIlIIllIlllIlIl = null;
        for (int lllllllllllllIllIIIlIIllIllllIIl = 0; lllllllllllllIllIIIlIIllIllllIIl < 64; ++lllllllllllllIllIIIlIIllIllllIIl) {
            if (lllllllllllllIllIIIlIIllIllllIIl < 8) {
                lllllllllllllIllIIIlIIllIlllIllI *= 2;
                lllllllllllllIllIIIlIIllIlllIlIl = new byte[lllllllllllllIllIIIlIIllIlllIllI];
            }
            int lllllllllllllIllIIIlIIllIllllIll = 0;
            int lllllllllllllIllIIIlIIllIllllIlI = 0;
            do {
                lllllllllllllIllIIIlIIllIllllIlI = lllllllllllllIllIIIlIIllIlllIlII.read(lllllllllllllIllIIIlIIllIlllIlIl, lllllllllllllIllIIIlIIllIllllIll, lllllllllllllIllIIIlIIllIlllIllI - lllllllllllllIllIIIlIIllIllllIll);
                if (lllllllllllllIllIIIlIIllIllllIlI < 0) {
                    lllllllllllllIllIIIlIIllIlllIIll.write(lllllllllllllIllIIIlIIllIlllIlIl, 0, lllllllllllllIllIIIlIIllIllllIll);
                    return;
                }
                lllllllllllllIllIIIlIIllIllllIll += lllllllllllllIllIIIlIIllIllllIlI;
            } while (lllllllllllllIllIIIlIIllIllllIll < lllllllllllllIllIIIlIIllIlllIllI);
            lllllllllllllIllIIIlIIllIlllIIll.write(lllllllllllllIllIIIlIIllIlllIlIl);
        }
        throw new IOException("too much data");
    }
    
    public synchronized ClassPath insertClassPath(final ClassPath lllllllllllllIllIIIlIIllllllllIl) {
        this.pathList = new ClassPathList(lllllllllllllIllIIIlIIllllllllIl, this.pathList);
        return lllllllllllllIllIIIlIIllllllllIl;
    }
}
