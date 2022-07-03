package com.viaversion.viaversion.libs.javassist.bytecode;

import java.io.*;

final class ByteStream extends OutputStream
{
    private /* synthetic */ byte[] buf;
    private /* synthetic */ int count;
    
    public void writeLong(final long lllllllllllllIIIIIIlIlllIIIlIlII) {
        this.enlarge(8);
        final int lllllllllllllIIIIIIlIlllIIIlIllI = this.count;
        this.buf[lllllllllllllIIIIIIlIlllIIIlIllI] = (byte)(lllllllllllllIIIIIIlIlllIIIlIlII >>> 56);
        this.buf[lllllllllllllIIIIIIlIlllIIIlIllI + 1] = (byte)(lllllllllllllIIIIIIlIlllIIIlIlII >>> 48);
        this.buf[lllllllllllllIIIIIIlIlllIIIlIllI + 2] = (byte)(lllllllllllllIIIIIIlIlllIIIlIlII >>> 40);
        this.buf[lllllllllllllIIIIIIlIlllIIIlIllI + 3] = (byte)(lllllllllllllIIIIIIlIlllIIIlIlII >>> 32);
        this.buf[lllllllllllllIIIIIIlIlllIIIlIllI + 4] = (byte)(lllllllllllllIIIIIIlIlllIIIlIlII >>> 24);
        this.buf[lllllllllllllIIIIIIlIlllIIIlIllI + 5] = (byte)(lllllllllllllIIIIIIlIlllIIIlIlII >>> 16);
        this.buf[lllllllllllllIIIIIIlIlllIIIlIllI + 6] = (byte)(lllllllllllllIIIIIIlIlllIIIlIlII >>> 8);
        this.buf[lllllllllllllIIIIIIlIlllIIIlIllI + 7] = (byte)lllllllllllllIIIIIIlIlllIIIlIlII;
        this.count = lllllllllllllIIIIIIlIlllIIIlIllI + 8;
    }
    
    @Override
    public void write(final byte[] lllllllllllllIIIIIIlIlllIlIIIIll) {
        this.write(lllllllllllllIIIIIIlIlllIlIIIIll, 0, lllllllllllllIIIIIIlIlllIlIIIIll.length);
    }
    
    public ByteStream(final int lllllllllllllIIIIIIlIlllIlIlIlIl) {
        this.buf = new byte[lllllllllllllIIIIIIlIlllIlIlIlIl];
        this.count = 0;
    }
    
    public int size() {
        return this.count;
    }
    
    public void writeFloat(final float lllllllllllllIIIIIIlIlllIIIIllll) {
        this.writeInt(Float.floatToIntBits(lllllllllllllIIIIIIlIlllIIIIllll));
    }
    
    public void writeInt(final int lllllllllllllIIIIIIlIllIlIlllllI, final int lllllllllllllIIIIIIlIllIlIllllIl) {
        this.buf[lllllllllllllIIIIIIlIllIlIlllllI] = (byte)(lllllllllllllIIIIIIlIllIlIllllIl >>> 24);
        this.buf[lllllllllllllIIIIIIlIllIlIlllllI + 1] = (byte)(lllllllllllllIIIIIIlIllIlIllllIl >>> 16);
        this.buf[lllllllllllllIIIIIIlIllIlIlllllI + 2] = (byte)(lllllllllllllIIIIIIlIllIlIllllIl >>> 8);
        this.buf[lllllllllllllIIIIIIlIllIlIlllllI + 3] = (byte)lllllllllllllIIIIIIlIllIlIllllIl;
    }
    
    public void writeShort(final int lllllllllllllIIIIIIlIlllIIlIlIIl) {
        this.enlarge(2);
        final int lllllllllllllIIIIIIlIlllIIlIlIII = this.count;
        this.buf[lllllllllllllIIIIIIlIlllIIlIlIII] = (byte)(lllllllllllllIIIIIIlIlllIIlIlIIl >>> 8);
        this.buf[lllllllllllllIIIIIIlIlllIIlIlIII + 1] = (byte)lllllllllllllIIIIIIlIlllIIlIlIIl;
        this.count = lllllllllllllIIIIIIlIlllIIlIlIII + 2;
    }
    
