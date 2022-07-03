package com.viaversion.viaversion.libs.javassist.bytecode.annotation;

import java.lang.reflect.*;
import com.viaversion.viaversion.libs.javassist.*;
import com.viaversion.viaversion.libs.javassist.bytecode.*;

public class AnnotationImpl implements InvocationHandler
{
    private transient /* synthetic */ int cachedHashCode;
    private transient /* synthetic */ Class<?> annotationType;
    private /* synthetic */ ClassLoader classLoader;
    private static /* synthetic */ Method JDK_ANNOTATION_TYPE_METHOD;
    private /* synthetic */ Annotation annotation;
    private /* synthetic */ ClassPool pool;
    
    @Override
    public int hashCode() {
        if (this.cachedHashCode == Integer.MIN_VALUE) {
            int llllllllllllllIIllIlIIIIIllllIlI = 0;
            this.getAnnotationType();
            final Method[] llllllllllllllIIllIlIIIIIllllIIl = this.annotationType.getDeclaredMethods();
            for (int llllllllllllllIIllIlIIIIIllllIll = 0; llllllllllllllIIllIlIIIIIllllIll < llllllllllllllIIllIlIIIIIllllIIl.length; ++llllllllllllllIIllIlIIIIIllllIll) {
                final String llllllllllllllIIllIlIIIIIlllllll = llllllllllllllIIllIlIIIIIllllIIl[llllllllllllllIIllIlIIIIIllllIll].getName();
                int llllllllllllllIIllIlIIIIIllllllI = 0;
                final MemberValue llllllllllllllIIllIlIIIIIlllllIl = this.annotation.getMemberValue(llllllllllllllIIllIlIIIIIlllllll);
                Object llllllllllllllIIllIlIIIIIlllllII = null;
                try {
                    if (llllllllllllllIIllIlIIIIIlllllIl != null) {
                        llllllllllllllIIllIlIIIIIlllllII = llllllllllllllIIllIlIIIIIlllllIl.getValue(this.classLoader, this.pool, llllllllllllllIIllIlIIIIIllllIIl[llllllllllllllIIllIlIIIIIllllIll]);
                    }
                    if (llllllllllllllIIllIlIIIIIlllllII == null) {
                        llllllllllllllIIllIlIIIIIlllllII = this.getDefault(llllllllllllllIIllIlIIIIIlllllll, llllllllllllllIIllIlIIIIIllllIIl[llllllllllllllIIllIlIIIIIllllIll]);
                    }
                }
                catch (RuntimeException llllllllllllllIIllIlIIIIlIIIIIIl) {
                    throw llllllllllllllIIllIlIIIIlIIIIIIl;
                }
                catch (Exception llllllllllllllIIllIlIIIIlIIIIIII) {
                    throw new RuntimeException(String.valueOf(new StringBuilder().append("Error retrieving value ").append(llllllllllllllIIllIlIIIIIlllllll).append(" for annotation ").append(this.annotation.getTypeName())), llllllllllllllIIllIlIIIIlIIIIIII);
                }
                if (llllllllllllllIIllIlIIIIIlllllII != null) {
                    if (llllllllllllllIIllIlIIIIIlllllII.getClass().isArray()) {
                        llllllllllllllIIllIlIIIIIllllllI = arrayHashCode(llllllllllllllIIllIlIIIIIlllllII);
                    }
                    else {
                        llllllllllllllIIllIlIIIIIllllllI = llllllllllllllIIllIlIIIIIlllllII.hashCode();
                    }
                }
                llllllllllllllIIllIlIIIIIllllIlI += (127 * llllllllllllllIIllIlIIIIIlllllll.hashCode() ^ llllllllllllllIIllIlIIIIIllllllI);
            }
            this.cachedHashCode = llllllllllllllIIllIlIIIIIllllIlI;
        }
        return this.cachedHashCode;
    }
    
