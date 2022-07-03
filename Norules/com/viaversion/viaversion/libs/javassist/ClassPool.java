package com.viaversion.viaversion.libs.javassist;

import java.security.*;
import java.net.*;
import com.viaversion.viaversion.libs.javassist.bytecode.*;
import com.viaversion.viaversion.libs.javassist.util.proxy.*;
import java.lang.invoke.*;
import java.util.*;
import java.io.*;

public class ClassPool
{
    public static /* synthetic */ boolean cacheOpenedJarFile;
    private /* synthetic */ ArrayList importedPackages;
    private static /* synthetic */ ClassPool defaultPool;
    public static /* synthetic */ boolean doPruning;
    public /* synthetic */ boolean childFirstLookup;
    private /* synthetic */ Hashtable cflow;
    protected /* synthetic */ ClassPool parent;
    public static /* synthetic */ boolean releaseUnmodifiedClassFile;
    protected /* synthetic */ Hashtable classes;
    protected /* synthetic */ ClassPoolTail source;
    private /* synthetic */ int compressCount;
    
    InputStream openClassfile(final String lllllllllllllIlIlIIIlIlIllllllII) throws NotFoundException {
        return this.source.openClassfile(lllllllllllllIlIlIIIlIlIllllllII);
    }
    
    public Class toClass(final CtClass lllllllllllllIlIlIIIlIlIIIIIIIII, final Class<?> lllllllllllllIlIlIIIlIIllllllIll, final ClassLoader lllllllllllllIlIlIIIlIIllllllllI, final ProtectionDomain lllllllllllllIlIlIIIlIIlllllllIl) throws CannotCompileException {
        try {
            return DefineClassHelper.toClass(lllllllllllllIlIlIIIlIlIIIIIIIII.getName(), lllllllllllllIlIlIIIlIIllllllIll, lllllllllllllIlIlIIIlIIllllllllI, lllllllllllllIlIlIIIlIIlllllllIl, lllllllllllllIlIlIIIlIlIIIIIIIII.toBytecode());
        }
        catch (IOException lllllllllllllIlIlIIIlIlIIIIIIIlI) {
            throw new CannotCompileException(lllllllllllllIlIlIIIlIlIIIIIIIlI);
        }
    }
    
    @Deprecated
    public Class toClass(final CtClass lllllllllllllIlIlIIIlIlIIIIllllI, final ClassLoader lllllllllllllIlIlIIIlIlIIIIlllIl, final ProtectionDomain lllllllllllllIlIlIIIlIlIIIIlllII) throws CannotCompileException {
        return this.toClass(lllllllllllllIlIlIIIlIlIIIIllllI, null, lllllllllllllIlIlIIIlIlIIIIlllIl, lllllllllllllIlIlIIIlIlIIIIlllII);
    }
    
    protected CtClass getCached(final String lllllllllllllIlIlIIIlIlllIlIIlIl) {
        return this.classes.get(lllllllllllllIlIlIIIlIlllIlIIlIl);
    }
    
