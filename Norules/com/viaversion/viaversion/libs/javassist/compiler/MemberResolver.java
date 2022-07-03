package com.viaversion.viaversion.libs.javassist.compiler;

import com.viaversion.viaversion.libs.javassist.*;
import com.viaversion.viaversion.libs.javassist.compiler.ast.*;
import com.viaversion.viaversion.libs.javassist.bytecode.*;
import java.util.*;
import java.lang.ref.*;

public class MemberResolver implements TokenId
{
    private /* synthetic */ Map<String, String> invalidNames;
    private /* synthetic */ ClassPool classPool;
    private static /* synthetic */ Map<ClassPool, Reference<Map<String, String>>> invalidNamesMap;
    
    public static int getInvalidMapSize() {
        return MemberResolver.invalidNamesMap.size();
    }
    
    public CtClass lookupClass(final String llllllllllllllIlIIIIlIIIllIllIlI, final boolean llllllllllllllIlIIIIlIIIllIlIIll) throws CompileError {
        final Map<String, String> llllllllllllllIlIIIIlIIIllIllIII = this.getInvalidNames();
        final String llllllllllllllIlIIIIlIIIllIlIlll = llllllllllllllIlIIIIlIIIllIllIII.get(llllllllllllllIlIIIIlIIIllIllIlI);
        if (llllllllllllllIlIIIIlIIIllIlIlll == "<invalid>") {
            throw new CompileError(String.valueOf(new StringBuilder().append("no such class: ").append(llllllllllllllIlIIIIlIIIllIllIlI)));
        }
        if (llllllllllllllIlIIIIlIIIllIlIlll != null) {
            try {
                return this.classPool.get(llllllllllllllIlIIIIlIIIllIlIlll);
            }
            catch (NotFoundException ex) {}
        }
        CtClass llllllllllllllIlIIIIlIIIllIlIllI = null;
        try {
            llllllllllllllIlIIIIlIIIllIlIllI = this.lookupClass0(llllllllllllllIlIIIIlIIIllIllIlI, llllllllllllllIlIIIIlIIIllIlIIll);
        }
        catch (NotFoundException llllllllllllllIlIIIIlIIIllIlllII) {
            llllllllllllllIlIIIIlIIIllIlIllI = this.searchImports(llllllllllllllIlIIIIlIIIllIllIlI);
        }
        llllllllllllllIlIIIIlIIIllIllIII.put(llllllllllllllIlIIIIlIIIllIllIlI, llllllllllllllIlIIIIlIIIllIlIllI.getName());
        return llllllllllllllIlIIIIlIIIllIlIllI;
    }
    
    public static CtClass getSuperclass(final CtClass llllllllllllllIlIIIIlIIIlIIIlIII) throws CompileError {
        try {
            final CtClass llllllllllllllIlIIIIlIIIlIIIlIlI = llllllllllllllIlIIIIlIIIlIIIlIII.getSuperclass();
            if (llllllllllllllIlIIIIlIIIlIIIlIlI != null) {
                return llllllllllllllIlIIIIlIIIlIIIlIlI;
            }
        }
        catch (NotFoundException ex) {}
        throw new CompileError(String.valueOf(new StringBuilder().append("cannot find the super class of ").append(llllllllllllllIlIIIIlIIIlIIIlIII.getName())));
    }
    
    static {
        YES = 0;
        INVALID = "<invalid>";
        NO = -1;
        MemberResolver.invalidNamesMap = new WeakHashMap<ClassPool, Reference<Map<String, String>>>();
    }
    
    public static int descToType(final char llllllllllllllIlIIIIlIIIIlllIIlI) throws CompileError {
        switch (llllllllllllllIlIIIIlIIIIlllIIlI) {
            case 'Z': {
                return 301;
            }
            case 'C': {
                return 306;
            }
            case 'B': {
                return 303;
            }
            case 'S': {
                return 334;
            }
            case 'I': {
                return 324;
            }
            case 'J': {
                return 326;
            }
            case 'F': {
                return 317;
            }
            case 'D': {
                return 312;
            }
            case 'V': {
                return 344;
            }
            case 'L':
            case '[': {
                return 307;
            }
            default: {
                fatal();
                return 344;
            }
        }
    }
    
    public CtClass lookupClass(final Declarator llllllllllllllIlIIIIlIIlIIlIlIII) throws CompileError {
        return this.lookupClass(llllllllllllllIlIIIIlIIlIIlIlIII.getType(), llllllllllllllIlIIIIlIIlIIlIlIII.getArrayDim(), llllllllllllllIlIIIIlIIlIIlIlIII.getClassName());
    }
    
