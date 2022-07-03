package com.viaversion.viaversion.libs.javassist.util.proxy;

import com.viaversion.viaversion.libs.javassist.*;
import java.security.*;
import com.viaversion.viaversion.libs.javassist.bytecode.*;
import java.lang.invoke.*;
import java.lang.reflect.*;
import java.util.*;

public class DefineClassHelper
{
    private static final /* synthetic */ Helper privileged;
    
    public static Class<?> toClass(final Class<?> lllllllllllllIlIIIIlllIIlIlIIIlI, final byte[] lllllllllllllIlIIIIlllIIlIlIIIIl) throws CannotCompileException {
        try {
            DefineClassHelper.class.getModule().addReads(lllllllllllllIlIIIIlllIIlIlIIIlI.getModule());
            final MethodHandles.Lookup lllllllllllllIlIIIIlllIIlIlIIlIl = MethodHandles.lookup();
            final MethodHandles.Lookup lllllllllllllIlIIIIlllIIlIlIIlII = MethodHandles.privateLookupIn((Class)lllllllllllllIlIIIIlllIIlIlIIIlI, lllllllllllllIlIIIIlllIIlIlIIlIl);
            return (Class<?>)lllllllllllllIlIIIIlllIIlIlIIlII.defineClass(lllllllllllllIlIIIIlllIIlIlIIIIl);
        }
        catch (IllegalAccessException | IllegalArgumentException ex2) {
            final Exception ex;
            final Exception lllllllllllllIlIIIIlllIIlIlIIIll = ex;
            throw new CannotCompileException(String.valueOf(new StringBuilder().append(lllllllllllllIlIIIIlllIIlIlIIIll.getMessage()).append(": ").append(lllllllllllllIlIIIIlllIIlIlIIIlI.getName()).append(" has no permission to define the class")));
        }
    }
    
    static Class<?> toPublicClass(final String lllllllllllllIlIIIIlllIIlIIIllll, final byte[] lllllllllllllIlIIIIlllIIlIIIllIl) throws CannotCompileException {
        try {
            MethodHandles.Lookup lllllllllllllIlIIIIlllIIlIIlIIIl = MethodHandles.lookup();
            lllllllllllllIlIIIIlllIIlIIlIIIl = lllllllllllllIlIIIIlllIIlIIlIIIl.dropLookupMode(2);
            return (Class<?>)lllllllllllllIlIIIIlllIIlIIlIIIl.defineClass(lllllllllllllIlIIIIlllIIlIIIllIl);
        }
        catch (Throwable lllllllllllllIlIIIIlllIIlIIlIIII) {
            throw new CannotCompileException(lllllllllllllIlIIIIlllIIlIIlIIII);
        }
    }
    
    private DefineClassHelper() {
    }
    
    public static Class<?> toClass(final String lllllllllllllIlIIIIlllIIlIllIlIl, final Class<?> lllllllllllllIlIIIIlllIIlIlIllll, final ClassLoader lllllllllllllIlIIIIlllIIlIlIlllI, final ProtectionDomain lllllllllllllIlIIIIlllIIlIllIIlI, final byte[] lllllllllllllIlIIIIlllIIlIlIllII) throws CannotCompileException {
        try {
            return DefineClassHelper.privileged.defineClass(lllllllllllllIlIIIIlllIIlIllIlIl, lllllllllllllIlIIIIlllIIlIlIllII, 0, lllllllllllllIlIIIIlllIIlIlIllII.length, lllllllllllllIlIIIIlllIIlIlIllll, lllllllllllllIlIIIIlllIIlIlIlllI, lllllllllllllIlIIIIlllIIlIllIIlI);
        }
        catch (RuntimeException lllllllllllllIlIIIIlllIIlIlllIlI) {
            throw lllllllllllllIlIIIIlllIIlIlllIlI;
        }
        catch (CannotCompileException lllllllllllllIlIIIIlllIIlIlllIIl) {
            throw lllllllllllllIlIIIIlllIIlIlllIIl;
        }
        catch (ClassFormatError lllllllllllllIlIIIIlllIIlIllIlll) {
            final Throwable lllllllllllllIlIIIIlllIIlIlllIII = lllllllllllllIlIIIIlllIIlIllIlll.getCause();
            throw new CannotCompileException((lllllllllllllIlIIIIlllIIlIlllIII == null) ? lllllllllllllIlIIIIlllIIlIllIlll : lllllllllllllIlIIIIlllIIlIlllIII);
        }
        catch (Exception lllllllllllllIlIIIIlllIIlIllIllI) {
            throw new CannotCompileException(lllllllllllllIlIIIIlllIIlIllIllI);
        }
    }
    
