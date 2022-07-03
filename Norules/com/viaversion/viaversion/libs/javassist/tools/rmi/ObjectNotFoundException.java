package com.viaversion.viaversion.libs.javassist.tools.rmi;

public class ObjectNotFoundException extends Exception
{
    public ObjectNotFoundException(final String lIlIlllIIlIII, final Exception lIlIlllIIIlII) {
        super(String.valueOf(new StringBuilder().append(lIlIlllIIlIII).append(" because of ").append(lIlIlllIIIlII.toString())));
    }
    
    public ObjectNotFoundException(final String lIlIlllIIllll) {
        super(String.valueOf(new StringBuilder().append(lIlIlllIIllll).append(" is not exported")));
    }
}
