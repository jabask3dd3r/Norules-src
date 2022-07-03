package org.yaml.snakeyaml.tokens;

import org.yaml.snakeyaml.error.*;

public final class KeyToken extends Token
{
    public KeyToken(final Mark lllllllllllllIlIIIIIllIlIlIlIIll, final Mark lllllllllllllIlIIIIIllIlIlIlIIlI) {
        super(lllllllllllllIlIIIIIllIlIlIlIIll, lllllllllllllIlIIIIIllIlIlIlIIlI);
    }
    
    @Override
    public ID getTokenId() {
        return ID.Key;
    }
}