    public static Class<?> toClass(final MethodHandles.Lookup lllllllllllllIlIIIIlllIIlIIllIII, final byte[] lllllllllllllIlIIIIlllIIlIIlIlll) throws CannotCompileException {
        try {
            return (Class<?>)lllllllllllllIlIIIIlllIIlIIllIII.defineClass(lllllllllllllIlIIIIlllIIlIIlIlll);
        }
        catch (IllegalAccessException | IllegalArgumentException ex2) {
            final Exception ex;
            final Exception lllllllllllllIlIIIIlllIIlIIllIIl = ex;
            throw new CannotCompileException(lllllllllllllIlIIIIlllIIlIIllIIl.getMessage());
        }
    }
    
    static {
        privileged = ((ClassFile.MAJOR_VERSION > 54) ? new Java11() : ((ClassFile.MAJOR_VERSION >= 53) ? new Java9() : ((ClassFile.MAJOR_VERSION >= 51) ? new Java7() : new JavaOther())));
    }
    
    private static class Java7 extends Helper
    {
        private final /* synthetic */ MethodHandle defineClass;
        private final /* synthetic */ SecurityActions stack;
        
        @Override
        Class<?> defineClass(final String lllllllllllllIIllIIlIIlIIlIIIIIl, final byte[] lllllllllllllIIllIIlIIlIIIllllll, final int lllllllllllllIIllIIlIIlIIIllIIII, final int lllllllllllllIIllIIlIIlIIIlllIll, final Class<?> lllllllllllllIIllIIlIIlIIIlllIlI, final ClassLoader lllllllllllllIIllIIlIIlIIIlIlllI, final ProtectionDomain lllllllllllllIIllIIlIIlIIIlIllII) throws ClassFormatError {
            if (this.stack.getCallerClass() != DefineClassHelper.class) {
                throw new IllegalAccessError("Access denied for caller.");
            }
            try {
                return (Class<?>)this.defineClass.invokeWithArguments(lllllllllllllIIllIIlIIlIIIlIlllI, lllllllllllllIIllIIlIIlIIlIIIIIl, lllllllllllllIIllIIlIIlIIIllllll, lllllllllllllIIllIIlIIlIIIllIIII, lllllllllllllIIllIIlIIlIIIlllIll, lllllllllllllIIllIIlIIlIIIlIllII);
            }
            catch (Throwable lllllllllllllIIllIIlIIlIIlIIIIll) {
                if (lllllllllllllIIllIIlIIlIIlIIIIll instanceof RuntimeException) {
                    throw (RuntimeException)lllllllllllllIIllIIlIIlIIlIIIIll;
                }
                if (lllllllllllllIIllIIlIIlIIlIIIIll instanceof ClassFormatError) {
                    throw (ClassFormatError)lllllllllllllIIllIIlIIlIIlIIIIll;
                }
                throw new ClassFormatError(lllllllllllllIIllIIlIIlIIlIIIIll.getMessage());
            }
        }
        
        private final MethodHandle getDefineClassMethodHandle() {
            if (DefineClassHelper.privileged != null && this.stack.getCallerClass() != this.getClass()) {
                throw new IllegalAccessError("Access denied for caller.");
            }
            try {
                return SecurityActions.getMethodHandle(ClassLoader.class, "defineClass", new Class[] { String.class, byte[].class, Integer.TYPE, Integer.TYPE, ProtectionDomain.class });
            }
            catch (NoSuchMethodException lllllllllllllIIllIIlIIlIIlIlllII) {
                throw new RuntimeException("cannot initialize", lllllllllllllIIllIIlIIlIIlIlllII);
            }
        }
        
