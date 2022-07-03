package org.yaml.snakeyaml.tokens;

import org.yaml.snakeyaml.error.*;

public final class BlockEntryToken extends Token
{
    @Override
    public ID getTokenId() {
        return ID.BlockEntry;
    }
    
    public BlockEntryToken(final Mark lllllllllllllIIlIIIIlIIlIllllIlI, final Mark lllllllllllllIIlIIIIlIIlIlllIllI) {
        super(lllllllllllllIIlIIIIlIIlIllllIlI, lllllllllllllIIlIIIIlIIlIlllIllI);
    }
}
