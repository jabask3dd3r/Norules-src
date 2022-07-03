package com.viaversion.viaversion.libs.javassist.bytecode;

import java.util.*;
import com.viaversion.viaversion.libs.javassist.*;

public class Descriptor
{
    public static int paramSize(final String lllllllllllllIIlIllIlIllIlllIIIl) {
        return -dataSize(lllllllllllllIIlIllIlIllIlllIIIl, false);
    }
    
    public static String toString(final String lllllllllllllIIlIllIlIllIlIlllIl) {
        return PrettyPrinter.toString(lllllllllllllIIlIllIlIllIlIlllIl);
    }
    
    public static String changeReturnType(final String lllllllllllllIIlIllIlIllllllIllI, final String lllllllllllllIIlIllIlIllllllIlIl) {
        final int lllllllllllllIIlIllIlIllllllIlII = lllllllllllllIIlIllIlIllllllIlIl.indexOf(41);
        if (lllllllllllllIIlIllIlIllllllIlII < 0) {
            return lllllllllllllIIlIllIlIllllllIlIl;
        }
        final StringBuffer lllllllllllllIIlIllIlIllllllIIll = new StringBuffer();
        lllllllllllllIIlIllIlIllllllIIll.append(lllllllllllllIIlIllIlIllllllIlIl.substring(0, lllllllllllllIIlIllIlIllllllIlII + 1));
        lllllllllllllIIlIllIlIllllllIIll.append('L');
        lllllllllllllIIlIllIlIllllllIIll.append(lllllllllllllIIlIllIlIllllllIllI.replace('.', '/'));
        lllllllllllllIIlIllIlIllllllIIll.append(';');
        return lllllllllllllIIlIllIlIllllllIIll.toString();
    }
    
    public static int dataSize(final String lllllllllllllIIlIllIlIllIlllIlII) {
        return dataSize(lllllllllllllIIlIllIlIllIlllIlII, true);
    }
    
    public static String toClassName(final String lllllllllllllIIlIllIllIIlIIIIIIl) {
        int lllllllllllllIIlIllIllIIlIIIIllI = 0;
        int lllllllllllllIIlIllIllIIlIIIIlIl;
        char lllllllllllllIIlIllIllIIlIIIIlII;
        for (lllllllllllllIIlIllIllIIlIIIIlIl = 0, lllllllllllllIIlIllIllIIlIIIIlII = lllllllllllllIIlIllIllIIlIIIIIIl.charAt(0); lllllllllllllIIlIllIllIIlIIIIlII == '['; lllllllllllllIIlIllIllIIlIIIIlII = lllllllllllllIIlIllIllIIlIIIIIIl.charAt(++lllllllllllllIIlIllIllIIlIIIIlIl)) {
            ++lllllllllllllIIlIllIllIIlIIIIllI;
        }
        if (lllllllllllllIIlIllIllIIlIIIIlII == 'L') {
            final int lllllllllllllIIlIllIllIIlIIlIIlI = lllllllllllllIIlIllIllIIlIIIIIIl.indexOf(59, lllllllllllllIIlIllIllIIlIIIIlIl++);
            final String lllllllllllllIIlIllIllIIlIIlIIIl = lllllllllllllIIlIllIllIIlIIIIIIl.substring(lllllllllllllIIlIllIllIIlIIIIlIl, lllllllllllllIIlIllIllIIlIIlIIlI).replace('/', '.');
            lllllllllllllIIlIllIllIIlIIIIlIl = lllllllllllllIIlIllIllIIlIIlIIlI;
        }
        else if (lllllllllllllIIlIllIllIIlIIIIlII == 'V') {
            final String lllllllllllllIIlIllIllIIlIIlIIII = "void";
        }
        else if (lllllllllllllIIlIllIllIIlIIIIlII == 'I') {
            final String lllllllllllllIIlIllIllIIlIIIllll = "int";
        }
        else if (lllllllllllllIIlIllIllIIlIIIIlII == 'B') {
            final String lllllllllllllIIlIllIllIIlIIIlllI = "byte";
        }
        else if (lllllllllllllIIlIllIllIIlIIIIlII == 'J') {
            final String lllllllllllllIIlIllIllIIlIIIllIl = "long";
        }
        else if (lllllllllllllIIlIllIllIIlIIIIlII == 'D') {
            final String lllllllllllllIIlIllIllIIlIIIllII = "double";
        }
        else if (lllllllllllllIIlIllIllIIlIIIIlII == 'F') {
            final String lllllllllllllIIlIllIllIIlIIIlIll = "float";
        }
        else if (lllllllllllllIIlIllIllIIlIIIIlII == 'C') {
            final String lllllllllllllIIlIllIllIIlIIIlIlI = "char";
        }
        else if (lllllllllllllIIlIllIllIIlIIIIlII == 'S') {
            final String lllllllllllllIIlIllIllIIlIIIlIIl = "short";
        }
        else {
            if (lllllllllllllIIlIllIllIIlIIIIlII != 'Z') {
                throw new RuntimeException(String.valueOf(new StringBuilder().append("bad descriptor: ").append(lllllllllllllIIlIllIllIIlIIIIIIl)));
            }
            final String lllllllllllllIIlIllIllIIlIIIlIII = "boolean";
        }
        if (lllllllllllllIIlIllIllIIlIIIIlIl + 1 != lllllllllllllIIlIllIllIIlIIIIIIl.length()) {
            throw new RuntimeException(String.valueOf(new StringBuilder().append("multiple descriptors?: ").append(lllllllllllllIIlIllIllIIlIIIIIIl)));
        }
        final String lllllllllllllIIlIllIllIIlIIIIIll;
        if (lllllllllllllIIlIllIllIIlIIIIllI == 0) {
            return lllllllllllllIIlIllIllIIlIIIIIll;
        }
        final StringBuffer lllllllllllllIIlIllIllIIlIIIIIlI = new StringBuffer(lllllllllllllIIlIllIllIIlIIIIIll);
        do {
            lllllllllllllIIlIllIllIIlIIIIIlI.append("[]");
        } while (--lllllllllllllIIlIllIllIIlIIIIllI > 0);
        return lllllllllllllIIlIllIllIIlIIIIIlI.toString();
    }
    