    private Method lookupMethod(final CtClass llllllllllllllIlIIIIlIIllIlllIll, final String llllllllllllllIlIIIIlIIllIlllIlI, final int[] llllllllllllllIlIIIIlIIllIlllIIl, final int[] llllllllllllllIlIIIIlIIllIlllIII, final String[] llllllllllllllIlIIIIlIIllIllIlll, final boolean llllllllllllllIlIIIIlIIlllIIIIIl) throws CompileError {
        Method llllllllllllllIlIIIIlIIlllIIIIII = null;
        final ClassFile llllllllllllllIlIIIIlIIllIllllll = llllllllllllllIlIIIIlIIllIlllIll.getClassFile2();
        if (llllllllllllllIlIIIIlIIllIllllll != null) {
            final List<MethodInfo> llllllllllllllIlIIIIlIIlllIIllll = llllllllllllllIlIIIIlIIllIllllll.getMethods();
            for (final MethodInfo llllllllllllllIlIIIIlIIlllIlIIII : llllllllllllllIlIIIIlIIlllIIllll) {
                if (llllllllllllllIlIIIIlIIlllIlIIII.getName().equals(llllllllllllllIlIIIIlIIllIlllIlI) && (llllllllllllllIlIIIIlIIlllIlIIII.getAccessFlags() & 0x40) == 0x0) {
                    final int llllllllllllllIlIIIIlIIlllIlIIIl = this.compareSignature(llllllllllllllIlIIIIlIIlllIlIIII.getDescriptor(), llllllllllllllIlIIIIlIIllIlllIIl, llllllllllllllIlIIIIlIIllIlllIII, llllllllllllllIlIIIIlIIllIllIlll);
                    if (llllllllllllllIlIIIIlIIlllIlIIIl == -1) {
                        continue;
                    }
                    final Method llllllllllllllIlIIIIlIIlllIlIIlI = new Method(llllllllllllllIlIIIIlIIllIlllIll, llllllllllllllIlIIIIlIIlllIlIIII, llllllllllllllIlIIIIlIIlllIlIIIl);
                    if (llllllllllllllIlIIIIlIIlllIlIIIl == 0) {
                        return llllllllllllllIlIIIIlIIlllIlIIlI;
                    }
                    if (llllllllllllllIlIIIIlIIlllIIIIII != null && llllllllllllllIlIIIIlIIlllIIIIII.notmatch <= llllllllllllllIlIIIIlIIlllIlIIIl) {
                        continue;
                    }
                    llllllllllllllIlIIIIlIIlllIIIIII = llllllllllllllIlIIIIlIIlllIlIIlI;
                }
            }
        }
        if (llllllllllllllIlIIIIlIIlllIIIIIl) {
            llllllllllllllIlIIIIlIIlllIIIIII = null;
        }
        else if (llllllllllllllIlIIIIlIIlllIIIIII != null) {
            return llllllllllllllIlIIIIlIIlllIIIIII;
        }
        final int llllllllllllllIlIIIIlIIllIlllllI = llllllllllllllIlIIIIlIIllIlllIll.getModifiers();
        final boolean llllllllllllllIlIIIIlIIllIllllIl = Modifier.isInterface(llllllllllllllIlIIIIlIIllIlllllI);
        try {
            if (!llllllllllllllIlIIIIlIIllIllllIl) {
                final CtClass llllllllllllllIlIIIIlIIlllIIllIl = llllllllllllllIlIIIIlIIllIlllIll.getSuperclass();
                if (llllllllllllllIlIIIIlIIlllIIllIl != null) {
                    final Method llllllllllllllIlIIIIlIIlllIIlllI = this.lookupMethod(llllllllllllllIlIIIIlIIlllIIllIl, llllllllllllllIlIIIIlIIllIlllIlI, llllllllllllllIlIIIIlIIllIlllIIl, llllllllllllllIlIIIIlIIllIlllIII, llllllllllllllIlIIIIlIIllIllIlll, llllllllllllllIlIIIIlIIlllIIIIIl);
                    if (llllllllllllllIlIIIIlIIlllIIlllI != null) {
                        return llllllllllllllIlIIIIlIIlllIIlllI;
                    }
                }
            }
        }
        catch (NotFoundException ex) {}
        try {
            final CtClass[] interfaces;
            final CtClass[] llllllllllllllIlIIIIlIIlllIIlIII = interfaces = llllllllllllllIlIIIIlIIllIlllIll.getInterfaces();
            final int length = interfaces.length;
            for (boolean llllllllllllllIlIIIIlIIllIlIlllI = false; (llllllllllllllIlIIIIlIIllIlIlllI ? 1 : 0) < length; ++llllllllllllllIlIIIIlIIllIlIlllI) {
                final CtClass llllllllllllllIlIIIIlIIlllIIlIll = interfaces[llllllllllllllIlIIIIlIIllIlIlllI];
                final Method llllllllllllllIlIIIIlIIlllIIllII = this.lookupMethod(llllllllllllllIlIIIIlIIlllIIlIll, llllllllllllllIlIIIIlIIllIlllIlI, llllllllllllllIlIIIIlIIllIlllIIl, llllllllllllllIlIIIIlIIllIlllIII, llllllllllllllIlIIIIlIIllIllIlll, llllllllllllllIlIIIIlIIlllIIIIIl);
                if (llllllllllllllIlIIIIlIIlllIIllII != null) {
                    return llllllllllllllIlIIIIlIIlllIIllII;
                }
            }
            if (llllllllllllllIlIIIIlIIllIllllIl) {
                final CtClass llllllllllllllIlIIIIlIIlllIIlIIl = llllllllllllllIlIIIIlIIllIlllIll.getSuperclass();
                if (llllllllllllllIlIIIIlIIlllIIlIIl != null) {
                    final Method llllllllllllllIlIIIIlIIlllIIlIlI = this.lookupMethod(llllllllllllllIlIIIIlIIlllIIlIIl, llllllllllllllIlIIIIlIIllIlllIlI, llllllllllllllIlIIIIlIIllIlllIIl, llllllllllllllIlIIIIlIIllIlllIII, llllllllllllllIlIIIIlIIllIllIlll, llllllllllllllIlIIIIlIIlllIIIIIl);
                    if (llllllllllllllIlIIIIlIIlllIIlIlI != null) {
                        return llllllllllllllIlIIIIlIIlllIIlIlI;
                    }
                }
            }
        }
        catch (NotFoundException ex2) {}
        return llllllllllllllIlIIIIlIIlllIIIIII;
    }
    
