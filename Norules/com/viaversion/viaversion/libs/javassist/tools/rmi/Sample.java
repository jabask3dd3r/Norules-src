package com.viaversion.viaversion.libs.javassist.tools.rmi;

public class Sample
{
    private /* synthetic */ int objectId;
    private /* synthetic */ ObjectImporter importer;
    
    public Object forward(final Object[] lllllllllllllIlIllIlllIlIIlIlIII, final int lllllllllllllIlIllIlllIlIIlIIlII) {
        return this.importer.call(this.objectId, lllllllllllllIlIllIlllIlIIlIIlII, lllllllllllllIlIllIlllIlIIlIlIII);
    }
    
    public static Object forwardStatic(final Object[] lllllllllllllIlIllIlllIlIIlIIIll, final int lllllllllllllIlIllIlllIlIIlIIIlI) throws RemoteException {
        throw new RemoteException("cannot call a static method.");
    }
}
