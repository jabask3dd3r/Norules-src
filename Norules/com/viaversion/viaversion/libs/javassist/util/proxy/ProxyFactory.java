package com.viaversion.viaversion.libs.javassist.util.proxy;

import java.security.*;
import java.lang.invoke.*;
import com.viaversion.viaversion.libs.javassist.*;
import java.util.*;
import com.viaversion.viaversion.libs.javassist.bytecode.*;
import java.lang.reflect.*;
import java.lang.ref.*;

public class ProxyFactory
{
    private /* synthetic */ String classname;
    private /* synthetic */ MethodHandler handler;
    private static /* synthetic */ char[] hexDigits;
    private /* synthetic */ Class<?> superClass;
    public static volatile /* synthetic */ boolean useWriteReplace;
    private static /* synthetic */ Map<ClassLoader, Map<String, ProxyDetails>> proxyCache;
    private /* synthetic */ boolean factoryWriteReplace;
    public static /* synthetic */ boolean onlyPublicMethods;
    private /* synthetic */ List<Map.Entry<String, Method>> signatureMethods;
    private static final /* synthetic */ String HANDLER_GETTER_TYPE;
    private static final /* synthetic */ String HANDLER_TYPE;
    private /* synthetic */ String superName;
    private /* synthetic */ boolean factoryUseCache;
    public static volatile /* synthetic */ boolean useCache;
    private static final /* synthetic */ String HANDLER_SETTER_TYPE;
    private static final /* synthetic */ Class<?> OBJECT_TYPE;
    private /* synthetic */ byte[] signature;
    private static /* synthetic */ Comparator<Map.Entry<String, Method>> sorter;
    public static /* synthetic */ UniqueName nameGenerator;
    public static /* synthetic */ ClassLoaderProvider classLoaderProvider;
    private /* synthetic */ boolean hasGetHandler;
    private /* synthetic */ String genericSignature;
    public /* synthetic */ String writeDirectory;
    private /* synthetic */ Class<?>[] interfaces;
    private /* synthetic */ String basename;
    private /* synthetic */ MethodFilter methodFilter;
    private /* synthetic */ Class<?> thisClass;
    
    public static boolean isProxyClass(final Class<?> lllllllllllllIIIIIIIIIIIIlIIlIll) {
        return Proxy.class.isAssignableFrom(lllllllllllllIIIIIIIIIIIIlIIlIll);
    }
    
    private static void setInterfaces(final ClassFile llllllllllllIllllllllllIllIlIIIl, final Class<?>[] llllllllllllIllllllllllIllIlIIII, final Class<?> llllllllllllIllllllllllIllIlIlII) {
        final String llllllllllllIllllllllllIllIlIIll = llllllllllllIllllllllllIllIlIlII.getName();
        String[] llllllllllllIllllllllllIllIlIIlI = null;
        if (llllllllllllIllllllllllIllIlIIII == null || llllllllllllIllllllllllIllIlIIII.length == 0) {
            final String[] llllllllllllIllllllllllIllIllIII = { llllllllllllIllllllllllIllIlIIll };
        }
        else {
            llllllllllllIllllllllllIllIlIIlI = new String[llllllllllllIllllllllllIllIlIIII.length + 1];
            for (int llllllllllllIllllllllllIllIlIlll = 0; llllllllllllIllllllllllIllIlIlll < llllllllllllIllllllllllIllIlIIII.length; ++llllllllllllIllllllllllIllIlIlll) {
                llllllllllllIllllllllllIllIlIIlI[llllllllllllIllllllllllIllIlIlll] = llllllllllllIllllllllllIllIlIIII[llllllllllllIllllllllllIllIlIlll].getName();
            }
            llllllllllllIllllllllllIllIlIIlI[llllllllllllIllllllllllIllIlIIII.length] = llllllllllllIllllllllllIllIlIIll;
        }
        llllllllllllIllllllllllIllIlIIIl.setInterfaces(llllllllllllIllllllllllIllIlIIlI);
    }
    
    private static void setThrows(final MethodInfo llllllllllllIlllllllllIlIIIlIIII, final ConstPool llllllllllllIlllllllllIlIIIIllll, final Method llllllllllllIlllllllllIlIIIIlIlI) {
        final Class<?>[] llllllllllllIlllllllllIlIIIIllIl = llllllllllllIlllllllllIlIIIIlIlI.getExceptionTypes();
        setThrows(llllllllllllIlllllllllIlIIIlIIII, llllllllllllIlllllllllIlIIIIllll, llllllllllllIlllllllllIlIIIIllIl);
    }
    
    private void setBit(final byte[] llllllllllllIllllllllllIlllIIlll, final int llllllllllllIllllllllllIlllIIIll) {
        final int llllllllllllIllllllllllIlllIIlIl = llllllllllllIllllllllllIlllIIIll >> 3;
        if (llllllllllllIllllllllllIlllIIlIl < llllllllllllIllllllllllIlllIIlll.length) {
            final int llllllllllllIllllllllllIlllIlIll = llllllllllllIllllllllllIlllIIIll & 0x7;
            final int llllllllllllIllllllllllIlllIlIlI = 1 << llllllllllllIllllllllllIlllIlIll;
            final int llllllllllllIllllllllllIlllIlIIl = llllllllllllIllllllllllIlllIIlll[llllllllllllIllllllllllIlllIIlIl];
            llllllllllllIllllllllllIlllIIlll[llllllllllllIllllllllllIlllIIlIl] = (byte)(llllllllllllIllllllllllIlllIlIIl | llllllllllllIllllllllllIlllIlIlI);
        }
    }
    
    static byte[] getFilterSignature(final Class<?> llllllllllllIllllllllllllIlIIIlI) {
        return (byte[])getField(llllllllllllIllllllllllllIlIIIlI, "_filter_signature");
    }
    
    private void installSignature(final byte[] llllllllllllIlllllllllllIIIIlIll) {
        this.makeSortedMethodList();
        final int llllllllllllIlllllllllllIIIIlIlI = this.signatureMethods.size();
        final int llllllllllllIlllllllllllIIIIlIIl = llllllllllllIlllllllllllIIIIlIlI + 7 >> 3;
        if (llllllllllllIlllllllllllIIIIlIll.length != llllllllllllIlllllllllllIIIIlIIl) {
            throw new RuntimeException("invalid filter signature length for deserialized proxy class");
        }
        this.signature = llllllllllllIlllllllllllIIIIlIll;
    }
    
    private static String keyToDesc(final String llllllllllllIlllllllllIllIIlIlII, final Method llllllllllllIlllllllllIllIIlIlIl) {
        return llllllllllllIlllllllllIllIIlIlII.substring(llllllllllllIlllllllllIllIIlIlII.indexOf(58) + 1);
    }
    
    private static void callFind2Methods(final Bytecode llllllllllllIllllllllllIlIIlllll, final String llllllllllllIllllllllllIlIIllllI, final String llllllllllllIllllllllllIlIIlIlII, final int llllllllllllIllllllllllIlIIlllII, final String llllllllllllIllllllllllIlIIlIIlI, final int llllllllllllIllllllllllIlIIlIIIl, final int llllllllllllIllllllllllIlIIllIIl) {
        final String llllllllllllIllllllllllIlIIllIII = RuntimeSupport.class.getName();
        final String llllllllllllIllllllllllIlIIlIlll = "(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;[Ljava/lang/reflect/Method;)V";
        llllllllllllIllllllllllIlIIlllll.addAload(llllllllllllIllllllllllIlIIlIIIl);
        llllllllllllIllllllllllIlIIlllll.addLdc(llllllllllllIllllllllllIlIIllllI);
        if (llllllllllllIllllllllllIlIIlIlII == null) {
            llllllllllllIllllllllllIlIIlllll.addOpcode(1);
        }
        else {
            llllllllllllIllllllllllIlIIlllll.addLdc(llllllllllllIllllllllllIlIIlIlII);
        }
        llllllllllllIllllllllllIlIIlllll.addIconst(llllllllllllIllllllllllIlIIlllII);
        llllllllllllIllllllllllIlIIlllll.addLdc(llllllllllllIllllllllllIlIIlIIlI);
        llllllllllllIllllllllllIlIIlllll.addAload(llllllllllllIllllllllllIlIIllIIl);
        llllllllllllIllllllllllIlIIlllll.addInvokestatic(llllllllllllIllllllllllIlIIllIII, "find2Methods", llllllllllllIllllllllllIlIIlIlll);
    }
    
    private static MethodInfo makeWriteReplace(final ConstPool llllllllllllIlllllllllIIlIlIIlIl) {
        final MethodInfo llllllllllllIlllllllllIIlIlIIlII = new MethodInfo(llllllllllllIlllllllllIIlIlIIlIl, "writeReplace", "()Ljava/lang/Object;");
        final String[] llllllllllllIlllllllllIIlIlIIIll = { "java.io.ObjectStreamException" };
        final ExceptionsAttribute llllllllllllIlllllllllIIlIlIIIlI = new ExceptionsAttribute(llllllllllllIlllllllllIIlIlIIlIl);
        llllllllllllIlllllllllIIlIlIIIlI.setExceptions(llllllllllllIlllllllllIIlIlIIIll);
        llllllllllllIlllllllllIIlIlIIlII.setExceptionsAttribute(llllllllllllIlllllllllIIlIlIIIlI);
        final Bytecode llllllllllllIlllllllllIIlIlIIIIl = new Bytecode(llllllllllllIlllllllllIIlIlIIlIl, 0, 1);
        llllllllllllIlllllllllIIlIlIIIIl.addAload(0);
        llllllllllllIlllllllllIIlIlIIIIl.addInvokestatic("com.viaversion.viaversion.libs.javassist.util.proxy.RuntimeSupport", "makeSerializedProxy", "(Ljava/lang/Object;)Ljavassist/util/proxy/SerializedProxy;");
        llllllllllllIlllllllllIIlIlIIIIl.addOpcode(176);
        llllllllllllIlllllllllIIlIlIIlII.setCodeAttribute(llllllllllllIlllllllllIIlIlIIIIl.toCodeAttribute());
        return llllllllllllIlllllllllIIlIlIIlII;
    }
    
    public void setUseCache(final boolean lllllllllllllIIIIIIIIIIIIlIllIIl) {
        if (this.handler != null && lllllllllllllIIIIIIIIIIIIlIllIIl) {
            throw new RuntimeException("caching cannot be enabled if the factory default interceptor has been set");
        }
        this.factoryUseCache = lllllllllllllIIIIIIIIIIIIlIllIIl;
    }
    
