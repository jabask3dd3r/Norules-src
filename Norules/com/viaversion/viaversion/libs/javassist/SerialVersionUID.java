package com.viaversion.viaversion.libs.javassist;

import java.util.*;
import java.io.*;
import java.security.*;
import com.viaversion.viaversion.libs.javassist.bytecode.*;

public class SerialVersionUID
{
    private static boolean isSerializable(final CtClass llllllllllllllllIlllllllllIIIlII) throws NotFoundException {
        final ClassPool llllllllllllllllIlllllllllIIIIll = llllllllllllllllIlllllllllIIIlII.getClassPool();
        return llllllllllllllllIlllllllllIIIlII.subtypeOf(llllllllllllllllIlllllllllIIIIll.get("java.io.Serializable"));
    }
    
    public static void setSerialVersionUID(final CtClass llllllllllllllllIlllllllllIIlIlI) throws CannotCompileException, NotFoundException {
        try {
            llllllllllllllllIlllllllllIIlIlI.getDeclaredField("serialVersionUID");
        }
        catch (NotFoundException ex) {
            if (!isSerializable(llllllllllllllllIlllllllllIIlIlI)) {
                return;
            }
            final CtField llllllllllllllllIlllllllllIIlIIl = new CtField(CtClass.longType, "serialVersionUID", llllllllllllllllIlllllllllIIlIlI);
            llllllllllllllllIlllllllllIIlIIl.setModifiers(26);
            llllllllllllllllIlllllllllIIlIlI.addField(llllllllllllllllIlllllllllIIlIIl, String.valueOf(new StringBuilder().append(calculateDefault(llllllllllllllllIlllllllllIIlIlI)).append("L")));
        }
    }
    
    private static String javaName(final CtClass llllllllllllllllIllllllllIIIIlll) {
        return Descriptor.toJavaName(Descriptor.toJvmName(llllllllllllllllIllllllllIIIIlll));
    }
    
