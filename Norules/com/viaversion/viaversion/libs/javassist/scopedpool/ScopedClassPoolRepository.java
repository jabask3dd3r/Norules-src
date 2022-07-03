package com.viaversion.viaversion.libs.javassist.scopedpool;

import java.util.*;
import com.viaversion.viaversion.libs.javassist.*;

public interface ScopedClassPoolRepository
{
    Map<ClassLoader, ScopedClassPool> getRegisteredCLs();
    
    void setPrune(final boolean p0);
    
    void unregisterClassLoader(final ClassLoader p0);
    
    void setClassPoolFactory(final ScopedClassPoolFactory p0);
    
    boolean isPrune();
    
    void clearUnregisteredClassLoaders();
    
    ClassPool findClassPool(final ClassLoader p0);
    
    ScopedClassPool createScopedClassPool(final ClassLoader p0, final ClassPool p1);
    
    ScopedClassPoolFactory getClassPoolFactory();
    
    ClassPool registerClassLoader(final ClassLoader p0);
}
