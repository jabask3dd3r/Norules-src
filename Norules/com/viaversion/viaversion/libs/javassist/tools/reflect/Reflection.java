package com.viaversion.viaversion.libs.javassist.tools.reflect;

import com.viaversion.viaversion.libs.javassist.bytecode.*;
import com.viaversion.viaversion.libs.javassist.*;

public class Reflection implements Translator
{
    protected /* synthetic */ ClassPool classPool;
    protected /* synthetic */ CtClass[] readParam;
    protected /* synthetic */ CtMethod trapStaticMethod;
    protected /* synthetic */ CtMethod trapRead;
    protected /* synthetic */ CtMethod trapMethod;
    protected /* synthetic */ CtMethod trapWrite;
    protected /* synthetic */ CodeConverter converter;
    
    private CtMethod findOriginal(final CtMethod lllllllllllllllIIllIIlIllIlIIIII, final boolean lllllllllllllllIIllIIlIllIIlllll) throws NotFoundException {
        if (lllllllllllllllIIllIIlIllIIlllll) {
            return lllllllllllllllIIllIIlIllIlIIIII;
        }
        final String lllllllllllllllIIllIIlIllIIllllI = lllllllllllllllIIllIIlIllIlIIIII.getName();
        final CtMethod[] lllllllllllllllIIllIIlIllIIlllIl = lllllllllllllllIIllIIlIllIlIIIII.getDeclaringClass().getDeclaredMethods();
        for (int lllllllllllllllIIllIIlIllIlIIIlI = 0; lllllllllllllllIIllIIlIllIlIIIlI < lllllllllllllllIIllIIlIllIIlllIl.length; ++lllllllllllllllIIllIIlIllIlIIIlI) {
            final String lllllllllllllllIIllIIlIllIlIIIll = lllllllllllllllIIllIIlIllIIlllIl[lllllllllllllllIIllIIlIllIlIIIlI].getName();
            if (lllllllllllllllIIllIIlIllIlIIIll.endsWith(lllllllllllllllIIllIIlIllIIllllI) && lllllllllllllllIIllIIlIllIlIIIll.startsWith("_m_") && lllllllllllllllIIllIIlIllIIlllIl[lllllllllllllllIIllIIlIllIlIIIlI].getSignature().equals(lllllllllllllllIIllIIlIllIlIIIII.getSignature())) {
                return lllllllllllllllIIllIIlIllIIlllIl[lllllllllllllllIIllIIlIllIlIIIlI];
            }
        }
        return lllllllllllllllIIllIIlIllIlIIIII;
    }
    
    private void registerReflectiveClass(final CtClass lllllllllllllllIIllIIllIIIIIlIIl) {
        final CtField[] lllllllllllllllIIllIIllIIIIIlIII = lllllllllllllllIIllIIllIIIIIlIIl.getDeclaredFields();
        for (int lllllllllllllllIIllIIllIIIIIlIll = 0; lllllllllllllllIIllIIllIIIIIlIll < lllllllllllllllIIllIIllIIIIIlIII.length; ++lllllllllllllllIIllIIllIIIIIlIll) {
            final CtField lllllllllllllllIIllIIllIIIIIllIl = lllllllllllllllIIllIIllIIIIIlIII[lllllllllllllllIIllIIllIIIIIlIll];
            final int lllllllllllllllIIllIIllIIIIIllII = lllllllllllllllIIllIIllIIIIIllIl.getModifiers();
            if ((lllllllllllllllIIllIIllIIIIIllII & 0x1) != 0x0 && (lllllllllllllllIIllIIllIIIIIllII & 0x10) == 0x0) {
                final String lllllllllllllllIIllIIllIIIIIlllI = lllllllllllllllIIllIIllIIIIIllIl.getName();
                this.converter.replaceFieldRead(lllllllllllllllIIllIIllIIIIIllIl, lllllllllllllllIIllIIllIIIIIlIIl, String.valueOf(new StringBuilder().append("_r_").append(lllllllllllllllIIllIIllIIIIIlllI)));
                this.converter.replaceFieldWrite(lllllllllllllllIIllIIllIIIIIllIl, lllllllllllllllIIllIIllIIIIIlIIl, String.valueOf(new StringBuilder().append("_w_").append(lllllllllllllllIIllIIllIIIIIlllI)));
            }
        }
    }
    
