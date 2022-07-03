package com.viaversion.viaversion.libs.javassist;

import java.util.*;
import com.viaversion.viaversion.libs.javassist.bytecode.*;
import com.viaversion.viaversion.libs.javassist.compiler.*;
import com.viaversion.viaversion.libs.javassist.compiler.ast.*;

public class CtField extends CtMember
{
    protected /* synthetic */ FieldInfo fieldInfo;
    
    @Override
    public String getGenericSignature() {
        final SignatureAttribute lllllllllllllIllIlIlIllIllllIIIl = (SignatureAttribute)this.fieldInfo.getAttribute("Signature");
        return (lllllllllllllIllIlIlIllIllllIIIl == null) ? null : lllllllllllllIllIlIlIllIllllIIIl.getSignature();
    }
    
    @Override
    public Object[] getAnnotations() throws ClassNotFoundException {
        return this.getAnnotations(false);
    }
    
    @Override
    public byte[] getAttribute(final String lllllllllllllIllIlIlIllIllIIllll) {
        final AttributeInfo lllllllllllllIllIlIlIllIllIIlllI = this.fieldInfo.getAttribute(lllllllllllllIllIlIlIllIllIIllll);
        if (lllllllllllllIllIlIlIllIllIIlllI == null) {
            return null;
        }
        return lllllllllllllIllIlIlIllIllIIlllI.get();
    }
    
    public void setName(final String lllllllllllllIllIlIlIlllIIlllIIl) {
        this.declaringClass.checkModify();
        this.fieldInfo.setName(lllllllllllllIllIlIlIlllIIlllIIl);
    }
    
    @Override
    public void setAttribute(final String lllllllllllllIllIlIlIllIllIIIIll, final byte[] lllllllllllllIllIlIlIllIllIIIlIl) {
        this.declaringClass.checkModify();
        this.fieldInfo.addAttribute(new AttributeInfo(this.fieldInfo.getConstPool(), lllllllllllllIllIlIlIllIllIIIIll, lllllllllllllIllIlIlIllIllIIIlIl));
    }
    
    @Override
    public void setGenericSignature(final String lllllllllllllIllIlIlIllIlllIlIIl) {
        this.declaringClass.checkModify();
        this.fieldInfo.addAttribute(new SignatureAttribute(this.fieldInfo.getConstPool(), lllllllllllllIllIlIlIllIlllIlIIl));
    }
    
    @Override
    public String getName() {
        return this.fieldInfo.getName();
    }
    