    public static String ofMethod(final CtClass lllllllllllllIIlIllIllIIIIlIlIIl, final CtClass[] lllllllllllllIIlIllIllIIIIlIlIII) {
        final StringBuffer lllllllllllllIIlIllIllIIIIlIIlll = new StringBuffer();
        lllllllllllllIIlIllIllIIIIlIIlll.append('(');
        if (lllllllllllllIIlIllIllIIIIlIlIII != null) {
            for (int lllllllllllllIIlIllIllIIIIlIlIlI = lllllllllllllIIlIllIllIIIIlIlIII.length, lllllllllllllIIlIllIllIIIIlIlIll = 0; lllllllllllllIIlIllIllIIIIlIlIll < lllllllllllllIIlIllIllIIIIlIlIlI; ++lllllllllllllIIlIllIllIIIIlIlIll) {
                toDescriptor(lllllllllllllIIlIllIllIIIIlIIlll, lllllllllllllIIlIllIllIIIIlIlIII[lllllllllllllIIlIllIllIIIIlIlIll]);
            }
        }
        lllllllllllllIIlIllIllIIIIlIIlll.append(')');
        if (lllllllllllllIIlIllIllIIIIlIlIIl != null) {
            toDescriptor(lllllllllllllIIlIllIllIIIIlIIlll, lllllllllllllIIlIllIllIIIIlIlIIl);
        }
        return lllllllllllllIIlIllIllIIIIlIIlll.toString();
    }
    
    public static String getParamDescriptor(final String lllllllllllllIIlIllIlIllllIIlllI) {
        return lllllllllllllIIlIllIlIllllIIlllI.substring(0, lllllllllllllIIlIllIlIllllIIlllI.indexOf(41) + 1);
    }
    
    public static String toJvmName(final CtClass lllllllllllllIIlIllIllIIlIIllIIl) {
        if (lllllllllllllIIlIllIllIIlIIllIIl.isArray()) {
            return of(lllllllllllllIIlIllIllIIlIIllIIl);
        }
        return toJvmName(lllllllllllllIIlIllIllIIlIIllIIl.getName());
    }
    
    public static int arrayDimension(final String lllllllllllllIIlIllIlIllIllllllI) {
        int lllllllllllllIIlIllIlIllIlllllll;
        for (lllllllllllllIIlIllIlIllIlllllll = 0; lllllllllllllIIlIllIlIllIllllllI.charAt(lllllllllllllIIlIllIlIllIlllllll) == '['; ++lllllllllllllIIlIllIlIllIlllllll) {}
        return lllllllllllllIIlIllIlIllIlllllll;
    }
    
    public static CtClass[] getParameterTypes(final String lllllllllllllIIlIllIlIlllllIIIlI, final ClassPool lllllllllllllIIlIllIlIlllllIIIIl) throws NotFoundException {
        if (lllllllllllllIIlIllIlIlllllIIIlI.charAt(0) != '(') {
            return null;
        }
        final int lllllllllllllIIlIllIlIlllllIIllI = numOfParameters(lllllllllllllIIlIllIlIlllllIIIlI);
        final CtClass[] lllllllllllllIIlIllIlIlllllIIlIl = new CtClass[lllllllllllllIIlIllIlIlllllIIllI];
        int lllllllllllllIIlIllIlIlllllIIlII = 0;
        int lllllllllllllIIlIllIlIlllllIIIll = 1;
        do {
            lllllllllllllIIlIllIlIlllllIIIll = toCtClass(lllllllllllllIIlIllIlIlllllIIIIl, lllllllllllllIIlIllIlIlllllIIIlI, lllllllllllllIIlIllIlIlllllIIIll, lllllllllllllIIlIllIlIlllllIIlIl, lllllllllllllIIlIllIlIlllllIIlII++);
        } while (lllllllllllllIIlIllIlIlllllIIIll > 0);
        return lllllllllllllIIlIllIlIlllllIIlIl;
    }
    
    public static String ofConstructor(final CtClass[] lllllllllllllIIlIllIllIIIIllIIIl) {
        return ofMethod(CtClass.voidType, lllllllllllllIIlIllIllIIIIllIIIl);
    }
    
    public static String ofParameters(final CtClass[] lllllllllllllIIlIllIllIIIIlIIIII) {
        return ofMethod(null, lllllllllllllIIlIllIllIIIIlIIIII);
    }
    