    public void rebuildClassFile(final ClassFile lllllllllllllllIIllIIlIlIlllIIII) throws BadBytecode {
        if (ClassFile.MAJOR_VERSION < 50) {
            return;
        }
        for (final MethodInfo lllllllllllllllIIllIIlIlIlllIlII : lllllllllllllllIIllIIlIlIlllIIII.getMethods()) {
            lllllllllllllllIIllIIlIlIlllIlII.rebuildStackMap(this.classPool);
        }
    }
    
    @Override
    public void start(final ClassPool lllllllllllllllIIllIIllIIlIIlIll) throws NotFoundException {
        this.classPool = lllllllllllllllIIllIIllIIlIIlIll;
        final String lllllllllllllllIIllIIllIIlIIlIlI = "com.viaversion.viaversion.libs.javassist.tools.reflect.Sample is not found or broken.";
        try {
            final CtClass lllllllllllllllIIllIIllIIlIIllll = this.classPool.get("com.viaversion.viaversion.libs.javassist.tools.reflect.Sample");
            this.rebuildClassFile(lllllllllllllllIIllIIllIIlIIllll.getClassFile());
            this.trapMethod = lllllllllllllllIIllIIllIIlIIllll.getDeclaredMethod("trap");
            this.trapStaticMethod = lllllllllllllllIIllIIllIIlIIllll.getDeclaredMethod("trapStatic");
            this.trapRead = lllllllllllllllIIllIIllIIlIIllll.getDeclaredMethod("trapRead");
            this.trapWrite = lllllllllllllllIIllIIllIIlIIllll.getDeclaredMethod("trapWrite");
            this.readParam = new CtClass[] { this.classPool.get("java.lang.Object") };
        }
        catch (NotFoundException lllllllllllllllIIllIIllIIlIIlllI) {
            throw new RuntimeException("com.viaversion.viaversion.libs.javassist.tools.reflect.Sample is not found or broken.");
        }
        catch (BadBytecode lllllllllllllllIIllIIllIIlIIllIl) {
            throw new RuntimeException("com.viaversion.viaversion.libs.javassist.tools.reflect.Sample is not found or broken.");
        }
    }
    
    public boolean makeReflective(final CtClass lllllllllllllllIIllIIllIIIIllIII, final CtClass lllllllllllllllIIllIIllIIIIlIlll, final CtClass lllllllllllllllIIllIIllIIIIllIlI) throws CannotCompileException, NotFoundException, CannotReflectException {
        if (lllllllllllllllIIllIIllIIIIllIII.isInterface()) {
            throw new CannotReflectException(String.valueOf(new StringBuilder().append("Cannot reflect an interface: ").append(lllllllllllllllIIllIIllIIIIllIII.getName())));
        }
        if (lllllllllllllllIIllIIllIIIIllIII.subclassOf(this.classPool.get("com.viaversion.viaversion.libs.javassist.tools.reflect.ClassMetaobject"))) {
            throw new CannotReflectException(String.valueOf(new StringBuilder().append("Cannot reflect a subclass of ClassMetaobject: ").append(lllllllllllllllIIllIIllIIIIllIII.getName())));
        }
        if (lllllllllllllllIIllIIllIIIIllIII.subclassOf(this.classPool.get("com.viaversion.viaversion.libs.javassist.tools.reflect.Metaobject"))) {
            throw new CannotReflectException(String.valueOf(new StringBuilder().append("Cannot reflect a subclass of Metaobject: ").append(lllllllllllllllIIllIIllIIIIllIII.getName())));
        }
        this.registerReflectiveClass(lllllllllllllllIIllIIllIIIIllIII);
        return this.modifyClassfile(lllllllllllllllIIllIIllIIIIllIII, lllllllllllllllIIllIIllIIIIlIlll, lllllllllllllllIIllIIllIIIIllIlI);
    }
    
    public boolean makeReflective(final Class<?> lllllllllllllllIIllIIllIIIlIIlII, final Class<?> lllllllllllllllIIllIIllIIIlIIIll, final Class<?> lllllllllllllllIIllIIllIIIlIIllI) throws CannotCompileException, NotFoundException {
        return this.makeReflective(lllllllllllllllIIllIIllIIIlIIlII.getName(), lllllllllllllllIIllIIllIIIlIIIll.getName(), lllllllllllllllIIllIIllIIIlIIllI.getName());
    }
    
