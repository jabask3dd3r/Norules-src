package com.viaversion.viaversion.libs.javassist.util.proxy;

import com.viaversion.viaversion.libs.javassist.bytecode.*;
import java.security.*;
import com.viaversion.viaversion.libs.javassist.*;
import java.io.*;
import java.lang.invoke.*;

public class FactoryHelper
{
    public static final /* synthetic */ Class<?>[] primitiveTypes;
    
    private static byte[] toBytecode(final ClassFile lllllllllllllllIIIIllIIllIlIIIII) throws IOException {
        final ByteArrayOutputStream lllllllllllllllIIIIllIIllIlIIIlI = new ByteArrayOutputStream();
        final DataOutputStream lllllllllllllllIIIIllIIllIlIIIIl = new DataOutputStream(lllllllllllllllIIIIllIIllIlIIIlI);
        try {
            lllllllllllllllIIIIllIIllIlIIIII.write(lllllllllllllllIIIIllIIllIlIIIIl);
        }
        finally {
            lllllllllllllllIIIIllIIllIlIIIIl.close();
        }
        return lllllllllllllllIIIIllIIllIlIIIlI.toByteArray();
    }
    
    @Deprecated
    public static Class<?> toClass(final ClassFile lllllllllllllllIIIIllIIlllIIllII, final ClassLoader lllllllllllllllIIIIllIIlllIIlIll) throws CannotCompileException {
        return toClass(lllllllllllllllIIIIllIIlllIIllII, null, lllllllllllllllIIIIllIIlllIIlIll, null);
    }
    
    public static Class<?> toClass(final ClassFile lllllllllllllllIIIIllIIllIllIllI, final Class<?> lllllllllllllllIIIIllIIllIllIlIl, final ClassLoader lllllllllllllllIIIIllIIllIlllIII, final ProtectionDomain lllllllllllllllIIIIllIIllIllIIll) throws CannotCompileException {
        try {
            final byte[] lllllllllllllllIIIIllIIllIllllII = toBytecode(lllllllllllllllIIIIllIIllIllIllI);
            if (ProxyFactory.onlyPublicMethods) {
                return DefineClassHelper.toPublicClass(lllllllllllllllIIIIllIIllIllIllI.getName(), lllllllllllllllIIIIllIIllIllllII);
            }
            return DefineClassHelper.toClass(lllllllllllllllIIIIllIIllIllIllI.getName(), lllllllllllllllIIIIllIIllIllIlIl, lllllllllllllllIIIIllIIllIlllIII, lllllllllllllllIIIIllIIllIllIIll, lllllllllllllllIIIIllIIllIllllII);
        }
        catch (IOException lllllllllllllllIIIIllIIllIlllIll) {
            throw new CannotCompileException(lllllllllllllllIIIIllIIllIlllIll);
        }
    }
    
