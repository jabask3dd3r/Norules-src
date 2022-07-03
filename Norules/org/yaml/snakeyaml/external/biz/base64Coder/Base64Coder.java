package org.yaml.snakeyaml.external.biz.base64Coder;

public class Base64Coder
{
    private static final /* synthetic */ String systemLineSeparator;
    private static /* synthetic */ byte[] map2;
    private static /* synthetic */ char[] map1;
    
    public static byte[] decode(final String lllllllllllllIIlIIIlllIIllIIlIII) {
        return decode(lllllllllllllIIlIIIlllIIllIIlIII.toCharArray());
    }
    
    public static String encodeLines(final byte[] lllllllllllllIIlIIIlllIlIIllIlll) {
        return encodeLines(lllllllllllllIIlIIIlllIlIIllIlll, 0, lllllllllllllIIlIIIlllIlIIllIlll.length, 76, Base64Coder.systemLineSeparator);
    }
    
    public static char[] encode(final byte[] lllllllllllllIIlIIIlllIlIIIlIIII, final int lllllllllllllIIlIIIlllIlIIIIllIl) {
        return encode(lllllllllllllIIlIIIlllIlIIIlIIII, 0, lllllllllllllIIlIIIlllIlIIIIllIl);
    }
    
    private Base64Coder() {
    }
    
    public static String encodeLines(final byte[] lllllllllllllIIlIIIlllIlIIlIIIII, final int lllllllllllllIIlIIIlllIlIIlIlIIl, final int lllllllllllllIIlIIIlllIlIIlIlIII, final int lllllllllllllIIlIIIlllIlIIlIIlll, final String lllllllllllllIIlIIIlllIlIIIlllII) {
        final int lllllllllllllIIlIIIlllIlIIlIIlIl = lllllllllllllIIlIIIlllIlIIlIIlll * 3 / 4;
        if (lllllllllllllIIlIIIlllIlIIlIIlIl <= 0) {
            throw new IllegalArgumentException();
        }
        final int lllllllllllllIIlIIIlllIlIIlIIlII = (lllllllllllllIIlIIIlllIlIIlIlIII + lllllllllllllIIlIIIlllIlIIlIIlIl - 1) / lllllllllllllIIlIIIlllIlIIlIIlIl;
        final int lllllllllllllIIlIIIlllIlIIlIIIll = (lllllllllllllIIlIIIlllIlIIlIlIII + 2) / 3 * 4 + lllllllllllllIIlIIIlllIlIIlIIlII * lllllllllllllIIlIIIlllIlIIIlllII.length();
        final StringBuilder lllllllllllllIIlIIIlllIlIIlIIIlI = new StringBuilder(lllllllllllllIIlIIIlllIlIIlIIIll);
        int lllllllllllllIIlIIIlllIlIIlIlIll;
        for (int lllllllllllllIIlIIIlllIlIIlIIIIl = 0; lllllllllllllIIlIIIlllIlIIlIIIIl < lllllllllllllIIlIIIlllIlIIlIlIII; lllllllllllllIIlIIIlllIlIIlIIIIl += lllllllllllllIIlIIIlllIlIIlIlIll) {
            lllllllllllllIIlIIIlllIlIIlIlIll = Math.min(lllllllllllllIIlIIIlllIlIIlIlIII - lllllllllllllIIlIIIlllIlIIlIIIIl, lllllllllllllIIlIIIlllIlIIlIIlIl);
            lllllllllllllIIlIIIlllIlIIlIIIlI.append(encode(lllllllllllllIIlIIIlllIlIIlIIIII, lllllllllllllIIlIIIlllIlIIlIlIIl + lllllllllllllIIlIIIlllIlIIlIIIIl, lllllllllllllIIlIIIlllIlIIlIlIll));
            lllllllllllllIIlIIIlllIlIIlIIIlI.append(lllllllllllllIIlIIIlllIlIIIlllII);
        }
        return String.valueOf(lllllllllllllIIlIIIlllIlIIlIIIlI);
    }
    
