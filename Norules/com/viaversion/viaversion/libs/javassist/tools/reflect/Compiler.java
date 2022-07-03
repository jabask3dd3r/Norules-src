package com.viaversion.viaversion.libs.javassist.tools.reflect;

import com.viaversion.viaversion.libs.javassist.*;
import java.io.*;

public class Compiler
{
    private static void processClasses(final CompiledClass[] lllllllllllllllIIlIIIlllllIIlIIl, final int lllllllllllllllIIlIIIlllllIIIlII) throws Exception {
        final Reflection lllllllllllllllIIlIIIlllllIIIlll = new Reflection();
        final ClassPool lllllllllllllllIIlIIIlllllIIIllI = ClassPool.getDefault();
        lllllllllllllllIIlIIIlllllIIIlll.start(lllllllllllllllIIlIIIlllllIIIllI);
        for (int lllllllllllllllIIlIIIlllllIIlIll = 0; lllllllllllllllIIlIIIlllllIIlIll < lllllllllllllllIIlIIIlllllIIIlII; ++lllllllllllllllIIlIIIlllllIIlIll) {
            final CtClass lllllllllllllllIIlIIIlllllIIllII = lllllllllllllllIIlIIIlllllIIIllI.get(lllllllllllllllIIlIIIlllllIIlIIl[lllllllllllllllIIlIIIlllllIIlIll].classname);
            if (lllllllllllllllIIlIIIlllllIIlIIl[lllllllllllllllIIlIIIlllllIIlIll].metaobject != null || lllllllllllllllIIlIIIlllllIIlIIl[lllllllllllllllIIlIIIlllllIIlIll].classobject != null) {
                String lllllllllllllllIIlIIIlllllIIlllI = null;
                if (lllllllllllllllIIlIIIlllllIIlIIl[lllllllllllllllIIlIIIlllllIIlIll].metaobject == null) {
                    final String lllllllllllllllIIlIIIlllllIlIIII = "com.viaversion.viaversion.libs.javassist.tools.reflect.Metaobject";
                }
                else {
                    lllllllllllllllIIlIIIlllllIIlllI = lllllllllllllllIIlIIIlllllIIlIIl[lllllllllllllllIIlIIIlllllIIlIll].metaobject;
                }
                String lllllllllllllllIIlIIIlllllIIllIl = null;
                if (lllllllllllllllIIlIIIlllllIIlIIl[lllllllllllllllIIlIIIlllllIIlIll].classobject == null) {
                    final String lllllllllllllllIIlIIIlllllIIllll = "com.viaversion.viaversion.libs.javassist.tools.reflect.ClassMetaobject";
                }
                else {
                    lllllllllllllllIIlIIIlllllIIllIl = lllllllllllllllIIlIIIlllllIIlIIl[lllllllllllllllIIlIIIlllllIIlIll].classobject;
                }
                if (!lllllllllllllllIIlIIIlllllIIIlll.makeReflective(lllllllllllllllIIlIIIlllllIIllII, lllllllllllllllIIlIIIlllllIIIllI.get(lllllllllllllllIIlIIIlllllIIlllI), lllllllllllllllIIlIIIlllllIIIllI.get(lllllllllllllllIIlIIIlllllIIllIl))) {
                    System.err.println(String.valueOf(new StringBuilder().append("Warning: ").append(lllllllllllllllIIlIIIlllllIIllII.getName()).append(" is reflective.  It was not changed.")));
                }
                System.err.println(String.valueOf(new StringBuilder().append(lllllllllllllllIIlIIIlllllIIllII.getName()).append(": ").append(lllllllllllllllIIlIIIlllllIIlllI).append(", ").append(lllllllllllllllIIlIIIlllllIIllIl)));
            }
            else {
                System.err.println(String.valueOf(new StringBuilder().append(lllllllllllllllIIlIIIlllllIIllII.getName()).append(": not reflective")));
            }
        }
        for (int lllllllllllllllIIlIIIlllllIIlIlI = 0; lllllllllllllllIIlIIIlllllIIlIlI < lllllllllllllllIIlIIIlllllIIIlII; ++lllllllllllllllIIlIIIlllllIIlIlI) {
            lllllllllllllllIIlIIIlllllIIIlll.onLoad(lllllllllllllllIIlIIIlllllIIIllI, lllllllllllllllIIlIIIlllllIIlIIl[lllllllllllllllIIlIIIlllllIIlIlI].classname);
            lllllllllllllllIIlIIIlllllIIIllI.get(lllllllllllllllIIlIIIlllllIIlIIl[lllllllllllllllIIlIIIlllllIIlIlI].classname).writeFile();
        }
    }
    
