package com.viaversion.viaversion.libs.javassist.util.proxy;

import java.lang.reflect.*;
import java.io.*;

public class RuntimeSupport
{
    public static /* synthetic */ MethodHandler default_interceptor;
    
    public static SerializedProxy makeSerializedProxy(final Object llllllllllllllIIlIIIIIIlllllIlIl) throws InvalidClassException {
        final Class<?> llllllllllllllIIlIIIIIIlllllIlII = llllllllllllllIIlIIIIIIlllllIlIl.getClass();
        MethodHandler llllllllllllllIIlIIIIIIlllllIIll = null;
        if (llllllllllllllIIlIIIIIIlllllIlIl instanceof ProxyObject) {
            llllllllllllllIIlIIIIIIlllllIIll = ((ProxyObject)llllllllllllllIIlIIIIIIlllllIlIl).getHandler();
        }
        else if (llllllllllllllIIlIIIIIIlllllIlIl instanceof Proxy) {
            llllllllllllllIIlIIIIIIlllllIIll = ProxyFactory.getHandler((Proxy)llllllllllllllIIlIIIIIIlllllIlIl);
        }
        return new SerializedProxy(llllllllllllllIIlIIIIIIlllllIlII, ProxyFactory.getFilterSignature(llllllllllllllIIlIIIIIIlllllIlII), llllllllllllllIIlIIIIIIlllllIIll);
    }
    
    public static String makeDescriptor(final String llllllllllllllIIlIIIIIlIIIIIIlII, final Class<?> llllllllllllllIIlIIIIIlIIIIIIIII) {
        final StringBuffer llllllllllllllIIlIIIIIlIIIIIIIlI = new StringBuffer(llllllllllllllIIlIIIIIlIIIIIIlII);
        makeDesc(llllllllllllllIIlIIIIIlIIIIIIIlI, llllllllllllllIIlIIIIIlIIIIIIIII);
        return llllllllllllllIIlIIIIIlIIIIIIIlI.toString();
    }
    
    public static String makeDescriptor(final Method llllllllllllllIIlIIIIIlIIIIlIlll) {
        final Class<?>[] llllllllllllllIIlIIIIIlIIIIlIllI = llllllllllllllIIlIIIIIlIIIIlIlll.getParameterTypes();
        return makeDescriptor(llllllllllllllIIlIIIIIlIIIIlIllI, llllllllllllllIIlIIIIIlIIIIlIlll.getReturnType());
    }
    
    @Deprecated
    public static Method findMethod(final Object llllllllllllllIIlIIIIIlIlIIIIIIl, final String llllllllllllllIIlIIIIIlIlIIIIIII, final String llllllllllllllIIlIIIIIlIIlllllll) {
        final Method llllllllllllllIIlIIIIIlIIllllllI = findMethod2(llllllllllllllIIlIIIIIlIlIIIIIIl.getClass(), llllllllllllllIIlIIIIIlIlIIIIIII, llllllllllllllIIlIIIIIlIIlllllll);
        if (llllllllllllllIIlIIIIIlIIllllllI == null) {
            error(llllllllllllllIIlIIIIIlIlIIIIIIl.getClass(), llllllllllllllIIlIIIIIlIlIIIIIII, llllllllllllllIIlIIIIIlIIlllllll);
        }
        return llllllllllllllIIlIIIIIlIIllllllI;
    }
    
    static {
        RuntimeSupport.default_interceptor = new DefaultMethodHandler();
    }
    
    public static String makeDescriptor(final Class<?>[] llllllllllllllIIlIIIIIlIIIIIlllI, final Class<?> llllllllllllllIIlIIIIIlIIIIIllIl) {
        final StringBuffer llllllllllllllIIlIIIIIlIIIIIllII = new StringBuffer();
        llllllllllllllIIlIIIIIlIIIIIllII.append('(');
        for (int llllllllllllllIIlIIIIIlIIIIIllll = 0; llllllllllllllIIlIIIIIlIIIIIllll < llllllllllllllIIlIIIIIlIIIIIlllI.length; ++llllllllllllllIIlIIIIIlIIIIIllll) {
            makeDesc(llllllllllllllIIlIIIIIlIIIIIllII, llllllllllllllIIlIIIIIlIIIIIlllI[llllllllllllllIIlIIIIIlIIIIIllll]);
        }
        llllllllllllllIIlIIIIIlIIIIIllII.append(')');
        if (llllllllllllllIIlIIIIIlIIIIIllIl != null) {
            makeDesc(llllllllllllllIIlIIIIIlIIIIIllII, llllllllllllllIIlIIIIIlIIIIIllIl);
        }
        return llllllllllllllIIlIIIIIlIIIIIllII.toString();
    }
    
