package com.viaversion.viaversion.libs.javassist.util.proxy;

import java.lang.invoke.*;
import java.security.*;
import com.viaversion.viaversion.libs.javassist.bytecode.*;
import java.lang.reflect.*;
import java.util.*;

class SecurityActions extends SecurityManager
{
    public static final /* synthetic */ SecurityActions stack;
    
    static TheUnsafe getSunMiscUnsafeAnonymously() throws ClassNotFoundException {
        try {
            return AccessController.doPrivileged((PrivilegedExceptionAction<TheUnsafe>)new PrivilegedExceptionAction<TheUnsafe>() {
                @Override
                public TheUnsafe run() throws SecurityException, IllegalArgumentException, IllegalAccessException, ClassNotFoundException, NoSuchFieldException {
                    final Class<?> llllllllllllIlllllIIlIIlIIIIllll = Class.forName("sun.misc.Unsafe");
                    final Field llllllllllllIlllllIIlIIlIIIIlllI = llllllllllllIlllllIIlIIlIIIIllll.getDeclaredField("theUnsafe");
                    llllllllllllIlllllIIlIIlIIIIlllI.setAccessible(true);
                    final SecurityActions stack = SecurityActions.stack;
                    Objects.requireNonNull(stack);
                    final TheUnsafe llllllllllllIlllllIIlIIlIIIIllIl = new TheUnsafe(llllllllllllIlllllIIlIIlIIIIllll, llllllllllllIlllllIIlIIlIIIIlllI.get(null));
                    llllllllllllIlllllIIlIIlIIIIlllI.setAccessible(false);
                    SecurityActions.disableWarning(llllllllllllIlllllIIlIIlIIIIllIl);
                    return llllllllllllIlllllIIlIIlIIIIllIl;
                }
            });
        }
        catch (PrivilegedActionException lllllllllllllllllllllIlIlIIlIlII) {
            if (lllllllllllllllllllllIlIlIIlIlII.getCause() instanceof ClassNotFoundException) {
                throw (ClassNotFoundException)lllllllllllllllllllllIlIlIIlIlII.getCause();
            }
            if (lllllllllllllllllllllIlIlIIlIlII.getCause() instanceof NoSuchFieldException) {
                throw new ClassNotFoundException("No such instance.", lllllllllllllllllllllIlIlIIlIlII.getCause());
            }
            if (lllllllllllllllllllllIlIlIIlIlII.getCause() instanceof IllegalAccessException || lllllllllllllllllllllIlIlIIlIlII.getCause() instanceof IllegalAccessException || lllllllllllllllllllllIlIlIIlIlII.getCause() instanceof SecurityException) {
                throw new ClassNotFoundException("Security denied access.", lllllllllllllllllllllIlIlIIlIlII.getCause());
            }
            throw new RuntimeException(lllllllllllllllllllllIlIlIIlIlII.getCause());
        }
    }
    
    static MethodHandle getMethodHandle(final Class<?> lllllllllllllllllllllIlIllIIllIl, final String lllllllllllllllllllllIlIllIIIlII, final Class<?>[] lllllllllllllllllllllIlIllIIlIII) throws NoSuchMethodException {
        try {
            return AccessController.doPrivileged((PrivilegedExceptionAction<MethodHandle>)new PrivilegedExceptionAction<MethodHandle>() {
                @Override
                public MethodHandle run() throws IllegalAccessException, SecurityException, NoSuchMethodException {
                    final Method lllllllllllllIlIIIIIlIlIllIllIII = lllllllllllllllllllllIlIllIIllIl.getDeclaredMethod(lllllllllllllllllllllIlIllIIIlII, (Class[])lllllllllllllllllllllIlIllIIlIII);
                    lllllllllllllIlIIIIIlIlIllIllIII.setAccessible(true);
                    final MethodHandle lllllllllllllIlIIIIIlIlIllIlIlll = MethodHandles.lookup().unreflect(lllllllllllllIlIIIIIlIlIllIllIII);
                    lllllllllllllIlIIIIIlIlIllIllIII.setAccessible(false);
                    return lllllllllllllIlIIIIIlIlIllIlIlll;
                }
            });
        }
        catch (PrivilegedActionException lllllllllllllllllllllIlIllIIllll) {
            if (lllllllllllllllllllllIlIllIIllll.getCause() instanceof NoSuchMethodException) {
                throw (NoSuchMethodException)lllllllllllllllllllllIlIllIIllll.getCause();
            }
            throw new RuntimeException(lllllllllllllllllllllIlIllIIllll.getCause());
        }
    }
    
    public Class<?> getCallerClass() {
        return (Class<?>)this.getClassContext()[2];
    }
    