    @Override
    public Object invoke(final Object llllllllllllllIIllIlIIIIlIllIIII, final Method llllllllllllllIIllIlIIIIlIlIlIlI, final Object[] llllllllllllllIIllIlIIIIlIlIlIIl) throws Throwable {
        final String llllllllllllllIIllIlIIIIlIlIllIl = llllllllllllllIIllIlIIIIlIlIlIlI.getName();
        if (Object.class == llllllllllllllIIllIlIIIIlIlIlIlI.getDeclaringClass()) {
            if ("equals".equals(llllllllllllllIIllIlIIIIlIlIllIl)) {
                final Object llllllllllllllIIllIlIIIIlIllIIlI = llllllllllllllIIllIlIIIIlIlIlIIl[0];
                return this.checkEquals(llllllllllllllIIllIlIIIIlIllIIlI);
            }
            if ("toString".equals(llllllllllllllIIllIlIIIIlIlIllIl)) {
                return this.annotation.toString();
            }
            if ("hashCode".equals(llllllllllllllIIllIlIIIIlIlIllIl)) {
                return this.hashCode();
            }
        }
        else if ("annotationType".equals(llllllllllllllIIllIlIIIIlIlIllIl) && llllllllllllllIIllIlIIIIlIlIlIlI.getParameterTypes().length == 0) {
            return this.getAnnotationType();
        }
        final MemberValue llllllllllllllIIllIlIIIIlIlIllII = this.annotation.getMemberValue(llllllllllllllIIllIlIIIIlIlIllIl);
        if (llllllllllllllIIllIlIIIIlIlIllII == null) {
            return this.getDefault(llllllllllllllIIllIlIIIIlIlIllIl, llllllllllllllIIllIlIIIIlIlIlIlI);
        }
        return llllllllllllllIIllIlIIIIlIlIllII.getValue(this.classLoader, this.pool, llllllllllllllIIllIlIIIIlIlIlIlI);
    }
    
    private boolean checkEquals(final Object llllllllllllllIIllIlIIIIIlIllIlI) throws Exception {
        if (llllllllllllllIIllIlIIIIIlIllIlI == null) {
            return false;
        }
        if (llllllllllllllIIllIlIIIIIlIllIlI instanceof Proxy) {
            final InvocationHandler llllllllllllllIIllIlIIIIIllIIIll = Proxy.getInvocationHandler(llllllllllllllIIllIlIIIIIlIllIlI);
            if (llllllllllllllIIllIlIIIIIllIIIll instanceof AnnotationImpl) {
                final AnnotationImpl llllllllllllllIIllIlIIIIIllIIlII = (AnnotationImpl)llllllllllllllIIllIlIIIIIllIIIll;
                return this.annotation.equals(llllllllllllllIIllIlIIIIIllIIlII.annotation);
            }
        }
        final Class<?> llllllllllllllIIllIlIIIIIlIllIIl = (Class<?>)AnnotationImpl.JDK_ANNOTATION_TYPE_METHOD.invoke(llllllllllllllIIllIlIIIIIlIllIlI, new Object[0]);
        if (!this.getAnnotationType().equals(llllllllllllllIIllIlIIIIIlIllIIl)) {
            return false;
        }
        final Method[] llllllllllllllIIllIlIIIIIlIllIII = this.annotationType.getDeclaredMethods();
        for (int llllllllllllllIIllIlIIIIIlIlllII = 0; llllllllllllllIIllIlIIIIIlIlllII < llllllllllllllIIllIlIIIIIlIllIII.length; ++llllllllllllllIIllIlIIIIIlIlllII) {
            final String llllllllllllllIIllIlIIIIIllIIIII = llllllllllllllIIllIlIIIIIlIllIII[llllllllllllllIIllIlIIIIIlIlllII].getName();
            final MemberValue llllllllllllllIIllIlIIIIIlIlllll = this.annotation.getMemberValue(llllllllllllllIIllIlIIIIIllIIIII);
            Object llllllllllllllIIllIlIIIIIlIllllI = null;
            Object llllllllllllllIIllIlIIIIIlIlllIl = null;
            try {
                if (llllllllllllllIIllIlIIIIIlIlllll != null) {
                    llllllllllllllIIllIlIIIIIlIllllI = llllllllllllllIIllIlIIIIIlIlllll.getValue(this.classLoader, this.pool, llllllllllllllIIllIlIIIIIlIllIII[llllllllllllllIIllIlIIIIIlIlllII]);
                }
                if (llllllllllllllIIllIlIIIIIlIllllI == null) {
                    llllllllllllllIIllIlIIIIIlIllllI = this.getDefault(llllllllllllllIIllIlIIIIIllIIIII, llllllllllllllIIllIlIIIIIlIllIII[llllllllllllllIIllIlIIIIIlIlllII]);
                }
                llllllllllllllIIllIlIIIIIlIlllIl = llllllllllllllIIllIlIIIIIlIllIII[llllllllllllllIIllIlIIIIIlIlllII].invoke(llllllllllllllIIllIlIIIIIlIllIlI, new Object[0]);
            }
            catch (RuntimeException llllllllllllllIIllIlIIIIIllIIIlI) {
                throw llllllllllllllIIllIlIIIIIllIIIlI;
            }
            catch (Exception llllllllllllllIIllIlIIIIIllIIIIl) {
                throw new RuntimeException(String.valueOf(new StringBuilder().append("Error retrieving value ").append(llllllllllllllIIllIlIIIIIllIIIII).append(" for annotation ").append(this.annotation.getTypeName())), llllllllllllllIIllIlIIIIIllIIIIl);
            }
            if (llllllllllllllIIllIlIIIIIlIllllI == null && llllllllllllllIIllIlIIIIIlIlllIl != null) {
                return false;
            }
            if (llllllllllllllIIllIlIIIIIlIllllI != null && !llllllllllllllIIllIlIIIIIlIllllI.equals(llllllllllllllIIllIlIIIIIlIlllIl)) {
                return false;
            }
        }
        return true;
    }
    