    public static void find2Methods(final Class<?> llllllllllllllIIlIIIIIlIlIIlllIl, final String llllllllllllllIIlIIIIIlIlIIlllII, final String llllllllllllllIIlIIIIIlIlIIllIll, final int llllllllllllllIIlIIIIIlIlIIllIlI, final String llllllllllllllIIlIIIIIlIlIIllIIl, final Method[] llllllllllllllIIlIIIIIlIlIIllllI) {
        llllllllllllllIIlIIIIIlIlIIllllI[llllllllllllllIIlIIIIIlIlIIllIlI + 1] = ((llllllllllllllIIlIIIIIlIlIIllIll == null) ? null : findMethod(llllllllllllllIIlIIIIIlIlIIlllIl, llllllllllllllIIlIIIIIlIlIIllIll, llllllllllllllIIlIIIIIlIlIIllIIl));
        llllllllllllllIIlIIIIIlIlIIllllI[llllllllllllllIIlIIIIIlIlIIllIlI] = findSuperClassMethod(llllllllllllllIIlIIIIIlIlIIlllIl, llllllllllllllIIlIIIIIlIlIIlllII, llllllllllllllIIlIIIIIlIlIIllIIl);
    }
    
    public static Method findSuperMethod(final Object llllllllllllllIIlIIIIIlIIllIIlIl, final String llllllllllllllIIlIIIIIlIIllIIlII, final String llllllllllllllIIlIIIIIlIIllIIIll) {
        final Class<?> llllllllllllllIIlIIIIIlIIllIIllI = llllllllllllllIIlIIIIIlIIllIIlIl.getClass();
        return findSuperClassMethod(llllllllllllllIIlIIIIIlIIllIIllI, llllllllllllllIIlIIIIIlIIllIIlII, llllllllllllllIIlIIIIIlIIllIIIll);
    }
    
    private static void error(final Class<?> llllllllllllllIIlIIIIIlIIlIlIIlI, final String llllllllllllllIIlIIIIIlIIlIlIIIl, final String llllllllllllllIIlIIIIIlIIlIlIIII) {
        throw new RuntimeException(String.valueOf(new StringBuilder().append("not found ").append(llllllllllllllIIlIIIIIlIIlIlIIIl).append(":").append(llllllllllllllIIlIIIIIlIIlIlIIII).append(" in ").append(llllllllllllllIIlIIIIIlIIlIlIIlI.getName())));
    }
    
    @Deprecated
    public static void find2Methods(final Object llllllllllllllIIlIIIIIlIlIIlIIIl, final String llllllllllllllIIlIIIIIlIlIIlIIII, final String llllllllllllllIIlIIIIIlIlIIIlIIl, final int llllllllllllllIIlIIIIIlIlIIIlllI, final String llllllllllllllIIlIIIIIlIlIIIIlll, final Method[] llllllllllllllIIlIIIIIlIlIIIIllI) {
        llllllllllllllIIlIIIIIlIlIIIIllI[llllllllllllllIIlIIIIIlIlIIIlllI + 1] = ((llllllllllllllIIlIIIIIlIlIIIlIIl == null) ? null : findMethod(llllllllllllllIIlIIIIIlIlIIlIIIl, llllllllllllllIIlIIIIIlIlIIIlIIl, llllllllllllllIIlIIIIIlIlIIIIlll));
        llllllllllllllIIlIIIIIlIlIIIIllI[llllllllllllllIIlIIIIIlIlIIIlllI] = findSuperMethod(llllllllllllllIIlIIIIIlIlIIlIIIl, llllllllllllllIIlIIIIIlIlIIlIIII, llllllllllllllIIlIIIIIlIlIIIIlll);
    }
    
