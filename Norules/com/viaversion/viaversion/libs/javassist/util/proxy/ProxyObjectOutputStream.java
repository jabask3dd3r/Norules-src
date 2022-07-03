package com.viaversion.viaversion.libs.javassist.util.proxy;

import java.io.*;

public class ProxyObjectOutputStream extends ObjectOutputStream
{
    @Override
    protected void writeClassDescriptor(final ObjectStreamClass lllllllllllllIIlIlIlllllllllIlII) throws IOException {
        final Class<?> lllllllllllllIIlIlIlllllllllIllI = lllllllllllllIIlIlIlllllllllIlII.forClass();
        if (ProxyFactory.isProxyClass(lllllllllllllIIlIlIlllllllllIllI)) {
            this.writeBoolean(true);
            final Class<?> lllllllllllllIIlIlIlllllllllllII = lllllllllllllIIlIlIlllllllllIllI.getSuperclass();
            final Class<?>[] lllllllllllllIIlIlIllllllllllIll = lllllllllllllIIlIlIlllllllllIllI.getInterfaces();
            final byte[] lllllllllllllIIlIlIllllllllllIlI = ProxyFactory.getFilterSignature(lllllllllllllIIlIlIlllllllllIllI);
            String lllllllllllllIIlIlIllllllllllIIl = lllllllllllllIIlIlIlllllllllllII.getName();
            this.writeObject(lllllllllllllIIlIlIllllllllllIIl);
            this.writeInt(lllllllllllllIIlIlIllllllllllIll.length - 1);
            for (int lllllllllllllIIlIlIlllllllllllIl = 0; lllllllllllllIIlIlIlllllllllllIl < lllllllllllllIIlIlIllllllllllIll.length; ++lllllllllllllIIlIlIlllllllllllIl) {
                final Class<?> lllllllllllllIIlIlIllllllllllllI = lllllllllllllIIlIlIllllllllllIll[lllllllllllllIIlIlIlllllllllllIl];
                if (lllllllllllllIIlIlIllllllllllllI != ProxyObject.class && lllllllllllllIIlIlIllllllllllllI != Proxy.class) {
                    lllllllllllllIIlIlIllllllllllIIl = lllllllllllllIIlIlIllllllllllIll[lllllllllllllIIlIlIlllllllllllIl].getName();
                    this.writeObject(lllllllllllllIIlIlIllllllllllIIl);
                }
            }
            this.writeInt(lllllllllllllIIlIlIllllllllllIlI.length);
            this.write(lllllllllllllIIlIlIllllllllllIlI);
        }
        else {
            this.writeBoolean(false);
            super.writeClassDescriptor(lllllllllllllIIlIlIlllllllllIlII);
        }
    }
    
    public ProxyObjectOutputStream(final OutputStream lllllllllllllIIlIllIIIIIIIIIlIII) throws IOException {
        super(lllllllllllllIIlIllIIIIIIIIIlIII);
    }
}
