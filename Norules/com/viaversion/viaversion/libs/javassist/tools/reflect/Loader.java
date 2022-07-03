package com.viaversion.viaversion.libs.javassist.tools.reflect;

import com.viaversion.viaversion.libs.javassist.*;

public class Loader extends com.viaversion.viaversion.libs.javassist.Loader
{
    protected /* synthetic */ Reflection reflection;
    
    public Loader() throws NotFoundException, CannotCompileException {
        this.delegateLoadingOf("com.viaversion.viaversion.libs.javassist.tools.reflect.Loader");
        this.reflection = new Reflection();
        final ClassPool lllllllllllllIIIlIlIIIllIIIllIIl = ClassPool.getDefault();
        this.addTranslator(lllllllllllllIIIlIlIIIllIIIllIIl, this.reflection);
    }
    
    public boolean makeReflective(final String lllllllllllllIIIlIlIIIllIIIlIIIl, final String lllllllllllllIIIlIlIIIllIIIIllII, final String lllllllllllllIIIlIlIIIllIIIIllll) throws NotFoundException, CannotCompileException {
        return this.reflection.makeReflective(lllllllllllllIIIlIlIIIllIIIlIIIl, lllllllllllllIIIlIlIIIllIIIIllII, lllllllllllllIIIlIlIIIllIIIIllll);
    }
    
    public static void main(final String[] lllllllllllllIIIlIlIIIllIIlIIIII) throws Throwable {
        final Loader lllllllllllllIIIlIlIIIllIIIlllll = new Loader();
        lllllllllllllIIIlIlIIIllIIIlllll.run(lllllllllllllIIIlIlIIIllIIlIIIII);
    }
}