    public int getPos() {
        return this.count;
    }
    
    public void writeBlank(final int lllllllllllllIIIIIIlIlllIlIIlIll) {
        this.enlarge(lllllllllllllIIIIIIlIlllIlIIlIll);
        this.count += lllllllllllllIIIIIIlIlllIlIIlIll;
    }
    
    public void writeTo(final OutputStream lllllllllllllIIIIIIlIllIlIlIlllI) throws IOException {
        lllllllllllllIIIIIIlIllIlIlIlllI.write(this.buf, 0, this.count);
    }
    
    public void write(final int lllllllllllllIIIIIIlIllIllIIllIl, final int lllllllllllllIIIIIIlIllIllIIllll) {
        this.buf[lllllllllllllIIIIIIlIllIllIIllIl] = (byte)lllllllllllllIIIIIIlIllIllIIllll;
    }
    
    private void writeUTF2(final String lllllllllllllIIIIIIlIllIlllIIIll, final int lllllllllllllIIIIIIlIllIllIllIll, final int lllllllllllllIIIIIIlIllIllIllIlI) {
        int lllllllllllllIIIIIIlIllIlllIIIII = lllllllllllllIIIIIIlIllIllIllIll;
        for (int lllllllllllllIIIIIIlIllIlllIIlll = lllllllllllllIIIIIIlIllIllIllIlI; lllllllllllllIIIIIIlIllIlllIIlll < lllllllllllllIIIIIIlIllIllIllIll; ++lllllllllllllIIIIIIlIllIlllIIlll) {
            final int lllllllllllllIIIIIIlIllIlllIlIII = lllllllllllllIIIIIIlIllIlllIIIll.charAt(lllllllllllllIIIIIIlIllIlllIIlll);
            if (lllllllllllllIIIIIIlIllIlllIlIII > 2047) {
                lllllllllllllIIIIIIlIllIlllIIIII += 2;
            }
            else if (lllllllllllllIIIIIIlIllIlllIlIII == 0 || lllllllllllllIIIIIIlIllIlllIlIII > 127) {
                ++lllllllllllllIIIIIIlIllIlllIIIII;
            }
        }
        if (lllllllllllllIIIIIIlIllIlllIIIII > 65535) {
            throw new RuntimeException(String.valueOf(new StringBuilder().append("encoded string too long: ").append(lllllllllllllIIIIIIlIllIllIllIll).append(lllllllllllllIIIIIIlIllIlllIIIII).append(" bytes")));
        }
        this.enlarge(lllllllllllllIIIIIIlIllIlllIIIII + 2);
        int lllllllllllllIIIIIIlIllIllIlllll = this.count;
        final byte[] lllllllllllllIIIIIIlIllIllIllllI = this.buf;
        lllllllllllllIIIIIIlIllIllIllllI[lllllllllllllIIIIIIlIllIllIlllll] = (byte)(lllllllllllllIIIIIIlIllIlllIIIII >>> 8);
        lllllllllllllIIIIIIlIllIllIllllI[lllllllllllllIIIIIIlIllIllIlllll + 1] = (byte)lllllllllllllIIIIIIlIllIlllIIIII;
        lllllllllllllIIIIIIlIllIllIlllll += 2 + lllllllllllllIIIIIIlIllIllIllIlI;
        for (int lllllllllllllIIIIIIlIllIlllIIlIl = lllllllllllllIIIIIIlIllIllIllIlI; lllllllllllllIIIIIIlIllIlllIIlIl < lllllllllllllIIIIIIlIllIllIllIll; ++lllllllllllllIIIIIIlIllIlllIIlIl) {
            final int lllllllllllllIIIIIIlIllIlllIIllI = lllllllllllllIIIIIIlIllIlllIIIll.charAt(lllllllllllllIIIIIIlIllIlllIIlIl);
            if (1 <= lllllllllllllIIIIIIlIllIlllIIllI && lllllllllllllIIIIIIlIllIlllIIllI <= 127) {
                lllllllllllllIIIIIIlIllIllIllllI[lllllllllllllIIIIIIlIllIllIlllll++] = (byte)lllllllllllllIIIIIIlIllIlllIIllI;
            }
            else if (lllllllllllllIIIIIIlIllIlllIIllI > 2047) {
                lllllllllllllIIIIIIlIllIllIllllI[lllllllllllllIIIIIIlIllIllIlllll] = (byte)(0xE0 | (lllllllllllllIIIIIIlIllIlllIIllI >> 12 & 0xF));
                lllllllllllllIIIIIIlIllIllIllllI[lllllllllllllIIIIIIlIllIllIlllll + 1] = (byte)(0x80 | (lllllllllllllIIIIIIlIllIlllIIllI >> 6 & 0x3F));
                lllllllllllllIIIIIIlIllIllIllllI[lllllllllllllIIIIIIlIllIllIlllll + 2] = (byte)(0x80 | (lllllllllllllIIIIIIlIllIlllIIllI & 0x3F));
                lllllllllllllIIIIIIlIllIllIlllll += 3;
            }
            else {
                lllllllllllllIIIIIIlIllIllIllllI[lllllllllllllIIIIIIlIllIllIlllll] = (byte)(0xC0 | (lllllllllllllIIIIIIlIllIlllIIllI >> 6 & 0x1F));
                lllllllllllllIIIIIIlIllIllIllllI[lllllllllllllIIIIIIlIllIllIlllll + 1] = (byte)(0x80 | (lllllllllllllIIIIIIlIllIlllIIllI & 0x3F));
                lllllllllllllIIIIIIlIllIllIlllll += 2;
            }
        }
        this.count = lllllllllllllIIIIIIlIllIllIlllll;
    }
    
