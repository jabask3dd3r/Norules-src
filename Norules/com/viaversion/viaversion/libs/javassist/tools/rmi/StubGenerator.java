package com.viaversion.viaversion.libs.javassist.tools.rmi;

import com.viaversion.viaversion.libs.javassist.*;
import java.lang.reflect.*;
import java.util.*;

public class StubGenerator implements Translator
{
    private /* synthetic */ CtClass[] exceptionForProxy;
    private /* synthetic */ CtMethod forwardStaticMethod;
    private /* synthetic */ ClassPool classPool;
    private /* synthetic */ CtClass[] interfacesForProxy;
    private /* synthetic */ CtMethod forwardMethod;
    private /* synthetic */ CtClass[] proxyConstructorParamTypes;
    private /* synthetic */ Map<String, CtClass> proxyClasses;
    
    private CtClass toCtClass(Class<?> lllllllllllllIIIIIllIIIlIlIlIIIl) throws NotFoundException {
        String lllllllllllllIIIIIllIIIlIlIlIIII = null;
        if (!lllllllllllllIIIIIllIIIlIlIlIIIl.isArray()) {
            final String lllllllllllllIIIIIllIIIlIlIlIlII = lllllllllllllIIIIIllIIIlIlIlIIIl.getName();
        }
        else {
            final StringBuffer lllllllllllllIIIIIllIIIlIlIlIIll = new StringBuffer();
            do {
                lllllllllllllIIIIIllIIIlIlIlIIll.append("[]");
                lllllllllllllIIIIIllIIIlIlIlIIIl = lllllllllllllIIIIIllIIIlIlIlIIIl.getComponentType();
            } while (lllllllllllllIIIIIllIIIlIlIlIIIl.isArray());
            lllllllllllllIIIIIllIIIlIlIlIIll.insert(0, lllllllllllllIIIIIllIIIlIlIlIIIl.getName());
            lllllllllllllIIIIIllIIIlIlIlIIII = lllllllllllllIIIIIllIIIlIlIlIIll.toString();
        }
        return this.classPool.get(lllllllllllllIIIIIllIIIlIlIlIIII);
    }
    
    static {
        accessorObjectId = "_getObjectId";
        fieldObjectId = "objectId";
        fieldImporter = "importer";
        sampleClass = "com.viaversion.viaversion.libs.javassist.tools.rmi.Sample";
    }
    
    public boolean isProxyClass(final String lllllllllllllIIIIIllIIIlIlllllIl) {
        return this.proxyClasses.get(lllllllllllllIIIIIllIIIlIlllllIl) != null;
    }
    
    private void modifySuperclass(CtClass lllllllllllllIIIIIllIIIlIIIlllIl) throws NotFoundException, CannotCompileException {
        while (true) {
            final CtClass lllllllllllllIIIIIllIIIlIIIllllI = ((CtClass)lllllllllllllIIIIIllIIIlIIIlllIl).getSuperclass();
            if (lllllllllllllIIIIIllIIIlIIIllllI == null) {
                break;
            }
            try {
                lllllllllllllIIIIIllIIIlIIIllllI.getDeclaredConstructor(null);
            }
            catch (NotFoundException lllllllllllllIIIIIllIIIlIIIllIll) {
                lllllllllllllIIIIIllIIIlIIIllllI.addConstructor(CtNewConstructor.defaultConstructor(lllllllllllllIIIIIllIIIlIIIllllI));
                lllllllllllllIIIIIllIIIlIIIlllIl = lllllllllllllIIIIIllIIIlIIIllllI;
                continue;
            }
            break;
        }
    }
    
    @Override
    public void start(final ClassPool lllllllllllllIIIIIllIIIllIIIIlll) throws NotFoundException {
        this.classPool = lllllllllllllIIIIIllIIIllIIIIlll;
        final CtClass lllllllllllllIIIIIllIIIllIIIlIIl = lllllllllllllIIIIIllIIIllIIIIlll.get("com.viaversion.viaversion.libs.javassist.tools.rmi.Sample");
        this.forwardMethod = lllllllllllllIIIIIllIIIllIIIlIIl.getDeclaredMethod("forward");
        this.forwardStaticMethod = lllllllllllllIIIIIllIIIllIIIlIIl.getDeclaredMethod("forwardStatic");
        this.proxyConstructorParamTypes = lllllllllllllIIIIIllIIIllIIIIlll.get(new String[] { "com.viaversion.viaversion.libs.javassist.tools.rmi.ObjectImporter", "int" });
        this.interfacesForProxy = lllllllllllllIIIIIllIIIllIIIIlll.get(new String[] { "java.io.Serializable", "com.viaversion.viaversion.libs.javassist.tools.rmi.Proxy" });
        this.exceptionForProxy = new CtClass[] { lllllllllllllIIIIIllIIIllIIIIlll.get("com.viaversion.viaversion.libs.javassist.tools.rmi.RemoteException") };
    }
    