    public static CtClass getReturnType(final String lllllllllllllIIlIllIlIllllIIlIIl, final ClassPool lllllllllllllIIlIllIlIllllIIIlII) throws NotFoundException {
        final int lllllllllllllIIlIllIlIllllIIIlll = lllllllllllllIIlIllIlIllllIIlIIl.indexOf(41);
        if (lllllllllllllIIlIllIlIllllIIIlll < 0) {
            return null;
        }
        final CtClass[] lllllllllllllIIlIllIlIllllIIIllI = { null };
        toCtClass(lllllllllllllIIlIllIlIllllIIIlII, lllllllllllllIIlIllIlIllllIIlIIl, lllllllllllllIIlIllIlIllllIIIlll + 1, lllllllllllllIIlIllIlIllllIIIllI, 0);
        return lllllllllllllIIlIllIlIllllIIIllI[0];
    }
    
    public static CtClass toCtClass(final String lllllllllllllIIlIllIlIlllIlIllIl, final ClassPool lllllllllllllIIlIllIlIlllIlIllII) throws NotFoundException {
        final CtClass[] lllllllllllllIIlIllIlIlllIlIllll = { null };
        final int lllllllllllllIIlIllIlIlllIlIlllI = toCtClass(lllllllllllllIIlIllIlIlllIlIllII, lllllllllllllIIlIllIlIlllIlIllIl, 0, lllllllllllllIIlIllIlIlllIlIllll, 0);
        if (lllllllllllllIIlIllIlIlllIlIlllI >= 0) {
            return lllllllllllllIIlIllIlIlllIlIllll[0];
        }
        return lllllllllllllIIlIllIlIlllIlIllII.get(lllllllllllllIIlIllIlIlllIlIllIl.replace('/', '.'));
    }
    
    public static String insertParameter(final CtClass lllllllllllllIIlIllIlIlllllllllI, final String lllllllllllllIIlIllIlIlllllllIll) {
        if (lllllllllllllIIlIllIlIlllllllIll.charAt(0) != '(') {
            return lllllllllllllIIlIllIlIlllllllIll;
        }
        return String.valueOf(new StringBuilder().append("(").append(of(lllllllllllllIIlIllIlIlllllllllI)).append(lllllllllllllIIlIllIlIlllllllIll.substring(1)));
    }
    
    private static int dataSize(final String lllllllllllllIIlIllIlIllIllIIlII, final boolean lllllllllllllIIlIllIlIllIllIIlll) {
        int lllllllllllllIIlIllIlIllIllIIllI = 0;
        char lllllllllllllIIlIllIlIllIllIIlIl = lllllllllllllIIlIllIlIllIllIIlII.charAt(0);
        if (lllllllllllllIIlIllIlIllIllIIlIl == '(') {
            int lllllllllllllIIlIllIlIllIllIlIIl = 1;
            while (true) {
                lllllllllllllIIlIllIlIllIllIIlIl = lllllllllllllIIlIllIlIllIllIIlII.charAt(lllllllllllllIIlIllIlIllIllIlIIl);
                if (lllllllllllllIIlIllIlIllIllIIlIl == ')') {
                    lllllllllllllIIlIllIlIllIllIIlIl = lllllllllllllIIlIllIlIllIllIIlII.charAt(lllllllllllllIIlIllIlIllIllIlIIl + 1);
                    break;
                }
                boolean lllllllllllllIIlIllIlIllIllIlIlI = false;
                while (lllllllllllllIIlIllIlIllIllIIlIl == '[') {
                    lllllllllllllIIlIllIlIllIllIlIlI = true;
                    lllllllllllllIIlIllIlIllIllIIlIl = lllllllllllllIIlIllIlIllIllIIlII.charAt(++lllllllllllllIIlIllIlIllIllIlIIl);
                }
                if (lllllllllllllIIlIllIlIllIllIIlIl == 'L') {
                    lllllllllllllIIlIllIlIllIllIlIIl = lllllllllllllIIlIllIlIllIllIIlII.indexOf(59, lllllllllllllIIlIllIlIllIllIlIIl) + 1;
                    if (lllllllllllllIIlIllIlIllIllIlIIl <= 0) {
                        throw new IndexOutOfBoundsException("bad descriptor");
                    }
                }
                else {
                    ++lllllllllllllIIlIllIlIllIllIlIIl;
                }
                if (!lllllllllllllIIlIllIlIllIllIlIlI && (lllllllllllllIIlIllIlIllIllIIlIl == 'J' || lllllllllllllIIlIllIlIllIllIIlIl == 'D')) {
                    lllllllllllllIIlIllIlIllIllIIllI -= 2;
                }
                else {
                    --lllllllllllllIIlIllIlIllIllIIllI;
                }
            }
        }
        if (lllllllllllllIIlIllIlIllIllIIlll) {
            if (lllllllllllllIIlIllIlIllIllIIlIl == 'J' || lllllllllllllIIlIllIlIllIllIIlIl == 'D') {
                lllllllllllllIIlIllIlIllIllIIllI += 2;
            }
            else if (lllllllllllllIIlIllIlIllIllIIlIl != 'V') {
                ++lllllllllllllIIlIllIlIllIllIIllI;
            }
        }
        return lllllllllllllIIlIllIlIllIllIIllI;
    }
    
    public static String toJvmName(final String lllllllllllllIIlIllIllIIlIlIIIII) {
        return lllllllllllllIIlIllIllIIlIlIIIII.replace('.', '/');
    }
    
