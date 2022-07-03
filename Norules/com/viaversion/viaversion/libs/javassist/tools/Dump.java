package com.viaversion.viaversion.libs.javassist.tools;

import java.io.*;
import com.viaversion.viaversion.libs.javassist.bytecode.*;

public class Dump
{
    public static void main(final String[] lllllllllllllIIlIIlllIllllIIllIl) throws Exception {
        if (lllllllllllllIIlIIlllIllllIIllIl.length != 1) {
            System.err.println("Usage: java Dump <class file name>");
            return;
        }
        final DataInputStream lllllllllllllIIlIIlllIllllIlIIII = new DataInputStream(new FileInputStream(lllllllllllllIIlIIlllIllllIIllIl[0]));
        final ClassFile lllllllllllllIIlIIlllIllllIIllll = new ClassFile(lllllllllllllIIlIIlllIllllIlIIII);
        final PrintWriter lllllllllllllIIlIIlllIllllIIlllI = new PrintWriter(System.out, true);
        lllllllllllllIIlIIlllIllllIIlllI.println("*** constant pool ***");
        lllllllllllllIIlIIlllIllllIIllll.getConstPool().print(lllllllllllllIIlIIlllIllllIIlllI);
        lllllllllllllIIlIIlllIllllIIlllI.println();
        lllllllllllllIIlIIlllIllllIIlllI.println("*** members ***");
        ClassFilePrinter.print(lllllllllllllIIlIIlllIllllIIllll, lllllllllllllIIlIIlllIllllIIlllI);
    }
    
    private Dump() {
    }
}
