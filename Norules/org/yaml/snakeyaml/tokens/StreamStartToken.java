package org.yaml.snakeyaml.tokens;

import org.yaml.snakeyaml.error.*;

public final class StreamStartToken extends Token
{
    public StreamStartToken(final Mark lllllllllllllIIIlllIlIlIlllllIlI, final Mark lllllllllllllIIIlllIlIlIllllIllI) {
        super(lllllllllllllIIIlllIlIlIlllllIlI, lllllllllllllIIIlllIlIlIllllIllI);
    }
    
    @Override
    public ID getTokenId() {
        return ID.StreamStart;
    }
}
