package com.viaversion.viaversion.libs.javassist.bytecode.stackmap;

import com.viaversion.viaversion.libs.javassist.*;
import com.viaversion.viaversion.libs.javassist.bytecode.*;
import java.util.*;

public abstract class TypeData
{
    public boolean isNullType() {
        return false;
    }
    
    public abstract int getTypeData(final ConstPool p0);
    
    public static CtClass commonSuperClass(final CtClass llllllllllllllIlllIIIllIIIIlIIII, final CtClass llllllllllllllIlllIIIllIIIIIllll) throws NotFoundException {
        CtClass llllllllllllllIlllIIIllIIIIIlllI = llllllllllllllIlllIIIllIIIIlIIII;
        CtClass llllllllllllllIlllIIIllIIIIIllII;
        CtClass llllllllllllllIlllIIIllIIIIIllIl = llllllllllllllIlllIIIllIIIIIllII = llllllllllllllIlllIIIllIIIIIllll;
        CtClass llllllllllllllIlllIIIllIIIIIlIll = llllllllllllllIlllIIIllIIIIIlllI;
        while (!eq(llllllllllllllIlllIIIllIIIIIlllI, llllllllllllllIlllIIIllIIIIIllIl) || llllllllllllllIlllIIIllIIIIIlllI.getSuperclass() == null) {
            final CtClass llllllllllllllIlllIIIllIIIIlIIlI = llllllllllllllIlllIIIllIIIIIlllI.getSuperclass();
            final CtClass llllllllllllllIlllIIIllIIIIlIIIl = llllllllllllllIlllIIIllIIIIIllIl.getSuperclass();
            if (llllllllllllllIlllIIIllIIIIlIIIl == null) {
                llllllllllllllIlllIIIllIIIIIllIl = llllllllllllllIlllIIIllIIIIIllII;
            }
            else {
                if (llllllllllllllIlllIIIllIIIIlIIlI != null) {
                    llllllllllllllIlllIIIllIIIIIlllI = llllllllllllllIlllIIIllIIIIlIIlI;
                    llllllllllllllIlllIIIllIIIIIllIl = llllllllllllllIlllIIIllIIIIlIIIl;
                    continue;
                }
                llllllllllllllIlllIIIllIIIIIlllI = llllllllllllllIlllIIIllIIIIIlIll;
                llllllllllllllIlllIIIllIIIIIlIll = llllllllllllllIlllIIIllIIIIIllII;
                llllllllllllllIlllIIIllIIIIIllII = llllllllllllllIlllIIIllIIIIIlllI;
                llllllllllllllIlllIIIllIIIIIlllI = llllllllllllllIlllIIIllIIIIIllIl;
                llllllllllllllIlllIIIllIIIIIllIl = llllllllllllllIlllIIIllIIIIIllII;
            }
            while (true) {
                llllllllllllllIlllIIIllIIIIIlllI = llllllllllllllIlllIIIllIIIIIlllI.getSuperclass();
                if (llllllllllllllIlllIIIllIIIIIlllI == null) {
                    break;
                }
                llllllllllllllIlllIIIllIIIIIlIll = llllllllllllllIlllIIIllIIIIIlIll.getSuperclass();
            }
            for (llllllllllllllIlllIIIllIIIIIlllI = llllllllllllllIlllIIIllIIIIIlIll; !eq(llllllllllllllIlllIIIllIIIIIlllI, llllllllllllllIlllIIIllIIIIIllIl); llllllllllllllIlllIIIllIIIIIlllI = llllllllllllllIlllIIIllIIIIIlllI.getSuperclass(), llllllllllllllIlllIIIllIIIIIllIl = llllllllllllllIlllIIIllIIIIIllIl.getSuperclass()) {}
            return llllllllllllllIlllIIIllIIIIIlllI;
        }
        return llllllllllllllIlllIIIllIIIIIlllI;
    }
    
    public static TypeData[] make(final int llllllllllllllIlllIIIllIIlIIllII) {
        final TypeData[] llllllllllllllIlllIIIllIIlIIlIll = new TypeData[llllllllllllllIlllIIIllIIlIIllII];
        for (int llllllllllllllIlllIIIllIIlIIllIl = 0; llllllllllllllIlllIIIllIIlIIllIl < llllllllllllllIlllIIIllIIlIIllII; ++llllllllllllllIlllIIIllIIlIIllIl) {
            llllllllllllllIlllIIIllIIlIIlIll[llllllllllllllIlllIIIllIIlIIllIl] = TypeTag.TOP;
        }
        return llllllllllllllIlllIIIllIIlIIlIll;
    }
    
    static boolean eq(final CtClass llllllllllllllIlllIIIlIllllllllI, final CtClass llllllllllllllIlllIIIlIlllllllll) {
        return llllllllllllllIlllIIIlIllllllllI == llllllllllllllIlllIIIlIlllllllll || (llllllllllllllIlllIIIlIllllllllI != null && llllllllllllllIlllIIIlIlllllllll != null && llllllllllllllIlllIIIlIllllllllI.getName().equals(llllllllllllllIlllIIIlIlllllllll.getName()));
    }
    
    public static void aastore(final TypeData llllllllllllllIlllIIIlIlllllIlII, final TypeData llllllllllllllIlllIIIlIlllllIllI, final ClassPool llllllllllllllIlllIIIlIlllllIIlI) throws BadBytecode {
        if (llllllllllllllIlllIIIlIlllllIlII instanceof AbsTypeVar && !llllllllllllllIlllIIIlIlllllIllI.isNullType()) {
            ((AbsTypeVar)llllllllllllllIlllIIIlIlllllIlII).merge(ArrayType.make(llllllllllllllIlllIIIlIlllllIllI));
        }
        if (llllllllllllllIlllIIIlIlllllIllI instanceof AbsTypeVar) {
            if (llllllllllllllIlllIIIlIlllllIlII instanceof AbsTypeVar) {
                ArrayElement.make(llllllllllllllIlllIIIlIlllllIlII);
            }
            else {
                if (!(llllllllllllllIlllIIIlIlllllIlII instanceof ClassName)) {
                    throw new BadBytecode(String.valueOf(new StringBuilder().append("bad AASTORE: ").append(llllllllllllllIlllIIIlIlllllIlII)));
                }
                if (!llllllllllllllIlllIIIlIlllllIlII.isNullType()) {
                    final String llllllllllllllIlllIIIlIllllllIII = typeName(llllllllllllllIlllIIIlIlllllIlII.getName());
                    llllllllllllllIlllIIIlIlllllIllI.setType(llllllllllllllIlllIIIlIllllllIII, llllllllllllllIlllIIIlIlllllIIlI);
                }
            }
        }
    }
    
    public boolean isUninit() {
        return false;
    }
    
