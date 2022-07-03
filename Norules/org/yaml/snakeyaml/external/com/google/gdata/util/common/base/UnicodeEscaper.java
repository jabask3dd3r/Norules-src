package org.yaml.snakeyaml.external.com.google.gdata.util.common.base;

import java.io.*;

public abstract class UnicodeEscaper implements Escaper
{
    private static final /* synthetic */ ThreadLocal<char[]> DEST_TL;
    
    protected final String escapeSlow(final String llllllllllllllIIlIIIlIlIlllIlIIl, int llllllllllllllIIlIIIlIlIlllIlIII) {
        final int llllllllllllllIIlIIIlIlIlllIllll = llllllllllllllIIlIIIlIlIlllIlIIl.length();
        char[] llllllllllllllIIlIIIlIlIlllIlllI = UnicodeEscaper.DEST_TL.get();
        int llllllllllllllIIlIIIlIlIlllIllIl = 0;
        int llllllllllllllIIlIIIlIlIlllIllII;
        for (llllllllllllllIIlIIIlIlIlllIllII = 0; llllllllllllllIIlIIIlIlIlllIlIII < llllllllllllllIIlIIIlIlIlllIllll; llllllllllllllIIlIIIlIlIlllIlIII = this.nextEscapeIndex(llllllllllllllIIlIIIlIlIlllIlIIl, llllllllllllllIIlIIIlIlIlllIllII, llllllllllllllIIlIIIlIlIlllIllll)) {
            final int llllllllllllllIIlIIIlIlIllllIlIl = codePointAt(llllllllllllllIIlIIIlIlIlllIlIIl, llllllllllllllIIlIIIlIlIlllIlIII, llllllllllllllIIlIIIlIlIlllIllll);
            if (llllllllllllllIIlIIIlIlIllllIlIl < 0) {
                throw new IllegalArgumentException("Trailing high surrogate at end of input");
            }
            final char[] llllllllllllllIIlIIIlIlIllllIlII = this.escape(llllllllllllllIIlIIIlIlIllllIlIl);
            if (llllllllllllllIIlIIIlIlIllllIlII != null) {
                final int llllllllllllllIIlIIIlIlIllllIlll = llllllllllllllIIlIIIlIlIlllIlIII - llllllllllllllIIlIIIlIlIlllIllII;
                final int llllllllllllllIIlIIIlIlIllllIllI = llllllllllllllIIlIIIlIlIlllIllIl + llllllllllllllIIlIIIlIlIllllIlll + llllllllllllllIIlIIIlIlIllllIlII.length;
                if (llllllllllllllIIlIIIlIlIlllIlllI.length < llllllllllllllIIlIIIlIlIllllIllI) {
                    final int llllllllllllllIIlIIIlIlIlllllIII = llllllllllllllIIlIIIlIlIllllIllI + (llllllllllllllIIlIIIlIlIlllIllll - llllllllllllllIIlIIIlIlIlllIlIII) + 32;
                    llllllllllllllIIlIIIlIlIlllIlllI = growBuffer(llllllllllllllIIlIIIlIlIlllIlllI, llllllllllllllIIlIIIlIlIlllIllIl, llllllllllllllIIlIIIlIlIlllllIII);
                }
                if (llllllllllllllIIlIIIlIlIllllIlll > 0) {
                    llllllllllllllIIlIIIlIlIlllIlIIl.getChars(llllllllllllllIIlIIIlIlIlllIllII, llllllllllllllIIlIIIlIlIlllIlIII, llllllllllllllIIlIIIlIlIlllIlllI, llllllllllllllIIlIIIlIlIlllIllIl);
                    llllllllllllllIIlIIIlIlIlllIllIl += llllllllllllllIIlIIIlIlIllllIlll;
                }
                if (llllllllllllllIIlIIIlIlIllllIlII.length > 0) {
                    System.arraycopy(llllllllllllllIIlIIIlIlIllllIlII, 0, llllllllllllllIIlIIIlIlIlllIlllI, llllllllllllllIIlIIIlIlIlllIllIl, llllllllllllllIIlIIIlIlIllllIlII.length);
                    llllllllllllllIIlIIIlIlIlllIllIl += llllllllllllllIIlIIIlIlIllllIlII.length;
                }
            }
            llllllllllllllIIlIIIlIlIlllIllII = llllllllllllllIIlIIIlIlIlllIlIII + (Character.isSupplementaryCodePoint(llllllllllllllIIlIIIlIlIllllIlIl) ? 2 : 1);
        }
        final int llllllllllllllIIlIIIlIlIlllIlIll = llllllllllllllIIlIIIlIlIlllIllll - llllllllllllllIIlIIIlIlIlllIllII;
        if (llllllllllllllIIlIIIlIlIlllIlIll > 0) {
            final int llllllllllllllIIlIIIlIlIllllIIll = llllllllllllllIIlIIIlIlIlllIllIl + llllllllllllllIIlIIIlIlIlllIlIll;
            if (llllllllllllllIIlIIIlIlIlllIlllI.length < llllllllllllllIIlIIIlIlIllllIIll) {
                llllllllllllllIIlIIIlIlIlllIlllI = growBuffer(llllllllllllllIIlIIIlIlIlllIlllI, llllllllllllllIIlIIIlIlIlllIllIl, llllllllllllllIIlIIIlIlIllllIIll);
            }
            llllllllllllllIIlIIIlIlIlllIlIIl.getChars(llllllllllllllIIlIIIlIlIlllIllII, llllllllllllllIIlIIIlIlIlllIllll, llllllllllllllIIlIIIlIlIlllIlllI, llllllllllllllIIlIIIlIlIlllIllIl);
            llllllllllllllIIlIIIlIlIlllIllIl = llllllllllllllIIlIIIlIlIllllIIll;
        }
        return new String(llllllllllllllIIlIIIlIlIlllIlllI, 0, llllllllllllllIIlIIIlIlIlllIllIl);
    }
    