    static void set(final Field lllllllllllllllllllllIlIlIIlllII, final Object lllllllllllllllllllllIlIlIIllIII, final Object lllllllllllllllllllllIlIlIIllIlI) throws IllegalAccessException {
        if (System.getSecurityManager() == null) {
            lllllllllllllllllllllIlIlIIlllII.set(lllllllllllllllllllllIlIlIIllIII, lllllllllllllllllllllIlIlIIllIlI);
        }
        else {
            try {
                AccessController.doPrivileged((PrivilegedExceptionAction<Object>)new PrivilegedExceptionAction<Void>() {
                    @Override
                    public Void run() throws Exception {
                        lllllllllllllllllllllIlIlIIlllII.set(lllllllllllllllllllllIlIlIIllIII, lllllllllllllllllllllIlIlIIllIlI);
                        return null;
                    }
                });
            }
            catch (PrivilegedActionException lllllllllllllllllllllIlIlIIlllIl) {
                if (lllllllllllllllllllllIlIlIIlllIl.getCause() instanceof NoSuchMethodException) {
                    throw (IllegalAccessException)lllllllllllllllllllllIlIlIIlllIl.getCause();
                }
                throw new RuntimeException(lllllllllllllllllllllIlIlIIlllIl.getCause());
            }
        }
    }
    
    static {
        stack = new SecurityActions();
    }
    
    static Method getDeclaredMethod(final Class<?> lllllllllllllllllllllIlIlIllIlII, final String lllllllllllllllllllllIlIlIllIIll, final Class<?>[] lllllllllllllllllllllIlIlIllIIlI) throws NoSuchMethodException {
        if (System.getSecurityManager() == null) {
            return lllllllllllllllllllllIlIlIllIlII.getDeclaredMethod(lllllllllllllllllllllIlIlIllIIll, lllllllllllllllllllllIlIlIllIIlI);
        }
        try {
            return AccessController.doPrivileged((PrivilegedExceptionAction<Method>)new PrivilegedExceptionAction<Method>() {
                @Override
                public Method run() throws Exception {
                    return lllllllllllllllllllllIlIlIllIlII.getDeclaredMethod(lllllllllllllllllllllIlIlIllIIll, (Class[])lllllllllllllllllllllIlIlIllIIlI);
                }
            });
        }
        catch (PrivilegedActionException lllllllllllllllllllllIlIlIlllIlI) {
            if (lllllllllllllllllllllIlIlIlllIlI.getCause() instanceof NoSuchMethodException) {
                throw (NoSuchMethodException)lllllllllllllllllllllIlIlIlllIlI.getCause();
            }
            throw new RuntimeException(lllllllllllllllllllllIlIlIlllIlI.getCause());
        }
    }
    
    static Method[] getDeclaredMethods(final Class<?> lllllllllllllllllllllIlIlllIIIlI) {
        if (System.getSecurityManager() == null) {
            return lllllllllllllllllllllIlIlllIIIlI.getDeclaredMethods();
        }
        return AccessController.doPrivileged((PrivilegedAction<Method[]>)new PrivilegedAction<Method[]>() {
            @Override
            public Method[] run() {
                return lllllllllllllllllllllIlIlllIIIlI.getDeclaredMethods();
            }
        });
    }
    
    static Constructor<?> getDeclaredConstructor(final Class<?> lllllllllllllllllllllIlIlIlIlIlI, final Class<?>[] lllllllllllllllllllllIlIlIlIlIIl) throws NoSuchMethodException {
        if (System.getSecurityManager() == null) {
            return lllllllllllllllllllllIlIlIlIlIlI.getDeclaredConstructor(lllllllllllllllllllllIlIlIlIlIIl);
        }
        try {
            return AccessController.doPrivileged((PrivilegedExceptionAction<Constructor<?>>)new PrivilegedExceptionAction<Constructor<?>>() {
                @Override
                public Constructor<?> run() throws Exception {
                    return lllllllllllllllllllllIlIlIlIlIlI.getDeclaredConstructor((Class<?>[])lllllllllllllllllllllIlIlIlIlIIl);
                }
            });
        }
        catch (PrivilegedActionException lllllllllllllllllllllIlIlIlIllIl) {
            if (lllllllllllllllllllllIlIlIlIllIl.getCause() instanceof NoSuchMethodException) {
                throw (NoSuchMethodException)lllllllllllllllllllllIlIlIlIllIl.getCause();
            }
            throw new RuntimeException(lllllllllllllllllllllIlIlIlIllIl.getCause());
        }
    }
    
