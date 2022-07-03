package com.viaversion.viaversion.libs.javassist.tools.rmi;

import java.io.*;

public class RemoteRef implements Serializable
{
    public /* synthetic */ String classname;
    public /* synthetic */ int oid;
    
    public RemoteRef(final int llIlIllIIIllIII) {
        this.oid = llIlIllIIIllIII;
        this.classname = null;
    }
    
    public RemoteRef(final int llIlIllIIIlIIll, final String llIlIllIIIlIIlI) {
        this.oid = llIlIllIIIlIIll;
        this.classname = llIlIllIIIlIIlI;
    }
}
