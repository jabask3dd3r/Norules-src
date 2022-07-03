package com.viaversion.viaversion.libs.javassist;

import java.net.*;
import java.io.*;

public class ByteArrayClassPath implements ClassPath
{
    protected /* synthetic */ byte[] classfile;
    protected /* synthetic */ String classname;
    
    public ByteArrayClassPath(final String lllllllllllllllIlllllIIIIIIlIIlI, final byte[] lllllllllllllllIlllllIIIIIIlIIIl) {
        this.classname = lllllllllllllllIlllllIIIIIIlIIlI;
        this.classfile = lllllllllllllllIlllllIIIIIIlIIIl;
    }
    
    @Override
    public InputStream openClassfile(final String lllllllllllllllIlllllIIIIIIIIlll) {
        if (this.classname.equals(lllllllllllllllIlllllIIIIIIIIlll)) {
            return new ByteArrayInputStream(this.classfile);
        }
        return null;
    }
    
    @Override
    public URL find(final String lllllllllllllllIllllIllllllllllI) {
        if (this.classname.equals(lllllllllllllllIllllIllllllllllI)) {
            final String lllllllllllllllIlllllIIIIIIIIIII = String.valueOf(new StringBuilder().append(lllllllllllllllIllllIllllllllllI.replace('.', '/')).append(".class"));
            try {
                return new URL(null, String.valueOf(new StringBuilder().append("file:/ByteArrayClassPath/").append(lllllllllllllllIlllllIIIIIIIIIII)), new BytecodeURLStreamHandler());
            }
            catch (MalformedURLException ex) {}
        }
        return null;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append("byte[]:").append(this.classname));
    }
    
    private class BytecodeURLStreamHandler extends URLStreamHandler
    {
        @Override
        protected URLConnection openConnection(final URL llllllllllllllllIllIIllIllllIIIl) {
            return new BytecodeURLConnection(llllllllllllllllIllIIllIllllIIIl);
        }
    }
    
    private class BytecodeURLConnection extends URLConnection
    {
        @Override
        public void connect() throws IOException {
        }
        
        protected BytecodeURLConnection(final URL lllllllllllllIIIlIlIlIIIIIlIIlII) {
            super(lllllllllllllIIIlIlIlIIIIIlIIlII);
        }
        
        @Override
        public InputStream getInputStream() throws IOException {
            return new ByteArrayInputStream(ByteArrayClassPath.this.classfile);
        }
        
        @Override
        public int getContentLength() {
            return ByteArrayClassPath.this.classfile.length;
        }
    }
}
