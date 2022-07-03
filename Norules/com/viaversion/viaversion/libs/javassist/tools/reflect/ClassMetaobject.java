package com.viaversion.viaversion.libs.javassist.tools.reflect;

import java.util.*;
import java.lang.reflect.*;
import java.io.*;

public class ClassMetaobject implements Serializable
{
    private /* synthetic */ Class<?> javaClass;
    public static /* synthetic */ boolean useContextClassLoader;
    private /* synthetic */ Method[] methods;
    private /* synthetic */ Constructor<?>[] constructors;
    
    public final int getMethodIndex(final String llllllllllllllIIlllIlllIIIIllllI, final Class<?>[] llllllllllllllIIlllIlllIIIIllIIl) throws NoSuchMethodException {
        final Method[] llllllllllllllIIlllIlllIIIIlllII = this.getReflectiveMethods();
        for (int llllllllllllllIIlllIlllIIIlIIIII = 0; llllllllllllllIIlllIlllIIIlIIIII < llllllllllllllIIlllIlllIIIIlllII.length; ++llllllllllllllIIlllIlllIIIlIIIII) {
            if (llllllllllllllIIlllIlllIIIIlllII[llllllllllllllIIlllIlllIIIlIIIII] != null) {
                if (this.getMethodName(llllllllllllllIIlllIlllIIIlIIIII).equals(llllllllllllllIIlllIlllIIIIllllI) && Arrays.equals(llllllllllllllIIlllIlllIIIIllIIl, llllllllllllllIIlllIlllIIIIlllII[llllllllllllllIIlllIlllIIIlIIIII].getParameterTypes())) {
                    return llllllllllllllIIlllIlllIIIlIIIII;
                }
            }
        }
        throw new NoSuchMethodException(String.valueOf(new StringBuilder().append("Method ").append(llllllllllllllIIlllIlllIIIIllllI).append(" not found")));
    }
    
    static {
        methodPrefix = "_m_";
        methodPrefixLen = 3;
        ClassMetaobject.useContextClassLoader = false;
    }
    
    public final Class<?> getReturnType(final int llllllllllllllIIlllIlllIIIlIlIll) {
        return this.getReflectiveMethods()[llllllllllllllIIlllIlllIIIlIlIll].getReturnType();
    }
    
    public Object trapMethodcall(final int llllllllllllllIIlllIlllIIlllIIll, final Object[] llllllllllllllIIlllIlllIIlllIIlI) throws Throwable {
        try {
            final Method[] llllllllllllllIIlllIlllIIllllIlI = this.getReflectiveMethods();
            return llllllllllllllIIlllIlllIIllllIlI[llllllllllllllIIlllIlllIIlllIIll].invoke(null, llllllllllllllIIlllIlllIIlllIIlI);
        }
        catch (InvocationTargetException llllllllllllllIIlllIlllIIllllIIl) {
            throw llllllllllllllIIlllIlllIIllllIIl.getTargetException();
        }
        catch (IllegalAccessException llllllllllllllIIlllIlllIIllllIII) {
            throw new CannotInvokeException(llllllllllllllIIlllIlllIIllllIII);
        }
    }
    
    public final Method getMethod(final int llllllllllllllIIlllIlllIIlIIIllI) {
        return this.getReflectiveMethods()[llllllllllllllIIlllIlllIIlIIIllI];
    }
    
    public final String getName() {
        return this.javaClass.getName();
    }
    
    public final Class<?> getJavaClass() {
        return this.javaClass;
    }
    
    public static Object invoke(final Object llllllllllllllIIlllIlllIlIIIIllI, final int llllllllllllllIIlllIlllIlIIIIlIl, final Object[] llllllllllllllIIlllIlllIlIIIIlII) throws Throwable {
        final Method[] llllllllllllllIIlllIlllIlIIIlIIl = llllllllllllllIIlllIlllIlIIIIllI.getClass().getMethods();
        final int llllllllllllllIIlllIlllIlIIIlIII = llllllllllllllIIlllIlllIlIIIlIIl.length;
        final String llllllllllllllIIlllIlllIlIIIIlll = String.valueOf(new StringBuilder().append("_m_").append(llllllllllllllIIlllIlllIlIIIIlIl));
        for (int llllllllllllllIIlllIlllIlIIIllIl = 0; llllllllllllllIIlllIlllIlIIIllIl < llllllllllllllIIlllIlllIlIIIlIII; ++llllllllllllllIIlllIlllIlIIIllIl) {
            if (llllllllllllllIIlllIlllIlIIIlIIl[llllllllllllllIIlllIlllIlIIIllIl].getName().startsWith(llllllllllllllIIlllIlllIlIIIIlll)) {
                try {
                    return llllllllllllllIIlllIlllIlIIIlIIl[llllllllllllllIIlllIlllIlIIIllIl].invoke(llllllllllllllIIlllIlllIlIIIIllI, llllllllllllllIIlllIlllIlIIIIlII);
                }
                catch (InvocationTargetException llllllllllllllIIlllIlllIlIIIllll) {
                    throw llllllllllllllIIlllIlllIlIIIllll.getTargetException();
                }
                catch (IllegalAccessException llllllllllllllIIlllIlllIlIIIlllI) {
                    throw new CannotInvokeException(llllllllllllllIIlllIlllIlIIIlllI);
                }
            }
        }
        throw new CannotInvokeException("cannot find a method");
    }
    
