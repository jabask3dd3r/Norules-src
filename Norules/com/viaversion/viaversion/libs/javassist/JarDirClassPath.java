package com.viaversion.viaversion.libs.javassist;

import java.net.*;
import java.io.*;

final class JarDirClassPath implements ClassPath
{
    /* synthetic */ JarClassPath[] jars;
    
    JarDirClassPath(final String llllllllllllllIllIIIIIlIIIIllIIl) throws NotFoundException {
        final File[] llllllllllllllIllIIIIIlIIIIllIll = new File(llllllllllllllIllIIIIIlIIIIllIIl).listFiles(new FilenameFilter() {
            @Override
            public boolean accept(final File lIllIlIIllllIl, String lIllIlIIlllIll) {
                lIllIlIIlllIll = (float)((String)lIllIlIIlllIll).toLowerCase();
                return ((String)lIllIlIIlllIll).endsWith(".jar") || ((String)lIllIlIIlllIll).endsWith(".zip");
            }
        });
        if (llllllllllllllIllIIIIIlIIIIllIll != null) {
            this.jars = new JarClassPath[llllllllllllllIllIIIIIlIIIIllIll.length];
            for (int llllllllllllllIllIIIIIlIIIIllllI = 0; llllllllllllllIllIIIIIlIIIIllllI < llllllllllllllIllIIIIIlIIIIllIll.length; ++llllllllllllllIllIIIIIlIIIIllllI) {
                this.jars[llllllllllllllIllIIIIIlIIIIllllI] = new JarClassPath(llllllllllllllIllIIIIIlIIIIllIll[llllllllllllllIllIIIIIlIIIIllllI].getPath());
            }
        }
    }
    
    @Override
    public URL find(final String llllllllllllllIllIIIIIlIIIIIIIll) {
        if (this.jars != null) {
            for (int llllllllllllllIllIIIIIlIIIIIIlIl = 0; llllllllllllllIllIIIIIlIIIIIIlIl < this.jars.length; ++llllllllllllllIllIIIIIlIIIIIIlIl) {
                final URL llllllllllllllIllIIIIIlIIIIIIllI = this.jars[llllllllllllllIllIIIIIlIIIIIIlIl].find(llllllllllllllIllIIIIIlIIIIIIIll);
                if (llllllllllllllIllIIIIIlIIIIIIllI != null) {
                    return llllllllllllllIllIIIIIlIIIIIIllI;
                }
            }
        }
        return null;
    }
    
    @Override
    public InputStream openClassfile(final String llllllllllllllIllIIIIIlIIIIIllll) throws NotFoundException {
        if (this.jars != null) {
            for (int llllllllllllllIllIIIIIlIIIIlIIIl = 0; llllllllllllllIllIIIIIlIIIIlIIIl < this.jars.length; ++llllllllllllllIllIIIIIlIIIIlIIIl) {
                final InputStream llllllllllllllIllIIIIIlIIIIlIIlI = this.jars[llllllllllllllIllIIIIIlIIIIlIIIl].openClassfile(llllllllllllllIllIIIIIlIIIIIllll);
                if (llllllllllllllIllIIIIIlIIIIlIIlI != null) {
                    return llllllllllllllIllIIIIIlIIIIlIIlI;
                }
            }
        }
        return null;
    }
}
