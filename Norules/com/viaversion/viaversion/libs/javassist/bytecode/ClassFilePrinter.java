package com.viaversion.viaversion.libs.javassist.bytecode;

import com.viaversion.viaversion.libs.javassist.*;
import java.util.*;
import java.io.*;

public class ClassFilePrinter
{
    public static void print(final ClassFile lllllllllllllIIIlIlIlllllIIlIlll, final PrintWriter lllllllllllllIIIlIlIlllllIIlIllI) {
        final int lllllllllllllIIIlIlIlllllIIllIll = AccessFlag.toModifier(lllllllllllllIIIlIlIlllllIIlIlll.getAccessFlags() & 0xFFFFFFDF);
        lllllllllllllIIIlIlIlllllIIlIllI.println(String.valueOf(new StringBuilder().append("major: ").append(lllllllllllllIIIlIlIlllllIIlIlll.major).append(", minor: ").append(lllllllllllllIIIlIlIlllllIIlIlll.minor).append(" modifiers: ").append(Integer.toHexString(lllllllllllllIIIlIlIlllllIIlIlll.getAccessFlags()))));
        lllllllllllllIIIlIlIlllllIIlIllI.println(String.valueOf(new StringBuilder().append(Modifier.toString(lllllllllllllIIIlIlIlllllIIllIll)).append(" class ").append(lllllllllllllIIIlIlIlllllIIlIlll.getName()).append(" extends ").append(lllllllllllllIIIlIlIlllllIIlIlll.getSuperclass())));
        final String[] lllllllllllllIIIlIlIlllllIIllIlI = lllllllllllllIIIlIlIlllllIIlIlll.getInterfaces();
        if (lllllllllllllIIIlIlIlllllIIllIlI != null && lllllllllllllIIIlIlIlllllIIllIlI.length > 0) {
            lllllllllllllIIIlIlIlllllIIlIllI.print("    implements ");
            lllllllllllllIIIlIlIlllllIIlIllI.print(lllllllllllllIIIlIlIlllllIIllIlI[0]);
            for (int lllllllllllllIIIlIlIlllllIlIIIlI = 1; lllllllllllllIIIlIlIlllllIlIIIlI < lllllllllllllIIIlIlIlllllIIllIlI.length; ++lllllllllllllIIIlIlIlllllIlIIIlI) {
                lllllllllllllIIIlIlIlllllIIlIllI.print(String.valueOf(new StringBuilder().append(", ").append(lllllllllllllIIIlIlIlllllIIllIlI[lllllllllllllIIIlIlIlllllIlIIIlI])));
            }
            lllllllllllllIIIlIlIlllllIIlIllI.println();
        }
        lllllllllllllIIIlIlIlllllIIlIllI.println();
        final List<FieldInfo> lllllllllllllIIIlIlIlllllIIllIIl = lllllllllllllIIIlIlIlllllIIlIlll.getFields();
        for (final FieldInfo lllllllllllllIIIlIlIlllllIlIIIII : lllllllllllllIIIlIlIlllllIIllIIl) {
            final int lllllllllllllIIIlIlIlllllIlIIIIl = lllllllllllllIIIlIlIlllllIlIIIII.getAccessFlags();
            lllllllllllllIIIlIlIlllllIIlIllI.println(String.valueOf(new StringBuilder().append(Modifier.toString(AccessFlag.toModifier(lllllllllllllIIIlIlIlllllIlIIIIl))).append(" ").append(lllllllllllllIIIlIlIlllllIlIIIII.getName()).append("\t").append(lllllllllllllIIIlIlIlllllIlIIIII.getDescriptor())));
            printAttributes(lllllllllllllIIIlIlIlllllIlIIIII.getAttributes(), lllllllllllllIIIlIlIlllllIIlIllI, 'f');
        }
        lllllllllllllIIIlIlIlllllIIlIllI.println();
        final List<MethodInfo> lllllllllllllIIIlIlIlllllIIllIII = lllllllllllllIIIlIlIlllllIIlIlll.getMethods();
        for (final MethodInfo lllllllllllllIIIlIlIlllllIIllllI : lllllllllllllIIIlIlIlllllIIllIII) {
            final int lllllllllllllIIIlIlIlllllIIlllll = lllllllllllllIIIlIlIlllllIIllllI.getAccessFlags();
            lllllllllllllIIIlIlIlllllIIlIllI.println(String.valueOf(new StringBuilder().append(Modifier.toString(AccessFlag.toModifier(lllllllllllllIIIlIlIlllllIIlllll))).append(" ").append(lllllllllllllIIIlIlIlllllIIllllI.getName()).append("\t").append(lllllllllllllIIIlIlIlllllIIllllI.getDescriptor())));
            printAttributes(lllllllllllllIIIlIlIlllllIIllllI.getAttributes(), lllllllllllllIIIlIlIlllllIIlIllI, 'm');
            lllllllllllllIIIlIlIlllllIIlIllI.println();
        }
        lllllllllllllIIIlIlIlllllIIlIllI.println();
        printAttributes(lllllllllllllIIIlIlIlllllIIlIlll.getAttributes(), lllllllllllllIIIlIlIlllllIIlIllI, 'c');
    }
    
    public static void print(final ClassFile lllllllllllllIIIlIlIlllllIlIllII) {
        print(lllllllllllllIIIlIlIlllllIlIllII, new PrintWriter(System.out, true));
    }
    
