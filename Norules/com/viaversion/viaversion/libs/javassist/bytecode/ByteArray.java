package com.viaversion.viaversion.libs.javassist.bytecode;

public class ByteArray
{
    public static void write16bit(final int lllllllllllllIIIlIlllIIllIIIIIII, final byte[] lllllllllllllIIIlIlllIIllIIIIIlI, final int lllllllllllllIIIlIlllIIllIIIIIIl) {
        lllllllllllllIIIlIlllIIllIIIIIlI[lllllllllllllIIIlIlllIIllIIIIIIl] = (byte)(lllllllllllllIIIlIlllIIllIIIIIII >>> 8);
        lllllllllllllIIIlIlllIIllIIIIIlI[lllllllllllllIIIlIlllIIllIIIIIIl + 1] = (byte)lllllllllllllIIIlIlllIIllIIIIIII;
    }
    
    public static int readS16bit(final byte[] lllllllllllllIIIlIlllIIllIIIlIlI, final int lllllllllllllIIIlIlllIIllIIIIlll) {
        return lllllllllllllIIIlIlllIIllIIIlIlI[lllllllllllllIIIlIlllIIllIIIIlll] << 8 | (lllllllllllllIIIlIlllIIllIIIlIlI[lllllllllllllIIIlIlllIIllIIIIlll + 1] & 0xFF);
    }
    
    public static int readU16bit(final byte[] lllllllllllllIIIlIlllIIllIIIlllI, final int lllllllllllllIIIlIlllIIllIIIllIl) {
        return (lllllllllllllIIIlIlllIIllIIIlllI[lllllllllllllIIIlIlllIIllIIIllIl] & 0xFF) << 8 | (lllllllllllllIIIlIlllIIllIIIlllI[lllllllllllllIIIlIlllIIllIIIllIl + 1] & 0xFF);
    }
    
    public static int read32bit(final byte[] lllllllllllllIIIlIlllIIlIllllIll, final int lllllllllllllIIIlIlllIIlIllllIII) {
        return lllllllllllllIIIlIlllIIlIllllIll[lllllllllllllIIIlIlllIIlIllllIII] << 24 | (lllllllllllllIIIlIlllIIlIllllIll[lllllllllllllIIIlIlllIIlIllllIII + 1] & 0xFF) << 16 | (lllllllllllllIIIlIlllIIlIllllIll[lllllllllllllIIIlIlllIIlIllllIII + 2] & 0xFF) << 8 | (lllllllllllllIIIlIlllIIlIllllIll[lllllllllllllIIIlIlllIIlIllllIII + 3] & 0xFF);
    }
    
    public static void write32bit(final int lllllllllllllIIIlIlllIIlIlllIlII, final byte[] lllllllllllllIIIlIlllIIlIlllIIll, final int lllllllllllllIIIlIlllIIlIlllIIlI) {
        lllllllllllllIIIlIlllIIlIlllIIll[lllllllllllllIIIlIlllIIlIlllIIlI] = (byte)(lllllllllllllIIIlIlllIIlIlllIlII >>> 24);
        lllllllllllllIIIlIlllIIlIlllIIll[lllllllllllllIIIlIlllIIlIlllIIlI + 1] = (byte)(lllllllllllllIIIlIlllIIlIlllIlII >>> 16);
        lllllllllllllIIIlIlllIIlIlllIIll[lllllllllllllIIIlIlllIIlIlllIIlI + 2] = (byte)(lllllllllllllIIIlIlllIIlIlllIlII >>> 8);
        lllllllllllllIIIlIlllIIlIlllIIll[lllllllllllllIIIlIlllIIlIlllIIlI + 3] = (byte)lllllllllllllIIIlIlllIIlIlllIlII;
    }
    
    static void copy32bit(final byte[] lllllllllllllIIIlIlllIIlIllIlIlI, final int lllllllllllllIIIlIlllIIlIllIlIIl, final byte[] lllllllllllllIIIlIlllIIlIllIlIII, final int lllllllllllllIIIlIlllIIlIllIIlll) {
        lllllllllllllIIIlIlllIIlIllIlIII[lllllllllllllIIIlIlllIIlIllIIlll] = lllllllllllllIIIlIlllIIlIllIlIlI[lllllllllllllIIIlIlllIIlIllIlIIl];
        lllllllllllllIIIlIlllIIlIllIlIII[lllllllllllllIIIlIlllIIlIllIIlll + 1] = lllllllllllllIIIlIlllIIlIllIlIlI[lllllllllllllIIIlIlllIIlIllIlIIl + 1];
        lllllllllllllIIIlIlllIIlIllIlIII[lllllllllllllIIIlIlllIIlIllIIlll + 2] = lllllllllllllIIIlIlllIIlIllIlIlI[lllllllllllllIIIlIlllIIlIllIlIIl + 2];
        lllllllllllllIIIlIlllIIlIllIlIII[lllllllllllllIIIlIlllIIlIllIIlll + 3] = lllllllllllllIIIlIlllIIlIllIlIlI[lllllllllllllIIIlIlllIIlIllIlIIl + 3];
    }
}