    public static String appendParameter(final CtClass lllllllllllllIIlIllIllIIIIIIIlII, final String lllllllllllllIIlIllIllIIIIIIIIll) {
        final int lllllllllllllIIlIllIllIIIIIIIllI = lllllllllllllIIlIllIllIIIIIIIIll.indexOf(41);
        if (lllllllllllllIIlIllIllIIIIIIIllI < 0) {
            return lllllllllllllIIlIllIllIIIIIIIIll;
        }
        final StringBuffer lllllllllllllIIlIllIllIIIIIIIlIl = new StringBuffer();
        lllllllllllllIIlIllIllIIIIIIIlIl.append(lllllllllllllIIlIllIllIIIIIIIIll.substring(0, lllllllllllllIIlIllIllIIIIIIIllI));
        toDescriptor(lllllllllllllIIlIllIllIIIIIIIlIl, lllllllllllllIIlIllIllIIIIIIIlII);
        lllllllllllllIIlIllIllIIIIIIIlIl.append(lllllllllllllIIlIllIllIIIIIIIIll.substring(lllllllllllllIIlIllIllIIIIIIIllI));
        return lllllllllllllIIlIllIllIIIIIIIlIl.toString();
    }
    
    static CtClass toPrimitiveClass(final char lllllllllllllIIlIllIlIlllIIIIlII) {
        CtClass lllllllllllllIIlIllIlIlllIIIIlIl = null;
        switch (lllllllllllllIIlIllIlIlllIIIIlII) {
            case 'Z': {
                lllllllllllllIIlIllIlIlllIIIIlIl = CtClass.booleanType;
                break;
            }
            case 'C': {
                lllllllllllllIIlIllIlIlllIIIIlIl = CtClass.charType;
                break;
            }
            case 'B': {
                lllllllllllllIIlIllIlIlllIIIIlIl = CtClass.byteType;
                break;
            }
            case 'S': {
                lllllllllllllIIlIllIlIlllIIIIlIl = CtClass.shortType;
                break;
            }
            case 'I': {
                lllllllllllllIIlIllIlIlllIIIIlIl = CtClass.intType;
                break;
            }
            case 'J': {
                lllllllllllllIIlIllIlIlllIIIIlIl = CtClass.longType;
                break;
            }
            case 'F': {
                lllllllllllllIIlIllIlIlllIIIIlIl = CtClass.floatType;
                break;
            }
            case 'D': {
                lllllllllllllIIlIllIlIlllIIIIlIl = CtClass.doubleType;
                break;
            }
            case 'V': {
                lllllllllllllIIlIllIlIlllIIIIlIl = CtClass.voidType;
                break;
            }
        }
        return lllllllllllllIIlIllIlIlllIIIIlIl;
    }
    
    public static boolean eqParamTypes(final String lllllllllllllIIlIllIlIllllIlIlII, final String lllllllllllllIIlIllIlIllllIlIlIl) {
        if (lllllllllllllIIlIllIlIllllIlIlII.charAt(0) != '(') {
            return false;
        }
        int lllllllllllllIIlIllIlIllllIlIlll = 0;
        while (true) {
            final char lllllllllllllIIlIllIlIllllIllIII = lllllllllllllIIlIllIlIllllIlIlII.charAt(lllllllllllllIIlIllIlIllllIlIlll);
            if (lllllllllllllIIlIllIlIllllIllIII != lllllllllllllIIlIllIlIllllIlIlIl.charAt(lllllllllllllIIlIllIlIllllIlIlll)) {
                return false;
            }
            if (lllllllllllllIIlIllIlIllllIllIII == ')') {
                return true;
            }
            ++lllllllllllllIIlIllIlIllllIlIlll;
        }
    }
    
    private static int toCtClass(final ClassPool lllllllllllllIIlIllIlIlllIIlIIlI, final String lllllllllllllIIlIllIlIlllIIlIIIl, int lllllllllllllIIlIllIlIlllIIllIIl, final CtClass[] lllllllllllllIIlIllIlIlllIIIllll, final int lllllllllllllIIlIllIlIlllIIIlllI) throws NotFoundException {
        int lllllllllllllIIlIllIlIlllIIlIlII = 0;
        char lllllllllllllIIlIllIlIlllIIlIIll;
        for (lllllllllllllIIlIllIlIlllIIlIIll = lllllllllllllIIlIllIlIlllIIlIIIl.charAt(lllllllllllllIIlIllIlIlllIIllIIl); lllllllllllllIIlIllIlIlllIIlIIll == '['; lllllllllllllIIlIllIlIlllIIlIIll = lllllllllllllIIlIllIlIlllIIlIIIl.charAt(++lllllllllllllIIlIllIlIlllIIllIIl)) {
            ++lllllllllllllIIlIllIlIlllIIlIlII;
        }
        int lllllllllllllIIlIllIlIlllIIlIllI = 0;
        String lllllllllllllIIlIllIlIlllIIlIlIl = null;
        if (lllllllllllllIIlIllIlIlllIIlIIll == 'L') {
            int lllllllllllllIIlIllIlIlllIIlllll = lllllllllllllIIlIllIlIlllIIlIIIl.indexOf(59, ++lllllllllllllIIlIllIlIlllIIllIIl);
            final String lllllllllllllIIlIllIlIlllIIllllI = lllllllllllllIIlIllIlIlllIIlIIIl.substring(lllllllllllllIIlIllIlIlllIIllIIl, lllllllllllllIIlIllIlIlllIIlllll++).replace('/', '.');
        }
        else {
            final CtClass lllllllllllllIIlIllIlIlllIIlllIl = toPrimitiveClass(lllllllllllllIIlIllIlIlllIIlIIll);
            if (lllllllllllllIIlIllIlIlllIIlllIl == null) {
                return -1;
            }
            lllllllllllllIIlIllIlIlllIIlIllI = lllllllllllllIIlIllIlIlllIIllIIl + 1;
            if (lllllllllllllIIlIllIlIlllIIlIlII == 0) {
                lllllllllllllIIlIllIlIlllIIIllll[lllllllllllllIIlIllIlIlllIIIlllI] = lllllllllllllIIlIllIlIlllIIlllIl;
                return lllllllllllllIIlIllIlIlllIIlIllI;
            }
            lllllllllllllIIlIllIlIlllIIlIlIl = lllllllllllllIIlIllIlIlllIIlllIl.getName();
        }
        if (lllllllllllllIIlIllIlIlllIIlIlII > 0) {
            final StringBuffer lllllllllllllIIlIllIlIlllIIlllII = new StringBuffer(lllllllllllllIIlIllIlIlllIIlIlIl);
            while (lllllllllllllIIlIllIlIlllIIlIlII-- > 0) {
                lllllllllllllIIlIllIlIlllIIlllII.append("[]");
            }
            lllllllllllllIIlIllIlIlllIIlIlIl = lllllllllllllIIlIllIlIlllIIlllII.toString();
        }
        lllllllllllllIIlIllIlIlllIIIllll[lllllllllllllIIlIllIlIlllIIIlllI] = lllllllllllllIIlIllIlIlllIIlIIlI.get(lllllllllllllIIlIllIlIlllIIlIlIl);
        return lllllllllllllIIlIllIlIlllIIlIllI;
    }
    