    public static long calculateDefault(final CtClass llllllllllllllllIllllllllIIllIII) throws CannotCompileException {
        try {
            final ByteArrayOutputStream llllllllllllllllIllllllllIlIIllI = new ByteArrayOutputStream();
            final DataOutputStream llllllllllllllllIllllllllIlIIlIl = new DataOutputStream(llllllllllllllllIllllllllIlIIllI);
            final ClassFile llllllllllllllllIllllllllIlIIlII = llllllllllllllllIllllllllIIllIII.getClassFile();
            final String llllllllllllllllIllllllllIlIIIll = javaName(llllllllllllllllIllllllllIIllIII);
            llllllllllllllllIllllllllIlIIlIl.writeUTF(llllllllllllllllIllllllllIlIIIll);
            final CtMethod[] llllllllllllllllIllllllllIlIIIlI = llllllllllllllllIllllllllIIllIII.getDeclaredMethods();
            int llllllllllllllllIllllllllIlIIIIl = llllllllllllllllIllllllllIIllIII.getModifiers();
            if ((llllllllllllllllIllllllllIlIIIIl & 0x200) != 0x0) {
                if (llllllllllllllllIllllllllIlIIIlI.length > 0) {
                    llllllllllllllllIllllllllIlIIIIl |= 0x400;
                }
                else {
                    llllllllllllllllIllllllllIlIIIIl &= 0xFFFFFBFF;
                }
            }
            llllllllllllllllIllllllllIlIIlIl.writeInt(llllllllllllllllIllllllllIlIIIIl);
            final String[] llllllllllllllllIllllllllIlIIIII = llllllllllllllllIllllllllIlIIlII.getInterfaces();
            for (int llllllllllllllllIllllllllIllIIlI = 0; llllllllllllllllIllllllllIllIIlI < llllllllllllllllIllllllllIlIIIII.length; ++llllllllllllllllIllllllllIllIIlI) {
                llllllllllllllllIllllllllIlIIIII[llllllllllllllllIllllllllIllIIlI] = javaName(llllllllllllllllIllllllllIlIIIII[llllllllllllllllIllllllllIllIIlI]);
            }
            Arrays.sort(llllllllllllllllIllllllllIlIIIII);
            for (int llllllllllllllllIllllllllIllIIIl = 0; llllllllllllllllIllllllllIllIIIl < llllllllllllllllIllllllllIlIIIII.length; ++llllllllllllllllIllllllllIllIIIl) {
                llllllllllllllllIllllllllIlIIlIl.writeUTF(llllllllllllllllIllllllllIlIIIII[llllllllllllllllIllllllllIllIIIl]);
            }
            final CtField[] llllllllllllllllIllllllllIIlllll = llllllllllllllllIllllllllIIllIII.getDeclaredFields();
            Arrays.sort(llllllllllllllllIllllllllIIlllll, new Comparator<CtField>() {
                @Override
                public int compare(final CtField lllllllllllllIIIIIlIlIIlIIIlIIII, final CtField lllllllllllllIIIIIlIlIIlIIIIllIl) {
                    return lllllllllllllIIIIIlIlIIlIIIlIIII.getName().compareTo(lllllllllllllIIIIIlIlIIlIIIIllIl.getName());
                }
            });
            for (int llllllllllllllllIllllllllIlIlllI = 0; llllllllllllllllIllllllllIlIlllI < llllllllllllllllIllllllllIIlllll.length; ++llllllllllllllllIllllllllIlIlllI) {
                final CtField llllllllllllllllIllllllllIllIIII = llllllllllllllllIllllllllIIlllll[llllllllllllllllIllllllllIlIlllI];
                final int llllllllllllllllIllllllllIlIllll = llllllllllllllllIllllllllIllIIII.getModifiers();
                if ((llllllllllllllllIllllllllIlIllll & 0x2) == 0x0 || (llllllllllllllllIllllllllIlIllll & 0x88) == 0x0) {
                    llllllllllllllllIllllllllIlIIlIl.writeUTF(llllllllllllllllIllllllllIllIIII.getName());
                    llllllllllllllllIllllllllIlIIlIl.writeInt(llllllllllllllllIllllllllIlIllll);
                    llllllllllllllllIllllllllIlIIlIl.writeUTF(llllllllllllllllIllllllllIllIIII.getFieldInfo2().getDescriptor());
                }
            }
            if (llllllllllllllllIllllllllIlIIlII.getStaticInitializer() != null) {
                llllllllllllllllIllllllllIlIIlIl.writeUTF("<clinit>");
                llllllllllllllllIllllllllIlIIlIl.writeInt(8);
                llllllllllllllllIllllllllIlIIlIl.writeUTF("()V");
            }
            final CtConstructor[] llllllllllllllllIllllllllIIllllI = llllllllllllllllIllllllllIIllIII.getDeclaredConstructors();
            Arrays.sort(llllllllllllllllIllllllllIIllllI, new Comparator<CtConstructor>() {
                @Override
                public int compare(final CtConstructor lllllllllllllllIIllllllIlIIlIlll, final CtConstructor lllllllllllllllIIllllllIlIIlIllI) {
                    return lllllllllllllllIIllllllIlIIlIlll.getMethodInfo2().getDescriptor().compareTo(lllllllllllllllIIllllllIlIIlIllI.getMethodInfo2().getDescriptor());
                }
            });
            for (int llllllllllllllllIllllllllIlIlIll = 0; llllllllllllllllIllllllllIlIlIll < llllllllllllllllIllllllllIIllllI.length; ++llllllllllllllllIllllllllIlIlIll) {
                final CtConstructor llllllllllllllllIllllllllIlIllIl = llllllllllllllllIllllllllIIllllI[llllllllllllllllIllllllllIlIlIll];
                final int llllllllllllllllIllllllllIlIllII = llllllllllllllllIllllllllIlIllIl.getModifiers();
                if ((llllllllllllllllIllllllllIlIllII & 0x2) == 0x0) {
                    llllllllllllllllIllllllllIlIIlIl.writeUTF("<init>");
                    llllllllllllllllIllllllllIlIIlIl.writeInt(llllllllllllllllIllllllllIlIllII);
                    llllllllllllllllIllllllllIlIIlIl.writeUTF(llllllllllllllllIllllllllIlIllIl.getMethodInfo2().getDescriptor().replace('/', '.'));
                }
            }
            Arrays.sort(llllllllllllllllIllllllllIlIIIlI, new Comparator<CtMethod>() {
                @Override
                public int compare(final CtMethod llllIIlllIIlIl, final CtMethod llllIIlllIIIIl) {
                    int llllIIlllIIIll = llllIIlllIIlIl.getName().compareTo(llllIIlllIIIIl.getName());
                    if (llllIIlllIIIll == 0) {
                        llllIIlllIIIll = llllIIlllIIlIl.getMethodInfo2().getDescriptor().compareTo(llllIIlllIIIIl.getMethodInfo2().getDescriptor());
                    }
                    return llllIIlllIIIll;
                }
            });
            for (int llllllllllllllllIllllllllIlIlIII = 0; llllllllllllllllIllllllllIlIlIII < llllllllllllllllIllllllllIlIIIlI.length; ++llllllllllllllllIllllllllIlIlIII) {
                final CtMethod llllllllllllllllIllllllllIlIlIlI = llllllllllllllllIllllllllIlIIIlI[llllllllllllllllIllllllllIlIlIII];
                final int llllllllllllllllIllllllllIlIlIIl = llllllllllllllllIllllllllIlIlIlI.getModifiers() & 0xD3F;
                if ((llllllllllllllllIllllllllIlIlIIl & 0x2) == 0x0) {
                    llllllllllllllllIllllllllIlIIlIl.writeUTF(llllllllllllllllIllllllllIlIlIlI.getName());
                    llllllllllllllllIllllllllIlIIlIl.writeInt(llllllllllllllllIllllllllIlIlIIl);
                    llllllllllllllllIllllllllIlIIlIl.writeUTF(llllllllllllllllIllllllllIlIlIlI.getMethodInfo2().getDescriptor().replace('/', '.'));
                }
            }
            llllllllllllllllIllllllllIlIIlIl.flush();
            final MessageDigest llllllllllllllllIllllllllIIlllIl = MessageDigest.getInstance("SHA");
            final byte[] llllllllllllllllIllllllllIIlllII = llllllllllllllllIllllllllIIlllIl.digest(llllllllllllllllIllllllllIlIIllI.toByteArray());
            long llllllllllllllllIllllllllIIllIll = 0L;
            for (int llllllllllllllllIllllllllIlIIlll = Math.min(llllllllllllllllIllllllllIIlllII.length, 8) - 1; llllllllllllllllIllllllllIlIIlll >= 0; --llllllllllllllllIllllllllIlIIlll) {
                llllllllllllllllIllllllllIIllIll = (llllllllllllllllIllllllllIIllIll << 8 | (long)(llllllllllllllllIllllllllIIlllII[llllllllllllllllIllllllllIlIIlll] & 0xFF));
            }
            return llllllllllllllllIllllllllIIllIll;
        }
        catch (IOException llllllllllllllllIllllllllIIllIlI) {
            throw new CannotCompileException(llllllllllllllllIllllllllIIllIlI);
        }
        catch (NoSuchAlgorithmException llllllllllllllllIllllllllIIllIIl) {
            throw new CannotCompileException(llllllllllllllllIllllllllIIllIIl);
        }
    }
    
    private static String javaName(final String llllllllllllllllIllllllllIIIIlII) {
        return Descriptor.toJavaName(Descriptor.toJvmName(llllllllllllllllIllllllllIIIIlII));
    }
}
