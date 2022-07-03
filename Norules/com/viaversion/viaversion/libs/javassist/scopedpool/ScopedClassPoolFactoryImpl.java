package com.viaversion.viaversion.libs.javassist.scopedpool;

import com.viaversion.viaversion.libs.javassist.*;

public class ScopedClassPoolFactoryImpl implements ScopedClassPoolFactory
{
    @Override
    public ScopedClassPool create(final ClassPool lllllllllllllIIlIlllIllIllIIlIll, final ScopedClassPoolRepository lllllllllllllIIlIlllIllIllIIlIlI) {
        return new ScopedClassPool(null, lllllllllllllIIlIlllIllIllIIlIll, lllllllllllllIIlIlllIllIllIIlIlI, true);
    }
    
    @Override
    public ScopedClassPool create(final ClassLoader lllllllllllllIIlIlllIllIllIlIlII, final ClassPool lllllllllllllIIlIlllIllIllIlIIII, final ScopedClassPoolRepository lllllllllllllIIlIlllIllIllIlIIlI) {
        return new ScopedClassPool(lllllllllllllIIlIlllIllIllIlIlII, lllllllllllllIIlIlllIllIllIlIIII, lllllllllllllIIlIlllIllIllIlIIlI, false);
    }
}