    public static char[] encode(final byte[] lllllllllllllIIlIIIlllIIllllIlIl, final int lllllllllllllIIlIIIlllIIllllIlII, final int lllllllllllllIIlIIIlllIIllllIIll) {
        final int lllllllllllllIIlIIIlllIIllllIIlI = (lllllllllllllIIlIIIlllIIllllIIll * 4 + 2) / 3;
        final int lllllllllllllIIlIIIlllIIllllIIIl = (lllllllllllllIIlIIIlllIIllllIIll + 2) / 3 * 4;
        final char[] lllllllllllllIIlIIIlllIIllllIIII = new char[lllllllllllllIIlIIIlllIIllllIIIl];
        int lllllllllllllIIlIIIlllIIllllllII;
        int lllllllllllllIIlIIIlllIIlllllIll;
        int lllllllllllllIIlIIIlllIIlllllIlI;
        int lllllllllllllIIlIIIlllIIlllllIIl;
        int lllllllllllllIIlIIIlllIIlllllIII;
        int lllllllllllllIIlIIIlllIIllllIlll;
        int lllllllllllllIIlIIIlllIIllllIllI;
        for (int lllllllllllllIIlIIIlllIIlllIllll = lllllllllllllIIlIIIlllIIllllIlII, lllllllllllllIIlIIIlllIIlllIlllI = lllllllllllllIIlIIIlllIIllllIlII + lllllllllllllIIlIIIlllIIllllIIll, lllllllllllllIIlIIIlllIIlllIllIl = 0; lllllllllllllIIlIIIlllIIlllIllll < lllllllllllllIIlIIIlllIIlllIlllI; lllllllllllllIIlIIIlllIIllllllII = (lllllllllllllIIlIIIlllIIllllIlIl[lllllllllllllIIlIIIlllIIlllIllll++] & 0xFF), lllllllllllllIIlIIIlllIIlllllIll = ((lllllllllllllIIlIIIlllIIlllIllll < lllllllllllllIIlIIIlllIIlllIlllI) ? (lllllllllllllIIlIIIlllIIllllIlIl[lllllllllllllIIlIIIlllIIlllIllll++] & 0xFF) : 0), lllllllllllllIIlIIIlllIIlllllIlI = ((lllllllllllllIIlIIIlllIIlllIllll < lllllllllllllIIlIIIlllIIlllIlllI) ? (lllllllllllllIIlIIIlllIIllllIlIl[lllllllllllllIIlIIIlllIIlllIllll++] & 0xFF) : 0), lllllllllllllIIlIIIlllIIlllllIIl = lllllllllllllIIlIIIlllIIllllllII >>> 2, lllllllllllllIIlIIIlllIIlllllIII = ((lllllllllllllIIlIIIlllIIllllllII & 0x3) << 4 | lllllllllllllIIlIIIlllIIlllllIll >>> 4), lllllllllllllIIlIIIlllIIllllIlll = ((lllllllllllllIIlIIIlllIIlllllIll & 0xF) << 2 | lllllllllllllIIlIIIlllIIlllllIlI >>> 6), lllllllllllllIIlIIIlllIIllllIllI = (lllllllllllllIIlIIIlllIIlllllIlI & 0x3F), lllllllllllllIIlIIIlllIIllllIIII[lllllllllllllIIlIIIlllIIlllIllIl++] = Base64Coder.map1[lllllllllllllIIlIIIlllIIlllllIIl], lllllllllllllIIlIIIlllIIllllIIII[lllllllllllllIIlIIIlllIIlllIllIl++] = Base64Coder.map1[lllllllllllllIIlIIIlllIIlllllIII], lllllllllllllIIlIIIlllIIllllIIII[lllllllllllllIIlIIIlllIIlllIllIl] = ((lllllllllllllIIlIIIlllIIlllIllIl < lllllllllllllIIlIIIlllIIllllIIlI) ? Base64Coder.map1[lllllllllllllIIlIIIlllIIllllIlll] : '='), ++lllllllllllllIIlIIIlllIIlllIllIl, lllllllllllllIIlIIIlllIIllllIIII[lllllllllllllIIlIIIlllIIlllIllIl] = ((lllllllllllllIIlIIIlllIIlllIllIl < lllllllllllllIIlIIIlllIIllllIIlI) ? Base64Coder.map1[lllllllllllllIIlIIIlllIIllllIllI] : '='), ++lllllllllllllIIlIIIlllIIlllIllIl) {}
        return lllllllllllllIIlIIIlllIIllllIIII;
    }
    
    public static String encodeString(final String lllllllllllllIIlIIIlllIlIIlllIlI) {
        return new String(encode(lllllllllllllIIlIIIlllIlIIlllIlI.getBytes()));
    }
    
    public static byte[] decodeLines(final String lllllllllllllIIlIIIlllIIllIlIIlI) {
        final char[] lllllllllllllIIlIIIlllIIllIlIIIl = new char[lllllllllllllIIlIIIlllIIllIlIIlI.length()];
        int lllllllllllllIIlIIIlllIIllIlIIII = 0;
        for (int lllllllllllllIIlIIIlllIIllIlIIll = 0; lllllllllllllIIlIIIlllIIllIlIIll < lllllllllllllIIlIIIlllIIllIlIIlI.length(); ++lllllllllllllIIlIIIlllIIllIlIIll) {
            final char lllllllllllllIIlIIIlllIIllIlIlII = lllllllllllllIIlIIIlllIIllIlIIlI.charAt(lllllllllllllIIlIIIlllIIllIlIIll);
            if (lllllllllllllIIlIIIlllIIllIlIlII != ' ' && lllllllllllllIIlIIIlllIIllIlIlII != '\r' && lllllllllllllIIlIIIlllIIllIlIlII != '\n' && lllllllllllllIIlIIIlllIIllIlIlII != '\t') {
                lllllllllllllIIlIIIlllIIllIlIIIl[lllllllllllllIIlIIIlllIIllIlIIII++] = lllllllllllllIIlIIIlllIIllIlIlII;
            }
        }
        return decode(lllllllllllllIIlIIIlllIIllIlIIIl, 0, lllllllllllllIIlIIIlllIIllIlIIII);
    }
    