    public static String appendParameter(final String lllllllllllllIIlIllIllIIIIIlIllI, final String lllllllllllllIIlIllIllIIIIIlIlIl) {
        final int lllllllllllllIIlIllIllIIIIIllIII = lllllllllllllIIlIllIllIIIIIlIlIl.indexOf(41);
        if (lllllllllllllIIlIllIllIIIIIllIII < 0) {
            return lllllllllllllIIlIllIllIIIIIlIlIl;
        }
        final StringBuffer lllllllllllllIIlIllIllIIIIIlIlll = new StringBuffer();
        lllllllllllllIIlIllIllIIIIIlIlll.append(lllllllllllllIIlIllIllIIIIIlIlIl.substring(0, lllllllllllllIIlIllIllIIIIIllIII));
        lllllllllllllIIlIllIllIIIIIlIlll.append('L');
        lllllllllllllIIlIllIllIIIIIlIlll.append(lllllllllllllIIlIllIllIIIIIlIllI.replace('.', '/'));
        lllllllllllllIIlIllIllIIIIIlIlll.append(';');
        lllllllllllllIIlIllIllIIIIIlIlll.append(lllllllllllllIIlIllIllIIIIIlIlIl.substring(lllllllllllllIIlIllIllIIIIIllIII));
        return lllllllllllllIIlIllIllIIIIIlIlll.toString();
    }
    
    public static String rename(final String lllllllllllllIIlIllIllIIIlIlIlIl, final Map<String, String> lllllllllllllIIlIllIllIIIlIlIlII) {
        if (lllllllllllllIIlIllIllIIIlIlIlII == null) {
            return lllllllllllllIIlIllIllIIIlIlIlIl;
        }
        final StringBuffer lllllllllllllIIlIllIllIIIlIlIIll = new StringBuffer();
        int lllllllllllllIIlIllIllIIIlIlIIlI = 0;
        int lllllllllllllIIlIllIllIIIlIlIIIl = 0;
        while (true) {
            final int lllllllllllllIIlIllIllIIIlIllIIl = lllllllllllllIIlIllIllIIIlIlIlIl.indexOf(76, lllllllllllllIIlIllIllIIIlIlIIIl);
            if (lllllllllllllIIlIllIllIIIlIllIIl < 0) {
                break;
            }
            final int lllllllllllllIIlIllIllIIIlIllIII = lllllllllllllIIlIllIllIIIlIlIlIl.indexOf(59, lllllllllllllIIlIllIllIIIlIllIIl);
            if (lllllllllllllIIlIllIllIIIlIllIII < 0) {
                break;
            }
            lllllllllllllIIlIllIllIIIlIlIIIl = lllllllllllllIIlIllIllIIIlIllIII + 1;
            final String lllllllllllllIIlIllIllIIIlIlIlll = lllllllllllllIIlIllIllIIIlIlIlIl.substring(lllllllllllllIIlIllIllIIIlIllIIl + 1, lllllllllllllIIlIllIllIIIlIllIII);
            final String lllllllllllllIIlIllIllIIIlIlIllI = lllllllllllllIIlIllIllIIIlIlIlII.get(lllllllllllllIIlIllIllIIIlIlIlll);
            if (lllllllllllllIIlIllIllIIIlIlIllI == null) {
                continue;
            }
            lllllllllllllIIlIllIllIIIlIlIIll.append(lllllllllllllIIlIllIllIIIlIlIlIl.substring(lllllllllllllIIlIllIllIIIlIlIIlI, lllllllllllllIIlIllIllIIIlIllIIl));
            lllllllllllllIIlIllIllIIIlIlIIll.append('L');
            lllllllllllllIIlIllIllIIIlIlIIll.append(lllllllllllllIIlIllIllIIIlIlIllI);
            lllllllllllllIIlIllIllIIIlIlIIll.append(';');
            lllllllllllllIIlIllIllIIIlIlIIlI = lllllllllllllIIlIllIllIIIlIlIIIl;
        }
        if (lllllllllllllIIlIllIllIIIlIlIIlI == 0) {
            return lllllllllllllIIlIllIllIIIlIlIlIl;
        }
        final int lllllllllllllIIlIllIllIIIlIlIIII = lllllllllllllIIlIllIllIIIlIlIlIl.length();
        if (lllllllllllllIIlIllIllIIIlIlIIlI < lllllllllllllIIlIllIllIIIlIlIIII) {
            lllllllllllllIIlIllIllIIIlIlIIll.append(lllllllllllllIIlIllIllIIIlIlIlIl.substring(lllllllllllllIIlIllIllIIIlIlIIlI, lllllllllllllIIlIllIllIIIlIlIIII));
        }
        return lllllllllllllIIlIllIllIIIlIlIIll.toString();
    }
    
