package com.viaversion.viaversion.libs.javassist.scopedpool;

import com.viaversion.viaversion.libs.javassist.*;
import java.util.*;

public class ScopedClassPoolRepositoryImpl implements ScopedClassPoolRepository
{
    protected /* synthetic */ Map<ClassLoader, ScopedClassPool> registeredCLs;
    protected /* synthetic */ ClassPool classpool;
    private /* synthetic */ boolean prune;
    private static final /* synthetic */ ScopedClassPoolRepositoryImpl instance;
    protected /* synthetic */ ScopedClassPoolFactory factory;
    
    @Override
    public void setClassPoolFactory(final ScopedClassPoolFactory llllllllllllllIIIIIllIlIlIlllIIl) {
        this.factory = llllllllllllllIIIIIllIlIlIlllIIl;
    }
    
    private ScopedClassPoolRepositoryImpl() {
        this.prune = true;
        this.registeredCLs = Collections.synchronizedMap(new WeakHashMap<ClassLoader, ScopedClassPool>());
        this.factory = new ScopedClassPoolFactoryImpl();
        this.classpool = ClassPool.getDefault();
        final ClassLoader llllllllllllllIIIIIllIllIIIIlIll = Thread.currentThread().getContextClassLoader();
        this.classpool.insertClassPath(new LoaderClassPath(llllllllllllllIIIIIllIllIIIIlIll));
    }
    
    @Override
    public ClassPool findClassPool(final ClassLoader llllllllllllllIIIIIllIlIllllIIIl) {
        if (llllllllllllllIIIIIllIlIllllIIIl == null) {
            return this.registerClassLoader(ClassLoader.getSystemClassLoader());
        }
        return this.registerClassLoader(llllllllllllllIIIIIllIlIllllIIIl);
    }
    
    @Override
    public void setPrune(final boolean llllllllllllllIIIIIllIllIIIIIIII) {
        this.prune = llllllllllllllIIIIIllIllIIIIIIII;
    }
    
    public void insertDelegate(final ScopedClassPoolRepository llllllllllllllIIIIIllIlIlIllllll) {
    }
    
    @Override
    public void unregisterClassLoader(final ClassLoader llllllllllllllIIIIIllIlIllIIIllI) {
        synchronized (this.registeredCLs) {
            final ScopedClassPool llllllllllllllIIIIIllIlIllIIlIII = this.registeredCLs.remove(llllllllllllllIIIIIllIlIllIIIllI);
            if (llllllllllllllIIIIIllIlIllIIlIII != null) {
                llllllllllllllIIIIIllIlIllIIlIII.close();
            }
        }
    }
    
    @Override
    public ScopedClassPoolFactory getClassPoolFactory() {
        return this.factory;
    }
    
    @Override
    public Map<ClassLoader, ScopedClassPool> getRegisteredCLs() {
        this.clearUnregisteredClassLoaders();
        return this.registeredCLs;
    }
    
    public static ScopedClassPoolRepository getInstance() {
        return ScopedClassPoolRepositoryImpl.instance;
    }
    
    static {
        instance = new ScopedClassPoolRepositoryImpl();
    }
    
    @Override
    public boolean isPrune() {
        return this.prune;
    }
    
    @Override
    public void clearUnregisteredClassLoaders() {
        List<ClassLoader> llllllllllllllIIIIIllIlIllIlIlIl = null;
        synchronized (this.registeredCLs) {
            for (final Map.Entry<ClassLoader, ScopedClassPool> llllllllllllllIIIIIllIlIllIllIII : this.registeredCLs.entrySet()) {
                if (llllllllllllllIIIIIllIlIllIllIII.getValue().isUnloadedClassLoader()) {
                    final ClassLoader llllllllllllllIIIIIllIlIllIllIIl = llllllllllllllIIIIIllIlIllIllIII.getValue().getClassLoader();
                    if (llllllllllllllIIIIIllIlIllIllIIl != null) {
                        if (llllllllllllllIIIIIllIlIllIlIlIl == null) {
                            llllllllllllllIIIIIllIlIllIlIlIl = new ArrayList<ClassLoader>();
                        }
                        llllllllllllllIIIIIllIlIllIlIlIl.add(llllllllllllllIIIIIllIlIllIllIIl);
                    }
                    this.registeredCLs.remove(llllllllllllllIIIIIllIlIllIllIII.getKey());
                }
            }
            if (llllllllllllllIIIIIllIlIllIlIlIl != null) {
                for (final ClassLoader llllllllllllllIIIIIllIlIllIlIlll : llllllllllllllIIIIIllIlIllIlIlIl) {
                    this.unregisterClassLoader(llllllllllllllIIIIIllIlIllIlIlll);
                }
            }
        }
    }
    
    @Override
    public ClassPool registerClassLoader(final ClassLoader llllllllllllllIIIIIllIlIlllIlIIl) {
        synchronized (this.registeredCLs) {
            if (this.registeredCLs.containsKey(llllllllllllllIIIIIllIlIlllIlIIl)) {
                return this.registeredCLs.get(llllllllllllllIIIIIllIlIlllIlIIl);
            }
            final ScopedClassPool llllllllllllllIIIIIllIlIlllIlIll = this.createScopedClassPool(llllllllllllllIIIIIllIlIlllIlIIl, this.classpool);
            this.registeredCLs.put(llllllllllllllIIIIIllIlIlllIlIIl, llllllllllllllIIIIIllIlIlllIlIll);
            return llllllllllllllIIIIIllIlIlllIlIll;
        }
    }
    
    @Override
    public ScopedClassPool createScopedClassPool(final ClassLoader llllllllllllllIIIIIllIlIlllllIll, final ClassPool llllllllllllllIIIIIllIlIlllllIlI) {
        return this.factory.create(llllllllllllllIIIIIllIlIlllllIll, llllllllllllllIIIIIllIlIlllllIlI, this);
    }
}
