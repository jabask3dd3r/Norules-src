package org.yaml.snakeyaml.external.com.google.gdata.util.common.base;

public class PercentEscaper extends UnicodeEscaper
{
    private final /* synthetic */ boolean plusForSpace;
    private static final /* synthetic */ char[] URI_ESCAPED_SPACE;
    private static final /* synthetic */ char[] UPPER_HEX_DIGITS;
    private final /* synthetic */ boolean[] safeOctets;
    
    private static boolean[] createSafeOctets(final String llllllllllllllIlllIIlIIllllIIIll) {
        int llllllllllllllIlllIIlIIllllIIllI = 122;
        final char[] llllllllllllllIlllIIlIIlllllIIIl;
        final char[] llllllllllllllIlllIIlIIllllIIlIl = llllllllllllllIlllIIlIIlllllIIIl = llllllllllllllIlllIIlIIllllIIIll.toCharArray();
        for (final char llllllllllllllIlllIIlIIlllllIIlI : llllllllllllllIlllIIlIIlllllIIIl) {
            llllllllllllllIlllIIlIIllllIIllI = Math.max(llllllllllllllIlllIIlIIlllllIIlI, llllllllllllllIlllIIlIIllllIIllI);
        }
        final boolean[] llllllllllllllIlllIIlIIllllIIlII = new boolean[llllllllllllllIlllIIlIIllllIIllI + 1];
        for (int llllllllllllllIlllIIlIIllllIlllI = 48; llllllllllllllIlllIIlIIllllIlllI <= 57; ++llllllllllllllIlllIIlIIllllIlllI) {
            llllllllllllllIlllIIlIIllllIIlII[llllllllllllllIlllIIlIIllllIlllI] = true;
        }
        for (int llllllllllllllIlllIIlIIllllIllIl = 65; llllllllllllllIlllIIlIIllllIllIl <= 90; ++llllllllllllllIlllIIlIIllllIllIl) {
            llllllllllllllIlllIIlIIllllIIlII[llllllllllllllIlllIIlIIllllIllIl] = true;
        }
        for (int llllllllllllllIlllIIlIIllllIllII = 97; llllllllllllllIlllIIlIIllllIllII <= 122; ++llllllllllllllIlllIIlIIllllIllII) {
            llllllllllllllIlllIIlIIllllIIlII[llllllllllllllIlllIIlIIllllIllII] = true;
        }
        for (final char llllllllllllllIlllIIlIIllllIlIll : llllllllllllllIlllIIlIIllllIIlIl) {
            llllllllllllllIlllIIlIIllllIIlII[llllllllllllllIlllIIlIIllllIlIll] = true;
        }
        return llllllllllllllIlllIIlIIllllIIlII;
    }
    
    @Override
    protected int nextEscapeIndex(final CharSequence llllllllllllllIlllIIlIIlllIlIIII, int llllllllllllllIlllIIlIIlllIlIIll, final int llllllllllllllIlllIIlIIlllIlIIlI) {
        while (llllllllllllllIlllIIlIIlllIlIIll < llllllllllllllIlllIIlIIlllIlIIlI) {
            final char llllllllllllllIlllIIlIIlllIlIllI = llllllllllllllIlllIIlIIlllIlIIII.charAt(llllllllllllllIlllIIlIIlllIlIIll);
            if (llllllllllllllIlllIIlIIlllIlIllI >= this.safeOctets.length) {
                break;
            }
            if (!this.safeOctets[llllllllllllllIlllIIlIIlllIlIllI]) {
                break;
            }
            ++llllllllllllllIlllIIlIIlllIlIIll;
        }
        return llllllllllllllIlllIIlIIlllIlIIll;
    }
    