    protected synchronized CtClass get0(final String lllllllllllllIlIlIIIlIllIIlIllII, final boolean lllllllllllllIlIlIIIlIllIIlIllll) throws NotFoundException {
        CtClass lllllllllllllIlIlIIIlIllIIlIlllI = null;
        if (lllllllllllllIlIlIIIlIllIIlIllll) {
            lllllllllllllIlIlIIIlIllIIlIlllI = this.getCached(lllllllllllllIlIlIIIlIllIIlIllII);
            if (lllllllllllllIlIlIIIlIllIIlIlllI != null) {
                return lllllllllllllIlIlIIIlIllIIlIlllI;
            }
        }
        if (!this.childFirstLookup && this.parent != null) {
            lllllllllllllIlIlIIIlIllIIlIlllI = this.parent.get0(lllllllllllllIlIlIIIlIllIIlIllII, lllllllllllllIlIlIIIlIllIIlIllll);
            if (lllllllllllllIlIlIIIlIllIIlIlllI != null) {
                return lllllllllllllIlIlIIIlIllIIlIlllI;
            }
        }
        lllllllllllllIlIlIIIlIllIIlIlllI = this.createCtClass(lllllllllllllIlIlIIIlIllIIlIllII, lllllllllllllIlIlIIIlIllIIlIllll);
        if (lllllllllllllIlIlIIIlIllIIlIlllI != null) {
            if (lllllllllllllIlIlIIIlIllIIlIllll) {
                this.cacheCtClass(lllllllllllllIlIlIIIlIllIIlIlllI.getName(), lllllllllllllIlIlIIIlIllIIlIlllI, false);
            }
            return lllllllllllllIlIlIIIlIllIIlIlllI;
        }
        if (this.childFirstLookup && this.parent != null) {
            lllllllllllllIlIlIIIlIllIIlIlllI = this.parent.get0(lllllllllllllIlIlIIIlIllIIlIllII, lllllllllllllIlIlIIIlIllIIlIllll);
        }
        return lllllllllllllIlIlIIIlIllIIlIlllI;
    }
    
    public ClassPath appendClassPath(final String lllllllllllllIlIlIIIlIlIIlIIllll) throws NotFoundException {
        return this.source.appendClassPath(lllllllllllllIlIlIIIlIlIIlIIllll);
    }
    
    void compress() {
        if (this.compressCount++ > 100) {
            this.compressCount = 0;
            final Enumeration lllllllllllllIlIlIIIlIlllIIIllll = this.classes.elements();
            while (lllllllllllllIlIlIIIlIlllIIIllll.hasMoreElements()) {
                lllllllllllllIlIlIIIlIlllIIIllll.nextElement().compress();
            }
        }
    }
    
    public URL find(final String lllllllllllllIlIlIIIlIllIIIllIII) {
        return this.source.find(lllllllllllllIlIlIIIlIllIIIllIII);
    }
    
    synchronized void classNameChanged(final String lllllllllllllIlIlIIIlIllIlIllIIl, final CtClass lllllllllllllIlIlIIIlIllIlIllIII) {
        final CtClass lllllllllllllIlIlIIIlIllIlIlIlll = this.getCached(lllllllllllllIlIlIIIlIllIlIllIIl);
        if (lllllllllllllIlIlIIIlIllIlIlIlll == lllllllllllllIlIlIIIlIllIlIllIII) {
            this.removeCached(lllllllllllllIlIlIIIlIllIlIllIIl);
        }
        final String lllllllllllllIlIlIIIlIllIlIlIllI = lllllllllllllIlIlIIIlIllIlIllIII.getName();
        this.checkNotFrozen(lllllllllllllIlIlIIIlIllIlIlIllI);
        this.cacheCtClass(lllllllllllllIlIlIIIlIllIlIlIllI, lllllllllllllIlIlIIIlIllIlIllIII, false);
    }
    
    synchronized CtClass makeNestedClass(final String lllllllllllllIlIlIIIlIlIlIIIlIII) {
        this.checkNotFrozen(lllllllllllllIlIlIIIlIlIlIIIlIII);
        final CtClass lllllllllllllIlIlIIIlIlIlIIIIlll = new CtNewClass(lllllllllllllIlIlIIIlIlIlIIIlIII, this, false, null);
        this.cacheCtClass(lllllllllllllIlIlIIIlIlIlIIIlIII, lllllllllllllIlIlIIIlIlIlIIIIlll, true);
        return lllllllllllllIlIlIIIlIlIlIIIIlll;
    }
    
