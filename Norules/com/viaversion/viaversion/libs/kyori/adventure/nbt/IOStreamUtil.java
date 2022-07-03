package com.viaversion.viaversion.libs.kyori.adventure.nbt;

import java.io.*;

final class IOStreamUtil
{
    private IOStreamUtil() {
    }
    
    static OutputStream closeShield(final OutputStream lllllllllllllllIlIllIIIIIllIIlII) {
        return new OutputStream() {
            @Override
            public void write(final byte[] lllllllllllllIllllIllIIIIIlIIllI) throws IOException {
                lllllllllllllllIlIllIIIIIllIIlII.write(lllllllllllllIllllIllIIIIIlIIllI);
            }
            
            @Override
            public void write(final byte[] lllllllllllllIllllIllIIIIIIlllII, final int lllllllllllllIllllIllIIIIIIlllIl, final int lllllllllllllIllllIllIIIIIIllIll) throws IOException {
                lllllllllllllllIlIllIIIIIllIIlII.write(lllllllllllllIllllIllIIIIIIlllII, lllllllllllllIllllIllIIIIIIlllIl, lllllllllllllIllllIllIIIIIIllIll);
            }
            
            @Override
            public void write(final int lllllllllllllIllllIllIIIIIlIllIl) throws IOException {
                lllllllllllllllIlIllIIIIIllIIlII.write(lllllllllllllIllllIllIIIIIlIllIl);
            }
        };
    }
    
    static InputStream closeShield(final InputStream lllllllllllllllIlIllIIIIIllIlIll) {
        return new InputStream() {
            @Override
            public int read(final byte[] llllllllllllllIIlIlllIlIlIIIIlIl, final int llllllllllllllIIlIlllIlIlIIIIIll, final int llllllllllllllIIlIlllIlIlIIIIlII) throws IOException {
                return lllllllllllllllIlIllIIIIIllIlIll.read(llllllllllllllIIlIlllIlIlIIIIlIl, llllllllllllllIIlIlllIlIlIIIIIll, llllllllllllllIIlIlllIlIlIIIIlII);
            }
            
            @Override
            public int read() throws IOException {
                return lllllllllllllllIlIllIIIIIllIlIll.read();
            }
            
            @Override
            public int read(final byte[] llllllllllllllIIlIlllIlIlIIllIIl) throws IOException {
                return lllllllllllllllIlIllIIIIIllIlIll.read(llllllllllllllIIlIlllIlIlIIllIIl);
            }
        };
    }
}