    static void printAttributes(final List<AttributeInfo> lllllllllllllIIIlIlIllllIllllllI, final PrintWriter lllllllllllllIIIlIlIllllIlllllIl, final char lllllllllllllIIIlIlIllllIllllIIl) {
        if (lllllllllllllIIIlIlIllllIllllllI == null) {
            return;
        }
        for (final AttributeInfo lllllllllllllIIIlIlIllllIlllllll : lllllllllllllIIIlIlIllllIllllllI) {
            if (lllllllllllllIIIlIlIllllIlllllll instanceof CodeAttribute) {
                final CodeAttribute lllllllllllllIIIlIlIlllllIIIIllI = (CodeAttribute)lllllllllllllIIIlIlIllllIlllllll;
                lllllllllllllIIIlIlIllllIlllllIl.println(String.valueOf(new StringBuilder().append("attribute: ").append(lllllllllllllIIIlIlIllllIlllllll.getName()).append(": ").append(lllllllllllllIIIlIlIllllIlllllll.getClass().getName())));
                lllllllllllllIIIlIlIllllIlllllIl.println(String.valueOf(new StringBuilder().append("max stack ").append(lllllllllllllIIIlIlIlllllIIIIllI.getMaxStack()).append(", max locals ").append(lllllllllllllIIIlIlIlllllIIIIllI.getMaxLocals()).append(", ").append(lllllllllllllIIIlIlIlllllIIIIllI.getExceptionTable().size()).append(" catch blocks")));
                lllllllllllllIIIlIlIllllIlllllIl.println("<code attribute begin>");
                printAttributes(lllllllllllllIIIlIlIlllllIIIIllI.getAttributes(), lllllllllllllIIIlIlIllllIlllllIl, lllllllllllllIIIlIlIllllIllllIIl);
                lllllllllllllIIIlIlIllllIlllllIl.println("<code attribute end>");
            }
            else if (lllllllllllllIIIlIlIllllIlllllll instanceof AnnotationsAttribute) {
                lllllllllllllIIIlIlIllllIlllllIl.println(String.valueOf(new StringBuilder().append("annnotation: ").append(lllllllllllllIIIlIlIllllIlllllll.toString())));
            }
            else if (lllllllllllllIIIlIlIllllIlllllll instanceof ParameterAnnotationsAttribute) {
                lllllllllllllIIIlIlIllllIlllllIl.println(String.valueOf(new StringBuilder().append("parameter annnotations: ").append(lllllllllllllIIIlIlIllllIlllllll.toString())));
            }
            else if (lllllllllllllIIIlIlIllllIlllllll instanceof StackMapTable) {
                lllllllllllllIIIlIlIllllIlllllIl.println("<stack map table begin>");
                StackMapTable.Printer.print((StackMapTable)lllllllllllllIIIlIlIllllIlllllll, lllllllllllllIIIlIlIllllIlllllIl);
                lllllllllllllIIIlIlIllllIlllllIl.println("<stack map table end>");
            }
            else if (lllllllllllllIIIlIlIllllIlllllll instanceof StackMap) {
                lllllllllllllIIIlIlIllllIlllllIl.println("<stack map begin>");
                ((StackMap)lllllllllllllIIIlIlIllllIlllllll).print(lllllllllllllIIIlIlIllllIlllllIl);
                lllllllllllllIIIlIlIllllIlllllIl.println("<stack map end>");
            }
            else if (lllllllllllllIIIlIlIllllIlllllll instanceof SignatureAttribute) {
                final SignatureAttribute lllllllllllllIIIlIlIlllllIIIIIIl = (SignatureAttribute)lllllllllllllIIIlIlIllllIlllllll;
                final String lllllllllllllIIIlIlIlllllIIIIIII = lllllllllllllIIIlIlIlllllIIIIIIl.getSignature();
                lllllllllllllIIIlIlIllllIlllllIl.println(String.valueOf(new StringBuilder().append("signature: ").append(lllllllllllllIIIlIlIlllllIIIIIII)));
                try {
                    String lllllllllllllIIIlIlIlllllIIIIIll = null;
                    if (lllllllllllllIIIlIlIllllIllllIIl == 'c') {
                        final String lllllllllllllIIIlIlIlllllIIIIlIl = SignatureAttribute.toClassSignature(lllllllllllllIIIlIlIlllllIIIIIII).toString();
                    }
                    else if (lllllllllllllIIIlIlIllllIllllIIl == 'm') {
                        final String lllllllllllllIIIlIlIlllllIIIIlII = SignatureAttribute.toMethodSignature(lllllllllllllIIIlIlIlllllIIIIIII).toString();
                    }
                    else {
                        lllllllllllllIIIlIlIlllllIIIIIll = SignatureAttribute.toFieldSignature(lllllllllllllIIIlIlIlllllIIIIIII).toString();
                    }
                    lllllllllllllIIIlIlIllllIlllllIl.println(String.valueOf(new StringBuilder().append("           ").append(lllllllllllllIIIlIlIlllllIIIIIll)));
                }
                catch (BadBytecode lllllllllllllIIIlIlIlllllIIIIIlI) {
                    lllllllllllllIIIlIlIllllIlllllIl.println("           syntax error");
                }
            }
            else {
                lllllllllllllIIIlIlIllllIlllllIl.println(String.valueOf(new StringBuilder().append("attribute: ").append(lllllllllllllIIIlIlIllllIlllllll.getName()).append(" (").append(lllllllllllllIIIlIlIllllIlllllll.get().length).append(" byte): ").append(lllllllllllllIIIlIlIllllIlllllll.getClass().getName())));
            }
        }
    }
}
