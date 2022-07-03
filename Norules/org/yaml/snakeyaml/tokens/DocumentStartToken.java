package org.yaml.snakeyaml.tokens;

import org.yaml.snakeyaml.error.*;

public final class DocumentStartToken extends Token
{
    public DocumentStartToken(final Mark llllllllllllllIlIlllllIllllllIlI, final Mark llllllllllllllIlIlllllIlllllIllI) {
        super(llllllllllllllIlIlllllIllllllIlI, llllllllllllllIlIlllllIlllllIllI);
    }
    
    @Override
    public ID getTokenId() {
        return ID.DocumentStart;
    }
}