    private Object getDefault(final String llllllllllllllIIllIlIIIIlIIlIIlI, final Method llllllllllllllIIllIlIIIIlIIlIlIl) throws RuntimeException, ClassNotFoundException {
        final String llllllllllllllIIllIlIIIIlIIlIlII = this.annotation.getTypeName();
        if (this.pool != null) {
            try {
                final CtClass llllllllllllllIIllIlIIIIlIIllIll = this.pool.get(llllllllllllllIIllIlIIIIlIIlIlII);
                final ClassFile llllllllllllllIIllIlIIIIlIIllIlI = llllllllllllllIIllIlIIIIlIIllIll.getClassFile2();
                final MethodInfo llllllllllllllIIllIlIIIIlIIllIIl = llllllllllllllIIllIlIIIIlIIllIlI.getMethod(llllllllllllllIIllIlIIIIlIIlIIlI);
                if (llllllllllllllIIllIlIIIIlIIllIIl != null) {
                    final AnnotationDefaultAttribute llllllllllllllIIllIlIIIIlIIlllII = (AnnotationDefaultAttribute)llllllllllllllIIllIlIIIIlIIllIIl.getAttribute("AnnotationDefault");
                    if (llllllllllllllIIllIlIIIIlIIlllII != null) {
                        final MemberValue llllllllllllllIIllIlIIIIlIIlllIl = llllllllllllllIIllIlIIIIlIIlllII.getDefaultValue();
                        return llllllllllllllIIllIlIIIIlIIlllIl.getValue(this.classLoader, this.pool, llllllllllllllIIllIlIIIIlIIlIlIl);
                    }
                }
            }
            catch (NotFoundException llllllllllllllIIllIlIIIIlIIllIII) {
                throw new RuntimeException(String.valueOf(new StringBuilder().append("cannot find a class file: ").append(llllllllllllllIIllIlIIIIlIIlIlII)));
            }
        }
        throw new RuntimeException(String.valueOf(new StringBuilder().append("no default value: ").append(llllllllllllllIIllIlIIIIlIIlIlII).append(".").append(llllllllllllllIIllIlIIIIlIIlIIlI).append("()")));
    }
    