    static void disableWarning(final TheUnsafe lllllllllllllllllllllIlIlIIIllII) {
        try {
            if (ClassFile.MAJOR_VERSION < 53) {
                return;
            }
            final Class<?> lllllllllllllllllllllIlIlIIIllll = Class.forName("jdk.internal.module.IllegalAccessLogger");
            final Field lllllllllllllllllllllIlIlIIIlllI = lllllllllllllllllllllIlIlIIIllll.getDeclaredField("logger");
            lllllllllllllllllllllIlIlIIIllII.call("putObjectVolatile", lllllllllllllllllllllIlIlIIIllll, lllllllllllllllllllllIlIlIIIllII.call("staticFieldOffset", lllllllllllllllllllllIlIlIIIlllI), null);
        }
        catch (Exception ex) {}
    }
    
    static void setAccessible(final AccessibleObject lllllllllllllllllllllIlIlIlIIIll, final boolean lllllllllllllllllllllIlIlIlIIlII) {
        if (System.getSecurityManager() == null) {
            lllllllllllllllllllllIlIlIlIIIll.setAccessible(lllllllllllllllllllllIlIlIlIIlII);
        }
        else {
            AccessController.doPrivileged((PrivilegedAction<Object>)new PrivilegedAction<Void>() {
                @Override
                public Void run() {
                    lllllllllllllllllllllIlIlIlIIIll.setAccessible(lllllllllllllllllllllIlIlIlIIlII);
                    return null;
                }
            });
        }
    }
    
    static Constructor<?>[] getDeclaredConstructors(final Class<?> lllllllllllllllllllllIlIllIllIII) {
        if (System.getSecurityManager() == null) {
            return lllllllllllllllllllllIlIllIllIII.getDeclaredConstructors();
        }
        return (Constructor<?>[])AccessController.doPrivileged((PrivilegedAction<Constructor[]>)new PrivilegedAction<Constructor<?>[]>() {
            @Override
            public Constructor<?>[] run() {
                return (Constructor<?>[])lllllllllllllllllllllIlIllIllIII.getDeclaredConstructors();
            }
        });
    }
    
    class TheUnsafe
    {
        final /* synthetic */ Map<String, List<Method>> methods;
        final /* synthetic */ Class<?> unsafe;
        final /* synthetic */ Object theUnsafe;
        
        public Object call(final String llllllllllllllIIIIllllIlllIIlIII, final Object... llllllllllllllIIIIllllIlllIIlIlI) {
            try {
                return this.getM(llllllllllllllIIIIllllIlllIIlIII, llllllllllllllIIIIllllIlllIIlIlI).invoke(this.theUnsafe, llllllllllllllIIIIllllIlllIIlIlI);
            }
            catch (Throwable llllllllllllllIIIIllllIlllIIllIl) {
                llllllllllllllIIIIllllIlllIIllIl.printStackTrace();
                return null;
            }
        }
        
        private Method getM(final String llllllllllllllIIIIllllIlllIlIIlI, final Object[] llllllllllllllIIIIllllIlllIlIlII) {
            return this.methods.get(llllllllllllllIIIIllllIlllIlIIlI).get(0);
        }
        
        TheUnsafe(final Class<?> llllllllllllllIIIIllllIlllIllllI, final Object llllllllllllllIIIIllllIllllIIIIl) {
            this.methods = new HashMap<String, List<Method>>();
            this.unsafe = llllllllllllllIIIIllllIlllIllllI;
            this.theUnsafe = llllllllllllllIIIIllllIllllIIIIl;
            final char llllllllllllllIIIIllllIlllIlllII = (Object)this.unsafe.getDeclaredMethods();
            final boolean llllllllllllllIIIIllllIlllIllIll = llllllllllllllIIIIllllIlllIlllII.length != 0;
            for (char llllllllllllllIIIIllllIlllIllIlI = '\0'; llllllllllllllIIIIllllIlllIllIlI < (llllllllllllllIIIIllllIlllIllIll ? 1 : 0); ++llllllllllllllIIIIllllIlllIllIlI) {
                final Method llllllllllllllIIIIllllIllllIIlIl = llllllllllllllIIIIllllIlllIlllII[llllllllllllllIIIIllllIlllIllIlI];
                if (!this.methods.containsKey(llllllllllllllIIIIllllIllllIIlIl.getName())) {
                    this.methods.put(llllllllllllllIIIIllllIllllIIlIl.getName(), Collections.singletonList(llllllllllllllIIIIllllIllllIIlIl));
                }
                else {
                    if (this.methods.get(llllllllllllllIIIIllllIllllIIlIl.getName()).size() == 1) {
                        this.methods.put(llllllllllllllIIIIllllIllllIIlIl.getName(), new ArrayList<Method>(this.methods.get(llllllllllllllIIIIllllIllllIIlIl.getName())));
                    }
                    this.methods.get(llllllllllllllIIIIllllIllllIIlIl.getName()).add(llllllllllllllIIIIllllIllllIIlIl);
                }
            }
        }
    }
}