    private CtClass searchImports(final String llllllllllllllIlIIIIlIIIlIllIlIl) throws CompileError {
        if (llllllllllllllIlIIIIlIIIlIllIlIl.indexOf(46) < 0) {
            final Iterator<String> llllllllllllllIlIIIIlIIIlIllIlll = this.classPool.getImportedPackages();
            while (llllllllllllllIlIIIIlIIIlIllIlll.hasNext()) {
                final String llllllllllllllIlIIIIlIIIlIlllIIl = llllllllllllllIlIIIIlIIIlIllIlll.next();
                final String llllllllllllllIlIIIIlIIIlIlllIII = String.valueOf(new StringBuilder().append(llllllllllllllIlIIIIlIIIlIlllIIl.replaceAll("\\.$", "")).append(".").append(llllllllllllllIlIIIIlIIIlIllIlIl));
                try {
                    return this.classPool.get(llllllllllllllIlIIIIlIIIlIlllIII);
                }
                catch (NotFoundException llllllllllllllIlIIIIlIIIlIlllIlI) {
                    try {
                        if (llllllllllllllIlIIIIlIIIlIlllIIl.endsWith(String.valueOf(new StringBuilder().append(".").append(llllllllllllllIlIIIIlIIIlIllIlIl)))) {
                            return this.classPool.get(llllllllllllllIlIIIIlIIIlIlllIIl);
                        }
                        continue;
                    }
                    catch (NotFoundException ex) {}
                    continue;
                }
                break;
            }
        }
        this.getInvalidNames().put(llllllllllllllIlIIIIlIIIlIllIlIl, "<invalid>");
        throw new CompileError(String.valueOf(new StringBuilder().append("no such class: ").append(llllllllllllllIlIIIIlIIIlIllIlIl)));
    }
    
    public CtField lookupFieldByJvmName2(String llllllllllllllIlIIIIlIIlIlIlIllI, final Symbol llllllllllllllIlIIIIlIIlIlIllIll, final ASTree llllllllllllllIlIIIIlIIlIlIllIlI) throws NoFieldException {
        final String llllllllllllllIlIIIIlIIlIlIllIIl = llllllllllllllIlIIIIlIIlIlIllIll.get();
        CtClass llllllllllllllIlIIIIlIIlIlIllIII = null;
        try {
            llllllllllllllIlIIIIlIIlIlIllIII = this.lookupClass(jvmToJavaName(llllllllllllllIlIIIIlIIlIlIlIllI), true);
        }
        catch (CompileError llllllllllllllIlIIIIlIIlIlIlllll) {
            throw new NoFieldException(String.valueOf(new StringBuilder().append(llllllllllllllIlIIIIlIIlIlIlIllI).append("/").append(llllllllllllllIlIIIIlIIlIlIllIIl)), llllllllllllllIlIIIIlIIlIlIllIlI);
        }
        try {
            return llllllllllllllIlIIIIlIIlIlIllIII.getField(llllllllllllllIlIIIIlIIlIlIllIIl);
        }
        catch (NotFoundException llllllllllllllIlIIIIlIIlIlIllllI) {
            llllllllllllllIlIIIIlIIlIlIlIllI = javaToJvmName(llllllllllllllIlIIIIlIIlIlIllIII.getName());
            throw new NoFieldException(String.valueOf(new StringBuilder().append(llllllllllllllIlIIIIlIIlIlIlIllI).append("$").append(llllllllllllllIlIIIIlIIlIlIllIIl)), llllllllllllllIlIIIIlIIlIlIllIlI);
        }
    }
    