    protected ASTree getInitAST() {
        return null;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append(this.getDeclaringClass().getName()).append(".").append(this.getName()).append(":").append(this.fieldInfo.getDescriptor()));
    }
    
    public Object getConstantValue() {
        final int lllllllllllllIllIlIlIllIllIllIIl = this.fieldInfo.getConstantValue();
        if (lllllllllllllIllIlIlIllIllIllIIl == 0) {
            return null;
        }
        final ConstPool lllllllllllllIllIlIlIllIllIllIII = this.fieldInfo.getConstPool();
        switch (lllllllllllllIllIlIlIllIllIllIII.getTag(lllllllllllllIllIlIlIllIllIllIIl)) {
            case 5: {
                return lllllllllllllIllIlIlIllIllIllIII.getLongInfo(lllllllllllllIllIlIlIllIllIllIIl);
            }
            case 4: {
                return lllllllllllllIllIlIlIllIllIllIII.getFloatInfo(lllllllllllllIllIlIlIllIllIllIIl);
            }
            case 6: {
                return lllllllllllllIllIlIlIllIllIllIII.getDoubleInfo(lllllllllllllIllIlIlIllIllIllIIl);
            }
            case 3: {
                final int lllllllllllllIllIlIlIllIllIllIll = lllllllllllllIllIlIlIllIllIllIII.getIntegerInfo(lllllllllllllIllIlIlIllIllIllIIl);
                if ("Z".equals(this.fieldInfo.getDescriptor())) {
                    return lllllllllllllIllIlIlIllIllIllIll != 0;
                }
                return lllllllllllllIllIlIlIllIllIllIll;
            }
            case 8: {
                return lllllllllllllIllIlIlIllIllIllIII.getStringInfo(lllllllllllllIllIlIlIllIllIllIIl);
            }
            default: {
                throw new RuntimeException(String.valueOf(new StringBuilder().append("bad tag: ").append(lllllllllllllIllIlIlIllIllIllIII.getTag(lllllllllllllIllIlIlIllIllIllIIl)).append(" at ").append(lllllllllllllIllIlIlIllIllIllIIl)));
            }
        }
    }
    
    private Object[] getAnnotations(final boolean lllllllllllllIllIlIlIlllIIIIIIII) throws ClassNotFoundException {
        final FieldInfo lllllllllllllIllIlIlIllIllllllll = this.getFieldInfo2();
        final AnnotationsAttribute lllllllllllllIllIlIlIllIlllllllI = (AnnotationsAttribute)lllllllllllllIllIlIlIllIllllllll.getAttribute("RuntimeInvisibleAnnotations");
        final AnnotationsAttribute lllllllllllllIllIlIlIllIllllllIl = (AnnotationsAttribute)lllllllllllllIllIlIlIllIllllllll.getAttribute("RuntimeVisibleAnnotations");
        return CtClassType.toAnnotationType(lllllllllllllIllIlIlIlllIIIIIIII, this.getDeclaringClass().getClassPool(), lllllllllllllIllIlIlIllIlllllllI, lllllllllllllIllIlIlIllIllllllIl);
    }
    
    @Override
    public CtClass getDeclaringClass() {
        return super.getDeclaringClass();
    }
    
    private CtField(final String lllllllllllllIllIlIlIlllIlllIIlI, final String lllllllllllllIllIlIlIlllIlllIIIl, final CtClass lllllllllllllIllIlIlIlllIlllIlIl) throws CannotCompileException {
        super(lllllllllllllIllIlIlIlllIlllIlIl);
        final ClassFile lllllllllllllIllIlIlIlllIlllIlII = lllllllllllllIllIlIlIlllIlllIlIl.getClassFile2();
        if (lllllllllllllIllIlIlIlllIlllIlII == null) {
            throw new CannotCompileException(String.valueOf(new StringBuilder().append("bad declaring class: ").append(lllllllllllllIllIlIlIlllIlllIlIl.getName())));
        }
        this.fieldInfo = new FieldInfo(lllllllllllllIllIlIlIlllIlllIlII.getConstPool(), lllllllllllllIllIlIlIlllIlllIIIl, lllllllllllllIllIlIlIlllIlllIIlI);
    }
    
    public FieldInfo getFieldInfo() {
        this.declaringClass.checkModify();
        return this.fieldInfo;
    }
    
    @Override
    public String getSignature() {
        return this.fieldInfo.getDescriptor();
    }
    
    @Override
    public int getModifiers() {
        return AccessFlag.toModifier(this.fieldInfo.getAccessFlags());
    }
    
    @Override
    public void setModifiers(final int lllllllllllllIllIlIlIlllIIlIlllI) {
        this.declaringClass.checkModify();
        this.fieldInfo.setAccessFlags(AccessFlag.of(lllllllllllllIllIlIlIlllIIlIlllI));
    }
    
    @Override
    public Object[] getAvailableAnnotations() {
        try {
            return this.getAnnotations(true);
        }
        catch (ClassNotFoundException lllllllllllllIllIlIlIlllIIIIlIlI) {
            throw new RuntimeException("Unexpected exception", lllllllllllllIllIlIlIlllIIIIlIlI);
        }
    }
    
    public FieldInfo getFieldInfo2() {
        return this.fieldInfo;
    }
    
    public void setType(final CtClass lllllllllllllIllIlIlIllIlllIIIII) {
        this.declaringClass.checkModify();
        this.fieldInfo.setDescriptor(Descriptor.of(lllllllllllllIllIlIlIllIlllIIIII));
    }
    
    @Override
    public boolean hasAnnotation(final String lllllllllllllIllIlIlIlllIIlIIlll) {
        final FieldInfo lllllllllllllIllIlIlIlllIIlIIllI = this.getFieldInfo2();
        final AnnotationsAttribute lllllllllllllIllIlIlIlllIIlIIlIl = (AnnotationsAttribute)lllllllllllllIllIlIlIlllIIlIIllI.getAttribute("RuntimeInvisibleAnnotations");
        final AnnotationsAttribute lllllllllllllIllIlIlIlllIIlIIlII = (AnnotationsAttribute)lllllllllllllIllIlIlIlllIIlIIllI.getAttribute("RuntimeVisibleAnnotations");
        return CtClassType.hasAnnotationType(lllllllllllllIllIlIlIlllIIlIIlll, this.getDeclaringClass().getClassPool(), lllllllllllllIllIlIlIlllIIlIIlIl, lllllllllllllIllIlIlIlllIIlIIlII);
    }
    
    Initializer getInit() {
        final ASTree lllllllllllllIllIlIlIlllIlIllIII = this.getInitAST();
        if (lllllllllllllIllIlIlIlllIlIllIII == null) {
            return null;
        }
        return Initializer.byExpr(lllllllllllllIllIlIlIlllIlIllIII);
    }
    
    public CtField(final CtField lllllllllllllIllIlIlIllllIIIIlII, final CtClass lllllllllllllIllIlIlIllllIIIIIll) throws CannotCompileException {
        this(lllllllllllllIllIlIlIllllIIIIlII.fieldInfo.getDescriptor(), lllllllllllllIllIlIlIllllIIIIlII.fieldInfo.getName(), lllllllllllllIllIlIlIllllIIIIIll);
        final FieldInfo lllllllllllllIllIlIlIllllIIIlIII = this.fieldInfo;
        lllllllllllllIllIlIlIllllIIIlIII.setAccessFlags(lllllllllllllIllIlIlIllllIIIIlII.fieldInfo.getAccessFlags());
        final ConstPool lllllllllllllIllIlIlIllllIIIIlll = lllllllllllllIllIlIlIllllIIIlIII.getConstPool();
        final List<AttributeInfo> lllllllllllllIllIlIlIllllIIIIllI = lllllllllllllIllIlIlIllllIIIIlII.fieldInfo.getAttributes();
        for (final AttributeInfo lllllllllllllIllIlIlIllllIIIllII : lllllllllllllIllIlIlIllllIIIIllI) {
            lllllllllllllIllIlIlIllllIIIlIII.addAttribute(lllllllllllllIllIlIlIllllIIIllII.copy(lllllllllllllIllIlIlIllllIIIIlll, null));
        }
    }
    
    @Override
    public Object getAnnotation(final Class<?> lllllllllllllIllIlIlIlllIIIllIII) throws ClassNotFoundException {
        final FieldInfo lllllllllllllIllIlIlIlllIIIlIlll = this.getFieldInfo2();
        final AnnotationsAttribute lllllllllllllIllIlIlIlllIIIlIllI = (AnnotationsAttribute)lllllllllllllIllIlIlIlllIIIlIlll.getAttribute("RuntimeInvisibleAnnotations");
        final AnnotationsAttribute lllllllllllllIllIlIlIlllIIIlIlIl = (AnnotationsAttribute)lllllllllllllIllIlIlIlllIIIlIlll.getAttribute("RuntimeVisibleAnnotations");
        return CtClassType.getAnnotationType(lllllllllllllIllIlIlIlllIIIllIII, this.getDeclaringClass().getClassPool(), lllllllllllllIllIlIlIlllIIIlIllI, lllllllllllllIllIlIlIlllIIIlIlIl);
    }
    
    static {
        javaLangString = "java.lang.String";
    }
    
    CtField(final FieldInfo lllllllllllllIllIlIlIlllIllIIlll, final CtClass lllllllllllllIllIlIlIlllIllIIllI) {
        super(lllllllllllllIllIlIlIlllIllIIllI);
        this.fieldInfo = lllllllllllllIllIlIlIlllIllIIlll;
    }
    
    public CtField(final CtClass lllllllllllllIllIlIlIllllIIllIll, final String lllllllllllllIllIlIlIllllIIlIllI, final CtClass lllllllllllllIllIlIlIllllIIllIIl) throws CannotCompileException {
        this(Descriptor.of(lllllllllllllIllIlIlIllllIIllIll), lllllllllllllIllIlIlIllllIIlIllI, lllllllllllllIllIlIlIllllIIllIIl);
    }
    
    @Override
    protected void extendToString(final StringBuffer lllllllllllllIllIlIlIlllIlIlllIl) {
        lllllllllllllIllIlIlIlllIlIlllIl.append(' ');
        lllllllllllllIllIlIlIlllIlIlllIl.append(this.getName());
        lllllllllllllIllIlIlIlllIlIlllIl.append(' ');
        lllllllllllllIllIlIlIlllIlIlllIl.append(this.fieldInfo.getDescriptor());
    }
    
    public CtClass getType() throws NotFoundException {
        return Descriptor.toCtClass(this.fieldInfo.getDescriptor(), this.declaringClass.getClassPool());
    }
    
    public static CtField make(final String lllllllllllllIllIlIlIlllIlIIllll, final CtClass lllllllllllllIllIlIlIlllIlIIlllI) throws CannotCompileException {
        final Javac lllllllllllllIllIlIlIlllIlIIllIl = new Javac(lllllllllllllIllIlIlIlllIlIIlllI);
        try {
            final CtMember lllllllllllllIllIlIlIlllIlIlIIIl = lllllllllllllIllIlIlIlllIlIIllIl.compile(lllllllllllllIllIlIlIlllIlIIllll);
            if (lllllllllllllIllIlIlIlllIlIlIIIl instanceof CtField) {
                return (CtField)lllllllllllllIllIlIlIlllIlIlIIIl;
            }
        }
        catch (CompileError lllllllllllllIllIlIlIlllIlIlIIII) {
            throw new CannotCompileException(lllllllllllllIllIlIlIlllIlIlIIII);
        }
        throw new CannotCompileException("not a field");
    }
    
    static class FloatInitializer extends Initializer
    {
        /* synthetic */ float value;
        
        @Override
        int getConstantValue(final ConstPool llllllllllllllIIIllIllIIIIIllIll, final CtClass llllllllllllllIIIllIllIIIIIllIlI) {
            if (llllllllllllllIIIllIllIIIIIllIlI == CtClass.floatType) {
                return llllllllllllllIIIllIllIIIIIllIll.addFloatInfo(this.value);
            }
            return 0;
        }
        
        @Override
        int compileIfStatic(final CtClass llllllllllllllIIIllIllIIIIlIIIlI, final String llllllllllllllIIIllIllIIIIlIIIIl, final Bytecode llllllllllllllIIIllIllIIIIlIIlIl, final Javac llllllllllllllIIIllIllIIIIlIIlII) throws CannotCompileException {
            llllllllllllllIIIllIllIIIIlIIlIl.addFconst(this.value);
            llllllllllllllIIIllIllIIIIlIIlIl.addPutstatic(Bytecode.THIS, llllllllllllllIIIllIllIIIIlIIIIl, Descriptor.of(llllllllllllllIIIllIllIIIIlIIIlI));
            return 2;
        }
        
        @Override
        int compile(final CtClass llllllllllllllIIIllIllIIIIllIlIl, final String llllllllllllllIIIllIllIIIIlIlllI, final Bytecode llllllllllllllIIIllIllIIIIllIIll, final CtClass[] llllllllllllllIIIllIllIIIIllIIlI, final Javac llllllllllllllIIIllIllIIIIllIIIl) throws CannotCompileException {
            llllllllllllllIIIllIllIIIIllIIll.addAload(0);
            llllllllllllllIIIllIllIIIIllIIll.addFconst(this.value);
            llllllllllllllIIIllIllIIIIllIIll.addPutfield(Bytecode.THIS, llllllllllllllIIIllIllIIIIlIlllI, Descriptor.of(llllllllllllllIIIllIllIIIIllIlIl));
            return 3;
        }
        
        @Override
        void check(final String llllllllllllllIIIllIllIIIIllllll) throws CannotCompileException {
            if (!llllllllllllllIIIllIllIIIIllllll.equals("F")) {
                throw new CannotCompileException("type mismatch");
            }
        }
        
        FloatInitializer(final float llllllllllllllIIIllIllIIIlIIlIIl) {
            this.value = llllllllllllllIIIllIllIIIlIIlIIl;
        }
    }
    
    public abstract static class Initializer
    {
        public static Initializer constant(final boolean llllIIlIlIIIlIl) {
            return new IntInitializer(llllIIlIlIIIlIl ? 1 : 0);
        }
        
        public static Initializer byCallWithParams(final CtClass llllIIIllllllII, final String llllIIIlllllIII) {
            final MethodInitializer llllIIIlllllIlI = new MethodInitializer();
            llllIIIlllllIlI.objectType = llllIIIllllllII;
            llllIIIlllllIlI.methodName = llllIIIlllllIII;
            llllIIIlllllIlI.stringParams = null;
            llllIIIlllllIlI.withConstructorParams = true;
            return llllIIIlllllIlI;
        }
        
        public static Initializer constant(final int llllIIlIlIIlIIl) {
            return new IntInitializer(llllIIlIlIIlIIl);
        }
        
        public static Initializer byNewWithParams(final CtClass llllIIlIIIllIlI, final String[] llllIIlIIIllIIl) {
            final NewInitializer llllIIlIIIllIII = new NewInitializer();
            llllIIlIIIllIII.objectType = llllIIlIIIllIlI;
            llllIIlIIIllIII.stringParams = llllIIlIIIllIIl;
            llllIIlIIIllIII.withConstructorParams = true;
            return llllIIlIIIllIII;
        }
        
        public static Initializer byParameter(final int llllIIlIIllIlII) {
            final ParamInitializer llllIIlIIllIlIl = new ParamInitializer();
            llllIIlIIllIlIl.nthParam = llllIIlIIllIlII;
            return llllIIlIIllIlIl;
        }
        
        public static Initializer constant(final double llllIIlIIllllIl) {
            return new DoubleInitializer(llllIIlIIllllIl);
        }
        
        abstract int compileIfStatic(final CtClass p0, final String p1, final Bytecode p2, final Javac p3) throws CannotCompileException;
        
        public static Initializer byCallWithParams(final CtClass llllIIIlllIlllI, final String llllIIIlllIllIl, final String[] llllIIIlllIllII) {
            final MethodInitializer llllIIIlllIllll = new MethodInitializer();
            llllIIIlllIllll.objectType = llllIIIlllIlllI;
            llllIIIlllIllll.methodName = llllIIIlllIllIl;
            llllIIIlllIllll.stringParams = llllIIIlllIllII;
            llllIIIlllIllll.withConstructorParams = true;
            return llllIIIlllIllll;
        }
        
        public static Initializer byNew(final CtClass llllIIlIIlIlllI) {
            final NewInitializer llllIIlIIlIllll = new NewInitializer();
            llllIIlIIlIllll.objectType = llllIIlIIlIlllI;
            llllIIlIIlIllll.stringParams = null;
            llllIIlIIlIllll.withConstructorParams = false;
            return llllIIlIIlIllll;
        }
        
        public static Initializer byNew(final CtClass llllIIlIIlIlIIl, final String[] llllIIlIIlIIlIl) {
            final NewInitializer llllIIlIIlIIlll = new NewInitializer();
            llllIIlIIlIIlll.objectType = llllIIlIIlIlIIl;
            llllIIlIIlIIlll.stringParams = llllIIlIIlIIlIl;
            llllIIlIIlIIlll.withConstructorParams = false;
            return llllIIlIIlIIlll;
        }
        
        public static Initializer byCall(final CtClass llllIIlIIIlIIIl, final String llllIIlIIIIllIl) {
            final MethodInitializer llllIIlIIIIllll = new MethodInitializer();
            llllIIlIIIIllll.objectType = llllIIlIIIlIIIl;
            llllIIlIIIIllll.methodName = llllIIlIIIIllIl;
            llllIIlIIIIllll.stringParams = null;
            llllIIlIIIIllll.withConstructorParams = false;
            return llllIIlIIIIllll;
        }
        
        public static Initializer constant(final long llllIIlIlIIIIll) {
            return new LongInitializer(llllIIlIlIIIIll);
        }
        
        abstract int compile(final CtClass p0, final String p1, final Bytecode p2, final CtClass[] p3, final Javac p4) throws CannotCompileException;
        
        void check(final String llllIIIllIlIlll) throws CannotCompileException {
        }
        
        public static Initializer constant(final String llllIIlIIlllIlI) {
            return new StringInitializer(llllIIlIIlllIlI);
        }
        
        int getConstantValue(final ConstPool llllIIIllIlIlIl, final CtClass llllIIIllIlIlII) {
            return 0;
        }
        
        public static Initializer constant(final float llllIIlIIllllll) {
            return new FloatInitializer(llllIIlIIllllll);
        }
        
        public static Initializer byCall(final CtClass llllIIlIIIIIlll, final String llllIIlIIIIIIlI, final String[] llllIIlIIIIIIIl) {
            final MethodInitializer llllIIlIIIIIlII = new MethodInitializer();
            llllIIlIIIIIlII.objectType = llllIIlIIIIIlll;
            llllIIlIIIIIlII.methodName = llllIIlIIIIIIlI;
            llllIIlIIIIIlII.stringParams = llllIIlIIIIIIIl;
            llllIIlIIIIIlII.withConstructorParams = false;
            return llllIIlIIIIIlII;
        }
        
        static Initializer byExpr(final ASTree llllIIIllIllIlI) {
            return new PtreeInitializer(llllIIIllIllIlI);
        }
        
        public static Initializer byNewArray(final CtClass llllIIIlllIIIlI, final int[] llllIIIllIlllll) {
            return new MultiArrayInitializer(llllIIIlllIIIlI, llllIIIllIlllll);
        }
        
        public static Initializer byNewArray(final CtClass llllIIIlllIIllI, final int llllIIIlllIIlIl) throws NotFoundException {
            return new ArrayInitializer(llllIIIlllIIllI.getComponentType(), llllIIIlllIIlIl);
        }
        
        public static Initializer byNewWithParams(final CtClass llllIIlIIIlllll) {
            final NewInitializer llllIIlIIlIIIII = new NewInitializer();
            llllIIlIIlIIIII.objectType = llllIIlIIIlllll;
            llllIIlIIlIIIII.stringParams = null;
            llllIIlIIlIIIII.withConstructorParams = true;
            return llllIIlIIlIIIII;
        }
        
        public static Initializer byExpr(final String llllIIIllIlllII) {
            return new CodeInitializer(llllIIIllIlllII);
        }
    }
    
    static class DoubleInitializer extends Initializer
    {
        /* synthetic */ double value;
        
        @Override
        void check(final String lllllllllllllIIIIlIIIllllIlllIll) throws CannotCompileException {
            if (!lllllllllllllIIIIlIIIllllIlllIll.equals("D")) {
                throw new CannotCompileException("type mismatch");
            }
        }
        
        DoubleInitializer(final double lllllllllllllIIIIlIIIlllllIIIIII) {
            this.value = lllllllllllllIIIIlIIIlllllIIIIII;
        }
        
        @Override
        int getConstantValue(final ConstPool lllllllllllllIIIIlIIIllllIIlIlll, final CtClass lllllllllllllIIIIlIIIllllIIlIllI) {
            if (lllllllllllllIIIIlIIIllllIIlIllI == CtClass.doubleType) {
                return lllllllllllllIIIIlIIIllllIIlIlll.addDoubleInfo(this.value);
            }
            return 0;
        }
        
        @Override
        int compileIfStatic(final CtClass lllllllllllllIIIIlIIIllllIlIIIIl, final String lllllllllllllIIIIlIIIllllIlIIlIl, final Bytecode lllllllllllllIIIIlIIIllllIlIIlII, final Javac lllllllllllllIIIIlIIIllllIlIIIll) throws CannotCompileException {
            lllllllllllllIIIIlIIIllllIlIIlII.addLdc2w(this.value);
            lllllllllllllIIIIlIIIllllIlIIlII.addPutstatic(Bytecode.THIS, lllllllllllllIIIIlIIIllllIlIIlIl, Descriptor.of(lllllllllllllIIIIlIIIllllIlIIIIl));
            return 2;
        }
        
        @Override
        int compile(final CtClass lllllllllllllIIIIlIIIllllIlIlllI, final String lllllllllllllIIIIlIIIllllIlIllIl, final Bytecode lllllllllllllIIIIlIIIllllIllIIlI, final CtClass[] lllllllllllllIIIIlIIIllllIllIIIl, final Javac lllllllllllllIIIIlIIIllllIllIIII) throws CannotCompileException {
            lllllllllllllIIIIlIIIllllIllIIlI.addAload(0);
            lllllllllllllIIIIlIIIllllIllIIlI.addLdc2w(this.value);
            lllllllllllllIIIIlIIIllllIllIIlI.addPutfield(Bytecode.THIS, lllllllllllllIIIIlIIIllllIlIllIl, Descriptor.of(lllllllllllllIIIIlIIIllllIlIlllI));
            return 3;
        }
    }
    
    static class StringInitializer extends Initializer
    {
        /* synthetic */ String value;
        
        @Override
        int compile(final CtClass llllllllllllllIllllllIIlIlIlIIIl, final String llllllllllllllIllllllIIlIlIlIIII, final Bytecode llllllllllllllIllllllIIlIlIIllll, final CtClass[] llllllllllllllIllllllIIlIlIIlllI, final Javac llllllllllllllIllllllIIlIlIIllIl) throws CannotCompileException {
            llllllllllllllIllllllIIlIlIIllll.addAload(0);
            llllllllllllllIllllllIIlIlIIllll.addLdc(this.value);
            llllllllllllllIllllllIIlIlIIllll.addPutfield(Bytecode.THIS, llllllllllllllIllllllIIlIlIlIIII, Descriptor.of(llllllllllllllIllllllIIlIlIlIIIl));
            return 2;
        }
        
        StringInitializer(final String llllllllllllllIllllllIIlIlIllIIl) {
            this.value = llllllllllllllIllllllIIlIlIllIIl;
        }
        
        @Override
        int compileIfStatic(final CtClass llllllllllllllIllllllIIlIlIIIIll, final String llllllllllllllIllllllIIlIIllllIl, final Bytecode llllllllllllllIllllllIIlIlIIIIIl, final Javac llllllllllllllIllllllIIlIlIIIIII) throws CannotCompileException {
            llllllllllllllIllllllIIlIlIIIIIl.addLdc(this.value);
            llllllllllllllIllllllIIlIlIIIIIl.addPutstatic(Bytecode.THIS, llllllllllllllIllllllIIlIIllllIl, Descriptor.of(llllllllllllllIllllllIIlIlIIIIll));
            return 1;
        }
        
        @Override
        int getConstantValue(final ConstPool llllllllllllllIllllllIIlIIllIlII, final CtClass llllllllllllllIllllllIIlIIllIIll) {
            if (llllllllllllllIllllllIIlIIllIIll.getName().equals("java.lang.String")) {
                return llllllllllllllIllllllIIlIIllIlII.addStringInfo(this.value);
            }
            return 0;
        }
    }
    
    static class LongInitializer extends Initializer
    {
        /* synthetic */ long value;
        
        @Override
        void check(final String llllllllllllllIlIIllIIIllIIlIIIl) throws CannotCompileException {
            if (!llllllllllllllIlIIllIIIllIIlIIIl.equals("J")) {
                throw new CannotCompileException("type mismatch");
            }
        }
        
        @Override
        int compile(final CtClass llllllllllllllIlIIllIIIllIIIIlIl, final String llllllllllllllIlIIllIIIllIIIlIlI, final Bytecode llllllllllllllIlIIllIIIllIIIlIIl, final CtClass[] llllllllllllllIlIIllIIIllIIIlIII, final Javac llllllllllllllIlIIllIIIllIIIIlll) throws CannotCompileException {
            llllllllllllllIlIIllIIIllIIIlIIl.addAload(0);
            llllllllllllllIlIIllIIIllIIIlIIl.addLdc2w(this.value);
            llllllllllllllIlIIllIIIllIIIlIIl.addPutfield(Bytecode.THIS, llllllllllllllIlIIllIIIllIIIlIlI, Descriptor.of(llllllllllllllIlIIllIIIllIIIIlIl));
            return 3;
        }
        
        @Override
        int compileIfStatic(final CtClass llllllllllllllIlIIllIIIlIlllllIl, final String llllllllllllllIlIIllIIIlIlllllII, final Bytecode llllllllllllllIlIIllIIIlIlllIllI, final Javac llllllllllllllIlIIllIIIlIllllIlI) throws CannotCompileException {
            llllllllllllllIlIIllIIIlIlllIllI.addLdc2w(this.value);
            llllllllllllllIlIIllIIIlIlllIllI.addPutstatic(Bytecode.THIS, llllllllllllllIlIIllIIIlIlllllII, Descriptor.of(llllllllllllllIlIIllIIIlIlllllIl));
            return 2;
        }
        
        @Override
        int getConstantValue(final ConstPool llllllllllllllIlIIllIIIlIlllIIIl, final CtClass llllllllllllllIlIIllIIIlIlllIIII) {
            if (llllllllllllllIlIIllIIIlIlllIIII == CtClass.longType) {
                return llllllllllllllIlIIllIIIlIlllIIIl.addLongInfo(this.value);
            }
            return 0;
        }
        
        LongInitializer(final long llllllllllllllIlIIllIIIllIIlIlIl) {
            this.value = llllllllllllllIlIIllIIIllIIlIlIl;
        }
    }
    
    static class MethodInitializer extends NewInitializer
    {
        /* synthetic */ String methodName;
        
        @Override
        int compileIfStatic(final CtClass lllllllllllllIlIlllIIIllllIllIll, final String lllllllllllllIlIlllIIIllllIllIlI, final Bytecode lllllllllllllIlIlllIIIllllIlIIIl, final Javac lllllllllllllIlIlllIIIllllIllIII) throws CannotCompileException {
            int lllllllllllllIlIlllIIIllllIlIllI = 1;
            String lllllllllllllIlIlllIIIllllIlIlll = null;
            if (this.stringParams == null) {
                final String lllllllllllllIlIlllIIIllllIlllIl = "()";
            }
            else {
                lllllllllllllIlIlllIIIllllIlIlll = "([Ljava/lang/String;)";
                lllllllllllllIlIlllIIIllllIlIllI += this.compileStringParameter(lllllllllllllIlIlllIIIllllIlIIIl);
            }
            final String lllllllllllllIlIlllIIIllllIlIlIl = Descriptor.of(lllllllllllllIlIlllIIIllllIllIll);
            lllllllllllllIlIlllIIIllllIlIIIl.addInvokestatic(this.objectType, this.methodName, String.valueOf(new StringBuilder().append(lllllllllllllIlIlllIIIllllIlIlll).append(lllllllllllllIlIlllIIIllllIlIlIl)));
            lllllllllllllIlIlllIIIllllIlIIIl.addPutstatic(Bytecode.THIS, lllllllllllllIlIlllIIIllllIllIlI, lllllllllllllIlIlllIIIllllIlIlIl);
            return lllllllllllllIlIlllIIIllllIlIllI;
        }
        
        @Override
        int compile(final CtClass lllllllllllllIlIlllIIIllllllIIIl, final String lllllllllllllIlIlllIIIllllllIIII, final Bytecode lllllllllllllIlIlllIIIlllllIllll, final CtClass[] lllllllllllllIlIlllIIIllllllIlll, final Javac lllllllllllllIlIlllIIIllllllIllI) throws CannotCompileException {
            lllllllllllllIlIlllIIIlllllIllll.addAload(0);
            lllllllllllllIlIlllIIIlllllIllll.addAload(0);
            int lllllllllllllIlIlllIIIllllllIlIl = 0;
            if (this.stringParams == null) {
                final int lllllllllllllIlIlllIIIllllllllII = 2;
            }
            else {
                lllllllllllllIlIlllIIIllllllIlIl = this.compileStringParameter(lllllllllllllIlIlllIIIlllllIllll) + 2;
            }
            if (this.withConstructorParams) {
                lllllllllllllIlIlllIIIllllllIlIl += CtNewWrappedMethod.compileParameterList(lllllllllllllIlIlllIIIlllllIllll, lllllllllllllIlIlllIIIllllllIlll, 1);
            }
            final String lllllllllllllIlIlllIIIllllllIlII = Descriptor.of(lllllllllllllIlIlllIIIllllllIIIl);
            final String lllllllllllllIlIlllIIIllllllIIll = String.valueOf(new StringBuilder().append(this.getDescriptor()).append(lllllllllllllIlIlllIIIllllllIlII));
            lllllllllllllIlIlllIIIlllllIllll.addInvokestatic(this.objectType, this.methodName, lllllllllllllIlIlllIIIllllllIIll);
            lllllllllllllIlIlllIIIlllllIllll.addPutfield(Bytecode.THIS, lllllllllllllIlIlllIIIllllllIIII, lllllllllllllIlIlllIIIllllllIlII);
            return lllllllllllllIlIlllIIIllllllIlIl;
        }
        
        private String getDescriptor() {
            final String lllllllllllllIlIlllIIIlllllIIlll = "(Ljava/lang/Object;[Ljava/lang/String;[Ljava/lang/Object;)";
            if (this.stringParams == null) {
                if (this.withConstructorParams) {
                    return "(Ljava/lang/Object;[Ljava/lang/Object;)";
                }
                return "(Ljava/lang/Object;)";
            }
            else {
                if (this.withConstructorParams) {
                    return "(Ljava/lang/Object;[Ljava/lang/String;[Ljava/lang/Object;)";
                }
                return "(Ljava/lang/Object;[Ljava/lang/String;)";
            }
        }
    }
    
    static class NewInitializer extends Initializer
    {
        /* synthetic */ CtClass objectType;
        /* synthetic */ String[] stringParams;
        /* synthetic */ boolean withConstructorParams;
        
        @Override
        int compileIfStatic(final CtClass lllllllllllllIlIIlIIllIIIIlIIIIl, final String lllllllllllllIlIIlIIllIIIIlIIIII, final Bytecode lllllllllllllIlIIlIIllIIIIlIIllI, final Javac lllllllllllllIlIIlIIllIIIIlIIlIl) throws CannotCompileException {
            lllllllllllllIlIIlIIllIIIIlIIllI.addNew(this.objectType);
            lllllllllllllIlIIlIIllIIIIlIIllI.add(89);
            int lllllllllllllIlIIlIIllIIIIlIIIll = 2;
            String lllllllllllllIlIIlIIllIIIIlIIlII = null;
            if (this.stringParams == null) {
                final String lllllllllllllIlIIlIIllIIIIlIlIlI = "()V";
            }
            else {
                lllllllllllllIlIIlIIllIIIIlIIlII = "([Ljava/lang/String;)V";
                lllllllllllllIlIIlIIllIIIIlIIIll += this.compileStringParameter(lllllllllllllIlIIlIIllIIIIlIIllI);
            }
            lllllllllllllIlIIlIIllIIIIlIIllI.addInvokespecial(this.objectType, "<init>", lllllllllllllIlIIlIIllIIIIlIIlII);
            lllllllllllllIlIIlIIllIIIIlIIllI.addPutstatic(Bytecode.THIS, lllllllllllllIlIIlIIllIIIIlIIIII, Descriptor.of(lllllllllllllIlIIlIIllIIIIlIIIIl));
            return lllllllllllllIlIIlIIllIIIIlIIIll;
        }
        
        @Override
        int compile(final CtClass lllllllllllllIlIIlIIllIIIIlllIll, final String lllllllllllllIlIIlIIllIIIIlllIlI, final Bytecode lllllllllllllIlIIlIIllIIIlIIIIII, final CtClass[] lllllllllllllIlIIlIIllIIIIlllIII, final Javac lllllllllllllIlIIlIIllIIIIlllllI) throws CannotCompileException {
            lllllllllllllIlIIlIIllIIIlIIIIII.addAload(0);
            lllllllllllllIlIIlIIllIIIlIIIIII.addNew(this.objectType);
            lllllllllllllIlIIlIIllIIIlIIIIII.add(89);
            lllllllllllllIlIIlIIllIIIlIIIIII.addAload(0);
            int lllllllllllllIlIIlIIllIIIIllllIl = 0;
            if (this.stringParams == null) {
                final int lllllllllllllIlIIlIIllIIIlIIIlII = 4;
            }
            else {
                lllllllllllllIlIIlIIllIIIIllllIl = this.compileStringParameter(lllllllllllllIlIIlIIllIIIlIIIIII) + 4;
            }
            if (this.withConstructorParams) {
                lllllllllllllIlIIlIIllIIIIllllIl += CtNewWrappedMethod.compileParameterList(lllllllllllllIlIIlIIllIIIlIIIIII, lllllllllllllIlIIlIIllIIIIlllIII, 1);
            }
            lllllllllllllIlIIlIIllIIIlIIIIII.addInvokespecial(this.objectType, "<init>", this.getDescriptor());
            lllllllllllllIlIIlIIllIIIlIIIIII.addPutfield(Bytecode.THIS, lllllllllllllIlIIlIIllIIIIlllIlI, Descriptor.of(lllllllllllllIlIIlIIllIIIIlllIll));
            return lllllllllllllIlIIlIIllIIIIllllIl;
        }
        
        private String getDescriptor() {
            final String lllllllllllllIlIIlIIllIIIIllIIll = "(Ljava/lang/Object;[Ljava/lang/String;[Ljava/lang/Object;)V";
            if (this.stringParams == null) {
                if (this.withConstructorParams) {
                    return "(Ljava/lang/Object;[Ljava/lang/Object;)V";
                }
                return "(Ljava/lang/Object;)V";
            }
            else {
                if (this.withConstructorParams) {
                    return "(Ljava/lang/Object;[Ljava/lang/String;[Ljava/lang/Object;)V";
                }
                return "(Ljava/lang/Object;[Ljava/lang/String;)V";
            }
        }
        
        protected final int compileStringParameter(final Bytecode lllllllllllllIlIIlIIllIIIIIlIllI) throws CannotCompileException {
            final int lllllllllllllIlIIlIIllIIIIIlIlIl = this.stringParams.length;
            lllllllllllllIlIIlIIllIIIIIlIllI.addIconst(lllllllllllllIlIIlIIllIIIIIlIlIl);
            lllllllllllllIlIIlIIllIIIIIlIllI.addAnewarray("java.lang.String");
            for (int lllllllllllllIlIIlIIllIIIIIllIII = 0; lllllllllllllIlIIlIIllIIIIIllIII < lllllllllllllIlIIlIIllIIIIIlIlIl; ++lllllllllllllIlIIlIIllIIIIIllIII) {
                lllllllllllllIlIIlIIllIIIIIlIllI.add(89);
                lllllllllllllIlIIlIIllIIIIIlIllI.addIconst(lllllllllllllIlIIlIIllIIIIIllIII);
                lllllllllllllIlIIlIIllIIIIIlIllI.addLdc(this.stringParams[lllllllllllllIlIIlIIllIIIIIllIII]);
                lllllllllllllIlIIlIIllIIIIIlIllI.add(83);
            }
            return 4;
        }
    }
    
    static class IntInitializer extends Initializer
    {
        /* synthetic */ int value;
        
        @Override
        int getConstantValue(final ConstPool lllllllllllllllIlIIlllllIlIlIIll, final CtClass lllllllllllllllIlIIlllllIlIlIIlI) {
            return lllllllllllllllIlIIlllllIlIlIIll.addIntegerInfo(this.value);
        }
        
        @Override
        void check(final String lllllllllllllllIlIIllllllIIlIIII) throws CannotCompileException {
            final char lllllllllllllllIlIIllllllIIlIIlI = lllllllllllllllIlIIllllllIIlIIII.charAt(0);
            if (lllllllllllllllIlIIllllllIIlIIlI != 'I' && lllllllllllllllIlIIllllllIIlIIlI != 'S' && lllllllllllllllIlIIllllllIIlIIlI != 'B' && lllllllllllllllIlIIllllllIIlIIlI != 'C' && lllllllllllllllIlIIllllllIIlIIlI != 'Z') {
                throw new CannotCompileException("type mismatch");
            }
        }
        
        @Override
        int compile(final CtClass lllllllllllllllIlIIlllllIllllllI, final String lllllllllllllllIlIIlllllIlllllII, final Bytecode lllllllllllllllIlIIlllllIllllIll, final CtClass[] lllllllllllllllIlIIlllllIllllIlI, final Javac lllllllllllllllIlIIlllllIllllIIl) throws CannotCompileException {
            lllllllllllllllIlIIlllllIllllIll.addAload(0);
            lllllllllllllllIlIIlllllIllllIll.addIconst(this.value);
            lllllllllllllllIlIIlllllIllllIll.addPutfield(Bytecode.THIS, lllllllllllllllIlIIlllllIlllllII, Descriptor.of(lllllllllllllllIlIIlllllIllllllI));
            return 2;
        }
        
        @Override
        int compileIfStatic(final CtClass lllllllllllllllIlIIlllllIllIllII, final String lllllllllllllllIlIIlllllIllIlIlI, final Bytecode lllllllllllllllIlIIlllllIlIllllI, final Javac lllllllllllllllIlIIlllllIllIIllI) throws CannotCompileException {
            lllllllllllllllIlIIlllllIlIllllI.addIconst(this.value);
            lllllllllllllllIlIIlllllIlIllllI.addPutstatic(Bytecode.THIS, lllllllllllllllIlIIlllllIllIlIlI, Descriptor.of(lllllllllllllllIlIIlllllIllIllII));
            return 1;
        }
        
        IntInitializer(final int lllllllllllllllIlIIllllllIIllIll) {
            this.value = lllllllllllllllIlIIllllllIIllIll;
        }
    }
    
    static class ArrayInitializer extends Initializer
    {
        /* synthetic */ CtClass type;
        /* synthetic */ int size;
        
        ArrayInitializer(final CtClass llllllllllllllIIIlIlIllIIIIlIIII, final int llllllllllllllIIIlIlIllIIIIIllII) {
            this.type = llllllllllllllIIIlIlIllIIIIlIIII;
            this.size = llllllllllllllIIIlIlIllIIIIIllII;
        }
        
        @Override
        int compile(final CtClass llllllllllllllIIIlIlIllIIIIIIIII, final String llllllllllllllIIIlIlIlIllllllIIl, final Bytecode llllllllllllllIIIlIlIlIllllllIII, final CtClass[] llllllllllllllIIIlIlIlIlllllllIl, final Javac llllllllllllllIIIlIlIlIlllllllII) throws CannotCompileException {
            llllllllllllllIIIlIlIlIllllllIII.addAload(0);
            this.addNewarray(llllllllllllllIIIlIlIlIllllllIII);
            llllllllllllllIIIlIlIlIllllllIII.addPutfield(Bytecode.THIS, llllllllllllllIIIlIlIlIllllllIIl, Descriptor.of(llllllllllllllIIIlIlIllIIIIIIIII));
            return 2;
        }
        
        @Override
        int compileIfStatic(final CtClass llllllllllllllIIIlIlIlIllllIllIl, final String llllllllllllllIIIlIlIlIlllllIIIl, final Bytecode llllllllllllllIIIlIlIlIlllllIIII, final Javac llllllllllllllIIIlIlIlIllllIllll) throws CannotCompileException {
            this.addNewarray(llllllllllllllIIIlIlIlIlllllIIII);
            llllllllllllllIIIlIlIlIlllllIIII.addPutstatic(Bytecode.THIS, llllllllllllllIIIlIlIlIlllllIIIl, Descriptor.of(llllllllllllllIIIlIlIlIllllIllIl));
            return 1;
        }
        
        private void addNewarray(final Bytecode llllllllllllllIIIlIlIllIIIIIlIII) {
            if (this.type.isPrimitive()) {
                llllllllllllllIIIlIlIllIIIIIlIII.addNewarray(((CtPrimitiveType)this.type).getArrayType(), this.size);
            }
            else {
                llllllllllllllIIIlIlIllIIIIIlIII.addAnewarray(this.type, this.size);
            }
        }
    }
    
    static class ParamInitializer extends Initializer
    {
        /* synthetic */ int nthParam;
        
        static int nthParamToLocal(final int lllllllllllllIIIllIIIlIllllIIIIl, final CtClass[] lllllllllllllIIIllIIIlIllllIIllI, final boolean lllllllllllllIIIllIIIlIllllIIlIl) {
            final CtClass lllllllllllllIIIllIIIlIllllIIlII = CtClass.longType;
            final CtClass lllllllllllllIIIllIIIlIllllIIIll = CtClass.doubleType;
            int lllllllllllllIIIllIIIlIllllIIIlI = 0;
            if (lllllllllllllIIIllIIIlIllllIIlIl) {
                final int lllllllllllllIIIllIIIlIllllIlIlI = 0;
            }
            else {
                lllllllllllllIIIllIIIlIllllIIIlI = 1;
            }
            for (final CtClass lllllllllllllIIIllIIIlIllllIlIIl : lllllllllllllIIIllIIIlIllllIIllI) {
                if (lllllllllllllIIIllIIIlIllllIlIIl == lllllllllllllIIIllIIIlIllllIIlII || lllllllllllllIIIllIIIlIllllIlIIl == lllllllllllllIIIllIIIlIllllIIIll) {
                    lllllllllllllIIIllIIIlIllllIIIlI += 2;
                }
                else {
                    ++lllllllllllllIIIllIIIlIllllIIIlI;
                }
            }
            return lllllllllllllIIIllIIIlIllllIIIlI;
        }
        
        @Override
        int compileIfStatic(final CtClass lllllllllllllIIIllIIIlIlllIllIII, final String lllllllllllllIIIllIIIlIlllIlIlll, final Bytecode lllllllllllllIIIllIIIlIlllIlIllI, final Javac lllllllllllllIIIllIIIlIlllIlIlIl) throws CannotCompileException {
            return 0;
        }
        
        @Override
        int compile(final CtClass lllllllllllllIIIllIIIlIllllllllI, final String lllllllllllllIIIllIIIlIlllllllIl, final Bytecode lllllllllllllIIIllIIIlIlllllIllI, final CtClass[] lllllllllllllIIIllIIIlIlllllIlIl, final Javac lllllllllllllIIIllIIIlIllllllIlI) throws CannotCompileException {
            if (lllllllllllllIIIllIIIlIlllllIlIl != null && this.nthParam < lllllllllllllIIIllIIIlIlllllIlIl.length) {
                lllllllllllllIIIllIIIlIlllllIllI.addAload(0);
                final int lllllllllllllIIIllIIIllIIIIIIIIl = nthParamToLocal(this.nthParam, lllllllllllllIIIllIIIlIlllllIlIl, false);
                final int lllllllllllllIIIllIIIllIIIIIIIII = lllllllllllllIIIllIIIlIlllllIllI.addLoad(lllllllllllllIIIllIIIllIIIIIIIIl, lllllllllllllIIIllIIIlIllllllllI) + 1;
                lllllllllllllIIIllIIIlIlllllIllI.addPutfield(Bytecode.THIS, lllllllllllllIIIllIIIlIlllllllIl, Descriptor.of(lllllllllllllIIIllIIIlIllllllllI));
                return lllllllllllllIIIllIIIllIIIIIIIII;
            }
            return 0;
        }
    }
    
    static class CodeInitializer extends CodeInitializer0
    {
        private /* synthetic */ String expression;
        
        @Override
        int getConstantValue(final ConstPool llllllllllllllIIIIIlIllIIIlIIIlI, final CtClass llllllllllllllIIIIIlIllIIIlIIlII) {
            try {
                final ASTree llllllllllllllIIIIIlIllIIIlIlIII = Javac.parseExpr(this.expression, new SymbolTable());
                return this.getConstantValue2(llllllllllllllIIIIIlIllIIIlIIIlI, llllllllllllllIIIIIlIllIIIlIIlII, llllllllllllllIIIIIlIllIIIlIlIII);
            }
            catch (CompileError llllllllllllllIIIIIlIllIIIlIIlll) {
                return 0;
            }
        }
        
        CodeInitializer(final String llllllllllllllIIIIIlIllIIIllIlIl) {
            this.expression = llllllllllllllIIIIIlIllIIIllIlIl;
        }
        
        @Override
        void compileExpr(final Javac llllllllllllllIIIIIlIllIIIlIllll) throws CompileError {
            llllllllllllllIIIIIlIllIIIlIllll.compileExpr(this.expression);
        }
    }
    
    abstract static class CodeInitializer0 extends Initializer
    {
        @Override
        int compile(final CtClass lllllllllllllllIlIllIlIIlIIlIlII, final String lllllllllllllllIlIllIlIIlIIlIIll, final Bytecode lllllllllllllllIlIllIlIIlIIlIIlI, final CtClass[] lllllllllllllllIlIllIlIIlIIlIlll, final Javac lllllllllllllllIlIllIlIIlIIlIIIl) throws CannotCompileException {
            try {
                lllllllllllllllIlIllIlIIlIIlIIlI.addAload(0);
                this.compileExpr(lllllllllllllllIlIllIlIIlIIlIIIl);
                lllllllllllllllIlIllIlIIlIIlIIlI.addPutfield(Bytecode.THIS, lllllllllllllllIlIllIlIIlIIlIIll, Descriptor.of(lllllllllllllllIlIllIlIIlIIlIlII));
                return lllllllllllllllIlIllIlIIlIIlIIlI.getMaxStack();
            }
            catch (CompileError lllllllllllllllIlIllIlIIlIIlllII) {
                throw new CannotCompileException(lllllllllllllllIlIllIlIIlIIlllII);
            }
        }
        
        abstract void compileExpr(final Javac p0) throws CompileError;
        
        int getConstantValue2(final ConstPool lllllllllllllllIlIllIlIIIlllIllI, final CtClass lllllllllllllllIlIllIlIIIlllIIlI, final ASTree lllllllllllllllIlIllIlIIIlllIlII) {
            if (lllllllllllllllIlIllIlIIIlllIIlI.isPrimitive()) {
                if (lllllllllllllllIlIllIlIIIlllIlII instanceof IntConst) {
                    final long lllllllllllllllIlIllIlIIIllllIIl = ((IntConst)lllllllllllllllIlIllIlIIIlllIlII).get();
                    if (lllllllllllllllIlIllIlIIIlllIIlI == CtClass.doubleType) {
                        return lllllllllllllllIlIllIlIIIlllIllI.addDoubleInfo((double)lllllllllllllllIlIllIlIIIllllIIl);
                    }
                    if (lllllllllllllllIlIllIlIIIlllIIlI == CtClass.floatType) {
                        return lllllllllllllllIlIllIlIIIlllIllI.addFloatInfo((float)lllllllllllllllIlIllIlIIIllllIIl);
                    }
                    if (lllllllllllllllIlIllIlIIIlllIIlI == CtClass.longType) {
                        return lllllllllllllllIlIllIlIIIlllIllI.addLongInfo(lllllllllllllllIlIllIlIIIllllIIl);
                    }
                    if (lllllllllllllllIlIllIlIIIlllIIlI != CtClass.voidType) {
                        return lllllllllllllllIlIllIlIIIlllIllI.addIntegerInfo((int)lllllllllllllllIlIllIlIIIllllIIl);
                    }
                }
                else if (lllllllllllllllIlIllIlIIIlllIlII instanceof DoubleConst) {
                    final double lllllllllllllllIlIllIlIIIllllIII = ((DoubleConst)lllllllllllllllIlIllIlIIIlllIlII).get();
                    if (lllllllllllllllIlIllIlIIIlllIIlI == CtClass.floatType) {
                        return lllllllllllllllIlIllIlIIIlllIllI.addFloatInfo((float)lllllllllllllllIlIllIlIIIllllIII);
                    }
                    if (lllllllllllllllIlIllIlIIIlllIIlI == CtClass.doubleType) {
                        return lllllllllllllllIlIllIlIIIlllIllI.addDoubleInfo(lllllllllllllllIlIllIlIIIllllIII);
                    }
                }
            }
            else if (lllllllllllllllIlIllIlIIIlllIlII instanceof StringL && lllllllllllllllIlIllIlIIIlllIIlI.getName().equals("java.lang.String")) {
                return lllllllllllllllIlIllIlIIIlllIllI.addStringInfo(((StringL)lllllllllllllllIlIllIlIIIlllIlII).get());
            }
            return 0;
        }
        
        @Override
        int compileIfStatic(final CtClass lllllllllllllllIlIllIlIIlIIIIlll, final String lllllllllllllllIlIllIlIIlIIIIIIl, final Bytecode lllllllllllllllIlIllIlIIlIIIIIII, final Javac lllllllllllllllIlIllIlIIIlllllll) throws CannotCompileException {
            try {
                this.compileExpr(lllllllllllllllIlIllIlIIIlllllll);
                lllllllllllllllIlIllIlIIlIIIIIII.addPutstatic(Bytecode.THIS, lllllllllllllllIlIllIlIIlIIIIIIl, Descriptor.of(lllllllllllllllIlIllIlIIlIIIIlll));
                return lllllllllllllllIlIllIlIIlIIIIIII.getMaxStack();
            }
            catch (CompileError lllllllllllllllIlIllIlIIlIIIlIIl) {
                throw new CannotCompileException(lllllllllllllllIlIllIlIIlIIIlIIl);
            }
        }
    }
    
    static class PtreeInitializer extends CodeInitializer0
    {
        private /* synthetic */ ASTree expression;
        
        @Override
        int getConstantValue(final ConstPool lllllllllllllIlIIlIIllIIIllIllll, final CtClass lllllllllllllIlIIlIIllIIIllIlllI) {
            return this.getConstantValue2(lllllllllllllIlIIlIIllIIIllIllll, lllllllllllllIlIIlIIllIIIllIlllI, this.expression);
        }
        
        PtreeInitializer(final ASTree lllllllllllllIlIIlIIllIIIlllllll) {
            this.expression = lllllllllllllIlIIlIIllIIIlllllll;
        }
        
        @Override
        void compileExpr(final Javac lllllllllllllIlIIlIIllIIIlllIlll) throws CompileError {
            lllllllllllllIlIIlIIllIIIlllIlll.compileExpr(this.expression);
        }
    }
    
    static class MultiArrayInitializer extends Initializer
    {
        /* synthetic */ CtClass type;
        /* synthetic */ int[] dim;
        
        @Override
        int compileIfStatic(final CtClass llllllllllllllIlIlIIlIllIIIlIIIl, final String llllllllllllllIlIlIIlIllIIIIlIlI, final Bytecode llllllllllllllIlIlIIlIllIIIIllll, final Javac llllllllllllllIlIlIIlIllIIIIlllI) throws CannotCompileException {
            final int llllllllllllllIlIlIIlIllIIIIllIl = llllllllllllllIlIlIIlIllIIIIllll.addMultiNewarray(llllllllllllllIlIlIIlIllIIIlIIIl, this.dim);
            llllllllllllllIlIlIIlIllIIIIllll.addPutstatic(Bytecode.THIS, llllllllllllllIlIlIIlIllIIIIlIlI, Descriptor.of(llllllllllllllIlIlIIlIllIIIlIIIl));
            return llllllllllllllIlIlIIlIllIIIIllIl;
        }
        
        @Override
        int compile(final CtClass llllllllllllllIlIlIIlIllIIlIIIlI, final String llllllllllllllIlIlIIlIllIIIllIlI, final Bytecode llllllllllllllIlIlIIlIllIIIllIIl, final CtClass[] llllllllllllllIlIlIIlIllIIIlllll, final Javac llllllllllllllIlIlIIlIllIIIllllI) throws CannotCompileException {
            llllllllllllllIlIlIIlIllIIIllIIl.addAload(0);
            final int llllllllllllllIlIlIIlIllIIIlllIl = llllllllllllllIlIlIIlIllIIIllIIl.addMultiNewarray(llllllllllllllIlIlIIlIllIIlIIIlI, this.dim);
            llllllllllllllIlIlIIlIllIIIllIIl.addPutfield(Bytecode.THIS, llllllllllllllIlIlIIlIllIIIllIlI, Descriptor.of(llllllllllllllIlIlIIlIllIIlIIIlI));
            return llllllllllllllIlIlIIlIllIIIlllIl + 1;
        }
        
        @Override
        void check(final String llllllllllllllIlIlIIlIllIIlIlIlI) throws CannotCompileException {
            if (llllllllllllllIlIlIIlIllIIlIlIlI.charAt(0) != '[') {
                throw new CannotCompileException("type mismatch");
            }
        }
        
        MultiArrayInitializer(final CtClass llllllllllllllIlIlIIlIllIIllIIIl, final int[] llllllllllllllIlIlIIlIllIIlIllIl) {
            this.type = llllllllllllllIlIlIIlIllIIllIIIl;
            this.dim = llllllllllllllIlIlIIlIllIIlIllIl;
        }
    }
}