    public void writeUTF(final String lllllllllllllIIIIIIlIllIllllllII) {
        final int lllllllllllllIIIIIIlIllIlllllIll = lllllllllllllIIIIIIlIllIllllllII.length();
        int lllllllllllllIIIIIIlIllIlllllIlI = this.count;
        this.enlarge(lllllllllllllIIIIIIlIllIlllllIll + 2);
        final byte[] lllllllllllllIIIIIIlIllIlllllIIl = this.buf;
        lllllllllllllIIIIIIlIllIlllllIIl[lllllllllllllIIIIIIlIllIlllllIlI++] = (byte)(lllllllllllllIIIIIIlIllIlllllIll >>> 8);
        lllllllllllllIIIIIIlIllIlllllIIl[lllllllllllllIIIIIIlIllIlllllIlI++] = (byte)lllllllllllllIIIIIIlIllIlllllIll;
        for (int lllllllllllllIIIIIIlIllIlllllllI = 0; lllllllllllllIIIIIIlIllIlllllllI < lllllllllllllIIIIIIlIllIlllllIll; ++lllllllllllllIIIIIIlIllIlllllllI) {
            final char lllllllllllllIIIIIIlIllIllllllll = lllllllllllllIIIIIIlIllIllllllII.charAt(lllllllllllllIIIIIIlIllIlllllllI);
            if ('\u0001' > lllllllllllllIIIIIIlIllIllllllll || lllllllllllllIIIIIIlIllIllllllll > '\u007f') {
                this.writeUTF2(lllllllllllllIIIIIIlIllIllllllII, lllllllllllllIIIIIIlIllIlllllIll, lllllllllllllIIIIIIlIllIlllllllI);
                return;
            }
            lllllllllllllIIIIIIlIllIlllllIIl[lllllllllllllIIIIIIlIllIlllllIlI++] = (byte)lllllllllllllIIIIIIlIllIllllllll;
        }
        this.count = lllllllllllllIIIIIIlIllIlllllIlI;
    }
    
    public void writeDouble(final double lllllllllllllIIIIIIlIlllIIIIIlll) {
        this.writeLong(Double.doubleToLongBits(lllllllllllllIIIIIIlIlllIIIIIlll));
    }
    