    public Method lookupMethod(final CtClass llllllllllllllIlIIIIlIIlllllIlll, final CtClass llllllllllllllIlIIIIlIIllllIllII, final MethodInfo llllllllllllllIlIIIIlIIlllllIlIl, final String llllllllllllllIlIIIIlIIllllIlIlI, final int[] llllllllllllllIlIIIIlIIllllIlIIl, final int[] llllllllllllllIlIIIIlIIlllllIIlI, final String[] llllllllllllllIlIIIIlIIlllllIIIl) throws CompileError {
        Method llllllllllllllIlIIIIlIIlllllIIII = null;
        if (llllllllllllllIlIIIIlIIlllllIlIl != null && llllllllllllllIlIIIIlIIlllllIlll == llllllllllllllIlIIIIlIIllllIllII && llllllllllllllIlIIIIlIIlllllIlIl.getName().equals(llllllllllllllIlIIIIlIIllllIlIlI)) {
            final int llllllllllllllIlIIIIlIIllllllIIl = this.compareSignature(llllllllllllllIlIIIIlIIlllllIlIl.getDescriptor(), llllllllllllllIlIIIIlIIllllIlIIl, llllllllllllllIlIIIIlIIlllllIIlI, llllllllllllllIlIIIIlIIlllllIIIl);
            if (llllllllllllllIlIIIIlIIllllllIIl != -1) {
                final Method llllllllllllllIlIIIIlIIllllllIlI = new Method(llllllllllllllIlIIIIlIIlllllIlll, llllllllllllllIlIIIIlIIlllllIlIl, llllllllllllllIlIIIIlIIllllllIIl);
                if (llllllllllllllIlIIIIlIIllllllIIl == 0) {
                    return llllllllllllllIlIIIIlIIllllllIlI;
                }
                llllllllllllllIlIIIIlIIlllllIIII = llllllllllllllIlIIIIlIIllllllIlI;
            }
        }
        final Method llllllllllllllIlIIIIlIIllllIllll = this.lookupMethod(llllllllllllllIlIIIIlIIlllllIlll, llllllllllllllIlIIIIlIIllllIlIlI, llllllllllllllIlIIIIlIIllllIlIIl, llllllllllllllIlIIIIlIIlllllIIlI, llllllllllllllIlIIIIlIIlllllIIIl, llllllllllllllIlIIIIlIIlllllIIII != null);
        if (llllllllllllllIlIIIIlIIllllIllll != null) {
            return llllllllllllllIlIIIIlIIllllIllll;
        }
        return llllllllllllllIlIIIIlIIlllllIIII;
    }
    
    private CtClass lookupClass0(String llllllllllllllIlIIIIlIIIlIIllllI, final boolean llllllllllllllIlIIIIlIIIlIIlllIl) throws NotFoundException {
        CtClass llllllllllllllIlIIIIlIIIlIlIIIII = null;
        do {
            try {
                llllllllllllllIlIIIIlIIIlIlIIIII = this.classPool.get(llllllllllllllIlIIIIlIIIlIIllllI);
            }
            catch (NotFoundException llllllllllllllIlIIIIlIIIlIlIIlII) {
                final int llllllllllllllIlIIIIlIIIlIlIIllI = llllllllllllllIlIIIIlIIIlIIllllI.lastIndexOf(46);
                if (llllllllllllllIlIIIIlIIIlIIlllIl || llllllllllllllIlIIIIlIIIlIlIIllI < 0) {
                    throw llllllllllllllIlIIIIlIIIlIlIIlII;
                }
                final StringBuffer llllllllllllllIlIIIIlIIIlIlIIlIl = new StringBuffer(llllllllllllllIlIIIIlIIIlIIllllI);
                llllllllllllllIlIIIIlIIIlIlIIlIl.setCharAt(llllllllllllllIlIIIIlIIIlIlIIllI, '$');
                llllllllllllllIlIIIIlIIIlIIllllI = llllllllllllllIlIIIIlIIIlIlIIlIl.toString();
            }
        } while (llllllllllllllIlIIIIlIIIlIlIIIII == null);
        return llllllllllllllIlIIIIlIIIlIlIIIII;
    }
    
