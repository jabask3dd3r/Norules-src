package com.viaversion.viaversion.libs.javassist;

import java.io.*;
import java.net.*;
import java.lang.ref.*;

public class LoaderClassPath implements ClassPath
{
    private /* synthetic */ Reference<ClassLoader> clref;
    
    @Override
    public InputStream openClassfile(final String lllllllllllllllllIlIlIllIIlllIIl) throws NotFoundException {
        final String lllllllllllllllllIlIlIllIIllllIl = String.valueOf(new StringBuilder().append(lllllllllllllllllIlIlIllIIlllIIl.replace('.', '/')).append(".class"));
        final ClassLoader lllllllllllllllllIlIlIllIIllllII = this.clref.get();
        if (lllllllllllllllllIlIlIllIIllllII == null) {
            return null;
        }
        final InputStream lllllllllllllllllIlIlIllIIlllIll = lllllllllllllllllIlIlIllIIllllII.getResourceAsStream(lllllllllllllllllIlIlIllIIllllIl);
        return lllllllllllllllllIlIlIllIIlllIll;
    }
    
    @Override
    public URL find(final String lllllllllllllllllIlIlIllIIlIlIlI) {
        final String lllllllllllllllllIlIlIllIIlIlllI = String.valueOf(new StringBuilder().append(lllllllllllllllllIlIlIllIIlIlIlI.replace('.', '/')).append(".class"));
        final ClassLoader lllllllllllllllllIlIlIllIIlIllIl = this.clref.get();
        if (lllllllllllllllllIlIlIllIIlIllIl == null) {
            return null;
        }
        final URL lllllllllllllllllIlIlIllIIlIllII = lllllllllllllllllIlIlIllIIlIllIl.getResource(lllllllllllllllllIlIlIllIIlIlllI);
        return lllllllllllllllllIlIlIllIIlIllII;
    }
    
    @Override
    public String toString() {
        return (this.clref.get() == null) ? "<null>" : this.clref.get().toString();
    }
    
    public LoaderClassPath(final ClassLoader lllllllllllllllllIlIlIllIlIIlIlI) {
        this.clref = new WeakReference<ClassLoader>(lllllllllllllllllIlIlIllIlIIlIlI);
    }
}
