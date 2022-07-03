package net.optifine.entity.model.anim;

import java.util.*;
import java.io.*;

public class TokenParser
{
    public static Token[] parse(final String lllllllllllllIlIlllIIIlIlIlIIlII) throws ParseException, IOException {
        final Reader lllllllllllllIlIlllIIIlIlIlIllII = new StringReader(lllllllllllllIlIlllIIIlIlIlIIlII);
        final PushbackReader lllllllllllllIlIlllIIIlIlIlIlIll = new PushbackReader(lllllllllllllIlIlllIIIlIlIlIllII);
        final List<Token> lllllllllllllIlIlllIIIlIlIlIlIlI = new ArrayList<Token>();
        while (true) {
            final int lllllllllllllIlIlllIIIlIlIlIlIIl = lllllllllllllIlIlllIIIlIlIlIlIll.read();
            if (lllllllllllllIlIlllIIIlIlIlIlIIl < 0) {
                final Token[] lllllllllllllIlIlllIIIlIlIlIlIII = lllllllllllllIlIlllIIIlIlIlIlIlI.toArray(new Token[lllllllllllllIlIlllIIIlIlIlIlIlI.size()]);
                return lllllllllllllIlIlllIIIlIlIlIlIII;
            }
            final char lllllllllllllIlIlllIIIlIlIlIIlll = (char)lllllllllllllIlIlllIIIlIlIlIlIIl;
            if (Character.isWhitespace(lllllllllllllIlIlllIIIlIlIlIIlll)) {
                continue;
            }
            final EnumTokenType lllllllllllllIlIlllIIIlIlIlIIllI = EnumTokenType.getTypeByFirstChar(lllllllllllllIlIlllIIIlIlIlIIlll);
            if (lllllllllllllIlIlllIIIlIlIlIIllI == null) {
                throw new ParseException(String.valueOf(new StringBuilder("Invalid character: '").append(lllllllllllllIlIlllIIIlIlIlIIlll).append("', in: ").append(lllllllllllllIlIlllIIIlIlIlIIlII)));
            }
            final Token lllllllllllllIlIlllIIIlIlIlIIlIl = readToken(lllllllllllllIlIlllIIIlIlIlIIlll, lllllllllllllIlIlllIIIlIlIlIIllI, lllllllllllllIlIlllIIIlIlIlIlIll);
            lllllllllllllIlIlllIIIlIlIlIlIlI.add(lllllllllllllIlIlllIIIlIlIlIIlIl);
        }
    }
    
    private static Token readToken(final char lllllllllllllIlIlllIIIlIlIIlIIII, final EnumTokenType lllllllllllllIlIlllIIIlIlIIIllll, final PushbackReader lllllllllllllIlIlllIIIlIlIIlIlII) throws IOException {
        final StringBuffer lllllllllllllIlIlllIIIlIlIIlIIll = new StringBuffer();
        lllllllllllllIlIlllIIIlIlIIlIIll.append(lllllllllllllIlIlllIIIlIlIIlIIII);
        while (lllllllllllllIlIlllIIIlIlIIIllll.getMaxLen() <= 0 || lllllllllllllIlIlllIIIlIlIIlIIll.length() < lllllllllllllIlIlllIIIlIlIIIllll.getMaxLen()) {
            final int lllllllllllllIlIlllIIIlIlIIlIIlI = lllllllllllllIlIlllIIIlIlIIlIlII.read();
            if (lllllllllllllIlIlllIIIlIlIIlIIlI < 0) {
                break;
            }
            final char lllllllllllllIlIlllIIIlIlIIlIIIl = (char)lllllllllllllIlIlllIIIlIlIIlIIlI;
            if (!lllllllllllllIlIlllIIIlIlIIIllll.hasChar(lllllllllllllIlIlllIIIlIlIIlIIIl)) {
                lllllllllllllIlIlllIIIlIlIIlIlII.unread(lllllllllllllIlIlllIIIlIlIIlIIIl);
                break;
            }
            lllllllllllllIlIlllIIIlIlIIlIIll.append(lllllllllllllIlIlllIIIlIlIIlIIIl);
        }
        return new Token(lllllllllllllIlIlllIIIlIlIIIllll, lllllllllllllIlIlllIIIlIlIIlIIll.toString());
    }
}