    private CtClass[] toCtClass(final Class<?>[] lllllllllllllIIIIIllIIIlIlIIIlII) throws NotFoundException {
        final int lllllllllllllIIIIIllIIIlIlIIIIll = lllllllllllllIIIIIllIIIlIlIIIlII.length;
        final CtClass[] lllllllllllllIIIIIllIIIlIlIIIIlI = new CtClass[lllllllllllllIIIIIllIIIlIlIIIIll];
        for (int lllllllllllllIIIIIllIIIlIlIIIllI = 0; lllllllllllllIIIIIllIIIlIlIIIllI < lllllllllllllIIIIIllIIIlIlIIIIll; ++lllllllllllllIIIIIllIIIlIlIIIllI) {
            lllllllllllllIIIIIllIIIlIlIIIIlI[lllllllllllllIIIIIllIIIlIlIIIllI] = this.toCtClass(lllllllllllllIIIIIllIIIlIlIIIlII[lllllllllllllIIIIIllIIIlIlIIIllI]);
        }
        return lllllllllllllIIIIIllIIIlIlIIIIlI;
    }
    
    private CtClass produceProxyClass(final CtClass lllllllllllllIIIIIllIIIlIllIIllI, final Class<?> lllllllllllllIIIIIllIIIlIlIllllI) throws CannotCompileException, NotFoundException {
        final int lllllllllllllIIIIIllIIIlIllIIlII = lllllllllllllIIIIIllIIIlIllIIllI.getModifiers();
        if (Modifier.isAbstract(lllllllllllllIIIIIllIIIlIllIIlII) || Modifier.isNative(lllllllllllllIIIIIllIIIlIllIIlII) || !Modifier.isPublic(lllllllllllllIIIIIllIIIlIllIIlII)) {
            throw new CannotCompileException(String.valueOf(new StringBuilder().append(lllllllllllllIIIIIllIIIlIllIIllI.getName()).append(" must be public, non-native, and non-abstract.")));
        }
        final CtClass lllllllllllllIIIIIllIIIlIllIIIll = this.classPool.makeClass(lllllllllllllIIIIIllIIIlIllIIllI.getName(), lllllllllllllIIIIIllIIIlIllIIllI.getSuperclass());
        lllllllllllllIIIIIllIIIlIllIIIll.setInterfaces(this.interfacesForProxy);
        CtField lllllllllllllIIIIIllIIIlIllIIIlI = new CtField(this.classPool.get("com.viaversion.viaversion.libs.javassist.tools.rmi.ObjectImporter"), "importer", lllllllllllllIIIIIllIIIlIllIIIll);
        lllllllllllllIIIIIllIIIlIllIIIlI.setModifiers(2);
        lllllllllllllIIIIIllIIIlIllIIIll.addField(lllllllllllllIIIIIllIIIlIllIIIlI, CtField.Initializer.byParameter(0));
        lllllllllllllIIIIIllIIIlIllIIIlI = new CtField(CtClass.intType, "objectId", lllllllllllllIIIIIllIIIlIllIIIll);
        lllllllllllllIIIIIllIIIlIllIIIlI.setModifiers(2);
        lllllllllllllIIIIIllIIIlIllIIIll.addField(lllllllllllllIIIIIllIIIlIllIIIlI, CtField.Initializer.byParameter(1));
        lllllllllllllIIIIIllIIIlIllIIIll.addMethod(CtNewMethod.getter("_getObjectId", lllllllllllllIIIIIllIIIlIllIIIlI));
        lllllllllllllIIIIIllIIIlIllIIIll.addConstructor(CtNewConstructor.defaultConstructor(lllllllllllllIIIIIllIIIlIllIIIll));
        final CtConstructor lllllllllllllIIIIIllIIIlIllIIIIl = CtNewConstructor.skeleton(this.proxyConstructorParamTypes, null, lllllllllllllIIIIIllIIIlIllIIIll);
        lllllllllllllIIIIIllIIIlIllIIIll.addConstructor(lllllllllllllIIIIIllIIIlIllIIIIl);
        try {
            this.addMethods(lllllllllllllIIIIIllIIIlIllIIIll, lllllllllllllIIIIIllIIIlIlIllllI.getMethods());
            return lllllllllllllIIIIIllIIIlIllIIIll;
        }
        catch (SecurityException lllllllllllllIIIIIllIIIlIllIlIII) {
            throw new CannotCompileException(lllllllllllllIIIIIllIIIlIllIlIII);
        }
    }
    