    public static char[] encode(final byte[] lllllllllllllIIlIIIlllIlIIIlIIll) {
        return encode(lllllllllllllIIlIIIlllIlIIIlIIll, 0, lllllllllllllIIlIIIlllIlIIIlIIll.length);
    }
    
    static {
        systemLineSeparator = System.getProperty("line.separator");
        Base64Coder.map1 = new char[64];
        int lllllllllllllIIlIIIlllIIlIIIIIll = 0;
        for (char lllllllllllllIIlIIIlllIIlIIIIllI = 'A'; lllllllllllllIIlIIIlllIIlIIIIllI <= 'Z'; ++lllllllllllllIIlIIIlllIIlIIIIllI) {
            Base64Coder.map1[lllllllllllllIIlIIIlllIIlIIIIIll++] = lllllllllllllIIlIIIlllIIlIIIIllI;
        }
        for (char lllllllllllllIIlIIIlllIIlIIIIlIl = 'a'; lllllllllllllIIlIIIlllIIlIIIIlIl <= 'z'; ++lllllllllllllIIlIIIlllIIlIIIIlIl) {
            Base64Coder.map1[lllllllllllllIIlIIIlllIIlIIIIIll++] = lllllllllllllIIlIIIlllIIlIIIIlIl;
        }
        for (char lllllllllllllIIlIIIlllIIlIIIIlII = '0'; lllllllllllllIIlIIIlllIIlIIIIlII <= '9'; ++lllllllllllllIIlIIIlllIIlIIIIlII) {
            Base64Coder.map1[lllllllllllllIIlIIIlllIIlIIIIIll++] = lllllllllllllIIlIIIlllIIlIIIIlII;
        }
        Base64Coder.map1[lllllllllllllIIlIIIlllIIlIIIIIll++] = '+';
        Base64Coder.map1[lllllllllllllIIlIIIlllIIlIIIIIll++] = '/';
        Base64Coder.map2 = new byte[128];
        for (int lllllllllllllIIlIIIlllIIlIIIIIlI = 0; lllllllllllllIIlIIIlllIIlIIIIIlI < Base64Coder.map2.length; ++lllllllllllllIIlIIIlllIIlIIIIIlI) {
            Base64Coder.map2[lllllllllllllIIlIIIlllIIlIIIIIlI] = -1;
        }
        for (int lllllllllllllIIlIIIlllIIlIIIIIIl = 0; lllllllllllllIIlIIIlllIIlIIIIIIl < 64; ++lllllllllllllIIlIIIlllIIlIIIIIIl) {
            Base64Coder.map2[Base64Coder.map1[lllllllllllllIIlIIIlllIIlIIIIIIl]] = (byte)lllllllllllllIIlIIIlllIIlIIIIIIl;
        }
    }
    
