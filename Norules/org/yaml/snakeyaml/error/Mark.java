package org.yaml.snakeyaml.error;

import java.io.*;
import org.yaml.snakeyaml.scanner.*;

public final class Mark implements Serializable
{
    private /* synthetic */ int line;
    private /* synthetic */ int index;
    private /* synthetic */ int pointer;
    private /* synthetic */ int[] buffer;
    private /* synthetic */ String name;
    private /* synthetic */ int column;
    
    public int getColumn() {
        return this.column;
    }
    
    public String getName() {
        return this.name;
    }
    
    @Override
    public String toString() {
        final String lllllllllllllllllIllIlIIIIIllIII = this.get_snippet();
        final StringBuilder lllllllllllllllllIllIlIIIIIlIlll = new StringBuilder(" in ");
        lllllllllllllllllIllIlIIIIIlIlll.append(this.name);
        lllllllllllllllllIllIlIIIIIlIlll.append(", line ");
        lllllllllllllllllIllIlIIIIIlIlll.append(this.line + 1);
        lllllllllllllllllIllIlIIIIIlIlll.append(", column ");
        lllllllllllllllllIllIlIIIIIlIlll.append(this.column + 1);
        lllllllllllllllllIllIlIIIIIlIlll.append(":\n");
        lllllllllllllllllIllIlIIIIIlIlll.append(lllllllllllllllllIllIlIIIIIllIII);
        return String.valueOf(lllllllllllllllllIllIlIIIIIlIlll);
    }
    
    public int getLine() {
        return this.line;
    }
    
    public String get_snippet() {
        return this.get_snippet(4, 75);
    }
    
    public Mark(final String lllllllllllllllllIllIlIIIlIIlIIl, final int lllllllllllllllllIllIlIIIlIIlIII, final int lllllllllllllllllIllIlIIIlIIlllI, final int lllllllllllllllllIllIlIIIlIIIllI, final int[] lllllllllllllllllIllIlIIIlIIllII, final int lllllllllllllllllIllIlIIIlIIlIll) {
        this.name = lllllllllllllllllIllIlIIIlIIlIIl;
        this.index = lllllllllllllllllIllIlIIIlIIlIII;
        this.line = lllllllllllllllllIllIlIIIlIIlllI;
        this.column = lllllllllllllllllIllIlIIIlIIIllI;
        this.buffer = lllllllllllllllllIllIlIIIlIIllII;
        this.pointer = lllllllllllllllllIllIlIIIlIIlIll;
    }
    
    public int getPointer() {
        return this.pointer;
    }
    
    public int getIndex() {
        return this.index;
    }
    
    public Mark(final String lllllllllllllllllIllIlIIIlllIIll, final int lllllllllllllllllIllIlIIIllllIIl, final int lllllllllllllllllIllIlIIIlllIIIl, final int lllllllllllllllllIllIlIIIlllIlll, final char[] lllllllllllllllllIllIlIIIllIllll, final int lllllllllllllllllIllIlIIIllIlllI) {
        this(lllllllllllllllllIllIlIIIlllIIll, lllllllllllllllllIllIlIIIllllIIl, lllllllllllllllllIllIlIIIlllIIIl, lllllllllllllllllIllIlIIIlllIlll, toCodePoints(lllllllllllllllllIllIlIIIllIllll), lllllllllllllllllIllIlIIIllIlllI);
    }
    
    @Deprecated
    public Mark(final String lllllllllllllllllIllIlIIIllIIlIl, final int lllllllllllllllllIllIlIIIlIlllIl, final int lllllllllllllllllIllIlIIIlIlllII, final int lllllllllllllllllIllIlIIIllIIIlI, final String lllllllllllllllllIllIlIIIlIllIlI, final int lllllllllllllllllIllIlIIIllIIIII) {
        this(lllllllllllllllllIllIlIIIllIIlIl, lllllllllllllllllIllIlIIIlIlllIl, lllllllllllllllllIllIlIIIlIlllII, lllllllllllllllllIllIlIIIllIIIlI, lllllllllllllllllIllIlIIIlIllIlI.toCharArray(), lllllllllllllllllIllIlIIIllIIIII);
    }
    