    private static Method searchInterfaces(final Class<?> llllllllllllllIIlIIIIIlIIIllIllI, final String llllllllllllllIIlIIIIIlIIIllIIII, final String llllllllllllllIIlIIIIIlIIIllIlII) {
        Method llllllllllllllIIlIIIIIlIIIllIIll = null;
        final Class<?>[] llllllllllllllIIlIIIIIlIIIllIIlI = llllllllllllllIIlIIIIIlIIIllIllI.getInterfaces();
        for (int llllllllllllllIIlIIIIIlIIIllIlll = 0; llllllllllllllIIlIIIIIlIIIllIlll < llllllllllllllIIlIIIIIlIIIllIIlI.length; ++llllllllllllllIIlIIIIIlIIIllIlll) {
            llllllllllllllIIlIIIIIlIIIllIIll = findSuperMethod2(llllllllllllllIIlIIIIIlIIIllIIlI[llllllllllllllIIlIIIIIlIIIllIlll], llllllllllllllIIlIIIIIlIIIllIIII, llllllllllllllIIlIIIIIlIIIllIlII);
            if (llllllllllllllIIlIIIIIlIIIllIIll != null) {
                return llllllllllllllIIlIIIIIlIIIllIIll;
            }
        }
        return llllllllllllllIIlIIIIIlIIIllIIll;
    }
    
    private static Method findMethod2(final Class<?> llllllllllllllIIlIIIIIlIIIlIIlII, final String llllllllllllllIIlIIIIIlIIIIllllI, final String llllllllllllllIIlIIIIIlIIIIlllIl) {
        final Method[] llllllllllllllIIlIIIIIlIIIlIIIIl = SecurityActions.getDeclaredMethods(llllllllllllllIIlIIIIIlIIIlIIlII);
        for (int llllllllllllllIIlIIIIIlIIIlIIIII = llllllllllllllIIlIIIIIlIIIlIIIIl.length, llllllllllllllIIlIIIIIlIIIlIIlIl = 0; llllllllllllllIIlIIIIIlIIIlIIlIl < llllllllllllllIIlIIIIIlIIIlIIIII; ++llllllllllllllIIlIIIIIlIIIlIIlIl) {
            if (llllllllllllllIIlIIIIIlIIIlIIIIl[llllllllllllllIIlIIIIIlIIIlIIlIl].getName().equals(llllllllllllllIIlIIIIIlIIIIllllI) && makeDescriptor(llllllllllllllIIlIIIIIlIIIlIIIIl[llllllllllllllIIlIIIIIlIIIlIIlIl]).equals(llllllllllllllIIlIIIIIlIIIIlllIl)) {
                return llllllllllllllIIlIIIIIlIIIlIIIIl[llllllllllllllIIlIIIIIlIIIlIIlIl];
            }
        }
        return null;
    }
    
    private static void makeDesc(final StringBuffer llllllllllllllIIlIIIIIIllllllIlI, final Class<?> llllllllllllllIIlIIIIIIllllllIll) {
        if (llllllllllllllIIlIIIIIIllllllIll.isArray()) {
            llllllllllllllIIlIIIIIIllllllIlI.append('[');
            makeDesc(llllllllllllllIIlIIIIIIllllllIlI, llllllllllllllIIlIIIIIIllllllIll.getComponentType());
        }
        else if (llllllllllllllIIlIIIIIIllllllIll.isPrimitive()) {
            if (llllllllllllllIIlIIIIIIllllllIll == Void.TYPE) {
                llllllllllllllIIlIIIIIIllllllIlI.append('V');
            }
            else if (llllllllllllllIIlIIIIIIllllllIll == Integer.TYPE) {
                llllllllllllllIIlIIIIIIllllllIlI.append('I');
            }
            else if (llllllllllllllIIlIIIIIIllllllIll == Byte.TYPE) {
                llllllllllllllIIlIIIIIIllllllIlI.append('B');
            }
            else if (llllllllllllllIIlIIIIIIllllllIll == Long.TYPE) {
                llllllllllllllIIlIIIIIIllllllIlI.append('J');
            }
            else if (llllllllllllllIIlIIIIIIllllllIll == Double.TYPE) {
                llllllllllllllIIlIIIIIIllllllIlI.append('D');
            }
            else if (llllllllllllllIIlIIIIIIllllllIll == Float.TYPE) {
                llllllllllllllIIlIIIIIIllllllIlI.append('F');
            }
            else if (llllllllllllllIIlIIIIIIllllllIll == Character.TYPE) {
                llllllllllllllIIlIIIIIIllllllIlI.append('C');
            }
            else if (llllllllllllllIIlIIIIIIllllllIll == Short.TYPE) {
                llllllllllllllIIlIIIIIIllllllIlI.append('S');
            }
            else {
                if (llllllllllllllIIlIIIIIIllllllIll != Boolean.TYPE) {
                    throw new RuntimeException(String.valueOf(new StringBuilder().append("bad type: ").append(llllllllllllllIIlIIIIIIllllllIll.getName())));
                }
                llllllllllllllIIlIIIIIIllllllIlI.append('Z');
            }
        }
        else {
            llllllllllllllIIlIIIIIIllllllIlI.append('L').append(llllllllllllllIIlIIIIIIllllllIll.getName().replace('.', '/')).append(';');
        }
    }
    
