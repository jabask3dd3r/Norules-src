package com.viaversion.viaversion.libs.javassist;

import java.security.*;
import com.viaversion.viaversion.libs.javassist.bytecode.*;
import java.util.*;
import java.lang.reflect.*;
import java.net.*;
import java.io.*;

public class Loader extends ClassLoader
{
    public /* synthetic */ boolean doDelegation;
    private /* synthetic */ ClassPool source;
    private /* synthetic */ HashMap<String, ClassLoader> notDefinedHere;
    private /* synthetic */ Translator translator;
    private /* synthetic */ ProtectionDomain domain;
    private /* synthetic */ Vector<String> notDefinedPackages;
    
    public void setDomain(final ProtectionDomain lllllllllllllIIlIIIIlllIIIlllIIl) {
        this.domain = lllllllllllllIIlIIIIlllIIIlllIIl;
    }
    
    private boolean isDefinedPackage(final String lllllllllllllIIlIIIIllIllllIIIlI) {
        if (ClassFile.MAJOR_VERSION >= 53) {
            return this.getDefinedPackage(lllllllllllllIIlIIIIllIllllIIIlI) == null;
        }
        return this.getPackage(lllllllllllllIIlIIIIllIllllIIIlI) == null;
    }
    
    public void delegateLoadingOf(final String lllllllllllllIIlIIIIlllIIIllllll) {
        if (lllllllllllllIIlIIIIlllIIIllllll.endsWith(".")) {
            this.notDefinedPackages.addElement(lllllllllllllIIlIIIIlllIIIllllll);
        }
        else {
            this.notDefinedHere.put(lllllllllllllIIlIIIIlllIIIllllll, this);
        }
    }
    
    public void addTranslator(final ClassPool lllllllllllllIIlIIIIlllIIIlIlIIl, final Translator lllllllllllllIIlIIIIlllIIIlIlIll) throws NotFoundException, CannotCompileException {
        this.source = lllllllllllllIIlIIIIlllIIIlIlIIl;
        this.translator = lllllllllllllIIlIIIIlllIIIlIlIll;
        lllllllllllllIIlIIIIlllIIIlIlIll.start(lllllllllllllIIlIIIIlllIIIlIlIIl);
    }
    
    public void setClassPool(final ClassPool lllllllllllllIIlIIIIlllIIIllIIIl) {
        this.source = lllllllllllllIIlIIIIlllIIIllIIIl;
    }
    
    private boolean notDelegated(final String lllllllllllllIIlIIIIllIlllIlIIII) {
        if (this.notDefinedHere.containsKey(lllllllllllllIIlIIIIllIlllIlIIII)) {
            return true;
        }
        for (final String lllllllllllllIIlIIIIllIlllIlIIlI : this.notDefinedPackages) {
            if (lllllllllllllIIlIIIIllIlllIlIIII.startsWith(lllllllllllllIIlIIIIllIlllIlIIlI)) {
                return true;
            }
        }
        return false;
    }
    
    public Loader() {
        this((ClassPool)null);
    }
    
    public void run(final String[] lllllllllllllIIlIIIIlllIIIIllllI) throws Throwable {
        if (lllllllllllllIIlIIIIlllIIIIllllI.length >= 1) {
            this.run(lllllllllllllIIlIIIIlllIIIIllllI[0], Arrays.copyOfRange(lllllllllllllIIlIIIIlllIIIIllllI, 1, lllllllllllllIIlIIIIlllIIIIllllI.length));
        }
    }
    
    protected Class<?> loadClassByDelegation(final String lllllllllllllIIlIIIIllIlllIllIII) throws ClassNotFoundException {
        Class<?> lllllllllllllIIlIIIIllIlllIllIlI = null;
        if (this.doDelegation && (lllllllllllllIIlIIIIllIlllIllIII.startsWith("java.") || lllllllllllllIIlIIIIllIlllIllIII.startsWith("javax.") || lllllllllllllIIlIIIIllIlllIllIII.startsWith("sun.") || lllllllllllllIIlIIIIllIlllIllIII.startsWith("com.sun.") || lllllllllllllIIlIIIIllIlllIllIII.startsWith("org.w3c.") || lllllllllllllIIlIIIIllIlllIllIII.startsWith("org.xml.") || this.notDelegated(lllllllllllllIIlIIIIllIlllIllIII))) {
            lllllllllllllIIlIIIIllIlllIllIlI = this.delegateToParent(lllllllllllllIIlIIIIllIlllIllIII);
        }
        return lllllllllllllIIlIIIIllIlllIllIlI;
    }
    