    public TypeData join() {
        return new TypeVar(this);
    }
    
    public abstract boolean eq(final TypeData p0);
    
    public void constructorCalled(final int llllllllllllllIlllIIIllIIIlIllIl) {
    }
    
    protected TypeData() {
    }
    
    public abstract void setType(final String p0, final ClassPool p1) throws BadBytecode;
    
    protected TypeVar toTypeVar(final int llllllllllllllIlllIIIllIIIlIllll) {
        return null;
    }
    
    private static void setType(final TypeData llllllllllllllIlllIIIllIIIlllllI, final String llllllllllllllIlllIIIllIIlIIIIII, final ClassPool llllllllllllllIlllIIIllIIIllllII) throws BadBytecode {
        llllllllllllllIlllIIIllIIIlllllI.setType(llllllllllllllIlllIIIllIIlIIIIII, llllllllllllllIlllIIIllIIIllllII);
    }
    
    public abstract BasicType isBasicType();
    
    abstract String toString2(final Set<TypeData> p0);
    
    public abstract String getName();
    
    public abstract int getTypeTag();
    
    public abstract TypeData getArrayType(final int p0) throws NotFoundException;
    
    public abstract boolean is2WordType();
    
    public static CtClass commonSuperClassEx(final CtClass llllllllllllllIlllIIIllIIIlIIIIl, final CtClass llllllllllllllIlllIIIllIIIlIIIII) throws NotFoundException {
        if (llllllllllllllIlllIIIllIIIlIIIIl == llllllllllllllIlllIIIllIIIlIIIII) {
            return llllllllllllllIlllIIIllIIIlIIIIl;
        }
        if (llllllllllllllIlllIIIllIIIlIIIIl.isArray() && llllllllllllllIlllIIIllIIIlIIIII.isArray()) {
            final CtClass llllllllllllllIlllIIIllIIIlIIlII = llllllllllllllIlllIIIllIIIlIIIIl.getComponentType();
            final CtClass llllllllllllllIlllIIIllIIIlIIIll = llllllllllllllIlllIIIllIIIlIIIII.getComponentType();
            final CtClass llllllllllllllIlllIIIllIIIlIIIlI = commonSuperClassEx(llllllllllllllIlllIIIllIIIlIIlII, llllllllllllllIlllIIIllIIIlIIIll);
            if (llllllllllllllIlllIIIllIIIlIIIlI == llllllllllllllIlllIIIllIIIlIIlII) {
                return llllllllllllllIlllIIIllIIIlIIIIl;
            }
            if (llllllllllllllIlllIIIllIIIlIIIlI == llllllllllllllIlllIIIllIIIlIIIll) {
                return llllllllllllllIlllIIIllIIIlIIIII;
            }
            return llllllllllllllIlllIIIllIIIlIIIIl.getClassPool().get((llllllllllllllIlllIIIllIIIlIIIlI == null) ? "java.lang.Object" : String.valueOf(new StringBuilder().append(llllllllllllllIlllIIIllIIIlIIIlI.getName()).append("[]")));
        }
        else {
            if (llllllllllllllIlllIIIllIIIlIIIIl.isPrimitive() || llllllllllllllIlllIIIllIIIlIIIII.isPrimitive()) {
                return null;
            }
            if (llllllllllllllIlllIIIllIIIlIIIIl.isArray() || llllllllllllllIlllIIIllIIIlIIIII.isArray()) {
                return llllllllllllllIlllIIIllIIIlIIIIl.getClassPool().get("java.lang.Object");
            }
            return commonSuperClass(llllllllllllllIlllIIIllIIIlIIIIl, llllllllllllllIlllIIIllIIIlIIIII);
        }
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append(super.toString()).append("(").append(this.toString2(new HashSet<TypeData>())).append(")"));
    }
    
    public int dfs(final List<TypeData> llllllllllllllIlllIIIllIIIllIlII, final int llllllllllllllIlllIIIllIIIllIIll, final ClassPool llllllllllllllIlllIIIllIIIllIIlI) throws NotFoundException {
        return llllllllllllllIlllIIIllIIIllIIll;
    }
    
    public static class UninitTypeVar extends AbsTypeVar
    {
        protected /* synthetic */ TypeData type;
        
        @Override
        protected TypeVar toTypeVar(final int lllllllllllllIIIllIllIIIIlIIllIl) {
            return null;
        }
        
        @Override
        public TypeData join() {
            return this.type.join();
        }
        
        @Override
        public String getName() {
            return this.type.getName();
        }
        
        @Override
        public boolean isUninit() {
            return this.type.isUninit();
        }
        
        @Override
        public int getTypeData(final ConstPool lllllllllllllIIIllIllIIIIllIIIll) {
            return this.type.getTypeData(lllllllllllllIIIllIllIIIIllIIIll);
        }
        
        public int offset() {
            if (this.type instanceof UninitData) {
                return ((UninitData)this.type).offset;
            }
            throw new RuntimeException("not available");
        }
        
        @Override
        public void merge(final TypeData lllllllllllllIIIllIllIIIIIlllIll) {
            if (!lllllllllllllIIIllIllIIIIIlllIll.eq(this.type)) {
                this.type = TypeTag.TOP;
            }
        }
        
        @Override
        public void setType(final String lllllllllllllIIIllIllIIIIlIIIIlI, final ClassPool lllllllllllllIIIllIllIIIIlIIIIIl) throws BadBytecode {
            this.type.setType(lllllllllllllIIIllIllIIIIlIIIIlI, lllllllllllllIIIllIllIIIIlIIIIIl);
        }
        
        @Override
        public int getTypeTag() {
            return this.type.getTypeTag();
        }
        
        @Override
        public void constructorCalled(final int lllllllllllllIIIllIllIIIIIllIlll) {
            this.type.constructorCalled(lllllllllllllIIIllIllIIIIIllIlll);
        }
        
        @Override
        String toString2(final Set<TypeData> lllllllllllllIIIllIllIIIIIlIlIlI) {
            return "";
        }
        
        @Override
        public boolean is2WordType() {
            return this.type.is2WordType();
        }
        
        @Override
        public BasicType isBasicType() {
            return this.type.isBasicType();
        }
        
        @Override
        public boolean eq(final TypeData lllllllllllllIIIllIllIIIIlIlIlII) {
            return this.type.eq(lllllllllllllIIIllIllIIIIlIlIlII);
        }
        
        @Override
        public TypeData getArrayType(final int lllllllllllllIIIllIllIIIIIlIlllI) throws NotFoundException {
            return this.type.getArrayType(lllllllllllllIIIllIllIIIIIlIlllI);
        }
    }
    
    public abstract static class AbsTypeVar extends TypeData
    {
        @Override
        public int getTypeTag() {
            return 7;
        }
        
        @Override
        public int getTypeData(final ConstPool lllllllllllllIIlIIlIllIlIIIllIII) {
            return lllllllllllllIIlIIlIllIlIIIllIII.addClassInfo(this.getName());
        }
        
        public abstract void merge(final TypeData p0);
        
        @Override
        public boolean eq(final TypeData lllllllllllllIIlIIlIllIlIIIlIlII) {
            if (lllllllllllllIIlIIlIllIlIIIlIlII.isUninit()) {
                return lllllllllllllIIlIIlIllIlIIIlIlII.eq(this);
            }
            return this.getName().equals(lllllllllllllIIlIIlIllIlIIIlIlII.getName());
        }
    }
    
    public static class UninitData extends ClassName
    {
        /* synthetic */ boolean initialized;
        /* synthetic */ int offset;
        
        @Override
        String toString2(final Set<TypeData> lllllllllllllIIIlIIllIlIlllIIIll) {
            return String.valueOf(new StringBuilder().append(this.getName()).append(",").append(this.offset));
        }
        
        @Override
        public int getTypeData(final ConstPool lllllllllllllIIIlIIllIlIllllllIl) {
            return this.offset;
        }
        
        UninitData(final int lllllllllllllIIIlIIllIllIIIIlIII, final String lllllllllllllIIIlIIllIllIIIIIlII) {
            super(lllllllllllllIIIlIIllIllIIIIIlII);
            this.offset = lllllllllllllIIIlIIllIllIIIIlIII;
            this.initialized = false;
        }
        
        public int offset() {
            return this.offset;
        }
        
        public UninitData copy() {
            return new UninitData(this.offset, this.getName());
        }
        
        @Override
        public boolean eq(final TypeData lllllllllllllIIIlIIllIlIllllIIlI) {
            if (lllllllllllllIIIlIIllIlIllllIIlI instanceof UninitData) {
                final UninitData lllllllllllllIIIlIIllIlIllllIlII = (UninitData)lllllllllllllIIIlIIllIlIllllIIlI;
                return this.offset == lllllllllllllIIIlIIllIlIllllIlII.offset && this.getName().equals(lllllllllllllIIIlIIllIlIllllIlII.getName());
            }
            return false;
        }
        
        @Override
        public TypeData join() {
            if (this.initialized) {
                return new TypeVar(new ClassName(this.getName()));
            }
            return new UninitTypeVar(this.copy());
        }
        
        @Override
        public void constructorCalled(final int lllllllllllllIIIlIIllIlIlllIIllI) {
            if (lllllllllllllIIIlIIllIlIlllIIllI == this.offset) {
                this.initialized = true;
            }
        }
        
        @Override
        public boolean isUninit() {
            return true;
        }
        
        @Override
        public int getTypeTag() {
            return 8;
        }
    }
    
    public static class ClassName extends TypeData
    {
        private /* synthetic */ String name;
        
        @Override
        String toString2(final Set<TypeData> lllllllllllllllIlIlllIlIllllllll) {
            return this.name;
        }
        
        @Override
        public TypeData getArrayType(final int lllllllllllllllIlIlllIllIIIIIllI) throws NotFoundException {
            if (lllllllllllllllIlIlllIllIIIIIllI == 0) {
                return this;
            }
            if (lllllllllllllllIlIlllIllIIIIIllI > 0) {
                final char[] lllllllllllllllIlIlllIllIIIIlIll = new char[lllllllllllllllIlIlllIllIIIIIllI];
                for (int lllllllllllllllIlIlllIllIIIIllII = 0; lllllllllllllllIlIlllIllIIIIllII < lllllllllllllllIlIlllIllIIIIIllI; ++lllllllllllllllIlIlllIllIIIIllII) {
                    lllllllllllllllIlIlllIllIIIIlIll[lllllllllllllllIlIlllIllIIIIllII] = '[';
                }
                String lllllllllllllllIlIlllIllIIIIlIlI = this.getName();
                if (lllllllllllllllIlIlllIllIIIIlIlI.charAt(0) != '[') {
                    lllllllllllllllIlIlllIllIIIIlIlI = String.valueOf(new StringBuilder().append("L").append(lllllllllllllllIlIlllIllIIIIlIlI.replace('.', '/')).append(";"));
                }
                return new ClassName(String.valueOf(new StringBuilder().append(new String(lllllllllllllllIlIlllIllIIIIlIll)).append(lllllllllllllllIlIlllIllIIIIlIlI)));
            }
            for (int lllllllllllllllIlIlllIllIIIIlIIl = 0; lllllllllllllllIlIlllIllIIIIlIIl < -lllllllllllllllIlIlllIllIIIIIllI; ++lllllllllllllllIlIlllIllIIIIlIIl) {
                if (this.name.charAt(lllllllllllllllIlIlllIllIIIIlIIl) != '[') {
                    throw new NotFoundException(String.valueOf(new StringBuilder().append("no ").append(lllllllllllllllIlIlllIllIIIIIllI).append(" dimensional array type: ").append(this.getName())));
                }
            }
            final char lllllllllllllllIlIlllIllIIIIlIII = this.name.charAt(-lllllllllllllllIlIlllIllIIIIIllI);
            if (lllllllllllllllIlIlllIllIIIIlIII == '[') {
                return new ClassName(this.name.substring(-lllllllllllllllIlIlllIllIIIIIllI));
            }
            if (lllllllllllllllIlIlllIllIIIIlIII == 'L') {
                return new ClassName(this.name.substring(-lllllllllllllllIlIlllIllIIIIIllI + 1, this.name.length() - 1).replace('/', '.'));
            }
            if (lllllllllllllllIlIlllIllIIIIlIII == TypeTag.DOUBLE.decodedName) {
                return TypeTag.DOUBLE;
            }
            if (lllllllllllllllIlIlllIllIIIIlIII == TypeTag.FLOAT.decodedName) {
                return TypeTag.FLOAT;
            }
            if (lllllllllllllllIlIlllIllIIIIlIII == TypeTag.LONG.decodedName) {
                return TypeTag.LONG;
            }
            return TypeTag.INTEGER;
        }
        
        @Override
        public String getName() {
            return this.name;
        }
        
        @Override
        public boolean eq(final TypeData lllllllllllllllIlIlllIllIIIlIllI) {
            if (lllllllllllllllIlIlllIllIIIlIllI.isUninit()) {
                return lllllllllllllllIlIlllIllIIIlIllI.eq(this);
            }
            return this.name.equals(lllllllllllllllIlIlllIllIIIlIllI.getName());
        }
        
        @Override
        public int getTypeTag() {
            return 7;
        }
        
        @Override
        public int getTypeData(final ConstPool lllllllllllllllIlIlllIllIIIlllII) {
            return lllllllllllllllIlIlllIllIIIlllII.addClassInfo(this.getName());
        }
        
        @Override
        public boolean is2WordType() {
            return false;
        }
        
        public ClassName(final String lllllllllllllllIllIIIIIllllIllIl) {
            this.name = lllllllllllllllIllIIIIIllllIllIl;
        }
        
        @Override
        public BasicType isBasicType() {
            return null;
        }
        
        @Override
        public void setType(final String lllllllllllllllIlIlllIllIIIlIIlI, final ClassPool lllllllllllllllIlIlllIllIIIlIIIl) throws BadBytecode {
        }
    }
    
    protected static class BasicType extends TypeData
    {
        private /* synthetic */ String name;
        private /* synthetic */ int typeTag;
        private /* synthetic */ char decodedName;
        
        @Override
        public boolean is2WordType() {
            return this.typeTag == 4 || this.typeTag == 3;
        }
        
        @Override
        public void setType(final String lllllllllllllIlIIlIIIlllIlIllIll, final ClassPool lllllllllllllIlIIlIIIlllIlIllIlI) throws BadBytecode {
            throw new BadBytecode(String.valueOf(new StringBuilder().append("conflict: ").append(this.name).append(" and ").append(lllllllllllllIlIIlIIIlllIlIllIll)));
        }
        
        @Override
        public int getTypeData(final ConstPool lllllllllllllIlIIlIIIlllIlllIlII) {
            return 0;
        }
        
        @Override
        String toString2(final Set<TypeData> lllllllllllllIlIIlIIIlllIlIIlIIl) {
            return this.name;
        }
        
        @Override
        public TypeData getArrayType(final int lllllllllllllIlIIlIIIlllIlIIlllI) throws NotFoundException {
            if (this == TypeTag.TOP) {
                return this;
            }
            if (lllllllllllllIlIIlIIIlllIlIIlllI < 0) {
                throw new NotFoundException(String.valueOf(new StringBuilder().append("no element type: ").append(this.name)));
            }
            if (lllllllllllllIlIIlIIIlllIlIIlllI == 0) {
                return this;
            }
            final char[] lllllllllllllIlIIlIIIlllIlIlIIlI = new char[lllllllllllllIlIIlIIIlllIlIIlllI + 1];
            for (int lllllllllllllIlIIlIIIlllIlIlIIll = 0; lllllllllllllIlIIlIIIlllIlIlIIll < lllllllllllllIlIIlIIIlllIlIIlllI; ++lllllllllllllIlIIlIIIlllIlIlIIll) {
                lllllllllllllIlIIlIIIlllIlIlIIlI[lllllllllllllIlIIlIIIlllIlIlIIll] = '[';
            }
            lllllllllllllIlIIlIIIlllIlIlIIlI[lllllllllllllIlIIlIIIlllIlIIlllI] = this.decodedName;
            return new ClassName(new String(lllllllllllllIlIIlIIIlllIlIlIIlI));
        }
        
        @Override
        public boolean eq(final TypeData lllllllllllllIlIIlIIIlllIllIIlIl) {
            return this == lllllllllllllIlIIlIIIlllIllIIlIl;
        }
        
        @Override
        public TypeData join() {
            if (this == TypeTag.TOP) {
                return this;
            }
            return super.join();
        }
        
        @Override
        public String getName() {
            return this.name;
        }
        
        @Override
        public BasicType isBasicType() {
            return this;
        }
        
        public BasicType(final String lllllllllllllIlIIlIIIlllIllllIll, final int lllllllllllllIlIIlIIIlllIllllIlI, final char lllllllllllllIlIIlIIIlllIlllllIl) {
            this.name = lllllllllllllIlIIlIIIlllIllllIll;
            this.typeTag = lllllllllllllIlIIlIIIlllIllllIlI;
            this.decodedName = lllllllllllllIlIIlIIIlllIlllllIl;
        }
        
        @Override
        public int getTypeTag() {
            return this.typeTag;
        }
        
        public char getDecodedName() {
            return this.decodedName;
        }
    }
    
    public static class TypeVar extends AbsTypeVar
    {
        private /* synthetic */ boolean is2WordType;
        protected /* synthetic */ String fixedType;
        private /* synthetic */ int smallest;
        protected /* synthetic */ List<TypeData> lowers;
        private /* synthetic */ boolean inList;
        protected /* synthetic */ List<String> uppers;
        protected /* synthetic */ List<TypeData> usedBy;
        private /* synthetic */ int dimension;
        private /* synthetic */ int visited;
        
        @Override
        public BasicType isBasicType() {
            if (this.fixedType == null) {
                return this.lowers.get(0).isBasicType();
            }
            return null;
        }
        
        @Override
        public void setType(final String lllllllllllllllIlIIlIlIIIIIlllII, final ClassPool lllllllllllllllIlIIlIlIIIIIllIll) throws BadBytecode {
            if (this.uppers == null) {
                this.uppers = new ArrayList<String>();
            }
            this.uppers.add(lllllllllllllllIlIIlIlIIIIIlllII);
        }
        
        private void fixTypes1(final List<TypeData> lllllllllllllllIlIIlIIlllIlllIlI, final TypeData lllllllllllllllIlIIlIIlllIlllIIl) throws NotFoundException {
            for (int lllllllllllllllIlIIlIIlllIlllIII = lllllllllllllllIlIIlIIlllIlllIlI.size(), lllllllllllllllIlIIlIIlllIllllII = 0; lllllllllllllllIlIIlIIlllIllllII < lllllllllllllllIlIIlIIlllIlllIII; ++lllllllllllllllIlIIlIIlllIllllII) {
                final TypeVar lllllllllllllllIlIIlIIlllIlllllI = lllllllllllllllIlIIlIIlllIlllIlI.get(lllllllllllllllIlIIlIIlllIllllII);
                final TypeData lllllllllllllllIlIIlIIlllIllllIl = lllllllllllllllIlIIlIIlllIlllIIl.getArrayType(-lllllllllllllllIlIIlIIlllIlllllI.dimension);
                if (lllllllllllllllIlIIlIIlllIllllIl.isBasicType() == null) {
                    lllllllllllllllIlIIlIIlllIlllllI.fixedType = lllllllllllllllIlIIlIIlllIllllIl.getName();
                }
                else {
                    lllllllllllllllIlIIlIIlllIlllllI.lowers.clear();
                    lllllllllllllllIlIIlIIlllIlllllI.lowers.add(lllllllllllllllIlIIlIIlllIllllIl);
                    lllllllllllllllIlIIlIIlllIlllllI.is2WordType = lllllllllllllllIlIIlIIlllIllllIl.is2WordType();
                }
            }
        }
        
        @Override
        public void merge(final TypeData lllllllllllllllIlIIlIlIIIIlIlIll) {
            this.lowers.add(lllllllllllllllIlIIlIlIIIIlIlIll);
            if (lllllllllllllllIlIIlIlIIIIlIlIll instanceof TypeVar) {
                ((TypeVar)lllllllllllllllIlIIlIlIIIIlIlIll).usedBy.add(this);
            }
        }
        
        @Override
        public TypeData getArrayType(final int lllllllllllllllIlIIlIlIIIIIIlIll) throws NotFoundException {
            if (lllllllllllllllIlIIlIlIIIIIIlIll == 0) {
                return this;
            }
            final BasicType lllllllllllllllIlIIlIlIIIIIIllIl = this.isBasicType();
            if (lllllllllllllllIlIIlIlIIIIIIllIl != null) {
                return lllllllllllllllIlIIlIlIIIIIIllIl.getArrayType(lllllllllllllllIlIIlIlIIIIIIlIll);
            }
            if (this.isNullType()) {
                return new NullType();
            }
            return new ClassName(this.getName()).getArrayType(lllllllllllllllIlIIlIlIIIIIIlIll);
        }
        
        private CtClass fixByUppers(final List<TypeData> lllllllllllllllIlIIlIIlllIIIlIll, final ClassPool lllllllllllllllIlIIlIIlllIIIIlII, final Set<TypeData> lllllllllllllllIlIIlIIlllIIIIIll, CtClass lllllllllllllllIlIIlIIlllIIIIIlI) throws NotFoundException {
            if (lllllllllllllllIlIIlIIlllIIIlIll == null) {
                return (CtClass)lllllllllllllllIlIIlIIlllIIIIIlI;
            }
            for (int lllllllllllllllIlIIlIIlllIIIIlll = lllllllllllllllIlIIlIIlllIIIlIll.size(), lllllllllllllllIlIIlIIlllIIIllIl = 0; lllllllllllllllIlIIlIIlllIIIllIl < lllllllllllllllIlIIlIIlllIIIIlll; ++lllllllllllllllIlIIlIIlllIIIllIl) {
                final TypeVar lllllllllllllllIlIIlIIlllIIIlllI = lllllllllllllllIlIIlIIlllIIIlIll.get(lllllllllllllllIlIIlIIlllIIIllIl);
                if (!lllllllllllllllIlIIlIIlllIIIIIll.add(lllllllllllllllIlIIlIIlllIIIlllI)) {
                    return (CtClass)lllllllllllllllIlIIlIIlllIIIIIlI;
                }
                if (lllllllllllllllIlIIlIIlllIIIlllI.uppers != null) {
                    for (int lllllllllllllllIlIIlIIlllIIIllll = lllllllllllllllIlIIlIIlllIIIlllI.uppers.size(), lllllllllllllllIlIIlIIlllIIlIIII = 0; lllllllllllllllIlIIlIIlllIIlIIII < lllllllllllllllIlIIlIIlllIIIllll; ++lllllllllllllllIlIIlIIlllIIlIIII) {
                        final CtClass lllllllllllllllIlIIlIIlllIIlIIIl = lllllllllllllllIlIIlIIlllIIIIlII.get(lllllllllllllllIlIIlIIlllIIIlllI.uppers.get(lllllllllllllllIlIIlIIlllIIlIIII));
                        if (lllllllllllllllIlIIlIIlllIIlIIIl.subtypeOf((CtClass)lllllllllllllllIlIIlIIlllIIIIIlI)) {
                            lllllllllllllllIlIIlIIlllIIIIIlI = lllllllllllllllIlIIlIIlllIIlIIIl;
                        }
                    }
                }
                lllllllllllllllIlIIlIIlllIIIIIlI = this.fixByUppers(lllllllllllllllIlIIlIIlllIIIlllI.usedBy, lllllllllllllllIlIIlIIlllIIIIlII, lllllllllllllllIlIIlIIlllIIIIIll, (CtClass)lllllllllllllllIlIIlIIlllIIIIIlI);
            }
            return (CtClass)lllllllllllllllIlIIlIIlllIIIIIlI;
        }
        
        @Override
        public boolean isUninit() {
            return this.fixedType == null && this.lowers.get(0).isUninit();
        }
        
        @Override
        protected TypeVar toTypeVar(final int lllllllllllllllIlIIlIlIIIIIlIIll) {
            this.dimension = lllllllllllllllIlIIlIlIIIIIlIIll;
            return this;
        }
        
        @Override
        public int getTypeTag() {
            if (this.fixedType == null) {
                return this.lowers.get(0).getTypeTag();
            }
            return super.getTypeTag();
        }
        
        private void fixTypes(final List<TypeData> lllllllllllllllIlIIlIIllllIllIIl, final ClassPool lllllllllllllllIlIIlIIllllIlIIIl) throws NotFoundException {
            final Set<String> lllllllllllllllIlIIlIIllllIlIlll = new HashSet<String>();
            boolean lllllllllllllllIlIIlIIllllIlIllI = false;
            TypeData lllllllllllllllIlIIlIIllllIlIlIl = null;
            for (int lllllllllllllllIlIIlIIllllIlIlII = lllllllllllllllIlIIlIIllllIllIIl.size(), lllllllllllllllIlIIlIIllllIlllII = 0; lllllllllllllllIlIIlIIllllIlllII < lllllllllllllllIlIIlIIllllIlIlII; ++lllllllllllllllIlIIlIIllllIlllII) {
                final TypeVar lllllllllllllllIlIIlIIllllIlllll = lllllllllllllllIlIIlIIllllIllIIl.get(lllllllllllllllIlIIlIIllllIlllII);
                final List<TypeData> lllllllllllllllIlIIlIIllllIllllI = lllllllllllllllIlIIlIIllllIlllll.lowers;
                for (int lllllllllllllllIlIIlIIllllIlllIl = lllllllllllllllIlIIlIIllllIllllI.size(), lllllllllllllllIlIIlIIlllllIIIII = 0; lllllllllllllllIlIIlIIlllllIIIII < lllllllllllllllIlIIlIIllllIlllIl; ++lllllllllllllllIlIIlIIlllllIIIII) {
                    final TypeData lllllllllllllllIlIIlIIlllllIIIll = lllllllllllllllIlIIlIIllllIllllI.get(lllllllllllllllIlIIlIIlllllIIIII);
                    final TypeData lllllllllllllllIlIIlIIlllllIIIlI = lllllllllllllllIlIIlIIlllllIIIll.getArrayType(lllllllllllllllIlIIlIIllllIlllll.dimension);
                    final BasicType lllllllllllllllIlIIlIIlllllIIIIl = lllllllllllllllIlIIlIIlllllIIIlI.isBasicType();
                    if (lllllllllllllllIlIIlIIllllIlIlIl == null) {
                        if (lllllllllllllllIlIIlIIlllllIIIIl == null) {
                            lllllllllllllllIlIIlIIllllIlIllI = false;
                            lllllllllllllllIlIIlIIllllIlIlIl = lllllllllllllllIlIIlIIlllllIIIlI;
                            if (lllllllllllllllIlIIlIIlllllIIIlI.isUninit()) {
                                break;
                            }
                        }
                        else {
                            lllllllllllllllIlIIlIIllllIlIllI = true;
                            lllllllllllllllIlIIlIIllllIlIlIl = lllllllllllllllIlIIlIIlllllIIIIl;
                        }
                    }
                    else if ((lllllllllllllllIlIIlIIlllllIIIIl == null && lllllllllllllllIlIIlIIllllIlIllI) || (lllllllllllllllIlIIlIIlllllIIIIl != null && lllllllllllllllIlIIlIIllllIlIlIl != lllllllllllllllIlIIlIIlllllIIIIl)) {
                        lllllllllllllllIlIIlIIllllIlIllI = true;
                        lllllllllllllllIlIIlIIllllIlIlIl = TypeTag.TOP;
                        break;
                    }
                    if (lllllllllllllllIlIIlIIlllllIIIIl == null && !lllllllllllllllIlIIlIIlllllIIIlI.isNullType()) {
                        lllllllllllllllIlIIlIIllllIlIlll.add(lllllllllllllllIlIIlIIlllllIIIlI.getName());
                    }
                }
            }
            if (lllllllllllllllIlIIlIIllllIlIllI) {
                this.is2WordType = lllllllllllllllIlIIlIIllllIlIlIl.is2WordType();
                this.fixTypes1(lllllllllllllllIlIIlIIllllIllIIl, lllllllllllllllIlIIlIIllllIlIlIl);
            }
            else {
                final String lllllllllllllllIlIIlIIllllIllIll = this.fixTypes2(lllllllllllllllIlIIlIIllllIllIIl, lllllllllllllllIlIIlIIllllIlIlll, lllllllllllllllIlIIlIIllllIlIIIl);
                this.fixTypes1(lllllllllllllllIlIIlIIllllIllIIl, new ClassName(lllllllllllllllIlIIlIIllllIllIll));
            }
        }
        
        private String fixTypes2(final List<TypeData> lllllllllllllllIlIIlIIlllIlIlIIl, final Set<String> lllllllllllllllIlIIlIIlllIlIlIII, final ClassPool lllllllllllllllIlIIlIIlllIlIIlll) throws NotFoundException {
            final Iterator<String> lllllllllllllllIlIIlIIlllIlIIllI = lllllllllllllllIlIIlIIlllIlIlIII.iterator();
            if (lllllllllllllllIlIIlIIlllIlIlIII.size() == 0) {
                return null;
            }
            if (lllllllllllllllIlIIlIIlllIlIlIII.size() == 1) {
                return lllllllllllllllIlIIlIIlllIlIIllI.next();
            }
            CtClass lllllllllllllllIlIIlIIlllIlIlIll = lllllllllllllllIlIIlIIlllIlIIlll.get(lllllllllllllllIlIIlIIlllIlIIllI.next());
            while (lllllllllllllllIlIIlIIlllIlIIllI.hasNext()) {
                lllllllllllllllIlIIlIIlllIlIlIll = TypeData.commonSuperClassEx(lllllllllllllllIlIIlIIlllIlIlIll, lllllllllllllllIlIIlIIlllIlIIlll.get(lllllllllllllllIlIIlIIlllIlIIllI.next()));
            }
            if (lllllllllllllllIlIIlIIlllIlIlIll.getSuperclass() == null || isObjectArray(lllllllllllllllIlIIlIIlllIlIlIll)) {
                lllllllllllllllIlIIlIIlllIlIlIll = this.fixByUppers(lllllllllllllllIlIIlIIlllIlIlIIl, lllllllllllllllIlIIlIIlllIlIIlll, new HashSet<TypeData>(), lllllllllllllllIlIIlIIlllIlIlIll);
            }
            if (lllllllllllllllIlIIlIIlllIlIlIll.isArray()) {
                return Descriptor.toJvmName(lllllllllllllllIlIIlIIlllIlIlIll);
            }
            return lllllllllllllllIlIIlIIlllIlIlIll.getName();
        }
        
        @Override
        public boolean is2WordType() {
            return this.fixedType == null && this.is2WordType;
        }
        
        @Override
        public boolean isNullType() {
            return this.fixedType == null && this.lowers.get(0).isNullType();
        }
        
        @Override
        public int dfs(final List<TypeData> lllllllllllllllIlIIlIIlllllllIII, int lllllllllllllllIlIIlIIllllllIlll, final ClassPool lllllllllllllllIlIIlIIlllllllIll) throws NotFoundException {
            if (this.visited > 0) {
                return lllllllllllllllIlIIlIIllllllIlll;
            }
            final int n = ++lllllllllllllllIlIIlIIllllllIlll;
            this.smallest = n;
            this.visited = n;
            lllllllllllllllIlIIlIIlllllllIII.add(this);
            this.inList = true;
            for (int lllllllllllllllIlIIlIIlllllllIlI = this.lowers.size(), lllllllllllllllIlIIlIlIIIIIIIIIl = 0; lllllllllllllllIlIIlIlIIIIIIIIIl < lllllllllllllllIlIIlIIlllllllIlI; ++lllllllllllllllIlIIlIlIIIIIIIIIl) {
                final TypeVar lllllllllllllllIlIIlIlIIIIIIIIlI = this.lowers.get(lllllllllllllllIlIIlIlIIIIIIIIIl).toTypeVar(this.dimension);
                if (lllllllllllllllIlIIlIlIIIIIIIIlI != null) {
                    if (lllllllllllllllIlIIlIlIIIIIIIIlI.visited == 0) {
                        lllllllllllllllIlIIlIIllllllIlll = lllllllllllllllIlIIlIlIIIIIIIIlI.dfs(lllllllllllllllIlIIlIIlllllllIII, lllllllllllllllIlIIlIIllllllIlll, lllllllllllllllIlIIlIIlllllllIll);
                        if (lllllllllllllllIlIIlIlIIIIIIIIlI.smallest < this.smallest) {
                            this.smallest = lllllllllllllllIlIIlIlIIIIIIIIlI.smallest;
                        }
                    }
                    else if (lllllllllllllllIlIIlIlIIIIIIIIlI.inList && lllllllllllllllIlIIlIlIIIIIIIIlI.visited < this.smallest) {
                        this.smallest = lllllllllllllllIlIIlIlIIIIIIIIlI.visited;
                    }
                }
            }
            if (this.visited == this.smallest) {
                final List<TypeData> lllllllllllllllIlIIlIlIIIIIIIIII = new ArrayList<TypeData>();
                TypeVar lllllllllllllllIlIIlIIllllllllll;
                do {
                    lllllllllllllllIlIIlIIllllllllll = lllllllllllllllIlIIlIIlllllllIII.remove(lllllllllllllllIlIIlIIlllllllIII.size() - 1);
                    lllllllllllllllIlIIlIIllllllllll.inList = false;
                    lllllllllllllllIlIIlIlIIIIIIIIII.add(lllllllllllllllIlIIlIIllllllllll);
                } while (lllllllllllllllIlIIlIIllllllllll != this);
                this.fixTypes(lllllllllllllllIlIIlIlIIIIIIIIII, lllllllllllllllIlIIlIIlllllllIll);
            }
            return lllllllllllllllIlIIlIIllllllIlll;
        }
        
        @Override
        public int getTypeData(final ConstPool lllllllllllllllIlIIlIlIIIIlIIIlI) {
            if (this.fixedType == null) {
                return this.lowers.get(0).getTypeData(lllllllllllllllIlIIlIlIIIIlIIIlI);
            }
            return super.getTypeData(lllllllllllllllIlIIlIlIIIIlIIIlI);
        }
        
        @Override
        public String getName() {
            if (this.fixedType == null) {
                return this.lowers.get(0).getName();
            }
            return this.fixedType;
        }
        
        public TypeVar(final TypeData lllllllllllllllIlIIlIlIIIIlllllI) {
            this.visited = 0;
            this.smallest = 0;
            this.inList = false;
            this.dimension = 0;
            this.uppers = null;
            this.lowers = new ArrayList<TypeData>(2);
            this.usedBy = new ArrayList<TypeData>(2);
            this.merge(lllllllllllllllIlIIlIlIIIIlllllI);
            this.fixedType = null;
            this.is2WordType = lllllllllllllllIlIIlIlIIIIlllllI.is2WordType();
        }
        
        @Override
        String toString2(final Set<TypeData> lllllllllllllllIlIIlIIllIlllIllI) {
            lllllllllllllllIlIIlIIllIlllIllI.add(this);
            if (this.lowers.size() > 0) {
                final TypeData lllllllllllllllIlIIlIIllIllllIII = this.lowers.get(0);
                if (lllllllllllllllIlIIlIIllIllllIII != null && !lllllllllllllllIlIIlIIllIlllIllI.contains(lllllllllllllllIlIIlIIllIllllIII)) {
                    return lllllllllllllllIlIIlIIllIllllIII.toString2(lllllllllllllllIlIIlIIllIlllIllI);
                }
            }
            return "?";
        }
        
        private static boolean isObjectArray(final CtClass lllllllllllllllIlIIlIIlllIIlllIl) throws NotFoundException {
            return lllllllllllllllIlIIlIIlllIIlllIl.isArray() && lllllllllllllllIlIIlIIlllIIlllIl.getComponentType().getSuperclass() == null;
        }
    }
    
    public static class NullType extends ClassName
    {
        @Override
        public TypeData getArrayType(final int llllllllllllllIlIlIIlIlIlIIllllI) {
            return this;
        }
        
        @Override
        public int getTypeTag() {
            return 5;
        }
        
        @Override
        public boolean isNullType() {
            return true;
        }
        
        @Override
        public int getTypeData(final ConstPool llllllllllllllIlIlIIlIlIlIlIIIIl) {
            return 0;
        }
        
        public NullType() {
            super("null-type");
        }
    }
    
    public static class ArrayType extends AbsTypeVar
    {
        private /* synthetic */ AbsTypeVar element;
        
        @Override
        String toString2(final Set<TypeData> lllllllllllllIIIIllIIIlIIIIIIIlI) {
            return String.valueOf(new StringBuilder().append("[").append(this.element.toString2(lllllllllllllIIIIllIIIlIIIIIIIlI)));
        }
        
        @Override
        public int dfs(final List<TypeData> lllllllllllllIIIIllIIIlIIIIIlllI, final int lllllllllllllIIIIllIIIlIIIIIlIIl, final ClassPool lllllllllllllIIIIllIIIlIIIIIlIII) throws NotFoundException {
            return this.element.dfs(lllllllllllllIIIIllIIIlIIIIIlllI, lllllllllllllIIIIllIIIlIIIIIlIIl, lllllllllllllIIIIllIIIlIIIIIlIII);
        }
        
        public AbsTypeVar elementType() {
            return this.element;
        }
        
        @Override
        public boolean is2WordType() {
            return false;
        }
        
        @Override
        public void setType(final String lllllllllllllIIIIllIIIlIIIlIIIIl, final ClassPool lllllllllllllIIIIllIIIlIIIlIIIII) throws BadBytecode {
            this.element.setType(typeName(lllllllllllllIIIIllIIIlIIIlIIIIl), lllllllllllllIIIIllIIIlIIIlIIIII);
        }
        
        @Override
        protected TypeVar toTypeVar(final int lllllllllllllIIIIllIIIlIIIIlllII) {
            return this.element.toTypeVar(lllllllllllllIIIIllIIIlIIIIlllII + 1);
        }
        
        private ArrayType(final AbsTypeVar lllllllllllllIIIIllIIIlIIlIIIIII) {
            this.element = lllllllllllllIIIIllIIIlIIlIIIIII;
        }
        
        static TypeData make(final TypeData lllllllllllllIIIIllIIIlIIIllllIl) throws BadBytecode {
            if (lllllllllllllIIIIllIIIlIIIllllIl instanceof ArrayElement) {
                return ((ArrayElement)lllllllllllllIIIIllIIIlIIIllllIl).arrayType();
            }
            if (lllllllllllllIIIIllIIIlIIIllllIl instanceof AbsTypeVar) {
                return new ArrayType((AbsTypeVar)lllllllllllllIIIIllIIIlIIIllllIl);
            }
            if (lllllllllllllIIIIllIIIlIIIllllIl instanceof ClassName && !lllllllllllllIIIIllIIIlIIIllllIl.isNullType()) {
                return new ClassName(typeName(lllllllllllllIIIIllIIIlIIIllllIl.getName()));
            }
            throw new BadBytecode(String.valueOf(new StringBuilder().append("bad AASTORE: ").append(lllllllllllllIIIIllIIIlIIIllllIl)));
        }
        
        @Override
        public TypeData getArrayType(final int lllllllllllllIIIIllIIIlIIIIlIllI) throws NotFoundException {
            return this.element.getArrayType(lllllllllllllIIIIllIIIlIIIIlIllI + 1);
        }
        
        public static String typeName(final String lllllllllllllIIIIllIIIlIIIlIlIlI) {
            if (lllllllllllllIIIIllIIIlIIIlIlIlI.charAt(0) == '[') {
                return String.valueOf(new StringBuilder().append("[").append(lllllllllllllIIIIllIIIlIIIlIlIlI));
            }
            return String.valueOf(new StringBuilder().append("[L").append(lllllllllllllIIIIllIIIlIIIlIlIlI.replace('.', '/')).append(";"));
        }
        
        @Override
        public BasicType isBasicType() {
            return null;
        }
        
        @Override
        public void merge(final TypeData lllllllllllllIIIIllIIIlIIIllIlll) {
            try {
                if (!lllllllllllllIIIIllIIIlIIIllIlll.isNullType()) {
                    this.element.merge(ArrayElement.make(lllllllllllllIIIIllIIIlIIIllIlll));
                }
            }
            catch (BadBytecode lllllllllllllIIIIllIIIlIIIlllIIl) {
                throw new RuntimeException(String.valueOf(new StringBuilder().append("fatal: ").append(lllllllllllllIIIIllIIIlIIIlllIIl)));
            }
        }
        
        @Override
        public String getName() {
            return typeName(this.element.getName());
        }
    }
    
    public static class ArrayElement extends AbsTypeVar
    {
        private /* synthetic */ AbsTypeVar array;
        
        @Override
        public TypeData getArrayType(final int lllllllllllllIllIIlIIIlIllIlIIll) throws NotFoundException {
            return this.array.getArrayType(lllllllllllllIllIIlIIIlIllIlIIll - 1);
        }
        
        @Override
        public void setType(final String lllllllllllllIllIIlIIIlIlllIIIII, final ClassPool lllllllllllllIllIIlIIIlIllIlllll) throws BadBytecode {
            this.array.setType(ArrayType.typeName(lllllllllllllIllIIlIIIlIlllIIIII), lllllllllllllIllIIlIIIlIllIlllll);
        }
        
        private ArrayElement(final AbsTypeVar lllllllllllllIllIIlIIIllIIIIIIlI) {
            this.array = lllllllllllllIllIIlIIIllIIIIIIlI;
        }
        
        @Override
        public BasicType isBasicType() {
            return null;
        }
        
        private static String typeName(final String lllllllllllllIllIIlIIIlIlllIlIIl) {
            if (lllllllllllllIllIIlIIIlIlllIlIIl.length() > 1 && lllllllllllllIllIIlIIIlIlllIlIIl.charAt(0) == '[') {
                final char lllllllllllllIllIIlIIIlIlllIlIll = lllllllllllllIllIIlIIIlIlllIlIIl.charAt(1);
                if (lllllllllllllIllIIlIIIlIlllIlIll == 'L') {
                    return lllllllllllllIllIIlIIIlIlllIlIIl.substring(2, lllllllllllllIllIIlIIIlIlllIlIIl.length() - 1).replace('/', '.');
                }
                if (lllllllllllllIllIIlIIIlIlllIlIll == '[') {
                    return lllllllllllllIllIIlIIIlIlllIlIIl.substring(1);
                }
            }
            return "java.lang.Object";
        }
        
        @Override
        protected TypeVar toTypeVar(final int lllllllllllllIllIIlIIIlIllIllIIl) {
            return this.array.toTypeVar(lllllllllllllIllIIlIIIlIllIllIIl - 1);
        }
        
        public static TypeData make(final TypeData lllllllllllllIllIIlIIIllIIIIIIII) throws BadBytecode {
            if (lllllllllllllIllIIlIIIllIIIIIIII instanceof ArrayType) {
                return ((ArrayType)lllllllllllllIllIIlIIIllIIIIIIII).elementType();
            }
            if (lllllllllllllIllIIlIIIllIIIIIIII instanceof AbsTypeVar) {
                return new ArrayElement((AbsTypeVar)lllllllllllllIllIIlIIIllIIIIIIII);
            }
            if (lllllllllllllIllIIlIIIllIIIIIIII instanceof ClassName && !lllllllllllllIllIIlIIIllIIIIIIII.isNullType()) {
                return new ClassName(typeName(lllllllllllllIllIIlIIIllIIIIIIII.getName()));
            }
            throw new BadBytecode(String.valueOf(new StringBuilder().append("bad AASTORE: ").append(lllllllllllllIllIIlIIIllIIIIIIII)));
        }
        
        @Override
        public boolean is2WordType() {
            return false;
        }
        
        @Override
        public void merge(final TypeData lllllllllllllIllIIlIIIlIlllllIIl) {
            try {
                if (!lllllllllllllIllIIlIIIlIlllllIIl.isNullType()) {
                    this.array.merge(ArrayType.make(lllllllllllllIllIIlIIIlIlllllIIl));
                }
            }
            catch (BadBytecode lllllllllllllIllIIlIIIlIlllllIll) {
                throw new RuntimeException(String.valueOf(new StringBuilder().append("fatal: ").append(lllllllllllllIllIIlIIIlIlllllIll)));
            }
        }
        
        @Override
        public int dfs(final List<TypeData> lllllllllllllIllIIlIIIlIllIIllIl, final int lllllllllllllIllIIlIIIlIllIIllII, final ClassPool lllllllllllllIllIIlIIIlIllIIlIll) throws NotFoundException {
            return this.array.dfs(lllllllllllllIllIIlIIIlIllIIllIl, lllllllllllllIllIIlIIIlIllIIllII, lllllllllllllIllIIlIIIlIllIIlIll);
        }
        
        public AbsTypeVar arrayType() {
            return this.array;
        }
        
        @Override
        public String getName() {
            return typeName(this.array.getName());
        }
        
        @Override
        String toString2(final Set<TypeData> lllllllllllllIllIIlIIIlIllIIIIIl) {
            return String.valueOf(new StringBuilder().append("*").append(this.array.toString2(lllllllllllllIllIIlIIIlIllIIIIIl)));
        }
    }
    
    public static class UninitThis extends UninitData
    {
        @Override
        public int getTypeTag() {
            return 6;
        }
        
        @Override
        public UninitData copy() {
            return new UninitThis(this.getName());
        }
        
        @Override
        public int getTypeData(final ConstPool lllllllllllllllIlIIlIIlIIIlllllI) {
            return 0;
        }
        
        UninitThis(final String lllllllllllllllIlIIlIIlIIlIIIlII) {
            super(-1, lllllllllllllllIlIIlIIlIIlIIIlII);
        }
        
        @Override
        String toString2(final Set<TypeData> lllllllllllllllIlIIlIIlIIIllllII) {
            return "uninit:this";
        }
    }
}