    private static void help(final PrintStream lllllllllllllllIIlIIIllllIlIlIIl) {
        lllllllllllllllIIlIIIllllIlIlIIl.println("Usage: java javassist.tools.reflect.Compiler");
        lllllllllllllllIIlIIIllllIlIlIIl.println("            (<class> [-m <metaobject>] [-c <class metaobject>])+");
    }
    
    public static void main(final String[] lllllllllllllllIIlIIIlllllIllIll) throws Exception {
        if (lllllllllllllllIIlIIIlllllIllIll.length == 0) {
            help(System.err);
            return;
        }
        final CompiledClass[] lllllllllllllllIIlIIIlllllIlllIl = new CompiledClass[lllllllllllllllIIlIIIlllllIllIll.length];
        final int lllllllllllllllIIlIIIlllllIlllII = parse(lllllllllllllllIIlIIIlllllIllIll, lllllllllllllllIIlIIIlllllIlllIl);
        if (lllllllllllllllIIlIIIlllllIlllII < 1) {
            System.err.println("bad parameter.");
            return;
        }
        processClasses(lllllllllllllllIIlIIIlllllIlllIl, lllllllllllllllIIlIIIlllllIlllII);
    }
    
    private static int parse(final String[] lllllllllllllllIIlIIIllllIllIIIl, final CompiledClass[] lllllllllllllllIIlIIIllllIllIIll) {
        int lllllllllllllllIIlIIIllllIllIIlI = -1;
        for (int lllllllllllllllIIlIIIllllIllIlIl = 0; lllllllllllllllIIlIIIllllIllIlIl < lllllllllllllllIIlIIIllllIllIIIl.length; ++lllllllllllllllIIlIIIllllIllIlIl) {
            final String lllllllllllllllIIlIIIllllIllIllI = lllllllllllllllIIlIIIllllIllIIIl[lllllllllllllllIIlIIIllllIllIlIl];
            if (lllllllllllllllIIlIIIllllIllIllI.equals("-m")) {
                if (lllllllllllllllIIlIIIllllIllIIlI < 0 || lllllllllllllllIIlIIIllllIllIlIl + 1 > lllllllllllllllIIlIIIllllIllIIIl.length) {
                    return -1;
                }
                lllllllllllllllIIlIIIllllIllIIll[lllllllllllllllIIlIIIllllIllIIlI].metaobject = lllllllllllllllIIlIIIllllIllIIIl[++lllllllllllllllIIlIIIllllIllIlIl];
            }
            else if (lllllllllllllllIIlIIIllllIllIllI.equals("-c")) {
                if (lllllllllllllllIIlIIIllllIllIIlI < 0 || lllllllllllllllIIlIIIllllIllIlIl + 1 > lllllllllllllllIIlIIIllllIllIIIl.length) {
                    return -1;
                }
                lllllllllllllllIIlIIIllllIllIIll[lllllllllllllllIIlIIIllllIllIIlI].classobject = lllllllllllllllIIlIIIllllIllIIIl[++lllllllllllllllIIlIIIllllIllIlIl];
            }
            else {
                if (lllllllllllllllIIlIIIllllIllIllI.charAt(0) == '-') {
                    return -1;
                }
                final CompiledClass lllllllllllllllIIlIIIllllIllIlll = new CompiledClass();
                lllllllllllllllIIlIIIllllIllIlll.classname = lllllllllllllllIIlIIIllllIllIllI;
                lllllllllllllllIIlIIIllllIllIlll.metaobject = null;
                lllllllllllllllIIlIIIllllIllIlll.classobject = null;
                lllllllllllllllIIlIIIllllIllIIll[++lllllllllllllllIIlIIIllllIllIIlI] = lllllllllllllllIIlIIIllllIllIlll;
            }
        }
        return lllllllllllllllIIlIIIllllIllIIlI + 1;
    }
}