    private static void writeFile0(final ClassFile lllllllllllllllIIIIllIIllIIIlIIl, final String lllllllllllllllIIIIllIIllIIIIIlI) throws IOException, CannotCompileException {
        final String lllllllllllllllIIIIllIIllIIIIlll = lllllllllllllllIIIIllIIllIIIlIIl.getName();
        final String lllllllllllllllIIIIllIIllIIIIllI = String.valueOf(new StringBuilder().append(lllllllllllllllIIIIllIIllIIIIIlI).append(File.separatorChar).append(lllllllllllllllIIIIllIIllIIIIlll.replace('.', File.separatorChar)).append(".class"));
        final int lllllllllllllllIIIIllIIllIIIIlIl = lllllllllllllllIIIIllIIllIIIIllI.lastIndexOf(File.separatorChar);
        if (lllllllllllllllIIIIllIIllIIIIlIl > 0) {
            final String lllllllllllllllIIIIllIIllIIIlIll = lllllllllllllllIIIIllIIllIIIIllI.substring(0, lllllllllllllllIIIIllIIllIIIIlIl);
            if (!lllllllllllllllIIIIllIIllIIIlIll.equals(".")) {
                new File(lllllllllllllllIIIIllIIllIIIlIll).mkdirs();
            }
        }
        final DataOutputStream lllllllllllllllIIIIllIIllIIIIlII = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(lllllllllllllllIIIIllIIllIIIIllI)));
        try {
            lllllllllllllllIIIIllIIllIIIlIIl.write(lllllllllllllllIIIIllIIllIIIIlII);
        }
        catch (IOException lllllllllllllllIIIIllIIllIIIlIlI) {
            throw lllllllllllllllIIIIllIIllIIIlIlI;
        }
        finally {
            lllllllllllllllIIIIllIIllIIIIlII.close();
        }
    }
    
    public static void writeFile(final ClassFile lllllllllllllllIIIIllIIllIIllIII, final String lllllllllllllllIIIIllIIllIIlIlll) throws CannotCompileException {
        try {
            writeFile0(lllllllllllllllIIIIllIIllIIllIII, lllllllllllllllIIIIllIIllIIlIlll);
        }
        catch (IOException lllllllllllllllIIIIllIIllIIllIIl) {
            throw new CannotCompileException(lllllllllllllllIIIIllIIllIIllIIl);
        }
    }
    
    @Deprecated
    public static Class<?> toClass(final ClassFile lllllllllllllllIIIIllIIlllIIIlII, final ClassLoader lllllllllllllllIIIIllIIlllIIIllI, final ProtectionDomain lllllllllllllllIIIIllIIlllIIIIlI) throws CannotCompileException {
        return toClass(lllllllllllllllIIIIllIIlllIIIlII, null, lllllllllllllllIIIIllIIlllIIIllI, lllllllllllllllIIIIllIIlllIIIIlI);
    }
    
    static {
        primitiveTypes = new Class[] { Boolean.TYPE, Byte.TYPE, Character.TYPE, Short.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE, Void.TYPE };
        wrapperTypes = new String[] { "java.lang.Boolean", "java.lang.Byte", "java.lang.Character", "java.lang.Short", "java.lang.Integer", "java.lang.Long", "java.lang.Float", "java.lang.Double", "java.lang.Void" };
        wrapperDesc = new String[] { "(Z)V", "(B)V", "(C)V", "(S)V", "(I)V", "(J)V", "(F)V", "(D)V" };
        unwarpMethods = new String[] { "booleanValue", "byteValue", "charValue", "shortValue", "intValue", "longValue", "floatValue", "doubleValue" };
        unwrapDesc = new String[] { "()Z", "()B", "()C", "()S", "()I", "()J", "()F", "()D" };
        dataSize = new int[] { 1, 1, 1, 1, 1, 2, 1, 2 };
    }
    
    public static final int typeIndex(final Class<?> lllllllllllllllIIIIllIIlllIlIIlI) {
        for (int lllllllllllllllIIIIllIIlllIlIlII = 0; lllllllllllllllIIIIllIIlllIlIlII < FactoryHelper.primitiveTypes.length; ++lllllllllllllllIIIIllIIlllIlIlII) {
            if (FactoryHelper.primitiveTypes[lllllllllllllllIIIIllIIlllIlIlII] == lllllllllllllllIIIIllIIlllIlIIlI) {
                return lllllllllllllllIIIIllIIlllIlIlII;
            }
        }
        throw new RuntimeException(String.valueOf(new StringBuilder().append("bad type:").append(lllllllllllllllIIIIllIIlllIlIIlI.getName())));
    }
    
    public static Class<?> toClass(final ClassFile lllllllllllllllIIIIllIIllIlIlIlI, final MethodHandles.Lookup lllllllllllllllIIIIllIIllIlIlIIl) throws CannotCompileException {
        try {
            final byte[] lllllllllllllllIIIIllIIllIlIlllI = toBytecode(lllllllllllllllIIIIllIIllIlIlIlI);
            return DefineClassHelper.toClass(lllllllllllllllIIIIllIIllIlIlIIl, lllllllllllllllIIIIllIIllIlIlllI);
        }
        catch (IOException lllllllllllllllIIIIllIIllIlIllIl) {
            throw new CannotCompileException(lllllllllllllllIIIIllIIllIlIllIl);
        }
    }
}
