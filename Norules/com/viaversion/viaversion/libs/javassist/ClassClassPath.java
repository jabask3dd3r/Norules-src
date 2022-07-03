package com.viaversion.viaversion.libs.javassist;

import java.net.*;
import java.io.*;

public class ClassClassPath implements ClassPath
{
    private /* synthetic */ Class<?> thisClass;
    
    public ClassClassPath(final Class<?> lllllllllllllllIlIIIlllllIlIlllI) {
        this.thisClass = lllllllllllllllIlIIIlllllIlIlllI;
    }
    
    @Override
    public URL find(final String lllllllllllllllIlIIIlllllIIllIll) {
        final String lllllllllllllllIlIIIlllllIIllIlI = String.valueOf(new StringBuilder().append('/').append(lllllllllllllllIlIIIlllllIIllIll.replace('.', '/')).append(".class"));
        return this.thisClass.getResource(lllllllllllllllIlIIIlllllIIllIlI);
    }
    
    @Override
    public InputStream openClassfile(final String lllllllllllllllIlIIIlllllIlIIIIl) throws NotFoundException {
        final String lllllllllllllllIlIIIlllllIlIIIll = String.valueOf(new StringBuilder().append('/').append(lllllllllllllllIlIIIlllllIlIIIIl.replace('.', '/')).append(".class"));
        return this.thisClass.getResourceAsStream(lllllllllllllllIlIIIlllllIlIIIll);
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append(this.thisClass.getName()).append(".class"));
    }
    
    ClassClassPath() {
        this(Object.class);
    }
}