        private Java7() {
            this.stack = SecurityActions.stack;
            this.defineClass = this.getDefineClassMethodHandle();
        }
    }
    
    private abstract static class Helper
    {
        abstract Class<?> defineClass(final String p0, final byte[] p1, final int p2, final int p3, final Class<?> p4, final ClassLoader p5, final ProtectionDomain p6) throws CannotCompileException, ClassFormatError;
    }
    
    private static class JavaOther extends Helper
    {
        private final /* synthetic */ Method defineClass;
        private final /* synthetic */ SecurityActions stack;
        
        private JavaOther() {
            this.defineClass = this.getDefineClassMethod();
            this.stack = SecurityActions.stack;
        }
        
        @Override
        Class<?> defineClass(final String llllllllllllllIIllIlllIllllIlllI, final byte[] llllllllllllllIIllIlllIllllIllIl, final int llllllllllllllIIllIlllIllllIllII, final int llllllllllllllIIllIlllIllllIlIll, final Class<?> llllllllllllllIIllIlllIllllIlIlI, final ClassLoader llllllllllllllIIllIlllIllllIlIIl, final ProtectionDomain llllllllllllllIIllIlllIllllIIIII) throws CannotCompileException, ClassFormatError {
            final Class<?> llllllllllllllIIllIlllIllllIIlll = this.stack.getCallerClass();
            if (llllllllllllllIIllIlllIllllIIlll != DefineClassHelper.class && llllllllllllllIIllIlllIllllIIlll != this.getClass()) {
                throw new IllegalAccessError("Access denied for caller.");
            }
            try {
                SecurityActions.setAccessible(this.defineClass, true);
                return (Class<?>)this.defineClass.invoke(llllllllllllllIIllIlllIllllIlIIl, llllllllllllllIIllIlllIllllIlllI, llllllllllllllIIllIlllIllllIllIl, llllllllllllllIIllIlllIllllIllII, llllllllllllllIIllIlllIllllIlIll, llllllllllllllIIllIlllIllllIIIII);
            }
            catch (Throwable llllllllllllllIIllIlllIlllllIIII) {
                if (llllllllllllllIIllIlllIlllllIIII instanceof ClassFormatError) {
                    throw (ClassFormatError)llllllllllllllIIllIlllIlllllIIII;
                }
                if (llllllllllllllIIllIlllIlllllIIII instanceof RuntimeException) {
                    throw (RuntimeException)llllllllllllllIIllIlllIlllllIIII;
                }
                throw new CannotCompileException(llllllllllllllIIllIlllIlllllIIII);
            }
        }
        
        private final Method getDefineClassMethod() {
            if (DefineClassHelper.privileged != null && this.stack.getCallerClass() != this.getClass()) {
                throw new IllegalAccessError("Access denied for caller.");
            }
            try {
                return SecurityActions.getDeclaredMethod(ClassLoader.class, "defineClass", new Class[] { String.class, byte[].class, Integer.TYPE, Integer.TYPE, ProtectionDomain.class });
            }
            catch (NoSuchMethodException llllllllllllllIIllIlllIlllllllIl) {
                throw new RuntimeException("cannot initialize", llllllllllllllIIllIlllIlllllllIl);
            }
        }
    }
    
