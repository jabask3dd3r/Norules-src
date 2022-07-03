package com.viaversion.viaversion.libs.javassist.tools;

import com.viaversion.viaversion.libs.javassist.bytecode.analysis.*;
import com.viaversion.viaversion.libs.javassist.*;

public class framedump
{
    private framedump() {
    }
    
    public static void main(final String[] lllllllllllllIlIIllIIIlIlllIllll) throws Exception {
        if (lllllllllllllIlIIllIIIlIlllIllll.length != 1) {
            System.err.println("Usage: java javassist.tools.framedump <fully-qualified class name>");
            return;
        }
        final ClassPool lllllllllllllIlIIllIIIlIllllIIIl = ClassPool.getDefault();
        final CtClass lllllllllllllIlIIllIIIlIllllIIII = lllllllllllllIlIIllIIIlIllllIIIl.get(lllllllllllllIlIIllIIIlIlllIllll[0]);
        System.out.println(String.valueOf(new StringBuilder().append("Frame Dump of ").append(lllllllllllllIlIIllIIIlIllllIIII.getName()).append(":")));
        FramePrinter.print(lllllllllllllIlIIllIIIlIllllIIII, System.out);
    }
}