    public static String of(final CtClass lllllllllllllIIlIllIllIIIlIIIlII) {
        final StringBuffer lllllllllllllIIlIllIllIIIlIIIIll = new StringBuffer();
        toDescriptor(lllllllllllllIIlIllIllIIIlIIIIll, lllllllllllllIIlIllIllIIIlIIIlII);
        return lllllllllllllIIlIllIllIIIlIIIIll.toString();
    }
    
    public static String rename(final String lllllllllllllIIlIllIllIIIllIlIIl, final String lllllllllllllIIlIllIllIIIllIlIII, final String lllllllllllllIIlIllIllIIIllIIlll) {
        if (lllllllllllllIIlIllIllIIIllIlIIl.indexOf(lllllllllllllIIlIllIllIIIllIlIII) < 0) {
            return lllllllllllllIIlIllIllIIIllIlIIl;
        }
        final StringBuffer lllllllllllllIIlIllIllIIIllIllIl = new StringBuffer();
        int lllllllllllllIIlIllIllIIIllIllII = 0;
        int lllllllllllllIIlIllIllIIIllIlIll = 0;
        while (true) {
            final int lllllllllllllIIlIllIllIIIlllIIIl = lllllllllllllIIlIllIllIIIllIlIIl.indexOf(76, lllllllllllllIIlIllIllIIIllIlIll);
            if (lllllllllllllIIlIllIllIIIlllIIIl < 0) {
                break;
            }
            if (lllllllllllllIIlIllIllIIIllIlIIl.startsWith(lllllllllllllIIlIllIllIIIllIlIII, lllllllllllllIIlIllIllIIIlllIIIl + 1) && lllllllllllllIIlIllIllIIIllIlIIl.charAt(lllllllllllllIIlIllIllIIIlllIIIl + lllllllllllllIIlIllIllIIIllIlIII.length() + 1) == ';') {
                lllllllllllllIIlIllIllIIIllIllIl.append(lllllllllllllIIlIllIllIIIllIlIIl.substring(lllllllllllllIIlIllIllIIIllIllII, lllllllllllllIIlIllIllIIIlllIIIl));
                lllllllllllllIIlIllIllIIIllIllIl.append('L');
                lllllllllllllIIlIllIllIIIllIllIl.append(lllllllllllllIIlIllIllIIIllIIlll);
                lllllllllllllIIlIllIllIIIllIllIl.append(';');
                lllllllllllllIIlIllIllIIIllIlIll = (lllllllllllllIIlIllIllIIIllIllII = lllllllllllllIIlIllIllIIIlllIIIl + lllllllllllllIIlIllIllIIIllIlIII.length() + 2);
            }
            else {
                lllllllllllllIIlIllIllIIIllIlIll = lllllllllllllIIlIllIllIIIllIlIIl.indexOf(59, lllllllllllllIIlIllIllIIIlllIIIl) + 1;
                if (lllllllllllllIIlIllIllIIIllIlIll < 1) {
                    break;
                }
                continue;
            }
        }
        if (lllllllllllllIIlIllIllIIIllIllII == 0) {
            return lllllllllllllIIlIllIllIIIllIlIIl;
        }
        final int lllllllllllllIIlIllIllIIIllIlIlI = lllllllllllllIIlIllIllIIIllIlIIl.length();
        if (lllllllllllllIIlIllIllIIIllIllII < lllllllllllllIIlIllIllIIIllIlIlI) {
            lllllllllllllIIlIllIllIIIllIllIl.append(lllllllllllllIIlIllIllIIIllIlIIl.substring(lllllllllllllIIlIllIllIIIllIllII, lllllllllllllIIlIllIllIIIllIlIlI));
        }
        return lllllllllllllIIlIllIllIIIllIllIl.toString();
    }
    
