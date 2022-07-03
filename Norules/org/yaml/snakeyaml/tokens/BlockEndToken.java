package org.yaml.snakeyaml.tokens;

import org.yaml.snakeyaml.error.*;

public final class BlockEndToken extends Token
{
    @Override
    public ID getTokenId() {
        return ID.BlockEnd;
    }
    
    public BlockEndToken(final Mark lllllllllllllllIIlIllIllIIIIlllI, final Mark lllllllllllllllIIlIllIllIIIIllII) {
        super(lllllllllllllllIIlIllIllIIIIlllI, lllllllllllllllIIlIllIllIIIIllII);
    }
}
