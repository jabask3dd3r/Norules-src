package org.yaml.snakeyaml.tokens;

import org.yaml.snakeyaml.error.*;

public class WhitespaceToken extends Token
{
    public WhitespaceToken(final Mark lllllllllllllIlllIIIIIIIlIlIllII, final Mark lllllllllllllIlllIIIIIIIlIlIlIII) {
        super(lllllllllllllIlllIIIIIIIlIlIllII, lllllllllllllIlllIIIIIIIlIlIlIII);
    }
    
    @Override
    public ID getTokenId() {
        return ID.Whitespace;
    }
}
