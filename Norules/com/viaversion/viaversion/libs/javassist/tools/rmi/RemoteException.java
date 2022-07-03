package com.viaversion.viaversion.libs.javassist.tools.rmi;

public class RemoteException extends RuntimeException
{
    public RemoteException(final String lllllllllllllllIIIIIllllllIlIlll) {
        super(lllllllllllllllIIIIIllllllIlIlll);
    }
    
    public RemoteException(final Exception lllllllllllllllIIIIIllllllIlIIll) {
        super(String.valueOf(new StringBuilder().append("by ").append(lllllllllllllllIIIIIllllllIlIIll.toString())));
    }
}