    protected ProtectionDomain getDomain() {
        Class<?> llllllllllllIlllllllllllIllllIll = null;
        if (this.superClass != null && !this.superClass.getName().equals("java.lang.Object")) {
            final Class<?> llllllllllllIlllllllllllIllllllI = this.superClass;
        }
        else if (this.interfaces != null && this.interfaces.length > 0) {
            final Class<?> llllllllllllIlllllllllllIlllllIl = this.interfaces[0];
        }
        else {
            llllllllllllIlllllllllllIllllIll = this.getClass();
        }
        return llllllllllllIlllllllllllIllllIll.getProtectionDomain();
    }
    
    private static Object getField(final Class<?> llllllllllllIllllllllllllIIlIlll, final String llllllllllllIllllllllllllIIlIllI) {
        try {
            final Field llllllllllllIllllllllllllIIlllII = llllllllllllIllllllllllllIIlIlll.getField(llllllllllllIllllllllllllIIlIllI);
            llllllllllllIllllllllllllIIlllII.setAccessible(true);
            final Object llllllllllllIllllllllllllIIllIll = llllllllllllIllllllllllllIIlllII.get(null);
            llllllllllllIllllllllllllIIlllII.setAccessible(false);
            return llllllllllllIllllllllllllIIllIll;
        }
        catch (Exception llllllllllllIllllllllllllIIllIlI) {
            throw new RuntimeException(llllllllllllIllllllllllllIIllIlI);
        }
    }
    
    private void createClass2(final ClassLoader llllllllllllIlllllllllllllIIllII, final MethodHandles.Lookup llllllllllllIlllllllllllllIIlIll) {
        final String llllllllllllIlllllllllllllIIlIlI = this.getKey(this.superClass, this.interfaces, this.signature, this.factoryWriteReplace);
        Map<String, ProxyDetails> llllllllllllIlllllllllllllIIlIIl = ProxyFactory.proxyCache.get(llllllllllllIlllllllllllllIIllII);
        if (llllllllllllIlllllllllllllIIlIIl == null) {
            llllllllllllIlllllllllllllIIlIIl = new HashMap<String, ProxyDetails>();
            ProxyFactory.proxyCache.put(llllllllllllIlllllllllllllIIllII, llllllllllllIlllllllllllllIIlIIl);
        }
        ProxyDetails llllllllllllIlllllllllllllIIlIII = llllllllllllIlllllllllllllIIlIIl.get(llllllllllllIlllllllllllllIIlIlI);
        if (llllllllllllIlllllllllllllIIlIII != null) {
            final Reference<Class<?>> llllllllllllIlllllllllllllIIlllI = llllllllllllIlllllllllllllIIlIII.proxyClass;
            this.thisClass = llllllllllllIlllllllllllllIIlllI.get();
            if (this.thisClass != null) {
                return;
            }
        }
        this.createClass3(llllllllllllIlllllllllllllIIllII, llllllllllllIlllllllllllllIIlIll);
        llllllllllllIlllllllllllllIIlIII = new ProxyDetails(this.signature, this.thisClass, this.factoryWriteReplace);
        llllllllllllIlllllllllllllIIlIIl.put(llllllllllllIlllllllllllllIIlIlI, llllllllllllIlllllllllllllIIlIII);
    }
    
    public boolean isUseWriteReplace() {
        return this.factoryWriteReplace;
    }
    
    private static boolean isDuplicated(final int llllllllllllIlllllllllIllIlIlIlI, final Method[] llllllllllllIlllllllllIllIlIlIIl) {
        final String llllllllllllIlllllllllIllIlIlIll = llllllllllllIlllllllllIllIlIlIIl[llllllllllllIlllllllllIllIlIlIlI].getName();
        for (int llllllllllllIlllllllllIllIlIlllI = 0; llllllllllllIlllllllllIllIlIlllI < llllllllllllIlllllllllIllIlIlIIl.length; ++llllllllllllIlllllllllIllIlIlllI) {
            if (llllllllllllIlllllllllIllIlIlllI != llllllllllllIlllllllllIllIlIlIlI && llllllllllllIlllllllllIllIlIlIll.equals(llllllllllllIlllllllllIllIlIlIIl[llllllllllllIlllllllllIllIlIlllI].getName()) && areParametersSame(llllllllllllIlllllllllIllIlIlIIl[llllllllllllIlllllllllIllIlIlIlI], llllllllllllIlllllllllIllIlIlIIl[llllllllllllIlllllllllIllIlIlllI])) {
                return true;
            }
        }
        return false;
    }
    
    static {
        HANDLER_GETTER_KEY = "getHandler:()";
        FILTER_SIGNATURE_TYPE = "[B";
        packageForJavaBase = "com.viaversion.viaversion.libs.javassist.util.proxy.";
        SERIAL_VERSION_UID_FIELD = "serialVersionUID";
        DEFAULT_INTERCEPTOR = "default_interceptor";
        HANDLER_SETTER = "setHandler";
        HANDLER_GETTER = "getHandler";
        SERIAL_VERSION_UID_TYPE = "J";
        HOLDER_TYPE = "[Ljava/lang/reflect/Method;";
        HANDLER = "handler";
        FILTER_SIGNATURE_FIELD = "_filter_signature";
        HOLDER = "_methods_";
        NULL_INTERCEPTOR_HOLDER = "com.viaversion.viaversion.libs.javassist.util.proxy.RuntimeSupport";
        ProxyFactory.onlyPublicMethods = false;
        OBJECT_TYPE = Object.class;
        HANDLER_TYPE = String.valueOf(new StringBuilder().append('L').append(MethodHandler.class.getName().replace('.', '/')).append(';'));
        HANDLER_SETTER_TYPE = String.valueOf(new StringBuilder().append("(").append(ProxyFactory.HANDLER_TYPE).append(")V"));
        HANDLER_GETTER_TYPE = String.valueOf(new StringBuilder().append("()").append(ProxyFactory.HANDLER_TYPE));
        ProxyFactory.useCache = true;
        ProxyFactory.useWriteReplace = true;
        ProxyFactory.proxyCache = new WeakHashMap<ClassLoader, Map<String, ProxyDetails>>();
        ProxyFactory.hexDigits = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
        ProxyFactory.classLoaderProvider = new ClassLoaderProvider() {
            @Override
            public ClassLoader get(final ProxyFactory llllllllllllIlllllllIllIIllIllIl) {
                return llllllllllllIlllllllIllIIllIllIl.getClassLoader0();
            }
        };
        ProxyFactory.nameGenerator = new UniqueName() {
            private final /* synthetic */ String sep = String.valueOf(new StringBuilder().append("_$$_jvst").append(Integer.toHexString(this.hashCode() & 0xFFF)).append("_"));
            private /* synthetic */ int counter = 0;
            
            @Override
            public String get(final String lllllllllllllIlIIIIllllIlIlIllll) {
                return String.valueOf(new StringBuilder().append(lllllllllllllIlIIIIllllIlIlIllll).append(this.sep).append(Integer.toHexString(this.counter++)));
            }
        };
        ProxyFactory.sorter = new Comparator<Map.Entry<String, Method>>() {
            @Override
            public int compare(final Map.Entry<String, Method> llllllllllllllIIIlIIlllIIlIIllll, final Map.Entry<String, Method> llllllllllllllIIIlIIlllIIlIIlllI) {
                return llllllllllllllIIIlIIlllIIlIIllll.getKey().compareTo((String)llllllllllllllIIIlIIlllIIlIIlllI.getKey());
            }
        };
    }
    
    private void makeSortedMethodList() {
        this.checkClassAndSuperName();
        this.hasGetHandler = false;
        final Map<String, Method> llllllllllllIlllllllllllIIlIlIII = this.getMethods(this.superClass, this.interfaces);
        this.signatureMethods = new ArrayList<Map.Entry<String, Method>>(llllllllllllIlllllllllllIIlIlIII.entrySet());
        Collections.sort(this.signatureMethods, ProxyFactory.sorter);
    }
    
    private void makeConstructors(final String llllllllllllIllllllllllIIIIlllIl, final ClassFile llllllllllllIllllllllllIIIIlllII, final ConstPool llllllllllllIllllllllllIIIIlIlII, final String llllllllllllIllllllllllIIIIllIlI) throws CannotCompileException {
        final Constructor<?>[] llllllllllllIllllllllllIIIIllIIl = SecurityActions.getDeclaredConstructors(this.superClass);
        final boolean llllllllllllIllllllllllIIIIllIII = !this.factoryUseCache;
        for (int llllllllllllIllllllllllIIIIlllll = 0; llllllllllllIllllllllllIIIIlllll < llllllllllllIllllllllllIIIIllIIl.length; ++llllllllllllIllllllllllIIIIlllll) {
            final Constructor<?> llllllllllllIllllllllllIIIlIIIIl = llllllllllllIllllllllllIIIIllIIl[llllllllllllIllllllllllIIIIlllll];
            final int llllllllllllIllllllllllIIIlIIIII = llllllllllllIllllllllllIIIlIIIIl.getModifiers();
            if (!Modifier.isFinal(llllllllllllIllllllllllIIIlIIIII) && !Modifier.isPrivate(llllllllllllIllllllllllIIIlIIIII) && isVisible(llllllllllllIllllllllllIIIlIIIII, this.basename, llllllllllllIllllllllllIIIlIIIIl)) {
                final MethodInfo llllllllllllIllllllllllIIIlIIIlI = makeConstructor(llllllllllllIllllllllllIIIIlllIl, llllllllllllIllllllllllIIIlIIIIl, llllllllllllIllllllllllIIIIlIlII, this.superClass, llllllllllllIllllllllllIIIIllIII);
                llllllllllllIllllllllllIIIIlllII.addMethod(llllllllllllIllllllllllIIIlIIIlI);
            }
        }
    }
    
    private static boolean makeUniqueName0(final String llllllllllllIlllllllllIlllllllIl, final Iterator<Map.Entry<String, Method>> llllllllllllIlllllllllIllllllllI) {
        while (llllllllllllIlllllllllIllllllllI.hasNext()) {
            if (llllllllllllIlllllllllIllllllllI.next().getKey().startsWith(llllllllllllIlllllllllIlllllllIl)) {
                return false;
            }
        }
        return true;
    }
    