    protected static final int codePointAt(final CharSequence llllllllllllllIIlIIIlIlIllIIlllI, int llllllllllllllIIlIIIlIlIllIIllIl, final int llllllllllllllIIlIIIlIlIllIIllII) {
        if (llllllllllllllIIlIIIlIlIllIIllIl >= llllllllllllllIIlIIIlIlIllIIllII) {
            throw new IndexOutOfBoundsException("Index exceeds specified range");
        }
        final char llllllllllllllIIlIIIlIlIllIlIIlI = llllllllllllllIIlIIIlIlIllIIlllI.charAt(llllllllllllllIIlIIIlIlIllIIllIl++);
        if (llllllllllllllIIlIIIlIlIllIlIIlI < '\ud800' || llllllllllllllIIlIIIlIlIllIlIIlI > '\udfff') {
            return llllllllllllllIIlIIIlIlIllIlIIlI;
        }
        if (llllllllllllllIIlIIIlIlIllIlIIlI > '\udbff') {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Unexpected low surrogate character '").append(llllllllllllllIIlIIIlIlIllIlIIlI).append("' with value ").append((int)llllllllllllllIIlIIIlIlIllIlIIlI).append(" at index ").append(llllllllllllllIIlIIIlIlIllIIllIl - 1)));
        }
        if (llllllllllllllIIlIIIlIlIllIIllIl == llllllllllllllIIlIIIlIlIllIIllII) {
            return -llllllllllllllIIlIIIlIlIllIlIIlI;
        }
        final char llllllllllllllIIlIIIlIlIllIlIIll = llllllllllllllIIlIIIlIlIllIIlllI.charAt(llllllllllllllIIlIIIlIlIllIIllIl);
        if (Character.isLowSurrogate(llllllllllllllIIlIIIlIlIllIlIIll)) {
            return Character.toCodePoint(llllllllllllllIIlIIIlIlIllIlIIlI, llllllllllllllIIlIIIlIlIllIlIIll);
        }
        throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Expected low surrogate but got char '").append(llllllllllllllIIlIIIlIlIllIlIIll).append("' with value ").append((int)llllllllllllllIIlIIIlIlIllIlIIll).append(" at index ").append(llllllllllllllIIlIIIlIlIllIIllIl)));
    }
    