    @Override
    public void onLoad(final ClassPool lllllllllllllIIIIIllIIIllIIIIlII, final String lllllllllllllIIIIIllIIIllIIIIIll) {
    }
    
    private void addMethods(final CtClass lllllllllllllIIIIIllIIIlIIlIllIl, final Method[] lllllllllllllIIIIIllIIIlIIlIllII) throws NotFoundException, CannotCompileException {
        for (int lllllllllllllIIIIIllIIIlIIlIllll = 0; lllllllllllllIIIIIllIIIlIIlIllll < lllllllllllllIIIIIllIIIlIIlIllII.length; ++lllllllllllllIIIIIllIIIlIIlIllll) {
            final Method lllllllllllllIIIIIllIIIlIIllIIIl = lllllllllllllIIIIIllIIIlIIlIllII[lllllllllllllIIIIIllIIIlIIlIllll];
            final int lllllllllllllIIIIIllIIIlIIllIIII = lllllllllllllIIIIIllIIIlIIllIIIl.getModifiers();
            if (lllllllllllllIIIIIllIIIlIIllIIIl.getDeclaringClass() != Object.class && !Modifier.isFinal(lllllllllllllIIIIIllIIIlIIllIIII)) {
                if (Modifier.isPublic(lllllllllllllIIIIIllIIIlIIllIIII)) {
                    CtMethod lllllllllllllIIIIIllIIIlIIllIIll = null;
                    if (Modifier.isStatic(lllllllllllllIIIIIllIIIlIIllIIII)) {
                        final CtMethod lllllllllllllIIIIIllIIIlIIllIlII = this.forwardStaticMethod;
                    }
                    else {
                        lllllllllllllIIIIIllIIIlIIllIIll = this.forwardMethod;
                    }
                    final CtMethod lllllllllllllIIIIIllIIIlIIllIIlI = CtNewMethod.wrapped(this.toCtClass(lllllllllllllIIIIIllIIIlIIllIIIl.getReturnType()), lllllllllllllIIIIIllIIIlIIllIIIl.getName(), this.toCtClass(lllllllllllllIIIIIllIIIlIIllIIIl.getParameterTypes()), this.exceptionForProxy, lllllllllllllIIIIIllIIIlIIllIIll, CtMethod.ConstParameter.integer(lllllllllllllIIIIIllIIIlIIlIllll), lllllllllllllIIIIIllIIIlIIlIllIl);
                    lllllllllllllIIIIIllIIIlIIllIIlI.setModifiers(lllllllllllllIIIIIllIIIlIIllIIII);
                    lllllllllllllIIIIIllIIIlIIlIllIl.addMethod(lllllllllllllIIIIIllIIIlIIllIIlI);
                }
                else if (!Modifier.isProtected(lllllllllllllIIIIIllIIIlIIllIIII) && !Modifier.isPrivate(lllllllllllllIIIIIllIIIlIIllIIII)) {
                    throw new CannotCompileException("the methods must be public, protected, or private.");
                }
            }
        }
    }
    
    public synchronized boolean makeProxyClass(final Class<?> lllllllllllllIIIIIllIIIlIlllIIll) throws CannotCompileException, NotFoundException {
        final String lllllllllllllIIIIIllIIIlIlllIllI = lllllllllllllIIIIIllIIIlIlllIIll.getName();
        if (this.proxyClasses.get(lllllllllllllIIIIIllIIIlIlllIllI) != null) {
            return false;
        }
        final CtClass lllllllllllllIIIIIllIIIlIlllIlIl = this.produceProxyClass(this.classPool.get(lllllllllllllIIIIIllIIIlIlllIllI), lllllllllllllIIIIIllIIIlIlllIIll);
        this.proxyClasses.put(lllllllllllllIIIIIllIIIlIlllIllI, lllllllllllllIIIIIllIIIlIlllIlIl);
        this.modifySuperclass(lllllllllllllIIIIIllIIIlIlllIlIl);
        return true;
    }
    
    public StubGenerator() {
        this.proxyClasses = new Hashtable<String, CtClass>();
    }
}