    public void setUseWriteReplace(final boolean lllllllllllllIIIIIIIIIIIIlIIlllI) {
        this.factoryWriteReplace = lllllllllllllIIIIIIIIIIIIlIIlllI;
    }
    
    private static boolean isBridge(final Method llllllllllllIllllllllllIIlIlIIlI) {
        return llllllllllllIllllllllllIIlIlIIlI.isBridge();
    }
    
    private static int addLoadParameters(final Bytecode llllllllllllIlllllllllIIllllIIIl, final Class<?>[] llllllllllllIlllllllllIIlllIlIll, final int llllllllllllIlllllllllIIlllIllll) {
        int llllllllllllIlllllllllIIlllIlllI = 0;
        for (int llllllllllllIlllllllllIIlllIllIl = llllllllllllIlllllllllIIlllIlIll.length, llllllllllllIlllllllllIIllllIIlI = 0; llllllllllllIlllllllllIIllllIIlI < llllllllllllIlllllllllIIlllIllIl; ++llllllllllllIlllllllllIIllllIIlI) {
            llllllllllllIlllllllllIIlllIlllI += addLoad(llllllllllllIlllllllllIIllllIIIl, llllllllllllIlllllllllIIlllIlllI + llllllllllllIlllllllllIIlllIllll, llllllllllllIlllllllllIIlllIlIll[llllllllllllIlllllllllIIllllIIlI]);
        }
        return llllllllllllIlllllllllIIlllIlllI;
    }
    
    public ProxyFactory() {
        this.superClass = null;
        this.interfaces = null;
        this.methodFilter = null;
        this.handler = null;
        this.signature = null;
        this.signatureMethods = null;
        this.hasGetHandler = false;
        this.thisClass = null;
        this.genericSignature = null;
        this.writeDirectory = null;
        this.factoryUseCache = ProxyFactory.useCache;
        this.factoryWriteReplace = ProxyFactory.useWriteReplace;
    }
    
    private int overrideMethods(final ClassFile llllllllllllIllllllllllIIllIIlII, final ConstPool llllllllllllIllllllllllIIllIIIll, final String llllllllllllIllllllllllIIlIllIlI, final List<Find2MethodsArgs> llllllllllllIllllllllllIIlIllIIl) throws CannotCompileException {
        final String llllllllllllIllllllllllIIllIIIII = makeUniqueName("_d", this.signatureMethods);
        final Iterator<Map.Entry<String, Method>> llllllllllllIllllllllllIIlIlllll = this.signatureMethods.iterator();
        int llllllllllllIllllllllllIIlIllllI = 0;
        while (llllllllllllIllllllllllIIlIlllll.hasNext()) {
            final Map.Entry<String, Method> llllllllllllIllllllllllIIllIIllI = llllllllllllIllllllllllIIlIlllll.next();
            if ((ClassFile.MAJOR_VERSION < 49 || !isBridge(llllllllllllIllllllllllIIllIIllI.getValue())) && this.testBit(this.signature, llllllllllllIllllllllllIIlIllllI)) {
                this.override(llllllllllllIllllllllllIIlIllIlI, llllllllllllIllllllllllIIllIIllI.getValue(), llllllllllllIllllllllllIIllIIIII, llllllllllllIllllllllllIIlIllllI, keyToDesc(llllllllllllIllllllllllIIllIIllI.getKey(), llllllllllllIllllllllllIIllIIllI.getValue()), llllllllllllIllllllllllIIllIIlII, llllllllllllIllllllllllIIllIIIll, llllllllllllIllllllllllIIlIllIIl);
            }
            ++llllllllllllIllllllllllIIlIllllI;
        }
        return llllllllllllIllllllllllIIlIllllI;
    }
    
    protected ClassLoader getClassLoader() {
        return ProxyFactory.classLoaderProvider.get(this);
    }
    