    public static Object make(final ClassLoader llllllllllllllIIllIlIIIIllIllIlI, final Class<?> llllllllllllllIIllIlIIIIllIllIIl, final ClassPool llllllllllllllIIllIlIIIIllIlllIl, final Annotation llllllllllllllIIllIlIIIIllIlIlll) throws IllegalArgumentException {
        final AnnotationImpl llllllllllllllIIllIlIIIIllIllIll = new AnnotationImpl(llllllllllllllIIllIlIIIIllIlIlll, llllllllllllllIIllIlIIIIllIlllIl, llllllllllllllIIllIlIIIIllIllIlI);
        return Proxy.newProxyInstance(llllllllllllllIIllIlIIIIllIllIlI, new Class[] { llllllllllllllIIllIlIIIIllIllIIl }, llllllllllllllIIllIlIIIIllIllIll);
    }
    
    private static int arrayHashCode(final Object llllllllllllllIIllIIllllllllIlII) {
        if (llllllllllllllIIllIIllllllllIlII == null) {
            return 0;
        }
        int llllllllllllllIIllIIllllllllIIlI = 1;
        final Object[] llllllllllllllIIllIIllllllllIIII = (Object[])llllllllllllllIIllIIllllllllIlII;
        for (int llllllllllllllIIllIIllllllllIllI = 0; llllllllllllllIIllIIllllllllIllI < llllllllllllllIIllIIllllllllIIII.length; ++llllllllllllllIIllIIllllllllIllI) {
            int llllllllllllllIIllIIlllllllllIII = 0;
            if (llllllllllllllIIllIIllllllllIIII[llllllllllllllIIllIIllllllllIllI] != null) {
                llllllllllllllIIllIIlllllllllIII = llllllllllllllIIllIIllllllllIIII[llllllllllllllIIllIIllllllllIllI].hashCode();
            }
            llllllllllllllIIllIIllllllllIIlI = 31 * llllllllllllllIIllIIllllllllIIlI + llllllllllllllIIllIIlllllllllIII;
        }
        return llllllllllllllIIllIIllllllllIIlI;
    }
    
    public String getTypeName() {
        return this.annotation.getTypeName();
    }
    
    static {
        JDK_ANNOTATION_CLASS_NAME = "java.lang.annotation.Annotation";
        AnnotationImpl.JDK_ANNOTATION_TYPE_METHOD = null;
        try {
            final Class<?> llllllllllllllIIllIIllllllIlllII = Class.forName("java.lang.annotation.Annotation");
            AnnotationImpl.JDK_ANNOTATION_TYPE_METHOD = llllllllllllllIIllIIllllllIlllII.getMethod("annotationType", (Class<?>[])null);
        }
        catch (Exception ex) {}
    }
    
    private AnnotationImpl(final Annotation llllllllllllllIIllIlIIIIllIlIIII, final ClassPool llllllllllllllIIllIlIIIIllIIlIll, final ClassLoader llllllllllllllIIllIlIIIIllIIlIlI) {
        this.cachedHashCode = Integer.MIN_VALUE;
        this.annotation = llllllllllllllIIllIlIIIIllIlIIII;
        this.pool = llllllllllllllIIllIlIIIIllIIlIll;
        this.classLoader = llllllllllllllIIllIlIIIIllIIlIlI;
    }
    
    private Class<?> getAnnotationType() {
        if (this.annotationType == null) {
            final String llllllllllllllIIllIlIIIIllIIIIII = this.annotation.getTypeName();
            try {
                this.annotationType = this.classLoader.loadClass(llllllllllllllIIllIlIIIIllIIIIII);
            }
            catch (ClassNotFoundException llllllllllllllIIllIlIIIIllIIIIIl) {
                final NoClassDefFoundError llllllllllllllIIllIlIIIIllIIIIlI = new NoClassDefFoundError(String.valueOf(new StringBuilder().append("Error loading annotation class: ").append(llllllllllllllIIllIlIIIIllIIIIII)));
                llllllllllllllIIllIlIIIIllIIIIlI.setStackTrace(llllllllllllllIIllIlIIIIllIIIIIl.getStackTrace());
                throw llllllllllllllIIllIlIIIIllIIIIlI;
            }
        }
        return this.annotationType;
    }
    
    public Annotation getAnnotation() {
        return this.annotation;
    }
}
