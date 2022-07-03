package com.viaversion.viaversion.libs.javassist.bytecode.analysis;

import com.viaversion.viaversion.libs.javassist.*;
import java.util.*;

public class Type
{
    public static final /* synthetic */ Type BYTE;
    public static final /* synthetic */ Type CLONEABLE;
    public static final /* synthetic */ Type FLOAT;
    public static final /* synthetic */ Type SHORT;
    public static final /* synthetic */ Type BOGUS;
    public static final /* synthetic */ Type DOUBLE;
    public static final /* synthetic */ Type BOOLEAN;
    public static final /* synthetic */ Type RETURN_ADDRESS;
    public static final /* synthetic */ Type CHAR;
    public static final /* synthetic */ Type LONG;
    private static final /* synthetic */ Map<CtClass, Type> prims;
    public static final /* synthetic */ Type SERIALIZABLE;
    public static final /* synthetic */ Type OBJECT;
    public static final /* synthetic */ Type UNINIT;
    public static final /* synthetic */ Type VOID;
    private final /* synthetic */ CtClass clazz;
    private final /* synthetic */ boolean special;
    public static final /* synthetic */ Type INTEGER;
    public static final /* synthetic */ Type TOP;
    
    Map<String, CtClass> getAllInterfaces(CtClass llllllllllllllIlIllIIllIIIIIIlII, Map<String, CtClass> llllllllllllllIlIllIIllIIIIIIIll) {
        if (llllllllllllllIlIllIIllIIIIIIIll == null) {
            llllllllllllllIlIllIIllIIIIIIIll = new HashMap<String, CtClass>();
        }
        if (llllllllllllllIlIllIIllIIIIIIlII.isInterface()) {
            llllllllllllllIlIllIIllIIIIIIIll.put(llllllllllllllIlIllIIllIIIIIIlII.getName(), llllllllllllllIlIllIIllIIIIIIlII);
        }
        do {
            try {
                final byte llllllllllllllIlIllIIllIIIIIIIIl;
                final CtClass[] llllllllllllllIlIllIIllIIIIIlIlI = (Object)(llllllllllllllIlIllIIllIIIIIIIIl = (byte)(Object)llllllllllllllIlIllIIllIIIIIIlII.getInterfaces());
                for (double llllllllllllllIlIllIIllIIIIIIIII = llllllllllllllIlIllIIllIIIIIIIIl.length, llllllllllllllIlIllIIlIlllllllll = 0; llllllllllllllIlIllIIlIlllllllll < llllllllllllllIlIllIIllIIIIIIIII; ++llllllllllllllIlIllIIlIlllllllll) {
                    final CtClass llllllllllllllIlIllIIllIIIIIlIll = llllllllllllllIlIllIIllIIIIIIIIl[llllllllllllllIlIllIIlIlllllllll];
                    llllllllllllllIlIllIIllIIIIIIIll.put(llllllllllllllIlIllIIllIIIIIlIll.getName(), llllllllllllllIlIllIIllIIIIIlIll);
                    this.getAllInterfaces(llllllllllllllIlIllIIllIIIIIlIll, llllllllllllllIlIllIIllIIIIIIIll);
                }
                llllllllllllllIlIllIIllIIIIIIlII = llllllllllllllIlIllIIllIIIIIIlII.getSuperclass();
            }
            catch (NotFoundException llllllllllllllIlIllIIllIIIIIlIIl) {
                throw new RuntimeException(llllllllllllllIlIllIIllIIIIIlIIl);
            }
        } while (llllllllllllllIlIllIIllIIIIIIlII != null);
        return llllllllllllllIlIllIIllIIIIIIIll;
    }
    
    @Override
    public int hashCode() {
        return this.getClass().hashCode() + this.clazz.hashCode();
    }
    
    public int getDimensions() {
        if (!this.isArray()) {
            return 0;
        }
        String llllllllllllllIlIllIIllIllIlllll;
        int llllllllllllllIlIllIIllIllIllllI;
        int llllllllllllllIlIllIIllIllIlllIl;
        for (llllllllllllllIlIllIIllIllIlllll = this.clazz.getName(), llllllllllllllIlIllIIllIllIllllI = llllllllllllllIlIllIIllIllIlllll.length() - 1, llllllllllllllIlIllIIllIllIlllIl = 0; llllllllllllllIlIllIIllIllIlllll.charAt(llllllllllllllIlIllIIllIllIllllI) == ']'; llllllllllllllIlIllIIllIllIllllI -= 2, ++llllllllllllllIlIllIIllIllIlllIl) {}
        return llllllllllllllIlIllIIllIllIlllIl;
    }
    
