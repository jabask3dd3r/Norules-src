package com.viaversion.viaversion.libs.javassist;

import java.util.*;
import com.viaversion.viaversion.libs.javassist.bytecode.*;

public class ClassMap extends HashMap<String, String>
{
    private /* synthetic */ ClassMap parent;
    
    public static String toJavaName(final String lllllllllllllllllIIIlIIlIlIlIIII) {
        return Descriptor.toJavaName(lllllllllllllllllIIIlIIlIlIlIIII);
    }
    
    public static String toJvmName(final String lllllllllllllllllIIIlIIlIlIlIIlI) {
        return Descriptor.toJvmName(lllllllllllllllllIIIlIIlIlIlIIlI);
    }
    
    ClassMap(final ClassMap lllllllllllllllllIIIlIIllIIlllll) {
        this.parent = lllllllllllllllllIIIlIIllIIlllll;
    }
    
    protected final String put0(final String lllllllllllllllllIIIlIIlIlllIIIl, final String lllllllllllllllllIIIlIIlIlllIIII) {
        return super.put(lllllllllllllllllIIIlIIlIlllIIIl, lllllllllllllllllIIIlIIlIlllIIII);
    }
    
    public ClassMap() {
        this.parent = null;
    }
    
    public void putIfNone(final String lllllllllllllllllIIIlIIlIllllIIl, final String lllllllllllllllllIIIlIIlIlllllIl) {
        if (lllllllllllllllllIIIlIIlIllllIIl == lllllllllllllllllIIIlIIlIlllllIl) {
            return;
        }
        final String lllllllllllllllllIIIlIIlIlllllII = toJvmName(lllllllllllllllllIIIlIIlIllllIIl);
        final String lllllllllllllllllIIIlIIlIllllIll = this.get(lllllllllllllllllIIIlIIlIlllllII);
        if (lllllllllllllllllIIIlIIlIllllIll == null) {
            super.put(lllllllllllllllllIIIlIIlIlllllII, toJvmName(lllllllllllllllllIIIlIIlIlllllIl));
        }
    }
    
    @Override
    public String get(final Object lllllllllllllllllIIIlIIlIllIlIII) {
        final String lllllllllllllllllIIIlIIlIllIIlll = super.get(lllllllllllllllllIIIlIIlIllIlIII);
        if (lllllllllllllllllIIIlIIlIllIIlll == null && this.parent != null) {
            return this.parent.get(lllllllllllllllllIIIlIIlIllIlIII);
        }
        return lllllllllllllllllIIIlIIlIllIIlll;
    }
    
    public void put(final CtClass lllllllllllllllllIIIlIIllIIllIII, final CtClass lllllllllllllllllIIIlIIllIIlIlll) {
        this.put(lllllllllllllllllIIIlIIllIIllIII.getName(), lllllllllllllllllIIIlIIllIIlIlll.getName());
    }
    
    @Override
    public String put(final String lllllllllllllllllIIIlIIllIIIllIl, final String lllllllllllllllllIIIlIIllIIIIlll) {
        if (lllllllllllllllllIIIlIIllIIIllIl == lllllllllllllllllIIIlIIllIIIIlll) {
            return lllllllllllllllllIIIlIIllIIIllIl;
        }
        final String lllllllllllllllllIIIlIIllIIIlIll = toJvmName(lllllllllllllllllIIIlIIllIIIllIl);
        final String lllllllllllllllllIIIlIIllIIIlIlI = this.get(lllllllllllllllllIIIlIIllIIIlIll);
        if (lllllllllllllllllIIIlIIllIIIlIlI == null || !lllllllllllllllllIIIlIIllIIIlIlI.equals(lllllllllllllllllIIIlIIllIIIlIll)) {
            return super.put(lllllllllllllllllIIIlIIllIIIlIll, toJvmName(lllllllllllllllllIIIlIIllIIIIlll));
        }
        return lllllllllllllllllIIIlIIllIIIlIlI;
    }
    
    public void fix(final CtClass lllllllllllllllllIIIlIIlIllIIIII) {
        this.fix(lllllllllllllllllIIIlIIlIllIIIII.getName());
    }
    
    public void fix(final String lllllllllllllllllIIIlIIlIlIllIIl) {
        final String lllllllllllllllllIIIlIIlIlIllIII = toJvmName(lllllllllllllllllIIIlIIlIlIllIIl);
        super.put(lllllllllllllllllIIIlIIlIlIllIII, lllllllllllllllllIIIlIIlIlIllIII);
    }
}