    protected abstract char[] escape(final int p0);
    
    @Override
    public String escape(final String llllllllllllllIIlIIIlIllIIIIIlll) {
        final int llllllllllllllIIlIIIlIllIIIIlIlI = llllllllllllllIIlIIIlIllIIIIIlll.length();
        final int llllllllllllllIIlIIIlIllIIIIlIIl = this.nextEscapeIndex(llllllllllllllIIlIIIlIllIIIIIlll, 0, llllllllllllllIIlIIIlIllIIIIlIlI);
        return (llllllllllllllIIlIIIlIllIIIIlIIl == llllllllllllllIIlIIIlIllIIIIlIlI) ? llllllllllllllIIlIIIlIllIIIIIlll : this.escapeSlow(llllllllllllllIIlIIIlIllIIIIIlll, llllllllllllllIIlIIIlIllIIIIlIIl);
    }
    
    protected int nextEscapeIndex(final CharSequence llllllllllllllIIlIIIlIllIIIllIlI, final int llllllllllllllIIlIIIlIllIIIllIIl, final int llllllllllllllIIlIIIlIllIIIllIII) {
        int llllllllllllllIIlIIIlIllIIIlIlll;
        int llllllllllllllIIlIIIlIllIIIlllII;
        for (llllllllllllllIIlIIIlIllIIIlIlll = llllllllllllllIIlIIIlIllIIIllIIl; llllllllllllllIIlIIIlIllIIIlIlll < llllllllllllllIIlIIIlIllIIIllIII; llllllllllllllIIlIIIlIllIIIlIlll += (Character.isSupplementaryCodePoint(llllllllllllllIIlIIIlIllIIIlllII) ? 2 : 1)) {
            llllllllllllllIIlIIIlIllIIIlllII = codePointAt(llllllllllllllIIlIIIlIllIIIllIlI, llllllllllllllIIlIIIlIllIIIlIlll, llllllllllllllIIlIIIlIllIIIllIII);
            if (llllllllllllllIIlIIIlIllIIIlllII < 0) {
                break;
            }
            if (this.escape(llllllllllllllIIlIIIlIllIIIlllII) != null) {
                break;
            }
        }
        return llllllllllllllIIlIIIlIllIIIlIlll;
    }
    
    private static final char[] growBuffer(final char[] llllllllllllllIIlIIIlIlIllIIIIIl, final int llllllllllllllIIlIIIlIlIllIIIlII, final int llllllllllllllIIlIIIlIlIlIllllll) {
        final char[] llllllllllllllIIlIIIlIlIllIIIIlI = new char[llllllllllllllIIlIIIlIlIlIllllll];
        if (llllllllllllllIIlIIIlIlIllIIIlII > 0) {
            System.arraycopy(llllllllllllllIIlIIIlIlIllIIIIIl, 0, llllllllllllllIIlIIIlIlIllIIIIlI, 0, llllllllllllllIIlIIIlIlIllIIIlII);
        }
        return llllllllllllllIIlIIIlIlIllIIIIlI;
    }
    
    static {
        DEST_PAD = 32;
        DEST_TL = new ThreadLocal<char[]>() {
            @Override
            protected char[] initialValue() {
                return new char[1024];
            }
        };
    }
    