    private boolean isExcluded(final String lllllllllllllllIIllIIllIIllIIllI) {
        return lllllllllllllllIIllIIllIIllIIllI.startsWith("_m_") || lllllllllllllllIIllIIllIIllIIllI.equals("_getClass") || lllllllllllllllIIllIIllIIllIIllI.equals("_setMetaobject") || lllllllllllllllIIllIIllIIllIIllI.equals("_getMetaobject") || lllllllllllllllIIllIIllIIllIIllI.startsWith("_r_") || lllllllllllllllIIllIIllIIllIIllI.startsWith("_w_");
    }
    
    private void processMethods0(int lllllllllllllllIIllIIlIllIllIIlI, final CtClass lllllllllllllllIIllIIlIllIlllIll, final CtMethod lllllllllllllllIIllIIlIllIllIIII, final int lllllllllllllllIIllIIlIllIlIllll, final boolean lllllllllllllllIIllIIlIllIlIlllI) throws CannotCompileException, NotFoundException {
        final String lllllllllllllllIIllIIlIllIllIllI = lllllllllllllllIIllIIlIllIllIIII.getName();
        if (this.isExcluded(lllllllllllllllIIllIIlIllIllIllI)) {
            return;
        }
        CtMethod lllllllllllllllIIllIIlIllIllIlIl = null;
        if (lllllllllllllllIIllIIlIllIllIIII.getDeclaringClass() == lllllllllllllllIIllIIlIllIlllIll) {
            if (Modifier.isNative(lllllllllllllllIIllIIlIllIllIIlI)) {
                return;
            }
            final CtMethod lllllllllllllllIIllIIlIllIllllll = lllllllllllllllIIllIIlIllIllIIII;
            if (Modifier.isFinal(lllllllllllllllIIllIIlIllIllIIlI)) {
                lllllllllllllllIIllIIlIllIllIIlI &= 0xFFFFFFEF;
                lllllllllllllllIIllIIlIllIllllll.setModifiers(lllllllllllllllIIllIIlIllIllIIlI);
            }
        }
        else {
            if (Modifier.isFinal(lllllllllllllllIIllIIlIllIllIIlI)) {
                return;
            }
            lllllllllllllllIIllIIlIllIllIIlI &= 0xFFFFFEFF;
            lllllllllllllllIIllIIlIllIllIlIl = CtNewMethod.delegator(this.findOriginal(lllllllllllllllIIllIIlIllIllIIII, lllllllllllllllIIllIIlIllIlIlllI), lllllllllllllllIIllIIlIllIlllIll);
            lllllllllllllllIIllIIlIllIllIlIl.setModifiers(lllllllllllllllIIllIIlIllIllIIlI);
            lllllllllllllllIIllIIlIllIlllIll.addMethod(lllllllllllllllIIllIIlIllIllIlIl);
        }
        lllllllllllllllIIllIIlIllIllIlIl.setName(String.valueOf(new StringBuilder().append("_m_").append(lllllllllllllllIIllIIlIllIlIllll).append("_").append(lllllllllllllllIIllIIlIllIllIllI)));
        CtMethod lllllllllllllllIIllIIlIllIllIlll = null;
        if (Modifier.isStatic(lllllllllllllllIIllIIlIllIllIIlI)) {
            final CtMethod lllllllllllllllIIllIIlIllIlllllI = this.trapStaticMethod;
        }
        else {
            lllllllllllllllIIllIIlIllIllIlll = this.trapMethod;
        }
        final CtMethod lllllllllllllllIIllIIlIllIllIlII = CtNewMethod.wrapped(lllllllllllllllIIllIIlIllIllIIII.getReturnType(), lllllllllllllllIIllIIlIllIllIllI, lllllllllllllllIIllIIlIllIllIIII.getParameterTypes(), lllllllllllllllIIllIIlIllIllIIII.getExceptionTypes(), lllllllllllllllIIllIIlIllIllIlll, CtMethod.ConstParameter.integer(lllllllllllllllIIllIIlIllIlIllll), lllllllllllllllIIllIIlIllIlllIll);
        lllllllllllllllIIllIIlIllIllIlII.setModifiers(lllllllllllllllIIllIIlIllIllIIlI);
        lllllllllllllllIIllIIlIllIlllIll.addMethod(lllllllllllllllIIllIIlIllIllIlII);
    }
    
    @Override
    public void onLoad(final ClassPool lllllllllllllllIIllIIllIIlIIIIII, final String lllllllllllllllIIllIIllIIIllllll) throws NotFoundException, CannotCompileException {
        final CtClass lllllllllllllllIIllIIllIIIlllllI = lllllllllllllllIIllIIllIIlIIIIII.get(lllllllllllllllIIllIIllIIIllllll);
        lllllllllllllllIIllIIllIIIlllllI.instrument(this.converter);
    }
    