    public String get_snippet(final int lllllllllllllllllIllIlIIIIlIlIII, final int lllllllllllllllllIllIlIIIIlIIlll) {
        final float lllllllllllllllllIllIlIIIIlIllll = lllllllllllllllllIllIlIIIIlIIlll / 2.0f - 1.0f;
        int lllllllllllllllllIllIlIIIIlIlllI = this.pointer;
        String lllllllllllllllllIllIlIIIIlIllIl = "";
        while (lllllllllllllllllIllIlIIIIlIlllI > 0 && !this.isLineBreak(this.buffer[lllllllllllllllllIllIlIIIIlIlllI - 1])) {
            --lllllllllllllllllIllIlIIIIlIlllI;
            if (this.pointer - lllllllllllllllllIllIlIIIIlIlllI > lllllllllllllllllIllIlIIIIlIllll) {
                lllllllllllllllllIllIlIIIIlIllIl = " ... ";
                lllllllllllllllllIllIlIIIIlIlllI += 5;
                break;
            }
        }
        String lllllllllllllllllIllIlIIIIlIllII = "";
        int lllllllllllllllllIllIlIIIIlIlIll = this.pointer;
        while (lllllllllllllllllIllIlIIIIlIlIll < this.buffer.length && !this.isLineBreak(this.buffer[lllllllllllllllllIllIlIIIIlIlIll])) {
            if (++lllllllllllllllllIllIlIIIIlIlIll - this.pointer > lllllllllllllllllIllIlIIIIlIllll) {
                lllllllllllllllllIllIlIIIIlIllII = " ... ";
                lllllllllllllllllIllIlIIIIlIlIll -= 5;
                break;
            }
        }
        final StringBuilder lllllllllllllllllIllIlIIIIlIlIlI = new StringBuilder();
        for (int lllllllllllllllllIllIlIIIIllIlIl = 0; lllllllllllllllllIllIlIIIIllIlIl < lllllllllllllllllIllIlIIIIlIlIII; ++lllllllllllllllllIllIlIIIIllIlIl) {
            lllllllllllllllllIllIlIIIIlIlIlI.append(" ");
        }
        lllllllllllllllllIllIlIIIIlIlIlI.append(lllllllllllllllllIllIlIIIIlIllIl);
        for (int lllllllllllllllllIllIlIIIIllIlII = lllllllllllllllllIllIlIIIIlIlllI; lllllllllllllllllIllIlIIIIllIlII < lllllllllllllllllIllIlIIIIlIlIll; ++lllllllllllllllllIllIlIIIIllIlII) {
            lllllllllllllllllIllIlIIIIlIlIlI.appendCodePoint(this.buffer[lllllllllllllllllIllIlIIIIllIlII]);
        }
        lllllllllllllllllIllIlIIIIlIlIlI.append(lllllllllllllllllIllIlIIIIlIllII);
        lllllllllllllllllIllIlIIIIlIlIlI.append("\n");
        for (int lllllllllllllllllIllIlIIIIllIIll = 0; lllllllllllllllllIllIlIIIIllIIll < lllllllllllllllllIllIlIIIIlIlIII + this.pointer - lllllllllllllllllIllIlIIIIlIlllI + lllllllllllllllllIllIlIIIIlIllIl.length(); ++lllllllllllllllllIllIlIIIIllIIll) {
            lllllllllllllllllIllIlIIIIlIlIlI.append(" ");
        }
        lllllllllllllllllIllIlIIIIlIlIlI.append("^");
        return String.valueOf(lllllllllllllllllIllIlIIIIlIlIlI);
    }
    
    private static int[] toCodePoints(final char[] lllllllllllllllllIllIlIIlIIIlIIl) {
        final int[] lllllllllllllllllIllIlIIlIIIlIII = new int[Character.codePointCount(lllllllllllllllllIllIlIIlIIIlIIl, 0, lllllllllllllllllIllIlIIlIIIlIIl.length)];
        int lllllllllllllllllIllIlIIlIIIllII;
        for (int lllllllllllllllllIllIlIIlIIIlIll = 0, lllllllllllllllllIllIlIIlIIIlIlI = 0; lllllllllllllllllIllIlIIlIIIlIll < lllllllllllllllllIllIlIIlIIIlIIl.length; lllllllllllllllllIllIlIIlIIIlIll += Character.charCount(lllllllllllllllllIllIlIIlIIIllII), ++lllllllllllllllllIllIlIIlIIIlIlI) {
            lllllllllllllllllIllIlIIlIIIllII = Character.codePointAt(lllllllllllllllllIllIlIIlIIIlIIl, lllllllllllllllllIllIlIIlIIIlIll);
            lllllllllllllllllIllIlIIlIIIlIII[lllllllllllllllllIllIlIIlIIIlIlI] = lllllllllllllllllIllIlIIlIIIllII;
        }
        return lllllllllllllllllIllIlIIlIIIlIII;
    }
    
    private boolean isLineBreak(final int lllllllllllllllllIllIlIIIlIIIIII) {
        return Constant.NULL_OR_LINEBR.has(lllllllllllllllllIllIlIIIlIIIIII);
    }
    
    public int[] getBuffer() {
        return this.buffer;
    }
}