    public static String javaToJvmName(final String llllllllllllllIlIIIIlIIIIllllIIl) {
        return llllllllllllllIlIIIIlIIIIllllIIl.replace('.', '/');
    }
    
    public String resolveClassName(final ASTList llllllllllllllIlIIIIlIIIlIIlIlIl) throws CompileError {
        if (llllllllllllllIlIIIIlIIIlIIlIlIl == null) {
            return null;
        }
        return javaToJvmName(this.lookupClassByName(llllllllllllllIlIIIIlIIIlIIlIlIl).getName());
    }
    
    public String resolveJvmClassName(final String llllllllllllllIlIIIIlIIIlIIIllll) throws CompileError {
        if (llllllllllllllIlIIIIlIIIlIIIllll == null) {
            return null;
        }
        return javaToJvmName(this.lookupClassByJvmName(llllllllllllllIlIIIIlIIIlIIIllll).getName());
    }
    
    private static void fatal() throws CompileError {
        throw new CompileError("fatal");
    }
    
    public CtClass lookupClass(final int llllllllllllllIlIIIIlIIlIIIllIlI, int llllllllllllllIlIIIIlIIlIIIllIIl, final String llllllllllllllIlIIIIlIIlIIIlllIl) throws CompileError {
        String llllllllllllllIlIIIIlIIlIIIlllII = "";
        if (llllllllllllllIlIIIIlIIlIIIllIlI == 307) {
            final CtClass llllllllllllllIlIIIIlIIlIIlIIIIl = this.lookupClassByJvmName(llllllllllllllIlIIIIlIIlIIIlllIl);
            if (llllllllllllllIlIIIIlIIlIIIllIIl <= 0) {
                return llllllllllllllIlIIIIlIIlIIlIIIIl;
            }
            llllllllllllllIlIIIIlIIlIIIlllII = llllllllllllllIlIIIIlIIlIIlIIIIl.getName();
        }
        else {
            llllllllllllllIlIIIIlIIlIIIlllII = getTypeName(llllllllllllllIlIIIIlIIlIIIllIlI);
        }
        while (llllllllllllllIlIIIIlIIlIIIllIIl-- > 0) {
            llllllllllllllIlIIIIlIIlIIIlllII = String.valueOf(new StringBuilder().append(llllllllllllllIlIIIIlIIlIIIlllII).append("[]"));
        }
        return this.lookupClass(llllllllllllllIlIIIIlIIlIIIlllII, false);
    }
    
    public CtField lookupFieldByJvmName(final String llllllllllllllIlIIIIlIIlIlIIlIIl, final Symbol llllllllllllllIlIIIIlIIlIlIIlIll) throws CompileError {
        return this.lookupField(jvmToJavaName(llllllllllllllIlIIIIlIIlIlIIlIIl), llllllllllllllIlIIIIlIIlIlIIlIll);
    }
    
    public CtClass lookupClassByJvmName(final String llllllllllllllIlIIIIlIIlIIllIIII) throws CompileError {
        return this.lookupClass(jvmToJavaName(llllllllllllllIlIIIIlIIlIIllIIII), false);
    }
    
    public static int getModifiers(ASTList llllllllllllllIlIIIIlIIIIllIlIll) {
        int llllllllllllllIlIIIIlIIIIllIllII = 0;
        while (llllllllllllllIlIIIIlIIIIllIlIll != null) {
            final Keyword llllllllllllllIlIIIIlIIIIllIlllI = (Keyword)((ASTList)llllllllllllllIlIIIIlIIIIllIlIll).head();
            llllllllllllllIlIIIIlIIIIllIlIll = ((ASTList)llllllllllllllIlIIIIlIIIIllIlIll).tail();
            switch (llllllllllllllIlIIIIlIIIIllIlllI.get()) {
                case 335: {
                    llllllllllllllIlIIIIlIIIIllIllII |= 0x8;
                    continue;
                }
                case 315: {
                    llllllllllllllIlIIIIlIIIIllIllII |= 0x10;
                    continue;
                }
                case 338: {
                    llllllllllllllIlIIIIlIIIIllIllII |= 0x20;
                    continue;
                }
                case 300: {
                    llllllllllllllIlIIIIlIIIIllIllII |= 0x400;
                    continue;
                }
                case 332: {
                    llllllllllllllIlIIIIlIIIIllIllII |= 0x1;
                    continue;
                }
                case 331: {
                    llllllllllllllIlIIIIlIIIIllIllII |= 0x4;
                    continue;
                }
                case 330: {
                    llllllllllllllIlIIIIlIIIIllIllII |= 0x2;
                    continue;
                }
                case 345: {
                    llllllllllllllIlIIIIlIIIIllIllII |= 0x40;
                    continue;
                }
                case 342: {
                    llllllllllllllIlIIIIlIIIIllIllII |= 0x80;
                    continue;
                }
                case 347: {
                    llllllllllllllIlIIIIlIIIIllIllII |= 0x800;
                    continue;
                }
            }
        }
        return llllllllllllllIlIIIIlIIIIllIllII;
    }
    