    private void processMethods(final CtClass lllllllllllllllIIllIIlIlllIllIIl, final boolean lllllllllllllllIIllIIlIlllIllllI) throws CannotCompileException, NotFoundException {
        final CtMethod[] lllllllllllllllIIllIIlIlllIlllII = lllllllllllllllIIllIIlIlllIllIIl.getMethods();
        for (int lllllllllllllllIIllIIlIllllIIIIl = 0; lllllllllllllllIIllIIlIllllIIIIl < lllllllllllllllIIllIIlIlllIlllII.length; ++lllllllllllllllIIllIIlIllllIIIIl) {
            final CtMethod lllllllllllllllIIllIIlIllllIIIll = lllllllllllllllIIllIIlIlllIlllII[lllllllllllllllIIllIIlIllllIIIIl];
            final int lllllllllllllllIIllIIlIllllIIIlI = lllllllllllllllIIllIIlIllllIIIll.getModifiers();
            if (Modifier.isPublic(lllllllllllllllIIllIIlIllllIIIlI) && !Modifier.isAbstract(lllllllllllllllIIllIIlIllllIIIlI)) {
                this.processMethods0(lllllllllllllllIIllIIlIllllIIIlI, lllllllllllllllIIllIIlIlllIllIIl, lllllllllllllllIIllIIlIllllIIIll, lllllllllllllllIIllIIlIllllIIIIl, lllllllllllllllIIllIIlIlllIllllI);
            }
        }
    }
    
    private void processFields(final CtClass lllllllllllllllIIllIIlIllIIIIlII) throws CannotCompileException, NotFoundException {
        final CtField[] lllllllllllllllIIllIIlIllIIIIIll = lllllllllllllllIIllIIlIllIIIIlII.getDeclaredFields();
        for (int lllllllllllllllIIllIIlIllIIIIllI = 0; lllllllllllllllIIllIIlIllIIIIllI < lllllllllllllllIIllIIlIllIIIIIll.length; ++lllllllllllllllIIllIIlIllIIIIllI) {
            final CtField lllllllllllllllIIllIIlIllIIIlIII = lllllllllllllllIIllIIlIllIIIIIll[lllllllllllllllIIllIIlIllIIIIllI];
            int lllllllllllllllIIllIIlIllIIIIlll = lllllllllllllllIIllIIlIllIIIlIII.getModifiers();
            if ((lllllllllllllllIIllIIlIllIIIIlll & 0x1) != 0x0 && (lllllllllllllllIIllIIlIllIIIIlll & 0x10) == 0x0) {
                lllllllllllllllIIllIIlIllIIIIlll |= 0x8;
                final String lllllllllllllllIIllIIlIllIIIllII = lllllllllllllllIIllIIlIllIIIlIII.getName();
                final CtClass lllllllllllllllIIllIIlIllIIIlIll = lllllllllllllllIIllIIlIllIIIlIII.getType();
                CtMethod lllllllllllllllIIllIIlIllIIIlIlI = CtNewMethod.wrapped(lllllllllllllllIIllIIlIllIIIlIll, String.valueOf(new StringBuilder().append("_r_").append(lllllllllllllllIIllIIlIllIIIllII)), this.readParam, null, this.trapRead, CtMethod.ConstParameter.string(lllllllllllllllIIllIIlIllIIIllII), lllllllllllllllIIllIIlIllIIIIlII);
                lllllllllllllllIIllIIlIllIIIlIlI.setModifiers(lllllllllllllllIIllIIlIllIIIIlll);
                lllllllllllllllIIllIIlIllIIIIlII.addMethod(lllllllllllllllIIllIIlIllIIIlIlI);
                final CtClass[] lllllllllllllllIIllIIlIllIIIlIIl = { this.classPool.get("java.lang.Object"), lllllllllllllllIIllIIlIllIIIlIll };
                lllllllllllllllIIllIIlIllIIIlIlI = CtNewMethod.wrapped(CtClass.voidType, String.valueOf(new StringBuilder().append("_w_").append(lllllllllllllllIIllIIlIllIIIllII)), lllllllllllllllIIllIIlIllIIIlIIl, null, this.trapWrite, CtMethod.ConstParameter.string(lllllllllllllllIIllIIlIllIIIllII), lllllllllllllllIIllIIlIllIIIIlII);
                lllllllllllllllIIllIIlIllIIIlIlI.setModifiers(lllllllllllllllIIllIIlIllIIIIlll);
                lllllllllllllllIIllIIlIllIIIIlII.addMethod(lllllllllllllllIIllIIlIllIIIlIlI);
            }
        }
    }
    