    public CtClass[] get(final String[] lllllllllllllIlIlIIIlIlIlllIIlll) throws NotFoundException {
        if (lllllllllllllIlIlIIIlIlIlllIIlll == null) {
            return new CtClass[0];
        }
        final int lllllllllllllIlIlIIIlIlIlllIlIlI = lllllllllllllIlIlIIIlIlIlllIIlll.length;
        final CtClass[] lllllllllllllIlIlIIIlIlIlllIlIIl = new CtClass[lllllllllllllIlIlIIIlIlIlllIlIlI];
        for (int lllllllllllllIlIlIIIlIlIlllIllIl = 0; lllllllllllllIlIlIIIlIlIlllIllIl < lllllllllllllIlIlIIIlIlIlllIlIlI; ++lllllllllllllIlIlIIIlIlIlllIllIl) {
            lllllllllllllIlIlIIIlIlIlllIlIIl[lllllllllllllIlIlIIIlIlIlllIllIl] = this.get(lllllllllllllIlIlIIIlIlIlllIIlll[lllllllllllllIlIlIIIlIlIlllIllIl]);
        }
        return lllllllllllllIlIlIIIlIlIlllIlIIl;
    }
    
    public ClassPath appendClassPath(final ClassPath lllllllllllllIlIlIIIlIlIIlIllIIl) {
        return this.source.appendClassPath(lllllllllllllIlIlIIIlIlIIlIllIIl);
    }
    
    public Class toClass(final CtClass lllllllllllllIlIlIIIlIlIIIllIIlI) throws CannotCompileException {
        return this.toClass(lllllllllllllIlIlIIIlIlIIIllIIlI, this.getClassLoader());
    }
    
    public CtClass makeClass(InputStream lllllllllllllIlIlIIIlIlIllIIIllI, final boolean lllllllllllllIlIlIIIlIlIllIIlIlI) throws RuntimeException, IOException {
        this.compress();
        lllllllllllllIlIlIIIlIlIllIIIllI = new BufferedInputStream(lllllllllllllIlIlIIIlIlIllIIIllI);
        final CtClass lllllllllllllIlIlIIIlIlIllIIlIIl = new CtClassType(lllllllllllllIlIlIIIlIlIllIIIllI, this);
        lllllllllllllIlIlIIIlIlIllIIlIIl.checkModify();
        final String lllllllllllllIlIlIIIlIlIllIIlIII = lllllllllllllIlIlIIIlIlIllIIlIIl.getName();
        if (lllllllllllllIlIlIIIlIlIllIIlIlI) {
            this.checkNotFrozen(lllllllllllllIlIlIIIlIlIllIIlIII);
        }
        this.cacheCtClass(lllllllllllllIlIlIIIlIlIllIIlIII, lllllllllllllIlIlIIIlIlIllIIlIIl, true);
        return lllllllllllllIlIlIIIlIlIllIIlIIl;
    }
    
    public Object[] lookupCflow(final String lllllllllllllIlIlIIIlIllIllIllII) {
        if (this.cflow == null) {
            this.cflow = new Hashtable();
        }
        return this.cflow.get(lllllllllllllIlIlIIIlIllIllIllII);
    }
    
    public CtClass makeClass(final ClassFile lllllllllllllIlIlIIIlIlIlIllIIIl, final boolean lllllllllllllIlIlIIIlIlIlIllIIII) throws RuntimeException {
        this.compress();
        final CtClass lllllllllllllIlIlIIIlIlIlIllIlII = new CtClassType(lllllllllllllIlIlIIIlIlIlIllIIIl, this);
        lllllllllllllIlIlIIIlIlIlIllIlII.checkModify();
        final String lllllllllllllIlIlIIIlIlIlIllIIll = lllllllllllllIlIlIIIlIlIlIllIlII.getName();
        if (lllllllllllllIlIlIIIlIlIlIllIIII) {
            this.checkNotFrozen(lllllllllllllIlIlIIIlIlIlIllIIll);
        }
        this.cacheCtClass(lllllllllllllIlIlIIIlIlIlIllIIll, lllllllllllllIlIlIIIlIlIlIllIlII, true);
        return lllllllllllllIlIlIIIlIlIlIllIlII;
    }
    
    public CtClass getCtClass(final String lllllllllllllIlIlIIIlIllIIlllIII) throws NotFoundException {
        if (lllllllllllllIlIlIIIlIllIIlllIII.charAt(0) == '[') {
            return Descriptor.toCtClass(lllllllllllllIlIlIIIlIllIIlllIII, this);
        }
        return this.get(lllllllllllllIlIlIIIlIllIIlllIII);
    }
    
