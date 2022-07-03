package com.viaversion.viaversion.libs.javassist.bytecode;

public class BadBytecode extends Exception
{
    public BadBytecode(final String lllllllllllllIIlllIllIIlIIlIIIIl) {
        super(lllllllllllllIIlllIllIIlIIlIIIIl);
    }
    
    public BadBytecode(final MethodInfo lllllllllllllIIlllIllIIlIIIlIIll, final Throwable lllllllllllllIIlllIllIIlIIIIllll) {
        super(String.valueOf(new StringBuilder().append(lllllllllllllIIlllIllIIlIIIlIIll.toString()).append(" in ").append(lllllllllllllIIlllIllIIlIIIlIIll.getConstPool().getClassName()).append(": ").append(lllllllllllllIIlllIllIIlIIIIllll.getMessage())), lllllllllllllIIlllIllIIlIIIIllll);
    }
    
    public BadBytecode(final int lllllllllllllIIlllIllIIlIIlIIlll) {
        super(String.valueOf(new StringBuilder().append("bytecode ").append(lllllllllllllIIlllIllIIlIIlIIlll)));
    }
    
    public BadBytecode(final String lllllllllllllIIlllIllIIlIIIllIIl, final Throwable lllllllllllllIIlllIllIIlIIIllIII) {
        super(lllllllllllllIIlllIllIIlIIIllIIl, lllllllllllllIIlllIllIIlIIIllIII);
    }
}