    public final Method[] getReflectiveMethods() {
        if (this.methods != null) {
            return this.methods;
        }
        final Class<?> llllllllllllllIIlllIlllIIlIlllII = this.getJavaClass();
        final Method[] llllllllllllllIIlllIlllIIlIllIll = llllllllllllllIIlllIlllIIlIlllII.getDeclaredMethods();
        final int llllllllllllllIIlllIlllIIlIllIlI = llllllllllllllIIlllIlllIIlIllIll.length;
        final int[] llllllllllllllIIlllIlllIIlIllIIl = new int[llllllllllllllIIlllIlllIIlIllIlI];
        int llllllllllllllIIlllIlllIIlIllIII = 0;
        for (int llllllllllllllIIlllIlllIIlIlllll = 0; llllllllllllllIIlllIlllIIlIlllll < llllllllllllllIIlllIlllIIlIllIlI; ++llllllllllllllIIlllIlllIIlIlllll) {
            final Method llllllllllllllIIlllIlllIIllIIIIl = llllllllllllllIIlllIlllIIlIllIll[llllllllllllllIIlllIlllIIlIlllll];
            final String llllllllllllllIIlllIlllIIllIIIII = llllllllllllllIIlllIlllIIllIIIIl.getName();
            if (llllllllllllllIIlllIlllIIllIIIII.startsWith("_m_")) {
                int llllllllllllllIIlllIlllIIllIIIlI = 0;
                int llllllllllllllIIlllIlllIIllIIIll = 3;
                while (true) {
                    final char llllllllllllllIIlllIlllIIllIIlII = llllllllllllllIIlllIlllIIllIIIII.charAt(llllllllllllllIIlllIlllIIllIIIll);
                    if ('0' > llllllllllllllIIlllIlllIIllIIlII || llllllllllllllIIlllIlllIIllIIlII > '9') {
                        break;
                    }
                    llllllllllllllIIlllIlllIIllIIIlI = llllllllllllllIIlllIlllIIllIIIlI * 10 + llllllllllllllIIlllIlllIIllIIlII - 48;
                    ++llllllllllllllIIlllIlllIIllIIIll;
                }
                llllllllllllllIIlllIlllIIlIllIIl[llllllllllllllIIlllIlllIIlIlllll] = ++llllllllllllllIIlllIlllIIllIIIlI;
                if (llllllllllllllIIlllIlllIIllIIIlI > llllllllllllllIIlllIlllIIlIllIII) {
                    llllllllllllllIIlllIlllIIlIllIII = llllllllllllllIIlllIlllIIllIIIlI;
                }
            }
        }
        this.methods = new Method[llllllllllllllIIlllIlllIIlIllIII];
        for (int llllllllllllllIIlllIlllIIlIllllI = 0; llllllllllllllIIlllIlllIIlIllllI < llllllllllllllIIlllIlllIIlIllIlI; ++llllllllllllllIIlllIlllIIlIllllI) {
            if (llllllllllllllIIlllIlllIIlIllIIl[llllllllllllllIIlllIlllIIlIllllI] > 0) {
                this.methods[llllllllllllllIIlllIlllIIlIllIIl[llllllllllllllIIlllIlllIIlIllllI] - 1] = llllllllllllllIIlllIlllIIlIllIll[llllllllllllllIIlllIlllIIlIllllI];
            }
        }
        return this.methods;
    }
    
    public final String getMethodName(final int llllllllllllllIIlllIlllIIIlllllI) {
        final String llllllllllllllIIlllIlllIIIllllIl = this.getReflectiveMethods()[llllllllllllllIIlllIlllIIIlllllI].getName();
        int llllllllllllllIIlllIlllIIIllllII = 3;
        char llllllllllllllIIlllIlllIIlIIIIII;
        do {
            llllllllllllllIIlllIlllIIlIIIIII = llllllllllllllIIlllIlllIIIllllIl.charAt(llllllllllllllIIlllIlllIIIllllII++);
        } while (llllllllllllllIIlllIlllIIlIIIIII >= '0' && '9' >= llllllllllllllIIlllIlllIIlIIIIII);
        return llllllllllllllIIlllIlllIIIllllIl.substring(llllllllllllllIIlllIlllIIIllllII);
    }
    