    public static String jvmToJavaName(final String llllllllllllllIlIIIIlIIIIlllIlIl) {
        return llllllllllllllIlIIIIlIIIIlllIlIl.replace('/', '.');
    }
    
    private int compareSignature(final String llllllllllllllIlIIIIlIIlIlllIlIl, final int[] llllllllllllllIlIIIIlIIlIlllIlII, final int[] llllllllllllllIlIIIIlIIlIlllllII, final String[] llllllllllllllIlIIIIlIIlIllllIll) throws CompileError {
        int llllllllllllllIlIIIIlIIlIllllIlI = 0;
        int llllllllllllllIlIIIIlIIlIllllIIl = 1;
        final int llllllllllllllIlIIIIlIIlIllllIII = llllllllllllllIlIIIIlIIlIlllIlII.length;
        if (llllllllllllllIlIIIIlIIlIllllIII != Descriptor.numOfParameters(llllllllllllllIlIIIIlIIlIlllIlIl)) {
            return -1;
        }
        final int llllllllllllllIlIIIIlIIlIlllIlll = llllllllllllllIlIIIIlIIlIlllIlIl.length();
        int llllllllllllllIlIIIIlIIllIIIIIII = 0;
        while (llllllllllllllIlIIIIlIIlIllllIIl < llllllllllllllIlIIIIlIIlIlllIlll) {
            char llllllllllllllIlIIIIlIIllIIIIIlI = llllllllllllllIlIIIIlIIlIlllIlIl.charAt(llllllllllllllIlIIIIlIIlIllllIIl++);
            if (llllllllllllllIlIIIIlIIllIIIIIlI == ')') {
                return (llllllllllllllIlIIIIlIIllIIIIIII == llllllllllllllIlIIIIlIIlIllllIII) ? llllllllllllllIlIIIIlIIlIllllIlI : -1;
            }
            if (llllllllllllllIlIIIIlIIllIIIIIII >= llllllllllllllIlIIIIlIIlIllllIII) {
                return -1;
            }
            int llllllllllllllIlIIIIlIIllIIIIIIl = 0;
            while (llllllllllllllIlIIIIlIIllIIIIIlI == '[') {
                ++llllllllllllllIlIIIIlIIllIIIIIIl;
                llllllllllllllIlIIIIlIIllIIIIIlI = llllllllllllllIlIIIIlIIlIlllIlIl.charAt(llllllllllllllIlIIIIlIIlIllllIIl++);
            }
            if (llllllllllllllIlIIIIlIIlIlllIlII[llllllllllllllIlIIIIlIIllIIIIIII] == 412) {
                if (llllllllllllllIlIIIIlIIllIIIIIIl == 0 && llllllllllllllIlIIIIlIIllIIIIIlI != 'L') {
                    return -1;
                }
                if (llllllllllllllIlIIIIlIIllIIIIIlI == 'L') {
                    llllllllllllllIlIIIIlIIlIllllIIl = llllllllllllllIlIIIIlIIlIlllIlIl.indexOf(59, llllllllllllllIlIIIIlIIlIllllIIl) + 1;
                }
            }
            else if (llllllllllllllIlIIIIlIIlIlllllII[llllllllllllllIlIIIIlIIllIIIIIII] != llllllllllllllIlIIIIlIIllIIIIIIl) {
                if (llllllllllllllIlIIIIlIIllIIIIIIl != 0 || llllllllllllllIlIIIIlIIllIIIIIlI != 'L' || !llllllllllllllIlIIIIlIIlIlllIlIl.startsWith("java/lang/Object;", llllllllllllllIlIIIIlIIlIllllIIl)) {
                    return -1;
                }
                llllllllllllllIlIIIIlIIlIllllIIl = llllllllllllllIlIIIIlIIlIlllIlIl.indexOf(59, llllllllllllllIlIIIIlIIlIllllIIl) + 1;
                ++llllllllllllllIlIIIIlIIlIllllIlI;
                if (llllllllllllllIlIIIIlIIlIllllIIl <= 0) {
                    return -1;
                }
            }
            else if (llllllllllllllIlIIIIlIIllIIIIIlI == 'L') {
                final int llllllllllllllIlIIIIlIIllIIIIllI = llllllllllllllIlIIIIlIIlIlllIlIl.indexOf(59, llllllllllllllIlIIIIlIIlIllllIIl);
                if (llllllllllllllIlIIIIlIIllIIIIllI < 0 || llllllllllllllIlIIIIlIIlIlllIlII[llllllllllllllIlIIIIlIIllIIIIIII] != 307) {
                    return -1;
                }
                final String llllllllllllllIlIIIIlIIllIIIIlIl = llllllllllllllIlIIIIlIIlIlllIlIl.substring(llllllllllllllIlIIIIlIIlIllllIIl, llllllllllllllIlIIIIlIIllIIIIllI);
                if (!llllllllllllllIlIIIIlIIllIIIIlIl.equals(llllllllllllllIlIIIIlIIlIllllIll[llllllllllllllIlIIIIlIIllIIIIIII])) {
                    final CtClass llllllllllllllIlIIIIlIIllIIIIlll = this.lookupClassByJvmName(llllllllllllllIlIIIIlIIlIllllIll[llllllllllllllIlIIIIlIIllIIIIIII]);
                    try {
                        if (!llllllllllllllIlIIIIlIIllIIIIlll.subtypeOf(this.lookupClassByJvmName(llllllllllllllIlIIIIlIIllIIIIlIl))) {
                            return -1;
                        }
                        ++llllllllllllllIlIIIIlIIlIllllIlI;
                    }
                    catch (NotFoundException llllllllllllllIlIIIIlIIllIIIlIII) {
                        ++llllllllllllllIlIIIIlIIlIllllIlI;
                    }
                }
                llllllllllllllIlIIIIlIIlIllllIIl = llllllllllllllIlIIIIlIIllIIIIllI + 1;
            }
            else {
                final int llllllllllllllIlIIIIlIIllIIIIlII = descToType(llllllllllllllIlIIIIlIIllIIIIIlI);
                final int llllllllllllllIlIIIIlIIllIIIIIll = llllllllllllllIlIIIIlIIlIlllIlII[llllllllllllllIlIIIIlIIllIIIIIII];
                if (llllllllllllllIlIIIIlIIllIIIIlII != llllllllllllllIlIIIIlIIllIIIIIll) {
                    if (llllllllllllllIlIIIIlIIllIIIIlII != 324 || (llllllllllllllIlIIIIlIIllIIIIIll != 334 && llllllllllllllIlIIIIlIIllIIIIIll != 303 && llllllllllllllIlIIIIlIIllIIIIIll != 306)) {
                        return -1;
                    }
                    ++llllllllllllllIlIIIIlIIlIllllIlI;
                }
            }
            ++llllllllllllllIlIIIIlIIllIIIIIII;
        }
        return -1;
    }
    
