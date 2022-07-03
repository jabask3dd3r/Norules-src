package org.yaml.snakeyaml.tokens;

import org.yaml.snakeyaml.error.*;

public final class DocumentEndToken extends Token
{
    public DocumentEndToken(final Mark lllllllllllllIllIIlllIIIIlIIIlII, final Mark lllllllllllllIllIIlllIIIIlIIIllI) {
        super(lllllllllllllIllIIlllIIIIlIIIlII, lllllllllllllIllIIlllIIIIlIIIllI);
    }
    
    @Override
    public ID getTokenId() {
        return ID.DocumentEnd;
    }
}