    @Override
    protected char[] escape(int llllllllllllllIlllIIlIIllIllIIll) {
        if (llllllllllllllIlllIIlIIllIllIIll < this.safeOctets.length && this.safeOctets[llllllllllllllIlllIIlIIllIllIIll]) {
            return null;
        }
        if (llllllllllllllIlllIIlIIllIllIIll == 32 && this.plusForSpace) {
            return PercentEscaper.URI_ESCAPED_SPACE;
        }
        if (llllllllllllllIlllIIlIIllIllIIll <= 127) {
            final char[] llllllllllllllIlllIIlIIllIlllIlI = { '%', PercentEscaper.UPPER_HEX_DIGITS[llllllllllllllIlllIIlIIllIllIIll >>> 4], PercentEscaper.UPPER_HEX_DIGITS[llllllllllllllIlllIIlIIllIllIIll & 0xF] };
            return llllllllllllllIlllIIlIIllIlllIlI;
        }
        if (llllllllllllllIlllIIlIIllIllIIll <= 2047) {
            final char[] llllllllllllllIlllIIlIIllIlllIIl = { '%', '\0', '\0', '%', '\0', PercentEscaper.UPPER_HEX_DIGITS[llllllllllllllIlllIIlIIllIllIIll & 0xF] };
            llllllllllllllIlllIIlIIllIllIIll >>>= 4;
            llllllllllllllIlllIIlIIllIlllIIl[4] = PercentEscaper.UPPER_HEX_DIGITS[0x8 | (llllllllllllllIlllIIlIIllIllIIll & 0x3)];
            llllllllllllllIlllIIlIIllIllIIll >>>= 2;
            llllllllllllllIlllIIlIIllIlllIIl[2] = PercentEscaper.UPPER_HEX_DIGITS[llllllllllllllIlllIIlIIllIllIIll & 0xF];
            llllllllllllllIlllIIlIIllIllIIll >>>= 4;
            llllllllllllllIlllIIlIIllIlllIIl[1] = PercentEscaper.UPPER_HEX_DIGITS[0xC | llllllllllllllIlllIIlIIllIllIIll];
            return llllllllllllllIlllIIlIIllIlllIIl;
        }
        if (llllllllllllllIlllIIlIIllIllIIll <= 65535) {
            final char[] llllllllllllllIlllIIlIIllIlllIII = { '%', 'E', '\0', '%', '\0', '\0', '%', '\0', PercentEscaper.UPPER_HEX_DIGITS[llllllllllllllIlllIIlIIllIllIIll & 0xF] };
            llllllllllllllIlllIIlIIllIllIIll >>>= 4;
            llllllllllllllIlllIIlIIllIlllIII[7] = PercentEscaper.UPPER_HEX_DIGITS[0x8 | (llllllllllllllIlllIIlIIllIllIIll & 0x3)];
            llllllllllllllIlllIIlIIllIllIIll >>>= 2;
            llllllllllllllIlllIIlIIllIlllIII[5] = PercentEscaper.UPPER_HEX_DIGITS[llllllllllllllIlllIIlIIllIllIIll & 0xF];
            llllllllllllllIlllIIlIIllIllIIll >>>= 4;
            llllllllllllllIlllIIlIIllIlllIII[4] = PercentEscaper.UPPER_HEX_DIGITS[0x8 | (llllllllllllllIlllIIlIIllIllIIll & 0x3)];
            llllllllllllllIlllIIlIIllIllIIll >>>= 2;
            llllllllllllllIlllIIlIIllIlllIII[2] = PercentEscaper.UPPER_HEX_DIGITS[llllllllllllllIlllIIlIIllIllIIll];
            return llllllllllllllIlllIIlIIllIlllIII;
        }
        if (llllllllllllllIlllIIlIIllIllIIll <= 1114111) {
            final char[] llllllllllllllIlllIIlIIllIllIlll = { '%', 'F', '\0', '%', '\0', '\0', '%', '\0', '\0', '%', '\0', PercentEscaper.UPPER_HEX_DIGITS[llllllllllllllIlllIIlIIllIllIIll & 0xF] };
            llllllllllllllIlllIIlIIllIllIIll >>>= 4;
            llllllllllllllIlllIIlIIllIllIlll[10] = PercentEscaper.UPPER_HEX_DIGITS[0x8 | (llllllllllllllIlllIIlIIllIllIIll & 0x3)];
            llllllllllllllIlllIIlIIllIllIIll >>>= 2;
            llllllllllllllIlllIIlIIllIllIlll[8] = PercentEscaper.UPPER_HEX_DIGITS[llllllllllllllIlllIIlIIllIllIIll & 0xF];
            llllllllllllllIlllIIlIIllIllIIll >>>= 4;
            llllllllllllllIlllIIlIIllIllIlll[7] = PercentEscaper.UPPER_HEX_DIGITS[0x8 | (llllllllllllllIlllIIlIIllIllIIll & 0x3)];
            llllllllllllllIlllIIlIIllIllIIll >>>= 2;
            llllllllllllllIlllIIlIIllIllIlll[5] = PercentEscaper.UPPER_HEX_DIGITS[llllllllllllllIlllIIlIIllIllIIll & 0xF];
            llllllllllllllIlllIIlIIllIllIIll >>>= 4;
            llllllllllllllIlllIIlIIllIllIlll[4] = PercentEscaper.UPPER_HEX_DIGITS[0x8 | (llllllllllllllIlllIIlIIllIllIIll & 0x3)];
            llllllllllllllIlllIIlIIllIllIIll >>>= 2;
            llllllllllllllIlllIIlIIllIllIlll[2] = PercentEscaper.UPPER_HEX_DIGITS[llllllllllllllIlllIIlIIllIllIIll & 0x7];
            return llllllllllllllIlllIIlIIllIllIlll;
        }
        throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Invalid unicode character value ").append(llllllllllllllIlllIIlIIllIllIIll)));
    }
    
