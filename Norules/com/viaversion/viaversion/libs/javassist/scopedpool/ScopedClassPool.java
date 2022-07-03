package com.viaversion.viaversion.libs.javassist.scopedpool;

import java.util.*;
import java.security.*;
import java.lang.ref.*;
import com.viaversion.viaversion.libs.javassist.*;

public class ScopedClassPool extends ClassPool
{
    protected /* synthetic */ ScopedClassPoolRepository repository;
    protected /* synthetic */ Map<String, CtClass> softcache;
    /* synthetic */ boolean isBootstrapCl;
    protected /* synthetic */ Reference<ClassLoader> classLoader;
    protected /* synthetic */ LoaderClassPath classPath;
    
    @Override
    public Class<?> toClass(final CtClass lllllllllllllIIllIIIIIlIIllIllll, final ClassLoader lllllllllllllIIllIIIIIlIIllIlllI, final ProtectionDomain lllllllllllllIIllIIIIIlIIllIlIlI) throws CannotCompileException {
        this.lockInCache(lllllllllllllIIllIIIIIlIIllIllll);
        return (Class<?>)super.toClass(lllllllllllllIIllIIIIIlIIllIllll, this.getClassLoader0(), lllllllllllllIIllIIIIIlIIllIlIlI);
    }
    
    @Override
    public ClassLoader getClassLoader() {
        final ClassLoader lllllllllllllIIllIIIIIlIllIIlllI = this.getClassLoader0();
        if (lllllllllllllIIllIIIIIlIllIIlllI == null && !this.isBootstrapCl) {
            throw new IllegalStateException("ClassLoader has been garbage collected");
        }
        return lllllllllllllIIllIIIIIlIllIIlllI;
    }
    
    protected ScopedClassPool(final ClassLoader lllllllllllllIIllIIIIIlIllIlIlIl, final ClassPool lllllllllllllIIllIIIIIlIllIllIIl, final ScopedClassPoolRepository lllllllllllllIIllIIIIIlIllIlIIll, final boolean lllllllllllllIIllIIIIIlIllIlIIlI) {
        super(lllllllllllllIIllIIIIIlIllIllIIl);
        this.softcache = new SoftValueHashMap<String, CtClass>();
        this.isBootstrapCl = true;
        this.repository = lllllllllllllIIllIIIIIlIllIlIIll;
        this.classLoader = new WeakReference<ClassLoader>(lllllllllllllIIllIIIIIlIllIlIlIl);
        if (lllllllllllllIIllIIIIIlIllIlIlIl != null) {
            this.classPath = new LoaderClassPath(lllllllllllllIIllIIIIIlIllIlIlIl);
            this.insertClassPath(this.classPath);
        }
        this.childFirstLookup = true;
        if (!lllllllllllllIIllIIIIIlIllIlIIlI && lllllllllllllIIllIIIIIlIllIlIlIl == null) {
            this.isBootstrapCl = true;
        }
    }
    
    @Override
    protected CtClass getCached(final String lllllllllllllIIllIIIIIlIlIlIIlll) {
        CtClass lllllllllllllIIllIIIIIlIlIlIIllI = this.getCachedLocally(lllllllllllllIIllIIIIIlIlIlIIlll);
        if (lllllllllllllIIllIIIIIlIlIlIIllI == null) {
            boolean lllllllllllllIIllIIIIIlIlIlIlIlI = false;
            final ClassLoader lllllllllllllIIllIIIIIlIlIlIlIIl = this.getClassLoader0();
            if (lllllllllllllIIllIIIIIlIlIlIlIIl != null) {
                final int lllllllllllllIIllIIIIIlIlIlIlllI = lllllllllllllIIllIIIIIlIlIlIIlll.lastIndexOf(36);
                String lllllllllllllIIllIIIIIlIlIlIllIl = null;
                if (lllllllllllllIIllIIIIIlIlIlIlllI < 0) {
                    lllllllllllllIIllIIIIIlIlIlIllIl = String.valueOf(new StringBuilder().append(lllllllllllllIIllIIIIIlIlIlIIlll.replaceAll("[\\.]", "/")).append(".class"));
                }
                else {
                    lllllllllllllIIllIIIIIlIlIlIllIl = String.valueOf(new StringBuilder().append(lllllllllllllIIllIIIIIlIlIlIIlll.substring(0, lllllllllllllIIllIIIIIlIlIlIlllI).replaceAll("[\\.]", "/")).append(lllllllllllllIIllIIIIIlIlIlIIlll.substring(lllllllllllllIIllIIIIIlIlIlIlllI)).append(".class"));
                }
                lllllllllllllIIllIIIIIlIlIlIlIlI = (lllllllllllllIIllIIIIIlIlIlIlIIl.getResource(lllllllllllllIIllIIIIIlIlIlIllIl) != null);
            }
            if (!lllllllllllllIIllIIIIIlIlIlIlIlI) {
                final Map<ClassLoader, ScopedClassPool> lllllllllllllIIllIIIIIlIlIlIlIll = this.repository.getRegisteredCLs();
                synchronized (lllllllllllllIIllIIIIIlIlIlIlIll) {
                    for (final ScopedClassPool lllllllllllllIIllIIIIIlIlIlIllII : lllllllllllllIIllIIIIIlIlIlIlIll.values()) {
                        if (lllllllllllllIIllIIIIIlIlIlIllII.isUnloadedClassLoader()) {
                            this.repository.unregisterClassLoader(lllllllllllllIIllIIIIIlIlIlIllII.getClassLoader());
                        }
                        else {
                            lllllllllllllIIllIIIIIlIlIlIIllI = lllllllllllllIIllIIIIIlIlIlIllII.getCachedLocally(lllllllllllllIIllIIIIIlIlIlIIlll);
                            if (lllllllllllllIIllIIIIIlIlIlIIllI != null) {
                                return lllllllllllllIIllIIIIIlIlIlIIllI;
                            }
                            continue;
                        }
                    }
                }
            }
        }
        return lllllllllllllIIllIIIIIlIlIlIIllI;
    }
    
