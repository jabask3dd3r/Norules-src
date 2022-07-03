package com.viaversion.viaversion.libs.javassist.util.proxy;

import java.lang.reflect.*;
import java.io.*;
import java.security.*;

class SerializedProxy implements Serializable
{
    private /* synthetic */ MethodHandler handler;
    private /* synthetic */ String superClass;
    private /* synthetic */ byte[] filterSignature;
    private /* synthetic */ String[] interfaces;
    
    SerializedProxy(final Class<?> lllllllllllllIIlIIIlIIIlIIlIIlll, final byte[] lllllllllllllIIlIIIlIIIlIIlIlllI, final MethodHandler lllllllllllllIIlIIIlIIIlIIlIIlIl) {
        this.filterSignature = lllllllllllllIIlIIIlIIIlIIlIlllI;
        this.handler = lllllllllllllIIlIIIlIIIlIIlIIlIl;
        this.superClass = lllllllllllllIIlIIIlIIIlIIlIIlll.getSuperclass().getName();
        final Class<?>[] lllllllllllllIIlIIIlIIIlIIlIllII = lllllllllllllIIlIIIlIIIlIIlIIlll.getInterfaces();
        final int lllllllllllllIIlIIIlIIIlIIlIlIll = lllllllllllllIIlIIIlIIIlIIlIllII.length;
        this.interfaces = new String[lllllllllllllIIlIIIlIIIlIIlIlIll - 1];
        final String lllllllllllllIIlIIIlIIIlIIlIlIlI = ProxyObject.class.getName();
        final String lllllllllllllIIlIIIlIIIlIIlIlIIl = Proxy.class.getName();
        for (int lllllllllllllIIlIIIlIIIlIIllIIIl = 0; lllllllllllllIIlIIIlIIIlIIllIIIl < lllllllllllllIIlIIIlIIIlIIlIlIll; ++lllllllllllllIIlIIIlIIIlIIllIIIl) {
            final String lllllllllllllIIlIIIlIIIlIIllIIlI = lllllllllllllIIlIIIlIIIlIIlIllII[lllllllllllllIIlIIIlIIIlIIllIIIl].getName();
            if (!lllllllllllllIIlIIIlIIIlIIllIIlI.equals(lllllllllllllIIlIIIlIIIlIIlIlIlI) && !lllllllllllllIIlIIIlIIIlIIllIIlI.equals(lllllllllllllIIlIIIlIIIlIIlIlIIl)) {
                this.interfaces[lllllllllllllIIlIIIlIIIlIIllIIIl] = lllllllllllllIIlIIIlIIIlIIllIIlI;
            }
        }
    }
    
    Object readResolve() throws ObjectStreamException {
        try {
            final int lllllllllllllIIlIIIlIIIlIIIIllll = this.interfaces.length;
            final Class<?>[] lllllllllllllIIlIIIlIIIlIIIIlllI = (Class<?>[])new Class[lllllllllllllIIlIIIlIIIlIIIIllll];
            for (int lllllllllllllIIlIIIlIIIlIIIlIIII = 0; lllllllllllllIIlIIIlIIIlIIIlIIII < lllllllllllllIIlIIIlIIIlIIIIllll; ++lllllllllllllIIlIIIlIIIlIIIlIIII) {
                lllllllllllllIIlIIIlIIIlIIIIlllI[lllllllllllllIIlIIIlIIIlIIIlIIII] = this.loadClass(this.interfaces[lllllllllllllIIlIIIlIIIlIIIlIIII]);
            }
            final ProxyFactory lllllllllllllIIlIIIlIIIlIIIIllIl = new ProxyFactory();
            lllllllllllllIIlIIIlIIIlIIIIllIl.setSuperclass(this.loadClass(this.superClass));
            lllllllllllllIIlIIIlIIIlIIIIllIl.setInterfaces(lllllllllllllIIlIIIlIIIlIIIIlllI);
            final Proxy lllllllllllllIIlIIIlIIIlIIIIllII = (Proxy)lllllllllllllIIlIIIlIIIlIIIIllIl.createClass(this.filterSignature).getConstructor((Class<?>[])new Class[0]).newInstance(new Object[0]);
            lllllllllllllIIlIIIlIIIlIIIIllII.setHandler(this.handler);
            return lllllllllllllIIlIIIlIIIlIIIIllII;
        }
        catch (NoSuchMethodException lllllllllllllIIlIIIlIIIlIIIIlIll) {
            throw new InvalidClassException(lllllllllllllIIlIIIlIIIlIIIIlIll.getMessage());
        }
        catch (InvocationTargetException lllllllllllllIIlIIIlIIIlIIIIlIlI) {
            throw new InvalidClassException(lllllllllllllIIlIIIlIIIlIIIIlIlI.getMessage());
        }
        catch (ClassNotFoundException lllllllllllllIIlIIIlIIIlIIIIlIIl) {
            throw new InvalidClassException(lllllllllllllIIlIIIlIIIlIIIIlIIl.getMessage());
        }
        catch (InstantiationException lllllllllllllIIlIIIlIIIlIIIIlIII) {
            throw new InvalidObjectException(lllllllllllllIIlIIIlIIIlIIIIlIII.getMessage());
        }
        catch (IllegalAccessException lllllllllllllIIlIIIlIIIlIIIIIlll) {
            throw new InvalidClassException(lllllllllllllIIlIIIlIIIlIIIIIlll.getMessage());
        }
    }
    
    protected Class<?> loadClass(final String lllllllllllllIIlIIIlIIIlIIIlIlll) throws ClassNotFoundException {
        try {
            return AccessController.doPrivileged((PrivilegedExceptionAction<Class<?>>)new PrivilegedExceptionAction<Class<?>>() {
                @Override
                public Class<?> run() throws Exception {
                    final ClassLoader lllllllllllllllIIIIIlIIIIlIIIlIl = Thread.currentThread().getContextClassLoader();
                    return Class.forName(lllllllllllllIIlIIIlIIIlIIIlIlll, true, lllllllllllllllIIIIIlIIIIlIIIlIl);
                }
            });
        }
        catch (PrivilegedActionException lllllllllllllIIlIIIlIIIlIIIllIll) {
            throw new RuntimeException(String.valueOf(new StringBuilder().append("cannot load the class: ").append(lllllllllllllIIlIIIlIIIlIIIlIlll)), lllllllllllllIIlIIIlIIIlIIIllIll.getException());
        }
    }
}