    private Type mergeClasses(final Type llllllllllllllIlIllIIllIIlIlIlII) throws NotFoundException {
        final CtClass llllllllllllllIlIllIIllIIlIlIIll = findCommonSuperClass(this.clazz, llllllllllllllIlIllIIllIIlIlIlII.clazz);
        if (llllllllllllllIlIllIIllIIlIlIIll.getSuperclass() == null) {
            final Map<String, CtClass> llllllllllllllIlIllIIllIIlIlIllI = this.findCommonInterfaces(llllllllllllllIlIllIIllIIlIlIlII);
            if (llllllllllllllIlIllIIllIIlIlIllI.size() == 1) {
                return new Type(llllllllllllllIlIllIIllIIlIlIllI.values().iterator().next());
            }
            if (llllllllllllllIlIllIIllIIlIlIllI.size() > 1) {
                return new MultiType(llllllllllllllIlIllIIllIIlIlIllI);
            }
            return new Type(llllllllllllllIlIllIIllIIlIlIIll);
        }
        else {
            final Map<String, CtClass> llllllllllllllIlIllIIllIIlIlIIlI = this.findExclusiveDeclaredInterfaces(llllllllllllllIlIllIIllIIlIlIlII, llllllllllllllIlIllIIllIIlIlIIll);
            if (llllllllllllllIlIllIIllIIlIlIIlI.size() > 0) {
                return new MultiType(llllllllllllllIlIllIIllIIlIlIIlI, new Type(llllllllllllllIlIllIIllIIlIlIIll));
            }
            return new Type(llllllllllllllIlIllIIllIIlIlIIll);
        }
    }
    
    Type(final CtClass llllllllllllllIlIllIIllIlllllllI) {
        this(llllllllllllllIlIllIIllIlllllllI, false);
    }
    
    public boolean isAssignableFrom(final Type llllllllllllllIlIllIIllIllIIIllI) {
        if (this == llllllllllllllIlIllIIllIllIIIllI) {
            return true;
        }
        if ((llllllllllllllIlIllIIllIllIIIllI == Type.UNINIT && this.isReference()) || (this == Type.UNINIT && llllllllllllllIlIllIIllIllIIIllI.isReference())) {
            return true;
        }
        if (llllllllllllllIlIllIIllIllIIIllI instanceof MultiType) {
            return ((MultiType)llllllllllllllIlIllIIllIllIIIllI).isAssignableTo(this);
        }
        if (llllllllllllllIlIllIIllIllIIIllI instanceof MultiArrayType) {
            return ((MultiArrayType)llllllllllllllIlIllIIllIllIIIllI).isAssignableTo(this);
        }
        if (this.clazz == null || this.clazz.isPrimitive()) {
            return false;
        }
        try {
            return llllllllllllllIlIllIIllIllIIIllI.clazz.subtypeOf(this.clazz);
        }
        catch (Exception llllllllllllllIlIllIIllIllIIlIlI) {
            throw new RuntimeException(llllllllllllllIlIllIIllIllIIlIlI);
        }
    }
    
    public boolean isSpecial() {
        return this.special;
    }
    
    public CtClass getCtClass() {
        return this.clazz;
    }
    
    private Map<String, CtClass> findExclusiveDeclaredInterfaces(final Type llllllllllllllIlIllIIllIIIllIlll, final CtClass llllllllllllllIlIllIIllIIIllIIII) {
        final Map<String, CtClass> llllllllllllllIlIllIIllIIIllIlIl = this.getDeclaredInterfaces(llllllllllllllIlIllIIllIIIllIlll.clazz, null);
        final Map<String, CtClass> llllllllllllllIlIllIIllIIIllIlII = this.getDeclaredInterfaces(this.clazz, null);
        final Map<String, CtClass> llllllllllllllIlIllIIllIIIllIIll = this.getAllInterfaces(llllllllllllllIlIllIIllIIIllIIII, null);
        for (final String llllllllllllllIlIllIIllIIIlllIIl : llllllllllllllIlIllIIllIIIllIIll.keySet()) {
            llllllllllllllIlIllIIllIIIllIlIl.remove(llllllllllllllIlIllIIllIIIlllIIl);
            llllllllllllllIlIllIIllIIIllIlII.remove(llllllllllllllIlIllIIllIIIlllIIl);
        }
        return this.findCommonInterfaces(llllllllllllllIlIllIIllIIIllIlIl, llllllllllllllIlIllIIllIIIllIlII);
    }
    
    public boolean isReference() {
        return !this.special && (this.clazz == null || !this.clazz.isPrimitive());
    }
    