    public Reflection() {
        this.classPool = null;
        this.converter = new CodeConverter();
    }
    
    public boolean makeReflective(final String lllllllllllllllIIllIIllIIIllIlII, final String lllllllllllllllIIllIIllIIIlIllll, final String lllllllllllllllIIllIIllIIIllIIlI) throws NotFoundException, CannotCompileException {
        return this.makeReflective(this.classPool.get(lllllllllllllllIIllIIllIIIllIlII), this.classPool.get(lllllllllllllllIIllIIllIIIlIllll), this.classPool.get(lllllllllllllllIIllIIllIIIllIIlI));
    }
    
    private boolean modifyClassfile(final CtClass lllllllllllllllIIllIIlIlllllIIII, final CtClass lllllllllllllllIIllIIlIlllllIllI, final CtClass lllllllllllllllIIllIIlIllllIlllI) throws CannotCompileException, NotFoundException {
        if (lllllllllllllllIIllIIlIlllllIIII.getAttribute("Reflective") != null) {
            return false;
        }
        lllllllllllllllIIllIIlIlllllIIII.setAttribute("Reflective", new byte[0]);
        final CtClass lllllllllllllllIIllIIlIlllllIlII = this.classPool.get("com.viaversion.viaversion.libs.javassist.tools.reflect.Metalevel");
        final boolean lllllllllllllllIIllIIlIlllllIIll = !lllllllllllllllIIllIIlIlllllIIII.subtypeOf(lllllllllllllllIIllIIlIlllllIlII);
        if (lllllllllllllllIIllIIlIlllllIIll) {
            lllllllllllllllIIllIIlIlllllIIII.addInterface(lllllllllllllllIIllIIlIlllllIlII);
        }
        this.processMethods(lllllllllllllllIIllIIlIlllllIIII, lllllllllllllllIIllIIlIlllllIIll);
        this.processFields(lllllllllllllllIIllIIlIlllllIIII);
        if (lllllllllllllllIIllIIlIlllllIIll) {
            final CtField lllllllllllllllIIllIIlIllllllIIl = new CtField(this.classPool.get("com.viaversion.viaversion.libs.javassist.tools.reflect.Metaobject"), "_metaobject", lllllllllllllllIIllIIlIlllllIIII);
            lllllllllllllllIIllIIlIllllllIIl.setModifiers(4);
            lllllllllllllllIIllIIlIlllllIIII.addField(lllllllllllllllIIllIIlIllllllIIl, CtField.Initializer.byNewWithParams(lllllllllllllllIIllIIlIlllllIllI));
            lllllllllllllllIIllIIlIlllllIIII.addMethod(CtNewMethod.getter("_getMetaobject", lllllllllllllllIIllIIlIllllllIIl));
            lllllllllllllllIIllIIlIlllllIIII.addMethod(CtNewMethod.setter("_setMetaobject", lllllllllllllllIIllIIlIllllllIIl));
        }
        final CtField lllllllllllllllIIllIIlIlllllIIlI = new CtField(this.classPool.get("com.viaversion.viaversion.libs.javassist.tools.reflect.ClassMetaobject"), "_classobject", lllllllllllllllIIllIIlIlllllIIII);
        lllllllllllllllIIllIIlIlllllIIlI.setModifiers(10);
        lllllllllllllllIIllIIlIlllllIIII.addField(lllllllllllllllIIllIIlIlllllIIlI, CtField.Initializer.byNew(lllllllllllllllIIllIIlIllllIlllI, new String[] { lllllllllllllllIIllIIlIlllllIIII.getName() }));
        lllllllllllllllIIllIIlIlllllIIII.addMethod(CtNewMethod.getter("_getClass", lllllllllllllllIIllIIlIlllllIIlI));
        return true;
    }
    
    static {
        classMetaobjectClassName = "com.viaversion.viaversion.libs.javassist.tools.reflect.ClassMetaobject";
        classobjectAccessor = "_getClass";
        writePrefix = "_w_";
        classobjectField = "_classobject";
        metaobjectGetter = "_getMetaobject";
        metaobjectClassName = "com.viaversion.viaversion.libs.javassist.tools.reflect.Metaobject";
        metaobjectSetter = "_setMetaobject";
        metaobjectField = "_metaobject";
        readPrefix = "_r_";
    }
}
