package org.yaml.snakeyaml.scanner;

import java.util.*;

public final class Constant
{
    private /* synthetic */ String content;
    /* synthetic */ boolean noASCII;
    /* synthetic */ boolean[] contains;
    
    public boolean has(final int llllllllllllllIIlIllIlIIllIllllI) {
        return (llllllllllllllIIlIllIlIIllIllllI < 128) ? this.contains[llllllllllllllIIlIllIlIIllIllllI] : (this.noASCII && this.content.indexOf(llllllllllllllIIlIllIlIIllIllllI, 0) != -1);
    }
    
    public boolean hasNo(final int llllllllllllllIIlIllIlIIllIIIlll, final String llllllllllllllIIlIllIlIIllIIIllI) {
        return !this.has(llllllllllllllIIlIllIlIIllIIIlll, llllllllllllllIIlIllIlIIllIIIllI);
    }
    
    private Constant(final String llllllllllllllIIlIllIlIIlllIIlll) {
        this.contains = new boolean[128];
        this.noASCII = false;
        Arrays.fill(this.contains, false);
        final StringBuilder llllllllllllllIIlIllIlIIlllIlIIl = new StringBuilder();
        for (int llllllllllllllIIlIllIlIIlllIllII = 0; llllllllllllllIIlIllIlIIlllIllII < llllllllllllllIIlIllIlIIlllIIlll.length(); ++llllllllllllllIIlIllIlIIlllIllII) {
            final int llllllllllllllIIlIllIlIIlllIllIl = llllllllllllllIIlIllIlIIlllIIlll.codePointAt(llllllllllllllIIlIllIlIIlllIllII);
            if (llllllllllllllIIlIllIlIIlllIllIl < 128) {
                this.contains[llllllllllllllIIlIllIlIIlllIllIl] = true;
            }
            else {
                llllllllllllllIIlIllIlIIlllIlIIl.appendCodePoint(llllllllllllllIIlIllIlIIlllIllIl);
            }
        }
        if (llllllllllllllIIlIllIlIIlllIlIIl.length() > 0) {
            this.noASCII = true;
            this.content = String.valueOf(llllllllllllllIIlIllIlIIlllIlIIl);
        }
    }
    
    public boolean has(final int llllllllllllllIIlIllIlIIllIlIIll, final String llllllllllllllIIlIllIlIIllIIllll) {
        return this.has(llllllllllllllIIlIllIlIIllIlIIll) || llllllllllllllIIlIllIlIIllIIllll.indexOf(llllllllllllllIIlIllIlIIllIlIIll, 0) != -1;
    }
    
    static {
        NULL_OR_LINEBR_S = "\u0000\r\n\u0085\u2028\u2029";
        ALPHA_S = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-_";
        NULL_BL_LINEBR_S = " \u0000\r\n\u0085\u2028\u2029";
        NULL_BL_T_S = "\u0000 \t";
        URI_CHARS_S = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-_-;/?:@&=+$,_.!~*'()[]%";
        NULL_BL_T_LINEBR_S = "\t \u0000\r\n\u0085\u2028\u2029";
        LINEBR_S = "\n\u0085\u2028\u2029";
        FULL_LINEBR_S = "\r\n\u0085\u2028\u2029";
        LINEBR = new Constant("\n\u0085\u2028\u2029");
        FULL_LINEBR = new Constant("\r\n\u0085\u2028\u2029");
        NULL_OR_LINEBR = new Constant("\u0000\r\n\u0085\u2028\u2029");
        NULL_BL_LINEBR = new Constant(" \u0000\r\n\u0085\u2028\u2029");
        NULL_BL_T_LINEBR = new Constant("\t \u0000\r\n\u0085\u2028\u2029");
        NULL_BL_T = new Constant("\u0000 \t");
        URI_CHARS = new Constant("abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-_-;/?:@&=+$,_.!~*'()[]%");
        ALPHA = new Constant("abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-_");
    }
    
    public boolean hasNo(final int llllllllllllllIIlIllIlIIllIllIII) {
        return !this.has(llllllllllllllIIlIllIlIIllIllIII);
    }
}