    private static boolean areParametersSame(final Method llllllllllllIlllllllllIllIlIIIII, final Method llllllllllllIlllllllllIllIIllIll) {
        final Class<?>[] llllllllllllIlllllllllIllIIllllI = llllllllllllIlllllllllIllIlIIIII.getParameterTypes();
        final Class<?>[] llllllllllllIlllllllllIllIIlllIl = llllllllllllIlllllllllIllIIllIll.getParameterTypes();
        if (llllllllllllIlllllllllIllIIllllI.length == llllllllllllIlllllllllIllIIlllIl.length) {
            for (int llllllllllllIlllllllllIllIlIIIIl = 0; llllllllllllIlllllllllIllIlIIIIl < llllllllllllIlllllllllIllIIllllI.length; ++llllllllllllIlllllllllIllIlIIIIl) {
                if (!llllllllllllIlllllllllIllIIllllI[llllllllllllIlllllllllIllIlIIIIl].getName().equals(llllllllllllIlllllllllIllIIlllIl[llllllllllllIlllllllllIllIlIIIIl].getName())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
    public void setSuperclass(final Class<?> lllllllllllllIIIIIIIIIIIIlIIIIlI) {
        this.superClass = lllllllllllllIIIIIIIIIIIIlIIIIlI;
        this.signature = null;
    }
    
    private MethodInfo makeDelegator(final Method llllllllllllIlllllllllIlIlIllIlI, final String llllllllllllIlllllllllIlIlIllIIl, final ConstPool llllllllllllIlllllllllIlIlIllIII, final Class<?> llllllllllllIlllllllllIlIllIIIIl, final String llllllllllllIlllllllllIlIllIIIII) {
        final MethodInfo llllllllllllIlllllllllIlIlIlllll = new MethodInfo(llllllllllllIlllllllllIlIlIllIII, llllllllllllIlllllllllIlIllIIIII, llllllllllllIlllllllllIlIlIllIIl);
        llllllllllllIlllllllllIlIlIlllll.setAccessFlags(0x11 | (llllllllllllIlllllllllIlIlIllIlI.getModifiers() & 0xFFFFFAD9));
        setThrows(llllllllllllIlllllllllIlIlIlllll, llllllllllllIlllllllllIlIlIllIII, llllllllllllIlllllllllIlIlIllIlI);
        final Bytecode llllllllllllIlllllllllIlIlIllllI = new Bytecode(llllllllllllIlllllllllIlIlIllIII, 0, 0);
        llllllllllllIlllllllllIlIlIllllI.addAload(0);
        int llllllllllllIlllllllllIlIlIlllIl = addLoadParameters(llllllllllllIlllllllllIlIlIllllI, llllllllllllIlllllllllIlIlIllIlI.getParameterTypes(), 1);
        final Class<?> llllllllllllIlllllllllIlIlIlllII = this.invokespecialTarget(llllllllllllIlllllllllIlIllIIIIl);
        llllllllllllIlllllllllIlIlIllllI.addInvokespecial(llllllllllllIlllllllllIlIlIlllII.isInterface(), llllllllllllIlllllllllIlIlIllIII.addClassInfo(llllllllllllIlllllllllIlIlIlllII.getName()), llllllllllllIlllllllllIlIlIllIlI.getName(), llllllllllllIlllllllllIlIlIllIIl);
        addReturn(llllllllllllIlllllllllIlIlIllllI, llllllllllllIlllllllllIlIlIllIlI.getReturnType());
        llllllllllllIlllllllllIlIlIllllI.setMaxLocals(++llllllllllllIlllllllllIlIlIlllIl);
        llllllllllllIlllllllllIlIlIlllll.setCodeAttribute(llllllllllllIlllllllllIlIlIllllI.toCodeAttribute());
        return llllllllllllIlllllllllIlIlIlllll;
    }
    
    private void createClass3(final ClassLoader llllllllllllIllllllllllllIlllIIl, final MethodHandles.Lookup llllllllllllIllllllllllllIlllIII) {
        this.allocateClassName();
        try {
            final ClassFile llllllllllllIllllllllllllIllllII = this.make();
            if (this.writeDirectory != null) {
                FactoryHelper.writeFile(llllllllllllIllllllllllllIllllII, this.writeDirectory);
            }
            if (llllllllllllIllllllllllllIlllIII == null) {
                this.thisClass = FactoryHelper.toClass(llllllllllllIllllllllllllIllllII, this.getClassInTheSamePackage(), llllllllllllIllllllllllllIlllIIl, this.getDomain());
            }
            else {
                this.thisClass = FactoryHelper.toClass(llllllllllllIllllllllllllIllllII, llllllllllllIllllllllllllIlllIII);
            }
            this.setField("_filter_signature", this.signature);
            if (!this.factoryUseCache) {
                this.setField("default_interceptor", this.handler);
            }
        }
        catch (CannotCompileException llllllllllllIllllllllllllIlllIll) {
            throw new RuntimeException(llllllllllllIllllllllllllIlllIll.getMessage(), llllllllllllIllllllllllllIlllIll);
        }
    }
    
    private static int addReturn(final Bytecode llllllllllllIlllllllllIIllIllIIl, final Class<?> llllllllllllIlllllllllIIllIllIII) {
        if (llllllllllllIlllllllllIIllIllIII.isPrimitive()) {
            if (llllllllllllIlllllllllIIllIllIII == Long.TYPE) {
                llllllllllllIlllllllllIIllIllIIl.addOpcode(173);
                return 2;
            }
            if (llllllllllllIlllllllllIIllIllIII == Float.TYPE) {
                llllllllllllIlllllllllIIllIllIIl.addOpcode(174);
            }
            else {
                if (llllllllllllIlllllllllIIllIllIII == Double.TYPE) {
                    llllllllllllIlllllllllIIllIllIIl.addOpcode(175);
                    return 2;
                }
                if (llllllllllllIlllllllllIIllIllIII == Void.TYPE) {
                    llllllllllllIlllllllllIIllIllIIl.addOpcode(177);
                    return 0;
                }
                llllllllllllIlllllllllIIllIllIIl.addOpcode(172);
            }
        }
        else {
            llllllllllllIlllllllllIIllIllIIl.addOpcode(176);
        }
        return 1;
    }
    
    private static void makeParameterList(final Bytecode llllllllllllIlllllllllIIllIIllll, final Class<?>[] llllllllllllIlllllllllIIllIIlllI) {
        int llllllllllllIlllllllllIIllIIllIl = 1;
        final int llllllllllllIlllllllllIIllIIllII = llllllllllllIlllllllllIIllIIlllI.length;
        llllllllllllIlllllllllIIllIIllll.addIconst(llllllllllllIlllllllllIIllIIllII);
        llllllllllllIlllllllllIIllIIllll.addAnewarray("java/lang/Object");
        for (int llllllllllllIlllllllllIIllIlIIII = 0; llllllllllllIlllllllllIIllIlIIII < llllllllllllIlllllllllIIllIIllII; ++llllllllllllIlllllllllIIllIlIIII) {
            llllllllllllIlllllllllIIllIIllll.addOpcode(89);
            llllllllllllIlllllllllIIllIIllll.addIconst(llllllllllllIlllllllllIIllIlIIII);
            final Class<?> llllllllllllIlllllllllIIllIlIIIl = llllllllllllIlllllllllIIllIIlllI[llllllllllllIlllllllllIIllIlIIII];
            if (llllllllllllIlllllllllIIllIlIIIl.isPrimitive()) {
                llllllllllllIlllllllllIIllIIllIl = makeWrapper(llllllllllllIlllllllllIIllIIllll, llllllllllllIlllllllllIIllIlIIIl, llllllllllllIlllllllllIIllIIllIl);
            }
            else {
                llllllllllllIlllllllllIIllIIllll.addAload(llllllllllllIlllllllllIIllIIllIl);
                ++llllllllllllIlllllllllIIllIIllIl;
            }
            llllllllllllIlllllllllIIllIIllll.addOpcode(83);
        }
    }
    
    private static String getPackageName(final String llllllllllllIlllllllllIllllIlIlI) {
        final int llllllllllllIlllllllllIllllIlIIl = llllllllllllIlllllllllIllllIlIlI.lastIndexOf(46);
        if (llllllllllllIlllllllllIllllIlIIl < 0) {
            return null;
        }
        return llllllllllllIlllllllllIllllIlIlI.substring(0, llllllllllllIlllllllllIllllIlIIl);
    }
    
    private Class<?> getClassInTheSamePackage() {
        if (this.basename.startsWith("com.viaversion.viaversion.libs.javassist.util.proxy.")) {
            return this.getClass();
        }
        if (this.superClass != null && this.superClass != ProxyFactory.OBJECT_TYPE) {
            return this.superClass;
        }
        if (this.interfaces != null && this.interfaces.length > 0) {
            return this.interfaces[0];
        }
        return this.getClass();
    }
    
    private static void addUnwrapper(final Bytecode llllllllllllIlllllllllIIlIllIIII, final Class<?> llllllllllllIlllllllllIIlIlIllIl) {
        if (llllllllllllIlllllllllIIlIlIllIl.isPrimitive()) {
            if (llllllllllllIlllllllllIIlIlIllIl == Void.TYPE) {
                llllllllllllIlllllllllIIlIllIIII.addOpcode(87);
            }
            else {
                final int llllllllllllIlllllllllIIlIllIIlI = FactoryHelper.typeIndex(llllllllllllIlllllllllIIlIlIllIl);
                final String llllllllllllIlllllllllIIlIllIIIl = FactoryHelper.wrapperTypes[llllllllllllIlllllllllIIlIllIIlI];
                llllllllllllIlllllllllIIlIllIIII.addCheckcast(llllllllllllIlllllllllIIlIllIIIl);
                llllllllllllIlllllllllIIlIllIIII.addInvokevirtual(llllllllllllIlllllllllIIlIllIIIl, FactoryHelper.unwarpMethods[llllllllllllIlllllllllIIlIllIIlI], FactoryHelper.unwrapDesc[llllllllllllIlllllllllIIlIllIIlI]);
            }
        }
        else {
            llllllllllllIlllllllllIIlIllIIII.addCheckcast(llllllllllllIlllllllllIIlIlIllIl.getName());
        }
    }
    
    private static void setThrows(final MethodInfo llllllllllllIlllllllllIIllllllIl, final ConstPool llllllllllllIlllllllllIlIIIIIIIl, final Class<?>[] llllllllllllIlllllllllIIlllllIll) {
        if (llllllllllllIlllllllllIIlllllIll.length == 0) {
            return;
        }
        final String[] llllllllllllIlllllllllIIllllllll = new String[llllllllllllIlllllllllIIlllllIll.length];
        for (int llllllllllllIlllllllllIlIIIIIIll = 0; llllllllllllIlllllllllIlIIIIIIll < llllllllllllIlllllllllIIlllllIll.length; ++llllllllllllIlllllllllIlIIIIIIll) {
            llllllllllllIlllllllllIIllllllll[llllllllllllIlllllllllIlIIIIIIll] = llllllllllllIlllllllllIIlllllIll[llllllllllllIlllllllllIlIIIIIIll].getName();
        }
        final ExceptionsAttribute llllllllllllIlllllllllIIlllllllI = new ExceptionsAttribute(llllllllllllIlllllllllIlIIIIIIIl);
        llllllllllllIlllllllllIIlllllllI.setExceptions(llllllllllllIlllllllllIIllllllll);
        llllllllllllIlllllllllIIllllllIl.setExceptionsAttribute(llllllllllllIlllllllllIIlllllllI);
    }
    
    public boolean isUseCache() {
        return this.factoryUseCache;
    }
    
    private static void addSetter(final String llllllllllllIllllllllllIlIIIIIll, final ClassFile llllllllllllIllllllllllIlIIIIIlI, final ConstPool llllllllllllIllllllllllIlIIIIllI) throws CannotCompileException {
        final MethodInfo llllllllllllIllllllllllIlIIIIlIl = new MethodInfo(llllllllllllIllllllllllIlIIIIllI, "setHandler", ProxyFactory.HANDLER_SETTER_TYPE);
        llllllllllllIllllllllllIlIIIIlIl.setAccessFlags(1);
        final Bytecode llllllllllllIllllllllllIlIIIIlII = new Bytecode(llllllllllllIllllllllllIlIIIIllI, 2, 2);
        llllllllllllIllllllllllIlIIIIlII.addAload(0);
        llllllllllllIllllllllllIlIIIIlII.addAload(1);
        llllllllllllIllllllllllIlIIIIlII.addPutfield(llllllllllllIllllllllllIlIIIIIll, "handler", ProxyFactory.HANDLER_TYPE);
        llllllllllllIllllllllllIlIIIIlII.addOpcode(177);
        llllllllllllIllllllllllIlIIIIlIl.setCodeAttribute(llllllllllllIllllllllllIlIIIIlII.toCodeAttribute());
        llllllllllllIllllllllllIlIIIIIlI.addMethod(llllllllllllIllllllllllIlIIIIlIl);
    }
    
    public Class<?> createClass() {
        if (this.signature == null) {
            this.computeSignature(this.methodFilter);
        }
        return this.createClass1(null);
    }
    
    private void getMethods(final Map<String, Method> llllllllllllIlllllllllIlllIIIIll, final Class<?> llllllllllllIlllllllllIllIlllIll, final Set<Class<?>> llllllllllllIlllllllllIllIlllIlI) {
        if (!llllllllllllIlllllllllIllIlllIlI.add(llllllllllllIlllllllllIllIlllIll)) {
            return;
        }
        final Class<?>[] llllllllllllIlllllllllIlllIIIIII = llllllllllllIlllllllllIllIlllIll.getInterfaces();
        for (int llllllllllllIlllllllllIlllIIlIIl = 0; llllllllllllIlllllllllIlllIIlIIl < llllllllllllIlllllllllIlllIIIIII.length; ++llllllllllllIlllllllllIlllIIlIIl) {
            this.getMethods(llllllllllllIlllllllllIlllIIIIll, llllllllllllIlllllllllIlllIIIIII[llllllllllllIlllllllllIlllIIlIIl], llllllllllllIlllllllllIllIlllIlI);
        }
        final Class<?> llllllllllllIlllllllllIllIllllll = llllllllllllIlllllllllIllIlllIll.getSuperclass();
        if (llllllllllllIlllllllllIllIllllll != null) {
            this.getMethods(llllllllllllIlllllllllIlllIIIIll, llllllllllllIlllllllllIllIllllll, llllllllllllIlllllllllIllIlllIlI);
        }
        final Method[] llllllllllllIlllllllllIllIlllllI = SecurityActions.getDeclaredMethods(llllllllllllIlllllllllIllIlllIll);
        for (int llllllllllllIlllllllllIlllIIIlIl = 0; llllllllllllIlllllllllIlllIIIlIl < llllllllllllIlllllllllIllIlllllI.length; ++llllllllllllIlllllllllIlllIIIlIl) {
            if (!Modifier.isPrivate(llllllllllllIlllllllllIllIlllllI[llllllllllllIlllllllllIlllIIIlIl].getModifiers())) {
                final Method llllllllllllIlllllllllIlllIIlIII = llllllllllllIlllllllllIllIlllllI[llllllllllllIlllllllllIlllIIIlIl];
                final String llllllllllllIlllllllllIlllIIIlll = String.valueOf(new StringBuilder().append(llllllllllllIlllllllllIlllIIlIII.getName()).append(':').append(RuntimeSupport.makeDescriptor(llllllllllllIlllllllllIlllIIlIII)));
                if (llllllllllllIlllllllllIlllIIIlll.startsWith("getHandler:()")) {
                    this.hasGetHandler = true;
                }
                final Method llllllllllllIlllllllllIlllIIIllI = llllllllllllIlllllllllIlllIIIIll.put(llllllllllllIlllllllllIlllIIIlll, llllllllllllIlllllllllIlllIIlIII);
                if (null != llllllllllllIlllllllllIlllIIIllI && isBridge(llllllllllllIlllllllllIlllIIlIII) && !Modifier.isPublic(llllllllllllIlllllllllIlllIIIllI.getDeclaringClass().getModifiers()) && !Modifier.isAbstract(llllllllllllIlllllllllIlllIIIllI.getModifiers()) && !isDuplicated(llllllllllllIlllllllllIlllIIIlIl, llllllllllllIlllllllllIllIlllllI)) {
                    llllllllllllIlllllllllIlllIIIIll.put(llllllllllllIlllllllllIlllIIIlll, llllllllllllIlllllllllIlllIIIllI);
                }
                if (null != llllllllllllIlllllllllIlllIIIllI && Modifier.isPublic(llllllllllllIlllllllllIlllIIIllI.getModifiers()) && !Modifier.isPublic(llllllllllllIlllllllllIlllIIlIII.getModifiers())) {
                    llllllllllllIlllllllllIlllIIIIll.put(llllllllllllIlllllllllIlllIIIlll, llllllllllllIlllllllllIlllIIIllI);
                }
            }
        }
    }
    
    Class<?> createClass(final byte[] lllllllllllllIIIIIIIIIIIIIIlllIl) {
        this.installSignature(lllllllllllllIIIIIIIIIIIIIIlllIl);
        return this.createClass1(null);
    }
    
    @Deprecated
    public void setHandler(final MethodHandler llllllllllllIlllllllllllIlIlIlll) {
        if (this.factoryUseCache && llllllllllllIlllllllllllIlIlIlll != null) {
            this.factoryUseCache = false;
            this.thisClass = null;
        }
        this.handler = llllllllllllIlllllllllllIlIlIlll;
        this.setField("default_interceptor", this.handler);
    }
    
    private static void addClassInitializer(final ClassFile llllllllllllIllllllllllIlIllIlII, final ConstPool llllllllllllIllllllllllIlIllIIll, final String llllllllllllIllllllllllIlIllIIlI, final int llllllllllllIllllllllllIlIlllIll, final List<Find2MethodsArgs> llllllllllllIllllllllllIlIllIIII) throws CannotCompileException {
        final FieldInfo llllllllllllIllllllllllIlIlllIIl = new FieldInfo(llllllllllllIllllllllllIlIllIIll, "_methods_", "[Ljava/lang/reflect/Method;");
        llllllllllllIllllllllllIlIlllIIl.setAccessFlags(10);
        llllllllllllIllllllllllIlIllIlII.addField(llllllllllllIllllllllllIlIlllIIl);
        final MethodInfo llllllllllllIllllllllllIlIlllIII = new MethodInfo(llllllllllllIllllllllllIlIllIIll, "<clinit>", "()V");
        llllllllllllIllllllllllIlIlllIII.setAccessFlags(8);
        setThrows(llllllllllllIllllllllllIlIlllIII, llllllllllllIllllllllllIlIllIIll, new Class[] { ClassNotFoundException.class });
        final Bytecode llllllllllllIllllllllllIlIllIlll = new Bytecode(llllllllllllIllllllllllIlIllIIll, 0, 2);
        llllllllllllIllllllllllIlIllIlll.addIconst(llllllllllllIllllllllllIlIlllIll * 2);
        llllllllllllIllllllllllIlIllIlll.addAnewarray("java.lang.reflect.Method");
        final int llllllllllllIllllllllllIlIllIllI = 0;
        llllllllllllIllllllllllIlIllIlll.addAstore(0);
        llllllllllllIllllllllllIlIllIlll.addLdc(llllllllllllIllllllllllIlIllIIlI);
        llllllllllllIllllllllllIlIllIlll.addInvokestatic("java.lang.Class", "forName", "(Ljava/lang/String;)Ljava/lang/Class;");
        final int llllllllllllIllllllllllIlIllIlIl = 1;
        llllllllllllIllllllllllIlIllIlll.addAstore(1);
        for (final Find2MethodsArgs llllllllllllIllllllllllIlIllllll : llllllllllllIllllllllllIlIllIIII) {
            callFind2Methods(llllllllllllIllllllllllIlIllIlll, llllllllllllIllllllllllIlIllllll.methodName, llllllllllllIllllllllllIlIllllll.delegatorName, llllllllllllIllllllllllIlIllllll.origIndex, llllllllllllIllllllllllIlIllllll.descriptor, 1, 0);
        }
        llllllllllllIllllllllllIlIllIlll.addAload(0);
        llllllllllllIllllllllllIlIllIlll.addPutstatic(llllllllllllIllllllllllIlIllIIlI, "_methods_", "[Ljava/lang/reflect/Method;");
        llllllllllllIllllllllllIlIllIlll.addLconst(-1L);
        llllllllllllIllllllllllIlIllIlll.addPutstatic(llllllllllllIllllllllllIlIllIIlI, "serialVersionUID", "J");
        llllllllllllIllllllllllIlIllIlll.addOpcode(177);
        llllllllllllIllllllllllIlIlllIII.setCodeAttribute(llllllllllllIllllllllllIlIllIlll.toCodeAttribute());
        llllllllllllIllllllllllIlIllIlII.addMethod(llllllllllllIllllllllllIlIlllIII);
    }
    
    private static int addLoad(final Bytecode llllllllllllIlllllllllIIlllIIIII, final int llllllllllllIlllllllllIIllIlllll, final Class<?> llllllllllllIlllllllllIIllIllllI) {
        if (llllllllllllIlllllllllIIllIllllI.isPrimitive()) {
            if (llllllllllllIlllllllllIIllIllllI == Long.TYPE) {
                llllllllllllIlllllllllIIlllIIIII.addLload(llllllllllllIlllllllllIIllIlllll);
                return 2;
            }
            if (llllllllllllIlllllllllIIllIllllI == Float.TYPE) {
                llllllllllllIlllllllllIIlllIIIII.addFload(llllllllllllIlllllllllIIllIlllll);
            }
            else {
                if (llllllllllllIlllllllllIIllIllllI == Double.TYPE) {
                    llllllllllllIlllllllllIIlllIIIII.addDload(llllllllllllIlllllllllIIllIlllll);
                    return 2;
                }
                llllllllllllIlllllllllIIlllIIIII.addIload(llllllllllllIlllllllllIIllIlllll);
            }
        }
        else {
            llllllllllllIlllllllllIIlllIIIII.addAload(llllllllllllIlllllllllIIllIlllll);
        }
        return 1;
    }
    
    private Map<String, Method> getMethods(final Class<?> llllllllllllIlllllllllIlllIllllI, final Class<?>[] llllllllllllIlllllllllIlllIllIII) {
        final Map<String, Method> llllllllllllIlllllllllIlllIlllII = new HashMap<String, Method>();
        final Set<Class<?>> llllllllllllIlllllllllIlllIllIll = new HashSet<Class<?>>();
        for (int llllllllllllIlllllllllIllllIIIII = 0; llllllllllllIlllllllllIllllIIIII < llllllllllllIlllllllllIlllIllIII.length; ++llllllllllllIlllllllllIllllIIIII) {
            this.getMethods(llllllllllllIlllllllllIlllIlllII, llllllllllllIlllllllllIlllIllIII[llllllllllllIlllllllllIllllIIIII], llllllllllllIlllllllllIlllIllIll);
        }
        this.getMethods(llllllllllllIlllllllllIlllIlllII, llllllllllllIlllllllllIlllIllllI, llllllllllllIlllllllllIlllIllIll);
        return llllllllllllIlllllllllIlllIlllII;
    }
    
    private static void addGetter(final String llllllllllllIllllllllllIIlllIlII, final ClassFile llllllllllllIllllllllllIIlllIIll, final ConstPool llllllllllllIllllllllllIIlllIIlI) throws CannotCompileException {
        final MethodInfo llllllllllllIllllllllllIIlllIllI = new MethodInfo(llllllllllllIllllllllllIIlllIIlI, "getHandler", ProxyFactory.HANDLER_GETTER_TYPE);
        llllllllllllIllllllllllIIlllIllI.setAccessFlags(1);
        final Bytecode llllllllllllIllllllllllIIlllIlIl = new Bytecode(llllllllllllIllllllllllIIlllIIlI, 1, 1);
        llllllllllllIllllllllllIIlllIlIl.addAload(0);
        llllllllllllIllllllllllIIlllIlIl.addGetfield(llllllllllllIllllllllllIIlllIlII, "handler", ProxyFactory.HANDLER_TYPE);
        llllllllllllIllllllllllIIlllIlIl.addOpcode(176);
        llllllllllllIllllllllllIIlllIllI.setCodeAttribute(llllllllllllIllllllllllIIlllIlIl.toCodeAttribute());
        llllllllllllIllllllllllIIlllIIll.addMethod(llllllllllllIllllllllllIIlllIllI);
    }
    
    private static boolean isVisible(final int llllllllllllIlllllllllIlllllIIIl, final String llllllllllllIlllllllllIlllllIIII, final Member llllllllllllIlllllllllIllllIllll) {
        if ((llllllllllllIlllllllllIlllllIIIl & 0x2) != 0x0) {
            return false;
        }
        if ((llllllllllllIlllllllllIlllllIIIl & 0x5) != 0x0) {
            return true;
        }
        final String llllllllllllIlllllllllIlllllIllI = getPackageName(llllllllllllIlllllllllIlllllIIII);
        final String llllllllllllIlllllllllIlllllIlIl = getPackageName(llllllllllllIlllllllllIllllIllll.getDeclaringClass().getName());
        if (llllllllllllIlllllllllIlllllIllI == null) {
            return llllllllllllIlllllllllIlllllIlIl == null;
        }
        return llllllllllllIlllllllllIlllllIllI.equals(llllllllllllIlllllllllIlllllIlIl);
    }
    
    private static MethodInfo makeForwarder(final String llllllllllllIlllllllllIlIIllIIll, final Method llllllllllllIlllllllllIlIIllIIlI, final String llllllllllllIlllllllllIlIIlIIIIl, final ConstPool llllllllllllIlllllllllIlIIlIIIII, final Class<?> llllllllllllIlllllllllIlIIlIllll, final String llllllllllllIlllllllllIlIIIlllll, final int llllllllllllIlllllllllIlIIIllllI, final List<Find2MethodsArgs> llllllllllllIlllllllllIlIIlIllII) {
        final MethodInfo llllllllllllIlllllllllIlIIlIlIll = new MethodInfo(llllllllllllIlllllllllIlIIlIIIII, llllllllllllIlllllllllIlIIllIIlI.getName(), llllllllllllIlllllllllIlIIlIIIIl);
        llllllllllllIlllllllllIlIIlIlIll.setAccessFlags(0x10 | (llllllllllllIlllllllllIlIIllIIlI.getModifiers() & 0xFFFFFADF));
        setThrows(llllllllllllIlllllllllIlIIlIlIll, llllllllllllIlllllllllIlIIlIIIII, llllllllllllIlllllllllIlIIllIIlI);
        final int llllllllllllIlllllllllIlIIlIlIlI = Descriptor.paramSize(llllllllllllIlllllllllIlIIlIIIIl);
        final Bytecode llllllllllllIlllllllllIlIIlIlIIl = new Bytecode(llllllllllllIlllllllllIlIIlIIIII, 0, llllllllllllIlllllllllIlIIlIlIlI + 2);
        final int llllllllllllIlllllllllIlIIlIlIII = llllllllllllIlllllllllIlIIIllllI * 2;
        final int llllllllllllIlllllllllIlIIlIIlll = llllllllllllIlllllllllIlIIIllllI * 2 + 1;
        final int llllllllllllIlllllllllIlIIlIIllI = llllllllllllIlllllllllIlIIlIlIlI + 1;
        llllllllllllIlllllllllIlIIlIlIIl.addGetstatic(llllllllllllIlllllllllIlIIllIIll, "_methods_", "[Ljava/lang/reflect/Method;");
        llllllllllllIlllllllllIlIIlIlIIl.addAstore(llllllllllllIlllllllllIlIIlIIllI);
        llllllllllllIlllllllllIlIIlIllII.add(new Find2MethodsArgs(llllllllllllIlllllllllIlIIllIIlI.getName(), llllllllllllIlllllllllIlIIIlllll, llllllllllllIlllllllllIlIIlIIIIl, llllllllllllIlllllllllIlIIlIlIII));
        llllllllllllIlllllllllIlIIlIlIIl.addAload(0);
        llllllllllllIlllllllllIlIIlIlIIl.addGetfield(llllllllllllIlllllllllIlIIllIIll, "handler", ProxyFactory.HANDLER_TYPE);
        llllllllllllIlllllllllIlIIlIlIIl.addAload(0);
        llllllllllllIlllllllllIlIIlIlIIl.addAload(llllllllllllIlllllllllIlIIlIIllI);
        llllllllllllIlllllllllIlIIlIlIIl.addIconst(llllllllllllIlllllllllIlIIlIlIII);
        llllllllllllIlllllllllIlIIlIlIIl.addOpcode(50);
        llllllllllllIlllllllllIlIIlIlIIl.addAload(llllllllllllIlllllllllIlIIlIIllI);
        llllllllllllIlllllllllIlIIlIlIIl.addIconst(llllllllllllIlllllllllIlIIlIIlll);
        llllllllllllIlllllllllIlIIlIlIIl.addOpcode(50);
        makeParameterList(llllllllllllIlllllllllIlIIlIlIIl, llllllllllllIlllllllllIlIIllIIlI.getParameterTypes());
        llllllllllllIlllllllllIlIIlIlIIl.addInvokeinterface(MethodHandler.class.getName(), "invoke", "(Ljava/lang/Object;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", 5);
        final Class<?> llllllllllllIlllllllllIlIIlIIlIl = llllllllllllIlllllllllIlIIllIIlI.getReturnType();
        addUnwrapper(llllllllllllIlllllllllIlIIlIlIIl, llllllllllllIlllllllllIlIIlIIlIl);
        addReturn(llllllllllllIlllllllllIlIIlIlIIl, llllllllllllIlllllllllIlIIlIIlIl);
        final CodeAttribute llllllllllllIlllllllllIlIIlIIlII = llllllllllllIlllllllllIlIIlIlIIl.toCodeAttribute();
        llllllllllllIlllllllllIlIIlIlIll.setCodeAttribute(llllllllllllIlllllllllIlIIlIIlII);
        return llllllllllllIlllllllllIlIIlIlIll;
    }
    
    private static String makeProxyName(final String llllllllllllIlllllllllllIlIlIIII) {
        synchronized (ProxyFactory.nameGenerator) {
            return ProxyFactory.nameGenerator.get(llllllllllllIlllllllllllIlIlIIII);
        }
    }
    
    Class<?> createClass(final MethodHandles.Lookup lllllllllllllIIIIIIIIIIIIIIIIlll, final byte[] lllllllllllllIIIIIIIIIIIIIIIIllI) {
        this.installSignature(lllllllllllllIIIIIIIIIIIIIIIIllI);
        return this.createClass1(lllllllllllllIIIIIIIIIIIIIIIIlll);
    }
    
    protected ClassLoader getClassLoader0() {
        ClassLoader llllllllllllIllllllllllllIIIIIll = null;
        if (this.superClass != null && !this.superClass.getName().equals("java.lang.Object")) {
            llllllllllllIllllllllllllIIIIIll = this.superClass.getClassLoader();
        }
        else if (this.interfaces != null && this.interfaces.length > 0) {
            llllllllllllIllllllllllllIIIIIll = this.interfaces[0].getClassLoader();
        }
        if (llllllllllllIllllllllllllIIIIIll == null) {
            llllllllllllIllllllllllllIIIIIll = this.getClass().getClassLoader();
            if (llllllllllllIllllllllllllIIIIIll == null) {
                llllllllllllIllllllllllllIIIIIll = Thread.currentThread().getContextClassLoader();
                if (llllllllllllIllllllllllllIIIIIll == null) {
                    llllllllllllIllllllllllllIIIIIll = ClassLoader.getSystemClassLoader();
                }
            }
        }
        return llllllllllllIllllllllllllIIIIIll;
    }
    
    public Object create(final Class<?>[] llllllllllllIlllllllllllIlIllllI, final Object[] llllllllllllIlllllllllllIllIIIlI) throws InvocationTargetException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InstantiationException {
        final Class<?> llllllllllllIlllllllllllIllIIIIl = this.createClass();
        final Constructor<?> llllllllllllIlllllllllllIllIIIII = llllllllllllIlllllllllllIllIIIIl.getConstructor(llllllllllllIlllllllllllIlIllllI);
        return llllllllllllIlllllllllllIllIIIII.newInstance(llllllllllllIlllllllllllIllIIIlI);
    }
    
    private static String makeUniqueName(final String llllllllllllIllllllllllIIIIIIlIl, final List<Map.Entry<String, Method>> llllllllllllIllllllllllIIIIIIllI) {
        if (makeUniqueName0(llllllllllllIllllllllllIIIIIIlIl, llllllllllllIllllllllllIIIIIIllI.iterator())) {
            return llllllllllllIllllllllllIIIIIIlIl;
        }
        for (int llllllllllllIllllllllllIIIIIlIII = 100; llllllllllllIllllllllllIIIIIlIII < 999; ++llllllllllllIllllllllllIIIIIlIII) {
            final String llllllllllllIllllllllllIIIIIlIIl = String.valueOf(new StringBuilder().append(llllllllllllIllllllllllIIIIIIlIl).append(llllllllllllIllllllllllIIIIIlIII));
            if (makeUniqueName0(llllllllllllIllllllllllIIIIIlIIl, llllllllllllIllllllllllIIIIIIllI.iterator())) {
                return llllllllllllIllllllllllIIIIIlIIl;
            }
        }
        throw new RuntimeException("cannot make a unique method name");
    }
    
    public void setFilter(final MethodFilter lllllllllllllIIIIIIIIIIIIIllIIII) {
        this.methodFilter = lllllllllllllIIIIIIIIIIIIIllIIII;
        this.signature = null;
    }
    
    public String getKey(final Class<?> llllllllllllIllllllllllllllIIIll, final Class<?>[] llllllllllllIllllllllllllllIIIlI, final byte[] llllllllllllIllllllllllllllIIIIl, final boolean llllllllllllIlllllllllllllIllIll) {
        final StringBuffer llllllllllllIlllllllllllllIlllll = new StringBuffer();
        if (llllllllllllIllllllllllllllIIIll != null) {
            llllllllllllIlllllllllllllIlllll.append(llllllllllllIllllllllllllllIIIll.getName());
        }
        llllllllllllIlllllllllllllIlllll.append(":");
        for (int llllllllllllIllllllllllllllIlIIl = 0; llllllllllllIllllllllllllllIlIIl < llllllllllllIllllllllllllllIIIlI.length; ++llllllllllllIllllllllllllllIlIIl) {
            llllllllllllIlllllllllllllIlllll.append(llllllllllllIllllllllllllllIIIlI[llllllllllllIllllllllllllllIlIIl].getName());
            llllllllllllIlllllllllllllIlllll.append(":");
        }
        for (int llllllllllllIllllllllllllllIIlIl = 0; llllllllllllIllllllllllllllIIlIl < llllllllllllIllllllllllllllIIIIl.length; ++llllllllllllIllllllllllllllIIlIl) {
            final byte llllllllllllIllllllllllllllIlIII = llllllllllllIllllllllllllllIIIIl[llllllllllllIllllllllllllllIIlIl];
            final int llllllllllllIllllllllllllllIIlll = llllllllllllIllllllllllllllIlIII & 0xF;
            final int llllllllllllIllllllllllllllIIllI = llllllllllllIllllllllllllllIlIII >> 4 & 0xF;
            llllllllllllIlllllllllllllIlllll.append(ProxyFactory.hexDigits[llllllllllllIllllllllllllllIIlll]);
            llllllllllllIlllllllllllllIlllll.append(ProxyFactory.hexDigits[llllllllllllIllllllllllllllIIllI]);
        }
        if (llllllllllllIlllllllllllllIllIll) {
            llllllllllllIlllllllllllllIlllll.append(":w");
        }
        return llllllllllllIlllllllllllllIlllll.toString();
    }
    
    private ClassFile make() throws CannotCompileException {
        final ClassFile llllllllllllIlllllllllllIlIIIIIl = new ClassFile(false, this.classname, this.superName);
        llllllllllllIlllllllllllIlIIIIIl.setAccessFlags(1);
        setInterfaces(llllllllllllIlllllllllllIlIIIIIl, this.interfaces, (Class<?>)(this.hasGetHandler ? Proxy.class : ProxyObject.class));
        final ConstPool llllllllllllIlllllllllllIlIIIIII = llllllllllllIlllllllllllIlIIIIIl.getConstPool();
        if (!this.factoryUseCache) {
            final FieldInfo llllllllllllIlllllllllllIlIIIlII = new FieldInfo(llllllllllllIlllllllllllIlIIIIII, "default_interceptor", ProxyFactory.HANDLER_TYPE);
            llllllllllllIlllllllllllIlIIIlII.setAccessFlags(9);
            llllllllllllIlllllllllllIlIIIIIl.addField(llllllllllllIlllllllllllIlIIIlII);
        }
        final FieldInfo llllllllllllIlllllllllllIIllllll = new FieldInfo(llllllllllllIlllllllllllIlIIIIII, "handler", ProxyFactory.HANDLER_TYPE);
        llllllllllllIlllllllllllIIllllll.setAccessFlags(2);
        llllllllllllIlllllllllllIlIIIIIl.addField(llllllllllllIlllllllllllIIllllll);
        final FieldInfo llllllllllllIlllllllllllIIlllllI = new FieldInfo(llllllllllllIlllllllllllIlIIIIII, "_filter_signature", "[B");
        llllllllllllIlllllllllllIIlllllI.setAccessFlags(9);
        llllllllllllIlllllllllllIlIIIIIl.addField(llllllllllllIlllllllllllIIlllllI);
        final FieldInfo llllllllllllIlllllllllllIIllllIl = new FieldInfo(llllllllllllIlllllllllllIlIIIIII, "serialVersionUID", "J");
        llllllllllllIlllllllllllIIllllIl.setAccessFlags(25);
        llllllllllllIlllllllllllIlIIIIIl.addField(llllllllllllIlllllllllllIIllllIl);
        if (this.genericSignature != null) {
            final SignatureAttribute llllllllllllIlllllllllllIlIIIIll = new SignatureAttribute(llllllllllllIlllllllllllIlIIIIII, this.genericSignature);
            llllllllllllIlllllllllllIlIIIIIl.addAttribute(llllllllllllIlllllllllllIlIIIIll);
        }
        this.makeConstructors(this.classname, llllllllllllIlllllllllllIlIIIIIl, llllllllllllIlllllllllllIlIIIIII, this.classname);
        final List<Find2MethodsArgs> llllllllllllIlllllllllllIIllllII = new ArrayList<Find2MethodsArgs>();
        final int llllllllllllIlllllllllllIIlllIll = this.overrideMethods(llllllllllllIlllllllllllIlIIIIIl, llllllllllllIlllllllllllIlIIIIII, this.classname, llllllllllllIlllllllllllIIllllII);
        addClassInitializer(llllllllllllIlllllllllllIlIIIIIl, llllllllllllIlllllllllllIlIIIIII, this.classname, llllllllllllIlllllllllllIIlllIll, llllllllllllIlllllllllllIIllllII);
        addSetter(this.classname, llllllllllllIlllllllllllIlIIIIIl, llllllllllllIlllllllllllIlIIIIII);
        if (!this.hasGetHandler) {
            addGetter(this.classname, llllllllllllIlllllllllllIlIIIIIl, llllllllllllIlllllllllllIlIIIIII);
        }
        if (this.factoryWriteReplace) {
            try {
                llllllllllllIlllllllllllIlIIIIIl.addMethod(makeWriteReplace(llllllllllllIlllllllllllIlIIIIII));
            }
            catch (DuplicateMemberException ex) {}
        }
        this.thisClass = null;
        return llllllllllllIlllllllllllIlIIIIIl;
    }
    
    private void checkClassAndSuperName() {
        if (this.interfaces == null) {
            this.interfaces = (Class<?>[])new Class[0];
        }
        if (this.superClass == null) {
            this.superClass = ProxyFactory.OBJECT_TYPE;
            this.superName = this.superClass.getName();
            this.basename = ((this.interfaces.length == 0) ? this.superName : this.interfaces[0].getName());
        }
        else {
            this.superName = this.superClass.getName();
            this.basename = this.superName;
        }
        if (Modifier.isFinal(this.superClass.getModifiers())) {
            throw new RuntimeException(String.valueOf(new StringBuilder().append(this.superName).append(" is final")));
        }
        if (this.basename.startsWith("java.") || this.basename.startsWith("jdk.") || ProxyFactory.onlyPublicMethods) {
            this.basename = String.valueOf(new StringBuilder().append("com.viaversion.viaversion.libs.javassist.util.proxy.").append(this.basename.replace('.', '_')));
        }
    }
    
    private void computeSignature(final MethodFilter llllllllllllIlllllllllllIIIlIllI) {
        this.makeSortedMethodList();
        final int llllllllllllIlllllllllllIIIllIIl = this.signatureMethods.size();
        final int llllllllllllIlllllllllllIIIllIII = llllllllllllIlllllllllllIIIllIIl + 7 >> 3;
        this.signature = new byte[llllllllllllIlllllllllllIIIllIII];
        for (int llllllllllllIlllllllllllIIIlllII = 0; llllllllllllIlllllllllllIIIlllII < llllllllllllIlllllllllllIIIllIIl; ++llllllllllllIlllllllllllIIIlllII) {
            final Method llllllllllllIlllllllllllIIIllllI = this.signatureMethods.get(llllllllllllIlllllllllllIIIlllII).getValue();
            final int llllllllllllIlllllllllllIIIlllIl = llllllllllllIlllllllllllIIIllllI.getModifiers();
            if (!Modifier.isFinal(llllllllllllIlllllllllllIIIlllIl) && !Modifier.isStatic(llllllllllllIlllllllllllIIIlllIl) && isVisible(llllllllllllIlllllllllllIIIlllIl, this.basename, llllllllllllIlllllllllllIIIllllI) && (llllllllllllIlllllllllllIIIlIllI == null || llllllllllllIlllllllllllIIIlIllI.isHandled(llllllllllllIlllllllllllIIIllllI))) {
                this.setBit(this.signature, llllllllllllIlllllllllllIIIlllII);
            }
        }
    }
    
    private void override(final String llllllllllllIllllllllllIIlIIIIll, final Method llllllllllllIllllllllllIIIllIllI, final String llllllllllllIllllllllllIIlIIIIIl, final int llllllllllllIllllllllllIIlIIIIII, final String llllllllllllIllllllllllIIIllIIll, final ClassFile llllllllllllIllllllllllIIIllIIlI, final ConstPool llllllllllllIllllllllllIIIllllIl, final List<Find2MethodsArgs> llllllllllllIllllllllllIIIllIIII) throws CannotCompileException {
        final Class<?> llllllllllllIllllllllllIIIlllIll = llllllllllllIllllllllllIIIllIllI.getDeclaringClass();
        String llllllllllllIllllllllllIIIlllIlI = String.valueOf(new StringBuilder().append(llllllllllllIllllllllllIIlIIIIIl).append(llllllllllllIllllllllllIIlIIIIII).append(llllllllllllIllllllllllIIIllIllI.getName()));
        if (Modifier.isAbstract(llllllllllllIllllllllllIIIllIllI.getModifiers())) {
            llllllllllllIllllllllllIIIlllIlI = null;
        }
        else {
            final MethodInfo llllllllllllIllllllllllIIlIIIlIl = this.makeDelegator(llllllllllllIllllllllllIIIllIllI, llllllllllllIllllllllllIIIllIIll, llllllllllllIllllllllllIIIllllIl, llllllllllllIllllllllllIIIlllIll, llllllllllllIllllllllllIIIlllIlI);
            llllllllllllIllllllllllIIlIIIlIl.setAccessFlags(llllllllllllIllllllllllIIlIIIlIl.getAccessFlags() & 0xFFFFFFBF);
            llllllllllllIllllllllllIIIllIIlI.addMethod(llllllllllllIllllllllllIIlIIIlIl);
        }
        final MethodInfo llllllllllllIllllllllllIIIlllIIl = makeForwarder(llllllllllllIllllllllllIIlIIIIll, llllllllllllIllllllllllIIIllIllI, llllllllllllIllllllllllIIIllIIll, llllllllllllIllllllllllIIIllllIl, llllllllllllIllllllllllIIIlllIll, llllllllllllIllllllllllIIIlllIlI, llllllllllllIllllllllllIIlIIIIII, llllllllllllIllllllllllIIIllIIII);
        llllllllllllIllllllllllIIIllIIlI.addMethod(llllllllllllIllllllllllIIIlllIIl);
    }
    
    public Class<?> createClass(final MethodHandles.Lookup lllllllllllllIIIIIIIIIIIIIIlIlIl) {
        if (this.signature == null) {
            this.computeSignature(this.methodFilter);
        }
        return this.createClass1(lllllllllllllIIIIIIIIIIIIIIlIlIl);
    }
    
    public void setInterfaces(final Class<?>[] lllllllllllllIIIIIIIIIIIIIlllIll) {
        this.interfaces = lllllllllllllIIIIIIIIIIIIIlllIll;
        this.signature = null;
    }
    
    public Class<?>[] getInterfaces() {
        return this.interfaces;
    }
    
    private static int makeWrapper(final Bytecode llllllllllllIlllllllllIIlIlllIll, final Class<?> llllllllllllIlllllllllIIlIllllll, final int llllllllllllIlllllllllIIlIlllllI) {
        final int llllllllllllIlllllllllIIlIllllIl = FactoryHelper.typeIndex(llllllllllllIlllllllllIIlIllllll);
        final String llllllllllllIlllllllllIIlIllllII = FactoryHelper.wrapperTypes[llllllllllllIlllllllllIIlIllllIl];
        llllllllllllIlllllllllIIlIlllIll.addNew(llllllllllllIlllllllllIIlIllllII);
        llllllllllllIlllllllllIIlIlllIll.addOpcode(89);
        addLoad(llllllllllllIlllllllllIIlIlllIll, llllllllllllIlllllllllIIlIlllllI, llllllllllllIlllllllllIIlIllllll);
        llllllllllllIlllllllllIIlIlllIll.addInvokespecial(llllllllllllIlllllllllIIlIllllII, "<init>", FactoryHelper.wrapperDesc[llllllllllllIlllllllllIIlIllllIl]);
        return llllllllllllIlllllllllIIlIlllllI + FactoryHelper.dataSize[llllllllllllIlllllllllIIlIllllIl];
    }
    
    private static MethodInfo makeConstructor(final String llllllllllllIlllllllllIllIIIIlll, final Constructor<?> llllllllllllIlllllllllIlIllllIlI, final ConstPool llllllllllllIlllllllllIllIIIIlIl, final Class<?> llllllllllllIlllllllllIllIIIIlII, final boolean llllllllllllIlllllllllIllIIIIIll) {
        final String llllllllllllIlllllllllIllIIIIIlI = RuntimeSupport.makeDescriptor(llllllllllllIlllllllllIlIllllIlI.getParameterTypes(), Void.TYPE);
        final MethodInfo llllllllllllIlllllllllIllIIIIIIl = new MethodInfo(llllllllllllIlllllllllIllIIIIlIl, "<init>", llllllllllllIlllllllllIllIIIIIlI);
        llllllllllllIlllllllllIllIIIIIIl.setAccessFlags(1);
        setThrows(llllllllllllIlllllllllIllIIIIIIl, llllllllllllIlllllllllIllIIIIlIl, llllllllllllIlllllllllIlIllllIlI.getExceptionTypes());
        final Bytecode llllllllllllIlllllllllIllIIIIIII = new Bytecode(llllllllllllIlllllllllIllIIIIlIl, 0, 0);
        if (llllllllllllIlllllllllIllIIIIIll) {
            llllllllllllIlllllllllIllIIIIIII.addAload(0);
            llllllllllllIlllllllllIllIIIIIII.addGetstatic(llllllllllllIlllllllllIllIIIIlll, "default_interceptor", ProxyFactory.HANDLER_TYPE);
            llllllllllllIlllllllllIllIIIIIII.addPutfield(llllllllllllIlllllllllIllIIIIlll, "handler", ProxyFactory.HANDLER_TYPE);
            llllllllllllIlllllllllIllIIIIIII.addGetstatic(llllllllllllIlllllllllIllIIIIlll, "default_interceptor", ProxyFactory.HANDLER_TYPE);
            llllllllllllIlllllllllIllIIIIIII.addOpcode(199);
            llllllllllllIlllllllllIllIIIIIII.addIndex(10);
        }
        llllllllllllIlllllllllIllIIIIIII.addAload(0);
        llllllllllllIlllllllllIllIIIIIII.addGetstatic("com.viaversion.viaversion.libs.javassist.util.proxy.RuntimeSupport", "default_interceptor", ProxyFactory.HANDLER_TYPE);
        llllllllllllIlllllllllIllIIIIIII.addPutfield(llllllllllllIlllllllllIllIIIIlll, "handler", ProxyFactory.HANDLER_TYPE);
        final int llllllllllllIlllllllllIlIlllllll = llllllllllllIlllllllllIllIIIIIII.currentPc();
        llllllllllllIlllllllllIllIIIIIII.addAload(0);
        final int llllllllllllIlllllllllIlIllllllI = addLoadParameters(llllllllllllIlllllllllIllIIIIIII, llllllllllllIlllllllllIlIllllIlI.getParameterTypes(), 1);
        llllllllllllIlllllllllIllIIIIIII.addInvokespecial(llllllllllllIlllllllllIllIIIIlII.getName(), "<init>", llllllllllllIlllllllllIllIIIIIlI);
        llllllllllllIlllllllllIllIIIIIII.addOpcode(177);
        llllllllllllIlllllllllIllIIIIIII.setMaxLocals(llllllllllllIlllllllllIlIllllllI + 1);
        final CodeAttribute llllllllllllIlllllllllIlIlllllIl = llllllllllllIlllllllllIllIIIIIII.toCodeAttribute();
        llllllllllllIlllllllllIllIIIIIIl.setCodeAttribute(llllllllllllIlllllllllIlIlllllIl);
        final StackMapTable.Writer llllllllllllIlllllllllIlIlllllII = new StackMapTable.Writer(32);
        llllllllllllIlllllllllIlIlllllII.sameFrame(llllllllllllIlllllllllIlIlllllll);
        llllllllllllIlllllllllIlIlllllIl.setAttribute(llllllllllllIlllllllllIlIlllllII.toStackMapTable(llllllllllllIlllllllllIllIIIIlIl));
        return llllllllllllIlllllllllIllIIIIIIl;
    }
    
    private void allocateClassName() {
        this.classname = makeProxyName(this.basename);
    }
    
    public void setGenericSignature(final String lllllllllllllIIIIIIIIIIIIIlIllII) {
        this.genericSignature = lllllllllllllIIIIIIIIIIIIIlIllII;
    }
    
    public Class<?> createClass(final MethodFilter lllllllllllllIIIIIIIIIIIIIlIIIll) {
        this.computeSignature(lllllllllllllIIIIIIIIIIIIIlIIIll);
        return this.createClass1(null);
    }
    
    public Object create(final Class<?>[] llllllllllllIlllllllllllIllIllIl, final Object[] llllllllllllIlllllllllllIllIllII, final MethodHandler llllllllllllIlllllllllllIlllIIII) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InstantiationException {
        final Object llllllllllllIlllllllllllIllIllll = this.create(llllllllllllIlllllllllllIllIllIl, llllllllllllIlllllllllllIllIllII);
        ((Proxy)llllllllllllIlllllllllllIllIllll).setHandler(llllllllllllIlllllllllllIlllIIII);
        return llllllllllllIlllllllllllIllIllll;
    }
    
    public static MethodHandler getHandler(final Proxy llllllllllllIllllllllllllIIIllII) {
        try {
            final Field llllllllllllIllllllllllllIIlIIII = llllllllllllIllllllllllllIIIllII.getClass().getDeclaredField("handler");
            llllllllllllIllllllllllllIIlIIII.setAccessible(true);
            final Object llllllllllllIllllllllllllIIIllll = llllllllllllIllllllllllllIIlIIII.get(llllllllllllIllllllllllllIIIllII);
            llllllllllllIllllllllllllIIlIIII.setAccessible(false);
            return (MethodHandler)llllllllllllIllllllllllllIIIllll;
        }
        catch (Exception llllllllllllIllllllllllllIIIlllI) {
            throw new RuntimeException(llllllllllllIllllllllllllIIIlllI);
        }
    }
    
    private void setField(final String llllllllllllIllllllllllllIlIIllI, final Object llllllllllllIllllllllllllIlIIlIl) {
        if (this.thisClass != null && llllllllllllIllllllllllllIlIIlIl != null) {
            try {
                final Field llllllllllllIllllllllllllIlIllII = this.thisClass.getField(llllllllllllIllllllllllllIlIIllI);
                SecurityActions.setAccessible(llllllllllllIllllllllllllIlIllII, true);
                llllllllllllIllllllllllllIlIllII.set(null, llllllllllllIllllllllllllIlIIlIl);
                SecurityActions.setAccessible(llllllllllllIllllllllllllIlIllII, false);
            }
            catch (Exception llllllllllllIllllllllllllIlIlIll) {
                throw new RuntimeException(llllllllllllIllllllllllllIlIlIll);
            }
        }
    }
    
    public Class<?> getSuperclass() {
        return this.superClass;
    }
    
    private Class<?> createClass1(final MethodHandles.Lookup llllllllllllIllllllllllllllllIlI) {
        Class<?> llllllllllllIllllllllllllllllIIl = this.thisClass;
        if (llllllllllllIllllllllllllllllIIl == null) {
            final ClassLoader llllllllllllIlllllllllllllllllII = this.getClassLoader();
            synchronized (ProxyFactory.proxyCache) {
                if (this.factoryUseCache) {
                    this.createClass2(llllllllllllIlllllllllllllllllII, llllllllllllIllllllllllllllllIlI);
                }
                else {
                    this.createClass3(llllllllllllIlllllllllllllllllII, llllllllllllIllllllllllllllllIlI);
                }
                llllllllllllIllllllllllllllllIIl = this.thisClass;
                this.thisClass = null;
            }
        }
        return llllllllllllIllllllllllllllllIIl;
    }
    
    public Class<?> createClass(final MethodHandles.Lookup lllllllllllllIIIIIIIIIIIIIIIllIl, final MethodFilter lllllllllllllIIIIIIIIIIIIIIIllII) {
        this.computeSignature(lllllllllllllIIIIIIIIIIIIIIIllII);
        return this.createClass1(lllllllllllllIIIIIIIIIIIIIIIllIl);
    }
    
    private Class<?> invokespecialTarget(final Class<?> llllllllllllIlllllllllIlIlIIIlll) {
        if (llllllllllllIlllllllllIlIlIIIlll.isInterface()) {
            final char llllllllllllIlllllllllIlIlIIIllI = (Object)this.interfaces;
            final long llllllllllllIlllllllllIlIlIIIlIl = llllllllllllIlllllllllIlIlIIIllI.length;
            for (final Class<?> llllllllllllIlllllllllIlIlIIlIll : llllllllllllIlllllllllIlIlIIIllI) {
                if (llllllllllllIlllllllllIlIlIIIlll.isAssignableFrom(llllllllllllIlllllllllIlIlIIlIll)) {
                    return llllllllllllIlllllllllIlIlIIlIll;
                }
            }
        }
        return this.superClass;
    }
    
    private boolean testBit(final byte[] llllllllllllIllllllllllIllllIlll, final int llllllllllllIllllllllllIllllllII) {
        final int llllllllllllIllllllllllIlllllIll = llllllllllllIllllllllllIllllllII >> 3;
        if (llllllllllllIllllllllllIlllllIll > llllllllllllIllllllllllIllllIlll.length) {
            return false;
        }
        final int llllllllllllIllllllllllIlllllIlI = llllllllllllIllllllllllIllllllII & 0x7;
        final int llllllllllllIllllllllllIlllllIIl = 1 << llllllllllllIllllllllllIlllllIlI;
        final int llllllllllllIllllllllllIlllllIII = llllllllllllIllllllllllIllllIlll[llllllllllllIllllllllllIlllllIll];
        return (llllllllllllIllllllllllIlllllIII & llllllllllllIllllllllllIlllllIIl) != 0x0;
    }
    
    static class Find2MethodsArgs
    {
        /* synthetic */ String descriptor;
        /* synthetic */ int origIndex;
        /* synthetic */ String methodName;
        /* synthetic */ String delegatorName;
        
        Find2MethodsArgs(final String llllllllllllllllllIlIIllIIlIllII, final String llllllllllllllllllIlIIllIIlIlIll, final String llllllllllllllllllIlIIllIIlIIlIl, final int llllllllllllllllllIlIIllIIlIlIIl) {
            this.methodName = llllllllllllllllllIlIIllIIlIllII;
            this.delegatorName = llllllllllllllllllIlIIllIIlIlIll;
            this.descriptor = llllllllllllllllllIlIIllIIlIIlIl;
            this.origIndex = llllllllllllllllllIlIIllIIlIlIIl;
        }
    }
    
    public interface ClassLoaderProvider
    {
        ClassLoader get(final ProxyFactory p0);
    }
    
    public interface UniqueName
    {
        String get(final String p0);
    }
    
    static class ProxyDetails
    {
        /* synthetic */ Reference<Class<?>> proxyClass;
        /* synthetic */ byte[] signature;
        /* synthetic */ boolean isUseWriteReplace;
        
        ProxyDetails(final byte[] llllllllllllllllllllllIIllIIlIlI, final Class<?> llllllllllllllllllllllIIllIIllIl, final boolean llllllllllllllllllllllIIllIIlIII) {
            this.signature = llllllllllllllllllllllIIllIIlIlI;
            this.proxyClass = new WeakReference<Class<?>>(llllllllllllllllllllllIIllIIllIl);
            this.isUseWriteReplace = llllllllllllllllllllllIIllIIlIII;
        }
    }
}