    public ClassMetaobject(final String[] llllllllllllllIIlllIlllIlllIIIll) {
        try {
            this.javaClass = this.getClassObject(llllllllllllllIIlllIlllIlllIIIll[0]);
        }
        catch (ClassNotFoundException llllllllllllllIIlllIlllIlllIIlll) {
            throw new RuntimeException(String.valueOf(new StringBuilder().append("not found: ").append(llllllllllllllIIlllIlllIlllIIIll[0]).append(", useContextClassLoader: ").append(Boolean.toString(ClassMetaobject.useContextClassLoader))), llllllllllllllIIlllIlllIlllIIlll);
        }
        this.constructors = this.javaClass.getConstructors();
        this.methods = null;
    }
    
    public Object trapFieldRead(final String llllllllllllllIIlllIlllIlIlIllIl) {
        final Class<?> llllllllllllllIIlllIlllIlIlIllII = this.getJavaClass();
        try {
            return llllllllllllllIIlllIlllIlIlIllII.getField(llllllllllllllIIlllIlllIlIlIllIl).get(null);
        }
        catch (NoSuchFieldException llllllllllllllIIlllIlllIlIllIIII) {
            throw new RuntimeException(llllllllllllllIIlllIlllIlIllIIII.toString());
        }
        catch (IllegalAccessException llllllllllllllIIlllIlllIlIlIllll) {
            throw new RuntimeException(llllllllllllllIIlllIlllIlIlIllll.toString());
        }
    }
    
    private void readObject(final ObjectInputStream llllllllllllllIIlllIlllIllIllIII) throws ClassNotFoundException, IOException {
        this.javaClass = this.getClassObject(llllllllllllllIIlllIlllIllIllIII.readUTF());
        this.constructors = this.javaClass.getConstructors();
        this.methods = null;
    }
    
    private void writeObject(final ObjectOutputStream llllllllllllllIIlllIlllIllIlllII) throws IOException {
        llllllllllllllIIlllIlllIllIlllII.writeUTF(this.javaClass.getName());
    }
    
    public final Object newInstance(final Object[] llllllllllllllIIlllIlllIlIlllIII) throws CannotCreateException {
        for (int llllllllllllllIIlllIlllIlIlllIlI = this.constructors.length, llllllllllllllIIlllIlllIlIllllIl = 0; llllllllllllllIIlllIlllIlIllllIl < llllllllllllllIIlllIlllIlIlllIlI; ++llllllllllllllIIlllIlllIlIllllIl) {
            try {
                return this.constructors[llllllllllllllIIlllIlllIlIllllIl].newInstance(llllllllllllllIIlllIlllIlIlllIII);
            }
            catch (IllegalArgumentException ex) {}
            catch (InstantiationException llllllllllllllIIlllIlllIllIIIIII) {
                throw new CannotCreateException(llllllllllllllIIlllIlllIllIIIIII);
            }
            catch (IllegalAccessException llllllllllllllIIlllIlllIlIllllll) {
                throw new CannotCreateException(llllllllllllllIIlllIlllIlIllllll);
            }
            catch (InvocationTargetException llllllllllllllIIlllIlllIlIlllllI) {
                throw new CannotCreateException(llllllllllllllIIlllIlllIlIlllllI);
            }
        }
        throw new CannotCreateException("no constructor matches");
    }
    
    public final Class<?>[] getParameterTypes(final int llllllllllllllIIlllIlllIIIllIIll) {
        return this.getReflectiveMethods()[llllllllllllllIIlllIlllIIIllIIll].getParameterTypes();
    }
    
    private Class<?> getClassObject(final String llllllllllllllIIlllIlllIllIlIIlI) throws ClassNotFoundException {
        if (ClassMetaobject.useContextClassLoader) {
            return Thread.currentThread().getContextClassLoader().loadClass(llllllllllllllIIlllIlllIllIlIIlI);
        }
        return Class.forName(llllllllllllllIIlllIlllIllIlIIlI);
    }
    
    public void trapFieldWrite(final String llllllllllllllIIlllIlllIlIIllIll, final Object llllllllllllllIIlllIlllIlIIllllI) {
        final Class<?> llllllllllllllIIlllIlllIlIIlllIl = this.getJavaClass();
        try {
            llllllllllllllIIlllIlllIlIIlllIl.getField(llllllllllllllIIlllIlllIlIIllIll).set(null, llllllllllllllIIlllIlllIlIIllllI);
        }
        catch (NoSuchFieldException llllllllllllllIIlllIlllIlIlIIIlI) {
            throw new RuntimeException(llllllllllllllIIlllIlllIlIlIIIlI.toString());
        }
        catch (IllegalAccessException llllllllllllllIIlllIlllIlIlIIIIl) {
            throw new RuntimeException(llllllllllllllIIlllIlllIlIlIIIIl.toString());
        }
    }
    
    public final boolean isInstance(final Object llllllllllllllIIlllIlllIllIIlIII) {
        return this.javaClass.isInstance(llllllllllllllIIlllIlllIllIIlIII);
    }
}
