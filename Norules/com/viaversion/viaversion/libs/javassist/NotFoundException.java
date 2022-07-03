package com.viaversion.viaversion.libs.javassist;

public class NotFoundException extends Exception
{
    public NotFoundException(final String lllllllllllllIIllIlllllIlIIIlIII, final Exception lllllllllllllIIllIlllllIlIIIIlll) {
        super(String.valueOf(new StringBuilder().append(lllllllllllllIIllIlllllIlIIIlIII).append(" because of ").append(lllllllllllllIIllIlllllIlIIIIlll.toString())));
    }
    
    public NotFoundException(final String lllllllllllllIIllIlllllIlIIlIIII) {
        super(lllllllllllllIIllIlllllIlIIlIIII);
    }
}