    private static void toDescriptor(final StringBuffer lllllllllllllIIlIllIllIIIIllIlll, final CtClass lllllllllllllIIlIllIllIIIIllIllI) {
        if (lllllllllllllIIlIllIllIIIIllIllI.isArray()) {
            lllllllllllllIIlIllIllIIIIllIlll.append('[');
            try {
                toDescriptor(lllllllllllllIIlIllIllIIIIllIlll, lllllllllllllIIlIllIllIIIIllIllI.getComponentType());
            }
            catch (NotFoundException lllllllllllllIIlIllIllIIIIlllIll) {
                lllllllllllllIIlIllIllIIIIllIlll.append('L');
                final String lllllllllllllIIlIllIllIIIIllllII = lllllllllllllIIlIllIllIIIIllIllI.getName();
                lllllllllllllIIlIllIllIIIIllIlll.append(toJvmName(lllllllllllllIIlIllIllIIIIllllII.substring(0, lllllllllllllIIlIllIllIIIIllllII.length() - 2)));
                lllllllllllllIIlIllIllIIIIllIlll.append(';');
            }
        }
        else if (lllllllllllllIIlIllIllIIIIllIllI.isPrimitive()) {
            final CtPrimitiveType lllllllllllllIIlIllIllIIIIlllIlI = (CtPrimitiveType)lllllllllllllIIlIllIllIIIIllIllI;
            lllllllllllllIIlIllIllIIIIllIlll.append(lllllllllllllIIlIllIllIIIIlllIlI.getDescriptor());
        }
        else {
            lllllllllllllIIlIllIllIIIIllIlll.append('L');
            lllllllllllllIIlIllIllIIIIllIlll.append(lllllllllllllIIlIllIllIIIIllIllI.getName().replace('.', '/'));
            lllllllllllllIIlIllIllIIIIllIlll.append(';');
        }
    }
    
    public static String toJavaName(final String lllllllllllllIIlIllIllIIlIIlllII) {
        return lllllllllllllIIlIllIllIIlIIlllII.replace('/', '.');
    }
    
    public static String of(final String lllllllllllllIIlIllIllIIIllllIIl) {
        if (lllllllllllllIIlIllIllIIIllllIIl.equals("void")) {
            return "V";
        }
        if (lllllllllllllIIlIllIllIIIllllIIl.equals("int")) {
            return "I";
        }
        if (lllllllllllllIIlIllIllIIIllllIIl.equals("byte")) {
            return "B";
        }
        if (lllllllllllllIIlIllIllIIIllllIIl.equals("long")) {
            return "J";
        }
        if (lllllllllllllIIlIllIllIIIllllIIl.equals("double")) {
            return "D";
        }
        if (lllllllllllllIIlIllIllIIIllllIIl.equals("float")) {
            return "F";
        }
        if (lllllllllllllIIlIllIllIIIllllIIl.equals("char")) {
            return "C";
        }
        if (lllllllllllllIIlIllIllIIIllllIIl.equals("short")) {
            return "S";
        }
        if (lllllllllllllIIlIllIllIIIllllIIl.equals("boolean")) {
            return "Z";
        }
        return String.valueOf(new StringBuilder().append("L").append(toJvmName(lllllllllllllIIlIllIllIIIllllIIl)).append(";"));
    }
    
    public static String insertParameter(final String lllllllllllllIIlIllIllIIIIIIlllI, final String lllllllllllllIIlIllIllIIIIIIllIl) {
        if (lllllllllllllIIlIllIllIIIIIIllIl.charAt(0) != '(') {
            return lllllllllllllIIlIllIllIIIIIIllIl;
        }
        return String.valueOf(new StringBuilder().append("(L").append(lllllllllllllIIlIllIllIIIIIIlllI.replace('.', '/')).append(';').append(lllllllllllllIIlIllIllIIIIIIllIl.substring(1)));
    }
    
    public static String toArrayComponent(final String lllllllllllllIIlIllIlIllIllllIlI, final int lllllllllllllIIlIllIlIllIlllIlll) {
        return lllllllllllllIIlIllIlIllIllllIlI.substring(lllllllllllllIIlIllIlIllIlllIlll);
    }
    
    public static int numOfParameters(final String lllllllllllllIIlIllIlIlllIllllII) {
        int lllllllllllllIIlIllIlIlllIlllIll = 0;
        int lllllllllllllIIlIllIlIlllIlllIlI = 1;
        while (true) {
            char lllllllllllllIIlIllIlIlllIllllIl = lllllllllllllIIlIllIlIlllIllllII.charAt(lllllllllllllIIlIllIlIlllIlllIlI);
            if (lllllllllllllIIlIllIlIlllIllllIl == ')') {
                return lllllllllllllIIlIllIlIlllIlllIll;
            }
            while (lllllllllllllIIlIllIlIlllIllllIl == '[') {
                lllllllllllllIIlIllIlIlllIllllIl = lllllllllllllIIlIllIlIlllIllllII.charAt(++lllllllllllllIIlIllIlIlllIlllIlI);
            }
            if (lllllllllllllIIlIllIlIlllIllllIl == 'L') {
                lllllllllllllIIlIllIlIlllIlllIlI = lllllllllllllIIlIllIlIlllIllllII.indexOf(59, lllllllllllllIIlIllIlIlllIlllIlI) + 1;
                if (lllllllllllllIIlIllIlIlllIlllIlI <= 0) {
                    throw new IndexOutOfBoundsException("bad descriptor");
                }
            }
            else {
                ++lllllllllllllIIlIllIlIlllIlllIlI;
            }
            ++lllllllllllllIIlIllIlIlllIlllIll;
        }
    }
    