    public void close() {
        this.removeClassPath(this.classPath);
        this.classes.clear();
        this.softcache.clear();
    }
    
    public boolean isUnloadedClassLoader() {
        return false;
    }
    
    public void lockInCache(final CtClass lllllllllllllIIllIIIIIlIlIIIlIlI) {
        super.cacheCtClass(lllllllllllllIIllIIIIIlIlIIIlIlI.getName(), lllllllllllllIIllIIIIIlIlIIIlIlI, false);
    }
    
    protected CtClass getCachedLocally(final String lllllllllllllIIllIIIIIlIlIIIIIll) {
        final CtClass lllllllllllllIIllIIIIIlIlIIIIIlI = this.classes.get(lllllllllllllIIllIIIIIlIlIIIIIll);
        if (lllllllllllllIIllIIIIIlIlIIIIIlI != null) {
            return lllllllllllllIIllIIIIIlIlIIIIIlI;
        }
        synchronized (this.softcache) {
            return this.softcache.get(lllllllllllllIIllIIIIIlIlIIIIIll);
        }
    }
    
    protected ScopedClassPool(final ClassLoader lllllllllllllIIllIIIIIlIlllIIIll, final ClassPool lllllllllllllIIllIIIIIlIlllIIllI, final ScopedClassPoolRepository lllllllllllllIIllIIIIIlIlllIIIIl) {
        this(lllllllllllllIIllIIIIIlIlllIIIll, lllllllllllllIIllIIIIIlIlllIIllI, lllllllllllllIIllIIIIIlIlllIIIIl, false);
    }
    
    public synchronized void soften(final CtClass lllllllllllllIIllIIIIIlIlIlllIlI) {
        if (this.repository.isPrune()) {
            lllllllllllllIIllIIIIIlIlIlllIlI.prune();
        }
        this.classes.remove(lllllllllllllIIllIIIIIlIlIlllIlI.getName());
        this.softcache.put(lllllllllllllIIllIIIIIlIlIlllIlI.getName(), lllllllllllllIIllIIIIIlIlIlllIlI);
    }
    
    protected ClassLoader getClassLoader0() {
        return this.classLoader.get();
    }
    
    public synchronized CtClass getLocally(final String lllllllllllllIIllIIIIIlIIlllIlIl) throws NotFoundException {
        this.softcache.remove(lllllllllllllIIllIIIIIlIIlllIlIl);
        CtClass lllllllllllllIIllIIIIIlIIlllIlll = this.classes.get(lllllllllllllIIllIIIIIlIIlllIlIl);
        if (lllllllllllllIIllIIIIIlIIlllIlll == null) {
            lllllllllllllIIllIIIIIlIIlllIlll = this.createCtClass(lllllllllllllIIllIIIIIlIIlllIlIl, true);
            if (lllllllllllllIIllIIIIIlIIlllIlll == null) {
                throw new NotFoundException(lllllllllllllIIllIIIIIlIIlllIlIl);
            }
            super.cacheCtClass(lllllllllllllIIllIIIIIlIIlllIlIl, lllllllllllllIIllIIIIIlIIlllIlll, false);
        }
        return lllllllllllllIIllIIIIIlIIlllIlll;
    }
    
    static {
        ClassPool.doPruning = false;
        ClassPool.releaseUnmodifiedClassFile = false;
    }
    
    @Override
    protected void cacheCtClass(final String lllllllllllllIIllIIIIIlIlIIlIllI, final CtClass lllllllllllllIIllIIIIIlIlIIlIIIl, final boolean lllllllllllllIIllIIIIIlIlIIlIlII) {
        if (lllllllllllllIIllIIIIIlIlIIlIlII) {
            super.cacheCtClass(lllllllllllllIIllIIIIIlIlIIlIllI, lllllllllllllIIllIIIIIlIlIIlIIIl, lllllllllllllIIllIIIIIlIlIIlIlII);
        }
        else {
            if (this.repository.isPrune()) {
                lllllllllllllIIllIIIIIlIlIIlIIIl.prune();
            }
            this.softcache.put(lllllllllllllIIllIIIIIlIlIIlIllI, lllllllllllllIIllIIIIIlIlIIlIIIl);
        }
    }
    
    public synchronized void flushClass(final String lllllllllllllIIllIIIIIlIllIIIIlI) {
        this.classes.remove(lllllllllllllIIllIIIIIlIllIIIIlI);
        this.softcache.remove(lllllllllllllIIllIIIIIlIllIIIIlI);
    }
}