    void checkNotFrozen(final String lllllllllllllIlIlIIIlIllIIIIllll) throws RuntimeException {
        CtClass lllllllllllllIlIlIIIlIllIIIlIIIl = this.getCached(lllllllllllllIlIlIIIlIllIIIIllll);
        if (lllllllllllllIlIlIIIlIllIIIlIIIl == null) {
            if (!this.childFirstLookup && this.parent != null) {
                try {
                    lllllllllllllIlIlIIIlIllIIIlIIIl = this.parent.get0(lllllllllllllIlIlIIIlIllIIIIllll, true);
                }
                catch (NotFoundException ex) {}
                if (lllllllllllllIlIlIIIlIllIIIlIIIl != null) {
                    throw new RuntimeException(String.valueOf(new StringBuilder().append(lllllllllllllIlIlIIIlIllIIIIllll).append(" is in a parent ClassPool.  Use the parent.")));
                }
            }
        }
        else if (lllllllllllllIlIlIIIlIllIIIlIIIl.isFrozen()) {
            throw new RuntimeException(String.valueOf(new StringBuilder().append(lllllllllllllIlIlIIIlIllIIIIllll).append(": frozen class (cannot edit)")));
        }
    }
    
    public static synchronized ClassPool getDefault() {
        if (ClassPool.defaultPool == null) {
            (ClassPool.defaultPool = new ClassPool(null)).appendSystemPath();
        }
        return ClassPool.defaultPool;
    }
    
    protected CtClass createCtClass(String lllllllllllllIlIlIIIlIllIIlIIIII, final boolean lllllllllllllIlIlIIIlIllIIlIIIlI) {
        if (lllllllllllllIlIlIIIlIllIIlIIIII.charAt(0) == '[') {
            lllllllllllllIlIlIIIlIllIIlIIIII = Descriptor.toClassName(lllllllllllllIlIlIIIlIllIIlIIIII);
        }
        if (lllllllllllllIlIlIIIlIllIIlIIIII.endsWith("[]")) {
            final String lllllllllllllIlIlIIIlIllIIlIIlIl = lllllllllllllIlIlIIIlIllIIlIIIII.substring(0, lllllllllllllIlIlIIIlIllIIlIIIII.indexOf(91));
            if ((!lllllllllllllIlIlIIIlIllIIlIIIlI || this.getCached(lllllllllllllIlIlIIIlIllIIlIIlIl) == null) && this.find(lllllllllllllIlIlIIIlIllIIlIIlIl) == null) {
                return null;
            }
            return new CtArray(lllllllllllllIlIlIIIlIllIIlIIIII, this);
        }
        else {
            if (this.find(lllllllllllllIlIlIIIlIllIIlIIIII) == null) {
                return null;
            }
            return new CtClassType(lllllllllllllIlIlIIIlIllIIlIIIII, this);
        }
    }
    
    public synchronized CtClass makeClass(final String lllllllllllllIlIlIIIlIlIlIIIllll, final CtClass lllllllllllllIlIlIIIlIlIlIIIlllI) throws RuntimeException {
        this.checkNotFrozen(lllllllllllllIlIlIIIlIlIlIIIllll);
        final CtClass lllllllllllllIlIlIIIlIlIlIIlIIIl = new CtNewClass(lllllllllllllIlIlIIIlIlIlIIIllll, this, false, lllllllllllllIlIlIIIlIlIlIIIlllI);
        this.cacheCtClass(lllllllllllllIlIlIIIlIlIlIIIllll, lllllllllllllIlIlIIIlIlIlIIlIIIl, true);
        return lllllllllllllIlIlIIIlIlIlIIlIIIl;
    }
    