    public Loader(final ClassPool lllllllllllllIIlIIIIlllIIlIlIIlI) {
        this.doDelegation = true;
        this.init(lllllllllllllIIlIIIIlllIIlIlIIlI);
    }
    
    public void run(final String lllllllllllllIIlIIIIlllIIIIlIIII, final String[] lllllllllllllIIlIIIIlllIIIIlIIll) throws Throwable {
        final Class<?> lllllllllllllIIlIIIIlllIIIIlIIlI = this.loadClass(lllllllllllllIIlIIIIlllIIIIlIIII);
        try {
            lllllllllllllIIlIIIIlllIIIIlIIlI.getDeclaredMethod("main", String[].class).invoke(null, lllllllllllllIIlIIIIlllIIIIlIIll);
        }
        catch (InvocationTargetException lllllllllllllIIlIIIIlllIIIIlIllI) {
            throw lllllllllllllIIlIIIIlllIIIIlIllI.getTargetException();
        }
    }
    
    @Override
    protected Class<?> findClass(final String lllllllllllllIIlIIIIllIllllIlIlI) throws ClassNotFoundException {
        try {
            Label_0103: {
                if (this.source != null) {
                    if (this.translator != null) {
                        this.translator.onLoad(this.source, lllllllllllllIIlIIIIllIllllIlIlI);
                    }
                    try {
                        final byte[] lllllllllllllIIlIIIIllIlllllIllI = this.source.get(lllllllllllllIIlIIIIllIllllIlIlI).toBytecode();
                        break Label_0103;
                    }
                    catch (NotFoundException lllllllllllllIIlIIIIllIlllllIlIl) {
                        return null;
                    }
                }
                final String lllllllllllllIIlIIIIllIlllllIlII = String.valueOf(new StringBuilder().append("/").append(lllllllllllllIIlIIIIllIllllIlIlI.replace('.', '/')).append(".class"));
                final InputStream lllllllllllllIIlIIIIllIlllllIIll = this.getClass().getResourceAsStream(lllllllllllllIIlIIIIllIlllllIlII);
                if (lllllllllllllIIlIIIIllIlllllIIll == null) {
                    return null;
                }
                final byte[] lllllllllllllIIlIIIIllIlllllIIlI = ClassPoolTail.readStream(lllllllllllllIIlIIIIllIlllllIIll);
            }
        }
        catch (Exception lllllllllllllIIlIIIIllIlllllIIIl) {
            throw new ClassNotFoundException(String.valueOf(new StringBuilder().append("caught an exception while obtaining a class file for ").append(lllllllllllllIIlIIIIllIllllIlIlI)), lllllllllllllIIlIIIIllIlllllIIIl);
        }
        final int lllllllllllllIIlIIIIllIllllIllII = lllllllllllllIIlIIIIllIllllIlIlI.lastIndexOf(46);
        if (lllllllllllllIIlIIIIllIllllIllII != -1) {
            final String lllllllllllllIIlIIIIllIlllllIIII = lllllllllllllIIlIIIIllIllllIlIlI.substring(0, lllllllllllllIIlIIIIllIllllIllII);
            if (this.isDefinedPackage(lllllllllllllIIlIIIIllIlllllIIII)) {
                try {
                    this.definePackage(lllllllllllllIIlIIIIllIlllllIIII, null, null, null, null, null, null, null);
                }
                catch (IllegalArgumentException ex) {}
            }
        }
        final byte[] lllllllllllllIIlIIIIllIllllIllIl;
        if (this.domain == null) {
            return this.defineClass(lllllllllllllIIlIIIIllIllllIlIlI, lllllllllllllIIlIIIIllIllllIllIl, 0, lllllllllllllIIlIIIIllIllllIllIl.length);
        }
        return this.defineClass(lllllllllllllIIlIIIIllIllllIlIlI, lllllllllllllIIlIIIIllIllllIllIl, 0, lllllllllllllIIlIIIIllIllllIllIl.length, this.domain);
    }
    
