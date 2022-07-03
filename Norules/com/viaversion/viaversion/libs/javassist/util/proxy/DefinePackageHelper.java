package com.viaversion.viaversion.libs.javassist.util.proxy;

import java.net.*;
import com.viaversion.viaversion.libs.javassist.*;
import com.viaversion.viaversion.libs.javassist.bytecode.*;
import java.lang.invoke.*;
import java.lang.reflect.*;

public class DefinePackageHelper
{
    private static final /* synthetic */ Helper privileged;
    
    public static void definePackage(final String lIlIIIIIllIIIll, final ClassLoader lIlIIIIIllIIIII) throws CannotCompileException {
        try {
            DefinePackageHelper.privileged.definePackage(lIlIIIIIllIIIII, lIlIIIIIllIIIll, null, null, null, null, null, null, null);
        }
        catch (IllegalArgumentException lIlIIIIIllIIlIl) {}
        catch (Exception lIlIIIIIllIIlII) {
            throw new CannotCompileException(lIlIIIIIllIIlII);
        }
    }
    
    private DefinePackageHelper() {
    }
    
    static {
        privileged = ((ClassFile.MAJOR_VERSION >= 53) ? new Java9() : ((ClassFile.MAJOR_VERSION >= 51) ? new Java7() : new JavaOther()));
    }
    
    private abstract static class Helper
    {
        abstract Package definePackage(final ClassLoader p0, final String p1, final String p2, final String p3, final String p4, final String p5, final String p6, final String p7, final URL p8) throws IllegalArgumentException;
    }
    
    private static class Java7 extends Helper
    {
        private final /* synthetic */ MethodHandle definePackage;
        private final /* synthetic */ SecurityActions stack;
        
        private Java7() {
            this.stack = SecurityActions.stack;
            this.definePackage = this.getDefinePackageMethodHandle();
        }
        
        private MethodHandle getDefinePackageMethodHandle() {
            if (this.stack.getCallerClass() != this.getClass()) {
                throw new IllegalAccessError("Access denied for caller.");
            }
            try {
                return SecurityActions.getMethodHandle(ClassLoader.class, "definePackage", new Class[] { String.class, String.class, String.class, String.class, String.class, String.class, String.class, URL.class });
            }
            catch (NoSuchMethodException llllllllllllllllllllllIllIllIlII) {
                throw new RuntimeException("cannot initialize", llllllllllllllllllllllIllIllIlII);
            }
        }
        
        @Override
        Package definePackage(final ClassLoader llllllllllllllllllllllIllIlIIIll, final String llllllllllllllllllllllIllIlIIIlI, final String llllllllllllllllllllllIllIIlIlll, final String llllllllllllllllllllllIllIlIIIII, final String llllllllllllllllllllllIllIIlllll, final String llllllllllllllllllllllIllIIlIlII, final String llllllllllllllllllllllIllIIlllIl, final String llllllllllllllllllllllIllIIlIIlI, final URL llllllllllllllllllllllIllIIlIIIl) throws IllegalArgumentException {
            if (this.stack.getCallerClass() != DefinePackageHelper.class) {
                throw new IllegalAccessError("Access denied for caller.");
            }
            try {
                return (Package)this.definePackage.invokeWithArguments(llllllllllllllllllllllIllIlIIIll, llllllllllllllllllllllIllIlIIIlI, llllllllllllllllllllllIllIIlIlll, llllllllllllllllllllllIllIlIIIII, llllllllllllllllllllllIllIIlllll, llllllllllllllllllllllIllIIlIlII, llllllllllllllllllllllIllIIlllIl, llllllllllllllllllllllIllIIlIIlI, llllllllllllllllllllllIllIIlIIIl);
            }
            catch (Throwable llllllllllllllllllllllIllIlIIlIl) {
                if (llllllllllllllllllllllIllIlIIlIl instanceof IllegalArgumentException) {
                    throw (IllegalArgumentException)llllllllllllllllllllllIllIlIIlIl;
                }
                if (llllllllllllllllllllllIllIlIIlIl instanceof RuntimeException) {
                    throw (RuntimeException)llllllllllllllllllllllIllIlIIlIl;
                }
                return null;
            }
        }
    }
    