    private static class Java11 extends JavaOther
    {
        @Override
        Class<?> defineClass(final String lllllllllllllIlIIlllIIlIIIlIIIll, final byte[] lllllllllllllIlIIlllIIlIIIlIIIlI, final int lllllllllllllIlIIlllIIlIIIIllIIl, final int lllllllllllllIlIIlllIIlIIIlIIIII, final Class<?> lllllllllllllIlIIlllIIlIIIIlllll, final ClassLoader lllllllllllllIlIIlllIIlIIIIlIllI, final ProtectionDomain lllllllllllllIlIIlllIIlIIIIlIlIl) throws CannotCompileException, ClassFormatError {
            if (lllllllllllllIlIIlllIIlIIIIlllll != null) {
                return DefineClassHelper.toClass(lllllllllllllIlIIlllIIlIIIIlllll, lllllllllllllIlIIlllIIlIIIlIIIlI);
            }
            return super.defineClass(lllllllllllllIlIIlllIIlIIIlIIIll, lllllllllllllIlIIlllIIlIIIlIIIlI, lllllllllllllIlIIlllIIlIIIIllIIl, lllllllllllllIlIIlllIIlIIIlIIIII, lllllllllllllIlIIlllIIlIIIIlllll, lllllllllllllIlIIlllIIlIIIIlIllI, lllllllllllllIlIIlllIIlIIIIlIlIl);
        }
    }
    
    private static class Java9 extends Helper
    {
        private final /* synthetic */ Method getCallerClass;
        private final /* synthetic */ Object stack;
        private final /* synthetic */ ReferencedUnsafe sunMiscUnsafe;
        
        @Override
        Class<?> defineClass(final String llllllllllllllIIIIllIllIIlIIllII, final byte[] llllllllllllllIIIIllIllIIlIIlIll, final int llllllllllllllIIIIllIllIIlIIIIlI, final int llllllllllllllIIIIllIllIIlIIlIIl, final Class<?> llllllllllllllIIIIllIllIIlIIlIII, final ClassLoader llllllllllllllIIIIllIllIIlIIIIII, final ProtectionDomain llllllllllllllIIIIllIllIIlIIIllI) throws ClassFormatError {
            try {
                if (this.getCallerClass.invoke(this.stack, new Object[0]) != DefineClassHelper.class) {
                    throw new IllegalAccessError("Access denied for caller.");
                }
            }
            catch (Exception llllllllllllllIIIIllIllIIlIIlllI) {
                throw new RuntimeException("cannot initialize", llllllllllllllIIIIllIllIIlIIlllI);
            }
            return this.sunMiscUnsafe.defineClass(llllllllllllllIIIIllIllIIlIIllII, llllllllllllllIIIIllIllIIlIIlIll, llllllllllllllIIIIllIllIIlIIIIlI, llllllllllllllIIIIllIllIIlIIlIIl, llllllllllllllIIIIllIllIIlIIIIII, llllllllllllllIIIIllIllIIlIIIllI);
        }
        
        private final ReferencedUnsafe getReferencedUnsafe() {
            try {
                if (DefineClassHelper.privileged != null && this.getCallerClass.invoke(this.stack, new Object[0]) != this.getClass()) {
                    throw new IllegalAccessError("Access denied for caller.");
                }
            }
            catch (Exception llllllllllllllIIIIllIllIIllIIIII) {
                throw new RuntimeException("cannot initialize", llllllllllllllIIIIllIllIIllIIIII);
            }
            try {
                final SecurityActions.TheUnsafe llllllllllllllIIIIllIllIIlIlllll = SecurityActions.getSunMiscUnsafeAnonymously();
                final List<Method> llllllllllllllIIIIllIllIIlIllllI = llllllllllllllIIIIllIllIIlIlllll.methods.get("defineClass");
                if (null == llllllllllllllIIIIllIllIIlIllllI) {
                    return null;
                }
                final MethodHandle llllllllllllllIIIIllIllIIlIlllIl = MethodHandles.lookup().unreflect(llllllllllllllIIIIllIllIIlIllllI.get(0));
                return new ReferencedUnsafe(llllllllllllllIIIIllIllIIlIlllll, llllllllllllllIIIIllIllIIlIlllIl);
            }
            catch (Throwable llllllllllllllIIIIllIllIIlIlllII) {
                throw new RuntimeException("cannot initialize", llllllllllllllIIIIllIllIIlIlllII);
            }
        }
        
