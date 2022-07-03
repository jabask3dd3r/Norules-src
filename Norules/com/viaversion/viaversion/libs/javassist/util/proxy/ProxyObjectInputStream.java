package com.viaversion.viaversion.libs.javassist.util.proxy;

import java.io.*;

public class ProxyObjectInputStream extends ObjectInputStream
{
    private /* synthetic */ ClassLoader loader;
    
    @Override
    protected ObjectStreamClass readClassDescriptor() throws IOException, ClassNotFoundException {
        final boolean llllllllllllllIIlllIIlIlIlIlIlIl = this.readBoolean();
        if (llllllllllllllIIlllIIlIlIlIlIlIl) {
            String llllllllllllllIIlllIIlIlIlIlllIl = (String)this.readObject();
            final Class<?> llllllllllllllIIlllIIlIlIlIlllII = this.loader.loadClass(llllllllllllllIIlllIIlIlIlIlllIl);
            int llllllllllllllIIlllIIlIlIlIllIll = this.readInt();
            final Class<?>[] llllllllllllllIIlllIIlIlIlIllIlI = (Class<?>[])new Class[llllllllllllllIIlllIIlIlIlIllIll];
            for (int llllllllllllllIIlllIIlIlIlIllllI = 0; llllllllllllllIIlllIIlIlIlIllllI < llllllllllllllIIlllIIlIlIlIllIll; ++llllllllllllllIIlllIIlIlIlIllllI) {
                llllllllllllllIIlllIIlIlIlIlllIl = (String)this.readObject();
                llllllllllllllIIlllIIlIlIlIllIlI[llllllllllllllIIlllIIlIlIlIllllI] = this.loader.loadClass(llllllllllllllIIlllIIlIlIlIlllIl);
            }
            llllllllllllllIIlllIIlIlIlIllIll = this.readInt();
            final byte[] llllllllllllllIIlllIIlIlIlIllIIl = new byte[llllllllllllllIIlllIIlIlIlIllIll];
            this.read(llllllllllllllIIlllIIlIlIlIllIIl);
            final ProxyFactory llllllllllllllIIlllIIlIlIlIllIII = new ProxyFactory();
            llllllllllllllIIlllIIlIlIlIllIII.setUseCache(true);
            llllllllllllllIIlllIIlIlIlIllIII.setUseWriteReplace(false);
            llllllllllllllIIlllIIlIlIlIllIII.setSuperclass(llllllllllllllIIlllIIlIlIlIlllII);
            llllllllllllllIIlllIIlIlIlIllIII.setInterfaces(llllllllllllllIIlllIIlIlIlIllIlI);
            final Class<?> llllllllllllllIIlllIIlIlIlIlIlll = llllllllllllllIIlllIIlIlIlIllIII.createClass(llllllllllllllIIlllIIlIlIlIllIIl);
            return ObjectStreamClass.lookup(llllllllllllllIIlllIIlIlIlIlIlll);
        }
        return super.readClassDescriptor();
    }
    
    public void setClassLoader(ClassLoader llllllllllllllIIlllIIlIlIllIlIII) {
        if (llllllllllllllIIlllIIlIlIllIlIII != null) {
            this.loader = llllllllllllllIIlllIIlIlIllIlIII;
        }
        else {
            llllllllllllllIIlllIIlIlIllIlIII = ClassLoader.getSystemClassLoader();
        }
    }
    
    public ProxyObjectInputStream(final InputStream llllllllllllllIIlllIIlIlIllIlllI) throws IOException {
        super(llllllllllllllIIlllIIlIlIllIlllI);
        this.loader = Thread.currentThread().getContextClassLoader();
        if (this.loader == null) {
            this.loader = ClassLoader.getSystemClassLoader();
        }
    }
}