    public CtClass get(final String lllllllllllllIlIlIIIlIllIlIIlIII) throws NotFoundException {
        CtClass lllllllllllllIlIlIIIlIllIlIIlIlI = null;
        if (lllllllllllllIlIlIIIlIllIlIIlIII == null) {
            final CtClass lllllllllllllIlIlIIIlIllIlIIllIl = null;
        }
        else {
            lllllllllllllIlIlIIIlIllIlIIlIlI = this.get0(lllllllllllllIlIlIIIlIllIlIIlIII, true);
        }
        if (lllllllllllllIlIlIIIlIllIlIIlIlI == null) {
            throw new NotFoundException(lllllllllllllIlIlIIIlIllIlIIlIII);
        }
        lllllllllllllIlIlIIIlIllIlIIlIlI.incGetCounter();
        return lllllllllllllIlIlIIIlIllIlIIlIlI;
    }
    
    public void removeClassPath(final ClassPath lllllllllllllIlIlIIIlIlIIlIIlIIl) {
        this.source.removeClassPath(lllllllllllllIlIlIIIlIlIIlIIlIIl);
    }
    
    public ClassPool(final boolean lllllllllllllIlIlIIIlIlllIlllIIl) {
        this(null);
        if (lllllllllllllIlIlIIIlIlllIlllIIl) {
            this.appendSystemPath();
        }
    }
    
    void writeClassfile(final String lllllllllllllIlIlIIIlIlIllllIlll, final OutputStream lllllllllllllIlIlIIIlIlIllllIllI) throws IOException, NotFoundException, CannotCompileException {
        this.source.writeClassfile(lllllllllllllIlIlIIIlIlIllllIlll, lllllllllllllIlIlIIIlIlIllllIllI);
    }
    
    public CtClass makeAnnotation(final String lllllllllllllIlIlIIIlIlIIllIlIIl) throws RuntimeException {
        try {
            final CtClass lllllllllllllIlIlIIIlIlIIllIlllI = this.makeInterface(lllllllllllllIlIlIIIlIlIIllIlIIl, this.get("java.lang.annotation.Annotation"));
            lllllllllllllIlIlIIIlIlIIllIlllI.setModifiers(lllllllllllllIlIlIIIlIlIIllIlllI.getModifiers() | 0x2000);
            return lllllllllllllIlIlIIIlIlIIllIlllI;
        }
        catch (NotFoundException lllllllllllllIlIlIIIlIlIIllIllIl) {
            throw new RuntimeException(lllllllllllllIlIlIIIlIlIIllIllIl.getMessage(), lllllllllllllIlIlIIIlIlIIllIllIl);
        }
    }
    
    @Deprecated
    public Class toClass(final CtClass lllllllllllllIlIlIIIlIlIIIlIlIIl, final ClassLoader lllllllllllllIlIlIIIlIlIIIlIlIll) throws CannotCompileException {
        return this.toClass(lllllllllllllIlIlIIIlIlIIIlIlIIl, null, lllllllllllllIlIlIIIlIlIIIlIlIll, null);
    }
    
    protected void cacheCtClass(final String lllllllllllllIlIlIIIlIlllIlIIIII, final CtClass lllllllllllllIlIlIIIlIlllIIlllll, final boolean lllllllllllllIlIlIIIlIlllIIllllI) {
        this.classes.put(lllllllllllllIlIlIIIlIlllIlIIIII, lllllllllllllIlIlIIIlIlllIIlllll);
    }
    
    @Deprecated
    public void recordInvalidClassName(final String lllllllllllllIlIlIIIlIllIllllllI) {
    }
    
    public void importPackage(final String lllllllllllllIlIlIIIlIlllIIIlIII) {
        this.importedPackages.add(lllllllllllllIlIlIIIlIlllIIIlIII);
    }
    
    public CtClass makeClass(final String lllllllllllllIlIlIIIlIlIlIIllIIl) throws RuntimeException {
        return this.makeClass(lllllllllllllIlIlIIIlIlIlIIllIIl, null);
    }
    