    private Map<String, String> getInvalidNames() {
        Map<String, String> llllllllllllllIlIIIIlIIIllIIIlll = this.invalidNames;
        if (llllllllllllllIlIIIIlIIIllIIIlll == null) {
            synchronized (MemberResolver.class) {
                final Reference<Map<String, String>> llllllllllllllIlIIIIlIIIllIIlIIl = MemberResolver.invalidNamesMap.get(this.classPool);
                if (llllllllllllllIlIIIIlIIIllIIlIIl != null) {
                    llllllllllllllIlIIIIlIIIllIIIlll = llllllllllllllIlIIIIlIIIllIIlIIl.get();
                }
                if (llllllllllllllIlIIIIlIIIllIIIlll == null) {
                    llllllllllllllIlIIIIlIIIllIIIlll = new Hashtable<String, String>();
                    MemberResolver.invalidNamesMap.put(this.classPool, new WeakReference<Map<String, String>>(llllllllllllllIlIIIIlIIIllIIIlll));
                }
            }
            this.invalidNames = llllllllllllllIlIIIIlIIIllIIIlll;
        }
        return llllllllllllllIlIIIIlIIIllIIIlll;
    }
    
    public ClassPool getClassPool() {
        return this.classPool;
    }
    
    public CtField lookupField(final String llllllllllllllIlIIIIlIIlIlIIIIIl, final Symbol llllllllllllllIlIIIIlIIlIIllllII) throws CompileError {
        final CtClass llllllllllllllIlIIIIlIIlIIllllll = this.lookupClass(llllllllllllllIlIIIIlIIlIlIIIIIl, false);
        try {
            return llllllllllllllIlIIIIlIIlIIllllll.getField(llllllllllllllIlIIIIlIIlIIllllII.get());
        }
        catch (NotFoundException llllllllllllllIlIIIIlIIlIIlllIlI) {
            throw new CompileError(String.valueOf(new StringBuilder().append("no such field: ").append(llllllllllllllIlIIIIlIIlIIllllII.get())));
        }
    }
    