    private static class Java9 extends Helper
    {
        @Override
        Package definePackage(final ClassLoader lllllllllllllIIlIlIllIllIIllIlll, final String lllllllllllllIIlIlIllIllIIllIllI, final String lllllllllllllIIlIlIllIllIIllIlIl, final String lllllllllllllIIlIlIllIllIIllIlII, final String lllllllllllllIIlIlIllIllIIllIIll, final String lllllllllllllIIlIlIllIllIIllIIlI, final String lllllllllllllIIlIlIllIllIIllIIIl, final String lllllllllllllIIlIlIllIllIIllIIII, final URL lllllllllllllIIlIlIllIllIIlIllll) throws IllegalArgumentException {
            throw new RuntimeException("define package has been disabled for jigsaw");
        }
    }
    
    private static class JavaOther extends Helper
    {
        private final /* synthetic */ Method definePackage;
        private final /* synthetic */ SecurityActions stack;
        
        private Method getDefinePackageMethod() {
            if (this.stack.getCallerClass() != this.getClass()) {
                throw new IllegalAccessError("Access denied for caller.");
            }
            try {
                return SecurityActions.getDeclaredMethod(ClassLoader.class, "definePackage", new Class[] { String.class, String.class, String.class, String.class, String.class, String.class, String.class, URL.class });
            }
            catch (NoSuchMethodException lllllllllllllIIIllIllIIIIIIIIllI) {
                throw new RuntimeException("cannot initialize", lllllllllllllIIIllIllIIIIIIIIllI);
            }
        }
        
        private JavaOther() {
            this.stack = SecurityActions.stack;
            this.definePackage = this.getDefinePackageMethod();
        }
        
        @Override
        Package definePackage(final ClassLoader lllllllllllllIIIllIlIlllllllIIll, final String lllllllllllllIIIllIlIllllllIlIII, final String lllllllllllllIIIllIlIlllllllIIIl, final String lllllllllllllIIIllIlIllllllIIllI, final String lllllllllllllIIIllIlIllllllIllll, final String lllllllllllllIIIllIlIllllllIIlII, final String lllllllllllllIIIllIlIllllllIllIl, final String lllllllllllllIIIllIlIllllllIIIlI, final URL lllllllllllllIIIllIlIllllllIlIll) throws IllegalArgumentException {
            if (this.stack.getCallerClass() != DefinePackageHelper.class) {
                throw new IllegalAccessError("Access denied for caller.");
            }
            try {
                this.definePackage.setAccessible(true);
                return (Package)this.definePackage.invoke(lllllllllllllIIIllIlIlllllllIIll, lllllllllllllIIIllIlIllllllIlIII, lllllllllllllIIIllIlIlllllllIIIl, lllllllllllllIIIllIlIllllllIIllI, lllllllllllllIIIllIlIllllllIllll, lllllllllllllIIIllIlIllllllIIlII, lllllllllllllIIIllIlIllllllIllIl, lllllllllllllIIIllIlIllllllIIIlI, lllllllllllllIIIllIlIllllllIlIll);
            }
            catch (Throwable lllllllllllllIIIllIlIlllllllIlIl) {
                if (lllllllllllllIIIllIlIlllllllIlIl instanceof InvocationTargetException) {
                    final Throwable lllllllllllllIIIllIlIlllllllIllI = ((InvocationTargetException)lllllllllllllIIIllIlIlllllllIlIl).getTargetException();
                    if (lllllllllllllIIIllIlIlllllllIllI instanceof IllegalArgumentException) {
                        throw (IllegalArgumentException)lllllllllllllIIIllIlIlllllllIllI;
                    }
                }
                if (lllllllllllllIIIllIlIlllllllIlIl instanceof RuntimeException) {
                    throw (RuntimeException)lllllllllllllIIIllIlIlllllllIlIl;
                }
                return null;
            }
        }
    }
}