    void recordCflow(final String lllllllllllllIlIlIIIlIllIlllIlII, final String lllllllllllllIlIlIIIlIllIlllIlll, final String lllllllllllllIlIlIIIlIllIlllIllI) {
        if (this.cflow == null) {
            this.cflow = new Hashtable();
        }
        this.cflow.put(lllllllllllllIlIlIIIlIllIlllIlII, new Object[] { lllllllllllllIlIlIIIlIllIlllIlll, lllllllllllllIlIlIIIlIllIlllIllI });
    }
    
    static ClassLoader getContextClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }
    
    public CtClass makeClass(final ClassFile lllllllllllllIlIlIIIlIlIlIllllll) throws RuntimeException {
        return this.makeClass(lllllllllllllIlIlIIIlIlIlIllllll, true);
    }
    
    public CtClass makeInterface(final String lllllllllllllIlIlIIIlIlIIllllllI) throws RuntimeException {
        return this.makeInterface(lllllllllllllIlIlIIIlIlIIllllllI, null);
    }
    
    @Deprecated
    public void makePackage(final ClassLoader lllllllllllllIlIlIIIlIIlllllIIlI, final String lllllllllllllIlIlIIIlIIlllllIIll) throws CannotCompileException {
        DefinePackageHelper.definePackage(lllllllllllllIlIlIIIlIIlllllIIll, lllllllllllllIlIlIIIlIIlllllIIlI);
    }
    
    public Class<?> toClass(final CtClass lllllllllllllIlIlIIIlIlIIIIlIlII, final Class<?> lllllllllllllIlIlIIIlIlIIIIlIlIl) throws CannotCompileException {
        try {
            return DefineClassHelper.toClass(lllllllllllllIlIlIIIlIlIIIIlIlIl, lllllllllllllIlIlIIIlIlIIIIlIlII.toBytecode());
        }
        catch (IOException lllllllllllllIlIlIIIlIlIIIIllIII) {
            throw new CannotCompileException(lllllllllllllIlIlIIIlIlIIIIllIII);
        }
    }
    
    public CtMethod getMethod(final String lllllllllllllIlIlIIIlIlIllIllIlI, final String lllllllllllllIlIlIIIlIlIllIllIIl) throws NotFoundException {
        final CtClass lllllllllllllIlIlIIIlIlIllIlllII = this.get(lllllllllllllIlIlIIIlIlIllIllIlI);
        return lllllllllllllIlIlIIIlIlIllIlllII.getDeclaredMethod(lllllllllllllIlIlIIIlIlIllIllIIl);
    }
    
    public synchronized CtClass makeInterface(final String lllllllllllllIlIlIIIlIlIIlllIlII, final CtClass lllllllllllllIlIlIIIlIlIIlllIIll) throws RuntimeException {
        this.checkNotFrozen(lllllllllllllIlIlIIIlIlIIlllIlII);
        final CtClass lllllllllllllIlIlIIIlIlIIlllIllI = new CtNewClass(lllllllllllllIlIlIIIlIlIIlllIlII, this, true, lllllllllllllIlIlIIIlIlIIlllIIll);
        this.cacheCtClass(lllllllllllllIlIlIIIlIlIIlllIlII, lllllllllllllIlIlIIIlIlIIlllIllI, true);
        return lllllllllllllIlIlIIIlIlIIlllIllI;
    }
    
    CtClass checkNotExists(final String lllllllllllllIlIlIIIlIllIIIIIlII) {
        CtClass lllllllllllllIlIlIIIlIllIIIIIllI = this.getCached(lllllllllllllIlIlIIIlIllIIIIIlII);
        if (lllllllllllllIlIlIIIlIllIIIIIllI == null && !this.childFirstLookup && this.parent != null) {
            try {
                lllllllllllllIlIlIIIlIllIIIIIllI = this.parent.get0(lllllllllllllIlIlIIIlIllIIIIIlII, true);
            }
            catch (NotFoundException ex) {}
        }
        return lllllllllllllIlIlIIIlIllIIIIIllI;
    }
    
    static {
        INIT_HASH_SIZE = 191;
        COMPRESS_THRESHOLD = 100;
        ClassPool.doPruning = false;
        ClassPool.releaseUnmodifiedClassFile = true;
        ClassPool.cacheOpenedJarFile = true;
        ClassPool.defaultPool = null;
    }
    
    public ClassPool(final ClassPool lllllllllllllIlIlIIIlIlllIlIllll) {
        this.childFirstLookup = false;
        this.cflow = null;
        this.classes = new Hashtable(191);
        this.source = new ClassPoolTail();
        this.parent = lllllllllllllIlIlIIIlIlllIlIllll;
        if (lllllllllllllIlIlIIIlIlllIlIllll == null) {
            final CtClass[] lllllllllllllIlIlIIIlIlllIllIIIl = CtClass.primitiveTypes;
            for (int lllllllllllllIlIlIIIlIlllIllIIlI = 0; lllllllllllllIlIlIIIlIlllIllIIlI < lllllllllllllIlIlIIIlIlllIllIIIl.length; ++lllllllllllllIlIlIIIlIlllIllIIlI) {
                this.classes.put(lllllllllllllIlIlIIIlIlllIllIIIl[lllllllllllllIlIlIIIlIlllIllIIlI].getName(), lllllllllllllIlIlIIIlIlllIllIIIl[lllllllllllllIlIlIIIlIlllIllIIlI]);
            }
        }
        this.cflow = null;
        this.compressCount = 0;
        this.clearImportedPackages();
    }
    
    public ClassLoader getClassLoader() {
        return getContextClassLoader();
    }
    
    public CtClass getOrNull(final String lllllllllllllIlIlIIIlIllIIlllllI) {
        CtClass lllllllllllllIlIlIIIlIllIlIIIIII = null;
        if (lllllllllllllIlIlIIIlIllIIlllllI == null) {
            lllllllllllllIlIlIIIlIllIlIIIIII = null;
        }
        else {
            try {
                lllllllllllllIlIlIIIlIllIlIIIIII = this.get0(lllllllllllllIlIlIIIlIllIIlllllI, true);
            }
            catch (NotFoundException ex) {}
        }
        if (lllllllllllllIlIlIIIlIllIlIIIIII != null) {
            lllllllllllllIlIlIIIlIllIlIIIIII.incGetCounter();
        }
        return lllllllllllllIlIlIIIlIllIlIIIIII;
    }
    
    public ClassPath insertClassPath(final ClassPath lllllllllllllIlIlIIIlIlIIllIIIIl) {
        return this.source.insertClassPath(lllllllllllllIlIlIIIlIlIIllIIIIl);
    }
    
    public CtClass makeClassIfNew(InputStream lllllllllllllIlIlIIIlIlIlIlIIIlI) throws IOException, RuntimeException {
        this.compress();
        lllllllllllllIlIlIIIlIlIlIlIIIlI = (float)new BufferedInputStream((InputStream)lllllllllllllIlIlIIIlIlIlIlIIIlI);
        final CtClass lllllllllllllIlIlIIIlIlIlIlIIllI = new CtClassType((InputStream)lllllllllllllIlIlIIIlIlIlIlIIIlI, this);
        lllllllllllllIlIlIIIlIlIlIlIIllI.checkModify();
        final String lllllllllllllIlIlIIIlIlIlIlIIlIl = lllllllllllllIlIlIIIlIlIlIlIIllI.getName();
        final CtClass lllllllllllllIlIlIIIlIlIlIlIIlII = this.checkNotExists(lllllllllllllIlIlIIIlIlIlIlIIlIl);
        if (lllllllllllllIlIlIIIlIlIlIlIIlII != null) {
            return lllllllllllllIlIlIIIlIlIlIlIIlII;
        }
        this.cacheCtClass(lllllllllllllIlIlIIIlIlIlIlIIlIl, lllllllllllllIlIlIIIlIlIlIlIIllI, true);
        return lllllllllllllIlIlIIIlIlIlIlIIllI;
    }
    
    public CtClass makeClass(final InputStream lllllllllllllIlIlIIIlIlIllIlIIlI) throws IOException, RuntimeException {
        return this.makeClass(lllllllllllllIlIlIIIlIlIllIlIIlI, true);
    }
    
    public ClassPool() {
        this(null);
    }
    
    public Class<?> toClass(final CtClass lllllllllllllIlIlIIIlIlIIIIIllII, final MethodHandles.Lookup lllllllllllllIlIlIIIlIlIIIIIlIIl) throws CannotCompileException {
        try {
            return DefineClassHelper.toClass(lllllllllllllIlIlIIIlIlIIIIIlIIl, lllllllllllllIlIlIIIlIlIIIIIllII.toBytecode());
        }
        catch (IOException lllllllllllllIlIlIIIlIlIIIIIlllI) {
            throw new CannotCompileException(lllllllllllllIlIlIIIlIlIIIIIlllI);
        }
    }
    
    public ClassPath insertClassPath(final String lllllllllllllIlIlIIIlIlIIlIlIlIl) throws NotFoundException {
        return this.source.insertClassPath(lllllllllllllIlIlIIIlIlIIlIlIlIl);
    }
    
    protected CtClass removeCached(final String lllllllllllllIlIlIIIlIlllIIlIlIl) {
        return this.classes.remove(lllllllllllllIlIlIIIlIlllIIlIlIl);
    }
    
    public ClassPath appendSystemPath() {
        return this.source.appendSystemPath();
    }
    
    public void clearImportedPackages() {
        this.importedPackages = new ArrayList();
        this.importedPackages.add("java.lang");
    }
    
    @Override
    public String toString() {
        return this.source.toString();
    }
    
    public CtClass getAndRename(final String lllllllllllllIlIlIIIlIllIllIIIlI, final String lllllllllllllIlIlIIIlIllIllIIlIl) throws NotFoundException {
        final CtClass lllllllllllllIlIlIIIlIllIllIIlII = this.get0(lllllllllllllIlIlIIIlIllIllIIIlI, false);
        if (lllllllllllllIlIlIIIlIllIllIIlII == null) {
            throw new NotFoundException(lllllllllllllIlIlIIIlIllIllIIIlI);
        }
        if (lllllllllllllIlIlIIIlIllIllIIlII instanceof CtClassType) {
            ((CtClassType)lllllllllllllIlIlIIIlIllIllIIlII).setClassPool(this);
        }
        lllllllllllllIlIlIIIlIllIllIIlII.setName(lllllllllllllIlIlIIIlIllIllIIlIl);
        return lllllllllllllIlIlIIIlIllIllIIlII;
    }
    
    public Iterator<String> getImportedPackages() {
        return this.importedPackages.iterator();
    }
    
    public void appendPathList(final String lllllllllllllIlIlIIIlIlIIIllllll) throws NotFoundException {
        final char lllllllllllllIlIlIIIlIlIIIlllllI = File.pathSeparatorChar;
        int lllllllllllllIlIlIIIlIlIIIllllIl = 0;
        while (true) {
            final int lllllllllllllIlIlIIIlIlIIlIIIIIl = lllllllllllllIlIlIIIlIlIIIllllll.indexOf(lllllllllllllIlIlIIIlIlIIIlllllI, lllllllllllllIlIlIIIlIlIIIllllIl);
            if (lllllllllllllIlIlIIIlIlIIlIIIIIl < 0) {
                break;
            }
            this.appendClassPath(lllllllllllllIlIlIIIlIlIIIllllll.substring(lllllllllllllIlIlIIIlIlIIIllllIl, lllllllllllllIlIlIIIlIlIIlIIIIIl));
            lllllllllllllIlIlIIIlIlIIIllllIl = lllllllllllllIlIlIIIlIlIIlIIIIIl + 1;
        }
        this.appendClassPath(lllllllllllllIlIlIIIlIlIIIllllll.substring(lllllllllllllIlIlIIIlIlIIIllllIl));
    }
}