        Java9() {
            this.sunMiscUnsafe = this.getReferencedUnsafe();
            Class<?> llllllllllllllIIIIllIllIIllIlIII = null;
            try {
                llllllllllllllIIIIllIllIIllIlIII = Class.forName("java.lang.StackWalker");
            }
            catch (ClassNotFoundException ex) {}
            if (llllllllllllllIIIIllIllIIllIlIII != null) {
                try {
                    final Class<?> llllllllllllllIIIIllIllIIllIlIll = Class.forName("java.lang.StackWalker$Option");
                    this.stack = llllllllllllllIIIIllIllIIllIlIII.getMethod("getInstance", llllllllllllllIIIIllIllIIllIlIll).invoke(null, llllllllllllllIIIIllIllIIllIlIll.getEnumConstants()[0]);
                    this.getCallerClass = llllllllllllllIIIIllIllIIllIlIII.getMethod("getCallerClass", (Class<?>[])new Class[0]);
                    return;
                }
                catch (Throwable llllllllllllllIIIIllIllIIllIlIlI) {
                    throw new RuntimeException("cannot initialize", llllllllllllllIIIIllIllIIllIlIlI);
                }
            }
            this.stack = null;
            this.getCallerClass = null;
        }
        
        final class ReferencedUnsafe
        {
            private final /* synthetic */ MethodHandle defineClass;
            private final /* synthetic */ SecurityActions.TheUnsafe sunMiscUnsafeTheUnsafe;
            
            ReferencedUnsafe(final SecurityActions.TheUnsafe lllllllllllllIlIIIIlIlIIlIIlIIII, final MethodHandle lllllllllllllIlIIIIlIlIIlIIIlIll) {
                this.sunMiscUnsafeTheUnsafe = lllllllllllllIlIIIIlIlIIlIIlIIII;
                this.defineClass = lllllllllllllIlIIIIlIlIIlIIIlIll;
            }
            
            Class<?> defineClass(final String lllllllllllllIlIIIIlIlIIIlllllll, final byte[] lllllllllllllIlIIIIlIlIIIlllIlll, final int lllllllllllllIlIIIIlIlIIIlllllIl, final int lllllllllllllIlIIIIlIlIIIlllllII, final ClassLoader lllllllllllllIlIIIIlIlIIIllllIll, final ProtectionDomain lllllllllllllIlIIIIlIlIIIllllIlI) throws ClassFormatError {
                try {
                    if (Java9.this.getCallerClass.invoke(Java9.this.stack, new Object[0]) != Java9.class) {
                        throw new IllegalAccessError("Access denied for caller.");
                    }
                }
                catch (Exception lllllllllllllIlIIIIlIlIIlIIIIIlI) {
                    throw new RuntimeException("cannot initialize", lllllllllllllIlIIIIlIlIIlIIIIIlI);
                }
                try {
                    return (Class<?>)this.defineClass.invokeWithArguments(this.sunMiscUnsafeTheUnsafe.theUnsafe, lllllllllllllIlIIIIlIlIIIlllllll, lllllllllllllIlIIIIlIlIIIlllIlll, lllllllllllllIlIIIIlIlIIIlllllIl, lllllllllllllIlIIIIlIlIIIlllllII, lllllllllllllIlIIIIlIlIIIllllIll, lllllllllllllIlIIIIlIlIIIllllIlI);
                }
                catch (Throwable lllllllllllllIlIIIIlIlIIlIIIIIIl) {
                    if (lllllllllllllIlIIIIlIlIIlIIIIIIl instanceof RuntimeException) {
                        throw (RuntimeException)lllllllllllllIlIIIIlIlIIlIIIIIIl;
                    }
                    if (lllllllllllllIlIIIIlIlIIlIIIIIIl instanceof ClassFormatError) {
                        throw (ClassFormatError)lllllllllllllIlIIIIlIlIIlIIIIIIl;
                    }
                    throw new ClassFormatError(lllllllllllllIlIIIIlIlIIlIIIIIIl.getMessage());
                }
            }
        }
    }
}