    public static Method findMethod(final Class<?> llllllllllllllIIlIIIIIlIIlllIIIl, final String llllllllllllllIIlIIIIIlIIlllIlII, final String llllllllllllllIIlIIIIIlIIllIllll) {
        final Method llllllllllllllIIlIIIIIlIIlllIIlI = findMethod2(llllllllllllllIIlIIIIIlIIlllIIIl, llllllllllllllIIlIIIIIlIIlllIlII, llllllllllllllIIlIIIIIlIIllIllll);
        if (llllllllllllllIIlIIIIIlIIlllIIlI == null) {
            error(llllllllllllllIIlIIIIIlIIlllIIIl, llllllllllllllIIlIIIIIlIIlllIlII, llllllllllllllIIlIIIIIlIIllIllll);
        }
        return llllllllllllllIIlIIIIIlIIlllIIlI;
    }
    
    private static Method findSuperMethod2(final Class<?> llllllllllllllIIlIIIIIlIIlIIIlll, final String llllllllllllllIIlIIIIIlIIlIIIllI, final String llllllllllllllIIlIIIIIlIIlIIIlIl) {
        Method llllllllllllllIIlIIIIIlIIlIIIlII = findMethod2(llllllllllllllIIlIIIIIlIIlIIIlll, llllllllllllllIIlIIIIIlIIlIIIllI, llllllllllllllIIlIIIIIlIIlIIIlIl);
        if (llllllllllllllIIlIIIIIlIIlIIIlII != null) {
            return llllllllllllllIIlIIIIIlIIlIIIlII;
        }
        final Class<?> llllllllllllllIIlIIIIIlIIlIIIIll = llllllllllllllIIlIIIIIlIIlIIIlll.getSuperclass();
        if (llllllllllllllIIlIIIIIlIIlIIIIll != null) {
            llllllllllllllIIlIIIIIlIIlIIIlII = findSuperMethod2(llllllllllllllIIlIIIIIlIIlIIIIll, llllllllllllllIIlIIIIIlIIlIIIllI, llllllllllllllIIlIIIIIlIIlIIIlIl);
            if (llllllllllllllIIlIIIIIlIIlIIIlII != null) {
                return llllllllllllllIIlIIIIIlIIlIIIlII;
            }
        }
        return searchInterfaces(llllllllllllllIIlIIIIIlIIlIIIlll, llllllllllllllIIlIIIIIlIIlIIIllI, llllllllllllllIIlIIIIIlIIlIIIlIl);
    }
    
    public static Method findSuperClassMethod(final Class<?> llllllllllllllIIlIIIIIlIIlIllIIl, final String llllllllllllllIIlIIIIIlIIlIlllII, final String llllllllllllllIIlIIIIIlIIlIllIll) {
        Method llllllllllllllIIlIIIIIlIIlIllIlI = findSuperMethod2(llllllllllllllIIlIIIIIlIIlIllIIl.getSuperclass(), llllllllllllllIIlIIIIIlIIlIlllII, llllllllllllllIIlIIIIIlIIlIllIll);
        if (llllllllllllllIIlIIIIIlIIlIllIlI == null) {
            llllllllllllllIIlIIIIIlIIlIllIlI = searchInterfaces(llllllllllllllIIlIIIIIlIIlIllIIl, llllllllllllllIIlIIIIIlIIlIlllII, llllllllllllllIIlIIIIIlIIlIllIll);
        }
        if (llllllllllllllIIlIIIIIlIIlIllIlI == null) {
            error(llllllllllllllIIlIIIIIlIIlIllIIl, llllllllllllllIIlIIIIIlIIlIlllII, llllllllllllllIIlIIIIIlIIlIllIll);
        }
        return llllllllllllllIIlIIIIIlIIlIllIlI;
    }
    
    static class DefaultMethodHandler implements Serializable, MethodHandler
    {
        @Override
        public Object invoke(final Object llllllllllllIllllllllIIllIIlIlII, final Method llllllllllllIllllllllIIllIIlIlll, final Method llllllllllllIllllllllIIllIIlIllI, final Object[] llllllllllllIllllllllIIllIIlIIlI) throws Exception {
            return llllllllllllIllllllllIIllIIlIllI.invoke(llllllllllllIllllllllIIllIIlIlII, llllllllllllIllllllllIIllIIlIIlI);
        }
    }
}