    static class PrettyPrinter
    {
        static int readType(final StringBuffer lllllllllllllIIlIlllIllIIlllllll, int lllllllllllllIIlIlllIllIIllllllI, final String lllllllllllllIIlIlllIllIIlllllIl) {
            char lllllllllllllIIlIlllIllIlIIIIIIl = lllllllllllllIIlIlllIllIIlllllIl.charAt(lllllllllllllIIlIlllIllIIllllllI);
            int lllllllllllllIIlIlllIllIlIIIIIII = 0;
            while (lllllllllllllIIlIlllIllIlIIIIIIl == '[') {
                ++lllllllllllllIIlIlllIllIlIIIIIII;
                lllllllllllllIIlIlllIllIlIIIIIIl = lllllllllllllIIlIlllIllIIlllllIl.charAt(++lllllllllllllIIlIlllIllIIllllllI);
            }
            if (lllllllllllllIIlIlllIllIlIIIIIIl == 'L') {
                while (true) {
                    lllllllllllllIIlIlllIllIlIIIIIIl = lllllllllllllIIlIlllIllIIlllllIl.charAt(++lllllllllllllIIlIlllIllIIllllllI);
                    if (lllllllllllllIIlIlllIllIlIIIIIIl == ';') {
                        break;
                    }
                    if (lllllllllllllIIlIlllIllIlIIIIIIl == '/') {
                        lllllllllllllIIlIlllIllIlIIIIIIl = '.';
                    }
                    lllllllllllllIIlIlllIllIIlllllll.append(lllllllllllllIIlIlllIllIlIIIIIIl);
                }
            }
            else {
                final CtClass lllllllllllllIIlIlllIllIlIIIIlIl = Descriptor.toPrimitiveClass(lllllllllllllIIlIlllIllIlIIIIIIl);
                lllllllllllllIIlIlllIllIIlllllll.append(lllllllllllllIIlIlllIllIlIIIIlIl.getName());
            }
            while (lllllllllllllIIlIlllIllIlIIIIIII-- > 0) {
                lllllllllllllIIlIlllIllIIlllllll.append("[]");
            }
            return lllllllllllllIIlIlllIllIIllllllI + 1;
        }
        
        static String toString(final String lllllllllllllIIlIlllIllIlIIIlllI) {
            final StringBuffer lllllllllllllIIlIlllIllIlIIIllll = new StringBuffer();
            if (lllllllllllllIIlIlllIllIlIIIlllI.charAt(0) == '(') {
                int lllllllllllllIIlIlllIllIlIIlIIIl = 1;
                lllllllllllllIIlIlllIllIlIIIllll.append('(');
                while (lllllllllllllIIlIlllIllIlIIIlllI.charAt(lllllllllllllIIlIlllIllIlIIlIIIl) != ')') {
                    if (lllllllllllllIIlIlllIllIlIIlIIIl > 1) {
                        lllllllllllllIIlIlllIllIlIIIllll.append(',');
                    }
                    lllllllllllllIIlIlllIllIlIIlIIIl = readType(lllllllllllllIIlIlllIllIlIIIllll, lllllllllllllIIlIlllIllIlIIlIIIl, lllllllllllllIIlIlllIllIlIIIlllI);
                }
                lllllllllllllIIlIlllIllIlIIIllll.append(')');
            }
            else {
                readType(lllllllllllllIIlIlllIllIlIIIllll, 0, lllllllllllllIIlIlllIllIlIIIlllI);
            }
            return lllllllllllllIIlIlllIllIlIIIllll.toString();
        }
    }
    
    public static class Iterator
    {
        private /* synthetic */ String desc;
        private /* synthetic */ boolean param;
        private /* synthetic */ int curPos;
        private /* synthetic */ int index;
        
        public Iterator(final String lllllllllllllllIlllllIIlIlllIIIl) {
            this.desc = lllllllllllllllIlllllIIlIlllIIIl;
            final int n = 0;
            this.curPos = n;
            this.index = n;
            this.param = false;
        }
        
        public boolean hasNext() {
            return this.index < this.desc.length();
        }
        
        public boolean is2byte() {
            final char lllllllllllllllIlllllIIlIllIIIlI = this.currentChar();
            return lllllllllllllllIlllllIIlIllIIIlI == 'D' || lllllllllllllllIlllllIIlIllIIIlI == 'J';
        }
        
        public int next() {
            int lllllllllllllllIlllllIIlIlIllIll = this.index;
            char lllllllllllllllIlllllIIlIlIllIlI = this.desc.charAt(lllllllllllllllIlllllIIlIlIllIll);
            if (lllllllllllllllIlllllIIlIlIllIlI == '(') {
                ++this.index;
                lllllllllllllllIlllllIIlIlIllIlI = this.desc.charAt(++lllllllllllllllIlllllIIlIlIllIll);
                this.param = true;
            }
            if (lllllllllllllllIlllllIIlIlIllIlI == ')') {
                ++this.index;
                lllllllllllllllIlllllIIlIlIllIlI = this.desc.charAt(++lllllllllllllllIlllllIIlIlIllIll);
                this.param = false;
            }
            while (lllllllllllllllIlllllIIlIlIllIlI == '[') {
                lllllllllllllllIlllllIIlIlIllIlI = this.desc.charAt(++lllllllllllllllIlllllIIlIlIllIll);
            }
            if (lllllllllllllllIlllllIIlIlIllIlI == 'L') {
                lllllllllllllllIlllllIIlIlIllIll = this.desc.indexOf(59, lllllllllllllllIlllllIIlIlIllIll) + 1;
                if (lllllllllllllllIlllllIIlIlIllIll <= 0) {
                    throw new IndexOutOfBoundsException("bad descriptor");
                }
            }
            else {
                ++lllllllllllllllIlllllIIlIlIllIll;
            }
            this.curPos = this.index;
            this.index = lllllllllllllllIlllllIIlIlIllIll;
            return this.curPos;
        }
        
        public char currentChar() {
            return this.desc.charAt(this.curPos);
        }
        
        public boolean isParameter() {
            return this.param;
        }
    }
}
