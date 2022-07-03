package com.viaversion.viaversion.libs.javassist.tools;

import com.viaversion.viaversion.libs.javassist.*;
import java.util.*;

public abstract class Callback
{
    private final /* synthetic */ String sourceCode;
    public static /* synthetic */ Map<String, Callback> callbacks;
    
    @Override
    public String toString() {
        return this.sourceCode();
    }
    
    public abstract void result(final Object[] p0);
    
    public static void insertBefore(final CtBehavior llllllllllllllIlIlIIIIIIIlIlllll, final Callback llllllllllllllIlIlIIIIIIIlIllllI) throws CannotCompileException {
        llllllllllllllIlIlIIIIIIIlIlllll.insertBefore(llllllllllllllIlIlIIIIIIIlIllllI.toString());
    }
    
    public static void insertAfter(final CtBehavior llllllllllllllIlIlIIIIIIIlIlIlII, final Callback llllllllllllllIlIlIIIIIIIlIlIIll, final boolean llllllllllllllIlIlIIIIIIIlIIllll) throws CannotCompileException {
        llllllllllllllIlIlIIIIIIIlIlIlII.insertAfter(llllllllllllllIlIlIIIIIIIlIlIIll.toString(), llllllllllllllIlIlIIIIIIIlIIllll);
    }
    
    public static void insertAfter(final CtBehavior llllllllllllllIlIlIIIIIIIlIllIIl, final Callback llllllllllllllIlIlIIIIIIIlIllIlI) throws CannotCompileException {
        llllllllllllllIlIlIIIIIIIlIllIIl.insertAfter(llllllllllllllIlIlIIIIIIIlIllIlI.toString(), false);
    }
    
    static {
        Callback.callbacks = new HashMap<String, Callback>();
    }
    
    public String sourceCode() {
        return this.sourceCode;
    }
    
    public Callback(final String llllllllllllllIlIlIIIIIIIllIlllI) {
        final String llllllllllllllIlIlIIIIIIIllIllIl = UUID.randomUUID().toString();
        Callback.callbacks.put(llllllllllllllIlIlIIIIIIIllIllIl, this);
        this.sourceCode = String.valueOf(new StringBuilder().append("((javassist.tools.Callback) javassist.tools.Callback.callbacks.get(\"").append(llllllllllllllIlIlIIIIIIIllIllIl).append("\")).result(new Object[]{").append(llllllllllllllIlIlIIIIIIIllIlllI).append("});"));
    }
    
    public static int insertAt(final CtBehavior llllllllllllllIlIlIIIIIIIlIIlIII, final Callback llllllllllllllIlIlIIIIIIIlIIIlll, final int llllllllllllllIlIlIIIIIIIlIIlIIl) throws CannotCompileException {
        return llllllllllllllIlIlIIIIIIIlIIlIII.insertAt(llllllllllllllIlIlIIIIIIIlIIlIIl, llllllllllllllIlIlIIIIIIIlIIIlll.toString());
    }
}