    public PercentEscaper(final String llllllllllllllIlllIIlIIlllllllll, final boolean llllllllllllllIlllIIlIIllllllIll) {
        if (llllllllllllllIlllIIlIIlllllllll.matches(".*[0-9A-Za-z].*")) {
            throw new IllegalArgumentException("Alphanumeric characters are always 'safe' and should not be explicitly specified");
        }
        if (llllllllllllllIlllIIlIIllllllIll && llllllllllllllIlllIIlIIlllllllll.contains(" ")) {
            throw new IllegalArgumentException("plusForSpace cannot be specified when space is a 'safe' character");
        }
        if (llllllllllllllIlllIIlIIlllllllll.contains("%")) {
            throw new IllegalArgumentException("The '%' character cannot be specified as 'safe'");
        }
        this.plusForSpace = llllllllllllllIlllIIlIIllllllIll;
        this.safeOctets = createSafeOctets(llllllllllllllIlllIIlIIlllllllll);
    }
    
    @Override
    public String escape(final String llllllllllllllIlllIIlIIlllIIIIIl) {
        for (int llllllllllllllIlllIIlIIlllIIIIll = llllllllllllllIlllIIlIIlllIIIIIl.length(), llllllllllllllIlllIIlIIlllIIIllI = 0; llllllllllllllIlllIIlIIlllIIIllI < llllllllllllllIlllIIlIIlllIIIIll; ++llllllllllllllIlllIIlIIlllIIIllI) {
            final char llllllllllllllIlllIIlIIlllIIIlll = llllllllllllllIlllIIlIIlllIIIIIl.charAt(llllllllllllllIlllIIlIIlllIIIllI);
            if (llllllllllllllIlllIIlIIlllIIIlll >= this.safeOctets.length || !this.safeOctets[llllllllllllllIlllIIlIIlllIIIlll]) {
                return this.escapeSlow(llllllllllllllIlllIIlIIlllIIIIIl, llllllllllllllIlllIIlIIlllIIIllI);
            }
        }
        return llllllllllllllIlllIIlIIlllIIIIIl;
    }
    
    static {
        SAFEQUERYSTRINGCHARS_URLENCODER = "-_.!~*'()@:$,;/?:";
        SAFECHARS_URLENCODER = "-_.*";
        SAFEPATHCHARS_URLENCODER = "-_.!~*'()@:$&,;=";
        URI_ESCAPED_SPACE = new char[] { '+' };
        UPPER_HEX_DIGITS = "0123456789ABCDEF".toCharArray();
    }
}