    public MemberResolver(final ClassPool llllllllllllllIlIIIIlIlIIIIIlIll) {
        this.invalidNames = null;
        this.classPool = llllllllllllllIlIIIIlIlIIIIIlIll;
    }
    
    public static CtClass getSuperInterface(final CtClass llllllllllllllIlIIIIlIIIIllllllI, final String llllllllllllllIlIIIIlIIIIlllllll) throws CompileError {
        try {
            final CtClass[] llllllllllllllIlIIIIlIIIlIIIIIIl = llllllllllllllIlIIIIlIIIIllllllI.getInterfaces();
            for (int llllllllllllllIlIIIIlIIIlIIIIIlI = 0; llllllllllllllIlIIIIlIIIlIIIIIlI < llllllllllllllIlIIIIlIIIlIIIIIIl.length; ++llllllllllllllIlIIIIlIIIlIIIIIlI) {
                if (llllllllllllllIlIIIIlIIIlIIIIIIl[llllllllllllllIlIIIIlIIIlIIIIIlI].getName().equals(llllllllllllllIlIIIIlIIIIlllllll)) {
                    return llllllllllllllIlIIIIlIIIlIIIIIIl[llllllllllllllIlIIIIlIIIlIIIIIlI];
                }
            }
        }
        catch (NotFoundException ex) {}
        throw new CompileError(String.valueOf(new StringBuilder().append("cannot find the super interface ").append(llllllllllllllIlIIIIlIIIIlllllll).append(" of ").append(llllllllllllllIlIIIIlIIIIllllllI.getName())));
    }
    
    public CtClass lookupClassByName(final ASTList llllllllllllllIlIIIIlIIlIIllIllI) throws CompileError {
        return this.lookupClass(Declarator.astToClassName(llllllllllllllIlIIIIlIIlIIllIllI, '.'), false);
    }
    
    static String getTypeName(final int llllllllllllllIlIIIIlIIIlllIIlIl) throws CompileError {
        String llllllllllllllIlIIIIlIIIlllIIllI = "";
        switch (llllllllllllllIlIIIIlIIIlllIIlIl) {
            case 301: {
                llllllllllllllIlIIIIlIIIlllIIllI = "boolean";
                break;
            }
            case 306: {
                llllllllllllllIlIIIIlIIIlllIIllI = "char";
                break;
            }
            case 303: {
                llllllllllllllIlIIIIlIIIlllIIllI = "byte";
                break;
            }
            case 334: {
                llllllllllllllIlIIIIlIIIlllIIllI = "short";
                break;
            }
            case 324: {
                llllllllllllllIlIIIIlIIIlllIIllI = "int";
                break;
            }
            case 326: {
                llllllllllllllIlIIIIlIIIlllIIllI = "long";
                break;
            }
            case 317: {
                llllllllllllllIlIIIIlIIIlllIIllI = "float";
                break;
            }
            case 312: {
                llllllllllllllIlIIIIlIIIlllIIllI = "double";
                break;
            }
            case 344: {
                llllllllllllllIlIIIIlIIIlllIIllI = "void";
                break;
            }
            default: {
                fatal();
                break;
            }
        }
        return llllllllllllllIlIIIIlIIIlllIIllI;
    }
    
    public static class Method
    {
        public /* synthetic */ CtClass declaring;
        public /* synthetic */ int notmatch;
        public /* synthetic */ MethodInfo info;
        
        public Method(final CtClass lllllllllllllIlIlIIlIIIllIlIIIIl, final MethodInfo lllllllllllllIlIlIIlIIIllIIlllII, final int lllllllllllllIlIlIIlIIIllIIlllll) {
            this.declaring = lllllllllllllIlIlIIlIIIllIlIIIIl;
            this.info = lllllllllllllIlIlIIlIIIllIIlllII;
            this.notmatch = lllllllllllllIlIlIIlIIIllIIlllll;
        }
        
        public boolean isStatic() {
            final int lllllllllllllIlIlIIlIIIllIIlIlIl = this.info.getAccessFlags();
            return (lllllllllllllIlIlIIlIIIllIIlIlIl & 0x8) != 0x0;
        }
    }
}