    Map<String, CtClass> getDeclaredInterfaces(final CtClass llllllllllllllIlIllIIlIllllIllII, final Map<String, CtClass> llllllllllllllIlIllIIlIllllIlIlI) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     4: new             Ljava/util/HashMap;
        //     7: dup            
        //     8: invokespecial   java/util/HashMap.<init>:()V
        //    11: astore_2        /* llllllllllllllIlIllIIlIlllllIIII */
        //    12: aload_1         /* llllllllllllllIlIllIIlIlllllIIIl */
        //    13: invokevirtual   com/viaversion/viaversion/libs/javassist/CtClass.isInterface:()Z
        //    16: ifeq            31
        //    19: aload_2         /* llllllllllllllIlIllIIlIlllllIIII */
        //    20: aload_1         /* llllllllllllllIlIllIIlIlllllIIIl */
        //    21: invokevirtual   com/viaversion/viaversion/libs/javassist/CtClass.getName:()Ljava/lang/String;
        //    24: aload_1         /* llllllllllllllIlIllIIlIlllllIIIl */
        //    25: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    30: pop            
        //    31: aload_1         /* llllllllllllllIlIllIIlIlllllIIIl */
        //    32: invokevirtual   com/viaversion/viaversion/libs/javassist/CtClass.getInterfaces:()[Lcom/viaversion/viaversion/libs/javassist/CtClass;
        //    35: astore_3        /* llllllllllllllIlIllIIlIllllIlIIl */
        //    36: goto            51
        //    39: astore          llllllllllllllIlIllIIlIlllllIlII
        //    41: new             Ljava/lang/RuntimeException;
        //    44: dup            
        //    45: aload           llllllllllllllIlIllIIlIlllllIlII
        //    47: invokespecial   java/lang/RuntimeException.<init>:(Ljava/lang/Throwable;)V
        //    50: athrow         
        //    51: aload_3         /* llllllllllllllIlIllIIlIllllIllll */
        //    52: astore          llllllllllllllIlIllIIlIllllIIlll
        //    54: aload           llllllllllllllIlIllIIlIllllIIlll
        //    56: arraylength    
        //    57: istore          llllllllllllllIlIllIIlIllllIIlIl
        //    59: iconst_0       
        //    60: istore          llllllllllllllIlIllIIlIllllIIlII
        //    62: iload           llllllllllllllIlIllIIlIllllIIlII
        //    64: iload           llllllllllllllIlIllIIlIllllIIlIl
        //    66: if_icmpge       104
        //    69: aload           llllllllllllllIlIllIIlIllllIIlll
        //    71: iload           llllllllllllllIlIllIIlIllllIIlII
        //    73: aaload         
        //    74: astore          llllllllllllllIlIllIIlIlllllIIll
        //    76: aload_2         /* llllllllllllllIlIllIIlIlllllIIII */
        //    77: aload           llllllllllllllIlIllIIlIlllllIIll
        //    79: invokevirtual   com/viaversion/viaversion/libs/javassist/CtClass.getName:()Ljava/lang/String;
        //    82: aload           llllllllllllllIlIllIIlIlllllIIll
        //    84: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    89: pop            
        //    90: aload_0         /* llllllllllllllIlIllIIlIllllIllIl */
        //    91: aload           llllllllllllllIlIllIIlIlllllIIll
        //    93: aload_2         /* llllllllllllllIlIllIIlIlllllIIII */
        //    94: invokevirtual   com/viaversion/viaversion/libs/javassist/bytecode/analysis/Type.getDeclaredInterfaces:(Lcom/viaversion/viaversion/libs/javassist/CtClass;Ljava/util/Map;)Ljava/util/Map;
        //    97: pop            
        //    98: iinc            llllllllllllllIlIllIIlIllllIIlII, 1
        //   101: goto            62
        //   104: aload_2         /* llllllllllllllIlIllIIlIlllllIIII */
        //   105: areturn        
        //    Signature:
        //  (Lcom/viaversion/viaversion/libs/javassist/CtClass;Ljava/util/Map<Ljava/lang/String;Lcom/viaversion/viaversion/libs/javassist/CtClass;>;)Ljava/util/Map<Ljava/lang/String;Lcom/viaversion/viaversion/libs/javassist/CtClass;>;
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                                        
        //  -----  -----  -----  -----  ------------------------------------------------------------
        //  31     36     39     51     Lcom/viaversion/viaversion/libs/javassist/NotFoundException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private static CtClass findCommonSuperClass(final CtClass llllllllllllllIlIllIIllIIllIIIlI, final CtClass llllllllllllllIlIllIIllIIllIIIIl) throws NotFoundException {
        CtClass llllllllllllllIlIllIIllIIllIIllI = llllllllllllllIlIllIIllIIllIIIlI;
        CtClass llllllllllllllIlIllIIllIIllIIlII;
        CtClass llllllllllllllIlIllIIllIIllIIlIl = llllllllllllllIlIllIIllIIllIIlII = llllllllllllllIlIllIIllIIllIIIIl;
        CtClass llllllllllllllIlIllIIllIIllIIIll = llllllllllllllIlIllIIllIIllIIllI;
        while (!eq(llllllllllllllIlIllIIllIIllIIllI, llllllllllllllIlIllIIllIIllIIlIl) || llllllllllllllIlIllIIllIIllIIllI.getSuperclass() == null) {
            final CtClass llllllllllllllIlIllIIllIIllIlIlI = llllllllllllllIlIllIIllIIllIIllI.getSuperclass();
            final CtClass llllllllllllllIlIllIIllIIllIlIIl = llllllllllllllIlIllIIllIIllIIlIl.getSuperclass();
            if (llllllllllllllIlIllIIllIIllIlIIl == null) {
                llllllllllllllIlIllIIllIIllIIlIl = llllllllllllllIlIllIIllIIllIIlII;
            }
            else {
                if (llllllllllllllIlIllIIllIIllIlIlI != null) {
                    llllllllllllllIlIllIIllIIllIIllI = llllllllllllllIlIllIIllIIllIlIlI;
                    llllllllllllllIlIllIIllIIllIIlIl = llllllllllllllIlIllIIllIIllIlIIl;
                    continue;
                }
                llllllllllllllIlIllIIllIIllIIllI = llllllllllllllIlIllIIllIIllIIIll;
                llllllllllllllIlIllIIllIIllIIIll = llllllllllllllIlIllIIllIIllIIlII;
                llllllllllllllIlIllIIllIIllIIlII = llllllllllllllIlIllIIllIIllIIllI;
                llllllllllllllIlIllIIllIIllIIllI = llllllllllllllIlIllIIllIIllIIlIl;
                llllllllllllllIlIllIIllIIllIIlIl = llllllllllllllIlIllIIllIIllIIlII;
            }
            while (true) {
                llllllllllllllIlIllIIllIIllIIllI = llllllllllllllIlIllIIllIIllIIllI.getSuperclass();
                if (llllllllllllllIlIllIIllIIllIIllI == null) {
                    break;
                }
                llllllllllllllIlIllIIllIIllIIIll = llllllllllllllIlIllIIllIIllIIIll.getSuperclass();
            }
            for (llllllllllllllIlIllIIllIIllIIllI = llllllllllllllIlIllIIllIIllIIIll; !eq(llllllllllllllIlIllIIllIIllIIllI, llllllllllllllIlIllIIllIIllIIlIl); llllllllllllllIlIllIIllIIllIIllI = llllllllllllllIlIllIIllIIllIIllI.getSuperclass(), llllllllllllllIlIllIIllIIllIIlIl = llllllllllllllIlIllIIllIIllIIlIl.getSuperclass()) {}
            return llllllllllllllIlIllIIllIIllIIllI;
        }
        return llllllllllllllIlIllIIllIIllIIllI;
    }
    
    @Override
    public String toString() {
        if (this == Type.BOGUS) {
            return "BOGUS";
        }
        if (this == Type.UNINIT) {
            return "UNINIT";
        }
        if (this == Type.RETURN_ADDRESS) {
            return "RETURN ADDRESS";
        }
        if (this == Type.TOP) {
            return "TOP";
        }
        return (this.clazz == null) ? "null" : this.clazz.getName();
    }
    
    private Type(final CtClass llllllllllllllIlIllIIllIllllIllI, final boolean llllllllllllllIlIllIIllIlllllIII) {
        this.clazz = llllllllllllllIlIllIIllIllllIllI;
        this.special = llllllllllllllIlIllIIllIlllllIII;
    }
    
    Map<String, CtClass> findCommonInterfaces(final Map<String, CtClass> llllllllllllllIlIllIIllIIIIllllI, Map<String, CtClass> llllllllllllllIlIllIIllIIIIllIIl) {
        if (llllllllllllllIlIllIIllIIIIllIIl == null) {
            llllllllllllllIlIllIIllIIIIllIIl = new HashMap<String, CtClass>();
        }
        if (llllllllllllllIlIllIIllIIIIllllI == null || llllllllllllllIlIllIIllIIIIllllI.isEmpty()) {
            llllllllllllllIlIllIIllIIIIllIIl.clear();
        }
        final Iterator<String> llllllllllllllIlIllIIllIIIIlllII = llllllllllllllIlIllIIllIIIIllIIl.keySet().iterator();
        while (llllllllllllllIlIllIIllIIIIlllII.hasNext()) {
            final String llllllllllllllIlIllIIllIIIlIIIll = llllllllllllllIlIllIIllIIIIlllII.next();
            if (!llllllllllllllIlIllIIllIIIIllllI.containsKey(llllllllllllllIlIllIIllIIIlIIIll)) {
                llllllllllllllIlIllIIllIIIIlllII.remove();
            }
        }
        final Collection<CtClass> llllllllllllllIlIllIIllIIIIllIll = new ArrayList<CtClass>();
        for (final CtClass llllllllllllllIlIllIIllIIIlIIIIl : llllllllllllllIlIllIIllIIIIllIIl.values()) {
            try {
                llllllllllllllIlIllIIllIIIIllIll.addAll(Arrays.asList(llllllllllllllIlIllIIllIIIlIIIIl.getInterfaces()));
            }
            catch (NotFoundException llllllllllllllIlIllIIllIIIlIIIlI) {
                throw new RuntimeException(llllllllllllllIlIllIIllIIIlIIIlI);
            }
        }
        for (final CtClass llllllllllllllIlIllIIllIIIlIIIII : llllllllllllllIlIllIIllIIIIllIll) {
            llllllllllllllIlIllIIllIIIIllIIl.remove(llllllllllllllIlIllIIllIIIlIIIII.getName());
        }
        return llllllllllllllIlIllIIllIIIIllIIl;
    }
    
    private ClassPool getClassPool(final Type llllllllllllllIlIllIIllIlIIIllll) {
        final ClassPool llllllllllllllIlIllIIllIlIIlIIII = llllllllllllllIlIllIIllIlIIIllll.clazz.getClassPool();
        return (llllllllllllllIlIllIIllIlIIlIIII != null) ? llllllllllllllIlIllIIllIlIIlIIII : ClassPool.getDefault();
    }
    
    boolean popChanged() {
        return false;
    }
    
    public boolean isArray() {
        return this.clazz != null && this.clazz.isArray();
    }
    
    static {
        prims = new IdentityHashMap<CtClass, Type>();
        DOUBLE = new Type(CtClass.doubleType);
        BOOLEAN = new Type(CtClass.booleanType);
        LONG = new Type(CtClass.longType);
        CHAR = new Type(CtClass.charType);
        BYTE = new Type(CtClass.byteType);
        SHORT = new Type(CtClass.shortType);
        INTEGER = new Type(CtClass.intType);
        FLOAT = new Type(CtClass.floatType);
        VOID = new Type(CtClass.voidType);
        UNINIT = new Type(null);
        RETURN_ADDRESS = new Type(null, true);
        TOP = new Type(null, true);
        BOGUS = new Type(null, true);
        OBJECT = lookupType("java.lang.Object");
        SERIALIZABLE = lookupType("java.io.Serializable");
        CLONEABLE = lookupType("java.lang.Cloneable");
        THROWABLE = lookupType("java.lang.Throwable");
        Type.prims.put(CtClass.doubleType, Type.DOUBLE);
        Type.prims.put(CtClass.longType, Type.LONG);
        Type.prims.put(CtClass.charType, Type.CHAR);
        Type.prims.put(CtClass.shortType, Type.SHORT);
        Type.prims.put(CtClass.intType, Type.INTEGER);
        Type.prims.put(CtClass.floatType, Type.FLOAT);
        Type.prims.put(CtClass.byteType, Type.BYTE);
        Type.prims.put(CtClass.booleanType, Type.BOOLEAN);
        Type.prims.put(CtClass.voidType, Type.VOID);
    }
    
    Type getRootComponent(Type llllllllllllllIlIllIIllIlIlllIII) {
        while (((Type)llllllllllllllIlIllIIllIlIlllIII).isArray()) {
            llllllllllllllIlIllIIllIlIlllIII = ((Type)llllllllllllllIlIllIIllIlIlllIII).getComponent();
        }
        return (Type)llllllllllllllIlIllIIllIlIlllIII;
    }
    
    String arrayName(String llllllllllllllIlIllIIllIlIIllllI, final int llllllllllllllIlIllIIllIlIIlllIl) {
        int llllllllllllllIlIllIIllIlIIlllII = llllllllllllllIlIllIIllIlIIllllI.length();
        final int llllllllllllllIlIllIIllIlIIllIll = llllllllllllllIlIllIIllIlIIlllII + llllllllllllllIlIllIIllIlIIlllIl * 2;
        final char[] llllllllllllllIlIllIIllIlIIllIlI = new char[llllllllllllllIlIllIIllIlIIllIll];
        llllllllllllllIlIllIIllIlIIllllI.getChars(0, llllllllllllllIlIllIIllIlIIlllII, llllllllllllllIlIllIIllIlIIllIlI, 0);
        while (llllllllllllllIlIllIIllIlIIlllII < llllllllllllllIlIllIIllIlIIllIll) {
            llllllllllllllIlIllIIllIlIIllIlI[llllllllllllllIlIllIIllIlIIlllII++] = '[';
            llllllllllllllIlIllIIllIlIIllIlI[llllllllllllllIlIllIIllIlIIlllII++] = ']';
        }
        llllllllllllllIlIllIIllIlIIllllI = new String(llllllllllllllIlIllIIllIlIIllIlI);
        return llllllllllllllIlIllIIllIlIIllllI;
    }
    
    private Type createArray(final Type llllllllllllllIlIllIIllIlIlIlllI, final int llllllllllllllIlIllIIllIlIlIllIl) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: instanceof      Lcom/viaversion/viaversion/libs/javassist/bytecode/analysis/MultiType;
        //     4: ifeq            20
        //     7: new             Lcom/viaversion/viaversion/libs/javassist/bytecode/analysis/MultiArrayType;
        //    10: dup            
        //    11: aload_1         /* llllllllllllllIlIllIIllIlIlIlIIl */
        //    12: checkcast       Lcom/viaversion/viaversion/libs/javassist/bytecode/analysis/MultiType;
        //    15: iload_2         /* llllllllllllllIlIllIIllIlIlIlIII */
        //    16: invokespecial   com/viaversion/viaversion/libs/javassist/bytecode/analysis/MultiArrayType.<init>:(Lcom/viaversion/viaversion/libs/javassist/bytecode/analysis/MultiType;I)V
        //    19: areturn        
        //    20: aload_0         /* llllllllllllllIlIllIIllIlIlIlIlI */
        //    21: aload_1         /* llllllllllllllIlIllIIllIlIlIlIIl */
        //    22: getfield        com/viaversion/viaversion/libs/javassist/bytecode/analysis/Type.clazz:Lcom/viaversion/viaversion/libs/javassist/CtClass;
        //    25: invokevirtual   com/viaversion/viaversion/libs/javassist/CtClass.getName:()Ljava/lang/String;
        //    28: iload_2         /* llllllllllllllIlIllIIllIlIlIlIII */
        //    29: invokevirtual   com/viaversion/viaversion/libs/javassist/bytecode/analysis/Type.arrayName:(Ljava/lang/String;I)Ljava/lang/String;
        //    32: astore_3        /* llllllllllllllIlIllIIllIlIlIllII */
        //    33: aload_0         /* llllllllllllllIlIllIIllIlIlIlIlI */
        //    34: aload_1         /* llllllllllllllIlIllIIllIlIlIlIIl */
        //    35: invokespecial   com/viaversion/viaversion/libs/javassist/bytecode/analysis/Type.getClassPool:(Lcom/viaversion/viaversion/libs/javassist/bytecode/analysis/Type;)Lcom/viaversion/viaversion/libs/javassist/ClassPool;
        //    38: aload_3         /* llllllllllllllIlIllIIllIlIlIllII */
        //    39: invokevirtual   com/viaversion/viaversion/libs/javassist/ClassPool.get:(Ljava/lang/String;)Lcom/viaversion/viaversion/libs/javassist/CtClass;
        //    42: invokestatic    com/viaversion/viaversion/libs/javassist/bytecode/analysis/Type.get:(Lcom/viaversion/viaversion/libs/javassist/CtClass;)Lcom/viaversion/viaversion/libs/javassist/bytecode/analysis/Type;
        //    45: astore          llllllllllllllIlIllIIllIlIllIIIl
        //    47: goto            62
        //    50: astore          llllllllllllllIlIllIIllIlIllIIII
        //    52: new             Ljava/lang/RuntimeException;
        //    55: dup            
        //    56: aload           llllllllllllllIlIllIIllIlIllIIII
        //    58: invokespecial   java/lang/RuntimeException.<init>:(Ljava/lang/Throwable;)V
        //    61: athrow         
        //    62: aload           llllllllllllllIlIllIIllIlIlIlIll
        //    64: areturn        
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                                        
        //  -----  -----  -----  -----  ------------------------------------------------------------
        //  33     47     50     62     Lcom/viaversion/viaversion/libs/javassist/NotFoundException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    static boolean eq(final CtClass llllllllllllllIlIllIIlIllIllllll, final CtClass llllllllllllllIlIllIIlIllIllllIl) {
        return llllllllllllllIlIllIIlIllIllllll == llllllllllllllIlIllIIlIllIllllIl || (llllllllllllllIlIllIIlIllIllllll != null && llllllllllllllIlIllIIlIllIllllIl != null && llllllllllllllIlIllIIlIllIllllll.getName().equals(llllllllllllllIlIllIIlIllIllllIl.getName()));
    }
    
    public static Type get(final CtClass llllllllllllllIlIllIIlllIIIIlIll) {
        final Type llllllllllllllIlIllIIlllIIIIllII = Type.prims.get(llllllllllllllIlIllIIlllIIIIlIll);
        return (llllllllllllllIlIllIIlllIIIIllII != null) ? llllllllllllllIlIllIIlllIIIIllII : new Type(llllllllllllllIlIllIIlllIIIIlIll);
    }
    
    public int getSize() {
        return (this.clazz == CtClass.doubleType || this.clazz == CtClass.longType || this == Type.TOP) ? 2 : 1;
    }
    
    public Type getComponent() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        com/viaversion/viaversion/libs/javassist/bytecode/analysis/Type.clazz:Lcom/viaversion/viaversion/libs/javassist/CtClass;
        //     4: ifnull          17
        //     7: aload_0         /* llllllllllllllIlIllIIllIllIlIIII */
        //     8: getfield        com/viaversion/viaversion/libs/javassist/bytecode/analysis/Type.clazz:Lcom/viaversion/viaversion/libs/javassist/CtClass;
        //    11: invokevirtual   com/viaversion/viaversion/libs/javassist/CtClass.isArray:()Z
        //    14: ifne            19
        //    17: aconst_null    
        //    18: areturn        
        //    19: aload_0         /* llllllllllllllIlIllIIllIllIlIIII */
        //    20: getfield        com/viaversion/viaversion/libs/javassist/bytecode/analysis/Type.clazz:Lcom/viaversion/viaversion/libs/javassist/CtClass;
        //    23: invokevirtual   com/viaversion/viaversion/libs/javassist/CtClass.getComponentType:()Lcom/viaversion/viaversion/libs/javassist/CtClass;
        //    26: astore_1        /* llllllllllllllIlIllIIllIllIlIlIl */
        //    27: goto            40
        //    30: astore_2        /* llllllllllllllIlIllIIllIllIlIlII */
        //    31: new             Ljava/lang/RuntimeException;
        //    34: dup            
        //    35: aload_2         /* llllllllllllllIlIllIIllIllIlIlII */
        //    36: invokespecial   java/lang/RuntimeException.<init>:(Ljava/lang/Throwable;)V
        //    39: athrow         
        //    40: getstatic       com/viaversion/viaversion/libs/javassist/bytecode/analysis/Type.prims:Ljava/util/Map;
        //    43: aload_1         /* llllllllllllllIlIllIIllIllIlIIlI */
        //    44: invokeinterface java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //    49: checkcast       Lcom/viaversion/viaversion/libs/javassist/bytecode/analysis/Type;
        //    52: astore_2        /* llllllllllllllIlIllIIllIllIlIIIl */
        //    53: aload_2         /* llllllllllllllIlIllIIllIllIlIIIl */
        //    54: ifnull          61
        //    57: aload_2         /* llllllllllllllIlIllIIllIllIlIIIl */
        //    58: goto            69
        //    61: new             Lcom/viaversion/viaversion/libs/javassist/bytecode/analysis/Type;
        //    64: dup            
        //    65: aload_1         /* llllllllllllllIlIllIIllIllIlIIlI */
        //    66: invokespecial   com/viaversion/viaversion/libs/javassist/bytecode/analysis/Type.<init>:(Lcom/viaversion/viaversion/libs/javassist/CtClass;)V
        //    69: areturn        
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                                        
        //  -----  -----  -----  -----  ------------------------------------------------------------
        //  19     27     30     40     Lcom/viaversion/viaversion/libs/javassist/NotFoundException;
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private static Type lookupType(final String llllllllllllllIlIllIIlllIIIIIlIl) {
        try {
            return new Type(ClassPool.getDefault().get(llllllllllllllIlIllIIlllIIIIIlIl));
        }
        catch (NotFoundException llllllllllllllIlIllIIlllIIIIIlll) {
            throw new RuntimeException(llllllllllllllIlIllIIlllIIIIIlll);
        }
    }
    
    private Type mergeArray(final Type llllllllllllllIlIllIIllIIllllIIl) {
        final Type llllllllllllllIlIllIIllIlIIIIIII = this.getRootComponent(llllllllllllllIlIllIIllIIllllIIl);
        final Type llllllllllllllIlIllIIllIIlllllll = this.getRootComponent(this);
        final int llllllllllllllIlIllIIllIIllllllI = llllllllllllllIlIllIIllIIllllIIl.getDimensions();
        final int llllllllllllllIlIllIIllIIlllllIl = this.getDimensions();
        if (llllllllllllllIlIllIIllIIllllllI == llllllllllllllIlIllIIllIIlllllIl) {
            final Type llllllllllllllIlIllIIllIlIIIIlIl = llllllllllllllIlIllIIllIIlllllll.merge(llllllllllllllIlIllIIllIlIIIIIII);
            if (llllllllllllllIlIllIIllIlIIIIlIl == Type.BOGUS) {
                return Type.OBJECT;
            }
            return this.createArray(llllllllllllllIlIllIIllIlIIIIlIl, llllllllllllllIlIllIIllIIlllllIl);
        }
        else {
            Type llllllllllllllIlIllIIllIIlllllII = null;
            int llllllllllllllIlIllIIllIIllllIll = 0;
            if (llllllllllllllIlIllIIllIIllllllI < llllllllllllllIlIllIIllIIlllllIl) {
                final Type llllllllllllllIlIllIIllIlIIIIlII = llllllllllllllIlIllIIllIlIIIIIII;
                final int llllllllllllllIlIllIIllIlIIIIIll = llllllllllllllIlIllIIllIIllllllI;
            }
            else {
                llllllllllllllIlIllIIllIIlllllII = llllllllllllllIlIllIIllIIlllllll;
                llllllllllllllIlIllIIllIIllllIll = llllllllllllllIlIllIIllIIlllllIl;
            }
            if (eq(Type.CLONEABLE.clazz, llllllllllllllIlIllIIllIIlllllII.clazz) || eq(Type.SERIALIZABLE.clazz, llllllllllllllIlIllIIllIIlllllII.clazz)) {
                return this.createArray(llllllllllllllIlIllIIllIIlllllII, llllllllllllllIlIllIIllIIllllIll);
            }
            return this.createArray(Type.OBJECT, llllllllllllllIlIllIIllIIllllIll);
        }
    }
    
    @Override
    public boolean equals(final Object llllllllllllllIlIllIIlIlllIlIIIl) {
        return llllllllllllllIlIllIIlIlllIlIIIl instanceof Type && llllllllllllllIlIllIIlIlllIlIIIl.getClass() == this.getClass() && eq(this.clazz, ((Type)llllllllllllllIlIllIIlIlllIlIIIl).clazz);
    }
    
    public Type merge(final Type llllllllllllllIlIllIIllIlIllllIl) {
        if (llllllllllllllIlIllIIllIlIllllIl == this) {
            return this;
        }
        if (llllllllllllllIlIllIIllIlIllllIl == null) {
            return this;
        }
        if (llllllllllllllIlIllIIllIlIllllIl == Type.UNINIT) {
            return this;
        }
        if (this == Type.UNINIT) {
            return llllllllllllllIlIllIIllIlIllllIl;
        }
        if (!llllllllllllllIlIllIIllIlIllllIl.isReference() || !this.isReference()) {
            return Type.BOGUS;
        }
        if (llllllllllllllIlIllIIllIlIllllIl instanceof MultiType) {
            return llllllllllllllIlIllIIllIlIllllIl.merge(this);
        }
        if (llllllllllllllIlIllIIllIlIllllIl.isArray() && this.isArray()) {
            return this.mergeArray(llllllllllllllIlIllIIllIlIllllIl);
        }
        try {
            return this.mergeClasses(llllllllllllllIlIllIIllIlIllllIl);
        }
        catch (NotFoundException llllllllllllllIlIllIIllIllIIIIIl) {
            throw new RuntimeException(llllllllllllllIlIllIIllIllIIIIIl);
        }
    }
    
    private Map<String, CtClass> findCommonInterfaces(final Type llllllllllllllIlIllIIllIIlIIIlII) {
        final Map<String, CtClass> llllllllllllllIlIllIIllIIlIIIlll = this.getAllInterfaces(llllllllllllllIlIllIIllIIlIIIlII.clazz, null);
        final Map<String, CtClass> llllllllllllllIlIllIIllIIlIIIllI = this.getAllInterfaces(this.clazz, null);
        return this.findCommonInterfaces(llllllllllllllIlIllIIllIIlIIIlll, llllllllllllllIlIllIIllIIlIIIllI);
    }
}