    @Override
    public Appendable escape(final Appendable llllllllllllllIIlIIIlIlIllIllIll) {
        assert llllllllllllllIIlIIIlIlIllIllIll != null;
        return new Appendable() {
            /* synthetic */ int pendingHighSurrogate = -1;
            /* synthetic */ char[] decodedChars = new char[2];
            
            @Override
            public Appendable append(final CharSequence lllllllllllllIlIIlIllllIlIIIIIII) throws IOException {
                return this.append(lllllllllllllIlIIlIllllIlIIIIIII, 0, lllllllllllllIlIIlIllllIlIIIIIII.length());
            }
            
            @Override
            public Appendable append(final CharSequence lllllllllllllIlIIlIllllIIllIlIlI, final int lllllllllllllIlIIlIllllIIllIlIIl, final int lllllllllllllIlIIlIllllIIllIllIl) throws IOException {
                int lllllllllllllIlIIlIllllIIllIllII = lllllllllllllIlIIlIllllIIllIlIIl;
                if (lllllllllllllIlIIlIllllIIllIllII < lllllllllllllIlIIlIllllIIllIllIl) {
                    int lllllllllllllIlIIlIllllIIlllIIIl = lllllllllllllIlIIlIllllIIllIllII;
                    if (this.pendingHighSurrogate != -1) {
                        final char lllllllllllllIlIIlIllllIIlllIllI = lllllllllllllIlIIlIllllIIllIlIlI.charAt(lllllllllllllIlIIlIllllIIllIllII++);
                        if (!Character.isLowSurrogate(lllllllllllllIlIIlIllllIIlllIllI)) {
                            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Expected low surrogate character but got ").append(lllllllllllllIlIIlIllllIIlllIllI)));
                        }
                        final char[] lllllllllllllIlIIlIllllIIlllIlIl = UnicodeEscaper.this.escape(Character.toCodePoint((char)this.pendingHighSurrogate, lllllllllllllIlIIlIllllIIlllIllI));
                        if (lllllllllllllIlIIlIllllIIlllIlIl != null) {
                            this.outputChars(lllllllllllllIlIIlIllllIIlllIlIl, lllllllllllllIlIIlIllllIIlllIlIl.length);
                            ++lllllllllllllIlIIlIllllIIlllIIIl;
                        }
                        else {
                            llllllllllllllIIlIIIlIlIllIllIll.append((char)this.pendingHighSurrogate);
                        }
                        this.pendingHighSurrogate = -1;
                    }
                    while (true) {
                        lllllllllllllIlIIlIllllIIllIllII = UnicodeEscaper.this.nextEscapeIndex(lllllllllllllIlIIlIllllIIllIlIlI, lllllllllllllIlIIlIllllIIllIllII, lllllllllllllIlIIlIllllIIllIllIl);
                        if (lllllllllllllIlIIlIllllIIllIllII > lllllllllllllIlIIlIllllIIlllIIIl) {
                            llllllllllllllIIlIIIlIlIllIllIll.append(lllllllllllllIlIIlIllllIIllIlIlI, lllllllllllllIlIIlIllllIIlllIIIl, lllllllllllllIlIIlIllllIIllIllII);
                        }
                        if (lllllllllllllIlIIlIllllIIllIllII == lllllllllllllIlIIlIllllIIllIllIl) {
                            break;
                        }
                        final int lllllllllllllIlIIlIllllIIlllIIll = UnicodeEscaper.codePointAt(lllllllllllllIlIIlIllllIIllIlIlI, lllllllllllllIlIIlIllllIIllIllII, lllllllllllllIlIIlIllllIIllIllIl);
                        if (lllllllllllllIlIIlIllllIIlllIIll < 0) {
                            this.pendingHighSurrogate = -lllllllllllllIlIIlIllllIIlllIIll;
                            break;
                        }
                        final char[] lllllllllllllIlIIlIllllIIlllIIlI = UnicodeEscaper.this.escape(lllllllllllllIlIIlIllllIIlllIIll);
                        if (lllllllllllllIlIIlIllllIIlllIIlI != null) {
                            this.outputChars(lllllllllllllIlIIlIllllIIlllIIlI, lllllllllllllIlIIlIllllIIlllIIlI.length);
                        }
                        else {
                            final int lllllllllllllIlIIlIllllIIlllIlII = Character.toChars(lllllllllllllIlIIlIllllIIlllIIll, this.decodedChars, 0);
                            this.outputChars(this.decodedChars, lllllllllllllIlIIlIllllIIlllIlII);
                        }
                        lllllllllllllIlIIlIllllIIllIllII = (lllllllllllllIlIIlIllllIIlllIIIl = lllllllllllllIlIIlIllllIIllIllII + (Character.isSupplementaryCodePoint(lllllllllllllIlIIlIllllIIlllIIll) ? 2 : 1));
                    }
                }
                return this;
            }
            
            private void outputChars(final char[] lllllllllllllIlIIlIllllIIlIlIIlI, final int lllllllllllllIlIIlIllllIIlIIlllI) throws IOException {
                for (int lllllllllllllIlIIlIllllIIlIlIlII = 0; lllllllllllllIlIIlIllllIIlIlIlII < lllllllllllllIlIIlIllllIIlIIlllI; ++lllllllllllllIlIIlIllllIIlIlIlII) {
                    llllllllllllllIIlIIIlIlIllIllIll.append(lllllllllllllIlIIlIllllIIlIlIIlI[lllllllllllllIlIIlIllllIIlIlIlII]);
                }
            }
            
            @Override
            public Appendable append(final char lllllllllllllIlIIlIllllIIlIlllII) throws IOException {
                if (this.pendingHighSurrogate != -1) {
                    if (!Character.isLowSurrogate(lllllllllllllIlIIlIllllIIlIlllII)) {
                        throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Expected low surrogate character but got '").append(lllllllllllllIlIIlIllllIIlIlllII).append("' with value ").append((int)lllllllllllllIlIIlIllllIIlIlllII)));
                    }
                    final char[] lllllllllllllIlIIlIllllIIlIlllll = UnicodeEscaper.this.escape(Character.toCodePoint((char)this.pendingHighSurrogate, lllllllllllllIlIIlIllllIIlIlllII));
                    if (lllllllllllllIlIIlIllllIIlIlllll != null) {
                        this.outputChars(lllllllllllllIlIIlIllllIIlIlllll, lllllllllllllIlIIlIllllIIlIlllll.length);
                    }
                    else {
                        llllllllllllllIIlIIIlIlIllIllIll.append((char)this.pendingHighSurrogate);
                        llllllllllllllIIlIIIlIlIllIllIll.append(lllllllllllllIlIIlIllllIIlIlllII);
                    }
                    this.pendingHighSurrogate = -1;
                }
                else if (Character.isHighSurrogate(lllllllllllllIlIIlIllllIIlIlllII)) {
                    this.pendingHighSurrogate = lllllllllllllIlIIlIllllIIlIlllII;
                }
                else {
                    if (Character.isLowSurrogate(lllllllllllllIlIIlIllllIIlIlllII)) {
                        throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Unexpected low surrogate character '").append(lllllllllllllIlIIlIllllIIlIlllII).append("' with value ").append((int)lllllllllllllIlIIlIllllIIlIlllII)));
                    }
                    final char[] lllllllllllllIlIIlIllllIIlIllllI = UnicodeEscaper.this.escape(lllllllllllllIlIIlIllllIIlIlllII);
                    if (lllllllllllllIlIIlIllllIIlIllllI != null) {
                        this.outputChars(lllllllllllllIlIIlIllllIIlIllllI, lllllllllllllIlIIlIllllIIlIllllI.length);
                    }
                    else {
                        llllllllllllllIIlIIIlIlIllIllIll.append(lllllllllllllIlIIlIllllIIlIlllII);
                    }
                }
                return this;
            }
        };
    }
}