    public void writeShort(final int lllllllllllllIIIIIIlIllIllIIIlII, final int lllllllllllllIIIIIIlIllIllIIIIll) {
        this.buf[lllllllllllllIIIIIIlIllIllIIIlII] = (byte)(lllllllllllllIIIIIIlIllIllIIIIll >>> 8);
        this.buf[lllllllllllllIIIIIIlIllIllIIIlII + 1] = (byte)lllllllllllllIIIIIIlIllIllIIIIll;
    }
    
    public void writeInt(final int lllllllllllllIIIIIIlIlllIIIlllIl) {
        this.enlarge(4);
        final int lllllllllllllIIIIIIlIlllIIIlllll = this.count;
        this.buf[lllllllllllllIIIIIIlIlllIIIlllll] = (byte)(lllllllllllllIIIIIIlIlllIIIlllIl >>> 24);
        this.buf[lllllllllllllIIIIIIlIlllIIIlllll + 1] = (byte)(lllllllllllllIIIIIIlIlllIIIlllIl >>> 16);
        this.buf[lllllllllllllIIIIIIlIlllIIIlllll + 2] = (byte)(lllllllllllllIIIIIIlIlllIIIlllIl >>> 8);
        this.buf[lllllllllllllIIIIIIlIlllIIIlllll + 3] = (byte)lllllllllllllIIIIIIlIlllIIIlllIl;
        this.count = lllllllllllllIIIIIIlIlllIIIlllll + 4;
    }
    
    public ByteStream() {
        this(32);
    }
    
    @Override
    public void write(final byte[] lllllllllllllIIIIIIlIlllIIlllIIl, final int lllllllllllllIIIIIIlIlllIIlllIII, final int lllllllllllllIIIIIIlIlllIIlllIll) {
        this.enlarge(lllllllllllllIIIIIIlIlllIIlllIll);
        System.arraycopy(lllllllllllllIIIIIIlIlllIIlllIIl, lllllllllllllIIIIIIlIlllIIlllIII, this.buf, this.count, lllllllllllllIIIIIIlIlllIIlllIll);
        this.count += lllllllllllllIIIIIIlIlllIIlllIll;
    }
    
    public byte[] toByteArray() {
        final byte[] lllllllllllllIIIIIIlIllIlIllIllI = new byte[this.count];
        System.arraycopy(this.buf, 0, lllllllllllllIIIIIIlIllIlIllIllI, 0, this.count);
        return lllllllllllllIIIIIIlIllIlIllIllI;
    }
    
    @Override
    public void write(final int lllllllllllllIIIIIIlIlllIIllIIlI) {
        this.enlarge(1);
        final int lllllllllllllIIIIIIlIlllIIllIIIl = this.count;
        this.buf[lllllllllllllIIIIIIlIlllIIllIIIl] = (byte)lllllllllllllIIIIIIlIlllIIllIIlI;
        this.count = lllllllllllllIIIIIIlIlllIIllIIIl + 1;
    }
    
    public void enlarge(final int lllllllllllllIIIIIIlIllIlIlIIlIl) {
        final int lllllllllllllIIIIIIlIllIlIlIIlII = this.count + lllllllllllllIIIIIIlIllIlIlIIlIl;
        if (lllllllllllllIIIIIIlIllIlIlIIlII > this.buf.length) {
            final int lllllllllllllIIIIIIlIllIlIlIlIII = this.buf.length << 1;
            final byte[] lllllllllllllIIIIIIlIllIlIlIIlll = new byte[(lllllllllllllIIIIIIlIllIlIlIlIII > lllllllllllllIIIIIIlIllIlIlIIlII) ? lllllllllllllIIIIIIlIllIlIlIlIII : lllllllllllllIIIIIIlIllIlIlIIlII];
            System.arraycopy(this.buf, 0, lllllllllllllIIIIIIlIllIlIlIIlll, 0, this.count);
            this.buf = lllllllllllllIIIIIIlIllIlIlIIlll;
        }
    }
}
