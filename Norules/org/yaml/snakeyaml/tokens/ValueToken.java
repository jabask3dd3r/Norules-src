package org.yaml.snakeyaml.tokens;

import org.yaml.snakeyaml.error.*;

public final class ValueToken extends Token
{
    public ValueToken(final Mark llllllllllllIllllllIlIIIIIIllIIl, final Mark llllllllllllIllllllIlIIIIIIlIlIl) {
        super(llllllllllllIllllllIlIIIIIIllIIl, llllllllllllIllllllIlIIIIIIlIlIl);
    }
    
    @Override
    public ID getTokenId() {
        return ID.Value;
    }
}