    public static byte[] decode(final char[] lllllllllllllIIlIIIlllIIlIlIIllI, final int lllllllllllllIIlIIIlllIIlIIlllIl, int lllllllllllllIIlIIIlllIIlIlIIlII) {
        if (lllllllllllllIIlIIIlllIIlIlIIlII % 4 != 0) {
            throw new IllegalArgumentException("Length of Base64 encoded input string is not a multiple of 4.");
        }
        while (lllllllllllllIIlIIIlllIIlIlIIlII > 0 && lllllllllllllIIlIIIlllIIlIlIIllI[lllllllllllllIIlIIIlllIIlIIlllIl + lllllllllllllIIlIIIlllIIlIlIIlII - 1] == '=') {
            --lllllllllllllIIlIIIlllIIlIlIIlII;
        }
        final int lllllllllllllIIlIIIlllIIlIlIIIll = lllllllllllllIIlIIIlllIIlIlIIlII * 3 / 4;
        final byte[] lllllllllllllIIlIIIlllIIlIlIIIlI = new byte[lllllllllllllIIlIIIlllIIlIlIIIll];
        int lllllllllllllIIlIIIlllIIlIlIIIIl = lllllllllllllIIlIIIlllIIlIIlllIl;
        final int lllllllllllllIIlIIIlllIIlIlIIIII = lllllllllllllIIlIIIlllIIlIIlllIl + lllllllllllllIIlIIIlllIIlIlIIlII;
        int lllllllllllllIIlIIIlllIIlIIlllll = 0;
        while (lllllllllllllIIlIIIlllIIlIlIIIIl < lllllllllllllIIlIIIlllIIlIlIIIII) {
            final int lllllllllllllIIlIIIlllIIlIllIIIl = lllllllllllllIIlIIIlllIIlIlIIllI[lllllllllllllIIlIIIlllIIlIlIIIIl++];
            final int lllllllllllllIIlIIIlllIIlIllIIII = lllllllllllllIIlIIIlllIIlIlIIllI[lllllllllllllIIlIIIlllIIlIlIIIIl++];
            final int lllllllllllllIIlIIIlllIIlIlIllll = (lllllllllllllIIlIIIlllIIlIlIIIIl < lllllllllllllIIlIIIlllIIlIlIIIII) ? lllllllllllllIIlIIIlllIIlIlIIllI[lllllllllllllIIlIIIlllIIlIlIIIIl++] : 'A';
            final int lllllllllllllIIlIIIlllIIlIlIlllI = (lllllllllllllIIlIIIlllIIlIlIIIIl < lllllllllllllIIlIIIlllIIlIlIIIII) ? lllllllllllllIIlIIIlllIIlIlIIllI[lllllllllllllIIlIIIlllIIlIlIIIIl++] : 'A';
            if (lllllllllllllIIlIIIlllIIlIllIIIl > 127 || lllllllllllllIIlIIIlllIIlIllIIII > 127 || lllllllllllllIIlIIIlllIIlIlIllll > 127 || lllllllllllllIIlIIIlllIIlIlIlllI > 127) {
                throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
            }
            final int lllllllllllllIIlIIIlllIIlIlIllIl = Base64Coder.map2[lllllllllllllIIlIIIlllIIlIllIIIl];
            final int lllllllllllllIIlIIIlllIIlIlIllII = Base64Coder.map2[lllllllllllllIIlIIIlllIIlIllIIII];
            final int lllllllllllllIIlIIIlllIIlIlIlIll = Base64Coder.map2[lllllllllllllIIlIIIlllIIlIlIllll];
            final int lllllllllllllIIlIIIlllIIlIlIlIlI = Base64Coder.map2[lllllllllllllIIlIIIlllIIlIlIlllI];
            if (lllllllllllllIIlIIIlllIIlIlIllIl < 0 || lllllllllllllIIlIIIlllIIlIlIllII < 0 || lllllllllllllIIlIIIlllIIlIlIlIll < 0 || lllllllllllllIIlIIIlllIIlIlIlIlI < 0) {
                throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
            }
            final int lllllllllllllIIlIIIlllIIlIlIlIIl = lllllllllllllIIlIIIlllIIlIlIllIl << 2 | lllllllllllllIIlIIIlllIIlIlIllII >>> 4;
            final int lllllllllllllIIlIIIlllIIlIlIlIII = (lllllllllllllIIlIIIlllIIlIlIllII & 0xF) << 4 | lllllllllllllIIlIIIlllIIlIlIlIll >>> 2;
            final int lllllllllllllIIlIIIlllIIlIlIIlll = (lllllllllllllIIlIIIlllIIlIlIlIll & 0x3) << 6 | lllllllllllllIIlIIIlllIIlIlIlIlI;
            lllllllllllllIIlIIIlllIIlIlIIIlI[lllllllllllllIIlIIIlllIIlIIlllll++] = (byte)lllllllllllllIIlIIIlllIIlIlIlIIl;
            if (lllllllllllllIIlIIIlllIIlIIlllll < lllllllllllllIIlIIIlllIIlIlIIIll) {
                lllllllllllllIIlIIIlllIIlIlIIIlI[lllllllllllllIIlIIIlllIIlIIlllll++] = (byte)lllllllllllllIIlIIIlllIIlIlIlIII;
            }
            if (lllllllllllllIIlIIIlllIIlIIlllll >= lllllllllllllIIlIIIlllIIlIlIIIll) {
                continue;
            }
            lllllllllllllIIlIIIlllIIlIlIIIlI[lllllllllllllIIlIIIlllIIlIIlllll++] = (byte)lllllllllllllIIlIIIlllIIlIlIIlll;
        }
        return lllllllllllllIIlIIIlllIIlIlIIIlI;
    }
    
    public static byte[] decode(final char[] lllllllllllllIIlIIIlllIIllIIIllI) {
        return decode(lllllllllllllIIlIIIlllIIllIIIllI, 0, lllllllllllllIIlIIIlllIIllIIIllI.length);
    }
    
    public static String decodeString(final String lllllllllllllIIlIIIlllIIllIllIlI) {
        return new String(decode(lllllllllllllIIlIIIlllIIllIllIlI));
    }
}