    private void init(final ClassPool lllllllllllllIIlIIIIlllIIlIIIlIl) {
        this.notDefinedHere = new HashMap<String, ClassLoader>();
        this.notDefinedPackages = new Vector<String>();
        this.source = lllllllllllllIIlIIIIlllIIlIIIlIl;
        this.translator = null;
        this.domain = null;
        this.delegateLoadingOf("com.viaversion.viaversion.libs.javassist.Loader");
    }
    
    public Loader(final ClassLoader lllllllllllllIIlIIIIlllIIlIIlIlI, final ClassPool lllllllllllllIIlIIIIlllIIlIIlIIl) {
        super(lllllllllllllIIlIIIIlllIIlIIlIlI);
        this.doDelegation = true;
        this.init(lllllllllllllIIlIIIIlllIIlIIlIIl);
    }
    
    public static void main(final String[] lllllllllllllIIlIIIIlllIIIlIIlIl) throws Throwable {
        final Loader lllllllllllllIIlIIIIlllIIIlIIlII = new Loader();
        lllllllllllllIIlIIIIlllIIIlIIlII.run(lllllllllllllIIlIIIIlllIIIlIIlIl);
    }
    
    @Override
    protected Class<?> loadClass(String lllllllllllllIIlIIIIlllIIIIIIIIl, final boolean lllllllllllllIIlIIIIlllIIIIIIIll) throws ClassFormatError, ClassNotFoundException {
        lllllllllllllIIlIIIIlllIIIIIIIIl = lllllllllllllIIlIIIIlllIIIIIIIIl.intern();
        synchronized (lllllllllllllIIlIIIIlllIIIIIIIIl) {
            Class<?> lllllllllllllIIlIIIIlllIIIIIIllI = this.findLoadedClass(lllllllllllllIIlIIIIlllIIIIIIIIl);
            if (lllllllllllllIIlIIIIlllIIIIIIllI == null) {
                lllllllllllllIIlIIIIlllIIIIIIllI = this.loadClassByDelegation(lllllllllllllIIlIIIIlllIIIIIIIIl);
            }
            if (lllllllllllllIIlIIIIlllIIIIIIllI == null) {
                lllllllllllllIIlIIIIlllIIIIIIllI = this.findClass(lllllllllllllIIlIIIIlllIIIIIIIIl);
            }
            if (lllllllllllllIIlIIIIlllIIIIIIllI == null) {
                lllllllllllllIIlIIIIlllIIIIIIllI = this.delegateToParent(lllllllllllllIIlIIIIlllIIIIIIIIl);
            }
            if (lllllllllllllIIlIIIIlllIIIIIIIll) {
                this.resolveClass(lllllllllllllIIlIIIIlllIIIIIIllI);
            }
            return lllllllllllllIIlIIIIlllIIIIIIllI;
        }
    }
    
    protected Class<?> delegateToParent(final String lllllllllllllIIlIIIIllIlllIIIlll) throws ClassNotFoundException {
        final ClassLoader lllllllllllllIIlIIIIllIlllIIIllI = this.getParent();
        if (lllllllllllllIIlIIIIllIlllIIIllI != null) {
            return lllllllllllllIIlIIIIllIlllIIIllI.loadClass(lllllllllllllIIlIIIIllIlllIIIlll);
        }
        return this.findSystemClass(lllllllllllllIIlIIIIllIlllIIIlll);
    }
    
    public static class Simple extends ClassLoader
    {
        public Class<?> invokeDefineClass(final CtClass llllllllllllllllIIlIIIIIlIIllIIl) throws CannotCompileException, IOException {
            final byte[] llllllllllllllllIIlIIIIIlIIllIll = llllllllllllllllIIlIIIIIlIIllIIl.toBytecode();
            return this.defineClass(llllllllllllllllIIlIIIIIlIIllIIl.getName(), llllllllllllllllIIlIIIIIlIIllIll, 0, llllllllllllllllIIlIIIIIlIIllIll.length);
        }
        
        public Simple() {
        }
        
        public Simple(final ClassLoader llllllllllllllllIIlIIIIIlIlIIIIl) {
            super(llllllllllllllllIIlIIIIIlIlIIIIl);
        }
    }
}
