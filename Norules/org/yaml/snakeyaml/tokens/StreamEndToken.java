package org.yaml.snakeyaml.tokens;

import org.yaml.snakeyaml.error.*;

public final class StreamEndToken extends Token
{
    @Override
    public ID getTokenId() {
        return ID.StreamEnd;
    }
    
    public StreamEndToken(final Mark lllllllllllllllllIllllIIllIIIIIl, final Mark lllllllllllllllllIllllIIllIIIIll) {
        super(lllllllllllllllllIllllIIllIIIIIl, lllllllllllllllllIllllIIllIIIIll);
    }
}
